/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.HitCircle;
import com.arenaofkings.packets.gameserver.data.Location;
import com.arenaofkings.packets.gameserver.data.LocationType;
import com.arenaofkings.packets.gameserver.data.Target;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import java.util.ArrayList;

public class hf {
    protected SpellName var_com_arenaofkings_packets_gameserver_data_updates_SpellName_a;
    protected String var_java_lang_String_a;
    protected azv var_azv_a;
    protected azv var_azv_b;
    protected azv var_azv_c;
    protected long var_long_b;
    protected gx var_gx_a;
    protected int var_int_a;
    protected int var_int_b;
    protected long var_long_c;
    protected uh var_uh_a;
    protected uk var_uk_a;
    protected LocationType var_com_arenaofkings_packets_gameserver_data_LocationType_a;
    protected ArrayList<Location> var_java_util_ArrayList_com_arenaofkings_packets_gameserver_data_Location__a;
    protected HitCircle var_com_arenaofkings_packets_gameserver_data_HitCircle_a;
    protected boolean var_boolean_c;
    protected boolean var_boolean_d = false;
    protected boolean var_boolean_e;
    protected boolean f;
    protected boolean g = true;
    protected int var_int_c = 1;
    protected int var_int_d = 1;
    protected int var_int_e;

    public hf(SpellName spellName, long l2, long l3, gx gx2, int n2, int n3, long l4, uh uh2, uk uk2, LocationType locationType, boolean bl2, boolean bl3) {
        this.var_com_arenaofkings_packets_gameserver_data_updates_SpellName_a = spellName;
        this.var_azv_c = new azv(l4, false);
        this.var_azv_a = new azv(l2, false);
        this.var_azv_b = new azv(l3, false);
        this.var_long_b = l3;
        this.var_gx_a = gx2;
        this.var_int_a = n2;
        this.var_int_b = n3;
        this.var_long_c = l4;
        this.var_uh_a = uh2;
        this.var_uk_a = uk2;
        this.var_com_arenaofkings_packets_gameserver_data_updates_SpellName_a = new ArrayList();
        this.var_com_arenaofkings_packets_gameserver_data_LocationType_a = locationType;
        this.var_com_arenaofkings_packets_gameserver_data_HitCircle_a = new HitCircle(n3);
        this.var_boolean_c = bl2;
        this.var_boolean_d = bl3;
    }

    public long long_b() {
        return this.var_long_c;
    }

    public azv azv_a() {
        return this.var_azv_c;
    }

    public azv azv_b() {
        return this.var_azv_a;
    }

    public SpellName com_arenaofkings_packets_gameserver_data_updates_SpellName_a() {
        return this.var_com_arenaofkings_packets_gameserver_data_updates_SpellName_a;
    }

    public String java_lang_String_a() {
        return this.var_java_lang_String_a;
    }

    public azv azv_c() {
        return this.var_azv_b;
    }

    public uh uh_a() {
        return this.var_uh_a;
    }

    public LocationType com_arenaofkings_packets_gameserver_data_LocationType_a() {
        return this.var_com_arenaofkings_packets_gameserver_data_LocationType_a;
    }

    public boolean boolean_c() {
        return this.var_boolean_c;
    }

    public int int_a() {
        return this.var_int_b;
    }

    public gx gx_a() {
        return this.var_gx_a;
    }

    public int int_b() {
        return this.var_int_a;
    }

    public uk uk_a() {
        return this.var_uk_a;
    }

    public void a(Target target) {
        ((ArrayList)((Object)this.var_com_arenaofkings_packets_gameserver_data_updates_SpellName_a)).add(new Location(target));
        this.var_com_arenaofkings_packets_gameserver_data_LocationType_a = LocationType.TARGETED;
    }

    public void void_a() {
        ((ArrayList)((Object)this.var_com_arenaofkings_packets_gameserver_data_updates_SpellName_a)).clear();
    }

    public ArrayList<Location> a() {
        return this.var_com_arenaofkings_packets_gameserver_data_updates_SpellName_a;
    }

    public void a(Location location) {
        ((ArrayList)((Object)this.var_com_arenaofkings_packets_gameserver_data_updates_SpellName_a)).add(location);
    }

    public HitCircle com_arenaofkings_packets_gameserver_data_HitCircle_a() {
        return this.var_com_arenaofkings_packets_gameserver_data_HitCircle_a;
    }

    public boolean boolean_d() {
        return this.var_boolean_d;
    }

    public boolean e() {
        return this.f;
    }

    public int int_c() {
        return this.var_int_d;
    }

    public void a(int n2) {
        this.var_int_c = n2;
        if (this.var_int_c <= 0) {
            this.var_int_c = 0;
            this.g = false;
        } else if (this.var_int_c > this.var_int_d) {
            this.var_int_c = this.var_int_d;
        }
    }

    public void b(int n2) {
        this.var_int_d = n2;
    }

    public int int_d() {
        return this.var_int_e;
    }

    public void c(boolean bl2) {
        this.f = bl2;
    }

    public void a(String string) {
        this.var_java_lang_String_a = string;
    }

    public void c(int n2) {
        this.var_int_e = n2;
    }

    public void d(boolean bl2) {
        this.var_boolean_e = bl2;
    }

    public String toString() {
        return "SpellLogic [spellName=" + (Object)((Object)this.var_com_arenaofkings_packets_gameserver_data_updates_SpellName_a) + ", castTimer=" + this.var_azv_a + ", cooldownTimer=" + this.var_azv_b + ", FIXED_COOLDOWN_MILLISECONDS=" + this.var_long_b + ", resource=" + (Object)((Object)this.var_gx_a) + ", resource_cost=" + this.var_int_a + ", range=" + this.var_int_b + ", aliveTime=" + this.var_long_c + ", legalTargets=" + (Object)((Object)this.var_uh_a) + ", spellType=" + (Object)((Object)this.var_uk_a) + ", locationType=" + (Object)((Object)this.var_com_arenaofkings_packets_gameserver_data_LocationType_a) + ", locations=" + (Object)((Object)this.var_com_arenaofkings_packets_gameserver_data_updates_SpellName_a) + ", hitCircle=" + this.var_com_arenaofkings_packets_gameserver_data_HitCircle_a + ", castWhileMoving=" + this.var_boolean_c + "]";
    }
}

