/*
 * Decompiled with CFR 0.152.
 */
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashSet;

public class bkv {
    private static final HashSet<String> a;

    public static bfx<?> a(Class<?> clazz, String string) {
        if (clazz.isPrimitive()) {
            if (clazz == Integer.TYPE) {
                return h.a;
            }
            if (clazz == Boolean.TYPE) {
                return c.a;
            }
            if (clazz == Long.TYPE) {
                return i.a;
            }
            if (clazz == Double.TYPE) {
                return f.a;
            }
            if (clazz == Character.TYPE) {
                return e.a;
            }
            if (clazz == Byte.TYPE) {
                return d.a;
            }
            if (clazz == Short.TYPE) {
                return l.a;
            }
            if (clazz == Float.TYPE) {
                return g.a;
            }
            if (clazz == Void.TYPE) {
                return bku.a;
            }
        } else if (a.contains(string)) {
            if (clazz == Integer.class) {
                return h.b;
            }
            if (clazz == Boolean.class) {
                return c.b;
            }
            if (clazz == Long.class) {
                return i.b;
            }
            if (clazz == Double.class) {
                return f.b;
            }
            if (clazz == Character.class) {
                return e.b;
            }
            if (clazz == Byte.class) {
                return d.b;
            }
            if (clazz == Short.class) {
                return l.b;
            }
            if (clazz == Float.class) {
                return g.b;
            }
            if (clazz == Number.class) {
                return j.a;
            }
            if (clazz == BigDecimal.class) {
                return bkv$a.a;
            }
            if (clazz == BigInteger.class) {
                return b.a;
            }
        } else {
            return null;
        }
        throw new IllegalArgumentException("Internal error: can't find deserializer for " + clazz.getName());
    }

    static {
        Class[] classArray;
        a = new HashSet();
        for (Class clazz : classArray = new Class[]{Boolean.class, Byte.class, Short.class, Character.class, Integer.class, Long.class, Float.class, Double.class, Number.class, BigDecimal.class, BigInteger.class}) {
            a.add(clazz.getName());
        }
    }

    @bgp
    public static class a
    extends blg<BigDecimal> {
        public static final a a = new a();

        public a() {
            super(BigDecimal.class);
        }

        @Override
        public Object b(bfs bfs2) {
            return BigDecimal.ZERO;
        }

        @Override
        public final btq a() {
            return btq.g;
        }

        @Override
        public BigDecimal a(bdc bdc2, bfs bfs2) {
            String string;
            switch (bdc2.int_a()) {
                case 7: 
                case 8: {
                    return bdc2.java_lang_Number_a();
                }
                case 6: {
                    string = bdc2.java_lang_String_e();
                    break;
                }
                case 1: {
                    string = bfs2.a(bdc2, this, this.b);
                    break;
                }
                case 3: {
                    return (BigDecimal)this.e(bdc2, bfs2);
                }
                default: {
                    return (BigDecimal)bfs2.a(this.bfw_a(bfs2), bdc2);
                }
            }
            bha bha2 = this.bha_a(bfs2, string);
            if (bha2 == bha.c) {
                return (BigDecimal)this.a(bfs2);
            }
            if (bha2 == bha.d) {
                return (BigDecimal)this.b(bfs2);
            }
            if (this.c(string = string.trim())) {
                return (BigDecimal)this.a(bfs2);
            }
            try {
                return new BigDecimal(string);
            }
            catch (IllegalArgumentException illegalArgumentException) {
                return (BigDecimal)bfs2.b(this.b, string, "not a valid representation", new Object[0]);
            }
        }
    }

    @bgp
    public static class b
    extends blg<BigInteger> {
        public static final b a = new b();

        public b() {
            super(BigInteger.class);
        }

        @Override
        public Object b(bfs bfs2) {
            return BigInteger.ZERO;
        }

        @Override
        public final btq a() {
            return btq.f;
        }

        @Override
        public BigInteger a(bdc bdc2, bfs bfs2) {
            String string;
            if (bdc2.boolean_e()) {
                return bdc2.java_lang_Number_a();
            }
            switch (bdc2.int_a()) {
                case 6: {
                    string = bdc2.java_lang_String_e();
                    break;
                }
                case 8: {
                    Class clazz = this.a(bdc2, bfs2, this.b);
                    if (clazz == bha.c) {
                        return (BigInteger)this.a(bfs2);
                    }
                    if (clazz == bha.d) {
                        return (BigInteger)this.b(bfs2);
                    }
                    return ((BigDecimal)bdc2.java_lang_Number_a()).toBigInteger();
                }
                case 1: {
                    string = bfs2.a(bdc2, this, this.b);
                    break;
                }
                case 3: {
                    return (BigInteger)this.e(bdc2, bfs2);
                }
                default: {
                    return (BigInteger)bfs2.a(this.bfw_a(bfs2), bdc2);
                }
            }
            bha bha2 = this.bha_a(bfs2, string);
            if (bha2 == bha.c) {
                return (BigInteger)this.a(bfs2);
            }
            if (bha2 == bha.d) {
                return (BigInteger)this.b(bfs2);
            }
            if (this.c(string = string.trim())) {
                return (BigInteger)this.a(bfs2);
            }
            try {
                return new BigInteger(string);
            }
            catch (IllegalArgumentException illegalArgumentException) {
                return (BigInteger)bfs2.b(this.b, string, "not a valid representation", new Object[0]);
            }
        }
    }

