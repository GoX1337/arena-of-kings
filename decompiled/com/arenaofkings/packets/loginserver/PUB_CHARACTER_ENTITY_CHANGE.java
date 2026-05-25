/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.loginserver;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.CharacterClass;
import com.arenaofkings.packets.misc.ProfileBackgrounds;
import com.arenaofkings.packets.misc.PublicPacket;
import com.arenaofkings.packets.misc.items.ItemData;
import java.util.ArrayList;

public class PUB_CHARACTER_ENTITY_CHANGE
extends PublicPacket {
    private ProfileBackgrounds profileBackground;
    String profile_effect_1;
    String profile_effect_2;
    String profile_effect_3;
    private CharacterClass characterClass;
    private int outfitNumber;
    private int level;
    private int experience;
    private int fame;
    private int rating;
    private int displayRating;
    private String character_name_old;
    private String character_name_new;
    private String character_slot_1_spell_name;
    private String character_slot_2_spell_name;
    private String character_slot_3_spell_name;
    private String character_slot_4_spell_name;
    private String character_slot_5_spell_name;
    private String character_slot_6_spell_name;
    private String character_slot_7_spell_name;
    private String character_slot_8_spell_name;
    private ArrayList<ItemData> itemData = new ArrayList();

    public PUB_CHARACTER_ENTITY_CHANGE() {
    }

    public PUB_CHARACTER_ENTITY_CHANGE(ProfileBackgrounds profileBackgrounds, String string, String string2, String string3, CharacterClass characterClass, int n2, int n3, String string4, String string5, String string6, String string7, String string8, String string9, String string10, String string11, String string12, String string13) {
        this.profileBackground = profileBackgrounds;
        this.characterClass = characterClass;
        this.outfitNumber = n2;
        this.fame = n3;
        this.character_name_old = string4;
        this.character_name_new = string5;
        this.character_slot_1_spell_name = string6;
        this.character_slot_2_spell_name = string7;
        this.character_slot_3_spell_name = string8;
        this.character_slot_4_spell_name = string9;
        this.character_slot_5_spell_name = string10;
        this.character_slot_6_spell_name = string11;
        this.character_slot_7_spell_name = string12;
        this.character_slot_8_spell_name = string13;
    }

    @Override
    public void handle(Engine engine) {
        Engine.a("new PUB_CHARACTER_ENTITY_CHANGE");
        Engine.a("pre entities size: " + ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getCharacterEntities().size());
        if (this.character_name_new == null) {
            Engine.a("lol");
        } else {
            Engine.a("old name: " + this.character_name_old);
            br br2 = (br)ay.ay_a().gf_a().a().get(this.character_name_old);
            if (br2 != null) {
                Engine.a("1");
                if (ay.ay_a() == br2) {
                    Engine.a("in");
                    int n2 = 0;
                    for (ej ej2 : ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getCharacterEntities()) {
                        if (ej2.java_lang_String_a().equals(this.character_name_new) && ej2 != ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity()) {
                            Engine.a("wo going in");
                            for (ajw ajw2 : br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().a()) {
                                engine.b(ajw2);
                            }
                            for (ajw ajw2 : ej2.a()) {
                                engine.a(ajw2);
                            }
                            ej2.void_a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_h());
                            ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().setActive_character_entity(ej2);
                            br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().g(this.outfitNumber);
                            br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().a(this.profileBackground);
                            br2.a(this.fame);
                            if (this.profile_effect_1 == null || this.profile_effect_1 == "") {
                                br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().a(abi.L, 1);
                            } else {
                                br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().a(abi.valueOf(this.profile_effect_1), 1);
                            }
                            if (this.profile_effect_2 == null || this.profile_effect_2 == "") {
                                br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().a(abi.L, 2);
                            } else {
                                br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().a(abi.valueOf(this.profile_effect_2), 2);
                            }
                            if (this.profile_effect_3 == null || this.profile_effect_3 == "") {
                                br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().a(abi.L, 3);
                            } else {
                                br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().a(abi.valueOf(this.profile_effect_3), 3);
                            }
                            br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().cr_a().a(this.characterClass, null, this.outfitNumber);
                            ay.ay_a().gf_a().a().remove(this.character_name_old);
                            ay.ay_a().gf_a().a().put(this.character_name_new, br2);
                            Engine.a("me exists case");
                            ay.ay_a().gd_a().cg_a().void_d();
                            Engine.a("pre loadSpellBook");
                            if (t.a(we.class, engine)) {
                                Engine.a("loading spell table, outfit table, and profile.");
                                ((we)engine.axc_a()).wh_a().e();
                                ((we)engine.axc_a()).wh_a().ya_a().azq_a().a(engine);
                                ((we)engine.axc_a()).wh_a().ya_a().ayo_a().a(engine);
                                ((we)engine.axc_a()).wh_a().d();
                                ((we)engine.axc_a()).wh_a().yg_b().g();
                                ej2.a(ej2.com_arenaofkings_packets_misc_CharacterClass_a(), -1, -1);
                                engine.var_hg_a.a(ej2.gu_a().ui_arr_a());
                                ay.ay_a().gd_a().as_a().b(((we)engine.axc_a()).axm_a());
                                ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bd_a().void_a();
                                Engine.a("done loading");
                            }
                            return;
                        }
                        ++n2;
                    }
                    for (ej ej2 : ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getCharacterEntities()) {
                        ej2.bd_a().void_a();
                    }
                    Engine.a("Creating new character entity");
                    ej ej3 = new ej(engine, this.character_name_new, this.characterClass, this.character_slot_1_spell_name, this.character_slot_2_spell_name, this.character_slot_3_spell_name, this.character_slot_4_spell_name, this.character_slot_5_spell_name, this.character_slot_6_spell_name, this.character_slot_7_spell_name, this.character_slot_8_spell_name, -1, this.outfitNumber, this.profileBackground.name(), "PE_0", "PE_0", "PE_0", this.level, this.experience, 1500, 1500, 0, 0, 0, 0, this.displayRating, 0, 0, 0, this.itemData);
                    Engine.a("mid size pre: " + ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getCharacterEntities().size());
                    ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getCharacterEntities().add(ej3);
                    Engine.a("mid size post: " + ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getCharacterEntities().size());
                    br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().setActive_character_entity(ej3);
                    br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().a(engine, false);
                    br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().bd_a().a(ej3);
                    br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().g(this.outfitNumber);
                    br2.a(this.fame);
                    if (t.a(we.class, engine)) {
                        ((we)engine.axc_a()).wh_a().e();
                    }
                    br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().cr_a().a(this.characterClass, null, this.outfitNumber);
                    ay.ay_a().gf_a().a().remove(this.character_name_old);
                    ay.ay_a().gf_a().a().put(this.character_name_new, br2);
                    Engine.a("me new case");
                    ay.ay_a().gd_a().cg_a().void_d();
                    if (t.a(vj.class, engine)) {
                        engine.var_baa_a.a(ajw.kH, 1.0f);
                        engine.a(xw.class, null);
                    }
                    return;
                }
                Engine.a("wut");
                for (ajw ajw3 : br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().a()) {
                    engine.b(ajw3);
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.character_slot_1_spell_name);
                arrayList.add(this.character_slot_2_spell_name);
                arrayList.add(this.character_slot_3_spell_name);
                arrayList.add(this.character_slot_4_spell_name);
                arrayList.add(this.character_slot_5_spell_name);
                arrayList.add(this.character_slot_6_spell_name);
                arrayList.add(this.character_slot_7_spell_name);
                arrayList.add(this.character_slot_8_spell_name);
                Engine.a("1");
                if (this.profile_effect_1 == null || this.profile_effect_1 == "") {
                    this.profile_effect_1 = "PE_0";
                }
                if (this.profile_effect_2 == null || this.profile_effect_2 == "") {
                    this.profile_effect_2 = "PE_0";
                }
                if (this.profile_effect_3 == null || this.profile_effect_3 == "") {
                    this.profile_effect_3 = "PE_0";
                }
                int n3 = br2.int_b();
                Engine.a("2");
                ei ei2 = new ei(engine, this.character_name_new, br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().int_h(), this.characterClass, this.outfitNumber, this.profileBackground, this.profile_effect_1, this.profile_effect_2, this.profile_effect_3, this.fame, this.rating, n3, this.level, arrayList, (int)br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX(), (int)br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY());
                Engine.a("3");
                db db2 = br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().cr_a().db_a();
                Engine.a("4");
                br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().g(this.outfitNumber);
                Engine.a("5");
                br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().cr_a().a(this.characterClass, db2, this.outfitNumber);
                Engine.a("6");
                for (ajw ajw4 : ei2.a()) {
                    engine.a(ajw4);
                }
                Engine.a("7");
                br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().bd_a().a(ei2);
                Engine.a("8");
                br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().setActive_character_entity(ei2);
                Engine.a("9");
                br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().a(engine, false);
                Engine.a("10");
                br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().bd_a().a(ei2);
                Engine.a("11");
                br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().bd_a().a(this.profileBackground);
                br2.a(this.fame);
                Engine.a("12 check " + br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().bd_a().abi_a());
                br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().bd_a().a(abi.valueOf(this.profile_effect_1), 1);
                br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().bd_a().a(abi.valueOf(this.profile_effect_2), 2);
                br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().bd_a().a(abi.valueOf(this.profile_effect_3), 3);
                ay.ay_a().gf_a().a().remove(this.character_name_old);
                Engine.a("13");
                ay.ay_a().gf_a().a().put(this.character_name_new, br2);
                Engine.a("14");
                if (t.a(we.class, engine)) {
                    ((we)engine.axc_a()).wh_a().d();
                    Engine.a("15");
                    ((we)engine.axc_a()).wh_a().yg_b().g();
                    Engine.a("15.1");
                }
            } else {
                Engine.a("hoho");
            }
        }
        Engine.a("post entities size: " + ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getCharacterEntities().size());
        Engine.a("out of entity change");
    }
}

