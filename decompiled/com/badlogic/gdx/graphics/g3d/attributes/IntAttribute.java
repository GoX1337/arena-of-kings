/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.attributes;

import com.badlogic.gdx.graphics.g3d.Attribute;

public class IntAttribute
extends Attribute {
    public static final String CullFaceAlias = "cullface";
    public static final long CullFace = IntAttribute.register("cullface");
    public int value;

    public static IntAttribute createCullFace(int n2) {
        return new IntAttribute(CullFace, n2);
    }

    public IntAttribute(long l2) {
        super(l2);
    }

    public IntAttribute(long l2, int n2) {
        super(l2);
        this.value = n2;
    }

    @Override
    public Attribute copy() {
        return new IntAttribute(this.type, this.value);
    }

    @Override
    public int hashCode() {
        int n2 = super.hashCode();
        n2 = 983 * n2 + this.value;
        return n2;
    }

    @Override
    public int compareTo(Attribute attribute) {
        if (this.type != attribute.type) {
            return (int)(this.type - attribute.type);
        }
        return this.value - ((IntAttribute)attribute).value;
    }
}

