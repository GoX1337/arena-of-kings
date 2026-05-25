/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.Direction;
import com.arenaofkings.packets.gameserver.data.EffectList;
import com.arenaofkings.packets.gameserver.data.HitCircle;
import com.arenaofkings.packets.gameserver.data.PlayerAction;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.IntMap;
import com.badlogic.gdx.utils.ObjectMap;
import java.util.ArrayList;
import java.util.List;

public class aik
extends InputAdapter {
    private final Engine var_com_arenaofkings_client_core_Engine_a;
    private final agd var_agd_a;
    private final agc var_agc_a;
    public Array<aim> var_com_badlogic_gdx_utils_Array_aim__a;
    public IntMap<ail> var_com_badlogic_gdx_utils_IntMap_ail__a;
    private final int var_int_a = 51;
    List<Integer> var_java_util_List_java_lang_Integer__a;

    public aik(Engine engine, agd agd2) {
        this.var_com_arenaofkings_client_core_Engine_a = engine;
        this.var_agd_a = agd2;
        this.var_agc_a = engine.var_agc_a;
        this.b();
        this.var_com_arenaofkings_client_core_Engine_a = new ArrayList();
        this.var_com_arenaofkings_client_core_Engine_a.add(59);
        this.var_com_arenaofkings_client_core_Engine_a.add(60);
        this.var_com_arenaofkings_client_core_Engine_a.add(57);
        this.var_com_arenaofkings_client_core_Engine_a.add(58);
        this.var_com_arenaofkings_client_core_Engine_a.add(129);
        this.var_com_arenaofkings_client_core_Engine_a.add(130);
    }

    private void b() {
        this.var_com_arenaofkings_client_core_Engine_a = new IntMap(51);
        this.var_com_arenaofkings_client_core_Engine_a = new Array();
        this.a(this.var_agc_a);
        this.a(new ajn(66));
        if (((IntMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).get(111) != null && ((ail)((IntMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).get(111)).getClass() == aii.class) {
            Engine.b("SETTING THE KEY");
            aii aii2 = (aii)((IntMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).get(111);
            aii2.void_a();
        } else {
            Engine.b("didn't find THE KEY");
            this.a(new ajl(111));
        }
    }

    public void a() {
        Object object;
        if (t.a(agd.class, this.var_com_arenaofkings_client_core_Engine_a) && ((agd)this.var_com_arenaofkings_client_core_Engine_a.axc_a()).ajt_a().boolean_a() && Gdx.input.isKeyJustPressed(61)) {
            ((agd)this.var_com_arenaofkings_client_core_Engine_a.axc_a()).ajt_a().void_a();
        }
        if (!(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_EffectManager_a().contains(EffectList.Windstorm) || !PlayerAction.isIdle(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().cr_a().com_arenaofkings_packets_gameserver_data_PlayerAction_a()) || ay.ay_a().gu_a().boolean_a(SpellName.Charge) && ay.ay_a().gu_a().boolean_a(SpellName.Safeguard) && ay.ay_a().gu_a().boolean_a(SpellName.Bear_Charge))) {
            object = axp.a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().cr_a().com_arenaofkings_packets_gameserver_data_Direction_a(), new HitCircle(this.var_com_arenaofkings_client_core_Engine_a.var_com_badlogic_gdx_math_Vector3_b.x, this.var_com_arenaofkings_client_core_Engine_a.var_com_badlogic_gdx_math_Vector3_b.y, 0), ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a());
            ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().cr_a().a((Direction)((Object)object));
        }
        object = ((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).iterator();
        while (object.hasNext()) {
            aim aim2 = (aim)object.next();
            aim2.a(this.var_com_arenaofkings_client_core_Engine_a);
        }
    }

    private void a(agc agc2) {
        for (ObjectMap.Entry entry : agc2.a()) {
            this.a((agb)entry.value);
        }
    }

    private void a(agb agb2) {
        if (agb2 instanceof aim) {
            this.a((aim)agb2);
        } else if (agb2 instanceof ail) {
            this.a((ail)agb2);
        }
    }

    private void a(ail ail2) {
        ((IntMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(ail2.int_a(), ail2);
    }

    private void a(aim aim2) {
        ((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).add(aim2);
    }

    @Override
    public boolean keyDown(int n2) {
        if (this.var_com_arenaofkings_client_core_Engine_a.contains(n2)) {
            return true;
        }
        Engine.b("keyDown " + n2);
        if (this.var_agd_a.boolean_a() || n2 == 66) {
            if (n2 == 37 && this.var_agd_a.agn_a().com_badlogic_gdx_scenes_scene2d_Stage_c().getKeyboardFocus() != this.var_agd_a.agn_a().i_a().axh_a()) {
                ay.ay_a().gd_a().as_a().void_c();
            }
            if (n2 == 111) {
                if (((agd)this.var_com_arenaofkings_client_core_Engine_a.axc_a()).agn_a().fm_a() != null) {
                    ((agd)this.var_com_arenaofkings_client_core_Engine_a.axc_a()).agn_a().a(null);
                    return true;
                }
                if (ay.ay_a().gd_a().as_a().boolean_a()) {
                    ay.ay_a().gd_a().as_a().f();
                    return true;
                }
            }
            ail ail2 = null;
            if (Gdx.input.isKeyPressed(59) || Gdx.input.isKeyPressed(60)) {
                ail2 = (ail)((IntMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).get(n2 + 7000);
            } else if (Gdx.input.isKeyPressed(57) || Gdx.input.isKeyPressed(58)) {
                ail2 = (ail)((IntMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).get(n2 + 8000);
            } else if (Gdx.input.isKeyPressed(129) || Gdx.input.isKeyPressed(130)) {
                ail2 = (ail)((IntMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).get(n2 + 9000);
            }
            if (ail2 == null) {
                ail2 = (ail)((IntMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).get(n2);
            }
            if (ail2 != null) {
                Engine.b("request found " + n2 + " " + ail2.getClass().getSimpleName());
                if (ail2.getClass() == aii.class || ail2.getClass() == ajn.class || ail2.getClass() == ajl.class || this.var_agd_a.agn_a().com_badlogic_gdx_scenes_scene2d_Stage_c().getKeyboardFocus() != this.var_agd_a.agn_a().i_a().axh_a()) {
                    return ail2.boolean_a(this.var_com_arenaofkings_client_core_Engine_a);
                }
            } else {
                Engine.b("request is null " + n2);
            }
        }
        return false;
    }

    @Override
    public boolean keyUp(int n2) {
        ail ail2;
        if (this.var_agd_a.boolean_a() && (ail2 = (ail)((IntMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).get(n2)) != null) {
            return ail2.b(this.var_com_arenaofkings_client_core_Engine_a);
        }
        return false;
    }

    @Override
    public boolean keyTyped(char c2) {
        return false;
    }

    @Override
    public boolean touchDown(int n2, int n3, int n4, int n5) {
        System.out.println("adapter touchDown: " + n4 + " " + n5);
        if (this.var_agd_a.boolean_a()) {
            if (n5 == 0 || n5 == 1) {
                ail ail2 = (ail)((IntMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).get(5000 + n5);
                if (ail2 != null) {
                    return ail2.boolean_a(this.var_com_arenaofkings_client_core_Engine_a);
                }
                for (int i2 = 0; i2 < ((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).size; ++i2) {
                    aim aim2 = (aim)((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).get(i2);
                    if (!aim2.a(this.var_com_arenaofkings_client_core_Engine_a, this.var_agd_a, n2, Gdx.graphics.getHeight() - n3, n4, n5)) continue;
                    return true;
                }
            } else {
                ail ail3 = (ail)((IntMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).get(5000 + n5);
                if (ail3 != null) {
                    return ail3.boolean_a(this.var_com_arenaofkings_client_core_Engine_a);
                }
            }
        }
        return false;
    }

    @Override
    public boolean touchUp(int n2, int n3, int n4, int n5) {
        int n6;
        System.out.println("adapter touchUp: " + n4 + " " + n5);
        if (this.var_agd_a.boolean_a() && n5 != 0 && n5 != 1) {
            for (n6 = 0; n6 < ((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).size; ++n6) {
                aim object2 = (aim)((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).get(n6);
                if (!object2.a(this.var_com_arenaofkings_client_core_Engine_a, this.var_agd_a, n2, Gdx.graphics.getHeight() - n3, n4, n5)) continue;
                return true;
            }
        }
        if (n5 == 0 && (Gdx.input.isKeyPressed(59) || Gdx.input.isKeyPressed(60))) {
            for (fm fm2 : ay.ay_a().gd_a().as_a().a()) {
                if (!(fm2 instanceof fh) || !fm2.boolean_a()) continue;
                this.var_agd_a.agn_a().i_a().axh_a().a(fm2);
                if (!this.var_agd_a.agn_a().i_a().boolean_a()) {
                    this.var_agd_a.agn_a().i_a().g();
                }
                this.var_agd_a.agn_a().com_badlogic_gdx_scenes_scene2d_Stage_c().setKeyboardFocus(this.var_agd_a.agn_a().i_a().axh_a());
            }
            for (am am2 : ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().a().values()) {
                if (!am2.fh_a().boolean_a()) continue;
                this.var_agd_a.agn_a().i_a().axh_a().a(am2.fh_a());
                this.var_agd_a.agn_a().com_badlogic_gdx_scenes_scene2d_Stage_c().setKeyboardFocus(this.var_agd_a.agn_a().i_a().axh_a());
            }
        }
        if (this.var_agd_a.boolean_a()) {
            for (n6 = 0; n6 < ((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).size; ++n6) {
                aim aim2 = (aim)((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).get(n6);
                if (!aim2.b(this.var_com_arenaofkings_client_core_Engine_a, this.var_agd_a, n2, Gdx.graphics.getHeight() - n3, n4, n5)) continue;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean touchDragged(int n2, int n3, int n4) {
        if (!Gdx.input.isButtonPressed(0)) {
            return false;
        }
        if (this.var_agd_a.boolean_a()) {
            for (int i2 = 0; i2 < ((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).size; ++i2) {
                aim aim2 = (aim)((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).get(i2);
                if (!aim2.a(this.var_com_arenaofkings_client_core_Engine_a, this.var_agd_a, n2, Gdx.graphics.getHeight() - n3, n4)) continue;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean mouseMoved(int n2, int n3) {
        if (this.var_agd_a.boolean_a()) {
            return super.mouseMoved(n2, Gdx.graphics.getHeight() - n3);
        }
        return false;
    }

    @Override
    public boolean scrolled(float f2, float f3) {
        System.out.println("scrolled amount: " + f3);
        if (this.var_agd_a.boolean_a()) {
            ail ail2;
            if (f3 > 0.0f ? (ail2 = (ail)((IntMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).get(6000)) != null : f3 < 0.0f && (ail2 = (ail)((IntMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).get(6001)) != null) {
                return ail2.boolean_a(this.var_com_arenaofkings_client_core_Engine_a);
            }
            for (int i2 = 0; i2 < ((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).size; ++i2) {
                aim aim2 = (aim)((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).get(i2);
                if (!aim2.a(this.var_agd_a, (int)f3)) continue;
                return true;
            }
        }
        return false;
    }
}

