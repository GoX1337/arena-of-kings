/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g2d;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.GdxRuntimeException;

public class NinePatch {
    public static final int TOP_LEFT = 0;
    public static final int TOP_CENTER = 1;
    public static final int TOP_RIGHT = 2;
    public static final int MIDDLE_LEFT = 3;
    public static final int MIDDLE_CENTER = 4;
    public static final int MIDDLE_RIGHT = 5;
    public static final int BOTTOM_LEFT = 6;
    public static final int BOTTOM_CENTER = 7;
    public static final int BOTTOM_RIGHT = 8;
    private static final Color tmpDrawColor = new Color();
    private Texture texture;
    private int bottomLeft;
    private int bottomCenter;
    private int bottomRight;
    private int middleLeft;
    private int middleCenter;
    private int middleRight;
    private int topLeft;
    private int topCenter;
    private int topRight;
    private float leftWidth;
    private float rightWidth;
    private float middleWidth;
    private float middleHeight;
    private float topHeight;
    private float bottomHeight;
    private float[] vertices = new float[180];
    private int idx;
    private final Color color = new Color(Color.WHITE);
    private float padLeft = -1.0f;
    private float padRight = -1.0f;
    private float padTop = -1.0f;
    private float padBottom = -1.0f;

    public NinePatch(Texture texture, int n2, int n3, int n4, int n5) {
        this(new TextureRegion(texture), n2, n3, n4, n5);
    }

    public NinePatch(TextureRegion textureRegion, int n2, int n3, int n4, int n5) {
        if (textureRegion == null) {
            throw new IllegalArgumentException("region cannot be null.");
        }
        int n6 = textureRegion.getRegionWidth() - n2 - n3;
        int n7 = textureRegion.getRegionHeight() - n4 - n5;
        TextureRegion[] textureRegionArray = new TextureRegion[9];
        if (n4 > 0) {
            if (n2 > 0) {
                textureRegionArray[0] = new TextureRegion(textureRegion, 0, 0, n2, n4);
            }
            if (n6 > 0) {
                textureRegionArray[1] = new TextureRegion(textureRegion, n2, 0, n6, n4);
            }
            if (n3 > 0) {
                textureRegionArray[2] = new TextureRegion(textureRegion, n2 + n6, 0, n3, n4);
            }
        }
        if (n7 > 0) {
            if (n2 > 0) {
                textureRegionArray[3] = new TextureRegion(textureRegion, 0, n4, n2, n7);
            }
            if (n6 > 0) {
                textureRegionArray[4] = new TextureRegion(textureRegion, n2, n4, n6, n7);
            }
            if (n3 > 0) {
                textureRegionArray[5] = new TextureRegion(textureRegion, n2 + n6, n4, n3, n7);
            }
        }
        if (n5 > 0) {
            if (n2 > 0) {
                textureRegionArray[6] = new TextureRegion(textureRegion, 0, n4 + n7, n2, n5);
            }
            if (n6 > 0) {
                textureRegionArray[7] = new TextureRegion(textureRegion, n2, n4 + n7, n6, n5);
            }
            if (n3 > 0) {
                textureRegionArray[8] = new TextureRegion(textureRegion, n2 + n6, n4 + n7, n3, n5);
            }
        }
        if (n2 == 0 && n6 == 0) {
            textureRegionArray[1] = textureRegionArray[2];
            textureRegionArray[4] = textureRegionArray[5];
            textureRegionArray[7] = textureRegionArray[8];
            textureRegionArray[2] = null;
            textureRegionArray[5] = null;
            textureRegionArray[8] = null;
        }
        if (n4 == 0 && n7 == 0) {
            textureRegionArray[3] = textureRegionArray[6];
            textureRegionArray[4] = textureRegionArray[7];
            textureRegionArray[5] = textureRegionArray[8];
            textureRegionArray[6] = null;
            textureRegionArray[7] = null;
            textureRegionArray[8] = null;
        }
        this.load(textureRegionArray);
    }

