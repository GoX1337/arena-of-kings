/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.client.core;

import com.arenaofkings.packets.loginserver.PUB_LOGIN_EXISTING_ACCOUNT_REQUEST;
import com.arenaofkings.packets.loginserver.PUB_LOGOUT_REQUEST;
import com.arenaofkings.packets.loginserver.PUB_MISC_CHAT_MESSAGE;
import com.arenaofkings.packets.loginserver.PUB_MISC_NEWS_UPDATE;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Colors;
import com.badlogic.gdx.graphics.Cursor;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.BitmapFontCache;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonWriter;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.codedisaster.steamworks.SteamAPI;
import com.codedisaster.steamworks.SteamApps;
import com.codedisaster.steamworks.SteamFriends;
import com.codedisaster.steamworks.SteamNativeHandle;
import com.codedisaster.steamworks.SteamUser;
import com.esotericsoftware.minlog.Log;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.time.StopWatch;

public class Engine
extends l {
    public static final azm var_azm_a;
    public final String var_java_lang_String_a = "2";
    public final String var_java_lang_String_b = "0";
    public final String var_java_lang_String_c = "0";
    public final String var_java_lang_String_d = "0";
    public final String var_java_lang_String_e = "2.0.0.0";
    public or var_or_a;
    public hg var_hg_a;
    public q var_q_a;
    public z var_z_a;
    public ag var_ag_a;
    public azv var_azv_a = new azv(6000L, true);
    public String var_java_lang_String_f = "";
    private azv var_azv_b = new azv(5000L, true);
    private boolean var_boolean_c = false;
    public SteamUser var_com_codedisaster_steamworks_SteamUser_a;
    public SteamApps var_com_codedisaster_steamworks_SteamApps_a;
    public SteamFriends var_com_codedisaster_steamworks_SteamFriends_a;
    public long var_long_a;
    public List<Object> var_java_util_List_java_lang_Object__a;
    public List<PUB_MISC_CHAT_MESSAGE> var_java_util_List_com_arenaofkings_packets_loginserver_PUB_MISC_CHAT_MESSAGE__b;
    public Array<String> var_com_badlogic_gdx_utils_Array_java_lang_String__a;
    public Array<g> var_com_badlogic_gdx_utils_Array_g__b;
    public static int var_int_a;
    public agc var_agc_a;
    @Deprecated
    public u var_u_a;
    private boolean var_boolean_d;
    private axc var_axc_a;
    private axc var_axc_b;
    private boolean var_boolean_e;
    private Dialog var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a;
    private boolean var_boolean_f;
    public azi var_azi_a;
    public axf var_axf_a;
    public Skin var_com_badlogic_gdx_scenes_scene2d_ui_Skin_a;
    public Cursor var_com_badlogic_gdx_graphics_Cursor_a;
    public Cursor var_com_badlogic_gdx_graphics_Cursor_b;
    public Cursor var_com_badlogic_gdx_graphics_Cursor_c;
    public Cursor var_com_badlogic_gdx_graphics_Cursor_d;
    public boolean var_boolean_a;
    public r var_r_a;
    public Viewport var_com_badlogic_gdx_utils_viewport_Viewport_a;
    public axe var_axe_a;
    public GlyphLayout var_com_badlogic_gdx_graphics_g2d_GlyphLayout_a;
    public BitmapFont var_com_badlogic_gdx_graphics_g2d_BitmapFont_a;
    public BitmapFont var_com_badlogic_gdx_graphics_g2d_BitmapFont_b;
    public BitmapFont var_com_badlogic_gdx_graphics_g2d_BitmapFont_c;
    public BitmapFont var_com_badlogic_gdx_graphics_g2d_BitmapFont_d;
    public BitmapFont var_com_badlogic_gdx_graphics_g2d_BitmapFont_e;
    public BitmapFont var_com_badlogic_gdx_graphics_g2d_BitmapFont_f;
    public BitmapFont var_com_badlogic_gdx_graphics_g2d_BitmapFont_g;
    public BitmapFont var_com_badlogic_gdx_graphics_g2d_BitmapFont_h;
    public axy var_axy_a;
    public axy var_axy_b;
    public axy var_axy_c;
    public axy var_axy_d;
    public axy var_axy_e;
    public BitmapFont var_com_badlogic_gdx_graphics_g2d_BitmapFont_i;
    public BitmapFont j;
    public BitmapFont k;
    public BitmapFont l;
    public BitmapFont m;
    public BitmapFont n;
    public BitmapFont o;
    public BitmapFont p;
    public BitmapFont q;
    private BitmapFontCache var_com_badlogic_gdx_graphics_g2d_BitmapFontCache_a;
    public int var_int_b;
    public BitmapFont r;
    public axy var_axy_f;
    public BitmapFont s;
    public axy var_axy_g;
    public Label.LabelStyle var_com_badlogic_gdx_scenes_scene2d_ui_Label$LabelStyle_a;
    public BitmapFont t;
    public BitmapFont u;
    public BitmapFont v;
    public BitmapFont w;
    public BitmapFont x;
    public BitmapFont y;
    public BitmapFont z;
    public Vector3 var_com_badlogic_gdx_math_Vector3_a;
    public Vector3 var_com_badlogic_gdx_math_Vector3_b;
    @Deprecated
    private Array<Class<? extends axc>> var_com_badlogic_gdx_utils_Array_java_lang_Class___extends_axc___c;
    private Array<azj> var_com_badlogic_gdx_utils_Array_azj__d;
    private azv var_azv_c;
    private Json var_com_badlogic_gdx_utils_Json_a;
    public final AssetManager var_com_badlogic_gdx_assets_AssetManager_a;
    public final baa var_baa_a;
    private int var_int_c;
    private int var_int_d;
    public Color var_com_badlogic_gdx_graphics_Color_a;
    public boolean var_boolean_b;
    private String var_java_lang_String_g;
    private boolean var_boolean_g;
    private String var_java_lang_String_h;
    private int var_int_e;
    private azv var_azv_d;
    private ArrayList<ajw> var_java_util_ArrayList_ajw__a;
    public aj var_aj_a;
    private azv var_azv_e;
    private boolean var_boolean_h;
    private boolean var_boolean_i;
    public PUB_LOGIN_EXISTING_ACCOUNT_REQUEST var_com_arenaofkings_packets_loginserver_PUB_LOGIN_EXISTING_ACCOUNT_REQUEST_a;

    public Engine(aj aj2) {
        this.var_azm_a = new ArrayList();
        this.var_java_lang_String_b = new ArrayList();
        this.var_azm_a = new Array();
        this.var_u_a = new u();
        this.var_boolean_d = true;
        this.var_axc_a = null;
        this.var_axc_b = null;
        this.var_boolean_e = false;
        this.var_boolean_f = false;
        this.var_boolean_a = false;
        this.var_int_b = 0;
        this.var_com_badlogic_gdx_math_Vector3_b = new Vector3(0.0f, 0.0f, 0.0f);
        this.var_java_lang_String_c = new Array();
        this.var_java_lang_String_d = new Array();
        this.var_azv_c = new azv(2000L, true);
        this.var_com_badlogic_gdx_utils_Json_a = new Json();
        this.var_java_lang_String_g = "";
        this.var_boolean_g = false;
        this.var_java_lang_String_h = "";
        this.var_int_e = 0;
        this.var_azv_d = new azv(1000L, true);
        this.var_azv_e = new azv(3000L, true);
        this.var_boolean_i = false;
        System.out.println("RATING 1500: " + axp.a(1500));
        System.out.println("RATING 2000: " + axp.a(2000));
        System.out.println("RATING 2400: " + axp.a(2400));
        System.out.println("RATING 3000: " + axp.a(3000));
        this.var_aj_a = aj2;
        this.var_q_a = new q();
        Log.set(5);
        Thread.setDefaultUncaughtExceptionHandler(new n(this));
        Engine.b("  \\ \\    / (_) | |     (_)        / ____|                           \n   \\ \\  / / _| | | __ _ _ _ __   | |  __  __ _ _ __ ___   ___  ___  \n    \\ \\/ / | | | |/ _` | | '_ \\  | | |_ |/ _` | '_ ` _ \\ / _ \\/ __| \n     \\  /  | | | | (_| | | | | | | |__| | (_| | | | | | |  __/\\__ \\ \n      \\/   |_|_|_|\\__,_|_|_| |_|  \\_____|\\__,_|_| |_| |_|\\___||___/ \n                                                                    \n                                                                    \n     /\\                                 / _| | |/ (_)                \n    /  \\   _ __ ___ _ __   __ _    ___ | |_  | ' / _ _ __   __ _ ___ \n   / /\\ \\ | '__/ _ \\ '_ \\ / _` |  / _ \\|  _| |  < | | '_ \\ / _` / __|\n  / ____ \\| | |  __/ | | | (_| | | (_) | |   | . \\| | | | | (_| \\__ \\\n /_/    \\_\\_|  \\___|_| |_|\\__,_|  \\___/|_|   |_|\\_\\_|_| |_|\\__, |___/\n                                                            __/ |    \n                                                           |___/     \n");
        this.var_com_badlogic_gdx_assets_AssetManager_a = new AssetManager();
        this.var_com_badlogic_gdx_assets_AssetManager_a.getLogger().setLevel(3);
        this.var_baa_a = new baa(this.var_com_badlogic_gdx_assets_AssetManager_a);
    }

    @Override
    public void create() {
        int n2;
        int n3;
        this.var_java_lang_String_g = "Arena of Kings";
        this.var_int_d = Gdx.graphics.getWidth();
        this.var_int_c = Gdx.graphics.getHeight();
        this.var_com_badlogic_gdx_utils_Json_a.setOutputType(JsonWriter.OutputType.json);
        Colors.put("BY", axe.A);
        Colors.put("G", axe.F);
        Colors.put("AOK_NAMEPLATE_GOLD", axe.F);
        this.var_java_lang_String_b = new ArrayList(var_int_a);
        for (int i2 = 0; i2 < var_int_a; ++i2) {
            this.var_java_lang_String_b.add(new PUB_MISC_CHAT_MESSAGE());
        }
        x.a(v.b);
        this.var_z_a = new z(this);
        this.var_ag_a = new ag(this);
        this.var_or_a = new or(this);
        this.var_hg_a = new hg(this);
        this.var_r_a = new r(1920.0f, 1080.0f);
        this.var_r_a.position.set(this.var_r_a.viewportWidth / 2.0f, this.var_r_a.viewportHeight / 2.0f, 0.0f);
        this.var_r_a.update();
        this.var_com_badlogic_gdx_math_Vector3_a = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0.0f);
        this.var_com_badlogic_gdx_math_Vector3_a = this.var_r_a.unproject(this.var_com_badlogic_gdx_math_Vector3_a);
        this.var_azi_a = new azi(this);
        this.var_axf_a = new axf();
        this.var_axf_a.setProjectionMatrix(this.var_r_a.combined);
        this.var_axf_a.setAutoShapeType(true);
        this.var_axf_a.setColor(0.0f, 0.0f, 0.0f, 0.8f);
        this.var_com_badlogic_gdx_assets_AssetManager_a.setLoader(TiledMap.class, new TmxMapLoader(new InternalFileHandleResolver()));
        this.var_com_badlogic_gdx_assets_AssetManager_a.update();
        this.var_u_a.setLoader(TiledMap.class, new TmxMapLoader(new InternalFileHandleResolver()));
        System.out.println("Load fonts");
        this.var_axe_a = new axe();
        this.var_com_badlogic_gdx_graphics_g2d_GlyphLayout_a = new GlyphLayout();
        this.var_com_badlogic_gdx_graphics_g2d_BitmapFont_a = new BitmapFont(Gdx.files.internal("misc/fonts/pt-sans-caption-bold-16a.fnt"));
        this.var_com_badlogic_gdx_graphics_g2d_BitmapFont_a.setColor(Color.RED);
        this.var_com_badlogic_gdx_graphics_g2d_BitmapFont_b = new BitmapFont(Gdx.files.internal("misc/fonts/pt-sans-caption-bold-16a.fnt"));
        this.var_com_badlogic_gdx_graphics_g2d_BitmapFont_b.setColor(0.28627452f, 0.49411765f, 0.8392157f, 1.0f);
        this.var_com_badlogic_gdx_graphics_g2d_BitmapFont_c = new BitmapFont(Gdx.files.internal("misc/fonts/pt-sans-caption-bold-16a.fnt"));
        this.var_com_badlogic_gdx_graphics_g2d_BitmapFont_c.setColor(0.24705882f, 0.627451f, 0.0627451f, 1.0f);
        this.var_com_badlogic_gdx_graphics_g2d_BitmapFont_d = new BitmapFont(Gdx.files.internal("misc/fonts/pt-sans-caption-bold-16a.fnt"));
        this.var_com_badlogic_gdx_graphics_g2d_BitmapFont_d.setColor(Color.WHITE);
        this.var_com_badlogic_gdx_graphics_g2d_BitmapFont_e = new BitmapFont(Gdx.files.internal("misc/fonts/pt-sans-caption-bold-16a.fnt"));
        this.var_com_badlogic_gdx_graphics_g2d_BitmapFont_e.setColor(1.0f, 1.0f, 1.0f, 1.0f);
        this.var_com_badlogic_gdx_graphics_g2d_BitmapFont_h = new BitmapFont(Gdx.files.internal("misc/fonts/pt-sans-caption-bold-16a.fnt"));
        this.var_com_badlogic_gdx_graphics_g2d_BitmapFont_h.setColor(0.64705884f, 0.48235294f, 0.29803923f, 1.0f);
        Colors.put("DIGICERT", new Color(0.003921569f, 0.45490196f, 0.76862746f, 1.0f));
        Colors.put("TWITCH", new Color(0.39215687f, 0.25490198f, 0.6431373f, 1.0f));
        Colors.put("YOUTUBE", new Color(1.0f, 0.0f, 0.0f, 1.0f));
        Colors.put("ATTRIBUTE_GOLD", new Color(1.0f, 0.81960785f, 0.0f, 1.0f));
        Colors.put("ATTRIBUTE_GREEN", new Color(0.12156863f, 1.0f, 0.11764706f, 1.0f));
        Colors.put("RARITY_POOR_FADED", new Color(0.6156863f, 0.6156863f, 0.6156863f, 0.1f));
        Colors.put("RARITY_COMMON_FADED", new Color(1.0f, 1.0f, 1.0f, 0.1f));
        Colors.put("RARITY_UNCOMMON_FADED", new Color(0.11764706f, 1.0f, 0.0f, 0.1f));
        Colors.put("RARITY_RARE_FADED", new Color(0.0f, 0.4392157f, 0.8666667f, 0.1f));
        Colors.put("RARITY_EPIC_FADED", new Color(0.6392157f, 0.20784314f, 0.93333334f, 0.1f));
        Colors.put("RARITY_LEGENDARY_FADED", new Color(1.0f, 0.5019608f, 0.0f, 0.1f));
        Colors.put("RARITY_ANCIENT_FADED", new Color(0.4862745f, 0.039215688f, 0.03137255f, 0.1f));
        Colors.put("RARITY_POOR", new Color(0.6156863f, 0.6156863f, 0.6156863f, 1.0f));
        Colors.put("RARITY_COMMON", new Color(1.0f, 1.0f, 1.0f, 1.0f));
        Colors.put("RARITY_UNCOMMON", new Color(0.11764706f, 1.0f, 0.0f, 1.0f));
        Colors.put("RARITY_RARE", new Color(0.0f, 0.4392157f, 0.8666667f, 1.0f));
        Colors.put("RARITY_EPIC", new Color(0.6392157f, 0.20784314f, 0.93333334f, 1.0f));
        Colors.put("RARITY_LEGENDARY", new Color(1.0f, 0.5019608f, 0.0f, 1.0f));
        Colors.put("RARITY_UNIQUE", new Color(0.87058824f, 0.77254903f, 0.4862745f, 1.0f));
        Colors.put("RARITY_ANCIENT", new Color(0.4862745f, 0.039215688f, 0.03137255f, 1.0f));
        Colors.put("RARITY_CORRUPTED", new Color(0.7490196f, 0.050980393f, 0.0f, 1.0f));
        Colors.put("PARCHMENT", new Color(0.64705884f, 0.48235294f, 0.29803923f, 1.0f));
        Colors.put("CLASS_COLOR_ASSASSIN", new Color(1.0f, 0.5764706f, 0.0f, 1.0f));
        Colors.put("CLASS_COLOR_CHAMPION", new Color(1.0f, 0.0f, 0.0f, 1.0f));
        Colors.put("CLASS_COLOR_ELDER", new Color(0.19607843f, 0.8039216f, 0.28627452f, 1.0f));
        Colors.put("CLASS_COLOR_LICH", new Color(0.38039216f, 0.019607844f, 0.98039216f, 1.0f));
        Colors.put("CLASS_COLOR_MYSTIC", new Color(0.91764706f, 0.89411765f, 0.08235294f, 1.0f));
        Colors.put("CLASS_COLOR_NIHILIST", new Color(0.42352942f, 0.4117647f, 0.5882353f, 1.0f));
        Colors.put("CLASS_COLOR_PALADIN", new Color(0.0f, 0.6509804f, 1.0f, 1.0f));
        Colors.put("CLASS_COLOR_RANGER", new Color(0.5882353f, 0.9372549f, 0.0627451f, 1.0f));
        Colors.put("CLASS_COLOR_SCHOLAR", new Color(0.9372549f, 0.89411765f, 0.6901961f, 1.0f));
        Colors.put("CLASS_COLOR_WIZARD", new Color(0.007843138f, 0.38039216f, 0.99215686f, 1.0f));
        Colors.put("AOK_BLUE", new Color(0.28627452f, 0.49411765f, 0.8392157f, 1.0f));
        Colors.put("ABILITY_HIT", new Color(0.9882353f, 0.8745098f, 0.17254902f, 1.0f));
        Colors.put("ABILITY_HIT_FADED", new Color(0.9882353f, 0.8745098f, 0.17254902f, 0.6f));
        Colors.put("RED_FADED", new Color(1.0f, 0.0f, 0.0f, 0.6f));
        Colors.put("RED", new Color(1.0f, 0.0f, 0.0f, 1.0f));
        Colors.put("ERROR", new Color(1.0f, 0.0f, 0.0f, 1.0f));
        Colors.put("SUCCESS", new Color(1.0f, 1.0f, 1.0f, 1.0f));
        Colors.put("AOK_ROYAL_GOLD", new Color(0.7921569f, 0.6862745f, 0.46666667f, 1.0f));
        Colors.put("DISCORD_PURPLE", new Color(0.44705883f, 0.5372549f, 0.85490197f, 1.0f));
        Colors.put("AOK_SAY", new Color(1.0f, 1.0f, 1.0f, 1.0f));
        Colors.put("AOK_PARTY", new Color(0.6666667f, 0.6666667f, 1.0f, 1.0f));
        Colors.put("AOK_WHISPER", new Color(1.0f, 0.5019608f, 1.0f, 1.0f));
        Colors.put("AOK_GOLD_GAIN", new Color(0.87058824f, 0.77254903f, 0.4862745f, 1.0f));
        Colors.put("AOK_XP_GAIN", new Color(0.43529412f, 0.43529412f, 0.0f, 1.0f));
        Colors.put("AOK_FAME_GAIN", new Color(1.0f, 0.6784314f, 0.29803923f, 1.0f));
        Colors.put("AOK_CHANNEL", new Color(0.7921569f, 0.6862745f, 0.46666667f, 1.0f));
        this.var_com_badlogic_gdx_graphics_Color_a = new Color(1.0f, 0.35f, 0.35f, 1.0f);
        this.var_com_badlogic_gdx_graphics_g2d_BitmapFont_f = new BitmapFont(Gdx.files.internal("misc/fonts/pt-sans-caption-bold-16a.fnt"));
        this.var_com_badlogic_gdx_graphics_g2d_BitmapFont_g = new BitmapFont(Gdx.files.internal("misc/fonts/pt-sans-caption-bold-16a.fnt"));
        this.k = new BitmapFont(Gdx.files.internal("misc/fonts/pt-sans-14.fnt"));
        this.j = new BitmapFont(Gdx.files.internal("misc/fonts/pt-sans-caption-bold-16a.fnt"));
        this.j.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        this.l = new BitmapFont(Gdx.files.internal("misc/fonts/pt-sans-caption-bold-16a.fnt"));
        this.l.setUseIntegerPositions(false);
        this.l.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        this.var_com_badlogic_gdx_graphics_g2d_BitmapFont_i = new BitmapFont(Gdx.files.internal("misc/fonts/pt_sans_12.fnt"));
        this.var_com_badlogic_gdx_graphics_g2d_BitmapFont_i.setUseIntegerPositions(false);
        this.var_com_badlogic_gdx_graphics_g2d_BitmapFont_i.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        this.n = new BitmapFont(Gdx.files.internal("misc/fonts/pt-sans-caption-bold-16a.fnt"));
        this.n.setUseIntegerPositions(false);
        this.n.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        this.o = new BitmapFont(Gdx.files.internal("misc/fonts/pt-sans-caption-bold-16a.fnt"));
        this.o.setUseIntegerPositions(false);
        this.o.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        this.o.getData().markupEnabled = true;
        this.var_com_badlogic_gdx_scenes_scene2d_ui_Label$LabelStyle_a = new Label.LabelStyle(this.o, Color.WHITE);
        this.p = new BitmapFont(Gdx.files.internal("misc/fonts/pt-sans-caption-bold-16a.fnt"));
        this.p.setUseIntegerPositions(false);
        this.p.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        this.p.getData().markupEnabled = true;
        this.var_axy_a = new axy(this.var_com_badlogic_gdx_graphics_g2d_BitmapFont_i);
        this.var_axy_a.a().getData().markupEnabled = true;
        this.var_axy_b = new axy(this.j);
        this.var_axy_b.a().getData().markupEnabled = true;
        this.var_axy_b.a().setUseIntegerPositions(true);
        this.var_axy_b.a().getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        FreeTypeFontGenerator freeTypeFontGenerator = new FreeTypeFontGenerator(Gdx.files.internal("misc/fonts/PTSans-Bold.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter freeTypeFontParameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        freeTypeFontParameter.size = 16;
        BitmapFont bitmapFont = freeTypeFontGenerator.generateFont(freeTypeFontParameter);
        bitmapFont.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        this.var_axy_c = new axy(bitmapFont);
        this.var_axy_c.a().getData().markupEnabled = true;
        this.var_axy_c.a().setUseIntegerPositions(false);
        this.var_axy_c.a().getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        freeTypeFontParameter.size = 22;
        bitmapFont = freeTypeFontGenerator.generateFont(freeTypeFontParameter);
        bitmapFont.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        this.var_axy_e = new axy(bitmapFont);
        this.var_axy_e.a().getData().markupEnabled = false;
        this.var_axy_e.a().setUseIntegerPositions(false);
        this.var_axy_e.a().getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        freeTypeFontParameter.size = 12;
        bitmapFont = freeTypeFontGenerator.generateFont(freeTypeFontParameter);
        bitmapFont.getRegion().getTexture().setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        this.var_axy_d = new axy(bitmapFont);
        this.var_axy_d.a().getData().markupEnabled = false;
        this.var_axy_d.a().setUseIntegerPositions(false);
        this.var_axy_d.a().getRegion().getTexture().setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        freeTypeFontGenerator.dispose();
        FreeTypeFontGenerator freeTypeFontGenerator2 = new FreeTypeFontGenerator(Gdx.files.internal("misc/fonts/PTSans-Bold.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter freeTypeFontParameter2 = new FreeTypeFontGenerator.FreeTypeFontParameter();
        freeTypeFontParameter2.size = 16;
        freeTypeFontParameter2.borderWidth = 1.0f;
        freeTypeFontParameter2.shadowOffsetX = 1;
        freeTypeFontParameter2.shadowOffsetY = 1;
        this.m = freeTypeFontGenerator2.generateFont(freeTypeFontParameter2);
        this.m.setUseIntegerPositions(false);
        this.m.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        freeTypeFontGenerator2.dispose();
        FreeTypeFontGenerator freeTypeFontGenerator3 = new FreeTypeFontGenerator(Gdx.files.internal("misc/fonts/PTSans-Bold.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter freeTypeFontParameter3 = new FreeTypeFontGenerator.FreeTypeFontParameter();
        freeTypeFontParameter3.size = 14;
        freeTypeFontParameter3.borderWidth = 1.0f;
        freeTypeFontParameter3.shadowOffsetX = 1;
        freeTypeFontParameter3.shadowOffsetY = 1;
        this.q = freeTypeFontGenerator3.generateFont(freeTypeFontParameter2);
        this.q.setUseIntegerPositions(false);
        this.q.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        freeTypeFontGenerator3.dispose();
        this.r = new BitmapFont(Gdx.files.internal("misc/fonts/pt-sans-caption-bold-32.fnt"));
        this.r.setUseIntegerPositions(false);
        this.r.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        this.r.getData().markupEnabled = true;
        this.var_axy_f = new axy(this.r);
        this.s = new BitmapFont(Gdx.files.internal("misc/fonts/marcellus-sc-26.fnt"));
        this.s.setUseIntegerPositions(false);
        this.s.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        this.s.getData().markupEnabled = true;
        this.var_axy_g = new axy(this.s);
        FreeTypeFontGenerator freeTypeFontGenerator4 = new FreeTypeFontGenerator(Gdx.files.internal("misc/fonts/NotoSans-Regular.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter freeTypeFontParameter4 = new FreeTypeFontGenerator.FreeTypeFontParameter();
        freeTypeFontParameter4.size = 18;
        this.u = freeTypeFontGenerator4.generateFont(freeTypeFontParameter4);
        this.u.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        freeTypeFontParameter4.size = 22;
        this.v = freeTypeFontGenerator4.generateFont(freeTypeFontParameter4);
        this.v.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        this.t = freeTypeFontGenerator4.generateFont(freeTypeFontParameter4);
        this.t.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        this.t.getData().markupEnabled = true;
        freeTypeFontParameter4.size = 28;
        this.x = freeTypeFontGenerator4.generateFont(freeTypeFontParameter4);
        this.x.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        this.w = freeTypeFontGenerator4.generateFont(freeTypeFontParameter4);
        this.w.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        freeTypeFontParameter4.size = 34;
        this.y = freeTypeFontGenerator4.generateFont(freeTypeFontParameter4);
        this.y.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        freeTypeFontParameter4.size = 64;
        this.z = freeTypeFontGenerator4.generateFont(freeTypeFontParameter4);
        this.z.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        Gdx.app.setLogLevel(1);
        this.var_u_a.load("misc/fonts/uiskin/uiskin.json", Skin.class);
        this.var_u_a.load("misc/cursors/cursors-v2.atlas", TextureAtlas.class);
        this.var_u_a.load("misc/fonts/pt-sans-caption-32a.fnt", BitmapFont.class);
        this.var_u_a.load("misc/fonts/pt-sans-caption-32a.png", Texture.class);
        this.var_u_a.finishLoading();
        this.var_com_badlogic_gdx_scenes_scene2d_ui_Skin_a = this.var_u_a.get("misc/fonts/uiskin/uiskin.json", Skin.class);
        TextureAtlas textureAtlas = this.var_u_a.get("misc/cursors/cursors-v2.atlas", TextureAtlas.class);
        TextureAtlas.AtlasRegion atlasRegion = textureAtlas.findRegion("cursor_default_gray");
        int n4 = atlasRegion.getRegionWidth();
        int n5 = atlasRegion.getRegionHeight();
        Texture texture = atlasRegion.getTexture();
        if (!texture.getTextureData().isPrepared()) {
            texture.getTextureData().prepare();
        }
        Pixmap pixmap = texture.getTextureData().consumePixmap();
        Pixmap pixmap2 = new Pixmap(n4, n5, Pixmap.Format.RGBA8888);
        for (int i3 = 0; i3 < n4; ++i3) {
            for (n3 = 0; n3 < n5; ++n3) {
                pixmap2.drawPixel(i3, n3, pixmap.getPixel(atlasRegion.getRegionX() + i3, atlasRegion.getRegionY() + n3));
            }
        }
        this.var_com_badlogic_gdx_graphics_Cursor_a = Gdx.graphics.newCursor(pixmap2, 0, 0);
        TextureAtlas.AtlasRegion atlasRegion2 = textureAtlas.findRegion("cursor_default_ally");
        n3 = atlasRegion2.getRegionWidth();
        int n6 = atlasRegion2.getRegionHeight();
        Texture texture2 = atlasRegion2.getTexture();
        if (!texture2.getTextureData().isPrepared()) {
            texture2.getTextureData().prepare();
        }
        Pixmap pixmap3 = texture2.getTextureData().consumePixmap();
        Pixmap pixmap4 = new Pixmap(n3, n6, Pixmap.Format.RGBA8888);
        for (int i4 = 0; i4 < n3; ++i4) {
            for (n2 = 0; n2 < n6; ++n2) {
                pixmap4.drawPixel(i4, n2, pixmap3.getPixel(atlasRegion2.getRegionX() + i4, atlasRegion2.getRegionY() + n2));
            }
        }
        this.var_com_badlogic_gdx_graphics_Cursor_b = Gdx.graphics.newCursor(pixmap4, 0, 0);
        TextureAtlas.AtlasRegion atlasRegion3 = textureAtlas.findRegion("cursor_default_enemy");
        n2 = atlasRegion3.getRegionWidth();
        int n7 = atlasRegion3.getRegionHeight();
        Texture texture3 = atlasRegion3.getTexture();
        if (!texture3.getTextureData().isPrepared()) {
            texture3.getTextureData().prepare();
        }
        Pixmap pixmap5 = texture3.getTextureData().consumePixmap();
        Pixmap pixmap6 = new Pixmap(n2, n7, Pixmap.Format.RGBA8888);
        for (int i5 = 0; i5 < n2; ++i5) {
            for (int i6 = 0; i6 < n7; ++i6) {
                pixmap6.drawPixel(i5, i6, pixmap5.getPixel(atlasRegion3.getRegionX() + i5, atlasRegion3.getRegionY() + i6));
            }
        }
        this.var_com_badlogic_gdx_graphics_Cursor_c = Gdx.graphics.newCursor(pixmap6, 0, 0);
        Pixmap pixmap7 = new Pixmap(Gdx.files.internal("misc/cursors/loot_cursor.png"));
        this.var_com_badlogic_gdx_graphics_Cursor_d = Gdx.graphics.newCursor(pixmap7, 0, 0);
        pixmap7.dispose();
        Gdx.graphics.setCursor(this.var_com_badlogic_gdx_graphics_Cursor_a);
        System.out.println("Login Loading Screen");
        this.var_z_a.void_b();
        this.setScreen(new afx(this, null));
    }

    public void void_b() {
        long l2;
        o o2 = new o(this);
        this.var_q_a.a("[STEAM] Initializing SteamUser...");
        if (!SteamAPI.isSteamRunning()) {
            System.exit(1);
        }
        this.var_com_codedisaster_steamworks_SteamUser_a = new SteamUser(o2);
        this.var_long_a = l2 = SteamNativeHandle.getNativeHandle(this.var_com_codedisaster_steamworks_SteamUser_a.getSteamID());
        this.var_q_a.a("[STEAM] Done.");
        this.var_q_a.a("[STEAM] Initializing SteamApps...");
        this.var_com_codedisaster_steamworks_SteamApps_a = new SteamApps();
        this.var_q_a.a("[STEAM] Done.");
        p p2 = new p(this);
        this.var_q_a.a("[STEAM] Initializing SteamFriends...");
        this.var_com_codedisaster_steamworks_SteamFriends_a = new SteamFriends(p2);
        this.var_q_a.a("[STEAM] Done.");
    }

    public void void_c() {
        this.var_azm_a = new ArrayList();
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.kH);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.e);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.c);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.d);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.jd);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.jl);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.jm);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.kM);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.kN);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.jl);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.jm);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.lc);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.jZ);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.ka);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.kb);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.kc);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.kd);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.ke);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.kf);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.kg);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.kh);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.ki);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.kj);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.kl);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.km);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.kn);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.kk);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.ko);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.kp);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.jS);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.jT);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.jY);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.iX);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.iY);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.iZ);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.ja);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.jb);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.kq);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.kr);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.ks);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.hM);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.jn);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.jp);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.ju);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.jr);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.jo);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.jv);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.jx);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.js);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.jB);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.jw);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.jt);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.jq);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.jz);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.jA);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.jy);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.iW);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.jc);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.jf);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.jg);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.jh);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.ji);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.jj);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.jk);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.je);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.i);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.kB);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.iU);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.iV);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.kD);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.kE);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.la);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.lb);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.kY);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.kX);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.kW);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.ky);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.jU);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.jV);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.jW);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.ld);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.le);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.bt);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.bu);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.bv);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.ic);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.bG);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.bH);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.bw);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.bx);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.by);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.bz);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.bA);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.bB);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.bC);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.bD);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.bE);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.bF);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.F);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.J);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.bf);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.bj);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.N);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.R);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.aj);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.an);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.aP);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.aT);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.aH);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.aL);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.ab);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.af);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.aX);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.bb);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.av);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.az);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.aD);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.bn);
        ((ArrayList)((Object)this.var_azm_a)).add(ajw.br);
    }

    public void d() {
        this.var_java_lang_String_b = new Array(var_int_a);
        for (int i2 = 0; i2 < var_int_a; ++i2) {
            ((Array)((Object)this.var_java_lang_String_b)).add(new g("", g.a(), this.k, this));
        }
        if ("2.0.0.0".startsWith("QA")) {
            ((g)((Array)((Object)this.var_java_lang_String_b)).get((int)(Engine.var_int_a - 8))).var_java_lang_String_a = "Welcome to Arena of Kings! (QA SERVER)";
            ((g)((Array)((Object)this.var_java_lang_String_b)).get(var_int_a - 8)).a(this.var_com_badlogic_gdx_graphics_g2d_BitmapFont_b);
        } else {
            ((g)((Array)((Object)this.var_java_lang_String_b)).get((int)(Engine.var_int_a - 8))).var_java_lang_String_a = "Welcome to Arena of Kings!";
            ((g)((Array)((Object)this.var_java_lang_String_b)).get(var_int_a - 8)).a(this.var_com_badlogic_gdx_graphics_g2d_BitmapFont_b);
        }
    }

    public void a(SpriteBatch spriteBatch) {
        Gdx.gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        Gdx.gl.glClear(16384);
        this.p();
        if (this.var_com_arenaofkings_packets_loginserver_PUB_LOGIN_EXISTING_ACCOUNT_REQUEST_a != null && this.var_azv_e.boolean_b() && this.var_boolean_h) {
            this.var_azv_e.void_c();
            this.var_boolean_i = true;
            if (!this.var_ag_a.boolean_a() || !t.a(agd.class, this) && !t.a(ajo.class, this)) {
                this.var_boolean_h = false;
                this.var_z_a.a(1, "          Reconnecting...", true);
                this.k();
                this.var_z_a.void_a(this.var_com_arenaofkings_packets_loginserver_PUB_LOGIN_EXISTING_ACCOUNT_REQUEST_a);
            }
        }
        if (this.var_azv_c.boolean_b()) {
            this.var_azv_c.void_c();
        }
        if (this.var_com_badlogic_gdx_graphics_Cursor_a != null) {
            Gdx.graphics.setCursor(this.var_com_badlogic_gdx_graphics_Cursor_a);
        } else {
            Engine.a("cursor is null");
        }
        if (Gdx.input.isTouched()) {
            this.m();
        }
        this.var_r_a.update();
        this.var_com_badlogic_gdx_math_Vector3_a.set(Gdx.input.getX(), Gdx.input.getY(), 0.0f);
        this.var_com_badlogic_gdx_math_Vector3_a = this.var_r_a.unproject(this.var_com_badlogic_gdx_math_Vector3_a);
        if (SteamAPI.isSteamRunning()) {
            SteamAPI.runCallbacks();
        }
        if (this.var_ag_a.boolean_b()) {
            this.var_ag_a.void_b();
        }
        if (!t.a(agd.class, this)) {
            this.j();
        }
        this.var_z_a.ac_a().a();
        this.var_ag_a.ab_a().a(this);
        this.var_ag_a.ab_a().void_a();
        this.g();
        this.var_boolean_i = false;
    }

    @Override
    public void void_a() {
        this.var_boolean_e = false;
    }

    private void p() {
    }

    public void e() {
        this.var_z_a.void_c();
    }

    public void f() {
        this.var_ag_a.c();
    }

    public void a(String string, BitmapFont bitmapFont, Color color, BitmapFont bitmapFont2, Color color2, float f2, float f3, int n2, int n3, float f4) {
        this.var_com_badlogic_gdx_graphics_g2d_BitmapFontCache_a = bitmapFont.getCache();
        this.var_com_badlogic_gdx_graphics_g2d_BitmapFontCache_a.clear();
        this.var_com_badlogic_gdx_graphics_g2d_BitmapFontCache_a.addText(string, f2, f3, 9999.0f, n2, false);
        this.var_com_badlogic_gdx_graphics_g2d_BitmapFontCache_a.setColor(color);
        this.var_com_badlogic_gdx_graphics_g2d_BitmapFontCache_a.setAlphas(f4);
        this.var_com_badlogic_gdx_graphics_g2d_BitmapFontCache_a.draw(this.var_azi_a);
    }

    public int a(String string, BitmapFont bitmapFont) {
        this.var_com_badlogic_gdx_graphics_g2d_GlyphLayout_a.setText(bitmapFont, string);
        return (int)this.var_com_badlogic_gdx_graphics_g2d_GlyphLayout_a.width;
    }

    public void a(String string, BitmapFont bitmapFont, Color color, BitmapFont bitmapFont2, Color color2, float f2, float f3, int n2, int n3) {
        this.var_com_badlogic_gdx_graphics_g2d_GlyphLayout_a.setText(bitmapFont2, string, color2, 0.0f, n2, false);
        bitmapFont2.draw((Batch)this.var_azi_a, this.var_com_badlogic_gdx_graphics_g2d_GlyphLayout_a, f2 - (float)n3, f3);
        bitmapFont2.draw((Batch)this.var_azi_a, this.var_com_badlogic_gdx_graphics_g2d_GlyphLayout_a, f2, f3 + (float)n3);
        bitmapFont2.draw((Batch)this.var_azi_a, this.var_com_badlogic_gdx_graphics_g2d_GlyphLayout_a, f2, f3 - (float)n3);
        bitmapFont2.draw((Batch)this.var_azi_a, this.var_com_badlogic_gdx_graphics_g2d_GlyphLayout_a, f2 + (float)n3, f3);
        this.var_com_badlogic_gdx_graphics_g2d_GlyphLayout_a.setText(bitmapFont, string, color, 0.0f, n2, false);
        bitmapFont2.draw((Batch)this.var_azi_a, this.var_com_badlogic_gdx_graphics_g2d_GlyphLayout_a, f2, f3);
    }

    public void a(String string, BitmapFont bitmapFont, Color color, BitmapFont bitmapFont2, Color color2, float f2, float f3, int n2) {
        bitmapFont.getData().markupEnabled = true;
        this.var_com_badlogic_gdx_graphics_g2d_GlyphLayout_a.setText(bitmapFont, string, color, 0.0f, n2, false);
        bitmapFont.draw((Batch)this.var_azi_a, this.var_com_badlogic_gdx_graphics_g2d_GlyphLayout_a, f2, f3);
    }

    public void a(String string, BitmapFont bitmapFont, Color color, BitmapFont bitmapFont2, Color color2, float f2, float f3, int n2, float f4) {
        boolean bl2 = bitmapFont2.getData().markupEnabled;
        boolean bl3 = bitmapFont.getData().markupEnabled;
        bitmapFont.getData().markupEnabled = true;
        this.var_com_badlogic_gdx_graphics_g2d_GlyphLayout_a.setText(bitmapFont, string, color, 0.0f, n2, false);
        bitmapFont.draw((Batch)this.var_azi_a, this.var_com_badlogic_gdx_graphics_g2d_GlyphLayout_a, f2, f3);
        bitmapFont2.getData().markupEnabled = bl2;
        bitmapFont.getData().markupEnabled = bl3;
    }

    public void a(String string, BitmapFont bitmapFont, Color color, BitmapFont bitmapFont2, Color color2, float f2, float f3, int n2, azi azi2) {
        boolean bl2 = bitmapFont2.getData().markupEnabled;
        boolean bl3 = bitmapFont.getData().markupEnabled;
        bitmapFont.getData().markupEnabled = true;
        this.var_com_badlogic_gdx_graphics_g2d_GlyphLayout_a.setText(bitmapFont, string, color, 1.0f, n2, false);
        bitmapFont.draw((Batch)azi2, this.var_com_badlogic_gdx_graphics_g2d_GlyphLayout_a, f2, f3);
        bitmapFont2.getData().markupEnabled = bl2;
        bitmapFont.getData().markupEnabled = bl3;
    }

    @Override
    public void render() {
        this.a(this.var_azi_a);
        super.render();
    }

    @Override
    public void dispose() {
        System.out.println("MAIN DISPOSE");
        System.exit(0);
    }

    @Override
    public void setScreen(Screen screen) {
        StopWatch stopWatch = StopWatch.createStarted();
        boolean bl2 = false;
        this.var_boolean_b = true;
        if (this.axc_a() != null && this.axc_a().getClass() != afx.class && (screen instanceof aes || screen instanceof afx)) {
            System.out.println("Delayed logout: " + this.var_boolean_i);
            bl2 = true;
        }
        this.var_axc_a = this.axc_a();
        this.var_axc_b = (axc)screen;
        if (this.axc_a() == null) {
            this.var_q_a.a("[SET-SCREEN] currentScreen NULL. newScreen: " + this.var_axc_b.getClass().getSimpleName());
        } else {
            this.var_q_a.a("[SET-SCREEN] currentScreen: " + this.axc_a().getClass().getSimpleName() + ". newScreen: " + this.var_axc_b.getClass().getSimpleName());
        }
        Engine.b("setScreen() " + screen.getClass().getSimpleName());
        this.a(this.var_axc_a, this.var_axc_b);
        Engine.b("setting screen");
        super.setScreen(screen);
        if (bl2 && !this.var_boolean_i) {
            System.out.println("Send logout request");
            PUB_LOGOUT_REQUEST pUB_LOGOUT_REQUEST = new PUB_LOGOUT_REQUEST();
            this.var_z_a.void_a(pUB_LOGOUT_REQUEST);
        }
        Engine.b("screen set");
        this.var_boolean_b = false;
        stopWatch.stop();
        System.out.println("SCREEN TRAN TOOK: " + stopWatch.getTime(TimeUnit.MILLISECONDS) + "ms");
    }

    public axc axc_a() {
        return (axc)super.getScreen();
    }

    @Deprecated
    public void a(ajw ajw2) {
    }

    public void a(Class<? extends axc> clazz, ayl ayl2) {
        if (this.var_axc_b != null) {
            ((Array)((Object)this.var_java_lang_String_d)).add(new azj(clazz, ayl2));
            this.var_boolean_e = true;
        }
    }

    public void g() {
        if (!((Array)((Object)this.var_java_lang_String_d)).isEmpty()) {
            this.var_boolean_e = true;
            System.out.println("Popped screen queue");
            azj azj2 = (azj)((Array)((Object)this.var_java_lang_String_d)).removeIndex(0);
            if (azj2.a() == afx.class) {
                this.var_axc_b = new afx(this, azj2.a());
            } else if (azj2.a() == vh.class) {
                this.var_axc_b = new vh(this, azj2.a());
            } else if (azj2.a() == wb.class) {
                this.var_axc_b = new wb(this, azj2.a());
            } else if (azj2.a() == xw.class) {
                this.var_axc_b = new xw(this, azj2.a());
            } else if (azj2.a() == ajo.class) {
                this.var_axc_b = new ajo(this, azj2.a());
            } else {
                Engine.a("[ERROR] AbstractScreen not found.");
            }
            System.out.println("Screen queue set: " + this.var_axc_b.getClass().getName());
            System.out.println("Screen queue set2: " + azj2.a().getName());
            if (this.axc_a() != null && this.axc_a().getClass() == agd.class) {
                System.out.println("WIPING PLAY");
                if (this.var_ag_a != null) {
                    this.var_ag_a.e();
                }
            }
            this.setScreen(this.var_axc_b);
            System.out.println("Done setting the screen");
        }
    }

    public void a(axc axc2, axc axc3) {
        if (axc2 == null) {
            Engine.b("loadDependencies: newScreen: " + axc3.getClass().getName() + " " + this.var_boolean_d);
        } else {
            Engine.b("loadDependencies: oldScreen: " + axc2.getClass().getName() + " newScreen: " + axc3.getClass().getName() + " " + this.var_boolean_d);
        }
        this.b(axc3);
    }

    private void a(axc axc2) {
        ArrayList<ajw> arrayList = new ArrayList<ajw>();
        for (ajw object : axc2.axm_a().a()) {
            Engine.b("[LOAD] Loading internal dependency \t" + object.a() + " " + object.a());
            if (!this.var_com_badlogic_gdx_assets_AssetManager_a.isLoaded(object.a())) {
                arrayList.add(object);
            }
            this.var_com_badlogic_gdx_assets_AssetManager_a.load(object.a(), object.a());
        }
        System.out.println("\n\nNew Loads: " + arrayList.size());
        for (ajw ajw2 : arrayList) {
            System.out.println("NEW LOAD OF: " + (Object)((Object)ajw2));
        }
        this.var_com_badlogic_gdx_assets_AssetManager_a.finishLoading();
    }

    private void b(axc axc2) {
        Engine.b("[PREPARE DEPENDENCIES]");
        if (this.var_axc_a != null) {
            Object object;
            Iterator iterator;
            Array<ajw> array;
            if (this.var_axc_a.getClass() == afx.class && axc2.getClass() == aes.class || this.var_axc_a.getClass() == xw.class && axc2.getClass() == we.class || this.var_axc_a.getClass() == ajo.class && axc2.getClass() == agd.class || this.var_axc_a.getClass() == wb.class && axc2.getClass() == vj.class || this.var_axc_a.getClass() == vh.class && axc2.getClass() == um.class) {
                array = new Array<ajw>();
                Iterator object2 = this.var_axc_a.axm_a().a().iterator();
                while (object2.hasNext()) {
                    array.add((ajw)((Object)object2.next()));
                }
                this.var_axc_a.dispose();
                this.var_axc_a = null;
                iterator = array.iterator();
                while (iterator.hasNext()) {
                    object = (ajw)((Object)iterator.next());
                    if (!axc2.axm_a().b((ajw)((Object)object))) {
                        Engine.b("[DISPOSE] Unloading: " + ((Enum)object).name() + "\t" + ((ajw)((Object)object)).toString());
                        this.a((ajw)((Object)object), true);
                        iterator.remove();
                        continue;
                    }
                    Engine.b("[DISPOSE] Skipping: " + ((Enum)object).name() + "\t" + ((ajw)((Object)object)).toString());
                }
                Engine.b("[DISPOSE] CASE 1 Dispose done!");
            } else if (this.var_axc_a.getClass() != afx.class || this.var_axc_a.getClass() != xw.class || this.var_axc_a.getClass() != ajo.class || this.var_axc_a.getClass() != vh.class || this.var_axc_a.getClass() != wb.class) {
                Engine.a("Coming from case 2");
                array = new Array();
                Iterator iterator2 = this.var_axc_a.axm_a().a().iterator();
                while (iterator2.hasNext()) {
                    array.add((ajw)((Object)iterator2.next()));
                }
                this.var_axc_a.dispose();
                this.var_axc_a = null;
                iterator = array.iterator();
                while (iterator.hasNext()) {
                    object = (ajw)((Object)iterator.next());
                    if (axc2.axm_a().b((ajw)((Object)object))) {
                        Engine.b("[DISPOSE] Skipping: " + ((Enum)object).name() + "\t" + ((ajw)((Object)object)).toString());
                    } else {
                        Engine.b("[DISPOSE] Unloading: " + ((Enum)object).name() + "\t" + ((ajw)((Object)object)).toString());
                        this.a((ajw)((Object)object), true);
                        iterator.remove();
                    }
                    Engine.b("[DISPOSE] First sweep done!");
                }
                object = array.iterator();
                while (object.hasNext()) {
                    ajw ajw2 = (ajw)((Object)object.next());
                    Engine.b("[DISPOSE] Unloading: " + ajw2.name() + "\t" + ajw2.toString());
                    this.a(ajw2, false);
                    object.remove();
                }
                Engine.b("[DISPOSE] Second sweep done!");
                Engine.b("[DISPOSE] Superpost");
                for (String string : this.var_com_badlogic_gdx_assets_AssetManager_a.getAssetNames()) {
                    Engine.b("\tAsset: " + string + " is loaded. RefCount: " + this.var_com_badlogic_gdx_assets_AssetManager_a.getReferenceCount(string));
                }
                Engine.b("[DISPOSE] CASE 2 Dispose done!");
            }
        }
        Engine.b("newScreen: " + axc2.getClass());
        if (axc2.getClass() == afx.class || axc2.getClass() == xw.class || axc2.getClass() == ajo.class || axc2.getClass() == vh.class || axc2.getClass() == wb.class) {
            Engine.b("[LOAD] Internal Dependencies begin ...");
            long l2 = System.nanoTime();
            this.a(axc2);
            long l3 = System.nanoTime();
            Engine.b(axc2.getClass().getName() + " Screen Load took: " + (int)Math.floor(TimeUnit.NANOSECONDS.toMillis(l3 - l2)) + "ms");
            Engine.b("[LOAD] Internal Dependencies done!");
        }
        Engine.b("[PREPARE DEPENDENCIES] - Superpost -");
        for (String string : this.var_com_badlogic_gdx_assets_AssetManager_a.getAssetNames()) {
            Engine.b("\tAsset: " + string + " is loaded. RefCount: " + this.var_com_badlogic_gdx_assets_AssetManager_a.getReferenceCount(string));
        }
    }

    public void a(ajw ajw2, boolean bl2) {
        if (ajw2 != null) {
            if (this.var_com_badlogic_gdx_assets_AssetManager_a.isLoaded(ajw2.a()) && !((ArrayList)((Object)this.var_azm_a)).contains((Object)ajw2)) {
                System.out.println("Safe unload of: " + (Object)((Object)ajw2));
                this.var_com_badlogic_gdx_assets_AssetManager_a.unload(ajw2.a());
                Engine.a("AssetManager.unload(" + (Object)((Object)ajw2) + ") done.");
            }
        } else {
            Engine.a("[WARNING] safeUnload() dependency was not loaded, so didn't unload..");
        }
    }

    @Deprecated
    public void b(ajw ajw2) {
    }

    public void h() {
        Engine.b("\nprintAssetManager()");
        for (String string : this.var_com_badlogic_gdx_assets_AssetManager_a.getAssetNames()) {
            Engine.b("\tAsset: " + string + " is loaded. RefCount: " + this.var_com_badlogic_gdx_assets_AssetManager_a.getReferenceCount(string));
        }
    }

    public boolean boolean_a() {
        return this.var_boolean_e;
    }

    public void a(String string, int n2, int n3, int n4) {
        String string2 = azu.a(this, this.var_axy_c.a(), string, n4);
        int n5 = azu.a(this, this.var_axy_c.a(), string2);
        int n6 = azu.b(this, this.var_axy_c.a(), string2);
        this.var_azi_a.end();
        this.var_axf_a.begin(ShapeRenderer.ShapeType.Filled);
        if (this.var_axf_a.isDrawing()) {
            this.var_axf_a.a(n2 - 12, (float)(n3 - 12 - n6), (float)(n5 + 25), (float)(n6 + 25), 20.0f, axe.y);
        }
        this.var_axf_a.end();
        this.var_azi_a.begin();
    }

    public void b(String string, int n2, int n3, int n4) {
        String string2 = azu.a(this, this.var_axy_f.a(), string, n4);
        int n5 = azu.a(this, this.var_axy_f.a(), string2);
        int n6 = azu.b(this, this.var_axy_f.a(), string2);
        this.var_azi_a.end();
        this.var_axf_a.begin(ShapeRenderer.ShapeType.Filled);
        if (this.var_axf_a.isDrawing()) {
            this.var_axf_a.a(n2 - 12, (float)(n3 - 12 - n6), (float)(n5 + 25), (float)(n6 + 25), 20.0f, axe.y);
        }
        this.var_axf_a.end();
        this.var_azi_a.begin();
    }

    public void a(String string, int n2, int n3) {
        this.a(string, this.var_axy_c.a(), Color.WHITE, this.var_axy_c.a(), Color.BLACK, (float)n2, (float)n3, 8, this.var_azi_a);
    }

    public static void a(String string) {
    }

    public static void b(String string) {
        System.out.println(string);
    }

    public static String a(double d2, int n2) {
        String string = "#";
        if (n2 > 0) {
            string = string + ".";
        }
        for (int i2 = 0; i2 < n2; ++i2) {
            string = string + "#";
        }
        return new DecimalFormat(string).format(d2);
    }

    public void a(Dialog dialog) {
        this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a = dialog;
        this.var_boolean_f = true;
    }

    public void i() {
        this.var_boolean_f = false;
    }

    public boolean boolean_b() {
        return this.var_boolean_f;
    }

    public boolean boolean_c() {
        if (this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a != null) {
            this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a.hide(null);
            this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a = null;
            this.var_boolean_f = false;
            return true;
        }
        return false;
    }

    public void j() {
        if (this.var_azv_a.boolean_b()) {
            this.var_azv_a.void_c();
            if (this.var_z_a != null && this.var_z_a.org_java_websocket_client_WebSocketClient_a() != null && this.var_z_a.org_java_websocket_client_WebSocketClient_a().isClosed()) {
                this.var_z_a.void_b();
            }
        }
    }

    public void k() {
        this.var_azv_a.void_c();
        if (this.var_z_a != null && this.var_z_a.org_java_websocket_client_WebSocketClient_a() != null && this.var_z_a.org_java_websocket_client_WebSocketClient_a().isClosed()) {
            this.var_z_a.void_b();
        }
    }

    public void l() {
        if ((this.var_boolean_c || this.var_azv_b.boolean_b()) && this.var_z_a.org_java_websocket_client_WebSocketClient_a().isOpen()) {
            this.var_azv_b.void_c();
            this.var_boolean_c = false;
            PUB_MISC_NEWS_UPDATE pUB_MISC_NEWS_UPDATE = new PUB_MISC_NEWS_UPDATE();
            this.var_z_a.void_a(pUB_MISC_NEWS_UPDATE);
        }
    }

    public void a(boolean bl2) {
        this.var_boolean_c = bl2;
        if ((this.var_boolean_c || this.var_azv_b.boolean_b()) && this.var_z_a.org_java_websocket_client_WebSocketClient_a().isOpen()) {
            this.var_azv_b.void_c();
            this.var_boolean_c = false;
            PUB_MISC_NEWS_UPDATE pUB_MISC_NEWS_UPDATE = new PUB_MISC_NEWS_UPDATE();
            this.var_z_a.void_a(pUB_MISC_NEWS_UPDATE);
        }
    }

    public void m() {
        this.var_boolean_g = false;
    }

    public void c(String string) {
        this.var_boolean_g = true;
        this.var_int_e = 0;
        this.var_java_lang_String_h = string;
        this.var_azv_d.void_c();
    }

    public void a(PUB_MISC_CHAT_MESSAGE pUB_MISC_CHAT_MESSAGE) {
        for (int i2 = 0; i2 < var_int_a - 1; ++i2) {
            this.var_java_lang_String_b.set(i2, (PUB_MISC_CHAT_MESSAGE)this.var_java_lang_String_b.get(i2 + 1));
        }
        this.var_java_lang_String_b.set(var_int_a - 1, pUB_MISC_CHAT_MESSAGE);
    }

    public List<PUB_MISC_CHAT_MESSAGE> a() {
        return this.var_java_lang_String_b;
    }

    public void n() {
        this.var_java_lang_String_b.clear();
        this.var_java_lang_String_b = new ArrayList(var_int_a);
        for (int i2 = 0; i2 < var_int_a; ++i2) {
            this.var_java_lang_String_b.add(new PUB_MISC_CHAT_MESSAGE());
        }
        this.a(new PUB_MISC_CHAT_MESSAGE("[AOK_BLUE]Development Update"));
        this.a(new PUB_MISC_CHAT_MESSAGE("[AOK_BLUE]Arena of Kings 2 is in development! Follow updates at  discord.gg/aok"));
        this.a(new PUB_MISC_CHAT_MESSAGE("[AOK_BLUE]Our classic game will be preserved and remain online."));
        this.a(new PUB_MISC_CHAT_MESSAGE("[AOK_BLUE]Our friendly community teaches new players - join us!"));
        this.a(new PUB_MISC_CHAT_MESSAGE("[AOK_NAMEPLATE_GOLD]We have huge plans behind the scenes. The best days are still to come."));
        this.a(new PUB_MISC_CHAT_MESSAGE("[RED]Much love from our team. Stay safe <3[]"));
    }

    public static void o() {
        System.exit(1);
    }

    public axm axm_a() {
        return this.axc_a().axm_a();
    }

    public void b(boolean bl2) {
        this.var_boolean_h = bl2;
    }

    @Override
    public /* synthetic */ Screen getScreen() {
        return this.axc_a();
    }

    static {
        var_azm_a = azm.var_azm_a;
        var_int_a = 100;
    }
}

