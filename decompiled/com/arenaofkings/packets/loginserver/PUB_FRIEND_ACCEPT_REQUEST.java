/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.loginserver;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.PlayerStatus;
import com.arenaofkings.packets.misc.PublicPacket;
import com.arenaofkings.packets.misc.RelationshipStatus;
import java.util.Iterator;

public class PUB_FRIEND_ACCEPT_REQUEST
extends PublicPacket {
    private String account_name;
    private String character_name;

    public PUB_FRIEND_ACCEPT_REQUEST() {
    }

    public PUB_FRIEND_ACCEPT_REQUEST(String string) {
        this.account_name = string;
    }

    public PUB_FRIEND_ACCEPT_REQUEST(String string, String string2) {
        this.account_name = string;
        this.character_name = string2;
    }

    @Override
    public void handle(Engine engine) {
        if (this.account_name == null || this.character_name == null) {
            return;
        }
        Engine.a("woo. new friend: " + this.account_name + " cname:" + this.character_name);
        if (this.character_name.equals("-1")) {
            Iterator iterator = ay.ay_a().gd_a().axz_a().a().iterator();
            while (iterator.hasNext()) {
                ayq ayq2 = (ayq)iterator.next();
                if (!this.account_name.equals(ayq2.a())) continue;
                iterator.remove();
            }
            return;
        }
        ayq ayq3 = ay.ay_a().gd_a().axz_a().a(this.account_name);
        if (ayq3 != null) {
            ayq3.a(RelationshipStatus.ACCEPTED);
            Engine.a("set");
        } else {
            ay.ay_a().gd_a().axz_a().a(new ayq(0, this.account_name, this.character_name, PlayerStatus.AVAILABLE, RelationshipStatus.ACCEPTED, "PUB_FRIEND_ACCEPT_REQUEST TODO"));
        }
    }
}

