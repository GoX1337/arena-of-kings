/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.kryo;

import com.esotericsoftware.kryo.ClassResolver;
import com.esotericsoftware.kryo.DefaultSerializer;
import com.esotericsoftware.kryo.KryoCopyable;
import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.KryoSerializable;
import com.esotericsoftware.kryo.ReferenceResolver;
import com.esotericsoftware.kryo.Registration;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.SerializerFactory;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.serializers.ClosureSerializer;
import com.esotericsoftware.kryo.serializers.CollectionSerializer;
import com.esotericsoftware.kryo.serializers.DefaultArraySerializers;
import com.esotericsoftware.kryo.serializers.DefaultSerializers;
import com.esotericsoftware.kryo.serializers.ImmutableCollectionsSerializers;
import com.esotericsoftware.kryo.serializers.MapSerializer;
import com.esotericsoftware.kryo.serializers.OptionalSerializers;
import com.esotericsoftware.kryo.serializers.RecordSerializer;
import com.esotericsoftware.kryo.serializers.TimeSerializers;
import com.esotericsoftware.kryo.util.DefaultClassResolver;
import com.esotericsoftware.kryo.util.DefaultGenerics;
import com.esotericsoftware.kryo.util.DefaultInstantiatorStrategy;
import com.esotericsoftware.kryo.util.Generics;
import com.esotericsoftware.kryo.util.IdentityMap;
import com.esotericsoftware.kryo.util.IntArray;
import com.esotericsoftware.kryo.util.MapReferenceResolver;
import com.esotericsoftware.kryo.util.NoGenerics;
import com.esotericsoftware.kryo.util.ObjectMap;
import com.esotericsoftware.kryo.util.Util;
import com.esotericsoftware.minlog.Log;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Currency;
import java.util.Date;
import java.util.EnumSet;
import java.util.Locale;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentSkipListMap;
import org.objenesis.instantiator.ObjectInstantiator;
import org.objenesis.strategy.InstantiatorStrategy;

public class Kryo {
    public static final byte NULL = 0;
    public static final byte NOT_NULL = 1;
    private static final int REF = -1;
    private static final int NO_REF = -2;
    private static final int DEFAULT_SERIALIZER_SIZE = 68;
    private SerializerFactory defaultSerializer = new SerializerFactory.FieldSerializerFactory();
    private final ArrayList<DefaultSerializerEntry> defaultSerializers = new ArrayList(68);
    private final int lowPriorityDefaultSerializerCount;
    private final ClassResolver classResolver;
    private int nextRegisterID;
    private ClassLoader classLoader = this.getClass().getClassLoader();
    private InstantiatorStrategy strategy = new DefaultInstantiatorStrategy();
    private boolean registrationRequired = true;
    private boolean warnUnregisteredClasses;
    private int depth;
    private int maxDepth = Integer.MAX_VALUE;
    private boolean autoReset = true;
    private volatile Thread thread;
    private ObjectMap context;
    private ObjectMap graphContext;
    private ReferenceResolver referenceResolver;
    private final IntArray readReferenceIds = new IntArray(0);
    private boolean references;
    private boolean copyReferences = true;
    private Object readObject;
    private int copyDepth;
    private boolean copyShallow;
    private IdentityMap originalToCopy;
    private Object needsCopyReference;
    private Generics generics = new DefaultGenerics(this);

    public Kryo() {
        this(new DefaultClassResolver(), null);
    }

    public Kryo(ReferenceResolver referenceResolver) {
        this(new DefaultClassResolver(), referenceResolver);
    }

