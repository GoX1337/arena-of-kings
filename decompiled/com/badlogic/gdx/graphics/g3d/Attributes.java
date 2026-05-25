/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d;

import com.badlogic.gdx.graphics.g3d.Attribute;
import com.badlogic.gdx.utils.Array;
import java.util.Comparator;
import java.util.Iterator;

public class Attributes
implements Comparable<Attributes>,
Iterable<Attribute>,
Comparator<Attribute> {
    protected long mask;
    protected final Array<Attribute> attributes = new Array();
    protected boolean sorted = true;

    public final void sort() {
        if (!this.sorted) {
            this.attributes.sort(this);
            this.sorted = true;
        }
    }

    public final long getMask() {
        return this.mask;
    }

    public final Attribute get(long l2) {
        if (this.has(l2)) {
            for (int i2 = 0; i2 < this.attributes.size; ++i2) {
                if (this.attributes.get((int)i2).type != l2) continue;
                return this.attributes.get(i2);
            }
        }
        return null;
    }

    public final <T extends Attribute> T get(Class<T> clazz, long l2) {
        return (T)this.get(l2);
    }

    public final Array<Attribute> get(Array<Attribute> array, long l2) {
        for (int i2 = 0; i2 < this.attributes.size; ++i2) {
            if ((this.attributes.get((int)i2).type & l2) == 0L) continue;
            array.add(this.attributes.get(i2));
        }
        return array;
    }

    public void clear() {
        this.mask = 0L;
        this.attributes.clear();
    }

    public int size() {
        return this.attributes.size;
    }

    private final void enable(long l2) {
        this.mask |= l2;
    }

    private final void disable(long l2) {
        this.mask &= l2 ^ 0xFFFFFFFFFFFFFFFFL;
    }

    public final void set(Attribute attribute) {
        int n2 = this.indexOf(attribute.type);
        if (n2 < 0) {
            this.enable(attribute.type);
            this.attributes.add(attribute);
            this.sorted = false;
        } else {
            this.attributes.set(n2, attribute);
        }
        this.sort();
    }

    public final void set(Attribute attribute, Attribute attribute2) {
        this.set(attribute);
        this.set(attribute2);
    }

    public final void set(Attribute attribute, Attribute attribute2, Attribute attribute3) {
        this.set(attribute);
        this.set(attribute2);
        this.set(attribute3);
    }

    public final void set(Attribute attribute, Attribute attribute2, Attribute attribute3, Attribute attribute4) {
        this.set(attribute);
        this.set(attribute2);
        this.set(attribute3);
        this.set(attribute4);
    }

    public final void set(Attribute ... attributeArray) {
        for (Attribute attribute : attributeArray) {
            this.set(attribute);
        }
    }

    public final void set(Iterable<Attribute> iterable) {
        for (Attribute attribute : iterable) {
            this.set(attribute);
        }
    }

    public final void remove(long l2) {
        for (int i2 = this.attributes.size - 1; i2 >= 0; --i2) {
            long l3 = this.attributes.get((int)i2).type;
            if ((l2 & l3) != l3) continue;
            this.attributes.removeIndex(i2);
            this.disable(l3);
            this.sorted = false;
        }
        this.sort();
    }

    public final boolean has(long l2) {
        return l2 != 0L && (this.mask & l2) == l2;
    }

    protected int indexOf(long l2) {
        if (this.has(l2)) {
            for (int i2 = 0; i2 < this.attributes.size; ++i2) {
                if (this.attributes.get((int)i2).type != l2) continue;
                return i2;
            }
        }
        return -1;
    }

    public final boolean same(Attributes attributes, boolean bl2) {
        if (attributes == this) {
            return true;
        }
        if (attributes == null || this.mask != attributes.mask) {
            return false;
        }
        if (!bl2) {
            return true;
        }
        this.sort();
        attributes.sort();
        for (int i2 = 0; i2 < this.attributes.size; ++i2) {
            if (this.attributes.get(i2).equals(attributes.attributes.get(i2))) continue;
            return false;
        }
        return true;
    }

    public final boolean same(Attributes attributes) {
        return this.same(attributes, false);
    }

    @Override
    public final int compare(Attribute attribute, Attribute attribute2) {
        return (int)(attribute.type - attribute2.type);
    }

    @Override
    public final Iterator<Attribute> iterator() {
        return this.attributes.iterator();
    }

    public int attributesHash() {
        this.sort();
        int n2 = this.attributes.size;
        long l2 = 71L + this.mask;
        int n3 = 1;
        for (int i2 = 0; i2 < n2; ++i2) {
            n3 = n3 * 7 & 0xFFFF;
            l2 += this.mask * (long)this.attributes.get(i2).hashCode() * (long)n3;
        }
        return (int)(l2 ^ l2 >> 32);
    }

    public int hashCode() {
        return this.attributesHash();
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Attributes)) {
            return false;
        }
        if (object == this) {
            return true;
        }
        return this.same((Attributes)object, true);
    }

    @Override
    public int compareTo(Attributes attributes) {
        if (attributes == this) {
            return 0;
        }
        if (this.mask != attributes.mask) {
            return this.mask < attributes.mask ? -1 : 1;
        }
        this.sort();
        attributes.sort();
        for (int i2 = 0; i2 < this.attributes.size; ++i2) {
            int n2 = this.attributes.get(i2).compareTo(attributes.attributes.get(i2));
            if (n2 == 0) continue;
            return n2 < 0 ? -1 : (n2 > 0 ? 1 : 0);
        }
        return 0;
    }
}

