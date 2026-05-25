/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.asm;

public class ByteVector {
    byte[] a;
    int b;

    public ByteVector() {
        this.a = new byte[64];
    }

    public ByteVector(int n2) {
        this.a = new byte[n2];
    }

    public ByteVector putByte(int n2) {
        int n3 = this.b;
        if (n3 + 1 > this.a.length) {
            this.a(1);
        }
        this.a[n3++] = (byte)n2;
        this.b = n3;
        return this;
    }

    ByteVector a(int n2, int n3) {
        int n4 = this.b;
        if (n4 + 2 > this.a.length) {
            this.a(2);
        }
        byte[] byArray = this.a;
        byArray[n4++] = (byte)n2;
        byArray[n4++] = (byte)n3;
        this.b = n4;
        return this;
    }

    public ByteVector putShort(int n2) {
        int n3 = this.b;
        if (n3 + 2 > this.a.length) {
            this.a(2);
        }
        byte[] byArray = this.a;
        byArray[n3++] = (byte)(n2 >>> 8);
        byArray[n3++] = (byte)n2;
        this.b = n3;
        return this;
    }

    ByteVector b(int n2, int n3) {
        int n4 = this.b;
        if (n4 + 3 > this.a.length) {
            this.a(3);
        }
        byte[] byArray = this.a;
        byArray[n4++] = (byte)n2;
        byArray[n4++] = (byte)(n3 >>> 8);
        byArray[n4++] = (byte)n3;
        this.b = n4;
        return this;
    }

    public ByteVector putInt(int n2) {
        int n3 = this.b;
        if (n3 + 4 > this.a.length) {
            this.a(4);
        }
        byte[] byArray = this.a;
        byArray[n3++] = (byte)(n2 >>> 24);
        byArray[n3++] = (byte)(n2 >>> 16);
        byArray[n3++] = (byte)(n2 >>> 8);
        byArray[n3++] = (byte)n2;
        this.b = n3;
        return this;
    }

    public ByteVector putLong(long l2) {
        int n2 = this.b;
        if (n2 + 8 > this.a.length) {
            this.a(8);
        }
        byte[] byArray = this.a;
        int n3 = (int)(l2 >>> 32);
        byArray[n2++] = (byte)(n3 >>> 24);
        byArray[n2++] = (byte)(n3 >>> 16);
        byArray[n2++] = (byte)(n3 >>> 8);
        byArray[n2++] = (byte)n3;
        n3 = (int)l2;
        byArray[n2++] = (byte)(n3 >>> 24);
        byArray[n2++] = (byte)(n3 >>> 16);
        byArray[n2++] = (byte)(n3 >>> 8);
        byArray[n2++] = (byte)n3;
        this.b = n2;
        return this;
    }

    public ByteVector putUTF8(String string) {
        int n2 = string.length();
        if (n2 > 65535) {
            throw new IllegalArgumentException();
        }
        int n3 = this.b;
        if (n3 + 2 + n2 > this.a.length) {
            this.a(2 + n2);
        }
        byte[] byArray = this.a;
        byArray[n3++] = (byte)(n2 >>> 8);
        byArray[n3++] = (byte)n2;
        for (int i2 = 0; i2 < n2; ++i2) {
            char c2 = string.charAt(i2);
            if (c2 < '\u0001' || c2 > '\u007f') {
                this.b = n3;
                return this.c(string, i2, 65535);
            }
            byArray[n3++] = (byte)c2;
        }
        this.b = n3;
        return this;
    }

    ByteVector c(String string, int n2, int n3) {
        char c2;
        int n4;
        int n5 = string.length();
        int n6 = n2;
        for (n4 = n2; n4 < n5; ++n4) {
            c2 = string.charAt(n4);
            if (c2 >= '\u0001' && c2 <= '\u007f') {
                ++n6;
                continue;
            }
            if (c2 > '\u07ff') {
                n6 += 3;
                continue;
            }
            n6 += 2;
        }
        if (n6 > n3) {
            throw new IllegalArgumentException();
        }
        n4 = this.b - n2 - 2;
        if (n4 >= 0) {
            this.a[n4] = (byte)(n6 >>> 8);
            this.a[n4 + 1] = (byte)n6;
        }
        if (this.b + n6 - n2 > this.a.length) {
            this.a(n6 - n2);
        }
        int n7 = this.b;
        for (int i2 = n2; i2 < n5; ++i2) {
            c2 = string.charAt(i2);
            if (c2 >= '\u0001' && c2 <= '\u007f') {
                this.a[n7++] = (byte)c2;
                continue;
            }
            if (c2 > '\u07ff') {
                this.a[n7++] = (byte)(0xE0 | c2 >> 12 & 0xF);
                this.a[n7++] = (byte)(0x80 | c2 >> 6 & 0x3F);
                this.a[n7++] = (byte)(0x80 | c2 & 0x3F);
                continue;
            }
            this.a[n7++] = (byte)(0xC0 | c2 >> 6 & 0x1F);
            this.a[n7++] = (byte)(0x80 | c2 & 0x3F);
        }
        this.b = n7;
        return this;
    }

    public ByteVector putByteArray(byte[] byArray, int n2, int n3) {
        if (this.b + n3 > this.a.length) {
            this.a(n3);
        }
        if (byArray != null) {
            System.arraycopy(byArray, n2, this.a, this.b, n3);
        }
        this.b += n3;
        return this;
    }

    private void a(int n2) {
        int n3 = 2 * this.a.length;
        int n4 = this.b + n2;
        byte[] byArray = new byte[n3 > n4 ? n3 : n4];
        System.arraycopy(this.a, 0, byArray, 0, this.b);
        this.a = byArray;
    }
}

