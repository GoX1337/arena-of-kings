/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.math;

import com.badlogic.gdx.math.Vector3;
import java.io.Serializable;

public class Plane
implements Serializable {
    private static final long serialVersionUID = -1240652082930747866L;
    public final Vector3 normal = new Vector3();
    public float d = 0.0f;

    public Plane() {
    }

    public Plane(Vector3 vector3, float f2) {
        this.normal.set(vector3).nor();
        this.d = f2;
    }

    public Plane(Vector3 vector3, Vector3 vector32) {
        this.normal.set(vector3).nor();
        this.d = -this.normal.dot(vector32);
    }

    public Plane(Vector3 vector3, Vector3 vector32, Vector3 vector33) {
        this.set(vector3, vector32, vector33);
    }

    public void set(Vector3 vector3, Vector3 vector32, Vector3 vector33) {
        this.normal.set(vector3).sub(vector32).crs(vector32.x - vector33.x, vector32.y - vector33.y, vector32.z - vector33.z).nor();
        this.d = -vector3.dot(this.normal);
    }

    public void set(float f2, float f3, float f4, float f5) {
        this.normal.set(f2, f3, f4);
        this.d = f5;
    }

    public float distance(Vector3 vector3) {
        return this.normal.dot(vector3) + this.d;
    }

    public PlaneSide testPoint(Vector3 vector3) {
        float f2 = this.normal.dot(vector3) + this.d;
        if (f2 == 0.0f) {
            return PlaneSide.OnPlane;
        }
        if (f2 < 0.0f) {
            return PlaneSide.Back;
        }
        return PlaneSide.Front;
    }

    public PlaneSide testPoint(float f2, float f3, float f4) {
        float f5 = this.normal.dot(f2, f3, f4) + this.d;
        if (f5 == 0.0f) {
            return PlaneSide.OnPlane;
        }
        if (f5 < 0.0f) {
            return PlaneSide.Back;
        }
        return PlaneSide.Front;
    }

    public boolean isFrontFacing(Vector3 vector3) {
        float f2 = this.normal.dot(vector3);
        return f2 <= 0.0f;
    }

    public Vector3 getNormal() {
        return this.normal;
    }

    public float getD() {
        return this.d;
    }

    public void set(Vector3 vector3, Vector3 vector32) {
        this.normal.set(vector32);
        this.d = -vector3.dot(vector32);
    }

    public void set(float f2, float f3, float f4, float f5, float f6, float f7) {
        this.normal.set(f5, f6, f7);
        this.d = -(f2 * f5 + f3 * f6 + f4 * f7);
    }

    public void set(Plane plane) {
        this.normal.set(plane.normal);
        this.d = plane.d;
    }

    public String toString() {
        return this.normal.toString() + ", " + this.d;
    }

    public static enum PlaneSide {
        OnPlane,
        Back,
        Front;

    }
}

