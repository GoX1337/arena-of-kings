/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.TimeUtils;

public class FPSLogger {
    long startTime;
    int bound;

    public FPSLogger() {
        this(Integer.MAX_VALUE);
    }

    public FPSLogger(int n2) {
        this.bound = n2;
        this.startTime = TimeUtils.nanoTime();
    }

    public void log() {
        int n2;
        long l2 = TimeUtils.nanoTime();
        if (l2 - this.startTime > 1000000000L && (n2 = Gdx.graphics.getFramesPerSecond()) < this.bound) {
            Gdx.app.log("FPSLogger", "fps: " + n2);
            this.startTime = l2;
        }
    }
}

