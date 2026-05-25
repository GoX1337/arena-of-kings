/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class bhz
extends bhv {
    protected final bmo a;
    protected final bfw b;

    public bhz(bhw bhw2, bfo bfo2, bfw bfw2, biv biv2, Map<String, bio> map, Set<String> set, boolean bl2, Set<String> set2, boolean bl3) {
        super(bhw2, bfo2, biv2, map, set, bl2, set2, bl3);
        this.b = bfw2;
        this.a = bhw2.bmo_a();
        if (this.a != null) {
            throw new IllegalArgumentException("Cannot use Object Id with Builder-based deserialization (type " + bfo2.bfw_a() + ")");
        }
    }

    protected bhz(bhz bhz2, boolean bl2) {
        super((bhv)bhz2, bl2);
        this.a = bhz2.a;
        this.b = bhz2.b;
    }

    protected bhz(bhz bhz2, but but2) {
        super((bhv)bhz2, but2);
        this.a = bhz2.a;
        this.b = bhz2.b;
    }

    public bhz(bhz bhz2, bjl bjl2) {
        super((bhv)bhz2, bjl2);
        this.a = bhz2.a;
        this.b = bhz2.b;
    }

    public bhz(bhz bhz2, Set<String> set, Set<String> set2) {
        super(bhz2, set, set2);
        this.a = bhz2.a;
        this.b = bhz2.b;
    }

    public bhz(bhz bhz2, biv biv2) {
        super((bhv)bhz2, biv2);
        this.a = bhz2.a;
        this.b = bhz2.b;
    }

    @Override
    public bfx<Object> a(but but2) {
        return new bhz(this, but2);
    }

    @Override
    public bhv a(bjl bjl2) {
        return new bhz(this, bjl2);
    }

    @Override
    public bhv a(Set<String> set, Set<String> set2) {
        return new bhz(this, set, set2);
    }

    @Override
    public bhv a(boolean bl2) {
        return new bhz(this, bl2);
    }

    @Override
    public bhv a(biv biv2) {
        return new bhz(this, biv2);
    }

    @Override
    protected bhv bhv_a() {
        bio[] bioArray = ((biv)((Object)this.a)).bio_arr_a();
        return new bit(this, this.b, bioArray, this.a);
    }

    @Override
    public Boolean a(bfr bfr2) {
        return Boolean.FALSE;
    }

    protected Object java_lang_Object_a(bfs bfs2, Object object) {
        if (null == this.a) {
            return object;
        }
        try {
            return this.a.java_lang_reflect_Method_b().invoke(object, (Object[])null);
        }
        catch (Exception exception) {
            return this.java_lang_Object_a(exception, bfs2);
        }
    }

    @Override
    public Object a(bdc bdc2, bfs bfs2) {
        if (bdc2.boolean_d()) {
            bdf bdf2 = bdc2.bdf_a();
            if (this.b != false) {
                return this.java_lang_Object_a(bfs2, this.a(bdc2, bfs2, bdf2));
            }
            return this.java_lang_Object_a(bfs2, this.b(bdc2, bfs2));
        }
        switch (bdc2.int_a()) {
            case 6: {
                return this.java_lang_Object_a(bfs2, this.n(bdc2, bfs2));
            }
            case 7: {
                return this.java_lang_Object_a(bfs2, this.m(bdc2, bfs2));
            }
            case 8: {
                return this.java_lang_Object_a(bfs2, this.o(bdc2, bfs2));
            }
            case 12: {
                return bdc2.java_lang_Object_a();
            }
            case 9: 
            case 10: {
                return this.java_lang_Object_a(bfs2, this.p(bdc2, bfs2));
            }
            case 3: {
                return this.e(bdc2, bfs2);
            }
            case 2: 
            case 5: {
                return this.java_lang_Object_a(bfs2, this.b(bdc2, bfs2));
            }
        }
        return bfs2.a(this.bfw_a(bfs2), bdc2);
    }

    @Override
    public Object a(bdc bdc2, bfs bfs2, Object object) {
        Class<?> clazz;
        bfw bfw2 = this.b;
        Class<?> clazz2 = this.a();
        if (clazz2.isAssignableFrom(clazz = object.getClass())) {
            return bfs2.b(bfw2, String.format("Deserialization of %s by passing existing Builder (%s) instance not supported", bfw2, clazz2.getName()));
        }
        return bfs2.b(bfw2, String.format("Deserialization of %s by passing existing instance (of %s) not supported", bfw2, clazz.getName()));
    }

    @Override
    private final Object a(bdc bdc2, bfs bfs2, bdf bdf2) {
        Object object = ((bir)((Object)this.a)).a(bfs2);
        while (bdc2.bdf_c() == bdf.f) {
            String string = bdc2.java_lang_String_d();
            bdc2.bdf_a();
            bio bio2 = ((biv)((Object)this.a)).bio_a(string);
            if (bio2 != null) {
                try {
                    object = bio2.java_lang_Object_a(bdc2, bfs2, object);
                }
                catch (Exception exception) {
                    this.a(exception, object, string, bfs2);
                }
            } else {
                this.a(bdc2, bfs2, object, string);
            }
            bdc2.bdf_a();
        }
        return object;
    }

    @Override
    public Object b(bdc bdc2, bfs bfs2) {
        Object object;
        if (this.a != false) {
            if (this.a != null) {
                return this.d(bdc2, bfs2);
            }
            if (this.a != null) {
                return this.g(bdc2, bfs2);
            }
            return this.l(bdc2, bfs2);
        }
        Object object2 = ((bir)((Object)this.a)).a(bfs2);
        if (this.a != null) {
            this.void_a(bfs2, object2);
        }
        if (this.d && (object = bfs2.a()) != null) {
            return this.a(bdc2, bfs2, object2, (Class<?>)object);
        }
        while (bdc2.bdf_c() == bdf.f) {
            object = bdc2.java_lang_String_d();
            bdc2.bdf_a();
            bio bio2 = ((biv)((Object)this.a)).bio_a((String)object);
            if (bio2 != null) {
                try {
                    object2 = bio2.java_lang_Object_a(bdc2, bfs2, object2);
                }
                catch (Exception exception) {
                    this.a(exception, object2, (String)object, bfs2);
                }
            } else {
                this.a(bdc2, bfs2, object2, (String)object);
            }
            bdc2.bdf_a();
        }
        return object2;
    }

    @Override
    protected Object c(bdc bdc2, bfs bfs2) {
        Object object;
        bmo bmo2 = this.a;
        bjr bjr2 = ((bjo)((Object)bmo2)).a(bdc2, bfs2, (bjl)((Object)this.a));
        Class<?> clazz = this.d ? bfs2.a() : null;
        bve bve2 = null;
        bdf bdf2 = bdc2.bdf_c();
        while (bdf2 == bdf.f) {
            block22: {
                object = bdc2.java_lang_String_d();
                bdc2.bdf_a();
                bio bio2 = ((bjo)((Object)bmo2)).a((String)object);
                if (!bjr2.a((String)object) || bio2 != null) {
                    Object object2;
                    if (bio2 != null) {
                        if (clazz != null && !bio2.a(clazz)) {
                            bdc2.bdc_a();
                        } else if (bjr2.boolean_a(bio2, bio2.java_lang_Object_a(bdc2, bfs2))) {
                            bdc2.bdf_a();
                            try {
                                object2 = ((bjo)((Object)bmo2)).a(bfs2, bjr2);
                            }
                            catch (Exception exception) {
                                this.a(exception, ((bfw)((Object)this.a)).a(), (String)object, bfs2);
                                break block22;
                            }
                            if (object2.getClass() != ((bfw)((Object)this.a)).a()) {
                                return this.a(bdc2, bfs2, object2, bve2);
                            }
                            if (bve2 != null) {
                                object2 = this.a(bfs2, object2, bve2);
                            }
                            return this.b(bdc2, bfs2, object2);
                        }
                    } else {
                        object2 = ((biv)((Object)this.a)).bio_a((String)object);
                        if (object2 != null) {
                            bjr2.void_a((bio)object2, ((bio)object2).java_lang_Object_a(bdc2, bfs2));
                        } else if (bup.a(object, (Collection<String>)((Object)this.a), (Collection<String>)((Object)this.b))) {
                            this.c(bdc2, bfs2, this.a(), (String)object);
                        } else if (this.a != null) {
                            bjr2.a((bin)((Object)this.a), (String)object, ((bin)((Object)this.a)).a(bdc2, bfs2));
                        } else {
                            if (bve2 == null) {
                                bve2 = new bve(bdc2, bfs2);
                            }
                            bve2.a((String)object);
                            bve2.b(bdc2);
                        }
                    }
                }
            }
            bdf2 = bdc2.bdf_a();
        }
        try {
            object = ((bjo)((Object)bmo2)).a(bfs2, bjr2);
        }
        catch (Exception exception) {
            object = this.java_lang_Object_a(exception, bfs2);
        }
        if (bve2 != null) {
            if (object.getClass() != ((bfw)((Object)this.a)).a()) {
                return this.a(null, bfs2, object, bve2);
            }
            return this.a(bfs2, object, bve2);
        }
        return object;
    }

    protected final Object b(bdc bdc2, bfs bfs2, Object object) {
        Object object2;
        if (this.a != null) {
            this.void_a(bfs2, object);
        }
        if (this.a != null) {
            if (bdc2.boolean_a(bdf.var_bdf_b)) {
                bdc2.bdf_a();
            }
            bve bve2 = new bve(bdc2, bfs2);
            bve2.void_c();
            return this.b(bdc2, bfs2, object, bve2);
        }
        if (this.a != null) {
            return this.c(bdc2, bfs2, object);
        }
        if (this.d && (object2 = bfs2.a()) != null) {
            return this.a(bdc2, bfs2, object, (Class<?>)object2);
        }
        object2 = bdc2.bdf_c();
        if (object2 == bdf.var_bdf_b) {
            object2 = bdc2.bdf_a();
        }
        while (object2 == bdf.f) {
            String string = bdc2.java_lang_String_d();
            bdc2.bdf_a();
            bio bio2 = ((biv)((Object)this.a)).bio_a(string);
            if (bio2 != null) {
                try {
                    object = bio2.java_lang_Object_a(bdc2, bfs2, object);
                }
                catch (Exception exception) {
                    this.a(exception, object, string, bfs2);
                }
            } else {
                this.a(bdc2, bfs2, object, string);
            }
            object2 = bdc2.bdf_a();
        }
        return object;
    }

    @Override
    protected Object e(bdc bdc2, bfs bfs2) {
        Serializable serializable = this.b;
        if (serializable != null || (serializable = this.a) != null) {
            Object object = ((bir)((Object)this.a)).b(bfs2, ((bfx)((Object)serializable)).a(bdc2, bfs2));
            if (this.a != null) {
                this.void_a(bfs2, object);
            }
            return this.java_lang_Object_a(bfs2, object);
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
                Object object = this.a(bdc2, bfs2);
                if (bdc2.bdf_a() != bdf.var_bdf_e) {
                    this.void_a(bdc2, bfs2);
                }
                return object;
            }
        }
        return bfs2.a(this.bfw_a(bfs2), bdc2);
    }

    protected final Object a(bdc bdc2, bfs bfs2, Object object, Class<?> clazz) {
        bdf bdf2 = bdc2.bdf_c();
        while (bdf2 == bdf.f) {
            String string = bdc2.java_lang_String_d();
            bdc2.bdf_a();
            bio bio2 = ((biv)((Object)this.a)).bio_a(string);
            if (bio2 != null) {
                if (!bio2.a(clazz)) {
                    bdc2.bdc_a();
                } else {
                    try {
                        object = bio2.java_lang_Object_a(bdc2, bfs2, object);
                    }
                    catch (Exception exception) {
                        this.a(exception, object, string, bfs2);
                    }
                }
            } else {
                this.a(bdc2, bfs2, object, string);
            }
            bdf2 = bdc2.bdf_a();
        }
        return object;
    }

    protected Object d(bdc bdc2, bfs bfs2) {
        Class<?> clazz;
        if (this.a != null) {
            return ((bir)((Object)this.a)).a(bfs2, ((bfx)((Object)this.a)).a(bdc2, bfs2));
        }
        if (this.a != null) {
            return this.f(bdc2, bfs2);
        }
        bve bve2 = new bve(bdc2, bfs2);
        bve2.void_c();
        Object object = ((bir)((Object)this.a)).a(bfs2);
        if (this.a != null) {
            this.void_a(bfs2, object);
        }
        Class<?> clazz2 = clazz = this.d ? bfs2.a() : null;
        while (bdc2.bdf_c() == bdf.f) {
            String string = bdc2.java_lang_String_d();
            bdc2.bdf_a();
            bio bio2 = ((biv)((Object)this.a)).bio_a(string);
            if (bio2 != null) {
                if (clazz != null && !bio2.a(clazz)) {
                    bdc2.bdc_a();
                } else {
                    try {
                        object = bio2.java_lang_Object_a(bdc2, bfs2, object);
                    }
                    catch (Exception exception) {
                        this.a(exception, object, string, bfs2);
                    }
                }
            } else if (bup.a(string, (Collection<String>)((Object)this.a), (Collection<String>)((Object)this.b))) {
                this.c(bdc2, bfs2, object, string);
            } else {
                bve2.a(string);
                bve2.b(bdc2);
                if (this.a != null) {
                    try {
                        ((bin)((Object)this.a)).a(bdc2, bfs2, object, string);
                    }
                    catch (Exception exception) {
                        this.a(exception, object, string, bfs2);
                    }
                }
            }
            bdc2.bdf_a();
        }
        bve2.void_d();
        return ((bjw)((Object)this.a)).a(bdc2, bfs2, object, bve2);
    }

    protected Object f(bdc bdc2, bfs bfs2) {
        bmo bmo2 = this.a;
        bjr bjr2 = ((bjo)((Object)bmo2)).a(bdc2, bfs2, (bjl)((Object)this.a));
        bve bve2 = new bve(bdc2, bfs2);
        bve2.void_c();
        Object object = null;
        bdf bdf2 = bdc2.bdf_c();
        while (bdf2 == bdf.f) {
            block16: {
                String string = bdc2.java_lang_String_d();
                bdc2.bdf_a();
                bio bio2 = ((bjo)((Object)bmo2)).a(string);
                if (!bjr2.a(string) || bio2 != null) {
                    if (bio2 != null) {
                        if (bjr2.boolean_a(bio2, bio2.java_lang_Object_a(bdc2, bfs2))) {
                            bdf2 = bdc2.bdf_a();
                            try {
                                object = ((bjo)((Object)bmo2)).a(bfs2, bjr2);
                            }
                            catch (Exception exception) {
                                this.a(exception, ((bfw)((Object)this.a)).a(), string, bfs2);
                                break block16;
                            }
                            if (object.getClass() != ((bfw)((Object)this.a)).a()) {
                                return this.a(bdc2, bfs2, object, bve2);
                            }
                            return this.b(bdc2, bfs2, object, bve2);
                        }
                    } else {
                        bio bio3 = ((biv)((Object)this.a)).bio_a(string);
                        if (bio3 != null) {
                            bjr2.void_a(bio3, bio3.java_lang_Object_a(bdc2, bfs2));
                        } else if (bup.a(string, (Collection<String>)((Object)this.a), (Collection<String>)((Object)this.b))) {
                            this.c(bdc2, bfs2, this.a(), string);
                        } else {
                            bve2.a(string);
                            bve2.b(bdc2);
                            if (this.a != null) {
                                bjr2.a((bin)((Object)this.a), string, ((bin)((Object)this.a)).a(bdc2, bfs2));
                            }
                        }
                    }
                }
            }
            bdf2 = bdc2.bdf_a();
        }
        bve2.void_d();
        if (object == null) {
            try {
                object = ((bjo)((Object)bmo2)).a(bfs2, bjr2);
            }
            catch (Exception exception) {
                return this.java_lang_Object_a(exception, bfs2);
            }
        }
        return ((bjw)((Object)this.a)).a(bdc2, bfs2, object, bve2);
    }

    protected Object b(bdc bdc2, bfs bfs2, Object object, bve bve2) {
        Class<?> clazz = this.d ? bfs2.a() : null;
        bdf bdf2 = bdc2.bdf_c();
        while (bdf2 == bdf.f) {
            String string = bdc2.java_lang_String_d();
            bio bio2 = ((biv)((Object)this.a)).bio_a(string);
            bdc2.bdf_a();
            if (bio2 != null) {
                if (clazz != null && !bio2.a(clazz)) {
                    bdc2.bdc_a();
                } else {
                    try {
                        object = bio2.java_lang_Object_a(bdc2, bfs2, object);
                    }
                    catch (Exception exception) {
                        this.a(exception, object, string, bfs2);
                    }
                }
            } else if (bup.a(string, (Collection<String>)((Object)this.a), (Collection<String>)((Object)this.b))) {
                this.c(bdc2, bfs2, object, string);
            } else {
                bve2.a(string);
                bve2.b(bdc2);
                if (this.a != null) {
                    ((bin)((Object)this.a)).a(bdc2, bfs2, object, string);
                }
            }
            bdf2 = bdc2.bdf_a();
        }
        bve2.void_d();
        return ((bjw)((Object)this.a)).a(bdc2, bfs2, object, bve2);
    }

    protected Object g(bdc bdc2, bfs bfs2) {
        if (this.a != null) {
            return this.h(bdc2, bfs2);
        }
        return this.c(bdc2, bfs2, ((bir)((Object)this.a)).a(bfs2));
    }

    protected Object c(bdc bdc2, bfs bfs2, Object object) {
        Class<?> clazz = this.d ? bfs2.a() : null;
        biz biz2 = ((biz)((Object)this.a)).a();
        bdf bdf2 = bdc2.bdf_c();
        while (bdf2 == bdf.f) {
            String string = bdc2.java_lang_String_d();
            bdf2 = bdc2.bdf_a();
            bio bio2 = ((biv)((Object)this.a)).bio_a(string);
            if (bio2 != null) {
                if (bdf2.d()) {
                    biz2.a(bdc2, bfs2, string, object);
                }
                if (clazz != null && !bio2.a(clazz)) {
                    bdc2.bdc_a();
                } else {
                    try {
                        object = bio2.java_lang_Object_a(bdc2, bfs2, object);
                    }
                    catch (Exception exception) {
                        this.a(exception, object, string, bfs2);
                    }
                }
            } else if (bup.a(string, (Collection<String>)((Object)this.a), (Collection<String>)((Object)this.b))) {
                this.c(bdc2, bfs2, object, string);
            } else if (!biz2.b(bdc2, bfs2, string, object)) {
                if (this.a != null) {
                    try {
                        ((bin)((Object)this.a)).a(bdc2, bfs2, object, string);
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

    protected Object h(bdc bdc2, bfs bfs2) {
        bfw bfw2 = this.b;
        return bfs2.b(bfw2, String.format("Deserialization (of %s) with Builder, External type id, @JsonCreator not yet implemented", bfw2));
    }
}

