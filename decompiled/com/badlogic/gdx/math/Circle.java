/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.math;

import com.badlogic.gdx.math.Shape2D;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.NumberUtils;
import java.io.Serializable;

public class Circle
implements Shape2D,
Serializable {
    public float x;
    public float y;
    public float radius;

    public Circle() {
    }

    public Circle(float f2, float f3, float f4) {
        this.x = f2;
        this.y = f3;
        this.radius = f4;
    }

    public Circle(Vector2 vector2, float f2) {
        this.x = vector2.x;
        this.y = vector2.y;
        this.radius = f2;
    }

    public Circle(Circle circle) {
        this.x = circle.x;
        this.y = circle.y;
        this.radius = circle.radius;
    }

    public Circle(Vector2 vector2, Vector2 vector22) {
        this.x = vector2.x;
        this.y = vector2.y;
        this.radius = Vector2.len(vector2.x - vector22.x, vector2.y - vector22.y);
    }

    public void set(float f2, float f3, float f4) {
        this.x = f2;
        this.y = f3;
        this.radius = f4;
    }

    public void set(Vector2 vector2, float f2) {
        this.x = vector2.x;
        this.y = vector2.y;
        this.radius = f2;
    }

    public void set(Circle circle) {
        this.x = circle.x;
        this.y = circle.y;
        this.radius = circle.radius;
    }

    public void set(Vector2 vector2, Vector2 vector22) {
        this.x = vector2.x;
        this.y = vector2.y;
        this.radius = Vector2.len(vector2.x - vector22.x, vector2.y - vector22.y);
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

    public void setRadius(float f2) {
        this.radius = f2;
    }

    @Override
    public boolean contains(float f2, float f3) {
        return (f2 = this.x - f2) * f2 + (f3 = this.y - f3) * f3 <= this.radius * this.radius;
    }

    @Override
    public boolean contains(Vector2 vector2) {
        float f2 = this.x - vector2.x;
        float f3 = this.y - vector2.y;
        return f2 * f2 + f3 * f3 <= this.radius * this.radius;
    }

    public boolean contains(Circle circle) {
        float f2 = this.radius - circle.radius;
        if (f2 < 0.0f) {
            return false;
        }
        float f3 = this.x - circle.x;
        float f4 = this.y - circle.y;
        float f5 = f3 * f3 + f4 * f4;
        float f6 = this.radius + circle.radius;
        return !(f2 * f2 < f5) && f5 < f6 * f6;
    }

    public boolean overlaps(Circle circle) {
        float f2 = this.x - circle.x;
        float f3 = this.y - circle.y;
        float f4 = f2 * f2 + f3 * f3;
        float f5 = this.radius + circle.radius;
        return f4 < f5 * f5;
    }

    public String toString() {
        return this.x + "," + this.y + "," + this.radius;
    }

    public float circumference() {
        return this.radius * ((float)Math.PI * 2);
    }

    public float area() {
        return this.radius * this.radius * (float)Math.PI;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object == null || object.getClass() != this.getClass()) {
            return false;
        }
        Circle circle = (Circle)object;
        return this.x == circle.x && this.y == circle.y && this.radius == circle.radius;
    }

    public int hashCode() {
        int n2 = 41;
        int n3 = 1;
        n3 = 41 * n3 + NumberUtils.floatToRawIntBits(this.radius);
        n3 = 41 * n3 + NumberUtils.floatToRawIntBits(this.x);
        n3 = 41 * n3 + NumberUtils.floatToRawIntBits(this.y);
        return n3;
    }
}

