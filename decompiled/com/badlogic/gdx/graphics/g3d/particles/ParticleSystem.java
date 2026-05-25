/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.particles;

import com.badlogic.gdx.graphics.g3d.Renderable;
import com.badlogic.gdx.graphics.g3d.RenderableProvider;
import com.badlogic.gdx.graphics.g3d.particles.ParticleEffect;
import com.badlogic.gdx.graphics.g3d.particles.batches.ParticleBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pool;

public final class ParticleSystem
implements RenderableProvider {
    private static ParticleSystem instance;
    private Array<ParticleBatch<?>> batches = new Array();
    private Array<ParticleEffect> effects = new Array();

    @Deprecated
    public static ParticleSystem get() {
        if (instance == null) {
            instance = new ParticleSystem();
        }
        return instance;
    }

    public void add(ParticleBatch<?> particleBatch) {
        this.batches.add(particleBatch);
    }

    public void add(ParticleEffect particleEffect) {
        this.effects.add(particleEffect);
    }

    public void remove(ParticleEffect particleEffect) {
        this.effects.removeValue(particleEffect, true);
    }

    public void removeAll() {
        this.effects.clear();
    }

    public void update() {
        for (ParticleEffect particleEffect : this.effects) {
            particleEffect.update();
        }
    }

    public void updateAndDraw() {
        for (ParticleEffect particleEffect : this.effects) {
            particleEffect.update();
            particleEffect.draw();
        }
    }

    public void update(float f2) {
        for (ParticleEffect particleEffect : this.effects) {
            particleEffect.update(f2);
        }
    }

    public void updateAndDraw(float f2) {
        for (ParticleEffect particleEffect : this.effects) {
            particleEffect.update(f2);
            particleEffect.draw();
        }
    }

    public void begin() {
        for (ParticleBatch particleBatch : this.batches) {
            particleBatch.begin();
        }
    }

    public void draw() {
        for (ParticleEffect particleEffect : this.effects) {
            particleEffect.draw();
        }
    }

    public void end() {
        for (ParticleBatch particleBatch : this.batches) {
            particleBatch.end();
        }
    }

    @Override
    public void getRenderables(Array<Renderable> array, Pool<Renderable> pool) {
        for (ParticleBatch particleBatch : this.batches) {
            particleBatch.getRenderables(array, pool);
        }
    }

    public Array<ParticleBatch<?>> getBatches() {
        return this.batches;
    }
}

