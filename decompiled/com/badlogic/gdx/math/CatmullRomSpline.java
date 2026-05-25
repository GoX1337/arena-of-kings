/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.math;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Path;
import com.badlogic.gdx.math.Vector;

public class CatmullRomSpline<T extends Vector<T>>
implements Path<T> {
    public T[] controlPoints;
    public boolean continuous;
    public int spanCount;
    private T tmp;
    private T tmp2;
    private T tmp3;

    public static <T extends Vector<T>> T calculate(T t2, float f2, T[] TArray, boolean bl2, T t3) {
        int n2 = bl2 ? TArray.length : TArray.length - 3;
        float f3 = f2 * (float)n2;
        int n3 = f2 >= 1.0f ? n2 - 1 : (int)f3;
        return (T)CatmullRomSpline.calculate(t2, (int)n3, (float)(f3 -= (float)n3), TArray, (boolean)bl2, t3);
    }

    public static <T extends Vector<T>> T calculate(T object, int n2, float f2, T[] TArray, boolean bl2, T object2) {
        int n3 = TArray.length;
        float f3 = f2 * f2;
        float f4 = f3 * f2;
        object.set(TArray[n2]).scl((float)(1.5f * f4 - 2.5f * f3 + 1.0f));
        if (bl2 || n2 > 0) {
            object.add(object2.set(TArray[(n3 + n2 - 1) % n3]).scl((float)(-0.5f * f4 + f3 - 0.5f * f2)));
        }
        if (bl2 || n2 < n3 - 1) {
            object.add(object2.set(TArray[(n2 + 1) % n3]).scl((float)(-1.5f * f4 + 2.0f * f3 + 0.5f * f2)));
        }
        if (bl2 || n2 < n3 - 2) {
            object.add(object2.set(TArray[(n2 + 2) % n3]).scl((float)(0.5f * f4 - 0.5f * f3)));
        }
        return (T)object;
    }

    public static <T extends Vector<T>> T derivative(T t2, float f2, T[] TArray, boolean bl2, T t3) {
        int n2 = bl2 ? TArray.length : TArray.length - 3;
        float f3 = f2 * (float)n2;
        int n3 = f2 >= 1.0f ? n2 - 1 : (int)f3;
        return (T)CatmullRomSpline.derivative(t2, (int)n3, (float)(f3 -= (float)n3), TArray, (boolean)bl2, t3);
    }

    public static <T extends Vector<T>> T derivative(T object, int n2, float f2, T[] TArray, boolean bl2, T object2) {
        int n3 = TArray.length;
        float f3 = f2 * f2;
        object.set(TArray[n2]).scl((float)(-f2 * 5.0f + f3 * 4.5f));
        if (bl2 || n2 > 0) {
            object.add(object2.set(TArray[(n3 + n2 - 1) % n3]).scl((float)(-0.5f + f2 * 2.0f - f3 * 1.5f)));
        }
        if (bl2 || n2 < n3 - 1) {
            object.add(object2.set(TArray[(n2 + 1) % n3]).scl((float)(0.5f + f2 * 4.0f - f3 * 4.5f)));
        }
        if (bl2 || n2 < n3 - 2) {
            object.add(object2.set(TArray[(n2 + 2) % n3]).scl((float)(-f2 + f3 * 1.5f)));
        }
        return (T)object;
    }

    public CatmullRomSpline() {
    }

    public CatmullRomSpline(T[] TArray, boolean bl2) {
        this.set((Vector[])TArray, bl2);
    }

    public CatmullRomSpline set(T[] TArray, boolean bl2) {
        if (this.tmp == null) {
            this.tmp = TArray[0].cpy();
        }
        if (this.tmp2 == null) {
            this.tmp2 = TArray[0].cpy();
        }
        if (this.tmp3 == null) {
            this.tmp3 = TArray[0].cpy();
        }
        this.controlPoints = TArray;
        this.continuous = bl2;
        this.spanCount = bl2 ? TArray.length : TArray.length - 3;
        return this;
    }

    @Override
    public T valueAt(T t2, float f2) {
        int n2 = this.spanCount;
        float f3 = f2 * (float)n2;
        int n3 = f2 >= 1.0f ? n2 - 1 : (int)f3;
        return this.valueAt(t2, n3, f3 -= (float)n3);
    }

    public T valueAt(T t2, int n2, float f2) {
        return (T)CatmullRomSpline.calculate(t2, (int)(this.continuous ? n2 : n2 + 1), (float)f2, this.controlPoints, (boolean)this.continuous, this.tmp);
    }

    @Override
    public T derivativeAt(T t2, float f2) {
        int n2 = this.spanCount;
        float f3 = f2 * (float)n2;
        int n3 = f2 >= 1.0f ? n2 - 1 : (int)f3;
        return this.derivativeAt(t2, n3, f3 -= (float)n3);
    }

    public T derivativeAt(T t2, int n2, float f2) {
        return (T)CatmullRomSpline.derivative(t2, (int)(this.continuous ? n2 : n2 + 1), (float)f2, this.controlPoints, (boolean)this.continuous, this.tmp);
    }

    public int nearest(T t2) {
        return this.nearest(t2, 0, this.spanCount);
    }

    public int nearest(T t2, int n2, int n3) {
        while (n2 < 0) {
            n2 += this.spanCount;
        }
        int n4 = n2 % this.spanCount;
        float f2 = t2.dst2(this.controlPoints[n4]);
        for (int i2 = 1; i2 < n3; ++i2) {
            int n5 = (n2 + i2) % this.spanCount;
            float f3 = t2.dst2(this.controlPoints[n5]);
            if (!(f3 < f2)) continue;
            f2 = f3;
            n4 = n5;
        }
        return n4;
    }

    @Override
    public float approximate(T t2) {
        return this.approximate(t2, this.nearest(t2));
    }

    public float approximate(T t2, int n2, int n3) {
        return this.approximate(t2, this.nearest(t2, n2, n3));
    }

    public float approximate(T t2, int n2) {
        T t3;
        T t4;
        T t5;
        int n3 = n2;
        T t6 = this.controlPoints[n3];
        T t7 = this.controlPoints[n3 > 0 ? n3 - 1 : this.spanCount - 1];
        T t8 = this.controlPoints[(n3 + 1) % this.spanCount];
        float f2 = t2.dst2(t7);
        float f3 = t2.dst2(t8);
        if (f3 < f2) {
            t5 = t6;
            t4 = t8;
            t3 = t2;
        } else {
            t5 = t7;
            t4 = t6;
            t3 = t2;
            n3 = n3 > 0 ? n3 - 1 : this.spanCount - 1;
        }
        float f4 = t5.dst2(t4);
        float f5 = t3.dst2(t4);
        float f6 = t3.dst2(t5);
        float f7 = (float)Math.sqrt(f4);
        float f8 = (f5 + f4 - f6) / (2.0f * f7);
        float f9 = MathUtils.clamp((f7 - f8) / f7, 0.0f, 1.0f);
        return ((float)n3 + f9) / (float)this.spanCount;
    }

    @Override
    public float locate(T t2) {
        return this.approximate(t2);
    }

    @Override
    public float approxLength(int n2) {
        float f2 = 0.0f;
        for (int i2 = 0; i2 < n2; ++i2) {
            this.tmp2.set(this.tmp3);
            this.valueAt(this.tmp3, (float)i2 / ((float)n2 - 1.0f));
            if (i2 <= 0) continue;
            f2 += this.tmp2.dst(this.tmp3);
        }
        return f2;
    }
}

