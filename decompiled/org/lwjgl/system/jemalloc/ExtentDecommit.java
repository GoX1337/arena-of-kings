/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.jemalloc;

import javax.annotation.Nullable;
import org.lwjgl.system.Callback;
import org.lwjgl.system.jemalloc.ExtentDecommitI;

public abstract class ExtentDecommit
extends Callback
implements ExtentDecommitI {
    public static ExtentDecommit create(long l2) {
        ExtentDecommitI extentDecommitI = (ExtentDecommitI)Callback.get(l2);
        return extentDecommitI instanceof ExtentDecommit ? (ExtentDecommit)extentDecommitI : new Container(l2, extentDecommitI);
    }

    @Nullable
    public static ExtentDecommit createSafe(long l2) {
        return l2 == 0L ? null : ExtentDecommit.create(l2);
    }

    public static ExtentDecommit create(ExtentDecommitI extentDecommitI) {
        return extentDecommitI instanceof ExtentDecommit ? (ExtentDecommit)extentDecommitI : new Container(extentDecommitI.address(), extentDecommitI);
    }

    protected ExtentDecommit() {
        super(CIF);
    }

    ExtentDecommit(long l2) {
        super(l2);
    }

    static final class Container
    extends ExtentDecommit {
        private final ExtentDecommitI delegate;

        Container(long l2, ExtentDecommitI extentDecommitI) {
            super(l2);
            this.delegate = extentDecommitI;
        }

        @Override
        public boolean invoke(long l2, long l3, long l4, long l5, long l6, int n2) {
            return this.delegate.invoke(l2, l3, l4, l5, l6, n2);
        }
    }
}

