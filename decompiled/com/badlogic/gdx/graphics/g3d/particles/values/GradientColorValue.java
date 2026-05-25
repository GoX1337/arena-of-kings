/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.particles.values;

import com.badlogic.gdx.graphics.g3d.particles.values.ParticleValue;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;

public class GradientColorValue
extends ParticleValue {
    private static float[] temp = new float[3];
    private float[] colors = new float[]{1.0f, 1.0f, 1.0f};
    public float[] timeline = new float[]{0.0f};

    public float[] getTimeline() {
        return this.timeline;
    }

    public void setTimeline(float[] fArray) {
        this.timeline = fArray;
    }

    public float[] getColors() {
        return this.colors;
    }

    public void setColors(float[] fArray) {
        this.colors = fArray;
    }

    public float[] getColor(float f2) {
        this.getColor(f2, temp, 0);
        return temp;
    }

    public void getColor(float f2, float[] fArray, int n2) {
        float f3;
        int n3 = 0;
        int n4 = -1;
        float[] fArray2 = this.timeline;
        int n5 = fArray2.length;
        int n6 = 1;
        while (n6 < n5) {
            f3 = fArray2[n6];
            if (f3 > f2) {
                n4 = n6;
                break;
            }
            n3 = n6++;
        }
        float f4 = fArray2[n3];
        f3 = this.colors[n3 *= 3];
        float f5 = this.colors[n3 + 1];
        float f6 = this.colors[n3 + 2];
        if (n4 == -1) {
            fArray[n2] = f3;
            fArray[n2 + 1] = f5;
            fArray[n2 + 2] = f6;
            return;
        }
        float f7 = (f2 - f4) / (fArray2[n4] - f4);
        fArray[n2] = f3 + (this.colors[n4 *= 3] - f3) * f7;
        fArray[n2 + 1] = f5 + (this.colors[n4 + 1] - f5) * f7;
        fArray[n2 + 2] = f6 + (this.colors[n4 + 2] - f6) * f7;
    }

    @Override
    public void write(Json json) {
        super.write(json);
        json.writeValue("colors", this.colors);
        json.writeValue("timeline", this.timeline);
    }

    @Override
    public void read(Json json, JsonValue jsonValue) {
        super.read(json, jsonValue);
        this.colors = json.readValue("colors", float[].class, jsonValue);
        this.timeline = json.readValue("timeline", float[].class, jsonValue);
    }

    public void load(GradientColorValue gradientColorValue) {
        super.load(gradientColorValue);
        this.colors = new float[gradientColorValue.colors.length];
        System.arraycopy(gradientColorValue.colors, 0, this.colors, 0, this.colors.length);
        this.timeline = new float[gradientColorValue.timeline.length];
        System.arraycopy(gradientColorValue.timeline, 0, this.timeline, 0, this.timeline.length);
    }
}

