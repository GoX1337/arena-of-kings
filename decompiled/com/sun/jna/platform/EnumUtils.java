/*
 * Decompiled with CFR 0.152.
 */
package com.sun.jna.platform;

import com.sun.jna.platform.win32.FlagEnum;
import java.util.HashSet;
import java.util.Set;

public class EnumUtils {
    public static final int UNINITIALIZED = -1;

    public static <E extends Enum<E>> int toInteger(E e2) {
        Enum[] enumArray = (Enum[])e2.getClass().getEnumConstants();
        for (int i2 = 0; i2 < enumArray.length; ++i2) {
            if (enumArray[i2] != e2) continue;
            return i2;
        }
        throw new IllegalArgumentException();
    }

    public static <E extends Enum<E>> E fromInteger(int n2, Class<E> clazz) {
        if (n2 == -1) {
            return null;
        }
        Enum[] enumArray = (Enum[])clazz.getEnumConstants();
        return (E)enumArray[n2];
    }

    public static <T extends FlagEnum> Set<T> setFromInteger(int n2, Class<T> clazz) {
        FlagEnum[] flagEnumArray = (FlagEnum[])clazz.getEnumConstants();
        HashSet<FlagEnum> hashSet = new HashSet<FlagEnum>();
        for (FlagEnum flagEnum : flagEnumArray) {
            if ((n2 & flagEnum.getFlag()) == 0) continue;
            hashSet.add(flagEnum);
        }
        return hashSet;
    }

    public static <T extends FlagEnum> int setToInteger(Set<T> set) {
        int n2 = 0;
        for (FlagEnum flagEnum : set) {
            n2 |= flagEnum.getFlag();
        }
        return n2;
    }
}

