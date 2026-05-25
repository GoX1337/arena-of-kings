/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.maps;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.reflect.ClassReflection;
import java.util.Iterator;

public class MapObjects
implements Iterable<MapObject> {
    private Array<MapObject> objects = new Array();

    public MapObject get(int n2) {
        return this.objects.get(n2);
    }

    public MapObject get(String string) {
        int n2 = this.objects.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            MapObject mapObject = this.objects.get(i2);
            if (!string.equals(mapObject.getName())) continue;
            return mapObject;
        }
        return null;
    }

    public int getIndex(String string) {
        return this.getIndex(this.get(string));
    }

    public int getIndex(MapObject mapObject) {
        return this.objects.indexOf(mapObject, true);
    }

    public int getCount() {
        return this.objects.size;
    }

    public void add(MapObject mapObject) {
        this.objects.add(mapObject);
    }

    public void remove(int n2) {
        this.objects.removeIndex(n2);
    }

    public void remove(MapObject mapObject) {
        this.objects.removeValue(mapObject, true);
    }

    public <T extends MapObject> Array<T> getByType(Class<T> clazz) {
        return this.getByType(clazz, new Array());
    }

    public <T extends MapObject> Array<T> getByType(Class<T> clazz, Array<T> array) {
        array.clear();
        int n2 = this.objects.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            MapObject mapObject = this.objects.get(i2);
            if (!ClassReflection.isInstance(clazz, mapObject)) continue;
            array.add(mapObject);
        }
        return array;
    }

    @Override
    public Iterator<MapObject> iterator() {
        return this.objects.iterator();
    }
}

