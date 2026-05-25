/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.Layout;

public class Widget
extends Actor
implements Layout {
    private boolean needsLayout = true;
    private boolean fillParent;
    private boolean layoutEnabled = true;

    @Override
    public float getMinWidth() {
        return this.getPrefWidth();
    }

    @Override
    public float getMinHeight() {
        return this.getPrefHeight();
    }

    @Override
    public float getPrefWidth() {
        return 0.0f;
    }

    @Override
    public float getPrefHeight() {
        return 0.0f;
    }

    @Override
    public float getMaxWidth() {
        return 0.0f;
    }

    @Override
    public float getMaxHeight() {
        return 0.0f;
    }

    @Override
    public void setLayoutEnabled(boolean bl2) {
        this.layoutEnabled = bl2;
        if (bl2) {
            this.invalidateHierarchy();
        }
    }

    @Override
    public void validate() {
        if (!this.layoutEnabled) {
            return;
        }
        Group group = this.getParent();
        if (this.fillParent && group != null) {
            float f2;
            float f3;
            Stage stage = this.getStage();
            if (stage != null && group == stage.getRoot()) {
                f3 = stage.getWidth();
                f2 = stage.getHeight();
            } else {
                f3 = group.getWidth();
                f2 = group.getHeight();
            }
            this.setSize(f3, f2);
        }
        if (!this.needsLayout) {
            return;
        }
        this.needsLayout = false;
        this.layout();
    }

    public boolean needsLayout() {
        return this.needsLayout;
    }

    @Override
    public void invalidate() {
        this.needsLayout = true;
    }

    @Override
    public void invalidateHierarchy() {
        if (!this.layoutEnabled) {
            return;
        }
        this.invalidate();
        Group group = this.getParent();
        if (group instanceof Layout) {
            ((Layout)((Object)group)).invalidateHierarchy();
        }
    }

    @Override
    public void sizeChanged() {
        this.invalidate();
    }

    @Override
    public void pack() {
        this.setSize(this.getPrefWidth(), this.getPrefHeight());
        this.validate();
    }

    @Override
    public void setFillParent(boolean bl2) {
        this.fillParent = bl2;
    }

    @Override
    public void draw(Batch batch, float f2) {
        this.validate();
    }

    @Override
    public void layout() {
    }
}

