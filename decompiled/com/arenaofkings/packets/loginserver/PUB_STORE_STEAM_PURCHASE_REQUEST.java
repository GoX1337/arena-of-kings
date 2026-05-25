/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.loginserver;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.PublicPacket;
import com.arenaofkings.packets.misc.StorePayableItem;

public class PUB_STORE_STEAM_PURCHASE_REQUEST
extends PublicPacket {
    public int itemID;
    public String steamID;
    public String languageCode;
    public String countryCode;
    public String currencyCode;
    public StorePayableItem item;
    public String metadata;

    @Override
    public void handle(Engine engine) {
    }
}

