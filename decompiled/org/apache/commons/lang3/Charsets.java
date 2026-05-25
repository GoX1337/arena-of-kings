/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3;

import java.nio.charset.Charset;

class Charsets {
    Charsets() {
    }

    static Charset toCharset(Charset charset) {
        return charset == null ? Charset.defaultCharset() : charset;
    }

    static Charset toCharset(String string) {
        return string == null ? Charset.defaultCharset() : Charset.forName(string);
    }

    static String toCharsetName(String string) {
        return string == null ? Charset.defaultCharset().name() : string;
    }
}

