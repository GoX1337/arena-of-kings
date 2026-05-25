/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.jemalloc;

import javax.annotation.Nullable;
import org.lwjgl.system.Callback;
import org.lwjgl.system.jemalloc.ExtentDestroyI;

public abstract class ExtentDestroy
extends Callback
implements ExtentDestroyI {
    public static ExtentDestroy create(long l2) {
        ExtentDestroyI extentDestroyI = (ExtentDestroyI)Callback.get(l2);
        return extentDestroyI instanceof ExtentDestroy ? (ExtentDestroy)extentDestroyI : new Container(l2, extentDestroyI);
    }

    @Nullable
    public static ExtentDestroy createSafe(long l2) {
        return l2 == 0L ? null : ExtentDestroy.create(l2);
    }

    public static ExtentDestroy create(ExtentDestroyI extentDestroyI) {
        return extentDestroyI instanceof ExtentDestroy ? (ExtentDestroy)extentDestroyI : new Container(extentDestroyI.address(), extentDestroyI);
    }

    protected ExtentDestroy() {
        super(CIF);
    }

    ExtentDestroy(long l2) {
        super(l2);
    }

    static final class Container
    extends ExtentDestroy {
        private final ExtentDestroyI delegate;

        Container(long l2, ExtentDestroyI extentDestroyI) {
            super(l2);
            this.delegate = extentDestroyI;
        }

        @Override
        public boolean invoke(long l2, long l3, long l4, boolean bl2, int n2) {
            return this.delegate.invoke(l2, l3, l4, bl2, n2);
        }
    }
}

