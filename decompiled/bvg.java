/*
 * Decompiled with CFR 0.152.
 */
public class bvg
extends bde {
    protected final bde var_bde_a;
    protected final bda var_bda_a;
    protected String var_java_lang_String_a;
    protected Object var_java_lang_Object_a;

    protected bvg(bde bde2, bda bda2) {
        super(bde2);
        this.var_bde_a = bde2.bde_a();
        this.var_java_lang_String_a = bde2.java_lang_String_b();
        this.var_java_lang_Object_a = bde2.java_lang_Object_a();
        this.var_bda_a = bda2;
    }

    protected bvg() {
        super(0, -1);
        this.var_bde_a = null;
        this.var_bda_a = bda.var_bda_a;
    }

    protected bvg(bvg bvg2, int n2, int n3) {
        super(n2, n3);
        this.var_bde_a = bvg2;
        this.var_bda_a = bvg2.var_bda_a;
    }

    @Override
    public Object java_lang_Object_a() {
        return this.var_java_lang_Object_a;
    }

    @Override
    public void void_a(Object object) {
        this.var_java_lang_Object_a = object;
    }

    public static bvg a(bde bde2) {
        if (bde2 == null) {
            return new bvg();
        }
        return new bvg(bde2, null);
    }

    @Override
    public bvg bvg_a() {
        ++this.b;
        return new bvg(this, 1, -1);
    }

    public bvg bvg_b() {
        ++this.b;
        return new bvg(this, 2, -1);
    }

    public bvg bvg_c() {
        if (this.var_bde_a instanceof bvg) {
            return (bvg)this.var_bde_a;
        }
        if (this.var_bde_a == null) {
            return new bvg();
        }
        return new bvg(this.var_bde_a, this.var_bda_a);
    }

    @Override
    public String java_lang_String_b() {
        return this.var_java_lang_String_a;
    }

    @Override
    public bde bde_a() {
        return this.var_bde_a;
    }

    public void a(String string) {
        this.var_java_lang_String_a = string;
    }

    public void void_a() {
        ++this.b;
    }
}

