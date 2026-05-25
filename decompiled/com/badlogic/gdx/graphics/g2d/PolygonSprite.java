/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g2d;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.PolygonRegion;
import com.badlogic.gdx.graphics.g2d.PolygonSpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;

public class PolygonSprite {
    PolygonRegion region;
    private float x;
    private float y;
    private float width;
    private float height;
    private float scaleX = 1.0f;
    private float scaleY = 1.0f;
    private float rotation;
    private float originX;
    private float originY;
    private float[] vertices;
    private boolean dirty;
    private Rectangle bounds = new Rectangle();
    private final Color color = new Color(1.0f, 1.0f, 1.0f, 1.0f);

    public PolygonSprite(PolygonRegion polygonRegion) {
        this.setRegion(polygonRegion);
        this.setSize(polygonRegion.region.regionWidth, polygonRegion.region.regionHeight);
        this.setOrigin(this.width / 2.0f, this.height / 2.0f);
    }

    public PolygonSprite(PolygonSprite polygonSprite) {
        this.set(polygonSprite);
    }

    public void set(PolygonSprite polygonSprite) {
        if (polygonSprite == null) {
            throw new IllegalArgumentException("sprite cannot be null.");
        }
        this.setRegion(polygonSprite.region);
        this.x = polygonSprite.x;
        this.y = polygonSprite.y;
        this.width = polygonSprite.width;
        this.height = polygonSprite.height;
        this.originX = polygonSprite.originX;
        this.originY = polygonSprite.originY;
        this.rotation = polygonSprite.rotation;
        this.scaleX = polygonSprite.scaleX;
        this.scaleY = polygonSprite.scaleY;
        this.color.set(polygonSprite.color);
    }

    public void setBounds(float f2, float f3, float f4, float f5) {
        this.x = f2;
        this.y = f3;
        this.width = f4;
        this.height = f5;
        this.dirty = true;
    }

    public void setSize(float f2, float f3) {
        this.width = f2;
        this.height = f3;
        this.dirty = true;
    }

    public void setPosition(float f2, float f3) {
        this.translate(f2 - this.x, f3 - this.y);
    }

    public void setX(float f2) {
        this.translateX(f2 - this.x);
    }

    public void setY(float f2) {
        this.translateY(f2 - this.y);
    }

    public void translateX(float f2) {
        this.x += f2;
        if (this.dirty) {
            return;
        }
        float[] fArray = this.vertices;
        for (int i2 = 0; i2 < fArray.length; i2 += 5) {
            int n2 = i2;
            fArray[n2] = fArray[n2] + f2;
        }
    }

    public void translateY(float f2) {
        this.y += f2;
        if (this.dirty) {
            return;
        }
        float[] fArray = this.vertices;
        for (int i2 = 1; i2 < fArray.length; i2 += 5) {
            int n2 = i2;
            fArray[n2] = fArray[n2] + f2;
        }
    }

    public void translate(float f2, float f3) {
        this.x += f2;
        this.y += f3;
        if (this.dirty) {
            return;
        }
        float[] fArray = this.vertices;
        for (int i2 = 0; i2 < fArray.length; i2 += 5) {
            int n2 = i2;
            fArray[n2] = fArray[n2] + f2;
            int n3 = i2 + 1;
            fArray[n3] = fArray[n3] + f3;
        }
    }

    public void setColor(Color color) {
        this.color.set(color);
        float f2 = color.toFloatBits();
        float[] fArray = this.vertices;
        for (int i2 = 2; i2 < fArray.length; i2 += 5) {
            fArray[i2] = f2;
        }
    }

    public void setColor(float f2, float f3, float f4, float f5) {
        this.color.set(f2, f3, f4, f5);
        float f6 = this.color.toFloatBits();
        float[] fArray = this.vertices;
        for (int i2 = 2; i2 < fArray.length; i2 += 5) {
            fArray[i2] = f6;
        }
    }

