/*
 * Decompiled with CFR 0.152.
 */
import java.util.BitSet;

public class bjr {
    protected final bdc var_bdc_a;
    protected final bfs var_bfs_a;
    protected final bjl var_bjl_a;
    protected final Object[] var_java_lang_Object_arr_a;
    protected int var_int_a;
    protected int b;
    protected final BitSet var_java_util_BitSet_a;
    protected bjq var_bjq_a;
    protected Object var_java_lang_Object_a;

    public bjr(bdc bdc2, bfs bfs2, int n2, bjl bjl2) {
        this.var_bdc_a = bdc2;
        this.var_bfs_a = bfs2;
        this.var_int_a = n2;
        this.var_bjl_a = bjl2;
        this.var_java_lang_Object_arr_a = new Object[n2];
        this.var_java_util_BitSet_a = n2 < 32 ? null : new BitSet();
    }

    public Object[] a(bio[] bioArray) {
        int n2;
        if (this.var_int_a > 0) {
            int n3;
            if (this.var_java_util_BitSet_a == null) {
                n2 = this.b;
                n3 = 0;
                int n4 = this.var_java_lang_Object_arr_a.length;
                while (n3 < n4) {
                    if ((n2 & 1) == 0) {
                        this.var_java_lang_Object_arr_a[n3] = this.a(bioArray[n3]);
                    }
                    ++n3;
                    n2 >>= 1;
                }
            } else {
                n2 = this.var_java_lang_Object_arr_a.length;
                n3 = 0;
                while ((n3 = this.var_java_util_BitSet_a.nextClearBit(n3)) < n2) {
                    this.var_java_lang_Object_arr_a[n3] = this.a(bioArray[n3]);
                    ++n3;
                }
            }
        }
        if (this.var_bfs_a.a(bfu.m)) {
            for (n2 = 0; n2 < bioArray.length; ++n2) {
                if (this.var_java_lang_Object_arr_a[n2] != null) continue;
                bio bio2 = bioArray[n2];
                this.var_bfs_a.a(bio2, "Null value for creator property '%s' (index %d); `DeserializationFeature.FAIL_ON_NULL_CREATOR_PROPERTIES` enabled", bio2.java_lang_String_a(), bioArray[n2].int_a());
            }
        }
        return this.var_java_lang_Object_arr_a;
    }

    protected Object a(bio bio2) {
        Object object = bio2.java_lang_Object_a();
        if (object != null) {
            return this.var_bfs_a.a(bio2.java_lang_Object_a(), (bfp)bio2, null);
        }
        if (bio2.f()) {
            this.var_bfs_a.a(bio2, "Missing required creator property '%s' (index %d)", bio2.java_lang_String_a(), bio2.int_a());
        }
        if (this.var_bfs_a.a(bfu.l)) {
            this.var_bfs_a.a(bio2, "Missing creator property '%s' (index %d); `DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES` enabled", bio2.java_lang_String_a(), bio2.int_a());
        }
        try {
            Object object2 = bio2.bil_a().a(this.var_bfs_a);
            if (object2 != null) {
                return object2;
            }
            bil bil2 = bio2.bil_a();
            return ((bfx)bil2).a(this.var_bfs_a);
        }
        catch (bfy bfy2) {
            bmn bmn2 = bio2.bmn_a();
            if (bmn2 != null) {
                bfy2.a(bmn2.b(), bio2.java_lang_String_a());
            }
            throw bfy2;
        }
    }

    public boolean a(String string) {
        if (this.var_bjl_a != null && string.equals(this.var_bjl_a.var_bgj_a.java_lang_String_a())) {
            this.var_java_lang_Object_a = this.var_bjl_a.a(this.var_bdc_a, this.var_bfs_a);
            return true;
        }
        return false;
    }

    public Object a(bfs bfs2, Object object) {
        if (this.var_bjl_a != null) {
            if (this.var_java_lang_Object_a != null) {
                bjs bjs2 = bfs2.a(this.var_java_lang_Object_a, (bck<?>)((Object)this.var_bjl_a.var_bfw_a), this.var_bjl_a.var_bcm_a);
                bjs2.a(object);
                bio bio2 = this.var_bjl_a.var_bio_a;
                if (bio2 != null) {
                    return bio2.java_lang_Object_a(object, this.var_java_lang_Object_a);
                }
            } else {
                bfs2.a(this.var_bjl_a, object);
            }
        }
        return object;
    }

    protected bjq a() {
        return this.var_bjq_a;
    }

    public boolean boolean_a(bio bio2, Object object) {
        int n2 = bio2.int_a();
        this.var_java_lang_Object_arr_a[n2] = object;
        if (this.var_java_util_BitSet_a == null) {
            int n3 = this.b;
            int n4 = n3 | 1 << n2;
            if (n3 != n4) {
                this.b = n4;
                if (--this.var_int_a <= 0) {
                    return this.var_bjl_a == null || this.var_java_lang_Object_a != null;
                }
            }
        } else if (!this.var_java_util_BitSet_a.get(n2)) {
            this.var_java_util_BitSet_a.set(n2);
            if (--this.var_int_a <= 0) {
                // empty if block
            }
        }
        return false;
    }

    public void void_a(bio bio2, Object object) {
        this.var_bjq_a = new bjq.c(this.var_bjq_a, object, bio2);
    }

    public void a(bin bin2, String string, Object object) {
        this.var_bjq_a = new bjq.a(this.var_bjq_a, object, bin2, string);
    }

    public void a(Object object, Object object2) {
        this.var_bjq_a = new bjq.b(this.var_bjq_a, object2, object);
    }
}

