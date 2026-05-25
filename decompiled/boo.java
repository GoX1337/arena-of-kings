/*
 * Decompiled with CFR 0.152.
 */
public class boo
extends boi {
    protected final bce.a var_bce$a_a;
    protected final String var_java_lang_String_a;

    public boo(bfw bfw2, boe boe2, String string, boolean bl2, bfw bfw3, bce.a a2) {
        super(bfw2, boe2, string, bl2, bfw3);
        this.var_java_lang_String_a = this.var_bce$a_a == null ? String.format("missing type id property '%s'", this.b) : String.format("missing type id property '%s' (for POJO property '%s')", this.b, this.var_bce$a_a.java_lang_String_a());
        this.var_bce$a_a = a2;
    }

    public boo(boo boo2, bfp bfp2) {
        super(boo2, bfp2);
        this.var_java_lang_String_a = this.var_bce$a_a == null ? String.format("missing type id property '%s'", this.b) : String.format("missing type id property '%s' (for POJO property '%s')", this.b, this.var_bce$a_a.java_lang_String_a());
        this.var_bce$a_a = boo2.var_bce$a_a;
    }

    @Override
    public boc a(bfp bfp2) {
        return bfp2 == this.var_bce$a_a ? this : new boo(this, bfp2);
    }

    @Override
    public bce.a bce$a_a() {
        return this.var_bce$a_a;
    }

    @Override
    public Object java_lang_Object_a(bdc bdc2, bfs bfs2) {
        Object object;
        if (bdc2.boolean_i() && (object = bdc2.java_lang_Object_c()) != null) {
            return this.a(bdc2, bfs2, object);
        }
        object = bdc2.bdf_c();
        if (object == bdf.var_bdf_b) {
            object = bdc2.bdf_a();
        } else if (object != bdf.f) {
            return this.b(bdc2, bfs2, null, this.var_java_lang_String_a);
        }
        bve bve2 = null;
        boolean bl2 = bfs2.a(bgd.v);
        while (object == bdf.f) {
            String string = bdc2.java_lang_String_d();
            bdc2.bdf_a();
            if (string.equals(this.b) || bl2 && string.equalsIgnoreCase(this.b)) {
                return this.a(bdc2, bfs2, bve2, bdc2.java_lang_String_e());
            }
            if (bve2 == null) {
                bve2 = new bve(bdc2, bfs2);
            }
            bve2.a(string);
            bve2.b(bdc2);
            object = bdc2.bdf_a();
        }
        return this.b(bdc2, bfs2, bve2, this.var_java_lang_String_a);
    }

    protected Object a(bdc bdc2, bfs bfs2, bve bve2, String string) {
        bfx<Object> bfx2 = this.a(bfs2, string);
        if (this.var_bce$a_a != false) {
            if (bve2 == null) {
                bve2 = new bve(bdc2, bfs2);
            }
            bve2.a(bdc2.java_lang_String_d());
            bve2.b(string);
        }
        if (bve2 != null) {
            bdc2.void_a();
            bdc2 = bff.a(false, bve2.bdc_a(bdc2), bdc2);
        }
        bdc2.bdf_a();
        return bfx2.a(bdc2, bfs2);
    }

    protected Object b(bdc bdc2, bfs bfs2, bve bve2, String string) {
        Object object;
        Object object2;
        if (!this.boolean_a()) {
            object2 = boc.a(bdc2, bfs2, (bfw)((Object)this.var_bce$a_a));
            if (object2 != null) {
                return object2;
            }
            if (bdc2.boolean_c()) {
                return super.d(bdc2, bfs2);
            }
            if (bdc2.boolean_a(bdf.h) && bfs2.a(bfu.t) && ((String)(object = bdc2.java_lang_String_e().trim())).isEmpty()) {
                return null;
            }
        }
        if ((object2 = this.a(bfs2)) == null) {
            object = this.b(bfs2, string);
            if (object == null) {
                return null;
            }
            object2 = bfs2.a((bfw)object, (bfp)((Object)this.var_bce$a_a));
        }
        if (bve2 != null) {
            bve2.void_d();
            bdc2 = bve2.bdc_a(bdc2);
            bdc2.bdf_a();
        }
        return ((bfx)object2).a(bdc2, bfs2);
    }

    @Override
    public Object d(bdc bdc2, bfs bfs2) {
        if (bdc2.boolean_a(bdf.var_bdf_d)) {
            return super.b(bdc2, bfs2);
        }
        return this.java_lang_Object_a(bdc2, bfs2);
    }
}

