/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.scenes.scene2d.actions;

import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.actions.TemporalAction;
import com.badlogic.gdx.utils.Null;

public class FloatAction
extends TemporalAction {
    private float start;
    private float end;
    private float value;

    public FloatAction() {
        this.start = 0.0f;
        this.end = 1.0f;
    }

    public FloatAction(float f2, float f3) {
        this.start = f2;
        this.end = f3;
    }

    public FloatAction(float f2, float f3, float f4) {
        super(f4);
        this.start = f2;
        this.end = f3;
    }

    public FloatAction(float f2, float f3, float f4, @Null Interpolation interpolation) {
        super(f4, interpolation);
        this.start = f2;
        this.end = f3;
    }

    @Override
    protected void begin() {
        this.value = this.start;
    }

    @Override
    protected void update(float f2) {
        this.value = f2 == 0.0f ? this.start : (f2 == 1.0f ? this.end : this.start + (this.end - this.start) * f2);
    }

    public float getValue() {
        return this.value;
    }

    public void setValue(float f2) {
        this.value = f2;
    }

    public float getStart() {
        return this.start;
    }

    public void setStart(float f2) {
        this.start = f2;
    }

    public float getEnd() {
        return this.end;
    }

    public void setEnd(float f2) {
        this.end = f2;
    }
}

