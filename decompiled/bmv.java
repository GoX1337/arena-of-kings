/*
 * Decompiled with CFR 0.152.
 */
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class bmv
extends bfo {
    private static final Class<?>[] b = new Class[0];
    protected final bnj var_bnj_a;
    protected final bhm<?> var_bhm____a;
    protected final bfn var_bfn_a;
    protected final bmh var_bmh_a;
    protected Class<?>[] var_java_lang_Class____arr_a;
    protected boolean var_boolean_a;
    protected List<bmx> var_java_util_List_bmx__a;
    protected bni var_bni_a;

    protected bmv(bnj bnj2, bfw bfw2, bmh bmh2) {
        super(bfw2);
        this.var_bnj_a = bnj2;
        this.var_bnj_a = bnj2.a();
        this.var_bfn_a = this.var_bnj_a == null ? null : ((bhm)((Object)this.var_bnj_a)).bfn_a();
        this.var_bmh_a = bmh2;
    }

    protected bmv(bhm<?> bhm2, bfw bfw2, bmh bmh2, List<bmx> list) {
        super(bfw2);
        this.var_bnj_a = null;
        this.var_bnj_a = bhm2;
        this.var_bfn_a = this.var_bnj_a == null ? null : ((bhm)((Object)this.var_bnj_a)).bfn_a();
        this.var_bmh_a = bmh2;
        this.var_bnj_a = list;
    }

    protected bmv(bnj bnj2) {
        this(bnj2, bnj2.bfw_a(), bnj2.bmh_a());
        this.var_bni_a = bnj2.bni_a();
    }

    public static bmv a(bnj bnj2) {
        return new bmv(bnj2);
    }

    public static bmv b(bnj bnj2) {
        return new bmv(bnj2);
    }

    public static bmv a(bhm<?> bhm2, bfw bfw2, bmh bmh2) {
        return new bmv(bhm2, bfw2, bmh2, Collections.emptyList());
    }

    protected List<bmx> e() {
        if (this.var_bnj_a == null) {
            this.var_bnj_a = this.var_bnj_a.a();
        }
        return this.var_bnj_a;
    }

    public boolean a(String string) {
        Iterator<bmx> iterator = this.e().iterator();
        while (iterator.hasNext()) {
            bmx bmx2 = iterator.next();
            if (!bmx2.java_lang_String_a().equals(string)) continue;
            iterator.remove();
            return true;
        }
        return false;
    }

    public boolean a(bmx bmx2) {
        if (this.boolean_a(bmx2.bgj_a())) {
            return false;
        }
        this.e().add(bmx2);
        return true;
    }

    public boolean boolean_a(bgj bgj2) {
        return this.bmx_a(bgj2) != null;
    }

    public bmx bmx_a(bgj bgj2) {
        for (bmx bmx2 : this.e()) {
            if (!bmx2.boolean_a(bgj2)) continue;
            return bmx2;
        }
        return null;
    }

    @Override
    public bmh bmh_a() {
        return this.var_bmh_a;
    }

    @Override
    public bni bni_a() {
        return this.var_bni_a;
    }

    @Override
    public List<bmx> a() {
        return this.e();
    }

    @Override
    public bmn bmn_a() {
        return this.var_bnj_a == null ? null : this.var_bnj_a.bmn_a();
    }

    @Override
    public bmn bmn_b() {
        return this.var_bnj_a == null ? null : this.var_bnj_a.b();
    }

    @Override
    public Set<String> a() {
        Set<String> set;
        Set<String> set2 = set = this.var_bnj_a == null ? null : this.var_bnj_a.a();
        if (set == null) {
            return Collections.emptySet();
        }
        return set;
    }

    @Override
    public boolean boolean_b() {
        return this.var_bmh_a.boolean_a();
    }

    @Override
    public bud bud_a() {
        return this.var_bmh_a.bud_a();
    }

    @Override
    public bmj bmj_a() {
        return this.var_bmh_a.bmj_a();
    }

    @Override
    public bmn d() {
        if (this.var_bnj_a != null) {
            bmn bmn2 = this.var_bnj_a.bmn_a();
            if (bmn2 != null) {
                Class<?> clazz = ((bmo)bmn2).a(0);
                if (clazz != String.class && clazz != Object.class) {
                    throw new IllegalArgumentException(String.format("Invalid 'any-setter' annotation on method '%s()': first argument not of type String or Object, but %s", ((bmo)bmn2).java_lang_String_a(), clazz.getName()));
                }
                return bmn2;
            }
            bmn bmn3 = this.var_bnj_a.e();
            if (bmn3 != null) {
                AnnotatedElement annotatedElement = bmn3.java_lang_reflect_AnnotatedElement_a();
                if (!Map.class.isAssignableFrom((Class<?>)annotatedElement)) {
                    throw new IllegalArgumentException(String.format("Invalid 'any-setter' annotation on field '%s': type is not instance of java.util.Map", bmn3.java_lang_String_a()));
                }
                return bmn3;
            }
        }
        return null;
    }

    @Override
    public Map<Object, bmn> a() {
        if (this.var_bnj_a != null) {
            return this.var_bnj_a.a();
        }
        return Collections.emptyMap();
    }

    @Override
    public List<bmj> c() {
        return this.var_bmh_a.a();
    }

    @Override
    public Object a(boolean bl2) {
        bmj bmj2 = this.var_bmh_a.bmj_a();
        if (bmj2 == null) {
            return null;
        }
        if (bl2) {
            bmj2.a(((bhm)((Object)this.var_bnj_a)).a(bgd.o));
        }
        try {
            return ((Constructor)bmj2.java_lang_Object_a()).newInstance(new Object[0]);
        }
        catch (Exception exception) {
            Throwable throwable = exception;
            while (throwable.getCause() != null) {
                throwable = throwable.getCause();
            }
            buk.java_lang_Throwable_a(throwable);
            buk.java_lang_Throwable_b(throwable);
            throw new IllegalArgumentException("Failed to instantiate bean of type " + this.var_bmh_a.b().getName() + ": (" + throwable.getClass().getName() + ") " + buk.java_lang_String_a(throwable), throwable);
        }
    }

    @Override
    public bmo a(String string, Class<?>[] classArray) {
        return this.var_bmh_a.a(string, classArray);
    }

    @Override
    public bbk.d a(bbk.d object) {
        Object object2;
        if (this.var_bfn_a != null && (object2 = this.var_bfn_a.java_lang_Object_a((bmg)this.var_bmh_a)) != null) {
            object = object == null ? object2 : ((bbk.d)object).a((bbk.d)object2);
        }
        if ((object2 = ((bhm)((Object)this.var_bnj_a)).bbk$d_a((Class<?>)this.var_bmh_a.java_lang_reflect_AnnotatedElement_a())) != null) {
            object = object == null ? object2 : ((bbk.d)object).a((bbk.d)object2);
        }
        return object;
    }

    @Override
    public Class<?>[] java_lang_Class____arr_a() {
        if (!this.var_boolean_a) {
            Class<?>[] classArray;
            this.var_boolean_a = true;
            Class<?>[] classArray2 = classArray = this.var_bfn_a == null ? null : this.var_bfn_a.java_lang_Class____arr_a((bmg)this.var_bmh_a);
            if (classArray == null && !((bhm)((Object)this.var_bnj_a)).a(bgd.s)) {
                classArray = b;
            }
            this.var_bnj_a = classArray;
        }
        return this.var_bnj_a;
    }

    @Override
    public bum<Object, Object> a() {
        if (this.var_bfn_a == null) {
            return null;
        }
        return this.a(this.var_bfn_a.java_lang_Object_f(this.var_bmh_a));
    }

    @Override
    public bbr.b a(bbr.b b2) {
        Object object;
        if (this.var_bfn_a != null && (object = this.var_bfn_a.java_lang_Object_a((bmg)this.var_bmh_a)) != null) {
            return b2 == null ? object : b2.a((bbr.b)object);
        }
        return b2;
    }

    @Override
    public bmn c() {
        if (this.var_bnj_a != null) {
            bmn bmn2 = this.var_bnj_a.d();
            if (bmn2 != null) {
                AnnotatedElement annotatedElement = bmn2.java_lang_reflect_AnnotatedElement_a();
                if (!Map.class.isAssignableFrom((Class<?>)annotatedElement)) {
                    throw new IllegalArgumentException(String.format("Invalid 'any-getter' annotation on method %s(): return type is not instance of java.util.Map", bmn2.java_lang_String_a()));
                }
                return bmn2;
            }
            bmn bmn3 = this.var_bnj_a.c();
            if (bmn3 != null) {
                AnnotatedElement annotatedElement = bmn3.java_lang_reflect_AnnotatedElement_a();
                if (!Map.class.isAssignableFrom((Class<?>)annotatedElement)) {
                    throw new IllegalArgumentException(String.format("Invalid 'any-getter' annotation on field '%s': type is not instance of java.util.Map", bmn3.java_lang_String_a()));
                }
                return bmn3;
            }
        }
        return null;
    }

    @Override
    public List<bmx> b() {
        ArrayList<bmx> arrayList = null;
        HashSet<String> hashSet = null;
        for (bmx bmx2 : this.e()) {
            bfn.a a2 = bmx2.bfn$a_a();
            if (a2 == null || !a2.b()) continue;
            String string = a2.java_lang_String_a();
            if (arrayList == null) {
                arrayList = new ArrayList<bmx>();
                hashSet = new HashSet<String>();
                hashSet.add(string);
            } else if (!hashSet.add(string)) {
                throw new IllegalArgumentException("Multiple back-reference properties with name " + buk.b(string));
            }
            arrayList.add(bmx2);
        }
        return arrayList;
    }

    @Override
    public List<bmo> d() {
        List<bmo> list = this.var_bmh_a.b();
        if (list.isEmpty()) {
            return list;
        }
        ArrayList<bmo> arrayList = null;
        for (bmo bmo2 : list) {
            if (!this.a(bmo2)) continue;
            if (arrayList == null) {
                arrayList = new ArrayList<bmo>();
            }
            arrayList.add(bmo2);
        }
        if (arrayList == null) {
            return Collections.emptyList();
        }
        return arrayList;
    }

    @Override
    public Constructor<?> a(Class<?> ... classArray) {
        for (bmj bmj2 : this.var_bmh_a.a()) {
            if (bmj2.int_a() != 1) continue;
            Class<?> clazz = bmj2.a(0);
            for (Class<?> clazz2 : classArray) {
                if (clazz2 != clazz) continue;
                return bmj2.java_lang_Object_a();
            }
        }
        return null;
    }

    @Override
    public Method a(Class<?> ... classArray) {
        for (bmo bmo2 : this.var_bmh_a.b()) {
            if (!this.a(bmo2) || bmo2.int_a() != 1) continue;
            Class<?> clazz = bmo2.a(0);
            for (Class<?> clazz2 : classArray) {
                if (!clazz.isAssignableFrom(clazz2)) continue;
                return bmo2.java_lang_reflect_Method_a();
            }
        }
        return null;
    }

    protected boolean a(bmo bmo2) {
        Class<?> clazz;
        Class<?> clazz2 = bmo2.c();
        if (!this.a().isAssignableFrom(clazz2)) {
            return false;
        }
        bbh.a a2 = this.var_bfn_a.bbh$a_a((bhm<?>)((Object)this.var_bnj_a), bmo2);
        if (a2 != null && a2 != bbh.a.d) {
            return true;
        }
        String string = bmo2.java_lang_String_a();
        if ("valueOf".equals(string) && bmo2.int_a() == 1) {
            return true;
        }
        return "fromString".equals(string) && bmo2.int_a() == 1 && ((clazz = bmo2.a(0)) == String.class || CharSequence.class.isAssignableFrom(clazz));
    }

    @Override
    public Class<?> b() {
        return this.var_bfn_a == null ? null : this.var_bfn_a.java_lang_Object_a(this.var_bmh_a);
    }

    @Override
    public bgt.a bgt$a_a() {
        return this.var_bfn_a == null ? null : this.var_bfn_a.java_lang_Object_a(this.var_bmh_a);
    }

    @Override
    public bum<Object, Object> b() {
        if (this.var_bfn_a == null) {
            return null;
        }
        return this.a(this.var_bfn_a.j(this.var_bmh_a));
    }

    protected bum<Object, Object> a(Object object) {
        bum bum2;
        if (object == null) {
            return null;
        }
        if (object instanceof bum) {
            return (bum)object;
        }
        if (!(object instanceof Class)) {
            throw new IllegalStateException("AnnotationIntrospector returned Converter definition of type " + object.getClass().getName() + "; expected type Converter or Class<Converter> instead");
        }
        Class clazz = (Class)object;
        if (clazz == bum.a.class || buk.c(clazz)) {
            return null;
        }
        if (!bum.class.isAssignableFrom(clazz)) {
            throw new IllegalStateException("AnnotationIntrospector returned Class " + clazz.getName() + "; expected Class<Converter>");
        }
        bhl bhl2 = ((bhm)((Object)this.var_bnj_a)).bhl_a();
        bum bum3 = bum2 = bhl2 == null ? null : bhl2.a((bhm<?>)((Object)this.var_bnj_a), (bmg)this.var_bmh_a, (Class<?>)clazz);
        if (bum2 == null) {
            bum2 = (bum)buk.a(clazz, ((bhm)((Object)this.var_bnj_a)).c());
        }
        return bum2;
    }
}

