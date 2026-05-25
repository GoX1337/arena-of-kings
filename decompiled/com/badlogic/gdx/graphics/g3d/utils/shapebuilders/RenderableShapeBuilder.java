/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.utils.shapebuilders;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.g3d.Renderable;
import com.badlogic.gdx.graphics.g3d.RenderableProvider;
import com.badlogic.gdx.graphics.g3d.utils.MeshPartBuilder;
import com.badlogic.gdx.graphics.g3d.utils.shapebuilders.BaseShapeBuilder;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.FlushablePool;

public class RenderableShapeBuilder
extends BaseShapeBuilder {
    private static short[] indices;
    private static float[] vertices;
    private static final RenderablePool renderablesPool;
    private static final Array<Renderable> renderables;
    private static final int FLOAT_BYTES = 4;

    public static void buildNormals(MeshPartBuilder meshPartBuilder, RenderableProvider renderableProvider, float f2) {
        RenderableShapeBuilder.buildNormals(meshPartBuilder, renderableProvider, f2, tmpColor0.set(0.0f, 0.0f, 1.0f, 1.0f), tmpColor1.set(1.0f, 0.0f, 0.0f, 1.0f), tmpColor2.set(0.0f, 1.0f, 0.0f, 1.0f));
    }

    public static void buildNormals(MeshPartBuilder meshPartBuilder, RenderableProvider renderableProvider, float f2, Color color, Color color2, Color color3) {
        renderableProvider.getRenderables(renderables, renderablesPool);
        for (Renderable renderable : renderables) {
            RenderableShapeBuilder.buildNormals(meshPartBuilder, renderable, f2, color, color2, color3);
        }
        renderablesPool.flush();
        renderables.clear();
    }

    public static void buildNormals(MeshPartBuilder meshPartBuilder, Renderable renderable, float f2, Color color, Color color2, Color color3) {
        int n2;
        int n3;
        Mesh mesh = renderable.meshPart.mesh;
        int n4 = -1;
        if (mesh.getVertexAttribute(1) != null) {
            n4 = mesh.getVertexAttribute((int)1).offset / 4;
        }
        int n5 = -1;
        if (mesh.getVertexAttribute(8) != null) {
            n5 = mesh.getVertexAttribute((int)8).offset / 4;
        }
        int n6 = -1;
        if (mesh.getVertexAttribute(128) != null) {
            n6 = mesh.getVertexAttribute((int)128).offset / 4;
        }
        int n7 = -1;
        if (mesh.getVertexAttribute(256) != null) {
            n7 = mesh.getVertexAttribute((int)256).offset / 4;
        }
        int n8 = mesh.getVertexSize() / 4;
        int n9 = 0;
        int n10 = 0;
        if (mesh.getNumIndices() > 0) {
            RenderableShapeBuilder.ensureIndicesCapacity(mesh.getNumIndices());
            mesh.getIndices(renderable.meshPart.offset, renderable.meshPart.size, indices, 0);
            n3 = RenderableShapeBuilder.minVerticeInIndices();
            n2 = RenderableShapeBuilder.maxVerticeInIndices();
            n9 = n3;
            n10 = n2 - n3;
        } else {
            n9 = renderable.meshPart.offset;
            n10 = renderable.meshPart.size;
        }
        RenderableShapeBuilder.ensureVerticesCapacity(n10 * n8);
        mesh.getVertices(n9 * n8, n10 * n8, vertices, 0);
        for (n3 = n9; n3 < n10; ++n3) {
            n2 = n3 * n8;
            tmpV0.set(vertices[n2 + n4], vertices[n2 + n4 + 1], vertices[n2 + n4 + 2]);
            if (n5 != -1) {
                tmpV1.set(vertices[n2 + n5], vertices[n2 + n5 + 1], vertices[n2 + n5 + 2]);
                tmpV2.set(tmpV0).add(tmpV1.scl(f2));
            }
            if (n6 != -1) {
                tmpV3.set(vertices[n2 + n6], vertices[n2 + n6 + 1], vertices[n2 + n6 + 2]);
                tmpV4.set(tmpV0).add(tmpV3.scl(f2));
            }
            if (n7 != -1) {
                tmpV5.set(vertices[n2 + n7], vertices[n2 + n7 + 1], vertices[n2 + n7 + 2]);
                tmpV6.set(tmpV0).add(tmpV5.scl(f2));
            }
            tmpV0.mul(renderable.worldTransform);
            tmpV2.mul(renderable.worldTransform);
            tmpV4.mul(renderable.worldTransform);
            tmpV6.mul(renderable.worldTransform);
            if (n5 != -1) {
                meshPartBuilder.setColor(color);
                meshPartBuilder.line(tmpV0, tmpV2);
            }
            if (n6 != -1) {
                meshPartBuilder.setColor(color2);
                meshPartBuilder.line(tmpV0, tmpV4);
            }
            if (n7 == -1) continue;
            meshPartBuilder.setColor(color3);
            meshPartBuilder.line(tmpV0, tmpV6);
        }
    }

    private static void ensureVerticesCapacity(int n2) {
        if (vertices == null || vertices.length < n2) {
            vertices = new float[n2];
        }
    }

    private static void ensureIndicesCapacity(int n2) {
        if (indices == null || indices.length < n2) {
            indices = new short[n2];
        }
    }

    private static short minVerticeInIndices() {
        short s2 = Short.MAX_VALUE;
        for (int i2 = 0; i2 < indices.length; ++i2) {
            if (indices[i2] >= s2) continue;
            s2 = indices[i2];
        }
        return s2;
    }

    private static short maxVerticeInIndices() {
        short s2 = Short.MIN_VALUE;
        for (int i2 = 0; i2 < indices.length; ++i2) {
            if (indices[i2] <= s2) continue;
            s2 = indices[i2];
        }
        return s2;
    }

    static {
        renderablesPool = new RenderablePool();
        renderables = new Array();
    }

    static class RenderablePool
    extends FlushablePool<Renderable> {
        @Override
        protected Renderable newObject() {
            return new Renderable();
        }

        @Override
        public Renderable obtain() {
            Renderable renderable = (Renderable)super.obtain();
            renderable.environment = null;
            renderable.material = null;
            renderable.meshPart.set("", null, 0, 0, 0);
            renderable.shader = null;
            renderable.userData = null;
            return renderable;
        }
    }
}

