/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3;

import java.util.UUID;

public class Conversion {
    private static final boolean[] TTTT = new boolean[]{true, true, true, true};
    private static final boolean[] FTTT = new boolean[]{false, true, true, true};
    private static final boolean[] TFTT = new boolean[]{true, false, true, true};
    private static final boolean[] FFTT = new boolean[]{false, false, true, true};
    private static final boolean[] TTFT = new boolean[]{true, true, false, true};
    private static final boolean[] FTFT = new boolean[]{false, true, false, true};
    private static final boolean[] TFFT = new boolean[]{true, false, false, true};
    private static final boolean[] FFFT = new boolean[]{false, false, false, true};
    private static final boolean[] TTTF = new boolean[]{true, true, true, false};
    private static final boolean[] FTTF = new boolean[]{false, true, true, false};
    private static final boolean[] TFTF = new boolean[]{true, false, true, false};
    private static final boolean[] FFTF = new boolean[]{false, false, true, false};
    private static final boolean[] TTFF = new boolean[]{true, true, false, false};
    private static final boolean[] FTFF = new boolean[]{false, true, false, false};
    private static final boolean[] TFFF = new boolean[]{true, false, false, false};
    private static final boolean[] FFFF = new boolean[]{false, false, false, false};

    public static int hexDigitToInt(char c2) {
        int n2 = Character.digit(c2, 16);
        if (n2 < 0) {
            throw new IllegalArgumentException("Cannot interpret '" + c2 + "' as a hexadecimal digit");
        }
        return n2;
    }

    public static int hexDigitMsb0ToInt(char c2) {
        switch (c2) {
            case '0': {
                return 0;
            }
            case '1': {
                return 8;
            }
            case '2': {
                return 4;
            }
            case '3': {
                return 12;
            }
            case '4': {
                return 2;
            }
            case '5': {
                return 10;
            }
            case '6': {
                return 6;
            }
            case '7': {
                return 14;
            }
            case '8': {
                return 1;
            }
            case '9': {
                return 9;
            }
            case 'A': 
            case 'a': {
                return 5;
            }
            case 'B': 
            case 'b': {
                return 13;
            }
            case 'C': 
            case 'c': {
                return 3;
            }
            case 'D': 
            case 'd': {
                return 11;
            }
            case 'E': 
            case 'e': {
                return 7;
            }
            case 'F': 
            case 'f': {
                return 15;
            }
        }
        throw new IllegalArgumentException("Cannot interpret '" + c2 + "' as a hexadecimal digit");
    }

    public static boolean[] hexDigitToBinary(char c2) {
        switch (c2) {
            case '0': {
                return (boolean[])FFFF.clone();
            }
            case '1': {
                return (boolean[])TFFF.clone();
            }
            case '2': {
                return (boolean[])FTFF.clone();
            }
            case '3': {
                return (boolean[])TTFF.clone();
            }
            case '4': {
                return (boolean[])FFTF.clone();
            }
            case '5': {
                return (boolean[])TFTF.clone();
            }
            case '6': {
                return (boolean[])FTTF.clone();
            }
            case '7': {
                return (boolean[])TTTF.clone();
            }
            case '8': {
                return (boolean[])FFFT.clone();
            }
            case '9': {
                return (boolean[])TFFT.clone();
            }
            case 'A': 
            case 'a': {
                return (boolean[])FTFT.clone();
            }
            case 'B': 
            case 'b': {
                return (boolean[])TTFT.clone();
            }
            case 'C': 
            case 'c': {
                return (boolean[])FFTT.clone();
            }
            case 'D': 
            case 'd': {
                return (boolean[])TFTT.clone();
            }
            case 'E': 
            case 'e': {
                return (boolean[])FTTT.clone();
            }
            case 'F': 
            case 'f': {
                return (boolean[])TTTT.clone();
            }
        }
        throw new IllegalArgumentException("Cannot interpret '" + c2 + "' as a hexadecimal digit");
    }

