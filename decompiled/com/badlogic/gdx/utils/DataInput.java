/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils;

import com.badlogic.gdx.utils.Null;
import java.io.DataInputStream;
import java.io.InputStream;

public class DataInput
extends DataInputStream {
    private char[] chars = new char[32];

    public DataInput(InputStream inputStream) {
        super(inputStream);
    }

    public int readInt(boolean bl2) {
        int n2 = this.read();
        int n3 = n2 & 0x7F;
        if ((n2 & 0x80) != 0) {
            n2 = this.read();
            n3 |= (n2 & 0x7F) << 7;
            if ((n2 & 0x80) != 0) {
                n2 = this.read();
                n3 |= (n2 & 0x7F) << 14;
                if ((n2 & 0x80) != 0) {
                    n2 = this.read();
                    n3 |= (n2 & 0x7F) << 21;
                    if ((n2 & 0x80) != 0) {
                        n2 = this.read();
                        n3 |= (n2 & 0x7F) << 28;
                    }
                }
            }
        }
        return bl2 ? n3 : n3 >>> 1 ^ -(n3 & 1);
    }

    @Null
    public String readString() {
        int n2 = this.readInt(true);
        switch (n2) {
            case 0: {
                return null;
            }
            case 1: {
                return "";
            }
        }
        if (this.chars.length < --n2) {
            this.chars = new char[n2];
        }
        char[] cArray = this.chars;
        int n3 = 0;
        int n4 = 0;
        while (n3 < n2 && (n4 = this.read()) <= 127) {
            cArray[n3++] = (char)n4;
        }
        if (n3 < n2) {
            this.readUtf8_slow(n2, n3, n4);
        }
        return new String(cArray, 0, n2);
    }

    private void readUtf8_slow(int n2, int n3, int n4) {
        char[] cArray = this.chars;
        while (true) {
            switch (n4 >> 4) {
                case 0: 
                case 1: 
                case 2: 
                case 3: 
                case 4: 
                case 5: 
                case 6: 
                case 7: {
                    cArray[n3] = (char)n4;
                    break;
                }
                case 12: 
                case 13: {
                    cArray[n3] = (char)((n4 & 0x1F) << 6 | this.read() & 0x3F);
                    break;
                }
                case 14: {
                    cArray[n3] = (char)((n4 & 0xF) << 12 | (this.read() & 0x3F) << 6 | this.read() & 0x3F);
                }
            }
            if (++n3 >= n2) break;
            n4 = this.read() & 0xFF;
        }
    }
}

