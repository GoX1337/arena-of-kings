/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g2d;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.IntArray;
import com.badlogic.gdx.utils.NumberUtils;
import com.badlogic.gdx.utils.Pools;
import java.util.Arrays;

public class BitmapFontCache {
    private static final Color tempColor = new Color(1.0f, 1.0f, 1.0f, 1.0f);
    private final BitmapFont font;
    private boolean integer;
    private final Array<GlyphLayout> layouts = new Array();
    private final Array<GlyphLayout> pooledLayouts = new Array();
    private int glyphCount;
    private float x;
    private float y;
    private final Color color = new Color(1.0f, 1.0f, 1.0f, 1.0f);
    private float currentTint;
    private float[][] pageVertices;
    private int[] idx;
    private IntArray[] pageGlyphIndices;
    private int[] tempGlyphCount;

    public BitmapFontCache(BitmapFont bitmapFont) {
        this(bitmapFont, bitmapFont.usesIntegerPositions());
    }

    public BitmapFontCache(BitmapFont bitmapFont, boolean bl2) {
        this.font = bitmapFont;
        this.integer = bl2;
        int n2 = bitmapFont.regions.size;
        if (n2 == 0) {
            throw new IllegalArgumentException("The specified font must contain at least one texture page.");
        }
        this.pageVertices = new float[n2][];
        this.idx = new int[n2];
        if (n2 > 1) {
            this.pageGlyphIndices = new IntArray[n2];
            int n3 = this.pageGlyphIndices.length;
            for (int i2 = 0; i2 < n3; ++i2) {
                this.pageGlyphIndices[i2] = new IntArray();
            }
        }
        this.tempGlyphCount = new int[n2];
    }

    public void setPosition(float f2, float f3) {
        this.translate(f2 - this.x, f3 - this.y);
    }

