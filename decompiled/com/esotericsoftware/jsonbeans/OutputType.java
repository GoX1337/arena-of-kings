/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.jsonbeans;

import java.util.regex.Pattern;

public enum OutputType {
    json,
    javascript,
    minimal;

    private static Pattern javascriptPattern;
    private static Pattern minimalNamePattern;
    private static Pattern minimalValuePattern;

    public String quoteValue(Object object) {
        int n2;
        if (object == null) {
            return "null";
        }
        String string = object.toString();
        if (object instanceof Number || object instanceof Boolean) {
            return string;
        }
        StringBuilder stringBuilder = new StringBuilder(string);
        OutputType.replace(stringBuilder, '\\', "\\\\");
        OutputType.replace(stringBuilder, '\r', "\\r");
        OutputType.replace(stringBuilder, '\n', "\\n");
        OutputType.replace(stringBuilder, '\t', "\\t");
        if (!(this != minimal || string.equals("true") || string.equals("false") || string.equals("null") || string.contains("//") || string.contains("/*") || (n2 = stringBuilder.length()) <= 0 || stringBuilder.charAt(n2 - 1) == ' ' || !minimalValuePattern.matcher(stringBuilder).matches())) {
            return stringBuilder.toString();
        }
        return '\"' + OutputType.replace(stringBuilder, '\"', "\\\"").toString() + '\"';
    }

    public String quoteName(String string) {
        StringBuilder stringBuilder = new StringBuilder(string);
        OutputType.replace(stringBuilder, '\\', "\\\\");
        OutputType.replace(stringBuilder, '\r', "\\r");
        OutputType.replace(stringBuilder, '\n', "\\n");
        OutputType.replace(stringBuilder, '\t', "\\t");
        switch (this) {
            case minimal: {
                if (!string.contains("//") && !string.contains("/*") && minimalNamePattern.matcher(stringBuilder).matches()) {
                    return stringBuilder.toString();
                }
            }
            case javascript: {
                if (!javascriptPattern.matcher(stringBuilder).matches()) break;
                return stringBuilder.toString();
            }
        }
        return '\"' + OutputType.replace(stringBuilder, '\"', "\\\"").toString() + '\"';
    }

    private static StringBuilder replace(StringBuilder stringBuilder, char c2, String string) {
        int n2 = string.length();
        int n3 = 0;
        while (n3 != stringBuilder.length()) {
            if (stringBuilder.charAt(n3) != c2) {
                ++n3;
                continue;
            }
            stringBuilder.replace(n3, n3 + 1, string);
            n3 += n2;
        }
        return stringBuilder;
    }

    static {
        javascriptPattern = Pattern.compile("^[a-zA-Z_$][a-zA-Z_$0-9]*$");
        minimalNamePattern = Pattern.compile("^[^\":,}/ ][^:]*$");
        minimalValuePattern = Pattern.compile("^[^\":,{\\[\\]/ ][^}\\],]*$");
    }
}