    @bgp
    public static class j
    extends blg<Object> {
        public static final j a = new j();

        public j() {
            super(Number.class);
        }

        @Override
        public final btq a() {
            return btq.f;
        }

        @Override
        public Object a(bdc bdc2, bfs bfs2) {
            String string;
            switch (bdc2.int_a()) {
                case 6: {
                    string = bdc2.java_lang_String_e();
                    break;
                }
                case 7: {
                    if (bfs2.a(b)) {
                        return this.t(bdc2, bfs2);
                    }
                    return bdc2.java_lang_Number_a();
                }
                case 8: {
                    if (bfs2.a(bfu.var_bfu_a) && !bdc2.boolean_f()) {
                        return bdc2.java_lang_Number_a();
                    }
                    return bdc2.java_lang_Number_a();
                }
                case 1: {
                    string = bfs2.a(bdc2, this, this.b);
                    break;
                }
                case 3: {
                    return this.e(bdc2, bfs2);
                }
                default: {
                    return bfs2.a(this.bfw_a(bfs2), bdc2);
                }
            }
            bha bha2 = this.bha_a(bfs2, string);
            if (bha2 == bha.c) {
                return this.a(bfs2);
            }
            if (bha2 == bha.d) {
                return this.b(bfs2);
            }
            if (this.c(string = string.trim())) {
                return this.a(bfs2);
            }
            if (this.e(string)) {
                return Double.POSITIVE_INFINITY;
            }
            if (this.d(string)) {
                return Double.NEGATIVE_INFINITY;
            }
            if (this.f(string)) {
                return Double.NaN;
            }
            try {
                if (!this.h(string)) {
                    if (bfs2.a(bfu.var_bfu_a)) {
                        return new BigDecimal(string);
                    }
                    return Double.valueOf(string);
                }
                if (bfs2.a(bfu.b)) {
                    return new BigInteger(string);
                }
                long l2 = Long.parseLong(string);
                if (!bfs2.a(bfu.c) && l2 <= Integer.MAX_VALUE && l2 >= Integer.MIN_VALUE) {
                    return (int)l2;
                }
                return l2;
            }
            catch (IllegalArgumentException illegalArgumentException) {
                return bfs2.b(this.b, string, "not a valid number", new Object[0]);
            }
        }

        @Override
        public Object a(bdc bdc2, bfs bfs2, boc boc2) {
            switch (bdc2.int_a()) {
                case 6: 
                case 7: 
                case 8: {
                    return this.a(bdc2, bfs2);
                }
            }
            return boc2.c(bdc2, bfs2);
        }
    }

    @bgp
    public static class f
    extends k<Double> {
        static final f a = new f(Double.TYPE, 0.0);
        static final f b = new f(Double.class, null);

        public f(Class<Double> clazz, Double d2) {
            super(clazz, btq.g, d2, 0.0);
        }

        @Override
        public Double a(bdc bdc2, bfs bfs2) {
            if (bdc2.boolean_a(bdf.j)) {
                return bdc2.double_a();
            }
            if (this.a != false) {
                return this.double_a(bdc2, bfs2);
            }
            return this.b(bdc2, bfs2);
        }

        @Override
        public Double a(bdc bdc2, bfs bfs2, boc boc2) {
            if (bdc2.boolean_a(bdf.j)) {
                return bdc2.double_a();
            }
            if (this.a != false) {
                return this.double_a(bdc2, bfs2);
            }
            return this.b(bdc2, bfs2);
        }

        protected final Double b(bdc bdc2, bfs bfs2) {
            String string;
            switch (bdc2.int_a()) {
                case 6: {
                    string = bdc2.java_lang_String_e();
                    break;
                }
                case 11: {
                    return (Double)this.a(bfs2);
                }
                case 7: 
                case 8: {
                    return bdc2.double_a();
                }
                case 1: {
                    string = bfs2.a(bdc2, this, (Class<?>)((Object)this.b));
                    break;
                }
                case 3: {
                    return (Double)this.e(bdc2, bfs2);
                }
                default: {
                    return (Double)bfs2.a((bfw)this.a(bfs2), bdc2);
                }
            }
            Object object = this.java_lang_Double_a(string);
            if (object != null) {
                return object;
            }
            object = this.bha_a(bfs2, string);
            if (object == bha.c) {
                return (Double)this.a(bfs2);
            }
            if (object == bha.d) {
                return (Double)this.b(bfs2);
            }
            if (this.boolean_a(bfs2, string = string.trim())) {
                return (Double)this.a(bfs2);
            }
            try {
                return f.double_a(string);
            }
            catch (IllegalArgumentException illegalArgumentException) {
                return (Double)bfs2.b((Class<?>)((Object)this.b), string, "not a valid `Double` value", new Object[0]);
            }
        }
    }

