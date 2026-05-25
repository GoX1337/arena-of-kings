/*
 * Decompiled with CFR 0.152.
 */
package org.json;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class CDL {
    private static String getValue(JSONTokener jSONTokener) {
        char c2;
        while ((c2 = jSONTokener.next()) == ' ' || c2 == '\t') {
        }
        switch (c2) {
            case '\u0000': {
                return null;
            }
            case '\"': 
            case '\'': {
                char c3 = c2;
                StringBuffer stringBuffer = new StringBuffer();
                while ((c2 = jSONTokener.next()) != c3) {
                    if (c2 == '\u0000' || c2 == '\n' || c2 == '\r') {
                        throw jSONTokener.syntaxError("Missing close quote '" + c3 + "'.");
                    }
                    stringBuffer.append(c2);
                }
                return stringBuffer.toString();
            }
            case ',': {
                jSONTokener.back();
                return "";
            }
        }
        jSONTokener.back();
        return jSONTokener.nextTo(',');
    }

    public static JSONArray rowToJSONArray(JSONTokener jSONTokener) {
        JSONArray jSONArray = new JSONArray();
        block0: while (true) {
            String string = CDL.getValue(jSONTokener);
            char c2 = jSONTokener.next();
            if (string == null || jSONArray.length() == 0 && string.length() == 0 && c2 != ',') {
                return null;
            }
            jSONArray.put(string);
            while (true) {
                if (c2 == ',') continue block0;
                if (c2 != ' ') {
                    if (c2 == '\n' || c2 == '\r' || c2 == '\u0000') {
                        return jSONArray;
                    }
                    throw jSONTokener.syntaxError("Bad character '" + c2 + "' (" + c2 + ").");
                }
                c2 = jSONTokener.next();
            }
            break;
        }
    }

    public static JSONObject rowToJSONObject(JSONArray jSONArray, JSONTokener jSONTokener) {
        JSONArray jSONArray2 = CDL.rowToJSONArray(jSONTokener);
        return jSONArray2 != null ? jSONArray2.toJSONObject(jSONArray) : null;
    }

    public static String rowToString(JSONArray jSONArray) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < jSONArray.length(); ++i2) {
            Object object;
            if (i2 > 0) {
                stringBuffer.append(',');
            }
            if ((object = jSONArray.opt(i2)) == null) continue;
            String string = object.toString();
            if (string.length() > 0 && (string.indexOf(44) >= 0 || string.indexOf(10) >= 0 || string.indexOf(13) >= 0 || string.indexOf(0) >= 0 || string.charAt(0) == '\"')) {
                stringBuffer.append('\"');
                int n2 = string.length();
                for (int i3 = 0; i3 < n2; ++i3) {
                    char c2 = string.charAt(i3);
                    if (c2 < ' ' || c2 == '\"') continue;
                    stringBuffer.append(c2);
                }
                stringBuffer.append('\"');
                continue;
            }
            stringBuffer.append(string);
        }
        stringBuffer.append('\n');
        return stringBuffer.toString();
    }

    public static JSONArray toJSONArray(String string) {
        return CDL.toJSONArray(new JSONTokener(string));
    }

    public static JSONArray toJSONArray(JSONTokener jSONTokener) {
        return CDL.toJSONArray(CDL.rowToJSONArray(jSONTokener), jSONTokener);
    }

    public static JSONArray toJSONArray(JSONArray jSONArray, String string) {
        return CDL.toJSONArray(jSONArray, new JSONTokener(string));
    }

    public static JSONArray toJSONArray(JSONArray jSONArray, JSONTokener jSONTokener) {
        JSONObject jSONObject;
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        JSONArray jSONArray2 = new JSONArray();
        while ((jSONObject = CDL.rowToJSONObject(jSONArray, jSONTokener)) != null) {
            jSONArray2.put(jSONObject);
        }
        if (jSONArray2.length() == 0) {
            return null;
        }
        return jSONArray2;
    }

    public static String toString(JSONArray jSONArray) {
        JSONArray jSONArray2;
        JSONObject jSONObject = jSONArray.optJSONObject(0);
        if (jSONObject != null && (jSONArray2 = jSONObject.names()) != null) {
            return CDL.rowToString(jSONArray2) + CDL.toString(jSONArray2, jSONArray);
        }
        return null;
    }

    public static String toString(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < jSONArray2.length(); ++i2) {
            JSONObject jSONObject = jSONArray2.optJSONObject(i2);
            if (jSONObject == null) continue;
            stringBuffer.append(CDL.rowToString(jSONObject.toJSONArray(jSONArray)));
        }
        return stringBuffer.toString();
    }
}

