/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.glutils.IndexArray;
import com.badlogic.gdx.graphics.glutils.IndexBufferObject;
import com.badlogic.gdx.graphics.glutils.IndexBufferObjectSubData;
import com.badlogic.gdx.graphics.glutils.IndexData;
import com.badlogic.gdx.graphics.glutils.InstanceBufferObject;
import com.badlogic.gdx.graphics.glutils.InstanceData;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.graphics.glutils.VertexArray;
import com.badlogic.gdx.graphics.glutils.VertexBufferObject;
import com.badlogic.gdx.graphics.glutils.VertexBufferObjectSubData;
import com.badlogic.gdx.graphics.glutils.VertexBufferObjectWithVAO;
import com.badlogic.gdx.graphics.glutils.VertexData;
import com.badlogic.gdx.math.Matrix3;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.BoundingBox;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import java.util.HashMap;
import java.util.Map;

public class Mesh
implements Disposable {
    static final Map<Application, Array<Mesh>> meshes = new HashMap<Application, Array<Mesh>>();
    final VertexData vertices;
    final IndexData indices;
    boolean autoBind = true;
    final boolean isVertexArray;
    InstanceData instances;
    boolean isInstanced = false;
    private final Vector3 tmpV = new Vector3();

    protected Mesh(VertexData vertexData, IndexData indexData, boolean bl2) {
        this.vertices = vertexData;
        this.indices = indexData;
        this.isVertexArray = bl2;
        Mesh.addManagedMesh(Gdx.app, this);
    }

    public Mesh(boolean bl2, int n2, int n3, VertexAttribute ... vertexAttributeArray) {
        this.vertices = this.makeVertexBuffer(bl2, n2, new VertexAttributes(vertexAttributeArray));
        this.indices = new IndexBufferObject(bl2, n3);
        this.isVertexArray = false;
        Mesh.addManagedMesh(Gdx.app, this);
    }

    public Mesh(boolean bl2, int n2, int n3, VertexAttributes vertexAttributes) {
        this.vertices = this.makeVertexBuffer(bl2, n2, vertexAttributes);
        this.indices = new IndexBufferObject(bl2, n3);
        this.isVertexArray = false;
        Mesh.addManagedMesh(Gdx.app, this);
    }

    public Mesh(boolean bl2, boolean bl3, int n2, int n3, VertexAttributes vertexAttributes) {
        this.vertices = this.makeVertexBuffer(bl2, n2, vertexAttributes);
        this.indices = new IndexBufferObject(bl3, n3);
        this.isVertexArray = false;
        Mesh.addManagedMesh(Gdx.app, this);
    }

    private VertexData makeVertexBuffer(boolean bl2, int n2, VertexAttributes vertexAttributes) {
        if (Gdx.gl30 != null) {
            return new VertexBufferObjectWithVAO(bl2, n2, vertexAttributes);
        }
        return new VertexBufferObject(bl2, n2, vertexAttributes);
    }

    public Mesh(VertexDataType vertexDataType, boolean bl2, int n2, int n3, VertexAttribute ... vertexAttributeArray) {
        this(vertexDataType, bl2, n2, n3, new VertexAttributes(vertexAttributeArray));
    }

    public Mesh(VertexDataType vertexDataType, boolean bl2, int n2, int n3, VertexAttributes vertexAttributes) {
        switch (vertexDataType) {
            case VertexBufferObject: {
                this.vertices = new VertexBufferObject(bl2, n2, vertexAttributes);
                this.indices = new IndexBufferObject(bl2, n3);
                this.isVertexArray = false;
                break;
            }
            case VertexBufferObjectSubData: {
                this.vertices = new VertexBufferObjectSubData(bl2, n2, vertexAttributes);
                this.indices = new IndexBufferObjectSubData(bl2, n3);
                this.isVertexArray = false;
                break;
            }
            case VertexBufferObjectWithVAO: {
                this.vertices = new VertexBufferObjectWithVAO(bl2, n2, vertexAttributes);
                this.indices = new IndexBufferObjectSubData(bl2, n3);
                this.isVertexArray = false;
                break;
            }
            default: {
                this.vertices = new VertexArray(n2, vertexAttributes);
                this.indices = new IndexArray(n3);
                this.isVertexArray = true;
            }
        }
        Mesh.addManagedMesh(Gdx.app, this);
    }

    public Mesh enableInstancedRendering(boolean bl2, int n2, VertexAttribute ... vertexAttributeArray) {
        if (this.isInstanced) {
            throw new GdxRuntimeException("Trying to enable InstancedRendering on same Mesh instance twice. Use disableInstancedRendering to clean up old InstanceData first");
        }
        this.isInstanced = true;
        this.instances = new InstanceBufferObject(bl2, n2, vertexAttributeArray);
        return this;
    }

    public Mesh disableInstancedRendering() {
        if (this.isInstanced) {
            this.isInstanced = false;
            this.instances.dispose();
            this.instances = null;
        }
        return this;
    }

    public Mesh setInstanceData(float[] fArray, int n2, int n3) {
        if (this.instances == null) {
            throw new GdxRuntimeException("An InstanceBufferObject must be set before setting instance data!");
        }
        this.instances.setInstanceData(fArray, n2, n3);
        return this;
    }

    public Mesh setInstanceData(float[] fArray) {
        if (this.instances == null) {
            throw new GdxRuntimeException("An InstanceBufferObject must be set before setting instance data!");
        }
        this.instances.setInstanceData(fArray, 0, fArray.length);
        return this;
    }

    public Mesh setInstanceData(FloatBuffer floatBuffer, int n2) {
        if (this.instances == null) {
            throw new GdxRuntimeException("An InstanceBufferObject must be set before setting instance data!");
        }
        this.instances.setInstanceData(floatBuffer, n2);
        return this;
    }

    public Mesh setInstanceData(FloatBuffer floatBuffer) {
        if (this.instances == null) {
            throw new GdxRuntimeException("An InstanceBufferObject must be set before setting instance data!");
        }
        this.instances.setInstanceData(floatBuffer, floatBuffer.limit());
        return this;
    }

    public Mesh updateInstanceData(int n2, float[] fArray) {
        return this.updateInstanceData(n2, fArray, 0, fArray.length);
    }

    public Mesh updateInstanceData(int n2, float[] fArray, int n3, int n4) {
        this.instances.updateInstanceData(n2, fArray, n3, n4);
        return this;
    }

    public Mesh updateInstanceData(int n2, FloatBuffer floatBuffer) {
        return this.updateInstanceData(n2, floatBuffer, 0, floatBuffer.limit());
    }

    public Mesh updateInstanceData(int n2, FloatBuffer floatBuffer, int n3, int n4) {
        this.instances.updateInstanceData(n2, floatBuffer, n3, n4);
        return this;
    }

    public Mesh setVertices(float[] fArray) {
        this.vertices.setVertices(fArray, 0, fArray.length);
        return this;
    }

    public boolean isInstanced() {
        return this.isInstanced;
    }

    public Mesh setVertices(float[] fArray, int n2, int n3) {
        this.vertices.setVertices(fArray, n2, n3);
        return this;
    }

    public Mesh updateVertices(int n2, float[] fArray) {
        return this.updateVertices(n2, fArray, 0, fArray.length);
    }

    public Mesh updateVertices(int n2, float[] fArray, int n3, int n4) {
        this.vertices.updateVertices(n2, fArray, n3, n4);
        return this;
    }

    public float[] getVertices(float[] fArray) {
        return this.getVertices(0, -1, fArray);
    }

    public float[] getVertices(int n2, float[] fArray) {
        return this.getVertices(n2, -1, fArray);
    }

    public float[] getVertices(int n2, int n3, float[] fArray) {
        return this.getVertices(n2, n3, fArray, 0);
    }

    public float[] getVertices(int n2, int n3, float[] fArray, int n4) {
        int n5 = this.getNumVertices() * this.getVertexSize() / 4;
        if (n3 == -1 && (n3 = n5 - n2) > fArray.length - n4) {
            n3 = fArray.length - n4;
        }
        if (n2 < 0 || n3 <= 0 || n2 + n3 > n5 || n4 < 0 || n4 >= fArray.length) {
            throw new IndexOutOfBoundsException();
        }
        if (fArray.length - n4 < n3) {
            throw new IllegalArgumentException("not enough room in vertices array, has " + fArray.length + " floats, needs " + n3);
        }
        int n6 = this.getVerticesBuffer().position();
        ((Buffer)this.getVerticesBuffer()).position(n2);
        this.getVerticesBuffer().get(fArray, n4, n3);
        ((Buffer)this.getVerticesBuffer()).position(n6);
        return fArray;
    }

    public Mesh setIndices(short[] sArray) {
        this.indices.setIndices(sArray, 0, sArray.length);
        return this;
    }

    public Mesh setIndices(short[] sArray, int n2, int n3) {
        this.indices.setIndices(sArray, n2, n3);
        return this;
    }

    public void getIndices(short[] sArray) {
        this.getIndices(sArray, 0);
    }

    public void getIndices(short[] sArray, int n2) {
        this.getIndices(0, sArray, n2);
    }

    public void getIndices(int n2, short[] sArray, int n3) {
        this.getIndices(n2, -1, sArray, n3);
    }

    public void getIndices(int n2, int n3, short[] sArray, int n4) {
        int n5 = this.getNumIndices();
        if (n3 < 0) {
            n3 = n5 - n2;
        }
        if (n2 < 0 || n2 >= n5 || n2 + n3 > n5) {
            throw new IllegalArgumentException("Invalid range specified, offset: " + n2 + ", count: " + n3 + ", max: " + n5);
        }
        if (sArray.length - n4 < n3) {
            throw new IllegalArgumentException("not enough room in indices array, has " + sArray.length + " shorts, needs " + n3);
        }
        int n6 = this.getIndicesBuffer().position();
        ((Buffer)this.getIndicesBuffer()).position(n2);
        this.getIndicesBuffer().get(sArray, n4, n3);
        ((Buffer)this.getIndicesBuffer()).position(n6);
    }

    public int getNumIndices() {
        return this.indices.getNumIndices();
    }

    public int getNumVertices() {
        return this.vertices.getNumVertices();
    }

    public int getMaxVertices() {
        return this.vertices.getNumMaxVertices();
    }

    public int getMaxIndices() {
        return this.indices.getNumMaxIndices();
    }

    public int getVertexSize() {
        return this.vertices.getAttributes().vertexSize;
    }

    public void setAutoBind(boolean bl2) {
        this.autoBind = bl2;
    }

    public void bind(ShaderProgram shaderProgram) {
        this.bind(shaderProgram, null);
    }

    public void bind(ShaderProgram shaderProgram, int[] nArray) {
        this.vertices.bind(shaderProgram, nArray);
        if (this.instances != null && this.instances.getNumInstances() > 0) {
            this.instances.bind(shaderProgram, nArray);
        }
        if (this.indices.getNumIndices() > 0) {
            this.indices.bind();
        }
    }

    public void unbind(ShaderProgram shaderProgram) {
        this.unbind(shaderProgram, null);
    }

    public void unbind(ShaderProgram shaderProgram, int[] nArray) {
        this.vertices.unbind(shaderProgram, nArray);
        if (this.instances != null && this.instances.getNumInstances() > 0) {
            this.instances.unbind(shaderProgram, nArray);
        }
        if (this.indices.getNumIndices() > 0) {
            this.indices.unbind();
        }
    }

    public void render(ShaderProgram shaderProgram, int n2) {
        this.render(shaderProgram, n2, 0, this.indices.getNumMaxIndices() > 0 ? this.getNumIndices() : this.getNumVertices(), this.autoBind);
    }

    public void render(ShaderProgram shaderProgram, int n2, int n3, int n4) {
        this.render(shaderProgram, n2, n3, n4, this.autoBind);
    }

    public void render(ShaderProgram shaderProgram, int n2, int n3, int n4, boolean bl2) {
        if (n4 == 0) {
            return;
        }
        if (bl2) {
            this.bind(shaderProgram);
        }
        if (this.isVertexArray) {
            if (this.indices.getNumIndices() > 0) {
                ShortBuffer shortBuffer = this.indices.getBuffer();
                int n5 = shortBuffer.position();
                int n6 = shortBuffer.limit();
                ((Buffer)shortBuffer).position(n3);
                Gdx.gl20.glDrawElements(n2, n4, 5123, shortBuffer);
                ((Buffer)shortBuffer).position(n5);
            } else {
                Gdx.gl20.glDrawArrays(n2, n3, n4);
            }
        } else {
            int n7 = 0;
            if (this.isInstanced) {
                n7 = this.instances.getNumInstances();
            }
            if (this.indices.getNumIndices() > 0) {
                if (n4 + n3 > this.indices.getNumMaxIndices()) {
                    throw new GdxRuntimeException("Mesh attempting to access memory outside of the index buffer (count: " + n4 + ", offset: " + n3 + ", max: " + this.indices.getNumMaxIndices() + ")");
                }
                if (this.isInstanced && n7 > 0) {
                    Gdx.gl30.glDrawElementsInstanced(n2, n4, 5123, n3 * 2, n7);
                } else {
                    Gdx.gl20.glDrawElements(n2, n4, 5123, n3 * 2);
                }
            } else if (this.isInstanced && n7 > 0) {
                Gdx.gl30.glDrawArraysInstanced(n2, n3, n4, n7);
            } else {
                Gdx.gl20.glDrawArrays(n2, n3, n4);
            }
        }
        if (bl2) {
            this.unbind(shaderProgram);
        }
    }

    @Override
    public void dispose() {
        if (meshes.get(Gdx.app) != null) {
            meshes.get(Gdx.app).removeValue(this, true);
        }
        this.vertices.dispose();
        if (this.instances != null) {
            this.instances.dispose();
        }
        this.indices.dispose();
    }

    public VertexAttribute getVertexAttribute(int n2) {
        VertexAttributes vertexAttributes = this.vertices.getAttributes();
        int n3 = vertexAttributes.size();
        for (int i2 = 0; i2 < n3; ++i2) {
            if (vertexAttributes.get((int)i2).usage != n2) continue;
            return vertexAttributes.get(i2);
        }
        return null;
    }

    public VertexAttributes getVertexAttributes() {
        return this.vertices.getAttributes();
    }

    public FloatBuffer getVerticesBuffer() {
        return this.vertices.getBuffer();
    }

    public BoundingBox calculateBoundingBox() {
        BoundingBox boundingBox = new BoundingBox();
        this.calculateBoundingBox(boundingBox);
        return boundingBox;
    }

    public void calculateBoundingBox(BoundingBox boundingBox) {
        int n2 = this.getNumVertices();
        if (n2 == 0) {
            throw new GdxRuntimeException("No vertices defined");
        }
        FloatBuffer floatBuffer = this.vertices.getBuffer();
        boundingBox.inf();
        VertexAttribute vertexAttribute = this.getVertexAttribute(1);
        int n3 = vertexAttribute.offset / 4;
        int n4 = this.vertices.getAttributes().vertexSize / 4;
        int n5 = n3;
        switch (vertexAttribute.numComponents) {
            case 1: {
                for (int i2 = 0; i2 < n2; ++i2) {
                    boundingBox.ext(floatBuffer.get(n5), 0.0f, 0.0f);
                    n5 += n4;
                }
                break;
            }
            case 2: {
                for (int i3 = 0; i3 < n2; ++i3) {
                    boundingBox.ext(floatBuffer.get(n5), floatBuffer.get(n5 + 1), 0.0f);
                    n5 += n4;
                }
                break;
            }
            case 3: {
                for (int i4 = 0; i4 < n2; ++i4) {
                    boundingBox.ext(floatBuffer.get(n5), floatBuffer.get(n5 + 1), floatBuffer.get(n5 + 2));
                    n5 += n4;
                }
                break;
            }
        }
    }

    public BoundingBox calculateBoundingBox(BoundingBox boundingBox, int n2, int n3) {
        return this.extendBoundingBox(boundingBox.inf(), n2, n3);
    }

    public BoundingBox calculateBoundingBox(BoundingBox boundingBox, int n2, int n3, Matrix4 matrix4) {
        return this.extendBoundingBox(boundingBox.inf(), n2, n3, matrix4);
    }

    public BoundingBox extendBoundingBox(BoundingBox boundingBox, int n2, int n3) {
        return this.extendBoundingBox(boundingBox, n2, n3, null);
    }

    public BoundingBox extendBoundingBox(BoundingBox boundingBox, int n2, int n3, Matrix4 matrix4) {
        int n4;
        int n5 = this.getNumIndices();
        int n6 = this.getNumVertices();
        int n7 = n4 = n5 == 0 ? n6 : n5;
        if (n2 < 0 || n3 < 1 || n2 + n3 > n4) {
            throw new GdxRuntimeException("Invalid part specified ( offset=" + n2 + ", count=" + n3 + ", max=" + n4 + " )");
        }
        FloatBuffer floatBuffer = this.vertices.getBuffer();
        ShortBuffer shortBuffer = this.indices.getBuffer();
        VertexAttribute vertexAttribute = this.getVertexAttribute(1);
        int n8 = vertexAttribute.offset / 4;
        int n9 = this.vertices.getAttributes().vertexSize / 4;
        int n10 = n2 + n3;
        switch (vertexAttribute.numComponents) {
            case 1: {
                if (n5 > 0) {
                    for (int i2 = n2; i2 < n10; ++i2) {
                        int n11 = (shortBuffer.get(i2) & 0xFFFF) * n9 + n8;
                        this.tmpV.set(floatBuffer.get(n11), 0.0f, 0.0f);
                        if (matrix4 != null) {
                            this.tmpV.mul(matrix4);
                        }
                        boundingBox.ext(this.tmpV);
                    }
                } else {
                    for (int i3 = n2; i3 < n10; ++i3) {
                        int n12 = i3 * n9 + n8;
                        this.tmpV.set(floatBuffer.get(n12), 0.0f, 0.0f);
                        if (matrix4 != null) {
                            this.tmpV.mul(matrix4);
                        }
                        boundingBox.ext(this.tmpV);
                    }
                }
                break;
            }
            case 2: {
                if (n5 > 0) {
                    for (int i4 = n2; i4 < n10; ++i4) {
                        int n13 = (shortBuffer.get(i4) & 0xFFFF) * n9 + n8;
                        this.tmpV.set(floatBuffer.get(n13), floatBuffer.get(n13 + 1), 0.0f);
                        if (matrix4 != null) {
                            this.tmpV.mul(matrix4);
                        }
                        boundingBox.ext(this.tmpV);
                    }
                } else {
                    for (int i5 = n2; i5 < n10; ++i5) {
                        int n14 = i5 * n9 + n8;
                        this.tmpV.set(floatBuffer.get(n14), floatBuffer.get(n14 + 1), 0.0f);
                        if (matrix4 != null) {
                            this.tmpV.mul(matrix4);
                        }
                        boundingBox.ext(this.tmpV);
                    }
                }
                break;
            }
            case 3: {
                if (n5 > 0) {
                    for (int i6 = n2; i6 < n10; ++i6) {
                        int n15 = (shortBuffer.get(i6) & 0xFFFF) * n9 + n8;
                        this.tmpV.set(floatBuffer.get(n15), floatBuffer.get(n15 + 1), floatBuffer.get(n15 + 2));
                        if (matrix4 != null) {
                            this.tmpV.mul(matrix4);
                        }
                        boundingBox.ext(this.tmpV);
                    }
                } else {
                    for (int i7 = n2; i7 < n10; ++i7) {
                        int n16 = i7 * n9 + n8;
                        this.tmpV.set(floatBuffer.get(n16), floatBuffer.get(n16 + 1), floatBuffer.get(n16 + 2));
                        if (matrix4 != null) {
                            this.tmpV.mul(matrix4);
                        }
                        boundingBox.ext(this.tmpV);
                    }
                }
                break;
            }
        }
        return boundingBox;
    }

    public float calculateRadiusSquared(float f2, float f3, float f4, int n2, int n3, Matrix4 matrix4) {
        int n4 = this.getNumIndices();
        if (n2 < 0 || n3 < 1 || n2 + n3 > n4) {
            throw new GdxRuntimeException("Not enough indices");
        }
        FloatBuffer floatBuffer = this.vertices.getBuffer();
        ShortBuffer shortBuffer = this.indices.getBuffer();
        VertexAttribute vertexAttribute = this.getVertexAttribute(1);
        int n5 = vertexAttribute.offset / 4;
        int n6 = this.vertices.getAttributes().vertexSize / 4;
        int n7 = n2 + n3;
        float f5 = 0.0f;
        switch (vertexAttribute.numComponents) {
            case 1: {
                for (int i2 = n2; i2 < n7; ++i2) {
                    float f6;
                    int n8 = (shortBuffer.get(i2) & 0xFFFF) * n6 + n5;
                    this.tmpV.set(floatBuffer.get(n8), 0.0f, 0.0f);
                    if (matrix4 != null) {
                        this.tmpV.mul(matrix4);
                    }
                    if (!((f6 = this.tmpV.sub(f2, f3, f4).len2()) > f5)) continue;
                    f5 = f6;
                }
                break;
            }
            case 2: {
                for (int i3 = n2; i3 < n7; ++i3) {
                    float f7;
                    int n9 = (shortBuffer.get(i3) & 0xFFFF) * n6 + n5;
                    this.tmpV.set(floatBuffer.get(n9), floatBuffer.get(n9 + 1), 0.0f);
                    if (matrix4 != null) {
                        this.tmpV.mul(matrix4);
                    }
                    if (!((f7 = this.tmpV.sub(f2, f3, f4).len2()) > f5)) continue;
                    f5 = f7;
                }
                break;
            }
            case 3: {
                for (int i4 = n2; i4 < n7; ++i4) {
                    float f8;
                    int n10 = (shortBuffer.get(i4) & 0xFFFF) * n6 + n5;
                    this.tmpV.set(floatBuffer.get(n10), floatBuffer.get(n10 + 1), floatBuffer.get(n10 + 2));
                    if (matrix4 != null) {
                        this.tmpV.mul(matrix4);
                    }
                    if (!((f8 = this.tmpV.sub(f2, f3, f4).len2()) > f5)) continue;
                    f5 = f8;
                }
                break;
            }
        }
        return f5;
    }

    public float calculateRadius(float f2, float f3, float f4, int n2, int n3, Matrix4 matrix4) {
        return (float)Math.sqrt(this.calculateRadiusSquared(f2, f3, f4, n2, n3, matrix4));
    }

    public float calculateRadius(Vector3 vector3, int n2, int n3, Matrix4 matrix4) {
        return this.calculateRadius(vector3.x, vector3.y, vector3.z, n2, n3, matrix4);
    }

    public float calculateRadius(float f2, float f3, float f4, int n2, int n3) {
        return this.calculateRadius(f2, f3, f4, n2, n3, null);
    }

    public float calculateRadius(Vector3 vector3, int n2, int n3) {
        return this.calculateRadius(vector3.x, vector3.y, vector3.z, n2, n3, null);
    }

    public float calculateRadius(float f2, float f3, float f4) {
        return this.calculateRadius(f2, f3, f4, 0, this.getNumIndices(), null);
    }

    public float calculateRadius(Vector3 vector3) {
        return this.calculateRadius(vector3.x, vector3.y, vector3.z, 0, this.getNumIndices(), null);
    }

    public ShortBuffer getIndicesBuffer() {
        return this.indices.getBuffer();
    }

    private static void addManagedMesh(Application application, Mesh mesh) {
        Array<Mesh> array = meshes.get(application);
        if (array == null) {
            array = new Array();
        }
        array.add(mesh);
        meshes.put(application, array);
    }

    public static void invalidateAllMeshes(Application application) {
        Array<Mesh> array = meshes.get(application);
        if (array == null) {
            return;
        }
        for (int i2 = 0; i2 < array.size; ++i2) {
            array.get((int)i2).vertices.invalidate();
            array.get((int)i2).indices.invalidate();
        }
    }

    public static void clearAllMeshes(Application application) {
        meshes.remove(application);
    }

    public static String getManagedStatus() {
        StringBuilder stringBuilder = new StringBuilder();
        boolean bl2 = false;
        stringBuilder.append("Managed meshes/app: { ");
        for (Application application : meshes.keySet()) {
            stringBuilder.append(Mesh.meshes.get((Object)application).size);
            stringBuilder.append(" ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public void scale(float f2, float f3, float f4) {
        VertexAttribute vertexAttribute = this.getVertexAttribute(1);
        int n2 = vertexAttribute.offset / 4;
        int n3 = vertexAttribute.numComponents;
        int n4 = this.getNumVertices();
        int n5 = this.getVertexSize() / 4;
        float[] fArray = new float[n4 * n5];
        this.getVertices(fArray);
        int n6 = n2;
        switch (n3) {
            case 1: {
                for (int i2 = 0; i2 < n4; ++i2) {
                    int n7 = n6;
                    fArray[n7] = fArray[n7] * f2;
                    n6 += n5;
                }
                break;
            }
            case 2: {
                for (int i3 = 0; i3 < n4; ++i3) {
                    int n8 = n6;
                    fArray[n8] = fArray[n8] * f2;
                    int n9 = n6 + 1;
                    fArray[n9] = fArray[n9] * f3;
                    n6 += n5;
                }
                break;
            }
            case 3: {
                for (int i4 = 0; i4 < n4; ++i4) {
                    int n10 = n6;
                    fArray[n10] = fArray[n10] * f2;
                    int n11 = n6 + 1;
                    fArray[n11] = fArray[n11] * f3;
                    int n12 = n6 + 2;
                    fArray[n12] = fArray[n12] * f4;
                    n6 += n5;
                }
                break;
            }
        }
        this.setVertices(fArray);
    }

    public void transform(Matrix4 matrix4) {
        this.transform(matrix4, 0, this.getNumVertices());
    }

    public void transform(Matrix4 matrix4, int n2, int n3) {
        VertexAttribute vertexAttribute = this.getVertexAttribute(1);
        int n4 = vertexAttribute.offset / 4;
        int n5 = this.getVertexSize() / 4;
        int n6 = vertexAttribute.numComponents;
        int n7 = this.getNumVertices();
        float[] fArray = new float[n3 * n5];
        this.getVertices(n2 * n5, n3 * n5, fArray);
        Mesh.transform(matrix4, fArray, n5, n4, n6, 0, n3);
        this.updateVertices(n2 * n5, fArray);
    }

    public static void transform(Matrix4 matrix4, float[] fArray, int n2, int n3, int n4, int n5, int n6) {
        if (n3 < 0 || n4 < 1 || n3 + n4 > n2) {
            throw new IndexOutOfBoundsException();
        }
        if (n5 < 0 || n6 < 1 || (n5 + n6) * n2 > fArray.length) {
            throw new IndexOutOfBoundsException("start = " + n5 + ", count = " + n6 + ", vertexSize = " + n2 + ", length = " + fArray.length);
        }
        Vector3 vector3 = new Vector3();
        int n7 = n3 + n5 * n2;
        switch (n4) {
            case 1: {
                for (int i2 = 0; i2 < n6; ++i2) {
                    vector3.set(fArray[n7], 0.0f, 0.0f).mul(matrix4);
                    fArray[n7] = vector3.x;
                    n7 += n2;
                }
                break;
            }
            case 2: {
                for (int i3 = 0; i3 < n6; ++i3) {
                    vector3.set(fArray[n7], fArray[n7 + 1], 0.0f).mul(matrix4);
                    fArray[n7] = vector3.x;
                    fArray[n7 + 1] = vector3.y;
                    n7 += n2;
                }
                break;
            }
            case 3: {
                for (int i4 = 0; i4 < n6; ++i4) {
                    vector3.set(fArray[n7], fArray[n7 + 1], fArray[n7 + 2]).mul(matrix4);
                    fArray[n7] = vector3.x;
                    fArray[n7 + 1] = vector3.y;
                    fArray[n7 + 2] = vector3.z;
                    n7 += n2;
                }
                break;
            }
        }
    }

    public void transformUV(Matrix3 matrix3) {
        this.transformUV(matrix3, 0, this.getNumVertices());
    }

    protected void transformUV(Matrix3 matrix3, int n2, int n3) {
        VertexAttribute vertexAttribute = this.getVertexAttribute(16);
        int n4 = vertexAttribute.offset / 4;
        int n5 = this.getVertexSize() / 4;
        int n6 = this.getNumVertices();
        float[] fArray = new float[n6 * n5];
        this.getVertices(0, fArray.length, fArray);
        Mesh.transformUV(matrix3, fArray, n5, n4, n2, n3);
        this.setVertices(fArray, 0, fArray.length);
    }

    public static void transformUV(Matrix3 matrix3, float[] fArray, int n2, int n3, int n4, int n5) {
        if (n4 < 0 || n5 < 1 || (n4 + n5) * n2 > fArray.length) {
            throw new IndexOutOfBoundsException("start = " + n4 + ", count = " + n5 + ", vertexSize = " + n2 + ", length = " + fArray.length);
        }
        Vector2 vector2 = new Vector2();
        int n6 = n3 + n4 * n2;
        for (int i2 = 0; i2 < n5; ++i2) {
            vector2.set(fArray[n6], fArray[n6 + 1]).mul(matrix3);
            fArray[n6] = vector2.x;
            fArray[n6 + 1] = vector2.y;
            n6 += n2;
        }
    }

    public Mesh copy(boolean bl2, boolean bl3, int[] nArray) {
        int n2;
        int n3;
        int n4;
        int n5;
        int n6 = this.getVertexSize() / 4;
        int n7 = this.getNumVertices();
        float[] fArray = new float[n7 * n6];
        this.getVertices(0, fArray.length, fArray);
        short[] sArray = null;
        VertexAttribute[] vertexAttributeArray = null;
        int n8 = 0;
        if (nArray != null) {
            int n9;
            n5 = 0;
            int n10 = 0;
            for (n9 = 0; n9 < nArray.length; ++n9) {
                if (this.getVertexAttribute(nArray[n9]) == null) continue;
                n5 += this.getVertexAttribute((int)nArray[n9]).numComponents;
                ++n10;
            }
            if (n5 > 0) {
                vertexAttributeArray = new VertexAttribute[n10];
                sArray = new short[n5];
                n9 = -1;
                n4 = -1;
                for (n3 = 0; n3 < nArray.length; ++n3) {
                    VertexAttribute vertexAttribute = this.getVertexAttribute(nArray[n3]);
                    if (vertexAttribute == null) continue;
                    for (n2 = 0; n2 < vertexAttribute.numComponents; ++n2) {
                        sArray[++n9] = (short)(vertexAttribute.offset + n2);
                    }
                    vertexAttributeArray[++n4] = vertexAttribute.copy();
                    n8 += vertexAttribute.numComponents;
                }
            }
        }
        if (sArray == null) {
            sArray = new short[n6];
            for (n5 = 0; n5 < n6; n5 = (int)((short)(n5 + 1))) {
                sArray[n5] = n5;
            }
            n8 = n6;
        }
        n5 = this.getNumIndices();
        short[] sArray2 = null;
        if (n5 > 0) {
            sArray2 = new short[n5];
            this.getIndices(sArray2);
            if (bl3 || n8 != n6) {
                float[] fArray2 = new float[fArray.length];
                n4 = 0;
                for (n3 = 0; n3 < n5; ++n3) {
                    int n11;
                    int n12;
                    int n13 = sArray2[n3] * n6;
                    n2 = -1;
                    if (bl3) {
                        for (n12 = 0; n12 < n4 && n2 < 0; n12 = (int)((short)(n12 + 1))) {
                            n11 = n12 * n8;
                            boolean bl4 = true;
                            for (int i2 = 0; i2 < sArray.length && bl4; ++i2) {
                                if (fArray2[n11 + i2] == fArray[n13 + sArray[i2]]) continue;
                                bl4 = false;
                            }
                            if (!bl4) continue;
                            n2 = n12;
                        }
                    }
                    if (n2 > 0) {
                        sArray2[n3] = n2;
                        continue;
                    }
                    n12 = n4 * n8;
                    for (n11 = 0; n11 < sArray.length; ++n11) {
                        fArray2[n12 + n11] = fArray[n13 + sArray[n11]];
                    }
                    sArray2[n3] = (short)n4;
                    ++n4;
                }
                fArray = fArray2;
                n7 = n4;
            }
        }
        Mesh mesh = vertexAttributeArray == null ? new Mesh(bl2, n7, sArray2 == null ? 0 : sArray2.length, this.getVertexAttributes()) : new Mesh(bl2, n7, sArray2 == null ? 0 : sArray2.length, vertexAttributeArray);
        mesh.setVertices(fArray, 0, n7 * n8);
        if (sArray2 != null) {
            mesh.setIndices(sArray2);
        }
        return mesh;
    }

    public Mesh copy(boolean bl2) {
        return this.copy(bl2, false, null);
    }

    public static enum VertexDataType {
        VertexArray,
        VertexBufferObject,
        VertexBufferObjectSubData,
        VertexBufferObjectWithVAO;

    }
}

