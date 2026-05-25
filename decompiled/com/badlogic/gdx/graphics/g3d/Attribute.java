/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d;

import com.badlogic.gdx.utils.Array;

public abstract class Attribute
implements Comparable<Attribute> {
    private static final Array<String> types = new Array();
    public final long type;
    private final int typeBit;

    public static final long getAttributeType(String string) {
        for (int i2 = 0; i2 < Attribute.types.size; ++i2) {
            if (types.get(i2).compareTo(string) != 0) continue;
            return 1L << i2;
        }
        return 0L;
    }

    public static final String getAttributeAlias(long l2) {
        int n2 = -1;
        while (l2 != 0L && ++n2 < 63 && (l2 >> n2 & 1L) == 0L) {
        }
        return n2 >= 0 && n2 < Attribute.types.size ? types.get(n2) : null;
    }

    public static final long register(String string) {
        long l2 = Attribute.getAttributeType(string);
        if (l2 > 0L) {
            return l2;
        }
        types.add(string);
        return 1L << Attribute.types.size - 1;
    }

    public Attribute(long l2) {
        this.type = l2;
        this.typeBit = Long.numberOfTrailingZeros(l2);
    }

    public abstract Attribute copy();

    protected boolean equals(Attribute attribute) {
        return attribute.hashCode() == this.hashCode();
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (object == this) {
            return true;
        }
        if (!(object instanceof Attribute)) {
            return false;
        }
        Attribute attribute = (Attribute)object;
        if (this.type != attribute.type) {
            return false;
        }
        return this.equals(attribute);
    }

    public String toString() {
        return Attribute.getAttributeAlias(this.type);
    }

    public int hashCode() {
        return 7489 * this.typeBit;
    }
}

