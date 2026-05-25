/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Member;

public abstract class bmn
extends bmg
implements Serializable {
    protected final transient bns var_bns_a;
    protected final transient bmu var_bmu_a;

    protected bmn(bns bns2, bmu bmu2) {
        this.var_bns_a = bns2;
        this.var_bmu_a = bmu2;
    }

    public abstract bmg a(bmu var1);

    public abstract Class<?> b();

    public abstract Member java_lang_reflect_Member_a();

    public String java_lang_String_b() {
        return this.b().getName() + "#" + this.java_lang_String_a();
    }

    @Override
    public final <A extends Annotation> A a(Class<A> clazz) {
        if (this.var_bmu_a == null) {
            return null;
        }
        return this.var_bmu_a.a(clazz);
    }

    @Override
    public final boolean a(Class<?> clazz) {
        if (this.var_bmu_a == null) {
            return false;
        }
        return this.var_bmu_a.a(clazz);
    }

    @Override
    public boolean a(Class<? extends Annotation>[] classArray) {
        if (this.var_bmu_a == null) {
            return false;
        }
        return this.var_bmu_a.a(classArray);
    }

    public bmu bmu_a() {
        return this.var_bmu_a;
    }

    public final void a(boolean bl2) {
        Member member = this.java_lang_reflect_Member_a();
        if (member != null) {
            buk.a(member, bl2);
        }
    }

    public abstract void a(Object var1, Object var2);

    public abstract Object b(Object var1);
}

