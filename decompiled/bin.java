/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;
import java.util.Map;

public class bin
implements Serializable {
    protected final bfp var_bfp_a;
    protected final bmn var_bmn_a;
    final boolean var_boolean_a;
    protected final bfw var_bfw_a;
    protected bfx<Object> var_bfx_java_lang_Object__a;
    protected final boc var_boc_a;
    protected final bgc var_bgc_a;

    public bin(bfp bfp2, bmn bmn2, bfw bfw2, bgc bgc2, bfx<Object> bfx2, boc boc2) {
        this.var_bfp_a = bfp2;
        this.var_bmn_a = bmn2;
        this.var_bfw_a = bfw2;
        this.var_bfp_a = bfx2;
        this.var_boc_a = boc2;
        this.var_bgc_a = bgc2;
        this.var_boolean_a = bmn2 instanceof bml;
    }

    public bin a(bfx<Object> bfx2) {
        return new bin(this.var_bfp_a, this.var_bmn_a, this.var_bfw_a, this.var_bgc_a, bfx2, this.var_boc_a);
    }

    public void a(bfr bfr2) {
        this.var_bmn_a.a(bfr2.a(bgd.o));
    }

    public bfp bfp_a() {
        return this.var_bfp_a;
    }

    public boolean boolean_a() {
        return this.var_bfp_a != null;
    }

    public bfw bfw_a() {
        return this.var_bfw_a;
    }

    public final void a(bdc bdc2, bfs bfs2, Object object, String string) {
        try {
            String string2 = this.var_bgc_a == null ? string : this.var_bgc_a.a(string, bfs2);
            this.a(object, (Object)string2, this.a(bdc2, bfs2));
        }
        catch (bip bip2) {
            if (((bfx)((Object)this.var_bfp_a)).bjl_a() == null) {
                throw bfy.a(bdc2, "Unresolved forward reference but no identity info.", (Throwable)bip2);
            }
            a a2 = new a(this, bip2, (Class<?>)this.var_bfw_a.a(), object, string);
            bip2.bjs_a().a(a2);
        }
    }

    public Object a(bdc bdc2, bfs bfs2) {
        if (bdc2.boolean_a(bdf.m)) {
            return ((bfx)((Object)this.var_bfp_a)).a(bfs2);
        }
        if (this.var_boc_a != null) {
            return ((bfx)((Object)this.var_bfp_a)).a(bdc2, bfs2, this.var_boc_a);
        }
        return ((bfx)((Object)this.var_bfp_a)).a(bdc2, bfs2);
    }

    public void a(Object object, Object object2, Object object3) {
        try {
            if (this.var_boolean_a) {
                bml bml2 = (bml)this.var_bmn_a;
                Map map = (Map)bml2.b(object);
                if (map != null) {
                    map.put(object2, object3);
                }
            } else {
                ((bmo)this.var_bmn_a).a(object, object2, object3);
            }
        }
        catch (Exception exception) {
            this.a(exception, object2, object3);
        }
    }

    protected void a(Exception exception, Object object, Object object2) {
        if (exception instanceof IllegalArgumentException) {
            String string = buk.c(object2);
            StringBuilder stringBuilder = new StringBuilder("Problem deserializing \"any\" property '").append(object);
            stringBuilder.append("' of class " + this.java_lang_String_a() + " (expected type: ").append(this.var_bfw_a);
            stringBuilder.append("; actual type: ").append(string).append(")");
            String string2 = buk.java_lang_String_a(exception);
            if (string2 != null) {
                stringBuilder.append(", problem: ").append(string2);
            } else {
                stringBuilder.append(" (no error message provided)");
            }
            throw new bfy(null, stringBuilder.toString(), (Throwable)exception);
        }
        buk.c(exception);
        buk.java_lang_Throwable_b(exception);
        Throwable throwable = buk.d(exception);
        throw new bfy(null, buk.java_lang_String_a(throwable), throwable);
    }

    private String java_lang_String_a() {
        return this.var_bmn_a.b().getName();
    }

    public String toString() {
        return "[any property on class " + this.java_lang_String_a() + "]";
    }

    static class a
    extends bjs.a {
        private final bin var_bin_a;
        private final Object var_java_lang_Object_a;
        private final String var_java_lang_String_a;

        public a(bin bin2, bip bip2, Class<?> clazz, Object object, String string) {
            super(bip2, clazz);
            this.var_bin_a = bin2;
            this.var_java_lang_Object_a = object;
            this.var_java_lang_String_a = string;
        }

        @Override
        public void a(Object object, Object object2) {
            if (!this.boolean_a(object)) {
                throw new IllegalArgumentException("Trying to resolve a forward reference with id [" + object.toString() + "] that wasn't previously registered.");
            }
            this.var_bin_a.a(this.var_java_lang_Object_a, (Object)this.var_java_lang_String_a, object2);
        }
    }
}

