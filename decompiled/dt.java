/*
 * Decompiled with CFR 0.152.
 */
public class dt
extends dc {
    public dt(double d2) {
        super(d2);
        this.b = d2;
    }

    @Override
    public void void_a(double d2) {
        this.a = d2;
        this.b = d2;
    }

    @Override
    public void void_a() {
        this.b = this.a;
    }

    @Override
    public double double_a(double d2) {
        return d2 / 100.0 * 0.01;
    }
}

