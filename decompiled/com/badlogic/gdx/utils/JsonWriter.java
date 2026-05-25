/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.StringBuilder;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.regex.Pattern;

public class JsonWriter
extends Writer {
    final Writer writer;
    private final Array<JsonObject> stack = new Array();
    private JsonObject current;
    private boolean named;
    private OutputType outputType = OutputType.json;
    private boolean quoteLongValues = false;

    public JsonWriter(Writer writer) {
        this.writer = writer;
    }

    public Writer getWriter() {
        return this.writer;
    }

    public void setOutputType(OutputType outputType) {
        this.outputType = outputType;
    }

    public void setQuoteLongValues(boolean bl2) {
        this.quoteLongValues = bl2;
    }

    public JsonWriter name(String string) {
        if (this.current == null || this.current.array) {
            throw new IllegalStateException("Current item must be an object.");
        }
        if (!this.current.needsComma) {
            this.current.needsComma = true;
        } else {
            this.writer.write(44);
        }
        this.writer.write(this.outputType.quoteName(string));
        this.writer.write(58);
        this.named = true;
        return this;
    }

    public JsonWriter object() {
        this.requireCommaOrName();
        this.current = new JsonObject(false);
        this.stack.add(this.current);
        return this;
    }

    public JsonWriter array() {
        this.requireCommaOrName();
        this.current = new JsonObject(true);
        this.stack.add(this.current);
        return this;
    }

    public JsonWriter value(Object object) {
        if (this.quoteLongValues && (object instanceof Long || object instanceof Double || object instanceof BigDecimal || object instanceof BigInteger)) {
            object = object.toString();
        } else if (object instanceof Number) {
            Number number = (Number)object;
            long l2 = number.longValue();
            if (number.doubleValue() == (double)l2) {
                object = l2;
            }
        }
        this.requireCommaOrName();
        this.writer.write(this.outputType.quoteValue(object));
        return this;
    }

    public JsonWriter json(String string) {
        this.requireCommaOrName();
        this.writer.write(string);
        return this;
    }

    private void requireCommaOrName() {
        if (this.current == null) {
            return;
        }
        if (this.current.array) {
            if (!this.current.needsComma) {
                this.current.needsComma = true;
            } else {
                this.writer.write(44);
            }
        } else {
            if (!this.named) {
                throw new IllegalStateException("Name must be set.");
            }
            this.named = false;
        }
    }

    public JsonWriter object(String string) {
        return this.name(string).object();
    }

    public JsonWriter array(String string) {
        return this.name(string).array();
    }

    public JsonWriter set(String string, Object object) {
        return this.name(string).value(object);
    }

    public JsonWriter json(String string, String string2) {
        return this.name(string).json(string2);
    }

    public JsonWriter pop() {
        if (this.named) {
            throw new IllegalStateException("Expected an object, array, or value since a name was set.");
        }
        this.stack.pop().close();
        this.current = this.stack.size == 0 ? null : this.stack.peek();
        return this;
    }

    @Override
    public void write(char[] cArray, int n2, int n3) {
        this.writer.write(cArray, n2, n3);
    }

    @Override
    public void flush() {
        this.writer.flush();
    }

    @Override
    public void close() {
        while (this.stack.size > 0) {
            this.pop();
        }
        this.writer.close();
    }

    public static enum OutputType {
        json,
        javascript,
        minimal;

        private static Pattern javascriptPattern;
        private static Pattern minimalNamePattern;
        private static Pattern minimalValuePattern;

        public String quoteValue(Object object) {
            int n2;
            if (object == null) {
                return "null";
            }
            String string = object.toString();
            if (object instanceof Number || object instanceof Boolean) {
                return string;
            }
            StringBuilder stringBuilder = new StringBuilder(string);
            stringBuilder.replace('\\', "\\\\").replace('\r', "\\r").replace('\n', "\\n").replace('\t', "\\t");
            if (!(this != minimal || string.equals("true") || string.equals("false") || string.equals("null") || string.contains("//") || string.contains("/*") || (n2 = stringBuilder.length()) <= 0 || stringBuilder.charAt(n2 - 1) == ' ' || !minimalValuePattern.matcher(stringBuilder).matches())) {
                return stringBuilder.toString();
            }
            return '\"' + stringBuilder.replace('\"', "\\\"").toString() + '\"';
        }

        public String quoteName(String string) {
            StringBuilder stringBuilder = new StringBuilder(string);
            stringBuilder.replace('\\', "\\\\").replace('\r', "\\r").replace('\n', "\\n").replace('\t', "\\t");
            switch (this) {
                case minimal: {
                    if (!string.contains("//") && !string.contains("/*") && minimalNamePattern.matcher(stringBuilder).matches()) {
                        return stringBuilder.toString();
                    }
                }
                case javascript: {
                    if (!javascriptPattern.matcher(stringBuilder).matches()) break;
                    return stringBuilder.toString();
                }
            }
            return '\"' + stringBuilder.replace('\"', "\\\"").toString() + '\"';
        }

        static {
            javascriptPattern = Pattern.compile("^[a-zA-Z_$][a-zA-Z_$0-9]*$");
            minimalNamePattern = Pattern.compile("^[^\":,}/ ][^:]*$");
            minimalValuePattern = Pattern.compile("^[^\":,{\\[\\]/ ][^}\\],]*$");
        }
    }

    class JsonObject {
        final boolean array;
        boolean needsComma;

        JsonObject(boolean bl2) {
            this.array = bl2;
            JsonWriter.this.writer.write(bl2 ? 91 : 123);
        }

        void close() {
            JsonWriter.this.writer.write(this.array ? 93 : 125);
        }
    }
}

