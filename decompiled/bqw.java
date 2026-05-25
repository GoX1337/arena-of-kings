/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;

public abstract class bqw {
    public static bqb a(bqb bqb2, Class<?>[] classArray) {
        if (classArray.length == 1) {
            return new b(bqb2, classArray[0]);
        }
        return new a(bqb2, classArray);
    }

    static final class a
    extends bqb
    implements Serializable {
        protected final bqb a;
        protected final Class<?>[] b;

        protected a(bqb bqb2, Class<?>[] classArray) {
            super(bqb2);
            this.a = bqb2;
            this.b = classArray;
        }

        @Override
        public a a(but but2) {
            return new a(this.a.a(but2), this.b);
        }

        @Override
        public void a(bgb<Object> bgb2) {
            this.a.a(bgb2);
        }

        @Override
        public void b(bgb<Object> bgb2) {
            this.a.b(bgb2);
        }

        @Override
        public void void_a(Object object, bcy bcy2, bgo bgo2) {
            if (this.a(bgo2.a())) {
                this.a.void_a(object, bcy2, bgo2);
                return;
            }
            this.a.b(object, bcy2, bgo2);
        }

        @Override
        public void c(Object object, bcy bcy2, bgo bgo2) {
            if (this.a(bgo2.a())) {
                this.a.c(object, bcy2, bgo2);
                return;
            }
            this.a.d(object, bcy2, bgo2);
        }

        private final boolean a(Class<?> clazz) {
            if (clazz == null) {
                return true;
            }
            int n2 = this.b.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                if (!this.b[i2].isAssignableFrom(clazz)) continue;
                return true;
            }
            return false;
        }
    }

    static final class b
    extends bqb
    implements Serializable {
        protected final bqb var_bqb_a;
        protected final Class<?> var_java_lang_Class____a;

        protected b(bqb bqb2, Class<?> clazz) {
            super(bqb2);
            this.var_bqb_a = bqb2;
            this.var_bqb_a = clazz;
        }

        @Override
        public b a(but but2) {
            return new b(this.var_bqb_a.a(but2), (Class<?>)((Object)this.var_bqb_a));
        }

        @Override
        public void a(bgb<Object> bgb2) {
            this.var_bqb_a.a(bgb2);
        }

        @Override
        public void b(bgb<Object> bgb2) {
            this.var_bqb_a.b(bgb2);
        }

        @Override
        public void void_a(Object object, bcy bcy2, bgo bgo2) {
            Class<?> clazz = bgo2.a();
            if (clazz == null || ((Class)((Object)this.var_bqb_a)).isAssignableFrom(clazz)) {
                this.var_bqb_a.void_a(object, bcy2, bgo2);
            } else {
                this.var_bqb_a.b(object, bcy2, bgo2);
            }
        }

        @Override
        public void c(Object object, bcy bcy2, bgo bgo2) {
            Class<?> clazz = bgo2.a();
            if (clazz == null || ((Class)((Object)this.var_bqb_a)).isAssignableFrom(clazz)) {
                this.var_bqb_a.c(object, bcy2, bgo2);
            } else {
                this.var_bqb_a.d(object, bcy2, bgo2);
            }
        }
    }
}

