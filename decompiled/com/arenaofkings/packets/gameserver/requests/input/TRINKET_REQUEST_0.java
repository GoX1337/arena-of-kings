/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.gameserver.requests.input;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.PublicPacket;

public class TRINKET_REQUEST_0
extends PublicPacket {
    boolean moving = false;

    public TRINKET_REQUEST_0() {
    }

    public TRINKET_REQUEST_0(boolean bl2) {
        this.moving = bl2;
    }

    @Override
    public void handle(Engine engine) {
    }
}

