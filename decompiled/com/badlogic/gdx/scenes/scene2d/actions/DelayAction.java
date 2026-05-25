/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.scenes.scene2d.actions;

import com.badlogic.gdx.scenes.scene2d.actions.DelegateAction;

public class DelayAction
extends DelegateAction {
    private float duration;
    private float time;

    public DelayAction() {
    }

    public DelayAction(float f2) {
        this.duration = f2;
    }

    @Override
    protected boolean delegate(float f2) {
        if (this.time < this.duration) {
            this.time += f2;
            if (this.time < this.duration) {
                return false;
            }
            f2 = this.time - this.duration;
        }
        if (this.action == null) {
            return true;
        }
        return this.action.act(f2);
    }

    public void finish() {
        this.time = this.duration;
    }

    @Override
    public void restart() {
        super.restart();
        this.time = 0.0f;
    }

    public float getTime() {
        return this.time;
    }

    public void setTime(float f2) {
        this.time = f2;
    }

    public float getDuration() {
        return this.duration;
    }

    public void setDuration(float f2) {
        this.duration = f2;
    }
}

