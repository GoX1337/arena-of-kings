/*
 * Decompiled with CFR 0.152.
 */
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class bmm
extends bmz {
    private final btz var_btz_a;
    private final bmy.a var_bmy$a_a;
    private final boolean var_boolean_a;

    bmm(bfn bfn2, btz btz2, bmy.a a2, boolean bl2) {
        super(bfn2);
        this.var_btz_a = btz2;
        this.var_bmy$a_a = bfn2 == null ? null : a2;
        this.var_boolean_a = bl2;
    }

    public static List<bml> a(bfn bfn2, bns bns2, bmy.a a2, btz btz2, bfw bfw2, boolean bl2) {
        return new bmm(bfn2, btz2, a2, bl2).a(bns2, bfw2);
    }

    List<bml> a(bns bns2, bfw bfw2) {
        Map<String, a> map = this.a(bns2, bfw2, null);
        if (map == null) {
            return Collections.emptyList();
        }
        ArrayList<bml> arrayList = new ArrayList<bml>(map.size());
        for (a a2 : map.values()) {
            arrayList.add(a2.a());
        }
        return arrayList;
    }

    private Map<String, a> a(bns bns2, bfw bfw2, Map<String, a> map) {
        bfw bfw3 = bfw2.bfw_e();
        if (bfw3 == null) {
            return map;
        }
        Object t2 = bfw2.a();
        map = this.a(new bns.a(this.var_btz_a, bfw3.bty_a()), bfw3, map);
        Object object = ((Class)t2).getDeclaredFields();
        int n2 = ((Field[])object).length;
        for (int i2 = 0; i2 < n2; ++i2) {
            Field field = object[i2];
            if (!this.a(field)) continue;
            if (map == null) {
                map = new LinkedHashMap<String, a>();
            }
            a a2 = new a(bns2, field);
            if (this.var_boolean_a) {
                a2.var_bmt_a = this.a(a2.var_bmt_a, field.getDeclaredAnnotations());
            }
            map.put(field.getName(), a2);
        }
        if (map != null && this.var_bmy$a_a != null && (object = this.var_bmy$a_a.a((Class<?>)t2)) != null) {
            this.a((Class<?>)object, (Class<?>)t2, map);
        }
        return map;
    }

    private void a(Class<?> clazz, Class<?> clazz2, Map<String, a> map) {
        List<Class<?>> list = buk.b(clazz, clazz2, true);
        for (Class<?> clazz3 : list) {
            for (Field field : clazz3.getDeclaredFields()) {
                String string;
                a a2;
                if (!this.a(field) || (a2 = map.get(string = field.getName())) == null) continue;
                a2.var_bmt_a = this.a(a2.var_bmt_a, field.getDeclaredAnnotations());
            }
        }
    }

    private boolean a(Field field) {
        if (field.isSynthetic()) {
            return false;
        }
        int n2 = field.getModifiers();
        return !Modifier.isStatic(n2);
    }

    static final class a {
        public final bns var_bns_a;
        public final Field var_java_lang_reflect_Field_a;
        public bmt var_bmt_a;

        public a(bns bns2, Field field) {
            this.var_bns_a = bns2;
            this.var_java_lang_reflect_Field_a = field;
            this.var_bmt_a = bmt.bmt_a();
        }

        public bml a() {
            return new bml(this.var_bns_a, this.var_java_lang_reflect_Field_a, (bmu)this.var_bmt_a.bmu_a());
        }
    }
}

