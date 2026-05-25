/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.KryoSerializable;
import com.esotericsoftware.kryo.Registration;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.serializers.CollectionSerializer;
import com.esotericsoftware.kryo.serializers.ImmutableSerializer;
import com.esotericsoftware.kryo.serializers.MapSerializer;
import com.esotericsoftware.kryo.util.Util;
import java.lang.reflect.Constructor;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Currency;
import java.util.Date;
import java.util.EnumSet;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentSkipListMap;

public class DefaultSerializers {

    public static class BitSetSerializer
    extends Serializer<BitSet> {
        @Override
        public void write(Kryo kryo, Output output, BitSet bitSet) {
            long[] lArray = bitSet.toLongArray();
            output.writeVarInt(lArray.length, true);
            output.writeLongs(lArray, 0, lArray.length);
        }

        @Override
        public BitSet read(Kryo kryo, Input input, Class clazz) {
            int n2 = input.readVarInt(true);
            long[] lArray = input.readLongs(n2);
            BitSet bitSet = BitSet.valueOf(lArray);
            return bitSet;
        }

        @Override
        public BitSet copy(Kryo kryo, BitSet bitSet) {
            return BitSet.valueOf(bitSet.toLongArray());
        }
    }

    public static class ArraysAsListSerializer
    extends CollectionSerializer<List> {
        @Override
        protected List create(Kryo kryo, Input input, Class clazz, int n2) {
            return new ArrayList(n2);
        }

        @Override
        public List read(Kryo kryo, Input input, Class clazz) {
            List list = (List)super.read(kryo, input, clazz);
            if (list == null) {
                return null;
            }
            return Arrays.asList(list.toArray());
        }

        @Override
        public List copy(Kryo kryo, List list) {
            Object[] objectArray = new Object[list.size()];
            List<Object> list2 = Arrays.asList(objectArray);
            kryo.reference(list2);
            for (int i2 = 0; i2 < list.size(); ++i2) {
                objectArray[i2] = kryo.copy(list.get(i2));
            }
            return list2;
        }
    }

    public static class URLSerializer
    extends ImmutableSerializer<URL> {
        @Override
        public void write(Kryo kryo, Output output, URL uRL) {
            output.writeString(uRL.toExternalForm());
        }

        @Override
        public URL read(Kryo kryo, Input input, Class<? extends URL> clazz) {
            try {
                return new URL(input.readString());
            }
            catch (MalformedURLException malformedURLException) {
                throw new KryoException(malformedURLException);
            }
        }
    }

    public static class CharsetSerializer
    extends ImmutableSerializer<Charset> {
        @Override
        public void write(Kryo kryo, Output output, Charset charset) {
            output.writeString(charset.name());
        }

        @Override
        public Charset read(Kryo kryo, Input input, Class<? extends Charset> clazz) {
            return Charset.forName(input.readString());
        }
    }

