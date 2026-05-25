/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;

public class bfi
implements Serializable {
    private final char a;
    private final char b;
    private final char c;

    public static bfi bfi_a() {
        return new bfi();
    }

    public bfi() {
        this(':', ',', ',');
    }

    public bfi(char c2, char c3, char c4) {
        this.a = c2;
        this.b = c3;
        this.c = c4;
    }

    public char char_a() {
        return this.a;
    }

    public char b() {
        return this.b;
    }

    public char c() {
        return this.c;
    }
}

