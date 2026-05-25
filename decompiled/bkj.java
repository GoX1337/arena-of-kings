/*
 * Decompiled with CFR 0.152.
 */
import java.util.Objects;

@bgp
public class bkj
extends blg<Object>
implements bib {
    protected Object[] var_java_lang_Object_arr_a;
    private final Enum<?> var_java_lang_Enum____a;
    protected final bul var_bul_a;
    protected bul b;
    protected final Boolean var_java_lang_Boolean_a;

    public bkj(bun bun2, Boolean bl2) {
        super(bun2.a());
        this.var_bul_a = bun2.bul_a();
        this.var_java_lang_Object_arr_a = bun2.java_lang_Enum____arr_a();
        this.var_java_lang_Object_arr_a = bun2.a();
        this.var_java_lang_Boolean_a = bl2;
    }

    protected bkj(bkj bkj2, Boolean bl2) {
        super(bkj2);
        this.var_bul_a = bkj2.var_bul_a;
        this.var_java_lang_Object_arr_a = bkj2.var_java_lang_Object_arr_a;
        this.var_java_lang_Object_arr_a = bkj2.var_java_lang_Object_arr_a;
        this.var_java_lang_Boolean_a = bl2;
    }

    public static bfx<?> a(bfr bfr2, Class<?> clazz, bmo bmo2, bir bir2, bio[] bioArray) {
        if (bfr2.c()) {
            buk.a(bmo2.java_lang_reflect_Method_b(), bfr2.a(bgd.o));
        }
        return new bkn(clazz, bmo2, bmo2.bfw_a(0), bir2, bioArray);
    }

    public static bfx<?> a(bfr bfr2, Class<?> clazz, bmo bmo2) {
        if (bfr2.c()) {
            buk.a(bmo2.java_lang_reflect_Method_b(), bfr2.a(bgd.o));
        }
        return new bkn(clazz, bmo2);
    }

    public bkj a(Boolean bl2) {
        if (Objects.equals(this.var_java_lang_Boolean_a, bl2)) {
            return this;
        }
        return new bkj(this, bl2);
    }

    @Override
    public bfx<?> a(bfs bfs2, bfp bfp2) {
        Boolean bl2 = this.a(bfs2, bfp2, this.a(), bbk.a.b);
        if (bl2 == null) {
            bl2 = this.var_java_lang_Boolean_a;
        }
        return this.a(bl2);
    }

    @Override
    public boolean boolean_a() {
        return true;
    }

    @Override
    public btq btq_a() {
        return btq.i;
    }

    @Override
    public Object b(bfs bfs2) {
        return this.var_java_lang_Object_arr_a;
    }

    @Override
    public Object a(bdc bdc2, bfs bfs2) {
        if (bdc2.boolean_a(bdf.h)) {
            return this.a(bdc2, bfs2, bdc2.java_lang_String_e());
        }
        if (bdc2.boolean_a(bdf.i)) {
            return this.a(bdc2, bfs2, bdc2.int_e());
        }
        if (bdc2.boolean_d()) {
            return this.a(bdc2, bfs2, bfs2.a(bdc2, this, (Class<?>)((Object)this.b)));
        }
        return this.b(bdc2, bfs2);
    }

    @Override
    protected Object a(bdc bdc2, bfs bfs2, String string) {
        String string2;
        bul bul2 = bfs2.a(bfu.w) ? this.a(bfs2) : this.var_bul_a;
        Object object = bul2.a(string);
        if (object == null && ((string2 = string.trim()) == string || (object = bul2.a(string2)) == null)) {
            return this.a(bdc2, bfs2, bul2, string2);
        }
        return object;
    }

    @Override
    protected Object a(bdc bdc2, bfs bfs2, int n2) {
        bha bha2 = bfs2.a(this.btq_a(), this.a(), bhe.c);
        if (bha2 == bha.var_bha_a) {
            if (bfs2.a(bfu.g)) {
                return bfs2.a(this.b(), n2, "not allowed to deserialize Enum value out of number: disable DeserializationConfig.DeserializationFeature.FAIL_ON_NUMBERS_FOR_ENUMS to allow", new Object[0]);
            }
            this.a(bfs2, bha2, this.a(), n2, "Integer value (" + n2 + ")");
        }
        switch (bha2) {
            case c: {
                return null;
            }
            case d: {
                return this.b(bfs2);
            }
        }
        if (n2 >= 0 && n2 < this.var_java_lang_Object_arr_a.length) {
            return this.var_java_lang_Object_arr_a[n2];
        }
        if (this.var_java_lang_Object_arr_a != null && bfs2.a(bfu.y)) {
            return this.var_java_lang_Object_arr_a;
        }
        if (!bfs2.a(bfu.x)) {
            return bfs2.a(this.b(), n2, "index value outside legal index range [0..%s]", this.var_java_lang_Object_arr_a.length - 1);
        }
        return null;
    }

    private final Object a(bdc bdc2, bfs bfs2, bul bul2, String string) {
        char c2;
        String string2 = string.trim();
        if (string2.isEmpty()) {
            bha bha2;
            if (string.isEmpty()) {
                bha2 = this.bha_a(bfs2);
                bha2 = this.a(bfs2, bha2, this.a(), string, "empty String (\"\")");
            } else {
                bha2 = this.c(bfs2);
                bha2 = this.a(bfs2, bha2, this.a(), string, "blank String (all whitespace)");
            }
            switch (bha2) {
                case d: 
                case b: {
                    return this.b(bfs2);
                }
            }
            return null;
        }
        if (Boolean.TRUE.equals(this.var_java_lang_Boolean_a)) {
            Object object = bul2.b(string2);
            if (object != null) {
                return object;
            }
        } else if (!bfs2.a(bfu.g) && (c2 = string2.charAt(0)) >= '0' && c2 <= '9') {
            try {
                int n2 = Integer.parseInt(string2);
                if (!bfs2.a(bgd.B)) {
                    return bfs2.b(this.b(), string2, "value looks like quoted Enum index, but `MapperFeature.ALLOW_COERCION_OF_SCALARS` prevents use", new Object[0]);
                }
                if (n2 >= 0 && n2 < this.var_java_lang_Object_arr_a.length) {
                    return this.var_java_lang_Object_arr_a[n2];
                }
            }
            catch (NumberFormatException numberFormatException) {
                // empty catch block
            }
        }
        if (this.var_java_lang_Object_arr_a != null && bfs2.a(bfu.y)) {
            return this.var_java_lang_Object_arr_a;
        }
        if (!bfs2.a(bfu.x)) {
            return bfs2.b(this.b(), string2, "not one of the values accepted for Enum class: %s", bul2.a());
        }
        return null;
    }

    protected Object b(bdc bdc2, bfs bfs2) {
        if (bdc2.boolean_a(bdf.var_bdf_d)) {
            return this.e(bdc2, bfs2);
        }
        return bfs2.a(this.b(), bdc2);
    }

    protected Class<?> b() {
        return this.a();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    protected bul a(bfs bfs2) {
        bul bul2 = this.b;
        if (bul2 == null) {
            bkj bkj2 = this;
            synchronized (bkj2) {
                bul2 = bun.b(bfs2.bfr_a(), this.b()).bul_a();
            }
            this.b = bul2;
        }
        return bul2;
    }
}

