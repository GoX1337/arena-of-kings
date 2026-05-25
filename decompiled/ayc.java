/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class ayc
extends ayf {
    protected Sprite var_com_badlogic_gdx_graphics_g2d_Sprite_a;
    protected boolean var_boolean_a;

    public ayc(int n2, int n3, TextureAtlas textureAtlas, String string, String string2, String string3, boolean bl2) {
        super(n2, n3, textureAtlas, string, string2, bl2);
        this.var_com_badlogic_gdx_graphics_g2d_Sprite_a = new Sprite(textureAtlas.createSprite(string3));
        this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.setPosition(n2, n3);
    }

    @Override
    public void a(float f2, Engine engine) {
        super.a(f2, engine);
    }

    @Override
    public void b(float f2, Engine engine) {
        if (!this.b && !this.var_boolean_a) {
            this.b.draw(engine.var_azi_a);
        } else if (this.b && !this.var_boolean_a) {
            this.c.draw(engine.var_azi_a);
        } else {
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.draw(engine.var_azi_a);
        }
    }

    @Override
    public void e() {
        this.c = Gdx.input.isButtonPressed(0) && Gdx.input.justTouched() && this.b && !this.var_boolean_a;
    }

    public void a(float f2) {
        this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.setScale(f2);
        this.c.setScale(f2);
        this.b.setScale(f2);
    }

    public void b(float f2) {
        this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.setAlpha(f2);
        this.c.setAlpha(f2);
        this.b.setAlpha(f2);
    }

    @Override
    public void a(float f2, float f3) {
        super.a(f2, f3);
        this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.setPosition(f2, f3);
    }
}

