/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.asm;

import com.esotericsoftware.asm.AnnotationVisitor;
import com.esotericsoftware.asm.Attribute;
import com.esotericsoftware.asm.ByteVector;
import com.esotericsoftware.asm.ClassVisitor;
import com.esotericsoftware.asm.ClassWriter;
import com.esotericsoftware.asm.Context;
import com.esotericsoftware.asm.FieldVisitor;
import com.esotericsoftware.asm.Handle;
import com.esotericsoftware.asm.Item;
import com.esotericsoftware.asm.Label;
import com.esotericsoftware.asm.MethodVisitor;
import com.esotericsoftware.asm.MethodWriter;
import com.esotericsoftware.asm.Opcodes;
import com.esotericsoftware.asm.Type;
import com.esotericsoftware.asm.TypePath;
import java.io.IOException;
import java.io.InputStream;

public class ClassReader {
    public static final int SKIP_CODE = 1;
    public static final int SKIP_DEBUG = 2;
    public static final int SKIP_FRAMES = 4;
    public static final int EXPAND_FRAMES = 8;
    public final byte[] b;
    private final int[] a;
    private final String[] c;
    private final int d;
    public final int header;

    public ClassReader(byte[] byArray) {
        this(byArray, 0, byArray.length);
    }

    public ClassReader(byte[] byArray, int n2, int n3) {
        this.b = byArray;
        if (this.readShort(n2 + 6) > 52) {
            throw new IllegalArgumentException();
        }
        this.a = new int[this.readUnsignedShort(n2 + 8)];
        int n4 = this.a.length;
        this.c = new String[n4];
        int n5 = 0;
        int n6 = n2 + 10;
        for (int i2 = 1; i2 < n4; ++i2) {
            int n7;
            this.a[i2] = n6 + 1;
            switch (byArray[n6]) {
                case 3: 
                case 4: 
                case 9: 
                case 10: 
                case 11: 
                case 12: 
                case 18: {
                    n7 = 5;
                    break;
                }
                case 5: 
                case 6: {
                    n7 = 9;
                    ++i2;
                    break;
                }
                case 1: {
                    n7 = 3 + this.readUnsignedShort(n6 + 1);
                    if (n7 <= n5) break;
                    n5 = n7;
                    break;
                }
                case 15: {
                    n7 = 4;
                    break;
                }
                default: {
                    n7 = 3;
                }
            }
            n6 += n7;
        }
        this.d = n5;
        this.header = n6;
    }

    public int getAccess() {
        return this.readUnsignedShort(this.header);
    }

    public String getClassName() {
        return this.readClass(this.header + 2, new char[this.d]);
    }

    public String getSuperName() {
        return this.readClass(this.header + 4, new char[this.d]);
    }

    public String[] getInterfaces() {
        int n2 = this.header + 6;
        int n3 = this.readUnsignedShort(n2);
        String[] stringArray = new String[n3];
        if (n3 > 0) {
            char[] cArray = new char[this.d];
            for (int i2 = 0; i2 < n3; ++i2) {
                stringArray[i2] = this.readClass(n2 += 2, cArray);
            }
        }
        return stringArray;
    }

    void a(ClassWriter classWriter) {
        int n2;
        char[] cArray = new char[this.d];
        int n3 = this.a.length;
        Item[] itemArray = new Item[n3];
        for (n2 = 1; n2 < n3; ++n2) {
            int n4;
            int n5 = this.a[n2];
            byte by2 = this.b[n5 - 1];
            Item item = new Item(n2);
            switch (by2) {
                case 9: 
                case 10: 
                case 11: {
                    int n6 = this.a[this.readUnsignedShort(n5 + 2)];
                    item.a(by2, this.readClass(n5, cArray), this.readUTF8(n6, cArray), this.readUTF8(n6 + 2, cArray));
                    break;
                }
                case 3: {
                    item.a(this.readInt(n5));
                    break;
                }
                case 4: {
                    item.a(Float.intBitsToFloat(this.readInt(n5)));
                    break;
                }
                case 12: {
                    item.a(by2, this.readUTF8(n5, cArray), this.readUTF8(n5 + 2, cArray), null);
                    break;
                }
                case 5: {
                    item.a(this.readLong(n5));
                    ++n2;
                    break;
                }
                case 6: {
                    item.a(Double.longBitsToDouble(this.readLong(n5)));
                    ++n2;
                    break;
                }
                case 1: {
                    String string = this.c[n2];
                    if (string == null) {
                        n5 = this.a[n2];
                        string = this.c[n2] = this.a(n5 + 2, this.readUnsignedShort(n5), cArray);
                    }
                    item.a(by2, string, null, null);
                    break;
                }
                case 15: {
                    n4 = this.a[this.readUnsignedShort(n5 + 1)];
                    int n6 = this.a[this.readUnsignedShort(n4 + 2)];
                    item.a(20 + this.readByte(n5), this.readClass(n4, cArray), this.readUTF8(n6, cArray), this.readUTF8(n6 + 2, cArray));
                    break;
                }
                case 18: {
                    if (classWriter.A == null) {
                        this.a(classWriter, itemArray, cArray);
                    }
                    int n6 = this.a[this.readUnsignedShort(n5 + 2)];
                    item.a(this.readUTF8(n6, cArray), this.readUTF8(n6 + 2, cArray), this.readUnsignedShort(n5));
                    break;
                }
                default: {
                    item.a(by2, this.readUTF8(n5, cArray), null, null);
                }
            }
            n4 = item.j % itemArray.length;
            item.k = itemArray[n4];
            itemArray[n4] = item;
        }
        n2 = this.a[1] - 1;
        classWriter.d.putByteArray(this.b, n2, this.header - n2);
        classWriter.e = itemArray;
        classWriter.f = (int)(0.75 * (double)n3);
        classWriter.c = n3;
    }

    private void a(ClassWriter classWriter, Item[] itemArray, char[] cArray) {
        int n2;
        int n3;
        int n4 = this.a();
        boolean bl2 = false;
        for (n3 = this.readUnsignedShort(n4); n3 > 0; --n3) {
            String string = this.readUTF8(n4 + 2, cArray);
            if ("BootstrapMethods".equals(string)) {
                bl2 = true;
                break;
            }
            n4 += 6 + this.readInt(n4 + 4);
        }
        if (!bl2) {
            return;
        }
        n3 = this.readUnsignedShort(n4 + 8);
        int n5 = n4 + 10;
        for (n2 = 0; n2 < n3; ++n2) {
            int n6 = n5 - n4 - 10;
            int n7 = this.readConst(this.readUnsignedShort(n5), cArray).hashCode();
            for (int i2 = this.readUnsignedShort(n5 + 2); i2 > 0; --i2) {
                n7 ^= this.readConst(this.readUnsignedShort(n5 + 4), cArray).hashCode();
                n5 += 2;
            }
            n5 += 4;
            Item item = new Item(n2);
            item.a(n6, n7 & Integer.MAX_VALUE);
            int n8 = item.j % itemArray.length;
            item.k = itemArray[n8];
            itemArray[n8] = item;
        }
        n2 = this.readInt(n4 + 4);
        ByteVector byteVector = new ByteVector(n2 + 62);
        byteVector.putByteArray(this.b, n4 + 10, n2 - 2);
        classWriter.z = n3;
        classWriter.A = byteVector;
    }

    public ClassReader(InputStream inputStream) {
        this(ClassReader.a(inputStream, false));
    }

    public ClassReader(String string) {
        this(ClassReader.a(ClassLoader.getSystemResourceAsStream(string.replace('.', '/') + ".class"), true));
    }

