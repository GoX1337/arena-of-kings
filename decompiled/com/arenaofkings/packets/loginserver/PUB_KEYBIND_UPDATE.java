/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.loginserver;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.InputIdentifier;
import com.arenaofkings.packets.misc.PublicPacket;

public class PUB_KEYBIND_UPDATE
extends PublicPacket {
    public InputIdentifier inputIdentifier;
    public int key;

    public PUB_KEYBIND_UPDATE() {
    }

    public PUB_KEYBIND_UPDATE(InputIdentifier inputIdentifier, int n2) {
        this.inputIdentifier = inputIdentifier;
        this.key = n2;
    }

    @Override
    public void handle(Engine engine) {
        if (t.a(we.class, engine)) {
            ((we)engine.axc_a()).wh_a().aay_a().a().a(this.key);
        }
    }
}

