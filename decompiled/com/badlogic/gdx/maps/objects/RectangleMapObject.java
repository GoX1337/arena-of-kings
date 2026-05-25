/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.maps.objects;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.math.Rectangle;

public class RectangleMapObject
extends MapObject {
    private Rectangle rectangle;

    public Rectangle getRectangle() {
        return this.rectangle;
    }

    public RectangleMapObject() {
        this(0.0f, 0.0f, 1.0f, 1.0f);
    }

    public RectangleMapObject(float f2, float f3, float f4, float f5) {
        this.rectangle = new Rectangle(f2, f3, f4, f5);
    }
}

