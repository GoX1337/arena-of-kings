/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.maps.objects;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.math.Polyline;

public class PolylineMapObject
extends MapObject {
    private Polyline polyline;

    public Polyline getPolyline() {
        return this.polyline;
    }

    public void setPolyline(Polyline polyline) {
        this.polyline = polyline;
    }

    public PolylineMapObject() {
        this(new float[0]);
    }

    public PolylineMapObject(float[] fArray) {
        this.polyline = new Polyline(fArray);
    }

    public PolylineMapObject(Polyline polyline) {
        this.polyline = polyline;
    }
}

