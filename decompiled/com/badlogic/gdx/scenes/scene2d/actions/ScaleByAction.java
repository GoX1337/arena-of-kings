/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.scenes.scene2d.actions;

import com.badlogic.gdx.scenes.scene2d.actions.RelativeTemporalAction;

public class ScaleByAction
extends RelativeTemporalAction {
    private float amountX;
    private float amountY;

    @Override
    protected void updateRelative(float f2) {
        this.target.scaleBy(this.amountX * f2, this.amountY * f2);
    }

    public void setAmount(float f2, float f3) {
        this.amountX = f2;
        this.amountY = f3;
    }

    public void setAmount(float f2) {
        this.amountX = f2;
        this.amountY = f2;
    }

    public float getAmountX() {
        return this.amountX;
    }

    public void setAmountX(float f2) {
        this.amountX = f2;
    }

    public float getAmountY() {
        return this.amountY;
    }

    public void setAmountY(float f2) {
        this.amountY = f2;
    }
}

