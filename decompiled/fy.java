/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.items.ItemData;

public class fy
extends fh {
    public fy(ItemData itemData) {
        super(itemData);
        switch (this.a) {
            case NECK: {
                this.a = ajw.kc;
                break;
            }
            case RING: {
                this.a = ajw.kb;
                break;
            }
            case TRINKET: {
                this.a = ajw.kd;
                break;
            }
        }
    }

    @Override
    public void a(axm axm2, boolean bl2) {
        if (bl2 || this.a == null) {
            Engine.b("loading new itemm: " + (Object)((Object)this.a));
            String string = this.a.name() + "_T" + this.a.int_a();
            this.a = new ayh(0, 0, axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.iW), string, true);
            Engine.b("loaded jewelry item icon: " + (Object)((Object)this.a));
            this.a = true;
        }
        this.b(axm2, bl2);
        this.c(axm2, bl2);
        Engine.b("loaded jewelry item borders: " + (Object)((Object)this.a));
    }

    @Override
    public void a(float f2, Engine engine) {
        if (this.a != null) {
            this.a.a(f2, engine);
        }
        if (this.c != null) {
            this.c.a(f2, engine);
        }
    }
}

