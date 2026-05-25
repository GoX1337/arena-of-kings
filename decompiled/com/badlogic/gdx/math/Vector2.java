/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.math;

import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Matrix3;
import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.NumberUtils;
import java.io.Serializable;

public class Vector2
implements Vector<Vector2>,
Serializable {
    private static final long serialVersionUID = 913902788239530931L;
    public static final Vector2 X = new Vector2(1.0f, 0.0f);
    public static final Vector2 Y = new Vector2(0.0f, 1.0f);
    public static final Vector2 Zero = new Vector2(0.0f, 0.0f);
    public float x;
    public float y;

    public Vector2() {
    }

    public Vector2(float f2, float f3) {
        this.x = f2;
        this.y = f3;
    }

    public Vector2(Vector2 vector2) {
        this.set(vector2);
    }

    @Override
    public Vector2 cpy() {
        return new Vector2(this);
    }

    public static float len(float f2, float f3) {
        return (float)Math.sqrt(f2 * f2 + f3 * f3);
    }

    @Override
    public float len() {
        return (float)Math.sqrt(this.x * this.x + this.y * this.y);
    }

    public static float len2(float f2, float f3) {
        return f2 * f2 + f3 * f3;
    }

    @Override
    public float len2() {
        return this.x * this.x + this.y * this.y;
    }

    @Override
    public Vector2 set(Vector2 vector2) {
        this.x = vector2.x;
        this.y = vector2.y;
        return this;
    }

    public Vector2 set(float f2, float f3) {
        this.x = f2;
        this.y = f3;
        return this;
    }

    @Override
    public Vector2 sub(Vector2 vector2) {
        this.x -= vector2.x;
        this.y -= vector2.y;
        return this;
    }

    public Vector2 sub(float f2, float f3) {
        this.x -= f2;
        this.y -= f3;
        return this;
    }

    @Override
    public Vector2 nor() {
        float f2 = this.len();
        if (f2 != 0.0f) {
            this.x /= f2;
            this.y /= f2;
        }
        return this;
    }

    @Override
    public Vector2 add(Vector2 vector2) {
        this.x += vector2.x;
        this.y += vector2.y;
        return this;
    }

    public Vector2 add(float f2, float f3) {
        this.x += f2;
        this.y += f3;
        return this;
    }

    public static float dot(float f2, float f3, float f4, float f5) {
        return f2 * f4 + f3 * f5;
    }

    @Override
    public float dot(Vector2 vector2) {
        return this.x * vector2.x + this.y * vector2.y;
    }

    public float dot(float f2, float f3) {
        return this.x * f2 + this.y * f3;
    }

    @Override
    public Vector2 scl(float f2) {
        this.x *= f2;
        this.y *= f2;
        return this;
    }

    public Vector2 scl(float f2, float f3) {
        this.x *= f2;
        this.y *= f3;
        return this;
    }

    @Override
    public Vector2 scl(Vector2 vector2) {
        this.x *= vector2.x;
        this.y *= vector2.y;
        return this;
    }

    @Override
    public Vector2 mulAdd(Vector2 vector2, float f2) {
        this.x += vector2.x * f2;
        this.y += vector2.y * f2;
        return this;
    }

    @Override
    public Vector2 mulAdd(Vector2 vector2, Vector2 vector22) {
        this.x += vector2.x * vector22.x;
        this.y += vector2.y * vector22.y;
        return this;
    }

    public static float dst(float f2, float f3, float f4, float f5) {
        float f6 = f4 - f2;
        float f7 = f5 - f3;
        return (float)Math.sqrt(f6 * f6 + f7 * f7);
    }

    @Override
    public float dst(Vector2 vector2) {
        float f2 = vector2.x - this.x;
        float f3 = vector2.y - this.y;
        return (float)Math.sqrt(f2 * f2 + f3 * f3);
    }

    public float dst(float f2, float f3) {
        float f4 = f2 - this.x;
        float f5 = f3 - this.y;
        return (float)Math.sqrt(f4 * f4 + f5 * f5);
    }

    public static float dst2(float f2, float f3, float f4, float f5) {
        float f6 = f4 - f2;
        float f7 = f5 - f3;
        return f6 * f6 + f7 * f7;
    }

    @Override
    public float dst2(Vector2 vector2) {
        float f2 = vector2.x - this.x;
        float f3 = vector2.y - this.y;
        return f2 * f2 + f3 * f3;
    }

    public float dst2(float f2, float f3) {
        float f4 = f2 - this.x;
        float f5 = f3 - this.y;
        return f4 * f4 + f5 * f5;
    }

    @Override
    public Vector2 limit(float f2) {
        return this.limit2(f2 * f2);
    }

    @Override
    public Vector2 limit2(float f2) {
        float f3 = this.len2();
        if (f3 > f2) {
            return this.scl((float)Math.sqrt(f2 / f3));
        }
        return this;
    }

    @Override
    public Vector2 clamp(float f2, float f3) {
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

    @Override
    public Vector2 setLength(float f2) {
        return this.setLength2(f2 * f2);
    }

    @Override
    public Vector2 setLength2(float f2) {
        float f3 = this.len2();
        return f3 == 0.0f || f3 == f2 ? this : this.scl((float)Math.sqrt(f2 / f3));
    }

    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }

    public Vector2 fromString(String string) {
        int n2 = string.indexOf(44, 1);
        if (n2 != -1 && string.charAt(0) == '(' && string.charAt(string.length() - 1) == ')') {
            try {
                float f2 = Float.parseFloat(string.substring(1, n2));
                float f3 = Float.parseFloat(string.substring(n2 + 1, string.length() - 1));
                return this.set(f2, f3);
            }
            catch (NumberFormatException numberFormatException) {
                // empty catch block
            }
        }
        throw new GdxRuntimeException("Malformed Vector2: " + string);
    }

    public Vector2 mul(Matrix3 matrix3) {
        float f2 = this.x * matrix3.val[0] + this.y * matrix3.val[3] + matrix3.val[6];
        float f3 = this.x * matrix3.val[1] + this.y * matrix3.val[4] + matrix3.val[7];
        this.x = f2;
        this.y = f3;
        return this;
    }

    public float crs(Vector2 vector2) {
        return this.x * vector2.y - this.y * vector2.x;
    }

    public float crs(float f2, float f3) {
        return this.x * f3 - this.y * f2;
    }

    @Deprecated
    public float angle() {
        float f2 = (float)Math.atan2(this.y, this.x) * 57.295776f;
        if (f2 < 0.0f) {
            f2 += 360.0f;
        }
        return f2;
    }

    @Deprecated
    public float angle(Vector2 vector2) {
        return (float)Math.atan2(this.crs(vector2), this.dot(vector2)) * 57.295776f;
    }

    public float angleDeg() {
        float f2 = (float)Math.atan2(this.y, this.x) * 57.295776f;
        if (f2 < 0.0f) {
            f2 += 360.0f;
        }
        return f2;
    }

    public float angleDeg(Vector2 vector2) {
        float f2 = (float)Math.atan2(vector2.crs(this), vector2.dot(this)) * 57.295776f;
        if (f2 < 0.0f) {
            f2 += 360.0f;
        }
        return f2;
    }

    public float angleRad() {
        return (float)Math.atan2(this.y, this.x);
    }

    public float angleRad(Vector2 vector2) {
        return (float)Math.atan2(vector2.crs(this), vector2.dot(this));
    }

    @Deprecated
    public Vector2 setAngle(float f2) {
        return this.setAngleRad(f2 * ((float)Math.PI / 180));
    }

    public Vector2 setAngleDeg(float f2) {
        return this.setAngleRad(f2 * ((float)Math.PI / 180));
    }

    public Vector2 setAngleRad(float f2) {
        this.set(this.len(), 0.0f);
        this.rotateRad(f2);
        return this;
    }

    @Deprecated
    public Vector2 rotate(float f2) {
        return this.rotateRad(f2 * ((float)Math.PI / 180));
    }

    @Deprecated
    public Vector2 rotateAround(Vector2 vector2, float f2) {
        return this.sub(vector2).rotateDeg(f2).add(vector2);
    }

    public Vector2 rotateDeg(float f2) {
        return this.rotateRad(f2 * ((float)Math.PI / 180));
    }

    public Vector2 rotateRad(float f2) {
        float f3 = (float)Math.cos(f2);
        float f4 = (float)Math.sin(f2);
        float f5 = this.x * f3 - this.y * f4;
        float f6 = this.x * f4 + this.y * f3;
        this.x = f5;
        this.y = f6;
        return this;
    }

    public Vector2 rotateAroundDeg(Vector2 vector2, float f2) {
        return this.sub(vector2).rotateDeg(f2).add(vector2);
    }

    public Vector2 rotateAroundRad(Vector2 vector2, float f2) {
        return this.sub(vector2).rotateRad(f2).add(vector2);
    }

    public Vector2 rotate90(int n2) {
        float f2 = this.x;
        if (n2 >= 0) {
            this.x = -this.y;
            this.y = f2;
        } else {
            this.x = this.y;
            this.y = -f2;
        }
        return this;
    }

    @Override
    public Vector2 lerp(Vector2 vector2, float f2) {
        float f3 = 1.0f - f2;
        this.x = this.x * f3 + vector2.x * f2;
        this.y = this.y * f3 + vector2.y * f2;
        return this;
    }

    @Override
    public Vector2 interpolate(Vector2 vector2, float f2, Interpolation interpolation) {
        return this.lerp(vector2, interpolation.apply(f2));
    }

    @Override
    public Vector2 setToRandomDirection() {
        float f2 = MathUtils.random(0.0f, (float)Math.PI * 2);
        return this.set(MathUtils.cos(f2), MathUtils.sin(f2));
    }

    public int hashCode() {
        int n2 = 31;
        int n3 = 1;
        n3 = 31 * n3 + NumberUtils.floatToIntBits(this.x);
        n3 = 31 * n3 + NumberUtils.floatToIntBits(this.y);
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
        Vector2 vector2 = (Vector2)object;
        if (NumberUtils.floatToIntBits(this.x) != NumberUtils.floatToIntBits(vector2.x)) {
            return false;
        }
        return NumberUtils.floatToIntBits(this.y) == NumberUtils.floatToIntBits(vector2.y);
    }

    @Override
    public boolean epsilonEquals(Vector2 vector2, float f2) {
        if (vector2 == null) {
            return false;
        }
        if (Math.abs(vector2.x - this.x) > f2) {
            return false;
        }
        return !(Math.abs(vector2.y - this.y) > f2);
    }

    public boolean epsilonEquals(float f2, float f3, float f4) {
        if (Math.abs(f2 - this.x) > f4) {
            return false;
        }
        return !(Math.abs(f3 - this.y) > f4);
    }

    public boolean epsilonEquals(Vector2 vector2) {
        return this.epsilonEquals(vector2, 1.0E-6f);
    }

    @Override
    public boolean epsilonEquals(float f2, float f3) {
        return this.epsilonEquals(f2, f3, 1.0E-6f);
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
        return this.x == 0.0f && this.y == 0.0f;
    }

    @Override
    public boolean isZero(float f2) {
        return this.len2() < f2;
    }

    @Override
    public boolean isOnLine(Vector2 vector2) {
        return MathUtils.isZero(this.x * vector2.y - this.y * vector2.x);
    }

    @Override
    public boolean isOnLine(Vector2 vector2, float f2) {
        return MathUtils.isZero(this.x * vector2.y - this.y * vector2.x, f2);
    }

    @Override
    public boolean isCollinear(Vector2 vector2, float f2) {
        return this.isOnLine(vector2, f2) && this.dot(vector2) > 0.0f;
    }

    @Override
    public boolean isCollinear(Vector2 vector2) {
        return this.isOnLine(vector2) && this.dot(vector2) > 0.0f;
    }

    @Override
    public boolean isCollinearOpposite(Vector2 vector2, float f2) {
        return this.isOnLine(vector2, f2) && this.dot(vector2) < 0.0f;
    }

    @Override
    public boolean isCollinearOpposite(Vector2 vector2) {
        return this.isOnLine(vector2) && this.dot(vector2) < 0.0f;
    }

    @Override
    public boolean isPerpendicular(Vector2 vector2) {
        return MathUtils.isZero(this.dot(vector2));
    }

    @Override
    public boolean isPerpendicular(Vector2 vector2, float f2) {
        return MathUtils.isZero(this.dot(vector2), f2);
    }

    @Override
    public boolean hasSameDirection(Vector2 vector2) {
        return this.dot(vector2) > 0.0f;
    }

    @Override
    public boolean hasOppositeDirection(Vector2 vector2) {
        return this.dot(vector2) < 0.0f;
    }

    @Override
    public Vector2 setZero() {
        this.x = 0.0f;
        this.y = 0.0f;
        return this;
    }
}

