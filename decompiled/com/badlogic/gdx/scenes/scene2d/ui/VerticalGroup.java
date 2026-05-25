/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.WidgetGroup;
import com.badlogic.gdx.scenes.scene2d.utils.Layout;
import com.badlogic.gdx.utils.FloatArray;
import com.badlogic.gdx.utils.SnapshotArray;

public class VerticalGroup
extends WidgetGroup {
    private float prefWidth;
    private float prefHeight;
    private float lastPrefWidth;
    private boolean sizeInvalid = true;
    private FloatArray columnSizes;
    private int align = 2;
    private int columnAlign;
    private boolean reverse;
    private boolean round = true;
    private boolean wrap;
    private boolean expand;
    private float space;
    private float wrapSpace;
    private float fill;
    private float padTop;
    private float padLeft;
    private float padBottom;
    private float padRight;

    public VerticalGroup() {
        this.setTouchable(Touchable.childrenOnly);
    }

    @Override
    public void invalidate() {
        super.invalidate();
        this.sizeInvalid = true;
    }

    private void computeSize() {
        this.sizeInvalid = false;
        SnapshotArray<Actor> snapshotArray = this.getChildren();
        int n2 = snapshotArray.size;
        this.prefWidth = 0.0f;
        if (this.wrap) {
            this.prefHeight = 0.0f;
            if (this.columnSizes == null) {
                this.columnSizes = new FloatArray();
            } else {
                this.columnSizes.clear();
            }
            FloatArray floatArray = this.columnSizes;
            float f2 = this.space;
            float f3 = this.wrapSpace;
            float f4 = this.padTop + this.padBottom;
            float f5 = this.getHeight() - f4;
            float f6 = 0.0f;
            float f7 = 0.0f;
            float f8 = 0.0f;
            int n3 = 0;
            int n4 = 1;
            if (this.reverse) {
                n3 = n2 - 1;
                n2 = -1;
                n4 = -1;
            }
            while (n3 != n2) {
                float f9;
                float f10;
                Actor actor = (Actor)snapshotArray.get(n3);
                if (actor instanceof Layout) {
                    Layout layout = (Layout)((Object)actor);
                    f10 = layout.getPrefWidth();
                    f9 = layout.getPrefHeight();
                    if (f9 > f5) {
                        f9 = Math.max(f5, layout.getMinHeight());
                    }
                } else {
                    f10 = actor.getWidth();
                    f9 = actor.getHeight();
                }
                float f11 = f9 + (f7 > 0.0f ? f2 : 0.0f);
                if (f7 + f11 > f5 && f7 > 0.0f) {
                    floatArray.add(f7);
                    floatArray.add(f8);
                    this.prefHeight = Math.max(this.prefHeight, f7 + f4);
                    if (f6 > 0.0f) {
                        f6 += f3;
                    }
                    f6 += f8;
                    f8 = 0.0f;
                    f7 = 0.0f;
                    f11 = f9;
                }
                f7 += f11;
                f8 = Math.max(f8, f10);
                n3 += n4;
            }
            floatArray.add(f7);
            floatArray.add(f8);
            this.prefHeight = Math.max(this.prefHeight, f7 + f4);
            if (f6 > 0.0f) {
                f6 += f3;
            }
            this.prefWidth = Math.max(this.prefWidth, f6 + f8);
        } else {
            this.prefHeight = this.padTop + this.padBottom + this.space * (float)(n2 - 1);
            for (int i2 = 0; i2 < n2; ++i2) {
                Actor actor = (Actor)snapshotArray.get(i2);
                if (actor instanceof Layout) {
                    Layout layout = (Layout)((Object)actor);
                    this.prefWidth = Math.max(this.prefWidth, layout.getPrefWidth());
                    this.prefHeight += layout.getPrefHeight();
                    continue;
                }
                this.prefWidth = Math.max(this.prefWidth, actor.getWidth());
                this.prefHeight += actor.getHeight();
            }
        }
        this.prefWidth += this.padLeft + this.padRight;
        if (this.round) {
            this.prefWidth = Math.round(this.prefWidth);
            this.prefHeight = Math.round(this.prefHeight);
        }
    }

    @Override
    public void layout() {
        if (this.sizeInvalid) {
            this.computeSize();
        }
        if (this.wrap) {
            this.layoutWrapped();
            return;
        }
        boolean bl2 = this.round;
        int n2 = this.align;
        float f2 = this.space;
        float f3 = this.padLeft;
        float f4 = this.fill;
        float f5 = (this.expand ? this.getWidth() : this.prefWidth) - f3 - this.padRight;
        float f6 = this.prefHeight - this.padTop + f2;
        if ((n2 & 2) != 0) {
            f6 += this.getHeight() - this.prefHeight;
        } else if ((n2 & 4) == 0) {
            f6 += (this.getHeight() - this.prefHeight) / 2.0f;
        }
        float f7 = (n2 & 8) != 0 ? f3 : ((n2 & 0x10) != 0 ? this.getWidth() - this.padRight - f5 : f3 + (this.getWidth() - f3 - this.padRight - f5) / 2.0f);
        n2 = this.columnAlign;
        SnapshotArray<Actor> snapshotArray = this.getChildren();
        int n3 = 0;
        int n4 = snapshotArray.size;
        int n5 = 1;
        if (this.reverse) {
            n3 = n4 - 1;
            n4 = -1;
            n5 = -1;
        }
        boolean bl3 = false;
        while (n3 != n4) {
            float f8;
            float f9;
            float f10;
            Actor actor = (Actor)snapshotArray.get(n3);
            Layout layout = null;
            if (actor instanceof Layout) {
                layout = (Layout)((Object)actor);
                f10 = layout.getPrefWidth();
                f9 = layout.getPrefHeight();
            } else {
                f10 = actor.getWidth();
                f9 = actor.getHeight();
            }
            if (f4 > 0.0f) {
                f10 = f5 * f4;
            }
            if (layout != null) {
                f10 = Math.max(f10, layout.getMinWidth());
                f8 = layout.getMaxWidth();
                if (f8 > 0.0f && f10 > f8) {
                    f10 = f8;
                }
            }
            f8 = f7;
            if ((n2 & 0x10) != 0) {
                f8 += f5 - f10;
            } else if ((n2 & 8) == 0) {
                f8 += (f5 - f10) / 2.0f;
            }
            f6 -= f9 + f2;
            if (bl2) {
                actor.setBounds(Math.round(f8), Math.round(f6), Math.round(f10), Math.round(f9));
            } else {
                actor.setBounds(f8, f6, f10, f9);
            }
            if (layout != null) {
                layout.validate();
            }
            n3 += n5;
        }
    }

    private void layoutWrapped() {
        float f2 = this.getPrefWidth();
        if (f2 != this.lastPrefWidth) {
            this.lastPrefWidth = f2;
            this.invalidateHierarchy();
        }
        int n2 = this.align;
        boolean bl2 = this.round;
        float f3 = this.space;
        float f4 = this.padLeft;
        float f5 = this.fill;
        float f6 = this.wrapSpace;
        float f7 = this.prefHeight - this.padTop - this.padBottom;
        float f8 = f4;
        float f9 = this.getHeight();
        float f10 = this.prefHeight - this.padTop + f3;
        float f11 = 0.0f;
        float f12 = 0.0f;
        if ((n2 & 0x10) != 0) {
            f8 += this.getWidth() - f2;
        } else if ((n2 & 8) == 0) {
            f8 += (this.getWidth() - f2) / 2.0f;
        }
        if ((n2 & 2) != 0) {
            f10 += f9 - this.prefHeight;
        } else if ((n2 & 4) == 0) {
            f10 += (f9 - this.prefHeight) / 2.0f;
        }
        f9 -= this.padTop;
        n2 = this.columnAlign;
        FloatArray floatArray = this.columnSizes;
        SnapshotArray<Actor> snapshotArray = this.getChildren();
        int n3 = 0;
        int n4 = snapshotArray.size;
        int n5 = 1;
        if (this.reverse) {
            n3 = n4 - 1;
            n4 = -1;
            n5 = -1;
        }
        int n6 = 0;
        while (n3 != n4) {
            float f13;
            float f14;
            float f15;
            Actor actor = (Actor)snapshotArray.get(n3);
            Layout layout = null;
            if (actor instanceof Layout) {
                layout = (Layout)((Object)actor);
                f15 = layout.getPrefWidth();
                f14 = layout.getPrefHeight();
                if (f14 > f9) {
                    f14 = Math.max(f9, layout.getMinHeight());
                }
            } else {
                f15 = actor.getWidth();
                f14 = actor.getHeight();
            }
            if (f11 - f14 - f3 < this.padBottom || n6 == 0) {
                n6 = Math.min(n6, floatArray.size - 2);
                f11 = f10;
                if ((n2 & 4) != 0) {
                    f11 -= f7 - floatArray.get(n6);
                } else if ((n2 & 2) == 0) {
                    f11 -= (f7 - floatArray.get(n6)) / 2.0f;
                }
                if (n6 > 0) {
                    f8 += f6;
                    f8 += f12;
                }
                f12 = floatArray.get(n6 + 1);
                n6 += 2;
            }
            if (f5 > 0.0f) {
                f15 = f12 * f5;
            }
            if (layout != null) {
                f15 = Math.max(f15, layout.getMinWidth());
                f13 = layout.getMaxWidth();
                if (f13 > 0.0f && f15 > f13) {
                    f15 = f13;
                }
            }
            f13 = f8;
            if ((n2 & 0x10) != 0) {
                f13 += f12 - f15;
            } else if ((n2 & 8) == 0) {
                f13 += (f12 - f15) / 2.0f;
            }
            f11 -= f14 + f3;
            if (bl2) {
                actor.setBounds(Math.round(f13), Math.round(f11), Math.round(f15), Math.round(f14));
            } else {
                actor.setBounds(f13, f11, f15, f14);
            }
            if (layout != null) {
                layout.validate();
            }
            n3 += n5;
        }
    }

    @Override
    public float getPrefWidth() {
        if (this.sizeInvalid) {
            this.computeSize();
        }
        return this.prefWidth;
    }

    @Override
    public float getPrefHeight() {
        if (this.wrap) {
            return 0.0f;
        }
        if (this.sizeInvalid) {
            this.computeSize();
        }
        return this.prefHeight;
    }

    public int getColumns() {
        return this.wrap ? this.columnSizes.size >> 1 : 1;
    }

    public void setRound(boolean bl2) {
        this.round = bl2;
    }

    public VerticalGroup reverse() {
        this.reverse = true;
        return this;
    }

    public VerticalGroup reverse(boolean bl2) {
        this.reverse = bl2;
        return this;
    }

    public boolean getReverse() {
        return this.reverse;
    }

    public VerticalGroup space(float f2) {
        this.space = f2;
        return this;
    }

    public float getSpace() {
        return this.space;
    }

    public VerticalGroup wrapSpace(float f2) {
        this.wrapSpace = f2;
        return this;
    }

    public float getWrapSpace() {
        return this.wrapSpace;
    }

    public VerticalGroup pad(float f2) {
        this.padTop = f2;
        this.padLeft = f2;
        this.padBottom = f2;
        this.padRight = f2;
        return this;
    }

    public VerticalGroup pad(float f2, float f3, float f4, float f5) {
        this.padTop = f2;
        this.padLeft = f3;
        this.padBottom = f4;
        this.padRight = f5;
        return this;
    }

    public VerticalGroup padTop(float f2) {
        this.padTop = f2;
        return this;
    }

    public VerticalGroup padLeft(float f2) {
        this.padLeft = f2;
        return this;
    }

    public VerticalGroup padBottom(float f2) {
        this.padBottom = f2;
        return this;
    }

    public VerticalGroup padRight(float f2) {
        this.padRight = f2;
        return this;
    }

    public float getPadTop() {
        return this.padTop;
    }

    public float getPadLeft() {
        return this.padLeft;
    }

    public float getPadBottom() {
        return this.padBottom;
    }

    public float getPadRight() {
        return this.padRight;
    }

    public VerticalGroup align(int n2) {
        this.align = n2;
        return this;
    }

    public VerticalGroup center() {
        this.align = 1;
        return this;
    }

    public VerticalGroup top() {
        this.align |= 2;
        this.align &= 0xFFFFFFFB;
        return this;
    }

    public VerticalGroup left() {
        this.align |= 8;
        this.align &= 0xFFFFFFEF;
        return this;
    }

    public VerticalGroup bottom() {
        this.align |= 4;
        this.align &= 0xFFFFFFFD;
        return this;
    }

    public VerticalGroup right() {
        this.align |= 0x10;
        this.align &= 0xFFFFFFF7;
        return this;
    }

    public int getAlign() {
        return this.align;
    }

    public VerticalGroup fill() {
        this.fill = 1.0f;
        return this;
    }

    public VerticalGroup fill(float f2) {
        this.fill = f2;
        return this;
    }

    public float getFill() {
        return this.fill;
    }

    public VerticalGroup expand() {
        this.expand = true;
        return this;
    }

    public VerticalGroup expand(boolean bl2) {
        this.expand = bl2;
        return this;
    }

    public boolean getExpand() {
        return this.expand;
    }

    public VerticalGroup grow() {
        this.expand = true;
        this.fill = 1.0f;
        return this;
    }

    public VerticalGroup wrap() {
        this.wrap = true;
        return this;
    }

    public VerticalGroup wrap(boolean bl2) {
        this.wrap = bl2;
        return this;
    }

    public boolean getWrap() {
        return this.wrap;
    }

    public VerticalGroup columnAlign(int n2) {
        this.columnAlign = n2;
        return this;
    }

    public VerticalGroup columnCenter() {
        this.columnAlign = 1;
        return this;
    }

    public VerticalGroup columnTop() {
        this.columnAlign |= 2;
        this.columnAlign &= 0xFFFFFFFB;
        return this;
    }

    public VerticalGroup columnLeft() {
        this.columnAlign |= 8;
        this.columnAlign &= 0xFFFFFFEF;
        return this;
    }

    public VerticalGroup columnBottom() {
        this.columnAlign |= 4;
        this.columnAlign &= 0xFFFFFFFD;
        return this;
    }

    public VerticalGroup columnRight() {
        this.columnAlign |= 0x10;
        this.columnAlign &= 0xFFFFFFF7;
        return this;
    }

    @Override
    public void drawDebugBounds(ShapeRenderer shapeRenderer) {
        super.drawDebugBounds(shapeRenderer);
        if (!this.getDebug()) {
            return;
        }
        shapeRenderer.set(ShapeRenderer.ShapeType.Line);
        if (this.getStage() != null) {
            shapeRenderer.setColor(this.getStage().getDebugColor());
        }
        shapeRenderer.rect(this.getX() + this.padLeft, this.getY() + this.padBottom, this.getOriginX(), this.getOriginY(), this.getWidth() - this.padLeft - this.padRight, this.getHeight() - this.padBottom - this.padTop, this.getScaleX(), this.getScaleY(), this.getRotation());
    }
}

