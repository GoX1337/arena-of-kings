/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.attributes;

import com.badlogic.gdx.graphics.g3d.Attribute;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.NumberUtils;

public class FloatAttribute
extends Attribute {
    public static final String ShininessAlias = "shininess";
    public static final long Shininess = FloatAttribute.register("shininess");
    public static final String AlphaTestAlias = "alphaTest";
    public static final long AlphaTest = FloatAttribute.register("alphaTest");
    public float value;

    public static FloatAttribute createShininess(float f2) {
        return new FloatAttribute(Shininess, f2);
    }

    public static FloatAttribute createAlphaTest(float f2) {
        return new FloatAttribute(AlphaTest, f2);
    }

    public FloatAttribute(long l2) {
        super(l2);
    }

    public FloatAttribute(long l2, float f2) {
        super(l2);
        this.value = f2;
    }

    @Override
    public Attribute copy() {
        return new FloatAttribute(this.type, this.value);
    }

    @Override
    public int hashCode() {
        int n2 = super.hashCode();
        n2 = 977 * n2 + NumberUtils.floatToRawIntBits(this.value);
        return n2;
    }

    @Override
    public int compareTo(Attribute attribute) {
        if (this.type != attribute.type) {
            return (int)(this.type - attribute.type);
        }
        float f2 = ((FloatAttribute)attribute).value;
        return MathUtils.isEqual(this.value, f2) ? 0 : (this.value < f2 ? -1 : 1);
    }
}

