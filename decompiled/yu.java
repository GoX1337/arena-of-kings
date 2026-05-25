/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class yu
extends yf {
    private ayf var_ayf_a;
    private ayf var_ayf_b;
    private ayf var_ayf_c;
    private ayf var_ayf_d;
    private ayf var_ayf_e;
    private ayf f;
    private ayf g;
    private ayf h;
    private ayh var_ayh_b;
    private ayh var_ayh_c;
    private ayf i;
    private ayf j;
    private ayh var_ayh_d;
    private ayh var_ayh_e;
    private abs var_abs_a;
    private abr var_abr_a;
    private aci var_aci_a;
    private acg var_acg_a;
    private ach var_ach_a;
    private abk var_abk_a;
    private acf var_acf_a;
    private abz var_abz_a;
    private ayg var_ayg_a;
    private boolean var_boolean_a = false;
    private int var_int_a = 0;
    private ayf k;
    private da var_da_a = new da();
    private da var_da_b = new da();

    public yu(Engine engine, axm axm2, Stage stage) {
        super(402, 365, axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.b), "store_panel");
        Engine.a("StorePanel 1");
        this.a(engine, axm2, stage);
        Engine.a("StorePanel 2");
        this.i = this.var_ayf_a;
        Engine.a("StorePanel 3");
        this.var_ayg_a = new ayg(((ayh)((Object)this.var_ayf_a)).com_badlogic_gdx_graphics_g2d_Sprite_a().getX(), ((ayh)((Object)this.var_ayf_a)).com_badlogic_gdx_graphics_g2d_Sprite_a().getY(), ((ayh)((Object)this.var_ayf_a)).com_badlogic_gdx_graphics_g2d_Sprite_a().getX() + (float)((ayh)((Object)this.var_ayf_a)).com_badlogic_gdx_graphics_g2d_Sprite_a().getRegionWidth(), ((ayh)((Object)this.var_ayf_a)).com_badlogic_gdx_graphics_g2d_Sprite_a().getY() + (float)((ayh)((Object)this.var_ayf_a)).com_badlogic_gdx_graphics_g2d_Sprite_a().getRegionHeight());
        Engine.a("StorePanel 4");
    }

    private void a(Engine engine, axm axm2, Stage stage) {
        TextureAtlas textureAtlas = axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c);
        TextureAtlas textureAtlas2 = axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.b);
        abi abi2 = abi.U;
        this.var_da_a = new da(abi2.getScreenDependency(), abi2.aer_a().java_lang_String_a(), abi2.aer_a().int_c(), abi2.aer_a().float_c(), abi2.aer_a().float_b(), Animation.PlayMode.LOOP, abi2.aer_a().d(), abi2.aer_a().e());
        this.var_da_a.d(-0.4f);
        this.var_da_a.a(axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.js));
        abi abi3 = abi.Y;
        this.var_da_b = new da(abi3.getScreenDependency(), abi3.aer_a().java_lang_String_a(), abi3.aer_a().int_c(), abi3.aer_a().float_c(), abi3.aer_a().float_b(), Animation.PlayMode.LOOP, abi3.aer_a().d(), abi3.aer_a().e());
        this.var_da_b.d(-0.4f);
        this.var_da_b.a(axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.jy));
        Engine.a("StorePanel.loadGFX 1");
        this.var_abs_a = new abs(engine, axm2, stage, false);
        Engine.a("StorePanel.loadGFX 2");
        this.var_abr_a = new abr(engine, axm2, stage, false);
        Engine.a("StorePanel.loadGFX 3");
        this.var_aci_a = new aci(engine, axm2, stage, false);
        Engine.a("StorePanel.loadGFX 4");
        this.var_acg_a = new acg(engine, axm2, stage, false);
        Engine.a("StorePanel.loadGFX 5");
        this.var_ach_a = new ach(engine, axm2, stage, false);
        Engine.a("StorePanel.loadGFX 6");
        this.var_abk_a = new abk(engine, axm2, stage, false);
        Engine.a("StorePanel.loadGFX 7");
        this.var_acf_a = new acf(engine, axm2, stage, false);
        this.var_abz_a = new abz(engine, axm2, stage, false);
        Engine.a("StorePanel.loadGFX 8");
        this.var_ayh_b = new ayh(0, 0, textureAtlas2, "menu_item_backdrop_default", true);
        this.var_ayh_c = new ayh(0, 0, textureAtlas2, "menu_item_backdrop_hovered", true);
        this.var_ayh_d = new ayh(0, 0, textureAtlas, "switch_character_right_default", true);
        this.var_ayh_e = new ayh(0, 0, textureAtlas, "switch_character_right_hovered", true);
        this.k = new yv(this, 450, 530, textureAtlas2, "redeem_code_default", "redeem_code_hovered", true);
        this.var_ayf_a = new yw(this, 363, 825, textureAtlas2, "menu_item_featured", "menu_item_featured_hovered", true);
        this.var_ayf_a.a(423.0f, 905.0f, 667.0f, 947.0f);
        this.var_ayf_b = new yx(this, 385, 811, textureAtlas2, "menu_item_class_skins", "menu_item_class_skins_hovered", true);
        this.var_ayf_b.a(423.0f, 844.0f, 667.0f, 886.0f);
        this.var_ayf_c = new yy(this, 410, 772, textureAtlas2, "menu_item_spell_skins", "menu_item_spell_skins_hovered", true);
        this.var_ayf_c.a(423.0f, 787.0f, 667.0f, 829.0f);
        this.var_ayf_d = new yz(this, 410, 712, textureAtlas2, "menu_item_profile_backgrounds", "menu_item_profile_backgrounds_hovered", true);
        this.var_ayf_d.a(423.0f, 726.0f, 667.0f, 768.0f);
        this.var_ayf_e = new za(this, 410, 652, textureAtlas2, "menu_item_profile_effects", "menu_item_profile_effects_hovered", true);
        this.var_ayf_e.a(423.0f, 667.0f, 667.0f, 709.0f);
        this.f = new zb(this, 410, 592, textureAtlas2, "menu_item_miscellaneous", "menu_item_miscellaneous_hovered", true);
        this.f.a(423.0f, 609.0f, 667.0f, 651.0f);
        this.g = new zc(this, 363, 380, textureAtlas2, "menu_item_membership_default", "menu_item_membership_hovered", true);
        this.g.a(423.0f, 460.0f, 667.0f, 502.0f);
        this.h = new zd(this, 410, 380, textureAtlas2, "menu_item_villain_coins", "menu_item_villain_coins_hovered", true);
        Engine.a("loaded panels");
    }

    public void a(float f2) {
        this.var_boolean_a = true;
        this.var_int_a = (int)f2;
    }

    @Override
    public void a(float f2, Engine engine) {
        this.k.a(f2, engine);
        this.var_ayg_a.b(engine);
        if (this.var_ayg_a.boolean_e() && this.var_boolean_a) {
            if (this.var_int_a == 1) {
                if (this.var_abs_a.a != false) {
                    this.var_abs_a.i();
                }
                if (this.var_abr_a.a != false) {
                    this.var_abr_a.i();
                }
                if (this.var_aci_a.a) {
                    this.var_aci_a.h();
                }
                if (this.var_acg_a.a) {
                    this.var_acg_a.i();
                }
                if (this.var_ach_a.a) {
                    this.var_ach_a.i();
                }
                if (this.var_acf_a.a) {
                    this.var_acf_a.i();
                }
                if (this.var_abz_a.var_fx_a != false) {
                    this.var_abz_a.i();
                }
            } else if (this.var_int_a == -1) {
                if (this.var_abs_a.a != false) {
                    this.var_abs_a.h();
                }
                if (this.var_abr_a.a != false) {
                    this.var_abr_a.h();
                }
                if (this.var_aci_a.a) {
                    this.var_aci_a.h();
                }
                if (this.var_acg_a.a) {
                    this.var_acg_a.h();
                }
                if (this.var_ach_a.a) {
                    this.var_ach_a.h();
                }
                if (this.var_acf_a.a) {
                    this.var_acf_a.h();
                }
                if (this.var_abz_a.var_fx_a != false) {
                    this.var_abz_a.h();
                }
            }
        }
        this.var_boolean_a = false;
        this.var_int_a = 0;
    }

    @Override
    public void b(float f2, Engine engine) {
        if (((ayh)((Object)this.var_ayf_a)).boolean_b()) {
            this.a(f2, engine);
            super.b(f2, engine);
            if (this.i == this.var_ayf_a) {
                this.var_ayh_e.b(f2, engine, 402, 901);
            } else if (this.j == this.var_ayf_a) {
                this.var_ayh_d.b(f2, engine, 402, 901);
            }
            this.var_ayf_a.a(f2, engine);
            this.var_ayf_a.b(f2, engine);
            if (this.i == this.var_ayf_b) {
                this.var_ayh_e.b(f2, engine, 402, 841);
            } else if (this.j == this.var_ayf_b) {
                this.var_ayh_d.b(f2, engine, 402, 841);
            }
            this.var_ayf_b.a(f2, engine);
            this.var_ayf_b.b(f2, engine);
            if (this.i == this.var_ayf_c) {
                this.var_ayh_e.b(f2, engine, 402, 784);
            } else if (this.j == this.var_ayf_c) {
                this.var_ayh_d.b(f2, engine, 402, 784);
            }
            this.var_ayf_c.a(f2, engine);
            this.var_ayf_c.b(f2, engine);
            if (this.i == this.var_ayf_d) {
                this.var_ayh_e.b(f2, engine, 402, 726);
            } else if (this.j == this.var_ayf_d) {
                this.var_ayh_d.b(f2, engine, 402, 726);
            }
            this.var_ayf_d.a(f2, engine);
            this.var_ayf_d.b(f2, engine);
            if (this.i == this.var_ayf_e) {
                this.var_ayh_e.b(f2, engine, 402, 665);
            } else if (this.j == this.var_ayf_e) {
                this.var_ayh_d.b(f2, engine, 402, 665);
            }
            this.var_ayf_e.a(f2, engine);
            this.var_ayf_e.b(f2, engine);
            if (this.i == this.f) {
                this.var_ayh_e.b(f2, engine, 402, 609);
            } else if (this.j == this.f) {
                this.var_ayh_d.b(f2, engine, 402, 609);
            }
            this.f.a(f2, engine);
            this.f.b(f2, engine);
            if (this.i == this.g || this.j == this.g) {
                // empty if block
            }
            if (this.i == this.h) {
                this.var_ayh_e.b(f2, engine, 402, 396);
            } else if (this.j == this.h) {
                this.var_ayh_d.b(f2, engine, 402, 396);
            }
            this.h.a(f2, engine);
            this.h.b(f2, engine);
            this.var_da_b.a(f2, engine);
            this.var_da_b.d(f2, 475.0f, 365.0f, engine.var_azi_a);
            this.var_abs_a.b(f2, engine);
            this.var_abr_a.b(f2, engine);
            this.var_acg_a.b(f2, engine);
            this.var_ach_a.b(f2, engine);
            this.var_abk_a.b(f2, engine);
            this.var_acf_a.b(f2, engine);
            this.var_aci_a.b(f2, engine);
        }
    }

    public void a(ze ze2) {
        ze2.g();
        this.i = this.var_abk_a == ze2 ? this.h : (this.var_abs_a == ze2 ? this.var_ayf_a : (this.var_abr_a == ze2 ? this.var_ayf_b : (this.var_aci_a == ze2 ? this.var_ayf_c : (this.var_acg_a == ze2 ? this.var_ayf_d : (this.var_ach_a == ze2 ? this.var_ayf_e : (this.var_acf_a == ze2 ? this.f : (this.var_abz_a == ze2 ? this.g : this.var_ayf_a)))))));
        if (this.var_abs_a != ze2) {
            this.var_abs_a.f();
        }
        if (this.var_abr_a != ze2) {
            this.var_abr_a.f();
        }
        if (this.var_aci_a != ze2) {
            this.var_aci_a.f();
        }
        if (this.var_acg_a != ze2) {
            this.var_acg_a.f();
        }
        if (this.var_ach_a != ze2) {
            this.var_ach_a.f();
        }
        if (this.var_abk_a != ze2) {
            this.var_abk_a.f();
        }
        if (this.var_acf_a != ze2) {
            this.var_acf_a.f();
        }
        if (this.var_abz_a != ze2) {
            this.var_abz_a.f();
        }
    }

    public ayg ayg_a() {
        return this.var_ayg_a;
    }

    @Override
    public void a(Stage stage) {
        super.a(stage);
        if (this.i == this.h) {
            this.var_abk_a.g();
        } else if (this.i == this.var_ayf_a) {
            this.var_abs_a.g();
        } else if (this.i == this.var_ayf_b) {
            this.var_abr_a.g();
        } else if (this.i == this.var_ayf_c) {
            this.var_aci_a.g();
        } else if (this.i == this.var_ayf_d) {
            this.var_acg_a.g();
        } else if (this.i == this.var_ayf_e) {
            this.var_ach_a.g();
        } else if (this.i == this.f) {
            this.var_acf_a.g();
        } else if (this.i == this.g) {
            this.var_abz_a.g();
        }
    }

    @Override
    public void b(Stage stage) {
        super.b(stage);
        this.var_abs_a.f();
        this.var_abr_a.f();
        this.var_aci_a.f();
        this.var_acg_a.f();
        this.var_ach_a.f();
        this.var_abk_a.f();
        this.var_acf_a.f();
        this.var_abz_a.f();
    }

    public abr abr_a() {
        return this.var_abr_a;
    }

    public acg acg_a() {
        return this.var_acg_a;
    }

    public ach ach_a() {
        return this.var_ach_a;
    }

    public void c(float f2, Engine engine) {
        if (this.var_abz_a.var_fx_a != false) {
            this.var_abz_a.d(f2, engine);
        }
    }

    static /* synthetic */ abs abs_a(yu yu2) {
        return yu2.var_abs_a;
    }

    static /* synthetic */ ayf a(yu yu2, ayf ayf2) {
        yu2.j = ayf2;
        return yu2.j;
    }

    static /* synthetic */ ayf ayf_a(yu yu2) {
        return yu2.j;
    }

    static /* synthetic */ abr abr_a(yu yu2) {
        return yu2.var_abr_a;
    }

    static /* synthetic */ aci aci_a(yu yu2) {
        return yu2.var_aci_a;
    }

    static /* synthetic */ acg acg_a(yu yu2) {
        return yu2.var_acg_a;
    }

    static /* synthetic */ ach ach_a(yu yu2) {
        return yu2.var_ach_a;
    }

    static /* synthetic */ acf acf_a(yu yu2) {
        return yu2.var_acf_a;
    }

    static /* synthetic */ abz abz_a(yu yu2) {
        return yu2.var_abz_a;
    }

    static /* synthetic */ abk abk_a(yu yu2) {
        return yu2.var_abk_a;
    }
}

