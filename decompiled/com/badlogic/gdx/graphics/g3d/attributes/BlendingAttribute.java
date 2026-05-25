/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.attributes;

import com.badlogic.gdx.graphics.g3d.Attribute;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.NumberUtils;

public class BlendingAttribute
extends Attribute {
    public static final String Alias = "blended";
    public static final long Type = BlendingAttribute.register("blended");
    public boolean blended;
    public int sourceFunction;
    public int destFunction;
    public float opacity = 1.0f;

    public static final boolean is(long l2) {
        return (l2 & Type) == l2;
    }

    public BlendingAttribute() {
        this(null);
    }

    public BlendingAttribute(boolean bl2, int n2, int n3, float f2) {
        super(Type);
        this.blended = bl2;
        this.sourceFunction = n2;
        this.destFunction = n3;
        this.opacity = f2;
    }

    public BlendingAttribute(int n2, int n3, float f2) {
        this(true, n2, n3, f2);
    }

    public BlendingAttribute(int n2, int n3) {
        this(n2, n3, 1.0f);
    }

    public BlendingAttribute(boolean bl2, float f2) {
        this(bl2, 770, 771, f2);
    }

    public BlendingAttribute(float f2) {
        this(true, f2);
    }

    public BlendingAttribute(BlendingAttribute blendingAttribute) {
        this(blendingAttribute == null || blendingAttribute.blended, blendingAttribute == null ? 770 : blendingAttribute.sourceFunction, blendingAttribute == null ? 771 : blendingAttribute.destFunction, blendingAttribute == null ? 1.0f : blendingAttribute.opacity);
    }

    @Override
    public BlendingAttribute copy() {
        return new BlendingAttribute(this);
    }

    @Override
    public int hashCode() {
        int n2 = super.hashCode();
        n2 = 947 * n2 + (this.blended ? 1 : 0);
        n2 = 947 * n2 + this.sourceFunction;
        n2 = 947 * n2 + this.destFunction;
        n2 = 947 * n2 + NumberUtils.floatToRawIntBits(this.opacity);
        return n2;
    }

    @Override
    public int compareTo(Attribute attribute) {
        if (this.type != attribute.type) {
            return (int)(this.type - attribute.type);
        }
        BlendingAttribute blendingAttribute = (BlendingAttribute)attribute;
        if (this.blended != blendingAttribute.blended) {
            return this.blended ? 1 : -1;
        }
        if (this.sourceFunction != blendingAttribute.sourceFunction) {
            return this.sourceFunction - blendingAttribute.sourceFunction;
        }
        if (this.destFunction != blendingAttribute.destFunction) {
            return this.destFunction - blendingAttribute.destFunction;
        }
        return MathUtils.isEqual(this.opacity, blendingAttribute.opacity) ? 0 : (this.opacity < blendingAttribute.opacity ? 1 : -1);
    }
}

