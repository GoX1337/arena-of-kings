/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.math;

import java.util.Random;

public class RandomXS128
extends Random {
    private static final double NORM_DOUBLE = (double)1.110223E-16f;
    private static final double NORM_FLOAT = 5.960464477539063E-8;
    private long seed0;
    private long seed1;

    public RandomXS128() {
        this.setSeed(new Random().nextLong());
    }

    public RandomXS128(long l2) {
        this.setSeed(l2);
    }

    public RandomXS128(long l2, long l3) {
        this.setState(l2, l3);
    }

    @Override
    public long nextLong() {
        long l2;
        long l3 = this.seed0;
        this.seed0 = l2 = this.seed1;
        l3 ^= l3 << 23;
        this.seed1 = l3 ^ l2 ^ l3 >>> 17 ^ l2 >>> 26;
        return this.seed1 + l2;
    }

    @Override
    protected final int next(int n2) {
        return (int)(this.nextLong() & (1L << n2) - 1L);
    }

    @Override
    public int nextInt() {
        return (int)this.nextLong();
    }

    @Override
    public int nextInt(int n2) {
        return (int)this.nextLong(n2);
    }

    @Override
    public long nextLong(long l2) {
        long l3;
        long l4;
        if (l2 <= 0L) {
            throw new IllegalArgumentException("n must be positive");
        }
        while ((l4 = this.nextLong() >>> 1) - (l3 = l4 % l2) + (l2 - 1L) < 0L) {
        }
        return l3;
    }

    @Override
    public double nextDouble() {
        return (double)(this.nextLong() >>> 11) * (double)1.110223E-16f;
    }

    @Override
    public float nextFloat() {
        return (float)((double)(this.nextLong() >>> 40) * 5.960464477539063E-8);
    }

    @Override
    public boolean nextBoolean() {
        return (this.nextLong() & 1L) != 0L;
    }

    @Override
    public void nextBytes(byte[] byArray) {
        int n2 = 0;
        int n3 = byArray.length;
        while (n3 != 0) {
            n2 = n3 < 8 ? n3 : 8;
            long l2 = this.nextLong();
            while (n2-- != 0) {
                byArray[--n3] = (byte)l2;
                l2 >>= 8;
            }
        }
    }

    @Override
    public void setSeed(long l2) {
        long l3 = RandomXS128.murmurHash3(l2 == 0L ? Long.MIN_VALUE : l2);
        this.setState(l3, RandomXS128.murmurHash3(l3));
    }

    public void setState(long l2, long l3) {
        this.seed0 = l2;
        this.seed1 = l3;
    }

    public long getState(int n2) {
        return n2 == 0 ? this.seed0 : this.seed1;
    }

    private static final long murmurHash3(long l2) {
        l2 ^= l2 >>> 33;
        l2 *= -49064778989728563L;
        l2 ^= l2 >>> 33;
        l2 *= -4265267296055464877L;
        l2 ^= l2 >>> 33;
        return l2;
    }
}

