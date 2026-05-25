/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.misc.ArenaTeamData;
import com.arenaofkings.packets.misc.ArenaTeamMemberData;
import java.util.ArrayList;

public class zg {
    private String var_java_lang_String_a = new ArrayList();
    private int var_int_a;
    private String var_java_lang_String_b;
    private String var_java_lang_String_c;
    private String var_java_lang_String_d;
    private int var_int_b;
    private int var_int_c;
    private int var_int_d;
    private int var_int_e;
    private int f;
    private String var_java_lang_String_e;
    private ArrayList<ArenaTeamMemberData> var_java_util_ArrayList_com_arenaofkings_packets_misc_ArenaTeamMemberData__a;

    @Deprecated
    public zg() {
    }

    public zg(ArenaTeamData arenaTeamData) {
        this.a(arenaTeamData.name);
        this.f(arenaTeamData.id);
        this.b(arenaTeamData.tag);
        this.c(arenaTeamData.country);
        this.d(arenaTeamData.logo);
        this.a(arenaTeamData.rank);
        this.b(arenaTeamData.points);
        this.d(arenaTeamData.wins);
        this.c(arenaTeamData.losses);
        this.e(arenaTeamData.fame);
        this.e(arenaTeamData.achievements);
    }

    public String java_lang_String_a() {
        return this.var_java_lang_String_a;
    }

    public void a(String string) {
        this.var_java_lang_String_a = string;
    }

    public String java_lang_String_b() {
        return this.var_java_lang_String_b;
    }

    public void b(String string) {
        this.var_java_lang_String_b = string;
    }

    public String java_lang_String_c() {
        return this.var_java_lang_String_c;
    }

    public void c(String string) {
        this.var_java_lang_String_c = string;
    }

    public String java_lang_String_d() {
        return this.var_java_lang_String_d;
    }

    public void d(String string) {
        this.var_java_lang_String_d = string;
    }

    public int int_a() {
        return this.var_int_b;
    }

    public void a(int n2) {
        this.var_int_b = n2;
    }

    public int int_b() {
        return this.var_int_c;
    }

    public void b(int n2) {
        this.var_int_c = n2;
    }

    public int int_c() {
        return this.var_int_e;
    }

    public int int_d() {
        return this.var_int_d;
    }

    public void c(int n2) {
        this.var_int_e = n2;
    }

    public void d(int n2) {
        this.var_int_d = n2;
    }

    public ArrayList<ArenaTeamMemberData> a() {
        return this.var_java_lang_String_a;
    }

    public String java_lang_String_e() {
        return this.var_java_lang_String_e;
    }

    public int int_e() {
        return this.f;
    }

    public void e(String string) {
        this.var_java_lang_String_e = string;
    }

    public void e(int n2) {
        this.f = n2;
    }

    public void f(int n2) {
        this.var_int_a = n2;
    }

    public int f() {
        return this.var_int_a;
    }

    public int g() {
        return this.var_int_a;
    }

    public String toString() {
        return this.var_java_lang_String_a + " [" + this.var_java_lang_String_b + "]";
    }
}

