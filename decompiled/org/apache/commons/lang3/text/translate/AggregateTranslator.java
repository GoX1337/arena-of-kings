/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3.text.translate;

import java.io.Writer;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.text.translate.CharSequenceTranslator;

@Deprecated
public class AggregateTranslator
extends CharSequenceTranslator {
    private final CharSequenceTranslator[] translators;

    public AggregateTranslator(CharSequenceTranslator ... charSequenceTranslatorArray) {
        this.translators = ArrayUtils.clone(charSequenceTranslatorArray);
    }

    @Override
    public int translate(CharSequence charSequence, int n2, Writer writer) {
        for (CharSequenceTranslator charSequenceTranslator : this.translators) {
            int n3 = charSequenceTranslator.translate(charSequence, n2, writer);
            if (n3 == 0) continue;
            return n3;
        }
        return 0;
    }
}

