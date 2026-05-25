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

public class OrthogonalTiledMapRenderer
extends BatchTiledMapRenderer {
    public OrthogonalTiledMapRenderer(TiledMap tiledMap) {
        super(tiledMap);
    }

    public OrthogonalTiledMapRenderer(TiledMap tiledMap, Batch batch) {
        super(tiledMap, batch);
    }

    public OrthogonalTiledMapRenderer(TiledMap tiledMap, float f2) {
        super(tiledMap, f2);
    }

    public OrthogonalTiledMapRenderer(TiledMap tiledMap, float f2, Batch batch) {
        super(tiledMap, f2, batch);
    }

    @Override
    public void renderTileLayer(TiledMapTileLayer tiledMapTileLayer) {
        Color color = this.batch.getColor();
        float f2 = Color.toFloatBits(color.r, color.g, color.b, color.a * tiledMapTileLayer.getOpacity());
        int n2 = tiledMapTileLayer.getWidth();
        int n3 = tiledMapTileLayer.getHeight();
        float f3 = (float)tiledMapTileLayer.getTileWidth() * this.unitScale;
        float f4 = (float)tiledMapTileLayer.getTileHeight() * this.unitScale;
        float f5 = tiledMapTileLayer.getRenderOffsetX() * this.unitScale;
        float f6 = -tiledMapTileLayer.getRenderOffsetY() * this.unitScale;
        int n4 = Math.max(0, (int)((this.viewBounds.x - f5) / f3));
        int n5 = Math.min(n2, (int)((this.viewBounds.x + this.viewBounds.width + f3 - f5) / f3));
        int n6 = Math.max(0, (int)((this.viewBounds.y - f6) / f4));
        int n7 = Math.min(n3, (int)((this.viewBounds.y + this.viewBounds.height + f4 - f6) / f4));
        float f7 = (float)n7 * f4 + f6;
        float f8 = (float)n4 * f3 + f5;
        float[] fArray = this.vertices;
        for (int i2 = n7; i2 >= n6; --i2) {
            float f9 = f8;
            for (int i3 = n4; i3 < n5; ++i3) {
                TiledMapTileLayer.Cell cell = tiledMapTileLayer.getCell(i3, i2);
                if (cell == null) {
                    f9 += f3;
                    continue;
                }
                TiledMapTile tiledMapTile = cell.getTile();
                if (tiledMapTile != null) {
                    float f10;
                    boolean bl2 = cell.getFlipHorizontally();
                    boolean bl3 = cell.getFlipVertically();
                    int n8 = cell.getRotation();
                    TextureRegion textureRegion = tiledMapTile.getTextureRegion();
                    float f11 = f9 + tiledMapTile.getOffsetX() * this.unitScale;
                    float f12 = f7 + tiledMapTile.getOffsetY() * this.unitScale;
                    float f13 = f11 + (float)textureRegion.getRegionWidth() * this.unitScale;
                    float f14 = f12 + (float)textureRegion.getRegionHeight() * this.unitScale;
                    float f15 = textureRegion.getU();
                    float f16 = textureRegion.getV2();
                    float f17 = textureRegion.getU2();
                    float f18 = textureRegion.getV();
                    fArray[0] = f11;
                    fArray[1] = f12;
                    fArray[2] = f2;
                    fArray[3] = f15;
                    fArray[4] = f16;
                    fArray[5] = f11;
                    fArray[6] = f14;
                    fArray[7] = f2;
                    fArray[8] = f15;
                    fArray[9] = f18;
                    fArray[10] = f13;
                    fArray[11] = f14;
                    fArray[12] = f2;
                    fArray[13] = f17;
                    fArray[14] = f18;
                    fArray[15] = f13;
                    fArray[16] = f12;
                    fArray[17] = f2;
                    fArray[18] = f17;
                    fArray[19] = f16;
                    if (bl2) {
                        f10 = fArray[3];
                        fArray[3] = fArray[13];
                        fArray[13] = f10;
                        f10 = fArray[8];
                        fArray[8] = fArray[18];
                        fArray[18] = f10;
                    }
                    if (bl3) {
                        f10 = fArray[4];
                        fArray[4] = fArray[14];
                        fArray[14] = f10;
                        f10 = fArray[9];
                        fArray[9] = fArray[19];
                        fArray[19] = f10;
                    }
                    if (n8 != 0) {
                        switch (n8) {
                            case 1: {
                                f10 = fArray[4];
                                fArray[4] = fArray[9];
                                fArray[9] = fArray[14];
                                fArray[14] = fArray[19];
                                fArray[19] = f10;
                                float f19 = fArray[3];
                                fArray[3] = fArray[8];
                                fArray[8] = fArray[13];
                                fArray[13] = fArray[18];
                                fArray[18] = f19;
                                break;
                            }
                            case 2: {
                                f10 = fArray[3];
                                fArray[3] = fArray[13];
                                fArray[13] = f10;
                                f10 = fArray[8];
                                fArray[8] = fArray[18];
                                fArray[18] = f10;
                                float f19 = fArray[4];
                                fArray[4] = fArray[14];
                                fArray[14] = f19;
                                f19 = fArray[9];
                                fArray[9] = fArray[19];
                                fArray[19] = f19;
                                break;
                            }
                            case 3: {
                                f10 = fArray[4];
                                fArray[4] = fArray[19];
                                fArray[19] = fArray[14];
                                fArray[14] = fArray[9];
                                fArray[9] = f10;
                                float f19 = fArray[3];
                                fArray[3] = fArray[18];
                                fArray[18] = fArray[13];
                                fArray[13] = fArray[8];
                                fArray[8] = f19;
                                break;
                            }
                        }
                    }
                    this.batch.draw(textureRegion.getTexture(), fArray, 0, 20);
                }
                f9 += f3;
            }
            f7 -= f4;
        }
    }
}

