/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Widget;
import com.badlogic.gdx.scenes.scene2d.utils.ArraySelection;
import com.badlogic.gdx.scenes.scene2d.utils.Cullable;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.UIUtils;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Null;
import com.badlogic.gdx.utils.OrderedSet;
import com.badlogic.gdx.utils.Pool;
import com.badlogic.gdx.utils.Pools;

public class List<T>
extends Widget
implements Cullable {
    ListStyle style;
    final Array<T> items = new Array();
    ArraySelection<T> selection = new ArraySelection<T>(this.items);
    private Rectangle cullingArea;
    private float prefWidth;
    private float prefHeight;
    float itemHeight;
    private int alignment = 8;
    int pressedIndex = -1;
    int overIndex = -1;
    private InputListener keyListener;
    boolean typeToSelect;

    public List(Skin skin) {
        this(skin.get(ListStyle.class));
    }

    public List(Skin skin, String string) {
        this(skin.get(string, ListStyle.class));
    }

    public List(ListStyle listStyle) {
        this.selection.setActor(this);
        this.selection.setRequired(true);
        this.setStyle(listStyle);
        this.setSize(this.getPrefWidth(), this.getPrefHeight());
        this.keyListener = new InputListener(){
            long typeTimeout;
            String prefix;

            @Override
            public boolean keyDown(InputEvent inputEvent, int n2) {
                if (List.this.items.isEmpty()) {
                    return false;
                }
                switch (n2) {
                    case 29: {
                        if (!UIUtils.ctrl() || !List.this.selection.getMultiple()) break;
                        List.this.selection.clear();
                        List.this.selection.addAll(List.this.items);
                        return true;
                    }
                    case 3: {
                        List.this.setSelectedIndex(0);
                        return true;
                    }
                    case 123: {
                        List.this.setSelectedIndex(List.this.items.size - 1);
                        return true;
                    }
                    case 20: {
                        int n3 = List.this.items.indexOf(List.this.getSelected(), false) + 1;
                        if (n3 >= List.this.items.size) {
                            n3 = 0;
                        }
                        List.this.setSelectedIndex(n3);
                        return true;
                    }
                    case 19: {
                        int n4 = List.this.items.indexOf(List.this.getSelected(), false) - 1;
                        if (n4 < 0) {
                            n4 = List.this.items.size - 1;
                        }
                        List.this.setSelectedIndex(n4);
                        return true;
                    }
                    case 111: {
                        if (List.this.getStage() != null) {
                            List.this.getStage().setKeyboardFocus(null);
                        }
                        return true;
                    }
                }
                return false;
            }

            @Override
            public boolean keyTyped(InputEvent inputEvent, char c2) {
                if (!List.this.typeToSelect) {
                    return false;
                }
                long l2 = System.currentTimeMillis();
                if (l2 > this.typeTimeout) {
                    this.prefix = "";
                }
                this.typeTimeout = l2 + 300L;
                this.prefix = this.prefix + Character.toLowerCase(c2);
                int n2 = List.this.items.size;
                for (int i2 = 0; i2 < n2; ++i2) {
                    if (!List.this.toString(List.this.items.get(i2)).toLowerCase().startsWith(this.prefix)) continue;
                    List.this.setSelectedIndex(i2);
                    break;
                }
                return false;
            }
        };
        this.addListener(this.keyListener);
        this.addListener(new InputListener(){

            @Override
            public boolean touchDown(InputEvent inputEvent, float f2, float f3, int n2, int n3) {
                if (n2 != 0 || n3 != 0) {
                    return true;
                }
                if (List.this.selection.isDisabled()) {
                    return true;
                }
                if (List.this.getStage() != null) {
                    List.this.getStage().setKeyboardFocus(List.this);
                }
                if (List.this.items.size == 0) {
                    return true;
                }
                int n4 = List.this.getItemIndexAt(f3);
                if (n4 == -1) {
                    return true;
                }
                List.this.selection.choose(List.this.items.get(n4));
                List.this.pressedIndex = n4;
                return true;
            }

            @Override
            public void touchUp(InputEvent inputEvent, float f2, float f3, int n2, int n3) {
                if (n2 != 0 || n3 != 0) {
                    return;
                }
                List.this.pressedIndex = -1;
            }

            @Override
            public void touchDragged(InputEvent inputEvent, float f2, float f3, int n2) {
                List.this.overIndex = List.this.getItemIndexAt(f3);
            }

            @Override
            public boolean mouseMoved(InputEvent inputEvent, float f2, float f3) {
                List.this.overIndex = List.this.getItemIndexAt(f3);
                return false;
            }

            @Override
            public void exit(InputEvent inputEvent, float f2, float f3, int n2, Actor actor) {
                if (n2 == 0) {
                    List.this.pressedIndex = -1;
                }
                if (n2 == -1) {
                    List.this.overIndex = -1;
                }
            }
        });
    }

    public void setStyle(ListStyle listStyle) {
        if (listStyle == null) {
            throw new IllegalArgumentException("style cannot be null.");
        }
        this.style = listStyle;
        this.invalidateHierarchy();
    }

    public ListStyle getStyle() {
        return this.style;
    }

    @Override
    public void layout() {
        BitmapFont bitmapFont = this.style.font;
        Drawable drawable = this.style.selection;
        this.itemHeight = bitmapFont.getCapHeight() - bitmapFont.getDescent() * 2.0f;
        this.itemHeight += drawable.getTopHeight() + drawable.getBottomHeight();
        this.prefWidth = 0.0f;
        Pool<GlyphLayout> pool = Pools.get(GlyphLayout.class);
        GlyphLayout glyphLayout = pool.obtain();
        for (int i2 = 0; i2 < this.items.size; ++i2) {
            glyphLayout.setText(bitmapFont, this.toString(this.items.get(i2)));
            this.prefWidth = Math.max(glyphLayout.width, this.prefWidth);
        }
        pool.free(glyphLayout);
        this.prefWidth += drawable.getLeftWidth() + drawable.getRightWidth();
        this.prefHeight = (float)this.items.size * this.itemHeight;
        Drawable drawable2 = this.style.background;
        if (drawable2 != null) {
            this.prefWidth = Math.max(this.prefWidth + drawable2.getLeftWidth() + drawable2.getRightWidth(), drawable2.getMinWidth());
            this.prefHeight = Math.max(this.prefHeight + drawable2.getTopHeight() + drawable2.getBottomHeight(), drawable2.getMinHeight());
        }
    }

    @Override
    public void draw(Batch batch, float f2) {
        float f3;
        float f4;
        this.validate();
        this.drawBackground(batch, f2);
        BitmapFont bitmapFont = this.style.font;
        Drawable drawable = this.style.selection;
        Color color = this.style.fontColorSelected;
        Color color2 = this.style.fontColorUnselected;
        Color color3 = this.getColor();
        batch.setColor(color3.r, color3.g, color3.b, color3.a * f2);
        float f5 = this.getX();
        float f6 = this.getY();
        float f7 = this.getWidth();
        float f8 = f4 = this.getHeight();
        Drawable drawable2 = this.style.background;
        if (drawable2 != null) {
            f3 = drawable2.getLeftWidth();
            f5 += f3;
            f8 -= drawable2.getTopHeight();
            f7 -= f3 + drawable2.getRightWidth();
        }
        f3 = drawable.getLeftWidth();
        float f9 = f7 - f3 - drawable.getRightWidth();
        float f10 = drawable.getTopHeight() - bitmapFont.getDescent();
        bitmapFont.setColor(color2.r, color2.g, color2.b, color2.a * f2);
        for (int i2 = 0; i2 < this.items.size; ++i2) {
            if (this.cullingArea == null || f8 - this.itemHeight <= this.cullingArea.y + this.cullingArea.height && f8 >= this.cullingArea.y) {
                T t2 = this.items.get(i2);
                boolean bl2 = this.selection.contains(t2);
                Drawable drawable3 = null;
                if (this.pressedIndex == i2 && this.style.down != null) {
                    drawable3 = this.style.down;
                } else if (bl2) {
                    drawable3 = drawable;
                    bitmapFont.setColor(color.r, color.g, color.b, color.a * f2);
                } else if (this.overIndex == i2 && this.style.over != null) {
                    drawable3 = this.style.over;
                }
                this.drawSelection(batch, drawable3, f5, f6 + f8 - this.itemHeight, f7, this.itemHeight);
                this.drawItem(batch, bitmapFont, i2, t2, f5 + f3, f6 + f8 - f10, f9);
                if (bl2) {
                    bitmapFont.setColor(color2.r, color2.g, color2.b, color2.a * f2);
                }
            } else if (f8 < this.cullingArea.y) break;
            f8 -= this.itemHeight;
        }
    }

    protected void drawSelection(Batch batch, @Null Drawable drawable, float f2, float f3, float f4, float f5) {
        if (drawable != null) {
            drawable.draw(batch, f2, f3, f4, f5);
        }
    }

    protected void drawBackground(Batch batch, float f2) {
        if (this.style.background != null) {
            Color color = this.getColor();
            batch.setColor(color.r, color.g, color.b, color.a * f2);
            this.style.background.draw(batch, this.getX(), this.getY(), this.getWidth(), this.getHeight());
        }
    }

    protected GlyphLayout drawItem(Batch batch, BitmapFont bitmapFont, int n2, T t2, float f2, float f3, float f4) {
        String string = this.toString(t2);
        return bitmapFont.draw(batch, string, f2, f3, 0, string.length(), f4, this.alignment, false, "...");
    }

    public ArraySelection<T> getSelection() {
        return this.selection;
    }

    public void setSelection(ArraySelection<T> arraySelection) {
        this.selection = arraySelection;
    }

    @Null
    public T getSelected() {
        return this.selection.first();
    }

    public void setSelected(@Null T t2) {
        if (this.items.contains(t2, false)) {
            this.selection.set(t2);
        } else if (this.selection.getRequired() && this.items.size > 0) {
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
        if (n2 < -1 || n2 >= this.items.size) {
            throw new IllegalArgumentException("index must be >= -1 and < " + this.items.size + ": " + n2);
        }
        if (n2 == -1) {
            this.selection.clear();
        } else {
            this.selection.set(this.items.get(n2));
        }
    }

    public T getOverItem() {
        return this.overIndex == -1 ? null : (T)this.items.get(this.overIndex);
    }

    public T getPressedItem() {
        return this.pressedIndex == -1 ? null : (T)this.items.get(this.pressedIndex);
    }

    @Null
    public T getItemAt(float f2) {
        int n2 = this.getItemIndexAt(f2);
        if (n2 == -1) {
            return null;
        }
        return this.items.get(n2);
    }

    public int getItemIndexAt(float f2) {
        int n2;
        float f3 = this.getHeight();
        Drawable drawable = this.style.background;
        if (drawable != null) {
            f3 -= drawable.getTopHeight() + drawable.getBottomHeight();
            f2 -= drawable.getBottomHeight();
        }
        if ((n2 = (int)((f3 - f2) / this.itemHeight)) < 0 || n2 >= this.items.size) {
            return -1;
        }
        return n2;
    }

    public void setItems(T ... TArray) {
        if (TArray == null) {
            throw new IllegalArgumentException("newItems cannot be null.");
        }
        float f2 = this.getPrefWidth();
        float f3 = this.getPrefHeight();
        this.items.clear();
        this.items.addAll(TArray);
        this.overIndex = -1;
        this.pressedIndex = -1;
        this.selection.validate();
        this.invalidate();
        if (f2 != this.getPrefWidth() || f3 != this.getPrefHeight()) {
            this.invalidateHierarchy();
        }
    }

    public void setItems(Array array) {
        if (array == null) {
            throw new IllegalArgumentException("newItems cannot be null.");
        }
        float f2 = this.getPrefWidth();
        float f3 = this.getPrefHeight();
        if (array != this.items) {
            this.items.clear();
            this.items.addAll(array);
        }
        this.overIndex = -1;
        this.pressedIndex = -1;
        this.selection.validate();
        this.invalidate();
        if (f2 != this.getPrefWidth() || f3 != this.getPrefHeight()) {
            this.invalidateHierarchy();
        }
    }

    public void clearItems() {
        if (this.items.size == 0) {
            return;
        }
        this.items.clear();
        this.overIndex = -1;
        this.pressedIndex = -1;
        this.selection.clear();
        this.invalidateHierarchy();
    }

    public Array<T> getItems() {
        return this.items;
    }

    public float getItemHeight() {
        return this.itemHeight;
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

    public String toString(T t2) {
        return t2.toString();
    }

    @Override
    public void setCullingArea(@Null Rectangle rectangle) {
        this.cullingArea = rectangle;
    }

    public Rectangle getCullingArea() {
        return this.cullingArea;
    }

    public void setAlignment(int n2) {
        this.alignment = n2;
    }

    public int getAlignment() {
        return this.alignment;
    }

    public void setTypeToSelect(boolean bl2) {
        this.typeToSelect = bl2;
    }

    public InputListener getKeyListener() {
        return this.keyListener;
    }

    public static class ListStyle {
        public BitmapFont font;
        public Color fontColorSelected = new Color(1.0f, 1.0f, 1.0f, 1.0f);
        public Color fontColorUnselected = new Color(1.0f, 1.0f, 1.0f, 1.0f);
        public Drawable selection;
        @Null
        public Drawable down;
        @Null
        public Drawable over;
        @Null
        public Drawable background;

        public ListStyle() {
        }

        public ListStyle(BitmapFont bitmapFont, Color color, Color color2, Drawable drawable) {
            this.font = bitmapFont;
            this.fontColorSelected.set(color);
            this.fontColorUnselected.set(color2);
            this.selection = drawable;
        }

        public ListStyle(ListStyle listStyle) {
            this.font = listStyle.font;
            this.fontColorSelected.set(listStyle.fontColorSelected);
            this.fontColorUnselected.set(listStyle.fontColorUnselected);
            this.selection = listStyle.selection;
            this.down = listStyle.down;
            this.over = listStyle.over;
            this.background = listStyle.background;
        }
    }
}

