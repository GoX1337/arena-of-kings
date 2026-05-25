/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.StoreItemContent;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class ads
extends abg {
    public ads(Engine engine, StoreItemContent storeItemContent, adc adc2, TextureAtlas textureAtlas, abe abe2, ze ze2, azx azx2) {
        super(engine, storeItemContent, ze2.axm_a(), abe2, ze2.yo_a(), adc2.a(), azx2);
        this.a = storeItemContent.getContent();
        this.b = storeItemContent.getPriceString();
        if (adc2.var_int_a != -1) {
            ayh ayh2 = new ayh(0, 0, textureAtlas, adc2.var_java_lang_String_a, adc2.var_int_a, true);
            ayh2.a(adc2.b + 2);
            ayh2.b(adc2.c + 15);
            ayh2.com_badlogic_gdx_graphics_g2d_Sprite_a().scale(-0.2f);
            this.a((axr)ayh2);
        } else {
            ayh ayh3 = new ayh(0, 0, textureAtlas, adc2.var_java_lang_String_a, true);
            ayh3.a(adc2.b + 2);
            ayh3.b(adc2.c + 15);
            ayh3.com_badlogic_gdx_graphics_g2d_Sprite_a().scale(-0.2f);
            this.a((axr)ayh3);
        }
        if (azx2 != null) {
            // empty if block
        }
    }
}

