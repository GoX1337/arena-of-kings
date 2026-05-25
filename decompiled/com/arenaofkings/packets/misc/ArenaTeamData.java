/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.misc;

import com.arenaofkings.packets.misc.ArenaTeamMemberData;
import java.util.ArrayList;

public class ArenaTeamData {
    public String name;
    public int id;
    public String tag;
    public String country;
    public String logo;
    public int rank;
    public int points;
    public int wins;
    public int losses;
    public int fame;
    public String achievements;
    public ArrayList<ArenaTeamMemberData> members = new ArrayList();

    @Deprecated
    public ArenaTeamData() {
    }

    public ArenaTeamData(String string, int n2, String string2, String string3, String string4, int n3, int n4, int n5, int n6, int n7, String string5, ArrayList<ArenaTeamMemberData> arrayList, boolean bl2) {
        this.name = string;
        this.id = n2;
        this.tag = string2;
        this.country = string3;
        this.logo = string4;
        this.rank = n3;
        this.points = n4;
        this.wins = n5;
        this.losses = n6;
        this.fame = n7;
        this.achievements = string5;
        this.members = arrayList;
    }

    public ArenaTeamData(zg zg2) {
        this.name = zg2.java_lang_String_a();
        this.id = zg2.g();
        this.tag = zg2.java_lang_String_b();
        this.country = zg2.java_lang_String_c();
        this.logo = zg2.java_lang_String_d();
        this.rank = zg2.int_a();
        this.points = zg2.int_b();
        this.wins = zg2.int_d();
        this.losses = zg2.int_c();
        this.fame = zg2.int_e();
        this.achievements = zg2.java_lang_String_e();
        this.members = zg2.a();
    }

    public String toString() {
        return "ArenaTeamData [name=" + this.name + ", id=" + this.id + ", tag=" + this.tag + ", country=" + this.country + ", logo=" + this.logo + ", rank=" + this.rank + ", points=" + this.points + ", wins=" + this.wins + ", losses=" + this.losses + ", fame=" + this.fame + ", achievements=" + this.achievements + ", members=" + this.members + "]";
    }
}

