/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.asm;

import com.esotericsoftware.asm.ByteVector;

public class TypePath {
    public static final int ARRAY_ELEMENT = 0;
    public static final int INNER_TYPE = 1;
    public static final int WILDCARD_BOUND = 2;
    public static final int TYPE_ARGUMENT = 3;
    byte[] a;
    int b;

    TypePath(byte[] byArray, int n2) {
        this.a = byArray;
        this.b = n2;
    }

    public int getLength() {
        return this.a[this.b];
    }

    public int getStep(int n2) {
        return this.a[this.b + 2 * n2 + 1];
    }

    public int getStepArgument(int n2) {
        return this.a[this.b + 2 * n2 + 2];
    }

    public static TypePath fromString(String string) {
        if (string == null || string.length() == 0) {
            return null;
        }
        int n2 = string.length();
        ByteVector byteVector = new ByteVector(n2);
        byteVector.putByte(0);
        int n3 = 0;
        while (n3 < n2) {
            char c2;
            if ((c2 = string.charAt(n3++)) == '[') {
                byteVector.a(0, 0);
                continue;
            }
            if (c2 == '.') {
                byteVector.a(1, 0);
                continue;
            }
            if (c2 == '*') {
                byteVector.a(2, 0);
                continue;
            }
            if (c2 < '0' || c2 > '9') continue;
            int n4 = c2 - 48;
            while (n3 < n2 && (c2 = string.charAt(n3)) >= '0' && c2 <= '9') {
                n4 = n4 * 10 + c2 - 48;
                ++n3;
            }
            if (n3 < n2 && string.charAt(n3) == ';') {
                ++n3;
            }
            byteVector.a(3, n4);
        }
        byteVector.a[0] = (byte)(byteVector.b / 2);
        return new TypePath(byteVector.a, 0);
    }

    public String toString() {
        int n2 = this.getLength();
        StringBuffer stringBuffer = new StringBuffer(n2 * 2);
        block6: for (int i2 = 0; i2 < n2; ++i2) {
            switch (this.getStep(i2)) {
                case 0: {
                    stringBuffer.append('[');
                    continue block6;
                }
                case 1: {
                    stringBuffer.append('.');
                    continue block6;
                }
                case 2: {
                    stringBuffer.append('*');
                    continue block6;
                }
                case 3: {
                    stringBuffer.append(this.getStepArgument(i2)).append(';');
                    continue block6;
                }
                default: {
                    stringBuffer.append('_');
                }
            }
        }
        return stringBuffer.toString();
    }
}

