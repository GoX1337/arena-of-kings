/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils.viewport;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.Viewport;

public class ScalingViewport
extends Viewport {
    private Scaling scaling;

    public ScalingViewport(Scaling scaling, float f2, float f3) {
        this(scaling, f2, f3, new OrthographicCamera());
    }

    public ScalingViewport(Scaling scaling, float f2, float f3, Camera camera) {
        this.scaling = scaling;
        this.setWorldSize(f2, f3);
        this.setCamera(camera);
    }

    @Override
    public void update(int n2, int n3, boolean bl2) {
        Vector2 vector2 = this.scaling.apply(this.getWorldWidth(), this.getWorldHeight(), n2, n3);
        int n4 = Math.round(vector2.x);
        int n5 = Math.round(vector2.y);
        this.setScreenBounds((n2 - n4) / 2, (n3 - n5) / 2, n4, n5);
        this.apply(bl2);
    }

    public Scaling getScaling() {
        return this.scaling;
    }

    public void setScaling(Scaling scaling) {
        this.scaling = scaling;
    }
}

