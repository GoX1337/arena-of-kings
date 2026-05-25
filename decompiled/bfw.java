/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.List;

public abstract class bfw
extends bet
implements Serializable,
Type {
    protected final Class<?> var_java_lang_Class____a;
    protected final int var_int_a;
    protected final Object var_java_lang_Object_a;
    protected final Object b;
    protected final boolean var_boolean_a;

    protected bfw(Class<?> clazz, int n2, Object object, Object object2, boolean bl2) {
        this.var_java_lang_Class____a = clazz;
        this.var_int_a = clazz.getName().hashCode() + n2;
        this.var_java_lang_Object_a = object;
        this.b = object2;
        this.var_boolean_a = bl2;
    }

    public abstract bfw btp_a(Object var1);

    public abstract bfw btp_b(Object var1);

    public abstract bfw btp_c(Object var1);

    public abstract bfw d(Object var1);

    public bfw bfw_a(bfw bfw2) {
        bfw bfw3 = this;
        Object t2 = bfw2.b();
        if (t2 != this.b) {
            bfw3 = bfw3.btp_a(t2);
        }
        if ((t2 = bfw2.a()) != this.var_java_lang_Object_a) {
            bfw3 = bfw3.btp_c(t2);
        }
        return bfw3;
    }

    public abstract bfw b(bfw var1);

    @Override
    public abstract bfw bfw_a();

    public abstract bfw a(Class<?> var1, bty var2, bfw var3, bfw[] var4);

    public final Class<?> a() {
        return this.var_java_lang_Class____a;
    }

    public final boolean boolean_a(Class<?> clazz) {
        return this.var_java_lang_Class____a == clazz;
    }

    public boolean boolean_b() {
        return true;
    }

    public final boolean b(Class<?> clazz) {
        return this.var_java_lang_Class____a == clazz || clazz.isAssignableFrom(this.var_java_lang_Class____a);
    }

    public final boolean c(Class<?> clazz) {
        return this.var_java_lang_Class____a == clazz || this.var_java_lang_Class____a.isAssignableFrom(clazz);
    }

    public boolean boolean_c() {
        return Modifier.isAbstract(this.var_java_lang_Class____a.getModifiers());
    }

    public boolean boolean_d() {
        int n2 = this.var_java_lang_Class____a.getModifiers();
        if ((n2 & 0x600) == 0) {
            return true;
        }
        return this.var_java_lang_Class____a.isPrimitive();
    }

    public boolean boolean_e() {
        return Throwable.class.isAssignableFrom(this.var_java_lang_Class____a);
    }

    public boolean boolean_f() {
        return false;
    }

    public final boolean g() {
        return buk.f(this.var_java_lang_Class____a);
    }

    public final boolean h() {
        return buk.f(this.var_java_lang_Class____a) && this.var_java_lang_Class____a != Enum.class;
    }

    public final boolean i() {
        return buk.d(this.var_java_lang_Class____a);
    }

    public final boolean j() {
        return this.var_java_lang_Class____a.isInterface();
    }

    public final boolean k() {
        return this.var_java_lang_Class____a.isPrimitive();
    }

    public final boolean l() {
        return Modifier.isFinal(this.var_java_lang_Class____a.getModifiers());
    }

    public abstract boolean m();

    public boolean n() {
        return false;
    }

    public boolean o() {
        return false;
    }

    public final boolean p() {
        return this.var_java_lang_Class____a == Object.class;
    }

    public final boolean q() {
        return this.var_boolean_a;
    }

    public boolean r() {
        return this.int_a() > 0;
    }

    public bfw bfw_b() {
        return null;
    }

    public bfw bfw_c() {
        return null;
    }

    public bfw bfw_d() {
        return null;
    }

    public abstract int int_a();

    public abstract bfw a(int var1);

    public bfw b(int n2) {
        bfw bfw2 = this.a(n2);
        return bfw2 == null ? btz.bfw_a() : bfw2;
    }

    public abstract bty bty_a();

    public abstract bfw bfw_a(Class<?> var1);

    public abstract bfw bfw_e();

    public abstract List<bfw> a();

    public <T> T a() {
        return (T)this.var_java_lang_Object_a;
    }

    public <T> T b() {
        return (T)this.b;
    }

    public boolean s() {
        return this.b != null || this.var_java_lang_Object_a != null;
    }

    public String java_lang_String_b() {
        StringBuilder stringBuilder = new StringBuilder(40);
        this.a(stringBuilder);
        return stringBuilder.toString();
    }

    public abstract StringBuilder a(StringBuilder var1);

    public abstract StringBuilder b(StringBuilder var1);

    public abstract String toString();

    public abstract boolean equals(Object var1);

    public final int hashCode() {
        return this.var_int_a;
    }

    @Override
    public /* synthetic */ bet bet_a() {
        return this.bfw_d();
    }
}

