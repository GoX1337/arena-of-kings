/*
 * Decompiled with CFR 0.152.
 */
package oshi.util.platform.mac;

import com.sun.jna.NativeLong;
import com.sun.jna.platform.mac.IOKit;
import com.sun.jna.platform.mac.IOKitUtil;
import com.sun.jna.ptr.NativeLongByReference;
import com.sun.jna.ptr.PointerByReference;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.jna.platform.mac.IOKit;
import oshi.jna.platform.mac.SystemB;
import oshi.util.ParseUtil;

@ThreadSafe
public final class SmcUtil {
    private static final Logger LOG = LoggerFactory.getLogger(SmcUtil.class);
    private static final IOKit IO = IOKit.INSTANCE;
    private static Map<Integer, IOKit.SMCKeyDataKeyInfo> keyInfoCache = new ConcurrentHashMap<Integer, IOKit.SMCKeyDataKeyInfo>();
    private static final byte[] DATATYPE_SP78 = ParseUtil.asciiStringToByteArray("sp78", 5);
    private static final byte[] DATATYPE_FPE2 = ParseUtil.asciiStringToByteArray("fpe2", 5);
    private static final byte[] DATATYPE_FLT = ParseUtil.asciiStringToByteArray("flt ", 5);
    public static final String SMC_KEY_FAN_NUM = "FNum";
    public static final String SMC_KEY_FAN_SPEED = "F%dAc";
    public static final String SMC_KEY_CPU_TEMP = "TC0P";
    public static final String SMC_KEY_CPU_VOLTAGE = "VC0C";
    public static final byte SMC_CMD_READ_BYTES = 5;
    public static final byte SMC_CMD_READ_KEYINFO = 9;
    public static final int KERNEL_INDEX_SMC = 2;

    private SmcUtil() {
    }

    public static IOKit.IOConnect smcOpen() {
        IOKit.IOService iOService = IOKitUtil.getMatchingService("AppleSMC");
        if (iOService != null) {
            PointerByReference pointerByReference = new PointerByReference();
            int n2 = IO.IOServiceOpen(iOService, SystemB.INSTANCE.mach_task_self(), 0, pointerByReference);
            iOService.release();
            if (n2 == 0) {
                return new IOKit.IOConnect(pointerByReference.getValue());
            }
            if (LOG.isErrorEnabled()) {
                LOG.error(String.format("Unable to open connection to AppleSMC service. Error: 0x%08x", n2));
            }
        } else {
            LOG.error("Unable to locate AppleSMC service");
        }
        return null;
    }

    public static int smcClose(IOKit.IOConnect iOConnect) {
        return IO.IOServiceClose(iOConnect);
    }

    public static double smcGetFloat(IOKit.IOConnect iOConnect, String string) {
        IOKit.SMCVal sMCVal = new IOKit.SMCVal();
        int n2 = SmcUtil.smcReadKey(iOConnect, string, sMCVal);
        if (n2 == 0 && sMCVal.dataSize > 0) {
            if (Arrays.equals(sMCVal.dataType, DATATYPE_SP78) && sMCVal.dataSize == 2) {
                return (double)sMCVal.bytes[0] + (double)sMCVal.bytes[1] / 256.0;
            }
            if (Arrays.equals(sMCVal.dataType, DATATYPE_FPE2) && sMCVal.dataSize == 2) {
                return ParseUtil.byteArrayToFloat(sMCVal.bytes, sMCVal.dataSize, 2);
            }
            if (Arrays.equals(sMCVal.dataType, DATATYPE_FLT) && sMCVal.dataSize == 4) {
                return ByteBuffer.wrap(sMCVal.bytes).order(ByteOrder.LITTLE_ENDIAN).getFloat();
            }
        }
        return 0.0;
    }

    public static long smcGetLong(IOKit.IOConnect iOConnect, String string) {
        IOKit.SMCVal sMCVal = new IOKit.SMCVal();
        int n2 = SmcUtil.smcReadKey(iOConnect, string, sMCVal);
        if (n2 == 0) {
            return ParseUtil.byteArrayToLong(sMCVal.bytes, sMCVal.dataSize);
        }
        return 0L;
    }

    public static int smcGetKeyInfo(IOKit.IOConnect iOConnect, IOKit.SMCKeyData sMCKeyData, IOKit.SMCKeyData sMCKeyData2) {
        if (keyInfoCache.containsKey(sMCKeyData.key)) {
            IOKit.SMCKeyDataKeyInfo sMCKeyDataKeyInfo = keyInfoCache.get(sMCKeyData.key);
            sMCKeyData2.keyInfo.dataSize = sMCKeyDataKeyInfo.dataSize;
            sMCKeyData2.keyInfo.dataType = sMCKeyDataKeyInfo.dataType;
            sMCKeyData2.keyInfo.dataAttributes = sMCKeyDataKeyInfo.dataAttributes;
        } else {
            sMCKeyData.data8 = (byte)9;
            int n2 = SmcUtil.smcCall(iOConnect, 2, sMCKeyData, sMCKeyData2);
            if (n2 != 0) {
                return n2;
            }
            IOKit.SMCKeyDataKeyInfo sMCKeyDataKeyInfo = new IOKit.SMCKeyDataKeyInfo();
            sMCKeyDataKeyInfo.dataSize = sMCKeyData2.keyInfo.dataSize;
            sMCKeyDataKeyInfo.dataType = sMCKeyData2.keyInfo.dataType;
            sMCKeyDataKeyInfo.dataAttributes = sMCKeyData2.keyInfo.dataAttributes;
            keyInfoCache.put(sMCKeyData.key, sMCKeyDataKeyInfo);
        }
        return 0;
    }

    public static int smcReadKey(IOKit.IOConnect iOConnect, String string, IOKit.SMCVal sMCVal) {
        IOKit.SMCKeyData sMCKeyData = new IOKit.SMCKeyData();
        IOKit.SMCKeyData sMCKeyData2 = new IOKit.SMCKeyData();
        sMCKeyData.key = (int)ParseUtil.strToLong(string, 4);
        int n2 = SmcUtil.smcGetKeyInfo(iOConnect, sMCKeyData, sMCKeyData2);
        if (n2 == 0) {
            sMCVal.dataSize = sMCKeyData2.keyInfo.dataSize;
            sMCVal.dataType = ParseUtil.longToByteArray(sMCKeyData2.keyInfo.dataType, 4, 5);
            sMCKeyData.keyInfo.dataSize = sMCVal.dataSize;
            sMCKeyData.data8 = (byte)5;
            n2 = SmcUtil.smcCall(iOConnect, 2, sMCKeyData, sMCKeyData2);
            if (n2 == 0) {
                System.arraycopy(sMCKeyData2.bytes, 0, sMCVal.bytes, 0, sMCVal.bytes.length);
                return 0;
            }
        }
        return n2;
    }

    public static int smcCall(IOKit.IOConnect iOConnect, int n2, IOKit.SMCKeyData sMCKeyData, IOKit.SMCKeyData sMCKeyData2) {
        return IO.IOConnectCallStructMethod(iOConnect, n2, sMCKeyData, new NativeLong((long)sMCKeyData.size()), sMCKeyData2, new NativeLongByReference(new NativeLong((long)sMCKeyData2.size())));
    }
}

