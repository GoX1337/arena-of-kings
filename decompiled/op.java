/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.EffectList;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import java.util.concurrent.TimeUnit;

public class op
extends ayh {
    private ayh var_ayh_a;
    private da var_da_a;
    private da var_da_b;
    private static int var_int_a;
    private static int var_int_b;
    private EffectList var_com_arenaofkings_packets_gameserver_data_EffectList_a;
    private EffectList var_com_arenaofkings_packets_gameserver_data_EffectList_b;
    private String var_java_lang_String_a = "";
    private String var_java_lang_String_b;
    private float e = 0.5f;
    private float f = 0.5f;
    private int c = 0;

    public op(Engine engine, EffectList effectList, String string, ot ot2, EffectList effectList2) {
        super(new Sprite(engine.var_or_a.var_com_badlogic_gdx_graphics_g2d_TextureAtlas_a.findRegion(string)), true);
        this.var_ayh_a = new ayh(new Sprite(engine.var_or_a.var_com_badlogic_gdx_graphics_g2d_TextureAtlas_a.findRegion("spell_icon_border_default")), true);
        this.var_com_arenaofkings_packets_gameserver_data_EffectList_a = effectList;
        this.var_com_arenaofkings_packets_gameserver_data_EffectList_b = effectList2 == null ? effectList : effectList2;
        this.var_java_lang_String_a = EffectList.getFormattedName(this.var_com_arenaofkings_packets_gameserver_data_EffectList_b);
        this.var_java_lang_String_b = string;
        ((Sprite)((Object)this.var_ayh_a)).setPosition(var_int_a, var_int_b);
        if (ot2 == ot.var_ot_a) {
            this.var_da_a = new da(ajw.jk, "Activation_GREEN", 50, 0.025f, 0.0f, Animation.PlayMode.NORMAL, -65, -65);
            this.var_da_b = new da(ajw.jk, "Activation_GREEN", 50, 0.025f, 0.0f, Animation.PlayMode.NORMAL, -65, -65);
        } else if (ot2 == ot.b) {
            this.var_da_a = new da(ajw.jj, "Activation_RED", 50, 0.025f, 0.0f, Animation.PlayMode.NORMAL, -65, -75);
            this.var_da_b = new da(ajw.jj, "Activation_RED", 50, 0.025f, 0.0f, Animation.PlayMode.NORMAL, -65, -75);
            this.c = 11;
        } else if (ot2 == ot.c) {
            this.var_da_a = new da(ajw.jg, "GCD_Flash", 50, 0.025f, 0.0f, Animation.PlayMode.NORMAL, -65, -75);
            this.var_da_b = new da(ajw.jg, "GCD_Flash", 50, 0.025f, 0.0f, Animation.PlayMode.NORMAL, -65, -75);
            this.c = 11;
        }
        this.var_da_a.a(((agd)engine.axc_a()).axm_a(), false, true);
        this.var_da_b.d(-0.5f);
        this.var_da_b.a(((agd)engine.axc_a()).axm_a(), false, true);
    }

    public void a(float f2, Engine engine, azv azv2, int n2, int n3) {
        engine.var_azi_a.draw((TextureRegion)((Object)this.var_ayh_a), ((Sprite)((Object)this.var_ayh_a)).getX() - (float)(58 * n3), ((Sprite)((Object)this.var_ayh_a)).getY() - (float)(n2 * 77));
    }

    public void b(float f2, Engine engine, azv azv2, int n2, int n3) {
        this.var_ayh_a.b(f2, engine, (int)((Sprite)((Object)this.var_ayh_a)).getX() - 58 * n3 - 3, (int)((Sprite)((Object)this.var_ayh_a)).getY() - n2 * 79);
    }

    public void c(float f2, Engine engine, azv azv2, int n2, int n3) {
        if (azv2.long_a() / 1000L < 1000L) {
            int n4 = (int)(azv2.long_a() / 1000L - azv2.a(TimeUnit.SECONDS));
            String string = "";
            if (azv2.long_a() > 0L && n4 >= 0) {
                string = n4 + "s";
            }
            engine.a(string, engine.l, Color.WHITE, engine.l, Color.BLACK, ((Sprite)((Object)this.var_ayh_a)).getX() - (float)(58 * n3) + 24.0f, ((Sprite)((Object)this.var_ayh_a)).getY() - 10.0f - (float)(n2 * 79), 1, 1);
        }
        if (this.e != false) {
            engine.var_com_badlogic_gdx_graphics_g2d_BitmapFont_a.draw((Batch)engine.var_azi_a, this.var_java_lang_String_a, ((Sprite)((Object)this.var_ayh_a)).getX() - (float)(66 * n3), ((Sprite)((Object)this.var_ayh_a)).getY() - 98.0f);
        }
    }

    public void d(float f2, Engine engine, azv azv2, int n2, int n3) {
        this.var_da_a.a(((Sprite)((Object)this.var_ayh_a)).getX() - (float)(58 * n3), ((Sprite)((Object)this.var_ayh_a)).getY() - (float)(n2 * 70));
        if (this.var_da_a.boolean_b()) {
            this.var_da_a.e(0.025f);
            this.e = this.e + f2 >= 0.8f ? 0.5f : (this.e += f2);
            this.var_da_a.a(this.e, engine.var_azi_a);
        } else {
            this.var_da_a.e(0.025f);
            this.var_da_a.b(f2, engine);
        }
    }

    public void a(float f2, Engine engine, int n2, int n3) {
        this.var_da_b.a(((Sprite)((Object)this.var_ayh_a)).getX() + (float)(28 * n3) - 1565.0f, ((Sprite)((Object)this.var_ayh_a)).getY() - (float)(n2 * 31) - 81.0f + (float)this.c);
        if (this.var_da_b.boolean_b()) {
            this.var_da_b.e(0.025f);
            this.f = this.f + f2 >= 0.8f ? 0.5f : (this.f += f2);
            this.var_da_b.a(this.f, engine.var_azi_a);
        } else {
            this.var_da_b.e(0.025f);
            this.var_da_b.b(f2, engine);
        }
    }

    public EffectList com_arenaofkings_packets_gameserver_data_EffectList_a() {
        return this.var_com_arenaofkings_packets_gameserver_data_EffectList_a;
    }

    public EffectList com_arenaofkings_packets_gameserver_data_EffectList_b() {
        return this.var_com_arenaofkings_packets_gameserver_data_EffectList_b;
    }

    static {
        var_int_a = 1860;
        var_int_b = 1020;
    }
}

