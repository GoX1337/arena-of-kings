/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d;

import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.Attribute;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.attributes.BlendingAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.FloatAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.TextureAttribute;
import com.badlogic.gdx.graphics.g3d.model.Animation;
import com.badlogic.gdx.graphics.g3d.model.MeshPart;
import com.badlogic.gdx.graphics.g3d.model.Node;
import com.badlogic.gdx.graphics.g3d.model.NodeAnimation;
import com.badlogic.gdx.graphics.g3d.model.NodeKeyframe;
import com.badlogic.gdx.graphics.g3d.model.NodePart;
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
import com.badlogic.gdx.graphics.g3d.utils.TextureDescriptor;
import com.badlogic.gdx.graphics.g3d.utils.TextureProvider;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.BoundingBox;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ArrayMap;
import com.badlogic.gdx.utils.BufferUtils;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.ObjectMap;
import java.nio.Buffer;

public class Model
implements Disposable {
    public final Array<Material> materials = new Array();
    public final Array<Node> nodes = new Array();
    public final Array<Animation> animations = new Array();
    public final Array<Mesh> meshes = new Array();
    public final Array<MeshPart> meshParts = new Array();
    protected final Array<Disposable> disposables = new Array();
    private ObjectMap<NodePart, ArrayMap<String, Matrix4>> nodePartBones = new ObjectMap();

    public Model() {
    }

    public Model(ModelData modelData) {
        this(modelData, new TextureProvider.FileTextureProvider());
    }

    public Model(ModelData modelData, TextureProvider textureProvider) {
        this.load(modelData, textureProvider);
    }

    protected void load(ModelData modelData, TextureProvider textureProvider) {
        this.loadMeshes(modelData.meshes);
        this.loadMaterials(modelData.materials, textureProvider);
        this.loadNodes(modelData.nodes);
        this.loadAnimations(modelData.animations);
        this.calculateTransforms();
    }

    protected void loadAnimations(Iterable<ModelAnimation> iterable) {
        for (ModelAnimation modelAnimation : iterable) {
            Animation animation = new Animation();
            animation.id = modelAnimation.id;
            for (ModelNodeAnimation modelNodeAnimation : modelAnimation.nodeAnimations) {
                Node node = this.getNode(modelNodeAnimation.nodeId);
                if (node == null) continue;
                NodeAnimation nodeAnimation = new NodeAnimation();
                nodeAnimation.node = node;
                if (modelNodeAnimation.translation != null) {
                    nodeAnimation.translation = new Array();
                    nodeAnimation.translation.ensureCapacity(modelNodeAnimation.translation.size);
                    for (ModelNodeKeyframe modelNodeKeyframe : modelNodeAnimation.translation) {
                        if (modelNodeKeyframe.keytime > animation.duration) {
                            animation.duration = modelNodeKeyframe.keytime;
                        }
                        nodeAnimation.translation.add(new NodeKeyframe<Vector3>(modelNodeKeyframe.keytime, new Vector3(modelNodeKeyframe.value == null ? node.translation : (Vector3)modelNodeKeyframe.value)));
                    }
                }
                if (modelNodeAnimation.rotation != null) {
                    nodeAnimation.rotation = new Array();
                    nodeAnimation.rotation.ensureCapacity(modelNodeAnimation.rotation.size);
                    for (ModelNodeKeyframe modelNodeKeyframe : modelNodeAnimation.rotation) {
                        if (modelNodeKeyframe.keytime > animation.duration) {
                            animation.duration = modelNodeKeyframe.keytime;
                        }
                        nodeAnimation.rotation.add(new NodeKeyframe<Quaternion>(modelNodeKeyframe.keytime, new Quaternion(modelNodeKeyframe.value == null ? node.rotation : (Quaternion)modelNodeKeyframe.value)));
                    }
                }
                if (modelNodeAnimation.scaling != null) {
                    nodeAnimation.scaling = new Array();
                    nodeAnimation.scaling.ensureCapacity(modelNodeAnimation.scaling.size);
                    for (ModelNodeKeyframe modelNodeKeyframe : modelNodeAnimation.scaling) {
                        if (modelNodeKeyframe.keytime > animation.duration) {
                            animation.duration = modelNodeKeyframe.keytime;
                        }
                        nodeAnimation.scaling.add(new NodeKeyframe<Vector3>(modelNodeKeyframe.keytime, new Vector3(modelNodeKeyframe.value == null ? node.scale : (Vector3)modelNodeKeyframe.value)));
                    }
                }
                if (!(nodeAnimation.translation != null && nodeAnimation.translation.size > 0 || nodeAnimation.rotation != null && nodeAnimation.rotation.size > 0) && (nodeAnimation.scaling == null || nodeAnimation.scaling.size <= 0)) continue;
                animation.nodeAnimations.add(nodeAnimation);
            }
            if (animation.nodeAnimations.size <= 0) continue;
            this.animations.add(animation);
        }
    }

    protected void loadNodes(Iterable<ModelNode> iterable) {
        this.nodePartBones.clear();
        for (ModelNode object : iterable) {
            this.nodes.add(this.loadNode(object));
        }
        for (ObjectMap.Entry entry : this.nodePartBones.entries()) {
            if (((NodePart)entry.key).invBoneBindTransforms == null) {
                ((NodePart)entry.key).invBoneBindTransforms = new ArrayMap(Node.class, Matrix4.class);
            }
            ((NodePart)entry.key).invBoneBindTransforms.clear();
            for (ObjectMap.Entry entry2 : ((ArrayMap)entry.value).entries()) {
                ((NodePart)entry.key).invBoneBindTransforms.put(this.getNode((String)entry2.key), new Matrix4((Matrix4)entry2.value).inv());
            }
        }
    }

    protected Node loadNode(ModelNode modelNode) {
        Node node = new Node();
        node.id = modelNode.id;
        if (modelNode.translation != null) {
            node.translation.set(modelNode.translation);
        }
        if (modelNode.rotation != null) {
            node.rotation.set(modelNode.rotation);
        }
        if (modelNode.scale != null) {
            node.scale.set(modelNode.scale);
        }
        if (modelNode.parts != null) {
            for (ModelNodePart object : modelNode.parts) {
                MeshPart meshPart = null;
                Material material = null;
                if (object.meshPartId != null) {
                    for (MeshPart meshPart2 : this.meshParts) {
                        if (!object.meshPartId.equals(meshPart2.id)) continue;
                        meshPart = meshPart2;
                        break;
                    }
                }
                if (object.materialId != null) {
                    for (Material material2 : this.materials) {
                        if (!object.materialId.equals(material2.id)) continue;
                        material = material2;
                        break;
                    }
                }
                if (meshPart == null || material == null) {
                    throw new GdxRuntimeException("Invalid node: " + node.id);
                }
                NodePart nodePart = new NodePart();
                nodePart.meshPart = meshPart;
                nodePart.material = material;
                node.parts.add(nodePart);
                if (object.bones == null) continue;
                this.nodePartBones.put(nodePart, object.bones);
            }
        }
        if (modelNode.children != null) {
            for (ModelNode modelNode2 : modelNode.children) {
                node.addChild(this.loadNode(modelNode2));
            }
        }
        return node;
    }

    protected void loadMeshes(Iterable<ModelMesh> iterable) {
        for (ModelMesh modelMesh : iterable) {
            this.convertMesh(modelMesh);
        }
    }

    protected void convertMesh(ModelMesh modelMesh) {
        int n2 = 0;
        for (ModelMeshPart object2 : modelMesh.parts) {
            n2 += object2.indices.length;
        }
        boolean bl2 = n2 > 0;
        VertexAttributes vertexAttributes = new VertexAttributes(modelMesh.attributes);
        int n3 = modelMesh.vertices.length / (vertexAttributes.vertexSize / 4);
        Mesh mesh = new Mesh(true, n3, n2, vertexAttributes);
        this.meshes.add(mesh);
        this.disposables.add(mesh);
        BufferUtils.copy(modelMesh.vertices, mesh.getVerticesBuffer(), modelMesh.vertices.length, 0);
        int n4 = 0;
        ((Buffer)mesh.getIndicesBuffer()).clear();
        for (ModelMeshPart modelMeshPart : modelMesh.parts) {
            MeshPart meshPart = new MeshPart();
            meshPart.id = modelMeshPart.id;
            meshPart.primitiveType = modelMeshPart.primitiveType;
            meshPart.offset = n4;
            meshPart.size = bl2 ? modelMeshPart.indices.length : n3;
            meshPart.mesh = mesh;
            if (bl2) {
                mesh.getIndicesBuffer().put(modelMeshPart.indices);
            }
            n4 += meshPart.size;
            this.meshParts.add(meshPart);
        }
        ((Buffer)mesh.getIndicesBuffer()).position(0);
        for (MeshPart meshPart : this.meshParts) {
            meshPart.update();
        }
    }

    protected void loadMaterials(Iterable<ModelMaterial> iterable, TextureProvider textureProvider) {
        for (ModelMaterial modelMaterial : iterable) {
            this.materials.add(this.convertMaterial(modelMaterial, textureProvider));
        }
    }

    protected Material convertMaterial(ModelMaterial modelMaterial, TextureProvider textureProvider) {
        Material material = new Material();
        material.id = modelMaterial.id;
        if (modelMaterial.ambient != null) {
            material.set((Attribute)new ColorAttribute(ColorAttribute.Ambient, modelMaterial.ambient));
        }
        if (modelMaterial.diffuse != null) {
            material.set((Attribute)new ColorAttribute(ColorAttribute.Diffuse, modelMaterial.diffuse));
        }
        if (modelMaterial.specular != null) {
            material.set((Attribute)new ColorAttribute(ColorAttribute.Specular, modelMaterial.specular));
        }
        if (modelMaterial.emissive != null) {
            material.set((Attribute)new ColorAttribute(ColorAttribute.Emissive, modelMaterial.emissive));
        }
        if (modelMaterial.reflection != null) {
            material.set((Attribute)new ColorAttribute(ColorAttribute.Reflection, modelMaterial.reflection));
        }
        if (modelMaterial.shininess > 0.0f) {
            material.set((Attribute)new FloatAttribute(FloatAttribute.Shininess, modelMaterial.shininess));
        }
        if (modelMaterial.opacity != 1.0f) {
            material.set((Attribute)new BlendingAttribute(770, 771, modelMaterial.opacity));
        }
        ObjectMap<String, Texture> objectMap = new ObjectMap<String, Texture>();
        if (modelMaterial.textures != null) {
            for (ModelTexture modelTexture : modelMaterial.textures) {
                Texture texture;
                if (objectMap.containsKey(modelTexture.fileName)) {
                    texture = (Texture)objectMap.get(modelTexture.fileName);
                } else {
                    texture = textureProvider.load(modelTexture.fileName);
                    objectMap.put(modelTexture.fileName, texture);
                    this.disposables.add(texture);
                }
                TextureDescriptor<Texture> textureDescriptor = new TextureDescriptor<Texture>(texture);
                textureDescriptor.minFilter = texture.getMinFilter();
                textureDescriptor.magFilter = texture.getMagFilter();
                textureDescriptor.uWrap = texture.getUWrap();
                textureDescriptor.vWrap = texture.getVWrap();
                float f2 = modelTexture.uvTranslation == null ? 0.0f : modelTexture.uvTranslation.x;
                float f3 = modelTexture.uvTranslation == null ? 0.0f : modelTexture.uvTranslation.y;
                float f4 = modelTexture.uvScaling == null ? 1.0f : modelTexture.uvScaling.x;
                float f5 = modelTexture.uvScaling == null ? 1.0f : modelTexture.uvScaling.y;
                switch (modelTexture.usage) {
                    case 2: {
                        material.set((Attribute)new TextureAttribute(TextureAttribute.Diffuse, textureDescriptor, f2, f3, f4, f5));
                        break;
                    }
                    case 5: {
                        material.set((Attribute)new TextureAttribute(TextureAttribute.Specular, textureDescriptor, f2, f3, f4, f5));
                        break;
                    }
                    case 8: {
                        material.set((Attribute)new TextureAttribute(TextureAttribute.Bump, textureDescriptor, f2, f3, f4, f5));
                        break;
                    }
                    case 7: {
                        material.set((Attribute)new TextureAttribute(TextureAttribute.Normal, textureDescriptor, f2, f3, f4, f5));
                        break;
                    }
                    case 4: {
                        material.set((Attribute)new TextureAttribute(TextureAttribute.Ambient, textureDescriptor, f2, f3, f4, f5));
                        break;
                    }
                    case 3: {
                        material.set((Attribute)new TextureAttribute(TextureAttribute.Emissive, textureDescriptor, f2, f3, f4, f5));
                        break;
                    }
                    case 10: {
                        material.set((Attribute)new TextureAttribute(TextureAttribute.Reflection, textureDescriptor, f2, f3, f4, f5));
                    }
                }
            }
        }
        return material;
    }

    public void manageDisposable(Disposable disposable) {
        if (!this.disposables.contains(disposable, true)) {
            this.disposables.add(disposable);
        }
    }

    public Iterable<Disposable> getManagedDisposables() {
        return this.disposables;
    }

    @Override
    public void dispose() {
        for (Disposable disposable : this.disposables) {
            disposable.dispose();
        }
    }

    public void calculateTransforms() {
        int n2;
        int n3 = this.nodes.size;
        for (n2 = 0; n2 < n3; ++n2) {
            this.nodes.get(n2).calculateTransforms(true);
        }
        for (n2 = 0; n2 < n3; ++n2) {
            this.nodes.get(n2).calculateBoneTransforms(true);
        }
    }

    public BoundingBox calculateBoundingBox(BoundingBox boundingBox) {
        boundingBox.inf();
        return this.extendBoundingBox(boundingBox);
    }

    public BoundingBox extendBoundingBox(BoundingBox boundingBox) {
        int n2 = this.nodes.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            this.nodes.get(i2).extendBoundingBox(boundingBox);
        }
        return boundingBox;
    }

    public Animation getAnimation(String string) {
        return this.getAnimation(string, true);
    }

    public Animation getAnimation(String string, boolean bl2) {
        int n2 = this.animations.size;
        if (bl2) {
            for (int i2 = 0; i2 < n2; ++i2) {
                Animation animation = this.animations.get(i2);
                if (!animation.id.equalsIgnoreCase(string)) continue;
                return animation;
            }
        } else {
            for (int i3 = 0; i3 < n2; ++i3) {
                Animation animation = this.animations.get(i3);
                if (!animation.id.equals(string)) continue;
                return animation;
            }
        }
        return null;
    }

    public Material getMaterial(String string) {
        return this.getMaterial(string, true);
    }

    public Material getMaterial(String string, boolean bl2) {
        int n2 = this.materials.size;
        if (bl2) {
            for (int i2 = 0; i2 < n2; ++i2) {
                Material material = this.materials.get(i2);
                if (!material.id.equalsIgnoreCase(string)) continue;
                return material;
            }
        } else {
            for (int i3 = 0; i3 < n2; ++i3) {
                Material material = this.materials.get(i3);
                if (!material.id.equals(string)) continue;
                return material;
            }
        }
        return null;
    }

    public Node getNode(String string) {
        return this.getNode(string, true);
    }

    public Node getNode(String string, boolean bl2) {
        return this.getNode(string, bl2, false);
    }

    public Node getNode(String string, boolean bl2, boolean bl3) {
        return Node.getNode(this.nodes, string, bl2, bl3);
    }
}

