/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;

public class buq<K, V>
implements bus<K, V>,
Serializable {
    protected final transient int var_int_a;
    protected final transient ConcurrentHashMap<K, V> cfr_renamed_45;

    public buq(int n2, int n3) {
        this.var_int_a = (int)new ConcurrentHashMap(n2, 0.8f, 4);
        this.var_int_a = n3;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public V a(K k2, V v2) {
        if (this.var_int_a.size() >= this.var_int_a) {
            buq buq2 = this;
            synchronized (buq2) {
                if (this.var_int_a.size() >= this.var_int_a) {
                    this.a();
                }
            }
        }
        return this.var_int_a.put(k2, v2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public V b(K k2, V v2) {
        if (this.var_int_a.size() >= this.var_int_a) {
            buq buq2 = this;
            synchronized (buq2) {
                if (this.var_int_a.size() >= this.var_int_a) {
                    this.a();
                }
            }
        }
        return this.var_int_a.putIfAbsent(k2, v2);
    }

    @Override
    public V a(Object object) {
        return this.var_int_a.get(object);
    }

    public void a() {
        this.var_int_a.clear();
    }
}

