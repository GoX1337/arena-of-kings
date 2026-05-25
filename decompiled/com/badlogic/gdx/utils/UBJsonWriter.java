/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.JsonValue;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class UBJsonWriter
implements Closeable {
    final DataOutputStream out;
    private JsonObject current;
    private boolean named;
    private final Array<JsonObject> stack = new Array();

    public UBJsonWriter(OutputStream outputStream) {
        if (!(outputStream instanceof DataOutputStream)) {
            outputStream = new DataOutputStream(outputStream);
        }
        this.out = (DataOutputStream)outputStream;
    }

    public UBJsonWriter object() {
        if (this.current != null && !this.current.array) {
            if (!this.named) {
                throw new IllegalStateException("Name must be set.");
            }
            this.named = false;
        }
        this.current = new JsonObject(false);
        this.stack.add(this.current);
        return this;
    }

    public UBJsonWriter object(String string) {
        this.name(string).object();
        return this;
    }

    public UBJsonWriter array() {
        if (this.current != null && !this.current.array) {
            if (!this.named) {
                throw new IllegalStateException("Name must be set.");
            }
            this.named = false;
        }
        this.current = new JsonObject(true);
        this.stack.add(this.current);
        return this;
    }

    public UBJsonWriter array(String string) {
        this.name(string).array();
        return this;
    }

    public UBJsonWriter name(String string) {
        if (this.current == null || this.current.array) {
            throw new IllegalStateException("Current item must be an object.");
        }
        byte[] byArray = string.getBytes("UTF-8");
        if (byArray.length <= 127) {
            this.out.writeByte(105);
            this.out.writeByte(byArray.length);
        } else if (byArray.length <= Short.MAX_VALUE) {
            this.out.writeByte(73);
            this.out.writeShort(byArray.length);
        } else {
            this.out.writeByte(108);
            this.out.writeInt(byArray.length);
        }
        this.out.write(byArray);
        this.named = true;
        return this;
    }

    public UBJsonWriter value(byte by2) {
        this.checkName();
        this.out.writeByte(105);
        this.out.writeByte(by2);
        return this;
    }

    public UBJsonWriter value(short s2) {
        this.checkName();
        this.out.writeByte(73);
        this.out.writeShort(s2);
        return this;
    }

    public UBJsonWriter value(int n2) {
        this.checkName();
        this.out.writeByte(108);
        this.out.writeInt(n2);
        return this;
    }

    public UBJsonWriter value(long l2) {
        this.checkName();
        this.out.writeByte(76);
        this.out.writeLong(l2);
        return this;
    }

    public UBJsonWriter value(float f2) {
        this.checkName();
        this.out.writeByte(100);
        this.out.writeFloat(f2);
        return this;
    }

    public UBJsonWriter value(double d2) {
        this.checkName();
        this.out.writeByte(68);
        this.out.writeDouble(d2);
        return this;
    }

    public UBJsonWriter value(boolean bl2) {
        this.checkName();
        this.out.writeByte(bl2 ? 84 : 70);
        return this;
    }

    public UBJsonWriter value(char c2) {
        this.checkName();
        this.out.writeByte(73);
        this.out.writeChar(c2);
        return this;
    }

    public UBJsonWriter value(String string) {
        this.checkName();
        byte[] byArray = string.getBytes("UTF-8");
        this.out.writeByte(83);
        if (byArray.length <= 127) {
            this.out.writeByte(105);
            this.out.writeByte(byArray.length);
        } else if (byArray.length <= Short.MAX_VALUE) {
            this.out.writeByte(73);
            this.out.writeShort(byArray.length);
        } else {
            this.out.writeByte(108);
            this.out.writeInt(byArray.length);
        }
        this.out.write(byArray);
        return this;
    }

    public UBJsonWriter value(byte[] byArray) {
        this.array();
        this.out.writeByte(36);
        this.out.writeByte(105);
        this.out.writeByte(35);
        this.value(byArray.length);
        int n2 = byArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            this.out.writeByte(byArray[i2]);
        }
        this.pop(true);
        return this;
    }

    public UBJsonWriter value(short[] sArray) {
        this.array();
        this.out.writeByte(36);
        this.out.writeByte(73);
        this.out.writeByte(35);
        this.value(sArray.length);
        int n2 = sArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            this.out.writeShort(sArray[i2]);
        }
        this.pop(true);
        return this;
    }

    public UBJsonWriter value(int[] nArray) {
        this.array();
        this.out.writeByte(36);
        this.out.writeByte(108);
        this.out.writeByte(35);
        this.value(nArray.length);
        int n2 = nArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            this.out.writeInt(nArray[i2]);
        }
        this.pop(true);
        return this;
    }

    public UBJsonWriter value(long[] lArray) {
        this.array();
        this.out.writeByte(36);
        this.out.writeByte(76);
        this.out.writeByte(35);
        this.value(lArray.length);
        int n2 = lArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            this.out.writeLong(lArray[i2]);
        }
        this.pop(true);
        return this;
    }

    public UBJsonWriter value(float[] fArray) {
        this.array();
        this.out.writeByte(36);
        this.out.writeByte(100);
        this.out.writeByte(35);
        this.value(fArray.length);
        int n2 = fArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            this.out.writeFloat(fArray[i2]);
        }
        this.pop(true);
        return this;
    }

    public UBJsonWriter value(double[] dArray) {
        this.array();
        this.out.writeByte(36);
        this.out.writeByte(68);
        this.out.writeByte(35);
        this.value(dArray.length);
        int n2 = dArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            this.out.writeDouble(dArray[i2]);
        }
        this.pop(true);
        return this;
    }

    public UBJsonWriter value(boolean[] blArray) {
        this.array();
        int n2 = blArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            this.out.writeByte(blArray[i2] ? 84 : 70);
        }
        this.pop();
        return this;
    }

    public UBJsonWriter value(char[] cArray) {
        this.array();
        this.out.writeByte(36);
        this.out.writeByte(67);
        this.out.writeByte(35);
        this.value(cArray.length);
        int n2 = cArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            this.out.writeChar(cArray[i2]);
        }
        this.pop(true);
        return this;
    }

    public UBJsonWriter value(String[] stringArray) {
        this.array();
        this.out.writeByte(36);
        this.out.writeByte(83);
        this.out.writeByte(35);
        this.value(stringArray.length);
        int n2 = stringArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            byte[] byArray = stringArray[i2].getBytes("UTF-8");
            if (byArray.length <= 127) {
                this.out.writeByte(105);
                this.out.writeByte(byArray.length);
            } else if (byArray.length <= Short.MAX_VALUE) {
                this.out.writeByte(73);
                this.out.writeShort(byArray.length);
            } else {
                this.out.writeByte(108);
                this.out.writeInt(byArray.length);
            }
            this.out.write(byArray);
        }
        this.pop(true);
        return this;
    }

    public UBJsonWriter value(JsonValue jsonValue) {
        if (jsonValue.isObject()) {
            if (jsonValue.name != null) {
                this.object(jsonValue.name);
            } else {
                this.object();
            }
            JsonValue jsonValue2 = jsonValue.child;
            while (jsonValue2 != null) {
                this.value(jsonValue2);
                jsonValue2 = jsonValue2.next;
            }
            this.pop();
        } else if (jsonValue.isArray()) {
            if (jsonValue.name != null) {
                this.array(jsonValue.name);
            } else {
                this.array();
            }
            JsonValue jsonValue3 = jsonValue.child;
            while (jsonValue3 != null) {
                this.value(jsonValue3);
                jsonValue3 = jsonValue3.next;
            }
            this.pop();
        } else if (jsonValue.isBoolean()) {
            if (jsonValue.name != null) {
                this.name(jsonValue.name);
            }
            this.value(jsonValue.asBoolean());
        } else if (jsonValue.isDouble()) {
            if (jsonValue.name != null) {
                this.name(jsonValue.name);
            }
            this.value(jsonValue.asDouble());
        } else if (jsonValue.isLong()) {
            if (jsonValue.name != null) {
                this.name(jsonValue.name);
            }
            this.value(jsonValue.asLong());
        } else if (jsonValue.isString()) {
            if (jsonValue.name != null) {
                this.name(jsonValue.name);
            }
            this.value(jsonValue.asString());
        } else if (jsonValue.isNull()) {
            if (jsonValue.name != null) {
                this.name(jsonValue.name);
            }
            this.value();
        } else {
            throw new IOException("Unhandled JsonValue type");
        }
        return this;
    }

    public UBJsonWriter value(Object object) {
        if (object == null) {
            return this.value();
        }
        if (object instanceof Number) {
            Number number = (Number)object;
            if (object instanceof Byte) {
                return this.value(number.byteValue());
            }
            if (object instanceof Short) {
                return this.value(number.shortValue());
            }
            if (object instanceof Integer) {
                return this.value(number.intValue());
            }
            if (object instanceof Long) {
                return this.value(number.longValue());
            }
            if (object instanceof Float) {
                return this.value(number.floatValue());
            }
            if (object instanceof Double) {
                return this.value(number.doubleValue());
            }
        } else {
            if (object instanceof Character) {
                return this.value(((Character)object).charValue());
            }
            if (object instanceof CharSequence) {
                return this.value(object.toString());
            }
            throw new IOException("Unknown object type.");
        }
        return this;
    }

    public UBJsonWriter value() {
        this.checkName();
        this.out.writeByte(90);
        return this;
    }

    public UBJsonWriter set(String string, byte by2) {
        return this.name(string).value(by2);
    }

    public UBJsonWriter set(String string, short s2) {
        return this.name(string).value(s2);
    }

    public UBJsonWriter set(String string, int n2) {
        return this.name(string).value(n2);
    }

    public UBJsonWriter set(String string, long l2) {
        return this.name(string).value(l2);
    }

    public UBJsonWriter set(String string, float f2) {
        return this.name(string).value(f2);
    }

    public UBJsonWriter set(String string, double d2) {
        return this.name(string).value(d2);
    }

    public UBJsonWriter set(String string, boolean bl2) {
        return this.name(string).value(bl2);
    }

    public UBJsonWriter set(String string, char c2) {
        return this.name(string).value(c2);
    }

    public UBJsonWriter set(String string, String string2) {
        return this.name(string).value(string2);
    }

    public UBJsonWriter set(String string, byte[] byArray) {
        return this.name(string).value(byArray);
    }

    public UBJsonWriter set(String string, short[] sArray) {
        return this.name(string).value(sArray);
    }

    public UBJsonWriter set(String string, int[] nArray) {
        return this.name(string).value(nArray);
    }

    public UBJsonWriter set(String string, long[] lArray) {
        return this.name(string).value(lArray);
    }

    public UBJsonWriter set(String string, float[] fArray) {
        return this.name(string).value(fArray);
    }

    public UBJsonWriter set(String string, double[] dArray) {
        return this.name(string).value(dArray);
    }

    public UBJsonWriter set(String string, boolean[] blArray) {
        return this.name(string).value(blArray);
    }

    public UBJsonWriter set(String string, char[] cArray) {
        return this.name(string).value(cArray);
    }

    public UBJsonWriter set(String string, String[] stringArray) {
        return this.name(string).value(stringArray);
    }

    public UBJsonWriter set(String string) {
        return this.name(string).value();
    }

    private void checkName() {
        if (this.current != null && !this.current.array) {
            if (!this.named) {
                throw new IllegalStateException("Name must be set.");
            }
            this.named = false;
        }
    }

    public UBJsonWriter pop() {
        return this.pop(false);
    }

    protected UBJsonWriter pop(boolean bl2) {
        if (this.named) {
            throw new IllegalStateException("Expected an object, array, or value since a name was set.");
        }
        if (bl2) {
            this.stack.pop();
        } else {
            this.stack.pop().close();
        }
        this.current = this.stack.size == 0 ? null : this.stack.peek();
        return this;
    }

    public void flush() {
        this.out.flush();
    }

    @Override
    public void close() {
        while (this.stack.size > 0) {
            this.pop();
        }
        this.out.close();
    }

    class JsonObject {
        final boolean array;

        JsonObject(boolean bl2) {
            this.array = bl2;
            UBJsonWriter.this.out.writeByte(bl2 ? 91 : 123);
        }

        void close() {
            UBJsonWriter.this.out.writeByte(this.array ? 93 : 125);
        }
    }
}

