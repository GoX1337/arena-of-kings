/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.utils.shapebuilders;

import com.badlogic.gdx.graphics.g3d.utils.MeshPartBuilder;
import com.badlogic.gdx.graphics.g3d.utils.shapebuilders.BaseShapeBuilder;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.GdxRuntimeException;

public class EllipseShapeBuilder
extends BaseShapeBuilder {
    public static void build(MeshPartBuilder meshPartBuilder, float f2, int n2, float f3, float f4, float f5, float f6, float f7, float f8) {
        EllipseShapeBuilder.build(meshPartBuilder, f2, n2, f3, f4, f5, f6, f7, f8, 0.0f, 360.0f);
    }

    public static void build(MeshPartBuilder meshPartBuilder, float f2, int n2, Vector3 vector3, Vector3 vector32) {
        EllipseShapeBuilder.build(meshPartBuilder, f2, n2, vector3.x, vector3.y, vector3.z, vector32.x, vector32.y, vector32.z);
    }

    public static void build(MeshPartBuilder meshPartBuilder, float f2, int n2, Vector3 vector3, Vector3 vector32, Vector3 vector33, Vector3 vector34) {
        EllipseShapeBuilder.build(meshPartBuilder, f2, n2, vector3.x, vector3.y, vector3.z, vector32.x, vector32.y, vector32.z, vector33.x, vector33.y, vector33.z, vector34.x, vector34.y, vector34.z);
    }

    public static void build(MeshPartBuilder meshPartBuilder, float f2, int n2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14) {
        EllipseShapeBuilder.build(meshPartBuilder, f2, n2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, 0.0f, 360.0f);
    }

    public static void build(MeshPartBuilder meshPartBuilder, float f2, int n2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        EllipseShapeBuilder.build(meshPartBuilder, f2 * 2.0f, f2 * 2.0f, n2, f3, f4, f5, f6, f7, f8, f9, f10);
    }

    public static void build(MeshPartBuilder meshPartBuilder, float f2, int n2, Vector3 vector3, Vector3 vector32, float f3, float f4) {
        EllipseShapeBuilder.build(meshPartBuilder, f2, n2, vector3.x, vector3.y, vector3.z, vector32.x, vector32.y, vector32.z, f3, f4);
    }

    public static void build(MeshPartBuilder meshPartBuilder, float f2, int n2, Vector3 vector3, Vector3 vector32, Vector3 vector33, Vector3 vector34, float f3, float f4) {
        EllipseShapeBuilder.build(meshPartBuilder, f2, n2, vector3.x, vector3.y, vector3.z, vector32.x, vector32.y, vector32.z, vector33.x, vector33.y, vector33.z, vector34.x, vector34.y, vector34.z, f3, f4);
    }

    public static void build(MeshPartBuilder meshPartBuilder, float f2, int n2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16) {
        EllipseShapeBuilder.build(meshPartBuilder, f2 * 2.0f, f2 * 2.0f, 0.0f, 0.0f, n2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16);
    }

    public static void build(MeshPartBuilder meshPartBuilder, float f2, float f3, int n2, float f4, float f5, float f6, float f7, float f8, float f9) {
        EllipseShapeBuilder.build(meshPartBuilder, f2, f3, n2, f4, f5, f6, f7, f8, f9, 0.0f, 360.0f);
    }

    public static void build(MeshPartBuilder meshPartBuilder, float f2, float f3, int n2, Vector3 vector3, Vector3 vector32) {
        EllipseShapeBuilder.build(meshPartBuilder, f2, f3, n2, vector3.x, vector3.y, vector3.z, vector32.x, vector32.y, vector32.z);
    }

    public static void build(MeshPartBuilder meshPartBuilder, float f2, float f3, int n2, Vector3 vector3, Vector3 vector32, Vector3 vector33, Vector3 vector34) {
        EllipseShapeBuilder.build(meshPartBuilder, f2, f3, n2, vector3.x, vector3.y, vector3.z, vector32.x, vector32.y, vector32.z, vector33.x, vector33.y, vector33.z, vector34.x, vector34.y, vector34.z);
    }

    public static void build(MeshPartBuilder meshPartBuilder, float f2, float f3, int n2, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15) {
        EllipseShapeBuilder.build(meshPartBuilder, f2, f3, n2, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, 0.0f, 360.0f);
    }

    public static void build(MeshPartBuilder meshPartBuilder, float f2, float f3, int n2, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11) {
        EllipseShapeBuilder.build(meshPartBuilder, f2, f3, 0.0f, 0.0f, n2, f4, f5, f6, f7, f8, f9, f10, f11);
    }

    public static void build(MeshPartBuilder meshPartBuilder, float f2, float f3, int n2, Vector3 vector3, Vector3 vector32, float f4, float f5) {
        EllipseShapeBuilder.build(meshPartBuilder, f2, f3, 0.0f, 0.0f, n2, vector3.x, vector3.y, vector3.z, vector32.x, vector32.y, vector32.z, f4, f5);
    }

    public static void build(MeshPartBuilder meshPartBuilder, float f2, float f3, int n2, Vector3 vector3, Vector3 vector32, Vector3 vector33, Vector3 vector34, float f4, float f5) {
        EllipseShapeBuilder.build(meshPartBuilder, f2, f3, 0.0f, 0.0f, n2, vector3.x, vector3.y, vector3.z, vector32.x, vector32.y, vector32.z, vector33.x, vector33.y, vector33.z, vector34.x, vector34.y, vector34.z, f4, f5);
    }

    public static void build(MeshPartBuilder meshPartBuilder, float f2, float f3, int n2, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17) {
        EllipseShapeBuilder.build(meshPartBuilder, f2, f3, 0.0f, 0.0f, n2, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17);
    }

    public static void build(MeshPartBuilder meshPartBuilder, float f2, float f3, float f4, float f5, int n2, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13) {
        tmpV1.set(f9, f10, f11).crs(0.0f, 0.0f, 1.0f);
        tmpV2.set(f9, f10, f11).crs(0.0f, 1.0f, 0.0f);
        if (tmpV2.len2() > tmpV1.len2()) {
            tmpV1.set(tmpV2);
        }
        tmpV2.set(tmpV1.nor()).crs(f9, f10, f11).nor();
        EllipseShapeBuilder.build(meshPartBuilder, f2, f3, f4, f5, n2, f6, f7, f8, f9, f10, f11, EllipseShapeBuilder.tmpV1.x, EllipseShapeBuilder.tmpV1.y, EllipseShapeBuilder.tmpV1.z, EllipseShapeBuilder.tmpV2.x, EllipseShapeBuilder.tmpV2.y, EllipseShapeBuilder.tmpV2.z, f12, f13);
    }

    public static void build(MeshPartBuilder meshPartBuilder, float f2, float f3, float f4, float f5, int n2, float f6, float f7, float f8, float f9, float f10, float f11) {
        EllipseShapeBuilder.build(meshPartBuilder, f2, f3, f4, f5, n2, f6, f7, f8, f9, f10, f11, 0.0f, 360.0f);
    }

    public static void build(MeshPartBuilder meshPartBuilder, float f2, float f3, float f4, float f5, int n2, Vector3 vector3, Vector3 vector32) {
        EllipseShapeBuilder.build(meshPartBuilder, f2, f3, f4, f5, n2, vector3.x, vector3.y, vector3.z, vector32.x, vector32.y, vector32.z, 0.0f, 360.0f);
    }

    public static void build(MeshPartBuilder meshPartBuilder, float f2, float f3, float f4, float f5, int n2, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19) {
        if (f4 <= 0.0f || f5 <= 0.0f) {
            meshPartBuilder.ensureVertices(n2 + 2);
            meshPartBuilder.ensureTriangleIndices(n2);
        } else if (f4 == f2 && f5 == f3) {
            meshPartBuilder.ensureVertices(n2 + 1);
            meshPartBuilder.ensureIndices(n2 + 1);
            if (meshPartBuilder.getPrimitiveType() != 1) {
                throw new GdxRuntimeException("Incorrect primitive type : expect GL_LINES because innerWidth == width && innerHeight == height");
            }
        } else {
            meshPartBuilder.ensureVertices((n2 + 1) * 2);
            meshPartBuilder.ensureRectangleIndices(n2 + 1);
        }
        float f20 = (float)Math.PI / 180 * f18;
        float f21 = (float)Math.PI / 180 * (f19 - f18) / (float)n2;
        Vector3 vector3 = tmpV1.set(f12, f13, f14).scl(f2 * 0.5f);
        Vector3 vector32 = tmpV2.set(f15, f16, f17).scl(f3 * 0.5f);
        Vector3 vector33 = tmpV3.set(f12, f13, f14).scl(f4 * 0.5f);
        Vector3 vector34 = tmpV4.set(f15, f16, f17).scl(f5 * 0.5f);
        MeshPartBuilder.VertexInfo vertexInfo = vertTmp3.set(null, null, null, null);
        vertexInfo.hasNormal = true;
        vertexInfo.hasPosition = true;
        vertexInfo.hasUV = true;
        vertexInfo.uv.set(0.5f, 0.5f);
        vertexInfo.position.set(f6, f7, f8);
        vertexInfo.normal.set(f9, f10, f11);
        MeshPartBuilder.VertexInfo vertexInfo2 = vertTmp4.set(null, null, null, null);
        vertexInfo2.hasNormal = true;
        vertexInfo2.hasPosition = true;
        vertexInfo2.hasUV = true;
        vertexInfo2.uv.set(0.5f, 0.5f);
        vertexInfo2.position.set(f6, f7, f8);
        vertexInfo2.normal.set(f9, f10, f11);
        short s2 = meshPartBuilder.vertex(vertexInfo2);
        float f22 = 0.0f;
        float f23 = 0.5f * (f4 / f2);
        float f24 = 0.5f * (f5 / f3);
        short s3 = 0;
        short s4 = 0;
        short s5 = 0;
        for (int i2 = 0; i2 <= n2; ++i2) {
            f22 = f20 + f21 * (float)i2;
            float f25 = MathUtils.cos(f22);
            float f26 = MathUtils.sin(f22);
            vertexInfo2.position.set(f6, f7, f8).add(vector3.x * f25 + vector32.x * f26, vector3.y * f25 + vector32.y * f26, vector3.z * f25 + vector32.z * f26);
            vertexInfo2.uv.set(0.5f + 0.5f * f25, 0.5f + 0.5f * f26);
            short s6 = meshPartBuilder.vertex(vertexInfo2);
            if (f4 <= 0.0f || f5 <= 0.0f) {
                if (i2 != 0) {
                    meshPartBuilder.triangle(s6, s3, s2);
                }
                s3 = s6;
                continue;
            }
            if (f4 == f2 && f5 == f3) {
                if (i2 != 0) {
                    meshPartBuilder.line(s6, s3);
                }
                s3 = s6;
                continue;
            }
            vertexInfo.position.set(f6, f7, f8).add(vector33.x * f25 + vector34.x * f26, vector33.y * f25 + vector34.y * f26, vector33.z * f25 + vector34.z * f26);
            vertexInfo.uv.set(0.5f + f23 * f25, 0.5f + f24 * f26);
            s3 = s6;
            s6 = meshPartBuilder.vertex(vertexInfo);
            if (i2 != 0) {
                meshPartBuilder.rect(s6, s3, s5, s4);
            }
            s5 = s3;
            s4 = s6;
        }
    }
}

