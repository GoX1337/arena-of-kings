/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.jsonbeans;

import com.esotericsoftware.jsonbeans.JsonException;
import com.esotericsoftware.jsonbeans.JsonReader;
import com.esotericsoftware.jsonbeans.JsonSerializable;
import com.esotericsoftware.jsonbeans.JsonSerializer;
import com.esotericsoftware.jsonbeans.JsonValue;
import com.esotericsoftware.jsonbeans.JsonWriter;
import com.esotericsoftware.jsonbeans.Null;
import com.esotericsoftware.jsonbeans.ObjectMap;
import com.esotericsoftware.jsonbeans.OrderedMap;
import com.esotericsoftware.jsonbeans.OutputType;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
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
    private OutputType outputType;
    private boolean quoteLongValues;
    private boolean ignoreUnknownFields;
    private boolean ignoreDeprecated;
    private boolean readDeprecated;
    private boolean enumNames = true;
    private boolean sortFields;
    private JsonSerializer defaultSerializer;
    private final ObjectMap<Class, OrderedMap<String, FieldMetadata>> typeToFields = new ObjectMap();
    private final ObjectMap<String, Class> tagToClass = new ObjectMap();
    private final ObjectMap<Class, String> classToTag = new ObjectMap();
    private final ObjectMap<Class, JsonSerializer> classToSerializer = new ObjectMap();
    private final ObjectMap<Class, Object[]> classToDefaultValues = new ObjectMap();
    private final Object[] equals1 = new Object[]{null};
    private final Object[] equals2 = new Object[]{null};

    public Json() {
        this.outputType = OutputType.minimal;
    }

    public Json(OutputType outputType) {
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

    public void setOutputType(OutputType outputType) {
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

    public void setDefaultSerializer(@Null JsonSerializer jsonSerializer) {
        this.defaultSerializer = jsonSerializer;
    }

    public <T> void setSerializer(Class<T> clazz, JsonSerializer<T> jsonSerializer) {
        this.classToSerializer.put(clazz, jsonSerializer);
    }

    public <T> JsonSerializer<T> getSerializer(Class<T> clazz) {
        return this.classToSerializer.get(clazz);
    }

    public void setUsePrototypes(boolean bl2) {
        this.usePrototypes = bl2;
    }

    public void setElementType(Class clazz, String string, Class clazz2) {
        FieldMetadata fieldMetadata = (FieldMetadata)this.getFields(clazz).get(string);
        if (fieldMetadata == null) {
            throw new JsonException("Field not found: " + string + " (" + clazz.getName() + ")");
        }
        fieldMetadata.elementType = clazz2;
    }

    public void setDeprecated(Class clazz, String string, boolean bl2) {
        FieldMetadata fieldMetadata = (FieldMetadata)this.getFields(clazz).get(string);
        if (fieldMetadata == null) {
            throw new JsonException("Field not found: " + string + " (" + clazz.getName() + ")");
        }
        fieldMetadata.deprecated = bl2;
    }

    public void setSortFields(boolean bl2) {
        this.sortFields = bl2;
    }

    private OrderedMap<String, FieldMetadata> getFields(Class clazz) {
        OrderedMap<String, FieldMetadata> orderedMap = this.typeToFields.get(clazz);
        if (orderedMap != null) {
            return orderedMap;
        }
        ArrayList arrayList = new ArrayList();
        for (Class clazz2 = clazz; clazz2 != Object.class; clazz2 = clazz2.getSuperclass()) {
            arrayList.add(clazz2);
        }
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = arrayList.size() - 1; i2 >= 0; --i2) {
            Collections.addAll(arrayList2, ((Class)arrayList.get(i2)).getDeclaredFields());
        }
        OrderedMap<String, FieldMetadata> orderedMap2 = new OrderedMap<String, FieldMetadata>(arrayList2.size());
        int n2 = arrayList2.size();
        for (int i3 = 0; i3 < n2; ++i3) {
            Field field = (Field)arrayList2.get(i3);
            int n3 = field.getModifiers();
            if (Modifier.isTransient(n3) || Modifier.isStatic(n3) || field.isSynthetic()) continue;
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
        if (this.sortFields) {
            Collections.sort(orderedMap2.keys);
        }
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

    public void toJson(@Null Object object, File file) {
        this.toJson(object, object == null ? null : object.getClass(), null, file);
    }

    public void toJson(@Null Object object, @Null Class clazz, File file) {
        this.toJson(object, clazz, null, file);
    }

    public void toJson(@Null Object object, @Null Class clazz, @Null Class clazz2, File file) {
        Writer writer = null;
        try {
            writer = new OutputStreamWriter((OutputStream)new FileOutputStream(file), "UTF-8");
            this.toJson(object, clazz, clazz2, writer);
        }
        catch (Exception exception) {
            throw new JsonException("Error writing file: " + file, exception);
        }
        finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            }
            catch (IOException iOException) {}
        }
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
            if (this.writer != null) {
                try {
                    this.writer.close();
                }
                catch (IOException iOException) {}
            }
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
        ArrayList<String> arrayList = orderedMap.orderedKeys();
        int n3 = arrayList.size();
        for (int i2 = 0; i2 < n3; ++i2) {
            Object object2;
            FieldMetadata fieldMetadata = (FieldMetadata)orderedMap.get(arrayList.get(i2));
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
            catch (IllegalAccessException illegalAccessException) {
                throw new JsonException("Error accessing field: " + field.getName() + " (" + clazz.getName() + ")", illegalAccessException);
            }
            catch (JsonException jsonException) {
                jsonException.addTrace(field + " (" + clazz.getName() + ")");
                throw jsonException;
            }
            catch (Exception exception) {
                object2 = new JsonException(exception);
                ((JsonException)object2).addTrace(field + " (" + clazz.getName() + ")");
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
        ArrayList<String> arrayList = orderedMap.orderedKeys();
        int n3 = arrayList.size();
        for (int i2 = 0; i2 < n3; ++i2) {
            FieldMetadata fieldMetadata = (FieldMetadata)orderedMap.get(arrayList.get(i2));
            if (this.ignoreDeprecated && fieldMetadata.deprecated) continue;
            Field field = fieldMetadata.field;
            try {
                objectArray[n2++] = field.get(object);
                continue;
            }
            catch (IllegalAccessException illegalAccessException) {
                throw new JsonException("Error accessing field: " + field.getName() + " (" + clazz.getName() + ")", illegalAccessException);
            }
            catch (JsonException jsonException) {
                jsonException.addTrace(field + " (" + clazz.getName() + ")");
                throw jsonException;
            }
            catch (RuntimeException runtimeException) {
                JsonException jsonException = new JsonException(runtimeException);
                jsonException.addTrace(field + " (" + clazz.getName() + ")");
                throw jsonException;
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
            throw new JsonException("Field not found: " + string + " (" + clazz2.getName() + ")");
        }
        Field field = fieldMetadata.field;
        if (clazz == null) {
            clazz = fieldMetadata.elementType;
        }
        try {
            this.writer.name(string2);
            this.writeValue(field.get(object), field.getType(), clazz);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new JsonException("Error accessing field: " + field.getName() + " (" + clazz2.getName() + ")", illegalAccessException);
        }
        catch (JsonException jsonException) {
            jsonException.addTrace(field + " (" + clazz2.getName() + ")");
            throw jsonException;
        }
        catch (Exception exception) {
            JsonException jsonException = new JsonException(exception);
            jsonException.addTrace(field + " (" + clazz2.getName() + ")");
            throw jsonException;
        }
    }

    public void writeValue(String string, @Null Object object) {
        try {
            this.writer.name(string);
        }
        catch (IOException iOException) {
            throw new JsonException(iOException);
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
            throw new JsonException(iOException);
        }
        this.writeValue(object, clazz, null);
    }

    public void writeValue(String string, @Null Object object, @Null Class clazz, @Null Class clazz2) {
        try {
            this.writer.name(string);
        }
        catch (IOException iOException) {
            throw new JsonException(iOException);
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
            if (object instanceof JsonSerializable) {
                this.writeObjectStart(clazz3, clazz);
                ((JsonSerializable)object).write(this);
                this.writeObjectEnd();
                return;
            }
            JsonSerializer jsonSerializer = this.classToSerializer.get(clazz3);
            if (jsonSerializer != null) {
                jsonSerializer.write(this, object, clazz);
                return;
            }
            if (object instanceof ArrayList) {
                void e2;
                if (clazz != null && clazz3 != clazz && clazz3 != ArrayList.class) {
                    throw new JsonException("Serialization of an Array other than the known type is not supported.\nKnown type: " + clazz + "\nActual type: " + clazz3);
                }
                this.writeArrayStart();
                ArrayList arrayList = (ArrayList)object;
                boolean i2 = false;
                int n2 = arrayList.size();
                while (e2 < n2) {
                    this.writeValue(arrayList.get((int)e2), clazz2, null);
                    ++e2;
                }
                this.writeArrayEnd();
                return;
            }
            if (object instanceof Collection) {
                if (this.typeName != null && clazz3 != ArrayList.class && (clazz == null || clazz != clazz3)) {
                    this.writeObjectStart(clazz3, clazz);
                    this.writeArrayStart("items");
                    for (Object e3 : (Collection)object) {
                        this.writeValue(e3, clazz2, null);
                    }
                    this.writeArrayEnd();
                    this.writeObjectEnd();
                } else {
                    this.writeArrayStart();
                    for (Object i3 : (Collection)object) {
                        this.writeValue(i3, clazz2, null);
                    }
                    this.writeArrayEnd();
                }
                return;
            }
            if (clazz3.isArray()) {
                if (clazz2 == null) {
                    clazz2 = clazz3.getComponentType();
                }
                int n3 = Array.getLength(object);
                this.writeArrayStart();
                boolean entry = false;
                while (entry < n3) {
                    this.writeValue(Array.get(object, (int)entry), clazz2, null);
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
                for (ObjectMap.Entry entry : ((ObjectMap)object).entries()) {
                    this.writer.name(this.convertToString(entry.key));
                    this.writeValue(entry.value, clazz2, null);
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
            if (Enum.class.isAssignableFrom(clazz3)) {
                if (this.typeName != null && (clazz == null || clazz != clazz3)) {
                    if (clazz3.getEnumConstants() == null) {
                        clazz3 = clazz3.getSuperclass();
                    }
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
            throw new JsonException(iOException);
        }
    }

    public void writeObjectStart(String string) {
        try {
            this.writer.name(string);
        }
        catch (IOException iOException) {
            throw new JsonException(iOException);
        }
        this.writeObjectStart();
    }

    public void writeObjectStart(String string, Class clazz, @Null Class clazz2) {
        try {
            this.writer.name(string);
        }
        catch (IOException iOException) {
            throw new JsonException(iOException);
        }
        this.writeObjectStart(clazz, clazz2);
    }

    public void writeObjectStart() {
        try {
            this.writer.object();
        }
        catch (IOException iOException) {
            throw new JsonException(iOException);
        }
    }

    public void writeObjectStart(Class clazz, @Null Class clazz2) {
        try {
            this.writer.object();
        }
        catch (IOException iOException) {
            throw new JsonException(iOException);
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
            throw new JsonException(iOException);
        }
    }

    public void writeArrayStart(String string) {
        try {
            this.writer.name(string);
            this.writer.array();
        }
        catch (IOException iOException) {
            throw new JsonException(iOException);
        }
    }

    public void writeArrayStart() {
        try {
            this.writer.array();
        }
        catch (IOException iOException) {
            throw new JsonException(iOException);
        }
    }

    public void writeArrayEnd() {
        try {
            this.writer.pop();
        }
        catch (IOException iOException) {
            throw new JsonException(iOException);
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
            throw new JsonException(iOException);
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
    public <T> T fromJson(Class<T> clazz, File file) {
        try {
            return this.readValue(clazz, null, new JsonReader().parse(file));
        }
        catch (Exception exception) {
            throw new JsonException("Error reading file: " + file, exception);
        }
    }

    @Null
    public <T> T fromJson(Class<T> clazz, Class clazz2, File file) {
        try {
            return this.readValue(clazz, clazz2, new JsonReader().parse(file));
        }
        catch (Exception exception) {
            throw new JsonException("Error reading file: " + file, exception);
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
            throw new JsonException("Field not found: " + string + " (" + clazz2.getName() + ")");
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
        catch (IllegalAccessException illegalAccessException) {
            throw new JsonException("Error accessing field: " + field.getName() + " (" + field.getDeclaringClass().getName() + ")", illegalAccessException);
        }
        catch (JsonException jsonException) {
            jsonException.addTrace(field.getName() + " (" + field.getDeclaringClass().getName() + ")");
            throw jsonException;
        }
        catch (RuntimeException runtimeException) {
            JsonException jsonException = new JsonException(runtimeException);
            jsonException.addTrace(jsonValue2.trace());
            jsonException.addTrace(field.getName() + " (" + field.getDeclaringClass().getName() + ")");
            throw jsonException;
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
                    object2 = new JsonException("Field not found: " + jsonValue2.name + " (" + clazz.getName() + ")");
                    ((JsonException)object2).addTrace(jsonValue2.trace());
                    throw object2;
                }
            } else if (!this.ignoreDeprecated || this.readDeprecated || !fieldMetadata.deprecated) {
                object2 = fieldMetadata.field;
                try {
                    ((Field)object2).set(object, this.readValue(((Field)object2).getType(), fieldMetadata.elementType, jsonValue2));
                }
                catch (IllegalAccessException illegalAccessException) {
                    throw new JsonException("Error accessing field: " + ((Field)object2).getName() + " (" + clazz.getName() + ")", illegalAccessException);
                }
                catch (JsonException jsonException) {
                    jsonException.addTrace(((Field)object2).getName() + " (" + clazz.getName() + ")");
                    throw jsonException;
                }
                catch (RuntimeException runtimeException) {
                    JsonException jsonException = new JsonException(runtimeException);
                    jsonException.addTrace(jsonValue2.trace());
                    jsonException.addTrace(((Field)object2).getName() + " (" + clazz.getName() + ")");
                    throw jsonException;
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
                    clazz = Class.forName((String)object2);
                }
                catch (ClassNotFoundException classNotFoundException) {
                    throw new JsonException(classNotFoundException);
                }
            }
            if (clazz == null) {
                if (this.defaultSerializer != null) {
                    return this.defaultSerializer.read(this, jsonValue, clazz);
                }
                return (T)jsonValue;
            }
            if (this.typeName != null && Collection.class.isAssignableFrom(clazz)) {
                if ((jsonValue = jsonValue.get("items")) == null) {
                    throw new JsonException("Unable to convert object to collection: " + jsonValue + " (" + clazz.getName() + ")");
                }
            } else {
                JsonSerializer jsonSerializer = this.classToSerializer.get(clazz);
                if (jsonSerializer != null) {
                    return jsonSerializer.read(this, jsonValue, clazz);
                }
                if (clazz == String.class || clazz == Integer.class || clazz == Boolean.class || clazz == Float.class || clazz == Long.class || clazz == Double.class || clazz == Short.class || clazz == Byte.class || clazz == Character.class || Enum.class.isAssignableFrom(clazz)) {
                    return (T)this.readValue("value", clazz, jsonValue);
                }
                Object object4 = this.newInstance(clazz);
                if (object4 instanceof JsonSerializable) {
                    ((JsonSerializable)object4).read(this, jsonValue);
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
                if (object4 instanceof Map) {
                    Map map = (Map)object4;
                    JsonValue jsonValue3 = jsonValue.child;
                    while (jsonValue3 != null) {
                        if (!jsonValue3.name.equals(this.typeName)) {
                            map.put(jsonValue3.name, this.readValue((Class<T>)object, null, jsonValue3));
                        }
                        jsonValue3 = jsonValue3.next;
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
            if (JsonSerializable.class.isAssignableFrom(clazz)) {
                Object object5 = this.newInstance(clazz);
                ((JsonSerializable)object5).read(this, jsonValue);
                return (T)object5;
            }
        }
        if (jsonValue.isArray()) {
            if (clazz == null || clazz == Object.class) {
                clazz = ArrayList.class;
            }
            if (Collection.class.isAssignableFrom(clazz)) {
                object2 = clazz.isInterface() ? new ArrayList() : (Collection)this.newInstance(clazz);
                JsonValue jsonValue4 = jsonValue.child;
                while (jsonValue4 != null) {
                    object2.add(this.readValue((Class<T>)object, null, jsonValue4));
                    jsonValue4 = jsonValue4.next;
                }
                return (T)object2;
            }
            if (clazz.isArray()) {
                object2 = clazz.getComponentType();
                if (object == null) {
                    object = object2;
                }
                Object object6 = Array.newInstance(object2, jsonValue.size);
                int n2 = 0;
                JsonValue jsonValue5 = jsonValue.child;
                while (jsonValue5 != null) {
                    Array.set(object6, n2++, this.readValue((Class<T>)object, null, jsonValue5));
                    jsonValue5 = jsonValue5.next;
                }
                return (T)object6;
            }
            throw new JsonException("Unable to convert value to required type: " + jsonValue + " (" + clazz.getName() + ")");
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
                    return (T)Integer.valueOf((String)object2);
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
            if (Enum.class.isAssignableFrom(clazz)) {
                for (Enum enum_ : (Enum[])clazz.getEnumConstants()) {
                    if (!((String)object2).equals(this.convertToString(enum_))) continue;
                    return (T)enum_;
                }
            }
            if (clazz == CharSequence.class) {
                return (T)object2;
            }
            throw new JsonException("Unable to convert value to required type: " + jsonValue + " (" + clazz.getName() + ")");
        }
        return null;
    }

    public void copyFields(Object object, Object object2) {
        OrderedMap<String, FieldMetadata> orderedMap = this.getFields(object2.getClass());
        for (ObjectMap.Entry entry : this.getFields(object.getClass())) {
            FieldMetadata fieldMetadata = (FieldMetadata)orderedMap.get((String)entry.key);
            Field field = ((FieldMetadata)entry.value).field;
            if (fieldMetadata == null) {
                throw new JsonException("To object is missing field: " + (String)entry.key);
            }
            try {
                fieldMetadata.field.set(object2, field.get(object));
            }
            catch (IllegalAccessException illegalAccessException) {
                throw new JsonException("Error copying field: " + field.getName(), illegalAccessException);
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
            return clazz.newInstance();
        }
        catch (Exception exception) {
            Exception exception2;
            try {
                Constructor constructor = clazz.getDeclaredConstructor(new Class[0]);
                constructor.setAccessible(true);
                return constructor.newInstance(new Object[0]);
            }
            catch (SecurityException securityException) {
            }
            catch (IllegalAccessException illegalAccessException) {
                if (Enum.class.isAssignableFrom(clazz)) {
                    if (clazz.getEnumConstants() == null) {
                        clazz = clazz.getSuperclass();
                    }
                    return clazz.getEnumConstants()[0];
                }
                if (clazz.isArray()) {
                    throw new JsonException("Encountered JSON object when expected array of type: " + clazz.getName(), exception);
                }
                if (clazz.isMemberClass() && !Modifier.isStatic(clazz.getModifiers())) {
                    throw new JsonException("Class cannot be created (non-static member class): " + clazz.getName(), exception);
                }
                throw new JsonException("Class cannot be created (missing no-arg constructor): " + clazz.getName(), exception);
            }
            catch (Exception exception3) {
                exception2 = exception3;
            }
            throw new JsonException("Error constructing instance of class: " + clazz.getName(), exception2);
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

    static class FieldMetadata {
        final Field field;
        Class elementType;
        boolean deprecated;

        public FieldMetadata(Field field) {
            this.field = field;
            int n2 = ObjectMap.class.isAssignableFrom(field.getType()) || Map.class.isAssignableFrom(field.getType()) ? 1 : 0;
            this.elementType = FieldMetadata.getElementType(field, n2);
            this.deprecated = field.isAnnotationPresent(Deprecated.class);
        }

        @Null
        private static Class getElementType(Field field, int n2) {
            Type[] typeArray;
            Type type = field.getGenericType();
            if (type instanceof ParameterizedType && (typeArray = ((ParameterizedType)type).getActualTypeArguments()).length - 1 >= n2) {
                Type type2;
                Type type3 = typeArray[n2];
                if (type3 instanceof Class) {
                    return (Class)type3;
                }
                if (type3 instanceof ParameterizedType) {
                    return (Class)((ParameterizedType)type3).getRawType();
                }
                if (type3 instanceof GenericArrayType && (type2 = ((GenericArrayType)type3).getGenericComponentType()) instanceof Class) {
                    return Array.newInstance((Class)type2, 0).getClass();
                }
            }
            return null;
        }
    }
}

