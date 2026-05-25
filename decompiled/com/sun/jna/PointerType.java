/*
 * Decompiled with CFR 0.152.
 */
package com.sun.jna;

import com.sun.jna.FromNativeContext;
import com.sun.jna.Klass;
import com.sun.jna.NativeMapped;
import com.sun.jna.Pointer;

public abstract class PointerType
implements NativeMapped {
    private Pointer pointer;

    public PointerType() {
        this.pointer = Pointer.NULL;
    }

    public PointerType(Pointer pointer) {
        this.pointer = pointer;
    }

    @Override
    public Class<?> nativeType() {
        return Pointer.class;
    }

    @Override
    public Object toNative() {
        return this.getPointer();
    }

    public Pointer getPointer() {
        return this.pointer;
    }

    public void setPointer(Pointer pointer) {
        this.pointer = pointer;
    }

    @Override
    public Object fromNative(Object object, FromNativeContext fromNativeContext) {
        if (object == null) {
            return null;
        }
        PointerType pointerType = (PointerType)Klass.newInstance(this.getClass());
        pointerType.pointer = (Pointer)object;
        return pointerType;
    }

    public int hashCode() {
        return this.pointer != null ? this.pointer.hashCode() : 0;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object instanceof PointerType) {
            Pointer pointer = ((PointerType)object).getPointer();
            if (this.pointer == null) {
                return pointer == null;
            }
            return this.pointer.equals(pointer);
        }
        return false;
    }

    public String toString() {
        return this.pointer == null ? "NULL" : this.pointer.toString() + " (" + super.toString() + ")";
    }
}

