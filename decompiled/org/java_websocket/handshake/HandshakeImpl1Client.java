/*
 * Decompiled with CFR 0.152.
 */
package org.java_websocket.handshake;

import org.java_websocket.handshake.ClientHandshakeBuilder;
import org.java_websocket.handshake.HandshakedataImpl1;

public class HandshakeImpl1Client
extends HandshakedataImpl1
implements ClientHandshakeBuilder {
    private String resourceDescriptor = "*";

    @Override
    public void setResourceDescriptor(String string) {
        if (string == null) {
            throw new IllegalArgumentException("http resource descriptor must not be null");
        }
        this.resourceDescriptor = string;
    }

    @Override
    public String getResourceDescriptor() {
        return this.resourceDescriptor;
    }
}

