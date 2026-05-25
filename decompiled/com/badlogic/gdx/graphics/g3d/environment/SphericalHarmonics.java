/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.environment;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g3d.environment.AmbientCubemap;
import com.badlogic.gdx.utils.GdxRuntimeException;

public class SphericalHarmonics {
    private static final float[] coeff = new float[]{0.282095f, 0.488603f, 0.488603f, 0.488603f, 1.092548f, 1.092548f, 1.092548f, 0.315392f, 0.546274f};
    public final float[] data;

    private static final float clamp(float f2) {
        return f2 < 0.0f ? 0.0f : (f2 > 1.0f ? 1.0f : f2);
    }

    public SphericalHarmonics() {
        this.data = new float[27];
    }

    public SphericalHarmonics(float[] fArray) {
        if (fArray.length != 27) {
            throw new GdxRuntimeException("Incorrect array size");
        }
        this.data = (float[])fArray.clone();
    }

    public SphericalHarmonics set(float[] fArray) {
        for (int i2 = 0; i2 < this.data.length; ++i2) {
            this.data[i2] = fArray[i2];
        }
        return this;
    }

    public SphericalHarmonics set(AmbientCubemap ambientCubemap) {
        return this.set(ambientCubemap.data);
    }

    public SphericalHarmonics set(Color color) {
        return this.set(color.r, color.g, color.b);
    }

    public SphericalHarmonics set(float f2, float f3, float f4) {
        int n2 = 0;
        while (n2 < this.data.length) {
            this.data[n2++] = f2;
            this.data[n2++] = f3;
            this.data[n2++] = f4;
        }
        return this;
    }
}