    public void setOrigin(float f2, float f3) {
        this.originX = f2;
        this.originY = f3;
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

    public void setScale(float f2) {
        this.scaleX = f2;
        this.scaleY = f2;
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

    public float[] getVertices() {
        if (!this.dirty) {
            return this.vertices;
        }
        this.dirty = false;
        float f2 = this.originX;
        float f3 = this.originY;
        float f4 = this.scaleX;
        float f5 = this.scaleY;
        PolygonRegion polygonRegion = this.region;
        float[] fArray = this.vertices;
        float[] fArray2 = polygonRegion.vertices;
        float f6 = this.x + f2;
        float f7 = this.y + f3;
        float f8 = this.width / (float)polygonRegion.region.getRegionWidth();
        float f9 = this.height / (float)polygonRegion.region.getRegionHeight();
        float f10 = MathUtils.cosDeg(this.rotation);
        float f11 = MathUtils.sinDeg(this.rotation);
        int n2 = 0;
        int n3 = 0;
        int n4 = fArray2.length;
        while (n2 < n4) {
            float f12 = (fArray2[n2] * f8 - f2) * f4;
            float f13 = (fArray2[n2 + 1] * f9 - f3) * f5;
            fArray[n3] = f10 * f12 - f11 * f13 + f6;
            fArray[n3 + 1] = f11 * f12 + f10 * f13 + f7;
            n2 += 2;
            n3 += 5;
        }
        return fArray;
    }

    public Rectangle getBoundingRectangle() {
        float[] fArray = this.getVertices();
        float f2 = fArray[0];
        float f3 = fArray[1];
        float f4 = fArray[0];
        float f5 = fArray[1];
        for (int i2 = 5; i2 < fArray.length; i2 += 5) {
            float f6 = fArray[i2];
            float f7 = fArray[i2 + 1];
            f2 = f2 > f6 ? f6 : f2;
            f4 = f4 < f6 ? f6 : f4;
            f3 = f3 > f7 ? f7 : f3;
            f5 = f5 < f7 ? f7 : f5;
        }
        this.bounds.x = f2;
        this.bounds.y = f3;
        this.bounds.width = f4 - f2;
        this.bounds.height = f5 - f3;
        return this.bounds;
    }

    public void draw(PolygonSpriteBatch polygonSpriteBatch) {
        PolygonRegion polygonRegion = this.region;
        polygonSpriteBatch.draw(polygonRegion.region.texture, this.getVertices(), 0, this.vertices.length, polygonRegion.triangles, 0, polygonRegion.triangles.length);
    }

    public void draw(PolygonSpriteBatch polygonSpriteBatch, float f2) {
        Color color = this.getColor();
        float f3 = color.a;
        color.a *= f2;
        this.setColor(color);
        this.draw(polygonSpriteBatch);
        color.a = f3;
        this.setColor(color);
    }

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }

    public float getWidth() {
        return this.width;
    }

    public float getHeight() {
        return this.height;
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

    public Color getColor() {
        return this.color;
    }

    public Color getPackedColor() {
        Color.abgr8888ToColor(this.color, this.vertices[2]);
        return this.color;
    }

    public void setRegion(PolygonRegion polygonRegion) {
        this.region = polygonRegion;
        float[] fArray = polygonRegion.vertices;
        float[] fArray2 = polygonRegion.textureCoords;
        int n2 = fArray.length / 2 * 5;
        if (this.vertices == null || this.vertices.length != n2) {
            this.vertices = new float[n2];
        }
        float f2 = this.color.toFloatBits();
        float[] fArray3 = this.vertices;
        int n3 = 0;
        for (int i2 = 2; i2 < n2; i2 += 5) {
            fArray3[i2] = f2;
            fArray3[i2 + 1] = fArray2[n3];
            fArray3[i2 + 2] = fArray2[n3 + 1];
            n3 += 2;
        }
        this.dirty = true;
    }

    public PolygonRegion getRegion() {
        return this.region;
    }
}