    public NinePatch(Texture texture, Color color) {
        this(texture);
        this.setColor(color);
    }

    public NinePatch(Texture texture) {
        this(new TextureRegion(texture));
    }

    public NinePatch(TextureRegion textureRegion, Color color) {
        this(textureRegion);
        this.setColor(color);
    }

    public NinePatch(TextureRegion textureRegion) {
        this.load(new TextureRegion[]{null, null, null, null, textureRegion, null, null, null, null});
    }

    public NinePatch(TextureRegion ... textureRegionArray) {
        if (textureRegionArray == null || textureRegionArray.length != 9) {
            throw new IllegalArgumentException("NinePatch needs nine TextureRegions");
        }
        this.load(textureRegionArray);
        if (textureRegionArray[0] != null && (float)textureRegionArray[0].getRegionWidth() != this.leftWidth || textureRegionArray[3] != null && (float)textureRegionArray[3].getRegionWidth() != this.leftWidth || textureRegionArray[6] != null && (float)textureRegionArray[6].getRegionWidth() != this.leftWidth) {
            throw new GdxRuntimeException("Left side patches must have the same width");
        }
        if (textureRegionArray[2] != null && (float)textureRegionArray[2].getRegionWidth() != this.rightWidth || textureRegionArray[5] != null && (float)textureRegionArray[5].getRegionWidth() != this.rightWidth || textureRegionArray[8] != null && (float)textureRegionArray[8].getRegionWidth() != this.rightWidth) {
            throw new GdxRuntimeException("Right side patches must have the same width");
        }
        if (textureRegionArray[6] != null && (float)textureRegionArray[6].getRegionHeight() != this.bottomHeight || textureRegionArray[7] != null && (float)textureRegionArray[7].getRegionHeight() != this.bottomHeight || textureRegionArray[8] != null && (float)textureRegionArray[8].getRegionHeight() != this.bottomHeight) {
            throw new GdxRuntimeException("Bottom side patches must have the same height");
        }
        if (textureRegionArray[0] != null && (float)textureRegionArray[0].getRegionHeight() != this.topHeight || textureRegionArray[1] != null && (float)textureRegionArray[1].getRegionHeight() != this.topHeight || textureRegionArray[2] != null && (float)textureRegionArray[2].getRegionHeight() != this.topHeight) {
            throw new GdxRuntimeException("Top side patches must have the same height");
        }
    }

    public NinePatch(NinePatch ninePatch) {
        this(ninePatch, ninePatch.color);
    }

    public NinePatch(NinePatch ninePatch, Color color) {
        this.texture = ninePatch.texture;
        this.bottomLeft = ninePatch.bottomLeft;
        this.bottomCenter = ninePatch.bottomCenter;
        this.bottomRight = ninePatch.bottomRight;
        this.middleLeft = ninePatch.middleLeft;
        this.middleCenter = ninePatch.middleCenter;
        this.middleRight = ninePatch.middleRight;
        this.topLeft = ninePatch.topLeft;
        this.topCenter = ninePatch.topCenter;
        this.topRight = ninePatch.topRight;
        this.leftWidth = ninePatch.leftWidth;
        this.rightWidth = ninePatch.rightWidth;
        this.middleWidth = ninePatch.middleWidth;
        this.middleHeight = ninePatch.middleHeight;
        this.topHeight = ninePatch.topHeight;
        this.bottomHeight = ninePatch.bottomHeight;
        this.padLeft = ninePatch.padLeft;
        this.padTop = ninePatch.padTop;
        this.padBottom = ninePatch.padBottom;
        this.padRight = ninePatch.padRight;
        this.vertices = new float[ninePatch.vertices.length];
        System.arraycopy(ninePatch.vertices, 0, this.vertices, 0, ninePatch.vertices.length);
        this.idx = ninePatch.idx;
        this.color.set(color);
    }

