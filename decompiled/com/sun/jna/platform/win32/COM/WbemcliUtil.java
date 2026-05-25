/*
 * Decompiled with CFR 0.152.
 */
package com.sun.jna.platform.win32.COM;

import com.sun.jna.Pointer;
import com.sun.jna.WString;
import com.sun.jna.platform.win32.COM.COMException;
import com.sun.jna.platform.win32.COM.COMUtils;
import com.sun.jna.platform.win32.COM.Wbemcli;
import com.sun.jna.platform.win32.Ole32;
import com.sun.jna.platform.win32.OleAuto;
import com.sun.jna.platform.win32.Variant;
import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.ptr.IntByReference;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeoutException;

public class WbemcliUtil {
    public static final WbemcliUtil INSTANCE = new WbemcliUtil();
    public static final String DEFAULT_NAMESPACE = "ROOT\\CIMV2";

    public static boolean hasNamespace(String string) {
        String string2 = string;
        if (string.toUpperCase().startsWith("ROOT\\")) {
            string2 = string.substring(5);
        }
        WmiQuery<NamespaceProperty> wmiQuery = new WmiQuery<NamespaceProperty>("ROOT", "__NAMESPACE", NamespaceProperty.class);
        WmiResult<NamespaceProperty> wmiResult = wmiQuery.execute();
        for (int i2 = 0; i2 < wmiResult.getResultCount(); ++i2) {
            if (!string2.equalsIgnoreCase((String)wmiResult.getValue(NamespaceProperty.NAME, i2))) continue;
            return true;
        }
        return false;
    }

    public static Wbemcli.IWbemServices connectServer(String string) {
        Wbemcli.IWbemLocator iWbemLocator = Wbemcli.IWbemLocator.create();
        if (iWbemLocator == null) {
            throw new COMException("Failed to create WbemLocator object.");
        }
        Wbemcli.IWbemServices iWbemServices = iWbemLocator.ConnectServer(string, null, null, null, 0, null, null);
        iWbemLocator.Release();
        WinNT.HRESULT hRESULT = Ole32.INSTANCE.CoSetProxyBlanket(iWbemServices, 10, 0, null, 3, 3, null, 0);
        if (COMUtils.FAILED(hRESULT)) {
            iWbemServices.Release();
            throw new COMException("Could not set proxy blanket.", hRESULT);
        }
        return iWbemServices;
    }

    public class WmiResult<T extends Enum<T>> {
        private Map<T, List<Object>> propertyMap;
        private Map<T, Integer> vtTypeMap;
        private Map<T, Integer> cimTypeMap;
        private int resultCount = 0;

        public WmiResult(Class<T> clazz) {
            this.propertyMap = new EnumMap<T, List<Object>>(clazz);
            this.vtTypeMap = new EnumMap<T, Integer>(clazz);
            this.cimTypeMap = new EnumMap<T, Integer>(clazz);
            for (Enum enum_ : (Enum[])clazz.getEnumConstants()) {
                this.propertyMap.put(enum_, new ArrayList());
                this.vtTypeMap.put(enum_, 1);
                this.cimTypeMap.put(enum_, 0);
            }
        }

        public Object getValue(T t2, int n2) {
            return this.propertyMap.get(t2).get(n2);
        }

        public int getVtType(T t2) {
            return this.vtTypeMap.get(t2);
        }

        public int getCIMType(T t2) {
            return this.cimTypeMap.get(t2);
        }

        private void add(int n2, int n3, T t2, Object object) {
            this.propertyMap.get(t2).add(object);
            if (n2 != 1 && this.vtTypeMap.get(t2).equals(1)) {
                this.vtTypeMap.put(t2, n2);
            }
            if (this.cimTypeMap.get(t2).equals(0)) {
                this.cimTypeMap.put(t2, n3);
            }
        }

        public int getResultCount() {
            return this.resultCount;
        }

        private void incrementResultCount() {
            ++this.resultCount;
        }
    }

    public static class WmiQuery<T extends Enum<T>> {
        private String nameSpace;
        private String wmiClassName;
        private Class<T> propertyEnum;

        public WmiQuery(String string, String string2, Class<T> clazz) {
            this.nameSpace = string;
            this.wmiClassName = string2;
            this.propertyEnum = clazz;
        }

        public WmiQuery(String string, Class<T> clazz) {
            this(WbemcliUtil.DEFAULT_NAMESPACE, string, clazz);
        }

        public Class<T> getPropertyEnum() {
            return this.propertyEnum;
        }

        public String getNameSpace() {
            return this.nameSpace;
        }

        public void setNameSpace(String string) {
            this.nameSpace = string;
        }

        public String getWmiClassName() {
            return this.wmiClassName;
        }

        public void setWmiClassName(String string) {
            this.wmiClassName = string;
        }

