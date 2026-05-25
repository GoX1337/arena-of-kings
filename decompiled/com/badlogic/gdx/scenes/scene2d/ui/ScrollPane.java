/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.WidgetGroup;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.badlogic.gdx.scenes.scene2d.utils.Cullable;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.Layout;
import com.badlogic.gdx.utils.Null;

public class ScrollPane
extends WidgetGroup {
    private ScrollPaneStyle style;
    private Actor widget;
    final Rectangle widgetArea = new Rectangle();
    final Rectangle hScrollBounds = new Rectangle();
    final Rectangle hKnobBounds = new Rectangle();
    final Rectangle vScrollBounds = new Rectangle();
    final Rectangle vKnobBounds = new Rectangle();
    private final Rectangle widgetCullingArea = new Rectangle();
    private ActorGestureListener flickScrollListener;
    boolean scrollX;
    boolean scrollY;
    boolean vScrollOnRight = true;
    boolean hScrollOnBottom = true;
    float amountX;
    float amountY;
    float visualAmountX;
    float visualAmountY;
    float maxX;
    float maxY;
    boolean touchScrollH;
    boolean touchScrollV;
    final Vector2 lastPoint = new Vector2();
    boolean fadeScrollBars = true;
    boolean smoothScrolling = true;
    boolean scrollBarTouch = true;
    float fadeAlpha;
    float fadeAlphaSeconds = 1.0f;
    float fadeDelay;
    float fadeDelaySeconds = 1.0f;
    boolean cancelTouchFocus = true;
    boolean flickScroll = true;
    float flingTime = 1.0f;
    float flingTimer;
    float velocityX;
    float velocityY;
    private boolean overscrollX = true;
    private boolean overscrollY = true;
    private float overscrollDistance = 50.0f;
    private float overscrollSpeedMin = 30.0f;
    private float overscrollSpeedMax = 200.0f;
    private boolean forceScrollX;
    private boolean forceScrollY;
    boolean disableX;
    boolean disableY;
    private boolean clamp = true;
    private boolean scrollbarsOnTop;
    private boolean variableSizeKnobs = true;
    int draggingPointer = -1;

    public ScrollPane(@Null Actor actor) {
        this(actor, new ScrollPaneStyle());
    }

    public ScrollPane(@Null Actor actor, Skin skin) {
        this(actor, skin.get(ScrollPaneStyle.class));
    }

    public ScrollPane(@Null Actor actor, Skin skin, String string) {
        this(actor, skin.get(string, ScrollPaneStyle.class));
    }

    public ScrollPane(@Null Actor actor, ScrollPaneStyle scrollPaneStyle) {
        if (scrollPaneStyle == null) {
            throw new IllegalArgumentException("style cannot be null.");
        }
        this.style = scrollPaneStyle;
        this.setActor(actor);
        this.setSize(150.0f, 150.0f);
        this.addCaptureListener();
        this.flickScrollListener = this.getFlickScrollListener();
        this.addListener(this.flickScrollListener);
        this.addScrollListener();
    }

    protected void addCaptureListener() {
        this.addCaptureListener(new InputListener(){
            private float handlePosition;

            @Override
            public boolean touchDown(InputEvent inputEvent, float f2, float f3, int n2, int n3) {
                if (ScrollPane.this.draggingPointer != -1) {
                    return false;
                }
                if (n2 == 0 && n3 != 0) {
                    return false;
                }
                if (ScrollPane.this.getStage() != null) {
                    ScrollPane.this.getStage().setScrollFocus(ScrollPane.this);
                }
                if (!ScrollPane.this.flickScroll) {
                    ScrollPane.this.setScrollbarsVisible(true);
                }
                if (ScrollPane.this.fadeAlpha == 0.0f) {
                    return false;
                }
                if (ScrollPane.this.scrollBarTouch && ScrollPane.this.scrollX && ScrollPane.this.hScrollBounds.contains(f2, f3)) {
                    inputEvent.stop();
                    ScrollPane.this.setScrollbarsVisible(true);
                    if (ScrollPane.this.hKnobBounds.contains(f2, f3)) {
                        ScrollPane.this.lastPoint.set(f2, f3);
                        this.handlePosition = ScrollPane.this.hKnobBounds.x;
                        ScrollPane.this.touchScrollH = true;
                        ScrollPane.this.draggingPointer = n2;
                        return true;
                    }
                    ScrollPane.this.setScrollX(ScrollPane.this.amountX + ScrollPane.this.widgetArea.width * (float)(f2 < ScrollPane.this.hKnobBounds.x ? -1 : 1));
                    return true;
                }
                if (ScrollPane.this.scrollBarTouch && ScrollPane.this.scrollY && ScrollPane.this.vScrollBounds.contains(f2, f3)) {
                    inputEvent.stop();
                    ScrollPane.this.setScrollbarsVisible(true);
                    if (ScrollPane.this.vKnobBounds.contains(f2, f3)) {
                        ScrollPane.this.lastPoint.set(f2, f3);
                        this.handlePosition = ScrollPane.this.vKnobBounds.y;
                        ScrollPane.this.touchScrollV = true;
                        ScrollPane.this.draggingPointer = n2;
                        return true;
                    }
                    ScrollPane.this.setScrollY(ScrollPane.this.amountY + ScrollPane.this.widgetArea.height * (float)(f3 < ScrollPane.this.vKnobBounds.y ? 1 : -1));
                    return true;
                }
                return false;
            }

            @Override
            public void touchUp(InputEvent inputEvent, float f2, float f3, int n2, int n3) {
                if (n2 != ScrollPane.this.draggingPointer) {
                    return;
                }
                ScrollPane.this.cancel();
            }

            @Override
            public void touchDragged(InputEvent inputEvent, float f2, float f3, int n2) {
                if (n2 != ScrollPane.this.draggingPointer) {
                    return;
                }
                if (ScrollPane.this.touchScrollH) {
                    float f4;
                    float f5 = f2 - ScrollPane.this.lastPoint.x;
                    this.handlePosition = f4 = this.handlePosition + f5;
                    f4 = Math.max(ScrollPane.this.hScrollBounds.x, f4);
                    f4 = Math.min(ScrollPane.this.hScrollBounds.x + ScrollPane.this.hScrollBounds.width - ScrollPane.this.hKnobBounds.width, f4);
                    float f6 = ScrollPane.this.hScrollBounds.width - ScrollPane.this.hKnobBounds.width;
                    if (f6 != 0.0f) {
                        ScrollPane.this.setScrollPercentX((f4 - ScrollPane.this.hScrollBounds.x) / f6);
                    }
                    ScrollPane.this.lastPoint.set(f2, f3);
                } else if (ScrollPane.this.touchScrollV) {
                    float f7;
                    float f8 = f3 - ScrollPane.this.lastPoint.y;
                    this.handlePosition = f7 = this.handlePosition + f8;
                    f7 = Math.max(ScrollPane.this.vScrollBounds.y, f7);
                    f7 = Math.min(ScrollPane.this.vScrollBounds.y + ScrollPane.this.vScrollBounds.height - ScrollPane.this.vKnobBounds.height, f7);
                    float f9 = ScrollPane.this.vScrollBounds.height - ScrollPane.this.vKnobBounds.height;
                    if (f9 != 0.0f) {
                        ScrollPane.this.setScrollPercentY(1.0f - (f7 - ScrollPane.this.vScrollBounds.y) / f9);
                    }
                    ScrollPane.this.lastPoint.set(f2, f3);
                }
            }

            @Override
            public boolean mouseMoved(InputEvent inputEvent, float f2, float f3) {
                if (!ScrollPane.this.flickScroll) {
                    ScrollPane.this.setScrollbarsVisible(true);
                }
                return false;
            }
        });
    }

    protected ActorGestureListener getFlickScrollListener() {
        return new ActorGestureListener(){

            @Override
            public void pan(InputEvent inputEvent, float f2, float f3, float f4, float f5) {
                ScrollPane.this.setScrollbarsVisible(true);
                if (!ScrollPane.this.scrollX) {
                    f4 = 0.0f;
                }
                if (!ScrollPane.this.scrollY) {
                    f5 = 0.0f;
                }
                ScrollPane.this.amountX -= f4;
                ScrollPane.this.amountY += f5;
                ScrollPane.this.clamp();
                if (ScrollPane.this.cancelTouchFocus && (f4 != 0.0f || f5 != 0.0f)) {
                    ScrollPane.this.cancelTouchFocus();
                }
            }

            @Override
            public void fling(InputEvent inputEvent, float f2, float f3, int n2) {
                float f4;
                float f5 = Math.abs(f2) > 150.0f && ScrollPane.this.scrollX ? f2 : 0.0f;
                float f6 = f4 = Math.abs(f3) > 150.0f && ScrollPane.this.scrollY ? -f3 : 0.0f;
                if (f5 != 0.0f || f4 != 0.0f) {
                    if (ScrollPane.this.cancelTouchFocus) {
                        ScrollPane.this.cancelTouchFocus();
                    }
                    ScrollPane.this.fling(ScrollPane.this.flingTime, f5, f4);
                }
            }

            @Override
            public boolean handle(Event event) {
                if (super.handle(event)) {
                    if (((InputEvent)event).getType() == InputEvent.Type.touchDown) {
                        ScrollPane.this.flingTimer = 0.0f;
                    }
                    return true;
                }
                if (event instanceof InputEvent && ((InputEvent)event).isTouchFocusCancel()) {
                    ScrollPane.this.cancel();
                }
                return false;
            }
        };
    }

    protected void addScrollListener() {
        this.addListener(new InputListener(){

            @Override
            public boolean scrolled(InputEvent inputEvent, float f2, float f3, float f4, float f5) {
                ScrollPane.this.setScrollbarsVisible(true);
                if (ScrollPane.this.scrollY || ScrollPane.this.scrollX) {
                    if (ScrollPane.this.scrollY) {
                        if (!ScrollPane.this.scrollX && f5 == 0.0f) {
                            f5 = f4;
                        }
                    } else if (ScrollPane.this.scrollX && f4 == 0.0f) {
                        f4 = f5;
                    }
                } else {
                    return false;
                }
                ScrollPane.this.setScrollY(ScrollPane.this.amountY + ScrollPane.this.getMouseWheelY() * f5);
                ScrollPane.this.setScrollX(ScrollPane.this.amountX + ScrollPane.this.getMouseWheelX() * f4);
                return true;
            }
        });
    }

    public void setScrollbarsVisible(boolean bl2) {
        if (bl2) {
            this.fadeAlpha = this.fadeAlphaSeconds;
            this.fadeDelay = this.fadeDelaySeconds;
        } else {
            this.fadeAlpha = 0.0f;
            this.fadeDelay = 0.0f;
        }
    }

    public void cancelTouchFocus() {
        Stage stage = this.getStage();
        if (stage != null) {
            stage.cancelTouchFocusExcept(this.flickScrollListener, this);
        }
    }

    public void cancel() {
        this.draggingPointer = -1;
        this.touchScrollH = false;
        this.touchScrollV = false;
        this.flickScrollListener.getGestureDetector().cancel();
    }

    void clamp() {
        if (!this.clamp) {
            return;
        }
        this.scrollX(this.overscrollX ? MathUtils.clamp(this.amountX, -this.overscrollDistance, this.maxX + this.overscrollDistance) : MathUtils.clamp(this.amountX, 0.0f, this.maxX));
        this.scrollY(this.overscrollY ? MathUtils.clamp(this.amountY, -this.overscrollDistance, this.maxY + this.overscrollDistance) : MathUtils.clamp(this.amountY, 0.0f, this.maxY));
    }

    public void setStyle(ScrollPaneStyle scrollPaneStyle) {
        if (scrollPaneStyle == null) {
            throw new IllegalArgumentException("style cannot be null.");
        }
        this.style = scrollPaneStyle;
        this.invalidateHierarchy();
    }

    public ScrollPaneStyle getStyle() {
        return this.style;
    }

    @Override
    public void act(float f2) {
        Stage stage;
        super.act(f2);
        boolean bl2 = this.flickScrollListener.getGestureDetector().isPanning();
        boolean bl3 = false;
        if (this.fadeAlpha > 0.0f && this.fadeScrollBars && !bl2 && !this.touchScrollH && !this.touchScrollV) {
            this.fadeDelay -= f2;
            if (this.fadeDelay <= 0.0f) {
                this.fadeAlpha = Math.max(0.0f, this.fadeAlpha - f2);
            }
            bl3 = true;
        }
        if (this.flingTimer > 0.0f) {
            this.setScrollbarsVisible(true);
            float f3 = this.flingTimer / this.flingTime;
            this.amountX -= this.velocityX * f3 * f2;
            this.amountY -= this.velocityY * f3 * f2;
            this.clamp();
            if (this.amountX == -this.overscrollDistance) {
                this.velocityX = 0.0f;
            }
            if (this.amountX >= this.maxX + this.overscrollDistance) {
                this.velocityX = 0.0f;
            }
            if (this.amountY == -this.overscrollDistance) {
                this.velocityY = 0.0f;
            }
            if (this.amountY >= this.maxY + this.overscrollDistance) {
                this.velocityY = 0.0f;
            }
            this.flingTimer -= f2;
            if (this.flingTimer <= 0.0f) {
                this.velocityX = 0.0f;
                this.velocityY = 0.0f;
            }
            bl3 = true;
        }
        if (this.smoothScrolling && this.flingTimer <= 0.0f && !bl2 && (!this.touchScrollH || this.scrollX && this.maxX / (this.hScrollBounds.width - this.hKnobBounds.width) > this.widgetArea.width * 0.1f) && (!this.touchScrollV || this.scrollY && this.maxY / (this.vScrollBounds.height - this.vKnobBounds.height) > this.widgetArea.height * 0.1f)) {
            if (this.visualAmountX != this.amountX) {
                if (this.visualAmountX < this.amountX) {
                    this.visualScrollX(Math.min(this.amountX, this.visualAmountX + Math.max(200.0f * f2, (this.amountX - this.visualAmountX) * 7.0f * f2)));
                } else {
                    this.visualScrollX(Math.max(this.amountX, this.visualAmountX - Math.max(200.0f * f2, (this.visualAmountX - this.amountX) * 7.0f * f2)));
                }
                bl3 = true;
            }
            if (this.visualAmountY != this.amountY) {
                if (this.visualAmountY < this.amountY) {
                    this.visualScrollY(Math.min(this.amountY, this.visualAmountY + Math.max(200.0f * f2, (this.amountY - this.visualAmountY) * 7.0f * f2)));
                } else {
                    this.visualScrollY(Math.max(this.amountY, this.visualAmountY - Math.max(200.0f * f2, (this.visualAmountY - this.amountY) * 7.0f * f2)));
                }
                bl3 = true;
            }
        } else {
            if (this.visualAmountX != this.amountX) {
                this.visualScrollX(this.amountX);
            }
            if (this.visualAmountY != this.amountY) {
                this.visualScrollY(this.amountY);
            }
        }
        if (!bl2) {
            if (this.overscrollX && this.scrollX) {
                if (this.amountX < 0.0f) {
                    this.setScrollbarsVisible(true);
                    this.amountX += (this.overscrollSpeedMin + (this.overscrollSpeedMax - this.overscrollSpeedMin) * -this.amountX / this.overscrollDistance) * f2;
                    if (this.amountX > 0.0f) {
                        this.scrollX(0.0f);
                    }
                    bl3 = true;
                } else if (this.amountX > this.maxX) {
                    this.setScrollbarsVisible(true);
                    this.amountX -= (this.overscrollSpeedMin + (this.overscrollSpeedMax - this.overscrollSpeedMin) * -(this.maxX - this.amountX) / this.overscrollDistance) * f2;
                    if (this.amountX < this.maxX) {
                        this.scrollX(this.maxX);
                    }
                    bl3 = true;
                }
            }
            if (this.overscrollY && this.scrollY) {
                if (this.amountY < 0.0f) {
                    this.setScrollbarsVisible(true);
                    this.amountY += (this.overscrollSpeedMin + (this.overscrollSpeedMax - this.overscrollSpeedMin) * -this.amountY / this.overscrollDistance) * f2;
                    if (this.amountY > 0.0f) {
                        this.scrollY(0.0f);
                    }
                    bl3 = true;
                } else if (this.amountY > this.maxY) {
                    this.setScrollbarsVisible(true);
                    this.amountY -= (this.overscrollSpeedMin + (this.overscrollSpeedMax - this.overscrollSpeedMin) * -(this.maxY - this.amountY) / this.overscrollDistance) * f2;
                    if (this.amountY < this.maxY) {
                        this.scrollY(this.maxY);
                    }
                    bl3 = true;
                }
            }
        }
        if (bl3 && (stage = this.getStage()) != null && stage.getActionsRequestRendering()) {
            Gdx.graphics.requestRendering();
        }
    }

    @Override
    public void layout() {
        float f2;
        float f3;
        float f4;
        Drawable drawable = this.style.background;
        Drawable drawable2 = this.style.hScrollKnob;
        Drawable drawable3 = this.style.vScrollKnob;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        float f8 = 0.0f;
        if (drawable != null) {
            f5 = drawable.getLeftWidth();
            f6 = drawable.getRightWidth();
            f7 = drawable.getTopHeight();
            f8 = drawable.getBottomHeight();
        }
        float f9 = this.getWidth();
        float f10 = this.getHeight();
        this.widgetArea.set(f5, f8, f9 - f5 - f6, f10 - f7 - f8);
        if (this.widget == null) {
            return;
        }
        float f11 = 0.0f;
        float f12 = 0.0f;
        if (drawable2 != null) {
            f11 = drawable2.getMinHeight();
        }
        if (this.style.hScroll != null) {
            f11 = Math.max(f11, this.style.hScroll.getMinHeight());
        }
        if (drawable3 != null) {
            f12 = drawable3.getMinWidth();
        }
        if (this.style.vScroll != null) {
            f12 = Math.max(f12, this.style.vScroll.getMinWidth());
        }
        if (this.widget instanceof Layout) {
            Layout layout = (Layout)((Object)this.widget);
            f4 = layout.getPrefWidth();
            f3 = layout.getPrefHeight();
        } else {
            f4 = this.widget.getWidth();
            f3 = this.widget.getHeight();
        }
        this.scrollX = this.forceScrollX || f4 > this.widgetArea.width && !this.disableX;
        boolean bl2 = this.scrollY = this.forceScrollY || f3 > this.widgetArea.height && !this.disableY;
        if (!this.scrollbarsOnTop) {
            if (this.scrollY) {
                this.widgetArea.width -= f12;
                if (!this.vScrollOnRight) {
                    this.widgetArea.x += f12;
                }
                if (!this.scrollX && f4 > this.widgetArea.width && !this.disableX) {
                    this.scrollX = true;
                }
            }
            if (this.scrollX) {
                this.widgetArea.height -= f11;
                if (this.hScrollOnBottom) {
                    this.widgetArea.y += f11;
                }
                if (!this.scrollY && f3 > this.widgetArea.height && !this.disableY) {
                    this.scrollY = true;
                    this.widgetArea.width -= f12;
                    if (!this.vScrollOnRight) {
                        this.widgetArea.x += f12;
                    }
                }
            }
        }
        f4 = this.disableX ? this.widgetArea.width : Math.max(this.widgetArea.width, f4);
        f3 = this.disableY ? this.widgetArea.height : Math.max(this.widgetArea.height, f3);
        this.maxX = f4 - this.widgetArea.width;
        this.maxY = f3 - this.widgetArea.height;
        this.scrollX(MathUtils.clamp(this.amountX, 0.0f, this.maxX));
        this.scrollY(MathUtils.clamp(this.amountY, 0.0f, this.maxY));
        if (this.scrollX) {
            if (drawable2 != null) {
                float f13 = this.scrollbarsOnTop ? f5 : this.widgetArea.x;
                f2 = this.hScrollOnBottom ? f8 : f10 - f7 - f11;
                this.hScrollBounds.set(f13, f2, this.widgetArea.width, f11);
                if (this.scrollY && this.scrollbarsOnTop) {
                    this.hScrollBounds.width -= f12;
                    if (!this.vScrollOnRight) {
                        this.hScrollBounds.x += f12;
                    }
                }
                this.hKnobBounds.width = this.variableSizeKnobs ? Math.max(drawable2.getMinWidth(), (float)((int)(this.hScrollBounds.width * this.widgetArea.width / f4))) : drawable2.getMinWidth();
                if (this.hKnobBounds.width > f4) {
                    this.hKnobBounds.width = 0.0f;
                }
                this.hKnobBounds.height = drawable2.getMinHeight();
                this.hKnobBounds.x = this.hScrollBounds.x + (float)((int)((this.hScrollBounds.width - this.hKnobBounds.width) * this.getScrollPercentX()));
                this.hKnobBounds.y = this.hScrollBounds.y;
            } else {
                this.hScrollBounds.set(0.0f, 0.0f, 0.0f, 0.0f);
                this.hKnobBounds.set(0.0f, 0.0f, 0.0f, 0.0f);
            }
        }
        if (this.scrollY) {
            if (drawable3 != null) {
                float f14 = this.vScrollOnRight ? f9 - f6 - f12 : f5;
                f2 = this.scrollbarsOnTop ? f8 : this.widgetArea.y;
                this.vScrollBounds.set(f14, f2, f12, this.widgetArea.height);
                if (this.scrollX && this.scrollbarsOnTop) {
                    this.vScrollBounds.height -= f11;
                    if (this.hScrollOnBottom) {
                        this.vScrollBounds.y += f11;
                    }
                }
                this.vKnobBounds.width = drawable3.getMinWidth();
                this.vKnobBounds.height = this.variableSizeKnobs ? Math.max(drawable3.getMinHeight(), (float)((int)(this.vScrollBounds.height * this.widgetArea.height / f3))) : drawable3.getMinHeight();
                if (this.vKnobBounds.height > f3) {
                    this.vKnobBounds.height = 0.0f;
                }
                this.vKnobBounds.x = this.vScrollOnRight ? f9 - f6 - drawable3.getMinWidth() : f5;
                this.vKnobBounds.y = this.vScrollBounds.y + (float)((int)((this.vScrollBounds.height - this.vKnobBounds.height) * (1.0f - this.getScrollPercentY())));
            } else {
                this.vScrollBounds.set(0.0f, 0.0f, 0.0f, 0.0f);
                this.vKnobBounds.set(0.0f, 0.0f, 0.0f, 0.0f);
            }
        }
        this.updateWidgetPosition();
        if (this.widget instanceof Layout) {
            this.widget.setSize(f4, f3);
            ((Layout)((Object)this.widget)).validate();
        }
    }

    private void updateWidgetPosition() {
        float f2 = this.widgetArea.x - (float)(this.scrollX ? (int)this.visualAmountX : 0);
        float f3 = this.widgetArea.y - (float)((int)(this.scrollY ? this.maxY - this.visualAmountY : this.maxY));
        this.widget.setPosition(f2, f3);
        if (this.widget instanceof Cullable) {
            this.widgetCullingArea.x = this.widgetArea.x - f2;
            this.widgetCullingArea.y = this.widgetArea.y - f3;
            this.widgetCullingArea.width = this.widgetArea.width;
            this.widgetCullingArea.height = this.widgetArea.height;
            ((Cullable)((Object)this.widget)).setCullingArea(this.widgetCullingArea);
        }
    }

    @Override
    public void draw(Batch batch, float f2) {
        if (this.widget == null) {
            return;
        }
        this.validate();
        this.applyTransform(batch, this.computeTransform());
        if (this.scrollX) {
            this.hKnobBounds.x = this.hScrollBounds.x + (float)((int)((this.hScrollBounds.width - this.hKnobBounds.width) * this.getVisualScrollPercentX()));
        }
        if (this.scrollY) {
            this.vKnobBounds.y = this.vScrollBounds.y + (float)((int)((this.vScrollBounds.height - this.vKnobBounds.height) * (1.0f - this.getVisualScrollPercentY())));
        }
        this.updateWidgetPosition();
        Color color = this.getColor();
        float f3 = color.a * f2;
        if (this.style.background != null) {
            batch.setColor(color.r, color.g, color.b, f3);
            this.style.background.draw(batch, 0.0f, 0.0f, this.getWidth(), this.getHeight());
        }
        batch.flush();
        if (this.clipBegin(this.widgetArea.x, this.widgetArea.y, this.widgetArea.width, this.widgetArea.height)) {
            this.drawChildren(batch, f2);
            batch.flush();
            this.clipEnd();
        }
        batch.setColor(color.r, color.g, color.b, f3);
        if (this.fadeScrollBars) {
            f3 *= Interpolation.fade.apply(this.fadeAlpha / this.fadeAlphaSeconds);
        }
        this.drawScrollBars(batch, color.r, color.g, color.b, f3);
        this.resetTransform(batch);
    }

    protected void drawScrollBars(Batch batch, float f2, float f3, float f4, float f5) {
        boolean bl2;
        if (f5 <= 0.0f) {
            return;
        }
        batch.setColor(f2, f3, f4, f5);
        boolean bl3 = this.scrollX && this.hKnobBounds.width > 0.0f;
        boolean bl4 = bl2 = this.scrollY && this.vKnobBounds.height > 0.0f;
        if (bl3 && bl2 && this.style.corner != null) {
            this.style.corner.draw(batch, this.hScrollBounds.x + this.hScrollBounds.width, this.hScrollBounds.y, this.vScrollBounds.width, this.vScrollBounds.y);
        }
        if (bl3) {
            if (this.style.hScroll != null) {
                this.style.hScroll.draw(batch, this.hScrollBounds.x, this.hScrollBounds.y, this.hScrollBounds.width, this.hScrollBounds.height);
            }
            if (this.style.hScrollKnob != null) {
                this.style.hScrollKnob.draw(batch, this.hKnobBounds.x, this.hKnobBounds.y, this.hKnobBounds.width, this.hKnobBounds.height);
            }
        }
        if (bl2) {
            if (this.style.vScroll != null) {
                this.style.vScroll.draw(batch, this.vScrollBounds.x, this.vScrollBounds.y, this.vScrollBounds.width, this.vScrollBounds.height);
            }
            if (this.style.vScrollKnob != null) {
                this.style.vScrollKnob.draw(batch, this.vKnobBounds.x, this.vKnobBounds.y, this.vKnobBounds.width, this.vKnobBounds.height);
            }
        }
    }

    public void fling(float f2, float f3, float f4) {
        this.flingTimer = f2;
        this.velocityX = f3;
        this.velocityY = f4;
    }

    @Override
    public float getPrefWidth() {
        float f2 = 0.0f;
        if (this.widget instanceof Layout) {
            f2 = ((Layout)((Object)this.widget)).getPrefWidth();
        } else if (this.widget != null) {
            f2 = this.widget.getWidth();
        }
        Drawable drawable = this.style.background;
        if (drawable != null) {
            f2 = Math.max(f2 + drawable.getLeftWidth() + drawable.getRightWidth(), drawable.getMinWidth());
        }
        if (this.scrollY) {
            float f3 = 0.0f;
            if (this.style.vScrollKnob != null) {
                f3 = this.style.vScrollKnob.getMinWidth();
            }
            if (this.style.vScroll != null) {
                f3 = Math.max(f3, this.style.vScroll.getMinWidth());
            }
            f2 += f3;
        }
        return f2;
    }

    @Override
    public float getPrefHeight() {
        float f2 = 0.0f;
        if (this.widget instanceof Layout) {
            f2 = ((Layout)((Object)this.widget)).getPrefHeight();
        } else if (this.widget != null) {
            f2 = this.widget.getHeight();
        }
        Drawable drawable = this.style.background;
        if (drawable != null) {
            f2 = Math.max(f2 + drawable.getTopHeight() + drawable.getBottomHeight(), drawable.getMinHeight());
        }
        if (this.scrollX) {
            float f3 = 0.0f;
            if (this.style.hScrollKnob != null) {
                f3 = this.style.hScrollKnob.getMinHeight();
            }
            if (this.style.hScroll != null) {
                f3 = Math.max(f3, this.style.hScroll.getMinHeight());
            }
            f2 += f3;
        }
        return f2;
    }

    @Override
    public float getMinWidth() {
        return 0.0f;
    }

    @Override
    public float getMinHeight() {
        return 0.0f;
    }

    public void setActor(@Null Actor actor) {
        if (this.widget == this) {
            throw new IllegalArgumentException("widget cannot be the ScrollPane.");
        }
        if (this.widget != null) {
            super.removeActor(this.widget);
        }
        this.widget = actor;
        if (this.widget != null) {
            super.addActor(this.widget);
        }
    }

    @Null
    public Actor getActor() {
        return this.widget;
    }

    @Deprecated
    public void setWidget(@Null Actor actor) {
        this.setActor(actor);
    }

    @Deprecated
    @Null
    public Actor getWidget() {
        return this.widget;
    }

    @Override
    @Deprecated
    public void addActor(Actor actor) {
        throw new UnsupportedOperationException("Use ScrollPane#setWidget.");
    }

    @Override
    @Deprecated
    public void addActorAt(int n2, Actor actor) {
        throw new UnsupportedOperationException("Use ScrollPane#setWidget.");
    }

    @Override
    @Deprecated
    public void addActorBefore(Actor actor, Actor actor2) {
        throw new UnsupportedOperationException("Use ScrollPane#setWidget.");
    }

    @Override
    @Deprecated
    public void addActorAfter(Actor actor, Actor actor2) {
        throw new UnsupportedOperationException("Use ScrollPane#setWidget.");
    }

    @Override
    public boolean removeActor(Actor actor) {
        if (actor == null) {
            throw new IllegalArgumentException("actor cannot be null.");
        }
        if (actor != this.widget) {
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
        if (actor != this.widget) {
            return false;
        }
        this.widget = null;
        return super.removeActor(actor, bl2);
    }

    @Override
    public Actor removeActorAt(int n2, boolean bl2) {
        Actor actor = super.removeActorAt(n2, bl2);
        if (actor == this.widget) {
            this.widget = null;
        }
        return actor;
    }

    @Override
    @Null
    public Actor hit(float f2, float f3, boolean bl2) {
        if (f2 < 0.0f || f2 >= this.getWidth() || f3 < 0.0f || f3 >= this.getHeight()) {
            return null;
        }
        if (bl2 && this.getTouchable() == Touchable.enabled && this.isVisible()) {
            if (this.scrollX && this.touchScrollH && this.hScrollBounds.contains(f2, f3)) {
                return this;
            }
            if (this.scrollY && this.touchScrollV && this.vScrollBounds.contains(f2, f3)) {
                return this;
            }
        }
        return super.hit(f2, f3, bl2);
    }

    protected void scrollX(float f2) {
        this.amountX = f2;
    }

    protected void scrollY(float f2) {
        this.amountY = f2;
    }

    protected void visualScrollX(float f2) {
        this.visualAmountX = f2;
    }

    protected void visualScrollY(float f2) {
        this.visualAmountY = f2;
    }

    protected float getMouseWheelX() {
        return Math.min(this.widgetArea.width, Math.max(this.widgetArea.width * 0.9f, this.maxX * 0.1f) / 4.0f);
    }

    protected float getMouseWheelY() {
        return Math.min(this.widgetArea.height, Math.max(this.widgetArea.height * 0.9f, this.maxY * 0.1f) / 4.0f);
    }

    public void setScrollX(float f2) {
        this.scrollX(MathUtils.clamp(f2, 0.0f, this.maxX));
    }

    public float getScrollX() {
        return this.amountX;
    }

    public void setScrollY(float f2) {
        this.scrollY(MathUtils.clamp(f2, 0.0f, this.maxY));
    }

    public float getScrollY() {
        return this.amountY;
    }

    public void updateVisualScroll() {
        this.visualAmountX = this.amountX;
        this.visualAmountY = this.amountY;
    }

    public float getVisualScrollX() {
        return !this.scrollX ? 0.0f : this.visualAmountX;
    }

    public float getVisualScrollY() {
        return !this.scrollY ? 0.0f : this.visualAmountY;
    }

    public float getVisualScrollPercentX() {
        if (this.maxX == 0.0f) {
            return 0.0f;
        }
        return MathUtils.clamp(this.visualAmountX / this.maxX, 0.0f, 1.0f);
    }

    public float getVisualScrollPercentY() {
        if (this.maxY == 0.0f) {
            return 0.0f;
        }
        return MathUtils.clamp(this.visualAmountY / this.maxY, 0.0f, 1.0f);
    }

    public float getScrollPercentX() {
        if (this.maxX == 0.0f) {
            return 0.0f;
        }
        return MathUtils.clamp(this.amountX / this.maxX, 0.0f, 1.0f);
    }

    public void setScrollPercentX(float f2) {
        this.scrollX(this.maxX * MathUtils.clamp(f2, 0.0f, 1.0f));
    }

    public float getScrollPercentY() {
        if (this.maxY == 0.0f) {
            return 0.0f;
        }
        return MathUtils.clamp(this.amountY / this.maxY, 0.0f, 1.0f);
    }

    public void setScrollPercentY(float f2) {
        this.scrollY(this.maxY * MathUtils.clamp(f2, 0.0f, 1.0f));
    }

    public void setFlickScroll(boolean bl2) {
        if (this.flickScroll == bl2) {
            return;
        }
        this.flickScroll = bl2;
        if (bl2) {
            this.addListener(this.flickScrollListener);
        } else {
            this.removeListener(this.flickScrollListener);
        }
        this.invalidate();
    }

    public void setFlickScrollTapSquareSize(float f2) {
        this.flickScrollListener.getGestureDetector().setTapSquareSize(f2);
    }

    public void scrollTo(float f2, float f3, float f4, float f5) {
        this.scrollTo(f2, f3, f4, f5, false, false);
    }

    public void scrollTo(float f2, float f3, float f4, float f5, boolean bl2, boolean bl3) {
        this.validate();
        float f6 = this.amountX;
        if (bl2) {
            f6 = f2 - this.widgetArea.width / 2.0f + f4 / 2.0f;
        } else {
            if (f2 + f4 > f6 + this.widgetArea.width) {
                f6 = f2 + f4 - this.widgetArea.width;
            }
            if (f2 < f6) {
                f6 = f2;
            }
        }
        this.scrollX(MathUtils.clamp(f6, 0.0f, this.maxX));
        float f7 = this.amountY;
        if (bl3) {
            f7 = this.maxY - f3 + this.widgetArea.height / 2.0f - f5 / 2.0f;
        } else {
            if (f7 > this.maxY - f3 - f5 + this.widgetArea.height) {
                f7 = this.maxY - f3 - f5 + this.widgetArea.height;
            }
            if (f7 < this.maxY - f3) {
                f7 = this.maxY - f3;
            }
        }
        this.scrollY(MathUtils.clamp(f7, 0.0f, this.maxY));
    }

    public float getMaxX() {
        return this.maxX;
    }

    public float getMaxY() {
        return this.maxY;
    }

    public float getScrollBarHeight() {
        if (!this.scrollX) {
            return 0.0f;
        }
        float f2 = 0.0f;
        if (this.style.hScrollKnob != null) {
            f2 = this.style.hScrollKnob.getMinHeight();
        }
        if (this.style.hScroll != null) {
            f2 = Math.max(f2, this.style.hScroll.getMinHeight());
        }
        return f2;
    }

    public float getScrollBarWidth() {
        if (!this.scrollY) {
            return 0.0f;
        }
        float f2 = 0.0f;
        if (this.style.vScrollKnob != null) {
            f2 = this.style.vScrollKnob.getMinWidth();
        }
        if (this.style.vScroll != null) {
            f2 = Math.max(f2, this.style.vScroll.getMinWidth());
        }
        return f2;
    }

    public float getScrollWidth() {
        return this.widgetArea.width;
    }

    public float getScrollHeight() {
        return this.widgetArea.height;
    }

    public boolean isScrollX() {
        return this.scrollX;
    }

    public boolean isScrollY() {
        return this.scrollY;
    }

    public void setScrollingDisabled(boolean bl2, boolean bl3) {
        this.disableX = bl2;
        this.disableY = bl3;
        this.invalidate();
    }

    public boolean isScrollingDisabledX() {
        return this.disableX;
    }

    public boolean isScrollingDisabledY() {
        return this.disableY;
    }

    public boolean isLeftEdge() {
        return !this.scrollX || this.amountX <= 0.0f;
    }

    public boolean isRightEdge() {
        return !this.scrollX || this.amountX >= this.maxX;
    }

    public boolean isTopEdge() {
        return !this.scrollY || this.amountY <= 0.0f;
    }

    public boolean isBottomEdge() {
        return !this.scrollY || this.amountY >= this.maxY;
    }

    public boolean isDragging() {
        return this.draggingPointer != -1;
    }

    public boolean isPanning() {
        return this.flickScrollListener.getGestureDetector().isPanning();
    }

    public boolean isFlinging() {
        return this.flingTimer > 0.0f;
    }

    public void setVelocityX(float f2) {
        this.velocityX = f2;
    }

    public float getVelocityX() {
        return this.velocityX;
    }

    public void setVelocityY(float f2) {
        this.velocityY = f2;
    }

    public float getVelocityY() {
        return this.velocityY;
    }

    public void setOverscroll(boolean bl2, boolean bl3) {
        this.overscrollX = bl2;
        this.overscrollY = bl3;
    }

    public void setupOverscroll(float f2, float f3, float f4) {
        this.overscrollDistance = f2;
        this.overscrollSpeedMin = f3;
        this.overscrollSpeedMax = f4;
    }

    public float getOverscrollDistance() {
        return this.overscrollDistance;
    }

    public void setForceScroll(boolean bl2, boolean bl3) {
        this.forceScrollX = bl2;
        this.forceScrollY = bl3;
    }

    public boolean isForceScrollX() {
        return this.forceScrollX;
    }

    public boolean isForceScrollY() {
        return this.forceScrollY;
    }

    public void setFlingTime(float f2) {
        this.flingTime = f2;
    }

    public void setClamp(boolean bl2) {
        this.clamp = bl2;
    }

    public void setScrollBarPositions(boolean bl2, boolean bl3) {
        this.hScrollOnBottom = bl2;
        this.vScrollOnRight = bl3;
    }

    public void setFadeScrollBars(boolean bl2) {
        if (this.fadeScrollBars == bl2) {
            return;
        }
        this.fadeScrollBars = bl2;
        if (!bl2) {
            this.fadeAlpha = this.fadeAlphaSeconds;
        }
        this.invalidate();
    }

    public void setupFadeScrollBars(float f2, float f3) {
        this.fadeAlphaSeconds = f2;
        this.fadeDelaySeconds = f3;
    }

    public boolean getFadeScrollBars() {
        return this.fadeScrollBars;
    }

    public void setScrollBarTouch(boolean bl2) {
        this.scrollBarTouch = bl2;
    }

    public void setSmoothScrolling(boolean bl2) {
        this.smoothScrolling = bl2;
    }

    public void setScrollbarsOnTop(boolean bl2) {
        this.scrollbarsOnTop = bl2;
        this.invalidate();
    }

    public boolean getVariableSizeKnobs() {
        return this.variableSizeKnobs;
    }

    public void setVariableSizeKnobs(boolean bl2) {
        this.variableSizeKnobs = bl2;
    }

    public void setCancelTouchFocus(boolean bl2) {
        this.cancelTouchFocus = bl2;
    }

    @Override
    public void drawDebug(ShapeRenderer shapeRenderer) {
        this.drawDebugBounds(shapeRenderer);
        this.applyTransform(shapeRenderer, this.computeTransform());
        if (this.clipBegin(this.widgetArea.x, this.widgetArea.y, this.widgetArea.width, this.widgetArea.height)) {
            this.drawDebugChildren(shapeRenderer);
            shapeRenderer.flush();
            this.clipEnd();
        }
        this.resetTransform(shapeRenderer);
    }

    public static class ScrollPaneStyle {
        @Null
        public Drawable background;
        @Null
        public Drawable corner;
        @Null
        public Drawable hScroll;
        @Null
        public Drawable hScrollKnob;
        @Null
        public Drawable vScroll;
        @Null
        public Drawable vScrollKnob;

        public ScrollPaneStyle() {
        }

        public ScrollPaneStyle(@Null Drawable drawable, @Null Drawable drawable2, @Null Drawable drawable3, @Null Drawable drawable4, @Null Drawable drawable5) {
            this.background = drawable;
            this.hScroll = drawable2;
            this.hScrollKnob = drawable3;
            this.vScroll = drawable4;
            this.vScrollKnob = drawable5;
        }

        public ScrollPaneStyle(ScrollPaneStyle scrollPaneStyle) {
            this.background = scrollPaneStyle.background;
            this.corner = scrollPaneStyle.corner;
            this.hScroll = scrollPaneStyle.hScroll;
            this.hScrollKnob = scrollPaneStyle.hScrollKnob;
            this.vScroll = scrollPaneStyle.vScroll;
            this.vScrollKnob = scrollPaneStyle.vScrollKnob;
        }
    }
}

