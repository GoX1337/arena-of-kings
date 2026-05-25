/*
 * Decompiled with CFR 0.152.
 */
package oshi.util;

import java.math.BigInteger;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.util.Constants;
import oshi.util.tuples.Pair;
import oshi.util.tuples.Triplet;

@ThreadSafe
public final class ParseUtil {
    private static final Logger LOG = LoggerFactory.getLogger(ParseUtil.class);
    private static final String DEFAULT_LOG_MSG = "{} didn't parse. Returning default. {}";
    private static final Pattern HERTZ_PATTERN = Pattern.compile("(\\d+(.\\d+)?) ?([kMGT]?Hz).*");
    private static final Pattern BYTES_PATTERN = Pattern.compile("(\\d+) ?([kMGT]?B).*");
    private static final Pattern UNITS_PATTERN = Pattern.compile("(\\d+(.\\d+)?)[\\s]?([kKMGT])?");
    private static final Pattern VALID_HEX = Pattern.compile("[0-9a-fA-F]+");
    private static final Pattern DHMS = Pattern.compile("(?:(\\d+)-)?(?:(\\d+):)??(?:(\\d+):)?(\\d+)(?:\\.(\\d+))?");
    private static final Pattern UUID_PATTERN = Pattern.compile(".*([0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}).*");
    private static final Pattern VENDOR_PRODUCT_ID_SERIAL = Pattern.compile(".*(?:VID|VEN)_(\\p{XDigit}{4})&(?:PID|DEV)_(\\p{XDigit}{4})(.*)\\\\(.*)");
    private static final Pattern LSPCI_MACHINE_READABLE = Pattern.compile("(.+)\\s\\[(.*?)\\]");
    private static final Pattern LSPCI_MEMORY_SIZE = Pattern.compile(".+\\s\\[size=(\\d+)([kKMGT])\\]");
    private static final String HZ = "Hz";
    private static final String KHZ = "kHz";
    private static final String MHZ = "MHz";
    private static final String GHZ = "GHz";
    private static final String THZ = "THz";
    private static final String PHZ = "PHz";
    private static final Map<String, Long> multipliers;
    private static final long EPOCH_DIFF = 11644473600000L;
    private static final int TZ_OFFSET;
    public static final Pattern whitespacesColonWhitespace;
    public static final Pattern whitespaces;
    public static final Pattern notDigits;
    public static final Pattern startWithNotDigits;
    public static final Pattern slash;
    private static final long[] POWERS_OF_TEN;
    private static final DateTimeFormatter CIM_FORMAT;

    private ParseUtil() {
    }

    public static long parseHertz(String string) {
        double d2;
        Matcher matcher = HERTZ_PATTERN.matcher(string.trim());
        if (matcher.find() && matcher.groupCount() == 3 && (d2 = Double.valueOf(matcher.group(1)) * (double)multipliers.getOrDefault(matcher.group(3), -1L).longValue()) >= 0.0) {
            return (long)d2;
        }
        return -1L;
    }

    public static int parseLastInt(String string, int n2) {
        try {
            String string2 = ParseUtil.parseLastString(string);
            if (string2.toLowerCase().startsWith("0x")) {
                return Integer.decode(string2);
            }
            return Integer.parseInt(string2);
        }
        catch (NumberFormatException numberFormatException) {
            LOG.trace(DEFAULT_LOG_MSG, (Object)string, (Object)numberFormatException);
            return n2;
        }
    }

    public static long parseLastLong(String string, long l2) {
        try {
            String string2 = ParseUtil.parseLastString(string);
            if (string2.toLowerCase().startsWith("0x")) {
                return Long.decode(string2);
            }
            return Long.parseLong(string2);
        }
        catch (NumberFormatException numberFormatException) {
            LOG.trace(DEFAULT_LOG_MSG, (Object)string, (Object)numberFormatException);
            return l2;
        }
    }

