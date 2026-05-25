/*
 * Decompiled with CFR 0.152.
 */
package oshi.util.tuples;

import oshi.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class Quartet<A, B, C, D> {
    private final A a;
    private final B b;
    private final C c;
    private final D d;

    public Quartet(A a2, B b2, C c2, D d2) {
        this.a = a2;
        this.b = b2;
        this.c = c2;
        this.d = d2;
    }

    public final A getA() {
        return this.a;
    }

    public final B getB() {
        return this.b;
    }

    public final C getC() {
        return this.c;
    }

    public final D getD() {
        return this.d;
    }
}

