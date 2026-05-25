/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.misc.ArenaName;
import com.arenaofkings.packets.misc.ArenaTeamData;

public class agp
extends ayl {
    protected ArenaName var_com_arenaofkings_packets_misc_ArenaName_a;
    protected boolean var_boolean_a;
    protected boolean var_boolean_b;
    protected boolean c;
    protected ArenaTeamData var_com_arenaofkings_packets_misc_ArenaTeamData_a = new ArenaTeamData();
    protected ArenaTeamData var_com_arenaofkings_packets_misc_ArenaTeamData_b = new ArenaTeamData();

    public void a(boolean bl2) {
        this.var_boolean_a = bl2;
    }

    public void b(boolean bl2) {
        this.c = bl2;
    }

    public void c(boolean bl2) {
        this.var_boolean_b = bl2;
    }

    public void a(ArenaName arenaName) {
        this.var_com_arenaofkings_packets_misc_ArenaName_a = arenaName;
    }

    public void a(ArenaTeamData arenaTeamData) {
        this.var_com_arenaofkings_packets_misc_ArenaTeamData_b = arenaTeamData;
    }

    public void b(ArenaTeamData arenaTeamData) {
        this.var_com_arenaofkings_packets_misc_ArenaTeamData_a = arenaTeamData;
    }

    public boolean boolean_a() {
        return this.var_boolean_b;
    }

    public ArenaTeamData com_arenaofkings_packets_misc_ArenaTeamData_a() {
        return this.var_com_arenaofkings_packets_misc_ArenaTeamData_b;
    }

    public ArenaTeamData com_arenaofkings_packets_misc_ArenaTeamData_b() {
        return this.var_com_arenaofkings_packets_misc_ArenaTeamData_a;
    }

    public ArenaName com_arenaofkings_packets_misc_ArenaName_a() {
        return this.var_com_arenaofkings_packets_misc_ArenaName_a;
    }

    public boolean boolean_b() {
        return this.var_boolean_a;
    }

    public boolean c() {
        return this.c;
    }
}

