/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.CharacterClass;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class aha
implements axr {
    private final Engine var_com_arenaofkings_client_core_Engine_a;
    private final br var_br_a;
    private int var_int_d;
    private ayh var_ayh_a;
    private ayh var_ayh_b;
    private ayh var_ayh_c;
    private agw var_agw_a;
    private agw var_agw_b;
    private ayh var_ayh_d;
    private ayg var_ayg_a;
    private boolean var_boolean_a;
    private float var_float_a = 0.8f;
    private int e = 1190;
    private azv var_azv_a = new azv(3000L, true);
    private da var_da_a;
    private da var_da_b;
    int var_int_a = 0;
    int var_int_b = 0;
    @Deprecated
    int var_int_c = 0;
    private azv var_azv_b = new azv(1000L, true);

    public aha(Engine engine, TextureAtlas textureAtlas, TextureAtlas textureAtlas2, br br2) {
        this.var_com_arenaofkings_client_core_Engine_a = engine;
        this.var_br_a = br2;
        this.var_int_d = br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().int_h() - 1;
        this.var_int_c = 0;
        if (br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().int_h() == 1) {
            this.var_int_a = engine.var_aj_a.int_a(ai.I);
            this.var_int_b = engine.var_aj_a.int_a(ai.J);
        } else if (br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().int_h() == 2) {
            this.var_int_a = engine.var_aj_a.int_a(ai.L);
            this.var_int_b = engine.var_aj_a.int_a(ai.M);
        } else if (br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().int_h() == 3) {
            this.var_int_a = engine.var_aj_a.int_a(ai.O);
            this.var_int_b = engine.var_aj_a.int_a(ai.P);
        }
        this.var_ayh_a = new ayh(60, 0, textureAtlas, "modern_frame_flipped", true);
        this.var_ayh_b = new ayh(-5, 20, textureAtlas, "modern_dragon_flipped", true);
        this.var_ayh_c = new ayh(2, 0, textureAtlas, "modern_detail", true);
        switch (br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_misc_CharacterClass_a()) {
            case ASSASSIN: {
                this.var_agw_a = new agw(textureAtlas, "modern_health_background", "modern_health_assassin_full");
                break;
            }
            case CHAMPION: {
                this.var_agw_a = new agw(textureAtlas, "modern_health_background", "modern_health_champion_full");
                break;
            }
            case ELDER: {
                this.var_agw_a = new agw(textureAtlas, "modern_health_background", "modern_health_elder_full");
                break;
            }
            case LICH: {
                this.var_agw_a = new agw(textureAtlas, "modern_health_background", "modern_health_lich_full");
                break;
            }
            case MYSTIC: {
                this.var_agw_a = new agw(textureAtlas, "modern_health_background", "modern_health_mystic_full");
                break;
            }
            case NIHILIST: {
                this.var_agw_a = new agw(textureAtlas, "modern_health_background", "modern_health_nihilist_full");
                break;
            }
            case PALADIN: {
                this.var_agw_a = new agw(textureAtlas, "modern_health_background", "modern_health_paladin_full");
                break;
            }
            case RANGER: {
                this.var_agw_a = new agw(textureAtlas, "modern_health_background", "modern_health_ranger_full");
                break;
            }
            case SCHOLAR: {
                this.var_agw_a = new agw(textureAtlas, "modern_health_background", "modern_health_scholar_full");
                break;
            }
            case WIZARD: {
                this.var_agw_a = new agw(textureAtlas, "modern_health_background", "modern_health_wizard_full");
                break;
            }
            default: {
                this.var_agw_a = new agw(textureAtlas, "modern_health_background", "modern_health_assassin_full");
            }
        }
        this.var_agw_a.c(75.0f, 30.0f);
        switch (br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_resources_Resource_a().getResourceType()) {
            case c: {
                this.var_agw_b = new agw(textureAtlas, "modern_resource_background", "modern_resource_mana_full");
                break;
            }
            case d: {
                System.out.println("Loaded energy bar");
                this.var_agw_b = new agw(textureAtlas, "modern_resource_background", "modern_resource_energy_full");
                break;
            }
            case e: {
                this.var_agw_b = new agw(textureAtlas, "modern_resource_background", "modern_resource_rage_full");
                break;
            }
            default: {
                this.var_agw_b = new agw(textureAtlas, "modern_resource_background", "modern_resource_mana_full");
            }
        }
        if (this.var_agw_b == null) {
            System.out.println("resource bar is null");
        }
        System.out.println("unoffsetting");
        this.var_agw_b.c(75.0f, 11.0f);
        this.var_ayh_d = new ayh(1, 1, textureAtlas2, CharacterClass.simpleName(br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_misc_CharacterClass_a()), true);
        this.var_ayg_a = new ahb(this, this.e + 60 + this.var_int_d * 224, 0, this.e + 30 + (this.var_int_d + 1) * 238, 92, br2, engine);
        this.var_da_a = new da(ajw.jg, "GCD_Flash", 0, 45, 0.02f, 0.0f, Animation.PlayMode.NORMAL, -65, -65);
        this.var_da_a.a(engine.axc_a().axm_a(), false, true);
        this.var_da_a.a(1550.0f, 415.0f);
        this.var_da_b = new da(ajw.jg, "GCD_Flash", 15, 45, 0.02f, 0.0f, Animation.PlayMode.LOOP, -65, -65);
        this.var_da_b.a(engine.axc_a().axm_a(), false, true);
        this.var_da_b.a(1550.0f, 415.0f);
    }

    @Override
    public void a(float f2, Engine engine) {
        if (this.var_azv_b.boolean_b()) {
            this.var_azv_b.void_c();
            if (this.var_br_a.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().int_h() == 1) {
                this.var_int_a = engine.var_aj_a.int_a(ai.I);
                this.var_int_b = engine.var_aj_a.int_a(ai.J);
            } else if (this.var_br_a.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().int_h() == 2) {
                this.var_int_a = engine.var_aj_a.int_a(ai.L);
                this.var_int_b = engine.var_aj_a.int_a(ai.M);
            } else if (this.var_br_a.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().int_h() == 3) {
                this.var_int_a = engine.var_aj_a.int_a(ai.O);
                this.var_int_b = engine.var_aj_a.int_a(ai.P);
            }
            this.var_int_c = 0;
            this.var_ayg_a.a(63 + this.var_int_a + this.var_int_c - 1, this.var_int_b + 4, 63 + this.var_int_a + this.var_int_c - 3 + 221, this.var_int_b + 68);
        }
        this.var_ayg_a.b(engine);
        this.var_agw_a.a(this.var_br_a.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().double_a(), this.var_br_a.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().double_b());
        this.var_agw_b.a(this.var_br_a.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_resources_Resource_a().getCurrentValue(), this.var_br_a.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_resources_Resource_a().getMaxValue());
    }

    @Override
    public void b(float f2, Engine engine) {
        this.a(f2, engine);
        this.var_float_a = ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer() == this.var_br_a ? 1.0f : (this.var_boolean_a ? 0.9f : 0.75f);
        if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer() == this.var_br_a) {
            this.var_da_b.a(f2, engine);
        }
        this.var_ayh_d.a(f2, engine, 204 + this.var_int_d * (this.var_int_c - 1) + this.var_int_a + this.var_ayh_d.int_b(), this.var_int_b + this.var_ayh_d.int_c(), this.var_float_a);
        this.var_ayh_b.a(f2, engine, 235 + this.var_int_d * (this.var_int_c + 1) + this.var_int_a + this.var_ayh_b.int_b(), this.var_int_b + this.var_ayh_b.int_c(), this.var_float_a);
        this.var_ayh_a.a(f2, engine, this.var_int_a + this.var_ayh_a.int_b(), this.var_int_b + this.var_ayh_a.int_c(), this.var_float_a);
        this.var_agw_a.a(f2, engine, -14 + this.var_int_d * this.var_int_c + this.var_int_a + this.var_agw_a.a().int_b(), this.var_int_b + this.var_agw_a.a().int_c(), this.var_float_a);
        this.var_agw_b.a(f2, engine, -14 + this.var_int_d * this.var_int_c + this.var_int_a + this.var_agw_b.a().int_b(), this.var_int_b + this.var_agw_b.a().int_c(), this.var_float_a);
        engine.a(this.var_br_a.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().java_lang_String_a(), engine.var_axy_b.a(), Color.WHITE, engine.var_axy_b.a(), Color.BLACK, (float)(this.var_int_a + 132 + this.var_int_d * this.var_int_c), (float)(this.var_int_b + 62), 1, 1);
        engine.a(String.valueOf((int)this.var_br_a.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().double_a()), engine.var_axy_b.a(), Color.WHITE, engine.var_axy_b.a(), Color.BLACK, (float)(this.var_int_a + 132 + this.var_int_d * this.var_int_c), (float)(this.var_int_b + 45), 1, 1);
        engine.a(String.valueOf((int)this.var_br_a.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_resources_Resource_a().getCurrentValue()), engine.var_axy_b.a(), Color.WHITE, engine.var_axy_b.a(), Color.BLACK, (float)(this.var_int_a + 132 + this.var_int_d * this.var_int_c), (float)(this.var_int_b + 25), 1, 1);
    }

    static /* synthetic */ boolean a(aha aha2, boolean bl2) {
        aha2.var_boolean_a = bl2;
        return aha2.var_boolean_a;
    }
}

