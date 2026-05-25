/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.chat.Chat;
import com.arenaofkings.client.core.Engine;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Array;

public class i
extends Chat {
    private ayh var_ayh_a;
    private ayh var_ayh_b;
    private ayh c;
    private azv var_azv_a = new azv(5000L, true);
    private float var_float_b = 1.0f;

    public i(Engine engine, axm axm2, Skin skin, int n2, Stage stage, int n3, int n4, int n5, int n6) {
        super(engine, axm2, engine.m, skin, n2, stage, n3, n4, n5, n6, 10, 100);
        Engine.a("playChat 1");
        TextureAtlas textureAtlas = axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.e);
        this.var_ayh_a = new ayh(110, 149, textureAtlas, "chatframeLarge", true);
        this.var_ayh_b = new ayh((int)this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getX(), (int)this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getY() - 19, textureAtlas, "sendframe_empty", false);
        this.c = new ayh((int)this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getX(), (int)this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getY() - 19, textureAtlas, "sendframe_withprompt", true);
        ((Actor)((Object)this.var_ayh_a)).addListener(new j(this));
        Engine.a("playChat 2");
        this.e = 522;
        this.f = 19;
        this.g = (int)this.c.com_badlogic_gdx_graphics_g2d_Sprite_a().getX();
        this.h = (int)this.c.com_badlogic_gdx_graphics_g2d_Sprite_a().getY();
        this.var_ayh_b = (ayh)this.e;
        this.var_ayh_a = (ayh)false;
        this.void_b();
        Engine.a("playChat 3");
        ay.ay_a().gd_a().ev_a().void_a("Game");
        this.var_ayh_a = ay.ay_a().gd_a().ev_a().b();
        this.var_ayh_b = "/p ";
        this.void_e();
        en en2 = ay.ay_a().gd_a().ev_a().en_a("Game");
        this.var_ayh_a = fd.b;
        Engine.a("playChat 4");
        this.a(engine, en2, "Party", -1);
        Engine.a("playChat 5");
        ((axh)((Object)this.var_ayh_a)).setDisabled(true);
    }

    @Override
    public void a(Engine engine) {
        if (((Stage)((Object)this.var_ayh_a)).getKeyboardFocus() != this.var_ayh_a || !(this.var_float_b > 0.0f)) {
            return;
        }
        if (engine.var_com_badlogic_gdx_math_Vector3_a.x >= (float)this.i && engine.var_com_badlogic_gdx_math_Vector3_a.x <= (float)this.k && engine.var_com_badlogic_gdx_math_Vector3_a.y >= (float)this.j && engine.var_com_badlogic_gdx_math_Vector3_a.y <= (float)this.l) {
            this.var_ayh_b = (ayh)true;
            this.a_();
        } else {
            this.var_ayh_b = (ayh)false;
            this.b_();
        }
    }

    @Override
    public void a(Array<g> array, String string, String string2, BitmapFont bitmapFont) {
        super.a(array, string, string2, bitmapFont);
        this.l();
    }

    public void l() {
        this.var_float_b = 1.0f;
        this.var_ayh_a.a(true);
        if (!this.var_ayh_b.boolean_b() && !this.c.boolean_b()) {
            this.var_ayh_b.a(false);
            this.c.a(true);
        }
        this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().setAlpha(this.var_float_b);
        this.var_ayh_b.com_badlogic_gdx_graphics_g2d_Sprite_a().setAlpha(this.var_float_b);
        this.c.com_badlogic_gdx_graphics_g2d_Sprite_a().setAlpha(this.var_float_b);
        this.var_azv_a.void_c();
    }

    public void m() {
        this.a(this.e);
        this.void_d();
    }

    @Override
    public void b(float f2, Engine engine) {
        this.a(f2, engine);
        if (((Stage)((Object)this.var_ayh_a)).getKeyboardFocus() == this.var_ayh_a) {
            this.var_azv_a.void_c();
        } else if (this.var_azv_a.boolean_b() && this.var_ayh_a.boolean_b()) {
            this.var_float_b -= f2;
            if (this.var_float_b <= 0.0f) {
                this.var_float_b = 0.0f;
                this.var_ayh_a.a(false);
                this.var_ayh_b.a(false);
                this.c.a(false);
                ((axh)((Object)this.var_ayh_a)).setDisabled(true);
            } else {
                this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().setAlpha(this.var_float_b);
                this.var_ayh_b.com_badlogic_gdx_graphics_g2d_Sprite_a().setAlpha(this.var_float_b);
                this.c.com_badlogic_gdx_graphics_g2d_Sprite_a().setAlpha(this.var_float_b);
            }
        }
        if (!engine.var_aj_a.boolean_a(ai.U)) {
            System.out.println("Render frame");
            this.var_ayh_a.b(f2, engine);
            this.var_ayh_b.b(f2, engine);
            this.c.b(f2, engine);
        }
        for (Actor actor : ((Stage)((Object)this.var_ayh_a)).getActors()) {
            if (!(actor instanceof d)) continue;
            ((d)actor).setColor(actor.getColor().r, actor.getColor().g, actor.getColor().b, this.var_float_b);
        }
        this.var_ayh_a = !((axh)((Object)this.var_ayh_a)).isDisabled() ? (Object)true : (ayh)false;
        if (((Actor)((Object)this.var_ayh_a)).isVisible() && this.var_ayh_a != false && this.var_ayh_a != null) {
            switch (k.a[((Enum)((Object)this.var_ayh_a)).ordinal()]) {
                case 1: {
                    engine.a((String)((Object)this.var_ayh_a), (BitmapFont)((Object)this.var_ayh_b), axe.N, (BitmapFont)((Object)this.var_ayh_b), Color.BLACK, this.g + 3, this.h + 15, 8, 0, this.var_float_b);
                    break;
                }
                case 2: {
                    engine.a("Say:  ", (BitmapFont)((Object)this.var_ayh_b), axe.H, (BitmapFont)((Object)this.var_ayh_b), Color.BLACK, this.g + 3, this.h + 15, 8, 0, this.var_float_b);
                    break;
                }
                case 3: {
                    engine.a("Party:  ", (BitmapFont)((Object)this.var_ayh_b), axe.I, (BitmapFont)((Object)this.var_ayh_b), Color.BLACK, this.g + 3, this.h + 15, 8, 0, this.var_float_b);
                    break;
                }
                case 4: {
                    engine.a((String)((Object)this.var_ayh_a), (BitmapFont)((Object)this.var_ayh_b), axe.J, (BitmapFont)((Object)this.var_ayh_b), Color.BLACK, this.g + 3, this.h + 15, 8, 0, this.var_float_b);
                    break;
                }
                case 5: {
                    if (((String)((Object)this.var_ayh_a)).startsWith("Say")) {
                        engine.a((String)((Object)this.var_ayh_a), (BitmapFont)((Object)this.var_ayh_b), axe.H, (BitmapFont)((Object)this.var_ayh_b), Color.BLACK, (float)(this.g + 3), (float)(this.h + 15), 8, 0);
                        break;
                    }
                    if (!((String)((Object)this.var_ayh_a)).startsWith("Party")) break;
                    engine.a((String)((Object)this.var_ayh_a), (BitmapFont)((Object)this.var_ayh_b), axe.I, (BitmapFont)((Object)this.var_ayh_b), Color.BLACK, (float)(this.g + 3), (float)(this.h + 15), 8, 0);
                }
            }
        }
    }

    @Override
    public void g() {
        super.g();
        ((axh)((Object)this.var_ayh_a)).setDisabled(false);
        if (((axh)((Object)this.var_ayh_a)).java_lang_String_a().equals("/assets")) {
            ((Engine)((Object)this.var_ayh_a)).h();
        } else if (((axh)((Object)this.var_ayh_a)).java_lang_String_a().equals("/reloadui")) {
            ((Engine)((Object)this.var_ayh_a)).var_aj_a.b();
            this.a("UI has been reloaded.");
        }
        if (this.var_ayh_a == false) {
            this.c.a(false);
            this.var_ayh_b.a(true);
        } else {
            this.c.a(true);
            this.var_ayh_b.a(false);
        }
        if (((Stage)((Object)this.var_ayh_a)).getKeyboardFocus() == this.var_ayh_a) {
            this.var_ayh_a = (ayh)true;
        } else {
            this.var_ayh_a = (ayh)false;
            ((axh)((Object)this.var_ayh_a)).setDisabled(true);
        }
        this.l();
    }

    @Override
    public void void_b() {
        ((Actor)((Object)this.var_ayh_a)).setPosition(this.g, this.h);
        ((Actor)((Object)this.var_ayh_a)).setSize(this.e, this.f);
    }

    public void n() {
        Engine.b("close it 1");
        if (((Stage)((Object)this.var_ayh_a)).getKeyboardFocus() == this.var_ayh_a) {
            ((axh)((Object)this.var_ayh_a)).b("");
            ((Stage)((Object)this.var_ayh_a)).setKeyboardFocus(null);
            Engine.b("close it 2");
            return;
        }
        if (this.var_ayh_b.boolean_b()) {
            this.var_ayh_b.a(false);
            this.c.a(true);
            this.l();
        } else if (this.c.boolean_b()) {
            this.c.a(true);
            this.var_ayh_b.a(false);
            this.var_float_b = 0.0f;
            this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().setAlpha(this.var_float_b);
            this.var_ayh_b.com_badlogic_gdx_graphics_g2d_Sprite_a().setAlpha(this.var_float_b);
            this.c.com_badlogic_gdx_graphics_g2d_Sprite_a().setAlpha(this.var_float_b);
        }
        this.var_ayh_a = (ayh)false;
        ((axh)((Object)this.var_ayh_a)).b("");
        ((axh)((Object)this.var_ayh_a)).setDisabled(true);
        ((Stage)((Object)this.var_ayh_a)).setKeyboardFocus(null);
    }

    public void o() {
        this.var_ayh_a = (ayh)false;
        ((axh)((Object)this.var_ayh_a)).b("");
        ((axh)((Object)this.var_ayh_a)).setDisabled(true);
        ((Stage)((Object)this.var_ayh_a)).setKeyboardFocus(null);
    }

    public boolean boolean_b() {
        return this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getColor().a <= 0.0f;
    }

    public void p() {
        ((axh)((Object)this.var_ayh_a)).b("/s ");
        this.var_ayh_b = "/s ";
    }

    public void q() {
        ((axh)((Object)this.var_ayh_a)).b("/p ");
        this.var_ayh_b = "/p ";
    }

    public boolean boolean_c() {
        return this.var_float_b <= 0.0f;
    }

    public boolean boolean_d() {
        return this.var_float_b > 0.1f;
    }

    public float float_a() {
        return this.var_float_b;
    }
}

