/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.maps.objects;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.math.Circle;

public class CircleMapObject
extends MapObject {
    private Circle circle;

    public Circle getCircle() {
        return this.circle;
    }

    public CircleMapObject() {
        this(0.0f, 0.0f, 1.0f);
    }

    public CircleMapObject(float f2, float f3, float f4) {
        this.circle = new Circle(f2, f3, f4);
    }
}

