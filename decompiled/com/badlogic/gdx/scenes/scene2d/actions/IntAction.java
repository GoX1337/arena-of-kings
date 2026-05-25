/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.scenes.scene2d.actions;

import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.actions.TemporalAction;
import com.badlogic.gdx.utils.Null;

public class IntAction
extends TemporalAction {
    private int start;
    private int end;
    private int value;

    public IntAction() {
        this.start = 0;
        this.end = 1;
    }

    public IntAction(int n2, int n3) {
        this.start = n2;
        this.end = n3;
    }

    public IntAction(int n2, int n3, float f2) {
        super(f2);
        this.start = n2;
        this.end = n3;
    }

    public IntAction(int n2, int n3, float f2, @Null Interpolation interpolation) {
        super(f2, interpolation);
        this.start = n2;
        this.end = n3;
    }

    @Override
    protected void begin() {
        this.value = this.start;
    }

    @Override
    protected void update(float f2) {
        this.value = f2 == 0.0f ? this.start : (f2 == 1.0f ? this.end : (int)((float)this.start + (float)(this.end - this.start) * f2));
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int n2) {
        this.value = n2;
    }

    public int getStart() {
        return this.start;
    }

    public void setStart(int n2) {
        this.start = n2;
    }

    public int getEnd() {
        return this.end;
    }

    public void setEnd(int n2) {
        this.end = n2;
    }
}

