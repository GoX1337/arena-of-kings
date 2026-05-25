/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.maps.tiled.renderers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteCache;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapLayers;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapImageLayer;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Disposable;

public class OrthoCachedTiledMapRenderer
implements TiledMapRenderer,
Disposable {
    private static final float tolerance = 1.0E-5f;
    protected static final int NUM_VERTICES = 20;
    protected final TiledMap map;
    protected final SpriteCache spriteCache;
    protected final float[] vertices = new float[20];
    protected boolean blending;
    protected float unitScale;
    protected final Rectangle viewBounds = new Rectangle();
    protected final Rectangle cacheBounds = new Rectangle();
    protected float overCache = 0.5f;
    protected float maxTileWidth;
    protected float maxTileHeight;
    protected boolean cached;
    protected int count;
    protected boolean canCacheMoreN;
    protected boolean canCacheMoreE;
    protected boolean canCacheMoreW;
    protected boolean canCacheMoreS;

    public OrthoCachedTiledMapRenderer(TiledMap tiledMap) {
        this(tiledMap, 1.0f, 2000);
    }

    public OrthoCachedTiledMapRenderer(TiledMap tiledMap, float f2) {
        this(tiledMap, f2, 2000);
    }

    public OrthoCachedTiledMapRenderer(TiledMap tiledMap, float f2, int n2) {
        this.map = tiledMap;
        this.unitScale = f2;
        this.spriteCache = new SpriteCache(n2, true);
    }

    @Override
    public void setView(OrthographicCamera orthographicCamera) {
        this.spriteCache.setProjectionMatrix(orthographicCamera.combined);
        float f2 = orthographicCamera.viewportWidth * orthographicCamera.zoom + this.maxTileWidth * 2.0f * this.unitScale;
        float f3 = orthographicCamera.viewportHeight * orthographicCamera.zoom + this.maxTileHeight * 2.0f * this.unitScale;
        this.viewBounds.set(orthographicCamera.position.x - f2 / 2.0f, orthographicCamera.position.y - f3 / 2.0f, f2, f3);
        if (this.canCacheMoreW && this.viewBounds.x < this.cacheBounds.x - 1.0E-5f || this.canCacheMoreS && this.viewBounds.y < this.cacheBounds.y - 1.0E-5f || this.canCacheMoreE && this.viewBounds.x + this.viewBounds.width > this.cacheBounds.x + this.cacheBounds.width + 1.0E-5f || this.canCacheMoreN && this.viewBounds.y + this.viewBounds.height > this.cacheBounds.y + this.cacheBounds.height + 1.0E-5f) {
            this.cached = false;
        }
    }

    @Override
    public void setView(Matrix4 matrix4, float f2, float f3, float f4, float f5) {
        this.spriteCache.setProjectionMatrix(matrix4);
        this.viewBounds.set(f2 -= this.maxTileWidth * this.unitScale, f3 -= this.maxTileHeight * this.unitScale, f4 += this.maxTileWidth * 2.0f * this.unitScale, f5 += this.maxTileHeight * 2.0f * this.unitScale);
        if (this.canCacheMoreW && this.viewBounds.x < this.cacheBounds.x - 1.0E-5f || this.canCacheMoreS && this.viewBounds.y < this.cacheBounds.y - 1.0E-5f || this.canCacheMoreE && this.viewBounds.x + this.viewBounds.width > this.cacheBounds.x + this.cacheBounds.width + 1.0E-5f || this.canCacheMoreN && this.viewBounds.y + this.viewBounds.height > this.cacheBounds.y + this.cacheBounds.height + 1.0E-5f) {
            this.cached = false;
        }
    }

    @Override
    public void render() {
        if (!this.cached) {
            this.cached = true;
            this.count = 0;
            this.spriteCache.clear();
            float f2 = this.viewBounds.width * this.overCache;
            float f3 = this.viewBounds.height * this.overCache;
            this.cacheBounds.x = this.viewBounds.x - f2;
            this.cacheBounds.y = this.viewBounds.y - f3;
            this.cacheBounds.width = this.viewBounds.width + f2 * 2.0f;
            this.cacheBounds.height = this.viewBounds.height + f3 * 2.0f;
            for (MapLayer mapLayer : this.map.getLayers()) {
                this.spriteCache.beginCache();
                if (mapLayer instanceof TiledMapTileLayer) {
                    this.renderTileLayer((TiledMapTileLayer)mapLayer);
                } else if (mapLayer instanceof TiledMapImageLayer) {
                    this.renderImageLayer((TiledMapImageLayer)mapLayer);
                }
                this.spriteCache.endCache();
            }
        }
        if (this.blending) {
            Gdx.gl.glEnable(3042);
            Gdx.gl.glBlendFunc(770, 771);
        }
        this.spriteCache.begin();
        MapLayers mapLayers = this.map.getLayers();
        int n2 = mapLayers.getCount();
        for (int i2 = 0; i2 < n2; ++i2) {
            MapLayer mapLayer;
            mapLayer = mapLayers.get(i2);
            if (!mapLayer.isVisible()) continue;
            this.spriteCache.draw(i2);
            this.renderObjects(mapLayer);
        }
        this.spriteCache.end();
        if (this.blending) {
            Gdx.gl.glDisable(3042);
        }
    }

    @Override
    public void render(int[] nArray) {
        if (!this.cached) {
            this.cached = true;
            this.count = 0;
            this.spriteCache.clear();
            float f2 = this.viewBounds.width * this.overCache;
            float f3 = this.viewBounds.height * this.overCache;
            this.cacheBounds.x = this.viewBounds.x - f2;
            this.cacheBounds.y = this.viewBounds.y - f3;
            this.cacheBounds.width = this.viewBounds.width + f2 * 2.0f;
            this.cacheBounds.height = this.viewBounds.height + f3 * 2.0f;
            for (MapLayer mapLayer : this.map.getLayers()) {
                this.spriteCache.beginCache();
                if (mapLayer instanceof TiledMapTileLayer) {
                    this.renderTileLayer((TiledMapTileLayer)mapLayer);
                } else if (mapLayer instanceof TiledMapImageLayer) {
                    this.renderImageLayer((TiledMapImageLayer)mapLayer);
                }
                this.spriteCache.endCache();
            }
        }
        if (this.blending) {
            Gdx.gl.glEnable(3042);
            Gdx.gl.glBlendFunc(770, 771);
        }
        this.spriteCache.begin();
        MapLayers mapLayers = this.map.getLayers();
        for (int n2 : nArray) {
            MapLayer mapLayer = mapLayers.get(n2);
            if (!mapLayer.isVisible()) continue;
            this.spriteCache.draw(n2);
            this.renderObjects(mapLayer);
        }
        this.spriteCache.end();
        if (this.blending) {
            Gdx.gl.glDisable(3042);
        }
    }

    @Override
    public void renderObjects(MapLayer mapLayer) {
        for (MapObject mapObject : mapLayer.getObjects()) {
            this.renderObject(mapObject);
        }
    }

    @Override
    public void renderObject(MapObject mapObject) {
    }

    @Override
    public void renderTileLayer(TiledMapTileLayer tiledMapTileLayer) {
        float f2 = Color.toFloatBits(1.0f, 1.0f, 1.0f, tiledMapTileLayer.getOpacity());
        int n2 = tiledMapTileLayer.getWidth();
        int n3 = tiledMapTileLayer.getHeight();
        float f3 = (float)tiledMapTileLayer.getTileWidth() * this.unitScale;
        float f4 = (float)tiledMapTileLayer.getTileHeight() * this.unitScale;
        float f5 = tiledMapTileLayer.getRenderOffsetX() * this.unitScale;
        float f6 = -tiledMapTileLayer.getRenderOffsetY() * this.unitScale;
        int n4 = Math.max(0, (int)((this.cacheBounds.x - f5) / f3));
        int n5 = Math.min(n2, (int)((this.cacheBounds.x + this.cacheBounds.width + f3 - f5) / f3));
        int n6 = Math.max(0, (int)((this.cacheBounds.y - f6) / f4));
        int n7 = Math.min(n3, (int)((this.cacheBounds.y + this.cacheBounds.height + f4 - f6) / f4));
        this.canCacheMoreN = n7 < n3;
        this.canCacheMoreE = n5 < n2;
        this.canCacheMoreW = n4 > 0;
        this.canCacheMoreS = n6 > 0;
        float[] fArray = this.vertices;
        for (int i2 = n7; i2 >= n6; --i2) {
            for (int i3 = n4; i3 < n5; ++i3) {
                float f7;
                TiledMapTile tiledMapTile;
                TiledMapTileLayer.Cell cell = tiledMapTileLayer.getCell(i3, i2);
                if (cell == null || (tiledMapTile = cell.getTile()) == null) continue;
                ++this.count;
                boolean bl2 = cell.getFlipHorizontally();
                boolean bl3 = cell.getFlipVertically();
                int n8 = cell.getRotation();
                TextureRegion textureRegion = tiledMapTile.getTextureRegion();
                Texture texture = textureRegion.getTexture();
                float f8 = (float)i3 * f3 + tiledMapTile.getOffsetX() * this.unitScale + f5;
                float f9 = (float)i2 * f4 + tiledMapTile.getOffsetY() * this.unitScale + f6;
                float f10 = f8 + (float)textureRegion.getRegionWidth() * this.unitScale;
                float f11 = f9 + (float)textureRegion.getRegionHeight() * this.unitScale;
                float f12 = 0.5f / (float)texture.getWidth();
                float f13 = 0.5f / (float)texture.getHeight();
                float f14 = textureRegion.getU() + f12;
                float f15 = textureRegion.getV2() - f13;
                float f16 = textureRegion.getU2() - f12;
                float f17 = textureRegion.getV() + f13;
                fArray[0] = f8;
                fArray[1] = f9;
                fArray[2] = f2;
                fArray[3] = f14;
                fArray[4] = f15;
                fArray[5] = f8;
                fArray[6] = f11;
                fArray[7] = f2;
                fArray[8] = f14;
                fArray[9] = f17;
                fArray[10] = f10;
                fArray[11] = f11;
                fArray[12] = f2;
                fArray[13] = f16;
                fArray[14] = f17;
                fArray[15] = f10;
                fArray[16] = f9;
                fArray[17] = f2;
                fArray[18] = f16;
                fArray[19] = f15;
                if (bl2) {
                    f7 = fArray[3];
                    fArray[3] = fArray[13];
                    fArray[13] = f7;
                    f7 = fArray[8];
                    fArray[8] = fArray[18];
                    fArray[18] = f7;
                }
                if (bl3) {
                    f7 = fArray[4];
                    fArray[4] = fArray[14];
                    fArray[14] = f7;
                    f7 = fArray[9];
                    fArray[9] = fArray[19];
                    fArray[19] = f7;
                }
                if (n8 != 0) {
                    switch (n8) {
                        case 1: {
                            f7 = fArray[4];
                            fArray[4] = fArray[9];
                            fArray[9] = fArray[14];
                            fArray[14] = fArray[19];
                            fArray[19] = f7;
                            float f18 = fArray[3];
                            fArray[3] = fArray[8];
                            fArray[8] = fArray[13];
                            fArray[13] = fArray[18];
                            fArray[18] = f18;
                            break;
                        }
                        case 2: {
                            f7 = fArray[3];
                            fArray[3] = fArray[13];
                            fArray[13] = f7;
                            f7 = fArray[8];
                            fArray[8] = fArray[18];
                            fArray[18] = f7;
                            float f18 = fArray[4];
                            fArray[4] = fArray[14];
                            fArray[14] = f18;
                            f18 = fArray[9];
                            fArray[9] = fArray[19];
                            fArray[19] = f18;
                            break;
                        }
                        case 3: {
                            f7 = fArray[4];
                            fArray[4] = fArray[19];
                            fArray[19] = fArray[14];
                            fArray[14] = fArray[9];
                            fArray[9] = f7;
                            float f18 = fArray[3];
                            fArray[3] = fArray[18];
                            fArray[18] = fArray[13];
                            fArray[13] = fArray[8];
                            fArray[8] = f18;
                            break;
                        }
                    }
                }
                this.spriteCache.add(texture, fArray, 0, 20);
            }
        }
    }

    @Override
    public void renderImageLayer(TiledMapImageLayer tiledMapImageLayer) {
        float f2 = Color.toFloatBits(1.0f, 1.0f, 1.0f, tiledMapImageLayer.getOpacity());
        float[] fArray = this.vertices;
        TextureRegion textureRegion = tiledMapImageLayer.getTextureRegion();
        if (textureRegion == null) {
            return;
        }
        float f3 = tiledMapImageLayer.getX();
        float f4 = tiledMapImageLayer.getY();
        float f5 = f3 * this.unitScale;
        float f6 = f4 * this.unitScale;
        float f7 = f5 + (float)textureRegion.getRegionWidth() * this.unitScale;
        float f8 = f6 + (float)textureRegion.getRegionHeight() * this.unitScale;
        float f9 = textureRegion.getU();
        float f10 = textureRegion.getV2();
        float f11 = textureRegion.getU2();
        float f12 = textureRegion.getV();
        fArray[0] = f5;
        fArray[1] = f6;
        fArray[2] = f2;
        fArray[3] = f9;
        fArray[4] = f10;
        fArray[5] = f5;
        fArray[6] = f8;
        fArray[7] = f2;
        fArray[8] = f9;
        fArray[9] = f12;
        fArray[10] = f7;
        fArray[11] = f8;
        fArray[12] = f2;
        fArray[13] = f11;
        fArray[14] = f12;
        fArray[15] = f7;
        fArray[16] = f6;
        fArray[17] = f2;
        fArray[18] = f11;
        fArray[19] = f10;
        this.spriteCache.add(textureRegion.getTexture(), fArray, 0, 20);
    }

    public void invalidateCache() {
        this.cached = false;
    }

    public boolean isCached() {
        return this.cached;
    }

    public void setOverCache(float f2) {
        this.overCache = f2;
    }

    public void setMaxTileSize(float f2, float f3) {
        this.maxTileWidth = f2;
        this.maxTileHeight = f3;
    }

    public void setBlending(boolean bl2) {
        this.blending = bl2;
    }

    public SpriteCache getSpriteCache() {
        return this.spriteCache;
    }

    @Override
    public void dispose() {
        this.spriteCache.dispose();
    }
}

