/*
 * Decompiled with CFR 0.152.
 */
import java.io.Closeable;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class bny
extends boa
implements Serializable {
    @Override
    public boa.b boa$b_a(bhm<?> bhm2, bfw bfw2) {
        if (this.boolean_a(bhm2, bfw2)) {
            return boa.b.b;
        }
        return boa.b.c;
    }

    @Override
    public boa.b a(bhm<?> bhm2, bfw bfw2, String string) {
        return boa.b.c;
    }

    @Override
    public boa.b boa$b_a(bhm<?> bhm2, bfw bfw2, bfw bfw3) {
        return this.boolean_a(bhm2, bfw2, bfw3) ? boa.b.var_boa$b_a : boa.b.b;
    }

    protected boolean boolean_a(bhm<?> bhm2, bfw bfw2) {
        return a.var_bny$a_a.a((Class<?>)bfw2.a());
    }

    protected boolean boolean_a(bhm<?> bhm2, bfw bfw2, bfw bfw3) {
        return true;
    }

    static final class a {
        public static final a var_bny$a_a;
        private final Set<String> var_java_util_Set_java_lang_String__a;

        private a() {
            this.var_bny$a_a = new HashSet();
            this.var_bny$a_a.add(Object.class.getName());
            this.var_bny$a_a.add(Closeable.class.getName());
            this.var_bny$a_a.add(Serializable.class.getName());
            this.var_bny$a_a.add(AutoCloseable.class.getName());
            this.var_bny$a_a.add(Cloneable.class.getName());
            this.var_bny$a_a.add("java.util.logging.Handler");
            this.var_bny$a_a.add("javax.naming.Referenceable");
            this.var_bny$a_a.add("javax.sql.DataSource");
        }

        public boolean a(Class<?> clazz) {
            return this.var_bny$a_a.contains(clazz.getName());
        }

        static {
            var_bny$a_a = new a();
        }
    }
}

