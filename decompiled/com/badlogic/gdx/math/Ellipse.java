/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.math;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Shape2D;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.NumberUtils;
import java.io.Serializable;

public class Ellipse
implements Shape2D,
Serializable {
    public float x;
    public float y;
    public float width;
    public float height;
    private static final long serialVersionUID = 7381533206532032099L;

    public Ellipse() {
    }

    public Ellipse(Ellipse ellipse) {
        this.x = ellipse.x;
        this.y = ellipse.y;
        this.width = ellipse.width;
        this.height = ellipse.height;
    }

    public Ellipse(float f2, float f3, float f4, float f5) {
        this.x = f2;
        this.y = f3;
        this.width = f4;
        this.height = f5;
    }

    public Ellipse(Vector2 vector2, float f2, float f3) {
        this.x = vector2.x;
        this.y = vector2.y;
        this.width = f2;
        this.height = f3;
    }

    public Ellipse(Vector2 vector2, Vector2 vector22) {
        this.x = vector2.x;
        this.y = vector2.y;
        this.width = vector22.x;
        this.height = vector22.y;
    }

    public Ellipse(Circle circle) {
        this.x = circle.x;
        this.y = circle.y;
        this.width = circle.radius * 2.0f;
        this.height = circle.radius * 2.0f;
    }

    @Override
    public boolean contains(float f2, float f3) {
        return (f2 -= this.x) * f2 / (this.width * 0.5f * this.width * 0.5f) + (f3 -= this.y) * f3 / (this.height * 0.5f * this.height * 0.5f) <= 1.0f;
    }

    @Override
    public boolean contains(Vector2 vector2) {
        return this.contains(vector2.x, vector2.y);
    }

    public void set(float f2, float f3, float f4, float f5) {
        this.x = f2;
        this.y = f3;
        this.width = f4;
        this.height = f5;
    }

    public void set(Ellipse ellipse) {
        this.x = ellipse.x;
        this.y = ellipse.y;
        this.width = ellipse.width;
        this.height = ellipse.height;
    }

    public void set(Circle circle) {
        this.x = circle.x;
        this.y = circle.y;
        this.width = circle.radius * 2.0f;
        this.height = circle.radius * 2.0f;
    }

    public void set(Vector2 vector2, Vector2 vector22) {
        this.x = vector2.x;
        this.y = vector2.y;
        this.width = vector22.x;
        this.height = vector22.y;
    }

    public Ellipse setPosition(Vector2 vector2) {
        this.x = vector2.x;
        this.y = vector2.y;
        return this;
    }

    public Ellipse setPosition(float f2, float f3) {
        this.x = f2;
        this.y = f3;
        return this;
    }

    public Ellipse setSize(float f2, float f3) {
        this.width = f2;
        this.height = f3;
        return this;
    }

    public float area() {
        return (float)Math.PI * (this.width * this.height) / 4.0f;
    }

    public float circumference() {
        float f2 = this.width / 2.0f;
        float f3 = this.height / 2.0f;
        if (f2 * 3.0f > f3 || f3 * 3.0f > f2) {
            return (float)(3.1415927410125732 * ((double)(3.0f * (f2 + f3)) - Math.sqrt((3.0f * f2 + f3) * (f2 + 3.0f * f3))));
        }
        return (float)(6.2831854820251465 * Math.sqrt((f2 * f2 + f3 * f3) / 2.0f));
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object == null || object.getClass() != this.getClass()) {
            return false;
        }
        Ellipse ellipse = (Ellipse)object;
        return this.x == ellipse.x && this.y == ellipse.y && this.width == ellipse.width && this.height == ellipse.height;
    }

    public int hashCode() {
        int n2 = 53;
        int n3 = 1;
        n3 = 53 * n3 + NumberUtils.floatToRawIntBits(this.height);
        n3 = 53 * n3 + NumberUtils.floatToRawIntBits(this.width);
        n3 = 53 * n3 + NumberUtils.floatToRawIntBits(this.x);
        n3 = 53 * n3 + NumberUtils.floatToRawIntBits(this.y);
        return n3;
    }
}

