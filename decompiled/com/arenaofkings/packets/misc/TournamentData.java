/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.misc;

import com.arenaofkings.packets.misc.TournamentStatus;

public class TournamentData {
    public int id;
    public String name;
    public String info;
    public String sponsor;
    public TournamentStatus status;
    public int max_teams;
    public int first_place_arena_team_id;
    public int second_place_arena_team_id;
    public String prize_1;
    public String prize_2;
    public String prize_3_4;
    public String prize_5_8;
    public String prize_9_16;
    public String prize_17_32;
    public String prize_33_64;
    public String prize_participants;
    public int qp_prize_1;
    public int qp_prize_2;
    public int qp_prize_3_4;
    public int qp_prize_5_8;
    public int qp_prize_9_16;
    public int qp_prize_17_32;
    public int qp_prize_33_64;
    public int qp_prize_participants;
    public String date;
    public String db_date;

    public String toString() {
        return "TournamentData [id=" + this.id + ", name=" + this.name + ", info=" + this.info + ", sponsor=" + this.sponsor + ", status=" + (Object)((Object)this.status) + ", max_teams=" + this.max_teams + ", first_place_arena_team_id=" + this.first_place_arena_team_id + ", second_place_arena_team_id=" + this.second_place_arena_team_id + ", prize_1=" + this.prize_1 + ", prize_2=" + this.prize_2 + ", prize_3_4=" + this.prize_3_4 + ", prize_5_8=" + this.prize_5_8 + ", prize_9_16=" + this.prize_9_16 + ", prize_17_32=" + this.prize_17_32 + ", prize_33_64=" + this.prize_33_64 + ", date=" + this.date + "]";
    }
}

