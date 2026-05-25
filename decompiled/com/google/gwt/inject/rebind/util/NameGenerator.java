/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.inject.Key
 *  com.google.inject.Singleton
 */
package com.google.gwt.inject.rebind.util;

import com.google.inject.Key;
import com.google.inject.Singleton;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
@Singleton
public class NameGenerator {
    private final Map<Key<?>, String> cache = new HashMap();
    private final Set<String> methodNames = new HashSet<String>();

    public String getGetterMethodName(Key<?> key) {
        return "get_" + this.mangle(key);
    }

    public String getCreatorMethodName(Key<?> key) {
        return "create_" + this.mangle(key);
    }

    public String getMemberInjectMethodName(Key<?> key) {
        return "memberInject_" + this.mangle(key);
    }

    public String getSingletonFieldName(Key<?> key) {
        return "singleton_" + this.mangle(key);
    }

    public String createMethodName(String string) {
        while (this.methodNames.contains(string)) {
            string = string + "_";
        }
        this.methodNames.add(string);
        return string;
    }

    public void markAsUsed(String string) {
        this.methodNames.add(string);
    }

    private String mangle(Key<?> key) {
        String string = this.cache.get(key);
        if (string != null) {
            return string;
        }
        String string2 = key.toString();
        string2 = this.convertToValidMemberName(string2);
        string2 = this.createMethodName(string2);
        this.cache.put(key, string2);
        return string2;
    }

    public String convertToValidMemberName(String string) {
        string = string.replaceAll("\\s+", "_");
        string = string.replaceAll("[^\\p{Alnum}_]", "\\$");
        return string;
    }

    public static String replaceLast(String string, char c2, char c3) {
        StringBuilder stringBuilder = new StringBuilder(string);
        int n2 = stringBuilder.lastIndexOf(String.valueOf(c2));
        if (n2 != -1) {
            stringBuilder.setCharAt(n2, c3);
        }
        return stringBuilder.toString();
    }
}

