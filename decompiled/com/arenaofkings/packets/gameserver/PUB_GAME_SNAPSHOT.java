/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.gameserver;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.updates.UpdatePacket;
import com.arenaofkings.packets.misc.PublicPacket;
import java.util.ArrayList;
import java.util.List;

public class PUB_GAME_SNAPSHOT
extends PublicPacket {
    ArrayList<UpdatePacket> updatePackets = new ArrayList();
    private int ID;

    public List<UpdatePacket> getSnapshots() {
        return this.updatePackets;
    }

    public int getID() {
        return this.ID;
    }

    @Override
    public void handle(Engine engine) {
        for (UpdatePacket updatePacket : this.updatePackets) {
            engine.var_q_a.a("[NETWORK-GS] " + updatePacket.getClass().getSimpleName() + ".handle()");
            updatePacket.handle(updatePacket, engine);
        }
    }
}

