/*
 * Decompiled with CFR 0.152.
 */
package com.sun.jna.ptr;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.ByReference;

public class ByteByReference
extends ByReference {
    public ByteByReference() {
        this(0);
    }

    public ByteByReference(byte by2) {
        super(1);
        this.setValue(by2);
    }

    public void setValue(byte by2) {
        this.getPointer().setByte(0L, by2);
    }

    public byte getValue() {
        return this.getPointer().getByte(0L);
    }

    @Override
    public String toString() {
        return String.format("byte@0x%1$x=0x%2$x (%2$d)", Pointer.nativeValue(this.getPointer()), this.getValue());
    }
}

