/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.utils;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g3d.model.MeshPart;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Pool;

public interface MeshPartBuilder {
    public MeshPart getMeshPart();

    public int getPrimitiveType();

    public VertexAttributes getAttributes();

    public void setColor(Color var1);

    public void setColor(float var1, float var2, float var3, float var4);

    public void setUVRange(float var1, float var2, float var3, float var4);

    public void setUVRange(TextureRegion var1);

    public Matrix4 getVertexTransform(Matrix4 var1);

    public void setVertexTransform(Matrix4 var1);

    public boolean isVertexTransformationEnabled();

    public void setVertexTransformationEnabled(boolean var1);

    public void ensureVertices(int var1);

    public void ensureIndices(int var1);

    public void ensureCapacity(int var1, int var2);

    public void ensureTriangleIndices(int var1);

    public void ensureRectangleIndices(int var1);

    public short vertex(float ... var1);

    public short vertex(Vector3 var1, Vector3 var2, Color var3, Vector2 var4);

    public short vertex(VertexInfo var1);

    public short lastIndex();

    public void index(short var1);

    public void index(short var1, short var2);

    public void index(short var1, short var2, short var3);

    public void index(short var1, short var2, short var3, short var4);

    public void index(short var1, short var2, short var3, short var4, short var5, short var6);

    public void index(short var1, short var2, short var3, short var4, short var5, short var6, short var7, short var8);

    public void line(short var1, short var2);

    public void line(VertexInfo var1, VertexInfo var2);

    public void line(Vector3 var1, Vector3 var2);

    public void line(float var1, float var2, float var3, float var4, float var5, float var6);

    public void line(Vector3 var1, Color var2, Vector3 var3, Color var4);

    public void triangle(short var1, short var2, short var3);

    public void triangle(VertexInfo var1, VertexInfo var2, VertexInfo var3);

    public void triangle(Vector3 var1, Vector3 var2, Vector3 var3);

    public void triangle(Vector3 var1, Color var2, Vector3 var3, Color var4, Vector3 var5, Color var6);

    public void rect(short var1, short var2, short var3, short var4);

    public void rect(VertexInfo var1, VertexInfo var2, VertexInfo var3, VertexInfo var4);

    public void rect(Vector3 var1, Vector3 var2, Vector3 var3, Vector3 var4, Vector3 var5);

    public void rect(float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9, float var10, float var11, float var12, float var13, float var14, float var15);

    public void addMesh(Mesh var1);

    public void addMesh(MeshPart var1);

    public void addMesh(Mesh var1, int var2, int var3);

    public void addMesh(float[] var1, short[] var2);

    public void addMesh(float[] var1, short[] var2, int var3, int var4);

    @Deprecated
    public void patch(VertexInfo var1, VertexInfo var2, VertexInfo var3, VertexInfo var4, int var5, int var6);

    @Deprecated
    public void patch(Vector3 var1, Vector3 var2, Vector3 var3, Vector3 var4, Vector3 var5, int var6, int var7);

    @Deprecated
    public void patch(float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9, float var10, float var11, float var12, float var13, float var14, float var15, int var16, int var17);

    @Deprecated
    public void box(VertexInfo var1, VertexInfo var2, VertexInfo var3, VertexInfo var4, VertexInfo var5, VertexInfo var6, VertexInfo var7, VertexInfo var8);

    @Deprecated
    public void box(Vector3 var1, Vector3 var2, Vector3 var3, Vector3 var4, Vector3 var5, Vector3 var6, Vector3 var7, Vector3 var8);

    @Deprecated
    public void box(Matrix4 var1);

    @Deprecated
    public void box(float var1, float var2, float var3);

    @Deprecated
    public void box(float var1, float var2, float var3, float var4, float var5, float var6);

    @Deprecated
    public void circle(float var1, int var2, float var3, float var4, float var5, float var6, float var7, float var8);

    @Deprecated
    public void circle(float var1, int var2, Vector3 var3, Vector3 var4);

