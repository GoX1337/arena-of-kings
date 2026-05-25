/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.jemalloc;

import javax.annotation.Nullable;
import org.lwjgl.system.Callback;
import org.lwjgl.system.jemalloc.ExtentCommitI;

public abstract class ExtentCommit
extends Callback
implements ExtentCommitI {
    public static ExtentCommit create(long l2) {
        ExtentCommitI extentCommitI = (ExtentCommitI)Callback.get(l2);
        return extentCommitI instanceof ExtentCommit ? (ExtentCommit)extentCommitI : new Container(l2, extentCommitI);
    }

    @Nullable
    public static ExtentCommit createSafe(long l2) {
        return l2 == 0L ? null : ExtentCommit.create(l2);
    }

    public static ExtentCommit create(ExtentCommitI extentCommitI) {
        return extentCommitI instanceof ExtentCommit ? (ExtentCommit)extentCommitI : new Container(extentCommitI.address(), extentCommitI);
    }

    protected ExtentCommit() {
        super(CIF);
    }

    ExtentCommit(long l2) {
        super(l2);
    }

    static final class Container
    extends ExtentCommit {
        private final ExtentCommitI delegate;

        Container(long l2, ExtentCommitI extentCommitI) {
            super(l2);
            this.delegate = extentCommitI;
        }

        @Override
        public boolean invoke(long l2, long l3, long l4, long l5, long l6, int n2) {
            return this.delegate.invoke(l2, l3, l4, l5, l6, n2);
        }
    }
}

