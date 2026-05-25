/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.WidgetGroup;
import com.badlogic.gdx.scenes.scene2d.utils.Layout;
import com.badlogic.gdx.utils.SnapshotArray;

public class Stack
extends WidgetGroup {
    private float prefWidth;
    private float prefHeight;
    private float minWidth;
    private float minHeight;
    private float maxWidth;
    private float maxHeight;
    private boolean sizeInvalid = true;

    public Stack() {
        this.setTransform(false);
        this.setWidth(150.0f);
        this.setHeight(150.0f);
        this.setTouchable(Touchable.childrenOnly);
    }

    public Stack(Actor ... actorArray) {
        this();
        for (Actor actor : actorArray) {
            this.addActor(actor);
        }
    }

    @Override
    public void invalidate() {
        super.invalidate();
        this.sizeInvalid = true;
    }

    private void computeSize() {
        this.sizeInvalid = false;
        this.prefWidth = 0.0f;
        this.prefHeight = 0.0f;
        this.minWidth = 0.0f;
        this.minHeight = 0.0f;
        this.maxWidth = 0.0f;
        this.maxHeight = 0.0f;
        SnapshotArray<Actor> snapshotArray = this.getChildren();
        int n2 = snapshotArray.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            float f2;
            float f3;
            Actor actor = (Actor)snapshotArray.get(i2);
            if (actor instanceof Layout) {
                Layout layout = (Layout)((Object)actor);
                this.prefWidth = Math.max(this.prefWidth, layout.getPrefWidth());
                this.prefHeight = Math.max(this.prefHeight, layout.getPrefHeight());
                this.minWidth = Math.max(this.minWidth, layout.getMinWidth());
                this.minHeight = Math.max(this.minHeight, layout.getMinHeight());
                f3 = layout.getMaxWidth();
                f2 = layout.getMaxHeight();
            } else {
                this.prefWidth = Math.max(this.prefWidth, actor.getWidth());
                this.prefHeight = Math.max(this.prefHeight, actor.getHeight());
                this.minWidth = Math.max(this.minWidth, actor.getWidth());
                this.minHeight = Math.max(this.minHeight, actor.getHeight());
                f3 = 0.0f;
                f2 = 0.0f;
            }
            if (f3 > 0.0f) {
                float f4 = this.maxWidth = this.maxWidth == 0.0f ? f3 : Math.min(this.maxWidth, f3);
            }
            if (!(f2 > 0.0f)) continue;
            this.maxHeight = this.maxHeight == 0.0f ? f2 : Math.min(this.maxHeight, f2);
        }
    }

    public void add(Actor actor) {
        this.addActor(actor);
    }

    @Override
    public void layout() {
        if (this.sizeInvalid) {
            this.computeSize();
        }
        float f2 = this.getWidth();
        float f3 = this.getHeight();
        SnapshotArray<Actor> snapshotArray = this.getChildren();
        int n2 = snapshotArray.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            Actor actor = (Actor)snapshotArray.get(i2);
            actor.setBounds(0.0f, 0.0f, f2, f3);
            if (!(actor instanceof Layout)) continue;
            ((Layout)((Object)actor)).validate();
        }
    }

    @Override
    public float getPrefWidth() {
        if (this.sizeInvalid) {
            this.computeSize();
        }
        return this.prefWidth;
    }

    @Override
    public float getPrefHeight() {
        if (this.sizeInvalid) {
            this.computeSize();
        }
        return this.prefHeight;
    }

    @Override
    public float getMinWidth() {
        if (this.sizeInvalid) {
            this.computeSize();
        }
        return this.minWidth;
    }

    @Override
    public float getMinHeight() {
        if (this.sizeInvalid) {
            this.computeSize();
        }
        return this.minHeight;
    }

    @Override
    public float getMaxWidth() {
        if (this.sizeInvalid) {
            this.computeSize();
        }
        return this.maxWidth;
    }

    @Override
    public float getMaxHeight() {
        if (this.sizeInvalid) {
            this.computeSize();
        }
        return this.maxHeight;
    }
}