    @Deprecated
    public void circle(float var1, int var2, Vector3 var3, Vector3 var4, Vector3 var5, Vector3 var6);

    @Deprecated
    public void circle(float var1, int var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9, float var10, float var11, float var12, float var13, float var14);

    @Deprecated
    public void circle(float var1, int var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9, float var10);

    @Deprecated
    public void circle(float var1, int var2, Vector3 var3, Vector3 var4, float var5, float var6);

    @Deprecated
    public void circle(float var1, int var2, Vector3 var3, Vector3 var4, Vector3 var5, Vector3 var6, float var7, float var8);

    @Deprecated
    public void circle(float var1, int var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9, float var10, float var11, float var12, float var13, float var14, float var15, float var16);

    @Deprecated
    public void ellipse(float var1, float var2, int var3, float var4, float var5, float var6, float var7, float var8, float var9);

    @Deprecated
    public void ellipse(float var1, float var2, int var3, Vector3 var4, Vector3 var5);

    @Deprecated
    public void ellipse(float var1, float var2, int var3, Vector3 var4, Vector3 var5, Vector3 var6, Vector3 var7);

    @Deprecated
    public void ellipse(float var1, float var2, int var3, float var4, float var5, float var6, float var7, float var8, float var9, float var10, float var11, float var12, float var13, float var14, float var15);

    @Deprecated
    public void ellipse(float var1, float var2, int var3, float var4, float var5, float var6, float var7, float var8, float var9, float var10, float var11);

    @Deprecated
    public void ellipse(float var1, float var2, int var3, Vector3 var4, Vector3 var5, float var6, float var7);

    @Deprecated
    public void ellipse(float var1, float var2, int var3, Vector3 var4, Vector3 var5, Vector3 var6, Vector3 var7, float var8, float var9);

    @Deprecated
    public void ellipse(float var1, float var2, int var3, float var4, float var5, float var6, float var7, float var8, float var9, float var10, float var11, float var12, float var13, float var14, float var15, float var16, float var17);

    @Deprecated
    public void ellipse(float var1, float var2, float var3, float var4, int var5, float var6, float var7, float var8, float var9, float var10, float var11, float var12, float var13, float var14, float var15, float var16, float var17, float var18, float var19);

    @Deprecated
    public void ellipse(float var1, float var2, float var3, float var4, int var5, float var6, float var7, float var8, float var9, float var10, float var11, float var12, float var13);

    @Deprecated
    public void ellipse(float var1, float var2, float var3, float var4, int var5, float var6, float var7, float var8, float var9, float var10, float var11);

    @Deprecated
    public void ellipse(float var1, float var2, float var3, float var4, int var5, Vector3 var6, Vector3 var7);

    @Deprecated
    public void cylinder(float var1, float var2, float var3, int var4);

    @Deprecated
    public void cylinder(float var1, float var2, float var3, int var4, float var5, float var6);

    @Deprecated
    public void cylinder(float var1, float var2, float var3, int var4, float var5, float var6, boolean var7);

    @Deprecated
    public void cone(float var1, float var2, float var3, int var4);

    @Deprecated
    public void cone(float var1, float var2, float var3, int var4, float var5, float var6);

    @Deprecated
    public void sphere(float var1, float var2, float var3, int var4, int var5);

    @Deprecated
    public void sphere(Matrix4 var1, float var2, float var3, float var4, int var5, int var6);

    @Deprecated
    public void sphere(float var1, float var2, float var3, int var4, int var5, float var6, float var7, float var8, float var9);

    @Deprecated
    public void sphere(Matrix4 var1, float var2, float var3, float var4, int var5, int var6, float var7, float var8, float var9, float var10);

    @Deprecated
    public void capsule(float var1, float var2, int var3);

    @Deprecated
    public void arrow(float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, int var9);

