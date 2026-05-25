/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3.text.translate;

import java.io.Writer;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import org.apache.commons.lang3.text.translate.CharSequenceTranslator;

@Deprecated
public class NumericEntityUnescaper
extends CharSequenceTranslator {
    private final EnumSet<OPTION> options;

    public NumericEntityUnescaper(OPTION ... oPTIONArray) {
        this.options = oPTIONArray.length > 0 ? EnumSet.copyOf(Arrays.asList(oPTIONArray)) : EnumSet.copyOf(Collections.singletonList(OPTION.semiColonRequired));
    }

    public boolean isSet(OPTION oPTION) {
        return this.options != null && this.options.contains((Object)oPTION);
    }

    @Override
    public int translate(CharSequence charSequence, int n2, Writer writer) {
        int n3 = charSequence.length();
        if (charSequence.charAt(n2) == '&' && n2 < n3 - 2 && charSequence.charAt(n2 + 1) == '#') {
            int n4;
            boolean bl2;
            int n5;
            int n6 = n2 + 2;
            boolean bl3 = false;
            char c2 = charSequence.charAt(n6);
            if (c2 == 'x' || c2 == 'X') {
                bl3 = true;
                if (++n6 == n3) {
                    return 0;
                }
            }
            for (n5 = n6; n5 < n3 && (charSequence.charAt(n5) >= '0' && charSequence.charAt(n5) <= '9' || charSequence.charAt(n5) >= 'a' && charSequence.charAt(n5) <= 'f' || charSequence.charAt(n5) >= 'A' && charSequence.charAt(n5) <= 'F'); ++n5) {
            }
            boolean bl4 = bl2 = n5 != n3 && charSequence.charAt(n5) == ';';
            if (!bl2) {
                if (this.isSet(OPTION.semiColonRequired)) {
                    return 0;
                }
                if (this.isSet(OPTION.errorIfNoSemiColon)) {
                    throw new IllegalArgumentException("Semi-colon required at end of numeric entity");
                }
            }
            try {
                n4 = bl3 ? Integer.parseInt(charSequence.subSequence(n6, n5).toString(), 16) : Integer.parseInt(charSequence.subSequence(n6, n5).toString(), 10);
            }
            catch (NumberFormatException numberFormatException) {
                return 0;
            }
            if (n4 > 65535) {
                char[] cArray = Character.toChars(n4);
                writer.write(cArray[0]);
                writer.write(cArray[1]);
            } else {
                writer.write(n4);
            }
            return 2 + n5 - n6 + (bl3 ? 1 : 0) + (bl2 ? 1 : 0);
        }
        return 0;
    }

    public static enum OPTION {
        semiColonRequired,
        semiColonOptional,
        errorIfNoSemiColon;

    }
}

