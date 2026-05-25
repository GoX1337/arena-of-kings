/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.jemalloc;

import javax.annotation.Nullable;
import org.lwjgl.system.Callback;
import org.lwjgl.system.jemalloc.ExtentAllocI;

public abstract class ExtentAlloc
extends Callback
implements ExtentAllocI {
    public static ExtentAlloc create(long l2) {
        ExtentAllocI extentAllocI = (ExtentAllocI)Callback.get(l2);
        return extentAllocI instanceof ExtentAlloc ? (ExtentAlloc)extentAllocI : new Container(l2, extentAllocI);
    }

    @Nullable
    public static ExtentAlloc createSafe(long l2) {
        return l2 == 0L ? null : ExtentAlloc.create(l2);
    }

    public static ExtentAlloc create(ExtentAllocI extentAllocI) {
        return extentAllocI instanceof ExtentAlloc ? (ExtentAlloc)extentAllocI : new Container(extentAllocI.address(), extentAllocI);
    }

    protected ExtentAlloc() {
        super(CIF);
    }

    ExtentAlloc(long l2) {
        super(l2);
    }

    static final class Container
    extends ExtentAlloc {
        private final ExtentAllocI delegate;

        Container(long l2, ExtentAllocI extentAllocI) {
            super(l2);
            this.delegate = extentAllocI;
        }

        @Override
        public long invoke(long l2, long l3, long l4, long l5, long l6, long l7, int n2) {
            return this.delegate.invoke(l2, l3, l4, l5, l6, l7, n2);
        }
    }
}