    public static class LocaleSerializer
    extends ImmutableSerializer<Locale> {
        public static final Locale SPANISH = new Locale("es", "", "");
        public static final Locale SPAIN = new Locale("es", "ES", "");

        protected Locale create(String string, String string2, String string3) {
            Locale locale = Locale.getDefault();
            if (LocaleSerializer.isSameLocale(locale, string, string2, string3)) {
                return locale;
            }
            if (locale != Locale.US && LocaleSerializer.isSameLocale(Locale.US, string, string2, string3)) {
                return Locale.US;
            }
            if (LocaleSerializer.isSameLocale(Locale.ENGLISH, string, string2, string3)) {
                return Locale.ENGLISH;
            }
            if (LocaleSerializer.isSameLocale(Locale.GERMAN, string, string2, string3)) {
                return Locale.GERMAN;
            }
            if (LocaleSerializer.isSameLocale(SPANISH, string, string2, string3)) {
                return SPANISH;
            }
            if (LocaleSerializer.isSameLocale(Locale.FRENCH, string, string2, string3)) {
                return Locale.FRENCH;
            }
            if (LocaleSerializer.isSameLocale(Locale.ITALIAN, string, string2, string3)) {
                return Locale.ITALIAN;
            }
            if (LocaleSerializer.isSameLocale(Locale.JAPANESE, string, string2, string3)) {
                return Locale.JAPANESE;
            }
            if (LocaleSerializer.isSameLocale(Locale.KOREAN, string, string2, string3)) {
                return Locale.KOREAN;
            }
            if (LocaleSerializer.isSameLocale(Locale.SIMPLIFIED_CHINESE, string, string2, string3)) {
                return Locale.SIMPLIFIED_CHINESE;
            }
            if (LocaleSerializer.isSameLocale(Locale.CHINESE, string, string2, string3)) {
                return Locale.CHINESE;
            }
            if (LocaleSerializer.isSameLocale(Locale.TRADITIONAL_CHINESE, string, string2, string3)) {
                return Locale.TRADITIONAL_CHINESE;
            }
            if (LocaleSerializer.isSameLocale(Locale.UK, string, string2, string3)) {
                return Locale.UK;
            }
            if (LocaleSerializer.isSameLocale(Locale.GERMANY, string, string2, string3)) {
                return Locale.GERMANY;
            }
            if (LocaleSerializer.isSameLocale(SPAIN, string, string2, string3)) {
                return SPAIN;
            }
            if (LocaleSerializer.isSameLocale(Locale.FRANCE, string, string2, string3)) {
                return Locale.FRANCE;
            }
            if (LocaleSerializer.isSameLocale(Locale.ITALY, string, string2, string3)) {
                return Locale.ITALY;
            }
            if (LocaleSerializer.isSameLocale(Locale.JAPAN, string, string2, string3)) {
                return Locale.JAPAN;
            }
            if (LocaleSerializer.isSameLocale(Locale.KOREA, string, string2, string3)) {
                return Locale.KOREA;
            }
            if (LocaleSerializer.isSameLocale(Locale.CANADA, string, string2, string3)) {
                return Locale.CANADA;
            }
            if (LocaleSerializer.isSameLocale(Locale.CANADA_FRENCH, string, string2, string3)) {
                return Locale.CANADA_FRENCH;
            }
            return new Locale(string, string2, string3);
        }

        @Override
        public void write(Kryo kryo, Output output, Locale locale) {
            output.writeAscii(locale.getLanguage());
            output.writeAscii(locale.getCountry());
            output.writeString(locale.getVariant());
        }

        @Override
        public Locale read(Kryo kryo, Input input, Class<? extends Locale> clazz) {
            String string = input.readString();
            String string2 = input.readString();
            String string3 = input.readString();
            return this.create(string, string2, string3);
        }

        protected static boolean isSameLocale(Locale locale, String string, String string2, String string3) {
            return locale.getLanguage().equals(string) && locale.getCountry().equals(string2) && locale.getVariant().equals(string3);
        }
    }

    public static class PriorityQueueSerializer
    extends CollectionSerializer<PriorityQueue> {
        @Override
        protected void writeHeader(Kryo kryo, Output output, PriorityQueue priorityQueue) {
            kryo.writeClassAndObject(output, priorityQueue.comparator());
        }

        @Override
        protected PriorityQueue create(Kryo kryo, Input input, Class<? extends PriorityQueue> clazz, int n2) {
            return this.createPriorityQueue(clazz, n2, (Comparator)kryo.readClassAndObject(input));
        }

        @Override
        protected PriorityQueue createCopy(Kryo kryo, PriorityQueue priorityQueue) {
            return this.createPriorityQueue(priorityQueue.getClass(), priorityQueue.size(), priorityQueue.comparator());
        }

        private PriorityQueue createPriorityQueue(Class<? extends Collection> clazz, int n2, Comparator comparator) {
            if (clazz == PriorityQueue.class || clazz == null) {
                return new PriorityQueue(n2, comparator);
            }
            try {
                Constructor<? extends Collection> constructor = clazz.getConstructor(Integer.TYPE, Comparator.class);
                if (!constructor.isAccessible()) {
                    try {
                        constructor.setAccessible(true);
                    }
                    catch (SecurityException securityException) {
                        // empty catch block
                    }
                }
                return (PriorityQueue)constructor.newInstance(comparator);
            }
            catch (Exception exception) {
                throw new KryoException(exception);
            }
        }
    }

