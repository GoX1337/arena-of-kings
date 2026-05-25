/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.Registration;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.InputChunked;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.io.OutputChunked;
import com.esotericsoftware.kryo.serializers.FieldSerializer;
import com.esotericsoftware.kryo.util.IntMap;
import com.esotericsoftware.kryo.util.Util;
import com.esotericsoftware.minlog.Log;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class TaggedFieldSerializer<T>
extends FieldSerializer<T> {
    private FieldSerializer.CachedField[] writeTags;
    private IntMap<FieldSerializer.CachedField> readTags;
    private final TaggedFieldSerializerConfig config;

    public TaggedFieldSerializer(Kryo kryo, Class clazz) {
        this(kryo, clazz, new TaggedFieldSerializerConfig());
    }

    public TaggedFieldSerializer(Kryo kryo, Class clazz, TaggedFieldSerializerConfig taggedFieldSerializerConfig) {
        super(kryo, clazz, taggedFieldSerializerConfig);
        this.config = taggedFieldSerializerConfig;
        this.setAcceptsNull(true);
    }

    @Override
    protected void initializeCachedFields() {
        FieldSerializer.CachedField[] cachedFieldArray = this.cachedFields.fields;
        int n2 = cachedFieldArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            Field field = cachedFieldArray[i2].field;
            if (field.getAnnotation(Tag.class) != null) continue;
            if (Log.TRACE) {
                Log.trace("kryo", "Ignoring field without tag: " + cachedFieldArray[i2]);
            }
            super.removeField(cachedFieldArray[i2]);
        }
        cachedFieldArray = this.cachedFields.fields;
        ArrayList<FieldSerializer.CachedField> arrayList = new ArrayList<FieldSerializer.CachedField>(cachedFieldArray.length);
        this.readTags = new IntMap((int)((float)cachedFieldArray.length / 0.8f));
        for (FieldSerializer.CachedField cachedField : cachedFieldArray) {
            Field field = cachedField.field;
            int n3 = field.getAnnotation(Tag.class).value();
            if (this.readTags.containsKey(n3)) {
                throw new KryoException(String.format("Duplicate tag %d on fields: %s and %s", n3, field, arrayList.get(n3)));
            }
            this.readTags.put(n3, cachedField);
            if (field.getAnnotation(Deprecated.class) == null) {
                arrayList.add(cachedField);
            }
            cachedField.tag = n3;
        }
        this.writeTags = arrayList.toArray(new FieldSerializer.CachedField[arrayList.size()]);
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
        Output output2;
        if (t2 == null) {
            output.writeByte((byte)0);
            return;
        }
        int n2 = this.pushTypeVariables();
        FieldSerializer.CachedField[] cachedFieldArray = this.writeTags;
        output.writeVarInt(cachedFieldArray.length + 1, true);
        this.writeHeader(kryo, output, t2);
        boolean bl2 = this.config.chunked;
        boolean bl3 = this.config.readUnknownTagData;
        OutputChunked outputChunked = null;
        if (bl2) {
            outputChunked = new OutputChunked(output, this.config.chunkSize);
            output2 = outputChunked;
        } else {
            output2 = output;
        }
        for (FieldSerializer.CachedField cachedField : cachedFieldArray) {
            if (Log.TRACE) {
                this.log("Write", cachedField, output.position());
            }
            output.writeVarInt(cachedField.tag, true);
            if (bl3) {
                Class<?> clazz = null;
                try {
                    Object object;
                    if (t2 != null && (object = cachedField.field.get(t2)) != null) {
                        clazz = object.getClass();
                    }
                }
                catch (IllegalAccessException illegalAccessException) {
                    // empty catch block
                }
                kryo.writeClass(output2, clazz);
                if (clazz == null) {
                    if (!bl2) continue;
                    outputChunked.endChunk();
                    continue;
                }
                cachedField.setCanBeNull(false);
                cachedField.setValueClass(clazz);
                cachedField.setReuseSerializer(false);
            }
            cachedField.write(output2, t2);
            if (!bl2) continue;
            outputChunked.endChunk();
        }
        this.popTypeVariables(n2);
    }

    protected void writeHeader(Kryo kryo, Output output, T t2) {
    }

    @Override
    public T read(Kryo kryo, Input input, Class<? extends T> clazz) {
        Input input2;
        int n2 = input.readVarInt(true);
        if (n2 == 0) {
            return null;
        }
        --n2;
        int n3 = this.pushTypeVariables();
        T t2 = this.create(kryo, input, clazz);
        kryo.reference(t2);
        boolean bl2 = this.config.chunked;
        boolean bl3 = this.config.readUnknownTagData;
        InputChunked inputChunked = null;
        if (bl2) {
            inputChunked = new InputChunked(input, this.config.chunkSize);
            input2 = inputChunked;
        } else {
            input2 = input;
        }
        IntMap<FieldSerializer.CachedField> intMap = this.readTags;
        for (int i2 = 0; i2 < n2; ++i2) {
            int n4 = input.readVarInt(true);
            FieldSerializer.CachedField cachedField = intMap.get(n4);
            if (bl3) {
                Registration registration;
                try {
                    registration = kryo.readClass(input2);
                }
                catch (KryoException kryoException) {
                    String string = "Unable to read unknown tag " + n4 + " data (unknown type). (" + this.getType().getName() + "#" + cachedField + ")";
                    if (!bl2) {
                        throw new KryoException(string, kryoException);
                    }
                    if (Log.DEBUG) {
                        Log.debug("kryo", string, kryoException);
                    }
                    inputChunked.nextChunk();
                    continue;
                }
                if (registration == null) {
                    if (!bl2) continue;
                    inputChunked.nextChunk();
                    continue;
                }
                Class clazz2 = registration.getType();
                if (cachedField == null) {
                    block20: {
                        if (Log.TRACE) {
                            Log.trace("kryo", "Read unknown tag " + n4 + " data, type: " + Util.className(clazz2));
                        }
                        try {
                            kryo.readObject(input2, clazz2);
                        }
                        catch (KryoException kryoException) {
                            String string = "Unable to read unknown tag " + n4 + " data, type: " + Util.className(clazz2) + " (" + this.getType().getName() + "#" + cachedField + ")";
                            if (!bl2) {
                                throw new KryoException(string, kryoException);
                            }
                            if (!Log.DEBUG) break block20;
                            Log.debug("kryo", string, kryoException);
                        }
                    }
                    if (!bl2) continue;
                    inputChunked.nextChunk();
                    continue;
                }
                cachedField.setCanBeNull(false);
                cachedField.setValueClass(clazz2);
                cachedField.setReuseSerializer(false);
            } else if (cachedField == null) {
                if (!bl2) {
                    throw new KryoException("Unknown field tag: " + n4 + " (" + this.getType().getName() + ")");
                }
                if (Log.TRACE) {
                    Log.trace("kryo", "Skip unknown field tag: " + n4);
                }
                inputChunked.nextChunk();
                continue;
            }
            if (Log.TRACE) {
                this.log("Read", cachedField, input.position());
            }
            cachedField.read(input2, t2);
            if (!bl2) continue;
            inputChunked.nextChunk();
        }
        this.popTypeVariables(n3);
        return t2;
    }

    public TaggedFieldSerializerConfig getTaggedFieldSerializerConfig() {
        return this.config;
    }

    public static class TaggedFieldSerializerConfig
    extends FieldSerializer.FieldSerializerConfig {
        boolean readUnknownTagData;
        boolean chunked;
        int chunkSize = 1024;

        @Override
        public TaggedFieldSerializerConfig clone() {
            return (TaggedFieldSerializerConfig)super.clone();
        }

        public void setReadUnknownTagData(boolean bl2) {
            this.readUnknownTagData = bl2;
        }

        public boolean getReadUnknownTagData() {
            return this.readUnknownTagData;
        }

        public void setChunkedEncoding(boolean bl2) {
            this.chunked = bl2;
            if (Log.TRACE) {
                Log.trace("kryo", "TaggedFieldSerializerConfig setChunked: " + bl2);
            }
        }

        public boolean getChunkedEncoding() {
            return this.chunked;
        }

        public void setChunkSize(int n2) {
            this.chunkSize = n2;
            if (Log.TRACE) {
                Log.trace("kryo", "TaggedFieldSerializerConfig setChunkSize: " + n2);
            }
        }

        public int getChunkSize() {
            return this.chunkSize;
        }
    }

    @Retention(value=RetentionPolicy.RUNTIME)
    @Target(value={ElementType.FIELD})
    public static @interface Tag {
        public int value();
    }
}

