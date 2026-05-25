/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.PerformanceCounter;
import com.badlogic.gdx.utils.StringBuilder;
import com.badlogic.gdx.utils.TimeUtils;

public class PerformanceCounters {
    private static final float nano2seconds = 1.0E-9f;
    private long lastTick = 0L;
    public final Array<PerformanceCounter> counters = new Array();

    public PerformanceCounter add(String string, int n2) {
        PerformanceCounter performanceCounter = new PerformanceCounter(string, n2);
        this.counters.add(performanceCounter);
        return performanceCounter;
    }

    public PerformanceCounter add(String string) {
        PerformanceCounter performanceCounter = new PerformanceCounter(string);
        this.counters.add(performanceCounter);
        return performanceCounter;
    }

    public void tick() {
        long l2 = TimeUtils.nanoTime();
        if (this.lastTick > 0L) {
            this.tick((float)(l2 - this.lastTick) * 1.0E-9f);
        }
        this.lastTick = l2;
    }

    public void tick(float f2) {
        for (int i2 = 0; i2 < this.counters.size; ++i2) {
            this.counters.get(i2).tick(f2);
        }
    }

    public StringBuilder toString(StringBuilder stringBuilder) {
        stringBuilder.setLength(0);
        for (int i2 = 0; i2 < this.counters.size; ++i2) {
            if (i2 != 0) {
                stringBuilder.append("; ");
            }
            this.counters.get(i2).toString(stringBuilder);
        }
        return stringBuilder;
    }
}

