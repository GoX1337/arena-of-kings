/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.scenes.scene2d.actions;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.actions.TemporalAction;

public class RotateToAction
extends TemporalAction {
    private float start;
    private float end;
    private boolean useShortestDirection = false;

    public RotateToAction() {
    }

    public RotateToAction(boolean bl2) {
        this.useShortestDirection = bl2;
    }

    @Override
    protected void begin() {
        this.start = this.target.getRotation();
    }

    @Override
    protected void update(float f2) {
        float f3 = f2 == 0.0f ? this.start : (f2 == 1.0f ? this.end : (this.useShortestDirection ? MathUtils.lerpAngleDeg(this.start, this.end, f2) : this.start + (this.end - this.start) * f2));
        this.target.setRotation(f3);
    }

    public float getRotation() {
        return this.end;
    }

    public void setRotation(float f2) {
        this.end = f2;
    }

    public boolean isUseShortestDirection() {
        return this.useShortestDirection;
    }

    public void setUseShortestDirection(boolean bl2) {
        this.useShortestDirection = bl2;
    }
}

