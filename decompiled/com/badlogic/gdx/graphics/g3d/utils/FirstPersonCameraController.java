/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.IntIntMap;

public class FirstPersonCameraController
extends InputAdapter {
    protected final Camera camera;
    protected final IntIntMap keys = new IntIntMap();
    public int strafeLeftKey = 29;
    public int strafeRightKey = 32;
    public int forwardKey = 51;
    public int backwardKey = 47;
    public int upKey = 45;
    public int downKey = 33;
    public boolean autoUpdate = true;
    protected float velocity = 5.0f;
    protected float degreesPerPixel = 0.5f;
    protected final Vector3 tmp = new Vector3();

    public FirstPersonCameraController(Camera camera) {
        this.camera = camera;
    }

    @Override
    public boolean keyDown(int n2) {
        this.keys.put(n2, n2);
        return true;
    }

    @Override
    public boolean keyUp(int n2) {
        this.keys.remove(n2, 0);
        return true;
    }

    public void setVelocity(float f2) {
        this.velocity = f2;
    }

    public void setDegreesPerPixel(float f2) {
        this.degreesPerPixel = f2;
    }

    @Override
    public boolean touchDragged(int n2, int n3, int n4) {
        float f2 = (float)(-Gdx.input.getDeltaX()) * this.degreesPerPixel;
        float f3 = (float)(-Gdx.input.getDeltaY()) * this.degreesPerPixel;
        this.camera.direction.rotate(this.camera.up, f2);
        this.tmp.set(this.camera.direction).crs(this.camera.up).nor();
        this.camera.direction.rotate(this.tmp, f3);
        return true;
    }

    public void update() {
        this.update(Gdx.graphics.getDeltaTime());
    }

    public void update(float f2) {
        if (this.keys.containsKey(this.forwardKey)) {
            this.tmp.set(this.camera.direction).nor().scl(f2 * this.velocity);
            this.camera.position.add(this.tmp);
        }
        if (this.keys.containsKey(this.backwardKey)) {
            this.tmp.set(this.camera.direction).nor().scl(-f2 * this.velocity);
            this.camera.position.add(this.tmp);
        }
        if (this.keys.containsKey(this.strafeLeftKey)) {
            this.tmp.set(this.camera.direction).crs(this.camera.up).nor().scl(-f2 * this.velocity);
            this.camera.position.add(this.tmp);
        }
        if (this.keys.containsKey(this.strafeRightKey)) {
            this.tmp.set(this.camera.direction).crs(this.camera.up).nor().scl(f2 * this.velocity);
            this.camera.position.add(this.tmp);
        }
        if (this.keys.containsKey(this.upKey)) {
            this.tmp.set(this.camera.up).nor().scl(f2 * this.velocity);
            this.camera.position.add(this.tmp);
        }
        if (this.keys.containsKey(this.downKey)) {
            this.tmp.set(this.camera.up).nor().scl(-f2 * this.velocity);
            this.camera.position.add(this.tmp);
        }
        if (this.autoUpdate) {
            this.camera.update(true);
        }
    }
}

