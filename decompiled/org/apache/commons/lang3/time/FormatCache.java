/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3.time;

import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.apache.commons.lang3.LocaleUtils;
import org.apache.commons.lang3.Validate;

abstract class FormatCache<F extends Format> {
    static final int NONE = -1;
    private final ConcurrentMap<ArrayKey, F> cInstanceCache = new ConcurrentHashMap<ArrayKey, F>(7);
    private static final ConcurrentMap<ArrayKey, String> cDateTimeInstanceCache = new ConcurrentHashMap<ArrayKey, String>(7);

    FormatCache() {
    }

    public F getInstance() {
        return this.getDateTimeInstance(3, 3, TimeZone.getDefault(), Locale.getDefault());
    }

    public F getInstance(String string, TimeZone timeZone, Locale locale) {
        Format format;
        ArrayKey arrayKey;
        Format format2;
        Validate.notNull(string, "pattern", new Object[0]);
        if (timeZone == null) {
            timeZone = TimeZone.getDefault();
        }
        if ((format2 = (Format)this.cInstanceCache.get(arrayKey = new ArrayKey(string, timeZone, locale = LocaleUtils.toLocale(locale)))) == null && (format = this.cInstanceCache.putIfAbsent(arrayKey, format2 = this.createInstance(string, timeZone, locale))) != null) {
            format2 = format;
        }
        return (F)format2;
    }

    protected abstract F createInstance(String var1, TimeZone var2, Locale var3);

    private F getDateTimeInstance(Integer n2, Integer n3, TimeZone timeZone, Locale locale) {
        locale = LocaleUtils.toLocale(locale);
        String string = FormatCache.getPatternForStyle(n2, n3, locale);
        return this.getInstance(string, timeZone, locale);
    }

    F getDateTimeInstance(int n2, int n3, TimeZone timeZone, Locale locale) {
        return this.getDateTimeInstance((Integer)n2, (Integer)n3, timeZone, locale);
    }

    F getDateInstance(int n2, TimeZone timeZone, Locale locale) {
        return this.getDateTimeInstance((Integer)n2, null, timeZone, locale);
    }

    F getTimeInstance(int n2, TimeZone timeZone, Locale locale) {
        return this.getDateTimeInstance(null, (Integer)n2, timeZone, locale);
    }

    static String getPatternForStyle(Integer n2, Integer n3, Locale locale) {
        Locale locale2 = LocaleUtils.toLocale(locale);
        ArrayKey arrayKey = new ArrayKey(n2, n3, locale2);
        String string = (String)cDateTimeInstanceCache.get(arrayKey);
        if (string == null) {
            try {
                DateFormat dateFormat = n2 == null ? DateFormat.getTimeInstance(n3, locale2) : (n3 == null ? DateFormat.getDateInstance(n2, locale2) : DateFormat.getDateTimeInstance(n2, n3, locale2));
                string = ((SimpleDateFormat)dateFormat).toPattern();
                String string2 = cDateTimeInstanceCache.putIfAbsent(arrayKey, string);
                if (string2 != null) {
                    string = string2;
                }
            }
            catch (ClassCastException classCastException) {
                throw new IllegalArgumentException("No date time pattern for locale: " + locale2);
            }
        }
        return string;
    }

    static final class ArrayKey {
        private final Object[] keys;
        private final int hashCode;

        private static int computeHashCode(Object[] objectArray) {
            int n2 = 31;
            int n3 = 1;
            n3 = 31 * n3 + Arrays.hashCode(objectArray);
            return n3;
        }

        ArrayKey(Object ... objectArray) {
            this.keys = objectArray;
            this.hashCode = ArrayKey.computeHashCode(objectArray);
        }

        public int hashCode() {
            return this.hashCode;
        }

        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (object == null) {
                return false;
            }
            if (this.getClass() != object.getClass()) {
                return false;
            }
            ArrayKey arrayKey = (ArrayKey)object;
            return Arrays.deepEquals(this.keys, arrayKey.keys);
        }
    }
}

