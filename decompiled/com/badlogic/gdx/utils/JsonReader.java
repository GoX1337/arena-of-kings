/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.BaseJsonReader;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.Null;
import com.badlogic.gdx.utils.SerializationException;
import com.badlogic.gdx.utils.StreamUtils;
import com.badlogic.gdx.utils.StringBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class JsonReader
implements BaseJsonReader {
    private static final byte[] _json_actions = JsonReader.init__json_actions_0();
    private static final short[] _json_key_offsets = JsonReader.init__json_key_offsets_0();
    private static final char[] _json_trans_keys = JsonReader.init__json_trans_keys_0();
    private static final byte[] _json_single_lengths = JsonReader.init__json_single_lengths_0();
    private static final byte[] _json_range_lengths = JsonReader.init__json_range_lengths_0();
    private static final short[] _json_index_offsets = JsonReader.init__json_index_offsets_0();
    private static final byte[] _json_indicies = JsonReader.init__json_indicies_0();
    private static final byte[] _json_trans_targs = JsonReader.init__json_trans_targs_0();
    private static final byte[] _json_trans_actions = JsonReader.init__json_trans_actions_0();
    private static final byte[] _json_eof_actions = JsonReader.init__json_eof_actions_0();
    static final int json_start = 1;
    static final int json_first_final = 35;
    static final int json_error = 0;
    static final int json_en_object = 5;
    static final int json_en_array = 23;
    static final int json_en_main = 1;
    private final Array<JsonValue> elements = new Array(8);
    private final Array<JsonValue> lastChild = new Array(8);
    private JsonValue root;
    private JsonValue current;

    public JsonValue parse(String string) {
        char[] cArray = string.toCharArray();
        return this.parse(cArray, 0, cArray.length);
    }

    public JsonValue parse(Reader reader) {
        char[] cArray = new char[1024];
        int n2 = 0;
        try {
            int n3;
            while ((n3 = reader.read(cArray, n2, cArray.length - n2)) != -1) {
                if (n3 == 0) {
                    char[] cArray2 = new char[cArray.length * 2];
                    System.arraycopy(cArray, 0, cArray2, 0, cArray.length);
                    cArray = cArray2;
                    continue;
                }
                n2 += n3;
            }
        }
        catch (IOException iOException) {
            throw new SerializationException("Error reading input.", iOException);
        }
        finally {
            StreamUtils.closeQuietly(reader);
        }
        return this.parse(cArray, 0, n2);
    }

    @Override
    public JsonValue parse(InputStream inputStream) {
        InputStreamReader inputStreamReader;
        try {
            inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
        }
        catch (Exception exception) {
            throw new SerializationException("Error reading stream.", exception);
        }
        return this.parse(inputStreamReader);
    }

    @Override
    public JsonValue parse(FileHandle fileHandle) {
        Reader reader;
        try {
            reader = fileHandle.reader("UTF-8");
        }
        catch (Exception exception) {
            throw new SerializationException("Error reading file: " + fileHandle, exception);
        }
        try {
            return this.parse(reader);
        }
        catch (Exception exception) {
            throw new SerializationException("Error parsing file: " + fileHandle, exception);
        }
    }

    /*
     * Unable to fully structure code
     */
    public JsonValue parse(char[] var1_1, int var2_2, int var3_3) {
        var5_4 = var2_2;
        var7_6 = var6_5 = var3_3;
        var8_7 = 0;
        var9_8 = new int[4];
        var10_9 = 0;
        var11_10 = new Array<String>(8);
        var12_11 = false;
        var13_12 = false;
        var14_13 = false;
        var15_14 = null;
        var16_15 = false;
        if (var16_15) {
            System.out.println();
        }
        try {
            var4_16 = 1;
            var8_7 = 0;
            var18_17 = 0;
            var22_19 = 0;
            block52: while (true) {
                switch (var22_19) {
                    case 0: {
                        if (var5_4 == var6_5) {
                            var22_19 = 4;
                            continue block52;
                        }
                        if (var4_16 == 0) {
                            var22_19 = 5;
                            continue block52;
                        }
                    }
                    case 1: {
                        var21_26 = JsonReader._json_key_offsets[var4_16];
                        var18_17 = JsonReader._json_index_offsets[var4_16];
                        var17_20 = JsonReader._json_single_lengths[var4_16];
                        if (var17_20 <= 0) ** GOTO lbl47
                        var23_27 = var21_26;
                        var25_35 = var21_26 + var17_20 - 1;
                        while (var25_35 >= var23_27) {
                            var24_31 = var23_27 + (var25_35 - var23_27 >> 1);
                            if (var1_1[var5_4] < JsonReader._json_trans_keys[var24_31]) {
                                var25_35 = var24_31 - 1;
                                continue;
                            }
                            if (var1_1[var5_4] > JsonReader._json_trans_keys[var24_31]) {
                                var23_27 = var24_31 + 1;
                                continue;
                            }
                            var18_17 += var24_31 - var21_26;
                            ** GOTO lbl61
                        }
                        var21_26 += var17_20;
                        var18_17 += var17_20;
lbl47:
                        // 2 sources

                        if ((var17_20 = JsonReader._json_range_lengths[var4_16]) > 0) {
                            var23_27 = var21_26;
                            var25_35 = var21_26 + (var17_20 << 1) - 2;
                            while (var25_35 >= var23_27) {
                                var24_31 = var23_27 + (var25_35 - var23_27 >> 1 & -2);
                                if (var1_1[var5_4] < JsonReader._json_trans_keys[var24_31]) {
                                    var25_35 = var24_31 - 2;
                                    continue;
                                }
                                if (var1_1[var5_4] > JsonReader._json_trans_keys[var24_31 + 1]) {
                                    var23_27 = var24_31 + 2;
                                    continue;
                                }
                                var18_17 += var24_31 - var21_26 >> 1;
                                ** GOTO lbl61
                            }
                            var18_17 += var17_20;
                        }
lbl61:
                        // 5 sources

                        var18_17 = JsonReader._json_indicies[var18_17];
                        var4_16 = JsonReader._json_trans_targs[var18_17];
                        if (JsonReader._json_trans_actions[var18_17] == 0) ** GOTO lbl253
                        var19_24 = JsonReader._json_trans_actions[var18_17];
                        var20_25 = JsonReader._json_actions[var19_24++];
                        block55: while (var20_25-- > 0) {
                            switch (JsonReader._json_actions[var19_24++]) {
                                case 0: {
                                    var13_12 = true;
                                    break;
                                }
                                case 1: {
                                    var23_28 = new String(var1_1, var10_9, var5_4 - var10_9);
                                    if (var12_11) {
                                        var23_28 = this.unescape(var23_28);
                                    }
                                    if (!var13_12) ** GOTO lbl81
                                    var13_12 = false;
                                    if (var16_15) {
                                        System.out.println("name: " + var23_28);
                                    }
                                    var11_10.add(var23_28);
                                    ** GOTO lbl129
lbl81:
                                    // 1 sources

                                    v0 = var24_32 = var11_10.size > 0 ? (String)var11_10.pop() : null;
                                    if (!var14_13) ** GOTO lbl126
                                    if (!var23_28.equals("true")) ** GOTO lbl88
                                    if (var16_15) {
                                        System.out.println("boolean: " + var24_32 + "=true");
                                    }
                                    this.bool(var24_32, true);
                                    ** GOTO lbl129
lbl88:
                                    // 1 sources

                                    if (!var23_28.equals("false")) ** GOTO lbl93
                                    if (var16_15) {
                                        System.out.println("boolean: " + var24_32 + "=false");
                                    }
                                    this.bool(var24_32, false);
                                    ** GOTO lbl129
lbl93:
                                    // 1 sources

                                    if (!var23_28.equals("null")) ** GOTO lbl96
                                    this.string(var24_32, null);
                                    ** GOTO lbl129
lbl96:
                                    // 1 sources

                                    var25_35 = 0;
                                    var26_38 = true;
                                    block56: for (var27_41 = var10_9; var27_41 < var5_4; ++var27_41) {
                                        switch (var1_1[var27_41]) {
                                            case '+': 
                                            case '-': 
                                            case '0': 
                                            case '1': 
                                            case '2': 
                                            case '3': 
                                            case '4': 
                                            case '5': 
                                            case '6': 
                                            case '7': 
                                            case '8': 
                                            case '9': {
                                                continue block56;
                                            }
                                            case '.': 
                                            case 'E': 
                                            case 'e': {
                                                var25_35 = 1;
                                                var26_38 = false;
                                                continue block56;
                                            }
                                            default: {
                                                var25_35 = 0;
                                                var26_38 = false;
                                                break block56;
                                            }
                                        }
                                    }
                                    if (var25_35 == 0) ** GOTO lbl118
                                    try {
                                        if (var16_15) {
                                            System.out.println("double: " + var24_32 + "=" + Double.parseDouble(var23_28));
                                        }
                                        this.number(var24_32, Double.parseDouble(var23_28), var23_28);
                                        ** GOTO lbl129
                                    }
                                    catch (NumberFormatException var27_42) {
                                        ** GOTO lbl126
                                    }
lbl118:
                                    // 1 sources

                                    if (!var26_38) ** GOTO lbl126
                                    if (var16_15) {
                                        System.out.println("double: " + var24_32 + "=" + Double.parseDouble(var23_28));
                                    }
                                    try {
                                        this.number(var24_32, Long.parseLong(var23_28), var23_28);
                                        ** GOTO lbl129
                                    }
                                    catch (NumberFormatException var27_43) {
                                        // empty catch block
                                    }
lbl126:
                                    // 4 sources

                                    if (var16_15) {
                                        System.out.println("string: " + var24_32 + "=" + var23_28);
                                    }
                                    this.string(var24_32, var23_28);
lbl129:
                                    // 7 sources

                                    var14_13 = false;
                                    var10_9 = var5_4;
                                    break;
                                }
                                case 2: {
                                    v1 = var23_29 = var11_10.size > 0 ? (String)var11_10.pop() : null;
                                    if (var16_15) {
                                        System.out.println("startObject: " + var23_29);
                                    }
                                    this.startObject(var23_29);
                                    if (var8_7 == var9_8.length) {
                                        var24_33 = new int[var9_8.length * 2];
                                        System.arraycopy(var9_8, 0, var24_33, 0, var9_8.length);
                                        var9_8 = var24_33;
                                    }
                                    var9_8[var8_7++] = var4_16;
                                    var4_16 = 5;
                                    var22_19 = 2;
                                    continue block52;
                                }
                                case 3: {
                                    if (var16_15) {
                                        System.out.println("endObject");
                                    }
                                    this.pop();
                                    var4_16 = var9_8[--var8_7];
                                    var22_19 = 2;
                                    continue block52;
                                }
                                case 4: {
                                    v2 = var23_30 = var11_10.size > 0 ? (String)var11_10.pop() : null;
                                    if (var16_15) {
                                        System.out.println("startArray: " + var23_30);
                                    }
                                    this.startArray(var23_30);
                                    if (var8_7 == var9_8.length) {
                                        var24_34 = new int[var9_8.length * 2];
                                        System.arraycopy(var9_8, 0, var24_34, 0, var9_8.length);
                                        var9_8 = var24_34;
                                    }
                                    var9_8[var8_7++] = var4_16;
                                    var4_16 = 23;
                                    var22_19 = 2;
                                    continue block52;
                                }
                                case 5: {
                                    if (var16_15) {
                                        System.out.println("endArray");
                                    }
                                    this.pop();
                                    var4_16 = var9_8[--var8_7];
                                    var22_19 = 2;
                                    continue block52;
                                }
                                case 6: {
                                    var23_27 = var5_4 - 1;
                                    if (var1_1[var5_4++] == '/') {
                                        while (var5_4 != var7_6 && var1_1[var5_4] != '\n') {
                                            ++var5_4;
                                        }
                                        --var5_4;
                                    } else {
                                        while (var5_4 + 1 < var7_6 && var1_1[var5_4] != '*' || var1_1[var5_4 + 1] != '/') {
                                            ++var5_4;
                                        }
                                        ++var5_4;
                                    }
                                    if (!var16_15) continue block55;
                                    System.out.println("comment " + new String(var1_1, var23_27, var5_4 - var23_27));
                                    break;
                                }
                                case 7: {
                                    if (var16_15) {
                                        System.out.println("unquotedChars");
                                    }
                                    var10_9 = var5_4;
                                    var12_11 = false;
                                    var14_13 = true;
                                    if (!var13_12) ** GOTO lbl214
                                    block59: while (true) {
                                        switch (var1_1[var5_4]) {
                                            case '\\': {
                                                var12_11 = true;
                                                ** GOTO lbl208
                                            }
                                            case '/': {
                                                if (var5_4 + 1 == var7_6) ** GOTO lbl208
                                                var23_27 = var1_1[var5_4 + 1];
                                                if (var23_27 == 47) ** GOTO lbl230
                                                if (var23_27 == 42) {
                                                    break block59;
                                                }
                                                ** GOTO lbl208
                                            }
                                            case '\n': 
                                            case '\r': 
                                            case ':': {
                                                break block59;
                                            }
lbl208:
                                            // 4 sources

                                            default: {
                                                if (!var16_15) continue block59;
                                                System.out.println("unquotedChar (name): '" + var1_1[var5_4] + "'");
                                                if (++var5_4 != var7_6) continue block59;
                                                break block59;
                                            }
                                        }
                                        break;
                                    }
                                    ** GOTO lbl230
lbl214:
                                    // 1 sources

                                    block60: while (true) {
                                        switch (var1_1[var5_4]) {
                                            case '\\': {
                                                var12_11 = true;
                                                ** GOTO lbl225
                                            }
                                            case '/': {
                                                if (var5_4 + 1 != var7_6 && ((var23_27 = var1_1[var5_4 + 1]) == 47 || var23_27 == 42)) {
                                                    break block60;
                                                }
                                                ** GOTO lbl225
                                            }
                                            case '\n': 
                                            case '\r': 
                                            case ',': 
                                            case ']': 
                                            case '}': {
                                                break block60;
                                            }
lbl225:
                                            // 3 sources

                                            default: {
                                                if (!var16_15) continue block60;
                                                System.out.println("unquotedChar (value): '" + var1_1[var5_4] + "'");
                                                if (++var5_4 != var7_6) continue block60;
                                                break block60;
                                            }
                                        }
                                        break;
                                    }
lbl230:
                                    // 5 sources

                                    --var5_4;
                                    while (Character.isSpace(var1_1[var5_4])) {
                                        --var5_4;
                                    }
                                    break;
                                }
                                case 8: {
                                    if (var16_15) {
                                        System.out.println("quotedChars");
                                    }
                                    var10_9 = ++var5_4;
                                    var12_11 = false;
                                    block62: while (true) {
                                        switch (var1_1[var5_4]) {
                                            case '\\': {
                                                var12_11 = true;
                                                ++var5_4;
                                                ** GOTO lbl248
                                            }
                                            case '\"': {
                                                break block62;
                                            }
lbl248:
                                            // 2 sources

                                            default: {
                                                if (++var5_4 != var7_6) continue block62;
                                                break block62;
                                            }
                                        }
                                        break;
                                    }
                                    --var5_4;
                                }
                            }
                        }
                    }
lbl253:
                    // 3 sources

                    case 2: {
                        if (var4_16 == 0) {
                            var22_19 = 5;
                            continue block52;
                        }
                        if (++var5_4 != var6_5) {
                            var22_19 = 1;
                            continue block52;
                        }
                    }
                    case 4: {
                        if (var5_4 != var7_6) break block52;
                        var23_27 = JsonReader._json_eof_actions[var4_16];
                        var24_31 = JsonReader._json_actions[var23_27++];
                        while (var24_31-- > 0) {
                            switch (JsonReader._json_actions[var23_27++]) {
                                case 1: {
                                    var25_37 = new String(var1_1, var10_9, var5_4 - var10_9);
                                    if (var12_11) {
                                        var25_37 = this.unescape(var25_37);
                                    }
                                    if (!var13_12) ** GOTO lbl276
                                    var13_12 = false;
                                    if (var16_15) {
                                        System.out.println("name: " + var25_37);
                                    }
                                    var11_10.add(var25_37);
                                    ** GOTO lbl324
lbl276:
                                    // 1 sources

                                    v3 = var26_40 = var11_10.size > 0 ? (String)var11_10.pop() : null;
                                    if (!var14_13) ** GOTO lbl321
                                    if (!var25_37.equals("true")) ** GOTO lbl283
                                    if (var16_15) {
                                        System.out.println("boolean: " + var26_40 + "=true");
                                    }
                                    this.bool(var26_40, true);
                                    ** GOTO lbl324
lbl283:
                                    // 1 sources

                                    if (!var25_37.equals("false")) ** GOTO lbl288
                                    if (var16_15) {
                                        System.out.println("boolean: " + var26_40 + "=false");
                                    }
                                    this.bool(var26_40, false);
                                    ** GOTO lbl324
lbl288:
                                    // 1 sources

                                    if (!var25_37.equals("null")) ** GOTO lbl291
                                    this.string(var26_40, null);
                                    ** GOTO lbl324
lbl291:
                                    // 1 sources

                                    var27_44 = false;
                                    var28_45 = true;
                                    block64: for (var29_46 = var10_9; var29_46 < var5_4; ++var29_46) {
                                        switch (var1_1[var29_46]) {
                                            case '+': 
                                            case '-': 
                                            case '0': 
                                            case '1': 
                                            case '2': 
                                            case '3': 
                                            case '4': 
                                            case '5': 
                                            case '6': 
                                            case '7': 
                                            case '8': 
                                            case '9': {
                                                continue block64;
                                            }
                                            case '.': 
                                            case 'E': 
                                            case 'e': {
                                                var27_44 = true;
                                                var28_45 = false;
                                                continue block64;
                                            }
                                            default: {
                                                var27_44 = false;
                                                var28_45 = false;
                                                break block64;
                                            }
                                        }
                                    }
                                    if (!var27_44) ** GOTO lbl313
                                    try {
                                        if (var16_15) {
                                            System.out.println("double: " + var26_40 + "=" + Double.parseDouble(var25_37));
                                        }
                                        this.number(var26_40, Double.parseDouble(var25_37), var25_37);
                                        ** GOTO lbl324
                                    }
                                    catch (NumberFormatException var29_47) {
                                        ** GOTO lbl321
                                    }
lbl313:
                                    // 1 sources

                                    if (!var28_45) ** GOTO lbl321
                                    if (var16_15) {
                                        System.out.println("double: " + var26_40 + "=" + Double.parseDouble(var25_37));
                                    }
                                    try {
                                        this.number(var26_40, Long.parseLong(var25_37), var25_37);
                                        ** GOTO lbl324
                                    }
                                    catch (NumberFormatException var29_48) {
                                        // empty catch block
                                    }
lbl321:
                                    // 4 sources

                                    if (var16_15) {
                                        System.out.println("string: " + var26_40 + "=" + var25_37);
                                    }
                                    this.string(var26_40, var25_37);
lbl324:
                                    // 7 sources

                                    var14_13 = false;
                                    var10_9 = var5_4;
                                }
                            }
                        }
                        break block52;
                    }
                }
                break;
            }
        }
        catch (RuntimeException var17_21) {
            var15_14 = var17_21;
        }
        var17_23 = this.root;
        this.root = null;
        this.current = null;
        this.lastChild.clear();
        if (var5_4 < var6_5) {
            var18_17 = 1;
            for (var19_24 = 0; var19_24 < var5_4; ++var19_24) {
                if (var1_1[var19_24] != '\n') continue;
                ++var18_17;
            }
            var19_24 = Math.max(0, var5_4 - 32);
            throw new SerializationException("Error parsing JSON on line " + var18_17 + " near: " + new String(var1_1, var19_24, var5_4 - var19_24) + "*ERROR*" + new String(var1_1, var5_4, Math.min(64, var6_5 - var5_4)), var15_14);
        }
        if (this.elements.size != 0) {
            var18_18 = this.elements.peek();
            this.elements.clear();
            if (var18_18 != null && var18_18.isObject()) {
                throw new SerializationException("Error parsing JSON, unmatched brace.");
            }
            throw new SerializationException("Error parsing JSON, unmatched bracket.");
        }
        if (var15_14 != null) {
            throw new SerializationException("Error parsing JSON: " + new String(var1_1), var15_14);
        }
        return var17_23;
    }

    private static byte[] init__json_actions_0() {
        return new byte[]{0, 1, 1, 1, 2, 1, 3, 1, 4, 1, 5, 1, 6, 1, 7, 1, 8, 2, 0, 7, 2, 0, 8, 2, 1, 3, 2, 1, 5};
    }

    private static short[] init__json_key_offsets_0() {
        return new short[]{0, 0, 11, 13, 14, 16, 25, 31, 37, 39, 50, 57, 64, 73, 74, 83, 85, 87, 96, 98, 100, 101, 103, 105, 116, 123, 130, 141, 142, 153, 155, 157, 168, 170, 172, 174, 179, 184, 184};
    }

    private static char[] init__json_trans_keys_0() {
        return new char[]{'\r', ' ', '\"', ',', '/', ':', '[', ']', '{', '\t', '\n', '*', '/', '\"', '*', '/', '\r', ' ', '\"', ',', '/', ':', '}', '\t', '\n', '\r', ' ', '/', ':', '\t', '\n', '\r', ' ', '/', ':', '\t', '\n', '*', '/', '\r', ' ', '\"', ',', '/', ':', '[', ']', '{', '\t', '\n', '\t', '\n', '\r', ' ', ',', '/', '}', '\t', '\n', '\r', ' ', ',', '/', '}', '\r', ' ', '\"', ',', '/', ':', '}', '\t', '\n', '\"', '\r', ' ', '\"', ',', '/', ':', '}', '\t', '\n', '*', '/', '*', '/', '\r', ' ', '\"', ',', '/', ':', '}', '\t', '\n', '*', '/', '*', '/', '\"', '*', '/', '*', '/', '\r', ' ', '\"', ',', '/', ':', '[', ']', '{', '\t', '\n', '\t', '\n', '\r', ' ', ',', '/', ']', '\t', '\n', '\r', ' ', ',', '/', ']', '\r', ' ', '\"', ',', '/', ':', '[', ']', '{', '\t', '\n', '\"', '\r', ' ', '\"', ',', '/', ':', '[', ']', '{', '\t', '\n', '*', '/', '*', '/', '\r', ' ', '\"', ',', '/', ':', '[', ']', '{', '\t', '\n', '*', '/', '*', '/', '*', '/', '\r', ' ', '/', '\t', '\n', '\r', ' ', '/', '\t', '\n', '\u0000'};
    }

    private static byte[] init__json_single_lengths_0() {
        return new byte[]{0, 9, 2, 1, 2, 7, 4, 4, 2, 9, 7, 7, 7, 1, 7, 2, 2, 7, 2, 2, 1, 2, 2, 9, 7, 7, 9, 1, 9, 2, 2, 9, 2, 2, 2, 3, 3, 0, 0};
    }

    private static byte[] init__json_range_lengths_0() {
        return new byte[]{0, 1, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0};
    }

    private static short[] init__json_index_offsets_0() {
        return new short[]{0, 0, 11, 14, 16, 19, 28, 34, 40, 43, 54, 62, 70, 79, 81, 90, 93, 96, 105, 108, 111, 113, 116, 119, 130, 138, 146, 157, 159, 170, 173, 176, 187, 190, 193, 196, 201, 206, 207};
    }

    private static byte[] init__json_indicies_0() {
        return new byte[]{1, 1, 2, 3, 4, 3, 5, 3, 6, 1, 0, 7, 7, 3, 8, 3, 9, 9, 3, 11, 11, 12, 13, 14, 3, 15, 11, 10, 16, 16, 17, 18, 16, 3, 19, 19, 20, 21, 19, 3, 22, 22, 3, 21, 21, 24, 3, 25, 3, 26, 3, 27, 21, 23, 28, 29, 29, 28, 30, 31, 32, 3, 33, 34, 34, 33, 13, 35, 15, 3, 34, 34, 12, 36, 37, 3, 15, 34, 10, 16, 3, 36, 36, 12, 3, 38, 3, 3, 36, 10, 39, 39, 3, 40, 40, 3, 13, 13, 12, 3, 41, 3, 15, 13, 10, 42, 42, 3, 43, 43, 3, 28, 3, 44, 44, 3, 45, 45, 3, 47, 47, 48, 49, 50, 3, 51, 52, 53, 47, 46, 54, 55, 55, 54, 56, 57, 58, 3, 59, 60, 60, 59, 49, 61, 52, 3, 60, 60, 48, 62, 63, 3, 51, 52, 53, 60, 46, 54, 3, 62, 62, 48, 3, 64, 3, 51, 3, 53, 62, 46, 65, 65, 3, 66, 66, 3, 49, 49, 48, 3, 67, 3, 51, 52, 53, 49, 46, 68, 68, 3, 69, 69, 3, 70, 70, 3, 8, 8, 71, 8, 3, 72, 72, 73, 72, 3, 3, 3, 0};
    }

    private static byte[] init__json_trans_targs_0() {
        return new byte[]{35, 1, 3, 0, 4, 36, 36, 36, 36, 1, 6, 5, 13, 17, 22, 37, 7, 8, 9, 7, 8, 9, 7, 10, 20, 21, 11, 11, 11, 12, 17, 19, 37, 11, 12, 19, 14, 16, 15, 14, 12, 18, 17, 11, 9, 5, 24, 23, 27, 31, 34, 25, 38, 25, 25, 26, 31, 33, 38, 25, 26, 33, 28, 30, 29, 28, 26, 32, 31, 25, 23, 2, 36, 2};
    }

    private static byte[] init__json_trans_actions_0() {
        return new byte[]{13, 0, 15, 0, 0, 7, 3, 11, 1, 11, 17, 0, 20, 0, 0, 5, 1, 1, 1, 0, 0, 0, 11, 13, 15, 0, 7, 3, 1, 1, 1, 1, 23, 0, 0, 0, 0, 0, 0, 11, 11, 0, 11, 11, 11, 11, 13, 0, 15, 0, 0, 7, 9, 3, 1, 1, 1, 1, 26, 0, 0, 0, 0, 0, 0, 11, 11, 0, 11, 11, 11, 1, 0, 0};
    }

    private static byte[] init__json_eof_actions_0() {
        return new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0};
    }

    private void addChild(@Null String string, JsonValue jsonValue) {
        jsonValue.setName(string);
        if (this.current == null) {
            this.current = jsonValue;
            this.root = jsonValue;
        } else if (this.current.isArray() || this.current.isObject()) {
            jsonValue.parent = this.current;
            if (this.current.size == 0) {
                this.current.child = jsonValue;
            } else {
                JsonValue jsonValue2 = this.lastChild.pop();
                jsonValue2.next = jsonValue;
                jsonValue.prev = jsonValue2;
            }
            this.lastChild.add(jsonValue);
            ++this.current.size;
        } else {
            this.root = this.current;
        }
    }

    protected void startObject(@Null String string) {
        JsonValue jsonValue = new JsonValue(JsonValue.ValueType.object);
        if (this.current != null) {
            this.addChild(string, jsonValue);
        }
        this.elements.add(jsonValue);
        this.current = jsonValue;
    }

    protected void startArray(@Null String string) {
        JsonValue jsonValue = new JsonValue(JsonValue.ValueType.array);
        if (this.current != null) {
            this.addChild(string, jsonValue);
        }
        this.elements.add(jsonValue);
        this.current = jsonValue;
    }

    protected void pop() {
        this.root = this.elements.pop();
        if (this.current.size > 0) {
            this.lastChild.pop();
        }
        this.current = this.elements.size > 0 ? this.elements.peek() : null;
    }

    protected void string(String string, String string2) {
        this.addChild(string, new JsonValue(string2));
    }

    protected void number(String string, double d2, String string2) {
        this.addChild(string, new JsonValue(d2, string2));
    }

    protected void number(String string, long l2, String string2) {
        this.addChild(string, new JsonValue(l2, string2));
    }

    protected void bool(String string, boolean bl2) {
        this.addChild(string, new JsonValue(bl2));
    }

    private String unescape(String string) {
        int n2 = string.length();
        StringBuilder stringBuilder = new StringBuilder(n2 + 16);
        int n3 = 0;
        while (n3 < n2) {
            char c2;
            if ((c2 = string.charAt(n3++)) != '\\') {
                stringBuilder.append(c2);
                continue;
            }
            if (n3 == n2) break;
            if ((c2 = string.charAt(n3++)) == 'u') {
                stringBuilder.append(Character.toChars(Integer.parseInt(string.substring(n3, n3 + 4), 16)));
                n3 += 4;
                continue;
            }
            switch (c2) {
                case '\"': 
                case '/': 
                case '\\': {
                    break;
                }
                case 'b': {
                    c2 = '\b';
                    break;
                }
                case 'f': {
                    c2 = '\f';
                    break;
                }
                case 'n': {
                    c2 = '\n';
                    break;
                }
                case 'r': {
                    c2 = '\r';
                    break;
                }
                case 't': {
                    c2 = '\t';
                    break;
                }
                default: {
                    throw new SerializationException("Illegal escaped character: \\" + c2);
                }
            }
            stringBuilder.append(c2);
        }
        return stringBuilder.toString();
    }
}

