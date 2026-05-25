/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import java.lang.reflect.Array;

public class DefaultArraySerializers {

    public static class ObjectArraySerializer
    extends Serializer<Object[]> {
        private boolean elementsAreSameType;
        private boolean elementsCanBeNull = true;
        private final Class type;

        public ObjectArraySerializer(Kryo kryo, Class clazz) {
            boolean bl2;
            this.setAcceptsNull(true);
            this.type = clazz;
            Class<?> clazz2 = clazz.getComponentType();
            boolean bl3 = bl2 = 0 != (clazz2.getModifiers() & 0x10);
            if (bl2) {
                this.setElementsAreSameType(true);
            }
        }

        @Override
        public void write(Kryo kryo, Output output, Object[] objectArray) {
            if (objectArray == null) {
                output.writeByte((byte)0);
                return;
            }
            int n2 = objectArray.length;
            output.writeVarInt(n2 + 1, true);
            Class<?> clazz = objectArray.getClass().getComponentType();
            if (this.elementsAreSameType || kryo.isFinal(clazz)) {
                Serializer serializer = kryo.getSerializer(clazz);
                if (this.elementsCanBeNull) {
                    for (int i2 = 0; i2 < n2; ++i2) {
                        kryo.writeObjectOrNull(output, objectArray[i2], serializer);
                    }
                } else {
                    for (int i3 = 0; i3 < n2; ++i3) {
                        kryo.writeObject(output, objectArray[i3], serializer);
                    }
                }
            } else {
                for (int i4 = 0; i4 < n2; ++i4) {
                    kryo.writeClassAndObject(output, objectArray[i4]);
                }
            }
        }

        @Override
        public Object[] read(Kryo kryo, Input input, Class clazz) {
            int n2 = input.readVarInt(true);
            if (n2 == 0) {
                return null;
            }
            Object[] objectArray = (Object[])Array.newInstance(clazz.getComponentType(), --n2);
            kryo.reference(objectArray);
            Class<?> clazz2 = clazz.getComponentType();
            if (this.elementsAreSameType || kryo.isFinal(clazz2)) {
                Serializer serializer = kryo.getSerializer(clazz2);
                if (this.elementsCanBeNull) {
                    for (int i2 = 0; i2 < n2; ++i2) {
                        objectArray[i2] = kryo.readObjectOrNull(input, clazz2, serializer);
                    }
                } else {
                    for (int i3 = 0; i3 < n2; ++i3) {
                        objectArray[i3] = kryo.readObject(input, clazz2, serializer);
                    }
                }
            } else {
                for (int i4 = 0; i4 < n2; ++i4) {
                    objectArray[i4] = kryo.readClassAndObject(input);
                }
            }
            return objectArray;
        }

        @Override
        public Object[] copy(Kryo kryo, Object[] objectArray) {
            int n2 = objectArray.length;
            Object[] objectArray2 = (Object[])Array.newInstance(objectArray.getClass().getComponentType(), n2);
            kryo.reference(objectArray2);
            for (int i2 = 0; i2 < n2; ++i2) {
                objectArray2[i2] = kryo.copy(objectArray[i2]);
            }
            return objectArray2;
        }

        public void setElementsCanBeNull(boolean bl2) {
            this.elementsCanBeNull = bl2;
        }

        public void setElementsAreSameType(boolean bl2) {
            this.elementsAreSameType = bl2;
        }
    }

