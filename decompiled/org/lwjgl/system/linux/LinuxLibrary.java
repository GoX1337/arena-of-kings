/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.linux;

import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.SharedLibrary;
import org.lwjgl.system.SharedLibraryUtil;
import org.lwjgl.system.linux.DynamicLinkLoader;

public class LinuxLibrary
extends SharedLibrary.Default {
    public LinuxLibrary(String string) {
        this(string, LinuxLibrary.loadLibrary(string));
    }

    public LinuxLibrary(String string, long l2) {
        super(string, l2);
    }

    private static long loadLibrary(String string) {
        long l2;
        try (MemoryStack memoryStack = MemoryStack.stackPush();){
            l2 = DynamicLinkLoader.dlopen(memoryStack.UTF8(string), 1);
        }
        if (l2 == 0L) {
            throw new UnsatisfiedLinkError("Failed to dynamically load library: " + string + "(error = " + DynamicLinkLoader.dlerror() + ")");
        }
        return l2;
    }

    @Override
    @Nullable
    public String getPath() {
        return SharedLibraryUtil.getLibraryPath(this.address());
    }

    @Override
    public long getFunctionAddress(ByteBuffer byteBuffer) {
        return DynamicLinkLoader.dlsym(this.address(), byteBuffer);
    }

    @Override
    public void free() {
        DynamicLinkLoader.dlclose(this.address());
    }
}

