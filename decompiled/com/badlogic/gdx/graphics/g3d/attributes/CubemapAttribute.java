/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.attributes;

import com.badlogic.gdx.graphics.Cubemap;
import com.badlogic.gdx.graphics.g3d.Attribute;
import com.badlogic.gdx.graphics.g3d.utils.TextureDescriptor;
import com.badlogic.gdx.utils.GdxRuntimeException;

public class CubemapAttribute
extends Attribute {
    public static final String EnvironmentMapAlias = "environmentCubemap";
    public static final long EnvironmentMap;
    protected static long Mask;
    public final TextureDescriptor<Cubemap> textureDescription;

    public static final boolean is(long l2) {
        return (l2 & Mask) != 0L;
    }

    public CubemapAttribute(long l2) {
        super(l2);
        if (!CubemapAttribute.is(l2)) {
            throw new GdxRuntimeException("Invalid type specified");
        }
        this.textureDescription = new TextureDescriptor();
    }

    public <T extends Cubemap> CubemapAttribute(long l2, TextureDescriptor<T> textureDescriptor) {
        this(l2);
        this.textureDescription.set(textureDescriptor);
    }

    public CubemapAttribute(long l2, Cubemap cubemap) {
        this(l2);
        this.textureDescription.texture = cubemap;
    }

    public CubemapAttribute(CubemapAttribute cubemapAttribute) {
        this(cubemapAttribute.type, cubemapAttribute.textureDescription);
    }

    @Override
    public Attribute copy() {
        return new CubemapAttribute(this);
    }

    @Override
    public int hashCode() {
        int n2 = super.hashCode();
        n2 = 967 * n2 + this.textureDescription.hashCode();
        return n2;
    }

    @Override
    public int compareTo(Attribute attribute) {
        if (this.type != attribute.type) {
            return (int)(this.type - attribute.type);
        }
        return this.textureDescription.compareTo(((CubemapAttribute)attribute).textureDescription);
    }

    static {
        Mask = EnvironmentMap = CubemapAttribute.register(EnvironmentMapAlias);
    }
}

