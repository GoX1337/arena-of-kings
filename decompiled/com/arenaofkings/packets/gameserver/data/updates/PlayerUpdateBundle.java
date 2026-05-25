/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.gameserver.data.updates;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.PublicPacket;
import java.util.ArrayList;

public class PlayerUpdateBundle
extends PublicPacket {
    ArrayList<PublicPacket> u = new ArrayList();

    public void add(PublicPacket publicPacket) {
        this.u.add(publicPacket);
    }

    public ArrayList<PublicPacket> getUpdates() {
        return this.u;
    }

    @Override
    public void handle(Engine engine) {
    }
}

