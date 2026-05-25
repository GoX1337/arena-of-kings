/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.math.collision;

import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.NumberUtils;
import java.io.Serializable;

public class Sphere
implements Serializable {
    private static final long serialVersionUID = -6487336868908521596L;
    public float radius;
    public final Vector3 center;
    private static final float PI_4_3 = 4.1887903f;

    public Sphere(Vector3 vector3, float f2) {
        this.center = new Vector3(vector3);
        this.radius = f2;
    }

    public boolean overlaps(Sphere sphere) {
        return this.center.dst2(sphere.center) < (this.radius + sphere.radius) * (this.radius + sphere.radius);
    }

    public int hashCode() {
        int n2 = 71;
        int n3 = 1;
        n3 = 71 * n3 + this.center.hashCode();
        n3 = 71 * n3 + NumberUtils.floatToRawIntBits(this.radius);
        return n3;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || object.getClass() != this.getClass()) {
            return false;
        }
        Sphere sphere = (Sphere)object;
        return this.radius == sphere.radius && this.center.equals(sphere.center);
    }

    public float volume() {
        return 4.1887903f * this.radius * this.radius * this.radius;
    }

    public float surfaceArea() {
        return (float)Math.PI * 4 * this.radius * this.radius;
    }
}

