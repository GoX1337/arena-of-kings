/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.particles.values;

import com.badlogic.gdx.graphics.g3d.particles.values.ParticleValue;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;

public class RangedNumericValue
extends ParticleValue {
    private float lowMin;
    private float lowMax;

    public float newLowValue() {
        return this.lowMin + (this.lowMax - this.lowMin) * MathUtils.random();
    }

    public void setLow(float f2) {
        this.lowMin = f2;
        this.lowMax = f2;
    }

    public void setLow(float f2, float f3) {
        this.lowMin = f2;
        this.lowMax = f3;
    }

    public float getLowMin() {
        return this.lowMin;
    }

    public void setLowMin(float f2) {
        this.lowMin = f2;
    }

    public float getLowMax() {
        return this.lowMax;
    }

    public void setLowMax(float f2) {
        this.lowMax = f2;
    }

    public void load(RangedNumericValue rangedNumericValue) {
        super.load(rangedNumericValue);
        this.lowMax = rangedNumericValue.lowMax;
        this.lowMin = rangedNumericValue.lowMin;
    }

    @Override
    public void write(Json json) {
        super.write(json);
        json.writeValue("lowMin", Float.valueOf(this.lowMin));
        json.writeValue("lowMax", Float.valueOf(this.lowMax));
    }

    @Override
    public void read(Json json, JsonValue jsonValue) {
        super.read(json, jsonValue);
        this.lowMin = json.readValue("lowMin", Float.TYPE, jsonValue).floatValue();
        this.lowMax = json.readValue("lowMax", Float.TYPE, jsonValue).floatValue();
    }
}

