/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics;

public final class VertexAttribute {
    public final int usage;
    public final int numComponents;
    public final boolean normalized;
    public final int type;
    public int offset;
    public String alias;
    public int unit;
    private final int usageIndex;

    public VertexAttribute(int n2, int n3, String string) {
        this(n2, n3, string, 0);
    }

    public VertexAttribute(int n2, int n3, String string, int n4) {
        this(n2, n3, n2 == 4 ? 5121 : 5126, n2 == 4, string, n4);
    }

    public VertexAttribute(int n2, int n3, int n4, boolean bl2, String string) {
        this(n2, n3, n4, bl2, string, 0);
    }

    public VertexAttribute(int n2, int n3, int n4, boolean bl2, String string, int n5) {
        this.usage = n2;
        this.numComponents = n3;
        this.type = n4;
        this.normalized = bl2;
        this.alias = string;
        this.unit = n5;
        this.usageIndex = Integer.numberOfTrailingZeros(n2);
    }

    public VertexAttribute copy() {
        return new VertexAttribute(this.usage, this.numComponents, this.type, this.normalized, this.alias, this.unit);
    }

    public static VertexAttribute Position() {
        return new VertexAttribute(1, 3, "a_position");
    }

    public static VertexAttribute TexCoords(int n2) {
        return new VertexAttribute(16, 2, "a_texCoord" + n2, n2);
    }

    public static VertexAttribute Normal() {
        return new VertexAttribute(8, 3, "a_normal");
    }

    public static VertexAttribute ColorPacked() {
        return new VertexAttribute(4, 4, 5121, true, "a_color");
    }

    public static VertexAttribute ColorUnpacked() {
        return new VertexAttribute(2, 4, 5126, false, "a_color");
    }

    public static VertexAttribute Tangent() {
        return new VertexAttribute(128, 3, "a_tangent");
    }

    public static VertexAttribute Binormal() {
        return new VertexAttribute(256, 3, "a_binormal");
    }

    public static VertexAttribute BoneWeight(int n2) {
        return new VertexAttribute(64, 2, "a_boneWeight" + n2, n2);
    }

    public boolean equals(Object object) {
        if (!(object instanceof VertexAttribute)) {
            return false;
        }
        return this.equals((VertexAttribute)object);
    }

    public boolean equals(VertexAttribute vertexAttribute) {
        return vertexAttribute != null && this.usage == vertexAttribute.usage && this.numComponents == vertexAttribute.numComponents && this.type == vertexAttribute.type && this.normalized == vertexAttribute.normalized && this.alias.equals(vertexAttribute.alias) && this.unit == vertexAttribute.unit;
    }

    public int getKey() {
        return (this.usageIndex << 8) + (this.unit & 0xFF);
    }

    public int getSizeInBytes() {
        switch (this.type) {
            case 5126: 
            case 5132: {
                return 4 * this.numComponents;
            }
            case 5120: 
            case 5121: {
                return this.numComponents;
            }
            case 5122: 
            case 5123: {
                return 2 * this.numComponents;
            }
        }
        return 0;
    }

    public int hashCode() {
        int n2 = this.getKey();
        n2 = 541 * n2 + this.numComponents;
        n2 = 541 * n2 + this.alias.hashCode();
        return n2;
    }
}

