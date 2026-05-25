/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.loginserver;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.PublicPacket;
import com.arenaofkings.packets.misc.items.ItemLocation;

public class PUB_TRADE_ITEM_MOVE
extends PublicPacket {
    public int grabItemPosition;
    public ItemLocation grabItemLocation;
    public int grabStashTabIndex;
    public int dropItemPosition;

    @Override
    public void handle(Engine engine) {
    }
}

