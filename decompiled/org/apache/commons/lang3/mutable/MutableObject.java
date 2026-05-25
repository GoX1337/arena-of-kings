/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3.mutable;

import java.io.Serializable;
import org.apache.commons.lang3.mutable.Mutable;

public class MutableObject<T>
implements Serializable,
Mutable<T> {
    private static final long serialVersionUID = 86241875189L;
    private T value;

    public MutableObject() {
    }

    public MutableObject(T t2) {
        this.value = t2;
    }

    @Override
    public T getValue() {
        return this.value;
    }

    @Override
    public void setValue(T t2) {
        this.value = t2;
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (this.getClass() == object.getClass()) {
            MutableObject mutableObject = (MutableObject)object;
            return this.value.equals(mutableObject.value);
        }
        return false;
    }

    public int hashCode() {
        return this.value == null ? 0 : this.value.hashCode();
    }

    public String toString() {
        return this.value == null ? "null" : this.value.toString();
    }
}

