/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.math;

public final class WindowedMean {
    float[] values;
    int added_values = 0;
    int last_value;
    float mean = 0.0f;
    boolean dirty = true;

    public WindowedMean(int n2) {
        this.values = new float[n2];
    }

    public boolean hasEnoughData() {
        return this.added_values >= this.values.length;
    }

    public void clear() {
        this.added_values = 0;
        this.last_value = 0;
        for (int i2 = 0; i2 < this.values.length; ++i2) {
            this.values[i2] = 0.0f;
        }
        this.dirty = true;
    }

    public void addValue(float f2) {
        if (this.added_values < this.values.length) {
            ++this.added_values;
        }
        this.values[this.last_value++] = f2;
        if (this.last_value > this.values.length - 1) {
            this.last_value = 0;
        }
        this.dirty = true;
    }

    public float getMean() {
        if (this.hasEnoughData()) {
            if (this.dirty) {
                float f2 = 0.0f;
                for (int i2 = 0; i2 < this.values.length; ++i2) {
                    f2 += this.values[i2];
                }
                this.mean = f2 / (float)this.values.length;
                this.dirty = false;
            }
            return this.mean;
        }
        return 0.0f;
    }

    public float getOldest() {
        return this.added_values < this.values.length ? this.values[0] : this.values[this.last_value];
    }

    public float getLatest() {
        return this.values[this.last_value - 1 == -1 ? this.values.length - 1 : this.last_value - 1];
    }

    public float standardDeviation() {
        if (!this.hasEnoughData()) {
            return 0.0f;
        }
        float f2 = this.getMean();
        float f3 = 0.0f;
        for (int i2 = 0; i2 < this.values.length; ++i2) {
            f3 += (this.values[i2] - f2) * (this.values[i2] - f2);
        }
        return (float)Math.sqrt(f3 / (float)this.values.length);
    }

    public float getLowest() {
        float f2 = Float.MAX_VALUE;
        for (int i2 = 0; i2 < this.values.length; ++i2) {
            f2 = Math.min(f2, this.values[i2]);
        }
        return f2;
    }

    public float getHighest() {
        float f2 = Float.MIN_NORMAL;
        for (int i2 = 0; i2 < this.values.length; ++i2) {
            f2 = Math.max(f2, this.values[i2]);
        }
        return f2;
    }

    public int getValueCount() {
        return this.added_values;
    }

    public int getWindowSize() {
        return this.values.length;
    }

    public float[] getWindowValues() {
        float[] fArray = new float[this.added_values];
        if (this.hasEnoughData()) {
            for (int i2 = 0; i2 < fArray.length; ++i2) {
                fArray[i2] = this.values[(i2 + this.last_value) % this.values.length];
            }
        } else {
            System.arraycopy(this.values, 0, fArray, 0, this.added_values);
        }
        return fArray;
    }
}

