/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.loginserver;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.loginserver.PUB_MISC_CHAT_MESSAGE;
import com.arenaofkings.packets.misc.PublicPacket;
import com.arenaofkings.packets.misc.ReadyStatus;

public class PUB_SERVER_MESSAGE
extends PublicPacket {
    private String message;

    public PUB_SERVER_MESSAGE() {
    }

    public PUB_SERVER_MESSAGE(String string) {
        this.message = string;
    }

    @Override
    public void handle(Engine engine) {
        PUB_MISC_CHAT_MESSAGE pUB_MISC_CHAT_MESSAGE = new PUB_MISC_CHAT_MESSAGE("[DISCORD_PURPLE]" + this.message);
        if (ay.ay_a() == null) {
            return;
        }
        if (ay.ay_a().gd_a() == null) {
            return;
        }
        if (ay.ay_a().gd_a().ev_a() == null) {
            return;
        }
        if (ay.ay_a().gd_a().ev_a().b() == null) {
            return;
        }
        pUB_MISC_CHAT_MESSAGE.channel = ay.ay_a().gd_a().ev_a().b().java_lang_String_a();
        pUB_MISC_CHAT_MESSAGE.header = "/1 ";
        if (this.message.equals("Tournament Start")) {
            // empty if block
        }
        pUB_MISC_CHAT_MESSAGE.handle(engine);
        if (this.message.startsWith("Daily quests have been reset")) {
            for (ej object : ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getCharacterEntities()) {
                object.c(0);
            }
        }
        if (this.message.startsWith("Weekly quests have been reset")) {
            for (ej ej2 : ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getCharacterEntities()) {
                ej2.d(0);
            }
        }
        if (this.message.startsWith("[SKY]Your Membership has been canceled")) {
            ay.ay_a().gd_a().b(false);
            ay.ay_a().gd_a().d(false);
        }
        if (t.a(agd.class, engine)) {
            ((agd)engine.axc_a()).agn_a().i_a().l();
            if (this.message.startsWith("A worthy challenger has been found!")) {
                ((agd)engine.axc_a()).d(true);
            }
            if (this.message.startsWith("[ERROR] ")) {
                ((agd)engine.axc_a()).agn_a().i_a().a(this.message, engine.var_com_badlogic_gdx_graphics_g2d_BitmapFont_a);
                engine.var_baa_a.a(ajw.kG, 0.6f);
            } else if (this.message.startsWith("[SUCCESS] ")) {
                ((agd)engine.axc_a()).agn_a().i_a().a(this.message, engine.var_com_badlogic_gdx_graphics_g2d_BitmapFont_c);
                engine.var_baa_a.a(ajw.ky, 0.6f);
            } else if (this.message.startsWith("[HIGHLIGHT] ")) {
                ((agd)engine.axc_a()).agn_a().i_a().a("[RARITY_LEGENDARY]" + this.message.substring(12), engine.var_com_badlogic_gdx_graphics_g2d_BitmapFont_h);
                engine.var_baa_a.a(ajw.ky, 0.6f);
            } else if (!(this.message.equals("Your party has entered the matchmaking queue.") || this.message.equals("Your party has left the matchmaking queue.") || this.message.equals("You are ready!") || this.message.equals("You are now unready.") || this.message.equals("You have entered the Party Finder. Seeking additional members ...") || this.message.equals("Worthy challengers are about to fight!") || this.message.equals("You have left the queue."))) {
                ((agd)engine.axc_a()).agn_a().i_a().a("[AOK_BLUE]" + this.message, engine.var_com_badlogic_gdx_graphics_g2d_BitmapFont_b);
                engine.var_baa_a.a(ajw.ky, 0.6f);
            }
        }
        if (t.a(we.class, engine)) {
            we we2 = (we)engine.axc_a();
            wg wg2 = we2.wh_a().wg_a();
            if (this.message.startsWith("[ERROR] ")) {
                engine.var_baa_a.a(ajw.kG, 0.6f);
            } else if (this.message.startsWith("[SUCCESS] ") || this.message.startsWith("[HIGHLIGHT] ") || this.message.equals("Your party has entered the matchmaking queue.") || this.message.equals("Your party has left the matchmaking queue.") || this.message.equals("You are ready!") || this.message.equals("You are now unready.") || this.message.equals("You have entered the Party Finder. Seeking additional members ...") || this.message.equals("Worthy challengers are about to fight!") || !this.message.equals("You have left the queue.")) {
                // empty if block
            }
            if (this.message.equals("You are ready!")) {
                ay.ay_a().gf_a().a(2);
                we2.wh_a().yg_b().void_b();
            }
            if (this.message.equals("You are now unready.")) {
                ay.ay_a().gf_a().a(1);
                we2.wh_a().yg_b().void_c();
                engine.var_baa_a.a(ajw.kx, 0.6f);
            }
            if (this.message.equals("Worthy challengers just entered the arena!")) {
                // empty if block
            }
            if (this.message.equals("Tournament Start")) {
                engine.var_baa_a.a(ajw.kZ, 0.6f);
            }
            if (this.message.startsWith("Your party has entered the Quick Play matchmaking queue.") || this.message.startsWith("You have entered the Quick Play Party Finder.")) {
                ay.ay_a().gf_a().a(2);
                we2.wh_a().yg_b().void_b();
            } else if (this.message.equals("Your party has left the matchmaking queue.") || this.message.equals("You have left the queue.")) {
                if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bd_a().com_arenaofkings_packets_misc_ReadyStatus_a() != ReadyStatus.RED) {
                    ay.ay_a().gf_a().a(2);
                    we2.wh_a().yg_b().void_b();
                } else {
                    ay.ay_a().gf_a().a(1);
                    we2.wh_a().yg_b().void_c();
                }
                engine.var_baa_a.a(ajw.kx, 0.6f);
            }
            if (this.message.equals("Your party has entered the Quick Play matchmaking queue.")) {
                we2.wh_a().a("3v3 Quick Play Matchmaking [GRAY](unranked)[]");
                ay.ay_a().gd_a().j(1);
                engine.var_baa_a.a(ajw.kw, 0.6f);
            } else if (this.message.equals("Your party has entered Ranked Team queue.")) {
                we2.wh_a().a("3v3 Ranked Team");
                ay.ay_a().gd_a().j(2);
                engine.var_baa_a.a(ajw.kw, 0.6f);
            } else if (this.message.equals("You have entered Ranked Solo queue. Searching for additional members...")) {
                we2.wh_a().a("3v3 Ranked Solo");
                ay.ay_a().gd_a().j(3);
                engine.var_baa_a.a(ajw.kw, 0.6f);
            } else if (this.message.equals("You have entered the Quick Play Party Finder. Searching for additional members...")) {
                we2.wh_a().a("3v3 Quick Play Party Finder [GRAY](unranked)[]");
                ay.ay_a().gd_a().j(1);
                engine.var_baa_a.a(ajw.kw, 0.6f);
            } else if (this.message.equals("Your party has left the matchmaking queue.") || this.message.equals("You have left the queue.")) {
                we2.wh_a().j();
                ay.ay_a().gd_a().j(0);
            } else if (this.message.startsWith("A player has abandoned")) {
                ay.ay_a().gd_a().azv_b().d();
            } else if (this.message.startsWith("Your Party has been formed!")) {
                ay.ay_a().gd_a().azv_b().void_c();
                ay.ay_a().gd_a().j(3);
                engine.var_baa_a.a(ajw.kw, 0.6f);
            } else if (this.message.startsWith("Your Party has been formed!")) {
                ay.ay_a().gd_a().azv_b().void_c();
                ay.ay_a().gd_a().j(3);
                engine.var_baa_a.a(ajw.kw, 0.6f);
            } else if (this.message.startsWith("You have entered Ranked Solo queue.")) {
                ay.ay_a().gd_a().j(3);
                engine.var_baa_a.a(ajw.kw, 0.6f);
            }
            Engine.b("out");
        }
    }
}

