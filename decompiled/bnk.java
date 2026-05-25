/*
 * Decompiled with CFR 0.152.
 */
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public class bnk
extends bmx
implements Comparable<bnk> {
    private static final bfn.a var_bfn$a_b;
    protected final boolean var_boolean_a;
    protected final bhm<?> var_bhm____a;
    protected final bfn var_bfn_a;
    protected final bgj var_bgj_a;
    protected final bgj var_bgj_b;
    protected a<bml> var_bnk$a_bml__a;
    protected a<bmr> var_bnk$a_bmr__b;
    protected a<bmo> c;
    protected a<bmo> d;
    protected transient bgi var_bgi_a;
    protected transient bfn.a var_bfn$a_a;

    public bnk(bhm<?> bhm2, bfn bfn2, boolean bl2, bgj bgj2) {
        this(bhm2, bfn2, bl2, bgj2, bgj2);
    }

    protected bnk(bhm<?> bhm2, bfn bfn2, boolean bl2, bgj bgj2, bgj bgj3) {
        this.var_boolean_a = bhm2;
        this.var_bfn_a = bfn2;
        this.var_bgj_b = bgj2;
        this.var_bgj_a = bgj3;
        this.var_boolean_a = bl2;
    }

    protected bnk(bnk bnk2, bgj bgj2) {
        this.var_boolean_a = bnk2.var_boolean_a;
        this.var_bfn_a = bnk2.var_bfn_a;
        this.var_bgj_b = bnk2.var_bgj_b;
        this.var_bgj_a = bgj2;
        this.var_boolean_a = bnk2.var_boolean_a;
        this.var_bfn$a_b = bnk2.var_bfn$a_b;
        this.c = bnk2.c;
        this.d = bnk2.d;
        this.var_boolean_a = bnk2.var_boolean_a;
    }

    public bnk bnk_a(bgj bgj2) {
        return new bnk(this, bgj2);
    }

    public bnk a(String string) {
        bgj bgj2 = this.var_bgj_a.b(string);
        return bgj2 == this.var_bgj_a ? this : new bnk(this, bgj2);
    }

    public int int_a(bnk bnk2) {
        if (this.var_bfn$a_b != null) {
            if (bnk2.var_bfn$a_b == null) {
                return -1;
            }
        } else if (bnk2.var_bfn$a_b != null) {
            return 1;
        }
        return this.java_lang_String_a().compareTo(bnk2.java_lang_String_a());
    }

    @Override
    public String java_lang_String_a() {
        return this.var_bgj_a == null ? null : this.var_bgj_a.java_lang_String_a();
    }

    @Override
    public bgj bgj_a() {
        return this.var_bgj_a;
    }

    @Override
    public boolean boolean_a(bgj bgj2) {
        return this.var_bgj_a.equals(bgj2);
    }

    public String java_lang_String_c() {
        return this.var_bgj_b.java_lang_String_a();
    }

    @Override
    public bgj bgj_b() {
        bmn bmn2 = this.bmn_d();
        return bmn2 == null || this.var_bfn_a == null ? null : this.var_bfn_a.java_lang_Object_a((bmg)bmn2);
    }

    @Override
    public boolean boolean_a() {
        return this.boolean_a((a)this.var_boolean_a) || this.boolean_a(this.c) || this.boolean_a(this.d) || this.b((a)((Object)this.var_bfn$a_b));
    }

    @Override
    public boolean boolean_b() {
        return this.b((a)this.var_boolean_a) || this.b(this.c) || this.b(this.d) || this.b((a)((Object)this.var_bfn$a_b));
    }

    @Override
    public bgi bgi_a() {
        if (this.var_bgi_a == null) {
            bmn bmn2 = this.bmn_e();
            if (bmn2 == null) {
                this.var_bgi_a = bgi.c;
            } else {
                Boolean bl2 = this.var_bfn_a.java_lang_Boolean_b(bmn2);
                String string = this.var_bfn_a.java_lang_String_b((bmg)bmn2);
                Object object = this.var_bfn_a.java_lang_Object_a((bmg)bmn2);
                Object object2 = this.var_bfn_a.java_lang_Object_a((bmg)bmn2);
                this.var_bgi_a = bl2 == null && object == null && object2 == null ? (string == null ? bgi.c : bgi.c.a(string)) : bgi.a(bl2, string, (Integer)object, (String)object2);
                if (!this.var_boolean_a) {
                    this.var_bgi_a = this.a(this.var_bgi_a, bmn2);
                }
            }
        }
        return this.var_bgi_a;
    }

    protected bgi a(bgi bgi2, bmn bmn2) {
        Object object;
        Class<?> clazz;
        boolean bl2 = true;
        bcj bcj2 = null;
        bcj bcj3 = null;
        bmn bmn3 = this.bmn_a();
        if (bmn2 != null) {
            if (this.var_bfn_a != null) {
                if (bmn3 != null && (clazz = this.var_bfn_a.java_lang_Object_e(bmn2)) != null) {
                    bl2 = false;
                    if (((Boolean)((Object)clazz)).booleanValue()) {
                        bgi2 = bgi2.a(bgi.a.c(bmn3));
                    }
                }
                if ((clazz = this.var_bfn_a.java_lang_Object_a((bmg)bmn2)) != null) {
                    bcj2 = ((bcb.a)((Object)clazz)).bcj_a();
                    bcj3 = ((bcb.a)((Object)clazz)).b();
                }
            }
            if (bl2 || bcj2 == null || bcj3 == null) {
                Boolean bl3;
                clazz = this.a(bmn2);
                object = this.var_boolean_a.bhg_a(clazz);
                bcb.a a2 = ((bhg)object).bcb$a_a();
                if (a2 != null) {
                    if (bcj2 == null) {
                        bcj2 = a2.bcj_a();
                    }
                    if (bcj3 == null) {
                        bcj3 = a2.b();
                    }
                }
                if (bl2 && bmn3 != null && (bl3 = ((bhg)object).java_lang_Boolean_b()) != null) {
                    bl2 = false;
                    if (bl3.booleanValue()) {
                        bgi2 = bgi2.a(bgi.a.b(bmn3));
                    }
                }
            }
        }
        if (bl2 || bcj2 == null || bcj3 == null) {
            clazz = this.var_boolean_a.bcb$a_a();
            if (bcj2 == null) {
                bcj2 = ((bcb.a)((Object)clazz)).bcj_a();
            }
            if (bcj3 == null) {
                bcj3 = ((bcb.a)((Object)clazz)).b();
            }
            if (bl2 && Boolean.TRUE.equals(object = this.var_boolean_a.java_lang_Boolean_a()) && bmn3 != null) {
                bgi2 = bgi2.a(bgi.a.a(bmn3));
            }
        }
        if (bcj2 != null || bcj3 != null) {
            bgi2 = bgi2.a(bcj2, bcj3);
        }
        return bgi2;
    }

    @Override
    public bfw bfw_a() {
        if (this.var_boolean_a) {
            bmn bmn2 = this.bmo_a();
            if (bmn2 == null && (bmn2 = this.bml_a()) == null) {
                return btz.bfw_a();
            }
            return ((bmg)bmn2).bfw_a();
        }
        bmn bmn3 = this.bmr_a();
        if (bmn3 == null) {
            bmn3 = this.bmo_b();
            if (bmn3 != null) {
                return ((bmo)bmn3).bfw_a(0);
            }
            bmn3 = this.bml_a();
        }
        if (bmn3 == null && (bmn3 = this.bmo_a()) == null) {
            return btz.bfw_a();
        }
        return bmn3.bfw_a();
    }

    @Override
    public Class<?> a() {
        return this.bfw_a().a();
    }

    public boolean i() {
        return this.c != null;
    }

    @Override
    public boolean boolean_e() {
        return this.d != null;
    }

    @Override
    public boolean f() {
        return this.var_boolean_a != null;
    }

    @Override
    public boolean g() {
        return this.var_bfn$a_b != null;
    }

    @Override
    public boolean boolean_c() {
        return this.var_bfn$a_b != null || this.d != null || this.var_boolean_a != null;
    }

    @Override
    public boolean boolean_d() {
        return this.c != null || this.var_boolean_a != null;
    }

    @Override
    public bmo bmo_a() {
        a<bmo> a2 = this.c;
        if (a2 == null) {
            return null;
        }
        Object t2 = a2.var_T_a;
        if (t2 == null) {
            return (bmo)a2.var_T_a;
        }
        while (t2 != null) {
            block11: {
                int n2;
                int n3;
                block9: {
                    Class<?> clazz;
                    Class<?> clazz2;
                    block10: {
                        clazz2 = ((bmo)a2.var_T_a).b();
                        if (clazz2 == (clazz = ((bmo)((a)t2).var_T_a).b())) break block9;
                        if (!clazz2.isAssignableFrom(clazz)) break block10;
                        a2 = t2;
                        break block11;
                    }
                    if (clazz.isAssignableFrom(clazz2)) break block11;
                }
                if ((n3 = this.a((bmo)((a)t2).var_T_a)) != (n2 = this.a((bmo)a2.var_T_a))) {
                    if (n3 < n2) {
                        a2 = t2;
                    }
                } else {
                    throw new IllegalArgumentException("Conflicting getter definitions for property \"" + this.java_lang_String_a() + "\": " + ((bmo)a2.var_T_a).java_lang_String_b() + " vs " + ((bmo)((a)t2).var_T_a).java_lang_String_b());
                }
            }
            t2 = ((a)t2).var_T_a;
        }
        this.c = a2.a();
        return (bmo)a2.var_T_a;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public bmo bmo_b() {
        a<bmo> a2 = this.d;
        if (a2 == null) {
            return null;
        }
        Object t2 = a2.var_T_a;
        if (t2 == null) {
            return (bmo)a2.var_T_a;
        }
        while (t2 != null) {
            block12: {
                int n2;
                block10: {
                    Class<?> clazz;
                    Class<?> clazz2;
                    block11: {
                        clazz2 = ((bmo)a2.var_T_a).b();
                        if (clazz2 == (clazz = ((bmo)((a)t2).var_T_a).b())) break block10;
                        if (!clazz2.isAssignableFrom(clazz)) break block11;
                        a2 = t2;
                        break block12;
                    }
                    if (clazz.isAssignableFrom(clazz2)) break block12;
                }
                bmo bmo2 = (bmo)((a)t2).var_T_a;
                bmo bmo3 = (bmo)a2.var_T_a;
                int n3 = this.b(bmo2);
                if (n3 != (n2 = this.b(bmo3))) {
                    if (n3 < n2) {
                        a2 = t2;
                    }
                } else {
                    if (this.var_bfn_a == null) throw new IllegalArgumentException(String.format("Conflicting setter definitions for property \"%s\": %s vs %s", this.java_lang_String_a(), ((bmo)a2.var_T_a).java_lang_String_b(), ((bmo)((a)t2).var_T_a).java_lang_String_b()));
                    bmo bmo4 = this.var_bfn_a.a((bhm<?>)this.var_boolean_a, bmo3, bmo2);
                    if (bmo4 != bmo3) {
                        if (bmo4 != bmo2) throw new IllegalArgumentException(String.format("Conflicting setter definitions for property \"%s\": %s vs %s", this.java_lang_String_a(), ((bmo)a2.var_T_a).java_lang_String_b(), ((bmo)((a)t2).var_T_a).java_lang_String_b()));
                        a2 = t2;
                    }
                }
            }
            t2 = ((a)t2).var_T_a;
        }
        this.d = a2.a();
        return (bmo)a2.var_T_a;
    }

    @Override
    public bml bml_a() {
        if (this.var_boolean_a == null) {
            return null;
        }
        bml bml2 = (bml)this.var_boolean_a.var_T_a;
        Object t2 = this.var_boolean_a.var_T_a;
        while (t2 != null) {
            block7: {
                bml bml3;
                block5: {
                    Class<?> clazz;
                    Class<?> clazz2;
                    block6: {
                        bml3 = (bml)((a)t2).var_T_a;
                        clazz2 = bml2.b();
                        if (clazz2 == (clazz = bml3.b())) break block5;
                        if (!clazz2.isAssignableFrom(clazz)) break block6;
                        bml2 = bml3;
                        break block7;
                    }
                    if (clazz.isAssignableFrom(clazz2)) break block7;
                }
                throw new IllegalArgumentException("Multiple fields representing property \"" + this.java_lang_String_a() + "\": " + bml2.java_lang_String_b() + " vs " + bml3.java_lang_String_b());
            }
            t2 = ((a)t2).var_T_a;
        }
        return bml2;
    }

    @Override
    public bmr bmr_a() {
        if (this.var_bfn$a_b == null) {
            return null;
        }
        bfn.a a2 = this.var_bfn$a_b;
        do {
            if (!(((bmr)((a)((Object)a2)).var_T_a).bms_a() instanceof bmj)) continue;
            return (bmr)((a)((Object)a2)).var_T_a;
        } while ((a2 = ((a)((Object)a2)).var_T_a) != null);
        return (bmr)((a)((Object)this.var_bfn$a_b)).var_T_a;
    }

    @Override
    public Iterator<bmr> a() {
        if (this.var_bfn$a_b == null) {
            return buk.a();
        }
        return new b<bmr>((a<bmr>)((Object)this.var_bfn$a_b));
    }

    @Override
    public bmn bmn_d() {
        if (this.var_boolean_a) {
            return this.bmn_a();
        }
        bmn bmn2 = this.bmn_b();
        if (bmn2 == null) {
            bmn2 = this.bmn_a();
        }
        return bmn2;
    }

    protected bmn bmn_e() {
        if (this.var_boolean_a) {
            if (this.c != null) {
                return (bmn)this.c.var_T_a;
            }
            if (this.var_boolean_a != null) {
                return (bmn)this.var_boolean_a.var_T_a;
            }
            return null;
        }
        if (this.var_bfn$a_b != null) {
            return (bmn)((a)((Object)this.var_bfn$a_b)).var_T_a;
        }
        if (this.d != null) {
            return (bmn)this.d.var_T_a;
        }
        if (this.var_boolean_a != null) {
            return (bmn)this.var_boolean_a.var_T_a;
        }
        if (this.c != null) {
            return (bmn)this.c.var_T_a;
        }
        return null;
    }

    protected int a(bmo bmo2) {
        String string = bmo2.java_lang_String_a();
        if (string.startsWith("get") && string.length() > 3) {
            return 1;
        }
        if (string.startsWith("is") && string.length() > 2) {
            return 2;
        }
        return 3;
    }

    protected int b(bmo bmo2) {
        String string = bmo2.java_lang_String_a();
        if (string.startsWith("set") && string.length() > 3) {
            return 1;
        }
        return 2;
    }

    @Override
    public Class<?>[] java_lang_Class____arr_a() {
        return this.a(new bnl(this));
    }

    @Override
    public bfn.a bfn$a_a() {
        bfn.a a2 = this.var_bfn$a_a;
        if (a2 != null) {
            if (a2 == var_bfn$a_b) {
                return null;
            }
            return a2;
        }
        a2 = this.a(new bnm(this));
        this.var_bfn$a_a = a2 == null ? var_bfn$a_b : a2;
        return a2;
    }

    @Override
    public boolean h() {
        Boolean bl2 = this.a(new bnn(this));
        return bl2 != null && bl2 != false;
    }

    @Override
    public bni bni_a() {
        return this.a(new bno(this));
    }

    @Override
    public bbr.b bbr$b_a() {
        bmn bmn2 = this.bmn_a();
        Object object = this.var_bfn_a == null ? null : this.var_bfn_a.java_lang_Object_a((bmg)bmn2);
        return object == null ? bbr.b.bbr$b_a() : object;
    }

    public bbw.a bbw$a_a() {
        return this.a(new bnp(this), bbw.a.var_bbw$a_a);
    }

    public void a(bml bml2, bgj bgj2, boolean bl2, boolean bl3, boolean bl4) {
        this.var_boolean_a = new a<bml>(bml2, (a<bml>)this.var_boolean_a, bgj2, bl2, bl3, bl4);
    }

    public void a(bmr bmr2, bgj bgj2, boolean bl2, boolean bl3, boolean bl4) {
        this.var_bfn$a_b = new a<bmr>(bmr2, (a<bmr>)((Object)this.var_bfn$a_b), bgj2, bl2, bl3, bl4);
    }

    public void a(bmo bmo2, bgj bgj2, boolean bl2, boolean bl3, boolean bl4) {
        this.c = new a<bmo>(bmo2, this.c, bgj2, bl2, bl3, bl4);
    }

    public void b(bmo bmo2, bgj bgj2, boolean bl2, boolean bl3, boolean bl4) {
        this.d = new a<bmo>(bmo2, this.d, bgj2, bl2, bl3, bl4);
    }

    public void void_a(bnk bnk2) {
        this.var_boolean_a = bnk.a(this.var_boolean_a, bnk2.var_boolean_a);
        this.var_bfn$a_b = bnk.a(this.var_bfn$a_b, bnk2.var_bfn$a_b);
        this.c = bnk.a(this.c, bnk2.c);
        this.d = bnk.a(this.d, bnk2.d);
    }

    private static <T> a<T> a(a<T> a2, a<T> a3) {
        if (a2 == null) {
            return a3;
        }
        if (a3 == null) {
            return a2;
        }
        return a2.b(a3);
    }

    public void void_a() {
        this.var_boolean_a = this.a((a)this.var_boolean_a);
        this.c = this.a(this.c);
        this.d = this.a(this.d);
        this.var_bfn$a_b = this.a((a)((Object)this.var_bfn$a_b));
    }

    public bbw.a a(boolean bl2, bnj bnj2) {
        bbw.a a2 = this.bbw$a_a();
        if (a2 == null) {
            a2 = bbw.a.var_bbw$a_a;
        }
        switch (a2) {
            case b: {
                if (bnj2 != null) {
                    bnj2.void_a(this.java_lang_String_a());
                    for (bgj bgj2 : this.a()) {
                        bnj2.void_a(bgj2.java_lang_String_a());
                    }
                }
                this.d = null;
                this.var_bfn$a_b = null;
                if (this.var_boolean_a) break;
                this.var_boolean_a = null;
                break;
            }
            case d: {
                break;
            }
            case c: {
                this.c = null;
                if (!this.var_boolean_a) break;
                this.var_boolean_a = null;
                break;
            }
            default: {
                this.c = this.b(this.c);
                this.var_bfn$a_b = this.b((a)((Object)this.var_bfn$a_b));
                if (bl2 && this.c != null) break;
                this.var_boolean_a = this.b((a)this.var_boolean_a);
                this.d = this.b(this.d);
            }
        }
        return a2;
    }

    public void void_b() {
        this.var_bfn$a_b = null;
    }

    public void void_c() {
        this.var_boolean_a = this.c((a)this.var_boolean_a);
        this.c = this.c(this.c);
        this.d = this.c(this.d);
        this.var_bfn$a_b = this.c((a)((Object)this.var_bfn$a_b));
    }

    public void a(boolean bl2) {
        if (bl2) {
            if (this.c != null) {
                bmu bmu2 = this.a(0, new a[]{this.c, (a)this.var_boolean_a, this.var_bfn$a_b, this.d});
                this.c = this.a(this.c, bmu2);
            } else if (this.var_boolean_a != null) {
                bmu bmu3 = this.a(0, new a[]{(a)this.var_boolean_a, this.var_bfn$a_b, this.d});
                this.var_boolean_a = this.a((a)this.var_boolean_a, bmu3);
            }
        } else if (this.var_bfn$a_b != null) {
            bmu bmu4 = this.a(0, new a[]{this.var_bfn$a_b, this.d, (a)this.var_boolean_a, this.c});
            this.var_bfn$a_b = this.a((a)((Object)this.var_bfn$a_b), bmu4);
        } else if (this.d != null) {
            bmu bmu5 = this.a(0, this.d, (a)this.var_boolean_a, this.c);
            this.d = this.a(this.d, bmu5);
        } else if (this.var_boolean_a != null) {
            bmu bmu6 = this.a(0, (a)this.var_boolean_a, this.c);
            this.var_boolean_a = this.a((a)this.var_boolean_a, bmu6);
        }
    }

    private bmu a(int n2, a<? extends bmn> ... aArray) {
        bmu bmu2 = this.bmu_a(aArray[n2]);
        while (++n2 < aArray.length) {
            if (aArray[n2] == null) continue;
            return bmu.a(bmu2, this.a(n2, aArray));
        }
        return bmu2;
    }

    private <T extends bmn> bmu bmu_a(a<T> a2) {
        bmu bmu2 = ((bmn)a2.var_T_a).bmu_a();
        if (a2.var_T_a != null) {
            bmu2 = bmu.a(bmu2, this.bmu_a((a<T>)a2.var_T_a));
        }
        return bmu2;
    }

    private <T extends bmn> a<T> a(a<T> a2, bmu bmu2) {
        bmn bmn2 = (bmn)((bmn)a2.var_T_a).a(bmu2);
        if (a2.var_T_a != null) {
            a2 = a2.a(this.a((a<T>)a2.var_T_a, bmu2));
        }
        return a2.a(bmn2);
    }

    private <T> a<T> a(a<T> a2) {
        if (a2 == null) {
            return a2;
        }
        return a2.b();
    }

    private <T> a<T> b(a<T> a2) {
        if (a2 == null) {
            return a2;
        }
        return a2.c();
    }

    private <T> a<T> c(a<T> a2) {
        if (a2 == null) {
            return a2;
        }
        return a2.d();
    }

    private <T> boolean boolean_a(a<T> a2) {
        while (a2 != null) {
            if (a2.var_bgj_a != null && a2.var_bgj_a.boolean_a()) {
                return true;
            }
            a2 = a2.var_T_a;
        }
        return false;
    }

    private <T> boolean b(a<T> a2) {
        while (a2 != null) {
            if (a2.var_bgj_a != null && a2.var_boolean_a) {
                return true;
            }
            a2 = a2.var_T_a;
        }
        return false;
    }

    public boolean j() {
        return this.c((a)this.var_boolean_a) || this.c(this.c) || this.c(this.d) || this.c((a)((Object)this.var_bfn$a_b));
    }

    private <T> boolean c(a<T> a2) {
        while (a2 != null) {
            if (a2.b) {
                return true;
            }
            a2 = a2.var_T_a;
        }
        return false;
    }

    public boolean k() {
        return this.d((a)this.var_boolean_a) || this.d(this.c) || this.d(this.d) || this.d((a)((Object)this.var_bfn$a_b));
    }

    private <T> boolean d(a<T> a2) {
        while (a2 != null) {
            if (a2.c) {
                return true;
            }
            a2 = a2.var_T_a;
        }
        return false;
    }

    public Set<bgj> a() {
        Set<bgj> set = null;
        set = this.a((a<? extends bmn>)this.var_boolean_a, set);
        set = this.a(this.c, set);
        set = this.a(this.d, set);
        if ((set = this.a((a<? extends bmn>)((Object)this.var_bfn$a_b), set)) == null) {
            return Collections.emptySet();
        }
        return set;
    }

    public Collection<bnk> a(Collection<bgj> collection) {
        HashMap<bgj, bnk> hashMap = new HashMap<bgj, bnk>();
        this.a(collection, (Map<bgj, bnk>)hashMap, (a<?>)this.var_boolean_a);
        this.a(collection, hashMap, this.c);
        this.a(collection, hashMap, this.d);
        this.a(collection, (Map<bgj, bnk>)hashMap, (a<?>)((Object)this.var_bfn$a_b));
        return hashMap.values();
    }

    private void a(Collection<bgj> collection, Map<bgj, bnk> map, a<?> a2) {
        a<?> a3 = a2;
        a<Object> a4 = a2;
        while (a4 != null) {
            bgj bgj2 = a4.var_bgj_a;
            if (!a4.var_boolean_a || bgj2 == null) {
                if (a4.b) {
                    throw new IllegalStateException("Conflicting/ambiguous property name definitions (implicit name " + buk.a(this.var_bgj_a) + "): found multiple explicit names: " + collection + ", but also implicit accessor: " + a4);
                }
            } else {
                a<Object> a5;
                bnk bnk2 = map.get(bgj2);
                if (bnk2 == null) {
                    bnk2 = new bnk((bhm<?>)this.var_boolean_a, this.var_bfn_a, this.var_boolean_a, this.var_bgj_b, bgj2);
                    map.put(bgj2, bnk2);
                }
                if (a3 == this.var_boolean_a) {
                    a5 = a4;
                    bnk2.var_boolean_a = a5.a((a<Object>)bnk2.var_boolean_a);
                } else if (a3 == this.c) {
                    a5 = a4;
                    bnk2.c = a5.a(bnk2.c);
                } else if (a3 == this.d) {
                    a5 = a4;
                    bnk2.d = a5.a(bnk2.d);
                } else if (a3 == this.var_bfn$a_b) {
                    a5 = a4;
                    bnk2.var_bfn$a_b = a5.a((a<Object>)((Object)bnk2.var_bfn$a_b));
                } else {
                    throw new IllegalStateException("Internal error: mismatched accessors, property: " + this);
                }
            }
            a4 = a4.var_T_a;
        }
    }

    private Set<bgj> a(a<? extends bmn> a2, Set<bgj> set) {
        while (a2 != null) {
            if (a2.var_boolean_a && a2.var_bgj_a != null) {
                if (set == null) {
                    set = new HashSet<bgj>();
                }
                set.add(a2.var_bgj_a);
            }
            a2 = a2.var_T_a;
        }
        return set;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[Property '").append(this.var_bgj_a).append("'; ctors: ").append(this.var_bfn$a_b).append(", field(s): ").append((Object)this.var_boolean_a).append(", getter(s): ").append(this.c).append(", setter(s): ").append(this.d);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    protected <T> T a(c<T> c2) {
        T t2 = null;
        if (this.var_bfn_a != null) {
            if (this.var_boolean_a) {
                if (this.c != null) {
                    t2 = c2.a((bmn)this.c.var_T_a);
                }
            } else {
                if (this.var_bfn$a_b != null) {
                    t2 = c2.a((bmn)((a)((Object)this.var_bfn$a_b)).var_T_a);
                }
                if (t2 == null && this.d != null) {
                    t2 = c2.a((bmn)this.d.var_T_a);
                }
            }
            if (t2 == null && this.var_boolean_a != null) {
                t2 = c2.a((bmn)this.var_boolean_a.var_T_a);
            }
        }
        return t2;
    }

    protected <T> T a(c<T> c2, T t2) {
        T t3;
        if (this.var_bfn_a == null) {
            return null;
        }
        if (this.var_boolean_a) {
            T t4;
            if (this.c != null && (t4 = c2.a((bmn)this.c.var_T_a)) != null && t4 != t2) {
                return t4;
            }
            if (this.var_boolean_a != null && (t4 = c2.a((bmn)this.var_boolean_a.var_T_a)) != null && t4 != t2) {
                return t4;
            }
            if (this.var_bfn$a_b != null && (t4 = c2.a((bmn)((a)((Object)this.var_bfn$a_b)).var_T_a)) != null && t4 != t2) {
                return t4;
            }
            if (this.d != null && (t4 = c2.a((bmn)this.d.var_T_a)) != null && t4 != t2) {
                return t4;
            }
            return null;
        }
        if (this.var_bfn$a_b != null && (t3 = c2.a((bmn)((a)((Object)this.var_bfn$a_b)).var_T_a)) != null && t3 != t2) {
            return t3;
        }
        if (this.d != null && (t3 = c2.a((bmn)this.d.var_T_a)) != null && t3 != t2) {
            return t3;
        }
        if (this.var_boolean_a != null && (t3 = c2.a((bmn)this.var_boolean_a.var_T_a)) != null && t3 != t2) {
            return t3;
        }
        if (this.c != null && (t3 = c2.a((bmn)this.c.var_T_a)) != null && t3 != t2) {
            return t3;
        }
        return null;
    }

    protected Class<?> a(bmn bmn2) {
        bmo bmo2;
        if (bmn2 instanceof bmo && (bmo2 = (bmo)bmn2).int_a() > 0) {
            return bmo2.bfw_a(0).a();
        }
        return bmn2.bfw_a().a();
    }

    @Override
    public /* synthetic */ int compareTo(Object object) {
        return this.int_a((bnk)object);
    }

    static {
        var_bfn$a_b = bfn.a.a("");
    }

    protected static final class a<T> {
        public final T var_T_a;
        public final a<T> var_bnk$a_T__a;
        public final bgj var_bgj_a;
        public final boolean var_boolean_a;
        public final boolean b;
        public final boolean c;

        public a(T t2, a<T> a2, bgj bgj2, boolean bl2, boolean bl3, boolean bl4) {
            this.var_T_a = t2;
            this.var_T_a = a2;
            bgj bgj3 = this.var_bgj_a = bgj2 == null || bgj2.c() ? null : bgj2;
            if (bl2) {
                if (this.var_bgj_a == null) {
                    throw new IllegalArgumentException("Cannot pass true for 'explName' if name is null/empty");
                }
                if (!bgj2.boolean_a()) {
                    bl2 = false;
                }
            }
            this.var_boolean_a = bl2;
            this.b = bl3;
            this.c = bl4;
        }

        public a<T> a() {
            if (this.var_T_a == null) {
                return this;
            }
            return new a<T>(this.var_T_a, null, this.var_bgj_a, this.var_boolean_a, this.b, this.c);
        }

        public a<T> a(T t2) {
            if (t2 == this.var_T_a) {
                return this;
            }
            return new a<T>(t2, this.var_T_a, this.var_bgj_a, this.var_boolean_a, this.b, this.c);
        }

        public a<T> a(a<T> a2) {
            if (a2 == this.var_T_a) {
                return this;
            }
            return new a<T>(this.var_T_a, a2, this.var_bgj_a, this.var_boolean_a, this.b, this.c);
        }

        public a<T> b() {
            a<T> a2;
            if (this.c) {
                return this.var_T_a == null ? null : ((a)this.var_T_a).b();
            }
            if (this.var_T_a != null && (a2 = ((a)this.var_T_a).b()) != this.var_T_a) {
                return this.a(a2);
            }
            return this;
        }

        public a<T> c() {
            a<T> a2 = this.var_T_a == null ? null : ((a)this.var_T_a).c();
            return this.b ? this.a(a2) : a2;
        }

        protected a<T> b(a<T> a2) {
            if (this.var_T_a == null) {
                return this.a(a2);
            }
            return this.a(((a)this.var_T_a).b(a2));
        }

        public a<T> d() {
            if (this.var_T_a == null) {
                return this;
            }
            a<T> a2 = ((a)this.var_T_a).d();
            if (this.var_bgj_a != null) {
                if (a2.var_bgj_a == null) {
                    return this.a(null);
                }
                return this.a(a2);
            }
            if (a2.var_bgj_a != null) {
                return a2;
            }
            if (this.b == a2.b) {
                return this.a(a2);
            }
            return this.b ? this.a(null) : a2;
        }

        public String toString() {
            String string = String.format("%s[visible=%b,ignore=%b,explicitName=%b]", this.var_T_a.toString(), this.b, this.c, this.var_boolean_a);
            if (this.var_T_a != null) {
                string = string + ", " + ((a)this.var_T_a).toString();
            }
            return string;
        }
    }

    protected static class b<T extends bmn>
    implements Iterator<T> {
        private a<T> a;

        public b(a<T> a2) {
            this.a = a2;
        }

        @Override
        public boolean hasNext() {
            return this.a != null;
        }

        public T a() {
            if (this.a == null) {
                throw new NoSuchElementException();
            }
            bmn bmn2 = (bmn)this.a.var_T_a;
            this.a = this.a.var_T_a;
            return (T)bmn2;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public /* synthetic */ Object next() {
            return this.a();
        }
    }

    static interface c<T> {
        public T a(bmn var1);
    }
}

