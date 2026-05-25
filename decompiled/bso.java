/*
 * Decompiled with CFR 0.152.
 */
import java.math.BigDecimal;
import java.math.BigInteger;

@bgp
public class bso
extends btd<Number>
implements bqh {
    public static final bso var_bso_a;
    protected final boolean var_boolean_a;

    public bso(Class<? extends Number> clazz) {
        super(clazz, false);
        this.var_boolean_a = clazz == BigInteger.class;
    }

    @Override
    public bgb<?> a(bgo bgo2, bfp bfp2) {
        bbk.d d2 = this.bbk$d_a(bgo2, bfp2, ((bte)this).a());
        if (d2 != null) {
            switch (d2.bbk$c_a()) {
                case i: {
                    if (((bte)this).a() == BigDecimal.class) {
                        return bso.a();
                    }
                    return bth.a;
                }
            }
        }
        return this;
    }

    @Override
    public void a(Number number, bcy bcy2, bgo bgo2) {
        if (number instanceof BigDecimal) {
            bcy2.void_a((BigDecimal)number);
        } else if (number instanceof BigInteger) {
            bcy2.a((BigInteger)number);
        } else if (number instanceof Long) {
            bcy2.b(number.longValue());
        } else if (number instanceof Double) {
            bcy2.a(number.doubleValue());
        } else if (number instanceof Float) {
            bcy2.a(number.floatValue());
        } else if (number instanceof Integer || number instanceof Byte || number instanceof Short) {
            bcy2.void_b(number.intValue());
        } else {
            bcy2.e(number.toString());
        }
    }

    public static bgb<?> a() {
        return bso$a.a;
    }

    static {
        var_bso_a = new bso((Class<? extends Number>)Number.class);
    }

    static final class a
    extends bti {
        static final a a = new a();

        public a() {
            super(BigDecimal.class);
        }

        @Override
        public boolean a(bgo bgo2, Object object) {
            return false;
        }

        @Override
        public void a(Object object, bcy bcy2, bgo bgo2) {
            String string;
            if (bcy2.boolean_a(bcy.a.h)) {
                BigDecimal bigDecimal = (BigDecimal)object;
                if (!this.a(bcy2, bigDecimal)) {
                    String string2 = String.format("Attempt to write plain `java.math.BigDecimal` (see JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN) with illegal scale (%d): needs to be between [-%d, %d]", bigDecimal.scale(), 9999, 9999);
                    bgo2.void_a(string2, new Object[0]);
                }
                string = bigDecimal.toPlainString();
            } else {
                string = object.toString();
            }
            bcy2.b(string);
        }

        @Override
        public String a(Object object) {
            throw new IllegalStateException();
        }

        protected boolean a(bcy bcy2, BigDecimal bigDecimal) {
            int n2 = bigDecimal.scale();
            return n2 >= -9999 && n2 <= 9999;
        }
    }
}

