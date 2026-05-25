/*
 * Decompiled with CFR 0.152.
 */
public class bla
extends blg<StackTraceElement> {
    public bla() {
        super(StackTraceElement.class);
    }

    @Override
    public StackTraceElement a(bdc bdc2, bfs bfs2) {
        bdf bdf2 = bdc2.bdf_c();
        if (bdf2 == bdf.var_bdf_b) {
            String string = "";
            String string2 = "";
            String string3 = "";
            String string4 = null;
            String string5 = null;
            String string6 = null;
            int n2 = -1;
            while ((bdf2 = bdc2.bdf_b()) != bdf.var_bdf_c) {
                String string7 = bdc2.java_lang_String_d();
                if ("className".equals(string7)) {
                    string = bdc2.java_lang_String_e();
                } else if ("classLoaderName".equals(string7)) {
                    string6 = bdc2.java_lang_String_e();
                } else if ("fileName".equals(string7)) {
                    string3 = bdc2.java_lang_String_e();
                } else if ("lineNumber".equals(string7)) {
                    n2 = bdf2.boolean_a() ? bdc2.int_e() : this.int_a(bdc2, bfs2);
                } else if ("methodName".equals(string7)) {
                    string2 = bdc2.java_lang_String_e();
                } else if (!"nativeMethod".equals(string7)) {
                    if ("moduleName".equals(string7)) {
                        string4 = bdc2.java_lang_String_e();
                    } else if ("moduleVersion".equals(string7)) {
                        string5 = bdc2.java_lang_String_e();
                    } else if (!"declaringClass".equals(string7) && !"format".equals(string7)) {
                        this.b(bdc2, bfs2, this.b, string7);
                    }
                }
                bdc2.bdc_a();
            }
            return this.a(bfs2, string, string2, string3, n2, string4, string5, string6);
        }
        if (bdf2 == bdf.var_bdf_d && bfs2.a(bfu.r)) {
            bdc2.bdf_a();
            StackTraceElement stackTraceElement = this.a(bdc2, bfs2);
            if (bdc2.bdf_a() != bdf.var_bdf_e) {
                this.void_a(bdc2, bfs2);
            }
            return stackTraceElement;
        }
        return (StackTraceElement)bfs2.a(this.b, bdc2);
    }

    protected StackTraceElement a(bfs bfs2, String string, String string2, String string3, int n2, String string4, String string5, String string6) {
        return new StackTraceElement(string, string2, string3, n2);
    }
}

