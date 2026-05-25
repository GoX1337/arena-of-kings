/*
 * Decompiled with CFR 0.152.
 */
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.Map;

class bfk {
    private final Object var_java_lang_Object_a = new ReferenceQueue();
    private final Map<SoftReference<bev>, Boolean> cfr_renamed_10;
    private final ReferenceQueue<bev> var_java_lang_ref_ReferenceQueue_bev__a;

    bfk() {
    }

    public static bfk bfk_a() {
        return bfk$a.a;
    }

    public SoftReference<bev> a(bev bev2) {
        SoftReference<bev> softReference = new SoftReference<bev>(bev2, (ReferenceQueue<bev>)this.var_java_lang_Object_a);
        this.var_java_lang_Object_a.put(softReference, true);
        this.void_a();
        return softReference;
    }

    private void void_a() {
        SoftReference softReference;
        while ((softReference = (SoftReference)((ReferenceQueue)this.var_java_lang_Object_a).poll()) != null) {
            this.var_java_lang_Object_a.remove(softReference);
        }
    }

    static final class a {
        static final bfk a = new bfk();
    }
}

