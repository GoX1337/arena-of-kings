/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.CharacterClass;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class ahu
implements axr {
    private final Engine var_com_arenaofkings_client_core_Engine_a;
    private final br var_br_a;
    private int e;
    private ayh var_ayh_a;
    private ayh var_ayh_b;
    private ayh var_ayh_c;
    private agw var_agw_a;
    private agw var_agw_b;
    private ayh var_ayh_d;
    private ayg var_ayg_a;
    private boolean var_boolean_b;
    private float var_float_a = 1.0f;
    private azv var_azv_a = new azv(3000L, true);
    private da var_da_a;
    private da var_da_b;
    boolean var_boolean_a;
    int var_int_a = 24;
    int var_int_b = 971;
    int var_int_c = 618;
    int var_int_d = 80;

    public ahu(Engine engine, TextureAtlas textureAtlas, TextureAtlas textureAtlas2, br br2, boolean bl2) {
        this.var_com_arenaofkings_client_core_Engine_a = engine;
        this.var_br_a = br2;
        this.e = br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().int_h() - 1;
        this.var_boolean_a = bl2;
        if (bl2) {
            this.var_ayh_a = new ayh(this.var_int_a + 60 + this.e * 223, this.var_int_b + 0, textureAtlas, "modern_frame", true);
            this.var_ayh_b = new ayh(this.var_int_a + -5 + this.e * 226, this.var_int_b + -6, textureAtlas, "dragon", true);
            this.var_ayh_c = new ayh(this.var_int_a + 2 + this.e * 225, this.var_int_b + 0, textureAtlas, "modern_detail", true);
        }
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
        if (bl2) {
            this.var_agw_a.c(this.var_int_a + 75 + this.e * 223, this.var_int_b + 30);
        }
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
        if (bl2) {
            this.var_agw_b.c(this.var_int_a + 75 + this.e * 223, this.var_int_b + 11);
            this.var_ayh_d = new ayh(this.var_int_a + 1 + this.e * 224, this.var_int_b + 1, textureAtlas2, CharacterClass.simpleName(br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_misc_CharacterClass_a()), true);
        }
        this.var_ayg_a = new ahv(this, this.var_int_a + this.e * 224, this.var_int_b + 0, (this.e + 1) * 222, 92, br2, engine);
        this.var_da_a = new da(ajw.jg, "GCD_Flash", 0, 45, 0.02f, 0.0f, Animation.PlayMode.NORMAL, -65, -65);
        this.var_da_a.a(engine.axc_a().axm_a(), false, true);
        this.var_da_a.a(1550.0f, 415.0f);
        this.var_da_b = new da(ajw.jg, "GCD_Flash", 15, 45, 0.02f, 0.0f, Animation.PlayMode.LOOP, -65, -65);
        this.var_da_b.a(engine.axc_a().axm_a(), false, true);
        this.var_da_b.a(1550.0f, 415.0f);
    }

    @Override
    public void a(float f2, Engine engine) {
        this.var_ayg_a.b(engine);
        this.var_agw_a.a(this.var_br_a.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().double_a(), this.var_br_a.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().double_b());
        this.var_agw_b.a(this.var_br_a.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_resources_Resource_a().getCurrentValue(), this.var_br_a.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_resources_Resource_a().getMaxValue());
    }

    @Override
    public void b(float f2, Engine engine) {
        this.a(f2, engine);
        this.var_ayh_d.a(f2, engine, this.var_float_a);
        this.var_ayh_b.a(f2, engine, this.var_float_a);
        this.var_ayh_a.a(f2, engine, this.var_float_a);
        this.var_agw_a.a(f2, engine, this.var_float_a);
        this.var_agw_b.a(f2, engine, this.var_float_a);
        engine.a(this.var_br_a.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().java_lang_String_a(), engine.var_axy_b.a(), Color.WHITE, engine.var_axy_b.a(), Color.BLACK, (float)(this.var_int_a + 147 + this.e * 225), (float)(this.var_int_b + 62), 1, 1);
        engine.a(String.valueOf((int)this.var_br_a.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().double_a()), engine.var_axy_b.a(), Color.WHITE, engine.var_axy_b.a(), Color.BLACK, (float)(this.var_int_a + 147 + this.e * 224), (float)(this.var_int_b + 45), 1, 1);
        engine.a(String.valueOf((int)this.var_br_a.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_resources_Resource_a().getCurrentValue()), engine.var_axy_b.a(), Color.WHITE, engine.var_axy_b.a(), Color.BLACK, (float)(this.var_int_a + 147 + this.e * 224), (float)(this.var_int_b + 25), 1, 1);
    }

    static /* synthetic */ boolean a(ahu ahu2, boolean bl2) {
        ahu2.var_boolean_b = bl2;
        return ahu2.var_boolean_b;
    }
}

