/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils.viewport;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.Viewport;

public class ScreenViewport
extends Viewport {
    private float unitsPerPixel = 1.0f;

    public ScreenViewport() {
        this(new OrthographicCamera());
    }

    public ScreenViewport(Camera camera) {
        this.setCamera(camera);
    }

    @Override
    public void update(int n2, int n3, boolean bl2) {
        this.setScreenBounds(0, 0, n2, n3);
        this.setWorldSize((float)n2 * this.unitsPerPixel, (float)n3 * this.unitsPerPixel);
        this.apply(bl2);
    }

    public float getUnitsPerPixel() {
        return this.unitsPerPixel;
    }

    public void setUnitsPerPixel(float f2) {
        this.unitsPerPixel = f2;
    }
}

