/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.Collection;
import java.util.Currency;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;

public class bta {
    public static Collection<Map.Entry<Class<?>, Object>> a() {
        HashMap<Class<Void>, Object> hashMap = new HashMap<Class<Void>, Object>();
        hashMap.put(URL.class, new bth(URL.class));
        hashMap.put(URI.class, new bth(URI.class));
        hashMap.put(Currency.class, new bth(Currency.class));
        hashMap.put(UUID.class, new btk());
        hashMap.put(Pattern.class, new bth(Pattern.class));
        hashMap.put(Locale.class, new bth(Locale.class));
        hashMap.put(AtomicBoolean.class, a.class);
        hashMap.put(AtomicInteger.class, b.class);
        hashMap.put(AtomicLong.class, c.class);
        hashMap.put(File.class, bsf.class);
        hashMap.put(Class.class, brz.class);
        hashMap.put(Void.class, bsn.a);
        hashMap.put(Void.TYPE, bsn.a);
        return hashMap.entrySet();
    }

    public static class c
    extends btd<AtomicLong> {
        public c() {
            super(AtomicLong.class, false);
        }

        @Override
        public void a(AtomicLong atomicLong, bcy bcy2, bgo bgo2) {
            bcy2.b(atomicLong.get());
        }
    }

    public static class b
    extends btd<AtomicInteger> {
        public b() {
            super(AtomicInteger.class, false);
        }

        @Override
        public void a(AtomicInteger atomicInteger, bcy bcy2, bgo bgo2) {
            bcy2.void_b(atomicInteger.get());
        }
    }

    public static class a
    extends btd<AtomicBoolean> {
        public a() {
            super(AtomicBoolean.class, false);
        }

        @Override
        public void a(AtomicBoolean atomicBoolean, bcy bcy2, bgo bgo2) {
            bcy2.a(atomicBoolean.get());
        }
    }
}

