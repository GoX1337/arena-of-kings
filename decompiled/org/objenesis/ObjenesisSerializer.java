/*
 * Decompiled with CFR 0.152.
 */
package org.objenesis;

import org.objenesis.ObjenesisBase;
import org.objenesis.strategy.SerializingInstantiatorStrategy;

public class ObjenesisSerializer
extends ObjenesisBase {
    public ObjenesisSerializer() {
        super(new SerializingInstantiatorStrategy());
    }

    public ObjenesisSerializer(boolean bl2) {
        super(new SerializingInstantiatorStrategy(), bl2);
    }
}

