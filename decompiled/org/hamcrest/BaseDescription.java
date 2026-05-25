/*
 * Decompiled with CFR 0.152.
 */
package org.hamcrest;

import java.util.Arrays;
import java.util.Iterator;
import org.hamcrest.Description;
import org.hamcrest.SelfDescribing;
import org.hamcrest.internal.ArrayIterator;
import org.hamcrest.internal.SelfDescribingValueIterator;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public abstract class BaseDescription
implements Description {
    @Override
    public Description appendText(String string) {
        this.append(string);
        return this;
    }

    @Override
    public Description appendDescriptionOf(SelfDescribing selfDescribing) {
        selfDescribing.describeTo(this);
        return this;
    }

    @Override
    public Description appendValue(Object object) {
        if (object == null) {
            this.append("null");
        } else if (object instanceof String) {
            this.toJavaSyntax((String)object);
        } else if (object instanceof Character) {
            this.append('\"');
            this.toJavaSyntax(((Character)object).charValue());
            this.append('\"');
        } else if (object instanceof Short) {
            this.append('<');
            this.append(String.valueOf(object));
            this.append("s>");
        } else if (object instanceof Long) {
            this.append('<');
            this.append(String.valueOf(object));
            this.append("L>");
        } else if (object instanceof Float) {
            this.append('<');
            this.append(String.valueOf(object));
            this.append("F>");
        } else if (object.getClass().isArray()) {
            this.appendValueList("[", ", ", "]", new ArrayIterator(object));
        } else {
            this.append('<');
            this.append(String.valueOf(object));
            this.append('>');
        }
        return this;
    }

    @Override
    public <T> Description appendValueList(String string, String string2, String string3, T ... TArray) {
        return this.appendValueList(string, string2, string3, (Iterable<T>)Arrays.asList(TArray));
    }

    @Override
    public <T> Description appendValueList(String string, String string2, String string3, Iterable<T> iterable) {
        return this.appendValueList(string, string2, string3, iterable.iterator());
    }

    private <T> Description appendValueList(String string, String string2, String string3, Iterator<T> iterator) {
        return this.appendList(string, string2, string3, new SelfDescribingValueIterator<T>(iterator));
    }

    @Override
    public Description appendList(String string, String string2, String string3, Iterable<? extends SelfDescribing> iterable) {
        return this.appendList(string, string2, string3, iterable.iterator());
    }

    private Description appendList(String string, String string2, String string3, Iterator<? extends SelfDescribing> iterator) {
        boolean bl2 = false;
        this.append(string);
        while (iterator.hasNext()) {
            if (bl2) {
                this.append(string2);
            }
            this.appendDescriptionOf(iterator.next());
            bl2 = true;
        }
        this.append(string3);
        return this;
    }

    protected void append(String string) {
        for (int i2 = 0; i2 < string.length(); ++i2) {
            this.append(string.charAt(i2));
        }
    }

    protected abstract void append(char var1);

    private void toJavaSyntax(String string) {
        this.append('\"');
        for (int i2 = 0; i2 < string.length(); ++i2) {
            this.toJavaSyntax(string.charAt(i2));
        }
        this.append('\"');
    }

    private void toJavaSyntax(char c2) {
        switch (c2) {
            case '\"': {
                this.append("\\\"");
                break;
            }
            case '\n': {
                this.append("\\n");
                break;
            }
            case '\r': {
                this.append("\\r");
                break;
            }
            case '\t': {
                this.append("\\t");
                break;
            }
            default: {
                this.append(c2);
            }
        }
    }
}