    public static double parseLastDouble(String string, double d2) {
        try {
            return Double.parseDouble(ParseUtil.parseLastString(string));
        }
        catch (NumberFormatException numberFormatException) {
            LOG.trace(DEFAULT_LOG_MSG, (Object)string, (Object)numberFormatException);
            return d2;
        }
    }

    public static String parseLastString(String string) {
        String[] stringArray = whitespaces.split(string);
        return stringArray[stringArray.length - 1];
    }

    public static String byteArrayToHexString(byte[] byArray) {
        StringBuilder stringBuilder = new StringBuilder(byArray.length * 2);
        for (byte by2 : byArray) {
            stringBuilder.append(Character.forDigit((by2 & 0xF0) >>> 4, 16));
            stringBuilder.append(Character.forDigit(by2 & 0xF, 16));
        }
        return stringBuilder.toString().toUpperCase();
    }

    public static byte[] hexStringToByteArray(String string) {
        int n2 = string.length();
        if (!VALID_HEX.matcher(string).matches() || (n2 & 1) != 0) {
            LOG.warn("Invalid hexadecimal string: {}", (Object)string);
            return new byte[0];
        }
        byte[] byArray = new byte[n2 / 2];
        for (int i2 = 0; i2 < n2; i2 += 2) {
            byArray[i2 / 2] = (byte)(Character.digit(string.charAt(i2), 16) << 4 | Character.digit(string.charAt(i2 + 1), 16));
        }
        return byArray;
    }

    public static byte[] asciiStringToByteArray(String string, int n2) {
        return Arrays.copyOf(string.getBytes(StandardCharsets.US_ASCII), n2);
    }

    public static byte[] longToByteArray(long l2, int n2, int n3) {
        long l3 = l2;
        byte[] byArray = new byte[8];
        for (int i2 = 7; i2 >= 0 && l3 != 0L; l3 >>>= 8, --i2) {
            byArray[i2] = (byte)l3;
        }
        return Arrays.copyOfRange(byArray, 8 - n2, 8 + n3 - n2);
    }

    public static long strToLong(String string, int n2) {
        return ParseUtil.byteArrayToLong(string.getBytes(StandardCharsets.US_ASCII), n2);
    }

    public static long byteArrayToLong(byte[] byArray, int n2) {
        return ParseUtil.byteArrayToLong(byArray, n2, true);
    }

    public static long byteArrayToLong(byte[] byArray, int n2, boolean bl2) {
        if (n2 > 8) {
            throw new IllegalArgumentException("Can't convert more than 8 bytes.");
        }
        if (n2 > byArray.length) {
            throw new IllegalArgumentException("Size can't be larger than array length.");
        }
        long l2 = 0L;
        for (int i2 = 0; i2 < n2; ++i2) {
            l2 = bl2 ? l2 << 8 | (long)(byArray[i2] & 0xFF) : l2 << 8 | (long)(byArray[n2 - i2 - 1] & 0xFF);
        }
        return l2;
    }

    public static float byteArrayToFloat(byte[] byArray, int n2, int n3) {
        return (float)ParseUtil.byteArrayToLong(byArray, n2) / (float)(1 << n3);
    }

    public static long unsignedIntToLong(int n2) {
        long l2 = n2;
        return l2 & 0xFFFFFFFFL;
    }

    public static long unsignedLongToSignedLong(long l2) {
        return l2 & Long.MAX_VALUE;
    }

    public static String hexStringToString(String string) {
        if (string.length() % 2 > 0) {
            return string;
        }
        StringBuilder stringBuilder = new StringBuilder();
        try {
            for (int i2 = 0; i2 < string.length(); i2 += 2) {
                int n2 = Integer.parseInt(string.substring(i2, i2 + 2), 16);
                if (n2 < 32 || n2 > 127) {
                    return string;
                }
                stringBuilder.append((char)n2);
            }
        }
        catch (NumberFormatException numberFormatException) {
            LOG.trace(DEFAULT_LOG_MSG, (Object)string, (Object)numberFormatException);
            return string;
        }
        return stringBuilder.toString();
    }

