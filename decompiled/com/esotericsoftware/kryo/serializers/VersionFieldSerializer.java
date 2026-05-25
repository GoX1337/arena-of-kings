/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.serializers.FieldSerializer;
import com.esotericsoftware.minlog.Log;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

public class VersionFieldSerializer<T>
extends FieldSerializer<T> {
    private final VersionFieldSerializerConfig config;
    private int typeVersion;
    private int[] fieldVersion;

    public VersionFieldSerializer(Kryo kryo, Class clazz) {
        this(kryo, clazz, new VersionFieldSerializerConfig());
    }

    public VersionFieldSerializer(Kryo kryo, Class clazz, VersionFieldSerializerConfig versionFieldSerializerConfig) {
        super(kryo, clazz, versionFieldSerializerConfig);
        this.config = versionFieldSerializerConfig;
        this.setAcceptsNull(true);
        this.initializeCachedFields();
    }

    @Override
    protected void initializeCachedFields() {
        FieldSerializer.CachedField[] cachedFieldArray = this.cachedFields.fields;
        this.fieldVersion = new int[cachedFieldArray.length];
        int n2 = cachedFieldArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            Field field = cachedFieldArray[i2].field;
            Since since = field.getAnnotation(Since.class);
            if (since != null) {
                this.fieldVersion[i2] = since.value();
                this.typeVersion = Math.max(this.fieldVersion[i2], this.typeVersion);
                continue;
            }
            this.fieldVersion[i2] = 0;
        }
        if (Log.DEBUG) {
            Log.debug("Version for type " + this.getType().getName() + ": " + this.typeVersion);
        }
    }

    @Override
    public void removeField(String string) {
        super.removeField(string);
        this.initializeCachedFields();
    }

    @Override
    public void removeField(FieldSerializer.CachedField cachedField) {
        super.removeField(cachedField);
        this.initializeCachedFields();
    }

    @Override
    public void write(Kryo kryo, Output output, T t2) {
        if (t2 == null) {
            output.writeByte((byte)0);
            return;
        }
        int n2 = this.pushTypeVariables();
        FieldSerializer.CachedField[] cachedFieldArray = this.cachedFields.fields;
        output.writeVarInt(this.typeVersion + 1, true);
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
        int n2 = input.readVarInt(true);
        if (n2 == 0) {
            return null;
        }
        if (!this.config.compatible && --n2 != this.typeVersion) {
            throw new KryoException("Version is not compatible: " + n2 + " != " + this.typeVersion);
        }
        int n3 = this.pushTypeVariables();
        T t2 = this.create(kryo, input, clazz);
        kryo.reference(t2);
        FieldSerializer.CachedField[] cachedFieldArray = this.cachedFields.fields;
        int n4 = cachedFieldArray.length;
        for (int i2 = 0; i2 < n4; ++i2) {
            if (this.fieldVersion[i2] > n2) {
                if (!Log.DEBUG) continue;
                Log.debug("Skip field: " + cachedFieldArray[i2].field.getName());
                continue;
            }
            if (Log.TRACE) {
                this.log("Read", cachedFieldArray[i2], input.position());
            }
            cachedFieldArray[i2].read(input, t2);
        }
        this.popTypeVariables(n3);
        return t2;
    }

    public VersionFieldSerializerConfig getVersionFieldSerializerConfig() {
        return this.config;
    }

    public static class VersionFieldSerializerConfig
    extends FieldSerializer.FieldSerializerConfig {
        boolean compatible = true;

        @Override
        public VersionFieldSerializerConfig clone() {
            return (VersionFieldSerializerConfig)super.clone();
        }

        public void setCompatible(boolean bl2) {
            this.compatible = bl2;
            if (Log.TRACE) {
                Log.trace("kryo", "VersionFieldSerializerConfig setCompatible: " + bl2);
            }
        }

        public boolean getCompatible() {
            return this.compatible;
        }
    }

    @Retention(value=RetentionPolicy.RUNTIME)
    @Target(value={ElementType.FIELD})
    public static @interface Since {
        public int value() default 0;
    }
}