    public static class TreeSetSerializer
    extends CollectionSerializer<TreeSet> {
        @Override
        protected void writeHeader(Kryo kryo, Output output, TreeSet treeSet) {
            kryo.writeClassAndObject(output, treeSet.comparator());
        }

        @Override
        protected TreeSet create(Kryo kryo, Input input, Class<? extends TreeSet> clazz, int n2) {
            return this.createTreeSet(clazz, (Comparator)kryo.readClassAndObject(input));
        }

        @Override
        protected TreeSet createCopy(Kryo kryo, TreeSet treeSet) {
            return this.createTreeSet(treeSet.getClass(), treeSet.comparator());
        }

        private TreeSet createTreeSet(Class<? extends Collection> clazz, Comparator comparator) {
            if (clazz == TreeSet.class || clazz == null) {
                return new TreeSet(comparator);
            }
            try {
                Constructor<? extends Collection> constructor = clazz.getConstructor(Comparator.class);
                if (!constructor.isAccessible()) {
                    try {
                        constructor.setAccessible(true);
                    }
                    catch (SecurityException securityException) {
                        // empty catch block
                    }
                }
                return (TreeSet)constructor.newInstance(comparator);
            }
            catch (Exception exception) {
                throw new KryoException(exception);
            }
        }
    }

    public static class ConcurrentSkipListMapSerializer
    extends MapSerializer<ConcurrentSkipListMap> {
        @Override
        protected void writeHeader(Kryo kryo, Output output, ConcurrentSkipListMap concurrentSkipListMap) {
            kryo.writeClassAndObject(output, concurrentSkipListMap.comparator());
        }

        @Override
        protected ConcurrentSkipListMap create(Kryo kryo, Input input, Class<? extends ConcurrentSkipListMap> clazz, int n2) {
            return this.createConcurrentSkipListMap(clazz, (Comparator)kryo.readClassAndObject(input));
        }

        @Override
        protected ConcurrentSkipListMap createCopy(Kryo kryo, ConcurrentSkipListMap concurrentSkipListMap) {
            return this.createConcurrentSkipListMap(concurrentSkipListMap.getClass(), concurrentSkipListMap.comparator());
        }

        private ConcurrentSkipListMap createConcurrentSkipListMap(Class<? extends ConcurrentSkipListMap> clazz, Comparator comparator) {
            if (clazz == ConcurrentSkipListMap.class || clazz == null) {
                return new ConcurrentSkipListMap(comparator);
            }
            try {
                Constructor<? extends ConcurrentSkipListMap> constructor = clazz.getConstructor(Comparator.class);
                if (!constructor.isAccessible()) {
                    try {
                        constructor.setAccessible(true);
                    }
                    catch (SecurityException securityException) {
                        // empty catch block
                    }
                }
                return constructor.newInstance(comparator);
            }
            catch (Exception exception) {
                throw new KryoException(exception);
            }
        }
    }

    public static class TreeMapSerializer
    extends MapSerializer<TreeMap> {
        @Override
        protected void writeHeader(Kryo kryo, Output output, TreeMap treeMap) {
            kryo.writeClassAndObject(output, treeMap.comparator());
        }

        @Override
        protected TreeMap create(Kryo kryo, Input input, Class<? extends TreeMap> clazz, int n2) {
            return this.createTreeMap(clazz, (Comparator)kryo.readClassAndObject(input));
        }

        @Override
        protected TreeMap createCopy(Kryo kryo, TreeMap treeMap) {
            return this.createTreeMap(treeMap.getClass(), treeMap.comparator());
        }

        private TreeMap createTreeMap(Class<? extends TreeMap> clazz, Comparator comparator) {
            if (clazz == TreeMap.class || clazz == null) {
                return new TreeMap(comparator);
            }
            try {
                Constructor<? extends TreeMap> constructor = clazz.getConstructor(Comparator.class);
                if (!constructor.isAccessible()) {
                    try {
                        constructor.setAccessible(true);
                    }
                    catch (SecurityException securityException) {
                        // empty catch block
                    }
                }
                return constructor.newInstance(comparator);
            }
            catch (Exception exception) {
                throw new KryoException(exception);
            }
        }
    }

