/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.attributes;

import com.badlogic.gdx.graphics.g3d.Attribute;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.NumberUtils;

public class DepthTestAttribute
extends Attribute {
    public static final String Alias = "depthStencil";
    public static final long Type;
    protected static long Mask;
    public int depthFunc;
    public float depthRangeNear;
    public float depthRangeFar;
    public boolean depthMask;

    public static final boolean is(long l2) {
        return (l2 & Mask) != 0L;
    }

    public DepthTestAttribute() {
        this(515);
    }

    public DepthTestAttribute(boolean bl2) {
        this(515, bl2);
    }

    public DepthTestAttribute(int n2) {
        this(n2, true);
    }

    public DepthTestAttribute(int n2, boolean bl2) {
        this(n2, 0.0f, 1.0f, bl2);
    }

    public DepthTestAttribute(int n2, float f2, float f3) {
        this(n2, f2, f3, true);
    }

    public DepthTestAttribute(int n2, float f2, float f3, boolean bl2) {
        this(Type, n2, f2, f3, bl2);
    }

    public DepthTestAttribute(long l2, int n2, float f2, float f3, boolean bl2) {
        super(l2);
        if (!DepthTestAttribute.is(l2)) {
            throw new GdxRuntimeException("Invalid type specified");
        }
        this.depthFunc = n2;
        this.depthRangeNear = f2;
        this.depthRangeFar = f3;
        this.depthMask = bl2;
    }

    public DepthTestAttribute(DepthTestAttribute depthTestAttribute) {
        this(depthTestAttribute.type, depthTestAttribute.depthFunc, depthTestAttribute.depthRangeNear, depthTestAttribute.depthRangeFar, depthTestAttribute.depthMask);
    }

    @Override
    public Attribute copy() {
        return new DepthTestAttribute(this);
    }

    @Override
    public int hashCode() {
        int n2 = super.hashCode();
        n2 = 971 * n2 + this.depthFunc;
        n2 = 971 * n2 + NumberUtils.floatToRawIntBits(this.depthRangeNear);
        n2 = 971 * n2 + NumberUtils.floatToRawIntBits(this.depthRangeFar);
        n2 = 971 * n2 + (this.depthMask ? 1 : 0);
        return n2;
    }

    @Override
    public int compareTo(Attribute attribute) {
        if (this.type != attribute.type) {
            return (int)(this.type - attribute.type);
        }
        DepthTestAttribute depthTestAttribute = (DepthTestAttribute)attribute;
        if (this.depthFunc != depthTestAttribute.depthFunc) {
            return this.depthFunc - depthTestAttribute.depthFunc;
        }
        if (this.depthMask != depthTestAttribute.depthMask) {
            return this.depthMask ? -1 : 1;
        }
        if (!MathUtils.isEqual(this.depthRangeNear, depthTestAttribute.depthRangeNear)) {
            return this.depthRangeNear < depthTestAttribute.depthRangeNear ? -1 : 1;
        }
        if (!MathUtils.isEqual(this.depthRangeFar, depthTestAttribute.depthRangeFar)) {
            return this.depthRangeFar < depthTestAttribute.depthRangeFar ? -1 : 1;
        }
        return 0;
    }

    static {
        Mask = Type = DepthTestAttribute.register(Alias);
    }
}

