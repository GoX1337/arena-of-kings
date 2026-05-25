/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system.macosx;

import org.lwjgl.system.APIUtil;
import org.lwjgl.system.SharedLibrary;
import org.lwjgl.system.macosx.MacOSXLibraryBundle;
import org.lwjgl.system.macosx.MacOSXLibraryDL;

public abstract class MacOSXLibrary
extends SharedLibrary.Default {
    protected MacOSXLibrary(String string, long l2) {
        super(string, l2);
    }

    public static MacOSXLibrary getWithIdentifier(String string) {
        APIUtil.apiLog("Loading library: " + string);
        MacOSXLibraryBundle macOSXLibraryBundle = MacOSXLibraryBundle.getWithIdentifier(string);
        APIUtil.apiLog("\tSuccess");
        return macOSXLibraryBundle;
    }

    public static MacOSXLibrary create(String string) {
        return string.endsWith(".framework") ? MacOSXLibraryBundle.create(string) : new MacOSXLibraryDL(string);
    }
}

