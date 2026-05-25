/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.Target;
import com.arenaofkings.packets.gameserver.requests.input.TargetRequest;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Cursor;

public class ain
extends aim {
    private azv var_azv_a = new azv(30L, true);
    private Cursor var_com_badlogic_gdx_graphics_Cursor_a;

    public ain(int n2) {
        super(n2);
    }

    @Override
    public void a(Engine engine) {
        if (ay.ay_a().gd_a().boolean_b()) {
            return;
        }
        if (engine.var_aj_a.boolean_a(ai.g)) {
            for (br br2 : ay.ay_a().gf_a().a().values()) {
                if (br2 == null || br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a() == null || br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity() == null || br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().cr_a() == null || br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity() == null || br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().cr_a().da_a() == null || br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity() == null || br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().cr_a().da_a().com_badlogic_gdx_graphics_g2d_Sprite_a() == null || br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity() == null || br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().cr_a().da_a().com_badlogic_gdx_graphics_g2d_Sprite_a().getBoundingRectangle() == null || ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getIdentifyingName().equals(br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().java_lang_String_a()) || !br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().cr_a().da_a().com_badlogic_gdx_graphics_g2d_Sprite_a().getBoundingRectangle().contains(engine.var_com_badlogic_gdx_math_Vector3_b.x, engine.var_com_badlogic_gdx_math_Vector3_b.y)) continue;
                if (this.var_azv_a.boolean_b()) {
                    this.var_azv_a.void_c();
                    if (this.var_com_badlogic_gdx_graphics_Cursor_a != engine.var_com_badlogic_gdx_graphics_Cursor_b) {
                        Gdx.graphics.setCursor(engine.var_com_badlogic_gdx_graphics_Cursor_b);
                        this.var_com_badlogic_gdx_graphics_Cursor_a = engine.var_com_badlogic_gdx_graphics_Cursor_b;
                    }
                }
                return;
            }
            for (br br2 : ay.ay_a().ge_a().a().values()) {
                if (br2 == null || br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a() == null || br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity() == null || br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().cr_a() == null || br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity() == null || br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().cr_a().da_a() == null || br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity() == null || br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().cr_a().da_a().com_badlogic_gdx_graphics_g2d_Sprite_a() == null || br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity() == null || br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().cr_a().da_a().com_badlogic_gdx_graphics_g2d_Sprite_a().getBoundingRectangle() == null || ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getIdentifyingName().equals(br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().java_lang_String_a()) || !br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().cr_a().da_a().com_badlogic_gdx_graphics_g2d_Sprite_a().getBoundingRectangle().contains(engine.var_com_badlogic_gdx_math_Vector3_b.x, engine.var_com_badlogic_gdx_math_Vector3_b.y) || br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().boolean_b() && !br2.f()) continue;
                if (this.var_azv_a.boolean_b()) {
                    this.var_azv_a.void_c();
                    if (this.var_com_badlogic_gdx_graphics_Cursor_a != engine.var_com_badlogic_gdx_graphics_Cursor_c) {
                        Gdx.graphics.setCursor(engine.var_com_badlogic_gdx_graphics_Cursor_c);
                        this.var_com_badlogic_gdx_graphics_Cursor_a = engine.var_com_badlogic_gdx_graphics_Cursor_c;
                    }
                }
                return;
            }
            if (this.var_azv_a.boolean_b()) {
                this.var_azv_a.void_c();
                if (this.var_com_badlogic_gdx_graphics_Cursor_a != engine.var_com_badlogic_gdx_graphics_Cursor_a) {
                    Gdx.graphics.setCursor(engine.var_com_badlogic_gdx_graphics_Cursor_a);
                    this.var_com_badlogic_gdx_graphics_Cursor_a = engine.var_com_badlogic_gdx_graphics_Cursor_a;
                }
                this.var_azv_a.void_c();
            }
        }
    }

    @Override
    public boolean a(Engine engine, agd agd2, int n2, int n3, int n4, int n5) {
        Engine.a("Click " + n5 + " [raw " + n2 + "," + n3 + "]  [projected " + engine.var_com_badlogic_gdx_math_Vector3_b.x + "," + engine.var_com_badlogic_gdx_math_Vector3_b.y + "]");
        boolean bl2 = false;
        if (n5 == this.var_azv_a) {
            if (!engine.var_aj_a.boolean_a(ai.k) || !Gdx.input.isKeyPressed(129) && !Gdx.input.isKeyPressed(130)) {
                for (br object : ay.ay_a().gf_a().a().values()) {
                    if (object == null || object.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a() == null || object.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity() == null || !object.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().boolean_a() || object.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().cr_a() == null || object.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity() == null || object.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().cr_a().da_a() == null || object.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity() == null || object.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().cr_a().da_a().com_badlogic_gdx_graphics_g2d_Sprite_a() == null || object.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity() == null || object.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().cr_a().da_a().com_badlogic_gdx_graphics_g2d_Sprite_a().getBoundingRectangle() == null || ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getIdentifyingName().equals(object.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().java_lang_String_a()) || !object.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().cr_a().da_a().com_badlogic_gdx_graphics_g2d_Sprite_a().getBoundingRectangle().contains(engine.var_com_badlogic_gdx_math_Vector3_b.x, engine.var_com_badlogic_gdx_math_Vector3_b.y)) continue;
                    ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().a(new Target(object.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().java_lang_String_a()));
                    engine.var_ag_a.a(new TargetRequest(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a()));
                    engine.var_baa_a.a(ajw.kD, 0.6f);
                    bl2 = true;
                    ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().a((ui)null);
                    if (((agd)engine.axc_a()).boolean_b()) {
                        ((agd)engine.axc_a()).g(true);
                    }
                    if (!t.a(agd.class, engine)) break;
                    ((agd)engine.axc_a()).agn_a().agt_a().a().a(object.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_misc_CharacterClass_a());
                    break;
                }
            }
            if (!(bl2 || engine.var_aj_a.boolean_a(ai.j) && (Gdx.input.isKeyPressed(59) || Gdx.input.isKeyPressed(60)))) {
                for (br br2 : ay.ay_a().ge_a().a().values()) {
                    if (br2 == null || br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a() == null || br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity() == null || !br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().boolean_a() || br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().cr_a() == null || br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity() == null || br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().cr_a().da_a() == null || br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity() == null || br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().cr_a().da_a().com_badlogic_gdx_graphics_g2d_Sprite_a() == null || br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity() == null || br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().cr_a().da_a().com_badlogic_gdx_graphics_g2d_Sprite_a().getBoundingRectangle() == null || ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getIdentifyingName().equals(br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().java_lang_String_a()) || !br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().cr_a().da_a().com_badlogic_gdx_graphics_g2d_Sprite_a().getBoundingRectangle().contains(engine.var_com_badlogic_gdx_math_Vector3_b.x, engine.var_com_badlogic_gdx_math_Vector3_b.y)) continue;
                    ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().a(new Target(br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().java_lang_String_a()));
                    engine.var_ag_a.a(new TargetRequest(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a()));
                    engine.var_baa_a.a(ajw.kD, 0.6f);
                    bl2 = true;
                    ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().a((ui)null);
                    if (((agd)engine.axc_a()).boolean_b()) {
                        ((agd)engine.axc_a()).g(true);
                    }
                    if (!t.a(agd.class, engine)) break;
                    ((agd)engine.axc_a()).agn_a().agt_a().a().a(br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_misc_CharacterClass_a());
                    break;
                }
            }
            if (!bl2) {
                for (ui ui2 : agd2.hi_a().a()) {
                    if (ui2 == null || ui2.boolean_c() || !ui2.hf_a().e() || ui2.hf_a().int_c() <= 0 || ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().cr_a().da_a().com_badlogic_gdx_graphics_g2d_Sprite_a() == null || ui2.da_a().com_badlogic_gdx_graphics_g2d_Sprite_a().getBoundingRectangle() == null || !ui2.da_a().com_badlogic_gdx_graphics_g2d_Sprite_a().getBoundingRectangle().contains(engine.var_com_badlogic_gdx_math_Vector3_b.x, engine.var_com_badlogic_gdx_math_Vector3_b.y)) continue;
                    ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().a(new Target(ui2.hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a().name(), ui2.hf_a().int_d()));
                    ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().a(ui2);
                    if (((agd)engine.axc_a()).boolean_b()) {
                        ((agd)engine.axc_a()).g(true);
                    }
                    engine.var_ag_a.a(new TargetRequest(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a()));
                    engine.var_baa_a.a(ajw.kD, 0.6f);
                    Engine.b("Clicking an orb - ID: " + ui2.hf_a().int_d());
                    bl2 = true;
                    if (!t.a(agd.class, engine)) continue;
                    ((agd)engine.axc_a()).agn_a().agt_a().a().a(null);
                }
            }
            if (!(engine.var_aj_a.boolean_a(ai.h) || bl2 || ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getIdentifyingName().equals(""))) {
                engine.var_baa_a.a(ajw.kE, 0.7f);
                ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getIdentifyingName().equals("");
                engine.var_ag_a.a(new TargetRequest(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a()));
                ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().clearTarget();
            }
        } else {
            Engine.a("click press id: " + n5);
        }
        return bl2;
    }

    @Override
    public boolean b(Engine engine, agd agd2, int n2, int n3, int n4, int n5) {
        return false;
    }

    @Override
    public boolean a(Engine engine, agd agd2, int n2, int n3, int n4) {
        return false;
    }

    @Override
    public boolean a(agd agd2, int n2) {
        return false;
    }
}

