/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils;

import com.badlogic.gdx.utils.StringBuilder;
import java.text.MessageFormat;
import java.util.Locale;

class TextFormatter {
    private MessageFormat messageFormat;
    private StringBuilder buffer = new StringBuilder();

    public TextFormatter(Locale locale, boolean bl2) {
        if (bl2) {
            this.messageFormat = new MessageFormat("", locale);
        }
    }

    public String format(String string, Object ... objectArray) {
        if (this.messageFormat != null) {
            this.messageFormat.applyPattern(this.replaceEscapeChars(string));
            return this.messageFormat.format(objectArray);
        }
        return this.simpleFormat(string, objectArray);
    }

    private String replaceEscapeChars(String string) {
        this.buffer.setLength(0);
        boolean bl2 = false;
        int n2 = string.length();
        for (int i2 = 0; i2 < n2; ++i2) {
            char c2 = string.charAt(i2);
            if (c2 == '\'') {
                bl2 = true;
                this.buffer.append("''");
                continue;
            }
            if (c2 == '{') {
                int n3;
                for (n3 = i2 + 1; n3 < n2 && string.charAt(n3) == '{'; ++n3) {
                }
                int n4 = (n3 - i2) / 2;
                if (n4 > 0) {
                    bl2 = true;
                    this.buffer.append('\'');
                    do {
                        this.buffer.append('{');
                    } while (--n4 > 0);
                    this.buffer.append('\'');
                }
                if ((n3 - i2) % 2 != 0) {
                    this.buffer.append('{');
                }
                i2 = n3 - 1;
                continue;
            }
            this.buffer.append(c2);
        }
        return bl2 ? this.buffer.toString() : string;
    }

    private String simpleFormat(String string, Object ... objectArray) {
        this.buffer.setLength(0);
        boolean bl2 = false;
        int n2 = -1;
        int n3 = string.length();
        for (int i2 = 0; i2 < n3; ++i2) {
            char c2 = string.charAt(i2);
            if (n2 < 0) {
                if (c2 == '{') {
                    bl2 = true;
                    if (i2 + 1 < n3 && string.charAt(i2 + 1) == '{') {
                        this.buffer.append(c2);
                        ++i2;
                        continue;
                    }
                    n2 = 0;
                    continue;
                }
                this.buffer.append(c2);
                continue;
            }
            if (c2 == '}') {
                if (n2 >= objectArray.length) {
                    throw new IllegalArgumentException("Argument index out of bounds: " + n2);
                }
                if (string.charAt(i2 - 1) == '{') {
                    throw new IllegalArgumentException("Missing argument index after a left curly brace");
                }
                if (objectArray[n2] == null) {
                    this.buffer.append("null");
                } else {
                    this.buffer.append(objectArray[n2].toString());
                }
                n2 = -1;
                continue;
            }
            if (c2 < '0' || c2 > '9') {
                throw new IllegalArgumentException("Unexpected '" + c2 + "' while parsing argument index");
            }
            n2 = n2 * 10 + (c2 - 48);
        }
        if (n2 >= 0) {
            throw new IllegalArgumentException("Unmatched braces in the pattern.");
        }
        return bl2 ? this.buffer.toString() : string;
    }
}

