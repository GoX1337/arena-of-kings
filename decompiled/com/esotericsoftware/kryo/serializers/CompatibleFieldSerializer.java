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
import com.esotericsoftware.kryo.util.ObjectMap;
import com.esotericsoftware.kryo.util.Util;
import com.esotericsoftware.minlog.Log;

public class CompatibleFieldSerializer<T>
extends FieldSerializer<T> {
    private static final int binarySearchThreshold = 32;
    private final CompatibleFieldSerializerConfig config;

    public CompatibleFieldSerializer(Kryo kryo, Class clazz) {
        this(kryo, clazz, new CompatibleFieldSerializerConfig());
    }

    public CompatibleFieldSerializer(Kryo kryo, Class clazz, CompatibleFieldSerializerConfig compatibleFieldSerializerConfig) {
        super(kryo, clazz, compatibleFieldSerializerConfig);
        this.config = compatibleFieldSerializerConfig;
    }

    @Override
    public void write(Kryo kryo, Output output, T t2) {
        Output output2;
        int n2;
        int n3;
        int n4 = this.pushTypeVariables();
        FieldSerializer.CachedField[] cachedFieldArray = this.cachedFields.fields;
        ObjectMap objectMap = kryo.getGraphContext();
        if (!objectMap.containsKey(this)) {
            if (Log.TRACE) {
                Log.trace("kryo", "Write fields for class: " + this.type.getName());
            }
            objectMap.put(this, null);
            output.writeVarInt(cachedFieldArray.length, true);
            n3 = cachedFieldArray.length;
            for (n2 = 0; n2 < n3; ++n2) {
                if (Log.TRACE) {
                    Log.trace("kryo", "Write field name: " + cachedFieldArray[n2].name + Util.pos(output.position()));
                }
                output.writeString(cachedFieldArray[n2].name);
            }
        }
        n2 = this.config.chunked;
        n3 = this.config.readUnknownFieldData;
        OutputChunked outputChunked = null;
        if (n2 != 0) {
            outputChunked = new OutputChunked(output, this.config.chunkSize);
            output2 = outputChunked;
        } else {
            output2 = output;
        }
        for (FieldSerializer.CachedField cachedField : cachedFieldArray) {
            if (Log.TRACE) {
                this.log("Write", cachedField, output.position());
            }
            if (n3 != 0) {
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
                    if (n2 == 0) continue;
                    outputChunked.endChunk();
                    continue;
                }
                cachedField.setCanBeNull(false);
                cachedField.setValueClass(clazz);
                cachedField.setReuseSerializer(false);
            }
            cachedField.write(output2, t2);
            if (n2 == 0) continue;
            outputChunked.endChunk();
        }
        this.popTypeVariables(n4);
    }

    @Override
    public T read(Kryo kryo, Input input, Class<? extends T> clazz) {
        Input input2;
        int n2 = this.pushTypeVariables();
        T t2 = this.create(kryo, input, clazz);
        kryo.reference(t2);
        FieldSerializer.CachedField[] cachedFieldArray = (FieldSerializer.CachedField[])kryo.getGraphContext().get(this);
        if (cachedFieldArray == null) {
            cachedFieldArray = this.readFields(kryo, input);
        }
        boolean bl2 = this.config.chunked;
        boolean bl3 = this.config.readUnknownFieldData;
        InputChunked inputChunked = null;
        if (bl2) {
            inputChunked = new InputChunked(input, this.config.chunkSize);
            input2 = inputChunked;
        } else {
            input2 = input;
        }
        for (FieldSerializer.CachedField cachedField : cachedFieldArray) {
            if (bl3) {
                String string;
                Registration registration;
                try {
                    registration = kryo.readClass(input2);
                }
                catch (KryoException kryoException) {
                    string = "Unable to read unknown data (unknown type). (" + this.getType().getName() + "#" + cachedField + ")";
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
                    block23: {
                        if (Log.TRACE) {
                            Log.trace("kryo", "Read unknown data, type: " + Util.className(clazz2) + Util.pos(input.position()));
                        }
                        try {
                            kryo.readObject(input2, clazz2);
                        }
                        catch (KryoException kryoException) {
                            String string2 = "Unable to read unknown data, type: " + Util.className(clazz2) + " (" + this.getType().getName() + "#" + cachedField + ")";
                            if (!bl2) {
                                throw new KryoException(string2, kryoException);
                            }
                            if (!Log.DEBUG) break block23;
                            Log.debug("kryo", string2, kryoException);
                        }
                    }
                    if (!bl2) continue;
                    inputChunked.nextChunk();
                    continue;
                }
                if (cachedField.valueClass != null && !Util.isAssignableTo(clazz2, cachedField.field.getType())) {
                    string = "Read type is incompatible with the field type: " + Util.className(clazz2) + " -> " + Util.className(cachedField.valueClass) + " (" + this.getType().getName() + "#" + cachedField + ")";
                    if (!bl2) {
                        throw new KryoException(string);
                    }
                    if (Log.DEBUG) {
                        Log.debug("kryo", string);
                    }
                    inputChunked.nextChunk();
                    continue;
                }
                cachedField.setCanBeNull(false);
                cachedField.setValueClass(clazz2);
                cachedField.setReuseSerializer(false);
            } else if (cachedField == null) {
                if (!bl2) {
                    throw new KryoException("Unknown field. (" + this.getType().getName() + ")");
                }
                if (Log.TRACE) {
                    Log.trace("kryo", "Skip unknown field.");
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
        this.popTypeVariables(n2);
        return t2;
    }

    private FieldSerializer.CachedField[] readFields(Kryo kryo, Input input) {
        if (Log.TRACE) {
            Log.trace("kryo", "Read fields for class: " + this.type.getName());
        }
        int n2 = input.readVarInt(true);
        String[] stringArray = new String[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            stringArray[i2] = input.readString();
            if (!Log.TRACE) continue;
            Log.trace("kryo", "Read field name: " + stringArray[i2]);
        }
        FieldSerializer.CachedField[] cachedFieldArray = new FieldSerializer.CachedField[n2];
        FieldSerializer.CachedField[] cachedFieldArray2 = this.cachedFields.fields;
        if (n2 < 32) {
            block1: for (int i3 = 0; i3 < n2; ++i3) {
                String string = stringArray[i3];
                int n3 = cachedFieldArray2.length;
                for (int i4 = 0; i4 < n3; ++i4) {
                    if (!cachedFieldArray2[i4].name.equals(string)) continue;
                    cachedFieldArray[i3] = cachedFieldArray2[i4];
                    continue block1;
                }
                if (!Log.TRACE) continue;
                Log.trace("kryo", "Unknown field will be skipped: " + string);
            }
        } else {
            int n4 = cachedFieldArray2.length - 1;
            block3: for (int i5 = 0; i5 < n2; ++i5) {
                String string = stringArray[i5];
                int n5 = 0;
                int n6 = n4;
                while (n5 <= n6) {
                    int n7 = n5 + n6 >>> 1;
                    int n8 = string.compareTo(cachedFieldArray2[n7].name);
                    if (n8 < 0) {
                        n6 = n7 - 1;
                        continue;
                    }
                    if (n8 > 0) {
                        n5 = n7 + 1;
                        continue;
                    }
                    cachedFieldArray[i5] = cachedFieldArray2[n7];
                    continue block3;
                }
                if (!Log.TRACE) continue;
                Log.trace("kryo", "Unknown field will be skipped: " + string);
            }
        }
        kryo.getGraphContext().put(this, cachedFieldArray);
        return cachedFieldArray;
    }

    public CompatibleFieldSerializerConfig getCompatibleFieldSerializerConfig() {
        return this.config;
    }

    public static class CompatibleFieldSerializerConfig
    extends FieldSerializer.FieldSerializerConfig {
        boolean readUnknownFieldData = true;
        boolean chunked;
        int chunkSize = 1024;

        @Override
        public CompatibleFieldSerializerConfig clone() {
            return (CompatibleFieldSerializerConfig)super.clone();
        }

        public void setReadUnknownFieldData(boolean bl2) {
            this.readUnknownFieldData = bl2;
        }

        public boolean getReadUnknownTagData() {
            return this.readUnknownFieldData;
        }

        public void setChunkedEncoding(boolean bl2) {
            this.chunked = bl2;
            if (Log.TRACE) {
                Log.trace("kryo", "CompatibleFieldSerializerConfig setChunked: " + bl2);
            }
        }

        public boolean getChunkedEncoding() {
            return this.chunked;
        }

        public void setChunkSize(int n2) {
            this.chunkSize = n2;
            if (Log.TRACE) {
                Log.trace("kryo", "CompatibleFieldSerializerConfig setChunkSize: " + n2);
            }
        }

        public int getChunkSize() {
            return this.chunkSize;
        }
    }
}

