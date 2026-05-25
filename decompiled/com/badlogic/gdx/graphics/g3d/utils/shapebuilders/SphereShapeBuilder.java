/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.utils.shapebuilders;

import com.badlogic.gdx.graphics.g3d.utils.MeshPartBuilder;
import com.badlogic.gdx.graphics.g3d.utils.shapebuilders.BaseShapeBuilder;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Matrix3;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.utils.ShortArray;

public class SphereShapeBuilder
extends BaseShapeBuilder {
    private static final ShortArray tmpIndices = new ShortArray();
    private static final Matrix3 normalTransform = new Matrix3();

    public static void build(MeshPartBuilder meshPartBuilder, float f2, float f3, float f4, int n2, int n3) {
        SphereShapeBuilder.build(meshPartBuilder, f2, f3, f4, n2, n3, 0.0f, 360.0f, 0.0f, 180.0f);
    }

    @Deprecated
    public static void build(MeshPartBuilder meshPartBuilder, Matrix4 matrix4, float f2, float f3, float f4, int n2, int n3) {
        SphereShapeBuilder.build(meshPartBuilder, matrix4, f2, f3, f4, n2, n3, 0.0f, 360.0f, 0.0f, 180.0f);
    }

    public static void build(MeshPartBuilder meshPartBuilder, float f2, float f3, float f4, int n2, int n3, float f5, float f6, float f7, float f8) {
        SphereShapeBuilder.build(meshPartBuilder, matTmp1.idt(), f2, f3, f4, n2, n3, f5, f6, f7, f8);
    }

    @Deprecated
    public static void build(MeshPartBuilder meshPartBuilder, Matrix4 matrix4, float f2, float f3, float f4, int n2, int n3, float f5, float f6, float f7, float f8) {
        boolean bl2 = MathUtils.isEqual(f7, 0.0f);
        boolean bl3 = MathUtils.isEqual(f8, 180.0f);
        float f9 = f2 * 0.5f;
        float f10 = f3 * 0.5f;
        float f11 = f4 * 0.5f;
        float f12 = (float)Math.PI / 180 * f5;
        float f13 = (float)Math.PI / 180 * (f6 - f5) / (float)n2;
        float f14 = (float)Math.PI / 180 * f7;
        float f15 = (float)Math.PI / 180 * (f8 - f7) / (float)n3;
        float f16 = 1.0f / (float)n2;
        float f17 = 1.0f / (float)n3;
        float f18 = 0.0f;
        float f19 = 0.0f;
        float f20 = 0.0f;
        float f21 = 0.0f;
        MeshPartBuilder.VertexInfo vertexInfo = vertTmp3.set(null, null, null, null);
        vertexInfo.hasNormal = true;
        vertexInfo.hasPosition = true;
        vertexInfo.hasUV = true;
        normalTransform.set(matrix4);
        int n4 = n2 + 3;
        tmpIndices.clear();
        tmpIndices.ensureCapacity(n2 * 2);
        SphereShapeBuilder.tmpIndices.size = n4;
        int n5 = 0;
        meshPartBuilder.ensureVertices((n3 + 1) * (n2 + 1));
        meshPartBuilder.ensureRectangleIndices(n2);
        for (int i2 = 0; i2 <= n3; ++i2) {
            f21 = f14 + f15 * (float)i2;
            f19 = f17 * (float)i2;
            float f22 = MathUtils.sin(f21);
            float f23 = MathUtils.cos(f21) * f10;
            for (int i3 = 0; i3 <= n2; ++i3) {
                f20 = f12 + f13 * (float)i3;
                f18 = i2 == 0 && bl2 || i2 == n3 && bl3 ? 1.0f - f16 * ((float)i3 - 0.5f) : 1.0f - f16 * (float)i3;
                vertexInfo.position.set(MathUtils.cos(f20) * f9 * f22, f23, MathUtils.sin(f20) * f11 * f22);
                vertexInfo.normal.set(vertexInfo.position).mul(normalTransform).nor();
                vertexInfo.position.mul(matrix4);
                vertexInfo.uv.set(f18, f19);
                tmpIndices.set(n5, meshPartBuilder.vertex(vertexInfo));
                int n6 = n5 + n4;
                if (i2 > 0 && i3 > 0) {
                    if (i2 == 1 && bl2) {
                        meshPartBuilder.triangle(tmpIndices.get(n5), tmpIndices.get((n6 - 1) % n4), tmpIndices.get((n6 - (n2 + 1)) % n4));
                    } else if (i2 == n3 && bl3) {
                        meshPartBuilder.triangle(tmpIndices.get(n5), tmpIndices.get((n6 - (n2 + 2)) % n4), tmpIndices.get((n6 - (n2 + 1)) % n4));
                    } else {
                        meshPartBuilder.rect(tmpIndices.get(n5), tmpIndices.get((n6 - 1) % n4), tmpIndices.get((n6 - (n2 + 2)) % n4), tmpIndices.get((n6 - (n2 + 1)) % n4));
                    }
                }
                n5 = (n5 + 1) % SphereShapeBuilder.tmpIndices.size;
            }
        }
    }
}

