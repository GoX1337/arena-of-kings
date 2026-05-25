/*
 * Decompiled with CFR 0.152.
 */
package com.sun.jna;

import com.sun.jna.FromNativeContext;
import com.sun.jna.Klass;
import com.sun.jna.NativeMapped;
import com.sun.jna.Pointer;
import com.sun.jna.ToNativeContext;
import com.sun.jna.TypeConverter;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.WeakHashMap;

public class NativeMappedConverter
implements TypeConverter {
    private static final Map<Class<?>, Reference<NativeMappedConverter>> converters = new WeakHashMap();
    private final Class<?> type;
    private final Class<?> nativeType;
    private final NativeMapped instance;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static NativeMappedConverter getInstance(Class<?> clazz) {
        Map<Class<?>, Reference<NativeMappedConverter>> map = converters;
        synchronized (map) {
            NativeMappedConverter nativeMappedConverter;
            Reference<NativeMappedConverter> reference = converters.get(clazz);
            NativeMappedConverter nativeMappedConverter2 = nativeMappedConverter = reference != null ? reference.get() : null;
            if (nativeMappedConverter == null) {
                nativeMappedConverter = new NativeMappedConverter(clazz);
                converters.put(clazz, new SoftReference<NativeMappedConverter>(nativeMappedConverter));
            }
            return nativeMappedConverter;
        }
    }

    public NativeMappedConverter(Class<?> clazz) {
        if (!NativeMapped.class.isAssignableFrom(clazz)) {
            throw new IllegalArgumentException("Type must derive from " + NativeMapped.class);
        }
        this.type = clazz;
        this.instance = this.defaultValue();
        this.nativeType = this.instance.nativeType();
    }

    public NativeMapped defaultValue() {
        if (this.type.isEnum()) {
            return (NativeMapped)this.type.getEnumConstants()[0];
        }
        return (NativeMapped)Klass.newInstance(this.type);
    }

    @Override
    public Object fromNative(Object object, FromNativeContext fromNativeContext) {
        return this.instance.fromNative(object, fromNativeContext);
    }

    @Override
    public Class<?> nativeType() {
        return this.nativeType;
    }

    @Override
    public Object toNative(Object object, ToNativeContext toNativeContext) {
        if (object == null) {
            if (Pointer.class.isAssignableFrom(this.nativeType)) {
                return null;
            }
            object = this.defaultValue();
        }
        return ((NativeMapped)object).toNative();
    }
}

