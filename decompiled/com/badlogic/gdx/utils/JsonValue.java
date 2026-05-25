/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils;

import com.badlogic.gdx.utils.JsonWriter;
import com.badlogic.gdx.utils.Null;
import com.badlogic.gdx.utils.SerializationException;
import com.badlogic.gdx.utils.StringBuilder;
import java.io.Writer;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class JsonValue
implements Iterable<JsonValue> {
    private ValueType type;
    private String stringValue;
    private double doubleValue;
    private long longValue;
    public String name;
    public JsonValue child;
    public JsonValue parent;
    public JsonValue next;
    public JsonValue prev;
    public int size;

    public JsonValue(ValueType valueType) {
        this.type = valueType;
    }

    public JsonValue(@Null String string) {
        this.set(string);
    }

    public JsonValue(double d2) {
        this.set(d2, null);
    }

    public JsonValue(long l2) {
        this.set(l2, (String)null);
    }

    public JsonValue(double d2, String string) {
        this.set(d2, string);
    }

    public JsonValue(long l2, String string) {
        this.set(l2, string);
    }

    public JsonValue(boolean bl2) {
        this.set(bl2);
    }

    @Null
    public JsonValue get(int n2) {
        JsonValue jsonValue = this.child;
        while (jsonValue != null && n2 > 0) {
            --n2;
            jsonValue = jsonValue.next;
        }
        return jsonValue;
    }

    @Null
    public JsonValue get(String string) {
        JsonValue jsonValue = this.child;
        while (!(jsonValue == null || jsonValue.name != null && jsonValue.name.equalsIgnoreCase(string))) {
            jsonValue = jsonValue.next;
        }
        return jsonValue;
    }

    public boolean has(String string) {
        return this.get(string) != null;
    }

    public JsonIterator iterator(String string) {
        JsonValue jsonValue = this.get(string);
        if (jsonValue == null) {
            JsonIterator jsonIterator = new JsonIterator();
            jsonIterator.entry = null;
            return jsonIterator;
        }
        return jsonValue.iterator();
    }

    public JsonValue require(int n2) {
        JsonValue jsonValue = this.get(n2);
        if (jsonValue == null) {
            throw new IllegalArgumentException("Child not found with index: " + n2);
        }
        return jsonValue;
    }

    public JsonValue require(String string) {
        JsonValue jsonValue = this.get(string);
        if (jsonValue == null) {
            throw new IllegalArgumentException("Child not found with name: " + string);
        }
        return jsonValue;
    }

    @Null
    public JsonValue remove(int n2) {
        JsonValue jsonValue = this.get(n2);
        if (jsonValue == null) {
            return null;
        }
        if (jsonValue.prev == null) {
            this.child = jsonValue.next;
            if (this.child != null) {
                this.child.prev = null;
            }
        } else {
            jsonValue.prev.next = jsonValue.next;
            if (jsonValue.next != null) {
                jsonValue.next.prev = jsonValue.prev;
            }
        }
        --this.size;
        return jsonValue;
    }

    @Null
    public JsonValue remove(String string) {
        JsonValue jsonValue = this.get(string);
        if (jsonValue == null) {
            return null;
        }
        if (jsonValue.prev == null) {
            this.child = jsonValue.next;
            if (this.child != null) {
                this.child.prev = null;
            }
        } else {
            jsonValue.prev.next = jsonValue.next;
            if (jsonValue.next != null) {
                jsonValue.next.prev = jsonValue.prev;
            }
        }
        --this.size;
        return jsonValue;
    }

    public void remove() {
        if (this.parent == null) {
            throw new IllegalStateException();
        }
        if (this.prev == null) {
            this.parent.child = this.next;
            if (this.parent.child != null) {
                this.parent.child.prev = null;
            }
        } else {
            this.prev.next = this.next;
            if (this.next != null) {
                this.next.prev = this.prev;
            }
        }
        --this.parent.size;
    }

    public boolean notEmpty() {
        return this.size > 0;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    @Deprecated
    public int size() {
        return this.size;
    }

    @Null
    public String asString() {
        switch (this.type) {
            case stringValue: {
                return this.stringValue;
            }
            case doubleValue: {
                return this.stringValue != null ? this.stringValue : Double.toString(this.doubleValue);
            }
            case longValue: {
                return this.stringValue != null ? this.stringValue : Long.toString(this.longValue);
            }
            case booleanValue: {
                return this.longValue != 0L ? "true" : "false";
            }
            case nullValue: {
                return null;
            }
        }
        throw new IllegalStateException("Value cannot be converted to string: " + (Object)((Object)this.type));
    }

    public float asFloat() {
        switch (this.type) {
            case stringValue: {
                return Float.parseFloat(this.stringValue);
            }
            case doubleValue: {
                return (float)this.doubleValue;
            }
            case longValue: {
                return this.longValue;
            }
            case booleanValue: {
                return this.longValue != 0L ? 1.0f : 0.0f;
            }
        }
        throw new IllegalStateException("Value cannot be converted to float: " + (Object)((Object)this.type));
    }

    public double asDouble() {
        switch (this.type) {
            case stringValue: {
                return Double.parseDouble(this.stringValue);
            }
            case doubleValue: {
                return this.doubleValue;
            }
            case longValue: {
                return this.longValue;
            }
            case booleanValue: {
                return this.longValue != 0L ? 1.0 : 0.0;
            }
        }
        throw new IllegalStateException("Value cannot be converted to double: " + (Object)((Object)this.type));
    }

    public long asLong() {
        switch (this.type) {
            case stringValue: {
                return Long.parseLong(this.stringValue);
            }
            case doubleValue: {
                return (long)this.doubleValue;
            }
            case longValue: {
                return this.longValue;
            }
            case booleanValue: {
                return this.longValue != 0L ? 1L : 0L;
            }
        }
        throw new IllegalStateException("Value cannot be converted to long: " + (Object)((Object)this.type));
    }

    public int asInt() {
        switch (this.type) {
            case stringValue: {
                return Integer.parseInt(this.stringValue);
            }
            case doubleValue: {
                return (int)this.doubleValue;
            }
            case longValue: {
                return (int)this.longValue;
            }
            case booleanValue: {
                return this.longValue != 0L ? 1 : 0;
            }
        }
        throw new IllegalStateException("Value cannot be converted to int: " + (Object)((Object)this.type));
    }

    public boolean asBoolean() {
        switch (this.type) {
            case stringValue: {
                return this.stringValue.equalsIgnoreCase("true");
            }
            case doubleValue: {
                return this.doubleValue != 0.0;
            }
            case longValue: {
                return this.longValue != 0L;
            }
            case booleanValue: {
                return this.longValue != 0L;
            }
        }
        throw new IllegalStateException("Value cannot be converted to boolean: " + (Object)((Object)this.type));
    }

    public byte asByte() {
        switch (this.type) {
            case stringValue: {
                return Byte.parseByte(this.stringValue);
            }
            case doubleValue: {
                return (byte)this.doubleValue;
            }
            case longValue: {
                return (byte)this.longValue;
            }
            case booleanValue: {
                return this.longValue != 0L ? (byte)1 : 0;
            }
        }
        throw new IllegalStateException("Value cannot be converted to byte: " + (Object)((Object)this.type));
    }

    public short asShort() {
        switch (this.type) {
            case stringValue: {
                return Short.parseShort(this.stringValue);
            }
            case doubleValue: {
                return (short)this.doubleValue;
            }
            case longValue: {
                return (short)this.longValue;
            }
            case booleanValue: {
                return this.longValue != 0L ? (short)1 : 0;
            }
        }
        throw new IllegalStateException("Value cannot be converted to short: " + (Object)((Object)this.type));
    }

    public char asChar() {
        switch (this.type) {
            case stringValue: {
                return this.stringValue.length() == 0 ? (char)'\u0000' : this.stringValue.charAt(0);
            }
            case doubleValue: {
                return (char)this.doubleValue;
            }
            case longValue: {
                return (char)this.longValue;
            }
            case booleanValue: {
                return this.longValue != 0L ? (char)'\u0001' : '\u0000';
            }
        }
        throw new IllegalStateException("Value cannot be converted to char: " + (Object)((Object)this.type));
    }

    public String[] asStringArray() {
        if (this.type != ValueType.array) {
            throw new IllegalStateException("Value is not an array: " + (Object)((Object)this.type));
        }
        String[] stringArray = new String[this.size];
        int n2 = 0;
        JsonValue jsonValue = this.child;
        while (jsonValue != null) {
            String string;
            switch (jsonValue.type) {
                case stringValue: {
                    string = jsonValue.stringValue;
                    break;
                }
                case doubleValue: {
                    string = this.stringValue != null ? this.stringValue : Double.toString(jsonValue.doubleValue);
                    break;
                }
                case longValue: {
                    string = this.stringValue != null ? this.stringValue : Long.toString(jsonValue.longValue);
                    break;
                }
                case booleanValue: {
                    string = jsonValue.longValue != 0L ? "true" : "false";
                    break;
                }
                case nullValue: {
                    string = null;
                    break;
                }
                default: {
                    throw new IllegalStateException("Value cannot be converted to string: " + (Object)((Object)jsonValue.type));
                }
            }
            stringArray[n2] = string;
            jsonValue = jsonValue.next;
            ++n2;
        }
        return stringArray;
    }

    public float[] asFloatArray() {
        if (this.type != ValueType.array) {
            throw new IllegalStateException("Value is not an array: " + (Object)((Object)this.type));
        }
        float[] fArray = new float[this.size];
        int n2 = 0;
        JsonValue jsonValue = this.child;
        while (jsonValue != null) {
            float f2;
            switch (jsonValue.type) {
                case stringValue: {
                    f2 = Float.parseFloat(jsonValue.stringValue);
                    break;
                }
                case doubleValue: {
                    f2 = (float)jsonValue.doubleValue;
                    break;
                }
                case longValue: {
                    f2 = jsonValue.longValue;
                    break;
                }
                case booleanValue: {
                    f2 = jsonValue.longValue != 0L ? 1.0f : 0.0f;
                    break;
                }
                default: {
                    throw new IllegalStateException("Value cannot be converted to float: " + (Object)((Object)jsonValue.type));
                }
            }
            fArray[n2] = f2;
            jsonValue = jsonValue.next;
            ++n2;
        }
        return fArray;
    }

    public double[] asDoubleArray() {
        if (this.type != ValueType.array) {
            throw new IllegalStateException("Value is not an array: " + (Object)((Object)this.type));
        }
        double[] dArray = new double[this.size];
        int n2 = 0;
        JsonValue jsonValue = this.child;
        while (jsonValue != null) {
            double d2;
            switch (jsonValue.type) {
                case stringValue: {
                    d2 = Double.parseDouble(jsonValue.stringValue);
                    break;
                }
                case doubleValue: {
                    d2 = jsonValue.doubleValue;
                    break;
                }
                case longValue: {
                    d2 = jsonValue.longValue;
                    break;
                }
                case booleanValue: {
                    d2 = jsonValue.longValue != 0L ? 1.0 : 0.0;
                    break;
                }
                default: {
                    throw new IllegalStateException("Value cannot be converted to double: " + (Object)((Object)jsonValue.type));
                }
            }
            dArray[n2] = d2;
            jsonValue = jsonValue.next;
            ++n2;
        }
        return dArray;
    }

    public long[] asLongArray() {
        if (this.type != ValueType.array) {
            throw new IllegalStateException("Value is not an array: " + (Object)((Object)this.type));
        }
        long[] lArray = new long[this.size];
        int n2 = 0;
        JsonValue jsonValue = this.child;
        while (jsonValue != null) {
            long l2;
            switch (jsonValue.type) {
                case stringValue: {
                    l2 = Long.parseLong(jsonValue.stringValue);
                    break;
                }
                case doubleValue: {
                    l2 = (long)jsonValue.doubleValue;
                    break;
                }
                case longValue: {
                    l2 = jsonValue.longValue;
                    break;
                }
                case booleanValue: {
                    l2 = jsonValue.longValue != 0L ? 1L : 0L;
                    break;
                }
                default: {
                    throw new IllegalStateException("Value cannot be converted to long: " + (Object)((Object)jsonValue.type));
                }
            }
            lArray[n2] = l2;
            jsonValue = jsonValue.next;
            ++n2;
        }
        return lArray;
    }

    public int[] asIntArray() {
        if (this.type != ValueType.array) {
            throw new IllegalStateException("Value is not an array: " + (Object)((Object)this.type));
        }
        int[] nArray = new int[this.size];
        int n2 = 0;
        JsonValue jsonValue = this.child;
        while (jsonValue != null) {
            int n3;
            switch (jsonValue.type) {
                case stringValue: {
                    n3 = Integer.parseInt(jsonValue.stringValue);
                    break;
                }
                case doubleValue: {
                    n3 = (int)jsonValue.doubleValue;
                    break;
                }
                case longValue: {
                    n3 = (int)jsonValue.longValue;
                    break;
                }
                case booleanValue: {
                    n3 = jsonValue.longValue != 0L ? 1 : 0;
                    break;
                }
                default: {
                    throw new IllegalStateException("Value cannot be converted to int: " + (Object)((Object)jsonValue.type));
                }
            }
            nArray[n2] = n3;
            jsonValue = jsonValue.next;
            ++n2;
        }
        return nArray;
    }

    public boolean[] asBooleanArray() {
        if (this.type != ValueType.array) {
            throw new IllegalStateException("Value is not an array: " + (Object)((Object)this.type));
        }
        boolean[] blArray = new boolean[this.size];
        int n2 = 0;
        JsonValue jsonValue = this.child;
        while (jsonValue != null) {
            boolean bl2;
            switch (jsonValue.type) {
                case stringValue: {
                    bl2 = Boolean.parseBoolean(jsonValue.stringValue);
                    break;
                }
                case doubleValue: {
                    bl2 = jsonValue.doubleValue == 0.0;
                    break;
                }
                case longValue: {
                    bl2 = jsonValue.longValue == 0L;
                    break;
                }
                case booleanValue: {
                    bl2 = jsonValue.longValue != 0L;
                    break;
                }
                default: {
                    throw new IllegalStateException("Value cannot be converted to boolean: " + (Object)((Object)jsonValue.type));
                }
            }
            blArray[n2] = bl2;
            jsonValue = jsonValue.next;
            ++n2;
        }
        return blArray;
    }

    public byte[] asByteArray() {
        if (this.type != ValueType.array) {
            throw new IllegalStateException("Value is not an array: " + (Object)((Object)this.type));
        }
        byte[] byArray = new byte[this.size];
        int n2 = 0;
        JsonValue jsonValue = this.child;
        while (jsonValue != null) {
            byte by2;
            switch (jsonValue.type) {
                case stringValue: {
                    by2 = Byte.parseByte(jsonValue.stringValue);
                    break;
                }
                case doubleValue: {
                    by2 = (byte)jsonValue.doubleValue;
                    break;
                }
                case longValue: {
                    by2 = (byte)jsonValue.longValue;
                    break;
                }
                case booleanValue: {
                    by2 = jsonValue.longValue != 0L ? (byte)1 : 0;
                    break;
                }
                default: {
                    throw new IllegalStateException("Value cannot be converted to byte: " + (Object)((Object)jsonValue.type));
                }
            }
            byArray[n2] = by2;
            jsonValue = jsonValue.next;
            ++n2;
        }
        return byArray;
    }

    public short[] asShortArray() {
        if (this.type != ValueType.array) {
            throw new IllegalStateException("Value is not an array: " + (Object)((Object)this.type));
        }
        short[] sArray = new short[this.size];
        int n2 = 0;
        JsonValue jsonValue = this.child;
        while (jsonValue != null) {
            short s2;
            switch (jsonValue.type) {
                case stringValue: {
                    s2 = Short.parseShort(jsonValue.stringValue);
                    break;
                }
                case doubleValue: {
                    s2 = (short)jsonValue.doubleValue;
                    break;
                }
                case longValue: {
                    s2 = (short)jsonValue.longValue;
                    break;
                }
                case booleanValue: {
                    s2 = jsonValue.longValue != 0L ? (short)1 : 0;
                    break;
                }
                default: {
                    throw new IllegalStateException("Value cannot be converted to short: " + (Object)((Object)jsonValue.type));
                }
            }
            sArray[n2] = s2;
            jsonValue = jsonValue.next;
            ++n2;
        }
        return sArray;
    }

    public char[] asCharArray() {
        if (this.type != ValueType.array) {
            throw new IllegalStateException("Value is not an array: " + (Object)((Object)this.type));
        }
        char[] cArray = new char[this.size];
        int n2 = 0;
        JsonValue jsonValue = this.child;
        while (jsonValue != null) {
            char c2;
            switch (jsonValue.type) {
                case stringValue: {
                    c2 = jsonValue.stringValue.length() == 0 ? (char)'\u0000' : jsonValue.stringValue.charAt(0);
                    break;
                }
                case doubleValue: {
                    c2 = (char)jsonValue.doubleValue;
                    break;
                }
                case longValue: {
                    c2 = (char)jsonValue.longValue;
                    break;
                }
                case booleanValue: {
                    c2 = jsonValue.longValue != 0L ? (char)'\u0001' : '\u0000';
                    break;
                }
                default: {
                    throw new IllegalStateException("Value cannot be converted to char: " + (Object)((Object)jsonValue.type));
                }
            }
            cArray[n2] = c2;
            jsonValue = jsonValue.next;
            ++n2;
        }
        return cArray;
    }

    public boolean hasChild(String string) {
        return this.getChild(string) != null;
    }

    @Null
    public JsonValue getChild(String string) {
        JsonValue jsonValue = this.get(string);
        return jsonValue == null ? null : jsonValue.child;
    }

    public String getString(String string, @Null String string2) {
        JsonValue jsonValue = this.get(string);
        return jsonValue == null || !jsonValue.isValue() || jsonValue.isNull() ? string2 : jsonValue.asString();
    }

    public float getFloat(String string, float f2) {
        JsonValue jsonValue = this.get(string);
        return jsonValue == null || !jsonValue.isValue() || jsonValue.isNull() ? f2 : jsonValue.asFloat();
    }

    public double getDouble(String string, double d2) {
        JsonValue jsonValue = this.get(string);
        return jsonValue == null || !jsonValue.isValue() || jsonValue.isNull() ? d2 : jsonValue.asDouble();
    }

    public long getLong(String string, long l2) {
        JsonValue jsonValue = this.get(string);
        return jsonValue == null || !jsonValue.isValue() || jsonValue.isNull() ? l2 : jsonValue.asLong();
    }

    public int getInt(String string, int n2) {
        JsonValue jsonValue = this.get(string);
        return jsonValue == null || !jsonValue.isValue() || jsonValue.isNull() ? n2 : jsonValue.asInt();
    }

    public boolean getBoolean(String string, boolean bl2) {
        JsonValue jsonValue = this.get(string);
        return jsonValue == null || !jsonValue.isValue() || jsonValue.isNull() ? bl2 : jsonValue.asBoolean();
    }

    public byte getByte(String string, byte by2) {
        JsonValue jsonValue = this.get(string);
        return jsonValue == null || !jsonValue.isValue() || jsonValue.isNull() ? by2 : jsonValue.asByte();
    }

    public short getShort(String string, short s2) {
        JsonValue jsonValue = this.get(string);
        return jsonValue == null || !jsonValue.isValue() || jsonValue.isNull() ? s2 : jsonValue.asShort();
    }

    public char getChar(String string, char c2) {
        JsonValue jsonValue = this.get(string);
        return jsonValue == null || !jsonValue.isValue() || jsonValue.isNull() ? c2 : jsonValue.asChar();
    }

    public String getString(String string) {
        JsonValue jsonValue = this.get(string);
        if (jsonValue == null) {
            throw new IllegalArgumentException("Named value not found: " + string);
        }
        return jsonValue.asString();
    }

    public float getFloat(String string) {
        JsonValue jsonValue = this.get(string);
        if (jsonValue == null) {
            throw new IllegalArgumentException("Named value not found: " + string);
        }
        return jsonValue.asFloat();
    }

    public double getDouble(String string) {
        JsonValue jsonValue = this.get(string);
        if (jsonValue == null) {
            throw new IllegalArgumentException("Named value not found: " + string);
        }
        return jsonValue.asDouble();
    }

    public long getLong(String string) {
        JsonValue jsonValue = this.get(string);
        if (jsonValue == null) {
            throw new IllegalArgumentException("Named value not found: " + string);
        }
        return jsonValue.asLong();
    }

    public int getInt(String string) {
        JsonValue jsonValue = this.get(string);
        if (jsonValue == null) {
            throw new IllegalArgumentException("Named value not found: " + string);
        }
        return jsonValue.asInt();
    }

    public boolean getBoolean(String string) {
        JsonValue jsonValue = this.get(string);
        if (jsonValue == null) {
            throw new IllegalArgumentException("Named value not found: " + string);
        }
        return jsonValue.asBoolean();
    }

    public byte getByte(String string) {
        JsonValue jsonValue = this.get(string);
        if (jsonValue == null) {
            throw new IllegalArgumentException("Named value not found: " + string);
        }
        return jsonValue.asByte();
    }

    public short getShort(String string) {
        JsonValue jsonValue = this.get(string);
        if (jsonValue == null) {
            throw new IllegalArgumentException("Named value not found: " + string);
        }
        return jsonValue.asShort();
    }

    public char getChar(String string) {
        JsonValue jsonValue = this.get(string);
        if (jsonValue == null) {
            throw new IllegalArgumentException("Named value not found: " + string);
        }
        return jsonValue.asChar();
    }

    public String getString(int n2) {
        JsonValue jsonValue = this.get(n2);
        if (jsonValue == null) {
            throw new IllegalArgumentException("Indexed value not found: " + this.name);
        }
        return jsonValue.asString();
    }

    public float getFloat(int n2) {
        JsonValue jsonValue = this.get(n2);
        if (jsonValue == null) {
            throw new IllegalArgumentException("Indexed value not found: " + this.name);
        }
        return jsonValue.asFloat();
    }

    public double getDouble(int n2) {
        JsonValue jsonValue = this.get(n2);
        if (jsonValue == null) {
            throw new IllegalArgumentException("Indexed value not found: " + this.name);
        }
        return jsonValue.asDouble();
    }

    public long getLong(int n2) {
        JsonValue jsonValue = this.get(n2);
        if (jsonValue == null) {
            throw new IllegalArgumentException("Indexed value not found: " + this.name);
        }
        return jsonValue.asLong();
    }

    public int getInt(int n2) {
        JsonValue jsonValue = this.get(n2);
        if (jsonValue == null) {
            throw new IllegalArgumentException("Indexed value not found: " + this.name);
        }
        return jsonValue.asInt();
    }

    public boolean getBoolean(int n2) {
        JsonValue jsonValue = this.get(n2);
        if (jsonValue == null) {
            throw new IllegalArgumentException("Indexed value not found: " + this.name);
        }
        return jsonValue.asBoolean();
    }

    public byte getByte(int n2) {
        JsonValue jsonValue = this.get(n2);
        if (jsonValue == null) {
            throw new IllegalArgumentException("Indexed value not found: " + this.name);
        }
        return jsonValue.asByte();
    }

    public short getShort(int n2) {
        JsonValue jsonValue = this.get(n2);
        if (jsonValue == null) {
            throw new IllegalArgumentException("Indexed value not found: " + this.name);
        }
        return jsonValue.asShort();
    }

    public char getChar(int n2) {
        JsonValue jsonValue = this.get(n2);
        if (jsonValue == null) {
            throw new IllegalArgumentException("Indexed value not found: " + this.name);
        }
        return jsonValue.asChar();
    }

    public ValueType type() {
        return this.type;
    }

    public void setType(ValueType valueType) {
        if (valueType == null) {
            throw new IllegalArgumentException("type cannot be null.");
        }
        this.type = valueType;
    }

    public boolean isArray() {
        return this.type == ValueType.array;
    }

    public boolean isObject() {
        return this.type == ValueType.object;
    }

    public boolean isString() {
        return this.type == ValueType.stringValue;
    }

    public boolean isNumber() {
        return this.type == ValueType.doubleValue || this.type == ValueType.longValue;
    }

    public boolean isDouble() {
        return this.type == ValueType.doubleValue;
    }

    public boolean isLong() {
        return this.type == ValueType.longValue;
    }

    public boolean isBoolean() {
        return this.type == ValueType.booleanValue;
    }

    public boolean isNull() {
        return this.type == ValueType.nullValue;
    }

    public boolean isValue() {
        switch (this.type) {
            case stringValue: 
            case doubleValue: 
            case longValue: 
            case booleanValue: 
            case nullValue: {
                return true;
            }
        }
        return false;
    }

    @Null
    public String name() {
        return this.name;
    }

    public void setName(@Null String string) {
        this.name = string;
    }

    @Null
    public JsonValue parent() {
        return this.parent;
    }

    @Null
    public JsonValue child() {
        return this.child;
    }

    public void addChild(String string, JsonValue jsonValue) {
        if (string == null) {
            throw new IllegalArgumentException("name cannot be null.");
        }
        jsonValue.name = string;
        this.addChild(jsonValue);
    }

    public void addChild(JsonValue jsonValue) {
        if (this.type == ValueType.object && jsonValue.name == null) {
            throw new IllegalStateException("An object child requires a name: " + jsonValue);
        }
        jsonValue.parent = this;
        ++this.size;
        JsonValue jsonValue2 = this.child;
        if (jsonValue2 != null) {
            while (true) {
                if (jsonValue2.next == null) {
                    jsonValue2.next = jsonValue;
                    jsonValue.prev = jsonValue2;
                    return;
                }
                jsonValue2 = jsonValue2.next;
            }
        }
        this.child = jsonValue;
    }

    @Null
    public JsonValue next() {
        return this.next;
    }

    public void setNext(@Null JsonValue jsonValue) {
        this.next = jsonValue;
    }

    @Null
    public JsonValue prev() {
        return this.prev;
    }

    public void setPrev(@Null JsonValue jsonValue) {
        this.prev = jsonValue;
    }

    public void set(@Null String string) {
        this.stringValue = string;
        this.type = string == null ? ValueType.nullValue : ValueType.stringValue;
    }

    public void set(double d2, @Null String string) {
        this.doubleValue = d2;
        this.longValue = (long)d2;
        this.stringValue = string;
        this.type = ValueType.doubleValue;
    }

    public void set(long l2, @Null String string) {
        this.longValue = l2;
        this.doubleValue = l2;
        this.stringValue = string;
        this.type = ValueType.longValue;
    }

    public void set(boolean bl2) {
        this.longValue = bl2 ? 1L : 0L;
        this.type = ValueType.booleanValue;
    }

    public String toJson(JsonWriter.OutputType outputType) {
        if (this.isValue()) {
            return this.asString();
        }
        StringBuilder stringBuilder = new StringBuilder(512);
        this.json(this, stringBuilder, outputType);
        return stringBuilder.toString();
    }

    private void json(JsonValue jsonValue, StringBuilder stringBuilder, JsonWriter.OutputType outputType) {
        if (jsonValue.isObject()) {
            if (jsonValue.child == null) {
                stringBuilder.append("{}");
            } else {
                int n2 = stringBuilder.length();
                stringBuilder.append('{');
                boolean bl2 = false;
                JsonValue jsonValue2 = jsonValue.child;
                while (jsonValue2 != null) {
                    stringBuilder.append(outputType.quoteName(jsonValue2.name));
                    stringBuilder.append(':');
                    this.json(jsonValue2, stringBuilder, outputType);
                    if (jsonValue2.next != null) {
                        stringBuilder.append(',');
                    }
                    jsonValue2 = jsonValue2.next;
                }
                stringBuilder.append('}');
            }
        } else if (jsonValue.isArray()) {
            if (jsonValue.child == null) {
                stringBuilder.append("[]");
            } else {
                int n3 = stringBuilder.length();
                stringBuilder.append('[');
                JsonValue jsonValue3 = jsonValue.child;
                while (jsonValue3 != null) {
                    this.json(jsonValue3, stringBuilder, outputType);
                    if (jsonValue3.next != null) {
                        stringBuilder.append(',');
                    }
                    jsonValue3 = jsonValue3.next;
                }
                stringBuilder.append(']');
            }
        } else if (jsonValue.isString()) {
            stringBuilder.append(outputType.quoteValue(jsonValue.asString()));
        } else if (jsonValue.isDouble()) {
            long l2;
            double d2 = jsonValue.asDouble();
            stringBuilder.append(d2 == (double)(l2 = jsonValue.asLong()) ? (double)l2 : d2);
        } else if (jsonValue.isLong()) {
            stringBuilder.append(jsonValue.asLong());
        } else if (jsonValue.isBoolean()) {
            stringBuilder.append(jsonValue.asBoolean());
        } else if (jsonValue.isNull()) {
            stringBuilder.append("null");
        } else {
            throw new SerializationException("Unknown object type: " + jsonValue);
        }
    }

    public JsonIterator iterator() {
        return new JsonIterator();
    }

    public String toString() {
        if (this.isValue()) {
            return this.name == null ? this.asString() : this.name + ": " + this.asString();
        }
        return (this.name == null ? "" : this.name + ": ") + this.prettyPrint(JsonWriter.OutputType.minimal, 0);
    }

    public String trace() {
        String string;
        if (this.parent == null) {
            if (this.type == ValueType.array) {
                return "[]";
            }
            if (this.type == ValueType.object) {
                return "{}";
            }
            return "";
        }
        if (this.parent.type == ValueType.array) {
            string = "[]";
            int n2 = 0;
            JsonValue jsonValue = this.parent.child;
            while (jsonValue != null) {
                if (jsonValue == this) {
                    string = "[" + n2 + "]";
                    break;
                }
                jsonValue = jsonValue.next;
                ++n2;
            }
        } else {
            string = this.name.indexOf(46) != -1 ? ".\"" + this.name.replace("\"", "\\\"") + "\"" : '.' + this.name;
        }
        return this.parent.trace() + string;
    }

    public String prettyPrint(JsonWriter.OutputType outputType, int n2) {
        PrettyPrintSettings prettyPrintSettings = new PrettyPrintSettings();
        prettyPrintSettings.outputType = outputType;
        prettyPrintSettings.singleLineColumns = n2;
        return this.prettyPrint(prettyPrintSettings);
    }

    public String prettyPrint(PrettyPrintSettings prettyPrintSettings) {
        StringBuilder stringBuilder = new StringBuilder(512);
        this.prettyPrint(this, stringBuilder, 0, prettyPrintSettings);
        return stringBuilder.toString();
    }

    private void prettyPrint(JsonValue jsonValue, StringBuilder stringBuilder, int n2, PrettyPrintSettings prettyPrintSettings) {
        JsonWriter.OutputType outputType = prettyPrintSettings.outputType;
        if (jsonValue.isObject()) {
            if (jsonValue.child == null) {
                stringBuilder.append("{}");
            } else {
                boolean bl2 = !JsonValue.isFlat(jsonValue);
                int n3 = stringBuilder.length();
                block0: while (true) {
                    stringBuilder.append(bl2 ? "{\n" : "{ ");
                    boolean bl3 = false;
                    JsonValue jsonValue2 = jsonValue.child;
                    while (jsonValue2 != null) {
                        if (bl2) {
                            JsonValue.indent(n2, stringBuilder);
                        }
                        stringBuilder.append(outputType.quoteName(jsonValue2.name));
                        stringBuilder.append(": ");
                        this.prettyPrint(jsonValue2, stringBuilder, n2 + 1, prettyPrintSettings);
                        if (!(bl2 && outputType == JsonWriter.OutputType.minimal || jsonValue2.next == null)) {
                            stringBuilder.append(',');
                        }
                        stringBuilder.append(bl2 ? (char)'\n' : ' ');
                        if (!bl2 && stringBuilder.length() - n3 > prettyPrintSettings.singleLineColumns) {
                            stringBuilder.setLength(n3);
                            bl2 = true;
                            continue block0;
                        }
                        jsonValue2 = jsonValue2.next;
                    }
                    break;
                }
                if (bl2) {
                    JsonValue.indent(n2 - 1, stringBuilder);
                }
                stringBuilder.append('}');
            }
        } else if (jsonValue.isArray()) {
            if (jsonValue.child == null) {
                stringBuilder.append("[]");
            } else {
                boolean bl4 = !JsonValue.isFlat(jsonValue);
                boolean bl5 = prettyPrintSettings.wrapNumericArrays || !JsonValue.isNumeric(jsonValue);
                int n4 = stringBuilder.length();
                block2: while (true) {
                    stringBuilder.append(bl4 ? "[\n" : "[ ");
                    JsonValue jsonValue3 = jsonValue.child;
                    while (jsonValue3 != null) {
                        if (bl4) {
                            JsonValue.indent(n2, stringBuilder);
                        }
                        this.prettyPrint(jsonValue3, stringBuilder, n2 + 1, prettyPrintSettings);
                        if (!(bl4 && outputType == JsonWriter.OutputType.minimal || jsonValue3.next == null)) {
                            stringBuilder.append(',');
                        }
                        stringBuilder.append(bl4 ? (char)'\n' : ' ');
                        if (bl5 && !bl4 && stringBuilder.length() - n4 > prettyPrintSettings.singleLineColumns) {
                            stringBuilder.setLength(n4);
                            bl4 = true;
                            continue block2;
                        }
                        jsonValue3 = jsonValue3.next;
                    }
                    break;
                }
                if (bl4) {
                    JsonValue.indent(n2 - 1, stringBuilder);
                }
                stringBuilder.append(']');
            }
        } else if (jsonValue.isString()) {
            stringBuilder.append(outputType.quoteValue(jsonValue.asString()));
        } else if (jsonValue.isDouble()) {
            long l2;
            double d2 = jsonValue.asDouble();
            stringBuilder.append(d2 == (double)(l2 = jsonValue.asLong()) ? (double)l2 : d2);
        } else if (jsonValue.isLong()) {
            stringBuilder.append(jsonValue.asLong());
        } else if (jsonValue.isBoolean()) {
            stringBuilder.append(jsonValue.asBoolean());
        } else if (jsonValue.isNull()) {
            stringBuilder.append("null");
        } else {
            throw new SerializationException("Unknown object type: " + jsonValue);
        }
    }

    public void prettyPrint(JsonWriter.OutputType outputType, Writer writer) {
        PrettyPrintSettings prettyPrintSettings = new PrettyPrintSettings();
        prettyPrintSettings.outputType = outputType;
        this.prettyPrint(this, writer, 0, prettyPrintSettings);
    }

    private void prettyPrint(JsonValue jsonValue, Writer writer, int n2, PrettyPrintSettings prettyPrintSettings) {
        JsonWriter.OutputType outputType = prettyPrintSettings.outputType;
        if (jsonValue.isObject()) {
            if (jsonValue.child == null) {
                writer.append("{}");
            } else {
                boolean bl2 = !JsonValue.isFlat(jsonValue) || jsonValue.size > 6;
                writer.append(bl2 ? "{\n" : "{ ");
                boolean bl3 = false;
                JsonValue jsonValue2 = jsonValue.child;
                while (jsonValue2 != null) {
                    if (bl2) {
                        JsonValue.indent(n2, writer);
                    }
                    writer.append(outputType.quoteName(jsonValue2.name));
                    writer.append(": ");
                    this.prettyPrint(jsonValue2, writer, n2 + 1, prettyPrintSettings);
                    if (!(bl2 && outputType == JsonWriter.OutputType.minimal || jsonValue2.next == null)) {
                        writer.append(',');
                    }
                    writer.append(bl2 ? (char)'\n' : ' ');
                    jsonValue2 = jsonValue2.next;
                }
                if (bl2) {
                    JsonValue.indent(n2 - 1, writer);
                }
                writer.append('}');
            }
        } else if (jsonValue.isArray()) {
            if (jsonValue.child == null) {
                writer.append("[]");
            } else {
                boolean bl4 = !JsonValue.isFlat(jsonValue);
                writer.append(bl4 ? "[\n" : "[ ");
                boolean bl5 = false;
                JsonValue jsonValue3 = jsonValue.child;
                while (jsonValue3 != null) {
                    if (bl4) {
                        JsonValue.indent(n2, writer);
                    }
                    this.prettyPrint(jsonValue3, writer, n2 + 1, prettyPrintSettings);
                    if (!(bl4 && outputType == JsonWriter.OutputType.minimal || jsonValue3.next == null)) {
                        writer.append(',');
                    }
                    writer.append(bl4 ? (char)'\n' : ' ');
                    jsonValue3 = jsonValue3.next;
                }
                if (bl4) {
                    JsonValue.indent(n2 - 1, writer);
                }
                writer.append(']');
            }
        } else if (jsonValue.isString()) {
            writer.append(outputType.quoteValue(jsonValue.asString()));
        } else if (jsonValue.isDouble()) {
            long l2;
            double d2 = jsonValue.asDouble();
            writer.append(Double.toString(d2 == (double)(l2 = jsonValue.asLong()) ? (double)l2 : d2));
        } else if (jsonValue.isLong()) {
            writer.append(Long.toString(jsonValue.asLong()));
        } else if (jsonValue.isBoolean()) {
            writer.append(Boolean.toString(jsonValue.asBoolean()));
        } else if (jsonValue.isNull()) {
            writer.append("null");
        } else {
            throw new SerializationException("Unknown object type: " + jsonValue);
        }
    }

    private static boolean isFlat(JsonValue jsonValue) {
        JsonValue jsonValue2 = jsonValue.child;
        while (jsonValue2 != null) {
            if (jsonValue2.isObject() || jsonValue2.isArray()) {
                return false;
            }
            jsonValue2 = jsonValue2.next;
        }
        return true;
    }

    private static boolean isNumeric(JsonValue jsonValue) {
        JsonValue jsonValue2 = jsonValue.child;
        while (jsonValue2 != null) {
            if (!jsonValue2.isNumber()) {
                return false;
            }
            jsonValue2 = jsonValue2.next;
        }
        return true;
    }

    private static void indent(int n2, StringBuilder stringBuilder) {
        for (int i2 = 0; i2 < n2; ++i2) {
            stringBuilder.append('\t');
        }
    }

    private static void indent(int n2, Writer writer) {
        for (int i2 = 0; i2 < n2; ++i2) {
            writer.append('\t');
        }
    }

    public static class PrettyPrintSettings {
        public JsonWriter.OutputType outputType;
        public int singleLineColumns;
        public boolean wrapNumericArrays;
    }

    public static enum ValueType {
        object,
        array,
        stringValue,
        doubleValue,
        longValue,
        booleanValue,
        nullValue;

    }

    public class JsonIterator
    implements Iterable<JsonValue>,
    Iterator<JsonValue> {
        JsonValue entry;
        JsonValue current;

        public JsonIterator() {
            this.entry = JsonValue.this.child;
        }

        @Override
        public boolean hasNext() {
            return this.entry != null;
        }

        @Override
        public JsonValue next() {
            this.current = this.entry;
            if (this.current == null) {
                throw new NoSuchElementException();
            }
            this.entry = this.current.next;
            return this.current;
        }

        @Override
        public void remove() {
            if (this.current.prev == null) {
                JsonValue.this.child = this.current.next;
                if (JsonValue.this.child != null) {
                    JsonValue.this.child.prev = null;
                }
            } else {
                this.current.prev.next = this.current.next;
                if (this.current.next != null) {
                    this.current.next.prev = this.current.prev;
                }
            }
            --JsonValue.this.size;
        }

        @Override
        public Iterator<JsonValue> iterator() {
            return this;
        }
    }
}

