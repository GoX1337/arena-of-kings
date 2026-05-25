/*
 * Decompiled with CFR 0.152.
 */
package com.google.api.translate;

import com.google.api.translate.Language;
import com.google.api.translate.TranslateV2;

public interface Translate {
    public static final Translate DEFAULT = new TranslateV2();

    public String execute(String var1, Language var2, Language var3);

    public String[] execute(String[] var1, Language var2, Language var3);

    public String[] execute(String var1, Language var2, Language[] var3);

    public String[] execute(String[] var1, Language[] var2, Language[] var3);
}