    public static int parseIntOrDefault(String string, int n2) {
        try {
            return Integer.parseInt(string);
        }
        catch (NumberFormatException numberFormatException) {
            LOG.trace(DEFAULT_LOG_MSG, (Object)string, (Object)numberFormatException);
            return n2;
        }
    }

    public static long parseLongOrDefault(String string, long l2) {
        try {
            return Long.parseLong(string);
        }
        catch (NumberFormatException numberFormatException) {
            LOG.trace(DEFAULT_LOG_MSG, (Object)string, (Object)numberFormatException);
            return l2;
        }
    }

    public static long parseUnsignedLongOrDefault(String string, long l2) {
        try {
            return new BigInteger(string).longValue();
        }
        catch (NumberFormatException numberFormatException) {
            LOG.trace(DEFAULT_LOG_MSG, (Object)string, (Object)numberFormatException);
            return l2;
        }
    }

    public static double parseDoubleOrDefault(String string, double d2) {
        try {
            return Double.parseDouble(string);
        }
        catch (NumberFormatException numberFormatException) {
            LOG.trace(DEFAULT_LOG_MSG, (Object)string, (Object)numberFormatException);
            return d2;
        }
    }

    public static long parseDHMSOrDefault(String string, long l2) {
        Matcher matcher = DHMS.matcher(string);
        if (matcher.matches()) {
            long l3 = 0L;
            if (matcher.group(1) != null) {
                l3 += ParseUtil.parseLongOrDefault(matcher.group(1), 0L) * 86400000L;
            }
            if (matcher.group(2) != null) {
                l3 += ParseUtil.parseLongOrDefault(matcher.group(2), 0L) * 3600000L;
            }
            if (matcher.group(3) != null) {
                l3 += ParseUtil.parseLongOrDefault(matcher.group(3), 0L) * 60000L;
            }
            l3 += ParseUtil.parseLongOrDefault(matcher.group(4), 0L) * 1000L;
            if (matcher.group(5) != null) {
                l3 += (long)(1000.0 * ParseUtil.parseDoubleOrDefault("0." + matcher.group(5), 0.0));
            }
            return l3;
        }
        return l2;
    }

    public static String parseUuidOrDefault(String string, String string2) {
        Matcher matcher = UUID_PATTERN.matcher(string.toLowerCase());
        if (matcher.matches()) {
            return matcher.group(1);
        }
        return string2;
    }

    public static String getSingleQuoteStringValue(String string) {
        return ParseUtil.getStringBetween(string, '\'');
    }

    public static String getDoubleQuoteStringValue(String string) {
        return ParseUtil.getStringBetween(string, '\"');
    }

    public static String getStringBetween(String string, char c2) {
        int n2 = string.indexOf(c2);
        if (n2 < 0) {
            return "";
        }
        return string.substring(n2 + 1, string.lastIndexOf(c2)).trim();
    }

    public static int getFirstIntValue(String string) {
        return ParseUtil.getNthIntValue(string, 1);
    }

    public static int getNthIntValue(String string, int n2) {
        String[] stringArray = notDigits.split(startWithNotDigits.matcher(string).replaceFirst(""));
        if (stringArray.length >= n2) {
            return ParseUtil.parseIntOrDefault(stringArray[n2 - 1], 0);
        }
        return 0;
    }

    public static String removeMatchingString(String string, String string2) {
        if (string == null || string.isEmpty() || string2 == null || string2.isEmpty()) {
            return string;
        }
        int n2 = string.indexOf(string2, 0);
        if (n2 == -1) {
            return string;
        }
        StringBuilder stringBuilder = new StringBuilder(string.length() - string2.length());
        int n3 = 0;
        do {
            stringBuilder.append(string.substring(n3, n2));
        } while ((n2 = string.indexOf(string2, n3 = n2 + string2.length())) != -1);
        stringBuilder.append(string.substring(n3));
        return stringBuilder.toString();
    }

