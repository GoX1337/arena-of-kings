/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3.mutable;

import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.mutable.Mutable;

public class MutableShort
extends Number
implements Comparable<MutableShort>,
Mutable<Number> {
    private static final long serialVersionUID = -2135791679L;
    private short value;

    public MutableShort() {
    }

    public MutableShort(short s2) {
        this.value = s2;
    }

    public MutableShort(Number number) {
        this.value = number.shortValue();
    }

    public MutableShort(String string) {
        this.value = Short.parseShort(string);
    }

    @Override
    public Short getValue() {
        return this.value;
    }

    @Override
    public void setValue(short s2) {
        this.value = s2;
    }

    @Override
    public void setValue(Number number) {
        this.value = number.shortValue();
    }

    public void increment() {
        this.value = (short)(this.value + 1);
    }

    public short getAndIncrement() {
        short s2 = this.value;
        this.value = (short)(this.value + 1);
        return s2;
    }

    public short incrementAndGet() {
        this.value = (short)(this.value + 1);
        return this.value;
    }

    public void decrement() {
        this.value = (short)(this.value - 1);
    }

    public short getAndDecrement() {
        short s2 = this.value;
        this.value = (short)(this.value - 1);
        return s2;
    }

    public short decrementAndGet() {
        this.value = (short)(this.value - 1);
        return this.value;
    }

    public void add(short s2) {
        this.value = (short)(this.value + s2);
    }

    public void add(Number number) {
        this.value = (short)(this.value + number.shortValue());
    }

    public void subtract(short s2) {
        this.value = (short)(this.value - s2);
    }

    public void subtract(Number number) {
        this.value = (short)(this.value - number.shortValue());
    }

    public short addAndGet(short s2) {
        this.value = (short)(this.value + s2);
        return this.value;
    }

    public short addAndGet(Number number) {
        this.value = (short)(this.value + number.shortValue());
        return this.value;
    }

    public short getAndAdd(short s2) {
        short s3 = this.value;
        this.value = (short)(this.value + s2);
        return s3;
    }

    public short getAndAdd(Number number) {
        short s2 = this.value;
        this.value = (short)(this.value + number.shortValue());
        return s2;
    }

    @Override
    public short shortValue() {
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

    public Short toShort() {
        return this.shortValue();
    }

    public boolean equals(Object object) {
        if (object instanceof MutableShort) {
            return this.value == ((MutableShort)object).shortValue();
        }
        return false;
    }

    public int hashCode() {
        return this.value;
    }

    @Override
    public int compareTo(MutableShort mutableShort) {
        return NumberUtils.compare(this.value, mutableShort.value);
    }

    public String toString() {
        return String.valueOf(this.value);
    }
}

