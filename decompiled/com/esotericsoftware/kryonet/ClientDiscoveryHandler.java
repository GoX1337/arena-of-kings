/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.kryonet;

import java.net.DatagramPacket;

public interface ClientDiscoveryHandler {
    default public DatagramPacket onRequestNewDatagramPacket() {
        return new DatagramPacket(new byte[0], 0);
    }

    default public void onDiscoveredHost(DatagramPacket datagramPacket) {
    }

    default public void onFinally() {
    }
}

