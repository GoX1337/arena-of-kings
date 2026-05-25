/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.loader;

import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.ModelLoader;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.g3d.model.data.ModelAnimation;
import com.badlogic.gdx.graphics.g3d.model.data.ModelData;
import com.badlogic.gdx.graphics.g3d.model.data.ModelMaterial;
import com.badlogic.gdx.graphics.g3d.model.data.ModelMesh;
import com.badlogic.gdx.graphics.g3d.model.data.ModelMeshPart;
import com.badlogic.gdx.graphics.g3d.model.data.ModelNode;
import com.badlogic.gdx.graphics.g3d.model.data.ModelNodeAnimation;
import com.badlogic.gdx.graphics.g3d.model.data.ModelNodeKeyframe;
import com.badlogic.gdx.graphics.g3d.model.data.ModelNodePart;
import com.badlogic.gdx.graphics.g3d.model.data.ModelTexture;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ArrayMap;
import com.badlogic.gdx.utils.BaseJsonReader;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.JsonValue;

public class G3dModelLoader
extends ModelLoader<ModelLoader.ModelParameters> {
    public static final short VERSION_HI = 0;
    public static final short VERSION_LO = 1;
    protected final BaseJsonReader reader;
    protected final Quaternion tempQ = new Quaternion();

    public G3dModelLoader(BaseJsonReader baseJsonReader) {
        this(baseJsonReader, null);
    }

    public G3dModelLoader(BaseJsonReader baseJsonReader, FileHandleResolver fileHandleResolver) {
        super(fileHandleResolver);
        this.reader = baseJsonReader;
    }

    @Override
    public ModelData loadModelData(FileHandle fileHandle, ModelLoader.ModelParameters modelParameters) {
        return this.parseModel(fileHandle);
    }

    public ModelData parseModel(FileHandle fileHandle) {
        JsonValue jsonValue = this.reader.parse(fileHandle);
        ModelData modelData = new ModelData();
        JsonValue jsonValue2 = jsonValue.require("version");
        modelData.version[0] = jsonValue2.getShort(0);
        modelData.version[1] = jsonValue2.getShort(1);
        if (modelData.version[0] != 0 || modelData.version[1] != 1) {
            throw new GdxRuntimeException("Model version not supported");
        }
        modelData.id = jsonValue.getString("id", "");
        this.parseMeshes(modelData, jsonValue);
        this.parseMaterials(modelData, jsonValue, fileHandle.parent().path());
        this.parseNodes(modelData, jsonValue);
        this.parseAnimations(modelData, jsonValue);
        return modelData;
    }

    protected void parseMeshes(ModelData modelData, JsonValue jsonValue) {
        JsonValue jsonValue2 = jsonValue.get("meshes");
        if (jsonValue2 != null) {
            modelData.meshes.ensureCapacity(jsonValue2.size);
            JsonValue jsonValue3 = jsonValue2.child;
            while (jsonValue3 != null) {
                String string;
                ModelMesh modelMesh = new ModelMesh();
                modelMesh.id = string = jsonValue3.getString("id", "");
                JsonValue jsonValue4 = jsonValue3.require("attributes");
                modelMesh.attributes = this.parseAttributes(jsonValue4);
                modelMesh.vertices = jsonValue3.require("vertices").asFloatArray();
                JsonValue jsonValue5 = jsonValue3.require("parts");
                Array<ModelMeshPart> array = new Array<ModelMeshPart>();
                JsonValue jsonValue6 = jsonValue5.child;
                while (jsonValue6 != null) {
                    ModelMeshPart modelMeshPart = new ModelMeshPart();
                    String string2 = jsonValue6.getString("id", null);
                    if (string2 == null) {
                        throw new GdxRuntimeException("Not id given for mesh part");
                    }
                    for (ModelMeshPart modelMeshPart2 : array) {
                        if (!modelMeshPart2.id.equals(string2)) continue;
                        throw new GdxRuntimeException("Mesh part with id '" + string2 + "' already in defined");
                    }
                    modelMeshPart.id = string2;
                    String string3 = jsonValue6.getString("type", null);
                    if (string3 == null) {
                        throw new GdxRuntimeException("No primitive type given for mesh part '" + string2 + "'");
                    }
                    modelMeshPart.primitiveType = this.parseType(string3);
                    modelMeshPart.indices = jsonValue6.require("indices").asShortArray();
                    array.add(modelMeshPart);
                    jsonValue6 = jsonValue6.next;
                }
                modelMesh.parts = array.toArray(ModelMeshPart.class);
                modelData.meshes.add(modelMesh);
                jsonValue3 = jsonValue3.next;
            }
        }
    }

    protected int parseType(String string) {
        if (string.equals("TRIANGLES")) {
            return 4;
        }
        if (string.equals("LINES")) {
            return 1;
        }
        if (string.equals("POINTS")) {
            return 0;
        }
        if (string.equals("TRIANGLE_STRIP")) {
            return 5;
        }
        if (string.equals("LINE_STRIP")) {
            return 3;
        }
        throw new GdxRuntimeException("Unknown primitive type '" + string + "', should be one of triangle, trianglestrip, line, linestrip, lineloop or point");
    }

    protected VertexAttribute[] parseAttributes(JsonValue jsonValue) {
        Array<VertexAttribute> array = new Array<VertexAttribute>();
        int n2 = 0;
        int n3 = 0;
        JsonValue jsonValue2 = jsonValue.child;
        while (jsonValue2 != null) {
            String string = jsonValue2.asString();
            String string2 = string;
            if (string2.equals("POSITION")) {
                array.add(VertexAttribute.Position());
            } else if (string2.equals("NORMAL")) {
                array.add(VertexAttribute.Normal());
            } else if (string2.equals("COLOR")) {
                array.add(VertexAttribute.ColorUnpacked());
            } else if (string2.equals("COLORPACKED")) {
                array.add(VertexAttribute.ColorPacked());
            } else if (string2.equals("TANGENT")) {
                array.add(VertexAttribute.Tangent());
            } else if (string2.equals("BINORMAL")) {
                array.add(VertexAttribute.Binormal());
            } else if (string2.startsWith("TEXCOORD")) {
                array.add(VertexAttribute.TexCoords(n2++));
            } else if (string2.startsWith("BLENDWEIGHT")) {
                array.add(VertexAttribute.BoneWeight(n3++));
            } else {
                throw new GdxRuntimeException("Unknown vertex attribute '" + string2 + "', should be one of position, normal, uv, tangent or binormal");
            }
            jsonValue2 = jsonValue2.next;
        }
        return array.toArray(VertexAttribute.class);
    }

    protected void parseMaterials(ModelData modelData, JsonValue jsonValue, String string) {
        JsonValue jsonValue2 = jsonValue.get("materials");
        if (jsonValue2 != null) {
            modelData.materials.ensureCapacity(jsonValue2.size);
            JsonValue jsonValue3 = jsonValue2.child;
            while (jsonValue3 != null) {
                JsonValue jsonValue4;
                JsonValue jsonValue5;
                JsonValue jsonValue6;
                JsonValue jsonValue7;
                ModelMaterial modelMaterial = new ModelMaterial();
                String string2 = jsonValue3.getString("id", null);
                if (string2 == null) {
                    throw new GdxRuntimeException("Material needs an id.");
                }
                modelMaterial.id = string2;
                JsonValue jsonValue8 = jsonValue3.get("diffuse");
                if (jsonValue8 != null) {
                    modelMaterial.diffuse = this.parseColor(jsonValue8);
                }
                if ((jsonValue7 = jsonValue3.get("ambient")) != null) {
                    modelMaterial.ambient = this.parseColor(jsonValue7);
                }
                if ((jsonValue6 = jsonValue3.get("emissive")) != null) {
                    modelMaterial.emissive = this.parseColor(jsonValue6);
                }
                if ((jsonValue5 = jsonValue3.get("specular")) != null) {
                    modelMaterial.specular = this.parseColor(jsonValue5);
                }
                if ((jsonValue4 = jsonValue3.get("reflection")) != null) {
                    modelMaterial.reflection = this.parseColor(jsonValue4);
                }
                modelMaterial.shininess = jsonValue3.getFloat("shininess", 0.0f);
                modelMaterial.opacity = jsonValue3.getFloat("opacity", 1.0f);
                JsonValue jsonValue9 = jsonValue3.get("textures");
                if (jsonValue9 != null) {
                    JsonValue jsonValue10 = jsonValue9.child;
                    while (jsonValue10 != null) {
                        ModelTexture modelTexture = new ModelTexture();
                        String string3 = jsonValue10.getString("id", null);
                        if (string3 == null) {
                            throw new GdxRuntimeException("Texture has no id.");
                        }
                        modelTexture.id = string3;
                        String string4 = jsonValue10.getString("filename", null);
                        if (string4 == null) {
                            throw new GdxRuntimeException("Texture needs filename.");
                        }
                        modelTexture.fileName = string + (string.length() == 0 || string.endsWith("/") ? "" : "/") + string4;
                        modelTexture.uvTranslation = this.readVector2(jsonValue10.get("uvTranslation"), 0.0f, 0.0f);
                        modelTexture.uvScaling = this.readVector2(jsonValue10.get("uvScaling"), 1.0f, 1.0f);
                        String string5 = jsonValue10.getString("type", null);
                        if (string5 == null) {
                            throw new GdxRuntimeException("Texture needs type.");
                        }
                        modelTexture.usage = this.parseTextureUsage(string5);
                        if (modelMaterial.textures == null) {
                            modelMaterial.textures = new Array();
                        }
                        modelMaterial.textures.add(modelTexture);
                        jsonValue10 = jsonValue10.next;
                    }
                }
                modelData.materials.add(modelMaterial);
                jsonValue3 = jsonValue3.next;
            }
        }
    }

    protected int parseTextureUsage(String string) {
        if (string.equalsIgnoreCase("AMBIENT")) {
            return 4;
        }
        if (string.equalsIgnoreCase("BUMP")) {
            return 8;
        }
        if (string.equalsIgnoreCase("DIFFUSE")) {
            return 2;
        }
        if (string.equalsIgnoreCase("EMISSIVE")) {
            return 3;
        }
        if (string.equalsIgnoreCase("NONE")) {
            return 1;
        }
        if (string.equalsIgnoreCase("NORMAL")) {
            return 7;
        }
        if (string.equalsIgnoreCase("REFLECTION")) {
            return 10;
        }
        if (string.equalsIgnoreCase("SHININESS")) {
            return 6;
        }
        if (string.equalsIgnoreCase("SPECULAR")) {
            return 5;
        }
        if (string.equalsIgnoreCase("TRANSPARENCY")) {
            return 9;
        }
        return 0;
    }

    protected Color parseColor(JsonValue jsonValue) {
        if (jsonValue.size >= 3) {
            return new Color(jsonValue.getFloat(0), jsonValue.getFloat(1), jsonValue.getFloat(2), 1.0f);
        }
        throw new GdxRuntimeException("Expected Color values <> than three.");
    }

    protected Vector2 readVector2(JsonValue jsonValue, float f2, float f3) {
        if (jsonValue == null) {
            return new Vector2(f2, f3);
        }
        if (jsonValue.size == 2) {
            return new Vector2(jsonValue.getFloat(0), jsonValue.getFloat(1));
        }
        throw new GdxRuntimeException("Expected Vector2 values <> than two.");
    }

    protected Array<ModelNode> parseNodes(ModelData modelData, JsonValue jsonValue) {
        JsonValue jsonValue2 = jsonValue.get("nodes");
        if (jsonValue2 != null) {
            modelData.nodes.ensureCapacity(jsonValue2.size);
            JsonValue jsonValue3 = jsonValue2.child;
            while (jsonValue3 != null) {
                modelData.nodes.add(this.parseNodesRecursively(jsonValue3));
                jsonValue3 = jsonValue3.next;
            }
        }
        return modelData.nodes;
    }

    protected ModelNode parseNodesRecursively(JsonValue jsonValue) {
        JsonValue jsonValue2;
        Object object;
        JsonValue jsonValue3;
        ModelNode modelNode = new ModelNode();
        String string = jsonValue.getString("id", null);
        if (string == null) {
            throw new GdxRuntimeException("Node id missing.");
        }
        modelNode.id = string;
        JsonValue jsonValue4 = jsonValue.get("translation");
        if (jsonValue4 != null && jsonValue4.size != 3) {
            throw new GdxRuntimeException("Node translation incomplete");
        }
        modelNode.translation = jsonValue4 == null ? null : new Vector3(jsonValue4.getFloat(0), jsonValue4.getFloat(1), jsonValue4.getFloat(2));
        JsonValue jsonValue5 = jsonValue.get("rotation");
        if (jsonValue5 != null && jsonValue5.size != 4) {
            throw new GdxRuntimeException("Node rotation incomplete");
        }
        modelNode.rotation = jsonValue5 == null ? null : new Quaternion(jsonValue5.getFloat(0), jsonValue5.getFloat(1), jsonValue5.getFloat(2), jsonValue5.getFloat(3));
        JsonValue jsonValue6 = jsonValue.get("scale");
        if (jsonValue6 != null && jsonValue6.size != 3) {
            throw new GdxRuntimeException("Node scale incomplete");
        }
        modelNode.scale = jsonValue6 == null ? null : new Vector3(jsonValue6.getFloat(0), jsonValue6.getFloat(1), jsonValue6.getFloat(2));
        String string2 = jsonValue.getString("mesh", null);
        if (string2 != null) {
            modelNode.meshId = string2;
        }
        if ((jsonValue3 = jsonValue.get("parts")) != null) {
            modelNode.parts = new ModelNodePart[jsonValue3.size];
            int n2 = 0;
            JsonValue jsonValue7 = jsonValue3.child;
            while (jsonValue7 != null) {
                object = new ModelNodePart();
                String string3 = jsonValue7.getString("meshpartid", null);
                String string4 = jsonValue7.getString("materialid", null);
                if (string3 == null || string4 == null) {
                    throw new GdxRuntimeException("Node " + string + " part is missing meshPartId or materialId");
                }
                ((ModelNodePart)object).materialId = string4;
                ((ModelNodePart)object).meshPartId = string3;
                JsonValue jsonValue8 = jsonValue7.get("bones");
                if (jsonValue8 != null) {
                    ((ModelNodePart)object).bones = new ArrayMap(true, jsonValue8.size, String.class, Matrix4.class);
                    int n3 = 0;
                    JsonValue jsonValue9 = jsonValue8.child;
                    while (jsonValue9 != null) {
                        String string5 = jsonValue9.getString("node", null);
                        if (string5 == null) {
                            throw new GdxRuntimeException("Bone node ID missing");
                        }
                        Matrix4 matrix4 = new Matrix4();
                        JsonValue jsonValue10 = jsonValue9.get("translation");
                        if (jsonValue10 != null && jsonValue10.size >= 3) {
                            matrix4.translate(jsonValue10.getFloat(0), jsonValue10.getFloat(1), jsonValue10.getFloat(2));
                        }
                        if ((jsonValue10 = jsonValue9.get("rotation")) != null && jsonValue10.size >= 4) {
                            matrix4.rotate(this.tempQ.set(jsonValue10.getFloat(0), jsonValue10.getFloat(1), jsonValue10.getFloat(2), jsonValue10.getFloat(3)));
                        }
                        if ((jsonValue10 = jsonValue9.get("scale")) != null && jsonValue10.size >= 3) {
                            matrix4.scale(jsonValue10.getFloat(0), jsonValue10.getFloat(1), jsonValue10.getFloat(2));
                        }
                        ((ModelNodePart)object).bones.put(string5, matrix4);
                        jsonValue9 = jsonValue9.next;
                        ++n3;
                    }
                }
                modelNode.parts[n2] = object;
                jsonValue7 = jsonValue7.next;
                ++n2;
            }
        }
        if ((jsonValue2 = jsonValue.get("children")) != null) {
            modelNode.children = new ModelNode[jsonValue2.size];
            int n4 = 0;
            object = jsonValue2.child;
            while (object != null) {
                modelNode.children[n4] = this.parseNodesRecursively((JsonValue)object);
                object = ((JsonValue)object).next;
                ++n4;
            }
        }
        return modelNode;
    }

    protected void parseAnimations(ModelData modelData, JsonValue jsonValue) {
        JsonValue jsonValue2 = jsonValue.get("animations");
        if (jsonValue2 == null) {
            return;
        }
        modelData.animations.ensureCapacity(jsonValue2.size);
        JsonValue jsonValue3 = jsonValue2.child;
        while (jsonValue3 != null) {
            JsonValue jsonValue4 = jsonValue3.get("bones");
            if (jsonValue4 != null) {
                ModelAnimation modelAnimation = new ModelAnimation();
                modelData.animations.add(modelAnimation);
                modelAnimation.nodeAnimations.ensureCapacity(jsonValue4.size);
                modelAnimation.id = jsonValue3.getString("id");
                JsonValue jsonValue5 = jsonValue4.child;
                while (jsonValue5 != null) {
                    Object object;
                    Object object2;
                    Object object3;
                    Object object4;
                    JsonValue jsonValue6;
                    ModelNodeAnimation modelNodeAnimation = new ModelNodeAnimation();
                    modelAnimation.nodeAnimations.add(modelNodeAnimation);
                    modelNodeAnimation.nodeId = jsonValue5.getString("boneId");
                    JsonValue jsonValue7 = jsonValue5.get("keyframes");
                    if (jsonValue7 != null && jsonValue7.isArray()) {
                        jsonValue6 = jsonValue7.child;
                        while (jsonValue6 != null) {
                            float f2 = jsonValue6.getFloat("keytime", 0.0f) / 1000.0f;
                            object4 = jsonValue6.get("translation");
                            if (object4 != null && ((JsonValue)object4).size == 3) {
                                if (modelNodeAnimation.translation == null) {
                                    modelNodeAnimation.translation = new Array();
                                }
                                object3 = new ModelNodeKeyframe();
                                ((ModelNodeKeyframe)object3).keytime = f2;
                                ((ModelNodeKeyframe)object3).value = new Vector3(((JsonValue)object4).getFloat(0), ((JsonValue)object4).getFloat(1), ((JsonValue)object4).getFloat(2));
                                modelNodeAnimation.translation.add((ModelNodeKeyframe<Vector3>)object3);
                            }
                            if ((object3 = jsonValue6.get("rotation")) != null && ((JsonValue)object3).size == 4) {
                                if (modelNodeAnimation.rotation == null) {
                                    modelNodeAnimation.rotation = new Array();
                                }
                                object2 = new ModelNodeKeyframe();
                                ((ModelNodeKeyframe)object2).keytime = f2;
                                ((ModelNodeKeyframe)object2).value = new Quaternion(((JsonValue)object3).getFloat(0), ((JsonValue)object3).getFloat(1), ((JsonValue)object3).getFloat(2), ((JsonValue)object3).getFloat(3));
                                modelNodeAnimation.rotation.add((ModelNodeKeyframe<Quaternion>)object2);
                            }
                            if ((object2 = jsonValue6.get("scale")) != null && ((JsonValue)object2).size == 3) {
                                if (modelNodeAnimation.scaling == null) {
                                    modelNodeAnimation.scaling = new Array();
                                }
                                object = new ModelNodeKeyframe();
                                ((ModelNodeKeyframe)object).keytime = f2;
                                ((ModelNodeKeyframe)object).value = new Vector3(((JsonValue)object2).getFloat(0), ((JsonValue)object2).getFloat(1), ((JsonValue)object2).getFloat(2));
                                modelNodeAnimation.scaling.add((ModelNodeKeyframe<Vector3>)object);
                            }
                            jsonValue6 = jsonValue6.next;
                        }
                    } else {
                        JsonValue jsonValue8;
                        jsonValue6 = jsonValue5.get("translation");
                        if (jsonValue6 != null && jsonValue6.isArray()) {
                            modelNodeAnimation.translation = new Array();
                            modelNodeAnimation.translation.ensureCapacity(jsonValue6.size);
                            jsonValue8 = jsonValue6.child;
                            while (jsonValue8 != null) {
                                object4 = new ModelNodeKeyframe();
                                modelNodeAnimation.translation.add((ModelNodeKeyframe<Vector3>)object4);
                                ((ModelNodeKeyframe)object4).keytime = jsonValue8.getFloat("keytime", 0.0f) / 1000.0f;
                                object3 = jsonValue8.get("value");
                                if (object3 != null && ((JsonValue)object3).size >= 3) {
                                    ((ModelNodeKeyframe)object4).value = new Vector3(((JsonValue)object3).getFloat(0), ((JsonValue)object3).getFloat(1), ((JsonValue)object3).getFloat(2));
                                }
                                jsonValue8 = jsonValue8.next;
                            }
                        }
                        if ((jsonValue8 = jsonValue5.get("rotation")) != null && jsonValue8.isArray()) {
                            modelNodeAnimation.rotation = new Array();
                            modelNodeAnimation.rotation.ensureCapacity(jsonValue8.size);
                            object4 = jsonValue8.child;
                            while (object4 != null) {
                                object3 = new ModelNodeKeyframe();
                                modelNodeAnimation.rotation.add((ModelNodeKeyframe<Quaternion>)object3);
                                ((ModelNodeKeyframe)object3).keytime = ((JsonValue)object4).getFloat("keytime", 0.0f) / 1000.0f;
                                object2 = ((JsonValue)object4).get("value");
                                if (object2 != null && ((JsonValue)object2).size >= 4) {
                                    ((ModelNodeKeyframe)object3).value = new Quaternion(((JsonValue)object2).getFloat(0), ((JsonValue)object2).getFloat(1), ((JsonValue)object2).getFloat(2), ((JsonValue)object2).getFloat(3));
                                }
                                object4 = ((JsonValue)object4).next;
                            }
                        }
                        if ((object4 = jsonValue5.get("scaling")) != null && ((JsonValue)object4).isArray()) {
                            modelNodeAnimation.scaling = new Array();
                            modelNodeAnimation.scaling.ensureCapacity(((JsonValue)object4).size);
                            object3 = ((JsonValue)object4).child;
                            while (object3 != null) {
                                object2 = new ModelNodeKeyframe();
                                modelNodeAnimation.scaling.add((ModelNodeKeyframe<Vector3>)object2);
                                ((ModelNodeKeyframe)object2).keytime = ((JsonValue)object3).getFloat("keytime", 0.0f) / 1000.0f;
                                object = ((JsonValue)object3).get("value");
                                if (object != null && ((JsonValue)object).size >= 3) {
                                    ((ModelNodeKeyframe)object2).value = new Vector3(((JsonValue)object).getFloat(0), ((JsonValue)object).getFloat(1), ((JsonValue)object).getFloat(2));
                                }
                                object3 = ((JsonValue)object3).next;
                            }
                        }
                    }
                    jsonValue5 = jsonValue5.next;
                }
            }
            jsonValue3 = jsonValue3.next;
        }
    }
}

