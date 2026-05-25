/*
 * Decompiled with CFR 0.152.
 */
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class bxn
implements bxh {
    private String var_java_lang_String_a = new Vector(10);
    private Vector<bxh> var_java_util_Vector_bxh__a;

    public static bxh a(Class<? extends bxi> clazz, String string) {
        bxi bxi2;
        Constructor<? extends bxi> constructor;
        try {
            constructor = bxn.a(clazz);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            return bxn.bxh_a("Class " + clazz.getName() + " has no public constructor TestCase(String name) or TestCase()");
        }
        try {
            if (constructor.getParameterTypes().length == 0) {
                bxi2 = constructor.newInstance(new Object[0]);
                if (bxi2 instanceof bxi) {
                    bxi2.b(string);
                }
            } else {
                bxi2 = constructor.newInstance(string);
            }
        }
        catch (InstantiationException instantiationException) {
            return bxn.bxh_a("Cannot instantiate test case: " + string + " (" + bxn.a(instantiationException) + ")");
        }
        catch (InvocationTargetException invocationTargetException) {
            return bxn.bxh_a("Exception in constructor: " + string + " (" + bxn.a(invocationTargetException.getTargetException()) + ")");
        }
        catch (IllegalAccessException illegalAccessException) {
            return bxn.bxh_a("Cannot access test case: " + string + " (" + bxn.a(illegalAccessException) + ")");
        }
        return bxi2;
    }

    public static Constructor<? extends bxi> a(Class<? extends bxi> clazz) {
        try {
            return clazz.getConstructor(String.class);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            return clazz.getConstructor(new Class[0]);
        }
    }

    public static bxh bxh_a(String string) {
        return new bxo("warning", string);
    }

    private static String a(Throwable throwable) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        throwable.printStackTrace(printWriter);
        return stringWriter.toString();
    }

    public bxn() {
    }

    public bxn(Class<? extends bxi> clazz) {
        this.var_java_lang_String_a = clazz.getName();
        try {
            bxn.a(clazz);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            this.a(bxn.bxh_a("Class " + clazz.getName() + " has no public constructor TestCase(String name) or TestCase()"));
            return;
        }
        if (!Modifier.isPublic(clazz.getModifiers())) {
            this.a(bxn.bxh_a("Class " + clazz.getName() + " is not public"));
            return;
        }
        Class<? extends bxi> clazz2 = clazz;
        ArrayList<String> arrayList = new ArrayList<String>();
        while (bxh.class.isAssignableFrom(clazz2)) {
            for (Method method : clazz2.getDeclaredMethods()) {
                this.a(method, arrayList, clazz);
            }
            clazz2 = clazz2.getSuperclass();
        }
        if (((Vector)((Object)this.var_java_lang_String_a)).size() == 0) {
            this.a(bxn.bxh_a("No tests found in " + clazz.getName()));
        }
    }

    public bxn(String string) {
        this.void_a(string);
    }

    public void a(bxh bxh2) {
        ((Vector)((Object)this.var_java_lang_String_a)).add(bxh2);
    }

    @Override
    public int int_a() {
        int n2 = 0;
        Iterator iterator = ((Vector)((Object)this.var_java_lang_String_a)).iterator();
        while (iterator.hasNext()) {
            bxh bxh2 = (bxh)iterator.next();
            n2 += bxh2.int_a();
        }
        return n2;
    }

    public String java_lang_String_a() {
        return this.var_java_lang_String_a;
    }

    @Override
    public void b(bxl bxl2) {
        Iterator iterator = ((Vector)((Object)this.var_java_lang_String_a)).iterator();
        while (iterator.hasNext()) {
            bxh bxh2 = (bxh)iterator.next();
            if (bxl2.a()) break;
            this.a(bxh2, bxl2);
        }
    }

    public void a(bxh bxh2, bxl bxl2) {
        bxh2.b(bxl2);
    }

    public void void_a(String string) {
        this.var_java_lang_String_a = string;
    }

    public bxh a(int n2) {
        return (bxh)((Vector)((Object)this.var_java_lang_String_a)).get(n2);
    }

    public int b() {
        return ((Vector)((Object)this.var_java_lang_String_a)).size();
    }

    public String toString() {
        if (this.java_lang_String_a() != null) {
            return this.java_lang_String_a();
        }
        return super.toString();
    }

    private void a(Method method, List<String> list, Class<? extends bxi> clazz) {
        String string = method.getName();
        if (list.contains(string)) {
            return;
        }
        if (!this.a(method)) {
            if (this.b(method)) {
                this.a(bxn.bxh_a("Test method isn't public: " + method.getName()));
            }
            return;
        }
        list.add(string);
        this.a(bxn.a(clazz, string));
    }

    private boolean a(Method method) {
        return this.b(method) && Modifier.isPublic(method.getModifiers());
    }

    private boolean b(Method method) {
        return method.getParameterTypes().length == 0 && method.getName().startsWith("test") && method.getReturnType().equals(Void.TYPE);
    }
}

