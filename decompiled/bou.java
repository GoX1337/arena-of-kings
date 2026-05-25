/*
 * Decompiled with CFR 0.152.
 */
public class bou
extends bos {
    protected final String a;
    protected final String b;

    protected bou(bfw bfw2, btz btz2, boa boa2) {
        super(bfw2, btz2, boa2);
        String string = ((Class)bfw2.a()).getName();
        int n2 = string.lastIndexOf(46);
        if (n2 < 0) {
            this.a = "";
            this.b = ".";
        } else {
            this.b = string.substring(0, n2 + 1);
            this.a = string.substring(0, n2);
        }
    }

    public static bou a(bfw bfw2, bhm<?> bhm2, boa boa2) {
        return new bou(bfw2, bhm2.btz_a(), boa2);
    }

    @Override
    public String a(Object object) {
        String string = object.getClass().getName();
        if (string.startsWith(this.b)) {
            return string.substring(this.b.length() - 1);
        }
        return string;
    }

    @Override
    protected bfw a(String string, bfq bfq2) {
        if (string.startsWith(".")) {
            StringBuilder stringBuilder = new StringBuilder(string.length() + this.a.length());
            if (this.a.isEmpty()) {
                stringBuilder.append(string.substring(1));
            } else {
                stringBuilder.append(this.a).append(string);
            }
            string = stringBuilder.toString();
        }
        return super.a(string, bfq2);
    }
}

