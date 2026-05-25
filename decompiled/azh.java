/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Array;

public class azh
extends azk<azf> {
    private ayh var_ayh_d;
    private ayh e;
    private ayh f;
    private final axm a = new Array();
    private int var_int_d = 1;

    public azh(Engine engine, axm axm2, String string, String string2, String string3, int n2, int n3) {
        super(axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c), string, string2, string3, n2, n3);
        this.var_ayh_d = new ayh(723, 709, axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c), "mtx_checkmark", true);
        this.e = new ayh(723, 709, axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c), "Goldlock", true);
        this.e.com_badlogic_gdx_graphics_g2d_Sprite_a().scale(-0.5f);
        this.f = new ayh(720, 709, axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c), "mtx_box", true);
        this.b.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(n2 + 315, n3 + 10);
        this.c.com_badlogic_gdx_graphics_g2d_Sprite_a().scale(0.2f);
        this.c.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(n2 + 319, n3 + 122);
        this.c.com_badlogic_gdx_graphics_g2d_Sprite_a().setColor(Color.WHITE);
        this.b.com_badlogic_gdx_graphics_g2d_Sprite_a().setColor(Color.GREEN);
        this.c = (int)this.c.com_badlogic_gdx_graphics_g2d_Sprite_a().getY();
        this.a = axm2;
        Engine.a("loading entries for ProfileEffectsTable");
        this.a(engine);
        this.a();
        this.e = (ayh)110.0f;
        this.c = (float)(this.e * this.a);
        this.j = 0.0f;
        this.k = 110.0f;
        this.h = (float)(this.e * this.a);
        this.i = 0.0f;
        Engine.a("created ProfileEffectsTablee");
    }

    public void a(Engine engine) {
        ((Array)((Object)this.a)).clear();
        TextureAtlas textureAtlas = this.a.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c);
        this.a(new azf(engine, textureAtlas, abi.L, 0));
        this.a(new azf(engine, textureAtlas, abi.M, 1));
        this.a(new azf(engine, textureAtlas, abi.N, 2));
        this.a(new azf(engine, textureAtlas, abi.O, 3));
        this.a(new azf(engine, textureAtlas, abi.P, 4));
        this.a(new azf(engine, textureAtlas, abi.Q, 5));
        this.a(new azf(engine, textureAtlas, abi.R, 6));
        this.a(new azf(engine, textureAtlas, abi.S, 7));
        this.a(new azf(engine, textureAtlas, abi.T, 8));
        this.a(new azf(engine, textureAtlas, abi.U, 9));
        this.a(new azf(engine, textureAtlas, abi.V, 10));
        this.a(new azf(engine, textureAtlas, abi.W, 11));
        this.a(new azf(engine, textureAtlas, abi.X, 12));
        this.a(new azf(engine, textureAtlas, abi.Y, 13));
        this.a(new azf(engine, textureAtlas, abi.Z, 14));
        this.a(new azf(engine, textureAtlas, abi.aa, 15));
        this.a(new azf(engine, textureAtlas, abi.ab, 16));
        ((Array)((Object)this.a)).sort();
        for (int i2 = 0; i2 < ((Array)((Object)this.a)).size; ++i2) {
            ((azf)((Array)((Object)this.a)).get(i2)).a(i2);
        }
    }

    private void a(azf azf2) {
        ((Array)((Object)this.a)).add(azf2);
    }

    @Override
    public void b(float f2, Engine engine) {
        Object object;
        int n2;
        int n3;
        int n4;
        this.a(f2, engine);
        ((ayh)((Object)this.a)).b(f2, engine);
        if (((Array)((Object)this.a)).size <= 5) {
            this.a = (axm)((Array)((Object)this.a)).size;
        }
        if (this.a >= 5) {
            n4 = 0;
            for (n3 = this.b; n3 <= this.a; ++n3) {
                ((azf)((Array)((Object)this.a)).get(n3)).a(n4);
                ((azf)((Array)((Object)this.a)).get(n3)).a(f2, engine);
                ((azf)((Array)((Object)this.a)).get(n3)).b(f2, engine);
                ++n4;
            }
        } else {
            n4 = 0;
            for (n3 = this.b; n3 < ((Array)((Object)this.a)).size; ++n3) {
                ((azf)((Array)((Object)this.a)).get(n3)).a(n4);
                ((azf)((Array)((Object)this.a)).get(n3)).a(f2, engine);
                ((azf)((Array)((Object)this.a)).get(n3)).b(f2, engine);
                ++n4;
            }
        }
        abi abi2 = ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().abi_a();
        abi abi3 = ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().abi_b();
        abi abi4 = ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().abi_c();
        for (n2 = 0; n2 < ((Array)((Object)this.a)).size; ++n2) {
            object = ((azf)((Array)((Object)this.a)).get(n2)).abi_a();
            if (object == abi2 || object == abi3 || object == abi4) {
                ((azf)((Array)((Object)this.a)).get(n2)).a(true);
            } else {
                ((azf)((Array)((Object)this.a)).get(n2)).a(false);
            }
            ((azf)((Array)((Object)this.a)).get(n2)).a(n2);
        }
        if (abi2.getScreenDependency() != ajw.bs || abi3.getScreenDependency() != ajw.bs || abi4.getScreenDependency() != ajw.bs) {
            ((azf)((Array)((Object)this.a)).get(0)).a(false);
        } else if (abi2.getScreenDependency() == ajw.bs || abi3.getScreenDependency() == ajw.bs || abi4.getScreenDependency() == ajw.bs) {
            ((azf)((Array)((Object)this.a)).get(0)).a(true);
        }
        for (n2 = 0; n2 < ((Array)((Object)this.a)).size; ++n2) {
            boolean bl2;
            object = (azf)((Array)((Object)this.a)).get(n2);
            boolean bl3 = bl2 = ((azf)object).int_a() >= this.b && ((azf)object).int_a() <= this.a;
            if (((azf)object).boolean_a() && bl2 && ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().abi_a().getScreenDependency() != ajw.bs && ay.ay_a().gd_a().a(((azf)object).abi_a())) {
                this.var_ayh_d.b(f2, engine, 683, 551 - (((azf)object).int_a() - this.b + 1) * 25);
            }
            if (!bl2 || ay.ay_a().gd_a().a(((azf)object).abi_a())) continue;
            this.e.b(f2, engine, 679, 544 - (((azf)object).int_a() - this.b + 1) * 25);
        }
        super.b(f2, engine);
        this.b.b(f2, engine);
        this.c.b(f2, engine);
    }
}

