/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.kryonet.rmi;

import com.esotericsoftware.kryonet.Connection;

public interface RemoteObject {
    public void setResponseTimeout(int var1);

    public void setNonBlocking(boolean var1);

    public void setTransmitReturnValue(boolean var1);

    public void setTransmitExceptions(boolean var1);

    public void setUDP(boolean var1);

    public void setRemoteToString(boolean var1);

    public Object waitForLastResponse();

    public Object hasLastResponse();

    public byte getLastResponseID();

    public Object waitForResponse(byte var1);

    public Object hasResponse(byte var1);

    public void close();

    public Connection getConnection();
}

