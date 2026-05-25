/*
 * Decompiled with CFR 0.152.
 */
import java.nio.ByteBuffer;
import java.util.HashSet;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class bkp {
    private static final HashSet<String> a;

    public static bfx<?> a(Class<?> clazz, String string) {
        if (a.contains(string)) {
            bko<?> bko2 = bko.a(clazz);
            if (bko2 != null) {
                return bko2;
            }
            if (clazz == UUID.class) {
                return new bln();
            }
            if (clazz == StackTraceElement.class) {
                return new bla();
            }
            if (clazz == AtomicBoolean.class) {
                return new bjz();
            }
            if (clazz == AtomicInteger.class) {
                return new bka();
            }
            if (clazz == AtomicLong.class) {
                return new bkb();
            }
            if (clazz == ByteBuffer.class) {
                return new bke();
            }
            if (clazz == Void.class) {
                return bku.a;
            }
        }
        return null;
    }

    static {
        Class[] classArray;
        a = new HashSet();
        for (Class clazz : classArray = new Class[]{UUID.class, AtomicBoolean.class, AtomicInteger.class, AtomicLong.class, StackTraceElement.class, ByteBuffer.class, Void.class}) {
            a.add(clazz.getName());
        }
        for (Class clazz : bko.java_lang_Class____arr_a()) {
            a.add(clazz.getName());
        }
    }
}

