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
import com.badlogic.gdx.maps.tiled.tiles.AnimatedTiledMapTile;

public class HexagonalTiledMapRenderer
extends BatchTiledMapRenderer {
    private boolean staggerAxisX = true;
    private boolean staggerIndexEven = false;
    private float hexSideLength = 0.0f;

    public HexagonalTiledMapRenderer(TiledMap tiledMap) {
        super(tiledMap);
        this.init(tiledMap);
    }

    public HexagonalTiledMapRenderer(TiledMap tiledMap, float f2) {
        super(tiledMap, f2);
        this.init(tiledMap);
    }

    public HexagonalTiledMapRenderer(TiledMap tiledMap, Batch batch) {
        super(tiledMap, batch);
        this.init(tiledMap);
    }

    public HexagonalTiledMapRenderer(TiledMap tiledMap, float f2, Batch batch) {
        super(tiledMap, f2, batch);
        this.init(tiledMap);
    }

    private void init(TiledMap tiledMap) {
        Integer n2;
        String string;
        String string2 = tiledMap.getProperties().get("staggeraxis", String.class);
        if (string2 != null) {
            this.staggerAxisX = string2.equals("x");
        }
        if ((string = tiledMap.getProperties().get("staggerindex", String.class)) != null) {
            this.staggerIndexEven = string.equals("even");
        }
        if ((n2 = tiledMap.getProperties().get("hexsidelength", Integer.class)) != null) {
            this.hexSideLength = n2.intValue();
        } else if (this.staggerAxisX) {
            n2 = tiledMap.getProperties().get("tilewidth", Integer.class);
            if (n2 != null) {
                this.hexSideLength = 0.5f * (float)n2.intValue();
            } else {
                TiledMapTileLayer tiledMapTileLayer = (TiledMapTileLayer)tiledMap.getLayers().get(0);
                this.hexSideLength = 0.5f * (float)tiledMapTileLayer.getTileWidth();
            }
        } else {
            n2 = tiledMap.getProperties().get("tileheight", Integer.class);
            if (n2 != null) {
                this.hexSideLength = 0.5f * (float)n2.intValue();
            } else {
                TiledMapTileLayer tiledMapTileLayer = (TiledMapTileLayer)tiledMap.getLayers().get(0);
                this.hexSideLength = 0.5f * (float)tiledMapTileLayer.getTileHeight();
            }
        }
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
        float f7 = this.hexSideLength * this.unitScale;
        if (this.staggerAxisX) {
            float f8 = (f3 - f7) / 2.0f;
            float f9 = (f3 + f7) / 2.0f;
            float f10 = f4 * 0.5f;
            int n4 = Math.max(0, (int)((this.viewBounds.y - f10 - f5) / f4));
            int n5 = Math.min(n3, (int)((this.viewBounds.y + this.viewBounds.height + f4 - f5) / f4));
            int n6 = Math.max(0, (int)((this.viewBounds.x - f8 - f6) / f9));
            int n7 = Math.min(n2, (int)((this.viewBounds.x + this.viewBounds.width + f9 - f6) / f9));
            int n8 = this.staggerIndexEven == (n6 % 2 == 0) ? n6 + 1 : n6;
            int n9 = this.staggerIndexEven == (n6 % 2 == 0) ? n6 : n6 + 1;
            for (int i2 = n5 - 1; i2 >= n4; --i2) {
                int n10;
                for (n10 = n8; n10 < n7; n10 += 2) {
                    this.renderCell(tiledMapTileLayer.getCell(n10, i2), f9 * (float)n10 + f5, f10 + f4 * (float)i2 + f6, f2);
                }
                for (n10 = n9; n10 < n7; n10 += 2) {
                    this.renderCell(tiledMapTileLayer.getCell(n10, i2), f9 * (float)n10 + f5, f4 * (float)i2 + f6, f2);
                }
            }
        } else {
            float f11 = (f4 - f7) / 2.0f;
            float f12 = (f4 + f7) / 2.0f;
            float f13 = f3 * 0.5f;
            int n11 = Math.max(0, (int)((this.viewBounds.y - f11 - f5) / f12));
            int n12 = Math.min(n3, (int)((this.viewBounds.y + this.viewBounds.height + f12 - f5) / f12));
            int n13 = Math.max(0, (int)((this.viewBounds.x - f13 - f6) / f3));
            int n14 = Math.min(n2, (int)((this.viewBounds.x + this.viewBounds.width + f3 - f6) / f3));
            float f14 = 0.0f;
            for (int i3 = n12 - 1; i3 >= n11; --i3) {
                f14 = i3 % 2 == 0 == this.staggerIndexEven ? f13 : 0.0f;
                for (int i4 = n13; i4 < n14; ++i4) {
                    this.renderCell(tiledMapTileLayer.getCell(i4, i3), f3 * (float)i4 + f14 + f5, f12 * (float)i3 + f6, f2);
                }
            }
        }
    }

    private void renderCell(TiledMapTileLayer.Cell cell, float f2, float f3, float f4) {
        TiledMapTile tiledMapTile;
        if (cell != null && (tiledMapTile = cell.getTile()) != null) {
            float f5;
            if (tiledMapTile instanceof AnimatedTiledMapTile) {
                return;
            }
            boolean bl2 = cell.getFlipHorizontally();
            boolean bl3 = cell.getFlipVertically();
            int n2 = cell.getRotation();
            TextureRegion textureRegion = tiledMapTile.getTextureRegion();
            float f6 = f2 + tiledMapTile.getOffsetX() * this.unitScale;
            float f7 = f3 + tiledMapTile.getOffsetY() * this.unitScale;
            float f8 = f6 + (float)textureRegion.getRegionWidth() * this.unitScale;
            float f9 = f7 + (float)textureRegion.getRegionHeight() * this.unitScale;
            float f10 = textureRegion.getU();
            float f11 = textureRegion.getV2();
            float f12 = textureRegion.getU2();
            float f13 = textureRegion.getV();
            this.vertices[0] = f6;
            this.vertices[1] = f7;
            this.vertices[2] = f4;
            this.vertices[3] = f10;
            this.vertices[4] = f11;
            this.vertices[5] = f6;
            this.vertices[6] = f9;
            this.vertices[7] = f4;
            this.vertices[8] = f10;
            this.vertices[9] = f13;
            this.vertices[10] = f8;
            this.vertices[11] = f9;
            this.vertices[12] = f4;
            this.vertices[13] = f12;
            this.vertices[14] = f13;
            this.vertices[15] = f8;
            this.vertices[16] = f7;
            this.vertices[17] = f4;
            this.vertices[18] = f12;
            this.vertices[19] = f11;
            if (bl2) {
                f5 = this.vertices[3];
                this.vertices[3] = this.vertices[13];
                this.vertices[13] = f5;
                f5 = this.vertices[8];
                this.vertices[8] = this.vertices[18];
                this.vertices[18] = f5;
            }
            if (bl3) {
                f5 = this.vertices[4];
                this.vertices[4] = this.vertices[14];
                this.vertices[14] = f5;
                f5 = this.vertices[9];
                this.vertices[9] = this.vertices[19];
                this.vertices[19] = f5;
            }
            if (n2 == 2) {
                f5 = this.vertices[3];
                this.vertices[3] = this.vertices[13];
                this.vertices[13] = f5;
                f5 = this.vertices[8];
                this.vertices[8] = this.vertices[18];
                this.vertices[18] = f5;
                float f14 = this.vertices[4];
                this.vertices[4] = this.vertices[14];
                this.vertices[14] = f14;
                f14 = this.vertices[9];
                this.vertices[9] = this.vertices[19];
                this.vertices[19] = f14;
            }
            this.batch.draw(textureRegion.getTexture(), this.vertices, 0, 20);
        }
    }
}

