/*
 * Decompiled with CFR 0.152.
 */
public final class bcr {
    public static final bcq a = new bcq("MIME", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
    public static final bcq b = new bcq(a, "MIME-NO-LINEFEEDS", Integer.MAX_VALUE);
    public static final bcq c = new bcq(a, "PEM", true, '=', 64);
    public static final bcq d;

    public static bcq a() {
        return b;
    }

    static {
        StringBuilder stringBuilder = new StringBuilder("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/");
        stringBuilder.setCharAt(stringBuilder.indexOf("+"), '-');
        stringBuilder.setCharAt(stringBuilder.indexOf("/"), '_');
        d = new bcq("MODIFIED-FOR-URL", stringBuilder.toString(), false, '\u0000', Integer.MAX_VALUE);
    }
}

