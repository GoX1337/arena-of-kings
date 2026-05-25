/*
 * Decompiled with CFR 0.152.
 */
package org.java_websocket.util;

import java.nio.ByteBuffer;

public class ByteBufferUtils {
    private ByteBufferUtils() {
    }

    public static int transferByteBuffer(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        int n2;
        if (byteBuffer == null || byteBuffer2 == null) {
            throw new IllegalArgumentException();
        }
        int n3 = byteBuffer.remaining();
        if (n3 > (n2 = byteBuffer2.remaining())) {
            int n4 = Math.min(n3, n2);
            byteBuffer.limit(n4);
            byteBuffer2.put(byteBuffer);
            return n4;
        }
        byteBuffer2.put(byteBuffer);
        return n3;
    }

    public static ByteBuffer getEmptyByteBuffer() {
        return ByteBuffer.allocate(0);
    }
}

