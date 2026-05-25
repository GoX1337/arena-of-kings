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
import com.badlogic.gdx.scenes.scene2d.ui.Cell;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Stack;
import com.badlogic.gdx.scenes.scene2d.ui.Value;
import com.badlogic.gdx.scenes.scene2d.ui.WidgetGroup;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.Layout;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Null;
import com.badlogic.gdx.utils.Pool;
import com.badlogic.gdx.utils.Pools;
import com.badlogic.gdx.utils.SnapshotArray;
import java.util.Arrays;

public class Table
extends WidgetGroup {
    public static Color debugTableColor = new Color(0.0f, 0.0f, 1.0f, 1.0f);
    public static Color debugCellColor = new Color(1.0f, 0.0f, 0.0f, 1.0f);
    public static Color debugActorColor = new Color(0.0f, 1.0f, 0.0f, 1.0f);
    static final Pool<Cell> cellPool = new Pool<Cell>(){

        @Override
        protected Cell newObject() {
            return new Cell();
        }
    };
    private static float[] columnWeightedWidth;
    private static float[] rowWeightedHeight;
    private int columns;
    private int rows;
    private boolean implicitEndRow;
    private final Array<Cell> cells = new Array(4);
    private final Cell cellDefaults;
    private final Array<Cell> columnDefaults = new Array(2);
    private Cell rowDefaults;
    private boolean sizeInvalid = true;
    private float[] columnMinWidth;
    private float[] rowMinHeight;
    private float[] columnPrefWidth;
    private float[] rowPrefHeight;
    private float tableMinWidth;
    private float tableMinHeight;
    private float tablePrefWidth;
    private float tablePrefHeight;
    private float[] columnWidth;
    private float[] rowHeight;
    private float[] expandWidth;
    private float[] expandHeight;
    Value padTop = backgroundTop;
    Value padLeft = backgroundLeft;
    Value padBottom = backgroundBottom;
    Value padRight = backgroundRight;
    int align = 1;
    Debug debug = Debug.none;
    Array<DebugRect> debugRects;
    @Null
    Drawable background;
    private boolean clip;
    @Null
    private Skin skin;
    boolean round = true;
    public static Value backgroundTop;
    public static Value backgroundLeft;
    public static Value backgroundBottom;
    public static Value backgroundRight;

    public Table() {
        this((Skin)null);
    }

    public Table(@Null Skin skin) {
        this.skin = skin;
        this.cellDefaults = this.obtainCell();
        this.setTransform(false);
        this.setTouchable(Touchable.childrenOnly);
    }

    private Cell obtainCell() {
        Cell cell = cellPool.obtain();
        cell.setTable(this);
        return cell;
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

    public void setBackground(String string) {
        if (this.skin == null) {
            throw new IllegalStateException("Table must have a skin set to use this method.");
        }
        this.setBackground(this.skin.getDrawable(string));
    }

    public void setBackground(@Null Drawable drawable) {
        if (this.background == drawable) {
            return;
        }
        float f2 = this.getPadTop();
        float f3 = this.getPadLeft();
        float f4 = this.getPadBottom();
        float f5 = this.getPadRight();
        this.background = drawable;
        float f6 = this.getPadTop();
        float f7 = this.getPadLeft();
        float f8 = this.getPadBottom();
        float f9 = this.getPadRight();
        if (f2 + f4 != f6 + f8 || f3 + f5 != f7 + f9) {
            this.invalidateHierarchy();
        } else if (f2 != f6 || f3 != f7 || f4 != f8 || f5 != f9) {
            this.invalidate();
        }
    }

    public Table background(@Null Drawable drawable) {
        this.setBackground(drawable);
        return this;
    }

    public Table background(String string) {
        this.setBackground(string);
        return this;
    }

    @Null
    public Drawable getBackground() {
        return this.background;
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

    public Table clip() {
        this.setClip(true);
        return this;
    }

    public Table clip(boolean bl2) {
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
    public void invalidate() {
        this.sizeInvalid = true;
        super.invalidate();
    }

    public <T extends Actor> Cell<T> add(@Null T t2) {
        Cell cell;
        block10: {
            int n2;
            cell = this.obtainCell();
            cell.actor = t2;
            if (this.implicitEndRow) {
                this.implicitEndRow = false;
                --this.rows;
                this.cells.peek().endRow = false;
            }
            if ((n2 = this.cells.size) > 0) {
                Cell cell2 = this.cells.peek();
                if (!cell2.endRow) {
                    cell.column = cell2.column + cell2.colspan;
                    cell.row = cell2.row;
                } else {
                    cell.column = 0;
                    cell.row = cell2.row + 1;
                }
                if (cell.row > 0) {
                    T[] TArray = this.cells.items;
                    for (int i2 = n2 - 1; i2 >= 0; --i2) {
                        int n3;
                        Cell cell3 = (Cell)TArray[i2];
                        int n4 = n3 + cell3.colspan;
                        for (n3 = cell3.column; n3 < n4; ++n3) {
                            if (n3 != cell.column) continue;
                            cell.cellAboveIndex = i2;
                            break block10;
                        }
                    }
                }
            } else {
                cell.column = 0;
                cell.row = 0;
            }
        }
        this.cells.add(cell);
        cell.set(this.cellDefaults);
        if (cell.column < this.columnDefaults.size) {
            cell.merge(this.columnDefaults.get(cell.column));
        }
        cell.merge(this.rowDefaults);
        if (t2 != null) {
            this.addActor(t2);
        }
        return cell;
    }

    public Table add(Actor ... actorArray) {
        int n2 = actorArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            this.add((T)actorArray[i2]);
        }
        return this;
    }

    public Cell<Label> add(@Null CharSequence charSequence) {
        if (this.skin == null) {
            throw new IllegalStateException("Table must have a skin set to use this method.");
        }
        return this.add((T)new Label(charSequence, this.skin));
    }

    public Cell<Label> add(@Null CharSequence charSequence, String string) {
        if (this.skin == null) {
            throw new IllegalStateException("Table must have a skin set to use this method.");
        }
        return this.add((T)new Label(charSequence, this.skin.get(string, Label.LabelStyle.class)));
    }

    public Cell<Label> add(@Null CharSequence charSequence, String string, @Null Color color) {
        if (this.skin == null) {
            throw new IllegalStateException("Table must have a skin set to use this method.");
        }
        return this.add((T)new Label(charSequence, new Label.LabelStyle(this.skin.getFont(string), color)));
    }

    public Cell<Label> add(@Null CharSequence charSequence, String string, String string2) {
        if (this.skin == null) {
            throw new IllegalStateException("Table must have a skin set to use this method.");
        }
        return this.add((T)new Label(charSequence, new Label.LabelStyle(this.skin.getFont(string), this.skin.getColor(string2))));
    }

    public Cell add() {
        return this.add((T)null);
    }

    public Cell<Stack> stack(Actor ... actorArray) {
        Stack stack = new Stack();
        if (actorArray != null) {
            int n2 = actorArray.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                stack.addActor(actorArray[i2]);
            }
        }
        return this.add((T)stack);
    }

    @Override
    public boolean removeActor(Actor actor) {
        return this.removeActor(actor, true);
    }

    @Override
    public boolean removeActor(Actor actor, boolean bl2) {
        if (!super.removeActor(actor, bl2)) {
            return false;
        }
        Cell<Actor> cell = this.getCell(actor);
        if (cell != null) {
            cell.actor = null;
        }
        return true;
    }

    @Override
    public Actor removeActorAt(int n2, boolean bl2) {
        Actor actor = super.removeActorAt(n2, bl2);
        Cell<Actor> cell = this.getCell(actor);
        if (cell != null) {
            cell.actor = null;
        }
        return actor;
    }

    @Override
    public void clearChildren(boolean bl2) {
        T[] TArray = this.cells.items;
        for (int i2 = this.cells.size - 1; i2 >= 0; --i2) {
            Cell cell = (Cell)TArray[i2];
            Actor actor = cell.actor;
            if (actor == null) continue;
            actor.remove();
        }
        cellPool.freeAll(this.cells);
        this.cells.clear();
        this.rows = 0;
        this.columns = 0;
        if (this.rowDefaults != null) {
            cellPool.free(this.rowDefaults);
        }
        this.rowDefaults = null;
        this.implicitEndRow = false;
        super.clearChildren(bl2);
    }

    public void reset() {
        this.clearChildren();
        this.padTop = backgroundTop;
        this.padLeft = backgroundLeft;
        this.padBottom = backgroundBottom;
        this.padRight = backgroundRight;
        this.align = 1;
        this.debug(Debug.none);
        this.cellDefaults.reset();
        int n2 = this.columnDefaults.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            Cell cell = this.columnDefaults.get(i2);
            if (cell == null) continue;
            cellPool.free(cell);
        }
        this.columnDefaults.clear();
    }

    public Cell row() {
        if (this.cells.size > 0) {
            if (!this.implicitEndRow) {
                if (this.cells.peek().endRow) {
                    return this.rowDefaults;
                }
                this.endRow();
            }
            this.invalidate();
        }
        this.implicitEndRow = false;
        if (this.rowDefaults != null) {
            cellPool.free(this.rowDefaults);
        }
        this.rowDefaults = this.obtainCell();
        this.rowDefaults.clear();
        return this.rowDefaults;
    }

    private void endRow() {
        T[] TArray = this.cells.items;
        int n2 = 0;
        for (int i2 = this.cells.size - 1; i2 >= 0; --i2) {
            Cell cell = (Cell)TArray[i2];
            if (cell.endRow) break;
            n2 += cell.colspan.intValue();
        }
        this.columns = Math.max(this.columns, n2);
        ++this.rows;
        this.cells.peek().endRow = true;
    }

    public Cell columnDefaults(int n2) {
        Cell cell;
        Cell cell2 = cell = this.columnDefaults.size > n2 ? this.columnDefaults.get(n2) : null;
        if (cell == null) {
            cell = this.obtainCell();
            cell.clear();
            if (n2 >= this.columnDefaults.size) {
                for (int i2 = this.columnDefaults.size; i2 < n2; ++i2) {
                    this.columnDefaults.add(null);
                }
                this.columnDefaults.add(cell);
            } else {
                this.columnDefaults.set(n2, cell);
            }
        }
        return cell;
    }

    @Null
    public <T extends Actor> Cell<T> getCell(T t2) {
        if (t2 == null) {
            throw new IllegalArgumentException("actor cannot be null.");
        }
        T[] TArray = this.cells.items;
        int n2 = this.cells.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            Cell cell = (Cell)TArray[i2];
            if (cell.actor != t2) continue;
            return cell;
        }
        return null;
    }

    public Array<Cell> getCells() {
        return this.cells;
    }

    @Override
    public float getPrefWidth() {
        if (this.sizeInvalid) {
            this.computeSize();
        }
        float f2 = this.tablePrefWidth;
        if (this.background != null) {
            return Math.max(f2, this.background.getMinWidth());
        }
        return f2;
    }

    @Override
    public float getPrefHeight() {
        if (this.sizeInvalid) {
            this.computeSize();
        }
        float f2 = this.tablePrefHeight;
        if (this.background != null) {
            return Math.max(f2, this.background.getMinHeight());
        }
        return f2;
    }

    @Override
    public float getMinWidth() {
        if (this.sizeInvalid) {
            this.computeSize();
        }
        return this.tableMinWidth;
    }

    @Override
    public float getMinHeight() {
        if (this.sizeInvalid) {
            this.computeSize();
        }
        return this.tableMinHeight;
    }

    public Cell defaults() {
        return this.cellDefaults;
    }

    public Table pad(Value value) {
        if (value == null) {
            throw new IllegalArgumentException("pad cannot be null.");
        }
        this.padTop = value;
        this.padLeft = value;
        this.padBottom = value;
        this.padRight = value;
        this.sizeInvalid = true;
        return this;
    }

    public Table pad(Value value, Value value2, Value value3, Value value4) {
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
        this.sizeInvalid = true;
        return this;
    }

    public Table padTop(Value value) {
        if (value == null) {
            throw new IllegalArgumentException("padTop cannot be null.");
        }
        this.padTop = value;
        this.sizeInvalid = true;
        return this;
    }

    public Table padLeft(Value value) {
        if (value == null) {
            throw new IllegalArgumentException("padLeft cannot be null.");
        }
        this.padLeft = value;
        this.sizeInvalid = true;
        return this;
    }

    public Table padBottom(Value value) {
        if (value == null) {
            throw new IllegalArgumentException("padBottom cannot be null.");
        }
        this.padBottom = value;
        this.sizeInvalid = true;
        return this;
    }

    public Table padRight(Value value) {
        if (value == null) {
            throw new IllegalArgumentException("padRight cannot be null.");
        }
        this.padRight = value;
        this.sizeInvalid = true;
        return this;
    }

    public Table pad(float f2) {
        this.pad(Value.Fixed.valueOf(f2));
        return this;
    }

    public Table pad(float f2, float f3, float f4, float f5) {
        this.padTop = Value.Fixed.valueOf(f2);
        this.padLeft = Value.Fixed.valueOf(f3);
        this.padBottom = Value.Fixed.valueOf(f4);
        this.padRight = Value.Fixed.valueOf(f5);
        this.sizeInvalid = true;
        return this;
    }

    public Table padTop(float f2) {
        this.padTop = Value.Fixed.valueOf(f2);
        this.sizeInvalid = true;
        return this;
    }

    public Table padLeft(float f2) {
        this.padLeft = Value.Fixed.valueOf(f2);
        this.sizeInvalid = true;
        return this;
    }

    public Table padBottom(float f2) {
        this.padBottom = Value.Fixed.valueOf(f2);
        this.sizeInvalid = true;
        return this;
    }

    public Table padRight(float f2) {
        this.padRight = Value.Fixed.valueOf(f2);
        this.sizeInvalid = true;
        return this;
    }

    public Table align(int n2) {
        this.align = n2;
        return this;
    }

    public Table center() {
        this.align = 1;
        return this;
    }

    public Table top() {
        this.align |= 2;
        this.align &= 0xFFFFFFFB;
        return this;
    }

    public Table left() {
        this.align |= 8;
        this.align &= 0xFFFFFFEF;
        return this;
    }

    public Table bottom() {
        this.align |= 4;
        this.align &= 0xFFFFFFFD;
        return this;
    }

    public Table right() {
        this.align |= 0x10;
        this.align &= 0xFFFFFFF7;
        return this;
    }

    @Override
    public void setDebug(boolean bl2) {
        this.debug(bl2 ? Debug.all : Debug.none);
    }

    @Override
    public Table debug() {
        super.debug();
        return this;
    }

    @Override
    public Table debugAll() {
        super.debugAll();
        return this;
    }

    public Table debugTable() {
        super.setDebug(true);
        if (this.debug != Debug.table) {
            this.debug = Debug.table;
            this.invalidate();
        }
        return this;
    }

    public Table debugCell() {
        super.setDebug(true);
        if (this.debug != Debug.cell) {
            this.debug = Debug.cell;
            this.invalidate();
        }
        return this;
    }

    public Table debugActor() {
        super.setDebug(true);
        if (this.debug != Debug.actor) {
            this.debug = Debug.actor;
            this.invalidate();
        }
        return this;
    }

    public Table debug(Debug debug) {
        super.setDebug(debug != Debug.none);
        if (this.debug != debug) {
            this.debug = debug;
            if (debug == Debug.none) {
                this.clearDebugRects();
            } else {
                this.invalidate();
            }
        }
        return this;
    }

    public Debug getTableDebug() {
        return this.debug;
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

    public int getAlign() {
        return this.align;
    }

    public int getRow(float f2) {
        int n2 = this.cells.size;
        if (n2 == 0) {
            return -1;
        }
        f2 += this.getPadTop();
        T[] TArray = this.cells.items;
        int n3 = 0;
        int n4 = 0;
        while (n3 < n2) {
            Cell cell = (Cell)TArray[n3++];
            if (cell.actorY + cell.computedPadTop < f2) {
                return n4;
            }
            if (!cell.endRow) continue;
            ++n4;
        }
        return -1;
    }

    public void setSkin(@Null Skin skin) {
        this.skin = skin;
    }

    public void setRound(boolean bl2) {
        this.round = bl2;
    }

    public int getRows() {
        return this.rows;
    }

    public int getColumns() {
        return this.columns;
    }

    public float getRowHeight(int n2) {
        if (this.rowHeight == null) {
            return 0.0f;
        }
        return this.rowHeight[n2];
    }

    public float getRowMinHeight(int n2) {
        if (this.sizeInvalid) {
            this.computeSize();
        }
        return this.rowMinHeight[n2];
    }

    public float getRowPrefHeight(int n2) {
        if (this.sizeInvalid) {
            this.computeSize();
        }
        return this.rowPrefHeight[n2];
    }

    public float getColumnWidth(int n2) {
        if (this.columnWidth == null) {
            return 0.0f;
        }
        return this.columnWidth[n2];
    }

    public float getColumnMinWidth(int n2) {
        if (this.sizeInvalid) {
            this.computeSize();
        }
        return this.columnMinWidth[n2];
    }

    public float getColumnPrefWidth(int n2) {
        if (this.sizeInvalid) {
            this.computeSize();
        }
        return this.columnPrefWidth[n2];
    }

    private float[] ensureSize(float[] fArray, int n2) {
        if (fArray == null || fArray.length < n2) {
            return new float[n2];
        }
        Arrays.fill(fArray, 0, n2, 0.0f);
        return fArray;
    }

    private void computeSize() {
        int n2;
        float f2;
        float f3;
        float f4;
        float f5;
        Object object;
        int n3;
        this.sizeInvalid = false;
        T[] TArray = this.cells.items;
        int n4 = this.cells.size;
        if (n4 > 0 && !((Cell)TArray[n4 - 1]).endRow) {
            this.endRow();
            this.implicitEndRow = true;
        }
        int n5 = this.columns;
        int n6 = this.rows;
        this.columnMinWidth = this.ensureSize(this.columnMinWidth, n5);
        float[] fArray = this.columnMinWidth;
        this.rowMinHeight = this.ensureSize(this.rowMinHeight, n6);
        float[] fArray2 = this.rowMinHeight;
        this.columnPrefWidth = this.ensureSize(this.columnPrefWidth, n5);
        float[] fArray3 = this.columnPrefWidth;
        this.rowPrefHeight = this.ensureSize(this.rowPrefHeight, n6);
        float[] fArray4 = this.rowPrefHeight;
        this.columnWidth = this.ensureSize(this.columnWidth, n5);
        float[] fArray5 = this.columnWidth;
        this.rowHeight = this.ensureSize(this.rowHeight, n6);
        float[] fArray6 = this.rowHeight;
        this.expandWidth = this.ensureSize(this.expandWidth, n5);
        float[] fArray7 = this.expandWidth;
        this.expandHeight = this.ensureSize(this.expandHeight, n6);
        float[] fArray8 = this.expandHeight;
        float f6 = 0.0f;
        for (int i2 = 0; i2 < n4; ++i2) {
            Cell cell = (Cell)TArray[i2];
            int n7 = cell.column;
            int n8 = cell.row;
            n3 = cell.colspan;
            object = cell.actor;
            if (cell.expandY != 0 && fArray8[n8] == 0.0f) {
                fArray8[n8] = cell.expandY.intValue();
            }
            if (n3 == 1 && cell.expandX != 0 && fArray7[n7] == 0.0f) {
                fArray7[n7] = cell.expandX.intValue();
            }
            cell.computedPadLeft = cell.padLeft.get((Actor)object) + (n7 == 0 ? 0.0f : Math.max(0.0f, cell.spaceLeft.get((Actor)object) - f6));
            cell.computedPadTop = cell.padTop.get((Actor)object);
            if (cell.cellAboveIndex != -1) {
                Cell cell2 = (Cell)TArray[cell.cellAboveIndex];
                cell.computedPadTop += Math.max(0.0f, cell.spaceTop.get((Actor)object) - cell2.spaceBottom.get((Actor)object));
            }
            float f7 = cell.spaceRight.get((Actor)object);
            cell.computedPadRight = cell.padRight.get((Actor)object) + (n7 + n3 == n5 ? 0.0f : f7);
            cell.computedPadBottom = cell.padBottom.get((Actor)object) + (n8 == n6 - 1 ? 0.0f : cell.spaceBottom.get((Actor)object));
            f6 = f7;
            float f8 = cell.prefWidth.get((Actor)object);
            float f9 = cell.prefHeight.get((Actor)object);
            float f10 = cell.minWidth.get((Actor)object);
            f5 = cell.minHeight.get((Actor)object);
            f4 = cell.maxWidth.get((Actor)object);
            f3 = cell.maxHeight.get((Actor)object);
            if (f8 < f10) {
                f8 = f10;
            }
            if (f9 < f5) {
                f9 = f5;
            }
            if (f4 > 0.0f && f8 > f4) {
                f8 = f4;
            }
            if (f3 > 0.0f && f9 > f3) {
                f9 = f3;
            }
            if (this.round) {
                f10 = (float)Math.ceil(f10);
                f5 = (float)Math.ceil(f5);
                f8 = (float)Math.ceil(f8);
                f9 = (float)Math.ceil(f9);
            }
            if (n3 == 1) {
                f2 = cell.computedPadLeft + cell.computedPadRight;
                fArray3[n7] = Math.max(fArray3[n7], f8 + f2);
                fArray[n7] = Math.max(fArray[n7], f10 + f2);
            }
            f2 = cell.computedPadTop + cell.computedPadBottom;
            fArray4[n8] = Math.max(fArray4[n8], f9 + f2);
            fArray2[n8] = Math.max(fArray2[n8], f5 + f2);
        }
        float f11 = 0.0f;
        float f12 = 0.0f;
        float f13 = 0.0f;
        float f14 = 0.0f;
        for (n3 = 0; n3 < n4; ++n3) {
            int n9;
            block28: {
                object = (Cell)TArray[n3];
                n9 = ((Cell)object).column;
                int n10 = ((Cell)object).expandX;
                if (n10 != 0) {
                    int n11;
                    int n12 = n9 + ((Cell)object).colspan;
                    for (n11 = n9; n11 < n12; ++n11) {
                        if (fArray7[n11] == 0.0f) {
                            continue;
                        }
                        break block28;
                    }
                    for (n11 = n9; n11 < n12; ++n11) {
                        fArray7[n11] = n10;
                    }
                }
            }
            if (((Cell)object).uniformX == Boolean.TRUE && ((Cell)object).colspan == 1) {
                float f15 = ((Cell)object).computedPadLeft + ((Cell)object).computedPadRight;
                f11 = Math.max(f11, fArray[n9] - f15);
                f13 = Math.max(f13, fArray3[n9] - f15);
            }
            if (((Cell)object).uniformY != Boolean.TRUE) continue;
            float f16 = ((Cell)object).computedPadTop + ((Cell)object).computedPadBottom;
            f12 = Math.max(f12, fArray2[((Cell)object).row] - f16);
            f14 = Math.max(f14, fArray4[((Cell)object).row] - f16);
        }
        if (f13 > 0.0f || f14 > 0.0f) {
            for (n3 = 0; n3 < n4; ++n3) {
                float f17;
                object = (Cell)TArray[n3];
                if (f13 > 0.0f && ((Cell)object).uniformX == Boolean.TRUE && ((Cell)object).colspan == 1) {
                    f17 = ((Cell)object).computedPadLeft + ((Cell)object).computedPadRight;
                    fArray[((Cell)object).column] = f11 + f17;
                    fArray3[((Cell)object).column] = f13 + f17;
                }
                if (!(f14 > 0.0f) || ((Cell)object).uniformY != Boolean.TRUE) continue;
                f17 = ((Cell)object).computedPadTop + ((Cell)object).computedPadBottom;
                fArray2[((Cell)object).row] = f12 + f17;
                fArray4[((Cell)object).row] = f14 + f17;
            }
        }
        for (n3 = 0; n3 < n4; ++n3) {
            int n13;
            object = (Cell)TArray[n3];
            int n14 = ((Cell)object).colspan;
            if (n14 == 1) continue;
            int n15 = ((Cell)object).column;
            Actor actor = ((Cell)object).actor;
            float f18 = ((Cell)object).minWidth.get(actor);
            f5 = ((Cell)object).prefWidth.get(actor);
            f4 = ((Cell)object).maxWidth.get(actor);
            if (f5 < f18) {
                f5 = f18;
            }
            if (f4 > 0.0f && f5 > f4) {
                f5 = f4;
            }
            if (this.round) {
                f18 = (float)Math.ceil(f18);
                f5 = (float)Math.ceil(f5);
            }
            f2 = f3 = -(((Cell)object).computedPadLeft + ((Cell)object).computedPadRight);
            float f19 = 0.0f;
            int n16 = n13 + n14;
            for (n13 = n15; n13 < n16; ++n13) {
                f3 += fArray[n13];
                f2 += fArray3[n13];
                f19 += fArray7[n13];
            }
            float f20 = Math.max(0.0f, f18 - f3);
            float f21 = Math.max(0.0f, f5 - f2);
            int n17 = n15;
            int n18 = n17 + n14;
            while (n17 < n18) {
                float f22 = f19 == 0.0f ? 1.0f / (float)n14 : fArray7[n17] / f19;
                int n19 = n17;
                fArray[n19] = fArray[n19] + f20 * f22;
                int n20 = n17++;
                fArray3[n20] = fArray3[n20] + f21 * f22;
            }
        }
        float f23 = this.padLeft.get(this) + this.padRight.get(this);
        float f24 = this.padTop.get(this) + this.padBottom.get(this);
        this.tableMinWidth = f23;
        this.tablePrefWidth = f23;
        for (n2 = 0; n2 < n5; ++n2) {
            this.tableMinWidth += fArray[n2];
            this.tablePrefWidth += fArray3[n2];
        }
        this.tableMinHeight = f24;
        this.tablePrefHeight = f24;
        for (n2 = 0; n2 < n6; ++n2) {
            this.tableMinHeight += fArray2[n2];
            this.tablePrefHeight += Math.max(fArray2[n2], fArray4[n2]);
        }
        this.tablePrefWidth = Math.max(this.tableMinWidth, this.tablePrefWidth);
        this.tablePrefHeight = Math.max(this.tableMinHeight, this.tablePrefHeight);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void layout() {
        int n2;
        float n23;
        float f2;
        float f3;
        float n17;
        int f30;
        void fArray8;
        float[] fArray;
        int n4;
        Object[] objectArray;
        float[] fArray2;
        if (this.sizeInvalid) {
            this.computeSize();
        }
        float f6 = this.getWidth();
        float f7 = this.getHeight();
        int n5 = this.columns;
        int n6 = this.rows;
        float[] fArray3 = this.columnWidth;
        float[] fArray4 = this.rowHeight;
        float f8 = this.padLeft.get(this);
        float f9 = f8 + this.padRight.get(this);
        float f10 = this.padTop.get(this);
        float f11 = f10 + this.padBottom.get(this);
        float f12 = this.tablePrefWidth - this.tableMinWidth;
        if (f12 == 0.0f) {
            fArray2 = this.columnMinWidth;
        } else {
            float f13 = Math.min(f12, Math.max(0.0f, f6 - this.tableMinWidth));
            columnWeightedWidth = this.ensureSize(columnWeightedWidth, n5);
            fArray2 = columnWeightedWidth;
            float[] fArray5 = this.columnMinWidth;
            objectArray = this.columnPrefWidth;
            for (n4 = 0; n4 < n5; ++n4) {
                reference var17_21 = objectArray[n4] - fArray5[n4];
                reference i2 = var17_21 / f12;
                fArray2[n4] = fArray5[n4] + f13 * i2;
            }
        }
        float f14 = this.tablePrefHeight - this.tableMinHeight;
        if (f14 == 0.0f) {
            fArray = this.rowMinHeight;
        } else {
            void fArray9;
            rowWeightedHeight = this.ensureSize(rowWeightedHeight, n6);
            fArray = rowWeightedHeight;
            float f15 = Math.min(f14, Math.max(0.0f, f7 - this.tableMinHeight));
            float[] fArray6 = this.rowMinHeight;
            float[] fArray7 = this.rowPrefHeight;
            boolean cell = false;
            while (fArray9 < n6) {
                float f22 = fArray7[fArray9] - fArray6[fArray9];
                float i4 = f22 / f14;
                fArray[fArray9] = fArray6[fArray9] + f15 * i4;
                ++fArray9;
            }
        }
        objectArray = this.cells.items;
        n4 = this.cells.size;
        boolean i3 = false;
        while (fArray8 < n4) {
            int f31;
            Cell cell = (Cell)objectArray[fArray8];
            int n3 = cell.column;
            int f23 = cell.row;
            Actor f24 = cell.actor;
            float f4 = 0.0f;
            f30 = cell.colspan;
            int f32 = f31 + f30;
            for (f31 = n3; f31 < f32; ++f31) {
                f4 += fArray2[f31];
            }
            n17 = fArray[f23];
            float n19 = cell.prefWidth.get(f24);
            f3 = cell.prefHeight.get(f24);
            float snapshotArray = cell.minWidth.get(f24);
            float actorArray = cell.minHeight.get(f24);
            f2 = cell.maxWidth.get(f24);
            n23 = cell.maxHeight.get(f24);
            if (n19 < snapshotArray) {
                n19 = snapshotArray;
            }
            if (f3 < actorArray) {
                f3 = actorArray;
            }
            if (f2 > 0.0f && n19 > f2) {
                n19 = f2;
            }
            if (n23 > 0.0f && f3 > n23) {
                f3 = n23;
            }
            cell.actorWidth = Math.min(f4 - cell.computedPadLeft - cell.computedPadRight, n19);
            cell.actorHeight = Math.min(n17 - cell.computedPadTop - cell.computedPadBottom, f3);
            if (f30 == 1) {
                fArray3[n3] = Math.max(fArray3[n3], f4);
            }
            fArray4[f23] = Math.max(fArray4[f23], n17);
            ++fArray8;
        }
        float[] fArray5 = this.expandWidth;
        float[] fArray6 = this.expandHeight;
        float f5 = 0.0f;
        for (int i6 = 0; i6 < n5; ++i6) {
            f5 += fArray5[i6];
        }
        if (f5 > 0.0f) {
            float f25 = f6 - f9;
            for (int i7 = 0; i7 < n5; ++i7) {
                f25 -= fArray3[i7];
            }
            if (f25 > 0.0f) {
                float f26 = 0.0f;
                int n14 = 0;
                for (f30 = 0; f30 < n5; ++f30) {
                    if (fArray5[f30] == 0.0f) continue;
                    n17 = f25 * fArray5[f30] / f5;
                    int n7 = f30;
                    fArray3[n7] = fArray3[n7] + n17;
                    f26 += n17;
                    n14 = f30;
                }
                int n8 = n14;
                fArray3[n8] = fArray3[n8] + (f25 - f26);
            }
        }
        f5 = 0.0f;
        for (int i8 = 0; i8 < n6; ++i8) {
            f5 += fArray6[i8];
        }
        if (f5 > 0.0f) {
            float f28 = f7 - f11;
            for (int cell = 0; cell < n6; ++cell) {
                f28 -= fArray4[cell];
            }
            if (f28 > 0.0f) {
                float f29 = 0.0f;
                int n22 = 0;
                for (f30 = 0; f30 < n6; ++f30) {
                    if (fArray6[f30] == 0.0f) continue;
                    n17 = f28 * fArray6[f30] / f5;
                    int n9 = f30;
                    fArray4[n9] = fArray4[n9] + n17;
                    f29 += n17;
                    n22 = f30;
                }
                int n10 = n22;
                fArray4[n10] = fArray4[n10] + (f28 - f29);
            }
        }
        for (int i2 = 0; i2 < n4; ++i2) {
            int n11;
            Cell cell = (Cell)objectArray[i2];
            int n12 = cell.colspan;
            if (n12 == 1) continue;
            float f13 = 0.0f;
            int n13 = n11 + n12;
            for (n11 = cell.column; n11 < n13; ++n11) {
                f13 += fArray2[n11] - fArray3[n11];
            }
            f13 -= Math.max(0.0f, cell.computedPadLeft + cell.computedPadRight);
            if (!((f13 /= (float)n12) > 0.0f)) continue;
            n11 = cell.column;
            n13 = n11 + n12;
            while (n11 < n13) {
                int n14 = n11++;
                fArray3[n14] = fArray3[n14] + f13;
            }
        }
        float f15 = f9;
        float f16 = f11;
        for (n2 = 0; n2 < n5; ++n2) {
            f15 += fArray3[n2];
        }
        for (n2 = 0; n2 < n6; ++n2) {
            f16 += fArray4[n2];
        }
        n2 = this.align;
        float f17 = f8;
        if ((n2 & 0x10) != 0) {
            f17 += f6 - f15;
        } else if ((n2 & 8) == 0) {
            f17 += (f6 - f15) / 2.0f;
        }
        float f18 = f10;
        if ((n2 & 4) != 0) {
            f18 += f7 - f16;
        } else if ((n2 & 2) == 0) {
            f18 += (f7 - f16) / 2.0f;
        }
        float f19 = f17;
        f3 = f18;
        for (int i4 = 0; i4 < n4; ++i4) {
            float f20;
            int n15;
            Cell cell = (Cell)objectArray[i4];
            f2 = 0.0f;
            int n16 = n15 + cell.colspan;
            for (n15 = cell.column; n15 < n16; ++n15) {
                f2 += fArray3[n15];
            }
            f2 -= cell.computedPadLeft + cell.computedPadRight;
            f19 += cell.computedPadLeft;
            n23 = cell.fillX.floatValue();
            float actor = cell.fillY.floatValue();
            if (n23 > 0.0f) {
                cell.actorWidth = Math.max(f2 * n23, cell.minWidth.get(cell.actor));
                f20 = cell.maxWidth.get(cell.actor);
                if (f20 > 0.0f) {
                    cell.actorWidth = Math.min(cell.actorWidth, f20);
                }
            }
            if (actor > 0.0f) {
                cell.actorHeight = Math.max(fArray4[cell.row] * actor - cell.computedPadTop - cell.computedPadBottom, cell.minHeight.get(cell.actor));
                f20 = cell.maxHeight.get(cell.actor);
                if (f20 > 0.0f) {
                    cell.actorHeight = Math.min(cell.actorHeight, f20);
                }
            }
            cell.actorX = ((n2 = cell.align.intValue()) & 8) != 0 ? f19 : ((n2 & 0x10) != 0 ? f19 + f2 - cell.actorWidth : f19 + (f2 - cell.actorWidth) / 2.0f);
            cell.actorY = (n2 & 2) != 0 ? cell.computedPadTop : ((n2 & 4) != 0 ? fArray4[cell.row] - cell.actorHeight - cell.computedPadBottom : (fArray4[cell.row] - cell.actorHeight + cell.computedPadTop - cell.computedPadBottom) / 2.0f);
            cell.actorY = f7 - f3 - cell.actorY - cell.actorHeight;
            if (this.round) {
                cell.actorWidth = (float)Math.ceil(cell.actorWidth);
                cell.actorHeight = (float)Math.ceil(cell.actorHeight);
                cell.actorX = (float)Math.floor(cell.actorX);
                cell.actorY = (float)Math.floor(cell.actorY);
            }
            if (cell.actor != null) {
                cell.actor.setBounds(cell.actorX, cell.actorY, cell.actorWidth, cell.actorHeight);
            }
            if (cell.endRow) {
                f19 = f17;
                f3 += fArray4[cell.row];
                continue;
            }
            f19 += f2 + cell.computedPadRight;
        }
        SnapshotArray<Actor> snapshotArray = this.getChildren();
        Actor[] actorArray = (Actor[])snapshotArray.items;
        int n18 = snapshotArray.size;
        for (int i5 = 0; i5 < n18; ++i5) {
            Actor actor = actorArray[i5];
            if (!(actor instanceof Layout)) continue;
            ((Layout)((Object)actor)).validate();
        }
        if (this.debug != Debug.none) {
            this.addDebugRects(f17, f18, f15 - f9, f16 - f11);
        }
    }

    private void addDebugRects(float f2, float f3, float f4, float f5) {
        this.clearDebugRects();
        if (this.debug == Debug.table || this.debug == Debug.all) {
            this.addDebugRect(0.0f, 0.0f, this.getWidth(), this.getHeight(), debugTableColor);
            this.addDebugRect(f2, this.getHeight() - f3, f4, -f5, debugTableColor);
        }
        float f6 = f2;
        int n2 = this.cells.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            int n3;
            Cell cell = this.cells.get(i2);
            if (this.debug == Debug.actor || this.debug == Debug.all) {
                this.addDebugRect(cell.actorX, cell.actorY, cell.actorWidth, cell.actorHeight, debugActorColor);
            }
            float f7 = 0.0f;
            int n4 = n3 + cell.colspan;
            for (n3 = cell.column; n3 < n4; ++n3) {
                f7 += this.columnWidth[n3];
            }
            f7 -= cell.computedPadLeft + cell.computedPadRight;
            f2 += cell.computedPadLeft;
            if (this.debug == Debug.cell || this.debug == Debug.all) {
                float f8 = this.rowHeight[cell.row] - cell.computedPadTop - cell.computedPadBottom;
                float f9 = f3 + cell.computedPadTop;
                this.addDebugRect(f2, this.getHeight() - f9, f7, -f8, debugCellColor);
            }
            if (cell.endRow) {
                f2 = f6;
                f3 += this.rowHeight[cell.row];
                continue;
            }
            f2 += f7 + cell.computedPadRight;
        }
    }

    private void clearDebugRects() {
        if (this.debugRects == null) {
            this.debugRects = new Array();
        }
        DebugRect.pool.freeAll(this.debugRects);
        this.debugRects.clear();
    }

    private void addDebugRect(float f2, float f3, float f4, float f5, Color color) {
        DebugRect debugRect = DebugRect.pool.obtain();
        debugRect.color = color;
        debugRect.set(f2, f3, f4, f5);
        this.debugRects.add(debugRect);
    }

    @Override
    public void drawDebug(ShapeRenderer shapeRenderer) {
        if (this.isTransform()) {
            this.applyTransform(shapeRenderer, this.computeTransform());
            this.drawDebugRects(shapeRenderer);
            if (this.clip) {
                shapeRenderer.flush();
                float f2 = 0.0f;
                float f3 = 0.0f;
                float f4 = this.getWidth();
                float f5 = this.getHeight();
                if (this.background != null) {
                    f2 = this.padLeft.get(this);
                    f3 = this.padBottom.get(this);
                    f4 -= f2 + this.padRight.get(this);
                    f5 -= f3 + this.padTop.get(this);
                }
                if (this.clipBegin(f2, f3, f4, f5)) {
                    this.drawDebugChildren(shapeRenderer);
                    this.clipEnd();
                }
            } else {
                this.drawDebugChildren(shapeRenderer);
            }
            this.resetTransform(shapeRenderer);
        } else {
            this.drawDebugRects(shapeRenderer);
            super.drawDebug(shapeRenderer);
        }
    }

    @Override
    public void drawDebugBounds(ShapeRenderer shapeRenderer) {
    }

    private void drawDebugRects(ShapeRenderer shapeRenderer) {
        if (this.debugRects == null || !this.getDebug()) {
            return;
        }
        shapeRenderer.set(ShapeRenderer.ShapeType.Line);
        if (this.getStage() != null) {
            shapeRenderer.setColor(this.getStage().getDebugColor());
        }
        float f2 = 0.0f;
        float f3 = 0.0f;
        if (!this.isTransform()) {
            f2 = this.getX();
            f3 = this.getY();
        }
        int n2 = this.debugRects.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            DebugRect debugRect = this.debugRects.get(i2);
            shapeRenderer.setColor(debugRect.color);
            shapeRenderer.rect(f2 + debugRect.x, f3 + debugRect.y, debugRect.width, debugRect.height);
        }
    }

    @Null
    public Skin getSkin() {
        return this.skin;
    }

    static {
        backgroundTop = new Value(){

            @Override
            public float get(@Null Actor actor) {
                Drawable drawable = ((Table)actor).background;
                return drawable == null ? 0.0f : drawable.getTopHeight();
            }
        };
        backgroundLeft = new Value(){

            @Override
            public float get(@Null Actor actor) {
                Drawable drawable = ((Table)actor).background;
                return drawable == null ? 0.0f : drawable.getLeftWidth();
            }
        };
        backgroundBottom = new Value(){

            @Override
            public float get(@Null Actor actor) {
                Drawable drawable = ((Table)actor).background;
                return drawable == null ? 0.0f : drawable.getBottomHeight();
            }
        };
        backgroundRight = new Value(){

            @Override
            public float get(@Null Actor actor) {
                Drawable drawable = ((Table)actor).background;
                return drawable == null ? 0.0f : drawable.getRightWidth();
            }
        };
    }

    public static enum Debug {
        none,
        all,
        table,
        cell,
        actor;

    }

    public static class DebugRect
    extends Rectangle {
        static Pool<DebugRect> pool = Pools.get(DebugRect.class);
        Color color;
    }
}

