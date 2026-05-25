/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.scenes.scene2d.utils;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class TiledDrawable
extends TextureRegionDrawable {
    private final Color color = new Color(1.0f, 1.0f, 1.0f, 1.0f);
    private float scale = 1.0f;

    public TiledDrawable() {
    }

    public TiledDrawable(TextureRegion textureRegion) {
        super(textureRegion);
    }

    public TiledDrawable(TextureRegionDrawable textureRegionDrawable) {
        super(textureRegionDrawable);
    }

    @Override
    public void draw(Batch batch, float f2, float f3, float f4, float f5) {
        int n2;
        float f6;
        float f7;
        float f8 = batch.getPackedColor();
        batch.setColor(batch.getColor().mul(this.color));
        TextureRegion textureRegion = this.getRegion();
        float f9 = (float)textureRegion.getRegionWidth() * this.scale;
        float f10 = (float)textureRegion.getRegionHeight() * this.scale;
        int n3 = (int)(f4 / f9);
        int n4 = (int)(f5 / f10);
        float f11 = f4 - f9 * (float)n3;
        float f12 = f5 - f10 * (float)n4;
        float f13 = f2;
        float f14 = f3;
        float f15 = f2 + f4 - f11;
        float f16 = f3 + f5 - f12;
        for (int i2 = 0; i2 < n3; ++i2) {
            f3 = f14;
            for (int i3 = 0; i3 < n4; ++i3) {
                batch.draw(textureRegion, f2, f3, f9, f10);
                f3 += f10;
            }
            f2 += f9;
        }
        Texture texture = textureRegion.getTexture();
        float f17 = textureRegion.getU();
        float f18 = textureRegion.getV2();
        if (f11 > 0.0f) {
            f7 = f17 + f11 / ((float)texture.getWidth() * this.scale);
            f6 = textureRegion.getV();
            f3 = f14;
            for (n2 = 0; n2 < n4; ++n2) {
                batch.draw(texture, f2, f3, f11, f10, f17, f18, f7, f6);
                f3 += f10;
            }
            if (f12 > 0.0f) {
                f6 = f18 - f12 / ((float)texture.getHeight() * this.scale);
                batch.draw(texture, f2, f3, f11, f12, f17, f18, f7, f6);
            }
        }
        if (f12 > 0.0f) {
            f7 = textureRegion.getU2();
            f6 = f18 - f12 / ((float)texture.getHeight() * this.scale);
            f2 = f13;
            for (n2 = 0; n2 < n3; ++n2) {
                batch.draw(texture, f2, f3, f9, f12, f17, f18, f7, f6);
                f2 += f9;
            }
        }
        batch.setPackedColor(f8);
    }

    @Override
    public void draw(Batch batch, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        throw new UnsupportedOperationException();
    }

    public Color getColor() {
        return this.color;
    }

    public void setScale(float f2) {
        this.scale = f2;
    }

    public float getScale() {
        return this.scale;
    }

    @Override
    public TiledDrawable tint(Color color) {
        TiledDrawable tiledDrawable = new TiledDrawable(this);
        tiledDrawable.color.set(color);
        tiledDrawable.setLeftWidth(this.getLeftWidth());
        tiledDrawable.setRightWidth(this.getRightWidth());
        tiledDrawable.setTopHeight(this.getTopHeight());
        tiledDrawable.setBottomHeight(this.getBottomHeight());
        return tiledDrawable;
    }
}

