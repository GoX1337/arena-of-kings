/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.math;

import java.io.Serializable;

public class GridPoint2
implements Serializable {
    private static final long serialVersionUID = -4019969926331717380L;
    public int x;
    public int y;

    public GridPoint2() {
    }

    public GridPoint2(int n2, int n3) {
        this.x = n2;
        this.y = n3;
    }

    public GridPoint2(GridPoint2 gridPoint2) {
        this.x = gridPoint2.x;
        this.y = gridPoint2.y;
    }

    public GridPoint2 set(GridPoint2 gridPoint2) {
        this.x = gridPoint2.x;
        this.y = gridPoint2.y;
        return this;
    }

    public GridPoint2 set(int n2, int n3) {
        this.x = n2;
        this.y = n3;
        return this;
    }

    public float dst2(GridPoint2 gridPoint2) {
        int n2 = gridPoint2.x - this.x;
        int n3 = gridPoint2.y - this.y;
        return n2 * n2 + n3 * n3;
    }

    public float dst2(int n2, int n3) {
        int n4 = n2 - this.x;
        int n5 = n3 - this.y;
        return n4 * n4 + n5 * n5;
    }

    public float dst(GridPoint2 gridPoint2) {
        int n2 = gridPoint2.x - this.x;
        int n3 = gridPoint2.y - this.y;
        return (float)Math.sqrt(n2 * n2 + n3 * n3);
    }

    public float dst(int n2, int n3) {
        int n4 = n2 - this.x;
        int n5 = n3 - this.y;
        return (float)Math.sqrt(n4 * n4 + n5 * n5);
    }

    public GridPoint2 add(GridPoint2 gridPoint2) {
        this.x += gridPoint2.x;
        this.y += gridPoint2.y;
        return this;
    }

    public GridPoint2 add(int n2, int n3) {
        this.x += n2;
        this.y += n3;
        return this;
    }

    public GridPoint2 sub(GridPoint2 gridPoint2) {
        this.x -= gridPoint2.x;
        this.y -= gridPoint2.y;
        return this;
    }

    public GridPoint2 sub(int n2, int n3) {
        this.x -= n2;
        this.y -= n3;
        return this;
    }

    public GridPoint2 cpy() {
        return new GridPoint2(this);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || object.getClass() != this.getClass()) {
            return false;
        }
        GridPoint2 gridPoint2 = (GridPoint2)object;
        return this.x == gridPoint2.x && this.y == gridPoint2.y;
    }

    public int hashCode() {
        int n2 = 53;
        int n3 = 1;
        n3 = 53 * n3 + this.x;
        n3 = 53 * n3 + this.y;
        return n3;
    }

    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }
}

