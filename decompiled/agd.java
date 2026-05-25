/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.PUB_PLAY_READY;
import com.arenaofkings.packets.gameserver.data.Direction;
import com.arenaofkings.packets.gameserver.data.PlayerAction;
import com.arenaofkings.packets.gameserver.data.resources.Energy;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.arenaofkings.packets.misc.ArenaName;
import com.arenaofkings.packets.misc.CharacterClass;
import com.arenaofkings.packets.misc.GameType;
import com.arenaofkings.packets.misc.InputIdentifier;
import com.arenaofkings.packets.misc.TutorialStage;
import com.arenaofkings.packets.misc.items.ItemSlot;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.time.StopWatch;

public class agd
extends axc {
    private agp var_agp_a;
    public agr var_agr_a;
    public ajt var_ajt_a;
    private hi var_hi_a;
    private TiledMap var_com_badlogic_gdx_maps_tiled_TiledMap_a;
    private InputMultiplexer var_com_badlogic_gdx_InputMultiplexer_a = new InputMultiplexer();
    private aik var_aik_a;
    private azv var_azv_a;
    private boolean var_boolean_a = true;
    private boolean var_boolean_b = false;
    private boolean var_boolean_f = false;
    private boolean var_boolean_g = false;
    private azv var_azv_b;
    private azv var_azv_c = new azv(3000L, false);
    private ayh var_ayh_d;
    private ayh var_ayh_e;
    private ayh var_ayh_f;
    private ayh var_ayh_g;
    private boolean var_boolean_h = false;
    private ayh var_ayh_h;
    private azv var_azv_d = new azv(0L, false);
    private boolean var_boolean_i = false;
    private boolean j = false;
    private Direction var_com_arenaofkings_packets_gameserver_data_Direction_a = Direction.SOUTH;
    private Direction var_com_arenaofkings_packets_gameserver_data_Direction_b = Direction.SOUTH;
    private Direction var_com_arenaofkings_packets_gameserver_data_Direction_c = Direction.SOUTH;
    private boolean k = false;
    private da var_da_g;
    private List<da> var_java_util_List_da__a;
    private int var_int_b;
    private int var_int_c;
    private boolean l = false;
    private boolean m = true;
    private int var_int_d = 0;
    private boolean n = false;
    private GameType var_com_arenaofkings_packets_misc_GameType_a;
    private azv var_azv_e = new azv(2500L, false);
    private azv var_azv_f = new azv(10000L, true);
    private TutorialStage var_com_arenaofkings_packets_misc_TutorialStage_a = TutorialStage.tutorialGreeting1_WELCOME;
    private Dialog var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a;
    private boolean o = false;
    private Dialog var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_b;
    private boolean p = false;
    private Dialog var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_c;
    private boolean q = false;
    private Dialog var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_d;
    private boolean r = false;
    private Dialog var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_e;
    private boolean s = false;
    private Dialog var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_f;
    private boolean t = false;
    private azv var_azv_g = new azv(1000L);
    private boolean u = false;
    private boolean v = true;
    private boolean w = false;
    Pixmap var_com_badlogic_gdx_graphics_Pixmap_a;
    Texture var_com_badlogic_gdx_graphics_Texture_a;
    Matrix4 var_com_badlogic_gdx_math_Matrix4_a;
    private float var_float_b;
    private float var_float_c;
    private float var_float_d;
    private float var_float_e;
    private long var_long_a = 0L;
    private float var_float_f;
    private float var_float_g;
    private aga var_aga_a;
    private ayh var_ayh_i;
    private boolean x = false;
    private azv var_azv_h = new azv(1000L, true);
    private BitmapFont var_com_badlogic_gdx_graphics_g2d_BitmapFont_a = new BitmapFont();
    private int var_int_e = Gdx.graphics.getFramesPerSecond();
    private float var_float_h = Gdx.graphics.getDeltaTime() * 1000.0f;
    private r var_r_a;
    private Viewport var_com_badlogic_gdx_utils_viewport_Viewport_a;
    private azv var_azv_i = new azv(200L, true);
    private List<br> var_java_util_List_br__b;
    private int var_int_f = 0;
    ayh var_ayh_a;
    ayh var_ayh_b;
    private boolean y;
    private zo var_zo_a;
    private zo var_zo_b;
    private long var_long_b = 0L;
    private boolean z;
    private boolean A;
    protected float var_float_a = 0.0f;
    protected int var_int_a = 20;
    protected da var_da_a;
    protected da var_da_b;
    protected da var_da_c;
    protected da var_da_d;
    protected da var_da_e;
    protected da var_da_f;
    protected ayh var_ayh_c;
    private boolean B;
    private boolean C = false;
    private StopWatch var_org_apache_commons_lang3_time_StopWatch_a;
    private Instant var_java_time_Instant_a;

    private void a(float f2) {
        ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bb_a().void_c();
    }

    public agd(Engine engine, ayl ayl2) {
        super(engine, ayl2);
        this.var_boolean_b = new ArrayList();
        this.var_agp_a = (agp)ayl2;
        this.var_aga_a = new aga();
        this.var_com_arenaofkings_packets_misc_GameType_a = ay.ay_a().gd_a().com_arenaofkings_packets_misc_GameType_a();
        switch (this.var_com_arenaofkings_packets_misc_GameType_a) {
            case ARENA: {
                this.n = false;
                break;
            }
            case TRAININGGROUND: {
                break;
            }
            case TUTORIAL_DPS: {
                this.n = true;
                break;
            }
            case DARK_BOSS_BATTLE: {
                this.n = true;
                break;
            }
            case TUTORIAL_HEALER: {
                this.n = true;
                break;
            }
            case BOT_GAME_1: {
                this.n = false;
                break;
            }
            case BOT_GAME_2: {
                this.n = false;
                break;
            }
            case BOT_GAME_3: {
                this.n = false;
                break;
            }
            case BOT_GAME_4: {
                this.n = false;
                break;
            }
            case BOT_GAME_5: {
                this.n = false;
                break;
            }
        }
    }

    private void void_c() {
        br br2;
        int n2;
        Engine.a("loadPlayers() in");
        for (n2 = 0; n2 < ay.ay_a().gf_a().a().size(); ++n2) {
            br2 = ay.ay_a().gf_a().a().a(n2);
            br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().gz_a().fu_a().a((axm)((Object)this.var_agp_a));
            br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().gz_a().ui_b().hd_a().a((axm)((Object)this.var_agp_a));
            br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().cr_a().cy_a().a(true);
            br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().cr_a().void_c();
            br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().cr_a().void_b();
            br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().cr_a().void_d();
            br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().cr_a().a(cv.var_cv_a);
            br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().a(true);
            if (ay.ay_a() == br2) {
                ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().cr_a().i();
                ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().gu_a().e();
            }
            Engine.a("nameplate time");
            br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().a(new aho((Engine)((Object)this.var_agp_a), ((axm)((Object)this.var_agp_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.e), ((axm)((Object)this.var_agp_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.jd), br2, br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().gz_a(), br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_EffectManager_a(), br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a(), true, br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_resources_Resource_a().getResourceType(), br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_misc_CharacterClass_a(), br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().int_h()));
            if (br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_misc_CharacterClass_a() == CharacterClass.ASSASSIN) {
                ((Energy)br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_resources_Resource_a()).setCombo_points(0);
            }
            Engine.a("out of nameplate");
        }
        Engine.a("loadPlayers() 2");
        for (n2 = 0; n2 < ay.ay_a().ge_a().a().size(); ++n2) {
            br2 = ay.ay_a().ge_a().a().a(n2);
            System.out.println("Enemy plater : " + br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().java_lang_String_a() + " " + (Object)((Object)br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_resources_Resource_a().getResourceType()));
            br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().gz_a().fu_a().a((axm)((Object)this.var_agp_a));
            br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().cr_a().cy_a().a(true);
            br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().cr_a().void_c();
            br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().cr_a().void_b();
            br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().cr_a().void_d();
            br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().cr_a().a(cv.var_cv_a);
            br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().a(true);
            if (ay.ay_a() == br2) {
                ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().cr_a().i();
            }
            if (ay.ay_a().gd_a().boolean_b()) {
                if (br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().db_a() == db.var_db_a) {
                    br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().a(new ahq((Engine)((Object)this.var_agp_a), ((axm)((Object)this.var_agp_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.e), ((axm)((Object)this.var_agp_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.jd), br2, br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().gz_a(), br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_EffectManager_a(), br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a(), true, br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_resources_Resource_a().getResourceType(), br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_misc_CharacterClass_a(), br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().int_h()));
                    continue;
                }
                br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().a(new ahq((Engine)((Object)this.var_agp_a), ((axm)((Object)this.var_agp_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.e), ((axm)((Object)this.var_agp_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.jd), br2, br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().gz_a(), br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_EffectManager_a(), br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a(), false, br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_resources_Resource_a().getResourceType(), br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_misc_CharacterClass_a(), br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().int_h()));
                continue;
            }
            br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().a(new ahq((Engine)((Object)this.var_agp_a), ((axm)((Object)this.var_agp_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.e), ((axm)((Object)this.var_agp_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.jd), br2, br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().gz_a(), br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_EffectManager_a(), br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a(), false, br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_resources_Resource_a().getResourceType(), br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_misc_CharacterClass_a(), br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().int_h()));
        }
        Engine.a("loadPlayers() 3");
        this.var_ayh_a = new ayh(0, 0, ((axm)((Object)this.var_agp_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.e), "nameplate_enemy_left_curl", true);
        this.var_ayh_b = new ayh(0, 0, ((axm)((Object)this.var_agp_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.e), "nameplate_enemy_right_curl", true);
        ay.ay_a().gu_a().a((axm)((Object)this.var_agp_a));
        Engine.a("loadPlayers() 4");
        ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().aih_a().a(((axm)((Object)this.var_agp_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.jd));
        Engine.a("loadPlayers() 5");
        for (n2 = 0; n2 < ay.ay_a().gf_a().a().size(); ++n2) {
            br2 = ay.ay_a().gf_a().a().a(n2);
            br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_EffectManager_a().init((axm)((Object)this.var_agp_a));
        }
        Engine.a("loadPlayers() 6");
        ay.ay_a().gu_a().void_a();
        Engine.a("suspect");
        if (((Engine)((Object)this.var_agp_a)).var_agc_a.a().containsKey(InputIdentifier.MOVE_TOWARD_CURSOR)) {
            Engine.a("contains it");
        } else {
            Engine.a("doesn't contain it");
        }
        ((air)((Engine)((Object)this.var_agp_a)).var_agc_a.a().get(InputIdentifier.MOVE_TOWARD_CURSOR)).void_a();
        Engine.a("suspect2");
        Engine.a("loadPlayers() out");
    }

    private void d() {
    }

    private void e() {
        this.var_agr_a = new agr(this.var_agp_a, this.var_com_arenaofkings_packets_misc_GameType_a, (axm)((Object)this.var_agp_a), (Engine)((Object)this.var_agp_a));
        if (this.var_agp_a.var_com_arenaofkings_packets_misc_ArenaName_a == ArenaName.SNOWY) {
            this.var_da_a = new da(ajw.ar, "idle", 28, 0.025f, 0.1f, Animation.PlayMode.LOOP_PINGPONG, 0, 0);
            this.var_da_a.a(((axm)((Object)this.var_agp_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.ar));
            this.var_da_a.a(1325.0f, 935.0f);
            this.var_da_b = new da(ajw.jp, "Clouds", 30, 0.025f, 0.0f, Animation.PlayMode.LOOP, 0, 0);
            this.var_da_b.a(((axm)((Object)this.var_agp_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.jp));
            this.var_da_b.a(1345.0f, 935.0f);
            this.var_da_c = new da(ajw.jx, "Snow", 30, 0.025f, 0.0f, Animation.PlayMode.LOOP, 0, 0);
            this.var_da_c.a(((axm)((Object)this.var_agp_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.jx));
            this.var_da_c.a(1125.0f, 935.0f);
            this.var_ayh_c = new ayh(1435, 972, ((axm)((Object)this.var_agp_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.h), "black_platform", true);
        }
        if (this.var_agp_a.var_com_arenaofkings_packets_misc_ArenaName_a == ArenaName.DARK) {
            this.var_agp_a = new ArrayList();
            this.var_da_d = new da(ajw.jn, "BlackSmoke", 30, 0.025f, 0.0f, Animation.PlayMode.LOOP, 0, 0);
            this.var_da_d.a(((axm)((Object)this.var_agp_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.jn));
            this.var_da_d.a((float)(745 + MathUtils.random(100)), 1295 + MathUtils.random(25));
            if (MathUtils.randomBoolean()) {
                this.a(745 + MathUtils.random(100), 1295 + MathUtils.random(25));
            }
            if (MathUtils.randomBoolean()) {
                this.a(1845 + MathUtils.random(100), 1295 + MathUtils.random(25));
            }
        }
        if (this.var_agp_a.var_com_arenaofkings_packets_misc_ArenaName_a == ArenaName.INDOOR) {
            this.var_da_f = new da(ajw.jy, "Stars", 30, 0.05f, 0.5f, Animation.PlayMode.LOOP, 0, 0);
            this.var_da_f.a(((axm)((Object)this.var_agp_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.jy));
            this.var_da_f.a((float)(745 + MathUtils.random(100)), 1225 + MathUtils.random(25));
            this.var_da_e = new da(ajw.jA, "WhiteSmoke", 30, 0.05f, -0.35f, Animation.PlayMode.LOOP, 0, 0);
            this.var_da_e.a(((axm)((Object)this.var_agp_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.jA));
            this.var_da_e.a(1325.0f, 685.0f);
        }
    }

    private void f() {
        this.var_hi_a = new hi();
        this.var_hi_a.a(((Engine)((Object)this.var_agp_a)).var_azi_a);
    }

    private void g() {
        ((Array)((Object)this.var_agp_a)).add(((agn)((Object)this.var_agp_a)).var_agt_a);
    }

    @Override
    public void show() {
        Object object;
        Engine.a("show 1");
        ((Engine)((Object)this.var_agp_a)).var_or_a.a(((axm)((Object)this.var_agp_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.jc));
        this.void_c();
        Engine.a("show 2");
        this.f();
        Engine.a("show 3");
        this.e();
        Engine.a("show 4");
        this.d();
        Engine.a("show 5");
        this.var_ajt_a = new ajt(((axm)((Object)this.var_agp_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.e), ((axm)((Object)this.var_agp_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c));
        Engine.a("show 6");
        if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX() > 1500.0f) {
            this.var_float_b = 2750.0f;
            this.var_float_c = 700.0f;
            this.var_float_d = 250.0f;
            this.var_float_e = 700.0f;
        } else {
            this.var_float_b = 250.0f;
            this.var_float_c = 700.0f;
            this.var_float_d = 2750.0f;
            this.var_float_e = 700.0f;
        }
        ay.ay_a().gd_a().ev_a().void_a("Game");
        this.var_r_a = new r(1920.0f, 1080.0f);
        this.var_float_f = 960.0f;
        this.var_float_g = 540.0f;
        if (ay.ay_a().gd_a().boolean_b()) {
            this.var_r_a.position.x = this.var_float_f;
            this.var_r_a.position.y = this.var_float_g;
        } else {
            this.var_r_a.position.x = MathUtils.clamp(this.var_float_b, this.var_float_f, this.var_agr_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getWidth() - this.var_float_f);
            this.var_r_a.position.y = MathUtils.clamp(this.var_float_c, this.var_float_g, this.var_agr_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getHeight() - this.var_float_g);
        }
        this.var_r_a.zoom = 1.0f;
        this.var_com_badlogic_gdx_utils_viewport_Viewport_a = new StretchViewport(1920.0f, 1080.0f, this.var_r_a);
        this.var_com_badlogic_gdx_utils_viewport_Viewport_a.setScreenPosition((int)this.var_r_a.position.x, (int)this.var_r_a.position.y);
        this.var_r_a.update();
        Engine.a("show 7");
        this.var_agp_a = new agn((axm)((Object)this.var_agp_a), (Engine)((Object)this.var_agp_a));
        Engine.a("show 8 - manager done");
        switch (this.var_com_arenaofkings_packets_misc_GameType_a) {
            case ARENA: {
                this.var_zo_a = new zo((Engine)((Object)this.var_agp_a), ((aya)((Object)this.var_agp_a)).com_badlogic_gdx_scenes_scene2d_Stage_c(), (axm)((Object)this.var_agp_a), 600, 675, this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_b().id, this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_b().name, this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_b().tag, this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_b().rank, this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_b().points, this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_b().logo, this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_b().country, "BORDER TODO", this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_b().fame);
                this.var_zo_a.a(true);
                this.var_zo_a.c(true);
                this.var_zo_b = new zo((Engine)((Object)this.var_agp_a), ((aya)((Object)this.var_agp_a)).com_badlogic_gdx_scenes_scene2d_Stage_c(), (axm)((Object)this.var_agp_a), 985, 675, this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_a().id, this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_a().name, this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_a().tag, this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_a().rank, this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_a().points, this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_a().logo, this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_a().country, "BORDER TODO", this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_a().fame);
                this.var_zo_b.a(true);
                this.var_zo_b.c(false);
                break;
            }
            case BOT_GAME_1: {
                this.var_zo_a = new zo((Engine)((Object)this.var_agp_a), ((aya)((Object)this.var_agp_a)).com_badlogic_gdx_scenes_scene2d_Stage_c(), (axm)((Object)this.var_agp_a), 600, 675, this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_b().id, this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_b().name, this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_b().tag, this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_b().rank, this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_b().points, this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_b().logo, this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_b().country, "BORDER TODO", this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_b().fame);
                this.var_zo_a.a(true);
                this.var_zo_b = new zo((Engine)((Object)this.var_agp_a), ((aya)((Object)this.var_agp_a)).com_badlogic_gdx_scenes_scene2d_Stage_c(), (axm)((Object)this.var_agp_a), 985, 675, this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_a().id, this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_a().name, this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_a().tag, this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_a().rank, this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_a().points, this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_a().logo, this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_a().country, "BORDER TODO", this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_a().fame);
                this.var_zo_b.a(true);
                break;
            }
            case BOT_GAME_2: {
                this.var_zo_a = new zo((Engine)((Object)this.var_agp_a), ((aya)((Object)this.var_agp_a)).com_badlogic_gdx_scenes_scene2d_Stage_c(), (axm)((Object)this.var_agp_a), 600, 675, this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_b().id, this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_b().name, this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_b().tag, this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_b().rank, this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_b().points, this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_b().logo, this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_b().country, "BORDER TODO", this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_b().fame);
                this.var_zo_a.a(true);
                this.var_zo_b = new zo((Engine)((Object)this.var_agp_a), ((aya)((Object)this.var_agp_a)).com_badlogic_gdx_scenes_scene2d_Stage_c(), (axm)((Object)this.var_agp_a), 985, 675, this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_a().id, this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_a().name, this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_a().tag, this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_a().rank, this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_a().points, this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_a().logo, this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_a().country, "BORDER TODO", this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_a().fame);
                this.var_zo_b.a(true);
                break;
            }
            case BOT_GAME_3: {
                this.var_zo_a = new zo((Engine)((Object)this.var_agp_a), ((aya)((Object)this.var_agp_a)).com_badlogic_gdx_scenes_scene2d_Stage_c(), (axm)((Object)this.var_agp_a), 600, 675, this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_b().id, this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_b().name, this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_b().tag, this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_b().rank, this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_b().points, this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_b().logo, this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_b().country, "BORDER TODO", this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_b().fame);
                this.var_zo_a.a(true);
                this.var_zo_b = new zo((Engine)((Object)this.var_agp_a), ((aya)((Object)this.var_agp_a)).com_badlogic_gdx_scenes_scene2d_Stage_c(), (axm)((Object)this.var_agp_a), 985, 675, this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_a().id, this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_a().name, this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_a().tag, this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_a().rank, this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_a().points, this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_a().logo, this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_a().country, "BORDER TODO", this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_a().fame);
                this.var_zo_b.a(true);
                break;
            }
            case BOT_GAME_4: {
                this.var_zo_a = new zo((Engine)((Object)this.var_agp_a), ((aya)((Object)this.var_agp_a)).com_badlogic_gdx_scenes_scene2d_Stage_c(), (axm)((Object)this.var_agp_a), 600, 675, this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_b().id, this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_b().name, this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_b().tag, this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_b().rank, this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_b().points, this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_b().logo, this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_b().country, "BORDER TODO", this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_b().fame);
                this.var_zo_a.a(true);
                this.var_zo_b = new zo((Engine)((Object)this.var_agp_a), ((aya)((Object)this.var_agp_a)).com_badlogic_gdx_scenes_scene2d_Stage_c(), (axm)((Object)this.var_agp_a), 985, 675, this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_a().id, this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_a().name, this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_a().tag, this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_a().rank, this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_a().points, this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_a().logo, this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_a().country, "BORDER TODO", this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_a().fame);
                this.var_zo_b.a(true);
                break;
            }
            case BOT_GAME_5: {
                this.var_zo_a = new zo((Engine)((Object)this.var_agp_a), ((aya)((Object)this.var_agp_a)).com_badlogic_gdx_scenes_scene2d_Stage_c(), (axm)((Object)this.var_agp_a), 600, 675, this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_b().id, this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_b().name, this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_b().tag, this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_b().rank, this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_b().points, this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_b().logo, this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_b().country, "BORDER TODO", this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_b().fame);
                this.var_zo_a.a(true);
                this.var_zo_b = new zo((Engine)((Object)this.var_agp_a), ((aya)((Object)this.var_agp_a)).com_badlogic_gdx_scenes_scene2d_Stage_c(), (axm)((Object)this.var_agp_a), 985, 675, this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_a().id, this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_a().name, this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_a().tag, this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_a().rank, this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_a().points, this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_a().logo, this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_a().country, "BORDER TODO", this.var_agp_a.com_arenaofkings_packets_misc_ArenaTeamData_a().fame);
                this.var_zo_b.a(true);
                break;
            }
            case TRAININGGROUND: {
                this.var_boolean_a = false;
                this.b(true);
                this.n = true;
                break;
            }
            case DARK_BOSS_BATTLE: {
                this.n = true;
                break;
            }
            case TUTORIAL_DPS: {
                Iterator iterator2;
                this.var_boolean_a = false;
                this.b(true);
                this.n = true;
                for (Iterator iterator2 : ay.ay_a().ge_a().a().values()) {
                    ((br)((Object)iterator2)).com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().b(true);
                }
                object = new Label.LabelStyle(((Engine)((Object)this.var_agp_a)).j, Color.WHITE);
                iterator2 = new TextButton.TextButtonStyle();
                ((TextButton.TextButtonStyle)((Object)iterator2)).font = ((Engine)((Object)this.var_agp_a)).l;
                ((TextButton.TextButtonStyle)((Object)iterator2)).fontColor = axe.K;
                this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a = new age(this, "", ((Engine)((Object)this.var_agp_a)).var_com_badlogic_gdx_scenes_scene2d_ui_Skin_a, (Label.LabelStyle)object);
                this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a.align(1);
                this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a.setBounds(750.0f, 450.0f, 450.0f, 205.0f);
                if (!((aya)((Object)this.var_agp_a)).var_com_badlogic_gdx_scenes_scene2d_Stage_a.getActors().contains(this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a, true)) {
                    ((aya)((Object)this.var_agp_a)).var_com_badlogic_gdx_scenes_scene2d_Stage_a.addActor(this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a);
                    Engine.b("added dialog");
                    break;
                }
                Engine.b("didn't add dialog");
                break;
            }
            case TUTORIAL_HEALER: {
                this.var_boolean_a = false;
                this.b(true);
                this.n = true;
                break;
            }
        }
        Engine.a("show 8");
        Engine.a("PlayGUIManager() out");
        object = new aik((Engine)((Object)this.var_agp_a), this);
        this.var_aik_a = object;
        this.var_com_badlogic_gdx_InputMultiplexer_a.addProcessor((InputProcessor)object);
        this.var_com_badlogic_gdx_InputMultiplexer_a.addProcessor(((aya)((Object)this.var_agp_a)).com_badlogic_gdx_scenes_scene2d_Stage_c());
        Gdx.input.setInputProcessor(this.var_com_badlogic_gdx_InputMultiplexer_a);
        switch (this.var_agr_a.var_com_arenaofkings_packets_misc_ArenaName_a) {
            case DARK: {
                this.var_com_badlogic_gdx_maps_tiled_TiledMap_a = (TiledMap)((axm)((Object)this.var_agp_a)).com_badlogic_gdx_utils_Disposable_a(ajw.p);
                break;
            }
            case DESERT: {
                this.var_com_badlogic_gdx_maps_tiled_TiledMap_a = (TiledMap)((axm)((Object)this.var_agp_a)).com_badlogic_gdx_utils_Disposable_a(ajw.t);
                break;
            }
            case FOREST: {
                this.var_com_badlogic_gdx_maps_tiled_TiledMap_a = (TiledMap)((axm)((Object)this.var_agp_a)).com_badlogic_gdx_utils_Disposable_a(ajw.x);
                break;
            }
            case INDOOR: {
                this.var_com_badlogic_gdx_maps_tiled_TiledMap_a = (TiledMap)((axm)((Object)this.var_agp_a)).com_badlogic_gdx_utils_Disposable_a(ajw.B);
                break;
            }
            case SNOWY: {
                this.var_com_badlogic_gdx_maps_tiled_TiledMap_a = (TiledMap)((axm)((Object)this.var_agp_a)).com_badlogic_gdx_utils_Disposable_a(ajw.l);
                break;
            }
            default: {
                this.var_com_badlogic_gdx_maps_tiled_TiledMap_a = (TiledMap)((axm)((Object)this.var_agp_a)).com_badlogic_gdx_utils_Disposable_a(ajw.p);
            }
        }
        this.g();
        if (ay.ay_a().gd_a().boolean_b()) {
            ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bb_a().a(this.var_com_badlogic_gdx_maps_tiled_TiledMap_a);
        }
        for (br br2 : ay.ay_a().gf_a().a().values()) {
            this.var_boolean_b.add(br2);
            br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().az_a().a(this.var_com_badlogic_gdx_maps_tiled_TiledMap_a);
        }
        for (br br2 : ay.ay_a().ge_a().a().values()) {
            this.var_boolean_b.add(br2);
            br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().az_a().a(this.var_com_badlogic_gdx_maps_tiled_TiledMap_a);
        }
        if (this.var_com_arenaofkings_packets_misc_GameType_a == GameType.ARENA) {
            if (!ay.ay_a().gd_a().boolean_b()) {
                this.var_r_a.position.x = MathUtils.clamp(this.var_float_b, this.var_float_f, this.var_agr_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getWidth() - this.var_float_f);
                this.var_r_a.position.y = MathUtils.clamp(this.var_float_c, this.var_float_g, this.var_agr_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getHeight() - this.var_float_g);
            } else {
                this.var_r_a.position.x = this.var_agr_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getWidth() / 2.0f;
                this.var_r_a.position.y = this.var_agr_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getHeight() / 2.0f;
            }
        } else {
            this.var_r_a.position.x = MathUtils.clamp(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX(), this.var_float_f, this.var_agr_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getWidth() - this.var_float_f);
            this.var_r_a.position.y = MathUtils.clamp(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY(), this.var_float_g, this.var_agr_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getHeight() - this.var_float_g);
        }
        this.var_r_a.zoom = 1.0f;
        ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bb_a().a(this.var_r_a);
        this.var_com_badlogic_gdx_graphics_g2d_BitmapFont_a.setColor(Color.GREEN);
        this.var_com_badlogic_gdx_graphics_Pixmap_a = new Pixmap(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getRadius(), ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getRadius(), Pixmap.Format.RGBA8888);
        this.var_com_badlogic_gdx_graphics_Pixmap_a.setColor(Color.RED);
        this.var_com_badlogic_gdx_graphics_Pixmap_a.fillCircle(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getRadius() / 2, ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getRadius() / 2, ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getRadius());
        this.var_com_badlogic_gdx_graphics_Texture_a = new Texture(this.var_com_badlogic_gdx_graphics_Pixmap_a);
        this.var_azv_a = new azv(120000L, false);
        ((Engine)((Object)this.var_agp_a)).var_ag_a.b(new PUB_PLAY_READY());
        this.var_ayh_h = new ayh(307, 440, ((axm)((Object)this.var_agp_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.e), "waiting_for_players", true);
        this.var_ayh_d = new ayh(900, 687, ((axm)((Object)this.var_agp_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.e), "3", true);
        this.var_ayh_e = new ayh(900, 687, ((axm)((Object)this.var_agp_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.e), "2", true);
        this.var_ayh_f = new ayh(900, 687, ((axm)((Object)this.var_agp_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.e), "1", true);
        this.var_ayh_g = new ayh(25, 650, ((axm)((Object)this.var_agp_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.e), "fight", true);
        this.var_ayh_i = new ayh(76, 650, ((axm)((Object)this.var_agp_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.e), "sudden_death", true);
    }

    @Override
    public void render(float f2) {
        if (this.var_org_apache_commons_lang3_time_StopWatch_a == null) {
            this.var_org_apache_commons_lang3_time_StopWatch_a = StopWatch.createStarted();
            this.var_java_time_Instant_a = Instant.now();
        }
        Instant instant = Instant.now();
        long l2 = Duration.between(this.var_java_time_Instant_a, instant).toMillis();
        if (this.var_org_apache_commons_lang3_time_StopWatch_a.getTime(TimeUnit.MILLISECONDS) - l2 > 2000L) {
            ((Engine)((Object)this.var_agp_a)).var_z_a.d();
        }
        ((Engine)((Object)this.var_agp_a)).e();
        ((Engine)((Object)this.var_agp_a)).f();
        ((Engine)((Object)this.var_agp_a)).a(((Engine)((Object)this.var_agp_a)).var_azi_a);
        if (((Engine)((Object)this.var_agp_a)).boolean_a()) {
            return;
        }
        this.g(f2);
        if (!this.u) {
            this.d(f2);
            if (this.m) {
                this.h(f2);
                this.a(f2, (Engine)((Object)this.var_agp_a));
            }
            if (this.m) {
                this.i(f2);
                if (ay.ay_a().gd_a().boolean_b()) {
                    this.var_boolean_a = false;
                    this.var_boolean_b = false;
                    this.var_boolean_f = false;
                    this.var_azv_c.d();
                    this.b(true);
                }
                if (this.var_boolean_a && this.var_ayh_h != null) {
                    this.var_ayh_h.b(f2, (Engine)((Object)this.var_agp_a));
                }
                if (this.var_boolean_b) {
                    if (this.var_zo_a != null) {
                        this.var_zo_a.d(this.var_agp_a.var_boolean_b);
                        this.var_zo_a.b(f2, (Engine)((Object)this.var_agp_a));
                    }
                    if (this.var_zo_b != null) {
                        this.var_zo_b.d(this.var_agp_a.var_boolean_b);
                        this.var_zo_b.b(f2, (Engine)((Object)this.var_agp_a));
                    }
                }
                if (this.var_boolean_f && !this.var_boolean_g) {
                    if (!this.var_azv_c.boolean_a()) {
                        Engine.b("COUNTDOWN START");
                        this.var_azv_c.void_a();
                        ((Engine)((Object)this.var_agp_a)).var_baa_a.a(ajw.kM);
                    }
                    if (this.var_azv_c.a(TimeUnit.MILLISECONDS) + this.var_long_b <= 1000L) {
                        this.var_ayh_d.b(f2, (Engine)((Object)this.var_agp_a));
                        this.var_ayh_d.com_badlogic_gdx_graphics_g2d_Sprite_a().scale(-1.0f * f2 * 0.5f);
                    } else if (this.var_azv_c.a(TimeUnit.MILLISECONDS) + this.var_long_b <= 2000L) {
                        this.var_ayh_e.b(f2, (Engine)((Object)this.var_agp_a));
                        this.var_ayh_e.com_badlogic_gdx_graphics_g2d_Sprite_a().scale(-1.0f * f2 * 0.5f);
                    } else if (this.var_azv_c.a(TimeUnit.MILLISECONDS) + this.var_long_b <= 3000L) {
                        this.var_ayh_f.b(f2, (Engine)((Object)this.var_agp_a));
                        this.var_ayh_f.com_badlogic_gdx_graphics_g2d_Sprite_a().scale(-1.0f * f2 * 0.5f);
                    } else if (this.var_azv_c.a(TimeUnit.MILLISECONDS) + this.var_long_b <= 4000L) {
                        if (!this.var_boolean_g) {
                            this.b(true);
                        }
                        this.var_ayh_g.b(f2, (Engine)((Object)this.var_agp_a));
                        this.var_ayh_g.com_badlogic_gdx_graphics_g2d_Sprite_a().scale(-1.0f * f2 * 1.0f);
                    } else {
                        this.var_boolean_f = false;
                        this.var_azv_c.d();
                        Engine.b("COUNTDOWN ENDED");
                    }
                }
                if (this.var_boolean_g && this.var_azv_c.a(TimeUnit.MILLISECONDS) + this.var_long_b <= 4000L && this.var_ayh_g.com_badlogic_gdx_graphics_g2d_Sprite_a().getScaleX() >= 0.0f) {
                    this.var_ayh_g.b(f2, (Engine)((Object)this.var_agp_a));
                    this.var_ayh_g.com_badlogic_gdx_graphics_g2d_Sprite_a().scale(-1.0f * f2 * 1.0f);
                }
                if (this.x) {
                    this.var_ayh_i.b(f2, (Engine)((Object)this.var_agp_a));
                    this.var_ayh_i.com_badlogic_gdx_graphics_g2d_Sprite_a().scale(-1.0f * f2 / 2.0f * 1.0f);
                    if ((double)this.var_ayh_i.com_badlogic_gdx_graphics_g2d_Sprite_a().getScaleX() <= 0.01) {
                        this.x = false;
                    }
                }
                this.var_agp_a.a(f2, ((Engine)((Object)this.var_agp_a)).var_azi_a);
            }
        }
        if (this.u) {
            this.var_com_badlogic_gdx_math_Matrix4_a = this.var_r_a.combined.cpy();
            this.var_com_badlogic_gdx_math_Matrix4_a.setToOrtho2D(0.0f, 0.0f, 1920.0f, 1080.0f);
            ((Engine)((Object)this.var_agp_a)).var_azi_a.setProjectionMatrix(this.var_com_badlogic_gdx_math_Matrix4_a);
            this.var_agr_a.var_ayh_a.b(f2, (Engine)((Object)this.var_agp_a));
            if (this.var_azv_g.boolean_b()) {
                this.var_azv_g.void_c();
            }
            if (this.var_azv_g.a(TimeUnit.MILLISECONDS) >= 666L) {
                ((Engine)((Object)this.var_agp_a)).a("Arena Loading.", ((Engine)((Object)this.var_agp_a)).var_axy_f.a(), axe.x, ((Engine)((Object)this.var_agp_a)).var_axy_f.a(), Color.BLACK, 1540.0f, 100.0f, 8, 1);
            } else if (this.var_azv_g.a(TimeUnit.MILLISECONDS) >= 333L) {
                ((Engine)((Object)this.var_agp_a)).a("Arena Loading..", ((Engine)((Object)this.var_agp_a)).var_axy_f.a(), axe.x, ((Engine)((Object)this.var_agp_a)).var_axy_f.a(), Color.BLACK, 1540.0f, 100.0f, 8, 1);
            } else if (this.var_azv_g.a(TimeUnit.MILLISECONDS) >= 0L) {
                ((Engine)((Object)this.var_agp_a)).a("Arena Loading...", ((Engine)((Object)this.var_agp_a)).var_axy_f.a(), axe.x, ((Engine)((Object)this.var_agp_a)).var_axy_f.a(), Color.BLACK, 1540.0f, 100.0f, 8, 1);
            }
            this.var_agp_a.a(f2, ((Engine)((Object)this.var_agp_a)).var_azi_a);
        }
        if (((Engine)((Object)this.var_agp_a)).var_azi_a.isDrawing()) {
            ((Engine)((Object)this.var_agp_a)).var_azi_a.end();
        }
        ((Engine)((Object)this.var_agp_a)).var_ag_a.f();
        this.b(((Engine)((Object)this.var_agp_a)).var_azi_a);
    }

    private void b(float f2) {
        if (this.var_azv_a.a(TimeUnit.SECONDS) > 2L && !this.y) {
            this.a("Set your [RED]Target[] by [BY]Left Clicking[] a Player.\nAlternatively, [RED]Target Enemies[] by pressing\n                [BY]" + ((Engine)((Object)this.var_agp_a)).var_agc_a.a(InputIdentifier.TARGET_TAB) + "[] (next) or [BY]" + ((Engine)((Object)this.var_agp_a)).var_agc_a.a(InputIdentifier.TARGET_NEAREST_ENEMY) + "[] (closest).\nClear your [RED]Target[] by pressing [BY]Escape[].", 1450, 185);
        }
        if (this.var_azv_a.a(TimeUnit.SECONDS) > 8L) {
            if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_misc_CharacterClass_a() == CharacterClass.ASSASSIN || ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_misc_CharacterClass_a() == CharacterClass.RANGER) {
                this.a("IMPORTANT: While targeting an enemy, [RED]Basic Attack[] by pressing [BY]" + ((Engine)((Object)this.var_agp_a)).var_agc_a.a(InputIdentifier.BASIC) + "[] to restore [SKY]Energy[] and deal damage to your [RED]Target[].", 630, 190);
            } else if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_misc_CharacterClass_a() == CharacterClass.CHAMPION) {
                this.a("IMPORTANT: While targeting an enemy, [RED]Basic Attack[] by pressing [BY]" + ((Engine)((Object)this.var_agp_a)).var_agc_a.a(InputIdentifier.BASIC) + "[] to restore [SKY]Rage[] and deal damage to your [RED]Target[].", 630, 190);
            } else {
                this.a("While targeting an enemy, [RED]Basic Attack[] by pressing [BY]" + ((Engine)((Object)this.var_agp_a)).var_agc_a.a(InputIdentifier.BASIC) + "[] to deal damage to your [RED]Target[].", 630, 190);
            }
        }
        if (this.var_azv_a.a(TimeUnit.SECONDS) > 14L) {
            this.a("[GREEN]Target Self[]: [BY]" + ((Engine)((Object)this.var_agp_a)).var_agc_a.a(InputIdentifier.TARGET_SELF) + "[]", 110, 125);
            this.a("[GREEN]Target Ally 2[]: [BY]" + ((Engine)((Object)this.var_agp_a)).var_agc_a.a(InputIdentifier.TARGET_ALLY_2) + "[]", 300, 125);
            this.a("[GREEN]Target Ally 3[]: [BY]" + ((Engine)((Object)this.var_agp_a)).var_agc_a.a(InputIdentifier.TARGET_ALLY_3) + "[]", 480, 125);
        }
        if (this.var_azv_a.a(TimeUnit.SECONDS) > 18L) {
            this.a("[GREEN]Buffs[] and [RED]Debuffs[] are displayed up here!", 1550, 980);
        }
        if (this.var_azv_a.a(TimeUnit.SECONDS) > 21L) {
            this.a("[PURPLE]Gameplay Tips from the Pros[]:\n \"For [RED]Movement[], use a combination of [BY]WASD[] and holding down [BY]Right Click[].\"\n\n  \"Activate your [CYAN]Trinket of Resolve[] ([BY]" + ((Engine)((Object)this.var_agp_a)).var_agc_a.a(InputIdentifier.TRINKET_1) + "[]) to remove ALL slow and crowd control [RED]Debuffs[] from you.\n  Trinket can be used while you are [RED]Crowd Controlled[]! (60 second Cooldown).\" ", 60, 870);
        }
    }

    private void a(String string, int n2, int n3, int n4) {
        String string2 = azu.a((Engine)((Object)this.var_agp_a), ((Engine)((Object)this.var_agp_a)).var_axy_c.a(), string, n4);
        int n5 = azu.a((Engine)((Object)this.var_agp_a), ((Engine)((Object)this.var_agp_a)).var_axy_c.a(), string2);
        int n6 = azu.b((Engine)((Object)this.var_agp_a), ((Engine)((Object)this.var_agp_a)).var_axy_c.a(), string2);
        ((Engine)((Object)this.var_agp_a)).var_azi_a.end();
        ((Engine)((Object)this.var_agp_a)).var_axf_a.begin(ShapeRenderer.ShapeType.Filled);
        if (((Engine)((Object)this.var_agp_a)).var_axf_a.isDrawing()) {
            ((Engine)((Object)this.var_agp_a)).var_axf_a.a(n2 - 12, (float)(n3 - 12 - n6), (float)(n5 + 25), (float)(n6 + 25), 20.0f, axe.y);
        }
        ((Engine)((Object)this.var_agp_a)).var_axf_a.end();
        ((Engine)((Object)this.var_agp_a)).var_azi_a.begin();
    }

    private void a(String string, int n2, int n3) {
        ((Engine)((Object)this.var_agp_a)).a(string, ((Engine)((Object)this.var_agp_a)).var_axy_b.a(), Color.WHITE, ((Engine)((Object)this.var_agp_a)).var_axy_b.a(), Color.BLACK, n2, n3, 8, ((Engine)((Object)this.var_agp_a)).var_azi_a);
    }

    private void c(float f2) {
        this.var_ajt_a.b(f2, (Engine)((Object)this.var_agp_a));
    }

    private void d(float f2) {
        axi axi2;
        if (this.var_int_d == 1) {
            ((Engine)((Object)this.var_agp_a)).var_azi_a.setShader(axs.var_com_badlogic_gdx_graphics_glutils_ShaderProgram_a);
        } else if (this.var_int_d == 2) {
            ((Engine)((Object)this.var_agp_a)).var_azi_a.setShader(axu.var_com_badlogic_gdx_graphics_glutils_ShaderProgram_a);
        } else if (this.var_int_d == 3) {
            ((Engine)((Object)this.var_agp_a)).var_azi_a.setShader(axw.var_com_badlogic_gdx_graphics_glutils_ShaderProgram_a);
        } else if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().boolean_b()) {
            ((Engine)((Object)this.var_agp_a)).var_azi_a.setShader(ayd.var_com_badlogic_gdx_graphics_glutils_ShaderProgram_a);
        }
        ((Engine)((Object)this.var_agp_a)).var_azi_a.draw(this.var_agr_a.com_badlogic_gdx_graphics_g2d_Sprite_a(), 0.0f, 0.0f);
        this.e(f2);
        this.f(f2);
        this.var_hi_a.a(f2, (Engine)((Object)this.var_agp_a));
        for (da object : this.var_agr_a.b()) {
            object.b(f2, (Engine)((Object)this.var_agp_a));
        }
        if (this.var_da_a != null) {
            ((Engine)((Object)this.var_agp_a)).a("Otherworldly Being", ((Engine)((Object)this.var_agp_a)).var_axy_b.a(), axe.m, ((Engine)((Object)this.var_agp_a)).var_axy_b.a(), Color.BLACK, this.var_da_a.float_d() + 173.0f, this.var_da_a.e() + 202.0f + this.var_float_a, 1, 1);
            this.var_ayh_c.b(f2, (Engine)((Object)this.var_agp_a), (int)this.var_ayh_c.com_badlogic_gdx_graphics_g2d_Sprite_a().getX(), (int)(this.var_ayh_c.com_badlogic_gdx_graphics_g2d_Sprite_a().getY() + this.var_float_a));
            this.var_da_a.a(f2, (Engine)((Object)this.var_agp_a));
            this.var_da_a.a(f2, (int)this.var_da_a.float_d(), (float)((int)this.var_da_a.e()) + this.var_float_a, ((Engine)((Object)this.var_agp_a)).var_azi_a, 1.0f);
            if (this.var_float_a >= 20.0f || this.var_float_a < 0.0f) {
                this.var_int_a *= -1;
            }
            this.var_float_a += (float)this.var_int_a * f2;
            this.var_da_b.b(f2, (Engine)((Object)this.var_agp_a));
            this.var_da_b.a(f2, 235.0f, 1295.0f, ((Engine)((Object)this.var_agp_a)).var_azi_a, 0.5f);
            this.var_da_b.a(f2, 795.0f, 1255.0f, ((Engine)((Object)this.var_agp_a)).var_azi_a, 0.75f);
            this.var_da_b.a(f2, 1725.0f, 1155.0f, ((Engine)((Object)this.var_agp_a)).var_azi_a, 0.25f);
            this.var_da_b.a(f2, 2105.0f, 1345.0f, ((Engine)((Object)this.var_agp_a)).var_azi_a, 0.66f);
            this.var_da_c.b(f2, (Engine)((Object)this.var_agp_a));
            this.var_da_c.a(f2, 1425.0f, 935.0f, ((Engine)((Object)this.var_agp_a)).var_azi_a);
            this.var_da_c.a(f2, 1425.0f, 1135.0f, ((Engine)((Object)this.var_agp_a)).var_azi_a);
            this.var_da_c.a(f2, 1525.0f, 1185.0f, ((Engine)((Object)this.var_agp_a)).var_azi_a);
            this.var_da_c.a(f2, 1125.0f, 1115.0f, ((Engine)((Object)this.var_agp_a)).var_azi_a);
            this.var_da_c.a(f2, 0.0f, 1345.0f, ((Engine)((Object)this.var_agp_a)).var_azi_a);
            this.var_da_c.a(f2, 225.0f, 1345.0f, ((Engine)((Object)this.var_agp_a)).var_azi_a);
            this.var_da_c.a(f2, 525.0f, 1375.0f, ((Engine)((Object)this.var_agp_a)).var_azi_a);
            this.var_da_c.a(f2, 825.0f, 1355.0f, ((Engine)((Object)this.var_agp_a)).var_azi_a);
            this.var_da_c.a(f2, 985.0f, 1175.0f, ((Engine)((Object)this.var_agp_a)).var_azi_a);
            this.var_da_c.a(f2, 1725.0f, 1175.0f, ((Engine)((Object)this.var_agp_a)).var_azi_a);
            this.var_da_c.a(f2, 1125.0f, 1335.0f, ((Engine)((Object)this.var_agp_a)).var_azi_a);
            this.var_da_c.a(f2, 1525.0f, 1385.0f, ((Engine)((Object)this.var_agp_a)).var_azi_a);
            this.var_da_c.a(f2, 1725.0f, 1365.0f, ((Engine)((Object)this.var_agp_a)).var_azi_a);
            this.var_da_c.a(f2, 1925.0f, 1365.0f, ((Engine)((Object)this.var_agp_a)).var_azi_a);
            this.var_da_c.a(f2, 2105.0f, 1345.0f, ((Engine)((Object)this.var_agp_a)).var_azi_a);
            this.var_da_c.a(f2, 2305.0f, 1355.0f, ((Engine)((Object)this.var_agp_a)).var_azi_a);
            this.var_da_c.a(f2, 2555.0f, 1365.0f, ((Engine)((Object)this.var_agp_a)).var_azi_a);
            this.var_da_c.a(f2, 2765.0f, 1370.0f, ((Engine)((Object)this.var_agp_a)).var_azi_a);
            this.var_da_c.a(f2, 1125.0f, 400.0f, ((Engine)((Object)this.var_agp_a)).var_azi_a);
            this.var_da_c.a(f2, 1425.0f, 400.0f, ((Engine)((Object)this.var_agp_a)).var_azi_a);
            this.var_da_c.a(f2, 1125.0f, 150.0f, ((Engine)((Object)this.var_agp_a)).var_azi_a);
            this.var_da_c.a(f2, 1425.0f, 150.0f, ((Engine)((Object)this.var_agp_a)).var_azi_a);
        }
        if (this.var_agr_a.var_com_arenaofkings_packets_misc_ArenaName_a == ArenaName.DARK) {
            this.var_da_d.a(f2, (Engine)((Object)this.var_agp_a));
            Iterator<Object> iterator = this.var_agp_a.iterator();
            while (iterator.hasNext()) {
                da da2 = (da)iterator.next();
                da2.b(f2, (Engine)((Object)this.var_agp_a));
                this.var_da_d.a(f2, da2.float_d() - 88.0f, da2.e() + 75.0f, ((Engine)((Object)this.var_agp_a)).var_azi_a);
            }
        } else if (this.var_agr_a.var_com_arenaofkings_packets_misc_ArenaName_a == ArenaName.INDOOR) {
            this.var_da_f.a(f2, (Engine)((Object)this.var_agp_a));
            this.var_da_f.a(f2, 235.0f, 1275.0f, ((Engine)((Object)this.var_agp_a)).var_azi_a, 0.5f);
            this.var_da_f.a(f2, 795.0f, 1225.0f, ((Engine)((Object)this.var_agp_a)).var_azi_a, 0.75f);
            this.var_da_f.a(f2, 1725.0f, 1235.0f, ((Engine)((Object)this.var_agp_a)).var_azi_a, 0.55f);
            this.var_da_f.a(f2, 2405.0f, 1245.0f, ((Engine)((Object)this.var_agp_a)).var_azi_a, 0.76f);
        }
        block2: for (br br2 : ay.ay_a().ge_a().a().values()) {
            this.var_int_f = 0;
            for (axi axi3 : this.var_agr_a.a()) {
                if (axi3 instanceof axi) {
                    axi2 = axi3;
                    if (this.u || br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().boolean_b() || !br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().cr_a().com_badlogic_gdx_math_Rectangle_a().overlaps(axi2.com_badlogic_gdx_graphics_g2d_Sprite_a().getBoundingRectangle()) || !(br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY() >= (float)axi2.int_a())) continue;
                    if (this.var_int_f > 1) continue block2;
                    if (br2.boolean_b()) continue;
                    br2.b(f2, (Engine)((Object)this.var_agp_a), ((agn)((Object)this.var_agp_a)).var_ayh_a, ((agn)((Object)this.var_agp_a)).b);
                    br2.d(f2, (Engine)((Object)this.var_agp_a));
                    br2.c(f2, (Engine)((Object)this.var_agp_a));
                    if (this.var_da_g == null) continue;
                    this.var_da_g.a(f2, (Engine)((Object)this.var_agp_a));
                    this.var_da_g.b(f2, this.var_int_b, this.var_int_c, ((Engine)((Object)this.var_agp_a)).var_azi_a);
                    continue;
                }
                Engine.a("[ERROR] Layering for non ImageGFX not supported!");
            }
        }
        block4: for (br br3 : ay.ay_a().gf_a().a().values()) {
            this.var_int_f = 0;
            for (axi axi3 : this.var_agr_a.a()) {
                if (axi3 instanceof axi) {
                    axi2 = axi3;
                    if (this.u || !br3.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().cr_a().com_badlogic_gdx_math_Rectangle_a().overlaps(axi2.com_badlogic_gdx_graphics_g2d_Sprite_a().getBoundingRectangle()) || !(br3.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY() >= (float)axi2.int_a())) continue;
                    ++this.var_int_f;
                    if (br3.boolean_b()) continue;
                    br3.b(f2, (Engine)((Object)this.var_agp_a), ((agn)((Object)this.var_agp_a)).var_ayh_a, ((agn)((Object)this.var_agp_a)).b);
                    br3.d(f2, (Engine)((Object)this.var_agp_a));
                    br3.c(f2, (Engine)((Object)this.var_agp_a));
                    if (this.var_da_g == null) continue block4;
                    this.var_da_g.a(f2, (Engine)((Object)this.var_agp_a));
                    this.var_da_g.b(f2, this.var_int_b, this.var_int_c, ((Engine)((Object)this.var_agp_a)).var_azi_a);
                    continue block4;
                }
                Engine.a("[ERROR] Layering for non ImageGFX not supported!");
            }
        }
        for (axr axr2 : this.var_agr_a.a()) {
            axr2.b(f2, (Engine)((Object)this.var_agp_a));
        }
        if (this.var_agr_a.var_com_arenaofkings_packets_misc_ArenaName_a == ArenaName.INDOOR) {
            this.var_da_e.b(f2, (Engine)((Object)this.var_agp_a));
        }
        for (br br4 : this.var_boolean_b) {
            if (!this.u && !br4.boolean_b()) {
                br4.b(f2, (Engine)((Object)this.var_agp_a), ((agn)((Object)this.var_agp_a)).var_ayh_a, ((agn)((Object)this.var_agp_a)).b);
                br4.d(f2, (Engine)((Object)this.var_agp_a));
                br4.c(f2, (Engine)((Object)this.var_agp_a));
            }
            if (this.u || this.var_da_g == null) continue;
            this.var_da_g.a(f2, (Engine)((Object)this.var_agp_a));
            this.var_da_g.b(f2, this.var_int_b, this.var_int_c, ((Engine)((Object)this.var_agp_a)).var_azi_a);
        }
        this.var_hi_a.a(f2, (Engine)((Object)this.var_agp_a), this.var_agr_a.a(), false);
        this.var_aga_a.a(f2, (Engine)((Object)this.var_agp_a), this.var_r_a);
        for (da da3 : this.var_agr_a.c()) {
            da3.b(f2, (Engine)((Object)this.var_agp_a));
        }
        if (this.var_com_arenaofkings_packets_misc_GameType_a == GameType.TRAININGGROUND) {
            ((Engine)((Object)this.var_agp_a)).a("Exit", ((Engine)((Object)this.var_agp_a)).var_axy_f.a(), Color.WHITE, ((Engine)((Object)this.var_agp_a)).var_axy_f.a(), Color.BLACK, 1503.0f, 1200.0f, 1, 1);
        }
        ((Engine)((Object)this.var_agp_a)).var_azi_a.setShader(null);
    }

    private void e(float f2) {
        for (br br2 : ay.ay_a().ge_a().a().values()) {
            br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().az_a().a(f2);
        }
        for (br br2 : ay.ay_a().gf_a().a().values()) {
            br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().az_a().a(f2);
        }
    }

    private void f(float f2) {
        for (br br2 : ay.ay_a().ge_a().a().values()) {
            br2.b(f2, (Engine)((Object)this.var_agp_a));
        }
        for (br br2 : ay.ay_a().gf_a().a().values()) {
            br2.b(f2, (Engine)((Object)this.var_agp_a));
        }
    }

    private void g(float f2) {
        float f3;
        float f4;
        ((Engine)((Object)this.var_agp_a)).var_azi_a.setColor(Color.WHITE);
        this.a(((Engine)((Object)this.var_agp_a)).var_azi_a);
        float f5 = 960.0f;
        float f6 = 540.0f;
        if (this.var_boolean_b && (this.var_com_arenaofkings_packets_misc_GameType_a == GameType.ARENA || this.var_com_arenaofkings_packets_misc_GameType_a == GameType.BOT_GAME_1 || this.var_com_arenaofkings_packets_misc_GameType_a == GameType.BOT_GAME_2 || this.var_com_arenaofkings_packets_misc_GameType_a == GameType.BOT_GAME_3 || this.var_com_arenaofkings_packets_misc_GameType_a == GameType.BOT_GAME_4 || this.var_com_arenaofkings_packets_misc_GameType_a == GameType.BOT_GAME_5)) {
            Engine.b(this.var_boolean_b + " cinematic tick " + this.var_float_c + " " + this.var_float_e + " DELTA: " + f2);
            if (this.var_azv_b != null && this.var_azv_b.a(TimeUnit.MILLISECONDS) > 8000L) {
                this.void_b();
                this.var_r_a.position.x = MathUtils.clamp(this.var_r_a.position.x, 0.0f, this.var_agr_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getWidth());
                this.var_r_a.position.y = MathUtils.clamp(this.var_r_a.position.y, 0.0f, this.var_agr_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getHeight());
            }
            if (this.var_float_c > 650.0f) {
                this.var_float_c -= 20.0f * f2;
                if (this.var_float_c < 650.0f) {
                    this.var_float_e -= 650.0f - this.var_float_c;
                }
                if (this.var_float_e < 650.0f) {
                    f4 = 650.0f - this.var_float_e;
                    this.var_long_b = (long)(f4 / 20.0f * 1000.0f);
                }
                this.var_r_a.position.x = MathUtils.clamp(this.var_float_b, f5, this.var_agr_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getWidth() - f5);
                this.var_r_a.position.y = MathUtils.clamp(this.var_float_c, f6, this.var_agr_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getHeight() - f6);
            } else if (this.var_float_e > 650.0f) {
                this.var_float_e -= 20.0f * f2;
                this.var_r_a.position.x = MathUtils.clamp(this.var_float_d, f5, this.var_agr_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getWidth() - f5);
                this.var_r_a.position.y = MathUtils.clamp(this.var_float_e, f6, this.var_agr_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getHeight() - f6);
            } else {
                this.var_boolean_b = false;
                f4 = ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX();
                f3 = ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY();
                this.var_r_a.position.x = MathUtils.clamp(f4, f5, this.var_agr_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getWidth() - f5);
                this.var_r_a.position.y = MathUtils.clamp(f3, f6, this.var_agr_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getHeight() - f6);
                this.var_boolean_f = true;
            }
        } else if (!ay.ay_a().gd_a().boolean_b()) {
            this.var_r_a.position.x = MathUtils.clamp(this.var_r_a.position.x, f5, this.var_agr_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getWidth() - f5);
            this.var_r_a.position.y = MathUtils.clamp(this.var_r_a.position.y, f6, this.var_agr_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getHeight() - f6);
        } else {
            this.var_r_a.position.x = MathUtils.clamp(this.var_r_a.position.x, 0.0f, this.var_agr_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getWidth());
            this.var_r_a.position.y = MathUtils.clamp(this.var_r_a.position.y, 0.0f, this.var_agr_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getHeight());
        }
        if (this.A) {
            f4 = ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX();
            f3 = ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY();
            this.var_r_a.position.x = MathUtils.clamp(f4, f5, this.var_agr_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getWidth() - f5);
            this.var_r_a.position.y = MathUtils.clamp(f3, f6, this.var_agr_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getHeight() - f6);
        }
        this.var_r_a.zoom = MathUtils.clamp(this.var_r_a.zoom, 0.01f, 1.0f);
        this.var_r_a.update();
        ((Engine)((Object)this.var_agp_a)).var_azi_a.setProjectionMatrix(this.var_r_a.combined);
        ((Engine)((Object)this.var_agp_a)).var_com_badlogic_gdx_math_Vector3_b.set(Gdx.input.getX(), Gdx.graphics.getHeight() - (Gdx.graphics.getHeight() - Gdx.input.getY()), 0.0f);
        ((Engine)((Object)this.var_agp_a)).var_com_badlogic_gdx_math_Vector3_b = this.var_r_a.unproject(((Engine)((Object)this.var_agp_a)).var_com_badlogic_gdx_math_Vector3_b);
        ((Engine)((Object)this.var_agp_a)).var_azi_a.begin();
        if (((Engine)((Object)this.var_agp_a)).boolean_a() && !((Engine)((Object)this.var_agp_a)).var_azi_a.isDrawing()) {
            ((Engine)((Object)this.var_agp_a)).var_azi_a.begin();
        }
        if (!this.u) {
            for (InputProcessor inputProcessor : this.var_com_badlogic_gdx_InputMultiplexer_a.getProcessors()) {
                if (!(inputProcessor instanceof aik)) continue;
                ((aik)inputProcessor).a();
            }
            if (!this.u) {
                this.a(f2);
            }
            if (ay.ay_a().gd_a().boolean_b()) {
                if (Gdx.input.isKeyPressed(((Engine)((Object)this.var_agp_a)).var_agc_a.a().get(InputIdentifier.MOVE_NORTH).int_a())) {
                    this.var_r_a.position.y = MathUtils.clamp(this.var_r_a.position.y + 350.0f * Gdx.graphics.getDeltaTime(), f6, this.var_agr_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getHeight() - f6);
                }
                if (Gdx.input.isKeyPressed(((Engine)((Object)this.var_agp_a)).var_agc_a.a().get(InputIdentifier.MOVE_SOUTH).int_a())) {
                    this.var_r_a.position.y = MathUtils.clamp(this.var_r_a.position.y - 350.0f * Gdx.graphics.getDeltaTime(), f6, this.var_agr_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getHeight() - f6);
                }
                if (Gdx.input.isKeyPressed(((Engine)((Object)this.var_agp_a)).var_agc_a.a().get(InputIdentifier.MOVE_EAST).int_a())) {
                    this.var_r_a.position.x = MathUtils.clamp(this.var_r_a.position.x + 400.0f * Gdx.graphics.getDeltaTime(), f5, this.var_agr_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getWidth() - f5);
                }
                if (Gdx.input.isKeyPressed(((Engine)((Object)this.var_agp_a)).var_agc_a.a().get(InputIdentifier.MOVE_WEST).int_a())) {
                    this.var_r_a.position.x = MathUtils.clamp(this.var_r_a.position.x - 400.0f * Gdx.graphics.getDeltaTime(), f5, this.var_agr_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getWidth() - f5);
                }
            }
            int n2 = ay.ay_a().ge_a().a().values().size();
            for (Object object : ay.ay_a().ge_a().a().values()) {
                if (!((br)object).com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().boolean_a()) {
                    --n2;
                }
                ((br)object).com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_EffectManager_a().removeExpiredEffects();
            }
            int n3 = ay.ay_a().gf_a().a().values().size();
            for (br br2 : ay.ay_a().gf_a().a().values()) {
                if (!br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().boolean_a()) {
                    --n3;
                }
                br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_EffectManager_a().removeExpiredEffects();
            }
            if (!this.l) {
                if (n2 == 0) {
                    this.l = true;
                    ((Engine)((Object)this.var_agp_a)).var_baa_a.a(ajw.kY, 0.25f);
                    ((Engine)((Object)this.var_agp_a)).var_baa_a.a(ajw.kW, 0.25f);
                } else if (n3 == 0) {
                    this.l = true;
                    ((Engine)((Object)this.var_agp_a)).var_baa_a.a(ajw.kY, 0.25f);
                    ((Engine)((Object)this.var_agp_a)).var_baa_a.a(ajw.kX, 0.25f);
                }
            }
            this.h();
            this.i();
            this.var_agr_a.a(f2, (Engine)((Object)this.var_agp_a));
            if (this.var_azv_i.boolean_b()) {
                this.var_azv_i.void_c();
                Collections.sort(this.var_boolean_b);
            }
            for (br br2 : this.var_boolean_b) {
                br2.void_b();
                if (br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().gz_a().ui_a() == null || br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().gz_a().ui_a().hd_a().boolean_a()) continue;
                br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().gz_a().ui_a().hd_a().b((axm)((Object)this.var_agp_a));
            }
            this.var_hi_a.a(f2, (Engine)((Object)this.var_agp_a), (axm)((Object)this.var_agp_a));
        }
    }

    private void h() {
        if (ay.ay_a().boolean_c()) {
            if (this.var_azv_d.boolean_b()) {
                this.var_boolean_i = false;
                if (!ay.ay_a().d()) {
                    ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bb_a().d(cw.a(cw.e, this.var_com_arenaofkings_packets_gameserver_data_Direction_a));
                }
            }
            if (!this.var_boolean_i) {
                this.var_boolean_i = true;
                this.j = MathUtils.random.nextBoolean();
                this.var_azv_d = new azv(MathUtils.random(750), true);
                this.var_com_arenaofkings_packets_gameserver_data_Direction_a = Direction.randomDirection();
            }
            if (this.var_azv_d.boolean_a() && !ay.ay_a().d() && !this.j) {
                ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bb_a().a(cw.a(cw.e, this.var_com_arenaofkings_packets_gameserver_data_Direction_a), true);
            }
        } else if (this.var_boolean_i) {
            this.var_boolean_i = false;
            ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bb_a().d(cw.a(cw.e, this.var_com_arenaofkings_packets_gameserver_data_Direction_a));
            this.var_azv_d = new azv(0L, false);
        }
    }

    private void i() {
        if (ay.ay_a().d()) {
            if (!this.k) {
                this.k = true;
                this.var_com_arenaofkings_packets_gameserver_data_Direction_b = Direction.randomDirection();
            }
            ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bb_a().a(cw.a(cw.e, this.var_com_arenaofkings_packets_gameserver_data_Direction_b), true);
        } else if (this.k) {
            this.k = false;
            ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bb_a().d(cw.a(cw.e, this.var_com_arenaofkings_packets_gameserver_data_Direction_b));
            this.var_com_arenaofkings_packets_gameserver_data_Direction_b = null;
        }
    }

    private void h(float f2) {
        this.var_hi_a.a(f2, ((Engine)((Object)this.var_agp_a)).var_azi_a);
        for (br br2 : this.var_boolean_b) {
            if (ay.ay_a().boolean_a() && ay.ay_a().boolean_a(br2)) {
                br2.a(f2, (Engine)((Object)this.var_agp_a), ((agn)((Object)this.var_agp_a)).ayh_a(), ((agn)((Object)this.var_agp_a)).ayh_b());
                continue;
            }
            if (ay.ay_a().boolean_a()) continue;
            br2.a(f2, (Engine)((Object)this.var_agp_a), ((agn)((Object)this.var_agp_a)).ayh_a(), ((agn)((Object)this.var_agp_a)).ayh_b());
        }
        if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getID() != -1 && ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().ui_a() != null) {
            float f3 = ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().ui_a().hf_a().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX();
            float f4 = ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().ui_a().hf_a().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY();
            this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(f3 - this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getWidth() / 2.0f - 70.0f, f4 + 116.0f - 57.0f);
            this.var_ayh_b.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(f3 - this.var_ayh_b.com_badlogic_gdx_graphics_g2d_Sprite_a().getWidth() / 2.0f + 70.0f, f4 + 116.0f - 57.0f);
            if (!ay.ay_a().boolean_a()) {
                this.var_ayh_a.b(f2, (Engine)((Object)this.var_agp_a));
                this.var_ayh_b.b(f2, (Engine)((Object)this.var_agp_a));
            }
        }
    }

    private void a(float f2, Engine engine) {
        for (br br2 : ay.ay_a().ge_a().a().values()) {
            br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().aih_a().a(f2, engine);
        }
        for (br br2 : ay.ay_a().gf_a().a().values()) {
            br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().aih_a().a(f2, engine);
        }
    }

    private void i(float f2) {
        block54: {
            block55: {
                block53: {
                    this.var_com_badlogic_gdx_math_Matrix4_a = this.var_r_a.combined.cpy();
                    this.var_com_badlogic_gdx_math_Matrix4_a.setToOrtho2D(0.0f, 0.0f, 1920.0f, 1080.0f);
                    ((Engine)((Object)this.var_agp_a)).var_azi_a.setProjectionMatrix(this.var_com_badlogic_gdx_math_Matrix4_a);
                    ((Engine)((Object)this.var_agp_a)).var_azi_a.c(f2, (Array<axr>)((Object)this.var_agp_a));
                    ((Engine)((Object)this.var_agp_a)).var_azi_a.b(f2, (Array<axr>)((Object)this.var_agp_a));
                    ((agn)((Object)this.var_agp_a)).var_ahn_a.b(f2, (Engine)((Object)this.var_agp_a));
                    ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_EffectManager_a().renderIcons(f2, (Engine)((Object)this.var_agp_a));
                    if (this.var_com_arenaofkings_packets_misc_GameType_a != GameType.TRAININGGROUND) break block53;
                    this.b(f2);
                    break block54;
                }
                if (this.var_com_arenaofkings_packets_misc_GameType_a != GameType.TUTORIAL_DPS) break block55;
                if (this.C) {
                    this.a("Objectives:\n -Defeat the opposing team.\n -Pick up the Items they drop (left click Loot Bags).\n -(Optional) Open your Inventory (I) to view Items. Note: you can only change Items in the Lobby.", 1580, 935, 300);
                    this.a("[RARITY_LEGENDARY]Objectives:[]\n -Defeat the opposing team!\n\n -[RARITY_LEGENDARY]Loot[] the Items they drop ([GREEN]left click[]).\n\n -Open your [GREEN]Inventory[] ([GREEN]I[]) to view Items.\n  [GRAY]You can only change gear in the Lobby.[]", 1580, 935);
                }
                switch (this.var_com_arenaofkings_packets_misc_TutorialStage_a) {
                    case tutorialGreeting1_WELCOME: {
                        if (this.var_azv_f.boolean_b()) {
                            this.var_azv_f.void_c();
                            this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a.setVisible(true);
                            break;
                        }
                        break block54;
                    }
                    case tutorialGreeting_CLASS_INTRO: {
                        this.z = false;
                        if (this.var_azv_f.boolean_b()) {
                            this.var_azv_f.void_c();
                            this.z = true;
                        }
                        if (this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_b != null && this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_b.isVisible()) break;
                        Object object = new Label.LabelStyle(((Engine)((Object)this.var_agp_a)).j, Color.WHITE);
                        Object object22 = new TextButton.TextButtonStyle();
                        ((TextButton.TextButtonStyle)object22).font = ((Engine)((Object)this.var_agp_a)).l;
                        ((TextButton.TextButtonStyle)object22).fontColor = axe.K;
                        this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_b = new agf(this, "", ((Engine)((Object)this.var_agp_a)).var_com_badlogic_gdx_scenes_scene2d_ui_Skin_a, (Label.LabelStyle)object);
                        this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_b.align(1);
                        this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_b.setBounds(646.0f, 450.0f, 625.0f, 350.0f);
                        if (!((aya)((Object)this.var_agp_a)).var_com_badlogic_gdx_scenes_scene2d_Stage_a.getActors().contains(this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_b, true)) {
                            ((aya)((Object)this.var_agp_a)).var_com_badlogic_gdx_scenes_scene2d_Stage_a.addActor(this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_b);
                            Engine.b("added dialog");
                            break;
                        }
                        Engine.b("didn't add dialog");
                        break;
                    }
                    case tutorialGreeting2_MOVE: {
                        this.z = false;
                        if (this.var_azv_f.boolean_b()) {
                            this.var_azv_f.void_c();
                            this.z = true;
                        }
                        if (this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_c != null && this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_c.isVisible()) break;
                        Object object = new Label.LabelStyle(((Engine)((Object)this.var_agp_a)).j, Color.WHITE);
                        Object object22 = new TextButton.TextButtonStyle();
                        ((TextButton.TextButtonStyle)object22).font = ((Engine)((Object)this.var_agp_a)).l;
                        ((TextButton.TextButtonStyle)object22).fontColor = axe.K;
                        this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_c = new agg(this, "", ((Engine)((Object)this.var_agp_a)).var_com_badlogic_gdx_scenes_scene2d_ui_Skin_a, (Label.LabelStyle)object);
                        this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_c.align(1);
                        this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_c.setBounds(750.0f, 450.0f, 450.0f, 205.0f);
                        if (!((aya)((Object)this.var_agp_a)).var_com_badlogic_gdx_scenes_scene2d_Stage_a.getActors().contains(this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_c, true)) {
                            ((aya)((Object)this.var_agp_a)).var_com_badlogic_gdx_scenes_scene2d_Stage_a.addActor(this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_c);
                            Engine.b("added dialog");
                        } else {
                            Engine.b("didn't add dialog");
                        }
                    }
                    case tutorialGreeting3_SPELLS: {
                        Object object22;
                        Object object;
                        this.z = false;
                        if (this.var_azv_f.boolean_b()) {
                            this.var_azv_f.void_c();
                            this.z = true;
                        }
                        if (this.var_azv_e.boolean_b() && this.o || this.z) {
                            if (this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_d != null && this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_d.isVisible()) break;
                            object = new Label.LabelStyle(((Engine)((Object)this.var_agp_a)).j, Color.WHITE);
                            object22 = new TextButton.TextButtonStyle();
                            ((TextButton.TextButtonStyle)object22).font = ((Engine)((Object)this.var_agp_a)).l;
                            ((TextButton.TextButtonStyle)object22).fontColor = axe.K;
                            this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_d = new agh(this, "", ((Engine)((Object)this.var_agp_a)).var_com_badlogic_gdx_scenes_scene2d_ui_Skin_a, (Label.LabelStyle)object);
                            this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_d.align(1);
                            this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_d.setBounds(725.0f, 450.0f, 500.0f, 325.0f);
                            this.B = true;
                            if (!((aya)((Object)this.var_agp_a)).var_com_badlogic_gdx_scenes_scene2d_Stage_a.getActors().contains(this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_d, true)) {
                                ((aya)((Object)this.var_agp_a)).var_com_badlogic_gdx_scenes_scene2d_Stage_a.addActor(this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_d);
                                Engine.b("added dialog");
                                break;
                            }
                            Engine.b("didn't add dialog");
                            break;
                        }
                        break block54;
                    }
                    case tutorialGreeting4_TARGETING: {
                        Object object22;
                        Object object;
                        this.z = false;
                        if (this.var_azv_f.boolean_b()) {
                            this.var_azv_f.void_c();
                            this.z = true;
                        }
                        if (this.var_azv_e.boolean_b() && this.o || this.z) {
                            if (this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_e != null && this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_e.isVisible()) break;
                            for (Object object22 : ay.ay_a().gf_a().a().values()) {
                                if (object22 == ay.ay_a()) continue;
                                ((br)object22).com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().b(false);
                            }
                            for (Object object22 : ay.ay_a().ge_a().a().values()) {
                                ((br)object22).com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().b(false);
                            }
                            this.var_azv_e.d();
                            this.var_azv_f.void_c();
                            object = new Label.LabelStyle(((Engine)((Object)this.var_agp_a)).j, Color.WHITE);
                            object22 = new TextButton.TextButtonStyle();
                            ((TextButton.TextButtonStyle)object22).font = ((Engine)((Object)this.var_agp_a)).l;
                            ((TextButton.TextButtonStyle)object22).fontColor = axe.K;
                            this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_e = new agi(this, "", ((Engine)((Object)this.var_agp_a)).var_com_badlogic_gdx_scenes_scene2d_ui_Skin_a, (Label.LabelStyle)object);
                            this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_e.align(1);
                            this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_e.setBounds(725.0f, 450.0f, 500.0f, 275.0f);
                            if (!((aya)((Object)this.var_agp_a)).var_com_badlogic_gdx_scenes_scene2d_Stage_a.getActors().contains(this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_e, true)) {
                                ((aya)((Object)this.var_agp_a)).var_com_badlogic_gdx_scenes_scene2d_Stage_a.addActor(this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_e);
                                Engine.b("added dialog");
                                break;
                            }
                            Engine.b("didn't add dialog");
                            break;
                        }
                        break block54;
                    }
                    case tutorialGreeting5_USE_ABILITY: {
                        Object object22;
                        Object object;
                        this.z = false;
                        if (this.var_azv_f.boolean_b()) {
                            this.var_azv_f.void_c();
                            this.z = true;
                        }
                        if (this.var_azv_e.boolean_b() || this.z) {
                            if (this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_f != null && this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_f.isVisible()) break;
                            this.var_azv_e.d();
                            this.var_azv_f.void_c();
                            object = new Label.LabelStyle(((Engine)((Object)this.var_agp_a)).j, Color.WHITE);
                            object22 = new TextButton.TextButtonStyle();
                            ((TextButton.TextButtonStyle)object22).font = ((Engine)((Object)this.var_agp_a)).l;
                            ((TextButton.TextButtonStyle)object22).fontColor = axe.K;
                            this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_f = new agj(this, "", ((Engine)((Object)this.var_agp_a)).var_com_badlogic_gdx_scenes_scene2d_ui_Skin_a, (Label.LabelStyle)object);
                            this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_f.align(1);
                            this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_f.setBounds(725.0f, 450.0f, 500.0f, 275.0f);
                            if (!((aya)((Object)this.var_agp_a)).var_com_badlogic_gdx_scenes_scene2d_Stage_a.getActors().contains(this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_f, true)) {
                                ((aya)((Object)this.var_agp_a)).var_com_badlogic_gdx_scenes_scene2d_Stage_a.addActor(this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_f);
                                Engine.b("added dialog");
                                break;
                            }
                            Engine.b("didn't add dialog");
                            break;
                        }
                        break block54;
                    }
                    case BASIC_ATTACK_7: {
                        break;
                    }
                    case DONE: {
                        break;
                    }
                    case KILL_DUMMY: {
                        break;
                    }
                    case TARGET_ENEMY_6: {
                        break;
                    }
                    case WALK_TO_PORTAL_4: {
                        break;
                    }
                    case WALK_TO_PORTAL_5: {
                        break;
                    }
                }
                break block54;
            }
            if (this.var_com_arenaofkings_packets_misc_GameType_a == GameType.TUTORIAL_HEALER) {
                this.b(f2);
            } else {
                this.c(f2);
            }
        }
        if (this.var_ajt_a.boolean_a()) {
            System.out.println("Scoreboard has data");
            if (this.var_azv_g.a(TimeUnit.MILLISECONDS) >= 666L) {
                ((Engine)((Object)this.var_agp_a)).a("Game is ending.", ((Engine)((Object)this.var_agp_a)).var_axy_f.a(), axe.y, ((Engine)((Object)this.var_agp_a)).var_axy_f.a(), Color.BLACK, 955.0f, 1006.0f, 1, 1);
            } else if (this.var_azv_g.a(TimeUnit.MILLISECONDS) >= 333L) {
                ((Engine)((Object)this.var_agp_a)).a("Game is ending..", ((Engine)((Object)this.var_agp_a)).var_axy_f.a(), axe.y, ((Engine)((Object)this.var_agp_a)).var_axy_f.a(), Color.BLACK, 955.0f, 1006.0f, 1, 1);
            }
            if (this.var_com_arenaofkings_packets_misc_GameType_a == GameType.TUTORIAL_DPS || this.var_com_arenaofkings_packets_misc_GameType_a == GameType.TUTORIAL_HEALER) {
                ((Engine)((Object)this.var_agp_a)).a("You've completed the Tutorial! Now loading the Lobby ...", ((Engine)((Object)this.var_agp_a)).var_axy_f.a(), axe.y, ((Engine)((Object)this.var_agp_a)).var_axy_f.a(), Color.BLACK, 955.0f, 1006.0f, 1, 1);
            } else if (this.var_com_arenaofkings_packets_misc_GameType_a == GameType.TRAININGGROUND) {
                ((Engine)((Object)this.var_agp_a)).a("Exiting the Training Ground shortly ...", ((Engine)((Object)this.var_agp_a)).var_axy_f.a(), axe.y, ((Engine)((Object)this.var_agp_a)).var_axy_f.a(), Color.BLACK, 955.0f, 1006.0f, 1, 1);
            } else if (this.var_com_arenaofkings_packets_misc_GameType_a == GameType.DARK_BOSS_BATTLE) {
                ((Engine)((Object)this.var_agp_a)).a("Exiting the Vexathras' Domain shortly ...", ((Engine)((Object)this.var_agp_a)).var_axy_f.a(), axe.y, ((Engine)((Object)this.var_agp_a)).var_axy_f.a(), Color.BLACK, 955.0f, 1006.0f, 1, 1);
            } else if (this.var_com_arenaofkings_packets_misc_GameType_a == GameType.ARENA) {
                ((Engine)((Object)this.var_agp_a)).a("Game is ending ...", ((Engine)((Object)this.var_agp_a)).var_axy_f.a(), axe.y, ((Engine)((Object)this.var_agp_a)).var_axy_f.a(), Color.BLACK, 955.0f, 1006.0f, 1, 1);
            }
        }
        if (this.boolean_b()) {
            if (this.B) {
                for (ui ui2 : ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().gu_a().ui_arr_a()) {
                    if (ui2.hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a() == SpellName.Meditate || ui2.hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a() == SpellName.TrinketOfResolve || ui2.hd_a().da_b() == null) continue;
                    ui2.hd_a().da_b().a().setPlayMode(Animation.PlayMode.LOOP);
                    ui2.hd_a().da_b().a(0.6f, ((Engine)((Object)this.var_agp_a)).var_azi_a);
                }
            } else {
                for (ui ui2 : ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().gu_a().ui_arr_a()) {
                    if (ui2.hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a() == SpellName.Meditate || ui2.hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a() == SpellName.TrinketOfResolve || ui2.hd_a().da_b() == null) continue;
                    ui2.hd_a().da_b().a().setPlayMode(Animation.PlayMode.NORMAL);
                }
            }
        }
        this.j(f2);
        ay.ay_a().gd_a().as_a().b(f2, (Engine)((Object)this.var_agp_a));
        ay.ay_a().gd_a().as_a().d(f2, (Engine)((Object)this.var_agp_a));
        if (ay.ay_a().gd_a().as_a().boolean_a()) {
            for (am am2 : ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().a().values()) {
                if (am2 == null || am2.fh_a() == null || am2.fh_a() instanceof ff || !am2.fh_a().boolean_a()) continue;
                am2.fh_a().c(f2, (Engine)((Object)this.var_agp_a));
            }
        }
        ay.ay_a().gd_a().as_a().a((ItemSlot)null);
        for (am am3 : ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().a().values()) {
            am3.a(false);
        }
    }

    private void j(float f2) {
        if (this.var_azv_h.boolean_b()) {
            this.var_int_e = Gdx.graphics.getFramesPerSecond();
            this.var_float_h = f2;
            this.var_azv_h.d();
            this.var_azv_h.void_a();
        }
        if (this.var_int_e >= 70) {
            ((Engine)((Object)this.var_agp_a)).var_com_badlogic_gdx_graphics_g2d_BitmapFont_f.setColor(Color.GREEN);
        } else if (this.var_int_e >= 60) {
            ((Engine)((Object)this.var_agp_a)).var_com_badlogic_gdx_graphics_g2d_BitmapFont_f.setColor(Color.LIME);
        } else if (this.var_int_e >= 40) {
            ((Engine)((Object)this.var_agp_a)).var_com_badlogic_gdx_graphics_g2d_BitmapFont_f.setColor(Color.ORANGE);
        } else {
            ((Engine)((Object)this.var_agp_a)).var_com_badlogic_gdx_graphics_g2d_BitmapFont_f.setColor(Color.RED);
        }
        StringBuilder stringBuilder = new StringBuilder().append("V ");
        Objects.requireNonNull(this.var_agp_a);
        ((Engine)((Object)this.var_agp_a)).a(stringBuilder.append("2.0.0.0").toString(), ((Engine)((Object)this.var_agp_a)).var_axy_c.a(), Color.WHITE, ((Engine)((Object)this.var_agp_a)).var_axy_c.a(), Color.BLACK, 1905.0f, 115.0f, 16, 1);
        ((Engine)((Object)this.var_agp_a)).a("FPS: " + this.var_int_e, ((Engine)((Object)this.var_agp_a)).var_axy_c.a(), ((Engine)((Object)this.var_agp_a)).var_com_badlogic_gdx_graphics_g2d_BitmapFont_f.getColor(), ((Engine)((Object)this.var_agp_a)).var_axy_c.a(), Color.BLACK, 1905.0f, 95.0f, 16, 1);
    }

    @Override
    public void resize(int n2, int n3) {
        Engine.b("Resize play");
        super.resize(n2, n3);
        this.var_com_badlogic_gdx_utils_viewport_Viewport_a.update(n2, n3);
        ((aya)((Object)this.var_agp_a)).com_badlogic_gdx_scenes_scene2d_Stage_c().getViewport().update(n2, n3);
    }

    @Override
    public void resume() {
        super.resume();
    }

    @Override
    public void dispose() {
        ay.ay_a().gf_a().b((Engine)((Object)this.var_agp_a));
        ay.ay_a().gf_a().a((Engine)((Object)this.var_agp_a));
        this.var_agr_a.d();
        super.dispose();
    }

    public void void_a() {
        this.var_int_b = (int)ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX();
        this.var_int_c = (int)ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY();
        PlayerAction playerAction = cw.a(cw.c, ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().cr_a().com_arenaofkings_packets_gameserver_data_Direction_a());
        this.var_da_g = ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().cr_a().cy_a().a().get(playerAction);
        if (this.var_da_g != null) {
            this.var_da_g.a(Animation.PlayMode.NORMAL);
        }
    }

    public void a(int n2, int n3) {
        da da2 = ay.ay_a().gf_a().a().a(MathUtils.random(0, ay.ay_a().gf_a().a().size() - 1)).com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().cr_a().cy_a().a().get(cw.a(cw.c, Direction.randomEastWestDirection()));
        if (da2 != null) {
            da2.a((float)n2, n3);
            da2.a(Animation.PlayMode.NORMAL);
            this.var_agp_a.add(da2);
        }
    }

    public azv azv_a() {
        return this.var_azv_a;
    }

    public hi hi_a() {
        return this.var_hi_a;
    }

    public void a(boolean bl2) {
        if (this.var_com_arenaofkings_packets_misc_GameType_a == GameType.DARK_BOSS_BATTLE) {
            this.var_boolean_a = false;
            this.var_boolean_f = false;
            this.var_boolean_g = true;
            this.n = true;
        } else {
            this.var_azv_b = new azv(8000L, true);
            this.var_boolean_b = bl2;
            if (bl2) {
                this.var_boolean_a = false;
            }
        }
    }

    public void void_b() {
        this.A = true;
        this.var_boolean_a = false;
        this.var_boolean_b = false;
        this.var_boolean_f = false;
        this.var_boolean_h = true;
        this.var_boolean_g = true;
        if (!this.var_azv_a.boolean_a()) {
            this.var_azv_a = new azv(120000L, true);
        }
    }

    public void b(boolean bl2) {
        if (this.var_azv_a != null) {
            this.var_azv_a = new azv(120000L, true);
            this.var_long_a = System.currentTimeMillis();
        } else {
            this.var_azv_a = new azv(120000L, true);
            this.var_long_a = System.currentTimeMillis();
        }
        this.var_boolean_g = true;
    }

    public boolean boolean_a() {
        return this.A || this.var_boolean_g;
    }

    @Override
    public agn agn_a() {
        return (agn)super.aya_a();
    }

    public void a(int n2) {
        if (n2 == 1) {
            this.x = true;
        }
    }

    public void c(boolean bl2) {
        this.w = bl2;
    }

    public void d(boolean bl2) {
        this.v = bl2;
        if (this.var_azv_g.boolean_a()) {
            this.var_azv_g.void_c();
        } else {
            this.var_azv_g.void_a();
        }
    }

    public ajt ajt_a() {
        return this.var_ajt_a;
    }

    public void a(boolean bl2, ArenaName arenaName) {
        this.u = bl2;
        this.var_agr_a.a((Engine)((Object)this.var_agp_a), arenaName);
    }

    public void e(boolean bl2) {
        this.y = bl2;
    }

    public void f(boolean bl2) {
        this.o = bl2;
        if (!this.var_azv_e.boolean_a()) {
            this.var_azv_e.void_c();
        }
    }

    public void g(boolean bl2) {
        this.s = bl2;
        if (!this.var_azv_e.boolean_a()) {
            this.var_azv_e.void_c();
        }
    }

    public aga aga_a() {
        return this.var_aga_a;
    }

    public boolean boolean_b() {
        return this.var_com_arenaofkings_packets_misc_GameType_a == GameType.TUTORIAL_DPS || this.var_com_arenaofkings_packets_misc_GameType_a == GameType.TUTORIAL_HEALER;
    }

    @Override
    public agp agp_a() {
        return this.var_agp_a;
    }

    static /* synthetic */ TutorialStage a(agd agd2, TutorialStage tutorialStage) {
        agd2.var_com_arenaofkings_packets_misc_TutorialStage_a = tutorialStage;
        return agd2.var_com_arenaofkings_packets_misc_TutorialStage_a;
    }

    static /* synthetic */ TutorialStage com_arenaofkings_packets_misc_TutorialStage_a(agd agd2) {
        return agd2.var_com_arenaofkings_packets_misc_TutorialStage_a;
    }

    static /* synthetic */ azv azv_a(agd agd2) {
        return agd2.var_azv_f;
    }

    static /* synthetic */ boolean a(agd agd2, boolean bl2) {
        agd2.B = bl2;
        return agd2.B;
    }

    static /* synthetic */ boolean b(agd agd2, boolean bl2) {
        agd2.C = bl2;
        return agd2.C;
    }
}

