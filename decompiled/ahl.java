/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.CharacterClass;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ahl
implements axr {
    private Map<CharacterClass, ayh> cfr_renamed_8;
    private ayh var_ayh_a;
    private CharacterClass var_com_arenaofkings_packets_misc_CharacterClass_a;
    private ayh var_ayh_b;
    private ayh var_ayh_c;
    private agw var_agw_a;
    private agw var_agw_b;
    private agw var_agw_c;
    private agw var_agw_d;
    private agw e;
    private ayh var_ayh_d;

    public ahl(TextureAtlas textureAtlas, TextureAtlas textureAtlas2, CharacterClass characterClass) {
        this.var_ayh_b = new ayh(1200, 5, textureAtlas, "dragon", true);
        this.var_ayh_c = new ayh(1210, 5, textureAtlas, "portrait_target", true);
        this.var_agw_a = new agw(textureAtlas, "portrait_health_background", "portrait_health_full");
        this.var_agw_a.a(1287.0f, 41.0f);
        this.var_agw_b = new agw(textureAtlas, "portrait_mana_background", "portrait_mana_full");
        this.var_agw_c = new agw(textureAtlas, "portrait_energy_background", "portrait_energy_full");
        this.var_agw_d = new agw(textureAtlas, "portrait_rage_background", "portrait_rage_full");
        this.var_agw_b.a(1287.0f, 26.0f);
        this.var_agw_c.a(1287.0f, 26.0f);
        this.var_agw_d.a(1287.0f, 26.0f);
        this.e = new agw(textureAtlas, "portrait_cast_background", "portrait_cast_full");
        this.e.a(1287.0f, 13.0f);
        this.var_ayh_d = new ayh(0, 0, textureAtlas, "portrait_cast_flare", true);
        this.cfr_renamed_8 = new HashMap<CharacterClass, ayh>();
        this.cfr_renamed_8.put(CharacterClass.ASSASSIN, new ayh(1212, 10, textureAtlas2, "Assassin", true));
        this.cfr_renamed_8.put(CharacterClass.CHAMPION, new ayh(1212, 10, textureAtlas2, "Champion", true));
        this.cfr_renamed_8.put(CharacterClass.ELDER, new ayh(1212, 10, textureAtlas2, "Elder", true));
        this.cfr_renamed_8.put(CharacterClass.LICH, new ayh(1212, 10, textureAtlas2, "Lich", true));
        this.cfr_renamed_8.put(CharacterClass.MYSTIC, new ayh(1212, 10, textureAtlas2, "Mystic", true));
        this.cfr_renamed_8.put(CharacterClass.NIHILIST, new ayh(1212, 10, textureAtlas2, "Nihilist", true));
        this.cfr_renamed_8.put(CharacterClass.PALADIN, new ayh(1212, 10, textureAtlas2, "Paladin", true));
        this.cfr_renamed_8.put(CharacterClass.RANGER, new ayh(1212, 10, textureAtlas2, "Ranger", true));
        this.cfr_renamed_8.put(CharacterClass.SCHOLAR, new ayh(1212, 10, textureAtlas2, "Scholar", true));
        this.cfr_renamed_8.put(CharacterClass.WIZARD, new ayh(1212, 10, textureAtlas2, "Wizard", true));
        this.a(characterClass);
    }

    @Override
    public void a(float f2, Engine engine) {
        if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer() != null) {
            this.var_agw_a.a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().double_a(), ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().double_b());
            switch (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_resources_Resource_a().getResourceType()) {
                case c: {
                    this.var_agw_b.a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_resources_Resource_a().getCurrentValue(), ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_resources_Resource_a().getMaxValue());
                    break;
                }
                case d: {
                    this.var_agw_c.a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_resources_Resource_a().getCurrentValue(), ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_resources_Resource_a().getMaxValue());
                    break;
                }
                case e: {
                    this.var_agw_d.a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_resources_Resource_a().getCurrentValue(), ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_resources_Resource_a().getMaxValue());
                }
            }
        }
    }

    @Override
    public void b(float f2, Engine engine) {
        if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer() != null) {
            this.var_ayh_c.b(f2, engine);
            if (this.var_ayh_a != null) {
                this.var_ayh_a.b(f2, engine);
            }
            this.var_ayh_b.b(f2, engine);
            this.var_agw_a.b(f2, engine);
            switch (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_resources_Resource_a().getResourceType()) {
                case c: {
                    this.var_agw_b.b(f2, engine);
                    break;
                }
                case d: {
                    this.var_agw_c.b(f2, engine);
                    break;
                }
                case e: {
                    this.var_agw_d.b(f2, engine);
                }
            }
            if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().gz_a().ui_a() != null && !ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().gz_a().ui_a().hf_a().azv_b().boolean_b()) {
                this.e.a((double)ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().gz_a().ui_a().hf_a().azv_b().a(TimeUnit.MILLISECONDS), (double)ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().gz_a().ui_a().hf_a().azv_b().long_a());
                this.var_ayh_d.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(1276.0f + ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().gz_a().ui_a().hf_a().azv_b().float_a() * (float)this.e.a().com_badlogic_gdx_graphics_g2d_Sprite_a().getRegionWidth(), 13.0f);
                this.e.b(f2, engine);
                this.var_ayh_d.b(f2, engine);
            }
            int n2 = 0;
            for (oo oo2 : ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_EffectManager_a().getEffects()) {
                oo2.op_a().b(f2, engine, 1825 - n2 * 50, 20);
                ++n2;
            }
            if (ay.ay_a().boolean_a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer())) {
                engine.a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().java_lang_String_a(), engine.var_axy_b.a(), Color.GREEN, engine.var_axy_b.a(), Color.BLACK, 1365.0f, 70.0f, 1, 1);
            } else {
                engine.a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().java_lang_String_a(), engine.var_axy_b.a(), Color.RED, engine.var_axy_b.a(), Color.BLACK, 1365.0f, 70.0f, 1, 1);
            }
            if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().double_a() / ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().double_b() <= (double)0.2f) {
                engine.a((int)ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().double_a() + " / " + (int)ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().double_b(), engine.var_axy_b.a(), Color.RED, engine.var_axy_b.a(), Color.BLACK, 1364.0f, 54.0f, 1, 1);
            } else {
                engine.a((int)ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().double_a() + " / " + (int)ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().double_b(), engine.var_axy_b.a(), Color.WHITE, engine.var_axy_b.a(), Color.BLACK, 1364.0f, 54.0f, 1, 1);
            }
            if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_resources_Resource_a().getCurrentValue() / ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_resources_Resource_a().getMaxValue() <= (double)0.2f) {
                engine.a((int)ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_resources_Resource_a().getCurrentValue() + " / " + (int)ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_resources_Resource_a().getMaxValue(), engine.var_axy_b.a(), Color.RED, engine.var_axy_b.a(), Color.BLACK, 1364.0f, 38.0f, 1, 1);
            } else {
                engine.a((int)ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_resources_Resource_a().getCurrentValue() + " / " + (int)ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_resources_Resource_a().getMaxValue(), engine.var_axy_b.a(), Color.WHITE, engine.var_axy_b.a(), Color.BLACK, 1364.0f, 38.0f, 1, 1);
            }
        }
    }

    public void a(CharacterClass characterClass) {
        if (characterClass != null) {
            this.var_com_arenaofkings_packets_misc_CharacterClass_a = characterClass;
            this.var_ayh_a = this.cfr_renamed_8.get((Object)characterClass);
        } else {
            this.var_com_arenaofkings_packets_misc_CharacterClass_a = null;
            this.var_ayh_a = null;
        }
    }
}

