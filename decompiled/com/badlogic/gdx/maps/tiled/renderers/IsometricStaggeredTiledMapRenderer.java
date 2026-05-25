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

public class IsometricStaggeredTiledMapRenderer
extends BatchTiledMapRenderer {
    public IsometricStaggeredTiledMapRenderer(TiledMap tiledMap) {
        super(tiledMap);
    }

    public IsometricStaggeredTiledMapRenderer(TiledMap tiledMap, Batch batch) {
        super(tiledMap, batch);
    }

    public IsometricStaggeredTiledMapRenderer(TiledMap tiledMap, float f2) {
        super(tiledMap, f2);
    }

    public IsometricStaggeredTiledMapRenderer(TiledMap tiledMap, float f2, Batch batch) {
        super(tiledMap, f2, batch);
    }

    @Override
    public void renderTileLayer(TiledMapTileLayer tiledMapTileLayer) {
        Color color = this.batch.getColor();
        float f2 = Color.toFloatBits(color.r, color.g, color.b, color.a * tiledMapTileLayer.getOpacity());
        int n2 = tiledMapTileLayer.getWidth();
        int n3 = tiledMapTileLayer.getHeight();
        float f3 = tiledMapTileLayer.getRenderOffsetX() * this.unitScale;
        float f4 = -tiledMapTileLayer.getRenderOffsetY() * this.unitScale;
        float f5 = (float)tiledMapTileLayer.getTileWidth() * this.unitScale;
        float f6 = (float)tiledMapTileLayer.getTileHeight() * this.unitScale;
        float f7 = f5 * 0.5f;
        float f8 = f6 * 0.5f;
        int n4 = Math.max(0, (int)((this.viewBounds.x - f7 - f3) / f5));
        int n5 = Math.min(n2, (int)((this.viewBounds.x + this.viewBounds.width + f5 + f7 - f3) / f5));
        int n6 = Math.max(0, (int)((this.viewBounds.y - f6 - f4) / f6));
        int n7 = Math.min(n3, (int)((this.viewBounds.y + this.viewBounds.height + f6 - f4) / f8));
        for (int i2 = n7 - 1; i2 >= n6; --i2) {
            float f9 = i2 % 2 == 1 ? f7 : 0.0f;
            for (int i3 = n5 - 1; i3 >= n4; --i3) {
                float f10;
                TiledMapTile tiledMapTile;
                TiledMapTileLayer.Cell cell = tiledMapTileLayer.getCell(i3, i2);
                if (cell == null || (tiledMapTile = cell.getTile()) == null) continue;
                boolean bl2 = cell.getFlipHorizontally();
                boolean bl3 = cell.getFlipVertically();
                int n8 = cell.getRotation();
                TextureRegion textureRegion = tiledMapTile.getTextureRegion();
                float f11 = (float)i3 * f5 - f9 + tiledMapTile.getOffsetX() * this.unitScale + f3;
                float f12 = (float)i2 * f8 + tiledMapTile.getOffsetY() * this.unitScale + f4;
                float f13 = f11 + (float)textureRegion.getRegionWidth() * this.unitScale;
                float f14 = f12 + (float)textureRegion.getRegionHeight() * this.unitScale;
                float f15 = textureRegion.getU();
                float f16 = textureRegion.getV2();
                float f17 = textureRegion.getU2();
                float f18 = textureRegion.getV();
                this.vertices[0] = f11;
                this.vertices[1] = f12;
                this.vertices[2] = f2;
                this.vertices[3] = f15;
                this.vertices[4] = f16;
                this.vertices[5] = f11;
                this.vertices[6] = f14;
                this.vertices[7] = f2;
                this.vertices[8] = f15;
                this.vertices[9] = f18;
                this.vertices[10] = f13;
                this.vertices[11] = f14;
                this.vertices[12] = f2;
                this.vertices[13] = f17;
                this.vertices[14] = f18;
                this.vertices[15] = f13;
                this.vertices[16] = f12;
                this.vertices[17] = f2;
                this.vertices[18] = f17;
                this.vertices[19] = f16;
                if (bl2) {
                    f10 = this.vertices[3];
                    this.vertices[3] = this.vertices[13];
                    this.vertices[13] = f10;
                    f10 = this.vertices[8];
                    this.vertices[8] = this.vertices[18];
                    this.vertices[18] = f10;
                }
                if (bl3) {
                    f10 = this.vertices[4];
                    this.vertices[4] = this.vertices[14];
                    this.vertices[14] = f10;
                    f10 = this.vertices[9];
                    this.vertices[9] = this.vertices[19];
                    this.vertices[19] = f10;
                }
                if (n8 != 0) {
                    switch (n8) {
                        case 1: {
                            f10 = this.vertices[4];
                            this.vertices[4] = this.vertices[9];
                            this.vertices[9] = this.vertices[14];
                            this.vertices[14] = this.vertices[19];
                            this.vertices[19] = f10;
                            float f19 = this.vertices[3];
                            this.vertices[3] = this.vertices[8];
                            this.vertices[8] = this.vertices[13];
                            this.vertices[13] = this.vertices[18];
                            this.vertices[18] = f19;
                            break;
                        }
                        case 2: {
                            f10 = this.vertices[3];
                            this.vertices[3] = this.vertices[13];
                            this.vertices[13] = f10;
                            f10 = this.vertices[8];
                            this.vertices[8] = this.vertices[18];
                            this.vertices[18] = f10;
                            float f19 = this.vertices[4];
                            this.vertices[4] = this.vertices[14];
                            this.vertices[14] = f19;
                            f19 = this.vertices[9];
                            this.vertices[9] = this.vertices[19];
                            this.vertices[19] = f19;
                            break;
                        }
                        case 3: {
                            f10 = this.vertices[4];
                            this.vertices[4] = this.vertices[19];
                            this.vertices[19] = this.vertices[14];
                            this.vertices[14] = this.vertices[9];
                            this.vertices[9] = f10;
                            float f19 = this.vertices[3];
                            this.vertices[3] = this.vertices[18];
                            this.vertices[18] = this.vertices[13];
                            this.vertices[13] = this.vertices[8];
                            this.vertices[8] = f19;
                            break;
                        }
                    }
                }
                this.batch.draw(textureRegion.getTexture(), this.vertices, 0, 20);
            }
        }
    }
}