    public static long[] parseStringToLongArray(String string, int[] nArray, int n2, char c2) {
        long[] lArray = new long[nArray.length];
        int n3 = string.length();
        int n4 = nArray.length - 1;
        int n5 = n2 - 1;
        int n6 = 0;
        boolean bl2 = false;
        boolean bl3 = true;
        boolean bl4 = false;
        boolean bl5 = false;
        while (--n3 > 0 && n4 >= 0) {
            char c3 = string.charAt(n3);
            if (c3 == c2) {
                if (!bl4 && bl3) {
                    bl4 = true;
                }
                if (bl2) continue;
                if (bl4 && nArray[n4] == n5--) {
                    --n4;
                }
                bl2 = true;
                n6 = 0;
                bl5 = false;
                bl3 = true;
                continue;
            }
            if (nArray[n4] != n5 || c3 == '+' || !bl3) {
                bl2 = false;
                continue;
            }
            if (c3 >= '0' && c3 <= '9' && !bl5) {
                if (n6 > 18 || n6 == 17 && c3 == '9' && lArray[n4] > 223372036854775807L) {
                    lArray[n4] = Long.MAX_VALUE;
                } else {
                    int n7 = n4;
                    lArray[n7] = lArray[n7] + (long)(c3 - 48) * POWERS_OF_TEN[n6++];
                }
                bl2 = false;
                continue;
            }
            if (c3 == '-') {
                int n8 = n4;
                lArray[n8] = lArray[n8] * -1L;
                bl2 = false;
                bl5 = true;
                continue;
            }
            if (bl4) {
                if (!ParseUtil.noLog(string)) {
                    LOG.error("Illegal character parsing string '{}' to long array: {}", (Object)string, (Object)Character.valueOf(string.charAt(n3)));
                }
                return new long[nArray.length];
            }
            lArray[n4] = 0L;
            bl3 = false;
        }
        if (n4 > 0) {
            if (!ParseUtil.noLog(string)) {
                LOG.error("Not enough fields in string '{}' parsing to long array: {}", (Object)string, (Object)(nArray.length - n4));
            }
            return new long[nArray.length];
        }
        return lArray;
    }

    private static boolean noLog(String string) {
        return string.startsWith("NOLOG: ");
    }

    public static int countStringToLongArray(String string, char c2) {
        int n2 = string.length();
        int n3 = 0;
        boolean bl2 = false;
        boolean bl3 = true;
        boolean bl4 = false;
        while (--n2 > 0) {
            char c3 = string.charAt(n2);
            if (c3 == c2) {
                if (bl2) continue;
                if (bl3) {
                    ++n3;
                }
                bl2 = true;
                bl4 = false;
                bl3 = true;
                continue;
            }
            if (c3 == '+' || !bl3) {
                bl2 = false;
                continue;
            }
            if (c3 >= '0' && c3 <= '9' && !bl4) {
                bl2 = false;
                continue;
            }
            if (c3 == '-') {
                bl2 = false;
                bl4 = true;
                continue;
            }
            if (n3 > 0) {
                return n3;
            }
            bl3 = false;
        }
        return n3 + 1;
    }

    public static String getTextBetweenStrings(String string, String string2, String string3) {
        String string4 = "";
        if (string.indexOf(string2) >= 0 && string.indexOf(string3) >= 0) {
            string4 = string.substring(string.indexOf(string2) + string2.length(), string.length());
            string4 = string4.substring(0, string4.indexOf(string3));
        }
        return string4;
    }

    public static long filetimeToUtcMs(long l2, boolean bl2) {
        return l2 / 10000L - 11644473600000L - (bl2 ? (long)TZ_OFFSET : 0L);
    }

    public static String parseMmDdYyyyToYyyyMmDD(String string) {
        try {
            return String.format("%s-%s-%s", string.substring(6, 10), string.substring(0, 2), string.substring(3, 5));
        }
        catch (StringIndexOutOfBoundsException stringIndexOutOfBoundsException) {
            return string;
        }
    }

