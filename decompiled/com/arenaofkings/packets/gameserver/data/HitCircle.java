/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.gameserver.data;

import com.arenaofkings.packets.gameserver.data.LocationType;
import com.badlogic.gdx.math.Vector2;

public class HitCircle {
    private float x;
    private float y;
    private int range;
    private int radius;
    private LocationType locationType;
    private String character_name_location;

    public HitCircle() {
    }

    public HitCircle(int n2) {
        this.range = n2;
    }

    public HitCircle(int n2, int n3) {
        this.range = n2;
        this.radius = n3;
    }

    public HitCircle(float f2, float f3, int n2) {
        this.x = f2;
        this.y = f3;
        this.radius = n2;
    }

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }

    public int getRadius() {
        return this.radius;
    }

    public int getRange() {
        return this.range;
    }

    public LocationType getLocationType() {
        return this.locationType;
    }

    public void setRadius(int n2) {
        this.radius = n2;
    }

    public void setPosition(Vector2 vector2) {
        this.x = vector2.x;
        this.y = vector2.y;
    }

    public void setPosition(float f2, float f3) {
        this.x = f2;
        this.y = f3;
    }

    public void setX(float f2) {
        this.x = f2;
    }

    public void setY(float f2) {
        this.y = f2;
    }

    public void setRange(int n2) {
        this.range = n2;
    }

    public void setData(int n2, int n3, int n4) {
        this.x = n2;
        this.y = n3;
        this.radius = n4;
    }

    public void add(float f2, float f3) {
        this.x += f2;
        this.y += f3;
    }

    public String toString() {
        return "HitCircle [x=" + this.x + ", y=" + this.y + ", range=" + this.range + ", radius=" + this.radius + ", locationType=" + (Object)((Object)this.locationType) + "]";
    }
}