    public static class CalendarSerializer
    extends Serializer<Calendar> {
        private static final long DEFAULT_GREGORIAN_CUTOVER = -12219292800000L;
        TimeZoneSerializer timeZoneSerializer = new TimeZoneSerializer();

        @Override
        public void write(Kryo kryo, Output output, Calendar calendar) {
            this.timeZoneSerializer.write(kryo, output, calendar.getTimeZone());
            output.writeVarLong(calendar.getTimeInMillis(), true);
            output.writeBoolean(calendar.isLenient());
            output.writeInt(calendar.getFirstDayOfWeek(), true);
            output.writeInt(calendar.getMinimalDaysInFirstWeek(), true);
            if (calendar instanceof GregorianCalendar) {
                output.writeVarLong(((GregorianCalendar)calendar).getGregorianChange().getTime(), false);
            } else {
                output.writeVarLong(-12219292800000L, false);
            }
        }

        @Override
        public Calendar read(Kryo kryo, Input input, Class<? extends Calendar> clazz) {
            Calendar calendar = Calendar.getInstance((TimeZone)this.timeZoneSerializer.read(kryo, input, TimeZone.class));
            calendar.setTimeInMillis(input.readVarLong(true));
            calendar.setLenient(input.readBoolean());
            calendar.setFirstDayOfWeek(input.readInt(true));
            calendar.setMinimalDaysInFirstWeek(input.readInt(true));
            long l2 = input.readVarLong(false);
            if (l2 != -12219292800000L && calendar instanceof GregorianCalendar) {
                ((GregorianCalendar)calendar).setGregorianChange(new Date(l2));
            }
            return calendar;
        }

        @Override
        public Calendar copy(Kryo kryo, Calendar calendar) {
            return (Calendar)calendar.clone();
        }
    }

    public static class TimeZoneSerializer
    extends ImmutableSerializer<TimeZone> {
        @Override
        public void write(Kryo kryo, Output output, TimeZone timeZone) {
            output.writeString(timeZone.getID());
        }

        @Override
        public TimeZone read(Kryo kryo, Input input, Class<? extends TimeZone> clazz) {
            return TimeZone.getTimeZone(input.readString());
        }
    }

    public static class CollectionsSingletonSetSerializer
    extends Serializer<Set> {
        @Override
        public void write(Kryo kryo, Output output, Set set) {
            kryo.writeClassAndObject(output, set.iterator().next());
        }

        @Override
        public Set read(Kryo kryo, Input input, Class<? extends Set> clazz) {
            return Collections.singleton(kryo.readClassAndObject(input));
        }

        @Override
        public Set copy(Kryo kryo, Set set) {
            return Collections.singleton(kryo.copy(set.iterator().next()));
        }
    }

    public static class CollectionsSingletonMapSerializer
    extends Serializer<Map> {
        @Override
        public void write(Kryo kryo, Output output, Map map) {
            Map.Entry entry = map.entrySet().iterator().next();
            kryo.writeClassAndObject(output, entry.getKey());
            kryo.writeClassAndObject(output, entry.getValue());
        }

        @Override
        public Map read(Kryo kryo, Input input, Class<? extends Map> clazz) {
            Object object = kryo.readClassAndObject(input);
            Object object2 = kryo.readClassAndObject(input);
            return Collections.singletonMap(object, object2);
        }

        @Override
        public Map copy(Kryo kryo, Map map) {
            Map.Entry entry = map.entrySet().iterator().next();
            return Collections.singletonMap(kryo.copy(entry.getKey()), kryo.copy(entry.getValue()));
        }
    }

