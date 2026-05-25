/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.gameserver.requests.input;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.Location;
import com.arenaofkings.packets.misc.PublicPacket;

public abstract class SpellRequest
extends PublicPacket {
    protected Location location;
    protected int slot;

    public Location getLocation() {
        return this.location;
    }

    @Override
    public void handle(Engine engine) {
    }
}

