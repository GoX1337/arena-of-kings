/*
 * Decompiled with CFR 0.152.
 */
package com.codedisaster.steamworks;

public abstract class SteamNativeIntHandle {
    int handle;

    SteamNativeIntHandle(int n2) {
        this.handle = n2;
    }

    public static <T extends SteamNativeIntHandle> int getNativeHandle(T t2) {
        return t2.handle;
    }

    public int hashCode() {
        return Integer.valueOf(this.handle).hashCode();
    }

    public boolean equals(Object object) {
        if (object instanceof SteamNativeIntHandle) {
            return this.handle == ((SteamNativeIntHandle)object).handle;
        }
        return false;
    }

    public String toString() {
        return Integer.toHexString(this.handle);
    }
}

