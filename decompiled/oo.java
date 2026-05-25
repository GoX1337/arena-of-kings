/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.EffectList;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;

public abstract class oo
implements axr {
    protected br var_br_a;
    protected br var_br_b;
    protected op var_op_a;
    protected azv var_azv_a;
    protected float var_float_a = 1.0f;
    protected EffectList var_com_arenaofkings_packets_gameserver_data_EffectList_a;
    protected boolean var_boolean_a = false;
    protected boolean var_boolean_b = false;
    protected boolean var_boolean_c = false;
    protected float var_float_b = 0.0f;
    protected float var_float_c = 1.0f;
    protected da var_da_a;
    protected String var_java_lang_String_a;
    protected String var_java_lang_String_b;
    protected int var_int_a;
    protected float var_float_d;
    protected Animation.PlayMode var_com_badlogic_gdx_graphics_g2d_Animation$PlayMode_a;
    protected ot var_ot_a;
    protected azo var_azo_a;
    protected boolean var_boolean_d = false;
    protected int var_int_b = 1;
    protected int var_int_c;
    private String var_java_lang_String_c = "*";
    private String var_java_lang_String_d = "*";
    protected da var_da_b;
    protected da var_da_c;

    public oo(EffectList effectList, Engine engine, ot ot2, String string) {
        this.var_com_arenaofkings_packets_gameserver_data_EffectList_a = effectList;
        this.var_op_a = new op(engine, effectList, string, ot2, null);
        this.var_da_b = new da(ajw.jf, "GCD_Default", 60, 0.01666f, 0.0f, Animation.PlayMode.REVERSED, -25, -25);
        this.var_da_b.d(-0.45f);
        this.var_da_b.a(((agd)engine.axc_a()).axm_a(), false, true, true);
        this.var_da_c = new da(ajw.jf, "GCD_Default", 60, 0.01666f, 0.0f, Animation.PlayMode.REVERSED, -25, -25);
        this.var_da_c.d(-0.45f);
        this.var_da_c.a(((agd)engine.axc_a()).axm_a(), false, true, true);
        this.var_ot_a = ot2;
    }

    public oo(EffectList effectList, Engine engine, ot ot2) {
        this.var_com_arenaofkings_packets_gameserver_data_EffectList_a = effectList;
        this.var_op_a = new op(engine, effectList, effectList.toString(), ot2, null);
        this.var_da_b = new da(ajw.jf, "GCD_Default", 60, 0.01666f, 0.0f, Animation.PlayMode.REVERSED, -25, -25);
        this.var_da_b.d(-0.45f);
        this.var_da_b.a(((agd)engine.axc_a()).axm_a(), false, true, true);
        this.var_da_c = new da(ajw.jf, "GCD_Default", 60, 0.01666f, 0.0f, Animation.PlayMode.REVERSED, -25, -25);
        this.var_da_c.d(-0.45f);
        this.var_da_c.a(((agd)engine.axc_a()).axm_a(), false, true, true);
        this.var_ot_a = ot2;
    }

    public oo(EffectList effectList, Engine engine, ot ot2, EffectList effectList2) {
        this.var_com_arenaofkings_packets_gameserver_data_EffectList_a = effectList;
        this.var_op_a = new op(engine, effectList, effectList.toString(), ot2, effectList2);
        this.var_da_b = new da(ajw.jf, "GCD_Default", 60, 0.01666f, 0.0f, Animation.PlayMode.REVERSED, -25, -25);
        this.var_da_b.d(-0.45f);
        this.var_da_b.a(((agd)engine.axc_a()).axm_a(), false, true, true);
        this.var_da_c = new da(ajw.jf, "GCD_Default", 60, 0.01666f, 0.0f, Animation.PlayMode.REVERSED, -25, -25);
        this.var_da_c.d(-0.45f);
        this.var_da_c.a(((agd)engine.axc_a()).axm_a(), false, true, true);
        this.var_ot_a = ot2;
    }

    public oo(EffectList effectList, Engine engine, ot ot2, String string, String string2, int n2, float f2, Animation.PlayMode playMode, int n3, int n4, float f3, float f4) {
        this.var_com_arenaofkings_packets_gameserver_data_EffectList_a = effectList;
        this.var_op_a = new op(engine, effectList, effectList.toString(), ot2, null);
        this.var_ot_a = ot2;
        this.var_da_a = new da(engine.var_com_badlogic_gdx_assets_AssetManager_a, string, string2, n2, f2, playMode, n3, n4);
        this.var_da_a.b(f3);
        this.var_da_a.c(f4);
        this.var_java_lang_String_a = string;
        this.var_java_lang_String_b = string2;
        this.var_int_a = n2;
        this.var_float_d = f2;
        this.var_com_badlogic_gdx_graphics_g2d_Animation$PlayMode_a = playMode;
        this.var_da_b = new da(ajw.jf, "GCD_Default", 60, 0.01666f, 0.0f, Animation.PlayMode.REVERSED, -25, -25);
        this.var_da_b.d(-0.45f);
        this.var_da_b.a(((agd)engine.axc_a()).axm_a(), false, true, true);
        this.var_da_c = new da(ajw.jf, "GCD_Default", 60, 0.01666f, 0.0f, Animation.PlayMode.REVERSED, -25, -25);
        this.var_da_c.d(-0.45f);
        this.var_da_c.a(((agd)engine.axc_a()).axm_a(), false, true, true);
    }

    public oo(EffectList effectList, String string, Engine engine, ot ot2, String string2, String string3, int n2, float f2, Animation.PlayMode playMode, int n3, int n4, float f3, float f4) {
        this.var_com_arenaofkings_packets_gameserver_data_EffectList_a = effectList;
        this.var_op_a = new op(engine, effectList, string, ot2, null);
        this.var_ot_a = ot2;
        this.var_da_a = new da(engine.var_com_badlogic_gdx_assets_AssetManager_a, string2, string3, n2, f2, playMode, n3, n4);
        this.var_da_a.b(f3);
        this.var_da_a.c(f4);
        this.var_java_lang_String_a = string2;
        this.var_java_lang_String_b = string3;
        this.var_int_a = n2;
        this.var_float_d = f2;
        this.var_com_badlogic_gdx_graphics_g2d_Animation$PlayMode_a = playMode;
        this.var_da_b = new da(ajw.jf, "GCD_Default", 60, 0.01666f, 0.0f, Animation.PlayMode.REVERSED, -25, -25);
        this.var_da_b.d(-0.45f);
        this.var_da_b.a(((agd)engine.axc_a()).axm_a(), false, true, true);
        this.var_da_c = new da(ajw.jf, "GCD_Default", 60, 0.01666f, 0.0f, Animation.PlayMode.REVERSED, -25, -25);
        this.var_da_c.d(-0.45f);
        this.var_da_c.a(((agd)engine.axc_a()).axm_a(), false, true, true);
    }

    public oo(EffectList effectList, Engine engine, ot ot2, String string, String string2, String string3, int n2, float f2, Animation.PlayMode playMode, int n3, int n4, float f3, float f4) {
        this.var_com_arenaofkings_packets_gameserver_data_EffectList_a = effectList;
        this.var_op_a = new op(engine, effectList, string, ot2, null);
        this.var_ot_a = ot2;
        this.var_da_a = new da(engine.var_com_badlogic_gdx_assets_AssetManager_a, string2, string3, n2, f2, playMode, n3, n4);
        this.var_da_a.b(f3);
        this.var_da_a.c(f4);
        this.var_java_lang_String_a = string2;
        this.var_java_lang_String_b = string3;
        this.var_int_a = n2;
        this.var_float_d = f2;
        this.var_com_badlogic_gdx_graphics_g2d_Animation$PlayMode_a = playMode;
        this.var_da_b = new da(ajw.jf, "GCD_Default", 60, 0.01666f, 0.0f, Animation.PlayMode.REVERSED, -25, -25);
        this.var_da_b.d(-0.45f);
        this.var_da_b.a(((agd)engine.axc_a()).axm_a(), false, true, true);
        this.var_da_c = new da(ajw.jf, "GCD_Default", 60, 0.01666f, 0.0f, Animation.PlayMode.REVERSED, -25, -25);
        this.var_da_c.d(-0.45f);
        this.var_da_c.a(((agd)engine.axc_a()).axm_a(), false, true, true);
    }

    public void a(float f2) {
        this.var_float_a += f2;
    }

    public void b(float f2) {
        this.var_float_a -= f2;
    }

    public void void_a() {
        if (this.var_boolean_a || this.var_boolean_b) {
            this.var_float_a = 1.0f;
        }
        this.var_float_b = this.var_float_c / (float)(this.var_azv_a.long_b() / 1000L);
    }

    public void a(float f2, boolean bl2) {
        this.var_boolean_c = bl2;
        this.var_float_c = f2;
        if (!bl2) {
            this.var_float_a += this.var_float_c;
        }
        this.var_boolean_a = true;
        this.var_float_b = this.var_float_c / (float)(this.var_azv_a.long_b() / 1000L);
    }

    public void b(float f2, boolean bl2) {
        this.var_boolean_c = bl2;
        if (!bl2) {
            this.var_float_a -= this.var_float_c;
        }
        this.var_boolean_b = true;
        this.var_float_b = this.var_float_c / (float)(this.var_azv_a.long_b() / 1000L);
    }

    public float float_a() {
        return this.var_float_a;
    }

    public void a(ajw ajw2) {
        this.var_azo_a = new azo(ajw2);
    }

    public void c(float f2) {
        if (this.var_boolean_a) {
            this.var_float_a = !this.var_boolean_c ? (this.var_float_a -= this.var_float_b * f2) : (this.var_float_a += this.var_float_b * f2);
        }
        if (this.var_boolean_b) {
            this.var_float_a = !this.var_boolean_c ? (this.var_float_a += this.var_float_b * f2) : (this.var_float_a -= this.var_float_b * f2);
        }
    }

    @Override
    public void a(float f2, Engine engine) {
    }

    public void a(float f2, Engine engine, int n2) {
        if (this.var_da_a != null) {
            this.var_da_a.a(this.var_br_a.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX(), this.var_br_a.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY());
            this.var_da_a.d(f2, engine);
        }
    }

    public void b(float f2, Engine engine, int n2) {
        if (this.var_da_a != null) {
            this.var_da_a.a(this.var_br_a.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX(), this.var_br_a.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY());
            this.var_da_a.c(f2, engine);
        }
    }

    public void a(float f2, Engine engine, azv azv2, int n2, int n3) {
        this.a(f2, engine);
        if (this.var_br_a.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().java_lang_String_a().equals(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().java_lang_String_a())) {
            this.var_op_a.a(f2, engine, azv2, n2, n3);
        }
    }

    public void b(float f2, Engine engine, azv azv2, int n2, int n3) {
        if (this.var_br_a.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().java_lang_String_a().equals(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().java_lang_String_a())) {
            this.var_op_a.b(f2, engine, azv2, n2, n3);
        }
    }

    public void c(float f2, Engine engine, azv azv2, int n2, int n3) {
        if (this.var_br_a.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().java_lang_String_a().equals(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().java_lang_String_a())) {
            this.var_op_a.c(f2, engine, azv2, n2, n3);
        }
    }

    public void d(float f2, Engine engine, azv azv2, int n2, int n3) {
        if (this.var_br_a.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().java_lang_String_a().equals(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().java_lang_String_a())) {
            this.var_op_a.d(f2, engine, azv2, n2, n3);
        }
    }

    @Override
    public void b(float f2, Engine engine) {
    }

    public abstract void void_b();

    public abstract void c();

    public void a(br br2) {
        this.var_br_a = br2;
    }

    public op op_a() {
        return this.var_op_a;
    }

    public br br_a() {
        return this.var_br_a;
    }

    public br br_b() {
        return this.var_br_b;
    }

    public void b(br br2) {
        this.var_br_b = br2;
    }

    public azv azv_a() {
        return this.var_azv_a;
    }

    public void a(azv azv2) {
        this.var_azv_a = azv2;
        this.var_da_b.e((float)azv2.long_b() / 1000.0f);
        this.var_da_b.a(0.0f);
        this.var_da_c.e((float)azv2.long_b() / 1000.0f);
        this.var_da_c.a(0.0f);
    }

    public azo azo_a() {
        return this.var_azo_a;
    }

    public void a(Color color) {
        this.var_da_a.a(color);
    }

    public ot ot_a() {
        return this.var_ot_a;
    }

    protected abstract void d();

    public void a(int n2) {
        this.var_int_b = n2;
        this.var_java_lang_String_c = "";
        for (int i2 = 0; i2 < n2; ++i2) {
            this.var_java_lang_String_c = this.var_java_lang_String_c + "*";
        }
    }

    public boolean boolean_a() {
        return this.var_boolean_d;
    }

    public void b(int n2) {
        this.var_int_c = n2;
        this.var_boolean_d = true;
        this.var_java_lang_String_d = "";
        for (int i2 = 0; i2 < n2; ++i2) {
            this.var_java_lang_String_d = this.var_java_lang_String_d + "*";
        }
    }

    public String java_lang_String_a() {
        return this.var_java_lang_String_c;
    }

    public String java_lang_String_b() {
        return this.var_java_lang_String_d;
    }

    public EffectList com_arenaofkings_packets_gameserver_data_EffectList_a() {
        return this.var_com_arenaofkings_packets_gameserver_data_EffectList_a;
    }

    public da da_a() {
        return this.var_da_b;
    }

    public da da_b() {
        return this.var_da_c;
    }
}

