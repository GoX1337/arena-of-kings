/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.utils.shapebuilders;

import com.badlogic.gdx.graphics.g3d.utils.MeshPartBuilder;
import com.badlogic.gdx.graphics.g3d.utils.shapebuilders.BaseShapeBuilder;
import com.badlogic.gdx.graphics.g3d.utils.shapebuilders.EllipseShapeBuilder;
import com.badlogic.gdx.math.MathUtils;

public class ConeShapeBuilder
extends BaseShapeBuilder {
    public static void build(MeshPartBuilder meshPartBuilder, float f2, float f3, float f4, int n2) {
        ConeShapeBuilder.build(meshPartBuilder, f2, f3, f4, n2, 0.0f, 360.0f);
    }

    public static void build(MeshPartBuilder meshPartBuilder, float f2, float f3, float f4, int n2, float f5, float f6) {
        ConeShapeBuilder.build(meshPartBuilder, f2, f3, f4, n2, f5, f6, true);
    }

    public static void build(MeshPartBuilder meshPartBuilder, float f2, float f3, float f4, int n2, float f5, float f6, boolean bl2) {
        meshPartBuilder.ensureVertices(n2 + 2);
        meshPartBuilder.ensureTriangleIndices(n2);
        float f7 = f2 * 0.5f;
        float f8 = f3 * 0.5f;
        float f9 = f4 * 0.5f;
        float f10 = (float)Math.PI / 180 * f5;
        float f11 = (float)Math.PI / 180 * (f6 - f5) / (float)n2;
        float f12 = 1.0f / (float)n2;
        float f13 = 0.0f;
        float f14 = 0.0f;
        MeshPartBuilder.VertexInfo vertexInfo = vertTmp3.set(null, null, null, null);
        vertexInfo.hasNormal = true;
        vertexInfo.hasPosition = true;
        vertexInfo.hasUV = true;
        MeshPartBuilder.VertexInfo vertexInfo2 = vertTmp4.set(null, null, null, null).setPos(0.0f, f8, 0.0f).setNor(0.0f, 1.0f, 0.0f).setUV(0.5f, 0.0f);
        short s2 = meshPartBuilder.vertex(vertexInfo2);
        short s3 = 0;
        for (int i2 = 0; i2 <= n2; ++i2) {
            f14 = f10 + f11 * (float)i2;
            f13 = 1.0f - f12 * (float)i2;
            vertexInfo.position.set(MathUtils.cos(f14) * f7, 0.0f, MathUtils.sin(f14) * f9);
            vertexInfo.normal.set(vertexInfo.position).nor();
            vertexInfo.position.y = -f8;
            vertexInfo.uv.set(f13, 1.0f);
            short s4 = meshPartBuilder.vertex(vertexInfo);
            if (i2 != 0) {
                meshPartBuilder.triangle(s2, s4, s3);
            }
            s3 = s4;
        }
        if (bl2) {
            EllipseShapeBuilder.build(meshPartBuilder, f2, f4, 0.0f, 0.0f, n2, 0.0f, -f8, 0.0f, 0.0f, -1.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 180.0f - f6, 180.0f - f5);
        }
    }
}

