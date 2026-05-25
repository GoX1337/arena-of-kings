/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3.text;

import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;
import java.nio.CharBuffer;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.builder.Builder;
import org.apache.commons.lang3.text.StrMatcher;
import org.apache.commons.lang3.text.StrTokenizer;

@Deprecated
public class StrBuilder
implements Serializable,
Appendable,
CharSequence,
Builder<String> {
    static final int CAPACITY = 32;
    private static final long serialVersionUID = 7628716375283629643L;
    protected char[] buffer;
    protected int size;
    private String newLine;
    private String nullText;

    public StrBuilder() {
        this(32);
    }

    public StrBuilder(int n2) {
        if (n2 <= 0) {
            n2 = 32;
        }
        this.buffer = new char[n2];
    }

    public StrBuilder(String string) {
        if (string == null) {
            this.buffer = new char[32];
        } else {
            this.buffer = new char[string.length() + 32];
            this.append(string);
        }
    }

    public String getNewLineText() {
        return this.newLine;
    }

    public StrBuilder setNewLineText(String string) {
        this.newLine = string;
        return this;
    }

    public String getNullText() {
        return this.nullText;
    }

    public StrBuilder setNullText(String string) {
        if (string != null && string.isEmpty()) {
            string = null;
        }
        this.nullText = string;
        return this;
    }

    @Override
    public int length() {
        return this.size;
    }

    public StrBuilder setLength(int n2) {
        if (n2 < 0) {
            throw new StringIndexOutOfBoundsException(n2);
        }
        if (n2 < this.size) {
            this.size = n2;
        } else if (n2 > this.size) {
            this.ensureCapacity(n2);
            int n3 = this.size;
            int n4 = n2;
            this.size = n2;
            for (int i2 = n3; i2 < n4; ++i2) {
                this.buffer[i2] = '\u0000';
            }
        }
        return this;
    }

    public int capacity() {
        return this.buffer.length;
    }

    public StrBuilder ensureCapacity(int n2) {
        if (n2 > this.buffer.length) {
            char[] cArray = this.buffer;
            this.buffer = new char[n2 * 2];
            System.arraycopy(cArray, 0, this.buffer, 0, this.size);
        }
        return this;
    }

    public StrBuilder minimizeCapacity() {
        if (this.buffer.length > this.length()) {
            char[] cArray = this.buffer;
            this.buffer = new char[this.length()];
            System.arraycopy(cArray, 0, this.buffer, 0, this.size);
        }
        return this;
    }

    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isNotEmpty() {
        return this.size > 0;
    }

    public StrBuilder clear() {
        this.size = 0;
        return this;
    }

    @Override
    public char charAt(int n2) {
        if (n2 < 0 || n2 >= this.length()) {
            throw new StringIndexOutOfBoundsException(n2);
        }
        return this.buffer[n2];
    }

    public StrBuilder setCharAt(int n2, char c2) {
        if (n2 < 0 || n2 >= this.length()) {
            throw new StringIndexOutOfBoundsException(n2);
        }
        this.buffer[n2] = c2;
        return this;
    }

    public StrBuilder deleteCharAt(int n2) {
        if (n2 < 0 || n2 >= this.size) {
            throw new StringIndexOutOfBoundsException(n2);
        }
        this.deleteImpl(n2, n2 + 1, 1);
        return this;
    }

    public char[] toCharArray() {
        if (this.size == 0) {
            return ArrayUtils.EMPTY_CHAR_ARRAY;
        }
        char[] cArray = new char[this.size];
        System.arraycopy(this.buffer, 0, cArray, 0, this.size);
        return cArray;
    }

    public char[] toCharArray(int n2, int n3) {
        int n4 = (n3 = this.validateRange(n2, n3)) - n2;
        if (n4 == 0) {
            return ArrayUtils.EMPTY_CHAR_ARRAY;
        }
        char[] cArray = new char[n4];
        System.arraycopy(this.buffer, n2, cArray, 0, n4);
        return cArray;
    }

    public char[] getChars(char[] cArray) {
        int n2 = this.length();
        if (cArray == null || cArray.length < n2) {
            cArray = new char[n2];
        }
        System.arraycopy(this.buffer, 0, cArray, 0, n2);
        return cArray;
    }

    public void getChars(int n2, int n3, char[] cArray, int n4) {
        if (n2 < 0) {
            throw new StringIndexOutOfBoundsException(n2);
        }
        if (n3 < 0 || n3 > this.length()) {
            throw new StringIndexOutOfBoundsException(n3);
        }
        if (n2 > n3) {
            throw new StringIndexOutOfBoundsException("end < start");
        }
        System.arraycopy(this.buffer, n2, cArray, n4, n3 - n2);
    }

    public int readFrom(Readable readable) {
        int n2 = this.size;
        if (readable instanceof Reader) {
            int n3;
            Reader reader = (Reader)readable;
            this.ensureCapacity(this.size + 1);
            while ((n3 = reader.read(this.buffer, this.size, this.buffer.length - this.size)) != -1) {
                this.size += n3;
                this.ensureCapacity(this.size + 1);
            }
        } else if (readable instanceof CharBuffer) {
            CharBuffer charBuffer = (CharBuffer)readable;
            int n4 = charBuffer.remaining();
            this.ensureCapacity(this.size + n4);
            charBuffer.get(this.buffer, this.size, n4);
            this.size += n4;
        } else {
            while (true) {
                this.ensureCapacity(this.size + 1);
                CharBuffer charBuffer = CharBuffer.wrap(this.buffer, this.size, this.buffer.length - this.size);
                int n5 = readable.read(charBuffer);
                if (n5 == -1) break;
                this.size += n5;
            }
        }
        return this.size - n2;
    }

    public StrBuilder appendNewLine() {
        if (this.newLine == null) {
            this.append(System.lineSeparator());
            return this;
        }
        return this.append(this.newLine);
    }

    public StrBuilder appendNull() {
        if (this.nullText == null) {
            return this;
        }
        return this.append(this.nullText);
    }

    public StrBuilder append(Object object) {
        if (object == null) {
            return this.appendNull();
        }
        if (object instanceof CharSequence) {
            return this.append((CharSequence)object);
        }
        return this.append(object.toString());
    }

    @Override
    public StrBuilder append(CharSequence charSequence) {
        if (charSequence == null) {
            return this.appendNull();
        }
        if (charSequence instanceof StrBuilder) {
            return this.append((StrBuilder)charSequence);
        }
        if (charSequence instanceof StringBuilder) {
            return this.append((StringBuilder)charSequence);
        }
        if (charSequence instanceof StringBuffer) {
            return this.append((StringBuffer)charSequence);
        }
        if (charSequence instanceof CharBuffer) {
            return this.append((CharBuffer)charSequence);
        }
        return this.append(charSequence.toString());
    }

    @Override
    public StrBuilder append(CharSequence charSequence, int n2, int n3) {
        if (charSequence == null) {
            return this.appendNull();
        }
        return this.append(charSequence.toString(), n2, n3);
    }

    public StrBuilder append(String string) {
        if (string == null) {
            return this.appendNull();
        }
        int n2 = string.length();
        if (n2 > 0) {
            int n3 = this.length();
            this.ensureCapacity(n3 + n2);
            string.getChars(0, n2, this.buffer, n3);
            this.size += n2;
        }
        return this;
    }

    public StrBuilder append(String string, int n2, int n3) {
        if (string == null) {
            return this.appendNull();
        }
        if (n2 < 0 || n2 > string.length()) {
            throw new StringIndexOutOfBoundsException("startIndex must be valid");
        }
        if (n3 < 0 || n2 + n3 > string.length()) {
            throw new StringIndexOutOfBoundsException("length must be valid");
        }
        if (n3 > 0) {
            int n4 = this.length();
            this.ensureCapacity(n4 + n3);
            string.getChars(n2, n2 + n3, this.buffer, n4);
            this.size += n3;
        }
        return this;
    }

    public StrBuilder append(String string, Object ... objectArray) {
        return this.append(String.format(string, objectArray));
    }

    public StrBuilder append(CharBuffer charBuffer) {
        if (charBuffer == null) {
            return this.appendNull();
        }
        if (charBuffer.hasArray()) {
            int n2 = charBuffer.remaining();
            int n3 = this.length();
            this.ensureCapacity(n3 + n2);
            System.arraycopy(charBuffer.array(), charBuffer.arrayOffset() + charBuffer.position(), this.buffer, n3, n2);
            this.size += n2;
        } else {
            this.append(charBuffer.toString());
        }
        return this;
    }

    public StrBuilder append(CharBuffer charBuffer, int n2, int n3) {
        if (charBuffer == null) {
            return this.appendNull();
        }
        if (charBuffer.hasArray()) {
            int n4 = charBuffer.remaining();
            if (n2 < 0 || n2 > n4) {
                throw new StringIndexOutOfBoundsException("startIndex must be valid");
            }
            if (n3 < 0 || n2 + n3 > n4) {
                throw new StringIndexOutOfBoundsException("length must be valid");
            }
            int n5 = this.length();
            this.ensureCapacity(n5 + n3);
            System.arraycopy(charBuffer.array(), charBuffer.arrayOffset() + charBuffer.position() + n2, this.buffer, n5, n3);
            this.size += n3;
        } else {
            this.append(charBuffer.toString(), n2, n3);
        }
        return this;
    }

    public StrBuilder append(StringBuffer stringBuffer) {
        if (stringBuffer == null) {
            return this.appendNull();
        }
        int n2 = stringBuffer.length();
        if (n2 > 0) {
            int n3 = this.length();
            this.ensureCapacity(n3 + n2);
            stringBuffer.getChars(0, n2, this.buffer, n3);
            this.size += n2;
        }
        return this;
    }

    public StrBuilder append(StringBuffer stringBuffer, int n2, int n3) {
        if (stringBuffer == null) {
            return this.appendNull();
        }
        if (n2 < 0 || n2 > stringBuffer.length()) {
            throw new StringIndexOutOfBoundsException("startIndex must be valid");
        }
        if (n3 < 0 || n2 + n3 > stringBuffer.length()) {
            throw new StringIndexOutOfBoundsException("length must be valid");
        }
        if (n3 > 0) {
            int n4 = this.length();
            this.ensureCapacity(n4 + n3);
            stringBuffer.getChars(n2, n2 + n3, this.buffer, n4);
            this.size += n3;
        }
        return this;
    }

    public StrBuilder append(StringBuilder stringBuilder) {
        if (stringBuilder == null) {
            return this.appendNull();
        }
        int n2 = stringBuilder.length();
        if (n2 > 0) {
            int n3 = this.length();
            this.ensureCapacity(n3 + n2);
            stringBuilder.getChars(0, n2, this.buffer, n3);
            this.size += n2;
        }
        return this;
    }

    public StrBuilder append(StringBuilder stringBuilder, int n2, int n3) {
        if (stringBuilder == null) {
            return this.appendNull();
        }
        if (n2 < 0 || n2 > stringBuilder.length()) {
            throw new StringIndexOutOfBoundsException("startIndex must be valid");
        }
        if (n3 < 0 || n2 + n3 > stringBuilder.length()) {
            throw new StringIndexOutOfBoundsException("length must be valid");
        }
        if (n3 > 0) {
            int n4 = this.length();
            this.ensureCapacity(n4 + n3);
            stringBuilder.getChars(n2, n2 + n3, this.buffer, n4);
            this.size += n3;
        }
        return this;
    }

    public StrBuilder append(StrBuilder strBuilder) {
        if (strBuilder == null) {
            return this.appendNull();
        }
        int n2 = strBuilder.length();
        if (n2 > 0) {
            int n3 = this.length();
            this.ensureCapacity(n3 + n2);
            System.arraycopy(strBuilder.buffer, 0, this.buffer, n3, n2);
            this.size += n2;
        }
        return this;
    }

    public StrBuilder append(StrBuilder strBuilder, int n2, int n3) {
        if (strBuilder == null) {
            return this.appendNull();
        }
        if (n2 < 0 || n2 > strBuilder.length()) {
            throw new StringIndexOutOfBoundsException("startIndex must be valid");
        }
        if (n3 < 0 || n2 + n3 > strBuilder.length()) {
            throw new StringIndexOutOfBoundsException("length must be valid");
        }
        if (n3 > 0) {
            int n4 = this.length();
            this.ensureCapacity(n4 + n3);
            strBuilder.getChars(n2, n2 + n3, this.buffer, n4);
            this.size += n3;
        }
        return this;
    }

    public StrBuilder append(char[] cArray) {
        if (cArray == null) {
            return this.appendNull();
        }
        int n2 = cArray.length;
        if (n2 > 0) {
            int n3 = this.length();
            this.ensureCapacity(n3 + n2);
            System.arraycopy(cArray, 0, this.buffer, n3, n2);
            this.size += n2;
        }
        return this;
    }

    public StrBuilder append(char[] cArray, int n2, int n3) {
        if (cArray == null) {
            return this.appendNull();
        }
        if (n2 < 0 || n2 > cArray.length) {
            throw new StringIndexOutOfBoundsException("Invalid startIndex: " + n3);
        }
        if (n3 < 0 || n2 + n3 > cArray.length) {
            throw new StringIndexOutOfBoundsException("Invalid length: " + n3);
        }
        if (n3 > 0) {
            int n4 = this.length();
            this.ensureCapacity(n4 + n3);
            System.arraycopy(cArray, n2, this.buffer, n4, n3);
            this.size += n3;
        }
        return this;
    }

    public StrBuilder append(boolean bl2) {
        if (bl2) {
            this.ensureCapacity(this.size + 4);
            this.buffer[this.size++] = 116;
            this.buffer[this.size++] = 114;
            this.buffer[this.size++] = 117;
            this.buffer[this.size++] = 101;
        } else {
            this.ensureCapacity(this.size + 5);
            this.buffer[this.size++] = 102;
            this.buffer[this.size++] = 97;
            this.buffer[this.size++] = 108;
            this.buffer[this.size++] = 115;
            this.buffer[this.size++] = 101;
        }
        return this;
    }

    @Override
    public StrBuilder append(char c2) {
        int n2 = this.length();
        this.ensureCapacity(n2 + 1);
        this.buffer[this.size++] = c2;
        return this;
    }

    public StrBuilder append(int n2) {
        return this.append(String.valueOf(n2));
    }

    public StrBuilder append(long l2) {
        return this.append(String.valueOf(l2));
    }

    public StrBuilder append(float f2) {
        return this.append(String.valueOf(f2));
    }

    public StrBuilder append(double d2) {
        return this.append(String.valueOf(d2));
    }

    public StrBuilder appendln(Object object) {
        return this.append(object).appendNewLine();
    }

    public StrBuilder appendln(String string) {
        return this.append(string).appendNewLine();
    }

    public StrBuilder appendln(String string, int n2, int n3) {
        return this.append(string, n2, n3).appendNewLine();
    }

    public StrBuilder appendln(String string, Object ... objectArray) {
        return this.append(string, objectArray).appendNewLine();
    }

    public StrBuilder appendln(StringBuffer stringBuffer) {
        return this.append(stringBuffer).appendNewLine();
    }

    public StrBuilder appendln(StringBuilder stringBuilder) {
        return this.append(stringBuilder).appendNewLine();
    }

    public StrBuilder appendln(StringBuilder stringBuilder, int n2, int n3) {
        return this.append(stringBuilder, n2, n3).appendNewLine();
    }

    public StrBuilder appendln(StringBuffer stringBuffer, int n2, int n3) {
        return this.append(stringBuffer, n2, n3).appendNewLine();
    }

    public StrBuilder appendln(StrBuilder strBuilder) {
        return this.append(strBuilder).appendNewLine();
    }

    public StrBuilder appendln(StrBuilder strBuilder, int n2, int n3) {
        return this.append(strBuilder, n2, n3).appendNewLine();
    }

    public StrBuilder appendln(char[] cArray) {
        return this.append(cArray).appendNewLine();
    }

    public StrBuilder appendln(char[] cArray, int n2, int n3) {
        return this.append(cArray, n2, n3).appendNewLine();
    }

    public StrBuilder appendln(boolean bl2) {
        return this.append(bl2).appendNewLine();
    }

    public StrBuilder appendln(char c2) {
        return this.append(c2).appendNewLine();
    }

    public StrBuilder appendln(int n2) {
        return this.append(n2).appendNewLine();
    }

    public StrBuilder appendln(long l2) {
        return this.append(l2).appendNewLine();
    }

    public StrBuilder appendln(float f2) {
        return this.append(f2).appendNewLine();
    }

    public StrBuilder appendln(double d2) {
        return this.append(d2).appendNewLine();
    }

    public <T> StrBuilder appendAll(T ... TArray) {
        if (ArrayUtils.isNotEmpty(TArray)) {
            for (T t2 : TArray) {
                this.append(t2);
            }
        }
        return this;
    }

    public StrBuilder appendAll(Iterable<?> iterable) {
        if (iterable != null) {
            for (Object obj : iterable) {
                this.append(obj);
            }
        }
        return this;
    }

    public StrBuilder appendAll(Iterator<?> iterator) {
        if (iterator != null) {
            while (iterator.hasNext()) {
                this.append(iterator.next());
            }
        }
        return this;
    }

    public StrBuilder appendWithSeparators(Object[] objectArray, String string) {
        if (objectArray != null && objectArray.length > 0) {
            String string2 = Objects.toString(string, "");
            this.append(objectArray[0]);
            for (int i2 = 1; i2 < objectArray.length; ++i2) {
                this.append(string2);
                this.append(objectArray[i2]);
            }
        }
        return this;
    }

    public StrBuilder appendWithSeparators(Iterable<?> iterable, String string) {
        if (iterable != null) {
            String string2 = Objects.toString(string, "");
            Iterator<?> iterator = iterable.iterator();
            while (iterator.hasNext()) {
                this.append(iterator.next());
                if (!iterator.hasNext()) continue;
                this.append(string2);
            }
        }
        return this;
    }

    public StrBuilder appendWithSeparators(Iterator<?> iterator, String string) {
        if (iterator != null) {
            String string2 = Objects.toString(string, "");
            while (iterator.hasNext()) {
                this.append(iterator.next());
                if (!iterator.hasNext()) continue;
                this.append(string2);
            }
        }
        return this;
    }

    public StrBuilder appendSeparator(String string) {
        return this.appendSeparator(string, null);
    }

    public StrBuilder appendSeparator(String string, String string2) {
        String string3;
        String string4 = string3 = this.isEmpty() ? string2 : string;
        if (string3 != null) {
            this.append(string3);
        }
        return this;
    }

    public StrBuilder appendSeparator(char c2) {
        if (this.isNotEmpty()) {
            this.append(c2);
        }
        return this;
    }

    public StrBuilder appendSeparator(char c2, char c3) {
        if (this.isNotEmpty()) {
            this.append(c2);
        } else {
            this.append(c3);
        }
        return this;
    }

    public StrBuilder appendSeparator(String string, int n2) {
        if (string != null && n2 > 0) {
            this.append(string);
        }
        return this;
    }

    public StrBuilder appendSeparator(char c2, int n2) {
        if (n2 > 0) {
            this.append(c2);
        }
        return this;
    }

    public StrBuilder appendPadding(int n2, char c2) {
        if (n2 >= 0) {
            this.ensureCapacity(this.size + n2);
            for (int i2 = 0; i2 < n2; ++i2) {
                this.buffer[this.size++] = c2;
            }
        }
        return this;
    }

    public StrBuilder appendFixedWidthPadLeft(Object object, int n2, char c2) {
        if (n2 > 0) {
            int n3;
            String string;
            this.ensureCapacity(this.size + n2);
            String string2 = string = object == null ? this.getNullText() : object.toString();
            if (string == null) {
                string = "";
            }
            if ((n3 = string.length()) >= n2) {
                string.getChars(n3 - n2, n3, this.buffer, this.size);
            } else {
                int n4 = n2 - n3;
                for (int i2 = 0; i2 < n4; ++i2) {
                    this.buffer[this.size + i2] = c2;
                }
                string.getChars(0, n3, this.buffer, this.size + n4);
            }
            this.size += n2;
        }
        return this;
    }

    public StrBuilder appendFixedWidthPadLeft(int n2, int n3, char c2) {
        return this.appendFixedWidthPadLeft(String.valueOf(n2), n3, c2);
    }

    public StrBuilder appendFixedWidthPadRight(Object object, int n2, char c2) {
        if (n2 > 0) {
            int n3;
            String string;
            this.ensureCapacity(this.size + n2);
            String string2 = string = object == null ? this.getNullText() : object.toString();
            if (string == null) {
                string = "";
            }
            if ((n3 = string.length()) >= n2) {
                string.getChars(0, n2, this.buffer, this.size);
            } else {
                int n4 = n2 - n3;
                string.getChars(0, n3, this.buffer, this.size);
                for (int i2 = 0; i2 < n4; ++i2) {
                    this.buffer[this.size + n3 + i2] = c2;
                }
            }
            this.size += n2;
        }
        return this;
    }

    public StrBuilder appendFixedWidthPadRight(int n2, int n3, char c2) {
        return this.appendFixedWidthPadRight(String.valueOf(n2), n3, c2);
    }

    public StrBuilder insert(int n2, Object object) {
        if (object == null) {
            return this.insert(n2, this.nullText);
        }
        return this.insert(n2, object.toString());
    }

    public StrBuilder insert(int n2, String string) {
        int n3;
        this.validateIndex(n2);
        if (string == null) {
            string = this.nullText;
        }
        if (string != null && (n3 = string.length()) > 0) {
            int n4 = this.size + n3;
            this.ensureCapacity(n4);
            System.arraycopy(this.buffer, n2, this.buffer, n2 + n3, this.size - n2);
            this.size = n4;
            string.getChars(0, n3, this.buffer, n2);
        }
        return this;
    }

    public StrBuilder insert(int n2, char[] cArray) {
        this.validateIndex(n2);
        if (cArray == null) {
            return this.insert(n2, this.nullText);
        }
        int n3 = cArray.length;
        if (n3 > 0) {
            this.ensureCapacity(this.size + n3);
            System.arraycopy(this.buffer, n2, this.buffer, n2 + n3, this.size - n2);
            System.arraycopy(cArray, 0, this.buffer, n2, n3);
            this.size += n3;
        }
        return this;
    }

    public StrBuilder insert(int n2, char[] cArray, int n3, int n4) {
        this.validateIndex(n2);
        if (cArray == null) {
            return this.insert(n2, this.nullText);
        }
        if (n3 < 0 || n3 > cArray.length) {
            throw new StringIndexOutOfBoundsException("Invalid offset: " + n3);
        }
        if (n4 < 0 || n3 + n4 > cArray.length) {
            throw new StringIndexOutOfBoundsException("Invalid length: " + n4);
        }
        if (n4 > 0) {
            this.ensureCapacity(this.size + n4);
            System.arraycopy(this.buffer, n2, this.buffer, n2 + n4, this.size - n2);
            System.arraycopy(cArray, n3, this.buffer, n2, n4);
            this.size += n4;
        }
        return this;
    }

    public StrBuilder insert(int n2, boolean bl2) {
        this.validateIndex(n2);
        if (bl2) {
            this.ensureCapacity(this.size + 4);
            System.arraycopy(this.buffer, n2, this.buffer, n2 + 4, this.size - n2);
            this.buffer[n2++] = 116;
            this.buffer[n2++] = 114;
            this.buffer[n2++] = 117;
            this.buffer[n2] = 101;
            this.size += 4;
        } else {
            this.ensureCapacity(this.size + 5);
            System.arraycopy(this.buffer, n2, this.buffer, n2 + 5, this.size - n2);
            this.buffer[n2++] = 102;
            this.buffer[n2++] = 97;
            this.buffer[n2++] = 108;
            this.buffer[n2++] = 115;
            this.buffer[n2] = 101;
            this.size += 5;
        }
        return this;
    }

    public StrBuilder insert(int n2, char c2) {
        this.validateIndex(n2);
        this.ensureCapacity(this.size + 1);
        System.arraycopy(this.buffer, n2, this.buffer, n2 + 1, this.size - n2);
        this.buffer[n2] = c2;
        ++this.size;
        return this;
    }

    public StrBuilder insert(int n2, int n3) {
        return this.insert(n2, String.valueOf(n3));
    }

    public StrBuilder insert(int n2, long l2) {
        return this.insert(n2, String.valueOf(l2));
    }

    public StrBuilder insert(int n2, float f2) {
        return this.insert(n2, String.valueOf(f2));
    }

    public StrBuilder insert(int n2, double d2) {
        return this.insert(n2, String.valueOf(d2));
    }

    private void deleteImpl(int n2, int n3, int n4) {
        System.arraycopy(this.buffer, n3, this.buffer, n2, this.size - n3);
        this.size -= n4;
    }

    public StrBuilder delete(int n2, int n3) {
        int n4 = (n3 = this.validateRange(n2, n3)) - n2;
        if (n4 > 0) {
            this.deleteImpl(n2, n3, n4);
        }
        return this;
    }

    public StrBuilder deleteAll(char c2) {
        for (int i2 = 0; i2 < this.size; ++i2) {
            if (this.buffer[i2] != c2) continue;
            int n2 = i2;
            while (++i2 < this.size && this.buffer[i2] == c2) {
            }
            int n3 = i2 - n2;
            this.deleteImpl(n2, i2, n3);
            i2 -= n3;
        }
        return this;
    }

    public StrBuilder deleteFirst(char c2) {
        for (int i2 = 0; i2 < this.size; ++i2) {
            if (this.buffer[i2] != c2) continue;
            this.deleteImpl(i2, i2 + 1, 1);
            break;
        }
        return this;
    }

    public StrBuilder deleteAll(String string) {
        int n2;
        int n3 = n2 = string == null ? 0 : string.length();
        if (n2 > 0) {
            int n4 = this.indexOf(string, 0);
            while (n4 >= 0) {
                this.deleteImpl(n4, n4 + n2, n2);
                n4 = this.indexOf(string, n4);
            }
        }
        return this;
    }

    public StrBuilder deleteFirst(String string) {
        int n2;
        int n3;
        int n4 = n3 = string == null ? 0 : string.length();
        if (n3 > 0 && (n2 = this.indexOf(string, 0)) >= 0) {
            this.deleteImpl(n2, n2 + n3, n3);
        }
        return this;
    }

    public StrBuilder deleteAll(StrMatcher strMatcher) {
        return this.replace(strMatcher, null, 0, this.size, -1);
    }

    public StrBuilder deleteFirst(StrMatcher strMatcher) {
        return this.replace(strMatcher, null, 0, this.size, 1);
    }

    private void replaceImpl(int n2, int n3, int n4, String string, int n5) {
        int n6 = this.size - n4 + n5;
        if (n5 != n4) {
            this.ensureCapacity(n6);
            System.arraycopy(this.buffer, n3, this.buffer, n2 + n5, this.size - n3);
            this.size = n6;
        }
        if (n5 > 0) {
            string.getChars(0, n5, this.buffer, n2);
        }
    }

    public StrBuilder replace(int n2, int n3, String string) {
        n3 = this.validateRange(n2, n3);
        int n4 = string == null ? 0 : string.length();
        this.replaceImpl(n2, n3, n3 - n2, string, n4);
        return this;
    }

    public StrBuilder replaceAll(char c2, char c3) {
        if (c2 != c3) {
            for (int i2 = 0; i2 < this.size; ++i2) {
                if (this.buffer[i2] != c2) continue;
                this.buffer[i2] = c3;
            }
        }
        return this;
    }

    public StrBuilder replaceFirst(char c2, char c3) {
        if (c2 != c3) {
            for (int i2 = 0; i2 < this.size; ++i2) {
                if (this.buffer[i2] != c2) continue;
                this.buffer[i2] = c3;
                break;
            }
        }
        return this;
    }

    public StrBuilder replaceAll(String string, String string2) {
        int n2;
        int n3 = n2 = string == null ? 0 : string.length();
        if (n2 > 0) {
            int n4 = string2 == null ? 0 : string2.length();
            int n5 = this.indexOf(string, 0);
            while (n5 >= 0) {
                this.replaceImpl(n5, n5 + n2, n2, string2, n4);
                n5 = this.indexOf(string, n5 + n4);
            }
        }
        return this;
    }

    public StrBuilder replaceFirst(String string, String string2) {
        int n2;
        int n3;
        int n4 = n3 = string == null ? 0 : string.length();
        if (n3 > 0 && (n2 = this.indexOf(string, 0)) >= 0) {
            int n5 = string2 == null ? 0 : string2.length();
            this.replaceImpl(n2, n2 + n3, n3, string2, n5);
        }
        return this;
    }

    public StrBuilder replaceAll(StrMatcher strMatcher, String string) {
        return this.replace(strMatcher, string, 0, this.size, -1);
    }

    public StrBuilder replaceFirst(StrMatcher strMatcher, String string) {
        return this.replace(strMatcher, string, 0, this.size, 1);
    }

    public StrBuilder replace(StrMatcher strMatcher, String string, int n2, int n3, int n4) {
        n3 = this.validateRange(n2, n3);
        return this.replaceImpl(strMatcher, string, n2, n3, n4);
    }

    private StrBuilder replaceImpl(StrMatcher strMatcher, String string, int n2, int n3, int n4) {
        if (strMatcher == null || this.size == 0) {
            return this;
        }
        int n5 = string == null ? 0 : string.length();
        for (int i2 = n2; i2 < n3 && n4 != 0; ++i2) {
            char[] cArray = this.buffer;
            int n6 = strMatcher.isMatch(cArray, i2, n2, n3);
            if (n6 <= 0) continue;
            this.replaceImpl(i2, i2 + n6, n6, string, n5);
            n3 = n3 - n6 + n5;
            i2 = i2 + n5 - 1;
            if (n4 <= 0) continue;
            --n4;
        }
        return this;
    }

    public StrBuilder reverse() {
        if (this.size == 0) {
            return this;
        }
        int n2 = this.size / 2;
        char[] cArray = this.buffer;
        int n3 = 0;
        int n4 = this.size - 1;
        while (n3 < n2) {
            char c2 = cArray[n3];
            cArray[n3] = cArray[n4];
            cArray[n4] = c2;
            ++n3;
            --n4;
        }
        return this;
    }

    public StrBuilder trim() {
        int n2;
        if (this.size == 0) {
            return this;
        }
        int n3 = this.size;
        char[] cArray = this.buffer;
        for (n2 = 0; n2 < n3 && cArray[n2] <= ' '; ++n2) {
        }
        while (n2 < n3 && cArray[n3 - 1] <= ' ') {
            --n3;
        }
        if (n3 < this.size) {
            this.delete(n3, this.size);
        }
        if (n2 > 0) {
            this.delete(0, n2);
        }
        return this;
    }

    public boolean startsWith(String string) {
        if (string == null) {
            return false;
        }
        int n2 = string.length();
        if (n2 == 0) {
            return true;
        }
        if (n2 > this.size) {
            return false;
        }
        for (int i2 = 0; i2 < n2; ++i2) {
            if (this.buffer[i2] == string.charAt(i2)) continue;
            return false;
        }
        return true;
    }

    public boolean endsWith(String string) {
        if (string == null) {
            return false;
        }
        int n2 = string.length();
        if (n2 == 0) {
            return true;
        }
        if (n2 > this.size) {
            return false;
        }
        int n3 = this.size - n2;
        int n4 = 0;
        while (n4 < n2) {
            if (this.buffer[n3] != string.charAt(n4)) {
                return false;
            }
            ++n4;
            ++n3;
        }
        return true;
    }

    @Override
    public CharSequence subSequence(int n2, int n3) {
        if (n2 < 0) {
            throw new StringIndexOutOfBoundsException(n2);
        }
        if (n3 > this.size) {
            throw new StringIndexOutOfBoundsException(n3);
        }
        if (n2 > n3) {
            throw new StringIndexOutOfBoundsException(n3 - n2);
        }
        return this.substring(n2, n3);
    }

    public String substring(int n2) {
        return this.substring(n2, this.size);
    }

    public String substring(int n2, int n3) {
        n3 = this.validateRange(n2, n3);
        return new String(this.buffer, n2, n3 - n2);
    }

    public String leftString(int n2) {
        if (n2 <= 0) {
            return "";
        }
        if (n2 >= this.size) {
            return new String(this.buffer, 0, this.size);
        }
        return new String(this.buffer, 0, n2);
    }

    public String rightString(int n2) {
        if (n2 <= 0) {
            return "";
        }
        if (n2 >= this.size) {
            return new String(this.buffer, 0, this.size);
        }
        return new String(this.buffer, this.size - n2, n2);
    }

    public String midString(int n2, int n3) {
        if (n2 < 0) {
            n2 = 0;
        }
        if (n3 <= 0 || n2 >= this.size) {
            return "";
        }
        if (this.size <= n2 + n3) {
            return new String(this.buffer, n2, this.size - n2);
        }
        return new String(this.buffer, n2, n3);
    }

    public boolean contains(char c2) {
        char[] cArray = this.buffer;
        for (int i2 = 0; i2 < this.size; ++i2) {
            if (cArray[i2] != c2) continue;
            return true;
        }
        return false;
    }

    public boolean contains(String string) {
        return this.indexOf(string, 0) >= 0;
    }

    public boolean contains(StrMatcher strMatcher) {
        return this.indexOf(strMatcher, 0) >= 0;
    }

    public int indexOf(char c2) {
        return this.indexOf(c2, 0);
    }

    public int indexOf(char c2, int n2) {
        if ((n2 = Math.max(n2, 0)) >= this.size) {
            return -1;
        }
        char[] cArray = this.buffer;
        for (int i2 = n2; i2 < this.size; ++i2) {
            if (cArray[i2] != c2) continue;
            return i2;
        }
        return -1;
    }

    public int indexOf(String string) {
        return this.indexOf(string, 0);
    }

    public int indexOf(String string, int n2) {
        n2 = Math.max(n2, 0);
        if (string == null || n2 >= this.size) {
            return -1;
        }
        int n3 = string.length();
        if (n3 == 1) {
            return this.indexOf(string.charAt(0), n2);
        }
        if (n3 == 0) {
            return n2;
        }
        if (n3 > this.size) {
            return -1;
        }
        char[] cArray = this.buffer;
        int n4 = this.size - n3 + 1;
        block0: for (int i2 = n2; i2 < n4; ++i2) {
            for (int i3 = 0; i3 < n3; ++i3) {
                if (string.charAt(i3) != cArray[i2 + i3]) continue block0;
            }
            return i2;
        }
        return -1;
    }

    public int indexOf(StrMatcher strMatcher) {
        return this.indexOf(strMatcher, 0);
    }

    public int indexOf(StrMatcher strMatcher, int n2) {
        n2 = Math.max(n2, 0);
        if (strMatcher == null || n2 >= this.size) {
            return -1;
        }
        int n3 = this.size;
        char[] cArray = this.buffer;
        for (int i2 = n2; i2 < n3; ++i2) {
            if (strMatcher.isMatch(cArray, i2, n2, n3) <= 0) continue;
            return i2;
        }
        return -1;
    }

    public int lastIndexOf(char c2) {
        return this.lastIndexOf(c2, this.size - 1);
    }

    public int lastIndexOf(char c2, int n2) {
        int n3 = n2 = n2 >= this.size ? this.size - 1 : n2;
        if (n2 < 0) {
            return -1;
        }
        for (int i2 = n2; i2 >= 0; --i2) {
            if (this.buffer[i2] != c2) continue;
            return i2;
        }
        return -1;
    }

    public int lastIndexOf(String string) {
        return this.lastIndexOf(string, this.size - 1);
    }

    public int lastIndexOf(String string, int n2) {
        int n3 = n2 = n2 >= this.size ? this.size - 1 : n2;
        if (string == null || n2 < 0) {
            return -1;
        }
        int n4 = string.length();
        if (n4 > 0 && n4 <= this.size) {
            if (n4 == 1) {
                return this.lastIndexOf(string.charAt(0), n2);
            }
            block0: for (int i2 = n2 - n4 + 1; i2 >= 0; --i2) {
                for (int i3 = 0; i3 < n4; ++i3) {
                    if (string.charAt(i3) != this.buffer[i2 + i3]) continue block0;
                }
                return i2;
            }
        } else if (n4 == 0) {
            return n2;
        }
        return -1;
    }

    public int lastIndexOf(StrMatcher strMatcher) {
        return this.lastIndexOf(strMatcher, this.size);
    }

    public int lastIndexOf(StrMatcher strMatcher, int n2) {
        int n3 = n2 = n2 >= this.size ? this.size - 1 : n2;
        if (strMatcher == null || n2 < 0) {
            return -1;
        }
        char[] cArray = this.buffer;
        int n4 = n2 + 1;
        for (int i2 = n2; i2 >= 0; --i2) {
            if (strMatcher.isMatch(cArray, i2, 0, n4) <= 0) continue;
            return i2;
        }
        return -1;
    }

    public StrTokenizer asTokenizer() {
        return new StrBuilderTokenizer();
    }

    public Reader asReader() {
        return new StrBuilderReader();
    }

    public Writer asWriter() {
        return new StrBuilderWriter();
    }

    public void appendTo(Appendable appendable) {
        if (appendable instanceof Writer) {
            ((Writer)appendable).write(this.buffer, 0, this.size);
        } else if (appendable instanceof StringBuilder) {
            ((StringBuilder)appendable).append(this.buffer, 0, this.size);
        } else if (appendable instanceof StringBuffer) {
            ((StringBuffer)appendable).append(this.buffer, 0, this.size);
        } else if (appendable instanceof CharBuffer) {
            ((CharBuffer)appendable).put(this.buffer, 0, this.size);
        } else {
            appendable.append(this);
        }
    }

    public boolean equalsIgnoreCase(StrBuilder strBuilder) {
        if (this == strBuilder) {
            return true;
        }
        if (this.size != strBuilder.size) {
            return false;
        }
        char[] cArray = this.buffer;
        char[] cArray2 = strBuilder.buffer;
        for (int i2 = this.size - 1; i2 >= 0; --i2) {
            char c2 = cArray[i2];
            char c3 = cArray2[i2];
            if (c2 == c3 || Character.toUpperCase(c2) == Character.toUpperCase(c3)) continue;
            return false;
        }
        return true;
    }

    public boolean equals(StrBuilder strBuilder) {
        if (this == strBuilder) {
            return true;
        }
        if (strBuilder == null) {
            return false;
        }
        if (this.size != strBuilder.size) {
            return false;
        }
        char[] cArray = this.buffer;
        char[] cArray2 = strBuilder.buffer;
        for (int i2 = this.size - 1; i2 >= 0; --i2) {
            if (cArray[i2] == cArray2[i2]) continue;
            return false;
        }
        return true;
    }

    public boolean equals(Object object) {
        return object instanceof StrBuilder && this.equals((StrBuilder)object);
    }

    public int hashCode() {
        char[] cArray = this.buffer;
        int n2 = 0;
        for (int i2 = this.size - 1; i2 >= 0; --i2) {
            n2 = 31 * n2 + cArray[i2];
        }
        return n2;
    }

    @Override
    public String toString() {
        return new String(this.buffer, 0, this.size);
    }

    public StringBuffer toStringBuffer() {
        return new StringBuffer(this.size).append(this.buffer, 0, this.size);
    }

    public StringBuilder toStringBuilder() {
        return new StringBuilder(this.size).append(this.buffer, 0, this.size);
    }

    @Override
    public String build() {
        return this.toString();
    }

    protected int validateRange(int n2, int n3) {
        if (n2 < 0) {
            throw new StringIndexOutOfBoundsException(n2);
        }
        if (n3 > this.size) {
            n3 = this.size;
        }
        if (n2 > n3) {
            throw new StringIndexOutOfBoundsException("end < start");
        }
        return n3;
    }

    protected void validateIndex(int n2) {
        if (n2 < 0 || n2 > this.size) {
            throw new StringIndexOutOfBoundsException(n2);
        }
    }

    class StrBuilderWriter
    extends Writer {
        StrBuilderWriter() {
        }

        @Override
        public void close() {
        }

        @Override
        public void flush() {
        }

        @Override
        public void write(int n2) {
            StrBuilder.this.append((char)n2);
        }

        @Override
        public void write(char[] cArray) {
            StrBuilder.this.append(cArray);
        }

        @Override
        public void write(char[] cArray, int n2, int n3) {
            StrBuilder.this.append(cArray, n2, n3);
        }

        @Override
        public void write(String string) {
            StrBuilder.this.append(string);
        }

        @Override
        public void write(String string, int n2, int n3) {
            StrBuilder.this.append(string, n2, n3);
        }
    }

    class StrBuilderReader
    extends Reader {
        private int pos;
        private int mark;

        StrBuilderReader() {
        }

        @Override
        public void close() {
        }

        @Override
        public int read() {
            if (!this.ready()) {
                return -1;
            }
            return StrBuilder.this.charAt(this.pos++);
        }

        @Override
        public int read(char[] cArray, int n2, int n3) {
            if (n2 < 0 || n3 < 0 || n2 > cArray.length || n2 + n3 > cArray.length || n2 + n3 < 0) {
                throw new IndexOutOfBoundsException();
            }
            if (n3 == 0) {
                return 0;
            }
            if (this.pos >= StrBuilder.this.size()) {
                return -1;
            }
            if (this.pos + n3 > StrBuilder.this.size()) {
                n3 = StrBuilder.this.size() - this.pos;
            }
            StrBuilder.this.getChars(this.pos, this.pos + n3, cArray, n2);
            this.pos += n3;
            return n3;
        }

        @Override
        public long skip(long l2) {
            if ((long)this.pos + l2 > (long)StrBuilder.this.size()) {
                l2 = StrBuilder.this.size() - this.pos;
            }
            if (l2 < 0L) {
                return 0L;
            }
            this.pos = (int)((long)this.pos + l2);
            return l2;
        }

        @Override
        public boolean ready() {
            return this.pos < StrBuilder.this.size();
        }

        @Override
        public boolean markSupported() {
            return true;
        }

        @Override
        public void mark(int n2) {
            this.mark = this.pos;
        }

        @Override
        public void reset() {
            this.pos = this.mark;
        }
    }

    class StrBuilderTokenizer
    extends StrTokenizer {
        StrBuilderTokenizer() {
        }

        @Override
        protected List<String> tokenize(char[] cArray, int n2, int n3) {
            if (cArray == null) {
                return super.tokenize(StrBuilder.this.buffer, 0, StrBuilder.this.size());
            }
            return super.tokenize(cArray, n2, n3);
        }

        @Override
        public String getContent() {
            String string = super.getContent();
            if (string == null) {
                return StrBuilder.this.toString();
            }
            return string;
        }
    }
}

