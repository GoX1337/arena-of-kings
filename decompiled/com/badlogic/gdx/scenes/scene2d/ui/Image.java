/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Widget;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.TransformDrawable;
import com.badlogic.gdx.utils.Null;
import com.badlogic.gdx.utils.Scaling;

public class Image
extends Widget {
    private Scaling scaling;
    private int align = 1;
    private float imageX;
    private float imageY;
    private float imageWidth;
    private float imageHeight;
    private Drawable drawable;

    public Image() {
        this((Drawable)null);
    }

    public Image(@Null NinePatch ninePatch) {
        this(new NinePatchDrawable(ninePatch), Scaling.stretch, 1);
    }

    public Image(@Null TextureRegion textureRegion) {
        this(new TextureRegionDrawable(textureRegion), Scaling.stretch, 1);
    }

    public Image(Texture texture) {
        this(new TextureRegionDrawable(new TextureRegion(texture)));
    }

    public Image(Skin skin, String string) {
        this(skin.getDrawable(string), Scaling.stretch, 1);
    }

    public Image(@Null Drawable drawable) {
        this(drawable, Scaling.stretch, 1);
    }

    public Image(@Null Drawable drawable, Scaling scaling) {
        this(drawable, scaling, 1);
    }

    public Image(@Null Drawable drawable, Scaling scaling, int n2) {
        this.setDrawable(drawable);
        this.scaling = scaling;
        this.align = n2;
        this.setSize(this.getPrefWidth(), this.getPrefHeight());
    }

    @Override
    public void layout() {
        if (this.drawable == null) {
            return;
        }
        float f2 = this.drawable.getMinWidth();
        float f3 = this.drawable.getMinHeight();
        float f4 = this.getWidth();
        float f5 = this.getHeight();
        Vector2 vector2 = this.scaling.apply(f2, f3, f4, f5);
        this.imageWidth = vector2.x;
        this.imageHeight = vector2.y;
        this.imageX = (this.align & 8) != 0 ? 0.0f : ((this.align & 0x10) != 0 ? (float)((int)(f4 - this.imageWidth)) : (float)((int)(f4 / 2.0f - this.imageWidth / 2.0f)));
        this.imageY = (this.align & 2) != 0 ? (float)((int)(f5 - this.imageHeight)) : ((this.align & 4) != 0 ? 0.0f : (float)((int)(f5 / 2.0f - this.imageHeight / 2.0f)));
    }

    @Override
    public void draw(Batch batch, float f2) {
        this.validate();
        Color color = this.getColor();
        batch.setColor(color.r, color.g, color.b, color.a * f2);
        float f3 = this.getX();
        float f4 = this.getY();
        float f5 = this.getScaleX();
        float f6 = this.getScaleY();
        if (this.drawable instanceof TransformDrawable) {
            float f7 = this.getRotation();
            if (f5 != 1.0f || f6 != 1.0f || f7 != 0.0f) {
                ((TransformDrawable)this.drawable).draw(batch, f3 + this.imageX, f4 + this.imageY, this.getOriginX() - this.imageX, this.getOriginY() - this.imageY, this.imageWidth, this.imageHeight, f5, f6, f7);
                return;
            }
        }
        if (this.drawable != null) {
            this.drawable.draw(batch, f3 + this.imageX, f4 + this.imageY, this.imageWidth * f5, this.imageHeight * f6);
        }
    }

    public void setDrawable(Skin skin, String string) {
        this.setDrawable(skin.getDrawable(string));
    }

    public void setDrawable(@Null Drawable drawable) {
        if (this.drawable == drawable) {
            return;
        }
        if (drawable != null) {
            if (this.getPrefWidth() != drawable.getMinWidth() || this.getPrefHeight() != drawable.getMinHeight()) {
                this.invalidateHierarchy();
            }
        } else {
            this.invalidateHierarchy();
        }
        this.drawable = drawable;
    }

    @Null
    public Drawable getDrawable() {
        return this.drawable;
    }

    public void setScaling(Scaling scaling) {
        if (scaling == null) {
            throw new IllegalArgumentException("scaling cannot be null.");
        }
        this.scaling = scaling;
        this.invalidate();
    }

    public void setAlign(int n2) {
        this.align = n2;
        this.invalidate();
    }

    public int getAlign() {
        return this.align;
    }

    @Override
    public float getMinWidth() {
        return 0.0f;
    }

    @Override
    public float getMinHeight() {
        return 0.0f;
    }

    @Override
    public float getPrefWidth() {
        if (this.drawable != null) {
            return this.drawable.getMinWidth();
        }
        return 0.0f;
    }

    @Override
    public float getPrefHeight() {
        if (this.drawable != null) {
            return this.drawable.getMinHeight();
        }
        return 0.0f;
    }

    public float getImageX() {
        return this.imageX;
    }

    public float getImageY() {
        return this.imageY;
    }

    public float getImageWidth() {
        return this.imageWidth;
    }

    public float getImageHeight() {
        return this.imageHeight;
    }

    @Override
    public String toString() {
        String string = this.getName();
        if (string != null) {
            return string;
        }
        String string2 = this.getClass().getName();
        int n2 = string2.lastIndexOf(46);
        if (n2 != -1) {
            string2 = string2.substring(n2 + 1);
        }
        return (string2.indexOf(36) != -1 ? "Image " : "") + string2 + ": " + this.drawable;
    }
}

