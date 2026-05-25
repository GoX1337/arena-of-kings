/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils;

import com.badlogic.gdx.utils.BufferUtils;
import com.badlogic.gdx.utils.Null;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringWriter;
import java.nio.Buffer;
import java.nio.ByteBuffer;

public final class StreamUtils {
    public static final int DEFAULT_BUFFER_SIZE = 4096;
    public static final byte[] EMPTY_BYTES = new byte[0];

    public static void copyStream(InputStream inputStream, OutputStream outputStream) {
        StreamUtils.copyStream(inputStream, outputStream, new byte[4096]);
    }

    public static void copyStream(InputStream inputStream, OutputStream outputStream, int n2) {
        StreamUtils.copyStream(inputStream, outputStream, new byte[n2]);
    }

    public static void copyStream(InputStream inputStream, OutputStream outputStream, byte[] byArray) {
        int n2;
        while ((n2 = inputStream.read(byArray)) != -1) {
            outputStream.write(byArray, 0, n2);
        }
    }

    public static void copyStream(InputStream inputStream, ByteBuffer byteBuffer) {
        StreamUtils.copyStream(inputStream, byteBuffer, new byte[4096]);
    }

    public static void copyStream(InputStream inputStream, ByteBuffer byteBuffer, int n2) {
        StreamUtils.copyStream(inputStream, byteBuffer, new byte[n2]);
    }

    public static int copyStream(InputStream inputStream, ByteBuffer byteBuffer, byte[] byArray) {
        int n2;
        int n3 = byteBuffer.position();
        int n4 = 0;
        while ((n2 = inputStream.read(byArray)) != -1) {
            BufferUtils.copy(byArray, 0, (Buffer)byteBuffer, n2);
            ((Buffer)byteBuffer).position(n3 + (n4 += n2));
        }
        ((Buffer)byteBuffer).position(n3);
        return n4;
    }

    public static byte[] copyStreamToByteArray(InputStream inputStream) {
        return StreamUtils.copyStreamToByteArray(inputStream, inputStream.available());
    }

    public static byte[] copyStreamToByteArray(InputStream inputStream, int n2) {
        OptimizedByteArrayOutputStream optimizedByteArrayOutputStream = new OptimizedByteArrayOutputStream(Math.max(0, n2));
        StreamUtils.copyStream(inputStream, optimizedByteArrayOutputStream);
        return ((ByteArrayOutputStream)optimizedByteArrayOutputStream).toByteArray();
    }

    public static String copyStreamToString(InputStream inputStream) {
        return StreamUtils.copyStreamToString(inputStream, inputStream.available(), null);
    }

    public static String copyStreamToString(InputStream inputStream, int n2) {
        return StreamUtils.copyStreamToString(inputStream, n2, null);
    }

    public static String copyStreamToString(InputStream inputStream, int n2, @Null String string) {
        int n3;
        InputStreamReader inputStreamReader = string == null ? new InputStreamReader(inputStream) : new InputStreamReader(inputStream, string);
        StringWriter stringWriter = new StringWriter(Math.max(0, n2));
        char[] cArray = new char[4096];
        while ((n3 = inputStreamReader.read(cArray)) != -1) {
            stringWriter.write(cArray, 0, n3);
        }
        return stringWriter.toString();
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
    }

    public static class OptimizedByteArrayOutputStream
    extends ByteArrayOutputStream {
        public OptimizedByteArrayOutputStream(int n2) {
            super(n2);
        }

        @Override
        public synchronized byte[] toByteArray() {
            if (this.count == this.buf.length) {
                return this.buf;
            }
            return super.toByteArray();
        }

        public byte[] getBuffer() {
            return this.buf;
        }
    }
}

