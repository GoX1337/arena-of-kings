/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.Null;
import com.badlogic.gdx.utils.ObjectMap;
import com.badlogic.gdx.utils.SerializationException;
import com.badlogic.gdx.utils.StreamUtils;
import com.badlogic.gdx.utils.StringBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class XmlReader {
    private final Array<Element> elements = new Array(8);
    private Element root;
    private Element current;
    private final StringBuilder textBuffer = new StringBuilder(64);
    private String entitiesText;
    private static final byte[] _xml_actions = XmlReader.init__xml_actions_0();
    private static final byte[] _xml_key_offsets = XmlReader.init__xml_key_offsets_0();
    private static final char[] _xml_trans_keys = XmlReader.init__xml_trans_keys_0();
    private static final byte[] _xml_single_lengths = XmlReader.init__xml_single_lengths_0();
    private static final byte[] _xml_range_lengths = XmlReader.init__xml_range_lengths_0();
    private static final short[] _xml_index_offsets = XmlReader.init__xml_index_offsets_0();
    private static final byte[] _xml_indicies = XmlReader.init__xml_indicies_0();
    private static final byte[] _xml_trans_targs = XmlReader.init__xml_trans_targs_0();
    private static final byte[] _xml_trans_actions = XmlReader.init__xml_trans_actions_0();
    static final int xml_start = 1;
    static final int xml_first_final = 34;
    static final int xml_error = 0;
    static final int xml_en_elementBody = 15;
    static final int xml_en_main = 1;

    public Element parse(String string) {
        char[] cArray = string.toCharArray();
        return this.parse(cArray, 0, cArray.length);
    }

    public Element parse(Reader reader) {
        try {
            int n2;
            char[] cArray = new char[1024];
            int n3 = 0;
            while ((n2 = reader.read(cArray, n3, cArray.length - n3)) != -1) {
                if (n2 == 0) {
                    char[] cArray2 = new char[cArray.length * 2];
                    System.arraycopy(cArray, 0, cArray2, 0, cArray.length);
                    cArray = cArray2;
                    continue;
                }
                n3 += n2;
            }
            Element element = this.parse(cArray, 0, n3);
            return element;
        }
        catch (IOException iOException) {
            throw new SerializationException(iOException);
        }
        finally {
            StreamUtils.closeQuietly(reader);
        }
    }

    public Element parse(InputStream inputStream) {
        try {
            Element element = this.parse(new InputStreamReader(inputStream, "UTF-8"));
            return element;
        }
        catch (IOException iOException) {
            throw new SerializationException(iOException);
        }
        finally {
            StreamUtils.closeQuietly(inputStream);
        }
    }

    public Element parse(FileHandle fileHandle) {
        try {
            return this.parse(fileHandle.reader("UTF-8"));
        }
        catch (Exception exception) {
            throw new SerializationException("Error parsing file: " + fileHandle, exception);
        }
    }

    /*
     * Unable to fully structure code
     */
    public Element parse(char[] var1_1, int var2_2, int var3_3) {
        var5_4 = var2_2;
        var6_5 = var3_3;
        var7_6 = 0;
        var8_7 = null;
        var9_8 = false;
        var4_9 = 1;
        var11_10 = 0;
        var15_11 = 0;
        block19: while (true) {
            switch (var15_11) {
                case 0: {
                    if (var5_4 == var6_5) {
                        var15_11 = 4;
                        continue block19;
                    }
                    if (var4_9 == 0) {
                        var15_11 = 5;
                        continue block19;
                    }
                }
                case 1: {
                    var14_17 = XmlReader._xml_key_offsets[var4_9];
                    var11_10 = XmlReader._xml_index_offsets[var4_9];
                    var10_12 = XmlReader._xml_single_lengths[var4_9];
                    if (var10_12 <= 0) ** GOTO lbl37
                    var16_18 = var14_17;
                    var18_20 = var14_17 + var10_12 - 1;
                    while (var18_20 >= var16_18) {
                        var17_19 = var16_18 + (var18_20 - var16_18 >> 1);
                        if (var1_1[var5_4] < XmlReader._xml_trans_keys[var17_19]) {
                            var18_20 = var17_19 - 1;
                            continue;
                        }
                        if (var1_1[var5_4] > XmlReader._xml_trans_keys[var17_19]) {
                            var16_18 = var17_19 + 1;
                            continue;
                        }
                        var11_10 += var17_19 - var14_17;
                        ** GOTO lbl51
                    }
                    var14_17 += var10_12;
                    var11_10 += var10_12;
lbl37:
                    // 2 sources

                    if ((var10_12 = XmlReader._xml_range_lengths[var4_9]) > 0) {
                        var16_18 = var14_17;
                        var18_20 = var14_17 + (var10_12 << 1) - 2;
                        while (var18_20 >= var16_18) {
                            var17_19 = var16_18 + (var18_20 - var16_18 >> 1 & -2);
                            if (var1_1[var5_4] < XmlReader._xml_trans_keys[var17_19]) {
                                var18_20 = var17_19 - 2;
                                continue;
                            }
                            if (var1_1[var5_4] > XmlReader._xml_trans_keys[var17_19 + 1]) {
                                var16_18 = var17_19 + 2;
                                continue;
                            }
                            var11_10 += var17_19 - var14_17 >> 1;
                            ** GOTO lbl51
                        }
                        var11_10 += var10_12;
                    }
lbl51:
                    // 5 sources

                    var11_10 = XmlReader._xml_indicies[var11_10];
                    var4_9 = XmlReader._xml_trans_targs[var11_10];
                    if (XmlReader._xml_trans_actions[var11_10] != 0) {
                        var12_15 = XmlReader._xml_trans_actions[var11_10];
                        var13_16 = XmlReader._xml_actions[var12_15++];
                        while (var13_16-- > 0) {
                            switch (XmlReader._xml_actions[var12_15++]) {
                                case 0: {
                                    var7_6 = var5_4;
                                    break;
                                }
                                case 1: {
                                    var16_18 = var1_1[var7_6];
                                    if (var16_18 == 63 || var16_18 == 33) {
                                        if (var1_1[var7_6 + 1] == '[' && var1_1[var7_6 + 2] == 'C' && var1_1[var7_6 + 3] == 'D' && var1_1[var7_6 + 4] == 'A' && var1_1[var7_6 + 5] == 'T' && var1_1[var7_6 + 6] == 'A' && var1_1[var7_6 + 7] == '[') {
                                            var5_4 = (var7_6 += 8) + 2;
                                            while (var1_1[var5_4 - 2] != ']' || var1_1[var5_4 - 1] != ']' || var1_1[var5_4] != '>') {
                                                ++var5_4;
                                            }
                                            this.text(new String(var1_1, var7_6, var5_4 - var7_6 - 2));
                                        } else if (var16_18 == 33 && var1_1[var7_6 + 1] == '-' && var1_1[var7_6 + 2] == '-') {
                                            var5_4 = var7_6 + 3;
                                            while (var1_1[var5_4] != '-' || var1_1[var5_4 + 1] != '-' || var1_1[var5_4 + 2] != '>') {
                                                ++var5_4;
                                            }
                                            var5_4 += 2;
                                        } else {
                                            while (var1_1[var5_4] != '>') {
                                                ++var5_4;
                                            }
                                        }
                                        var4_9 = 15;
                                        var15_11 = 2;
                                        continue block19;
                                    }
                                    var9_8 = true;
                                    this.open(new String(var1_1, var7_6, var5_4 - var7_6));
                                    break;
                                }
                                case 2: {
                                    var9_8 = false;
                                    this.close();
                                    var4_9 = 15;
                                    var15_11 = 2;
                                    continue block19;
                                }
                                case 3: {
                                    this.close();
                                    var4_9 = 15;
                                    var15_11 = 2;
                                    continue block19;
                                }
                                case 4: {
                                    if (!var9_8) break;
                                    var4_9 = 15;
                                    var15_11 = 2;
                                    continue block19;
                                }
                                case 5: {
                                    var8_7 = new String(var1_1, var7_6, var5_4 - var7_6);
                                    break;
                                }
                                case 6: {
                                    block26: for (var16_18 = var5_4; var16_18 != var7_6; --var16_18) {
                                        switch (var1_1[var16_18 - 1]) {
                                            case '\t': 
                                            case '\n': 
                                            case '\r': 
                                            case ' ': {
                                                continue block26;
                                            }
                                        }
                                    }
                                    var17_19 = var7_6;
                                    var18_20 = 0;
                                    block27: while (var17_19 != var16_18) {
                                        if (var1_1[var17_19++] != '&') continue;
                                        var19_21 = var17_19;
                                        while (var17_19 != var16_18) {
                                            if (var1_1[var17_19++] != ';') continue;
                                            this.textBuffer.append(var1_1, var7_6, var19_21 - var7_6 - 1);
                                            var20_22 = new String(var1_1, var19_21, var17_19 - var19_21 - 1);
                                            var21_23 = this.entity(var20_22);
                                            this.textBuffer.append(var21_23 != null ? var21_23 : var20_22);
                                            var7_6 = var17_19;
                                            var18_20 = 1;
                                            continue block27;
                                        }
                                    }
                                    if (var18_20 != 0) {
                                        if (var7_6 < var16_18) {
                                            this.textBuffer.append(var1_1, var7_6, var16_18 - var7_6);
                                        }
                                        this.entitiesText = this.textBuffer.toString();
                                        this.textBuffer.setLength(0);
                                        break;
                                    }
                                    this.entitiesText = new String(var1_1, var7_6, var16_18 - var7_6);
                                    break;
                                }
                                case 7: {
                                    this.attribute(var8_7, this.entitiesText);
                                    break;
                                }
                                case 8: {
                                    this.text(this.entitiesText);
                                }
                            }
                        }
                    }
                }
                case 2: {
                    if (var4_9 == 0) {
                        var15_11 = 5;
                        continue block19;
                    }
                    if (++var5_4 == var6_5) break block19;
                    var15_11 = 1;
                    continue block19;
                }
            }
            break;
        }
        this.entitiesText = null;
        if (var5_4 < var6_5) {
            var10_12 = 1;
            for (var11_10 = 0; var11_10 < var5_4; ++var11_10) {
                if (var1_1[var11_10] != '\n') continue;
                ++var10_12;
            }
            throw new SerializationException("Error parsing XML on line " + var10_12 + " near: " + new String(var1_1, var5_4, Math.min(32, var6_5 - var5_4)));
        }
        if (this.elements.size != 0) {
            var10_13 = this.elements.peek();
            this.elements.clear();
            throw new SerializationException("Error parsing XML, unclosed element: " + var10_13.getName());
        }
        var10_14 = this.root;
        this.root = null;
        return var10_14;
    }

    private static byte[] init__xml_actions_0() {
        return new byte[]{0, 1, 0, 1, 1, 1, 2, 1, 3, 1, 4, 1, 5, 2, 1, 4, 2, 2, 4, 2, 6, 7, 2, 6, 8, 3, 0, 6, 7};
    }

    private static byte[] init__xml_key_offsets_0() {
        return new byte[]{0, 0, 4, 9, 14, 20, 26, 30, 35, 36, 37, 42, 46, 50, 51, 52, 56, 57, 62, 67, 73, 79, 83, 88, 89, 90, 95, 99, 103, 104, 108, 109, 110, 111, 112, 115};
    }

    private static char[] init__xml_trans_keys_0() {
        return new char[]{' ', '<', '\t', '\r', ' ', '/', '>', '\t', '\r', ' ', '/', '>', '\t', '\r', ' ', '/', '=', '>', '\t', '\r', ' ', '/', '=', '>', '\t', '\r', ' ', '=', '\t', '\r', ' ', '\"', '\'', '\t', '\r', '\"', '\"', ' ', '/', '>', '\t', '\r', ' ', '>', '\t', '\r', ' ', '>', '\t', '\r', '\'', '\'', ' ', '<', '\t', '\r', '<', ' ', '/', '>', '\t', '\r', ' ', '/', '>', '\t', '\r', ' ', '/', '=', '>', '\t', '\r', ' ', '/', '=', '>', '\t', '\r', ' ', '=', '\t', '\r', ' ', '\"', '\'', '\t', '\r', '\"', '\"', ' ', '/', '>', '\t', '\r', ' ', '>', '\t', '\r', ' ', '>', '\t', '\r', '<', ' ', '/', '\t', '\r', '>', '>', '\'', '\'', ' ', '\t', '\r', '\u0000'};
    }

    private static byte[] init__xml_single_lengths_0() {
        return new byte[]{0, 2, 3, 3, 4, 4, 2, 3, 1, 1, 3, 2, 2, 1, 1, 2, 1, 3, 3, 4, 4, 2, 3, 1, 1, 3, 2, 2, 1, 2, 1, 1, 1, 1, 1, 0};
    }

    private static byte[] init__xml_range_lengths_0() {
        return new byte[]{0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 1, 0};
    }

    private static short[] init__xml_index_offsets_0() {
        return new short[]{0, 0, 4, 9, 14, 20, 26, 30, 35, 37, 39, 44, 48, 52, 54, 56, 60, 62, 67, 72, 78, 84, 88, 93, 95, 97, 102, 106, 110, 112, 116, 118, 120, 122, 124, 127};
    }

    private static byte[] init__xml_indicies_0() {
        return new byte[]{0, 2, 0, 1, 2, 1, 1, 2, 3, 5, 6, 7, 5, 4, 9, 10, 1, 11, 9, 8, 13, 1, 14, 1, 13, 12, 15, 16, 15, 1, 16, 17, 18, 16, 1, 20, 19, 22, 21, 9, 10, 11, 9, 1, 23, 24, 23, 1, 25, 11, 25, 1, 20, 26, 22, 27, 29, 30, 29, 28, 32, 31, 30, 34, 1, 30, 33, 36, 37, 38, 36, 35, 40, 41, 1, 42, 40, 39, 44, 1, 45, 1, 44, 43, 46, 47, 46, 1, 47, 48, 49, 47, 1, 51, 50, 53, 52, 40, 41, 42, 40, 1, 54, 55, 54, 1, 56, 42, 56, 1, 57, 1, 57, 34, 57, 1, 1, 58, 59, 58, 51, 60, 53, 61, 62, 62, 1, 1, 0};
    }

    private static byte[] init__xml_trans_targs_0() {
        return new byte[]{1, 0, 2, 3, 3, 4, 11, 34, 5, 4, 11, 34, 5, 6, 7, 6, 7, 8, 13, 9, 10, 9, 10, 12, 34, 12, 14, 14, 16, 15, 17, 16, 17, 18, 30, 18, 19, 26, 28, 20, 19, 26, 28, 20, 21, 22, 21, 22, 23, 32, 24, 25, 24, 25, 27, 28, 27, 29, 31, 35, 33, 33, 34};
    }

    private static byte[] init__xml_trans_actions_0() {
        return new byte[]{0, 0, 0, 1, 0, 3, 3, 13, 1, 0, 0, 9, 0, 11, 11, 0, 0, 0, 0, 1, 25, 0, 19, 5, 16, 0, 1, 0, 1, 0, 0, 0, 22, 1, 0, 0, 3, 3, 13, 1, 0, 0, 9, 0, 11, 11, 0, 0, 0, 0, 1, 25, 0, 19, 5, 16, 0, 0, 0, 7, 1, 0, 0};
    }

    protected void open(String string) {
        Element element = new Element(string, this.current);
        Element element2 = this.current;
        if (element2 != null) {
            element2.addChild(element);
        }
        this.elements.add(element);
        this.current = element;
    }

    protected void attribute(String string, String string2) {
        this.current.setAttribute(string, string2);
    }

    @Null
    protected String entity(String string) {
        if (string.equals("lt")) {
            return "<";
        }
        if (string.equals("gt")) {
            return ">";
        }
        if (string.equals("amp")) {
            return "&";
        }
        if (string.equals("apos")) {
            return "'";
        }
        if (string.equals("quot")) {
            return "\"";
        }
        if (string.startsWith("#x")) {
            return Character.toString((char)Integer.parseInt(string.substring(2), 16));
        }
        return null;
    }

    protected void text(String string) {
        String string2 = this.current.getText();
        this.current.setText(string2 != null ? string2 + string : string);
    }

    protected void close() {
        this.root = this.elements.pop();
        this.current = this.elements.size > 0 ? this.elements.peek() : null;
    }

    public static class Element {
        private final String name;
        private ObjectMap<String, String> attributes;
        private Array<Element> children;
        private String text;
        private Element parent;

        public Element(String string, Element element) {
            this.name = string;
            this.parent = element;
        }

        public String getName() {
            return this.name;
        }

        public ObjectMap<String, String> getAttributes() {
            return this.attributes;
        }

        public String getAttribute(String string) {
            if (this.attributes == null) {
                throw new GdxRuntimeException("Element " + this.name + " doesn't have attribute: " + string);
            }
            String string2 = this.attributes.get(string);
            if (string2 == null) {
                throw new GdxRuntimeException("Element " + this.name + " doesn't have attribute: " + string);
            }
            return string2;
        }

        public String getAttribute(String string, String string2) {
            if (this.attributes == null) {
                return string2;
            }
            String string3 = this.attributes.get(string);
            if (string3 == null) {
                return string2;
            }
            return string3;
        }

        public boolean hasAttribute(String string) {
            if (this.attributes == null) {
                return false;
            }
            return this.attributes.containsKey(string);
        }

        public void setAttribute(String string, String string2) {
            if (this.attributes == null) {
                this.attributes = new ObjectMap(8);
            }
            this.attributes.put(string, string2);
        }

        public int getChildCount() {
            if (this.children == null) {
                return 0;
            }
            return this.children.size;
        }

        public Element getChild(int n2) {
            if (this.children == null) {
                throw new GdxRuntimeException("Element has no children: " + this.name);
            }
            return this.children.get(n2);
        }

        public void addChild(Element element) {
            if (this.children == null) {
                this.children = new Array(8);
            }
            this.children.add(element);
        }

        public String getText() {
            return this.text;
        }

        public void setText(String string) {
            this.text = string;
        }

        public void removeChild(int n2) {
            if (this.children != null) {
                this.children.removeIndex(n2);
            }
        }

        public void removeChild(Element element) {
            if (this.children != null) {
                this.children.removeValue(element, true);
            }
        }

        public void remove() {
            this.parent.removeChild(this);
        }

        public Element getParent() {
            return this.parent;
        }

        public String toString() {
            return this.toString("");
        }

        public String toString(String string) {
            StringBuilder stringBuilder = new StringBuilder(128);
            stringBuilder.append(string);
            stringBuilder.append('<');
            stringBuilder.append(this.name);
            if (this.attributes != null) {
                for (ObjectMap.Entry object : this.attributes.entries()) {
                    stringBuilder.append(' ');
                    stringBuilder.append((String)object.key);
                    stringBuilder.append("=\"");
                    stringBuilder.append((String)object.value);
                    stringBuilder.append('\"');
                }
            }
            if (this.children == null && (this.text == null || this.text.length() == 0)) {
                stringBuilder.append("/>");
            } else {
                stringBuilder.append(">\n");
                String string2 = string + '\t';
                if (this.text != null && this.text.length() > 0) {
                    stringBuilder.append(string2);
                    stringBuilder.append(this.text);
                    stringBuilder.append('\n');
                }
                if (this.children != null) {
                    for (Element element : this.children) {
                        stringBuilder.append(element.toString(string2));
                        stringBuilder.append('\n');
                    }
                }
                stringBuilder.append(string);
                stringBuilder.append("</");
                stringBuilder.append(this.name);
                stringBuilder.append('>');
            }
            return stringBuilder.toString();
        }

        @Null
        public Element getChildByName(String string) {
            if (this.children == null) {
                return null;
            }
            for (int i2 = 0; i2 < this.children.size; ++i2) {
                Element element = this.children.get(i2);
                if (!element.name.equals(string)) continue;
                return element;
            }
            return null;
        }

        public boolean hasChild(String string) {
            if (this.children == null) {
                return false;
            }
            return this.getChildByName(string) != null;
        }

        @Null
        public Element getChildByNameRecursive(String string) {
            if (this.children == null) {
                return null;
            }
            for (int i2 = 0; i2 < this.children.size; ++i2) {
                Element element = this.children.get(i2);
                if (element.name.equals(string)) {
                    return element;
                }
                Element element2 = element.getChildByNameRecursive(string);
                if (element2 == null) continue;
                return element2;
            }
            return null;
        }

        public boolean hasChildRecursive(String string) {
            if (this.children == null) {
                return false;
            }
            return this.getChildByNameRecursive(string) != null;
        }

        public Array<Element> getChildrenByName(String string) {
            Array<Element> array = new Array<Element>();
            if (this.children == null) {
                return array;
            }
            for (int i2 = 0; i2 < this.children.size; ++i2) {
                Element element = this.children.get(i2);
                if (!element.name.equals(string)) continue;
                array.add(element);
            }
            return array;
        }

        public Array<Element> getChildrenByNameRecursively(String string) {
            Array<Element> array = new Array<Element>();
            this.getChildrenByNameRecursively(string, array);
            return array;
        }

        private void getChildrenByNameRecursively(String string, Array<Element> array) {
            if (this.children == null) {
                return;
            }
            for (int i2 = 0; i2 < this.children.size; ++i2) {
                Element element = this.children.get(i2);
                if (element.name.equals(string)) {
                    array.add(element);
                }
                element.getChildrenByNameRecursively(string, array);
            }
        }

        public float getFloatAttribute(String string) {
            return Float.parseFloat(this.getAttribute(string));
        }

        public float getFloatAttribute(String string, float f2) {
            String string2 = this.getAttribute(string, null);
            if (string2 == null) {
                return f2;
            }
            return Float.parseFloat(string2);
        }

        public int getIntAttribute(String string) {
            return Integer.parseInt(this.getAttribute(string));
        }

        public int getIntAttribute(String string, int n2) {
            String string2 = this.getAttribute(string, null);
            if (string2 == null) {
                return n2;
            }
            return Integer.parseInt(string2);
        }

        public boolean getBooleanAttribute(String string) {
            return Boolean.parseBoolean(this.getAttribute(string));
        }

        public boolean getBooleanAttribute(String string, boolean bl2) {
            String string2 = this.getAttribute(string, null);
            if (string2 == null) {
                return bl2;
            }
            return Boolean.parseBoolean(string2);
        }

        public String get(String string) {
            String string2 = this.get(string, null);
            if (string2 == null) {
                throw new GdxRuntimeException("Element " + this.name + " doesn't have attribute or child: " + string);
            }
            return string2;
        }

        public String get(String string, String string2) {
            Object object;
            if (this.attributes != null && (object = this.attributes.get(string)) != null) {
                return object;
            }
            object = this.getChildByName(string);
            if (object == null) {
                return string2;
            }
            String string3 = ((Element)object).getText();
            if (string3 == null) {
                return string2;
            }
            return string3;
        }

        public int getInt(String string) {
            String string2 = this.get(string, null);
            if (string2 == null) {
                throw new GdxRuntimeException("Element " + this.name + " doesn't have attribute or child: " + string);
            }
            return Integer.parseInt(string2);
        }

        public int getInt(String string, int n2) {
            String string2 = this.get(string, null);
            if (string2 == null) {
                return n2;
            }
            return Integer.parseInt(string2);
        }

        public float getFloat(String string) {
            String string2 = this.get(string, null);
            if (string2 == null) {
                throw new GdxRuntimeException("Element " + this.name + " doesn't have attribute or child: " + string);
            }
            return Float.parseFloat(string2);
        }

        public float getFloat(String string, float f2) {
            String string2 = this.get(string, null);
            if (string2 == null) {
                return f2;
            }
            return Float.parseFloat(string2);
        }

        public boolean getBoolean(String string) {
            String string2 = this.get(string, null);
            if (string2 == null) {
                throw new GdxRuntimeException("Element " + this.name + " doesn't have attribute or child: " + string);
            }
            return Boolean.parseBoolean(string2);
        }

        public boolean getBoolean(String string, boolean bl2) {
            String string2 = this.get(string, null);
            if (string2 == null) {
                return bl2;
            }
            return Boolean.parseBoolean(string2);
        }
    }
}