    public Kryo(ClassResolver classResolver, ReferenceResolver referenceResolver) {
        if (classResolver == null) {
            throw new IllegalArgumentException("classResolver cannot be null.");
        }
        this.classResolver = classResolver;
        classResolver.setKryo(this);
        this.referenceResolver = referenceResolver;
        if (referenceResolver != null) {
            referenceResolver.setKryo(this);
            this.references = true;
        }
        this.addDefaultSerializer(byte[].class, DefaultArraySerializers.ByteArraySerializer.class);
        this.addDefaultSerializer(char[].class, DefaultArraySerializers.CharArraySerializer.class);
        this.addDefaultSerializer(short[].class, DefaultArraySerializers.ShortArraySerializer.class);
        this.addDefaultSerializer(int[].class, DefaultArraySerializers.IntArraySerializer.class);
        this.addDefaultSerializer(long[].class, DefaultArraySerializers.LongArraySerializer.class);
        this.addDefaultSerializer(float[].class, DefaultArraySerializers.FloatArraySerializer.class);
        this.addDefaultSerializer(double[].class, DefaultArraySerializers.DoubleArraySerializer.class);
        this.addDefaultSerializer(boolean[].class, DefaultArraySerializers.BooleanArraySerializer.class);
        this.addDefaultSerializer(String[].class, DefaultArraySerializers.StringArraySerializer.class);
        this.addDefaultSerializer(Object[].class, DefaultArraySerializers.ObjectArraySerializer.class);
        this.addDefaultSerializer(BigInteger.class, DefaultSerializers.BigIntegerSerializer.class);
        this.addDefaultSerializer(BigDecimal.class, DefaultSerializers.BigDecimalSerializer.class);
        this.addDefaultSerializer(Class.class, DefaultSerializers.ClassSerializer.class);
        this.addDefaultSerializer(Date.class, DefaultSerializers.DateSerializer.class);
        this.addDefaultSerializer(Enum.class, DefaultSerializers.EnumSerializer.class);
        this.addDefaultSerializer(EnumSet.class, DefaultSerializers.EnumSetSerializer.class);
        this.addDefaultSerializer(Currency.class, DefaultSerializers.CurrencySerializer.class);
        this.addDefaultSerializer(StringBuffer.class, DefaultSerializers.StringBufferSerializer.class);
        this.addDefaultSerializer(StringBuilder.class, DefaultSerializers.StringBuilderSerializer.class);
        this.addDefaultSerializer(Collections.EMPTY_LIST.getClass(), DefaultSerializers.CollectionsEmptyListSerializer.class);
        this.addDefaultSerializer(Collections.EMPTY_MAP.getClass(), DefaultSerializers.CollectionsEmptyMapSerializer.class);
        this.addDefaultSerializer(Collections.EMPTY_SET.getClass(), DefaultSerializers.CollectionsEmptySetSerializer.class);
        this.addDefaultSerializer(Collections.singletonList(null).getClass(), DefaultSerializers.CollectionsSingletonListSerializer.class);
        this.addDefaultSerializer(Collections.singletonMap(null, null).getClass(), DefaultSerializers.CollectionsSingletonMapSerializer.class);
        this.addDefaultSerializer(Collections.singleton(null).getClass(), DefaultSerializers.CollectionsSingletonSetSerializer.class);
        this.addDefaultSerializer(TreeSet.class, DefaultSerializers.TreeSetSerializer.class);
        this.addDefaultSerializer(Collection.class, CollectionSerializer.class);
        this.addDefaultSerializer(ConcurrentSkipListMap.class, DefaultSerializers.ConcurrentSkipListMapSerializer.class);
        this.addDefaultSerializer(TreeMap.class, DefaultSerializers.TreeMapSerializer.class);
        this.addDefaultSerializer(Map.class, MapSerializer.class);
        this.addDefaultSerializer(TimeZone.class, DefaultSerializers.TimeZoneSerializer.class);
        this.addDefaultSerializer(Calendar.class, DefaultSerializers.CalendarSerializer.class);
        this.addDefaultSerializer(Locale.class, DefaultSerializers.LocaleSerializer.class);
        this.addDefaultSerializer(Charset.class, DefaultSerializers.CharsetSerializer.class);
        this.addDefaultSerializer(URL.class, DefaultSerializers.URLSerializer.class);
        this.addDefaultSerializer(Arrays.asList(new Object[0]).getClass(), DefaultSerializers.ArraysAsListSerializer.class);
        this.addDefaultSerializer(Void.TYPE, new DefaultSerializers.VoidSerializer());
        this.addDefaultSerializer(PriorityQueue.class, new DefaultSerializers.PriorityQueueSerializer());
        this.addDefaultSerializer(BitSet.class, new DefaultSerializers.BitSetSerializer());
        this.addDefaultSerializer(KryoSerializable.class, DefaultSerializers.KryoSerializableSerializer.class);
        OptionalSerializers.addDefaultSerializers(this);
        TimeSerializers.addDefaultSerializers(this);
        ImmutableCollectionsSerializers.addDefaultSerializers(this);
        if (Util.isClassAvailable("java.lang.Record")) {
            this.addDefaultSerializer("java.lang.Record", RecordSerializer.class);
        }
        this.lowPriorityDefaultSerializerCount = this.defaultSerializers.size();
        this.register(Integer.TYPE, new DefaultSerializers.IntSerializer());
        this.register(String.class, new DefaultSerializers.StringSerializer());
        this.register(Float.TYPE, new DefaultSerializers.FloatSerializer());
        this.register(Boolean.TYPE, new DefaultSerializers.BooleanSerializer());
        this.register(Byte.TYPE, new DefaultSerializers.ByteSerializer());
        this.register(Character.TYPE, new DefaultSerializers.CharSerializer());
        this.register(Short.TYPE, new DefaultSerializers.ShortSerializer());
        this.register(Long.TYPE, new DefaultSerializers.LongSerializer());
        this.register(Double.TYPE, new DefaultSerializers.DoubleSerializer());
    }

    public void setDefaultSerializer(SerializerFactory serializerFactory) {
        if (serializerFactory == null) {
            throw new IllegalArgumentException("serializer cannot be null.");
        }
        this.defaultSerializer = serializerFactory;
    }

    public void setDefaultSerializer(Class<? extends Serializer> clazz) {
        if (clazz == null) {
            throw new IllegalArgumentException("serializer cannot be null.");
        }
        this.defaultSerializer = new SerializerFactory.ReflectionSerializerFactory<Serializer>(clazz);
    }

