/*
 * Decompiled with CFR 0.152.
 */
import java.lang.reflect.Member;
import java.util.HashMap;

public class bix {
    protected static final String[] var_java_lang_String_arr_a;
    protected final bfo var_bfo_a;
    protected final boolean var_boolean_a;
    protected final boolean var_boolean_b;
    protected final bms[] var_bms_arr_a = new bms[11];
    protected int var_int_a = 0;
    protected boolean var_boolean_c = false;
    protected bio[] var_bio_arr_a;
    protected bio[] var_bio_arr_b;
    protected bio[] var_bio_arr_c;

    public bix(bfo bfo2, bhm<?> bhm2) {
        this.var_bfo_a = bfo2;
        this.var_boolean_a = bhm2.c();
        this.var_boolean_b = bhm2.a(bgd.o);
    }

    public bir a(bfs bfs2) {
        bfr bfr2 = bfs2.bfr_a();
        bfw bfw2 = this.a(bfs2, this.var_bms_arr_a[8], this.var_bio_arr_a);
        bfw bfw3 = this.a(bfs2, this.var_bms_arr_a[10], this.var_bio_arr_b);
        bfw bfw4 = this.var_bfo_a.bfw_a();
        blh blh2 = new blh(bfr2, bfw4);
        blh2.a(this.var_bms_arr_a[0], this.var_bms_arr_a[8], bfw2, this.var_bio_arr_a, this.var_bms_arr_a[9], this.var_bio_arr_c);
        blh2.a(this.var_bms_arr_a[10], bfw3, this.var_bio_arr_b);
        blh2.a(this.var_bms_arr_a[1]);
        blh2.b(this.var_bms_arr_a[2]);
        blh2.c(this.var_bms_arr_a[3]);
        blh2.d(this.var_bms_arr_a[4]);
        blh2.e(this.var_bms_arr_a[5]);
        blh2.f(this.var_bms_arr_a[6]);
        blh2.g(this.var_bms_arr_a[7]);
        return blh2;
    }

    public void void_a(bms bms2) {
        this.var_bms_arr_a[0] = this.a((bmn)bms2);
    }

    public void a(bms bms2, boolean bl2) {
        this.a(bms2, 1, bl2);
    }

    public void b(bms bms2, boolean bl2) {
        this.a(bms2, 2, bl2);
    }

    public void c(bms bms2, boolean bl2) {
        this.a(bms2, 3, bl2);
    }

    public void d(bms bms2, boolean bl2) {
        this.a(bms2, 4, bl2);
    }

    public void e(bms bms2, boolean bl2) {
        this.a(bms2, 5, bl2);
    }

    public void f(bms bms2, boolean bl2) {
        this.a(bms2, 6, bl2);
    }

    public void g(bms bms2, boolean bl2) {
        this.a(bms2, 7, bl2);
    }

    public void a(bms bms2, boolean bl2, bio[] bioArray, int n2) {
        if (bms2.bfw_a(n2).n()) {
            if (this.a(bms2, 10, bl2)) {
                this.var_bio_arr_b = bioArray;
            }
        } else if (this.a(bms2, 8, bl2)) {
            this.var_bio_arr_a = bioArray;
        }
    }

    public void a(bms bms2, boolean bl2, bio[] bioArray) {
        if (this.a(bms2, 9, bl2)) {
            if (bioArray.length > 1) {
                HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
                int n2 = bioArray.length;
                for (int i2 = 0; i2 < n2; ++i2) {
                    Integer n3;
                    String string = bioArray[i2].java_lang_String_a();
                    if (string.isEmpty() && bioArray[i2].java_lang_Object_a() != null || (n3 = hashMap.put(string, i2)) == null) continue;
                    throw new IllegalArgumentException(String.format("Duplicate creator property \"%s\" (index %s vs %d) for type %s ", string, n3, i2, buk.java_lang_String_b(this.var_bfo_a.a())));
                }
            }
            this.var_bio_arr_c = bioArray;
        }
    }

    public boolean a() {
        return this.var_bms_arr_a[0] != null;
    }

    public boolean b() {
        return this.var_bms_arr_a[8] != null;
    }

    public boolean c() {
        return this.var_bms_arr_a[9] != null;
    }

    private bfw a(bfs bfs2, bms bms2, bio[] bioArray) {
        if (!this.var_boolean_c || bms2 == null) {
            return null;
        }
        int n2 = 0;
        if (bioArray != null) {
            int n3 = bioArray.length;
            for (int i2 = 0; i2 < n3; ++i2) {
                if (bioArray[i2] != null) continue;
                n2 = i2;
                break;
            }
        }
        bfr bfr2 = bfs2.bfr_a();
        bfw bfw2 = bms2.bfw_a(n2);
        bfn bfn2 = bfr2.bfn_a();
        if (bfn2 != null) {
            bmr bmr2 = bms2.bmr_a(n2);
            Object object = bfn2.g(bmr2);
            if (object != null) {
                bfx<Object> bfx2 = bfs2.a((bmg)bmr2, object);
                bfw2 = bfw2.btp_c(bfx2);
            } else {
                bfw2 = bfn2.b(bfr2, (bmg)bmr2, bfw2);
            }
        }
        return bfw2;
    }

    private <T extends bmn> T a(T t2) {
        if (t2 != null && this.var_boolean_a) {
            buk.a((Member)((Object)t2.java_lang_reflect_AnnotatedElement_a()), this.var_boolean_b);
        }
        return t2;
    }

    protected boolean a(bms bms2, int n2, boolean bl2) {
        int n3 = 1 << n2;
        this.var_boolean_c = true;
        bms bms3 = this.var_bms_arr_a[n2];
        if (bms3 != null) {
            boolean bl3;
            if ((this.var_int_a & n3) != 0) {
                if (!bl2) {
                    return false;
                }
                bl3 = true;
            } else {
                boolean bl4 = bl3 = !bl2;
            }
            if (bl3 && bms3.getClass() == bms2.getClass()) {
                Class<?> clazz;
                Class<?> clazz2 = bms3.a(0);
                if (clazz2 == (clazz = bms2.a(0))) {
                    if (this.boolean_a(bms2)) {
                        return false;
                    }
                    if (!this.boolean_a(bms3)) {
                        this.a(n2, bl2, bms3, bms2);
                    }
                } else {
                    if (clazz.isAssignableFrom(clazz2)) {
                        return false;
                    }
                    if (!clazz2.isAssignableFrom(clazz)) {
                        if (clazz2.isPrimitive() != clazz.isPrimitive()) {
                            if (clazz2.isPrimitive()) {
                                return false;
                            }
                        } else {
                            this.a(n2, bl2, bms3, bms2);
                        }
                    }
                }
            }
        }
        if (bl2) {
            this.var_int_a |= n3;
        }
        this.var_bms_arr_a[n2] = this.a((bmn)bms2);
        return true;
    }

    protected void a(int n2, boolean bl2, bms bms2, bms bms3) {
        throw new IllegalArgumentException(String.format("Conflicting %s creators: already had %s creator %s, encountered another: %s", var_java_lang_String_arr_a[n2], bl2 ? "explicitly marked" : "implicitly discovered", bms2, bms3));
    }

    protected boolean boolean_a(bms bms2) {
        return buk.f(bms2.b()) && "valueOf".equals(bms2.java_lang_Object_a());
    }

    static {
        var_java_lang_String_arr_a = new String[]{"default", "from-String", "from-int", "from-long", "from-big-integer", "from-double", "from-big-decimal", "from-boolean", "delegate", "property-based", "array-delegate"};
    }
}

