/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.SerializerFactory;
import com.esotericsoftware.kryo.serializers.AsmField;
import com.esotericsoftware.kryo.serializers.CollectionSerializer;
import com.esotericsoftware.kryo.serializers.FieldSerializer;
import com.esotericsoftware.kryo.serializers.MapSerializer;
import com.esotericsoftware.kryo.serializers.ReflectField;
import com.esotericsoftware.kryo.serializers.UnsafeField;
import com.esotericsoftware.kryo.util.Generics;
import com.esotericsoftware.kryo.util.Util;
import com.esotericsoftware.minlog.Log;
import com.esotericsoftware.reflectasm.FieldAccess;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.security.AccessControlException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;

class CachedFields
implements Comparator<FieldSerializer.CachedField> {
    static final FieldSerializer.CachedField[] emptyCachedFields = new FieldSerializer.CachedField[0];
    private final FieldSerializer serializer;
    FieldSerializer.CachedField[] fields = new FieldSerializer.CachedField[0];
    FieldSerializer.CachedField[] copyFields = new FieldSerializer.CachedField[0];
    private final ArrayList<Field> removedFields = new ArrayList();
    private Object access;

    public CachedFields(FieldSerializer fieldSerializer) {
        this.serializer = fieldSerializer;
    }

    public void rebuild() {
        if (this.serializer.type.isInterface()) {
            this.fields = emptyCachedFields;
            this.copyFields = emptyCachedFields;
            this.serializer.initializeCachedFields();
            return;
        }
        ArrayList<FieldSerializer.CachedField> arrayList = new ArrayList<FieldSerializer.CachedField>();
        ArrayList<FieldSerializer.CachedField> arrayList2 = new ArrayList<FieldSerializer.CachedField>();
        boolean bl2 = !Util.unsafe && !Util.isAndroid && Modifier.isPublic(this.serializer.type.getModifiers());
        for (Class clazz = this.serializer.type; clazz != Object.class; clazz = clazz.getSuperclass()) {
            for (Field field : clazz.getDeclaredFields()) {
                this.addField(field, bl2, arrayList, arrayList2);
            }
        }
        if (this.fields.length != arrayList.size()) {
            this.fields = new FieldSerializer.CachedField[arrayList.size()];
        }
        arrayList.toArray(this.fields);
        Arrays.sort(this.fields, this);
        if (this.copyFields.length != arrayList2.size()) {
            this.copyFields = new FieldSerializer.CachedField[arrayList2.size()];
        }
        arrayList2.toArray(this.copyFields);
        Arrays.sort(this.copyFields, this);
        this.serializer.initializeCachedFields();
    }

    private void addField(Field field, boolean bl2, ArrayList<FieldSerializer.CachedField> arrayList, ArrayList<FieldSerializer.CachedField> arrayList2) {
        FieldSerializer.CachedField cachedField;
        int n2;
        Class clazz;
        Generics.GenericType genericType;
        Class<?> clazz2;
        boolean bl3;
        FieldSerializer.FieldSerializerConfig fieldSerializerConfig;
        block27: {
            FieldSerializer.Optional optional;
            int n3 = field.getModifiers();
            if (Modifier.isStatic(n3)) {
                return;
            }
            fieldSerializerConfig = this.serializer.config;
            if (field.isSynthetic() && fieldSerializerConfig.ignoreSyntheticFields) {
                return;
            }
            if (!field.isAccessible()) {
                if (!fieldSerializerConfig.setFieldsAsAccessible) {
                    return;
                }
                try {
                    field.setAccessible(true);
                }
                catch (AccessControlException accessControlException) {
                    if (Log.DEBUG) {
                        Log.debug("kryo", "Unable to set field as accessible: " + field);
                    }
                    return;
                }
            }
            if ((optional = field.getAnnotation(FieldSerializer.Optional.class)) != null && !this.serializer.kryo.getContext().containsKey(optional.value())) {
                return;
            }
            if (this.removedFields.contains(field)) {
                return;
            }
            bl3 = Modifier.isTransient(n3);
            if (bl3 && !fieldSerializerConfig.serializeTransient && !fieldSerializerConfig.copyTransient) {
                return;
            }
            clazz2 = field.getDeclaringClass();
            genericType = new Generics.GenericType(clazz2, this.serializer.type, field.getGenericType());
            clazz = genericType.getType() instanceof Class ? (Class)genericType.getType() : field.getType();
            n2 = -1;
            if (bl2 && !Modifier.isFinal(n3) && Modifier.isPublic(n3) && Modifier.isPublic(clazz.getModifiers())) {
                try {
                    if (this.access == null) {
                        this.access = FieldAccess.get(this.serializer.type);
                    }
                    n2 = ((FieldAccess)this.access).getIndex(field);
                }
                catch (RuntimeException runtimeException) {
                    if (!Log.DEBUG) break block27;
                    Log.debug("kryo", "Unable to use ReflectASM.", runtimeException);
                }
            }
        }
        if (Util.unsafe) {
            cachedField = this.newUnsafeField(field, clazz, genericType);
        } else if (n2 != -1) {
            cachedField = this.newAsmField(field, clazz, genericType);
            cachedField.access = (FieldAccess)this.access;
            cachedField.accessIndex = n2;
        } else {
            cachedField = this.newReflectField(field, clazz, genericType);
        }
        cachedField.varEncoding = fieldSerializerConfig.varEncoding;
        cachedField.name = fieldSerializerConfig.extendedFieldNames ? clazz2.getSimpleName() + "." + field.getName() : field.getName();
        if (cachedField instanceof ReflectField) {
            boolean bl4 = cachedField.canBeNull = fieldSerializerConfig.fieldsCanBeNull && !field.isAnnotationPresent(FieldSerializer.NotNull.class);
            if (this.serializer.kryo.isFinal(clazz) || fieldSerializerConfig.fixedFieldTypes) {
                cachedField.valueClass = clazz;
            }
            if (Log.TRACE) {
                Log.trace("kryo", "Cached " + clazz.getSimpleName() + " field: " + field.getName() + " (" + Util.className(clazz2) + ")");
            }
        } else {
            cachedField.canBeNull = clazz == String.class && fieldSerializerConfig.fieldsCanBeNull;
            cachedField.valueClass = clazz;
            if (Log.TRACE) {
                Log.trace("kryo", "Cached " + clazz.getSimpleName() + " field: " + field.getName() + " (" + Util.className(clazz2) + ")");
            }
        }
        this.applyAnnotations(cachedField);
        if (bl3) {
            if (fieldSerializerConfig.serializeTransient) {
                arrayList.add(cachedField);
            }
            if (fieldSerializerConfig.copyTransient) {
                arrayList2.add(cachedField);
            }
        } else {
            arrayList.add(cachedField);
            arrayList2.add(cachedField);
        }
    }

    private FieldSerializer.CachedField newUnsafeField(Field field, Class clazz, Generics.GenericType genericType) {
        if (clazz.isPrimitive()) {
            if (clazz == Integer.TYPE) {
                return new UnsafeField.IntUnsafeField(field);
            }
            if (clazz == Float.TYPE) {
                return new UnsafeField.FloatUnsafeField(field);
            }
            if (clazz == Boolean.TYPE) {
                return new UnsafeField.BooleanUnsafeField(field);
            }
            if (clazz == Long.TYPE) {
                return new UnsafeField.LongUnsafeField(field);
            }
            if (clazz == Double.TYPE) {
                return new UnsafeField.DoubleUnsafeField(field);
            }
            if (clazz == Short.TYPE) {
                return new UnsafeField.ShortUnsafeField(field);
            }
            if (clazz == Character.TYPE) {
                return new UnsafeField.CharUnsafeField(field);
            }
            if (clazz == Byte.TYPE) {
                return new UnsafeField.ByteUnsafeField(field);
            }
        }
        if (!(clazz != String.class || this.serializer.kryo.getReferences() && this.serializer.kryo.getReferenceResolver().useReferences(String.class))) {
            return new UnsafeField.StringUnsafeField(field);
        }
        return new UnsafeField(field, this.serializer, genericType);
    }

    private FieldSerializer.CachedField newAsmField(Field field, Class clazz, Generics.GenericType genericType) {
        if (clazz.isPrimitive()) {
            if (clazz == Integer.TYPE) {
                return new AsmField.IntAsmField(field);
            }
            if (clazz == Float.TYPE) {
                return new AsmField.FloatAsmField(field);
            }
            if (clazz == Boolean.TYPE) {
                return new AsmField.BooleanAsmField(field);
            }
            if (clazz == Long.TYPE) {
                return new AsmField.LongAsmField(field);
            }
            if (clazz == Double.TYPE) {
                return new AsmField.DoubleAsmField(field);
            }
            if (clazz == Short.TYPE) {
                return new AsmField.ShortAsmField(field);
            }
            if (clazz == Character.TYPE) {
                return new AsmField.CharAsmField(field);
            }
            if (clazz == Byte.TYPE) {
                return new AsmField.ByteAsmField(field);
            }
        }
        if (!(clazz != String.class || this.serializer.kryo.getReferences() && this.serializer.kryo.getReferenceResolver().useReferences(String.class))) {
            return new AsmField.StringAsmField(field);
        }
        return new AsmField(field, this.serializer, genericType);
    }

    private FieldSerializer.CachedField newReflectField(Field field, Class clazz, Generics.GenericType genericType) {
        if (clazz.isPrimitive()) {
            if (clazz == Integer.TYPE) {
                return new ReflectField.IntReflectField(field);
            }
            if (clazz == Float.TYPE) {
                return new ReflectField.FloatReflectField(field);
            }
            if (clazz == Boolean.TYPE) {
                return new ReflectField.BooleanReflectField(field);
            }
            if (clazz == Long.TYPE) {
                return new ReflectField.LongReflectField(field);
            }
            if (clazz == Double.TYPE) {
                return new ReflectField.DoubleReflectField(field);
            }
            if (clazz == Short.TYPE) {
                return new ReflectField.ShortReflectField(field);
            }
            if (clazz == Character.TYPE) {
                return new ReflectField.CharReflectField(field);
            }
            if (clazz == Byte.TYPE) {
                return new ReflectField.ByteReflectField(field);
            }
        }
        return new ReflectField(field, this.serializer, genericType);
    }

    @Override
    public int compare(FieldSerializer.CachedField cachedField, FieldSerializer.CachedField cachedField2) {
        return cachedField.name.compareTo(cachedField2.name);
    }

    public void removeField(String string) {
        FieldSerializer.CachedField[] cachedFieldArray;
        FieldSerializer.CachedField cachedField;
        int n2;
        boolean bl2 = false;
        for (n2 = 0; n2 < this.fields.length; ++n2) {
            cachedField = this.fields[n2];
            if (!cachedField.name.equals(string)) continue;
            cachedFieldArray = new FieldSerializer.CachedField[this.fields.length - 1];
            System.arraycopy(this.fields, 0, cachedFieldArray, 0, n2);
            System.arraycopy(this.fields, n2 + 1, cachedFieldArray, n2, cachedFieldArray.length - n2);
            this.fields = cachedFieldArray;
            this.removedFields.add(cachedField.field);
            bl2 = true;
            break;
        }
        for (n2 = 0; n2 < this.copyFields.length; ++n2) {
            cachedField = this.copyFields[n2];
            if (!cachedField.name.equals(string)) continue;
            cachedFieldArray = new FieldSerializer.CachedField[this.copyFields.length - 1];
            System.arraycopy(this.copyFields, 0, cachedFieldArray, 0, n2);
            System.arraycopy(this.copyFields, n2 + 1, cachedFieldArray, n2, cachedFieldArray.length - n2);
            this.copyFields = cachedFieldArray;
            this.removedFields.add(cachedField.field);
            bl2 = true;
            break;
        }
        if (!bl2) {
            throw new IllegalArgumentException("Field \"" + string + "\" not found on class: " + this.serializer.type.getName());
        }
    }

    public void removeField(FieldSerializer.CachedField cachedField) {
        FieldSerializer.CachedField[] cachedFieldArray;
        FieldSerializer.CachedField cachedField2;
        int n2;
        boolean bl2 = false;
        for (n2 = 0; n2 < this.fields.length; ++n2) {
            cachedField2 = this.fields[n2];
            if (cachedField2 != cachedField) continue;
            cachedFieldArray = new FieldSerializer.CachedField[this.fields.length - 1];
            System.arraycopy(this.fields, 0, cachedFieldArray, 0, n2);
            System.arraycopy(this.fields, n2 + 1, cachedFieldArray, n2, cachedFieldArray.length - n2);
            this.fields = cachedFieldArray;
            this.removedFields.add(cachedField2.field);
            bl2 = true;
            break;
        }
        for (n2 = 0; n2 < this.copyFields.length; ++n2) {
            cachedField2 = this.copyFields[n2];
            if (cachedField2 != cachedField) continue;
            cachedFieldArray = new FieldSerializer.CachedField[this.copyFields.length - 1];
            System.arraycopy(this.copyFields, 0, cachedFieldArray, 0, n2);
            System.arraycopy(this.copyFields, n2 + 1, cachedFieldArray, n2, cachedFieldArray.length - n2);
            this.copyFields = cachedFieldArray;
            this.removedFields.add(cachedField2.field);
            bl2 = true;
            break;
        }
        if (!bl2) {
            throw new IllegalArgumentException("Field \"" + cachedField + "\" not found on class: " + this.serializer.type.getName());
        }
    }

    private void applyAnnotations(FieldSerializer.CachedField cachedField) {
        Object object;
        Serializer serializer;
        Class clazz;
        Annotation annotation;
        Field field = cachedField.field;
        if (field.isAnnotationPresent(FieldSerializer.Bind.class)) {
            if (cachedField.serializer != null) {
                throw new KryoException("@Bind applied to a field that already has a serializer: " + cachedField.field.getDeclaringClass().getName() + "." + cachedField.field.getName());
            }
            annotation = field.getAnnotation(FieldSerializer.Bind.class);
            clazz = annotation.valueClass();
            if (clazz == Object.class) {
                clazz = null;
            }
            if (clazz != null) {
                cachedField.setValueClass(clazz);
            }
            if ((serializer = this.newSerializer(clazz, annotation.serializer(), annotation.serializerFactory())) != null) {
                cachedField.setSerializer(serializer);
            }
            cachedField.setCanBeNull(annotation.canBeNull());
            cachedField.setVariableLengthEncoding(annotation.variableLengthEncoding());
            cachedField.setOptimizePositive(annotation.optimizePositive());
        }
        if (field.isAnnotationPresent(CollectionSerializer.BindCollection.class)) {
            if (cachedField.serializer != null) {
                throw new KryoException("@BindCollection applied to a field that already has a serializer: " + cachedField.field.getDeclaringClass().getName() + "." + cachedField.field.getName());
            }
            if (!Collection.class.isAssignableFrom(field.getType())) {
                throw new KryoException("@BindCollection can only be used with a field implementing Collection: " + Util.className(field.getType()));
            }
            annotation = field.getAnnotation(CollectionSerializer.BindCollection.class);
            clazz = annotation.elementClass();
            if (clazz == Object.class) {
                clazz = null;
            }
            serializer = this.newSerializer(clazz, annotation.elementSerializer(), annotation.elementSerializerFactory());
            object = new CollectionSerializer();
            ((CollectionSerializer)object).setElementsCanBeNull(annotation.elementsCanBeNull());
            if (clazz != null) {
                ((CollectionSerializer)object).setElementClass(clazz);
            }
            if (serializer != null) {
                ((CollectionSerializer)object).setElementSerializer(serializer);
            }
            cachedField.setSerializer((Serializer)object);
        }
        if (field.isAnnotationPresent(MapSerializer.BindMap.class)) {
            if (cachedField.serializer != null) {
                throw new KryoException("@BindMap applied to a field that already has a serializer: " + cachedField.field.getDeclaringClass().getName() + "." + cachedField.field.getName());
            }
            if (!Map.class.isAssignableFrom(field.getType())) {
                throw new KryoException("@BindMap can only be used with a field implementing Map: " + Util.className(field.getType()));
            }
            annotation = field.getAnnotation(MapSerializer.BindMap.class);
            clazz = annotation.valueClass();
            if (clazz == Object.class) {
                clazz = null;
            }
            serializer = this.newSerializer(clazz, annotation.valueSerializer(), annotation.valueSerializerFactory());
            object = annotation.keyClass();
            if (object == Object.class) {
                object = null;
            }
            Serializer serializer2 = this.newSerializer((Class)object, annotation.keySerializer(), annotation.keySerializerFactory());
            MapSerializer mapSerializer = new MapSerializer();
            mapSerializer.setKeysCanBeNull(annotation.keysCanBeNull());
            mapSerializer.setValuesCanBeNull(annotation.valuesCanBeNull());
            if (object != null) {
                mapSerializer.setKeyClass((Class)object);
            }
            if (serializer2 != null) {
                mapSerializer.setKeySerializer(serializer2);
            }
            if (clazz != null) {
                mapSerializer.setValueClass(clazz);
            }
            if (serializer != null) {
                mapSerializer.setValueSerializer(serializer);
            }
            cachedField.setSerializer(mapSerializer);
        }
    }

    private Serializer newSerializer(Class clazz, Class clazz2, Class clazz3) {
        if (clazz2 == Serializer.class) {
            clazz2 = null;
        }
        if (clazz3 == SerializerFactory.class) {
            clazz3 = null;
        }
        if (clazz3 == null && clazz2 != null) {
            clazz3 = SerializerFactory.ReflectionSerializerFactory.class;
        }
        if (clazz3 == null) {
            return null;
        }
        return Util.newFactory(clazz3, clazz2).newSerializer(this.serializer.kryo, clazz);
    }
}

