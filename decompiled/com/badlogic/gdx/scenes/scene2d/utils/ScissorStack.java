/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.scenes.scene2d.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.glutils.HdpiUtils;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Null;

public class ScissorStack {
    private static Array<Rectangle> scissors = new Array();
    static Vector3 tmp = new Vector3();
    static final Rectangle viewport = new Rectangle();

    public static boolean pushScissors(Rectangle rectangle) {
        ScissorStack.fix(rectangle);
        if (ScissorStack.scissors.size == 0) {
            if (rectangle.width < 1.0f || rectangle.height < 1.0f) {
                return false;
            }
            Gdx.gl.glEnable(3089);
        } else {
            Rectangle rectangle2 = scissors.get(ScissorStack.scissors.size - 1);
            float f2 = Math.max(rectangle2.x, rectangle.x);
            float f3 = Math.min(rectangle2.x + rectangle2.width, rectangle.x + rectangle.width);
            if (f3 - f2 < 1.0f) {
                return false;
            }
            float f4 = Math.max(rectangle2.y, rectangle.y);
            float f5 = Math.min(rectangle2.y + rectangle2.height, rectangle.y + rectangle.height);
            if (f5 - f4 < 1.0f) {
                return false;
            }
            rectangle.x = f2;
            rectangle.y = f4;
            rectangle.width = f3 - f2;
            rectangle.height = Math.max(1.0f, f5 - f4);
        }
        scissors.add(rectangle);
        HdpiUtils.glScissor((int)rectangle.x, (int)rectangle.y, (int)rectangle.width, (int)rectangle.height);
        return true;
    }

    public static Rectangle popScissors() {
        Rectangle rectangle = scissors.pop();
        if (ScissorStack.scissors.size == 0) {
            Gdx.gl.glDisable(3089);
        } else {
            Rectangle rectangle2 = scissors.peek();
            HdpiUtils.glScissor((int)rectangle2.x, (int)rectangle2.y, (int)rectangle2.width, (int)rectangle2.height);
        }
        return rectangle;
    }

    @Null
    public static Rectangle peekScissors() {
        if (ScissorStack.scissors.size == 0) {
            return null;
        }
        return scissors.peek();
    }

    private static void fix(Rectangle rectangle) {
        rectangle.x = Math.round(rectangle.x);
        rectangle.y = Math.round(rectangle.y);
        rectangle.width = Math.round(rectangle.width);
        rectangle.height = Math.round(rectangle.height);
        if (rectangle.width < 0.0f) {
            rectangle.width = -rectangle.width;
            rectangle.x -= rectangle.width;
        }
        if (rectangle.height < 0.0f) {
            rectangle.height = -rectangle.height;
            rectangle.y -= rectangle.height;
        }
    }

    public static void calculateScissors(Camera camera, Matrix4 matrix4, Rectangle rectangle, Rectangle rectangle2) {
        ScissorStack.calculateScissors(camera, 0.0f, 0.0f, Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), matrix4, rectangle, rectangle2);
    }

    public static void calculateScissors(Camera camera, float f2, float f3, float f4, float f5, Matrix4 matrix4, Rectangle rectangle, Rectangle rectangle2) {
        tmp.set(rectangle.x, rectangle.y, 0.0f);
        tmp.mul(matrix4);
        camera.project(tmp, f2, f3, f4, f5);
        rectangle2.x = ScissorStack.tmp.x;
        rectangle2.y = ScissorStack.tmp.y;
        tmp.set(rectangle.x + rectangle.width, rectangle.y + rectangle.height, 0.0f);
        tmp.mul(matrix4);
        camera.project(tmp, f2, f3, f4, f5);
        rectangle2.width = ScissorStack.tmp.x - rectangle2.x;
        rectangle2.height = ScissorStack.tmp.y - rectangle2.y;
    }

    public static Rectangle getViewport() {
        if (ScissorStack.scissors.size == 0) {
            viewport.set(0.0f, 0.0f, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
            return viewport;
        }
        Rectangle rectangle = scissors.peek();
        viewport.set(rectangle);
        return viewport;
    }
}

