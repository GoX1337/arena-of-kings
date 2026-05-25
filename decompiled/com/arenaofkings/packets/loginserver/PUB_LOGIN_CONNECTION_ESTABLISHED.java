/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.loginserver;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.PublicPacket;

public class PUB_LOGIN_CONNECTION_ESTABLISHED
extends PublicPacket {
    @Override
    public void handle(Engine engine) {
        engine.var_z_a.a(true);
        engine.a(true);
    }
}

