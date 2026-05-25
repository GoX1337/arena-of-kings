/*
 * Decompiled with CFR 0.152.
 */
import java.io.Closeable;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

public abstract class brt
extends bte<Object>
implements bqh,
bqo {
    protected static final bgj var_bgj_a;
    protected static final bqb[] var_bqb_arr_a;
    protected final bfw var_bfw_a;
    protected final bqb[] b;
    protected final bqb[] c;
    protected final bpx var_bpx_a;
    protected final Object var_java_lang_Object_a;
    protected final bmn var_bmn_a;
    protected final brc var_brc_a;
    protected final bbk.c var_bbk$c_a;

    protected brt(bfw bfw2, bqd bqd2, bqb[] bqbArray, bqb[] bqbArray2) {
        super(bfw2);
        this.var_bfw_a = bfw2;
        this.b = bqbArray;
        this.c = bqbArray2;
        if (bqd2 == null) {
            this.var_bmn_a = null;
            this.var_bpx_a = null;
            this.var_java_lang_Object_a = null;
            this.var_brc_a = null;
            this.var_bbk$c_a = null;
        } else {
            this.var_bmn_a = bqd2.java_lang_Object_a();
            this.var_bpx_a = bqd2.bpx_a();
            this.var_java_lang_Object_a = bqd2.java_lang_Object_a();
            this.var_brc_a = bqd2.java_lang_Object_a();
            bbk.d d2 = bqd2.bfo_a().a((bbk.d)null);
            this.var_bbk$c_a = d2.bbk$c_a();
        }
    }

    protected brt(brt brt2, bqb[] bqbArray, bqb[] bqbArray2) {
        super(brt2.var_bgj_a);
        this.var_bfw_a = brt2.var_bfw_a;
        this.b = bqbArray;
        this.c = bqbArray2;
        this.var_bmn_a = brt2.var_bmn_a;
        this.var_bpx_a = brt2.var_bpx_a;
        this.var_brc_a = brt2.var_brc_a;
        this.var_java_lang_Object_a = brt2.var_java_lang_Object_a;
        this.var_bbk$c_a = brt2.var_bbk$c_a;
    }

    protected brt(brt brt2, brc brc2) {
        this(brt2, brc2, brt2.var_java_lang_Object_a);
    }

    protected brt(brt brt2, brc brc2, Object object) {
        super(brt2.var_bgj_a);
        this.var_bfw_a = brt2.var_bfw_a;
        this.b = brt2.b;
        this.c = brt2.c;
        this.var_bmn_a = brt2.var_bmn_a;
        this.var_bpx_a = brt2.var_bpx_a;
        this.var_brc_a = brc2;
        this.var_java_lang_Object_a = object;
        this.var_bbk$c_a = brt2.var_bbk$c_a;
    }

    protected brt(brt brt2, Set<String> set, Set<String> set2) {
        super(brt2.var_bgj_a);
        this.var_bfw_a = brt2.var_bfw_a;
        bqb[] bqbArray = brt2.b;
        bqb[] bqbArray2 = brt2.c;
        int n2 = bqbArray.length;
        ArrayList<bqb> arrayList = new ArrayList<bqb>(n2);
        ArrayList<bqb> arrayList2 = bqbArray2 == null ? null : new ArrayList<bqb>(n2);
        for (int i2 = 0; i2 < n2; ++i2) {
            bqb bqb2 = bqbArray[i2];
            if (bup.a(bqb2.java_lang_String_a(), set, set2)) continue;
            arrayList.add(bqb2);
            if (bqbArray2 == null) continue;
            arrayList2.add(bqbArray2[i2]);
        }
        this.b = arrayList.toArray(new bqb[arrayList.size()]);
        this.c = arrayList2 == null ? null : arrayList2.toArray(new bqb[arrayList2.size()]);
        this.var_bmn_a = brt2.var_bmn_a;
        this.var_bpx_a = brt2.var_bpx_a;
        this.var_brc_a = brt2.var_brc_a;
        this.var_java_lang_Object_a = brt2.var_java_lang_Object_a;
        this.var_bbk$c_a = brt2.var_bbk$c_a;
    }

    public abstract brt a(brc var1);

    protected abstract brt a(Set<String> var1, Set<String> var2);

    protected abstract brt brt_a();

    public abstract brt a(Object var1);

    protected abstract brt a(bqb[] var1, bqb[] var2);

    protected brt(brt brt2, but but2) {
        this(brt2, brt.a(brt2.b, but2), brt.a(brt2.c, but2));
    }

    private static final bqb[] a(bqb[] bqbArray, but but2) {
        if (bqbArray == null || bqbArray.length == 0 || but2 == null || but2 == but.a) {
            return bqbArray;
        }
        int n2 = bqbArray.length;
        bqb[] bqbArray2 = new bqb[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            bqb bqb2 = bqbArray[i2];
            if (bqb2 == null) continue;
            bqbArray2[i2] = bqb2.a(but2);
        }
        return bqbArray2;
    }

    @Override
    public void void_a(bgo bgo2) {
        int n2 = this.c == null ? 0 : this.c.length;
        int n3 = this.b.length;
        for (int i2 = 0; i2 < n3; ++i2) {
            Serializable serializable;
            bgb<Object> bgb2;
            bqb bqb2 = this.b[i2];
            if (!bqb2.c() && !bqb2.boolean_b() && (bgb2 = bgo2.a(bqb2)) != null) {
                bqb2.b(bgb2);
                if (i2 < n2 && (serializable = this.c[i2]) != null) {
                    ((bqb)serializable).b(bgb2);
                }
            }
            if (bqb2.boolean_a()) continue;
            bgb2 = this.a(bgo2, bqb2);
            if (bgb2 == null) {
                bog bog2;
                serializable = bqb2.bfw_b();
                if (serializable == null && !((bfw)(serializable = bqb2.bfw_a())).l()) {
                    if (!((bfw)serializable).m() && ((bfw)serializable).int_a() <= 0) continue;
                    bqb2.a((bfw)serializable);
                    continue;
                }
                bgb2 = bgo2.a((bfw)serializable, (bfp)bqb2);
                if (((bfw)serializable).m() && (bog2 = (bog)((bfw)serializable).bfw_c().b()) != null && bgb2 instanceof bqg) {
                    bqg<?> bqg2 = ((bqg)bgb2).a(bog2);
                    bgb2 = bqg2;
                }
            }
            if (i2 < n2 && (serializable = this.c[i2]) != null) {
                ((bqb)serializable).a(bgb2);
                continue;
            }
            bqb2.a(bgb2);
        }
        if (this.var_bpx_a != null) {
            this.var_bpx_a.a(bgo2);
        }
    }

    protected bgb<Object> a(bgo bgo2, bqb bqb2) {
        Object object;
        bmn bmn2;
        bfn bfn2 = bgo2.bfn_a();
        if (bfn2 != null && (bmn2 = bqb2.bmn_a()) != null && (object = bfn2.java_lang_Object_f(bmn2)) != null) {
            bum<Object, Object> bum2 = bgo2.a((bmg)bqb2.bmn_a(), object);
            bfw bfw2 = bum2.b(bgo2.btz_a());
            bgb<Object> bgb2 = bfw2.p() ? null : bgo2.a(bfw2, (bfp)bqb2);
            return new bsz(bum2, bfw2, bgb2);
        }
        return null;
    }

    @Override
    public bgb<?> a(bgo bgo2, bfp bfp2) {
        Object object;
        Serializable serializable;
        Object object2;
        Object object3;
        bfn bfn2 = bgo2.bfn_a();
        bmn bmn2 = bfp2 == null || bfn2 == null ? null : bfp2.bmn_a();
        bgm bgm2 = bgo2.bgm_a();
        bbk.d d2 = this.bbk$d_a(bgo2, bfp2, (Class<?>)((Object)this.var_bgj_a));
        bbk.c c2 = null;
        if (d2 != null && d2.boolean_a() && (c2 = d2.bbk$c_a()) != bbk.c.var_bbk$c_a && c2 != this.var_bbk$c_a) {
            if (this.var_bfw_a.g()) {
                switch (c2) {
                    case i: 
                    case f: 
                    case h: {
                        bfo bfo2 = bgm2.c(this.var_bfw_a);
                        bsd bsd2 = bsd.a(this.var_bfw_a.a(), bgo2.bgm_a(), bfo2, d2);
                        return bgo2.a(bsd2, bfp2);
                    }
                }
            } else if (!(c2 != bbk.c.b || this.var_bfw_a.o() && Map.class.isAssignableFrom((Class<?>)((Object)this.var_bgj_a)) || !Map.Entry.class.isAssignableFrom((Class<?>)((Object)this.var_bgj_a)))) {
                bfw bfw2 = this.var_bfw_a.bfw_a(Map.Entry.class);
                bfw bfw3 = bfw2.b(0);
                bfw bfw4 = bfw2.b(1);
                bra bra2 = new bra(this.var_bfw_a, bfw3, bfw4, false, null, bfp2);
                return bgo2.a(bra2, bfp2);
            }
        }
        brc brc2 = this.var_brc_a;
        int n2 = 0;
        Set<String> set = null;
        Set<String> set2 = null;
        Object object4 = null;
        if (bmn2 != null) {
            set = bfn2.bbp$a_a(bgm2, bmn2).a();
            set2 = bfn2.bbs$a_a(bgm2, bmn2).a();
            object3 = bfn2.bni_a((bmg)bmn2);
            if (object3 == null) {
                if (brc2 != null && (object3 = bfn2.a((bmg)bmn2, (bni)null)) != null) {
                    brc2 = this.var_brc_a.a(((bni)object3).boolean_a());
                }
            } else {
                object3 = bfn2.a((bmg)bmn2, (bni)object3);
                object2 = ((bni)object3).b();
                serializable = bgo2.a((Type)object2);
                object = bgo2.btz_a().bfw_arr_a((bfw)serializable, bck.class)[0];
                if (object2 == bcl.c.class) {
                    bqb bqb2;
                    String string = ((bni)object3).bgj_a().java_lang_String_a();
                    bqb bqb3 = null;
                    int n3 = 0;
                    int n4 = this.b.length;
                    while (true) {
                        if (n3 == n4) {
                            bgo2.b(this.var_bfw_a, String.format("Invalid Object Id definition for %s: cannot find property with name %s", buk.java_lang_String_b(this.a()), buk.b(string)));
                        }
                        if (string.equals((bqb2 = this.b[n3]).java_lang_String_a())) break;
                        ++n3;
                    }
                    bqb3 = bqb2;
                    n2 = n3;
                    object = bqb3.bfw_a();
                    brd brd2 = new brd((bni)object3, bqb3);
                    brc2 = brc.a((bfw)object, null, brd2, ((bni)object3).boolean_a());
                } else {
                    bck<?> bck2 = bgo2.a((bmg)bmn2, (bni)object3);
                    brc2 = brc.a((bfw)object, ((bni)object3).bgj_a(), bck2, ((bni)object3).boolean_a());
                }
            }
            if (!((object2 = bfn2.java_lang_Object_a((bmg)bmn2)) == null || this.var_java_lang_Object_a != null && object2.equals(this.var_java_lang_Object_a))) {
                object4 = object2;
            }
        }
        object3 = this;
        if (n2 > 0) {
            object2 = Arrays.copyOf(this.b, this.b.length);
            serializable = object2[n2];
            System.arraycopy(object2, 0, object2, 1, n2);
            object2[0] = serializable;
            if (this.c == null) {
                object = null;
            } else {
                object = Arrays.copyOf(this.c, this.c.length);
                serializable = object[n2];
                System.arraycopy(object, 0, object, 1, n2);
                object[0] = serializable;
            }
            object3 = ((brt)object3).a((bqb[])object2, (bqb[])object);
        }
        if (brc2 != null && (brc2 = brc2.a((bgb<?>)(object2 = bgo2.a(brc2.var_bfw_a, bfp2)))) != this.var_brc_a) {
            object3 = ((brt)object3).a(brc2);
        }
        if (set != null && !set.isEmpty() || set2 != null) {
            object3 = ((brt)object3).a(set, set2);
        }
        if (object4 != null) {
            object3 = ((brt)object3).a(object4);
        }
        if (c2 == null) {
            c2 = this.var_bbk$c_a;
        }
        if (c2 == bbk.c.d) {
            return ((brt)object3).brt_a();
        }
        return object3;
    }

    @Override
    public boolean boolean_a() {
        return this.var_brc_a != null;
    }

    @Override
    public void a(Object object, bcy bcy2, bgo bgo2, bog bog2) {
        if (this.var_brc_a != null) {
            bcy2.a(object);
            this.b(object, bcy2, bgo2, bog2);
            return;
        }
        bcy2.a(object);
        beu beu2 = this.a(bog2, object, bdf.var_bdf_b);
        bog2.a(bcy2, beu2);
        if (this.var_java_lang_Object_a != null) {
            this.d(object, bcy2, bgo2);
        } else {
            this.c(object, bcy2, bgo2);
        }
        bog2.b(bcy2, beu2);
    }

    protected final void a(Object object, bcy bcy2, bgo bgo2, boolean bl2) {
        brc brc2 = this.var_brc_a;
        brp brp2 = bgo2.a(object, (bck<?>)((Object)brc2.var_bfw_a));
        if (brp2.boolean_a(bcy2, bgo2, brc2)) {
            return;
        }
        Object object2 = brp2.a(object);
        if (brc2.var_boolean_a) {
            ((bgb)((Object)brc2.var_bfw_a)).a(object2, bcy2, bgo2);
            return;
        }
        if (bl2) {
            bcy2.c(object);
        }
        brp2.void_a(bcy2, bgo2, brc2);
        if (this.var_java_lang_Object_a != null) {
            this.d(object, bcy2, bgo2);
        } else {
            this.c(object, bcy2, bgo2);
        }
        if (bl2) {
            bcy2.void_d();
        }
    }

    protected final void b(Object object, bcy bcy2, bgo bgo2, bog bog2) {
        brc brc2 = this.var_brc_a;
        brp brp2 = bgo2.a(object, (bck<?>)((Object)brc2.var_bfw_a));
        if (brp2.boolean_a(bcy2, bgo2, brc2)) {
            return;
        }
        Object object2 = brp2.a(object);
        if (brc2.var_boolean_a) {
            ((bgb)((Object)brc2.var_bfw_a)).a(object2, bcy2, bgo2);
            return;
        }
        this.a(object, bcy2, bgo2, bog2, brp2);
    }

    protected void a(Object object, bcy bcy2, bgo bgo2, bog bog2, brp brp2) {
        brc brc2 = this.var_brc_a;
        beu beu2 = this.a(bog2, object, bdf.var_bdf_b);
        bog2.a(bcy2, beu2);
        brp2.void_a(bcy2, bgo2, brc2);
        if (this.var_java_lang_Object_a != null) {
            this.d(object, bcy2, bgo2);
        } else {
            this.c(object, bcy2, bgo2);
        }
        bog2.b(bcy2, beu2);
    }

    protected final beu a(bog bog2, Object object, bdf bdf2) {
        if (this.var_bmn_a == null) {
            return bog2.a(object, bdf2);
        }
        Object object2 = this.var_bmn_a.b(object);
        if (object2 == null) {
            object2 = "";
        }
        return bog2.a(object, bdf2, object2);
    }

    protected void c(Object object, bcy bcy2, bgo bgo2) {
        int n2;
        bqb[] bqbArray = this.c != null && bgo2.a() != null ? this.c : this.b;
        try {
            for (bqb bqb2 : bqbArray) {
                if (bqb2 == null) continue;
                bqb2.void_a(object, bcy2, bgo2);
            }
            if (this.var_bpx_a != null) {
                this.var_bpx_a.a(object, bcy2, bgo2);
            }
        }
        catch (Exception exception) {
            String string = n2 == bqbArray.length ? "[anySetter]" : bqbArray[n2].java_lang_String_a();
            this.a(bgo2, (Throwable)exception, object, string);
        }
        catch (StackOverflowError stackOverflowError) {
            bfy bfy2 = new bfy((Closeable)bcy2, "Infinite recursion (StackOverflowError)", (Throwable)stackOverflowError);
            String string = n2 == bqbArray.length ? "[anySetter]" : bqbArray[n2].java_lang_String_a();
            bfy2.a(new bfy.a(object, string));
            throw bfy2;
        }
    }

    protected void d(Object object, bcy bcy2, bgo bgo2) {
        int n2;
        bqb[] bqbArray = this.c != null && bgo2.a() != null ? this.c : this.b;
        bqm bqm2 = this.a(bgo2, this.var_java_lang_Object_a, object);
        if (bqm2 == null) {
            this.c(object, bcy2, bgo2);
            return;
        }
        try {
            for (bqb bqb2 : bqbArray) {
                if (bqb2 == null) continue;
                bqm2.a(object, bcy2, bgo2, bqb2);
            }
            if (this.var_bpx_a != null) {
                this.var_bpx_a.a(object, bcy2, bgo2, bqm2);
            }
        }
        catch (Exception exception) {
            String string = n2 == bqbArray.length ? "[anySetter]" : bqbArray[n2].java_lang_String_a();
            this.a(bgo2, (Throwable)exception, object, string);
        }
        catch (StackOverflowError stackOverflowError) {
            bfy bfy2 = new bfy((Closeable)bcy2, "Infinite recursion (StackOverflowError)", (Throwable)stackOverflowError);
            String string = n2 == bqbArray.length ? "[anySetter]" : bqbArray[n2].java_lang_String_a();
            bfy2.a(new bfy.a(object, string));
            throw bfy2;
        }
    }

    static {
        var_bgj_a = new bgj("#object-ref");
        var_bqb_arr_a = new bqb[0];
    }
}

