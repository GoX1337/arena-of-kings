/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.scenes.scene2d.actions;

import com.badlogic.gdx.scenes.scene2d.actions.RelativeTemporalAction;

public class RotateByAction
extends RelativeTemporalAction {
    private float amount;

    @Override
    protected void updateRelative(float f2) {
        this.target.rotateBy(this.amount * f2);
    }

    public float getAmount() {
        return this.amount;
    }

    public void setAmount(float f2) {
        this.amount = f2;
    }
}

