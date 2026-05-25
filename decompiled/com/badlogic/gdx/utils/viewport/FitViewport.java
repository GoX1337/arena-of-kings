/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils.viewport;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;

public class FitViewport
extends ScalingViewport {
    public FitViewport(float f2, float f3) {
        super(Scaling.fit, f2, f3);
    }

    public FitViewport(float f2, float f3, Camera camera) {
        super(Scaling.fit, f2, f3, camera);
    }
}

