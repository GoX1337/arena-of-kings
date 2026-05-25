/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.loginserver;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.PublicPacket;

public class PUB_PARTY_INVITE
extends PublicPacket {
    private String invite_name;
    private int partyType;

    public PUB_PARTY_INVITE() {
    }

    public PUB_PARTY_INVITE(String string, int n2) {
        this.invite_name = string;
        this.partyType = n2;
    }

    @Override
    public void handle(Engine engine) {
    }
}

