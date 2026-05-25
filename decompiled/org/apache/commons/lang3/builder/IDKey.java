/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3.builder;

final class IDKey {
    private final Object value;
    private final int id;

    IDKey(Object object) {
        this.id = System.identityHashCode(object);
        this.value = object;
    }

    public int hashCode() {
        return this.id;
    }

    public boolean equals(Object object) {
        if (!(object instanceof IDKey)) {
            return false;
        }
        IDKey iDKey = (IDKey)object;
        if (this.id != iDKey.id) {
            return false;
        }
        return this.value == iDKey.value;
    }
}