    public static boolean[] hexDigitMsb0ToBinary(char c2) {
        switch (c2) {
            case '0': {
                return (boolean[])FFFF.clone();
            }
            case '1': {
                return (boolean[])FFFT.clone();
            }
            case '2': {
                return (boolean[])FFTF.clone();
            }
            case '3': {
                return (boolean[])FFTT.clone();
            }
            case '4': {
                return (boolean[])FTFF.clone();
            }
            case '5': {
                return (boolean[])FTFT.clone();
            }
            case '6': {
                return (boolean[])FTTF.clone();
            }
            case '7': {
                return (boolean[])FTTT.clone();
            }
            case '8': {
                return (boolean[])TFFF.clone();
            }
            case '9': {
                return (boolean[])TFFT.clone();
            }
            case 'A': 
            case 'a': {
                return (boolean[])TFTF.clone();
            }
            case 'B': 
            case 'b': {
                return (boolean[])TFTT.clone();
            }
            case 'C': 
            case 'c': {
                return (boolean[])TTFF.clone();
            }
            case 'D': 
            case 'd': {
                return (boolean[])TTFT.clone();
            }
            case 'E': 
            case 'e': {
                return (boolean[])TTTF.clone();
            }
            case 'F': 
            case 'f': {
                return (boolean[])TTTT.clone();
            }
        }
        throw new IllegalArgumentException("Cannot interpret '" + c2 + "' as a hexadecimal digit");
    }

    public static char binaryToHexDigit(boolean[] blArray) {
        return Conversion.binaryToHexDigit(blArray, 0);
    }

    public static char binaryToHexDigit(boolean[] blArray, int n2) {
        if (blArray.length == 0) {
            throw new IllegalArgumentException("Cannot convert an empty array.");
        }
        if (blArray.length > n2 + 3 && blArray[n2 + 3]) {
            if (blArray[n2 + 2]) {
                if (blArray[n2 + 1]) {
                    return blArray[n2] ? (char)'f' : 'e';
                }
                return blArray[n2] ? (char)'d' : 'c';
            }
            if (blArray[n2 + 1]) {
                return blArray[n2] ? (char)'b' : 'a';
            }
            return blArray[n2] ? (char)'9' : '8';
        }
        if (blArray.length > n2 + 2 && blArray[n2 + 2]) {
            if (blArray[n2 + 1]) {
                return blArray[n2] ? (char)'7' : '6';
            }
            return blArray[n2] ? (char)'5' : '4';
        }
        if (blArray.length > n2 + 1 && blArray[n2 + 1]) {
            return blArray[n2] ? (char)'3' : '2';
        }
        return blArray[n2] ? (char)'1' : '0';
    }

    public static char binaryToHexDigitMsb0_4bits(boolean[] blArray) {
        return Conversion.binaryToHexDigitMsb0_4bits(blArray, 0);
    }

    public static char binaryToHexDigitMsb0_4bits(boolean[] blArray, int n2) {
        if (blArray.length > 8) {
            throw new IllegalArgumentException("src.length>8: src.length=" + blArray.length);
        }
        if (blArray.length - n2 < 4) {
            throw new IllegalArgumentException("src.length-srcPos<4: src.length=" + blArray.length + ", srcPos=" + n2);
        }
        if (blArray[n2 + 3]) {
            if (blArray[n2 + 2]) {
                if (blArray[n2 + 1]) {
                    return blArray[n2] ? (char)'f' : '7';
                }
                return blArray[n2] ? (char)'b' : '3';
            }
            if (blArray[n2 + 1]) {
                return blArray[n2] ? (char)'d' : '5';
            }
            return blArray[n2] ? (char)'9' : '1';
        }
        if (blArray[n2 + 2]) {
            if (blArray[n2 + 1]) {
                return blArray[n2] ? (char)'e' : '6';
            }
            return blArray[n2] ? (char)'a' : '2';
        }
        if (blArray[n2 + 1]) {
            return blArray[n2] ? (char)'c' : '4';
        }
        return blArray[n2] ? (char)'8' : '0';
    }

    public static char binaryBeMsb0ToHexDigit(boolean[] blArray) {
        return Conversion.binaryBeMsb0ToHexDigit(blArray, 0);
    }

