/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class bhw {
    protected final bfr var_bfr_a = new LinkedHashMap();
    protected final bfs var_bfs_a;
    protected final bfo var_bfo_a;
    protected final Map<String, bio> cfr_renamed_15;
    protected List<bjx> var_java_util_List_bjx__a;
    protected HashMap<String, bio> cfr_renamed_19;
    protected HashSet<String> var_java_util_HashSet_java_lang_String__a;
    protected HashSet<String> b;
    protected bir var_bir_a;
    protected bjl var_bjl_a;
    protected bin var_bin_a;
    protected boolean var_boolean_a;
    protected bmo var_bmo_a;
    protected bgt.a var_bgt$a_a;

    public bhw(bfo bfo2, bfs bfs2) {
        this.var_bfo_a = bfo2;
        this.var_bfs_a = bfs2;
        this.var_bfr_a = bfs2.bfr_a();
    }

    public void a(bio bio2, boolean bl2) {
        this.var_bfr_a.put(bio2.java_lang_String_a(), bio2);
    }

    public void a(bio bio2) {
        bio bio3 = this.var_bfr_a.put(bio2.java_lang_String_a(), bio2);
        if (bio3 != null && bio3 != bio2) {
            throw new IllegalArgumentException("Duplicate property '" + bio2.java_lang_String_a() + "' for " + this.var_bfo_a.bfw_a());
        }
    }

    public void a(String string, bio bio2) {
        if (this.var_bfr_a == null) {
            this.var_bfr_a = new HashMap(4);
        }
        if (this.var_bfr_a.c()) {
            bio2.a(this.var_bfr_a);
        }
        ((HashMap)((Object)this.var_bfr_a)).put(string, bio2);
    }

    public void a(bgj bgj2, bfw bfw2, bud bud2, bmn bmn2, Object object) {
        if (this.var_bfr_a == null) {
            this.var_bfr_a = new ArrayList();
        }
        if (this.var_bfr_a.c()) {
            bmn2.a(this.var_bfr_a.a(bgd.o));
        }
        this.var_bfr_a.add(new bjx(bgj2, bfw2, bmn2, object));
    }

    public void void_a(String string) {
        if (this.var_bfr_a == null) {
            this.var_bfr_a = new HashSet();
        }
        ((HashSet)((Object)this.var_bfr_a)).add(string);
    }

    public void b(String string) {
        if (this.b == null) {
            this.b = new HashSet();
        }
        this.b.add(string);
    }

    public void b(bio bio2) {
        this.a(bio2);
    }

    public void a(bin bin2) {
        if (this.var_bin_a != null && bin2 != null) {
            throw new IllegalStateException("_anySetter already set to non-null");
        }
        this.var_bin_a = bin2;
    }

    public void a(boolean bl2) {
        this.var_boolean_a = bl2;
    }

    public void a(bir bir2) {
        this.var_bir_a = bir2;
    }

    public void a(bjl bjl2) {
        this.var_bjl_a = bjl2;
    }

    public void a(bmo bmo2, bgt.a a2) {
        this.var_bmo_a = bmo2;
        this.var_bgt$a_a = a2;
    }

    public bio a(bgj bgj2) {
        return (bio)this.var_bfr_a.get(bgj2.java_lang_String_a());
    }

    public bin bin_a() {
        return this.var_bin_a;
    }

    public bir bir_a() {
        return this.var_bir_a;
    }

    public List<bjx> a() {
        return this.var_bfr_a;
    }

    public bjl bjl_a() {
        return this.var_bjl_a;
    }

    public bmo bmo_a() {
        return this.var_bmo_a;
    }

    public boolean boolean_a(String string) {
        return bup.a(string, (Collection<String>)((Object)this.var_bfr_a), this.b);
    }

    public bfx<?> a() {
        boolean bl2;
        Collection<bio> collection = this.var_bfr_a.values();
        this.a(collection);
        biv biv2 = biv.a(this.var_bfr_a, collection, this.a(collection), this.boolean_a());
        biv2.biv_a();
        boolean bl3 = bl2 = !this.var_bfr_a.a(bgd.s);
        if (!bl2) {
            for (bio bio2 : collection) {
                if (!bio2.e()) continue;
                bl2 = true;
                break;
            }
        }
        if (this.var_bjl_a != null) {
            bjn bjn2 = new bjn(this.var_bjl_a, bgi.var_bgi_a);
            biv2 = biv2.biv_a(bjn2);
        }
        return new bht(this, this.var_bfo_a, biv2, (Map<String, bio>)((Object)this.var_bfr_a), (HashSet<String>)((Object)this.var_bfr_a), this.var_boolean_a, (Set<String>)this.b, bl2);
    }

    public bhq bhq_a() {
        return new bhq(this, this.var_bfo_a, (Map<String, bio>)((Object)this.var_bfr_a), (Map<String, bio>)((Object)this.var_bfr_a));
    }

    public bfx<?> a(bfw bfw2, String string) {
        Object object;
        boolean bl2;
        Object object2;
        Class<?> clazz;
        if (this.var_bmo_a == null) {
            if (!string.isEmpty()) {
                this.var_bfs_a.b(this.var_bfo_a.bfw_a(), String.format("Builder class %s does not have build method (name: '%s')", buk.a(this.var_bfo_a.bfw_a()), string));
            }
        } else {
            clazz = this.var_bmo_a.c();
            if (clazz != (object2 = bfw2.a()) && !clazz.isAssignableFrom((Class<?>)object2) && !((Class)object2).isAssignableFrom(clazz)) {
                this.var_bfs_a.b(this.var_bfo_a.bfw_a(), String.format("Build method `%s` has wrong return type (%s), not compatible with POJO type (%s)", this.var_bmo_a.java_lang_String_b(), buk.b((Object)clazz), buk.a(bfw2)));
            }
        }
        clazz = this.var_bfr_a.values();
        this.a((Collection<bio>)((Object)clazz));
        object2 = biv.a(this.var_bfr_a, (Collection<bio>)((Object)clazz), this.a((Collection<bio>)((Object)clazz)), this.boolean_a());
        ((biv)object2).biv_a();
        boolean bl3 = bl2 = !this.var_bfr_a.a(bgd.s);
        if (!bl2) {
            object = clazz.iterator();
            while (object.hasNext()) {
                bio bio2 = (bio)object.next();
                if (!bio2.e()) continue;
                bl2 = true;
                break;
            }
        }
        if (this.var_bjl_a != null) {
            object = new bjn(this.var_bjl_a, bgi.var_bgi_a);
            object2 = ((biv)object2).biv_a((bio)object);
        }
        return this.a(bfw2, (biv)object2, bl2);
    }

    protected bfx<?> a(bfw bfw2, biv biv2, boolean bl2) {
        return new bhz(this, this.var_bfo_a, bfw2, biv2, (Map<String, bio>)((Object)this.var_bfr_a), (Set<String>)((Object)this.var_bfr_a), this.var_boolean_a, this.b, bl2);
    }

    protected void a(Collection<bio> collection) {
        if (this.var_bfr_a.c()) {
            for (bio bio2 : collection) {
                bio2.a(this.var_bfr_a);
            }
        }
        if (this.var_bin_a != null) {
            this.var_bin_a.a(this.var_bfr_a);
        }
        if (this.var_bmo_a != null) {
            this.var_bmo_a.a(this.var_bfr_a.a(bgd.o));
        }
    }

    protected Map<String, List<bgj>> a(Collection<bio> collection) {
        HashMap<String, Object> hashMap = null;
        bfn bfn2 = this.var_bfr_a.bfn_a();
        if (bfn2 != null) {
            for (bio bio2 : collection) {
                Object object = bfn2.java_lang_Object_b((bmg)bio2.bmn_a());
                if (object == null || object.isEmpty()) continue;
                if (hashMap == null) {
                    hashMap = new HashMap<String, Object>();
                }
                hashMap.put(bio2.java_lang_String_a(), object);
            }
        }
        if (hashMap == null) {
            return Collections.emptyMap();
        }
        return hashMap;
    }

    protected boolean boolean_a() {
        bbk.d d2 = this.var_bfo_a.a((bbk.d)null);
        Boolean bl2 = d2.a(bbk.a.b);
        return bl2 == null ? this.var_bfr_a.a(bgd.v) : bl2.booleanValue();
    }
}

