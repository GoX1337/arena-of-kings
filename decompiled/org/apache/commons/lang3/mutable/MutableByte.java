/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3.mutable;

import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.mutable.Mutable;

public class MutableByte
extends Number
implements Comparable<MutableByte>,
Mutable<Number> {
    private static final long serialVersionUID = -1585823265L;
    private byte value;

    public MutableByte() {
    }

    public MutableByte(byte by2) {
        this.value = by2;
    }

    public MutableByte(Number number) {
        this.value = number.byteValue();
    }

    public MutableByte(String string) {
        this.value = Byte.parseByte(string);
    }

    @Override
    public Byte getValue() {
        return this.value;
    }

    @Override
    public void setValue(byte by2) {
        this.value = by2;
    }

    @Override
    public void setValue(Number number) {
        this.value = number.byteValue();
    }

    public void increment() {
        this.value = (byte)(this.value + 1);
    }

    public byte getAndIncrement() {
        byte by2 = this.value;
        this.value = (byte)(this.value + 1);
        return by2;
    }

    public byte incrementAndGet() {
        this.value = (byte)(this.value + 1);
        return this.value;
    }

    public void decrement() {
        this.value = (byte)(this.value - 1);
    }

    public byte getAndDecrement() {
        byte by2 = this.value;
        this.value = (byte)(this.value - 1);
        return by2;
    }

    public byte decrementAndGet() {
        this.value = (byte)(this.value - 1);
        return this.value;
    }

    public void add(byte by2) {
        this.value = (byte)(this.value + by2);
    }

    public void add(Number number) {
        this.value = (byte)(this.value + number.byteValue());
    }

    public void subtract(byte by2) {
        this.value = (byte)(this.value - by2);
    }

    public void subtract(Number number) {
        this.value = (byte)(this.value - number.byteValue());
    }

    public byte addAndGet(byte by2) {
        this.value = (byte)(this.value + by2);
        return this.value;
    }

    public byte addAndGet(Number number) {
        this.value = (byte)(this.value + number.byteValue());
        return this.value;
    }

    public byte getAndAdd(byte by2) {
        byte by3 = this.value;
        this.value = (byte)(this.value + by2);
        return by3;
    }

    public byte getAndAdd(Number number) {
        byte by2 = this.value;
        this.value = (byte)(this.value + number.byteValue());
        return by2;
    }

    @Override
    public byte byteValue() {
        return this.value;
    }

    @Override
    public int intValue() {
        return this.value;
    }

    @Override
    public long longValue() {
        return this.value;
    }

    @Override
    public float floatValue() {
        return this.value;
    }

    @Override
    public double doubleValue() {
        return this.value;
    }

    public Byte toByte() {
        return this.byteValue();
    }

    public boolean equals(Object object) {
        if (object instanceof MutableByte) {
            return this.value == ((MutableByte)object).byteValue();
        }
        return false;
    }

    public int hashCode() {
        return this.value;
    }

    @Override
    public int compareTo(MutableByte mutableByte) {
        return NumberUtils.compare(this.value, mutableByte.value);
    }

    public String toString() {
        return String.valueOf(this.value);
    }
}

