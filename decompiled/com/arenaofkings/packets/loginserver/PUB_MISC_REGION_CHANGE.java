/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.loginserver;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.PublicPacket;
import com.arenaofkings.packets.misc.Region;

public class PUB_MISC_REGION_CHANGE
extends PublicPacket {
    private boolean USvalue;
    private boolean EUvalue;
    private Region preference;

    public void setEUvalue(boolean bl2) {
        this.EUvalue = bl2;
    }

    public void setPreference(Region region) {
        this.preference = region;
    }

    public void setUSvalue(boolean bl2) {
        this.USvalue = bl2;
    }

    @Override
    public void handle(Engine engine) {
    }
}