    public void addDefaultSerializer(Class clazz, Serializer serializer) {
        if (clazz == null) {
            throw new IllegalArgumentException("type cannot be null.");
        }
        if (serializer == null) {
            throw new IllegalArgumentException("serializer cannot be null.");
        }
        this.insertDefaultSerializer(clazz, new SerializerFactory.SingletonSerializerFactory<Serializer>(serializer));
    }

    public void addDefaultSerializer(Class clazz, SerializerFactory serializerFactory) {
        if (clazz == null) {
            throw new IllegalArgumentException("type cannot be null.");
        }
        if (serializerFactory == null) {
            throw new IllegalArgumentException("serializerFactory cannot be null.");
        }
        this.insertDefaultSerializer(clazz, serializerFactory);
    }

    private void addDefaultSerializer(String string, Class<? extends Serializer> clazz) {
        try {
            this.addDefaultSerializer(Class.forName(string), clazz);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new KryoException("default serializer cannot be added: " + string);
        }
    }

    public void addDefaultSerializer(Class clazz, Class<? extends Serializer> clazz2) {
        if (clazz == null) {
            throw new IllegalArgumentException("type cannot be null.");
        }
        if (clazz2 == null) {
            throw new IllegalArgumentException("serializerClass cannot be null.");
        }
        this.insertDefaultSerializer(clazz, new SerializerFactory.ReflectionSerializerFactory<Serializer>(clazz2));
    }

    private int insertDefaultSerializer(Class clazz, SerializerFactory serializerFactory) {
        int n2 = 0;
        int n3 = this.defaultSerializers.size() - this.lowPriorityDefaultSerializerCount;
        for (int i2 = 0; i2 < n3; ++i2) {
            if (!clazz.isAssignableFrom(this.defaultSerializers.get((int)i2).type)) continue;
            n2 = i2 + 1;
        }
        this.defaultSerializers.add(n2, new DefaultSerializerEntry(clazz, serializerFactory));
        return n2;
    }

