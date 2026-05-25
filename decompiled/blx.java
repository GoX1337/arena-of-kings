/*
 * Decompiled with CFR 0.152.
 */
import java.io.Closeable;

public class blx
extends bfy {
    protected final bfw a;

    protected blx(bdc bdc2, String string, bfw bfw2, Throwable throwable) {
        super((Closeable)bdc2, string, throwable);
        this.a = bfw2;
    }

    public static blx a(bdc bdc2, String string, bfw bfw2, Throwable throwable) {
        return new blx(bdc2, string, bfw2, throwable);
    }
}

