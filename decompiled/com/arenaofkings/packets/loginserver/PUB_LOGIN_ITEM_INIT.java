/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.loginserver;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.PublicPacket;
import com.arenaofkings.packets.misc.items.ItemData;
import java.util.ArrayList;

public class PUB_LOGIN_ITEM_INIT
extends PublicPacket {
    private ArrayList<ItemData> inventoryData = new ArrayList();
    private ArrayList<ItemData> stashData = new ArrayList();

    @Override
    public void handle(Engine engine) {
        Engine.b("item init");
        ay.ay_a().gd_a().a(engine, this.inventoryData);
    }
}

