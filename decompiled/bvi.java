/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;

public class bvi
implements Serializable {
    protected static final bvi a = new bvi();

    public boolean a(Class<?> clazz) {
        return false;
    }

    public static bvi a(Class<?>[] classArray) {
        if (classArray == null) {
            return a;
        }
        switch (classArray.length) {
            case 0: {
                return a;
            }
            case 1: {
                return new b(classArray[0]);
            }
        }
        return new a(classArray);
    }

    static final class a
    extends bvi
    implements Serializable {
        private final Class<?>[] a;

        public a(Class<?>[] classArray) {
            this.a = classArray;
        }

        @Override
        public boolean a(Class<?> clazz) {
            for (Class<?> clazz2 : this.a) {
                if (clazz != clazz2 && !clazz2.isAssignableFrom(clazz)) continue;
                return true;
            }
            return false;
        }
    }

    static final class b
    extends bvi {
        private final Class<?> a;

        public b(Class<?> clazz) {
            this.a = clazz;
        }

        @Override
        public boolean a(Class<?> clazz) {
            return clazz == this.a || this.a.isAssignableFrom(clazz);
        }
    }
}

