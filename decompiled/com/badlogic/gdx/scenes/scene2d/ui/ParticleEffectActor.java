/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Disposable;

public class ParticleEffectActor
extends Actor
implements Disposable {
    private final ParticleEffect particleEffect;
    protected float lastDelta;
    protected boolean isRunning;
    protected boolean ownsEffect;
    private boolean resetOnStart;
    private boolean autoRemove;

    public ParticleEffectActor(ParticleEffect particleEffect, boolean bl2) {
        this.particleEffect = particleEffect;
        this.resetOnStart = bl2;
    }

    public ParticleEffectActor(FileHandle fileHandle, TextureAtlas textureAtlas) {
        this.particleEffect = new ParticleEffect();
        this.particleEffect.load(fileHandle, textureAtlas);
        this.ownsEffect = true;
    }

    public ParticleEffectActor(FileHandle fileHandle, FileHandle fileHandle2) {
        this.particleEffect = new ParticleEffect();
        this.particleEffect.load(fileHandle, fileHandle2);
        this.ownsEffect = true;
    }

    @Override
    public void draw(Batch batch, float f2) {
        this.particleEffect.setPosition(this.getX(), this.getY());
        if (this.lastDelta > 0.0f) {
            this.particleEffect.update(this.lastDelta);
            this.lastDelta = 0.0f;
        }
        if (this.isRunning) {
            this.particleEffect.draw(batch);
            this.isRunning = !this.particleEffect.isComplete();
        }
    }

    @Override
    public void act(float f2) {
        super.act(f2);
        this.lastDelta += f2;
        if (this.autoRemove && this.particleEffect.isComplete()) {
            this.remove();
        }
    }

    public void start() {
        this.isRunning = true;
        if (this.resetOnStart) {
            this.particleEffect.reset(false);
        }
        this.particleEffect.start();
    }

    public boolean isResetOnStart() {
        return this.resetOnStart;
    }

    public ParticleEffectActor setResetOnStart(boolean bl2) {
        this.resetOnStart = bl2;
        return this;
    }

    public boolean isAutoRemove() {
        return this.autoRemove;
    }

    public ParticleEffectActor setAutoRemove(boolean bl2) {
        this.autoRemove = bl2;
        return this;
    }

    public boolean isRunning() {
        return this.isRunning;
    }

    public ParticleEffect getEffect() {
        return this.particleEffect;
    }

    @Override
    public void scaleChanged() {
        super.scaleChanged();
        this.particleEffect.scaleEffect(this.getScaleX(), this.getScaleY(), this.getScaleY());
    }

    public void cancel() {
        this.isRunning = true;
    }

    public void allowCompletion() {
        this.particleEffect.allowCompletion();
    }

    @Override
    public void dispose() {
        if (this.ownsEffect) {
            this.particleEffect.dispose();
        }
    }
}

