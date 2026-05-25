/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.loginserver;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.PublicPacket;

public class PUB_MISC_CRASH_REPORT
extends PublicPacket {
    private String eventLog = "";
    private String crashLog = "";

    public PUB_MISC_CRASH_REPORT() {
    }

    public PUB_MISC_CRASH_REPORT(String string, String string2) {
        this.eventLog = string;
        this.crashLog = string2;
    }

    @Override
    public void handle(Engine engine) {
    }
}

