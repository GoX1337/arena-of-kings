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

public class HorizontalGroup
extends WidgetGroup {
    private float prefWidth;
    private float prefHeight;
    private float lastPrefHeight;
    private boolean sizeInvalid = true;
    private FloatArray rowSizes;
    private int align = 8;
    private int rowAlign;
    private boolean reverse;
    private boolean round = true;
    private boolean wrap;
    private boolean wrapReverse;
    private boolean expand;
    private float space;
    private float wrapSpace;
    private float fill;
    private float padTop;
    private float padLeft;
    private float padBottom;
    private float padRight;

    public HorizontalGroup() {
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
        this.prefHeight = 0.0f;
        if (this.wrap) {
            this.prefWidth = 0.0f;
            if (this.rowSizes == null) {
                this.rowSizes = new FloatArray();
            } else {
                this.rowSizes.clear();
            }
            FloatArray floatArray = this.rowSizes;
            float f2 = this.space;
            float f3 = this.wrapSpace;
            float f4 = this.padLeft + this.padRight;
            float f5 = this.getWidth() - f4;
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
                    if (f10 > f5) {
                        f10 = Math.max(f5, layout.getMinWidth());
                    }
                    f9 = layout.getPrefHeight();
                } else {
                    f10 = actor.getWidth();
                    f9 = actor.getHeight();
                }
                float f11 = f10 + (f6 > 0.0f ? f2 : 0.0f);
                if (f6 + f11 > f5 && f6 > 0.0f) {
                    floatArray.add(f6);
                    floatArray.add(f8);
                    this.prefWidth = Math.max(this.prefWidth, f6 + f4);
                    if (f7 > 0.0f) {
                        f7 += f3;
                    }
                    f7 += f8;
                    f8 = 0.0f;
                    f6 = 0.0f;
                    f11 = f10;
                }
                f6 += f11;
                f8 = Math.max(f8, f9);
                n3 += n4;
            }
            floatArray.add(f6);
            floatArray.add(f8);
            this.prefWidth = Math.max(this.prefWidth, f6 + f4);
            if (f7 > 0.0f) {
                f7 += f3;
            }
            this.prefHeight = Math.max(this.prefHeight, f7 + f8);
        } else {
            this.prefWidth = this.padLeft + this.padRight + this.space * (float)(n2 - 1);
            for (int i2 = 0; i2 < n2; ++i2) {
                Actor actor = (Actor)snapshotArray.get(i2);
                if (actor instanceof Layout) {
                    Layout layout = (Layout)((Object)actor);
                    this.prefWidth += layout.getPrefWidth();
                    this.prefHeight = Math.max(this.prefHeight, layout.getPrefHeight());
                    continue;
                }
                this.prefWidth += actor.getWidth();
                this.prefHeight = Math.max(this.prefHeight, actor.getHeight());
            }
        }
        this.prefHeight += this.padTop + this.padBottom;
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
        float f3 = this.padBottom;
        float f4 = this.fill;
        float f5 = (this.expand ? this.getHeight() : this.prefHeight) - this.padTop - f3;
        float f6 = this.padLeft;
        if ((n2 & 0x10) != 0) {
            f6 += this.getWidth() - this.prefWidth;
        } else if ((n2 & 8) == 0) {
            f6 += (this.getWidth() - this.prefWidth) / 2.0f;
        }
        float f7 = (n2 & 4) != 0 ? f3 : ((n2 & 2) != 0 ? this.getHeight() - this.padTop - f5 : f3 + (this.getHeight() - f3 - this.padTop - f5) / 2.0f);
        n2 = this.rowAlign;
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
                f9 = f5 * f4;
            }
            if (layout != null) {
                f9 = Math.max(f9, layout.getMinHeight());
                f8 = layout.getMaxHeight();
                if (f8 > 0.0f && f9 > f8) {
                    f9 = f8;
                }
            }
            f8 = f7;
            if ((n2 & 2) != 0) {
                f8 += f5 - f9;
            } else if ((n2 & 4) == 0) {
                f8 += (f5 - f9) / 2.0f;
            }
            if (bl2) {
                actor.setBounds(Math.round(f6), Math.round(f8), Math.round(f10), Math.round(f9));
            } else {
                actor.setBounds(f6, f8, f10, f9);
            }
            f6 += f10 + f2;
            if (layout != null) {
                layout.validate();
            }
            n3 += n5;
        }
    }

    private void layoutWrapped() {
        float f2 = this.getPrefHeight();
        if (f2 != this.lastPrefHeight) {
            this.lastPrefHeight = f2;
            this.invalidateHierarchy();
        }
        int n2 = this.align;
        boolean bl2 = this.round;
        float f3 = this.space;
        float f4 = this.fill;
        float f5 = this.wrapSpace;
        float f6 = this.prefWidth - this.padLeft - this.padRight;
        float f7 = f2 - this.padTop;
        float f8 = this.getWidth();
        float f9 = this.padLeft;
        float f10 = 0.0f;
        float f11 = 0.0f;
        float f12 = -1.0f;
        if ((n2 & 2) != 0) {
            f7 += this.getHeight() - f2;
        } else if ((n2 & 4) == 0) {
            f7 += (this.getHeight() - f2) / 2.0f;
        }
        if (this.wrapReverse) {
            f7 -= f2 + this.rowSizes.get(1);
            f12 = 1.0f;
        }
        if ((n2 & 0x10) != 0) {
            f9 += f8 - this.prefWidth;
        } else if ((n2 & 8) == 0) {
            f9 += (f8 - this.prefWidth) / 2.0f;
        }
        f8 -= this.padRight;
        n2 = this.rowAlign;
        FloatArray floatArray = this.rowSizes;
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
                if (f15 > f8) {
                    f15 = Math.max(f8, layout.getMinWidth());
                }
                f14 = layout.getPrefHeight();
            } else {
                f15 = actor.getWidth();
                f14 = actor.getHeight();
            }
            if (f10 + f15 > f8 || n6 == 0) {
                n6 = Math.min(n6, floatArray.size - 2);
                f10 = f9;
                if ((n2 & 0x10) != 0) {
                    f10 += f6 - floatArray.get(n6);
                } else if ((n2 & 8) == 0) {
                    f10 += (f6 - floatArray.get(n6)) / 2.0f;
                }
                f11 = floatArray.get(n6 + 1);
                if (n6 > 0) {
                    f7 += f5 * f12;
                }
                f7 += f11 * f12;
                n6 += 2;
            }
            if (f4 > 0.0f) {
                f14 = f11 * f4;
            }
            if (layout != null) {
                f14 = Math.max(f14, layout.getMinHeight());
                f13 = layout.getMaxHeight();
                if (f13 > 0.0f && f14 > f13) {
                    f14 = f13;
                }
            }
            f13 = f7;
            if ((n2 & 2) != 0) {
                f13 += f11 - f14;
            } else if ((n2 & 4) == 0) {
                f13 += (f11 - f14) / 2.0f;
            }
            if (bl2) {
                actor.setBounds(Math.round(f10), Math.round(f13), Math.round(f15), Math.round(f14));
            } else {
                actor.setBounds(f10, f13, f15, f14);
            }
            f10 += f15 + f3;
            if (layout != null) {
                layout.validate();
            }
            n3 += n5;
        }
    }

    @Override
    public float getPrefWidth() {
        if (this.wrap) {
            return 0.0f;
        }
        if (this.sizeInvalid) {
            this.computeSize();
        }
        return this.prefWidth;
    }

    @Override
    public float getPrefHeight() {
        if (this.sizeInvalid) {
            this.computeSize();
        }
        return this.prefHeight;
    }

    public int getRows() {
        return this.wrap ? this.rowSizes.size >> 1 : 1;
    }

    public void setRound(boolean bl2) {
        this.round = bl2;
    }

    public HorizontalGroup reverse() {
        this.reverse = true;
        return this;
    }

    public HorizontalGroup reverse(boolean bl2) {
        this.reverse = bl2;
        return this;
    }

    public boolean getReverse() {
        return this.reverse;
    }

    public HorizontalGroup wrapReverse() {
        this.wrapReverse = true;
        return this;
    }

    public HorizontalGroup wrapReverse(boolean bl2) {
        this.wrapReverse = bl2;
        return this;
    }

    public boolean getWrapReverse() {
        return this.wrapReverse;
    }

    public HorizontalGroup space(float f2) {
        this.space = f2;
        return this;
    }

    public float getSpace() {
        return this.space;
    }

    public HorizontalGroup wrapSpace(float f2) {
        this.wrapSpace = f2;
        return this;
    }

    public float getWrapSpace() {
        return this.wrapSpace;
    }

    public HorizontalGroup pad(float f2) {
        this.padTop = f2;
        this.padLeft = f2;
        this.padBottom = f2;
        this.padRight = f2;
        return this;
    }

    public HorizontalGroup pad(float f2, float f3, float f4, float f5) {
        this.padTop = f2;
        this.padLeft = f3;
        this.padBottom = f4;
        this.padRight = f5;
        return this;
    }

    public HorizontalGroup padTop(float f2) {
        this.padTop = f2;
        return this;
    }

    public HorizontalGroup padLeft(float f2) {
        this.padLeft = f2;
        return this;
    }

    public HorizontalGroup padBottom(float f2) {
        this.padBottom = f2;
        return this;
    }

    public HorizontalGroup padRight(float f2) {
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

    public HorizontalGroup align(int n2) {
        this.align = n2;
        return this;
    }

    public HorizontalGroup center() {
        this.align = 1;
        return this;
    }

    public HorizontalGroup top() {
        this.align |= 2;
        this.align &= 0xFFFFFFFB;
        return this;
    }

    public HorizontalGroup left() {
        this.align |= 8;
        this.align &= 0xFFFFFFEF;
        return this;
    }

    public HorizontalGroup bottom() {
        this.align |= 4;
        this.align &= 0xFFFFFFFD;
        return this;
    }

    public HorizontalGroup right() {
        this.align |= 0x10;
        this.align &= 0xFFFFFFF7;
        return this;
    }

    public int getAlign() {
        return this.align;
    }

    public HorizontalGroup fill() {
        this.fill = 1.0f;
        return this;
    }

    public HorizontalGroup fill(float f2) {
        this.fill = f2;
        return this;
    }

    public float getFill() {
        return this.fill;
    }

    public HorizontalGroup expand() {
        this.expand = true;
        return this;
    }

    public HorizontalGroup expand(boolean bl2) {
        this.expand = bl2;
        return this;
    }

    public boolean getExpand() {
        return this.expand;
    }

    public HorizontalGroup grow() {
        this.expand = true;
        this.fill = 1.0f;
        return this;
    }

    public HorizontalGroup wrap() {
        this.wrap = true;
        return this;
    }

    public HorizontalGroup wrap(boolean bl2) {
        this.wrap = bl2;
        return this;
    }

    public boolean getWrap() {
        return this.wrap;
    }

    public HorizontalGroup rowAlign(int n2) {
        this.rowAlign = n2;
        return this;
    }

    public HorizontalGroup rowCenter() {
        this.rowAlign = 1;
        return this;
    }

    public HorizontalGroup rowTop() {
        this.rowAlign |= 2;
        this.rowAlign &= 0xFFFFFFFB;
        return this;
    }

    public HorizontalGroup rowLeft() {
        this.rowAlign |= 8;
        this.rowAlign &= 0xFFFFFFEF;
        return this;
    }

    public HorizontalGroup rowBottom() {
        this.rowAlign |= 4;
        this.rowAlign &= 0xFFFFFFFD;
        return this;
    }

    public HorizontalGroup rowRight() {
        this.rowAlign |= 0x10;
        this.rowAlign &= 0xFFFFFFF7;
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

