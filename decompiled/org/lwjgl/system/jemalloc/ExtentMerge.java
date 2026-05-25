/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.jemalloc;

import javax.annotation.Nullable;
import org.lwjgl.system.Callback;
import org.lwjgl.system.jemalloc.ExtentMergeI;

public abstract class ExtentMerge
extends Callback
implements ExtentMergeI {
    public static ExtentMerge create(long l2) {
        ExtentMergeI extentMergeI = (ExtentMergeI)Callback.get(l2);
        return extentMergeI instanceof ExtentMerge ? (ExtentMerge)extentMergeI : new Container(l2, extentMergeI);
    }

    @Nullable
    public static ExtentMerge createSafe(long l2) {
        return l2 == 0L ? null : ExtentMerge.create(l2);
    }

    public static ExtentMerge create(ExtentMergeI extentMergeI) {
        return extentMergeI instanceof ExtentMerge ? (ExtentMerge)extentMergeI : new Container(extentMergeI.address(), extentMergeI);
    }

    protected ExtentMerge() {
        super(CIF);
    }

    ExtentMerge(long l2) {
        super(l2);
    }

    static final class Container
    extends ExtentMerge {
        private final ExtentMergeI delegate;

        Container(long l2, ExtentMergeI extentMergeI) {
            super(l2);
            this.delegate = extentMergeI;
        }

        @Override
        public boolean invoke(long l2, long l3, long l4, long l5, long l6, boolean bl2, int n2) {
            return this.delegate.invoke(l2, l3, l4, l5, l6, bl2, n2);
        }
    }
}

