/*
 * Decompiled with CFR 0.152.
 */
public class bdd
extends bcu {
    protected bda a;

    protected bdd(String string, bda bda2, Throwable throwable) {
        super(string, throwable);
        this.a = bda2;
    }

    protected bdd(String string) {
        super(string);
    }

    protected bdd(String string, bda bda2) {
        this(string, bda2, null);
    }

    protected bdd(String string, Throwable throwable) {
        this(string, null, throwable);
    }

    public bda bda_a() {
        return this.a;
    }

    public String java_lang_String_a() {
        return super.getMessage();
    }

    public Object java_lang_Object_a() {
        return null;
    }

    protected String java_lang_String_b() {
        return null;
    }

    @Override
    public String getMessage() {
        String string = super.getMessage();
        if (string == null) {
            string = "N/A";
        }
        bda bda2 = this.bda_a();
        String string2 = this.java_lang_String_b();
        if (bda2 != null || string2 != null) {
            StringBuilder stringBuilder = new StringBuilder(100);
            stringBuilder.append(string);
            if (string2 != null) {
                stringBuilder.append(string2);
            }
            if (bda2 != null) {
                stringBuilder.append('\n');
                stringBuilder.append(" at ");
                stringBuilder.append(bda2.toString());
            }
            string = stringBuilder.toString();
        }
        return string;
    }

    @Override
    public String toString() {
        return this.getClass().getName() + ": " + this.getMessage();
    }
}

