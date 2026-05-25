/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.StoreItemContent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import java.util.Iterator;

public class abr
extends ze {
    private axq a = axq.var_axq_a;
    private boolean b = false;

    public abr(Engine engine, axm axm2, Stage stage, boolean bl2) {
        super(engine, 10, axm2, stage, yo.b, bl2);
        this.f();
    }

    @Override
    public void g() {
        super.g();
        if (!this.b) {
            Engine.b("initializing items");
            this.a(new acq((Engine)((Object)this.a), (StoreItemContent)abi.u, new act(), (axm)((Object)this.a), abe.var_abe_a, this, new azx((Engine)((Object)this.a), 0, 0, ((axm)((Object)this.a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.b), abi.u, false, true)));
            this.a(new acq((Engine)((Object)this.a), (StoreItemContent)abi.k, new acj(), (axm)((Object)this.a), abe.c, this, new azx((Engine)((Object)this.a), 0, 0, ((axm)((Object)this.a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.b), abi.k, false, true)));
            this.a(new acq((Engine)((Object)this.a), (StoreItemContent)abi.l, new ack(), (axm)((Object)this.a), abe.d, this, new azx((Engine)((Object)this.a), 0, 0, ((axm)((Object)this.a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.b), abi.l, false, true)));
            this.a(new acq((Engine)((Object)this.a), (StoreItemContent)abi.m, new acl(), (axm)((Object)this.a), abe.f, this, new azx((Engine)((Object)this.a), 0, 0, ((axm)((Object)this.a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.b), abi.m, false, true)));
            this.a(new acq((Engine)((Object)this.a), (StoreItemContent)abi.n, new acm(), (axm)((Object)this.a), abe.d, this, new azx((Engine)((Object)this.a), 0, 0, ((axm)((Object)this.a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.b), abi.n, false, true)));
            this.a(new acq((Engine)((Object)this.a), (StoreItemContent)abi.p, new acn(), (axm)((Object)this.a), abe.f, this, new azx((Engine)((Object)this.a), 0, 0, ((axm)((Object)this.a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.b), abi.p, false, true)));
            this.a(new acq((Engine)((Object)this.a), (StoreItemContent)abi.q, new aco(), (axm)((Object)this.a), abe.d, this, new azx((Engine)((Object)this.a), 0, 0, ((axm)((Object)this.a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.b), abi.q, false, true)));
            this.a(new acq((Engine)((Object)this.a), (StoreItemContent)abi.r, new acp(), (axm)((Object)this.a), abe.f, this, new azx((Engine)((Object)this.a), 0, 0, ((axm)((Object)this.a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.b), abi.r, false, true)));
            this.a(new acq((Engine)((Object)this.a), (StoreItemContent)abi.s, new acr(), (axm)((Object)this.a), abe.d, this, new azx((Engine)((Object)this.a), 0, 0, ((axm)((Object)this.a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.b), abi.s, false, true)));
            this.a(new acq((Engine)((Object)this.a), (StoreItemContent)abi.t, new acs(), (axm)((Object)this.a), abe.f, this, new azx((Engine)((Object)this.a), 0, 0, ((axm)((Object)this.a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.b), abi.t, false, true)));
            this.a(new acq((Engine)((Object)this.a), (StoreItemContent)abi.u, new act(), (axm)((Object)this.a), abe.d, this, new azx((Engine)((Object)this.a), 0, 0, ((axm)((Object)this.a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.b), abi.u, false, true)));
            this.a(new acq((Engine)((Object)this.a), (StoreItemContent)abi.v, new acu(), (axm)((Object)this.a), abe.f, this, new azx((Engine)((Object)this.a), 0, 0, ((axm)((Object)this.a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.b), abi.v, false, true)));
            this.a = axq.b;
            this.b = true;
            this.void_a();
        }
    }

    @Override
    public void a(float f2, Engine engine) {
        if (this.a == axq.b) {
            Iterator iterator = ((Array)((Object)this.a)).iterator();
            while (iterator.hasNext()) {
                abg abg2 = (abg)iterator.next();
                Iterator iterator2 = ((Array)((Object)abg2.var_com_arenaofkings_packets_misc_StoreItemContent_a)).iterator();
                while (iterator2.hasNext()) {
                    axr axr2 = (axr)iterator2.next();
                    if (!(axr2 instanceof da) || ((da)axr2).boolean_a() || !engine.var_u_a.isLoaded(((da)axr2).ajw_a().a())) continue;
                    ((da)axr2).a((axm)((Object)this.a), false, true);
                }
            }
        }
    }

    @Override
    public void b(float f2, Engine engine) {
        if (this.a != false) {
            this.a(f2, engine);
            super.b(f2, engine);
            this.c(f2, engine);
        }
    }

    public void h() {
        this.b();
    }

    public void i() {
        this.c();
    }
}

