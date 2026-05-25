/*
 * Decompiled with CFR 0.152.
 */
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class ayi<K, V>
extends LinkedHashMap<K, V> {
    public V a(int n2) {
        Map.Entry<K, V> entry = this.a(n2);
        if (entry == null) {
            return null;
        }
        return entry.getValue();
    }

    public Map.Entry<K, V> a(int n2) {
        Set set = this.entrySet();
        int n3 = 0;
        for (Map.Entry entry : set) {
            if (n3++ != n2) continue;
            return entry;
        }
        return null;
    }
}