    private void load(TextureRegion[] textureRegionArray) {
        if (textureRegionArray[6] != null) {
            this.bottomLeft = this.add(textureRegionArray[6], false, false);
            this.leftWidth = textureRegionArray[6].getRegionWidth();
            this.bottomHeight = textureRegionArray[6].getRegionHeight();
        } else {
            this.bottomLeft = -1;
        }
        if (textureRegionArray[7] != null) {
            this.bottomCenter = this.add(textureRegionArray[7], textureRegionArray[6] != null || textureRegionArray[8] != null, false);
            this.middleWidth = Math.max(this.middleWidth, (float)textureRegionArray[7].getRegionWidth());
            this.bottomHeight = Math.max(this.bottomHeight, (float)textureRegionArray[7].getRegionHeight());
        } else {
            this.bottomCenter = -1;
        }
        if (textureRegionArray[8] != null) {
            this.bottomRight = this.add(textureRegionArray[8], false, false);
            this.rightWidth = Math.max(this.rightWidth, (float)textureRegionArray[8].getRegionWidth());
            this.bottomHeight = Math.max(this.bottomHeight, (float)textureRegionArray[8].getRegionHeight());
        } else {
            this.bottomRight = -1;
        }
        if (textureRegionArray[3] != null) {
            this.middleLeft = this.add(textureRegionArray[3], false, textureRegionArray[0] != null || textureRegionArray[6] != null);
            this.leftWidth = Math.max(this.leftWidth, (float)textureRegionArray[3].getRegionWidth());
            this.middleHeight = Math.max(this.middleHeight, (float)textureRegionArray[3].getRegionHeight());
        } else {
            this.middleLeft = -1;
        }
        if (textureRegionArray[4] != null) {
            this.middleCenter = this.add(textureRegionArray[4], textureRegionArray[3] != null || textureRegionArray[5] != null, textureRegionArray[1] != null || textureRegionArray[7] != null);
            this.middleWidth = Math.max(this.middleWidth, (float)textureRegionArray[4].getRegionWidth());
            this.middleHeight = Math.max(this.middleHeight, (float)textureRegionArray[4].getRegionHeight());
        } else {
            this.middleCenter = -1;
        }
        if (textureRegionArray[5] != null) {
            this.middleRight = this.add(textureRegionArray[5], false, textureRegionArray[2] != null || textureRegionArray[8] != null);
            this.rightWidth = Math.max(this.rightWidth, (float)textureRegionArray[5].getRegionWidth());
            this.middleHeight = Math.max(this.middleHeight, (float)textureRegionArray[5].getRegionHeight());
        } else {
            this.middleRight = -1;
        }
        if (textureRegionArray[0] != null) {
            this.topLeft = this.add(textureRegionArray[0], false, false);
            this.leftWidth = Math.max(this.leftWidth, (float)textureRegionArray[0].getRegionWidth());
            this.topHeight = Math.max(this.topHeight, (float)textureRegionArray[0].getRegionHeight());
        } else {
            this.topLeft = -1;
        }
        if (textureRegionArray[1] != null) {
            this.topCenter = this.add(textureRegionArray[1], textureRegionArray[0] != null || textureRegionArray[2] != null, false);
            this.middleWidth = Math.max(this.middleWidth, (float)textureRegionArray[1].getRegionWidth());
            this.topHeight = Math.max(this.topHeight, (float)textureRegionArray[1].getRegionHeight());
        } else {
            this.topCenter = -1;
        }
        if (textureRegionArray[2] != null) {
            this.topRight = this.add(textureRegionArray[2], false, false);
            this.rightWidth = Math.max(this.rightWidth, (float)textureRegionArray[2].getRegionWidth());
            this.topHeight = Math.max(this.topHeight, (float)textureRegionArray[2].getRegionHeight());
        } else {
            this.topRight = -1;
        }
        if (this.idx < this.vertices.length) {
            float[] fArray = new float[this.idx];
            System.arraycopy(this.vertices, 0, fArray, 0, this.idx);
            this.vertices = fArray;
        }
    }

