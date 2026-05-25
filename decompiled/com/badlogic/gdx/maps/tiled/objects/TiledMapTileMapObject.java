/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.maps.tiled.objects;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.objects.TextureMapObject;
import com.badlogic.gdx.maps.tiled.TiledMapTile;

public class TiledMapTileMapObject
extends TextureMapObject {
    private boolean flipHorizontally;
    private boolean flipVertically;
    private TiledMapTile tile;

    public TiledMapTileMapObject(TiledMapTile tiledMapTile, boolean bl2, boolean bl3) {
        this.flipHorizontally = bl2;
        this.flipVertically = bl3;
        this.tile = tiledMapTile;
        TextureRegion textureRegion = new TextureRegion(tiledMapTile.getTextureRegion());
        textureRegion.flip(bl2, bl3);
        this.setTextureRegion(textureRegion);
    }

    public boolean isFlipHorizontally() {
        return this.flipHorizontally;
    }

    public void setFlipHorizontally(boolean bl2) {
        this.flipHorizontally = bl2;
    }

    public boolean isFlipVertically() {
        return this.flipVertically;
    }

    public void setFlipVertically(boolean bl2) {
        this.flipVertically = bl2;
    }

    public TiledMapTile getTile() {
        return this.tile;
    }

    public void setTile(TiledMapTile tiledMapTile) {
        this.tile = tiledMapTile;
    }
}

