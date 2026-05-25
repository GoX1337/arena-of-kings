/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.loginserver.PUB_TOURNAMENT_LIST_REQUEST;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ObjectMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class aaf
extends zm {
    private ayh var_ayh_a;
    private ayh var_ayh_b;
    private Array<aab> var_com_badlogic_gdx_utils_Array_aab__a;
    private ObjectMap<String, ayh> cfr_renamed_1;
    private ayf var_ayf_a;
    private ayh var_ayh_c;
    private ayh var_ayh_d;
    private boolean var_boolean_b = false;
    private Iterator<aab> var_java_util_Iterator_aab__a;
    private aab var_aab_a;
    private ayh var_ayh_e;
    private ayh f;
    private ayh g;
    private ayf var_ayf_b;
    private ayh h;
    private Map<String, ayh> cfr_renamed_0;
    private ayf var_ayf_c;
    private ayf var_ayf_d;
    private ayf var_ayf_e;
    private aaa var_aaa_a;
    private SelectBox<zg> var_com_badlogic_gdx_scenes_scene2d_ui_SelectBox_zg__a;
    private Dialog var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a;
    private int var_int_a = 0;
    private int var_int_b = 0;
    private int var_int_c = 0;
    private int var_int_d = 0;

    public aaf(Engine engine, axm axm2, Stage stage) {
        super(engine, axm2, stage);
    }

    @Override
    public void void_a() {
        TextureAtlas textureAtlas = ((axm)((Object)this.var_ayh_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c);
        TextureAtlas textureAtlas2 = ((axm)((Object)this.var_ayh_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.jd);
        TextureAtlas textureAtlas3 = ((axm)((Object)this.var_ayh_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.je);
        TextureAtlas textureAtlas4 = ((axm)((Object)this.var_ayh_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.i);
        TextureAtlas textureAtlas5 = ((axm)((Object)this.var_ayh_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.b);
        this.h = new ayh(0, 0, textureAtlas, "bracket_background", true);
        this.var_ayh_e = new ayh(0, 0, textureAtlas, "bracket_connector_horizontal", true);
        this.f = new ayh(0, 0, textureAtlas, "bracket_connector_vertical", true);
        this.g = new ayh(0, 0, textureAtlas, "bye", true);
        this.var_ayf_b = new ayf(0, 0, textureAtlas, "bracket_default", "bracket_hovered", true);
        this.var_ayh_a = new HashMap();
        this.var_ayh_a.put("blue_cup", new ayh(0, 0, textureAtlas4, "blue_cup", true, 0.75f, true));
        this.var_ayh_a.put("blue_star", new ayh(0, 0, textureAtlas4, "blue_star", true));
        this.var_ayh_a.put("purple_cup", new ayh(0, 0, textureAtlas4, "purple_cup", true));
        this.var_ayh_a.put("purple_star", new ayh(0, 0, textureAtlas4, "purple_star", true));
        this.var_ayh_a.put("orange_cup", new ayh(0, 0, textureAtlas4, "orange_cup", true));
        this.var_ayh_a.put("orange_star", new ayh(0, 0, textureAtlas4, "orange_star", true));
        this.d();
        if (this.var_ayh_a == null) {
            this.var_ayh_a = new Array();
        } else {
            ((Array)((Object)this.var_ayh_a)).clear();
        }
        this.var_ayh_a = new ObjectMap();
        ayh ayh2 = new ayh(0, 0, textureAtlas, "villain_logo_tiny", true);
        ayh ayh3 = new ayh(0, 0, textureAtlas, "villain_logo", true);
        ((ObjectMap)((Object)this.var_ayh_a)).put("Villain Games - Small Logo", ayh2);
        ((ObjectMap)((Object)this.var_ayh_a)).put("Villain Games - Big Logo", ayh3);
        this.var_ayh_a = new ayh(680, 828, textureAtlas, "tournament_longview_main_frame", true);
        this.var_ayh_b = new ayh(677, 382, textureAtlas, "tournament_inspect_main_frame", true);
        this.var_ayf_a = new ayf(0, 0, textureAtlas, "tournament_longview_row", "tournament_longview_row_hovered", true);
        this.var_ayh_c = new ayh(0, 0, textureAtlas, "tournament_prize_row", true);
        this.var_ayh_d = new aag(this, 1468, 910, textureAtlas, "bracket_x", true);
        this.var_ayh_d.com_badlogic_gdx_graphics_g2d_Sprite_a().scale(-0.5f);
        int n2 = 0;
        for (zz zz2 : ay.ay_a().gd_a().a()) {
            aab aab2 = new aab(this, zz2, n2++, (ayh)((ObjectMap)((Object)this.var_ayh_a)).get(zz2.b() + " - Small Logo"), (ayh)((ObjectMap)((Object)this.var_ayh_a)).get(zz2.b() + " - Big Logo"), this.var_ayf_a, this.var_ayh_c, this.var_ayh_d);
            ((Array)((Object)this.var_ayh_a)).add(aab2);
        }
        this.var_ayf_c = new aah(this, 1090, 652, textureAtlas, "tournament_register_button_default", "tournament_register_button_hovered", true);
        this.var_ayf_d = new aaj(this, 1230, 652, textureAtlas, "tournament_teams_button_default", "tournament_teams_button_hovered", true);
        this.var_ayf_e = new aak(this, 1370, 652, textureAtlas, "tournament_bracket_button_default", "tournament_bracket_button_hovered", true);
        this.f();
    }

    public void d() {
        this.var_ayh_a = new SelectBox(((Engine)((Object)this.var_ayh_a)).var_com_badlogic_gdx_scenes_scene2d_ui_Skin_a);
        ((SelectBox)((Object)this.var_ayh_a)).setItems(ay.ay_a().gd_a().a());
        if (ay.ay_a().gd_a().a().size >= 1) {
            ((SelectBox)((Object)this.var_ayh_a)).setSelected(ay.ay_a().gd_a().a().get(0));
        }
        ((SelectBox)((Object)this.var_ayh_a)).setAlignment(1);
        ((SelectBox)((Object)this.var_ayh_a)).getList().setAlignment(1);
        ((Actor)((Object)this.var_ayh_a)).setWidth(230.0f);
        ((Actor)((Object)this.var_ayh_a)).setColor(1.0f, 1.0f, 1.0f, 0.6f);
        ((SelectBox)((Object)this.var_ayh_a)).getStyle().fontColor = Color.GREEN;
    }

    public void e() {
        if (this.var_ayh_a == null) {
            this.var_ayh_a = new Array();
        } else {
            ((Array)((Object)this.var_ayh_a)).clear();
        }
        int n2 = 0;
        for (zz zz2 : ay.ay_a().gd_a().a()) {
            aab aab2 = new aab(this, zz2, n2++, (ayh)((ObjectMap)((Object)this.var_ayh_a)).get(zz2.b() + " - Small Logo"), (ayh)((ObjectMap)((Object)this.var_ayh_a)).get(zz2.b() + " - Big Logo"), this.var_ayf_a, this.var_ayh_c, this.var_ayh_d);
            ((Array)((Object)this.var_ayh_a)).add(aab2);
        }
        this.f();
    }

    public void f() {
        this.var_boolean_b = false;
        this.var_ayh_a = ((Array)((Object)this.var_ayh_a)).iterator();
        while (this.var_ayh_a.hasNext()) {
            aab aab2 = (aab)this.var_ayh_a.next();
            aab2.a(false);
        }
        this.var_aab_a = null;
    }

    public void g() {
        this.var_boolean_b = true;
        Iterator iterator = ((Array)((Object)this.var_ayh_a)).iterator();
        while (iterator.hasNext()) {
            aab aab2 = (aab)iterator.next();
            if (!aab2.var_boolean_a) continue;
            this.var_aab_a = aab2;
        }
    }

    @Override
    public void a(float f2, Engine engine) {
    }

    @Override
    public void b(float f2, Engine engine) {
        if (this.var_ayh_a != false) {
            this.var_ayf_a.a(f2, engine);
            if (this.var_boolean_b) {
                this.var_ayh_b.b(f2, engine);
                this.var_ayf_c.a(f2, engine);
                this.var_ayf_d.a(f2, engine);
                this.var_ayf_e.a(f2, engine);
                this.var_ayf_c.b(f2, engine);
                this.var_ayf_d.b(f2, engine);
                this.var_ayf_e.b(f2, engine);
                for (int i2 = 0; i2 < ((Array)((Object)this.var_ayh_a)).size; ++i2) {
                    aab aab2 = (aab)((Array)((Object)this.var_ayh_a)).get(i2);
                    aab2.c(f2, engine);
                    if (!aab2.var_boolean_a) continue;
                    this.a(engine, aab2);
                }
            } else {
                this.var_ayh_a.b(f2, engine);
                aab aab3 = null;
                for (int i3 = 0; i3 < ((Array)((Object)this.var_ayh_a)).size; ++i3) {
                    aab aab4 = (aab)((Array)((Object)this.var_ayh_a)).get(i3);
                    aab4.d(f2, engine);
                    if (aab3 == null) {
                        aab3 = aab4;
                        continue;
                    }
                    if (aab3.zz_a().m <= aab4.zz_a().m) continue;
                    aab3 = aab4;
                }
                if (aab3 != null) {
                    this.a(engine, aab3);
                }
            }
        }
    }

    public void a(Engine engine, aab aab2) {
        engine.a("Schedule:", engine.var_axy_c.a(), axe.E, engine.var_axy_c.a(), Color.BLACK, 947.0f, 950.0f, 1, 1);
        engine.a(aab2.zz_a().java_lang_String_a(), engine.var_axy_c.a(), Color.WHITE, engine.var_axy_c.a(), Color.BLACK, 947.0f, 927.0f, 1, 1);
        this.var_int_a = aab2.int_a(aab2.zz_a().java_util_Date_a().getTime());
        this.var_int_b = aab2.b(aab2.zz_a().java_util_Date_a().getTime());
        this.var_int_c = aab2.c(aab2.zz_a().java_util_Date_a().getTime());
        this.var_int_d = aab2.d(aab2.zz_a().java_util_Date_a().getTime());
        engine.a(String.valueOf(this.var_int_a), engine.var_axy_c.a(), Color.BLACK, engine.var_axy_c.a(), Color.WHITE, 1102.0f, 924.0f, 1);
        engine.a(String.valueOf(this.var_int_b), engine.var_axy_c.a(), Color.BLACK, engine.var_axy_c.a(), Color.WHITE, 1162.0f, 925.0f, 1);
        engine.a(String.valueOf(this.var_int_c), engine.var_axy_c.a(), Color.BLACK, engine.var_axy_c.a(), Color.WHITE, 1222.0f, 925.0f, 1);
        engine.a(String.valueOf(this.var_int_d), engine.var_axy_c.a(), Color.BLACK, engine.var_axy_c.a(), Color.WHITE, 1282.0f, 925.0f, 1);
    }

    public void c(float f2, Engine engine) {
        if (this.var_aaa_a != null && this.var_aaa_a.aab_a().boolean_a()) {
            this.h.b(f2, engine);
            this.var_aaa_a.b(f2, engine);
        }
    }

    public aab a(int n2) {
        aab aab2 = null;
        Iterator iterator = ((Array)((Object)this.var_ayh_a)).iterator();
        while (iterator.hasNext()) {
            aab aab3 = (aab)iterator.next();
            if (aab3.zz_a().int_a() != n2) continue;
            aab2 = aab3;
            break;
        }
        return aab2;
    }

    public aaa aaa_a() {
        return this.var_aaa_a;
    }

    @Override
    public void void_b() {
        this.var_ayh_a = (ayh)true;
        ((Engine)((Object)this.var_ayh_a)).var_z_a.void_a(new PUB_TOURNAMENT_LIST_REQUEST());
        this.f();
    }

    @Override
    public void void_c() {
        this.var_ayh_a = (ayh)false;
    }

    public Map<String, ayh> a() {
        return this.var_ayh_a;
    }

    static /* synthetic */ aab aab_a(aaf aaf2) {
        return aaf2.var_aab_a;
    }

    static /* synthetic */ Dialog a(aaf aaf2, Dialog dialog) {
        aaf2.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a = dialog;
        return aaf2.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a;
    }

    static /* synthetic */ SelectBox com_badlogic_gdx_scenes_scene2d_ui_SelectBox_a(aaf aaf2) {
        return aaf2.var_ayh_a;
    }

    static /* synthetic */ Dialog com_badlogic_gdx_scenes_scene2d_ui_Dialog_a(aaf aaf2) {
        return aaf2.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a;
    }

    static /* synthetic */ aaa a(aaf aaf2, aaa aaa2) {
        aaf2.var_aaa_a = aaa2;
        return aaf2.var_aaa_a;
    }

    static /* synthetic */ ayh ayh_a(aaf aaf2) {
        return aaf2.var_ayh_e;
    }

    static /* synthetic */ ayh b(aaf aaf2) {
        return aaf2.f;
    }

    static /* synthetic */ ayh c(aaf aaf2) {
        return aaf2.g;
    }

    static /* synthetic */ ayf ayf_a(aaf aaf2) {
        return aaf2.var_ayf_b;
    }

    static /* synthetic */ aaa aaa_a(aaf aaf2) {
        return aaf2.var_aaa_a;
    }
}

