/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.maps;

import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapLayers;

public class MapGroupLayer
extends MapLayer {
    private MapLayers layers = new MapLayers();

    public MapLayers getLayers() {
        return this.layers;
    }

    @Override
    public void invalidateRenderOffset() {
        super.invalidateRenderOffset();
        for (int i2 = 0; i2 < this.layers.size(); ++i2) {
            MapLayer mapLayer = this.layers.get(i2);
            mapLayer.invalidateRenderOffset();
        }
    }
}

