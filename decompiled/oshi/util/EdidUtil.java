/*
 * Decompiled with CFR 0.152.
 */
package oshi.util;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.util.ParseUtil;

@ThreadSafe
public final class EdidUtil {
    private static final Logger LOG = LoggerFactory.getLogger(EdidUtil.class);

    private EdidUtil() {
    }

    public static String getManufacturerID(byte[] byArray) {
        String string = String.format("%8s%8s", Integer.toBinaryString(byArray[8] & 0xFF), Integer.toBinaryString(byArray[9] & 0xFF)).replace(' ', '0');
        LOG.debug("Manufacurer ID: {}", (Object)string);
        return String.format("%s%s%s", Character.valueOf((char)(64 + Integer.parseInt(string.substring(1, 6), 2))), Character.valueOf((char)(64 + Integer.parseInt(string.substring(7, 11), 2))), Character.valueOf((char)(64 + Integer.parseInt(string.substring(12, 16), 2)))).replace("@", "");
    }

    public static String getProductID(byte[] byArray) {
        return Integer.toHexString(ByteBuffer.wrap(Arrays.copyOfRange(byArray, 10, 12)).order(ByteOrder.LITTLE_ENDIAN).getShort() & 0xFFFF);
    }

    public static String getSerialNo(byte[] byArray) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Serial number: {}", (Object)Arrays.toString(Arrays.copyOfRange(byArray, 12, 16)));
        }
        return String.format("%s%s%s%s", EdidUtil.getAlphaNumericOrHex(byArray[15]), EdidUtil.getAlphaNumericOrHex(byArray[14]), EdidUtil.getAlphaNumericOrHex(byArray[13]), EdidUtil.getAlphaNumericOrHex(byArray[12]));
    }

    private static String getAlphaNumericOrHex(byte by2) {
        return Character.isLetterOrDigit((char)by2) ? String.format("%s", Character.valueOf((char)by2)) : String.format("%02X", by2);
    }

    public static byte getWeek(byte[] byArray) {
        return byArray[16];
    }

    public static int getYear(byte[] byArray) {
        byte by2 = byArray[17];
        LOG.debug("Year-1990: {}", (Object)by2);
        return by2 + 1990;
    }

    public static String getVersion(byte[] byArray) {
        return byArray[18] + "." + byArray[19];
    }

    public static boolean isDigital(byte[] byArray) {
        return 1 == (byArray[20] & 0xFF) >> 7;
    }

    public static int getHcm(byte[] byArray) {
        return byArray[21];
    }

    public static int getVcm(byte[] byArray) {
        return byArray[22];
    }

    public static byte[][] getDescriptors(byte[] byArray) {
        byte[][] byArray2 = new byte[4][18];
        for (int i2 = 0; i2 < byArray2.length; ++i2) {
            System.arraycopy(byArray, 54 + 18 * i2, byArray2[i2], 0, 18);
        }
        return byArray2;
    }

    public static int getDescriptorType(byte[] byArray) {
        return ByteBuffer.wrap(Arrays.copyOfRange(byArray, 0, 4)).getInt();
    }

    public static String getTimingDescriptor(byte[] byArray) {
        int n2 = ByteBuffer.wrap(Arrays.copyOfRange(byArray, 0, 2)).order(ByteOrder.LITTLE_ENDIAN).getShort() / 100;
        int n3 = (byArray[2] & 0xFF) + ((byArray[4] & 0xF0) << 4);
        int n4 = (byArray[5] & 0xFF) + ((byArray[7] & 0xF0) << 4);
        return String.format("Clock %dMHz, Active Pixels %dx%d ", n2, n3, n4);
    }

    public static String getDescriptorRangeLimits(byte[] byArray) {
        return String.format("Field Rate %d-%d Hz vertical, %d-%d Hz horizontal, Max clock: %d MHz", byArray[5], byArray[6], byArray[7], byArray[8], byArray[9] * 10);
    }

    public static String getDescriptorText(byte[] byArray) {
        return new String(Arrays.copyOfRange(byArray, 4, 18), StandardCharsets.US_ASCII).trim();
    }

    public static String toString(byte[] byArray) {
        byte[][] byArray2;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("  Manuf. ID=").append(EdidUtil.getManufacturerID(byArray));
        stringBuilder.append(", Product ID=").append(EdidUtil.getProductID(byArray));
        stringBuilder.append(", ").append(EdidUtil.isDigital(byArray) ? "Digital" : "Analog");
        stringBuilder.append(", Serial=").append(EdidUtil.getSerialNo(byArray));
        stringBuilder.append(", ManufDate=").append(EdidUtil.getWeek(byArray) * 12 / 52 + 1).append('/').append(EdidUtil.getYear(byArray));
        stringBuilder.append(", EDID v").append(EdidUtil.getVersion(byArray));
        int n2 = EdidUtil.getHcm(byArray);
        int n3 = EdidUtil.getVcm(byArray);
        stringBuilder.append(String.format("%n  %d x %d cm (%.1f x %.1f in)", n2, n3, (double)n2 / 2.54, (double)n3 / 2.54));
        block8: for (byte[] byArray3 : byArray2 = EdidUtil.getDescriptors(byArray)) {
            switch (EdidUtil.getDescriptorType(byArray3)) {
                case 255: {
                    stringBuilder.append("\n  Serial Number: ").append(EdidUtil.getDescriptorText(byArray3));
                    continue block8;
                }
                case 254: {
                    stringBuilder.append("\n  Unspecified Text: ").append(EdidUtil.getDescriptorText(byArray3));
                    continue block8;
                }
                case 253: {
                    stringBuilder.append("\n  Range Limits: ").append(EdidUtil.getDescriptorRangeLimits(byArray3));
                    continue block8;
                }
                case 252: {
                    stringBuilder.append("\n  Monitor Name: ").append(EdidUtil.getDescriptorText(byArray3));
                    continue block8;
                }
                case 251: {
                    stringBuilder.append("\n  White Point Data: ").append(ParseUtil.byteArrayToHexString(byArray3));
                    continue block8;
                }
                case 250: {
                    stringBuilder.append("\n  Standard Timing ID: ").append(ParseUtil.byteArrayToHexString(byArray3));
                    continue block8;
                }
                default: {
                    if (EdidUtil.getDescriptorType(byArray3) <= 15 && EdidUtil.getDescriptorType(byArray3) >= 0) {
                        stringBuilder.append("\n  Manufacturer Data: ").append(ParseUtil.byteArrayToHexString(byArray3));
                        continue block8;
                    }
                    stringBuilder.append("\n  Preferred Timing: ").append(EdidUtil.getTimingDescriptor(byArray3));
                }
            }
        }
        return stringBuilder.toString();
    }
}

