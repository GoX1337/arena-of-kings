/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.scenes.scene2d.utils;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.Null;
import com.badlogic.gdx.utils.reflect.ClassReflection;

public class BaseDrawable
implements Drawable {
    @Null
    private String name;
    private float leftWidth;
    private float rightWidth;
    private float topHeight;
    private float bottomHeight;
    private float minWidth;
    private float minHeight;

    public BaseDrawable() {
    }

    public BaseDrawable(Drawable drawable) {
        if (drawable instanceof BaseDrawable) {
            this.name = ((BaseDrawable)drawable).getName();
        }
        this.leftWidth = drawable.getLeftWidth();
        this.rightWidth = drawable.getRightWidth();
        this.topHeight = drawable.getTopHeight();
        this.bottomHeight = drawable.getBottomHeight();
        this.minWidth = drawable.getMinWidth();
        this.minHeight = drawable.getMinHeight();
    }

    @Override
    public void draw(Batch batch, float f2, float f3, float f4, float f5) {
    }

    @Override
    public float getLeftWidth() {
        return this.leftWidth;
    }

    @Override
    public void setLeftWidth(float f2) {
        this.leftWidth = f2;
    }

    @Override
    public float getRightWidth() {
        return this.rightWidth;
    }

    @Override
    public void setRightWidth(float f2) {
        this.rightWidth = f2;
    }

    @Override
    public float getTopHeight() {
        return this.topHeight;
    }

    @Override
    public void setTopHeight(float f2) {
        this.topHeight = f2;
    }

    @Override
    public float getBottomHeight() {
        return this.bottomHeight;
    }

    @Override
    public void setBottomHeight(float f2) {
        this.bottomHeight = f2;
    }

    public void setPadding(float f2, float f3, float f4, float f5) {
        this.setTopHeight(f2);
        this.setLeftWidth(f3);
        this.setBottomHeight(f4);
        this.setRightWidth(f5);
    }

    @Override
    public float getMinWidth() {
        return this.minWidth;
    }

    @Override
    public void setMinWidth(float f2) {
        this.minWidth = f2;
    }

    @Override
    public float getMinHeight() {
        return this.minHeight;
    }

    @Override
    public void setMinHeight(float f2) {
        this.minHeight = f2;
    }

    public void setMinSize(float f2, float f3) {
        this.setMinWidth(f2);
        this.setMinHeight(f3);
    }

    @Null
    public String getName() {
        return this.name;
    }

    public void setName(@Null String string) {
        this.name = string;
    }

    @Null
    public String toString() {
        if (this.name == null) {
            return ClassReflection.getSimpleName(this.getClass());
        }
        return this.name;
    }
}

