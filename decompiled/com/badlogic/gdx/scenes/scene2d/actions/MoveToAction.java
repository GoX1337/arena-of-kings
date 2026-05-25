/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.scenes.scene2d.actions;

import com.badlogic.gdx.scenes.scene2d.actions.TemporalAction;

public class MoveToAction
extends TemporalAction {
    private float startX;
    private float startY;
    private float endX;
    private float endY;
    private int alignment = 12;

    @Override
    protected void begin() {
        this.startX = this.target.getX(this.alignment);
        this.startY = this.target.getY(this.alignment);
    }

    @Override
    protected void update(float f2) {
        float f3;
        float f4;
        if (f2 == 0.0f) {
            f4 = this.startX;
            f3 = this.startY;
        } else if (f2 == 1.0f) {
            f4 = this.endX;
            f3 = this.endY;
        } else {
            f4 = this.startX + (this.endX - this.startX) * f2;
            f3 = this.startY + (this.endY - this.startY) * f2;
        }
        this.target.setPosition(f4, f3, this.alignment);
    }

    @Override
    public void reset() {
        super.reset();
        this.alignment = 12;
    }

    public void setStartPosition(float f2, float f3) {
        this.startX = f2;
        this.startY = f3;
    }

    public void setPosition(float f2, float f3) {
        this.endX = f2;
        this.endY = f3;
    }

    public void setPosition(float f2, float f3, int n2) {
        this.endX = f2;
        this.endY = f3;
        this.alignment = n2;
    }

    public float getX() {
        return this.endX;
    }

    public void setX(float f2) {
        this.endX = f2;
    }

    public float getY() {
        return this.endY;
    }

    public void setY(float f2) {
        this.endY = f2;
    }

    public float getStartX() {
        return this.startX;
    }

    public float getStartY() {
        return this.startY;
    }

    public int getAlignment() {
        return this.alignment;
    }

    public void setAlignment(int n2) {
        this.alignment = n2;
    }
}

