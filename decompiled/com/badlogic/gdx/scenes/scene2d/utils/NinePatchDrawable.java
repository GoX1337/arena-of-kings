/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.scenes.scene2d.utils;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.scenes.scene2d.utils.BaseDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.TransformDrawable;

public class NinePatchDrawable
extends BaseDrawable
implements TransformDrawable {
    private NinePatch patch;

    public NinePatchDrawable() {
    }

    public NinePatchDrawable(NinePatch ninePatch) {
        this.setPatch(ninePatch);
    }

    public NinePatchDrawable(NinePatchDrawable ninePatchDrawable) {
        super(ninePatchDrawable);
        this.patch = ninePatchDrawable.patch;
    }

    @Override
    public void draw(Batch batch, float f2, float f3, float f4, float f5) {
        this.patch.draw(batch, f2, f3, f4, f5);
    }

    @Override
    public void draw(Batch batch, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        this.patch.draw(batch, f2, f3, f4, f5, f6, f7, f8, f9, f10);
    }

    public void setPatch(NinePatch ninePatch) {
        this.patch = ninePatch;
        if (ninePatch != null) {
            this.setMinWidth(ninePatch.getTotalWidth());
            this.setMinHeight(ninePatch.getTotalHeight());
            this.setTopHeight(ninePatch.getPadTop());
            this.setRightWidth(ninePatch.getPadRight());
            this.setBottomHeight(ninePatch.getPadBottom());
            this.setLeftWidth(ninePatch.getPadLeft());
        }
    }

    public NinePatch getPatch() {
        return this.patch;
    }

    public NinePatchDrawable tint(Color color) {
        NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(this);
        ninePatchDrawable.patch = new NinePatch(ninePatchDrawable.getPatch(), color);
        return ninePatchDrawable;
    }
}

