/*
 * Decompiled with CFR 0.152.
 */
package org.objenesis.instantiator.basic;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.io.Serializable;
import org.objenesis.ObjenesisException;
import org.objenesis.instantiator.ObjectInstantiator;
import org.objenesis.instantiator.annotations.Instantiator;
import org.objenesis.instantiator.annotations.Typology;

@Instantiator(value=Typology.SERIALIZATION)
public class ObjectInputStreamInstantiator<T>
implements ObjectInstantiator<T> {
    private final ObjectInputStream inputStream;

    public ObjectInputStreamInstantiator(Class<T> clazz) {
        if (Serializable.class.isAssignableFrom(clazz)) {
            try {
                this.inputStream = new ObjectInputStream(new a(clazz));
            }
            catch (IOException iOException) {
                throw new Error("IOException: " + iOException.getMessage());
            }
        } else {
            throw new ObjenesisException(new NotSerializableException(clazz + " not serializable"));
        }
    }

    @Override
    public T newInstance() {
        try {
            return (T)this.inputStream.readObject();
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new Error("ClassNotFoundException: " + classNotFoundException.getMessage());
        }
        catch (Exception exception) {
            throw new ObjenesisException(exception);
        }
    }

    static class a
    extends InputStream {
        private int var_int_a = 0;
        private byte[] var_byte_arr_a = var_byte_arr_b;
        private int var_int_b = 0;
        private static final int[] var_int_arr_a;
        private final byte[][] var_byte_arr_arr_a;
        private static byte[] var_byte_arr_b;
        private static byte[] c;

        private static void a() {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                dataOutputStream.writeShort(-21267);
                dataOutputStream.writeShort(5);
                var_byte_arr_b = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream = new ByteArrayOutputStream();
                dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                dataOutputStream.writeByte(115);
                dataOutputStream.writeByte(113);
                dataOutputStream.writeInt(0x7E0000);
                c = byteArrayOutputStream.toByteArray();
            }
            catch (IOException iOException) {
                throw new Error("IOException: " + iOException.getMessage());
            }
        }

        public a(Class<?> clazz) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            try {
                dataOutputStream.writeByte(115);
                dataOutputStream.writeByte(114);
                dataOutputStream.writeUTF(clazz.getName());
                dataOutputStream.writeLong(ObjectStreamClass.lookup(clazz).getSerialVersionUID());
                dataOutputStream.writeByte(2);
                dataOutputStream.writeShort(0);
                dataOutputStream.writeByte(120);
                dataOutputStream.writeByte(112);
            }
            catch (IOException iOException) {
                throw new Error("IOException: " + iOException.getMessage());
            }
            byte[] byArray = byteArrayOutputStream.toByteArray();
            this.var_byte_arr_arr_a = new byte[][]{var_byte_arr_b, byArray, c};
        }

        private void b() {
            this.var_int_a = 0;
            this.var_int_b = var_int_arr_a[this.var_int_b];
            this.var_byte_arr_a = this.var_byte_arr_arr_a[this.var_int_b];
        }

        @Override
        public int read() {
            byte by2 = this.var_byte_arr_a[this.var_int_a++];
            if (this.var_int_a >= this.var_byte_arr_a.length) {
                this.b();
            }
            return by2;
        }

        @Override
        public int available() {
            return Integer.MAX_VALUE;
        }

        @Override
        public int read(byte[] byArray, int n2, int n3) {
            int n4;
            int n5 = this.var_byte_arr_a.length - this.var_int_a;
            for (n4 = n3; n5 <= n4; n4 -= n5) {
                System.arraycopy(this.var_byte_arr_a, this.var_int_a, byArray, n2, n5);
                n2 += n5;
                this.b();
                n5 = this.var_byte_arr_a.length - this.var_int_a;
            }
            if (n4 > 0) {
                System.arraycopy(this.var_byte_arr_a, this.var_int_a, byArray, n2, n4);
                this.var_int_a += n4;
            }
            return n3;
        }

        static {
            var_int_arr_a = new int[]{1, 2, 2};
            org.objenesis.instantiator.basic.ObjectInputStreamInstantiator$a.a();
        }
    }
}

