/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.TournamentData;
import com.arenaofkings.packets.misc.TournamentStatus;
import java.util.Date;

public class zz
implements Comparable<zz> {
    public int var_int_a;
    public String var_java_lang_String_a;
    public String var_java_lang_String_b;
    public String var_java_lang_String_c;
    public TournamentStatus var_com_arenaofkings_packets_misc_TournamentStatus_a;
    public int var_int_b;
    public int var_int_c;
    public int var_int_d;
    public String var_java_lang_String_d;
    public String var_java_lang_String_e;
    public String var_java_lang_String_f;
    public String var_java_lang_String_g;
    public String var_java_lang_String_h;
    public String var_java_lang_String_i;
    public String var_java_lang_String_j;
    public String var_java_lang_String_k;
    public int var_int_e = 0;
    public int var_int_f = 0;
    public int var_int_g = 0;
    public int var_int_h = 0;
    public int var_int_i = 0;
    public int var_int_j = 0;
    public int var_int_k = 0;
    public int var_int_l = 0;
    public Date var_java_util_Date_a;
    public int m;
    public String var_java_lang_String_l;

    public zz() {
    }

    public zz(TournamentData tournamentData) {
        this.var_int_a = tournamentData.id;
        this.var_java_lang_String_a = tournamentData.name;
        this.var_java_lang_String_b = tournamentData.info;
        this.var_java_lang_String_c = tournamentData.sponsor;
        this.var_com_arenaofkings_packets_misc_TournamentStatus_a = tournamentData.status;
        this.var_int_b = tournamentData.max_teams;
        this.var_int_c = tournamentData.first_place_arena_team_id;
        this.var_int_d = tournamentData.second_place_arena_team_id;
        this.var_java_lang_String_d = tournamentData.prize_1;
        this.var_java_lang_String_e = tournamentData.prize_2;
        this.var_java_lang_String_f = tournamentData.prize_3_4;
        this.var_java_lang_String_g = tournamentData.prize_5_8;
        this.var_java_lang_String_h = tournamentData.prize_9_16;
        this.var_java_lang_String_i = tournamentData.prize_17_32;
        this.var_java_lang_String_j = tournamentData.prize_33_64;
        this.var_java_lang_String_k = tournamentData.prize_participants;
        this.var_int_e = tournamentData.qp_prize_1;
        this.var_int_f = tournamentData.qp_prize_2;
        this.var_int_g = tournamentData.qp_prize_3_4;
        this.var_int_h = tournamentData.qp_prize_5_8;
        this.var_int_i = tournamentData.qp_prize_9_16;
        this.var_int_j = tournamentData.qp_prize_17_32;
        this.var_int_k = tournamentData.qp_prize_33_64;
        this.var_int_l = tournamentData.qp_prize_participants;
        Engine.b("Date is: " + tournamentData.date);
        this.var_java_util_Date_a = new Date(Integer.valueOf(tournamentData.date).intValue());
        this.m = Integer.valueOf(tournamentData.date);
        Engine.b("Loaded date");
        this.var_java_lang_String_l = tournamentData.db_date;
    }

    public int int_a() {
        return this.var_int_a;
    }

    public String java_lang_String_a() {
        return this.var_java_lang_String_a;
    }

    public String b() {
        return this.var_java_lang_String_c;
    }

    public TournamentStatus com_arenaofkings_packets_misc_TournamentStatus_a() {
        return this.var_com_arenaofkings_packets_misc_TournamentStatus_a;
    }

    public Date java_util_Date_a() {
        return this.var_java_util_Date_a;
    }

    public String toString() {
        return "Tournament [id=" + this.var_int_a + ", name=" + this.var_java_lang_String_a + ", info=" + this.var_java_lang_String_b + ", sponsor=" + this.var_java_lang_String_c + ", status=" + (Object)((Object)this.var_com_arenaofkings_packets_misc_TournamentStatus_a) + ", max_teams=" + this.var_int_b + ", first_place_arena_team_id=" + this.var_int_c + ", second_place_arena_team_id=" + this.var_int_d + ", prize_1=" + this.var_java_lang_String_d + ", prize_2=" + this.var_java_lang_String_e + ", prize_3_4=" + this.var_java_lang_String_f + ", prize_5_8=" + this.var_java_lang_String_g + ", prize_9_16=" + this.var_java_lang_String_h + ", prize_17_32=" + this.var_java_lang_String_i + ", prize_33_64=" + this.var_java_lang_String_j + ", event_date=" + this.var_java_util_Date_a + "]";
    }

    public int a(zz zz2) {
        if (this.var_java_util_Date_a.compareTo(zz2.var_java_util_Date_a) > 0) {
            return 1;
        }
        if (this.var_java_util_Date_a.compareTo(zz2.var_java_util_Date_a) < 0) {
            return -1;
        }
        if (this.var_int_a > zz2.var_int_a) {
            return 1;
        }
        return -1;
    }

    @Override
    public /* synthetic */ int compareTo(Object object) {
        return this.a((zz)object);
    }
}

