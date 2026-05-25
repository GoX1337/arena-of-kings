/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.arenaofkings.packets.misc.ArenaTeamData;
import com.arenaofkings.packets.misc.GameType;
import com.arenaofkings.packets.misc.ProfileBackgrounds;
import com.arenaofkings.packets.misc.StripeCustomerData;
import com.arenaofkings.packets.misc.items.ItemData;
import com.badlogic.gdx.utils.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class gd {
    private final String var_java_lang_String_a = new HashSet();
    private int var_int_a;
    private int var_int_b;
    private int var_int_c;
    private Set<String> var_java_util_Set_java_lang_String__a;
    private bn var_bn_a;
    private int var_int_d;
    private int var_int_e;
    private int var_int_f;
    private boolean var_boolean_a = false;
    private boolean var_boolean_b;
    private Date var_java_util_Date_a;
    private boolean var_boolean_c = false;
    private int var_int_g;
    private final ev var_ev_a;
    private axz var_axz_a = new axz();
    private GameType var_com_arenaofkings_packets_misc_GameType_a;
    private ArrayList<StripeCustomerData> var_java_util_ArrayList_com_arenaofkings_packets_misc_StripeCustomerData__a;
    private axd var_axd_a;
    private Array<zg> var_com_badlogic_gdx_utils_Array_zg__a;
    private zg var_zg_a;
    private ArrayList<zz> var_java_util_ArrayList_zz__b;
    private azv var_azv_a;
    private int h = -1;
    private int i = -1;
    private boolean var_boolean_d = false;
    private boolean var_boolean_e;
    private boolean var_boolean_f = false;
    private boolean var_boolean_g = false;
    private String var_java_lang_String_b = "December Monthly Championship";
    private int j = 2;
    private as var_as_a;
    private cg var_cg_a;
    private bu var_bu_a;
    private ca var_ca_a;
    private int k = 0;
    private azv var_azv_b;

    public gd(Engine engine, String string, int n2, int n3, int n4, int n5, int n6, int n7, int n8, boolean bl2, String string2, int n9, int n10, ev ev2, axz axz2, ArrayList<StripeCustomerData> arrayList, int n11, ArrayList<String> arrayList2, String string3, ArrayList<ArenaTeamData> arrayList3, ArrayList<ItemData> arrayList4, ArrayList<ItemData> arrayList5) {
        this.var_java_lang_String_a = new Array();
        this.var_int_b = (int)new ArrayList();
        this.var_azv_a = new azv(120000L, true);
        this.var_azv_b = new azv(60000L, false);
        this.var_java_lang_String_a = string;
        this.var_int_a = n2;
        this.var_int_b = n3;
        this.var_bn_a = new bn(n4);
        this.var_int_d = n5;
        this.var_int_e = n6;
        this.var_int_f = n7;
        if (n8 == 0) {
            this.var_boolean_a = false;
        } else if (n8 == 1) {
            this.var_boolean_a = true;
        }
        this.var_boolean_b = bl2;
        this.var_java_util_Date_a = new Date(Integer.valueOf(string2).intValue());
        this.j = n9;
        this.var_ev_a = ev2;
        this.var_axz_a = axz2;
        this.var_java_lang_String_a = arrayList;
        this.var_int_c = n11;
        this.void_a();
        for (String object : arrayList2) {
            this.var_java_lang_String_a.add(object);
        }
        this.var_axd_a = axd.valueOf(string3);
        for (ArenaTeamData arenaTeamData : arrayList3) {
            ((Array)((Object)this.var_java_lang_String_a)).add(new zg(arenaTeamData));
        }
        this.var_as_a = new as(engine, arrayList4);
        this.var_cg_a = new cg(engine);
        this.var_ca_a = new ca(engine);
        this.var_bu_a = new bu(engine, n10, arrayList5);
    }

    private void void_a() {
        this.var_java_lang_String_a.add("NONE");
        this.var_java_lang_String_a.add("PE_0");
        this.var_java_lang_String_a.add("SKIN_ASSASSIN_1");
        this.var_java_lang_String_a.add("SKIN_CHAMPION_1");
        this.var_java_lang_String_a.add("SKIN_ELDER_1");
        this.var_java_lang_String_a.add("SKIN_LICH_1");
        this.var_java_lang_String_a.add("SKIN_MYSTIC_1");
        this.var_java_lang_String_a.add("SKIN_NIHILIST_1");
        this.var_java_lang_String_a.add("SKIN_PALADIN_1");
        this.var_java_lang_String_a.add("SKIN_RANGER_1");
        this.var_java_lang_String_a.add("SKIN_SCHOLAR_1");
        this.var_java_lang_String_a.add("SKIN_WIZARD_1");
    }

    public void a(Engine engine, ArrayList<ItemData> arrayList) {
        this.var_as_a = new as(engine, arrayList);
    }

    public GameType com_arenaofkings_packets_misc_GameType_a() {
        return this.var_com_arenaofkings_packets_misc_GameType_a;
    }

    public int int_a() {
        return this.var_int_a;
    }

    public String java_lang_String_a() {
        return this.var_java_lang_String_a;
    }

    public void a(GameType gameType) {
        this.var_com_arenaofkings_packets_misc_GameType_a = gameType;
    }

    public int int_b() {
        return this.var_int_c;
    }

    public ev ev_a() {
        return this.var_ev_a;
    }

    public axz axz_a() {
        return this.var_axz_a;
    }

    public int int_c() {
        return this.var_int_d;
    }

    public int int_d() {
        return this.var_int_f;
    }

    public boolean a(ProfileBackgrounds profileBackgrounds) {
        return this.var_java_lang_String_a.contains(profileBackgrounds.name());
    }

    public boolean a(SpellName spellName) {
        if (this.a(abi.ar)) {
            return true;
        }
        return this.var_java_lang_String_a.contains(spellName.name());
    }

    public boolean a(abi abi2) {
        return this.var_java_lang_String_a.contains(abi2.name());
    }

    public int int_e() {
        return this.var_int_b;
    }

    public void a(int n2) {
        this.var_int_b = n2;
    }

    public void a(Engine engine, abi abi2) {
        if (abi2 == abi.ap) {
            this.i(1);
            return;
        }
        if (abi2 == abi.af || abi2 == abi.ag || abi2 == abi.am || abi2 == abi.ak || abi2 == abi.al) {
            return;
        }
        this.var_java_lang_String_a.add(abi2.name());
        if (abi2 == abi.ar) {
            // empty if block
        }
    }

    public void b(int n2) {
        this.var_int_e = n2;
    }

    public void c(int n2) {
        this.var_int_d = n2;
    }

    public void d(int n2) {
        this.var_int_f = n2;
    }

    public void e(int n2) {
        this.var_int_b += n2;
    }

    public void f(int n2) {
        this.var_int_a = n2;
    }

    public void g(int n2) {
        this.var_int_c = n2;
    }

    public void h(int n2) {
        this.var_int_g = n2;
    }

    public void a(zg zg2) {
        ((Array)((Object)this.var_java_lang_String_a)).add(zg2);
    }

    public void a(String string) {
        Iterator iterator = ((Array)((Object)this.var_java_lang_String_a)).iterator();
        while (iterator.hasNext()) {
            zg zg2 = (zg)iterator.next();
            if (!zg2.java_lang_String_a().equals(string)) continue;
            iterator.remove();
        }
    }

    public Array<zg> a() {
        return this.var_java_lang_String_a;
    }

    public ArrayList<zz> a() {
        return this.var_int_b;
    }

    public int int_f() {
        return this.i;
    }

    public int g() {
        return this.h;
    }

    public azv azv_a() {
        return this.var_azv_a;
    }

    public void a(int n2, int n3) {
        this.h = n2;
        this.i = n3;
        this.var_azv_a.void_c();
        this.var_boolean_d = this.h != -1 && this.i != -1;
    }

    public boolean boolean_a() {
        return this.var_boolean_d;
    }

    public void a(boolean bl2) {
        this.var_boolean_f = bl2;
    }

    public boolean boolean_b() {
        return this.var_boolean_f;
    }

    public as as_a() {
        return this.var_as_a;
    }

    public cg cg_a() {
        return this.var_cg_a;
    }

    public bu bu_a() {
        return this.var_bu_a;
    }

    public ca ca_a() {
        return this.var_ca_a;
    }

    public int h() {
        return this.j;
    }

    public void i(int n2) {
        this.j += n2;
    }

    public boolean boolean_c() {
        return this.var_boolean_a;
    }

    public boolean boolean_d() {
        return this.var_boolean_b;
    }

    public void b(boolean bl2) {
        this.var_boolean_b = bl2;
    }

    public void c(boolean bl2) {
        this.var_boolean_e = bl2;
    }

    public boolean boolean_e() {
        return this.h != -1 || this.i != -1;
    }

    public void b(String string) {
        this.var_java_lang_String_b = string;
    }

    public String java_lang_String_b() {
        return this.var_java_lang_String_b;
    }

    public zg zg_a() {
        return this.var_zg_a;
    }

    public void b(zg zg2) {
        this.var_zg_a = zg2;
    }

    public boolean boolean_f() {
        return this.var_boolean_c;
    }

    public void d(boolean bl2) {
        this.var_boolean_c = bl2;
    }

    public void j(int n2) {
        this.k = n2;
    }

    public int i() {
        return this.k;
    }

    public axd axd_a() {
        return this.var_axd_a;
    }

    public azv azv_b() {
        return this.var_azv_b;
    }
}

