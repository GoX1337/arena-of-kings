/*
 * Decompiled with CFR 0.152.
 */
public class gf
extends gk {
    private int a = 1;
    private int b = 0;
    private int c = 0;

    public int a() {
        return this.a;
    }

    public void a(int n2) {
        this.a = n2;
    }

    public int b() {
        int n2 = 0;
        for (br br2 : this.a.values()) {
            n2 += br2.int_a();
        }
        return n2;
    }

    public int c() {
        this.b = 0;
        for (br br2 : this.a.values()) {
            this.b += br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().l();
        }
        this.b /= this.a.values().size();
        return this.b;
    }

    public int d() {
        this.c = 0;
        for (br br2 : this.a.values()) {
            this.c += br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().k();
        }
        this.c /= this.a.values().size();
        return this.c;
    }
}

