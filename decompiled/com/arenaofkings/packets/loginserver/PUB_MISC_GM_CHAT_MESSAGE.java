/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.loginserver;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.loginserver.PUB_MISC_CHAT_MESSAGE;
import com.arenaofkings.packets.misc.PublicPacket;

public class PUB_MISC_GM_CHAT_MESSAGE
extends PublicPacket {
    private String message;

    public PUB_MISC_GM_CHAT_MESSAGE() {
    }

    public PUB_MISC_GM_CHAT_MESSAGE(String string) {
        this.message = string;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String string) {
        this.message = string;
    }

    @Override
    public void handle(Engine engine) {
        PUB_MISC_CHAT_MESSAGE pUB_MISC_CHAT_MESSAGE = new PUB_MISC_CHAT_MESSAGE("[DISCORD_PURPLE]" + this.message);
        pUB_MISC_CHAT_MESSAGE.channel = ay.ay_a().gd_a().ev_a().b().java_lang_String_a();
        pUB_MISC_CHAT_MESSAGE.header = "/1 ";
        pUB_MISC_CHAT_MESSAGE.handle(engine);
        if (!t.a(we.class, engine) && t.a(agd.class, engine)) {
            ((agd)engine.axc_a()).agn_a().i_a().l();
        }
    }
}

