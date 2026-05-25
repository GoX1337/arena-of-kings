/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g2d;

import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class Gdx2DPixmap
implements Disposable {
    public static final int GDX2D_FORMAT_ALPHA = 1;
    public static final int GDX2D_FORMAT_LUMINANCE_ALPHA = 2;
    public static final int GDX2D_FORMAT_RGB888 = 3;
    public static final int GDX2D_FORMAT_RGBA8888 = 4;
    public static final int GDX2D_FORMAT_RGB565 = 5;
    public static final int GDX2D_FORMAT_RGBA4444 = 6;
    public static final int GDX2D_SCALE_NEAREST = 0;
    public static final int GDX2D_SCALE_LINEAR = 1;
    public static final int GDX2D_BLEND_NONE = 0;
    public static final int GDX2D_BLEND_SRC_OVER = 1;
    long basePtr;
    int width;
    int height;
    int format;
    ByteBuffer pixelPtr;
    long[] nativeData = new long[4];

    public static int toGlFormat(int n2) {
        switch (n2) {
            case 1: {
                return 6406;
            }
            case 2: {
                return 6410;
            }
            case 3: 
            case 5: {
                return 6407;
            }
            case 4: 
            case 6: {
                return 6408;
            }
        }
        throw new GdxRuntimeException("unknown format: " + n2);
    }

    public static int toGlType(int n2) {
        switch (n2) {
            case 1: 
            case 2: 
            case 3: 
            case 4: {
                return 5121;
            }
            case 5: {
                return 33635;
            }
            case 6: {
                return 32819;
            }
        }
        throw new GdxRuntimeException("unknown format: " + n2);
    }

    public Gdx2DPixmap(byte[] byArray, int n2, int n3, int n4) {
        this.pixelPtr = Gdx2DPixmap.load(this.nativeData, byArray, n2, n3);
        if (this.pixelPtr == null) {
            throw new IOException("Error loading pixmap: " + Gdx2DPixmap.getFailureReason());
        }
        this.basePtr = this.nativeData[0];
        this.width = (int)this.nativeData[1];
        this.height = (int)this.nativeData[2];
        this.format = (int)this.nativeData[3];
        if (n4 != 0 && n4 != this.format) {
            this.convert(n4);
        }
    }

    public Gdx2DPixmap(ByteBuffer byteBuffer, int n2, int n3, int n4) {
        this.pixelPtr = Gdx2DPixmap.loadByteBuffer(this.nativeData, byteBuffer, n2, n3);
        if (this.pixelPtr == null) {
            throw new IOException("Error loading pixmap: " + Gdx2DPixmap.getFailureReason());
        }
        this.basePtr = this.nativeData[0];
        this.width = (int)this.nativeData[1];
        this.height = (int)this.nativeData[2];
        this.format = (int)this.nativeData[3];
        if (n4 != 0 && n4 != this.format) {
            this.convert(n4);
        }
    }

    public Gdx2DPixmap(InputStream inputStream, int n2) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
        byte[] byArray = new byte[1024];
        int n3 = 0;
        while ((n3 = inputStream.read(byArray)) != -1) {
            byteArrayOutputStream.write(byArray, 0, n3);
        }
        byArray = byteArrayOutputStream.toByteArray();
        this.pixelPtr = Gdx2DPixmap.load(this.nativeData, byArray, 0, byArray.length);
        if (this.pixelPtr == null) {
            throw new IOException("Error loading pixmap: " + Gdx2DPixmap.getFailureReason());
        }
        this.basePtr = this.nativeData[0];
        this.width = (int)this.nativeData[1];
        this.height = (int)this.nativeData[2];
        this.format = (int)this.nativeData[3];
        if (n2 != 0 && n2 != this.format) {
            this.convert(n2);
        }
    }

    public Gdx2DPixmap(int n2, int n3, int n4) {
        this.pixelPtr = Gdx2DPixmap.newPixmap(this.nativeData, n2, n3, n4);
        if (this.pixelPtr == null) {
            throw new GdxRuntimeException("Unable to allocate memory for pixmap: " + n2 + "x" + n3 + ", " + Gdx2DPixmap.getFormatString(n4));
        }
        this.basePtr = this.nativeData[0];
        this.width = (int)this.nativeData[1];
        this.height = (int)this.nativeData[2];
        this.format = (int)this.nativeData[3];
    }

    public Gdx2DPixmap(ByteBuffer byteBuffer, long[] lArray) {
        this.pixelPtr = byteBuffer;
        this.basePtr = lArray[0];
        this.width = (int)lArray[1];
        this.height = (int)lArray[2];
        this.format = (int)lArray[3];
    }

    private void convert(int n2) {
        Gdx2DPixmap gdx2DPixmap = new Gdx2DPixmap(this.width, this.height, n2);
        gdx2DPixmap.setBlend(0);
        gdx2DPixmap.drawPixmap(this, 0, 0, 0, 0, this.width, this.height);
        this.dispose();
        this.basePtr = gdx2DPixmap.basePtr;
        this.format = gdx2DPixmap.format;
        this.height = gdx2DPixmap.height;
        this.nativeData = gdx2DPixmap.nativeData;
        this.pixelPtr = gdx2DPixmap.pixelPtr;
        this.width = gdx2DPixmap.width;
    }

    @Override
    public void dispose() {
        Gdx2DPixmap.free(this.basePtr);
    }

    public void clear(int n2) {
        Gdx2DPixmap.clear(this.basePtr, n2);
    }

    public void setPixel(int n2, int n3, int n4) {
        Gdx2DPixmap.setPixel(this.basePtr, n2, n3, n4);
    }

    public int getPixel(int n2, int n3) {
        return Gdx2DPixmap.getPixel(this.basePtr, n2, n3);
    }

    public void drawLine(int n2, int n3, int n4, int n5, int n6) {
        Gdx2DPixmap.drawLine(this.basePtr, n2, n3, n4, n5, n6);
    }

    public void drawRect(int n2, int n3, int n4, int n5, int n6) {
        Gdx2DPixmap.drawRect(this.basePtr, n2, n3, n4, n5, n6);
    }

    public void drawCircle(int n2, int n3, int n4, int n5) {
        Gdx2DPixmap.drawCircle(this.basePtr, n2, n3, n4, n5);
    }

    public void fillRect(int n2, int n3, int n4, int n5, int n6) {
        Gdx2DPixmap.fillRect(this.basePtr, n2, n3, n4, n5, n6);
    }

    public void fillCircle(int n2, int n3, int n4, int n5) {
        Gdx2DPixmap.fillCircle(this.basePtr, n2, n3, n4, n5);
    }

    public void fillTriangle(int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        Gdx2DPixmap.fillTriangle(this.basePtr, n2, n3, n4, n5, n6, n7, n8);
    }

    public void drawPixmap(Gdx2DPixmap gdx2DPixmap, int n2, int n3, int n4, int n5, int n6, int n7) {
        Gdx2DPixmap.drawPixmap(gdx2DPixmap.basePtr, this.basePtr, n2, n3, n6, n7, n4, n5, n6, n7);
    }

    public void drawPixmap(Gdx2DPixmap gdx2DPixmap, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9) {
        Gdx2DPixmap.drawPixmap(gdx2DPixmap.basePtr, this.basePtr, n2, n3, n4, n5, n6, n7, n8, n9);
    }

    public void setBlend(int n2) {
        Gdx2DPixmap.setBlend(this.basePtr, n2);
    }

    public void setScale(int n2) {
        Gdx2DPixmap.setScale(this.basePtr, n2);
    }

    public static Gdx2DPixmap newPixmap(InputStream inputStream, int n2) {
        try {
            return new Gdx2DPixmap(inputStream, n2);
        }
        catch (IOException iOException) {
            return null;
        }
    }

    public static Gdx2DPixmap newPixmap(int n2, int n3, int n4) {
        try {
            return new Gdx2DPixmap(n2, n3, n4);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            return null;
        }
    }

    public ByteBuffer getPixels() {
        return this.pixelPtr;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public int getFormat() {
        return this.format;
    }

    public int getGLInternalFormat() {
        return Gdx2DPixmap.toGlFormat(this.format);
    }

    public int getGLFormat() {
        return this.getGLInternalFormat();
    }

    public int getGLType() {
        return Gdx2DPixmap.toGlType(this.format);
    }

    public String getFormatString() {
        return Gdx2DPixmap.getFormatString(this.format);
    }

    private static String getFormatString(int n2) {
        switch (n2) {
            case 1: {
                return "alpha";
            }
            case 2: {
                return "luminance alpha";
            }
            case 3: {
                return "rgb888";
            }
            case 4: {
                return "rgba8888";
            }
            case 5: {
                return "rgb565";
            }
            case 6: {
                return "rgba4444";
            }
        }
        return "unknown";
    }

    private static native ByteBuffer load(long[] var0, byte[] var1, int var2, int var3);

    private static native ByteBuffer loadByteBuffer(long[] var0, ByteBuffer var1, int var2, int var3);

    private static native ByteBuffer newPixmap(long[] var0, int var1, int var2, int var3);

    private static native void free(long var0);

    private static native void clear(long var0, int var2);

    private static native void setPixel(long var0, int var2, int var3, int var4);

    private static native int getPixel(long var0, int var2, int var3);

    private static native void drawLine(long var0, int var2, int var3, int var4, int var5, int var6);

    private static native void drawRect(long var0, int var2, int var3, int var4, int var5, int var6);

    private static native void drawCircle(long var0, int var2, int var3, int var4, int var5);

    private static native void fillRect(long var0, int var2, int var3, int var4, int var5, int var6);

    private static native void fillCircle(long var0, int var2, int var3, int var4, int var5);

    private static native void fillTriangle(long var0, int var2, int var3, int var4, int var5, int var6, int var7, int var8);

    private static native void drawPixmap(long var0, long var2, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11);

    private static native void setBlend(long var0, int var2);

    private static native void setScale(long var0, int var2);

    public static native String getFailureReason();
}

