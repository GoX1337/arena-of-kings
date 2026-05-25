/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;
import java.util.Map;

public class bhq
extends bfx<Object>
implements bib,
Serializable {
    protected final bfw var_bfw_a;
    protected final bjl var_bjl_a;
    protected final Map<String, bio> cfr_renamed_15;
    protected transient Map<String, bio> cfr_renamed_16;
    protected final boolean var_boolean_a;
    protected final boolean var_boolean_b;
    protected final boolean c;
    protected final boolean d;

    public bhq(bhw bhw2, bfo bfo2, Map<String, bio> map, Map<String, bio> map2) {
        this.var_bfw_a = bfo2.bfw_a();
        this.var_bjl_a = bhw2.bjl_a();
        this.var_bfw_a = map;
        this.cfr_renamed_16 = map2;
        Object t2 = this.var_bfw_a.a();
        this.var_boolean_a = ((Class)t2).isAssignableFrom(String.class);
        this.var_boolean_b = t2 == Boolean.TYPE || ((Class)t2).isAssignableFrom(Boolean.class);
        this.c = t2 == Integer.TYPE || ((Class)t2).isAssignableFrom(Integer.class);
        this.d = t2 == Double.TYPE || ((Class)t2).isAssignableFrom(Double.class);
    }

    protected bhq(bfo bfo2) {
        this.var_bfw_a = bfo2.bfw_a();
        this.var_bjl_a = null;
        this.var_bfw_a = null;
        Object t2 = this.var_bfw_a.a();
        this.var_boolean_a = ((Class)t2).isAssignableFrom(String.class);
        this.var_boolean_b = t2 == Boolean.TYPE || ((Class)t2).isAssignableFrom(Boolean.class);
        this.c = t2 == Integer.TYPE || ((Class)t2).isAssignableFrom(Integer.class);
        this.d = t2 == Double.TYPE || ((Class)t2).isAssignableFrom(Double.class);
    }

    protected bhq(bhq bhq2, bjl bjl2, Map<String, bio> map) {
        this.var_bfw_a = bhq2.var_bfw_a;
        this.var_bfw_a = bhq2.var_bfw_a;
        this.var_boolean_a = bhq2.var_boolean_a;
        this.var_boolean_b = bhq2.var_boolean_b;
        this.c = bhq2.c;
        this.d = bhq2.d;
        this.var_bjl_a = bjl2;
        this.cfr_renamed_16 = map;
    }

    public static bhq a(bfo bfo2) {
        return new bhq(bfo2);
    }

    @Override
    public bfx<?> a(bfs bfs2, bfp bfp2) {
        bni bni2;
        bmn bmn2;
        bfn bfn2 = bfs2.bfn_a();
        if (bfp2 != null && bfn2 != null && (bmn2 = bfp2.bmn_a()) != null && (bni2 = bfn2.bni_a((bmg)bmn2)) != null) {
            bck bck2;
            bfw bfw2;
            Object object;
            bio bio2 = null;
            bcm bcm2 = bfs2.a((bmg)bmn2, bni2);
            Class<? extends bck<?>> clazz = (bni2 = bfn2.a((bmg)bmn2, bni2)).b();
            if (clazz == bcl.c.class) {
                object = bni2.bgj_a();
                bio bio3 = bio2 = this.cfr_renamed_16 == null ? null : this.cfr_renamed_16.get(((bgj)object).java_lang_String_a());
                if (bio2 == null) {
                    bfs2.b(this.var_bfw_a, String.format("Invalid Object Id definition for %s: cannot find property with name %s", buk.java_lang_String_b(this.a()), buk.a((bgj)object)));
                }
                bfw2 = bio2.bfw_a();
                bck2 = new bjp(bni2.a());
            } else {
                bcm2 = bfs2.a((bmg)bmn2, bni2);
                object = bfs2.bfw_a(clazz);
                bfw2 = bfs2.btz_a().bfw_arr_a((bfw)object, bck.class)[0];
                bck2 = bfs2.a((bmg)bmn2, bni2);
            }
            object = bfs2.b(bfw2);
            bjl bjl2 = bjl.a(bfw2, bni2.bgj_a(), bck2, object, bio2, bcm2);
            return new bhq(this, bjl2, null);
        }
        if (this.cfr_renamed_16 == null) {
            return this;
        }
        return new bhq(this, this.var_bjl_a, null);
    }

    @Override
    public Class<?> a() {
        return this.var_bfw_a.a();
    }

    @Override
    public boolean boolean_a() {
        return true;
    }

    @Override
    public btq btq_a() {
        return btq.d;
    }

    @Override
    public Boolean a(bfr bfr2) {
        return null;
    }

    @Override
    public bjl bjl_a() {
        return this.var_bjl_a;
    }

    @Override
    public bio a(String string) {
        return this.var_bfw_a == null ? null : (bio)this.var_bfw_a.get(string);
    }

    @Override
    public Object a(bdc bdc2, bfs bfs2, boc boc2) {
        Object object;
        if (this.var_bjl_a != null && (object = bdc2.bdf_c()) != null) {
            if (object.d()) {
                return this.c(bdc2, bfs2);
            }
            if (object == bdf.var_bdf_b) {
                object = bdc2.bdf_a();
            }
            if (object == bdf.f && this.var_bjl_a.boolean_a() && this.var_bjl_a.a(bdc2.java_lang_String_d(), bdc2)) {
                return this.c(bdc2, bfs2);
            }
        }
        if ((object = this.b(bdc2, bfs2)) != null) {
            return object;
        }
        return boc2.java_lang_Object_a(bdc2, bfs2);
    }

    @Override
    public Object a(bdc bdc2, bfs bfs2) {
        bir.a a2 = new bir.a(this.var_bfw_a);
        return bfs2.a((Class<?>)this.var_bfw_a.a(), a2, bdc2, "abstract types either need to be mapped to concrete types, have custom deserializer, or contain additional type information", new Object[0]);
    }

    protected Object b(bdc bdc2, bfs bfs2) {
        switch (bdc2.int_a()) {
            case 6: {
                if (!this.var_boolean_a) break;
                return bdc2.java_lang_String_e();
            }
            case 7: {
                if (!this.c) break;
                return bdc2.int_e();
            }
            case 8: {
                if (!this.d) break;
                return bdc2.double_a();
            }
            case 9: {
                if (!this.var_boolean_b) break;
                return Boolean.TRUE;
            }
            case 10: {
                if (!this.var_boolean_b) break;
                return Boolean.FALSE;
            }
        }
        return null;
    }

    protected Object c(bdc bdc2, bfs bfs2) {
        Object object = this.var_bjl_a.a(bdc2, bfs2);
        bjs bjs2 = bfs2.a(object, (bck<?>)((Object)this.var_bjl_a.var_bfw_a), this.var_bjl_a.var_bcm_a);
        Object object2 = bjs2.java_lang_Object_a();
        if (object2 == null) {
            throw new bip(bdc2, "Could not resolve Object Id [" + object + "] -- unresolved forward-reference?", bdc2.bda_b(), bjs2);
        }
        return object2;
    }
}

