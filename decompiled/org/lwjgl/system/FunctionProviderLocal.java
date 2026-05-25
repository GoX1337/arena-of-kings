/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system;

import java.nio.ByteBuffer;
import org.lwjgl.system.FunctionProvider;
import org.lwjgl.system.MemoryStack;

public interface FunctionProviderLocal
extends FunctionProvider {
    default public long getFunctionAddress(long l2, CharSequence charSequence) {
        try (MemoryStack memoryStack = MemoryStack.stackPush();){
            long l3 = this.getFunctionAddress(l2, memoryStack.ASCII(charSequence));
            return l3;
        }
    }

    public long getFunctionAddress(long var1, ByteBuffer var3);
}

