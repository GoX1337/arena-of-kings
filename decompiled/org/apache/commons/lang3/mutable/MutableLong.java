/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3.mutable;

import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.mutable.Mutable;

public class MutableLong
extends Number
implements Comparable<MutableLong>,
Mutable<Number> {
    private static final long serialVersionUID = 62986528375L;
    private long value;

    public MutableLong() {
    }

    public MutableLong(long l2) {
        this.value = l2;
    }

    public MutableLong(Number number) {
        this.value = number.longValue();
    }

    public MutableLong(String string) {
        this.value = Long.parseLong(string);
    }

    @Override
    public Long getValue() {
        return this.value;
    }

    @Override
    public void setValue(long l2) {
        this.value = l2;
    }

    @Override
    public void setValue(Number number) {
        this.value = number.longValue();
    }

    public void increment() {
        ++this.value;
    }

    public long getAndIncrement() {
        long l2 = this.value++;
        return l2;
    }

    public long incrementAndGet() {
        ++this.value;
        return this.value;
    }

    public void decrement() {
        --this.value;
    }

    public long getAndDecrement() {
        long l2 = this.value--;
        return l2;
    }

    public long decrementAndGet() {
        --this.value;
        return this.value;
    }

    public void add(long l2) {
        this.value += l2;
    }

    public void add(Number number) {
        this.value += number.longValue();
    }

    public void subtract(long l2) {
        this.value -= l2;
    }

    public void subtract(Number number) {
        this.value -= number.longValue();
    }

    public long addAndGet(long l2) {
        this.value += l2;
        return this.value;
    }

    public long addAndGet(Number number) {
        this.value += number.longValue();
        return this.value;
    }

    public long getAndAdd(long l2) {
        long l3 = this.value;
        this.value += l2;
        return l3;
    }

    public long getAndAdd(Number number) {
        long l2 = this.value;
        this.value += number.longValue();
        return l2;
    }

    @Override
    public int intValue() {
        return (int)this.value;
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

    public Long toLong() {
        return this.longValue();
    }

    public boolean equals(Object object) {
        if (object instanceof MutableLong) {
            return this.value == ((MutableLong)object).longValue();
        }
        return false;
    }

    public int hashCode() {
        return (int)(this.value ^ this.value >>> 32);
    }

    @Override
    public int compareTo(MutableLong mutableLong) {
        return NumberUtils.compare(this.value, mutableLong.value);
    }

    public String toString() {
        return String.valueOf(this.value);
    }
}

