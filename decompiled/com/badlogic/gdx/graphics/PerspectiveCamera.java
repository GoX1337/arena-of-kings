/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;

public class PerspectiveCamera
extends Camera {
    public float fieldOfView = 67.0f;
    final Vector3 tmp = new Vector3();

    public PerspectiveCamera() {
    }

    public PerspectiveCamera(float f2, float f3, float f4) {
        this.fieldOfView = f2;
        this.viewportWidth = f3;
        this.viewportHeight = f4;
        this.update();
    }

    @Override
    public void update() {
        this.update(true);
    }

    @Override
    public void update(boolean bl2) {
        float f2 = this.viewportWidth / this.viewportHeight;
        this.projection.setToProjection(Math.abs(this.near), Math.abs(this.far), this.fieldOfView, f2);
        this.view.setToLookAt(this.position, this.tmp.set(this.position).add(this.direction), this.up);
        this.combined.set(this.projection);
        Matrix4.mul(this.combined.val, this.view.val);
        if (bl2) {
            this.invProjectionView.set(this.combined);
            Matrix4.inv(this.invProjectionView.val);
            this.frustum.update(this.invProjectionView);
        }
    }
}

