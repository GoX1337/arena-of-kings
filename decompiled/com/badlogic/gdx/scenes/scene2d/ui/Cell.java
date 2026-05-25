/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Value;
import com.badlogic.gdx.utils.Null;
import com.badlogic.gdx.utils.Pool;

public class Cell<T extends Actor>
implements Pool.Poolable {
    private static final Float zerof = Float.valueOf(0.0f);
    private static final Float onef = Float.valueOf(1.0f);
    private static final Integer zeroi = 0;
    private static final Integer onei;
    private static final Integer centeri;
    private static final Integer topi;
    private static final Integer bottomi;
    private static final Integer lefti;
    private static final Integer righti;
    private static Files files;
    private static Cell defaults;
    Value minWidth;
    Value minHeight;
    Value prefWidth;
    Value prefHeight;
    Value maxWidth;
    Value maxHeight;
    Value spaceTop;
    Value spaceLeft;
    Value spaceBottom;
    Value spaceRight;
    Value padTop;
    Value padLeft;
    Value padBottom;
    Value padRight;
    Float fillX;
    Float fillY;
    Integer align;
    Integer expandX;
    Integer expandY;
    Integer colspan;
    Boolean uniformX;
    Boolean uniformY;
    @Null
    Actor actor;
    float actorX;
    float actorY;
    float actorWidth;
    float actorHeight;
    private Table table;
    boolean endRow;
    int column;
    int row;
    int cellAboveIndex = -1;
    float computedPadTop;
    float computedPadLeft;
    float computedPadBottom;
    float computedPadRight;

    public Cell() {
        Cell cell = Cell.defaults();
        if (cell != null) {
            this.set(cell);
        }
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public <A extends Actor> Cell<A> setActor(@Null A a2) {
        if (this.actor != a2) {
            if (this.actor != null && this.actor.getParent() == this.table) {
                this.actor.remove();
            }
            this.actor = a2;
            if (a2 != null) {
                this.table.addActor(a2);
            }
        }
        return this;
    }

    public Cell<T> clearActor() {
        this.setActor(null);
        return this;
    }

    @Null
    public T getActor() {
        return (T)this.actor;
    }

    public boolean hasActor() {
        return this.actor != null;
    }

    public Cell<T> size(Value value) {
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

    public Cell<T> size(Value value, Value value2) {
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

    public Cell<T> size(float f2) {
        this.size(Value.Fixed.valueOf(f2));
        return this;
    }

    public Cell<T> size(float f2, float f3) {
        this.size(Value.Fixed.valueOf(f2), Value.Fixed.valueOf(f3));
        return this;
    }

    public Cell<T> width(Value value) {
        if (value == null) {
            throw new IllegalArgumentException("width cannot be null.");
        }
        this.minWidth = value;
        this.prefWidth = value;
        this.maxWidth = value;
        return this;
    }

    public Cell<T> width(float f2) {
        this.width(Value.Fixed.valueOf(f2));
        return this;
    }

    public Cell<T> height(Value value) {
        if (value == null) {
            throw new IllegalArgumentException("height cannot be null.");
        }
        this.minHeight = value;
        this.prefHeight = value;
        this.maxHeight = value;
        return this;
    }

    public Cell<T> height(float f2) {
        this.height(Value.Fixed.valueOf(f2));
        return this;
    }

    public Cell<T> minSize(Value value) {
        if (value == null) {
            throw new IllegalArgumentException("size cannot be null.");
        }
        this.minWidth = value;
        this.minHeight = value;
        return this;
    }

    public Cell<T> minSize(Value value, Value value2) {
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

    public Cell<T> minWidth(Value value) {
        if (value == null) {
            throw new IllegalArgumentException("minWidth cannot be null.");
        }
        this.minWidth = value;
        return this;
    }

    public Cell<T> minHeight(Value value) {
        if (value == null) {
            throw new IllegalArgumentException("minHeight cannot be null.");
        }
        this.minHeight = value;
        return this;
    }

    public Cell<T> minSize(float f2) {
        this.minSize(Value.Fixed.valueOf(f2));
        return this;
    }

    public Cell<T> minSize(float f2, float f3) {
        this.minSize(Value.Fixed.valueOf(f2), Value.Fixed.valueOf(f3));
        return this;
    }

    public Cell<T> minWidth(float f2) {
        this.minWidth = Value.Fixed.valueOf(f2);
        return this;
    }

    public Cell<T> minHeight(float f2) {
        this.minHeight = Value.Fixed.valueOf(f2);
        return this;
    }

    public Cell<T> prefSize(Value value) {
        if (value == null) {
            throw new IllegalArgumentException("size cannot be null.");
        }
        this.prefWidth = value;
        this.prefHeight = value;
        return this;
    }

    public Cell<T> prefSize(Value value, Value value2) {
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

    public Cell<T> prefWidth(Value value) {
        if (value == null) {
            throw new IllegalArgumentException("prefWidth cannot be null.");
        }
        this.prefWidth = value;
        return this;
    }

    public Cell<T> prefHeight(Value value) {
        if (value == null) {
            throw new IllegalArgumentException("prefHeight cannot be null.");
        }
        this.prefHeight = value;
        return this;
    }

    public Cell<T> prefSize(float f2, float f3) {
        this.prefSize(Value.Fixed.valueOf(f2), Value.Fixed.valueOf(f3));
        return this;
    }

    public Cell<T> prefSize(float f2) {
        this.prefSize(Value.Fixed.valueOf(f2));
        return this;
    }

    public Cell<T> prefWidth(float f2) {
        this.prefWidth = Value.Fixed.valueOf(f2);
        return this;
    }

    public Cell<T> prefHeight(float f2) {
        this.prefHeight = Value.Fixed.valueOf(f2);
        return this;
    }

    public Cell<T> maxSize(Value value) {
        if (value == null) {
            throw new IllegalArgumentException("size cannot be null.");
        }
        this.maxWidth = value;
        this.maxHeight = value;
        return this;
    }

    public Cell<T> maxSize(Value value, Value value2) {
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

    public Cell<T> maxWidth(Value value) {
        if (value == null) {
            throw new IllegalArgumentException("maxWidth cannot be null.");
        }
        this.maxWidth = value;
        return this;
    }

    public Cell<T> maxHeight(Value value) {
        if (value == null) {
            throw new IllegalArgumentException("maxHeight cannot be null.");
        }
        this.maxHeight = value;
        return this;
    }

    public Cell<T> maxSize(float f2) {
        this.maxSize(Value.Fixed.valueOf(f2));
        return this;
    }

    public Cell<T> maxSize(float f2, float f3) {
        this.maxSize(Value.Fixed.valueOf(f2), Value.Fixed.valueOf(f3));
        return this;
    }

    public Cell<T> maxWidth(float f2) {
        this.maxWidth = Value.Fixed.valueOf(f2);
        return this;
    }

    public Cell<T> maxHeight(float f2) {
        this.maxHeight = Value.Fixed.valueOf(f2);
        return this;
    }

    public Cell<T> space(Value value) {
        if (value == null) {
            throw new IllegalArgumentException("space cannot be null.");
        }
        this.spaceTop = value;
        this.spaceLeft = value;
        this.spaceBottom = value;
        this.spaceRight = value;
        return this;
    }

    public Cell<T> space(Value value, Value value2, Value value3, Value value4) {
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
        this.spaceTop = value;
        this.spaceLeft = value2;
        this.spaceBottom = value3;
        this.spaceRight = value4;
        return this;
    }

    public Cell<T> spaceTop(Value value) {
        if (value == null) {
            throw new IllegalArgumentException("spaceTop cannot be null.");
        }
        this.spaceTop = value;
        return this;
    }

    public Cell<T> spaceLeft(Value value) {
        if (value == null) {
            throw new IllegalArgumentException("spaceLeft cannot be null.");
        }
        this.spaceLeft = value;
        return this;
    }

    public Cell<T> spaceBottom(Value value) {
        if (value == null) {
            throw new IllegalArgumentException("spaceBottom cannot be null.");
        }
        this.spaceBottom = value;
        return this;
    }

    public Cell<T> spaceRight(Value value) {
        if (value == null) {
            throw new IllegalArgumentException("spaceRight cannot be null.");
        }
        this.spaceRight = value;
        return this;
    }

    public Cell<T> space(float f2) {
        if (f2 < 0.0f) {
            throw new IllegalArgumentException("space cannot be < 0: " + f2);
        }
        this.space(Value.Fixed.valueOf(f2));
        return this;
    }

    public Cell<T> space(float f2, float f3, float f4, float f5) {
        if (f2 < 0.0f) {
            throw new IllegalArgumentException("top cannot be < 0: " + f2);
        }
        if (f3 < 0.0f) {
            throw new IllegalArgumentException("left cannot be < 0: " + f3);
        }
        if (f4 < 0.0f) {
            throw new IllegalArgumentException("bottom cannot be < 0: " + f4);
        }
        if (f5 < 0.0f) {
            throw new IllegalArgumentException("right cannot be < 0: " + f5);
        }
        this.space(Value.Fixed.valueOf(f2), Value.Fixed.valueOf(f3), Value.Fixed.valueOf(f4), Value.Fixed.valueOf(f5));
        return this;
    }

    public Cell<T> spaceTop(float f2) {
        if (f2 < 0.0f) {
            throw new IllegalArgumentException("spaceTop cannot be < 0: " + f2);
        }
        this.spaceTop = Value.Fixed.valueOf(f2);
        return this;
    }

    public Cell<T> spaceLeft(float f2) {
        if (f2 < 0.0f) {
            throw new IllegalArgumentException("spaceLeft cannot be < 0: " + f2);
        }
        this.spaceLeft = Value.Fixed.valueOf(f2);
        return this;
    }

    public Cell<T> spaceBottom(float f2) {
        if (f2 < 0.0f) {
            throw new IllegalArgumentException("spaceBottom cannot be < 0: " + f2);
        }
        this.spaceBottom = Value.Fixed.valueOf(f2);
        return this;
    }

    public Cell<T> spaceRight(float f2) {
        if (f2 < 0.0f) {
            throw new IllegalArgumentException("spaceRight cannot be < 0: " + f2);
        }
        this.spaceRight = Value.Fixed.valueOf(f2);
        return this;
    }

    public Cell<T> pad(Value value) {
        if (value == null) {
            throw new IllegalArgumentException("pad cannot be null.");
        }
        this.padTop = value;
        this.padLeft = value;
        this.padBottom = value;
        this.padRight = value;
        return this;
    }

    public Cell<T> pad(Value value, Value value2, Value value3, Value value4) {
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

    public Cell<T> padTop(Value value) {
        if (value == null) {
            throw new IllegalArgumentException("padTop cannot be null.");
        }
        this.padTop = value;
        return this;
    }

    public Cell<T> padLeft(Value value) {
        if (value == null) {
            throw new IllegalArgumentException("padLeft cannot be null.");
        }
        this.padLeft = value;
        return this;
    }

    public Cell<T> padBottom(Value value) {
        if (value == null) {
            throw new IllegalArgumentException("padBottom cannot be null.");
        }
        this.padBottom = value;
        return this;
    }

    public Cell<T> padRight(Value value) {
        if (value == null) {
            throw new IllegalArgumentException("padRight cannot be null.");
        }
        this.padRight = value;
        return this;
    }

    public Cell<T> pad(float f2) {
        this.pad(Value.Fixed.valueOf(f2));
        return this;
    }

    public Cell<T> pad(float f2, float f3, float f4, float f5) {
        this.pad(Value.Fixed.valueOf(f2), Value.Fixed.valueOf(f3), Value.Fixed.valueOf(f4), Value.Fixed.valueOf(f5));
        return this;
    }

    public Cell<T> padTop(float f2) {
        this.padTop = Value.Fixed.valueOf(f2);
        return this;
    }

    public Cell<T> padLeft(float f2) {
        this.padLeft = Value.Fixed.valueOf(f2);
        return this;
    }

    public Cell<T> padBottom(float f2) {
        this.padBottom = Value.Fixed.valueOf(f2);
        return this;
    }

    public Cell<T> padRight(float f2) {
        this.padRight = Value.Fixed.valueOf(f2);
        return this;
    }

    public Cell<T> fill() {
        this.fillX = onef;
        this.fillY = onef;
        return this;
    }

    public Cell<T> fillX() {
        this.fillX = onef;
        return this;
    }

    public Cell<T> fillY() {
        this.fillY = onef;
        return this;
    }

    public Cell<T> fill(float f2, float f3) {
        this.fillX = Float.valueOf(f2);
        this.fillY = Float.valueOf(f3);
        return this;
    }

    public Cell<T> fill(boolean bl2, boolean bl3) {
        this.fillX = bl2 ? onef : zerof;
        this.fillY = bl3 ? onef : zerof;
        return this;
    }

    public Cell<T> fill(boolean bl2) {
        this.fillX = bl2 ? onef : zerof;
        this.fillY = bl2 ? onef : zerof;
        return this;
    }

    public Cell<T> align(int n2) {
        this.align = n2;
        return this;
    }

    public Cell<T> center() {
        this.align = centeri;
        return this;
    }

    public Cell<T> top() {
        this.align = this.align == null ? topi : Integer.valueOf((this.align | 2) & 0xFFFFFFFB);
        return this;
    }

    public Cell<T> left() {
        this.align = this.align == null ? lefti : Integer.valueOf((this.align | 8) & 0xFFFFFFEF);
        return this;
    }

    public Cell<T> bottom() {
        this.align = this.align == null ? bottomi : Integer.valueOf((this.align | 4) & 0xFFFFFFFD);
        return this;
    }

    public Cell<T> right() {
        this.align = this.align == null ? righti : Integer.valueOf((this.align | 0x10) & 0xFFFFFFF7);
        return this;
    }

    public Cell<T> grow() {
        this.expandX = onei;
        this.expandY = onei;
        this.fillX = onef;
        this.fillY = onef;
        return this;
    }

    public Cell<T> growX() {
        this.expandX = onei;
        this.fillX = onef;
        return this;
    }

    public Cell<T> growY() {
        this.expandY = onei;
        this.fillY = onef;
        return this;
    }

    public Cell<T> expand() {
        this.expandX = onei;
        this.expandY = onei;
        return this;
    }

    public Cell<T> expandX() {
        this.expandX = onei;
        return this;
    }

    public Cell<T> expandY() {
        this.expandY = onei;
        return this;
    }

    public Cell<T> expand(int n2, int n3) {
        this.expandX = n2;
        this.expandY = n3;
        return this;
    }

    public Cell<T> expand(boolean bl2, boolean bl3) {
        this.expandX = bl2 ? onei : zeroi;
        this.expandY = bl3 ? onei : zeroi;
        return this;
    }

    public Cell<T> colspan(int n2) {
        this.colspan = n2;
        return this;
    }

    public Cell<T> uniform() {
        this.uniformX = Boolean.TRUE;
        this.uniformY = Boolean.TRUE;
        return this;
    }

    public Cell<T> uniformX() {
        this.uniformX = Boolean.TRUE;
        return this;
    }

    public Cell<T> uniformY() {
        this.uniformY = Boolean.TRUE;
        return this;
    }

    public Cell<T> uniform(boolean bl2) {
        this.uniformX = bl2;
        this.uniformY = bl2;
        return this;
    }

    public Cell<T> uniform(boolean bl2, boolean bl3) {
        this.uniformX = bl2;
        this.uniformY = bl3;
        return this;
    }

    public void setActorBounds(float f2, float f3, float f4, float f5) {
        this.actorX = f2;
        this.actorY = f3;
        this.actorWidth = f4;
        this.actorHeight = f5;
    }

    public float getActorX() {
        return this.actorX;
    }

    public void setActorX(float f2) {
        this.actorX = f2;
    }

    public float getActorY() {
        return this.actorY;
    }

    public void setActorY(float f2) {
        this.actorY = f2;
    }

    public float getActorWidth() {
        return this.actorWidth;
    }

    public void setActorWidth(float f2) {
        this.actorWidth = f2;
    }

    public float getActorHeight() {
        return this.actorHeight;
    }

    public void setActorHeight(float f2) {
        this.actorHeight = f2;
    }

    public int getColumn() {
        return this.column;
    }

    public int getRow() {
        return this.row;
    }

    @Null
    public Value getMinWidthValue() {
        return this.minWidth;
    }

    public float getMinWidth() {
        return this.minWidth.get(this.actor);
    }

    @Null
    public Value getMinHeightValue() {
        return this.minHeight;
    }

    public float getMinHeight() {
        return this.minHeight.get(this.actor);
    }

    @Null
    public Value getPrefWidthValue() {
        return this.prefWidth;
    }

    public float getPrefWidth() {
        return this.prefWidth.get(this.actor);
    }

    @Null
    public Value getPrefHeightValue() {
        return this.prefHeight;
    }

    public float getPrefHeight() {
        return this.prefHeight.get(this.actor);
    }

    @Null
    public Value getMaxWidthValue() {
        return this.maxWidth;
    }

    public float getMaxWidth() {
        return this.maxWidth.get(this.actor);
    }

    @Null
    public Value getMaxHeightValue() {
        return this.maxHeight;
    }

    public float getMaxHeight() {
        return this.maxHeight.get(this.actor);
    }

    @Null
    public Value getSpaceTopValue() {
        return this.spaceTop;
    }

    public float getSpaceTop() {
        return this.spaceTop.get(this.actor);
    }

    @Null
    public Value getSpaceLeftValue() {
        return this.spaceLeft;
    }

    public float getSpaceLeft() {
        return this.spaceLeft.get(this.actor);
    }

    @Null
    public Value getSpaceBottomValue() {
        return this.spaceBottom;
    }

    public float getSpaceBottom() {
        return this.spaceBottom.get(this.actor);
    }

    @Null
    public Value getSpaceRightValue() {
        return this.spaceRight;
    }

    public float getSpaceRight() {
        return this.spaceRight.get(this.actor);
    }

    @Null
    public Value getPadTopValue() {
        return this.padTop;
    }

    public float getPadTop() {
        return this.padTop.get(this.actor);
    }

    @Null
    public Value getPadLeftValue() {
        return this.padLeft;
    }

    public float getPadLeft() {
        return this.padLeft.get(this.actor);
    }

    @Null
    public Value getPadBottomValue() {
        return this.padBottom;
    }

    public float getPadBottom() {
        return this.padBottom.get(this.actor);
    }

    @Null
    public Value getPadRightValue() {
        return this.padRight;
    }

    public float getPadRight() {
        return this.padRight.get(this.actor);
    }

    public float getPadX() {
        return this.padLeft.get(this.actor) + this.padRight.get(this.actor);
    }

    public float getPadY() {
        return this.padTop.get(this.actor) + this.padBottom.get(this.actor);
    }

    public float getFillX() {
        return this.fillX.floatValue();
    }

    public float getFillY() {
        return this.fillY.floatValue();
    }

    public int getAlign() {
        return this.align;
    }

    public int getExpandX() {
        return this.expandX;
    }

    public int getExpandY() {
        return this.expandY;
    }

    public int getColspan() {
        return this.colspan;
    }

    public boolean getUniformX() {
        return this.uniformX;
    }

    public boolean getUniformY() {
        return this.uniformY;
    }

    public boolean isEndRow() {
        return this.endRow;
    }

    public float getComputedPadTop() {
        return this.computedPadTop;
    }

    public float getComputedPadLeft() {
        return this.computedPadLeft;
    }

    public float getComputedPadBottom() {
        return this.computedPadBottom;
    }

    public float getComputedPadRight() {
        return this.computedPadRight;
    }

    public void row() {
        this.table.row();
    }

    public Table getTable() {
        return this.table;
    }

    void clear() {
        this.minWidth = null;
        this.minHeight = null;
        this.prefWidth = null;
        this.prefHeight = null;
        this.maxWidth = null;
        this.maxHeight = null;
        this.spaceTop = null;
        this.spaceLeft = null;
        this.spaceBottom = null;
        this.spaceRight = null;
        this.padTop = null;
        this.padLeft = null;
        this.padBottom = null;
        this.padRight = null;
        this.fillX = null;
        this.fillY = null;
        this.align = null;
        this.expandX = null;
        this.expandY = null;
        this.colspan = null;
        this.uniformX = null;
        this.uniformY = null;
    }

    @Override
    public void reset() {
        this.actor = null;
        this.table = null;
        this.endRow = false;
        this.cellAboveIndex = -1;
        this.set(Cell.defaults());
    }

    void set(Cell cell) {
        this.minWidth = cell.minWidth;
        this.minHeight = cell.minHeight;
        this.prefWidth = cell.prefWidth;
        this.prefHeight = cell.prefHeight;
        this.maxWidth = cell.maxWidth;
        this.maxHeight = cell.maxHeight;
        this.spaceTop = cell.spaceTop;
        this.spaceLeft = cell.spaceLeft;
        this.spaceBottom = cell.spaceBottom;
        this.spaceRight = cell.spaceRight;
        this.padTop = cell.padTop;
        this.padLeft = cell.padLeft;
        this.padBottom = cell.padBottom;
        this.padRight = cell.padRight;
        this.fillX = cell.fillX;
        this.fillY = cell.fillY;
        this.align = cell.align;
        this.expandX = cell.expandX;
        this.expandY = cell.expandY;
        this.colspan = cell.colspan;
        this.uniformX = cell.uniformX;
        this.uniformY = cell.uniformY;
    }

    void merge(@Null Cell cell) {
        if (cell == null) {
            return;
        }
        if (cell.minWidth != null) {
            this.minWidth = cell.minWidth;
        }
        if (cell.minHeight != null) {
            this.minHeight = cell.minHeight;
        }
        if (cell.prefWidth != null) {
            this.prefWidth = cell.prefWidth;
        }
        if (cell.prefHeight != null) {
            this.prefHeight = cell.prefHeight;
        }
        if (cell.maxWidth != null) {
            this.maxWidth = cell.maxWidth;
        }
        if (cell.maxHeight != null) {
            this.maxHeight = cell.maxHeight;
        }
        if (cell.spaceTop != null) {
            this.spaceTop = cell.spaceTop;
        }
        if (cell.spaceLeft != null) {
            this.spaceLeft = cell.spaceLeft;
        }
        if (cell.spaceBottom != null) {
            this.spaceBottom = cell.spaceBottom;
        }
        if (cell.spaceRight != null) {
            this.spaceRight = cell.spaceRight;
        }
        if (cell.padTop != null) {
            this.padTop = cell.padTop;
        }
        if (cell.padLeft != null) {
            this.padLeft = cell.padLeft;
        }
        if (cell.padBottom != null) {
            this.padBottom = cell.padBottom;
        }
        if (cell.padRight != null) {
            this.padRight = cell.padRight;
        }
        if (cell.fillX != null) {
            this.fillX = cell.fillX;
        }
        if (cell.fillY != null) {
            this.fillY = cell.fillY;
        }
        if (cell.align != null) {
            this.align = cell.align;
        }
        if (cell.expandX != null) {
            this.expandX = cell.expandX;
        }
        if (cell.expandY != null) {
            this.expandY = cell.expandY;
        }
        if (cell.colspan != null) {
            this.colspan = cell.colspan;
        }
        if (cell.uniformX != null) {
            this.uniformX = cell.uniformX;
        }
        if (cell.uniformY != null) {
            this.uniformY = cell.uniformY;
        }
    }

    public String toString() {
        return this.actor != null ? this.actor.toString() : super.toString();
    }

    public static Cell defaults() {
        if (files == null || files != Gdx.files) {
            files = Gdx.files;
            defaults = new Cell();
            Cell.defaults.minWidth = Value.minWidth;
            Cell.defaults.minHeight = Value.minHeight;
            Cell.defaults.prefWidth = Value.prefWidth;
            Cell.defaults.prefHeight = Value.prefHeight;
            Cell.defaults.maxWidth = Value.maxWidth;
            Cell.defaults.maxHeight = Value.maxHeight;
            Cell.defaults.spaceTop = Value.zero;
            Cell.defaults.spaceLeft = Value.zero;
            Cell.defaults.spaceBottom = Value.zero;
            Cell.defaults.spaceRight = Value.zero;
            Cell.defaults.padTop = Value.zero;
            Cell.defaults.padLeft = Value.zero;
            Cell.defaults.padBottom = Value.zero;
            Cell.defaults.padRight = Value.zero;
            Cell.defaults.fillX = zerof;
            Cell.defaults.fillY = zerof;
            Cell.defaults.align = centeri;
            Cell.defaults.expandX = zeroi;
            Cell.defaults.expandY = zeroi;
            Cell.defaults.colspan = onei;
            Cell.defaults.uniformX = null;
            Cell.defaults.uniformY = null;
        }
        return defaults;
    }

    static {
        centeri = onei = Integer.valueOf(1);
        topi = 2;
        bottomi = 4;
        lefti = 8;
        righti = 16;
    }
}

