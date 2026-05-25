/*
 * Decompiled with CFR 0.152.
 */
import java.util.HashSet;

public class bei {
    protected final Object var_java_lang_Object_a;
    protected String var_java_lang_String_a;
    protected String b;
    protected HashSet<String> var_java_util_HashSet_java_lang_String__a;

    private bei(Object object) {
        this.var_java_lang_Object_a = object;
    }

    public static bei a(bdc bdc2) {
        return new bei(bdc2);
    }

    public static bei a(bcy bcy2) {
        return new bei(bcy2);
    }

    public bei bei_a() {
        return new bei(this.var_java_lang_Object_a);
    }

    public void void_a() {
        this.var_java_lang_String_a = null;
        this.b = null;
        this.var_java_lang_Object_a = null;
    }

    public Object java_lang_Object_a() {
        return this.var_java_lang_Object_a;
    }

    public boolean a(String string) {
        if (this.var_java_lang_String_a == null) {
            this.var_java_lang_String_a = string;
            return false;
        }
        if (string.equals(this.var_java_lang_String_a)) {
            return true;
        }
        if (this.b == null) {
            this.b = string;
            return false;
        }
        if (string.equals(this.b)) {
            return true;
        }
        if (this.var_java_lang_Object_a == null) {
            this.var_java_lang_Object_a = new HashSet(16);
            ((HashSet)this.var_java_lang_Object_a).add(this.var_java_lang_String_a);
            ((HashSet)this.var_java_lang_Object_a).add(this.b);
        }
        return !((HashSet)this.var_java_lang_Object_a).add(string);
    }
}

