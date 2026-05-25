/*
 * Decompiled with CFR 0.152.
 */
import java.util.Map;

public abstract class bjq {
    public final bjq var_bjq_a;
    public final Object var_java_lang_Object_a;

    protected bjq(bjq bjq2, Object object) {
        this.var_bjq_a = bjq2;
        this.var_java_lang_Object_a = object;
    }

    public abstract void a(Object var1);

    static final class b
    extends bjq {
        final Object b;

        public b(bjq bjq2, Object object, Object object2) {
            super(bjq2, object);
            this.b = object2;
        }

        @Override
        public void a(Object object) {
            ((Map)object).put(this.b, this.a);
        }
    }

    static final class a
    extends bjq {
        final bin var_bin_a;
        final String var_java_lang_String_a;

        public a(bjq bjq2, Object object, bin bin2, String string) {
            super(bjq2, object);
            this.var_bin_a = bin2;
            this.var_java_lang_String_a = string;
        }

        @Override
        public void a(Object object) {
            this.var_bin_a.a(object, (Object)this.var_java_lang_String_a, (Object)this.var_bin_a);
        }
    }

    static final class c
    extends bjq {
        final bio a;

        public c(bjq bjq2, Object object, bio bio2) {
            super(bjq2, object);
            this.a = bio2;
        }

        @Override
        public void a(Object object) {
            this.a.void_a(object, (Object)this.a);
        }
    }
}

