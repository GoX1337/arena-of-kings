/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Array;

public class azl<T>
implements axr {
    public Array<T> var_com_badlogic_gdx_utils_Array_T__a = new Array();
    public ayh var_ayh_a;
    public ayh var_ayh_b;
    protected int var_int_a = 5;
    protected int var_int_b = 0;

    public void a(TextureAtlas textureAtlas, String string, String string2, int n2, int n3) {
        this.var_ayh_a = new ayh(textureAtlas.createSprite(string));
        this.var_ayh_b = new ayh(textureAtlas.createSprite(string2));
        this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(n2, n3);
        this.var_ayh_b.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(n2, n3);
    }

    @Override
    public void a(float f2, Engine engine) {
    }

    @Override
    public void b(float f2, Engine engine) {
        if (this.var_com_badlogic_gdx_utils_Array_T__a != null) {
            for (Object e2 : this.var_com_badlogic_gdx_utils_Array_T__a) {
                ((axr)e2).b(f2, engine);
            }
        }
        this.var_ayh_a.b(f2, engine);
        this.var_ayh_b.b(f2, engine);
    }

    public void a() {
        Engine.a("items: " + this.var_com_badlogic_gdx_utils_Array_T__a.size);
        Engine.a("PRE down bottom: " + this.var_int_a + " top: " + this.var_int_b);
        if (this.var_int_a < this.var_com_badlogic_gdx_utils_Array_T__a.size) {
            ++this.var_int_a;
            ++this.var_int_b;
            Engine.a("down bottom: " + this.var_int_a + " top: " + this.var_int_b);
        }
    }

    public void b() {
        Engine.a("PRE up bottom: " + this.var_int_a + " top: " + this.var_int_b);
        if (this.var_int_b > 0) {
            --this.var_int_a;
            --this.var_int_b;
            Engine.a("up bottom: " + this.var_int_a + " top: " + this.var_int_b);
        }
    }

    public Array<T> a() {
        return this.var_com_badlogic_gdx_utils_Array_T__a;
    }
}

