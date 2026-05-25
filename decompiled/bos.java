/*
 * Decompiled with CFR 0.152.
 */
import java.util.EnumMap;
import java.util.EnumSet;

public class bos
extends bpa {
    protected final boa a;

    public bos(bfw bfw2, btz btz2, boa boa2) {
        super(bfw2, btz2);
        this.a = boa2;
    }

    public static bos a(bfw bfw2, bhm<?> bhm2, boa boa2) {
        return new bos(bfw2, bhm2.btz_a(), boa2);
    }

    @Override
    public String a(Object object) {
        return this.a(object, object.getClass(), (btz)((Object)this.a));
    }

    @Override
    public String a(Object object, Class<?> clazz) {
        return this.a(object, clazz, (btz)((Object)this.a));
    }

    @Override
    public bfw a(bfq bfq2, String string) {
        return this.a(string, bfq2);
    }

    protected bfw a(String string, bfq bfq2) {
        bfw bfw2 = bfq2.a((bfw)((Object)this.a), string, this.a);
        if (bfw2 == null && bfq2 instanceof bfs) {
            return ((bfs)bfq2).a((bfw)((Object)this.a), string, this, "no such class found");
        }
        return bfw2;
    }

    protected String a(Object object, Class<?> clazz, btz btz2) {
        Object t2;
        Class<?> clazz2;
        String string;
        if (buk.f(clazz) && !clazz.isEnum()) {
            clazz = clazz.getSuperclass();
        }
        if ((string = clazz.getName()).startsWith("java.util.")) {
            if (object instanceof EnumSet) {
                Class<? extends Enum<?>> clazz3 = buk.a((EnumSet)object);
                string = btz2.a(EnumSet.class, clazz3).java_lang_String_a();
            } else if (object instanceof EnumMap) {
                Class<? extends Enum<?>> clazz4 = buk.a((EnumMap)object);
                Class<Object> clazz5 = Object.class;
                string = btz2.a(EnumMap.class, clazz4, clazz5).java_lang_String_a();
            }
        } else if (string.indexOf(36) >= 0 && (clazz2 = buk.a(clazz)) != null && buk.a(t2 = ((bfw)((Object)this.a)).a()) == null) {
            clazz = ((bfw)((Object)this.a)).a();
            string = clazz.getName();
        }
        return string;
    }

    @Override
    public String b() {
        return "class name used as type id";
    }
}

