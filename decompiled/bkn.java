/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;

class bkn
extends blc<Object>
implements bib {
    protected final bfw var_bfw_a;
    protected final boolean var_boolean_a;
    protected final bmo var_bmo_a;
    protected final bfx<?> var_bfx____a;
    protected final bir var_bir_a;
    protected final bio[] var_bio_arr_a;
    private transient bjo var_bjo_a;

    public bkn(Class<?> clazz, bmo bmo2, bfw bfw2, bir bir2, bio[] bioArray) {
        super(clazz);
        this.var_bmo_a = bmo2;
        this.var_boolean_a = true;
        this.var_bfw_a = bfw2.boolean_a(String.class) ? null : bfw2;
        this.var_bfw_a = null;
        this.var_bir_a = bir2;
        this.var_bio_arr_a = bioArray;
    }

    public bkn(Class<?> clazz, bmo bmo2) {
        super(clazz);
        this.var_bmo_a = bmo2;
        this.var_boolean_a = false;
        this.var_bfw_a = null;
        this.var_bfw_a = null;
        this.var_bir_a = null;
        this.var_bio_arr_a = null;
    }

    protected bkn(bkn bkn2, bfx<?> bfx2) {
        super(bkn2.b);
        this.var_bfw_a = bkn2.var_bfw_a;
        this.var_bmo_a = bkn2.var_bmo_a;
        this.var_boolean_a = bkn2.var_boolean_a;
        this.var_bir_a = bkn2.var_bir_a;
        this.var_bio_arr_a = bkn2.var_bio_arr_a;
        this.var_bfw_a = bfx2;
    }

    @Override
    public bfx<?> a(bfs bfs2, bfp bfp2) {
        if (this.var_bfw_a == null && this.var_bfw_a != null && this.var_bio_arr_a == null) {
            return new bkn(this, bfs2.a(this.var_bfw_a, bfp2));
        }
        return this;
    }

    @Override
    public Boolean a(bfr bfr2) {
        return Boolean.FALSE;
    }

    @Override
    public btq btq_a() {
        return btq.i;
    }

    @Override
    public boolean boolean_a() {
        return true;
    }

    @Override
    public bir bir_a() {
        return this.var_bir_a;
    }

    @Override
    public Object a(bdc bdc2, bfs bfs2) {
        Object object;
        if (this.var_bfw_a != null) {
            object = ((bfx)((Object)this.var_bfw_a)).a(bdc2, bfs2);
        } else if (this.var_boolean_a) {
            bdf bdf2 = bdc2.bdf_c();
            if (this.var_bio_arr_a != null) {
                if (!bdc2.boolean_d()) {
                    bfw bfw2 = this.bfw_a(bfs2);
                    bfs2.a(bfw2, "Input mismatch reading Enum %s: properties-based `@JsonCreator` (%s) expects JSON Object (JsonToken.START_OBJECT), got JsonToken.%s", new Object[]{buk.a(bfw2), this.var_bmo_a, bdc2.bdf_c()});
                }
                if (this.var_bjo_a == null) {
                    this.var_bjo_a = bjo.a(bfs2, this.var_bir_a, this.var_bio_arr_a, bfs2.a(bgd.v));
                }
                bdc2.bdf_a();
                return this.a(bdc2, bfs2, this.var_bjo_a);
            }
            object = bdf2 == bdf.h || bdf2 == bdf.f ? bdc2.java_lang_String_e() : (bdf2 == bdf.i ? bdc2.java_lang_Number_a() : bdc2.java_lang_String_f());
        } else {
            bdc2.bdc_a();
            try {
                return this.var_bmo_a.java_lang_Object_a();
            }
            catch (Exception exception) {
                Throwable throwable = buk.e(exception);
                return bfs2.a(this.b, null, throwable);
            }
        }
        try {
            return this.var_bmo_a.a((Object)this.b, new Object[]{object});
        }
        catch (Exception exception) {
            Throwable throwable = buk.e(exception);
            if (bfs2.a(bfu.x) && throwable instanceof IllegalArgumentException) {
                return null;
            }
            return bfs2.a(this.b, object, throwable);
        }
    }

    @Override
    public Object a(bdc bdc2, bfs bfs2, boc boc2) {
        if (this.var_bfw_a == null) {
            return this.a(bdc2, bfs2);
        }
        return boc2.d(bdc2, bfs2);
    }

    @Override
    protected Object a(bdc bdc2, bfs bfs2, bjo bjo2) {
        bjr bjr2 = bjo2.a(bdc2, bfs2, null);
        bdf bdf2 = bdc2.bdf_c();
        while (bdf2 == bdf.f) {
            String string = bdc2.java_lang_String_d();
            bdc2.bdf_a();
            bio bio2 = bjo2.a(string);
            if (!(bjr2.a(string) && bio2 == null || bio2 == null)) {
                bjr2.boolean_a(bio2, this.a(bdc2, bfs2, bio2));
            }
            bdf2 = bdc2.bdf_a();
        }
        return bjo2.a(bfs2, bjr2);
    }

    @Override
    protected final Object a(bdc bdc2, bfs bfs2, bio bio2) {
        try {
            return bio2.java_lang_Object_a(bdc2, bfs2);
        }
        catch (Exception exception) {
            return this.a(exception, this.a(), bio2.java_lang_String_a(), bfs2);
        }
    }

    protected Object a(Throwable throwable, Object object, String string, bfs bfs2) {
        throw bfy.a(this.a(throwable, bfs2), object, string);
    }

    private Throwable a(Throwable throwable, bfs bfs2) {
        boolean bl2;
        throwable = buk.d(throwable);
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
}

