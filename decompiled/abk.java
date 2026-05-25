/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.StorePayableItem;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class abk
extends ze {
    private abg var_abg_a = null;
    private boolean b = false;
    private da var_da_a = new da();

    public abk(Engine engine, axm axm2, Stage stage, boolean bl2) {
        super(engine, 6, axm2, stage, yo.c, bl2);
        System.out.println("Checkout");
        this.b = false;
        abi abi2 = abi.Y;
        this.var_da_a = new da(abi2.getScreenDependency(), abi2.aer_a().java_lang_String_a(), abi2.aer_a().int_c(), 0.06666667f, abi2.aer_a().float_b(), Animation.PlayMode.LOOP, abi2.aer_a().d(), abi2.aer_a().e());
        this.var_da_a.d(-0.4f);
        this.var_da_a.a(axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.jy));
        this.a(new aep(engine, axm2, abe.var_abe_a, (yo)((Object)this.var_abg_a), new abl(this, engine, 0, 0, axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.b), StorePayableItem.VILLAIN_COINS_500, true, engine)));
        this.a(new ael(engine, axm2, abe.var_abe_b, (yo)((Object)this.var_abg_a), new abm(this, engine, 0, 0, axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.b), StorePayableItem.VILLAIN_COINS_1000, true, engine)));
        this.a(new aen(engine, axm2, abe.c, (yo)((Object)this.var_abg_a), new abn(this, engine, 0, 0, axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.b), StorePayableItem.VILLAIN_COINS_2000, true, engine)));
        this.a(new aeo(engine, axm2, abe.d, (yo)((Object)this.var_abg_a), new abo(this, engine, 0, 0, axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.b), StorePayableItem.VILLAIN_COINS_3500, true, engine)));
        this.a(new aeq(engine, axm2, abe.e, (yo)((Object)this.var_abg_a), new abp(this, engine, 0, 0, axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.b), StorePayableItem.VILLAIN_COINS_5000, true, engine)));
        this.a(new aem(engine, axm2, abe.f, (yo)((Object)this.var_abg_a), new abq(this, engine, 0, 0, axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.b), StorePayableItem.VILLAIN_COINS_10000, true, engine)));
        this.f();
    }

    private void i() {
    }

    public void h() {
    }

    @Override
    public void a(float f2, Engine engine) {
        if (this.var_abg_a != false && this.b && this.var_abg_a != null) {
            this.i();
        } else {
            this.h();
        }
    }

    @Override
    public void b(float f2, Engine engine) {
        this.a(f2, engine);
        if (this.var_abg_a != false && this.b && this.var_abg_a != null) {
            this.var_abg_a.a(f2, engine, 1200, 600);
        } else if (this.var_abg_a != false && !this.b) {
            super.b(f2, engine);
            this.var_da_a.a(f2, engine);
            this.var_da_a.a(f2, engine, 674, 675);
            this.var_da_a.a(f2, engine, 950, 675);
            this.var_da_a.a(f2, engine, 1226, 675);
            this.var_da_a.a(f2, engine, 674, 405);
            this.var_da_a.a(f2, engine, 950, 405);
            this.var_da_a.a(f2, engine, 1226, 405);
        }
    }

    @Override
    public void g() {
        super.g();
    }

    @Override
    public void f() {
        super.f();
        this.b = false;
        this.var_abg_a = null;
        this.h();
    }
}

