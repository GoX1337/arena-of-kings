/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3.text.translate;

import java.io.Writer;
import org.apache.commons.lang3.text.translate.CodePointTranslator;

@Deprecated
public class NumericEntityEscaper
extends CodePointTranslator {
    private final int below;
    private final int above;
    private final boolean between;

    private NumericEntityEscaper(int n2, int n3, boolean bl2) {
        this.below = n2;
        this.above = n3;
        this.between = bl2;
    }

    public NumericEntityEscaper() {
        this(0, Integer.MAX_VALUE, true);
    }

    public static NumericEntityEscaper below(int n2) {
        return NumericEntityEscaper.outsideOf(n2, Integer.MAX_VALUE);
    }

    public static NumericEntityEscaper above(int n2) {
        return NumericEntityEscaper.outsideOf(0, n2);
    }

    public static NumericEntityEscaper between(int n2, int n3) {
        return new NumericEntityEscaper(n2, n3, true);
    }

    public static NumericEntityEscaper outsideOf(int n2, int n3) {
        return new NumericEntityEscaper(n2, n3, false);
    }

    @Override
    public boolean translate(int n2, Writer writer) {
        if (this.between ? n2 < this.below || n2 > this.above : n2 >= this.below && n2 <= this.above) {
            return false;
        }
        writer.write("&#");
        writer.write(Integer.toString(n2, 10));
        writer.write(59);
        return true;
    }
}