    public static class StringArraySerializer
    extends Serializer<String[]> {
        public StringArraySerializer() {
            this.setAcceptsNull(true);
        }

        @Override
        public void write(Kryo kryo, Output output, String[] stringArray) {
            if (stringArray == null) {
                output.writeByte((byte)0);
                return;
            }
            output.writeVarInt(stringArray.length + 1, true);
            if (kryo.getReferences() && kryo.getReferenceResolver().useReferences(String.class)) {
                Serializer serializer = kryo.getSerializer(String.class);
                int n2 = stringArray.length;
                for (int i2 = 0; i2 < n2; ++i2) {
                    kryo.writeObjectOrNull(output, (Object)stringArray[i2], serializer);
                }
            } else {
                int n3 = stringArray.length;
                for (int i3 = 0; i3 < n3; ++i3) {
                    output.writeString(stringArray[i3]);
                }
            }
        }

        @Override
        public String[] read(Kryo kryo, Input input, Class clazz) {
            int n2 = input.readVarInt(true);
            if (n2 == 0) {
                return null;
            }
            String[] stringArray = new String[--n2];
            if (kryo.getReferences() && kryo.getReferenceResolver().useReferences(String.class)) {
                Serializer serializer = kryo.getSerializer(String.class);
                for (int i2 = 0; i2 < n2; ++i2) {
                    stringArray[i2] = kryo.readObjectOrNull(input, String.class, serializer);
                }
            } else {
                for (int i3 = 0; i3 < n2; ++i3) {
                    stringArray[i3] = input.readString();
                }
            }
            return stringArray;
        }

        @Override
        public String[] copy(Kryo kryo, String[] stringArray) {
            String[] stringArray2 = new String[stringArray.length];
            System.arraycopy(stringArray, 0, stringArray2, 0, stringArray2.length);
            return stringArray2;
        }
    }

    public static class BooleanArraySerializer
    extends Serializer<boolean[]> {
        public BooleanArraySerializer() {
            this.setAcceptsNull(true);
        }

        @Override
        public void write(Kryo kryo, Output output, boolean[] blArray) {
            if (blArray == null) {
                output.writeByte((byte)0);
                return;
            }
            output.writeVarInt(blArray.length + 1, true);
            int n2 = blArray.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                output.writeBoolean(blArray[i2]);
            }
        }

        @Override
        public boolean[] read(Kryo kryo, Input input, Class clazz) {
            int n2 = input.readVarInt(true);
            if (n2 == 0) {
                return null;
            }
            boolean[] blArray = new boolean[--n2];
            for (int i2 = 0; i2 < n2; ++i2) {
                blArray[i2] = input.readBoolean();
            }
            return blArray;
        }

