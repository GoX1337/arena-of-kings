/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.SerializerFactory;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.serializers.CachedFields;
import com.esotericsoftware.kryo.serializers.ReflectField;
import com.esotericsoftware.kryo.util.Generics;
import com.esotericsoftware.kryo.util.Util;
import com.esotericsoftware.minlog.Log;
import com.esotericsoftware.reflectasm.FieldAccess;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

public class FieldSerializer<T>
extends Serializer<T> {
    final Kryo kryo;
    final Class type;
    final FieldSerializerConfig config;
    final CachedFields cachedFields;
    private final Generics.GenericsHierarchy genericsHierarchy;

    public FieldSerializer(Kryo kryo, Class clazz) {
        this(kryo, clazz, new FieldSerializerConfig());
    }

    public FieldSerializer(Kryo kryo, Class clazz, FieldSerializerConfig fieldSerializerConfig) {
        if (clazz == null) {
            throw new IllegalArgumentException("type cannot be null.");
        }
        if (clazz.isPrimitive()) {
            throw new IllegalArgumentException("type cannot be a primitive class: " + clazz);
        }
        if (fieldSerializerConfig == null) {
            throw new IllegalArgumentException("config cannot be null.");
        }
        this.kryo = kryo;
        this.type = clazz;
        this.config = fieldSerializerConfig;
        this.genericsHierarchy = new Generics.GenericsHierarchy(clazz);
        this.cachedFields = new CachedFields(this);
        this.cachedFields.rebuild();
    }

    protected void initializeCachedFields() {
    }

    public FieldSerializerConfig getFieldSerializerConfig() {
        return this.config;
    }

    public void updateFields() {
        if (Log.TRACE) {
            Log.trace("kryo", "Update fields: " + Util.className(this.type));
        }
        this.cachedFields.rebuild();
    }

    @Override
    public void write(Kryo kryo, Output output, T t2) {
        int n2 = this.pushTypeVariables();
        CachedField[] cachedFieldArray = this.cachedFields.fields;
        int n3 = cachedFieldArray.length;
        for (int i2 = 0; i2 < n3; ++i2) {
            if (Log.TRACE) {
                this.log("Write", cachedFieldArray[i2], output.position());
            }
            cachedFieldArray[i2].write(output, t2);
        }
        this.popTypeVariables(n2);
    }

    @Override
    public T read(Kryo kryo, Input input, Class<? extends T> clazz) {
        int n2 = this.pushTypeVariables();
        T t2 = this.create(kryo, input, clazz);
        kryo.reference(t2);
        CachedField[] cachedFieldArray = this.cachedFields.fields;
        int n3 = cachedFieldArray.length;
        for (int i2 = 0; i2 < n3; ++i2) {
            if (Log.TRACE) {
                this.log("Read", cachedFieldArray[i2], input.position());
            }
            cachedFieldArray[i2].read(input, t2);
        }
        this.popTypeVariables(n2);
        return t2;
    }

    protected int pushTypeVariables() {
        Generics.GenericType[] genericTypeArray = this.kryo.getGenerics().nextGenericTypes();
        if (genericTypeArray == null) {
            return 0;
        }
        int n2 = this.kryo.getGenerics().pushTypeVariables(this.genericsHierarchy, genericTypeArray);
        if (Log.TRACE && n2 > 0) {
            Log.trace("kryo", "Generics: " + this.kryo.getGenerics());
        }
        return n2;
    }

    protected void popTypeVariables(int n2) {
        Generics generics = this.kryo.getGenerics();
        if (n2 > 0) {
            generics.popTypeVariables(n2);
        }
        generics.popGenericType();
    }

    protected T create(Kryo kryo, Input input, Class<? extends T> clazz) {
        return kryo.newInstance(clazz);
    }

    protected void log(String string, CachedField cachedField, int n2) {
        String string2;
        if (cachedField instanceof ReflectField) {
            ReflectField reflectField = (ReflectField)cachedField;
            Class<?> clazz = reflectField.resolveFieldClass();
            if (clazz == null) {
                clazz = cachedField.field.getType();
            }
            string2 = Util.simpleName(clazz, reflectField.genericType);
        } else {
            string2 = cachedField.valueClass != null ? cachedField.valueClass.getSimpleName() : cachedField.field.getType().getSimpleName();
        }
        Log.trace("kryo", string + " field " + string2 + ": " + cachedField.name + " (" + Util.className(cachedField.field.getDeclaringClass()) + ')' + Util.pos(n2));
    }

    public CachedField getField(String string) {
        for (CachedField cachedField : this.cachedFields.fields) {
            if (!cachedField.name.equals(string)) continue;
            return cachedField;
        }
        throw new IllegalArgumentException("Field \"" + string + "\" not found on class: " + this.type.getName());
    }

    public void removeField(String string) {
        this.cachedFields.removeField(string);
    }

    public void removeField(CachedField cachedField) {
        this.cachedFields.removeField(cachedField);
    }

    public CachedField[] getFields() {
        return this.cachedFields.fields;
    }

    public CachedField[] getCopyFields() {
        return this.cachedFields.copyFields;
    }

    public Class getType() {
        return this.type;
    }

    public Kryo getKryo() {
        return this.kryo;
    }

    protected T createCopy(Kryo kryo, T t2) {
        return (T)kryo.newInstance(t2.getClass());
    }

    @Override
    public T copy(Kryo kryo, T t2) {
        T t3 = this.createCopy(kryo, t2);
        kryo.reference(t3);
        int n2 = this.cachedFields.copyFields.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            this.cachedFields.copyFields[i2].copy(t2, t3);
        }
        return t3;
    }

    public static class FieldSerializerConfig
    implements Cloneable {
        boolean fieldsCanBeNull = true;
        boolean setFieldsAsAccessible = true;
        boolean ignoreSyntheticFields = true;
        boolean fixedFieldTypes;
        boolean copyTransient = true;
        boolean serializeTransient;
        boolean varEncoding = true;
        boolean extendedFieldNames;

        public FieldSerializerConfig clone() {
            try {
                return (FieldSerializerConfig)super.clone();
            }
            catch (CloneNotSupportedException cloneNotSupportedException) {
                throw new KryoException(cloneNotSupportedException);
            }
        }

        public void setFieldsCanBeNull(boolean bl2) {
            this.fieldsCanBeNull = bl2;
            if (Log.TRACE) {
                Log.trace("kryo", "FieldSerializerConfig fieldsCanBeNull: " + bl2);
            }
        }

        public boolean getFieldsCanBeNull() {
            return this.fieldsCanBeNull;
        }

        public void setFieldsAsAccessible(boolean bl2) {
            this.setFieldsAsAccessible = bl2;
            if (Log.TRACE) {
                Log.trace("kryo", "FieldSerializerConfig setFieldsAsAccessible: " + bl2);
            }
        }

        public boolean getSetFieldsAsAccessible() {
            return this.setFieldsAsAccessible;
        }

        public void setIgnoreSyntheticFields(boolean bl2) {
            this.ignoreSyntheticFields = bl2;
            if (Log.TRACE) {
                Log.trace("kryo", "FieldSerializerConfig ignoreSyntheticFields: " + bl2);
            }
        }

        public boolean getIgnoreSyntheticFields() {
            return this.ignoreSyntheticFields;
        }

        public void setFixedFieldTypes(boolean bl2) {
            this.fixedFieldTypes = bl2;
            if (Log.TRACE) {
                Log.trace("kryo", "FieldSerializerConfig fixedFieldTypes: " + bl2);
            }
        }

        public boolean getFixedFieldTypes() {
            return this.fixedFieldTypes;
        }

        public void setCopyTransient(boolean bl2) {
            this.copyTransient = bl2;
            if (Log.TRACE) {
                Log.trace("kryo", "FieldSerializerConfig copyTransient: " + bl2);
            }
        }

        public boolean getCopyTransient() {
            return this.copyTransient;
        }

        public void setSerializeTransient(boolean bl2) {
            this.serializeTransient = bl2;
            if (Log.TRACE) {
                Log.trace("kryo", "FieldSerializerConfig serializeTransient: " + bl2);
            }
        }

        public boolean getSerializeTransient() {
            return this.serializeTransient;
        }

        public void setVariableLengthEncoding(boolean bl2) {
            this.varEncoding = bl2;
            if (Log.TRACE) {
                Log.trace("kryo", "FieldSerializerConfig variable length encoding: " + bl2);
            }
        }

        public boolean getVariableLengthEncoding() {
            return this.varEncoding;
        }

        public void setExtendedFieldNames(boolean bl2) {
            this.extendedFieldNames = bl2;
            if (Log.TRACE) {
                Log.trace("kryo", "FieldSerializerConfig extendedFieldNames: " + bl2);
            }
        }

        public boolean getExtendedFieldNames() {
            return this.extendedFieldNames;
        }
    }

    @Retention(value=RetentionPolicy.RUNTIME)
    @Target(value={ElementType.FIELD})
    public static @interface NotNull {
    }

    @Retention(value=RetentionPolicy.RUNTIME)
    @Target(value={ElementType.FIELD})
    public static @interface Bind {
        public Class valueClass() default Object.class;

        public Class<? extends Serializer> serializer() default Serializer.class;

        public Class<? extends SerializerFactory> serializerFactory() default SerializerFactory.class;

        public boolean canBeNull() default true;

        public boolean variableLengthEncoding() default true;

        public boolean optimizePositive() default false;
    }

    @Retention(value=RetentionPolicy.RUNTIME)
    @Target(value={ElementType.FIELD})
    public static @interface Optional {
        public String value();
    }

    public static abstract class CachedField {
        final Field field;
        String name;
        Class valueClass;
        Serializer serializer;
        boolean canBeNull;
        boolean varEncoding = true;
        boolean optimizePositive;
        boolean reuseSerializer = true;
        FieldAccess access;
        int accessIndex = -1;
        long offset;
        int tag;

        public CachedField(Field field) {
            this.field = field;
        }

        public void setValueClass(Class clazz) {
            this.valueClass = clazz;
        }

        public Class getValueClass() {
            return this.valueClass;
        }

        public void setValueClass(Class clazz, Serializer serializer) {
            this.valueClass = clazz;
            this.serializer = serializer;
        }

        public void setSerializer(Serializer serializer) {
            this.serializer = serializer;
        }

        public Serializer getSerializer() {
            return this.serializer;
        }

        public void setCanBeNull(boolean bl2) {
            this.canBeNull = bl2;
        }

        public boolean getCanBeNull() {
            return this.canBeNull;
        }

        public void setVariableLengthEncoding(boolean bl2) {
            this.varEncoding = bl2;
        }

        public boolean getVariableLengthEncoding() {
            return this.varEncoding;
        }

        public void setOptimizePositive(boolean bl2) {
            this.optimizePositive = bl2;
        }

        public boolean getOptimizePositive() {
            return this.optimizePositive;
        }

        void setReuseSerializer(boolean bl2) {
            this.reuseSerializer = bl2;
        }

        boolean getReuseSerializer() {
            return this.reuseSerializer;
        }

        public String getName() {
            return this.name;
        }

        public Field getField() {
            return this.field;
        }

        public String toString() {
            return this.name;
        }

        public abstract void write(Output var1, Object var2);

        public abstract void read(Input var1, Object var2);

        public abstract void copy(Object var1, Object var2);
    }
}

