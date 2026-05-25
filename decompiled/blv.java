/*
 * Decompiled with CFR 0.152.
 */
import java.util.Collection;
import java.util.Iterator;

public abstract class blv
extends blu {
    protected final Class<?> var_java_lang_Class____b;
    protected final String var_java_lang_String_a;
    protected final Collection<Object> var_java_util_Collection_java_lang_Object__a;
    protected transient String var_java_lang_String_b;

    protected blv(bdc bdc2, String string, bda bda2, Class<?> clazz, String string2, Collection<Object> collection) {
        super(bdc2, string, bda2);
        this.var_java_lang_Class____b = clazz;
        this.var_java_lang_String_a = string2;
        this.var_java_lang_String_a = collection;
    }

    @Override
    public String java_lang_String_b() {
        String string = this.var_java_lang_String_b;
        if (string == null && this.var_java_lang_String_a != null) {
            StringBuilder stringBuilder = new StringBuilder(100);
            int n2 = this.var_java_lang_String_a.size();
            if (n2 == 1) {
                stringBuilder.append(" (one known property: \"");
                stringBuilder.append(String.valueOf(this.var_java_lang_String_a.iterator().next()));
                stringBuilder.append('\"');
            } else {
                stringBuilder.append(" (").append(n2).append(" known properties: ");
                Iterator iterator = this.var_java_lang_String_a.iterator();
                while (iterator.hasNext()) {
                    stringBuilder.append('\"');
                    stringBuilder.append(String.valueOf(iterator.next()));
                    stringBuilder.append('\"');
                    if (stringBuilder.length() > 1000) {
                        stringBuilder.append(" [truncated]");
                        break;
                    }
                    if (!iterator.hasNext()) continue;
                    stringBuilder.append(", ");
                }
            }
            stringBuilder.append("])");
            this.var_java_lang_String_b = string = stringBuilder.toString();
        }
        return string;
    }
}

