/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.scenes.scene2d.actions;

import com.badlogic.gdx.scenes.scene2d.actions.RelativeTemporalAction;

public class SizeByAction
extends RelativeTemporalAction {
    private float amountWidth;
    private float amountHeight;

    @Override
    protected void updateRelative(float f2) {
        this.target.sizeBy(this.amountWidth * f2, this.amountHeight * f2);
    }

    public void setAmount(float f2, float f3) {
        this.amountWidth = f2;
        this.amountHeight = f3;
    }

    public float getAmountWidth() {
        return this.amountWidth;
    }

    public void setAmountWidth(float f2) {
        this.amountWidth = f2;
    }

    public float getAmountHeight() {
        return this.amountHeight;
    }

    public void setAmountHeight(float f2) {
        this.amountHeight = f2;
    }
}

