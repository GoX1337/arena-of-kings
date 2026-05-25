/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Array;
import java.util.HashMap;
import java.util.Map;

public class en
implements axr {
    private final Engine var_com_arenaofkings_client_core_Engine_a;
    private final ev var_ev_a;
    private boolean var_boolean_a;
    private ayf var_ayf_a;
    private String var_java_lang_String_a;
    private String var_java_lang_String_b;
    private String var_java_lang_String_c;
    private int var_int_c;
    private int d = 391;
    private int e = 275;
    private Array<g> var_com_badlogic_gdx_utils_Array_g__a;
    private Array<g> var_com_badlogic_gdx_utils_Array_g__b;
    private fd var_fd_a;
    private ayh var_ayh_a;
    private ayh var_ayh_b;
    private int f = 0;
    private ayi<String, ew> cfr_renamed_53;
    private boolean var_boolean_b = false;
    private azv var_azv_a = new azv(6000L, true);
    private da var_da_a;
    private da var_da_b;
    private Table var_com_badlogic_gdx_scenes_scene2d_ui_Table_a;
    private int g;
    private boolean var_boolean_c = false;
    private ayg var_ayg_a;
    int var_int_a = 0;
    int var_int_b = 10;

    public en(ev ev2, String string, int n2, fd fd2, Engine engine) {
        int n3;
        this.var_ev_a = ev2;
        this.var_com_arenaofkings_client_core_Engine_a = engine;
        this.var_java_lang_String_a = string;
        this.var_java_lang_String_b = string;
        this.var_int_c = n2;
        this.var_fd_a = fd2;
        this.var_com_arenaofkings_client_core_Engine_a = new ayi();
        this.var_com_arenaofkings_client_core_Engine_a = new Array(Engine.var_int_a);
        for (n3 = 0; n3 < Engine.var_int_a; ++n3) {
            ((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).add(new g("", g.a(), engine.k, engine));
        }
        this.var_java_lang_String_b = new Array(Engine.var_int_a);
        for (n3 = 0; n3 < Engine.var_int_a; ++n3) {
            ((Array)((Object)this.var_java_lang_String_b)).add(new g("", g.a(), engine.k, engine));
        }
        this.d(string);
        this.var_ayg_a = new ayg(1320, 10, 1543, 292);
        Engine.a("new channel: " + string + " " + this.var_java_lang_String_c);
    }

    public void a(TextureAtlas textureAtlas) {
        this.var_ayf_a = new eo(this, this.d, this.e - 14 - 31 * this.var_int_c, textureAtlas, "channel_backdrop", "channel_backdrop_hovered", true);
        this.var_ayh_a = new ayh(this.d, this.e, textureAtlas, "channel_notification_bubble", true);
        this.var_ayh_b = new ayh(this.d, this.e, textureAtlas, "channel_notification_bubble", true);
        this.var_ayh_b.com_badlogic_gdx_graphics_g2d_Sprite_a().setColor(Color.GOLD);
        this.var_da_a = new da(ajw.jg, "GCD_Flash", 0, 45, 0.02f, 0.0f, Animation.PlayMode.NORMAL, -65, -65);
        this.var_da_a.d(-0.55f);
        this.var_da_a.a(this.var_com_arenaofkings_client_core_Engine_a.axc_a().axm_a(), false, true);
        this.var_da_a.a((float)this.d, this.e);
        this.var_da_b = new da(ajw.jg, "GCD_Flash", 15, 45, 0.02f, 0.0f, Animation.PlayMode.LOOP, -65, -65);
        this.var_da_b.d(-0.55f);
        this.var_da_b.a(this.var_com_arenaofkings_client_core_Engine_a.axc_a().axm_a(), false, true);
        this.var_da_b.a((float)this.d, this.e);
        this.var_boolean_a = true;
        this.var_boolean_b = true;
    }

    private void d(String string) {
        if (this.var_int_c != 0) {
            this.var_java_lang_String_c = "[" + this.var_int_c + "]" + string.substring(0, Math.min(string.length(), 13));
        }
    }

    public String java_lang_String_a() {
        return this.var_java_lang_String_a;
    }

    public int int_a() {
        return this.var_int_c;
    }

    public void a(int n2) {
        this.var_int_c = n2;
    }

    @Override
    public void a(float f2, Engine engine) {
        this.var_ayg_a.b(engine);
        if (this.var_ayf_a != null) {
            this.var_ayf_a.a(f2, engine);
        }
        if (ay.ay_a().gd_a().ev_a().b() == this) {
            if (this.var_ayf_a != null) {
                this.var_ayf_a.b(true);
            }
            this.e();
        } else {
            this.f();
        }
    }

    public void a(float f2, Engine engine, int n2) {
        if (!this.var_boolean_b) {
            ((we)engine.axc_a()).b();
        }
        if (this.var_ayh_a == null) {
            return;
        }
        this.g = n2;
        this.a(f2, engine);
        if (this.var_ayf_a != null) {
            this.var_ayf_a.a((float)(this.d - 12), this.e - 16 - 31 * n2);
            this.var_ayf_a.b(f2, engine, this.d - 12, this.e - 16 - 31 * n2);
        }
        if (this.var_fd_a == fd.e) {
            engine.l.setColor(axe.N);
        }
        if (this.var_fd_a == fd.c) {
            engine.a(this.var_java_lang_String_b, engine.l, axe.J, engine.l, Color.BLACK, (float)(this.d + 14), (float)(this.e + 4 - 32 * n2), 8, 1);
        } else {
            engine.a(this.var_java_lang_String_b, engine.l, axe.N, engine.l, Color.BLACK, (float)(this.d + 14), (float)(this.e + 4 - 32 * n2), 8, 1);
        }
        if (this.f == 0) {
            this.var_ayh_a.b(f2, engine, this.d + 127, this.e - 12 - 31 * n2);
        } else {
            if (this.var_da_b != null) {
                this.var_da_b.a(f2, engine);
                this.var_da_b.d(f2, this.d + 239, this.e + 53 - 31 * n2, engine.var_azi_a);
                if (this.var_azv_a.boolean_b()) {
                    this.var_azv_a.void_c();
                    this.var_da_a.void_a();
                }
                if (!this.var_da_a.a().isAnimationFinished(this.var_da_a.float_a())) {
                    this.var_da_a.a(f2, engine);
                    this.var_da_a.d(f2, this.d + 239, this.e + 53 - 31 * n2, engine.var_azi_a);
                }
            }
            this.var_ayh_b.b(f2, engine, this.d + 127, this.e - 12 - 31 * n2);
        }
        if (this.f >= 99) {
            engine.a("99+", engine.l, Color.WHITE, engine.l, Color.BLACK, (float)(this.d + 142), (float)(this.e + 4 - 32 * n2), 1, 1);
        } else if (this.f > 0) {
            engine.a(String.valueOf(this.f), engine.l, Color.WHITE, engine.l, Color.BLACK, (float)(this.d + 142), (float)(this.e + 4 - 32 * n2), 1, 1);
        }
        if (this.boolean_b()) {
            if (((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).size() <= 10) {
                this.var_int_b = ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).size();
            }
            if (this.var_int_b >= 10) {
                int n3 = this.var_int_b - 10;
                int n4 = 0;
                for (int i2 = this.var_int_a; i2 < this.var_int_b; ++i2) {
                    int n5 = i2 - n3;
                    if (((ayi)((Object)this.var_com_arenaofkings_client_core_Engine_a)).a(i2) != null) {
                        ((ew)((ayi)((Object)this.var_com_arenaofkings_client_core_Engine_a)).a(i2)).a(f2, engine, n5);
                    }
                    ++n4;
                }
            } else {
                int n6 = 0;
                for (int i3 = this.var_int_a; i3 < ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).size(); ++i3) {
                    if (((ayi)((Object)this.var_com_arenaofkings_client_core_Engine_a)).a(i3) != null) {
                        ((ew)((ayi)((Object)this.var_com_arenaofkings_client_core_Engine_a)).a(i3)).a(f2, engine, n6);
                    }
                    ++n6;
                }
            }
        }
        engine.l.setColor(Color.WHITE);
    }

    public void void_a() {
        if (this.var_int_b < ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).size()) {
            ++this.var_int_b;
            ++this.var_int_a;
        }
    }

    public void void_b() {
        if (this.var_int_a > 0) {
            --this.var_int_b;
            --this.var_int_a;
        }
    }

    public boolean boolean_a() {
        return this.var_boolean_c && (this.var_fd_a == fd.c || this.var_fd_a == fd.e) || this.var_fd_a == fd.c && this.var_ayf_a != null && this.var_ayf_a.boolean_b() && this.var_ayf_a.boolean_a() && Gdx.input.isKeyPressed(129);
    }

    public boolean boolean_b() {
        return this == ay.ay_a().gd_a().ev_a().b();
    }

    @Override
    public void b(float f2, Engine engine) {
    }

    public Array<g> a() {
        return this.var_java_lang_String_b;
    }

    public fd fd_a() {
        return this.var_fd_a;
    }

    public void void_c() {
        ++this.f;
    }

    public void d() {
        this.f = 0;
    }

    public void a(ew ew2) {
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(ew2.a(), ew2);
        Engine.b("addChannelPlayer " + ew2.a());
    }

    public void a(String string) {
        ew ew2 = new ew(string, ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).size());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(ew2.a(), ew2);
        Engine.b("addChannelPlayer " + ew2.a());
    }

    public void b(String string) {
        if (((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).containsKey(string)) {
            ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).remove(string);
            Engine.b("removeChannelPlayer " + string);
        }
    }

    public Map<String, ew> a() {
        return this.var_com_arenaofkings_client_core_Engine_a;
    }

    public int int_b() {
        if (t.a(agd.class, this.var_com_arenaofkings_client_core_Engine_a)) {
            return this.d - 443;
        }
        return this.d;
    }

    public int int_c() {
        if (t.a(agd.class, this.var_com_arenaofkings_client_core_Engine_a)) {
            return this.e + 100;
        }
        return this.e;
    }

    public void e() {
        for (int i2 = 0; i2 < ((Array)((Object)this.var_java_lang_String_b)).size; ++i2) {
            g g2 = (g)((Array)((Object)this.var_java_lang_String_b)).get(i2);
            for (int i3 = 0; i3 < g2.var_int_a.size(); ++i3) {
                ((d)g2.var_int_a.get(i3)).setVisible(true);
            }
        }
    }

    public void f() {
        for (int i2 = 0; i2 < ((Array)((Object)this.var_java_lang_String_b)).size; ++i2) {
            g g2 = (g)((Array)((Object)this.var_java_lang_String_b)).get(i2);
            for (int i3 = 0; i3 < g2.var_int_a.size(); ++i3) {
                ((d)g2.var_int_a.get(i3)).setVisible(false);
            }
        }
    }

    public void c(String string) {
        this.var_java_lang_String_b = string;
    }

    public String java_lang_String_b() {
        return this.var_java_lang_String_b;
    }

    public boolean boolean_c() {
        return this.var_ayg_a.boolean_e();
    }

    static /* synthetic */ String java_lang_String_a(en en2) {
        return en2.var_java_lang_String_a;
    }

    static /* synthetic */ ev ev_a(en en2) {
        return en2.var_ev_a;
    }

    static /* synthetic */ Engine com_arenaofkings_client_core_Engine_a(en en2) {
        return en2.var_com_arenaofkings_client_core_Engine_a;
    }

    static /* synthetic */ fd fd_a(en en2) {
        return en2.var_fd_a;
    }

    static /* synthetic */ int int_a(en en2) {
        return en2.var_int_c;
    }

    static /* synthetic */ String java_lang_String_b(en en2) {
        return en2.var_java_lang_String_b;
    }

    static /* synthetic */ Table a(en en2, Table table) {
        en2.var_com_badlogic_gdx_scenes_scene2d_ui_Table_a = table;
        return en2.var_com_badlogic_gdx_scenes_scene2d_ui_Table_a;
    }

    static /* synthetic */ Table com_badlogic_gdx_scenes_scene2d_ui_Table_a(en en2) {
        return en2.var_com_badlogic_gdx_scenes_scene2d_ui_Table_a;
    }

    static /* synthetic */ boolean a(en en2, boolean bl2) {
        en2.var_boolean_c = bl2;
        return en2.var_boolean_c;
    }

    static /* synthetic */ int int_b(en en2) {
        return en2.g;
    }
}

