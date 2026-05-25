/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.gameserver;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.loginserver.PUB_MISC_CHAT_MESSAGE;
import com.arenaofkings.packets.misc.PublicPacket;

public class PUB_GAME_FOG_UPDATE
extends PublicPacket {
    private int fogLevel = 0;

    @Override
    public void handle(Engine engine) {
        if (t.a(agd.class, engine)) {
            ((agd)engine.axc_a()).a(this.fogLevel);
            if (this.fogLevel == 1) {
                PUB_MISC_CHAT_MESSAGE pUB_MISC_CHAT_MESSAGE = new PUB_MISC_CHAT_MESSAGE(" ", "[RED]Sudden Death Stage 1.  +10% Amplify -10% Healing");
                pUB_MISC_CHAT_MESSAGE.channel = " ";
                ((agd)engine.axc_a()).agn_a().i_a().a(pUB_MISC_CHAT_MESSAGE, " ", true);
                engine.var_baa_a.a(ajw.kN, 0.7f);
            } else if (this.fogLevel == 2) {
                PUB_MISC_CHAT_MESSAGE pUB_MISC_CHAT_MESSAGE = new PUB_MISC_CHAT_MESSAGE(" ", "[RED]Sudden Death Stage 2.  +20% Amplify -20% Healing");
                pUB_MISC_CHAT_MESSAGE.channel = " ";
                ((agd)engine.axc_a()).agn_a().i_a().a(pUB_MISC_CHAT_MESSAGE, " ", true);
                engine.var_baa_a.a(ajw.kN, 0.75f);
            } else if (this.fogLevel == 3) {
                PUB_MISC_CHAT_MESSAGE pUB_MISC_CHAT_MESSAGE = new PUB_MISC_CHAT_MESSAGE(" ", "[RED]Sudden Death Stage 3.  +30% Amplify -30% Healing");
                pUB_MISC_CHAT_MESSAGE.channel = " ";
                ((agd)engine.axc_a()).agn_a().i_a().a(pUB_MISC_CHAT_MESSAGE, " ", true);
                engine.var_baa_a.a(ajw.kN, 0.8f);
            } else if (this.fogLevel == 4) {
                PUB_MISC_CHAT_MESSAGE pUB_MISC_CHAT_MESSAGE = new PUB_MISC_CHAT_MESSAGE(" ", "[RED]Sudden Death Stage 4.  +40% Amplify -40% Healing");
                pUB_MISC_CHAT_MESSAGE.channel = " ";
                ((agd)engine.axc_a()).agn_a().i_a().a(pUB_MISC_CHAT_MESSAGE, " ", true);
                engine.var_baa_a.a(ajw.kN, 0.8f);
            } else if (this.fogLevel == 5) {
                PUB_MISC_CHAT_MESSAGE pUB_MISC_CHAT_MESSAGE = new PUB_MISC_CHAT_MESSAGE(" ", "[RED]Sudden Death Stage 5.  +50% Amplify -60% Healing");
                pUB_MISC_CHAT_MESSAGE.channel = " ";
                ((agd)engine.axc_a()).agn_a().i_a().a(pUB_MISC_CHAT_MESSAGE, " ", true);
                engine.var_baa_a.a(ajw.kN, 0.8f);
            } else if (this.fogLevel == 6) {
                PUB_MISC_CHAT_MESSAGE pUB_MISC_CHAT_MESSAGE = new PUB_MISC_CHAT_MESSAGE(" ", "[RED]Sudden Death Stage 6.  +50% Amplify -80% Healing");
                pUB_MISC_CHAT_MESSAGE.channel = " ";
                ((agd)engine.axc_a()).agn_a().i_a().a(pUB_MISC_CHAT_MESSAGE, " ", true);
                engine.var_baa_a.a(ajw.kN, 0.8f);
            } else if (this.fogLevel == 7) {
                PUB_MISC_CHAT_MESSAGE pUB_MISC_CHAT_MESSAGE = new PUB_MISC_CHAT_MESSAGE(" ", "[RED]Sudden Death Stage 7.  +50% Amplify -100% Healing");
                pUB_MISC_CHAT_MESSAGE.channel = " ";
                ((agd)engine.axc_a()).agn_a().i_a().a(pUB_MISC_CHAT_MESSAGE, " ", true);
                engine.var_baa_a.a(ajw.kN, 0.8f);
            }
        }
    }
}

