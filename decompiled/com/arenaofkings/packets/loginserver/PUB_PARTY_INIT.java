/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.loginserver;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.ArenaTeamData;
import com.arenaofkings.packets.misc.CharacterClass;
import com.arenaofkings.packets.misc.PartyRole;
import com.arenaofkings.packets.misc.ProfileBackgrounds;
import com.arenaofkings.packets.misc.PublicPacket;
import com.arenaofkings.packets.misc.ReadyStatus;
import java.util.ArrayList;

public class PUB_PARTY_INIT
extends PublicPacket {
    private ArrayList<String> character_name = new ArrayList();
    private ArrayList<Integer> character_ordinal = new ArrayList();
    private ArrayList<CharacterClass> character_class = new ArrayList();
    private ArrayList<Integer> character_outfit = new ArrayList();
    private ArrayList<ProfileBackgrounds> character_profile_background = new ArrayList();
    private ArrayList<String> character_profile_effect_1 = new ArrayList();
    private ArrayList<String> character_profile_effect_2 = new ArrayList();
    private ArrayList<String> character_profile_effect_3 = new ArrayList();
    private ArrayList<Integer> character_level = new ArrayList();
    private ArrayList<Integer> fame = new ArrayList();
    private ArrayList<Integer> rating = new ArrayList();
    private ArrayList<Integer> memberMonths = new ArrayList();
    private ArrayList<ArrayList<String>> character_spells = new ArrayList();
    private ArrayList<PartyRole> role = new ArrayList();
    private ArenaTeamData arenaTeamData;
    private int partyType;

    @Override
    public void handle(Engine engine) {
        Engine.b("New party! ");
        ay.ay_a().gd_a().ev_a().void_a("Game");
        String string = "";
        Engine.a("PUB_PARTY_INIT PACKET READ");
        if (engine.axc_a().getClass() == we.class && ay.ay_a().gf_a().a().size() == 1) {
            ((we)engine.axc_a()).wh_a().f();
        }
        ay.ay_a().gf_a().a(engine, false);
        ay.ay_a().gf_a().a(1);
        for (int i2 = 0; i2 < this.character_name.size(); ++i2) {
            Object object;
            string = string + this.character_name.get(i2) + " " + (Object)((Object)this.character_class.get(i2)) + " " + this.character_outfit.get(i2);
            if (this.character_name.get(i2).equals(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().java_lang_String_a())) {
                ay.ay_a().gf_a().a(ay.ay_a());
                ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().void_a(this.character_ordinal.get(i2));
                ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bd_a().a(ReadyStatus.RED);
                if (this.role != null && !this.role.isEmpty()) {
                    try {
                        ay.ay_a().a(this.role.get(i2));
                        object = (we)engine.axc_a();
                        wg wg2 = ((we)object).wh_a().wg_a();
                        if (ay.ay_a().com_arenaofkings_packets_misc_PartyRole_a() == PartyRole.DPS) {
                            wg2.a("[YELLOW]Your assigned role is Damage.[]");
                            continue;
                        }
                        if (ay.ay_a().com_arenaofkings_packets_misc_PartyRole_a() != PartyRole.HEALER) continue;
                        wg2.a("[LIME]Your assigned role is Healer.[]");
                    }
                    catch (Exception exception) {}
                    continue;
                }
                ay.ay_a().a(PartyRole.NONE);
                continue;
            }
            object = new aq(engine, this.character_name.get(i2), this.character_ordinal.get(i2), this.character_class.get(i2), this.character_outfit.get(i2), this.character_profile_background.get(i2), this.character_profile_effect_1.get(i2), this.character_profile_effect_2.get(i2), this.character_profile_effect_3.get(i2), this.fame.get(i2), this.rating.get(i2), this.memberMonths.get(i2), this.character_level.get(i2), this.character_spells.get(i2), 0, 0);
            if (this.role != null && !this.role.isEmpty()) {
                try {
                    ((br)object).a(this.role.get(i2));
                }
                catch (Exception exception) {
                    // empty catch block
                }
            }
            ay.ay_a().gf_a().a(engine, (br)object);
        }
        if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_h() != 1) {
            for (Object object : ay.ay_a().gf_a().a().values()) {
                if (((br)object).com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().int_h() != 1) continue;
                ((br)object).com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().void_a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_h());
                ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().void_a(1);
                break;
            }
        }
        if (engine.axc_a().getClass() == we.class) {
            we we2 = (we)engine.axc_a();
            System.out.println("PARTY TYPE: " + this.partyType);
            if (this.partyType == 0) {
                this.partyType = 1;
            }
            if (this.partyType == 1 || this.partyType == 2 || this.partyType == 3) {
                we2.wh_a().yp_a().a(this.partyType);
            }
            we2.wh_a().yp_a().b(this.partyType);
            we2.wh_a().a(engine, this.arenaTeamData);
            we2.wh_a().j();
        }
    }
}

