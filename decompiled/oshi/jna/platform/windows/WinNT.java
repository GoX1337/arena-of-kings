/*
 * Decompiled with CFR 0.152.
 */
package oshi.jna.platform.windows;

import com.sun.jna.Structure;

public interface WinNT
extends com.sun.jna.platform.win32.WinNT {

    @Structure.FieldOrder(value={"TokenIsElevated"})
    public static class TOKEN_ELEVATION
    extends Structure {
        public int TokenIsElevated;
    }
}

