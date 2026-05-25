/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.scenes.scene2d.actions;

import com.badlogic.gdx.scenes.scene2d.actions.TemporalAction;

public class SizeToAction
extends TemporalAction {
    private float startWidth;
    private float startHeight;
    private float endWidth;
    private float endHeight;

    @Override
    protected void begin() {
        this.startWidth = this.target.getWidth();
        this.startHeight = this.target.getHeight();
    }

    @Override
    protected void update(float f2) {
        float f3;
        float f4;
        if (f2 == 0.0f) {
            f4 = this.startWidth;
            f3 = this.startHeight;
        } else if (f2 == 1.0f) {
            f4 = this.endWidth;
            f3 = this.endHeight;
        } else {
            f4 = this.startWidth + (this.endWidth - this.startWidth) * f2;
            f3 = this.startHeight + (this.endHeight - this.startHeight) * f2;
        }
        this.target.setSize(f4, f3);
    }

    public void setSize(float f2, float f3) {
        this.endWidth = f2;
        this.endHeight = f3;
    }

    public float getWidth() {
        return this.endWidth;
    }

    public void setWidth(float f2) {
        this.endWidth = f2;
    }

    public float getHeight() {
        return this.endHeight;
    }

    public void setHeight(float f2) {
        this.endHeight = f2;
    }
}

