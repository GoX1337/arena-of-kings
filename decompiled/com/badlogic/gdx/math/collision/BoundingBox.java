/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.math.collision;

import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;
import java.io.Serializable;
import java.util.List;

public class BoundingBox
implements Serializable {
    private static final long serialVersionUID = -1286036817192127343L;
    private static final Vector3 tmpVector = new Vector3();
    public final Vector3 min = new Vector3();
    public final Vector3 max = new Vector3();
    private final Vector3 cnt = new Vector3();
    private final Vector3 dim = new Vector3();

    public Vector3 getCenter(Vector3 vector3) {
        return vector3.set(this.cnt);
    }

    public float getCenterX() {
        return this.cnt.x;
    }

    public float getCenterY() {
        return this.cnt.y;
    }

    public float getCenterZ() {
        return this.cnt.z;
    }

    public Vector3 getCorner000(Vector3 vector3) {
        return vector3.set(this.min.x, this.min.y, this.min.z);
    }

    public Vector3 getCorner001(Vector3 vector3) {
        return vector3.set(this.min.x, this.min.y, this.max.z);
    }

    public Vector3 getCorner010(Vector3 vector3) {
        return vector3.set(this.min.x, this.max.y, this.min.z);
    }

    public Vector3 getCorner011(Vector3 vector3) {
        return vector3.set(this.min.x, this.max.y, this.max.z);
    }

    public Vector3 getCorner100(Vector3 vector3) {
        return vector3.set(this.max.x, this.min.y, this.min.z);
    }

    public Vector3 getCorner101(Vector3 vector3) {
        return vector3.set(this.max.x, this.min.y, this.max.z);
    }

    public Vector3 getCorner110(Vector3 vector3) {
        return vector3.set(this.max.x, this.max.y, this.min.z);
    }

    public Vector3 getCorner111(Vector3 vector3) {
        return vector3.set(this.max.x, this.max.y, this.max.z);
    }

    public Vector3 getDimensions(Vector3 vector3) {
        return vector3.set(this.dim);
    }

    public float getWidth() {
        return this.dim.x;
    }

    public float getHeight() {
        return this.dim.y;
    }

    public float getDepth() {
        return this.dim.z;
    }

    public Vector3 getMin(Vector3 vector3) {
        return vector3.set(this.min);
    }

    public Vector3 getMax(Vector3 vector3) {
        return vector3.set(this.max);
    }

    public BoundingBox() {
        this.clr();
    }

    public BoundingBox(BoundingBox boundingBox) {
        this.set(boundingBox);
    }

    public BoundingBox(Vector3 vector3, Vector3 vector32) {
        this.set(vector3, vector32);
    }

    public BoundingBox set(BoundingBox boundingBox) {
        return this.set(boundingBox.min, boundingBox.max);
    }

    public BoundingBox set(Vector3 vector3, Vector3 vector32) {
        this.min.set(vector3.x < vector32.x ? vector3.x : vector32.x, vector3.y < vector32.y ? vector3.y : vector32.y, vector3.z < vector32.z ? vector3.z : vector32.z);
        this.max.set(vector3.x > vector32.x ? vector3.x : vector32.x, vector3.y > vector32.y ? vector3.y : vector32.y, vector3.z > vector32.z ? vector3.z : vector32.z);
        this.update();
        return this;
    }

    public void update() {
        this.cnt.set(this.min).add(this.max).scl(0.5f);
        this.dim.set(this.max).sub(this.min);
    }

    public BoundingBox set(Vector3[] vector3Array) {
        this.inf();
        for (Vector3 vector3 : vector3Array) {
            this.ext(vector3);
        }
        return this;
    }

    public BoundingBox set(List<Vector3> list) {
        this.inf();
        for (Vector3 vector3 : list) {
            this.ext(vector3);
        }
        return this;
    }

    public BoundingBox inf() {
        this.min.set(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY);
        this.max.set(Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);
        this.cnt.set(0.0f, 0.0f, 0.0f);
        this.dim.set(0.0f, 0.0f, 0.0f);
        return this;
    }

    public BoundingBox ext(Vector3 vector3) {
        return this.set(this.min.set(BoundingBox.min(this.min.x, vector3.x), BoundingBox.min(this.min.y, vector3.y), BoundingBox.min(this.min.z, vector3.z)), this.max.set(Math.max(this.max.x, vector3.x), Math.max(this.max.y, vector3.y), Math.max(this.max.z, vector3.z)));
    }

    public BoundingBox clr() {
        return this.set(this.min.set(0.0f, 0.0f, 0.0f), this.max.set(0.0f, 0.0f, 0.0f));
    }

    public boolean isValid() {
        return this.min.x <= this.max.x && this.min.y <= this.max.y && this.min.z <= this.max.z;
    }

    public BoundingBox ext(BoundingBox boundingBox) {
        return this.set(this.min.set(BoundingBox.min(this.min.x, boundingBox.min.x), BoundingBox.min(this.min.y, boundingBox.min.y), BoundingBox.min(this.min.z, boundingBox.min.z)), this.max.set(BoundingBox.max(this.max.x, boundingBox.max.x), BoundingBox.max(this.max.y, boundingBox.max.y), BoundingBox.max(this.max.z, boundingBox.max.z)));
    }

    public BoundingBox ext(Vector3 vector3, float f2) {
        return this.set(this.min.set(BoundingBox.min(this.min.x, vector3.x - f2), BoundingBox.min(this.min.y, vector3.y - f2), BoundingBox.min(this.min.z, vector3.z - f2)), this.max.set(BoundingBox.max(this.max.x, vector3.x + f2), BoundingBox.max(this.max.y, vector3.y + f2), BoundingBox.max(this.max.z, vector3.z + f2)));
    }

    public BoundingBox ext(BoundingBox boundingBox, Matrix4 matrix4) {
        this.ext(tmpVector.set(boundingBox.min.x, boundingBox.min.y, boundingBox.min.z).mul(matrix4));
        this.ext(tmpVector.set(boundingBox.min.x, boundingBox.min.y, boundingBox.max.z).mul(matrix4));
        this.ext(tmpVector.set(boundingBox.min.x, boundingBox.max.y, boundingBox.min.z).mul(matrix4));
        this.ext(tmpVector.set(boundingBox.min.x, boundingBox.max.y, boundingBox.max.z).mul(matrix4));
        this.ext(tmpVector.set(boundingBox.max.x, boundingBox.min.y, boundingBox.min.z).mul(matrix4));
        this.ext(tmpVector.set(boundingBox.max.x, boundingBox.min.y, boundingBox.max.z).mul(matrix4));
        this.ext(tmpVector.set(boundingBox.max.x, boundingBox.max.y, boundingBox.min.z).mul(matrix4));
        this.ext(tmpVector.set(boundingBox.max.x, boundingBox.max.y, boundingBox.max.z).mul(matrix4));
        return this;
    }

    public BoundingBox mul(Matrix4 matrix4) {
        float f2 = this.min.x;
        float f3 = this.min.y;
        float f4 = this.min.z;
        float f5 = this.max.x;
        float f6 = this.max.y;
        float f7 = this.max.z;
        this.inf();
        this.ext(tmpVector.set(f2, f3, f4).mul(matrix4));
        this.ext(tmpVector.set(f2, f3, f7).mul(matrix4));
        this.ext(tmpVector.set(f2, f6, f4).mul(matrix4));
        this.ext(tmpVector.set(f2, f6, f7).mul(matrix4));
        this.ext(tmpVector.set(f5, f3, f4).mul(matrix4));
        this.ext(tmpVector.set(f5, f3, f7).mul(matrix4));
        this.ext(tmpVector.set(f5, f6, f4).mul(matrix4));
        this.ext(tmpVector.set(f5, f6, f7).mul(matrix4));
        return this;
    }

    public boolean contains(BoundingBox boundingBox) {
        return !this.isValid() || this.min.x <= boundingBox.min.x && this.min.y <= boundingBox.min.y && this.min.z <= boundingBox.min.z && this.max.x >= boundingBox.max.x && this.max.y >= boundingBox.max.y && this.max.z >= boundingBox.max.z;
    }

    public boolean intersects(BoundingBox boundingBox) {
        if (!this.isValid()) {
            return false;
        }
        float f2 = Math.abs(this.cnt.x - boundingBox.cnt.x);
        float f3 = this.dim.x / 2.0f + boundingBox.dim.x / 2.0f;
        float f4 = Math.abs(this.cnt.y - boundingBox.cnt.y);
        float f5 = this.dim.y / 2.0f + boundingBox.dim.y / 2.0f;
        float f6 = Math.abs(this.cnt.z - boundingBox.cnt.z);
        float f7 = this.dim.z / 2.0f + boundingBox.dim.z / 2.0f;
        return f2 <= f3 && f4 <= f5 && f6 <= f7;
    }

    public boolean contains(Vector3 vector3) {
        return this.min.x <= vector3.x && this.max.x >= vector3.x && this.min.y <= vector3.y && this.max.y >= vector3.y && this.min.z <= vector3.z && this.max.z >= vector3.z;
    }

    public String toString() {
        return "[" + this.min + "|" + this.max + "]";
    }

    public BoundingBox ext(float f2, float f3, float f4) {
        return this.set(this.min.set(BoundingBox.min(this.min.x, f2), BoundingBox.min(this.min.y, f3), BoundingBox.min(this.min.z, f4)), this.max.set(BoundingBox.max(this.max.x, f2), BoundingBox.max(this.max.y, f3), BoundingBox.max(this.max.z, f4)));
    }

    static final float min(float f2, float f3) {
        return f2 > f3 ? f3 : f2;
    }

    static final float max(float f2, float f3) {
        return f2 > f3 ? f2 : f3;
    }
}

