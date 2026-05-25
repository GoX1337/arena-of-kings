/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import java.util.concurrent.TimeUnit;

public class ahn
implements axr {
    private ayh var_ayh_a;
    private ayh var_ayh_b;
    private ayh c;
    private ayh d;
    private ayh e;
    private int var_int_a;
    private int var_int_b;

    public ahn(TextureAtlas textureAtlas) {
        this.var_ayh_a = new ayh(748, 1023, textureAtlas, "top_bar_panel", true);
        this.var_ayh_b = new ayh(760, 1040, textureAtlas, "top_bar_empty_globe", true);
        this.c = new ayh(760, 1040, textureAtlas, "top_bar_ally_globe", true);
        this.d = new ayh(760, 1040, textureAtlas, "top_bar_enemy_globe", true);
        this.e = new ayh(936, 1035, textureAtlas, "top_bar_skull", true);
    }

    @Override
    public void a(float f2, Engine engine) {
    }

    @Override
    public void b(float f2, Engine engine) {
        int n2;
        this.var_ayh_a.b(f2, engine);
        this.var_int_a = 0;
        for (n2 = 0; n2 < ay.ay_a().gf_a().a().size(); ++n2) {
            this.var_ayh_b.b(f2, engine, 764 + 36 * n2, 1039);
            if (!ay.ay_a().gf_a().a().a(n2).com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().boolean_a()) continue;
            ++this.var_int_a;
        }
        for (n2 = 0; n2 < this.var_int_a; ++n2) {
            this.c.b(f2, engine, 764 + 36 * n2, 1039);
        }
        this.var_int_b = 0;
        for (n2 = 0; n2 < ay.ay_a().ge_a().a().size(); ++n2) {
            this.var_ayh_b.b(f2, engine, 1100 - 36 * n2, 1039);
            if (!ay.ay_a().ge_a().a().a(n2).com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().boolean_a()) continue;
            ++this.var_int_b;
        }
        for (n2 = 0; n2 < this.var_int_b; ++n2) {
            this.d.b(f2, engine, 1100 - 36 * n2, 1039);
        }
        long l2 = 120L - ((agd)engine.axc_a()).azv_a().a(TimeUnit.SECONDS);
        int n3 = (int)(l2 / 60L);
        int n4 = (int)(l2 - (long)(60 * n3));
        String string = "0";
        string = n4 < 10 ? string + n3 + ":0" + n4 : string + n3 + ":" + n4;
        if (n3 == 0 && n4 <= 30 && n4 >= 0) {
            engine.a(string, engine.l, Color.ORANGE, engine.l, Color.BLACK, 949.0f, 1062.0f, 1, 0);
        } else if (n3 == 0 && n4 > 30 || n3 > 0) {
            engine.a(string, engine.l, Color.WHITE, engine.l, Color.BLACK, 949.0f, 1062.0f, 1, 0);
        } else if (n3 <= 0 && n4 < 0) {
            engine.a("DEATH", engine.l, Color.RED, engine.l, Color.BLACK, 949.0f, 1062.0f, 1, 0);
            this.e.b(f2, engine);
        } else {
            engine.a("2:00", engine.l, Color.WHITE, engine.l, Color.BLACK, 949.0f, 1062.0f, 1, 0);
        }
    }
}

