/*
 * Decompiled with CFR 0.152.
 */
public final class bwr {
    private static short a = (short)-32763;
    private short b = (short)-1;

    public void a(int n2, int n3) {
        int n4 = 1 << n3 - 1;
        do {
            if ((this.b & 0x8000) == 0 ^ (n2 & n4) == 0) {
                this.b = (short)(this.b << 1);
                this.b = (short)(this.b ^ a);
                continue;
            }
            this.b = (short)(this.b << 1);
        } while ((n4 >>>= 1) != 0);
    }

    public short a() {
        short s2 = this.b;
        this.b = (short)-1;
        return s2;
    }
}