    public void translate(float f2, float f3) {
        if (f2 == 0.0f && f3 == 0.0f) {
            return;
        }
        if (this.integer) {
            f2 = Math.round(f2);
            f3 = Math.round(f3);
        }
        this.x += f2;
        this.y += f3;
        float[][] fArray = this.pageVertices;
        int n2 = fArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            float[] fArray2 = fArray[i2];
            int n3 = this.idx[i2];
            for (int i3 = 0; i3 < n3; i3 += 5) {
                int n4 = i3;
                fArray2[n4] = fArray2[n4] + f2;
                int n5 = i3 + 1;
                fArray2[n5] = fArray2[n5] + f3;
            }
        }
    }

    public void tint(Color color) {
        float f2 = color.toFloatBits();
        if (this.currentTint == f2) {
            return;
        }
        this.currentTint = f2;
        float[][] fArray = this.pageVertices;
        Color color2 = tempColor;
        int[] nArray = this.tempGlyphCount;
        Arrays.fill(nArray, 0);
        int n2 = this.layouts.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            GlyphLayout glyphLayout = this.layouts.get(i2);
            IntArray intArray = glyphLayout.colors;
            int n3 = 0;
            int n4 = 0;
            int n5 = 0;
            float f3 = 0.0f;
            int n6 = glyphLayout.runs.size;
            for (int i3 = 0; i3 < n6; ++i3) {
                GlyphLayout.GlyphRun glyphRun = glyphLayout.runs.get(i3);
                T[] TArray = glyphRun.glyphs.items;
                int n7 = glyphRun.glyphs.size;
                for (int i4 = 0; i4 < n7; ++i4) {
                    if (n5++ == n4) {
                        Color.abgr8888ToColor(color2, intArray.get(++n3));
                        f3 = color2.mul(color).toFloatBits();
                        n4 = ++n3 < intArray.size ? intArray.get(n3) : -1;
                    }
                    int n8 = ((BitmapFont.Glyph)TArray[i4]).page;
                    int n9 = nArray[n8] * 20 + 2;
                    int n10 = n8;
                    nArray[n10] = nArray[n10] + 1;
                    float[] fArray2 = fArray[n8];
                    fArray2[n9] = f3;
                    fArray2[n9 + 5] = f3;
                    fArray2[n9 + 10] = f3;
                    fArray2[n9 + 15] = f3;
                }
            }
        }
    }

    public void setAlphas(float f2) {
        int n2 = (int)(254.0f * f2) << 24;
        float f3 = 0.0f;
        float f4 = 0.0f;
        int n3 = this.pageVertices.length;
        for (int i2 = 0; i2 < n3; ++i2) {
            float[] fArray = this.pageVertices[i2];
            int n4 = this.idx[i2];
            for (int i3 = 2; i3 < n4; i3 += 5) {
                float f5 = fArray[i3];
                if (f5 == f3 && i3 != 2) {
                    fArray[i3] = f4;
                    continue;
                }
                f3 = f5;
                int n5 = NumberUtils.floatToIntColor(f5);
                n5 = n5 & 0xFFFFFF | n2;
                fArray[i3] = f4 = NumberUtils.intToFloatColor(n5);
            }
        }
    }

    public void setColors(float f2) {
        int n2 = this.pageVertices.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            float[] fArray = this.pageVertices[i2];
            int n3 = this.idx[i2];
            for (int i3 = 2; i3 < n3; i3 += 5) {
                fArray[i3] = f2;
            }
        }
    }

    public void setColors(Color color) {
        this.setColors(color.toFloatBits());
    }

    public void setColors(float f2, float f3, float f4, float f5) {
        int n2 = (int)(255.0f * f5) << 24 | (int)(255.0f * f4) << 16 | (int)(255.0f * f3) << 8 | (int)(255.0f * f2);
        this.setColors(NumberUtils.intToFloatColor(n2));
    }

    public void setColors(Color color, int n2, int n3) {
        this.setColors(color.toFloatBits(), n2, n3);
    }

    public void setColors(float f2, int n2, int n3) {
        if (this.pageVertices.length == 1) {
            float[] fArray = this.pageVertices[0];
            int n4 = Math.min(n3 * 20, this.idx[0]);
            for (int i2 = n2 * 20 + 2; i2 < n4; i2 += 5) {
                fArray[i2] = f2;
            }
            return;
        }
        int n5 = this.pageVertices.length;
        for (int i3 = 0; i3 < n5; ++i3) {
            int n6;
            float[] fArray = this.pageVertices[i3];
            IntArray intArray = this.pageGlyphIndices[i3];
            int n7 = intArray.size;
            for (int i4 = 0; i4 < n7 && (n6 = intArray.items[i4]) < n3; ++i4) {
                if (n6 < n2) continue;
                int n8 = i4 * 20 + 2;
                fArray[n8] = f2;
                fArray[n8 + 5] = f2;
                fArray[n8 + 10] = f2;
                fArray[n8 + 15] = f2;
            }
        }
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color color) {
        this.color.set(color);
    }

    public void setColor(float f2, float f3, float f4, float f5) {
        this.color.set(f2, f3, f4, f5);
    }

    public void draw(Batch batch) {
        Array<TextureRegion> array = this.font.getRegions();
        int n2 = this.pageVertices.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (this.idx[i2] <= 0) continue;
            float[] fArray = this.pageVertices[i2];
            batch.draw(array.get(i2).getTexture(), fArray, 0, this.idx[i2]);
        }
    }

    public void draw(Batch batch, int n2, int n3) {
        if (this.pageVertices.length == 1) {
            batch.draw(this.font.getRegion().getTexture(), this.pageVertices[0], n2 * 20, (n3 - n2) * 20);
            return;
        }
        Array<TextureRegion> array = this.font.getRegions();
        int n4 = this.pageVertices.length;
        for (int i2 = 0; i2 < n4; ++i2) {
            int n5;
            int n6 = -1;
            int n7 = 0;
            IntArray intArray = this.pageGlyphIndices[i2];
            int n8 = intArray.size;
            for (int i3 = 0; i3 < n8 && (n5 = intArray.get(i3)) < n3; ++i3) {
                if (n6 == -1 && n5 >= n2) {
                    n6 = i3;
                }
                if (n5 < n2) continue;
                ++n7;
            }
            if (n6 == -1 || n7 == 0) continue;
            batch.draw(array.get(i2).getTexture(), this.pageVertices[i2], n6 * 20, n7 * 20);
        }
    }

    public void draw(Batch batch, float f2) {
        if (f2 == 1.0f) {
            this.draw(batch);
            return;
        }
        Color color = this.getColor();
        float f3 = color.a;
        color.a *= f2;
        this.setColors(color);
        this.draw(batch);
        color.a = f3;
        this.setColors(color);
    }

    public void clear() {
        this.x = 0.0f;
        this.y = 0.0f;
        Pools.freeAll(this.pooledLayouts, true);
        this.pooledLayouts.clear();
        this.layouts.clear();
        int n2 = this.idx.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (this.pageGlyphIndices != null) {
                this.pageGlyphIndices[i2].clear();
            }
            this.idx[i2] = 0;
        }
    }

    private void requireGlyphs(GlyphLayout glyphLayout) {
        if (this.pageVertices.length == 1) {
            this.requirePageGlyphs(0, glyphLayout.glyphCount);
        } else {
            int n2;
            int[] nArray = this.tempGlyphCount;
            Arrays.fill(nArray, 0);
            int n3 = glyphLayout.runs.size;
            for (n2 = 0; n2 < n3; ++n2) {
                Array<BitmapFont.Glyph> array = glyphLayout.runs.get((int)n2).glyphs;
                T[] TArray = array.items;
                int n4 = array.size;
                for (int i2 = 0; i2 < n4; ++i2) {
                    int n5 = ((BitmapFont.Glyph)TArray[i2]).page;
                    nArray[n5] = nArray[n5] + 1;
                }
            }
            n3 = nArray.length;
            for (n2 = 0; n2 < n3; ++n2) {
                this.requirePageGlyphs(n2, nArray[n2]);
            }
        }
    }

    private void requirePageGlyphs(int n2, int n3) {
        if (this.pageGlyphIndices != null && n3 > this.pageGlyphIndices[n2].items.length) {
            this.pageGlyphIndices[n2].ensureCapacity(n3 - this.pageGlyphIndices[n2].size);
        }
        int n4 = this.idx[n2] + n3 * 20;
        float[] fArray = this.pageVertices[n2];
        if (fArray == null) {
            this.pageVertices[n2] = new float[n4];
        } else if (fArray.length < n4) {
            float[] fArray2 = new float[n4];
            System.arraycopy(fArray, 0, fArray2, 0, this.idx[n2]);
            this.pageVertices[n2] = fArray2;
        }
    }

    private void setPageCount(int n2) {
        float[][] fArrayArray = new float[n2][];
        System.arraycopy(this.pageVertices, 0, fArrayArray, 0, this.pageVertices.length);
        this.pageVertices = fArrayArray;
        int[] nArray = new int[n2];
        System.arraycopy(this.idx, 0, nArray, 0, this.idx.length);
        this.idx = nArray;
        IntArray[] intArrayArray = new IntArray[n2];
        int n3 = 0;
        if (this.pageGlyphIndices != null) {
            n3 = this.pageGlyphIndices.length;
            System.arraycopy(this.pageGlyphIndices, 0, intArrayArray, 0, this.pageGlyphIndices.length);
        }
        for (int i2 = n3; i2 < n2; ++i2) {
            intArrayArray[i2] = new IntArray();
        }
        this.pageGlyphIndices = intArrayArray;
        this.tempGlyphCount = new int[n2];
    }

    private void addToCache(GlyphLayout glyphLayout, float f2, float f3) {
        int n2 = glyphLayout.runs.size;
        if (n2 == 0) {
            return;
        }
        if (this.pageVertices.length < this.font.regions.size) {
            this.setPageCount(this.font.regions.size);
        }
        this.layouts.add(glyphLayout);
        this.requireGlyphs(glyphLayout);
        IntArray intArray = glyphLayout.colors;
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        float f4 = 0.0f;
        for (int i2 = 0; i2 < n2; ++i2) {
            GlyphLayout.GlyphRun glyphRun = glyphLayout.runs.get(i2);
            T[] TArray = glyphRun.glyphs.items;
            float[] fArray = glyphRun.xAdvances.items;
            float f5 = f2 + glyphRun.x;
            float f6 = f3 + glyphRun.y;
            int n6 = glyphRun.glyphs.size;
            for (int i3 = 0; i3 < n6; ++i3) {
                if (n5++ == n4) {
                    f4 = NumberUtils.intToFloatColor(intArray.get(++n3));
                    n4 = ++n3 < intArray.size ? intArray.get(n3) : -1;
                }
                this.addGlyph((BitmapFont.Glyph)TArray[i3], f5 += fArray[i3], f6, f4);
            }
        }
        this.currentTint = Color.WHITE_FLOAT_BITS;
    }

    private void addGlyph(BitmapFont.Glyph glyph, float f2, float f3, float f4) {
        float f5 = this.font.data.scaleX;
        float f6 = this.font.data.scaleY;
        f2 += (float)glyph.xoffset * f5;
        f3 += (float)glyph.yoffset * f6;
        float f7 = (float)glyph.width * f5;
        float f8 = (float)glyph.height * f6;
        float f9 = glyph.u;
        float f10 = glyph.u2;
        float f11 = glyph.v;
        float f12 = glyph.v2;
        if (this.integer) {
            f2 = Math.round(f2);
            f3 = Math.round(f3);
            f7 = Math.round(f7);
            f8 = Math.round(f8);
        }
        float f13 = f2 + f7;
        float f14 = f3 + f8;
        int n2 = glyph.page;
        int n3 = this.idx[n2];
        int n4 = n2;
        this.idx[n4] = this.idx[n4] + 20;
        if (this.pageGlyphIndices != null) {
            this.pageGlyphIndices[n2].add(this.glyphCount++);
        }
        float[] fArray = this.pageVertices[n2];
        fArray[n3++] = f2;
        fArray[n3++] = f3;
        fArray[n3++] = f4;
        fArray[n3++] = f9;
        fArray[n3++] = f11;
        fArray[n3++] = f2;
        fArray[n3++] = f14;
        fArray[n3++] = f4;
        fArray[n3++] = f9;
        fArray[n3++] = f12;
        fArray[n3++] = f13;
        fArray[n3++] = f14;
        fArray[n3++] = f4;
        fArray[n3++] = f10;
        fArray[n3++] = f12;
        fArray[n3++] = f13;
        fArray[n3++] = f3;
        fArray[n3++] = f4;
        fArray[n3++] = f10;
        fArray[n3] = f11;
    }

    public GlyphLayout setText(CharSequence charSequence, float f2, float f3) {
        this.clear();
        return this.addText(charSequence, f2, f3, 0, charSequence.length(), 0.0f, 8, false);
    }

    public GlyphLayout setText(CharSequence charSequence, float f2, float f3, float f4, int n2, boolean bl2) {
        this.clear();
        return this.addText(charSequence, f2, f3, 0, charSequence.length(), f4, n2, bl2);
    }

    public GlyphLayout setText(CharSequence charSequence, float f2, float f3, int n2, int n3, float f4, int n4, boolean bl2) {
        this.clear();
        return this.addText(charSequence, f2, f3, n2, n3, f4, n4, bl2);
    }

    public GlyphLayout setText(CharSequence charSequence, float f2, float f3, int n2, int n3, float f4, int n4, boolean bl2, String string) {
        this.clear();
        return this.addText(charSequence, f2, f3, n2, n3, f4, n4, bl2, string);
    }

    public void setText(GlyphLayout glyphLayout, float f2, float f3) {
        this.clear();
        this.addText(glyphLayout, f2, f3);
    }

    public GlyphLayout addText(CharSequence charSequence, float f2, float f3) {
        return this.addText(charSequence, f2, f3, 0, charSequence.length(), 0.0f, 8, false, null);
    }

    public GlyphLayout addText(CharSequence charSequence, float f2, float f3, float f4, int n2, boolean bl2) {
        return this.addText(charSequence, f2, f3, 0, charSequence.length(), f4, n2, bl2, null);
    }

    public GlyphLayout addText(CharSequence charSequence, float f2, float f3, int n2, int n3, float f4, int n4, boolean bl2) {
        return this.addText(charSequence, f2, f3, n2, n3, f4, n4, bl2, null);
    }

    public GlyphLayout addText(CharSequence charSequence, float f2, float f3, int n2, int n3, float f4, int n4, boolean bl2, String string) {
        GlyphLayout glyphLayout = Pools.obtain(GlyphLayout.class);
        this.pooledLayouts.add(glyphLayout);
        glyphLayout.setText(this.font, charSequence, n2, n3, this.color, f4, n4, bl2, string);
        this.addText(glyphLayout, f2, f3);
        return glyphLayout;
    }

    public void addText(GlyphLayout glyphLayout, float f2, float f3) {
        this.addToCache(glyphLayout, f2, f3 + this.font.data.ascent);
    }

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }

    public BitmapFont getFont() {
        return this.font;
    }

    public void setUseIntegerPositions(boolean bl2) {
        this.integer = bl2;
    }

    public boolean usesIntegerPositions() {
        return this.integer;
    }

    public float[] getVertices() {
        return this.getVertices(0);
    }

    public float[] getVertices(int n2) {
        return this.pageVertices[n2];
    }

    public int getVertexCount(int n2) {
        return this.idx[n2];
    }

    public Array<GlyphLayout> getLayouts() {
        return this.layouts;
    }
}

