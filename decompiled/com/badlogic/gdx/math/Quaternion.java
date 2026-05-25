/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.math;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Matrix3;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.NumberUtils;
import java.io.Serializable;

public class Quaternion
implements Serializable {
    private static final long serialVersionUID = -7661875440774897168L;
    private static Quaternion tmp1 = new Quaternion(0.0f, 0.0f, 0.0f, 0.0f);
    private static Quaternion tmp2 = new Quaternion(0.0f, 0.0f, 0.0f, 0.0f);
    public float x;
    public float y;
    public float z;
    public float w;

    public Quaternion(float f2, float f3, float f4, float f5) {
        this.set(f2, f3, f4, f5);
    }

    public Quaternion() {
        this.idt();
    }

    public Quaternion(Quaternion quaternion) {
        this.set(quaternion);
    }

    public Quaternion(Vector3 vector3, float f2) {
        this.set(vector3, f2);
    }

    public Quaternion set(float f2, float f3, float f4, float f5) {
        this.x = f2;
        this.y = f3;
        this.z = f4;
        this.w = f5;
        return this;
    }

    public Quaternion set(Quaternion quaternion) {
        return this.set(quaternion.x, quaternion.y, quaternion.z, quaternion.w);
    }

    public Quaternion set(Vector3 vector3, float f2) {
        return this.setFromAxis(vector3.x, vector3.y, vector3.z, f2);
    }

    public Quaternion cpy() {
        return new Quaternion(this);
    }

    public static final float len(float f2, float f3, float f4, float f5) {
        return (float)Math.sqrt(f2 * f2 + f3 * f3 + f4 * f4 + f5 * f5);
    }

    public float len() {
        return (float)Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z + this.w * this.w);
    }

    public String toString() {
        return "[" + this.x + "|" + this.y + "|" + this.z + "|" + this.w + "]";
    }

    public Quaternion setEulerAngles(float f2, float f3, float f4) {
        return this.setEulerAnglesRad(f2 * ((float)Math.PI / 180), f3 * ((float)Math.PI / 180), f4 * ((float)Math.PI / 180));
    }

    public Quaternion setEulerAnglesRad(float f2, float f3, float f4) {
        float f5 = f4 * 0.5f;
        float f6 = (float)Math.sin(f5);
        float f7 = (float)Math.cos(f5);
        float f8 = f3 * 0.5f;
        float f9 = (float)Math.sin(f8);
        float f10 = (float)Math.cos(f8);
        float f11 = f2 * 0.5f;
        float f12 = (float)Math.sin(f11);
        float f13 = (float)Math.cos(f11);
        float f14 = f13 * f9;
        float f15 = f12 * f10;
        float f16 = f13 * f10;
        float f17 = f12 * f9;
        this.x = f14 * f7 + f15 * f6;
        this.y = f15 * f7 - f14 * f6;
        this.z = f16 * f6 - f17 * f7;
        this.w = f16 * f7 + f17 * f6;
        return this;
    }

    public int getGimbalPole() {
        float f2 = this.y * this.x + this.z * this.w;
        return f2 > 0.499f ? 1 : (f2 < -0.499f ? -1 : 0);
    }

    public float getRollRad() {
        int n2 = this.getGimbalPole();
        return n2 == 0 ? MathUtils.atan2(2.0f * (this.w * this.z + this.y * this.x), 1.0f - 2.0f * (this.x * this.x + this.z * this.z)) : (float)n2 * 2.0f * MathUtils.atan2(this.y, this.w);
    }

    public float getRoll() {
        return this.getRollRad() * 57.295776f;
    }

    public float getPitchRad() {
        int n2 = this.getGimbalPole();
        return n2 == 0 ? (float)Math.asin(MathUtils.clamp(2.0f * (this.w * this.x - this.z * this.y), -1.0f, 1.0f)) : (float)n2 * (float)Math.PI * 0.5f;
    }

    public float getPitch() {
        return this.getPitchRad() * 57.295776f;
    }

    public float getYawRad() {
        return this.getGimbalPole() == 0 ? MathUtils.atan2(2.0f * (this.y * this.w + this.x * this.z), 1.0f - 2.0f * (this.y * this.y + this.x * this.x)) : 0.0f;
    }

    public float getYaw() {
        return this.getYawRad() * 57.295776f;
    }

    public static final float len2(float f2, float f3, float f4, float f5) {
        return f2 * f2 + f3 * f3 + f4 * f4 + f5 * f5;
    }

    public float len2() {
        return this.x * this.x + this.y * this.y + this.z * this.z + this.w * this.w;
    }

    public Quaternion nor() {
        float f2 = this.len2();
        if (f2 != 0.0f && !MathUtils.isEqual(f2, 1.0f)) {
            f2 = (float)Math.sqrt(f2);
            this.w /= f2;
            this.x /= f2;
            this.y /= f2;
            this.z /= f2;
        }
        return this;
    }

    public Quaternion conjugate() {
        this.x = -this.x;
        this.y = -this.y;
        this.z = -this.z;
        return this;
    }

    public Vector3 transform(Vector3 vector3) {
        tmp2.set(this);
        tmp2.conjugate();
        tmp2.mulLeft(tmp1.set(vector3.x, vector3.y, vector3.z, 0.0f)).mulLeft(this);
        vector3.x = Quaternion.tmp2.x;
        vector3.y = Quaternion.tmp2.y;
        vector3.z = Quaternion.tmp2.z;
        return vector3;
    }

    public Quaternion mul(Quaternion quaternion) {
        float f2 = this.w * quaternion.x + this.x * quaternion.w + this.y * quaternion.z - this.z * quaternion.y;
        float f3 = this.w * quaternion.y + this.y * quaternion.w + this.z * quaternion.x - this.x * quaternion.z;
        float f4 = this.w * quaternion.z + this.z * quaternion.w + this.x * quaternion.y - this.y * quaternion.x;
        float f5 = this.w * quaternion.w - this.x * quaternion.x - this.y * quaternion.y - this.z * quaternion.z;
        this.x = f2;
        this.y = f3;
        this.z = f4;
        this.w = f5;
        return this;
    }

    public Quaternion mul(float f2, float f3, float f4, float f5) {
        float f6 = this.w * f2 + this.x * f5 + this.y * f4 - this.z * f3;
        float f7 = this.w * f3 + this.y * f5 + this.z * f2 - this.x * f4;
        float f8 = this.w * f4 + this.z * f5 + this.x * f3 - this.y * f2;
        float f9 = this.w * f5 - this.x * f2 - this.y * f3 - this.z * f4;
        this.x = f6;
        this.y = f7;
        this.z = f8;
        this.w = f9;
        return this;
    }

    public Quaternion mulLeft(Quaternion quaternion) {
        float f2 = quaternion.w * this.x + quaternion.x * this.w + quaternion.y * this.z - quaternion.z * this.y;
        float f3 = quaternion.w * this.y + quaternion.y * this.w + quaternion.z * this.x - quaternion.x * this.z;
        float f4 = quaternion.w * this.z + quaternion.z * this.w + quaternion.x * this.y - quaternion.y * this.x;
        float f5 = quaternion.w * this.w - quaternion.x * this.x - quaternion.y * this.y - quaternion.z * this.z;
        this.x = f2;
        this.y = f3;
        this.z = f4;
        this.w = f5;
        return this;
    }

    public Quaternion mulLeft(float f2, float f3, float f4, float f5) {
        float f6 = f5 * this.x + f2 * this.w + f3 * this.z - f4 * this.y;
        float f7 = f5 * this.y + f3 * this.w + f4 * this.x - f2 * this.z;
        float f8 = f5 * this.z + f4 * this.w + f2 * this.y - f3 * this.x;
        float f9 = f5 * this.w - f2 * this.x - f3 * this.y - f4 * this.z;
        this.x = f6;
        this.y = f7;
        this.z = f8;
        this.w = f9;
        return this;
    }

    public Quaternion add(Quaternion quaternion) {
        this.x += quaternion.x;
        this.y += quaternion.y;
        this.z += quaternion.z;
        this.w += quaternion.w;
        return this;
    }

    public Quaternion add(float f2, float f3, float f4, float f5) {
        this.x += f2;
        this.y += f3;
        this.z += f4;
        this.w += f5;
        return this;
    }

    public void toMatrix(float[] fArray) {
        float f2 = this.x * this.x;
        float f3 = this.x * this.y;
        float f4 = this.x * this.z;
        float f5 = this.x * this.w;
        float f6 = this.y * this.y;
        float f7 = this.y * this.z;
        float f8 = this.y * this.w;
        float f9 = this.z * this.z;
        float f10 = this.z * this.w;
        fArray[0] = 1.0f - 2.0f * (f6 + f9);
        fArray[4] = 2.0f * (f3 - f10);
        fArray[8] = 2.0f * (f4 + f8);
        fArray[12] = 0.0f;
        fArray[1] = 2.0f * (f3 + f10);
        fArray[5] = 1.0f - 2.0f * (f2 + f9);
        fArray[9] = 2.0f * (f7 - f5);
        fArray[13] = 0.0f;
        fArray[2] = 2.0f * (f4 - f8);
        fArray[6] = 2.0f * (f7 + f5);
        fArray[10] = 1.0f - 2.0f * (f2 + f6);
        fArray[14] = 0.0f;
        fArray[3] = 0.0f;
        fArray[7] = 0.0f;
        fArray[11] = 0.0f;
        fArray[15] = 1.0f;
    }

    public Quaternion idt() {
        return this.set(0.0f, 0.0f, 0.0f, 1.0f);
    }

    public boolean isIdentity() {
        return MathUtils.isZero(this.x) && MathUtils.isZero(this.y) && MathUtils.isZero(this.z) && MathUtils.isEqual(this.w, 1.0f);
    }

    public boolean isIdentity(float f2) {
        return MathUtils.isZero(this.x, f2) && MathUtils.isZero(this.y, f2) && MathUtils.isZero(this.z, f2) && MathUtils.isEqual(this.w, 1.0f, f2);
    }

    public Quaternion setFromAxis(Vector3 vector3, float f2) {
        return this.setFromAxis(vector3.x, vector3.y, vector3.z, f2);
    }

    public Quaternion setFromAxisRad(Vector3 vector3, float f2) {
        return this.setFromAxisRad(vector3.x, vector3.y, vector3.z, f2);
    }

    public Quaternion setFromAxis(float f2, float f3, float f4, float f5) {
        return this.setFromAxisRad(f2, f3, f4, f5 * ((float)Math.PI / 180));
    }

    public Quaternion setFromAxisRad(float f2, float f3, float f4, float f5) {
        float f6 = Vector3.len(f2, f3, f4);
        if (f6 == 0.0f) {
            return this.idt();
        }
        f6 = 1.0f / f6;
        float f7 = f5 < 0.0f ? (float)Math.PI * 2 - -f5 % ((float)Math.PI * 2) : f5 % ((float)Math.PI * 2);
        float f8 = (float)Math.sin(f7 / 2.0f);
        float f9 = (float)Math.cos(f7 / 2.0f);
        return this.set(f6 * f2 * f8, f6 * f3 * f8, f6 * f4 * f8, f9).nor();
    }

    public Quaternion setFromMatrix(boolean bl2, Matrix4 matrix4) {
        return this.setFromAxes(bl2, matrix4.val[0], matrix4.val[4], matrix4.val[8], matrix4.val[1], matrix4.val[5], matrix4.val[9], matrix4.val[2], matrix4.val[6], matrix4.val[10]);
    }

    public Quaternion setFromMatrix(Matrix4 matrix4) {
        return this.setFromMatrix(false, matrix4);
    }

    public Quaternion setFromMatrix(boolean bl2, Matrix3 matrix3) {
        return this.setFromAxes(bl2, matrix3.val[0], matrix3.val[3], matrix3.val[6], matrix3.val[1], matrix3.val[4], matrix3.val[7], matrix3.val[2], matrix3.val[5], matrix3.val[8]);
    }

    public Quaternion setFromMatrix(Matrix3 matrix3) {
        return this.setFromMatrix(false, matrix3);
    }

    public Quaternion setFromAxes(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        return this.setFromAxes(false, f2, f3, f4, f5, f6, f7, f8, f9, f10);
    }

    public Quaternion setFromAxes(boolean bl2, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        float f11;
        float f12;
        if (bl2) {
            f12 = 1.0f / Vector3.len(f2, f3, f4);
            f11 = 1.0f / Vector3.len(f5, f6, f7);
            float f13 = 1.0f / Vector3.len(f8, f9, f10);
            f2 *= f12;
            f3 *= f12;
            f4 *= f12;
            f5 *= f11;
            f6 *= f11;
            f7 *= f11;
            f8 *= f13;
            f9 *= f13;
            f10 *= f13;
        }
        if ((f12 = f2 + f6 + f10) >= 0.0f) {
            f11 = (float)Math.sqrt(f12 + 1.0f);
            this.w = 0.5f * f11;
            f11 = 0.5f / f11;
            this.x = (f9 - f7) * f11;
            this.y = (f4 - f8) * f11;
            this.z = (f5 - f3) * f11;
        } else if (f2 > f6 && f2 > f10) {
            f11 = (float)Math.sqrt(1.0 + (double)f2 - (double)f6 - (double)f10);
            this.x = f11 * 0.5f;
            f11 = 0.5f / f11;
            this.y = (f5 + f3) * f11;
            this.z = (f4 + f8) * f11;
            this.w = (f9 - f7) * f11;
        } else if (f6 > f10) {
            f11 = (float)Math.sqrt(1.0 + (double)f6 - (double)f2 - (double)f10);
            this.y = f11 * 0.5f;
            f11 = 0.5f / f11;
            this.x = (f5 + f3) * f11;
            this.z = (f9 + f7) * f11;
            this.w = (f4 - f8) * f11;
        } else {
            f11 = (float)Math.sqrt(1.0 + (double)f10 - (double)f2 - (double)f6);
            this.z = f11 * 0.5f;
            f11 = 0.5f / f11;
            this.x = (f4 + f8) * f11;
            this.y = (f9 + f7) * f11;
            this.w = (f5 - f3) * f11;
        }
        return this;
    }

    public Quaternion setFromCross(Vector3 vector3, Vector3 vector32) {
        float f2 = MathUtils.clamp(vector3.dot(vector32), -1.0f, 1.0f);
        float f3 = (float)Math.acos(f2);
        return this.setFromAxisRad(vector3.y * vector32.z - vector3.z * vector32.y, vector3.z * vector32.x - vector3.x * vector32.z, vector3.x * vector32.y - vector3.y * vector32.x, f3);
    }

    public Quaternion setFromCross(float f2, float f3, float f4, float f5, float f6, float f7) {
        float f8 = MathUtils.clamp(Vector3.dot(f2, f3, f4, f5, f6, f7), -1.0f, 1.0f);
        float f9 = (float)Math.acos(f8);
        return this.setFromAxisRad(f3 * f7 - f4 * f6, f4 * f5 - f2 * f7, f2 * f6 - f3 * f5, f9);
    }

    public Quaternion slerp(Quaternion quaternion, float f2) {
        float f3 = this.x * quaternion.x + this.y * quaternion.y + this.z * quaternion.z + this.w * quaternion.w;
        float f4 = f3 < 0.0f ? -f3 : f3;
        float f5 = 1.0f - f2;
        float f6 = f2;
        if ((double)(1.0f - f4) > 0.1) {
            float f7 = (float)Math.acos(f4);
            float f8 = 1.0f / (float)Math.sin(f7);
            f5 = (float)Math.sin((1.0f - f2) * f7) * f8;
            f6 = (float)Math.sin(f2 * f7) * f8;
        }
        if (f3 < 0.0f) {
            f6 = -f6;
        }
        this.x = f5 * this.x + f6 * quaternion.x;
        this.y = f5 * this.y + f6 * quaternion.y;
        this.z = f5 * this.z + f6 * quaternion.z;
        this.w = f5 * this.w + f6 * quaternion.w;
        return this;
    }

    public Quaternion slerp(Quaternion[] quaternionArray) {
        float f2 = 1.0f / (float)quaternionArray.length;
        this.set(quaternionArray[0]).exp(f2);
        for (int i2 = 1; i2 < quaternionArray.length; ++i2) {
            this.mul(tmp1.set(quaternionArray[i2]).exp(f2));
        }
        this.nor();
        return this;
    }

    public Quaternion slerp(Quaternion[] quaternionArray, float[] fArray) {
        this.set(quaternionArray[0]).exp(fArray[0]);
        for (int i2 = 1; i2 < quaternionArray.length; ++i2) {
            this.mul(tmp1.set(quaternionArray[i2]).exp(fArray[i2]));
        }
        this.nor();
        return this;
    }

    public Quaternion exp(float f2) {
        float f3 = this.len();
        float f4 = (float)Math.pow(f3, f2);
        float f5 = (float)Math.acos(this.w / f3);
        float f6 = 0.0f;
        f6 = (double)Math.abs(f5) < 0.001 ? f4 * f2 / f3 : (float)((double)f4 * Math.sin(f2 * f5) / ((double)f3 * Math.sin(f5)));
        this.w = (float)((double)f4 * Math.cos(f2 * f5));
        this.x *= f6;
        this.y *= f6;
        this.z *= f6;
        this.nor();
        return this;
    }

    public int hashCode() {
        int n2 = 31;
        int n3 = 1;
        n3 = 31 * n3 + NumberUtils.floatToRawIntBits(this.w);
        n3 = 31 * n3 + NumberUtils.floatToRawIntBits(this.x);
        n3 = 31 * n3 + NumberUtils.floatToRawIntBits(this.y);
        n3 = 31 * n3 + NumberUtils.floatToRawIntBits(this.z);
        return n3;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (!(object instanceof Quaternion)) {
            return false;
        }
        Quaternion quaternion = (Quaternion)object;
        return NumberUtils.floatToRawIntBits(this.w) == NumberUtils.floatToRawIntBits(quaternion.w) && NumberUtils.floatToRawIntBits(this.x) == NumberUtils.floatToRawIntBits(quaternion.x) && NumberUtils.floatToRawIntBits(this.y) == NumberUtils.floatToRawIntBits(quaternion.y) && NumberUtils.floatToRawIntBits(this.z) == NumberUtils.floatToRawIntBits(quaternion.z);
    }

    public static final float dot(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        return f2 * f6 + f3 * f7 + f4 * f8 + f5 * f9;
    }

    public float dot(Quaternion quaternion) {
        return this.x * quaternion.x + this.y * quaternion.y + this.z * quaternion.z + this.w * quaternion.w;
    }

    public float dot(float f2, float f3, float f4, float f5) {
        return this.x * f2 + this.y * f3 + this.z * f4 + this.w * f5;
    }

    public Quaternion mul(float f2) {
        this.x *= f2;
        this.y *= f2;
        this.z *= f2;
        this.w *= f2;
        return this;
    }

    public float getAxisAngle(Vector3 vector3) {
        return this.getAxisAngleRad(vector3) * 57.295776f;
    }

    public float getAxisAngleRad(Vector3 vector3) {
        if (this.w > 1.0f) {
            this.nor();
        }
        float f2 = (float)(2.0 * Math.acos(this.w));
        double d2 = Math.sqrt(1.0f - this.w * this.w);
        if (d2 < (double)1.0E-6f) {
            vector3.x = this.x;
            vector3.y = this.y;
            vector3.z = this.z;
        } else {
            vector3.x = (float)((double)this.x / d2);
            vector3.y = (float)((double)this.y / d2);
            vector3.z = (float)((double)this.z / d2);
        }
        return f2;
    }

    public float getAngleRad() {
        return (float)(2.0 * Math.acos(this.w > 1.0f ? (double)(this.w / this.len()) : (double)this.w));
    }

    public float getAngle() {
        return this.getAngleRad() * 57.295776f;
    }

    public void getSwingTwist(float f2, float f3, float f4, Quaternion quaternion, Quaternion quaternion2) {
        float f5 = Vector3.dot(this.x, this.y, this.z, f2, f3, f4);
        quaternion2.set(f2 * f5, f3 * f5, f4 * f5, this.w).nor();
        if (f5 < 0.0f) {
            quaternion2.mul(-1.0f);
        }
        quaternion.set(quaternion2).conjugate().mulLeft(this);
    }

    public void getSwingTwist(Vector3 vector3, Quaternion quaternion, Quaternion quaternion2) {
        this.getSwingTwist(vector3.x, vector3.y, vector3.z, quaternion, quaternion2);
    }

    public float getAngleAroundRad(float f2, float f3, float f4) {
        float f5 = Vector3.dot(this.x, this.y, this.z, f2, f3, f4);
        float f6 = Quaternion.len2(f2 * f5, f3 * f5, f4 * f5, this.w);
        return MathUtils.isZero(f6) ? 0.0f : (float)(2.0 * Math.acos(MathUtils.clamp((float)((double)(f5 < 0.0f ? -this.w : this.w) / Math.sqrt(f6)), -1.0f, 1.0f)));
    }

    public float getAngleAroundRad(Vector3 vector3) {
        return this.getAngleAroundRad(vector3.x, vector3.y, vector3.z);
    }

    public float getAngleAround(float f2, float f3, float f4) {
        return this.getAngleAroundRad(f2, f3, f4) * 57.295776f;
    }

    public float getAngleAround(Vector3 vector3) {
        return this.getAngleAround(vector3.x, vector3.y, vector3.z);
    }
}

