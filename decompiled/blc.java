/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

public abstract class blc<T>
extends bfx<T>
implements Serializable {
    protected static final int var_int_b;
    @Deprecated
    protected static final int var_int_c;
    protected final Class<?> var_java_lang_Class____b;
    protected final bfw var_bfw_c;

    protected blc(Class<?> clazz) {
        this.var_int_b = (int)clazz;
        this.var_bfw_c = null;
    }

    protected blc(bfw bfw2) {
        this.var_int_b = (int)(bfw2 == null ? Object.class : bfw2.a());
        this.var_bfw_c = bfw2;
    }

    protected blc(blc<?> blc2) {
        this.var_int_b = blc2.var_int_b;
        this.var_bfw_c = blc2.var_bfw_c;
    }

    @Override
    public Class<?> a() {
        return this.var_int_b;
    }

    @Override
    public bfw bfw_a() {
        return this.var_bfw_c;
    }

    @Override
    public bfw bfw_a(bfs bfs2) {
        if (this.var_bfw_c != null) {
            return this.var_bfw_c;
        }
        return bfs2.bfw_a((Class<?>)this.var_int_b);
    }

    @Override
    public bir bir_a() {
        return null;
    }

    protected boolean a(bfx<?> bfx2) {
        return buk.boolean_a(bfx2);
    }

    protected boolean a(bgc bgc2) {
        return buk.boolean_a(bgc2);
    }

    @Override
    public Object a(bdc bdc2, bfs bfs2, boc boc2) {
        return boc2.d(bdc2, bfs2);
    }

    protected T e(bdc bdc2, bfs bfs2) {
        bha bha2 = this.bha_b(bfs2);
        boolean bl2 = bfs2.a(bfu.r);
        if (bl2 || bha2 != bha.var_bha_a) {
            bdf bdf2 = bdc2.bdf_a();
            if (bdf2 == bdf.var_bdf_e) {
                switch (bha2) {
                    case d: {
                        return (T)this.b(bfs2);
                    }
                    case c: 
                    case b: {
                        return this.a(bfs2);
                    }
                }
            } else if (bl2) {
                T t2 = this.s(bdc2, bfs2);
                if (bdc2.bdf_a() != bdf.var_bdf_e) {
                    this.void_a(bdc2, bfs2);
                }
                return t2;
            }
        }
        return (T)bfs2.a(this.bfw_a(bfs2), bdf.var_bdf_d, bdc2, null, new Object[0]);
    }

    protected T r(bdc bdc2, bfs bfs2) {
        bir bir2 = this.bir_a();
        Class<?> clazz = this.a();
        String string = bdc2.java_lang_String_f();
        if (bir2 != null && bir2.boolean_b()) {
            return (T)bir2.a(bfs2, string);
        }
        if (string.isEmpty()) {
            bha bha2 = bfs2.a(this.btq_a(), clazz, bhe.j);
            return (T)this.a(bdc2, bfs2, bha2, clazz, "empty String (\"\")");
        }
        if (blc.g(string)) {
            bha bha3 = bfs2.a(this.btq_a(), clazz, bha.var_bha_a);
            return (T)this.a(bdc2, bfs2, bha3, clazz, "blank String (all whitespace)");
        }
        if (bir2 != null) {
            string = string.trim();
            if (bir2.boolean_c() && bfs2.a(btq.f, Integer.class, bhe.f) == bha.b) {
                return (T)bir2.a(bfs2, this.int_a(bfs2, string));
            }
            if (bir2.d() && bfs2.a(btq.f, Long.class, bhe.f) == bha.b) {
                return (T)bir2.a(bfs2, this.long_a(bfs2, string));
            }
            if (bir2.h() && bfs2.a(btq.h, Boolean.class, bhe.f) == bha.b) {
                String string2 = string.trim();
                if ("true".equals(string2)) {
                    return (T)bir2.a(bfs2, true);
                }
                if ("false".equals(string2)) {
                    return (T)bir2.a(bfs2, false);
                }
            }
        }
        return (T)bfs2.a(clazz, bir2, bfs2.bdc_a(), "no String-argument constructor/factory method to deserialize from String value ('%s')", string);
    }

    protected Object a(bdc bdc2, bfs bfs2, bha bha2, Class<?> clazz, String string) {
        switch (bha2) {
            case d: {
                return this.b(bfs2);
            }
            case var_bha_a: {
                this.a(bfs2, bha2, clazz, "", "empty String (\"\")");
            }
        }
        return null;
    }

    protected T s(bdc bdc2, bfs bfs2) {
        if (bdc2.boolean_a(bdf.var_bdf_d)) {
            String string = String.format("Cannot deserialize instance of %s out of %s token: nested Arrays not allowed with %s", new Object[]{buk.java_lang_String_b(this.var_int_b), bdf.var_bdf_d, "DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS"});
            Object object = bfs2.a(this.bfw_a(bfs2), bdc2.bdf_c(), bdc2, string, new Object[0]);
            return (T)object;
        }
        return this.a(bdc2, bfs2);
    }

    @Override
    protected final boolean boolean_a(bdc bdc2, bfs bfs2) {
        String string;
        switch (bdc2.int_a()) {
            case 6: {
                string = bdc2.java_lang_String_e();
                break;
            }
            case 7: {
                return Boolean.TRUE.equals(this.b(bdc2, bfs2, Boolean.TYPE));
            }
            case 9: {
                return true;
            }
            case 10: {
                return false;
            }
            case 11: {
                this.void_b(bfs2);
                return false;
            }
            case 1: {
                string = bfs2.a(bdc2, this, Boolean.TYPE);
                break;
            }
            case 3: {
                if (bfs2.a(bfu.r)) {
                    bdc2.bdf_a();
                    boolean bl2 = this.boolean_a(bdc2, bfs2);
                    this.b(bdc2, bfs2);
                    return bl2;
                }
            }
            default: {
                return (Boolean)bfs2.a(Boolean.TYPE, bdc2);
            }
        }
        bha bha2 = this.a(bfs2, string, btq.h, Boolean.TYPE);
        if (bha2 == bha.c) {
            this.void_b(bfs2);
            return false;
        }
        if (bha2 == bha.d) {
            return false;
        }
        int n2 = (string = string.trim()).length();
        if (n2 == 4) {
            if (this.boolean_a(string)) {
                return true;
            }
        } else if (n2 == 5 && this.b(string)) {
            return false;
        }
        if (this.c(string)) {
            this.void_a(bfs2, string);
            return false;
        }
        Boolean bl3 = (Boolean)bfs2.b(Boolean.TYPE, string, "only \"true\"/\"True\"/\"TRUE\" or \"false\"/\"False\"/\"FALSE\" recognized", new Object[0]);
        return Boolean.TRUE.equals(bl3);
    }

    protected boolean boolean_a(String string) {
        char c2 = string.charAt(0);
        if (c2 == 't') {
            return "true".equals(string);
        }
        if (c2 == 'T') {
            return "TRUE".equals(string) || "True".equals(string);
        }
        return false;
    }

    protected boolean b(String string) {
        char c2 = string.charAt(0);
        if (c2 == 'f') {
            return "false".equals(string);
        }
        if (c2 == 'F') {
            return "FALSE".equals(string) || "False".equals(string);
        }
        return false;
    }

    @Override
    protected final Boolean java_lang_Boolean_a(bdc bdc2, bfs bfs2, Class<?> clazz) {
        String string;
        switch (bdc2.int_a()) {
            case 6: {
                string = bdc2.java_lang_String_e();
                break;
            }
            case 7: {
                return this.b(bdc2, bfs2, clazz);
            }
            case 9: {
                return true;
            }
            case 10: {
                return false;
            }
            case 11: {
                return null;
            }
            case 1: {
                string = bfs2.a(bdc2, this, clazz);
                break;
            }
            case 3: {
                return (Boolean)this.e(bdc2, bfs2);
            }
            default: {
                return (Boolean)bfs2.a(clazz, bdc2);
            }
        }
        bha bha2 = this.a(bfs2, string, btq.h, clazz);
        if (bha2 == bha.c) {
            return null;
        }
        if (bha2 == bha.d) {
            return false;
        }
        int n2 = (string = string.trim()).length();
        if (n2 == 4) {
            if (this.boolean_a(string)) {
                return true;
            }
        } else if (n2 == 5 && this.b(string)) {
            return false;
        }
        if (this.boolean_a(bfs2, string)) {
            return null;
        }
        return (Boolean)bfs2.b(clazz, string, "only \"true\" or \"false\" recognized", new Object[0]);
    }

    @Override
    protected final byte byte_a(bdc bdc2, bfs bfs2) {
        int n2;
        String string;
        switch (bdc2.int_a()) {
            case 6: {
                string = bdc2.java_lang_String_e();
                break;
            }
            case 8: {
                bha bha2 = this.bha_a(bdc2, bfs2, Byte.TYPE);
                if (bha2 == bha.c) {
                    return 0;
                }
                if (bha2 == bha.d) {
                    return 0;
                }
                return bdc2.byte_a();
            }
            case 7: {
                return bdc2.byte_a();
            }
            case 11: {
                this.void_b(bfs2);
                return 0;
            }
            case 1: {
                string = bfs2.a(bdc2, this, Byte.TYPE);
                break;
            }
            case 3: {
                if (bfs2.a(bfu.r)) {
                    bdc2.bdf_a();
                    byte by2 = this.byte_a(bdc2, bfs2);
                    this.b(bdc2, bfs2);
                    return by2;
                }
            }
            default: {
                return (Byte)bfs2.a(bfs2.bfw_a(Byte.TYPE), bdc2);
            }
        }
        bha bha3 = this.a(bfs2, string, btq.f, Byte.TYPE);
        if (bha3 == bha.c) {
            return 0;
        }
        if (bha3 == bha.d) {
            return 0;
        }
        if (this.c(string = string.trim())) {
            this.void_a(bfs2, string);
            return 0;
        }
        try {
            n2 = bea.int_a(string);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            return (Byte)bfs2.b((Class<?>)this.var_int_b, string, "not a valid `byte` value", new Object[0]);
        }
        if (this.a(n2)) {
            return (Byte)bfs2.b((Class<?>)this.var_int_b, string, "overflow, value cannot be represented as 8-bit value", new Object[0]);
        }
        return (byte)n2;
    }

    @Override
    protected final short short_a(bdc bdc2, bfs bfs2) {
        int n2;
        String string;
        switch (bdc2.int_a()) {
            case 6: {
                string = bdc2.java_lang_String_e();
                break;
            }
            case 8: {
                bha bha2 = this.bha_a(bdc2, bfs2, Short.TYPE);
                if (bha2 == bha.c) {
                    return 0;
                }
                if (bha2 == bha.d) {
                    return 0;
                }
                return bdc2.short_a();
            }
            case 7: {
                return bdc2.short_a();
            }
            case 11: {
                this.void_b(bfs2);
                return 0;
            }
            case 1: {
                string = bfs2.a(bdc2, this, Short.TYPE);
                break;
            }
            case 3: {
                if (bfs2.a(bfu.r)) {
                    bdc2.bdf_a();
                    short s2 = this.short_a(bdc2, bfs2);
                    this.b(bdc2, bfs2);
                    return s2;
                }
            }
            default: {
                return (Short)bfs2.a(bfs2.bfw_a(Short.TYPE), bdc2);
            }
        }
        bha bha3 = this.a(bfs2, string, btq.f, Short.TYPE);
        if (bha3 == bha.c) {
            return 0;
        }
        if (bha3 == bha.d) {
            return 0;
        }
        if (this.c(string = string.trim())) {
            this.void_a(bfs2, string);
            return 0;
        }
        try {
            n2 = bea.int_a(string);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            return (Short)bfs2.b(Short.TYPE, string, "not a valid `short` value", new Object[0]);
        }
        if (this.b(n2)) {
            return (Short)bfs2.b(Short.TYPE, string, "overflow, value cannot be represented as 16-bit value", new Object[0]);
        }
        return (short)n2;
    }

    @Override
    protected final int int_a(bdc bdc2, bfs bfs2) {
        String string;
        switch (bdc2.int_a()) {
            case 6: {
                string = bdc2.java_lang_String_e();
                break;
            }
            case 8: {
                bha bha2 = this.bha_a(bdc2, bfs2, Integer.TYPE);
                if (bha2 == bha.c) {
                    return 0;
                }
                if (bha2 == bha.d) {
                    return 0;
                }
                return bdc2.int_f();
            }
            case 7: {
                return bdc2.int_e();
            }
            case 11: {
                this.void_b(bfs2);
                return 0;
            }
            case 1: {
                string = bfs2.a(bdc2, this, Integer.TYPE);
                break;
            }
            case 3: {
                if (bfs2.a(bfu.r)) {
                    bdc2.bdf_a();
                    int n2 = this.int_a(bdc2, bfs2);
                    this.b(bdc2, bfs2);
                    return n2;
                }
            }
            default: {
                return ((Number)bfs2.a(Integer.TYPE, bdc2)).intValue();
            }
        }
        bha bha3 = this.a(bfs2, string, btq.f, Integer.TYPE);
        if (bha3 == bha.c) {
            return 0;
        }
        if (bha3 == bha.d) {
            return 0;
        }
        if (this.c(string = string.trim())) {
            this.void_a(bfs2, string);
            return 0;
        }
        return this.int_a(bfs2, string);
    }

    protected final int int_a(bfs bfs2, String string) {
        try {
            if (string.length() > 9) {
                long l2 = Long.parseLong(string);
                if (this.a(l2)) {
                    Number number = (Number)bfs2.b(Integer.TYPE, string, "Overflow: numeric value (%s) out of range of int (%d -%d)", string, Integer.MIN_VALUE, Integer.MAX_VALUE);
                    return this.a(number).intValue();
                }
                return (int)l2;
            }
            return bea.int_a(string);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            Number number = (Number)bfs2.b(Integer.TYPE, string, "not a valid `int` value", new Object[0]);
            return this.a(number).intValue();
        }
    }

    @Override
    protected final Integer java_lang_Integer_a(bdc bdc2, bfs bfs2, Class<?> clazz) {
        String string;
        switch (bdc2.int_a()) {
            case 6: {
                string = bdc2.java_lang_String_e();
                break;
            }
            case 8: {
                bha bha2 = this.bha_a(bdc2, bfs2, clazz);
                if (bha2 == bha.c) {
                    return (Integer)this.a(bfs2);
                }
                if (bha2 == bha.d) {
                    return (Integer)this.b(bfs2);
                }
                return bdc2.int_f();
            }
            case 7: {
                return bdc2.int_e();
            }
            case 11: {
                return (Integer)this.a(bfs2);
            }
            case 1: {
                string = bfs2.a(bdc2, this, clazz);
                break;
            }
            case 3: {
                return (Integer)this.e(bdc2, bfs2);
            }
            default: {
                return (Integer)bfs2.a(this.bfw_a(bfs2), bdc2);
            }
        }
        bha bha3 = this.bha_a(bfs2, string);
        if (bha3 == bha.c) {
            return (Integer)this.a(bfs2);
        }
        if (bha3 == bha.d) {
            return (Integer)this.b(bfs2);
        }
        if (this.boolean_a(bfs2, string = string.trim())) {
            return (Integer)this.a(bfs2);
        }
        return this.int_a(bfs2, string);
    }

    @Override
    protected final long long_a(bdc bdc2, bfs bfs2) {
        String string;
        switch (bdc2.int_a()) {
            case 6: {
                string = bdc2.java_lang_String_e();
                break;
            }
            case 8: {
                bha bha2 = this.bha_a(bdc2, bfs2, Long.TYPE);
                if (bha2 == bha.c) {
                    return 0L;
                }
                if (bha2 == bha.d) {
                    return 0L;
                }
                return bdc2.long_b();
            }
            case 7: {
                return bdc2.long_a();
            }
            case 11: {
                this.void_b(bfs2);
                return 0L;
            }
            case 1: {
                string = bfs2.a(bdc2, this, Long.TYPE);
                break;
            }
            case 3: {
                if (bfs2.a(bfu.r)) {
                    bdc2.bdf_a();
                    long l2 = this.long_a(bdc2, bfs2);
                    this.b(bdc2, bfs2);
                    return l2;
                }
            }
            default: {
                return ((Number)bfs2.a(Long.TYPE, bdc2)).longValue();
            }
        }
        bha bha3 = this.a(bfs2, string, btq.f, Long.TYPE);
        if (bha3 == bha.c) {
            return 0L;
        }
        if (bha3 == bha.d) {
            return 0L;
        }
        if (this.c(string = string.trim())) {
            this.void_a(bfs2, string);
            return 0L;
        }
        return this.long_a(bfs2, string);
    }

    protected final long long_a(bfs bfs2, String string) {
        try {
            return bea.long_a(string);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            Number number = (Number)bfs2.b(Long.TYPE, string, "not a valid `long` value", new Object[0]);
            return this.a(number).longValue();
        }
    }

    @Override
    protected final Long java_lang_Long_a(bdc bdc2, bfs bfs2, Class<?> clazz) {
        String string;
        switch (bdc2.int_a()) {
            case 6: {
                string = bdc2.java_lang_String_e();
                break;
            }
            case 8: {
                bha bha2 = this.bha_a(bdc2, bfs2, clazz);
                if (bha2 == bha.c) {
                    return (Long)this.a(bfs2);
                }
                if (bha2 == bha.d) {
                    return (Long)this.b(bfs2);
                }
                return bdc2.long_b();
            }
            case 11: {
                return (Long)this.a(bfs2);
            }
            case 7: {
                return bdc2.long_a();
            }
            case 1: {
                string = bfs2.a(bdc2, this, clazz);
                break;
            }
            case 3: {
                return (Long)this.e(bdc2, bfs2);
            }
            default: {
                return (Long)bfs2.a(this.bfw_a(bfs2), bdc2);
            }
        }
        bha bha3 = this.bha_a(bfs2, string);
        if (bha3 == bha.c) {
            return (Long)this.a(bfs2);
        }
        if (bha3 == bha.d) {
            return (Long)this.b(bfs2);
        }
        if (this.boolean_a(bfs2, string = string.trim())) {
            return (Long)this.a(bfs2);
        }
        return this.long_a(bfs2, string);
    }

    @Override
    protected final float float_a(bdc bdc2, bfs bfs2) {
        String string;
        switch (bdc2.int_a()) {
            case 6: {
                string = bdc2.java_lang_String_e();
                break;
            }
            case 7: 
            case 8: {
                return bdc2.float_a();
            }
            case 11: {
                this.void_b(bfs2);
                return 0.0f;
            }
            case 1: {
                string = bfs2.a(bdc2, this, Float.TYPE);
                break;
            }
            case 3: {
                if (bfs2.a(bfu.r)) {
                    bdc2.bdf_a();
                    float f2 = this.float_a(bdc2, bfs2);
                    this.b(bdc2, bfs2);
                    return f2;
                }
            }
            default: {
                return ((Number)bfs2.a(Float.TYPE, bdc2)).floatValue();
            }
        }
        Object object = this.java_lang_Float_a(string);
        if (object != null) {
            return object.floatValue();
        }
        object = this.a(bfs2, string, btq.f, Float.TYPE);
        if (object == bha.c) {
            return 0.0f;
        }
        if (object == bha.d) {
            return 0.0f;
        }
        if (this.c(string = string.trim())) {
            this.void_a(bfs2, string);
            return 0.0f;
        }
        return this.float_a(bfs2, string);
    }

    protected final float float_a(bfs bfs2, String string) {
        try {
            return Float.parseFloat(string);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            Number number = (Number)bfs2.b(Float.TYPE, string, "not a valid `float` value", new Object[0]);
            return this.a(number).floatValue();
        }
    }

    protected Float java_lang_Float_a(String string) {
        if (!string.isEmpty()) {
            switch (string.charAt(0)) {
                case 'I': {
                    if (!this.e(string)) break;
                    return Float.valueOf(Float.POSITIVE_INFINITY);
                }
                case 'N': {
                    if (!this.f(string)) break;
                    return Float.valueOf(Float.NaN);
                }
                case '-': {
                    if (!this.d(string)) break;
                    return Float.valueOf(Float.NEGATIVE_INFINITY);
                }
            }
        }
        return null;
    }

    @Override
    protected final double double_a(bdc bdc2, bfs bfs2) {
        String string;
        switch (bdc2.int_a()) {
            case 6: {
                string = bdc2.java_lang_String_e();
                break;
            }
            case 7: 
            case 8: {
                return bdc2.double_a();
            }
            case 11: {
                this.void_b(bfs2);
                return 0.0;
            }
            case 1: {
                string = bfs2.a(bdc2, this, Double.TYPE);
                break;
            }
            case 3: {
                if (bfs2.a(bfu.r)) {
                    bdc2.bdf_a();
                    double d2 = this.double_a(bdc2, bfs2);
                    this.b(bdc2, bfs2);
                    return d2;
                }
            }
            default: {
                return ((Number)bfs2.a(Double.TYPE, bdc2)).doubleValue();
            }
        }
        Object object = this.java_lang_Double_a(string);
        if (object != null) {
            return object;
        }
        object = this.a(bfs2, string, btq.f, Double.TYPE);
        if (object == bha.c) {
            return 0.0;
        }
        if (object == bha.d) {
            return 0.0;
        }
        if (this.c(string = string.trim())) {
            this.void_a(bfs2, string);
            return 0.0;
        }
        return this.double_a(bfs2, string);
    }

    protected final double double_a(bfs bfs2, String string) {
        try {
            return blc.double_a(string);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            Number number = (Number)bfs2.b(Double.TYPE, string, "not a valid `double` value (as String to convert)", new Object[0]);
            return this.a(number).doubleValue();
        }
    }

    protected static final double double_a(String string) {
        if ("2.2250738585072012e-308".equals(string)) {
            return Double.MIN_NORMAL;
        }
        return Double.parseDouble(string);
    }

    protected Double java_lang_Double_a(String string) {
        if (!string.isEmpty()) {
            switch (string.charAt(0)) {
                case 'I': {
                    if (!this.e(string)) break;
                    return Double.POSITIVE_INFINITY;
                }
                case 'N': {
                    if (!this.f(string)) break;
                    return Double.NaN;
                }
                case '-': {
                    if (!this.d(string)) break;
                    return Double.NEGATIVE_INFINITY;
                }
            }
        }
        return null;
    }

    @Override
    protected Date java_util_Date_a(bdc bdc2, bfs bfs2) {
        String string;
        switch (bdc2.int_a()) {
            case 6: {
                string = bdc2.java_lang_String_e();
                break;
            }
            case 7: {
                long l2;
                try {
                    l2 = bdc2.long_a();
                }
                catch (bdb | bdq bdr2) {
                    Number number = (Number)bfs2.a((Class<?>)this.var_int_b, bdc2.java_lang_Number_a(), "not a valid 64-bit `long` for creating `java.util.Date`", new Object[0]);
                    l2 = number.longValue();
                }
                return new Date(l2);
            }
            case 11: {
                return (Date)this.a(bfs2);
            }
            case 1: {
                string = bfs2.a(bdc2, this, (Class<?>)this.var_int_b);
                break;
            }
            case 3: {
                return this.c(bdc2, bfs2);
            }
            default: {
                return (Date)bfs2.a((Class<?>)this.var_int_b, bdc2);
            }
        }
        return this.a(string.trim(), bfs2);
    }

    protected Date c(bdc bdc2, bfs bfs2) {
        bha bha2 = this.bha_b(bfs2);
        boolean bl2 = bfs2.a(bfu.r);
        if (bl2 || bha2 != bha.var_bha_a) {
            bdf bdf2 = bdc2.bdf_a();
            if (bdf2 == bdf.var_bdf_e) {
                switch (bha2) {
                    case d: {
                        return (Date)this.b(bfs2);
                    }
                    case c: 
                    case b: {
                        return (Date)this.a(bfs2);
                    }
                }
            } else if (bl2) {
                Date date = this.java_util_Date_a(bdc2, bfs2);
                this.b(bdc2, bfs2);
                return date;
            }
        }
        return (Date)bfs2.a((Class<?>)this.var_int_b, bdf.var_bdf_d, bdc2, null, new Object[0]);
    }

    protected Date a(String string, bfs bfs2) {
        try {
            if (string.isEmpty()) {
                bha bha2 = this.bha_a(bfs2, string);
                switch (bha2) {
                    case d: {
                        return new Date(0L);
                    }
                }
                return null;
            }
            if (this.c(string)) {
                return null;
            }
            return bfs2.java_util_Date_a(string);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            return (Date)bfs2.b((Class<?>)this.var_int_b, string, "not a valid representation (error: %s)", buk.java_lang_String_a(illegalArgumentException));
        }
    }

    @Override
    protected final String java_lang_String_a(bdc bdc2, bfs bfs2) {
        if (bdc2.boolean_a(bdf.h)) {
            return bdc2.java_lang_String_e();
        }
        if (bdc2.boolean_a(bdf.g)) {
            Object object = bdc2.java_lang_Object_a();
            if (object instanceof byte[]) {
                return bfs2.bcq_a().a((byte[])object, false);
            }
            if (object == null) {
                return null;
            }
            return object.toString();
        }
        if (bdc2.boolean_a(bdf.var_bdf_b)) {
            return bfs2.a(bdc2, this, (Class<?>)this.var_int_b);
        }
        String string = bdc2.java_lang_String_f();
        if (string != null) {
            return string;
        }
        return (String)bfs2.a(String.class, bdc2);
    }

    protected boolean c(String string) {
        return "null".equals(string);
    }

    protected final boolean d(String string) {
        return "-Infinity".equals(string) || "-INF".equals(string);
    }

    protected final boolean e(String string) {
        return "Infinity".equals(string) || "INF".equals(string);
    }

    protected final boolean f(String string) {
        return "NaN".equals(string);
    }

    protected static final boolean g(String string) {
        int n2 = string.length();
        for (int i2 = 0; i2 < n2; ++i2) {
            if (string.charAt(i2) <= ' ') continue;
            return false;
        }
        return true;
    }

    protected bha bha_a(bfs bfs2, String string) {
        return this.a(bfs2, string, this.btq_a(), this.a());
    }

    protected bha a(bfs bfs2, String string, btq btq2, Class<?> clazz) {
        if (string.isEmpty()) {
            bha bha2 = bfs2.a(btq2, clazz, bhe.j);
            return this.a(bfs2, bha2, clazz, string, "empty String (\"\")");
        }
        if (blc.g(string)) {
            bha bha3 = bfs2.a(btq2, clazz, bha.var_bha_a);
            return this.a(bfs2, bha3, clazz, string, "blank String (all whitespace)");
        }
        if (bfs2.a(bdj.c)) {
            return bha.b;
        }
        bha bha4 = bfs2.a(btq2, clazz, bhe.f);
        if (bha4 == bha.var_bha_a) {
            bfs2.a(this, "Cannot coerce String value (\"%s\") to %s (but might if coercion using `CoercionConfig` was enabled)", string, this.java_lang_String_a());
        }
        return bha4;
    }

    @Override
    protected bha bha_a(bdc bdc2, bfs bfs2, Class<?> clazz) {
        bha bha2 = bfs2.a(btq.f, clazz, bhe.d);
        if (bha2 == bha.var_bha_a) {
            return this.a(bfs2, bha2, clazz, bdc2.java_lang_Number_a(), "Floating-point value (" + bdc2.java_lang_String_e() + ")");
        }
        return bha2;
    }

    protected Boolean b(bdc bdc2, bfs bfs2, Class<?> clazz) {
        bha bha2 = bfs2.a(btq.h, clazz, bhe.c);
        switch (bha2) {
            case var_bha_a: {
                this.a(bfs2, bha2, clazz, bdc2.java_lang_Number_a(), "Integer value (" + bdc2.java_lang_String_e() + ")");
                return Boolean.FALSE;
            }
            case c: {
                return null;
            }
            case d: {
                return Boolean.FALSE;
            }
        }
        if (bdc2.bdc$b_a() == bdc.b.var_bdc$b_a) {
            return bdc2.int_e() != 0;
        }
        return !"0".equals(bdc2.java_lang_String_e());
    }

    protected bha a(bfs bfs2, bha bha2, Class<?> clazz, Object object, String string) {
        if (bha2 == bha.var_bha_a) {
            bfs2.a(this, clazz, object, "Cannot coerce %s to %s (but could if coercion was enabled using `CoercionConfig`)", string, this.java_lang_String_a());
        }
        return bha2;
    }

    protected boolean boolean_a(bfs bfs2, String string) {
        if (this.c(string)) {
            if (!bfs2.a(bgd.B)) {
                this.a(bfs2, true, bgd.B, "String \"null\"");
            }
            return true;
        }
        return false;
    }

    protected Object t(bdc bdc2, bfs bfs2) {
        int n2 = bfs2.int_a();
        if (bfu.b.a(n2)) {
            return bdc2.java_lang_Number_a();
        }
        if (bfu.c.a(n2)) {
            return bdc2.long_a();
        }
        return bdc2.java_lang_Number_a();
    }

    protected final void void_b(bfs bfs2) {
        if (bfs2.a(bfu.f)) {
            bfs2.a(this, "Cannot coerce `null` to %s (disable `DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES` to allow)", this.java_lang_String_a());
        }
    }

    protected final void void_a(bfs bfs2, String string) {
        boolean bl2;
        Enum enum_;
        if (!bfs2.a(bgd.B)) {
            enum_ = bgd.B;
            bl2 = true;
        } else if (bfs2.a(bfu.f)) {
            enum_ = bfu.f;
            bl2 = false;
        } else {
            return;
        }
        String string2 = string.isEmpty() ? "empty String (\"\")" : String.format("String \"%s\"", string);
        this.a(bfs2, bl2, enum_, string2);
    }

    protected void a(bfs bfs2, boolean bl2, Enum<?> enum_, String string) {
        String string2 = bl2 ? "enable" : "disable";
        bfs2.a(this, "Cannot coerce %s to Null value as %s (%s `%s.%s` to allow)", string, this.java_lang_String_a(), string2, enum_.getDeclaringClass().getSimpleName(), enum_.name());
    }

    @Override
    protected String java_lang_String_a() {
        String string;
        boolean bl2;
        bfw bfw2 = this.bfw_a();
        if (bfw2 != null && !bfw2.k()) {
            bl2 = bfw2.m() || bfw2.a() != false;
            string = buk.a(bfw2);
        } else {
            Class<?> clazz = this.a();
            bl2 = clazz.isArray() || Collection.class.isAssignableFrom(clazz) || Map.class.isAssignableFrom(clazz);
            string = buk.b(clazz);
        }
        if (bl2) {
            return "element of " + string;
        }
        return string + " value";
    }

    protected bfx<Object> a(bfs bfs2, bfw bfw2, bfp bfp2) {
        return bfs2.a(bfw2, bfp2);
    }

    protected final boolean h(String string) {
        int n2 = string.length();
        if (n2 > 0) {
            int n3;
            char c2 = string.charAt(0);
            if (c2 == '-' || c2 == '+') {
                if (n2 == 1) {
                    return false;
                }
                n3 = 1;
            } else {
                n3 = 0;
            }
            while (n3 < n2) {
                char c3 = string.charAt(n3);
                if (c3 > '9' || c3 < '0') {
                    return false;
                }
                ++n3;
            }
            return true;
        }
        return false;
    }

    protected bfx<?> a(bfs bfs2, bfp bfp2, bfx<?> bfx2) {
        Object object;
        bmn bmn2;
        bfn bfn2 = bfs2.bfn_a();
        if (blc.a(bfn2, bfp2) && (bmn2 = bfp2.bmn_a()) != null && (object = bfn2.c(bmn2)) != null) {
            bum<Object, Object> bum2 = bfs2.a((bmg)bfp2.bmn_a(), object);
            bfw bfw2 = bum2.a(bfs2.btz_a());
            if (bfx2 == null) {
                bfx2 = bfs2.a(bfw2, bfp2);
            }
            return new blb<Object>(bum2, bfw2, bfx2);
        }
        return bfx2;
    }

    protected bbk.d a(bfs bfs2, bfp bfp2, Class<?> clazz) {
        if (bfp2 != null) {
            return bfp2.bbk$d_a(bfs2.bfr_a(), clazz);
        }
        return bfs2.bbk$d_a(clazz);
    }

    protected Boolean a(bfs bfs2, bfp bfp2, Class<?> clazz, bbk.a a2) {
        bbk.d d2 = this.a(bfs2, bfp2, clazz);
        if (d2 != null) {
            return d2.a(a2);
        }
        return null;
    }

    protected final bil a(bfs bfs2, bio bio2, bgi bgi2) {
        if (bio2 != null) {
            return this.a(bfs2, (bfp)bio2, bgi2.bcj_a(), (bfx<?>)bio2.bil_a());
        }
        return null;
    }

    protected bil a(bfs bfs2, bfp bfp2, bfx<?> bfx2) {
        bcj bcj2 = this.a(bfs2, bfp2);
        if (bcj2 == bcj.b) {
            return bjj.a();
        }
        if (bcj2 == bcj.c) {
            if (bfp2 == null) {
                bfw bfw2 = bfs2.bfw_a((Class<?>)bfx2.a());
                if (bfw2.m()) {
                    bfw2 = bfw2.bfw_c();
                }
                return bjk.a(bfw2);
            }
            return bjk.a(bfp2, bfp2.bfw_a().bfw_c());
        }
        bil bil2 = this.a(bfs2, bfp2, bcj2, bfx2);
        if (bil2 != null) {
            return bil2;
        }
        return bfx2;
    }

    protected bcj a(bfs bfs2, bfp bfp2) {
        if (bfp2 != null) {
            return bfp2.bgi_a().bcj_b();
        }
        return null;
    }

    protected final bil a(bfs bfs2, bfp bfp2, bcj bcj2, bfx<?> bfx2) {
        if (bcj2 == bcj.c) {
            if (bfp2 == null) {
                return bjk.a(bfs2.bfw_a((Class<?>)bfx2.a()));
            }
            return bjk.a(bfp2);
        }
        if (bcj2 == bcj.d) {
            Object object;
            if (bfx2 == null) {
                return null;
            }
            if (bfx2 instanceof bhv && !((bir)(object = ((bhv)bfx2).bir_a())).i()) {
                bfw bfw2 = bfp2.bfw_a();
                bfs2.b(bfw2, String.format("Cannot create empty instance of %s, no default Creator", bfw2));
            }
            if ((object = bfx2.buc_a()) == buc.var_buc_a) {
                return bjj.b();
            }
            if (object == buc.b) {
                return bjj.a(bfx2.b(bfs2));
            }
            return new bji(bfx2);
        }
        if (bcj2 == bcj.b) {
            return bjj.a();
        }
        return null;
    }

    @Override
    protected bha bha_a(bfs bfs2) {
        return bfs2.a(this.btq_a(), this.a(), bhe.j);
    }

    protected bha bha_b(bfs bfs2) {
        return bfs2.a(this.btq_a(), this.a(), bhe.h);
    }

    protected bha c(bfs bfs2) {
        return bfs2.a(this.btq_a(), this.a(), bha.var_bha_a);
    }

    protected void b(bdc bdc2, bfs bfs2, Object clazz, String string) {
        if (clazz == null) {
            clazz = this.a();
        }
        if (bfs2.a(bdc2, this, clazz, string)) {
            return;
        }
        bdc2.bdc_a();
    }

    @Override
    protected void void_a(bdc bdc2, bfs bfs2) {
        bfs2.a(this, bdf.var_bdf_e, "Attempted to unwrap '%s' value from an array (with `DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS`) but it contains more than one value", this.a().getName());
    }

    protected void b(bdc bdc2, bfs bfs2) {
        bdf bdf2 = bdc2.bdf_a();
        if (bdf2 != bdf.var_bdf_e) {
            this.void_a(bdc2, bfs2);
        }
    }

    protected static final boolean a(Object object, Object object2) {
        return object != null && object2 != null;
    }

    protected final boolean a(int n2) {
        return n2 < -128 || n2 > 255;
    }

    protected final boolean b(int n2) {
        return n2 < Short.MIN_VALUE || n2 > Short.MAX_VALUE;
    }

    protected final boolean a(long l2) {
        return l2 < Integer.MIN_VALUE || l2 > Integer.MAX_VALUE;
    }

    protected Number a(Number number) {
        if (number == null) {
            number = 0;
        }
        return number;
    }

    static {
        var_int_b = bfu.b.int_a() | bfu.c.int_a();
        var_int_c = bfu.r.int_a() | bfu.u.int_a();
    }
}

