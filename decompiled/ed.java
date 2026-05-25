/*
 * Decompiled with CFR 0.152.
 */
public class ed
extends dc {
    public ed() {
    }

    public ed(double d2) {
        super(d2);
    }

    @Override
    public void void_a() {
        this.b = -2.0 * Math.pow(10.0, -5.0) * Math.pow(this.a, 3.0) + 0.007 * Math.pow(this.a, 2.0) - 1.7 * Math.pow(10.0, -13.0) * this.a + 80.0;
    }

    @Override
    public double double_a(double d2) {
        return -2.0 * Math.pow(10.0, -5.0) * Math.pow(d2, 3.0) + 0.007 * Math.pow(d2, 2.0) - 1.7 * Math.pow(10.0, -13.0) * d2 + 80.0;
    }
}

