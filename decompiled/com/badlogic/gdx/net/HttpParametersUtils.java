/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.net;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Set;

public final class HttpParametersUtils {
    public static String defaultEncoding = "UTF-8";
    public static String nameValueSeparator = "=";
    public static String parameterSeparator = "&";

    private HttpParametersUtils() {
    }

    public static String convertHttpParameters(Map<String, String> map) {
        Set<String> set = map.keySet();
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : set) {
            stringBuilder.append(HttpParametersUtils.encode(string, defaultEncoding));
            stringBuilder.append(nameValueSeparator);
            stringBuilder.append(HttpParametersUtils.encode(map.get(string), defaultEncoding));
            stringBuilder.append(parameterSeparator);
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        return stringBuilder.toString();
    }

    private static String encode(String string, String string2) {
        try {
            return URLEncoder.encode(string, string2);
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            throw new IllegalArgumentException(unsupportedEncodingException);
        }
    }
}

