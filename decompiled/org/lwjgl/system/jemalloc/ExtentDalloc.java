/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.jemalloc;

import javax.annotation.Nullable;
import org.lwjgl.system.Callback;
import org.lwjgl.system.jemalloc.ExtentDallocI;

public abstract class ExtentDalloc
extends Callback
implements ExtentDallocI {
    public static ExtentDalloc create(long l2) {
        ExtentDallocI extentDallocI = (ExtentDallocI)Callback.get(l2);
        return extentDallocI instanceof ExtentDalloc ? (ExtentDalloc)extentDallocI : new Container(l2, extentDallocI);
    }

    @Nullable
    public static ExtentDalloc createSafe(long l2) {
        return l2 == 0L ? null : ExtentDalloc.create(l2);
    }

    public static ExtentDalloc create(ExtentDallocI extentDallocI) {
        return extentDallocI instanceof ExtentDalloc ? (ExtentDalloc)extentDallocI : new Container(extentDallocI.address(), extentDallocI);
    }

    protected ExtentDalloc() {
        super(CIF);
    }

    ExtentDalloc(long l2) {
        super(l2);
    }

    static final class Container
    extends ExtentDalloc {
        private final ExtentDallocI delegate;

        Container(long l2, ExtentDallocI extentDallocI) {
            super(l2);
            this.delegate = extentDallocI;
        }

        @Override
        public boolean invoke(long l2, long l3, long l4, boolean bl2, int n2) {
            return this.delegate.invoke(l2, l3, l4, bl2, n2);
        }
    }
}

