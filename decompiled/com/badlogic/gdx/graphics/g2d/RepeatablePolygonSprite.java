/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g2d;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.PolygonSpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.EarClippingTriangulator;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ShortArray;

public class RepeatablePolygonSprite {
    private TextureRegion region;
    private float density;
    private boolean dirty = true;
    private Array<float[]> parts = new Array();
    private Array<float[]> vertices = new Array();
    private Array<short[]> indices = new Array();
    private int cols;
    private int rows;
    private float gridWidth;
    private float gridHeight;
    public float x = 0.0f;
    public float y = 0.0f;
    private Color color = Color.WHITE;
    private Vector2 offset = new Vector2();

    public void setPolygon(TextureRegion textureRegion, float[] fArray) {
        this.setPolygon(textureRegion, fArray, -1.0f);
    }

    public void setPolygon(TextureRegion textureRegion, float[] fArray, float f2) {
        this.region = textureRegion;
        fArray = this.offset(fArray);
        Polygon polygon = new Polygon(fArray);
        Polygon polygon2 = new Polygon();
        Polygon polygon3 = new Polygon();
        EarClippingTriangulator earClippingTriangulator = new EarClippingTriangulator();
        Rectangle rectangle = polygon.getBoundingRectangle();
        if (f2 == -1.0f) {
            f2 = rectangle.getWidth() / (float)textureRegion.getRegionWidth();
        }
        float f3 = (float)textureRegion.getRegionHeight() / (float)textureRegion.getRegionWidth();
        this.cols = (int)Math.ceil(f2);
        this.gridWidth = rectangle.getWidth() / f2;
        this.gridHeight = f3 * this.gridWidth;
        this.rows = (int)Math.ceil(rectangle.getHeight() / this.gridHeight);
        for (int i2 = 0; i2 < this.cols; ++i2) {
            for (int i3 = 0; i3 < this.rows; ++i3) {
                float[] fArray2 = new float[8];
                int n2 = 0;
                fArray2[n2++] = (float)i2 * this.gridWidth;
                fArray2[n2++] = (float)i3 * this.gridHeight;
                fArray2[n2++] = (float)i2 * this.gridWidth;
                fArray2[n2++] = (float)(i3 + 1) * this.gridHeight;
                fArray2[n2++] = (float)(i2 + 1) * this.gridWidth;
                fArray2[n2++] = (float)(i3 + 1) * this.gridHeight;
                fArray2[n2++] = (float)(i2 + 1) * this.gridWidth;
                fArray2[n2] = (float)i3 * this.gridHeight;
                polygon2.setVertices(fArray2);
                Intersector.intersectPolygons(polygon, polygon2, polygon3);
                fArray2 = polygon3.getVertices();
                if (fArray2.length > 0) {
                    this.parts.add(this.snapToGrid(fArray2));
                    ShortArray shortArray = earClippingTriangulator.computeTriangles(fArray2);
                    this.indices.add(shortArray.toArray());
                    continue;
                }
                this.parts.add(null);
            }
        }
        this.buildVertices();
    }

    private float[] snapToGrid(float[] fArray) {
        for (int i2 = 0; i2 < fArray.length; i2 += 2) {
            float f2 = fArray[i2] / this.gridWidth % 1.0f;
            float f3 = fArray[i2 + 1] / this.gridHeight % 1.0f;
            if (f2 > 0.99f || f2 < 0.01f) {
                fArray[i2] = this.gridWidth * (float)Math.round(fArray[i2] / this.gridWidth);
            }
            if (!(f3 > 0.99f) && !(f3 < 0.01f)) continue;
            fArray[i2 + 1] = this.gridHeight * (float)Math.round(fArray[i2 + 1] / this.gridHeight);
        }
        return fArray;
    }

    private float[] offset(float[] fArray) {
        int n2;
        this.offset.set(fArray[0], fArray[1]);
        for (n2 = 0; n2 < fArray.length - 1; n2 += 2) {
            if (this.offset.x > fArray[n2]) {
                this.offset.x = fArray[n2];
            }
            if (!(this.offset.y > fArray[n2 + 1])) continue;
            this.offset.y = fArray[n2 + 1];
        }
        for (n2 = 0; n2 < fArray.length; n2 += 2) {
            int n3 = n2;
            fArray[n3] = fArray[n3] - this.offset.x;
            int n4 = n2 + 1;
            fArray[n4] = fArray[n4] - this.offset.y;
        }
        return fArray;
    }

    private void buildVertices() {
        this.vertices.clear();
        for (int i2 = 0; i2 < this.parts.size; ++i2) {
            float[] fArray = this.parts.get(i2);
            if (fArray == null) continue;
            float[] fArray2 = new float[5 * fArray.length / 2];
            int n2 = 0;
            int n3 = i2 / this.rows;
            int n4 = i2 % this.rows;
            for (int i3 = 0; i3 < fArray.length; i3 += 2) {
                fArray2[n2++] = fArray[i3] + this.offset.x + this.x;
                fArray2[n2++] = fArray[i3 + 1] + this.offset.y + this.y;
                fArray2[n2++] = this.color.toFloatBits();
                float f2 = fArray[i3] % this.gridWidth / this.gridWidth;
                float f3 = fArray[i3 + 1] % this.gridHeight / this.gridHeight;
                if (fArray[i3] == (float)n3 * this.gridWidth) {
                    f2 = 0.0f;
                }
                if (fArray[i3] == (float)(n3 + 1) * this.gridWidth) {
                    f2 = 1.0f;
                }
                if (fArray[i3 + 1] == (float)n4 * this.gridHeight) {
                    f3 = 0.0f;
                }
                if (fArray[i3 + 1] == (float)(n4 + 1) * this.gridHeight) {
                    f3 = 1.0f;
                }
                f2 = this.region.getU() + (this.region.getU2() - this.region.getU()) * f2;
                f3 = this.region.getV() + (this.region.getV2() - this.region.getV()) * f3;
                fArray2[n2++] = f2;
                fArray2[n2++] = f3;
            }
            this.vertices.add(fArray2);
        }
        this.dirty = false;
    }

    public void draw(PolygonSpriteBatch polygonSpriteBatch) {
        if (this.dirty) {
            this.buildVertices();
        }
        for (int i2 = 0; i2 < this.vertices.size; ++i2) {
            polygonSpriteBatch.draw(this.region.getTexture(), this.vertices.get(i2), 0, this.vertices.get(i2).length, this.indices.get(i2), 0, this.indices.get(i2).length);
        }
    }

    public void setColor(Color color) {
        this.color = color;
        this.dirty = true;
    }

    public void setPosition(float f2, float f3) {
        this.x = f2;
        this.y = f3;
        this.dirty = true;
    }
}