        @Override
        public boolean[] copy(Kryo kryo, boolean[] blArray) {
            boolean[] blArray2 = new boolean[blArray.length];
            System.arraycopy(blArray, 0, blArray2, 0, blArray2.length);
            return blArray2;
        }
    }

    public static class DoubleArraySerializer
    extends Serializer<double[]> {
        public DoubleArraySerializer() {
            this.setAcceptsNull(true);
        }

        @Override
        public void write(Kryo kryo, Output output, double[] dArray) {
            if (dArray == null) {
                output.writeByte((byte)0);
                return;
            }
            output.writeVarInt(dArray.length + 1, true);
            output.writeDoubles(dArray, 0, dArray.length);
        }

        @Override
        public double[] read(Kryo kryo, Input input, Class clazz) {
            int n2 = input.readVarInt(true);
            if (n2 == 0) {
                return null;
            }
            return input.readDoubles(n2 - 1);
        }

        @Override
        public double[] copy(Kryo kryo, double[] dArray) {
            double[] dArray2 = new double[dArray.length];
            System.arraycopy(dArray, 0, dArray2, 0, dArray2.length);
            return dArray2;
        }
    }

    public static class CharArraySerializer
    extends Serializer<char[]> {
        public CharArraySerializer() {
            this.setAcceptsNull(true);
        }

        @Override
        public void write(Kryo kryo, Output output, char[] cArray) {
            if (cArray == null) {
                output.writeByte((byte)0);
                return;
            }
            output.writeVarInt(cArray.length + 1, true);
            output.writeChars(cArray, 0, cArray.length);
        }

        @Override
        public char[] read(Kryo kryo, Input input, Class clazz) {
            int n2 = input.readVarInt(true);
            if (n2 == 0) {
                return null;
            }
            return input.readChars(n2 - 1);
        }

        @Override
        public char[] copy(Kryo kryo, char[] cArray) {
            char[] cArray2 = new char[cArray.length];
            System.arraycopy(cArray, 0, cArray2, 0, cArray2.length);
            return cArray2;
        }
    }

    public static class ShortArraySerializer
    extends Serializer<short[]> {
        public ShortArraySerializer() {
            this.setAcceptsNull(true);
        }

        @Override
        public void write(Kryo kryo, Output output, short[] sArray) {
            if (sArray == null) {
                output.writeByte((byte)0);
                return;
            }
            output.writeVarInt(sArray.length + 1, true);
            output.writeShorts(sArray, 0, sArray.length);
        }

        @Override
        public short[] read(Kryo kryo, Input input, Class clazz) {
            int n2 = input.readVarInt(true);
            if (n2 == 0) {
                return null;
            }
            return input.readShorts(n2 - 1);
        }

        @Override
        public short[] copy(Kryo kryo, short[] sArray) {
            short[] sArray2 = new short[sArray.length];
            System.arraycopy(sArray, 0, sArray2, 0, sArray2.length);
            return sArray2;
        }
    }

    public static class LongArraySerializer
    extends Serializer<long[]> {
        public LongArraySerializer() {
            this.setAcceptsNull(true);
        }

        @Override
        public void write(Kryo kryo, Output output, long[] lArray) {
            if (lArray == null) {
                output.writeByte((byte)0);
                return;
            }
            output.writeVarInt(lArray.length + 1, true);
            output.writeLongs(lArray, 0, lArray.length, false);
        }

        @Override
        public long[] read(Kryo kryo, Input input, Class clazz) {
            int n2 = input.readVarInt(true);
            if (n2 == 0) {
                return null;
            }
            return input.readLongs(n2 - 1, false);
        }

        @Override
        public long[] copy(Kryo kryo, long[] lArray) {
            long[] lArray2 = new long[lArray.length];
            System.arraycopy(lArray, 0, lArray2, 0, lArray2.length);
            return lArray2;
        }
    }

    public static class FloatArraySerializer
    extends Serializer<float[]> {
        public FloatArraySerializer() {
            this.setAcceptsNull(true);
        }

        @Override
        public void write(Kryo kryo, Output output, float[] fArray) {
            if (fArray == null) {
                output.writeByte((byte)0);
                return;
            }
            output.writeVarInt(fArray.length + 1, true);
            output.writeFloats(fArray, 0, fArray.length);
        }

        @Override
        public float[] read(Kryo kryo, Input input, Class clazz) {
            int n2 = input.readVarInt(true);
            if (n2 == 0) {
                return null;
            }
            return input.readFloats(n2 - 1);
        }

        @Override
        public float[] copy(Kryo kryo, float[] fArray) {
            float[] fArray2 = new float[fArray.length];
            System.arraycopy(fArray, 0, fArray2, 0, fArray2.length);
            return fArray2;
        }
    }

    public static class IntArraySerializer
    extends Serializer<int[]> {
        public IntArraySerializer() {
            this.setAcceptsNull(true);
        }

        @Override
        public void write(Kryo kryo, Output output, int[] nArray) {
            if (nArray == null) {
                output.writeByte((byte)0);
                return;
            }
            output.writeVarInt(nArray.length + 1, true);
            output.writeInts(nArray, 0, nArray.length, false);
        }

        @Override
        public int[] read(Kryo kryo, Input input, Class clazz) {
            int n2 = input.readVarInt(true);
            if (n2 == 0) {
                return null;
            }
            return input.readInts(n2 - 1, false);
        }

        @Override
        public int[] copy(Kryo kryo, int[] nArray) {
            int[] nArray2 = new int[nArray.length];
            System.arraycopy(nArray, 0, nArray2, 0, nArray2.length);
            return nArray2;
        }
    }

    public static class ByteArraySerializer
    extends Serializer<byte[]> {
        public ByteArraySerializer() {
            this.setAcceptsNull(true);
        }

        @Override
        public void write(Kryo kryo, Output output, byte[] byArray) {
            if (byArray == null) {
                output.writeByte((byte)0);
                return;
            }
            output.writeVarInt(byArray.length + 1, true);
            output.writeBytes(byArray);
        }

        @Override
        public byte[] read(Kryo kryo, Input input, Class clazz) {
            int n2 = input.readVarInt(true);
            if (n2 == 0) {
                return null;
            }
            return input.readBytes(n2 - 1);
        }

        @Override
        public byte[] copy(Kryo kryo, byte[] byArray) {
            byte[] byArray2 = new byte[byArray.length];
            System.arraycopy(byArray, 0, byArray2, 0, byArray2.length);
            return byArray2;
        }
    }
}

