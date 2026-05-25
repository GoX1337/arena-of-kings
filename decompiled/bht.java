/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class bht
extends bhv
implements Serializable {
    protected transient Exception var_java_lang_Exception_a;
    private volatile transient but var_but_a;

    public bht(bhw bhw2, bfo bfo2, biv biv2, Map<String, bio> map, HashSet<String> hashSet, boolean bl2, Set<String> set, boolean bl3) {
        super(bhw2, bfo2, biv2, map, hashSet, bl2, set, bl3);
    }

    protected bht(bhv bhv2) {
        super(bhv2, bhv2.c);
    }

    protected bht(bhv bhv2, boolean bl2) {
        super(bhv2, bl2);
    }

    protected bht(bhv bhv2, but but2) {
        super(bhv2, but2);
    }

    public bht(bhv bhv2, bjl bjl2) {
        super(bhv2, bjl2);
    }

    public bht(bhv bhv2, Set<String> set, Set<String> set2) {
        super(bhv2, set, set2);
    }

    public bht(bhv bhv2, biv biv2) {
        super(bhv2, biv2);
    }

    @Override
    public bfx<Object> a(but but2) {
        if (this.getClass() != bht.class) {
            return this;
        }
        if (this.var_but_a == but2) {
            return this;
        }
        this.var_but_a = but2;
        try {
            bht bht2 = new bht((bhv)this, but2);
            return bht2;
        }
        finally {
            this.var_but_a = null;
        }
    }

    @Override
    public bht a(bjl bjl2) {
        return new bht((bhv)this, bjl2);
    }

    @Override
    public bht a(Set<String> set, Set<String> set2) {
        return new bht(this, set, set2);
    }

    @Override
    public bhv a(boolean bl2) {
        return new bht((bhv)this, bl2);
    }

    @Override
    public bhv a(biv biv2) {
        return new bht((bhv)this, biv2);
    }

    @Override
    protected bhv bhv_a() {
        bio[] bioArray = ((biv)((Object)this.var_java_lang_Exception_a)).bio_arr_a();
        return new biu((bhv)this, bioArray);
    }

    @Override
    public Object a(bdc bdc2, bfs bfs2) {
        if (bdc2.boolean_d()) {
            if (this.b) {
                return this.b(bdc2, bfs2, bdc2.bdf_a());
            }
            bdc2.bdf_a();
            if (this.var_java_lang_Exception_a != null) {
                return this.j(bdc2, bfs2);
            }
            return this.b(bdc2, bfs2);
        }
        return this.a(bdc2, bfs2, bdc2.bdf_c());
    }

    @Override
    protected final Object a(bdc bdc2, bfs bfs2, bdf bdf2) {
        if (bdf2 != null) {
            switch (bdf2) {
                case h: {
                    return this.n(bdc2, bfs2);
                }
                case i: {
                    return this.m(bdc2, bfs2);
                }
                case j: {
                    return this.o(bdc2, bfs2);
                }
                case g: {
                    return this.q(bdc2, bfs2);
                }
                case k: 
                case l: {
                    return this.p(bdc2, bfs2);
                }
                case m: {
                    return this.d(bdc2, bfs2);
                }
                case var_bdf_d: {
                    return this.e(bdc2, bfs2);
                }
                case f: 
                case var_bdf_c: {
                    if (this.b) {
                        return this.b(bdc2, bfs2, bdf2);
                    }
                    if (this.var_java_lang_Exception_a != null) {
                        return this.j(bdc2, bfs2);
                    }
                    return this.b(bdc2, bfs2);
                }
            }
        }
        return bfs2.a(this.bfw_a(bfs2), bdc2);
    }

    @Override
    public Object a(bdc bdc2, bfs bfs2, Object object) {
        Serializable serializable;
        String string;
        bdc2.a(object);
        if (this.var_java_lang_Exception_a != null) {
            this.void_a(bfs2, object);
        }
        if (this.var_java_lang_Exception_a != null) {
            return this.b(bdc2, bfs2, object);
        }
        if (this.var_java_lang_Exception_a != null) {
            return this.c(bdc2, bfs2, object);
        }
        if (bdc2.boolean_d()) {
            string = bdc2.java_lang_String_a();
            if (string == null) {
                return object;
            }
        } else if (bdc2.boolean_a(5)) {
            string = bdc2.java_lang_String_d();
        } else {
            return object;
        }
        if (this.d && (serializable = bfs2.a()) != null) {
            return this.a(bdc2, bfs2, object, (Class<?>)serializable);
        }
        do {
            bdc2.bdf_a();
            serializable = ((biv)((Object)this.var_java_lang_Exception_a)).bio_a(string);
            if (serializable != null) {
                try {
                    ((bio)serializable).void_a(bdc2, bfs2, object);
                }
                catch (Exception exception) {
                    this.a(exception, object, string, bfs2);
                }
                continue;
            }
            this.a(bdc2, bfs2, object, string);
        } while ((string = bdc2.java_lang_String_a()) != null);
        return object;
    }

    private final Object b(bdc bdc2, bfs bfs2, bdf bdf2) {
        Object object = ((bir)((Object)this.var_java_lang_Exception_a)).a(bfs2);
        bdc2.a(object);
        if (bdc2.boolean_a(5)) {
            String string = bdc2.java_lang_String_d();
            do {
                bdc2.bdf_a();
                bio bio2 = ((biv)((Object)this.var_java_lang_Exception_a)).bio_a(string);
                if (bio2 != null) {
                    try {
                        bio2.void_a(bdc2, bfs2, object);
                    }
                    catch (Exception exception) {
                        this.a(exception, object, string, bfs2);
                    }
                    continue;
                }
                this.a(bdc2, bfs2, object, string);
            } while ((string = bdc2.java_lang_String_a()) != null);
        }
        return object;
    }

    @Override
    public Object b(bdc bdc2, bfs bfs2) {
        Object object;
        if (this.var_java_lang_Exception_a != null && ((bjl)((Object)this.var_java_lang_Exception_a)).boolean_a() && bdc2.boolean_a(5) && ((bjl)((Object)this.var_java_lang_Exception_a)).a(bdc2.java_lang_String_d(), bdc2)) {
            return this.k(bdc2, bfs2);
        }
        if (this.var_java_lang_Exception_a != false) {
            if (this.var_java_lang_Exception_a != null) {
                return this.f(bdc2, bfs2);
            }
            if (this.var_java_lang_Exception_a != null) {
                return this.h(bdc2, bfs2);
            }
            Object object2 = this.l(bdc2, bfs2);
            return object2;
        }
        Object object3 = ((bir)((Object)this.var_java_lang_Exception_a)).a(bfs2);
        bdc2.a(object3);
        if (bdc2.boolean_h() && (object = bdc2.java_lang_Object_b()) != null) {
            this.a(bdc2, bfs2, object3, object);
        }
        if (this.var_java_lang_Exception_a != null) {
            this.void_a(bfs2, object3);
        }
        if (this.d && (object = bfs2.a()) != null) {
            return this.a(bdc2, bfs2, object3, (Class<?>)object);
        }
        if (bdc2.boolean_a(5)) {
            object = bdc2.java_lang_String_d();
            do {
                bdc2.bdf_a();
                bio bio2 = ((biv)((Object)this.var_java_lang_Exception_a)).bio_a((String)object);
                if (bio2 != null) {
                    try {
                        bio2.void_a(bdc2, bfs2, object3);
                    }
                    catch (Exception exception) {
                        this.a(exception, object3, (String)object, bfs2);
                    }
                    continue;
                }
                this.a(bdc2, bfs2, object3, (String)object);
            } while ((object = bdc2.java_lang_String_a()) != null);
        }
        return object3;
    }

    @Override
    protected Object c(bdc bdc2, bfs bfs2) {
        Object object;
        Exception exception = this.var_java_lang_Exception_a;
        bjr bjr2 = ((bjo)((Object)exception)).a(bdc2, bfs2, (bjl)((Object)this.var_java_lang_Exception_a));
        bve bve2 = null;
        Class<?> clazz = this.d ? bfs2.a() : null;
        bdf bdf2 = bdc2.bdf_c();
        ArrayList<a> arrayList = null;
        while (bdf2 == bdf.f) {
            object = bdc2.java_lang_String_d();
            bdc2.bdf_a();
            bio bio2 = ((bjo)((Object)exception)).a((String)object);
            if (!bjr2.a((String)object) || bio2 != null) {
                if (bio2 != null) {
                    if (clazz != null && !bio2.a(clazz)) {
                        bdc2.bdc_a();
                    } else {
                        Object object2 = this.a(bdc2, bfs2, bio2);
                        if (bjr2.boolean_a(bio2, object2)) {
                            Object object3;
                            bdc2.bdf_a();
                            try {
                                object3 = ((bjo)((Object)exception)).a(bfs2, bjr2);
                            }
                            catch (Exception exception2) {
                                object3 = this.java_lang_Object_a(exception2, bfs2);
                            }
                            if (object3 == null) {
                                return bfs2.a(this.a(), null, this.java_lang_Exception_a());
                            }
                            bdc2.a(object3);
                            if (object3.getClass() != ((bfw)((Object)this.var_java_lang_Exception_a)).a()) {
                                return this.a(bdc2, bfs2, object3, bve2);
                            }
                            if (bve2 != null) {
                                object3 = this.a(bfs2, object3, bve2);
                            }
                            return this.a(bdc2, bfs2, object3);
                        }
                    }
                } else {
                    bio bio3 = ((biv)((Object)this.var_java_lang_Exception_a)).bio_a((String)object);
                    if (bio3 != null) {
                        try {
                            bjr2.void_a(bio3, this.a(bdc2, bfs2, bio3));
                        }
                        catch (bip bip2) {
                            a a2 = this.a(bfs2, bio3, bjr2, bip2);
                            if (arrayList == null) {
                                arrayList = new ArrayList<a>();
                            }
                            arrayList.add(a2);
                        }
                    } else if (bup.a(object, (Collection<String>)((Object)this.var_java_lang_Exception_a), this.b)) {
                        this.c(bdc2, bfs2, this.a(), (String)object);
                    } else if (this.var_java_lang_Exception_a != null) {
                        try {
                            bjr2.a((bin)((Object)this.var_java_lang_Exception_a), (String)object, ((bin)((Object)this.var_java_lang_Exception_a)).a(bdc2, bfs2));
                        }
                        catch (Exception exception3) {
                            this.a(exception3, ((bfw)((Object)this.var_java_lang_Exception_a)).a(), (String)object, bfs2);
                        }
                    } else {
                        if (bve2 == null) {
                            bve2 = new bve(bdc2, bfs2);
                        }
                        bve2.a((String)object);
                        bve2.b(bdc2);
                    }
                }
            }
            bdf2 = bdc2.bdf_a();
        }
        try {
            object = ((bjo)((Object)exception)).a(bfs2, bjr2);
        }
        catch (Exception exception4) {
            this.java_lang_Object_a(exception4, bfs2);
            object = null;
        }
        if (this.var_java_lang_Exception_a != null) {
            this.void_a(bfs2, object);
        }
        if (arrayList != null) {
            for (a a3 : arrayList) {
                a3.void_a(object);
            }
        }
        if (bve2 != null) {
            if (object.getClass() != ((bfw)((Object)this.var_java_lang_Exception_a)).a()) {
                return this.a(null, bfs2, object, bve2);
            }
            return this.a(bfs2, object, bve2);
        }
        return object;
    }

    private a a(bfs bfs2, bio bio2, bjr bjr2, bip bip2) {
        a a2 = new a(bfs2, bip2, bio2.bfw_a(), bjr2, bio2);
        bip2.bjs_a().a(a2);
        return a2;
    }

    @Override
    protected final Object a(bdc bdc2, bfs bfs2, bio bio2) {
        try {
            return bio2.java_lang_Object_a(bdc2, bfs2);
        }
        catch (Exception exception) {
            this.a(exception, ((bfw)((Object)this.var_java_lang_Exception_a)).a(), bio2.java_lang_String_a(), bfs2);
            return null;
        }
    }

    protected Object d(bdc bdc2, bfs bfs2) {
        if (bdc2.boolean_a()) {
            bve bve2 = new bve(bdc2, bfs2);
            bve2.void_d();
            bdc bdc3 = bve2.bdc_a(bdc2);
            bdc3.bdf_a();
            Object object = this.b ? this.b(bdc3, bfs2, bdf.var_bdf_c) : this.b(bdc3, bfs2);
            bdc3.close();
            return object;
        }
        return bfs2.a(this.bfw_a(bfs2), bdc2);
    }

    @Override
    protected Object e(bdc bdc2, bfs bfs2) {
        Object object = this.b;
        if (object != null || (object = this.var_java_lang_Exception_a) != null) {
            Object object2 = ((bir)((Object)this.var_java_lang_Exception_a)).b(bfs2, ((bfx)object).a(bdc2, bfs2));
            if (this.var_java_lang_Exception_a != null) {
                this.void_a(bfs2, object2);
            }
            return object2;
        }
        bha bha2 = this.bha_b(bfs2);
        boolean bl2 = bfs2.a(bfu.r);
        if (bl2 || bha2 != bha.var_bha_a) {
            bdf bdf2 = bdc2.bdf_a();
            if (bdf2 == bdf.var_bdf_e) {
                switch (bha2) {
                    case d: {
                        return this.b(bfs2);
                    }
                    case c: 
                    case b: {
                        return this.a(bfs2);
                    }
                }
                return bfs2.a(this.bfw_a(bfs2), bdf.var_bdf_d, bdc2, null, new Object[0]);
            }
            if (bl2) {
                Object object3 = this.a(bdc2, bfs2);
                if (bdc2.bdf_a() != bdf.var_bdf_e) {
                    this.void_a(bdc2, bfs2);
                }
                return object3;
            }
        }
        return bfs2.a(this.bfw_a(bfs2), bdc2);
    }

    protected final Object a(bdc bdc2, bfs bfs2, Object object, Class<?> clazz) {
        if (bdc2.boolean_a(5)) {
            String string = bdc2.java_lang_String_d();
            do {
                bdc2.bdf_a();
                bio bio2 = ((biv)((Object)this.var_java_lang_Exception_a)).bio_a(string);
                if (bio2 != null) {
                    if (!bio2.a(clazz)) {
                        bdc2.bdc_a();
                        continue;
                    }
                    try {
                        bio2.void_a(bdc2, bfs2, object);
                    }
                    catch (Exception exception) {
                        this.a(exception, object, string, bfs2);
                    }
                    continue;
                }
                this.a(bdc2, bfs2, object, string);
            } while ((string = bdc2.java_lang_String_a()) != null);
        }
        return object;
    }

    protected Object f(bdc bdc2, bfs bfs2) {
        String string;
        if (this.var_java_lang_Exception_a != null) {
            return ((bir)((Object)this.var_java_lang_Exception_a)).a(bfs2, ((bfx)((Object)this.var_java_lang_Exception_a)).a(bdc2, bfs2));
        }
        if (this.var_java_lang_Exception_a != null) {
            return this.g(bdc2, bfs2);
        }
        bve bve2 = new bve(bdc2, bfs2);
        bve2.void_c();
        Object object = ((bir)((Object)this.var_java_lang_Exception_a)).a(bfs2);
        bdc2.a(object);
        if (this.var_java_lang_Exception_a != null) {
            this.void_a(bfs2, object);
        }
        Class<?> clazz = this.d ? bfs2.a() : null;
        String string2 = string = bdc2.boolean_a(5) ? bdc2.java_lang_String_d() : null;
        while (string != null) {
            bdc2.bdf_a();
            bio bio2 = ((biv)((Object)this.var_java_lang_Exception_a)).bio_a(string);
            if (bio2 != null) {
                if (clazz != null && !bio2.a(clazz)) {
                    bdc2.bdc_a();
                } else {
                    try {
                        bio2.void_a(bdc2, bfs2, object);
                    }
                    catch (Exception exception) {
                        this.a(exception, object, string, bfs2);
                    }
                }
            } else if (bup.a(string, (Collection<String>)((Object)this.var_java_lang_Exception_a), this.b)) {
                this.c(bdc2, bfs2, object, string);
            } else if (this.var_java_lang_Exception_a == null) {
                bve2.a(string);
                bve2.b(bdc2);
            } else {
                bve bve3 = bve.bve_a(bdc2);
                bve2.a(string);
                bve2.a(bve3);
                try {
                    ((bin)((Object)this.var_java_lang_Exception_a)).a(bve3.bdc_b(), bfs2, object, string);
                }
                catch (Exception exception) {
                    this.a(exception, object, string, bfs2);
                }
            }
            string = bdc2.java_lang_String_a();
        }
        bve2.void_d();
        ((bjw)((Object)this.var_java_lang_Exception_a)).a(bdc2, bfs2, object, bve2);
        return object;
    }

    protected Object b(bdc bdc2, bfs bfs2, Object object) {
        Class<?> clazz;
        bdf bdf2 = bdc2.bdf_c();
        if (bdf2 == bdf.var_bdf_b) {
            bdf2 = bdc2.bdf_a();
        }
        bve bve2 = new bve(bdc2, bfs2);
        bve2.void_c();
        Class<?> clazz2 = clazz = this.d ? bfs2.a() : null;
        while (bdf2 == bdf.f) {
            String string = bdc2.java_lang_String_d();
            bio bio2 = ((biv)((Object)this.var_java_lang_Exception_a)).bio_a(string);
            bdc2.bdf_a();
            if (bio2 != null) {
                if (clazz != null && !bio2.a(clazz)) {
                    bdc2.bdc_a();
                } else {
                    try {
                        bio2.void_a(bdc2, bfs2, object);
                    }
                    catch (Exception exception) {
                        this.a(exception, object, string, bfs2);
                    }
                }
            } else if (bup.a(string, (Collection<String>)((Object)this.var_java_lang_Exception_a), this.b)) {
                this.c(bdc2, bfs2, object, string);
            } else if (this.var_java_lang_Exception_a == null) {
                bve2.a(string);
                bve2.b(bdc2);
            } else {
                bve bve3 = bve.bve_a(bdc2);
                bve2.a(string);
                bve2.a(bve3);
                try {
                    ((bin)((Object)this.var_java_lang_Exception_a)).a(bve3.bdc_b(), bfs2, object, string);
                }
                catch (Exception exception) {
                    this.a(exception, object, string, bfs2);
                }
            }
            bdf2 = bdc2.bdf_a();
        }
        bve2.void_d();
        ((bjw)((Object)this.var_java_lang_Exception_a)).a(bdc2, bfs2, object, bve2);
        return object;
    }

    protected Object g(bdc bdc2, bfs bfs2) {
        Object object;
        Exception exception = this.var_java_lang_Exception_a;
        bjr bjr2 = ((bjo)((Object)exception)).a(bdc2, bfs2, (bjl)((Object)this.var_java_lang_Exception_a));
        bve bve2 = new bve(bdc2, bfs2);
        bve2.void_c();
        bdf bdf2 = bdc2.bdf_c();
        while (bdf2 == bdf.f) {
            object = bdc2.java_lang_String_d();
            bdc2.bdf_a();
            bio bio2 = ((bjo)((Object)exception)).a((String)object);
            if (!bjr2.a((String)object) || bio2 != null) {
                Object object2;
                if (bio2 != null) {
                    if (bjr2.boolean_a(bio2, this.a(bdc2, bfs2, bio2))) {
                        bdf2 = bdc2.bdf_a();
                        try {
                            object2 = ((bjo)((Object)exception)).a(bfs2, bjr2);
                        }
                        catch (Exception exception2) {
                            object2 = this.java_lang_Object_a(exception2, bfs2);
                        }
                        bdc2.a(object2);
                        while (bdf2 == bdf.f) {
                            bve2.b(bdc2);
                            bdf2 = bdc2.bdf_a();
                        }
                        if (bdf2 != bdf.var_bdf_c) {
                            bfs2.a(this, bdf.var_bdf_c, "Attempted to unwrap '%s' value", this.a().getName());
                        }
                        bve2.void_d();
                        if (object2.getClass() != ((bfw)((Object)this.var_java_lang_Exception_a)).a()) {
                            bfs2.a(bio2, "Cannot create polymorphic instances with unwrapped values", new Object[0]);
                            return null;
                        }
                        return ((bjw)((Object)this.var_java_lang_Exception_a)).a(bdc2, bfs2, object2, bve2);
                    }
                } else {
                    object2 = ((biv)((Object)this.var_java_lang_Exception_a)).bio_a((String)object);
                    if (object2 != null) {
                        bjr2.void_a((bio)object2, this.a(bdc2, bfs2, (bio)object2));
                    } else if (bup.a(object, (Collection<String>)((Object)this.var_java_lang_Exception_a), this.b)) {
                        this.c(bdc2, bfs2, this.a(), (String)object);
                    } else if (this.var_java_lang_Exception_a == null) {
                        bve2.a((String)object);
                        bve2.b(bdc2);
                    } else {
                        bve bve3 = bve.bve_a(bdc2);
                        bve2.a((String)object);
                        bve2.a(bve3);
                        try {
                            bjr2.a((bin)((Object)this.var_java_lang_Exception_a), (String)object, ((bin)((Object)this.var_java_lang_Exception_a)).a(bve3.bdc_b(), bfs2));
                        }
                        catch (Exception exception3) {
                            this.a(exception3, ((bfw)((Object)this.var_java_lang_Exception_a)).a(), (String)object, bfs2);
                        }
                    }
                }
            }
            bdf2 = bdc2.bdf_a();
        }
        try {
            object = ((bjo)((Object)exception)).a(bfs2, bjr2);
        }
        catch (Exception exception4) {
            this.java_lang_Object_a(exception4, bfs2);
            return null;
        }
        return ((bjw)((Object)this.var_java_lang_Exception_a)).a(bdc2, bfs2, object, bve2);
    }

    protected Object h(bdc bdc2, bfs bfs2) {
        if (this.var_java_lang_Exception_a != null) {
            return this.i(bdc2, bfs2);
        }
        if (this.var_java_lang_Exception_a != null) {
            return ((bir)((Object)this.var_java_lang_Exception_a)).a(bfs2, ((bfx)((Object)this.var_java_lang_Exception_a)).a(bdc2, bfs2));
        }
        return this.c(bdc2, bfs2, ((bir)((Object)this.var_java_lang_Exception_a)).a(bfs2));
    }

    protected Object c(bdc bdc2, bfs bfs2, Object object) {
        return this.a(bdc2, bfs2, object, ((biz)((Object)this.var_java_lang_Exception_a)).a());
    }

    protected Object a(bdc bdc2, bfs bfs2, Object object, biz biz2) {
        Class<?> clazz = this.d ? bfs2.a() : null;
        bdf bdf2 = bdc2.bdf_c();
        while (bdf2 == bdf.f) {
            String string = bdc2.java_lang_String_d();
            bdf2 = bdc2.bdf_a();
            bio bio2 = ((biv)((Object)this.var_java_lang_Exception_a)).bio_a(string);
            if (bio2 != null) {
                if (bdf2.d()) {
                    biz2.a(bdc2, bfs2, string, object);
                }
                if (clazz != null && !bio2.a(clazz)) {
                    bdc2.bdc_a();
                } else {
                    try {
                        bio2.void_a(bdc2, bfs2, object);
                    }
                    catch (Exception exception) {
                        this.a(exception, object, string, bfs2);
                    }
                }
            } else if (bup.a(string, (Collection<String>)((Object)this.var_java_lang_Exception_a), this.b)) {
                this.c(bdc2, bfs2, object, string);
            } else if (!biz2.b(bdc2, bfs2, string, object)) {
                if (this.var_java_lang_Exception_a != null) {
                    try {
                        ((bin)((Object)this.var_java_lang_Exception_a)).a(bdc2, bfs2, object, string);
                    }
                    catch (Exception exception) {
                        this.a(exception, object, string, bfs2);
                    }
                } else {
                    this.b(bdc2, bfs2, object, string);
                }
            }
            bdf2 = bdc2.bdf_a();
        }
        return biz2.a(bdc2, bfs2, object);
    }

    protected Object i(bdc bdc2, bfs bfs2) {
        biz biz2 = ((biz)((Object)this.var_java_lang_Exception_a)).a();
        Exception exception = this.var_java_lang_Exception_a;
        bjr bjr2 = ((bjo)((Object)exception)).a(bdc2, bfs2, (bjl)((Object)this.var_java_lang_Exception_a));
        Class<?> clazz = this.d ? bfs2.a() : null;
        bdf bdf2 = bdc2.bdf_c();
        while (bdf2 == bdf.f) {
            block20: {
                String string = bdc2.java_lang_String_d();
                bdf2 = bdc2.bdf_a();
                bio bio2 = ((bjo)((Object)exception)).a(string);
                if (!bjr2.a(string) || bio2 != null) {
                    Object object;
                    if (bio2 != null) {
                        if (!biz2.b(bdc2, bfs2, string, null) && bjr2.boolean_a(bio2, this.a(bdc2, bfs2, bio2))) {
                            bdf2 = bdc2.bdf_a();
                            try {
                                object = ((bjo)((Object)exception)).a(bfs2, bjr2);
                            }
                            catch (Exception exception2) {
                                this.a(exception2, ((bfw)((Object)this.var_java_lang_Exception_a)).a(), string, bfs2);
                                break block20;
                            }
                            if (object.getClass() != ((bfw)((Object)this.var_java_lang_Exception_a)).a()) {
                                return bfs2.b((bfw)((Object)this.var_java_lang_Exception_a), String.format("Cannot create polymorphic instances with external type ids (%s -> %s)", this.var_java_lang_Exception_a, object.getClass()));
                            }
                            return this.a(bdc2, bfs2, object, biz2);
                        }
                    } else {
                        object = ((biv)((Object)this.var_java_lang_Exception_a)).bio_a(string);
                        if (object != null) {
                            if (bdf2.d()) {
                                biz2.a(bdc2, bfs2, string, null);
                            }
                            if (clazz != null && !((bio)object).a(clazz)) {
                                bdc2.bdc_a();
                            } else {
                                bjr2.void_a((bio)object, ((bio)object).java_lang_Object_a(bdc2, bfs2));
                            }
                        } else if (!biz2.b(bdc2, bfs2, string, null)) {
                            if (bup.a(string, (Collection<String>)((Object)this.var_java_lang_Exception_a), this.b)) {
                                this.c(bdc2, bfs2, this.a(), string);
                            } else if (this.var_java_lang_Exception_a != null) {
                                bjr2.a((bin)((Object)this.var_java_lang_Exception_a), string, ((bin)((Object)this.var_java_lang_Exception_a)).a(bdc2, bfs2));
                            } else {
                                this.b(bdc2, bfs2, this.b, string);
                            }
                        }
                    }
                }
            }
            bdf2 = bdc2.bdf_a();
        }
        try {
            return biz2.a(bdc2, bfs2, bjr2, (bjo)((Object)exception));
        }
        catch (Exception exception3) {
            return this.java_lang_Object_a(exception3, bfs2);
        }
    }

    @Override
    protected Exception java_lang_Exception_a() {
        if (this.var_java_lang_Exception_a == null) {
            this.var_java_lang_Exception_a = new NullPointerException("JSON Creator returned null");
        }
        return this.var_java_lang_Exception_a;
    }

    static class a
    extends bjs.a {
        private final bfs var_bfs_a;
        private final bio var_bio_a;
        private Object var_java_lang_Object_a;

        a(bfs bfs2, bip bip2, bfw bfw2, bjr bjr2, bio bio2) {
            super(bip2, bfw2);
            this.var_bfs_a = bfs2;
            this.var_bio_a = bio2;
        }

        public void void_a(Object object) {
            this.var_java_lang_Object_a = object;
        }

        @Override
        public void a(Object object, Object object2) {
            if (this.var_java_lang_Object_a == null) {
                this.var_bfs_a.a(this.var_bio_a, "Cannot resolve ObjectId forward reference using property '%s' (of type %s): Bean not yet resolved", this.var_bio_a.java_lang_String_a(), ((Class)this.var_bio_a.java_lang_Object_a()).getName());
            }
            this.var_bio_a.void_a(this.var_java_lang_Object_a, object2);
        }
    }
}

