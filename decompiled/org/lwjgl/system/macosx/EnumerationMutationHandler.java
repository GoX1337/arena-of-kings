/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.macosx;

import javax.annotation.Nullable;
import org.lwjgl.system.Callback;
import org.lwjgl.system.macosx.EnumerationMutationHandlerI;

public abstract class EnumerationMutationHandler
extends Callback
implements EnumerationMutationHandlerI {
    public static EnumerationMutationHandler create(long l2) {
        EnumerationMutationHandlerI enumerationMutationHandlerI = (EnumerationMutationHandlerI)Callback.get(l2);
        return enumerationMutationHandlerI instanceof EnumerationMutationHandler ? (EnumerationMutationHandler)enumerationMutationHandlerI : new Container(l2, enumerationMutationHandlerI);
    }

    @Nullable
    public static EnumerationMutationHandler createSafe(long l2) {
        return l2 == 0L ? null : EnumerationMutationHandler.create(l2);
    }

    public static EnumerationMutationHandler create(EnumerationMutationHandlerI enumerationMutationHandlerI) {
        return enumerationMutationHandlerI instanceof EnumerationMutationHandler ? (EnumerationMutationHandler)enumerationMutationHandlerI : new Container(enumerationMutationHandlerI.address(), enumerationMutationHandlerI);
    }

    protected EnumerationMutationHandler() {
        super(CIF);
    }

    EnumerationMutationHandler(long l2) {
        super(l2);
    }

    static final class Container
    extends EnumerationMutationHandler {
        private final EnumerationMutationHandlerI delegate;

        Container(long l2, EnumerationMutationHandlerI enumerationMutationHandlerI) {
            super(l2);
            this.delegate = enumerationMutationHandlerI;
        }

        @Override
        public void invoke(long l2) {
            this.delegate.invoke(l2);
        }
    }
}

