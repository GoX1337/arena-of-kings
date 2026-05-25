/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.environment;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g3d.environment.BaseLight;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;

public class SpotLight
extends BaseLight<SpotLight> {
    public final Vector3 position = new Vector3();
    public final Vector3 direction = new Vector3();
    public float intensity;
    public float cutoffAngle;
    public float exponent;

    public SpotLight setPosition(float f2, float f3, float f4) {
        this.position.set(f2, f3, f4);
        return this;
    }

    public SpotLight setPosition(Vector3 vector3) {
        this.position.set(vector3);
        return this;
    }

    public SpotLight setDirection(float f2, float f3, float f4) {
        this.direction.set(f2, f3, f4);
        return this;
    }

    public SpotLight setDirection(Vector3 vector3) {
        this.direction.set(vector3);
        return this;
    }

    public SpotLight setIntensity(float f2) {
        this.intensity = f2;
        return this;
    }

    public SpotLight setCutoffAngle(float f2) {
        this.cutoffAngle = f2;
        return this;
    }

    public SpotLight setExponent(float f2) {
        this.exponent = f2;
        return this;
    }

    public SpotLight set(SpotLight spotLight) {
        return this.set(spotLight.color, spotLight.position, spotLight.direction, spotLight.intensity, spotLight.cutoffAngle, spotLight.exponent);
    }

    public SpotLight set(Color color, Vector3 vector3, Vector3 vector32, float f2, float f3, float f4) {
        if (color != null) {
            this.color.set(color);
        }
        if (vector3 != null) {
            this.position.set(vector3);
        }
        if (vector32 != null) {
            this.direction.set(vector32).nor();
        }
        this.intensity = f2;
        this.cutoffAngle = f3;
        this.exponent = f4;
        return this;
    }

    public SpotLight set(float f2, float f3, float f4, Vector3 vector3, Vector3 vector32, float f5, float f6, float f7) {
        this.color.set(f2, f3, f4, 1.0f);
        if (vector3 != null) {
            this.position.set(vector3);
        }
        if (vector32 != null) {
            this.direction.set(vector32).nor();
        }
        this.intensity = f5;
        this.cutoffAngle = f6;
        this.exponent = f7;
        return this;
    }

    public SpotLight set(Color color, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        if (color != null) {
            this.color.set(color);
        }
        this.position.set(f2, f3, f4);
        this.direction.set(f5, f6, f7).nor();
        this.intensity = f8;
        this.cutoffAngle = f9;
        this.exponent = f10;
        return this;
    }

    public SpotLight set(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13) {
        this.color.set(f2, f3, f4, 1.0f);
        this.position.set(f5, f6, f7);
        this.direction.set(f8, f9, f10).nor();
        this.intensity = f11;
        this.cutoffAngle = f12;
        this.exponent = f13;
        return this;
    }

    public SpotLight setTarget(Vector3 vector3) {
        this.direction.set(vector3).sub(this.position).nor();
        return this;
    }

    public boolean equals(Object object) {
        return object instanceof SpotLight && this.equals((SpotLight)object);
    }

    public boolean equals(SpotLight spotLight) {
        return spotLight != null && (spotLight == this || this.color.equals(spotLight.color) && this.position.equals(spotLight.position) && this.direction.equals(spotLight.direction) && MathUtils.isEqual(this.intensity, spotLight.intensity) && MathUtils.isEqual(this.cutoffAngle, spotLight.cutoffAngle) && MathUtils.isEqual(this.exponent, spotLight.exponent));
    }
}

