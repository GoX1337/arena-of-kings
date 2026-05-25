/*
 * Decompiled with CFR 0.152.
 */
import java.lang.ref.SoftReference;

public class bew {
    private static final bfk var_bfk_a;
    protected static final ThreadLocal<SoftReference<bev>> var_java_lang_ThreadLocal_java_lang_ref_SoftReference_bev___a;

    public static bev a() {
        bev bev2;
        SoftReference<bev> softReference = (SoftReference<bev>)((ThreadLocal)((Object)var_bfk_a)).get();
        bev bev3 = bev2 = softReference == null ? null : (bev)softReference.get();
        if (bev2 == null) {
            bev2 = new bev();
            softReference = var_bfk_a != null ? var_bfk_a.a(bev2) : new SoftReference<bev>(bev2);
            ((ThreadLocal)((Object)var_bfk_a)).set(softReference);
        }
        return bev2;
    }

    static {
        boolean bl2 = false;
        try {
            bl2 = "true".equals(System.getProperty("com.fasterxml.jackson.core.util.BufferRecyclers.trackReusableBuffers"));
        }
        catch (SecurityException securityException) {
            // empty catch block
        }
        var_bfk_a = bl2 ? bfk.bfk_a() : null;
        var_bfk_a = new ThreadLocal();
    }
}

