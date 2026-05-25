/*
 * Decompiled with CFR 0.152.
 */
public class bwq
extends bwv {
    private int a = 256;

    public bwq(String string, Throwable throwable) {
        super(string, throwable);
    }

    public bwq(int n2, Throwable throwable) {
        this(bwq.a(n2), throwable);
        this.a = n2;
    }

    public int a() {
        return this.a;
    }

    public static String a(int n2) {
        return "Bitstream errorcode " + Integer.toHexString(n2);
    }
}

