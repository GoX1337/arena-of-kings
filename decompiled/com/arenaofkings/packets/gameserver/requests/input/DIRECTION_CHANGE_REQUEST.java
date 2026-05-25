/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.gameserver.requests.input;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.Direction;
import com.arenaofkings.packets.misc.PublicPacket;

public class DIRECTION_CHANGE_REQUEST
extends PublicPacket {
    private Direction direction;

    public DIRECTION_CHANGE_REQUEST() {
    }

    public DIRECTION_CHANGE_REQUEST(Direction direction) {
        this.direction = direction;
    }

    @Override
    public void handle(Engine engine) {
    }
}