    public static class CollectionsSingletonListSerializer
    extends Serializer<List> {
        @Override
        public void write(Kryo kryo, Output output, List list) {
            kryo.writeClassAndObject(output, list.get(0));
        }

        @Override
        public List read(Kryo kryo, Input input, Class<? extends List> clazz) {
            return Collections.singletonList(kryo.readClassAndObject(input));
        }

        @Override
        public List copy(Kryo kryo, List list) {
            return Collections.singletonList(kryo.copy(list.get(0)));
        }
    }

    public static class CollectionsEmptySetSerializer
    extends ImmutableSerializer<Set> {
        @Override
        public void write(Kryo kryo, Output output, Set set) {
        }

        @Override
        public Set read(Kryo kryo, Input input, Class<? extends Set> clazz) {
            return Collections.EMPTY_SET;
        }
    }

    public static class CollectionsEmptyMapSerializer
    extends ImmutableSerializer<Map> {
        @Override
        public void write(Kryo kryo, Output output, Map map) {
        }

        @Override
        public Map read(Kryo kryo, Input input, Class<? extends Map> clazz) {
            return Collections.EMPTY_MAP;
        }
    }

    public static class CollectionsEmptyListSerializer
    extends ImmutableSerializer<Collection> {
        @Override
        public void write(Kryo kryo, Output output, Collection collection) {
        }

        @Override
        public Collection read(Kryo kryo, Input input, Class<? extends Collection> clazz) {
            return Collections.EMPTY_LIST;
        }
    }

    public static class KryoSerializableSerializer
    extends Serializer<KryoSerializable> {
        @Override
        public void write(Kryo kryo, Output output, KryoSerializable kryoSerializable) {
            kryoSerializable.write(kryo, output);
        }

        @Override
        public KryoSerializable read(Kryo kryo, Input input, Class<? extends KryoSerializable> clazz) {
            KryoSerializable kryoSerializable = kryo.newInstance(clazz);
            kryo.reference(kryoSerializable);
            kryoSerializable.read(kryo, input);
            return kryoSerializable;
        }
    }

    public static class StringBuilderSerializer
    extends Serializer<StringBuilder> {
        public StringBuilderSerializer() {
            this.setAcceptsNull(true);
        }

        @Override
        public void write(Kryo kryo, Output output, StringBuilder stringBuilder) {
            output.writeString(stringBuilder == null ? null : stringBuilder.toString());
        }

        @Override
        public StringBuilder read(Kryo kryo, Input input, Class<? extends StringBuilder> clazz) {
            return input.readStringBuilder();
        }

        @Override
        public StringBuilder copy(Kryo kryo, StringBuilder stringBuilder) {
            return new StringBuilder(stringBuilder);
        }
    }

    public static class StringBufferSerializer
    extends Serializer<StringBuffer> {
        public StringBufferSerializer() {
            this.setAcceptsNull(true);
        }

        @Override
        public void write(Kryo kryo, Output output, StringBuffer stringBuffer) {
            output.writeString(stringBuffer == null ? null : stringBuffer.toString());
        }

        @Override
        public StringBuffer read(Kryo kryo, Input input, Class<? extends StringBuffer> clazz) {
            String string = input.readString();
            if (string == null) {
                return null;
            }
            return new StringBuffer(string);
        }

        @Override
        public StringBuffer copy(Kryo kryo, StringBuffer stringBuffer) {
            return new StringBuffer(stringBuffer);
        }
    }

    public static class CurrencySerializer
    extends ImmutableSerializer<Currency> {
        public CurrencySerializer() {
            this.setAcceptsNull(true);
        }

        @Override
        public void write(Kryo kryo, Output output, Currency currency) {
            output.writeString(currency == null ? null : currency.getCurrencyCode());
        }

        @Override
        public Currency read(Kryo kryo, Input input, Class<? extends Currency> clazz) {
            String string = input.readString();
            if (string == null) {
                return null;
            }
            return Currency.getInstance(string);
        }
    }

