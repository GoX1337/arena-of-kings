/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.scenes.scene2d.utils;

import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;
import com.badlogic.gdx.utils.Timer;

public class DragScrollListener
extends DragListener {
    static final Vector2 tmpCoords = new Vector2();
    private ScrollPane scroll;
    private Timer.Task scrollUp;
    private Timer.Task scrollDown;
    Interpolation interpolation = Interpolation.exp5In;
    float minSpeed = 15.0f;
    float maxSpeed = 75.0f;
    float tickSecs = 0.05f;
    long startTime;
    long rampTime = 1750L;
    float padTop;
    float padBottom;

    public DragScrollListener(final ScrollPane scrollPane) {
        this.scroll = scrollPane;
        this.scrollUp = new Timer.Task(){

            @Override
            public void run() {
                DragScrollListener.this.scroll(scrollPane.getScrollY() - DragScrollListener.this.getScrollPixels());
            }
        };
        this.scrollDown = new Timer.Task(){

            @Override
            public void run() {
                DragScrollListener.this.scroll(scrollPane.getScrollY() + DragScrollListener.this.getScrollPixels());
            }
        };
    }

    public void setup(float f2, float f3, float f4, float f5) {
        this.minSpeed = f2;
        this.maxSpeed = f3;
        this.tickSecs = f4;
        this.rampTime = (long)(f5 * 1000.0f);
    }

    float getScrollPixels() {
        return this.interpolation.apply(this.minSpeed, this.maxSpeed, Math.min(1.0f, (float)(System.currentTimeMillis() - this.startTime) / (float)this.rampTime));
    }

    @Override
    public void drag(InputEvent inputEvent, float f2, float f3, int n2) {
        inputEvent.getListenerActor().localToActorCoordinates(this.scroll, tmpCoords.set(f2, f3));
        if (this.isAbove(DragScrollListener.tmpCoords.y)) {
            this.scrollDown.cancel();
            if (!this.scrollUp.isScheduled()) {
                this.startTime = System.currentTimeMillis();
                Timer.schedule(this.scrollUp, this.tickSecs, this.tickSecs);
            }
            return;
        }
        if (this.isBelow(DragScrollListener.tmpCoords.y)) {
            this.scrollUp.cancel();
            if (!this.scrollDown.isScheduled()) {
                this.startTime = System.currentTimeMillis();
                Timer.schedule(this.scrollDown, this.tickSecs, this.tickSecs);
            }
            return;
        }
        this.scrollUp.cancel();
        this.scrollDown.cancel();
    }

    @Override
    public void dragStop(InputEvent inputEvent, float f2, float f3, int n2) {
        this.scrollUp.cancel();
        this.scrollDown.cancel();
    }

    protected boolean isAbove(float f2) {
        return f2 >= this.scroll.getHeight() - this.padTop;
    }

    protected boolean isBelow(float f2) {
        return f2 < this.padBottom;
    }

    protected void scroll(float f2) {
        this.scroll.setScrollY(f2);
    }

    public void setPadding(float f2, float f3) {
        this.padTop = f2;
        this.padBottom = f3;
    }
}