    public static char binaryBeMsb0ToHexDigit(boolean[] blArray, int n2) {
        if (blArray.length == 0) {
            throw new IllegalArgumentException("Cannot convert an empty array.");
        }
        int n3 = blArray.length - 1 - n2;
        int n4 = Math.min(4, n3 + 1);
        boolean[] blArray2 = new boolean[4];
        System.arraycopy(blArray, n3 + 1 - n4, blArray2, 4 - n4, n4);
        blArray = blArray2;
        n2 = 0;
        if (blArray[n2]) {
            if (blArray.length > n2 + 1 && blArray[n2 + 1]) {
                if (blArray.length > n2 + 2 && blArray[n2 + 2]) {
                    return (char)(blArray.length > n2 + 3 && blArray[n2 + 3] ? 102 : 101);
                }
                return (char)(blArray.length > n2 + 3 && blArray[n2 + 3] ? 100 : 99);
            }
            if (blArray.length > n2 + 2 && blArray[n2 + 2]) {
                return (char)(blArray.length > n2 + 3 && blArray[n2 + 3] ? 98 : 97);
            }
            return (char)(blArray.length > n2 + 3 && blArray[n2 + 3] ? 57 : 56);
        }
        if (blArray.length > n2 + 1 && blArray[n2 + 1]) {
            if (blArray.length > n2 + 2 && blArray[n2 + 2]) {
                return (char)(blArray.length > n2 + 3 && blArray[n2 + 3] ? 55 : 54);
            }
            return (char)(blArray.length > n2 + 3 && blArray[n2 + 3] ? 53 : 52);
        }
        if (blArray.length > n2 + 2 && blArray[n2 + 2]) {
            return (char)(blArray.length > n2 + 3 && blArray[n2 + 3] ? 51 : 50);
        }
        return (char)(blArray.length > n2 + 3 && blArray[n2 + 3] ? 49 : 48);
    }

    public static char intToHexDigit(int n2) {
        char c2 = Character.forDigit(n2, 16);
        if (c2 == '\u0000') {
            throw new IllegalArgumentException("nibble value not between 0 and 15: " + n2);
        }
        return c2;
    }

    public static char intToHexDigitMsb0(int n2) {
        switch (n2) {
            case 0: {
                return '0';
            }
            case 1: {
                return '8';
            }
            case 2: {
                return '4';
            }
            case 3: {
                return 'c';
            }
            case 4: {
                return '2';
            }
            case 5: {
                return 'a';
            }
            case 6: {
                return '6';
            }
            case 7: {
                return 'e';
            }
            case 8: {
                return '1';
            }
            case 9: {
                return '9';
            }
            case 10: {
                return '5';
            }
            case 11: {
                return 'd';
            }
            case 12: {
                return '3';
            }
            case 13: {
                return 'b';
            }
            case 14: {
                return '7';
            }
            case 15: {
                return 'f';
            }
        }
        throw new IllegalArgumentException("nibble value not between 0 and 15: " + n2);
    }

    public static long intArrayToLong(int[] nArray, int n2, long l2, int n3, int n4) {
        if (nArray.length == 0 && n2 == 0 || 0 == n4) {
            return l2;
        }
        if ((n4 - 1) * 32 + n3 >= 64) {
            throw new IllegalArgumentException("(nInts-1)*32+dstPos is greater or equal to than 64");
        }
        long l3 = l2;
        for (int i2 = 0; i2 < n4; ++i2) {
            int n5 = i2 * 32 + n3;
            long l4 = (0xFFFFFFFFL & (long)nArray[i2 + n2]) << n5;
            long l5 = 0xFFFFFFFFL << n5;
            l3 = l3 & (l5 ^ 0xFFFFFFFFFFFFFFFFL) | l4;
        }
        return l3;
    }

    public static long shortArrayToLong(short[] sArray, int n2, long l2, int n3, int n4) {
        if (sArray.length == 0 && n2 == 0 || 0 == n4) {
            return l2;
        }
        if ((n4 - 1) * 16 + n3 >= 64) {
            throw new IllegalArgumentException("(nShorts-1)*16+dstPos is greater or equal to than 64");
        }
        long l3 = l2;
        for (int i2 = 0; i2 < n4; ++i2) {
            int n5 = i2 * 16 + n3;
            long l4 = (0xFFFFL & (long)sArray[i2 + n2]) << n5;
            long l5 = 65535L << n5;
            l3 = l3 & (l5 ^ 0xFFFFFFFFFFFFFFFFL) | l4;
        }
        return l3;
    }

    public static int shortArrayToInt(short[] sArray, int n2, int n3, int n4, int n5) {
        if (sArray.length == 0 && n2 == 0 || 0 == n5) {
            return n3;
        }
        if ((n5 - 1) * 16 + n4 >= 32) {
            throw new IllegalArgumentException("(nShorts-1)*16+dstPos is greater or equal to than 32");
        }
        int n6 = n3;
        for (int i2 = 0; i2 < n5; ++i2) {
            int n7 = i2 * 16 + n4;
            int n8 = (0xFFFF & sArray[i2 + n2]) << n7;
            int n9 = 65535 << n7;
            n6 = n6 & ~n9 | n8;
        }
        return n6;
    }

