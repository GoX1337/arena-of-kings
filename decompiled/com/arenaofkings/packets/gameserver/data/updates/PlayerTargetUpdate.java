/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.gameserver.data.updates;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.Target;
import com.arenaofkings.packets.gameserver.data.updates.PlayerSnapshot;

public class PlayerTargetUpdate
extends PlayerSnapshot {
    private Target target;

    public PlayerTargetUpdate() {
    }

    public PlayerTargetUpdate(Target target) {
        this.target = target;
    }

    public Target getTarget() {
        return this.target;
    }

    public void setTarget(Target target) {
        this.target = target;
    }

    @Override
    public void handle(String string, PlayerSnapshot playerSnapshot, Engine engine) {
    }
}

