/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class axj
extends ayc
implements azs {
    private final Engine var_com_arenaofkings_client_core_Engine_a;
    private final zu var_zu_a;
    protected abi var_abi_a;
    private Sprite d;
    private String var_java_lang_String_a = "";

    public axj(Engine engine, zu zu2, int n2, int n3, TextureAtlas textureAtlas, TextureAtlas textureAtlas2, abi abi2, boolean bl2) {
        super(n2, n3, textureAtlas, "purchase_button_default", "purchase_button_hovered", "unavailable_button", bl2);
        this.var_com_arenaofkings_client_core_Engine_a = engine;
        this.var_zu_a = zu2;
        this.var_abi_a = abi2;
        switch (abi2.com_arenaofkings_packets_misc_Currency_a()) {
            case SILVER: {
                this.d = new Sprite(textureAtlas2.createSprite("SilverCoin"));
                this.d.setScale(-0.8f);
                this.d.flip(true, true);
                this.d.setPosition(n2 + 53, n3 + 16);
                break;
            }
            case VILLAIN_COINS: {
                this.d = new Sprite(textureAtlas.createSprite("vc1"));
                this.d.setScale(-0.3f);
                this.d.flip(true, true);
                this.d.setPosition(n2 - 8, n3 - 30);
            }
        }
        this.a((float)(n2 + 14), n3 + 7, (float)(n2 + 14) + ((Sprite)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getWidth() * 0.8f, (float)(n3 + 7) + ((Sprite)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getHeight() * 0.8f);
        this.a(-0.8f);
    }

    @Override
    public void b(float f2, Engine engine) {
        if (!this.b && this.var_com_arenaofkings_client_core_Engine_a == false) {
            this.b.draw(engine.var_azi_a);
            this.d.draw(engine.var_azi_a);
            axe cfr_ignored_0 = engine.var_axe_a;
            engine.a(String.valueOf(this.var_abi_a.int_a()), engine.var_axy_c.a(), axe.E, engine.var_axy_c.a(), Color.BLACK, this.b.getX() + 106.0f, this.b.getY() + 45.0f, 8, 1);
        } else if (this.b && this.var_com_arenaofkings_client_core_Engine_a == false) {
            this.c.draw(engine.var_azi_a);
            this.d.draw(engine.var_azi_a);
            axe cfr_ignored_1 = engine.var_axe_a;
            engine.a(String.valueOf(this.var_abi_a.int_a()), engine.var_axy_c.a(), axe.E, engine.var_axy_c.a(), Color.BLACK, this.b.getX() + 106.0f, this.b.getY() + 45.0f, 8, 1);
        } else {
            ((Sprite)((Object)this.var_com_arenaofkings_client_core_Engine_a)).draw(engine.var_azi_a);
        }
    }

    @Override
    public void void_a() {
        if (this.var_com_arenaofkings_client_core_Engine_a.boolean_b()) {
            return;
        }
        we we2 = (we)this.var_com_arenaofkings_client_core_Engine_a.axc_a();
        Label.LabelStyle labelStyle = new Label.LabelStyle(this.var_com_arenaofkings_client_core_Engine_a.j, Color.WHITE);
        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = this.var_com_arenaofkings_client_core_Engine_a.l;
        textButtonStyle.fontColor = axe.K;
        axk axk2 = new axk(this, "", this.var_com_arenaofkings_client_core_Engine_a.var_com_badlogic_gdx_scenes_scene2d_ui_Skin_a, labelStyle);
        axk2.setBounds(830.0f, 575.0f, 450.0f, 135.0f);
        this.var_com_arenaofkings_client_core_Engine_a.a(axk2);
        we2.wh_a().com_badlogic_gdx_scenes_scene2d_Stage_c().addActor(axk2);
    }

    @Override
    public void a(int n2, int n3) {
        super.a((float)n2, n3);
        this.d.setPosition(n2 - 8, n3 - 30);
    }

    static /* synthetic */ Engine com_arenaofkings_client_core_Engine_a(axj axj2) {
        return axj2.var_com_arenaofkings_client_core_Engine_a;
    }

    static /* synthetic */ zu zu_a(axj axj2) {
        return axj2.var_zu_a;
    }
}

