/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Array;
import java.util.Iterator;

public class ajr
implements axr {
    private final TextureAtlas var_com_badlogic_gdx_graphics_g2d_TextureAtlas_a = new Array();
    private azt var_azt_a;
    private int var_int_a = 0;
    private Array<ajs> var_com_badlogic_gdx_utils_Array_ajs__a;

    public ajr(Engine engine, TextureAtlas textureAtlas) {
        this.var_com_badlogic_gdx_graphics_g2d_TextureAtlas_a = textureAtlas;
        this.var_azt_a = new azt("", engine.var_axy_c.a());
    }

    public void a(ajs ajs2) {
        ((Array)((Object)this.var_com_badlogic_gdx_graphics_g2d_TextureAtlas_a)).add(ajs2);
        this.var_int_a += ajs2.int_a();
        this.var_azt_a.a(String.valueOf(this.var_int_a));
    }

    @Override
    public void a(float f2, Engine engine) {
        this.var_azt_a.a(f2, engine);
    }

    public void a(float f2, Engine engine, float f3, float f4, Color color) {
        this.var_azt_a.a((int)f3, (int)f4);
        this.a(f2, engine);
        engine.a(this.var_azt_a.java_lang_String_a(), engine.var_axy_c.a(), color, engine.var_axy_c.a(), Color.BLACK, f3, f4, 1, 1);
    }

    public void b(float f2, Engine engine, float f3, float f4, Color color) {
        if (this.var_azt_a.boolean_a() && ((Array)((Object)this.var_com_badlogic_gdx_graphics_g2d_TextureAtlas_a)).size > 0) {
            int n2 = 0;
            Iterator iterator = ((Array)((Object)this.var_com_badlogic_gdx_graphics_g2d_TextureAtlas_a)).iterator();
            while (iterator.hasNext()) {
                ajs ajs2 = (ajs)iterator.next();
                int n3 = azu.a(engine, engine.var_axy_c.a(), ajs2.java_lang_String_a());
                if (n3 <= n2) continue;
                n2 = n3;
            }
            engine.var_azi_a.end();
            Gdx.gl.glEnable(3042);
            Gdx.gl.glBlendFunc(770, 771);
            engine.var_axf_a.begin();
            engine.var_axf_a.set(ShapeRenderer.ShapeType.Filled);
            engine.var_axf_a.b(f3 + 25.0f + (float)azu.a(engine, engine.var_axy_c.a(), String.valueOf(this.var_int_a)), f4 - (float)(((Array)((Object)this.var_com_badlogic_gdx_graphics_g2d_TextureAtlas_a)).size * 25), n2 + 40, ((Array)((Object)this.var_com_badlogic_gdx_graphics_g2d_TextureAtlas_a)).size * 25, 5.0f);
            engine.var_axf_a.end();
            Gdx.gl.glDisable(3042);
            engine.var_azi_a.begin();
            ((Array)((Object)this.var_com_badlogic_gdx_graphics_g2d_TextureAtlas_a)).sort();
            for (int i2 = 0; i2 < ((Array)((Object)this.var_com_badlogic_gdx_graphics_g2d_TextureAtlas_a)).size; ++i2) {
                engine.a(((ajs)((Array)((Object)this.var_com_badlogic_gdx_graphics_g2d_TextureAtlas_a)).get(i2)).java_lang_String_a(), engine.var_axy_c.a(), color, engine.var_axy_c.a(), Color.BLACK, f3 + 30.0f + (float)azu.a(engine, engine.var_axy_c.a(), String.valueOf(this.var_int_a)), f4 - 6.0f - (float)(25 * i2), 8, 1);
            }
        }
    }

    @Override
    public void b(float f2, Engine engine) {
    }
}

