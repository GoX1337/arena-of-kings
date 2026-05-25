/*
 * Decompiled with CFR 0.152.
 */
package com.sun.jna.platform;

import com.sun.jna.FromNativeContext;
import com.sun.jna.ToNativeContext;
import com.sun.jna.TypeConverter;

public class EnumConverter<T extends Enum<T>>
implements TypeConverter {
    private final Class<T> clazz;

    public EnumConverter(Class<T> clazz) {
        this.clazz = clazz;
    }

    public T fromNative(Object object, FromNativeContext fromNativeContext) {
        Integer n2 = (Integer)object;
        Enum[] enumArray = (Enum[])this.clazz.getEnumConstants();
        return (T)enumArray[n2];
    }

    @Override
    public Integer toNative(Object object, ToNativeContext toNativeContext) {
        Enum enum_ = (Enum)this.clazz.cast(object);
        return enum_.ordinal();
    }

    public Class<Integer> nativeType() {
        return Integer.class;
    }
}

