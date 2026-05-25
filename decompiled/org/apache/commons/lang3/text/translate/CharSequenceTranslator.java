/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3.text.translate;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Locale;
import org.apache.commons.lang3.text.translate.AggregateTranslator;

@Deprecated
public abstract class CharSequenceTranslator {
    static final char[] HEX_DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public abstract int translate(CharSequence var1, int var2, Writer var3);

    public final String translate(CharSequence charSequence) {
        if (charSequence == null) {
            return null;
        }
        try {
            StringWriter stringWriter = new StringWriter(charSequence.length() * 2);
            this.translate(charSequence, stringWriter);
            return stringWriter.toString();
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
    }

    public final void translate(CharSequence charSequence, Writer writer) {
        if (writer == null) {
            throw new IllegalArgumentException("The Writer must not be null");
        }
        if (charSequence == null) {
            return;
        }
        int n2 = 0;
        int n3 = charSequence.length();
        while (n2 < n3) {
            int n4;
            int n5 = this.translate(charSequence, n2, writer);
            if (n5 == 0) {
                char c2;
                n4 = charSequence.charAt(n2);
                writer.write(n4);
                if (!Character.isHighSurrogate((char)n4) || ++n2 >= n3 || !Character.isLowSurrogate(c2 = charSequence.charAt(n2))) continue;
                writer.write(c2);
                ++n2;
                continue;
            }
            for (n4 = 0; n4 < n5; ++n4) {
                n2 += Character.charCount(Character.codePointAt(charSequence, n2));
            }
        }
    }

    public final CharSequenceTranslator with(CharSequenceTranslator ... charSequenceTranslatorArray) {
        CharSequenceTranslator[] charSequenceTranslatorArray2 = new CharSequenceTranslator[charSequenceTranslatorArray.length + 1];
        charSequenceTranslatorArray2[0] = this;
        System.arraycopy(charSequenceTranslatorArray, 0, charSequenceTranslatorArray2, 1, charSequenceTranslatorArray.length);
        return new AggregateTranslator(charSequenceTranslatorArray2);
    }

    public static String hex(int n2) {
        return Integer.toHexString(n2).toUpperCase(Locale.ENGLISH);
    }
}

