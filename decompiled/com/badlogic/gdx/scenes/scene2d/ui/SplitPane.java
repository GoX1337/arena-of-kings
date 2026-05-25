/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.WidgetGroup;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.Layout;
import com.badlogic.gdx.scenes.scene2d.utils.ScissorStack;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.Null;

public class SplitPane
extends WidgetGroup {
    SplitPaneStyle style;
    @Null
    private Actor firstWidget;
    @Null
    private Actor secondWidget;
    boolean vertical;
    float splitAmount = 0.5f;
    float minAmount;
    float maxAmount = 1.0f;
    private final Rectangle firstWidgetBounds = new Rectangle();
    private final Rectangle secondWidgetBounds = new Rectangle();
    final Rectangle handleBounds = new Rectangle();
    boolean cursorOverHandle;
    private final Rectangle tempScissors = new Rectangle();
    Vector2 lastPoint = new Vector2();
    Vector2 handlePosition = new Vector2();

    public SplitPane(@Null Actor actor, @Null Actor actor2, boolean bl2, Skin skin) {
        this(actor, actor2, bl2, skin, "default-" + (bl2 ? "vertical" : "horizontal"));
    }

    public SplitPane(@Null Actor actor, @Null Actor actor2, boolean bl2, Skin skin, String string) {
        this(actor, actor2, bl2, skin.get(string, SplitPaneStyle.class));
    }

    public SplitPane(@Null Actor actor, @Null Actor actor2, boolean bl2, SplitPaneStyle splitPaneStyle) {
        this.vertical = bl2;
        this.setStyle(splitPaneStyle);
        this.setFirstWidget(actor);
        this.setSecondWidget(actor2);
        this.setSize(this.getPrefWidth(), this.getPrefHeight());
        this.initialize();
    }

    private void initialize() {
        this.addListener(new InputListener(){
            int draggingPointer = -1;

            @Override
            public boolean touchDown(InputEvent inputEvent, float f2, float f3, int n2, int n3) {
                if (this.draggingPointer != -1) {
                    return false;
                }
                if (n2 == 0 && n3 != 0) {
                    return false;
                }
                if (SplitPane.this.handleBounds.contains(f2, f3)) {
                    this.draggingPointer = n2;
                    SplitPane.this.lastPoint.set(f2, f3);
                    SplitPane.this.handlePosition.set(SplitPane.this.handleBounds.x, SplitPane.this.handleBounds.y);
                    return true;
                }
                return false;
            }

            @Override
            public void touchUp(InputEvent inputEvent, float f2, float f3, int n2, int n3) {
                if (n2 == this.draggingPointer) {
                    this.draggingPointer = -1;
                }
            }

            @Override
            public void touchDragged(InputEvent inputEvent, float f2, float f3, int n2) {
                if (n2 != this.draggingPointer) {
                    return;
                }
                Drawable drawable = SplitPane.this.style.handle;
                if (!SplitPane.this.vertical) {
                    float f4;
                    float f5 = f2 - SplitPane.this.lastPoint.x;
                    float f6 = SplitPane.this.getWidth() - drawable.getMinWidth();
                    SplitPane.this.handlePosition.x = f4 = SplitPane.this.handlePosition.x + f5;
                    f4 = Math.max(0.0f, f4);
                    f4 = Math.min(f6, f4);
                    SplitPane.this.splitAmount = f4 / f6;
                    SplitPane.this.lastPoint.set(f2, f3);
                } else {
                    float f7;
                    float f8 = f3 - SplitPane.this.lastPoint.y;
                    float f9 = SplitPane.this.getHeight() - drawable.getMinHeight();
                    SplitPane.this.handlePosition.y = f7 = SplitPane.this.handlePosition.y + f8;
                    f7 = Math.max(0.0f, f7);
                    f7 = Math.min(f9, f7);
                    SplitPane.this.splitAmount = 1.0f - f7 / f9;
                    SplitPane.this.lastPoint.set(f2, f3);
                }
                SplitPane.this.invalidate();
            }

            @Override
            public boolean mouseMoved(InputEvent inputEvent, float f2, float f3) {
                SplitPane.this.cursorOverHandle = SplitPane.this.handleBounds.contains(f2, f3);
                return false;
            }
        });
    }

    public void setStyle(SplitPaneStyle splitPaneStyle) {
        this.style = splitPaneStyle;
        this.invalidateHierarchy();
    }

    public SplitPaneStyle getStyle() {
        return this.style;
    }

    @Override
    public void layout() {
        Object object;
        this.clampSplitAmount();
        if (!this.vertical) {
            this.calculateHorizBoundsAndPositions();
        } else {
            this.calculateVertBoundsAndPositions();
        }
        Actor actor = this.firstWidget;
        if (actor != null) {
            object = this.firstWidgetBounds;
            actor.setBounds(((Rectangle)object).x, ((Rectangle)object).y, ((Rectangle)object).width, ((Rectangle)object).height);
            if (actor instanceof Layout) {
                ((Layout)((Object)actor)).validate();
            }
        }
        if ((object = this.secondWidget) != null) {
            Rectangle rectangle = this.secondWidgetBounds;
            ((Actor)object).setBounds(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
            if (object instanceof Layout) {
                ((Layout)object).validate();
            }
        }
    }

    @Override
    public float getPrefWidth() {
        float f2;
        float f3;
        float f4 = this.firstWidget == null ? 0.0f : (f3 = this.firstWidget instanceof Layout ? ((Layout)((Object)this.firstWidget)).getPrefWidth() : this.firstWidget.getWidth());
        float f5 = this.secondWidget == null ? 0.0f : (f2 = this.secondWidget instanceof Layout ? ((Layout)((Object)this.secondWidget)).getPrefWidth() : this.secondWidget.getWidth());
        if (this.vertical) {
            return Math.max(f3, f2);
        }
        return f3 + this.style.handle.getMinWidth() + f2;
    }

    @Override
    public float getPrefHeight() {
        float f2;
        float f3;
        float f4 = this.firstWidget == null ? 0.0f : (f3 = this.firstWidget instanceof Layout ? ((Layout)((Object)this.firstWidget)).getPrefHeight() : this.firstWidget.getHeight());
        float f5 = this.secondWidget == null ? 0.0f : (f2 = this.secondWidget instanceof Layout ? ((Layout)((Object)this.secondWidget)).getPrefHeight() : this.secondWidget.getHeight());
        if (!this.vertical) {
            return Math.max(f3, f2);
        }
        return f3 + this.style.handle.getMinHeight() + f2;
    }

    @Override
    public float getMinWidth() {
        float f2;
        float f3 = this.firstWidget instanceof Layout ? ((Layout)((Object)this.firstWidget)).getMinWidth() : 0.0f;
        float f4 = f2 = this.secondWidget instanceof Layout ? ((Layout)((Object)this.secondWidget)).getMinWidth() : 0.0f;
        if (this.vertical) {
            return Math.max(f3, f2);
        }
        return f3 + this.style.handle.getMinWidth() + f2;
    }

    @Override
    public float getMinHeight() {
        float f2;
        float f3 = this.firstWidget instanceof Layout ? ((Layout)((Object)this.firstWidget)).getMinHeight() : 0.0f;
        float f4 = f2 = this.secondWidget instanceof Layout ? ((Layout)((Object)this.secondWidget)).getMinHeight() : 0.0f;
        if (!this.vertical) {
            return Math.max(f3, f2);
        }
        return f3 + this.style.handle.getMinHeight() + f2;
    }

    public void setVertical(boolean bl2) {
        if (this.vertical == bl2) {
            return;
        }
        this.vertical = bl2;
        this.invalidateHierarchy();
    }

    public boolean isVertical() {
        return this.vertical;
    }

    private void calculateHorizBoundsAndPositions() {
        Drawable drawable = this.style.handle;
        float f2 = this.getHeight();
        float f3 = this.getWidth() - drawable.getMinWidth();
        float f4 = (int)(f3 * this.splitAmount);
        float f5 = f3 - f4;
        float f6 = drawable.getMinWidth();
        this.firstWidgetBounds.set(0.0f, 0.0f, f4, f2);
        this.secondWidgetBounds.set(f4 + f6, 0.0f, f5, f2);
        this.handleBounds.set(f4, 0.0f, f6, f2);
    }

    private void calculateVertBoundsAndPositions() {
        Drawable drawable = this.style.handle;
        float f2 = this.getWidth();
        float f3 = this.getHeight();
        float f4 = f3 - drawable.getMinHeight();
        float f5 = (int)(f4 * this.splitAmount);
        float f6 = f4 - f5;
        float f7 = drawable.getMinHeight();
        this.firstWidgetBounds.set(0.0f, f3 - f5, f2, f5);
        this.secondWidgetBounds.set(0.0f, 0.0f, f2, f6);
        this.handleBounds.set(0.0f, f6, f2, f7);
    }

    @Override
    public void draw(Batch batch, float f2) {
        Stage stage = this.getStage();
        if (stage == null) {
            return;
        }
        this.validate();
        Color color = this.getColor();
        float f3 = color.a * f2;
        this.applyTransform(batch, this.computeTransform());
        if (this.firstWidget != null && this.firstWidget.isVisible()) {
            batch.flush();
            stage.calculateScissors(this.firstWidgetBounds, this.tempScissors);
            if (ScissorStack.pushScissors(this.tempScissors)) {
                this.firstWidget.draw(batch, f3);
                batch.flush();
                ScissorStack.popScissors();
            }
        }
        if (this.secondWidget != null && this.secondWidget.isVisible()) {
            batch.flush();
            stage.calculateScissors(this.secondWidgetBounds, this.tempScissors);
            if (ScissorStack.pushScissors(this.tempScissors)) {
                this.secondWidget.draw(batch, f3);
                batch.flush();
                ScissorStack.popScissors();
            }
        }
        batch.setColor(color.r, color.g, color.b, f3);
        this.style.handle.draw(batch, this.handleBounds.x, this.handleBounds.y, this.handleBounds.width, this.handleBounds.height);
        this.resetTransform(batch);
    }

    public void setSplitAmount(float f2) {
        this.splitAmount = f2;
        this.invalidate();
    }

    public float getSplitAmount() {
        return this.splitAmount;
    }

    protected void clampSplitAmount() {
        float f2 = this.minAmount;
        float f3 = this.maxAmount;
        if (this.vertical) {
            float f4 = this.getHeight() - this.style.handle.getMinHeight();
            if (this.firstWidget instanceof Layout) {
                f2 = Math.max(f2, Math.min(((Layout)((Object)this.firstWidget)).getMinHeight() / f4, 1.0f));
            }
            if (this.secondWidget instanceof Layout) {
                f3 = Math.min(f3, 1.0f - Math.min(((Layout)((Object)this.secondWidget)).getMinHeight() / f4, 1.0f));
            }
        } else {
            float f5 = this.getWidth() - this.style.handle.getMinWidth();
            if (this.firstWidget instanceof Layout) {
                f2 = Math.max(f2, Math.min(((Layout)((Object)this.firstWidget)).getMinWidth() / f5, 1.0f));
            }
            if (this.secondWidget instanceof Layout) {
                f3 = Math.min(f3, 1.0f - Math.min(((Layout)((Object)this.secondWidget)).getMinWidth() / f5, 1.0f));
            }
        }
        this.splitAmount = f2 > f3 ? 0.5f * (f2 + f3) : Math.max(Math.min(this.splitAmount, f3), f2);
    }

    public float getMinSplitAmount() {
        return this.minAmount;
    }

    public void setMinSplitAmount(float f2) {
        if (f2 < 0.0f || f2 > 1.0f) {
            throw new GdxRuntimeException("minAmount has to be >= 0 and <= 1");
        }
        this.minAmount = f2;
    }

    public float getMaxSplitAmount() {
        return this.maxAmount;
    }

    public void setMaxSplitAmount(float f2) {
        if (f2 < 0.0f || f2 > 1.0f) {
            throw new GdxRuntimeException("maxAmount has to be >= 0 and <= 1");
        }
        this.maxAmount = f2;
    }

    public void setFirstWidget(@Null Actor actor) {
        if (this.firstWidget != null) {
            super.removeActor(this.firstWidget);
        }
        this.firstWidget = actor;
        if (actor != null) {
            super.addActor(actor);
        }
        this.invalidate();
    }

    public void setSecondWidget(@Null Actor actor) {
        if (this.secondWidget != null) {
            super.removeActor(this.secondWidget);
        }
        this.secondWidget = actor;
        if (actor != null) {
            super.addActor(actor);
        }
        this.invalidate();
    }

    @Override
    public void addActor(Actor actor) {
        throw new UnsupportedOperationException("Use SplitPane#setWidget.");
    }

    @Override
    public void addActorAt(int n2, Actor actor) {
        throw new UnsupportedOperationException("Use SplitPane#setWidget.");
    }

    @Override
    public void addActorBefore(Actor actor, Actor actor2) {
        throw new UnsupportedOperationException("Use SplitPane#setWidget.");
    }

    @Override
    public boolean removeActor(Actor actor) {
        if (actor == null) {
            throw new IllegalArgumentException("actor cannot be null.");
        }
        if (actor == this.firstWidget) {
            this.setFirstWidget(null);
            return true;
        }
        if (actor == this.secondWidget) {
            this.setSecondWidget(null);
            return true;
        }
        return true;
    }

    @Override
    public boolean removeActor(Actor actor, boolean bl2) {
        if (actor == null) {
            throw new IllegalArgumentException("actor cannot be null.");
        }
        if (actor == this.firstWidget) {
            super.removeActor(actor, bl2);
            this.firstWidget = null;
            this.invalidate();
            return true;
        }
        if (actor == this.secondWidget) {
            super.removeActor(actor, bl2);
            this.secondWidget = null;
            this.invalidate();
            return true;
        }
        return false;
    }

    @Override
    public Actor removeActorAt(int n2, boolean bl2) {
        Actor actor = super.removeActorAt(n2, bl2);
        if (actor == this.firstWidget) {
            super.removeActor(actor, bl2);
            this.firstWidget = null;
            this.invalidate();
        } else if (actor == this.secondWidget) {
            super.removeActor(actor, bl2);
            this.secondWidget = null;
            this.invalidate();
        }
        return actor;
    }

    public boolean isCursorOverHandle() {
        return this.cursorOverHandle;
    }

    public static class SplitPaneStyle {
        public Drawable handle;

        public SplitPaneStyle() {
        }

        public SplitPaneStyle(Drawable drawable) {
            this.handle = drawable;
        }

        public SplitPaneStyle(SplitPaneStyle splitPaneStyle) {
            this.handle = splitPaneStyle.handle;
        }
    }
}

