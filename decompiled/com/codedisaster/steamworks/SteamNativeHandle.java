/*
 * Decompiled with CFR 0.152.
 */
package com.codedisaster.steamworks;

public abstract class SteamNativeHandle {
    long handle;

    SteamNativeHandle(long l2) {
        this.handle = l2;
    }

    public static <T extends SteamNativeHandle> long getNativeHandle(T t2) {
        return t2.handle;
    }

    public int hashCode() {
        return Long.valueOf(this.handle).hashCode();
    }

    public boolean equals(Object object) {
        if (object instanceof SteamNativeHandle) {
            return this.handle == ((SteamNativeHandle)object).handle;
        }
        return false;
    }

    public String toString() {
        return Long.toHexString(this.handle);
    }
}

