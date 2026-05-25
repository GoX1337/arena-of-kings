/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.windows;

import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import org.lwjgl.system.Library;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.SharedLibrary;
import org.lwjgl.system.windows.WinBase;
import org.lwjgl.system.windows.WindowsUtil;

public class WindowsLibrary
extends SharedLibrary.Default {
    public static final long HINSTANCE;

    public WindowsLibrary(String string) {
        this(string, WindowsLibrary.loadLibrary(string));
    }

    public WindowsLibrary(String string, long l2) {
        super(string, l2);
    }

    private static long loadLibrary(String string) {
        long l2;
        try (MemoryStack memoryStack = MemoryStack.stackPush();){
            l2 = WinBase.LoadLibrary(memoryStack.UTF16(string));
        }
        if (l2 == 0L) {
            throw new UnsatisfiedLinkError("Failed to load library: " + string + " (error code = " + WinBase.getLastError() + ")");
        }
        return l2;
    }

    @Override
    @Nullable
    public String getPath() {
        int n2 = 256;
        ByteBuffer byteBuffer = MemoryUtil.memAlloc(n2);
        try {
            while (true) {
                int n3 = WinBase.GetModuleFileName(this.address(), byteBuffer);
                int n4 = WinBase.getLastError();
                if (n4 == 0) {
                    String string = n3 == 0 ? null : MemoryUtil.memUTF16(byteBuffer, n3);
                    return string;
                }
                if (n4 != 122) {
                    String string = null;
                    return string;
                }
                n2 = n2 * 3 / 2;
                byteBuffer = MemoryUtil.memRealloc(byteBuffer, n2);
            }
        }
        finally {
            MemoryUtil.memFree(byteBuffer);
        }
    }

    @Override
    public long getFunctionAddress(ByteBuffer byteBuffer) {
        return WinBase.GetProcAddress(this.address(), byteBuffer);
    }

    @Override
    public void free() {
        if (!WinBase.FreeLibrary(this.address())) {
            WindowsUtil.windowsThrowException("Failed to unload library: " + this.getName());
        }
    }

    static {
        try (MemoryStack memoryStack = MemoryStack.stackPush();){
            HINSTANCE = WinBase.GetModuleHandle(memoryStack.UTF16(Library.JNI_LIBRARY_NAME));
            if (HINSTANCE == 0L) {
                throw new RuntimeException("Failed to retrieve LWJGL module handle.");
            }
        }
    }
}

