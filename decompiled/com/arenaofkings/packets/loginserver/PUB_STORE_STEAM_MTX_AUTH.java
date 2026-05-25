/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.loginserver;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.PublicPacket;

public class PUB_STORE_STEAM_MTX_AUTH
extends PublicPacket {
    private int appID;
    private long orderID;
    private boolean authorized;

    public PUB_STORE_STEAM_MTX_AUTH() {
    }

    public PUB_STORE_STEAM_MTX_AUTH(int n2, long l2, boolean bl2) {
        this.appID = n2;
        this.orderID = l2;
        this.authorized = bl2;
    }

    @Override
    public void handle(Engine engine) {
    }
}

