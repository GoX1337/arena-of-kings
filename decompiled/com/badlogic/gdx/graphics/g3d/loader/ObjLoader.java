/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.loader;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.ModelLoader;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.loader.MtlLoader;
import com.badlogic.gdx.graphics.g3d.model.data.ModelData;
import com.badlogic.gdx.graphics.g3d.model.data.ModelMesh;
import com.badlogic.gdx.graphics.g3d.model.data.ModelMeshPart;
import com.badlogic.gdx.graphics.g3d.model.data.ModelNode;
import com.badlogic.gdx.graphics.g3d.model.data.ModelNodePart;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.FloatArray;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ObjLoader
extends ModelLoader<ObjLoaderParameters> {
    public static boolean logWarning = false;
    final FloatArray verts = new FloatArray(300);
    final FloatArray norms = new FloatArray(300);
    final FloatArray uvs = new FloatArray(200);
    final Array<Group> groups = new Array(10);

    public ObjLoader() {
        this(null);
    }

    public ObjLoader(FileHandleResolver fileHandleResolver) {
        super(fileHandleResolver);
    }

    @Override
    public Model loadModel(FileHandle fileHandle, boolean bl2) {
        return this.loadModel(fileHandle, new ObjLoaderParameters(bl2));
    }

    @Override
    public ModelData loadModelData(FileHandle fileHandle, ObjLoaderParameters objLoaderParameters) {
        return this.loadModelData(fileHandle, objLoaderParameters != null && objLoaderParameters.flipV);
    }

    /*
     * Unable to fully structure code
     */
    @Override
    protected ModelData loadModelData(FileHandle var1_1, boolean var2_2) {
        if (ObjLoader.logWarning) {
            Gdx.app.error("ObjLoader", "Wavefront (OBJ) is not fully supported, consult the documentation for more information");
        }
        var6_3 = new MtlLoader();
        var7_4 = new Group("default");
        this.groups.add(var7_4);
        var8_5 = new BufferedReader(new InputStreamReader(var1_1.read()), 4096);
        var9_6 = 0;
lbl8:
        // 2 sources

        try {
            while ((var3_7 = var8_5.readLine()) != null && (var4_8 = var3_7.split("\\s+")).length >= 1) {
                block33: {
                    if (var4_8[0].length() == 0 || (var5_9 = var4_8[0].toLowerCase().charAt(0)) == '#') continue;
                    if (var5_9 == 'v') {
                        if (var4_8[0].length() == 1) {
                            this.verts.add(Float.parseFloat(var4_8[1]));
                            this.verts.add(Float.parseFloat(var4_8[2]));
                            this.verts.add(Float.parseFloat(var4_8[3]));
                            continue;
                        }
                        if (var4_8[0].charAt(1) == 'n') {
                            this.norms.add(Float.parseFloat(var4_8[1]));
                            this.norms.add(Float.parseFloat(var4_8[2]));
                            this.norms.add(Float.parseFloat(var4_8[3]));
                            continue;
                        }
                        if (var4_8[0].charAt(1) != 't') continue;
                        this.uvs.add(Float.parseFloat(var4_8[1]));
                        this.uvs.add(var2_2 != false ? 1.0f - Float.parseFloat(var4_8[2]) : Float.parseFloat(var4_8[2]));
                        continue;
                    }
                    if (var5_9 != 'f') break block33;
                    var11_13 = var7_4.faces;
                    for (var12_14 = 1; var12_14 < var4_8.length - 2; --var12_14) {
                        var10_10 = var4_8[1].split("/");
                        var11_13.add(this.getIndex(var10_10[0], this.verts.size));
                        if (var10_10.length > 2) {
                            if (var12_14 == 1) {
                                var7_4.hasNorms = true;
                            }
                            var11_13.add(this.getIndex(var10_10[2], this.norms.size));
                        }
                        if (var10_10.length > 1 && var10_10[1].length() > 0) {
                            if (var12_14 == 1) {
                                var7_4.hasUVs = true;
                            }
                            var11_13.add(this.getIndex(var10_10[1], this.uvs.size));
                        }
                        var10_10 = var4_8[++var12_14].split("/");
                        var11_13.add(this.getIndex(var10_10[0], this.verts.size));
                        if (var10_10.length > 2) {
                            var11_13.add(this.getIndex(var10_10[2], this.norms.size));
                        }
                        if (var10_10.length > 1 && var10_10[1].length() > 0) {
                            var11_13.add(this.getIndex(var10_10[1], this.uvs.size));
                        }
                        var10_10 = var4_8[++var12_14].split("/");
                        var11_13.add(this.getIndex(var10_10[0], this.verts.size));
                        if (var10_10.length > 2) {
                            var11_13.add(this.getIndex(var10_10[2], this.norms.size));
                        }
                        if (var10_10.length > 1 && var10_10[1].length() > 0) {
                            var11_13.add(this.getIndex(var10_10[1], this.uvs.size));
                        }
                        ++var7_4.numFaces;
                    }
                    ** GOTO lbl8
                }
                if (var5_9 == 'o' || var5_9 == 'g') {
                    if (var4_8.length > 1) {
                        var7_4 = this.setActiveGroup(var4_8[1]);
                        continue;
                    }
                    var7_4 = this.setActiveGroup("default");
                    continue;
                }
                if (var4_8[0].equals("mtllib")) {
                    var6_3.load(var1_1.parent().child(var4_8[1]));
                    continue;
                }
                if (!var4_8[0].equals("usemtl")) continue;
                if (var4_8.length == 1) {
                    var7_4.materialName = "default";
                    continue;
                }
                var7_4.materialName = var4_8[1].replace('.', '_');
            }
            var8_5.close();
        }
        catch (IOException var10_11) {
            return null;
        }
        for (var10_12 = 0; var10_12 < this.groups.size; ++var10_12) {
            if (this.groups.get((int)var10_12).numFaces >= 1) continue;
            this.groups.removeIndex(var10_12);
            --var10_12;
        }
        if (this.groups.size < 1) {
            return null;
        }
        var10_12 = this.groups.size;
        var11_13 = new ModelData();
        for (var12_14 = 0; var12_14 < var10_12; ++var12_14) {
            var13_15 = this.groups.get(var12_14);
            var14_16 = var13_15.faces;
            var15_17 = var14_16.size;
            var16_18 = var13_15.numFaces;
            var17_19 = var13_15.hasNorms;
            var18_20 = var13_15.hasUVs;
            var19_21 = new float[var16_18 * 3 * (3 + (var17_19 != false ? 3 : 0) + (var18_20 != false ? 2 : 0))];
            var20_22 = 0;
            var21_24 = 0;
            while (var20_22 < var15_17) {
                var22_26 = var14_16.get(var20_22++) * 3;
                var19_21[var21_24++] = this.verts.get(var22_26++);
                var19_21[var21_24++] = this.verts.get(var22_26++);
                var19_21[var21_24++] = this.verts.get(var22_26);
                if (var17_19) {
                    var23_28 = var14_16.get(var20_22++) * 3;
                    var19_21[var21_24++] = this.norms.get(var23_28++);
                    var19_21[var21_24++] = this.norms.get(var23_28++);
                    var19_21[var21_24++] = this.norms.get(var23_28);
                }
                if (!var18_20) continue;
                var23_28 = var14_16.get(var20_22++) * 2;
                var19_21[var21_24++] = this.uvs.get(var23_28++);
                var19_21[var21_24++] = this.uvs.get(var23_28);
            }
            var20_22 = var16_18 * 3 >= 32767 ? 0 : var16_18 * 3;
            var21_23 = new short[var20_22];
            if (var20_22 > 0) {
                for (var22_26 = 0; var22_26 < var20_22; ++var22_26) {
                    var21_23[var22_26] = (short)var22_26;
                }
            }
            var22_25 = new Array<VertexAttribute>();
            var22_25.add(new VertexAttribute(1, 3, "a_position"));
            if (var17_19) {
                var22_25.add(new VertexAttribute(8, 3, "a_normal"));
            }
            if (var18_20) {
                var22_25.add(new VertexAttribute(16, 2, "a_texCoord0"));
            }
            var23_27 = Integer.toString(++var9_6);
            var24_29 = "default".equals(var13_15.name) != false ? "node" + var23_27 : var13_15.name;
            var25_30 = "default".equals(var13_15.name) != false ? "mesh" + var23_27 : var13_15.name;
            var26_31 = "default".equals(var13_15.name) != false ? "part" + var23_27 : var13_15.name;
            var27_32 = new ModelNode();
            var27_32.id = var24_29;
            var27_32.meshId = var25_30;
            var27_32.scale = new Vector3(1.0f, 1.0f, 1.0f);
            var27_32.translation = new Vector3();
            var27_32.rotation = new Quaternion();
            var28_33 = new ModelNodePart();
            var28_33.meshPartId = var26_31;
            var28_33.materialId = var13_15.materialName;
            var27_32.parts = new ModelNodePart[]{var28_33};
            var29_34 = new ModelMeshPart();
            var29_34.id = var26_31;
            var29_34.indices = var21_23;
            var29_34.primitiveType = 4;
            var30_35 = new ModelMesh();
            var30_35.id = var25_30;
            var30_35.attributes = var22_25.toArray(VertexAttribute.class);
            var30_35.vertices = var19_21;
            var30_35.parts = new ModelMeshPart[]{var29_34};
            var11_13.nodes.add(var27_32);
            var11_13.meshes.add(var30_35);
            var31_36 = var6_3.getMaterial(var13_15.materialName);
            var11_13.materials.add(var31_36);
        }
        if (this.verts.size > 0) {
            this.verts.clear();
        }
        if (this.norms.size > 0) {
            this.norms.clear();
        }
        if (this.uvs.size > 0) {
            this.uvs.clear();
        }
        if (this.groups.size > 0) {
            this.groups.clear();
        }
        return var11_13;
    }

    private Group setActiveGroup(String string) {
        for (Group group : this.groups) {
            if (!group.name.equals(string)) continue;
            return group;
        }
        Group group = new Group(string);
        this.groups.add(group);
        return group;
    }

    private int getIndex(String string, int n2) {
        if (string == null || string.length() == 0) {
            return 0;
        }
        int n3 = Integer.parseInt(string);
        if (n3 < 0) {
            return n2 + n3;
        }
        return n3 - 1;
    }

    static class Group {
        final String name;
        String materialName;
        Array<Integer> faces;
        int numFaces;
        boolean hasNorms;
        boolean hasUVs;
        Material mat;

        Group(String string) {
            this.name = string;
            this.faces = new Array(200);
            this.numFaces = 0;
            this.mat = new Material("");
            this.materialName = "default";
        }
    }

    public static class ObjLoaderParameters
    extends ModelLoader.ModelParameters {
        public boolean flipV;

        public ObjLoaderParameters() {
        }

        public ObjLoaderParameters(boolean bl2) {
            this.flipV = bl2;
        }
    }
}

