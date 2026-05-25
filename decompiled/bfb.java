/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.ConcurrentHashMap;

public final class bfb
extends ConcurrentHashMap<String, String> {
    public static final bfb var_bfb_a;
    private final Object var_java_lang_Object_a = new Object();

    private bfb() {
        super(180, 0.8f, 4);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public String a(String string) {
        String string2 = (String)this.get(string);
        if (string2 != null) {
            return string2;
        }
        if (this.size() >= 180) {
            Object object = this.var_java_lang_Object_a;
            synchronized (object) {
                if (this.size() >= 180) {
                    this.clear();
                }
            }
        }
        string2 = string.intern();
        this.put(string2, string2);
        return string2;
    }

    static {
        var_bfb_a = new bfb();
    }
}

