/*
 * Decompiled with CFR 0.152.
 */
public final class bek
extends bde {
    protected final bek var_bek_a;
    protected bei var_bei_a;
    protected bek b;
    protected String var_java_lang_String_a;
    protected Object var_java_lang_Object_a;
    protected int c;
    protected int d;

    public bek(bek bek2, bei bei2, int n2, int n3, int n4) {
        this.var_bek_a = bek2;
        this.var_bei_a = bei2;
        this.var_bek_a = (bek)n2;
        this.c = n3;
        this.d = n4;
        this.b = (bek)-1;
    }

    public void a(int n2, int n3, int n4) {
        this.var_bek_a = (bek)n2;
        this.b = (bek)-1;
        this.c = n3;
        this.d = n4;
        this.var_java_lang_String_a = null;
        this.var_java_lang_Object_a = null;
        if (this.var_bei_a != null) {
            this.var_bei_a.void_a();
        }
    }

    public bek a(bei bei2) {
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

    public static bek b(bei bei2) {
        return new bek(null, bei2, 0, 1, 0);
    }

    public bek a(int n2, int n3) {
        bek bek2 = this.b;
        if (bek2 == null) {
            this.b = bek2 = new bek(this, this.var_bei_a == null ? null : this.var_bei_a.bei_a(), 1, n2, n3);
        } else {
            bek2.a(1, n2, n3);
        }
        return bek2;
    }

    public bek b(int n2, int n3) {
        bek bek2 = this.b;
        if (bek2 == null) {
            this.b = bek2 = new bek(this, this.var_bei_a == null ? null : this.var_bei_a.bei_a(), 2, n2, n3);
            return bek2;
        }
        bek2.a(2, n2, n3);
        return bek2;
    }

    @Override
    public String java_lang_String_b() {
        return this.var_java_lang_String_a;
    }

    @Override
    public bek bek_a() {
        return this.var_bek_a;
    }

    @Override
    public bda bda_a(Object object) {
        long l2 = -1L;
        return new bda(object, l2, this.c, this.d);
    }

    public bek bek_b() {
        this.var_java_lang_Object_a = null;
        return this.var_bek_a;
    }

    @Override
    public bei bei_a() {
        return this.var_bei_a;
    }

    public boolean d() {
        reference var1_1 = ++this.b;
        return this.var_bek_a != false && var1_1 > 0;
    }

    public void a(String string) {
        this.var_java_lang_String_a = string;
        if (this.var_bei_a != null) {
            this.a(this.var_bei_a, string);
        }
    }

    private void a(bei bei2, String string) {
        if (bei2.a(string)) {
            Object object = bei2.java_lang_Object_a();
            throw new bdb(object instanceof bdc ? (bdc)object : null, "Duplicate field '" + string + "'");
        }
    }
}

