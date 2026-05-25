/*
 * Decompiled with CFR 0.152.
 */
public abstract class bde {
    protected int a;
    protected int b;

    protected bde() {
    }

    protected bde(bde bde2) {
        this.a = bde2.a;
        this.b = bde2.b;
    }

    protected bde(int n2, int n3) {
        this.a = n2;
        this.b = n3;
    }

    public abstract bde bde_a();

    public final boolean boolean_a() {
        return this.a == 1;
    }

    public final boolean boolean_b() {
        return this.a == 0;
    }

    public final boolean boolean_c() {
        return this.a == 2;
    }

    public String java_lang_String_a() {
        switch (this.a) {
            case 0: {
                return "root";
            }
            case 1: {
                return "Array";
            }
            case 2: {
                return "Object";
            }
        }
        return "?";
    }

    public final int int_a() {
        return this.b + 1;
    }

    public final int int_b() {
        return this.b < 0 ? 0 : this.b;
    }

    public abstract String java_lang_String_b();

    public Object java_lang_Object_a() {
        return null;
    }

    public void void_a(Object object) {
    }

    public bda bda_a(Object object) {
        return bda.var_bda_a;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        switch (this.a) {
            case 0: {
                stringBuilder.append("/");
                break;
            }
            case 1: {
                stringBuilder.append('[');
                stringBuilder.append(this.int_b());
                stringBuilder.append(']');
                break;
            }
            default: {
                stringBuilder.append('{');
                String string = this.java_lang_String_b();
                if (string != null) {
                    stringBuilder.append('\"');
                    bdt.a(stringBuilder, string);
                    stringBuilder.append('\"');
                } else {
                    stringBuilder.append('?');
                }
                stringBuilder.append('}');
            }
        }
        return stringBuilder.toString();
    }
}

