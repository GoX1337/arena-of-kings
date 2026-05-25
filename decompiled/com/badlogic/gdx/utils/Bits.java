/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils;

import java.util.Arrays;

public class Bits {
    long[] bits = new long[]{0L};

    public Bits() {
    }

    public Bits(int n2) {
        this.checkCapacity(n2 >>> 6);
    }

    public Bits(Bits bits) {
        this.bits = new long[bits.bits.length];
        System.arraycopy(bits.bits, 0, this.bits, 0, bits.bits.length);
    }

    public boolean get(int n2) {
        int n3 = n2 >>> 6;
        if (n3 >= this.bits.length) {
            return false;
        }
        return (this.bits[n3] & 1L << (n2 & 0x3F)) != 0L;
    }

    public boolean getAndClear(int n2) {
        int n3 = n2 >>> 6;
        if (n3 >= this.bits.length) {
            return false;
        }
        long l2 = this.bits[n3];
        int n4 = n3;
        this.bits[n4] = this.bits[n4] & (1L << (n2 & 0x3F) ^ 0xFFFFFFFFFFFFFFFFL);
        return this.bits[n3] != l2;
    }

    public boolean getAndSet(int n2) {
        int n3 = n2 >>> 6;
        this.checkCapacity(n3);
        long l2 = this.bits[n3];
        int n4 = n3;
        this.bits[n4] = this.bits[n4] | 1L << (n2 & 0x3F);
        return this.bits[n3] == l2;
    }

    public void set(int n2) {
        int n3 = n2 >>> 6;
        this.checkCapacity(n3);
        int n4 = n3;
        this.bits[n4] = this.bits[n4] | 1L << (n2 & 0x3F);
    }

    public void flip(int n2) {
        int n3 = n2 >>> 6;
        this.checkCapacity(n3);
        int n4 = n3;
        this.bits[n4] = this.bits[n4] ^ 1L << (n2 & 0x3F);
    }

    private void checkCapacity(int n2) {
        if (n2 >= this.bits.length) {
            long[] lArray = new long[n2 + 1];
            System.arraycopy(this.bits, 0, lArray, 0, this.bits.length);
            this.bits = lArray;
        }
    }

    public void clear(int n2) {
        int n3 = n2 >>> 6;
        if (n3 >= this.bits.length) {
            return;
        }
        int n4 = n3;
        this.bits[n4] = this.bits[n4] & (1L << (n2 & 0x3F) ^ 0xFFFFFFFFFFFFFFFFL);
    }

    public void clear() {
        Arrays.fill(this.bits, 0L);
    }

    public int numBits() {
        return this.bits.length << 6;
    }

    public int length() {
        long[] lArray = this.bits;
        for (int i2 = lArray.length - 1; i2 >= 0; --i2) {
            long l2 = lArray[i2];
            if (l2 == 0L) continue;
            for (int i3 = 63; i3 >= 0; --i3) {
                if ((l2 & 1L << (i3 & 0x3F)) == 0L) continue;
                return (i2 << 6) + i3 + 1;
            }
        }
        return 0;
    }

    public boolean notEmpty() {
        return !this.isEmpty();
    }

