/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.asm;

import com.esotericsoftware.asm.AnnotationVisitor;
import com.esotericsoftware.asm.Attribute;
import com.esotericsoftware.asm.TypePath;

public abstract class FieldVisitor {
    protected final int api;
    protected FieldVisitor fv;

    public FieldVisitor(int n2) {
        this(n2, null);
    }

    public FieldVisitor(int n2, FieldVisitor fieldVisitor) {
        if (n2 != 262144 && n2 != 327680) {
            throw new IllegalArgumentException();
        }
        this.api = n2;
        this.fv = fieldVisitor;
    }

    public AnnotationVisitor visitAnnotation(String string, boolean bl2) {
        if (this.fv != null) {
            return this.fv.visitAnnotation(string, bl2);
        }
        return null;
    }

    public AnnotationVisitor visitTypeAnnotation(int n2, TypePath typePath, String string, boolean bl2) {
        if (this.api < 327680) {
            throw new RuntimeException();
        }
        if (this.fv != null) {
            return this.fv.visitTypeAnnotation(n2, typePath, string, bl2);
        }
        return null;
    }

    public void visitAttribute(Attribute attribute) {
        if (this.fv != null) {
            this.fv.visitAttribute(attribute);
        }
    }

    public void visitEnd() {
        if (this.fv != null) {
            this.fv.visitEnd();
        }
    }
}

