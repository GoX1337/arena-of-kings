/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.loginserver;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.PublicPacket;

public class PUB_TRADE_OPEN
extends PublicPacket {
    String trader_name;

    @Override
    public void handle(Engine engine) {
        ay.ay_a().gd_a().ca_a().a(this.trader_name);
    }
}

