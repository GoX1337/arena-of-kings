/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.maps.tiled.renderers;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.MapGroupLayer;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapLayers;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapImageLayer;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.tiles.AnimatedTiledMapTile;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Disposable;

public abstract class BatchTiledMapRenderer
implements TiledMapRenderer,
Disposable {
    protected static final int NUM_VERTICES = 20;
    protected TiledMap map;
    protected float unitScale;
    protected Batch batch;
    protected Rectangle viewBounds;
    protected Rectangle imageBounds = new Rectangle();
    protected boolean ownsBatch;
    protected float[] vertices = new float[20];

    public TiledMap getMap() {
        return this.map;
    }

    public void setMap(TiledMap tiledMap) {
        this.map = tiledMap;
    }

    public float getUnitScale() {
        return this.unitScale;
    }

    public Batch getBatch() {
        return this.batch;
    }

    public Rectangle getViewBounds() {
        return this.viewBounds;
    }

    public BatchTiledMapRenderer(TiledMap tiledMap) {
        this(tiledMap, 1.0f);
    }

    public BatchTiledMapRenderer(TiledMap tiledMap, float f2) {
        this.map = tiledMap;
        this.unitScale = f2;
        this.viewBounds = new Rectangle();
        this.batch = new SpriteBatch();
        this.ownsBatch = true;
    }

    public BatchTiledMapRenderer(TiledMap tiledMap, Batch batch) {
        this(tiledMap, 1.0f, batch);
    }

    public BatchTiledMapRenderer(TiledMap tiledMap, float f2, Batch batch) {
        this.map = tiledMap;
        this.unitScale = f2;
        this.viewBounds = new Rectangle();
        this.batch = batch;
        this.ownsBatch = false;
    }

    @Override
    public void setView(OrthographicCamera orthographicCamera) {
        this.batch.setProjectionMatrix(orthographicCamera.combined);
        float f2 = orthographicCamera.viewportWidth * orthographicCamera.zoom;
        float f3 = orthographicCamera.viewportHeight * orthographicCamera.zoom;
        float f4 = f2 * Math.abs(orthographicCamera.up.y) + f3 * Math.abs(orthographicCamera.up.x);
        float f5 = f3 * Math.abs(orthographicCamera.up.y) + f2 * Math.abs(orthographicCamera.up.x);
        this.viewBounds.set(orthographicCamera.position.x - f4 / 2.0f, orthographicCamera.position.y - f5 / 2.0f, f4, f5);
    }

    @Override
    public void setView(Matrix4 matrix4, float f2, float f3, float f4, float f5) {
        this.batch.setProjectionMatrix(matrix4);
        this.viewBounds.set(f2, f3, f4, f5);
    }

    @Override
    public void render() {
        this.beginRender();
        for (MapLayer mapLayer : this.map.getLayers()) {
            this.renderMapLayer(mapLayer);
        }
        this.endRender();
    }

    @Override
    public void render(int[] nArray) {
        this.beginRender();
        for (int n2 : nArray) {
            MapLayer mapLayer = this.map.getLayers().get(n2);
            this.renderMapLayer(mapLayer);
        }
        this.endRender();
    }

    protected void renderMapLayer(MapLayer mapLayer) {
        if (!mapLayer.isVisible()) {
            return;
        }
        if (mapLayer instanceof MapGroupLayer) {
            MapLayers mapLayers = ((MapGroupLayer)mapLayer).getLayers();
            for (int i2 = 0; i2 < mapLayers.size(); ++i2) {
                MapLayer mapLayer2 = mapLayers.get(i2);
                if (!mapLayer2.isVisible()) continue;
                this.renderMapLayer(mapLayer2);
            }
        } else if (mapLayer instanceof TiledMapTileLayer) {
            this.renderTileLayer((TiledMapTileLayer)mapLayer);
        } else if (mapLayer instanceof TiledMapImageLayer) {
            this.renderImageLayer((TiledMapImageLayer)mapLayer);
        } else {
            this.renderObjects(mapLayer);
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
    public void renderImageLayer(TiledMapImageLayer tiledMapImageLayer) {
        Color color = this.batch.getColor();
        float f2 = Color.toFloatBits(color.r, color.g, color.b, color.a * tiledMapImageLayer.getOpacity());
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
        this.imageBounds.set(f5, f6, f7 - f5, f8 - f6);
        if (this.viewBounds.contains(this.imageBounds) || this.viewBounds.overlaps(this.imageBounds)) {
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
            this.batch.draw(textureRegion.getTexture(), fArray, 0, 20);
        }
    }

    protected void beginRender() {
        AnimatedTiledMapTile.updateAnimationBaseTime();
        this.batch.begin();
    }

    protected void endRender() {
        this.batch.end();
    }

    @Override
    public void dispose() {
        if (this.ownsBatch) {
            this.batch.dispose();
        }
    }
}

