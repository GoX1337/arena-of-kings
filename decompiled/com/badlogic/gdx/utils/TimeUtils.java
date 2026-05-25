/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils;

public final class TimeUtils {
    private static final long nanosPerMilli = 1000000L;

    public static long nanoTime() {
        return System.nanoTime();
    }

    public static long millis() {
        return System.currentTimeMillis();
    }

    public static long nanosToMillis(long l2) {
        return l2 / 1000000L;
    }

    public static long millisToNanos(long l2) {
        return l2 * 1000000L;
    }

    public static long timeSinceNanos(long l2) {
        return TimeUtils.nanoTime() - l2;
    }

    public static long timeSinceMillis(long l2) {
        return TimeUtils.millis() - l2;
    }
}

