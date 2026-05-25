/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.items.ItemData;

public class fx
extends fh {
    public fx(ItemData itemData) {
        super(itemData);
        if (this.a == fp.bU || this.a == fp.bV || this.a == fp.bW || this.a == fp.bY || this.a == fp.bZ) {
            this.a = ajw.ke;
        } else if (this.a == fp.bX) {
            this.a = ajw.kp;
        }
    }

    @Override
    public void a(axm axm2, boolean bl2) {
        if (bl2 || this.a == null) {
            Engine.b("loading new consumable: " + (Object)((Object)this.a));
            String string = this.a.java_lang_String_b();
            Engine.b("path: " + string);
            this.a = new ayh(0, 0, axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.iW), string, true);
            Engine.b("loaded consumable icon");
            this.a = true;
        }
        this.b(axm2, bl2);
        this.c(axm2, bl2);
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

    @Override
    public void c(float f2, Engine engine) {
        super.c(f2, engine);
    }

    @Override
    public void a(Engine engine, int n2, int n3, int n4, boolean bl2, boolean bl3) {
        super.a(engine, n2, n3, n4, bl2, bl3);
    }

    public boolean boolean_d() {
        return this.a == fp.bX;
    }
}