    private int add(TextureRegion textureRegion, boolean bl2, boolean bl3) {
        if (this.texture == null) {
            this.texture = textureRegion.getTexture();
        } else if (this.texture != textureRegion.getTexture()) {
            throw new IllegalArgumentException("All regions must be from the same texture.");
        }
        float f2 = textureRegion.u;
        float f3 = textureRegion.v2;
        float f4 = textureRegion.u2;
        float f5 = textureRegion.v;
        if (this.texture.getMagFilter() == Texture.TextureFilter.Linear || this.texture.getMinFilter() == Texture.TextureFilter.Linear) {
            float f6;
            if (bl2) {
                f6 = 0.5f / (float)this.texture.getWidth();
                f2 += f6;
                f4 -= f6;
            }
            if (bl3) {
                f6 = 0.5f / (float)this.texture.getHeight();
                f3 -= f6;
                f5 += f6;
            }
        }
        float[] fArray = this.vertices;
        int n2 = this.idx;
        fArray[n2 + 3] = f2;
        fArray[n2 + 4] = f3;
        fArray[n2 + 8] = f2;
        fArray[n2 + 9] = f5;
        fArray[n2 + 13] = f4;
        fArray[n2 + 14] = f5;
        fArray[n2 + 18] = f4;
        fArray[n2 + 19] = f3;
        this.idx += 20;
        return n2;
    }

    private void set(int n2, float f2, float f3, float f4, float f5, float f6) {
        float f7 = f2 + f4;
        float f8 = f3 + f5;
        float[] fArray = this.vertices;
        fArray[n2] = f2;
        fArray[n2 + 1] = f3;
        fArray[n2 + 2] = f6;
        fArray[n2 + 5] = f2;
        fArray[n2 + 6] = f8;
        fArray[n2 + 7] = f6;
        fArray[n2 + 10] = f7;
        fArray[n2 + 11] = f8;
        fArray[n2 + 12] = f6;
        fArray[n2 + 15] = f7;
        fArray[n2 + 16] = f3;
        fArray[n2 + 17] = f6;
    }

    private void prepareVertices(Batch batch, float f2, float f3, float f4, float f5) {
        float f6 = f2 + this.leftWidth;
        float f7 = f3 + this.bottomHeight;
        float f8 = f4 - this.rightWidth - this.leftWidth;
        float f9 = f5 - this.topHeight - this.bottomHeight;
        float f10 = f2 + f4 - this.rightWidth;
        float f11 = f3 + f5 - this.topHeight;
        float f12 = tmpDrawColor.set(this.color).mul(batch.getColor()).toFloatBits();
        if (this.bottomLeft != -1) {
            this.set(this.bottomLeft, f2, f3, this.leftWidth, this.bottomHeight, f12);
        }
        if (this.bottomCenter != -1) {
            this.set(this.bottomCenter, f6, f3, f8, this.bottomHeight, f12);
        }
        if (this.bottomRight != -1) {
            this.set(this.bottomRight, f10, f3, this.rightWidth, this.bottomHeight, f12);
        }
        if (this.middleLeft != -1) {
            this.set(this.middleLeft, f2, f7, this.leftWidth, f9, f12);
        }
        if (this.middleCenter != -1) {
            this.set(this.middleCenter, f6, f7, f8, f9, f12);
        }
        if (this.middleRight != -1) {
            this.set(this.middleRight, f10, f7, this.rightWidth, f9, f12);
        }
        if (this.topLeft != -1) {
            this.set(this.topLeft, f2, f11, this.leftWidth, this.topHeight, f12);
        }
        if (this.topCenter != -1) {
            this.set(this.topCenter, f6, f11, f8, this.topHeight, f12);
        }
        if (this.topRight != -1) {
            this.set(this.topRight, f10, f11, this.rightWidth, this.topHeight, f12);
        }
    }

    public void draw(Batch batch, float f2, float f3, float f4, float f5) {
        this.prepareVertices(batch, f2, f3, f4, f5);
        batch.draw(this.texture, this.vertices, 0, this.idx);
    }

