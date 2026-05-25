/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils;

import com.badlogic.gdx.utils.ObjectMap;
import com.badlogic.gdx.utils.StringBuilder;
import java.io.BufferedReader;
import java.io.Reader;
import java.io.Writer;
import java.util.Date;

public final class PropertiesUtils {
    private static final int NONE = 0;
    private static final int SLASH = 1;
    private static final int UNICODE = 2;
    private static final int CONTINUE = 3;
    private static final int KEY_DONE = 4;
    private static final int IGNORE = 5;
    private static final String LINE_SEPARATOR = "\n";

    private PropertiesUtils() {
    }

    public static void load(ObjectMap<String, String> objectMap, Reader reader) {
        int n2;
        if (objectMap == null) {
            throw new NullPointerException("properties cannot be null");
        }
        if (reader == null) {
            throw new NullPointerException("reader cannot be null");
        }
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        char[] cArray = new char[40];
        int n6 = 0;
        int n7 = -1;
        boolean bl2 = true;
        BufferedReader bufferedReader = new BufferedReader(reader);
        block17: while ((n2 = bufferedReader.read()) != -1) {
            Object object;
            int n8 = n2;
            if (n6 == cArray.length) {
                object = new char[cArray.length * 2];
                System.arraycopy(cArray, 0, object, 0, n6);
                cArray = object;
            }
            if (n3 == 2) {
                int n9 = Character.digit((char)n8, 16);
                if (n9 >= 0) {
                    n4 = (n4 << 4) + n9;
                    if (++n5 < 4) {
                        continue;
                    }
                } else if (n5 <= 4) {
                    throw new IllegalArgumentException("Invalid Unicode sequence: illegal character");
                }
                n3 = 0;
                cArray[n6++] = (char)n4;
                if (n8 != 10) continue;
            }
            if (n3 == 1) {
                n3 = 0;
                switch (n8) {
                    case 13: {
                        n3 = 3;
                        continue block17;
                    }
                    case 10: {
                        n3 = 5;
                        continue block17;
                    }
                    case 98: {
                        n8 = 8;
                        break;
                    }
                    case 102: {
                        n8 = 12;
                        break;
                    }
                    case 110: {
                        n8 = 10;
                        break;
                    }
                    case 114: {
                        n8 = 13;
                        break;
                    }
                    case 116: {
                        n8 = 9;
                        break;
                    }
                    case 117: {
                        n3 = 2;
                        n5 = 0;
                        n4 = 0;
                        continue block17;
                    }
                }
            } else {
                switch (n8) {
                    case 33: 
                    case 35: {
                        if (!bl2) break;
                        while ((n2 = bufferedReader.read()) != -1 && (n8 = (int)((char)n2)) != 13 && n8 != 10) {
                        }
                        continue block17;
                    }
                    case 10: {
                        if (n3 == 3) {
                            n3 = 5;
                            continue block17;
                        }
                    }
                    case 13: {
                        n3 = 0;
                        bl2 = true;
                        if (n6 > 0 || n6 == 0 && n7 == 0) {
                            if (n7 == -1) {
                                n7 = n6;
                            }
                            object = new String(cArray, 0, n6);
                            objectMap.put(((String)object).substring(0, n7), ((String)object).substring(n7));
                        }
                        n7 = -1;
                        n6 = 0;
                        continue block17;
                    }
                    case 92: {
                        if (n3 == 4) {
                            n7 = n6;
                        }
                        n3 = 1;
                        continue block17;
                    }
                    case 58: 
                    case 61: {
                        if (n7 != -1) break;
                        n3 = 0;
                        n7 = n6;
                        continue block17;
                    }
                }
                if (Character.isSpace((char)n8)) {
                    if (n3 == 3) {
                        n3 = 5;
                    }
                    if (n6 == 0 || n6 == n7 || n3 == 5) continue;
                    if (n7 == -1) {
                        n3 = 4;
                        continue;
                    }
                }
                if (n3 == 5 || n3 == 3) {
                    n3 = 0;
                }
            }
            bl2 = false;
            if (n3 == 4) {
                n7 = n6;
                n3 = 0;
            }
            cArray[n6++] = n8;
        }
        if (n3 == 2 && n5 <= 4) {
            throw new IllegalArgumentException("Invalid Unicode sequence: expected format \\uxxxx");
        }
        if (n7 == -1 && n6 > 0) {
            n7 = n6;
        }
        if (n7 >= 0) {
            String string = new String(cArray, 0, n6);
            String string2 = string.substring(0, n7);
            String string3 = string.substring(n7);
            if (n3 == 1) {
                string3 = string3 + "\u0000";
            }
            objectMap.put(string2, string3);
        }
    }

