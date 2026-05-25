/*
 * Decompiled with CFR 0.152.
 */
import java.lang.reflect.Type;

public abstract class bfq {
    public abstract bhm<?> a();

    public bfw a(Type type) {
        if (type == null) {
            return null;
        }
        return this.btz_a().a(type);
    }

    public bfw a(bfw bfw2, String string, boa boa2) {
        Class<?> clazz;
        int n2 = string.indexOf(60);
        if (n2 > 0) {
            return this.a(bfw2, string, boa2, n2);
        }
        bhm<?> bhm2 = this.a();
        boa.b b2 = boa2.a(bhm2, bfw2, string);
        if (b2 == boa.b.b) {
            return (bfw)this.a(bfw2, string, boa2);
        }
        try {
            clazz = this.btz_a().a(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            return null;
        }
        catch (Exception exception) {
            throw this.a(bfw2, string, String.format("problem: (%s) %s", exception.getClass().getName(), buk.java_lang_String_a(exception)));
        }
        if (!bfw2.c(clazz)) {
            return (bfw)this.a(bfw2, string);
        }
        bfw bfw3 = bhm2.btz_a().bfw_a(bfw2, clazz);
        if (b2 == boa.b.c && (b2 = boa2.boa$b_a(bhm2, bfw2, bfw3)) != boa.b.var_boa$b_a) {
            return (bfw)this.b(bfw2, string, boa2);
        }
        return bfw3;
    }

    private bfw a(bfw bfw2, String string, boa boa2, int n2) {
        bhm<?> bhm2 = this.a();
        boa.b b2 = boa2.a(bhm2, bfw2, string.substring(0, n2));
        if (b2 == boa.b.b) {
            return (bfw)this.a(bfw2, string, boa2);
        }
        bfw bfw3 = this.btz_a().a(string);
        if (!bfw3.b((Class<?>)bfw2.a())) {
            return (bfw)this.a(bfw2, string);
        }
        if (b2 != boa.b.var_boa$b_a && boa2.boa$b_a(bhm2, bfw2, bfw3) != boa.b.var_boa$b_a) {
            return (bfw)this.b(bfw2, string, boa2);
        }
        return bfw3;
    }

    protected <T> T a(bfw bfw2, String string) {
        throw this.a(bfw2, string, "Not a subtype");
    }

    protected <T> T a(bfw bfw2, String string, boa boa2) {
        throw this.a(bfw2, string, "Configured `PolymorphicTypeValidator` (of type " + buk.c(boa2) + ") denied resolution");
    }

    protected <T> T b(bfw bfw2, String string, boa boa2) {
        throw this.a(bfw2, string, "Configured `PolymorphicTypeValidator` (of type " + buk.c(boa2) + ") denied resolution");
    }

    protected abstract bfy a(bfw var1, String var2, String var3);

    public abstract btz btz_a();

    public bck<?> a(bmg bmg2, bni bni2) {
        bck bck2;
        Class<? extends bck<?>> clazz = bni2.b();
        bhm<?> bhm2 = this.a();
        bhl bhl2 = bhm2.bhl_a();
        bck bck3 = bck2 = bhl2 == null ? null : bhl2.a(bhm2, bmg2, clazz);
        if (bck2 == null) {
            bck2 = (bck)buk.a(clazz, bhm2.c());
        }
        return bck2.a(bni2.a());
    }

    public bcm a(bmg bmg2, bni bni2) {
        bcm bcm2;
        Class<? extends bcm> clazz = bni2.c();
        bhm<?> bhm2 = this.a();
        bhl bhl2 = bhm2.bhl_a();
        bcm bcm3 = bcm2 = bhl2 == null ? null : bhl2.bcm_a(bhm2, bmg2, clazz);
        if (bcm2 == null) {
            bcm2 = (bcm)buk.a(clazz, bhm2.c());
        }
        return bcm2;
    }

    public bum<Object, Object> a(bmg bmg2, Object object) {
        bum bum2;
        if (object == null) {
            return null;
        }
        if (object instanceof bum) {
            return (bum)object;
        }
        if (!(object instanceof Class)) {
            throw new IllegalStateException("AnnotationIntrospector returned Converter definition of type " + object.getClass().getName() + "; expected type Converter or Class<Converter> instead");
        }
        Class clazz = (Class)object;
        if (clazz == bum.a.class || buk.c(clazz)) {
            return null;
        }
        if (!bum.class.isAssignableFrom(clazz)) {
            throw new IllegalStateException("AnnotationIntrospector returned Class " + clazz.getName() + "; expected Class<Converter>");
        }
        bhm<?> bhm2 = this.a();
        bhl bhl2 = bhm2.bhl_a();
        bum bum3 = bum2 = bhl2 == null ? null : bhl2.a(bhm2, bmg2, clazz);
        if (bum2 == null) {
            bum2 = (bum)buk.a(clazz, bhm2.c());
        }
        return bum2;
    }

    public abstract <T> T b(bfw var1, String var2);

    public <T> T a(Class<?> clazz, String string) {
        return this.b(this.a(clazz), string);
    }

    protected final String java_lang_String_a(String string, Object ... objectArray) {
        if (objectArray.length > 0) {
            return String.format(string, objectArray);
        }
        return string;
    }

    protected final String java_lang_String_a(String string) {
        if (string == null) {
            return "";
        }
        if (string.length() <= 500) {
            return string;
        }
        return string.substring(0, 500) + "]...[" + string.substring(string.length() - 500);
    }

    protected String b(String string) {
        if (string == null) {
            return "[N/A]";
        }
        return String.format("\"%s\"", this.java_lang_String_a(string));
    }

    protected String a(String string, String string2) {
        if (string2 == null) {
            return string;
        }
        return string + ": " + string2;
    }
}

