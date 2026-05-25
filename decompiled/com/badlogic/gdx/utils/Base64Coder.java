/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils;

import com.badlogic.gdx.utils.StringBuilder;
import java.io.UnsupportedEncodingException;

public class Base64Coder {
    private static final String systemLineSeparator = "\n";
    public static final CharMap regularMap = new CharMap('+', '/');
    public static final CharMap urlsafeMap = new CharMap('-', '_');

    public static String encodeString(String string) {
        return Base64Coder.encodeString(string, false);
    }

    public static String encodeString(String string, boolean bl2) {
        try {
            return new String(Base64Coder.encode(string.getBytes("UTF-8"), bl2 ? Base64Coder.urlsafeMap.encodingMap : Base64Coder.regularMap.encodingMap));
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            return "";
        }
    }

    public static String encodeLines(byte[] byArray) {
        return Base64Coder.encodeLines(byArray, 0, byArray.length, 76, systemLineSeparator, Base64Coder.regularMap.encodingMap);
    }

    public static String encodeLines(byte[] byArray, int n2, int n3, int n4, String string, CharMap charMap) {
        return Base64Coder.encodeLines(byArray, n2, n3, n4, string, charMap.encodingMap);
    }

    public static String encodeLines(byte[] byArray, int n2, int n3, int n4, String string, char[] cArray) {
        int n5;
        int n6 = n4 * 3 / 4;
        if (n6 <= 0) {
            throw new IllegalArgumentException();
        }
        int n7 = (n3 + n6 - 1) / n6;
        int n8 = (n3 + 2) / 3 * 4 + n7 * string.length();
        StringBuilder stringBuilder = new StringBuilder(n8);
        for (int i2 = 0; i2 < n3; i2 += n5) {
            n5 = Math.min(n3 - i2, n6);
            stringBuilder.append(Base64Coder.encode(byArray, n2 + i2, n5, cArray));
            stringBuilder.append(string);
        }
        return stringBuilder.toString();
    }

    public static char[] encode(byte[] byArray) {
        return Base64Coder.encode(byArray, Base64Coder.regularMap.encodingMap);
    }

    public static char[] encode(byte[] byArray, CharMap charMap) {
        return Base64Coder.encode(byArray, 0, byArray.length, charMap);
    }

    public static char[] encode(byte[] byArray, char[] cArray) {
        return Base64Coder.encode(byArray, 0, byArray.length, cArray);
    }

    public static char[] encode(byte[] byArray, int n2) {
        return Base64Coder.encode(byArray, 0, n2, Base64Coder.regularMap.encodingMap);
    }

    public static char[] encode(byte[] byArray, int n2, int n3, CharMap charMap) {
        return Base64Coder.encode(byArray, n2, n3, charMap.encodingMap);
    }

    public static char[] encode(byte[] byArray, int n2, int n3, char[] cArray) {
        int n4 = (n3 * 4 + 2) / 3;
        int n5 = (n3 + 2) / 3 * 4;
        char[] cArray2 = new char[n5];
        int n6 = n2;
        int n7 = n2 + n3;
        int n8 = 0;
        while (n6 < n7) {
            int n9 = byArray[n6++] & 0xFF;
            int n10 = n6 < n7 ? byArray[n6++] & 0xFF : 0;
            int n11 = n6 < n7 ? byArray[n6++] & 0xFF : 0;
            int n12 = n9 >>> 2;
            int n13 = (n9 & 3) << 4 | n10 >>> 4;
            int n14 = (n10 & 0xF) << 2 | n11 >>> 6;
            int n15 = n11 & 0x3F;
            cArray2[n8++] = cArray[n12];
            cArray2[n8++] = cArray[n13];
            cArray2[n8] = n8 < n4 ? cArray[n14] : 61;
            int n16 = ++n8 < n4 ? cArray[n15] : 61;
            cArray2[n8] = n16;
            ++n8;
        }
        return cArray2;
    }

    public static String decodeString(String string) {
        return Base64Coder.decodeString(string, false);
    }

    public static String decodeString(String string, boolean bl2) {
        return new String(Base64Coder.decode(string.toCharArray(), bl2 ? Base64Coder.urlsafeMap.decodingMap : Base64Coder.regularMap.decodingMap));
    }

    public static byte[] decodeLines(String string) {
        return Base64Coder.decodeLines(string, Base64Coder.regularMap.decodingMap);
    }

