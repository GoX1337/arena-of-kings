/*
 * Decompiled with CFR 0.152.
 */
package org.junit.runner.manipulation;

import org.junit.runner.Description;
import org.junit.runner.manipulation.Filterable;

public abstract class Filter {
    public static Filter ALL = new byq();

    public static Filter matchMethodDescription(Description description) {
        return new byr(description);
    }

    public abstract boolean shouldRun(Description var1);

    public abstract String describe();

    public void apply(Object object) {
        if (!(object instanceof Filterable)) {
            return;
        }
        Filterable filterable = (Filterable)object;
        filterable.filter(this);
    }
}

