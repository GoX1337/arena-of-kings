/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.loginserver.PUB_MISC_CHAT_MESSAGE;
import com.arenaofkings.packets.loginserver.TournamentMatchData;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

public class aaa
implements axr {
    private final aab var_aab_a;
    private final ayh var_ayh_a;
    private final ayh var_ayh_b;
    private final ayh var_ayh_c;
    private final ayf var_ayf_a;
    private Vector2 var_com_badlogic_gdx_math_Vector2_a = new Vector2(0.0f, 0.0f);
    private Vector2 var_com_badlogic_gdx_math_Vector2_b = new Vector2(0.0f, 0.0f);
    private Vector2 var_com_badlogic_gdx_math_Vector2_c = new Vector2(0.0f, 0.0f);
    private Vector2 d = new Vector2(0.0f, 0.0f);
    private Vector2 e = new Vector2(0.0f, 0.0f);
    private TournamentMatchData var_com_arenaofkings_packets_loginserver_TournamentMatchData_a;
    private boolean var_boolean_a;

    public aaa(aab aab2, ayh ayh2, ayh ayh3, ayh ayh4, ayf ayf2) {
        this.var_aab_a = aab2;
        this.var_ayh_a = ayh2;
        this.var_ayh_b = ayh3;
        this.var_ayh_c = ayh4;
        this.var_ayf_a = ayf2;
    }

    @Override
    public void a(float f2, Engine engine) {
    }

    @Override
    public void b(float f2, Engine engine) {
        if (this.var_aab_a.var_boolean_b) {
            if (Gdx.input.isKeyJustPressed(111)) {
                this.c();
                return;
            }
            int n2 = 0;
            int n3 = 1;
            Object object = this.var_aab_a.var_ayh_b.iterator();
            while (object.hasNext()) {
                TournamentMatchData tournamentMatchData = (TournamentMatchData)object.next();
                if (n3 != tournamentMatchData.round) {
                    n2 = 0;
                    n3 = tournamentMatchData.round;
                }
                int n4 = -250 + n3 * 300;
                int n5 = 1050 - n3 * 80 - n2++ * 200;
                n4 = (int)((float)n4 + this.var_com_badlogic_gdx_math_Vector2_c.x);
                n5 = (int)((float)n5 - this.var_com_badlogic_gdx_math_Vector2_c.y);
                n4 = (int)((float)n4 + this.d.x);
                n5 = (int)((float)n5 - this.d.y);
                this.var_ayf_a.a((float)n4, n5);
                this.var_ayf_a.a(f2, engine);
                this.var_ayf_a.b(f2, engine);
                if (this.var_ayf_a.boolean_a()) {
                    this.var_com_arenaofkings_packets_loginserver_TournamentMatchData_a = tournamentMatchData;
                }
                engine.a(String.valueOf(tournamentMatchData.team_1_seed), engine.var_axy_c.a(), Color.WHITE, engine.var_axy_c.a(), Color.BLACK, (float)(n4 + 16), (float)(n5 + 62), 8, 1);
                engine.a(String.valueOf(tournamentMatchData.team_2_seed), engine.var_axy_c.a(), Color.WHITE, engine.var_axy_c.a(), Color.BLACK, (float)(n4 + 16), (float)(n5 + 33), 8, 1);
                engine.a(String.valueOf(tournamentMatchData.team_1_name), engine.var_axy_c.a(), axe.E, engine.var_axy_c.a(), Color.BLACK, (float)(n4 + 40), (float)(n5 + 71), 8, 1);
                engine.a(String.valueOf(tournamentMatchData.team_2_name), engine.var_axy_c.a(), axe.E, engine.var_axy_c.a(), Color.BLACK, (float)(n4 + 40), (float)(n5 + 40), 8, 1);
                engine.a("[" + String.valueOf(tournamentMatchData.team_1_tag) + "]", engine.var_axy_b.a(), axe.E, engine.var_axy_b.a(), Color.BLACK, (float)(n4 + 40), (float)(n5 + 57), 8, 1);
                engine.a("[" + String.valueOf(tournamentMatchData.team_2_tag) + "]", engine.var_axy_b.a(), axe.E, engine.var_axy_b.a(), Color.BLACK, (float)(n4 + 40), (float)(n5 + 26), 8, 1);
                engine.a(String.valueOf(tournamentMatchData.team_1_score), engine.var_axy_c.a(), Color.WHITE, engine.var_axy_c.a(), Color.BLACK, (float)(n4 + 196), (float)(n5 + 60), 1, 1);
                engine.a(String.valueOf(tournamentMatchData.team_2_score), engine.var_axy_c.a(), Color.WHITE, engine.var_axy_c.a(), Color.BLACK, (float)(n4 + 196), (float)(n5 + 32), 1, 1);
            }
            if (this.var_com_arenaofkings_packets_loginserver_TournamentMatchData_a != null) {
                if (this.var_com_arenaofkings_packets_loginserver_TournamentMatchData_a.team_1_score != 5 && this.var_com_arenaofkings_packets_loginserver_TournamentMatchData_a.team_2_score != 5) {
                    engine.var_z_a.void_a(new PUB_MISC_CHAT_MESSAGE("/spectate " + this.var_com_arenaofkings_packets_loginserver_TournamentMatchData_a.team_1_captain));
                } else {
                    object = new PUB_MISC_CHAT_MESSAGE(" ", "[RED]Spectate not available, that Game has completed.[]");
                    ((PUB_MISC_CHAT_MESSAGE)object).channel = " ";
                    ((we)engine.axc_a()).wh_a().wg_a().a((PUB_MISC_CHAT_MESSAGE)object, " ", true);
                }
            } else if (!this.var_boolean_a && Gdx.input.justTouched()) {
                this.c();
            }
            this.var_com_arenaofkings_packets_loginserver_TournamentMatchData_a = null;
            this.var_boolean_a = false;
        }
    }

    public void a(float f2, float f3) {
        this.var_com_badlogic_gdx_math_Vector2_b.set(f2, f3);
    }

    public void b(float f2, float f3) {
        this.var_com_badlogic_gdx_math_Vector2_a = new Vector2(f2, f3);
        this.var_com_badlogic_gdx_math_Vector2_c = this.var_com_badlogic_gdx_math_Vector2_a.cpy().sub(this.var_com_badlogic_gdx_math_Vector2_b);
    }

    public void void_a() {
        this.d.add(this.var_com_badlogic_gdx_math_Vector2_c);
        this.var_com_badlogic_gdx_math_Vector2_c.set(0.0f, 0.0f);
    }

    public aab aab_a() {
        return this.var_aab_a;
    }

    public void b() {
        this.var_boolean_a = true;
        ((Engine)((Object)this.var_aab_a.var_aaf_a.var_ayh_a)).var_baa_a.a(ajw.kD, 0.5f);
        this.var_aab_a.var_boolean_b = true;
    }

    public void c() {
        ((Engine)((Object)this.var_aab_a.var_aaf_a.var_ayh_a)).var_baa_a.a(ajw.kE, 0.4f);
        this.var_aab_a.var_boolean_b = false;
    }
}

