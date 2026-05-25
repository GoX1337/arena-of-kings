/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.loginserver.dev;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.PublicPacket;

public class PUB_GAME_ASSIGN
extends PublicPacket {
    private String IP_ADDRESS;
    private int PORT;
    private int gameID;

    public void setIP_ADDRESS(String string) {
        this.IP_ADDRESS = string;
    }

    public void setPORT(int n2) {
        this.PORT = n2;
    }

    public String getIP_ADDRESS() {
        return this.IP_ADDRESS;
    }

    public int getPORT() {
        return this.PORT;
    }

    @Override
    public void handle(Engine engine) {
        Engine.b("New game assigned! " + this.IP_ADDRESS + " " + this.PORT);
        engine.var_ag_a.a(this.IP_ADDRESS, this.PORT, this.gameID);
    }
}

