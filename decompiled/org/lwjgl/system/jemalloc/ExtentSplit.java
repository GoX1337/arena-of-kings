/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.jemalloc;

import javax.annotation.Nullable;
import org.lwjgl.system.Callback;
import org.lwjgl.system.jemalloc.ExtentSplitI;

public abstract class ExtentSplit
extends Callback
implements ExtentSplitI {
    public static ExtentSplit create(long l2) {
        ExtentSplitI extentSplitI = (ExtentSplitI)Callback.get(l2);
        return extentSplitI instanceof ExtentSplit ? (ExtentSplit)extentSplitI : new Container(l2, extentSplitI);
    }

    @Nullable
    public static ExtentSplit createSafe(long l2) {
        return l2 == 0L ? null : ExtentSplit.create(l2);
    }

    public static ExtentSplit create(ExtentSplitI extentSplitI) {
        return extentSplitI instanceof ExtentSplit ? (ExtentSplit)extentSplitI : new Container(extentSplitI.address(), extentSplitI);
    }

    protected ExtentSplit() {
        super(CIF);
    }

    ExtentSplit(long l2) {
        super(l2);
    }

    static final class Container
    extends ExtentSplit {
        private final ExtentSplitI delegate;

        Container(long l2, ExtentSplitI extentSplitI) {
            super(l2);
            this.delegate = extentSplitI;
        }

        @Override
        public boolean invoke(long l2, long l3, long l4, long l5, long l6, boolean bl2, int n2) {
            return this.delegate.invoke(l2, l3, l4, l5, l6, bl2, n2);
        }
    }
}

