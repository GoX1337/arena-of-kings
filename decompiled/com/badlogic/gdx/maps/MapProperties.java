/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.maps;

import com.badlogic.gdx.utils.ObjectMap;
import java.util.Iterator;

public class MapProperties {
    private ObjectMap<String, Object> properties = new ObjectMap();

    public boolean containsKey(String string) {
        return this.properties.containsKey(string);
    }

    public Object get(String string) {
        return this.properties.get(string);
    }

    public <T> T get(String string, Class<T> clazz) {
        return (T)this.get(string);
    }

    public <T> T get(String string, T t2, Class<T> clazz) {
        Object object = this.get(string);
        return (T)(object == null ? t2 : object);
    }

    public void put(String string, Object object) {
        this.properties.put(string, object);
    }

    public void putAll(MapProperties mapProperties) {
        this.properties.putAll(mapProperties.properties);
    }

    public void remove(String string) {
        this.properties.remove(string);
    }

    public void clear() {
        this.properties.clear();
    }

    public Iterator<String> getKeys() {
        return this.properties.keys();
    }

    public Iterator<Object> getValues() {
        return this.properties.values();
    }
}

