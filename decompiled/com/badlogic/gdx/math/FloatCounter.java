/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.math;

import com.badlogic.gdx.math.WindowedMean;
import com.badlogic.gdx.utils.Pool;

public class FloatCounter
implements Pool.Poolable {
    public int count;
    public float total;
    public float min;
    public float max;
    public float average;
    public float latest;
    public float value;
    public final WindowedMean mean;

    public FloatCounter(int n2) {
        this.mean = n2 > 1 ? new WindowedMean(n2) : null;
        this.reset();
    }

    public void put(float f2) {
        this.latest = f2;
        this.total += f2;
        ++this.count;
        this.average = this.total / (float)this.count;
        if (this.mean != null) {
            this.mean.addValue(f2);
            this.value = this.mean.getMean();
        } else {
            this.value = this.latest;
        }
        if (this.mean == null || this.mean.hasEnoughData()) {
            if (this.value < this.min) {
                this.min = this.value;
            }
            if (this.value > this.max) {
                this.max = this.value;
            }
        }
    }

    @Override
    public void reset() {
        this.count = 0;
        this.total = 0.0f;
        this.min = Float.MAX_VALUE;
        this.max = -3.4028235E38f;
        this.average = 0.0f;
        this.latest = 0.0f;
        this.value = 0.0f;
        if (this.mean != null) {
            this.mean.clear();
        }
    }

    public String toString() {
        return "FloatCounter{count=" + this.count + ", total=" + this.total + ", min=" + this.min + ", max=" + this.max + ", average=" + this.average + ", latest=" + this.latest + ", value=" + this.value + '}';
    }
}

