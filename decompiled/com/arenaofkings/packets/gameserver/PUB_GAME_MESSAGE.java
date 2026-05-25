/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.gameserver;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.loginserver.PUB_MISC_CHAT_MESSAGE;
import com.arenaofkings.packets.misc.PublicPacket;

public class PUB_GAME_MESSAGE
extends PublicPacket {
    private String data;
    private boolean sendToChat;

    public void setData(String string) {
        this.data = string;
    }

    public void setSendToChat(boolean bl2) {
        this.sendToChat = bl2;
    }

    @Override
    public void handle(Engine engine) {
        if (this.sendToChat && t.a(agd.class, engine)) {
            PUB_MISC_CHAT_MESSAGE pUB_MISC_CHAT_MESSAGE = new PUB_MISC_CHAT_MESSAGE(" ", this.data);
            pUB_MISC_CHAT_MESSAGE.channel = " ";
            ((agd)engine.axc_a()).agn_a().i_a().a(pUB_MISC_CHAT_MESSAGE, " ", true);
        }
    }
}

