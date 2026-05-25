/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.macosx;

import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import org.lwjgl.system.Checks;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.macosx.CoreFoundation;
import org.lwjgl.system.macosx.MacOSXLibrary;

public class MacOSXLibraryBundle
extends MacOSXLibrary {
    public MacOSXLibraryBundle(String string, long l2) {
        super(string, l2);
    }

    /*
     * Loose catch block
     */
    public static MacOSXLibraryBundle getWithIdentifier(String string) {
        long l2 = 0L;
        try {
            try (MemoryStack memoryStack = MemoryStack.stackPush();){
                l2 = MacOSXLibraryBundle.CString2CFString(memoryStack.UTF8(string), 0x8000100);
                long l3 = CoreFoundation.CFBundleGetBundleWithIdentifier(l2);
                if (l3 == 0L) {
                    throw new UnsatisfiedLinkError("Failed to retrieve bundle with identifier: " + string);
                }
                CoreFoundation.CFRetain(l3);
                MacOSXLibraryBundle macOSXLibraryBundle = new MacOSXLibraryBundle(string, l3);
                return macOSXLibraryBundle;
            }
            {
                catch (Throwable throwable) {
                    throw throwable;
                }
            }
        }
        finally {
            if (l2 != 0L) {
                CoreFoundation.CFRelease(l2);
            }
        }
    }

    /*
     * Loose catch block
     */
    public static MacOSXLibraryBundle create(String string) {
        long l2 = 0L;
        long l3 = 0L;
        try {
            try (MemoryStack memoryStack = MemoryStack.stackPush();){
                l2 = MacOSXLibraryBundle.CString2CFString(memoryStack.UTF8(string), 0x8000100);
                l3 = Checks.check(CoreFoundation.CFURLCreateWithFileSystemPath(0L, l2, 0L, true));
                long l4 = CoreFoundation.CFBundleCreate(0L, l3);
                if (l4 == 0L) {
                    throw new UnsatisfiedLinkError("Failed to create bundle: " + string);
                }
                MacOSXLibraryBundle macOSXLibraryBundle = new MacOSXLibraryBundle(string, l4);
                return macOSXLibraryBundle;
            }
            {
                catch (Throwable throwable) {
                    throw throwable;
                }
            }
        }
        finally {
            if (l3 != 0L) {
                CoreFoundation.CFRelease(l3);
            }
            if (l2 != 0L) {
                CoreFoundation.CFRelease(l2);
            }
        }
    }

    @Override
    @Nullable
    public String getPath() {
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public long getFunctionAddress(ByteBuffer byteBuffer) {
        long l2 = MacOSXLibraryBundle.CString2CFString(byteBuffer, 1536);
        try {
            long l3 = CoreFoundation.CFBundleGetFunctionPointerForName(this.address(), l2);
            return l3;
        }
        finally {
            CoreFoundation.CFRelease(l2);
        }
    }

    private static long CString2CFString(ByteBuffer byteBuffer, int n2) {
        return Checks.check(CoreFoundation.CFStringCreateWithCStringNoCopy(0L, byteBuffer, n2, CoreFoundation.kCFAllocatorNull));
    }

    @Override
    public void free() {
        CoreFoundation.CFRelease(this.address());
    }
}

