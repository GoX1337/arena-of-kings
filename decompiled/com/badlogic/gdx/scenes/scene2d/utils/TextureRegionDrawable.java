/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.scenes.scene2d.utils;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.utils.BaseDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.TransformDrawable;

public class TextureRegionDrawable
extends BaseDrawable
implements TransformDrawable {
    private TextureRegion region;

    public TextureRegionDrawable() {
    }

    public TextureRegionDrawable(Texture texture) {
        this.setRegion(new TextureRegion(texture));
    }

    public TextureRegionDrawable(TextureRegion textureRegion) {
        this.setRegion(textureRegion);
    }

    public TextureRegionDrawable(TextureRegionDrawable textureRegionDrawable) {
        super(textureRegionDrawable);
        this.setRegion(textureRegionDrawable.region);
    }

    @Override
    public void draw(Batch batch, float f2, float f3, float f4, float f5) {
        batch.draw(this.region, f2, f3, f4, f5);
    }

    @Override
    public void draw(Batch batch, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        batch.draw(this.region, f2, f3, f4, f5, f6, f7, f8, f9, f10);
    }

    public void setRegion(TextureRegion textureRegion) {
        this.region = textureRegion;
        if (textureRegion != null) {
            this.setMinWidth(textureRegion.getRegionWidth());
            this.setMinHeight(textureRegion.getRegionHeight());
        }
    }

    public TextureRegion getRegion() {
        return this.region;
    }

    public Drawable tint(Color color) {
        Sprite sprite = this.region instanceof TextureAtlas.AtlasRegion ? new TextureAtlas.AtlasSprite((TextureAtlas.AtlasRegion)this.region) : new Sprite(this.region);
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

