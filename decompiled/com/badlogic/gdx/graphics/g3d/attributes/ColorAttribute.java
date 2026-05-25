/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.attributes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g3d.Attribute;
import com.badlogic.gdx.utils.GdxRuntimeException;

public class ColorAttribute
extends Attribute {
    public static final String DiffuseAlias = "diffuseColor";
    public static final long Diffuse = ColorAttribute.register("diffuseColor");
    public static final String SpecularAlias = "specularColor";
    public static final long Specular = ColorAttribute.register("specularColor");
    public static final String AmbientAlias = "ambientColor";
    public static final long Ambient = ColorAttribute.register("ambientColor");
    public static final String EmissiveAlias = "emissiveColor";
    public static final long Emissive = ColorAttribute.register("emissiveColor");
    public static final String ReflectionAlias = "reflectionColor";
    public static final long Reflection = ColorAttribute.register("reflectionColor");
    public static final String AmbientLightAlias = "ambientLightColor";
    public static final long AmbientLight = ColorAttribute.register("ambientLightColor");
    public static final String FogAlias = "fogColor";
    public static final long Fog = ColorAttribute.register("fogColor");
    protected static long Mask = Ambient | Diffuse | Specular | Emissive | Reflection | AmbientLight | Fog;
    public final Color color = new Color();

    public static final boolean is(long l2) {
        return (l2 & Mask) != 0L;
    }

    public static final ColorAttribute createAmbient(Color color) {
        return new ColorAttribute(Ambient, color);
    }

    public static final ColorAttribute createAmbient(float f2, float f3, float f4, float f5) {
        return new ColorAttribute(Ambient, f2, f3, f4, f5);
    }

    public static final ColorAttribute createDiffuse(Color color) {
        return new ColorAttribute(Diffuse, color);
    }

    public static final ColorAttribute createDiffuse(float f2, float f3, float f4, float f5) {
        return new ColorAttribute(Diffuse, f2, f3, f4, f5);
    }

    public static final ColorAttribute createSpecular(Color color) {
        return new ColorAttribute(Specular, color);
    }

    public static final ColorAttribute createSpecular(float f2, float f3, float f4, float f5) {
        return new ColorAttribute(Specular, f2, f3, f4, f5);
    }

    public static final ColorAttribute createReflection(Color color) {
        return new ColorAttribute(Reflection, color);
    }

    public static final ColorAttribute createReflection(float f2, float f3, float f4, float f5) {
        return new ColorAttribute(Reflection, f2, f3, f4, f5);
    }

    public static final ColorAttribute createEmissive(Color color) {
        return new ColorAttribute(Emissive, color);
    }

    public static final ColorAttribute createEmissive(float f2, float f3, float f4, float f5) {
        return new ColorAttribute(Emissive, f2, f3, f4, f5);
    }

    public static final ColorAttribute createAmbientLight(Color color) {
        return new ColorAttribute(AmbientLight, color);
    }

    public static final ColorAttribute createAmbientLight(float f2, float f3, float f4, float f5) {
        return new ColorAttribute(AmbientLight, f2, f3, f4, f5);
    }

    public static final ColorAttribute createFog(Color color) {
        return new ColorAttribute(Fog, color);
    }

    public static final ColorAttribute createFog(float f2, float f3, float f4, float f5) {
        return new ColorAttribute(Fog, f2, f3, f4, f5);
    }

    public ColorAttribute(long l2) {
        super(l2);
        if (!ColorAttribute.is(l2)) {
            throw new GdxRuntimeException("Invalid type specified");
        }
    }

    public ColorAttribute(long l2, Color color) {
        this(l2);
        if (color != null) {
            this.color.set(color);
        }
    }

    public ColorAttribute(long l2, float f2, float f3, float f4, float f5) {
        this(l2);
        this.color.set(f2, f3, f4, f5);
    }

    public ColorAttribute(ColorAttribute colorAttribute) {
        this(colorAttribute.type, colorAttribute.color);
    }

    @Override
    public Attribute copy() {
        return new ColorAttribute(this);
    }

    @Override
    public int hashCode() {
        int n2 = super.hashCode();
        n2 = 953 * n2 + this.color.toIntBits();
        return n2;
    }

    @Override
    public int compareTo(Attribute attribute) {
        if (this.type != attribute.type) {
            return (int)(this.type - attribute.type);
        }
        return ((ColorAttribute)attribute).color.toIntBits() - this.color.toIntBits();
    }
}

