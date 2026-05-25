/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class boz
extends boc
implements Serializable {
    protected final boe var_boe_a;
    protected final bfw var_bfw_a;
    protected final bfp var_bfp_a;
    protected final bfw var_bfw_b;
    protected final String var_java_lang_String_b;
    protected final boolean var_boolean_a;
    protected final Map<String, bfx<Object>> cfr_renamed_35;
    protected bfx<Object> var_bfx_java_lang_Object__a;

    protected boz(bfw bfw2, boe boe2, String string, boolean bl2, bfw bfw3) {
        this.var_bfw_a = bfw2;
        this.var_boe_a = boe2;
        this.var_java_lang_String_b = buk.a(string);
        this.var_boolean_a = bl2;
        this.var_boe_a = new ConcurrentHashMap(16, 0.75f, 2);
        this.var_bfw_b = bfw3;
        this.var_bfp_a = null;
    }

    protected boz(boz boz2, bfp bfp2) {
        this.var_bfw_a = boz2.var_bfw_a;
        this.var_boe_a = boz2.var_boe_a;
        this.var_java_lang_String_b = boz2.var_java_lang_String_b;
        this.var_boolean_a = boz2.var_boolean_a;
        this.var_boe_a = boz2.var_boe_a;
        this.var_bfw_b = boz2.var_bfw_b;
        this.var_boe_a = boz2.var_boe_a;
        this.var_bfp_a = bfp2;
    }

    public String java_lang_String_b() {
        return ((Class)this.var_bfw_a.a()).getName();
    }

    @Override
    public final String java_lang_String_a() {
        return this.var_java_lang_String_b;
    }

    @Override
    public boe boe_a() {
        return this.var_boe_a;
    }

    @Override
    public Class<?> a() {
        return buk.a(this.var_bfw_b);
    }

    @Override
    public boolean boolean_a() {
        return this.var_bfw_b != null;
    }

    public bfw bfw_a() {
        return this.var_bfw_a;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[').append(this.getClass().getName());
        stringBuilder.append("; base-type:").append(this.var_bfw_a);
        stringBuilder.append("; id-resolver: ").append(this.var_boe_a);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    protected final bfx<Object> a(bfs bfs2, String string) {
        bfx<Object> bfx2 = (bfx<Object>)this.var_boe_a.get(string);
        if (bfx2 == null) {
            bfw bfw2 = this.var_boe_a.a(bfs2, string);
            if (bfw2 == null) {
                bfx2 = this.a(bfs2);
                if (bfx2 == null) {
                    bfw bfw3 = this.a(bfs2, string);
                    if (bfw3 == null) {
                        return bku.a;
                    }
                    bfx2 = bfs2.a(bfw3, this.var_bfp_a);
                }
            } else {
                if (this.var_bfw_a != null && this.var_bfw_a.getClass() == bfw2.getClass() && !bfw2.r()) {
                    try {
                        bfw2 = bfs2.a(this.var_bfw_a, (Class<?>)bfw2.a());
                    }
                    catch (IllegalArgumentException illegalArgumentException) {
                        throw bfs2.a(this.var_bfw_a, string, illegalArgumentException.getMessage());
                    }
                }
                bfx2 = bfs2.a(bfw2, this.var_bfp_a);
            }
            this.var_boe_a.put(string, bfx2);
        }
        return bfx2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected final bfx<Object> a(bfs bfs2) {
        if (this.var_bfw_b == null) {
            if (!bfs2.a(bfu.h)) {
                return bku.a;
            }
            return null;
        }
        Object t2 = this.var_bfw_b.a();
        if (buk.c(t2)) {
            return bku.a;
        }
        bfw bfw2 = this.var_bfw_b;
        synchronized (bfw2) {
            if (this.var_boe_a == null) {
                this.var_boe_a = bfs2.a(this.var_bfw_b, this.var_bfp_a);
            }
            return this.var_boe_a;
        }
    }

    protected Object a(bdc bdc2, bfs bfs2, Object object) {
        bfx<Object> bfx2;
        if (object == null) {
            bfx2 = this.a(bfs2);
            if (bfx2 == null) {
                return bfs2.a(this.bfw_a(), "No (native) type id found when one was expected for polymorphic type handling", new Object[0]);
            }
        } else {
            String string = object instanceof String ? (String)object : String.valueOf(object);
            bfx2 = this.a(bfs2, string);
        }
        return bfx2.a(bdc2, bfs2);
    }

    protected bfw a(bfs bfs2, String string) {
        String string2 = this.var_boe_a.b();
        string2 = string2 == null ? "type ids are not statically known" : "known type ids = " + string2;
        if (this.var_bfp_a != null) {
            string2 = String.format("%s (for POJO property '%s')", string2, this.var_bfp_a.java_lang_String_a());
        }
        return bfs2.a(this.var_bfw_a, string, this.var_boe_a, string2);
    }

    protected bfw b(bfs bfs2, String string) {
        return bfs2.a(this.var_bfw_a, this.var_boe_a, string);
    }
}

