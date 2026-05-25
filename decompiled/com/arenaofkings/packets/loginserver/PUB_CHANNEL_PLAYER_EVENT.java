/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.loginserver;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.ChannelEvent;
import com.arenaofkings.packets.misc.PublicPacket;
import com.badlogic.gdx.utils.ObjectMap;

public class PUB_CHANNEL_PLAYER_EVENT
extends PublicPacket {
    private String channelName;
    private ChannelEvent channelEvent;
    private String playerName;
    private String newPlayerName;

    @Override
    public void handle(Engine engine) {
        System.out.println("Channel event");
        if (ay.ay_a() == null || ay.ay_a().gd_a() == null || ay.ay_a().gd_a().ev_a() == null) {
            return;
        }
        en en2 = ay.ay_a().gd_a().ev_a().en_a(this.channelName);
        System.out.println("Done channel event");
        if (en2 != null) {
            switch (this.channelEvent) {
                case PLAYER_JOIN: {
                    en2.a(this.playerName);
                    break;
                }
                case PLAYER_LEAVE: {
                    en2.b(this.playerName);
                    break;
                }
                case PLAYER_CHANGE_CHARACTER: {
                    for (ObjectMap.Entry<String, en> entry : ay.ay_a().gd_a().ev_a().a().entries()) {
                        ew ew2 = ((en)entry.value).a().get(this.playerName);
                        if (ew2 == null) continue;
                        ew2.a(this.newPlayerName);
                        ((en)entry.value).a().put(this.newPlayerName, ((en)entry.value).a().remove(this.playerName));
                    }
                    break;
                }
            }
        }
    }
}

