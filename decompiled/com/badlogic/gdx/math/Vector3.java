/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.math;

import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Matrix3;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.NumberUtils;
import java.io.Serializable;

public class Vector3
implements Vector<Vector3>,
Serializable {
    private static final long serialVersionUID = 3840054589595372522L;
    public float x;
    public float y;
    public float z;
    public static final Vector3 X = new Vector3(1.0f, 0.0f, 0.0f);
    public static final Vector3 Y = new Vector3(0.0f, 1.0f, 0.0f);
    public static final Vector3 Z = new Vector3(0.0f, 0.0f, 1.0f);
    public static final Vector3 Zero = new Vector3(0.0f, 0.0f, 0.0f);
    private static final Matrix4 tmpMat = new Matrix4();

    public Vector3() {
    }

    public Vector3(float f2, float f3, float f4) {
        this.set(f2, f3, f4);
    }

    public Vector3(Vector3 vector3) {
        this.set(vector3);
    }

    public Vector3(float[] fArray) {
        this.set(fArray[0], fArray[1], fArray[2]);
    }

    public Vector3(Vector2 vector2, float f2) {
        this.set(vector2.x, vector2.y, f2);
    }

    public Vector3 set(float f2, float f3, float f4) {
        this.x = f2;
        this.y = f3;
        this.z = f4;
        return this;
    }

    @Override
    public Vector3 set(Vector3 vector3) {
        return this.set(vector3.x, vector3.y, vector3.z);
    }

    @Override
    public Vector3 set(float[] fArray) {
        return this.set(fArray[0], fArray[1], fArray[2]);
    }

    public Vector3 set(Vector2 vector2, float f2) {
        return this.set(vector2.x, vector2.y, f2);
    }

    public Vector3 setFromSpherical(float f2, float f3) {
        float f4 = MathUtils.cos(f3);
        float f5 = MathUtils.sin(f3);
        float f6 = MathUtils.cos(f2);
        float f7 = MathUtils.sin(f2);
        return this.set(f6 * f5, f7 * f5, f4);
    }

    @Override
    public Vector3 setToRandomDirection() {
        float f2 = MathUtils.random();
        float f3 = MathUtils.random();
        float f4 = (float)Math.PI * 2 * f2;
        float f5 = (float)Math.acos(2.0f * f3 - 1.0f);
        return this.setFromSpherical(f4, f5);
    }

    @Override
    public Vector3 cpy() {
        return new Vector3(this);
    }

    @Override
    public Vector3 add(Vector3 vector3) {
        return this.add(vector3.x, vector3.y, vector3.z);
    }

    public Vector3 add(float f2, float f3, float f4) {
        return this.set(this.x + f2, this.y + f3, this.z + f4);
    }

    @Override
    public Vector3 add(float f2) {
        return this.set(this.x + f2, this.y + f2, this.z + f2);
    }

    @Override
    public Vector3 sub(Vector3 vector3) {
        return this.sub(vector3.x, vector3.y, vector3.z);
    }

    public Vector3 sub(float f2, float f3, float f4) {
        return this.set(this.x - f2, this.y - f3, this.z - f4);
    }

    @Override
    public Vector3 sub(float f2) {
        return this.set(this.x - f2, this.y - f2, this.z - f2);
    }

    @Override
    public Vector3 scl(float f2) {
        return this.set(this.x * f2, this.y * f2, this.z * f2);
    }

    @Override
    public Vector3 scl(Vector3 vector3) {
        return this.set(this.x * vector3.x, this.y * vector3.y, this.z * vector3.z);
    }

    public Vector3 scl(float f2, float f3, float f4) {
        return this.set(this.x * f2, this.y * f3, this.z * f4);
    }

    @Override
    public Vector3 mulAdd(Vector3 vector3, float f2) {
        this.x += vector3.x * f2;
        this.y += vector3.y * f2;
        this.z += vector3.z * f2;
        return this;
    }

    @Override
    public Vector3 mulAdd(Vector3 vector3, Vector3 vector32) {
        this.x += vector3.x * vector32.x;
        this.y += vector3.y * vector32.y;
        this.z += vector3.z * vector32.z;
        return this;
    }

    public static float len(float f2, float f3, float f4) {
        return (float)Math.sqrt(f2 * f2 + f3 * f3 + f4 * f4);
    }

    @Override
    public float len() {
        return (float)Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
    }

    public static float len2(float f2, float f3, float f4) {
        return f2 * f2 + f3 * f3 + f4 * f4;
    }

    @Override
    public float len2() {
        return this.x * this.x + this.y * this.y + this.z * this.z;
    }

    public boolean idt(Vector3 vector3) {
        return this.x == vector3.x && this.y == vector3.y && this.z == vector3.z;
    }

    public static float dst(float f2, float f3, float f4, float f5, float f6, float f7) {
        float f8 = f5 - f2;
        float f9 = f6 - f3;
        float f10 = f7 - f4;
        return (float)Math.sqrt(f8 * f8 + f9 * f9 + f10 * f10);
    }

    @Override
    public float dst(Vector3 vector3) {
        float f2 = vector3.x - this.x;
        float f3 = vector3.y - this.y;
        float f4 = vector3.z - this.z;
        return (float)Math.sqrt(f2 * f2 + f3 * f3 + f4 * f4);
    }

    public float dst(float f2, float f3, float f4) {
        float f5 = f2 - this.x;
        float f6 = f3 - this.y;
        float f7 = f4 - this.z;
        return (float)Math.sqrt(f5 * f5 + f6 * f6 + f7 * f7);
    }

    public static float dst2(float f2, float f3, float f4, float f5, float f6, float f7) {
        float f8 = f5 - f2;
        float f9 = f6 - f3;
        float f10 = f7 - f4;
        return f8 * f8 + f9 * f9 + f10 * f10;
    }

    @Override
    public float dst2(Vector3 vector3) {
        float f2 = vector3.x - this.x;
        float f3 = vector3.y - this.y;
        float f4 = vector3.z - this.z;
        return f2 * f2 + f3 * f3 + f4 * f4;
    }

    public float dst2(float f2, float f3, float f4) {
        float f5 = f2 - this.x;
        float f6 = f3 - this.y;
        float f7 = f4 - this.z;
        return f5 * f5 + f6 * f6 + f7 * f7;
    }

    @Override
    public Vector3 nor() {
        float f2 = this.len2();
        if (f2 == 0.0f || f2 == 1.0f) {
            return this;
        }
        return this.scl(1.0f / (float)Math.sqrt(f2));
    }

    public static float dot(float f2, float f3, float f4, float f5, float f6, float f7) {
        return f2 * f5 + f3 * f6 + f4 * f7;
    }

    @Override
    public float dot(Vector3 vector3) {
        return this.x * vector3.x + this.y * vector3.y + this.z * vector3.z;
    }

    public float dot(float f2, float f3, float f4) {
        return this.x * f2 + this.y * f3 + this.z * f4;
    }

    public Vector3 crs(Vector3 vector3) {
        return this.set(this.y * vector3.z - this.z * vector3.y, this.z * vector3.x - this.x * vector3.z, this.x * vector3.y - this.y * vector3.x);
    }

    public Vector3 crs(float f2, float f3, float f4) {
        return this.set(this.y * f4 - this.z * f3, this.z * f2 - this.x * f4, this.x * f3 - this.y * f2);
    }

    public Vector3 mul4x3(float[] fArray) {
        return this.set(this.x * fArray[0] + this.y * fArray[3] + this.z * fArray[6] + fArray[9], this.x * fArray[1] + this.y * fArray[4] + this.z * fArray[7] + fArray[10], this.x * fArray[2] + this.y * fArray[5] + this.z * fArray[8] + fArray[11]);
    }

    public Vector3 mul(Matrix4 matrix4) {
        float[] fArray = matrix4.val;
        return this.set(this.x * fArray[0] + this.y * fArray[4] + this.z * fArray[8] + fArray[12], this.x * fArray[1] + this.y * fArray[5] + this.z * fArray[9] + fArray[13], this.x * fArray[2] + this.y * fArray[6] + this.z * fArray[10] + fArray[14]);
    }

    public Vector3 traMul(Matrix4 matrix4) {
        float[] fArray = matrix4.val;
        return this.set(this.x * fArray[0] + this.y * fArray[1] + this.z * fArray[2] + fArray[3], this.x * fArray[4] + this.y * fArray[5] + this.z * fArray[6] + fArray[7], this.x * fArray[8] + this.y * fArray[9] + this.z * fArray[10] + fArray[11]);
    }

    public Vector3 mul(Matrix3 matrix3) {
        float[] fArray = matrix3.val;
        return this.set(this.x * fArray[0] + this.y * fArray[3] + this.z * fArray[6], this.x * fArray[1] + this.y * fArray[4] + this.z * fArray[7], this.x * fArray[2] + this.y * fArray[5] + this.z * fArray[8]);
    }

    public Vector3 traMul(Matrix3 matrix3) {
        float[] fArray = matrix3.val;
        return this.set(this.x * fArray[0] + this.y * fArray[1] + this.z * fArray[2], this.x * fArray[3] + this.y * fArray[4] + this.z * fArray[5], this.x * fArray[6] + this.y * fArray[7] + this.z * fArray[8]);
    }

    public Vector3 mul(Quaternion quaternion) {
        return quaternion.transform(this);
    }

    public Vector3 prj(Matrix4 matrix4) {
        float[] fArray = matrix4.val;
        float f2 = 1.0f / (this.x * fArray[3] + this.y * fArray[7] + this.z * fArray[11] + fArray[15]);
        return this.set((this.x * fArray[0] + this.y * fArray[4] + this.z * fArray[8] + fArray[12]) * f2, (this.x * fArray[1] + this.y * fArray[5] + this.z * fArray[9] + fArray[13]) * f2, (this.x * fArray[2] + this.y * fArray[6] + this.z * fArray[10] + fArray[14]) * f2);
    }

    public Vector3 rot(Matrix4 matrix4) {
        float[] fArray = matrix4.val;
        return this.set(this.x * fArray[0] + this.y * fArray[4] + this.z * fArray[8], this.x * fArray[1] + this.y * fArray[5] + this.z * fArray[9], this.x * fArray[2] + this.y * fArray[6] + this.z * fArray[10]);
    }

    public Vector3 unrotate(Matrix4 matrix4) {
        float[] fArray = matrix4.val;
        return this.set(this.x * fArray[0] + this.y * fArray[1] + this.z * fArray[2], this.x * fArray[4] + this.y * fArray[5] + this.z * fArray[6], this.x * fArray[8] + this.y * fArray[9] + this.z * fArray[10]);
    }

    public Vector3 untransform(Matrix4 matrix4) {
        float[] fArray = matrix4.val;
        this.x -= fArray[12];
        this.y -= fArray[12];
        this.z -= fArray[12];
        return this.set(this.x * fArray[0] + this.y * fArray[1] + this.z * fArray[2], this.x * fArray[4] + this.y * fArray[5] + this.z * fArray[6], this.x * fArray[8] + this.y * fArray[9] + this.z * fArray[10]);
    }

    public Vector3 rotate(float f2, float f3, float f4, float f5) {
        return this.mul(tmpMat.setToRotation(f3, f4, f5, f2));
    }

    public Vector3 rotateRad(float f2, float f3, float f4, float f5) {
        return this.mul(tmpMat.setToRotationRad(f3, f4, f5, f2));
    }

    public Vector3 rotate(Vector3 vector3, float f2) {
        tmpMat.setToRotation(vector3, f2);
        return this.mul(tmpMat);
    }

    public Vector3 rotateRad(Vector3 vector3, float f2) {
        tmpMat.setToRotationRad(vector3, f2);
        return this.mul(tmpMat);
    }

    @Override
    public boolean isUnit() {
        return this.isUnit(1.0E-9f);
    }

    @Override
    public boolean isUnit(float f2) {
        return Math.abs(this.len2() - 1.0f) < f2;
    }

    @Override
    public boolean isZero() {
        return this.x == 0.0f && this.y == 0.0f && this.z == 0.0f;
    }

    @Override
    public boolean isZero(float f2) {
        return this.len2() < f2;
    }

    @Override
    public boolean isOnLine(Vector3 vector3, float f2) {
        return Vector3.len2(this.y * vector3.z - this.z * vector3.y, this.z * vector3.x - this.x * vector3.z, this.x * vector3.y - this.y * vector3.x) <= f2;
    }

    @Override
    public boolean isOnLine(Vector3 vector3) {
        return Vector3.len2(this.y * vector3.z - this.z * vector3.y, this.z * vector3.x - this.x * vector3.z, this.x * vector3.y - this.y * vector3.x) <= 1.0E-6f;
    }

    @Override
    public boolean isCollinear(Vector3 vector3, float f2) {
        return this.isOnLine(vector3, f2) && this.hasSameDirection(vector3);
    }

    @Override
    public boolean isCollinear(Vector3 vector3) {
        return this.isOnLine(vector3) && this.hasSameDirection(vector3);
    }

    @Override
    public boolean isCollinearOpposite(Vector3 vector3, float f2) {
        return this.isOnLine(vector3, f2) && this.hasOppositeDirection(vector3);
    }

    @Override
    public boolean isCollinearOpposite(Vector3 vector3) {
        return this.isOnLine(vector3) && this.hasOppositeDirection(vector3);
    }

    @Override
    public boolean isPerpendicular(Vector3 vector3) {
        return MathUtils.isZero(this.dot(vector3));
    }

    @Override
    public boolean isPerpendicular(Vector3 vector3, float f2) {
        return MathUtils.isZero(this.dot(vector3), f2);
    }

    @Override
    public boolean hasSameDirection(Vector3 vector3) {
        return this.dot(vector3) > 0.0f;
    }

    @Override
    public boolean hasOppositeDirection(Vector3 vector3) {
        return this.dot(vector3) < 0.0f;
    }

    @Override
    public Vector3 lerp(Vector3 vector3, float f2) {
        this.x += f2 * (vector3.x - this.x);
        this.y += f2 * (vector3.y - this.y);
        this.z += f2 * (vector3.z - this.z);
        return this;
    }

    @Override
    public Vector3 interpolate(Vector3 vector3, float f2, Interpolation interpolation) {
        return this.lerp(vector3, interpolation.apply(0.0f, 1.0f, f2));
    }

    public Vector3 slerp(Vector3 vector3, float f2) {
        float f3 = this.dot(vector3);
        if ((double)f3 > 0.9995 || (double)f3 < -0.9995) {
            return this.lerp(vector3, f2);
        }
        float f4 = (float)Math.acos(f3);
        float f5 = f4 * f2;
        float f6 = (float)Math.sin(f5);
        float f7 = vector3.x - this.x * f3;
        float f8 = vector3.y - this.y * f3;
        float f9 = vector3.z - this.z * f3;
        float f10 = f7 * f7 + f8 * f8 + f9 * f9;
        float f11 = f6 * (f10 < 1.0E-4f ? 1.0f : 1.0f / (float)Math.sqrt(f10));
        return this.scl((float)Math.cos(f5)).add(f7 * f11, f8 * f11, f9 * f11).nor();
    }

    public String toString() {
        return "(" + this.x + "," + this.y + "," + this.z + ")";
    }

    public Vector3 fromString(String string) {
        int n2 = string.indexOf(44, 1);
        int n3 = string.indexOf(44, n2 + 1);
        if (n2 != -1 && n3 != -1 && string.charAt(0) == '(' && string.charAt(string.length() - 1) == ')') {
            try {
                float f2 = Float.parseFloat(string.substring(1, n2));
                float f3 = Float.parseFloat(string.substring(n2 + 1, n3));
                float f4 = Float.parseFloat(string.substring(n3 + 1, string.length() - 1));
                return this.set(f2, f3, f4);
            }
            catch (NumberFormatException numberFormatException) {
                // empty catch block
            }
        }
        throw new GdxRuntimeException("Malformed Vector3: " + string);
    }

    @Override
    public Vector3 limit(float f2) {
        return this.limit2(f2 * f2);
    }

    @Override
    public Vector3 limit2(float f2) {
        float f3 = this.len2();
        if (f3 > f2) {
            this.scl((float)Math.sqrt(f2 / f3));
        }
        return this;
    }

    @Override
    public Vector3 setLength(float f2) {
        return this.setLength2(f2 * f2);
    }

    @Override
    public Vector3 setLength2(float f2) {
        float f3 = this.len2();
        return f3 == 0.0f || f3 == f2 ? this : this.scl((float)Math.sqrt(f2 / f3));
    }

    @Override
    public Vector3 clamp(float f2, float f3) {
        float f4 = this.len2();
        if (f4 == 0.0f) {
            return this;
        }
        float f5 = f3 * f3;
        if (f4 > f5) {
            return this.scl((float)Math.sqrt(f5 / f4));
        }
        float f6 = f2 * f2;
        if (f4 < f6) {
            return this.scl((float)Math.sqrt(f6 / f4));
        }
        return this;
    }

    public int hashCode() {
        int n2 = 31;
        int n3 = 1;
        n3 = 31 * n3 + NumberUtils.floatToIntBits(this.x);
        n3 = 31 * n3 + NumberUtils.floatToIntBits(this.y);
        n3 = 31 * n3 + NumberUtils.floatToIntBits(this.z);
        return n3;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (this.getClass() != object.getClass()) {
            return false;
        }
        Vector3 vector3 = (Vector3)object;
        if (NumberUtils.floatToIntBits(this.x) != NumberUtils.floatToIntBits(vector3.x)) {
            return false;
        }
        if (NumberUtils.floatToIntBits(this.y) != NumberUtils.floatToIntBits(vector3.y)) {
            return false;
        }
        return NumberUtils.floatToIntBits(this.z) == NumberUtils.floatToIntBits(vector3.z);
    }

    @Override
    public boolean epsilonEquals(Vector3 vector3, float f2) {
        if (vector3 == null) {
            return false;
        }
        if (Math.abs(vector3.x - this.x) > f2) {
            return false;
        }
        if (Math.abs(vector3.y - this.y) > f2) {
            return false;
        }
        return !(Math.abs(vector3.z - this.z) > f2);
    }

    public boolean epsilonEquals(float f2, float f3, float f4, float f5) {
        if (Math.abs(f2 - this.x) > f5) {
            return false;
        }
        if (Math.abs(f3 - this.y) > f5) {
            return false;
        }
        return !(Math.abs(f4 - this.z) > f5);
    }

    public boolean epsilonEquals(Vector3 vector3) {
        return this.epsilonEquals(vector3, 1.0E-6f);
    }

    public boolean epsilonEquals(float f2, float f3, float f4) {
        return this.epsilonEquals(f2, f3, f4, 1.0E-6f);
    }

    @Override
    public Vector3 setZero() {
        this.x = 0.0f;
        this.y = 0.0f;
        this.z = 0.0f;
        return this;
    }
}

