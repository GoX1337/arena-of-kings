/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.utils.shapebuilders;

import com.badlogic.gdx.graphics.g3d.utils.MeshPartBuilder;
import com.badlogic.gdx.graphics.g3d.utils.shapebuilders.BaseShapeBuilder;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.BoundingBox;

public class BoxShapeBuilder
extends BaseShapeBuilder {
    public static void build(MeshPartBuilder meshPartBuilder, BoundingBox boundingBox) {
        meshPartBuilder.box(boundingBox.getCorner000(BoxShapeBuilder.obtainV3()), boundingBox.getCorner010(BoxShapeBuilder.obtainV3()), boundingBox.getCorner100(BoxShapeBuilder.obtainV3()), boundingBox.getCorner110(BoxShapeBuilder.obtainV3()), boundingBox.getCorner001(BoxShapeBuilder.obtainV3()), boundingBox.getCorner011(BoxShapeBuilder.obtainV3()), boundingBox.getCorner101(BoxShapeBuilder.obtainV3()), boundingBox.getCorner111(BoxShapeBuilder.obtainV3()));
        BoxShapeBuilder.freeAll();
    }

    public static void build(MeshPartBuilder meshPartBuilder, MeshPartBuilder.VertexInfo vertexInfo, MeshPartBuilder.VertexInfo vertexInfo2, MeshPartBuilder.VertexInfo vertexInfo3, MeshPartBuilder.VertexInfo vertexInfo4, MeshPartBuilder.VertexInfo vertexInfo5, MeshPartBuilder.VertexInfo vertexInfo6, MeshPartBuilder.VertexInfo vertexInfo7, MeshPartBuilder.VertexInfo vertexInfo8) {
        meshPartBuilder.ensureVertices(8);
        short s2 = meshPartBuilder.vertex(vertexInfo);
        short s3 = meshPartBuilder.vertex(vertexInfo3);
        short s4 = meshPartBuilder.vertex(vertexInfo4);
        short s5 = meshPartBuilder.vertex(vertexInfo2);
        short s6 = meshPartBuilder.vertex(vertexInfo5);
        short s7 = meshPartBuilder.vertex(vertexInfo7);
        short s8 = meshPartBuilder.vertex(vertexInfo8);
        short s9 = meshPartBuilder.vertex(vertexInfo6);
        int n2 = meshPartBuilder.getPrimitiveType();
        if (n2 == 1) {
            meshPartBuilder.ensureIndices(24);
            meshPartBuilder.rect(s2, s3, s4, s5);
            meshPartBuilder.rect(s7, s6, s9, s8);
            meshPartBuilder.index(s2, s6, s5, s9, s4, s8, s3, s7);
        } else if (n2 == 0) {
            meshPartBuilder.ensureRectangleIndices(2);
            meshPartBuilder.rect(s2, s3, s4, s5);
            meshPartBuilder.rect(s7, s6, s9, s8);
        } else {
            meshPartBuilder.ensureRectangleIndices(6);
            meshPartBuilder.rect(s2, s3, s4, s5);
            meshPartBuilder.rect(s7, s6, s9, s8);
            meshPartBuilder.rect(s2, s5, s9, s6);
            meshPartBuilder.rect(s7, s8, s4, s3);
            meshPartBuilder.rect(s7, s3, s2, s6);
            meshPartBuilder.rect(s4, s8, s9, s5);
        }
    }

    public static void build(MeshPartBuilder meshPartBuilder, Vector3 vector3, Vector3 vector32, Vector3 vector33, Vector3 vector34, Vector3 vector35, Vector3 vector36, Vector3 vector37, Vector3 vector38) {
        if ((meshPartBuilder.getAttributes().getMask() & 0x198L) == 0L) {
            BoxShapeBuilder.build(meshPartBuilder, vertTmp1.set(vector3, null, null, null), vertTmp2.set(vector32, null, null, null), vertTmp3.set(vector33, null, null, null), vertTmp4.set(vector34, null, null, null), vertTmp5.set(vector35, null, null, null), vertTmp6.set(vector36, null, null, null), vertTmp7.set(vector37, null, null, null), vertTmp8.set(vector38, null, null, null));
        } else {
            meshPartBuilder.ensureVertices(24);
            meshPartBuilder.ensureRectangleIndices(6);
            Vector3 vector39 = tmpV1.set(vector3).lerp(vector34, 0.5f).sub(tmpV2.set(vector35).lerp(vector38, 0.5f)).nor();
            meshPartBuilder.rect(vector3, vector32, vector34, vector33, vector39);
            meshPartBuilder.rect(vector36, vector35, vector37, vector38, vector39.scl(-1.0f));
            vector39 = tmpV1.set(vector3).lerp(vector37, 0.5f).sub(tmpV2.set(vector32).lerp(vector38, 0.5f)).nor();
            meshPartBuilder.rect(vector35, vector3, vector33, vector37, vector39);
            meshPartBuilder.rect(vector32, vector36, vector38, vector34, vector39.scl(-1.0f));
            vector39 = tmpV1.set(vector3).lerp(vector36, 0.5f).sub(tmpV2.set(vector33).lerp(vector38, 0.5f)).nor();
            meshPartBuilder.rect(vector35, vector36, vector32, vector3, vector39);
            meshPartBuilder.rect(vector33, vector34, vector38, vector37, vector39.scl(-1.0f));
        }
    }

    public static void build(MeshPartBuilder meshPartBuilder, Matrix4 matrix4) {
        BoxShapeBuilder.build(meshPartBuilder, BoxShapeBuilder.obtainV3().set(-0.5f, -0.5f, -0.5f).mul(matrix4), BoxShapeBuilder.obtainV3().set(-0.5f, 0.5f, -0.5f).mul(matrix4), BoxShapeBuilder.obtainV3().set(0.5f, -0.5f, -0.5f).mul(matrix4), BoxShapeBuilder.obtainV3().set(0.5f, 0.5f, -0.5f).mul(matrix4), BoxShapeBuilder.obtainV3().set(-0.5f, -0.5f, 0.5f).mul(matrix4), BoxShapeBuilder.obtainV3().set(-0.5f, 0.5f, 0.5f).mul(matrix4), BoxShapeBuilder.obtainV3().set(0.5f, -0.5f, 0.5f).mul(matrix4), BoxShapeBuilder.obtainV3().set(0.5f, 0.5f, 0.5f).mul(matrix4));
        BoxShapeBuilder.freeAll();
    }

    public static void build(MeshPartBuilder meshPartBuilder, float f2, float f3, float f4) {
        BoxShapeBuilder.build(meshPartBuilder, 0.0f, 0.0f, 0.0f, f2, f3, f4);
    }

    public static void build(MeshPartBuilder meshPartBuilder, float f2, float f3, float f4, float f5, float f6, float f7) {
        float f8 = f5 * 0.5f;
        float f9 = f6 * 0.5f;
        float f10 = f7 * 0.5f;
        float f11 = f2 - f8;
        float f12 = f3 - f9;
        float f13 = f4 - f10;
        float f14 = f2 + f8;
        float f15 = f3 + f9;
        float f16 = f4 + f10;
        BoxShapeBuilder.build(meshPartBuilder, BoxShapeBuilder.obtainV3().set(f11, f12, f13), BoxShapeBuilder.obtainV3().set(f11, f15, f13), BoxShapeBuilder.obtainV3().set(f14, f12, f13), BoxShapeBuilder.obtainV3().set(f14, f15, f13), BoxShapeBuilder.obtainV3().set(f11, f12, f16), BoxShapeBuilder.obtainV3().set(f11, f15, f16), BoxShapeBuilder.obtainV3().set(f14, f12, f16), BoxShapeBuilder.obtainV3().set(f14, f15, f16));
        BoxShapeBuilder.freeAll();
    }
}

