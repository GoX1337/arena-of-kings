/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.InputIdentifier;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class aax
extends ayh {
    protected InputIdentifier var_com_arenaofkings_packets_misc_InputIdentifier_a;
    protected boolean var_boolean_a = false;

    public aax(TextureAtlas textureAtlas, int n2, int n3) {
        this.var_com_arenaofkings_packets_misc_InputIdentifier_a = textureAtlas.createSprite("hotkey_parchment");
        ((Sprite)((Object)this.var_com_arenaofkings_packets_misc_InputIdentifier_a)).setPosition(n2, n3);
    }

    @Override
    public void a(float f2, Engine engine) {
        this.e();
        this.a(engine);
        this.f();
        if (this.f) {
            we we2;
            this.void_c();
            if (t.a(we.class, engine) && (we2 = (we)engine.axc_a()).wh_a().wg_a().axh_a().hasKeyboardFocus()) {
                we2.wh_a().com_badlogic_gdx_scenes_scene2d_Stage_c().setKeyboardFocus(null);
            }
        } else if (Gdx.input.isButtonPressed(0) && Gdx.input.justTouched()) {
            this.var_boolean_a = false;
        }
    }

    public void a(float f2, Engine engine, int n2) {
        if (this.b) {
            ((Sprite)((Object)this.var_com_arenaofkings_packets_misc_InputIdentifier_a)).draw(engine.var_azi_a);
            if (n2 != 9999) {
                if (this.var_boolean_a) {
                    engine.a(agc.a(n2), engine.var_axy_b.a(), Color.RED, engine.var_axy_b.a(), Color.BLACK, ((Sprite)((Object)this.var_com_arenaofkings_packets_misc_InputIdentifier_a)).getX() + ((Sprite)((Object)this.var_com_arenaofkings_packets_misc_InputIdentifier_a)).getWidth() / 2.0f, ((Sprite)((Object)this.var_com_arenaofkings_packets_misc_InputIdentifier_a)).getY() + ((Sprite)((Object)this.var_com_arenaofkings_packets_misc_InputIdentifier_a)).getHeight() / 2.0f + 12.0f, 1, 1);
                } else {
                    engine.a(agc.a(n2), engine.var_axy_b.a(), Color.GOLDENROD, engine.var_axy_b.a(), Color.BLACK, ((Sprite)((Object)this.var_com_arenaofkings_packets_misc_InputIdentifier_a)).getX() + ((Sprite)((Object)this.var_com_arenaofkings_packets_misc_InputIdentifier_a)).getWidth() / 2.0f, ((Sprite)((Object)this.var_com_arenaofkings_packets_misc_InputIdentifier_a)).getY() + ((Sprite)((Object)this.var_com_arenaofkings_packets_misc_InputIdentifier_a)).getHeight() / 2.0f + 12.0f, 1, 1);
                }
            } else {
                engine.a("UNBOUND", engine.var_axy_b.a(), Color.RED, engine.var_axy_b.a(), Color.BLACK, ((Sprite)((Object)this.var_com_arenaofkings_packets_misc_InputIdentifier_a)).getX() + ((Sprite)((Object)this.var_com_arenaofkings_packets_misc_InputIdentifier_a)).getWidth() / 2.0f, ((Sprite)((Object)this.var_com_arenaofkings_packets_misc_InputIdentifier_a)).getY() + ((Sprite)((Object)this.var_com_arenaofkings_packets_misc_InputIdentifier_a)).getHeight() / 2.0f + 12.0f, 1, 1);
            }
            if (this.var_boolean_a) {
                engine.a("(Press Key)", engine.var_axy_b.a(), Color.RED, engine.var_axy_b.a(), Color.BLACK, ((Sprite)((Object)this.var_com_arenaofkings_packets_misc_InputIdentifier_a)).getX() + ((Sprite)((Object)this.var_com_arenaofkings_packets_misc_InputIdentifier_a)).getWidth() / 2.0f, ((Sprite)((Object)this.var_com_arenaofkings_packets_misc_InputIdentifier_a)).getY() + ((Sprite)((Object)this.var_com_arenaofkings_packets_misc_InputIdentifier_a)).getHeight() / 2.0f, 1, 1);
            }
        }
    }

    @Override
    public void void_c() {
        this.var_boolean_a = true;
    }
}

