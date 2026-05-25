/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.loginserver;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.PublicPacket;

public class PUB_MISC_NEWS_UPDATE
extends PublicPacket {
    private String news;

    @Override
    public void handle(Engine engine) {
        System.out.println("NEWS received");
        System.out.println("news: " + this.news);
        engine.var_java_lang_String_f = this.news;
        engine.var_z_a.a(w.var_w_a);
    }
}

