/*
 * Decompiled with CFR 0.152.
 */
package com.sun.jna;

public final class WString
implements CharSequence,
Comparable {
    private String string;

    public WString(String string) {
        if (string == null) {
            throw new NullPointerException("String initializer must be non-null");
        }
        this.string = string;
    }

    @Override
    public String toString() {
        return this.string;
    }

    public boolean equals(Object object) {
        return object instanceof WString && this.toString().equals(object.toString());
    }

    public int hashCode() {
        return this.toString().hashCode();
    }

    public int compareTo(Object object) {
        return this.toString().compareTo(object.toString());
    }

    @Override
    public int length() {
        return this.toString().length();
    }

    @Override
    public char charAt(int n2) {
        return this.toString().charAt(n2);
    }

    @Override
    public CharSequence subSequence(int n2, int n3) {
        return this.toString().subSequence(n2, n3);
    }
}

