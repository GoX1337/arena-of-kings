/*
 * Decompiled with CFR 0.152.
 */
import java.io.Closeable;

public class blu
extends bfy {
    protected Class<?> a;

    protected blu(bdc bdc2, String string) {
        this(bdc2, string, (bfw)null);
    }

    protected blu(bdc bdc2, String string, bda bda2) {
        super((Closeable)bdc2, string, bda2);
    }

    protected blu(bdc bdc2, String string, Class<?> clazz) {
        super(bdc2, string);
        this.a = clazz;
    }

    protected blu(bdc bdc2, String string, bfw bfw2) {
        super(bdc2, string);
        this.a = buk.a(bfw2);
    }

    public static blu a(bdc bdc2, bfw bfw2, String string) {
        return new blu(bdc2, string, bfw2);
    }

    public static blu a(bdc bdc2, Class<?> clazz, String string) {
        return new blu(bdc2, string, clazz);
    }

    public blu a(bfw bfw2) {
        this.a = bfw2.a();
        return this;
    }
}

