/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.utils.shapebuilders;

import com.badlogic.gdx.graphics.g3d.utils.MeshPartBuilder;
import com.badlogic.gdx.graphics.g3d.utils.shapebuilders.BaseShapeBuilder;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.GdxRuntimeException;

public class PatchShapeBuilder
extends BaseShapeBuilder {
    public static void build(MeshPartBuilder meshPartBuilder, MeshPartBuilder.VertexInfo vertexInfo, MeshPartBuilder.VertexInfo vertexInfo2, MeshPartBuilder.VertexInfo vertexInfo3, MeshPartBuilder.VertexInfo vertexInfo4, int n2, int n3) {
        if (n2 < 1 || n3 < 1) {
            throw new GdxRuntimeException("divisionsU and divisionV must be > 0, u,v: " + n2 + ", " + n3);
        }
        meshPartBuilder.ensureVertices((n3 + 1) * (n2 + 1));
        meshPartBuilder.ensureRectangleIndices(n3 * n2);
        for (int i2 = 0; i2 <= n2; ++i2) {
            float f2 = (float)i2 / (float)n2;
            vertTmp5.set(vertexInfo).lerp(vertexInfo2, f2);
            vertTmp6.set(vertexInfo4).lerp(vertexInfo3, f2);
            for (int i3 = 0; i3 <= n3; ++i3) {
                short s2 = meshPartBuilder.vertex(vertTmp7.set(vertTmp5).lerp(vertTmp6, (float)i3 / (float)n3));
                if (i2 <= 0 || i3 <= 0) continue;
                meshPartBuilder.rect((short)(s2 - n3 - 2), (short)(s2 - 1), s2, (short)(s2 - n3 - 1));
            }
        }
    }

    public static void build(MeshPartBuilder meshPartBuilder, Vector3 vector3, Vector3 vector32, Vector3 vector33, Vector3 vector34, Vector3 vector35, int n2, int n3) {
        PatchShapeBuilder.build(meshPartBuilder, vertTmp1.set(vector3, vector35, null, null).setUV(0.0f, 1.0f), vertTmp2.set(vector32, vector35, null, null).setUV(1.0f, 1.0f), vertTmp3.set(vector33, vector35, null, null).setUV(1.0f, 0.0f), vertTmp4.set(vector34, vector35, null, null).setUV(0.0f, 0.0f), n2, n3);
    }

    public static void build(MeshPartBuilder meshPartBuilder, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, int n2, int n3) {
        PatchShapeBuilder.build(meshPartBuilder, vertTmp1.set(null).setPos(f2, f3, f4).setNor(f14, f15, f16).setUV(0.0f, 1.0f), vertTmp2.set(null).setPos(f5, f6, f7).setNor(f14, f15, f16).setUV(1.0f, 1.0f), vertTmp3.set(null).setPos(f8, f9, f10).setNor(f14, f15, f16).setUV(1.0f, 0.0f), vertTmp4.set(null).setPos(f11, f12, f13).setNor(f14, f15, f16).setUV(0.0f, 0.0f), n2, n3);
    }
}

