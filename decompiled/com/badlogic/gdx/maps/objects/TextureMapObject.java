/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.maps.objects;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.MapObject;

public class TextureMapObject
extends MapObject {
    private float x = 0.0f;
    private float y = 0.0f;
    private float originX = 0.0f;
    private float originY = 0.0f;
    private float scaleX = 1.0f;
    private float scaleY = 1.0f;
    private float rotation = 0.0f;
    private TextureRegion textureRegion = null;

    public float getX() {
        return this.x;
    }

    public void setX(float f2) {
        this.x = f2;
    }

    public float getY() {
        return this.y;
    }

    public void setY(float f2) {
        this.y = f2;
    }

    public float getOriginX() {
        return this.originX;
    }

    public void setOriginX(float f2) {
        this.originX = f2;
    }

    public float getOriginY() {
        return this.originY;
    }

    public void setOriginY(float f2) {
        this.originY = f2;
    }

    public float getScaleX() {
        return this.scaleX;
    }

    public void setScaleX(float f2) {
        this.scaleX = f2;
    }

    public float getScaleY() {
        return this.scaleY;
    }

    public void setScaleY(float f2) {
        this.scaleY = f2;
    }

    public float getRotation() {
        return this.rotation;
    }

    public void setRotation(float f2) {
        this.rotation = f2;
    }

    public TextureRegion getTextureRegion() {
        return this.textureRegion;
    }

    public void setTextureRegion(TextureRegion textureRegion) {
        this.textureRegion = textureRegion;
    }

    public TextureMapObject() {
        this(null);
    }

    public TextureMapObject(TextureRegion textureRegion) {
        this.textureRegion = textureRegion;
    }
}