    public void draw(Batch batch, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        this.prepareVertices(batch, f2, f3, f6, f7);
        float f11 = f2 + f4;
        float f12 = f3 + f5;
        int n2 = this.idx;
        float[] fArray = this.vertices;
        if (f10 != 0.0f) {
            for (int i2 = 0; i2 < n2; i2 += 5) {
                float f13 = (fArray[i2] - f11) * f8;
                float f14 = (fArray[i2 + 1] - f12) * f9;
                float f15 = MathUtils.cosDeg(f10);
                float f16 = MathUtils.sinDeg(f10);
                fArray[i2] = f15 * f13 - f16 * f14 + f11;
                fArray[i2 + 1] = f16 * f13 + f15 * f14 + f12;
            }
        } else if (f8 != 1.0f || f9 != 1.0f) {
            for (int i3 = 0; i3 < n2; i3 += 5) {
                fArray[i3] = (fArray[i3] - f11) * f8 + f11;
                fArray[i3 + 1] = (fArray[i3 + 1] - f12) * f9 + f12;
            }
        }
        batch.draw(this.texture, fArray, 0, n2);
    }

    public void setColor(Color color) {
        this.color.set(color);
    }

    public Color getColor() {
        return this.color;
    }

    public float getLeftWidth() {
        return this.leftWidth;
    }

    public void setLeftWidth(float f2) {
        this.leftWidth = f2;
    }

    public float getRightWidth() {
        return this.rightWidth;
    }

    public void setRightWidth(float f2) {
        this.rightWidth = f2;
    }

    public float getTopHeight() {
        return this.topHeight;
    }

    public void setTopHeight(float f2) {
        this.topHeight = f2;
    }

    public float getBottomHeight() {
        return this.bottomHeight;
    }

    public void setBottomHeight(float f2) {
        this.bottomHeight = f2;
    }

    public float getMiddleWidth() {
        return this.middleWidth;
    }

    public void setMiddleWidth(float f2) {
        this.middleWidth = f2;
    }

    public float getMiddleHeight() {
        return this.middleHeight;
    }

    public void setMiddleHeight(float f2) {
        this.middleHeight = f2;
    }

    public float getTotalWidth() {
        return this.leftWidth + this.middleWidth + this.rightWidth;
    }

    public float getTotalHeight() {
        return this.topHeight + this.middleHeight + this.bottomHeight;
    }

    public void setPadding(float f2, float f3, float f4, float f5) {
        this.padLeft = f2;
        this.padRight = f3;
        this.padTop = f4;
        this.padBottom = f5;
    }

    public float getPadLeft() {
        if (this.padLeft == -1.0f) {
            return this.getLeftWidth();
        }
        return this.padLeft;
    }

    public void setPadLeft(float f2) {
        this.padLeft = f2;
    }

    public float getPadRight() {
        if (this.padRight == -1.0f) {
            return this.getRightWidth();
        }
        return this.padRight;
    }

    public void setPadRight(float f2) {
        this.padRight = f2;
    }

    public float getPadTop() {
        if (this.padTop == -1.0f) {
            return this.getTopHeight();
        }
        return this.padTop;
    }

    public void setPadTop(float f2) {
        this.padTop = f2;
    }

    public float getPadBottom() {
        if (this.padBottom == -1.0f) {
            return this.getBottomHeight();
        }
        return this.padBottom;
    }

    public void setPadBottom(float f2) {
        this.padBottom = f2;
    }

    public void scale(float f2, float f3) {
        this.leftWidth *= f2;
        this.rightWidth *= f2;
        this.topHeight *= f3;
        this.bottomHeight *= f3;
        this.middleWidth *= f2;
        this.middleHeight *= f3;
        if (this.padLeft != -1.0f) {
            this.padLeft *= f2;
        }
        if (this.padRight != -1.0f) {
            this.padRight *= f2;
        }
        if (this.padTop != -1.0f) {
            this.padTop *= f3;
        }
        if (this.padBottom != -1.0f) {
            this.padBottom *= f3;
        }
    }

    public Texture getTexture() {
        return this.texture;
    }
}

