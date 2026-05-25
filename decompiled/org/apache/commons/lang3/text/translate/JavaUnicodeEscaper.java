/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3.text.translate;

import org.apache.commons.lang3.text.translate.UnicodeEscaper;

@Deprecated
public class JavaUnicodeEscaper
extends UnicodeEscaper {
    public static JavaUnicodeEscaper above(int n2) {
        return JavaUnicodeEscaper.outsideOf(0, n2);
    }

    public static JavaUnicodeEscaper below(int n2) {
        return JavaUnicodeEscaper.outsideOf(n2, Integer.MAX_VALUE);
    }

    public static JavaUnicodeEscaper between(int n2, int n3) {
        return new JavaUnicodeEscaper(n2, n3, true);
    }

    public static JavaUnicodeEscaper outsideOf(int n2, int n3) {
        return new JavaUnicodeEscaper(n2, n3, false);
    }

    public JavaUnicodeEscaper(int n2, int n3, boolean bl2) {
        super(n2, n3, bl2);
    }

    @Override
    protected String toUtf16Escape(int n2) {
        char[] cArray = Character.toChars(n2);
        return "\\u" + JavaUnicodeEscaper.hex(cArray[0]) + "\\u" + JavaUnicodeEscaper.hex(cArray[1]);
    }
}

