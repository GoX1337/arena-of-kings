/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.gameserver.requests.input;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.Target;
import com.arenaofkings.packets.misc.PublicPacket;

public class TargetRequest
extends PublicPacket {
    private Target target;

    public TargetRequest() {
    }

    public TargetRequest(Target target) {
        this.target = target;
    }

    public Target getTarget() {
        return this.target;
    }

    public void setTarget(Target target) {
        this.target = target;
    }

    @Override
    public void handle(Engine engine) {
    }
}

