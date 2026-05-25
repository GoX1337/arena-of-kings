/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.particles.values;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.particles.ResourceData;
import com.badlogic.gdx.graphics.g3d.particles.values.ParticleValue;
import com.badlogic.gdx.graphics.g3d.particles.values.SpawnShapeValue;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.GdxRuntimeException;

public abstract class MeshSpawnShapeValue
extends SpawnShapeValue {
    protected Mesh mesh;
    protected Model model;

    public MeshSpawnShapeValue(MeshSpawnShapeValue meshSpawnShapeValue) {
        super(meshSpawnShapeValue);
    }

    public MeshSpawnShapeValue() {
    }

    @Override
    public void load(ParticleValue particleValue) {
        super.load(particleValue);
        MeshSpawnShapeValue meshSpawnShapeValue = (MeshSpawnShapeValue)particleValue;
        this.setMesh(meshSpawnShapeValue.mesh, meshSpawnShapeValue.model);
    }

    public void setMesh(Mesh mesh, Model model) {
        if (mesh.getVertexAttribute(1) == null) {
            throw new GdxRuntimeException("Mesh vertices must have Usage.Position");
        }
        this.model = model;
        this.mesh = mesh;
    }

    public void setMesh(Mesh mesh) {
        this.setMesh(mesh, null);
    }

    @Override
    public void save(AssetManager assetManager, ResourceData resourceData) {
        if (this.model != null) {
            ResourceData.SaveData saveData = resourceData.createSaveData();
            saveData.saveAsset(assetManager.getAssetFileName(this.model), Model.class);
            saveData.save("index", this.model.meshes.indexOf(this.mesh, true));
        }
    }

    @Override
    public void load(AssetManager assetManager, ResourceData resourceData) {
        ResourceData.SaveData saveData = resourceData.getSaveData();
        AssetDescriptor assetDescriptor = saveData.loadAsset();
        if (assetDescriptor != null) {
            Model model = (Model)assetManager.get(assetDescriptor);
            this.setMesh(model.meshes.get((Integer)saveData.load("index")), model);
        }
    }

    public static class Triangle {
        float x1;
        float y1;
        float z1;
        float x2;
        float y2;
        float z2;
        float x3;
        float y3;
        float z3;

        public Triangle(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
            this.x1 = f2;
            this.y1 = f3;
            this.z1 = f4;
            this.x2 = f5;
            this.y2 = f6;
            this.z2 = f7;
            this.x3 = f8;
            this.y3 = f9;
            this.z3 = f10;
        }

        public static Vector3 pick(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, Vector3 vector3) {
            float f11 = MathUtils.random();
            float f12 = MathUtils.random();
            return vector3.set(f2 + f11 * (f5 - f2) + f12 * (f8 - f2), f3 + f11 * (f6 - f3) + f12 * (f9 - f3), f4 + f11 * (f7 - f4) + f12 * (f10 - f4));
        }

        public Vector3 pick(Vector3 vector3) {
            float f2 = MathUtils.random();
            float f3 = MathUtils.random();
            return vector3.set(this.x1 + f2 * (this.x2 - this.x1) + f3 * (this.x3 - this.x1), this.y1 + f2 * (this.y2 - this.y1) + f3 * (this.y3 - this.y1), this.z1 + f2 * (this.z2 - this.z1) + f3 * (this.z3 - this.z1));
        }
    }
}

