/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils;

import com.badlogic.gdx.utils.Null;
import java.io.DataOutputStream;
import java.io.OutputStream;

public class DataOutput
extends DataOutputStream {
    public DataOutput(OutputStream outputStream) {
        super(outputStream);
    }

    public int writeInt(int n2, boolean bl2) {
        if (!bl2) {
            n2 = n2 << 1 ^ n2 >> 31;
        }
        if (n2 >>> 7 == 0) {
            this.write((byte)n2);
            return 1;
        }
        this.write((byte)(n2 & 0x7F | 0x80));
        if (n2 >>> 14 == 0) {
            this.write((byte)(n2 >>> 7));
            return 2;
        }
        this.write((byte)(n2 >>> 7 | 0x80));
        if (n2 >>> 21 == 0) {
            this.write((byte)(n2 >>> 14));
            return 3;
        }
        this.write((byte)(n2 >>> 14 | 0x80));
        if (n2 >>> 28 == 0) {
            this.write((byte)(n2 >>> 21));
            return 4;
        }
        this.write((byte)(n2 >>> 21 | 0x80));
        this.write((byte)(n2 >>> 28));
        return 5;
    }

    public void writeString(@Null String string) {
        char c2;
        int n2;
        if (string == null) {
            this.write(0);
            return;
        }
        int n3 = string.length();
        if (n3 == 0) {
            this.writeByte(1);
            return;
        }
        this.writeInt(n3 + 1, true);
        for (n2 = 0; n2 < n3 && (c2 = string.charAt(n2)) <= '\u007f'; ++n2) {
            this.write((byte)c2);
        }
        if (n2 < n3) {
            this.writeString_slow(string, n3, n2);
        }
    }

    private void writeString_slow(String string, int n2, int n3) {
        while (n3 < n2) {
            char c2 = string.charAt(n3);
            if (c2 <= '\u007f') {
                this.write((byte)c2);
            } else if (c2 > '\u07ff') {
                this.write((byte)(0xE0 | c2 >> 12 & 0xF));
                this.write((byte)(0x80 | c2 >> 6 & 0x3F));
                this.write((byte)(0x80 | c2 & 0x3F));
            } else {
                this.write((byte)(0xC0 | c2 >> 6 & 0x1F));
                this.write((byte)(0x80 | c2 & 0x3F));
            }
            ++n3;
        }
    }
}

