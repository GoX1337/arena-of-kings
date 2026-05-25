/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils.viewport;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.glutils.HdpiUtils;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.Ray;
import com.badlogic.gdx.scenes.scene2d.utils.ScissorStack;

public abstract class Viewport {
    private Camera camera;
    private float worldWidth;
    private float worldHeight;
    private int screenX;
    private int screenY;
    private int screenWidth;
    private int screenHeight;
    private final Vector3 tmp = new Vector3();

    public void apply() {
        this.apply(false);
    }

    public void apply(boolean bl2) {
        HdpiUtils.glViewport(this.screenX, this.screenY, this.screenWidth, this.screenHeight);
        this.camera.viewportWidth = this.worldWidth;
        this.camera.viewportHeight = this.worldHeight;
        if (bl2) {
            this.camera.position.set(this.worldWidth / 2.0f, this.worldHeight / 2.0f, 0.0f);
        }
        this.camera.update();
    }

    public final void update(int n2, int n3) {
        this.update(n2, n3, false);
    }

    public void update(int n2, int n3, boolean bl2) {
        this.apply(bl2);
    }

    public Vector2 unproject(Vector2 vector2) {
        this.tmp.set(vector2.x, vector2.y, 1.0f);
        this.camera.unproject(this.tmp, this.screenX, this.screenY, this.screenWidth, this.screenHeight);
        vector2.set(this.tmp.x, this.tmp.y);
        return vector2;
    }

    public Vector2 project(Vector2 vector2) {
        this.tmp.set(vector2.x, vector2.y, 1.0f);
        this.camera.project(this.tmp, this.screenX, this.screenY, this.screenWidth, this.screenHeight);
        vector2.set(this.tmp.x, this.tmp.y);
        return vector2;
    }

    public Vector3 unproject(Vector3 vector3) {
        this.camera.unproject(vector3, this.screenX, this.screenY, this.screenWidth, this.screenHeight);
        return vector3;
    }

    public Vector3 project(Vector3 vector3) {
        this.camera.project(vector3, this.screenX, this.screenY, this.screenWidth, this.screenHeight);
        return vector3;
    }

    public Ray getPickRay(float f2, float f3) {
        return this.camera.getPickRay(f2, f3, this.screenX, this.screenY, this.screenWidth, this.screenHeight);
    }

    public void calculateScissors(Matrix4 matrix4, Rectangle rectangle, Rectangle rectangle2) {
        ScissorStack.calculateScissors(this.camera, this.screenX, this.screenY, this.screenWidth, this.screenHeight, matrix4, rectangle, rectangle2);
    }

    public Vector2 toScreenCoordinates(Vector2 vector2, Matrix4 matrix4) {
        this.tmp.set(vector2.x, vector2.y, 0.0f);
        this.tmp.mul(matrix4);
        this.camera.project(this.tmp, this.screenX, this.screenY, this.screenWidth, this.screenHeight);
        this.tmp.y = (float)Gdx.graphics.getHeight() - this.tmp.y;
        vector2.x = this.tmp.x;
        vector2.y = this.tmp.y;
        return vector2;
    }

    public Camera getCamera() {
        return this.camera;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    public float getWorldWidth() {
        return this.worldWidth;
    }

    public void setWorldWidth(float f2) {
        this.worldWidth = f2;
    }

    public float getWorldHeight() {
        return this.worldHeight;
    }

    public void setWorldHeight(float f2) {
        this.worldHeight = f2;
    }

    public void setWorldSize(float f2, float f3) {
        this.worldWidth = f2;
        this.worldHeight = f3;
    }

    public int getScreenX() {
        return this.screenX;
    }

    public void setScreenX(int n2) {
        this.screenX = n2;
    }

    public int getScreenY() {
        return this.screenY;
    }

    public void setScreenY(int n2) {
        this.screenY = n2;
    }

    public int getScreenWidth() {
        return this.screenWidth;
    }

    public void setScreenWidth(int n2) {
        this.screenWidth = n2;
    }

    public int getScreenHeight() {
        return this.screenHeight;
    }

    public void setScreenHeight(int n2) {
        this.screenHeight = n2;
    }

    public void setScreenPosition(int n2, int n3) {
        this.screenX = n2;
        this.screenY = n3;
    }

    public void setScreenSize(int n2, int n3) {
        this.screenWidth = n2;
        this.screenHeight = n3;
    }

    public void setScreenBounds(int n2, int n3, int n4, int n5) {
        this.screenX = n2;
        this.screenY = n3;
        this.screenWidth = n4;
        this.screenHeight = n5;
    }

    public int getLeftGutterWidth() {
        return this.screenX;
    }

    public int getRightGutterX() {
        return this.screenX + this.screenWidth;
    }

    public int getRightGutterWidth() {
        return Gdx.graphics.getWidth() - (this.screenX + this.screenWidth);
    }

    public int getBottomGutterHeight() {
        return this.screenY;
    }

    public int getTopGutterY() {
        return this.screenY + this.screenHeight;
    }

    public int getTopGutterHeight() {
        return Gdx.graphics.getHeight() - (this.screenY + this.screenHeight);
    }
}

