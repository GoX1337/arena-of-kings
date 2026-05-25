/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.StorePayableItem;

public class aem
extends abg {
    public aem(Engine engine, axm axm2, abe abe2, yo yo2, azw azw2) {
        super(engine, StorePayableItem.VILLAIN_COINS_10000, axm2, abe2, yo2, yt.d, azw2);
        this.a = "$100";
        this.b = "13000 Villain Coins";
        this.c = "+2000 bonus Villain Coins";
        ayh ayh2 = new ayh(0, 0, axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.b), "vc6", true);
        ayh2.a(33);
        ayh2.b(85);
        ayh2.com_badlogic_gdx_graphics_g2d_Sprite_a().scale(-0.2f);
        this.a((axr)ayh2);
    }

    @Override
    public void b(float f2, Engine engine) {
        super.b(f2, engine);
    }
}

