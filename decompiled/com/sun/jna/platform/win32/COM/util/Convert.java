/*
 * Decompiled with CFR 0.152.
 */
package com.sun.jna.platform.win32.COM.util;

import com.sun.jna.platform.win32.COM.Dispatch;
import com.sun.jna.platform.win32.COM.IUnknown;
import com.sun.jna.platform.win32.COM.util.IComEnum;
import com.sun.jna.platform.win32.COM.util.IDispatch;
import com.sun.jna.platform.win32.COM.util.ObjectFactory;
import com.sun.jna.platform.win32.COM.util.ProxyObject;
import com.sun.jna.platform.win32.OaIdl;
import com.sun.jna.platform.win32.OleAuto;
import com.sun.jna.platform.win32.Variant;
import com.sun.jna.platform.win32.WTypes;
import com.sun.jna.platform.win32.WinDef;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Date;

class Convert {
    Convert() {
    }

    public static Variant.VARIANT toVariant(Object object) {
        if (object instanceof Variant.VARIANT) {
            return (Variant.VARIANT)object;
        }
        if (object instanceof Byte) {
            return new Variant.VARIANT((Byte)object);
        }
        if (object instanceof Character) {
            return new Variant.VARIANT(((Character)object).charValue());
        }
        if (object instanceof Short) {
            return new Variant.VARIANT((Short)object);
        }
        if (object instanceof Integer) {
            return new Variant.VARIANT((Integer)object);
        }
        if (object instanceof Long) {
            return new Variant.VARIANT((Long)object);
        }
        if (object instanceof Float) {
            return new Variant.VARIANT(((Float)object).floatValue());
        }
        if (object instanceof Double) {
            return new Variant.VARIANT((Double)object);
        }
        if (object instanceof String) {
            return new Variant.VARIANT((String)object);
        }
        if (object instanceof Boolean) {
            return new Variant.VARIANT((Boolean)object);
        }
        if (object instanceof Dispatch) {
            return new Variant.VARIANT((Dispatch)object);
        }
        if (object instanceof Date) {
            return new Variant.VARIANT((Date)object);
        }
        if (object instanceof Proxy) {
            InvocationHandler invocationHandler = Proxy.getInvocationHandler(object);
            ProxyObject proxyObject = (ProxyObject)invocationHandler;
            return new Variant.VARIANT(proxyObject.getRawDispatch());
        }
        if (object instanceof IComEnum) {
            IComEnum iComEnum = (IComEnum)object;
            return new Variant.VARIANT(new WinDef.LONG(iComEnum.getValue()));
        }
        Constructor<?> constructor = null;
        if (object != null) {
            for (Constructor<?> constructor2 : Variant.VARIANT.class.getConstructors()) {
                Class<?>[] classArray = constructor2.getParameterTypes();
                if (classArray.length != 1 || !classArray[0].isAssignableFrom(object.getClass())) continue;
                constructor = constructor2;
            }
        }
        if (constructor != null) {
            try {
                return (Variant.VARIANT)constructor.newInstance(object);
            }
            catch (Exception exception) {
                throw new RuntimeException(exception);
            }
        }
        return null;
    }

