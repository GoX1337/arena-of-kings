/*
 * Decompiled with CFR 0.152.
 */
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public abstract class btx
extends bfw
implements bga {
    private static final bty var_bty_b;
    private static final bfw[] var_bfw_arr_b;
    protected final bfw c;
    protected final bfw[] var_bfw_arr_a;
    protected final bty var_bty_a;
    volatile transient String var_java_lang_String_a;

    protected btx(Class<?> clazz, bty bty2, bfw bfw2, bfw[] bfwArray, int n2, Object object, Object object2, boolean bl2) {
        super(clazz, n2, object, object2, bl2);
        this.var_bty_a = bty2 == null ? var_bty_b : bty2;
        this.c = bfw2;
        this.var_bfw_arr_a = bfwArray;
    }

    @Override
    public String java_lang_String_a() {
        String string = this.var_java_lang_String_a;
        if (string == null) {
            string = this.java_lang_String_c();
        }
        return string;
    }

    protected String java_lang_String_c() {
        return this.var_bfw_arr_a.getName();
    }

    @Override
    public bty bty_a() {
        return this.var_bty_a;
    }

    @Override
    public int int_a() {
        return this.var_bty_a.int_a();
    }

    @Override
    public bfw a(int n2) {
        return this.var_bty_a.a(n2);
    }

    @Override
    public bfw bfw_e() {
        return this.c;
    }

    @Override
    public List<bfw> a() {
        if (this.var_bfw_arr_a == null) {
            return Collections.emptyList();
        }
        switch (this.var_bfw_arr_a.length) {
            case 0: {
                return Collections.emptyList();
            }
            case 1: {
                return Collections.singletonList(this.var_bfw_arr_a[0]);
            }
        }
        return Arrays.asList(this.var_bfw_arr_a);
    }

    @Override
    public final bfw bfw_a(Class<?> clazz) {
        bfw bfw2;
        if (clazz == this.var_bfw_arr_a) {
            return this;
        }
        if (clazz.isInterface() && this.var_bfw_arr_a != null) {
            int n2 = this.var_bfw_arr_a.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                bfw bfw3 = this.var_bfw_arr_a[i2].bfw_a(clazz);
                if (bfw3 == null) continue;
                return bfw3;
            }
        }
        if (this.c != null && (bfw2 = this.c.bfw_a(clazz)) != null) {
            return bfw2;
        }
        return null;
    }

    @Override
    public void a(bcy bcy2, bgo bgo2, bog bog2) {
        beu beu2 = new beu(this, bdf.h);
        bog2.a(bcy2, beu2);
        this.a(bcy2, bgo2);
        bog2.b(bcy2, beu2);
    }

    @Override
    public void a(bcy bcy2, bgo bgo2) {
        bcy2.b(this.java_lang_String_a());
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    protected static StringBuilder a(Class<?> clazz, StringBuilder stringBuilder, boolean bl2) {
        if (clazz.isPrimitive()) {
            if (clazz == Boolean.TYPE) {
                stringBuilder.append('Z');
                return stringBuilder;
            } else if (clazz == Byte.TYPE) {
                stringBuilder.append('B');
                return stringBuilder;
            } else if (clazz == Short.TYPE) {
                stringBuilder.append('S');
                return stringBuilder;
            } else if (clazz == Character.TYPE) {
                stringBuilder.append('C');
                return stringBuilder;
            } else if (clazz == Integer.TYPE) {
                stringBuilder.append('I');
                return stringBuilder;
            } else if (clazz == Long.TYPE) {
                stringBuilder.append('J');
                return stringBuilder;
            } else if (clazz == Float.TYPE) {
                stringBuilder.append('F');
                return stringBuilder;
            } else if (clazz == Double.TYPE) {
                stringBuilder.append('D');
                return stringBuilder;
            } else {
                if (clazz != Void.TYPE) throw new IllegalStateException("Unrecognized primitive type: " + clazz.getName());
                stringBuilder.append('V');
            }
            return stringBuilder;
        } else {
            stringBuilder.append('L');
            String string = clazz.getName();
            int n2 = string.length();
            for (int i2 = 0; i2 < n2; ++i2) {
                char c2 = string.charAt(i2);
                if (c2 == '.') {
                    c2 = '/';
                }
                stringBuilder.append(c2);
            }
            if (!bl2) return stringBuilder;
            stringBuilder.append(';');
        }
        return stringBuilder;
    }

    static {
        var_bty_b = bty.bty_a();
        var_bfw_arr_b = new bfw[0];
    }
}

