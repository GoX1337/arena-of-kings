/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.loginserver;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.PublicPacket;
import java.util.ArrayList;

public class PUB_TRADE_FINISHED_SYNC
extends PublicPacket {
    public ArrayList<Integer> clearInventoryPositions;
    public ArrayList<Integer> clearStashPositions;
    public ArrayList<Integer> clearStashTabIndexes;
    public int newSilverAmount = 0;
    public int tradedSilverAmount = 0;

    @Override
    public void handle(Engine engine) {
        ay.ay_a().gd_a().ca_a().a(this.clearInventoryPositions, this.clearStashPositions, this.clearStashTabIndexes, this.tradedSilverAmount);
        ay.ay_a().gd_a().f(this.newSilverAmount);
    }
}

