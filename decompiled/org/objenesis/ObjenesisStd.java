/*
 * Decompiled with CFR 0.152.
 */
package org.objenesis;

import org.objenesis.ObjenesisBase;
import org.objenesis.strategy.StdInstantiatorStrategy;

public class ObjenesisStd
extends ObjenesisBase {
    public ObjenesisStd() {
        super(new StdInstantiatorStrategy());
    }

    public ObjenesisStd(boolean bl2) {
        super(new StdInstantiatorStrategy(), bl2);
    }
}

