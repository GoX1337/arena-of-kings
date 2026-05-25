/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g2d;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Colors;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.FloatArray;
import com.badlogic.gdx.utils.IntArray;
import com.badlogic.gdx.utils.Null;
import com.badlogic.gdx.utils.Pool;
import com.badlogic.gdx.utils.Pools;

public class GlyphLayout
implements Pool.Poolable {
    private static final Pool<GlyphRun> glyphRunPool = Pools.get(GlyphRun.class);
    private static final IntArray colorStack = new IntArray(4);
    private static final float epsilon = 1.0E-4f;
    public final Array<GlyphRun> runs = new Array(1);
    public final IntArray colors = new IntArray(2);
    public int glyphCount;
    public float width;
    public float height;

    public GlyphLayout() {
    }

    public GlyphLayout(BitmapFont bitmapFont, CharSequence charSequence) {
        this.setText(bitmapFont, charSequence);
    }

    public GlyphLayout(BitmapFont bitmapFont, CharSequence charSequence, Color color, float f2, int n2, boolean bl2) {
        this.setText(bitmapFont, charSequence, color, f2, n2, bl2);
    }

    public GlyphLayout(BitmapFont bitmapFont, CharSequence charSequence, int n2, int n3, Color color, float f2, int n4, boolean bl2, String string) {
        this.setText(bitmapFont, charSequence, n2, n3, color, f2, n4, bl2, string);
    }

    public void setText(BitmapFont bitmapFont, CharSequence charSequence) {
        this.setText(bitmapFont, charSequence, 0, charSequence.length(), bitmapFont.getColor(), 0.0f, 8, false, null);
    }

    public void setText(BitmapFont bitmapFont, CharSequence charSequence, Color color, float f2, int n2, boolean bl2) {
        this.setText(bitmapFont, charSequence, 0, charSequence.length(), color, f2, n2, bl2, null);
    }

    public void setText(BitmapFont bitmapFont, CharSequence charSequence, int n2, int n3, Color color, float f2, int n4, boolean bl2, @Null String string) {
        int n5;
        this.reset();
        BitmapFont.BitmapFontData bitmapFontData = bitmapFont.data;
        if (n2 == n3) {
            this.height = bitmapFontData.capHeight;
            return;
        }
        if (bl2) {
            f2 = Math.max(f2, bitmapFontData.spaceXadvance * 3.0f);
        }
        boolean bl3 = bl2 || string != null;
        int n6 = n5 = color.toIntBits();
        this.colors.add(0, n5);
        boolean bl4 = bitmapFontData.markupEnabled;
        if (bl4) {
            colorStack.add(n5);
        }
        boolean bl5 = false;
        float f3 = 0.0f;
        float f4 = bitmapFontData.down;
        GlyphRun glyphRun = null;
        BitmapFont.Glyph glyph = null;
        int n7 = n2;
        block4: while (true) {
            int n8;
            boolean bl6;
            block30: {
                block29: {
                    GlyphRun glyphRun2;
                    block28: {
                        bl6 = false;
                        if (n2 == n3) {
                            if (n7 == n3) break;
                            n8 = n3;
                            bl5 = true;
                        } else {
                            switch (charSequence.charAt(n2++)) {
                                case '\n': {
                                    n8 = n2 - 1;
                                    bl6 = true;
                                    break;
                                }
                                case '[': {
                                    if (bl4) {
                                        int n9 = this.parseColorMarkup(charSequence, n2, n3);
                                        if (n9 >= 0) {
                                            n8 = n2 - 1;
                                            if ((n2 += n9 + 1) == n3) {
                                                bl5 = true;
                                                break;
                                            }
                                            n6 = colorStack.peek();
                                            break;
                                        }
                                        if (n9 == -2) {
                                            ++n2;
                                        }
                                    }
                                }
                                default: {
                                    continue block4;
                                }
                            }
                        }
                        glyphRun2 = glyphRunPool.obtain();
                        glyphRun2.x = 0.0f;
                        glyphRun2.y = f3;
                        bitmapFontData.getGlyphs(glyphRun2, charSequence, n7, n8, glyph);
                        this.glyphCount += glyphRun2.glyphs.size;
                        if (n6 != n5) {
                            if (this.colors.get(this.colors.size - 2) == this.glyphCount) {
                                this.colors.set(this.colors.size - 1, n6);
                            } else {
                                this.colors.add(this.glyphCount);
                                this.colors.add(n6);
                            }
                            n5 = n6;
                        }
                        if (glyphRun2.glyphs.size != 0) break block28;
                        glyphRunPool.free(glyphRun2);
                        if (glyphRun != null) break block29;
                        break block30;
                    }
                    if (glyphRun == null) {
                        glyphRun = glyphRun2;
                        this.runs.add(glyphRun);
                    } else {
                        glyphRun.appendRun(glyphRun2);
                        glyphRunPool.free(glyphRun2);
                    }
                }
                if (bl6 || bl5) {
                    this.setLastGlyphXAdvance(bitmapFontData, glyphRun);
                    glyph = null;
                } else {
                    glyph = glyphRun.glyphs.peek();
                }
                if (bl3 && glyphRun.glyphs.size != 0 && (bl6 || bl5)) {
                    float f5 = glyphRun.xAdvances.first() + glyphRun.xAdvances.get(1);
                    for (int i2 = 2; i2 < glyphRun.xAdvances.size; ++i2) {
                        BitmapFont.Glyph glyph2 = glyphRun.glyphs.get(i2 - 1);
                        float f6 = this.getGlyphWidth(glyph2, bitmapFontData);
                        if (f5 + f6 - 1.0E-4f <= f2) {
                            f5 += glyphRun.xAdvances.items[i2];
                            continue;
                        }
                        if (string != null) {
                            this.truncate(bitmapFontData, glyphRun, f2, string);
                            break block4;
                        }
                        int n10 = bitmapFontData.getWrapIndex(glyphRun.glyphs, i2);
                        if (n10 == 0 && glyphRun.x == 0.0f || n10 >= glyphRun.glyphs.size) {
                            n10 = i2 - 1;
                        }
                        if ((glyphRun = this.wrap(bitmapFontData, glyphRun, n10)) == null) break;
                        this.runs.add(glyphRun);
                        glyphRun.x = 0.0f;
                        glyphRun.y = f3 += f4;
                        f5 = glyphRun.xAdvances.first() + glyphRun.xAdvances.get(1);
                        i2 = 1;
                    }
                }
            }
            if (bl6) {
                glyphRun = null;
                glyph = null;
                f3 = n8 == n7 ? (f3 += f4 * bitmapFontData.blankLineScale) : (f3 += f4);
            }
            n7 = n2;
        }
        this.height = bitmapFontData.capHeight + Math.abs(f3);
        this.calculateWidths(bitmapFontData);
        this.alignRuns(f2, n4);
        if (bl4) {
            colorStack.clear();
        }
    }

    private void calculateWidths(BitmapFont.BitmapFontData bitmapFontData) {
        float f2 = 0.0f;
        T[] TArray = this.runs.items;
        int n2 = this.runs.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            GlyphRun glyphRun = (GlyphRun)TArray[i2];
            float[] fArray = glyphRun.xAdvances.items;
            float f3 = glyphRun.x + fArray[0];
            float f4 = 0.0f;
            T[] TArray2 = glyphRun.glyphs.items;
            int n3 = 0;
            int n4 = glyphRun.glyphs.size;
            while (n3 < n4) {
                BitmapFont.Glyph glyph = (BitmapFont.Glyph)TArray2[n3];
                float f5 = this.getGlyphWidth(glyph, bitmapFontData);
                f4 = Math.max(f4, f3 + f5);
                f3 += fArray[++n3];
            }
            glyphRun.width = Math.max(f3, f4) - glyphRun.x;
            f2 = Math.max(f2, glyphRun.x + glyphRun.width);
        }
        this.width = f2;
    }

    private void alignRuns(float f2, int n2) {
        if ((n2 & 8) == 0) {
            boolean bl2 = (n2 & 1) != 0;
            T[] TArray = this.runs.items;
            int n3 = this.runs.size;
            for (int i2 = 0; i2 < n3; ++i2) {
                GlyphRun glyphRun = (GlyphRun)TArray[i2];
                glyphRun.x = glyphRun.x + (bl2 ? 0.5f * (f2 - glyphRun.width) : f2 - glyphRun.width);
            }
        }
    }

    private void truncate(BitmapFont.BitmapFontData bitmapFontData, GlyphRun glyphRun, float f2, String string) {
        int n2;
        float f3;
        int n3;
        int n4 = glyphRun.glyphs.size;
        GlyphRun glyphRun2 = glyphRunPool.obtain();
        bitmapFontData.getGlyphs(glyphRun2, string, 0, string.length(), null);
        float f4 = 0.0f;
        if (glyphRun2.xAdvances.size > 0) {
            this.setLastGlyphXAdvance(bitmapFontData, glyphRun2);
            float[] fArray = glyphRun2.xAdvances.items;
            int n5 = glyphRun2.xAdvances.size;
            for (int i2 = 1; i2 < n5; ++i2) {
                f4 += fArray[i2];
            }
        }
        f2 -= f4;
        float f5 = glyphRun.x;
        float[] fArray = glyphRun.xAdvances.items;
        for (n3 = 0; n3 < glyphRun.xAdvances.size && !((f5 += (f3 = fArray[n3])) > f2); ++n3) {
        }
        if (n3 > 1) {
            glyphRun.glyphs.truncate(n3 - 1);
            glyphRun.xAdvances.truncate(n3);
            this.setLastGlyphXAdvance(bitmapFontData, glyphRun);
            if (glyphRun2.xAdvances.size > 0) {
                glyphRun.xAdvances.addAll(glyphRun2.xAdvances, 1, glyphRun2.xAdvances.size - 1);
            }
        } else {
            glyphRun.glyphs.clear();
            glyphRun.xAdvances.clear();
            glyphRun.xAdvances.addAll(glyphRun2.xAdvances);
        }
        if ((n2 = n4 - glyphRun.glyphs.size) > 0) {
            this.glyphCount -= n2;
            if (bitmapFontData.markupEnabled) {
                while (this.colors.size > 2 && this.colors.get(this.colors.size - 2) >= this.glyphCount) {
                    this.colors.size -= 2;
                }
            }
        }
        glyphRun.glyphs.addAll(glyphRun2.glyphs);
        this.glyphCount += string.length();
        glyphRunPool.free(glyphRun2);
    }

    private GlyphRun wrap(BitmapFont.BitmapFontData bitmapFontData, GlyphRun glyphRun, int n2) {
        int n3;
        int n4;
        Array<BitmapFont.Glyph> array = glyphRun.glyphs;
        int n5 = glyphRun.glyphs.size;
        FloatArray floatArray = glyphRun.xAdvances;
        for (n4 = n2; n4 > 0 && bitmapFontData.isWhitespace((char)array.get((int)(n4 - 1)).id); --n4) {
        }
        for (n3 = n2; n3 < n5 && bitmapFontData.isWhitespace((char)array.get((int)n3).id); ++n3) {
        }
        GlyphRun glyphRun2 = null;
        if (n3 < n5) {
            glyphRun2 = glyphRunPool.obtain();
            Array<BitmapFont.Glyph> array2 = glyphRun2.glyphs;
            array2.addAll(array, 0, n4);
            array.removeRange(0, n3 - 1);
            glyphRun.glyphs = array2;
            glyphRun2.glyphs = array;
            FloatArray floatArray2 = glyphRun2.xAdvances;
            floatArray2.addAll(floatArray, 0, n4 + 1);
            floatArray.removeRange(1, n3);
            floatArray.items[0] = this.getLineOffset(array, bitmapFontData);
            glyphRun.xAdvances = floatArray2;
            glyphRun2.xAdvances = floatArray;
            int n6 = glyphRun.glyphs.size;
            int n7 = glyphRun2.glyphs.size;
            int n8 = n5 - n6 - n7;
            this.glyphCount -= n8;
            if (bitmapFontData.markupEnabled && n8 > 0) {
                int n9;
                int n10 = this.glyphCount - n7;
                for (int i2 = this.colors.size - 2; i2 >= 2 && (n9 = this.colors.get(i2)) > n10; i2 -= 2) {
                    this.colors.set(i2, n9 - n8);
                }
            }
        } else {
            array.truncate(n4);
            floatArray.truncate(n4 + 1);
            int n11 = n3 - n4;
            if (n11 > 0) {
                this.glyphCount -= n11;
                if (bitmapFontData.markupEnabled && this.colors.get(this.colors.size - 2) > this.glyphCount) {
                    int n12 = this.colors.peek();
                    while (this.colors.get(this.colors.size - 2) > this.glyphCount) {
                        this.colors.size -= 2;
                    }
                    this.colors.set(this.colors.size - 2, this.glyphCount);
                    this.colors.set(this.colors.size - 1, n12);
                }
            }
        }
        if (n4 == 0) {
            glyphRunPool.free(glyphRun);
            this.runs.pop();
        } else {
            this.setLastGlyphXAdvance(bitmapFontData, glyphRun);
        }
        return glyphRun2;
    }

    private void setLastGlyphXAdvance(BitmapFont.BitmapFontData bitmapFontData, GlyphRun glyphRun) {
        BitmapFont.Glyph glyph = glyphRun.glyphs.peek();
        if (!glyph.fixedWidth) {
            glyphRun.xAdvances.items[glyphRun.xAdvances.size - 1] = this.getGlyphWidth(glyph, bitmapFontData);
        }
    }

    private float getGlyphWidth(BitmapFont.Glyph glyph, BitmapFont.BitmapFontData bitmapFontData) {
        return (float)(glyph.width + glyph.xoffset) * bitmapFontData.scaleX - bitmapFontData.padRight;
    }

    private float getLineOffset(Array<BitmapFont.Glyph> array, BitmapFont.BitmapFontData bitmapFontData) {
        return (float)(-array.first().xoffset) * bitmapFontData.scaleX - bitmapFontData.padLeft;
    }

    private int parseColorMarkup(CharSequence charSequence, int n2, int n3) {
        if (n2 == n3) {
            return -1;
        }
        switch (charSequence.charAt(n2)) {
            case '#': {
                int n4 = 0;
                for (int i2 = n2 + 1; i2 < n3; ++i2) {
                    char c2 = charSequence.charAt(i2);
                    if (c2 == ']') {
                        if (i2 < n2 + 2 || i2 > n2 + 9) break;
                        if (i2 - n2 < 8) {
                            n4 = n4 << (9 - (i2 - n2) << 2) | 0xFF;
                        }
                        colorStack.add(Integer.reverseBytes(n4));
                        return i2 - n2;
                    }
                    n4 = (n4 << 4) + c2;
                    if (c2 >= '0' && c2 <= '9') {
                        n4 -= 48;
                        continue;
                    }
                    if (c2 >= 'A' && c2 <= 'F') {
                        n4 -= 55;
                        continue;
                    }
                    if (c2 < 'a' || c2 > 'f') break;
                    n4 -= 87;
                }
                return -1;
            }
            case '[': {
                return -2;
            }
            case ']': {
                if (GlyphLayout.colorStack.size > 1) {
                    colorStack.pop();
                }
                return 0;
            }
        }
        for (int i3 = n2 + 1; i3 < n3; ++i3) {
            char c3 = charSequence.charAt(i3);
            if (c3 != ']') continue;
            Color color = Colors.get(charSequence.subSequence(n2, i3).toString());
            if (color == null) {
                return -1;
            }
            colorStack.add(color.toIntBits());
            return i3 - n2;
        }
        return -1;
    }

    @Override
    public void reset() {
        glyphRunPool.freeAll(this.runs);
        this.runs.clear();
        this.colors.clear();
        this.glyphCount = 0;
        this.width = 0.0f;
        this.height = 0.0f;
    }

    public String toString() {
        if (this.runs.size == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append(this.width);
        stringBuilder.append('x');
        stringBuilder.append(this.height);
        stringBuilder.append('\n');
        int n2 = this.runs.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            stringBuilder.append(this.runs.get(i2).toString());
            stringBuilder.append('\n');
        }
        stringBuilder.setLength(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

    public static class GlyphRun
    implements Pool.Poolable {
        public Array<BitmapFont.Glyph> glyphs = new Array();
        public FloatArray xAdvances = new FloatArray();
        public float x;
        public float y;
        public float width;

        void appendRun(GlyphRun glyphRun) {
            this.glyphs.addAll(glyphRun.glyphs);
            if (this.xAdvances.notEmpty()) {
                --this.xAdvances.size;
            }
            this.xAdvances.addAll(glyphRun.xAdvances);
        }

        @Override
        public void reset() {
            this.glyphs.clear();
            this.xAdvances.clear();
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder(this.glyphs.size + 32);
            Array<BitmapFont.Glyph> array = this.glyphs;
            int n2 = array.size;
            for (int i2 = 0; i2 < n2; ++i2) {
                BitmapFont.Glyph glyph = array.get(i2);
                stringBuilder.append((char)glyph.id);
            }
            stringBuilder.append(", ");
            stringBuilder.append(this.x);
            stringBuilder.append(", ");
            stringBuilder.append(this.y);
            stringBuilder.append(", ");
            stringBuilder.append(this.width);
            return stringBuilder.toString();
        }
    }
}

