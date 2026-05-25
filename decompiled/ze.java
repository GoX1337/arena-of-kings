/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;

public abstract class ze
implements axr {
    protected final Engine var_com_arenaofkings_client_core_Engine_a;
    protected final axm var_axm_a;
    protected final Stage var_com_badlogic_gdx_scenes_scene2d_Stage_a;
    protected Array<abg> var_com_badlogic_gdx_utils_Array_abg__a;
    protected yo var_yo_a;
    protected int var_int_a;
    protected int var_int_b;
    public ayh var_ayh_a;
    public ayh var_ayh_b;
    protected int var_int_c = 4;
    protected int var_int_d = 0;
    protected int var_int_e;
    protected float var_float_a;
    protected float var_float_b;
    protected float var_float_c;
    protected float var_float_d;
    protected float var_float_e;
    protected float var_float_f = 0.0f;
    protected float g = 0.0f;
    protected float h;
    protected float i;
    protected float j = 0.0f;
    protected float k;
    protected float l;
    protected boolean var_boolean_a;
    private int var_int_f = 0;

    public ze(Engine engine, int n2, axm axm2, Stage stage, yo yo2, boolean bl2) {
        this.var_com_arenaofkings_client_core_Engine_a = engine;
        this.var_com_arenaofkings_client_core_Engine_a = new Array(true, n2);
        this.var_axm_a = axm2;
        this.var_com_badlogic_gdx_scenes_scene2d_Stage_a = stage;
        this.var_yo_a = yo2;
        this.var_boolean_a = bl2;
        this.var_int_a = -1;
        this.var_int_b = -1;
        TextureAtlas textureAtlas = axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c);
        this.var_ayh_a = new ayh(textureAtlas.createSprite("spell_book_scrollbar"));
        this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().scale(-0.2f);
        this.var_ayh_b = new ayh(textureAtlas.createSprite("scrollknob"));
        int n3 = 1130;
        int n4 = 500;
        this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(n3 + 350, n4);
        this.var_ayh_b.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(n3 + 346, n4 + 310);
        this.var_ayh_b.com_badlogic_gdx_graphics_g2d_Sprite_a().setColor(Color.WHITE);
        this.var_int_e = (int)this.var_ayh_b.com_badlogic_gdx_graphics_g2d_Sprite_a().getY();
        this.var_ayh_b.com_badlogic_gdx_graphics_g2d_Sprite_a().scale(0.2f);
        this.var_ayh_b.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(n3 + 354, n4 + 322);
        this.var_int_e = (int)this.var_ayh_b.com_badlogic_gdx_graphics_g2d_Sprite_a().getY();
    }

    protected void void_a() {
        this.var_float_b = 0.0f;
        this.var_float_a = 1.0f / (float)(((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).size - 3);
        this.var_float_d = 0.0f;
        this.var_float_e = 280.0f;
        this.var_float_c = this.var_float_e * this.var_float_a;
        this.j = 0.0f;
        this.k = 280.0f;
        this.h = this.var_float_e * this.var_float_a;
        this.i = 0.0f;
    }

    public void b() {
        switch (this.var_yo_a) {
            case b: {
                Engine.a("pre top: " + this.var_int_a + " bottom: " + this.var_int_b);
                if (this.var_int_a - 2 >= 0) {
                    this.var_int_b -= 2;
                    this.var_int_a -= 2;
                    if (this.var_int_a < 0 || this.var_int_b > ((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).size) {
                        this.h();
                    }
                    int n2 = 0;
                    while (this.var_int_a + n2 <= this.var_int_b) {
                        Engine.a(n2 + " " + this.var_int_a + " " + this.var_int_b);
                        if (n2 == 0) {
                            ((abg)((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).get(this.var_int_a + n2)).a(abe.var_abe_a);
                        } else if (n2 == 1) {
                            ((abg)((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).get(this.var_int_a + n2)).a(abe.c);
                        } else if (n2 == 2) {
                            ((abg)((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).get(this.var_int_a + n2)).a(abe.d);
                        } else if (n2 == 3) {
                            ((abg)((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).get(this.var_int_a + n2)).a(abe.f);
                        }
                        ++n2;
                    }
                }
                Engine.a("post top: " + this.var_int_a + " bottom: " + this.var_int_b);
                this.i -= this.var_float_a * 2.0f;
                if (!(this.i + this.var_float_f + this.g - this.var_float_a * 2.0f < 0.0f)) break;
                this.i = 0.0f;
                this.var_float_f = 0.0f;
                this.g = 0.0f;
                break;
            }
        }
    }

    public void c() {
        switch (this.var_yo_a) {
            case b: {
                if (this.var_int_b + 2 >= ((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).size) {
                    this.var_int_b = ((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).size - 1;
                    this.var_int_a = this.var_int_b - 3;
                    if (this.var_int_a < 0 || this.var_int_b > ((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).size) {
                        this.h();
                    }
                    this.e();
                } else if (this.var_int_b + 2 < ((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).size) {
                    this.var_int_a += 2;
                    this.var_int_b += 2;
                    if (this.var_int_a < 0 || this.var_int_b > ((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).size) {
                        this.h();
                    }
                    this.e();
                }
                this.i += this.var_float_a * 2.0f;
                if (!(this.i + this.var_float_f + this.g + this.var_float_a * 2.0f > 1.0f)) break;
                this.i = 1.0f;
                this.var_float_f = 0.0f;
                this.g = 0.0f;
                break;
            }
        }
    }

    protected void a(abg abg2) {
        ((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).add(abg2);
        this.h();
    }

    private void h() {
        if (this.var_yo_a == yo.b) {
            if (((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).size >= 4) {
                this.var_int_a = 0;
                this.var_int_b = this.var_int_a + 3;
            } else {
                this.var_int_a = 0;
                this.var_int_b = ((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).size - 1;
            }
        } else if (this.var_yo_a == yo.c) {
            if (((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).size >= 6) {
                this.var_int_a = 0;
                this.var_int_b = this.var_int_a + 5;
            } else {
                this.var_int_a = 0;
                this.var_int_b = ((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).size - 1;
            }
        }
        Engine.a("top: " + this.var_int_a + " bot: " + this.var_int_b + " size: " + ((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).size);
    }

    public void d() {
    }

    public void a(int n2) {
        if (this.i + (float)n2 / this.k + this.g > 0.0f && this.i + (float)n2 / this.k + this.g < 1.0f) {
            this.var_float_f = (float)n2 / this.k;
        }
        Engine.b("SLIDE percentScrolled: " + this.i + " %amount: " + (float)n2 / this.k + " slideTotal: " + this.g + " slideAmount: " + this.var_float_f);
        this.l = this.i + this.var_float_f + this.g;
        if (this.var_int_f - (int)(this.l / this.var_float_a) >= 2) {
            this.var_int_f = (int)(this.l / this.var_float_a);
            if (this.var_int_f < 0) {
                this.var_int_f = 0;
            } else if (this.var_int_f > ((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).size) {
                this.var_int_f = ((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).size - 1;
            }
            if (this.var_int_f == 0 || this.var_int_f == 1) {
                this.var_int_a = 0;
                this.var_int_b = this.var_int_a + 3;
            } else if (this.var_int_f == ((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).size - 1 || this.var_int_f == ((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).size - 2) {
                this.var_int_b = ((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).size - 1;
                this.var_int_a = this.var_int_b - 3;
            } else {
                this.var_int_b -= 2;
                this.var_int_a -= 2;
            }
        } else if ((int)(this.l / this.var_float_a) - this.var_int_f >= 2) {
            this.var_int_f = (int)(this.l / this.var_float_a);
            if (this.var_int_f < 0) {
                this.var_int_f = 0;
            } else if (this.var_int_f > ((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).size) {
                this.var_int_f = ((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).size - 1;
            }
            if (this.var_int_f == 0 || this.var_int_f == 1) {
                this.var_int_a = 0;
                this.var_int_b = this.var_int_a + 3;
            } else if (this.var_int_f == ((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).size - 1 || this.var_int_f == ((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).size - 2) {
                this.var_int_b = ((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).size - 1;
                this.var_int_a = this.var_int_b - 3;
            } else {
                this.var_int_b += 2;
                this.var_int_a += 2;
            }
        }
        Engine.b("nearest: " + this.var_int_f + " totalCachePercent: " + this.l + " yPercentIncrement: " + this.var_float_a);
        if (this.var_int_f < 0) {
            this.var_int_f = 0;
            Engine.b("nearest is bugged");
        }
        if (this.var_int_b >= ((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).size) {
            this.var_int_b = ((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).size - 1;
            this.var_int_a = this.var_int_b - 3;
            Engine.b("CORRECTED topIndex: " + this.var_int_a + " Buttom: " + this.var_int_b);
        } else {
            Engine.b("topIndex: " + this.var_int_a + " SIZE: " + ((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).size + " bottomIndex: " + this.var_int_b);
        }
        this.e();
        Engine.b("Slide out");
    }

    public void e() {
        int n2 = 0;
        while (this.var_int_a + n2 <= this.var_int_b) {
            if (n2 == 0) {
                ((abg)((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).get(this.var_int_a + n2)).a(abe.var_abe_a);
            } else if (n2 == 1) {
                ((abg)((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).get(this.var_int_a + n2)).a(abe.c);
            } else if (n2 == 2) {
                ((abg)((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).get(this.var_int_a + n2)).a(abe.d);
            } else if (n2 == 3) {
                ((abg)((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).get(this.var_int_a + n2)).a(abe.f);
            }
            ++n2;
        }
    }

    @Override
    public void b(float f2, Engine engine) {
        if (this.var_int_b != -1 && this.var_int_a != -1) {
            for (int i2 = this.var_int_a; i2 <= this.var_int_b; ++i2) {
                ((abg)((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).get(i2)).b(f2, engine);
            }
        }
    }

    public void c(float f2, Engine engine) {
        this.var_ayh_a.a(f2, engine);
        this.var_ayh_b.a(f2, engine);
        this.var_ayh_a.b(f2, engine);
        this.var_ayh_b.c((int)((float)this.var_int_e - (this.i + this.g + this.var_float_f) * this.k));
        this.var_ayh_b.b(f2, engine);
    }

    public void f() {
        this.var_boolean_a = false;
    }

    public void g() {
        this.h();
        if (this.var_yo_a == yo.b) {
            int n2 = 0;
            while (this.var_int_a + n2 <= this.var_int_b) {
                if (n2 == 0) {
                    ((abg)((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).get(this.var_int_a + n2)).a(abe.var_abe_a);
                } else if (n2 == 1) {
                    ((abg)((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).get(this.var_int_a + n2)).a(abe.c);
                } else if (n2 == 2) {
                    ((abg)((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).get(this.var_int_a + n2)).a(abe.d);
                } else {
                    if (n2 != 3) break;
                    ((abg)((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).get(this.var_int_a + n2)).a(abe.f);
                }
                ++n2;
            }
        } else if (this.var_yo_a == yo.c) {
            int n3 = 0;
            while (this.var_int_a + n3 <= this.var_int_b) {
                if (n3 == 0) {
                    ((abg)((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).get(this.var_int_a + n3)).a(abe.var_abe_a);
                } else if (n3 == 1) {
                    ((abg)((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).get(this.var_int_a + n3)).a(abe.var_abe_b);
                } else if (n3 == 2) {
                    ((abg)((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).get(this.var_int_a + n3)).a(abe.c);
                } else if (n3 == 3) {
                    ((abg)((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).get(this.var_int_a + n3)).a(abe.d);
                } else if (n3 == 4) {
                    ((abg)((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).get(this.var_int_a + n3)).a(abe.e);
                } else {
                    if (n3 != 5) break;
                    ((abg)((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).get(this.var_int_a + n3)).a(abe.f);
                }
                ++n3;
            }
        }
        this.var_boolean_a = true;
    }

    public yo yo_a() {
        return this.var_yo_a;
    }

    public axm axm_a() {
        return this.var_axm_a;
    }

    public ayh ayh_a() {
        return this.var_ayh_b;
    }
}

