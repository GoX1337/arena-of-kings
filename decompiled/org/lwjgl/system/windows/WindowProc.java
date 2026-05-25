/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.windows;

import javax.annotation.Nullable;
import org.lwjgl.system.Callback;
import org.lwjgl.system.windows.WindowProcI;

public abstract class WindowProc
extends Callback
implements WindowProcI {
    public static WindowProc create(long l2) {
        WindowProcI windowProcI = (WindowProcI)Callback.get(l2);
        return windowProcI instanceof WindowProc ? (WindowProc)windowProcI : new Container(l2, windowProcI);
    }

    @Nullable
    public static WindowProc createSafe(long l2) {
        return l2 == 0L ? null : WindowProc.create(l2);
    }

    public static WindowProc create(WindowProcI windowProcI) {
        return windowProcI instanceof WindowProc ? (WindowProc)windowProcI : new Container(windowProcI.address(), windowProcI);
    }

    protected WindowProc() {
        super(CIF);
    }

    WindowProc(long l2) {
        super(l2);
    }

    static final class Container
    extends WindowProc {
        private final WindowProcI delegate;

        Container(long l2, WindowProcI windowProcI) {
            super(l2);
            this.delegate = windowProcI;
        }

        @Override
        public long invoke(long l2, int n2, long l3, long l4) {
            return this.delegate.invoke(l2, n2, l3, l4);
        }
    }
}