    public static OffsetDateTime parseCimDateTimeToOffset(String string) {
        try {
            int n2 = Integer.parseInt(string.substring(22));
            LocalTime localTime = LocalTime.MIDNIGHT.plusMinutes(n2);
            return OffsetDateTime.parse(string.substring(0, 22) + localTime.format(DateTimeFormatter.ISO_LOCAL_TIME), CIM_FORMAT);
        }
        catch (IndexOutOfBoundsException | NumberFormatException | DateTimeParseException runtimeException) {
            LOG.trace("Unable to parse {} to CIM DateTime.", (Object)string);
            return Constants.UNIX_EPOCH;
        }
    }

    public static boolean filePathStartsWith(List<String> list, String string) {
        for (String string2 : list) {
            if (!string.equals(string2) && !string.startsWith(string2 + "/")) continue;
            return true;
        }
        return false;
    }

    public static long parseMultipliedToLongs(String string) {
        Matcher matcher = UNITS_PATTERN.matcher(string.trim());
        String[] stringArray = matcher.find() && matcher.groupCount() == 3 ? new String[]{matcher.group(1), matcher.group(3)} : new String[]{string};
        double d2 = ParseUtil.parseDoubleOrDefault(stringArray[0], 0.0);
        if (stringArray.length == 2 && stringArray[1] != null && stringArray[1].length() >= 1) {
            switch (stringArray[1].charAt(0)) {
                case 'T': {
                    d2 *= 1.0E12;
                    break;
                }
                case 'G': {
                    d2 *= 1.0E9;
                    break;
                }
                case 'M': {
                    d2 *= 1000000.0;
                    break;
                }
                case 'K': 
                case 'k': {
                    d2 *= 1000.0;
                    break;
                }
            }
        }
        return (long)d2;
    }

    public static long parseDecimalMemorySizeToBinary(String string) {
        Matcher matcher;
        String[] stringArray = whitespaces.split(string);
        if (stringArray.length < 2 && (matcher = BYTES_PATTERN.matcher(string.trim())).find() && matcher.groupCount() == 2) {
            stringArray = new String[]{matcher.group(1), matcher.group(2)};
        }
        long l2 = ParseUtil.parseLongOrDefault(stringArray[0], 0L);
        if (stringArray.length == 2 && stringArray[1].length() > 1) {
            switch (stringArray[1].charAt(0)) {
                case 'T': {
                    l2 <<= 40;
                    break;
                }
                case 'G': {
                    l2 <<= 30;
                    break;
                }
                case 'M': {
                    l2 <<= 20;
                    break;
                }
                case 'K': 
                case 'k': {
                    l2 <<= 10;
                    break;
                }
            }
        }
        return l2;
    }

    public static Triplet<String, String, String> parseDeviceIdToVendorProductSerial(String string) {
        Matcher matcher = VENDOR_PRODUCT_ID_SERIAL.matcher(string);
        if (matcher.matches()) {
            String string2 = "0x" + matcher.group(1).toLowerCase();
            String string3 = "0x" + matcher.group(2).toLowerCase();
            String string4 = matcher.group(4);
            return new Triplet<String, String, String>(string2, string3, !matcher.group(3).isEmpty() || string4.contains("&") ? "" : string4);
        }
        return null;
    }

    public static long parseLshwResourceString(String string) {
        String[] stringArray;
        long l2 = 0L;
        for (String string2 : stringArray = whitespaces.split(string)) {
            String[] stringArray2;
            if (!string2.startsWith("memory:") || (stringArray2 = string2.substring(7).split("-")).length != 2) continue;
            try {
                l2 += Long.parseLong(stringArray2[1], 16) - Long.parseLong(stringArray2[0], 16) + 1L;
            }
            catch (NumberFormatException numberFormatException) {
                LOG.trace(DEFAULT_LOG_MSG, (Object)string2, (Object)numberFormatException);
            }
        }
        return l2;
    }

