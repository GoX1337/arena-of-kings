/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3;

public class BitField {
    private final int _mask;
    private final int _shift_count;

    public BitField(int n2) {
        this._mask = n2;
        this._shift_count = n2 == 0 ? 0 : Integer.numberOfTrailingZeros(n2);
    }

    public int getValue(int n2) {
        return this.getRawValue(n2) >> this._shift_count;
    }

    public short getShortValue(short s2) {
        return (short)this.getValue(s2);
    }

    public int getRawValue(int n2) {
        return n2 & this._mask;
    }

    public short getShortRawValue(short s2) {
        return (short)this.getRawValue(s2);
    }

    public boolean isSet(int n2) {
        return (n2 & this._mask) != 0;
    }

    public boolean isAllSet(int n2) {
        return (n2 & this._mask) == this._mask;
    }

    public int setValue(int n2, int n3) {
        return n2 & ~this._mask | n3 << this._shift_count & this._mask;
    }

    public short setShortValue(short s2, short s3) {
        return (short)this.setValue(s2, s3);
    }

    public int clear(int n2) {
        return n2 & ~this._mask;
    }

    public short clearShort(short s2) {
        return (short)this.clear(s2);
    }

    public byte clearByte(byte by2) {
        return (byte)this.clear(by2);
    }

    public int set(int n2) {
        return n2 | this._mask;
    }

    public short setShort(short s2) {
        return (short)this.set(s2);
    }

    public byte setByte(byte by2) {
        return (byte)this.set(by2);
    }

    public int setBoolean(int n2, boolean bl2) {
        return bl2 ? this.set(n2) : this.clear(n2);
    }

    public short setShortBoolean(short s2, boolean bl2) {
        return bl2 ? this.setShort(s2) : this.clearShort(s2);
    }

    public byte setByteBoolean(byte by2, boolean bl2) {
        return bl2 ? this.setByte(by2) : this.clearByte(by2);
    }
}

