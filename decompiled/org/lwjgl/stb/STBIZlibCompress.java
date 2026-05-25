/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.stb;

import javax.annotation.Nullable;
import org.lwjgl.stb.STBIZlibCompressI;
import org.lwjgl.system.Callback;

public abstract class STBIZlibCompress
extends Callback
implements STBIZlibCompressI {
    public static STBIZlibCompress create(long l2) {
        STBIZlibCompressI sTBIZlibCompressI = (STBIZlibCompressI)Callback.get(l2);
        return sTBIZlibCompressI instanceof STBIZlibCompress ? (STBIZlibCompress)sTBIZlibCompressI : new Container(l2, sTBIZlibCompressI);
    }

    @Nullable
    public static STBIZlibCompress createSafe(long l2) {
        return l2 == 0L ? null : STBIZlibCompress.create(l2);
    }

    public static STBIZlibCompress create(STBIZlibCompressI sTBIZlibCompressI) {
        return sTBIZlibCompressI instanceof STBIZlibCompress ? (STBIZlibCompress)sTBIZlibCompressI : new Container(sTBIZlibCompressI.address(), sTBIZlibCompressI);
    }

    protected STBIZlibCompress() {
        super(CIF);
    }

    STBIZlibCompress(long l2) {
        super(l2);
    }

    static final class Container
    extends STBIZlibCompress {
        private final STBIZlibCompressI delegate;

        Container(long l2, STBIZlibCompressI sTBIZlibCompressI) {
            super(l2);
            this.delegate = sTBIZlibCompressI;
        }

        @Override
        public long invoke(long l2, int n2, long l3, int n3) {
            return this.delegate.invoke(l2, n2, l3, n3);
        }
    }
}