    @bgp
    public static class g
    extends k<Float> {
        static final g a = new g(Float.TYPE, Float.valueOf(0.0f));
        static final g b = new g(Float.class, null);

        public g(Class<Float> clazz, Float f2) {
            super(clazz, btq.g, f2, Float.valueOf(0.0f));
        }

        @Override
        public Float a(bdc bdc2, bfs bfs2) {
            if (bdc2.boolean_a(bdf.j)) {
                return Float.valueOf(bdc2.float_a());
            }
            if (this.a != false) {
                return Float.valueOf(this.float_a(bdc2, bfs2));
            }
            return this.b(bdc2, bfs2);
        }

        protected final Float b(bdc bdc2, bfs bfs2) {
            String string;
            switch (bdc2.int_a()) {
                case 6: {
                    string = bdc2.java_lang_String_e();
                    break;
                }
                case 11: {
                    return (Float)this.a(bfs2);
                }
                case 7: 
                case 8: {
                    return Float.valueOf(bdc2.float_a());
                }
                case 1: {
                    string = bfs2.a(bdc2, this, (Class<?>)((Object)this.b));
                    break;
                }
                case 3: {
                    return (Float)this.e(bdc2, bfs2);
                }
                default: {
                    return (Float)bfs2.a((bfw)this.a(bfs2), bdc2);
                }
            }
            Object object = this.java_lang_Float_a(string);
            if (object != null) {
                return object;
            }
            object = this.bha_a(bfs2, string);
            if (object == bha.c) {
                return (Float)this.a(bfs2);
            }
            if (object == bha.d) {
                return (Float)this.b(bfs2);
            }
            if (this.boolean_a(bfs2, string = string.trim())) {
                return (Float)this.a(bfs2);
            }
            try {
                return Float.valueOf(Float.parseFloat(string));
            }
            catch (IllegalArgumentException illegalArgumentException) {
                return (Float)bfs2.b((Class<?>)((Object)this.b), string, "not a valid `Float` value", new Object[0]);
            }
        }
    }

    @bgp
    public static final class i
    extends k<Long> {
        static final i a = new i(Long.TYPE, 0L);
        static final i b = new i(Long.class, null);

        public i(Class<Long> clazz, Long l2) {
            super(clazz, btq.f, l2, 0L);
        }

        @Override
        public boolean a() {
            return true;
        }

        @Override
        public Long a(bdc bdc2, bfs bfs2) {
            if (bdc2.boolean_e()) {
                return bdc2.long_a();
            }
            if (this.a != false) {
                return this.long_a(bdc2, bfs2);
            }
            return this.a(bdc2, bfs2, Long.class);
        }
    }

    @bgp
    public static final class h
    extends k<Integer> {
        static final h a = new h(Integer.TYPE, 0);
        static final h b = new h(Integer.class, null);

        public h(Class<Integer> clazz, Integer n2) {
            super(clazz, btq.f, n2, 0);
        }

        @Override
        public boolean a() {
            return true;
        }

        @Override
        public Integer a(bdc bdc2, bfs bfs2) {
            if (bdc2.boolean_e()) {
                return bdc2.int_e();
            }
            if (this.a != false) {
                return this.int_a(bdc2, bfs2);
            }
            return this.a(bdc2, bfs2, Integer.class);
        }

        @Override
        public Integer a(bdc bdc2, bfs bfs2, boc boc2) {
            if (bdc2.boolean_e()) {
                return bdc2.int_e();
            }
            if (this.a != false) {
                return this.int_a(bdc2, bfs2);
            }
            return this.a(bdc2, bfs2, Integer.class);
        }
    }

