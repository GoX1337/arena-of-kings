/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.loginserver;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.PublicPacket;

public class PUB_LOGIN_QUEUE_UPDATE
extends PublicPacket {
    private int position;

    @Override
    public void handle(Engine engine) {
        System.out.println("handling queue update");
        if (t.a(aes.class, engine)) {
            ((aex)((aes)engine.axc_a()).aya_a()).a(this.position);
        }
        System.out.println("done handling queue update");
    }
}

