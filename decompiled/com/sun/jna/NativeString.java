/*
 * Decompiled with CFR 0.152.
 */
package com.sun.jna;

import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.WString;

class NativeString
implements CharSequence,
Comparable {
    static final String WIDE_STRING = "--WIDE-STRING--";
    private Pointer pointer;
    private String encoding;

    public NativeString(String string) {
        this(string, Native.getDefaultStringEncoding());
    }

    public NativeString(String string, boolean bl2) {
        this(string, bl2 ? WIDE_STRING : Native.getDefaultStringEncoding());
    }

    public NativeString(WString wString) {
        this(wString.toString(), WIDE_STRING);
    }

    public NativeString(String string, String string2) {
        if (string == null) {
            throw new NullPointerException("String must not be null");
        }
        this.encoding = string2;
        if (WIDE_STRING.equals(this.encoding)) {
            int n2 = (string.length() + 1) * Native.WCHAR_SIZE;
            this.pointer = new StringMemory(n2);
            this.pointer.setWideString(0L, string);
        } else {
            byte[] byArray = Native.getBytes(string, string2);
            this.pointer = new StringMemory(byArray.length + 1);
            this.pointer.write(0L, byArray, 0, byArray.length);
            this.pointer.setByte(byArray.length, (byte)0);
        }
    }

    public int hashCode() {
        return this.toString().hashCode();
    }

    public boolean equals(Object object) {
        if (object instanceof CharSequence) {
            return this.compareTo(object) == 0;
        }
        return false;
    }

    @Override
    public String toString() {
        boolean bl2 = WIDE_STRING.equals(this.encoding);
        return bl2 ? this.pointer.getWideString(0L) : this.pointer.getString(0L, this.encoding);
    }

    public Pointer getPointer() {
        return this.pointer;
    }

    @Override
    public char charAt(int n2) {
        return this.toString().charAt(n2);
    }

    @Override
    public int length() {
        return this.toString().length();
    }

    @Override
    public CharSequence subSequence(int n2, int n3) {
        return this.toString().subSequence(n2, n3);
    }

    public int compareTo(Object object) {
        if (object == null) {
            return 1;
        }
        return this.toString().compareTo(object.toString());
    }

    class StringMemory
    extends Memory {
        public StringMemory(long l2) {
            super(l2);
        }

        @Override
        public String toString() {
            return NativeString.this.toString();
        }
    }
}

