/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Value;
import com.badlogic.gdx.scenes.scene2d.ui.WidgetGroup;
import com.badlogic.gdx.scenes.scene2d.utils.Cullable;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.Layout;
import com.badlogic.gdx.utils.Null;

public class Container<T extends Actor>
extends WidgetGroup {
    @Null
    private T actor;
    private Value minWidth = Value.minWidth;
    private Value minHeight = Value.minHeight;
    private Value prefWidth = Value.prefWidth;
    private Value prefHeight = Value.prefHeight;
    private Value maxWidth = Value.zero;
    private Value maxHeight = Value.zero;
    private Value padTop = Value.zero;
    private Value padLeft = Value.zero;
    private Value padBottom = Value.zero;
    private Value padRight = Value.zero;
    private float fillX;
    private float fillY;
    private int align;
    @Null
    private Drawable background;
    private boolean clip;
    private boolean round = true;

    public Container() {
        this.setTouchable(Touchable.childrenOnly);
        this.setTransform(false);
    }

    public Container(@Null T t2) {
        this();
        this.setActor(t2);
    }

    @Override
    public void draw(Batch batch, float f2) {
        this.validate();
        if (this.isTransform()) {
            this.applyTransform(batch, this.computeTransform());
            this.drawBackground(batch, f2, 0.0f, 0.0f);
            if (this.clip) {
                batch.flush();
                float f3 = this.padLeft.get(this);
                float f4 = this.padBottom.get(this);
                if (this.clipBegin(f3, f4, this.getWidth() - f3 - this.padRight.get(this), this.getHeight() - f4 - this.padTop.get(this))) {
                    this.drawChildren(batch, f2);
                    batch.flush();
                    this.clipEnd();
                }
            } else {
                this.drawChildren(batch, f2);
            }
            this.resetTransform(batch);
        } else {
            this.drawBackground(batch, f2, this.getX(), this.getY());
            super.draw(batch, f2);
        }
    }

    protected void drawBackground(Batch batch, float f2, float f3, float f4) {
        if (this.background == null) {
            return;
        }
        Color color = this.getColor();
        batch.setColor(color.r, color.g, color.b, color.a * f2);
        this.background.draw(batch, f3, f4, this.getWidth(), this.getHeight());
    }

    public void setBackground(@Null Drawable drawable) {
        this.setBackground(drawable, true);
    }

    public void setBackground(@Null Drawable drawable, boolean bl2) {
        if (this.background == drawable) {
            return;
        }
        this.background = drawable;
        if (bl2) {
            if (drawable == null) {
                this.pad(Value.zero);
            } else {
                this.pad(drawable.getTopHeight(), drawable.getLeftWidth(), drawable.getBottomHeight(), drawable.getRightWidth());
            }
            this.invalidate();
        }
    }

    public Container<T> background(@Null Drawable drawable) {
        this.setBackground(drawable);
        return this;
    }

    @Null
    public Drawable getBackground() {
        return this.background;
    }

    @Override
    public void layout() {
        float f2;
        if (this.actor == null) {
            return;
        }
        float f3 = this.padLeft.get(this);
        float f4 = this.padBottom.get(this);
        float f5 = this.getWidth() - f3 - this.padRight.get(this);
        float f6 = this.getHeight() - f4 - this.padTop.get(this);
        float f7 = this.minWidth.get((Actor)this.actor);
        float f8 = this.minHeight.get((Actor)this.actor);
        float f9 = this.prefWidth.get((Actor)this.actor);
        float f10 = this.prefHeight.get((Actor)this.actor);
        float f11 = this.maxWidth.get((Actor)this.actor);
        float f12 = this.maxHeight.get((Actor)this.actor);
        float f13 = this.fillX > 0.0f ? f5 * this.fillX : Math.min(f9, f5);
        if (f13 < f7) {
            f13 = f7;
        }
        if (f11 > 0.0f && f13 > f11) {
            f13 = f11;
        }
        if ((f2 = this.fillY > 0.0f ? f6 * this.fillY : Math.min(f10, f6)) < f8) {
            f2 = f8;
        }
        if (f12 > 0.0f && f2 > f12) {
            f2 = f12;
        }
        float f14 = f3;
        if ((this.align & 0x10) != 0) {
            f14 += f5 - f13;
        } else if ((this.align & 8) == 0) {
            f14 += (f5 - f13) / 2.0f;
        }
        float f15 = f4;
        if ((this.align & 2) != 0) {
            f15 += f6 - f2;
        } else if ((this.align & 4) == 0) {
            f15 += (f6 - f2) / 2.0f;
        }
        if (this.round) {
            f14 = Math.round(f14);
            f15 = Math.round(f15);
            f13 = Math.round(f13);
            f2 = Math.round(f2);
        }
        ((Actor)this.actor).setBounds(f14, f15, f13, f2);
        if (this.actor instanceof Layout) {
            ((Layout)this.actor).validate();
        }
    }

    @Override
    public void setCullingArea(Rectangle rectangle) {
        super.setCullingArea(rectangle);
        if (this.fillX == 1.0f && this.fillY == 1.0f && this.actor instanceof Cullable) {
            ((Cullable)this.actor).setCullingArea(rectangle);
        }
    }

    public void setActor(@Null T t2) {
        if (t2 == this) {
            throw new IllegalArgumentException("actor cannot be the Container.");
        }
        if (t2 == this.actor) {
            return;
        }
        if (this.actor != null) {
            super.removeActor((Actor)this.actor);
        }
        this.actor = t2;
        if (t2 != null) {
            super.addActor((Actor)t2);
        }
    }

    @Null
    public T getActor() {
        return this.actor;
    }

    @Override
    @Deprecated
    public void addActor(Actor actor) {
        throw new UnsupportedOperationException("Use Container#setActor.");
    }

    @Override
    @Deprecated
    public void addActorAt(int n2, Actor actor) {
        throw new UnsupportedOperationException("Use Container#setActor.");
    }

    @Override
    @Deprecated
    public void addActorBefore(Actor actor, Actor actor2) {
        throw new UnsupportedOperationException("Use Container#setActor.");
    }

    @Override
    @Deprecated
    public void addActorAfter(Actor actor, Actor actor2) {
        throw new UnsupportedOperationException("Use Container#setActor.");
    }

    @Override
    public boolean removeActor(Actor actor) {
        if (actor == null) {
            throw new IllegalArgumentException("actor cannot be null.");
        }
        if (actor != this.actor) {
            return false;
        }
        this.setActor(null);
        return true;
    }

    @Override
    public boolean removeActor(Actor actor, boolean bl2) {
        if (actor == null) {
            throw new IllegalArgumentException("actor cannot be null.");
        }
        if (actor != this.actor) {
            return false;
        }
        this.actor = null;
        return super.removeActor(actor, bl2);
    }

    @Override
    public Actor removeActorAt(int n2, boolean bl2) {
        Actor actor = super.removeActorAt(n2, bl2);
        if (actor == this.actor) {
            this.actor = null;
        }
        return actor;
    }

    public Container<T> size(Value value) {
        if (value == null) {
            throw new IllegalArgumentException("size cannot be null.");
        }
        this.minWidth = value;
        this.minHeight = value;
        this.prefWidth = value;
        this.prefHeight = value;
        this.maxWidth = value;
        this.maxHeight = value;
        return this;
    }

    public Container<T> size(Value value, Value value2) {
        if (value == null) {
            throw new IllegalArgumentException("width cannot be null.");
        }
        if (value2 == null) {
            throw new IllegalArgumentException("height cannot be null.");
        }
        this.minWidth = value;
        this.minHeight = value2;
        this.prefWidth = value;
        this.prefHeight = value2;
        this.maxWidth = value;
        this.maxHeight = value2;
        return this;
    }

    public Container<T> size(float f2) {
        this.size(Value.Fixed.valueOf(f2));
        return this;
    }

    public Container<T> size(float f2, float f3) {
        this.size(Value.Fixed.valueOf(f2), Value.Fixed.valueOf(f3));
        return this;
    }

    public Container<T> width(Value value) {
        if (value == null) {
            throw new IllegalArgumentException("width cannot be null.");
        }
        this.minWidth = value;
        this.prefWidth = value;
        this.maxWidth = value;
        return this;
    }

    public Container<T> width(float f2) {
        this.width(Value.Fixed.valueOf(f2));
        return this;
    }

    public Container<T> height(Value value) {
        if (value == null) {
            throw new IllegalArgumentException("height cannot be null.");
        }
        this.minHeight = value;
        this.prefHeight = value;
        this.maxHeight = value;
        return this;
    }

    public Container<T> height(float f2) {
        this.height(Value.Fixed.valueOf(f2));
        return this;
    }

    public Container<T> minSize(Value value) {
        if (value == null) {
            throw new IllegalArgumentException("size cannot be null.");
        }
        this.minWidth = value;
        this.minHeight = value;
        return this;
    }

    public Container<T> minSize(Value value, Value value2) {
        if (value == null) {
            throw new IllegalArgumentException("width cannot be null.");
        }
        if (value2 == null) {
            throw new IllegalArgumentException("height cannot be null.");
        }
        this.minWidth = value;
        this.minHeight = value2;
        return this;
    }

    public Container<T> minWidth(Value value) {
        if (value == null) {
            throw new IllegalArgumentException("minWidth cannot be null.");
        }
        this.minWidth = value;
        return this;
    }

    public Container<T> minHeight(Value value) {
        if (value == null) {
            throw new IllegalArgumentException("minHeight cannot be null.");
        }
        this.minHeight = value;
        return this;
    }

    public Container<T> minSize(float f2) {
        this.minSize(Value.Fixed.valueOf(f2));
        return this;
    }

    public Container<T> minSize(float f2, float f3) {
        this.minSize(Value.Fixed.valueOf(f2), Value.Fixed.valueOf(f3));
        return this;
    }

    public Container<T> minWidth(float f2) {
        this.minWidth = Value.Fixed.valueOf(f2);
        return this;
    }

    public Container<T> minHeight(float f2) {
        this.minHeight = Value.Fixed.valueOf(f2);
        return this;
    }

    public Container<T> prefSize(Value value) {
        if (value == null) {
            throw new IllegalArgumentException("size cannot be null.");
        }
        this.prefWidth = value;
        this.prefHeight = value;
        return this;
    }

    public Container<T> prefSize(Value value, Value value2) {
        if (value == null) {
            throw new IllegalArgumentException("width cannot be null.");
        }
        if (value2 == null) {
            throw new IllegalArgumentException("height cannot be null.");
        }
        this.prefWidth = value;
        this.prefHeight = value2;
        return this;
    }

    public Container<T> prefWidth(Value value) {
        if (value == null) {
            throw new IllegalArgumentException("prefWidth cannot be null.");
        }
        this.prefWidth = value;
        return this;
    }

    public Container<T> prefHeight(Value value) {
        if (value == null) {
            throw new IllegalArgumentException("prefHeight cannot be null.");
        }
        this.prefHeight = value;
        return this;
    }

    public Container<T> prefSize(float f2, float f3) {
        this.prefSize(Value.Fixed.valueOf(f2), Value.Fixed.valueOf(f3));
        return this;
    }

    public Container<T> prefSize(float f2) {
        this.prefSize(Value.Fixed.valueOf(f2));
        return this;
    }

    public Container<T> prefWidth(float f2) {
        this.prefWidth = Value.Fixed.valueOf(f2);
        return this;
    }

    public Container<T> prefHeight(float f2) {
        this.prefHeight = Value.Fixed.valueOf(f2);
        return this;
    }

    public Container<T> maxSize(Value value) {
        if (value == null) {
            throw new IllegalArgumentException("size cannot be null.");
        }
        this.maxWidth = value;
        this.maxHeight = value;
        return this;
    }

    public Container<T> maxSize(Value value, Value value2) {
        if (value == null) {
            throw new IllegalArgumentException("width cannot be null.");
        }
        if (value2 == null) {
            throw new IllegalArgumentException("height cannot be null.");
        }
        this.maxWidth = value;
        this.maxHeight = value2;
        return this;
    }

    public Container<T> maxWidth(Value value) {
        if (value == null) {
            throw new IllegalArgumentException("maxWidth cannot be null.");
        }
        this.maxWidth = value;
        return this;
    }

    public Container<T> maxHeight(Value value) {
        if (value == null) {
            throw new IllegalArgumentException("maxHeight cannot be null.");
        }
        this.maxHeight = value;
        return this;
    }

    public Container<T> maxSize(float f2) {
        this.maxSize(Value.Fixed.valueOf(f2));
        return this;
    }

    public Container<T> maxSize(float f2, float f3) {
        this.maxSize(Value.Fixed.valueOf(f2), Value.Fixed.valueOf(f3));
        return this;
    }

    public Container<T> maxWidth(float f2) {
        this.maxWidth = Value.Fixed.valueOf(f2);
        return this;
    }

    public Container<T> maxHeight(float f2) {
        this.maxHeight = Value.Fixed.valueOf(f2);
        return this;
    }

    public Container<T> pad(Value value) {
        if (value == null) {
            throw new IllegalArgumentException("pad cannot be null.");
        }
        this.padTop = value;
        this.padLeft = value;
        this.padBottom = value;
        this.padRight = value;
        return this;
    }

    public Container<T> pad(Value value, Value value2, Value value3, Value value4) {
        if (value == null) {
            throw new IllegalArgumentException("top cannot be null.");
        }
        if (value2 == null) {
            throw new IllegalArgumentException("left cannot be null.");
        }
        if (value3 == null) {
            throw new IllegalArgumentException("bottom cannot be null.");
        }
        if (value4 == null) {
            throw new IllegalArgumentException("right cannot be null.");
        }
        this.padTop = value;
        this.padLeft = value2;
        this.padBottom = value3;
        this.padRight = value4;
        return this;
    }

    public Container<T> padTop(Value value) {
        if (value == null) {
            throw new IllegalArgumentException("padTop cannot be null.");
        }
        this.padTop = value;
        return this;
    }

    public Container<T> padLeft(Value value) {
        if (value == null) {
            throw new IllegalArgumentException("padLeft cannot be null.");
        }
        this.padLeft = value;
        return this;
    }

    public Container<T> padBottom(Value value) {
        if (value == null) {
            throw new IllegalArgumentException("padBottom cannot be null.");
        }
        this.padBottom = value;
        return this;
    }

    public Container<T> padRight(Value value) {
        if (value == null) {
            throw new IllegalArgumentException("padRight cannot be null.");
        }
        this.padRight = value;
        return this;
    }

    public Container<T> pad(float f2) {
        Value.Fixed fixed = Value.Fixed.valueOf(f2);
        this.padTop = fixed;
        this.padLeft = fixed;
        this.padBottom = fixed;
        this.padRight = fixed;
        return this;
    }

    public Container<T> pad(float f2, float f3, float f4, float f5) {
        this.padTop = Value.Fixed.valueOf(f2);
        this.padLeft = Value.Fixed.valueOf(f3);
        this.padBottom = Value.Fixed.valueOf(f4);
        this.padRight = Value.Fixed.valueOf(f5);
        return this;
    }

    public Container<T> padTop(float f2) {
        this.padTop = Value.Fixed.valueOf(f2);
        return this;
    }

    public Container<T> padLeft(float f2) {
        this.padLeft = Value.Fixed.valueOf(f2);
        return this;
    }

    public Container<T> padBottom(float f2) {
        this.padBottom = Value.Fixed.valueOf(f2);
        return this;
    }

    public Container<T> padRight(float f2) {
        this.padRight = Value.Fixed.valueOf(f2);
        return this;
    }

    public Container<T> fill() {
        this.fillX = 1.0f;
        this.fillY = 1.0f;
        return this;
    }

    public Container<T> fillX() {
        this.fillX = 1.0f;
        return this;
    }

    public Container<T> fillY() {
        this.fillY = 1.0f;
        return this;
    }

    public Container<T> fill(float f2, float f3) {
        this.fillX = f2;
        this.fillY = f3;
        return this;
    }

    public Container<T> fill(boolean bl2, boolean bl3) {
        this.fillX = bl2 ? 1.0f : 0.0f;
        this.fillY = bl3 ? 1.0f : 0.0f;
        return this;
    }

    public Container<T> fill(boolean bl2) {
        this.fillX = bl2 ? 1.0f : 0.0f;
        this.fillY = bl2 ? 1.0f : 0.0f;
        return this;
    }

    public Container<T> align(int n2) {
        this.align = n2;
        return this;
    }

    public Container<T> center() {
        this.align = 1;
        return this;
    }

    public Container<T> top() {
        this.align |= 2;
        this.align &= 0xFFFFFFFB;
        return this;
    }

    public Container<T> left() {
        this.align |= 8;
        this.align &= 0xFFFFFFEF;
        return this;
    }

    public Container<T> bottom() {
        this.align |= 4;
        this.align &= 0xFFFFFFFD;
        return this;
    }

    public Container<T> right() {
        this.align |= 0x10;
        this.align &= 0xFFFFFFF7;
        return this;
    }

    @Override
    public float getMinWidth() {
        return this.minWidth.get((Actor)this.actor) + this.padLeft.get(this) + this.padRight.get(this);
    }

    public Value getMinHeightValue() {
        return this.minHeight;
    }

    @Override
    public float getMinHeight() {
        return this.minHeight.get((Actor)this.actor) + this.padTop.get(this) + this.padBottom.get(this);
    }

    public Value getPrefWidthValue() {
        return this.prefWidth;
    }

    @Override
    public float getPrefWidth() {
        float f2 = this.prefWidth.get((Actor)this.actor);
        if (this.background != null) {
            f2 = Math.max(f2, this.background.getMinWidth());
        }
        return Math.max(this.getMinWidth(), f2 + this.padLeft.get(this) + this.padRight.get(this));
    }

    public Value getPrefHeightValue() {
        return this.prefHeight;
    }

    @Override
    public float getPrefHeight() {
        float f2 = this.prefHeight.get((Actor)this.actor);
        if (this.background != null) {
            f2 = Math.max(f2, this.background.getMinHeight());
        }
        return Math.max(this.getMinHeight(), f2 + this.padTop.get(this) + this.padBottom.get(this));
    }

    public Value getMaxWidthValue() {
        return this.maxWidth;
    }

    @Override
    public float getMaxWidth() {
        float f2 = this.maxWidth.get((Actor)this.actor);
        if (f2 > 0.0f) {
            f2 += this.padLeft.get(this) + this.padRight.get(this);
        }
        return f2;
    }

    public Value getMaxHeightValue() {
        return this.maxHeight;
    }

    @Override
    public float getMaxHeight() {
        float f2 = this.maxHeight.get((Actor)this.actor);
        if (f2 > 0.0f) {
            f2 += this.padTop.get(this) + this.padBottom.get(this);
        }
        return f2;
    }

    public Value getPadTopValue() {
        return this.padTop;
    }

    public float getPadTop() {
        return this.padTop.get(this);
    }

    public Value getPadLeftValue() {
        return this.padLeft;
    }

    public float getPadLeft() {
        return this.padLeft.get(this);
    }

    public Value getPadBottomValue() {
        return this.padBottom;
    }

    public float getPadBottom() {
        return this.padBottom.get(this);
    }

    public Value getPadRightValue() {
        return this.padRight;
    }

    public float getPadRight() {
        return this.padRight.get(this);
    }

    public float getPadX() {
        return this.padLeft.get(this) + this.padRight.get(this);
    }

    public float getPadY() {
        return this.padTop.get(this) + this.padBottom.get(this);
    }

    public float getFillX() {
        return this.fillX;
    }

    public float getFillY() {
        return this.fillY;
    }

    public int getAlign() {
        return this.align;
    }

    public void setRound(boolean bl2) {
        this.round = bl2;
    }

    public Container<T> clip() {
        this.setClip(true);
        return this;
    }

    public Container<T> clip(boolean bl2) {
        this.setClip(bl2);
        return this;
    }

    public void setClip(boolean bl2) {
        this.clip = bl2;
        this.setTransform(bl2);
        this.invalidate();
    }

    public boolean getClip() {
        return this.clip;
    }

    @Override
    @Null
    public Actor hit(float f2, float f3, boolean bl2) {
        if (this.clip) {
            if (bl2 && this.getTouchable() == Touchable.disabled) {
                return null;
            }
            if (f2 < 0.0f || f2 >= this.getWidth() || f3 < 0.0f || f3 >= this.getHeight()) {
                return null;
            }
        }
        return super.hit(f2, f3, bl2);
    }

    @Override
    public void drawDebug(ShapeRenderer shapeRenderer) {
        this.validate();
        if (this.isTransform()) {
            this.applyTransform(shapeRenderer, this.computeTransform());
            if (this.clip) {
                boolean bl2;
                shapeRenderer.flush();
                float f2 = this.padLeft.get(this);
                float f3 = this.padBottom.get(this);
                boolean bl3 = bl2 = this.background == null ? this.clipBegin(0.0f, 0.0f, this.getWidth(), this.getHeight()) : this.clipBegin(f2, f3, this.getWidth() - f2 - this.padRight.get(this), this.getHeight() - f3 - this.padTop.get(this));
                if (bl2) {
                    this.drawDebugChildren(shapeRenderer);
                    this.clipEnd();
                }
            } else {
                this.drawDebugChildren(shapeRenderer);
            }
            this.resetTransform(shapeRenderer);
        } else {
            super.drawDebug(shapeRenderer);
        }
    }
}

