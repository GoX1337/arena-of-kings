/*
 * Decompiled with CFR 0.152.
 */
public class bws
extends bwv {
    private int a = 512;

    public bws(String string, Throwable throwable) {
        super(string, throwable);
    }

    public bws(int n2, Throwable throwable) {
        this(bws.a(n2), throwable);
        this.a = n2;
    }

    public static String a(int n2) {
        return "Decoder errorcode " + Integer.toHexString(n2);
    }
}

