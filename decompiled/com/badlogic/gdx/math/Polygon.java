/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.math;

import com.badlogic.gdx.math.GeometryUtils;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Shape2D;
import com.badlogic.gdx.math.Vector2;

public class Polygon
implements Shape2D {
    private float[] localVertices;
    private float[] worldVertices;
    private float x;
    private float y;
    private float originX;
    private float originY;
    private float rotation;
    private float scaleX = 1.0f;
    private float scaleY = 1.0f;
    private boolean dirty = true;
    private Rectangle bounds;

    public Polygon() {
        this.localVertices = new float[0];
    }

    public Polygon(float[] fArray) {
        if (fArray.length < 6) {
            throw new IllegalArgumentException("polygons must contain at least 3 points.");
        }
        this.localVertices = fArray;
    }

    public float[] getVertices() {
        return this.localVertices;
    }

    public float[] getTransformedVertices() {
        if (!this.dirty) {
            return this.worldVertices;
        }
        this.dirty = false;
        float[] fArray = this.localVertices;
        if (this.worldVertices == null || this.worldVertices.length != fArray.length) {
            this.worldVertices = new float[fArray.length];
        }
        float[] fArray2 = this.worldVertices;
        float f2 = this.x;
        float f3 = this.y;
        float f4 = this.originX;
        float f5 = this.originY;
        float f6 = this.scaleX;
        float f7 = this.scaleY;
        boolean bl2 = f6 != 1.0f || f7 != 1.0f;
        float f8 = this.rotation;
        float f9 = MathUtils.cosDeg(f8);
        float f10 = MathUtils.sinDeg(f8);
        int n2 = fArray.length;
        for (int i2 = 0; i2 < n2; i2 += 2) {
            float f11 = fArray[i2] - f4;
            float f12 = fArray[i2 + 1] - f5;
            if (bl2) {
                f11 *= f6;
                f12 *= f7;
            }
            if (f8 != 0.0f) {
                float f13 = f11;
                f11 = f9 * f11 - f10 * f12;
                f12 = f10 * f13 + f9 * f12;
            }
            fArray2[i2] = f2 + f11 + f4;
            fArray2[i2 + 1] = f3 + f12 + f5;
        }
        return fArray2;
    }

    public void setOrigin(float f2, float f3) {
        this.originX = f2;
        this.originY = f3;
        this.dirty = true;
    }

    public void setPosition(float f2, float f3) {
        this.x = f2;
        this.y = f3;
        this.dirty = true;
    }

    public void setVertices(float[] fArray) {
        if (fArray.length < 6) {
            throw new IllegalArgumentException("polygons must contain at least 3 points.");
        }
        this.localVertices = fArray;
        this.dirty = true;
    }

    public void setVertex(int n2, float f2, float f3) {
        if (n2 < 0 || n2 > this.localVertices.length / 2 - 1) {
            throw new IllegalArgumentException("the vertex " + n2 + " doesn't exist");
        }
        this.localVertices[2 * n2] = f2;
        this.localVertices[2 * n2 + 1] = f3;
        this.dirty = true;
    }

    public void translate(float f2, float f3) {
        this.x += f2;
        this.y += f3;
        this.dirty = true;
    }

    public void setRotation(float f2) {
        this.rotation = f2;
        this.dirty = true;
    }

    public void rotate(float f2) {
        this.rotation += f2;
        this.dirty = true;
    }

    public void setScale(float f2, float f3) {
        this.scaleX = f2;
        this.scaleY = f3;
        this.dirty = true;
    }

    public void scale(float f2) {
        this.scaleX += f2;
        this.scaleY += f2;
        this.dirty = true;
    }

    public void dirty() {
        this.dirty = true;
    }

    public float area() {
        float[] fArray = this.getTransformedVertices();
        return GeometryUtils.polygonArea(fArray, 0, fArray.length);
    }

    public int getVertexCount() {
        return this.localVertices.length / 2;
    }

    public Vector2 getVertex(int n2, Vector2 vector2) {
        if (n2 < 0 || n2 > this.getVertexCount()) {
            throw new IllegalArgumentException("the vertex " + n2 + " doesn't exist");
        }
        float[] fArray = this.getTransformedVertices();
        return vector2.set(fArray[2 * n2], fArray[2 * n2 + 1]);
    }

    public Vector2 getCentroid(Vector2 vector2) {
        float[] fArray = this.getTransformedVertices();
        return GeometryUtils.polygonCentroid(fArray, 0, fArray.length, vector2);
    }

    public Rectangle getBoundingRectangle() {
        float[] fArray = this.getTransformedVertices();
        float f2 = fArray[0];
        float f3 = fArray[1];
        float f4 = fArray[0];
        float f5 = fArray[1];
        int n2 = fArray.length;
        for (int i2 = 2; i2 < n2; i2 += 2) {
            f2 = f2 > fArray[i2] ? fArray[i2] : f2;
            f3 = f3 > fArray[i2 + 1] ? fArray[i2 + 1] : f3;
            f4 = f4 < fArray[i2] ? fArray[i2] : f4;
            f5 = f5 < fArray[i2 + 1] ? fArray[i2 + 1] : f5;
        }
        if (this.bounds == null) {
            this.bounds = new Rectangle();
        }
        this.bounds.x = f2;
        this.bounds.y = f3;
        this.bounds.width = f4 - f2;
        this.bounds.height = f5 - f3;
        return this.bounds;
    }

    @Override
    public boolean contains(float f2, float f3) {
        float[] fArray = this.getTransformedVertices();
        int n2 = fArray.length;
        int n3 = 0;
        for (int i2 = 0; i2 < n2; i2 += 2) {
            float f4 = fArray[i2];
            float f5 = fArray[i2 + 1];
            float f6 = fArray[(i2 + 2) % n2];
            float f7 = fArray[(i2 + 3) % n2];
            if (!(f5 <= f3 && f3 < f7) && (!(f7 <= f3) || !(f3 < f5)) || !(f2 < (f6 - f4) / (f7 - f5) * (f3 - f5) + f4)) continue;
            ++n3;
        }
        return n3 & true;
    }

    @Override
    public boolean contains(Vector2 vector2) {
        return this.contains(vector2.x, vector2.y);
    }

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }

    public float getOriginX() {
        return this.originX;
    }

    public float getOriginY() {
        return this.originY;
    }

    public float getRotation() {
        return this.rotation;
    }

    public float getScaleX() {
        return this.scaleX;
    }

    public float getScaleY() {
        return this.scaleY;
    }
}

