/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;

public class aay
extends yf {
    private ayh var_ayh_b;
    private aye var_aye_a;
    private aye var_aye_b;
    private abc var_abc_a;
    private abd var_abd_a;
    private Slider var_com_badlogic_gdx_scenes_scene2d_ui_Slider_a;
    private ayh c;
    private ayh d;
    private boolean var_boolean_a;
    private ayh e;
    private ayh f;
    private boolean var_boolean_b;

    public aay(Engine engine, axm axm2, Stage stage) {
        super(402, 380, axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.b), "store_panel");
        this.a(engine, axm2, stage);
        this.var_aye_a = this.var_aye_b;
        this.var_abc_a = this.var_abd_a;
        this.var_com_badlogic_gdx_scenes_scene2d_ui_Slider_a = new Slider(0.0f, 100.0f, 1.0f, false, engine.var_com_badlogic_gdx_scenes_scene2d_ui_Skin_a);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_Slider_a.setValue(engine.var_aj_a.int_a(ai.S));
        engine.var_baa_a.a(this.var_com_badlogic_gdx_scenes_scene2d_ui_Slider_a.getValue() / 100.0f);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_Slider_a.setAnimateDuration(0.1f);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_Slider_a.setPosition(1130.0f, 625.0f);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_Slider_a.addListener(new aaz(this, engine));
        stage.addActor(this.var_com_badlogic_gdx_scenes_scene2d_ui_Slider_a);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_Slider_a.setVisible(false);
        TextureAtlas textureAtlas = axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c);
        this.d = new aba(this, 559, 813, textureAtlas, "mtx_box", true, engine);
        this.c = new ayh(562, 813, textureAtlas, "mtx_checkmark", true);
        this.f = new abb(this, 559, 743, textureAtlas, "mtx_box", true, engine);
        this.e = new ayh(562, 743, textureAtlas, "mtx_checkmark", true);
        this.var_boolean_a = engine.var_aj_a.boolean_a(ai.e);
        this.var_boolean_b = engine.var_aj_a.boolean_a(ai.f);
    }

    private void a(Engine engine, axm axm2, Stage stage) {
        TextureAtlas textureAtlas = axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c);
        this.var_abd_a = new abd(engine, axm2, stage, true);
        this.var_ayh_b = new ayh(600, 390, textureAtlas, "menu_divider", true);
        this.var_aye_b = new aye(411, 895, textureAtlas, "menu_hotkeys_unhovered", "menu_hotkeys_hovered", "menu_backdrop", true);
        this.var_aye_b.a(411, 907);
    }

    public abd a() {
        return this.var_abd_a;
    }

    @Override
    public void a(float f2, Engine engine) {
    }

    @Override
    public void b(float f2, Engine engine) {
        if (((ayh)((Object)this.var_aye_a)).boolean_b()) {
            super.b(f2, engine);
            this.var_aye_b.a(f2, engine);
            this.var_abc_a.b(f2, engine);
            this.d.a(f2, engine);
            this.d.b(f2, engine);
            this.d.b(f2, engine);
            if (this.var_boolean_a) {
                this.c.b(f2, engine);
            }
            this.f.a(f2, engine);
            this.f.b(f2, engine);
            this.f.b(f2, engine);
            if (this.var_boolean_b) {
                this.e.b(f2, engine);
            }
            engine.a("Regions", engine.var_axy_f.a(), Color.WHITE, engine.var_axy_f.a(), Color.BLACK, 520.0f, 945.0f, 1, 1);
            engine.a("Selecting multiple Regions\nspeeds up queue times", engine.var_axy_c.a(), Color.WHITE, engine.var_axy_c.a(), Color.BLACK, 520.0f, 906.0f, 1, 1);
            if (engine.var_ag_a.ab_a().int_a() <= 115) {
                engine.a("US-East", engine.var_axy_c.a(), Color.GREEN, engine.var_axy_c.a(), Color.BLACK, 450.0f, 845.0f, 8, 1);
                engine.a("Ping: " + engine.var_ag_a.ab_a().int_a() + "ms", engine.var_axy_c.a(), Color.GREEN, engine.var_axy_c.a(), Color.BLACK, 450.0f, 825.0f, 8, 1);
            } else if (engine.var_ag_a.ab_a().int_a() <= 175) {
                engine.a("US-East", engine.var_axy_c.a(), Color.YELLOW, engine.var_axy_c.a(), Color.BLACK, 450.0f, 845.0f, 8, 1);
                engine.a("Ping: " + engine.var_ag_a.ab_a().int_a() + "ms", engine.var_axy_c.a(), Color.YELLOW, engine.var_axy_c.a(), Color.BLACK, 450.0f, 825.0f, 8, 1);
            } else {
                engine.a("US-East", engine.var_axy_c.a(), Color.RED, engine.var_axy_c.a(), Color.BLACK, 450.0f, 845.0f, 8, 1);
                engine.a("Ping: " + engine.var_ag_a.ab_a().int_a() + "ms", engine.var_axy_c.a(), Color.RED, engine.var_axy_c.a(), Color.BLACK, 450.0f, 825.0f, 8, 1);
            }
            if (engine.var_ag_a.ab_a().int_a() <= 115) {
                engine.a("EU-West", engine.var_axy_c.a(), Color.GREEN, engine.var_axy_c.a(), Color.BLACK, 450.0f, 775.0f, 8, 1);
                engine.a("Ping: " + engine.var_ag_a.ab_a().b() + "ms", engine.var_axy_c.a(), Color.GREEN, engine.var_axy_c.a(), Color.BLACK, 450.0f, 755.0f, 8, 1);
            } else if (engine.var_ag_a.ab_a().int_a() <= 175) {
                engine.a("EU-West", engine.var_axy_c.a(), Color.YELLOW, engine.var_axy_c.a(), Color.BLACK, 450.0f, 775.0f, 8, 1);
                engine.a("Ping: " + engine.var_ag_a.ab_a().b() + "ms", engine.var_axy_c.a(), Color.YELLOW, engine.var_axy_c.a(), Color.BLACK, 450.0f, 755.0f, 8, 1);
            } else {
                engine.a("EU-West", engine.var_axy_c.a(), Color.RED, engine.var_axy_c.a(), Color.BLACK, 450.0f, 775.0f, 8, 1);
                engine.a("Ping: " + engine.var_ag_a.ab_a().b() + "ms", engine.var_axy_c.a(), Color.RED, engine.var_axy_c.a(), Color.BLACK, 450.0f, 755.0f, 8, 1);
            }
            engine.a("Volume", engine.var_axy_c.a(), Color.WHITE, engine.var_axy_c.a(), Color.BLACK, 1199.0f, 674.0f, 1, 1);
        }
    }

    @Override
    public void a(Stage stage) {
        super.a(stage);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_Slider_a.setVisible(true);
    }

    @Override
    public void b(Stage stage) {
        super.b(stage);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_Slider_a.setVisible(false);
    }

    static /* synthetic */ Slider com_badlogic_gdx_scenes_scene2d_ui_Slider_a(aay aay2) {
        return aay2.var_com_badlogic_gdx_scenes_scene2d_ui_Slider_a;
    }

    static /* synthetic */ boolean a(aay aay2, boolean bl2) {
        aay2.var_boolean_a = bl2;
        return aay2.var_boolean_a;
    }

    static /* synthetic */ boolean boolean_a(aay aay2) {
        return aay2.var_boolean_a;
    }

    static /* synthetic */ boolean b(aay aay2) {
        return aay2.var_boolean_b;
    }

    static /* synthetic */ boolean b(aay aay2, boolean bl2) {
        aay2.var_boolean_b = bl2;
        return aay2.var_boolean_b;
    }
}

