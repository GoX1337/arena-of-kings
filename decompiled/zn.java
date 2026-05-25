/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.LadderPlayerData;
import com.badlogic.gdx.graphics.Color;

public class zn
implements axr {
    protected LadderPlayerData var_com_arenaofkings_packets_misc_LadderPlayerData_a;
    protected ayh var_ayh_a;
    protected ayf var_ayf_a;
    protected int var_int_a;
    protected int b;
    protected int c;
    private boolean var_boolean_a = false;

    public zn(zt zt2, LadderPlayerData ladderPlayerData, ayf ayf2, ayh ayh2, int n2) {
        this.var_com_arenaofkings_packets_misc_LadderPlayerData_a = ladderPlayerData;
        this.var_ayf_a = ayf2;
        this.var_ayh_a = ayh2;
        this.c = n2;
        this.a();
    }

    private void a() {
        this.var_int_a = 686;
        this.b = 894 - this.c * 28;
    }

    @Override
    public void a(float f2, Engine engine) {
        this.var_ayf_a.a((float)this.var_int_a, this.b);
        this.var_ayh_a.a(this.var_int_a, this.b);
    }

    @Override
    public void b(float f2, Engine engine) {
        this.a(f2, engine);
        this.var_ayf_a.a(f2, engine, this.var_int_a, this.b);
        if (!this.var_boolean_a && this.var_ayf_a.boolean_b()) {
            engine.var_baa_a.a(ajw.kK, 0.6f);
            this.var_boolean_a = true;
        } else if (!this.var_ayf_a.boolean_b()) {
            this.var_boolean_a = false;
        }
        engine.a("" + (this.c + 1), engine.var_axy_b.a(), Color.WHITE, engine.var_axy_b.a(), Color.BLACK, (float)(this.var_int_a + 46), (float)(this.b + 18), 1, 1);
        this.var_ayh_a.b(f2, engine, this.var_int_a + 147, this.b);
        engine.a(this.var_com_arenaofkings_packets_misc_LadderPlayerData_a.character_name, engine.var_axy_b.a(), Color.WHITE, engine.var_axy_b.a(), Color.BLACK, (float)(this.var_int_a + 177), (float)(this.b + 18), 8, 1);
        engine.a("" + this.var_com_arenaofkings_packets_misc_LadderPlayerData_a.character_rating, engine.var_axy_b.a(), Color.WHITE, engine.var_axy_b.a(), Color.BLACK, (float)(this.var_int_a + 502), (float)(this.b + 18), 1, 1);
        engine.a("" + this.var_com_arenaofkings_packets_misc_LadderPlayerData_a.character_wins, engine.var_axy_b.a(), Color.WHITE, engine.var_axy_b.a(), Color.BLACK, (float)(this.var_int_a + 650), (float)(this.b + 18), 1, 1);
        engine.a("" + this.var_com_arenaofkings_packets_misc_LadderPlayerData_a.character_losses, engine.var_axy_b.a(), Color.WHITE, engine.var_axy_b.a(), Color.BLACK, (float)(this.var_int_a + 769), (float)(this.b + 18), 1, 1);
    }
}

