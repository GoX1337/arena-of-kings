/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.gameserver.requests.input;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.Location;
import com.arenaofkings.packets.gameserver.requests.input.SpellRequest;

public class SPELL_REQUEST
extends SpellRequest {
    public SPELL_REQUEST() {
    }

    public SPELL_REQUEST(Location location, int n2) {
        this.location = location;
        this.slot = n2;
    }

    @Override
    public void handle(Engine engine) {
    }
}

