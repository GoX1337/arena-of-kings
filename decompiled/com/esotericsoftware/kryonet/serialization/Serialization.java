/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.kryonet.serialization;

import com.esotericsoftware.kryonet.Connection;
import java.nio.ByteBuffer;

public interface Serialization {
    public void write(Connection var1, ByteBuffer var2, Object var3);

    public Object read(Connection var1, ByteBuffer var2);

    public int getLengthLength();

    public void writeLength(ByteBuffer var1, int var2);

    public int readLength(ByteBuffer var1);
}

