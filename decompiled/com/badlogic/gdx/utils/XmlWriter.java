/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils;

import com.badlogic.gdx.utils.Array;
import java.io.Writer;

public class XmlWriter
extends Writer {
    private final Writer writer;
    private final Array<String> stack = new Array();
    private String currentElement;
    private boolean indentNextClose;
    public int indent;

    public XmlWriter(Writer writer) {
        this.writer = writer;
    }

    private void indent() {
        int n2 = this.indent;
        if (this.currentElement != null) {
            ++n2;
        }
        for (int i2 = 0; i2 < n2; ++i2) {
            this.writer.write(9);
        }
    }

    public XmlWriter element(String string) {
        if (this.startElementContent()) {
            this.writer.write(10);
        }
        this.indent();
        this.writer.write(60);
        this.writer.write(string);
        this.currentElement = string;
        return this;
    }

    public XmlWriter element(String string, Object object) {
        return this.element(string).text(object).pop();
    }

    private boolean startElementContent() {
        if (this.currentElement == null) {
            return false;
        }
        ++this.indent;
        this.stack.add(this.currentElement);
        this.currentElement = null;
        this.writer.write(">");
        return true;
    }

    public XmlWriter attribute(String string, Object object) {
        if (this.currentElement == null) {
            throw new IllegalStateException();
        }
        this.writer.write(32);
        this.writer.write(string);
        this.writer.write("=\"");
        this.writer.write(object == null ? "null" : object.toString());
        this.writer.write(34);
        return this;
    }

    public XmlWriter text(Object object) {
        this.startElementContent();
        String string = object == null ? "null" : object.toString();
        boolean bl2 = this.indentNextClose = string.length() > 64;
        if (this.indentNextClose) {
            this.writer.write(10);
            this.indent();
        }
        this.writer.write(string);
        if (this.indentNextClose) {
            this.writer.write(10);
        }
        return this;
    }

    public XmlWriter pop() {
        if (this.currentElement != null) {
            this.writer.write("/>\n");
            this.currentElement = null;
        } else {
            this.indent = Math.max(this.indent - 1, 0);
            if (this.indentNextClose) {
                this.indent();
            }
            this.writer.write("</");
            this.writer.write(this.stack.pop());
            this.writer.write(">\n");
        }
        this.indentNextClose = true;
        return this;
    }

    @Override
    public void close() {
        while (this.stack.size != 0) {
            this.pop();
        }
        this.writer.close();
    }

    @Override
    public void write(char[] cArray, int n2, int n3) {
        this.startElementContent();
        this.writer.write(cArray, n2, n3);
    }

    @Override
    public void flush() {
        this.writer.flush();
    }
}

