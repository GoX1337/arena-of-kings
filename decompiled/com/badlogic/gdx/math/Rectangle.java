/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.math;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Shape2D;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.NumberUtils;
import java.io.Serializable;

public class Rectangle
implements Shape2D,
Serializable {
    public static final Rectangle tmp = new Rectangle();
    public static final Rectangle tmp2 = new Rectangle();
    private static final long serialVersionUID = 5733252015138115702L;
    public float x;
    public float y;
    public float width;
    public float height;

    public Rectangle() {
    }

    public Rectangle(float f2, float f3, float f4, float f5) {
        this.x = f2;
        this.y = f3;
        this.width = f4;
        this.height = f5;
    }

    public Rectangle(Rectangle rectangle) {
        this.x = rectangle.x;
        this.y = rectangle.y;
        this.width = rectangle.width;
        this.height = rectangle.height;
    }

    public Rectangle set(float f2, float f3, float f4, float f5) {
        this.x = f2;
        this.y = f3;
        this.width = f4;
        this.height = f5;
        return this;
    }

    public float getX() {
        return this.x;
    }

    public Rectangle setX(float f2) {
        this.x = f2;
        return this;
    }

    public float getY() {
        return this.y;
    }

    public Rectangle setY(float f2) {
        this.y = f2;
        return this;
    }

    public float getWidth() {
        return this.width;
    }

    public Rectangle setWidth(float f2) {
        this.width = f2;
        return this;
    }

    public float getHeight() {
        return this.height;
    }

    public Rectangle setHeight(float f2) {
        this.height = f2;
        return this;
    }

    public Vector2 getPosition(Vector2 vector2) {
        return vector2.set(this.x, this.y);
    }

    public Rectangle setPosition(Vector2 vector2) {
        this.x = vector2.x;
        this.y = vector2.y;
        return this;
    }

    public Rectangle setPosition(float f2, float f3) {
        this.x = f2;
        this.y = f3;
        return this;
    }

    public Rectangle setSize(float f2, float f3) {
        this.width = f2;
        this.height = f3;
        return this;
    }

    public Rectangle setSize(float f2) {
        this.width = f2;
        this.height = f2;
        return this;
    }

    public Vector2 getSize(Vector2 vector2) {
        return vector2.set(this.width, this.height);
    }

    @Override
    public boolean contains(float f2, float f3) {
        return this.x <= f2 && this.x + this.width >= f2 && this.y <= f3 && this.y + this.height >= f3;
    }

    @Override
    public boolean contains(Vector2 vector2) {
        return this.contains(vector2.x, vector2.y);
    }

    public boolean contains(Circle circle) {
        return circle.x - circle.radius >= this.x && circle.x + circle.radius <= this.x + this.width && circle.y - circle.radius >= this.y && circle.y + circle.radius <= this.y + this.height;
    }

    public boolean contains(Rectangle rectangle) {
        float f2 = rectangle.x;
        float f3 = f2 + rectangle.width;
        float f4 = rectangle.y;
        float f5 = f4 + rectangle.height;
        return f2 > this.x && f2 < this.x + this.width && f3 > this.x && f3 < this.x + this.width && f4 > this.y && f4 < this.y + this.height && f5 > this.y && f5 < this.y + this.height;
    }

    public boolean overlaps(Rectangle rectangle) {
        return this.x < rectangle.x + rectangle.width && this.x + this.width > rectangle.x && this.y < rectangle.y + rectangle.height && this.y + this.height > rectangle.y;
    }

    public Rectangle set(Rectangle rectangle) {
        this.x = rectangle.x;
        this.y = rectangle.y;
        this.width = rectangle.width;
        this.height = rectangle.height;
        return this;
    }

    public Rectangle merge(Rectangle rectangle) {
        float f2 = Math.min(this.x, rectangle.x);
        float f3 = Math.max(this.x + this.width, rectangle.x + rectangle.width);
        this.x = f2;
        this.width = f3 - f2;
        float f4 = Math.min(this.y, rectangle.y);
        float f5 = Math.max(this.y + this.height, rectangle.y + rectangle.height);
        this.y = f4;
        this.height = f5 - f4;
        return this;
    }

    public Rectangle merge(float f2, float f3) {
        float f4 = Math.min(this.x, f2);
        float f5 = Math.max(this.x + this.width, f2);
        this.x = f4;
        this.width = f5 - f4;
        float f6 = Math.min(this.y, f3);
        float f7 = Math.max(this.y + this.height, f3);
        this.y = f6;
        this.height = f7 - f6;
        return this;
    }

    public Rectangle merge(Vector2 vector2) {
        return this.merge(vector2.x, vector2.y);
    }

    public Rectangle merge(Vector2[] vector2Array) {
        float f2 = this.x;
        float f3 = this.x + this.width;
        float f4 = this.y;
        float f5 = this.y + this.height;
        for (int i2 = 0; i2 < vector2Array.length; ++i2) {
            Vector2 vector2 = vector2Array[i2];
            f2 = Math.min(f2, vector2.x);
            f3 = Math.max(f3, vector2.x);
            f4 = Math.min(f4, vector2.y);
            f5 = Math.max(f5, vector2.y);
        }
        this.x = f2;
        this.width = f3 - f2;
        this.y = f4;
        this.height = f5 - f4;
        return this;
    }

    public float getAspectRatio() {
        return this.height == 0.0f ? Float.NaN : this.width / this.height;
    }

    public Vector2 getCenter(Vector2 vector2) {
        vector2.x = this.x + this.width / 2.0f;
        vector2.y = this.y + this.height / 2.0f;
        return vector2;
    }

    public Rectangle setCenter(float f2, float f3) {
        this.setPosition(f2 - this.width / 2.0f, f3 - this.height / 2.0f);
        return this;
    }

    public Rectangle setCenter(Vector2 vector2) {
        this.setPosition(vector2.x - this.width / 2.0f, vector2.y - this.height / 2.0f);
        return this;
    }

    public Rectangle fitOutside(Rectangle rectangle) {
        float f2 = this.getAspectRatio();
        if (f2 > rectangle.getAspectRatio()) {
            this.setSize(rectangle.height * f2, rectangle.height);
        } else {
            this.setSize(rectangle.width, rectangle.width / f2);
        }
        this.setPosition(rectangle.x + rectangle.width / 2.0f - this.width / 2.0f, rectangle.y + rectangle.height / 2.0f - this.height / 2.0f);
        return this;
    }

    public Rectangle fitInside(Rectangle rectangle) {
        float f2 = this.getAspectRatio();
        if (f2 < rectangle.getAspectRatio()) {
            this.setSize(rectangle.height * f2, rectangle.height);
        } else {
            this.setSize(rectangle.width, rectangle.width / f2);
        }
        this.setPosition(rectangle.x + rectangle.width / 2.0f - this.width / 2.0f, rectangle.y + rectangle.height / 2.0f - this.height / 2.0f);
        return this;
    }

    public String toString() {
        return "[" + this.x + "," + this.y + "," + this.width + "," + this.height + "]";
    }

    public Rectangle fromString(String string) {
        int n2 = string.indexOf(44, 1);
        int n3 = string.indexOf(44, n2 + 1);
        int n4 = string.indexOf(44, n3 + 1);
        if (n2 != -1 && n3 != -1 && n4 != -1 && string.charAt(0) == '[' && string.charAt(string.length() - 1) == ']') {
            try {
                float f2 = Float.parseFloat(string.substring(1, n2));
                float f3 = Float.parseFloat(string.substring(n2 + 1, n3));
                float f4 = Float.parseFloat(string.substring(n3 + 1, n4));
                float f5 = Float.parseFloat(string.substring(n4 + 1, string.length() - 1));
                return this.set(f2, f3, f4, f5);
            }
            catch (NumberFormatException numberFormatException) {
                // empty catch block
            }
        }
        throw new GdxRuntimeException("Malformed Rectangle: " + string);
    }

    public float area() {
        return this.width * this.height;
    }

    public float perimeter() {
        return 2.0f * (this.width + this.height);
    }

    public int hashCode() {
        int n2 = 31;
        int n3 = 1;
        n3 = 31 * n3 + NumberUtils.floatToRawIntBits(this.height);
        n3 = 31 * n3 + NumberUtils.floatToRawIntBits(this.width);
        n3 = 31 * n3 + NumberUtils.floatToRawIntBits(this.x);
        n3 = 31 * n3 + NumberUtils.floatToRawIntBits(this.y);
        return n3;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (this.getClass() != object.getClass()) {
            return false;
        }
        Rectangle rectangle = (Rectangle)object;
        if (NumberUtils.floatToRawIntBits(this.height) != NumberUtils.floatToRawIntBits(rectangle.height)) {
            return false;
        }
        if (NumberUtils.floatToRawIntBits(this.width) != NumberUtils.floatToRawIntBits(rectangle.width)) {
            return false;
        }
        if (NumberUtils.floatToRawIntBits(this.x) != NumberUtils.floatToRawIntBits(rectangle.x)) {
            return false;
        }
        return NumberUtils.floatToRawIntBits(this.y) == NumberUtils.floatToRawIntBits(rectangle.y);
    }
}

