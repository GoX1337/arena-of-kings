/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.StoreItemContent;
import com.badlogic.gdx.graphics.g2d.Animation;

public class acq
extends abg {
    public acq(Engine engine, StoreItemContent storeItemContent, aer aer2, axm axm2, abe abe2, ze ze2, azx azx2) {
        super(engine, storeItemContent, ze2.axm_a(), abe2, ze2.yo_a(), aer2.yt_a(), azx2);
        this.a = storeItemContent.getContent();
        this.b = storeItemContent.getPriceString();
        da da2 = new da(storeItemContent.getScreenDependency(), aer2.java_lang_String_a(), aer2.int_c(), aer2.float_c(), aer2.float_b(), Animation.PlayMode.LOOP, aer2.d(), aer2.e());
        Engine.b("storeContent dep : " + (Object)((Object)storeItemContent.getScreenDependency()));
        da2.a(ze2.axm_a().com_badlogic_gdx_graphics_g2d_TextureAtlas_a(storeItemContent.getScreenDependency()));
        this.a(engine, storeItemContent.getScreenDependency(), da2);
        Engine.b("content size: " + this.a.size);
    }
}

