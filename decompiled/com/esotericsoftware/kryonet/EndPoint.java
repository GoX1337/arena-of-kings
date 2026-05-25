/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.kryonet;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Listener;

public interface EndPoint
extends Runnable {
    public void addListener(Listener var1);

    public void removeListener(Listener var1);

    @Override
    public void run();

    public void start();

    public void stop();

    public void close();

    public void update(int var1);

    public Thread getUpdateThread();

    public Kryo getKryo();
}

