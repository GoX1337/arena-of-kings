/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.maps;

import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.reflect.ClassReflection;
import java.util.Iterator;

public class MapLayers
implements Iterable<MapLayer> {
    private Array<MapLayer> layers = new Array();

    public MapLayer get(int n2) {
        return this.layers.get(n2);
    }

    public MapLayer get(String string) {
        int n2 = this.layers.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            MapLayer mapLayer = this.layers.get(i2);
            if (!string.equals(mapLayer.getName())) continue;
            return mapLayer;
        }
        return null;
    }

    public int getIndex(String string) {
        return this.getIndex(this.get(string));
    }

    public int getIndex(MapLayer mapLayer) {
        return this.layers.indexOf(mapLayer, true);
    }

    public int getCount() {
        return this.layers.size;
    }

    public void add(MapLayer mapLayer) {
        this.layers.add(mapLayer);
    }

    public void remove(int n2) {
        this.layers.removeIndex(n2);
    }

    public void remove(MapLayer mapLayer) {
        this.layers.removeValue(mapLayer, true);
    }

    public int size() {
        return this.layers.size;
    }

    public <T extends MapLayer> Array<T> getByType(Class<T> clazz) {
        return this.getByType(clazz, new Array());
    }

    public <T extends MapLayer> Array<T> getByType(Class<T> clazz, Array<T> array) {
        array.clear();
        int n2 = this.layers.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            MapLayer mapLayer = this.layers.get(i2);
            if (!ClassReflection.isInstance(clazz, mapLayer)) continue;
            array.add(mapLayer);
        }
        return array;
    }

    @Override
    public Iterator<MapLayer> iterator() {
        return this.layers.iterator();
    }
}