    public static class VertexInfo
    implements Pool.Poolable {
        public final Vector3 position = new Vector3();
        public boolean hasPosition;
        public final Vector3 normal = new Vector3(0.0f, 1.0f, 0.0f);
        public boolean hasNormal;
        public final Color color = new Color(1.0f, 1.0f, 1.0f, 1.0f);
        public boolean hasColor;
        public final Vector2 uv = new Vector2();
        public boolean hasUV;

        @Override
        public void reset() {
            this.position.set(0.0f, 0.0f, 0.0f);
            this.normal.set(0.0f, 1.0f, 0.0f);
            this.color.set(1.0f, 1.0f, 1.0f, 1.0f);
            this.uv.set(0.0f, 0.0f);
        }

        public VertexInfo set(Vector3 vector3, Vector3 vector32, Color color, Vector2 vector2) {
            this.reset();
            boolean bl2 = this.hasPosition = vector3 != null;
            if (this.hasPosition) {
                this.position.set(vector3);
            }
            boolean bl3 = this.hasNormal = vector32 != null;
            if (this.hasNormal) {
                this.normal.set(vector32);
            }
            boolean bl4 = this.hasColor = color != null;
            if (this.hasColor) {
                this.color.set(color);
            }
            boolean bl5 = this.hasUV = vector2 != null;
            if (this.hasUV) {
                this.uv.set(vector2);
            }
            return this;
        }

        public VertexInfo set(VertexInfo vertexInfo) {
            if (vertexInfo == null) {
                return this.set(null, null, null, null);
            }
            this.hasPosition = vertexInfo.hasPosition;
            this.position.set(vertexInfo.position);
            this.hasNormal = vertexInfo.hasNormal;
            this.normal.set(vertexInfo.normal);
            this.hasColor = vertexInfo.hasColor;
            this.color.set(vertexInfo.color);
            this.hasUV = vertexInfo.hasUV;
            this.uv.set(vertexInfo.uv);
            return this;
        }

        public VertexInfo setPos(float f2, float f3, float f4) {
            this.position.set(f2, f3, f4);
            this.hasPosition = true;
            return this;
        }

        public VertexInfo setPos(Vector3 vector3) {
            boolean bl2 = this.hasPosition = vector3 != null;
            if (this.hasPosition) {
                this.position.set(vector3);
            }
            return this;
        }

        public VertexInfo setNor(float f2, float f3, float f4) {
            this.normal.set(f2, f3, f4);
            this.hasNormal = true;
            return this;
        }

        public VertexInfo setNor(Vector3 vector3) {
            boolean bl2 = this.hasNormal = vector3 != null;
            if (this.hasNormal) {
                this.normal.set(vector3);
            }
            return this;
        }

        public VertexInfo setCol(float f2, float f3, float f4, float f5) {
            this.color.set(f2, f3, f4, f5);
            this.hasColor = true;
            return this;
        }

        public VertexInfo setCol(Color color) {
            boolean bl2 = this.hasColor = color != null;
            if (this.hasColor) {
                this.color.set(color);
            }
            return this;
        }

        public VertexInfo setUV(float f2, float f3) {
            this.uv.set(f2, f3);
            this.hasUV = true;
            return this;
        }

        public VertexInfo setUV(Vector2 vector2) {
            boolean bl2 = this.hasUV = vector2 != null;
            if (this.hasUV) {
                this.uv.set(vector2);
            }
            return this;
        }

        public VertexInfo lerp(VertexInfo vertexInfo, float f2) {
            if (this.hasPosition && vertexInfo.hasPosition) {
                this.position.lerp(vertexInfo.position, f2);
            }
            if (this.hasNormal && vertexInfo.hasNormal) {
                this.normal.lerp(vertexInfo.normal, f2);
            }
            if (this.hasColor && vertexInfo.hasColor) {
                this.color.lerp(vertexInfo.color, f2);
            }
            if (this.hasUV && vertexInfo.hasUV) {
                this.uv.lerp(vertexInfo.uv, f2);
            }
            return this;
        }
    }
}