    public static long byteArrayToLong(byte[] byArray, int n2, long l2, int n3, int n4) {
        if (byArray.length == 0 && n2 == 0 || 0 == n4) {
            return l2;
        }
        if ((n4 - 1) * 8 + n3 >= 64) {
            throw new IllegalArgumentException("(nBytes-1)*8+dstPos is greater or equal to than 64");
        }
        long l3 = l2;
        for (int i2 = 0; i2 < n4; ++i2) {
            int n5 = i2 * 8 + n3;
            long l4 = (0xFFL & (long)byArray[i2 + n2]) << n5;
            long l5 = 255L << n5;
            l3 = l3 & (l5 ^ 0xFFFFFFFFFFFFFFFFL) | l4;
        }
        return l3;
    }

    public static int byteArrayToInt(byte[] byArray, int n2, int n3, int n4, int n5) {
        if (byArray.length == 0 && n2 == 0 || 0 == n5) {
            return n3;
        }
        if ((n5 - 1) * 8 + n4 >= 32) {
            throw new IllegalArgumentException("(nBytes-1)*8+dstPos is greater or equal to than 32");
        }
        int n6 = n3;
        for (int i2 = 0; i2 < n5; ++i2) {
            int n7 = i2 * 8 + n4;
            int n8 = (0xFF & byArray[i2 + n2]) << n7;
            int n9 = 255 << n7;
            n6 = n6 & ~n9 | n8;
        }
        return n6;
    }

    public static short byteArrayToShort(byte[] byArray, int n2, short s2, int n3, int n4) {
        if (byArray.length == 0 && n2 == 0 || 0 == n4) {
            return s2;
        }
        if ((n4 - 1) * 8 + n3 >= 16) {
            throw new IllegalArgumentException("(nBytes-1)*8+dstPos is greater or equal to than 16");
        }
        short s3 = s2;
        for (int i2 = 0; i2 < n4; ++i2) {
            int n5 = i2 * 8 + n3;
            int n6 = (0xFF & byArray[i2 + n2]) << n5;
            int n7 = 255 << n5;
            s3 = (short)(s3 & ~n7 | n6);
        }
        return s3;
    }

    public static long hexToLong(String string, int n2, long l2, int n3, int n4) {
        if (0 == n4) {
            return l2;
        }
        if ((n4 - 1) * 4 + n3 >= 64) {
            throw new IllegalArgumentException("(nHexs-1)*4+dstPos is greater or equal to than 64");
        }
        long l3 = l2;
        for (int i2 = 0; i2 < n4; ++i2) {
            int n5 = i2 * 4 + n3;
            long l4 = (0xFL & (long)Conversion.hexDigitToInt(string.charAt(i2 + n2))) << n5;
            long l5 = 15L << n5;
            l3 = l3 & (l5 ^ 0xFFFFFFFFFFFFFFFFL) | l4;
        }
        return l3;
    }

    public static int hexToInt(String string, int n2, int n3, int n4, int n5) {
        if (0 == n5) {
            return n3;
        }
        if ((n5 - 1) * 4 + n4 >= 32) {
            throw new IllegalArgumentException("(nHexs-1)*4+dstPos is greater or equal to than 32");
        }
        int n6 = n3;
        for (int i2 = 0; i2 < n5; ++i2) {
            int n7 = i2 * 4 + n4;
            int n8 = (0xF & Conversion.hexDigitToInt(string.charAt(i2 + n2))) << n7;
            int n9 = 15 << n7;
            n6 = n6 & ~n9 | n8;
        }
        return n6;
    }

    public static short hexToShort(String string, int n2, short s2, int n3, int n4) {
        if (0 == n4) {
            return s2;
        }
        if ((n4 - 1) * 4 + n3 >= 16) {
            throw new IllegalArgumentException("(nHexs-1)*4+dstPos is greater or equal to than 16");
        }
        short s3 = s2;
        for (int i2 = 0; i2 < n4; ++i2) {
            int n5 = i2 * 4 + n3;
            int n6 = (0xF & Conversion.hexDigitToInt(string.charAt(i2 + n2))) << n5;
            int n7 = 15 << n5;
            s3 = (short)(s3 & ~n7 | n6);
        }
        return s3;
    }

