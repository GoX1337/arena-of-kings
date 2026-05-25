/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.math;

import com.badlogic.gdx.math.Affine2;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.io.Serializable;

public class Matrix3
implements Serializable {
    private static final long serialVersionUID = 7907569533774959788L;
    public static final int M00 = 0;
    public static final int M01 = 3;
    public static final int M02 = 6;
    public static final int M10 = 1;
    public static final int M11 = 4;
    public static final int M12 = 7;
    public static final int M20 = 2;
    public static final int M21 = 5;
    public static final int M22 = 8;
    public float[] val = new float[9];
    private float[] tmp = new float[9];

    public Matrix3() {
        this.idt();
    }

    public Matrix3(Matrix3 matrix3) {
        this.set(matrix3);
    }

    public Matrix3(float[] fArray) {
        this.set(fArray);
    }

    public Matrix3 idt() {
        float[] fArray = this.val;
        fArray[0] = 1.0f;
        fArray[1] = 0.0f;
        fArray[2] = 0.0f;
        fArray[3] = 0.0f;
        fArray[4] = 1.0f;
        fArray[5] = 0.0f;
        fArray[6] = 0.0f;
        fArray[7] = 0.0f;
        fArray[8] = 1.0f;
        return this;
    }

    public Matrix3 mul(Matrix3 matrix3) {
        float[] fArray = this.val;
        float f2 = fArray[0] * matrix3.val[0] + fArray[3] * matrix3.val[1] + fArray[6] * matrix3.val[2];
        float f3 = fArray[0] * matrix3.val[3] + fArray[3] * matrix3.val[4] + fArray[6] * matrix3.val[5];
        float f4 = fArray[0] * matrix3.val[6] + fArray[3] * matrix3.val[7] + fArray[6] * matrix3.val[8];
        float f5 = fArray[1] * matrix3.val[0] + fArray[4] * matrix3.val[1] + fArray[7] * matrix3.val[2];
        float f6 = fArray[1] * matrix3.val[3] + fArray[4] * matrix3.val[4] + fArray[7] * matrix3.val[5];
        float f7 = fArray[1] * matrix3.val[6] + fArray[4] * matrix3.val[7] + fArray[7] * matrix3.val[8];
        float f8 = fArray[2] * matrix3.val[0] + fArray[5] * matrix3.val[1] + fArray[8] * matrix3.val[2];
        float f9 = fArray[2] * matrix3.val[3] + fArray[5] * matrix3.val[4] + fArray[8] * matrix3.val[5];
        float f10 = fArray[2] * matrix3.val[6] + fArray[5] * matrix3.val[7] + fArray[8] * matrix3.val[8];
        fArray[0] = f2;
        fArray[1] = f5;
        fArray[2] = f8;
        fArray[3] = f3;
        fArray[4] = f6;
        fArray[5] = f9;
        fArray[6] = f4;
        fArray[7] = f7;
        fArray[8] = f10;
        return this;
    }

    public Matrix3 mulLeft(Matrix3 matrix3) {
        float[] fArray = this.val;
        float f2 = matrix3.val[0] * fArray[0] + matrix3.val[3] * fArray[1] + matrix3.val[6] * fArray[2];
        float f3 = matrix3.val[0] * fArray[3] + matrix3.val[3] * fArray[4] + matrix3.val[6] * fArray[5];
        float f4 = matrix3.val[0] * fArray[6] + matrix3.val[3] * fArray[7] + matrix3.val[6] * fArray[8];
        float f5 = matrix3.val[1] * fArray[0] + matrix3.val[4] * fArray[1] + matrix3.val[7] * fArray[2];
        float f6 = matrix3.val[1] * fArray[3] + matrix3.val[4] * fArray[4] + matrix3.val[7] * fArray[5];
        float f7 = matrix3.val[1] * fArray[6] + matrix3.val[4] * fArray[7] + matrix3.val[7] * fArray[8];
        float f8 = matrix3.val[2] * fArray[0] + matrix3.val[5] * fArray[1] + matrix3.val[8] * fArray[2];
        float f9 = matrix3.val[2] * fArray[3] + matrix3.val[5] * fArray[4] + matrix3.val[8] * fArray[5];
        float f10 = matrix3.val[2] * fArray[6] + matrix3.val[5] * fArray[7] + matrix3.val[8] * fArray[8];
        fArray[0] = f2;
        fArray[1] = f5;
        fArray[2] = f8;
        fArray[3] = f3;
        fArray[4] = f6;
        fArray[5] = f9;
        fArray[6] = f4;
        fArray[7] = f7;
        fArray[8] = f10;
        return this;
    }

    public Matrix3 setToRotation(float f2) {
        return this.setToRotationRad((float)Math.PI / 180 * f2);
    }

    public Matrix3 setToRotationRad(float f2) {
        float f3 = (float)Math.cos(f2);
        float f4 = (float)Math.sin(f2);
        float[] fArray = this.val;
        fArray[0] = f3;
        fArray[1] = f4;
        fArray[2] = 0.0f;
        fArray[3] = -f4;
        fArray[4] = f3;
        fArray[5] = 0.0f;
        fArray[6] = 0.0f;
        fArray[7] = 0.0f;
        fArray[8] = 1.0f;
        return this;
    }

    public Matrix3 setToRotation(Vector3 vector3, float f2) {
        return this.setToRotation(vector3, MathUtils.cosDeg(f2), MathUtils.sinDeg(f2));
    }

    public Matrix3 setToRotation(Vector3 vector3, float f2, float f3) {
        float[] fArray = this.val;
        float f4 = 1.0f - f2;
        fArray[0] = f4 * vector3.x * vector3.x + f2;
        fArray[3] = f4 * vector3.x * vector3.y - vector3.z * f3;
        fArray[6] = f4 * vector3.z * vector3.x + vector3.y * f3;
        fArray[1] = f4 * vector3.x * vector3.y + vector3.z * f3;
        fArray[4] = f4 * vector3.y * vector3.y + f2;
        fArray[7] = f4 * vector3.y * vector3.z - vector3.x * f3;
        fArray[2] = f4 * vector3.z * vector3.x - vector3.y * f3;
        fArray[5] = f4 * vector3.y * vector3.z + vector3.x * f3;
        fArray[8] = f4 * vector3.z * vector3.z + f2;
        return this;
    }

    public Matrix3 setToTranslation(float f2, float f3) {
        float[] fArray = this.val;
        fArray[0] = 1.0f;
        fArray[1] = 0.0f;
        fArray[2] = 0.0f;
        fArray[3] = 0.0f;
        fArray[4] = 1.0f;
        fArray[5] = 0.0f;
        fArray[6] = f2;
        fArray[7] = f3;
        fArray[8] = 1.0f;
        return this;
    }

    public Matrix3 setToTranslation(Vector2 vector2) {
        float[] fArray = this.val;
        fArray[0] = 1.0f;
        fArray[1] = 0.0f;
        fArray[2] = 0.0f;
        fArray[3] = 0.0f;
        fArray[4] = 1.0f;
        fArray[5] = 0.0f;
        fArray[6] = vector2.x;
        fArray[7] = vector2.y;
        fArray[8] = 1.0f;
        return this;
    }

    public Matrix3 setToScaling(float f2, float f3) {
        float[] fArray = this.val;
        fArray[0] = f2;
        fArray[1] = 0.0f;
        fArray[2] = 0.0f;
        fArray[3] = 0.0f;
        fArray[4] = f3;
        fArray[5] = 0.0f;
        fArray[6] = 0.0f;
        fArray[7] = 0.0f;
        fArray[8] = 1.0f;
        return this;
    }

    public Matrix3 setToScaling(Vector2 vector2) {
        float[] fArray = this.val;
        fArray[0] = vector2.x;
        fArray[1] = 0.0f;
        fArray[2] = 0.0f;
        fArray[3] = 0.0f;
        fArray[4] = vector2.y;
        fArray[5] = 0.0f;
        fArray[6] = 0.0f;
        fArray[7] = 0.0f;
        fArray[8] = 1.0f;
        return this;
    }

    public String toString() {
        float[] fArray = this.val;
        return "[" + fArray[0] + "|" + fArray[3] + "|" + fArray[6] + "]\n[" + fArray[1] + "|" + fArray[4] + "|" + fArray[7] + "]\n[" + fArray[2] + "|" + fArray[5] + "|" + fArray[8] + "]";
    }

    public float det() {
        float[] fArray = this.val;
        return fArray[0] * fArray[4] * fArray[8] + fArray[3] * fArray[7] * fArray[2] + fArray[6] * fArray[1] * fArray[5] - fArray[0] * fArray[7] * fArray[5] - fArray[3] * fArray[1] * fArray[8] - fArray[6] * fArray[4] * fArray[2];
    }

    public Matrix3 inv() {
        float f2 = this.det();
        if (f2 == 0.0f) {
            throw new GdxRuntimeException("Can't invert a singular matrix");
        }
        float f3 = 1.0f / f2;
        float[] fArray = this.tmp;
        float[] fArray2 = this.val;
        fArray[0] = fArray2[4] * fArray2[8] - fArray2[5] * fArray2[7];
        fArray[1] = fArray2[2] * fArray2[7] - fArray2[1] * fArray2[8];
        fArray[2] = fArray2[1] * fArray2[5] - fArray2[2] * fArray2[4];
        fArray[3] = fArray2[5] * fArray2[6] - fArray2[3] * fArray2[8];
        fArray[4] = fArray2[0] * fArray2[8] - fArray2[2] * fArray2[6];
        fArray[5] = fArray2[2] * fArray2[3] - fArray2[0] * fArray2[5];
        fArray[6] = fArray2[3] * fArray2[7] - fArray2[4] * fArray2[6];
        fArray[7] = fArray2[1] * fArray2[6] - fArray2[0] * fArray2[7];
        fArray[8] = fArray2[0] * fArray2[4] - fArray2[1] * fArray2[3];
        fArray2[0] = f3 * fArray[0];
        fArray2[1] = f3 * fArray[1];
        fArray2[2] = f3 * fArray[2];
        fArray2[3] = f3 * fArray[3];
        fArray2[4] = f3 * fArray[4];
        fArray2[5] = f3 * fArray[5];
        fArray2[6] = f3 * fArray[6];
        fArray2[7] = f3 * fArray[7];
        fArray2[8] = f3 * fArray[8];
        return this;
    }

    public Matrix3 set(Matrix3 matrix3) {
        System.arraycopy(matrix3.val, 0, this.val, 0, this.val.length);
        return this;
    }

    public Matrix3 set(Affine2 affine2) {
        float[] fArray = this.val;
        fArray[0] = affine2.m00;
        fArray[1] = affine2.m10;
        fArray[2] = 0.0f;
        fArray[3] = affine2.m01;
        fArray[4] = affine2.m11;
        fArray[5] = 0.0f;
        fArray[6] = affine2.m02;
        fArray[7] = affine2.m12;
        fArray[8] = 1.0f;
        return this;
    }

    public Matrix3 set(Matrix4 matrix4) {
        float[] fArray = this.val;
        fArray[0] = matrix4.val[0];
        fArray[1] = matrix4.val[1];
        fArray[2] = matrix4.val[2];
        fArray[3] = matrix4.val[4];
        fArray[4] = matrix4.val[5];
        fArray[5] = matrix4.val[6];
        fArray[6] = matrix4.val[8];
        fArray[7] = matrix4.val[9];
        fArray[8] = matrix4.val[10];
        return this;
    }

    public Matrix3 set(float[] fArray) {
        System.arraycopy(fArray, 0, this.val, 0, this.val.length);
        return this;
    }

    public Matrix3 trn(Vector2 vector2) {
        this.val[6] = this.val[6] + vector2.x;
        this.val[7] = this.val[7] + vector2.y;
        return this;
    }

    public Matrix3 trn(float f2, float f3) {
        this.val[6] = this.val[6] + f2;
        this.val[7] = this.val[7] + f3;
        return this;
    }

    public Matrix3 trn(Vector3 vector3) {
        this.val[6] = this.val[6] + vector3.x;
        this.val[7] = this.val[7] + vector3.y;
        return this;
    }

    public Matrix3 translate(float f2, float f3) {
        float[] fArray = this.val;
        this.tmp[0] = 1.0f;
        this.tmp[1] = 0.0f;
        this.tmp[2] = 0.0f;
        this.tmp[3] = 0.0f;
        this.tmp[4] = 1.0f;
        this.tmp[5] = 0.0f;
        this.tmp[6] = f2;
        this.tmp[7] = f3;
        this.tmp[8] = 1.0f;
        Matrix3.mul(fArray, this.tmp);
        return this;
    }

    public Matrix3 translate(Vector2 vector2) {
        float[] fArray = this.val;
        this.tmp[0] = 1.0f;
        this.tmp[1] = 0.0f;
        this.tmp[2] = 0.0f;
        this.tmp[3] = 0.0f;
        this.tmp[4] = 1.0f;
        this.tmp[5] = 0.0f;
        this.tmp[6] = vector2.x;
        this.tmp[7] = vector2.y;
        this.tmp[8] = 1.0f;
        Matrix3.mul(fArray, this.tmp);
        return this;
    }

    public Matrix3 rotate(float f2) {
        return this.rotateRad((float)Math.PI / 180 * f2);
    }

    public Matrix3 rotateRad(float f2) {
        if (f2 == 0.0f) {
            return this;
        }
        float f3 = (float)Math.cos(f2);
        float f4 = (float)Math.sin(f2);
        float[] fArray = this.tmp;
        fArray[0] = f3;
        fArray[1] = f4;
        fArray[2] = 0.0f;
        fArray[3] = -f4;
        fArray[4] = f3;
        fArray[5] = 0.0f;
        fArray[6] = 0.0f;
        fArray[7] = 0.0f;
        fArray[8] = 1.0f;
        Matrix3.mul(this.val, fArray);
        return this;
    }

    public Matrix3 scale(float f2, float f3) {
        float[] fArray = this.tmp;
        fArray[0] = f2;
        fArray[1] = 0.0f;
        fArray[2] = 0.0f;
        fArray[3] = 0.0f;
        fArray[4] = f3;
        fArray[5] = 0.0f;
        fArray[6] = 0.0f;
        fArray[7] = 0.0f;
        fArray[8] = 1.0f;
        Matrix3.mul(this.val, fArray);
        return this;
    }

    public Matrix3 scale(Vector2 vector2) {
        float[] fArray = this.tmp;
        fArray[0] = vector2.x;
        fArray[1] = 0.0f;
        fArray[2] = 0.0f;
        fArray[3] = 0.0f;
        fArray[4] = vector2.y;
        fArray[5] = 0.0f;
        fArray[6] = 0.0f;
        fArray[7] = 0.0f;
        fArray[8] = 1.0f;
        Matrix3.mul(this.val, fArray);
        return this;
    }

    public float[] getValues() {
        return this.val;
    }

    public Vector2 getTranslation(Vector2 vector2) {
        vector2.x = this.val[6];
        vector2.y = this.val[7];
        return vector2;
    }

    public Vector2 getScale(Vector2 vector2) {
        float[] fArray = this.val;
        vector2.x = (float)Math.sqrt(fArray[0] * fArray[0] + fArray[3] * fArray[3]);
        vector2.y = (float)Math.sqrt(fArray[1] * fArray[1] + fArray[4] * fArray[4]);
        return vector2;
    }

    public float getRotation() {
        return 57.295776f * (float)Math.atan2(this.val[1], this.val[0]);
    }

    public float getRotationRad() {
        return (float)Math.atan2(this.val[1], this.val[0]);
    }

    public Matrix3 scl(float f2) {
        this.val[0] = this.val[0] * f2;
        this.val[4] = this.val[4] * f2;
        return this;
    }

    public Matrix3 scl(Vector2 vector2) {
        this.val[0] = this.val[0] * vector2.x;
        this.val[4] = this.val[4] * vector2.y;
        return this;
    }

    public Matrix3 scl(Vector3 vector3) {
        this.val[0] = this.val[0] * vector3.x;
        this.val[4] = this.val[4] * vector3.y;
        return this;
    }

    public Matrix3 transpose() {
        float[] fArray = this.val;
        float f2 = fArray[1];
        float f3 = fArray[2];
        float f4 = fArray[3];
        float f5 = fArray[5];
        float f6 = fArray[6];
        float f7 = fArray[7];
        fArray[3] = f2;
        fArray[6] = f3;
        fArray[1] = f4;
        fArray[7] = f5;
        fArray[2] = f6;
        fArray[5] = f7;
        return this;
    }

    private static void mul(float[] fArray, float[] fArray2) {
        float f2 = fArray[0] * fArray2[0] + fArray[3] * fArray2[1] + fArray[6] * fArray2[2];
        float f3 = fArray[0] * fArray2[3] + fArray[3] * fArray2[4] + fArray[6] * fArray2[5];
        float f4 = fArray[0] * fArray2[6] + fArray[3] * fArray2[7] + fArray[6] * fArray2[8];
        float f5 = fArray[1] * fArray2[0] + fArray[4] * fArray2[1] + fArray[7] * fArray2[2];
        float f6 = fArray[1] * fArray2[3] + fArray[4] * fArray2[4] + fArray[7] * fArray2[5];
        float f7 = fArray[1] * fArray2[6] + fArray[4] * fArray2[7] + fArray[7] * fArray2[8];
        float f8 = fArray[2] * fArray2[0] + fArray[5] * fArray2[1] + fArray[8] * fArray2[2];
        float f9 = fArray[2] * fArray2[3] + fArray[5] * fArray2[4] + fArray[8] * fArray2[5];
        float f10 = fArray[2] * fArray2[6] + fArray[5] * fArray2[7] + fArray[8] * fArray2[8];
        fArray[0] = f2;
        fArray[1] = f5;
        fArray[2] = f8;
        fArray[3] = f3;
        fArray[4] = f6;
        fArray[5] = f9;
        fArray[6] = f4;
        fArray[7] = f7;
        fArray[8] = f10;
    }
}

