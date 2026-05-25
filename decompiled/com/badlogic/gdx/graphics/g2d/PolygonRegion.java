/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g2d;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class PolygonRegion {
    final float[] textureCoords;
    final float[] vertices;
    final short[] triangles;
    final TextureRegion region;

    public PolygonRegion(TextureRegion textureRegion, float[] fArray, short[] sArray) {
        this.region = textureRegion;
        this.vertices = fArray;
        this.triangles = sArray;
        this.textureCoords = new float[fArray.length];
        float[] fArray2 = this.textureCoords;
        float f2 = textureRegion.u;
        float f3 = textureRegion.v;
        float f4 = textureRegion.u2 - f2;
        float f5 = textureRegion.v2 - f3;
        int n2 = textureRegion.regionWidth;
        int n3 = textureRegion.regionHeight;
        int n4 = fArray.length;
        for (int i2 = 0; i2 < n4; i2 += 2) {
            fArray2[i2] = f2 + f4 * (fArray[i2] / (float)n2);
            fArray2[i2 + 1] = f3 + f5 * (1.0f - fArray[i2 + 1] / (float)n3);
        }
    }

    public float[] getVertices() {
        return this.vertices;
    }

    public short[] getTriangles() {
        return this.triangles;
    }

    public float[] getTextureCoords() {
        return this.textureCoords;
    }

    public TextureRegion getRegion() {
        return this.region;
    }
}