    public static class EnumSetSerializer
    extends Serializer<EnumSet> {
        @Override
        public void write(Kryo kryo, Output output, EnumSet enumSet) {
            Serializer serializer;
            if (enumSet.isEmpty()) {
                EnumSet enumSet2 = EnumSet.complementOf(enumSet);
                if (enumSet2.isEmpty()) {
                    throw new KryoException("An EnumSet must have a defined Enum to be serialized.");
                }
                serializer = kryo.writeClass(output, enumSet2.iterator().next().getClass()).getSerializer();
            } else {
                serializer = kryo.writeClass(output, enumSet.iterator().next().getClass()).getSerializer();
            }
            output.writeVarInt(enumSet.size(), true);
            for (Object e2 : enumSet) {
                serializer.write(kryo, output, e2);
            }
        }

        @Override
        public EnumSet read(Kryo kryo, Input input, Class<? extends EnumSet> clazz) {
            Registration registration = kryo.readClass(input);
            EnumSet enumSet = EnumSet.noneOf(registration.getType());
            Serializer serializer = registration.getSerializer();
            int n2 = input.readVarInt(true);
            for (int i2 = 0; i2 < n2; ++i2) {
                enumSet.add(serializer.read(kryo, input, null));
            }
            return enumSet;
        }

        @Override
        public EnumSet copy(Kryo kryo, EnumSet enumSet) {
            return EnumSet.copyOf(enumSet);
        }
    }

    public static class EnumSerializer
    extends ImmutableSerializer<Enum> {
        private Object[] enumConstants;

        public EnumSerializer(Class<? extends Enum> clazz) {
            this.setAcceptsNull(true);
            this.enumConstants = clazz.getEnumConstants();
            if (this.enumConstants == null && !Enum.class.equals(clazz)) {
                throw new IllegalArgumentException("The type must be an enum: " + clazz);
            }
        }

        @Override
        public void write(Kryo kryo, Output output, Enum enum_) {
            if (enum_ == null) {
                output.writeVarInt(0, true);
                return;
            }
            output.writeVarInt(enum_.ordinal() + 1, true);
        }

        @Override
        public Enum read(Kryo kryo, Input input, Class<? extends Enum> clazz) {
            int n2 = input.readVarInt(true);
            if (n2 == 0) {
                return null;
            }
            if (--n2 < 0 || n2 > this.enumConstants.length - 1) {
                throw new KryoException("Invalid ordinal for enum \"" + clazz.getName() + "\": " + n2);
            }
            Object object = this.enumConstants[n2];
            return (Enum)object;
        }
    }

    public static class DateSerializer
    extends Serializer<Date> {
        private Date create(Kryo kryo, Class<? extends Date> clazz, long l2) {
            if (clazz == Date.class || clazz == null) {
                return new Date(l2);
            }
            if (clazz == Timestamp.class) {
                return new Timestamp(l2);
            }
            if (clazz == java.sql.Date.class) {
                return new java.sql.Date(l2);
            }
            if (clazz == Time.class) {
                return new Time(l2);
            }
            try {
                Constructor<? extends Date> constructor = clazz.getConstructor(Long.TYPE);
                if (!constructor.isAccessible()) {
                    try {
                        constructor.setAccessible(true);
                    }
                    catch (SecurityException securityException) {
                        // empty catch block
                    }
                }
                return constructor.newInstance(l2);
            }
            catch (Exception exception) {
                Date date = kryo.newInstance(clazz);
                date.setTime(l2);
                return date;
            }
        }

        @Override
        public void write(Kryo kryo, Output output, Date date) {
            output.writeVarLong(date.getTime(), true);
        }

        @Override
        public Date read(Kryo kryo, Input input, Class<? extends Date> clazz) {
            return this.create(kryo, clazz, input.readVarLong(true));
        }

        @Override
        public Date copy(Kryo kryo, Date date) {
            return this.create(kryo, date.getClass(), date.getTime());
        }
    }

