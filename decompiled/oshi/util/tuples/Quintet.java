/*
 * Decompiled with CFR 0.152.
 */
package oshi.util.tuples;

import oshi.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class Quintet<A, B, C, D, E> {
    private final A a;
    private final B b;
    private final C c;
    private final D d;
    private final E e;

    public Quintet(A a2, B b2, C c2, D d2, E e2) {
        this.a = a2;
        this.b = b2;
        this.c = c2;
        this.d = d2;
        this.e = e2;
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

    public final E getE() {
        return this.e;
    }
}

