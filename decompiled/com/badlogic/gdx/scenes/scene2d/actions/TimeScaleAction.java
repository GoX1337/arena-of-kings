/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.scenes.scene2d.actions;

import com.badlogic.gdx.scenes.scene2d.actions.DelegateAction;

public class TimeScaleAction
extends DelegateAction {
    private float scale;

    @Override
    protected boolean delegate(float f2) {
        if (this.action == null) {
            return true;
        }
        return this.action.act(f2 * this.scale);
    }

    public float getScale() {
        return this.scale;
    }

    public void setScale(float f2) {
        this.scale = f2;
    }
}

