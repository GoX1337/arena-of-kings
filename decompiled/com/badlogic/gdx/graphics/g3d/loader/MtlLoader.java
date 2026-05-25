/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.loader;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g3d.model.data.ModelMaterial;
import com.badlogic.gdx.graphics.g3d.model.data.ModelTexture;
import com.badlogic.gdx.utils.Array;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class MtlLoader {
    public Array<ModelMaterial> materials = new Array();

    MtlLoader() {
    }

    public void load(FileHandle fileHandle) {
        Object object;
        ObjMaterial objMaterial = new ObjMaterial();
        if (fileHandle == null || !fileHandle.exists()) {
            return;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileHandle.read()), 4096);
        try {
            String string;
            while ((string = bufferedReader.readLine()) != null) {
                String[] stringArray;
                if (string.length() > 0 && string.charAt(0) == '\t') {
                    string = string.substring(1).trim();
                }
                if ((stringArray = string.split("\\s+"))[0].length() == 0 || stringArray[0].charAt(0) == '#') continue;
                object = stringArray[0].toLowerCase();
                if (((String)object).equals("newmtl")) {
                    ModelMaterial modelMaterial = objMaterial.build();
                    this.materials.add(modelMaterial);
                    if (stringArray.length > 1) {
                        objMaterial.materialName = stringArray[1];
                        objMaterial.materialName = objMaterial.materialName.replace('.', '_');
                    } else {
                        objMaterial.materialName = "default";
                    }
                    objMaterial.reset();
                    continue;
                }
                if (((String)object).equals("ka")) {
                    objMaterial.ambientColor = this.parseColor(stringArray);
                    continue;
                }
                if (((String)object).equals("kd")) {
                    objMaterial.diffuseColor = this.parseColor(stringArray);
                    continue;
                }
                if (((String)object).equals("ks")) {
                    objMaterial.specularColor = this.parseColor(stringArray);
                    continue;
                }
                if (((String)object).equals("tr") || ((String)object).equals("d")) {
                    objMaterial.opacity = Float.parseFloat(stringArray[1]);
                    continue;
                }
                if (((String)object).equals("ns")) {
                    objMaterial.shininess = Float.parseFloat(stringArray[1]);
                    continue;
                }
                if (((String)object).equals("map_d")) {
                    objMaterial.alphaTexFilename = fileHandle.parent().child(stringArray[1]).path();
                    continue;
                }
                if (((String)object).equals("map_ka")) {
                    objMaterial.ambientTexFilename = fileHandle.parent().child(stringArray[1]).path();
                    continue;
                }
                if (((String)object).equals("map_kd")) {
                    objMaterial.diffuseTexFilename = fileHandle.parent().child(stringArray[1]).path();
                    continue;
                }
                if (((String)object).equals("map_ks")) {
                    objMaterial.specularTexFilename = fileHandle.parent().child(stringArray[1]).path();
                    continue;
                }
                if (!((String)object).equals("map_ns")) continue;
                objMaterial.shininessTexFilename = fileHandle.parent().child(stringArray[1]).path();
            }
            bufferedReader.close();
        }
        catch (IOException iOException) {
            return;
        }
        object = objMaterial.build();
        this.materials.add((ModelMaterial)object);
    }

    private Color parseColor(String[] stringArray) {
        float f2 = Float.parseFloat(stringArray[1]);
        float f3 = Float.parseFloat(stringArray[2]);
        float f4 = Float.parseFloat(stringArray[3]);
        float f5 = 1.0f;
        if (stringArray.length > 4) {
            f5 = Float.parseFloat(stringArray[4]);
        }
        return new Color(f2, f3, f4, f5);
    }

    public ModelMaterial getMaterial(String string) {
        for (ModelMaterial modelMaterial : this.materials) {
            if (!modelMaterial.id.equals(string)) continue;
            return modelMaterial;
        }
        ModelMaterial modelMaterial = new ModelMaterial();
        modelMaterial.id = string;
        modelMaterial.diffuse = new Color(Color.WHITE);
        this.materials.add(modelMaterial);
        return modelMaterial;
    }

    static class ObjMaterial {
        String materialName = "default";
        Color ambientColor;
        Color diffuseColor;
        Color specularColor;
        float opacity;
        float shininess;
        String alphaTexFilename;
        String ambientTexFilename;
        String diffuseTexFilename;
        String shininessTexFilename;
        String specularTexFilename;

        public ObjMaterial() {
            this.reset();
        }

        public ModelMaterial build() {
            ModelMaterial modelMaterial = new ModelMaterial();
            modelMaterial.id = this.materialName;
            modelMaterial.ambient = this.ambientColor == null ? null : new Color(this.ambientColor);
            modelMaterial.diffuse = new Color(this.diffuseColor);
            modelMaterial.specular = new Color(this.specularColor);
            modelMaterial.opacity = this.opacity;
            modelMaterial.shininess = this.shininess;
            this.addTexture(modelMaterial, this.alphaTexFilename, 9);
            this.addTexture(modelMaterial, this.ambientTexFilename, 4);
            this.addTexture(modelMaterial, this.diffuseTexFilename, 2);
            this.addTexture(modelMaterial, this.specularTexFilename, 5);
            this.addTexture(modelMaterial, this.shininessTexFilename, 6);
            return modelMaterial;
        }

        private void addTexture(ModelMaterial modelMaterial, String string, int n2) {
            if (string != null) {
                ModelTexture modelTexture = new ModelTexture();
                modelTexture.usage = n2;
                modelTexture.fileName = string;
                if (modelMaterial.textures == null) {
                    modelMaterial.textures = new Array(1);
                }
                modelMaterial.textures.add(modelTexture);
            }
        }

        public void reset() {
            this.ambientColor = null;
            this.diffuseColor = Color.WHITE;
            this.specularColor = Color.WHITE;
            this.opacity = 1.0f;
            this.shininess = 0.0f;
            this.alphaTexFilename = null;
            this.ambientTexFilename = null;
            this.diffuseTexFilename = null;
            this.shininessTexFilename = null;
            this.specularTexFilename = null;
        }
    }
}

