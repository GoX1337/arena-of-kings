/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import java.util.ArrayList;
import java.util.List;

public class g {
    private static int b = 0;
    public int var_int_a;
    public String var_java_lang_String_a;
    public BitmapFont var_com_badlogic_gdx_graphics_g2d_BitmapFont_a;
    public List<d> var_java_util_List_d__a;

    public g(String string, int n2, BitmapFont bitmapFont, Engine engine) {
        this.var_int_a = (int)new ArrayList(1);
        this.var_int_a.add(new d(string, engine.var_com_badlogic_gdx_scenes_scene2d_ui_Label$LabelStyle_a, null, engine));
        this.var_java_lang_String_a = string;
        this.var_int_a = n2;
        this.var_com_badlogic_gdx_graphics_g2d_BitmapFont_a = bitmapFont;
    }

    public g(String string, List<d> list, int n2, BitmapFont bitmapFont) {
        this.var_java_lang_String_a = string;
        this.var_int_a = (int)list;
        this.var_int_a = n2;
        this.var_com_badlogic_gdx_graphics_g2d_BitmapFont_a = bitmapFont;
    }

    public static int a() {
        return ++b;
    }

    public static int b() {
        return b;
    }

    public List<d> a() {
        return this.var_int_a;
    }

    public String toString() {
        return "this.ID = " + this.var_int_a + " this.row_text = " + this.var_java_lang_String_a + " NEXT_ID = " + b;
    }

    public void a(BitmapFont bitmapFont) {
        this.var_com_badlogic_gdx_graphics_g2d_BitmapFont_a = bitmapFont;
    }
}

