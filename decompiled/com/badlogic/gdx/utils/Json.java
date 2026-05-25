/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ArrayMap;
import com.badlogic.gdx.utils.IntMap;
import com.badlogic.gdx.utils.IntSet;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.JsonWriter;
import com.badlogic.gdx.utils.LongMap;
import com.badlogic.gdx.utils.Null;
import com.badlogic.gdx.utils.ObjectFloatMap;
import com.badlogic.gdx.utils.ObjectIntMap;
import com.badlogic.gdx.utils.ObjectMap;
import com.badlogic.gdx.utils.ObjectSet;
import com.badlogic.gdx.utils.OrderedMap;
import com.badlogic.gdx.utils.Queue;
import com.badlogic.gdx.utils.SerializationException;
import com.badlogic.gdx.utils.StreamUtils;
import com.badlogic.gdx.utils.reflect.ArrayReflection;
import com.badlogic.gdx.utils.reflect.ClassReflection;
import com.badlogic.gdx.utils.reflect.Constructor;
import com.badlogic.gdx.utils.reflect.Field;
import com.badlogic.gdx.utils.reflect.ReflectionException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.security.AccessControlException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Json {
    private static final boolean debug = false;
    private JsonWriter writer;
    private String typeName = "class";
    private boolean usePrototypes = true;
    private JsonWriter.OutputType outputType;
    private boolean quoteLongValues;
    private boolean ignoreUnknownFields;
    private boolean ignoreDeprecated;
    private boolean readDeprecated;
    private boolean enumNames = true;
    private boolean sortFields;
    private Serializer defaultSerializer;
    private final ObjectMap<Class, OrderedMap<String, FieldMetadata>> typeToFields = new ObjectMap();
    private final ObjectMap<String, Class> tagToClass = new ObjectMap();
    private final ObjectMap<Class, String> classToTag = new ObjectMap();
    private final ObjectMap<Class, Serializer> classToSerializer = new ObjectMap();
    private final ObjectMap<Class, Object[]> classToDefaultValues = new ObjectMap();
    private final Object[] equals1 = new Object[]{null};
    private final Object[] equals2 = new Object[]{null};

    public Json() {
        this.outputType = JsonWriter.OutputType.minimal;
    }

    public Json(JsonWriter.OutputType outputType) {
        this.outputType = outputType;
    }

    public void setIgnoreUnknownFields(boolean bl2) {
        this.ignoreUnknownFields = bl2;
    }

    public boolean getIgnoreUnknownFields() {
        return this.ignoreUnknownFields;
    }

    public void setIgnoreDeprecated(boolean bl2) {
        this.ignoreDeprecated = bl2;
    }

    public void setReadDeprecated(boolean bl2) {
        this.readDeprecated = bl2;
    }

    public void setOutputType(JsonWriter.OutputType outputType) {
        this.outputType = outputType;
    }

    public void setQuoteLongValues(boolean bl2) {
        this.quoteLongValues = bl2;
    }

    public void setEnumNames(boolean bl2) {
        this.enumNames = bl2;
    }

    public void addClassTag(String string, Class clazz) {
        this.tagToClass.put(string, clazz);
        this.classToTag.put(clazz, string);
    }

    @Null
    public Class getClass(String string) {
        return this.tagToClass.get(string);
    }

    @Null
    public String getTag(Class clazz) {
        return this.classToTag.get(clazz);
    }

    public void setTypeName(@Null String string) {
        this.typeName = string;
    }

    public void setDefaultSerializer(@Null Serializer serializer) {
        this.defaultSerializer = serializer;
    }

    public <T> void setSerializer(Class<T> clazz, Serializer<T> serializer) {
        this.classToSerializer.put(clazz, serializer);
    }

    public <T> Serializer<T> getSerializer(Class<T> clazz) {
        return this.classToSerializer.get(clazz);
    }

    public void setUsePrototypes(boolean bl2) {
        this.usePrototypes = bl2;
    }

    public void setElementType(Class clazz, String string, Class clazz2) {
        FieldMetadata fieldMetadata = (FieldMetadata)this.getFields(clazz).get(string);
        if (fieldMetadata == null) {
            throw new SerializationException("Field not found: " + string + " (" + clazz.getName() + ")");
        }
        fieldMetadata.elementType = clazz2;
    }

    public void setDeprecated(Class clazz, String string, boolean bl2) {
        FieldMetadata fieldMetadata = (FieldMetadata)this.getFields(clazz).get(string);
        if (fieldMetadata == null) {
            throw new SerializationException("Field not found: " + string + " (" + clazz.getName() + ")");
        }
        fieldMetadata.deprecated = bl2;
    }

    public void setSortFields(boolean bl2) {
        this.sortFields = bl2;
    }

    protected void sortFields(Class clazz, Array<String> array) {
        if (this.sortFields) {
            array.sort();
        }
    }

    private OrderedMap<String, FieldMetadata> getFields(Class clazz) {
        OrderedMap<String, FieldMetadata> orderedMap = this.typeToFields.get(clazz);
        if (orderedMap != null) {
            return orderedMap;
        }
        Array array = new Array();
        for (Class clazz2 = clazz; clazz2 != Object.class; clazz2 = clazz2.getSuperclass()) {
            array.add(clazz2);
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = array.size - 1; i2 >= 0; --i2) {
            Collections.addAll(arrayList, ClassReflection.getDeclaredFields((Class)array.get(i2)));
        }
        OrderedMap<String, FieldMetadata> orderedMap2 = new OrderedMap<String, FieldMetadata>(arrayList.size());
        int n2 = arrayList.size();
        for (int i3 = 0; i3 < n2; ++i3) {
            Field field = (Field)arrayList.get(i3);
            if (field.isTransient() || field.isStatic() || field.isSynthetic()) continue;
            if (!field.isAccessible()) {
                try {
                    field.setAccessible(true);
                }
                catch (AccessControlException accessControlException) {
                    continue;
                }
            }
            orderedMap2.put(field.getName(), new FieldMetadata(field));
        }
        this.sortFields(clazz, orderedMap2.keys);
        this.typeToFields.put(clazz, orderedMap2);
        return orderedMap2;
    }

    public String toJson(@Null Object object) {
        return this.toJson(object, object == null ? null : object.getClass(), (Class)null);
    }

    public String toJson(@Null Object object, @Null Class clazz) {
        return this.toJson(object, clazz, (Class)null);
    }

    public String toJson(@Null Object object, @Null Class clazz, @Null Class clazz2) {
        StringWriter stringWriter = new StringWriter();
        this.toJson(object, clazz, clazz2, stringWriter);
        return stringWriter.toString();
    }

    public void toJson(@Null Object object, FileHandle fileHandle) {
        this.toJson(object, object == null ? null : object.getClass(), null, fileHandle);
    }

    public void toJson(@Null Object object, @Null Class clazz, FileHandle fileHandle) {
        this.toJson(object, clazz, null, fileHandle);
    }

    public void toJson(@Null Object object, @Null Class clazz, @Null Class clazz2, FileHandle fileHandle) {
        Writer writer = null;
        try {
            writer = fileHandle.writer(false, "UTF-8");
            this.toJson(object, clazz, clazz2, writer);
        }
        catch (Exception exception) {
            try {
                throw new SerializationException("Error writing file: " + fileHandle, exception);
            }
            catch (Throwable throwable) {
                StreamUtils.closeQuietly(writer);
                throw throwable;
            }
        }
        StreamUtils.closeQuietly(writer);
    }

    public void toJson(@Null Object object, Writer writer) {
        this.toJson(object, object == null ? null : object.getClass(), null, writer);
    }

    public void toJson(@Null Object object, @Null Class clazz, Writer writer) {
        this.toJson(object, clazz, null, writer);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void toJson(@Null Object object, @Null Class clazz, @Null Class clazz2, Writer writer) {
        this.setWriter(writer);
        try {
            this.writeValue(object, clazz, clazz2);
        }
        finally {
            StreamUtils.closeQuietly(this.writer);
            this.writer = null;
        }
    }

    public void setWriter(Writer writer) {
        if (!(writer instanceof JsonWriter)) {
            writer = new JsonWriter(writer);
        }
        this.writer = (JsonWriter)writer;
        this.writer.setOutputType(this.outputType);
        this.writer.setQuoteLongValues(this.quoteLongValues);
    }

    public JsonWriter getWriter() {
        return this.writer;
    }

    public void writeFields(Object object) {
        Class<?> clazz = object.getClass();
        Object[] objectArray = this.getDefaultValues(clazz);
        OrderedMap<String, FieldMetadata> orderedMap = this.getFields(clazz);
        int n2 = 0;
        Array<String> array = orderedMap.orderedKeys();
        int n3 = array.size;
        for (int i2 = 0; i2 < n3; ++i2) {
            Object object2;
            FieldMetadata fieldMetadata = (FieldMetadata)orderedMap.get(array.get(i2));
            if (this.ignoreDeprecated && fieldMetadata.deprecated) continue;
            Field field = fieldMetadata.field;
            try {
                Object object3 = field.get(object);
                if (objectArray != null) {
                    object2 = objectArray[n2++];
                    if (object3 == null && object2 == null) continue;
                    if (object3 != null && object2 != null) {
                        if (object3.equals(object2)) continue;
                        if (object3.getClass().isArray() && object2.getClass().isArray()) {
                            this.equals1[0] = object3;
                            this.equals2[0] = object2;
                            if (Arrays.deepEquals(this.equals1, this.equals2)) continue;
                        }
                    }
                }
                this.writer.name(field.getName());
                this.writeValue(object3, field.getType(), fieldMetadata.elementType);
                continue;
            }
            catch (ReflectionException reflectionException) {
                throw new SerializationException("Error accessing field: " + field.getName() + " (" + clazz.getName() + ")", reflectionException);
            }
            catch (SerializationException serializationException) {
                serializationException.addTrace(field + " (" + clazz.getName() + ")");
                throw serializationException;
            }
            catch (Exception exception) {
                object2 = new SerializationException(exception);
                ((SerializationException)object2).addTrace(field + " (" + clazz.getName() + ")");
                throw object2;
            }
        }
    }

    @Null
    private Object[] getDefaultValues(Class clazz) {
        Object object;
        if (!this.usePrototypes) {
            return null;
        }
        if (this.classToDefaultValues.containsKey(clazz)) {
            return this.classToDefaultValues.get(clazz);
        }
        try {
            object = this.newInstance(clazz);
        }
        catch (Exception exception) {
            this.classToDefaultValues.put(clazz, null);
            return null;
        }
        OrderedMap<String, FieldMetadata> orderedMap = this.getFields(clazz);
        Object[] objectArray = new Object[orderedMap.size];
        this.classToDefaultValues.put(clazz, objectArray);
        int n2 = 0;
        Array<String> array = orderedMap.orderedKeys();
        int n3 = array.size;
        for (int i2 = 0; i2 < n3; ++i2) {
            FieldMetadata fieldMetadata = (FieldMetadata)orderedMap.get(array.get(i2));
            if (this.ignoreDeprecated && fieldMetadata.deprecated) continue;
            Field field = fieldMetadata.field;
            try {
                objectArray[n2++] = field.get(object);
                continue;
            }
            catch (ReflectionException reflectionException) {
                throw new SerializationException("Error accessing field: " + field.getName() + " (" + clazz.getName() + ")", reflectionException);
            }
            catch (SerializationException serializationException) {
                serializationException.addTrace(field + " (" + clazz.getName() + ")");
                throw serializationException;
            }
            catch (RuntimeException runtimeException) {
                SerializationException serializationException = new SerializationException(runtimeException);
                serializationException.addTrace(field + " (" + clazz.getName() + ")");
                throw serializationException;
            }
        }
        return objectArray;
    }

    public void writeField(Object object, String string) {
        this.writeField(object, string, string, null);
    }

    public void writeField(Object object, String string, @Null Class clazz) {
        this.writeField(object, string, string, clazz);
    }

    public void writeField(Object object, String string, String string2) {
        this.writeField(object, string, string2, null);
    }

    public void writeField(Object object, String string, String string2, @Null Class clazz) {
        Class<?> clazz2 = object.getClass();
        FieldMetadata fieldMetadata = (FieldMetadata)this.getFields(clazz2).get(string);
        if (fieldMetadata == null) {
            throw new SerializationException("Field not found: " + string + " (" + clazz2.getName() + ")");
        }
        Field field = fieldMetadata.field;
        if (clazz == null) {
            clazz = fieldMetadata.elementType;
        }
        try {
            this.writer.name(string2);
            this.writeValue(field.get(object), field.getType(), clazz);
        }
        catch (ReflectionException reflectionException) {
            throw new SerializationException("Error accessing field: " + field.getName() + " (" + clazz2.getName() + ")", reflectionException);
        }
        catch (SerializationException serializationException) {
            serializationException.addTrace(field + " (" + clazz2.getName() + ")");
            throw serializationException;
        }
        catch (Exception exception) {
            SerializationException serializationException = new SerializationException(exception);
            serializationException.addTrace(field + " (" + clazz2.getName() + ")");
            throw serializationException;
        }
    }

    public void writeValue(String string, @Null Object object) {
        try {
            this.writer.name(string);
        }
        catch (IOException iOException) {
            throw new SerializationException(iOException);
        }
        if (object == null) {
            this.writeValue(object, null, null);
        } else {
            this.writeValue(object, object.getClass(), null);
        }
    }

    public void writeValue(String string, @Null Object object, @Null Class clazz) {
        try {
            this.writer.name(string);
        }
        catch (IOException iOException) {
            throw new SerializationException(iOException);
        }
        this.writeValue(object, clazz, null);
    }

    public void writeValue(String string, @Null Object object, @Null Class clazz, @Null Class clazz2) {
        try {
            this.writer.name(string);
        }
        catch (IOException iOException) {
            throw new SerializationException(iOException);
        }
        this.writeValue(object, clazz, clazz2);
    }

    public void writeValue(@Null Object object) {
        if (object == null) {
            this.writeValue(object, null, null);
        } else {
            this.writeValue(object, object.getClass(), null);
        }
    }

    public void writeValue(@Null Object object, @Null Class clazz) {
        this.writeValue(object, clazz, null);
    }

    /*
     * WARNING - void declaration
     */
    public void writeValue(@Null Object object, @Null Class clazz, @Null Class clazz2) {
        try {
            if (object == null) {
                this.writer.value(null);
                return;
            }
            if (clazz != null && clazz.isPrimitive() || clazz == String.class || clazz == Integer.class || clazz == Boolean.class || clazz == Float.class || clazz == Long.class || clazz == Double.class || clazz == Short.class || clazz == Byte.class || clazz == Character.class) {
                this.writer.value(object);
                return;
            }
            Class<?> clazz3 = object.getClass();
            if (clazz3.isPrimitive() || clazz3 == String.class || clazz3 == Integer.class || clazz3 == Boolean.class || clazz3 == Float.class || clazz3 == Long.class || clazz3 == Double.class || clazz3 == Short.class || clazz3 == Byte.class || clazz3 == Character.class) {
                this.writeObjectStart(clazz3, null);
                this.writeValue("value", object);
                this.writeObjectEnd();
                return;
            }
            if (object instanceof Serializable) {
                this.writeObjectStart(clazz3, clazz);
                ((Serializable)object).write(this);
                this.writeObjectEnd();
                return;
            }
            Serializer serializer = this.classToSerializer.get(clazz3);
            if (serializer != null) {
                serializer.write(this, object, clazz);
                return;
            }
            if (object instanceof Array) {
                void i3;
                if (clazz != null && clazz3 != clazz && clazz3 != Array.class) {
                    throw new SerializationException("Serialization of an Array other than the known type is not supported.\nKnown type: " + clazz + "\nActual type: " + clazz3);
                }
                this.writeArrayStart();
                Array array = (Array)object;
                boolean i2 = false;
                int n2 = array.size;
                while (i3 < n2) {
                    this.writeValue(array.get((int)i3), clazz2, null);
                    ++i3;
                }
                this.writeArrayEnd();
                return;
            }
            if (object instanceof Queue) {
                void e3;
                if (clazz != null && clazz3 != clazz && clazz3 != Queue.class) {
                    throw new SerializationException("Serialization of a Queue other than the known type is not supported.\nKnown type: " + clazz + "\nActual type: " + clazz3);
                }
                this.writeArrayStart();
                Queue queue = (Queue)object;
                boolean e2 = false;
                int n3 = queue.size;
                while (e3 < n3) {
                    this.writeValue(queue.get((int)e3), clazz2, null);
                    ++e3;
                }
                this.writeArrayEnd();
                return;
            }
            if (object instanceof Collection) {
                if (this.typeName != null && clazz3 != ArrayList.class && (clazz == null || clazz != clazz3)) {
                    this.writeObjectStart(clazz3, clazz);
                    this.writeArrayStart("items");
                    for (Object i4 : (Collection)object) {
                        this.writeValue(i4, clazz2, null);
                    }
                    this.writeArrayEnd();
                    this.writeObjectEnd();
                } else {
                    this.writeArrayStart();
                    for (Object entry : (Collection)object) {
                        this.writeValue(entry, clazz2, null);
                    }
                    this.writeArrayEnd();
                }
                return;
            }
            if (clazz3.isArray()) {
                if (clazz2 == null) {
                    clazz2 = clazz3.getComponentType();
                }
                int n4 = ArrayReflection.getLength(object);
                this.writeArrayStart();
                boolean entry = false;
                while (entry < n4) {
                    this.writeValue(ArrayReflection.get(object, (int)entry), clazz2, null);
                    ++entry;
                }
                this.writeArrayEnd();
                return;
            }
            if (object instanceof ObjectMap) {
                if (clazz == null) {
                    clazz = ObjectMap.class;
                }
                this.writeObjectStart(clazz3, clazz);
                for (ObjectMap.Entry e4 : ((ObjectMap)object).entries()) {
                    this.writer.name(this.convertToString(e4.key));
                    this.writeValue(e4.value, clazz2, null);
                }
                this.writeObjectEnd();
                return;
            }
            if (object instanceof ObjectIntMap) {
                if (clazz == null) {
                    clazz = ObjectIntMap.class;
                }
                this.writeObjectStart(clazz3, clazz);
                for (ObjectIntMap.Entry entry : ((ObjectIntMap)object).entries()) {
                    this.writer.name(this.convertToString(entry.key));
                    this.writeValue(entry.value, Integer.class);
                }
                this.writeObjectEnd();
                return;
            }
            if (object instanceof ObjectFloatMap) {
                if (clazz == null) {
                    clazz = ObjectFloatMap.class;
                }
                this.writeObjectStart(clazz3, clazz);
                for (ObjectFloatMap.Entry entry : ((ObjectFloatMap)object).entries()) {
                    this.writer.name(this.convertToString(entry.key));
                    this.writeValue(Float.valueOf(entry.value), Float.class);
                }
                this.writeObjectEnd();
                return;
            }
            if (object instanceof ObjectSet) {
                if (clazz == null) {
                    clazz = ObjectSet.class;
                }
                this.writeObjectStart(clazz3, clazz);
                this.writer.name("values");
                this.writeArrayStart();
                for (Object i5 : (ObjectSet)object) {
                    this.writeValue(i5, clazz2, null);
                }
                this.writeArrayEnd();
                this.writeObjectEnd();
                return;
            }
            if (object instanceof IntMap) {
                if (clazz == null) {
                    clazz = IntMap.class;
                }
                this.writeObjectStart(clazz3, clazz);
                for (IntMap.Entry entry : ((IntMap)object).entries()) {
                    this.writer.name(String.valueOf(entry.key));
                    this.writeValue(entry.value, clazz2, null);
                }
                this.writeObjectEnd();
                return;
            }
            if (object instanceof LongMap) {
                if (clazz == null) {
                    clazz = LongMap.class;
                }
                this.writeObjectStart(clazz3, clazz);
                for (LongMap.Entry entry : ((LongMap)object).entries()) {
                    this.writer.name(String.valueOf(entry.key));
                    this.writeValue(entry.value, clazz2, null);
                }
                this.writeObjectEnd();
                return;
            }
            if (object instanceof IntSet) {
                if (clazz == null) {
                    clazz = IntSet.class;
                }
                this.writeObjectStart(clazz3, clazz);
                this.writer.name("values");
                this.writeArrayStart();
                IntSet.IntSetIterator intSetIterator = ((IntSet)object).iterator();
                while (intSetIterator.hasNext) {
                    this.writeValue(intSetIterator.next(), Integer.class, null);
                }
                this.writeArrayEnd();
                this.writeObjectEnd();
                return;
            }
            if (object instanceof ArrayMap) {
                void var7_36;
                if (clazz == null) {
                    clazz = ArrayMap.class;
                }
                this.writeObjectStart(clazz3, clazz);
                ArrayMap arrayMap = (ArrayMap)object;
                boolean bl2 = false;
                int n4 = arrayMap.size;
                while (var7_36 < n4) {
                    this.writer.name(this.convertToString(arrayMap.keys[var7_36]));
                    this.writeValue(arrayMap.values[var7_36], clazz2, null);
                    ++var7_36;
                }
                this.writeObjectEnd();
                return;
            }
            if (object instanceof Map) {
                if (clazz == null) {
                    clazz = HashMap.class;
                }
                this.writeObjectStart(clazz3, clazz);
                for (Map.Entry entry : ((Map)object).entrySet()) {
                    this.writer.name(this.convertToString(entry.getKey()));
                    this.writeValue(entry.getValue(), clazz2, null);
                }
                this.writeObjectEnd();
                return;
            }
            if (ClassReflection.isAssignableFrom(Enum.class, clazz3)) {
                if (clazz3.getEnumConstants() == null) {
                    clazz3 = clazz3.getSuperclass();
                }
                if (this.typeName != null && (clazz == null || clazz != clazz3)) {
                    this.writeObjectStart(clazz3, null);
                    this.writer.name("value");
                    this.writer.value(this.convertToString((Enum)object));
                    this.writeObjectEnd();
                } else {
                    this.writer.value(this.convertToString((Enum)object));
                }
                return;
            }
            this.writeObjectStart(clazz3, clazz);
            this.writeFields(object);
            this.writeObjectEnd();
        }
        catch (IOException iOException) {
            throw new SerializationException(iOException);
        }
    }

    public void writeObjectStart(String string) {
        try {
            this.writer.name(string);
        }
        catch (IOException iOException) {
            throw new SerializationException(iOException);
        }
        this.writeObjectStart();
    }

    public void writeObjectStart(String string, Class clazz, @Null Class clazz2) {
        try {
            this.writer.name(string);
        }
        catch (IOException iOException) {
            throw new SerializationException(iOException);
        }
        this.writeObjectStart(clazz, clazz2);
    }

    public void writeObjectStart() {
        try {
            this.writer.object();
        }
        catch (IOException iOException) {
            throw new SerializationException(iOException);
        }
    }

    public void writeObjectStart(Class clazz, @Null Class clazz2) {
        try {
            this.writer.object();
        }
        catch (IOException iOException) {
            throw new SerializationException(iOException);
        }
        if (clazz2 == null || clazz2 != clazz) {
            this.writeType(clazz);
        }
    }

    public void writeObjectEnd() {
        try {
            this.writer.pop();
        }
        catch (IOException iOException) {
            throw new SerializationException(iOException);
        }
    }

    public void writeArrayStart(String string) {
        try {
            this.writer.name(string);
            this.writer.array();
        }
        catch (IOException iOException) {
            throw new SerializationException(iOException);
        }
    }

    public void writeArrayStart() {
        try {
            this.writer.array();
        }
        catch (IOException iOException) {
            throw new SerializationException(iOException);
        }
    }

    public void writeArrayEnd() {
        try {
            this.writer.pop();
        }
        catch (IOException iOException) {
            throw new SerializationException(iOException);
        }
    }

    public void writeType(Class clazz) {
        if (this.typeName == null) {
            return;
        }
        String string = this.getTag(clazz);
        if (string == null) {
            string = clazz.getName();
        }
        try {
            this.writer.set(this.typeName, string);
        }
        catch (IOException iOException) {
            throw new SerializationException(iOException);
        }
    }

    @Null
    public <T> T fromJson(Class<T> clazz, Reader reader) {
        return this.readValue(clazz, null, new JsonReader().parse(reader));
    }

    @Null
    public <T> T fromJson(Class<T> clazz, Class clazz2, Reader reader) {
        return this.readValue(clazz, clazz2, new JsonReader().parse(reader));
    }

    @Null
    public <T> T fromJson(Class<T> clazz, InputStream inputStream) {
        return this.readValue(clazz, null, new JsonReader().parse(inputStream));
    }

    @Null
    public <T> T fromJson(Class<T> clazz, Class clazz2, InputStream inputStream) {
        return this.readValue(clazz, clazz2, new JsonReader().parse(inputStream));
    }

    @Null
    public <T> T fromJson(Class<T> clazz, FileHandle fileHandle) {
        try {
            return this.readValue(clazz, null, new JsonReader().parse(fileHandle));
        }
        catch (Exception exception) {
            throw new SerializationException("Error reading file: " + fileHandle, exception);
        }
    }

    @Null
    public <T> T fromJson(Class<T> clazz, Class clazz2, FileHandle fileHandle) {
        try {
            return this.readValue(clazz, clazz2, new JsonReader().parse(fileHandle));
        }
        catch (Exception exception) {
            throw new SerializationException("Error reading file: " + fileHandle, exception);
        }
    }

    @Null
    public <T> T fromJson(Class<T> clazz, char[] cArray, int n2, int n3) {
        return this.readValue(clazz, null, new JsonReader().parse(cArray, n2, n3));
    }

    @Null
    public <T> T fromJson(Class<T> clazz, Class clazz2, char[] cArray, int n2, int n3) {
        return this.readValue(clazz, clazz2, new JsonReader().parse(cArray, n2, n3));
    }

    @Null
    public <T> T fromJson(Class<T> clazz, String string) {
        return this.readValue(clazz, null, new JsonReader().parse(string));
    }

    @Null
    public <T> T fromJson(Class<T> clazz, Class clazz2, String string) {
        return this.readValue(clazz, clazz2, new JsonReader().parse(string));
    }

    public void readField(Object object, String string, JsonValue jsonValue) {
        this.readField(object, string, string, null, jsonValue);
    }

    public void readField(Object object, String string, @Null Class clazz, JsonValue jsonValue) {
        this.readField(object, string, string, clazz, jsonValue);
    }

    public void readField(Object object, String string, String string2, JsonValue jsonValue) {
        this.readField(object, string, string2, null, jsonValue);
    }

    public void readField(Object object, String string, String string2, @Null Class clazz, JsonValue jsonValue) {
        Class<?> clazz2 = object.getClass();
        FieldMetadata fieldMetadata = (FieldMetadata)this.getFields(clazz2).get(string);
        if (fieldMetadata == null) {
            throw new SerializationException("Field not found: " + string + " (" + clazz2.getName() + ")");
        }
        Field field = fieldMetadata.field;
        if (clazz == null) {
            clazz = fieldMetadata.elementType;
        }
        this.readField(object, field, string2, clazz, jsonValue);
    }

    public void readField(@Null Object object, Field field, String string, @Null Class clazz, JsonValue jsonValue) {
        JsonValue jsonValue2 = jsonValue.get(string);
        if (jsonValue2 == null) {
            return;
        }
        try {
            field.set(object, this.readValue(field.getType(), clazz, jsonValue2));
        }
        catch (ReflectionException reflectionException) {
            throw new SerializationException("Error accessing field: " + field.getName() + " (" + field.getDeclaringClass().getName() + ")", reflectionException);
        }
        catch (SerializationException serializationException) {
            serializationException.addTrace(field.getName() + " (" + field.getDeclaringClass().getName() + ")");
            throw serializationException;
        }
        catch (RuntimeException runtimeException) {
            SerializationException serializationException = new SerializationException(runtimeException);
            serializationException.addTrace(jsonValue2.trace());
            serializationException.addTrace(field.getName() + " (" + field.getDeclaringClass().getName() + ")");
            throw serializationException;
        }
    }

    public void readFields(Object object, JsonValue jsonValue) {
        Class<?> clazz = object.getClass();
        OrderedMap<String, FieldMetadata> orderedMap = this.getFields(clazz);
        JsonValue jsonValue2 = jsonValue.child;
        while (jsonValue2 != null) {
            Object object2;
            FieldMetadata fieldMetadata = (FieldMetadata)orderedMap.get(jsonValue2.name().replace(" ", "_"));
            if (fieldMetadata == null) {
                if (!(jsonValue2.name.equals(this.typeName) || this.ignoreUnknownFields || this.ignoreUnknownField(clazz, jsonValue2.name))) {
                    object2 = new SerializationException("Field not found: " + jsonValue2.name + " (" + clazz.getName() + ")");
                    ((SerializationException)object2).addTrace(jsonValue2.trace());
                    throw object2;
                }
            } else if (!this.ignoreDeprecated || this.readDeprecated || !fieldMetadata.deprecated) {
                object2 = fieldMetadata.field;
                try {
                    ((Field)object2).set(object, this.readValue(((Field)object2).getType(), fieldMetadata.elementType, jsonValue2));
                }
                catch (ReflectionException reflectionException) {
                    throw new SerializationException("Error accessing field: " + ((Field)object2).getName() + " (" + clazz.getName() + ")", reflectionException);
                }
                catch (SerializationException serializationException) {
                    serializationException.addTrace(((Field)object2).getName() + " (" + clazz.getName() + ")");
                    throw serializationException;
                }
                catch (RuntimeException runtimeException) {
                    SerializationException serializationException = new SerializationException(runtimeException);
                    serializationException.addTrace(jsonValue2.trace());
                    serializationException.addTrace(((Field)object2).getName() + " (" + clazz.getName() + ")");
                    throw serializationException;
                }
            }
            jsonValue2 = jsonValue2.next;
        }
    }

    protected boolean ignoreUnknownField(Class clazz, String string) {
        return false;
    }

    @Null
    public <T> T readValue(String string, @Null Class<T> clazz, JsonValue jsonValue) {
        return this.readValue(clazz, null, jsonValue.get(string));
    }

    @Null
    public <T> T readValue(String string, @Null Class<T> clazz, T t2, JsonValue jsonValue) {
        JsonValue jsonValue2 = jsonValue.get(string);
        if (jsonValue2 == null) {
            return t2;
        }
        return this.readValue(clazz, null, jsonValue2);
    }

    @Null
    public <T> T readValue(String string, @Null Class<T> clazz, @Null Class clazz2, JsonValue jsonValue) {
        return this.readValue(clazz, clazz2, jsonValue.get(string));
    }

    @Null
    public <T> T readValue(String string, @Null Class<T> clazz, @Null Class clazz2, T t2, JsonValue jsonValue) {
        JsonValue jsonValue2 = jsonValue.get(string);
        return this.readValue(clazz, clazz2, t2, jsonValue2);
    }

    @Null
    public <T> T readValue(@Null Class<T> clazz, @Null Class clazz2, T t2, JsonValue jsonValue) {
        if (jsonValue == null) {
            return t2;
        }
        return this.readValue(clazz, clazz2, jsonValue);
    }

    @Null
    public <T> T readValue(@Null Class<T> clazz, JsonValue jsonValue) {
        return this.readValue(clazz, null, jsonValue);
    }

    @Null
    public <T> T readValue(@Null Class<T> clazz, @Null Class object, JsonValue jsonValue) {
        Object object2;
        if (jsonValue == null) {
            return null;
        }
        if (jsonValue.isObject()) {
            Object object3 = object2 = this.typeName == null ? null : jsonValue.getString(this.typeName, null);
            if (object2 != null && (clazz = this.getClass((String)object2)) == null) {
                try {
                    clazz = ClassReflection.forName((String)object2);
                }
                catch (ReflectionException reflectionException) {
                    throw new SerializationException(reflectionException);
                }
            }
            if (clazz == null) {
                if (this.defaultSerializer != null) {
                    return this.defaultSerializer.read(this, jsonValue, clazz);
                }
                return (T)jsonValue;
            }
            if (this.typeName != null && ClassReflection.isAssignableFrom(Collection.class, clazz)) {
                if ((jsonValue = jsonValue.get("items")) == null) {
                    throw new SerializationException("Unable to convert object to collection: " + jsonValue + " (" + clazz.getName() + ")");
                }
            } else {
                Serializer serializer = this.classToSerializer.get(clazz);
                if (serializer != null) {
                    return serializer.read(this, jsonValue, clazz);
                }
                if (clazz == String.class || clazz == Integer.class || clazz == Boolean.class || clazz == Float.class || clazz == Long.class || clazz == Double.class || clazz == Short.class || clazz == Byte.class || clazz == Character.class || ClassReflection.isAssignableFrom(Enum.class, clazz)) {
                    return this.readValue("value", clazz, jsonValue);
                }
                Object object4 = this.newInstance(clazz);
                if (object4 instanceof Serializable) {
                    ((Serializable)object4).read(this, jsonValue);
                    return (T)object4;
                }
                if (object4 instanceof ObjectMap) {
                    ObjectMap objectMap = (ObjectMap)object4;
                    JsonValue jsonValue2 = jsonValue.child;
                    while (jsonValue2 != null) {
                        objectMap.put(jsonValue2.name, this.readValue((Class<T>)object, null, jsonValue2));
                        jsonValue2 = jsonValue2.next;
                    }
                    return (T)objectMap;
                }
                if (object4 instanceof ObjectIntMap) {
                    ObjectIntMap objectIntMap = (ObjectIntMap)object4;
                    JsonValue jsonValue3 = jsonValue.child;
                    while (jsonValue3 != null) {
                        objectIntMap.put(jsonValue3.name, this.readValue(Integer.class, null, jsonValue3));
                        jsonValue3 = jsonValue3.next;
                    }
                    return (T)objectIntMap;
                }
                if (object4 instanceof ObjectFloatMap) {
                    ObjectFloatMap objectFloatMap = (ObjectFloatMap)object4;
                    JsonValue jsonValue4 = jsonValue.child;
                    while (jsonValue4 != null) {
                        objectFloatMap.put(jsonValue4.name, this.readValue(Float.class, null, jsonValue4).floatValue());
                        jsonValue4 = jsonValue4.next;
                    }
                    return (T)objectFloatMap;
                }
                if (object4 instanceof ObjectSet) {
                    ObjectSet objectSet = (ObjectSet)object4;
                    JsonValue jsonValue5 = jsonValue.getChild("values");
                    while (jsonValue5 != null) {
                        objectSet.add(this.readValue((Class<T>)object, null, jsonValue5));
                        jsonValue5 = jsonValue5.next;
                    }
                    return (T)objectSet;
                }
                if (object4 instanceof IntMap) {
                    IntMap intMap = (IntMap)object4;
                    JsonValue jsonValue6 = jsonValue.child;
                    while (jsonValue6 != null) {
                        intMap.put(Integer.parseInt(jsonValue6.name), this.readValue((Class<T>)object, null, jsonValue6));
                        jsonValue6 = jsonValue6.next;
                    }
                    return (T)intMap;
                }
                if (object4 instanceof LongMap) {
                    LongMap longMap = (LongMap)object4;
                    JsonValue jsonValue7 = jsonValue.child;
                    while (jsonValue7 != null) {
                        longMap.put(Long.parseLong(jsonValue7.name), this.readValue((Class<T>)object, null, jsonValue7));
                        jsonValue7 = jsonValue7.next;
                    }
                    return (T)longMap;
                }
                if (object4 instanceof IntSet) {
                    IntSet intSet = (IntSet)object4;
                    JsonValue jsonValue8 = jsonValue.getChild("values");
                    while (jsonValue8 != null) {
                        intSet.add(jsonValue8.asInt());
                        jsonValue8 = jsonValue8.next;
                    }
                    return (T)intSet;
                }
                if (object4 instanceof ArrayMap) {
                    ArrayMap arrayMap = (ArrayMap)object4;
                    JsonValue jsonValue9 = jsonValue.child;
                    while (jsonValue9 != null) {
                        arrayMap.put(jsonValue9.name, this.readValue((Class<T>)object, null, jsonValue9));
                        jsonValue9 = jsonValue9.next;
                    }
                    return (T)arrayMap;
                }
                if (object4 instanceof Map) {
                    Map map = (Map)object4;
                    JsonValue jsonValue10 = jsonValue.child;
                    while (jsonValue10 != null) {
                        if (!jsonValue10.name.equals(this.typeName)) {
                            map.put(jsonValue10.name, this.readValue((Class<T>)object, null, jsonValue10));
                        }
                        jsonValue10 = jsonValue10.next;
                    }
                    return (T)map;
                }
                this.readFields(object4, jsonValue);
                return (T)object4;
            }
        }
        if (clazz != null) {
            object2 = this.classToSerializer.get(clazz);
            if (object2 != null) {
                return object2.read(this, jsonValue, clazz);
            }
            if (ClassReflection.isAssignableFrom(Serializable.class, clazz)) {
                Object object5 = this.newInstance(clazz);
                ((Serializable)object5).read(this, jsonValue);
                return (T)object5;
            }
        }
        if (jsonValue.isArray()) {
            if (clazz == null || clazz == Object.class) {
                clazz = Array.class;
            }
            if (ClassReflection.isAssignableFrom(Array.class, clazz)) {
                object2 = clazz == Array.class ? new Array() : (Array)this.newInstance(clazz);
                JsonValue jsonValue11 = jsonValue.child;
                while (jsonValue11 != null) {
                    ((Array)object2).add(this.readValue((Class<T>)object, null, jsonValue11));
                    jsonValue11 = jsonValue11.next;
                }
                return (T)object2;
            }
            if (ClassReflection.isAssignableFrom(Queue.class, clazz)) {
                object2 = clazz == Queue.class ? new Queue() : (Queue)this.newInstance(clazz);
                JsonValue jsonValue12 = jsonValue.child;
                while (jsonValue12 != null) {
                    ((Queue)object2).addLast(this.readValue((Class<T>)object, null, jsonValue12));
                    jsonValue12 = jsonValue12.next;
                }
                return (T)object2;
            }
            if (ClassReflection.isAssignableFrom(Collection.class, clazz)) {
                object2 = clazz.isInterface() ? new ArrayList() : (Collection)this.newInstance(clazz);
                JsonValue jsonValue13 = jsonValue.child;
                while (jsonValue13 != null) {
                    object2.add(this.readValue((Class<T>)object, null, jsonValue13));
                    jsonValue13 = jsonValue13.next;
                }
                return (T)object2;
            }
            if (clazz.isArray()) {
                object2 = clazz.getComponentType();
                if (object == null) {
                    object = object2;
                }
                Object object6 = ArrayReflection.newInstance((Class)object2, jsonValue.size);
                int n2 = 0;
                JsonValue jsonValue14 = jsonValue.child;
                while (jsonValue14 != null) {
                    ArrayReflection.set(object6, n2++, this.readValue((Class<T>)object, null, jsonValue14));
                    jsonValue14 = jsonValue14.next;
                }
                return (T)object6;
            }
            throw new SerializationException("Unable to convert value to required type: " + jsonValue + " (" + clazz.getName() + ")");
        }
        if (jsonValue.isNumber()) {
            try {
                if (clazz == null || clazz == Float.TYPE || clazz == Float.class) {
                    return (T)Float.valueOf(jsonValue.asFloat());
                }
                if (clazz == Integer.TYPE || clazz == Integer.class) {
                    return (T)Integer.valueOf(jsonValue.asInt());
                }
                if (clazz == Long.TYPE || clazz == Long.class) {
                    return (T)Long.valueOf(jsonValue.asLong());
                }
                if (clazz == Double.TYPE || clazz == Double.class) {
                    return (T)Double.valueOf(jsonValue.asDouble());
                }
                if (clazz == String.class) {
                    return (T)jsonValue.asString();
                }
                if (clazz == Short.TYPE || clazz == Short.class) {
                    return (T)Short.valueOf(jsonValue.asShort());
                }
                if (clazz == Byte.TYPE || clazz == Byte.class) {
                    return (T)Byte.valueOf(jsonValue.asByte());
                }
            }
            catch (NumberFormatException numberFormatException) {
                // empty catch block
            }
            jsonValue = new JsonValue(jsonValue.asString());
        }
        if (jsonValue.isBoolean()) {
            try {
                if (clazz == null || clazz == Boolean.TYPE || clazz == Boolean.class) {
                    return (T)Boolean.valueOf(jsonValue.asBoolean());
                }
            }
            catch (NumberFormatException numberFormatException) {
                // empty catch block
            }
            jsonValue = new JsonValue(jsonValue.asString());
        }
        if (jsonValue.isString()) {
            object2 = jsonValue.asString();
            if (clazz == null || clazz == String.class) {
                return (T)object2;
            }
            try {
                if (clazz == Integer.TYPE || clazz == Integer.class) {
                    return (T)Integer.valueOf(object2);
                }
                if (clazz == Float.TYPE || clazz == Float.class) {
                    return (T)Float.valueOf((String)object2);
                }
                if (clazz == Long.TYPE || clazz == Long.class) {
                    return (T)Long.valueOf((String)object2);
                }
                if (clazz == Double.TYPE || clazz == Double.class) {
                    return (T)Double.valueOf((String)object2);
                }
                if (clazz == Short.TYPE || clazz == Short.class) {
                    return (T)Short.valueOf((String)object2);
                }
                if (clazz == Byte.TYPE || clazz == Byte.class) {
                    return (T)Byte.valueOf((String)object2);
                }
            }
            catch (NumberFormatException numberFormatException) {
                // empty catch block
            }
            if (clazz == Boolean.TYPE || clazz == Boolean.class) {
                return (T)Boolean.valueOf((String)object2);
            }
            if (clazz == Character.TYPE || clazz == Character.class) {
                return (T)Character.valueOf(((String)object2).charAt(0));
            }
            if (ClassReflection.isAssignableFrom(Enum.class, clazz)) {
                for (Enum enum_ : (Enum[])clazz.getEnumConstants()) {
                    if (!((String)object2).equals(this.convertToString(enum_))) continue;
                    return (T)enum_;
                }
            }
            if (clazz == CharSequence.class) {
                return (T)object2;
            }
            throw new SerializationException("Unable to convert value to required type: " + jsonValue + " (" + clazz.getName() + ")");
        }
        return null;
    }

    public void copyFields(Object object, Object object2) {
        OrderedMap<String, FieldMetadata> orderedMap = this.getFields(object2.getClass());
        for (ObjectMap.Entry entry : this.getFields(object.getClass())) {
            FieldMetadata fieldMetadata = (FieldMetadata)orderedMap.get(entry.key);
            Field field = ((FieldMetadata)entry.value).field;
            if (fieldMetadata == null) {
                throw new SerializationException("To object is missing field: " + (String)entry.key);
            }
            try {
                fieldMetadata.field.set(object2, field.get(object));
            }
            catch (ReflectionException reflectionException) {
                throw new SerializationException("Error copying field: " + field.getName(), reflectionException);
            }
        }
    }

    private String convertToString(Enum enum_) {
        return this.enumNames ? enum_.name() : enum_.toString();
    }

    private String convertToString(Object object) {
        if (object instanceof Enum) {
            return this.convertToString((Enum)object);
        }
        if (object instanceof Class) {
            return ((Class)object).getName();
        }
        return String.valueOf(object);
    }

    protected Object newInstance(Class clazz) {
        try {
            return ClassReflection.newInstance(clazz);
        }
        catch (Exception exception) {
            Exception exception2;
            try {
                Constructor constructor = ClassReflection.getDeclaredConstructor(clazz, new Class[0]);
                constructor.setAccessible(true);
                return constructor.newInstance(new Object[0]);
            }
            catch (SecurityException securityException) {
            }
            catch (ReflectionException reflectionException) {
                if (ClassReflection.isAssignableFrom(Enum.class, clazz)) {
                    if (clazz.getEnumConstants() == null) {
                        clazz = clazz.getSuperclass();
                    }
                    return clazz.getEnumConstants()[0];
                }
                if (clazz.isArray()) {
                    throw new SerializationException("Encountered JSON object when expected array of type: " + clazz.getName(), exception);
                }
                if (ClassReflection.isMemberClass(clazz) && !ClassReflection.isStaticClass(clazz)) {
                    throw new SerializationException("Class cannot be created (non-static member class): " + clazz.getName(), exception);
                }
                throw new SerializationException("Class cannot be created (missing no-arg constructor): " + clazz.getName(), exception);
            }
            catch (Exception exception3) {
                exception2 = exception3;
            }
            throw new SerializationException("Error constructing instance of class: " + clazz.getName(), exception2);
        }
    }

    public String prettyPrint(@Null Object object) {
        return this.prettyPrint(object, 0);
    }

    public String prettyPrint(String string) {
        return this.prettyPrint(string, 0);
    }

    public String prettyPrint(@Null Object object, int n2) {
        return this.prettyPrint(this.toJson(object), n2);
    }

    public String prettyPrint(String string, int n2) {
        return new JsonReader().parse(string).prettyPrint(this.outputType, n2);
    }

    public String prettyPrint(@Null Object object, JsonValue.PrettyPrintSettings prettyPrintSettings) {
        return this.prettyPrint(this.toJson(object), prettyPrintSettings);
    }

    public String prettyPrint(String string, JsonValue.PrettyPrintSettings prettyPrintSettings) {
        return new JsonReader().parse(string).prettyPrint(prettyPrintSettings);
    }

    public static interface Serializable {
        public void write(Json var1);

        public void read(Json var1, JsonValue var2);
    }

    public static abstract class ReadOnlySerializer<T>
    implements Serializer<T> {
        @Override
        public void write(Json json, T t2, Class clazz) {
        }

        @Override
        public abstract T read(Json var1, JsonValue var2, Class var3);
    }

    public static interface Serializer<T> {
        public void write(Json var1, T var2, Class var3);

        public T read(Json var1, JsonValue var2, Class var3);
    }

    static class FieldMetadata {
        final Field field;
        Class elementType;
        boolean deprecated;

        public FieldMetadata(Field field) {
            this.field = field;
            int n2 = ClassReflection.isAssignableFrom(ObjectMap.class, field.getType()) || ClassReflection.isAssignableFrom(Map.class, field.getType()) ? 1 : 0;
            this.elementType = field.getElementType(n2);
            this.deprecated = field.isAnnotationPresent(Deprecated.class);
        }
    }
}

