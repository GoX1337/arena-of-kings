/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.scenes.scene2d.actions;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.actions.TemporalAction;
import com.badlogic.gdx.utils.Null;

public class ColorAction
extends TemporalAction {
    private float startR;
    private float startG;
    private float startB;
    private float startA;
    @Null
    private Color color;
    private final Color end = new Color();

    @Override
    protected void begin() {
        if (this.color == null) {
            this.color = this.target.getColor();
        }
        this.startR = this.color.r;
        this.startG = this.color.g;
        this.startB = this.color.b;
        this.startA = this.color.a;
    }

    @Override
    protected void update(float f2) {
        if (f2 == 0.0f) {
            this.color.set(this.startR, this.startG, this.startB, this.startA);
        } else if (f2 == 1.0f) {
            this.color.set(this.end);
        } else {
            float f3 = this.startR + (this.end.r - this.startR) * f2;
            float f4 = this.startG + (this.end.g - this.startG) * f2;
            float f5 = this.startB + (this.end.b - this.startB) * f2;
            float f6 = this.startA + (this.end.a - this.startA) * f2;
            this.color.set(f3, f4, f5, f6);
        }
    }

    @Override
    public void reset() {
        super.reset();
        this.color = null;
    }

    @Null
    public Color getColor() {
        return this.color;
    }

    public void setColor(@Null Color color) {
        this.color = color;
    }

    public Color getEndColor() {
        return this.end;
    }

    public void setEndColor(Color color) {
        this.end.set(color);
    }
}

