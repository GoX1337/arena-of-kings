/*
 * Decompiled with CFR 0.152.
 */
import java.util.Objects;
import java.util.UUID;

public class btk
extends btd<UUID>
implements bqh {
    static final char[] var_char_arr_a;
    protected final Boolean var_java_lang_Boolean_a;

    public btk() {
        this((Boolean)null);
    }

    protected btk(Boolean bl2) {
        super(UUID.class);
        this.var_java_lang_Boolean_a = bl2;
    }

    @Override
    public boolean a(bgo bgo2, UUID uUID) {
        return uUID.getLeastSignificantBits() == 0L && uUID.getMostSignificantBits() == 0L;
    }

    @Override
    public bgb<?> a(bgo bgo2, bfp bfp2) {
        bbk.d d2 = this.bbk$d_a(bgo2, bfp2, this.a());
        Boolean bl2 = null;
        if (d2 != null) {
            bbk.c c2 = d2.bbk$c_a();
            if (c2 == bbk.c.k) {
                bl2 = true;
            } else if (c2 == bbk.c.i) {
                bl2 = false;
            }
        }
        if (!Objects.equals(bl2, this.var_java_lang_Boolean_a)) {
            return new btk(bl2);
        }
        return this;
    }

    @Override
    public void a(UUID uUID, bcy bcy2, bgo bgo2) {
        if (this.a(bcy2)) {
            bcy2.a(btk.a(uUID));
            return;
        }
        char[] cArray = new char[36];
        long l2 = uUID.getMostSignificantBits();
        btk.a((int)(l2 >> 32), cArray, 0);
        cArray[8] = 45;
        int n2 = (int)l2;
        btk.b(n2 >>> 16, cArray, 9);
        cArray[13] = 45;
        btk.b(n2, cArray, 14);
        cArray[18] = 45;
        long l3 = uUID.getLeastSignificantBits();
        btk.b((int)(l3 >>> 48), cArray, 19);
        cArray[23] = 45;
        btk.b((int)(l3 >>> 32), cArray, 24);
        btk.a((int)l3, cArray, 28);
        bcy2.a(cArray, 0, 36);
    }

    protected boolean a(bcy bcy2) {
        if (this.var_java_lang_Boolean_a != null) {
            return this.var_java_lang_Boolean_a;
        }
        return !(bcy2 instanceof bve) && bcy2.boolean_c();
    }

    private static void a(int n2, char[] cArray, int n3) {
        btk.b(n2 >> 16, cArray, n3);
        btk.b(n2, cArray, n3 + 4);
    }

    private static void b(int n2, char[] cArray, int n3) {
        cArray[n3] = var_char_arr_a[n2 >> 12 & 0xF];
        cArray[++n3] = var_char_arr_a[n2 >> 8 & 0xF];
        cArray[++n3] = var_char_arr_a[n2 >> 4 & 0xF];
        cArray[++n3] = var_char_arr_a[n2 & 0xF];
    }

    private static final byte[] a(UUID uUID) {
        byte[] byArray = new byte[16];
        long l2 = uUID.getMostSignificantBits();
        long l3 = uUID.getLeastSignificantBits();
        btk.a((int)(l2 >> 32), byArray, 0);
        btk.a((int)l2, byArray, 4);
        btk.a((int)(l3 >> 32), byArray, 8);
        btk.a((int)l3, byArray, 12);
        return byArray;
    }

    private static final void a(int n2, byte[] byArray, int n3) {
        byArray[n3] = (byte)(n2 >> 24);
        byArray[++n3] = (byte)(n2 >> 16);
        byArray[++n3] = (byte)(n2 >> 8);
        byArray[++n3] = (byte)n2;
    }

    static {
        var_char_arr_a = "0123456789abcdef".toCharArray();
    }
}