    public static class ClassSerializer
    extends ImmutableSerializer<Class> {
        public ClassSerializer() {
            this.setAcceptsNull(true);
        }

        @Override
        public void write(Kryo kryo, Output output, Class clazz) {
            kryo.writeClass(output, clazz);
            if (clazz != null && (clazz.isPrimitive() || Util.isWrapperClass(clazz))) {
                output.writeBoolean(clazz.isPrimitive());
            }
        }

        @Override
        public Class read(Kryo kryo, Input input, Class<? extends Class> clazz) {
            Registration registration = kryo.readClass(input);
            if (registration == null) {
                return null;
            }
            Class clazz2 = registration.getType();
            if (!clazz2.isPrimitive() || input.readBoolean()) {
                return clazz2;
            }
            return Util.getWrapperClass(clazz2);
        }
    }

    public static class BigDecimalSerializer
    extends ImmutableSerializer<BigDecimal> {
        private final BigIntegerSerializer bigIntegerSerializer = new BigIntegerSerializer();

        public BigDecimalSerializer() {
            this.setAcceptsNull(true);
        }

        @Override
        public void write(Kryo kryo, Output output, BigDecimal bigDecimal) {
            if (bigDecimal == null) {
                output.writeByte((byte)0);
                return;
            }
            if (bigDecimal == BigDecimal.ZERO) {
                this.bigIntegerSerializer.write(kryo, output, BigInteger.ZERO);
                output.writeInt(0, false);
                return;
            }
            this.bigIntegerSerializer.write(kryo, output, bigDecimal.unscaledValue());
            output.writeInt(bigDecimal.scale(), false);
        }

        @Override
        public BigDecimal read(Kryo kryo, Input input, Class<? extends BigDecimal> clazz) {
            Object object = this.bigIntegerSerializer.read(kryo, input, BigInteger.class);
            if (object == null) {
                return null;
            }
            int n2 = input.readInt(false);
            if (clazz != BigDecimal.class && clazz != null) {
                try {
                    Constructor<? extends BigDecimal> constructor = clazz.getConstructor(BigInteger.class, Integer.TYPE);
                    if (!constructor.isAccessible()) {
                        try {
                            constructor.setAccessible(true);
                        }
                        catch (SecurityException securityException) {
                            // empty catch block
                        }
                    }
                    return constructor.newInstance(object, n2);
                }
                catch (Exception exception) {
                    throw new KryoException(exception);
                }
            }
            if (object == BigInteger.ZERO && n2 == 0) {
                return BigDecimal.ZERO;
            }
            return new BigDecimal((BigInteger)object, n2);
        }
    }

    public static class BigIntegerSerializer
    extends ImmutableSerializer<BigInteger> {
        public BigIntegerSerializer() {
            this.setAcceptsNull(true);
        }

        @Override
        public void write(Kryo kryo, Output output, BigInteger bigInteger) {
            if (bigInteger == null) {
                output.writeByte((byte)0);
                return;
            }
            if (bigInteger == BigInteger.ZERO) {
                output.writeByte(2);
                output.writeByte(0);
                return;
            }
            byte[] byArray = bigInteger.toByteArray();
            output.writeVarInt(byArray.length + 1, true);
            output.writeBytes(byArray);
        }

        @Override
        public BigInteger read(Kryo kryo, Input input, Class<? extends BigInteger> clazz) {
            int n2 = input.readVarInt(true);
            if (n2 == 0) {
                return null;
            }
            byte[] byArray = input.readBytes(n2 - 1);
            if (clazz != BigInteger.class && clazz != null) {
                try {
                    Constructor<? extends BigInteger> constructor = clazz.getConstructor(byte[].class);
                    if (!constructor.isAccessible()) {
                        try {
                            constructor.setAccessible(true);
                        }
                        catch (SecurityException securityException) {
                            // empty catch block
                        }
                    }
                    return constructor.newInstance(new Object[]{byArray});
                }
                catch (Exception exception) {
                    throw new KryoException(exception);
                }
            }
            if (n2 == 2) {
                switch (byArray[0]) {
                    case 0: {
                        return BigInteger.ZERO;
                    }
                    case 1: {
                        return BigInteger.ONE;
                    }
                    case 10: {
                        return BigInteger.TEN;
                    }
                }
            }
            return new BigInteger(byArray);
        }
    }

