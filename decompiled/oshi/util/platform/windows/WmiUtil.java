/*
 * Decompiled with CFR 0.152.
 */
package oshi.util.platform.windows;

import com.sun.jna.platform.win32.COM.WbemcliUtil;
import java.time.OffsetDateTime;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.util.Constants;
import oshi.util.ParseUtil;

@ThreadSafe
public final class WmiUtil {
    public static final String OHM_NAMESPACE = "ROOT\\OpenHardwareMonitor";
    private static final String CLASS_CAST_MSG = "%s is not a %s type. CIM Type is %d and VT type is %d";

    private WmiUtil() {
    }

    public static <T extends Enum<T>> String queryToString(WbemcliUtil.WmiQuery<T> wmiQuery) {
        Enum[] enumArray = (Enum[])wmiQuery.getPropertyEnum().getEnumConstants();
        StringBuilder stringBuilder = new StringBuilder("SELECT ");
        stringBuilder.append(enumArray[0].name());
        for (int i2 = 1; i2 < enumArray.length; ++i2) {
            stringBuilder.append(',').append(enumArray[i2].name());
        }
        stringBuilder.append(" FROM ").append(wmiQuery.getWmiClassName());
        return stringBuilder.toString();
    }

    public static <T extends Enum<T>> String getString(WbemcliUtil.WmiResult<T> wmiResult, T t2, int n2) {
        if (wmiResult.getCIMType(t2) == 8) {
            return WmiUtil.getStr(wmiResult, t2, n2);
        }
        throw new ClassCastException(String.format(CLASS_CAST_MSG, t2.name(), "String", wmiResult.getCIMType(t2), wmiResult.getVtType(t2)));
    }

    public static <T extends Enum<T>> String getDateString(WbemcliUtil.WmiResult<T> wmiResult, T t2, int n2) {
        OffsetDateTime offsetDateTime = WmiUtil.getDateTime(wmiResult, t2, n2);
        if (offsetDateTime.equals(Constants.UNIX_EPOCH)) {
            return "";
        }
        return offsetDateTime.toLocalDate().toString();
    }

    public static <T extends Enum<T>> OffsetDateTime getDateTime(WbemcliUtil.WmiResult<T> wmiResult, T t2, int n2) {
        if (wmiResult.getCIMType(t2) == 101) {
            return ParseUtil.parseCimDateTimeToOffset(WmiUtil.getStr(wmiResult, t2, n2));
        }
        throw new ClassCastException(String.format(CLASS_CAST_MSG, t2.name(), "DateTime", wmiResult.getCIMType(t2), wmiResult.getVtType(t2)));
    }

    public static <T extends Enum<T>> String getRefString(WbemcliUtil.WmiResult<T> wmiResult, T t2, int n2) {
        if (wmiResult.getCIMType(t2) == 102) {
            return WmiUtil.getStr(wmiResult, t2, n2);
        }
        throw new ClassCastException(String.format(CLASS_CAST_MSG, t2.name(), "Reference", wmiResult.getCIMType(t2), wmiResult.getVtType(t2)));
    }

    private static <T extends Enum<T>> String getStr(WbemcliUtil.WmiResult<T> wmiResult, T t2, int n2) {
        Object object = wmiResult.getValue(t2, n2);
        if (object == null) {
            return "";
        }
        if (wmiResult.getVtType(t2) == 8) {
            return (String)object;
        }
        throw new ClassCastException(String.format(CLASS_CAST_MSG, t2.name(), "String-mapped", wmiResult.getCIMType(t2), wmiResult.getVtType(t2)));
    }

    public static <T extends Enum<T>> long getUint64(WbemcliUtil.WmiResult<T> wmiResult, T t2, int n2) {
        Object object = wmiResult.getValue(t2, n2);
        if (object == null) {
            return 0L;
        }
        if (wmiResult.getCIMType(t2) == 21 && wmiResult.getVtType(t2) == 8) {
            return ParseUtil.parseLongOrDefault((String)object, 0L);
        }
        throw new ClassCastException(String.format(CLASS_CAST_MSG, t2.name(), "UINT64", wmiResult.getCIMType(t2), wmiResult.getVtType(t2)));
    }

    public static <T extends Enum<T>> int getUint32(WbemcliUtil.WmiResult<T> wmiResult, T t2, int n2) {
        if (wmiResult.getCIMType(t2) == 19) {
            return WmiUtil.getInt(wmiResult, t2, n2);
        }
        throw new ClassCastException(String.format(CLASS_CAST_MSG, t2.name(), "UINT32", wmiResult.getCIMType(t2), wmiResult.getVtType(t2)));
    }

    public static <T extends Enum<T>> long getUint32asLong(WbemcliUtil.WmiResult<T> wmiResult, T t2, int n2) {
        if (wmiResult.getCIMType(t2) == 19) {
            return (long)WmiUtil.getInt(wmiResult, t2, n2) & 0xFFFFFFFFL;
        }
        throw new ClassCastException(String.format(CLASS_CAST_MSG, t2.name(), "UINT32", wmiResult.getCIMType(t2), wmiResult.getVtType(t2)));
    }

    public static <T extends Enum<T>> int getSint32(WbemcliUtil.WmiResult<T> wmiResult, T t2, int n2) {
        if (wmiResult.getCIMType(t2) == 3) {
            return WmiUtil.getInt(wmiResult, t2, n2);
        }
        throw new ClassCastException(String.format(CLASS_CAST_MSG, t2.name(), "SINT32", wmiResult.getCIMType(t2), wmiResult.getVtType(t2)));
    }

    public static <T extends Enum<T>> int getUint16(WbemcliUtil.WmiResult<T> wmiResult, T t2, int n2) {
        if (wmiResult.getCIMType(t2) == 18) {
            return WmiUtil.getInt(wmiResult, t2, n2);
        }
        throw new ClassCastException(String.format(CLASS_CAST_MSG, t2.name(), "UINT16", wmiResult.getCIMType(t2), wmiResult.getVtType(t2)));
    }

    private static <T extends Enum<T>> int getInt(WbemcliUtil.WmiResult<T> wmiResult, T t2, int n2) {
        Object object = wmiResult.getValue(t2, n2);
        if (object == null) {
            return 0;
        }
        if (wmiResult.getVtType(t2) == 3) {
            return (Integer)object;
        }
        throw new ClassCastException(String.format(CLASS_CAST_MSG, t2.name(), "32-bit integer", wmiResult.getCIMType(t2), wmiResult.getVtType(t2)));
    }

    public static <T extends Enum<T>> float getFloat(WbemcliUtil.WmiResult<T> wmiResult, T t2, int n2) {
        Object object = wmiResult.getValue(t2, n2);
        if (object == null) {
            return 0.0f;
        }
        if (wmiResult.getCIMType(t2) == 4 && wmiResult.getVtType(t2) == 4) {
            return ((Float)object).floatValue();
        }
        throw new ClassCastException(String.format(CLASS_CAST_MSG, t2.name(), "Float", wmiResult.getCIMType(t2), wmiResult.getVtType(t2)));
    }
}

