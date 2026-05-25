/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.apache.commons.lang3.StringUtils;

public class LocaleUtils {
    private static final ConcurrentMap<String, List<Locale>> cLanguagesByCountry = new ConcurrentHashMap<String, List<Locale>>();
    private static final ConcurrentMap<String, List<Locale>> cCountriesByLanguage = new ConcurrentHashMap<String, List<Locale>>();

    public static List<Locale> availableLocaleList() {
        return SyncAvoid.AVAILABLE_LOCALE_LIST;
    }

    public static Set<Locale> availableLocaleSet() {
        return SyncAvoid.AVAILABLE_LOCALE_SET;
    }

    public static List<Locale> countriesByLanguage(String string) {
        if (string == null) {
            return Collections.emptyList();
        }
        List<Locale> list = (ArrayList)cCountriesByLanguage.get(string);
        if (list == null) {
            list = new ArrayList();
            List<Locale> list2 = LocaleUtils.availableLocaleList();
            for (Locale locale : list2) {
                if (!string.equals(locale.getLanguage()) || locale.getCountry().isEmpty() || !locale.getVariant().isEmpty()) continue;
                list.add(locale);
            }
            list = Collections.unmodifiableList(list);
            cCountriesByLanguage.putIfAbsent(string, list);
            list = (List)cCountriesByLanguage.get(string);
        }
        return list;
    }

    public static boolean isAvailableLocale(Locale locale) {
        return LocaleUtils.availableLocaleList().contains(locale);
    }

    private static boolean isISO3166CountryCode(String string) {
        return StringUtils.isAllUpperCase(string) && string.length() == 2;
    }

    private static boolean isISO639LanguageCode(String string) {
        return StringUtils.isAllLowerCase(string) && (string.length() == 2 || string.length() == 3);
    }

    private static boolean isNumericAreaCode(String string) {
        return StringUtils.isNumeric(string) && string.length() == 3;
    }

    public static List<Locale> languagesByCountry(String string) {
        if (string == null) {
            return Collections.emptyList();
        }
        List<Locale> list = (ArrayList)cLanguagesByCountry.get(string);
        if (list == null) {
            list = new ArrayList();
            List<Locale> list2 = LocaleUtils.availableLocaleList();
            for (Locale locale : list2) {
                if (!string.equals(locale.getCountry()) || !locale.getVariant().isEmpty()) continue;
                list.add(locale);
            }
            list = Collections.unmodifiableList(list);
            cLanguagesByCountry.putIfAbsent(string, list);
            list = (List)cLanguagesByCountry.get(string);
        }
        return list;
    }

    public static List<Locale> localeLookupList(Locale locale) {
        return LocaleUtils.localeLookupList(locale, locale);
    }

    public static List<Locale> localeLookupList(Locale locale, Locale locale2) {
        ArrayList<Locale> arrayList = new ArrayList<Locale>(4);
        if (locale != null) {
            arrayList.add(locale);
            if (!locale.getVariant().isEmpty()) {
                arrayList.add(new Locale(locale.getLanguage(), locale.getCountry()));
            }
            if (!locale.getCountry().isEmpty()) {
                arrayList.add(new Locale(locale.getLanguage(), ""));
            }
            if (!arrayList.contains(locale2)) {
                arrayList.add(locale2);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    private static Locale parseLocale(String string) {
        if (LocaleUtils.isISO639LanguageCode(string)) {
            return new Locale(string);
        }
        String[] stringArray = string.split("_", -1);
        String string2 = stringArray[0];
        if (stringArray.length == 2) {
            String string3 = stringArray[1];
            if (LocaleUtils.isISO639LanguageCode(string2) && LocaleUtils.isISO3166CountryCode(string3) || LocaleUtils.isNumericAreaCode(string3)) {
                return new Locale(string2, string3);
            }
        } else if (stringArray.length == 3) {
            String string4 = stringArray[1];
            String string5 = stringArray[2];
            if (LocaleUtils.isISO639LanguageCode(string2) && (string4.isEmpty() || LocaleUtils.isISO3166CountryCode(string4) || LocaleUtils.isNumericAreaCode(string4)) && !string5.isEmpty()) {
                return new Locale(string2, string4, string5);
            }
        }
        throw new IllegalArgumentException("Invalid locale format: " + string);
    }

    public static Locale toLocale(Locale locale) {
        return locale != null ? locale : Locale.getDefault();
    }

    public static Locale toLocale(String string) {
        if (string == null) {
            return null;
        }
        if (string.isEmpty()) {
            return new Locale("", "");
        }
        if (string.contains("#")) {
            throw new IllegalArgumentException("Invalid locale format: " + string);
        }
        int n2 = string.length();
        if (n2 < 2) {
            throw new IllegalArgumentException("Invalid locale format: " + string);
        }
        char c2 = string.charAt(0);
        if (c2 == '_') {
            if (n2 < 3) {
                throw new IllegalArgumentException("Invalid locale format: " + string);
            }
            char c3 = string.charAt(1);
            char c4 = string.charAt(2);
            if (!Character.isUpperCase(c3) || !Character.isUpperCase(c4)) {
                throw new IllegalArgumentException("Invalid locale format: " + string);
            }
            if (n2 == 3) {
                return new Locale("", string.substring(1, 3));
            }
            if (n2 < 5) {
                throw new IllegalArgumentException("Invalid locale format: " + string);
            }
            if (string.charAt(3) != '_') {
                throw new IllegalArgumentException("Invalid locale format: " + string);
            }
            return new Locale("", string.substring(1, 3), string.substring(4));
        }
        return LocaleUtils.parseLocale(string);
    }

    static class SyncAvoid {
        private static final List<Locale> AVAILABLE_LOCALE_LIST;
        private static final Set<Locale> AVAILABLE_LOCALE_SET;

        SyncAvoid() {
        }

        static {
            ArrayList<Locale> arrayList = new ArrayList<Locale>(Arrays.asList(Locale.getAvailableLocales()));
            AVAILABLE_LOCALE_LIST = Collections.unmodifiableList(arrayList);
            AVAILABLE_LOCALE_SET = Collections.unmodifiableSet(new HashSet<Locale>(arrayList));
        }
    }
}

