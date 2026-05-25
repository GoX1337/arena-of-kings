/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.environment;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g3d.environment.BaseLight;
import com.badlogic.gdx.math.Vector3;

public class DirectionalLight
extends BaseLight<DirectionalLight> {
    public final Vector3 direction = new Vector3();

    public DirectionalLight setDirection(float f2, float f3, float f4) {
        this.direction.set(f2, f3, f4);
        return this;
    }

    public DirectionalLight setDirection(Vector3 vector3) {
        this.direction.set(vector3);
        return this;
    }

    public DirectionalLight set(DirectionalLight directionalLight) {
        return this.set(directionalLight.color, directionalLight.direction);
    }

    public DirectionalLight set(Color color, Vector3 vector3) {
        if (color != null) {
            this.color.set(color);
        }
        if (vector3 != null) {
            this.direction.set(vector3).nor();
        }
        return this;
    }

    public DirectionalLight set(float f2, float f3, float f4, Vector3 vector3) {
        this.color.set(f2, f3, f4, 1.0f);
        if (vector3 != null) {
            this.direction.set(vector3).nor();
        }
        return this;
    }

    public DirectionalLight set(Color color, float f2, float f3, float f4) {
        if (color != null) {
            this.color.set(color);
        }
        this.direction.set(f2, f3, f4).nor();
        return this;
    }

    public DirectionalLight set(float f2, float f3, float f4, float f5, float f6, float f7) {
        this.color.set(f2, f3, f4, 1.0f);
        this.direction.set(f5, f6, f7).nor();
        return this;
    }

    public boolean equals(Object object) {
        return object instanceof DirectionalLight && this.equals((DirectionalLight)object);
    }

    public boolean equals(DirectionalLight directionalLight) {
        return directionalLight != null && (directionalLight == this || this.color.equals(directionalLight.color) && this.direction.equals(directionalLight.direction));
    }
}

