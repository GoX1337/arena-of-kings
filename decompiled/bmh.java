/*
 * Decompiled with CFR 0.152.
 */
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

public final class bmh
extends bmg
implements bns {
    private static final a var_bmh$a_b;
    protected final bfw var_bfw_a;
    protected final Class<?> var_java_lang_Class____a;
    protected final bty var_bty_a;
    protected final List<bfw> var_java_util_List_bfw__a;
    protected final bfn var_bfn_a;
    protected final btz var_btz_a;
    protected final bmy.a var_bmy$a_a;
    protected final Class<?> var_java_lang_Class____b;
    protected final boolean var_boolean_a;
    protected final bud var_bud_a;
    protected a var_bmh$a_a;
    protected bmq var_bmq_a;
    protected List<bml> var_java_util_List_bml__b;
    protected transient Boolean var_java_lang_Boolean_a;

    bmh(bfw bfw2, Class<?> clazz, List<bfw> list, Class<?> clazz2, bud bud2, bty bty2, bfn bfn2, bmy.a a2, btz btz2, boolean bl2) {
        this.var_bfw_a = bfw2;
        this.var_bfw_a = clazz;
        this.var_bfw_a = list;
        this.var_bmh$a_b = clazz2;
        this.var_bud_a = bud2;
        this.var_bty_a = bty2;
        this.var_bfn_a = bfn2;
        this.var_bmy$a_a = a2;
        this.var_btz_a = btz2;
        this.var_boolean_a = bl2;
    }

    bmh(Class<?> clazz) {
        this.var_bfw_a = null;
        this.var_bfw_a = clazz;
        this.var_bfw_a = Collections.emptyList();
        this.var_bmh$a_b = null;
        this.var_bud_a = bmt.bmu_a();
        this.var_bty_a = bty.bty_a();
        this.var_bfn_a = null;
        this.var_bmy$a_a = null;
        this.var_btz_a = null;
        this.var_boolean_a = false;
    }

    @Override
    public bfw a(Type type) {
        return this.var_btz_a.a(type, this.var_bty_a);
    }

    public Class<?> b() {
        return this.var_bfw_a;
    }

    @Override
    public String java_lang_String_a() {
        return ((Class)((Object)this.var_bfw_a)).getName();
    }

    @Override
    public <A extends Annotation> A a(Class<A> clazz) {
        return this.var_bud_a.a(clazz);
    }

    @Override
    public boolean a(Class<?> clazz) {
        return this.var_bud_a.a(clazz);
    }

    @Override
    public boolean a(Class<? extends Annotation>[] classArray) {
        return this.var_bud_a.a(classArray);
    }

    @Override
    public Class<?> a() {
        return this.var_bfw_a;
    }

    @Override
    public bfw bfw_a() {
        return this.var_bfw_a;
    }

    public bud bud_a() {
        return this.var_bud_a;
    }

    public boolean boolean_a() {
        return this.var_bud_a.a() > 0;
    }

    public bmj bmj_a() {
        return this.bmh$a_a().var_bmj_a;
    }

    public List<bmj> a() {
        return this.bmh$a_a().var_bmj_a;
    }

    public List<bmo> b() {
        return this.bmh$a_a().b;
    }

    public Iterable<bmo> a() {
        return this.bmq_a();
    }

    public bmo a(String string, Class<?>[] classArray) {
        return this.bmq_a().a(string, classArray);
    }

    public Iterable<bml> b() {
        return this.c();
    }

    public boolean b() {
        Boolean bl2 = this.var_java_lang_Boolean_a;
        if (bl2 == null) {
            this.var_java_lang_Boolean_a = bl2 = Boolean.valueOf(buk.i(this.var_bfw_a));
        }
        return bl2;
    }

    private final List<bml> c() {
        Object object = this.var_bmh$a_b;
        if (object == null) {
            object = this.var_bfw_a == null ? Collections.emptyList() : bmm.a(this.var_bfn_a, this, this.var_bmy$a_a, this.var_btz_a, this.var_bfw_a, this.var_boolean_a);
            this.var_bmh$a_b = object;
        }
        return object;
    }

    private final bmq bmq_a() {
        bmq bmq2 = this.var_bmq_a;
        if (bmq2 == null) {
            bmq2 = this.var_bfw_a == null ? new bmq() : bmp.a(this.var_bfn_a, this, this.var_bmy$a_a, this.var_btz_a, this.var_bfw_a, (List<bfw>)((Object)this.var_bfw_a), this.var_bmh$a_b, this.var_boolean_a);
            this.var_bmq_a = bmq2;
        }
        return bmq2;
    }

    private final a bmh$a_a() {
        a a2 = this.var_bmh$a_a;
        if (a2 == null) {
            a2 = this.var_bfw_a == null ? var_bmh$a_b : bmk.a(this.var_bfn_a, this.var_btz_a, this, this.var_bfw_a, this.var_bmh$a_b, this.var_boolean_a);
            this.var_bmh$a_a = a2;
        }
        return a2;
    }

    @Override
    public String toString() {
        return "[AnnotedClass " + ((Class)((Object)this.var_bfw_a)).getName() + "]";
    }

    @Override
    public int hashCode() {
        return ((Class)((Object)this.var_bfw_a)).getName().hashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (buk.a(object, this.getClass()) == false) {
            return false;
        }
        return ((bmh)object).var_bfw_a == this.var_bfw_a;
    }

    @Override
    public /* synthetic */ AnnotatedElement java_lang_reflect_AnnotatedElement_a() {
        return this.b();
    }

    static {
        var_bmh$a_b = new a(null, Collections.emptyList(), Collections.emptyList());
    }

    public static final class a {
        public final bmj var_bmj_a;
        public final List<bmj> var_java_util_List_bmj__a;
        public final List<bmo> b;

        public a(bmj bmj2, List<bmj> list, List<bmo> list2) {
            this.var_bmj_a = bmj2;
            this.var_bmj_a = list;
            this.b = list2;
        }
    }
}

