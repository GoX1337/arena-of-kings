/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.loginserver;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.PublicPacket;

public class PUB_SILVER_CHANGE
extends PublicPacket {
    private int silver;

    public PUB_SILVER_CHANGE() {
    }

    public PUB_SILVER_CHANGE(int n2) {
        this.silver = n2;
    }

    @Override
    public void handle(Engine engine) {
        ay.ay_a().gd_a().f(this.silver);
        engine.var_baa_a.a(ajw.jU);
        engine.var_baa_a.a(ajw.jW);
    }
}