    public static class StringSerializer
    extends ImmutableSerializer<String> {
        public StringSerializer() {
            this.setAcceptsNull(true);
        }

        @Override
        public void write(Kryo kryo, Output output, String string) {
            output.writeString(string);
        }

        @Override
        public String read(Kryo kryo, Input input, Class<? extends String> clazz) {
            return input.readString();
        }
    }

    public static class DoubleSerializer
    extends ImmutableSerializer<Double> {
        @Override
        public void write(Kryo kryo, Output output, Double d2) {
            output.writeDouble(d2);
        }

        @Override
        public Double read(Kryo kryo, Input input, Class<? extends Double> clazz) {
            return input.readDouble();
        }
    }

    public static class FloatSerializer
    extends ImmutableSerializer<Float> {
        @Override
        public void write(Kryo kryo, Output output, Float f2) {
            output.writeFloat(f2.floatValue());
        }

        @Override
        public Float read(Kryo kryo, Input input, Class<? extends Float> clazz) {
            return Float.valueOf(input.readFloat());
        }
    }

    public static class LongSerializer
    extends ImmutableSerializer<Long> {
        @Override
        public void write(Kryo kryo, Output output, Long l2) {
            output.writeVarLong(l2, false);
        }

        @Override
        public Long read(Kryo kryo, Input input, Class<? extends Long> clazz) {
            return input.readVarLong(false);
        }
    }

    public static class IntSerializer
    extends ImmutableSerializer<Integer> {
        @Override
        public void write(Kryo kryo, Output output, Integer n2) {
            output.writeInt(n2, false);
        }

        @Override
        public Integer read(Kryo kryo, Input input, Class<? extends Integer> clazz) {
            return input.readInt(false);
        }
    }

    public static class ShortSerializer
    extends ImmutableSerializer<Short> {
        @Override
        public void write(Kryo kryo, Output output, Short s2) {
            output.writeShort(s2.shortValue());
        }

        @Override
        public Short read(Kryo kryo, Input input, Class<? extends Short> clazz) {
            return input.readShort();
        }
    }

    public static class CharSerializer
    extends ImmutableSerializer<Character> {
        @Override
        public void write(Kryo kryo, Output output, Character c2) {
            output.writeChar(c2.charValue());
        }

        @Override
        public Character read(Kryo kryo, Input input, Class<? extends Character> clazz) {
            return Character.valueOf(input.readChar());
        }
    }

    public static class ByteSerializer
    extends ImmutableSerializer<Byte> {
        @Override
        public void write(Kryo kryo, Output output, Byte by2) {
            output.writeByte(by2);
        }

        @Override
        public Byte read(Kryo kryo, Input input, Class<? extends Byte> clazz) {
            return input.readByte();
        }
    }

    public static class BooleanSerializer
    extends ImmutableSerializer<Boolean> {
        @Override
        public void write(Kryo kryo, Output output, Boolean bl2) {
            output.writeBoolean(bl2);
        }

        @Override
        public Boolean read(Kryo kryo, Input input, Class<? extends Boolean> clazz) {
            return input.readBoolean();
        }
    }

    public static class VoidSerializer
    extends ImmutableSerializer {
        @Override
        public void write(Kryo kryo, Output output, Object object) {
        }

        @Override
        public Object read(Kryo kryo, Input input, Class clazz) {
            return null;
        }
    }
}

