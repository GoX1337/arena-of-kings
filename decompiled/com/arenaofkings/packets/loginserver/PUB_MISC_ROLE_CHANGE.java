/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.loginserver;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.PartyRole;
import com.arenaofkings.packets.misc.PublicPacket;

public class PUB_MISC_ROLE_CHANGE
extends PublicPacket {
    public String characterName;
    public PartyRole partyRole;
    public boolean status;

    @Override
    public void handle(Engine engine) {
        br br2 = ay.ay_a().br_a(this.characterName);
        if (br2 != null) {
            br2.a(this.partyRole);
        }
    }
}

