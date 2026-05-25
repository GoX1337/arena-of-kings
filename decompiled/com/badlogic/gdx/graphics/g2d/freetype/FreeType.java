/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g2d.freetype;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.utils.BufferUtils;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.LongMap;
import com.badlogic.gdx.utils.SharedLibraryLoader;
import com.badlogic.gdx.utils.StreamUtils;
import java.io.IOException;
import java.io.InputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public class FreeType {
    public static int FT_PIXEL_MODE_NONE = 0;
    public static int FT_PIXEL_MODE_MONO = 1;
    public static int FT_PIXEL_MODE_GRAY = 2;
    public static int FT_PIXEL_MODE_GRAY2 = 3;
    public static int FT_PIXEL_MODE_GRAY4 = 4;
    public static int FT_PIXEL_MODE_LCD = 5;
    public static int FT_PIXEL_MODE_LCD_V = 6;
    public static int FT_ENCODING_NONE = 0;
    public static int FT_ENCODING_MS_SYMBOL = FreeType.encode('s', 'y', 'm', 'b');
    public static int FT_ENCODING_UNICODE = FreeType.encode('u', 'n', 'i', 'c');
    public static int FT_ENCODING_SJIS = FreeType.encode('s', 'j', 'i', 's');
    public static int FT_ENCODING_GB2312 = FreeType.encode('g', 'b', ' ', ' ');
    public static int FT_ENCODING_BIG5 = FreeType.encode('b', 'i', 'g', '5');
    public static int FT_ENCODING_WANSUNG = FreeType.encode('w', 'a', 'n', 's');
    public static int FT_ENCODING_JOHAB = FreeType.encode('j', 'o', 'h', 'a');
    public static int FT_ENCODING_ADOBE_STANDARD = FreeType.encode('A', 'D', 'O', 'B');
    public static int FT_ENCODING_ADOBE_EXPERT = FreeType.encode('A', 'D', 'B', 'E');
    public static int FT_ENCODING_ADOBE_CUSTOM = FreeType.encode('A', 'D', 'B', 'C');
    public static int FT_ENCODING_ADOBE_LATIN_1 = FreeType.encode('l', 'a', 't', '1');
    public static int FT_ENCODING_OLD_LATIN_2 = FreeType.encode('l', 'a', 't', '2');
    public static int FT_ENCODING_APPLE_ROMAN = FreeType.encode('a', 'r', 'm', 'n');
    public static int FT_FACE_FLAG_SCALABLE = 1;
    public static int FT_FACE_FLAG_FIXED_SIZES = 2;
    public static int FT_FACE_FLAG_FIXED_WIDTH = 4;
    public static int FT_FACE_FLAG_SFNT = 8;
    public static int FT_FACE_FLAG_HORIZONTAL = 16;
    public static int FT_FACE_FLAG_VERTICAL = 32;
    public static int FT_FACE_FLAG_KERNING = 64;
    public static int FT_FACE_FLAG_FAST_GLYPHS = 128;
    public static int FT_FACE_FLAG_MULTIPLE_MASTERS = 256;
    public static int FT_FACE_FLAG_GLYPH_NAMES = 512;
    public static int FT_FACE_FLAG_EXTERNAL_STREAM = 1024;
    public static int FT_FACE_FLAG_HINTER = 2048;
    public static int FT_FACE_FLAG_CID_KEYED = 4096;
    public static int FT_FACE_FLAG_TRICKY = 8192;
    public static int FT_STYLE_FLAG_ITALIC = 1;
    public static int FT_STYLE_FLAG_BOLD = 2;
    public static int FT_LOAD_DEFAULT = 0;
    public static int FT_LOAD_NO_SCALE = 1;
    public static int FT_LOAD_NO_HINTING = 2;
    public static int FT_LOAD_RENDER = 4;
    public static int FT_LOAD_NO_BITMAP = 8;
    public static int FT_LOAD_VERTICAL_LAYOUT = 16;
    public static int FT_LOAD_FORCE_AUTOHINT = 32;
    public static int FT_LOAD_CROP_BITMAP = 64;
    public static int FT_LOAD_PEDANTIC = 128;
    public static int FT_LOAD_IGNORE_GLOBAL_ADVANCE_WIDTH = 512;
    public static int FT_LOAD_NO_RECURSE = 1024;
    public static int FT_LOAD_IGNORE_TRANSFORM = 2048;
    public static int FT_LOAD_MONOCHROME = 4096;
    public static int FT_LOAD_LINEAR_DESIGN = 8192;
    public static int FT_LOAD_NO_AUTOHINT = 32768;
    public static int FT_LOAD_TARGET_NORMAL = 0;
    public static int FT_LOAD_TARGET_LIGHT = 65536;
    public static int FT_LOAD_TARGET_MONO = 131072;
    public static int FT_LOAD_TARGET_LCD = 196608;
    public static int FT_LOAD_TARGET_LCD_V = 262144;
    public static int FT_RENDER_MODE_NORMAL = 0;
    public static int FT_RENDER_MODE_LIGHT = 1;
    public static int FT_RENDER_MODE_MONO = 2;
    public static int FT_RENDER_MODE_LCD = 3;
    public static int FT_RENDER_MODE_LCD_V = 4;
    public static int FT_RENDER_MODE_MAX = 5;
    public static int FT_KERNING_DEFAULT = 0;
    public static int FT_KERNING_UNFITTED = 1;
    public static int FT_KERNING_UNSCALED = 2;
    public static int FT_STROKER_LINECAP_BUTT = 0;
    public static int FT_STROKER_LINECAP_ROUND = 1;
    public static int FT_STROKER_LINECAP_SQUARE = 2;
    public static int FT_STROKER_LINEJOIN_ROUND = 0;
    public static int FT_STROKER_LINEJOIN_BEVEL = 1;
    public static int FT_STROKER_LINEJOIN_MITER_VARIABLE;
    public static int FT_STROKER_LINEJOIN_MITER;
    public static int FT_STROKER_LINEJOIN_MITER_FIXED;

    static native int getLastErrorCode();

    private static int encode(char c2, char c3, char c4, char c5) {
        return c2 << 24 | c3 << 16 | c4 << 8 | c5;
    }

    public static Library initFreeType() {
        new SharedLibraryLoader().load("gdx-freetype");
        long l2 = FreeType.initFreeTypeJni();
        if (l2 == 0L) {
            throw new GdxRuntimeException("Couldn't initialize FreeType library, FreeType error code: " + FreeType.getLastErrorCode());
        }
        return new Library(l2);
    }

    private static native long initFreeTypeJni();

    public static int toInt(int n2) {
        return (n2 + 63 & 0xFFFFFFC0) >> 6;
    }

    static {
        FT_STROKER_LINEJOIN_MITER = FT_STROKER_LINEJOIN_MITER_VARIABLE = 2;
        FT_STROKER_LINEJOIN_MITER_FIXED = 3;
    }

    public static class Stroker
    extends Pointer
    implements Disposable {
        Stroker(long l2) {
            super(l2);
        }

        public void set(int n2, int n3, int n4, int n5) {
            Stroker.set(this.address, n2, n3, n4, n5);
        }

        private static native void set(long var0, int var2, int var3, int var4, int var5);

        @Override
        public void dispose() {
            Stroker.done(this.address);
        }

        private static native void done(long var0);
    }

    public static class GlyphMetrics
    extends Pointer {
        GlyphMetrics(long l2) {
            super(l2);
        }

        public int getWidth() {
            return GlyphMetrics.getWidth(this.address);
        }

        private static native int getWidth(long var0);

        public int getHeight() {
            return GlyphMetrics.getHeight(this.address);
        }

        private static native int getHeight(long var0);

        public int getHoriBearingX() {
            return GlyphMetrics.getHoriBearingX(this.address);
        }

        private static native int getHoriBearingX(long var0);

        public int getHoriBearingY() {
            return GlyphMetrics.getHoriBearingY(this.address);
        }

        private static native int getHoriBearingY(long var0);

        public int getHoriAdvance() {
            return GlyphMetrics.getHoriAdvance(this.address);
        }

        private static native int getHoriAdvance(long var0);

        public int getVertBearingX() {
            return GlyphMetrics.getVertBearingX(this.address);
        }

        private static native int getVertBearingX(long var0);

        public int getVertBearingY() {
            return GlyphMetrics.getVertBearingY(this.address);
        }

        private static native int getVertBearingY(long var0);

        public int getVertAdvance() {
            return GlyphMetrics.getVertAdvance(this.address);
        }

        private static native int getVertAdvance(long var0);
    }

    public static class Bitmap
    extends Pointer {
        Bitmap(long l2) {
            super(l2);
        }

        public int getRows() {
            return Bitmap.getRows(this.address);
        }

        private static native int getRows(long var0);

        public int getWidth() {
            return Bitmap.getWidth(this.address);
        }

        private static native int getWidth(long var0);

        public int getPitch() {
            return Bitmap.getPitch(this.address);
        }

        private static native int getPitch(long var0);

        public ByteBuffer getBuffer() {
            if (this.getRows() == 0) {
                return BufferUtils.newByteBuffer(1);
            }
            return Bitmap.getBuffer(this.address);
        }

        private static native ByteBuffer getBuffer(long var0);

        public Pixmap getPixmap(Pixmap.Format format, Color color, float f2) {
            Pixmap pixmap;
            int n2 = this.getWidth();
            int n3 = this.getRows();
            ByteBuffer byteBuffer = this.getBuffer();
            int n4 = this.getPixelMode();
            int n5 = Math.abs(this.getPitch());
            if (color == Color.WHITE && n4 == FT_PIXEL_MODE_GRAY && n5 == n2 && f2 == 1.0f) {
                pixmap = new Pixmap(n2, n3, Pixmap.Format.Alpha);
                BufferUtils.copy(byteBuffer, pixmap.getPixels(), pixmap.getPixels().capacity());
            } else {
                pixmap = new Pixmap(n2, n3, Pixmap.Format.RGBA8888);
                int n6 = Color.rgba8888(color);
                byte[] byArray = new byte[n5];
                int[] nArray = new int[n2];
                IntBuffer intBuffer = pixmap.getPixels().asIntBuffer();
                if (n4 == FT_PIXEL_MODE_MONO) {
                    for (int i2 = 0; i2 < n3; ++i2) {
                        byteBuffer.get(byArray);
                        int n7 = 0;
                        for (int i3 = 0; i3 < n2; i3 += 8) {
                            byte by2 = byArray[n7];
                            int n8 = Math.min(8, n2 - i3);
                            for (int i4 = 0; i4 < n8; ++i4) {
                                nArray[i3 + i4] = (by2 & 1 << 7 - i4) != 0 ? n6 : 0;
                            }
                            ++n7;
                        }
                        intBuffer.put(nArray);
                    }
                } else {
                    int n9 = n6 & 0xFFFFFF00;
                    int n10 = n6 & 0xFF;
                    for (int i5 = 0; i5 < n3; ++i5) {
                        byteBuffer.get(byArray);
                        for (int i6 = 0; i6 < n2; ++i6) {
                            int n11 = byArray[i6] & 0xFF;
                            nArray[i6] = n11 == 0 ? n9 : (n11 == 255 ? n9 | n10 : n9 | (int)((float)n10 * (float)Math.pow((float)n11 / 255.0f, f2)));
                        }
                        intBuffer.put(nArray);
                    }
                }
            }
            Pixmap pixmap2 = pixmap;
            if (format != pixmap.getFormat()) {
                pixmap2 = new Pixmap(pixmap.getWidth(), pixmap.getHeight(), format);
                pixmap2.setBlending(Pixmap.Blending.None);
                pixmap2.drawPixmap(pixmap, 0, 0);
                pixmap2.setBlending(Pixmap.Blending.SourceOver);
                pixmap.dispose();
            }
            return pixmap2;
        }

        public int getNumGray() {
            return Bitmap.getNumGray(this.address);
        }

        private static native int getNumGray(long var0);

        public int getPixelMode() {
            return Bitmap.getPixelMode(this.address);
        }

        private static native int getPixelMode(long var0);
    }

    public static class Glyph
    extends Pointer
    implements Disposable {
        private boolean rendered;

        Glyph(long l2) {
            super(l2);
        }

        @Override
        public void dispose() {
            Glyph.done(this.address);
        }

        private static native void done(long var0);

        public void strokeBorder(Stroker stroker, boolean bl2) {
            this.address = Glyph.strokeBorder(this.address, stroker.address, bl2);
        }

        private static native long strokeBorder(long var0, long var2, boolean var4);

        public void toBitmap(int n2) {
            long l2 = Glyph.toBitmap(this.address, n2);
            if (l2 == 0L) {
                throw new GdxRuntimeException("Couldn't render glyph, FreeType error code: " + FreeType.getLastErrorCode());
            }
            this.address = l2;
            this.rendered = true;
        }

        private static native long toBitmap(long var0, int var2);

        public Bitmap getBitmap() {
            if (!this.rendered) {
                throw new GdxRuntimeException("Glyph is not yet rendered");
            }
            return new Bitmap(Glyph.getBitmap(this.address));
        }

        private static native long getBitmap(long var0);

        public int getLeft() {
            if (!this.rendered) {
                throw new GdxRuntimeException("Glyph is not yet rendered");
            }
            return Glyph.getLeft(this.address);
        }

        private static native int getLeft(long var0);

        public int getTop() {
            if (!this.rendered) {
                throw new GdxRuntimeException("Glyph is not yet rendered");
            }
            return Glyph.getTop(this.address);
        }

        private static native int getTop(long var0);
    }

    public static class GlyphSlot
    extends Pointer {
        GlyphSlot(long l2) {
            super(l2);
        }

        public GlyphMetrics getMetrics() {
            return new GlyphMetrics(GlyphSlot.getMetrics(this.address));
        }

        private static native long getMetrics(long var0);

        public int getLinearHoriAdvance() {
            return GlyphSlot.getLinearHoriAdvance(this.address);
        }

        private static native int getLinearHoriAdvance(long var0);

        public int getLinearVertAdvance() {
            return GlyphSlot.getLinearVertAdvance(this.address);
        }

        private static native int getLinearVertAdvance(long var0);

        public int getAdvanceX() {
            return GlyphSlot.getAdvanceX(this.address);
        }

        private static native int getAdvanceX(long var0);

        public int getAdvanceY() {
            return GlyphSlot.getAdvanceY(this.address);
        }

        private static native int getAdvanceY(long var0);

        public int getFormat() {
            return GlyphSlot.getFormat(this.address);
        }

        private static native int getFormat(long var0);

        public Bitmap getBitmap() {
            return new Bitmap(GlyphSlot.getBitmap(this.address));
        }

        private static native long getBitmap(long var0);

        public int getBitmapLeft() {
            return GlyphSlot.getBitmapLeft(this.address);
        }

        private static native int getBitmapLeft(long var0);

        public int getBitmapTop() {
            return GlyphSlot.getBitmapTop(this.address);
        }

        private static native int getBitmapTop(long var0);

        public boolean renderGlyph(int n2) {
            return GlyphSlot.renderGlyph(this.address, n2);
        }

        private static native boolean renderGlyph(long var0, int var2);

        public Glyph getGlyph() {
            long l2 = GlyphSlot.getGlyph(this.address);
            if (l2 == 0L) {
                throw new GdxRuntimeException("Couldn't get glyph, FreeType error code: " + FreeType.getLastErrorCode());
            }
            return new Glyph(l2);
        }

        private static native long getGlyph(long var0);
    }

    public static class SizeMetrics
    extends Pointer {
        SizeMetrics(long l2) {
            super(l2);
        }

        public int getXppem() {
            return SizeMetrics.getXppem(this.address);
        }

        private static native int getXppem(long var0);

        public int getYppem() {
            return SizeMetrics.getYppem(this.address);
        }

        private static native int getYppem(long var0);

        public int getXScale() {
            return SizeMetrics.getXscale(this.address);
        }

        private static native int getXscale(long var0);

        public int getYscale() {
            return SizeMetrics.getYscale(this.address);
        }

        private static native int getYscale(long var0);

        public int getAscender() {
            return SizeMetrics.getAscender(this.address);
        }

        private static native int getAscender(long var0);

        public int getDescender() {
            return SizeMetrics.getDescender(this.address);
        }

        private static native int getDescender(long var0);

        public int getHeight() {
            return SizeMetrics.getHeight(this.address);
        }

        private static native int getHeight(long var0);

        public int getMaxAdvance() {
            return SizeMetrics.getMaxAdvance(this.address);
        }

        private static native int getMaxAdvance(long var0);
    }

    public static class Size
    extends Pointer {
        Size(long l2) {
            super(l2);
        }

        public SizeMetrics getMetrics() {
            return new SizeMetrics(Size.getMetrics(this.address));
        }

        private static native long getMetrics(long var0);
    }

    public static class Face
    extends Pointer
    implements Disposable {
        Library library;

        public Face(long l2, Library library) {
            super(l2);
            this.library = library;
        }

        @Override
        public void dispose() {
            Face.doneFace(this.address);
            ByteBuffer byteBuffer = this.library.fontData.get(this.address);
            if (byteBuffer != null) {
                this.library.fontData.remove(this.address);
                if (BufferUtils.isUnsafeByteBuffer(byteBuffer)) {
                    BufferUtils.disposeUnsafeByteBuffer(byteBuffer);
                }
            }
        }

        private static native void doneFace(long var0);

        public int getFaceFlags() {
            return Face.getFaceFlags(this.address);
        }

        private static native int getFaceFlags(long var0);

        public int getStyleFlags() {
            return Face.getStyleFlags(this.address);
        }

        private static native int getStyleFlags(long var0);

        public int getNumGlyphs() {
            return Face.getNumGlyphs(this.address);
        }

        private static native int getNumGlyphs(long var0);

        public int getAscender() {
            return Face.getAscender(this.address);
        }

        private static native int getAscender(long var0);

        public int getDescender() {
            return Face.getDescender(this.address);
        }

        private static native int getDescender(long var0);

        public int getHeight() {
            return Face.getHeight(this.address);
        }

        private static native int getHeight(long var0);

        public int getMaxAdvanceWidth() {
            return Face.getMaxAdvanceWidth(this.address);
        }

        private static native int getMaxAdvanceWidth(long var0);

        public int getMaxAdvanceHeight() {
            return Face.getMaxAdvanceHeight(this.address);
        }

        private static native int getMaxAdvanceHeight(long var0);

        public int getUnderlinePosition() {
            return Face.getUnderlinePosition(this.address);
        }

        private static native int getUnderlinePosition(long var0);

        public int getUnderlineThickness() {
            return Face.getUnderlineThickness(this.address);
        }

        private static native int getUnderlineThickness(long var0);

        public boolean selectSize(int n2) {
            return Face.selectSize(this.address, n2);
        }

        private static native boolean selectSize(long var0, int var2);

        public boolean setCharSize(int n2, int n3, int n4, int n5) {
            return Face.setCharSize(this.address, n2, n3, n4, n5);
        }

        private static native boolean setCharSize(long var0, int var2, int var3, int var4, int var5);

        public boolean setPixelSizes(int n2, int n3) {
            return Face.setPixelSizes(this.address, n2, n3);
        }

        private static native boolean setPixelSizes(long var0, int var2, int var3);

        public boolean loadGlyph(int n2, int n3) {
            return Face.loadGlyph(this.address, n2, n3);
        }

        private static native boolean loadGlyph(long var0, int var2, int var3);

        public boolean loadChar(int n2, int n3) {
            return Face.loadChar(this.address, n2, n3);
        }

        private static native boolean loadChar(long var0, int var2, int var3);

        public GlyphSlot getGlyph() {
            return new GlyphSlot(Face.getGlyph(this.address));
        }

        private static native long getGlyph(long var0);

        public Size getSize() {
            return new Size(Face.getSize(this.address));
        }

        private static native long getSize(long var0);

        public boolean hasKerning() {
            return Face.hasKerning(this.address);
        }

        private static native boolean hasKerning(long var0);

        public int getKerning(int n2, int n3, int n4) {
            return Face.getKerning(this.address, n2, n3, n4);
        }

        private static native int getKerning(long var0, int var2, int var3, int var4);

        public int getCharIndex(int n2) {
            return Face.getCharIndex(this.address, n2);
        }

        private static native int getCharIndex(long var0, int var2);
    }

    public static class Library
    extends Pointer
    implements Disposable {
        LongMap<ByteBuffer> fontData = new LongMap();

        Library(long l2) {
            super(l2);
        }

        @Override
        public void dispose() {
            Library.doneFreeType(this.address);
            for (ByteBuffer byteBuffer : this.fontData.values()) {
                if (!BufferUtils.isUnsafeByteBuffer(byteBuffer)) continue;
                BufferUtils.disposeUnsafeByteBuffer(byteBuffer);
            }
        }

        private static native void doneFreeType(long var0);

        public Face newFace(FileHandle fileHandle, int n2) {
            ByteBuffer byteBuffer = null;
            try {
                byteBuffer = fileHandle.map();
            }
            catch (GdxRuntimeException gdxRuntimeException) {
                // empty catch block
            }
            if (byteBuffer == null) {
                InputStream inputStream = fileHandle.read();
                try {
                    int n3 = (int)fileHandle.length();
                    if (n3 == 0) {
                        byte[] byArray = StreamUtils.copyStreamToByteArray(inputStream, 16384);
                        byteBuffer = BufferUtils.newUnsafeByteBuffer(byArray.length);
                        BufferUtils.copy(byArray, 0, (Buffer)byteBuffer, byArray.length);
                    } else {
                        byteBuffer = BufferUtils.newUnsafeByteBuffer(n3);
                        StreamUtils.copyStream(inputStream, byteBuffer);
                    }
                }
                catch (IOException iOException) {
                    throw new GdxRuntimeException(iOException);
                }
                finally {
                    StreamUtils.closeQuietly(inputStream);
                }
            }
            return this.newMemoryFace(byteBuffer, n2);
        }

        public Face newMemoryFace(byte[] byArray, int n2, int n3) {
            ByteBuffer byteBuffer = BufferUtils.newUnsafeByteBuffer(byArray.length);
            BufferUtils.copy(byArray, 0, (Buffer)byteBuffer, byArray.length);
            return this.newMemoryFace(byteBuffer, n3);
        }

        public Face newMemoryFace(ByteBuffer byteBuffer, int n2) {
            long l2 = Library.newMemoryFace(this.address, byteBuffer, byteBuffer.remaining(), n2);
            if (l2 == 0L) {
                if (BufferUtils.isUnsafeByteBuffer(byteBuffer)) {
                    BufferUtils.disposeUnsafeByteBuffer(byteBuffer);
                }
                throw new GdxRuntimeException("Couldn't load font, FreeType error code: " + FreeType.getLastErrorCode());
            }
            this.fontData.put(l2, byteBuffer);
            return new Face(l2, this);
        }

        private static native long newMemoryFace(long var0, ByteBuffer var2, int var3, int var4);

        public Stroker createStroker() {
            long l2 = Library.strokerNew(this.address);
            if (l2 == 0L) {
                throw new GdxRuntimeException("Couldn't create FreeType stroker, FreeType error code: " + FreeType.getLastErrorCode());
            }
            return new Stroker(l2);
        }

        private static native long strokerNew(long var0);
    }

    static class Pointer {
        long address;

        Pointer(long l2) {
            this.address = l2;
        }
    }
}

