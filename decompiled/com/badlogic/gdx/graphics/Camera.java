/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Frustum;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.Ray;

public abstract class Camera {
    public final Vector3 position = new Vector3();
    public final Vector3 direction = new Vector3(0.0f, 0.0f, -1.0f);
    public final Vector3 up = new Vector3(0.0f, 1.0f, 0.0f);
    public final Matrix4 projection = new Matrix4();
    public final Matrix4 view = new Matrix4();
    public final Matrix4 combined = new Matrix4();
    public final Matrix4 invProjectionView = new Matrix4();
    public float near = 1.0f;
    public float far = 100.0f;
    public float viewportWidth = 0.0f;
    public float viewportHeight = 0.0f;
    public final Frustum frustum = new Frustum();
    private final Vector3 tmpVec = new Vector3();
    private final Ray ray = new Ray(new Vector3(), new Vector3());

    public abstract void update();

    public abstract void update(boolean var1);

    public void lookAt(float f2, float f3, float f4) {
        this.tmpVec.set(f2, f3, f4).sub(this.position).nor();
        if (!this.tmpVec.isZero()) {
            float f5 = this.tmpVec.dot(this.up);
            if (Math.abs(f5 - 1.0f) < 1.0E-9f) {
                this.up.set(this.direction).scl(-1.0f);
            } else if (Math.abs(f5 + 1.0f) < 1.0E-9f) {
                this.up.set(this.direction);
            }
            this.direction.set(this.tmpVec);
            this.normalizeUp();
        }
    }

    public void lookAt(Vector3 vector3) {
        this.lookAt(vector3.x, vector3.y, vector3.z);
    }

    public void normalizeUp() {
        this.tmpVec.set(this.direction).crs(this.up);
        this.up.set(this.tmpVec).crs(this.direction).nor();
    }

    public void rotate(float f2, float f3, float f4, float f5) {
        this.direction.rotate(f2, f3, f4, f5);
        this.up.rotate(f2, f3, f4, f5);
    }

    public void rotate(Vector3 vector3, float f2) {
        this.direction.rotate(vector3, f2);
        this.up.rotate(vector3, f2);
    }

    public void rotate(Matrix4 matrix4) {
        this.direction.rot(matrix4);
        this.up.rot(matrix4);
    }

    public void rotate(Quaternion quaternion) {
        quaternion.transform(this.direction);
        quaternion.transform(this.up);
    }

    public void rotateAround(Vector3 vector3, Vector3 vector32, float f2) {
        this.tmpVec.set(vector3);
        this.tmpVec.sub(this.position);
        this.translate(this.tmpVec);
        this.rotate(vector32, f2);
        this.tmpVec.rotate(vector32, f2);
        this.translate(-this.tmpVec.x, -this.tmpVec.y, -this.tmpVec.z);
    }

    public void transform(Matrix4 matrix4) {
        this.position.mul(matrix4);
        this.rotate(matrix4);
    }

    public void translate(float f2, float f3, float f4) {
        this.position.add(f2, f3, f4);
    }

    public void translate(Vector3 vector3) {
        this.position.add(vector3);
    }

    public Vector3 unproject(Vector3 vector3, float f2, float f3, float f4, float f5) {
        float f6 = vector3.x - f2;
        float f7 = (float)Gdx.graphics.getHeight() - vector3.y - f3;
        vector3.x = 2.0f * f6 / f4 - 1.0f;
        vector3.y = 2.0f * f7 / f5 - 1.0f;
        vector3.z = 2.0f * vector3.z - 1.0f;
        vector3.prj(this.invProjectionView);
        return vector3;
    }

    public Vector3 unproject(Vector3 vector3) {
        this.unproject(vector3, 0.0f, 0.0f, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        return vector3;
    }

    public Vector3 project(Vector3 vector3) {
        this.project(vector3, 0.0f, 0.0f, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        return vector3;
    }

    public Vector3 project(Vector3 vector3, float f2, float f3, float f4, float f5) {
        vector3.prj(this.combined);
        vector3.x = f4 * (vector3.x + 1.0f) / 2.0f + f2;
        vector3.y = f5 * (vector3.y + 1.0f) / 2.0f + f3;
        vector3.z = (vector3.z + 1.0f) / 2.0f;
        return vector3;
    }

    public Ray getPickRay(float f2, float f3, float f4, float f5, float f6, float f7) {
        this.unproject(this.ray.origin.set(f2, f3, 0.0f), f4, f5, f6, f7);
        this.unproject(this.ray.direction.set(f2, f3, 1.0f), f4, f5, f6, f7);
        this.ray.direction.sub(this.ray.origin).nor();
        return this.ray;
    }

    public Ray getPickRay(float f2, float f3) {
        return this.getPickRay(f2, f3, 0.0f, 0.0f, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }
}

