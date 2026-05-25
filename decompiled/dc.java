/*
 * Decompiled with CFR 0.152.
 */
public abstract class dc {
    protected double a = 0.0;
    protected double b = 0.0;

    public dc() {
    }

    public dc(double d2) {
        this.a = d2;
    }

    public double double_a() {
        return this.b;
    }

    public double double_b() {
        return this.a;
    }

    public void void_a(double d2) {
        this.a = d2;
    }

    public void b(double d2) {
        this.a += d2;
    }

    public abstract void void_a();

    public abstract double double_a(double var1);

    public void void_b() {
        this.a = 0.0;
        this.b = 0.0;
    }
}

