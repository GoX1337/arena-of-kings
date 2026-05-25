/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.math;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Path;
import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.GdxRuntimeException;

public class Bezier<T extends Vector<T>>
implements Path<T> {
    public Array<T> points = new Array();
    private T tmp;
    private T tmp2;
    private T tmp3;

    public static <T extends Vector<T>> T linear(T t2, float f2, T t3, T t4, T t5) {
        return t2.set(t3).scl((float)(1.0f - f2)).add(t5.set(t4).scl((float)f2));
    }

    public static <T extends Vector<T>> T linear_derivative(T t2, float f2, T t3, T t4, T t5) {
        return t2.set(t4).sub(t3);
    }

    public static <T extends Vector<T>> T quadratic(T t2, float f2, T t3, T t4, T t5, T t6) {
        float f3 = 1.0f - f2;
        return t2.set(t3).scl((float)(f3 * f3)).add(t6.set(t4).scl((float)(2.0f * f3 * f2))).add(t6.set(t5).scl((float)(f2 * f2)));
    }

    public static <T extends Vector<T>> T quadratic_derivative(T t2, float f2, T t3, T t4, T t5, T t6) {
        float f3 = 1.0f - f2;
        return t2.set(t4).sub(t3).scl((float)2.0f).scl(1.0f - f2).add(t6.set(t5).sub(t4).scl((float)f2).scl(2.0f));
    }

    public static <T extends Vector<T>> T cubic(T t2, float f2, T t3, T t4, T t5, T t6, T t7) {
        float f3 = 1.0f - f2;
        float f4 = f3 * f3;
        float f5 = f2 * f2;
        return t2.set(t3).scl((float)(f4 * f3)).add(t7.set(t4).scl((float)(3.0f * f4 * f2))).add(t7.set(t5).scl((float)(3.0f * f3 * f5))).add(t7.set(t6).scl((float)(f5 * f2)));
    }

    public static <T extends Vector<T>> T cubic_derivative(T t2, float f2, T t3, T t4, T t5, T t6, T t7) {
        float f3 = 1.0f - f2;
        float f4 = f3 * f3;
        float f5 = f2 * f2;
        return t2.set(t4).sub(t3).scl((float)(f4 * 3.0f)).add(t7.set(t5).sub(t4).scl((float)(f3 * f2 * 6.0f))).add(t7.set(t6).sub(t5).scl((float)(f5 * 3.0f)));
    }

    public Bezier() {
    }

    public Bezier(T ... TArray) {
        this.set((Vector[])TArray);
    }

    public Bezier(T[] TArray, int n2, int n3) {
        this.set((Vector[])TArray, n2, n3);
    }

    public Bezier(Array<T> array, int n2, int n3) {
        this.set(array, n2, n3);
    }

    public Bezier set(T ... TArray) {
        return this.set((Vector[])TArray, 0, TArray.length);
    }

    public Bezier set(T[] TArray, int n2, int n3) {
        if (n3 < 2 || n3 > 4) {
            throw new GdxRuntimeException("Only first, second and third degree Bezier curves are supported.");
        }
        if (this.tmp == null) {
            this.tmp = TArray[0].cpy();
        }
        if (this.tmp2 == null) {
            this.tmp2 = TArray[0].cpy();
        }
        if (this.tmp3 == null) {
            this.tmp3 = TArray[0].cpy();
        }
        this.points.clear();
        this.points.addAll(TArray, n2, n3);
        return this;
    }

    public Bezier set(Array<T> array, int n2, int n3) {
        if (n3 < 2 || n3 > 4) {
            throw new GdxRuntimeException("Only first, second and third degree Bezier curves are supported.");
        }
        if (this.tmp == null) {
            this.tmp = ((Vector)array.get(0)).cpy();
        }
        if (this.tmp2 == null) {
            this.tmp2 = ((Vector)array.get(0)).cpy();
        }
        if (this.tmp3 == null) {
            this.tmp3 = ((Vector)array.get(0)).cpy();
        }
        this.points.clear();
        this.points.addAll(array, n2, n3);
        return this;
    }

    @Override
    public T valueAt(T t2, float f2) {
        int n2 = this.points.size;
        if (n2 == 2) {
            Bezier.linear(t2, f2, (Vector)this.points.get(0), (Vector)this.points.get(1), this.tmp);
        } else if (n2 == 3) {
            Bezier.quadratic(t2, f2, (Vector)this.points.get(0), (Vector)this.points.get(1), (Vector)this.points.get(2), this.tmp);
        } else if (n2 == 4) {
            Bezier.cubic(t2, f2, (Vector)this.points.get(0), (Vector)this.points.get(1), (Vector)this.points.get(2), (Vector)this.points.get(3), this.tmp);
        }
        return t2;
    }

    @Override
    public T derivativeAt(T t2, float f2) {
        int n2 = this.points.size;
        if (n2 == 2) {
            Bezier.linear_derivative(t2, f2, (Vector)this.points.get(0), (Vector)this.points.get(1), this.tmp);
        } else if (n2 == 3) {
            Bezier.quadratic_derivative(t2, f2, (Vector)this.points.get(0), (Vector)this.points.get(1), (Vector)this.points.get(2), this.tmp);
        } else if (n2 == 4) {
            Bezier.cubic_derivative(t2, f2, (Vector)this.points.get(0), (Vector)this.points.get(1), (Vector)this.points.get(2), (Vector)this.points.get(3), this.tmp);
        }
        return t2;
    }

    @Override
    public float approximate(T vector) {
        Vector vector2 = (Vector)this.points.get(0);
        Vector vector3 = (Vector)this.points.get(this.points.size - 1);
        Vector vector4 = vector;
        float f2 = vector2.dst2(vector3);
        float f3 = vector4.dst2((Vector)vector3);
        float f4 = vector4.dst2((Vector)vector2);
        float f5 = (float)Math.sqrt(f2);
        float f6 = (f3 + f2 - f4) / (2.0f * f5);
        return MathUtils.clamp((f5 - f6) / f5, 0.0f, 1.0f);
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

