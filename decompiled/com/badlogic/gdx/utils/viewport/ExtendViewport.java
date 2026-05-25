/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils.viewport;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.Viewport;

public class ExtendViewport
extends Viewport {
    private float minWorldWidth;
    private float minWorldHeight;
    private float maxWorldWidth;
    private float maxWorldHeight;
    private Scaling scaling = Scaling.fit;

    public ExtendViewport(float f2, float f3) {
        this(f2, f3, 0.0f, 0.0f, new OrthographicCamera());
    }

    public ExtendViewport(float f2, float f3, Camera camera) {
        this(f2, f3, 0.0f, 0.0f, camera);
    }

    public ExtendViewport(float f2, float f3, float f4, float f5) {
        this(f2, f3, f4, f5, new OrthographicCamera());
    }

    public ExtendViewport(float f2, float f3, float f4, float f5, Camera camera) {
        this.minWorldWidth = f2;
        this.minWorldHeight = f3;
        this.maxWorldWidth = f4;
        this.maxWorldHeight = f5;
        this.setCamera(camera);
    }

    @Override
    public void update(int n2, int n3, boolean bl2) {
        float f2;
        float f3;
        float f4;
        float f5 = this.minWorldWidth;
        float f6 = this.minWorldHeight;
        Vector2 vector2 = this.scaling.apply(f5, f6, n2, n3);
        int n4 = Math.round(vector2.x);
        int n5 = Math.round(vector2.y);
        if (n4 < n2) {
            f4 = (float)n5 / f6;
            f3 = f6 / (float)n5;
            f2 = (float)(n2 - n4) * f3;
            if (this.maxWorldWidth > 0.0f) {
                f2 = Math.min(f2, this.maxWorldWidth - this.minWorldWidth);
            }
            f5 += f2;
            n4 += Math.round(f2 * f4);
        }
        if (n5 < n3) {
            f4 = (float)n4 / f5;
            f3 = f5 / (float)n4;
            f2 = (float)(n3 - n5) * f3;
            if (this.maxWorldHeight > 0.0f) {
                f2 = Math.min(f2, this.maxWorldHeight - this.minWorldHeight);
            }
            f6 += f2;
            n5 += Math.round(f2 * f4);
        }
        this.setWorldSize(f5, f6);
        this.setScreenBounds((n2 - n4) / 2, (n3 - n5) / 2, n4, n5);
        this.apply(bl2);
    }

    public float getMinWorldWidth() {
        return this.minWorldWidth;
    }

    public void setMinWorldWidth(float f2) {
        this.minWorldWidth = f2;
    }

    public float getMinWorldHeight() {
        return this.minWorldHeight;
    }

    public void setMinWorldHeight(float f2) {
        this.minWorldHeight = f2;
    }

    public float getMaxWorldWidth() {
        return this.maxWorldWidth;
    }

    public void setMaxWorldWidth(float f2) {
        this.maxWorldWidth = f2;
    }

    public float getMaxWorldHeight() {
        return this.maxWorldHeight;
    }

    public void setMaxWorldHeight(float f2) {
        this.maxWorldHeight = f2;
    }

    public void setScaling(Scaling scaling) {
        this.scaling = scaling;
    }
}

