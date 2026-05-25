/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.attributes;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g3d.Attribute;
import com.badlogic.gdx.graphics.g3d.utils.TextureDescriptor;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.NumberUtils;

public class TextureAttribute
extends Attribute {
    public static final String DiffuseAlias = "diffuseTexture";
    public static final long Diffuse = TextureAttribute.register("diffuseTexture");
    public static final String SpecularAlias = "specularTexture";
    public static final long Specular = TextureAttribute.register("specularTexture");
    public static final String BumpAlias = "bumpTexture";
    public static final long Bump = TextureAttribute.register("bumpTexture");
    public static final String NormalAlias = "normalTexture";
    public static final long Normal = TextureAttribute.register("normalTexture");
    public static final String AmbientAlias = "ambientTexture";
    public static final long Ambient = TextureAttribute.register("ambientTexture");
    public static final String EmissiveAlias = "emissiveTexture";
    public static final long Emissive = TextureAttribute.register("emissiveTexture");
    public static final String ReflectionAlias = "reflectionTexture";
    public static final long Reflection = TextureAttribute.register("reflectionTexture");
    protected static long Mask = Diffuse | Specular | Bump | Normal | Ambient | Emissive | Reflection;
    public final TextureDescriptor<Texture> textureDescription;
    public float offsetU = 0.0f;
    public float offsetV = 0.0f;
    public float scaleU = 1.0f;
    public float scaleV = 1.0f;
    public int uvIndex = 0;

    public static final boolean is(long l2) {
        return (l2 & Mask) != 0L;
    }

    public static TextureAttribute createDiffuse(Texture texture) {
        return new TextureAttribute(Diffuse, texture);
    }

    public static TextureAttribute createDiffuse(TextureRegion textureRegion) {
        return new TextureAttribute(Diffuse, textureRegion);
    }

    public static TextureAttribute createSpecular(Texture texture) {
        return new TextureAttribute(Specular, texture);
    }

    public static TextureAttribute createSpecular(TextureRegion textureRegion) {
        return new TextureAttribute(Specular, textureRegion);
    }

    public static TextureAttribute createNormal(Texture texture) {
        return new TextureAttribute(Normal, texture);
    }

    public static TextureAttribute createNormal(TextureRegion textureRegion) {
        return new TextureAttribute(Normal, textureRegion);
    }

    public static TextureAttribute createBump(Texture texture) {
        return new TextureAttribute(Bump, texture);
    }

    public static TextureAttribute createBump(TextureRegion textureRegion) {
        return new TextureAttribute(Bump, textureRegion);
    }

    public static TextureAttribute createAmbient(Texture texture) {
        return new TextureAttribute(Ambient, texture);
    }

    public static TextureAttribute createAmbient(TextureRegion textureRegion) {
        return new TextureAttribute(Ambient, textureRegion);
    }

    public static TextureAttribute createEmissive(Texture texture) {
        return new TextureAttribute(Emissive, texture);
    }

    public static TextureAttribute createEmissive(TextureRegion textureRegion) {
        return new TextureAttribute(Emissive, textureRegion);
    }

    public static TextureAttribute createReflection(Texture texture) {
        return new TextureAttribute(Reflection, texture);
    }

    public static TextureAttribute createReflection(TextureRegion textureRegion) {
        return new TextureAttribute(Reflection, textureRegion);
    }

    public TextureAttribute(long l2) {
        super(l2);
        if (!TextureAttribute.is(l2)) {
            throw new GdxRuntimeException("Invalid type specified");
        }
        this.textureDescription = new TextureDescriptor();
    }

    public <T extends Texture> TextureAttribute(long l2, TextureDescriptor<T> textureDescriptor) {
        this(l2);
        this.textureDescription.set(textureDescriptor);
    }

    public <T extends Texture> TextureAttribute(long l2, TextureDescriptor<T> textureDescriptor, float f2, float f3, float f4, float f5, int n2) {
        this(l2, textureDescriptor);
        this.offsetU = f2;
        this.offsetV = f3;
        this.scaleU = f4;
        this.scaleV = f5;
        this.uvIndex = n2;
    }

    public <T extends Texture> TextureAttribute(long l2, TextureDescriptor<T> textureDescriptor, float f2, float f3, float f4, float f5) {
        this(l2, textureDescriptor, f2, f3, f4, f5, 0);
    }

    public TextureAttribute(long l2, Texture texture) {
        this(l2);
        this.textureDescription.texture = texture;
    }

    public TextureAttribute(long l2, TextureRegion textureRegion) {
        this(l2);
        this.set(textureRegion);
    }

    public TextureAttribute(TextureAttribute textureAttribute) {
        this(textureAttribute.type, textureAttribute.textureDescription, textureAttribute.offsetU, textureAttribute.offsetV, textureAttribute.scaleU, textureAttribute.scaleV, textureAttribute.uvIndex);
    }

    public void set(TextureRegion textureRegion) {
        this.textureDescription.texture = textureRegion.getTexture();
        this.offsetU = textureRegion.getU();
        this.offsetV = textureRegion.getV();
        this.scaleU = textureRegion.getU2() - this.offsetU;
        this.scaleV = textureRegion.getV2() - this.offsetV;
    }

    @Override
    public Attribute copy() {
        return new TextureAttribute(this);
    }

    @Override
    public int hashCode() {
        int n2 = super.hashCode();
        n2 = 991 * n2 + this.textureDescription.hashCode();
        n2 = 991 * n2 + NumberUtils.floatToRawIntBits(this.offsetU);
        n2 = 991 * n2 + NumberUtils.floatToRawIntBits(this.offsetV);
        n2 = 991 * n2 + NumberUtils.floatToRawIntBits(this.scaleU);
        n2 = 991 * n2 + NumberUtils.floatToRawIntBits(this.scaleV);
        n2 = 991 * n2 + this.uvIndex;
        return n2;
    }

    @Override
    public int compareTo(Attribute attribute) {
        if (this.type != attribute.type) {
            return this.type < attribute.type ? -1 : 1;
        }
        TextureAttribute textureAttribute = (TextureAttribute)attribute;
        int n2 = this.textureDescription.compareTo(textureAttribute.textureDescription);
        if (n2 != 0) {
            return n2;
        }
        if (this.uvIndex != textureAttribute.uvIndex) {
            return this.uvIndex - textureAttribute.uvIndex;
        }
        if (!MathUtils.isEqual(this.scaleU, textureAttribute.scaleU)) {
            return this.scaleU > textureAttribute.scaleU ? 1 : -1;
        }
        if (!MathUtils.isEqual(this.scaleV, textureAttribute.scaleV)) {
            return this.scaleV > textureAttribute.scaleV ? 1 : -1;
        }
        if (!MathUtils.isEqual(this.offsetU, textureAttribute.offsetU)) {
            return this.offsetU > textureAttribute.offsetU ? 1 : -1;
        }
        if (!MathUtils.isEqual(this.offsetV, textureAttribute.offsetV)) {
            return this.offsetV > textureAttribute.offsetV ? 1 : -1;
        }
        return 0;
    }
}

