/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.InputIdentifier;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class ahi
implements axr {
    private final Engine var_com_arenaofkings_client_core_Engine_a;
    private final br var_br_a;
    private int var_int_a;
    private ayh var_ayh_a;
    private ayh var_ayh_b;
    private agw var_agw_a;
    private ayg var_ayg_a;
    private boolean var_boolean_a;
    private float var_float_a = 0.8f;
    private da var_da_a;
    private da var_da_b;
    private String var_java_lang_String_a;

    public ahi(Engine engine, TextureAtlas textureAtlas, TextureAtlas textureAtlas2, br br2) {
        this.var_com_arenaofkings_client_core_Engine_a = engine;
        this.var_br_a = br2;
        this.var_int_a = br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().int_h() - 1;
        this.var_ayh_a = new ayh(742 + this.var_int_a * 144, 136, textureAtlas, "tab_frame", true);
        this.var_ayh_b = new ayh(742 + this.var_int_a * 144, 136, textureAtlas, "tab_frame_glow", true);
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
        if (this.var_int_a == 0) {
            if (engine.var_agc_a.a().get(InputIdentifier.TARGET_SELF) != null) {
                this.var_java_lang_String_a = engine.var_agc_a.a(InputIdentifier.TARGET_SELF);
            }
        } else if (this.var_int_a == 1) {
            if (engine.var_agc_a.a().get(InputIdentifier.TARGET_ALLY_2) != null) {
                this.var_java_lang_String_a = engine.var_agc_a.a(InputIdentifier.TARGET_ALLY_2);
            }
        } else if (this.var_int_a == 2 && engine.var_agc_a.a().get(InputIdentifier.TARGET_ALLY_3) != null) {
            this.var_java_lang_String_a = engine.var_agc_a.a(InputIdentifier.TARGET_ALLY_3);
        }
        if (this.var_java_lang_String_a.length() > 4) {
            this.var_java_lang_String_a = this.var_java_lang_String_a.substring(0, 4);
        }
        this.var_agw_a.c(744 + this.var_int_a * 144, 137.0f);
        this.var_ayg_a = new ahj(this, 742 + this.var_int_a * 144, 138, 885 + this.var_int_a * 143, 174, br2, engine);
        this.var_da_a = new da(ajw.jg, "GCD_Flash", 0, 45, 0.02f, 0.0f, Animation.PlayMode.NORMAL, -65, -65);
        this.var_da_a.a(engine.axc_a().axm_a(), false, true);
        this.var_da_a.a(1550.0f, 415.0f);
        this.var_da_b = new da(ajw.jg, "GCD_Flash", 15, 45, 0.02f, 0.0f, Animation.PlayMode.LOOP, -65, -65);
        this.var_da_b.d(-0.6f);
        this.var_da_b.a(engine.axc_a().axm_a(), false, true);
        this.var_da_b.a(1550.0f, 415.0f);
    }

    @Override
    public void a(float f2, Engine engine) {
        this.var_ayg_a.b(engine);
        this.var_agw_a.a(this.var_br_a.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().double_a(), this.var_br_a.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().double_b());
    }

    @Override
    public void b(float f2, Engine engine) {
        this.a(f2, engine);
        this.var_float_a = ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer() == this.var_br_a ? 1.0f : (this.var_boolean_a ? 0.9f : 0.75f);
        if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer() == this.var_br_a) {
            this.var_ayh_b.a(f2, engine.var_azi_a, 740 + this.var_int_a * 144, 155, 1.0f);
        }
        this.var_ayh_a.b(f2, engine);
        this.var_agw_a.a(f2, engine, this.var_float_a);
        engine.a(this.var_br_a.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().java_lang_String_a(), engine.var_axy_b.a(), Color.WHITE, engine.var_axy_b.a(), Color.BLACK, (float)(815 + this.var_int_a * 144), 166.0f, 1, 1);
        if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer() == this.var_br_a) {
            if (this.var_java_lang_String_a.length() > 2) {
                engine.a(this.var_java_lang_String_a, engine.var_axy_a.a(), Color.YELLOW, engine.var_axy_a.a(), Color.BLACK, (float)(815 + this.var_int_a * 144), 184.0f, 1, 1);
            } else {
                engine.a(this.var_java_lang_String_a, engine.var_axy_b.a(), Color.YELLOW, engine.var_axy_b.a(), Color.BLACK, (float)(815 + this.var_int_a * 144), 184.0f, 1, 1);
            }
        } else if (this.var_java_lang_String_a.length() > 2) {
            engine.a(this.var_java_lang_String_a, engine.var_axy_a.a(), Color.LIGHT_GRAY, engine.var_axy_a.a(), Color.BLACK, (float)(815 + this.var_int_a * 144), 184.0f, 1, 1);
        } else {
            engine.a(this.var_java_lang_String_a, engine.var_axy_b.a(), Color.LIGHT_GRAY, engine.var_axy_b.a(), Color.BLACK, (float)(815 + this.var_int_a * 144), 184.0f, 1, 1);
        }
    }

    static /* synthetic */ boolean a(ahi ahi2, boolean bl2) {
        ahi2.var_boolean_a = bl2;
        return ahi2.var_boolean_a;
    }
}

