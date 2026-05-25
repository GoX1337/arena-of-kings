/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3.text.translate;

import java.io.Writer;
import org.apache.commons.lang3.text.translate.CodePointTranslator;

@Deprecated
public class UnicodeEscaper
extends CodePointTranslator {
    private final int below;
    private final int above;
    private final boolean between;

    public UnicodeEscaper() {
        this(0, Integer.MAX_VALUE, true);
    }

    protected UnicodeEscaper(int n2, int n3, boolean bl2) {
        this.below = n2;
        this.above = n3;
        this.between = bl2;
    }

    public static UnicodeEscaper below(int n2) {
        return UnicodeEscaper.outsideOf(n2, Integer.MAX_VALUE);
    }

    public static UnicodeEscaper above(int n2) {
        return UnicodeEscaper.outsideOf(0, n2);
    }

    public static UnicodeEscaper outsideOf(int n2, int n3) {
        return new UnicodeEscaper(n2, n3, false);
    }

    public static UnicodeEscaper between(int n2, int n3) {
        return new UnicodeEscaper(n2, n3, true);
    }

    @Override
    public boolean translate(int n2, Writer writer) {
        if (this.between ? n2 < this.below || n2 > this.above : n2 >= this.below && n2 <= this.above) {
            return false;
        }
        if (n2 > 65535) {
            writer.write(this.toUtf16Escape(n2));
        } else {
            writer.write("\\u");
            writer.write(HEX_DIGITS[n2 >> 12 & 0xF]);
            writer.write(HEX_DIGITS[n2 >> 8 & 0xF]);
            writer.write(HEX_DIGITS[n2 >> 4 & 0xF]);
            writer.write(HEX_DIGITS[n2 & 0xF]);
        }
        return true;
    }

    protected String toUtf16Escape(int n2) {
        return "\\u" + UnicodeEscaper.hex(n2);
    }
}

