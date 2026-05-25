/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.asm;

import com.esotericsoftware.asm.AnnotationVisitor;
import com.esotericsoftware.asm.AnnotationWriter;
import com.esotericsoftware.asm.Attribute;
import com.esotericsoftware.asm.ByteVector;
import com.esotericsoftware.asm.ClassWriter;
import com.esotericsoftware.asm.Edge;
import com.esotericsoftware.asm.Frame;
import com.esotericsoftware.asm.Handle;
import com.esotericsoftware.asm.Handler;
import com.esotericsoftware.asm.Item;
import com.esotericsoftware.asm.Label;
import com.esotericsoftware.asm.MethodVisitor;
import com.esotericsoftware.asm.Type;
import com.esotericsoftware.asm.TypePath;

class MethodWriter
extends MethodVisitor {
    final ClassWriter b;
    private int c;
    private final int d;
    private final int e;
    private final String f;
    String g;
    int h;
    int i;
    int j;
    int[] k;
    private ByteVector l;
    private AnnotationWriter m;
    private AnnotationWriter n;
    private AnnotationWriter U;
    private AnnotationWriter V;
    private AnnotationWriter[] o;
    private AnnotationWriter[] p;
    private int S;
    private Attribute q;
    private ByteVector r = new ByteVector();
    private int s;
    private int t;
    private int T;
    private int u;
    private ByteVector v;
    private int w;
    private int[] x;
    private int[] z;
    private int A;
    private Handler B;
    private Handler C;
    private int Z;
    private ByteVector $;
    private int D;
    private ByteVector E;
    private int F;
    private ByteVector G;
    private int H;
    private ByteVector I;
    private int Y;
    private AnnotationWriter W;
    private AnnotationWriter X;
    private Attribute J;
    private boolean K;
    private int L;
    private final int M;
    private Label N;
    private Label O;
    private Label P;
    private int Q;
    private int R;

    MethodWriter(ClassWriter classWriter, int n2, String string, String string2, String string3, String[] stringArray, boolean bl2, boolean bl3) {
        super(327680);
        int n3;
        if (classWriter.D == null) {
            classWriter.D = this;
        } else {
            classWriter.E.mv = this;
        }
        classWriter.E = this;
        this.b = classWriter;
        this.c = n2;
        if ("<init>".equals(string)) {
            this.c |= 0x80000;
        }
        this.d = classWriter.newUTF8(string);
        this.e = classWriter.newUTF8(string2);
        this.f = string2;
        this.g = string3;
        if (stringArray != null && stringArray.length > 0) {
            this.j = stringArray.length;
            this.k = new int[this.j];
            for (n3 = 0; n3 < this.j; ++n3) {
                this.k[n3] = classWriter.newClass(stringArray[n3]);
            }
        }
        int n4 = bl3 ? 0 : (this.M = bl2 ? 1 : 2);
        if (bl2 || bl3) {
            n3 = Type.getArgumentsAndReturnSizes(this.f) >> 2;
            if ((n2 & 8) != 0) {
                --n3;
            }
            this.t = n3;
            this.T = n3;
            this.N = new Label();
            this.N.a |= 8;
            this.visitLabel(this.N);
        }
    }

    public void visitParameter(String string, int n2) {
        if (this.$ == null) {
            this.$ = new ByteVector();
        }
        ++this.Z;
        this.$.putShort(string == null ? 0 : this.b.newUTF8(string)).putShort(n2);
    }

    public AnnotationVisitor visitAnnotationDefault() {
        this.l = new ByteVector();
        return new AnnotationWriter(this.b, false, this.l, null, 0);
    }

    public AnnotationVisitor visitAnnotation(String string, boolean bl2) {
        ByteVector byteVector = new ByteVector();
        byteVector.putShort(this.b.newUTF8(string)).putShort(0);
        AnnotationWriter annotationWriter = new AnnotationWriter(this.b, true, byteVector, byteVector, 2);
        if (bl2) {
            annotationWriter.g = this.m;
            this.m = annotationWriter;
        } else {
            annotationWriter.g = this.n;
            this.n = annotationWriter;
        }
        return annotationWriter;
    }

    public AnnotationVisitor visitTypeAnnotation(int n2, TypePath typePath, String string, boolean bl2) {
        ByteVector byteVector = new ByteVector();
        AnnotationWriter.a(n2, typePath, byteVector);
        byteVector.putShort(this.b.newUTF8(string)).putShort(0);
        AnnotationWriter annotationWriter = new AnnotationWriter(this.b, true, byteVector, byteVector, byteVector.b - 2);
        if (bl2) {
            annotationWriter.g = this.U;
            this.U = annotationWriter;
        } else {
            annotationWriter.g = this.V;
            this.V = annotationWriter;
        }
        return annotationWriter;
    }

    public AnnotationVisitor visitParameterAnnotation(int n2, String string, boolean bl2) {
        ByteVector byteVector = new ByteVector();
        if ("Ljava/lang/Synthetic;".equals(string)) {
            this.S = Math.max(this.S, n2 + 1);
            return new AnnotationWriter(this.b, false, byteVector, null, 0);
        }
        byteVector.putShort(this.b.newUTF8(string)).putShort(0);
        AnnotationWriter annotationWriter = new AnnotationWriter(this.b, true, byteVector, byteVector, 2);
        if (bl2) {
            if (this.o == null) {
                this.o = new AnnotationWriter[Type.getArgumentTypes(this.f).length];
            }
            annotationWriter.g = this.o[n2];
            this.o[n2] = annotationWriter;
        } else {
            if (this.p == null) {
                this.p = new AnnotationWriter[Type.getArgumentTypes(this.f).length];
            }
            annotationWriter.g = this.p[n2];
            this.p[n2] = annotationWriter;
        }
        return annotationWriter;
    }

    public void visitAttribute(Attribute attribute) {
        if (attribute.isCodeAttribute()) {
            attribute.a = this.J;
            this.J = attribute;
        } else {
            attribute.a = this.q;
            this.q = attribute;
        }
    }

    public void visitCode() {
    }

    public void visitFrame(int n2, int n3, Object[] objectArray, int n4, Object[] objectArray2) {
        if (this.M == 0) {
            return;
        }
        if (n2 == -1) {
            int n5;
            if (this.x == null) {
                this.f();
            }
            this.T = n3;
            int n6 = this.a(this.r.b, n3, n4);
            for (n5 = 0; n5 < n3; ++n5) {
                this.z[n6++] = objectArray[n5] instanceof String ? 0x1700000 | this.b.int_c((String)objectArray[n5]) : (objectArray[n5] instanceof Integer ? (Integer)objectArray[n5] : 0x1800000 | this.b.a("", ((Label)objectArray[n5]).c));
            }
            for (n5 = 0; n5 < n4; ++n5) {
                this.z[n6++] = objectArray2[n5] instanceof String ? 0x1700000 | this.b.int_c((String)objectArray2[n5]) : (objectArray2[n5] instanceof Integer ? (Integer)objectArray2[n5] : 0x1800000 | this.b.a("", ((Label)objectArray2[n5]).c));
            }
            this.b();
        } else {
            int n7;
            if (this.v == null) {
                this.v = new ByteVector();
                n7 = this.r.b;
            } else {
                n7 = this.r.b - this.w - 1;
                if (n7 < 0) {
                    if (n2 == 3) {
                        return;
                    }
                    throw new IllegalStateException();
                }
            }
            switch (n2) {
                case 0: {
                    int n8;
                    this.T = n3;
                    this.v.putByte(255).putShort(n7).putShort(n3);
                    for (n8 = 0; n8 < n3; ++n8) {
                        this.a(objectArray[n8]);
                    }
                    this.v.putShort(n4);
                    for (n8 = 0; n8 < n4; ++n8) {
                        this.a(objectArray2[n8]);
                    }
                    break;
                }
                case 1: {
                    this.T += n3;
                    this.v.putByte(251 + n3).putShort(n7);
                    for (int i2 = 0; i2 < n3; ++i2) {
                        this.a(objectArray[i2]);
                    }
                    break;
                }
                case 2: {
                    this.T -= n3;
                    this.v.putByte(251 - n3).putShort(n7);
                    break;
                }
                case 3: {
                    if (n7 < 64) {
                        this.v.putByte(n7);
                        break;
                    }
                    this.v.putByte(251).putShort(n7);
                    break;
                }
                case 4: {
                    if (n7 < 64) {
                        this.v.putByte(64 + n7);
                    } else {
                        this.v.putByte(247).putShort(n7);
                    }
                    this.a(objectArray2[0]);
                }
            }
            this.w = this.r.b;
            ++this.u;
        }
        this.s = Math.max(this.s, n4);
        this.t = Math.max(this.t, this.T);
    }

    public void visitInsn(int n2) {
        this.Y = this.r.b;
        this.r.putByte(n2);
        if (this.P != null) {
            if (this.M == 0) {
                this.P.h.a(n2, 0, null, null);
            } else {
                int n3 = this.Q + Frame.a[n2];
                if (n3 > this.R) {
                    this.R = n3;
                }
                this.Q = n3;
            }
            if (n2 >= 172 && n2 <= 177 || n2 == 191) {
                this.e();
            }
        }
    }

    public void visitIntInsn(int n2, int n3) {
        this.Y = this.r.b;
        if (this.P != null) {
            if (this.M == 0) {
                this.P.h.a(n2, n3, null, null);
            } else if (n2 != 188) {
                int n4 = this.Q + 1;
                if (n4 > this.R) {
                    this.R = n4;
                }
                this.Q = n4;
            }
        }
        if (n2 == 17) {
            this.r.b(n2, n3);
        } else {
            this.r.a(n2, n3);
        }
    }

    public void visitVarInsn(int n2, int n3) {
        int n4;
        this.Y = this.r.b;
        if (this.P != null) {
            if (this.M == 0) {
                this.P.h.a(n2, n3, null, null);
            } else if (n2 == 169) {
                this.P.a |= 0x100;
                this.P.f = this.Q;
                this.e();
            } else {
                n4 = this.Q + Frame.a[n2];
                if (n4 > this.R) {
                    this.R = n4;
                }
                this.Q = n4;
            }
        }
        if (this.M != 2 && (n4 = n2 == 22 || n2 == 24 || n2 == 55 || n2 == 57 ? n3 + 2 : n3 + 1) > this.t) {
            this.t = n4;
        }
        if (n3 < 4 && n2 != 169) {
            n4 = n2 < 54 ? 26 + (n2 - 21 << 2) + n3 : 59 + (n2 - 54 << 2) + n3;
            this.r.putByte(n4);
        } else if (n3 >= 256) {
            this.r.putByte(196).b(n2, n3);
        } else {
            this.r.a(n2, n3);
        }
        if (n2 >= 54 && this.M == 0 && this.A > 0) {
            this.visitLabel(new Label());
        }
    }

    public void visitTypeInsn(int n2, String string) {
        this.Y = this.r.b;
        Item item = this.b.a(string);
        if (this.P != null) {
            if (this.M == 0) {
                this.P.h.a(n2, this.r.b, this.b, item);
            } else if (n2 == 187) {
                int n3 = this.Q + 1;
                if (n3 > this.R) {
                    this.R = n3;
                }
                this.Q = n3;
            }
        }
        this.r.b(n2, item.a);
    }

    public void visitFieldInsn(int n2, String string, String string2, String string3) {
        this.Y = this.r.b;
        Item item = this.b.a(string, string2, string3);
        if (this.P != null) {
            if (this.M == 0) {
                this.P.h.a(n2, 0, this.b, item);
            } else {
                int n3;
                char c2 = string3.charAt(0);
                switch (n2) {
                    case 178: {
                        n3 = this.Q + (c2 == 'D' || c2 == 'J' ? 2 : 1);
                        break;
                    }
                    case 179: {
                        n3 = this.Q + (c2 == 'D' || c2 == 'J' ? -2 : -1);
                        break;
                    }
                    case 180: {
                        n3 = this.Q + (c2 == 'D' || c2 == 'J' ? 1 : 0);
                        break;
                    }
                    default: {
                        n3 = this.Q + (c2 == 'D' || c2 == 'J' ? -3 : -2);
                    }
                }
                if (n3 > this.R) {
                    this.R = n3;
                }
                this.Q = n3;
            }
        }
        this.r.b(n2, item.a);
    }

    public void visitMethodInsn(int n2, String string, String string2, String string3, boolean bl2) {
        this.Y = this.r.b;
        Item item = this.b.a(string, string2, string3, bl2);
        int n3 = item.c;
        if (this.P != null) {
            if (this.M == 0) {
                this.P.h.a(n2, 0, this.b, item);
            } else {
                int n4;
                if (n3 == 0) {
                    item.c = n3 = Type.getArgumentsAndReturnSizes(string3);
                }
                if ((n4 = n2 == 184 ? this.Q - (n3 >> 2) + (n3 & 3) + 1 : this.Q - (n3 >> 2) + (n3 & 3)) > this.R) {
                    this.R = n4;
                }
                this.Q = n4;
            }
        }
        if (n2 == 185) {
            if (n3 == 0) {
                item.c = n3 = Type.getArgumentsAndReturnSizes(string3);
            }
            this.r.b(185, item.a).a(n3 >> 2, 0);
        } else {
            this.r.b(n2, item.a);
        }
    }

    public void visitInvokeDynamicInsn(String string, String string2, Handle handle, Object ... objectArray) {
        this.Y = this.r.b;
        Item item = this.b.a(string, string2, handle, objectArray);
        int n2 = item.c;
        if (this.P != null) {
            if (this.M == 0) {
                this.P.h.a(186, 0, this.b, item);
            } else {
                int n3;
                if (n2 == 0) {
                    item.c = n2 = Type.getArgumentsAndReturnSizes(string2);
                }
                if ((n3 = this.Q - (n2 >> 2) + (n2 & 3) + 1) > this.R) {
                    this.R = n3;
                }
                this.Q = n3;
            }
        }
        this.r.b(186, item.a);
        this.r.putShort(0);
    }

    public void visitJumpInsn(int n2, Label label) {
        this.Y = this.r.b;
        Label label2 = null;
        if (this.P != null) {
            if (this.M == 0) {
                this.P.h.a(n2, 0, null, null);
                label.a().a |= 0x10;
                this.a(0, label);
                if (n2 != 167) {
                    label2 = new Label();
                }
            } else if (n2 == 168) {
                if ((label.a & 0x200) == 0) {
                    label.a |= 0x200;
                    ++this.L;
                }
                this.P.a |= 0x80;
                this.a(this.Q + 1, label);
                label2 = new Label();
            } else {
                this.Q += Frame.a[n2];
                this.a(this.Q, label);
            }
        }
        if ((label.a & 2) != 0 && label.c - this.r.b < Short.MIN_VALUE) {
            if (n2 == 167) {
                this.r.putByte(200);
            } else if (n2 == 168) {
                this.r.putByte(201);
            } else {
                if (label2 != null) {
                    label2.a |= 0x10;
                }
                this.r.putByte(n2 <= 166 ? (n2 + 1 ^ 1) - 1 : n2 ^ 1);
                this.r.putShort(8);
                this.r.putByte(200);
            }
            label.a(this, this.r, this.r.b - 1, true);
        } else {
            this.r.putByte(n2);
            label.a(this, this.r, this.r.b - 1, false);
        }
        if (this.P != null) {
            if (label2 != null) {
                this.visitLabel(label2);
            }
            if (n2 == 167) {
                this.e();
            }
        }
    }

    public void visitLabel(Label label) {
        this.K |= label.a(this, this.r.b, this.r.a);
        if ((label.a & 1) != 0) {
            return;
        }
        if (this.M == 0) {
            if (this.P != null) {
                if (label.c == this.P.c) {
                    this.P.a |= label.a & 0x10;
                    label.h = this.P.h;
                    return;
                }
                this.a(0, label);
            }
            this.P = label;
            if (label.h == null) {
                label.h = new Frame();
                label.h.b = label;
            }
            if (this.O != null) {
                if (label.c == this.O.c) {
                    this.O.a |= label.a & 0x10;
                    label.h = this.O.h;
                    this.P = this.O;
                    return;
                }
                this.O.i = label;
            }
            this.O = label;
        } else if (this.M == 1) {
            if (this.P != null) {
                this.P.g = this.R;
                this.a(this.Q, label);
            }
            this.P = label;
            this.Q = 0;
            this.R = 0;
            if (this.O != null) {
                this.O.i = label;
            }
            this.O = label;
        }
    }

    public void visitLdcInsn(Object object) {
        int n2;
        this.Y = this.r.b;
        Item item = this.b.a(object);
        if (this.P != null) {
            if (this.M == 0) {
                this.P.h.a(18, 0, this.b, item);
            } else {
                n2 = item.b == 5 || item.b == 6 ? this.Q + 2 : this.Q + 1;
                if (n2 > this.R) {
                    this.R = n2;
                }
                this.Q = n2;
            }
        }
        n2 = item.a;
        if (item.b == 5 || item.b == 6) {
            this.r.b(20, n2);
        } else if (n2 >= 256) {
            this.r.b(19, n2);
        } else {
            this.r.a(18, n2);
        }
    }

    public void visitIincInsn(int n2, int n3) {
        int n4;
        this.Y = this.r.b;
        if (this.P != null && this.M == 0) {
            this.P.h.a(132, n2, null, null);
        }
        if (this.M != 2 && (n4 = n2 + 1) > this.t) {
            this.t = n4;
        }
        if (n2 > 255 || n3 > 127 || n3 < -128) {
            this.r.putByte(196).b(132, n2).putShort(n3);
        } else {
            this.r.putByte(132).a(n2, n3);
        }
    }

    public void visitTableSwitchInsn(int n2, int n3, Label label, Label ... labelArray) {
        this.Y = this.r.b;
        int n4 = this.r.b;
        this.r.putByte(170);
        this.r.putByteArray(null, 0, (4 - this.r.b % 4) % 4);
        label.a(this, this.r, n4, true);
        this.r.putInt(n2).putInt(n3);
        for (int i2 = 0; i2 < labelArray.length; ++i2) {
            labelArray[i2].a(this, this.r, n4, true);
        }
        this.a(label, labelArray);
    }

    public void visitLookupSwitchInsn(Label label, int[] nArray, Label[] labelArray) {
        this.Y = this.r.b;
        int n2 = this.r.b;
        this.r.putByte(171);
        this.r.putByteArray(null, 0, (4 - this.r.b % 4) % 4);
        label.a(this, this.r, n2, true);
        this.r.putInt(labelArray.length);
        for (int i2 = 0; i2 < labelArray.length; ++i2) {
            this.r.putInt(nArray[i2]);
            labelArray[i2].a(this, this.r, n2, true);
        }
        this.a(label, labelArray);
    }

    private void a(Label label, Label[] labelArray) {
        if (this.P != null) {
            if (this.M == 0) {
                this.P.h.a(171, 0, null, null);
                this.a(0, label);
                label.a().a |= 0x10;
                for (int i2 = 0; i2 < labelArray.length; ++i2) {
                    this.a(0, labelArray[i2]);
                    labelArray[i2].a().a |= 0x10;
                }
            } else {
                --this.Q;
                this.a(this.Q, label);
                for (int i3 = 0; i3 < labelArray.length; ++i3) {
                    this.a(this.Q, labelArray[i3]);
                }
            }
            this.e();
        }
    }

    public void visitMultiANewArrayInsn(String string, int n2) {
        this.Y = this.r.b;
        Item item = this.b.a(string);
        if (this.P != null) {
            if (this.M == 0) {
                this.P.h.a(197, n2, this.b, item);
            } else {
                this.Q += 1 - n2;
            }
        }
        this.r.b(197, item.a).putByte(n2);
    }

    public AnnotationVisitor visitInsnAnnotation(int n2, TypePath typePath, String string, boolean bl2) {
        ByteVector byteVector = new ByteVector();
        n2 = n2 & 0xFF0000FF | this.Y << 8;
        AnnotationWriter.a(n2, typePath, byteVector);
        byteVector.putShort(this.b.newUTF8(string)).putShort(0);
        AnnotationWriter annotationWriter = new AnnotationWriter(this.b, true, byteVector, byteVector, byteVector.b - 2);
        if (bl2) {
            annotationWriter.g = this.W;
            this.W = annotationWriter;
        } else {
            annotationWriter.g = this.X;
            this.X = annotationWriter;
        }
        return annotationWriter;
    }

    public void visitTryCatchBlock(Label label, Label label2, Label label3, String string) {
        ++this.A;
        Handler handler = new Handler();
        handler.a = label;
        handler.b = label2;
        handler.c = label3;
        handler.d = string;
        int n2 = handler.e = string != null ? this.b.newClass(string) : 0;
        if (this.C == null) {
            this.B = handler;
        } else {
            this.C.f = handler;
        }
        this.C = handler;
    }

    public AnnotationVisitor visitTryCatchAnnotation(int n2, TypePath typePath, String string, boolean bl2) {
        ByteVector byteVector = new ByteVector();
        AnnotationWriter.a(n2, typePath, byteVector);
        byteVector.putShort(this.b.newUTF8(string)).putShort(0);
        AnnotationWriter annotationWriter = new AnnotationWriter(this.b, true, byteVector, byteVector, byteVector.b - 2);
        if (bl2) {
            annotationWriter.g = this.W;
            this.W = annotationWriter;
        } else {
            annotationWriter.g = this.X;
            this.X = annotationWriter;
        }
        return annotationWriter;
    }

    public void visitLocalVariable(String string, String string2, String string3, Label label, Label label2, int n2) {
        char c2;
        int n3;
        if (string3 != null) {
            if (this.G == null) {
                this.G = new ByteVector();
            }
            ++this.F;
            this.G.putShort(label.c).putShort(label2.c - label.c).putShort(this.b.newUTF8(string)).putShort(this.b.newUTF8(string3)).putShort(n2);
        }
        if (this.E == null) {
            this.E = new ByteVector();
        }
        ++this.D;
        this.E.putShort(label.c).putShort(label2.c - label.c).putShort(this.b.newUTF8(string)).putShort(this.b.newUTF8(string2)).putShort(n2);
        if (this.M != 2 && (n3 = n2 + ((c2 = string2.charAt(0)) == 'J' || c2 == 'D' ? 2 : 1)) > this.t) {
            this.t = n3;
        }
    }

    public AnnotationVisitor visitLocalVariableAnnotation(int n2, TypePath typePath, Label[] labelArray, Label[] labelArray2, int[] nArray, String string, boolean bl2) {
        int n3;
        ByteVector byteVector = new ByteVector();
        byteVector.putByte(n2 >>> 24).putShort(labelArray.length);
        for (n3 = 0; n3 < labelArray.length; ++n3) {
            byteVector.putShort(labelArray[n3].c).putShort(labelArray2[n3].c - labelArray[n3].c).putShort(nArray[n3]);
        }
        if (typePath == null) {
            byteVector.putByte(0);
        } else {
            n3 = typePath.a[typePath.b] * 2 + 1;
            byteVector.putByteArray(typePath.a, typePath.b, n3);
        }
        byteVector.putShort(this.b.newUTF8(string)).putShort(0);
        AnnotationWriter annotationWriter = new AnnotationWriter(this.b, true, byteVector, byteVector, byteVector.b - 2);
        if (bl2) {
            annotationWriter.g = this.W;
            this.W = annotationWriter;
        } else {
            annotationWriter.g = this.X;
            this.X = annotationWriter;
        }
        return annotationWriter;
    }

    public void visitLineNumber(int n2, Label label) {
        if (this.I == null) {
            this.I = new ByteVector();
        }
        ++this.H;
        this.I.putShort(label.c);
        this.I.putShort(n2);
    }

    public void visitMaxs(int n2, int n3) {
        if (this.K) {
            this.d();
        }
        if (this.M == 0) {
            int n4;
            Object object;
            Type[] typeArray;
            Object object2;
            Handler handler = this.B;
            while (handler != null) {
                object2 = handler.a.a();
                typeArray = handler.c.a();
                Label label = handler.b.a();
                object = handler.d == null ? "java/lang/Throwable" : handler.d;
                int n5 = 0x1700000 | this.b.int_c((String)object);
                typeArray.a |= 0x10;
                while (object2 != label) {
                    Edge edge = new Edge();
                    edge.a = n5;
                    edge.b = typeArray;
                    edge.c = ((Label)object2).j;
                    ((Label)object2).j = edge;
                    object2 = ((Label)object2).i;
                }
                handler = handler.f;
            }
            object2 = this.N.h;
            typeArray = Type.getArgumentTypes(this.f);
            ((Frame)object2).a(this.b, this.c, typeArray, this.t);
            this.b((Frame)object2);
            int n6 = 0;
            object = this.N;
            while (object != null) {
                Object object3 = object;
                object = ((Label)object).k;
                ((Label)object3).k = null;
                object2 = ((Label)object3).h;
                if ((((Label)object3).a & 0x10) != 0) {
                    ((Label)object3).a |= 0x20;
                }
                ((Label)object3).a |= 0x40;
                int n7 = ((Frame)object2).d.length + ((Label)object3).g;
                if (n7 > n6) {
                    n6 = n7;
                }
                Edge edge = ((Label)object3).j;
                while (edge != null) {
                    Label label = edge.b.a();
                    n4 = ((Frame)object2).a(this.b, label.h, edge.a) ? 1 : 0;
                    if (n4 != 0 && label.k == null) {
                        label.k = object;
                        object = label;
                    }
                    edge = edge.c;
                }
            }
            Label label = this.N;
            while (label != null) {
                int n8;
                Label label2;
                int n9;
                object2 = label.h;
                if ((label.a & 0x20) != 0) {
                    this.b((Frame)object2);
                }
                if ((label.a & 0x40) == 0 && (n9 = ((label2 = label.i) == null ? this.r.b : label2.c) - 1) >= (n8 = label.c)) {
                    n6 = Math.max(n6, 1);
                    for (n4 = n8; n4 < n9; ++n4) {
                        this.r.a[n4] = 0;
                    }
                    this.r.a[n9] = -65;
                    n4 = this.a(n8, 0, 1);
                    this.z[n4] = 0x1700000 | this.b.int_c("java/lang/Throwable");
                    this.b();
                    this.B = Handler.a(this.B, label, label2);
                }
                label = label.i;
            }
            handler = this.B;
            this.A = 0;
            while (handler != null) {
                ++this.A;
                handler = handler.f;
            }
            this.s = n6;
        } else if (this.M == 1) {
            Object object;
            Label label;
            Label label3;
            Handler handler = this.B;
            while (handler != null) {
                Label label4 = handler.a;
                label3 = handler.c;
                label = handler.b;
                while (label4 != label) {
                    object = new Edge();
                    ((Edge)object).a = Integer.MAX_VALUE;
                    ((Edge)object).b = label3;
                    if ((label4.a & 0x80) == 0) {
                        ((Edge)object).c = label4.j;
                        label4.j = object;
                    } else {
                        ((Edge)object).c = label4.j.c.c;
                        label4.j.c.c = object;
                    }
                    label4 = label4.i;
                }
                handler = handler.f;
            }
            if (this.L > 0) {
                int n10 = 0;
                this.N.b(null, 1L, this.L);
                label3 = this.N;
                while (label3 != null) {
                    if ((label3.a & 0x80) != 0) {
                        label = label3.j.c.b;
                        if ((label.a & 0x400) == 0) {
                            label.b(null, (long)(++n10) / 32L << 32 | 1L << n10 % 32, this.L);
                        }
                    }
                    label3 = label3.i;
                }
                label3 = this.N;
                while (label3 != null) {
                    if ((label3.a & 0x80) != 0) {
                        label = this.N;
                        while (label != null) {
                            label.a &= 0xFFFFF7FF;
                            label = label.i;
                        }
                        object = label3.j.c.b;
                        ((Label)object).b(label3, 0L, this.L);
                    }
                    label3 = label3.i;
                }
            }
            int n11 = 0;
            label3 = this.N;
            while (label3 != null) {
                label = label3;
                label3 = label3.k;
                int n12 = label.f;
                int n13 = n12 + label.g;
                if (n13 > n11) {
                    n11 = n13;
                }
                Edge edge = label.j;
                if ((label.a & 0x80) != 0) {
                    edge = edge.c;
                }
                while (edge != null) {
                    label = edge.b;
                    if ((label.a & 8) == 0) {
                        label.f = edge.a == Integer.MAX_VALUE ? 1 : n12 + edge.a;
                        label.a |= 8;
                        label.k = label3;
                        label3 = label;
                    }
                    edge = edge.c;
                }
            }
            this.s = Math.max(n2, n11);
        } else {
            this.s = n2;
            this.t = n3;
        }
    }

    public void visitEnd() {
    }

    private void a(int n2, Label label) {
        Edge edge = new Edge();
        edge.a = n2;
        edge.b = label;
        edge.c = this.P.j;
        this.P.j = edge;
    }

    private void e() {
        if (this.M == 0) {
            Label label = new Label();
            label.h = new Frame();
            label.h.b = label;
            label.a(this, this.r.b, this.r.a);
            this.O.i = label;
            this.O = label;
        } else {
            this.P.g = this.R;
        }
        this.P = null;
    }

    private void b(Frame frame) {
        int n2;
        int n3;
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        int[] nArray = frame.c;
        int[] nArray2 = frame.d;
        for (n3 = 0; n3 < nArray.length; ++n3) {
            n2 = nArray[n3];
            if (n2 == 0x1000000) {
                ++n4;
            } else {
                n5 += n4 + 1;
                n4 = 0;
            }
            if (n2 != 0x1000004 && n2 != 0x1000003) continue;
            ++n3;
        }
        for (n3 = 0; n3 < nArray2.length; ++n3) {
            n2 = nArray2[n3];
            ++n6;
            if (n2 != 0x1000004 && n2 != 0x1000003) continue;
            ++n3;
        }
        int n7 = this.a(frame.b.c, n5, n6);
        n3 = 0;
        while (n5 > 0) {
            n2 = nArray[n3];
            this.z[n7++] = n2;
            if (n2 == 0x1000004 || n2 == 0x1000003) {
                ++n3;
            }
            ++n3;
            --n5;
        }
        for (n3 = 0; n3 < nArray2.length; ++n3) {
            n2 = nArray2[n3];
            this.z[n7++] = n2;
            if (n2 != 0x1000004 && n2 != 0x1000003) continue;
            ++n3;
        }
        this.b();
    }

    private void f() {
        int n2 = this.a(0, this.f.length() + 1, 0);
        if ((this.c & 8) == 0) {
            this.z[n2++] = (this.c & 0x80000) == 0 ? 0x1700000 | this.b.int_c(this.b.I) : 6;
        }
        int n3 = 1;
        block8: while (true) {
            int n4 = n3;
            switch (this.f.charAt(n3++)) {
                case 'B': 
                case 'C': 
                case 'I': 
                case 'S': 
                case 'Z': {
                    this.z[n2++] = 1;
                    continue block8;
                }
                case 'F': {
                    this.z[n2++] = 2;
                    continue block8;
                }
                case 'J': {
                    this.z[n2++] = 4;
                    continue block8;
                }
                case 'D': {
                    this.z[n2++] = 3;
                    continue block8;
                }
                case '[': {
                    while (this.f.charAt(n3) == '[') {
                        ++n3;
                    }
                    if (this.f.charAt(n3) == 'L') {
                        ++n3;
                        while (this.f.charAt(n3) != ';') {
                            ++n3;
                        }
                    }
                    this.z[n2++] = 0x1700000 | this.b.int_c(this.f.substring(n4, ++n3));
                    continue block8;
                }
                case 'L': {
                    while (this.f.charAt(n3) != ';') {
                        ++n3;
                    }
                    this.z[n2++] = 0x1700000 | this.b.int_c(this.f.substring(n4 + 1, n3++));
                    continue block8;
                }
            }
            break;
        }
        this.z[1] = n2 - 3;
        this.b();
    }

    private int a(int n2, int n3, int n4) {
        int n5 = 3 + n3 + n4;
        if (this.z == null || this.z.length < n5) {
            this.z = new int[n5];
        }
        this.z[0] = n2;
        this.z[1] = n3;
        this.z[2] = n4;
        return 3;
    }

    private void b() {
        if (this.x != null) {
            if (this.v == null) {
                this.v = new ByteVector();
            }
            this.c();
            ++this.u;
        }
        this.x = this.z;
        this.z = null;
    }

    private void c() {
        int n2 = this.z[1];
        int n3 = this.z[2];
        if ((this.b.b & 0xFFFF) < 50) {
            this.v.putShort(this.z[0]).putShort(n2);
            this.a(3, 3 + n2);
            this.v.putShort(n3);
            this.a(3 + n2, 3 + n2 + n3);
            return;
        }
        int n4 = this.x[1];
        int n5 = 255;
        int n6 = 0;
        int n7 = this.u == 0 ? this.z[0] : this.z[0] - this.x[0] - 1;
        if (n3 == 0) {
            n6 = n2 - n4;
            switch (n6) {
                case -3: 
                case -2: 
                case -1: {
                    n5 = 248;
                    n4 = n2;
                    break;
                }
                case 0: {
                    n5 = n7 < 64 ? 0 : 251;
                    break;
                }
                case 1: 
                case 2: 
                case 3: {
                    n5 = 252;
                }
            }
        } else if (n2 == n4 && n3 == 1) {
            int n8 = n5 = n7 < 63 ? 64 : 247;
        }
        if (n5 != 255) {
            int n9 = 3;
            for (int i2 = 0; i2 < n4; ++i2) {
                if (this.z[n9] != this.x[n9]) {
                    n5 = 255;
                    break;
                }
                ++n9;
            }
        }
        switch (n5) {
            case 0: {
                this.v.putByte(n7);
                break;
            }
            case 64: {
                this.v.putByte(64 + n7);
                this.a(3 + n2, 4 + n2);
                break;
            }
            case 247: {
                this.v.putByte(247).putShort(n7);
                this.a(3 + n2, 4 + n2);
                break;
            }
            case 251: {
                this.v.putByte(251).putShort(n7);
                break;
            }
            case 248: {
                this.v.putByte(251 + n6).putShort(n7);
                break;
            }
            case 252: {
                this.v.putByte(251 + n6).putShort(n7);
                this.a(3 + n4, 3 + n2);
                break;
            }
            default: {
                this.v.putByte(255).putShort(n7).putShort(n2);
                this.a(3, 3 + n2);
                this.v.putShort(n3);
                this.a(3 + n2, 3 + n2 + n3);
            }
        }
    }

    private void a(int n2, int n3) {
        for (int i2 = n2; i2 < n3; ++i2) {
            int n4 = this.z[i2];
            int n5 = n4 & 0xF0000000;
            if (n5 == 0) {
                int n6 = n4 & 0xFFFFF;
                switch (n4 & 0xFF00000) {
                    case 0x1700000: {
                        this.v.putByte(7).putShort(this.b.newClass(this.b.H[n6].g));
                        break;
                    }
                    case 0x1800000: {
                        this.v.putByte(8).putShort(this.b.H[n6].c);
                        break;
                    }
                    default: {
                        this.v.putByte(n6);
                        break;
                    }
                }
                continue;
            }
            StringBuffer stringBuffer = new StringBuffer();
            n5 >>= 28;
            while (n5-- > 0) {
                stringBuffer.append('[');
            }
            if ((n4 & 0xFF00000) == 0x1700000) {
                stringBuffer.append('L');
                stringBuffer.append(this.b.H[n4 & 0xFFFFF].g);
                stringBuffer.append(';');
            } else {
                switch (n4 & 0xF) {
                    case 1: {
                        stringBuffer.append('I');
                        break;
                    }
                    case 2: {
                        stringBuffer.append('F');
                        break;
                    }
                    case 3: {
                        stringBuffer.append('D');
                        break;
                    }
                    case 9: {
                        stringBuffer.append('Z');
                        break;
                    }
                    case 10: {
                        stringBuffer.append('B');
                        break;
                    }
                    case 11: {
                        stringBuffer.append('C');
                        break;
                    }
                    case 12: {
                        stringBuffer.append('S');
                        break;
                    }
                    default: {
                        stringBuffer.append('J');
                    }
                }
            }
            this.v.putByte(7).putShort(this.b.newClass(stringBuffer.toString()));
        }
    }

    private void a(Object object) {
        if (object instanceof String) {
            this.v.putByte(7).putShort(this.b.newClass((String)object));
        } else if (object instanceof Integer) {
            this.v.putByte((Integer)object);
        } else {
            this.v.putByte(8).putShort(((Label)object).c);
        }
    }

    final int a() {
        int n2;
        if (this.h != 0) {
            return 6 + this.i;
        }
        int n3 = 8;
        if (this.r.b > 0) {
            if (this.r.b > 65535) {
                throw new RuntimeException("Method code too large!");
            }
            this.b.newUTF8("Code");
            n3 += 18 + this.r.b + 8 * this.A;
            if (this.E != null) {
                this.b.newUTF8("LocalVariableTable");
                n3 += 8 + this.E.b;
            }
            if (this.G != null) {
                this.b.newUTF8("LocalVariableTypeTable");
                n3 += 8 + this.G.b;
            }
            if (this.I != null) {
                this.b.newUTF8("LineNumberTable");
                n3 += 8 + this.I.b;
            }
            if (this.v != null) {
                n2 = (this.b.b & 0xFFFF) >= 50 ? 1 : 0;
                this.b.newUTF8(n2 != 0 ? "StackMapTable" : "StackMap");
                n3 += 8 + this.v.b;
            }
            if (this.W != null) {
                this.b.newUTF8("RuntimeVisibleTypeAnnotations");
                n3 += 8 + this.W.a();
            }
            if (this.X != null) {
                this.b.newUTF8("RuntimeInvisibleTypeAnnotations");
                n3 += 8 + this.X.a();
            }
            if (this.J != null) {
                n3 += this.J.a(this.b, this.r.a, this.r.b, this.s, this.t);
            }
        }
        if (this.j > 0) {
            this.b.newUTF8("Exceptions");
            n3 += 8 + 2 * this.j;
        }
        if ((this.c & 0x1000) != 0 && ((this.b.b & 0xFFFF) < 49 || (this.c & 0x40000) != 0)) {
            this.b.newUTF8("Synthetic");
            n3 += 6;
        }
        if ((this.c & 0x20000) != 0) {
            this.b.newUTF8("Deprecated");
            n3 += 6;
        }
        if (this.g != null) {
            this.b.newUTF8("Signature");
            this.b.newUTF8(this.g);
            n3 += 8;
        }
        if (this.$ != null) {
            this.b.newUTF8("MethodParameters");
            n3 += 7 + this.$.b;
        }
        if (this.l != null) {
            this.b.newUTF8("AnnotationDefault");
            n3 += 6 + this.l.b;
        }
        if (this.m != null) {
            this.b.newUTF8("RuntimeVisibleAnnotations");
            n3 += 8 + this.m.a();
        }
        if (this.n != null) {
            this.b.newUTF8("RuntimeInvisibleAnnotations");
            n3 += 8 + this.n.a();
        }
        if (this.U != null) {
            this.b.newUTF8("RuntimeVisibleTypeAnnotations");
            n3 += 8 + this.U.a();
        }
        if (this.V != null) {
            this.b.newUTF8("RuntimeInvisibleTypeAnnotations");
            n3 += 8 + this.V.a();
        }
        if (this.o != null) {
            this.b.newUTF8("RuntimeVisibleParameterAnnotations");
            n3 += 7 + 2 * (this.o.length - this.S);
            for (n2 = this.o.length - 1; n2 >= this.S; --n2) {
                n3 += this.o[n2] == null ? 0 : this.o[n2].a();
            }
        }
        if (this.p != null) {
            this.b.newUTF8("RuntimeInvisibleParameterAnnotations");
            n3 += 7 + 2 * (this.p.length - this.S);
            for (n2 = this.p.length - 1; n2 >= this.S; --n2) {
                n3 += this.p[n2] == null ? 0 : this.p[n2].a();
            }
        }
        if (this.q != null) {
            n3 += this.q.a(this.b, null, 0, -1, -1);
        }
        return n3;
    }

    final void a(ByteVector byteVector) {
        int n2;
        int n3 = 64;
        int n4 = 0xE0000 | (this.c & 0x40000) / 64;
        byteVector.putShort(this.c & ~n4).putShort(this.d).putShort(this.e);
        if (this.h != 0) {
            byteVector.putByteArray(this.b.M.b, this.h, this.i);
            return;
        }
        int n5 = 0;
        if (this.r.b > 0) {
            ++n5;
        }
        if (this.j > 0) {
            ++n5;
        }
        if ((this.c & 0x1000) != 0 && ((this.b.b & 0xFFFF) < 49 || (this.c & 0x40000) != 0)) {
            ++n5;
        }
        if ((this.c & 0x20000) != 0) {
            ++n5;
        }
        if (this.g != null) {
            ++n5;
        }
        if (this.$ != null) {
            ++n5;
        }
        if (this.l != null) {
            ++n5;
        }
        if (this.m != null) {
            ++n5;
        }
        if (this.n != null) {
            ++n5;
        }
        if (this.U != null) {
            ++n5;
        }
        if (this.V != null) {
            ++n5;
        }
        if (this.o != null) {
            ++n5;
        }
        if (this.p != null) {
            ++n5;
        }
        if (this.q != null) {
            n5 += this.q.a();
        }
        byteVector.putShort(n5);
        if (this.r.b > 0) {
            n2 = 12 + this.r.b + 8 * this.A;
            if (this.E != null) {
                n2 += 8 + this.E.b;
            }
            if (this.G != null) {
                n2 += 8 + this.G.b;
            }
            if (this.I != null) {
                n2 += 8 + this.I.b;
            }
            if (this.v != null) {
                n2 += 8 + this.v.b;
            }
            if (this.W != null) {
                n2 += 8 + this.W.a();
            }
            if (this.X != null) {
                n2 += 8 + this.X.a();
            }
            if (this.J != null) {
                n2 += this.J.a(this.b, this.r.a, this.r.b, this.s, this.t);
            }
            byteVector.putShort(this.b.newUTF8("Code")).putInt(n2);
            byteVector.putShort(this.s).putShort(this.t);
            byteVector.putInt(this.r.b).putByteArray(this.r.a, 0, this.r.b);
            byteVector.putShort(this.A);
            if (this.A > 0) {
                Handler handler = this.B;
                while (handler != null) {
                    byteVector.putShort(handler.a.c).putShort(handler.b.c).putShort(handler.c.c).putShort(handler.e);
                    handler = handler.f;
                }
            }
            n5 = 0;
            if (this.E != null) {
                ++n5;
            }
            if (this.G != null) {
                ++n5;
            }
            if (this.I != null) {
                ++n5;
            }
            if (this.v != null) {
                ++n5;
            }
            if (this.W != null) {
                ++n5;
            }
            if (this.X != null) {
                ++n5;
            }
            if (this.J != null) {
                n5 += this.J.a();
            }
            byteVector.putShort(n5);
            if (this.E != null) {
                byteVector.putShort(this.b.newUTF8("LocalVariableTable"));
                byteVector.putInt(this.E.b + 2).putShort(this.D);
                byteVector.putByteArray(this.E.a, 0, this.E.b);
            }
            if (this.G != null) {
                byteVector.putShort(this.b.newUTF8("LocalVariableTypeTable"));
                byteVector.putInt(this.G.b + 2).putShort(this.F);
                byteVector.putByteArray(this.G.a, 0, this.G.b);
            }
            if (this.I != null) {
                byteVector.putShort(this.b.newUTF8("LineNumberTable"));
                byteVector.putInt(this.I.b + 2).putShort(this.H);
                byteVector.putByteArray(this.I.a, 0, this.I.b);
            }
            if (this.v != null) {
                boolean bl2 = (this.b.b & 0xFFFF) >= 50;
                byteVector.putShort(this.b.newUTF8(bl2 ? "StackMapTable" : "StackMap"));
                byteVector.putInt(this.v.b + 2).putShort(this.u);
                byteVector.putByteArray(this.v.a, 0, this.v.b);
            }
            if (this.W != null) {
                byteVector.putShort(this.b.newUTF8("RuntimeVisibleTypeAnnotations"));
                this.W.a(byteVector);
            }
            if (this.X != null) {
                byteVector.putShort(this.b.newUTF8("RuntimeInvisibleTypeAnnotations"));
                this.X.a(byteVector);
            }
            if (this.J != null) {
                this.J.a(this.b, this.r.a, this.r.b, this.t, this.s, byteVector);
            }
        }
        if (this.j > 0) {
            byteVector.putShort(this.b.newUTF8("Exceptions")).putInt(2 * this.j + 2);
            byteVector.putShort(this.j);
            for (n2 = 0; n2 < this.j; ++n2) {
                byteVector.putShort(this.k[n2]);
            }
        }
        if ((this.c & 0x1000) != 0 && ((this.b.b & 0xFFFF) < 49 || (this.c & 0x40000) != 0)) {
            byteVector.putShort(this.b.newUTF8("Synthetic")).putInt(0);
        }
        if ((this.c & 0x20000) != 0) {
            byteVector.putShort(this.b.newUTF8("Deprecated")).putInt(0);
        }
        if (this.g != null) {
            byteVector.putShort(this.b.newUTF8("Signature")).putInt(2).putShort(this.b.newUTF8(this.g));
        }
        if (this.$ != null) {
            byteVector.putShort(this.b.newUTF8("MethodParameters"));
            byteVector.putInt(this.$.b + 1).putByte(this.Z);
            byteVector.putByteArray(this.$.a, 0, this.$.b);
        }
        if (this.l != null) {
            byteVector.putShort(this.b.newUTF8("AnnotationDefault"));
            byteVector.putInt(this.l.b);
            byteVector.putByteArray(this.l.a, 0, this.l.b);
        }
        if (this.m != null) {
            byteVector.putShort(this.b.newUTF8("RuntimeVisibleAnnotations"));
            this.m.a(byteVector);
        }
        if (this.n != null) {
            byteVector.putShort(this.b.newUTF8("RuntimeInvisibleAnnotations"));
            this.n.a(byteVector);
        }
        if (this.U != null) {
            byteVector.putShort(this.b.newUTF8("RuntimeVisibleTypeAnnotations"));
            this.U.a(byteVector);
        }
        if (this.V != null) {
            byteVector.putShort(this.b.newUTF8("RuntimeInvisibleTypeAnnotations"));
            this.V.a(byteVector);
        }
        if (this.o != null) {
            byteVector.putShort(this.b.newUTF8("RuntimeVisibleParameterAnnotations"));
            AnnotationWriter.a(this.o, this.S, byteVector);
        }
        if (this.p != null) {
            byteVector.putShort(this.b.newUTF8("RuntimeInvisibleParameterAnnotations"));
            AnnotationWriter.a(this.p, this.S, byteVector);
        }
        if (this.q != null) {
            this.q.a(this.b, null, 0, -1, -1, byteVector);
        }
    }

    private void d() {
        int n2;
        Object[] objectArray;
        Object object;
        int n3;
        int n4;
        int n5;
        int n6;
        byte[] byArray = this.r.a;
        int[] nArray = new int[]{};
        int[] nArray2 = new int[]{};
        boolean[] blArray = new boolean[this.r.b];
        int n7 = 3;
        do {
            if (n7 == 3) {
                n7 = 2;
            }
            n6 = 0;
            while (n6 < byArray.length) {
                int n8 = byArray[n6] & 0xFF;
                n5 = 0;
                switch (ClassWriter.a[n8]) {
                    case 0: 
                    case 4: {
                        ++n6;
                        break;
                    }
                    case 9: {
                        if (n8 > 201) {
                            n8 = n8 < 218 ? n8 - 49 : n8 - 20;
                            n4 = n6 + MethodWriter.c(byArray, n6 + 1);
                        } else {
                            n4 = n6 + MethodWriter.b(byArray, n6 + 1);
                        }
                        n3 = MethodWriter.a(nArray, nArray2, n6, n4);
                        if (!(n3 >= Short.MIN_VALUE && n3 <= Short.MAX_VALUE || blArray[n6])) {
                            n5 = n8 == 167 || n8 == 168 ? 2 : 5;
                            blArray[n6] = true;
                        }
                        n6 += 3;
                        break;
                    }
                    case 10: {
                        n6 += 5;
                        break;
                    }
                    case 14: {
                        if (n7 == 1) {
                            n3 = MethodWriter.a(nArray, nArray2, 0, n6);
                            n5 = -(n3 & 3);
                        } else if (!blArray[n6]) {
                            n5 = n6 & 3;
                            blArray[n6] = true;
                        }
                        n6 = n6 + 4 - (n6 & 3);
                        n6 += 4 * (MethodWriter.a(byArray, n6 + 8) - MethodWriter.a(byArray, n6 + 4) + 1) + 12;
                        break;
                    }
                    case 15: {
                        if (n7 == 1) {
                            n3 = MethodWriter.a(nArray, nArray2, 0, n6);
                            n5 = -(n3 & 3);
                        } else if (!blArray[n6]) {
                            n5 = n6 & 3;
                            blArray[n6] = true;
                        }
                        n6 = n6 + 4 - (n6 & 3);
                        n6 += 8 * MethodWriter.a(byArray, n6 + 4) + 8;
                        break;
                    }
                    case 17: {
                        n8 = byArray[n6 + 1] & 0xFF;
                        if (n8 == 132) {
                            n6 += 6;
                            break;
                        }
                        n6 += 4;
                        break;
                    }
                    case 1: 
                    case 3: 
                    case 11: {
                        n6 += 2;
                        break;
                    }
                    case 2: 
                    case 5: 
                    case 6: 
                    case 12: 
                    case 13: {
                        n6 += 3;
                        break;
                    }
                    case 7: 
                    case 8: {
                        n6 += 5;
                        break;
                    }
                    default: {
                        n6 += 4;
                    }
                }
                if (n5 == 0) continue;
                object = new int[nArray.length + 1];
                objectArray = new int[nArray2.length + 1];
                System.arraycopy(nArray, 0, object, 0, nArray.length);
                System.arraycopy(nArray2, 0, objectArray, 0, nArray2.length);
                object[nArray.length] = n6;
                objectArray[nArray2.length] = n5;
                nArray = object;
                nArray2 = objectArray;
                if (n5 <= 0) continue;
                n7 = 3;
            }
            if (n7 >= 3) continue;
            --n7;
        } while (n7 != 0);
        ByteVector byteVector = new ByteVector(this.r.b);
        n6 = 0;
        block24: while (n6 < this.r.b) {
            n5 = byArray[n6] & 0xFF;
            switch (ClassWriter.a[n5]) {
                case 0: 
                case 4: {
                    byteVector.putByte(n5);
                    ++n6;
                    continue block24;
                }
                case 9: {
                    if (n5 > 201) {
                        n5 = n5 < 218 ? n5 - 49 : n5 - 20;
                        n4 = n6 + MethodWriter.c(byArray, n6 + 1);
                    } else {
                        n4 = n6 + MethodWriter.b(byArray, n6 + 1);
                    }
                    n3 = MethodWriter.a(nArray, nArray2, n6, n4);
                    if (blArray[n6]) {
                        if (n5 == 167) {
                            byteVector.putByte(200);
                        } else if (n5 == 168) {
                            byteVector.putByte(201);
                        } else {
                            byteVector.putByte(n5 <= 166 ? (n5 + 1 ^ 1) - 1 : n5 ^ 1);
                            byteVector.putShort(8);
                            byteVector.putByte(200);
                            n3 -= 3;
                        }
                        byteVector.putInt(n3);
                    } else {
                        byteVector.putByte(n5);
                        byteVector.putShort(n3);
                    }
                    n6 += 3;
                    continue block24;
                }
                case 10: {
                    n4 = n6 + MethodWriter.a(byArray, n6 + 1);
                    n3 = MethodWriter.a(nArray, nArray2, n6, n4);
                    byteVector.putByte(n5);
                    byteVector.putInt(n3);
                    n6 += 5;
                    continue block24;
                }
                case 14: {
                    int n9 = n6;
                    n6 = n6 + 4 - (n9 & 3);
                    byteVector.putByte(170);
                    byteVector.putByteArray(null, 0, (4 - byteVector.b % 4) % 4);
                    n4 = n9 + MethodWriter.a(byArray, n6);
                    n3 = MethodWriter.a(nArray, nArray2, n9, n4);
                    byteVector.putInt(n3);
                    int n10 = MethodWriter.a(byArray, n6 += 4);
                    byteVector.putInt(n10);
                    byteVector.putInt(MethodWriter.a(byArray, (n6 += 4) - 4));
                    for (n10 = MethodWriter.a(byArray, n6 += 4) - n10 + 1; n10 > 0; --n10) {
                        n4 = n9 + MethodWriter.a(byArray, n6);
                        n6 += 4;
                        n3 = MethodWriter.a(nArray, nArray2, n9, n4);
                        byteVector.putInt(n3);
                    }
                    continue block24;
                }
                case 15: {
                    int n10;
                    int n9 = n6;
                    n6 = n6 + 4 - (n9 & 3);
                    byteVector.putByte(171);
                    byteVector.putByteArray(null, 0, (4 - byteVector.b % 4) % 4);
                    n4 = n9 + MethodWriter.a(byArray, n6);
                    n3 = MethodWriter.a(nArray, nArray2, n9, n4);
                    byteVector.putInt(n3);
                    n6 += 4;
                    byteVector.putInt(n10);
                    for (n10 = MethodWriter.a(byArray, n6 += 4); n10 > 0; --n10) {
                        byteVector.putInt(MethodWriter.a(byArray, n6));
                        n4 = n9 + MethodWriter.a(byArray, n6 += 4);
                        n6 += 4;
                        n3 = MethodWriter.a(nArray, nArray2, n9, n4);
                        byteVector.putInt(n3);
                    }
                    continue block24;
                }
                case 17: {
                    n5 = byArray[n6 + 1] & 0xFF;
                    if (n5 == 132) {
                        byteVector.putByteArray(byArray, n6, 6);
                        n6 += 6;
                        continue block24;
                    }
                    byteVector.putByteArray(byArray, n6, 4);
                    n6 += 4;
                    continue block24;
                }
                case 1: 
                case 3: 
                case 11: {
                    byteVector.putByteArray(byArray, n6, 2);
                    n6 += 2;
                    continue block24;
                }
                case 2: 
                case 5: 
                case 6: 
                case 12: 
                case 13: {
                    byteVector.putByteArray(byArray, n6, 3);
                    n6 += 3;
                    continue block24;
                }
                case 7: 
                case 8: {
                    byteVector.putByteArray(byArray, n6, 5);
                    n6 += 5;
                    continue block24;
                }
            }
            byteVector.putByteArray(byArray, n6, 4);
            n6 += 4;
        }
        if (this.M == 0) {
            Label label = this.N;
            while (label != null) {
                n6 = label.c - 3;
                if (n6 >= 0 && blArray[n6]) {
                    label.a |= 0x10;
                }
                MethodWriter.a(nArray, nArray2, label);
                label = label.i;
            }
            if (this.b.H != null) {
                for (n2 = 0; n2 < this.b.H.length; ++n2) {
                    object = this.b.H[n2];
                    if (object == null || object.b != 31) continue;
                    object.c = MethodWriter.a(nArray, nArray2, 0, object.c);
                }
            }
        } else if (this.u > 0) {
            this.b.L = true;
        }
        Handler handler = this.B;
        while (handler != null) {
            MethodWriter.a(nArray, nArray2, handler.a);
            MethodWriter.a(nArray, nArray2, handler.b);
            MethodWriter.a(nArray, nArray2, handler.c);
            handler = handler.f;
        }
        for (n2 = 0; n2 < 2; ++n2) {
            object = n2 == 0 ? this.E : this.G;
            if (object == null) continue;
            byArray = object.a;
            for (n6 = 0; n6 < object.b; n6 += 10) {
                n4 = MethodWriter.c(byArray, n6);
                n3 = MethodWriter.a(nArray, nArray2, 0, n4);
                MethodWriter.a(byArray, n6, n3);
                n3 = MethodWriter.a(nArray, nArray2, 0, n4 += MethodWriter.c(byArray, n6 + 2)) - n3;
                MethodWriter.a(byArray, n6 + 2, n3);
            }
        }
        if (this.I != null) {
            byArray = this.I.a;
            for (n6 = 0; n6 < this.I.b; n6 += 4) {
                MethodWriter.a(byArray, n6, MethodWriter.a(nArray, nArray2, 0, MethodWriter.c(byArray, n6)));
            }
        }
        object = this.J;
        while (object != null) {
            objectArray = object.getLabels();
            if (objectArray != null) {
                for (n2 = objectArray.length - 1; n2 >= 0; --n2) {
                    MethodWriter.a(nArray, nArray2, (Label)objectArray[n2]);
                }
            }
            object = object.a;
        }
        this.r = byteVector;
    }

    static int c(byte[] byArray, int n2) {
        return (byArray[n2] & 0xFF) << 8 | byArray[n2 + 1] & 0xFF;
    }

    static short b(byte[] byArray, int n2) {
        return (short)((byArray[n2] & 0xFF) << 8 | byArray[n2 + 1] & 0xFF);
    }

    static int a(byte[] byArray, int n2) {
        return (byArray[n2] & 0xFF) << 24 | (byArray[n2 + 1] & 0xFF) << 16 | (byArray[n2 + 2] & 0xFF) << 8 | byArray[n2 + 3] & 0xFF;
    }

    static void a(byte[] byArray, int n2, int n3) {
        byArray[n2] = (byte)(n3 >>> 8);
        byArray[n2 + 1] = (byte)n3;
    }

    static int a(int[] nArray, int[] nArray2, int n2, int n3) {
        int n4 = n3 - n2;
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            if (n2 < nArray[i2] && nArray[i2] <= n3) {
                n4 += nArray2[i2];
                continue;
            }
            if (n3 >= nArray[i2] || nArray[i2] > n2) continue;
            n4 -= nArray2[i2];
        }
        return n4;
    }

    static void a(int[] nArray, int[] nArray2, Label label) {
        if ((label.a & 4) == 0) {
            label.c = MethodWriter.a(nArray, nArray2, 0, label.c);
            label.a |= 4;
        }
    }
}

