/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3.concurrent;

import java.util.Objects;
import org.apache.commons.lang3.concurrent.ConcurrentInitializer;

public class ConstantInitializer<T>
implements ConcurrentInitializer<T> {
    private static final String FMT_TO_STRING = "ConstantInitializer@%d [ object = %s ]";
    private final T object;

    public ConstantInitializer(T t2) {
        this.object = t2;
    }

    public final T getObject() {
        return this.object;
    }

    @Override
    public T get() {
        return this.getObject();
    }

    public int hashCode() {
        return this.getObject() != null ? this.getObject().hashCode() : 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof ConstantInitializer)) {
            return false;
        }
        ConstantInitializer constantInitializer = (ConstantInitializer)object;
        return Objects.equals(this.getObject(), constantInitializer.getObject());
    }

    public String toString() {
        return String.format(FMT_TO_STRING, System.identityHashCode(this), String.valueOf(this.getObject()));
    }
}

