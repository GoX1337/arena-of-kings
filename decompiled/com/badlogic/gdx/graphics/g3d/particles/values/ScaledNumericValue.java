/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.particles.values;

import com.badlogic.gdx.graphics.g3d.particles.values.RangedNumericValue;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;

public class ScaledNumericValue
extends RangedNumericValue {
    private float[] scaling = new float[]{1.0f};
    public float[] timeline = new float[]{0.0f};
    private float highMin;
    private float highMax;
    private boolean relative = false;

    public float newHighValue() {
        return this.highMin + (this.highMax - this.highMin) * MathUtils.random();
    }

    public void setHigh(float f2) {
        this.highMin = f2;
        this.highMax = f2;
    }

    public void setHigh(float f2, float f3) {
        this.highMin = f2;
        this.highMax = f3;
    }

    public float getHighMin() {
        return this.highMin;
    }

    public void setHighMin(float f2) {
        this.highMin = f2;
    }

    public float getHighMax() {
        return this.highMax;
    }

    public void setHighMax(float f2) {
        this.highMax = f2;
    }

    public float[] getScaling() {
        return this.scaling;
    }

    public void setScaling(float[] fArray) {
        this.scaling = fArray;
    }

    public float[] getTimeline() {
        return this.timeline;
    }

    public void setTimeline(float[] fArray) {
        this.timeline = fArray;
    }

    public boolean isRelative() {
        return this.relative;
    }

    public void setRelative(boolean bl2) {
        this.relative = bl2;
    }

    public float getScale(float f2) {
        float f3;
        int n2;
        int n3 = -1;
        int n4 = this.timeline.length;
        for (n2 = 1; n2 < n4; ++n2) {
            f3 = this.timeline[n2];
            if (!(f3 > f2)) continue;
            n3 = n2;
            break;
        }
        if (n3 == -1) {
            return this.scaling[n4 - 1];
        }
        n2 = n3 - 1;
        f3 = this.scaling[n2];
        float f4 = this.timeline[n2];
        return f3 + (this.scaling[n3] - f3) * ((f2 - f4) / (this.timeline[n3] - f4));
    }

    public void load(ScaledNumericValue scaledNumericValue) {
        super.load(scaledNumericValue);
        this.highMax = scaledNumericValue.highMax;
        this.highMin = scaledNumericValue.highMin;
        this.scaling = new float[scaledNumericValue.scaling.length];
        System.arraycopy(scaledNumericValue.scaling, 0, this.scaling, 0, this.scaling.length);
        this.timeline = new float[scaledNumericValue.timeline.length];
        System.arraycopy(scaledNumericValue.timeline, 0, this.timeline, 0, this.timeline.length);
        this.relative = scaledNumericValue.relative;
    }

    @Override
    public void write(Json json) {
        super.write(json);
        json.writeValue("highMin", Float.valueOf(this.highMin));
        json.writeValue("highMax", Float.valueOf(this.highMax));
        json.writeValue("relative", this.relative);
        json.writeValue("scaling", this.scaling);
        json.writeValue("timeline", this.timeline);
    }

    @Override
    public void read(Json json, JsonValue jsonValue) {
        super.read(json, jsonValue);
        this.highMin = json.readValue("highMin", Float.TYPE, jsonValue).floatValue();
        this.highMax = json.readValue("highMax", Float.TYPE, jsonValue).floatValue();
        this.relative = json.readValue("relative", Boolean.TYPE, jsonValue);
        this.scaling = json.readValue("scaling", float[].class, jsonValue);
        this.timeline = json.readValue("timeline", float[].class, jsonValue);
    }
}

