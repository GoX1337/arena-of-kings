/*
 * Decompiled with CFR 0.152.
 */
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public final class bjo {
    protected final int var_int_a;
    protected final bir var_bir_a;
    protected final HashMap<String, bio> cfr_renamed_19;
    protected final bio[] var_bio_arr_a;

    protected bjo(bfs bfs2, bir bir2, bio[] bioArray, boolean bl2, boolean bl3) {
        Object object;
        int n2;
        this.var_bir_a = bir2;
        this.var_int_a = bl2 ? (int)bjo$a.a(bfs2.bfr_a().java_util_Locale_a()) : (int)new HashMap();
        this.var_int_a = n2 = bioArray.length;
        this.var_bio_arr_a = new bio[n2];
        if (bl3) {
            bfr bfr2 = bfs2.bfr_a();
            object = bioArray;
            int n3 = ((bio[])object).length;
            for (int i2 = 0; i2 < n3; ++i2) {
                List<bgj> list;
                bio bio2 = object[i2];
                if (bio2.boolean_a() || (list = bio2.a((bhm<?>)bfr2)).isEmpty()) continue;
                for (bgj bgj2 : list) {
                    this.var_int_a.put(bgj2.java_lang_String_a(), bio2);
                }
            }
        }
        for (int i3 = 0; i3 < n2; ++i3) {
            this.var_bio_arr_a[i3] = object = bioArray[i3];
            if (((bio)object).boolean_a()) continue;
            this.var_int_a.put(((bio)object).java_lang_String_a(), object);
        }
    }

    public static bjo a(bfs bfs2, bir bir2, bio[] bioArray, biv biv2) {
        int n2 = bioArray.length;
        bio[] bioArray2 = new bio[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            bio bio2 = bioArray[i2];
            if (!bio2.c() && !bio2.boolean_b()) {
                bio2 = bio2.a(bfs2.a(bio2.bfw_a(), bio2));
            }
            bioArray2[i2] = bio2;
        }
        return new bjo(bfs2, bir2, bioArray2, biv2.boolean_a(), true);
    }

    public static bjo a(bfs bfs2, bir bir2, bio[] bioArray, boolean bl2) {
        int n2 = bioArray.length;
        bio[] bioArray2 = new bio[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            bio bio2 = bioArray[i2];
            if (!bio2.c()) {
                bio2 = bio2.a(bfs2.a(bio2.bfw_a(), bio2));
            }
            bioArray2[i2] = bio2;
        }
        return new bjo(bfs2, bir2, bioArray2, bl2, false);
    }

    public bio a(String string) {
        return (bio)this.var_int_a.get(string);
    }

    public bjr a(bdc bdc2, bfs bfs2, bjl bjl2) {
        return new bjr(bdc2, bfs2, this.var_int_a, bjl2);
    }

    public Object a(bfs bfs2, bjr bjr2) {
        Object object = this.var_bir_a.a(bfs2, this.var_bio_arr_a, bjr2);
        if (object != null) {
            object = bjr2.a(bfs2, object);
            bjq bjq2 = bjr2.a();
            while (bjq2 != null) {
                bjq2.a(object);
                bjq2 = bjq2.var_bjq_a;
            }
        }
        return object;
    }

    static class a
    extends HashMap<String, bio> {
        protected final Locale a;

        @Deprecated
        public a() {
            this(Locale.getDefault());
        }

        public a(Locale locale) {
            this.a = locale;
        }

        public static a a(Locale locale) {
            return new a(locale);
        }

        public bio a(Object object) {
            return (bio)super.get(((String)object).toLowerCase(this.a));
        }

        public bio a(String string, bio bio2) {
            string = string.toLowerCase(this.a);
            return super.put(string, bio2);
        }

        @Override
        public /* synthetic */ Object put(Object object, Object object2) {
            return this.a((String)object, (bio)object2);
        }

        @Override
        public /* synthetic */ Object get(Object object) {
            return this.a(object);
        }
    }
}

