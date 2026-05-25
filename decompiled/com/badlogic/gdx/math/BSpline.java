/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.math;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Path;
import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.utils.Array;

public class BSpline<T extends Vector<T>>
implements Path<T> {
    private static final float d6 = 0.16666667f;
    public T[] controlPoints;
    public Array<T> knots;
    public int degree;
    public boolean continuous;
    public int spanCount;
    private T tmp;
    private T tmp2;
    private T tmp3;

    public static <T extends Vector<T>> T cubic(T t2, float f2, T[] TArray, boolean bl2, T t3) {
        int n2 = bl2 ? TArray.length : TArray.length - 3;
        float f3 = f2 * (float)n2;
        int n3 = f2 >= 1.0f ? n2 - 1 : (int)f3;
        return (T)BSpline.cubic(t2, (int)n3, (float)(f3 -= (float)n3), TArray, (boolean)bl2, t3);
    }

    public static <T extends Vector<T>> T cubic_derivative(T t2, float f2, T[] TArray, boolean bl2, T t3) {
        int n2 = bl2 ? TArray.length : TArray.length - 3;
        float f3 = f2 * (float)n2;
        int n3 = f2 >= 1.0f ? n2 - 1 : (int)f3;
        return (T)BSpline.cubic(t2, (int)n3, (float)(f3 -= (float)n3), TArray, (boolean)bl2, t3);
    }

    public static <T extends Vector<T>> T cubic(T object, int n2, float f2, T[] TArray, boolean bl2, T object2) {
        int n3 = TArray.length;
        float f3 = 1.0f - f2;
        float f4 = f2 * f2;
        float f5 = f4 * f2;
        object.set(TArray[n2]).scl((float)((3.0f * f5 - 6.0f * f4 + 4.0f) * 0.16666667f));
        if (bl2 || n2 > 0) {
            object.add(object2.set(TArray[(n3 + n2 - 1) % n3]).scl((float)(f3 * f3 * f3 * 0.16666667f)));
        }
        if (bl2 || n2 < n3 - 1) {
            object.add(object2.set(TArray[(n2 + 1) % n3]).scl((float)((-3.0f * f5 + 3.0f * f4 + 3.0f * f2 + 1.0f) * 0.16666667f)));
        }
        if (bl2 || n2 < n3 - 2) {
            object.add(object2.set(TArray[(n2 + 2) % n3]).scl((float)(f5 * 0.16666667f)));
        }
        return (T)object;
    }

    public static <T extends Vector<T>> T cubic_derivative(T object, int n2, float f2, T[] TArray, boolean bl2, T object2) {
        int n3 = TArray.length;
        float f3 = 1.0f - f2;
        float f4 = f2 * f2;
        float f5 = f4 * f2;
        object.set(TArray[n2]).scl((float)(1.5f * f4 - 2.0f * f2));
        if (bl2 || n2 > 0) {
            object.add(object2.set(TArray[(n3 + n2 - 1) % n3]).scl((float)(-0.5f * f3 * f3)));
        }
        if (bl2 || n2 < n3 - 1) {
            object.add(object2.set(TArray[(n2 + 1) % n3]).scl((float)(-1.5f * f4 + f2 + 0.5f)));
        }
        if (bl2 || n2 < n3 - 2) {
            object.add(object2.set(TArray[(n2 + 2) % n3]).scl((float)(0.5f * f4)));
        }
        return (T)object;
    }

    public static <T extends Vector<T>> T calculate(T t2, float f2, T[] TArray, int n2, boolean bl2, T t3) {
        int n3 = bl2 ? TArray.length : TArray.length - n2;
        float f3 = f2 * (float)n3;
        int n4 = f2 >= 1.0f ? n3 - 1 : (int)f3;
        return (T)BSpline.calculate(t2, (int)n4, (float)(f3 -= (float)n4), TArray, (int)n2, (boolean)bl2, t3);
    }

    public static <T extends Vector<T>> T derivative(T t2, float f2, T[] TArray, int n2, boolean bl2, T t3) {
        int n3 = bl2 ? TArray.length : TArray.length - n2;
        float f3 = f2 * (float)n3;
        int n4 = f2 >= 1.0f ? n3 - 1 : (int)f3;
        return (T)BSpline.derivative(t2, (int)n4, (float)(f3 -= (float)n4), TArray, (int)n2, (boolean)bl2, t3);
    }

    public static <T extends Vector<T>> T calculate(T t2, int n2, float f2, T[] TArray, int n3, boolean bl2, T t3) {
        switch (n3) {
            case 3: {
                return (T)BSpline.cubic(t2, (int)n2, (float)f2, TArray, (boolean)bl2, t3);
            }
        }
        throw new IllegalArgumentException();
    }

    public static <T extends Vector<T>> T derivative(T t2, int n2, float f2, T[] TArray, int n3, boolean bl2, T t3) {
        switch (n3) {
            case 3: {
                return (T)BSpline.cubic_derivative(t2, (int)n2, (float)f2, TArray, (boolean)bl2, t3);
            }
        }
        throw new IllegalArgumentException();
    }

    public BSpline() {
    }

    public BSpline(T[] TArray, int n2, boolean bl2) {
        this.set((Vector[])TArray, n2, bl2);
    }

    public BSpline set(T[] TArray, int n2, boolean bl2) {
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
        this.degree = n2;
        this.continuous = bl2;
        int n3 = this.spanCount = bl2 ? TArray.length : TArray.length - n2;
        if (this.knots == null) {
            this.knots = new Array(this.spanCount);
        } else {
            this.knots.clear();
            this.knots.ensureCapacity(this.spanCount);
        }
        for (int i2 = 0; i2 < this.spanCount; ++i2) {
            this.knots.add(BSpline.calculate(TArray[0].cpy(), (int)(bl2 ? i2 : (int)((float)i2 + 0.5f * (float)n2)), (float)0.0f, TArray, (int)n2, (boolean)bl2, this.tmp));
        }
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
        return (T)BSpline.calculate(t2, (int)(this.continuous ? n2 : n2 + (int)((float)this.degree * 0.5f)), (float)f2, this.controlPoints, (int)this.degree, (boolean)this.continuous, this.tmp);
    }

    @Override
    public T derivativeAt(T t2, float f2) {
        int n2 = this.spanCount;
        float f3 = f2 * (float)n2;
        int n3 = f2 >= 1.0f ? n2 - 1 : (int)f3;
        return this.derivativeAt(t2, n3, f3 -= (float)n3);
    }

    public T derivativeAt(T t2, int n2, float f2) {
        return (T)BSpline.derivative(t2, (int)(this.continuous ? n2 : n2 + (int)((float)this.degree * 0.5f)), (float)f2, this.controlPoints, (int)this.degree, (boolean)this.continuous, this.tmp);
    }

    public int nearest(T t2) {
        return this.nearest(t2, 0, this.spanCount);
    }

    public int nearest(T vector, int n2, int n3) {
        while (n2 < 0) {
            n2 += this.spanCount;
        }
        int n4 = n2 % this.spanCount;
        float f2 = vector.dst2((Vector)((Vector)this.knots.get(n4)));
        for (int i2 = 1; i2 < n3; ++i2) {
            int n5 = (n2 + i2) % this.spanCount;
            float f3 = vector.dst2((Vector)((Vector)this.knots.get(n5)));
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

    public float approximate(T vector, int n2) {
        Vector vector2;
        Vector vector3;
        Vector vector4;
        int n3 = n2;
        Vector vector5 = (Vector)this.knots.get(n3);
        Vector vector6 = (Vector)this.knots.get(n3 > 0 ? n3 - 1 : this.spanCount - 1);
        Vector vector7 = (Vector)this.knots.get((n3 + 1) % this.spanCount);
        float f2 = vector.dst2((Vector)vector6);
        float f3 = vector.dst2((Vector)vector7);
        if (f3 < f2) {
            vector4 = vector5;
            vector3 = vector7;
            vector2 = vector;
        } else {
            vector4 = vector6;
            vector3 = vector5;
            vector2 = vector;
            n3 = n3 > 0 ? n3 - 1 : this.spanCount - 1;
        }
        float f4 = vector4.dst2(vector3);
        float f5 = vector2.dst2((Vector)vector3);
        float f6 = vector2.dst2((Vector)vector4);
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

