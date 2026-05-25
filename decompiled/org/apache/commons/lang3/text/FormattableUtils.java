/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3.text;

import java.util.Formattable;
import java.util.Formatter;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.Validate;

@Deprecated
public class FormattableUtils {
    private static final String SIMPLEST_FORMAT = "%s";

    public static String toString(Formattable formattable) {
        return String.format(SIMPLEST_FORMAT, formattable);
    }

    public static Formatter append(CharSequence charSequence, Formatter formatter, int n2, int n3, int n4) {
        return FormattableUtils.append(charSequence, formatter, n2, n3, n4, ' ', null);
    }

    public static Formatter append(CharSequence charSequence, Formatter formatter, int n2, int n3, int n4, char c2) {
        return FormattableUtils.append(charSequence, formatter, n2, n3, n4, c2, null);
    }

    public static Formatter append(CharSequence charSequence, Formatter formatter, int n2, int n3, int n4, CharSequence charSequence2) {
        return FormattableUtils.append(charSequence, formatter, n2, n3, n4, ' ', charSequence2);
    }

    public static Formatter append(CharSequence charSequence, Formatter formatter, int n2, int n3, int n4, char c2, CharSequence charSequence2) {
        Validate.isTrue(charSequence2 == null || n4 < 0 || charSequence2.length() <= n4, "Specified ellipsis '%1$s' exceeds precision of %2$s", charSequence2, n4);
        StringBuilder stringBuilder = new StringBuilder(charSequence);
        if (n4 >= 0 && n4 < charSequence.length()) {
            CharSequence charSequence3 = ObjectUtils.defaultIfNull(charSequence2, "");
            stringBuilder.replace(n4 - charSequence3.length(), charSequence.length(), charSequence3.toString());
        }
        boolean bl2 = (n2 & 1) == 1;
        for (int i2 = stringBuilder.length(); i2 < n3; ++i2) {
            stringBuilder.insert(bl2 ? i2 : 0, c2);
        }
        formatter.format(stringBuilder.toString(), new Object[0]);
        return formatter;
    }
}

