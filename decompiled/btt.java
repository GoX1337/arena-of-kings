/*
 * Decompiled with CFR 0.152.
 */
public class btt
extends btx {
    protected final int b;
    protected bfw a;

    public btt(int n2) {
        super(Object.class, bty.bty_a(), btz.bfw_a(), null, 1, null, null, false);
        this.b = n2;
    }

    public bfw bfw_f() {
        return this.a;
    }

    public void void_a(bfw bfw2) {
        this.a = bfw2;
    }

    @Override
    protected String java_lang_String_c() {
        return this.toString();
    }

    @Override
    public StringBuilder a(StringBuilder stringBuilder) {
        return this.b(stringBuilder);
    }

    @Override
    public StringBuilder b(StringBuilder stringBuilder) {
        stringBuilder.append('$').append(this.b + 1);
        return stringBuilder;
    }

    @Override
    public bfw bfw_a(Object object) {
        return (bfw)this.c();
    }

    @Override
    public bfw bfw_b(Object object) {
        return (bfw)this.c();
    }

    @Override
    public bfw bfw_c(Object object) {
        return (bfw)this.c();
    }

    @Override
    public bfw d(Object object) {
        return (bfw)this.c();
    }

    @Override
    public bfw b(bfw bfw2) {
        return (bfw)this.c();
    }

    @Override
    public bfw bfw_a() {
        return (bfw)this.c();
    }

    @Override
    public bfw a(Class<?> clazz, bty bty2, bfw bfw2, bfw[] bfwArray) {
        return (bfw)this.c();
    }

    @Override
    public boolean m() {
        return false;
    }

    @Override
    public String toString() {
        return this.b(new StringBuilder()).toString();
    }

    @Override
    public boolean equals(Object object) {
        return object == this;
    }

    private <T> T c() {
        throw new UnsupportedOperationException("Operation should not be attempted on " + this.getClass().getName());
    }
}