    public static Pair<String, String> parseLspciMachineReadable(String string) {
        Matcher matcher = LSPCI_MACHINE_READABLE.matcher(string);
        if (matcher.matches()) {
            return new Pair<String, String>(matcher.group(1), matcher.group(2));
        }
        return null;
    }

    public static long parseLspciMemorySize(String string) {
        Matcher matcher = LSPCI_MEMORY_SIZE.matcher(string);
        if (matcher.matches()) {
            return ParseUtil.parseDecimalMemorySizeToBinary(matcher.group(1) + " " + matcher.group(2) + "B");
        }
        return 0L;
    }

    public static List<Integer> parseHyphenatedIntList(String string) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (String string2 : whitespaces.split(string)) {
            int n2;
            if (string2.contains("-")) {
                n2 = ParseUtil.getFirstIntValue(string2);
                int n3 = ParseUtil.getNthIntValue(string2, 2);
                for (int i2 = n2; i2 <= n3; ++i2) {
                    arrayList.add(i2);
                }
                continue;
            }
            n2 = ParseUtil.parseIntOrDefault(string2, -1);
            if (n2 < 0) continue;
            arrayList.add(n2);
        }
        return arrayList;
    }

    public static byte[] parseIntToIP(int n2) {
        return ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(n2).array();
    }

    public static byte[] parseIntArrayToIP(int[] nArray) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(16).order(ByteOrder.LITTLE_ENDIAN);
        for (int n2 : nArray) {
            byteBuffer.putInt(n2);
        }
        return byteBuffer.array();
    }

    public static int bigEndian16ToLittleEndian(int n2) {
        return n2 >> 8 & 0xFF | n2 << 8 & 0xFF00;
    }

    public static String parseUtAddrV6toIP(int[] nArray) {
        if (nArray.length != 4) {
            throw new IllegalArgumentException("ut_addr_v6 must have exactly 4 elements");
        }
        if (nArray[1] == 0 && nArray[2] == 0 && nArray[3] == 0) {
            if (nArray[0] == 0) {
                return "::";
            }
            byte[] byArray = ByteBuffer.allocate(4).putInt(nArray[0]).array();
            try {
                return InetAddress.getByAddress(byArray).getHostAddress();
            }
            catch (UnknownHostException unknownHostException) {
                return "unknown";
            }
        }
        byte[] byArray = ByteBuffer.allocate(16).putInt(nArray[0]).putInt(nArray[1]).putInt(nArray[2]).putInt(nArray[3]).array();
        try {
            return InetAddress.getByAddress(byArray).getHostAddress().replaceAll("((?:(?:^|:)0+\\b){2,}):?(?!\\S*\\b\\1:0+\\b)(\\S*)", "::$2");
        }
        catch (UnknownHostException unknownHostException) {
            return "unknown";
        }
    }

    public static int hexStringToInt(String string, int n2) {
        if (string != null) {
            try {
                if (string.startsWith("0x")) {
                    return new BigInteger(string.substring(2), 16).intValue();
                }
                return new BigInteger(string, 16).intValue();
            }
            catch (NumberFormatException numberFormatException) {
                LOG.trace(DEFAULT_LOG_MSG, (Object)string, (Object)numberFormatException);
            }
        }
        return n2;
    }

    public static long hexStringToLong(String string, long l2) {
        if (string != null) {
            try {
                if (string.startsWith("0x")) {
                    return new BigInteger(string.substring(2), 16).longValue();
                }
                return new BigInteger(string, 16).longValue();
            }
            catch (NumberFormatException numberFormatException) {
                LOG.trace(DEFAULT_LOG_MSG, (Object)string, (Object)numberFormatException);
            }
        }
        return l2;
    }

    public static String removeLeadingDots(String string) {
        int n2;
        for (n2 = 0; n2 < string.length() && string.charAt(n2) == '.'; ++n2) {
        }
        return n2 < string.length() ? string.substring(n2) : "";
    }

    public static List<String> parseByteArrayToStrings(byte[] byArray) {
        ArrayList<String> arrayList = new ArrayList<String>();
        int n2 = 0;
        int n3 = 0;
        do {
            if (n3 != byArray.length && byArray[n3] != 0) continue;
            if (n2 == n3) break;
            arrayList.add(new String(byArray, n2, n3 - n2, StandardCharsets.UTF_8));
            n2 = n3 + 1;
        } while (n3++ < byArray.length);
        return arrayList;
    }

    public static Map<String, String> parseByteArrayToStringMap(byte[] byArray) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>();
        int n2 = 0;
        int n3 = 0;
        String string = null;
        do {
            if (n3 == byArray.length || byArray[n3] == 0) {
                if (n2 == n3 && string == null) break;
                linkedHashMap.put(string, new String(byArray, n2, n3 - n2, StandardCharsets.UTF_8));
                string = null;
                n2 = n3 + 1;
                continue;
            }
            if (byArray[n3] != 61 || string != null) continue;
            string = new String(byArray, n2, n3 - n2, StandardCharsets.UTF_8);
            n2 = n3 + 1;
        } while (n3++ < byArray.length);
        return linkedHashMap;
    }

    public static Map<String, String> parseCharArrayToStringMap(char[] cArray) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>();
        int n2 = 0;
        int n3 = 0;
        String string = null;
        do {
            if (n3 == cArray.length || cArray[n3] == '\u0000') {
                if (n2 == n3 && string == null) break;
                linkedHashMap.put(string, new String(cArray, n2, n3 - n2));
                string = null;
                n2 = n3 + 1;
                continue;
            }
            if (cArray[n3] != '=' || string != null) continue;
            string = new String(cArray, n2, n3 - n2);
            n2 = n3 + 1;
        } while (n3++ < cArray.length);
        return linkedHashMap;
    }

    public static <K extends Enum<K>> Map<K, String> stringToEnumMap(Class<K> clazz, String string, char c2) {
        EnumMap<Enum, String> enumMap = new EnumMap<Enum, String>(clazz);
        int n2 = 0;
        int n3 = string.length();
        EnumSet<Enum> enumSet = EnumSet.allOf(clazz);
        int n4 = enumSet.size();
        for (Enum enum_ : enumSet) {
            int n5;
            int n6 = n5 = --n4 == 0 ? n3 : string.indexOf(c2, n2);
            if (n5 >= 0) {
                enumMap.put(enum_, string.substring(n2, n5));
                n2 = n5;
                while (++n2 < n3 && string.charAt(n2) == c2) {
                }
                continue;
            }
            enumMap.put(enum_, string.substring(n2));
            break;
        }
        return enumMap;
    }

    static {
        TZ_OFFSET = TimeZone.getDefault().getOffset(System.currentTimeMillis());
        whitespacesColonWhitespace = Pattern.compile("\\s+:\\s");
        whitespaces = Pattern.compile("\\s+");
        notDigits = Pattern.compile("[^0-9]+");
        startWithNotDigits = Pattern.compile("^[^0-9]*");
        slash = Pattern.compile("\\/");
        multipliers = new HashMap<String, Long>();
        multipliers.put(HZ, 1L);
        multipliers.put(KHZ, 1000L);
        multipliers.put(MHZ, 1000000L);
        multipliers.put(GHZ, 1000000000L);
        multipliers.put(THZ, 1000000000000L);
        multipliers.put(PHZ, 1000000000000000L);
        POWERS_OF_TEN = new long[]{1L, 10L, 100L, 1000L, 10000L, 100000L, 1000000L, 10000000L, 100000000L, 1000000000L, 10000000000L, 100000000000L, 1000000000000L, 10000000000000L, 100000000000000L, 1000000000000000L, 10000000000000000L, 100000000000000000L, 1000000000000000000L};
        CIM_FORMAT = DateTimeFormatter.ofPattern("yyyyMMddHHmmss.SSSSSSZZZZZ", Locale.US);
    }
}

