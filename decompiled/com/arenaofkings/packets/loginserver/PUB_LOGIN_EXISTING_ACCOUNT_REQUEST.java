/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.loginserver;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.PublicPacket;

public class PUB_LOGIN_EXISTING_ACCOUNT_REQUEST
extends PublicPacket {
    public String pram1;
    public String pram2;
    public String pram3;
    public String pram4;
    public String pram5;

    public PUB_LOGIN_EXISTING_ACCOUNT_REQUEST() {
    }

    public PUB_LOGIN_EXISTING_ACCOUNT_REQUEST(String string, String string2, String string3, String string4) {
        this.pram1 = string;
        this.pram2 = string2;
        this.pram3 = string3;
        this.pram4 = string4;
        try {
            this.pram5 = m.a();
        }
        catch (Exception exception) {
            this.pram5 = "ERROR";
        }
    }

    @Override
    public void handle(Engine engine) {
    }
}

