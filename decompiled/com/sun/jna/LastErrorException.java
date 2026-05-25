/*
 * Decompiled with CFR 0.152.
 */
package com.sun.jna;

import com.sun.jna.Platform;

public class LastErrorException
extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private int errorCode;

    private static String formatMessage(int n2) {
        return Platform.isWindows() ? "GetLastError() returned " + n2 : "errno was " + n2;
    }

    private static String parseMessage(String string) {
        try {
            return LastErrorException.formatMessage(Integer.parseInt(string));
        }
        catch (NumberFormatException numberFormatException) {
            return string;
        }
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public LastErrorException(String string) {
        super(LastErrorException.parseMessage(string.trim()));
        try {
            if (string.startsWith("[")) {
                string = string.substring(1, string.indexOf("]"));
            }
            this.errorCode = Integer.parseInt(string);
        }
        catch (NumberFormatException numberFormatException) {
            this.errorCode = -1;
        }
    }

    public LastErrorException(int n2) {
        this(n2, LastErrorException.formatMessage(n2));
    }

    public LastErrorException(int n2, String string) {
        super(string);
        this.errorCode = n2;
    }
}

