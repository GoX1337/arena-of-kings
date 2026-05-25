/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.math;

import com.badlogic.gdx.math.GridPoint2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pool;

public class Bresenham2 {
    private final Array<GridPoint2> points = new Array();
    private final Pool<GridPoint2> pool = new Pool<GridPoint2>(){

        @Override
        protected GridPoint2 newObject() {
            return new GridPoint2();
        }
    };

    public Array<GridPoint2> line(GridPoint2 gridPoint2, GridPoint2 gridPoint22) {
        return this.line(gridPoint2.x, gridPoint2.y, gridPoint22.x, gridPoint22.y);
    }

    public Array<GridPoint2> line(int n2, int n3, int n4, int n5) {
        this.pool.freeAll(this.points);
        this.points.clear();
        return this.line(n2, n3, n4, n5, this.pool, this.points);
    }

    public Array<GridPoint2> line(int n2, int n3, int n4, int n5, Pool<GridPoint2> pool, Array<GridPoint2> array) {
        int n6 = n4 - n2;
        int n7 = n5 - n3;
        int n8 = 0;
        int n9 = 0;
        int n10 = 0;
        int n11 = 0;
        if (n6 < 0) {
            n8 = -1;
            n10 = -1;
        } else if (n6 > 0) {
            n8 = 1;
            n10 = 1;
        }
        if (n7 < 0) {
            n9 = -1;
        } else if (n7 > 0) {
            n9 = 1;
        }
        int n12 = Math.abs(n6);
        int n13 = Math.abs(n7);
        if (n12 < n13) {
            n12 = Math.abs(n7);
            n13 = Math.abs(n6);
            if (n7 < 0) {
                n11 = -1;
            } else if (n7 > 0) {
                n11 = 1;
            }
            n10 = 0;
        }
        int n14 = n13 << 1;
        int n15 = n12 << 1;
        int n16 = 0;
        for (int i2 = 0; i2 <= n12; ++i2) {
            GridPoint2 gridPoint2 = pool.obtain();
            gridPoint2.set(n2, n3);
            array.add(gridPoint2);
            if ((n16 += n14) > n12) {
                n16 -= n15;
                n2 += n8;
                n3 += n9;
                continue;
            }
            n2 += n10;
            n3 += n11;
        }
        return array;
    }
}

