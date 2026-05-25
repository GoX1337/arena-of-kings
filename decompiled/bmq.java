/*
 * Decompiled with CFR 0.152.
 */
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

public final class bmq
implements Iterable<bmo> {
    protected Map<bne, bmo> a;

    public bmq() {
    }

    public bmq(Map<bne, bmo> map) {
        this.a = map;
    }

    public bmo a(String string, Class<?>[] classArray) {
        if (this.a == null) {
            return null;
        }
        return this.a.get(new bne(string, classArray));
    }

    @Override
    public Iterator<bmo> iterator() {
        if (this.a == null) {
            return Collections.emptyIterator();
        }
        return this.a.values().iterator();
    }
}

