/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.scenes.scene2d.actions;

import com.badlogic.gdx.scenes.scene2d.actions.TemporalAction;

public abstract class RelativeTemporalAction
extends TemporalAction {
    private float lastPercent;

    @Override
    protected void begin() {
        this.lastPercent = 0.0f;
    }

    @Override
    protected void update(float f2) {
        this.updateRelative(f2 - this.lastPercent);
        this.lastPercent = f2;
    }

    protected abstract void updateRelative(float var1);
}

