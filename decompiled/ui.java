/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.Location;
import com.arenaofkings.packets.gameserver.data.Target;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.utils.Array;
import java.util.ArrayList;

public abstract class ui
implements axr {
    protected hf var_hf_a;
    protected br var_br_a;
    protected Array<br> var_com_badlogic_gdx_utils_Array_br__a;
    protected boolean var_boolean_a;
    protected hd var_hd_a;
    protected da var_da_a;
    protected da var_da_b;
    protected azo var_azo_a;
    protected float var_float_a = -1.0f;
    protected boolean var_boolean_b;
    protected azo var_azo_b;
    protected boolean c;

    @Deprecated
    public ui() {
    }

    @Override
    public void a(float f2, Engine engine) {
        if (this.var_da_a != null) {
            this.var_da_a.a(f2, engine);
        }
        if (this.var_da_b != null) {
            this.var_da_b.a(f2, engine);
        }
    }

    public void a(float f2, Engine engine, int n2, int n3) {
    }

    public void a(float f2, Engine engine, int n2, int n3, int n4) {
        if (!this.var_hd_a.boolean_a()) {
            this.var_hd_a.a(engine.axc_a().axm_a());
        }
        this.var_hd_a.ayh_b().com_badlogic_gdx_graphics_g2d_Sprite_a().scale(-0.225f);
        this.var_hd_a.ayh_c().com_badlogic_gdx_graphics_g2d_Sprite_a().scale(-0.225f);
        this.var_hd_a.com_badlogic_gdx_graphics_g2d_Sprite_a().scale(-0.225f);
        this.var_hd_a.da_b().d(-0.2f);
        int n5 = (int)this.var_hd_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getX();
        int n6 = (int)this.var_hd_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getY();
        if (n2 == 1) {
            this.var_hd_a.a(344 + n4 + n3 * 45, 572);
            this.var_hd_a.a(f2, engine);
            this.var_hd_a.ayh_a().b(f2, engine);
            this.var_hd_a.ayh_b().b(f2, engine);
            this.var_hd_a.ayh_c().b(f2, engine);
            if (this.var_hd_a.com_arenaofkings_packets_gameserver_data_updates_SpellName_a() != SpellName.Empty && this.var_hd_a.ayh_a().boolean_a()) {
                this.var_hd_a.a(engine, true, -255, 55);
            }
            if (this.var_hd_a.com_arenaofkings_packets_gameserver_data_updates_SpellName_a() != SpellName.Empty) {
                this.var_hd_a.da_b().b(f2, engine);
            }
        } else if (n2 == 2) {
            this.var_hd_a.a(725 + n4 + n3 * 45, 572);
            this.var_hd_a.a(f2, engine);
            this.var_hd_a.ayh_a().b(f2, engine);
            this.var_hd_a.ayh_b().b(f2, engine);
            this.var_hd_a.ayh_c().b(f2, engine);
            if (this.var_hd_a.com_arenaofkings_packets_gameserver_data_updates_SpellName_a() != SpellName.Empty && this.var_hd_a.ayh_a().boolean_a()) {
                this.var_hd_a.a(engine, true, -255, 55);
            }
            if (this.var_hd_a.com_arenaofkings_packets_gameserver_data_updates_SpellName_a() != SpellName.Empty) {
                this.var_hd_a.da_b().b(f2, engine);
            }
        } else if (n2 == 3) {
            this.var_hd_a.a(1119 + n4 + n3 * 45, 572);
            this.var_hd_a.a(f2, engine);
            this.var_hd_a.ayh_a().b(f2, engine);
            this.var_hd_a.ayh_b().b(f2, engine);
            this.var_hd_a.ayh_c().b(f2, engine);
            if (this.var_hd_a.com_arenaofkings_packets_gameserver_data_updates_SpellName_a() != SpellName.Empty && this.var_hd_a.ayh_a().boolean_a()) {
                this.var_hd_a.a(engine, true, -255, 55);
            }
            if (this.var_hd_a.com_arenaofkings_packets_gameserver_data_updates_SpellName_a() != SpellName.Empty) {
                this.var_hd_a.da_b().b(f2, engine);
            }
        }
        this.var_hd_a.a(n5, n6);
        this.var_hd_a.ayh_b().com_badlogic_gdx_graphics_g2d_Sprite_a().scale(0.225f);
        this.var_hd_a.ayh_c().com_badlogic_gdx_graphics_g2d_Sprite_a().scale(0.225f);
        this.var_hd_a.com_badlogic_gdx_graphics_g2d_Sprite_a().scale(0.225f);
        this.var_hd_a.da_b().d(0.2f);
    }

    public void a(float f2, Engine engine, int n2) {
        this.var_hd_a.ayh_b().com_badlogic_gdx_graphics_g2d_Sprite_a().scale(-0.225f);
        this.var_hd_a.ayh_c().com_badlogic_gdx_graphics_g2d_Sprite_a().scale(-0.225f);
        this.var_hd_a.com_badlogic_gdx_graphics_g2d_Sprite_a().scale(-0.225f);
        this.var_hd_a.a(f2, engine);
        this.var_hd_a.a(1103 + n2 * 45, 420);
        this.var_hd_a.ayh_a().b(f2, engine);
        this.var_hd_a.ayh_b().com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(1099 + n2 * 45, 419.0f);
        this.var_hd_a.ayh_b().b(f2, engine);
        this.var_hd_a.ayh_c().com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(1099 + n2 * 45, 420.0f);
        this.var_hd_a.ayh_c().b(f2, engine);
        this.var_hd_a.ayh_b().com_badlogic_gdx_graphics_g2d_Sprite_a().scale(0.225f);
        this.var_hd_a.ayh_c().com_badlogic_gdx_graphics_g2d_Sprite_a().scale(0.225f);
        this.var_hd_a.com_badlogic_gdx_graphics_g2d_Sprite_a().scale(0.225f);
    }

    public void b(float f2, Engine engine, int n2) {
        if (this.var_hd_a.com_arenaofkings_packets_gameserver_data_updates_SpellName_a() != SpellName.Empty && this.var_hd_a.ayh_a().boolean_a()) {
            this.var_hd_a.a(engine, true, -265, 65);
        }
    }

    public void c(float f2, Engine engine, int n2) {
        this.var_hd_a.da_b().d(-0.2f);
        if (this.var_hd_a.com_arenaofkings_packets_gameserver_data_updates_SpellName_a() != SpellName.Empty) {
            this.var_hd_a.da_b().b(f2, engine);
        }
        this.var_hd_a.da_b().d(0.2f);
    }

    @Override
    public void b(float f2, Engine engine) {
    }

    public void a(float f2, Engine engine, boolean bl2) {
        if (this.var_da_a != null && this.var_hf_a.a().size() == 1 && this.var_hf_a.a().get(0).getTarget() == null) {
            this.var_da_a.f(f2, this.var_hf_a.a().get(0).getX(), this.var_hf_a.a().get(0).getY(), engine.var_azi_a);
        } else if (this.var_da_a != null && this.var_hf_a.a().size() == 1 && this.var_hf_a.a().get(0).getTarget() != null) {
            this.var_da_a.d(f2, this.var_hf_a.a().get(0).getX(), this.var_hf_a.a().get(0).getY(), engine.var_azi_a);
        } else if (this.var_da_a != null && this.var_hf_a.a().size() > 1) {
            for (Location location : this.var_hf_a.a()) {
                if (location.getTarget() == null) {
                    this.var_da_a.d(f2, location.getX(), location.getY(), engine.var_azi_a);
                    continue;
                }
                if (!ay.ay_a().boolean_a(location.getTarget().getIdentifyingName()) && (ay.ay_a().boolean_a(location.getTarget().getIdentifyingName()) || location.getTarget().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().boolean_b() && !location.getTarget().getPlayer().f())) continue;
                this.var_da_a.d(f2, location.getX(), location.getY(), engine.var_azi_a);
            }
        } else if (this.var_da_a != null) {
            this.var_da_a.d(f2, this.var_da_a.com_badlogic_gdx_math_Vector3_a().x, this.var_da_a.com_badlogic_gdx_math_Vector3_a().y, engine.var_azi_a);
        }
        if (this.var_da_a != null && bl2) {
            this.var_da_a.c(true);
        }
    }

    public void c(float f2, Engine engine) {
        if (this.var_da_a != null && this.var_hf_a.a().size() == 1 && this.var_hf_a.a().size() > 0 && this.var_hf_a.a().get(0).getTarget() == null) {
            this.var_da_a.g(f2, this.var_hf_a.a().get(0).getX(), this.var_hf_a.a().get(0).getY(), engine.var_azi_a);
        } else if (this.var_da_a != null && this.var_hf_a.a().size() == 1 && this.var_hf_a.a().size() > 0 && this.var_hf_a.a().get(0).getTarget() != null) {
            Engine.a(this.var_hf_a.a().get(0).toString());
            this.var_da_a.e(f2, this.var_hf_a.a().get(0).getX(), this.var_hf_a.a().get(0).getY(), engine.var_azi_a);
        } else if (this.var_da_a != null && this.var_hf_a.a().size() > 1) {
            for (Location location : this.var_hf_a.a()) {
                if (location.getTarget() == null) {
                    this.var_da_a.e(f2, location.getX(), location.getY(), engine.var_azi_a);
                    continue;
                }
                if (!ay.ay_a().boolean_a(location.getTarget().getIdentifyingName()) && (ay.ay_a().boolean_a(location.getTarget().getIdentifyingName()) || location.getTarget().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().boolean_b() && !location.getTarget().getPlayer().f())) continue;
                this.var_da_a.e(f2, location.getX(), location.getY(), engine.var_azi_a);
            }
        } else if (this.var_da_a != null) {
            this.var_da_a.e(f2, this.var_da_a.com_badlogic_gdx_math_Vector3_a().x, this.var_da_a.com_badlogic_gdx_math_Vector3_a().y, engine.var_azi_a);
        }
    }

    public void a(float f2, azi azi2) {
        if (this.var_da_a != null && this.var_hf_a.a().size() == 1) {
            this.var_da_a.h(f2, this.var_hf_a.a().get(0).getX(), this.var_hf_a.a().get(0).getY(), azi2);
        } else if (this.var_da_a != null && this.var_hf_a.a().size() > 1) {
            for (Location location : this.var_hf_a.a()) {
                this.var_da_a.h(f2, location.getX(), location.getY(), azi2);
            }
        } else if (this.var_da_a != null) {
            this.var_da_a.h(f2, this.var_da_a.com_badlogic_gdx_math_Vector3_a().x, this.var_da_a.com_badlogic_gdx_math_Vector3_a().y, azi2);
        }
    }

    public static ui a(ui ui2) {
        ui ui3 = null;
        if (ui2.getClass().getSuperclass() == uf.class) {
            Engine.a("cloning a FixedCoordinateSpell");
            ui3 = ui2.var_da_a != null ? new uf(new uf.a().a(ui2.hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a(), ui2.hd_a().java_lang_String_a(), ui2.hf_a().azv_b().long_a(), ui2.hf_a().azv_c().long_a(), ui2.hf_a().gx_a(), ui2.hf_a().int_b(), ui2.hf_a().int_a(), ui2.hf_a().long_b(), uj.var_uj_a, ui2.hf_a().uh_a(), ui2.hf_a().uk_a(), ui2.hf_a().com_arenaofkings_packets_gameserver_data_LocationType_a(), ui2.hf_a().boolean_c(), ui2.hf_a().boolean_d()).a(ui2.var_da_a.ajw_a(), ui2.var_da_a.java_lang_String_a(), ui2.var_da_a.int_c(), ui2.var_da_a.float_b(), ui2.var_da_a.com_badlogic_gdx_graphics_g2d_Animation$PlayMode_a(), ui2.var_da_a.int_a(), ui2.var_da_a.int_b())) : new uf(new uf.a().a(ui2.hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a(), ui2.hd_a().java_lang_String_a(), ui2.hf_a().azv_b().long_a(), ui2.hf_a().azv_c().long_a(), ui2.hf_a().gx_a(), ui2.hf_a().int_b(), ui2.hf_a().int_a(), ui2.hf_a().long_b(), uj.var_uj_a, ui2.hf_a().uh_a(), ui2.hf_a().uk_a(), ui2.hf_a().com_arenaofkings_packets_gameserver_data_LocationType_a(), ui2.hf_a().boolean_c(), ui2.hf_a().boolean_d()));
        } else if (ui2.getClass().getSuperclass() == ug.class) {
            Engine.a("cloning a FixedPlayerSpell");
            ui3 = ui2.var_da_a != null ? new ug(new ug.a().a(ui2.hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a(), ui2.hd_a().java_lang_String_a(), ui2.hf_a().azv_b().long_a(), ui2.hf_a().azv_c().long_a(), ui2.hf_a().gx_a(), ui2.hf_a().int_b(), ui2.hf_a().int_a(), ui2.hf_a().long_b(), uj.var_uj_a, ui2.hf_a().uh_a(), ui2.hf_a().uk_a(), ui2.hf_a().com_arenaofkings_packets_gameserver_data_LocationType_a(), ui2.hf_a().boolean_c(), ui2.hf_a().boolean_d()).a(ui2.var_da_a.ajw_a(), ui2.var_da_a.java_lang_String_a(), ui2.var_da_a.int_c(), ui2.var_da_a.float_b(), ui2.var_da_a.com_badlogic_gdx_graphics_g2d_Animation$PlayMode_a(), ui2.var_da_a.int_a(), ui2.var_da_a.int_b())) : new ug(new ug.a().a(ui2.hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a(), ui2.hd_a().java_lang_String_a(), ui2.hf_a().azv_b().long_a(), ui2.hf_a().azv_c().long_a(), ui2.hf_a().gx_a(), ui2.hf_a().int_b(), ui2.hf_a().int_a(), ui2.hf_a().long_b(), uj.var_uj_a, ui2.hf_a().uh_a(), ui2.hf_a().uk_a(), ui2.hf_a().com_arenaofkings_packets_gameserver_data_LocationType_a(), ui2.hf_a().boolean_c(), ui2.hf_a().boolean_d()));
        } else if (ui2.getClass().getSuperclass() == ue.class) {
            Engine.a("cloning a DynamicPlayerSpell");
            ui3 = ui2.var_da_a != null ? new ue(new ue.a().a(ui2.hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a(), ui2.hd_a().java_lang_String_a(), ui2.hf_a().azv_b().long_a(), ui2.hf_a().azv_c().long_a(), ui2.hf_a().gx_a(), ui2.hf_a().int_b(), ui2.hf_a().int_a(), ui2.hf_a().long_b(), uj.var_uj_a, ui2.hf_a().uh_a(), ui2.hf_a().uk_a(), ui2.hf_a().com_arenaofkings_packets_gameserver_data_LocationType_a(), ui2.hf_a().boolean_c(), ui2.hf_a().boolean_d()).a(ui2.var_da_a.ajw_a(), ui2.var_da_a.java_lang_String_a(), ui2.var_da_a.int_c(), ui2.var_da_a.float_b(), ui2.var_da_a.com_badlogic_gdx_graphics_g2d_Animation$PlayMode_a(), ui2.var_da_a.int_a(), ui2.var_da_a.int_b())) : new ue(new ue.a().a(ui2.hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a(), ui2.hd_a().java_lang_String_a(), ui2.hf_a().azv_b().long_a(), ui2.hf_a().azv_c().long_a(), ui2.hf_a().gx_a(), ui2.hf_a().int_b(), ui2.hf_a().int_a(), ui2.hf_a().long_b(), uj.var_uj_a, ui2.hf_a().uh_a(), ui2.hf_a().uk_a(), ui2.hf_a().com_arenaofkings_packets_gameserver_data_LocationType_a(), ui2.hf_a().boolean_c(), ui2.hf_a().boolean_d()));
        } else if (ui2.getClass().getSuperclass() == ul.class) {
            Engine.a("cloning a TargetedProjectileSpell");
            if (ui2.var_da_a != null) {
                ui3 = new ul(new ul.a().a(ui2.hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a(), ui2.hd_a().java_lang_String_a(), ui2.hf_a().azv_b().long_a(), ui2.hf_a().azv_c().long_a(), ui2.hf_a().gx_a(), ui2.hf_a().int_b(), ui2.hf_a().int_a(), ((gw)ui2.hf_a()).long_a(), ui2.hf_a().long_b(), uj.var_uj_a, ui2.hf_a().uh_a(), ui2.hf_a().uk_a(), ui2.hf_a().com_arenaofkings_packets_gameserver_data_LocationType_a(), ui2.hf_a().boolean_c(), ui2.hf_a().boolean_d()).a(ui2.var_da_a.ajw_a(), ui2.var_da_a.java_lang_String_a(), ui2.var_da_a.int_c(), ui2.var_da_a.float_b(), ui2.var_da_a.com_badlogic_gdx_graphics_g2d_Animation$PlayMode_a(), ui2.var_da_a.int_a(), ui2.var_da_a.int_b()).a(ui2.var_da_a.com_badlogic_gdx_graphics_Color_a()));
            }
            ui3 = ui2.var_da_a != null && ui2.var_da_b != null ? new ul(new ul.a().a(ui2.hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a(), ui2.hd_a().java_lang_String_a(), ui2.hf_a().azv_b().long_a(), ui2.hf_a().azv_c().long_a(), ui2.hf_a().gx_a(), ui2.hf_a().int_b(), ui2.hf_a().int_a(), ((gw)ui2.hf_a()).long_a(), ui2.hf_a().long_b(), uj.var_uj_a, ui2.hf_a().uh_a(), ui2.hf_a().uk_a(), ui2.hf_a().com_arenaofkings_packets_gameserver_data_LocationType_a(), ui2.hf_a().boolean_c(), ui2.hf_a().boolean_d()).a(ui2.var_da_a.ajw_a(), ui2.var_da_a.java_lang_String_a(), ui2.var_da_a.int_c(), ui2.var_da_a.float_b(), ui2.var_da_a.com_badlogic_gdx_graphics_g2d_Animation$PlayMode_a(), ui2.var_da_a.int_a(), ui2.var_da_a.int_b()).a(ui2.var_da_a.com_badlogic_gdx_graphics_Color_a()).b(ui2.var_da_b.ajw_a(), ui2.var_da_b.java_lang_String_a(), ui2.var_da_b.int_c(), ui2.var_da_b.float_b(), ui2.var_da_b.com_badlogic_gdx_graphics_g2d_Animation$PlayMode_a(), ui2.var_da_b.int_a(), ui2.var_da_b.int_b())) : new ul(new ul.a().a(ui2.hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a(), ui2.hd_a().java_lang_String_a(), ui2.hf_a().azv_b().long_a(), ui2.hf_a().azv_c().long_a(), ui2.hf_a().gx_a(), ui2.hf_a().int_b(), ui2.hf_a().int_a(), ((gw)ui2.hf_a()).long_a(), ui2.hf_a().long_b(), uj.var_uj_a, ui2.hf_a().uh_a(), ui2.hf_a().uk_a(), ui2.hf_a().com_arenaofkings_packets_gameserver_data_LocationType_a(), ui2.hf_a().boolean_c(), ui2.hf_a().boolean_d()));
        } else {
            Engine.a("spell type not yet implemented");
        }
        if (ui3 != null) {
            ui3.var_br_a = ui2.var_br_a;
            ui3.var_boolean_a = ui2.var_boolean_a;
            ui3.var_hf_a.a(ui2.java_lang_String_a());
            ui3.var_hf_a = new Array();
            if (ui3 != null) {
                Engine.a("Cloning optional spell parameters");
                ui3.hf_a().c(ui2.hf_a().e());
                ui3.hf_a().b(ui2.hf_a().int_c());
            }
            Engine.a("Successfully cloned a spell: " + ui3.getClass().getSimpleName());
        }
        return ui3;
    }

    public void a(axm axm2) {
        Engine.a("spell.loadAnimationGFX in");
        if (this.var_da_a != null && !this.var_da_a.ajw_a().a().equals("")) {
            if (this.var_br_a != null) {
                this.var_da_a.a(axm2, this.var_hf_a.e(), ay.ay_a().boolean_a(this.var_br_a));
            } else {
                this.var_da_a.a(axm2, this.var_hf_a.e(), false);
            }
        }
        if (this.var_da_a != null && this.var_da_a.boolean_b()) {
            Engine.a("resetting state time");
            this.var_da_a.a(0.0f);
        }
        Engine.a("spell.loadAnimationGFX out");
    }

    public void b(axm axm2) {
        Engine.a("loading icon");
        Engine.a("icon: " + (Object)((Object)this.var_hd_a.com_arenaofkings_packets_gameserver_data_updates_SpellName_a()) + " path:" + this.var_hd_a.java_lang_String_a());
        if (!this.var_hd_a.java_lang_String_a().equals("")) {
            this.var_hd_a.b(axm2);
        }
        Engine.a("done");
    }

    public void void_a() {
    }

    protected void void_b() {
        if (ay.ay_a().boolean_a(this.var_br_a)) {
            this.void_c();
        } else {
            this.d();
        }
    }

    protected void void_c() {
        Engine.a("friendly party size: " + ay.ay_a().gf_a().a().size());
        if (ay.ay_a().boolean_a(this.var_br_a)) {
            this.var_hf_a.a().clear();
            for (br br2 : ay.ay_a().gf_a().a().values()) {
                Engine.a("adding location " + br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().java_lang_String_a());
                this.var_hf_a.a(new Target(br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().java_lang_String_a()));
            }
        } else {
            Engine.a("not partied");
        }
    }

    protected void d() {
        Engine.a("enemy party size: " + ay.ay_a().gf_a().a().size());
        if (!ay.ay_a().boolean_a(this.var_br_a)) {
            this.var_hf_a.a().clear();
            for (br br2 : ay.ay_a().ge_a().a().values()) {
                this.var_hf_a.a(new Target(br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().java_lang_String_a()));
            }
        }
    }

    protected void e() {
        this.var_hf_a.a().add(new Location(new Target(this.var_br_a.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().java_lang_String_a())));
    }

    public boolean boolean_a() {
        return this.var_hf_a.uk_a() == uk.var_uk_a || this.var_hf_a.azv_b().long_a() == 0L;
    }

    public br br_a() {
        return this.var_br_a;
    }

    public da da_a() {
        return this.var_da_a;
    }

    public boolean boolean_b() {
        return this.var_boolean_b;
    }

    public azo azo_a() {
        return this.var_azo_a;
    }

    public azo azo_b() {
        return this.var_azo_b;
    }

    public hf hf_a() {
        return this.var_hf_a;
    }

    public hd hd_a() {
        return this.var_hd_a;
    }

    public ArrayList<Location> a() {
        return this.var_hf_a.a();
    }

    public da da_b() {
        return this.var_da_b;
    }

    public void a(br br2) {
        this.var_br_a = br2;
    }

    public void a(Location location) {
        this.var_hf_a.a(location);
    }

    public String java_lang_String_a() {
        return this.var_hf_a.java_lang_String_a();
    }

    public boolean boolean_c() {
        return this.c;
    }

    public void a(boolean bl2) {
        this.c = bl2;
    }

    public static int a(double d2) {
        if (ay.ay_a() != null && ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a() != null && ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity() != null) {
            return (int)((double)ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_b(dz.class) * d2);
        }
        return (int)d2;
    }

    public void a(int n2) {
        this.var_hf_a.c(n2);
    }

    public int int_a() {
        return this.var_hf_a.int_d();
    }

    public void a(float f2) {
        if (this.var_azo_a != null) {
            this.var_azo_a.b(f2);
        }
        if (this.var_azo_b != null) {
            this.var_azo_a.b(f2);
        }
    }

    public String toString() {
        String string = "";
        if (this.var_hf_a != null) {
            string = string + this.var_hf_a.toString() + "\t";
        }
        if (this.var_br_a != null) {
            string = string + this.var_br_a.toString() + "\t";
        }
        string = string + " done= " + this.var_boolean_a;
        if (this.var_hd_a != null) {
            string = string + this.var_hd_a.toString() + "\t";
        }
        if (this.var_da_a != null) {
            string = string + this.var_da_a.toString() + "\t";
        }
        return string;
    }
}

