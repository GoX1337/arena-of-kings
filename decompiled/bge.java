/*
 * Decompiled with CFR 0.152.
 */
public class bge
extends bcw {
    public bge() {
        this(null);
    }

    public bge(bgf bgf2) {
        super(bgf2);
        if (bgf2 == null) {
            this.a(new bgf(this));
        }
    }

    @Override
    public final bgf bgf_a() {
        return (bgf)this.a;
    }

    @Override
    public String java_lang_String_a() {
        return "JSON";
    }
}

