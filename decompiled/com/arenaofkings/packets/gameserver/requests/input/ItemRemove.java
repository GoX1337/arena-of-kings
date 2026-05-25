/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.gameserver.requests.input;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.PublicPacket;

public class ItemRemove
extends PublicPacket {
    public int itemID;

    @Override
    public void handle(Engine engine) {
        fj fj2;
        if (!t.a(agd.class, engine) || (fj2 = ((agd)engine.axc_a()).aga_a().a(engine, this.itemID)) != null) {
            // empty if block
        }
    }
}

