/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.gameserver.data.EffectList;

public final class oq
extends Enum<oq> {
    public static final /* enum */ oq var_oq_a;
    public static final /* enum */ oq b;
    public static final /* enum */ oq c;
    public static final /* enum */ oq d;
    public static final /* enum */ oq e;
    public static final /* enum */ oq f;
    public static final /* enum */ oq g;
    public static final /* enum */ oq h;
    public static final /* enum */ oq i;
    public static final /* enum */ oq j;
    public static final /* enum */ oq k;
    private int var_int_a;
    private static final /* synthetic */ oq[] var_oq_arr_a;

    public static oq[] values() {
        return (oq[])var_oq_arr_a.clone();
    }

    public static oq valueOf(String string) {
        return Enum.valueOf(oq.class, string);
    }

    private oq(int n3) {
        this.var_int_a = n3;
    }

    public int a() {
        return this.var_int_a;
    }

    public static oq a(oo oo2) {
        if (oo2 == null) {
            return k;
        }
        EffectList effectList = oo2.op_a().com_arenaofkings_packets_gameserver_data_EffectList_a();
        if (effectList == EffectList.Windstorm) {
            return var_oq_a;
        }
        if (effectList == EffectList.Stun) {
            return b;
        }
        if (effectList == EffectList.Sheepify) {
            return d;
        }
        if (effectList == EffectList.Incapacitate) {
            return c;
        }
        if (effectList == EffectList.Fear) {
            return e;
        }
        if (effectList == EffectList.Silence) {
            return f;
        }
        if (effectList == EffectList.Freeze || effectList == EffectList.EtherealBindings || effectList == EffectList.FlashFreeze || effectList == EffectList.CripplingSlash || effectList == EffectList.GraspingVines || effectList == EffectList.Slash || effectList == EffectList.Charge || effectList == EffectList.Hypothermia || effectList == EffectList.DeathsGrasp) {
            return g;
        }
        if (effectList == EffectList.Immortality) {
            return h;
        }
        if (effectList == EffectList.Vigor || effectList == EffectList.SpiritForm) {
            return i;
        }
        if (effectList == EffectList.Stealth) {
            return j;
        }
        return k;
    }

    public static oo a(oo oo2, oo oo3) {
        if (oq.a((oo)oo2).var_int_a <= oq.a((oo)oo3).var_int_a) {
            return oo2;
        }
        return oo3;
    }

    static {
        var_oq_a = new oq(0);
        b = new oq(1);
        c = new oq(2);
        d = new oq(3);
        e = new oq(4);
        f = new oq(5);
        g = new oq(6);
        h = new oq(7);
        i = new oq(8);
        j = new oq(9);
        k = new oq(10);
        var_oq_arr_a = new oq[]{var_oq_a, b, c, d, e, f, g, h, i, j, k};
    }
}

