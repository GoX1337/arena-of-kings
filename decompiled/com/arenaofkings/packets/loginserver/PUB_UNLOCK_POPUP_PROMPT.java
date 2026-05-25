/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.loginserver;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.PublicPacket;

public class PUB_UNLOCK_POPUP_PROMPT
extends PublicPacket {
    private String storeUnlockableItem;

    @Override
    public void handle(Engine engine) {
        if (t.a(we.class, engine)) {
            ((we)engine.axc_a()).wh_a().a(abi.valueOf(this.storeUnlockableItem));
        }
    }
}

