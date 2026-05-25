/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g2d;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFontCache;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.FloatArray;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.StreamUtils;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BitmapFont
implements Disposable {
    private static final int LOG2_PAGE_SIZE = 9;
    private static final int PAGE_SIZE = 512;
    private static final int PAGES = 128;
    final BitmapFontData data;
    Array<TextureRegion> regions;
    private final BitmapFontCache cache;
    private boolean flipped;
    boolean integer;
    private boolean ownsTexture;

    public BitmapFont() {
        this(Gdx.files.classpath("com/badlogic/gdx/utils/lsans-15.fnt"), Gdx.files.classpath("com/badlogic/gdx/utils/lsans-15.png"), false, true);
    }

    public BitmapFont(boolean bl2) {
        this(Gdx.files.classpath("com/badlogic/gdx/utils/lsans-15.fnt"), Gdx.files.classpath("com/badlogic/gdx/utils/lsans-15.png"), bl2, true);
    }

    public BitmapFont(FileHandle fileHandle, TextureRegion textureRegion) {
        this(fileHandle, textureRegion, false);
    }

    public BitmapFont(FileHandle fileHandle, TextureRegion textureRegion, boolean bl2) {
        this(new BitmapFontData(fileHandle, bl2), textureRegion, true);
    }

    public BitmapFont(FileHandle fileHandle) {
        this(fileHandle, false);
    }

    public BitmapFont(FileHandle fileHandle, boolean bl2) {
        this(new BitmapFontData(fileHandle, bl2), (TextureRegion)null, true);
    }

    public BitmapFont(FileHandle fileHandle, FileHandle fileHandle2, boolean bl2) {
        this(fileHandle, fileHandle2, bl2, true);
    }

    public BitmapFont(FileHandle fileHandle, FileHandle fileHandle2, boolean bl2, boolean bl3) {
        this(new BitmapFontData(fileHandle, bl2), new TextureRegion(new Texture(fileHandle2, false)), bl3);
        this.ownsTexture = true;
    }

    public BitmapFont(BitmapFontData bitmapFontData, TextureRegion textureRegion, boolean bl2) {
        this(bitmapFontData, textureRegion != null ? Array.with(textureRegion) : null, bl2);
    }

    public BitmapFont(BitmapFontData bitmapFontData, Array<TextureRegion> array, boolean bl2) {
        this.flipped = bitmapFontData.flipped;
        this.data = bitmapFontData;
        this.integer = bl2;
        if (array == null || array.size == 0) {
            if (bitmapFontData.imagePaths == null) {
                throw new IllegalArgumentException("If no regions are specified, the font data must have an images path.");
            }
            int n2 = bitmapFontData.imagePaths.length;
            this.regions = new Array(n2);
            for (int i2 = 0; i2 < n2; ++i2) {
                FileHandle fileHandle = bitmapFontData.fontFile == null ? Gdx.files.internal(bitmapFontData.imagePaths[i2]) : Gdx.files.getFileHandle(bitmapFontData.imagePaths[i2], bitmapFontData.fontFile.type());
                this.regions.add(new TextureRegion(new Texture(fileHandle, false)));
            }
            this.ownsTexture = true;
        } else {
            this.regions = array;
            this.ownsTexture = false;
        }
        this.cache = this.newFontCache();
        this.load(bitmapFontData);
    }

    protected void load(BitmapFontData bitmapFontData) {
        for (Glyph[] glyphArray : bitmapFontData.glyphs) {
            if (glyphArray == null) continue;
            for (Glyph glyph : glyphArray) {
                if (glyph == null) continue;
                bitmapFontData.setGlyphRegion(glyph, this.regions.get(glyph.page));
            }
        }
        if (bitmapFontData.missingGlyph != null) {
            bitmapFontData.setGlyphRegion(bitmapFontData.missingGlyph, this.regions.get(bitmapFontData.missingGlyph.page));
        }
    }

    public GlyphLayout draw(Batch batch, CharSequence charSequence, float f2, float f3) {
        this.cache.clear();
        GlyphLayout glyphLayout = this.cache.addText(charSequence, f2, f3);
        this.cache.draw(batch);
        return glyphLayout;
    }

    public GlyphLayout draw(Batch batch, CharSequence charSequence, float f2, float f3, float f4, int n2, boolean bl2) {
        this.cache.clear();
        GlyphLayout glyphLayout = this.cache.addText(charSequence, f2, f3, f4, n2, bl2);
        this.cache.draw(batch);
        return glyphLayout;
    }

    public GlyphLayout draw(Batch batch, CharSequence charSequence, float f2, float f3, int n2, int n3, float f4, int n4, boolean bl2) {
        this.cache.clear();
        GlyphLayout glyphLayout = this.cache.addText(charSequence, f2, f3, n2, n3, f4, n4, bl2);
        this.cache.draw(batch);
        return glyphLayout;
    }

    public GlyphLayout draw(Batch batch, CharSequence charSequence, float f2, float f3, int n2, int n3, float f4, int n4, boolean bl2, String string) {
        this.cache.clear();
        GlyphLayout glyphLayout = this.cache.addText(charSequence, f2, f3, n2, n3, f4, n4, bl2, string);
        this.cache.draw(batch);
        return glyphLayout;
    }

    public void draw(Batch batch, GlyphLayout glyphLayout, float f2, float f3) {
        this.cache.clear();
        this.cache.addText(glyphLayout, f2, f3);
        this.cache.draw(batch);
    }

    public Color getColor() {
        return this.cache.getColor();
    }

    public void setColor(Color color) {
        this.cache.getColor().set(color);
    }

    public void setColor(float f2, float f3, float f4, float f5) {
        this.cache.getColor().set(f2, f3, f4, f5);
    }

    public float getScaleX() {
        return this.data.scaleX;
    }

    public float getScaleY() {
        return this.data.scaleY;
    }

    public TextureRegion getRegion() {
        return this.regions.first();
    }

    public Array<TextureRegion> getRegions() {
        return this.regions;
    }

    public TextureRegion getRegion(int n2) {
        return this.regions.get(n2);
    }

    public float getLineHeight() {
        return this.data.lineHeight;
    }

    public float getSpaceXadvance() {
        return this.data.spaceXadvance;
    }

    public float getXHeight() {
        return this.data.xHeight;
    }

    public float getCapHeight() {
        return this.data.capHeight;
    }

    public float getAscent() {
        return this.data.ascent;
    }

    public float getDescent() {
        return this.data.descent;
    }

    public boolean isFlipped() {
        return this.flipped;
    }

    @Override
    public void dispose() {
        if (this.ownsTexture) {
            for (int i2 = 0; i2 < this.regions.size; ++i2) {
                this.regions.get(i2).getTexture().dispose();
            }
        }
    }

    public void setFixedWidthGlyphs(CharSequence charSequence) {
        Glyph glyph;
        int n2;
        BitmapFontData bitmapFontData = this.data;
        int n3 = 0;
        int n4 = charSequence.length();
        for (n2 = 0; n2 < n4; ++n2) {
            glyph = bitmapFontData.getGlyph(charSequence.charAt(n2));
            if (glyph == null || glyph.xadvance <= n3) continue;
            n3 = glyph.xadvance;
        }
        n4 = charSequence.length();
        for (n2 = 0; n2 < n4; ++n2) {
            glyph = bitmapFontData.getGlyph(charSequence.charAt(n2));
            if (glyph == null) continue;
            glyph.xoffset += (n3 - glyph.xadvance) / 2;
            glyph.xadvance = n3;
            glyph.kerning = null;
            glyph.fixedWidth = true;
        }
    }

    public void setUseIntegerPositions(boolean bl2) {
        this.integer = bl2;
        this.cache.setUseIntegerPositions(bl2);
    }

    public boolean usesIntegerPositions() {
        return this.integer;
    }

    public BitmapFontCache getCache() {
        return this.cache;
    }

    public BitmapFontData getData() {
        return this.data;
    }

    public boolean ownsTexture() {
        return this.ownsTexture;
    }

    public void setOwnsTexture(boolean bl2) {
        this.ownsTexture = bl2;
    }

    public BitmapFontCache newFontCache() {
        return new BitmapFontCache(this, this.integer);
    }

    public String toString() {
        return this.data.name != null ? this.data.name : super.toString();
    }

    static int indexOf(CharSequence charSequence, char c2, int n2) {
        int n3 = charSequence.length();
        while (n2 < n3) {
            if (charSequence.charAt(n2) == c2) {
                return n2;
            }
            ++n2;
        }
        return n3;
    }

    public static class BitmapFontData {
        public String name;
        public String[] imagePaths;
        public FileHandle fontFile;
        public boolean flipped;
        public float padTop;
        public float padRight;
        public float padBottom;
        public float padLeft;
        public float lineHeight;
        public float capHeight = 1.0f;
        public float ascent;
        public float descent;
        public float down;
        public float blankLineScale = 1.0f;
        public float scaleX = 1.0f;
        public float scaleY = 1.0f;
        public boolean markupEnabled;
        public float cursorX;
        public final Glyph[][] glyphs = new Glyph[128][];
        public Glyph missingGlyph;
        public float spaceXadvance;
        public float xHeight = 1.0f;
        public char[] breakChars;
        public char[] xChars = new char[]{'x', 'e', 'a', 'o', 'n', 's', 'r', 'c', 'u', 'm', 'v', 'w', 'z'};
        public char[] capChars = new char[]{'M', 'N', 'B', 'D', 'C', 'E', 'F', 'K', 'A', 'G', 'H', 'I', 'J', 'L', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

        public BitmapFontData() {
        }

        public BitmapFontData(FileHandle fileHandle, boolean bl2) {
            this.fontFile = fileHandle;
            this.flipped = bl2;
            this.load(fileHandle, bl2);
        }

        public void load(FileHandle fileHandle, boolean bl2) {
            if (this.imagePaths != null) {
                throw new IllegalStateException("Already loaded.");
            }
            this.name = fileHandle.nameWithoutExtension();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileHandle.read()), 512);
            try {
                char c3;
                int n2;
                int n3;
                Glyph glyph;
                Object object;
                Object object2;
                String string = bufferedReader.readLine();
                if (string == null) {
                    throw new GdxRuntimeException("File is empty.");
                }
                String[] stringArray = (string = string.substring(string.indexOf("padding=") + 8)).substring(0, string.indexOf(32)).split(",", 4);
                if (stringArray.length != 4) {
                    throw new GdxRuntimeException("Invalid padding.");
                }
                this.padTop = Integer.parseInt(stringArray[0]);
                this.padRight = Integer.parseInt(stringArray[1]);
                this.padBottom = Integer.parseInt(stringArray[2]);
                this.padLeft = Integer.parseInt(stringArray[3]);
                float f2 = this.padTop + this.padBottom;
                string = bufferedReader.readLine();
                if (string == null) {
                    throw new GdxRuntimeException("Missing common header.");
                }
                String[] stringArray2 = string.split(" ", 9);
                if (stringArray2.length < 3) {
                    throw new GdxRuntimeException("Invalid common header.");
                }
                if (!stringArray2[1].startsWith("lineHeight=")) {
                    throw new GdxRuntimeException("Missing: lineHeight");
                }
                this.lineHeight = Integer.parseInt(stringArray2[1].substring(11));
                if (!stringArray2[2].startsWith("base=")) {
                    throw new GdxRuntimeException("Missing: base");
                }
                float f3 = Integer.parseInt(stringArray2[2].substring(5));
                int n4 = 1;
                if (stringArray2.length >= 6 && stringArray2[5] != null && stringArray2[5].startsWith("pages=")) {
                    try {
                        n4 = Math.max(1, Integer.parseInt(stringArray2[5].substring(6)));
                    }
                    catch (NumberFormatException numberFormatException) {
                        // empty catch block
                    }
                }
                this.imagePaths = new String[n4];
                for (int i2 = 0; i2 < n4; ++i2) {
                    String string2;
                    string = bufferedReader.readLine();
                    if (string == null) {
                        throw new GdxRuntimeException("Missing additional page definitions.");
                    }
                    object2 = Pattern.compile(".*id=(\\d+)").matcher(string);
                    if (((Matcher)object2).find()) {
                        string2 = ((Matcher)object2).group(1);
                        try {
                            int n5 = Integer.parseInt(string2);
                            if (n5 != i2) {
                                throw new GdxRuntimeException("Page IDs must be indices starting at 0: " + string2);
                            }
                        }
                        catch (NumberFormatException numberFormatException) {
                            throw new GdxRuntimeException("Invalid page id: " + string2, numberFormatException);
                        }
                    }
                    if (!((Matcher)(object2 = Pattern.compile(".*file=\"?([^\"]+)\"?").matcher(string))).find()) {
                        throw new GdxRuntimeException("Missing: file");
                    }
                    string2 = ((Matcher)object2).group(1);
                    this.imagePaths[i2] = fileHandle.parent().child(string2).path().replaceAll("\\\\", "/");
                }
                this.descent = 0.0f;
                while ((string = bufferedReader.readLine()) != null && !string.startsWith("kernings ") && !string.startsWith("metrics ")) {
                    if (!string.startsWith("char ")) continue;
                    Glyph glyph2 = new Glyph();
                    object2 = new StringTokenizer(string, " =");
                    ((StringTokenizer)object2).nextToken();
                    ((StringTokenizer)object2).nextToken();
                    int n6 = Integer.parseInt(((StringTokenizer)object2).nextToken());
                    if (n6 <= 0) {
                        this.missingGlyph = glyph2;
                    } else {
                        if (n6 > 65535) continue;
                        this.setGlyph(n6, glyph2);
                    }
                    glyph2.id = n6;
                    ((StringTokenizer)object2).nextToken();
                    glyph2.srcX = Integer.parseInt(((StringTokenizer)object2).nextToken());
                    ((StringTokenizer)object2).nextToken();
                    glyph2.srcY = Integer.parseInt(((StringTokenizer)object2).nextToken());
                    ((StringTokenizer)object2).nextToken();
                    glyph2.width = Integer.parseInt(((StringTokenizer)object2).nextToken());
                    ((StringTokenizer)object2).nextToken();
                    glyph2.height = Integer.parseInt(((StringTokenizer)object2).nextToken());
                    ((StringTokenizer)object2).nextToken();
                    glyph2.xoffset = Integer.parseInt(((StringTokenizer)object2).nextToken());
                    ((StringTokenizer)object2).nextToken();
                    glyph2.yoffset = bl2 ? Integer.parseInt(((StringTokenizer)object2).nextToken()) : -(glyph2.height + Integer.parseInt(((StringTokenizer)object2).nextToken()));
                    ((StringTokenizer)object2).nextToken();
                    glyph2.xadvance = Integer.parseInt(((StringTokenizer)object2).nextToken());
                    if (((StringTokenizer)object2).hasMoreTokens()) {
                        ((StringTokenizer)object2).nextToken();
                    }
                    if (((StringTokenizer)object2).hasMoreTokens()) {
                        try {
                            glyph2.page = Integer.parseInt(((StringTokenizer)object2).nextToken());
                        }
                        catch (NumberFormatException numberFormatException) {
                            // empty catch block
                        }
                    }
                    if (glyph2.width <= 0 || glyph2.height <= 0) continue;
                    this.descent = Math.min(f3 + (float)glyph2.yoffset, this.descent);
                }
                this.descent += this.padBottom;
                while ((string = bufferedReader.readLine()) != null && string.startsWith("kerning ")) {
                    StringTokenizer stringTokenizer = new StringTokenizer(string, " =");
                    stringTokenizer.nextToken();
                    stringTokenizer.nextToken();
                    int n7 = Integer.parseInt(stringTokenizer.nextToken());
                    stringTokenizer.nextToken();
                    int n8 = Integer.parseInt(stringTokenizer.nextToken());
                    if (n7 < 0 || n7 > 65535 || n8 < 0 || n8 > 65535) continue;
                    Glyph glyph3 = this.getGlyph((char)n7);
                    stringTokenizer.nextToken();
                    int n9 = Integer.parseInt(stringTokenizer.nextToken());
                    if (glyph3 == null) continue;
                    glyph3.setKerning(n8, n9);
                }
                boolean bl3 = false;
                float f4 = 0.0f;
                float f5 = 0.0f;
                float f6 = 0.0f;
                float f7 = 0.0f;
                float f8 = 0.0f;
                float f9 = 0.0f;
                float f10 = 0.0f;
                if (string != null && string.startsWith("metrics ")) {
                    bl3 = true;
                    object = new StringTokenizer(string, " =");
                    ((StringTokenizer)object).nextToken();
                    ((StringTokenizer)object).nextToken();
                    f4 = Float.parseFloat(((StringTokenizer)object).nextToken());
                    ((StringTokenizer)object).nextToken();
                    f5 = Float.parseFloat(((StringTokenizer)object).nextToken());
                    ((StringTokenizer)object).nextToken();
                    f6 = Float.parseFloat(((StringTokenizer)object).nextToken());
                    ((StringTokenizer)object).nextToken();
                    f7 = Float.parseFloat(((StringTokenizer)object).nextToken());
                    ((StringTokenizer)object).nextToken();
                    f8 = Float.parseFloat(((StringTokenizer)object).nextToken());
                    ((StringTokenizer)object).nextToken();
                    f9 = Float.parseFloat(((StringTokenizer)object).nextToken());
                    ((StringTokenizer)object).nextToken();
                    f10 = Float.parseFloat(((StringTokenizer)object).nextToken());
                }
                if ((object = this.getGlyph(' ')) == null) {
                    object = new Glyph();
                    ((Glyph)object).id = 32;
                    glyph = this.getGlyph('l');
                    if (glyph == null) {
                        glyph = this.getFirstGlyph();
                    }
                    ((Glyph)object).xadvance = glyph.xadvance;
                    this.setGlyph(32, (Glyph)object);
                }
                if (((Glyph)object).width == 0) {
                    ((Glyph)object).width = (int)(this.padLeft + (float)((Glyph)object).xadvance + this.padRight);
                    ((Glyph)object).xoffset = (int)(-this.padLeft);
                }
                this.spaceXadvance = ((Glyph)object).xadvance;
                glyph = null;
                Object object3 = this.xChars;
                int n10 = ((char[])object3).length;
                for (n3 = 0; n3 < n10 && (glyph = this.getGlyph((char)(n2 = object3[n3]))) == null; ++n3) {
                }
                if (glyph == null) {
                    glyph = this.getFirstGlyph();
                }
                this.xHeight = (float)glyph.height - f2;
                object3 = null;
                char[] object4 = this.capChars;
                n3 = object4.length;
                for (n2 = 0; n2 < n3 && (object3 = (Object)this.getGlyph(c3 = object4[n2])) == null; ++n2) {
                }
                if (object3 == null) {
                    for (Glyph[] glyphArray : this.glyphs) {
                        if (glyphArray == null) continue;
                        for (Glyph glyph2 : glyphArray) {
                            if (glyph2 == null || glyph2.height == 0 || glyph2.width == 0) continue;
                            this.capHeight = Math.max(this.capHeight, (float)glyph2.height);
                        }
                    }
                } else {
                    this.capHeight = object3.height;
                }
                this.capHeight -= f2;
                this.ascent = f3 - this.capHeight;
                this.down = -this.lineHeight;
                if (bl2) {
                    this.ascent = -this.ascent;
                    this.down = -this.down;
                }
                if (bl3) {
                    this.ascent = f4;
                    this.descent = f5;
                    this.down = f6;
                    this.capHeight = f7;
                    this.lineHeight = f8;
                    this.spaceXadvance = f9;
                    this.xHeight = f10;
                }
            }
            catch (Exception exception) {
                throw new GdxRuntimeException("Error loading font file: " + fileHandle, exception);
            }
            finally {
                StreamUtils.closeQuietly(bufferedReader);
            }
        }

        public void setGlyphRegion(Glyph glyph, TextureRegion textureRegion) {
            Texture texture = textureRegion.getTexture();
            float f2 = 1.0f / (float)texture.getWidth();
            float f3 = 1.0f / (float)texture.getHeight();
            float f4 = 0.0f;
            float f5 = 0.0f;
            float f6 = textureRegion.u;
            float f7 = textureRegion.v;
            float f8 = textureRegion.getRegionWidth();
            float f9 = textureRegion.getRegionHeight();
            if (textureRegion instanceof TextureAtlas.AtlasRegion) {
                TextureAtlas.AtlasRegion atlasRegion = (TextureAtlas.AtlasRegion)textureRegion;
                f4 = atlasRegion.offsetX;
                f5 = (float)(atlasRegion.originalHeight - atlasRegion.packedHeight) - atlasRegion.offsetY;
            }
            float f10 = glyph.srcX;
            float f11 = glyph.srcX + glyph.width;
            float f12 = glyph.srcY;
            float f13 = glyph.srcY + glyph.height;
            if (f4 > 0.0f) {
                if ((f10 -= f4) < 0.0f) {
                    glyph.width = (int)((float)glyph.width + f10);
                    glyph.xoffset = (int)((float)glyph.xoffset - f10);
                    f10 = 0.0f;
                }
                if ((f11 -= f4) > f8) {
                    glyph.width = (int)((float)glyph.width - (f11 - f8));
                    f11 = f8;
                }
            }
            if (f5 > 0.0f) {
                if ((f12 -= f5) < 0.0f) {
                    glyph.height = (int)((float)glyph.height + f12);
                    if (glyph.height < 0) {
                        glyph.height = 0;
                    }
                    f12 = 0.0f;
                }
                if ((f13 -= f5) > f9) {
                    float f14 = f13 - f9;
                    glyph.height = (int)((float)glyph.height - f14);
                    glyph.yoffset = (int)((float)glyph.yoffset + f14);
                    f13 = f9;
                }
            }
            glyph.u = f6 + f10 * f2;
            glyph.u2 = f6 + f11 * f2;
            if (this.flipped) {
                glyph.v = f7 + f12 * f3;
                glyph.v2 = f7 + f13 * f3;
            } else {
                glyph.v2 = f7 + f12 * f3;
                glyph.v = f7 + f13 * f3;
            }
        }

        public void setLineHeight(float f2) {
            this.lineHeight = f2 * this.scaleY;
            this.down = this.flipped ? this.lineHeight : -this.lineHeight;
        }

        public void setGlyph(int n2, Glyph glyph) {
            Glyph[] glyphArray = this.glyphs[n2 / 512];
            if (glyphArray == null) {
                glyphArray = new Glyph[512];
                this.glyphs[n2 / 512] = glyphArray;
            }
            glyphArray[n2 & 0x1FF] = glyph;
        }

        public Glyph getFirstGlyph() {
            for (Glyph[] glyphArray : this.glyphs) {
                if (glyphArray == null) continue;
                for (Glyph glyph : glyphArray) {
                    if (glyph == null || glyph.height == 0 || glyph.width == 0) continue;
                    return glyph;
                }
            }
            throw new GdxRuntimeException("No glyphs found.");
        }

        public boolean hasGlyph(char c2) {
            if (this.missingGlyph != null) {
                return true;
            }
            return this.getGlyph(c2) != null;
        }

        public Glyph getGlyph(char c2) {
            Glyph[] glyphArray = this.glyphs[c2 / 512];
            if (glyphArray != null) {
                return glyphArray[c2 & 0x1FF];
            }
            return null;
        }

        public void getGlyphs(GlyphLayout.GlyphRun glyphRun, CharSequence charSequence, int n2, int n3, Glyph glyph) {
            int n4 = n3 - n2;
            if (n4 == 0) {
                return;
            }
            boolean bl2 = this.markupEnabled;
            float f2 = this.scaleX;
            Array<Glyph> array = glyphRun.glyphs;
            FloatArray floatArray = glyphRun.xAdvances;
            array.ensureCapacity(n4);
            glyphRun.xAdvances.ensureCapacity(n4 + 1);
            do {
                char c2;
                if ((c2 = charSequence.charAt(n2++)) == '\r') continue;
                Glyph glyph2 = this.getGlyph(c2);
                if (glyph2 == null) {
                    if (this.missingGlyph == null) continue;
                    glyph2 = this.missingGlyph;
                }
                array.add(glyph2);
                floatArray.add(glyph == null ? (glyph2.fixedWidth ? 0.0f : (float)(-glyph2.xoffset) * f2 - this.padLeft) : (float)(glyph.xadvance + glyph.getKerning(c2)) * f2);
                glyph = glyph2;
                if (!bl2 || c2 != '[' || n2 >= n3 || charSequence.charAt(n2) != '[') continue;
                ++n2;
            } while (n2 < n3);
            if (glyph != null) {
                float f3 = glyph.fixedWidth ? (float)glyph.xadvance * f2 : (float)(glyph.width + glyph.xoffset) * f2 - this.padRight;
                floatArray.add(f3);
            }
        }

        public int getWrapIndex(Array<Glyph> array, int n2) {
            int n3 = n2 - 1;
            T[] TArray = array.items;
            char c2 = (char)((Glyph)TArray[n3]).id;
            if (this.isWhitespace(c2)) {
                return n3;
            }
            if (this.isBreakChar(c2)) {
                --n3;
            }
            while (n3 > 0) {
                c2 = (char)((Glyph)TArray[n3]).id;
                if (this.isWhitespace(c2) || this.isBreakChar(c2)) {
                    return n3 + 1;
                }
                --n3;
            }
            return 0;
        }

        public boolean isBreakChar(char c2) {
            if (this.breakChars == null) {
                return false;
            }
            for (char c3 : this.breakChars) {
                if (c2 != c3) continue;
                return true;
            }
            return false;
        }

        public boolean isWhitespace(char c2) {
            switch (c2) {
                case '\t': 
                case '\n': 
                case '\r': 
                case ' ': {
                    return true;
                }
            }
            return false;
        }

        public String getImagePath(int n2) {
            return this.imagePaths[n2];
        }

        public String[] getImagePaths() {
            return this.imagePaths;
        }

        public FileHandle getFontFile() {
            return this.fontFile;
        }

        public void setScale(float f2, float f3) {
            if (f2 == 0.0f) {
                throw new IllegalArgumentException("scaleX cannot be 0.");
            }
            if (f3 == 0.0f) {
                throw new IllegalArgumentException("scaleY cannot be 0.");
            }
            float f4 = f2 / this.scaleX;
            float f5 = f3 / this.scaleY;
            this.lineHeight *= f5;
            this.spaceXadvance *= f4;
            this.xHeight *= f5;
            this.capHeight *= f5;
            this.ascent *= f5;
            this.descent *= f5;
            this.down *= f5;
            this.padLeft *= f4;
            this.padRight *= f4;
            this.padTop *= f5;
            this.padBottom *= f5;
            this.scaleX = f2;
            this.scaleY = f3;
        }

        public void setScale(float f2) {
            this.setScale(f2, f2);
        }

        public void scale(float f2) {
            this.setScale(this.scaleX + f2, this.scaleY + f2);
        }

        public String toString() {
            return this.name != null ? this.name : super.toString();
        }
    }

    public static class Glyph {
        public int id;
        public int srcX;
        public int srcY;
        public int width;
        public int height;
        public float u;
        public float v;
        public float u2;
        public float v2;
        public int xoffset;
        public int yoffset;
        public int xadvance;
        public byte[][] kerning;
        public boolean fixedWidth;
        public int page = 0;

        public int getKerning(char c2) {
            byte[] byArray;
            if (this.kerning != null && (byArray = this.kerning[c2 >>> 9]) != null) {
                return byArray[c2 & 0x1FF];
            }
            return 0;
        }

        public void setKerning(int n2, int n3) {
            byte[] byArray;
            if (this.kerning == null) {
                this.kerning = new byte[128][];
            }
            if ((byArray = this.kerning[n2 >>> 9]) == null) {
                byArray = new byte[512];
                this.kerning[n2 >>> 9] = byArray;
            }
            byArray[n2 & 0x1FF] = (byte)n3;
        }

        public String toString() {
            return Character.toString((char)this.id);
        }
    }
}

