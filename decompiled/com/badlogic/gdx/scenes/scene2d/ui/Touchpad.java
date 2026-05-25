/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Widget;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.Null;
import com.badlogic.gdx.utils.Pools;

public class Touchpad
extends Widget {
    private TouchpadStyle style;
    boolean touched;
    boolean resetOnTouchUp = true;
    private float deadzoneRadius;
    private final Circle knobBounds = new Circle(0.0f, 0.0f, 0.0f);
    private final Circle touchBounds = new Circle(0.0f, 0.0f, 0.0f);
    private final Circle deadzoneBounds = new Circle(0.0f, 0.0f, 0.0f);
    private final Vector2 knobPosition = new Vector2();
    private final Vector2 knobPercent = new Vector2();

    public Touchpad(float f2, Skin skin) {
        this(f2, skin.get(TouchpadStyle.class));
    }

    public Touchpad(float f2, Skin skin, String string) {
        this(f2, skin.get(string, TouchpadStyle.class));
    }

    public Touchpad(float f2, TouchpadStyle touchpadStyle) {
        if (f2 < 0.0f) {
            throw new IllegalArgumentException("deadzoneRadius must be > 0");
        }
        this.deadzoneRadius = f2;
        this.knobPosition.set(this.getWidth() / 2.0f, this.getHeight() / 2.0f);
        this.setStyle(touchpadStyle);
        this.setSize(this.getPrefWidth(), this.getPrefHeight());
        this.addListener(new InputListener(){

            @Override
            public boolean touchDown(InputEvent inputEvent, float f2, float f3, int n2, int n3) {
                if (Touchpad.this.touched) {
                    return false;
                }
                Touchpad.this.touched = true;
                Touchpad.this.calculatePositionAndValue(f2, f3, false);
                return true;
            }

            @Override
            public void touchDragged(InputEvent inputEvent, float f2, float f3, int n2) {
                Touchpad.this.calculatePositionAndValue(f2, f3, false);
            }

            @Override
            public void touchUp(InputEvent inputEvent, float f2, float f3, int n2, int n3) {
                Touchpad.this.touched = false;
                Touchpad.this.calculatePositionAndValue(f2, f3, Touchpad.this.resetOnTouchUp);
            }
        });
    }

    void calculatePositionAndValue(float f2, float f3, boolean bl2) {
        float f4 = this.knobPosition.x;
        float f5 = this.knobPosition.y;
        float f6 = this.knobPercent.x;
        float f7 = this.knobPercent.y;
        float f8 = this.knobBounds.x;
        float f9 = this.knobBounds.y;
        this.knobPosition.set(f8, f9);
        this.knobPercent.set(0.0f, 0.0f);
        if (!bl2 && !this.deadzoneBounds.contains(f2, f3)) {
            this.knobPercent.set((f2 - f8) / this.knobBounds.radius, (f3 - f9) / this.knobBounds.radius);
            float f10 = this.knobPercent.len();
            if (f10 > 1.0f) {
                this.knobPercent.scl(1.0f / f10);
            }
            if (this.knobBounds.contains(f2, f3)) {
                this.knobPosition.set(f2, f3);
            } else {
                this.knobPosition.set(this.knobPercent).nor().scl(this.knobBounds.radius).add(this.knobBounds.x, this.knobBounds.y);
            }
        }
        if (f6 != this.knobPercent.x || f7 != this.knobPercent.y) {
            ChangeListener.ChangeEvent changeEvent = Pools.obtain(ChangeListener.ChangeEvent.class);
            if (this.fire(changeEvent)) {
                this.knobPercent.set(f6, f7);
                this.knobPosition.set(f4, f5);
            }
            Pools.free(changeEvent);
        }
    }

    public void setStyle(TouchpadStyle touchpadStyle) {
        if (touchpadStyle == null) {
            throw new IllegalArgumentException("style cannot be null");
        }
        this.style = touchpadStyle;
        this.invalidateHierarchy();
    }

    public TouchpadStyle getStyle() {
        return this.style;
    }

    @Override
    public Actor hit(float f2, float f3, boolean bl2) {
        if (bl2 && this.getTouchable() != Touchable.enabled) {
            return null;
        }
        if (!this.isVisible()) {
            return null;
        }
        return this.touchBounds.contains(f2, f3) ? this : null;
    }

    @Override
    public void layout() {
        float f2 = this.getWidth() / 2.0f;
        float f3 = this.getHeight() / 2.0f;
        float f4 = Math.min(f2, f3);
        this.touchBounds.set(f2, f3, f4);
        if (this.style.knob != null) {
            f4 -= Math.max(this.style.knob.getMinWidth(), this.style.knob.getMinHeight()) / 2.0f;
        }
        this.knobBounds.set(f2, f3, f4);
        this.deadzoneBounds.set(f2, f3, this.deadzoneRadius);
        this.knobPosition.set(f2, f3);
        this.knobPercent.set(0.0f, 0.0f);
    }

    @Override
    public void draw(Batch batch, float f2) {
        Drawable drawable;
        this.validate();
        Color color = this.getColor();
        batch.setColor(color.r, color.g, color.b, color.a * f2);
        float f3 = this.getX();
        float f4 = this.getY();
        float f5 = this.getWidth();
        float f6 = this.getHeight();
        Drawable drawable2 = this.style.background;
        if (drawable2 != null) {
            drawable2.draw(batch, f3, f4, f5, f6);
        }
        if ((drawable = this.style.knob) != null) {
            drawable.draw(batch, f3 += this.knobPosition.x - drawable.getMinWidth() / 2.0f, f4 += this.knobPosition.y - drawable.getMinHeight() / 2.0f, drawable.getMinWidth(), drawable.getMinHeight());
        }
    }

    @Override
    public float getPrefWidth() {
        return this.style.background != null ? this.style.background.getMinWidth() : 0.0f;
    }

    @Override
    public float getPrefHeight() {
        return this.style.background != null ? this.style.background.getMinHeight() : 0.0f;
    }

    public boolean isTouched() {
        return this.touched;
    }

    public boolean getResetOnTouchUp() {
        return this.resetOnTouchUp;
    }

    public void setResetOnTouchUp(boolean bl2) {
        this.resetOnTouchUp = bl2;
    }

    public void setDeadzone(float f2) {
        if (f2 < 0.0f) {
            throw new IllegalArgumentException("deadzoneRadius must be > 0");
        }
        this.deadzoneRadius = f2;
        this.invalidate();
    }

    public float getKnobX() {
        return this.knobPosition.x;
    }

    public float getKnobY() {
        return this.knobPosition.y;
    }

    public float getKnobPercentX() {
        return this.knobPercent.x;
    }

    public float getKnobPercentY() {
        return this.knobPercent.y;
    }

    public static class TouchpadStyle {
        @Null
        public Drawable background;
        @Null
        public Drawable knob;

        public TouchpadStyle() {
        }

        public TouchpadStyle(@Null Drawable drawable, @Null Drawable drawable2) {
            this.background = drawable;
            this.knob = drawable2;
        }

        public TouchpadStyle(TouchpadStyle touchpadStyle) {
            this.background = touchpadStyle.background;
            this.knob = touchpadStyle.knob;
        }
    }
}

