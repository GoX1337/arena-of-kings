/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.maps.tiled.tiles;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.IntArray;
import com.badlogic.gdx.utils.TimeUtils;

public class AnimatedTiledMapTile
implements TiledMapTile {
    private static long lastTiledMapRenderTime = 0L;
    private int id;
    private TiledMapTile.BlendMode blendMode = TiledMapTile.BlendMode.ALPHA;
    private MapProperties properties;
    private MapObjects objects;
    private StaticTiledMapTile[] frameTiles;
    private int[] animationIntervals;
    private int loopDuration;
    private static final long initialTimeOffset = TimeUtils.millis();

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void setId(int n2) {
        this.id = n2;
    }

    @Override
    public TiledMapTile.BlendMode getBlendMode() {
        return this.blendMode;
    }

    @Override
    public void setBlendMode(TiledMapTile.BlendMode blendMode) {
        this.blendMode = blendMode;
    }

    public int getCurrentFrameIndex() {
        int n2 = (int)(lastTiledMapRenderTime % (long)this.loopDuration);
        for (int i2 = 0; i2 < this.animationIntervals.length; ++i2) {
            int n3 = this.animationIntervals[i2];
            if (n2 <= n3) {
                return i2;
            }
            n2 -= n3;
        }
        throw new GdxRuntimeException("Could not determine current animation frame in AnimatedTiledMapTile.  This should never happen.");
    }

    public TiledMapTile getCurrentFrame() {
        return this.frameTiles[this.getCurrentFrameIndex()];
    }

    @Override
    public TextureRegion getTextureRegion() {
        return this.getCurrentFrame().getTextureRegion();
    }

    @Override
    public void setTextureRegion(TextureRegion textureRegion) {
        throw new GdxRuntimeException("Cannot set the texture region of AnimatedTiledMapTile.");
    }

    @Override
    public float getOffsetX() {
        return this.getCurrentFrame().getOffsetX();
    }

    @Override
    public void setOffsetX(float f2) {
        throw new GdxRuntimeException("Cannot set offset of AnimatedTiledMapTile.");
    }

    @Override
    public float getOffsetY() {
        return this.getCurrentFrame().getOffsetY();
    }

    @Override
    public void setOffsetY(float f2) {
        throw new GdxRuntimeException("Cannot set offset of AnimatedTiledMapTile.");
    }

    public int[] getAnimationIntervals() {
        return this.animationIntervals;
    }

    public void setAnimationIntervals(int[] nArray) {
        if (nArray.length == this.animationIntervals.length) {
            this.animationIntervals = nArray;
            this.loopDuration = 0;
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                this.loopDuration += nArray[i2];
            }
        } else {
            throw new GdxRuntimeException("Cannot set " + nArray.length + " frame intervals. The given int[] must have a size of " + this.animationIntervals.length + ".");
        }
    }

    @Override
    public MapProperties getProperties() {
        if (this.properties == null) {
            this.properties = new MapProperties();
        }
        return this.properties;
    }

    @Override
    public MapObjects getObjects() {
        if (this.objects == null) {
            this.objects = new MapObjects();
        }
        return this.objects;
    }

    public static void updateAnimationBaseTime() {
        lastTiledMapRenderTime = TimeUtils.millis() - initialTimeOffset;
    }

    public AnimatedTiledMapTile(float f2, Array<StaticTiledMapTile> array) {
        this.frameTiles = new StaticTiledMapTile[array.size];
        this.loopDuration = array.size * (int)(f2 * 1000.0f);
        this.animationIntervals = new int[array.size];
        for (int i2 = 0; i2 < array.size; ++i2) {
            this.frameTiles[i2] = array.get(i2);
            this.animationIntervals[i2] = (int)(f2 * 1000.0f);
        }
    }

    public AnimatedTiledMapTile(IntArray intArray, Array<StaticTiledMapTile> array) {
        this.frameTiles = new StaticTiledMapTile[array.size];
        this.animationIntervals = intArray.toArray();
        this.loopDuration = 0;
        for (int i2 = 0; i2 < intArray.size; ++i2) {
            this.frameTiles[i2] = array.get(i2);
            this.loopDuration += intArray.get(i2);
        }
    }

    public StaticTiledMapTile[] getFrameTiles() {
        return this.frameTiles;
    }
}

