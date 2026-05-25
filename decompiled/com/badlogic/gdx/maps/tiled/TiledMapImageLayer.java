/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.maps.tiled;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.MapLayer;

public class TiledMapImageLayer
extends MapLayer {
    private TextureRegion region;
    private float x;
    private float y;

    public TiledMapImageLayer(TextureRegion textureRegion, float f2, float f3) {
        this.region = textureRegion;
        this.x = f2;
        this.y = f3;
    }

    public TextureRegion getTextureRegion() {
        return this.region;
    }

    public void setTextureRegion(TextureRegion textureRegion) {
        this.region = textureRegion;
    }

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
}

