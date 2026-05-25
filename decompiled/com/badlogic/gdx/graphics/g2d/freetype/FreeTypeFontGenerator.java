/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g2d.freetype;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.PixmapPacker;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeType;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.Null;
import java.nio.ByteBuffer;

public class FreeTypeFontGenerator
implements Disposable {
    public static final String DEFAULT_CHARS = "\u0000ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890\"!`?'.,;:()[]{}<>|/@\\^$\u20ac-%+=#_&~*\u007f\u0080\u0081\u0082\u0083\u0084\u0085\u0086\u0087\u0088\u0089\u008a\u008b\u008c\u008d\u008e\u008f\u0090\u0091\u0092\u0093\u0094\u0095\u0096\u0097\u0098\u0099\u009a\u009b\u009c\u009d\u009e\u009f\u00a0\u00a1\u00a2\u00a3\u00a4\u00a5\u00a6\u00a7\u00a8\u00a9\u00aa\u00ab\u00ac\u00ad\u00ae\u00af\u00b0\u00b1\u00b2\u00b3\u00b4\u00b5\u00b6\u00b7\u00b8\u00b9\u00ba\u00bb\u00bc\u00bd\u00be\u00bf\u00c0\u00c1\u00c2\u00c3\u00c4\u00c5\u00c6\u00c7\u00c8\u00c9\u00ca\u00cb\u00cc\u00cd\u00ce\u00cf\u00d0\u00d1\u00d2\u00d3\u00d4\u00d5\u00d6\u00d7\u00d8\u00d9\u00da\u00db\u00dc\u00dd\u00de\u00df\u00e0\u00e1\u00e2\u00e3\u00e4\u00e5\u00e6\u00e7\u00e8\u00e9\u00ea\u00eb\u00ec\u00ed\u00ee\u00ef\u00f0\u00f1\u00f2\u00f3\u00f4\u00f5\u00f6\u00f7\u00f8\u00f9\u00fa\u00fb\u00fc\u00fd\u00fe\u00ff";
    public static final int NO_MAXIMUM = -1;
    private static int maxTextureSize = 1024;
    final FreeType.Library library;
    final FreeType.Face face;
    final String name;
    boolean bitmapped = false;
    private int pixelWidth;
    private int pixelHeight;

    public FreeTypeFontGenerator(FileHandle fileHandle) {
        this(fileHandle, 0);
    }

    public FreeTypeFontGenerator(FileHandle fileHandle, int n2) {
        this.name = fileHandle.nameWithoutExtension();
        this.library = FreeType.initFreeType();
        this.face = this.library.newFace(fileHandle, n2);
        if (this.checkForBitmapFont()) {
            return;
        }
        this.setPixelSizes(0, 15);
    }

    private int getLoadingFlags(FreeTypeFontParameter freeTypeFontParameter) {
        int n2 = FreeType.FT_LOAD_DEFAULT;
        switch (freeTypeFontParameter.hinting) {
            case None: {
                n2 |= FreeType.FT_LOAD_NO_HINTING;
                break;
            }
            case Slight: {
                n2 |= FreeType.FT_LOAD_TARGET_LIGHT;
                break;
            }
            case Medium: {
                n2 |= FreeType.FT_LOAD_TARGET_NORMAL;
                break;
            }
            case Full: {
                n2 |= FreeType.FT_LOAD_TARGET_MONO;
                break;
            }
            case AutoSlight: {
                n2 |= FreeType.FT_LOAD_FORCE_AUTOHINT | FreeType.FT_LOAD_TARGET_LIGHT;
                break;
            }
            case AutoMedium: {
                n2 |= FreeType.FT_LOAD_FORCE_AUTOHINT | FreeType.FT_LOAD_TARGET_NORMAL;
                break;
            }
            case AutoFull: {
                n2 |= FreeType.FT_LOAD_FORCE_AUTOHINT | FreeType.FT_LOAD_TARGET_MONO;
            }
        }
        return n2;
    }

    private boolean loadChar(int n2) {
        return this.loadChar(n2, FreeType.FT_LOAD_DEFAULT | FreeType.FT_LOAD_FORCE_AUTOHINT);
    }

    private boolean loadChar(int n2, int n3) {
        return this.face.loadChar(n2, n3);
    }

    private boolean checkForBitmapFont() {
        FreeType.GlyphSlot glyphSlot;
        int n2 = this.face.getFaceFlags();
        if ((n2 & FreeType.FT_FACE_FLAG_FIXED_SIZES) == FreeType.FT_FACE_FLAG_FIXED_SIZES && (n2 & FreeType.FT_FACE_FLAG_HORIZONTAL) == FreeType.FT_FACE_FLAG_HORIZONTAL && this.loadChar(32) && (glyphSlot = this.face.getGlyph()).getFormat() == 1651078259) {
            this.bitmapped = true;
        }
        return this.bitmapped;
    }

    public BitmapFont generateFont(FreeTypeFontParameter freeTypeFontParameter) {
        return this.generateFont(freeTypeFontParameter, new FreeTypeBitmapFontData());
    }

    public BitmapFont generateFont(FreeTypeFontParameter freeTypeFontParameter, FreeTypeBitmapFontData freeTypeBitmapFontData) {
        boolean bl2;
        boolean bl3 = bl2 = freeTypeBitmapFontData.regions == null && freeTypeFontParameter.packer != null;
        if (bl2) {
            freeTypeBitmapFontData.regions = new Array();
        }
        this.generateData(freeTypeFontParameter, freeTypeBitmapFontData);
        if (bl2) {
            freeTypeFontParameter.packer.updateTextureRegions(freeTypeBitmapFontData.regions, freeTypeFontParameter.minFilter, freeTypeFontParameter.magFilter, freeTypeFontParameter.genMipMaps);
        }
        if (freeTypeBitmapFontData.regions.isEmpty()) {
            throw new GdxRuntimeException("Unable to create a font with no texture regions.");
        }
        BitmapFont bitmapFont = this.newBitmapFont(freeTypeBitmapFontData, freeTypeBitmapFontData.regions, true);
        bitmapFont.setOwnsTexture(freeTypeFontParameter.packer == null);
        return bitmapFont;
    }

    protected BitmapFont newBitmapFont(BitmapFont.BitmapFontData bitmapFontData, Array<TextureRegion> array, boolean bl2) {
        return new BitmapFont(bitmapFontData, array, bl2);
    }

    public int scaleForPixelHeight(int n2) {
        this.setPixelSizes(0, n2);
        FreeType.SizeMetrics sizeMetrics = this.face.getSize().getMetrics();
        int n3 = FreeType.toInt(sizeMetrics.getAscender());
        int n4 = FreeType.toInt(sizeMetrics.getDescender());
        return n2 * n2 / (n3 - n4);
    }

    public int scaleForPixelWidth(int n2, int n3) {
        FreeType.SizeMetrics sizeMetrics = this.face.getSize().getMetrics();
        int n4 = FreeType.toInt(sizeMetrics.getMaxAdvance());
        int n5 = FreeType.toInt(sizeMetrics.getAscender());
        int n6 = FreeType.toInt(sizeMetrics.getDescender());
        int n7 = n5 - n6;
        int n8 = n7 * n2 / (n4 * n3);
        this.setPixelSizes(0, n8);
        return n8;
    }

    public int scaleToFitSquare(int n2, int n3, int n4) {
        return Math.min(this.scaleForPixelHeight(n3), this.scaleForPixelWidth(n2, n4));
    }

    @Null
    public GlyphAndBitmap generateGlyphAndBitmap(int n2, int n3, boolean bl2) {
        this.setPixelSizes(0, n3);
        FreeType.SizeMetrics sizeMetrics = this.face.getSize().getMetrics();
        int n4 = FreeType.toInt(sizeMetrics.getAscender());
        if (this.face.getCharIndex(n2) == 0) {
            return null;
        }
        if (!this.loadChar(n2)) {
            throw new GdxRuntimeException("Unable to load character!");
        }
        FreeType.GlyphSlot glyphSlot = this.face.getGlyph();
        Object object = this.bitmapped ? glyphSlot.getBitmap() : (!glyphSlot.renderGlyph(FreeType.FT_RENDER_MODE_NORMAL) ? null : glyphSlot.getBitmap());
        FreeType.GlyphMetrics glyphMetrics = glyphSlot.getMetrics();
        BitmapFont.Glyph glyph = new BitmapFont.Glyph();
        if (object != null) {
            glyph.width = ((FreeType.Bitmap)object).getWidth();
            glyph.height = ((FreeType.Bitmap)object).getRows();
        } else {
            glyph.width = 0;
            glyph.height = 0;
        }
        glyph.xoffset = glyphSlot.getBitmapLeft();
        glyph.yoffset = bl2 ? -glyphSlot.getBitmapTop() + n4 : -(glyph.height - glyphSlot.getBitmapTop()) - n4;
        glyph.xadvance = FreeType.toInt(glyphMetrics.getHoriAdvance());
        glyph.srcX = 0;
        glyph.srcY = 0;
        glyph.id = n2;
        GlyphAndBitmap glyphAndBitmap = new GlyphAndBitmap();
        glyphAndBitmap.glyph = glyph;
        glyphAndBitmap.bitmap = object;
        return glyphAndBitmap;
    }

    public FreeTypeBitmapFontData generateData(int n2) {
        FreeTypeFontParameter freeTypeFontParameter = new FreeTypeFontParameter();
        freeTypeFontParameter.size = n2;
        return this.generateData(freeTypeFontParameter);
    }

    public FreeTypeBitmapFontData generateData(FreeTypeFontParameter freeTypeFontParameter) {
        return this.generateData(freeTypeFontParameter, new FreeTypeBitmapFontData());
    }

    void setPixelSizes(int n2, int n3) {
        this.pixelWidth = n2;
        this.pixelHeight = n3;
        if (!this.bitmapped && !this.face.setPixelSizes(n2, n3)) {
            throw new GdxRuntimeException("Couldn't set size for font");
        }
    }

    public FreeTypeBitmapFontData generateData(FreeTypeFontParameter freeTypeFontParameter, FreeTypeBitmapFontData freeTypeBitmapFontData) {
        BitmapFont.Glyph glyph;
        int n2;
        int n3;
        int n4;
        int n5;
        freeTypeBitmapFontData.name = this.name + "-" + freeTypeFontParameter.size;
        char[] cArray = freeTypeFontParameter.characters.toCharArray();
        int n6 = cArray.length;
        boolean bl2 = freeTypeFontParameter.incremental;
        int n7 = this.getLoadingFlags(freeTypeFontParameter);
        this.setPixelSizes(0, freeTypeFontParameter.size);
        FreeType.SizeMetrics sizeMetrics = this.face.getSize().getMetrics();
        freeTypeBitmapFontData.flipped = freeTypeFontParameter.flip;
        freeTypeBitmapFontData.ascent = FreeType.toInt(sizeMetrics.getAscender());
        freeTypeBitmapFontData.descent = FreeType.toInt(sizeMetrics.getDescender());
        freeTypeBitmapFontData.lineHeight = FreeType.toInt(sizeMetrics.getHeight());
        float f2 = freeTypeBitmapFontData.ascent;
        if (this.bitmapped && freeTypeBitmapFontData.lineHeight == 0.0f) {
            for (int i2 = 32; i2 < 32 + this.face.getNumGlyphs(); ++i2) {
                if (!this.loadChar(i2, n7)) continue;
                int n8 = FreeType.toInt(this.face.getGlyph().getMetrics().getHeight());
                freeTypeBitmapFontData.lineHeight = (float)n8 > freeTypeBitmapFontData.lineHeight ? (float)n8 : freeTypeBitmapFontData.lineHeight;
            }
        }
        freeTypeBitmapFontData.lineHeight += (float)freeTypeFontParameter.spaceY;
        freeTypeBitmapFontData.spaceXadvance = this.loadChar(32, n7) || this.loadChar(108, n7) ? (float)FreeType.toInt(this.face.getGlyph().getMetrics().getHoriAdvance()) : (float)this.face.getMaxAdvanceWidth();
        for (char c2 : freeTypeBitmapFontData.xChars) {
            if (!this.loadChar(c2, n7)) continue;
            freeTypeBitmapFontData.xHeight = FreeType.toInt(this.face.getGlyph().getMetrics().getHeight());
            break;
        }
        if (freeTypeBitmapFontData.xHeight == 0.0f) {
            throw new GdxRuntimeException("No x-height character found in font");
        }
        for (char c2 : freeTypeBitmapFontData.capChars) {
            if (!this.loadChar(c2, n7)) continue;
            freeTypeBitmapFontData.capHeight = FreeType.toInt(this.face.getGlyph().getMetrics().getHeight()) + Math.abs(freeTypeFontParameter.shadowOffsetY);
            break;
        }
        if (!this.bitmapped && freeTypeBitmapFontData.capHeight == 1.0f) {
            throw new GdxRuntimeException("No cap character found in font");
        }
        freeTypeBitmapFontData.ascent -= freeTypeBitmapFontData.capHeight;
        freeTypeBitmapFontData.down = -freeTypeBitmapFontData.lineHeight;
        if (freeTypeFontParameter.flip) {
            freeTypeBitmapFontData.ascent = -freeTypeBitmapFontData.ascent;
            freeTypeBitmapFontData.down = -freeTypeBitmapFontData.down;
        }
        boolean bl3 = false;
        PixmapPacker pixmapPacker = freeTypeFontParameter.packer;
        if (pixmapPacker == null) {
            PixmapPacker.PackStrategy packStrategy;
            int n9;
            if (bl2) {
                n9 = maxTextureSize;
                packStrategy = new PixmapPacker.GuillotineStrategy();
            } else {
                n5 = (int)Math.ceil(freeTypeBitmapFontData.lineHeight);
                n9 = MathUtils.nextPowerOfTwo((int)Math.sqrt(n5 * n5 * n6));
                if (maxTextureSize > 0) {
                    n9 = Math.min(n9, maxTextureSize);
                }
                packStrategy = new PixmapPacker.SkylineStrategy();
            }
            bl3 = true;
            pixmapPacker = new PixmapPacker(n9, n9, Pixmap.Format.RGBA8888, 1, false, packStrategy);
            pixmapPacker.setTransparentColor(freeTypeFontParameter.color);
            pixmapPacker.getTransparentColor().a = 0.0f;
            if (freeTypeFontParameter.borderWidth > 0.0f) {
                pixmapPacker.setTransparentColor(freeTypeFontParameter.borderColor);
                pixmapPacker.getTransparentColor().a = 0.0f;
            }
        }
        if (bl2) {
            freeTypeBitmapFontData.glyphs = new Array(n6 + 32);
        }
        FreeType.Stroker stroker = null;
        if (freeTypeFontParameter.borderWidth > 0.0f) {
            stroker = this.library.createStroker();
            stroker.set((int)(freeTypeFontParameter.borderWidth * 64.0f), freeTypeFontParameter.borderStraight ? FreeType.FT_STROKER_LINECAP_BUTT : FreeType.FT_STROKER_LINECAP_ROUND, freeTypeFontParameter.borderStraight ? FreeType.FT_STROKER_LINEJOIN_MITER_FIXED : FreeType.FT_STROKER_LINEJOIN_ROUND, 0);
        }
        int[] nArray = new int[n6];
        for (n5 = 0; n5 < n6; ++n5) {
            BitmapFont.Glyph glyph2;
            n4 = cArray[n5];
            nArray[n5] = n3 = this.loadChar(n4, n7) ? FreeType.toInt(this.face.getGlyph().getMetrics().getHeight()) : 0;
            if (n4 != 0 || (glyph2 = this.createGlyph('\u0000', freeTypeBitmapFontData, freeTypeFontParameter, stroker, f2, pixmapPacker)) == null || glyph2.width == 0 || glyph2.height == 0) continue;
            freeTypeBitmapFontData.setGlyph(0, glyph2);
            freeTypeBitmapFontData.missingGlyph = glyph2;
            if (!bl2) continue;
            freeTypeBitmapFontData.glyphs.add(glyph2);
        }
        n5 = nArray.length;
        while (n5 > 0) {
            BitmapFont.Glyph glyph3;
            int n10;
            n4 = 0;
            n3 = nArray[0];
            for (n10 = 1; n10 < n5; ++n10) {
                n2 = nArray[n10];
                if (n2 <= n3) continue;
                n3 = n2;
                n4 = n10;
            }
            n10 = cArray[n4];
            if (freeTypeBitmapFontData.getGlyph((char)n10) == null && (glyph3 = this.createGlyph((char)n10, freeTypeBitmapFontData, freeTypeFontParameter, stroker, f2, pixmapPacker)) != null) {
                freeTypeBitmapFontData.setGlyph(n10, glyph3);
                if (bl2) {
                    freeTypeBitmapFontData.glyphs.add(glyph3);
                }
            }
            nArray[n4] = nArray[--n5];
            n2 = cArray[n4];
            cArray[n4] = cArray[n5];
            cArray[n5] = n2;
        }
        if (stroker != null && !bl2) {
            stroker.dispose();
        }
        if (bl2) {
            freeTypeBitmapFontData.generator = this;
            freeTypeBitmapFontData.parameter = freeTypeFontParameter;
            freeTypeBitmapFontData.stroker = stroker;
            freeTypeBitmapFontData.packer = pixmapPacker;
        }
        freeTypeFontParameter.kerning &= this.face.hasKerning();
        if (freeTypeFontParameter.kerning) {
            for (n4 = 0; n4 < n6; ++n4) {
                n3 = cArray[n4];
                BitmapFont.Glyph glyph4 = freeTypeBitmapFontData.getGlyph((char)n3);
                if (glyph4 == null) continue;
                n2 = this.face.getCharIndex(n3);
                for (int i3 = n4; i3 < n6; ++i3) {
                    char c3 = cArray[i3];
                    BitmapFont.Glyph glyph5 = freeTypeBitmapFontData.getGlyph(c3);
                    if (glyph5 == null) continue;
                    int n11 = this.face.getCharIndex(c3);
                    int n12 = this.face.getKerning(n2, n11, 0);
                    if (n12 != 0) {
                        glyph4.setKerning(c3, FreeType.toInt(n12));
                    }
                    if ((n12 = this.face.getKerning(n11, n2, 0)) == 0) continue;
                    glyph5.setKerning(n3, FreeType.toInt(n12));
                }
            }
        }
        if (bl3) {
            freeTypeBitmapFontData.regions = new Array();
            pixmapPacker.updateTextureRegions(freeTypeBitmapFontData.regions, freeTypeFontParameter.minFilter, freeTypeFontParameter.magFilter, freeTypeFontParameter.genMipMaps);
        }
        if ((glyph = freeTypeBitmapFontData.getGlyph(' ')) == null) {
            glyph = new BitmapFont.Glyph();
            glyph.xadvance = (int)freeTypeBitmapFontData.spaceXadvance + freeTypeFontParameter.spaceX;
            glyph.id = 32;
            freeTypeBitmapFontData.setGlyph(32, glyph);
        }
        if (glyph.width == 0) {
            glyph.width = (int)((float)glyph.xadvance + freeTypeBitmapFontData.padRight);
        }
        return freeTypeBitmapFontData;
    }

    @Null
    protected BitmapFont.Glyph createGlyph(char c2, FreeTypeBitmapFontData freeTypeBitmapFontData, FreeTypeFontParameter freeTypeFontParameter, FreeType.Stroker stroker, float f2, PixmapPacker pixmapPacker) {
        int n2;
        int n3;
        boolean bl2;
        boolean bl3 = bl2 = this.face.getCharIndex(c2) == 0 && c2 != '\u0000';
        if (bl2) {
            return null;
        }
        if (!this.loadChar(c2, this.getLoadingFlags(freeTypeFontParameter))) {
            return null;
        }
        FreeType.GlyphSlot glyphSlot = this.face.getGlyph();
        FreeType.Glyph glyph = glyphSlot.getGlyph();
        try {
            glyph.toBitmap(freeTypeFontParameter.mono ? FreeType.FT_RENDER_MODE_MONO : FreeType.FT_RENDER_MODE_NORMAL);
        }
        catch (GdxRuntimeException gdxRuntimeException) {
            glyph.dispose();
            Gdx.app.log("FreeTypeFontGenerator", "Couldn't render char: " + c2);
            return null;
        }
        FreeType.Bitmap bitmap = glyph.getBitmap();
        Pixmap pixmap = bitmap.getPixmap(Pixmap.Format.RGBA8888, freeTypeFontParameter.color, freeTypeFontParameter.gamma);
        if (bitmap.getWidth() != 0 && bitmap.getRows() != 0) {
            int n4;
            int n5 = 0;
            int n6 = 0;
            if (freeTypeFontParameter.borderWidth > 0.0f) {
                n4 = glyph.getTop();
                n3 = glyph.getLeft();
                FreeType.Glyph glyph2 = glyphSlot.getGlyph();
                glyph2.strokeBorder(stroker, false);
                glyph2.toBitmap(freeTypeFontParameter.mono ? FreeType.FT_RENDER_MODE_MONO : FreeType.FT_RENDER_MODE_NORMAL);
                n5 = n3 - glyph2.getLeft();
                n6 = -(n4 - glyph2.getTop());
                FreeType.Bitmap bitmap2 = glyph2.getBitmap();
                Pixmap pixmap2 = bitmap2.getPixmap(Pixmap.Format.RGBA8888, freeTypeFontParameter.borderColor, freeTypeFontParameter.borderGamma);
                int n7 = freeTypeFontParameter.renderCount;
                for (n2 = 0; n2 < n7; ++n2) {
                    pixmap2.drawPixmap(pixmap, n5, n6);
                }
                pixmap.dispose();
                glyph.dispose();
                pixmap = pixmap2;
                glyph = glyph2;
            }
            if (freeTypeFontParameter.shadowOffsetX != 0 || freeTypeFontParameter.shadowOffsetY != 0) {
                byte by3;
                n4 = pixmap.getWidth();
                n3 = pixmap.getHeight();
                int n8 = Math.max(freeTypeFontParameter.shadowOffsetX, 0);
                int n9 = Math.max(freeTypeFontParameter.shadowOffsetY, 0);
                int n10 = n4 + Math.abs(freeTypeFontParameter.shadowOffsetX);
                n2 = n3 + Math.abs(freeTypeFontParameter.shadowOffsetY);
                Pixmap pixmap3 = new Pixmap(n10, n2, pixmap.getFormat());
                Color color = freeTypeFontParameter.shadowColor;
                float f3 = color.a;
                if (f3 != 0.0f) {
                    by3 = (byte)(color.r * 255.0f);
                    byte by2 = (byte)(color.g * 255.0f);
                    byte by4 = (byte)(color.b * 255.0f);
                    ByteBuffer byteBuffer = pixmap.getPixels();
                    ByteBuffer byteBuffer2 = pixmap3.getPixels();
                    for (int i2 = 0; i2 < n3; ++i2) {
                        int n7 = n10 * (i2 + n9) + n8;
                        for (int i3 = 0; i3 < n4; ++i3) {
                            int n11 = (n4 * i2 + i3) * 4;
                            byte by5 = byteBuffer.get(n11 + 3);
                            if (by5 == 0) continue;
                            int n12 = (n7 + i3) * 4;
                            byteBuffer2.put(n12, by3);
                            byteBuffer2.put(n12 + 1, by2);
                            byteBuffer2.put(n12 + 2, by4);
                            byteBuffer2.put(n12 + 3, (byte)((float)(by5 & 0xFF) * f3));
                        }
                    }
                }
                int n13 = freeTypeFontParameter.renderCount;
                for (by3 = 0; by3 < n13; by3 = (byte)(by3 + 1)) {
                    pixmap3.drawPixmap(pixmap, Math.max(-freeTypeFontParameter.shadowOffsetX, 0), Math.max(-freeTypeFontParameter.shadowOffsetY, 0));
                }
                pixmap.dispose();
                pixmap = pixmap3;
            } else if (freeTypeFontParameter.borderWidth == 0.0f) {
                n3 = freeTypeFontParameter.renderCount - 1;
                for (n4 = 0; n4 < n3; ++n4) {
                    pixmap.drawPixmap(pixmap, 0, 0);
                }
            }
            if (freeTypeFontParameter.padTop > 0 || freeTypeFontParameter.padLeft > 0 || freeTypeFontParameter.padBottom > 0 || freeTypeFontParameter.padRight > 0) {
                Pixmap pixmap4 = new Pixmap(pixmap.getWidth() + freeTypeFontParameter.padLeft + freeTypeFontParameter.padRight, pixmap.getHeight() + freeTypeFontParameter.padTop + freeTypeFontParameter.padBottom, pixmap.getFormat());
                pixmap4.setBlending(Pixmap.Blending.None);
                pixmap4.drawPixmap(pixmap, freeTypeFontParameter.padLeft, freeTypeFontParameter.padTop);
                pixmap.dispose();
                pixmap = pixmap4;
            }
        }
        FreeType.GlyphMetrics glyphMetrics = glyphSlot.getMetrics();
        BitmapFont.Glyph glyph3 = new BitmapFont.Glyph();
        glyph3.id = c2;
        glyph3.width = pixmap.getWidth();
        glyph3.height = pixmap.getHeight();
        glyph3.xoffset = glyph.getLeft();
        glyph3.yoffset = freeTypeFontParameter.flip ? -glyph.getTop() + (int)f2 : -(glyph3.height - glyph.getTop()) - (int)f2;
        glyph3.xadvance = FreeType.toInt(glyphMetrics.getHoriAdvance()) + (int)freeTypeFontParameter.borderWidth + freeTypeFontParameter.spaceX;
        if (this.bitmapped) {
            pixmap.setColor(Color.CLEAR);
            pixmap.fill();
            ByteBuffer byteBuffer = bitmap.getBuffer();
            n3 = Color.WHITE.toIntBits();
            int n14 = Color.CLEAR.toIntBits();
            for (int i4 = 0; i4 < glyph3.height; ++i4) {
                int n15 = i4 * bitmap.getPitch();
                for (n2 = 0; n2 < glyph3.width + glyph3.xoffset; ++n2) {
                    int n16 = byteBuffer.get(n15 + n2 / 8) >>> 7 - n2 % 8 & 1;
                    pixmap.drawPixel(n2, i4, n16 == 1 ? n3 : n14);
                }
            }
        }
        Rectangle rectangle = pixmapPacker.pack(pixmap);
        glyph3.page = pixmapPacker.getPages().size - 1;
        glyph3.srcX = (int)rectangle.x;
        glyph3.srcY = (int)rectangle.y;
        if (freeTypeFontParameter.incremental && freeTypeBitmapFontData.regions != null && freeTypeBitmapFontData.regions.size <= glyph3.page) {
            pixmapPacker.updateTextureRegions(freeTypeBitmapFontData.regions, freeTypeFontParameter.minFilter, freeTypeFontParameter.magFilter, freeTypeFontParameter.genMipMaps);
        }
        pixmap.dispose();
        glyph.dispose();
        return glyph3;
    }

    public boolean hasGlyph(int n2) {
        return this.face.getCharIndex(n2) != 0;
    }

    public String toString() {
        return this.name;
    }

    @Override
    public void dispose() {
        this.face.dispose();
        this.library.dispose();
    }

    public static void setMaxTextureSize(int n2) {
        maxTextureSize = n2;
    }

    public static int getMaxTextureSize() {
        return maxTextureSize;
    }

    public static class FreeTypeFontParameter {
        public int size = 16;
        public boolean mono;
        public Hinting hinting = Hinting.AutoMedium;
        public Color color = Color.WHITE;
        public float gamma = 1.8f;
        public int renderCount = 2;
        public float borderWidth = 0.0f;
        public Color borderColor = Color.BLACK;
        public boolean borderStraight = false;
        public float borderGamma = 1.8f;
        public int shadowOffsetX = 0;
        public int shadowOffsetY = 0;
        public Color shadowColor = new Color(0.0f, 0.0f, 0.0f, 0.75f);
        public int spaceX;
        public int spaceY;
        public int padTop;
        public int padLeft;
        public int padBottom;
        public int padRight;
        public String characters = "\u0000ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890\"!`?'.,;:()[]{}<>|/@\\^$\u20ac-%+=#_&~*\u007f\u0080\u0081\u0082\u0083\u0084\u0085\u0086\u0087\u0088\u0089\u008a\u008b\u008c\u008d\u008e\u008f\u0090\u0091\u0092\u0093\u0094\u0095\u0096\u0097\u0098\u0099\u009a\u009b\u009c\u009d\u009e\u009f\u00a0\u00a1\u00a2\u00a3\u00a4\u00a5\u00a6\u00a7\u00a8\u00a9\u00aa\u00ab\u00ac\u00ad\u00ae\u00af\u00b0\u00b1\u00b2\u00b3\u00b4\u00b5\u00b6\u00b7\u00b8\u00b9\u00ba\u00bb\u00bc\u00bd\u00be\u00bf\u00c0\u00c1\u00c2\u00c3\u00c4\u00c5\u00c6\u00c7\u00c8\u00c9\u00ca\u00cb\u00cc\u00cd\u00ce\u00cf\u00d0\u00d1\u00d2\u00d3\u00d4\u00d5\u00d6\u00d7\u00d8\u00d9\u00da\u00db\u00dc\u00dd\u00de\u00df\u00e0\u00e1\u00e2\u00e3\u00e4\u00e5\u00e6\u00e7\u00e8\u00e9\u00ea\u00eb\u00ec\u00ed\u00ee\u00ef\u00f0\u00f1\u00f2\u00f3\u00f4\u00f5\u00f6\u00f7\u00f8\u00f9\u00fa\u00fb\u00fc\u00fd\u00fe\u00ff";
        public boolean kerning = true;
        public PixmapPacker packer = null;
        public boolean flip = false;
        public boolean genMipMaps = false;
        public Texture.TextureFilter minFilter = Texture.TextureFilter.Nearest;
        public Texture.TextureFilter magFilter = Texture.TextureFilter.Nearest;
        public boolean incremental;
    }

    public static enum Hinting {
        None,
        Slight,
        Medium,
        Full,
        AutoSlight,
        AutoMedium,
        AutoFull;

    }

    public static class FreeTypeBitmapFontData
    extends BitmapFont.BitmapFontData
    implements Disposable {
        public Array<TextureRegion> regions;
        FreeTypeFontGenerator generator;
        FreeTypeFontParameter parameter;
        FreeType.Stroker stroker;
        PixmapPacker packer;
        Array<BitmapFont.Glyph> glyphs;
        private boolean dirty;

        @Override
        public BitmapFont.Glyph getGlyph(char c2) {
            BitmapFont.Glyph glyph = super.getGlyph(c2);
            if (glyph == null && this.generator != null) {
                this.generator.setPixelSizes(0, this.parameter.size);
                float f2 = ((this.flipped ? -this.ascent : this.ascent) + this.capHeight) / this.scaleY;
                glyph = this.generator.createGlyph(c2, this, this.parameter, this.stroker, f2, this.packer);
                if (glyph == null) {
                    return this.missingGlyph;
                }
                this.setGlyphRegion(glyph, this.regions.get(glyph.page));
                this.setGlyph(c2, glyph);
                this.glyphs.add(glyph);
                this.dirty = true;
                FreeType.Face face = this.generator.face;
                if (this.parameter.kerning) {
                    int n2 = face.getCharIndex(c2);
                    int n3 = this.glyphs.size;
                    for (int i2 = 0; i2 < n3; ++i2) {
                        BitmapFont.Glyph glyph2 = this.glyphs.get(i2);
                        int n4 = face.getCharIndex(glyph2.id);
                        int n5 = face.getKerning(n2, n4, 0);
                        if (n5 != 0) {
                            glyph.setKerning(glyph2.id, FreeType.toInt(n5));
                        }
                        if ((n5 = face.getKerning(n4, n2, 0)) == 0) continue;
                        glyph2.setKerning(c2, FreeType.toInt(n5));
                    }
                }
            }
            return glyph;
        }

        @Override
        public void getGlyphs(GlyphLayout.GlyphRun glyphRun, CharSequence charSequence, int n2, int n3, BitmapFont.Glyph glyph) {
            if (this.packer != null) {
                this.packer.setPackToTexture(true);
            }
            super.getGlyphs(glyphRun, charSequence, n2, n3, glyph);
            if (this.dirty) {
                this.dirty = false;
                this.packer.updateTextureRegions(this.regions, this.parameter.minFilter, this.parameter.magFilter, this.parameter.genMipMaps);
            }
        }

        @Override
        public void dispose() {
            if (this.stroker != null) {
                this.stroker.dispose();
            }
            if (this.packer != null) {
                this.packer.dispose();
            }
        }
    }

    public class GlyphAndBitmap {
        public BitmapFont.Glyph glyph;
        @Null
        public FreeType.Bitmap bitmap;
    }
}

