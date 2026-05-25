/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.loginserver.PUB_MISC_CHAT_MESSAGE;
import com.arenaofkings.packets.loginserver.PUB_PARTY_INVITE;
import com.arenaofkings.packets.misc.ArenaName;
import com.arenaofkings.packets.misc.ArenaTeamData;
import com.arenaofkings.packets.misc.CharacterClass;
import com.arenaofkings.packets.misc.items.ItemSlot;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.utils.Array;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.time.StopWatch;

public class wh
extends aya {
    protected ayf var_ayf_a;
    protected ayf var_ayf_b;
    protected ayf var_ayf_c;
    protected ayf var_ayf_d;
    protected ayf var_ayf_e;
    protected ayh var_ayh_a;
    protected ayh var_ayh_b;
    protected ayg var_ayg_a;
    protected ayf var_ayf_f;
    protected ayf var_ayf_g;
    protected ayg var_ayg_b;
    protected ayf var_ayf_h;
    protected ayf var_ayf_i;
    protected ayg var_ayg_c;
    protected ayf var_ayf_j;
    protected ayf var_ayf_k;
    protected ayg var_ayg_d;
    protected ayf var_ayf_l;
    protected ayf var_ayf_m;
    protected ayg var_ayg_e;
    protected ayf var_ayf_n;
    protected ayf var_ayf_o;
    protected ayg var_ayg_f;
    protected ayf p;
    protected ayf q;
    protected ayg var_ayg_g;
    protected ayh var_ayh_c;
    protected Dialog var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a = null;
    protected abi var_abi_a = null;
    protected Dialog var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_b = null;
    protected Dialog var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_c = null;
    protected Dialog var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_d = null;
    protected TextField var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a;
    protected ayc var_ayc_a;
    protected fe var_fe_a;
    protected wg var_wg_a;
    protected ayf r;
    protected ayf s;
    protected ayf t;
    protected ayh var_ayh_d;
    protected ayh var_ayh_e;
    protected ayf u;
    private ArenaName var_com_arenaofkings_packets_misc_ArenaName_a;
    private CharacterClass var_com_arenaofkings_packets_misc_CharacterClass_a;
    private CharacterClass var_com_arenaofkings_packets_misc_CharacterClass_b;
    private CharacterClass var_com_arenaofkings_packets_misc_CharacterClass_c;
    private CharacterClass var_com_arenaofkings_packets_misc_CharacterClass_d;
    private CharacterClass var_com_arenaofkings_packets_misc_CharacterClass_e;
    private CharacterClass var_com_arenaofkings_packets_misc_CharacterClass_f;
    private boolean var_boolean_a = false;
    private ayh var_ayh_f;
    private ayh var_ayh_g;
    private ayh var_ayh_h;
    private ayh var_ayh_i;
    private ayh var_ayh_j;
    private ayh var_ayh_k;
    gg var_gg_a;
    gl var_gl_a;
    private boolean var_boolean_b = true;
    private yu var_yu_a;
    private yp var_yp_a;
    private yn var_yn_a;
    private ya var_ya_a;
    private zi var_zi_a;
    private bm var_bm_a;
    private aay var_aay_a;
    private yg var_yg_a;
    private hd var_hd_a;
    private int var_int_a;
    private int var_int_b;
    private boolean var_boolean_c = false;
    private boolean var_boolean_d = false;
    private fm var_fm_a;
    private ayf v;
    private ayf w;
    private ayf x;
    private ayf y;
    private int var_int_c;
    private int var_int_d;
    private fd var_fd_a = null;
    private Table var_com_badlogic_gdx_scenes_scene2d_ui_Table_a;
    private boolean var_boolean_e = false;
    private ayh var_ayh_l;
    private ayh var_ayh_m;
    private ayh var_ayh_n;
    private ayh var_ayh_o;
    private da var_da_a;
    private Stage var_com_badlogic_gdx_scenes_scene2d_Stage_b;
    private Stage var_com_badlogic_gdx_scenes_scene2d_Stage_c;
    private StopWatch var_org_apache_commons_lang3_time_StopWatch_a = StopWatch.create();
    private String var_java_lang_String_a;
    private Map<CharacterClass, ayh> cfr_renamed_8;
    private int var_int_e = 0;
    private boolean var_boolean_f = false;
    private azv var_azv_a = new azv(0L, true);
    private agw var_agw_a;
    private agw var_agw_b;

    private void k() {
        Engine.b("loadChat 1");
        this.var_ayc_a = new wi(this, 1210, 3, ((axm)((Object)this.var_ayf_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c), "send_default", "send_hovered", "send_grayed", true);
        Engine.b("loadChat 2");
        this.var_wg_a = new wg((Engine)((Object)this.var_ayf_a), (axm)((Object)this.var_ayf_a), ((Engine)((Object)this.var_ayf_a)).q, ((Engine)((Object)this.var_ayf_a)).var_com_badlogic_gdx_scenes_scene2d_ui_Skin_a, 100, true, (Stage)((Object)this.var_ayf_a), 550, 12, 1312, 340);
        Engine.b("loadChat 3");
        this.var_wg_a.l();
        Engine.b("loadChat 4");
        Engine.b("loadChat 5");
        ((Array)((Object)((Engine)((Object)this.var_ayf_a)).var_azm_a)).clear();
        Engine.b("loadChat 6");
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a = new TextField("", ((Engine)((Object)this.var_ayf_a)).var_com_badlogic_gdx_scenes_scene2d_ui_Skin_a);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.setAlignment(1);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.setFocusTraversal(true);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.setMaxLength(15);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.setWidth(350.0f);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.setPosition(730.0f, 625.0f);
        Engine.b("loadChat 7");
        TextField.TextFieldStyle textFieldStyle = new TextField.TextFieldStyle(this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.getStyle());
        textFieldStyle.font = ((Engine)((Object)this.var_ayf_a)).o;
        Engine.b("loadChat 8");
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.setStyle(textFieldStyle);
        Engine.b("chat loaded");
    }

    private void l() {
        this.var_ayg_a = new wt(this, 718, 506, 1210, 640);
        this.var_ayg_b = new xe(this, 450, 985, 565, 1080);
        this.var_ayf_f = new xq(this, 41, 1020, ((axm)((Object)this.var_ayf_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c), "news_default", "news_hovered", true);
        this.var_ayf_g = new xr(this, 35, 1000, ((axm)((Object)this.var_ayf_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c), "news_default", "news_hovered", true);
        this.var_ayg_c = new xs(this, 565, 985, 790, 1080);
        this.var_ayf_h = new xt(this, 529, 1032, ((axm)((Object)this.var_ayf_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c), "character_default", "character_hovered", true);
        this.var_ayf_i = new xu(this, 660, 1007, ((axm)((Object)this.var_ayf_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c), "character_icon_default", "character_icon_hovered", true);
        this.var_ayg_d = new xv(this, 813, 985, 968, 1080);
        this.var_ayf_j = new wj(this, 392, 1028, ((axm)((Object)this.var_ayf_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c), "play_default", "play_hovered", true);
        this.var_ayf_k = new wk(this, 862, 1007, ((axm)((Object)this.var_ayf_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c), "play_icon_default", "play_icon_hovered", true);
        this.var_ayg_e = new wl(this, 968, 985, 1130, 1080);
        this.var_ayf_l = new wm(this, 719, 1032, ((axm)((Object)this.var_ayf_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c), "store_default", "store_hovered", true);
        this.var_ayf_m = new wn(this, 1027, 1016, ((axm)((Object)this.var_ayf_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c), "store_icon_default", "store_icon_hovered", true);
        this.var_ayg_f = new wo(this, 864, 1017, 1300, 1080);
        this.var_ayf_n = new wp(this, 849, 1032, ((axm)((Object)this.var_ayf_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c), "ladder_default", "ladder_hovered", true);
        this.var_ayf_o = new wq(this, 1196, 1013, ((axm)((Object)this.var_ayf_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c), "ladder_icon_default", "ladder_icon_hovered", true);
        this.var_ayg_g = new wr(this, 1011, 1017, 1442, 1080);
        this.p = new ws(this, 1004, 1032, ((axm)((Object)this.var_ayf_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c), "guide_default", "guide_hovered", true);
        this.q = new wu(this, 1366, 1010, ((axm)((Object)this.var_ayf_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c), "guide_icon_default", "guide_icon_hovered", true);
        this.var_ayf_b = new wv(this, 1771, 1000, ((axm)((Object)this.var_ayf_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c), "settings_icon_default", "settings_icon_hovered", true);
        this.var_ayf_d = new ww(this, 1590, 989, ((axm)((Object)this.var_ayf_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c), "vendor_icon_default", "vendor_icon_hovered", true);
        this.var_ayf_c = new wx(this, 1692, 1001, ((axm)((Object)this.var_ayf_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c), "stash_icon_default", "stash_icon_hovered", true);
        this.var_ayf_e = new wy(this, 128, 392, ((axm)((Object)this.var_ayf_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c), "schedule_button_default", "schedule_button_hovered", true);
        this.var_ayh_c = new ayh(475, 1000, ((axm)((Object)this.var_ayf_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c), "highlight_flare", true);
        this.var_ayh_c.com_badlogic_gdx_graphics_g2d_Sprite_a().setAlpha(0.35f);
    }

    public wh(axm axm2, Engine engine) {
        super(axm2, engine);
    }

    @Override
    public void void_a() {
        Engine.a("init 1");
        this.var_com_badlogic_gdx_scenes_scene2d_Stage_b = new Stage(((Engine)((Object)this.var_ayf_a)).var_com_badlogic_gdx_utils_viewport_Viewport_a, ((Engine)((Object)this.var_ayf_a)).var_azi_a);
        this.var_com_badlogic_gdx_scenes_scene2d_Stage_c = new Stage(((Engine)((Object)this.var_ayf_a)).var_com_badlogic_gdx_utils_viewport_Viewport_a, ((Engine)((Object)this.var_ayf_a)).var_azi_a);
        this.n();
        Engine.a("init 2");
        this.o();
        Engine.a("init 3");
        this.u();
        Engine.a("init 4 DONE");
    }

    public void a(float f2) {
        ((Engine)((Object)this.var_ayf_a)).var_azi_a.setColor(Color.WHITE);
        if (this.var_yn_a.boolean_b()) {
            this.var_ayg_a.b((Engine)((Object)this.var_ayf_a));
        }
        this.m();
        for (br object : ay.ay_a().gf_a().a().values()) {
            if (object.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().cr_a().da_a() != null) {
                object.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().cr_a().da_a().a(false);
            }
            if (object.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().bd_a().da_a() != null) {
                object.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().bd_a().da_a().a(false);
            }
            if (object.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().bd_a().da_b() != null) {
                object.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().bd_a().da_b().a(false);
            }
            if (object.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().bd_a().da_c() != null) {
                object.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().bd_a().da_c().a(false);
            }
            if (!object.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().cr_a().boolean_b()) continue;
            object.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().cr_a().a(false);
        }
        if (!ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bd_a().boolean_a()) {
            ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bd_a().c((axm)((Object)this.var_ayf_a));
        }
        if (!ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bd_a().boolean_b()) {
            ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bd_a().a((axm)((Object)this.var_ayf_a), false);
        }
        if (!ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bd_a().boolean_c()) {
            ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bd_a().b((axm)((Object)this.var_ayf_a), false);
        }
        if (!ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bd_a().e()) {
            ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bd_a().a((axm)((Object)this.var_ayf_a));
        }
        if (!ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bd_a().f()) {
            ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bd_a().a(((we)((Engine)((Object)this.var_ayf_a)).axc_a()).axm_a().com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.jm));
        }
        if (!ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bd_a().d()) {
            ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bd_a().c((axm)((Object)this.var_ayf_a), false);
        }
        this.var_boolean_e = false;
        if (ay.ay_a().gd_a().cg_a().boolean_a()) {
            for (fm fm2 : ay.ay_a().gd_a().as_a().a()) {
                if (!(fm2 instanceof fh) || !fm2.boolean_a()) continue;
                if (fm2 instanceof ff) break;
                this.var_boolean_e = true;
                break;
            }
            if (ay.ay_a().gd_a().bu_a().bz_a() != null) {
                for (fm fm3 : ay.ay_a().gd_a().bu_a().bz_a().a()) {
                    if (!(fm3 instanceof fh) || !fm3.boolean_a()) continue;
                    if (fm3 instanceof ff) break;
                    this.var_boolean_e = true;
                    break;
                }
            }
        }
        if (this.var_boolean_e) {
            Gdx.graphics.setCursor(((Engine)((Object)this.var_ayf_a)).var_com_badlogic_gdx_graphics_Cursor_d);
        } else {
            Gdx.graphics.setCursor(((Engine)((Object)this.var_ayf_a)).var_com_badlogic_gdx_graphics_Cursor_a);
        }
    }

    private void m() {
    }

    @Override
    public void a(float f2, azi azi2) {
        this.a(f2);
        azi2.begin();
        if (this.var_org_apache_commons_lang3_time_StopWatch_a != null && this.var_org_apache_commons_lang3_time_StopWatch_a.isStarted()) {
            ((Engine)((Object)this.var_ayf_a)).a(this.var_java_lang_String_a + "\n[SKY]In Queue: " + this.java_lang_String_a(), ((Engine)((Object)this.var_ayf_a)).var_axy_b.a(), Color.WHITE, ((Engine)((Object)this.var_ayf_a)).var_axy_b.a(), Color.BLACK, 390.0f, 1010.0f, 8);
        }
        if (ay.ay_a().gf_a().a().size() == 3) {
            ((Engine)((Object)this.var_ayf_a)).a("Team Composition", ((Engine)((Object)this.var_ayf_a)).var_axy_b.a(), Color.WHITE, ((Engine)((Object)this.var_ayf_a)).var_axy_b.a(), Color.BLACK, 1146.0f, 1015.0f, 1);
            for (br br2 : ay.ay_a().gf_a().a().values()) {
                if (br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_misc_CharacterClass_a() == CharacterClass.ELDER || br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_misc_CharacterClass_a() == CharacterClass.MYSTIC || br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_misc_CharacterClass_a() == CharacterClass.NIHILIST || br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_misc_CharacterClass_a() == CharacterClass.PALADIN || br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_misc_CharacterClass_a() == CharacterClass.SCHOLAR) {
                    this.var_boolean_f = true;
                }
                ((ayh)this.var_ayf_a.get((Object)br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_misc_CharacterClass_a())).b(f2, (Engine)((Object)this.var_ayf_a), 1058 + this.var_int_e++ * 50, 943);
            }
        }
        if (ay.ay_a().gf_a().a().size() == 3 && !this.var_boolean_f && this.var_azv_a.a(TimeUnit.SECONDS) % 2L == 0L) {
            ((Engine)((Object)this.var_ayf_a)).a("[YELLOW]Warning!\n[RED]Your team has no healer", ((Engine)((Object)this.var_ayf_a)).var_axy_b.a(), Color.RED, ((Engine)((Object)this.var_ayf_a)).var_axy_b.a(), Color.BLACK, 1160.0f, 1006.0f, 1);
        }
        this.var_boolean_f = false;
        this.var_int_e = 0;
        this.a(f2, azi2, this.var_ayh_f);
        this.a(f2, azi2, this.var_ayh_g);
        this.a(f2, azi2, this.var_ayh_h);
        this.a(f2, azi2, this.var_ayh_i);
        this.a(f2, azi2, this.var_ayh_j);
        this.a(f2, azi2, this.var_ayh_k);
        if (this.var_yn_a.boolean_b()) {
            this.var_ayh_c.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(386.0f, 968.0f);
        } else if (this.var_ya_a.boolean_b()) {
            this.var_ayh_c.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(478.0f, 968.0f);
        } else if (this.var_yp_a.boolean_b() || this.var_yg_a.boolean_b()) {
            this.var_ayh_c.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(324.0f, 968.0f);
        } else if (this.var_yu_a.boolean_b()) {
            this.var_ayh_c.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(637.0f, 968.0f);
        } else if (this.var_aay_a.boolean_b()) {
            this.var_ayh_c.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(1650.0f, 968.0f);
        } else if (this.var_zi_a.boolean_b()) {
            this.var_ayh_c.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(787.0f, 968.0f);
        }
        if (!this.var_yn_a.boolean_b()) {
            this.var_ayh_c.b(f2, (Engine)((Object)this.var_ayf_a));
        }
        this.var_yp_a.b(f2, (Engine)((Object)this.var_ayf_a));
        this.var_yg_a.b(f2, (Engine)((Object)this.var_ayf_a));
        this.var_ya_a.b(f2, (Engine)((Object)this.var_ayf_a));
        this.var_yn_a.b(f2, (Engine)((Object)this.var_ayf_a));
        this.var_zi_a.b(f2, (Engine)((Object)this.var_ayf_a));
        this.var_aay_a.b(f2, (Engine)((Object)this.var_ayf_a));
        this.var_wg_a.b(f2, (Engine)((Object)this.var_ayf_a));
        this.var_gg_a.b(f2, (Engine)((Object)this.var_ayf_a));
        this.var_gl_a.b(f2, (Engine)((Object)this.var_ayf_a));
        this.var_fe_a.b(f2, (Engine)((Object)this.var_ayf_a));
        ay.ay_a().gd_a().axz_a().a(f2, (Engine)((Object)this.var_ayf_a), (axm)((Object)this.var_ayf_a));
        ((Engine)((Object)this.var_ayf_a)).a(String.valueOf(ay.ay_a().gd_a().int_b()), ((Engine)((Object)this.var_ayf_a)).var_axy_c.a(), Color.WHITE, ((Engine)((Object)this.var_ayf_a)).var_axy_c.a(), Color.BLACK, 1142.0f, 1052.0f, 8, 1);
        ((Engine)((Object)this.var_ayf_a)).a(String.valueOf(ay.ay_a().gd_a().int_e()), ((Engine)((Object)this.var_ayf_a)).var_axy_c.a(), Color.WHITE, ((Engine)((Object)this.var_ayf_a)).var_axy_c.a(), Color.BLACK, 1266.0f, 1052.0f, 8, 1);
        ((Engine)((Object)this.var_ayf_a)).a(String.valueOf(ay.ay_a().gd_a().int_a()), ((Engine)((Object)this.var_ayf_a)).var_axy_c.a(), Color.WHITE, ((Engine)((Object)this.var_ayf_a)).var_axy_c.a(), Color.BLACK, 1395.0f, 1052.0f, 8, 1);
        this.var_bm_a.b(f2, (Engine)((Object)this.var_ayf_a));
        boolean bl2 = false;
        boolean bl3 = false;
        boolean bl4 = false;
        for (br br3 : ay.ay_a().gf_a().a().values()) {
            if (br3.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().int_h() == 1) {
                bl2 = true;
                continue;
            }
            if (br3.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().int_h() == 2) {
                bl3 = true;
                continue;
            }
            if (br3.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().int_h() != 3) continue;
            bl4 = true;
        }
        if (!bl3 && this.var_yg_a.boolean_b()) {
            ((Engine)((Object)this.var_ayf_a)).var_axy_f.a().getData().setScale(1.0f);
            ((Engine)((Object)this.var_ayf_a)).a("Invite a friend!", ((Engine)((Object)this.var_ayf_a)).var_axy_f.a(), axe.x, ((Engine)((Object)this.var_ayf_a)).var_axy_f.a(), Color.BLACK, 970.0f, 758.0f, 1, 1);
            this.r.a(f2, (Engine)((Object)this.var_ayf_a));
            this.r.b(f2, (Engine)((Object)this.var_ayf_a));
        }
        if (!bl4 && this.var_yg_a.boolean_b()) {
            ((Engine)((Object)this.var_ayf_a)).a("Invite a friend!", ((Engine)((Object)this.var_ayf_a)).var_axy_f.a(), axe.x, ((Engine)((Object)this.var_ayf_a)).var_axy_f.a(), Color.BLACK, 1325.0f, 758.0f, 1, 1);
            this.s.a(f2, (Engine)((Object)this.var_ayf_a));
            this.s.b(f2, (Engine)((Object)this.var_ayf_a));
        }
        this.var_yg_a.c(f2, (Engine)((Object)this.var_ayf_a));
        azi2.end();
        azi2.begin();
        if (this.var_yg_a.boolean_b()) {
            // empty if block
        }
        if (ay.ay_a().gd_a().boolean_a() && ay.ay_a().gd_a().azv_a().int_a() > 0) {
            int n2;
            if (this.var_da_a != null) {
                this.var_da_a.a(f2, (Engine)((Object)this.var_ayf_a));
                this.var_da_a.d(f2, 160.0f, 615.0f, ((Engine)((Object)this.var_ayf_a)).var_azi_a);
                this.var_da_a.d(f2, 210.0f, 615.0f, ((Engine)((Object)this.var_ayf_a)).var_azi_a);
                this.var_da_a.d(f2, 260.0f, 615.0f, ((Engine)((Object)this.var_ayf_a)).var_azi_a);
                this.var_da_a.d(f2, 310.0f, 615.0f, ((Engine)((Object)this.var_ayf_a)).var_azi_a);
                this.var_da_a.d(f2, 360.0f, 615.0f, ((Engine)((Object)this.var_ayf_a)).var_azi_a);
                this.var_da_a.d(f2, 410.0f, 615.0f, ((Engine)((Object)this.var_ayf_a)).var_azi_a);
                this.var_da_a.d(f2, 435.0f, 615.0f, ((Engine)((Object)this.var_ayf_a)).var_azi_a);
                this.var_da_a.d(f2, 160.0f, 570.0f, ((Engine)((Object)this.var_ayf_a)).var_azi_a);
                this.var_da_a.d(f2, 160.0f, 530.0f, ((Engine)((Object)this.var_ayf_a)).var_azi_a);
                this.var_da_a.d(f2, 435.0f, 570.0f, ((Engine)((Object)this.var_ayf_a)).var_azi_a);
                this.var_da_a.d(f2, 435.0f, 530.0f, ((Engine)((Object)this.var_ayf_a)).var_azi_a);
                this.var_da_a.d(f2, 160.0f, 490.0f, ((Engine)((Object)this.var_ayf_a)).var_azi_a);
                this.var_da_a.d(f2, 210.0f, 490.0f, ((Engine)((Object)this.var_ayf_a)).var_azi_a);
                this.var_da_a.d(f2, 260.0f, 490.0f, ((Engine)((Object)this.var_ayf_a)).var_azi_a);
                this.var_da_a.d(f2, 310.0f, 490.0f, ((Engine)((Object)this.var_ayf_a)).var_azi_a);
                this.var_da_a.d(f2, 360.0f, 490.0f, ((Engine)((Object)this.var_ayf_a)).var_azi_a);
                this.var_da_a.d(f2, 410.0f, 490.0f, ((Engine)((Object)this.var_ayf_a)).var_azi_a);
                this.var_da_a.d(f2, 435.0f, 490.0f, ((Engine)((Object)this.var_ayf_a)).var_azi_a);
            }
            ((Engine)((Object)this.var_ayf_a)).b("Tournament\nTournament\nMatch Score " + ay.ay_a().gd_a().g() + "-" + ay.ay_a().gd_a().int_f() + "\nNext Game in 100 sec", 50, 570, 400);
            ((Engine)((Object)this.var_ayf_a)).a("Tournament", ((Engine)((Object)this.var_ayf_a)).var_axy_f.a(), axe.v, ((Engine)((Object)this.var_ayf_a)).var_axy_f.a(), Color.BLACK, 200.0f, 573.0f, 1, 1);
            if (ay.ay_a().gd_a().java_lang_String_b().length() > 0) {
                ((Engine)((Object)this.var_ayf_a)).a(ay.ay_a().gd_a().java_lang_String_b(), ((Engine)((Object)this.var_ayf_a)).var_axy_c.a(), axe.m, ((Engine)((Object)this.var_ayf_a)).var_axy_c.a(), Color.BLACK, 200.0f, 542.0f, 1, 1);
            }
            ((Engine)((Object)this.var_ayf_a)).a("Match Score", ((Engine)((Object)this.var_ayf_a)).var_axy_f.a(), axe.m, ((Engine)((Object)this.var_ayf_a)).var_axy_f.a(), Color.BLACK, 200.0f, 524.0f, 1, 1);
            this.var_ayh_m.a(f2, azi2, 63, 538, 1.0f);
            this.var_ayh_m.a(f2, azi2, 295, 538, 1.0f);
            for (n2 = 0; n2 < 5; ++n2) {
                this.var_ayh_l.a(f2, azi2, 56 + n2 * 26, 462, 1.0f);
                this.var_ayh_l.a(f2, azi2, 218 + n2 * 26, 462, 1.0f);
            }
            for (n2 = 0; n2 < ay.ay_a().gd_a().g(); ++n2) {
                this.var_ayh_o.a(f2, azi2, 57 + n2 * 26, 465, 1.0f);
            }
            for (n2 = 0; n2 < ay.ay_a().gd_a().int_f(); ++n2) {
                this.var_ayh_n.a(f2, azi2, 219 + n2 * 26, 465, 1.0f);
            }
            ((Engine)((Object)this.var_ayf_a)).a("Next Game in " + ay.ay_a().gd_a().azv_a().int_a() + "sec", ((Engine)((Object)this.var_ayf_a)).var_axy_f.a(), axe.x, ((Engine)((Object)this.var_ayf_a)).var_axy_f.a(), Color.BLACK, 200.0f, 450.0f, 1, 1);
        }
        azi2.end();
        if (this.var_com_badlogic_gdx_scenes_scene2d_ui_Table_a != null && this.var_fd_a != null) {
            ((Engine)((Object)this.var_ayf_a)).var_axf_a.begin(ShapeRenderer.ShapeType.Filled);
            switch (this.var_fd_a) {
                case e: {
                    ((Engine)((Object)this.var_ayf_a)).var_axf_a.a(this.var_int_c + 36, (float)(this.var_int_d - 22), 125.0f, 40.0f, 20.0f, axe.y);
                    break;
                }
                case d: {
                    break;
                }
                case b: {
                    break;
                }
                case var_fd_a: {
                    break;
                }
                case c: {
                    ((Engine)((Object)this.var_ayf_a)).var_axf_a.a(this.var_int_c + 36, (float)(this.var_int_d - 48), 125.0f, 100.0f, 20.0f, axe.J);
                    break;
                }
            }
            ((Engine)((Object)this.var_ayf_a)).var_axf_a.end();
        }
        if (this.var_yu_a.boolean_b()) {
            azi2.begin();
            this.var_yu_a.b(f2, (Engine)((Object)this.var_ayf_a));
            azi2.end();
        }
        ay.ay_a().gd_a().cg_a().h();
    }

    private void a(float f2, azi azi2, ayh ayh2) {
        if (ayh2 != null) {
            ayh2.b(f2, (Engine)((Object)this.var_ayf_a));
        }
    }

    public void a(float f2, Engine engine) {
        ay.ay_a().gd_a().cg_a().b(f2, engine);
        ay.ay_a().gd_a().bu_a().b(f2, engine);
        ay.ay_a().gd_a().as_a().b(f2, engine);
        this.var_ya_a.c(f2, engine);
        ay.ay_a().gd_a().ca_a().b(f2, engine);
        engine.var_azi_a.end();
        if (!ay.ay_a().gd_a().bu_a().boolean_a() && this.var_zi_a.zu_a().boolean_a() || this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a != null) {
            this.var_com_badlogic_gdx_scenes_scene2d_Stage_b.act(f2);
            this.var_com_badlogic_gdx_scenes_scene2d_Stage_b.draw();
        }
        if (ay.ay_a().gd_a().bu_a().boolean_a()) {
            this.var_com_badlogic_gdx_scenes_scene2d_Stage_c.act(f2);
            this.var_com_badlogic_gdx_scenes_scene2d_Stage_c.draw();
        }
        engine.var_azi_a.begin();
        ay.ay_a().gd_a().cg_a().c(f2, engine);
        ay.ay_a().gd_a().as_a().a(f2);
        ay.ay_a().gd_a().ca_a().gp_a().b(f2, engine);
        ay.ay_a().gd_a().ca_a().c(f2, engine);
        ay.ay_a().gd_a().bu_a().c(f2, engine);
        ay.ay_a().gd_a().as_a().c(f2, engine);
        ay.ay_a().gd_a().as_a().d(f2, engine);
        if (this.var_ya_a.azp_a().boolean_a()) {
            for (int i2 = 1; i2 < ay.ay_a().gu_a().ui_arr_a().length; ++i2) {
                ay.ay_a().gu_a().ui_a(i2).b(f2, engine, i2);
            }
        }
        ay.ay_a().gd_a().bu_a().d(f2, engine);
        if (ay.ay_a().gd_a().as_a().boolean_a()) {
            for (am am2 : ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().a().values()) {
                if (am2 == null || am2.fh_a() == null || am2.fh_a() instanceof ff || !am2.fh_a().boolean_a()) continue;
                am2.fh_a().c(f2, engine);
            }
        }
        this.v.a(f2, engine);
        this.v.b(f2, engine);
        this.w.a(f2, engine);
        this.w.b(f2, engine);
        this.x.a(f2, engine);
        this.x.b(f2, engine);
        if (this.var_hd_a != null) {
            if (this.var_hd_a.boolean_a()) {
                if (this.var_boolean_c) {
                    this.var_hd_a.a(this.var_int_a, this.var_int_b);
                    this.var_boolean_c = false;
                }
                this.var_hd_a.c(f2, engine);
            } else {
                this.var_hd_a.a((axm)((Object)this.var_ayf_a));
            }
        }
        if (this.var_fm_a != null) {
            if (!this.var_fm_a.boolean_c()) {
                this.var_fm_a.a((axm)((Object)this.var_ayf_a), true);
            }
            if (this.var_fm_a.boolean_c()) {
                this.var_fm_a.a(engine, 450, 500, 0, false, true);
            }
        }
        ay.ay_a().gd_a().as_a().a((ItemSlot)null);
        for (am am2 : ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().a().values()) {
            am2.a(false);
        }
    }

    private void n() {
    }

    private void o() {
        this.var_agw_a = new agw(((axm)((Object)this.var_ayf_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c), "progression_bar_empty", "progression_bar_green");
        this.var_agw_a.a().com_badlogic_gdx_graphics_g2d_Sprite_a().setColor(Color.GRAY);
        this.var_agw_b = new agw(((axm)((Object)this.var_ayf_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c), "progression_bar_empty", "progression_bar_blue");
        this.var_agw_b.a().com_badlogic_gdx_graphics_g2d_Sprite_a().setColor(Color.GRAY);
        this.v = new wz(this, 1352, 1026, ((axm)((Object)this.var_ayf_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c), "silver_coin_menu_default", "silver_coin_menu_hovered", true);
        this.x = new xa(this, 1096, 1026, ((axm)((Object)this.var_ayf_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c), "villain_coin_menu_default", "villain_coin_menu_hovered", true);
        this.w = new xb(this, 1224, 1024, ((axm)((Object)this.var_ayf_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c), "ability_essence_default", "ability_essence_hovered", true);
        this.y = new xc(this, 1483, 1024, ((axm)((Object)this.var_ayf_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c), "arena_points_medium_default", "arena_points_medium_hovered", true);
        this.var_ayf_a = new HashMap();
        this.var_ayf_a.put(CharacterClass.ASSASSIN, new ayh(0, 0, ((axm)((Object)this.var_ayf_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.jd), CharacterClass.simpleName(CharacterClass.ASSASSIN), 0.5f));
        this.var_ayf_a.put(CharacterClass.CHAMPION, new ayh(0, 0, ((axm)((Object)this.var_ayf_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.jd), CharacterClass.simpleName(CharacterClass.CHAMPION), 0.5f));
        this.var_ayf_a.put(CharacterClass.ELDER, new ayh(0, 0, ((axm)((Object)this.var_ayf_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.jd), CharacterClass.simpleName(CharacterClass.ELDER), 0.5f));
        this.var_ayf_a.put(CharacterClass.LICH, new ayh(0, 0, ((axm)((Object)this.var_ayf_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.jd), CharacterClass.simpleName(CharacterClass.LICH), 0.5f));
        this.var_ayf_a.put(CharacterClass.MYSTIC, new ayh(0, 0, ((axm)((Object)this.var_ayf_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.jd), CharacterClass.simpleName(CharacterClass.MYSTIC), 0.5f));
        this.var_ayf_a.put(CharacterClass.NIHILIST, new ayh(0, 0, ((axm)((Object)this.var_ayf_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.jd), CharacterClass.simpleName(CharacterClass.NIHILIST), 0.5f));
        this.var_ayf_a.put(CharacterClass.PALADIN, new ayh(0, 0, ((axm)((Object)this.var_ayf_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.jd), CharacterClass.simpleName(CharacterClass.PALADIN), 0.5f));
        this.var_ayf_a.put(CharacterClass.RANGER, new ayh(0, 0, ((axm)((Object)this.var_ayf_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.jd), CharacterClass.simpleName(CharacterClass.RANGER), 0.5f));
        this.var_ayf_a.put(CharacterClass.SCHOLAR, new ayh(0, 0, ((axm)((Object)this.var_ayf_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.jd), CharacterClass.simpleName(CharacterClass.SCHOLAR), 0.5f));
        this.var_ayf_a.put(CharacterClass.WIZARD, new ayh(0, 0, ((axm)((Object)this.var_ayf_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.jd), CharacterClass.simpleName(CharacterClass.WIZARD), 0.5f));
        Engine.a("loadImages 1");
        this.l();
        Engine.a("loadImages 2");
        this.t();
        Engine.b("loadImages 3");
        this.k();
        Engine.b("loadImages 4");
        this.e();
        Engine.a("loadImages 5");
        this.d();
        Engine.a("loadImages 6");
        this.q();
        this.r();
        this.s();
        Engine.a("loadImages 7");
        this.p();
        Engine.a("loadImages 8");
        this.void_c();
        Engine.a("loadImages 9");
        ay.ay_a().gd_a().as_a().a((axm)((Object)this.var_ayf_a));
        Engine.a("loadImages 9.1");
        ay.ay_a().gd_a().cg_a().a((axm)((Object)this.var_ayf_a));
        Engine.a("loadImages 9.2");
        ay.ay_a().gd_a().bu_a().a((axm)((Object)this.var_ayf_a));
        Engine.a("loadImages 9.3");
        ay.ay_a().gd_a().ca_a().a((axm)((Object)this.var_ayf_a), (Stage)((Object)this.var_ayf_a));
        Engine.a("loadImages 9.4");
        this.var_ayh_a = new ayh(0, 0, ((axm)((Object)this.var_ayf_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c), "main_panel", true);
        Engine.a("loadImages 10");
        this.var_ayf_a = new xd(this, 1852, 1000, ((axm)((Object)this.var_ayf_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c), "door_icon_default", "door_icon_hovered", true);
        Engine.a("loadImages 10.1");
        this.var_ayh_l = new ayh(0, 0, ((axm)((Object)this.var_ayf_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.i), "detail", true);
        this.var_ayh_m = new ayh(0, 0, ((axm)((Object)this.var_ayf_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.i), "gold_cup", true);
        this.var_ayh_n = new ayh(0, 0, ((axm)((Object)this.var_ayf_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.i), "red_star", true);
        this.var_ayh_o = new ayh(0, 0, ((axm)((Object)this.var_ayf_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.i), "blue_star", true);
        Engine.a("loadImages 10.2");
        this.var_da_a = new da(ajw.jg, "GCD_Flash", 15, 45, 0.02f, 0.0f, Animation.PlayMode.LOOP, -65, -65);
        this.var_da_a.a(((Engine)((Object)this.var_ayf_a)).axc_a().axm_a(), false, true);
        this.var_da_a.a(1550.0f, 415.0f);
        this.var_ayh_b = new ayh(0, 328, ((axm)((Object)this.var_ayf_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c), "skull_detail", true);
        Engine.a("loadImages 11");
        this.var_ayh_e = new ayh(0, 0, ((axm)((Object)this.var_ayf_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c), "quest_icon_3d", true);
        this.var_ayh_e.com_badlogic_gdx_graphics_g2d_Sprite_a().scale(-0.8f);
    }

    public void void_c() {
        this.var_fe_a = new fe(((axm)((Object)this.var_ayf_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c), "channel_backdrop", 1312, 248);
        ay.ay_a().gd_a().ev_a().a(((axm)((Object)this.var_ayf_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c));
        this.var_ayh_d = new xf(this, 384, 299, ((axm)((Object)this.var_ayf_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c), "plus_default", true);
        for (en axr2 : ay.ay_a().gd_a().ev_a().a().values()) {
            for (ew ew2 : axr2.a().values()) {
                Engine.b("LOAD CHANNEL PLAYER IN");
                ew2.a((Engine)((Object)this.var_ayf_a), true);
                Engine.b("LOAD CHANNEL PLAYER OUT");
            }
        }
        for (ayq ayq2 : ay.ay_a().gd_a().axz_a().a()) {
            ayq2.a((Engine)((Object)this.var_ayf_a), true);
        }
    }

    private void p() {
        this.u = new xh(this, 1647, 583, ((axm)((Object)this.var_ayf_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c), "spectate2_button_default", "spectate2_button_hovered", true);
        ay.ay_a().gd_a().axz_a().a(((axm)((Object)this.var_ayf_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c), "social_backdrop", "social_scrollbar", "scrollknob", 1482, 300);
        this.t = new xi(this, 1800, 290, ((axm)((Object)this.var_ayf_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c), "friend_icon_unhovered", "friend_icon_hovered", true);
        this.r = new xk(this, 940, 765, ((axm)((Object)this.var_ayf_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c), "friend_icon_unhovered", "friend_icon_hovered", true);
        this.s = new xm(this, 1295, 765, ((axm)((Object)this.var_ayf_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c), "friend_icon_unhovered", "friend_icon_hovered", true);
    }

    public void a(Object object) {
        if (object.equals("confirm")) {
            ((Engine)((Object)this.var_ayf_a)).var_baa_a.a(ajw.kA, 0.4f);
            if (t.a(we.class, (Engine)((Object)this.var_ayf_a))) {
                wh wh2 = (wh)((Engine)((Object)this.var_ayf_a)).axc_a().aya_a();
                PUB_PARTY_INVITE pUB_PARTY_INVITE = new PUB_PARTY_INVITE(this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.getText(), wh2.yp_a().a());
                ((Engine)((Object)this.var_ayf_a)).var_z_a.void_a(pUB_PARTY_INVITE);
            } else {
                PUB_PARTY_INVITE pUB_PARTY_INVITE = new PUB_PARTY_INVITE(this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.getText(), 1);
                ((Engine)((Object)this.var_ayf_a)).var_z_a.void_a(pUB_PARTY_INVITE);
            }
            this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.setText("");
        } else if (object.equals("deny")) {
            ((Engine)((Object)this.var_ayf_a)).var_baa_a.a(ajw.kE, 0.4f);
        }
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.setText("");
        ((Engine)((Object)this.var_ayf_a)).i();
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.remove();
        this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_c.hide();
    }

    public void b(Object object) {
        if (object.equals("confirm")) {
            ((Engine)((Object)this.var_ayf_a)).var_baa_a.a(ajw.kA, 0.4f);
            ((Engine)((Object)this.var_ayf_a)).var_z_a.void_a(new PUB_MISC_CHAT_MESSAGE("/friend add " + this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.getText()));
            this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.setText("");
        } else if (object.equals("deny")) {
            ((Engine)((Object)this.var_ayf_a)).var_baa_a.a(ajw.kE, 0.4f);
        }
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.setText("");
        ((Engine)((Object)this.var_ayf_a)).i();
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.remove();
        this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_b.hide();
    }

    public void c(Object object) {
        if (object.equals("confirm")) {
            ((Engine)((Object)this.var_ayf_a)).var_baa_a.a(ajw.kA, 0.4f);
            ((Engine)((Object)this.var_ayf_a)).var_z_a.void_a(new PUB_MISC_CHAT_MESSAGE("/join " + this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.getText()));
            this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.setText("");
        } else if (object.equals("deny")) {
            ((Engine)((Object)this.var_ayf_a)).var_baa_a.a(ajw.kE, 0.4f);
        }
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.setText("");
        ((Engine)((Object)this.var_ayf_a)).i();
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.remove();
        this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_d.hide();
    }

    private void q() {
        this.var_gg_a = new gg((Engine)((Object)this.var_ayf_a), ((axm)((Object)this.var_ayf_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c));
    }

    private void r() {
        this.var_gl_a = new gl((Engine)((Object)this.var_ayf_a), ((axm)((Object)this.var_ayf_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c));
    }

    private void s() {
        ay.ay_a().gd_a().ca_a().a(new gp((Engine)((Object)this.var_ayf_a), ((axm)((Object)this.var_ayf_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c)));
    }

    public void d() {
        this.var_bm_a = new bm(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bd_a());
    }

    public void e() {
        ay.ay_a().gu_a().a((axm)((Object)this.var_ayf_a));
    }

    public void a(abi abi2) {
        if (abi2 == null) {
            return;
        }
        if (((Engine)((Object)this.var_ayf_a)).boolean_b()) {
            return;
        }
        if (ay.ay_a().gd_a().a(abi2)) {
            return;
        }
        this.var_abi_a = abi2;
        Label.LabelStyle labelStyle = new Label.LabelStyle(((Engine)((Object)this.var_ayf_a)).j, Color.WHITE);
        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = ((Engine)((Object)this.var_ayf_a)).l;
        textButtonStyle.fontColor = axe.K;
        this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a = new xo(this, "", ((Engine)((Object)this.var_ayf_a)).var_com_badlogic_gdx_scenes_scene2d_ui_Skin_a, abi2, labelStyle);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a.setBounds(730.0f, 575.0f, 450.0f, 135.0f);
        if (!this.var_com_badlogic_gdx_scenes_scene2d_Stage_b.getActors().contains(this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a, true)) {
            ((Engine)((Object)this.var_ayf_a)).a(this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a);
            this.var_com_badlogic_gdx_scenes_scene2d_Stage_b.addActor(this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a);
            Engine.b("added dialog unlock");
        } else {
            Engine.b("didn't add dialog");
        }
    }

    private void t() {
        Engine.a("matchmaking panel");
        this.var_yg_a = new yg((Engine)((Object)this.var_ayf_a), ((axm)((Object)this.var_ayf_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c));
        Engine.a("store panel build");
        this.var_yu_a = new yu((Engine)((Object)this.var_ayf_a), (axm)((Object)this.var_ayf_a), (Stage)((Object)this.var_ayf_a));
        Engine.a("play panel");
        this.var_yp_a = new yp(this.var_yg_a, (Stage)((Object)this.var_ayf_a), (Engine)((Object)this.var_ayf_a), ((axm)((Object)this.var_ayf_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c));
        Engine.a("matchmaking quitbutton");
        this.var_yg_a.a(this.var_yp_a, (Stage)((Object)this.var_ayf_a), (Engine)((Object)this.var_ayf_a), ((axm)((Object)this.var_ayf_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c));
        Engine.a("character panel");
        this.var_ya_a = new ya((Engine)((Object)this.var_ayf_a), (axm)((Object)this.var_ayf_a));
        this.var_zi_a = new zi((Engine)((Object)this.var_ayf_a), (axm)((Object)this.var_ayf_a), this.var_com_badlogic_gdx_scenes_scene2d_Stage_b);
        Engine.a("news panel");
        this.var_yn_a = new yn((Engine)((Object)this.var_ayf_a), ((axm)((Object)this.var_ayf_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c), ((axm)((Object)this.var_ayf_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.b));
        Engine.a("options panel");
        this.var_aay_a = new aay((Engine)((Object)this.var_ayf_a), (axm)((Object)this.var_ayf_a), (Stage)((Object)this.var_ayf_a));
        Engine.a("done with panels");
    }

    private void u() {
        ((Stage)((Object)this.var_ayf_a)).addActor(this.var_wg_a.axh_a());
        this.var_com_badlogic_gdx_scenes_scene2d_Stage_c.addActor(ay.ay_a().gd_a().bu_a().a());
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.setVisible(true);
    }

    private void a(yf yf2) {
        Engine.a("show panel");
        ((Engine)((Object)this.var_ayf_a)).var_baa_a.a(ajw.kI, 1.0f);
        yf2.a((Stage)((Object)this.var_ayf_a));
        if (yf2 != this.var_yn_a) {
            this.var_yn_a.b((Stage)((Object)this.var_ayf_a));
        }
        if (yf2 != this.var_ya_a) {
            this.var_ya_a.b((Stage)((Object)this.var_ayf_a));
        }
        if (yf2 != this.var_yg_a) {
            this.var_yg_a.b((Stage)((Object)this.var_ayf_a));
        }
        if (yf2 != this.var_yp_a) {
            this.var_yp_a.b((Stage)((Object)this.var_ayf_a));
        }
        if (yf2 != this.var_yu_a) {
            this.var_yu_a.b((Stage)((Object)this.var_ayf_a));
        }
        if (yf2 != this.var_zi_a) {
            this.var_zi_a.b((Stage)((Object)this.var_ayf_a));
        }
        if (yf2 != this.var_aay_a) {
            this.var_aay_a.b((Stage)((Object)this.var_ayf_a));
        }
        this.var_ya_a.void_a();
    }

    public yg yg_a() {
        return this.var_yg_a;
    }

    public void f() {
        this.a(this.var_yg_a);
    }

    public void g() {
        this.a(this.var_ya_a);
    }

    public void h() {
        this.a(this.var_zi_a);
    }

    public void i() {
        this.a(this.var_yu_a);
    }

    @Override
    public void void_b() {
        super.void_b();
    }

    public wg wg_a() {
        return this.var_wg_a;
    }

    public ya ya_a() {
        return this.var_ya_a;
    }

    public yg yg_b() {
        return this.var_yg_a;
    }

    public zi zi_a() {
        return this.var_zi_a;
    }

    public yu yu_a() {
        return this.var_yu_a;
    }

    public Stage com_badlogic_gdx_scenes_scene2d_Stage_a() {
        return this.var_com_badlogic_gdx_scenes_scene2d_Stage_b;
    }

    public Stage com_badlogic_gdx_scenes_scene2d_Stage_b() {
        return this.var_com_badlogic_gdx_scenes_scene2d_Stage_c;
    }

    public aay aay_a() {
        return this.var_aay_a;
    }

    public hd hd_a() {
        return this.var_hd_a;
    }

    public void a(hd hd2) {
        Engine.a("set dragging icon");
        if (hd2 != null) {
            Engine.a("dragging a: " + (Object)((Object)hd2.com_arenaofkings_packets_gameserver_data_updates_SpellName_a()));
        }
        this.var_hd_a = hd2;
    }

    public void a(boolean bl2) {
        this.var_boolean_c = bl2;
    }

    public void b(boolean bl2) {
        this.var_boolean_d = bl2;
    }

    public boolean boolean_a() {
        return this.var_boolean_d;
    }

    public void a(int n2, int n3) {
        this.var_int_a = n2;
        this.var_int_b = n3;
    }

    public gg gg_a() {
        return this.var_gg_a;
    }

    public gl gl_a() {
        return this.var_gl_a;
    }

    public void a(Engine engine, ArenaTeamData arenaTeamData) {
        this.f();
        this.var_yp_a.a(engine, arenaTeamData);
    }

    public void a(fm fm2) {
        this.var_fm_a = fm2;
        if (fm2 != null) {
            this.var_fm_a.a((Engine)((Object)this.var_ayf_a), (axm)((Object)this.var_ayf_a));
        }
    }

    public fm fm_a() {
        return this.var_fm_a;
    }

    public void a(Table table, int n2, int n3, fd fd2) {
        if (this.var_com_badlogic_gdx_scenes_scene2d_ui_Table_a != null) {
            this.var_com_badlogic_gdx_scenes_scene2d_ui_Table_a.remove();
        }
        this.var_int_c = n2;
        this.var_int_d = n3;
        this.var_com_badlogic_gdx_scenes_scene2d_ui_Table_a = table;
        this.var_fd_a = fd2;
    }

    public Table com_badlogic_gdx_scenes_scene2d_ui_Table_a() {
        return this.var_com_badlogic_gdx_scenes_scene2d_ui_Table_a;
    }

    public TextField com_badlogic_gdx_scenes_scene2d_ui_TextField_a() {
        return this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a;
    }

    public Dialog com_badlogic_gdx_scenes_scene2d_ui_Dialog_a() {
        return this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_b;
    }

    public Dialog com_badlogic_gdx_scenes_scene2d_ui_Dialog_b() {
        return this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_d;
    }

    public Dialog com_badlogic_gdx_scenes_scene2d_ui_Dialog_c() {
        return this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_c;
    }

    public void a(ArenaName arenaName, CharacterClass characterClass, CharacterClass characterClass2, CharacterClass characterClass3, CharacterClass characterClass4, CharacterClass characterClass5, CharacterClass characterClass6) {
        if (this.var_com_arenaofkings_packets_misc_ArenaName_a != arenaName || this.var_com_arenaofkings_packets_misc_CharacterClass_a != characterClass || this.var_com_arenaofkings_packets_misc_CharacterClass_b != characterClass2 || this.var_com_arenaofkings_packets_misc_CharacterClass_c != characterClass3 || this.var_com_arenaofkings_packets_misc_CharacterClass_d != characterClass4 || this.var_com_arenaofkings_packets_misc_CharacterClass_e != characterClass5 || this.var_com_arenaofkings_packets_misc_CharacterClass_f != characterClass6) {
            this.var_boolean_a = true;
        }
        if (arenaName != null) {
            this.var_com_arenaofkings_packets_misc_ArenaName_a = arenaName;
        }
        if (characterClass != null) {
            this.var_com_arenaofkings_packets_misc_CharacterClass_a = characterClass;
        }
        if (characterClass2 != null) {
            this.var_com_arenaofkings_packets_misc_CharacterClass_b = characterClass2;
        }
        if (characterClass3 != null) {
            this.var_com_arenaofkings_packets_misc_CharacterClass_c = characterClass3;
        }
        if (characterClass4 != null) {
            this.var_com_arenaofkings_packets_misc_CharacterClass_d = characterClass4;
        }
        if (characterClass5 != null) {
            this.var_com_arenaofkings_packets_misc_CharacterClass_e = characterClass5;
        }
        if (characterClass6 != null) {
            this.var_com_arenaofkings_packets_misc_CharacterClass_f = characterClass6;
        }
    }

    public void a(String string) {
        this.var_java_lang_String_a = string;
        if (!this.var_org_apache_commons_lang3_time_StopWatch_a.isStarted()) {
            this.var_org_apache_commons_lang3_time_StopWatch_a.start();
        }
    }

    public void j() {
        this.var_org_apache_commons_lang3_time_StopWatch_a.reset();
    }

    public String java_lang_String_a() {
        int n2 = (int)this.var_org_apache_commons_lang3_time_StopWatch_a.getTime(TimeUnit.SECONDS);
        int n3 = (int)Math.floor(n2 / 86400);
        int n4 = (int)Math.floor((n2 %= 86400) / 3600);
        int n5 = (int)Math.floor((n2 %= 3600) / 60);
        n2 %= 60;
        if (n3 > 0) {
            return n3 + " days " + n4 + " hours " + n5 + " min " + n2 + " sec";
        }
        if (n4 > 0) {
            return n4 + " hours " + n5 + " min " + n2 + " sec";
        }
        if (n5 > 0) {
            return n5 + " min " + n2 + " sec";
        }
        if (n2 >= 0) {
            return n2 + " sec";
        }
        return "";
    }

    public yp yp_a() {
        return this.var_yp_a;
    }

    static /* synthetic */ yn yn_a(wh wh2) {
        return wh2.var_yn_a;
    }

    static /* synthetic */ void a(wh wh2, yf yf2) {
        wh2.a(yf2);
    }

    static /* synthetic */ ya ya_a(wh wh2) {
        return wh2.var_ya_a;
    }

    static /* synthetic */ yg yg_a(wh wh2) {
        return wh2.var_yg_a;
    }

    static /* synthetic */ yp yp_a(wh wh2) {
        return wh2.var_yp_a;
    }

    static /* synthetic */ yu yu_a(wh wh2) {
        return wh2.var_yu_a;
    }

    static /* synthetic */ zi zi_a(wh wh2) {
        return wh2.var_zi_a;
    }

    static /* synthetic */ aay aay_a(wh wh2) {
        return wh2.var_aay_a;
    }
}

