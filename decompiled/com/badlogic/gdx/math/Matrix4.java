/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.math;

import com.badlogic.gdx.math.Affine2;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Matrix3;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector3;
import java.io.Serializable;

public class Matrix4
implements Serializable {
    private static final long serialVersionUID = -2717655254359579617L;
    public static final int M00 = 0;
    public static final int M01 = 4;
    public static final int M02 = 8;
    public static final int M03 = 12;
    public static final int M10 = 1;
    public static final int M11 = 5;
    public static final int M12 = 9;
    public static final int M13 = 13;
    public static final int M20 = 2;
    public static final int M21 = 6;
    public static final int M22 = 10;
    public static final int M23 = 14;
    public static final int M30 = 3;
    public static final int M31 = 7;
    public static final int M32 = 11;
    public static final int M33 = 15;
    static final Quaternion quat = new Quaternion();
    static final Quaternion quat2 = new Quaternion();
    static final Vector3 l_vez = new Vector3();
    static final Vector3 l_vex = new Vector3();
    static final Vector3 l_vey = new Vector3();
    static final Vector3 tmpVec = new Vector3();
    static final Matrix4 tmpMat = new Matrix4();
    static final Vector3 right = new Vector3();
    static final Vector3 tmpForward = new Vector3();
    static final Vector3 tmpUp = new Vector3();
    public final float[] val = new float[16];

    public Matrix4() {
        this.val[0] = 1.0f;
        this.val[5] = 1.0f;
        this.val[10] = 1.0f;
        this.val[15] = 1.0f;
    }

    public Matrix4(Matrix4 matrix4) {
        this.set(matrix4);
    }

    public Matrix4(float[] fArray) {
        this.set(fArray);
    }

    public Matrix4(Quaternion quaternion) {
        this.set(quaternion);
    }

    public Matrix4(Vector3 vector3, Quaternion quaternion, Vector3 vector32) {
        this.set(vector3, quaternion, vector32);
    }

    public Matrix4 set(Matrix4 matrix4) {
        return this.set(matrix4.val);
    }

    public Matrix4 set(float[] fArray) {
        System.arraycopy(fArray, 0, this.val, 0, this.val.length);
        return this;
    }

    public Matrix4 set(Quaternion quaternion) {
        return this.set(quaternion.x, quaternion.y, quaternion.z, quaternion.w);
    }

    public Matrix4 set(float f2, float f3, float f4, float f5) {
        return this.set(0.0f, 0.0f, 0.0f, f2, f3, f4, f5);
    }

    public Matrix4 set(Vector3 vector3, Quaternion quaternion) {
        return this.set(vector3.x, vector3.y, vector3.z, quaternion.x, quaternion.y, quaternion.z, quaternion.w);
    }

    public Matrix4 set(float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        float f9 = f5 * 2.0f;
        float f10 = f6 * 2.0f;
        float f11 = f7 * 2.0f;
        float f12 = f8 * f9;
        float f13 = f8 * f10;
        float f14 = f8 * f11;
        float f15 = f5 * f9;
        float f16 = f5 * f10;
        float f17 = f5 * f11;
        float f18 = f6 * f10;
        float f19 = f6 * f11;
        float f20 = f7 * f11;
        this.val[0] = 1.0f - (f18 + f20);
        this.val[4] = f16 - f14;
        this.val[8] = f17 + f13;
        this.val[12] = f2;
        this.val[1] = f16 + f14;
        this.val[5] = 1.0f - (f15 + f20);
        this.val[9] = f19 - f12;
        this.val[13] = f3;
        this.val[2] = f17 - f13;
        this.val[6] = f19 + f12;
        this.val[10] = 1.0f - (f15 + f18);
        this.val[14] = f4;
        this.val[3] = 0.0f;
        this.val[7] = 0.0f;
        this.val[11] = 0.0f;
        this.val[15] = 1.0f;
        return this;
    }

    public Matrix4 set(Vector3 vector3, Quaternion quaternion, Vector3 vector32) {
        return this.set(vector3.x, vector3.y, vector3.z, quaternion.x, quaternion.y, quaternion.z, quaternion.w, vector32.x, vector32.y, vector32.z);
    }

    public Matrix4 set(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11) {
        float f12 = f5 * 2.0f;
        float f13 = f6 * 2.0f;
        float f14 = f7 * 2.0f;
        float f15 = f8 * f12;
        float f16 = f8 * f13;
        float f17 = f8 * f14;
        float f18 = f5 * f12;
        float f19 = f5 * f13;
        float f20 = f5 * f14;
        float f21 = f6 * f13;
        float f22 = f6 * f14;
        float f23 = f7 * f14;
        this.val[0] = f9 * (1.0f - (f21 + f23));
        this.val[4] = f10 * (f19 - f17);
        this.val[8] = f11 * (f20 + f16);
        this.val[12] = f2;
        this.val[1] = f9 * (f19 + f17);
        this.val[5] = f10 * (1.0f - (f18 + f23));
        this.val[9] = f11 * (f22 - f15);
        this.val[13] = f3;
        this.val[2] = f9 * (f20 - f16);
        this.val[6] = f10 * (f22 + f15);
        this.val[10] = f11 * (1.0f - (f18 + f21));
        this.val[14] = f4;
        this.val[3] = 0.0f;
        this.val[7] = 0.0f;
        this.val[11] = 0.0f;
        this.val[15] = 1.0f;
        return this;
    }

    public Matrix4 set(Vector3 vector3, Vector3 vector32, Vector3 vector33, Vector3 vector34) {
        this.val[0] = vector3.x;
        this.val[4] = vector3.y;
        this.val[8] = vector3.z;
        this.val[1] = vector32.x;
        this.val[5] = vector32.y;
        this.val[9] = vector32.z;
        this.val[2] = vector33.x;
        this.val[6] = vector33.y;
        this.val[10] = vector33.z;
        this.val[12] = vector34.x;
        this.val[13] = vector34.y;
        this.val[14] = vector34.z;
        this.val[3] = 0.0f;
        this.val[7] = 0.0f;
        this.val[11] = 0.0f;
        this.val[15] = 1.0f;
        return this;
    }

    public Matrix4 cpy() {
        return new Matrix4(this);
    }

    public Matrix4 trn(Vector3 vector3) {
        this.val[12] = this.val[12] + vector3.x;
        this.val[13] = this.val[13] + vector3.y;
        this.val[14] = this.val[14] + vector3.z;
        return this;
    }

    public Matrix4 trn(float f2, float f3, float f4) {
        this.val[12] = this.val[12] + f2;
        this.val[13] = this.val[13] + f3;
        this.val[14] = this.val[14] + f4;
        return this;
    }

    public float[] getValues() {
        return this.val;
    }

    public Matrix4 mul(Matrix4 matrix4) {
        Matrix4.mul(this.val, matrix4.val);
        return this;
    }

    public Matrix4 mulLeft(Matrix4 matrix4) {
        tmpMat.set(matrix4);
        Matrix4.mul(Matrix4.tmpMat.val, this.val);
        return this.set(tmpMat);
    }

    public Matrix4 tra() {
        float f2 = this.val[4];
        float f3 = this.val[8];
        float f4 = this.val[12];
        float f5 = this.val[9];
        float f6 = this.val[13];
        float f7 = this.val[14];
        this.val[4] = this.val[1];
        this.val[8] = this.val[2];
        this.val[12] = this.val[3];
        this.val[1] = f2;
        this.val[9] = this.val[6];
        this.val[13] = this.val[7];
        this.val[2] = f3;
        this.val[6] = f5;
        this.val[14] = this.val[11];
        this.val[3] = f4;
        this.val[7] = f6;
        this.val[11] = f7;
        return this;
    }

    public Matrix4 idt() {
        this.val[0] = 1.0f;
        this.val[4] = 0.0f;
        this.val[8] = 0.0f;
        this.val[12] = 0.0f;
        this.val[1] = 0.0f;
        this.val[5] = 1.0f;
        this.val[9] = 0.0f;
        this.val[13] = 0.0f;
        this.val[2] = 0.0f;
        this.val[6] = 0.0f;
        this.val[10] = 1.0f;
        this.val[14] = 0.0f;
        this.val[3] = 0.0f;
        this.val[7] = 0.0f;
        this.val[11] = 0.0f;
        this.val[15] = 1.0f;
        return this;
    }

    public Matrix4 inv() {
        float f2 = this.val[3] * this.val[6] * this.val[9] * this.val[12] - this.val[2] * this.val[7] * this.val[9] * this.val[12] - this.val[3] * this.val[5] * this.val[10] * this.val[12] + this.val[1] * this.val[7] * this.val[10] * this.val[12] + this.val[2] * this.val[5] * this.val[11] * this.val[12] - this.val[1] * this.val[6] * this.val[11] * this.val[12] - this.val[3] * this.val[6] * this.val[8] * this.val[13] + this.val[2] * this.val[7] * this.val[8] * this.val[13] + this.val[3] * this.val[4] * this.val[10] * this.val[13] - this.val[0] * this.val[7] * this.val[10] * this.val[13] - this.val[2] * this.val[4] * this.val[11] * this.val[13] + this.val[0] * this.val[6] * this.val[11] * this.val[13] + this.val[3] * this.val[5] * this.val[8] * this.val[14] - this.val[1] * this.val[7] * this.val[8] * this.val[14] - this.val[3] * this.val[4] * this.val[9] * this.val[14] + this.val[0] * this.val[7] * this.val[9] * this.val[14] + this.val[1] * this.val[4] * this.val[11] * this.val[14] - this.val[0] * this.val[5] * this.val[11] * this.val[14] - this.val[2] * this.val[5] * this.val[8] * this.val[15] + this.val[1] * this.val[6] * this.val[8] * this.val[15] + this.val[2] * this.val[4] * this.val[9] * this.val[15] - this.val[0] * this.val[6] * this.val[9] * this.val[15] - this.val[1] * this.val[4] * this.val[10] * this.val[15] + this.val[0] * this.val[5] * this.val[10] * this.val[15];
        if (f2 == 0.0f) {
            throw new RuntimeException("non-invertible matrix");
        }
        float f3 = this.val[9] * this.val[14] * this.val[7] - this.val[13] * this.val[10] * this.val[7] + this.val[13] * this.val[6] * this.val[11] - this.val[5] * this.val[14] * this.val[11] - this.val[9] * this.val[6] * this.val[15] + this.val[5] * this.val[10] * this.val[15];
        float f4 = this.val[12] * this.val[10] * this.val[7] - this.val[8] * this.val[14] * this.val[7] - this.val[12] * this.val[6] * this.val[11] + this.val[4] * this.val[14] * this.val[11] + this.val[8] * this.val[6] * this.val[15] - this.val[4] * this.val[10] * this.val[15];
        float f5 = this.val[8] * this.val[13] * this.val[7] - this.val[12] * this.val[9] * this.val[7] + this.val[12] * this.val[5] * this.val[11] - this.val[4] * this.val[13] * this.val[11] - this.val[8] * this.val[5] * this.val[15] + this.val[4] * this.val[9] * this.val[15];
        float f6 = this.val[12] * this.val[9] * this.val[6] - this.val[8] * this.val[13] * this.val[6] - this.val[12] * this.val[5] * this.val[10] + this.val[4] * this.val[13] * this.val[10] + this.val[8] * this.val[5] * this.val[14] - this.val[4] * this.val[9] * this.val[14];
        float f7 = this.val[13] * this.val[10] * this.val[3] - this.val[9] * this.val[14] * this.val[3] - this.val[13] * this.val[2] * this.val[11] + this.val[1] * this.val[14] * this.val[11] + this.val[9] * this.val[2] * this.val[15] - this.val[1] * this.val[10] * this.val[15];
        float f8 = this.val[8] * this.val[14] * this.val[3] - this.val[12] * this.val[10] * this.val[3] + this.val[12] * this.val[2] * this.val[11] - this.val[0] * this.val[14] * this.val[11] - this.val[8] * this.val[2] * this.val[15] + this.val[0] * this.val[10] * this.val[15];
        float f9 = this.val[12] * this.val[9] * this.val[3] - this.val[8] * this.val[13] * this.val[3] - this.val[12] * this.val[1] * this.val[11] + this.val[0] * this.val[13] * this.val[11] + this.val[8] * this.val[1] * this.val[15] - this.val[0] * this.val[9] * this.val[15];
        float f10 = this.val[8] * this.val[13] * this.val[2] - this.val[12] * this.val[9] * this.val[2] + this.val[12] * this.val[1] * this.val[10] - this.val[0] * this.val[13] * this.val[10] - this.val[8] * this.val[1] * this.val[14] + this.val[0] * this.val[9] * this.val[14];
        float f11 = this.val[5] * this.val[14] * this.val[3] - this.val[13] * this.val[6] * this.val[3] + this.val[13] * this.val[2] * this.val[7] - this.val[1] * this.val[14] * this.val[7] - this.val[5] * this.val[2] * this.val[15] + this.val[1] * this.val[6] * this.val[15];
        float f12 = this.val[12] * this.val[6] * this.val[3] - this.val[4] * this.val[14] * this.val[3] - this.val[12] * this.val[2] * this.val[7] + this.val[0] * this.val[14] * this.val[7] + this.val[4] * this.val[2] * this.val[15] - this.val[0] * this.val[6] * this.val[15];
        float f13 = this.val[4] * this.val[13] * this.val[3] - this.val[12] * this.val[5] * this.val[3] + this.val[12] * this.val[1] * this.val[7] - this.val[0] * this.val[13] * this.val[7] - this.val[4] * this.val[1] * this.val[15] + this.val[0] * this.val[5] * this.val[15];
        float f14 = this.val[12] * this.val[5] * this.val[2] - this.val[4] * this.val[13] * this.val[2] - this.val[12] * this.val[1] * this.val[6] + this.val[0] * this.val[13] * this.val[6] + this.val[4] * this.val[1] * this.val[14] - this.val[0] * this.val[5] * this.val[14];
        float f15 = this.val[9] * this.val[6] * this.val[3] - this.val[5] * this.val[10] * this.val[3] - this.val[9] * this.val[2] * this.val[7] + this.val[1] * this.val[10] * this.val[7] + this.val[5] * this.val[2] * this.val[11] - this.val[1] * this.val[6] * this.val[11];
        float f16 = this.val[4] * this.val[10] * this.val[3] - this.val[8] * this.val[6] * this.val[3] + this.val[8] * this.val[2] * this.val[7] - this.val[0] * this.val[10] * this.val[7] - this.val[4] * this.val[2] * this.val[11] + this.val[0] * this.val[6] * this.val[11];
        float f17 = this.val[8] * this.val[5] * this.val[3] - this.val[4] * this.val[9] * this.val[3] - this.val[8] * this.val[1] * this.val[7] + this.val[0] * this.val[9] * this.val[7] + this.val[4] * this.val[1] * this.val[11] - this.val[0] * this.val[5] * this.val[11];
        float f18 = this.val[4] * this.val[9] * this.val[2] - this.val[8] * this.val[5] * this.val[2] + this.val[8] * this.val[1] * this.val[6] - this.val[0] * this.val[9] * this.val[6] - this.val[4] * this.val[1] * this.val[10] + this.val[0] * this.val[5] * this.val[10];
        float f19 = 1.0f / f2;
        this.val[0] = f3 * f19;
        this.val[1] = f7 * f19;
        this.val[2] = f11 * f19;
        this.val[3] = f15 * f19;
        this.val[4] = f4 * f19;
        this.val[5] = f8 * f19;
        this.val[6] = f12 * f19;
        this.val[7] = f16 * f19;
        this.val[8] = f5 * f19;
        this.val[9] = f9 * f19;
        this.val[10] = f13 * f19;
        this.val[11] = f17 * f19;
        this.val[12] = f6 * f19;
        this.val[13] = f10 * f19;
        this.val[14] = f14 * f19;
        this.val[15] = f18 * f19;
        return this;
    }

    public float det() {
        return this.val[3] * this.val[6] * this.val[9] * this.val[12] - this.val[2] * this.val[7] * this.val[9] * this.val[12] - this.val[3] * this.val[5] * this.val[10] * this.val[12] + this.val[1] * this.val[7] * this.val[10] * this.val[12] + this.val[2] * this.val[5] * this.val[11] * this.val[12] - this.val[1] * this.val[6] * this.val[11] * this.val[12] - this.val[3] * this.val[6] * this.val[8] * this.val[13] + this.val[2] * this.val[7] * this.val[8] * this.val[13] + this.val[3] * this.val[4] * this.val[10] * this.val[13] - this.val[0] * this.val[7] * this.val[10] * this.val[13] - this.val[2] * this.val[4] * this.val[11] * this.val[13] + this.val[0] * this.val[6] * this.val[11] * this.val[13] + this.val[3] * this.val[5] * this.val[8] * this.val[14] - this.val[1] * this.val[7] * this.val[8] * this.val[14] - this.val[3] * this.val[4] * this.val[9] * this.val[14] + this.val[0] * this.val[7] * this.val[9] * this.val[14] + this.val[1] * this.val[4] * this.val[11] * this.val[14] - this.val[0] * this.val[5] * this.val[11] * this.val[14] - this.val[2] * this.val[5] * this.val[8] * this.val[15] + this.val[1] * this.val[6] * this.val[8] * this.val[15] + this.val[2] * this.val[4] * this.val[9] * this.val[15] - this.val[0] * this.val[6] * this.val[9] * this.val[15] - this.val[1] * this.val[4] * this.val[10] * this.val[15] + this.val[0] * this.val[5] * this.val[10] * this.val[15];
    }

    public float det3x3() {
        return this.val[0] * this.val[5] * this.val[10] + this.val[4] * this.val[9] * this.val[2] + this.val[8] * this.val[1] * this.val[6] - this.val[0] * this.val[9] * this.val[6] - this.val[4] * this.val[1] * this.val[10] - this.val[8] * this.val[5] * this.val[2];
    }

    public Matrix4 setToProjection(float f2, float f3, float f4, float f5) {
        this.idt();
        float f6 = (float)(1.0 / Math.tan((double)f4 * (Math.PI / 180) / 2.0));
        float f7 = (f3 + f2) / (f2 - f3);
        float f8 = 2.0f * f3 * f2 / (f2 - f3);
        this.val[0] = f6 / f5;
        this.val[1] = 0.0f;
        this.val[2] = 0.0f;
        this.val[3] = 0.0f;
        this.val[4] = 0.0f;
        this.val[5] = f6;
        this.val[6] = 0.0f;
        this.val[7] = 0.0f;
        this.val[8] = 0.0f;
        this.val[9] = 0.0f;
        this.val[10] = f7;
        this.val[11] = -1.0f;
        this.val[12] = 0.0f;
        this.val[13] = 0.0f;
        this.val[14] = f8;
        this.val[15] = 0.0f;
        return this;
    }

    public Matrix4 setToProjection(float f2, float f3, float f4, float f5, float f6, float f7) {
        float f8 = 2.0f * f6 / (f3 - f2);
        float f9 = 2.0f * f6 / (f5 - f4);
        float f10 = (f3 + f2) / (f3 - f2);
        float f11 = (f5 + f4) / (f5 - f4);
        float f12 = (f7 + f6) / (f6 - f7);
        float f13 = 2.0f * f7 * f6 / (f6 - f7);
        this.val[0] = f8;
        this.val[1] = 0.0f;
        this.val[2] = 0.0f;
        this.val[3] = 0.0f;
        this.val[4] = 0.0f;
        this.val[5] = f9;
        this.val[6] = 0.0f;
        this.val[7] = 0.0f;
        this.val[8] = f10;
        this.val[9] = f11;
        this.val[10] = f12;
        this.val[11] = -1.0f;
        this.val[12] = 0.0f;
        this.val[13] = 0.0f;
        this.val[14] = f13;
        this.val[15] = 0.0f;
        return this;
    }

    public Matrix4 setToOrtho2D(float f2, float f3, float f4, float f5) {
        this.setToOrtho(f2, f2 + f4, f3, f3 + f5, 0.0f, 1.0f);
        return this;
    }

    public Matrix4 setToOrtho2D(float f2, float f3, float f4, float f5, float f6, float f7) {
        this.setToOrtho(f2, f2 + f4, f3, f3 + f5, f6, f7);
        return this;
    }

    public Matrix4 setToOrtho(float f2, float f3, float f4, float f5, float f6, float f7) {
        float f8 = 2.0f / (f3 - f2);
        float f9 = 2.0f / (f5 - f4);
        float f10 = -2.0f / (f7 - f6);
        float f11 = -(f3 + f2) / (f3 - f2);
        float f12 = -(f5 + f4) / (f5 - f4);
        float f13 = -(f7 + f6) / (f7 - f6);
        this.val[0] = f8;
        this.val[1] = 0.0f;
        this.val[2] = 0.0f;
        this.val[3] = 0.0f;
        this.val[4] = 0.0f;
        this.val[5] = f9;
        this.val[6] = 0.0f;
        this.val[7] = 0.0f;
        this.val[8] = 0.0f;
        this.val[9] = 0.0f;
        this.val[10] = f10;
        this.val[11] = 0.0f;
        this.val[12] = f11;
        this.val[13] = f12;
        this.val[14] = f13;
        this.val[15] = 1.0f;
        return this;
    }

    public Matrix4 setTranslation(Vector3 vector3) {
        this.val[12] = vector3.x;
        this.val[13] = vector3.y;
        this.val[14] = vector3.z;
        return this;
    }

    public Matrix4 setTranslation(float f2, float f3, float f4) {
        this.val[12] = f2;
        this.val[13] = f3;
        this.val[14] = f4;
        return this;
    }

    public Matrix4 setToTranslation(Vector3 vector3) {
        this.idt();
        this.val[12] = vector3.x;
        this.val[13] = vector3.y;
        this.val[14] = vector3.z;
        return this;
    }

    public Matrix4 setToTranslation(float f2, float f3, float f4) {
        this.idt();
        this.val[12] = f2;
        this.val[13] = f3;
        this.val[14] = f4;
        return this;
    }

    public Matrix4 setToTranslationAndScaling(Vector3 vector3, Vector3 vector32) {
        this.idt();
        this.val[12] = vector3.x;
        this.val[13] = vector3.y;
        this.val[14] = vector3.z;
        this.val[0] = vector32.x;
        this.val[5] = vector32.y;
        this.val[10] = vector32.z;
        return this;
    }

    public Matrix4 setToTranslationAndScaling(float f2, float f3, float f4, float f5, float f6, float f7) {
        this.idt();
        this.val[12] = f2;
        this.val[13] = f3;
        this.val[14] = f4;
        this.val[0] = f5;
        this.val[5] = f6;
        this.val[10] = f7;
        return this;
    }

    public Matrix4 setToRotation(Vector3 vector3, float f2) {
        if (f2 == 0.0f) {
            this.idt();
            return this;
        }
        return this.set(quat.set(vector3, f2));
    }

    public Matrix4 setToRotationRad(Vector3 vector3, float f2) {
        if (f2 == 0.0f) {
            this.idt();
            return this;
        }
        return this.set(quat.setFromAxisRad(vector3, f2));
    }

    public Matrix4 setToRotation(float f2, float f3, float f4, float f5) {
        if (f5 == 0.0f) {
            this.idt();
            return this;
        }
        return this.set(quat.setFromAxis(f2, f3, f4, f5));
    }

    public Matrix4 setToRotationRad(float f2, float f3, float f4, float f5) {
        if (f5 == 0.0f) {
            this.idt();
            return this;
        }
        return this.set(quat.setFromAxisRad(f2, f3, f4, f5));
    }

    public Matrix4 setToRotation(Vector3 vector3, Vector3 vector32) {
        return this.set(quat.setFromCross(vector3, vector32));
    }

    public Matrix4 setToRotation(float f2, float f3, float f4, float f5, float f6, float f7) {
        return this.set(quat.setFromCross(f2, f3, f4, f5, f6, f7));
    }

    public Matrix4 setFromEulerAngles(float f2, float f3, float f4) {
        quat.setEulerAngles(f2, f3, f4);
        return this.set(quat);
    }

    public Matrix4 setFromEulerAnglesRad(float f2, float f3, float f4) {
        quat.setEulerAnglesRad(f2, f3, f4);
        return this.set(quat);
    }

    public Matrix4 setToScaling(Vector3 vector3) {
        this.idt();
        this.val[0] = vector3.x;
        this.val[5] = vector3.y;
        this.val[10] = vector3.z;
        return this;
    }

    public Matrix4 setToScaling(float f2, float f3, float f4) {
        this.idt();
        this.val[0] = f2;
        this.val[5] = f3;
        this.val[10] = f4;
        return this;
    }

    public Matrix4 setToLookAt(Vector3 vector3, Vector3 vector32) {
        l_vez.set(vector3).nor();
        l_vex.set(vector3).crs(vector32).nor();
        l_vey.set(l_vex).crs(l_vez).nor();
        this.idt();
        this.val[0] = Matrix4.l_vex.x;
        this.val[4] = Matrix4.l_vex.y;
        this.val[8] = Matrix4.l_vex.z;
        this.val[1] = Matrix4.l_vey.x;
        this.val[5] = Matrix4.l_vey.y;
        this.val[9] = Matrix4.l_vey.z;
        this.val[2] = -Matrix4.l_vez.x;
        this.val[6] = -Matrix4.l_vez.y;
        this.val[10] = -Matrix4.l_vez.z;
        return this;
    }

    public Matrix4 setToLookAt(Vector3 vector3, Vector3 vector32, Vector3 vector33) {
        tmpVec.set(vector32).sub(vector3);
        this.setToLookAt(tmpVec, vector33);
        this.mul(tmpMat.setToTranslation(-vector3.x, -vector3.y, -vector3.z));
        return this;
    }

    public Matrix4 setToWorld(Vector3 vector3, Vector3 vector32, Vector3 vector33) {
        tmpForward.set(vector32).nor();
        right.set(tmpForward).crs(vector33).nor();
        tmpUp.set(right).crs(tmpForward).nor();
        this.set(right, tmpUp, tmpForward.scl(-1.0f), vector3);
        return this;
    }

    public Matrix4 lerp(Matrix4 matrix4, float f2) {
        for (int i2 = 0; i2 < 16; ++i2) {
            this.val[i2] = this.val[i2] * (1.0f - f2) + matrix4.val[i2] * f2;
        }
        return this;
    }

    public Matrix4 avg(Matrix4 matrix4, float f2) {
        this.getScale(tmpVec);
        matrix4.getScale(tmpForward);
        this.getRotation(quat);
        matrix4.getRotation(quat2);
        this.getTranslation(tmpUp);
        matrix4.getTranslation(right);
        this.setToScaling(tmpVec.scl(f2).add(tmpForward.scl(1.0f - f2)));
        this.rotate(quat.slerp(quat2, 1.0f - f2));
        this.setTranslation(tmpUp.scl(f2).add(right.scl(1.0f - f2)));
        return this;
    }

    public Matrix4 avg(Matrix4[] matrix4Array) {
        float f2 = 1.0f / (float)matrix4Array.length;
        tmpVec.set(matrix4Array[0].getScale(tmpUp).scl(f2));
        quat.set(matrix4Array[0].getRotation(quat2).exp(f2));
        tmpForward.set(matrix4Array[0].getTranslation(tmpUp).scl(f2));
        for (int i2 = 1; i2 < matrix4Array.length; ++i2) {
            tmpVec.add(matrix4Array[i2].getScale(tmpUp).scl(f2));
            quat.mul(matrix4Array[i2].getRotation(quat2).exp(f2));
            tmpForward.add(matrix4Array[i2].getTranslation(tmpUp).scl(f2));
        }
        quat.nor();
        this.setToScaling(tmpVec);
        this.rotate(quat);
        this.setTranslation(tmpForward);
        return this;
    }

    public Matrix4 avg(Matrix4[] matrix4Array, float[] fArray) {
        tmpVec.set(matrix4Array[0].getScale(tmpUp).scl(fArray[0]));
        quat.set(matrix4Array[0].getRotation(quat2).exp(fArray[0]));
        tmpForward.set(matrix4Array[0].getTranslation(tmpUp).scl(fArray[0]));
        for (int i2 = 1; i2 < matrix4Array.length; ++i2) {
            tmpVec.add(matrix4Array[i2].getScale(tmpUp).scl(fArray[i2]));
            quat.mul(matrix4Array[i2].getRotation(quat2).exp(fArray[i2]));
            tmpForward.add(matrix4Array[i2].getTranslation(tmpUp).scl(fArray[i2]));
        }
        quat.nor();
        this.setToScaling(tmpVec);
        this.rotate(quat);
        this.setTranslation(tmpForward);
        return this;
    }

    public Matrix4 set(Matrix3 matrix3) {
        this.val[0] = matrix3.val[0];
        this.val[1] = matrix3.val[1];
        this.val[2] = matrix3.val[2];
        this.val[3] = 0.0f;
        this.val[4] = matrix3.val[3];
        this.val[5] = matrix3.val[4];
        this.val[6] = matrix3.val[5];
        this.val[7] = 0.0f;
        this.val[8] = 0.0f;
        this.val[9] = 0.0f;
        this.val[10] = 1.0f;
        this.val[11] = 0.0f;
        this.val[12] = matrix3.val[6];
        this.val[13] = matrix3.val[7];
        this.val[14] = 0.0f;
        this.val[15] = matrix3.val[8];
        return this;
    }

    public Matrix4 set(Affine2 affine2) {
        this.val[0] = affine2.m00;
        this.val[1] = affine2.m10;
        this.val[2] = 0.0f;
        this.val[3] = 0.0f;
        this.val[4] = affine2.m01;
        this.val[5] = affine2.m11;
        this.val[6] = 0.0f;
        this.val[7] = 0.0f;
        this.val[8] = 0.0f;
        this.val[9] = 0.0f;
        this.val[10] = 1.0f;
        this.val[11] = 0.0f;
        this.val[12] = affine2.m02;
        this.val[13] = affine2.m12;
        this.val[14] = 0.0f;
        this.val[15] = 1.0f;
        return this;
    }

    public Matrix4 setAsAffine(Affine2 affine2) {
        this.val[0] = affine2.m00;
        this.val[1] = affine2.m10;
        this.val[4] = affine2.m01;
        this.val[5] = affine2.m11;
        this.val[12] = affine2.m02;
        this.val[13] = affine2.m12;
        return this;
    }

    public Matrix4 setAsAffine(Matrix4 matrix4) {
        this.val[0] = matrix4.val[0];
        this.val[1] = matrix4.val[1];
        this.val[4] = matrix4.val[4];
        this.val[5] = matrix4.val[5];
        this.val[12] = matrix4.val[12];
        this.val[13] = matrix4.val[13];
        return this;
    }

    public Matrix4 scl(Vector3 vector3) {
        this.val[0] = this.val[0] * vector3.x;
        this.val[5] = this.val[5] * vector3.y;
        this.val[10] = this.val[10] * vector3.z;
        return this;
    }

    public Matrix4 scl(float f2, float f3, float f4) {
        this.val[0] = this.val[0] * f2;
        this.val[5] = this.val[5] * f3;
        this.val[10] = this.val[10] * f4;
        return this;
    }

    public Matrix4 scl(float f2) {
        this.val[0] = this.val[0] * f2;
        this.val[5] = this.val[5] * f2;
        this.val[10] = this.val[10] * f2;
        return this;
    }

    public Vector3 getTranslation(Vector3 vector3) {
        vector3.x = this.val[12];
        vector3.y = this.val[13];
        vector3.z = this.val[14];
        return vector3;
    }

    public Quaternion getRotation(Quaternion quaternion, boolean bl2) {
        return quaternion.setFromMatrix(bl2, this);
    }

    public Quaternion getRotation(Quaternion quaternion) {
        return quaternion.setFromMatrix(this);
    }

    public float getScaleXSquared() {
        return this.val[0] * this.val[0] + this.val[4] * this.val[4] + this.val[8] * this.val[8];
    }

    public float getScaleYSquared() {
        return this.val[1] * this.val[1] + this.val[5] * this.val[5] + this.val[9] * this.val[9];
    }

    public float getScaleZSquared() {
        return this.val[2] * this.val[2] + this.val[6] * this.val[6] + this.val[10] * this.val[10];
    }

    public float getScaleX() {
        return MathUtils.isZero(this.val[4]) && MathUtils.isZero(this.val[8]) ? Math.abs(this.val[0]) : (float)Math.sqrt(this.getScaleXSquared());
    }

    public float getScaleY() {
        return MathUtils.isZero(this.val[1]) && MathUtils.isZero(this.val[9]) ? Math.abs(this.val[5]) : (float)Math.sqrt(this.getScaleYSquared());
    }

    public float getScaleZ() {
        return MathUtils.isZero(this.val[2]) && MathUtils.isZero(this.val[6]) ? Math.abs(this.val[10]) : (float)Math.sqrt(this.getScaleZSquared());
    }

    public Vector3 getScale(Vector3 vector3) {
        return vector3.set(this.getScaleX(), this.getScaleY(), this.getScaleZ());
    }

    public Matrix4 toNormalMatrix() {
        this.val[12] = 0.0f;
        this.val[13] = 0.0f;
        this.val[14] = 0.0f;
        return this.inv().tra();
    }

    public String toString() {
        return "[" + this.val[0] + "|" + this.val[4] + "|" + this.val[8] + "|" + this.val[12] + "]\n[" + this.val[1] + "|" + this.val[5] + "|" + this.val[9] + "|" + this.val[13] + "]\n[" + this.val[2] + "|" + this.val[6] + "|" + this.val[10] + "|" + this.val[14] + "]\n[" + this.val[3] + "|" + this.val[7] + "|" + this.val[11] + "|" + this.val[15] + "]\n";
    }

    public static native void mulVec(float[] var0, float[] var1, int var2, int var3, int var4);

    public static native void prj(float[] var0, float[] var1, int var2, int var3, int var4);

    public static native void rot(float[] var0, float[] var1, int var2, int var3, int var4);

    public static void mul(float[] fArray, float[] fArray2) {
        float f2 = fArray[0] * fArray2[0] + fArray[4] * fArray2[1] + fArray[8] * fArray2[2] + fArray[12] * fArray2[3];
        float f3 = fArray[0] * fArray2[4] + fArray[4] * fArray2[5] + fArray[8] * fArray2[6] + fArray[12] * fArray2[7];
        float f4 = fArray[0] * fArray2[8] + fArray[4] * fArray2[9] + fArray[8] * fArray2[10] + fArray[12] * fArray2[11];
        float f5 = fArray[0] * fArray2[12] + fArray[4] * fArray2[13] + fArray[8] * fArray2[14] + fArray[12] * fArray2[15];
        float f6 = fArray[1] * fArray2[0] + fArray[5] * fArray2[1] + fArray[9] * fArray2[2] + fArray[13] * fArray2[3];
        float f7 = fArray[1] * fArray2[4] + fArray[5] * fArray2[5] + fArray[9] * fArray2[6] + fArray[13] * fArray2[7];
        float f8 = fArray[1] * fArray2[8] + fArray[5] * fArray2[9] + fArray[9] * fArray2[10] + fArray[13] * fArray2[11];
        float f9 = fArray[1] * fArray2[12] + fArray[5] * fArray2[13] + fArray[9] * fArray2[14] + fArray[13] * fArray2[15];
        float f10 = fArray[2] * fArray2[0] + fArray[6] * fArray2[1] + fArray[10] * fArray2[2] + fArray[14] * fArray2[3];
        float f11 = fArray[2] * fArray2[4] + fArray[6] * fArray2[5] + fArray[10] * fArray2[6] + fArray[14] * fArray2[7];
        float f12 = fArray[2] * fArray2[8] + fArray[6] * fArray2[9] + fArray[10] * fArray2[10] + fArray[14] * fArray2[11];
        float f13 = fArray[2] * fArray2[12] + fArray[6] * fArray2[13] + fArray[10] * fArray2[14] + fArray[14] * fArray2[15];
        float f14 = fArray[3] * fArray2[0] + fArray[7] * fArray2[1] + fArray[11] * fArray2[2] + fArray[15] * fArray2[3];
        float f15 = fArray[3] * fArray2[4] + fArray[7] * fArray2[5] + fArray[11] * fArray2[6] + fArray[15] * fArray2[7];
        float f16 = fArray[3] * fArray2[8] + fArray[7] * fArray2[9] + fArray[11] * fArray2[10] + fArray[15] * fArray2[11];
        float f17 = fArray[3] * fArray2[12] + fArray[7] * fArray2[13] + fArray[11] * fArray2[14] + fArray[15] * fArray2[15];
        fArray[0] = f2;
        fArray[1] = f6;
        fArray[2] = f10;
        fArray[3] = f14;
        fArray[4] = f3;
        fArray[5] = f7;
        fArray[6] = f11;
        fArray[7] = f15;
        fArray[8] = f4;
        fArray[9] = f8;
        fArray[10] = f12;
        fArray[11] = f16;
        fArray[12] = f5;
        fArray[13] = f9;
        fArray[14] = f13;
        fArray[15] = f17;
    }

    public static void mulVec(float[] fArray, float[] fArray2) {
        float f2 = fArray2[0] * fArray[0] + fArray2[1] * fArray[4] + fArray2[2] * fArray[8] + fArray[12];
        float f3 = fArray2[0] * fArray[1] + fArray2[1] * fArray[5] + fArray2[2] * fArray[9] + fArray[13];
        float f4 = fArray2[0] * fArray[2] + fArray2[1] * fArray[6] + fArray2[2] * fArray[10] + fArray[14];
        fArray2[0] = f2;
        fArray2[1] = f3;
        fArray2[2] = f4;
    }

    public static void prj(float[] fArray, float[] fArray2) {
        float f2 = 1.0f / (fArray2[0] * fArray[3] + fArray2[1] * fArray[7] + fArray2[2] * fArray[11] + fArray[15]);
        float f3 = (fArray2[0] * fArray[0] + fArray2[1] * fArray[4] + fArray2[2] * fArray[8] + fArray[12]) * f2;
        float f4 = (fArray2[0] * fArray[1] + fArray2[1] * fArray[5] + fArray2[2] * fArray[9] + fArray[13]) * f2;
        float f5 = (fArray2[0] * fArray[2] + fArray2[1] * fArray[6] + fArray2[2] * fArray[10] + fArray[14]) * f2;
        fArray2[0] = f3;
        fArray2[1] = f4;
        fArray2[2] = f5;
    }

    public static void rot(float[] fArray, float[] fArray2) {
        float f2 = fArray2[0] * fArray[0] + fArray2[1] * fArray[4] + fArray2[2] * fArray[8];
        float f3 = fArray2[0] * fArray[1] + fArray2[1] * fArray[5] + fArray2[2] * fArray[9];
        float f4 = fArray2[0] * fArray[2] + fArray2[1] * fArray[6] + fArray2[2] * fArray[10];
        fArray2[0] = f2;
        fArray2[1] = f3;
        fArray2[2] = f4;
    }

    public static boolean inv(float[] fArray) {
        float f2 = Matrix4.det(fArray);
        if (f2 == 0.0f) {
            return false;
        }
        float f3 = fArray[9] * fArray[14] * fArray[7] - fArray[13] * fArray[10] * fArray[7] + fArray[13] * fArray[6] * fArray[11] - fArray[5] * fArray[14] * fArray[11] - fArray[9] * fArray[6] * fArray[15] + fArray[5] * fArray[10] * fArray[15];
        float f4 = fArray[12] * fArray[10] * fArray[7] - fArray[8] * fArray[14] * fArray[7] - fArray[12] * fArray[6] * fArray[11] + fArray[4] * fArray[14] * fArray[11] + fArray[8] * fArray[6] * fArray[15] - fArray[4] * fArray[10] * fArray[15];
        float f5 = fArray[8] * fArray[13] * fArray[7] - fArray[12] * fArray[9] * fArray[7] + fArray[12] * fArray[5] * fArray[11] - fArray[4] * fArray[13] * fArray[11] - fArray[8] * fArray[5] * fArray[15] + fArray[4] * fArray[9] * fArray[15];
        float f6 = fArray[12] * fArray[9] * fArray[6] - fArray[8] * fArray[13] * fArray[6] - fArray[12] * fArray[5] * fArray[10] + fArray[4] * fArray[13] * fArray[10] + fArray[8] * fArray[5] * fArray[14] - fArray[4] * fArray[9] * fArray[14];
        float f7 = fArray[13] * fArray[10] * fArray[3] - fArray[9] * fArray[14] * fArray[3] - fArray[13] * fArray[2] * fArray[11] + fArray[1] * fArray[14] * fArray[11] + fArray[9] * fArray[2] * fArray[15] - fArray[1] * fArray[10] * fArray[15];
        float f8 = fArray[8] * fArray[14] * fArray[3] - fArray[12] * fArray[10] * fArray[3] + fArray[12] * fArray[2] * fArray[11] - fArray[0] * fArray[14] * fArray[11] - fArray[8] * fArray[2] * fArray[15] + fArray[0] * fArray[10] * fArray[15];
        float f9 = fArray[12] * fArray[9] * fArray[3] - fArray[8] * fArray[13] * fArray[3] - fArray[12] * fArray[1] * fArray[11] + fArray[0] * fArray[13] * fArray[11] + fArray[8] * fArray[1] * fArray[15] - fArray[0] * fArray[9] * fArray[15];
        float f10 = fArray[8] * fArray[13] * fArray[2] - fArray[12] * fArray[9] * fArray[2] + fArray[12] * fArray[1] * fArray[10] - fArray[0] * fArray[13] * fArray[10] - fArray[8] * fArray[1] * fArray[14] + fArray[0] * fArray[9] * fArray[14];
        float f11 = fArray[5] * fArray[14] * fArray[3] - fArray[13] * fArray[6] * fArray[3] + fArray[13] * fArray[2] * fArray[7] - fArray[1] * fArray[14] * fArray[7] - fArray[5] * fArray[2] * fArray[15] + fArray[1] * fArray[6] * fArray[15];
        float f12 = fArray[12] * fArray[6] * fArray[3] - fArray[4] * fArray[14] * fArray[3] - fArray[12] * fArray[2] * fArray[7] + fArray[0] * fArray[14] * fArray[7] + fArray[4] * fArray[2] * fArray[15] - fArray[0] * fArray[6] * fArray[15];
        float f13 = fArray[4] * fArray[13] * fArray[3] - fArray[12] * fArray[5] * fArray[3] + fArray[12] * fArray[1] * fArray[7] - fArray[0] * fArray[13] * fArray[7] - fArray[4] * fArray[1] * fArray[15] + fArray[0] * fArray[5] * fArray[15];
        float f14 = fArray[12] * fArray[5] * fArray[2] - fArray[4] * fArray[13] * fArray[2] - fArray[12] * fArray[1] * fArray[6] + fArray[0] * fArray[13] * fArray[6] + fArray[4] * fArray[1] * fArray[14] - fArray[0] * fArray[5] * fArray[14];
        float f15 = fArray[9] * fArray[6] * fArray[3] - fArray[5] * fArray[10] * fArray[3] - fArray[9] * fArray[2] * fArray[7] + fArray[1] * fArray[10] * fArray[7] + fArray[5] * fArray[2] * fArray[11] - fArray[1] * fArray[6] * fArray[11];
        float f16 = fArray[4] * fArray[10] * fArray[3] - fArray[8] * fArray[6] * fArray[3] + fArray[8] * fArray[2] * fArray[7] - fArray[0] * fArray[10] * fArray[7] - fArray[4] * fArray[2] * fArray[11] + fArray[0] * fArray[6] * fArray[11];
        float f17 = fArray[8] * fArray[5] * fArray[3] - fArray[4] * fArray[9] * fArray[3] - fArray[8] * fArray[1] * fArray[7] + fArray[0] * fArray[9] * fArray[7] + fArray[4] * fArray[1] * fArray[11] - fArray[0] * fArray[5] * fArray[11];
        float f18 = fArray[4] * fArray[9] * fArray[2] - fArray[8] * fArray[5] * fArray[2] + fArray[8] * fArray[1] * fArray[6] - fArray[0] * fArray[9] * fArray[6] - fArray[4] * fArray[1] * fArray[10] + fArray[0] * fArray[5] * fArray[10];
        float f19 = 1.0f / f2;
        fArray[0] = f3 * f19;
        fArray[1] = f7 * f19;
        fArray[2] = f11 * f19;
        fArray[3] = f15 * f19;
        fArray[4] = f4 * f19;
        fArray[5] = f8 * f19;
        fArray[6] = f12 * f19;
        fArray[7] = f16 * f19;
        fArray[8] = f5 * f19;
        fArray[9] = f9 * f19;
        fArray[10] = f13 * f19;
        fArray[11] = f17 * f19;
        fArray[12] = f6 * f19;
        fArray[13] = f10 * f19;
        fArray[14] = f14 * f19;
        fArray[15] = f18 * f19;
        return true;
    }

    public static float det(float[] fArray) {
        return fArray[3] * fArray[6] * fArray[9] * fArray[12] - fArray[2] * fArray[7] * fArray[9] * fArray[12] - fArray[3] * fArray[5] * fArray[10] * fArray[12] + fArray[1] * fArray[7] * fArray[10] * fArray[12] + fArray[2] * fArray[5] * fArray[11] * fArray[12] - fArray[1] * fArray[6] * fArray[11] * fArray[12] - fArray[3] * fArray[6] * fArray[8] * fArray[13] + fArray[2] * fArray[7] * fArray[8] * fArray[13] + fArray[3] * fArray[4] * fArray[10] * fArray[13] - fArray[0] * fArray[7] * fArray[10] * fArray[13] - fArray[2] * fArray[4] * fArray[11] * fArray[13] + fArray[0] * fArray[6] * fArray[11] * fArray[13] + fArray[3] * fArray[5] * fArray[8] * fArray[14] - fArray[1] * fArray[7] * fArray[8] * fArray[14] - fArray[3] * fArray[4] * fArray[9] * fArray[14] + fArray[0] * fArray[7] * fArray[9] * fArray[14] + fArray[1] * fArray[4] * fArray[11] * fArray[14] - fArray[0] * fArray[5] * fArray[11] * fArray[14] - fArray[2] * fArray[5] * fArray[8] * fArray[15] + fArray[1] * fArray[6] * fArray[8] * fArray[15] + fArray[2] * fArray[4] * fArray[9] * fArray[15] - fArray[0] * fArray[6] * fArray[9] * fArray[15] - fArray[1] * fArray[4] * fArray[10] * fArray[15] + fArray[0] * fArray[5] * fArray[10] * fArray[15];
    }

    public Matrix4 translate(Vector3 vector3) {
        return this.translate(vector3.x, vector3.y, vector3.z);
    }

    public Matrix4 translate(float f2, float f3, float f4) {
        this.val[12] = this.val[12] + (this.val[0] * f2 + this.val[4] * f3 + this.val[8] * f4);
        this.val[13] = this.val[13] + (this.val[1] * f2 + this.val[5] * f3 + this.val[9] * f4);
        this.val[14] = this.val[14] + (this.val[2] * f2 + this.val[6] * f3 + this.val[10] * f4);
        this.val[15] = this.val[15] + (this.val[3] * f2 + this.val[7] * f3 + this.val[11] * f4);
        return this;
    }

    public Matrix4 rotate(Vector3 vector3, float f2) {
        if (f2 == 0.0f) {
            return this;
        }
        quat.set(vector3, f2);
        return this.rotate(quat);
    }

    public Matrix4 rotateRad(Vector3 vector3, float f2) {
        if (f2 == 0.0f) {
            return this;
        }
        quat.setFromAxisRad(vector3, f2);
        return this.rotate(quat);
    }

    public Matrix4 rotate(float f2, float f3, float f4, float f5) {
        if (f5 == 0.0f) {
            return this;
        }
        quat.setFromAxis(f2, f3, f4, f5);
        return this.rotate(quat);
    }

    public Matrix4 rotateRad(float f2, float f3, float f4, float f5) {
        if (f5 == 0.0f) {
            return this;
        }
        quat.setFromAxisRad(f2, f3, f4, f5);
        return this.rotate(quat);
    }

    public Matrix4 rotate(Quaternion quaternion) {
        float f2 = quaternion.x;
        float f3 = quaternion.y;
        float f4 = quaternion.z;
        float f5 = quaternion.w;
        float f6 = f2 * f2;
        float f7 = f2 * f3;
        float f8 = f2 * f4;
        float f9 = f2 * f5;
        float f10 = f3 * f3;
        float f11 = f3 * f4;
        float f12 = f3 * f5;
        float f13 = f4 * f4;
        float f14 = f4 * f5;
        float f15 = 1.0f - 2.0f * (f10 + f13);
        float f16 = 2.0f * (f7 - f14);
        float f17 = 2.0f * (f8 + f12);
        float f18 = 2.0f * (f7 + f14);
        float f19 = 1.0f - 2.0f * (f6 + f13);
        float f20 = 2.0f * (f11 - f9);
        float f21 = 2.0f * (f8 - f12);
        float f22 = 2.0f * (f11 + f9);
        float f23 = 1.0f - 2.0f * (f6 + f10);
        float f24 = this.val[0] * f15 + this.val[4] * f18 + this.val[8] * f21;
        float f25 = this.val[0] * f16 + this.val[4] * f19 + this.val[8] * f22;
        float f26 = this.val[0] * f17 + this.val[4] * f20 + this.val[8] * f23;
        float f27 = this.val[1] * f15 + this.val[5] * f18 + this.val[9] * f21;
        float f28 = this.val[1] * f16 + this.val[5] * f19 + this.val[9] * f22;
        float f29 = this.val[1] * f17 + this.val[5] * f20 + this.val[9] * f23;
        float f30 = this.val[2] * f15 + this.val[6] * f18 + this.val[10] * f21;
        float f31 = this.val[2] * f16 + this.val[6] * f19 + this.val[10] * f22;
        float f32 = this.val[2] * f17 + this.val[6] * f20 + this.val[10] * f23;
        float f33 = this.val[3] * f15 + this.val[7] * f18 + this.val[11] * f21;
        float f34 = this.val[3] * f16 + this.val[7] * f19 + this.val[11] * f22;
        float f35 = this.val[3] * f17 + this.val[7] * f20 + this.val[11] * f23;
        this.val[0] = f24;
        this.val[1] = f27;
        this.val[2] = f30;
        this.val[3] = f33;
        this.val[4] = f25;
        this.val[5] = f28;
        this.val[6] = f31;
        this.val[7] = f34;
        this.val[8] = f26;
        this.val[9] = f29;
        this.val[10] = f32;
        this.val[11] = f35;
        return this;
    }

    public Matrix4 rotate(Vector3 vector3, Vector3 vector32) {
        return this.rotate(quat.setFromCross(vector3, vector32));
    }

    public Matrix4 rotateTowardDirection(Vector3 vector3, Vector3 vector32) {
        l_vez.set(vector3).nor();
        l_vex.set(vector3).crs(vector32).nor();
        l_vey.set(l_vex).crs(l_vez).nor();
        float f2 = this.val[0] * Matrix4.l_vex.x + this.val[4] * Matrix4.l_vex.y + this.val[8] * Matrix4.l_vex.z;
        float f3 = this.val[0] * Matrix4.l_vey.x + this.val[4] * Matrix4.l_vey.y + this.val[8] * Matrix4.l_vey.z;
        float f4 = this.val[0] * -Matrix4.l_vez.x + this.val[4] * -Matrix4.l_vez.y + this.val[8] * -Matrix4.l_vez.z;
        float f5 = this.val[1] * Matrix4.l_vex.x + this.val[5] * Matrix4.l_vex.y + this.val[9] * Matrix4.l_vex.z;
        float f6 = this.val[1] * Matrix4.l_vey.x + this.val[5] * Matrix4.l_vey.y + this.val[9] * Matrix4.l_vey.z;
        float f7 = this.val[1] * -Matrix4.l_vez.x + this.val[5] * -Matrix4.l_vez.y + this.val[9] * -Matrix4.l_vez.z;
        float f8 = this.val[2] * Matrix4.l_vex.x + this.val[6] * Matrix4.l_vex.y + this.val[10] * Matrix4.l_vex.z;
        float f9 = this.val[2] * Matrix4.l_vey.x + this.val[6] * Matrix4.l_vey.y + this.val[10] * Matrix4.l_vey.z;
        float f10 = this.val[2] * -Matrix4.l_vez.x + this.val[6] * -Matrix4.l_vez.y + this.val[10] * -Matrix4.l_vez.z;
        float f11 = this.val[3] * Matrix4.l_vex.x + this.val[7] * Matrix4.l_vex.y + this.val[11] * Matrix4.l_vex.z;
        float f12 = this.val[3] * Matrix4.l_vey.x + this.val[7] * Matrix4.l_vey.y + this.val[11] * Matrix4.l_vey.z;
        float f13 = this.val[3] * -Matrix4.l_vez.x + this.val[7] * -Matrix4.l_vez.y + this.val[11] * -Matrix4.l_vez.z;
        this.val[0] = f2;
        this.val[1] = f5;
        this.val[2] = f8;
        this.val[3] = f11;
        this.val[4] = f3;
        this.val[5] = f6;
        this.val[6] = f9;
        this.val[7] = f12;
        this.val[8] = f4;
        this.val[9] = f7;
        this.val[10] = f10;
        this.val[11] = f13;
        return this;
    }

    public Matrix4 rotateTowardTarget(Vector3 vector3, Vector3 vector32) {
        tmpVec.set(vector3.x - this.val[12], vector3.y - this.val[13], vector3.z - this.val[14]);
        return this.rotateTowardDirection(tmpVec, vector32);
    }

    public Matrix4 scale(float f2, float f3, float f4) {
        this.val[0] = this.val[0] * f2;
        this.val[4] = this.val[4] * f3;
        this.val[8] = this.val[8] * f4;
        this.val[1] = this.val[1] * f2;
        this.val[5] = this.val[5] * f3;
        this.val[9] = this.val[9] * f4;
        this.val[2] = this.val[2] * f2;
        this.val[6] = this.val[6] * f3;
        this.val[10] = this.val[10] * f4;
        this.val[3] = this.val[3] * f2;
        this.val[7] = this.val[7] * f3;
        this.val[11] = this.val[11] * f4;
        return this;
    }

    public void extract4x3Matrix(float[] fArray) {
        fArray[0] = this.val[0];
        fArray[1] = this.val[1];
        fArray[2] = this.val[2];
        fArray[3] = this.val[4];
        fArray[4] = this.val[5];
        fArray[5] = this.val[6];
        fArray[6] = this.val[8];
        fArray[7] = this.val[9];
        fArray[8] = this.val[10];
        fArray[9] = this.val[12];
        fArray[10] = this.val[13];
        fArray[11] = this.val[14];
    }

    public boolean hasRotationOrScaling() {
        return !MathUtils.isEqual(this.val[0], 1.0f) || !MathUtils.isEqual(this.val[5], 1.0f) || !MathUtils.isEqual(this.val[10], 1.0f) || !MathUtils.isZero(this.val[4]) || !MathUtils.isZero(this.val[8]) || !MathUtils.isZero(this.val[1]) || !MathUtils.isZero(this.val[9]) || !MathUtils.isZero(this.val[2]) || !MathUtils.isZero(this.val[6]);
    }
}

