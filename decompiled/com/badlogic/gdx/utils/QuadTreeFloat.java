/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils;

import com.badlogic.gdx.utils.FloatArray;
import com.badlogic.gdx.utils.Null;
import com.badlogic.gdx.utils.Pool;
import java.util.Arrays;

public class QuadTreeFloat
implements Pool.Poolable {
    public static final int VALUE = 0;
    public static final int X = 1;
    public static final int Y = 2;
    public static final int DISTSQR = 3;
    private static final Pool<QuadTreeFloat> pool = new Pool(128, 4096){

        protected Object newObject() {
            return new QuadTreeFloat();
        }
    };
    public final int maxValues;
    public final int maxDepth;
    public float x;
    public float y;
    public float width;
    public float height;
    public int depth;
    @Null
    public QuadTreeFloat nw;
    @Null
    public QuadTreeFloat ne;
    @Null
    public QuadTreeFloat sw;
    @Null
    public QuadTreeFloat se;
    public float[] values;
    public int count;

    public QuadTreeFloat() {
        this(16, 8);
    }

    public QuadTreeFloat(int n2, int n3) {
        this.maxValues = n2 * 3;
        this.maxDepth = n3;
        this.values = new float[this.maxValues];
    }

    public void setBounds(float f2, float f3, float f4, float f5) {
        this.x = f2;
        this.y = f3;
        this.width = f4;
        this.height = f5;
    }

    public void add(float f2, float f3, float f4) {
        int n2 = this.count;
        if (n2 == -1) {
            this.addToChild(f2, f3, f4);
            return;
        }
        if (this.depth < this.maxDepth) {
            if (n2 == this.maxValues) {
                this.split(f2, f3, f4);
                return;
            }
        } else if (n2 == this.values.length) {
            this.values = Arrays.copyOf(this.values, this.growValues());
        }
        this.values[n2] = f2;
        this.values[n2 + 1] = f3;
        this.values[n2 + 2] = f4;
        this.count += 3;
    }

    private void split(float f2, float f3, float f4) {
        float[] fArray = this.values;
        for (int i2 = 0; i2 < this.maxValues; i2 += 3) {
            this.addToChild(fArray[i2], fArray[i2 + 1], fArray[i2 + 2]);
        }
        this.count = -1;
        this.addToChild(f2, f3, f4);
    }

    private void addToChild(float f2, float f3, float f4) {
        float f5 = this.width / 2.0f;
        float f6 = this.height / 2.0f;
        QuadTreeFloat quadTreeFloat = f3 < this.x + f5 ? (f4 < this.y + f6 ? (this.sw != null ? this.sw : (this.sw = this.obtainChild(this.x, this.y, f5, f6, this.depth + 1))) : (this.nw != null ? this.nw : (this.nw = this.obtainChild(this.x, this.y + f6, f5, f6, this.depth + 1)))) : (f4 < this.y + f6 ? (this.se != null ? this.se : (this.se = this.obtainChild(this.x + f5, this.y, f5, f6, this.depth + 1))) : (this.ne != null ? this.ne : (this.ne = this.obtainChild(this.x + f5, this.y + f6, f5, f6, this.depth + 1))));
        quadTreeFloat.add(f2, f3, f4);
    }

    private QuadTreeFloat obtainChild(float f2, float f3, float f4, float f5, int n2) {
        QuadTreeFloat quadTreeFloat = pool.obtain();
        quadTreeFloat.x = f2;
        quadTreeFloat.y = f3;
        quadTreeFloat.width = f4;
        quadTreeFloat.height = f5;
        quadTreeFloat.depth = n2;
        return quadTreeFloat;
    }

    protected int growValues() {
        return this.count + 30;
    }

    public void query(float f2, float f3, float f4, FloatArray floatArray) {
        this.query(f2, f3, f4 * f4, f2 - f4, f3 - f4, f4 * 2.0f, floatArray);
    }

    private void query(float f2, float f3, float f4, float f5, float f6, float f7, FloatArray floatArray) {
        if (!(this.x < f5 + f7 && this.x + this.width > f5 && this.y < f6 + f7 && this.y + this.height > f6)) {
            return;
        }
        int n2 = this.count;
        if (n2 != -1) {
            float[] fArray = this.values;
            for (int i2 = 1; i2 < n2; i2 += 3) {
                float f8 = fArray[i2];
                float f9 = f8 - f2;
                float f10 = fArray[i2 + 1];
                float f11 = f10 - f3;
                float f12 = f9 * f9 + f11 * f11;
                if (!(f12 <= f4)) continue;
                floatArray.add(fArray[i2 - 1]);
                floatArray.add(f8);
                floatArray.add(f10);
                floatArray.add(f12);
            }
        } else {
            if (this.nw != null) {
                this.nw.query(f2, f3, f4, f5, f6, f7, floatArray);
            }
            if (this.sw != null) {
                this.sw.query(f2, f3, f4, f5, f6, f7, floatArray);
            }
            if (this.ne != null) {
                this.ne.query(f2, f3, f4, f5, f6, f7, floatArray);
            }
            if (this.se != null) {
                this.se.query(f2, f3, f4, f5, f6, f7, floatArray);
            }
        }
    }

    public boolean nearest(float f2, float f3, FloatArray floatArray) {
        boolean bl2;
        floatArray.clear();
        floatArray.add(0.0f);
        floatArray.add(0.0f);
        floatArray.add(0.0f);
        floatArray.add(Float.POSITIVE_INFINITY);
        this.findNearestInternal(f2, f3, floatArray);
        float f4 = floatArray.first();
        float f5 = floatArray.get(1);
        float f6 = floatArray.get(2);
        float f7 = floatArray.get(3);
        boolean bl3 = bl2 = f7 != Float.POSITIVE_INFINITY;
        if (!bl2) {
            f7 = Math.max(this.width, this.height);
            f7 *= f7;
        }
        floatArray.clear();
        this.query(f2, f3, (float)Math.sqrt(f7), floatArray);
        int n2 = floatArray.size;
        for (int i2 = 3; i2 < n2; i2 += 4) {
            float f8 = floatArray.get(i2);
            if (!(f8 < f7)) continue;
            f7 = f8;
            f4 = floatArray.get(i2 - 3);
            f5 = floatArray.get(i2 - 2);
            f6 = floatArray.get(i2 - 1);
        }
        if (!bl2 && floatArray.isEmpty()) {
            return false;
        }
        floatArray.clear();
        floatArray.add(f4);
        floatArray.add(f5);
        floatArray.add(f6);
        floatArray.add(f7);
        return true;
    }

    private void findNearestInternal(float f2, float f3, FloatArray floatArray) {
        if (!(this.x < f2 && this.x + this.width > f2 && this.y < f3 && this.y + this.height > f3)) {
            return;
        }
        int n2 = this.count;
        if (n2 != -1) {
            float f4 = floatArray.first();
            float f5 = floatArray.get(1);
            float f6 = floatArray.get(2);
            float f7 = floatArray.get(3);
            float[] fArray = this.values;
            for (int i2 = 1; i2 < n2; i2 += 3) {
                float f8 = fArray[i2];
                float f9 = f8 - f2;
                float f10 = fArray[i2 + 1];
                float f11 = f10 - f3;
                float f12 = f9 * f9 + f11 * f11;
                if (!(f12 < f7)) continue;
                f7 = f12;
                f4 = fArray[i2 - 1];
                f5 = f8;
                f6 = f10;
            }
            floatArray.set(0, f4);
            floatArray.set(1, f5);
            floatArray.set(2, f6);
            floatArray.set(3, f7);
        } else {
            if (this.nw != null) {
                this.nw.findNearestInternal(f2, f3, floatArray);
            }
            if (this.sw != null) {
                this.sw.findNearestInternal(f2, f3, floatArray);
            }
            if (this.ne != null) {
                this.ne.findNearestInternal(f2, f3, floatArray);
            }
            if (this.se != null) {
                this.se.findNearestInternal(f2, f3, floatArray);
            }
        }
    }

    @Override
    public void reset() {
        if (this.count == -1) {
            if (this.nw != null) {
                pool.free(this.nw);
                this.nw = null;
            }
            if (this.sw != null) {
                pool.free(this.sw);
                this.sw = null;
            }
            if (this.ne != null) {
                pool.free(this.ne);
                this.ne = null;
            }
            if (this.se != null) {
                pool.free(this.se);
                this.se = null;
            }
        }
        this.count = 0;
        if (this.values.length > this.maxValues) {
            this.values = new float[this.maxValues];
        }
    }
}

