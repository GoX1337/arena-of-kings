/*
 * Decompiled with CFR 0.152.
 */
public class bem
extends bde {
    protected final bem var_bem_a;
    protected bei var_bei_a;
    protected bem b;
    protected String var_java_lang_String_a;
    protected Object var_java_lang_Object_a;
    protected boolean var_boolean_a;

    protected bem(int n2, bem bem2, bei bei2) {
        this.var_bem_a = (bem)n2;
        this.var_bem_a = bem2;
        this.var_bei_a = bei2;
        this.b = (bem)-1;
    }

    protected bem(int n2, bem bem2, bei bei2, Object object) {
        this.var_bem_a = (bem)n2;
        this.var_bem_a = bem2;
        this.var_bei_a = bei2;
        this.b = (bem)-1;
        this.var_java_lang_Object_a = object;
    }

    public bem a(int n2) {
        this.var_bem_a = (bem)n2;
        this.b = (bem)-1;
        this.var_java_lang_String_a = null;
        this.var_boolean_a = false;
        this.var_java_lang_Object_a = null;
        if (this.var_bei_a != null) {
            this.var_bei_a.void_a();
        }
        return this;
    }

    public bem a(int n2, Object object) {
        this.var_bem_a = (bem)n2;
        this.b = (bem)-1;
        this.var_java_lang_String_a = null;
        this.var_boolean_a = false;
        this.var_java_lang_Object_a = object;
        if (this.var_bei_a != null) {
            this.var_bei_a.void_a();
        }
        return this;
    }

    public bem a(bei bei2) {
        this.var_bei_a = bei2;
        return this;
    }

    @Override
    public Object java_lang_Object_a() {
        return this.var_java_lang_Object_a;
    }

    @Override
    public void void_a(Object object) {
        this.var_java_lang_Object_a = object;
    }

    public static bem b(bei bei2) {
        return new bem(0, null, bei2);
    }

    @Override
    public bem bem_a() {
        bem bem2 = this.b;
        if (bem2 == null) {
            this.b = bem2 = new bem(1, this, this.var_bei_a == null ? null : this.var_bei_a.bei_a());
            return bem2;
        }
        return bem2.a(1);
    }

    public bem bem_a(Object object) {
        bem bem2 = this.b;
        if (bem2 == null) {
            this.b = bem2 = new bem(1, this, this.var_bei_a == null ? null : this.var_bei_a.bei_a(), object);
            return bem2;
        }
        return bem2.a(1, object);
    }

    public bem bem_b() {
        bem bem2 = this.b;
        if (bem2 == null) {
            this.b = bem2 = new bem(2, this, this.var_bei_a == null ? null : this.var_bei_a.bei_a());
            return bem2;
        }
        return bem2.a(2);
    }

    public bem b(Object object) {
        bem bem2 = this.b;
        if (bem2 == null) {
            this.b = bem2 = new bem(2, this, this.var_bei_a == null ? null : this.var_bei_a.bei_a(), object);
            return bem2;
        }
        return bem2.a(2, object);
    }

    public final bem bem_c() {
        return this.var_bem_a;
    }

    @Override
    public final String java_lang_String_b() {
        return this.var_java_lang_String_a;
    }

    public bem d() {
        this.var_java_lang_Object_a = null;
        return this.var_bem_a;
    }

    @Override
    public bei bei_a() {
        return this.var_bei_a;
    }

    public int a(String string) {
        if (this.var_bem_a != 2 || this.var_boolean_a) {
            return 4;
        }
        this.var_boolean_a = true;
        this.var_java_lang_String_a = string;
        if (this.var_bei_a != null) {
            this.a(this.var_bei_a, string);
        }
        return this.b < 0 ? 0 : 1;
    }

    private final void a(bei bei2, String string) {
        if (bei2.a(string)) {
            Object object = bei2.java_lang_Object_a();
            throw new bcx("Duplicate field '" + string + "'", object instanceof bcy ? (bcy)object : null);
        }
    }

    public int int_c() {
        if (this.var_bem_a == 2) {
            if (!this.var_boolean_a) {
                return 5;
            }
            this.var_boolean_a = false;
            ++this.b;
            return 2;
        }
        if (this.var_bem_a == true) {
            reference var1_1;
            return (var1_1 = this.b++) < 0 ? 0 : 1;
        }
        ++this.b;
        return this.b == false ? 0 : 3;
    }

    @Override
    public /* synthetic */ bde bde_a() {
        return this.bem_c();
    }
}

