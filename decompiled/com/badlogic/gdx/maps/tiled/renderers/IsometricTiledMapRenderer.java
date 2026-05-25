/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.maps.tiled.renderers;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.renderers.BatchTiledMapRenderer;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class IsometricTiledMapRenderer
extends BatchTiledMapRenderer {
    private Matrix4 isoTransform;
    private Matrix4 invIsotransform;
    private Vector3 screenPos = new Vector3();
    private Vector2 topRight = new Vector2();
    private Vector2 bottomLeft = new Vector2();
    private Vector2 topLeft = new Vector2();
    private Vector2 bottomRight = new Vector2();

    public IsometricTiledMapRenderer(TiledMap tiledMap) {
        super(tiledMap);
        this.init();
    }

    public IsometricTiledMapRenderer(TiledMap tiledMap, Batch batch) {
        super(tiledMap, batch);
        this.init();
    }

    public IsometricTiledMapRenderer(TiledMap tiledMap, float f2) {
        super(tiledMap, f2);
        this.init();
    }

    public IsometricTiledMapRenderer(TiledMap tiledMap, float f2, Batch batch) {
        super(tiledMap, f2, batch);
        this.init();
    }

    private void init() {
        this.isoTransform = new Matrix4();
        this.isoTransform.idt();
        this.isoTransform.scale((float)(Math.sqrt(2.0) / 2.0), (float)(Math.sqrt(2.0) / 4.0), 1.0f);
        this.isoTransform.rotate(0.0f, 0.0f, 1.0f, -45.0f);
        this.invIsotransform = new Matrix4(this.isoTransform);
        this.invIsotransform.inv();
    }

    private Vector3 translateScreenToIso(Vector2 vector2) {
        this.screenPos.set(vector2.x, vector2.y, 0.0f);
        this.screenPos.mul(this.invIsotransform);
        return this.screenPos;
    }

    @Override
    public void renderTileLayer(TiledMapTileLayer tiledMapTileLayer) {
        Color color = this.batch.getColor();
        float f2 = Color.toFloatBits(color.r, color.g, color.b, color.a * tiledMapTileLayer.getOpacity());
        float f3 = (float)tiledMapTileLayer.getTileWidth() * this.unitScale;
        float f4 = (float)tiledMapTileLayer.getTileHeight() * this.unitScale;
        float f5 = tiledMapTileLayer.getRenderOffsetX() * this.unitScale;
        float f6 = -tiledMapTileLayer.getRenderOffsetY() * this.unitScale;
        float f7 = f3 * 0.5f;
        float f8 = f4 * 0.5f;
        this.topRight.set(this.viewBounds.x + this.viewBounds.width - f5, this.viewBounds.y - f6);
        this.bottomLeft.set(this.viewBounds.x - f5, this.viewBounds.y + this.viewBounds.height - f6);
        this.topLeft.set(this.viewBounds.x - f5, this.viewBounds.y - f6);
        this.bottomRight.set(this.viewBounds.x + this.viewBounds.width - f5, this.viewBounds.y + this.viewBounds.height - f6);
        int n2 = (int)(this.translateScreenToIso((Vector2)this.topLeft).y / f3) - 2;
        int n3 = (int)(this.translateScreenToIso((Vector2)this.bottomRight).y / f3) + 2;
        int n4 = (int)(this.translateScreenToIso((Vector2)this.bottomLeft).x / f3) - 2;
        int n5 = (int)(this.translateScreenToIso((Vector2)this.topRight).x / f3) + 2;
        for (int i2 = n3; i2 >= n2; --i2) {
            for (int i3 = n4; i3 <= n5; ++i3) {
                float f9;
                TiledMapTile tiledMapTile;
                float f10 = (float)i3 * f7 + (float)i2 * f7;
                float f11 = (float)i2 * f8 - (float)i3 * f8;
                TiledMapTileLayer.Cell cell = tiledMapTileLayer.getCell(i3, i2);
                if (cell == null || (tiledMapTile = cell.getTile()) == null) continue;
                boolean bl2 = cell.getFlipHorizontally();
                boolean bl3 = cell.getFlipVertically();
                int n6 = cell.getRotation();
                TextureRegion textureRegion = tiledMapTile.getTextureRegion();
                float f12 = f10 + tiledMapTile.getOffsetX() * this.unitScale + f5;
                float f13 = f11 + tiledMapTile.getOffsetY() * this.unitScale + f6;
                float f14 = f12 + (float)textureRegion.getRegionWidth() * this.unitScale;
                float f15 = f13 + (float)textureRegion.getRegionHeight() * this.unitScale;
                float f16 = textureRegion.getU();
                float f17 = textureRegion.getV2();
                float f18 = textureRegion.getU2();
                float f19 = textureRegion.getV();
                this.vertices[0] = f12;
                this.vertices[1] = f13;
                this.vertices[2] = f2;
                this.vertices[3] = f16;
                this.vertices[4] = f17;
                this.vertices[5] = f12;
                this.vertices[6] = f15;
                this.vertices[7] = f2;
                this.vertices[8] = f16;
                this.vertices[9] = f19;
                this.vertices[10] = f14;
                this.vertices[11] = f15;
                this.vertices[12] = f2;
                this.vertices[13] = f18;
                this.vertices[14] = f19;
                this.vertices[15] = f14;
                this.vertices[16] = f13;
                this.vertices[17] = f2;
                this.vertices[18] = f18;
                this.vertices[19] = f17;
                if (bl2) {
                    f9 = this.vertices[3];
                    this.vertices[3] = this.vertices[13];
                    this.vertices[13] = f9;
                    f9 = this.vertices[8];
                    this.vertices[8] = this.vertices[18];
                    this.vertices[18] = f9;
                }
                if (bl3) {
                    f9 = this.vertices[4];
                    this.vertices[4] = this.vertices[14];
                    this.vertices[14] = f9;
                    f9 = this.vertices[9];
                    this.vertices[9] = this.vertices[19];
                    this.vertices[19] = f9;
                }
                if (n6 != 0) {
                    switch (n6) {
                        case 1: {
                            f9 = this.vertices[4];
                            this.vertices[4] = this.vertices[9];
                            this.vertices[9] = this.vertices[14];
                            this.vertices[14] = this.vertices[19];
                            this.vertices[19] = f9;
                            float f20 = this.vertices[3];
                            this.vertices[3] = this.vertices[8];
                            this.vertices[8] = this.vertices[13];
                            this.vertices[13] = this.vertices[18];
                            this.vertices[18] = f20;
                            break;
                        }
                        case 2: {
                            f9 = this.vertices[3];
                            this.vertices[3] = this.vertices[13];
                            this.vertices[13] = f9;
                            f9 = this.vertices[8];
                            this.vertices[8] = this.vertices[18];
                            this.vertices[18] = f9;
                            float f20 = this.vertices[4];
                            this.vertices[4] = this.vertices[14];
                            this.vertices[14] = f20;
                            f20 = this.vertices[9];
                            this.vertices[9] = this.vertices[19];
                            this.vertices[19] = f20;
                            break;
                        }
                        case 3: {
                            f9 = this.vertices[4];
                            this.vertices[4] = this.vertices[19];
                            this.vertices[19] = this.vertices[14];
                            this.vertices[14] = this.vertices[9];
                            this.vertices[9] = f9;
                            float f20 = this.vertices[3];
                            this.vertices[3] = this.vertices[18];
                            this.vertices[18] = this.vertices[13];
                            this.vertices[13] = this.vertices[8];
                            this.vertices[8] = f20;
                            break;
                        }
                    }
                }
                this.batch.draw(textureRegion.getTexture(), this.vertices, 0, 20);
            }
        }
    }
}

