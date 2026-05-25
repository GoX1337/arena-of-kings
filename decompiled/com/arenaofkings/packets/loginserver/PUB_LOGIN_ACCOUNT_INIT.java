/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.loginserver;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.player.me.MyAccountData;
import com.arenaofkings.packets.loginserver.PUB_CHARACTER_SELECT_REQUEST;
import com.arenaofkings.packets.loginserver.PUB_FRIEND_STATUS_UPDATE;
import com.arenaofkings.packets.loginserver.PUB_KEYBIND_UPDATE;
import com.arenaofkings.packets.loginserver.PUB_MISC_REGION_CHANGE;
import com.arenaofkings.packets.misc.ArenaTeamData;
import com.arenaofkings.packets.misc.CharacterClass;
import com.arenaofkings.packets.misc.PublicPacket;
import com.arenaofkings.packets.misc.StripeCustomerData;
import com.arenaofkings.packets.misc.items.ItemData;
import java.util.ArrayList;
import java.util.HashMap;

public class PUB_LOGIN_ACCOUNT_INIT
extends PublicPacket {
    private int account_gold;
    private int ability_essence;
    private String account_name;
    private int account_wins;
    private int account_losses;
    private int account_fame;
    private String account_createdate;
    private int account_played_time;
    private int account_member;
    private String account_member_startdate;
    private String account_member_expiredate;
    private boolean account_member_active_subscription;
    private double account_rating;
    private ArrayList<CharacterClass> character_class = new ArrayList();
    private ArrayList<String> character_slot_1_spell_names = new ArrayList();
    private ArrayList<String> character_slot_2_spell_names = new ArrayList();
    private ArrayList<String> character_slot_3_spell_names = new ArrayList();
    private ArrayList<String> character_slot_4_spell_names = new ArrayList();
    private ArrayList<String> character_slot_5_spell_names = new ArrayList();
    private ArrayList<String> character_slot_6_spell_names = new ArrayList();
    private ArrayList<String> character_slot_7_spell_names = new ArrayList();
    private ArrayList<String> character_slot_8_spell_names = new ArrayList();
    private ArrayList<String> character_kingdom = new ArrayList();
    private ArrayList<Integer> character_outfit = new ArrayList();
    private ArrayList<Integer> character_id = new ArrayList();
    private ArrayList<Integer> character_level = new ArrayList();
    private ArrayList<Integer> character_arena_points = new ArrayList();
    private ArrayList<Integer> character_experience = new ArrayList();
    private ArrayList<String> character_name = new ArrayList();
    private ArrayList<String> character_profile_background = new ArrayList();
    private ArrayList<String> character_profile_effect_1 = new ArrayList();
    private ArrayList<String> character_profile_effect_2 = new ArrayList();
    private ArrayList<String> character_profile_effect_3 = new ArrayList();
    private ArrayList<Double> character_rating = new ArrayList();
    private ArrayList<Double> character_rating_deviation = new ArrayList();
    private ArrayList<Double> character_rating_volatility = new ArrayList();
    private ArrayList<Double> character_solo_rating = new ArrayList();
    private ArrayList<Double> character_solo_rating_deviation = new ArrayList();
    private ArrayList<Double> character_solo_rating_volatility = new ArrayList();
    private ArrayList<Integer> character_display_rating = new ArrayList();
    private ArrayList<Integer> character_display_rating_active = new ArrayList();
    private ArrayList<Integer> character_wins = new ArrayList();
    private ArrayList<Integer> character_losses = new ArrayList();
    private ArrayList<Integer> character_solo_wins = new ArrayList();
    private ArrayList<Integer> character_solo_losses = new ArrayList();
    private ArrayList<Integer> character_daily_games = new ArrayList();
    private ArrayList<Integer> character_weekly_games = new ArrayList();
    private String UUID;
    private ArrayList<StripeCustomerData> stripeCustomerData = new ArrayList();
    private int last_login_index;
    private String stripe_cust_id;
    private String user_email;
    private int villain_coins;
    private ArrayList<String> unlocked_content = new ArrayList();
    private String privilege;
    private int character_slots;
    private int stash_tabs;
    private String raf;
    private String affiliate;
    private HashMap<String, ArrayList<ItemData>> equippedData = new HashMap();
    private ArrayList<ItemData> inventoryData = new ArrayList();
    private ArrayList<ItemData> stashData = new ArrayList();
    private ArrayList<String> clientChannels = new ArrayList();
    private ArrayList<String> worldPlayers = new ArrayList();
    private ArrayList<String> channel2Players = new ArrayList();
    private ArrayList<String> channel3Players = new ArrayList();
    private ArrayList<PUB_FRIEND_STATUS_UPDATE> friends_list = new ArrayList();
    private ArrayList<PUB_KEYBIND_UPDATE> keybind_update = new ArrayList();
    private ArrayList<ArenaTeamData> arena_teams = new ArrayList();
    private String invalidPassword = "";

    public PUB_LOGIN_ACCOUNT_INIT() {
    }

    public PUB_LOGIN_ACCOUNT_INIT(String string, ArrayList<String> arrayList, int n2, ArrayList<String> arrayList2) {
        this.UUID = string;
        this.character_name = arrayList;
        this.account_gold = n2;
        this.clientChannels = arrayList2;
    }

    @Override
    public void handle(Engine engine) {
        Object object;
        engine.var_baa_a.a(ajw.kH, 1.0f);
        Engine.a("PUB_LOGIN_ACCOUNT_INIT()");
        Engine.a(this.toString());
        Engine.b("unlocked content");
        for (String object22 : this.unlocked_content) {
            Engine.b(object22);
        }
        System.out.println("Flist size: " + this.friends_list.size());
        for (PUB_FRIEND_STATUS_UPDATE pUB_FRIEND_STATUS_UPDATE : this.friends_list) {
            System.out.println("Friend update: " + pUB_FRIEND_STATUS_UPDATE.toString());
        }
        ay.ay_a().b(Integer.valueOf(this.account_member_startdate));
        System.out.println("Load my data");
        ay.ay_a().a(engine, new gd(engine, this.UUID, this.account_gold, this.ability_essence, (int)this.account_rating, this.account_wins, this.account_losses, this.account_fame, this.account_member, this.account_member_active_subscription, this.account_member_expiredate, this.character_slots, this.stash_tabs, new ev(this.clientChannels, this.worldPlayers, this.channel2Players, this.channel3Players, engine), new axz(this.friends_list), this.stripeCustomerData, this.villain_coins, this.unlocked_content, this.privilege, this.arena_teams, this.inventoryData, this.stashData), new MyAccountData(engine, this.account_name, 1, this.character_class, this.character_slot_1_spell_names, this.character_slot_2_spell_names, this.character_slot_3_spell_names, this.character_slot_4_spell_names, this.character_slot_5_spell_names, this.character_slot_6_spell_names, this.character_slot_7_spell_names, this.character_slot_8_spell_names, this.character_name, this.character_id, this.character_outfit, this.character_profile_background, this.character_profile_effect_1, this.character_profile_effect_2, this.character_profile_effect_3, this.character_level, this.character_experience, this.character_rating, this.character_solo_rating, this.character_wins, this.character_losses, this.character_solo_wins, this.character_solo_losses, this.character_display_rating, this.character_arena_points, this.character_daily_games, this.character_weekly_games, this.last_login_index, this.equippedData));
        if (t.a(aes.class, engine)) {
            if (engine.var_aj_a.boolean_a(ak.var_ak_a)) {
                object = (aes)engine.axc_a();
                aex aex2 = (aex)((axc)object).aya_a();
                engine.var_aj_a.a(ak.b, aex2.com_badlogic_gdx_scenes_scene2d_ui_TextField_a().getText());
            }
            object = (aes)engine.axc_a();
            ((aes)object).a(this);
        }
        engine.var_z_a.a(axn.c);
        Engine.a("Out of loadMyData");
        if (this.invalidPassword.equals("invalid")) {
            object = (aes)engine.axc_a();
            aex aex3 = (aex)((axc)object).aya_a();
            aex3.m();
            return;
        }
        if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getCharacterEntities().isEmpty()) {
            engine.a(wb.class, new wd(false));
        } else {
            engine.var_z_a.void_a(new PUB_CHARACTER_SELECT_REQUEST(this.character_name.get(0)));
            ay.ay_a().gd_a().ev_a().en_a().a(this.character_name.get(0));
            engine.var_agc_a = new agc(this.keybind_update);
            engine.a(xw.class, new xz(true));
        }
        System.out.println("Create region change");
        object = new PUB_MISC_REGION_CHANGE();
        ((PUB_MISC_REGION_CHANGE)object).setUSvalue(engine.var_aj_a.boolean_a(ai.e));
        ((PUB_MISC_REGION_CHANGE)object).setEUvalue(engine.var_aj_a.boolean_a(ai.f));
        ((PUB_MISC_REGION_CHANGE)object).setPreference(engine.var_ag_a.ab_a().com_arenaofkings_packets_misc_Region_a());
        engine.var_z_a.void_a(object);
    }

    public void setInvalidPassword(String string) {
        this.invalidPassword = string;
    }

    public String toString() {
        return "PUB_LOGIN_ACCOUNT_INIT [account_gold=" + this.account_gold + ", account_name=" + this.account_name + ", character_class=" + this.character_class + ", character_slot_1_spell_names=" + this.character_slot_1_spell_names + ", character_slot_2_spell_names=" + this.character_slot_2_spell_names + ", character_slot_3_spell_names=" + this.character_slot_3_spell_names + ", character_slot_4_spell_names=" + this.character_slot_4_spell_names + ", character_slot_5_spell_names=" + this.character_slot_5_spell_names + ", character_slot_6_spell_names\t\t=" + this.character_slot_6_spell_names + ", character_kingdom=" + this.character_kingdom + ", character_outfit=" + this.character_outfit + ", character_id=" + this.character_id + ", character_level=" + this.character_level + ", character_name=" + this.character_name + ", UUID=" + this.UUID + ", clientChannels=" + this.clientChannels + "]";
    }
}

