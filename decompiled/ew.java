/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class ew
implements axr {
    private ayf var_ayf_a;
    private String var_java_lang_String_a;
    private int var_int_a;
    private Table var_com_badlogic_gdx_scenes_scene2d_ui_Table_a;

    public ew() {
    }

    public ew(String string, int n2) {
        this.var_java_lang_String_a = string;
        this.var_int_a = n2;
    }

    public String a() {
        return this.var_java_lang_String_a;
    }

    public void a(String string) {
        this.var_java_lang_String_a = string;
    }

    public void a(Engine engine, boolean bl2) {
        if (this.var_ayf_a == null || bl2) {
            TextureAtlas textureAtlas = null;
            if (t.a(we.class, engine)) {
                textureAtlas = engine.axc_a().axm_a().com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c);
            } else if (t.a(agd.class, engine)) {
                textureAtlas = engine.axc_a().axm_a().com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.e);
            }
            this.var_ayf_a = new ex(this, 0, 0, textureAtlas, "channel_players_backdrop_default", "channel_players_backdrop_hovered", true, engine);
        }
    }

    @Override
    public void a(float f2, Engine engine) {
        we we2;
        this.a(engine, false);
        this.var_ayf_a.a(f2, engine);
        if (this.var_com_badlogic_gdx_scenes_scene2d_ui_Table_a != null && t.a(we.class, engine) && (we2 = (we)engine.axc_a()).wh_a().com_badlogic_gdx_scenes_scene2d_ui_Table_a() == this.var_com_badlogic_gdx_scenes_scene2d_ui_Table_a) {
            this.var_ayf_a.b(true);
        }
    }

    @Override
    public void b(float f2, Engine engine) {
        this.a(f2, engine);
        this.var_ayf_a.b(f2, engine);
        engine.a(this.var_java_lang_String_a, engine.l, Color.WHITE, engine.l, Color.BLACK, 1203.0f, 281.0f, 1, 1);
    }

    public void a(float f2, Engine engine, int n2) {
        this.var_int_a = n2;
        if (this.var_ayf_a != null) {
            this.var_ayf_a.a(1319.0f, 260 - n2 * 28);
        }
        this.a(f2, engine);
        this.var_ayf_a.b(f2, engine);
        engine.a(this.var_java_lang_String_a, engine.l, Color.WHITE, engine.l, Color.BLACK, 1430.0f, (float)(278 - n2 * 28), 1, 1);
    }

    static /* synthetic */ Table a(ew ew2, Table table) {
        ew2.var_com_badlogic_gdx_scenes_scene2d_ui_Table_a = table;
        return ew2.var_com_badlogic_gdx_scenes_scene2d_ui_Table_a;
    }

    static /* synthetic */ Table com_badlogic_gdx_scenes_scene2d_ui_Table_a(ew ew2) {
        return ew2.var_com_badlogic_gdx_scenes_scene2d_ui_Table_a;
    }

    static /* synthetic */ String java_lang_String_a(ew ew2) {
        return ew2.var_java_lang_String_a;
    }

    static /* synthetic */ int int_a(ew ew2) {
        return ew2.var_int_a;
    }
}

