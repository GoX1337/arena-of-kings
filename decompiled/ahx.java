/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.HitCircle;
import com.arenaofkings.packets.misc.CharacterClass;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class ahx
implements axr {
    private final Engine var_com_arenaofkings_client_core_Engine_a;
    private final br var_br_a;
    private int var_int_c;
    private ayh var_ayh_a;
    private ayh var_ayh_b;
    private ayh var_ayh_c;
    private agw var_agw_a;
    private agw var_agw_b;
    private agw var_agw_c;
    private agw var_agw_d;
    private agw var_agw_e;
    private agw var_agw_f;
    private agw var_agw_g;
    private agw var_agw_h;
    private agw var_agw_i;
    private agw var_agw_j;
    private agw var_agw_k;
    private agw var_agw_l;
    private agw var_agw_m;
    private ayh var_ayh_d;
    private ayh var_ayh_e;
    private ayh var_ayh_f;
    private ayh var_ayh_g;
    private ayh var_ayh_h;
    private ayh var_ayh_i;
    private ayh var_ayh_j;
    private ayh var_ayh_k;
    private ayh var_ayh_l;
    private ayh var_ayh_m;
    private ayg var_ayg_a;
    private boolean var_boolean_a;
    private float var_float_a = 1.0f;
    private int var_int_d = 1190;
    int var_int_a = -945;
    int var_int_b = 971;
    private azv var_azv_a = new azv(3000L, true);
    private da var_da_a;
    private da var_da_b;
    private HitCircle var_com_arenaofkings_packets_gameserver_data_HitCircle_a;

    public ahx(Engine engine, TextureAtlas textureAtlas, TextureAtlas textureAtlas2, br br2) {
        this.var_com_arenaofkings_client_core_Engine_a = engine;
        this.var_br_a = br2;
        this.var_int_c = br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().int_h() - 1;
        this.var_com_arenaofkings_packets_gameserver_data_HitCircle_a = new HitCircle(365.0f, 776.0f, 0);
        this.var_ayh_a = new ayh(this.var_int_a + this.var_int_d + 60 + this.var_int_c * 223, this.var_int_b + 0, textureAtlas, "modern_frame_flipped", true);
        this.var_ayh_b = new ayh(this.var_int_a + this.var_int_d + 235 + this.var_int_c * 223, this.var_int_b + 20, textureAtlas, "modern_dragon_flipped", true);
        this.var_ayh_c = new ayh(this.var_int_a + this.var_int_d + 252 + this.var_int_c * 225, this.var_int_b + 0, textureAtlas, "modern_detail", true);
        this.var_ayh_d = new ayh(this.var_int_a + this.var_int_d + 204 + this.var_int_c * 224, this.var_int_b + 1, textureAtlas2, CharacterClass.simpleName(CharacterClass.ASSASSIN), true);
        this.var_ayh_e = new ayh(this.var_int_a + this.var_int_d + 204 + this.var_int_c * 224, this.var_int_b + 1, textureAtlas2, CharacterClass.simpleName(CharacterClass.CHAMPION), true);
        this.var_ayh_f = new ayh(this.var_int_a + this.var_int_d + 204 + this.var_int_c * 224, this.var_int_b + 1, textureAtlas2, CharacterClass.simpleName(CharacterClass.ELDER), true);
        this.var_ayh_g = new ayh(this.var_int_a + this.var_int_d + 204 + this.var_int_c * 224, this.var_int_b + 1, textureAtlas2, CharacterClass.simpleName(CharacterClass.LICH), true);
        this.var_ayh_h = new ayh(this.var_int_a + this.var_int_d + 204 + this.var_int_c * 224, this.var_int_b + 1, textureAtlas2, CharacterClass.simpleName(CharacterClass.MYSTIC), true);
        this.var_ayh_i = new ayh(this.var_int_a + this.var_int_d + 204 + this.var_int_c * 224, this.var_int_b + 1, textureAtlas2, CharacterClass.simpleName(CharacterClass.NIHILIST), true);
        this.var_ayh_j = new ayh(this.var_int_a + this.var_int_d + 204 + this.var_int_c * 224, this.var_int_b + 1, textureAtlas2, CharacterClass.simpleName(CharacterClass.PALADIN), true);
        this.var_ayh_k = new ayh(this.var_int_a + this.var_int_d + 204 + this.var_int_c * 224, this.var_int_b + 1, textureAtlas2, CharacterClass.simpleName(CharacterClass.RANGER), true);
        this.var_ayh_l = new ayh(this.var_int_a + this.var_int_d + 204 + this.var_int_c * 224, this.var_int_b + 1, textureAtlas2, CharacterClass.simpleName(CharacterClass.SCHOLAR), true);
        this.var_ayh_m = new ayh(this.var_int_a + this.var_int_d + 204 + this.var_int_c * 224, this.var_int_b + 1, textureAtlas2, CharacterClass.simpleName(CharacterClass.WIZARD), true);
        this.var_agw_a = new agw(textureAtlas, "modern_health_background", "modern_health_assassin_full");
        this.var_agw_b = new agw(textureAtlas, "modern_health_background", "modern_health_champion_full");
        this.var_agw_c = new agw(textureAtlas, "modern_health_background", "modern_health_elder_full");
        this.var_agw_d = new agw(textureAtlas, "modern_health_background", "modern_health_lich_full");
        this.var_agw_e = new agw(textureAtlas, "modern_health_background", "modern_health_mystic_full");
        this.var_agw_f = new agw(textureAtlas, "modern_health_background", "modern_health_nihilist_full");
        this.var_agw_g = new agw(textureAtlas, "modern_health_background", "modern_health_paladin_full");
        this.var_agw_h = new agw(textureAtlas, "modern_health_background", "modern_health_ranger_full");
        this.var_agw_i = new agw(textureAtlas, "modern_health_background", "modern_health_scholar_full");
        this.var_agw_j = new agw(textureAtlas, "modern_health_background", "modern_health_wizard_full");
        this.var_agw_a.c(this.var_int_a + this.var_int_d + 61 + this.var_int_c * 223, this.var_int_b + 30);
        this.var_agw_b.c(this.var_int_a + this.var_int_d + 61 + this.var_int_c * 223, this.var_int_b + 30);
        this.var_agw_c.c(this.var_int_a + this.var_int_d + 61 + this.var_int_c * 223, this.var_int_b + 30);
        this.var_agw_d.c(this.var_int_a + this.var_int_d + 61 + this.var_int_c * 223, this.var_int_b + 30);
        this.var_agw_e.c(this.var_int_a + this.var_int_d + 61 + this.var_int_c * 223, this.var_int_b + 30);
        this.var_agw_f.c(this.var_int_a + this.var_int_d + 61 + this.var_int_c * 223, this.var_int_b + 30);
        this.var_agw_g.c(this.var_int_a + this.var_int_d + 61 + this.var_int_c * 223, this.var_int_b + 30);
        this.var_agw_h.c(this.var_int_a + this.var_int_d + 61 + this.var_int_c * 223, this.var_int_b + 30);
        this.var_agw_i.c(this.var_int_a + this.var_int_d + 61 + this.var_int_c * 223, this.var_int_b + 30);
        this.var_agw_j.c(this.var_int_a + this.var_int_d + 61 + this.var_int_c * 223, this.var_int_b + 30);
        this.var_agw_k = new agw(textureAtlas, "modern_resource_background", "modern_resource_mana_full");
        this.var_agw_l = new agw(textureAtlas, "modern_resource_background", "modern_resource_energy_full");
        this.var_agw_m = new agw(textureAtlas, "modern_resource_background", "modern_resource_rage_full");
        this.var_agw_k.c(this.var_int_a + this.var_int_d + 61 + this.var_int_c * 223, this.var_int_b + 11);
        this.var_agw_l.c(this.var_int_a + this.var_int_d + 61 + this.var_int_c * 223, this.var_int_b + 11);
        this.var_agw_m.c(this.var_int_a + this.var_int_d + 61 + this.var_int_c * 223, this.var_int_b + 11);
        this.var_ayg_a = new ahy(this, this.var_int_a + this.var_int_d + 60 + this.var_int_c * 224, this.var_int_b + 0, this.var_int_d + 30 + (this.var_int_c + 1) * 238, 92, br2, engine);
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
        switch (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_misc_CharacterClass_a()) {
            case ASSASSIN: {
                this.var_agw_a.a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().double_a(), ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().double_b());
                this.var_agw_l.a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_resources_Resource_a().getCurrentValue(), ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_resources_Resource_a().getMaxValue());
                break;
            }
            case CHAMPION: {
                this.var_agw_b.a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().double_a(), ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().double_b());
                this.var_agw_m.a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_resources_Resource_a().getCurrentValue(), ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_resources_Resource_a().getMaxValue());
                break;
            }
            case ELDER: {
                this.var_agw_c.a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().double_a(), ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().double_b());
                this.var_agw_k.a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_resources_Resource_a().getCurrentValue(), ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_resources_Resource_a().getMaxValue());
                break;
            }
            case LICH: {
                this.var_agw_d.a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().double_a(), ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().double_b());
                this.var_agw_k.a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_resources_Resource_a().getCurrentValue(), ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_resources_Resource_a().getMaxValue());
                break;
            }
            case MYSTIC: {
                this.var_agw_e.a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().double_a(), ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().double_b());
                this.var_agw_k.a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_resources_Resource_a().getCurrentValue(), ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_resources_Resource_a().getMaxValue());
                break;
            }
            case NIHILIST: {
                this.var_agw_f.a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().double_a(), ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().double_b());
                this.var_agw_k.a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_resources_Resource_a().getCurrentValue(), ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_resources_Resource_a().getMaxValue());
                break;
            }
            case PALADIN: {
                this.var_agw_g.a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().double_a(), ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().double_b());
                this.var_agw_k.a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_resources_Resource_a().getCurrentValue(), ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_resources_Resource_a().getMaxValue());
                break;
            }
            case RANGER: {
                this.var_agw_h.a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().double_a(), ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().double_b());
                this.var_agw_l.a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_resources_Resource_a().getCurrentValue(), ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_resources_Resource_a().getMaxValue());
                break;
            }
            case SCHOLAR: {
                this.var_agw_i.a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().double_a(), ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().double_b());
                this.var_agw_k.a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_resources_Resource_a().getCurrentValue(), ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_resources_Resource_a().getMaxValue());
                break;
            }
            case WIZARD: {
                this.var_agw_j.a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().double_a(), ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().double_b());
                this.var_agw_k.a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_resources_Resource_a().getCurrentValue(), ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_resources_Resource_a().getMaxValue());
                break;
            }
        }
    }

    @Override
    public void b(float f2, Engine engine) {
        if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a() == null) {
            return;
        }
        if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer() == null) {
            return;
        }
        this.a(f2, engine);
        switch (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_misc_CharacterClass_a()) {
            case ASSASSIN: {
                this.var_ayh_d.b(f2, engine);
                break;
            }
            case CHAMPION: {
                this.var_ayh_e.b(f2, engine);
                break;
            }
            case ELDER: {
                this.var_ayh_f.b(f2, engine);
                break;
            }
            case LICH: {
                this.var_ayh_g.b(f2, engine);
                break;
            }
            case MYSTIC: {
                this.var_ayh_h.b(f2, engine);
                break;
            }
            case NIHILIST: {
                this.var_ayh_i.b(f2, engine);
                break;
            }
            case PALADIN: {
                this.var_ayh_j.b(f2, engine);
                break;
            }
            case RANGER: {
                this.var_ayh_k.b(f2, engine);
                break;
            }
            case SCHOLAR: {
                this.var_ayh_l.b(f2, engine);
                break;
            }
            case WIZARD: {
                this.var_ayh_m.b(f2, engine);
                break;
            }
        }
        this.var_ayh_b.a(f2, engine, this.var_float_a);
        this.var_ayh_a.a(f2, engine, this.var_float_a);
        switch (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_misc_CharacterClass_a()) {
            case ASSASSIN: {
                this.var_ayh_d.b(f2, engine);
                this.var_agw_a.a(f2, engine, this.var_float_a);
                this.var_agw_l.a(f2, engine, this.var_float_a);
                break;
            }
            case CHAMPION: {
                this.var_ayh_e.b(f2, engine);
                this.var_agw_b.a(f2, engine, this.var_float_a);
                this.var_agw_m.a(f2, engine, this.var_float_a);
                break;
            }
            case ELDER: {
                this.var_ayh_f.b(f2, engine);
                this.var_agw_c.a(f2, engine, this.var_float_a);
                this.var_agw_k.a(f2, engine, this.var_float_a);
                break;
            }
            case LICH: {
                this.var_ayh_g.b(f2, engine);
                this.var_agw_d.a(f2, engine, this.var_float_a);
                this.var_agw_k.a(f2, engine, this.var_float_a);
                break;
            }
            case MYSTIC: {
                this.var_ayh_h.b(f2, engine);
                this.var_agw_e.a(f2, engine, this.var_float_a);
                this.var_agw_k.a(f2, engine, this.var_float_a);
                break;
            }
            case NIHILIST: {
                this.var_ayh_i.b(f2, engine);
                this.var_agw_f.a(f2, engine, this.var_float_a);
                this.var_agw_k.a(f2, engine, this.var_float_a);
                break;
            }
            case PALADIN: {
                this.var_ayh_j.b(f2, engine);
                this.var_agw_g.a(f2, engine, this.var_float_a);
                this.var_agw_k.a(f2, engine, this.var_float_a);
                break;
            }
            case RANGER: {
                this.var_ayh_k.b(f2, engine);
                this.var_agw_h.a(f2, engine, this.var_float_a);
                this.var_agw_l.a(f2, engine, this.var_float_a);
                break;
            }
            case SCHOLAR: {
                this.var_ayh_l.b(f2, engine);
                this.var_agw_i.a(f2, engine, this.var_float_a);
                this.var_agw_k.a(f2, engine, this.var_float_a);
                break;
            }
            case WIZARD: {
                this.var_ayh_m.b(f2, engine);
                this.var_agw_j.a(f2, engine, this.var_float_a);
                this.var_agw_k.a(f2, engine, this.var_float_a);
                break;
            }
        }
        engine.a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().java_lang_String_a(), engine.var_axy_b.a(), axe.A, engine.var_axy_b.a(), Color.BLACK, (float)(this.var_int_a + this.var_int_d + 132 + this.var_int_c * 224), (float)(this.var_int_b + 62), 1, 1);
        engine.a(String.valueOf((int)ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().double_a()), engine.var_axy_b.a(), Color.WHITE, engine.var_axy_b.a(), Color.BLACK, (float)(this.var_int_a + this.var_int_d + 132 + this.var_int_c * 224), (float)(this.var_int_b + 45), 1, 1);
        engine.a(String.valueOf((int)ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_resources_Resource_a().getCurrentValue()), engine.var_axy_b.a(), Color.WHITE, engine.var_axy_b.a(), Color.BLACK, (float)(this.var_int_a + this.var_int_d + 132 + this.var_int_c * 224), (float)(this.var_int_b + 25), 1, 1);
        if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a() != null && ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer() != null) {
            if (ay.ay_a().gf_a().a().containsValue(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer())) {
                ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_EffectManager_a().renderTopHudIconsAlly(f2, engine, this.var_com_arenaofkings_packets_gameserver_data_HitCircle_a);
            } else if (ay.ay_a().ge_a().a().containsValue(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer())) {
                ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_EffectManager_a().renderTopHudIconsEnemy(f2, engine, this.var_com_arenaofkings_packets_gameserver_data_HitCircle_a);
            }
        }
    }

    static /* synthetic */ boolean a(ahx ahx2, boolean bl2) {
        ahx2.var_boolean_a = bl2;
        return ahx2.var_boolean_a;
    }
}

