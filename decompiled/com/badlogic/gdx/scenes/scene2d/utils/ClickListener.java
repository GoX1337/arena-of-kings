/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.scenes.scene2d.utils;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.utils.Null;
import com.badlogic.gdx.utils.TimeUtils;

public class ClickListener
extends InputListener {
    public static float visualPressedDuration = 0.1f;
    private float tapSquareSize = 14.0f;
    private float touchDownX = -1.0f;
    private float touchDownY = -1.0f;
    private int pressedPointer = -1;
    private int pressedButton = -1;
    private int button;
    private boolean pressed;
    private boolean over;
    private boolean cancelled;
    private long visualPressedTime;
    private long tapCountInterval = 400000000L;
    private int tapCount;
    private long lastTapTime;

    public ClickListener() {
    }

    public ClickListener(int n2) {
        this.button = n2;
    }

    @Override
    public boolean touchDown(InputEvent inputEvent, float f2, float f3, int n2, int n3) {
        if (this.pressed) {
            return false;
        }
        if (n2 == 0 && this.button != -1 && n3 != this.button) {
            return false;
        }
        this.pressed = true;
        this.pressedPointer = n2;
        this.pressedButton = n3;
        this.touchDownX = f2;
        this.touchDownY = f3;
        this.setVisualPressed(true);
        return true;
    }

    @Override
    public void touchDragged(InputEvent inputEvent, float f2, float f3, int n2) {
        if (n2 != this.pressedPointer || this.cancelled) {
            return;
        }
        this.pressed = this.isOver(inputEvent.getListenerActor(), f2, f3);
        if (!this.pressed) {
            this.invalidateTapSquare();
        }
    }

    @Override
    public void touchUp(InputEvent inputEvent, float f2, float f3, int n2, int n3) {
        if (n2 == this.pressedPointer) {
            if (!this.cancelled) {
                boolean bl2 = this.isOver(inputEvent.getListenerActor(), f2, f3);
                if (bl2 && n2 == 0 && this.button != -1 && n3 != this.button) {
                    bl2 = false;
                }
                if (bl2) {
                    long l2 = TimeUtils.nanoTime();
                    if (l2 - this.lastTapTime > this.tapCountInterval) {
                        this.tapCount = 0;
                    }
                    ++this.tapCount;
                    this.lastTapTime = l2;
                    this.clicked(inputEvent, f2, f3);
                }
            }
            this.pressed = false;
            this.pressedPointer = -1;
            this.pressedButton = -1;
            this.cancelled = false;
        }
    }

    @Override
    public void enter(InputEvent inputEvent, float f2, float f3, int n2, @Null Actor actor) {
        if (n2 == -1 && !this.cancelled) {
            this.over = true;
        }
    }

    @Override
    public void exit(InputEvent inputEvent, float f2, float f3, int n2, @Null Actor actor) {
        if (n2 == -1 && !this.cancelled) {
            this.over = false;
        }
    }

    public void cancel() {
        if (this.pressedPointer == -1) {
            return;
        }
        this.cancelled = true;
        this.pressed = false;
    }

    public void clicked(InputEvent inputEvent, float f2, float f3) {
    }

    public boolean isOver(Actor actor, float f2, float f3) {
        Actor actor2 = actor.hit(f2, f3, true);
        if (actor2 == null || !actor2.isDescendantOf(actor)) {
            return this.inTapSquare(f2, f3);
        }
        return true;
    }

    public boolean inTapSquare(float f2, float f3) {
        if (this.touchDownX == -1.0f && this.touchDownY == -1.0f) {
            return false;
        }
        return Math.abs(f2 - this.touchDownX) < this.tapSquareSize && Math.abs(f3 - this.touchDownY) < this.tapSquareSize;
    }

    public boolean inTapSquare() {
        return this.touchDownX != -1.0f;
    }

    public void invalidateTapSquare() {
        this.touchDownX = -1.0f;
        this.touchDownY = -1.0f;
    }

    public boolean isPressed() {
        return this.pressed;
    }

    public boolean isVisualPressed() {
        if (this.pressed) {
            return true;
        }
        if (this.visualPressedTime <= 0L) {
            return false;
        }
        if (this.visualPressedTime > TimeUtils.millis()) {
            return true;
        }
        this.visualPressedTime = 0L;
        return false;
    }

    public void setVisualPressed(boolean bl2) {
        this.visualPressedTime = bl2 ? TimeUtils.millis() + (long)(visualPressedDuration * 1000.0f) : 0L;
    }

    public boolean isOver() {
        return this.over || this.pressed;
    }

    public void setTapSquareSize(float f2) {
        this.tapSquareSize = f2;
    }

    public float getTapSquareSize() {
        return this.tapSquareSize;
    }

    public void setTapCountInterval(float f2) {
        this.tapCountInterval = (long)(f2 * 1.0E9f);
    }

    public int getTapCount() {
        return this.tapCount;
    }

    public void setTapCount(int n2) {
        this.tapCount = n2;
    }

    public float getTouchDownX() {
        return this.touchDownX;
    }

    public float getTouchDownY() {
        return this.touchDownY;
    }

    public int getPressedButton() {
        return this.pressedButton;
    }

    public int getPressedPointer() {
        return this.pressedPointer;
    }

    public int getButton() {
        return this.button;
    }

    public void setButton(int n2) {
        this.button = n2;
    }
}

