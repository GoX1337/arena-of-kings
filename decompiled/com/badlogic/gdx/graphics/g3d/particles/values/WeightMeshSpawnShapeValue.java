/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.particles.values;

import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.particles.values.MeshSpawnShapeValue;
import com.badlogic.gdx.graphics.g3d.particles.values.SpawnShapeValue;
import com.badlogic.gdx.math.CumulativeDistribution;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;

public final class WeightMeshSpawnShapeValue
extends MeshSpawnShapeValue {
    private CumulativeDistribution<MeshSpawnShapeValue.Triangle> distribution = new CumulativeDistribution();

    public WeightMeshSpawnShapeValue(WeightMeshSpawnShapeValue weightMeshSpawnShapeValue) {
        super(weightMeshSpawnShapeValue);
        this.load(weightMeshSpawnShapeValue);
    }

    public WeightMeshSpawnShapeValue() {
    }

    @Override
    public void init() {
        this.calculateWeights();
    }

    public void calculateWeights() {
        this.distribution.clear();
        VertexAttributes vertexAttributes = this.mesh.getVertexAttributes();
        int n2 = this.mesh.getNumIndices();
        int n3 = this.mesh.getNumVertices();
        short s2 = (short)(vertexAttributes.vertexSize / 4);
        short s3 = (short)(vertexAttributes.findByUsage((int)1).offset / 4);
        float[] fArray = new float[n3 * s2];
        this.mesh.getVertices(fArray);
        if (n2 > 0) {
            short[] sArray = new short[n2];
            this.mesh.getIndices(sArray);
            for (int i2 = 0; i2 < n2; i2 += 3) {
                int n4 = sArray[i2] * s2 + s3;
                int n5 = sArray[i2 + 1] * s2 + s3;
                int n6 = sArray[i2 + 2] * s2 + s3;
                float f2 = fArray[n4];
                float f3 = fArray[n4 + 1];
                float f4 = fArray[n4 + 2];
                float f5 = fArray[n5];
                float f6 = fArray[n5 + 1];
                float f7 = fArray[n5 + 2];
                float f8 = fArray[n6];
                float f9 = fArray[n6 + 1];
                float f10 = fArray[n6 + 2];
                float f11 = Math.abs((f2 * (f6 - f9) + f5 * (f9 - f3) + f8 * (f3 - f6)) / 2.0f);
                this.distribution.add(new MeshSpawnShapeValue.Triangle(f2, f3, f4, f5, f6, f7, f8, f9, f10), f11);
            }
        } else {
            for (int i3 = 0; i3 < n3; i3 += s2) {
                int n7 = i3 + s3;
                int n8 = n7 + s2;
                int n9 = n8 + s2;
                float f12 = fArray[n7];
                float f13 = fArray[n7 + 1];
                float f14 = fArray[n7 + 2];
                float f15 = fArray[n8];
                float f16 = fArray[n8 + 1];
                float f17 = fArray[n8 + 2];
                float f18 = fArray[n9];
                float f19 = fArray[n9 + 1];
                float f20 = fArray[n9 + 2];
                float f21 = Math.abs((f12 * (f16 - f19) + f15 * (f19 - f13) + f18 * (f13 - f16)) / 2.0f);
                this.distribution.add(new MeshSpawnShapeValue.Triangle(f12, f13, f14, f15, f16, f17, f18, f19, f20), f21);
            }
        }
        this.distribution.generateNormalized();
    }

    @Override
    public void spawnAux(Vector3 vector3, float f2) {
        MeshSpawnShapeValue.Triangle triangle = this.distribution.value();
        float f3 = MathUtils.random();
        float f4 = MathUtils.random();
        vector3.set(triangle.x1 + f3 * (triangle.x2 - triangle.x1) + f4 * (triangle.x3 - triangle.x1), triangle.y1 + f3 * (triangle.y2 - triangle.y1) + f4 * (triangle.y3 - triangle.y1), triangle.z1 + f3 * (triangle.z2 - triangle.z1) + f4 * (triangle.z3 - triangle.z1));
    }

    @Override
    public SpawnShapeValue copy() {
        return new WeightMeshSpawnShapeValue(this);
    }
}

