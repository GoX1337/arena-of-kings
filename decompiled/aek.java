/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.StoreItemContent;
import com.badlogic.gdx.graphics.g2d.Animation;

public class aek
extends abg {
    public aek(Engine engine, StoreItemContent storeItemContent, aer aer2, int n2, int n3, axm axm2, abe abe2, ze ze2, azx azx2) {
        super(engine, storeItemContent, ze2.axm_a(), abe2, ze2.yo_a(), aer2.yt_a(), azx2);
        this.a = storeItemContent.getContent();
        this.b = storeItemContent.getPriceString();
        da da2 = new da(storeItemContent.getScreenDependency(), aer2.java_lang_String_a(), aer2.int_c(), aer2.float_c(), aer2.float_a(), Animation.PlayMode.LOOP, aer2.d() + n2, aer2.e() + n3);
        da2.a(axm2, false, true);
        da2.a(aer2.com_badlogic_gdx_graphics_Color_a());
        this.a((axr)da2);
    }
}

