/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.particles.values;

import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;

public class ParticleValue
implements Json.Serializable {
    public boolean active;

    public ParticleValue() {
    }

    public ParticleValue(ParticleValue particleValue) {
        this.active = particleValue.active;
    }

    public boolean isActive() {
        return this.active;
    }

    public void setActive(boolean bl2) {
        this.active = bl2;
    }

    public void load(ParticleValue particleValue) {
        this.active = particleValue.active;
    }

    @Override
    public void write(Json json) {
        json.writeValue("active", this.active);
    }

    @Override
    public void read(Json json, JsonValue jsonValue) {
        this.active = json.readValue("active", Boolean.class, jsonValue);
    }
}

