/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.loginserver;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.PublicPacket;
import com.badlogic.gdx.Gdx;

public class PUB_STORE_TOKEN_RESPONSE
extends PublicPacket {
    private String ACCESS_TOKEN;

    @Override
    public void handle(Engine engine) {
        Engine.b("Received ACCESS_TOKEN " + this.ACCESS_TOKEN);
        Gdx.net.openURI("https://sandbox-secure.xsolla.com/paystation2/?access_token=" + this.ACCESS_TOKEN);
        engine.var_baa_a.a(ajw.kA, 0.5f);
        if (t.a(we.class, engine)) {
            we we2 = (we)engine.axc_a();
            wg wg2 = we2.wh_a().wg_a();
            wg2.a("[RARITY_LEGENDARY]Opening a new Tab for your Secure Checkout with Xsolla's Payment Portal!", engine.var_com_badlogic_gdx_graphics_g2d_BitmapFont_b);
            wg2.a("[RARITY_LEGENDARY]Didn't get a pop-up? Whitelist us on your [RED]Ad Blocker[]!", engine.var_com_badlogic_gdx_graphics_g2d_BitmapFont_b);
        }
    }
}

