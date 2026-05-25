/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.math;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;

public class CumulativeDistribution<T> {
    private Array<CumulativeValue> values = new Array(false, 10, CumulativeValue.class);

    public void add(T t2, float f2) {
        this.values.add(new CumulativeValue(t2, 0.0f, f2));
    }

    public void add(T t2) {
        this.values.add(new CumulativeValue(t2, 0.0f, 0.0f));
    }

    public void generate() {
        float f2 = 0.0f;
        for (int i2 = 0; i2 < this.values.size; ++i2) {
            ((CumulativeValue[])this.values.items)[i2].frequency = f2 += ((CumulativeValue[])this.values.items)[i2].interval;
        }
    }

    public void generateNormalized() {
        float f2 = 0.0f;
        for (int i2 = 0; i2 < this.values.size; ++i2) {
            f2 += ((CumulativeValue[])this.values.items)[i2].interval;
        }
        float f3 = 0.0f;
        for (int i3 = 0; i3 < this.values.size; ++i3) {
            ((CumulativeValue[])this.values.items)[i3].frequency = f3 += ((CumulativeValue[])this.values.items)[i3].interval / f2;
        }
    }

    public void generateUniform() {
        float f2 = 1.0f / (float)this.values.size;
        for (int i2 = 0; i2 < this.values.size; ++i2) {
            ((CumulativeValue[])this.values.items)[i2].interval = f2;
            ((CumulativeValue[])this.values.items)[i2].frequency = (float)(i2 + 1) * f2;
        }
    }

    public T value(float f2) {
        CumulativeValue cumulativeValue = null;
        int n2 = this.values.size - 1;
        int n3 = 0;
        while (n3 <= n2) {
            int n4 = n3 + (n2 - n3) / 2;
            cumulativeValue = ((CumulativeValue[])this.values.items)[n4];
            if (f2 < cumulativeValue.frequency) {
                n2 = n4 - 1;
                continue;
            }
            if (!(f2 > cumulativeValue.frequency)) break;
            n3 = n4 + 1;
        }
        return ((CumulativeValue[])this.values.items)[n3].value;
    }

    public T value() {
        return this.value(MathUtils.random());
    }

    public int size() {
        return this.values.size;
    }

    public float getInterval(int n2) {
        return ((CumulativeValue[])this.values.items)[n2].interval;
    }

    public T getValue(int n2) {
        return ((CumulativeValue[])this.values.items)[n2].value;
    }

    public void setInterval(T t2, float f2) {
        for (CumulativeValue cumulativeValue : this.values) {
            if (cumulativeValue.value != t2) continue;
            cumulativeValue.interval = f2;
            return;
        }
    }

    public void setInterval(int n2, float f2) {
        ((CumulativeValue[])this.values.items)[n2].interval = f2;
    }

    public void clear() {
        this.values.clear();
    }

    public class CumulativeValue {
        public T value;
        public float frequency;
        public float interval;

        public CumulativeValue(T t2, float f2, float f3) {
            this.value = t2;
            this.frequency = f2;
            this.interval = f3;
        }
    }
}

