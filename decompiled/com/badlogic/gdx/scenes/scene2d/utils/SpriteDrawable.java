/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.scenes.scene2d.utils;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.utils.BaseDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.TransformDrawable;

public class SpriteDrawable
extends BaseDrawable
implements TransformDrawable {
    private Sprite sprite;

    public SpriteDrawable() {
    }

    public SpriteDrawable(Sprite sprite) {
        this.setSprite(sprite);
    }

    public SpriteDrawable(SpriteDrawable spriteDrawable) {
        super(spriteDrawable);
        this.setSprite(spriteDrawable.sprite);
    }

    @Override
    public void draw(Batch batch, float f2, float f3, float f4, float f5) {
        Color color = this.sprite.getColor();
        float f6 = color.toFloatBits();
        this.sprite.setColor(color.mul(batch.getColor()));
        this.sprite.setRotation(0.0f);
        this.sprite.setScale(1.0f, 1.0f);
        this.sprite.setBounds(f2, f3, f4, f5);
        this.sprite.draw(batch);
        this.sprite.setPackedColor(f6);
    }

    @Override
    public void draw(Batch batch, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        Color color = this.sprite.getColor();
        float f11 = color.toFloatBits();
        this.sprite.setColor(color.mul(batch.getColor()));
        this.sprite.setOrigin(f4, f5);
        this.sprite.setRotation(f10);
        this.sprite.setScale(f8, f9);
        this.sprite.setBounds(f2, f3, f6, f7);
        this.sprite.draw(batch);
        this.sprite.setPackedColor(f11);
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
        this.setMinWidth(sprite.getWidth());
        this.setMinHeight(sprite.getHeight());
    }

    public Sprite getSprite() {
        return this.sprite;
    }

    public SpriteDrawable tint(Color color) {
        Sprite sprite = this.sprite instanceof TextureAtlas.AtlasSprite ? new TextureAtlas.AtlasSprite((TextureAtlas.AtlasSprite)this.sprite) : new Sprite(this.sprite);
        sprite.setColor(color);
        sprite.setSize(this.getMinWidth(), this.getMinHeight());
        SpriteDrawable spriteDrawable = new SpriteDrawable(sprite);
        spriteDrawable.setLeftWidth(this.getLeftWidth());
        spriteDrawable.setRightWidth(this.getRightWidth());
        spriteDrawable.setTopHeight(this.getTopHeight());
        spriteDrawable.setBottomHeight(this.getBottomHeight());
        return spriteDrawable;
    }
}

