/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.RandomAccess;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;

public abstract class bpy
extends bqq
implements Serializable {
    protected static final HashMap<String, bgb<?>> cfr_renamed_38;
    protected static final HashMap<String, Class<? extends bgb<?>>> b;
    protected final bhp var_bhp_a;

    protected bpy(bhp bhp2) {
        this.var_bhp_a = bhp2 == null ? new bhp() : bhp2;
    }

    @Override
    public bgb<Object> a(bgo bgo2, bfw bfw2, bgb<Object> bgb2) {
        Object object;
        bgm bgm2 = bgo2.bgm_a();
        bfo bfo2 = bgm2.a(bfw2);
        bsj bsj2 = null;
        if (this.var_bhp_a.a()) {
            bqr bgb32;
            object = this.var_bhp_a.b().iterator();
            while (object.hasNext() && (bsj2 = (bgb32 = object.next()).a(bgm2, bfw2, bfo2)) == null) {
            }
        }
        if (bsj2 == null && (bsj2 = this.b(bgo2, bfo2.bmh_a())) == null && (bsj2 = bgb2) == null && (bsj2 = btc.a(bgm2, bfw2.a(), false)) == null) {
            object = bfo2.bmn_a();
            if (object == null) {
                object = bfo2.bmn_b();
            }
            if (object != null) {
                bgb<Object> bgb3 = this.a(bgo2, ((bmg)object).bfw_a(), bgb2);
                if (bgm2.c()) {
                    buk.a(((bmn)object).java_lang_reflect_Member_a(), bgm2.a(bgd.o));
                }
                bsj2 = new bsj((bmn)object, null, bgb3);
            } else {
                bsj2 = btc.a(bgm2, bfw2.a());
            }
        }
        if (this.var_bhp_a.b()) {
            for (bqf bqf2 : this.var_bhp_a.c()) {
                bsj2 = bqf2.b(bgm2, bfw2, bfo2, bsj2);
            }
        }
        return bsj2;
    }

    @Override
    @Deprecated
    public bgb<Object> a(bgm bgm2, bfw bfw2, bgb<Object> bgb2) {
        bfo bfo2 = bgm2.a(bfw2);
        bgb<Object> bgb3 = null;
        if (this.var_bhp_a.a()) {
            bqr object;
            Iterator<Object> iterator = this.var_bhp_a.b().iterator();
            while (iterator.hasNext() && (bgb3 = (object = iterator.next()).a(bgm2, bfw2, bfo2)) == null) {
            }
        }
        if (bgb3 == null && (bgb3 = bgb2) == null && (bgb3 = btc.a(bgm2, bfw2.a(), false)) == null) {
            bgb3 = btc.a(bgm2, bfw2.a());
        }
        if (this.var_bhp_a.b()) {
            for (bqf bqf2 : this.var_bhp_a.c()) {
                bgb3 = bqf2.b(bgm2, bfw2, bfo2, bgb3);
            }
        }
        return bgb3;
    }

    @Override
    public bog a(bgm bgm2, bfw bfw2) {
        bfo bfo2 = bgm2.bfo_a((Class<?>)bfw2.a());
        bmh bmh2 = bfo2.bmh_a();
        bfn bfn2 = bgm2.bfn_a();
        bof<?> bof2 = bfn2.a(bgm2, bmh2, bfw2);
        Collection<bnz> collection = null;
        if (bof2 == null) {
            bof2 = bgm2.a(bfw2);
        } else {
            collection = bgm2.bob_a().a(bgm2, bmh2);
        }
        if (bof2 == null) {
            return null;
        }
        return bof2.a(bgm2, bfw2, collection);
    }

    protected abstract Iterable<bqr> a();

    protected final bgb<?> a(bfw bfw2, bgm bgm2, bfo bfo2, boolean bl2) {
        Class<? extends bgb<?>> clazz;
        Object t2 = bfw2.a();
        String string = ((Class)t2).getName();
        bgb<?> bgb2 = cfr_renamed_38.get(string);
        if (bgb2 == null && (clazz = b.get(string)) != null) {
            return (bgb)buk.a(clazz, false);
        }
        return bgb2;
    }

    protected final bgb<?> a(bgo bgo2, bfw bfw2, bfo bfo2) {
        Object t2 = bfw2.a();
        if (bga.class.isAssignableFrom((Class<?>)t2)) {
            return bsw.a;
        }
        bmn bmn2 = bfo2.bmn_b();
        if (bmn2 != null) {
            bog bog2;
            if (bgo2.boolean_a()) {
                buk.a(bmn2.java_lang_reflect_Member_a(), bgo2.a(bgd.o));
            }
            bfw bfw3 = bmn2.bfw_a();
            bgb bgb2 = this.a(bgo2, bmn2);
            if (bgb2 == null) {
                bgb2 = (bgb)bfw3.a();
            }
            if ((bog2 = (bog)bfw3.b()) == null) {
                bog2 = this.a(bgo2.bgm_a(), bfw3);
            }
            return new bsj(bmn2, bog2, bgb2);
        }
        return null;
    }

    protected final bgb<?> a(bgo bgo2, bfw bfw2, bfo bfo2, boolean bl2) {
        if (bfw2.g()) {
            return this.a(bgo2.bgm_a(), bfw2, bfo2);
        }
        Object t2 = bfw2.a();
        bgb<?> bgb2 = this.b(bgo2, bfw2, bfo2, bl2);
        if (bgb2 != null) {
            return bgb2;
        }
        if (Calendar.class.isAssignableFrom((Class<?>)t2)) {
            return bry.a;
        }
        if (Date.class.isAssignableFrom((Class<?>)t2)) {
            return bsb.a;
        }
        if (Map.Entry.class.isAssignableFrom((Class<?>)t2)) {
            bfw bfw3 = bfw2.bfw_a(Map.Entry.class);
            bfw bfw4 = bfw3.b(0);
            bfw bfw5 = bfw3.b(1);
            return this.a(bgo2, bfw2, bfo2, bl2, bfw4, bfw5);
        }
        if (ByteBuffer.class.isAssignableFrom((Class<?>)t2)) {
            return new brx();
        }
        if (InetAddress.class.isAssignableFrom((Class<?>)t2)) {
            return new bsg();
        }
        if (InetSocketAddress.class.isAssignableFrom((Class<?>)t2)) {
            return new bsh();
        }
        if (TimeZone.class.isAssignableFrom((Class<?>)t2)) {
            return new btg();
        }
        if (Charset.class.isAssignableFrom((Class<?>)t2)) {
            return bth.a;
        }
        if (Number.class.isAssignableFrom((Class<?>)t2)) {
            bbk.d d2 = bfo2.a((bbk.d)null);
            switch (d2.bbk$c_a()) {
                case i: {
                    return bth.a;
                }
                case e: 
                case d: {
                    return null;
                }
            }
            return bso.var_bso_a;
        }
        return null;
    }

    protected bgb<?> b(bgo bgo2, bfw bfw2, bfo bfo2, boolean bl2) {
        return bme.var_bme_a.a(bgo2.bgm_a(), bfw2, bfo2);
    }

    protected final bgb<?> a(bgm bgm2, bfw bfw2, bfo bfo2, boolean bl2) {
        Object t2 = bfw2.a();
        if (Iterator.class.isAssignableFrom((Class<?>)t2)) {
            bfw[] bfwArray = bgm2.btz_a().bfw_arr_a(bfw2, Iterator.class);
            bfw bfw3 = bfwArray == null || bfwArray.length != 1 ? btz.bfw_a() : bfwArray[0];
            return this.a(bgm2, bfw2, bfo2, bl2, bfw3);
        }
        if (Iterable.class.isAssignableFrom((Class<?>)t2)) {
            bfw[] bfwArray = bgm2.btz_a().bfw_arr_a(bfw2, Iterable.class);
            bfw bfw4 = bfwArray == null || bfwArray.length != 1 ? btz.bfw_a() : bfwArray[0];
            return this.b(bgm2, bfw2, bfo2, bl2, bfw4);
        }
        if (CharSequence.class.isAssignableFrom((Class<?>)t2)) {
            return bth.a;
        }
        return null;
    }

    protected bgb<Object> a(bgo bgo2, bmg bmg2) {
        Object object = bgo2.bfn_a().java_lang_Object_b(bmg2);
        if (object == null) {
            return null;
        }
        bgb<Object> bgb2 = bgo2.a(bmg2, object);
        return this.a(bgo2, bmg2, bgb2);
    }

    protected bgb<?> a(bgo bgo2, bmg bmg2, bgb<?> bgb2) {
        bum<Object, Object> bum2 = this.a(bgo2, bmg2);
        if (bum2 == null) {
            return bgb2;
        }
        bfw bfw2 = bum2.b(bgo2.btz_a());
        return new bsz(bum2, bfw2, bgb2);
    }

    protected bum<Object, Object> a(bgo bgo2, bmg bmg2) {
        Object object = bgo2.bfn_a().java_lang_Object_f(bmg2);
        if (object == null) {
            return null;
        }
        return bgo2.a(bmg2, object);
    }

    protected bgb<?> c(bgo bgo2, bfw bfw2, bfo bfo2, boolean bl2) {
        bfw bfw3;
        bog bog2;
        bgm bgm2 = bgo2.bgm_a();
        if (!(bl2 || !bfw2.q() || bfw2.m() && bfw2.bfw_c().p())) {
            bl2 = true;
        }
        if ((bog2 = this.a(bgm2, bfw3 = bfw2.bfw_c())) != null) {
            bl2 = false;
        }
        bgb<Object> bgb2 = this.c(bgo2, bfo2.bmh_a());
        if (bfw2.o()) {
            bqr bqr2;
            btr btr2 = (btr)bfw2;
            bgb<Object> bgb3 = this.b(bgo2, bfo2.bmh_a());
            if (btr2 instanceof bts) {
                return this.a(bgo2, (bts)btr2, bfo2, bl2, bgb3, bog2, bgb2);
            }
            bgb<?> bgb4 = null;
            btr btr3 = (btr)bfw2;
            Iterator<bqr> iterator = this.a().iterator();
            while (iterator.hasNext() && (bgb4 = (bqr2 = iterator.next()).a(bgm2, btr3, bfo2, bgb3, bog2, bgb2)) == null) {
            }
            if (bgb4 == null) {
                bgb4 = this.a(bgo2, bfw2, bfo2);
            }
            if (bgb4 != null && this.var_bhp_a.b()) {
                for (bqf bqf2 : this.var_bhp_a.c()) {
                    bgb4 = bqf2.a(bgm2, btr3, bfo2, bgb4);
                }
            }
            return bgb4;
        }
        if (bfw2.n()) {
            bqr bqr3;
            bto bto2 = (bto)bfw2;
            if (bto2 instanceof btp) {
                return this.a(bgo2, (btp)bto2, bfo2, bl2, bog2, bgb2);
            }
            bgb<?> bgb5 = null;
            bto bto3 = (bto)bfw2;
            Iterator<Object> iterator = this.a().iterator();
            while (iterator.hasNext() && (bgb5 = (bqr3 = iterator.next()).a(bgm2, bto3, bfo2, bog2, bgb2)) == null) {
            }
            if (bgb5 == null) {
                bgb5 = this.a(bgo2, bfw2, bfo2);
            }
            if (bgb5 != null && this.var_bhp_a.b()) {
                for (bqf bqf3 : this.var_bhp_a.c()) {
                    bgb5 = bqf3.a(bgm2, bto3, bfo2, bgb5);
                }
            }
            return bgb5;
        }
        if (bfw2.boolean_f()) {
            return this.a(bgo2, (btl)bfw2, bfo2, bl2, bog2, bgb2);
        }
        return null;
    }

    protected bgb<?> a(bgo bgo2, btp btp2, bfo bfo2, boolean bl2, bog bog2, bgb<Object> bgb2) {
        bqr object3;
        bgm bgm2 = bgo2.bgm_a();
        bte bte2 = null;
        Object object2 = this.a().iterator();
        while (object2.hasNext() && (bte2 = (object3 = object2.next()).a(bgm2, btp2, bfo2, bog2, bgb2)) == null) {
        }
        if (bte2 == null && (bte2 = this.a(bgo2, (bfw)btp2, bfo2)) == null) {
            bfw bfw2;
            object2 = bfo2.a((bbk.d)null);
            if (((bbk.d)object2).bbk$c_a() == bbk.c.e) {
                return null;
            }
            Object t2 = btp2.a();
            if (EnumSet.class.isAssignableFrom((Class<?>)t2)) {
                bfw2 = btp2.bfw_c();
                if (!bfw2.h()) {
                    bfw2 = null;
                }
                bte2 = this.a(bfw2);
            } else {
                bfw2 = btp2.bfw_c().a();
                if (this.a((Class<?>)t2)) {
                    if (bfw2 == String.class) {
                        if (buk.boolean_a(bgb2)) {
                            bte2 = bqy.a;
                        }
                    } else {
                        bte2 = this.a(btp2.bfw_c(), bl2, bog2, bgb2);
                    }
                } else if (bfw2 == String.class && buk.boolean_a(bgb2)) {
                    bte2 = brj.a;
                }
                if (bte2 == null) {
                    bte2 = this.b(btp2.bfw_c(), bl2, bog2, bgb2);
                }
            }
        }
        if (this.var_bhp_a.b()) {
            for (bqf bqf2 : this.var_bhp_a.c()) {
                bte2 = bqf2.a(bgm2, btp2, bfo2, bte2);
            }
        }
        return bte2;
    }

    protected boolean a(Class<?> clazz) {
        return RandomAccess.class.isAssignableFrom(clazz);
    }

    public bqg<?> a(bfw bfw2, boolean bl2, bog bog2, bgb<Object> bgb2) {
        return new bqx(bfw2, bl2, bog2, bgb2);
    }

    public bqg<?> b(bfw bfw2, boolean bl2, bog bog2, bgb<Object> bgb2) {
        return new bsa(bfw2, bl2, bog2, bgb2);
    }

    public bgb<?> a(bfw bfw2) {
        return new bse(bfw2);
    }

    protected bgb<?> a(bgo bgo2, bts bts2, bfo bfo2, boolean bl2, bgb<Object> bgb2, bog bog2, bgb<Object> bgb3) {
        bqr object3;
        bbk.d d2 = bfo2.a((bbk.d)null);
        if (d2.bbk$c_a() == bbk.c.e) {
            return null;
        }
        bsl bsl2 = null;
        bgm bgm2 = bgo2.bgm_a();
        Object object2 = this.a().iterator();
        while (object2.hasNext() && (bsl2 = (object3 = object2.next()).a(bgm2, bts2, bfo2, bgb2, bog2, bgb3)) == null) {
        }
        if (bsl2 == null && (bsl2 = this.a(bgo2, (bfw)bts2, bfo2)) == null) {
            object2 = this.a(bgm2, bfo2);
            bbp.a a2 = bgm2.bbp$a_a(Map.class, bfo2.bmh_a());
            Set<String> set = a2 == null ? null : a2.a();
            bbs.a a3 = bgm2.bbs$a_a(Map.class, bfo2.bmh_a());
            Set<String> set2 = a3 == null ? null : a3.a();
            bsl bsl3 = bsl.a(set, set2, bts2, bl2, bog2, bgb2, bgb3, object2);
            bsl2 = this.a(bgo2, bfo2, bsl3);
        }
        if (this.var_bhp_a.b()) {
            for (bqf bqf2 : this.var_bhp_a.c()) {
                bsl2 = bqf2.a(bgm2, bts2, bfo2, bsl2);
            }
        }
        return bsl2;
    }

    protected bsl a(bgo bgo2, bfo bfo2, bsl bsl2) {
        Object object;
        bbr.a a2;
        bfw bfw2 = bsl2.a();
        bbr.b b2 = this.a(bgo2, bfo2, bfw2, Map.class);
        bbr.a a3 = a2 = b2 == null ? bbr.a.g : b2.b();
        if (a2 == bbr.a.g || a2 == bbr.a.var_bbr$a_a) {
            if (!bgo2.a(bgn.r)) {
                return bsl2.a((Object)null, true);
            }
            return bsl2;
        }
        boolean bl2 = true;
        switch (a2) {
            case e: {
                object = buh.java_lang_Object_a(bfw2);
                if (object == null || !object.getClass().isArray()) break;
                object = bue.a(object);
                break;
            }
            case c: {
                object = bfw2.a() != false ? bsl.var_java_lang_Object_a : null;
                break;
            }
            case d: {
                object = bsl.var_java_lang_Object_a;
                break;
            }
            case f: {
                object = bgo2.a((bmx)null, b2.b());
                if (object == null) {
                    bl2 = true;
                    break;
                }
                bl2 = bgo2.boolean_a(object);
                break;
            }
            default: {
                object = null;
            }
        }
        return bsl2.a(object, bl2);
    }

    protected bgb<?> a(bgo bgo2, bfw bfw2, bfo bfo2, boolean bl2, bfw bfw3, bfw bfw4) {
        Object object;
        bbr.a a2;
        bbk.d d2 = bgo2.bbk$d_a(Map.Entry.class);
        bbk.d d3 = bfo2.a((bbk.d)null);
        bbk.d d4 = bbk.d.a(d3, d2);
        if (d4.bbk$c_a() == bbk.c.e) {
            return null;
        }
        bra bra2 = new bra(bfw4, bfw3, bfw4, bl2, this.a(bgo2.bgm_a(), bfw4), null);
        bfw bfw5 = bra2.a();
        bbr.b b2 = this.a(bgo2, bfo2, bfw5, Map.Entry.class);
        bbr.a a3 = a2 = b2 == null ? bbr.a.g : b2.b();
        if (a2 == bbr.a.g || a2 == bbr.a.var_bbr$a_a) {
            return bra2;
        }
        boolean bl3 = true;
        switch (a2) {
            case e: {
                object = buh.java_lang_Object_a(bfw5);
                if (object == null || !object.getClass().isArray()) break;
                object = bue.a(object);
                break;
            }
            case c: {
                object = bfw5.a() != false ? bsl.var_java_lang_Object_a : null;
                break;
            }
            case d: {
                object = bsl.var_java_lang_Object_a;
                break;
            }
            case f: {
                object = bgo2.a((bmx)null, b2.b());
                if (object == null) {
                    bl3 = true;
                    break;
                }
                bl3 = bgo2.boolean_a(object);
                break;
            }
            default: {
                object = null;
            }
        }
        return bra2.a(object, bl3);
    }

    protected bbr.b a(bgo bgo2, bfo bfo2, bfw bfw2, Class<?> clazz) {
        bgm bgm2 = bgo2.bgm_a();
        bbr.b b2 = bfo2.a(bgm2.bbr$b_a());
        b2 = bgm2.a(clazz, b2);
        bbr.b b3 = bgm2.a((Class<?>)bfw2.a(), (bbr.b)null);
        if (b3 != null) {
            switch (b3.bbr$a_a()) {
                case g: {
                    break;
                }
                case f: {
                    b2 = b2.a(b3.b());
                    break;
                }
                default: {
                    b2 = b2.b(b3.bbr$a_a());
                }
            }
        }
        return b2;
    }

    protected bgb<?> a(bgo bgo2, btl btl2, bfo bfo2, boolean bl2, bog bog2, bgb<Object> bgb2) {
        bqr object2;
        bgm bgm2 = bgo2.bgm_a();
        bgb bgb3 = null;
        Iterator<Object> iterator = this.a().iterator();
        while (iterator.hasNext() && (bgb3 = (object2 = iterator.next()).a(bgm2, btl2, bfo2, bog2, bgb2)) == null) {
        }
        if (bgb3 == null) {
            iterator = btl2.a();
            if (bgb2 == null || buk.boolean_a(bgb2)) {
                bgb3 = String[].class == iterator ? bri.var_bri_a : bsy.a(iterator);
            }
            if (bgb3 == null) {
                bgb3 = new bss(btl2.bfw_c(), bl2, bog2, bgb2);
            }
        }
        if (this.var_bhp_a.b()) {
            for (bqf bqf2 : this.var_bhp_a.c()) {
                bgb3 = bqf2.a(bgm2, btl2, bfo2, bgb3);
            }
        }
        return bgb3;
    }

    public bgb<?> a(bgo bgo2, btu btu2, bfo bfo2, boolean bl2) {
        bfw bfw2 = btu2.bfw_c();
        bog bog2 = (bog)bfw2.b();
        bgm bgm2 = bgo2.bgm_a();
        if (bog2 == null) {
            bog2 = this.a(bgm2, bfw2);
        }
        bgb bgb2 = (bgb)bfw2.a();
        for (bqr bqr2 : this.a()) {
            bgb<?> bgb3 = bqr2.a(bgm2, btu2, bfo2, bog2, (bgb<Object>)bgb2);
            if (bgb3 == null) continue;
            return bgb3;
        }
        if (btu2.b(AtomicReference.class)) {
            return this.a(bgo2, btu2, bfo2, bl2, bog2, (bgb<Object>)bgb2);
        }
        return null;
    }

    protected bgb<?> a(bgo bgo2, btu btu2, bfo bfo2, boolean bl2, bog bog2, bgb<Object> bgb2) {
        boolean bl3;
        Object object;
        bbr.a a2;
        bfw bfw2 = btu2.bfw_d();
        bbr.b b2 = this.a(bgo2, bfo2, bfw2, AtomicReference.class);
        bbr.a a3 = a2 = b2 == null ? bbr.a.g : b2.b();
        if (a2 == bbr.a.g || a2 == bbr.a.var_bbr$a_a) {
            object = null;
            bl3 = false;
        } else {
            bl3 = true;
            switch (a2) {
                case e: {
                    object = buh.java_lang_Object_a(bfw2);
                    if (object == null || !object.getClass().isArray()) break;
                    object = bue.a(object);
                    break;
                }
                case c: {
                    object = bfw2.a() != false ? bsl.var_java_lang_Object_a : null;
                    break;
                }
                case d: {
                    object = bsl.var_java_lang_Object_a;
                    break;
                }
                case f: {
                    object = bgo2.a((bmx)null, b2.b());
                    if (object == null) {
                        bl3 = true;
                        break;
                    }
                    bl3 = bgo2.boolean_a(object);
                    break;
                }
                default: {
                    object = null;
                }
            }
        }
        brs brs2 = new brs(btu2, bl2, bog2, bgb2);
        return brs2.a(object, bl3);
    }

    protected bgb<?> a(bgm bgm2, bfw bfw2, bfo bfo2, boolean bl2, bfw bfw3) {
        return new bqz(bfw3, bl2, this.a(bgm2, bfw3));
    }

    protected bgb<?> b(bgm bgm2, bfw bfw2, bfo bfo2, boolean bl2, bfw bfw3) {
        return new bsi(bfw3, bl2, this.a(bgm2, bfw3));
    }

    protected bgb<?> a(bgm bgm2, bfw bfw2, bfo bfo2) {
        bbk.d d2 = bfo2.a((bbk.d)null);
        if (d2.bbk$c_a() == bbk.c.e) {
            ((bmv)bfo2).a("declaringClass");
            return null;
        }
        Object t2 = bfw2.a();
        bgb bgb2 = bsd.a(t2, bgm2, bfo2, d2);
        if (this.var_bhp_a.b()) {
            for (bqf bqf2 : this.var_bhp_a.c()) {
                bgb2 = bqf2.a(bgm2, bfw2, bfo2, bgb2);
            }
        }
        return bgb2;
    }

    protected bgb<Object> b(bgo bgo2, bmg bmg2) {
        bfn bfn2 = bgo2.bfn_a();
        Object object = bfn2.java_lang_Object_c(bmg2);
        if (object != null) {
            return bgo2.a(bmg2, object);
        }
        return null;
    }

    protected bgb<Object> c(bgo bgo2, bmg bmg2) {
        bfn bfn2 = bgo2.bfn_a();
        Object object = bfn2.java_lang_Object_d(bmg2);
        if (object != null) {
            return bgo2.a(bmg2, object);
        }
        return null;
    }

    protected Object a(bgm bgm2, bfo bfo2) {
        return bgm2.bfn_a().java_lang_Object_a((bmg)bfo2.bmh_a());
    }

    protected boolean a(bgm bgm2, bfo bfo2, bog bog2) {
        if (bog2 != null) {
            return false;
        }
        bfn bfn2 = bgm2.bfn_a();
        bgu.b b2 = bfn2.bgu$b_a((bmg)bfo2.bmh_a());
        if (b2 != null && b2 != bgu.b.c) {
            return b2 == bgu.b.b;
        }
        return bgm2.a(bgd.p);
    }

    static {
        HashMap<String, Class<btj>> hashMap = new HashMap<String, Class<btj>>();
        HashMap hashMap2 = new HashMap();
        hashMap2.put(String.class.getName(), new btf());
        bth bth2 = bth.a;
        hashMap2.put(StringBuffer.class.getName(), bth2);
        hashMap2.put(StringBuilder.class.getName(), bth2);
        hashMap2.put(Character.class.getName(), bth2);
        hashMap2.put(Character.TYPE.getName(), bth2);
        bsq.a(hashMap2);
        hashMap2.put(Boolean.TYPE.getName(), new brv(true));
        hashMap2.put(Boolean.class.getName(), new brv(false));
        hashMap2.put(BigInteger.class.getName(), new bso((Class<? extends Number>)BigInteger.class));
        hashMap2.put(BigDecimal.class.getName(), new bso((Class<? extends Number>)BigDecimal.class));
        hashMap2.put(Calendar.class.getName(), bry.a);
        hashMap2.put(Date.class.getName(), bsb.a);
        for (Map.Entry<Class<?>, Object> entry : bta.a()) {
            Object object = entry.getValue();
            if (object instanceof bgb) {
                hashMap2.put(entry.getKey().getName(), (bgb)object);
                continue;
            }
            Class clazz = (Class)object;
            hashMap.put(entry.getKey().getName(), clazz);
        }
        hashMap.put(bve.class.getName(), btj.class);
        cfr_renamed_38 = hashMap2;
        b = hashMap;
    }
}

