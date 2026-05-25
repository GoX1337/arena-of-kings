/*
 * Decompiled with CFR 0.152.
 */
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class bmp
extends bmz {
    private final bmy.a var_bmy$a_a;
    private final boolean var_boolean_a;

    bmp(bfn bfn2, bmy.a a2, boolean bl2) {
        super(bfn2);
        this.var_bmy$a_a = bfn2 == null ? null : a2;
        this.var_boolean_a = bl2;
    }

    public static bmq a(bfn bfn2, bns bns2, bmy.a a2, btz btz2, bfw bfw2, List<bfw> list, Class<?> clazz, boolean bl2) {
        return new bmp(bfn2, a2, bl2).a(btz2, bns2, bfw2, list, clazz);
    }

    bmq a(btz btz2, bns bns2, bfw bfw2, List<bfw> list, Class<?> clazz) {
        Object object;
        Class<?> clazz2;
        LinkedHashMap<bne, a> linkedHashMap = new LinkedHashMap<bne, a>();
        this.b(bns2, (Class<?>)bfw2.a(), (Map<bne, a>)linkedHashMap, clazz);
        for (bfw object22 : list) {
            Class<?> clazz3 = this.var_bmy$a_a == null ? null : this.var_bmy$a_a.a((Class<?>)object22.a());
            this.b(new bns.a(btz2, object22.bty_a()), (Class<?>)object22.a(), (Map<bne, a>)linkedHashMap, clazz3);
        }
        boolean bl2 = false;
        if (this.var_bmy$a_a != null && (clazz2 = this.var_bmy$a_a.a(Object.class)) != null) {
            this.a(bns2, (Class<?>)bfw2.a(), (Map<bne, a>)linkedHashMap, clazz2);
            bl2 = true;
        }
        if (bl2 && this.var_bmy$a_a != null && !linkedHashMap.isEmpty()) {
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                bne bne2 = (bne)entry.getKey();
                if (!"hashCode".equals(bne2.java_lang_String_a()) || 0 != bne2.int_a()) continue;
                try {
                    object = Object.class.getDeclaredMethod(bne2.java_lang_String_a(), new Class[0]);
                    if (object == null) continue;
                    a a2 = (a)entry.getValue();
                    a2.var_bmt_a = this.b(a2.var_bmt_a, ((Method)object).getDeclaredAnnotations());
                    a2.var_java_lang_reflect_Method_a = object;
                }
                catch (Exception exception) {}
            }
        }
        if (linkedHashMap.isEmpty()) {
            return new bmq();
        }
        LinkedHashMap<bne, bmo> linkedHashMap2 = new LinkedHashMap<bne, bmo>(linkedHashMap.size());
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            object = ((a)entry.getValue()).a();
            if (object == null) continue;
            linkedHashMap2.put((bne)entry.getKey(), (bmo)object);
        }
        return new bmq(linkedHashMap2);
    }

    private void b(bns bns2, Class<?> clazz, Map<bne, a> map, Class<?> clazz2) {
        if (clazz2 != null) {
            this.a(bns2, clazz, map, clazz2);
        }
        if (clazz == null) {
            return;
        }
        for (Method method : buk.java_lang_reflect_Method_arr_a(clazz)) {
            Object object;
            if (!bmp.a(method)) continue;
            bne bne2 = new bne(method);
            a a2 = map.get(bne2);
            if (a2 == null) {
                object = this.var_bmy$a_a == null ? bmt.bmt_a() : this.a(method.getDeclaredAnnotations());
                map.put(bne2, new a(bns2, method, (bmt)object));
                continue;
            }
            if (this.var_boolean_a) {
                a2.var_bmt_a = this.b(a2.var_bmt_a, method.getDeclaredAnnotations());
            }
            if ((object = a2.var_java_lang_reflect_Method_a) == null) {
                a2.var_java_lang_reflect_Method_a = method;
                continue;
            }
            if (!Modifier.isAbstract(((Method)object).getModifiers()) || Modifier.isAbstract(method.getModifiers())) continue;
            a2.var_java_lang_reflect_Method_a = method;
            a2.var_bns_a = bns2;
        }
    }

    protected void a(bns bns2, Class<?> clazz, Map<bne, a> map, Class<?> clazz2) {
        if (this.var_bmy$a_a == null) {
            return;
        }
        for (Class<?> clazz3 : buk.a(clazz2, clazz, true)) {
            for (Method method : clazz3.getDeclaredMethods()) {
                if (!bmp.a(method)) continue;
                bne bne2 = new bne(method);
                a a2 = map.get(bne2);
                Annotation[] annotationArray = method.getDeclaredAnnotations();
                if (a2 == null) {
                    map.put(bne2, new a(bns2, null, this.a(annotationArray)));
                    continue;
                }
                a2.var_bmt_a = this.b(a2.var_bmt_a, annotationArray);
            }
        }
    }

    private static boolean a(Method method) {
        if (Modifier.isStatic(method.getModifiers()) || method.isSynthetic() || method.isBridge()) {
            return false;
        }
        int n2 = method.getParameterTypes().length;
        return n2 <= 2;
    }

    static final class a {
        public bns var_bns_a;
        public Method var_java_lang_reflect_Method_a;
        public bmt var_bmt_a;

        public a(bns bns2, Method method, bmt bmt2) {
            this.var_bns_a = bns2;
            this.var_java_lang_reflect_Method_a = method;
            this.var_bmt_a = bmt2;
        }

        public bmo a() {
            if (this.var_java_lang_reflect_Method_a == null) {
                return null;
            }
            return new bmo(this.var_bns_a, this.var_java_lang_reflect_Method_a, (bmu)this.var_bmt_a.bmu_a(), null);
        }
    }
}

