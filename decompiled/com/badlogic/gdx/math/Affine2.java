/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.math;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Matrix3;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.io.Serializable;

public final class Affine2
implements Serializable {
    private static final long serialVersionUID = 1524569123485049187L;
    public float m00 = 1.0f;
    public float m01 = 0.0f;
    public float m02 = 0.0f;
    public float m10 = 0.0f;
    public float m11 = 1.0f;
    public float m12 = 0.0f;

    public Affine2() {
    }

    public Affine2(Affine2 affine2) {
        this.set(affine2);
    }

    public Affine2 idt() {
        this.m00 = 1.0f;
        this.m01 = 0.0f;
        this.m02 = 0.0f;
        this.m10 = 0.0f;
        this.m11 = 1.0f;
        this.m12 = 0.0f;
        return this;
    }

    public Affine2 set(Affine2 affine2) {
        this.m00 = affine2.m00;
        this.m01 = affine2.m01;
        this.m02 = affine2.m02;
        this.m10 = affine2.m10;
        this.m11 = affine2.m11;
        this.m12 = affine2.m12;
        return this;
    }

    public Affine2 set(Matrix3 matrix3) {
        float[] fArray = matrix3.val;
        this.m00 = fArray[0];
        this.m01 = fArray[3];
        this.m02 = fArray[6];
        this.m10 = fArray[1];
        this.m11 = fArray[4];
        this.m12 = fArray[7];
        return this;
    }

    public Affine2 set(Matrix4 matrix4) {
        float[] fArray = matrix4.val;
        this.m00 = fArray[0];
        this.m01 = fArray[4];
        this.m02 = fArray[12];
        this.m10 = fArray[1];
        this.m11 = fArray[5];
        this.m12 = fArray[13];
        return this;
    }

    public Affine2 setToTranslation(float f2, float f3) {
        this.m00 = 1.0f;
        this.m01 = 0.0f;
        this.m02 = f2;
        this.m10 = 0.0f;
        this.m11 = 1.0f;
        this.m12 = f3;
        return this;
    }

    public Affine2 setToTranslation(Vector2 vector2) {
        return this.setToTranslation(vector2.x, vector2.y);
    }

    public Affine2 setToScaling(float f2, float f3) {
        this.m00 = f2;
        this.m01 = 0.0f;
        this.m02 = 0.0f;
        this.m10 = 0.0f;
        this.m11 = f3;
        this.m12 = 0.0f;
        return this;
    }

    public Affine2 setToScaling(Vector2 vector2) {
        return this.setToScaling(vector2.x, vector2.y);
    }

    public Affine2 setToRotation(float f2) {
        float f3 = MathUtils.cosDeg(f2);
        float f4 = MathUtils.sinDeg(f2);
        this.m00 = f3;
        this.m01 = -f4;
        this.m02 = 0.0f;
        this.m10 = f4;
        this.m11 = f3;
        this.m12 = 0.0f;
        return this;
    }

    public Affine2 setToRotationRad(float f2) {
        float f3 = MathUtils.cos(f2);
        float f4 = MathUtils.sin(f2);
        this.m00 = f3;
        this.m01 = -f4;
        this.m02 = 0.0f;
        this.m10 = f4;
        this.m11 = f3;
        this.m12 = 0.0f;
        return this;
    }

    public Affine2 setToRotation(float f2, float f3) {
        this.m00 = f2;
        this.m01 = -f3;
        this.m02 = 0.0f;
        this.m10 = f3;
        this.m11 = f2;
        this.m12 = 0.0f;
        return this;
    }

    public Affine2 setToShearing(float f2, float f3) {
        this.m00 = 1.0f;
        this.m01 = f2;
        this.m02 = 0.0f;
        this.m10 = f3;
        this.m11 = 1.0f;
        this.m12 = 0.0f;
        return this;
    }

    public Affine2 setToShearing(Vector2 vector2) {
        return this.setToShearing(vector2.x, vector2.y);
    }

    public Affine2 setToTrnRotScl(float f2, float f3, float f4, float f5, float f6) {
        this.m02 = f2;
        this.m12 = f3;
        if (f4 == 0.0f) {
            this.m00 = f5;
            this.m01 = 0.0f;
            this.m10 = 0.0f;
            this.m11 = f6;
        } else {
            float f7 = MathUtils.sinDeg(f4);
            float f8 = MathUtils.cosDeg(f4);
            this.m00 = f8 * f5;
            this.m01 = -f7 * f6;
            this.m10 = f7 * f5;
            this.m11 = f8 * f6;
        }
        return this;
    }

    public Affine2 setToTrnRotScl(Vector2 vector2, float f2, Vector2 vector22) {
        return this.setToTrnRotScl(vector2.x, vector2.y, f2, vector22.x, vector22.y);
    }

    public Affine2 setToTrnRotRadScl(float f2, float f3, float f4, float f5, float f6) {
        this.m02 = f2;
        this.m12 = f3;
        if (f4 == 0.0f) {
            this.m00 = f5;
            this.m01 = 0.0f;
            this.m10 = 0.0f;
            this.m11 = f6;
        } else {
            float f7 = MathUtils.sin(f4);
            float f8 = MathUtils.cos(f4);
            this.m00 = f8 * f5;
            this.m01 = -f7 * f6;
            this.m10 = f7 * f5;
            this.m11 = f8 * f6;
        }
        return this;
    }

    public Affine2 setToTrnRotRadScl(Vector2 vector2, float f2, Vector2 vector22) {
        return this.setToTrnRotRadScl(vector2.x, vector2.y, f2, vector22.x, vector22.y);
    }

    public Affine2 setToTrnScl(float f2, float f3, float f4, float f5) {
        this.m00 = f4;
        this.m01 = 0.0f;
        this.m02 = f2;
        this.m10 = 0.0f;
        this.m11 = f5;
        this.m12 = f3;
        return this;
    }

    public Affine2 setToTrnScl(Vector2 vector2, Vector2 vector22) {
        return this.setToTrnScl(vector2.x, vector2.y, vector22.x, vector22.y);
    }

    public Affine2 setToProduct(Affine2 affine2, Affine2 affine22) {
        this.m00 = affine2.m00 * affine22.m00 + affine2.m01 * affine22.m10;
        this.m01 = affine2.m00 * affine22.m01 + affine2.m01 * affine22.m11;
        this.m02 = affine2.m00 * affine22.m02 + affine2.m01 * affine22.m12 + affine2.m02;
        this.m10 = affine2.m10 * affine22.m00 + affine2.m11 * affine22.m10;
        this.m11 = affine2.m10 * affine22.m01 + affine2.m11 * affine22.m11;
        this.m12 = affine2.m10 * affine22.m02 + affine2.m11 * affine22.m12 + affine2.m12;
        return this;
    }

    public Affine2 inv() {
        float f2 = this.det();
        if (f2 == 0.0f) {
            throw new GdxRuntimeException("Can't invert a singular affine matrix");
        }
        float f3 = 1.0f / f2;
        float f4 = this.m11;
        float f5 = -this.m01;
        float f6 = this.m01 * this.m12 - this.m11 * this.m02;
        float f7 = -this.m10;
        float f8 = this.m00;
        float f9 = this.m10 * this.m02 - this.m00 * this.m12;
        this.m00 = f3 * f4;
        this.m01 = f3 * f5;
        this.m02 = f3 * f6;
        this.m10 = f3 * f7;
        this.m11 = f3 * f8;
        this.m12 = f3 * f9;
        return this;
    }

    public Affine2 mul(Affine2 affine2) {
        float f2 = this.m00 * affine2.m00 + this.m01 * affine2.m10;
        float f3 = this.m00 * affine2.m01 + this.m01 * affine2.m11;
        float f4 = this.m00 * affine2.m02 + this.m01 * affine2.m12 + this.m02;
        float f5 = this.m10 * affine2.m00 + this.m11 * affine2.m10;
        float f6 = this.m10 * affine2.m01 + this.m11 * affine2.m11;
        float f7 = this.m10 * affine2.m02 + this.m11 * affine2.m12 + this.m12;
        this.m00 = f2;
        this.m01 = f3;
        this.m02 = f4;
        this.m10 = f5;
        this.m11 = f6;
        this.m12 = f7;
        return this;
    }

    public Affine2 preMul(Affine2 affine2) {
        float f2 = affine2.m00 * this.m00 + affine2.m01 * this.m10;
        float f3 = affine2.m00 * this.m01 + affine2.m01 * this.m11;
        float f4 = affine2.m00 * this.m02 + affine2.m01 * this.m12 + affine2.m02;
        float f5 = affine2.m10 * this.m00 + affine2.m11 * this.m10;
        float f6 = affine2.m10 * this.m01 + affine2.m11 * this.m11;
        float f7 = affine2.m10 * this.m02 + affine2.m11 * this.m12 + affine2.m12;
        this.m00 = f2;
        this.m01 = f3;
        this.m02 = f4;
        this.m10 = f5;
        this.m11 = f6;
        this.m12 = f7;
        return this;
    }

    public Affine2 translate(float f2, float f3) {
        this.m02 += this.m00 * f2 + this.m01 * f3;
        this.m12 += this.m10 * f2 + this.m11 * f3;
        return this;
    }

    public Affine2 translate(Vector2 vector2) {
        return this.translate(vector2.x, vector2.y);
    }

    public Affine2 preTranslate(float f2, float f3) {
        this.m02 += f2;
        this.m12 += f3;
        return this;
    }

    public Affine2 preTranslate(Vector2 vector2) {
        return this.preTranslate(vector2.x, vector2.y);
    }

    public Affine2 scale(float f2, float f3) {
        this.m00 *= f2;
        this.m01 *= f3;
        this.m10 *= f2;
        this.m11 *= f3;
        return this;
    }

    public Affine2 scale(Vector2 vector2) {
        return this.scale(vector2.x, vector2.y);
    }

    public Affine2 preScale(float f2, float f3) {
        this.m00 *= f2;
        this.m01 *= f2;
        this.m02 *= f2;
        this.m10 *= f3;
        this.m11 *= f3;
        this.m12 *= f3;
        return this;
    }

    public Affine2 preScale(Vector2 vector2) {
        return this.preScale(vector2.x, vector2.y);
    }

    public Affine2 rotate(float f2) {
        if (f2 == 0.0f) {
            return this;
        }
        float f3 = MathUtils.cosDeg(f2);
        float f4 = MathUtils.sinDeg(f2);
        float f5 = this.m00 * f3 + this.m01 * f4;
        float f6 = this.m00 * -f4 + this.m01 * f3;
        float f7 = this.m10 * f3 + this.m11 * f4;
        float f8 = this.m10 * -f4 + this.m11 * f3;
        this.m00 = f5;
        this.m01 = f6;
        this.m10 = f7;
        this.m11 = f8;
        return this;
    }

    public Affine2 rotateRad(float f2) {
        if (f2 == 0.0f) {
            return this;
        }
        float f3 = MathUtils.cos(f2);
        float f4 = MathUtils.sin(f2);
        float f5 = this.m00 * f3 + this.m01 * f4;
        float f6 = this.m00 * -f4 + this.m01 * f3;
        float f7 = this.m10 * f3 + this.m11 * f4;
        float f8 = this.m10 * -f4 + this.m11 * f3;
        this.m00 = f5;
        this.m01 = f6;
        this.m10 = f7;
        this.m11 = f8;
        return this;
    }

    public Affine2 preRotate(float f2) {
        if (f2 == 0.0f) {
            return this;
        }
        float f3 = MathUtils.cosDeg(f2);
        float f4 = MathUtils.sinDeg(f2);
        float f5 = f3 * this.m00 - f4 * this.m10;
        float f6 = f3 * this.m01 - f4 * this.m11;
        float f7 = f3 * this.m02 - f4 * this.m12;
        float f8 = f4 * this.m00 + f3 * this.m10;
        float f9 = f4 * this.m01 + f3 * this.m11;
        float f10 = f4 * this.m02 + f3 * this.m12;
        this.m00 = f5;
        this.m01 = f6;
        this.m02 = f7;
        this.m10 = f8;
        this.m11 = f9;
        this.m12 = f10;
        return this;
    }

    public Affine2 preRotateRad(float f2) {
        if (f2 == 0.0f) {
            return this;
        }
        float f3 = MathUtils.cos(f2);
        float f4 = MathUtils.sin(f2);
        float f5 = f3 * this.m00 - f4 * this.m10;
        float f6 = f3 * this.m01 - f4 * this.m11;
        float f7 = f3 * this.m02 - f4 * this.m12;
        float f8 = f4 * this.m00 + f3 * this.m10;
        float f9 = f4 * this.m01 + f3 * this.m11;
        float f10 = f4 * this.m02 + f3 * this.m12;
        this.m00 = f5;
        this.m01 = f6;
        this.m02 = f7;
        this.m10 = f8;
        this.m11 = f9;
        this.m12 = f10;
        return this;
    }

    public Affine2 shear(float f2, float f3) {
        float f4 = this.m00 + f3 * this.m01;
        float f5 = this.m01 + f2 * this.m00;
        this.m00 = f4;
        this.m01 = f5;
        f4 = this.m10 + f3 * this.m11;
        f5 = this.m11 + f2 * this.m10;
        this.m10 = f4;
        this.m11 = f5;
        return this;
    }

    public Affine2 shear(Vector2 vector2) {
        return this.shear(vector2.x, vector2.y);
    }

    public Affine2 preShear(float f2, float f3) {
        float f4 = this.m00 + f2 * this.m10;
        float f5 = this.m01 + f2 * this.m11;
        float f6 = this.m02 + f2 * this.m12;
        float f7 = this.m10 + f3 * this.m00;
        float f8 = this.m11 + f3 * this.m01;
        float f9 = this.m12 + f3 * this.m02;
        this.m00 = f4;
        this.m01 = f5;
        this.m02 = f6;
        this.m10 = f7;
        this.m11 = f8;
        this.m12 = f9;
        return this;
    }

    public Affine2 preShear(Vector2 vector2) {
        return this.preShear(vector2.x, vector2.y);
    }

    public float det() {
        return this.m00 * this.m11 - this.m01 * this.m10;
    }

    public Vector2 getTranslation(Vector2 vector2) {
        vector2.x = this.m02;
        vector2.y = this.m12;
        return vector2;
    }

    public boolean isTranslation() {
        return this.m00 == 1.0f && this.m11 == 1.0f && this.m01 == 0.0f && this.m10 == 0.0f;
    }

    public boolean isIdt() {
        return this.m00 == 1.0f && this.m02 == 0.0f && this.m12 == 0.0f && this.m11 == 1.0f && this.m01 == 0.0f && this.m10 == 0.0f;
    }

    public void applyTo(Vector2 vector2) {
        float f2 = vector2.x;
        float f3 = vector2.y;
        vector2.x = this.m00 * f2 + this.m01 * f3 + this.m02;
        vector2.y = this.m10 * f2 + this.m11 * f3 + this.m12;
    }

    public String toString() {
        return "[" + this.m00 + "|" + this.m01 + "|" + this.m02 + "]\n[" + this.m10 + "|" + this.m11 + "|" + this.m12 + "]\n[0.0|0.0|0.1]";
    }
}