    public static byte hexToByte(String string, int n2, byte by2, int n3, int n4) {
        if (0 == n4) {
            return by2;
        }
        if ((n4 - 1) * 4 + n3 >= 8) {
            throw new IllegalArgumentException("(nHexs-1)*4+dstPos is greater or equal to than 8");
        }
        byte by3 = by2;
        for (int i2 = 0; i2 < n4; ++i2) {
            int n5 = i2 * 4 + n3;
            int n6 = (0xF & Conversion.hexDigitToInt(string.charAt(i2 + n2))) << n5;
            int n7 = 15 << n5;
            by3 = (byte)(by3 & ~n7 | n6);
        }
        return by3;
    }

    public static long binaryToLong(boolean[] blArray, int n2, long l2, int n3, int n4) {
        if (blArray.length == 0 && n2 == 0 || 0 == n4) {
            return l2;
        }
        if (n4 - 1 + n3 >= 64) {
            throw new IllegalArgumentException("nBools-1+dstPos is greater or equal to than 64");
        }
        long l3 = l2;
        for (int i2 = 0; i2 < n4; ++i2) {
            int n5 = i2 + n3;
            long l4 = (blArray[i2 + n2] ? 1L : 0L) << n5;
            long l5 = 1L << n5;
            l3 = l3 & (l5 ^ 0xFFFFFFFFFFFFFFFFL) | l4;
        }
        return l3;
    }

    public static int binaryToInt(boolean[] blArray, int n2, int n3, int n4, int n5) {
        if (blArray.length == 0 && n2 == 0 || 0 == n5) {
            return n3;
        }
        if (n5 - 1 + n4 >= 32) {
            throw new IllegalArgumentException("nBools-1+dstPos is greater or equal to than 32");
        }
        int n6 = n3;
        for (int i2 = 0; i2 < n5; ++i2) {
            int n7 = i2 + n4;
            int n8 = (blArray[i2 + n2] ? 1 : 0) << n7;
            int n9 = 1 << n7;
            n6 = n6 & ~n9 | n8;
        }
        return n6;
    }

    public static short binaryToShort(boolean[] blArray, int n2, short s2, int n3, int n4) {
        if (blArray.length == 0 && n2 == 0 || 0 == n4) {
            return s2;
        }
        if (n4 - 1 + n3 >= 16) {
            throw new IllegalArgumentException("nBools-1+dstPos is greater or equal to than 16");
        }
        short s3 = s2;
        for (int i2 = 0; i2 < n4; ++i2) {
            int n5 = i2 + n3;
            int n6 = (blArray[i2 + n2] ? 1 : 0) << n5;
            int n7 = 1 << n5;
            s3 = (short)(s3 & ~n7 | n6);
        }
        return s3;
    }

    public static byte binaryToByte(boolean[] blArray, int n2, byte by2, int n3, int n4) {
        if (blArray.length == 0 && n2 == 0 || 0 == n4) {
            return by2;
        }
        if (n4 - 1 + n3 >= 8) {
            throw new IllegalArgumentException("nBools-1+dstPos is greater or equal to than 8");
        }
        byte by3 = by2;
        for (int i2 = 0; i2 < n4; ++i2) {
            int n5 = i2 + n3;
            int n6 = (blArray[i2 + n2] ? 1 : 0) << n5;
            int n7 = 1 << n5;
            by3 = (byte)(by3 & ~n7 | n6);
        }
        return by3;
    }

    public static int[] longToIntArray(long l2, int n2, int[] nArray, int n3, int n4) {
        if (0 == n4) {
            return nArray;
        }
        if ((n4 - 1) * 32 + n2 >= 64) {
            throw new IllegalArgumentException("(nInts-1)*32+srcPos is greater or equal to than 64");
        }
        for (int i2 = 0; i2 < n4; ++i2) {
            int n5 = i2 * 32 + n2;
            nArray[n3 + i2] = (int)(0xFFFFFFFFFFFFFFFFL & l2 >> n5);
        }
        return nArray;
    }

    public static short[] longToShortArray(long l2, int n2, short[] sArray, int n3, int n4) {
        if (0 == n4) {
            return sArray;
        }
        if ((n4 - 1) * 16 + n2 >= 64) {
            throw new IllegalArgumentException("(nShorts-1)*16+srcPos is greater or equal to than 64");
        }
        for (int i2 = 0; i2 < n4; ++i2) {
            int n5 = i2 * 16 + n2;
            sArray[n3 + i2] = (short)(0xFFFFL & l2 >> n5);
        }
        return sArray;
    }