        public WmiResult<T> execute() {
            try {
                return this.execute(-1);
            }
            catch (TimeoutException timeoutException) {
                throw new COMException("Got a WMI timeout when infinite wait was specified. This should never happen.");
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public WmiResult<T> execute(int n2) {
            if (((Enum[])this.getPropertyEnum().getEnumConstants()).length < 1) {
                throw new IllegalArgumentException("The query's property enum has no values.");
            }
            Wbemcli.IWbemServices iWbemServices = WbemcliUtil.connectServer(this.getNameSpace());
            try {
                WmiResult<T> wmiResult;
                Wbemcli.IEnumWbemClassObject iEnumWbemClassObject = WmiQuery.selectProperties(iWbemServices, this);
                try {
                    wmiResult = WmiQuery.enumerateProperties(iEnumWbemClassObject, this.getPropertyEnum(), n2);
                }
                catch (Throwable throwable) {
                    iEnumWbemClassObject.Release();
                    throw throwable;
                }
                iEnumWbemClassObject.Release();
                return wmiResult;
            }
            finally {
                iWbemServices.Release();
            }
        }

        private static <T extends Enum<T>> Wbemcli.IEnumWbemClassObject selectProperties(Wbemcli.IWbemServices iWbemServices, WmiQuery<T> wmiQuery) {
            Enum[] enumArray = (Enum[])wmiQuery.getPropertyEnum().getEnumConstants();
            StringBuilder stringBuilder = new StringBuilder("SELECT ");
            stringBuilder.append(enumArray[0].name());
            for (int i2 = 1; i2 < enumArray.length; ++i2) {
                stringBuilder.append(',').append(enumArray[i2].name());
            }
            stringBuilder.append(" FROM ").append(wmiQuery.getWmiClassName());
            return iWbemServices.ExecQuery("WQL", stringBuilder.toString().replaceAll("\\\\", "\\\\\\\\"), 48, null);
        }

        private static <T extends Enum<T>> WmiResult<T> enumerateProperties(Wbemcli.IEnumWbemClassObject iEnumWbemClassObject, Class<T> clazz, int n2) {
            WbemcliUtil wbemcliUtil = INSTANCE;
            wbemcliUtil.getClass();
            WmiResult<T> wmiResult = wbemcliUtil.new WmiResult<T>(clazz);
            Pointer[] pointerArray = new Pointer[1];
            IntByReference intByReference = new IntByReference(0);
            HashMap<Enum, WString> hashMap = new HashMap<Enum, WString>();
            WinNT.HRESULT hRESULT = null;
            for (Enum enumArray : (Enum[])clazz.getEnumConstants()) {
                hashMap.put(enumArray, new WString(enumArray.name()));
            }
            while (iEnumWbemClassObject.getPointer() != Pointer.NULL && (hRESULT = iEnumWbemClassObject.Next(n2, pointerArray.length, pointerArray, intByReference)).intValue() != 1 && hRESULT.intValue() != 262149) {
                if (hRESULT.intValue() == 262148) {
                    throw new TimeoutException("No results after " + n2 + " ms.");
                }
                if (COMUtils.FAILED(hRESULT)) {
                    throw new COMException("Failed to enumerate results.", hRESULT);
                }
                Variant.VARIANT.ByReference byReference = new Variant.VARIANT.ByReference();
                IntByReference intByReference2 = new IntByReference();
                Wbemcli.IWbemClassObject iWbemClassObject = new Wbemcli.IWbemClassObject(pointerArray[0]);
                for (Enum enum_ : (Enum[])clazz.getEnumConstants()) {
                    iWbemClassObject.Get((WString)hashMap.get(enum_), 0, byReference, intByReference2, null);
                    int n3 = (byReference.getValue() == null ? Integer.valueOf(1) : byReference.getVarType()).intValue();
                    int n4 = intByReference2.getValue();
                    switch (n3) {
                        case 8: {
                            ((WmiResult)wmiResult).add(n3, n4, enum_, byReference.stringValue());
                            break;
                        }
                        case 3: {
                            ((WmiResult)wmiResult).add(n3, n4, enum_, byReference.intValue());
                            break;
                        }
                        case 17: {
                            ((WmiResult)wmiResult).add(n3, n4, enum_, byReference.byteValue());
                            break;
                        }
                        case 2: {
                            ((WmiResult)wmiResult).add(n3, n4, enum_, byReference.shortValue());
                            break;
                        }
                        case 11: {
                            ((WmiResult)wmiResult).add(n3, n4, enum_, byReference.booleanValue());
                            break;
                        }
                        case 4: {
                            ((WmiResult)wmiResult).add(n3, n4, enum_, Float.valueOf(byReference.floatValue()));
                            break;
                        }
                        case 5: {
                            ((WmiResult)wmiResult).add(n3, n4, enum_, byReference.doubleValue());
                            break;
                        }
                        case 0: 
                        case 1: {
                            ((WmiResult)wmiResult).add(n3, n4, enum_, null);
                            break;
                        }
                        default: {
                            if ((n3 & 0x2000) == 8192 || (n3 & 0xD) == 13 || (n3 & 9) == 9 || (n3 & 0x1000) == 4096) {
                                ((WmiResult)wmiResult).add(n3, n4, enum_, null);
                                break;
                            }
                            ((WmiResult)wmiResult).add(n3, n4, enum_, byReference.getValue());
                        }
                    }
                    OleAuto.INSTANCE.VariantClear(byReference);
                }
                iWbemClassObject.Release();
                ((WmiResult)wmiResult).incrementResultCount();
            }
            return wmiResult;
        }
    }

    static enum NamespaceProperty {
        NAME;

    }
}

