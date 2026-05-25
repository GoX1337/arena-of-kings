/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Widget;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.Disableable;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.Null;
import com.badlogic.gdx.utils.Pools;

public class ProgressBar
extends Widget
implements Disableable {
    private ProgressBarStyle style;
    float min;
    float max;
    float stepSize;
    private float value;
    private float animateFromValue;
    float position;
    final boolean vertical;
    private float animateDuration;
    private float animateTime;
    private Interpolation animateInterpolation = Interpolation.linear;
    private Interpolation visualInterpolation = Interpolation.linear;
    boolean disabled;
    private boolean round = true;
    private boolean programmaticChangeEvents = true;

    public ProgressBar(float f2, float f3, float f4, boolean bl2, Skin skin) {
        this(f2, f3, f4, bl2, skin.get("default-" + (bl2 ? "vertical" : "horizontal"), ProgressBarStyle.class));
    }

    public ProgressBar(float f2, float f3, float f4, boolean bl2, Skin skin, String string) {
        this(f2, f3, f4, bl2, skin.get(string, ProgressBarStyle.class));
    }

    public ProgressBar(float f2, float f3, float f4, boolean bl2, ProgressBarStyle progressBarStyle) {
        if (f2 > f3) {
            throw new IllegalArgumentException("max must be > min. min,max: " + f2 + ", " + f3);
        }
        if (f4 <= 0.0f) {
            throw new IllegalArgumentException("stepSize must be > 0: " + f4);
        }
        this.setStyle(progressBarStyle);
        this.min = f2;
        this.max = f3;
        this.stepSize = f4;
        this.vertical = bl2;
        this.value = f2;
        this.setSize(this.getPrefWidth(), this.getPrefHeight());
    }

    public void setStyle(ProgressBarStyle progressBarStyle) {
        if (progressBarStyle == null) {
            throw new IllegalArgumentException("style cannot be null.");
        }
        this.style = progressBarStyle;
        this.invalidateHierarchy();
    }

    public ProgressBarStyle getStyle() {
        return this.style;
    }

    @Override
    public void act(float f2) {
        super.act(f2);
        if (this.animateTime > 0.0f) {
            this.animateTime -= f2;
            Stage stage = this.getStage();
            if (stage != null && stage.getActionsRequestRendering()) {
                Gdx.graphics.requestRendering();
            }
        }
    }

    @Override
    public void draw(Batch batch, float f2) {
        ProgressBarStyle progressBarStyle = this.style;
        boolean bl2 = this.disabled;
        Drawable drawable = progressBarStyle.knob;
        Drawable drawable2 = this.getKnobDrawable();
        Drawable drawable3 = this.getBackgroundDrawable();
        Drawable drawable4 = this.getKnobBeforeDrawable();
        Drawable drawable5 = this.getKnobAfterDrawable();
        Color color = this.getColor();
        float f3 = this.getX();
        float f4 = this.getY();
        float f5 = this.getWidth();
        float f6 = this.getHeight();
        float f7 = drawable == null ? 0.0f : drawable.getMinHeight();
        float f8 = drawable == null ? 0.0f : drawable.getMinWidth();
        float f9 = this.getVisualPercent();
        batch.setColor(color.r, color.g, color.b, color.a * f2);
        if (this.vertical) {
            float f10 = 0.0f;
            float f11 = 0.0f;
            if (drawable3 != null) {
                this.drawRound(batch, drawable3, f3 + (f5 - drawable3.getMinWidth()) * 0.5f, f4, drawable3.getMinWidth(), f6);
                f10 = drawable3.getTopHeight();
                f11 = drawable3.getBottomHeight();
                f6 -= f10 + f11;
            }
            float f12 = f6 - f7;
            float f13 = MathUtils.clamp(f12 * f9, 0.0f, f12);
            this.position = f11 + f13;
            float f14 = f7 * 0.5f;
            if (drawable4 != null) {
                this.drawRound(batch, drawable4, f3 + (f5 - drawable4.getMinWidth()) * 0.5f, f4 + f11, drawable4.getMinWidth(), f13 + f14);
            }
            if (drawable5 != null) {
                this.drawRound(batch, drawable5, f3 + (f5 - drawable5.getMinWidth()) * 0.5f, f4 + this.position + f14, drawable5.getMinWidth(), f12 - (this.round ? (float)Math.round(f13 - f14) : f13 - f14));
            }
            if (drawable2 != null) {
                float f15 = drawable2.getMinWidth();
                float f16 = drawable2.getMinHeight();
                this.drawRound(batch, drawable2, f3 + (f5 - f15) * 0.5f, f4 + this.position + (f7 - f16) * 0.5f, f15, f16);
            }
        } else {
            float f17 = 0.0f;
            float f18 = 0.0f;
            if (drawable3 != null) {
                this.drawRound(batch, drawable3, f3, Math.round(f4 + (f6 - drawable3.getMinHeight()) * 0.5f), f5, Math.round(drawable3.getMinHeight()));
                f17 = drawable3.getLeftWidth();
                f18 = drawable3.getRightWidth();
                f5 -= f17 + f18;
            }
            float f19 = f5 - f8;
            float f20 = MathUtils.clamp(f19 * f9, 0.0f, f19);
            this.position = f17 + f20;
            float f21 = f8 * 0.5f;
            if (drawable4 != null) {
                this.drawRound(batch, drawable4, f3 + f17, f4 + (f6 - drawable4.getMinHeight()) * 0.5f, f20 + f21, drawable4.getMinHeight());
            }
            if (drawable5 != null) {
                this.drawRound(batch, drawable5, f3 + this.position + f21, f4 + (f6 - drawable5.getMinHeight()) * 0.5f, f19 - (this.round ? (float)Math.round(f20 - f21) : f20 - f21), drawable5.getMinHeight());
            }
            if (drawable2 != null) {
                float f22 = drawable2.getMinWidth();
                float f23 = drawable2.getMinHeight();
                this.drawRound(batch, drawable2, f3 + this.position + (f8 - f22) * 0.5f, f4 + (f6 - f23) * 0.5f, f22, f23);
            }
        }
    }

    private void drawRound(Batch batch, Drawable drawable, float f2, float f3, float f4, float f5) {
        if (this.round) {
            f2 = Math.round(f2);
            f3 = Math.round(f3);
            f4 = Math.round(f4);
            f5 = Math.round(f5);
        }
        drawable.draw(batch, f2, f3, f4, f5);
    }

    public float getValue() {
        return this.value;
    }

    public float getVisualValue() {
        if (this.animateTime > 0.0f) {
            return this.animateInterpolation.apply(this.animateFromValue, this.value, 1.0f - this.animateTime / this.animateDuration);
        }
        return this.value;
    }

    public void updateVisualValue() {
        this.animateTime = 0.0f;
    }

    public float getPercent() {
        if (this.min == this.max) {
            return 0.0f;
        }
        return (this.value - this.min) / (this.max - this.min);
    }

    public float getVisualPercent() {
        if (this.min == this.max) {
            return 0.0f;
        }
        return this.visualInterpolation.apply((this.getVisualValue() - this.min) / (this.max - this.min));
    }

    @Null
    protected Drawable getBackgroundDrawable() {
        if (this.disabled && this.style.disabledBackground != null) {
            return this.style.disabledBackground;
        }
        return this.style.background;
    }

    @Null
    protected Drawable getKnobDrawable() {
        if (this.disabled && this.style.disabledKnob != null) {
            return this.style.disabledKnob;
        }
        return this.style.knob;
    }

    protected Drawable getKnobBeforeDrawable() {
        if (this.disabled && this.style.disabledKnobBefore != null) {
            return this.style.disabledKnobBefore;
        }
        return this.style.knobBefore;
    }

    protected Drawable getKnobAfterDrawable() {
        if (this.disabled && this.style.disabledKnobAfter != null) {
            return this.style.disabledKnobAfter;
        }
        return this.style.knobAfter;
    }

    protected float getKnobPosition() {
        return this.position;
    }

    public boolean setValue(float f2) {
        float f3;
        if ((f2 = this.clamp(this.round(f2))) == (f3 = this.value)) {
            return false;
        }
        float f4 = this.getVisualValue();
        this.value = f2;
        if (this.programmaticChangeEvents) {
            ChangeListener.ChangeEvent changeEvent = Pools.obtain(ChangeListener.ChangeEvent.class);
            boolean bl2 = this.fire(changeEvent);
            Pools.free(changeEvent);
            if (bl2) {
                this.value = f3;
                return false;
            }
        }
        if (this.animateDuration > 0.0f) {
            this.animateFromValue = f4;
            this.animateTime = this.animateDuration;
        }
        return true;
    }

    protected float round(float f2) {
        return (float)Math.round(f2 / this.stepSize) * this.stepSize;
    }

    protected float clamp(float f2) {
        return MathUtils.clamp(f2, this.min, this.max);
    }

    public void setRange(float f2, float f3) {
        if (f2 > f3) {
            throw new IllegalArgumentException("min must be <= max: " + f2 + " <= " + f3);
        }
        this.min = f2;
        this.max = f3;
        if (this.value < f2) {
            this.setValue(f2);
        } else if (this.value > f3) {
            this.setValue(f3);
        }
    }

    public void setStepSize(float f2) {
        if (f2 <= 0.0f) {
            throw new IllegalArgumentException("steps must be > 0: " + f2);
        }
        this.stepSize = f2;
    }

    @Override
    public float getPrefWidth() {
        if (this.vertical) {
            Drawable drawable = this.style.knob;
            Drawable drawable2 = this.getBackgroundDrawable();
            return Math.max(drawable == null ? 0.0f : drawable.getMinWidth(), drawable2 == null ? 0.0f : drawable2.getMinWidth());
        }
        return 140.0f;
    }

    @Override
    public float getPrefHeight() {
        if (this.vertical) {
            return 140.0f;
        }
        Drawable drawable = this.style.knob;
        Drawable drawable2 = this.getBackgroundDrawable();
        return Math.max(drawable == null ? 0.0f : drawable.getMinHeight(), drawable2 == null ? 0.0f : drawable2.getMinHeight());
    }

    public float getMinValue() {
        return this.min;
    }

    public float getMaxValue() {
        return this.max;
    }

    public float getStepSize() {
        return this.stepSize;
    }

    public void setAnimateDuration(float f2) {
        this.animateDuration = f2;
    }

    public void setAnimateInterpolation(Interpolation interpolation) {
        if (interpolation == null) {
            throw new IllegalArgumentException("animateInterpolation cannot be null.");
        }
        this.animateInterpolation = interpolation;
    }

    public void setVisualInterpolation(Interpolation interpolation) {
        this.visualInterpolation = interpolation;
    }

    public void setRound(boolean bl2) {
        this.round = bl2;
    }

    @Override
    public void setDisabled(boolean bl2) {
        this.disabled = bl2;
    }

    public boolean isAnimating() {
        return this.animateTime > 0.0f;
    }

    @Override
    public boolean isDisabled() {
        return this.disabled;
    }

    public boolean isVertical() {
        return this.vertical;
    }

    public void setProgrammaticChangeEvents(boolean bl2) {
        this.programmaticChangeEvents = bl2;
    }

    public static class ProgressBarStyle {
        @Null
        public Drawable background;
        @Null
        public Drawable disabledBackground;
        @Null
        public Drawable knob;
        @Null
        public Drawable disabledKnob;
        @Null
        public Drawable knobBefore;
        @Null
        public Drawable disabledKnobBefore;
        @Null
        public Drawable knobAfter;
        @Null
        public Drawable disabledKnobAfter;

        public ProgressBarStyle() {
        }

        public ProgressBarStyle(@Null Drawable drawable, @Null Drawable drawable2) {
            this.background = drawable;
            this.knob = drawable2;
        }

        public ProgressBarStyle(ProgressBarStyle progressBarStyle) {
            this.background = progressBarStyle.background;
            this.disabledBackground = progressBarStyle.disabledBackground;
            this.knob = progressBarStyle.knob;
            this.disabledKnob = progressBarStyle.disabledKnob;
            this.knobBefore = progressBarStyle.knobBefore;
            this.disabledKnobBefore = progressBarStyle.disabledKnobBefore;
            this.knobAfter = progressBarStyle.knobAfter;
            this.disabledKnobAfter = progressBarStyle.disabledKnobAfter;
        }
    }
}