    public Serializer getDefaultSerializer(Class clazz) {
        if (clazz == null) {
            throw new IllegalArgumentException("type cannot be null.");
        }
        Serializer serializer = this.getDefaultSerializerForAnnotatedType(clazz);
        if (serializer != null) {
            return serializer;
        }
        int n2 = this.defaultSerializers.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            DefaultSerializerEntry defaultSerializerEntry = this.defaultSerializers.get(i2);
            if (!defaultSerializerEntry.type.isAssignableFrom(clazz) || !defaultSerializerEntry.serializerFactory.isSupported(clazz)) continue;
            return defaultSerializerEntry.serializerFactory.newSerializer(this, clazz);
        }
        return this.newDefaultSerializer(clazz);
    }

    protected Serializer getDefaultSerializerForAnnotatedType(Class clazz) {
        if (clazz.isAnnotationPresent(DefaultSerializer.class)) {
            DefaultSerializer defaultSerializer = clazz.getAnnotation(DefaultSerializer.class);
            return Util.newFactory(defaultSerializer.serializerFactory(), defaultSerializer.value()).newSerializer(this, clazz);
        }
        return null;
    }

    protected Serializer newDefaultSerializer(Class clazz) {
        return this.defaultSerializer.newSerializer(this, clazz);
    }

    public Registration register(Class clazz) {
        Registration registration = this.classResolver.getRegistration(clazz);
        if (registration != null) {
            return registration;
        }
        return this.register(clazz, this.getDefaultSerializer(clazz));
    }

    public Registration register(Class clazz, int n2) {
        Registration registration = this.classResolver.getRegistration(clazz);
        if (registration != null) {
            return registration;
        }
        return this.register(clazz, this.getDefaultSerializer(clazz), n2);
    }

    public Registration register(Class clazz, Serializer serializer) {
        Registration registration = this.classResolver.getRegistration(clazz);
        if (registration != null) {
            registration.setSerializer(serializer);
            return registration;
        }
        return this.classResolver.register(new Registration(clazz, serializer, this.getNextRegistrationId()));
    }

    public Registration register(Class clazz, Serializer serializer, int n2) {
        if (n2 < 0) {
            throw new IllegalArgumentException("id must be >= 0: " + n2);
        }
        return this.register(new Registration(clazz, serializer, n2));
    }

    public Registration register(Registration registration) {
        int n2 = registration.getId();
        if (n2 < 0) {
            throw new IllegalArgumentException("id must be > 0: " + n2);
        }
        Registration registration2 = this.classResolver.unregister(n2);
        if (Log.DEBUG && registration2 != null && registration2.getType() != registration.getType()) {
            Log.debug("kryo", "Registration overwritten: " + registration2 + " -> " + registration);
        }
        return this.classResolver.register(registration);
    }

    public int getNextRegistrationId() {
        while (this.nextRegisterID != -2) {
            if (this.classResolver.getRegistration(this.nextRegisterID) == null) {
                return this.nextRegisterID;
            }
            ++this.nextRegisterID;
        }
        throw new KryoException("No registration IDs are available.");
    }

    public Registration getRegistration(Class clazz) {
        if (clazz == null) {
            throw new IllegalArgumentException("type cannot be null.");
        }
        Registration registration = this.classResolver.getRegistration(clazz);
        if (registration == null) {
            if (Proxy.isProxyClass(clazz)) {
                registration = this.getRegistration(InvocationHandler.class);
            } else if (!clazz.isEnum() && Enum.class.isAssignableFrom(clazz) && clazz != Enum.class) {
                while ((clazz = clazz.getSuperclass()) != null) {
                    if (!clazz.isEnum()) continue;
                    registration = this.classResolver.getRegistration(clazz);
                    break;
                }
            } else if (EnumSet.class.isAssignableFrom(clazz)) {
                registration = this.classResolver.getRegistration(EnumSet.class);
            } else if (this.isClosure(clazz)) {
                registration = this.classResolver.getRegistration(ClosureSerializer.Closure.class);
            }
            if (registration == null) {
                if (this.registrationRequired) {
                    throw new IllegalArgumentException(this.unregisteredClassMessage(clazz));
                }
                if (Log.WARN && this.warnUnregisteredClasses) {
                    Log.warn(this.unregisteredClassMessage(clazz));
                }
                registration = this.classResolver.registerImplicit(clazz);
            }
        }
        return registration;
    }

    protected String unregisteredClassMessage(Class clazz) {
        return "Class is not registered: " + Util.className(clazz) + "\nNote: To register this class use: kryo.register(" + Util.canonicalName(clazz) + ".class);";
    }

    public Registration getRegistration(int n2) {
        return this.classResolver.getRegistration(n2);
    }

    public Serializer getSerializer(Class clazz) {
        return this.getRegistration(clazz).getSerializer();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Registration writeClass(Output output, Class clazz) {
        if (output == null) {
            throw new IllegalArgumentException("output cannot be null.");
        }
        try {
            Registration registration = this.classResolver.writeClass(output, clazz);
            return registration;
        }
        finally {
            if (this.depth == 0 && this.autoReset) {
                this.reset();
            }
        }
    }

    public void writeObject(Output output, Object object) {
        if (output == null) {
            throw new IllegalArgumentException("output cannot be null.");
        }
        if (object == null) {
            throw new IllegalArgumentException("object cannot be null.");
        }
        this.beginObject();
        try {
            if (this.references && this.writeReferenceOrNull(output, object, false)) {
                return;
            }
            if (Log.TRACE || Log.DEBUG && this.depth == 1) {
                Util.log("Write", object, output.position());
            }
            this.getRegistration(object.getClass()).getSerializer().write(this, output, object);
        }
        finally {
            if (--this.depth == 0 && this.autoReset) {
                this.reset();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void writeObject(Output output, Object object, Serializer serializer) {
        if (output == null) {
            throw new IllegalArgumentException("output cannot be null.");
        }
        if (object == null) {
            throw new IllegalArgumentException("object cannot be null.");
        }
        if (serializer == null) {
            throw new IllegalArgumentException("serializer cannot be null.");
        }
        this.beginObject();
        try {
            if (this.references && this.writeReferenceOrNull(output, object, false)) {
                return;
            }
            if (Log.TRACE || Log.DEBUG && this.depth == 1) {
                Util.log("Write", object, output.position());
            }
            serializer.write(this, output, object);
        }
        finally {
            if (--this.depth == 0 && this.autoReset) {
                this.reset();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void writeObjectOrNull(Output output, Object object, Class clazz) {
        if (output == null) {
            throw new IllegalArgumentException("output cannot be null.");
        }
        this.beginObject();
        try {
            Serializer serializer = this.getRegistration(clazz).getSerializer();
            if (this.references) {
                if (this.writeReferenceOrNull(output, object, true)) {
                    return;
                }
            } else if (!serializer.getAcceptsNull()) {
                if (object == null) {
                    if (Log.TRACE || Log.DEBUG && this.depth == 1) {
                        Util.log("Write", object, output.position());
                    }
                    output.writeByte((byte)0);
                    return;
                }
                if (Log.TRACE) {
                    Log.trace("kryo", "Write: <not null>" + Util.pos(output.position()));
                }
                output.writeByte((byte)1);
            }
            if (Log.TRACE || Log.DEBUG && this.depth == 1) {
                Util.log("Write", object, output.position());
            }
            serializer.write(this, output, object);
        }
        finally {
            if (--this.depth == 0 && this.autoReset) {
                this.reset();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void writeObjectOrNull(Output output, Object object, Serializer serializer) {
        if (output == null) {
            throw new IllegalArgumentException("output cannot be null.");
        }
        if (serializer == null) {
            throw new IllegalArgumentException("serializer cannot be null.");
        }
        this.beginObject();
        try {
            if (this.references) {
                if (this.writeReferenceOrNull(output, object, true)) {
                    return;
                }
            } else if (!serializer.getAcceptsNull()) {
                if (object == null) {
                    if (Log.TRACE || Log.DEBUG && this.depth == 1) {
                        Util.log("Write", null, output.position());
                    }
                    output.writeByte((byte)0);
                    return;
                }
                if (Log.TRACE) {
                    Log.trace("kryo", "Write: <not null>" + Util.pos(output.position()));
                }
                output.writeByte((byte)1);
            }
            if (Log.TRACE || Log.DEBUG && this.depth == 1) {
                Util.log("Write", object, output.position());
            }
            serializer.write(this, output, object);
        }
        finally {
            if (--this.depth == 0 && this.autoReset) {
                this.reset();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void writeClassAndObject(Output output, Object object) {
        if (output == null) {
            throw new IllegalArgumentException("output cannot be null.");
        }
        this.beginObject();
        try {
            if (object == null) {
                this.writeClass(output, null);
                return;
            }
            Registration registration = this.writeClass(output, object.getClass());
            if (this.references && this.writeReferenceOrNull(output, object, false)) {
                return;
            }
            if (Log.TRACE || Log.DEBUG && this.depth == 1) {
                Util.log("Write", object, output.position());
            }
            registration.getSerializer().write(this, output, object);
        }
        finally {
            if (--this.depth == 0 && this.autoReset) {
                this.reset();
            }
        }
    }

    boolean writeReferenceOrNull(Output output, Object object, boolean bl2) {
        if (object == null) {
            if (Log.TRACE || Log.DEBUG && this.depth == 1) {
                Util.log("Write", null, output.position());
            }
            output.writeByte((byte)0);
            return true;
        }
        if (!this.referenceResolver.useReferences(object.getClass())) {
            if (bl2) {
                if (Log.TRACE) {
                    Log.trace("kryo", "Write: <not null>" + Util.pos(output.position()));
                }
                output.writeByte((byte)1);
            }
            return false;
        }
        int n2 = this.referenceResolver.getWrittenId(object);
        if (n2 != -1) {
            if (Log.DEBUG) {
                Log.debug("kryo", "Write reference " + n2 + ": " + Util.string(object) + Util.pos(output.position()));
            }
            output.writeVarInt(n2 + 2, true);
            return true;
        }
        n2 = this.referenceResolver.addWrittenObject(object);
        if (Log.TRACE) {
            Log.trace("kryo", "Write: <not null>" + Util.pos(output.position()));
        }
        output.writeByte((byte)1);
        if (Log.TRACE) {
            Log.trace("kryo", "Write initial reference " + n2 + ": " + Util.string(object) + Util.pos(output.position()));
        }
        return false;
    }

    public Registration readClass(Input input) {
        if (input == null) {
            throw new IllegalArgumentException("input cannot be null.");
        }
        try {
            Registration registration = this.classResolver.readClass(input);
            return registration;
        }
        finally {
            if (this.depth == 0 && this.autoReset) {
                this.reset();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public <T> T readObject(Input input, Class<T> clazz) {
        if (input == null) {
            throw new IllegalArgumentException("input cannot be null.");
        }
        if (clazz == null) {
            throw new IllegalArgumentException("type cannot be null.");
        }
        this.beginObject();
        try {
            T t2;
            if (this.references) {
                int n2 = this.readReferenceOrNull(input, clazz, false);
                if (n2 == -1) {
                    Object object = this.readObject;
                    return (T)object;
                }
                t2 = this.getRegistration(clazz).getSerializer().read(this, input, clazz);
                if (n2 == this.readReferenceIds.size) {
                    this.reference(t2);
                }
            } else {
                t2 = this.getRegistration(clazz).getSerializer().read(this, input, clazz);
            }
            if (Log.TRACE || Log.DEBUG && this.depth == 1) {
                Util.log("Read", t2, input.position());
            }
            T t3 = t2;
            return t3;
        }
        finally {
            if (--this.depth == 0 && this.autoReset) {
                this.reset();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public <T> T readObject(Input input, Class<T> clazz, Serializer serializer) {
        if (input == null) {
            throw new IllegalArgumentException("input cannot be null.");
        }
        if (clazz == null) {
            throw new IllegalArgumentException("type cannot be null.");
        }
        if (serializer == null) {
            throw new IllegalArgumentException("serializer cannot be null.");
        }
        this.beginObject();
        try {
            T t2;
            if (this.references) {
                int n2 = this.readReferenceOrNull(input, clazz, false);
                if (n2 == -1) {
                    Object object = this.readObject;
                    return (T)object;
                }
                t2 = serializer.read(this, input, clazz);
                if (n2 == this.readReferenceIds.size) {
                    this.reference(t2);
                }
            } else {
                t2 = serializer.read(this, input, clazz);
            }
            if (Log.TRACE || Log.DEBUG && this.depth == 1) {
                Util.log("Read", t2, input.position());
            }
            T t3 = t2;
            return t3;
        }
        finally {
            if (--this.depth == 0 && this.autoReset) {
                this.reset();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public <T> T readObjectOrNull(Input input, Class<T> clazz) {
        if (input == null) {
            throw new IllegalArgumentException("input cannot be null.");
        }
        if (clazz == null) {
            throw new IllegalArgumentException("type cannot be null.");
        }
        this.beginObject();
        try {
            T t2;
            if (this.references) {
                int n2 = this.readReferenceOrNull(input, clazz, true);
                if (n2 == -1) {
                    Object object = this.readObject;
                    return (T)object;
                }
                t2 = this.getRegistration(clazz).getSerializer().read(this, input, clazz);
                if (n2 == this.readReferenceIds.size) {
                    this.reference(t2);
                }
            } else {
                Serializer serializer = this.getRegistration(clazz).getSerializer();
                if (!serializer.getAcceptsNull() && input.readByte() == 0) {
                    if (Log.TRACE || Log.DEBUG && this.depth == 1) {
                        Util.log("Read", null, input.position());
                    }
                    T t3 = null;
                    return t3;
                }
                t2 = serializer.read(this, input, clazz);
            }
            if (Log.TRACE || Log.DEBUG && this.depth == 1) {
                Util.log("Read", t2, input.position());
            }
            T t4 = t2;
            return t4;
        }
        finally {
            if (--this.depth == 0 && this.autoReset) {
                this.reset();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public <T> T readObjectOrNull(Input input, Class<T> clazz, Serializer serializer) {
        if (input == null) {
            throw new IllegalArgumentException("input cannot be null.");
        }
        if (clazz == null) {
            throw new IllegalArgumentException("type cannot be null.");
        }
        if (serializer == null) {
            throw new IllegalArgumentException("serializer cannot be null.");
        }
        this.beginObject();
        try {
            T t2;
            if (this.references) {
                int n2 = this.readReferenceOrNull(input, clazz, true);
                if (n2 == -1) {
                    Object object = this.readObject;
                    return (T)object;
                }
                t2 = serializer.read(this, input, clazz);
                if (n2 == this.readReferenceIds.size) {
                    this.reference(t2);
                }
            } else {
                if (!serializer.getAcceptsNull() && input.readByte() == 0) {
                    if (Log.TRACE || Log.DEBUG && this.depth == 1) {
                        Util.log("Read", null, input.position());
                    }
                    T t3 = null;
                    return t3;
                }
                t2 = serializer.read(this, input, clazz);
            }
            if (Log.TRACE || Log.DEBUG && this.depth == 1) {
                Util.log("Read", t2, input.position());
            }
            T t4 = t2;
            return t4;
        }
        finally {
            if (--this.depth == 0 && this.autoReset) {
                this.reset();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Object readClassAndObject(Input input) {
        if (input == null) {
            throw new IllegalArgumentException("input cannot be null.");
        }
        this.beginObject();
        try {
            Object t2;
            Registration registration = this.readClass(input);
            if (registration == null) {
                Object var3_3 = null;
                return var3_3;
            }
            Class clazz = registration.getType();
            if (this.references) {
                int n2 = this.readReferenceOrNull(input, clazz, false);
                if (n2 == -1) {
                    Object object = this.readObject;
                    return object;
                }
                t2 = registration.getSerializer().read(this, input, clazz);
                if (n2 == this.readReferenceIds.size) {
                    this.reference(t2);
                }
            } else {
                t2 = registration.getSerializer().read(this, input, clazz);
            }
            if (Log.TRACE || Log.DEBUG && this.depth == 1) {
                Util.log("Read", t2, input.position());
            }
            Object t3 = t2;
            return t3;
        }
        finally {
            if (--this.depth == 0 && this.autoReset) {
                this.reset();
            }
        }
    }

    int readReferenceOrNull(Input input, Class clazz, boolean bl2) {
        int n2;
        if (clazz.isPrimitive()) {
            clazz = Util.getWrapperClass(clazz);
        }
        boolean bl3 = this.referenceResolver.useReferences(clazz);
        if (bl2) {
            n2 = input.readVarInt(true);
            if (n2 == 0) {
                if (Log.TRACE || Log.DEBUG && this.depth == 1) {
                    Util.log("Read", null, input.position());
                }
                this.readObject = null;
                return -1;
            }
            if (!bl3) {
                this.readReferenceIds.add(-2);
                return this.readReferenceIds.size;
            }
        } else {
            if (!bl3) {
                this.readReferenceIds.add(-2);
                return this.readReferenceIds.size;
            }
            n2 = input.readVarInt(true);
        }
        if (n2 == 1) {
            if (Log.TRACE) {
                Log.trace("kryo", "Read: <not null>" + Util.pos(input.position()));
            }
            n2 = this.referenceResolver.nextReadId(clazz);
            if (Log.TRACE) {
                Log.trace("kryo", "Read initial reference " + n2 + ": " + Util.className(clazz) + Util.pos(input.position()));
            }
            this.readReferenceIds.add(n2);
            return this.readReferenceIds.size;
        }
        this.readObject = this.referenceResolver.getReadObject(clazz, n2 -= 2);
        if (Log.DEBUG) {
            Log.debug("kryo", "Read reference " + n2 + ": " + Util.string(this.readObject) + Util.pos(input.position()));
        }
        return -1;
    }

    public void reference(Object object) {
        int n2;
        if (this.copyDepth > 0) {
            if (this.needsCopyReference != null) {
                if (object == null) {
                    throw new IllegalArgumentException("object cannot be null.");
                }
                this.originalToCopy.put(this.needsCopyReference, object);
                this.needsCopyReference = null;
            }
        } else if (this.references && object != null && (n2 = this.readReferenceIds.pop()) != -2) {
            this.referenceResolver.setReadObject(n2, object);
        }
    }

    public void reset() {
        this.depth = 0;
        if (this.graphContext != null) {
            this.graphContext.clear(2048);
        }
        this.classResolver.reset();
        if (this.references) {
            this.referenceResolver.reset();
            this.readObject = null;
        }
        this.copyDepth = 0;
        if (this.originalToCopy != null) {
            this.originalToCopy.clear(2048);
        }
        if (Log.TRACE) {
            Log.trace("kryo", "Object graph complete.");
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public <T> T copy(T t2) {
        if (t2 == null) {
            return null;
        }
        if (this.copyShallow) {
            return t2;
        }
        ++this.copyDepth;
        try {
            Object v2;
            if (this.originalToCopy == null) {
                this.originalToCopy = new IdentityMap();
            }
            if ((v2 = this.originalToCopy.get(t2)) != null) {
                Object v3 = v2;
                return (T)v3;
            }
            if (this.copyReferences) {
                this.needsCopyReference = t2;
            }
            Object t3 = t2 instanceof KryoCopyable ? ((KryoCopyable)t2).copy(this) : this.getSerializer(t2.getClass()).copy(this, t2);
            if (this.needsCopyReference != null) {
                this.reference(t3);
            }
            if (Log.TRACE || Log.DEBUG && this.copyDepth == 1) {
                Util.log("Copy", t3, -1);
            }
            Object t4 = t3;
            return t4;
        }
        finally {
            if (--this.copyDepth == 0) {
                this.reset();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public <T> T copy(T t2, Serializer serializer) {
        if (t2 == null) {
            return null;
        }
        if (this.copyShallow) {
            return t2;
        }
        ++this.copyDepth;
        try {
            Object v2;
            if (this.originalToCopy == null) {
                this.originalToCopy = new IdentityMap();
            }
            if ((v2 = this.originalToCopy.get(t2)) != null) {
                Object v3 = v2;
                return (T)v3;
            }
            if (this.copyReferences) {
                this.needsCopyReference = t2;
            }
            Object t3 = t2 instanceof KryoCopyable ? ((KryoCopyable)t2).copy(this) : serializer.copy(this, t2);
            if (this.needsCopyReference != null) {
                this.reference(t3);
            }
            if (Log.TRACE || Log.DEBUG && this.copyDepth == 1) {
                Util.log("Copy", t3, -1);
            }
            Object t4 = t3;
            return t4;
        }
        finally {
            if (--this.copyDepth == 0) {
                this.reset();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public <T> T copyShallow(T t2) {
        if (t2 == null) {
            return null;
        }
        ++this.copyDepth;
        this.copyShallow = true;
        try {
            Object v2;
            if (this.originalToCopy == null) {
                this.originalToCopy = new IdentityMap();
            }
            if ((v2 = this.originalToCopy.get(t2)) != null) {
                Object v3 = v2;
                return (T)v3;
            }
            if (this.copyReferences) {
                this.needsCopyReference = t2;
            }
            Object t3 = t2 instanceof KryoCopyable ? ((KryoCopyable)t2).copy(this) : this.getSerializer(t2.getClass()).copy(this, t2);
            if (this.needsCopyReference != null) {
                this.reference(t3);
            }
            if (Log.TRACE || Log.DEBUG && this.copyDepth == 1) {
                Util.log("Shallow copy", t3, -1);
            }
            Object t4 = t3;
            return t4;
        }
        finally {
            this.copyShallow = false;
            if (--this.copyDepth == 0) {
                this.reset();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public <T> T copyShallow(T t2, Serializer serializer) {
        if (t2 == null) {
            return null;
        }
        ++this.copyDepth;
        this.copyShallow = true;
        try {
            Object v2;
            if (this.originalToCopy == null) {
                this.originalToCopy = new IdentityMap();
            }
            if ((v2 = this.originalToCopy.get(t2)) != null) {
                Object v3 = v2;
                return (T)v3;
            }
            if (this.copyReferences) {
                this.needsCopyReference = t2;
            }
            Object t3 = t2 instanceof KryoCopyable ? ((KryoCopyable)t2).copy(this) : serializer.copy(this, t2);
            if (this.needsCopyReference != null) {
                this.reference(t3);
            }
            if (Log.TRACE || Log.DEBUG && this.copyDepth == 1) {
                Util.log("Shallow copy", t3, -1);
            }
            Object t4 = t3;
            return t4;
        }
        finally {
            this.copyShallow = false;
            if (--this.copyDepth == 0) {
                this.reset();
            }
        }
    }

    private void beginObject() {
        if (Log.DEBUG) {
            if (this.depth == 0) {
                this.thread = Thread.currentThread();
            } else if (this.thread != Thread.currentThread()) {
                throw new ConcurrentModificationException("Kryo must not be accessed concurrently by multiple threads.");
            }
        }
        if (this.depth == this.maxDepth) {
            throw new KryoException("Max depth exceeded: " + this.depth);
        }
        ++this.depth;
    }

    public ClassResolver getClassResolver() {
        return this.classResolver;
    }

    public ReferenceResolver getReferenceResolver() {
        return this.referenceResolver;
    }

    public void setClassLoader(ClassLoader classLoader) {
        if (classLoader == null) {
            throw new IllegalArgumentException("classLoader cannot be null.");
        }
        this.classLoader = classLoader;
    }

    public ClassLoader getClassLoader() {
        return this.classLoader;
    }

    public void setRegistrationRequired(boolean bl2) {
        this.registrationRequired = bl2;
        if (Log.TRACE) {
            Log.trace("kryo", "Registration required: " + bl2);
        }
    }

    public boolean isRegistrationRequired() {
        return this.registrationRequired;
    }

    public void setWarnUnregisteredClasses(boolean bl2) {
        this.warnUnregisteredClasses = bl2;
        if (Log.TRACE) {
            Log.trace("kryo", "Warn unregistered classes: " + bl2);
        }
    }

    public boolean getWarnUnregisteredClasses() {
        return this.warnUnregisteredClasses;
    }

    public boolean setReferences(boolean bl2) {
        boolean bl3 = this.references;
        if (bl2 == bl3) {
            return bl2;
        }
        if (bl3) {
            this.referenceResolver.reset();
            this.readObject = null;
        }
        this.references = bl2;
        if (bl2 && this.referenceResolver == null) {
            this.referenceResolver = new MapReferenceResolver();
        }
        if (Log.TRACE) {
            Log.trace("kryo", "References: " + bl2);
        }
        return !bl2;
    }

    public void setCopyReferences(boolean bl2) {
        this.copyReferences = bl2;
    }

    public void setReferenceResolver(ReferenceResolver referenceResolver) {
        if (referenceResolver == null) {
            throw new IllegalArgumentException("referenceResolver cannot be null.");
        }
        this.references = true;
        this.referenceResolver = referenceResolver;
        if (Log.TRACE) {
            Log.trace("kryo", "Reference resolver: " + referenceResolver.getClass().getName());
        }
    }

    public boolean getReferences() {
        return this.references;
    }

    public void setInstantiatorStrategy(InstantiatorStrategy instantiatorStrategy) {
        this.strategy = instantiatorStrategy;
    }

    public InstantiatorStrategy getInstantiatorStrategy() {
        return this.strategy;
    }

    protected ObjectInstantiator newInstantiator(Class clazz) {
        return this.strategy.newInstantiatorOf(clazz);
    }

    public <T> T newInstance(Class<T> clazz) {
        Registration registration = this.getRegistration(clazz);
        ObjectInstantiator objectInstantiator = registration.getInstantiator();
        if (objectInstantiator == null) {
            objectInstantiator = this.newInstantiator(clazz);
            registration.setInstantiator(objectInstantiator);
        }
        return objectInstantiator.newInstance();
    }

    public ObjectMap getContext() {
        if (this.context == null) {
            this.context = new ObjectMap();
        }
        return this.context;
    }

    public ObjectMap getGraphContext() {
        if (this.graphContext == null) {
            this.graphContext = new ObjectMap();
        }
        return this.graphContext;
    }

    public int getDepth() {
        return this.depth;
    }

    public IdentityMap getOriginalToCopyMap() {
        return this.originalToCopy;
    }

    public void setAutoReset(boolean bl2) {
        this.autoReset = bl2;
    }

    public void setMaxDepth(int n2) {
        if (n2 <= 0) {
            throw new IllegalArgumentException("maxDepth must be > 0.");
        }
        this.maxDepth = n2;
    }

    public boolean isFinal(Class clazz) {
        if (clazz == null) {
            throw new IllegalArgumentException("type cannot be null.");
        }
        if (clazz.isArray()) {
            return Modifier.isFinal(Util.getElementClass(clazz).getModifiers());
        }
        return Modifier.isFinal(clazz.getModifiers());
    }

    public boolean isClosure(Class clazz) {
        if (clazz == null) {
            throw new IllegalArgumentException("type cannot be null.");
        }
        return clazz.getName().indexOf(47) >= 0;
    }

    public Generics getGenerics() {
        return this.generics;
    }

    public void setOptimizedGenerics(boolean bl2) {
        this.generics = bl2 ? new DefaultGenerics(this) : NoGenerics.INSTANCE;
    }

    static final class DefaultSerializerEntry {
        final Class type;
        final SerializerFactory serializerFactory;

        DefaultSerializerEntry(Class clazz, SerializerFactory serializerFactory) {
            this.type = clazz;
            this.serializerFactory = serializerFactory;
        }
    }
}

