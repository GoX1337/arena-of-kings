/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.math.collision;

import com.badlogic.gdx.math.Vector3;
import java.io.Serializable;

public class Segment
implements Serializable {
    private static final long serialVersionUID = 2739667069736519602L;
    public final Vector3 a = new Vector3();
    public final Vector3 b = new Vector3();

    public Segment(Vector3 vector3, Vector3 vector32) {
        this.a.set(vector3);
        this.b.set(vector32);
    }

    public Segment(float f2, float f3, float f4, float f5, float f6, float f7) {
        this.a.set(f2, f3, f4);
        this.b.set(f5, f6, f7);
    }

    public float len() {
        return this.a.dst(this.b);
    }

    public float len2() {
        return this.a.dst2(this.b);
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object == null || object.getClass() != this.getClass()) {
            return false;
        }
        Segment segment = (Segment)object;
        return this.a.equals(segment.a) && this.b.equals(segment.b);
    }

    public int hashCode() {
        int n2 = 71;
        int n3 = 1;
        n3 = 71 * n3 + this.a.hashCode();
        n3 = 71 * n3 + this.b.hashCode();
        return n3;
    }
}

