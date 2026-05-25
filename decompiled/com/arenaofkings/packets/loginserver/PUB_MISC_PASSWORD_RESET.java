/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.loginserver;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.PublicPacket;

public class PUB_MISC_PASSWORD_RESET
extends PublicPacket {
    public String email;
    public int returnCode;

    @Override
    public void handle(Engine engine) {
        aes aes2;
        Engine.b("Password Reset received. Return code: " + this.returnCode);
        if (this.email.equals("valid") && this.returnCode == 1600 && t.a(aes.class, engine) && (aes2 = (aes)engine.axc_a()).com_arenaofkings_packets_loginserver_PUB_LOGIN_ACCOUNT_INIT_a() != null) {
            aes2.com_arenaofkings_packets_loginserver_PUB_LOGIN_ACCOUNT_INIT_a().setInvalidPassword("");
            aes2.com_arenaofkings_packets_loginserver_PUB_LOGIN_ACCOUNT_INIT_a().handle(engine);
        }
    }
}

