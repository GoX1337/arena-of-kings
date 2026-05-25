/*
 * Decompiled with CFR 0.152.
 */
public class bcl {

    public static abstract class c
    extends a<Object> {
        protected c(Class<?> clazz) {
            super(clazz);
        }
    }

    public static abstract class b
    extends bck<Object> {
    }

    static abstract class a<T>
    extends bck<T> {
        protected final Class<?> a;

        protected a(Class<?> clazz) {
            this.a = clazz;
        }

        @Override
        public final Class<?> a() {
            return this.a;
        }

        @Override
        public boolean a(bck<?> bck2) {
            return bck2.getClass() == this.getClass() && bck2.a() == this.a;
        }
    }
}

