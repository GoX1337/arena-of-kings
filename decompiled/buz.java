/*
 * Decompiled with CFR 0.152.
 */
public abstract class buz<T> {
    protected T var_T_a;
    protected a<T> var_buz$a_T__a;
    protected a<T> b;
    protected int var_int_a;

    protected buz() {
    }

    public int int_a() {
        return this.var_int_a;
    }

    public T a() {
        this.void_a();
        return this.var_T_a == null ? this.a(12) : this.var_T_a;
    }

    public final T a(T t2, int n2) {
        a<T> a2 = new a<T>(t2, n2);
        if (this.var_T_a == null) {
            this.b = a2;
            this.var_T_a = this.b;
        } else {
            this.b.a(a2);
            this.b = a2;
        }
        this.var_int_a += n2;
        int n3 = n2;
        n3 = n3 < 16384 ? (n3 += n3) : (n3 += n3 >> 2);
        return this.a(n3);
    }

    public T b(T t2, int n2) {
        int n3 = n2 + this.var_int_a;
        T t3 = this.a(n3);
        int n4 = 0;
        for (Object object = this.var_T_a; object != null; object = ((a)object).a()) {
            n4 = ((a)object).a(t3, n4);
        }
        System.arraycopy(t2, 0, t3, n4, n2);
        if ((n4 += n2) != n3) {
            throw new IllegalStateException("Should have gotten " + n3 + " entries, got " + n4);
        }
        return t3;
    }

    protected abstract T a(int var1);

    protected void void_a() {
        if (this.b != null) {
            this.var_T_a = this.b.a();
        }
        this.b = null;
        this.var_T_a = null;
        this.var_int_a = 0;
    }

    static final class a<T> {
        final T var_T_a;
        final int var_int_a;
        a<T> var_buz$a_T__a;

        public a(T t2, int n2) {
            this.var_T_a = t2;
            this.var_int_a = n2;
        }

        public T a() {
            return this.var_T_a;
        }

        public int a(T t2, int n2) {
            System.arraycopy(this.var_T_a, 0, t2, n2, this.var_int_a);
            return n2 += this.var_int_a;
        }

        public a<T> a() {
            return this.var_T_a;
        }

        public void a(a<T> a2) {
            if (this.var_T_a != null) {
                throw new IllegalStateException();
            }
            this.var_T_a = a2;
        }
    }
}

