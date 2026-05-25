/*
 * Decompiled with CFR 0.152.
 */
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class buh {
    public static Object java_lang_Object_a(bfw bfw2) {
        Object t2 = bfw2.a();
        Class<?> clazz = buk.c(t2);
        if (clazz != null) {
            return buk.java_lang_Object_a(clazz);
        }
        if (bfw2.m() || bfw2.a() != false) {
            return bbr.a.d;
        }
        if (t2 == String.class) {
            return "";
        }
        if (bfw2.b(Date.class)) {
            return new Date(0L);
        }
        if (bfw2.b(Calendar.class)) {
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            gregorianCalendar.setTimeInMillis(0L);
            return gregorianCalendar;
        }
        return null;
    }

    public static String java_lang_String_a(bfw bfw2) {
        String string;
        String string2;
        Object t2 = bfw2.a();
        if (buh.a(t2)) {
            string2 = "Java 8 date/time";
            string = "com.fasterxml.jackson.datatype:jackson-datatype-jsr310";
        } else if (buh.b(t2)) {
            string2 = "Joda date/time";
            string = "com.fasterxml.jackson.datatype:jackson-datatype-joda";
        } else {
            return null;
        }
        return String.format("%s type %s not supported by default: add Module \"%s\" to enable handling", string2, buk.a(bfw2), string);
    }

    public static boolean a(Class<?> clazz) {
        return clazz.getName().startsWith("java.time.");
    }

    public static boolean b(Class<?> clazz) {
        return clazz.getName().startsWith("org.joda.time.");
    }
}

