/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.environment;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.GdxRuntimeException;

public class AmbientCubemap {
    private static final int NUM_VALUES = 18;
    public final float[] data;

    private static final float clamp(float f2) {
        return f2 < 0.0f ? 0.0f : (f2 > 1.0f ? 1.0f : f2);
    }

    public AmbientCubemap() {
        this.data = new float[18];
    }

    public AmbientCubemap(float[] fArray) {
        if (fArray.length != 18) {
            throw new GdxRuntimeException("Incorrect array size");
        }
        this.data = new float[fArray.length];
        System.arraycopy(fArray, 0, this.data, 0, this.data.length);
    }

    public AmbientCubemap(AmbientCubemap ambientCubemap) {
        this(ambientCubemap.data);
    }

    public AmbientCubemap set(float[] fArray) {
        for (int i2 = 0; i2 < this.data.length; ++i2) {
            this.data[i2] = fArray[i2];
        }
        return this;
    }

    public AmbientCubemap set(AmbientCubemap ambientCubemap) {
        return this.set(ambientCubemap.data);
    }

    public AmbientCubemap set(Color color) {
        return this.set(color.r, color.g, color.b);
    }

    public AmbientCubemap set(float f2, float f3, float f4) {
        for (int i2 = 0; i2 < 18; i2 += 3) {
            this.data[i2] = f2;
            this.data[i2 + 1] = f3;
            this.data[i2 + 2] = f4;
        }
        return this;
    }

    public Color getColor(Color color, int n2) {
        return color.set(this.data[n2 *= 3], this.data[n2 + 1], this.data[n2 + 2], 1.0f);
    }

    public AmbientCubemap clear() {
        for (int i2 = 0; i2 < this.data.length; ++i2) {
            this.data[i2] = 0.0f;
        }
        return this;
    }

    public AmbientCubemap clamp() {
        for (int i2 = 0; i2 < this.data.length; ++i2) {
            this.data[i2] = AmbientCubemap.clamp(this.data[i2]);
        }
        return this;
    }

    public AmbientCubemap add(float f2, float f3, float f4) {
        int n2 = 0;
        while (n2 < this.data.length) {
            int n3 = n2++;
            this.data[n3] = this.data[n3] + f2;
            int n4 = n2++;
            this.data[n4] = this.data[n4] + f3;
            int n5 = n2++;
            this.data[n5] = this.data[n5] + f4;
        }
        return this;
    }

    public AmbientCubemap add(Color color) {
        return this.add(color.r, color.g, color.b);
    }

    public AmbientCubemap add(float f2, float f3, float f4, float f5, float f6, float f7) {
        int n2;
        float f8 = f5 * f5;
        float f9 = f6 * f6;
        float f10 = f7 * f7;
        float f11 = f8 + f9 + f10;
        if (f11 == 0.0f) {
            return this;
        }
        f11 = 1.0f / f11 * (f11 + 1.0f);
        float f12 = f2 * f11;
        float f13 = f3 * f11;
        float f14 = f4 * f11;
        int n3 = n2 = f5 > 0.0f ? 0 : 3;
        this.data[n3] = this.data[n3] + f8 * f12;
        int n4 = n2 + 1;
        this.data[n4] = this.data[n4] + f8 * f13;
        int n5 = n2 + 2;
        this.data[n5] = this.data[n5] + f8 * f14;
        int n6 = n2 = f6 > 0.0f ? 6 : 9;
        this.data[n6] = this.data[n6] + f9 * f12;
        int n7 = n2 + 1;
        this.data[n7] = this.data[n7] + f9 * f13;
        int n8 = n2 + 2;
        this.data[n8] = this.data[n8] + f9 * f14;
        int n9 = n2 = f7 > 0.0f ? 12 : 15;
        this.data[n9] = this.data[n9] + f10 * f12;
        int n10 = n2 + 1;
        this.data[n10] = this.data[n10] + f10 * f13;
        int n11 = n2 + 2;
        this.data[n11] = this.data[n11] + f10 * f14;
        return this;
    }

    public AmbientCubemap add(Color color, Vector3 vector3) {
        return this.add(color.r, color.g, color.b, vector3.x, vector3.y, vector3.z);
    }

    public AmbientCubemap add(float f2, float f3, float f4, Vector3 vector3) {
        return this.add(f2, f3, f4, vector3.x, vector3.y, vector3.z);
    }

    public AmbientCubemap add(Color color, float f2, float f3, float f4) {
        return this.add(color.r, color.g, color.b, f2, f3, f4);
    }

    public AmbientCubemap add(Color color, Vector3 vector3, Vector3 vector32) {
        return this.add(color.r, color.g, color.b, vector32.x - vector3.x, vector32.y - vector3.y, vector32.z - vector3.z);
    }

    public AmbientCubemap add(Color color, Vector3 vector3, Vector3 vector32, float f2) {
        float f3 = f2 / (1.0f + vector32.dst(vector3));
        return this.add(color.r * f3, color.g * f3, color.b * f3, vector32.x - vector3.x, vector32.y - vector3.y, vector32.z - vector3.z);
    }

    public String toString() {
        String string = "";
        for (int i2 = 0; i2 < this.data.length; i2 += 3) {
            string = string + Float.toString(this.data[i2]) + ", " + Float.toString(this.data[i2 + 1]) + ", " + Float.toString(this.data[i2 + 2]) + "\n";
        }
        return string;
    }
}

