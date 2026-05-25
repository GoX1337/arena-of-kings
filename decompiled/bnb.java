/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class bnb
extends bmf {
    protected final bhm<?> var_bhm____a;
    protected final bmh var_bmh_a;
    protected final a var_bnb$a_a;
    protected final boolean var_boolean_a;
    protected final String var_java_lang_String_a;
    protected final String b;
    protected final String c;

    protected bnb(bhm<?> bhm2, bmh bmh2, String string, String string2, String string3, a a2) {
        this.var_bhm____a = bhm2;
        this.var_bmh_a = bmh2;
        this.var_boolean_a = bhm2.a(bgd.z);
        this.c = string;
        this.var_java_lang_String_a = string2;
        this.b = string3;
        this.var_bnb$a_a = a2;
    }

    @Override
    public String a(bmo bmo2, String string) {
        Object object;
        if (this.b != null && ((object = bmo2.java_lang_Object_a()) == Boolean.class || object == Boolean.TYPE) && string.startsWith(this.b)) {
            return this.var_boolean_a ? this.b(string, 2) : this.a(string, 2);
        }
        return null;
    }

    @Override
    public String b(bmo bmo2, String string) {
        if (this.var_java_lang_String_a != null && string.startsWith(this.var_java_lang_String_a)) {
            if ("getCallbacks".equals(string) ? this.a(bmo2) : "getMetaClass".equals(string) && this.b(bmo2)) {
                return null;
            }
            return this.var_boolean_a ? this.b(string, this.var_java_lang_String_a.length()) : this.a(string, this.var_java_lang_String_a.length());
        }
        return null;
    }

    @Override
    public String c(bmo bmo2, String string) {
        if (this.c != null && string.startsWith(this.c)) {
            return this.var_boolean_a ? this.b(string, this.c.length()) : this.a(string, this.c.length());
        }
        return null;
    }

    @Override
    public String a(bml bml2, String string) {
        return string;
    }

    protected String a(String string, int n2) {
        int n3 = string.length();
        if (n3 == n2) {
            return null;
        }
        char c2 = string.charAt(n2);
        if (this.var_bnb$a_a != null && !this.var_bnb$a_a.a(c2, string, n2)) {
            return null;
        }
        char c3 = Character.toLowerCase(c2);
        if (c2 == c3) {
            return string.substring(n2);
        }
        StringBuilder stringBuilder = new StringBuilder(n3 - n2);
        stringBuilder.append(c3);
        for (int i2 = n2 + 1; i2 < n3; ++i2) {
            c2 = string.charAt(i2);
            if (c2 == (c3 = Character.toLowerCase(c2))) {
                stringBuilder.append(string, i2, n3);
                break;
            }
            stringBuilder.append(c3);
        }
        return stringBuilder.toString();
    }

    protected String b(String string, int n2) {
        int n3 = string.length();
        if (n3 == n2) {
            return null;
        }
        char c2 = string.charAt(n2);
        if (this.var_bnb$a_a != null && !this.var_bnb$a_a.a(c2, string, n2)) {
            return null;
        }
        char c3 = Character.toLowerCase(c2);
        if (c2 == c3) {
            return string.substring(n2);
        }
        if (n2 + 1 < n3 && Character.isUpperCase(string.charAt(n2 + 1))) {
            return string.substring(n2);
        }
        StringBuilder stringBuilder = new StringBuilder(n3 - n2);
        stringBuilder.append(c3);
        stringBuilder.append(string, n2 + 1, n3);
        return stringBuilder.toString();
    }

    protected boolean a(bmo bmo2) {
        Class<?> clazz;
        String string;
        Object object = bmo2.java_lang_Object_a();
        if (((Class)object).isArray() && (string = (clazz = ((Class)object).getComponentType()).getName()).contains(".cglib")) {
            return string.startsWith("net.sf.cglib") || string.startsWith("org.hibernate.repackage.cglib") || string.startsWith("org.springframework.cglib");
        }
        return false;
    }

    protected boolean b(bmo bmo2) {
        return ((Class)bmo2.java_lang_Object_a()).getName().startsWith("groovy.lang");
    }

    public static class c
    extends bnb {
        protected final Set<String> a = new HashSet<String>();

        public c(bhm<?> bhm2, bmh bmh2) {
            super(bhm2, bmh2, null, "get", "is", null);
            for (String string : bnw.a(bmh2.java_lang_reflect_AnnotatedElement_a())) {
                this.a.add(string);
            }
        }

        @Override
        public String b(bmo bmo2, String string) {
            if (this.a.contains(string)) {
                return string;
            }
            return super.b(bmo2, string);
        }
    }

    public static class b
    extends bmf.a
    implements Serializable {
        protected final String var_java_lang_String_a;
        protected final String b;
        protected final String c;
        protected final String d;
        protected final a var_bnb$a_a;

        public b() {
            this("set", "with", "get", "is", null);
        }

        protected b(String string, String string2, String string3, String string4, a a2) {
            this.var_java_lang_String_a = string;
            this.b = string2;
            this.c = string3;
            this.d = string4;
            this.var_bnb$a_a = a2;
        }

        @Override
        public bmf a(bhm<?> bhm2, bmh bmh2) {
            return new bnb(bhm2, bmh2, this.var_java_lang_String_a, this.c, this.d, this.var_bnb$a_a);
        }

        @Override
        public bmf a(bhm<?> bhm2, bmh bmh2, bfo bfo2) {
            bfn bfn2 = bhm2.b() ? bhm2.bfn_a() : null;
            Object object = bfn2 == null ? null : bfn2.java_lang_Object_a(bmh2);
            String string = object == null ? this.b : ((bgt.a)object).b;
            return new bnb(bhm2, bmh2, string, this.c, this.d, this.var_bnb$a_a);
        }

        @Override
        public bmf b(bhm<?> bhm2, bmh bmh2) {
            return new c(bhm2, bmh2);
        }
    }

    public static interface a {
        public boolean a(char var1, String var2, int var3);
    }
}