    public static short[] intToShortArray(int n2, int n3, short[] sArray, int n4, int n5) {
        if (0 == n5) {
            return sArray;
        }
        if ((n5 - 1) * 16 + n3 >= 32) {
            throw new IllegalArgumentException("(nShorts-1)*16+srcPos is greater or equal to than 32");
        }
        for (int i2 = 0; i2 < n5; ++i2) {
            int n6 = i2 * 16 + n3;
            sArray[n4 + i2] = (short)(0xFFFF & n2 >> n6);
        }
        return sArray;
    }

    public static byte[] longToByteArray(long l2, int n2, byte[] byArray, int n3, int n4) {
        if (0 == n4) {
            return byArray;
        }
        if ((n4 - 1) * 8 + n2 >= 64) {
            throw new IllegalArgumentException("(nBytes-1)*8+srcPos is greater or equal to than 64");
        }
        for (int i2 = 0; i2 < n4; ++i2) {
            int n5 = i2 * 8 + n2;
            byArray[n3 + i2] = (byte)(0xFFL & l2 >> n5);
        }
        return byArray;
    }

    public static byte[] intToByteArray(int n2, int n3, byte[] byArray, int n4, int n5) {
        if (0 == n5) {
            return byArray;
        }
        if ((n5 - 1) * 8 + n3 >= 32) {
            throw new IllegalArgumentException("(nBytes-1)*8+srcPos is greater or equal to than 32");
        }
        for (int i2 = 0; i2 < n5; ++i2) {
            int n6 = i2 * 8 + n3;
            byArray[n4 + i2] = (byte)(0xFF & n2 >> n6);
        }
        return byArray;
    }

    public static byte[] shortToByteArray(short s2, int n2, byte[] byArray, int n3, int n4) {
        if (0 == n4) {
            return byArray;
        }
        if ((n4 - 1) * 8 + n2 >= 16) {
            throw new IllegalArgumentException("(nBytes-1)*8+srcPos is greater or equal to than 16");
        }
        for (int i2 = 0; i2 < n4; ++i2) {
            int n5 = i2 * 8 + n2;
            byArray[n3 + i2] = (byte)(0xFF & s2 >> n5);
        }
        return byArray;
    }

    public static String longToHex(long l2, int n2, String string, int n3, int n4) {
        if (0 == n4) {
            return string;
        }
        if ((n4 - 1) * 4 + n2 >= 64) {
            throw new IllegalArgumentException("(nHexs-1)*4+srcPos is greater or equal to than 64");
        }
        StringBuilder stringBuilder = new StringBuilder(string);
        int n5 = stringBuilder.length();
        for (int i2 = 0; i2 < n4; ++i2) {
            int n6 = i2 * 4 + n2;
            int n7 = (int)(0xFL & l2 >> n6);
            if (n3 + i2 == n5) {
                ++n5;
                stringBuilder.append(Conversion.intToHexDigit(n7));
                continue;
            }
            stringBuilder.setCharAt(n3 + i2, Conversion.intToHexDigit(n7));
        }
        return stringBuilder.toString();
    }

    public static String intToHex(int n2, int n3, String string, int n4, int n5) {
        if (0 == n5) {
            return string;
        }
        if ((n5 - 1) * 4 + n3 >= 32) {
            throw new IllegalArgumentException("(nHexs-1)*4+srcPos is greater or equal to than 32");
        }
        StringBuilder stringBuilder = new StringBuilder(string);
        int n6 = stringBuilder.length();
        for (int i2 = 0; i2 < n5; ++i2) {
            int n7 = i2 * 4 + n3;
            int n8 = 0xF & n2 >> n7;
            if (n4 + i2 == n6) {
                ++n6;
                stringBuilder.append(Conversion.intToHexDigit(n8));
                continue;
            }
            stringBuilder.setCharAt(n4 + i2, Conversion.intToHexDigit(n8));
        }
        return stringBuilder.toString();
    }