    public static void store(ObjectMap<String, String> objectMap, Writer writer, String string) {
        PropertiesUtils.storeImpl(objectMap, writer, string, false);
    }

    private static void storeImpl(ObjectMap<String, String> objectMap, Writer writer, String string, boolean bl2) {
        if (string != null) {
            PropertiesUtils.writeComment(writer, string);
        }
        writer.write("#");
        writer.write(new Date().toString());
        writer.write(LINE_SEPARATOR);
        StringBuilder stringBuilder = new StringBuilder(200);
        for (ObjectMap.Entry entry : objectMap.entries()) {
            PropertiesUtils.dumpString(stringBuilder, (String)entry.key, true, bl2);
            stringBuilder.append('=');
            PropertiesUtils.dumpString(stringBuilder, (String)entry.value, false, bl2);
            writer.write(LINE_SEPARATOR);
            writer.write(stringBuilder.toString());
            stringBuilder.setLength(0);
        }
        writer.flush();
    }

    private static void dumpString(StringBuilder stringBuilder, String string, boolean bl2, boolean bl3) {
        int n2 = string.length();
        block8: for (int i2 = 0; i2 < n2; ++i2) {
            char c2 = string.charAt(i2);
            if (c2 > '=' && c2 < '\u007f') {
                stringBuilder.append(c2 == '\\' ? "\\\\" : Character.valueOf(c2));
                continue;
            }
            switch (c2) {
                case ' ': {
                    if (i2 == 0 || bl2) {
                        stringBuilder.append("\\ ");
                        continue block8;
                    }
                    stringBuilder.append(c2);
                    continue block8;
                }
                case '\n': {
                    stringBuilder.append("\\n");
                    continue block8;
                }
                case '\r': {
                    stringBuilder.append("\\r");
                    continue block8;
                }
                case '\t': {
                    stringBuilder.append("\\t");
                    continue block8;
                }
                case '\f': {
                    stringBuilder.append("\\f");
                    continue block8;
                }
                case '!': 
                case '#': 
                case ':': 
                case '=': {
                    stringBuilder.append('\\').append(c2);
                    continue block8;
                }
                default: {
                    if ((c2 < ' ' || c2 > '~') & bl3) {
                        String string2 = Integer.toHexString(c2);
                        stringBuilder.append("\\u");
                        for (int i3 = 0; i3 < 4 - string2.length(); ++i3) {
                            stringBuilder.append('0');
                        }
                        stringBuilder.append(string2);
                        continue block8;
                    }
                    stringBuilder.append(c2);
                }
            }
        }
    }

    private static void writeComment(Writer writer, String string) {
        int n2;
        writer.write("#");
        int n3 = string.length();
        int n4 = 0;
        for (n2 = 0; n2 < n3; ++n2) {
            char c2 = string.charAt(n2);
            if (c2 <= '\u00ff' && c2 != '\n' && c2 != '\r') continue;
            if (n4 != n2) {
                writer.write(string.substring(n4, n2));
            }
            if (c2 > '\u00ff') {
                String string2 = Integer.toHexString(c2);
                writer.write("\\u");
                for (int i2 = 0; i2 < 4 - string2.length(); ++i2) {
                    writer.write(48);
                }
                writer.write(string2);
            } else {
                writer.write(LINE_SEPARATOR);
                if (c2 == '\r' && n2 != n3 - 1 && string.charAt(n2 + 1) == '\n') {
                    ++n2;
                }
                if (n2 == n3 - 1 || string.charAt(n2 + 1) != '#' && string.charAt(n2 + 1) != '!') {
                    writer.write("#");
                }
            }
            n4 = n2 + 1;
        }
        if (n4 != n2) {
            writer.write(string.substring(n4, n2));
        }
        writer.write(LINE_SEPARATOR);
    }
}