    @bgp
    public static class e
    extends k<Character> {
        static final e a = new e(Character.TYPE, Character.valueOf('\u0000'));
        static final e b = new e(Character.class, null);

        public e(Class<Character> clazz, Character c2) {
            super(clazz, btq.f, c2, Character.valueOf('\u0000'));
        }

        @Override
        public Character a(bdc bdc2, bfs bfs2) {
            String string;
            switch (bdc2.int_a()) {
                case 6: {
                    string = bdc2.java_lang_String_e();
                    break;
                }
                case 7: {
                    bha bha2 = bfs2.a(this.a(), (Class<?>)((Object)this.b), bhe.c);
                    switch (bha2) {
                        case var_bha_a: {
                            this.a(bfs2, bha2, (Class<?>)((Object)this.b), bdc2.java_lang_Number_a(), "Integer value (" + bdc2.java_lang_String_e() + ")");
                        }
                        case c: {
                            return (Character)this.a(bfs2);
                        }
                        case d: {
                            return (Character)this.b(bfs2);
                        }
                    }
                    int n2 = bdc2.int_e();
                    if (n2 >= 0 && n2 <= 65535) {
                        return Character.valueOf((char)n2);
                    }
                    return (Character)bfs2.a(this.a(), n2, "value outside valid Character range (0x0000 - 0xFFFF)", new Object[0]);
                }
                case 11: {
                    if (this.a != false) {
                        this.void_b(bfs2);
                    }
                    return (Character)this.a(bfs2);
                }
                case 1: {
                    string = bfs2.a(bdc2, this, (Class<?>)((Object)this.b));
                    break;
                }
                case 3: {
                    return (Character)this.e(bdc2, bfs2);
                }
                default: {
                    return (Character)bfs2.a((bfw)this.a(bfs2), bdc2);
                }
            }
            if (string.length() == 1) {
                return Character.valueOf(string.charAt(0));
            }
            bha bha3 = this.bha_a(bfs2, string);
            if (bha3 == bha.c) {
                return (Character)this.a(bfs2);
            }
            if (bha3 == bha.d) {
                return (Character)this.b(bfs2);
            }
            if (this.boolean_a(bfs2, string = string.trim())) {
                return (Character)this.a(bfs2);
            }
            return (Character)bfs2.b(this.a(), string, "Expected either Integer value code or 1-character String", new Object[0]);
        }
    }

    @bgp
    public static class l
    extends k<Short> {
        static final l a = new l(Short.TYPE, (short)0);
        static final l b = new l(Short.class, null);

        public l(Class<Short> clazz, Short s2) {
            super(clazz, btq.f, s2, (short)0);
        }

        @Override
        public Short a(bdc bdc2, bfs bfs2) {
            if (bdc2.boolean_e()) {
                return bdc2.short_a();
            }
            if (this.a != false) {
                return this.short_a(bdc2, bfs2);
            }
            return this.b(bdc2, bfs2);
        }

        protected Short b(bdc bdc2, bfs bfs2) {
            int n2;
            String string;
            switch (bdc2.int_a()) {
                case 6: {
                    string = bdc2.java_lang_String_e();
                    break;
                }
                case 8: {
                    l l2 = this.a(bdc2, bfs2, this.b);
                    if (l2 == bha.c) {
                        return (Short)this.a(bfs2);
                    }
                    if (l2 == bha.d) {
                        return (Short)this.b(bfs2);
                    }
                    return bdc2.short_a();
                }
                case 11: {
                    return (Short)this.a(bfs2);
                }
                case 7: {
                    return bdc2.short_a();
                }
                case 1: {
                    string = bfs2.a(bdc2, this, (Class<?>)((Object)this.b));
                    break;
                }
                case 3: {
                    return (Short)this.e(bdc2, bfs2);
                }
                default: {
                    return (Short)bfs2.a((bfw)this.a(bfs2), bdc2);
                }
            }
            bha bha2 = this.bha_a(bfs2, string);
            if (bha2 == bha.c) {
                return (Short)this.a(bfs2);
            }
            if (bha2 == bha.d) {
                return (Short)this.b(bfs2);
            }
            if (this.boolean_a(bfs2, string = string.trim())) {
                return (Short)this.a(bfs2);
            }
            try {
                n2 = bea.int_a(string);
            }
            catch (IllegalArgumentException illegalArgumentException) {
                return (Short)bfs2.b((Class<?>)((Object)this.b), string, "not a valid Short value", new Object[0]);
            }
            if (this.b(n2)) {
                return (Short)bfs2.b((Class<?>)((Object)this.b), string, "overflow, value cannot be represented as 16-bit value", new Object[0]);
            }
            return (short)n2;
        }
    }

