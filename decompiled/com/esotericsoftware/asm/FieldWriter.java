/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.asm;

import com.esotericsoftware.asm.AnnotationVisitor;
import com.esotericsoftware.asm.AnnotationWriter;
import com.esotericsoftware.asm.Attribute;
import com.esotericsoftware.asm.ByteVector;
import com.esotericsoftware.asm.ClassWriter;
import com.esotericsoftware.asm.FieldVisitor;
import com.esotericsoftware.asm.TypePath;

final class FieldWriter
extends FieldVisitor {
    private final ClassWriter b;
    private final int c;
    private final int d;
    private final int e;
    private int f;
    private int g;
    private AnnotationWriter h;
    private AnnotationWriter i;
    private AnnotationWriter k;
    private AnnotationWriter l;
    private Attribute j;

    FieldWriter(ClassWriter classWriter, int n2, String string, String string2, String string3, Object object) {
        super(327680);
        if (classWriter.B == null) {
            classWriter.B = this;
        } else {
            classWriter.C.fv = this;
        }
        classWriter.C = this;
        this.b = classWriter;
        this.c = n2;
        this.d = classWriter.newUTF8(string);
        this.e = classWriter.newUTF8(string2);
        if (string3 != null) {
            this.f = classWriter.newUTF8(string3);
        }
        if (object != null) {
            this.g = classWriter.a((Object)object).a;
        }
    }

    public AnnotationVisitor visitAnnotation(String string, boolean bl2) {
        ByteVector byteVector = new ByteVector();
        byteVector.putShort(this.b.newUTF8(string)).putShort(0);
        AnnotationWriter annotationWriter = new AnnotationWriter(this.b, true, byteVector, byteVector, 2);
        if (bl2) {
            annotationWriter.g = this.h;
            this.h = annotationWriter;
        } else {
            annotationWriter.g = this.i;
            this.i = annotationWriter;
        }
        return annotationWriter;
    }

    public AnnotationVisitor visitTypeAnnotation(int n2, TypePath typePath, String string, boolean bl2) {
        ByteVector byteVector = new ByteVector();
        AnnotationWriter.a(n2, typePath, byteVector);
        byteVector.putShort(this.b.newUTF8(string)).putShort(0);
        AnnotationWriter annotationWriter = new AnnotationWriter(this.b, true, byteVector, byteVector, byteVector.b - 2);
        if (bl2) {
            annotationWriter.g = this.k;
            this.k = annotationWriter;
        } else {
            annotationWriter.g = this.l;
            this.l = annotationWriter;
        }
        return annotationWriter;
    }

    public void visitAttribute(Attribute attribute) {
        attribute.a = this.j;
        this.j = attribute;
    }

    public void visitEnd() {
    }

    int a() {
        int n2 = 8;
        if (this.g != 0) {
            this.b.newUTF8("ConstantValue");
            n2 += 8;
        }
        if ((this.c & 0x1000) != 0 && ((this.b.b & 0xFFFF) < 49 || (this.c & 0x40000) != 0)) {
            this.b.newUTF8("Synthetic");
            n2 += 6;
        }
        if ((this.c & 0x20000) != 0) {
            this.b.newUTF8("Deprecated");
            n2 += 6;
        }
        if (this.f != 0) {
            this.b.newUTF8("Signature");
            n2 += 8;
        }
        if (this.h != null) {
            this.b.newUTF8("RuntimeVisibleAnnotations");
            n2 += 8 + this.h.a();
        }
        if (this.i != null) {
            this.b.newUTF8("RuntimeInvisibleAnnotations");
            n2 += 8 + this.i.a();
        }
        if (this.k != null) {
            this.b.newUTF8("RuntimeVisibleTypeAnnotations");
            n2 += 8 + this.k.a();
        }
        if (this.l != null) {
            this.b.newUTF8("RuntimeInvisibleTypeAnnotations");
            n2 += 8 + this.l.a();
        }
        if (this.j != null) {
            n2 += this.j.a(this.b, null, 0, -1, -1);
        }
        return n2;
    }

    void a(ByteVector byteVector) {
        int n2 = 64;
        int n3 = 0x60000 | (this.c & 0x40000) / 64;
        byteVector.putShort(this.c & ~n3).putShort(this.d).putShort(this.e);
        int n4 = 0;
        if (this.g != 0) {
            ++n4;
        }
        if ((this.c & 0x1000) != 0 && ((this.b.b & 0xFFFF) < 49 || (this.c & 0x40000) != 0)) {
            ++n4;
        }
        if ((this.c & 0x20000) != 0) {
            ++n4;
        }
        if (this.f != 0) {
            ++n4;
        }
        if (this.h != null) {
            ++n4;
        }
        if (this.i != null) {
            ++n4;
        }
        if (this.k != null) {
            ++n4;
        }
        if (this.l != null) {
            ++n4;
        }
        if (this.j != null) {
            n4 += this.j.a();
        }
        byteVector.putShort(n4);
        if (this.g != 0) {
            byteVector.putShort(this.b.newUTF8("ConstantValue"));
            byteVector.putInt(2).putShort(this.g);
        }
        if ((this.c & 0x1000) != 0 && ((this.b.b & 0xFFFF) < 49 || (this.c & 0x40000) != 0)) {
            byteVector.putShort(this.b.newUTF8("Synthetic")).putInt(0);
        }
        if ((this.c & 0x20000) != 0) {
            byteVector.putShort(this.b.newUTF8("Deprecated")).putInt(0);
        }
        if (this.f != 0) {
            byteVector.putShort(this.b.newUTF8("Signature"));
            byteVector.putInt(2).putShort(this.f);
        }
        if (this.h != null) {
            byteVector.putShort(this.b.newUTF8("RuntimeVisibleAnnotations"));
            this.h.a(byteVector);
        }
        if (this.i != null) {
            byteVector.putShort(this.b.newUTF8("RuntimeInvisibleAnnotations"));
            this.i.a(byteVector);
        }
        if (this.k != null) {
            byteVector.putShort(this.b.newUTF8("RuntimeVisibleTypeAnnotations"));
            this.k.a(byteVector);
        }
        if (this.l != null) {
            byteVector.putShort(this.b.newUTF8("RuntimeInvisibleTypeAnnotations"));
            this.l.a(byteVector);
        }
        if (this.j != null) {
            this.j.a(this.b, null, 0, -1, -1, byteVector);
        }
    }
}