    public boolean isEmpty() {
        long[] lArray = this.bits;
        int n2 = lArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (lArray[i2] == 0L) continue;
            return false;
        }
        return true;
    }

    public int nextSetBit(int n2) {
        int n3;
        int n4 = n2 >>> 6;
        long[] lArray = this.bits;
        int n5 = lArray.length;
        if (n4 >= n5) {
            return -1;
        }
        long l2 = lArray[n4];
        if (l2 != 0L) {
            for (n3 = n2 & 0x3F; n3 < 64; ++n3) {
                if ((l2 & 1L << (n3 & 0x3F)) == 0L) continue;
                return (n4 << 6) + n3;
            }
        }
        ++n4;
        while (n4 < n5) {
            if (n4 != 0 && (l2 = lArray[n4]) != 0L) {
                for (n3 = 0; n3 < 64; ++n3) {
                    if ((l2 & 1L << (n3 & 0x3F)) == 0L) continue;
                    return (n4 << 6) + n3;
                }
            }
            ++n4;
        }
        return -1;
    }

    public int nextClearBit(int n2) {
        int n3;
        int n4 = n2 >>> 6;
        long[] lArray = this.bits;
        int n5 = lArray.length;
        if (n4 >= n5) {
            return lArray.length << 6;
        }
        long l2 = lArray[n4];
        for (n3 = n2 & 0x3F; n3 < 64; ++n3) {
            if ((l2 & 1L << (n3 & 0x3F)) != 0L) continue;
            return (n4 << 6) + n3;
        }
        ++n4;
        while (n4 < n5) {
            if (n4 == 0) {
                return n4 << 6;
            }
            l2 = lArray[n4];
            for (n3 = 0; n3 < 64; ++n3) {
                if ((l2 & 1L << (n3 & 0x3F)) != 0L) continue;
                return (n4 << 6) + n3;
            }
            ++n4;
        }
        return lArray.length << 6;
    }

    public void and(Bits bits) {
        int n2;
        int n3 = Math.min(this.bits.length, bits.bits.length);
        for (n2 = 0; n3 > n2; ++n2) {
            int n4 = n2;
            this.bits[n4] = this.bits[n4] & bits.bits[n2];
        }
        if (this.bits.length > n3) {
            int n5 = this.bits.length;
            for (n2 = n3; n5 > n2; ++n2) {
                this.bits[n2] = 0L;
            }
        }
    }

    public void andNot(Bits bits) {
        int n2 = this.bits.length;
        int n3 = bits.bits.length;
        for (int i2 = 0; i2 < n2 && i2 < n3; ++i2) {
            int n4 = i2;
            this.bits[n4] = this.bits[n4] & (bits.bits[i2] ^ 0xFFFFFFFFFFFFFFFFL);
        }
    }

    public void or(Bits bits) {
        int n2;
        int n3 = Math.min(this.bits.length, bits.bits.length);
        for (n2 = 0; n3 > n2; ++n2) {
            int n4 = n2;
            this.bits[n4] = this.bits[n4] | bits.bits[n2];
        }
        if (n3 < bits.bits.length) {
            this.checkCapacity(bits.bits.length);
            int n5 = bits.bits.length;
            for (n2 = n3; n5 > n2; ++n2) {
                this.bits[n2] = bits.bits[n2];
            }
        }
    }

    public void xor(Bits bits) {
        int n2;
        int n3 = Math.min(this.bits.length, bits.bits.length);
        for (n2 = 0; n3 > n2; ++n2) {
            int n4 = n2;
            this.bits[n4] = this.bits[n4] ^ bits.bits[n2];
        }
        if (n3 < bits.bits.length) {
            this.checkCapacity(bits.bits.length);
            int n5 = bits.bits.length;
            for (n2 = n3; n5 > n2; ++n2) {
                this.bits[n2] = bits.bits[n2];
            }
        }
    }

    public boolean intersects(Bits bits) {
        long[] lArray = this.bits;
        long[] lArray2 = bits.bits;
        for (int i2 = Math.min(lArray.length, lArray2.length) - 1; i2 >= 0; --i2) {
            if ((lArray[i2] & lArray2[i2]) == 0L) continue;
            return true;
        }
        return false;
    }

    public boolean containsAll(Bits bits) {
        int n2;
        int n3;
        long[] lArray = this.bits;
        long[] lArray2 = bits.bits;
        int n4 = lArray2.length;
        for (n3 = n2 = lArray.length; n3 < n4; ++n3) {
            if (lArray2[n3] == 0L) continue;
            return false;
        }
        for (n3 = Math.min(n2, n4) - 1; n3 >= 0; --n3) {
            if ((lArray[n3] & lArray2[n3]) == lArray2[n3]) continue;
            return false;
        }
        return true;
    }

    public int hashCode() {
        int n2 = this.length() >>> 6;
        int n3 = 0;
        for (int i2 = 0; n2 >= i2; ++i2) {
            n3 = 127 * n3 + (int)(this.bits[i2] ^ this.bits[i2] >>> 32);
        }
        return n3;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (this.getClass() != object.getClass()) {
            return false;
        }
        Bits bits = (Bits)object;
        long[] lArray = bits.bits;
        int n2 = Math.min(this.bits.length, lArray.length);
        for (int i2 = 0; n2 > i2; ++i2) {
            if (this.bits[i2] == lArray[i2]) continue;
            return false;
        }
        if (this.bits.length == lArray.length) {
            return true;
        }
        return this.length() == bits.length();
    }
}

