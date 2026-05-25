/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.particles.emitters;

import com.badlogic.gdx.graphics.g3d.particles.ParticleControllerComponent;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;

public abstract class Emitter
extends ParticleControllerComponent
implements Json.Serializable {
    public int minParticleCount;
    public int maxParticleCount = 4;
    public float percent;

    public Emitter(Emitter emitter) {
        this.set(emitter);
    }

    public Emitter() {
    }

    @Override
    public void init() {
        this.controller.particles.size = 0;
    }

    @Override
    public void end() {
        this.controller.particles.size = 0;
    }

    public boolean isComplete() {
        return this.percent >= 1.0f;
    }

    public int getMinParticleCount() {
        return this.minParticleCount;
    }

    public void setMinParticleCount(int n2) {
        this.minParticleCount = n2;
    }

    public int getMaxParticleCount() {
        return this.maxParticleCount;
    }

    public void setMaxParticleCount(int n2) {
        this.maxParticleCount = n2;
    }

    public void setParticleCount(int n2, int n3) {
        this.setMinParticleCount(n2);
        this.setMaxParticleCount(n3);
    }

    public void set(Emitter emitter) {
        this.minParticleCount = emitter.minParticleCount;
        this.maxParticleCount = emitter.maxParticleCount;
    }

    @Override
    public void write(Json json) {
        json.writeValue("minParticleCount", this.minParticleCount);
        json.writeValue("maxParticleCount", this.maxParticleCount);
    }

    @Override
    public void read(Json json, JsonValue jsonValue) {
        this.minParticleCount = json.readValue("minParticleCount", Integer.TYPE, jsonValue);
        this.maxParticleCount = json.readValue("maxParticleCount", Integer.TYPE, jsonValue);
    }
}

