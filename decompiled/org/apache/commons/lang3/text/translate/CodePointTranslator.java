/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3.text.translate;

import java.io.Writer;
import org.apache.commons.lang3.text.translate.CharSequenceTranslator;

@Deprecated
public abstract class CodePointTranslator
extends CharSequenceTranslator {
    @Override
    public final int translate(CharSequence charSequence, int n2, Writer writer) {
        int n3 = Character.codePointAt(charSequence, n2);
        boolean bl2 = this.translate(n3, writer);
        return bl2 ? 1 : 0;
    }

    public abstract boolean translate(int var1, Writer var2);
}

