/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.Null;
import com.badlogic.gdx.utils.Pools;

public class Slider
extends ProgressBar {
    int button = -1;
    int draggingPointer = -1;
    boolean mouseOver;
    private Interpolation visualInterpolationInverse = Interpolation.linear;
    private float[] snapValues;
    private float threshold;

    public Slider(float f2, float f3, float f4, boolean bl2, Skin skin) {
        this(f2, f3, f4, bl2, skin.get("default-" + (bl2 ? "vertical" : "horizontal"), SliderStyle.class));
    }

    public Slider(float f2, float f3, float f4, boolean bl2, Skin skin, String string) {
        this(f2, f3, f4, bl2, skin.get(string, SliderStyle.class));
    }

    public Slider(float f2, float f3, float f4, boolean bl2, SliderStyle sliderStyle) {
        super(f2, f3, f4, bl2, sliderStyle);
        this.addListener(new InputListener(){

            @Override
            public boolean touchDown(InputEvent inputEvent, float f2, float f3, int n2, int n3) {
                if (Slider.this.disabled) {
                    return false;
                }
                if (Slider.this.button != -1 && Slider.this.button != n3) {
                    return false;
                }
                if (Slider.this.draggingPointer != -1) {
                    return false;
                }
                Slider.this.draggingPointer = n2;
                Slider.this.calculatePositionAndValue(f2, f3);
                return true;
            }

            @Override
            public void touchUp(InputEvent inputEvent, float f2, float f3, int n2, int n3) {
                if (n2 != Slider.this.draggingPointer) {
                    return;
                }
                Slider.this.draggingPointer = -1;
                if (inputEvent.isTouchFocusCancel() || !Slider.this.calculatePositionAndValue(f2, f3)) {
                    ChangeListener.ChangeEvent changeEvent = Pools.obtain(ChangeListener.ChangeEvent.class);
                    Slider.this.fire(changeEvent);
                    Pools.free(changeEvent);
                }
            }

            @Override
            public void touchDragged(InputEvent inputEvent, float f2, float f3, int n2) {
                Slider.this.calculatePositionAndValue(f2, f3);
            }

            @Override
            public void enter(InputEvent inputEvent, float f2, float f3, int n2, @Null Actor actor) {
                if (n2 == -1) {
                    Slider.this.mouseOver = true;
                }
            }

            @Override
            public void exit(InputEvent inputEvent, float f2, float f3, int n2, @Null Actor actor) {
                if (n2 == -1) {
                    Slider.this.mouseOver = false;
                }
            }
        });
    }

    @Override
    public SliderStyle getStyle() {
        return (SliderStyle)super.getStyle();
    }

    public boolean isOver() {
        return this.mouseOver;
    }

    @Override
    @Null
    protected Drawable getBackgroundDrawable() {
        SliderStyle sliderStyle = (SliderStyle)super.getStyle();
        if (this.disabled && sliderStyle.disabledBackground != null) {
            return sliderStyle.disabledBackground;
        }
        if (this.isDragging() && sliderStyle.backgroundDown != null) {
            return sliderStyle.backgroundDown;
        }
        if (this.mouseOver && sliderStyle.backgroundOver != null) {
            return sliderStyle.backgroundOver;
        }
        return sliderStyle.background;
    }

    @Override
    @Null
    protected Drawable getKnobDrawable() {
        SliderStyle sliderStyle = (SliderStyle)super.getStyle();
        if (this.disabled && sliderStyle.disabledKnob != null) {
            return sliderStyle.disabledKnob;
        }
        if (this.isDragging() && sliderStyle.knobDown != null) {
            return sliderStyle.knobDown;
        }
        if (this.mouseOver && sliderStyle.knobOver != null) {
            return sliderStyle.knobOver;
        }
        return sliderStyle.knob;
    }

    @Override
    protected Drawable getKnobBeforeDrawable() {
        SliderStyle sliderStyle = (SliderStyle)super.getStyle();
        if (this.disabled && sliderStyle.disabledKnobBefore != null) {
            return sliderStyle.disabledKnobBefore;
        }
        if (this.isDragging() && sliderStyle.knobBeforeDown != null) {
            return sliderStyle.knobBeforeDown;
        }
        if (this.mouseOver && sliderStyle.knobBeforeOver != null) {
            return sliderStyle.knobBeforeOver;
        }
        return sliderStyle.knobBefore;
    }

    @Override
    protected Drawable getKnobAfterDrawable() {
        SliderStyle sliderStyle = (SliderStyle)super.getStyle();
        if (this.disabled && sliderStyle.disabledKnobAfter != null) {
            return sliderStyle.disabledKnobAfter;
        }
        if (this.isDragging() && sliderStyle.knobAfterDown != null) {
            return sliderStyle.knobAfterDown;
        }
        if (this.mouseOver && sliderStyle.knobAfterOver != null) {
            return sliderStyle.knobAfterOver;
        }
        return sliderStyle.knobAfter;
    }

    boolean calculatePositionAndValue(float f2, float f3) {
        float f4;
        float f5;
        float f6;
        SliderStyle sliderStyle = this.getStyle();
        Drawable drawable = sliderStyle.knob;
        Drawable drawable2 = this.getBackgroundDrawable();
        float f7 = this.position;
        float f8 = this.getMinValue();
        float f9 = this.getMaxValue();
        if (this.vertical) {
            f6 = this.getHeight() - drawable2.getTopHeight() - drawable2.getBottomHeight();
            f5 = drawable == null ? 0.0f : drawable.getMinHeight();
            this.position = f3 - drawable2.getBottomHeight() - f5 * 0.5f;
            f4 = f8 + (f9 - f8) * this.visualInterpolationInverse.apply(this.position / (f6 - f5));
            this.position = Math.max(Math.min(0.0f, drawable2.getBottomHeight()), this.position);
            this.position = Math.min(f6 - f5, this.position);
        } else {
            f6 = this.getWidth() - drawable2.getLeftWidth() - drawable2.getRightWidth();
            f5 = drawable == null ? 0.0f : drawable.getMinWidth();
            this.position = f2 - drawable2.getLeftWidth() - f5 * 0.5f;
            f4 = f8 + (f9 - f8) * this.visualInterpolationInverse.apply(this.position / (f6 - f5));
            this.position = Math.max(Math.min(0.0f, drawable2.getLeftWidth()), this.position);
            this.position = Math.min(f6 - f5, this.position);
        }
        f6 = f4;
        if (!Gdx.input.isKeyPressed(59) && !Gdx.input.isKeyPressed(60)) {
            f4 = this.snap(f4);
        }
        boolean bl2 = this.setValue(f4);
        if (f4 == f6) {
            this.position = f7;
        }
        return bl2;
    }

    protected float snap(float f2) {
        if (this.snapValues == null || this.snapValues.length == 0) {
            return f2;
        }
        float f3 = -1.0f;
        float f4 = 0.0f;
        for (int i2 = 0; i2 < this.snapValues.length; ++i2) {
            float f5 = this.snapValues[i2];
            float f6 = Math.abs(f2 - f5);
            if (!(f6 <= this.threshold) || f3 != -1.0f && !(f6 < f3)) continue;
            f3 = f6;
            f4 = f5;
        }
        return f3 == -1.0f ? f2 : f4;
    }

    public void setSnapToValues(@Null float[] fArray, float f2) {
        this.snapValues = fArray;
        this.threshold = f2;
    }

    public boolean isDragging() {
        return this.draggingPointer != -1;
    }

    public void setButton(int n2) {
        this.button = n2;
    }

    public void setVisualInterpolationInverse(Interpolation interpolation) {
        this.visualInterpolationInverse = interpolation;
    }

    public void setVisualPercent(float f2) {
        this.setValue(this.min + (this.max - this.min) * this.visualInterpolationInverse.apply(f2));
    }

    public static class SliderStyle
    extends ProgressBar.ProgressBarStyle {
        @Null
        public Drawable backgroundOver;
        @Null
        public Drawable backgroundDown;
        @Null
        public Drawable knobOver;
        @Null
        public Drawable knobDown;
        @Null
        public Drawable knobBeforeOver;
        @Null
        public Drawable knobBeforeDown;
        @Null
        public Drawable knobAfterOver;
        @Null
        public Drawable knobAfterDown;

        public SliderStyle() {
        }

        public SliderStyle(@Null Drawable drawable, @Null Drawable drawable2) {
            super(drawable, drawable2);
        }

        public SliderStyle(SliderStyle sliderStyle) {
            super(sliderStyle);
            this.backgroundOver = sliderStyle.backgroundOver;
            this.backgroundDown = sliderStyle.backgroundDown;
            this.knobOver = sliderStyle.knobOver;
            this.knobDown = sliderStyle.knobDown;
            this.knobBeforeOver = sliderStyle.knobBeforeOver;
            this.knobBeforeDown = sliderStyle.knobBeforeDown;
            this.knobAfterOver = sliderStyle.knobAfterOver;
            this.knobAfterDown = sliderStyle.knobAfterDown;
        }
    }
}