    private static byte[] a(InputStream inputStream, boolean bl2) {
        if (inputStream == null) {
            throw new IOException("Class not found");
        }
        try {
            byte[] byArray = new byte[inputStream.available()];
            int n2 = 0;
            while (true) {
                byte[] byArray2;
                int n3;
                if ((n3 = inputStream.read(byArray, n2, byArray.length - n2)) == -1) {
                    byte[] byArray3;
                    if (n2 < byArray.length) {
                        byArray3 = new byte[n2];
                        System.arraycopy(byArray, 0, byArray3, 0, n2);
                        byArray = byArray3;
                    }
                    byArray3 = byArray;
                    return byArray3;
                }
                if ((n2 += n3) != byArray.length) continue;
                int n4 = inputStream.read();
                if (n4 < 0) {
                    byArray2 = byArray;
                    return byArray2;
                }
                byArray2 = new byte[byArray.length + 1000];
                System.arraycopy(byArray, 0, byArray2, 0, n2);
                byArray2[n2++] = (byte)n4;
                byArray = byArray2;
            }
        }
        finally {
            if (bl2) {
                inputStream.close();
            }
        }
    }

    public void accept(ClassVisitor classVisitor, int n2) {
        this.accept(classVisitor, new Attribute[0], n2);
    }

    public void accept(ClassVisitor classVisitor, Attribute[] attributeArray, int n2) {
        int n3;
        int n4 = this.header;
        char[] cArray = new char[this.d];
        Context context = new Context();
        context.a = attributeArray;
        context.b = n2;
        context.c = cArray;
        int n5 = this.readUnsignedShort(n4);
        String string = this.readClass(n4 + 2, cArray);
        String string2 = this.readClass(n4 + 4, cArray);
        String[] stringArray = new String[this.readUnsignedShort(n4 + 6)];
        n4 += 8;
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            stringArray[i2] = this.readClass(n4, cArray);
            n4 += 2;
        }
        String string3 = null;
        String string4 = null;
        String string5 = null;
        String string6 = null;
        String string7 = null;
        String string8 = null;
        int n6 = 0;
        int n7 = 0;
        int n8 = 0;
        int n9 = 0;
        int n10 = 0;
        Attribute attribute = null;
        n4 = this.a();
        for (n3 = this.readUnsignedShort(n4); n3 > 0; --n3) {
            String string9 = this.readUTF8(n4 + 2, cArray);
            if ("SourceFile".equals(string9)) {
                string4 = this.readUTF8(n4 + 8, cArray);
            } else if ("InnerClasses".equals(string9)) {
                n10 = n4 + 8;
            } else if ("EnclosingMethod".equals(string9)) {
                string6 = this.readClass(n4 + 8, cArray);
                int n11 = this.readUnsignedShort(n4 + 10);
                if (n11 != 0) {
                    string7 = this.readUTF8(this.a[n11], cArray);
                    string8 = this.readUTF8(this.a[n11] + 2, cArray);
                }
            } else if ("Signature".equals(string9)) {
                string3 = this.readUTF8(n4 + 8, cArray);
            } else if ("RuntimeVisibleAnnotations".equals(string9)) {
                n6 = n4 + 8;
            } else if ("RuntimeVisibleTypeAnnotations".equals(string9)) {
                n8 = n4 + 8;
            } else if ("Deprecated".equals(string9)) {
                n5 |= 0x20000;
            } else if ("Synthetic".equals(string9)) {
                n5 |= 0x41000;
            } else if ("SourceDebugExtension".equals(string9)) {
                int n12 = this.readInt(n4 + 4);
                string5 = this.a(n4 + 8, n12, new char[n12]);
            } else if ("RuntimeInvisibleAnnotations".equals(string9)) {
                n7 = n4 + 8;
            } else if ("RuntimeInvisibleTypeAnnotations".equals(string9)) {
                n9 = n4 + 8;
            } else if ("BootstrapMethods".equals(string9)) {
                int[] nArray = new int[this.readUnsignedShort(n4 + 8)];
                int n13 = n4 + 10;
                for (int i3 = 0; i3 < nArray.length; ++i3) {
                    nArray[i3] = n13;
                    n13 += 2 + this.readUnsignedShort(n13 + 2) << 1;
                }
                context.d = nArray;
            } else {
                Attribute attribute2 = this.a(attributeArray, string9, n4 + 8, this.readInt(n4 + 4), cArray, -1, null);
                if (attribute2 != null) {
                    attribute2.a = attribute;
                    attribute = attribute2;
                }
            }
            n4 += 6 + this.readInt(n4 + 4);
        }
        classVisitor.visit(this.readInt(this.a[1] - 7), n5, string, string3, string2, stringArray);
        if ((n2 & 2) == 0 && (string4 != null || string5 != null)) {
            classVisitor.visitSource(string4, string5);
        }
        if (string6 != null) {
            classVisitor.visitOuterClass(string6, string7, string8);
        }
        if (n6 != 0) {
            int n14 = n6 + 2;
            for (n3 = this.readUnsignedShort(n6); n3 > 0; --n3) {
                n14 = this.a(n14 + 2, cArray, true, classVisitor.visitAnnotation(this.readUTF8(n14, cArray), true));
            }
        }
        if (n7 != 0) {
            int n15 = n7 + 2;
            for (n3 = this.readUnsignedShort(n7); n3 > 0; --n3) {
                n15 = this.a(n15 + 2, cArray, true, classVisitor.visitAnnotation(this.readUTF8(n15, cArray), false));
            }
        }
        if (n8 != 0) {
            int n16 = n8 + 2;
            for (n3 = this.readUnsignedShort(n8); n3 > 0; --n3) {
                n16 = this.a(context, n16);
                n16 = this.a(n16 + 2, cArray, true, classVisitor.visitTypeAnnotation(context.i, context.j, this.readUTF8(n16, cArray), true));
            }
        }
        if (n9 != 0) {
            int n17 = n9 + 2;
            for (n3 = this.readUnsignedShort(n9); n3 > 0; --n3) {
                n17 = this.a(context, n17);
                n17 = this.a(n17 + 2, cArray, true, classVisitor.visitTypeAnnotation(context.i, context.j, this.readUTF8(n17, cArray), false));
            }
        }
        while (attribute != null) {
            Attribute attribute3 = attribute.a;
            attribute.a = null;
            classVisitor.visitAttribute(attribute);
            attribute = attribute3;
        }
        if (n10 != 0) {
            n3 = n10 + 2;
            for (int i4 = this.readUnsignedShort(n10); i4 > 0; --i4) {
                classVisitor.visitInnerClass(this.readClass(n3, cArray), this.readClass(n3 + 2, cArray), this.readUTF8(n3 + 4, cArray), this.readUnsignedShort(n3 + 6));
                n3 += 8;
            }
        }
        n4 = this.header + 10 + 2 * stringArray.length;
        for (n3 = this.readUnsignedShort(n4 - 2); n3 > 0; --n3) {
            n4 = this.a(classVisitor, context, n4);
        }
        for (n3 = this.readUnsignedShort((n4 += 2) - 2); n3 > 0; --n3) {
            n4 = this.b(classVisitor, context, n4);
        }
        classVisitor.visitEnd();
    }

    private int a(ClassVisitor classVisitor, Context context, int n2) {
        int n3;
        char[] cArray = context.c;
        int n4 = this.readUnsignedShort(n2);
        String string = this.readUTF8(n2 + 2, cArray);
        String string2 = this.readUTF8(n2 + 4, cArray);
        n2 += 6;
        String string3 = null;
        int n5 = 0;
        int n6 = 0;
        int n7 = 0;
        int n8 = 0;
        Object object = null;
        Attribute attribute = null;
        for (int i2 = this.readUnsignedShort(n2); i2 > 0; --i2) {
            String string4 = this.readUTF8(n2 + 2, cArray);
            if ("ConstantValue".equals(string4)) {
                n3 = this.readUnsignedShort(n2 + 8);
                object = n3 == 0 ? null : this.readConst(n3, cArray);
            } else if ("Signature".equals(string4)) {
                string3 = this.readUTF8(n2 + 8, cArray);
            } else if ("Deprecated".equals(string4)) {
                n4 |= 0x20000;
            } else if ("Synthetic".equals(string4)) {
                n4 |= 0x41000;
            } else if ("RuntimeVisibleAnnotations".equals(string4)) {
                n5 = n2 + 8;
            } else if ("RuntimeVisibleTypeAnnotations".equals(string4)) {
                n7 = n2 + 8;
            } else if ("RuntimeInvisibleAnnotations".equals(string4)) {
                n6 = n2 + 8;
            } else if ("RuntimeInvisibleTypeAnnotations".equals(string4)) {
                n8 = n2 + 8;
            } else {
                Attribute attribute2 = this.a(context.a, string4, n2 + 8, this.readInt(n2 + 4), cArray, -1, null);
                if (attribute2 != null) {
                    attribute2.a = attribute;
                    attribute = attribute2;
                }
            }
            n2 += 6 + this.readInt(n2 + 4);
        }
        n2 += 2;
        FieldVisitor fieldVisitor = classVisitor.visitField(n4, string, string2, string3, object);
        if (fieldVisitor == null) {
            return n2;
        }
        if (n5 != 0) {
            n3 = n5 + 2;
            for (int i3 = this.readUnsignedShort(n5); i3 > 0; --i3) {
                n3 = this.a(n3 + 2, cArray, true, fieldVisitor.visitAnnotation(this.readUTF8(n3, cArray), true));
            }
        }
        if (n6 != 0) {
            n3 = n6 + 2;
            for (int i4 = this.readUnsignedShort(n6); i4 > 0; --i4) {
                n3 = this.a(n3 + 2, cArray, true, fieldVisitor.visitAnnotation(this.readUTF8(n3, cArray), false));
            }
        }
        if (n7 != 0) {
            n3 = n7 + 2;
            for (int i5 = this.readUnsignedShort(n7); i5 > 0; --i5) {
                n3 = this.a(context, n3);
                n3 = this.a(n3 + 2, cArray, true, fieldVisitor.visitTypeAnnotation(context.i, context.j, this.readUTF8(n3, cArray), true));
            }
        }
        if (n8 != 0) {
            n3 = n8 + 2;
            for (int i6 = this.readUnsignedShort(n8); i6 > 0; --i6) {
                n3 = this.a(context, n3);
                n3 = this.a(n3 + 2, cArray, true, fieldVisitor.visitTypeAnnotation(context.i, context.j, this.readUTF8(n3, cArray), false));
            }
        }
        while (attribute != null) {
            Attribute attribute3 = attribute.a;
            attribute.a = null;
            fieldVisitor.visitAttribute(attribute);
            attribute = attribute3;
        }
        fieldVisitor.visitEnd();
        return n2;
    }

    private int b(ClassVisitor classVisitor, Context context, int n2) {
        int n3;
        Object object;
        char[] cArray = context.c;
        context.e = this.readUnsignedShort(n2);
        context.f = this.readUTF8(n2 + 2, cArray);
        context.g = this.readUTF8(n2 + 4, cArray);
        n2 += 6;
        int n4 = 0;
        int n5 = 0;
        String[] stringArray = null;
        String string = null;
        int n6 = 0;
        int n7 = 0;
        int n8 = 0;
        int n9 = 0;
        int n10 = 0;
        int n11 = 0;
        int n12 = 0;
        int n13 = 0;
        int n14 = n2;
        Attribute attribute = null;
        for (int i2 = this.readUnsignedShort(n2); i2 > 0; --i2) {
            object = this.readUTF8(n2 + 2, cArray);
            if ("Code".equals(object)) {
                if ((context.b & 1) == 0) {
                    n4 = n2 + 8;
                }
            } else if ("Exceptions".equals(object)) {
                stringArray = new String[this.readUnsignedShort(n2 + 8)];
                n5 = n2 + 10;
                for (n3 = 0; n3 < stringArray.length; ++n3) {
                    stringArray[n3] = this.readClass(n5, cArray);
                    n5 += 2;
                }
            } else if ("Signature".equals(object)) {
                string = this.readUTF8(n2 + 8, cArray);
            } else if ("Deprecated".equals(object)) {
                context.e |= 0x20000;
            } else if ("RuntimeVisibleAnnotations".equals(object)) {
                n7 = n2 + 8;
            } else if ("RuntimeVisibleTypeAnnotations".equals(object)) {
                n9 = n2 + 8;
            } else if ("AnnotationDefault".equals(object)) {
                n11 = n2 + 8;
            } else if ("Synthetic".equals(object)) {
                context.e |= 0x41000;
            } else if ("RuntimeInvisibleAnnotations".equals(object)) {
                n8 = n2 + 8;
            } else if ("RuntimeInvisibleTypeAnnotations".equals(object)) {
                n10 = n2 + 8;
            } else if ("RuntimeVisibleParameterAnnotations".equals(object)) {
                n12 = n2 + 8;
            } else if ("RuntimeInvisibleParameterAnnotations".equals(object)) {
                n13 = n2 + 8;
            } else if ("MethodParameters".equals(object)) {
                n6 = n2 + 8;
            } else {
                Attribute attribute2 = this.a(context.a, (String)object, n2 + 8, this.readInt(n2 + 4), cArray, -1, null);
                if (attribute2 != null) {
                    attribute2.a = attribute;
                    attribute = attribute2;
                }
            }
            n2 += 6 + this.readInt(n2 + 4);
        }
        n2 += 2;
        MethodVisitor methodVisitor = classVisitor.visitMethod(context.e, context.f, context.g, string, stringArray);
        if (methodVisitor == null) {
            return n2;
        }
        if (methodVisitor instanceof MethodWriter) {
            object = (MethodWriter)methodVisitor;
            if (((MethodWriter)object).b.M == this && string == ((MethodWriter)object).g) {
                n3 = 0;
                if (stringArray == null) {
                    n3 = ((MethodWriter)object).j == 0 ? 1 : 0;
                } else if (stringArray.length == ((MethodWriter)object).j) {
                    n3 = 1;
                    for (int i3 = stringArray.length - 1; i3 >= 0; --i3) {
                        if (((MethodWriter)object).k[i3] == this.readUnsignedShort(n5 -= 2)) continue;
                        n3 = 0;
                        break;
                    }
                }
                if (n3 != 0) {
                    ((MethodWriter)object).h = n14;
                    ((MethodWriter)object).i = n2 - n14;
                    return n2;
                }
            }
        }
        if (n6 != 0) {
            int n15 = this.b[n6] & 0xFF;
            n3 = n6 + 1;
            while (n15 > 0) {
                methodVisitor.visitParameter(this.readUTF8(n3, cArray), this.readUnsignedShort(n3 + 2));
                --n15;
                n3 += 4;
            }
        }
        if (n11 != 0) {
            AnnotationVisitor annotationVisitor = methodVisitor.visitAnnotationDefault();
            this.a(n11, cArray, null, annotationVisitor);
            if (annotationVisitor != null) {
                annotationVisitor.visitEnd();
            }
        }
        if (n7 != 0) {
            n3 = n7 + 2;
            for (int i4 = this.readUnsignedShort(n7); i4 > 0; --i4) {
                n3 = this.a(n3 + 2, cArray, true, methodVisitor.visitAnnotation(this.readUTF8(n3, cArray), true));
            }
        }
        if (n8 != 0) {
            n3 = n8 + 2;
            for (int i5 = this.readUnsignedShort(n8); i5 > 0; --i5) {
                n3 = this.a(n3 + 2, cArray, true, methodVisitor.visitAnnotation(this.readUTF8(n3, cArray), false));
            }
        }
        if (n9 != 0) {
            n3 = n9 + 2;
            for (int i6 = this.readUnsignedShort(n9); i6 > 0; --i6) {
                n3 = this.a(context, n3);
                n3 = this.a(n3 + 2, cArray, true, methodVisitor.visitTypeAnnotation(context.i, context.j, this.readUTF8(n3, cArray), true));
            }
        }
        if (n10 != 0) {
            n3 = n10 + 2;
            for (int i7 = this.readUnsignedShort(n10); i7 > 0; --i7) {
                n3 = this.a(context, n3);
                n3 = this.a(n3 + 2, cArray, true, methodVisitor.visitTypeAnnotation(context.i, context.j, this.readUTF8(n3, cArray), false));
            }
        }
        if (n12 != 0) {
            this.b(methodVisitor, context, n12, true);
        }
        if (n13 != 0) {
            this.b(methodVisitor, context, n13, false);
        }
        while (attribute != null) {
            Attribute attribute3 = attribute.a;
            attribute.a = null;
            methodVisitor.visitAttribute(attribute);
            attribute = attribute3;
        }
        if (n4 != 0) {
            methodVisitor.visitCode();
            this.a(methodVisitor, context, n4);
        }
        methodVisitor.visitEnd();
        return n2;
    }

    private void a(MethodVisitor methodVisitor, Context context, int n2) {
        int n3;
        int n4;
        int n5;
        Object object;
        int n6;
        int n7;
        byte[] byArray = this.b;
        char[] cArray = context.c;
        int n8 = this.readUnsignedShort(n2);
        int n9 = this.readUnsignedShort(n2 + 2);
        int n10 = this.readInt(n2 + 4);
        int n11 = n2 += 8;
        int n12 = n2 + n10;
        context.h = new Label[n10 + 2];
        Label[] labelArray = context.h;
        this.readLabel(n10 + 1, labelArray);
        block29: while (n2 < n12) {
            n7 = n2 - n11;
            int n13 = byArray[n2] & 0xFF;
            switch (ClassWriter.a[n13]) {
                case 0: 
                case 4: {
                    ++n2;
                    continue block29;
                }
                case 9: {
                    this.readLabel(n7 + this.readShort(n2 + 1), labelArray);
                    n2 += 3;
                    continue block29;
                }
                case 10: {
                    this.readLabel(n7 + this.readInt(n2 + 1), labelArray);
                    n2 += 5;
                    continue block29;
                }
                case 17: {
                    n13 = byArray[n2 + 1] & 0xFF;
                    if (n13 == 132) {
                        n2 += 6;
                        continue block29;
                    }
                    n2 += 4;
                    continue block29;
                }
                case 14: {
                    int n14;
                    n2 = n2 + 4 - (n7 & 3);
                    this.readLabel(n7 + this.readInt(n2), labelArray);
                    for (n14 = this.readInt(n2 + 8) - this.readInt(n2 + 4) + 1; n14 > 0; --n14) {
                        this.readLabel(n7 + this.readInt(n2 + 12), labelArray);
                        n2 += 4;
                    }
                    n2 += 12;
                    continue block29;
                }
                case 15: {
                    int n14;
                    n2 = n2 + 4 - (n7 & 3);
                    this.readLabel(n7 + this.readInt(n2), labelArray);
                    for (n14 = this.readInt(n2 + 4); n14 > 0; --n14) {
                        this.readLabel(n7 + this.readInt(n2 + 12), labelArray);
                        n2 += 8;
                    }
                    n2 += 8;
                    continue block29;
                }
                case 1: 
                case 3: 
                case 11: {
                    n2 += 2;
                    continue block29;
                }
                case 2: 
                case 5: 
                case 6: 
                case 12: 
                case 13: {
                    n2 += 3;
                    continue block29;
                }
                case 7: 
                case 8: {
                    n2 += 5;
                    continue block29;
                }
            }
            n2 += 4;
        }
        for (n7 = this.readUnsignedShort(n2); n7 > 0; --n7) {
            Label label = this.readLabel(this.readUnsignedShort(n2 + 2), labelArray);
            Label label2 = this.readLabel(this.readUnsignedShort(n2 + 4), labelArray);
            Label label3 = this.readLabel(this.readUnsignedShort(n2 + 6), labelArray);
            String string = this.readUTF8(this.a[this.readUnsignedShort(n2 + 8)], cArray);
            methodVisitor.visitTryCatchBlock(label, label2, label3, string);
            n2 += 8;
        }
        n2 += 2;
        int[] nArray = null;
        int[] nArray2 = null;
        int n15 = 0;
        int n16 = 0;
        int n17 = -1;
        int n18 = -1;
        int n19 = 0;
        int n20 = 0;
        boolean bl2 = true;
        boolean bl3 = (context.b & 8) != 0;
        int n21 = 0;
        int n22 = 0;
        int n23 = 0;
        Context context2 = null;
        Attribute attribute = null;
        for (n6 = this.readUnsignedShort(n2); n6 > 0; --n6) {
            object = this.readUTF8(n2 + 2, cArray);
            if ("LocalVariableTable".equals(object)) {
                if ((context.b & 2) == 0) {
                    n19 = n2 + 8;
                    n5 = n2;
                    for (n4 = this.readUnsignedShort(n2 + 8); n4 > 0; --n4) {
                        n3 = this.readUnsignedShort(n5 + 10);
                        if (labelArray[n3] == null) {
                            this.readLabel((int)n3, (Label[])labelArray).a |= 1;
                        }
                        if (labelArray[n3 += this.readUnsignedShort(n5 + 12)] == null) {
                            this.readLabel((int)n3, (Label[])labelArray).a |= 1;
                        }
                        n5 += 10;
                    }
                }
            } else if ("LocalVariableTypeTable".equals(object)) {
                n20 = n2 + 8;
            } else if ("LineNumberTable".equals(object)) {
                if ((context.b & 2) == 0) {
                    n5 = n2;
                    for (n4 = this.readUnsignedShort(n2 + 8); n4 > 0; --n4) {
                        n3 = this.readUnsignedShort(n5 + 10);
                        if (labelArray[n3] == null) {
                            this.readLabel((int)n3, (Label[])labelArray).a |= 1;
                        }
                        Label label = labelArray[n3];
                        while (label.b > 0) {
                            if (label.k == null) {
                                label.k = new Label();
                            }
                            label = label.k;
                        }
                        label.b = this.readUnsignedShort(n5 + 12);
                        n5 += 4;
                    }
                }
            } else if ("RuntimeVisibleTypeAnnotations".equals(object)) {
                nArray = this.a(methodVisitor, context, n2 + 8, true);
                n17 = nArray.length == 0 || this.readByte(nArray[0]) < 67 ? -1 : this.readUnsignedShort(nArray[0] + 1);
            } else if ("RuntimeInvisibleTypeAnnotations".equals(object)) {
                nArray2 = this.a(methodVisitor, context, n2 + 8, false);
                n18 = nArray2.length == 0 || this.readByte(nArray2[0]) < 67 ? -1 : this.readUnsignedShort(nArray2[0] + 1);
            } else if ("StackMapTable".equals(object)) {
                if ((context.b & 4) == 0) {
                    n21 = n2 + 10;
                    n22 = this.readInt(n2 + 4);
                    n23 = this.readUnsignedShort(n2 + 8);
                }
            } else if ("StackMap".equals(object)) {
                if ((context.b & 4) == 0) {
                    bl2 = false;
                    n21 = n2 + 10;
                    n22 = this.readInt(n2 + 4);
                    n23 = this.readUnsignedShort(n2 + 8);
                }
            } else {
                for (n4 = 0; n4 < context.a.length; ++n4) {
                    Attribute attribute2;
                    if (!context.a[n4].type.equals(object) || (attribute2 = context.a[n4].read(this, n2 + 8, this.readInt(n2 + 4), cArray, n11 - 8, labelArray)) == null) continue;
                    attribute2.a = attribute;
                    attribute = attribute2;
                }
            }
            n2 += 6 + this.readInt(n2 + 4);
        }
        n2 += 2;
        if (n21 != 0) {
            context2 = context;
            context2.o = -1;
            context2.p = 0;
            context2.q = 0;
            context2.r = 0;
            context2.t = 0;
            context2.s = new Object[n9];
            context2.u = new Object[n8];
            if (bl3) {
                this.a(context);
            }
            for (n6 = n21; n6 < n21 + n22 - 2; ++n6) {
                int n24;
                if (byArray[n6] != 8 || (n24 = this.readUnsignedShort(n6 + 1)) < 0 || n24 >= n10 || (byArray[n11 + n24] & 0xFF) != 187) continue;
                this.readLabel(n24, labelArray);
            }
        }
        n2 = n11;
        while (n2 < n12) {
            n6 = n2 - n11;
            object = labelArray[n6];
            if (object != null) {
                Label label = ((Label)object).k;
                ((Label)object).k = null;
                methodVisitor.visitLabel((Label)object);
                if ((context.b & 2) == 0 && ((Label)object).b > 0) {
                    methodVisitor.visitLineNumber(((Label)object).b, (Label)object);
                    while (label != null) {
                        methodVisitor.visitLineNumber(label.b, (Label)object);
                        label = label.k;
                    }
                }
            }
            while (context2 != null && (context2.o == n6 || context2.o == -1)) {
                if (context2.o != -1) {
                    if (!bl2 || bl3) {
                        methodVisitor.visitFrame(-1, context2.q, context2.s, context2.t, context2.u);
                    } else {
                        methodVisitor.visitFrame(context2.p, context2.r, context2.s, context2.t, context2.u);
                    }
                }
                if (n23 > 0) {
                    n21 = this.a(n21, bl2, bl3, context2);
                    --n23;
                    continue;
                }
                context2 = null;
            }
            n4 = byArray[n2] & 0xFF;
            switch (ClassWriter.a[n4]) {
                case 0: {
                    methodVisitor.visitInsn(n4);
                    ++n2;
                    break;
                }
                case 4: {
                    if (n4 > 54) {
                        methodVisitor.visitVarInsn(54 + ((n4 -= 59) >> 2), n4 & 3);
                    } else {
                        methodVisitor.visitVarInsn(21 + ((n4 -= 26) >> 2), n4 & 3);
                    }
                    ++n2;
                    break;
                }
                case 9: {
                    methodVisitor.visitJumpInsn(n4, labelArray[n6 + this.readShort(n2 + 1)]);
                    n2 += 3;
                    break;
                }
                case 10: {
                    methodVisitor.visitJumpInsn(n4 - 33, labelArray[n6 + this.readInt(n2 + 1)]);
                    n2 += 5;
                    break;
                }
                case 17: {
                    n4 = byArray[n2 + 1] & 0xFF;
                    if (n4 == 132) {
                        methodVisitor.visitIincInsn(this.readUnsignedShort(n2 + 2), this.readShort(n2 + 4));
                        n2 += 6;
                        break;
                    }
                    methodVisitor.visitVarInsn(n4, this.readUnsignedShort(n2 + 2));
                    n2 += 4;
                    break;
                }
                case 14: {
                    n2 = n2 + 4 - (n6 & 3);
                    n5 = n6 + this.readInt(n2);
                    n3 = this.readInt(n2 + 4);
                    int n25 = this.readInt(n2 + 8);
                    Label[] labelArray2 = new Label[n25 - n3 + 1];
                    n2 += 12;
                    for (int i2 = 0; i2 < labelArray2.length; ++i2) {
                        labelArray2[i2] = labelArray[n6 + this.readInt(n2)];
                        n2 += 4;
                    }
                    methodVisitor.visitTableSwitchInsn(n3, n25, labelArray[n5], labelArray2);
                    break;
                }
                case 15: {
                    n2 = n2 + 4 - (n6 & 3);
                    n5 = n6 + this.readInt(n2);
                    n3 = this.readInt(n2 + 4);
                    int[] nArray3 = new int[n3];
                    Label[] labelArray3 = new Label[n3];
                    n2 += 8;
                    for (int i3 = 0; i3 < n3; ++i3) {
                        nArray3[i3] = this.readInt(n2);
                        labelArray3[i3] = labelArray[n6 + this.readInt(n2 + 4)];
                        n2 += 8;
                    }
                    methodVisitor.visitLookupSwitchInsn(labelArray[n5], nArray3, labelArray3);
                    break;
                }
                case 3: {
                    methodVisitor.visitVarInsn(n4, byArray[n2 + 1] & 0xFF);
                    n2 += 2;
                    break;
                }
                case 1: {
                    methodVisitor.visitIntInsn(n4, byArray[n2 + 1]);
                    n2 += 2;
                    break;
                }
                case 2: {
                    methodVisitor.visitIntInsn(n4, this.readShort(n2 + 1));
                    n2 += 3;
                    break;
                }
                case 11: {
                    methodVisitor.visitLdcInsn(this.readConst(byArray[n2 + 1] & 0xFF, cArray));
                    n2 += 2;
                    break;
                }
                case 12: {
                    methodVisitor.visitLdcInsn(this.readConst(this.readUnsignedShort(n2 + 1), cArray));
                    n2 += 3;
                    break;
                }
                case 6: 
                case 7: {
                    n5 = this.a[this.readUnsignedShort(n2 + 1)];
                    n3 = byArray[n5 - 1] == 11 ? 1 : 0;
                    String string = this.readClass(n5, cArray);
                    n5 = this.a[this.readUnsignedShort(n5 + 2)];
                    String string2 = this.readUTF8(n5, cArray);
                    String string3 = this.readUTF8(n5 + 2, cArray);
                    if (n4 < 182) {
                        methodVisitor.visitFieldInsn(n4, string, string2, string3);
                    } else {
                        methodVisitor.visitMethodInsn(n4, string, string2, string3, n3 != 0);
                    }
                    if (n4 == 185) {
                        n2 += 5;
                        break;
                    }
                    n2 += 3;
                    break;
                }
                case 8: {
                    n5 = this.a[this.readUnsignedShort(n2 + 1)];
                    n3 = context.d[this.readUnsignedShort(n5)];
                    Handle handle = (Handle)this.readConst(this.readUnsignedShort(n3), cArray);
                    int n26 = this.readUnsignedShort(n3 + 2);
                    Object[] objectArray = new Object[n26];
                    n3 += 4;
                    for (int i4 = 0; i4 < n26; ++i4) {
                        objectArray[i4] = this.readConst(this.readUnsignedShort(n3), cArray);
                        n3 += 2;
                    }
                    n5 = this.a[this.readUnsignedShort(n5 + 2)];
                    String string = this.readUTF8(n5, cArray);
                    String string4 = this.readUTF8(n5 + 2, cArray);
                    methodVisitor.visitInvokeDynamicInsn(string, string4, handle, objectArray);
                    n2 += 5;
                    break;
                }
                case 5: {
                    methodVisitor.visitTypeInsn(n4, this.readClass(n2 + 1, cArray));
                    n2 += 3;
                    break;
                }
                case 13: {
                    methodVisitor.visitIincInsn(byArray[n2 + 1] & 0xFF, byArray[n2 + 2]);
                    n2 += 3;
                    break;
                }
                default: {
                    methodVisitor.visitMultiANewArrayInsn(this.readClass(n2 + 1, cArray), byArray[n2 + 3] & 0xFF);
                    n2 += 4;
                }
            }
            while (nArray != null && n15 < nArray.length && n17 <= n6) {
                if (n17 == n6) {
                    n5 = this.a(context, nArray[n15]);
                    this.a(n5 + 2, cArray, true, methodVisitor.visitInsnAnnotation(context.i, context.j, this.readUTF8(n5, cArray), true));
                }
                n17 = ++n15 >= nArray.length || this.readByte(nArray[n15]) < 67 ? -1 : this.readUnsignedShort(nArray[n15] + 1);
            }
            while (nArray2 != null && n16 < nArray2.length && n18 <= n6) {
                if (n18 == n6) {
                    n5 = this.a(context, nArray2[n16]);
                    this.a(n5 + 2, cArray, true, methodVisitor.visitInsnAnnotation(context.i, context.j, this.readUTF8(n5, cArray), false));
                }
                n18 = ++n16 >= nArray2.length || this.readByte(nArray2[n16]) < 67 ? -1 : this.readUnsignedShort(nArray2[n16] + 1);
            }
        }
        if (labelArray[n10] != null) {
            methodVisitor.visitLabel(labelArray[n10]);
        }
        if ((context.b & 2) == 0 && n19 != 0) {
            int[] nArray4 = null;
            if (n20 != 0) {
                n2 = n20 + 2;
                nArray4 = new int[this.readUnsignedShort(n20) * 3];
                int n27 = nArray4.length;
                while (n27 > 0) {
                    nArray4[--n27] = n2 + 6;
                    nArray4[--n27] = this.readUnsignedShort(n2 + 8);
                    nArray4[--n27] = this.readUnsignedShort(n2);
                    n2 += 10;
                }
            }
            n2 = n19 + 2;
            for (int i5 = this.readUnsignedShort(n19); i5 > 0; --i5) {
                n4 = this.readUnsignedShort(n2);
                n5 = this.readUnsignedShort(n2 + 2);
                n3 = this.readUnsignedShort(n2 + 8);
                String string = null;
                if (nArray4 != null) {
                    for (int i6 = 0; i6 < nArray4.length; i6 += 3) {
                        if (nArray4[i6] != n4 || nArray4[i6 + 1] != n3) continue;
                        string = this.readUTF8(nArray4[i6 + 2], cArray);
                        break;
                    }
                }
                methodVisitor.visitLocalVariable(this.readUTF8(n2 + 4, cArray), this.readUTF8(n2 + 6, cArray), string, labelArray[n4], labelArray[n4 + n5], n3);
                n2 += 10;
            }
        }
        if (nArray != null) {
            for (int i7 = 0; i7 < nArray.length; ++i7) {
                if (this.readByte((int)nArray[i7]) >> 1 != 32) continue;
                int n28 = this.a(context, nArray[i7]);
                n28 = this.a(n28 + 2, cArray, true, methodVisitor.visitLocalVariableAnnotation(context.i, context.j, context.l, context.m, context.n, this.readUTF8(n28, cArray), true));
            }
        }
        if (nArray2 != null) {
            for (int i8 = 0; i8 < nArray2.length; ++i8) {
                if (this.readByte((int)nArray2[i8]) >> 1 != 32) continue;
                int n29 = this.a(context, nArray2[i8]);
                n29 = this.a(n29 + 2, cArray, true, methodVisitor.visitLocalVariableAnnotation(context.i, context.j, context.l, context.m, context.n, this.readUTF8(n29, cArray), false));
            }
        }
        while (attribute != null) {
            Attribute attribute3 = attribute.a;
            attribute.a = null;
            methodVisitor.visitAttribute(attribute);
            attribute = attribute3;
        }
        methodVisitor.visitMaxs(n8, n9);
    }

    private int[] a(MethodVisitor methodVisitor, Context context, int n2, boolean bl2) {
        char[] cArray = context.c;
        int[] nArray = new int[this.readUnsignedShort(n2)];
        n2 += 2;
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            int n3;
            nArray[i2] = n2;
            int n4 = this.readInt(n2);
            switch (n4 >>> 24) {
                case 0: 
                case 1: 
                case 22: {
                    n2 += 2;
                    break;
                }
                case 19: 
                case 20: 
                case 21: {
                    ++n2;
                    break;
                }
                case 64: 
                case 65: {
                    for (n3 = this.readUnsignedShort(n2 + 1); n3 > 0; --n3) {
                        int n5 = this.readUnsignedShort(n2 + 3);
                        int n6 = this.readUnsignedShort(n2 + 5);
                        this.readLabel(n5, context.h);
                        this.readLabel(n5 + n6, context.h);
                        n2 += 6;
                    }
                    n2 += 3;
                    break;
                }
                case 71: 
                case 72: 
                case 73: 
                case 74: 
                case 75: {
                    n2 += 4;
                    break;
                }
                default: {
                    n2 += 3;
                }
            }
            n3 = this.readByte(n2);
            if (n4 >>> 24 == 66) {
                TypePath typePath = n3 == 0 ? null : new TypePath(this.b, n2);
                n2 += 1 + 2 * n3;
                n2 = this.a(n2 + 2, cArray, true, methodVisitor.visitTryCatchAnnotation(n4, typePath, this.readUTF8(n2, cArray), bl2));
                continue;
            }
            n2 = this.a(n2 + 3 + 2 * n3, cArray, true, null);
        }
        return nArray;
    }

    private int a(Context context, int n2) {
        int n3;
        int n4 = this.readInt(n2);
        switch (n4 >>> 24) {
            case 0: 
            case 1: 
            case 22: {
                n4 &= 0xFFFF0000;
                n2 += 2;
                break;
            }
            case 19: 
            case 20: 
            case 21: {
                n4 &= 0xFF000000;
                ++n2;
                break;
            }
            case 64: 
            case 65: {
                n4 &= 0xFF000000;
                n3 = this.readUnsignedShort(n2 + 1);
                context.l = new Label[n3];
                context.m = new Label[n3];
                context.n = new int[n3];
                n2 += 3;
                for (int i2 = 0; i2 < n3; ++i2) {
                    int n5 = this.readUnsignedShort(n2);
                    int n6 = this.readUnsignedShort(n2 + 2);
                    context.l[i2] = this.readLabel(n5, context.h);
                    context.m[i2] = this.readLabel(n5 + n6, context.h);
                    context.n[i2] = this.readUnsignedShort(n2 + 4);
                    n2 += 6;
                }
                break;
            }
            case 71: 
            case 72: 
            case 73: 
            case 74: 
            case 75: {
                n4 &= 0xFF0000FF;
                n2 += 4;
                break;
            }
            default: {
                n4 &= n4 >>> 24 < 67 ? -256 : -16777216;
                n2 += 3;
            }
        }
        n3 = this.readByte(n2);
        context.i = n4;
        context.j = n3 == 0 ? null : new TypePath(this.b, n2);
        return n2 + 1 + 2 * n3;
    }

    private void b(MethodVisitor methodVisitor, Context context, int n2, boolean bl2) {
        AnnotationVisitor annotationVisitor;
        int n3;
        int n4 = this.b[n2++] & 0xFF;
        int n5 = Type.getArgumentTypes(context.g).length - n4;
        for (n3 = 0; n3 < n5; ++n3) {
            annotationVisitor = methodVisitor.visitParameterAnnotation(n3, "Ljava/lang/Synthetic;", false);
            if (annotationVisitor == null) continue;
            annotationVisitor.visitEnd();
        }
        char[] cArray = context.c;
        while (n3 < n4 + n5) {
            int n6 = this.readUnsignedShort(n2);
            n2 += 2;
            while (n6 > 0) {
                annotationVisitor = methodVisitor.visitParameterAnnotation(n3, this.readUTF8(n2, cArray), bl2);
                n2 = this.a(n2 + 2, cArray, true, annotationVisitor);
                --n6;
            }
            ++n3;
        }
    }

    private int a(int n2, char[] cArray, boolean bl2, AnnotationVisitor annotationVisitor) {
        int n3 = this.readUnsignedShort(n2);
        n2 += 2;
        if (bl2) {
            while (n3 > 0) {
                n2 = this.a(n2 + 2, cArray, this.readUTF8(n2, cArray), annotationVisitor);
                --n3;
            }
        } else {
            while (n3 > 0) {
                n2 = this.a(n2, cArray, null, annotationVisitor);
                --n3;
            }
        }
        if (annotationVisitor != null) {
            annotationVisitor.visitEnd();
        }
        return n2;
    }

    private int a(int n2, char[] cArray, String string, AnnotationVisitor annotationVisitor) {
        if (annotationVisitor == null) {
            switch (this.b[n2] & 0xFF) {
                case 101: {
                    return n2 + 5;
                }
                case 64: {
                    return this.a(n2 + 3, cArray, true, null);
                }
                case 91: {
                    return this.a(n2 + 1, cArray, false, null);
                }
            }
            return n2 + 3;
        }
        block5 : switch (this.b[n2++] & 0xFF) {
            case 68: 
            case 70: 
            case 73: 
            case 74: {
                annotationVisitor.visit(string, this.readConst(this.readUnsignedShort(n2), cArray));
                n2 += 2;
                break;
            }
            case 66: {
                annotationVisitor.visit(string, new Byte((byte)this.readInt(this.a[this.readUnsignedShort(n2)])));
                n2 += 2;
                break;
            }
            case 90: {
                annotationVisitor.visit(string, this.readInt(this.a[this.readUnsignedShort(n2)]) == 0 ? Boolean.FALSE : Boolean.TRUE);
                n2 += 2;
                break;
            }
            case 83: {
                annotationVisitor.visit(string, new Short((short)this.readInt(this.a[this.readUnsignedShort(n2)])));
                n2 += 2;
                break;
            }
            case 67: {
                annotationVisitor.visit(string, new Character((char)this.readInt(this.a[this.readUnsignedShort(n2)])));
                n2 += 2;
                break;
            }
            case 115: {
                annotationVisitor.visit(string, this.readUTF8(n2, cArray));
                n2 += 2;
                break;
            }
            case 101: {
                annotationVisitor.visitEnum(string, this.readUTF8(n2, cArray), this.readUTF8(n2 + 2, cArray));
                n2 += 4;
                break;
            }
            case 99: {
                annotationVisitor.visit(string, Type.getType(this.readUTF8(n2, cArray)));
                n2 += 2;
                break;
            }
            case 64: {
                n2 = this.a(n2 + 2, cArray, true, annotationVisitor.visitAnnotation(string, this.readUTF8(n2, cArray)));
                break;
            }
            case 91: {
                int n3 = this.readUnsignedShort(n2);
                n2 += 2;
                if (n3 == 0) {
                    return this.a(n2 - 2, cArray, false, annotationVisitor.visitArray(string));
                }
                switch (this.b[n2++] & 0xFF) {
                    case 66: {
                        byte[] byArray = new byte[n3];
                        for (int i2 = 0; i2 < n3; ++i2) {
                            byArray[i2] = (byte)this.readInt(this.a[this.readUnsignedShort(n2)]);
                            n2 += 3;
                        }
                        annotationVisitor.visit(string, byArray);
                        --n2;
                        break block5;
                    }
                    case 90: {
                        boolean[] blArray = new boolean[n3];
                        for (int i3 = 0; i3 < n3; ++i3) {
                            blArray[i3] = this.readInt(this.a[this.readUnsignedShort(n2)]) != 0;
                            n2 += 3;
                        }
                        annotationVisitor.visit(string, blArray);
                        --n2;
                        break block5;
                    }
                    case 83: {
                        short[] sArray = new short[n3];
                        for (int i4 = 0; i4 < n3; ++i4) {
                            sArray[i4] = (short)this.readInt(this.a[this.readUnsignedShort(n2)]);
                            n2 += 3;
                        }
                        annotationVisitor.visit(string, sArray);
                        --n2;
                        break block5;
                    }
                    case 67: {
                        char[] cArray2 = new char[n3];
                        for (int i5 = 0; i5 < n3; ++i5) {
                            cArray2[i5] = (char)this.readInt(this.a[this.readUnsignedShort(n2)]);
                            n2 += 3;
                        }
                        annotationVisitor.visit(string, cArray2);
                        --n2;
                        break block5;
                    }
                    case 73: {
                        int[] nArray = new int[n3];
                        for (int i6 = 0; i6 < n3; ++i6) {
                            nArray[i6] = this.readInt(this.a[this.readUnsignedShort(n2)]);
                            n2 += 3;
                        }
                        annotationVisitor.visit(string, nArray);
                        --n2;
                        break block5;
                    }
                    case 74: {
                        long[] lArray = new long[n3];
                        for (int i7 = 0; i7 < n3; ++i7) {
                            lArray[i7] = this.readLong(this.a[this.readUnsignedShort(n2)]);
                            n2 += 3;
                        }
                        annotationVisitor.visit(string, lArray);
                        --n2;
                        break block5;
                    }
                    case 70: {
                        float[] fArray = new float[n3];
                        for (int i8 = 0; i8 < n3; ++i8) {
                            fArray[i8] = Float.intBitsToFloat(this.readInt(this.a[this.readUnsignedShort(n2)]));
                            n2 += 3;
                        }
                        annotationVisitor.visit(string, fArray);
                        --n2;
                        break block5;
                    }
                    case 68: {
                        double[] dArray = new double[n3];
                        for (int i9 = 0; i9 < n3; ++i9) {
                            dArray[i9] = Double.longBitsToDouble(this.readLong(this.a[this.readUnsignedShort(n2)]));
                            n2 += 3;
                        }
                        annotationVisitor.visit(string, dArray);
                        --n2;
                        break block5;
                    }
                }
                n2 = this.a(n2 - 3, cArray, false, annotationVisitor.visitArray(string));
            }
        }
        return n2;
    }

    private void a(Context context) {
        String string = context.g;
        Object[] objectArray = context.s;
        int n2 = 0;
        if ((context.e & 8) == 0) {
            objectArray[n2++] = "<init>".equals(context.f) ? Opcodes.UNINITIALIZED_THIS : this.readClass(this.header + 2, context.c);
        }
        int n3 = 1;
        block8: while (true) {
            int n4 = n3;
            switch (string.charAt(n3++)) {
                case 'B': 
                case 'C': 
                case 'I': 
                case 'S': 
                case 'Z': {
                    objectArray[n2++] = Opcodes.INTEGER;
                    continue block8;
                }
                case 'F': {
                    objectArray[n2++] = Opcodes.FLOAT;
                    continue block8;
                }
                case 'J': {
                    objectArray[n2++] = Opcodes.LONG;
                    continue block8;
                }
                case 'D': {
                    objectArray[n2++] = Opcodes.DOUBLE;
                    continue block8;
                }
                case '[': {
                    while (string.charAt(n3) == '[') {
                        ++n3;
                    }
                    if (string.charAt(n3) == 'L') {
                        ++n3;
                        while (string.charAt(n3) != ';') {
                            ++n3;
                        }
                    }
                    objectArray[n2++] = string.substring(n4, ++n3);
                    continue block8;
                }
                case 'L': {
                    while (string.charAt(n3) != ';') {
                        ++n3;
                    }
                    objectArray[n2++] = string.substring(n4 + 1, n3++);
                    continue block8;
                }
            }
            break;
        }
        context.q = n2;
    }

    private int a(int n2, boolean bl2, boolean bl3, Context context) {
        int n3;
        int n4;
        char[] cArray = context.c;
        Label[] labelArray = context.h;
        if (bl2) {
            n4 = this.b[n2++] & 0xFF;
        } else {
            n4 = 255;
            context.o = -1;
        }
        context.r = 0;
        if (n4 < 64) {
            n3 = n4;
            context.p = 3;
            context.t = 0;
        } else if (n4 < 128) {
            n3 = n4 - 64;
            n2 = this.a(context.u, 0, n2, cArray, labelArray);
            context.p = 4;
            context.t = 1;
        } else {
            n3 = this.readUnsignedShort(n2);
            n2 += 2;
            if (n4 == 247) {
                n2 = this.a(context.u, 0, n2, cArray, labelArray);
                context.p = 4;
                context.t = 1;
            } else if (n4 >= 248 && n4 < 251) {
                context.p = 2;
                context.r = 251 - n4;
                context.q -= context.r;
                context.t = 0;
            } else if (n4 == 251) {
                context.p = 3;
                context.t = 0;
            } else if (n4 < 255) {
                int n5 = bl3 ? context.q : 0;
                for (int i2 = n4 - 251; i2 > 0; --i2) {
                    n2 = this.a(context.s, n5++, n2, cArray, labelArray);
                }
                context.p = 1;
                context.r = n4 - 251;
                context.q += context.r;
                context.t = 0;
            } else {
                context.p = 0;
                int n6 = this.readUnsignedShort(n2);
                n2 += 2;
                context.r = n6;
                context.q = n6;
                int n7 = 0;
                while (n6 > 0) {
                    n2 = this.a(context.s, n7++, n2, cArray, labelArray);
                    --n6;
                }
                n6 = this.readUnsignedShort(n2);
                n2 += 2;
                context.t = n6;
                n7 = 0;
                while (n6 > 0) {
                    n2 = this.a(context.u, n7++, n2, cArray, labelArray);
                    --n6;
                }
            }
        }
        context.o += n3 + 1;
        this.readLabel(context.o, labelArray);
        return n2;
    }

    private int a(Object[] objectArray, int n2, int n3, char[] cArray, Label[] labelArray) {
        int n4 = this.b[n3++] & 0xFF;
        switch (n4) {
            case 0: {
                objectArray[n2] = Opcodes.TOP;
                break;
            }
            case 1: {
                objectArray[n2] = Opcodes.INTEGER;
                break;
            }
            case 2: {
                objectArray[n2] = Opcodes.FLOAT;
                break;
            }
            case 3: {
                objectArray[n2] = Opcodes.DOUBLE;
                break;
            }
            case 4: {
                objectArray[n2] = Opcodes.LONG;
                break;
            }
            case 5: {
                objectArray[n2] = Opcodes.NULL;
                break;
            }
            case 6: {
                objectArray[n2] = Opcodes.UNINITIALIZED_THIS;
                break;
            }
            case 7: {
                objectArray[n2] = this.readClass(n3, cArray);
                n3 += 2;
                break;
            }
            default: {
                objectArray[n2] = this.readLabel(this.readUnsignedShort(n3), labelArray);
                n3 += 2;
            }
        }
        return n3;
    }

    protected Label readLabel(int n2, Label[] labelArray) {
        if (labelArray[n2] == null) {
            labelArray[n2] = new Label();
        }
        return labelArray[n2];
    }

    private int a() {
        int n2;
        int n3;
        int n4 = this.header + 8 + this.readUnsignedShort(this.header + 6) * 2;
        for (n3 = this.readUnsignedShort(n4); n3 > 0; --n3) {
            for (n2 = this.readUnsignedShort(n4 + 8); n2 > 0; --n2) {
                n4 += 6 + this.readInt(n4 + 12);
            }
            n4 += 8;
        }
        for (n3 = this.readUnsignedShort(n4 += 2); n3 > 0; --n3) {
            for (n2 = this.readUnsignedShort(n4 + 8); n2 > 0; --n2) {
                n4 += 6 + this.readInt(n4 + 12);
            }
            n4 += 8;
        }
        return n4 + 2;
    }

    private Attribute a(Attribute[] attributeArray, String string, int n2, int n3, char[] cArray, int n4, Label[] labelArray) {
        for (int i2 = 0; i2 < attributeArray.length; ++i2) {
            if (!attributeArray[i2].type.equals(string)) continue;
            return attributeArray[i2].read(this, n2, n3, cArray, n4, labelArray);
        }
        return new Attribute(string).read(this, n2, n3, null, -1, null);
    }

    public int getItemCount() {
        return this.a.length;
    }

    public int getItem(int n2) {
        return this.a[n2];
    }

    public int getMaxStringLength() {
        return this.d;
    }

    public int readByte(int n2) {
        return this.b[n2] & 0xFF;
    }

    public int readUnsignedShort(int n2) {
        byte[] byArray = this.b;
        return (byArray[n2] & 0xFF) << 8 | byArray[n2 + 1] & 0xFF;
    }

    public short readShort(int n2) {
        byte[] byArray = this.b;
        return (short)((byArray[n2] & 0xFF) << 8 | byArray[n2 + 1] & 0xFF);
    }

    public int readInt(int n2) {
        byte[] byArray = this.b;
        return (byArray[n2] & 0xFF) << 24 | (byArray[n2 + 1] & 0xFF) << 16 | (byArray[n2 + 2] & 0xFF) << 8 | byArray[n2 + 3] & 0xFF;
    }

    public long readLong(int n2) {
        long l2 = this.readInt(n2);
        long l3 = (long)this.readInt(n2 + 4) & 0xFFFFFFFFL;
        return l2 << 32 | l3;
    }

    public String readUTF8(int n2, char[] cArray) {
        int n3 = this.readUnsignedShort(n2);
        if (n2 == 0 || n3 == 0) {
            return null;
        }
        String string = this.c[n3];
        if (string != null) {
            return string;
        }
        n2 = this.a[n3];
        this.c[n3] = this.a(n2 + 2, this.readUnsignedShort(n2), cArray);
        return this.c[n3];
    }

    private String a(int n2, int n3, char[] cArray) {
        int n4 = n2 + n3;
        byte[] byArray = this.b;
        int n5 = 0;
        int n6 = 0;
        int n7 = 0;
        while (n2 < n4) {
            int n8 = byArray[n2++];
            switch (n6) {
                case 0: {
                    if ((n8 &= 0xFF) < 128) {
                        cArray[n5++] = (char)n8;
                        break;
                    }
                    if (n8 < 224 && n8 > 191) {
                        n7 = (char)(n8 & 0x1F);
                        n6 = 1;
                        break;
                    }
                    n7 = (char)(n8 & 0xF);
                    n6 = 2;
                    break;
                }
                case 1: {
                    cArray[n5++] = (char)(n7 << 6 | n8 & 0x3F);
                    n6 = 0;
                    break;
                }
                case 2: {
                    n7 = (char)(n7 << 6 | n8 & 0x3F);
                    n6 = 1;
                }
            }
        }
        return new String(cArray, 0, n5);
    }

    public String readClass(int n2, char[] cArray) {
        return this.readUTF8(this.a[this.readUnsignedShort(n2)], cArray);
    }

    public Object readConst(int n2, char[] cArray) {
        int n3 = this.a[n2];
        switch (this.b[n3 - 1]) {
            case 3: {
                return new Integer(this.readInt(n3));
            }
            case 4: {
                return new Float(Float.intBitsToFloat(this.readInt(n3)));
            }
            case 5: {
                return new Long(this.readLong(n3));
            }
            case 6: {
                return new Double(Double.longBitsToDouble(this.readLong(n3)));
            }
            case 7: {
                return Type.getObjectType(this.readUTF8(n3, cArray));
            }
            case 8: {
                return this.readUTF8(n3, cArray);
            }
            case 16: {
                return Type.getMethodType(this.readUTF8(n3, cArray));
            }
        }
        int n4 = this.readByte(n3);
        int[] nArray = this.a;
        int n5 = nArray[this.readUnsignedShort(n3 + 1)];
        boolean bl2 = this.b[n5 - 1] == 11;
        String string = this.readClass(n5, cArray);
        n5 = nArray[this.readUnsignedShort(n5 + 2)];
        String string2 = this.readUTF8(n5, cArray);
        String string3 = this.readUTF8(n5 + 2, cArray);
        return new Handle(n4, string, string2, string3, bl2);
    }
}

