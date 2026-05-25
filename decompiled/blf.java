/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class blf
implements bik,
Serializable {
    public static bgc a(bun bun2) {
        return new ble.b(bun2, null);
    }

    public static bgc a(bun bun2, bmo bmo2) {
        return new ble.b(bun2, bmo2);
    }

    public static bgc a(bfr bfr2, bfw bfw2, bfx<?> bfx2) {
        return new ble.a((Class<?>)bfw2.a(), bfx2);
    }

    public static bgc a(bfr bfr2, bfw bfw2) {
        bfo bfo2 = bfr2.bfo_a(bfw2);
        Constructor<?> constructor = bfo2.a(String.class);
        if (constructor != null) {
            if (bfr2.c()) {
                buk.a(constructor, bfr2.a(bgd.o));
            }
            return new ble.c(constructor);
        }
        Method method = bfo2.a(String.class);
        if (method != null) {
            if (bfr2.c()) {
                buk.a(method, bfr2.a(bgd.o));
            }
            return new ble.d(method);
        }
        return null;
    }

    @Override
    public bgc a(bfw bfw2, bfr bfr2, bfo bfo2) {
        Object object = bfw2.a();
        if (((Class)object).isPrimitive()) {
            object = buk.b(object);
        }
        return ble.a(object);
    }
}

