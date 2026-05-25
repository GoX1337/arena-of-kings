/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.particles.values;

import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.particles.values.MeshSpawnShapeValue;
import com.badlogic.gdx.graphics.g3d.particles.values.SpawnShapeValue;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;

public final class UnweightedMeshSpawnShapeValue
extends MeshSpawnShapeValue {
    private float[] vertices;
    private short[] indices;
    private int positionOffset;
    private int vertexSize;
    private int vertexCount;
    private int triangleCount;

    public UnweightedMeshSpawnShapeValue(UnweightedMeshSpawnShapeValue unweightedMeshSpawnShapeValue) {
        super(unweightedMeshSpawnShapeValue);
        this.load(unweightedMeshSpawnShapeValue);
    }

    public UnweightedMeshSpawnShapeValue() {
    }

    @Override
    public void setMesh(Mesh mesh, Model model) {
        super.setMesh(mesh, model);
        this.vertexSize = mesh.getVertexSize() / 4;
        this.positionOffset = mesh.getVertexAttribute((int)1).offset / 4;
        int n2 = mesh.getNumIndices();
        if (n2 > 0) {
            this.indices = new short[n2];
            mesh.getIndices(this.indices);
            this.triangleCount = this.indices.length / 3;
        } else {
            this.indices = null;
        }
        this.vertexCount = mesh.getNumVertices();
        this.vertices = new float[this.vertexCount * this.vertexSize];
        mesh.getVertices(this.vertices);
    }

    @Override
    public void spawnAux(Vector3 vector3, float f2) {
        if (this.indices == null) {
            int n2 = MathUtils.random(this.vertexCount - 3) * this.vertexSize;
            int n3 = n2 + this.positionOffset;
            int n4 = n3 + this.vertexSize;
            int n5 = n4 + this.vertexSize;
            float f3 = this.vertices[n3];
            float f4 = this.vertices[n3 + 1];
            float f5 = this.vertices[n3 + 2];
            float f6 = this.vertices[n4];
            float f7 = this.vertices[n4 + 1];
            float f8 = this.vertices[n4 + 2];
            float f9 = this.vertices[n5];
            float f10 = this.vertices[n5 + 1];
            float f11 = this.vertices[n5 + 2];
            MeshSpawnShapeValue.Triangle.pick(f3, f4, f5, f6, f7, f8, f9, f10, f11, vector3);
        } else {
            int n6 = MathUtils.random(this.triangleCount - 1) * 3;
            int n7 = this.indices[n6] * this.vertexSize + this.positionOffset;
            int n8 = this.indices[n6 + 1] * this.vertexSize + this.positionOffset;
            int n9 = this.indices[n6 + 2] * this.vertexSize + this.positionOffset;
            float f12 = this.vertices[n7];
            float f13 = this.vertices[n7 + 1];
            float f14 = this.vertices[n7 + 2];
            float f15 = this.vertices[n8];
            float f16 = this.vertices[n8 + 1];
            float f17 = this.vertices[n8 + 2];
            float f18 = this.vertices[n9];
            float f19 = this.vertices[n9 + 1];
            float f20 = this.vertices[n9 + 2];
            MeshSpawnShapeValue.Triangle.pick(f12, f13, f14, f15, f16, f17, f18, f19, f20, vector3);
        }
    }

    @Override
    public SpawnShapeValue copy() {
        return new UnweightedMeshSpawnShapeValue(this);
    }
}

