/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.kryonet;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public interface ServerDiscoveryHandler {
    public static final ByteBuffer emptyBuffer = ByteBuffer.allocate(0);

    default public boolean onDiscoverHost(DatagramChannel datagramChannel, InetSocketAddress inetSocketAddress) {
        datagramChannel.send(emptyBuffer, inetSocketAddress);
        return true;
    }
}

