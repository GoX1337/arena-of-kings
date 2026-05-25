/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class bme
implements Serializable {
    private static final Class<?> var_java_lang_Class____a;
    private static final Class<?> var_java_lang_Class____b;
    private static final bly var_bly_a;
    public static final bme var_bme_a;
    private final Map<String, String> cfr_renamed_28;
    private final Map<String, Object> cfr_renamed_29;

    protected bme() {
        this.var_java_lang_Class____a = new HashMap();
        this.var_java_lang_Class____a.put("java.sql.Date", "com.fasterxml.jackson.databind.deser.std.DateDeserializers$SqlDateDeserializer");
        this.var_java_lang_Class____a.put("java.sql.Timestamp", "com.fasterxml.jackson.databind.deser.std.DateDeserializers$TimestampDeserializer");
        this.var_java_lang_Class____b = new HashMap();
        this.var_java_lang_Class____b.put("java.sql.Timestamp", bsb.a);
        this.var_java_lang_Class____b.put("java.sql.Date", "com.fasterxml.jackson.databind.ser.std.SqlDateSerializer");
        this.var_java_lang_Class____b.put("java.sql.Time", "com.fasterxml.jackson.databind.ser.std.SqlTimeSerializer");
        this.var_java_lang_Class____b.put("java.sql.Blob", "com.fasterxml.jackson.databind.ext.SqlBlobSerializer");
        this.var_java_lang_Class____b.put("javax.sql.rowset.serial.SerialBlob", "com.fasterxml.jackson.databind.ext.SqlBlobSerializer");
    }

    public bgb<?> a(bgm bgm2, bfw bfw2, bfo bfo2) {
        Object object;
        Object t2 = bfw2.a();
        if (this.a((Class<?>)t2, var_java_lang_Class____a)) {
            return (bgb)this.a("com.fasterxml.jackson.databind.ext.DOMSerializer", bfw2);
        }
        if (var_bly_a != null && (object = var_bly_a.a((Class<?>)t2)) != null) {
            return object;
        }
        object = ((Class)t2).getName();
        Object v2 = this.var_java_lang_Class____b.get(object);
        if (v2 != null) {
            if (v2 instanceof bgb) {
                return (bgb)v2;
            }
            return (bgb)this.a((String)v2, bfw2);
        }
        if (!((String)object).startsWith("javax.xml.") && !this.a((Class<?>)t2, "javax.xml.")) {
            return null;
        }
        String string = "com.fasterxml.jackson.databind.ext.CoreXMLSerializers";
        Object object2 = this.a(string, bfw2);
        if (object2 == null) {
            return null;
        }
        return ((bqr)object2).a(bgm2, bfw2, bfo2);
    }

    public bfx<?> a(bfw bfw2, bfr bfr2, bfo bfo2) {
        Object object;
        Object t2 = bfw2.a();
        if (var_bly_a != null && (object = var_bly_a.a((Class<?>)t2)) != null) {
            return object;
        }
        if (this.a((Class<?>)t2, var_java_lang_Class____a)) {
            return (bfx)this.a("com.fasterxml.jackson.databind.ext.DOMDeserializer$NodeDeserializer", bfw2);
        }
        if (this.a((Class<?>)t2, var_java_lang_Class____b)) {
            return (bfx)this.a("com.fasterxml.jackson.databind.ext.DOMDeserializer$DocumentDeserializer", bfw2);
        }
        object = ((Class)t2).getName();
        String string = (String)this.var_java_lang_Class____a.get(object);
        if (string != null) {
            return (bfx)this.a(string, bfw2);
        }
        if (!((String)object).startsWith("javax.xml.") && !this.a((Class<?>)t2, "javax.xml.")) {
            return null;
        }
        String string2 = "com.fasterxml.jackson.databind.ext.CoreXMLDeserializers";
        Object object2 = this.a(string2, bfw2);
        if (object2 == null) {
            return null;
        }
        return ((bij)object2).a(bfw2, bfr2, bfo2);
    }

    private boolean a(Class<?> clazz, Class<?> clazz2) {
        return clazz2 != null && clazz2.isAssignableFrom(clazz);
    }

    private Object a(String string, bfw bfw2) {
        try {
            return this.a(Class.forName(string), bfw2);
        }
        catch (Throwable throwable) {
            throw new IllegalStateException("Failed to find class `" + string + "` for handling values of type " + buk.a(bfw2) + ", problem: (" + throwable.getClass().getName() + ") " + throwable.getMessage());
        }
    }

    private Object a(Class<?> clazz, bfw bfw2) {
        try {
            return buk.a(clazz, false);
        }
        catch (Throwable throwable) {
            throw new IllegalStateException("Failed to create instance of `" + clazz.getName() + "` for handling values of type " + buk.a(bfw2) + ", problem: (" + throwable.getClass().getName() + ") " + throwable.getMessage());
        }
    }

    private boolean a(Class<?> clazz, String string) {
        for (Class<?> clazz2 = clazz.getSuperclass(); clazz2 != null; clazz2 = clazz2.getSuperclass()) {
            if (clazz2 == Object.class) {
                return false;
            }
            if (!clazz2.getName().startsWith(string)) continue;
            return true;
        }
        return false;
    }

    static {
        Object object = null;
        Class<Node> clazz = null;
        try {
            clazz = Node.class;
            object = Document.class;
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        var_java_lang_Class____a = clazz;
        var_java_lang_Class____b = object;
        object = null;
        try {
            object = bly.a();
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        var_bly_a = object;
        var_bme_a = new bme();
    }
}

