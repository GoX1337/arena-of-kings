/*
 * Decompiled with CFR 0.152.
 */
package com.sun.jna;

import com.sun.jna.Callback;

public class CallbackThreadInitializer {
    private boolean daemon;
    private boolean detach;
    private String name;
    private ThreadGroup group;

    public CallbackThreadInitializer() {
        this(true);
    }

    public CallbackThreadInitializer(boolean bl2) {
        this(bl2, false);
    }

    public CallbackThreadInitializer(boolean bl2, boolean bl3) {
        this(bl2, bl3, null);
    }

    public CallbackThreadInitializer(boolean bl2, boolean bl3, String string) {
        this(bl2, bl3, string, null);
    }

    public CallbackThreadInitializer(boolean bl2, boolean bl3, String string, ThreadGroup threadGroup) {
        this.daemon = bl2;
        this.detach = bl3;
        this.name = string;
        this.group = threadGroup;
    }

    public String getName(Callback callback) {
        return this.name;
    }

    public ThreadGroup getThreadGroup(Callback callback) {
        return this.group;
    }

    public boolean isDaemon(Callback callback) {
        return this.daemon;
    }

    public boolean detach(Callback callback) {
        return this.detach;
    }
}

