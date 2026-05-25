/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.ProfileBackgrounds;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Array;

public class aze
extends azk<azc> {
    private azc var_azc_a = new Array();
    private int var_int_d;
    private ayh var_ayh_d;
    private ayh e;
    private ayh f;
    private final axm var_axm_a;

    public aze(Engine engine, axm axm2, String string, String string2, String string3, int n2, int n3) {
        super(axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c), string, string2, string3, n2, n3);
        this.var_ayh_d = new ayh(723, 892, axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c), "mtx_checkmark", true);
        this.e = new ayh(723, 892, axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c), "Goldlock", true);
        this.e.com_badlogic_gdx_graphics_g2d_Sprite_a().scale(-0.5f);
        this.f = new ayh(720, 892, axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c), "mtx_box", true);
        this.b.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(n2 + 315, n3 + 10);
        this.c.com_badlogic_gdx_graphics_g2d_Sprite_a().scale(0.2f);
        this.c.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(n2 + 319, n3 + 122);
        this.c.com_badlogic_gdx_graphics_g2d_Sprite_a().setColor(Color.WHITE);
        this.b.com_badlogic_gdx_graphics_g2d_Sprite_a().setColor(Color.GREEN);
        this.c = (int)this.c.com_badlogic_gdx_graphics_g2d_Sprite_a().getY();
        this.var_axm_a = axm2;
        Engine.a("loading entries for ProfileBackgroundsTable");
        this.a(engine);
        this.a();
        this.e = (ayh)110.0f;
        this.c = (float)(this.e * this.var_azc_a);
        this.j = 0.0f;
        this.k = 110.0f;
        this.h = (float)(this.e * this.var_azc_a);
        this.i = 0.0f;
        Engine.a("created ProfileBackgroundsTable");
    }

    public void a(Engine engine) {
        ((Array)((Object)this.var_azc_a)).clear();
        TextureAtlas textureAtlas = this.var_axm_a.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c);
        this.a(new azc(engine, textureAtlas, ProfileBackgrounds.NONE, 0));
        this.a(new azc(engine, textureAtlas, ProfileBackgrounds.PBG_0, 1));
        this.a(new azc(engine, textureAtlas, ProfileBackgrounds.PBG_1, 2));
        this.a(new azc(engine, textureAtlas, ProfileBackgrounds.PBG_2, 3));
        this.a(new azc(engine, textureAtlas, ProfileBackgrounds.PBG_3, 4));
        this.a(new azc(engine, textureAtlas, ProfileBackgrounds.PBG_4, 5));
        this.a(new azc(engine, textureAtlas, ProfileBackgrounds.PBG_5, 6));
        this.a(new azc(engine, textureAtlas, ProfileBackgrounds.PBG_6, 7));
        this.a(new azc(engine, textureAtlas, ProfileBackgrounds.PBG_7, 8));
        this.a(new azc(engine, textureAtlas, ProfileBackgrounds.PBG_8, 9));
        this.a(new azc(engine, textureAtlas, ProfileBackgrounds.PBG_9, 10));
        this.a(new azc(engine, textureAtlas, ProfileBackgrounds.PBG_10, 11));
        this.a(new azc(engine, textureAtlas, ProfileBackgrounds.PBG_11, 12));
        this.a(new azc(engine, textureAtlas, ProfileBackgrounds.PBG_12, 13));
        this.a(new azc(engine, textureAtlas, ProfileBackgrounds.PBG_14, 14));
        this.a(new azc(engine, textureAtlas, ProfileBackgrounds.PBG_15, 15));
        ((Array)((Object)this.var_azc_a)).sort();
        for (int i2 = 0; i2 < ((Array)((Object)this.var_azc_a)).size; ++i2) {
            ((azc)((Array)((Object)this.var_azc_a)).get(i2)).a(i2);
        }
        this.a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_misc_ProfileBackgrounds_a());
    }

    private void a(ProfileBackgrounds profileBackgrounds) {
        for (int i2 = 0; i2 < ((Array)((Object)this.var_azc_a)).size; ++i2) {
            if (((azc)((Array)((Object)this.var_azc_a)).get(i2)).com_arenaofkings_packets_misc_ProfileBackgrounds_a() != profileBackgrounds) continue;
            if (this.var_azc_a != null) {
                this.var_azc_a.a(false);
            }
            this.var_azc_a = (azc)((Array)((Object)this.var_azc_a)).get(i2);
            this.var_azc_a.a(true);
            this.var_int_d = i2;
            this.var_ayh_d.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(683.0f, 728 - (this.var_azc_a.int_a() + 1) * 25);
        }
    }

    private void a(azc azc2) {
        ((Array)((Object)this.var_azc_a)).add(azc2);
    }

    @Override
    public void b(float f2, Engine engine) {
        int n2;
        int n3;
        this.a(f2, engine);
        ((ayh)((Object)this.var_azc_a)).b(f2, engine);
        if (((Array)((Object)this.var_azc_a)).size <= 5) {
            this.var_azc_a = (azc)((Array)((Object)this.var_azc_a)).size;
        }
        if (this.var_azc_a >= 5) {
            n3 = 0;
            for (n2 = this.b; n2 <= this.var_azc_a; ++n2) {
                ((azc)((Array)((Object)this.var_azc_a)).get(n2)).a(n3);
                ((azc)((Array)((Object)this.var_azc_a)).get(n2)).a(f2, engine);
                ((azc)((Array)((Object)this.var_azc_a)).get(n2)).b(f2, engine);
                ++n3;
            }
        } else {
            n3 = 0;
            for (n2 = this.b; n2 < ((Array)((Object)this.var_azc_a)).size; ++n2) {
                ((azc)((Array)((Object)this.var_azc_a)).get(n2)).a(n3);
                ((azc)((Array)((Object)this.var_azc_a)).get(n2)).a(f2, engine);
                ((azc)((Array)((Object)this.var_azc_a)).get(n2)).b(f2, engine);
                ++n3;
            }
        }
        this.a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_misc_ProfileBackgrounds_a());
        for (n3 = 0; n3 < ((Array)((Object)this.var_azc_a)).size; ++n3) {
            boolean bl2;
            azc azc2 = (azc)((Array)((Object)this.var_azc_a)).get(n3);
            azc2.a(n3);
            boolean bl3 = bl2 = azc2.int_a() >= this.b && azc2.int_a() <= this.var_azc_a;
            if (!bl2 || ay.ay_a().gd_a().a(azc2.com_arenaofkings_packets_misc_ProfileBackgrounds_a())) continue;
            this.e.b(f2, engine, 679, 723 - (azc2.int_a() - this.b + 1) * 25);
        }
        if (this.var_azc_a != null && this.var_int_d >= this.b && this.var_int_d <= this.var_azc_a) {
            this.var_ayh_d.b(f2, engine);
        }
        super.b(f2, engine);
        this.b.b(f2, engine);
        this.c.b(f2, engine);
    }
}

