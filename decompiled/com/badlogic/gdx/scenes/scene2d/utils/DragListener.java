/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.scenes.scene2d.utils;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class DragListener
extends InputListener {
    private float tapSquareSize = 14.0f;
    private float touchDownX = -1.0f;
    private float touchDownY = -1.0f;
    private float stageTouchDownX = -1.0f;
    private float stageTouchDownY = -1.0f;
    private float dragStartX;
    private float dragStartY;
    private float dragLastX;
    private float dragLastY;
    private float dragX;
    private float dragY;
    private int pressedPointer = -1;
    private int button;
    private boolean dragging;

    @Override
    public boolean touchDown(InputEvent inputEvent, float f2, float f3, int n2, int n3) {
        if (this.pressedPointer != -1) {
            return false;
        }
        if (n2 == 0 && this.button != -1 && n3 != this.button) {
            return false;
        }
        this.pressedPointer = n2;
        this.touchDownX = f2;
        this.touchDownY = f3;
        this.stageTouchDownX = inputEvent.getStageX();
        this.stageTouchDownY = inputEvent.getStageY();
        return true;
    }

    @Override
    public void touchDragged(InputEvent inputEvent, float f2, float f3, int n2) {
        if (n2 != this.pressedPointer) {
            return;
        }
        if (!this.dragging && (Math.abs(this.touchDownX - f2) > this.tapSquareSize || Math.abs(this.touchDownY - f3) > this.tapSquareSize)) {
            this.dragging = true;
            this.dragStartX = f2;
            this.dragStartY = f3;
            this.dragStart(inputEvent, f2, f3, n2);
            this.dragX = f2;
            this.dragY = f3;
        }
        if (this.dragging) {
            this.dragLastX = this.dragX;
            this.dragLastY = this.dragY;
            this.dragX = f2;
            this.dragY = f3;
            this.drag(inputEvent, f2, f3, n2);
        }
    }

    @Override
    public void touchUp(InputEvent inputEvent, float f2, float f3, int n2, int n3) {
        if (n2 == this.pressedPointer) {
            if (this.dragging) {
                this.dragStop(inputEvent, f2, f3, n2);
            }
            this.cancel();
        }
    }

    public void dragStart(InputEvent inputEvent, float f2, float f3, int n2) {
    }

    public void drag(InputEvent inputEvent, float f2, float f3, int n2) {
    }

    public void dragStop(InputEvent inputEvent, float f2, float f3, int n2) {
    }

    public void cancel() {
        this.dragging = false;
        this.pressedPointer = -1;
    }

    public boolean isDragging() {
        return this.dragging;
    }

    public void setTapSquareSize(float f2) {
        this.tapSquareSize = f2;
    }

    public float getTapSquareSize() {
        return this.tapSquareSize;
    }

    public float getTouchDownX() {
        return this.touchDownX;
    }

    public float getTouchDownY() {
        return this.touchDownY;
    }

    public float getStageTouchDownX() {
        return this.stageTouchDownX;
    }

    public float getStageTouchDownY() {
        return this.stageTouchDownY;
    }

    public float getDragStartX() {
        return this.dragStartX;
    }

    public void setDragStartX(float f2) {
        this.dragStartX = f2;
    }

    public float getDragStartY() {
        return this.dragStartY;
    }

    public void setDragStartY(float f2) {
        this.dragStartY = f2;
    }

    public float getDragX() {
        return this.dragX;
    }

    public float getDragY() {
        return this.dragY;
    }

    public float getDragDistance() {
        return Vector2.len(this.dragX - this.dragStartX, this.dragY - this.dragStartY);
    }

    public float getDeltaX() {
        return this.dragX - this.dragLastX;
    }

    public float getDeltaY() {
        return this.dragY - this.dragLastY;
    }

    public int getButton() {
        return this.button;
    }

    public void setButton(int n2) {
        this.button = n2;
    }
}

