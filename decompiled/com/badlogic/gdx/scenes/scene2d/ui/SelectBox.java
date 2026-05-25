/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Widget;
import com.badlogic.gdx.scenes.scene2d.utils.ArraySelection;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Disableable;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Null;
import com.badlogic.gdx.utils.OrderedSet;
import com.badlogic.gdx.utils.Pool;
import com.badlogic.gdx.utils.Pools;

public class SelectBox<T>
extends Widget
implements Disableable {
    static final Vector2 temp = new Vector2();
    SelectBoxStyle style;
    final Array<T> items = new Array();
    SelectBoxScrollPane<T> scrollPane;
    private float prefWidth;
    private float prefHeight;
    private ClickListener clickListener;
    boolean disabled;
    private int alignment = 8;
    boolean selectedPrefWidth;
    final ArraySelection<T> selection = new ArraySelection(this.items){

        @Override
        public boolean fireChangeEvent() {
            if (SelectBox.this.selectedPrefWidth) {
                SelectBox.this.invalidateHierarchy();
            }
            return super.fireChangeEvent();
        }
    };

    public SelectBox(Skin skin) {
        this(skin.get(SelectBoxStyle.class));
    }

    public SelectBox(Skin skin, String string) {
        this(skin.get(string, SelectBoxStyle.class));
    }

    public SelectBox(SelectBoxStyle selectBoxStyle) {
        this.setStyle(selectBoxStyle);
        this.setSize(this.getPrefWidth(), this.getPrefHeight());
        this.selection.setActor(this);
        this.selection.setRequired(true);
        this.scrollPane = new SelectBoxScrollPane(this);
        this.clickListener = new ClickListener(){

            @Override
            public boolean touchDown(InputEvent inputEvent, float f2, float f3, int n2, int n3) {
                if (n2 == 0 && n3 != 0) {
                    return false;
                }
                if (SelectBox.this.isDisabled()) {
                    return false;
                }
                if (SelectBox.this.scrollPane.hasParent()) {
                    SelectBox.this.hideScrollPane();
                } else {
                    SelectBox.this.showScrollPane();
                }
                return true;
            }
        };
        this.addListener(this.clickListener);
    }

    protected SelectBoxScrollPane<T> newScrollPane() {
        return new SelectBoxScrollPane(this);
    }

    public void setMaxListCount(int n2) {
        this.scrollPane.maxListCount = n2;
    }

    public int getMaxListCount() {
        return this.scrollPane.maxListCount;
    }

    @Override
    public void setStage(Stage stage) {
        if (stage == null) {
            this.scrollPane.hide();
        }
        super.setStage(stage);
    }

    public void setStyle(SelectBoxStyle selectBoxStyle) {
        if (selectBoxStyle == null) {
            throw new IllegalArgumentException("style cannot be null.");
        }
        this.style = selectBoxStyle;
        if (this.scrollPane != null) {
            this.scrollPane.setStyle(selectBoxStyle.scrollStyle);
            this.scrollPane.list.setStyle(selectBoxStyle.listStyle);
        }
        this.invalidateHierarchy();
    }

    public SelectBoxStyle getStyle() {
        return this.style;
    }

    public void setItems(T ... TArray) {
        if (TArray == null) {
            throw new IllegalArgumentException("newItems cannot be null.");
        }
        float f2 = this.getPrefWidth();
        this.items.clear();
        this.items.addAll(TArray);
        this.selection.validate();
        this.scrollPane.list.setItems(this.items);
        this.invalidate();
        if (f2 != this.getPrefWidth()) {
            this.invalidateHierarchy();
        }
    }

    public void setItems(Array<T> array) {
        if (array == null) {
            throw new IllegalArgumentException("newItems cannot be null.");
        }
        float f2 = this.getPrefWidth();
        if (array != this.items) {
            this.items.clear();
            this.items.addAll(array);
        }
        this.selection.validate();
        this.scrollPane.list.setItems(this.items);
        this.invalidate();
        if (f2 != this.getPrefWidth()) {
            this.invalidateHierarchy();
        }
    }

    public void clearItems() {
        if (this.items.size == 0) {
            return;
        }
        this.items.clear();
        this.selection.clear();
        this.scrollPane.list.clearItems();
        this.invalidateHierarchy();
    }

    public Array<T> getItems() {
        return this.items;
    }

    @Override
    public void layout() {
        Drawable drawable = this.style.background;
        BitmapFont bitmapFont = this.style.font;
        this.prefHeight = drawable != null ? Math.max(drawable.getTopHeight() + drawable.getBottomHeight() + bitmapFont.getCapHeight() - bitmapFont.getDescent() * 2.0f, drawable.getMinHeight()) : bitmapFont.getCapHeight() - bitmapFont.getDescent() * 2.0f;
        Pool<GlyphLayout> pool = Pools.get(GlyphLayout.class);
        GlyphLayout glyphLayout = pool.obtain();
        if (this.selectedPrefWidth) {
            T t2;
            this.prefWidth = 0.0f;
            if (drawable != null) {
                this.prefWidth = drawable.getLeftWidth() + drawable.getRightWidth();
            }
            if ((t2 = this.getSelected()) != null) {
                glyphLayout.setText(bitmapFont, this.toString(t2));
                this.prefWidth += glyphLayout.width;
            }
        } else {
            float f2 = 0.0f;
            for (int i2 = 0; i2 < this.items.size; ++i2) {
                glyphLayout.setText(bitmapFont, this.toString(this.items.get(i2)));
                f2 = Math.max(glyphLayout.width, f2);
            }
            this.prefWidth = f2;
            if (drawable != null) {
                this.prefWidth = Math.max(this.prefWidth + drawable.getLeftWidth() + drawable.getRightWidth(), drawable.getMinWidth());
            }
            List.ListStyle listStyle = this.style.listStyle;
            ScrollPane.ScrollPaneStyle scrollPaneStyle = this.style.scrollStyle;
            float f3 = f2 + listStyle.selection.getLeftWidth() + listStyle.selection.getRightWidth();
            drawable = scrollPaneStyle.background;
            if (drawable != null) {
                f3 = Math.max(f3 + drawable.getLeftWidth() + drawable.getRightWidth(), drawable.getMinWidth());
            }
            if (this.scrollPane == null || !this.scrollPane.disableY) {
                f3 += Math.max(this.style.scrollStyle.vScroll != null ? this.style.scrollStyle.vScroll.getMinWidth() : 0.0f, this.style.scrollStyle.vScrollKnob != null ? this.style.scrollStyle.vScrollKnob.getMinWidth() : 0.0f);
            }
            this.prefWidth = Math.max(this.prefWidth, f3);
        }
        pool.free(glyphLayout);
    }

    @Null
    protected Drawable getBackgroundDrawable() {
        if (this.isDisabled() && this.style.backgroundDisabled != null) {
            return this.style.backgroundDisabled;
        }
        if (this.scrollPane.hasParent() && this.style.backgroundOpen != null) {
            return this.style.backgroundOpen;
        }
        if (this.isOver() && this.style.backgroundOver != null) {
            return this.style.backgroundOver;
        }
        return this.style.background;
    }

    protected Color getFontColor() {
        if (this.isDisabled() && this.style.disabledFontColor != null) {
            return this.style.disabledFontColor;
        }
        if (this.style.overFontColor != null && (this.isOver() || this.scrollPane.hasParent())) {
            return this.style.overFontColor;
        }
        return this.style.fontColor;
    }

    @Override
    public void draw(Batch batch, float f2) {
        Object t2;
        this.validate();
        Drawable drawable = this.getBackgroundDrawable();
        Color color = this.getFontColor();
        BitmapFont bitmapFont = this.style.font;
        Color color2 = this.getColor();
        float f3 = this.getX();
        float f4 = this.getY();
        float f5 = this.getWidth();
        float f6 = this.getHeight();
        batch.setColor(color2.r, color2.g, color2.b, color2.a * f2);
        if (drawable != null) {
            drawable.draw(batch, f3, f4, f5, f6);
        }
        if ((t2 = this.selection.first()) != null) {
            if (drawable != null) {
                f5 -= drawable.getLeftWidth() + drawable.getRightWidth();
                f3 += drawable.getLeftWidth();
                f4 += (float)((int)((f6 -= drawable.getBottomHeight() + drawable.getTopHeight()) / 2.0f + drawable.getBottomHeight() + bitmapFont.getData().capHeight / 2.0f));
            } else {
                f4 += (float)((int)(f6 / 2.0f + bitmapFont.getData().capHeight / 2.0f));
            }
            bitmapFont.setColor(color.r, color.g, color.b, color.a * f2);
            this.drawItem(batch, bitmapFont, t2, f3, f4, f5);
        }
    }

    protected GlyphLayout drawItem(Batch batch, BitmapFont bitmapFont, T t2, float f2, float f3, float f4) {
        String string = this.toString(t2);
        return bitmapFont.draw(batch, string, f2, f3, 0, string.length(), f4, this.alignment, false, "...");
    }

    public void setAlignment(int n2) {
        this.alignment = n2;
    }

    public ArraySelection<T> getSelection() {
        return this.selection;
    }

    @Null
    public T getSelected() {
        return this.selection.first();
    }

    public void setSelected(@Null T t2) {
        if (this.items.contains(t2, false)) {
            this.selection.set(t2);
        } else if (this.items.size > 0) {
            this.selection.set(this.items.first());
        } else {
            this.selection.clear();
        }
    }

    public int getSelectedIndex() {
        OrderedSet orderedSet = this.selection.items();
        return orderedSet.size == 0 ? -1 : this.items.indexOf(orderedSet.first(), false);
    }

    public void setSelectedIndex(int n2) {
        this.selection.set(this.items.get(n2));
    }

    public void setSelectedPrefWidth(boolean bl2) {
        this.selectedPrefWidth = bl2;
    }

    public boolean getSelectedPrefWidth() {
        return this.selectedPrefWidth;
    }

    public float getMaxSelectedPrefWidth() {
        Pool<GlyphLayout> pool = Pools.get(GlyphLayout.class);
        GlyphLayout glyphLayout = pool.obtain();
        float f2 = 0.0f;
        for (int i2 = 0; i2 < this.items.size; ++i2) {
            glyphLayout.setText(this.style.font, this.toString(this.items.get(i2)));
            f2 = Math.max(glyphLayout.width, f2);
        }
        Drawable drawable = this.style.background;
        if (drawable != null) {
            f2 = Math.max(f2 + drawable.getLeftWidth() + drawable.getRightWidth(), drawable.getMinWidth());
        }
        return f2;
    }

    @Override
    public void setDisabled(boolean bl2) {
        if (bl2 && !this.disabled) {
            this.hideScrollPane();
        }
        this.disabled = bl2;
    }

    @Override
    public boolean isDisabled() {
        return this.disabled;
    }

    @Override
    public float getPrefWidth() {
        this.validate();
        return this.prefWidth;
    }

    @Override
    public float getPrefHeight() {
        this.validate();
        return this.prefHeight;
    }

    protected String toString(T t2) {
        return t2.toString();
    }

    @Deprecated
    public void showList() {
        this.showScrollPane();
    }

    public void showScrollPane() {
        if (this.items.size == 0) {
            return;
        }
        if (this.getStage() != null) {
            this.scrollPane.show(this.getStage());
        }
    }

    @Deprecated
    public void hideList() {
        this.hideScrollPane();
    }

    public void hideScrollPane() {
        this.scrollPane.hide();
    }

    public List<T> getList() {
        return this.scrollPane.list;
    }

    public void setScrollingDisabled(boolean bl2) {
        this.scrollPane.setScrollingDisabled(true, bl2);
        this.invalidateHierarchy();
    }

    public SelectBoxScrollPane getScrollPane() {
        return this.scrollPane;
    }

    public boolean isOver() {
        return this.clickListener.isOver();
    }

    public ClickListener getClickListener() {
        return this.clickListener;
    }

    protected void onShow(Actor actor, boolean bl2) {
        actor.getColor().a = 0.0f;
        actor.addAction(Actions.fadeIn(0.3f, Interpolation.fade));
    }

    protected void onHide(Actor actor) {
        actor.getColor().a = 1.0f;
        actor.addAction(Actions.sequence((Action)Actions.fadeOut(0.15f, Interpolation.fade), (Action)Actions.removeActor()));
    }

    public static class SelectBoxStyle {
        public BitmapFont font;
        public Color fontColor = new Color(1.0f, 1.0f, 1.0f, 1.0f);
        @Null
        public Color overFontColor;
        @Null
        public Color disabledFontColor;
        @Null
        public Drawable background;
        public ScrollPane.ScrollPaneStyle scrollStyle;
        public List.ListStyle listStyle;
        @Null
        public Drawable backgroundOver;
        @Null
        public Drawable backgroundOpen;
        @Null
        public Drawable backgroundDisabled;

        public SelectBoxStyle() {
        }

        public SelectBoxStyle(BitmapFont bitmapFont, Color color, @Null Drawable drawable, ScrollPane.ScrollPaneStyle scrollPaneStyle, List.ListStyle listStyle) {
            this.font = bitmapFont;
            this.fontColor.set(color);
            this.background = drawable;
            this.scrollStyle = scrollPaneStyle;
            this.listStyle = listStyle;
        }

        public SelectBoxStyle(SelectBoxStyle selectBoxStyle) {
            this.font = selectBoxStyle.font;
            this.fontColor.set(selectBoxStyle.fontColor);
            if (selectBoxStyle.overFontColor != null) {
                this.overFontColor = new Color(selectBoxStyle.overFontColor);
            }
            if (selectBoxStyle.disabledFontColor != null) {
                this.disabledFontColor = new Color(selectBoxStyle.disabledFontColor);
            }
            this.background = selectBoxStyle.background;
            this.scrollStyle = new ScrollPane.ScrollPaneStyle(selectBoxStyle.scrollStyle);
            this.listStyle = new List.ListStyle(selectBoxStyle.listStyle);
            this.backgroundOver = selectBoxStyle.backgroundOver;
            this.backgroundOpen = selectBoxStyle.backgroundOpen;
            this.backgroundDisabled = selectBoxStyle.backgroundDisabled;
        }
    }

    public static class SelectBoxScrollPane<T>
    extends ScrollPane {
        final SelectBox<T> selectBox;
        int maxListCount;
        private final Vector2 stagePosition = new Vector2();
        final List<T> list;
        private InputListener hideListener;
        private Actor previousScrollFocus;

        public SelectBoxScrollPane(final SelectBox<T> selectBox) {
            super(null, selectBox.style.scrollStyle);
            this.selectBox = selectBox;
            this.setOverscroll(false, false);
            this.setFadeScrollBars(false);
            this.setScrollingDisabled(true, false);
            this.list = this.newList();
            this.list.setTouchable(Touchable.disabled);
            this.list.setTypeToSelect(true);
            this.setActor(this.list);
            this.list.addListener(new ClickListener(){

                @Override
                public void clicked(InputEvent inputEvent, float f2, float f3) {
                    Object t2 = SelectBoxScrollPane.this.list.getSelected();
                    if (t2 != null) {
                        selectBox.selection.items().clear(51);
                    }
                    selectBox.selection.choose(t2);
                    SelectBoxScrollPane.this.hide();
                }

                @Override
                public boolean mouseMoved(InputEvent inputEvent, float f2, float f3) {
                    int n2 = SelectBoxScrollPane.this.list.getItemIndexAt(f3);
                    if (n2 != -1) {
                        SelectBoxScrollPane.this.list.setSelectedIndex(n2);
                    }
                    return true;
                }
            });
            this.addListener(new InputListener(){

                @Override
                public void exit(InputEvent inputEvent, float f2, float f3, int n2, @Null Actor actor) {
                    if (actor == null || !SelectBoxScrollPane.this.isAscendantOf(actor)) {
                        SelectBoxScrollPane.this.list.selection.set(selectBox.getSelected());
                    }
                }
            });
            this.hideListener = new InputListener(){

                @Override
                public boolean touchDown(InputEvent inputEvent, float f2, float f3, int n2, int n3) {
                    Actor actor = inputEvent.getTarget();
                    if (SelectBoxScrollPane.this.isAscendantOf(actor)) {
                        return false;
                    }
                    SelectBoxScrollPane.this.list.selection.set(selectBox.getSelected());
                    SelectBoxScrollPane.this.hide();
                    return false;
                }

                @Override
                public boolean keyDown(InputEvent inputEvent, int n2) {
                    switch (n2) {
                        case 66: 
                        case 160: {
                            selectBox.selection.choose(SelectBoxScrollPane.this.list.getSelected());
                        }
                        case 111: {
                            SelectBoxScrollPane.this.hide();
                            inputEvent.stop();
                            return true;
                        }
                    }
                    return false;
                }
            };
        }

        protected List<T> newList() {
            return new List<T>(this.selectBox.style.listStyle){

                @Override
                public String toString(T t2) {
                    return SelectBoxScrollPane.this.selectBox.toString(t2);
                }
            };
        }

        public void show(Stage stage) {
            Drawable drawable;
            if (this.list.isTouchable()) {
                return;
            }
            stage.addActor(this);
            stage.addCaptureListener(this.hideListener);
            stage.addListener(this.list.getKeyListener());
            this.selectBox.localToStageCoordinates(this.stagePosition.set(0.0f, 0.0f));
            float f2 = this.list.getItemHeight();
            float f3 = f2 * (float)(this.maxListCount <= 0 ? this.selectBox.items.size : Math.min(this.maxListCount, this.selectBox.items.size));
            Drawable drawable2 = this.getStyle().background;
            if (drawable2 != null) {
                f3 += drawable2.getTopHeight() + drawable2.getBottomHeight();
            }
            if ((drawable = this.list.getStyle().background) != null) {
                f3 += drawable.getTopHeight() + drawable.getBottomHeight();
            }
            float f4 = this.stagePosition.y;
            float f5 = stage.getHeight() - f4 - this.selectBox.getHeight();
            boolean bl2 = true;
            if (f3 > f4) {
                if (f5 > f4) {
                    bl2 = false;
                    f3 = Math.min(f3, f5);
                } else {
                    f3 = f4;
                }
            }
            if (bl2) {
                this.setY(this.stagePosition.y - f3);
            } else {
                this.setY(this.stagePosition.y + this.selectBox.getHeight());
            }
            this.setX(this.stagePosition.x);
            this.setHeight(f3);
            this.validate();
            float f6 = Math.max(this.getPrefWidth(), this.selectBox.getWidth());
            this.setWidth(f6);
            this.validate();
            this.scrollTo(0.0f, this.list.getHeight() - (float)this.selectBox.getSelectedIndex() * f2 - f2 / 2.0f, 0.0f, 0.0f, true, true);
            this.updateVisualScroll();
            this.previousScrollFocus = null;
            Actor actor = stage.getScrollFocus();
            if (actor != null && !actor.isDescendantOf(this)) {
                this.previousScrollFocus = actor;
            }
            stage.setScrollFocus(this);
            this.list.selection.set(this.selectBox.getSelected());
            this.list.setTouchable(Touchable.enabled);
            this.clearActions();
            this.selectBox.onShow(this, bl2);
        }

        public void hide() {
            if (!this.list.isTouchable() || !this.hasParent()) {
                return;
            }
            this.list.setTouchable(Touchable.disabled);
            Stage stage = this.getStage();
            if (stage != null) {
                Actor actor;
                stage.removeCaptureListener(this.hideListener);
                stage.removeListener(this.list.getKeyListener());
                if (this.previousScrollFocus != null && this.previousScrollFocus.getStage() == null) {
                    this.previousScrollFocus = null;
                }
                if ((actor = stage.getScrollFocus()) == null || this.isAscendantOf(actor)) {
                    stage.setScrollFocus(this.previousScrollFocus);
                }
            }
            this.clearActions();
            this.selectBox.onHide(this);
        }

        @Override
        public void draw(Batch batch, float f2) {
            this.selectBox.localToStageCoordinates(temp.set(0.0f, 0.0f));
            if (!temp.equals(this.stagePosition)) {
                this.hide();
            }
            super.draw(batch, f2);
        }

        @Override
        public void act(float f2) {
            super.act(f2);
            this.toFront();
        }

        @Override
        public void setStage(Stage stage) {
            Stage stage2 = this.getStage();
            if (stage2 != null) {
                stage2.removeCaptureListener(this.hideListener);
                stage2.removeListener(this.list.getKeyListener());
            }
            super.setStage(stage);
        }

        public List<T> getList() {
            return this.list;
        }

        public SelectBox<T> getSelectBox() {
            return this.selectBox;
        }
    }
}

