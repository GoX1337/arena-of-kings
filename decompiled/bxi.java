/*
 * Decompiled with CFR 0.152.
 */
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public abstract class bxi
extends bxe
implements bxh {
    private String a;

    public bxi() {
        this.a = null;
    }

    public bxi(String string) {
        this.a = string;
    }

    public int int_a() {
        return 1;
    }

    public void b(bxl bxl2) {
        bxl2.a(this);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void void_a() {
        Throwable throwable = null;
        this.c();
        try {
            this.b();
        }
        catch (Throwable throwable2) {
            throwable = throwable2;
        }
        finally {
            block13: {
                try {
                    this.d();
                }
                catch (Throwable throwable3) {
                    if (throwable != null) break block13;
                    throwable = throwable3;
                }
            }
        }
        if (throwable != null) {
            throw throwable;
        }
    }

    protected void b() {
        bxi.a("TestCase.fName cannot be null", this.a);
        Method method = null;
        try {
            method = this.getClass().getMethod(this.a, null);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            bxi.a("Method \"" + this.a + "\" not found");
        }
        if (!Modifier.isPublic(method.getModifiers())) {
            bxi.a("Method \"" + this.a + "\" should be public");
        }
        try {
            method.invoke((Object)this, new Object[0]);
        }
        catch (InvocationTargetException invocationTargetException) {
            invocationTargetException.fillInStackTrace();
            throw invocationTargetException.getTargetException();
        }
        catch (IllegalAccessException illegalAccessException) {
            illegalAccessException.fillInStackTrace();
            throw illegalAccessException;
        }
    }

    protected void c() {
    }

    protected void d() {
    }

    public String toString() {
        return this.java_lang_String_a() + "(" + this.getClass().getName() + ")";
    }

    public String java_lang_String_a() {
        return this.a;
    }

    public void b(String string) {
        this.a = string;
    }
}

