/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class bhv
extends blc<Object>
implements bib,
bim,
Serializable {
    protected static final bgj var_bgj_a;
    protected final bfw var_bfw_a;
    protected final bbk.c var_bbk$c_a;
    protected final bir var_bir_a;
    protected bfx<Object> var_bfx_java_lang_Object__a;
    protected bfx<Object> var_bfx_java_lang_Object__b;
    protected bjo var_bjo_a;
    protected boolean var_boolean_a;
    protected boolean var_boolean_b;
    protected final biv var_biv_a;
    protected final bjx[] var_bjx_arr_a;
    protected bin var_bin_a;
    protected final Set<String> var_java_util_Set_java_lang_String__a;
    protected final Set<String> var_java_util_Set_java_lang_String__b;
    protected final boolean c;
    protected final boolean d;
    protected final Map<String, bio> cfr_renamed_15;
    protected transient HashMap<btm, bfx<Object>> cfr_renamed_18;
    protected bjw var_bjw_a;
    protected biz var_biz_a;
    protected final bjl var_bjl_a;

    protected bhv(bhw bhw2, bfo bfo2, biv biv2, Map<String, bio> map, Set<String> set, boolean bl2, Set<String> set2, boolean bl3) {
        super(bfo2.bfw_a());
        this.var_bfw_a = bfo2.bfw_a();
        this.var_bir_a = bhw2.bir_a();
        this.var_bgj_a = null;
        this.var_bfx_java_lang_Object__b = null;
        this.var_bjo_a = null;
        this.var_biv_a = biv2;
        this.var_bgj_a = map;
        this.var_bgj_a = set;
        this.c = bl2;
        this.var_bfx_java_lang_Object__b = set2;
        this.var_bin_a = bhw2.bin_a();
        List<bjx> list = bhw2.a();
        this.var_bjx_arr_a = list == null || list.isEmpty() ? null : list.toArray(new bjx[list.size()]);
        this.var_bjl_a = bhw2.bjl_a();
        this.var_boolean_a = this.var_bjw_a != null || this.var_bir_a.j() || this.var_bir_a.l() || !this.var_bir_a.i();
        bbk.d d2 = bfo2.a((bbk.d)null);
        this.var_bbk$c_a = d2.bbk$c_a();
        this.d = bl3;
        this.var_boolean_b = !this.var_boolean_a && this.var_bjx_arr_a == null && !this.d && this.var_bjl_a == null;
    }

    protected bhv(bhv bhv2) {
        this(bhv2, bhv2.c);
    }

    protected bhv(bhv bhv2, boolean bl2) {
        super(bhv2.var_bfw_a);
        this.var_bfw_a = bhv2.var_bfw_a;
        this.var_bir_a = bhv2.var_bir_a;
        this.var_bgj_a = bhv2.var_bgj_a;
        this.var_bfx_java_lang_Object__b = bhv2.var_bfx_java_lang_Object__b;
        this.var_bjo_a = bhv2.var_bjo_a;
        this.var_biv_a = bhv2.var_biv_a;
        this.var_bgj_a = bhv2.var_bgj_a;
        this.var_bgj_a = bhv2.var_bgj_a;
        this.c = bl2;
        this.var_bfx_java_lang_Object__b = bhv2.var_bfx_java_lang_Object__b;
        this.var_bin_a = bhv2.var_bin_a;
        this.var_bjx_arr_a = bhv2.var_bjx_arr_a;
        this.var_bjl_a = bhv2.var_bjl_a;
        this.var_boolean_a = bhv2.var_boolean_a;
        this.var_bjw_a = bhv2.var_bjw_a;
        this.d = bhv2.d;
        this.var_bbk$c_a = bhv2.var_bbk$c_a;
        this.var_boolean_b = bhv2.var_boolean_b;
    }

    protected bhv(bhv bhv2, but but2) {
        super(bhv2.var_bfw_a);
        this.var_bfw_a = bhv2.var_bfw_a;
        this.var_bir_a = bhv2.var_bir_a;
        this.var_bgj_a = bhv2.var_bgj_a;
        this.var_bfx_java_lang_Object__b = bhv2.var_bfx_java_lang_Object__b;
        this.var_bjo_a = bhv2.var_bjo_a;
        this.var_bgj_a = bhv2.var_bgj_a;
        this.var_bgj_a = bhv2.var_bgj_a;
        this.c = but2 != null || bhv2.c;
        this.var_bfx_java_lang_Object__b = bhv2.var_bfx_java_lang_Object__b;
        this.var_bin_a = bhv2.var_bin_a;
        this.var_bjx_arr_a = bhv2.var_bjx_arr_a;
        this.var_bjl_a = bhv2.var_bjl_a;
        this.var_boolean_a = bhv2.var_boolean_a;
        bjw bjw2 = bhv2.var_bjw_a;
        if (but2 != null) {
            if (bjw2 != null) {
                bjw2 = bjw2.a(but2);
            }
            this.var_biv_a = bhv2.var_biv_a.a(but2);
        } else {
            this.var_biv_a = bhv2.var_biv_a;
        }
        this.var_bjw_a = bjw2;
        this.d = bhv2.d;
        this.var_bbk$c_a = bhv2.var_bbk$c_a;
        this.var_boolean_b = false;
    }

    public bhv(bhv bhv2, bjl bjl2) {
        super(bhv2.var_bfw_a);
        this.var_bfw_a = bhv2.var_bfw_a;
        this.var_bir_a = bhv2.var_bir_a;
        this.var_bgj_a = bhv2.var_bgj_a;
        this.var_bfx_java_lang_Object__b = bhv2.var_bfx_java_lang_Object__b;
        this.var_bjo_a = bhv2.var_bjo_a;
        this.var_bgj_a = bhv2.var_bgj_a;
        this.var_bgj_a = bhv2.var_bgj_a;
        this.c = bhv2.c;
        this.var_bfx_java_lang_Object__b = bhv2.var_bfx_java_lang_Object__b;
        this.var_bin_a = bhv2.var_bin_a;
        this.var_bjx_arr_a = bhv2.var_bjx_arr_a;
        this.var_boolean_a = bhv2.var_boolean_a;
        this.var_bjw_a = bhv2.var_bjw_a;
        this.d = bhv2.d;
        this.var_bbk$c_a = bhv2.var_bbk$c_a;
        this.var_bjl_a = bjl2;
        if (bjl2 == null) {
            this.var_biv_a = bhv2.var_biv_a;
            this.var_boolean_b = bhv2.var_boolean_b;
        } else {
            bjn bjn2 = new bjn(bjl2, bgi.var_bgi_a);
            this.var_biv_a = bhv2.var_biv_a.biv_a(bjn2);
            this.var_boolean_b = false;
        }
    }

    public bhv(bhv bhv2, Set<String> set, Set<String> set2) {
        super(bhv2.var_bfw_a);
        this.var_bfw_a = bhv2.var_bfw_a;
        this.var_bir_a = bhv2.var_bir_a;
        this.var_bgj_a = bhv2.var_bgj_a;
        this.var_bfx_java_lang_Object__b = bhv2.var_bfx_java_lang_Object__b;
        this.var_bjo_a = bhv2.var_bjo_a;
        this.var_bgj_a = bhv2.var_bgj_a;
        this.var_bgj_a = set;
        this.c = bhv2.c;
        this.var_bfx_java_lang_Object__b = set2;
        this.var_bin_a = bhv2.var_bin_a;
        this.var_bjx_arr_a = bhv2.var_bjx_arr_a;
        this.var_boolean_a = bhv2.var_boolean_a;
        this.var_bjw_a = bhv2.var_bjw_a;
        this.d = bhv2.d;
        this.var_bbk$c_a = bhv2.var_bbk$c_a;
        this.var_boolean_b = bhv2.var_boolean_b;
        this.var_bjl_a = bhv2.var_bjl_a;
        this.var_biv_a = bhv2.var_biv_a.a(set, set2);
    }

    protected bhv(bhv bhv2, biv biv2) {
        super(bhv2.var_bfw_a);
        this.var_bfw_a = bhv2.var_bfw_a;
        this.var_bir_a = bhv2.var_bir_a;
        this.var_bgj_a = bhv2.var_bgj_a;
        this.var_bfx_java_lang_Object__b = bhv2.var_bfx_java_lang_Object__b;
        this.var_bjo_a = bhv2.var_bjo_a;
        this.var_biv_a = biv2;
        this.var_bgj_a = bhv2.var_bgj_a;
        this.var_bgj_a = bhv2.var_bgj_a;
        this.c = bhv2.c;
        this.var_bfx_java_lang_Object__b = bhv2.var_bfx_java_lang_Object__b;
        this.var_bin_a = bhv2.var_bin_a;
        this.var_bjx_arr_a = bhv2.var_bjx_arr_a;
        this.var_bjl_a = bhv2.var_bjl_a;
        this.var_boolean_a = bhv2.var_boolean_a;
        this.var_bjw_a = bhv2.var_bjw_a;
        this.d = bhv2.d;
        this.var_bbk$c_a = bhv2.var_bbk$c_a;
        this.var_boolean_b = bhv2.var_boolean_b;
    }

    @Override
    public abstract bfx<Object> a(but var1);

    public abstract bhv a(bjl var1);

    public abstract bhv a(Set<String> var1, Set<String> var2);

    public abstract bhv a(boolean var1);

    public bhv a(biv biv2) {
        throw new UnsupportedOperationException("Class " + this.getClass().getName() + " does not override `withBeanProperties()`, needs to");
    }

    @Override
    protected abstract bhv bhv_a();

    @Override
    public void a(bfs bfs2) {
        Object object;
        bfx<?> bfx2;
        bfx<Object> bfx3;
        bio[] bioArray;
        biz.a a2 = null;
        if (this.var_bir_a.l()) {
            bioArray = this.var_bir_a.bio_arr_a(bfs2.bfr_a());
            if (this.var_bgj_a != null || this.var_bfx_java_lang_Object__b != null) {
                int n2 = bioArray.length;
                for (int i2 = 0; i2 < n2; ++i2) {
                    bio bio2 = bioArray[i2];
                    if (!bup.a(bio2.java_lang_String_a(), (Collection<String>)((Object)this.var_bgj_a), this.var_bfx_java_lang_Object__b)) continue;
                    bioArray[i2].void_a();
                }
            }
        } else {
            bioArray = null;
        }
        bjw bjw2 = null;
        for (bio bio2 : this.var_biv_a) {
            if (bio2.c()) continue;
            bfx3 = this.a(bfs2, bio2);
            if (bfx3 == null) {
                bfx3 = bfs2.a(bio2.bfw_a());
            }
            bfx2 = bio2.a(bfx3);
            this.a(this.var_biv_a, bioArray, bio2, (bio)((Object)bfx2));
        }
        for (bio bio2 : this.var_biv_a) {
            Object object2;
            Object object3;
            but but2;
            bfx3 = bio2;
            bfx2 = ((bio)((Object)bfx3)).bil_a();
            bfx2 = bfs2.a(bfx2, (bfp)((Object)bfx3), ((bio)((Object)bfx3)).bfw_a());
            bfx3 = ((bio)((Object)bfx3)).a(bfx2);
            if (!((bfx3 = this.bio_a(bfs2, (bio)((Object)bfx3))) instanceof bjf)) {
                bfx3 = this.b(bfs2, (bio)((Object)bfx3));
            }
            if ((but2 = this.but_a(bfs2, (bio)((Object)bfx3))) != null && (object3 = ((bfx)(object2 = ((bio)((Object)bfx3)).bil_a())).a(but2)) != object2 && object3 != null) {
                bfx3 = ((bio)((Object)bfx3)).a((bfx<?>)object3);
                if (bjw2 == null) {
                    bjw2 = new bjw();
                }
                bjw2.a((bio)((Object)bfx3));
                this.var_biv_a.void_a((bio)((Object)bfx3));
                continue;
            }
            object2 = ((bio)((Object)bfx3)).java_lang_Object_a();
            bfx3 = this.a(bfs2, (bio)((Object)bfx3), (bgi)object2);
            if ((bfx3 = this.c(bfs2, (bio)((Object)bfx3))) != bio2) {
                this.a(this.var_biv_a, bioArray, bio2, (bio)((Object)bfx3));
            }
            if (!((bio)((Object)bfx3)).d() || ((boc)(object3 = ((bio)((Object)bfx3)).boc_a())).bce$a_a() != bce.a.d) continue;
            if (a2 == null) {
                a2 = biz.a(this.var_bfw_a);
            }
            a2.a((bio)((Object)bfx3), (boc)object3);
            this.var_biv_a.void_a((bio)((Object)bfx3));
        }
        if (this.var_bin_a != null && !this.var_bin_a.boolean_a()) {
            this.var_bin_a = this.var_bin_a.a(this.a(bfs2, this.var_bin_a.bfw_a(), this.var_bin_a.bfp_a()));
        }
        if (this.var_bir_a.j()) {
            object = this.var_bir_a.bfw_a(bfs2.bfr_a());
            if (object == null) {
                bfs2.b(this.var_bfw_a, String.format("Invalid delegate-creator definition for %s: value instantiator (%s) returned true for 'canCreateUsingDelegate()', but null for 'getDelegateType()'", buk.a(this.var_bfw_a), buk.c(this.var_bir_a)));
            }
            this.var_bgj_a = this.a(bfs2, (bfw)object, this.var_bir_a.bms_b());
        }
        if (this.var_bir_a.k()) {
            object = this.var_bir_a.b(bfs2.bfr_a());
            if (object == null) {
                bfs2.b(this.var_bfw_a, String.format("Invalid delegate-creator definition for %s: value instantiator (%s) returned true for 'canCreateUsingArrayDelegate()', but null for 'getArrayDelegateType()'", buk.a(this.var_bfw_a), buk.c(this.var_bir_a)));
            }
            this.var_bfx_java_lang_Object__b = this.a(bfs2, (bfw)object, this.var_bir_a.bms_c());
        }
        if (bioArray != null) {
            this.var_bjo_a = bjo.a(bfs2, this.var_bir_a, bioArray, this.var_biv_a);
        }
        if (a2 != null) {
            this.var_biz_a = a2.a(this.var_biv_a);
            this.var_boolean_a = true;
        }
        this.var_bjw_a = bjw2;
        if (bjw2 != null) {
            this.var_boolean_a = true;
        }
        this.var_boolean_b = this.var_boolean_b && !this.var_boolean_a;
    }

    protected void a(biv biv2, bio[] bioArray, bio bio2, bio bio3) {
        biv2.a(bio2, bio3);
        if (bioArray != null) {
            int n2 = bioArray.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                if (bioArray[i2] != bio2) continue;
                bioArray[i2] = bio3;
                return;
            }
        }
    }

    private bfx<Object> a(bfs bfs2, bfw bfw2, bms bms2) {
        bfx<Object> bfx2;
        bfp.b b2 = new bfp.b(var_bgj_a, bfw2, null, bms2, bgi.var_bgi_b);
        boc boc2 = (boc)bfw2.b();
        if (boc2 == null) {
            boc2 = bfs2.bfr_a().boc_a(bfw2);
        }
        bfx2 = (bfx2 = (bfx<Object>)bfw2.a()) == null ? this.a(bfs2, bfw2, b2) : bfs2.b(bfx2, b2, bfw2);
        if (boc2 != null) {
            boc2 = boc2.a(b2);
            return new bju(boc2, bfx2);
        }
        return bfx2;
    }

    protected bfx<Object> a(bfs bfs2, bio bio2) {
        Object object;
        bfn bfn2 = bfs2.bfn_a();
        if (bfn2 != null && (object = bfn2.j(bio2.bmn_a())) != null) {
            bum<Object, Object> bum2 = bfs2.a((bmg)bio2.bmn_a(), object);
            bfw bfw2 = bum2.a(bfs2.btz_a());
            bfx<Object> bfx2 = bfs2.a(bfw2);
            return new blb<Object>(bum2, bfw2, bfx2);
        }
        return null;
    }

    @Override
    public bfx<?> a(bfs bfs2, bfp bfp2) {
        Serializable serializable;
        Object object;
        Serializable serializable2;
        Object object2;
        Serializable serializable3;
        Object object3;
        bmn bmn2;
        bjl bjl2 = this.var_bjl_a;
        bfn bfn2 = bfs2.bfn_a();
        bmn bmn3 = bmn2 = bhv.a(bfp2, bfn2) ? bfp2.bmn_a() : null;
        if (bmn2 != null && (object3 = bfn2.bni_a((bmg)bmn2)) != null) {
            Object object4;
            object3 = bfn2.a((bmg)bmn2, (bni)object3);
            serializable3 = ((bni)object3).b();
            object2 = bfs2.a((bmg)bmn2, (bni)object3);
            if (serializable3 == bcl.c.class) {
                object4 = ((bni)object3).bgj_a();
                serializable2 = this.a((bgj)object4);
                if (serializable2 == null) {
                    bfs2.b(this.var_bfw_a, String.format("Invalid Object Id definition for %s: cannot find property with name %s", buk.java_lang_String_b(this.a()), buk.a((bgj)object4)));
                }
                object = ((bio)serializable2).bfw_a();
                serializable = new bjp(((bni)object3).a());
            } else {
                object4 = bfs2.bfw_a((Class<?>)serializable3);
                object = bfs2.btz_a().bfw_arr_a((bfw)object4, bck.class)[0];
                serializable2 = null;
                serializable = bfs2.a((bmg)bmn2, (bni)object3);
            }
            object4 = bfs2.b((bfw)object);
            bjl2 = bjl.a((bfw)object, ((bni)object3).bgj_a(), serializable, object4, (bio)serializable2, (bcm)object2);
        }
        object3 = this;
        if (bjl2 != null && bjl2 != this.var_bjl_a) {
            object3 = ((bhv)object3).a(bjl2);
        }
        if (bmn2 != null) {
            object3 = this.a(bfs2, bfn2, (bhv)object3, bmn2);
        }
        serializable3 = this.a(bfs2, bfp2, this.a());
        object = null;
        if (serializable3 != null) {
            if (((bbk.d)serializable3).boolean_a()) {
                object = ((bbk.d)serializable3).bbk$c_a();
            }
            if ((serializable2 = ((bbk.d)serializable3).a(bbk.a.b)) != null && (object2 = (serializable = this.var_biv_a).a((Boolean)serializable2)) != serializable) {
                object3 = ((bhv)object3).a((biv)object2);
            }
        }
        if (object == null) {
            object = this.var_bbk$c_a;
        }
        if (object == bbk.c.d) {
            object3 = ((bhv)object3).bhv_a();
        }
        return object3;
    }

    protected bhv a(bfs bfs2, bfn bfn2, bhv bhv2, bmn bmn2) {
        HashSet<String> hashSet;
        bfr bfr2 = bfs2.bfr_a();
        bbp.a a2 = bfn2.bbp$a_a(bfr2, bmn2);
        if (a2.boolean_a() && !this.c) {
            bhv2 = bhv2.a(true);
        }
        Set<String> set = a2.b();
        bgj bgj2 = bhv2.var_bgj_a;
        if (set.isEmpty()) {
            hashSet = bgj2;
        } else if (bgj2 == null || bgj2.isEmpty()) {
            hashSet = set;
        } else {
            hashSet = new HashSet<String>((Collection<String>)((Object)bgj2));
            hashSet.addAll(set);
        }
        bfx<Object> bfx2 = bhv2.var_bfx_java_lang_Object__b;
        Set<String> set2 = bup.a(bfx2, bfn2.bbs$a_a(bfr2, bmn2).a());
        if (hashSet != bgj2 || set2 != bfx2) {
            bhv2 = bhv2.a(hashSet, set2);
        }
        return bhv2;
    }

    protected bio bio_a(bfs bfs2, bio bio2) {
        String string = bio2.java_lang_String_b();
        if (string == null) {
            return bio2;
        }
        bil bil2 = bio2.bil_a();
        bio bio3 = ((bfx)bil2).a(string);
        if (bio3 == null) {
            bfs2.b(this.var_bfw_a, String.format("Cannot handle managed/back reference %s: no back reference property found from type %s", buk.b(string), buk.a(bio2.bfw_a())));
        }
        bfw bfw2 = this.var_bfw_a;
        bfw bfw3 = bio3.bfw_a();
        boolean bl2 = bio2.bfw_a().m();
        if (!((Class)bfw3.a()).isAssignableFrom((Class<?>)bfw2.a())) {
            bfs2.b(this.var_bfw_a, String.format("Cannot handle managed/back reference %s: back reference type (%s) not compatible with managed type (%s)", buk.b(string), buk.a(bfw3), ((Class)bfw2.a()).getName()));
        }
        return new bjf(bio2, string, bio3, bl2);
    }

    protected bio b(bfs bfs2, bio bio2) {
        bjl bjl2;
        bni bni2 = bio2.bni_a();
        bil bil2 = bio2.bil_a();
        bjl bjl3 = bjl2 = bil2 == null ? null : ((bfx)bil2).bjl_a();
        if (bni2 == null && bjl2 == null) {
            return bio2;
        }
        return new bjm(bio2, bni2);
    }

    protected but but_a(bfs bfs2, bio bio2) {
        but but2;
        bmn bmn2 = bio2.bmn_a();
        if (bmn2 != null && (but2 = bfs2.bfn_a().but_a(bmn2)) != null) {
            if (bio2 instanceof bid) {
                bfs2.b(this.bfw_a(), String.format("Cannot define Creator property \"%s\" as `@JsonUnwrapped`: combination not yet supported", bio2.java_lang_String_a()));
            }
            return but2;
        }
        return null;
    }

    protected bio c(bfs bfs2, bio bio2) {
        Object t2;
        Class<?> clazz;
        bhv bhv2;
        bir bir2;
        bil bil2 = bio2.bil_a();
        if (bil2 instanceof bhv && !(bir2 = (bhv2 = (bhv)bil2).bir_a()).i() && (clazz = buk.a(t2 = bio2.bfw_a().a())) != null && clazz == this.var_bfw_a.a()) {
            for (Constructor<?> constructor : ((Class)t2).getConstructors()) {
                Class<?>[] classArray = constructor.getParameterTypes();
                if (classArray.length != 1 || !clazz.equals(classArray[0])) continue;
                if (bfs2.boolean_a()) {
                    buk.a(constructor, bfs2.a(bgd.o));
                }
                return new bjc(bio2, constructor);
            }
        }
        return bio2;
    }

    protected bio a(bfs bfs2, bio bio2, bgi bgi2) {
        bil bil2;
        bgi.a a2 = bgi2.bgi$a_a();
        if (a2 != null) {
            bil2 = bio2.bil_a();
            Boolean bl2 = ((bfx)bil2).a(bfs2.bfr_a());
            if (bl2 == null) {
                if (a2.var_boolean_a) {
                    return bio2;
                }
            } else if (!bl2.booleanValue()) {
                if (!a2.var_boolean_a) {
                    bfs2.a((bfx<?>)bil2);
                }
                return bio2;
            }
            bmn bmn2 = a2.var_bmn_a;
            bmn2.a(bfs2.a(bgd.o));
            if (!(bio2 instanceof bjt)) {
                bio2 = bjg.a(bio2, bmn2);
            }
        }
        if ((bil2 = this.a(bfs2, bio2, bgi2)) != null) {
            bio2 = bio2.a(bil2);
        }
        return bio2;
    }

    @Override
    public buc buc_a() {
        return buc.c;
    }

    @Override
    public Object b(bfs bfs2) {
        try {
            return this.var_bir_a.a(bfs2);
        }
        catch (IOException iOException) {
            return buk.a(bfs2, iOException);
        }
    }

    @Override
    public boolean boolean_a() {
        return true;
    }

    @Override
    public Boolean a(bfr bfr2) {
        return Boolean.TRUE;
    }

    @Override
    public Class<?> a() {
        return this.var_bfw_a.a();
    }

    @Override
    public bjl bjl_a() {
        return this.var_bjl_a;
    }

    @Override
    public Collection<Object> a() {
        ArrayList<Object> arrayList = new ArrayList<Object>();
        for (bio bio2 : this.var_biv_a) {
            arrayList.add(bio2.java_lang_String_a());
        }
        return arrayList;
    }

    @Override
    public bfw bfw_a() {
        return this.var_bfw_a;
    }

    @Override
    public btq btq_a() {
        return btq.d;
    }

    public bio a(bgj bgj2) {
        return this.b(bgj2.java_lang_String_a());
    }

    public bio b(String string) {
        bio bio2;
        bio bio3 = bio2 = this.var_biv_a == null ? null : this.var_biv_a.bio_a(string);
        if (bio2 == null && this.var_bjo_a != null) {
            bio2 = this.var_bjo_a.a(string);
        }
        return bio2;
    }

    @Override
    public bio a(String string) {
        if (this.var_bgj_a == null) {
            return null;
        }
        return (bio)this.var_bgj_a.get(string);
    }

    @Override
    public bir bir_a() {
        return this.var_bir_a;
    }

    public abstract Object b(bdc var1, bfs var2);

    @Override
    public Object a(bdc bdc2, bfs bfs2, boc boc2) {
        if (this.var_bjl_a != null) {
            Object object;
            if (bdc2.boolean_h() && (object = bdc2.java_lang_Object_b()) != null) {
                Object object2 = boc2.java_lang_Object_a(bdc2, bfs2);
                return this.a(bdc2, bfs2, object2, object);
            }
            object = bdc2.bdf_c();
            if (object != null) {
                if (((bdf)((Object)object)).d()) {
                    return this.k(bdc2, bfs2);
                }
                if (object == bdf.var_bdf_b) {
                    object = bdc2.bdf_a();
                }
                if (object == bdf.f && this.var_bjl_a.boolean_a() && this.var_bjl_a.a(bdc2.java_lang_String_d(), bdc2)) {
                    return this.k(bdc2, bfs2);
                }
            }
        }
        return boc2.java_lang_Object_a(bdc2, bfs2);
    }

    protected Object a(bdc bdc2, bfs bfs2, Object object, Object object2) {
        bfx<Object> bfx2 = this.var_bjl_a.a();
        Object object3 = bfx2.a() == object2.getClass() ? object2 : this.a(bdc2, bfs2, object2, bfx2);
        bjs bjs2 = bfs2.a(object3, (bck<?>)((Object)this.var_bjl_a.var_bfw_a), this.var_bjl_a.var_bcm_a);
        bjs2.a(object);
        bio bio2 = this.var_bjl_a.var_bio_a;
        if (bio2 != null) {
            return bio2.java_lang_Object_a(object, object3);
        }
        return object;
    }

    protected Object a(bdc bdc2, bfs bfs2, Object object, bfx<Object> bfx2) {
        bve bve2 = new bve(bdc2, bfs2);
        if (object instanceof String) {
            bve2.b((String)object);
        } else if (object instanceof Long) {
            bve2.b((Long)object);
        } else if (object instanceof Integer) {
            bve2.void_b((Integer)object);
        } else {
            bve2.h(object);
        }
        bdc bdc3 = bve2.bdc_a();
        bdc3.bdf_a();
        return bfx2.a(bdc3, bfs2);
    }

    protected Object j(bdc bdc2, bfs bfs2) {
        return this.b(bdc2, bfs2);
    }

    protected Object k(bdc bdc2, bfs bfs2) {
        Object object = this.var_bjl_a.a(bdc2, bfs2);
        bjs bjs2 = bfs2.a(object, (bck<?>)((Object)this.var_bjl_a.var_bfw_a), this.var_bjl_a.var_bcm_a);
        Object object2 = bjs2.java_lang_Object_a();
        if (object2 == null) {
            throw new bip(bdc2, "Could not resolve Object Id [" + object + "] (for " + this.var_bfw_a + ").", bdc2.bda_b(), bjs2);
        }
        return object2;
    }

    protected Object l(bdc bdc2, bfs bfs2) {
        bfx<Object> bfx2 = this.a();
        if (bfx2 != null) {
            Object object = this.var_bir_a.a(bfs2, bfx2.a(bdc2, bfs2));
            if (this.var_bjx_arr_a != null) {
                this.void_a(bfs2, object);
            }
            return object;
        }
        if (this.var_bjo_a != null) {
            return this.c(bdc2, bfs2);
        }
        Object t2 = this.var_bfw_a.a();
        if (buk.i(t2)) {
            return bfs2.a((Class<?>)t2, (bir)null, bdc2, "non-static inner classes like this can only by instantiated using default, no-argument constructor", new Object[0]);
        }
        return bfs2.a((Class<?>)t2, this.bir_a(), bdc2, "cannot deserialize from Object value (no delegate- or property-based Creator)", new Object[0]);
    }

    protected abstract Object c(bdc var1, bfs var2);

    public Object m(bdc bdc2, bfs bfs2) {
        if (this.var_bjl_a != null) {
            return this.k(bdc2, bfs2);
        }
        bfx<Object> bfx2 = this.a();
        bdc.b b2 = bdc2.bdc$b_a();
        if (b2 == bdc.b.var_bdc$b_a) {
            if (bfx2 != null && !this.var_bir_a.boolean_c()) {
                Object object = this.var_bir_a.a(bfs2, bfx2.a(bdc2, bfs2));
                if (this.var_bjx_arr_a != null) {
                    this.void_a(bfs2, object);
                }
                return object;
            }
            return this.var_bir_a.a(bfs2, bdc2.int_e());
        }
        if (b2 == bdc.b.b) {
            if (bfx2 != null && !this.var_bir_a.boolean_c()) {
                Object object = this.var_bir_a.a(bfs2, bfx2.a(bdc2, bfs2));
                if (this.var_bjx_arr_a != null) {
                    this.void_a(bfs2, object);
                }
                return object;
            }
            return this.var_bir_a.a(bfs2, bdc2.long_a());
        }
        if (b2 == bdc.b.c) {
            if (bfx2 != null && !this.var_bir_a.e()) {
                Object object = this.var_bir_a.a(bfs2, bfx2.a(bdc2, bfs2));
                if (this.var_bjx_arr_a != null) {
                    this.void_a(bfs2, object);
                }
                return object;
            }
            return this.var_bir_a.a(bfs2, (BigInteger)bdc2.java_lang_Number_a());
        }
        return bfs2.a(this.a(), this.bir_a(), bdc2, "no suitable creator method found to deserialize from Number value (%s)", bdc2.java_lang_Number_a());
    }

    public Object n(bdc bdc2, bfs bfs2) {
        if (this.var_bjl_a != null) {
            return this.k(bdc2, bfs2);
        }
        bfx<Object> bfx2 = this.a();
        if (bfx2 != null && !this.var_bir_a.boolean_b()) {
            Object object = this.var_bir_a.a(bfs2, bfx2.a(bdc2, bfs2));
            if (this.var_bjx_arr_a != null) {
                this.void_a(bfs2, object);
            }
            return object;
        }
        return this.r(bdc2, bfs2);
    }

    public Object o(bdc bdc2, bfs bfs2) {
        bdc.b b2 = bdc2.bdc$b_a();
        if (b2 == bdc.b.e || b2 == bdc.b.d) {
            bfx<Object> bfx2 = this.a();
            if (bfx2 != null && !this.var_bir_a.f()) {
                Object object = this.var_bir_a.a(bfs2, bfx2.a(bdc2, bfs2));
                if (this.var_bjx_arr_a != null) {
                    this.void_a(bfs2, object);
                }
                return object;
            }
            return this.var_bir_a.a(bfs2, bdc2.double_a());
        }
        if (b2 == bdc.b.f) {
            bfx<Object> bfx3 = this.a();
            if (bfx3 != null && !this.var_bir_a.g()) {
                Object object = this.var_bir_a.a(bfs2, bfx3.a(bdc2, bfs2));
                if (this.var_bjx_arr_a != null) {
                    this.void_a(bfs2, object);
                }
                return object;
            }
            return this.var_bir_a.a(bfs2, (BigDecimal)bdc2.java_lang_Number_a());
        }
        return bfs2.a(this.a(), this.bir_a(), bdc2, "no suitable creator method found to deserialize from Number value (%s)", bdc2.java_lang_Number_a());
    }

    public Object p(bdc bdc2, bfs bfs2) {
        bfx<Object> bfx2 = this.a();
        if (bfx2 != null && !this.var_bir_a.h()) {
            Object object = this.var_bir_a.a(bfs2, bfx2.a(bdc2, bfs2));
            if (this.var_bjx_arr_a != null) {
                this.void_a(bfs2, object);
            }
            return object;
        }
        boolean bl2 = bdc2.bdf_c() == bdf.k;
        return this.var_bir_a.a(bfs2, bl2);
    }

    public Object q(bdc bdc2, bfs bfs2) {
        if (this.var_bjl_a != null) {
            return this.k(bdc2, bfs2);
        }
        bfx<Object> bfx2 = this.a();
        if (bfx2 != null && !this.var_bir_a.boolean_b()) {
            Object object = this.var_bir_a.a(bfs2, bfx2.a(bdc2, bfs2));
            if (this.var_bjx_arr_a != null) {
                this.void_a(bfs2, object);
            }
            return object;
        }
        Object object = bdc2.java_lang_Object_a();
        if (object != null && !this.var_bfw_a.c(object.getClass())) {
            object = bfs2.a(this.var_bfw_a, object, bdc2);
        }
        return object;
    }

    @Override
    protected final bfx<Object> a() {
        Object object = this.var_bgj_a;
        if (object == null) {
            object = this.var_bfx_java_lang_Object__b;
        }
        return object;
    }

    protected void void_a(bfs bfs2, Object object) {
        for (bjx bjx2 : this.var_bjx_arr_a) {
            bjx2.void_a(bfs2, object);
        }
    }

    protected Object a(bfs bfs2, Object object, bve bve2) {
        bve2.void_d();
        bdc bdc2 = bve2.bdc_a();
        while (bdc2.bdf_a() != bdf.var_bdf_c) {
            String string = bdc2.java_lang_String_d();
            bdc2.bdf_a();
            this.b(bdc2, bfs2, object, string);
        }
        return object;
    }

    protected void a(bdc bdc2, bfs bfs2, Object object, String string) {
        if (bup.a(string, (Collection<String>)((Object)this.var_bgj_a), this.var_bfx_java_lang_Object__b)) {
            this.c(bdc2, bfs2, object, string);
        } else if (this.var_bin_a != null) {
            try {
                this.var_bin_a.a(bdc2, bfs2, object, string);
            }
            catch (Exception exception) {
                this.a(exception, object, string, bfs2);
            }
        } else {
            this.b(bdc2, bfs2, object, string);
        }
    }

    @Override
    protected void b(bdc bdc2, bfs bfs2, Object object, String string) {
        if (this.c) {
            bdc2.bdc_a();
            return;
        }
        if (bup.a(string, (Collection<String>)((Object)this.var_bgj_a), this.var_bfx_java_lang_Object__b)) {
            this.c(bdc2, bfs2, object, string);
        }
        super.b(bdc2, bfs2, object, string);
    }

    protected void c(bdc bdc2, bfs bfs2, Object object, String string) {
        if (bfs2.a(bfu.j)) {
            throw blp.a(bdc2, object, string, this.a());
        }
        bdc2.bdc_a();
    }

    protected Object a(bdc bdc2, bfs bfs2, Object object, bve bve2) {
        Object object2 = this.a(bfs2, object, bve2);
        if (object2 != null) {
            if (bve2 != null) {
                bve2.void_d();
                bdc bdc3 = bve2.bdc_a();
                bdc3.bdf_a();
                object = ((bfx)object2).a(bdc3, bfs2, object);
            }
            if (bdc2 != null) {
                object = ((bfx)object2).a(bdc2, bfs2, object);
            }
            return object;
        }
        if (bve2 != null) {
            object = this.a(bfs2, object, bve2);
        }
        if (bdc2 != null) {
            object = this.a(bdc2, bfs2, object);
        }
        return object;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected bfx<Object> a(bfs bfs2, Object object, bve bve2) {
        bfx<Object> bfx2;
        Serializable serializable = this;
        synchronized (serializable) {
            bfx2 = this.var_bgj_a == null ? null : (bfx<Object>)((HashMap)((Object)this.var_bgj_a)).get(new btm(object.getClass()));
        }
        if (bfx2 != null) {
            return bfx2;
        }
        serializable = bfs2.bfw_a(object.getClass());
        bfx2 = bfs2.b((bfw)serializable);
        if (bfx2 != null) {
            bhv bhv2 = this;
            synchronized (bhv2) {
                if (this.var_bgj_a == null) {
                    this.var_bgj_a = new HashMap();
                }
                ((HashMap)((Object)this.var_bgj_a)).put(new btm(object.getClass()), bfx2);
            }
        }
        return bfx2;
    }

    public void a(Throwable throwable, Object object, String string, bfs bfs2) {
        throw bfy.a(this.java_lang_Throwable_a(throwable, bfs2), object, string);
    }

    private Throwable java_lang_Throwable_a(Throwable throwable, bfs bfs2) {
        boolean bl2;
        while (throwable instanceof InvocationTargetException && throwable.getCause() != null) {
            throwable = throwable.getCause();
        }
        buk.java_lang_Throwable_a(throwable);
        boolean bl3 = bl2 = bfs2 == null || bfs2.a(bfu.p);
        if (throwable instanceof IOException) {
            if (!bl2 || !(throwable instanceof bdd)) {
                throw (IOException)throwable;
            }
        } else if (!bl2) {
            buk.java_lang_Throwable_b(throwable);
        }
        return throwable;
    }

    protected Object java_lang_Object_a(Throwable throwable, bfs bfs2) {
        boolean bl2;
        while (throwable instanceof InvocationTargetException && throwable.getCause() != null) {
            throwable = throwable.getCause();
        }
        buk.java_lang_Throwable_a(throwable);
        if (throwable instanceof IOException) {
            throw (IOException)throwable;
        }
        boolean bl3 = bl2 = bfs2 == null || bfs2.a(bfu.p);
        if (!bl2) {
            buk.java_lang_Throwable_b(throwable);
        }
        return bfs2.a((Class<?>)this.var_bfw_a.a(), (Object)null, throwable);
    }

    static {
        var_bgj_a = new bgj("#temporary-name");
    }
}

