/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.maps.tiled;

import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileSet;
import com.badlogic.gdx.utils.Array;
import java.util.Iterator;

public class TiledMapTileSets
implements Iterable<TiledMapTileSet> {
    private Array<TiledMapTileSet> tilesets = new Array();

    public TiledMapTileSet getTileSet(int n2) {
        return this.tilesets.get(n2);
    }

    public TiledMapTileSet getTileSet(String string) {
        for (TiledMapTileSet tiledMapTileSet : this.tilesets) {
            if (!string.equals(tiledMapTileSet.getName())) continue;
            return tiledMapTileSet;
        }
        return null;
    }

    public void addTileSet(TiledMapTileSet tiledMapTileSet) {
        this.tilesets.add(tiledMapTileSet);
    }

    public void removeTileSet(int n2) {
        this.tilesets.removeIndex(n2);
    }

    public void removeTileSet(TiledMapTileSet tiledMapTileSet) {
        this.tilesets.removeValue(tiledMapTileSet, true);
    }

    public TiledMapTile getTile(int n2) {
        for (int i2 = this.tilesets.size - 1; i2 >= 0; --i2) {
            TiledMapTileSet tiledMapTileSet = this.tilesets.get(i2);
            TiledMapTile tiledMapTile = tiledMapTileSet.getTile(n2);
            if (tiledMapTile == null) continue;
            return tiledMapTile;
        }
        return null;
    }

    @Override
    public Iterator<TiledMapTileSet> iterator() {
        return this.tilesets.iterator();
    }
}

