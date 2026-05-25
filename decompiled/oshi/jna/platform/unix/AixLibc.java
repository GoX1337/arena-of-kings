/*
 * Decompiled with CFR 0.152.
 */
package oshi.jna.platform.unix;

import com.sun.jna.Native;
import oshi.jna.platform.unix.CLibrary;

public interface AixLibc
extends CLibrary {
    public static final AixLibc INSTANCE = Native.load("c", AixLibc.class);
}