    public static byte[] decodeLines(String string, CharMap charMap) {
        return Base64Coder.decodeLines(string, charMap.decodingMap);
    }

    public static byte[] decodeLines(String string, byte[] byArray) {
        char[] cArray = new char[string.length()];
        int n2 = 0;
        for (int i2 = 0; i2 < string.length(); ++i2) {
            char c2 = string.charAt(i2);
            if (c2 == ' ' || c2 == '\r' || c2 == '\n' || c2 == '\t') continue;
            cArray[n2++] = c2;
        }
        return Base64Coder.decode(cArray, 0, n2, byArray);
    }

    public static byte[] decode(String string) {
        return Base64Coder.decode(string.toCharArray());
    }

    public static byte[] decode(String string, CharMap charMap) {
        return Base64Coder.decode(string.toCharArray(), charMap);
    }

    public static byte[] decode(char[] cArray, byte[] byArray) {
        return Base64Coder.decode(cArray, 0, cArray.length, byArray);
    }

    public static byte[] decode(char[] cArray, CharMap charMap) {
        return Base64Coder.decode(cArray, 0, cArray.length, charMap);
    }

    public static byte[] decode(char[] cArray) {
        return Base64Coder.decode(cArray, 0, cArray.length, Base64Coder.regularMap.decodingMap);
    }

    public static byte[] decode(char[] cArray, int n2, int n3, CharMap charMap) {
        return Base64Coder.decode(cArray, n2, n3, charMap.decodingMap);
    }

    public static byte[] decode(char[] cArray, int n2, int n3, byte[] byArray) {
        if (n3 % 4 != 0) {
            throw new IllegalArgumentException("Length of Base64 encoded input string is not a multiple of 4.");
        }
        while (n3 > 0 && cArray[n2 + n3 - 1] == '=') {
            --n3;
        }
        int n4 = n3 * 3 / 4;
        byte[] byArray2 = new byte[n4];
        int n5 = n2;
        int n6 = n2 + n3;
        int n7 = 0;
        while (n5 < n6) {
            int n8;
            char c2 = cArray[n5++];
            char c3 = cArray[n5++];
            int n9 = n5 < n6 ? cArray[n5++] : 65;
            int n10 = n8 = n5 < n6 ? cArray[n5++] : 65;
            if (c2 > '\u007f' || c3 > '\u007f' || n9 > 127 || n8 > 127) {
                throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
            }
            byte by2 = byArray[c2];
            byte by3 = byArray[c3];
            byte by4 = byArray[n9];
            byte by5 = byArray[n8];
            if (by2 < 0 || by3 < 0 || by4 < 0 || by5 < 0) {
                throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
            }
            int n11 = by2 << 2 | by3 >>> 4;
            int n12 = (by3 & 0xF) << 4 | by4 >>> 2;
            int n13 = (by4 & 3) << 6 | by5;
            byArray2[n7++] = (byte)n11;
            if (n7 < n4) {
                byArray2[n7++] = (byte)n12;
            }
            if (n7 >= n4) continue;
            byArray2[n7++] = (byte)n13;
        }
        return byArray2;
    }

    private Base64Coder() {
    }

    public static class CharMap {
        protected final char[] encodingMap = new char[64];
        protected final byte[] decodingMap = new byte[128];

        public CharMap(char c2, char c3) {
            int n2;
            int n3 = 0;
            for (n2 = 65; n2 <= 90; n2 = (int)((char)(n2 + 1))) {
                this.encodingMap[n3++] = n2;
            }
            for (n2 = 97; n2 <= 122; n2 = (int)((char)(n2 + 1))) {
                this.encodingMap[n3++] = n2;
            }
            for (n2 = 48; n2 <= 57; n2 = (int)((char)(n2 + 1))) {
                this.encodingMap[n3++] = n2;
            }
            this.encodingMap[n3++] = c2;
            this.encodingMap[n3++] = c3;
            for (n3 = 0; n3 < this.decodingMap.length; ++n3) {
                this.decodingMap[n3] = -1;
            }
            for (n3 = 0; n3 < 64; ++n3) {
                this.decodingMap[this.encodingMap[n3]] = (byte)n3;
            }
        }

        public byte[] getDecodingMap() {
            return this.decodingMap;
        }

        public char[] getEncodingMap() {
            return this.encodingMap;
        }
    }
}

