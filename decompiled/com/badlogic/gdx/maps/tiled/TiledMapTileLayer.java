/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.maps.tiled;

import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTile;

public class TiledMapTileLayer
extends MapLayer {
    private int width;
    private int height;
    private int tileWidth;
    private int tileHeight;
    private Cell[][] cells;

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public int getTileWidth() {
        return this.tileWidth;
    }

    public int getTileHeight() {
        return this.tileHeight;
    }

    public TiledMapTileLayer(int n2, int n3, int n4, int n5) {
        this.width = n2;
        this.height = n3;
        this.tileWidth = n4;
        this.tileHeight = n5;
        this.cells = new Cell[n2][n3];
    }

    public Cell getCell(int n2, int n3) {
        if (n2 < 0 || n2 >= this.width) {
            return null;
        }
        if (n3 < 0 || n3 >= this.height) {
            return null;
        }
        return this.cells[n2][n3];
    }

    public void setCell(int n2, int n3, Cell cell) {
        if (n2 < 0 || n2 >= this.width) {
            return;
        }
        if (n3 < 0 || n3 >= this.height) {
            return;
        }
        this.cells[n2][n3] = cell;
    }

    public static class Cell {
        private TiledMapTile tile;
        private boolean flipHorizontally;
        private boolean flipVertically;
        private int rotation;
        public static final int ROTATE_0 = 0;
        public static final int ROTATE_90 = 1;
        public static final int ROTATE_180 = 2;
        public static final int ROTATE_270 = 3;

        public TiledMapTile getTile() {
            return this.tile;
        }

        public Cell setTile(TiledMapTile tiledMapTile) {
            this.tile = tiledMapTile;
            return this;
        }

        public boolean getFlipHorizontally() {
            return this.flipHorizontally;
        }

        public Cell setFlipHorizontally(boolean bl2) {
            this.flipHorizontally = bl2;
            return this;
        }

        public boolean getFlipVertically() {
            return this.flipVertically;
        }

        public Cell setFlipVertically(boolean bl2) {
            this.flipVertically = bl2;
            return this;
        }

        public int getRotation() {
            return this.rotation;
        }

        public Cell setRotation(int n2) {
            this.rotation = n2;
            return this;
        }
    }
}

