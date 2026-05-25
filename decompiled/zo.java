/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;

public class zo
implements axr {
    private final Engine var_com_arenaofkings_client_core_Engine_a;
    private final Stage var_com_badlogic_gdx_scenes_scene2d_Stage_a;
    private final axm var_axm_a;
    private final String var_java_lang_String_a;
    private final String var_java_lang_String_b;
    private String var_java_lang_String_c;
    private int var_int_a = -1;
    private int var_int_b = 0;
    private int var_int_c = 0;
    private ayh var_ayh_a;
    private ayh var_ayh_b;
    private ayh var_ayh_c;
    private ayh var_ayh_d;
    private ayh var_ayh_e;
    private ayf var_ayf_a;
    private ayf var_ayf_b;
    private int var_int_d;
    private ao var_ao_a;
    private boolean var_boolean_a = true;
    private int var_int_e;
    private int f;
    private Dialog var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a;
    private TextField var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a;
    private boolean var_boolean_b = false;
    private boolean var_boolean_c = false;
    private boolean var_boolean_d = false;
    private boolean var_boolean_e;

    public zo(Engine engine, Stage stage, axm axm2, int n2, int n3, int n4, String string, String string2, int n5, int n6, String string3, String string4, String string5, int n7) {
        Engine.b("teambanner 1 " + string + "  " + string2);
        this.var_com_arenaofkings_client_core_Engine_a = engine;
        this.var_com_badlogic_gdx_scenes_scene2d_Stage_a = stage;
        this.var_axm_a = axm2;
        this.var_java_lang_String_a = string;
        this.var_java_lang_String_b = string2;
        this.var_int_e = n2;
        this.f = n3;
        TextureAtlas textureAtlas = axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.jd);
        TextureAtlas textureAtlas2 = axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.je);
        TextureAtlas textureAtlas3 = axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.i);
        Engine.b("teambanner 2");
        this.var_int_c = n4;
        this.var_int_d = n7;
        this.var_ao_a = ao.a(n7);
        Engine.b("teambanner 3");
        this.var_ayh_d = new ayh(n2 + 10, n3 + 36, textureAtlas, this.var_ao_a.name(), true);
        Engine.b("teambanner 4");
        this.var_ayh_c = new ayh(n2, n3, textureAtlas3, "base_banner", true);
        Engine.b("teambanner 5");
        this.var_ayh_b = new ayh(n2 + 3, n3 + 2, textureAtlas3, string3, true);
        Engine.b("teambanner 6");
        Engine.b("country: " + string4);
        this.var_java_lang_String_c = string4;
        this.var_ayh_e = new ayh(n2 + 250, n3 + 50, textureAtlas2, string4, true);
        this.var_ayh_e.com_badlogic_gdx_graphics_g2d_Sprite_a().scale(-0.35f);
        Engine.b("teambanner 7");
        if (!string5.equals("")) {
            // empty if block
        }
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a = new TextField("", engine.var_com_badlogic_gdx_scenes_scene2d_ui_Skin_a);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.setAlignment(1);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.setFocusTraversal(true);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.setMaxLength(15);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.setWidth(350.0f);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.setPosition(730.0f, 625.0f);
        TextField.TextFieldStyle textFieldStyle = new TextField.TextFieldStyle(this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.getStyle());
        textFieldStyle.font = engine.o;
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.setStyle(textFieldStyle);
        this.var_ayf_b = new zp(this, n2 + 290, n3 + 92, textureAtlas3, "x_button_default", "x_button_hovered", true, engine, string, string2, stage);
        this.var_ayf_a = new zr(this, n2 + 5, n3 + 4, textureAtlas3, "plus_default", "plus_hovered", true, engine, string, stage);
    }

    @Override
    public void a(float f2, Engine engine) {
    }

    @Override
    public void b(float f2, Engine engine) {
        if (this.var_boolean_a) {
            this.var_ayh_b.b(f2, engine);
            this.var_ayh_c.b(f2, engine);
            this.var_ayh_d.b(f2, engine);
            if (this.var_boolean_d) {
                engine.a(this.var_java_lang_String_a, engine.var_axy_c.a(), Color.SKY, engine.var_axy_c.a(), Color.BLACK, (float)(this.var_int_e + 89), (float)(this.f + 112), 8, 1);
                if (!this.var_java_lang_String_b.equals("")) {
                    this.var_ayh_e.b(f2, engine);
                    engine.a("[" + this.var_java_lang_String_b + "]", engine.var_axy_c.a(), Color.SKY, engine.var_axy_c.a(), Color.BLACK, (float)(this.var_int_e + 89), (float)(this.f + 92), 8, 1);
                }
                if (this.var_int_a > 0) {
                    engine.a("Rank: " + this.var_int_a, engine.var_axy_c.a(), Color.SKY, engine.var_axy_c.a(), Color.BLACK, (float)(this.var_int_e + 89), (float)(this.f + 72), 8, 1);
                }
                if (this.var_boolean_e) {
                    engine.a("Estimated MMR: " + this.var_int_c, engine.var_axy_c.a(), Color.SKY, engine.var_axy_c.a(), Color.BLACK, (float)(this.var_int_e + 89), (float)(this.f + 52), 8, 1);
                } else {
                    engine.a("Unranked", engine.var_axy_c.a(), Color.SKY, engine.var_axy_c.a(), Color.BLACK, (float)(this.var_int_e + 89), (float)(this.f + 52), 8, 1);
                }
            } else {
                engine.a(this.var_java_lang_String_a, engine.var_axy_c.a(), Color.SALMON, engine.var_axy_c.a(), Color.BLACK, (float)(this.var_int_e + 89), (float)(this.f + 112), 8, 1);
                if (!this.var_java_lang_String_b.equals("")) {
                    this.var_ayh_e.b(f2, engine);
                    engine.a("[" + this.var_java_lang_String_b + "]", engine.var_axy_c.a(), Color.SALMON, engine.var_axy_c.a(), Color.BLACK, (float)(this.var_int_e + 89), (float)(this.f + 92), 8, 1);
                }
                if (this.var_int_a > 0) {
                    engine.a("Rank: " + this.var_int_a, engine.var_axy_c.a(), Color.SALMON, engine.var_axy_c.a(), Color.BLACK, (float)(this.var_int_e + 89), (float)(this.f + 72), 8, 1);
                }
                if (this.var_boolean_e) {
                    engine.a("Estimated MMR: " + this.var_int_c, engine.var_axy_c.a(), Color.SALMON, engine.var_axy_c.a(), Color.BLACK, (float)(this.var_int_e + 89), (float)(this.f + 52), 8, 1);
                } else {
                    engine.a("Unranked", engine.var_axy_c.a(), Color.SALMON, engine.var_axy_c.a(), Color.BLACK, (float)(this.var_int_e + 89), (float)(this.f + 52), 8, 1);
                }
            }
            if (!this.var_boolean_b && !this.var_java_lang_String_b.equals("")) {
                this.var_ayf_b.a(f2, engine);
                this.var_ayf_b.b(f2, engine);
                this.var_ayf_a.a(f2, engine);
                this.var_ayf_a.b(f2, engine);
            }
            if (this.var_ayh_a != null) {
                this.var_ayh_a.b(f2, engine);
            }
        }
    }

    public void c(float f2, Engine engine) {
        if (this.var_boolean_a) {
            this.var_ayh_b.b(f2, engine);
            this.var_ayh_c.b(f2, engine);
            this.var_ayh_d.b(f2, engine);
            engine.a(this.var_java_lang_String_a, engine.var_axy_c.a(), Color.WHITE, engine.var_axy_c.a(), Color.BLACK, (float)(this.var_int_e + 89), (float)(this.f + 112), 8, 1);
            if (!this.var_java_lang_String_b.equals("")) {
                this.var_ayh_e.b(f2, engine);
                engine.a("[" + this.var_java_lang_String_b + "]", engine.var_axy_c.a(), Color.WHITE, engine.var_axy_c.a(), Color.BLACK, (float)(this.var_int_e + 89), (float)(this.f + 92), 8, 1);
            }
            if (this.var_int_a > 0) {
                engine.a("Rank: " + this.var_int_a, engine.var_axy_c.a(), Color.WHITE, engine.var_axy_c.a(), Color.BLACK, (float)(this.var_int_e + 89), (float)(this.f + 72), 8, 1);
            }
            engine.a("Estimated MMR: " + this.var_int_c, engine.var_axy_c.a(), Color.WHITE, engine.var_axy_c.a(), Color.BLACK, (float)(this.var_int_e + 89), (float)(this.f + 52), 8, 1);
            if (this.var_ayh_a != null) {
                this.var_ayh_a.b(f2, engine);
            }
        }
    }

    public void a(boolean bl2) {
        this.var_boolean_b = bl2;
    }

    public void b(boolean bl2) {
        this.var_boolean_c = bl2;
    }

    public void a(int n2) {
        this.var_int_c = n2;
    }

    public String a() {
        return this.var_java_lang_String_a;
    }

    public void c(boolean bl2) {
        this.var_boolean_d = bl2;
    }

    public void d(boolean bl2) {
        this.var_boolean_e = bl2;
    }

    static /* synthetic */ Dialog a(zo zo2, Dialog dialog) {
        zo2.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a = dialog;
        return zo2.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a;
    }

    static /* synthetic */ TextField com_badlogic_gdx_scenes_scene2d_ui_TextField_a(zo zo2) {
        return zo2.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a;
    }

    static /* synthetic */ Dialog com_badlogic_gdx_scenes_scene2d_ui_Dialog_a(zo zo2) {
        return zo2.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a;
    }
}

