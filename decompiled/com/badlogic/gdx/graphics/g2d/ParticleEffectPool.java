/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g2d;

import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.ParticleEmitter;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pool;

public class ParticleEffectPool
extends Pool<PooledEffect> {
    private final ParticleEffect effect;

    public ParticleEffectPool(ParticleEffect particleEffect, int n2, int n3) {
        super(n2, n3);
        this.effect = particleEffect;
    }

    @Override
    protected PooledEffect newObject() {
        PooledEffect pooledEffect = new PooledEffect(this.effect);
        pooledEffect.start();
        return pooledEffect;
    }

    @Override
    public void free(PooledEffect pooledEffect) {
        super.free(pooledEffect);
        pooledEffect.reset(false);
        if (pooledEffect.xSizeScale != this.effect.xSizeScale || pooledEffect.ySizeScale != this.effect.ySizeScale || pooledEffect.motionScale != this.effect.motionScale) {
            Array<ParticleEmitter> array = pooledEffect.getEmitters();
            Array<ParticleEmitter> array2 = this.effect.getEmitters();
            for (int i2 = 0; i2 < array.size; ++i2) {
                ParticleEmitter particleEmitter = array.get(i2);
                ParticleEmitter particleEmitter2 = array2.get(i2);
                particleEmitter.matchSize(particleEmitter2);
                particleEmitter.matchMotion(particleEmitter2);
            }
            pooledEffect.xSizeScale = this.effect.xSizeScale;
            pooledEffect.ySizeScale = this.effect.ySizeScale;
            pooledEffect.motionScale = this.effect.motionScale;
        }
    }

    public class PooledEffect
    extends ParticleEffect {
        PooledEffect(ParticleEffect particleEffect) {
            super(particleEffect);
        }

        public void free() {
            ParticleEffectPool.this.free(this);
        }
    }
}

