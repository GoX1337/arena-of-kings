/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.jemalloc;

import javax.annotation.Nullable;
import org.lwjgl.system.Callback;
import org.lwjgl.system.jemalloc.ExtentPurgeI;

public abstract class ExtentPurge
extends Callback
implements ExtentPurgeI {
    public static ExtentPurge create(long l2) {
        ExtentPurgeI extentPurgeI = (ExtentPurgeI)Callback.get(l2);
        return extentPurgeI instanceof ExtentPurge ? (ExtentPurge)extentPurgeI : new Container(l2, extentPurgeI);
    }

    @Nullable
    public static ExtentPurge createSafe(long l2) {
        return l2 == 0L ? null : ExtentPurge.create(l2);
    }

    public static ExtentPurge create(ExtentPurgeI extentPurgeI) {
        return extentPurgeI instanceof ExtentPurge ? (ExtentPurge)extentPurgeI : new Container(extentPurgeI.address(), extentPurgeI);
    }

    protected ExtentPurge() {
        super(CIF);
    }

    ExtentPurge(long l2) {
        super(l2);
    }

    static final class Container
    extends ExtentPurge {
        private final ExtentPurgeI delegate;

        Container(long l2, ExtentPurgeI extentPurgeI) {
            super(l2);
            this.delegate = extentPurgeI;
        }

        @Override
        public boolean invoke(long l2, long l3, long l4, long l5, long l6, int n2) {
            return this.delegate.invoke(l2, l3, l4, l5, l6, n2);
        }
    }
}

