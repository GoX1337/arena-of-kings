/*
 * Decompiled with CFR 0.152.
 */
import java.io.Writer;

public final class bed
extends Writer {
    private final bfj a;

    public bed(bev bev2) {
        this.a = new bfj(bev2);
    }

    @Override
    public Writer append(char c2) {
        this.write(c2);
        return this;
    }

    @Override
    public Writer append(CharSequence charSequence) {
        String string = charSequence.toString();
        this.a.a(string, 0, string.length());
        return this;
    }

    @Override
    public Writer append(CharSequence charSequence, int n2, int n3) {
        String string = charSequence.subSequence(n2, n3).toString();
        this.a.a(string, 0, string.length());
        return this;
    }

    @Override
    public void close() {
    }

    @Override
    public void flush() {
    }

    @Override
    public void write(char[] cArray) {
        this.a.c(cArray, 0, cArray.length);
    }

    @Override
    public void write(char[] cArray, int n2, int n3) {
        this.a.c(cArray, n2, n3);
    }

    @Override
    public void write(int n2) {
        this.a.a((char)n2);
    }

    @Override
    public void write(String string) {
        this.a.a(string, 0, string.length());
    }

    @Override
    public void write(String string, int n2, int n3) {
        this.a.a(string, n2, n3);
    }

    public String a() {
        String string = this.a.java_lang_String_a();
        this.a.void_a();
        return string;
    }
}

