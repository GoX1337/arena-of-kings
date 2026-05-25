/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.CharacterClass;
import java.util.HashMap;

public class dg {
    private HashMap<Class<? extends dc>, dc> a = new HashMap();

    public dg() {
        this.a();
    }

    public dg(CharacterClass characterClass, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, double d12, double d13, double d14, double d15, double d16, double d17, double d18, double d19) {
        this.a.put(eb.class, new eb(d2));
        this.a.put(ds.class, new ds(d3));
        this.a.put(di.class, new di(d4));
        this.a.put(ee.class, new ee(d5));
        this.a.put(dj.class, new dj(d6));
        this.a.put(dv.class, new dv(d7));
        this.a.put(dn.class, new dn(d8));
        this.a.put(dp.class, new dp(d9));
        this.a.put(dw.class, new dw(d10));
        this.a.put(ea.class, new ea(0.0));
        this.a.put(ec.class, new ec(0.0));
        this.a.put(dm.class, new dm(d11));
        this.a.put(dl.class, new dl(d12));
        this.a.put(dk.class, new dk(d13));
        this.a.put(du.class, new du(d14));
        this.a.put(dt.class, new dt(0.0));
        this.a.put(_do.class, new _do(d15));
        this.a.put(ed.class, new ed(d16));
        this.a.put(dq.class, new dq(d17));
        this.a.put(dy.class, new dy(d18));
        this.a.put(dx.class, new dx(d19));
        this.a.put(dr.class, new dr(0.0));
        this.a(characterClass);
    }

    public void a(CharacterClass characterClass) {
        this.a.get(dm.class).void_a(1067.0);
        this.a.get(dq.class).void_a(25.0);
        this.a.get(dy.class).void_a(30.0);
        this.a.get(dp.class).void_a(0.0);
        this.a.get(dw.class).void_a(0.0);
        switch (characterClass) {
            case ASSASSIN: {
                this.a.get(di.class).void_a(670.0);
                this.a.get(eb.class).void_a(300.0);
                break;
            }
            case CHAMPION: {
                this.a.get(eb.class).void_a(670.0);
                this.a.get(di.class).void_a(300.0);
                break;
            }
            case ELDER: {
                this.a.get(ee.class).void_a(670.0);
                this.a.get(di.class).void_a(300.0);
                break;
            }
            case LICH: {
                this.a.get(ds.class).void_a(670.0);
                this.a.get(eb.class).void_a(300.0);
                break;
            }
            case MYSTIC: {
                this.a.get(ee.class).void_a(670.0);
                this.a.get(ds.class).void_a(300.0);
                break;
            }
            case NIHILIST: {
                this.a.get(ds.class).void_a(705.0);
                this.a.get(eb.class).void_a(325.0);
                break;
            }
            case PALADIN: {
                this.a.get(eb.class).void_a(705.0);
                this.a.get(ee.class).void_a(325.0);
                break;
            }
            case RANGER: {
                this.a.get(di.class).void_a(670.0);
                this.a.get(eb.class).void_a(300.0);
                break;
            }
            case SCHOLAR: {
                this.a.get(ee.class).void_a(670.0);
                this.a.get(ds.class).void_a(300.0);
                break;
            }
            case WIZARD: {
                this.a.get(ds.class).void_a(670.0);
                this.a.get(ee.class).void_a(300.0);
                break;
            }
        }
        this.a.put(dz.class, new dz(365.0));
    }

    public void a() {
        this.a.put(eb.class, new eb(0.0));
        this.a.put(ds.class, new ds(0.0));
        this.a.put(di.class, new di(0.0));
        this.a.put(ee.class, new ee(0.0));
        this.a.put(dj.class, new dj(0.0));
        this.a.put(dv.class, new dv(0.0));
        this.a.put(dn.class, new dn(0.0));
        this.a.put(dp.class, new dp(0.0));
        this.a.put(dw.class, new dw(0.0));
        this.a.put(ec.class, new ec(0.0));
        this.a.put(ea.class, new ea(0.0));
        this.a.put(dm.class, new dm(0.0));
        this.a.put(dl.class, new dl(0.0));
        this.a.put(dk.class, new dk(0.0));
        this.a.put(du.class, new du(0.0));
        this.a.put(_do.class, new _do(0.0));
        this.a.put(ed.class, new ed(0.0));
        this.a.put(dq.class, new dq(0.0));
        this.a.put(dy.class, new dy(0.0));
        this.a.put(dx.class, new dx(0.0));
        this.a.put(dt.class, new dt(0.0));
        this.a.put(dr.class, new dr(0.0));
        this.a.put(dz.class, new dz(0.0));
    }

    public void b() {
        for (dc dc2 : this.a.values()) {
            dc2.void_b();
            Engine.b("reset attribute: " + dc2.getClass().getName());
        }
    }

    public double double_a(Class<? extends dc> clazz) {
        dc dc2 = this.a.get(clazz);
        if (dc2 != null) {
            return dc2.double_b();
        }
        System.out.println("Attribute: " + clazz.getName() + " is null in SingleAttributes.getTotalSheetValue()");
        return 0.0;
    }

    public double b(Class<? extends dc> clazz) {
        dc dc2 = this.a.get(clazz);
        if (dc2 != null) {
            return dc2.double_a();
        }
        System.out.println("Attribute: " + clazz.getName() + " is null in SingleAttributes.getTotalCalculatedValue()");
        return 0.0;
    }

    public dc dc_a(Class<? extends dc> clazz) {
        return this.a.get(clazz);
    }

    public HashMap<Class<? extends dc>, dc> a() {
        return this.a;
    }
}

