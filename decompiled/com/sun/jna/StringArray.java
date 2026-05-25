/*
 * Decompiled with CFR 0.152.
 */
package com.sun.jna;

import com.sun.jna.Function;
import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.NativeString;
import com.sun.jna.Pointer;
import com.sun.jna.WString;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringArray
extends Memory
implements Function.PostCallRead {
    private String encoding;
    private List<NativeString> natives = new ArrayList<NativeString>();
    private Object[] original;

    public StringArray(String[] stringArray) {
        this(stringArray, false);
    }

    public StringArray(String[] stringArray, boolean bl2) {
        this((Object[])stringArray, bl2 ? "--WIDE-STRING--" : Native.getDefaultStringEncoding());
    }

    public StringArray(String[] stringArray, String string) {
        this((Object[])stringArray, string);
    }

    public StringArray(WString[] wStringArray) {
        this(wStringArray, "--WIDE-STRING--");
    }

    private StringArray(Object[] objectArray, String string) {
        super((objectArray.length + 1) * Native.POINTER_SIZE);
        this.original = objectArray;
        this.encoding = string;
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            Pointer pointer = null;
            if (objectArray[i2] != null) {
                NativeString nativeString = new NativeString(objectArray[i2].toString(), string);
                this.natives.add(nativeString);
                pointer = nativeString.getPointer();
            }
            this.setPointer(Native.POINTER_SIZE * i2, pointer);
        }
        this.setPointer(Native.POINTER_SIZE * objectArray.length, null);
    }

    @Override
    public void read() {
        boolean bl2 = this.original instanceof WString[];
        boolean bl3 = "--WIDE-STRING--".equals(this.encoding);
        for (int i2 = 0; i2 < this.original.length; ++i2) {
            Pointer pointer = this.getPointer(i2 * Native.POINTER_SIZE);
            CharSequence charSequence = null;
            if (pointer != null) {
                String string = charSequence = bl3 ? pointer.getWideString(0L) : pointer.getString(0L, this.encoding);
                if (bl2) {
                    charSequence = new WString((String)charSequence);
                }
            }
            this.original[i2] = charSequence;
        }
    }

    @Override
    public String toString() {
        boolean bl2 = "--WIDE-STRING--".equals(this.encoding);
        String string = bl2 ? "const wchar_t*[]" : "const char*[]";
        string = string + Arrays.asList(this.original);
        return string;
    }
}

