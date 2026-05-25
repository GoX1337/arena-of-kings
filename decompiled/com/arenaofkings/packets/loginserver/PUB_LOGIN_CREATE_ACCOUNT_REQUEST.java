/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.loginserver;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.PublicPacket;

public class PUB_LOGIN_CREATE_ACCOUNT_REQUEST
extends PublicPacket {
    private String username;
    private String password;
    private String betakey;
    private String raf;
    private String email;
    private String affiliate;
    private boolean subscribe;

    public PUB_LOGIN_CREATE_ACCOUNT_REQUEST(String string, String string2, String string3, String string4, String string5, boolean bl2, String string6) {
        this.username = string;
        this.password = string2;
        this.betakey = string3;
        this.raf = string4;
        this.email = string5;
        this.subscribe = bl2;
        this.affiliate = string6;
    }

    @Override
    public void handle(Engine engine) {
    }

    public String toString() {
        return "PUB_LOGIN_CREATE_ACCOUNT_REQUEST [username=" + this.username + ", password=" + this.password + ", betakey=" + this.betakey + ", email=" + this.email + "]";
    }
}

