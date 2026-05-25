/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.inject.Key
 */
package com.google.gwt.inject.rebind.binding;

import com.google.inject.Key;
import java.util.Collections;
import java.util.Set;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class RequiredKeys {
    private final Set<Key<?>> requiredKeys;
    private final Set<Key<?>> optionalKeys;

    public RequiredKeys(Set<Key<?>> set, Set<Key<?>> set2) {
        this.requiredKeys = Collections.unmodifiableSet(set);
        this.optionalKeys = Collections.unmodifiableSet(set2);
    }

    public RequiredKeys(Set<Key<?>> set) {
        this(set, Collections.emptySet());
    }

    public Set<Key<?>> getRequiredKeys() {
        return this.requiredKeys;
    }

    public Set<Key<?>> getOptionalKeys() {
        return this.optionalKeys;
    }
}

