/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class ayj
extends ayh {
    private final Engine var_com_arenaofkings_client_core_Engine_a;
    private String var_java_lang_String_a = "";
    private int var_int_a = 400;
    private int b;
    private int c;
    private boolean var_boolean_a = false;
    private boolean j = false;

    public ayj(Engine engine, int n2, int n3, String string, boolean bl2) {
        super(n2, n3, null, "", true);
        this.g = n2;
        this.h = n3;
        this.var_com_arenaofkings_client_core_Engine_a = engine;
        this.var_java_lang_String_a = string;
        this.j = bl2;
    }

    public ayj(Engine engine, int n2, int n3, String string, String string2, azn azn2, TextureAtlas textureAtlas) {
        super(n2, n3, textureAtlas, string2, true);
        this.g = n2;
        this.h = n3;
        this.var_com_arenaofkings_client_core_Engine_a = engine;
        this.var_java_lang_String_a = string;
        switch (azn2) {
            case var_azn_a: {
                ((Sprite)((Object)this.var_com_arenaofkings_client_core_Engine_a)).scale(-0.5f);
                break;
            }
            case b: {
                ((Sprite)((Object)this.var_com_arenaofkings_client_core_Engine_a)).scale(-0.25f);
                break;
            }
            case c: {
                break;
            }
        }
    }

    public ayj(Engine engine, int n2, int n3, String string, azn azn2, TextureAtlas textureAtlas) {
        super(n2, n3, textureAtlas, "Information", true);
        this.g = n2;
        this.h = n3;
        this.var_com_arenaofkings_client_core_Engine_a = engine;
        this.var_java_lang_String_a = string;
        switch (azn2) {
            case var_azn_a: {
                ((Sprite)((Object)this.var_com_arenaofkings_client_core_Engine_a)).scale(-0.5f);
                break;
            }
            case b: {
                ((Sprite)((Object)this.var_com_arenaofkings_client_core_Engine_a)).scale(-0.25f);
                break;
            }
            case c: {
                break;
            }
        }
    }

    public void d(int n2) {
        this.var_int_a = n2;
    }

    public void c(int n2, int n3) {
        this.b = n2;
        this.c = n3;
    }

    @Override
    public void void_a() {
        super.void_a();
        this.var_com_arenaofkings_client_core_Engine_a.var_azi_a.end();
        Gdx.gl.glEnable(3042);
        Gdx.gl.glBlendFunc(770, 771);
        this.var_com_arenaofkings_client_core_Engine_a.var_axf_a.begin();
        this.var_com_arenaofkings_client_core_Engine_a.var_axf_a.set(ShapeRenderer.ShapeType.Filled);
        int n2 = azu.a(this.var_com_arenaofkings_client_core_Engine_a, this.var_com_arenaofkings_client_core_Engine_a.var_axy_c.a(), this.var_java_lang_String_a);
        int n3 = -20;
        int n4 = -12;
        int n5 = 0;
        String string = azu.a(this.var_com_arenaofkings_client_core_Engine_a, this.var_com_arenaofkings_client_core_Engine_a.var_axy_c.a(), this.var_java_lang_String_a, this.var_int_a);
        int n6 = azu.b(this.var_com_arenaofkings_client_core_Engine_a, this.var_com_arenaofkings_client_core_Engine_a.var_axy_c.a(), string);
        this.var_com_arenaofkings_client_core_Engine_a.var_axf_a.b(this.g + this.b, this.h + this.c + 4, this.var_int_a + 25, (n6 += 26) + 36, 10.0f);
        this.var_com_arenaofkings_client_core_Engine_a.var_axf_a.end();
        Gdx.gl.glDisable(3042);
        this.var_com_arenaofkings_client_core_Engine_a.var_azi_a.begin();
        this.var_com_arenaofkings_client_core_Engine_a.a(string, this.var_com_arenaofkings_client_core_Engine_a.var_axy_c.a(), Color.WHITE, this.var_com_arenaofkings_client_core_Engine_a.var_axy_c.a(), Color.BLACK, this.g + this.b + (this.var_int_a + 25) / 2, this.h + this.c + (n6 += 25) + -20 * n5 + -12, 1);
    }

    @Override
    public void b(float f2, Engine engine) {
        if (this.j) {
            this.void_a();
        } else {
            super.b(f2, engine);
        }
    }
}

