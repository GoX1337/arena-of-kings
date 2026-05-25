/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.kryo;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.serializers.CompatibleFieldSerializer;
import com.esotericsoftware.kryo.serializers.FieldSerializer;
import com.esotericsoftware.kryo.serializers.TaggedFieldSerializer;
import com.esotericsoftware.kryo.serializers.VersionFieldSerializer;
import com.esotericsoftware.kryo.util.Util;

public interface SerializerFactory<T extends Serializer> {
    public T newSerializer(Kryo var1, Class var2);

    public boolean isSupported(Class var1);

    public static class CompatibleFieldSerializerFactory
    extends BaseSerializerFactory<CompatibleFieldSerializer> {
        private final CompatibleFieldSerializer.CompatibleFieldSerializerConfig config;

        public CompatibleFieldSerializerFactory() {
            this.config = new CompatibleFieldSerializer.CompatibleFieldSerializerConfig();
        }

        public CompatibleFieldSerializerFactory(CompatibleFieldSerializer.CompatibleFieldSerializerConfig compatibleFieldSerializerConfig) {
            this.config = compatibleFieldSerializerConfig;
        }

        public CompatibleFieldSerializer.CompatibleFieldSerializerConfig getConfig() {
            return this.config;
        }

        @Override
        public CompatibleFieldSerializer newSerializer(Kryo kryo, Class clazz) {
            return new CompatibleFieldSerializer(kryo, clazz, this.config.clone());
        }
    }

    public static class VersionFieldSerializerFactory
    extends BaseSerializerFactory<VersionFieldSerializer> {
        private final VersionFieldSerializer.VersionFieldSerializerConfig config;

        public VersionFieldSerializerFactory() {
            this.config = new VersionFieldSerializer.VersionFieldSerializerConfig();
        }

        public VersionFieldSerializerFactory(VersionFieldSerializer.VersionFieldSerializerConfig versionFieldSerializerConfig) {
            this.config = versionFieldSerializerConfig;
        }

        public VersionFieldSerializer.VersionFieldSerializerConfig getConfig() {
            return this.config;
        }

        @Override
        public VersionFieldSerializer newSerializer(Kryo kryo, Class clazz) {
            return new VersionFieldSerializer(kryo, clazz, this.config.clone());
        }
    }

    public static class TaggedFieldSerializerFactory
    extends BaseSerializerFactory<TaggedFieldSerializer> {
        private final TaggedFieldSerializer.TaggedFieldSerializerConfig config;

        public TaggedFieldSerializerFactory() {
            this.config = new TaggedFieldSerializer.TaggedFieldSerializerConfig();
        }

        public TaggedFieldSerializerFactory(TaggedFieldSerializer.TaggedFieldSerializerConfig taggedFieldSerializerConfig) {
            this.config = taggedFieldSerializerConfig;
        }

        public TaggedFieldSerializer.TaggedFieldSerializerConfig getConfig() {
            return this.config;
        }

        @Override
        public TaggedFieldSerializer newSerializer(Kryo kryo, Class clazz) {
            return new TaggedFieldSerializer(kryo, clazz, this.config.clone());
        }
    }

    public static class FieldSerializerFactory
    extends BaseSerializerFactory<FieldSerializer> {
        private final FieldSerializer.FieldSerializerConfig config;

        public FieldSerializerFactory() {
            this.config = new FieldSerializer.FieldSerializerConfig();
        }

        public FieldSerializerFactory(FieldSerializer.FieldSerializerConfig fieldSerializerConfig) {
            this.config = fieldSerializerConfig;
        }

        public FieldSerializer.FieldSerializerConfig getConfig() {
            return this.config;
        }

        @Override
        public FieldSerializer newSerializer(Kryo kryo, Class clazz) {
            return new FieldSerializer(kryo, clazz, this.config.clone());
        }
    }

    public static class SingletonSerializerFactory<T extends Serializer>
    extends BaseSerializerFactory<T> {
        private final T serializer;

        public SingletonSerializerFactory(T t2) {
            this.serializer = t2;
        }

        @Override
        public T newSerializer(Kryo kryo, Class clazz) {
            return this.serializer;
        }
    }

    public static class ReflectionSerializerFactory<T extends Serializer>
    extends BaseSerializerFactory<T> {
        private final Class<T> serializerClass;

        public ReflectionSerializerFactory(Class<T> clazz) {
            this.serializerClass = clazz;
        }

        @Override
        public T newSerializer(Kryo kryo, Class clazz) {
            return ReflectionSerializerFactory.newSerializer(kryo, this.serializerClass, clazz);
        }

        public static <T extends Serializer> T newSerializer(Kryo kryo, Class<T> clazz, Class clazz2) {
            try {
                try {
                    return (T)((Serializer)clazz.getConstructor(Kryo.class, Class.class).newInstance(kryo, clazz2));
                }
                catch (NoSuchMethodException noSuchMethodException) {
                    try {
                        return (T)((Serializer)clazz.getConstructor(Kryo.class).newInstance(kryo));
                    }
                    catch (NoSuchMethodException noSuchMethodException2) {
                        try {
                            return (T)((Serializer)clazz.getConstructor(Class.class).newInstance(clazz2));
                        }
                        catch (NoSuchMethodException noSuchMethodException3) {
                            return (T)((Serializer)clazz.newInstance());
                        }
                    }
                }
            }
            catch (Exception exception) {
                throw new IllegalArgumentException("Unable to create serializer \"" + clazz.getName() + "\" for class: " + Util.className(clazz2), exception);
            }
        }
    }

    public static abstract class BaseSerializerFactory<T extends Serializer>
    implements SerializerFactory<T> {
        @Override
        public boolean isSupported(Class clazz) {
            return true;
        }
    }
}