    @bgp
    public static class d
    extends k<Byte> {
        static final d a = new d(Byte.TYPE, (byte)0);
        static final d b = new d(Byte.class, null);

        public d(Class<Byte> clazz, Byte by2) {
            super(clazz, btq.f, by2, (byte)0);
        }

        @Override
        public Byte a(bdc bdc2, bfs bfs2) {
            if (bdc2.boolean_e()) {
                return bdc2.byte_a();
            }
            if (this.a != false) {
                return this.byte_a(bdc2, bfs2);
            }
            return this.b(bdc2, bfs2);
        }

        protected Byte b(bdc bdc2, bfs bfs2) {
            int n2;
            String string;
            switch (bdc2.int_a()) {
                case 6: {
                    string = bdc2.java_lang_String_e();
                    break;
                }
                case 8: {
                    d d2 = this.a(bdc2, bfs2, this.b);
                    if (d2 == bha.c) {
                        return (Byte)this.a(bfs2);
                    }
                    if (d2 == bha.d) {
                        return (Byte)this.b(bfs2);
                    }
                    return bdc2.byte_a();
                }
                case 11: {
                    return (Byte)this.a(bfs2);
                }
                case 7: {
                    return bdc2.byte_a();
                }
                case 3: {
                    return (Byte)this.e(bdc2, bfs2);
                }
                case 1: {
                    string = bfs2.a(bdc2, this, (Class<?>)((Object)this.b));
                    break;
                }
                default: {
                    return (Byte)bfs2.a((bfw)this.a(bfs2), bdc2);
                }
            }
            bha bha2 = this.bha_a(bfs2, string);
            if (bha2 == bha.c) {
                return (Byte)this.a(bfs2);
            }
            if (bha2 == bha.d) {
                return (Byte)this.b(bfs2);
            }
            if (this.boolean_a(bfs2, string = string.trim())) {
                return (Byte)this.a(bfs2);
            }
            try {
                n2 = bea.int_a(string);
            }
            catch (IllegalArgumentException illegalArgumentException) {
                return (Byte)bfs2.b((Class<?>)((Object)this.b), string, "not a valid Byte value", new Object[0]);
            }
            if (this.a(n2)) {
                return (Byte)bfs2.b((Class<?>)((Object)this.b), string, "overflow, value cannot be represented as 8-bit value", new Object[0]);
            }
            return (byte)n2;
        }
    }

    @bgp
    public static final class c
    extends k<Boolean> {
        static final c a = new c(Boolean.TYPE, Boolean.FALSE);
        static final c b = new c(Boolean.class, null);

        public c(Class<Boolean> clazz, Boolean bl2) {
            super(clazz, btq.h, bl2, Boolean.FALSE);
        }

        @Override
        public Boolean a(bdc bdc2, bfs bfs2) {
            bdf bdf2 = bdc2.bdf_c();
            if (bdf2 == bdf.k) {
                return Boolean.TRUE;
            }
            if (bdf2 == bdf.l) {
                return Boolean.FALSE;
            }
            if (this.a != false) {
                return this.boolean_a(bdc2, bfs2);
            }
            return this.a(bdc2, bfs2, this.b);
        }

        @Override
        public Boolean a(bdc bdc2, bfs bfs2, boc boc2) {
            bdf bdf2 = bdc2.bdf_c();
            if (bdf2 == bdf.k) {
                return Boolean.TRUE;
            }
            if (bdf2 == bdf.l) {
                return Boolean.FALSE;
            }
            if (this.a != false) {
                return this.boolean_a(bdc2, bfs2);
            }
            return this.a(bdc2, bfs2, this.b);
        }
    }

    protected static abstract class k<T>
    extends blg<T> {
        protected final btq var_btq_a;
        protected final T var_T_a;
        protected final T b;
        protected final boolean var_boolean_a;

        protected k(Class<T> clazz, btq btq2, T t2, T t3) {
            super(clazz);
            this.var_btq_a = btq2;
            this.var_btq_a = t2;
            this.b = t3;
            this.var_boolean_a = clazz.isPrimitive();
        }

        @Override
        public final T a(bfs bfs2) {
            if (this.var_boolean_a && bfs2.a(bfu.f)) {
                bfs2.a(this, "Cannot map `null` into type %s (set DeserializationConfig.DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES to 'false' to allow)", buk.c(this.a()));
            }
            return (T)((Object)this.var_btq_a);
        }

        @Override
        public Object b(bfs bfs2) {
            return this.b;
        }

        @Override
        public final btq a() {
            return this.var_btq_a;
        }
    }
}

