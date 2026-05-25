/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class ck
extends cj {
    public ck(Engine engine, cg cg2) {
        super(engine, cg2);
        TextureAtlas textureAtlas = engine.axm_a().com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c);
        this.a = new cl(this, 40, 887, textureAtlas, "vendor_general_default", "vendor_general_hovered", true, cg2);
    }

    @Override
    public void a(float f2) {
        super.a(f2);
        if (this.a) {
            // empty if block
        }
    }
}

