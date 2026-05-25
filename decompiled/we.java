/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.loginserver.PUB_LOBBY_SPECTATE_UPDATE;
import com.arenaofkings.packets.loginserver.PUB_TRADE_ACTION;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Array;

public class we
extends axc {
    private InputMultiplexer var_com_badlogic_gdx_InputMultiplexer_a = new InputMultiplexer();
    private Class<? extends axc> var_java_lang_Class___extends_axc__a;
    private Label var_com_badlogic_gdx_scenes_scene2d_ui_Label_a;
    private Label.LabelStyle var_com_badlogic_gdx_scenes_scene2d_ui_Label$LabelStyle_a;
    private azv var_azv_a = new azv(20000L, true);
    private boolean var_boolean_a = false;

    public we(Engine engine, ayl ayl2) {
        super(engine, ayl2);
        engine.var_u_a.finishLoading();
        Engine.a("Lobby()");
    }

    @Override
    public void show() {
        Engine.a("Lobby.show()");
        ((Engine)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).var_or_a.a(((axm)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.jc));
        Engine.a("Lobby.show() 2");
        this.var_com_badlogic_gdx_InputMultiplexer_a = new wh((axm)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a), (Engine)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a));
        for (Actor object2 : ((aya)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).com_badlogic_gdx_scenes_scene2d_Stage_c().getActors()) {
            if (!(object2 instanceof d)) continue;
            Engine.b("b contains chat label: " + ((d)object2).getX() + " " + ((d)object2).getText());
        }
        ((wh)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).wg_a().k();
        for (Actor actor : ((aya)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).com_badlogic_gdx_scenes_scene2d_Stage_c().getActors()) {
            if (!(actor instanceof d)) continue;
            Engine.b("c contains chat label: " + ((d)actor).getX() + " " + ((d)actor).getText());
        }
        ay.ay_a().gd_a().bu_a().a(((aya)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).com_badlogic_gdx_scenes_scene2d_Stage_c());
        Engine.a("Lobby.show() 3");
        this.void_c();
        Engine.a("Lobby.show() 4");
        this.d();
        Engine.a("Lobby.show() 5");
        Engine.b("Lobby show 6");
        if (this.boolean_c()) {
            Engine.b("Lobby hasOptionalScreenData: " + ((xz)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).b);
            if (((xz)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).b == 1) {
                Engine.b("Lobby open 1");
                ((wh)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).yg_a().a(true);
                ((wh)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).yg_a().void_d();
            } else if (((xz)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).b == 2) {
                Engine.b("Lobby open 2");
                ((wh)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).yg_a().a(true);
                ((wh)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).yg_a().void_e();
            } else if (((xz)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).b == 3) {
                Engine.b("Lobby open 3");
                ((wh)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).yg_a().a(true);
                ((wh)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).yg_a().f();
            }
        }
        Engine.b("Lobby show 7 data: " + ay.ay_a().gd_a().i());
        if (ay.ay_a().gd_a().i() == 1) {
            for (br br2 : ay.ay_a().gf_a().a().values()) {
                if (br2 == ay.ay_a()) continue;
                br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().h(100);
            }
            ((wh)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).f();
            ((wh)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).yp_a().b(1);
            ((wh)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).yg_a().a(true);
            ((wh)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).yg_a().void_d();
        } else if (ay.ay_a().gd_a().i() == 2) {
            for (br br3 : ay.ay_a().gf_a().a().values()) {
                if (br3 == ay.ay_a()) continue;
                br3.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().h(100);
            }
            ((wh)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).f();
            ((wh)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).yp_a().b(2);
            ((wh)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).yg_a().a(ay.ay_a().gd_a().zg_a(), true, false);
            ((wh)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).yg_a().g();
            ((wh)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).yg_a().a(true);
            ((wh)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).yg_a().void_e();
        } else if (ay.ay_a().gd_a().i() == 3) {
            for (br br4 : ay.ay_a().gf_a().a().values()) {
                if (br4 == ay.ay_a()) continue;
                br4.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().h(100);
            }
            ((wh)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).f();
            ((wh)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).yp_a().b(3);
            ((wh)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).yg_a().a(ay.ay_a().gd_a().zg_a(), false, true);
            ((wh)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).yg_a().g();
            ((wh)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).yg_a().a(true);
            ((wh)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).yg_a().f();
        }
        Engine.a("Lobby.show() 6");
        this.var_com_badlogic_gdx_InputMultiplexer_a.addProcessor(new aal((Engine)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a), this));
        this.var_com_badlogic_gdx_InputMultiplexer_a.addProcessor(((aya)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).com_badlogic_gdx_scenes_scene2d_Stage_c());
        this.var_com_badlogic_gdx_InputMultiplexer_a.addProcessor(((wh)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).com_badlogic_gdx_scenes_scene2d_Stage_a());
        this.var_com_badlogic_gdx_InputMultiplexer_a.addProcessor(((wh)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).com_badlogic_gdx_scenes_scene2d_Stage_b());
        Engine.a("Lobby.show() 6.1");
        Gdx.input.setInputProcessor(this.var_com_badlogic_gdx_InputMultiplexer_a);
        Engine.a("Lobby.show() 6.2");
        Engine.a("Lobby.show() 6.3");
        for (fm fm2 : ay.ay_a().gd_a().as_a().a()) {
            fm2.a((axm)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a), true);
        }
        Engine.a("Lobby.show() 6.4");
        Object object3 = null;
        Object var2_14 = null;
        Engine.a("Lobby.show() 6.5");
        for (int i2 = 0; i2 < ay.ay_a().gd_a().bu_a().a().size(); ++i2) {
            Engine.a("Lobby.show() 6.51");
            bz bz2 = ay.ay_a().gd_a().bu_a().a().get(i2);
            if (bz2 == null) continue;
            Engine.a("Lobby.show() 6.52");
            for (int i3 = 0; i3 < 112; ++i3) {
                object3 = bz2.fm_a(i3);
                if (object3 != null) {
                    ((fm)object3).b(false);
                    ((fm)object3).a((axm)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a), true);
                } else {
                    Engine.b("cache item was null");
                }
                Engine.a("j out");
            }
        }
        Engine.a("Lobby.show() 6.6");
        ((Engine)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).var_hg_a.b();
        Engine.a("Lobby.show() 6.7");
        ay.ay_a().gd_a().cg_a().void_d();
        Engine.a("Lobby.show() 6.8");
        Engine.a("Lobby.show() 7");
        this.var_com_badlogic_gdx_scenes_scene2d_ui_Label$LabelStyle_a = new Label.LabelStyle(((Engine)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).j, Color.WHITE);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_Label_a = new Label((CharSequence)"", this.var_com_badlogic_gdx_scenes_scene2d_ui_Label$LabelStyle_a);
        ay.ay_a().gd_a().ev_a().void_a("Game");
        if (this.boolean_c()) {
            xz xz2 = (xz)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a);
            if (!xz2.var_boolean_a && xz2.var_int_a == 0) {
                ay.ay_a().gd_a().as_a().void_d();
                if (ay.ay_a().gd_a().as_a().boolean_b()) {
                    ((wh)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).wg_a().a("[ERROR]Your Inventory is full! You can Sell items to the Vendor for Silver.");
                } else if (ay.ay_a().gd_a().as_a().int_d() <= 4) {
                    ((wh)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).wg_a().a("[ERROR]Your Inventory is almost full! You can Sell items to the Vendor for Silver.");
                }
            }
        }
        this.void_a();
        for (Actor actor : ((aya)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).com_badlogic_gdx_scenes_scene2d_Stage_c().getActors()) {
            if (!(actor instanceof d)) continue;
            Engine.b("d contains chat label: " + ((d)actor).getX() + " " + ((d)actor).getText());
        }
    }

    private void void_c() {
        ay.ay_a().gd_a().azv_b().d();
        Engine.a("loadPlayers() in. Size of friendlyParty: " + ay.ay_a().gf_a().a().size());
        for (br br2 : ay.ay_a().gf_a().a().values()) {
            br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().cr_a().c(true);
            Engine.a("loading player " + br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().java_lang_String_a());
            gt gt2 = (gt)br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().gz_a();
            if (gt2 != null) {
                for (ui ui2 : gt2.ui_arr_a()) {
                    if (ui2 == null) {
                        Engine.a("spell is null");
                        continue;
                    }
                    Engine.a(ui2.toString());
                }
            } else {
                Engine.a("friendly spellbar is null");
            }
            Engine.a("pre assets toString");
            br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().cr_a().void_c();
            br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().cr_a().void_d();
            br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().bd_a().b(false);
            br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().bd_a().a((axm)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a), ajw.c, true, false);
            ((gt)br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().gz_a()).a(((we)((Engine)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).axc_a()).axm_a());
            if (ay.ay_a() != br2) continue;
            ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().cr_a().i();
            ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().gu_a().e();
        }
    }

    private void d() {
        ((Array)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).add(((wh)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).var_ayh_a);
        ((Array)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).add(((wh)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).var_ayf_g);
        ((Array)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).add(((wh)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).var_ayf_h);
        ((Array)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).add(((wh)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).var_ayf_j);
        ((Array)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).add(((wh)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).var_ayf_l);
        ((Array)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).add(((wh)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).var_ayf_n);
        ((Array)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).add(((wh)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).p);
        ((Array)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).add(((wh)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).var_ayc_a);
        ((Array)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).add(((wh)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).t);
        ((Array)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).add(((wh)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).var_ayf_b);
        ((Array)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).add(((wh)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).var_ayf_d);
        ((Array)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).add(((wh)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).var_ayf_c);
        ((Array)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).add(((wh)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).var_ayh_d);
        ((Array)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).add(((wh)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).var_ayf_a);
    }

    @Override
    public void render(float f2) {
        Gdx.gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        Gdx.gl.glClear(16384);
        ((Engine)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).var_azi_a.enableBlending();
        ((Engine)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).e();
        ((Engine)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).f();
        ((Engine)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).a(((Engine)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).var_azi_a);
        if (((Engine)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).boolean_a()) {
            return;
        }
        ay.ay_a().gd_a().cg_a().g();
        if (this.var_azv_a.boolean_b()) {
            this.void_a();
        }
        if (this.var_com_badlogic_gdx_InputMultiplexer_a != null) {
            ((Engine)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).setScreen(new wb((Engine)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a), new wd(true)));
            return;
        }
        if (Gdx.input.isKeyJustPressed(111) && t.a(we.class, (Engine)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a))) {
            we we2 = (we)((Engine)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).axc_a();
            Engine.b("ESCAPE" + this.var_boolean_a);
            if (((wh)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).wg_a().axh_a().hasKeyboardFocus() && ((wh)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).wg_a().axh_a().java_lang_String_a().length() > 0) {
                ((wh)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).wg_a().axh_a().b("");
                ((wh)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).com_badlogic_gdx_scenes_scene2d_Stage_c().setKeyboardFocus(null);
                this.var_boolean_a = true;
            }
            if (((Engine)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).boolean_c()) {
                Engine.b("ESCAPE 1" + this.var_boolean_a);
                this.var_boolean_a = true;
            }
            Engine.b("ESCAPE 2" + this.var_boolean_a);
            if (!this.var_boolean_a && we2.wh_a().fm_a() != null) {
                we2.wh_a().a((fm)null);
                this.var_boolean_a = true;
                Engine.b("ESCAPE 3" + this.var_boolean_a);
            }
            Engine.b("ESCAPE 4" + this.var_boolean_a);
            if (!this.var_boolean_a && ay.ay_a().gd_a().ca_a().boolean_a()) {
                PUB_TRADE_ACTION pUB_TRADE_ACTION = new PUB_TRADE_ACTION();
                pUB_TRADE_ACTION.action = 0;
                ((Engine)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).var_z_a.void_a(pUB_TRADE_ACTION);
                ay.ay_a().gd_a().ca_a().void_a();
                this.var_boolean_a = true;
                Engine.b("ESCAPE 5" + this.var_boolean_a);
            }
            Engine.b("ESCAPE 6" + this.var_boolean_a);
            if (!this.var_boolean_a && ay.ay_a().gd_a().cg_a().boolean_a()) {
                ay.ay_a().gd_a().cg_a().f();
                this.var_boolean_a = true;
            }
            if (!this.var_boolean_a && ay.ay_a().gd_a().as_a().boolean_a() && ay.ay_a().gd_a().bu_a().boolean_a()) {
                ay.ay_a().gd_a().as_a().f();
                ay.ay_a().gd_a().bu_a().d();
                this.var_boolean_a = true;
            } else if (!this.var_boolean_a && ay.ay_a().gd_a().as_a().boolean_a()) {
                ay.ay_a().gd_a().as_a().f();
                this.var_boolean_a = true;
            } else if (!this.var_boolean_a && ay.ay_a().gd_a().bu_a().boolean_a()) {
                ay.ay_a().gd_a().bu_a().void_c();
                this.var_boolean_a = true;
            }
        }
        this.a(((Engine)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).var_azi_a);
        if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bd_a() != null && !ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bd_a().g()) {
            ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bd_a().a((axm)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a), ajw.c, true, false);
        }
        ((Engine)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).var_azi_a.c(f2, (Array<axr>)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a));
        ((Engine)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).var_azi_a.a(f2, (Array<axr>)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a));
        this.var_com_badlogic_gdx_InputMultiplexer_a.a(f2, ((Engine)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).var_azi_a);
        ((aya)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).var_com_badlogic_gdx_scenes_scene2d_Stage_a.act(f2);
        ((aya)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).var_com_badlogic_gdx_scenes_scene2d_Stage_a.draw();
        ((Engine)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).var_azi_a.begin();
        ((wh)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).a(f2, (Engine)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a));
        ((wh)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).zi_a().aaf_a().c(f2, (Engine)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a));
        if (((wh)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).yu_a().boolean_b()) {
            ((wh)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).yu_a().c(f2, (Engine)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a));
        }
        ((Engine)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).var_azi_a.end();
        this.b(((Engine)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).var_azi_a);
        this.var_boolean_a = false;
    }

    public void void_a() {
        this.var_azv_a.void_c();
        PUB_LOBBY_SPECTATE_UPDATE pUB_LOBBY_SPECTATE_UPDATE = new PUB_LOBBY_SPECTATE_UPDATE();
        ((Engine)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).var_z_a.void_a(pUB_LOBBY_SPECTATE_UPDATE);
    }

    @Override
    public void resize(int n2, int n3) {
        super.resize(n2, n3);
        this.wh_a().var_wg_a.j();
        ((aya)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).com_badlogic_gdx_scenes_scene2d_Stage_c().getViewport().update(n2, n3);
    }

    @Override
    public void dispose() {
        Engine.b("LOBBY DISPOSE CALLED");
        super.dispose();
    }

    public void b() {
        ((wh)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a)).void_c();
    }

    @Override
    public wh wh_a() {
        return (wh)((Object)this.var_com_badlogic_gdx_InputMultiplexer_a);
    }

    public void a(Class<? extends axc> clazz) {
        this.var_com_badlogic_gdx_InputMultiplexer_a = clazz;
    }
}

