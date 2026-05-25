/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.serializers.CollectionSerializer;
import com.esotericsoftware.kryo.serializers.MapSerializer;
import com.esotericsoftware.kryo.util.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class ImmutableCollectionsSerializers {
    public static void addDefaultSerializers(Kryo kryo) {
        if (Util.isClassAvailable("java.util.ImmutableCollections")) {
            JdkImmutableListSerializer.addDefaultSerializers(kryo);
            JdkImmutableMapSerializer.addDefaultSerializers(kryo);
            JdkImmutableSetSerializer.addDefaultSerializers(kryo);
        }
    }

    static class JdkImmutableSetSerializer
    extends CollectionSerializer<Set<Object>> {
        private JdkImmutableSetSerializer() {
            this.setElementsCanBeNull(false);
        }

        @Override
        protected Set<Object> create(Kryo kryo, Input input, Class<? extends Set<Object>> clazz, int n2) {
            return new HashSet<Object>();
        }

        @Override
        protected Set<Object> createCopy(Kryo kryo, Set<Object> set) {
            return new HashSet<Object>();
        }

        @Override
        public Set<Object> read(Kryo kryo, Input input, Class<? extends Set<Object>> clazz) {
            Set set = (Set)super.read(kryo, input, clazz);
            if (set == null) {
                return null;
            }
            return Set.of(set.toArray());
        }

        @Override
        public Set<Object> copy(Kryo kryo, Set<Object> set) {
            Set<Object> set2 = super.copy(kryo, set);
            return Set.copyOf(set2);
        }

        static void addDefaultSerializers(Kryo kryo) {
            JdkImmutableSetSerializer jdkImmutableSetSerializer = new JdkImmutableSetSerializer();
            kryo.addDefaultSerializer(Set.of().getClass(), jdkImmutableSetSerializer);
            kryo.addDefaultSerializer(Set.of(Integer.valueOf(1)).getClass(), jdkImmutableSetSerializer);
            kryo.addDefaultSerializer(Set.of(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4)).getClass(), jdkImmutableSetSerializer);
        }
    }

    static class JdkImmutableMapSerializer
    extends MapSerializer<Map<Object, Object>> {
        private JdkImmutableMapSerializer() {
            this.setKeysCanBeNull(false);
            this.setValuesCanBeNull(false);
        }

        @Override
        protected Map<Object, Object> create(Kryo kryo, Input input, Class<? extends Map<Object, Object>> clazz, int n2) {
            return new HashMap<Object, Object>();
        }

        @Override
        protected Map<Object, Object> createCopy(Kryo kryo, Map<Object, Object> map) {
            return new HashMap<Object, Object>();
        }

        @Override
        public Map<Object, Object> read(Kryo kryo, Input input, Class<? extends Map<Object, Object>> clazz) {
            Object object = super.read(kryo, input, clazz);
            if (object == null) {
                return null;
            }
            return Map.copyOf(object);
        }

        @Override
        public Map<Object, Object> copy(Kryo kryo, Map<Object, Object> map) {
            Map<Object, Object> map2 = super.copy(kryo, map);
            return Map.copyOf(map2);
        }

        static void addDefaultSerializers(Kryo kryo) {
            JdkImmutableMapSerializer jdkImmutableMapSerializer = new JdkImmutableMapSerializer();
            kryo.addDefaultSerializer(Map.of().getClass(), jdkImmutableMapSerializer);
            kryo.addDefaultSerializer(Map.of(1, 2).getClass(), jdkImmutableMapSerializer);
            kryo.addDefaultSerializer(Map.of(1, 2, 3, 4).getClass(), jdkImmutableMapSerializer);
        }
    }

    static class JdkImmutableListSerializer
    extends CollectionSerializer<List<Object>> {
        private JdkImmutableListSerializer() {
            this.setElementsCanBeNull(false);
        }

        @Override
        protected List<Object> create(Kryo kryo, Input input, Class<? extends List<Object>> clazz, int n2) {
            return new ArrayList<Object>(n2);
        }

        @Override
        protected List<Object> createCopy(Kryo kryo, List<Object> list) {
            return new ArrayList<Object>(list.size());
        }

        @Override
        public List<Object> read(Kryo kryo, Input input, Class<? extends List<Object>> clazz) {
            List list = (List)super.read(kryo, input, clazz);
            if (list == null) {
                return null;
            }
            return List.of(list.toArray());
        }

        @Override
        public List<Object> copy(Kryo kryo, List<Object> list) {
            List<Object> list2 = super.copy(kryo, list);
            return List.copyOf(list2);
        }

        static void addDefaultSerializers(Kryo kryo) {
            JdkImmutableListSerializer jdkImmutableListSerializer = new JdkImmutableListSerializer();
            kryo.addDefaultSerializer(List.of().getClass(), jdkImmutableListSerializer);
            kryo.addDefaultSerializer(List.of(Integer.valueOf(1)).getClass(), jdkImmutableListSerializer);
            kryo.addDefaultSerializer(List.of(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4)).getClass(), jdkImmutableListSerializer);
            kryo.addDefaultSerializer(List.of(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4)).subList(0, 2).getClass(), jdkImmutableListSerializer);
        }
    }
}

