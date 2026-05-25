/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

public class bmw
extends bmy
implements Serializable {
    private static final Class<?> var_java_lang_Class____a;
    private static final Class<?> var_java_lang_Class____b;
    private static final Class<?> var_java_lang_Class____c;
    protected static final bmv var_bmv_a;
    protected static final bmv var_bmv_b;
    protected static final bmv var_bmv_c;
    protected static final bmv d;
    protected static final bmv e;

    @Override
    public bmv a(bgm bgm2, bfw bfw2, bmy.a a2) {
        bmv bmv2 = this.a(bgm2, bfw2);
        if (bmv2 == null && (bmv2 = this.b(bgm2, bfw2)) == null) {
            bmv2 = bmv.b(this.a(bgm2, bfw2, a2, true));
        }
        return bmv2;
    }

    @Override
    public bmv bmv_a(bfr bfr2, bfw bfw2, bmy.a a2) {
        bmv bmv2 = this.a(bfr2, bfw2);
        if (bmv2 == null && (bmv2 = this.b(bfr2, bfw2)) == null) {
            bmv2 = bmv.a(this.a(bfr2, bfw2, a2, false));
        }
        return bmv2;
    }

    @Override
    public bmv a(bfr bfr2, bfw bfw2, bmy.a a2, bfo bfo2) {
        return bmv.a(this.a(bfr2, bfw2, a2, bfo2, false));
    }

    @Override
    public bmv bmv_b(bfr bfr2, bfw bfw2, bmy.a a2) {
        bmv bmv2 = this.a(bfr2, bfw2);
        if (bmv2 == null && (bmv2 = this.b(bfr2, bfw2)) == null) {
            bmv2 = bmv.a(this.a(bfr2, bfw2, a2, false));
        }
        return bmv2;
    }

    @Override
    public bmv bmv_a(bhm<?> bhm2, bfw bfw2, bmy.a a2) {
        bmv bmv2 = this.a(bhm2, bfw2);
        if (bmv2 == null) {
            bmv2 = bmv.a(bhm2, bfw2, this.bmh_a(bhm2, bfw2, a2));
        }
        return bmv2;
    }

    protected bnj a(bhm<?> bhm2, bfw bfw2, bmy.a a2, boolean bl2) {
        bmh bmh2 = this.bmh_a(bhm2, bfw2, a2);
        bmf bmf2 = bfw2.i() ? bhm2.bmf$a_a().b(bhm2, bmh2) : bhm2.bmf$a_a().a(bhm2, bmh2);
        return this.a(bhm2, bmh2, bfw2, bl2, bmf2);
    }

    protected bnj a(bhm<?> bhm2, bfw bfw2, bmy.a a2, bfo bfo2, boolean bl2) {
        bmh bmh2 = this.bmh_a(bhm2, bfw2, a2);
        bmf bmf2 = bhm2.bmf$a_a().a(bhm2, bmh2, bfo2);
        return this.a(bhm2, bmh2, bfw2, bl2, bmf2);
    }

    protected bnj a(bhm<?> bhm2, bmh bmh2, bfw bfw2, boolean bl2, bmf bmf2) {
        return new bnj(bhm2, bl2, bfw2, bmh2, bmf2);
    }

    protected bmv a(bhm<?> bhm2, bfw bfw2) {
        Object t2 = bfw2.a();
        if (((Class)t2).isPrimitive()) {
            if (t2 == Integer.TYPE) {
                return var_bmv_c;
            }
            if (t2 == Long.TYPE) {
                return d;
            }
            if (t2 == Boolean.TYPE) {
                return var_bmv_b;
            }
        } else if (buk.h(t2)) {
            if (t2 == var_java_lang_Class____a) {
                return e;
            }
            if (t2 == var_java_lang_Class____b) {
                return var_bmv_a;
            }
            if (t2 == Integer.class) {
                return var_bmv_c;
            }
            if (t2 == Long.class) {
                return d;
            }
            if (t2 == Boolean.class) {
                return var_bmv_b;
            }
        } else if (var_java_lang_Class____c.isAssignableFrom((Class<?>)t2)) {
            return bmv.a(bhm2, bfw2, bmi.a(t2));
        }
        return null;
    }

    protected boolean a(bfw bfw2) {
        if (!bfw2.m() || bfw2.boolean_f()) {
            return false;
        }
        Object t2 = bfw2.a();
        return buk.h(t2) && (Collection.class.isAssignableFrom((Class<?>)t2) || Map.class.isAssignableFrom((Class<?>)t2));
    }

    protected bmv b(bhm<?> bhm2, bfw bfw2) {
        if (this.a(bfw2)) {
            return bmv.a(bhm2, bfw2, this.bmh_a(bhm2, bfw2, bhm2));
        }
        return null;
    }

    protected bmh bmh_a(bhm<?> bhm2, bfw bfw2, bmy.a a2) {
        return bmi.a(bhm2, bfw2, a2);
    }

    @Override
    public /* synthetic */ bfo bfo_a(bfr bfr2, bfw bfw2, bmy.a a2) {
        return this.bmv_b(bfr2, bfw2, a2);
    }

    @Override
    public /* synthetic */ bfo bfo_b(bfr bfr2, bfw bfw2, bmy.a a2) {
        return this.bmv_a(bfr2, bfw2, a2);
    }

    static {
        var_java_lang_Class____a = Object.class;
        var_java_lang_Class____b = String.class;
        var_java_lang_Class____c = bfz.class;
        var_bmv_a = bmv.a(null, btw.btw_a(String.class), bmi.a(var_java_lang_Class____b));
        var_bmv_b = bmv.a(null, btw.btw_a(Boolean.TYPE), bmi.a(Boolean.TYPE));
        var_bmv_c = bmv.a(null, btw.btw_a(Integer.TYPE), bmi.a(Integer.TYPE));
        d = bmv.a(null, btw.btw_a(Long.TYPE), bmi.a(Long.TYPE));
        e = bmv.a(null, btw.btw_a(Object.class), bmi.a(var_java_lang_Class____a));
    }
}