    public static String shortToHex(short s2, int n2, String string, int n3, int n4) {
        if (0 == n4) {
            return string;
        }
        if ((n4 - 1) * 4 + n2 >= 16) {
            throw new IllegalArgumentException("(nHexs-1)*4+srcPos is greater or equal to than 16");
        }
        StringBuilder stringBuilder = new StringBuilder(string);
        int n5 = stringBuilder.length();
        for (int i2 = 0; i2 < n4; ++i2) {
            int n6 = i2 * 4 + n2;
            int n7 = 0xF & s2 >> n6;
            if (n3 + i2 == n5) {
                ++n5;
                stringBuilder.append(Conversion.intToHexDigit(n7));
                continue;
            }
            stringBuilder.setCharAt(n3 + i2, Conversion.intToHexDigit(n7));
        }
        return stringBuilder.toString();
    }

    public static String byteToHex(byte by2, int n2, String string, int n3, int n4) {
        if (0 == n4) {
            return string;
        }
        if ((n4 - 1) * 4 + n2 >= 8) {
            throw new IllegalArgumentException("(nHexs-1)*4+srcPos is greater or equal to than 8");
        }
        StringBuilder stringBuilder = new StringBuilder(string);
        int n5 = stringBuilder.length();
        for (int i2 = 0; i2 < n4; ++i2) {
            int n6 = i2 * 4 + n2;
            int n7 = 0xF & by2 >> n6;
            if (n3 + i2 == n5) {
                ++n5;
                stringBuilder.append(Conversion.intToHexDigit(n7));
                continue;
            }
            stringBuilder.setCharAt(n3 + i2, Conversion.intToHexDigit(n7));
        }
        return stringBuilder.toString();
    }

    public static boolean[] longToBinary(long l2, int n2, boolean[] blArray, int n3, int n4) {
        if (0 == n4) {
            return blArray;
        }
        if (n4 - 1 + n2 >= 64) {
            throw new IllegalArgumentException("nBools-1+srcPos is greater or equal to than 64");
        }
        for (int i2 = 0; i2 < n4; ++i2) {
            int n5 = i2 + n2;
            blArray[n3 + i2] = (1L & l2 >> n5) != 0L;
        }
        return blArray;
    }

    public static boolean[] intToBinary(int n2, int n3, boolean[] blArray, int n4, int n5) {
        if (0 == n5) {
            return blArray;
        }
        if (n5 - 1 + n3 >= 32) {
            throw new IllegalArgumentException("nBools-1+srcPos is greater or equal to than 32");
        }
        for (int i2 = 0; i2 < n5; ++i2) {
            int n6 = i2 + n3;
            blArray[n4 + i2] = (1 & n2 >> n6) != 0;
        }
        return blArray;
    }

    public static boolean[] shortToBinary(short s2, int n2, boolean[] blArray, int n3, int n4) {
        if (0 == n4) {
            return blArray;
        }
        if (n4 - 1 + n2 >= 16) {
            throw new IllegalArgumentException("nBools-1+srcPos is greater or equal to than 16");
        }
        assert (n4 - 1 < 16 - n2);
        for (int i2 = 0; i2 < n4; ++i2) {
            int n5 = i2 + n2;
            blArray[n3 + i2] = (1 & s2 >> n5) != 0;
        }
        return blArray;
    }

    public static boolean[] byteToBinary(byte by2, int n2, boolean[] blArray, int n3, int n4) {
        if (0 == n4) {
            return blArray;
        }
        if (n4 - 1 + n2 >= 8) {
            throw new IllegalArgumentException("nBools-1+srcPos is greater or equal to than 8");
        }
        for (int i2 = 0; i2 < n4; ++i2) {
            int n5 = i2 + n2;
            blArray[n3 + i2] = (1 & by2 >> n5) != 0;
        }
        return blArray;
    }

    public static byte[] uuidToByteArray(UUID uUID, byte[] byArray, int n2, int n3) {
        if (0 == n3) {
            return byArray;
        }
        if (n3 > 16) {
            throw new IllegalArgumentException("nBytes is greater than 16");
        }
        Conversion.longToByteArray(uUID.getMostSignificantBits(), 0, byArray, n2, Math.min(n3, 8));
        if (n3 >= 8) {
            Conversion.longToByteArray(uUID.getLeastSignificantBits(), 0, byArray, n2 + 8, n3 - 8);
        }
        return byArray;
    }

    public static UUID byteArrayToUuid(byte[] byArray, int n2) {
        if (byArray.length - n2 < 16) {
            throw new IllegalArgumentException("Need at least 16 bytes for UUID");
        }
        return new UUID(Conversion.byteArrayToLong(byArray, n2, 0L, 0, 8), Conversion.byteArrayToLong(byArray, n2 + 8, 0L, 0, 8));
    }
}

