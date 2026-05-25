/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.math;

import java.io.Serializable;

public class GridPoint3
implements Serializable {
    private static final long serialVersionUID = 5922187982746752830L;
    public int x;
    public int y;
    public int z;

    public GridPoint3() {
    }

    public GridPoint3(int n2, int n3, int n4) {
        this.x = n2;
        this.y = n3;
        this.z = n4;
    }

    public GridPoint3(GridPoint3 gridPoint3) {
        this.x = gridPoint3.x;
        this.y = gridPoint3.y;
        this.z = gridPoint3.z;
    }

    public GridPoint3 set(GridPoint3 gridPoint3) {
        this.x = gridPoint3.x;
        this.y = gridPoint3.y;
        this.z = gridPoint3.z;
        return this;
    }

    public GridPoint3 set(int n2, int n3, int n4) {
        this.x = n2;
        this.y = n3;
        this.z = n4;
        return this;
    }

    public float dst2(GridPoint3 gridPoint3) {
        int n2 = gridPoint3.x - this.x;
        int n3 = gridPoint3.y - this.y;
        int n4 = gridPoint3.z - this.z;
        return n2 * n2 + n3 * n3 + n4 * n4;
    }

    public float dst2(int n2, int n3, int n4) {
        int n5 = n2 - this.x;
        int n6 = n3 - this.y;
        int n7 = n4 - this.z;
        return n5 * n5 + n6 * n6 + n7 * n7;
    }

    public float dst(GridPoint3 gridPoint3) {
        int n2 = gridPoint3.x - this.x;
        int n3 = gridPoint3.y - this.y;
        int n4 = gridPoint3.z - this.z;
        return (float)Math.sqrt(n2 * n2 + n3 * n3 + n4 * n4);
    }

    public float dst(int n2, int n3, int n4) {
        int n5 = n2 - this.x;
        int n6 = n3 - this.y;
        int n7 = n4 - this.z;
        return (float)Math.sqrt(n5 * n5 + n6 * n6 + n7 * n7);
    }

    public GridPoint3 add(GridPoint3 gridPoint3) {
        this.x += gridPoint3.x;
        this.y += gridPoint3.y;
        this.z += gridPoint3.z;
        return this;
    }

    public GridPoint3 add(int n2, int n3, int n4) {
        this.x += n2;
        this.y += n3;
        this.z += n4;
        return this;
    }

    public GridPoint3 sub(GridPoint3 gridPoint3) {
        this.x -= gridPoint3.x;
        this.y -= gridPoint3.y;
        this.z -= gridPoint3.z;
        return this;
    }

    public GridPoint3 sub(int n2, int n3, int n4) {
        this.x -= n2;
        this.y -= n3;
        this.z -= n4;
        return this;
    }

    public GridPoint3 cpy() {
        return new GridPoint3(this);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || object.getClass() != this.getClass()) {
            return false;
        }
        GridPoint3 gridPoint3 = (GridPoint3)object;
        return this.x == gridPoint3.x && this.y == gridPoint3.y && this.z == gridPoint3.z;
    }

    public int hashCode() {
        int n2 = 17;
        int n3 = 1;
        n3 = 17 * n3 + this.x;
        n3 = 17 * n3 + this.y;
        n3 = 17 * n3 + this.z;
        return n3;
    }

    public String toString() {
        return "(" + this.x + ", " + this.y + ", " + this.z + ")";
    }
}