    public static Object toJavaObject(Variant.VARIANT vARIANT, Class<?> clazz, ObjectFactory objectFactory, boolean bl2, boolean bl3) {
        Object object;
        Object object2;
        int n2;
        int n3 = n2 = vARIANT != null ? vARIANT.getVarType().intValue() : 1;
        if (n2 == 0 || n2 == 1) {
            return null;
        }
        if (clazz != null && !clazz.isAssignableFrom(Object.class)) {
            if (clazz.isAssignableFrom(vARIANT.getClass())) {
                return vARIANT;
            }
            object2 = vARIANT.getValue();
            if (object2 != null && clazz.isAssignableFrom(object2.getClass())) {
                return object2;
            }
        }
        object2 = vARIANT;
        if (n2 == 16396) {
            vARIANT = (Variant.VARIANT)vARIANT.getValue();
            n2 = vARIANT.getVarType().intValue();
        }
        if (clazz == null || clazz.isAssignableFrom(Object.class)) {
            clazz = null;
            switch (n2) {
                case 16: 
                case 17: {
                    clazz = Byte.class;
                    break;
                }
                case 2: {
                    clazz = Short.class;
                    break;
                }
                case 18: {
                    clazz = Character.class;
                    break;
                }
                case 3: 
                case 19: 
                case 22: 
                case 23: {
                    clazz = Integer.class;
                    break;
                }
                case 20: 
                case 21: {
                    clazz = Long.class;
                    break;
                }
                case 4: {
                    clazz = Float.class;
                    break;
                }
                case 5: {
                    clazz = Double.class;
                    break;
                }
                case 11: {
                    clazz = Boolean.class;
                    break;
                }
                case 10: {
                    clazz = WinDef.SCODE.class;
                    break;
                }
                case 6: {
                    clazz = OaIdl.CURRENCY.class;
                    break;
                }
                case 7: {
                    clazz = Date.class;
                    break;
                }
                case 8: {
                    clazz = String.class;
                    break;
                }
                case 13: {
                    clazz = IUnknown.class;
                    break;
                }
                case 9: {
                    clazz = IDispatch.class;
                    break;
                }
                case 16396: {
                    clazz = Variant.class;
                    break;
                }
                case 16384: {
                    clazz = WinDef.PVOID.class;
                    break;
                }
                case 16398: {
                    clazz = OaIdl.DECIMAL.class;
                    break;
                }
                default: {
                    if ((n2 & 0x2000) <= 0) break;
                    clazz = OaIdl.SAFEARRAY.class;
                }
            }
        }
        if (Byte.class.equals(clazz) || Byte.TYPE.equals(clazz)) {
            object = vARIANT.byteValue();
        } else if (Short.class.equals(clazz) || Short.TYPE.equals(clazz)) {
            object = vARIANT.shortValue();
        } else if (Character.class.equals(clazz) || Character.TYPE.equals(clazz)) {
            object = Character.valueOf((char)vARIANT.intValue());
        } else if (Integer.class.equals(clazz) || Integer.TYPE.equals(clazz)) {
            object = vARIANT.intValue();
        } else if (Long.class.equals(clazz) || Long.TYPE.equals(clazz) || IComEnum.class.isAssignableFrom(clazz)) {
            object = vARIANT.longValue();
        } else if (Float.class.equals(clazz) || Float.TYPE.equals(clazz)) {
            object = Float.valueOf(vARIANT.floatValue());
        } else if (Double.class.equals(clazz) || Double.TYPE.equals(clazz)) {
            object = vARIANT.doubleValue();
        } else if (Boolean.class.equals(clazz) || Boolean.TYPE.equals(clazz)) {
            object = vARIANT.booleanValue();
        } else if (Date.class.equals(clazz)) {
            object = vARIANT.dateValue();
        } else if (String.class.equals(clazz)) {
            object = vARIANT.stringValue();
        } else {
            object = vARIANT.getValue();
            if (object instanceof Dispatch) {
                Dispatch dispatch = (Dispatch)object;
                if (clazz != null && clazz.isInterface()) {
                    Object object3 = objectFactory.createProxy(clazz, dispatch);
                    if (!bl2) {
                        int n4 = dispatch.Release();
                    }
                    object = object3;
                } else {
                    object = dispatch;
                }
            }
        }
        if (IComEnum.class.isAssignableFrom(clazz)) {
            object = clazz.cast(Convert.toComEnum(clazz, object));
        }
        if (bl3) {
            Convert.free((Variant.VARIANT)object2, object);
        }
        return object;
    }

    public static <T extends IComEnum> T toComEnum(Class<T> clazz, Object object) {
        try {
            IComEnum[] iComEnumArray;
            Method method = clazz.getMethod("values", new Class[0]);
            for (IComEnum iComEnum : iComEnumArray = (IComEnum[])method.invoke(null, new Object[0])) {
                if (!object.equals(iComEnum.getValue())) continue;
                return (T)iComEnum;
            }
        }
        catch (NoSuchMethodException noSuchMethodException) {
        }
        catch (IllegalAccessException illegalAccessException) {
        }
        catch (IllegalArgumentException illegalArgumentException) {
        }
        catch (InvocationTargetException invocationTargetException) {
            // empty catch block
        }
        return null;
    }

    public static void free(Variant.VARIANT vARIANT, Class<?> clazz) {
        Object object;
        if ((clazz == null || !WTypes.BSTR.class.isAssignableFrom(clazz)) && vARIANT != null && vARIANT.getVarType().intValue() == 8 && (object = vARIANT.getValue()) instanceof WTypes.BSTR) {
            OleAuto.INSTANCE.SysFreeString((WTypes.BSTR)object);
        }
    }

    public static void free(Variant.VARIANT vARIANT, Object object) {
        Convert.free(vARIANT, object == null ? null : object.getClass());
    }
}

