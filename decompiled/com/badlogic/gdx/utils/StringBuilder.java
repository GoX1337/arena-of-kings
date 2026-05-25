/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils;

import com.badlogic.gdx.utils.Null;
import java.util.Arrays;

public class StringBuilder
implements Appendable,
CharSequence {
    static final int INITIAL_CAPACITY = 16;
    public char[] chars;
    public int length;
    private static final char[] digits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public static int numChars(int n2, int n3) {
        int n4;
        int n5 = n4 = n2 < 0 ? 2 : 1;
        while ((n2 /= n3) != 0) {
            ++n4;
        }
        return n4;
    }

    public static int numChars(long l2, int n2) {
        int n3;
        int n4 = n3 = l2 < 0L ? 2 : 1;
        while ((l2 /= (long)n2) != 0L) {
            ++n3;
        }
        return n3;
    }

    final char[] getValue() {
        return this.chars;
    }

    public StringBuilder() {
        this.chars = new char[16];
    }

    public StringBuilder(int n2) {
        if (n2 < 0) {
            throw new NegativeArraySizeException();
        }
        this.chars = new char[n2];
    }

    public StringBuilder(CharSequence charSequence) {
        this(charSequence.toString());
    }

    public StringBuilder(StringBuilder stringBuilder) {
        this.length = stringBuilder.length;
        this.chars = new char[this.length + 16];
        System.arraycopy(stringBuilder.chars, 0, this.chars, 0, this.length);
    }

    public StringBuilder(String string) {
        this.length = string.length();
        this.chars = new char[this.length + 16];
        string.getChars(0, this.length, this.chars, 0);
    }

    private void enlargeBuffer(int n2) {
        int n3 = (this.chars.length >> 1) + this.chars.length + 2;
        char[] cArray = new char[n2 > n3 ? n2 : n3];
        System.arraycopy(this.chars, 0, cArray, 0, this.length);
        this.chars = cArray;
    }

    final void appendNull() {
        int n2 = this.length + 4;
        if (n2 > this.chars.length) {
            this.enlargeBuffer(n2);
        }
        this.chars[this.length++] = 110;
        this.chars[this.length++] = 117;
        this.chars[this.length++] = 108;
        this.chars[this.length++] = 108;
    }

    final void append0(char[] cArray) {
        int n2 = this.length + cArray.length;
        if (n2 > this.chars.length) {
            this.enlargeBuffer(n2);
        }
        System.arraycopy(cArray, 0, this.chars, this.length, cArray.length);
        this.length = n2;
    }

    final void append0(char[] cArray, int n2, int n3) {
        if (n2 > cArray.length || n2 < 0) {
            throw new ArrayIndexOutOfBoundsException("Offset out of bounds: " + n2);
        }
        if (n3 < 0 || cArray.length - n2 < n3) {
            throw new ArrayIndexOutOfBoundsException("Length out of bounds: " + n3);
        }
        int n4 = this.length + n3;
        if (n4 > this.chars.length) {
            this.enlargeBuffer(n4);
        }
        System.arraycopy(cArray, n2, this.chars, this.length, n3);
        this.length = n4;
    }

    final void append0(char c2) {
        if (this.length == this.chars.length) {
            this.enlargeBuffer(this.length + 1);
        }
        this.chars[this.length++] = c2;
    }

    final void append0(String string) {
        if (string == null) {
            this.appendNull();
            return;
        }
        int n2 = string.length();
        int n3 = this.length + n2;
        if (n3 > this.chars.length) {
            this.enlargeBuffer(n3);
        }
        string.getChars(0, n2, this.chars, this.length);
        this.length = n3;
    }

    final void append0(CharSequence charSequence, int n2, int n3) {
        if (charSequence == null) {
            charSequence = "null";
        }
        if (n2 < 0 || n3 < 0 || n2 > n3 || n3 > charSequence.length()) {
            throw new IndexOutOfBoundsException();
        }
        this.append0(charSequence.subSequence(n2, n3).toString());
    }

    public int capacity() {
        return this.chars.length;
    }

    @Override
    public char charAt(int n2) {
        if (n2 < 0 || n2 >= this.length) {
            throw new StringIndexOutOfBoundsException(n2);
        }
        return this.chars[n2];
    }

    final void delete0(int n2, int n3) {
        if (n2 >= 0) {
            if (n3 > this.length) {
                n3 = this.length;
            }
            if (n3 == n2) {
                return;
            }
            if (n3 > n2) {
                int n4 = this.length - n3;
                if (n4 >= 0) {
                    System.arraycopy(this.chars, n3, this.chars, n2, n4);
                }
                this.length -= n3 - n2;
                return;
            }
        }
        throw new StringIndexOutOfBoundsException();
    }

    final void deleteCharAt0(int n2) {
        if (0 > n2 || n2 >= this.length) {
            throw new StringIndexOutOfBoundsException(n2);
        }
        int n3 = this.length - n2 - 1;
        if (n3 > 0) {
            System.arraycopy(this.chars, n2 + 1, this.chars, n2, n3);
        }
        --this.length;
    }

    public void ensureCapacity(int n2) {
        if (n2 > this.chars.length) {
            int n3 = (this.chars.length << 1) + 2;
            this.enlargeBuffer(n3 > n2 ? n3 : n2);
        }
    }

    public void getChars(int n2, int n3, char[] cArray, int n4) {
        if (n2 > this.length || n3 > this.length || n2 > n3) {
            throw new StringIndexOutOfBoundsException();
        }
        System.arraycopy(this.chars, n2, cArray, n4, n3 - n2);
    }

    final void insert0(int n2, char[] cArray) {
        if (0 > n2 || n2 > this.length) {
            throw new StringIndexOutOfBoundsException(n2);
        }
        if (cArray.length != 0) {
            this.move(cArray.length, n2);
            System.arraycopy(cArray, 0, cArray, n2, cArray.length);
            this.length += cArray.length;
        }
    }

    final void insert0(int n2, char[] cArray, int n3, int n4) {
        if (0 <= n2 && n2 <= n4) {
            if (n3 >= 0 && 0 <= n4 && n4 <= cArray.length - n3) {
                if (n4 != 0) {
                    this.move(n4, n2);
                    System.arraycopy(cArray, n3, this.chars, n2, n4);
                    this.length += n4;
                }
                return;
            }
            throw new StringIndexOutOfBoundsException("offset " + n3 + ", length " + n4 + ", char[].length " + cArray.length);
        }
        throw new StringIndexOutOfBoundsException(n2);
    }

    final void insert0(int n2, char c2) {
        if (0 > n2 || n2 > this.length) {
            throw new ArrayIndexOutOfBoundsException(n2);
        }
        this.move(1, n2);
        this.chars[n2] = c2;
        ++this.length;
    }

    final void insert0(int n2, String string) {
        if (0 <= n2 && n2 <= this.length) {
            int n3;
            if (string == null) {
                string = "null";
            }
            if ((n3 = string.length()) != 0) {
                this.move(n3, n2);
                string.getChars(0, n3, this.chars, n2);
                this.length += n3;
            }
        } else {
            throw new StringIndexOutOfBoundsException(n2);
        }
    }

    final void insert0(int n2, CharSequence charSequence, int n3, int n4) {
        if (charSequence == null) {
            charSequence = "null";
        }
        if (n2 < 0 || n2 > this.length || n3 < 0 || n4 < 0 || n3 > n4 || n4 > charSequence.length()) {
            throw new IndexOutOfBoundsException();
        }
        this.insert0(n2, charSequence.subSequence(n3, n4).toString());
    }

    @Override
    public int length() {
        return this.length;
    }

    private void move(int n2, int n3) {
        if (this.chars.length - this.length >= n2) {
            System.arraycopy(this.chars, n3, this.chars, n3 + n2, this.length - n3);
            return;
        }
        int n4 = this.length + n2;
        int n5 = (this.chars.length << 1) + 2;
        int n6 = n4 > n5 ? n4 : n5;
        char[] cArray = new char[n6];
        System.arraycopy(this.chars, 0, cArray, 0, n3);
        System.arraycopy(this.chars, n3, cArray, n3 + n2, this.length - n3);
        this.chars = cArray;
    }

    final void replace0(int n2, int n3, String string) {
        if (n2 >= 0) {
            if (n3 > this.length) {
                n3 = this.length;
            }
            if (n3 > n2) {
                int n4 = string.length();
                int n5 = n3 - n2 - n4;
                if (n5 > 0) {
                    System.arraycopy(this.chars, n3, this.chars, n2 + n4, this.length - n3);
                } else if (n5 < 0) {
                    this.move(-n5, n3);
                }
                string.getChars(0, n4, this.chars, n2);
                this.length -= n5;
                return;
            }
            if (n2 == n3) {
                if (string == null) {
                    throw new NullPointerException();
                }
                this.insert0(n2, string);
                return;
            }
        }
        throw new StringIndexOutOfBoundsException();
    }

    final void reverse0() {
        if (this.length < 2) {
            return;
        }
        int n2 = this.length - 1;
        char c2 = this.chars[0];
        char c3 = this.chars[n2];
        boolean bl2 = true;
        boolean bl3 = true;
        int n3 = 0;
        int n4 = this.length / 2;
        while (n3 < n4) {
            boolean bl4;
            char c4 = this.chars[n3 + 1];
            char c5 = this.chars[n2 - 1];
            boolean bl5 = bl4 = bl2 && c4 >= '\udc00' && c4 <= '\udfff' && c2 >= '\ud800' && c2 <= '\udbff';
            if (bl4 && this.length < 3) {
                return;
            }
            boolean bl6 = bl3 && c5 >= '\ud800' && c5 <= '\udbff' && c3 >= '\udc00' && c3 <= '\udfff';
            bl3 = true;
            bl2 = true;
            if (bl4 == bl6) {
                if (bl4) {
                    this.chars[n2] = c4;
                    this.chars[n2 - 1] = c2;
                    this.chars[n3] = c5;
                    this.chars[n3 + 1] = c3;
                    c2 = this.chars[n3 + 2];
                    c3 = this.chars[n2 - 2];
                    ++n3;
                    --n2;
                } else {
                    this.chars[n2] = c2;
                    this.chars[n3] = c3;
                    c2 = c4;
                    c3 = c5;
                }
            } else if (bl4) {
                this.chars[n2] = c4;
                this.chars[n3] = c3;
                c3 = c5;
                bl2 = false;
            } else {
                this.chars[n2] = c2;
                this.chars[n3] = c5;
                c2 = c4;
                bl3 = false;
            }
            ++n3;
            --n2;
        }
        if (!((this.length & 1) != 1 || bl2 && bl3)) {
            this.chars[n2] = bl2 ? c3 : c2;
        }
    }

    public void setCharAt(int n2, char c2) {
        if (0 > n2 || n2 >= this.length) {
            throw new StringIndexOutOfBoundsException(n2);
        }
        this.chars[n2] = c2;
    }

    public void setLength(int n2) {
        if (n2 < 0) {
            throw new StringIndexOutOfBoundsException(n2);
        }
        if (n2 > this.chars.length) {
            this.enlargeBuffer(n2);
        } else if (this.length < n2) {
            Arrays.fill(this.chars, this.length, n2, '\u0000');
        }
        this.length = n2;
    }

    public String substring(int n2) {
        if (0 <= n2 && n2 <= this.length) {
            if (n2 == this.length) {
                return "";
            }
            return new String(this.chars, n2, this.length - n2);
        }
        throw new StringIndexOutOfBoundsException(n2);
    }

    public String substring(int n2, int n3) {
        if (0 <= n2 && n2 <= n3 && n3 <= this.length) {
            if (n2 == n3) {
                return "";
            }
            return new String(this.chars, n2, n3 - n2);
        }
        throw new StringIndexOutOfBoundsException();
    }

    @Override
    public String toString() {
        if (this.length == 0) {
            return "";
        }
        return new String(this.chars, 0, this.length);
    }

    public String toStringAndClear() {
        String string = this.toString();
        this.clear();
        return string;
    }

    @Override
    public CharSequence subSequence(int n2, int n3) {
        return this.substring(n2, n3);
    }

    public int indexOf(String string) {
        return this.indexOf(string, 0);
    }

    public int indexOf(String string, int n2) {
        int n3;
        if (n2 < 0) {
            n2 = 0;
        }
        if ((n3 = string.length()) == 0) {
            return n2 < this.length || n2 == 0 ? n2 : this.length;
        }
        int n4 = this.length - n3;
        if (n2 > n4) {
            return -1;
        }
        char c2 = string.charAt(0);
        while (true) {
            int n5;
            boolean bl2 = false;
            for (n5 = n2; n5 <= n4; ++n5) {
                if (this.chars[n5] != c2) continue;
                bl2 = true;
                break;
            }
            if (!bl2) {
                return -1;
            }
            int n6 = n5;
            int n7 = 0;
            while (++n7 < n3 && this.chars[++n6] == string.charAt(n7)) {
            }
            if (n7 == n3) {
                return n5;
            }
            n2 = n5 + 1;
        }
    }

    public int indexOfIgnoreCase(String string, int n2) {
        int n3;
        if (n2 < 0) {
            n2 = 0;
        }
        if ((n3 = string.length()) == 0) {
            return n2 < this.length || n2 == 0 ? n2 : this.length;
        }
        int n4 = this.length - n3;
        if (n2 > n4) {
            return -1;
        }
        char c2 = Character.toUpperCase(string.charAt(0));
        char c3 = Character.toLowerCase(c2);
        while (true) {
            char c4;
            char c5;
            int n5;
            int n6;
            boolean bl2 = false;
            for (n6 = n2; n6 <= n4; ++n6) {
                n5 = this.chars[n6];
                if (n5 != c2 && n5 != c3) continue;
                bl2 = true;
                break;
            }
            if (!bl2) {
                return -1;
            }
            n5 = n6;
            int n7 = 0;
            while (++n7 < n3 && ((c5 = this.chars[++n5]) == (c4 = Character.toUpperCase(string.charAt(n7))) || c5 == Character.toLowerCase(c4))) {
            }
            if (n7 == n3) {
                return n6;
            }
            n2 = n6 + 1;
        }
    }

    public boolean contains(String string) {
        return this.indexOf(string, 0) != -1;
    }

    public boolean containsIgnoreCase(String string) {
        return this.indexOfIgnoreCase(string, 0) != -1;
    }

    public int lastIndexOf(String string) {
        return this.lastIndexOf(string, this.length);
    }

    public int lastIndexOf(String string, int n2) {
        int n3 = string.length();
        if (n3 <= this.length && n2 >= 0) {
            if (n3 > 0) {
                if (n2 > this.length - n3) {
                    n2 = this.length - n3;
                }
                char c2 = string.charAt(0);
                while (true) {
                    int n4;
                    boolean bl2 = false;
                    for (n4 = n2; n4 >= 0; --n4) {
                        if (this.chars[n4] != c2) continue;
                        bl2 = true;
                        break;
                    }
                    if (!bl2) {
                        return -1;
                    }
                    int n5 = n4;
                    int n6 = 0;
                    while (++n6 < n3 && this.chars[++n5] == string.charAt(n6)) {
                    }
                    if (n6 == n3) {
                        return n4;
                    }
                    n2 = n4 - 1;
                }
            }
            return n2 < this.length ? n2 : this.length;
        }
        return -1;
    }

    public void trimToSize() {
        if (this.length < this.chars.length) {
            char[] cArray = new char[this.length];
            System.arraycopy(this.chars, 0, cArray, 0, this.length);
            this.chars = cArray;
        }
    }

    public int codePointAt(int n2) {
        if (n2 < 0 || n2 >= this.length) {
            throw new StringIndexOutOfBoundsException(n2);
        }
        return Character.codePointAt(this.chars, n2, this.length);
    }

    public int codePointBefore(int n2) {
        if (n2 < 1 || n2 > this.length) {
            throw new StringIndexOutOfBoundsException(n2);
        }
        return Character.codePointBefore(this.chars, n2);
    }

    public int codePointCount(int n2, int n3) {
        if (n2 < 0 || n3 > this.length || n2 > n3) {
            throw new StringIndexOutOfBoundsException();
        }
        return Character.codePointCount(this.chars, n2, n3 - n2);
    }

    public int offsetByCodePoints(int n2, int n3) {
        return Character.offsetByCodePoints(this.chars, 0, this.length, n2, n3);
    }

    public StringBuilder append(boolean bl2) {
        this.append0(bl2 ? "true" : "false");
        return this;
    }

    @Override
    public StringBuilder append(char c2) {
        this.append0(c2);
        return this;
    }

    public StringBuilder append(int n2) {
        return this.append(n2, 0);
    }

    public StringBuilder append(int n2, int n3) {
        return this.append(n2, n3, '0');
    }

    public StringBuilder append(int n2, int n3, char c2) {
        if (n2 == Integer.MIN_VALUE) {
            this.append0("-2147483648");
            return this;
        }
        if (n2 < 0) {
            this.append0('-');
            n2 = -n2;
        }
        if (n3 > 1) {
            for (int i2 = n3 - StringBuilder.numChars(n2, 10); i2 > 0; --i2) {
                this.append(c2);
            }
        }
        if (n2 >= 10000) {
            if (n2 >= 1000000000) {
                this.append0(digits[(int)((long)n2 % 10000000000L / 1000000000L)]);
            }
            if (n2 >= 100000000) {
                this.append0(digits[n2 % 1000000000 / 100000000]);
            }
            if (n2 >= 10000000) {
                this.append0(digits[n2 % 100000000 / 10000000]);
            }
            if (n2 >= 1000000) {
                this.append0(digits[n2 % 10000000 / 1000000]);
            }
            if (n2 >= 100000) {
                this.append0(digits[n2 % 1000000 / 100000]);
            }
            this.append0(digits[n2 % 100000 / 10000]);
        }
        if (n2 >= 1000) {
            this.append0(digits[n2 % 10000 / 1000]);
        }
        if (n2 >= 100) {
            this.append0(digits[n2 % 1000 / 100]);
        }
        if (n2 >= 10) {
            this.append0(digits[n2 % 100 / 10]);
        }
        this.append0(digits[n2 % 10]);
        return this;
    }

    public StringBuilder append(long l2) {
        return this.append(l2, 0);
    }

    public StringBuilder append(long l2, int n2) {
        return this.append(l2, n2, '0');
    }

    public StringBuilder append(long l2, int n2, char c2) {
        if (l2 == Long.MIN_VALUE) {
            this.append0("-9223372036854775808");
            return this;
        }
        if (l2 < 0L) {
            this.append0('-');
            l2 = -l2;
        }
        if (n2 > 1) {
            for (int i2 = n2 - StringBuilder.numChars(l2, 10); i2 > 0; --i2) {
                this.append(c2);
            }
        }
        if (l2 >= 10000L) {
            if (l2 >= 1000000000000000000L) {
                this.append0(digits[(int)((double)l2 % 1.0E19 / 1.0E18)]);
            }
            if (l2 >= 100000000000000000L) {
                this.append0(digits[(int)(l2 % 1000000000000000000L / 100000000000000000L)]);
            }
            if (l2 >= 10000000000000000L) {
                this.append0(digits[(int)(l2 % 100000000000000000L / 10000000000000000L)]);
            }
            if (l2 >= 1000000000000000L) {
                this.append0(digits[(int)(l2 % 10000000000000000L / 1000000000000000L)]);
            }
            if (l2 >= 100000000000000L) {
                this.append0(digits[(int)(l2 % 1000000000000000L / 100000000000000L)]);
            }
            if (l2 >= 10000000000000L) {
                this.append0(digits[(int)(l2 % 100000000000000L / 10000000000000L)]);
            }
            if (l2 >= 1000000000000L) {
                this.append0(digits[(int)(l2 % 10000000000000L / 1000000000000L)]);
            }
            if (l2 >= 100000000000L) {
                this.append0(digits[(int)(l2 % 1000000000000L / 100000000000L)]);
            }
            if (l2 >= 10000000000L) {
                this.append0(digits[(int)(l2 % 100000000000L / 10000000000L)]);
            }
            if (l2 >= 1000000000L) {
                this.append0(digits[(int)(l2 % 10000000000L / 1000000000L)]);
            }
            if (l2 >= 100000000L) {
                this.append0(digits[(int)(l2 % 1000000000L / 100000000L)]);
            }
            if (l2 >= 10000000L) {
                this.append0(digits[(int)(l2 % 100000000L / 10000000L)]);
            }
            if (l2 >= 1000000L) {
                this.append0(digits[(int)(l2 % 10000000L / 1000000L)]);
            }
            if (l2 >= 100000L) {
                this.append0(digits[(int)(l2 % 1000000L / 100000L)]);
            }
            this.append0(digits[(int)(l2 % 100000L / 10000L)]);
        }
        if (l2 >= 1000L) {
            this.append0(digits[(int)(l2 % 10000L / 1000L)]);
        }
        if (l2 >= 100L) {
            this.append0(digits[(int)(l2 % 1000L / 100L)]);
        }
        if (l2 >= 10L) {
            this.append0(digits[(int)(l2 % 100L / 10L)]);
        }
        this.append0(digits[(int)(l2 % 10L)]);
        return this;
    }

    public StringBuilder append(float f2) {
        this.append0(Float.toString(f2));
        return this;
    }

    public StringBuilder append(double d2) {
        this.append0(Double.toString(d2));
        return this;
    }

    public StringBuilder append(Object object) {
        if (object == null) {
            this.appendNull();
        } else {
            this.append0(object.toString());
        }
        return this;
    }

    public StringBuilder append(String string) {
        this.append0(string);
        return this;
    }

    public StringBuilder append(String string, String string2) {
        if (this.length > 0) {
            this.append0(string2);
        }
        this.append0(string);
        return this;
    }

    public StringBuilder appendLine(String string) {
        this.append0(string);
        this.append0('\n');
        return this;
    }

    public StringBuilder append(char[] cArray) {
        this.append0(cArray);
        return this;
    }

    public StringBuilder append(char[] cArray, int n2, int n3) {
        this.append0(cArray, n2, n3);
        return this;
    }

    @Override
    public StringBuilder append(CharSequence charSequence) {
        if (charSequence == null) {
            this.appendNull();
        } else if (charSequence instanceof StringBuilder) {
            StringBuilder stringBuilder = (StringBuilder)charSequence;
            this.append0(stringBuilder.chars, 0, stringBuilder.length);
        } else {
            this.append0(charSequence.toString());
        }
        return this;
    }

    public StringBuilder append(StringBuilder stringBuilder) {
        if (stringBuilder == null) {
            this.appendNull();
        } else {
            this.append0(stringBuilder.chars, 0, stringBuilder.length);
        }
        return this;
    }

    @Override
    public StringBuilder append(CharSequence charSequence, int n2, int n3) {
        this.append0(charSequence, n2, n3);
        return this;
    }

    public StringBuilder append(StringBuilder stringBuilder, int n2, int n3) {
        if (stringBuilder == null) {
            this.appendNull();
        } else {
            this.append0(stringBuilder.chars, n2, n3);
        }
        return this;
    }

    public StringBuilder appendCodePoint(int n2) {
        this.append0(Character.toChars(n2));
        return this;
    }

    public StringBuilder delete(int n2, int n3) {
        this.delete0(n2, n3);
        return this;
    }

    public StringBuilder deleteCharAt(int n2) {
        this.deleteCharAt0(n2);
        return this;
    }

    public void clear() {
        this.length = 0;
    }

    public StringBuilder insert(int n2, boolean bl2) {
        this.insert0(n2, bl2 ? "true" : "false");
        return this;
    }

    public StringBuilder insert(int n2, char c2) {
        this.insert0(n2, c2);
        return this;
    }

    public StringBuilder insert(int n2, int n3) {
        this.insert0(n2, Integer.toString(n3));
        return this;
    }

    public StringBuilder insert(int n2, long l2) {
        this.insert0(n2, Long.toString(l2));
        return this;
    }

    public StringBuilder insert(int n2, float f2) {
        this.insert0(n2, Float.toString(f2));
        return this;
    }

    public StringBuilder insert(int n2, double d2) {
        this.insert0(n2, Double.toString(d2));
        return this;
    }

    public StringBuilder insert(int n2, Object object) {
        this.insert0(n2, object == null ? "null" : object.toString());
        return this;
    }

    public StringBuilder insert(int n2, String string) {
        this.insert0(n2, string);
        return this;
    }

    public StringBuilder insert(int n2, char[] cArray) {
        this.insert0(n2, cArray);
        return this;
    }

    public StringBuilder insert(int n2, char[] cArray, int n3, int n4) {
        this.insert0(n2, cArray, n3, n4);
        return this;
    }

    public StringBuilder insert(int n2, CharSequence charSequence) {
        this.insert0(n2, charSequence == null ? "null" : charSequence.toString());
        return this;
    }

    public StringBuilder insert(int n2, CharSequence charSequence, int n3, int n4) {
        this.insert0(n2, charSequence, n3, n4);
        return this;
    }

    public StringBuilder replace(int n2, int n3, String string) {
        this.replace0(n2, n3, string);
        return this;
    }

    public StringBuilder replace(String string, String string2) {
        int n2 = string.length();
        int n3 = string2.length();
        int n4 = 0;
        while ((n4 = this.indexOf(string, n4)) != -1) {
            this.replace0(n4, n4 + n2, string2);
            n4 += n3;
        }
        return this;
    }

    public StringBuilder replace(char c2, String string) {
        int n2 = string.length();
        int n3 = 0;
        while (n3 != this.length) {
            if (this.chars[n3] != c2) {
                ++n3;
                continue;
            }
            this.replace0(n3, n3 + 1, string);
            n3 += n2;
        }
        return this;
    }

    public StringBuilder reverse() {
        this.reverse0();
        return this;
    }

    @Override
    public boolean isEmpty() {
        return this.length == 0;
    }

    public boolean notEmpty() {
        return this.length != 0;
    }

    public int hashCode() {
        int n2 = 31 + this.length;
        for (int i2 = 0; i2 < this.length; ++i2) {
            n2 = 31 * n2 + this.chars[i2];
        }
        return n2;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (this.getClass() != object.getClass()) {
            return false;
        }
        StringBuilder stringBuilder = (StringBuilder)object;
        int n2 = this.length;
        if (n2 != stringBuilder.length) {
            return false;
        }
        char[] cArray = this.chars;
        char[] cArray2 = stringBuilder.chars;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (cArray[i2] == cArray2[i2]) continue;
            return false;
        }
        return true;
    }

    public boolean equalsIgnoreCase(@Null StringBuilder stringBuilder) {
        if (this == stringBuilder) {
            return true;
        }
        if (stringBuilder == null) {
            return false;
        }
        int n2 = this.length;
        if (n2 != stringBuilder.length) {
            return false;
        }
        char[] cArray = this.chars;
        char[] cArray2 = stringBuilder.chars;
        for (int i2 = 0; i2 < n2; ++i2) {
            char c2 = cArray[i2];
            char c3 = Character.toUpperCase(cArray2[i2]);
            if (c2 == c3 || c2 == Character.toLowerCase(c3)) continue;
            return false;
        }
        return true;
    }

    public boolean equalsIgnoreCase(@Null String string) {
        if (string == null) {
            return false;
        }
        int n2 = this.length;
        if (n2 != string.length()) {
            return false;
        }
        char[] cArray = this.chars;
        for (int i2 = 0; i2 < n2; ++i2) {
            char c2 = cArray[i2];
            char c3 = Character.toUpperCase(string.charAt(i2));
            if (c2 == c3 || c2 == Character.toLowerCase(c3)) continue;
            return false;
        }
        return true;
    }
}

