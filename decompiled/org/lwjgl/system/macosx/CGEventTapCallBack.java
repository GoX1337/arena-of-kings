/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.macosx;

import javax.annotation.Nullable;
import org.lwjgl.system.Callback;
import org.lwjgl.system.macosx.CGEventTapCallBackI;

public abstract class CGEventTapCallBack
extends Callback
implements CGEventTapCallBackI {
    public static CGEventTapCallBack create(long l2) {
        CGEventTapCallBackI cGEventTapCallBackI = (CGEventTapCallBackI)Callback.get(l2);
        return cGEventTapCallBackI instanceof CGEventTapCallBack ? (CGEventTapCallBack)cGEventTapCallBackI : new Container(l2, cGEventTapCallBackI);
    }

    @Nullable
    public static CGEventTapCallBack createSafe(long l2) {
        return l2 == 0L ? null : CGEventTapCallBack.create(l2);
    }

    public static CGEventTapCallBack create(CGEventTapCallBackI cGEventTapCallBackI) {
        return cGEventTapCallBackI instanceof CGEventTapCallBack ? (CGEventTapCallBack)cGEventTapCallBackI : new Container(cGEventTapCallBackI.address(), cGEventTapCallBackI);
    }

    protected CGEventTapCallBack() {
        super(CIF);
    }

    CGEventTapCallBack(long l2) {
        super(l2);
    }

    static final class Container
    extends CGEventTapCallBack {
        private final CGEventTapCallBackI delegate;

        Container(long l2, CGEventTapCallBackI cGEventTapCallBackI) {
            super(l2);
            this.delegate = cGEventTapCallBackI;
        }

        @Override
        public long invoke(long l2, int n2, long l3, long l4) {
            return this.delegate.invoke(l2, n2, l3, l4);
        }
    }
}

