/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class OrthographicCamera
extends Camera {
    public float zoom = 1.0f;
    private final Vector3 tmp = new Vector3();

    public OrthographicCamera() {
        this.near = 0.0f;
    }

    public OrthographicCamera(float f2, float f3) {
        this.viewportWidth = f2;
        this.viewportHeight = f3;
        this.near = 0.0f;
        this.update();
    }

    @Override
    public void update() {
        this.update(true);
    }

    @Override
    public void update(boolean bl2) {
        this.projection.setToOrtho(this.zoom * -this.viewportWidth / 2.0f, this.zoom * (this.viewportWidth / 2.0f), this.zoom * -(this.viewportHeight / 2.0f), this.zoom * this.viewportHeight / 2.0f, this.near, this.far);
        this.view.setToLookAt(this.position, this.tmp.set(this.position).add(this.direction), this.up);
        this.combined.set(this.projection);
        Matrix4.mul(this.combined.val, this.view.val);
        if (bl2) {
            this.invProjectionView.set(this.combined);
            Matrix4.inv(this.invProjectionView.val);
            this.frustum.update(this.invProjectionView);
        }
    }

    public void setToOrtho(boolean bl2) {
        this.setToOrtho(bl2, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }

    public void setToOrtho(boolean bl2, float f2, float f3) {
        if (bl2) {
            this.up.set(0.0f, -1.0f, 0.0f);
            this.direction.set(0.0f, 0.0f, 1.0f);
        } else {
            this.up.set(0.0f, 1.0f, 0.0f);
            this.direction.set(0.0f, 0.0f, -1.0f);
        }
        this.position.set(this.zoom * f2 / 2.0f, this.zoom * f3 / 2.0f, 0.0f);
        this.viewportWidth = f2;
        this.viewportHeight = f3;
        this.update();
    }

    public void rotate(float f2) {
        this.rotate(this.direction, f2);
    }

    public void translate(float f2, float f3) {
        this.translate(f2, f3, 0.0f);
    }

    public void translate(Vector2 vector2) {
        this.translate(vector2.x, vector2.y, 0.0f);
    }
}

