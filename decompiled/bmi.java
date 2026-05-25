/*
 * Decompiled with CFR 0.152.
 */
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class bmi {
    private static final bud var_bud_a;
    private static final Class<?> var_java_lang_Class____a;
    private static final Class<?> b;
    private static final Class<?> c;
    private static final Class<?> d;
    private final bhm<?> var_bhm____a;
    private final bfn var_bfn_a;
    private final bmy.a var_bmy$a_a;
    private final bty var_bty_a;
    private final bfw var_bfw_a;
    private final Class<?> e;
    private final Class<?> f;
    private final boolean var_boolean_a;

    bmi(bhm<?> bhm2, bfw bfw2, bmy.a a2) {
        this.var_bud_a = bhm2;
        this.var_bfw_a = bfw2;
        this.e = bfw2.a();
        this.var_bmy$a_a = a2;
        this.var_bty_a = bfw2.bty_a();
        this.var_bfn_a = bhm2.b() ? bhm2.bfn_a() : null;
        this.f = a2 == null ? null : a2.a(this.e);
        this.var_boolean_a = this.var_bfn_a != null && (!buk.h(this.e) || !this.var_bfw_a.m());
    }

    bmi(bhm<?> bhm2, Class<?> clazz, bmy.a a2) {
        this.var_bud_a = bhm2;
        this.var_bfw_a = null;
        this.e = clazz;
        this.var_bmy$a_a = a2;
        this.var_bty_a = bty.bty_a();
        if (bhm2 == null) {
            this.var_bfn_a = null;
            this.f = null;
        } else {
            this.var_bfn_a = bhm2.b() ? bhm2.bfn_a() : null;
            this.f = a2 == null ? null : a2.a(this.e);
        }
        this.var_boolean_a = this.var_bfn_a != null;
    }

    public static bmh a(bhm<?> bhm2, bfw bfw2, bmy.a a2) {
        if (bfw2.boolean_f() && bmi.boolean_a(bhm2, bfw2.a())) {
            return bmi.b(bhm2, bfw2.a());
        }
        return new bmi(bhm2, bfw2, a2).a();
    }

    public static bmh bmh_a(bhm<?> bhm2, Class<?> clazz) {
        return bmi.a(bhm2, clazz, bhm2);
    }

    public static bmh a(bhm<?> bhm2, Class<?> clazz, bmy.a a2) {
        if (clazz.isArray() && bmi.boolean_a(bhm2, clazz)) {
            return bmi.b(bhm2, clazz);
        }
        return new bmi(bhm2, clazz, a2).b();
    }

    private static boolean boolean_a(bhm<?> bhm2, Class<?> clazz) {
        return bhm2 == null || bhm2.a(clazz) == null;
    }

    static bmh a(Class<?> clazz) {
        return new bmh(clazz);
    }

    static bmh b(bhm<?> bhm2, Class<?> clazz) {
        return new bmh(clazz);
    }

    bmh a() {
        ArrayList<bfw> arrayList = new ArrayList<bfw>(8);
        if (!this.var_bfw_a.boolean_a(Object.class)) {
            if (this.var_bfw_a.j()) {
                bmi.b(this.var_bfw_a, arrayList, false);
            } else {
                bmi.a(this.var_bfw_a, arrayList, false);
            }
        }
        return new bmh(this.var_bfw_a, this.e, arrayList, this.f, this.a(arrayList), this.var_bty_a, this.var_bfn_a, this.var_bmy$a_a, ((bhm)((Object)this.var_bud_a)).btz_a(), this.var_boolean_a);
    }

    bmh b() {
        List<bfw> list = Collections.emptyList();
        return new bmh(null, this.e, list, this.f, this.a(list), this.var_bty_a, this.var_bfn_a, this.var_bmy$a_a, ((bhm)((Object)this.var_bud_a)).btz_a(), this.var_boolean_a);
    }

    private static void a(bfw bfw2, List<bfw> list, boolean bl2) {
        Object t2 = bfw2.a();
        if (t2 == var_bud_a || t2 == b) {
            return;
        }
        if (bl2) {
            if (bmi.a(list, t2)) {
                return;
            }
            list.add(bfw2);
        }
        for (bfw bfw3 : bfw2.a()) {
            bmi.b(bfw3, list, true);
        }
        bfw bfw4 = bfw2.bfw_e();
        if (bfw4 != null) {
            bmi.a(bfw4, list, true);
        }
    }

    private static void b(bfw bfw2, List<bfw> list, boolean bl2) {
        Object t2 = bfw2.a();
        if (bl2) {
            if (bmi.a(list, t2)) {
                return;
            }
            list.add(bfw2);
            if (t2 == c || t2 == d) {
                return;
            }
        }
        for (bfw bfw3 : bfw2.a()) {
            bmi.b(bfw3, list, true);
        }
    }

    private static boolean a(List<bfw> list, Class<?> clazz) {
        int n2 = list.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            if (list.get(i2).a() != clazz) continue;
            return true;
        }
        return false;
    }

    private bud a(List<bfw> list) {
        boolean bl2;
        if (this.var_bfn_a == null) {
            return var_bud_a;
        }
        boolean bl3 = bl2 = this.var_bmy$a_a != null && (!(this.var_bmy$a_a instanceof bnr) || ((bnr)this.var_bmy$a_a).a());
        if (!bl2 && !this.var_boolean_a) {
            return var_bud_a;
        }
        bmt bmt2 = bmt.bmt_a();
        if (this.f != null) {
            bmt2 = this.a(bmt2, this.e, this.f);
        }
        if (this.var_boolean_a) {
            bmt2 = this.a(bmt2, buk.java_lang_annotation_Annotation_arr_a(this.e));
        }
        for (bfw bfw2 : list) {
            if (bl2) {
                Object t2 = bfw2.a();
                bmt2 = this.a(bmt2, (Class<?>)t2, this.var_bmy$a_a.a((Class<?>)t2));
            }
            if (!this.var_boolean_a) continue;
            bmt2 = this.a(bmt2, buk.java_lang_annotation_Annotation_arr_a(bfw2.a()));
        }
        if (bl2) {
            bmt2 = this.a(bmt2, Object.class, this.var_bmy$a_a.a(Object.class));
        }
        return bmt2.b();
    }

    private bmt a(bmt bmt2, Class<?> clazz, Class<?> clazz2) {
        if (clazz2 != null) {
            bmt2 = this.a(bmt2, buk.java_lang_annotation_Annotation_arr_a(clazz2));
            for (Class<?> clazz3 : buk.b(clazz2, clazz, false)) {
                bmt2 = this.a(bmt2, buk.java_lang_annotation_Annotation_arr_a(clazz3));
            }
        }
        return bmt2;
    }

    private bmt a(bmt bmt2, Annotation[] annotationArray) {
        if (annotationArray != null) {
            for (Annotation annotation : annotationArray) {
                if (bmt2.boolean_a(annotation)) continue;
                bmt2 = bmt2.bmt_a(annotation);
                if (!this.var_bfn_a.a(annotation)) continue;
                bmt2 = this.a(bmt2, annotation);
            }
        }
        return bmt2;
    }

    private bmt a(bmt bmt2, Annotation annotation) {
        for (Annotation annotation2 : buk.java_lang_annotation_Annotation_arr_a(annotation.annotationType())) {
            if (annotation2 instanceof Target || annotation2 instanceof Retention || bmt2.boolean_a(annotation2)) continue;
            bmt2 = bmt2.bmt_a(annotation2);
            if (!this.var_bfn_a.a(annotation2)) continue;
            bmt2 = this.a(bmt2, annotation2);
        }
        return bmt2;
    }

    static {
        var_bud_a = bmt.bmu_a();
        var_bud_a = Object.class;
        b = Enum.class;
        c = List.class;
        d = Map.class;
    }
}

