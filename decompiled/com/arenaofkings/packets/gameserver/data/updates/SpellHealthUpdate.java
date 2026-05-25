/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.gameserver.data.updates;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.PublicPacket;

public class SpellHealthUpdate
extends PublicPacket {
    private int health;
    private int ID;

    public SpellHealthUpdate() {
    }

    public SpellHealthUpdate(int n2, int n3) {
        this.health = n2;
        this.ID = n3;
    }

    @Override
    public void handle(Engine engine) {
        for (ui ui2 : ((agd)engine.axc_a()).hi_a().a()) {
            if (ui2.int_a() != this.ID || this.health != 0) continue;
            ui2.hf_a().a(this.health);
        }
    }
}

