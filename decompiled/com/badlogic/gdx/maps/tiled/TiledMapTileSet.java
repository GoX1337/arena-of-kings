/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.maps.tiled;

import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.utils.IntMap;
import java.util.Iterator;

public class TiledMapTileSet
implements Iterable<TiledMapTile> {
    private String name;
    private IntMap<TiledMapTile> tiles = new IntMap();
    private MapProperties properties = new MapProperties();

    public String getName() {
        return this.name;
    }

    public void setName(String string) {
        this.name = string;
    }

    public MapProperties getProperties() {
        return this.properties;
    }

    public TiledMapTile getTile(int n2) {
        return this.tiles.get(n2);
    }

    @Override
    public Iterator<TiledMapTile> iterator() {
        return this.tiles.values().iterator();
    }

    public void putTile(int n2, TiledMapTile tiledMapTile) {
        this.tiles.put(n2, tiledMapTile);
    }

    public void removeTile(int n2) {
        this.tiles.remove(n2);
    }

    public int size() {
        return this.tiles.size;
    }
}

