/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.ArenaTeamData;
import com.arenaofkings.packets.misc.ArenaTeamMemberData;
import com.arenaofkings.packets.misc.ReadyStatus;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class yg
extends yf {
    private final Engine var_com_arenaofkings_client_core_Engine_a;
    private ayf var_ayf_a;
    private azv var_azv_a = new azv(10000L, true);
    private ayf var_ayf_b;
    private ayf var_ayf_c;
    private ayh var_ayh_b;
    private ayh var_ayh_c;
    private boolean var_boolean_b = false;
    public boolean var_boolean_a = false;
    private azv var_azv_b = new azv(1750L, true);
    private zo var_zo_a;
    private zg var_zg_a;
    private boolean var_boolean_c;
    private boolean var_boolean_d;
    private boolean var_boolean_e;
    private ayh var_ayh_d;
    private ayh var_ayh_e;
    private ayh var_ayh_f;
    private ayh var_ayh_g;
    private ayh h;
    private boolean var_boolean_f;
    private ayh i;
    private ayh j;
    private boolean var_boolean_g;

    public yg(Engine engine, TextureAtlas textureAtlas) {
        super(0, 0, textureAtlas, "playframe");
        ((ayh)((Object)this.var_com_arenaofkings_client_core_Engine_a)).a(357, 372);
        this.var_com_arenaofkings_client_core_Engine_a = engine;
        this.var_ayh_c = new ayh(408, 387, textureAtlas, "ascension_game_mode", true);
        this.var_ayh_e = new ayh(0, 0, textureAtlas, "role_dps_icon", true);
        this.var_ayh_d = new ayh(0, 0, textureAtlas, "role_healer_icon", true);
        this.var_ayh_f = new ayh(459, 416, textureAtlas, "role_frame_ranked", true);
        this.var_ayf_a = new yh(this, 840, 495, textureAtlas, "ready_button_default", "ready_button_hovered", true, engine);
        this.var_ayf_c = new yi(this, 859, 390, textureAtlas, "cancel_button_default", "cancel_button_hovered", false, engine);
        this.var_ayh_b = new ayh(840, 460, textureAtlas, "searching_button3", true);
        this.h = new yj(this, 650, 460, textureAtlas, "mtx_box", true, engine);
        this.var_ayh_g = new ayh(653, 460, textureAtlas, "mtx_checkmark", true);
        this.j = new yk(this, 650, 421, textureAtlas, "mtx_box", true, engine);
        this.i = new ayh(653, 421, textureAtlas, "mtx_checkmark", true);
    }

    public void a(yp yp2, Stage stage, Engine engine, TextureAtlas textureAtlas) {
        this.var_ayf_b = new yl(this, 859, 390, textureAtlas, "quit_button_default", "quit_button_hovered", true, engine, yp2, stage);
    }

    @Override
    public void a(float f2, Engine engine) {
        if (((ayh)((Object)this.var_com_arenaofkings_client_core_Engine_a)).boolean_b()) {
            if (ay.ay_a().com_arenaofkings_packets_misc_PartyRole_a() != null) {
                switch (ay.ay_a().com_arenaofkings_packets_misc_PartyRole_a()) {
                    case BOTH: {
                        this.var_boolean_f = true;
                        this.var_boolean_g = true;
                        break;
                    }
                    case DPS: {
                        this.var_boolean_f = true;
                        this.var_boolean_g = false;
                        break;
                    }
                    case HEALER: {
                        this.var_boolean_g = true;
                        this.var_boolean_f = false;
                        break;
                    }
                    case NONE: {
                        this.var_boolean_f = false;
                        this.var_boolean_g = false;
                        break;
                    }
                }
            }
            this.var_ayf_a.a(f2, engine);
            this.var_ayf_b.a(f2, engine);
            this.var_ayf_c.a(f2, engine);
            this.var_ayh_b.a(f2, engine);
            this.var_ayh_c.a(f2, engine);
        }
        if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bd_a().com_arenaofkings_packets_misc_ReadyStatus_a() == ReadyStatus.GREEN || ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bd_a().com_arenaofkings_packets_misc_ReadyStatus_a() == ReadyStatus.YELLOW) {
            this.void_b();
        } else {
            this.void_c();
        }
        this.var_boolean_e = false;
    }

    @Override
    public void b(float f2, Engine engine) {
        this.a(f2, engine);
        if (((ayh)((Object)this.var_com_arenaofkings_client_core_Engine_a)).boolean_b()) {
            super.b(f2, engine);
            this.var_ayf_a.b(f2, engine);
            this.var_ayf_b.b(f2, engine);
            this.var_ayf_c.b(f2, engine);
            this.var_ayh_b.b(f2, engine);
            if (this.var_azv_b.boolean_b()) {
                this.var_azv_b.void_c();
            }
            if (!ay.ay_a().gd_a().boolean_e() && this.var_boolean_d && ay.ay_a().gf_a().a().size() < 3) {
                this.var_ayh_f.b(f2, engine);
                this.h.a(f2, engine);
                this.h.b(f2, engine);
                this.h.b(f2, engine);
                this.j.a(f2, engine);
                this.j.b(f2, engine);
                this.j.b(f2, engine);
                if (this.var_boolean_f) {
                    this.var_ayh_g.b(f2, engine);
                }
                if (this.var_boolean_g) {
                    this.i.b(f2, engine);
                }
            }
            if ((this.var_boolean_d || this.var_boolean_c) && this.var_zg_a != null && this.var_zo_a != null && ay.ay_a().gf_a().a().size() == 3) {
                this.var_zo_a.c(f2, engine);
            }
            if (this.var_boolean_c) {
                engine.a("Ranked 3v3 Team", engine.var_axy_e.a(), Color.RED, engine.var_axy_e.a(), Color.BLACK, 960.0f, 988.0f, 1);
            } else if (this.var_boolean_d) {
                if (ay.ay_a().gf_a().a() < 2 && ay.ay_a().gd_a().azv_b().boolean_a()) {
                    engine.a("" + (60L - ay.ay_a().gd_a().azv_b().a(TimeUnit.SECONDS)), engine.var_axy_e.a(), Color.WHITE, engine.var_axy_e.a(), Color.BLACK, 960.0f, 1007.0f, 1);
                }
                engine.a("Ranked 3v3 Solo", engine.var_axy_e.a(), Color.RED, engine.var_axy_e.a(), Color.BLACK, 960.0f, 988.0f, 1);
            } else {
                engine.a("Quick Play 3v3", engine.var_axy_e.a(), Color.GREEN, engine.var_axy_e.a(), Color.BLACK, 960.0f, 988.0f, 1);
            }
            block33: for (br br2 : ay.ay_a().gf_a().a().values()) {
                if (!br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().bd_a().g()) {
                    br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().bd_a().a(((we)engine.axc_a()).axm_a(), ajw.c, true, false);
                    ((gt)br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().gz_a()).a(((we)engine.axc_a()).axm_a());
                }
                if (br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().cr_a().da_a() == null) {
                    br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().cr_a().a(false);
                }
                if (!br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().bd_a().boolean_a()) {
                    br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().bd_a().c(((we)engine.axc_a()).axm_a());
                }
                if (!br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().bd_a().boolean_b()) {
                    br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().bd_a().a(((we)engine.axc_a()).axm_a(), false);
                }
                if (!br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().bd_a().e()) {
                    br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().bd_a().a(((we)engine.axc_a()).axm_a());
                }
                if (!br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().bd_a().boolean_c()) {
                    br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().bd_a().b(((we)engine.axc_a()).axm_a(), false);
                }
                if (!br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().bd_a().f()) {
                    br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().bd_a().a(((we)engine.axc_a()).axm_a().com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.jm));
                }
                if (!br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().bd_a().d()) {
                    br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().bd_a().c(((we)engine.axc_a()).axm_a(), false);
                }
                if (br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().int_h() == 1) {
                    if (this.var_boolean_c || this.var_boolean_d) {
                        br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().bd_a().b(f2, engine, 415, 650, true, true, true, true);
                    } else {
                        br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().bd_a().b(f2, engine, 415, 650, true, true, true, false);
                    }
                    if (br2.com_arenaofkings_packets_misc_PartyRole_a() != null) {
                        switch (br2.com_arenaofkings_packets_misc_PartyRole_a()) {
                            case DPS: {
                                this.var_ayh_e.b(f2, engine, 713, 903);
                                break;
                            }
                            case HEALER: {
                                this.var_ayh_d.b(f2, engine, 713, 903);
                                break;
                            }
                            case BOTH: {
                                this.var_ayh_e.b(f2, engine, 691, 903);
                                this.var_ayh_d.b(f2, engine, 713, 903);
                                break;
                            }
                            case NONE: {
                                break;
                            }
                        }
                    }
                    switch (br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().bd_a().com_arenaofkings_packets_misc_ReadyStatus_a()) {
                        case GREEN: {
                            continue block33;
                        }
                        case RED: {
                            if (this.var_azv_b.a(TimeUnit.MILLISECONDS) <= 275L) continue block33;
                            engine.a("NOT READY", engine.var_axy_c.a(), axe.v, engine.var_axy_c.a(), Color.BLACK, 571.0f, 865.0f, 1, 1);
                            continue block33;
                        }
                        case YELLOW: {
                            continue block33;
                        }
                    }
                    continue;
                }
                if (br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().int_h() == 2) {
                    if (this.var_boolean_c || this.var_boolean_d) {
                        br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().bd_a().b(f2, engine, 808, 650, true, true, true, true);
                    } else {
                        br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().bd_a().b(f2, engine, 808, 650, true, true, true, false);
                    }
                    if (br2.com_arenaofkings_packets_misc_PartyRole_a() != null) {
                        switch (br2.com_arenaofkings_packets_misc_PartyRole_a()) {
                            case DPS: {
                                this.var_ayh_e.b(f2, engine, 1076, 903);
                                break;
                            }
                            case HEALER: {
                                this.var_ayh_d.b(f2, engine, 1076, 903);
                                break;
                            }
                            case BOTH: {
                                this.var_ayh_e.b(f2, engine, 1054, 903);
                                this.var_ayh_d.b(f2, engine, 1076, 903);
                                break;
                            }
                            case NONE: {
                                break;
                            }
                        }
                    }
                    switch (br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().bd_a().com_arenaofkings_packets_misc_ReadyStatus_a()) {
                        case GREEN: {
                            continue block33;
                        }
                        case RED: {
                            if (this.var_azv_b.a(TimeUnit.MILLISECONDS) <= 275L) continue block33;
                            engine.a("NOT READY", engine.var_axy_c.a(), axe.v, engine.var_axy_c.a(), Color.BLACK, 964.0f, 865.0f, 1, 1);
                            continue block33;
                        }
                        case YELLOW: {
                            continue block33;
                        }
                    }
                    continue;
                }
                if (br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().int_h() == 3) {
                    if (this.var_boolean_c || this.var_boolean_d) {
                        br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().bd_a().b(f2, engine, 1201, 650, true, true, true, true);
                    } else {
                        br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().bd_a().b(f2, engine, 1201, 650, true, true, true, false);
                    }
                    if (br2.com_arenaofkings_packets_misc_PartyRole_a() != null) {
                        switch (br2.com_arenaofkings_packets_misc_PartyRole_a()) {
                            case DPS: {
                                this.var_ayh_e.b(f2, engine, 1441, 903);
                                break;
                            }
                            case HEALER: {
                                this.var_ayh_d.b(f2, engine, 1441, 903);
                                break;
                            }
                            case BOTH: {
                                this.var_ayh_e.b(f2, engine, 1419, 903);
                                this.var_ayh_d.b(f2, engine, 1441, 903);
                                break;
                            }
                            case NONE: {
                                break;
                            }
                        }
                    }
                    switch (br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().bd_a().com_arenaofkings_packets_misc_ReadyStatus_a()) {
                        case GREEN: {
                            continue block33;
                        }
                        case RED: {
                            if (this.var_azv_b.a(TimeUnit.MILLISECONDS) <= 275L) continue block33;
                            engine.a("NOT READY", engine.var_axy_c.a(), axe.v, engine.var_axy_c.a(), Color.BLACK, 1356.0f, 865.0f, 1, 1);
                            continue block33;
                        }
                        case YELLOW: {
                            continue block33;
                        }
                    }
                    continue;
                }
                if (br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().int_h() != 4) continue;
                br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().bd_a().b(f2, engine, 1050, 650, true, true, true, true);
            }
        }
    }

    public void c(float f2, Engine engine) {
        for (br br2 : ay.ay_a().gf_a().a().values()) {
            if (br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().int_h() == 1) {
                if (!this.boolean_b()) continue;
                br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().gz_a().b(f2, engine);
                continue;
            }
            if (br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().int_h() == 2) {
                if (!this.boolean_b()) continue;
                ((gt)br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().gz_a()).c(f2, engine);
                continue;
            }
            if (br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().int_h() != 3 || !this.boolean_b()) continue;
            ((gt)br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().gz_a()).c(f2, engine);
        }
    }

    public void void_a() {
        this.var_ayf_b.f();
        this.var_ayf_a.f();
        this.var_ayf_c.f();
        this.var_ayh_b.g();
    }

    public void void_b() {
        this.var_ayh_b.a(true);
        this.var_ayf_c.a(true);
        this.var_ayf_b.a(false);
        this.var_ayf_a.a(false);
    }

    public void void_c() {
        this.var_ayh_b.a(false);
        this.var_ayf_c.a(false);
        this.var_ayf_b.a(true);
        this.var_ayf_a.a(true);
    }

    @Override
    public void a(Stage stage) {
        super.a(stage);
        this.var_ayf_a.a(true);
        this.var_ayf_b.a(true);
        this.var_ayf_c.a(false);
        this.var_ayh_b.a(false);
        this.var_ayh_c.a(true);
    }

    @Override
    public void b(Stage stage) {
        super.b(stage);
        this.var_ayf_a.a(false);
        this.var_ayf_b.a(false);
        this.var_ayf_c.a(false);
        this.var_ayh_c.a(false);
        this.var_ayh_b.a(false);
    }

    public boolean boolean_a() {
        return this.var_boolean_b;
    }

    public void a(boolean bl2) {
        this.var_boolean_b = bl2;
    }

    public void void_d() {
        this.var_boolean_c = false;
        this.var_boolean_d = false;
    }

    public void void_e() {
        this.var_boolean_c = true;
        this.var_boolean_d = false;
    }

    public void f() {
        this.var_boolean_d = true;
        this.var_boolean_c = false;
    }

    public boolean boolean_c() {
        return this.var_boolean_d;
    }

    public boolean boolean_d() {
        return this.var_boolean_c;
    }

    public void a(zg zg2, boolean bl2, boolean bl3) {
        System.out.println("useTeamRating: " + bl2 + " useSoloRating: " + bl3);
        if (zg2 == null) {
            System.out.println("Team is null");
            zg2 = bl2 ? new zg(new ArenaTeamData(ay.ay_a().gf_a().a().a(0).getValue().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().java_lang_String_a() + "'s team", ay.ay_a().gf_a().c(), "", "Unknown", "BB-0", -1, 0, 0, 0, ay.ay_a().gf_a().b(), "", new ArrayList<ArenaTeamMemberData>(), false)) : new zg(new ArenaTeamData(ay.ay_a().gf_a().a().a(0).getValue().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().java_lang_String_a() + "'s team", ay.ay_a().gf_a().d(), "", "Unknown", "BB-0", -1, 0, 0, 0, ay.ay_a().gf_a().b(), "", new ArrayList<ArenaTeamMemberData>(), false));
        }
        this.var_zg_a = zg2;
        ay.ay_a().gd_a().b(zg2);
        this.var_zo_a = new zo(this.var_com_arenaofkings_client_core_Engine_a, this.var_com_arenaofkings_client_core_Engine_a.axc_a().aya_a().com_badlogic_gdx_scenes_scene2d_Stage_c(), this.var_com_arenaofkings_client_core_Engine_a.axc_a().axm_a(), 1146, 434, zg2.f(), zg2.java_lang_String_a(), zg2.java_lang_String_b(), zg2.int_a(), zg2.int_b(), zg2.java_lang_String_d(), zg2.java_lang_String_c(), "", zg2.int_e());
        this.var_zo_a.b(true);
        this.var_zo_a.a(zg2.f());
    }

    public void g() {
        System.out.println("panel to open is: " + ay.ay_a().gd_a().i());
        if (ay.ay_a().gd_a().i() == 2) {
            int n2 = 0;
            for (br br2 : ay.ay_a().gf_a().a().values()) {
                n2 += br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().int_j();
            }
            if (n2 == 0) {
                n2 = 1;
            }
            n2 /= ay.ay_a().gf_a().a().values().size();
            if (this.var_zo_a != null) {
                this.var_zo_a.a(n2);
            }
        } else if (ay.ay_a().gd_a().i() == 3) {
            int n3 = 0;
            for (br br3 : ay.ay_a().gf_a().a().values()) {
                n3 += br3.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().k();
            }
            if (n3 == 0) {
                n3 = 1;
            }
            n3 /= ay.ay_a().gf_a().a().values().size();
            if (this.var_zo_a != null) {
                this.var_zo_a.a(n3);
            }
        }
    }

    public boolean boolean_e() {
        return this.var_boolean_a;
    }

    public void a(ArenaTeamData arenaTeamData) {
        if (arenaTeamData != null) {
            this.a(new zg(arenaTeamData), true, false);
        }
    }

    static /* synthetic */ boolean a(yg yg2) {
        return yg2.var_boolean_c;
    }

    static /* synthetic */ boolean b(yg yg2) {
        return yg2.var_boolean_d;
    }

    static /* synthetic */ boolean c(yg yg2) {
        return yg2.var_boolean_f;
    }

    static /* synthetic */ boolean d(yg yg2) {
        return yg2.var_boolean_g;
    }

    static /* synthetic */ boolean a(yg yg2, boolean bl2) {
        yg2.var_boolean_f = bl2;
        return yg2.var_boolean_f;
    }

    static /* synthetic */ boolean b(yg yg2, boolean bl2) {
        yg2.var_boolean_g = bl2;
        return yg2.var_boolean_g;
    }

    static /* synthetic */ boolean c(yg yg2, boolean bl2) {
        yg2.var_boolean_c = bl2;
        return yg2.var_boolean_c;
    }

    static /* synthetic */ boolean d(yg yg2, boolean bl2) {
        yg2.var_boolean_d = bl2;
        return yg2.var_boolean_d;
    }
}

