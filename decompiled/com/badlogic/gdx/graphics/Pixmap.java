/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Gdx2DPixmap;
import com.badlogic.gdx.utils.BufferUtils;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.io.IOException;
import java.nio.ByteBuffer;

public class Pixmap
implements Disposable {
    private Blending blending = Blending.SourceOver;
    private Filter filter = Filter.BiLinear;
    final Gdx2DPixmap pixmap;
    int color = 0;
    private boolean disposed;

    public static Pixmap createFromFrameBuffer(int n2, int n3, int n4, int n5) {
        Gdx.gl.glPixelStorei(3333, 1);
        Pixmap pixmap = new Pixmap(n4, n5, Format.RGBA8888);
        ByteBuffer byteBuffer = pixmap.getPixels();
        Gdx.gl.glReadPixels(n2, n3, n4, n5, 6408, 5121, byteBuffer);
        return pixmap;
    }

    public void setBlending(Blending blending) {
        this.blending = blending;
        this.pixmap.setBlend(blending == Blending.None ? 0 : 1);
    }

    public void setFilter(Filter filter) {
        this.filter = filter;
        this.pixmap.setScale(filter == Filter.NearestNeighbour ? 0 : 1);
    }

    public Pixmap(int n2, int n3, Format format) {
        this.pixmap = new Gdx2DPixmap(n2, n3, Format.toGdx2DPixmapFormat(format));
        this.setColor(0.0f, 0.0f, 0.0f, 0.0f);
        this.fill();
    }

    public Pixmap(byte[] byArray, int n2, int n3) {
        try {
            this.pixmap = new Gdx2DPixmap(byArray, n2, n3, 0);
        }
        catch (IOException iOException) {
            throw new GdxRuntimeException("Couldn't load pixmap from image data", iOException);
        }
    }

    public Pixmap(ByteBuffer byteBuffer, int n2, int n3) {
        if (!byteBuffer.isDirect()) {
            throw new GdxRuntimeException("Couldn't load pixmap from non-direct ByteBuffer");
        }
        try {
            this.pixmap = new Gdx2DPixmap(byteBuffer, n2, n3, 0);
        }
        catch (IOException iOException) {
            throw new GdxRuntimeException("Couldn't load pixmap from image data", iOException);
        }
    }

    public Pixmap(ByteBuffer byteBuffer) {
        this(byteBuffer, byteBuffer.position(), byteBuffer.remaining());
    }

    public Pixmap(FileHandle fileHandle) {
        try {
            byte[] byArray = fileHandle.readBytes();
            this.pixmap = new Gdx2DPixmap(byArray, 0, byArray.length, 0);
        }
        catch (Exception exception) {
            throw new GdxRuntimeException("Couldn't load file: " + fileHandle, exception);
        }
    }

    public Pixmap(Gdx2DPixmap gdx2DPixmap) {
        this.pixmap = gdx2DPixmap;
    }

    public static void downloadFromUrl(String string, final DownloadPixmapResponseListener downloadPixmapResponseListener) {
        Net.HttpRequest httpRequest = new Net.HttpRequest("GET");
        httpRequest.setUrl(string);
        Gdx.net.sendHttpRequest(httpRequest, new Net.HttpResponseListener(){

            @Override
            public void handleHttpResponse(Net.HttpResponse httpResponse) {
                final byte[] byArray = httpResponse.getResult();
                Gdx.app.postRunnable(new Runnable(){

                    @Override
                    public void run() {
                        try {
                            Pixmap pixmap = new Pixmap(byArray, 0, byArray.length);
                            downloadPixmapResponseListener.downloadComplete(pixmap);
                        }
                        catch (Throwable throwable) {
                            this.failed(throwable);
                        }
                    }
                });
            }

            @Override
            public void failed(Throwable throwable) {
                downloadPixmapResponseListener.downloadFailed(throwable);
            }

            @Override
            public void cancelled() {
            }
        });
    }

    public void setColor(int n2) {
        this.color = n2;
    }

    public void setColor(float f2, float f3, float f4, float f5) {
        this.color = Color.rgba8888(f2, f3, f4, f5);
    }

    public void setColor(Color color) {
        this.color = Color.rgba8888(color.r, color.g, color.b, color.a);
    }

    public void fill() {
        this.pixmap.clear(this.color);
    }

    public void drawLine(int n2, int n3, int n4, int n5) {
        this.pixmap.drawLine(n2, n3, n4, n5, this.color);
    }

    public void drawRectangle(int n2, int n3, int n4, int n5) {
        this.pixmap.drawRect(n2, n3, n4, n5, this.color);
    }

    public void drawPixmap(Pixmap pixmap, int n2, int n3) {
        this.drawPixmap(pixmap, n2, n3, 0, 0, pixmap.getWidth(), pixmap.getHeight());
    }

    public void drawPixmap(Pixmap pixmap, int n2, int n3, int n4, int n5, int n6, int n7) {
        this.pixmap.drawPixmap(pixmap.pixmap, n4, n5, n2, n3, n6, n7);
    }

    public void drawPixmap(Pixmap pixmap, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9) {
        this.pixmap.drawPixmap(pixmap.pixmap, n2, n3, n4, n5, n6, n7, n8, n9);
    }

    public void fillRectangle(int n2, int n3, int n4, int n5) {
        this.pixmap.fillRect(n2, n3, n4, n5, this.color);
    }

    public void drawCircle(int n2, int n3, int n4) {
        this.pixmap.drawCircle(n2, n3, n4, this.color);
    }

    public void fillCircle(int n2, int n3, int n4) {
        this.pixmap.fillCircle(n2, n3, n4, this.color);
    }

    public void fillTriangle(int n2, int n3, int n4, int n5, int n6, int n7) {
        this.pixmap.fillTriangle(n2, n3, n4, n5, n6, n7, this.color);
    }

    public int getPixel(int n2, int n3) {
        return this.pixmap.getPixel(n2, n3);
    }

    public int getWidth() {
        return this.pixmap.getWidth();
    }

    public int getHeight() {
        return this.pixmap.getHeight();
    }

    @Override
    public void dispose() {
        if (this.disposed) {
            throw new GdxRuntimeException("Pixmap already disposed!");
        }
        this.pixmap.dispose();
        this.disposed = true;
    }

    public boolean isDisposed() {
        return this.disposed;
    }

    public void drawPixel(int n2, int n3) {
        this.pixmap.setPixel(n2, n3, this.color);
    }

    public void drawPixel(int n2, int n3, int n4) {
        this.pixmap.setPixel(n2, n3, n4);
    }

    public int getGLFormat() {
        return this.pixmap.getGLFormat();
    }

    public int getGLInternalFormat() {
        return this.pixmap.getGLInternalFormat();
    }

    public int getGLType() {
        return this.pixmap.getGLType();
    }

    public ByteBuffer getPixels() {
        if (this.disposed) {
            throw new GdxRuntimeException("Pixmap already disposed");
        }
        return this.pixmap.getPixels();
    }

    public void setPixels(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = this.pixmap.getPixels();
        BufferUtils.copy(byteBuffer, byteBuffer2, byteBuffer2.limit());
    }

    public Format getFormat() {
        return Format.fromGdx2DPixmapFormat(this.pixmap.getFormat());
    }

    public Blending getBlending() {
        return this.blending;
    }

    public Filter getFilter() {
        return this.filter;
    }

    public static interface DownloadPixmapResponseListener {
        public void downloadComplete(Pixmap var1);

        public void downloadFailed(Throwable var1);
    }

    public static enum Filter {
        NearestNeighbour,
        BiLinear;

    }

    public static enum Blending {
        None,
        SourceOver;

    }

    public static enum Format {
        Alpha,
        Intensity,
        LuminanceAlpha,
        RGB565,
        RGBA4444,
        RGB888,
        RGBA8888;


        public static int toGdx2DPixmapFormat(Format format) {
            if (format == Alpha) {
                return 1;
            }
            if (format == Intensity) {
                return 1;
            }
            if (format == LuminanceAlpha) {
                return 2;
            }
            if (format == RGB565) {
                return 5;
            }
            if (format == RGBA4444) {
                return 6;
            }
            if (format == RGB888) {
                return 3;
            }
            if (format == RGBA8888) {
                return 4;
            }
            throw new GdxRuntimeException("Unknown Format: " + (Object)((Object)format));
        }

        public static Format fromGdx2DPixmapFormat(int n2) {
            if (n2 == 1) {
                return Alpha;
            }
            if (n2 == 2) {
                return LuminanceAlpha;
            }
            if (n2 == 5) {
                return RGB565;
            }
            if (n2 == 6) {
                return RGBA4444;
            }
            if (n2 == 3) {
                return RGB888;
            }
            if (n2 == 4) {
                return RGBA8888;
            }
            throw new GdxRuntimeException("Unknown Gdx2DPixmap Format: " + n2);
        }

        public static int toGlFormat(Format format) {
            return Gdx2DPixmap.toGlFormat(Format.toGdx2DPixmapFormat(format));
        }

        public static int toGlType(Format format) {
            return Gdx2DPixmap.toGlType(Format.toGdx2DPixmapFormat(format));
        }
    }
}

