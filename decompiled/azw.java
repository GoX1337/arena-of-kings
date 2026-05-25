/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.StorePayableItem;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class azw
extends ayc
implements azs {
    protected StorePayableItem var_com_arenaofkings_packets_misc_StorePayableItem_a;
    private Sprite d;
    private String var_java_lang_String_a = "";

    public azw(Engine engine, int n2, int n3, TextureAtlas textureAtlas, StorePayableItem storePayableItem, boolean bl2) {
        super(n2, n3, textureAtlas, "purchase_button_default2", "purchase_button_hovered2", "unavailable_button", bl2);
        this.var_com_arenaofkings_packets_misc_StorePayableItem_a = storePayableItem;
        we we2 = (we)engine.axc_a();
        TextureAtlas textureAtlas2 = we2.axm_a().com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c);
        this.d = new Sprite(textureAtlas2.createSprite("villain_coin_menu_default"));
        this.d.setScale(0.9f);
        this.d.setPosition(n2, n3);
    }

    @Override
    public void b(float f2, Engine engine) {
        if (!this.b && this.var_com_arenaofkings_packets_misc_StorePayableItem_a == false) {
            this.b.draw(engine.var_azi_a);
            this.d.draw(engine.var_azi_a);
            axe cfr_ignored_0 = engine.var_axe_a;
            engine.a(String.valueOf(StorePayableItem.getAmount(this.var_com_arenaofkings_packets_misc_StorePayableItem_a)), engine.var_axy_e.a(), axe.F, engine.var_axy_e.a(), Color.BLACK, this.b.getX() + 59.0f, this.b.getY() + 31.0f, 8, 1);
        } else if (this.b && this.var_com_arenaofkings_packets_misc_StorePayableItem_a == false) {
            this.c.draw(engine.var_azi_a);
            this.d.draw(engine.var_azi_a);
            axe cfr_ignored_1 = engine.var_axe_a;
            engine.a(String.valueOf(StorePayableItem.getAmount(this.var_com_arenaofkings_packets_misc_StorePayableItem_a)), engine.var_axy_e.a(), axe.F, engine.var_axy_e.a(), Color.BLACK, this.b.getX() + 59.0f, this.b.getY() + 31.0f, 8, 1);
        } else {
            ((Sprite)((Object)this.var_com_arenaofkings_packets_misc_StorePayableItem_a)).draw(engine.var_azi_a);
        }
    }

    @Override
    public void a(int n2, int n3) {
        super.a((float)(n2 += 29), n3 += 30);
        this.d.setPosition(n2 + 16, n3 + 1);
    }
}

