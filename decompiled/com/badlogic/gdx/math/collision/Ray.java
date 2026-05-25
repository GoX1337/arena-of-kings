/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.math.collision;

import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;
import java.io.Serializable;

public class Ray
implements Serializable {
    private static final long serialVersionUID = -620692054835390878L;
    public final Vector3 origin = new Vector3();
    public final Vector3 direction = new Vector3();
    static Vector3 tmp = new Vector3();

    public Ray() {
    }

    public Ray(Vector3 vector3, Vector3 vector32) {
        this.origin.set(vector3);
        this.direction.set(vector32).nor();
    }

    public Ray cpy() {
        return new Ray(this.origin, this.direction);
    }

    public Vector3 getEndPoint(Vector3 vector3, float f2) {
        return vector3.set(this.direction).scl(f2).add(this.origin);
    }

    public Ray mul(Matrix4 matrix4) {
        tmp.set(this.origin).add(this.direction);
        tmp.mul(matrix4);
        this.origin.mul(matrix4);
        this.direction.set(tmp.sub(this.origin)).nor();
        return this;
    }

    public String toString() {
        return "ray [" + this.origin + ":" + this.direction + "]";
    }

    public Ray set(Vector3 vector3, Vector3 vector32) {
        this.origin.set(vector3);
        this.direction.set(vector32).nor();
        return this;
    }

    public Ray set(float f2, float f3, float f4, float f5, float f6, float f7) {
        this.origin.set(f2, f3, f4);
        this.direction.set(f5, f6, f7).nor();
        return this;
    }

    public Ray set(Ray ray) {
        this.origin.set(ray.origin);
        this.direction.set(ray.direction).nor();
        return this;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object == null || object.getClass() != this.getClass()) {
            return false;
        }
        Ray ray = (Ray)object;
        return this.direction.equals(ray.direction) && this.origin.equals(ray.origin);
    }

    public int hashCode() {
        int n2 = 73;
        int n3 = 1;
        n3 = 73 * n3 + this.direction.hashCode();
        n3 = 73 * n3 + this.origin.hashCode();
        return n3;
    }
}

