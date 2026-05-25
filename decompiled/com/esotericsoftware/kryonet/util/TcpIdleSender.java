/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.kryonet.util;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

public abstract class TcpIdleSender
implements Listener {
    boolean started;

    @Override
    public void idle(Connection connection) {
        Object object;
        if (!this.started) {
            this.started = true;
            this.start();
        }
        if ((object = this.next()) == null) {
            connection.removeListener(this);
        } else {
            connection.sendTCP(object);
        }
    }

    protected void start() {
    }

    protected abstract Object next();
}

