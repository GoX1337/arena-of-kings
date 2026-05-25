/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3;

import java.util.Random;
import org.apache.commons.lang3.RandomUtils;

public class RandomStringUtils {
    private static final Random RANDOM = new Random();

    public static String random(int n2) {
        return RandomStringUtils.random(n2, false, false);
    }

    public static String randomAscii(int n2) {
        return RandomStringUtils.random(n2, 32, 127, false, false);
    }

    public static String randomAscii(int n2, int n3) {
        return RandomStringUtils.randomAscii(RandomUtils.nextInt(n2, n3));
    }

    public static String randomAlphabetic(int n2) {
        return RandomStringUtils.random(n2, true, false);
    }

    public static String randomAlphabetic(int n2, int n3) {
        return RandomStringUtils.randomAlphabetic(RandomUtils.nextInt(n2, n3));
    }

    public static String randomAlphanumeric(int n2) {
        return RandomStringUtils.random(n2, true, true);
    }

    public static String randomAlphanumeric(int n2, int n3) {
        return RandomStringUtils.randomAlphanumeric(RandomUtils.nextInt(n2, n3));
    }

    public static String randomGraph(int n2) {
        return RandomStringUtils.random(n2, 33, 126, false, false);
    }

    public static String randomGraph(int n2, int n3) {
        return RandomStringUtils.randomGraph(RandomUtils.nextInt(n2, n3));
    }

    public static String randomNumeric(int n2) {
        return RandomStringUtils.random(n2, false, true);
    }

    public static String randomNumeric(int n2, int n3) {
        return RandomStringUtils.randomNumeric(RandomUtils.nextInt(n2, n3));
    }

    public static String randomPrint(int n2) {
        return RandomStringUtils.random(n2, 32, 126, false, false);
    }

    public static String randomPrint(int n2, int n3) {
        return RandomStringUtils.randomPrint(RandomUtils.nextInt(n2, n3));
    }

    public static String random(int n2, boolean bl2, boolean bl3) {
        return RandomStringUtils.random(n2, 0, 0, bl2, bl3);
    }

    public static String random(int n2, int n3, int n4, boolean bl2, boolean bl3) {
        return RandomStringUtils.random(n2, n3, n4, bl2, bl3, null, RANDOM);
    }

    public static String random(int n2, int n3, int n4, boolean bl2, boolean bl3, char ... cArray) {
        return RandomStringUtils.random(n2, n3, n4, bl2, bl3, cArray, RANDOM);
    }

    public static String random(int n2, int n3, int n4, boolean bl2, boolean bl3, char[] cArray, Random random) {
        if (n2 == 0) {
            return "";
        }
        if (n2 < 0) {
            throw new IllegalArgumentException("Requested random string length " + n2 + " is less than 0.");
        }
        if (cArray != null && cArray.length == 0) {
            throw new IllegalArgumentException("The chars array must not be empty");
        }
        if (n3 == 0 && n4 == 0) {
            if (cArray != null) {
                n4 = cArray.length;
            } else if (!bl2 && !bl3) {
                n4 = 0x10FFFF;
            } else {
                n4 = 123;
                n3 = 32;
            }
        } else if (n4 <= n3) {
            throw new IllegalArgumentException("Parameter end (" + n4 + ") must be greater than start (" + n3 + ")");
        }
        int n5 = 48;
        int n6 = 65;
        if (cArray == null && (bl3 && n4 <= 48 || bl2 && n4 <= 65)) {
            throw new IllegalArgumentException("Parameter end (" + n4 + ") must be greater then (" + 48 + ") for generating digits or greater then (" + 65 + ") for generating letters.");
        }
        StringBuilder stringBuilder = new StringBuilder(n2);
        int n7 = n4 - n3;
        block3: while (n2-- != 0) {
            int n8;
            if (cArray == null) {
                n8 = random.nextInt(n7) + n3;
                switch (Character.getType(n8)) {
                    case 0: 
                    case 18: 
                    case 19: {
                        ++n2;
                        continue block3;
                    }
                }
            } else {
                n8 = cArray[random.nextInt(n7) + n3];
            }
            int n9 = Character.charCount(n8);
            if (n2 == 0 && n9 > 1) {
                ++n2;
                continue;
            }
            if (bl2 && Character.isLetter(n8) || bl3 && Character.isDigit(n8) || !bl2 && !bl3) {
                stringBuilder.appendCodePoint(n8);
                if (n9 != 2) continue;
                --n2;
                continue;
            }
            ++n2;
        }
        return stringBuilder.toString();
    }

    public static String random(int n2, String string) {
        if (string == null) {
            return RandomStringUtils.random(n2, 0, 0, false, false, null, RANDOM);
        }
        return RandomStringUtils.random(n2, string.toCharArray());
    }

    public static String random(int n2, char ... cArray) {
        if (cArray == null) {
            return RandomStringUtils.random(n2, 0, 0, false, false, null, RANDOM);
        }
        return RandomStringUtils.random(n2, 0, cArray.length, false, false, cArray, RANDOM);
    }
}

