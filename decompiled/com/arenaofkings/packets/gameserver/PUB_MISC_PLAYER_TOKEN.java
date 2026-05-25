/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.gameserver;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.PublicPacket;

public class PUB_MISC_PLAYER_TOKEN
extends PublicPacket {
    private String token;
    private int gameID;

    public PUB_MISC_PLAYER_TOKEN() {
    }

    public PUB_MISC_PLAYER_TOKEN(String string) {
        this.token = string;
    }

    public void setToken(String string) {
        this.token = string;
    }

    public void setGameID(int n2) {
        this.gameID = n2;
    }

    @Override
    public void handle(Engine engine) {
    }
}

