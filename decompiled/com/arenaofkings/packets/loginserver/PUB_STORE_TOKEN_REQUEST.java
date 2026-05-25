/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.loginserver;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.PublicPacket;
import com.arenaofkings.packets.misc.StorePayableItem;

public class PUB_STORE_TOKEN_REQUEST
extends PublicPacket {
    private StorePayableItem storePayableItem;

    public PUB_STORE_TOKEN_REQUEST(StorePayableItem storePayableItem) {
        this.storePayableItem = storePayableItem;
    }

    @Override
    public void handle(Engine engine) {
    }
}

