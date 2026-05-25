/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.loginserver;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.PublicPacket;

public class PUB_TRADE_ITEM_REMOVE
extends PublicPacket {
    public int position;
    public String traderName;

    @Override
    public void handle(Engine engine) {
        ay.ay_a().gd_a().ca_a().a(this.traderName, this.position);
    }
}

