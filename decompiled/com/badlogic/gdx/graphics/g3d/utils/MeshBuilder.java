/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.utils;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g3d.model.MeshPart;
import com.badlogic.gdx.graphics.g3d.utils.MeshPartBuilder;
import com.badlogic.gdx.graphics.g3d.utils.shapebuilders.ArrowShapeBuilder;
import com.badlogic.gdx.graphics.g3d.utils.shapebuilders.BoxShapeBuilder;
import com.badlogic.gdx.graphics.g3d.utils.shapebuilders.CapsuleShapeBuilder;
import com.badlogic.gdx.graphics.g3d.utils.shapebuilders.ConeShapeBuilder;
import com.badlogic.gdx.graphics.g3d.utils.shapebuilders.CylinderShapeBuilder;
import com.badlogic.gdx.graphics.g3d.utils.shapebuilders.EllipseShapeBuilder;
import com.badlogic.gdx.graphics.g3d.utils.shapebuilders.PatchShapeBuilder;
import com.badlogic.gdx.graphics.g3d.utils.shapebuilders.SphereShapeBuilder;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Matrix3;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.BoundingBox;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.FloatArray;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.IntIntMap;
import com.badlogic.gdx.utils.ShortArray;

public class MeshBuilder
implements MeshPartBuilder {
    public static final int MAX_VERTICES = 65536;
    public static final int MAX_INDEX = 65535;
    private static final ShortArray tmpIndices = new ShortArray();
    private static final FloatArray tmpVertices = new FloatArray();
    private final MeshPartBuilder.VertexInfo vertTmp1 = new MeshPartBuilder.VertexInfo();
    private final MeshPartBuilder.VertexInfo vertTmp2 = new MeshPartBuilder.VertexInfo();
    private final MeshPartBuilder.VertexInfo vertTmp3 = new MeshPartBuilder.VertexInfo();
    private final MeshPartBuilder.VertexInfo vertTmp4 = new MeshPartBuilder.VertexInfo();
    private final Color tempC1 = new Color();
    private VertexAttributes attributes;
    private FloatArray vertices = new FloatArray();
    private ShortArray indices = new ShortArray();
    private int stride;
    private int vindex;
    private int istart;
    private int posOffset;
    private int posSize;
    private int norOffset;
    private int biNorOffset;
    private int tangentOffset;
    private int colOffset;
    private int colSize;
    private int cpOffset;
    private int uvOffset;
    private MeshPart part;
    private Array<MeshPart> parts = new Array();
    private final Color color = new Color(Color.WHITE);
    private boolean hasColor = false;
    private int primitiveType;
    private float uOffset = 0.0f;
    private float uScale = 1.0f;
    private float vOffset = 0.0f;
    private float vScale = 1.0f;
    private boolean hasUVTransform = false;
    private float[] vertex;
    private boolean vertexTransformationEnabled = false;
    private final Matrix4 positionTransform = new Matrix4();
    private final Matrix3 normalTransform = new Matrix3();
    private final BoundingBox bounds = new BoundingBox();
    private int lastIndex = -1;
    private static final Vector3 vTmp = new Vector3();
    private final Vector3 tmpNormal = new Vector3();
    private static IntIntMap indicesMap = null;

    public static VertexAttributes createAttributes(long l2) {
        Array<VertexAttribute> array = new Array<VertexAttribute>();
        if ((l2 & 1L) == 1L) {
            array.add(new VertexAttribute(1, 3, "a_position"));
        }
        if ((l2 & 2L) == 2L) {
            array.add(new VertexAttribute(2, 4, "a_color"));
        }
        if ((l2 & 4L) == 4L) {
            array.add(new VertexAttribute(4, 4, "a_color"));
        }
        if ((l2 & 8L) == 8L) {
            array.add(new VertexAttribute(8, 3, "a_normal"));
        }
        if ((l2 & 0x10L) == 16L) {
            array.add(new VertexAttribute(16, 2, "a_texCoord0"));
        }
        VertexAttribute[] vertexAttributeArray = new VertexAttribute[array.size];
        for (int i2 = 0; i2 < vertexAttributeArray.length; ++i2) {
            vertexAttributeArray[i2] = (VertexAttribute)array.get(i2);
        }
        return new VertexAttributes(vertexAttributeArray);
    }

    public void begin(long l2) {
        this.begin(MeshBuilder.createAttributes(l2), -1);
    }

    public void begin(VertexAttributes vertexAttributes) {
        this.begin(vertexAttributes, -1);
    }

    public void begin(long l2, int n2) {
        this.begin(MeshBuilder.createAttributes(l2), n2);
    }

    public void begin(VertexAttributes vertexAttributes, int n2) {
        VertexAttribute vertexAttribute;
        if (this.attributes != null) {
            throw new RuntimeException("Call end() first");
        }
        this.attributes = vertexAttributes;
        this.vertices.clear();
        this.indices.clear();
        this.parts.clear();
        this.vindex = 0;
        this.lastIndex = -1;
        this.istart = 0;
        this.part = null;
        this.stride = vertexAttributes.vertexSize / 4;
        if (this.vertex == null || this.vertex.length < this.stride) {
            this.vertex = new float[this.stride];
        }
        if ((vertexAttribute = vertexAttributes.findByUsage(1)) == null) {
            throw new GdxRuntimeException("Cannot build mesh without position attribute");
        }
        this.posOffset = vertexAttribute.offset / 4;
        this.posSize = vertexAttribute.numComponents;
        vertexAttribute = vertexAttributes.findByUsage(8);
        this.norOffset = vertexAttribute == null ? -1 : vertexAttribute.offset / 4;
        vertexAttribute = vertexAttributes.findByUsage(256);
        this.biNorOffset = vertexAttribute == null ? -1 : vertexAttribute.offset / 4;
        vertexAttribute = vertexAttributes.findByUsage(128);
        this.tangentOffset = vertexAttribute == null ? -1 : vertexAttribute.offset / 4;
        vertexAttribute = vertexAttributes.findByUsage(2);
        this.colOffset = vertexAttribute == null ? -1 : vertexAttribute.offset / 4;
        this.colSize = vertexAttribute == null ? 0 : vertexAttribute.numComponents;
        vertexAttribute = vertexAttributes.findByUsage(4);
        this.cpOffset = vertexAttribute == null ? -1 : vertexAttribute.offset / 4;
        vertexAttribute = vertexAttributes.findByUsage(16);
        this.uvOffset = vertexAttribute == null ? -1 : vertexAttribute.offset / 4;
        this.setColor(null);
        this.setVertexTransform(null);
        this.setUVRange(null);
        this.primitiveType = n2;
        this.bounds.inf();
    }

    private void endpart() {
        if (this.part != null) {
            this.bounds.getCenter(this.part.center);
            this.bounds.getDimensions(this.part.halfExtents).scl(0.5f);
            this.part.radius = this.part.halfExtents.len();
            this.bounds.inf();
            this.part.offset = this.istart;
            this.part.size = this.indices.size - this.istart;
            this.istart = this.indices.size;
            this.part = null;
        }
    }

    public MeshPart part(String string, int n2) {
        return this.part(string, n2, new MeshPart());
    }

    public MeshPart part(String string, int n2, MeshPart meshPart) {
        if (this.attributes == null) {
            throw new RuntimeException("Call begin() first");
        }
        this.endpart();
        this.part = meshPart;
        this.part.id = string;
        this.primitiveType = this.part.primitiveType = n2;
        this.parts.add(this.part);
        this.setColor(null);
        this.setVertexTransform(null);
        this.setUVRange(null);
        return this.part;
    }

    public Mesh end(Mesh mesh) {
        this.endpart();
        if (this.attributes == null) {
            throw new GdxRuntimeException("Call begin() first");
        }
        if (!this.attributes.equals(mesh.getVertexAttributes())) {
            throw new GdxRuntimeException("Mesh attributes don't match");
        }
        if (mesh.getMaxVertices() * this.stride < this.vertices.size) {
            throw new GdxRuntimeException("Mesh can't hold enough vertices: " + mesh.getMaxVertices() + " * " + this.stride + " < " + this.vertices.size);
        }
        if (mesh.getMaxIndices() < this.indices.size) {
            throw new GdxRuntimeException("Mesh can't hold enough indices: " + mesh.getMaxIndices() + " < " + this.indices.size);
        }
        mesh.setVertices(this.vertices.items, 0, this.vertices.size);
        mesh.setIndices(this.indices.items, 0, this.indices.size);
        for (MeshPart meshPart : this.parts) {
            meshPart.mesh = mesh;
        }
        this.parts.clear();
        this.attributes = null;
        this.vertices.clear();
        this.indices.clear();
        return mesh;
    }

    public Mesh end() {
        return this.end(new Mesh(true, this.vertices.size / this.stride, this.indices.size, this.attributes));
    }

    public void clear() {
        this.vertices.clear();
        this.indices.clear();
        this.parts.clear();
        this.vindex = 0;
        this.lastIndex = -1;
        this.istart = 0;
        this.part = null;
    }

    public int getFloatsPerVertex() {
        return this.stride;
    }

    public int getNumVertices() {
        return this.vertices.size / this.stride;
    }

    public void getVertices(float[] fArray, int n2) {
        if (this.attributes == null) {
            throw new GdxRuntimeException("Must be called in between #begin and #end");
        }
        if (n2 < 0 || n2 > fArray.length - this.vertices.size) {
            throw new GdxRuntimeException("Array too small or offset out of range");
        }
        System.arraycopy(this.vertices.items, 0, fArray, n2, this.vertices.size);
    }

    protected float[] getVertices() {
        return this.vertices.items;
    }

    public int getNumIndices() {
        return this.indices.size;
    }

    public void getIndices(short[] sArray, int n2) {
        if (this.attributes == null) {
            throw new GdxRuntimeException("Must be called in between #begin and #end");
        }
        if (n2 < 0 || n2 > sArray.length - this.indices.size) {
            throw new GdxRuntimeException("Array too small or offset out of range");
        }
        System.arraycopy(this.indices.items, 0, sArray, n2, this.indices.size);
    }

    protected short[] getIndices() {
        return this.indices.items;
    }

    @Override
    public VertexAttributes getAttributes() {
        return this.attributes;
    }

    @Override
    public MeshPart getMeshPart() {
        return this.part;
    }

    @Override
    public int getPrimitiveType() {
        return this.primitiveType;
    }

    @Override
    public void setColor(float f2, float f3, float f4, float f5) {
        this.color.set(f2, f3, f4, f5);
        this.hasColor = !this.color.equals(Color.WHITE);
    }

    @Override
    public void setColor(Color color) {
        this.hasColor = color != null;
        this.color.set(!this.hasColor ? Color.WHITE : color);
    }

    @Override
    public void setUVRange(float f2, float f3, float f4, float f5) {
        this.uOffset = f2;
        this.vOffset = f3;
        this.uScale = f4 - f2;
        this.vScale = f5 - f3;
        this.hasUVTransform = !MathUtils.isZero(f2) || !MathUtils.isZero(f3) || !MathUtils.isEqual(f4, 1.0f) || !MathUtils.isEqual(f5, 1.0f);
    }

    @Override
    public void setUVRange(TextureRegion textureRegion) {
        if (textureRegion == null) {
            this.hasUVTransform = false;
            this.vOffset = 0.0f;
            this.uOffset = 0.0f;
            this.vScale = 1.0f;
            this.uScale = 1.0f;
        } else {
            this.hasUVTransform = true;
            this.setUVRange(textureRegion.getU(), textureRegion.getV(), textureRegion.getU2(), textureRegion.getV2());
        }
    }

    @Override
    public Matrix4 getVertexTransform(Matrix4 matrix4) {
        return matrix4.set(this.positionTransform);
    }

    @Override
    public void setVertexTransform(Matrix4 matrix4) {
        boolean bl2 = this.vertexTransformationEnabled = matrix4 != null;
        if (this.vertexTransformationEnabled) {
            this.positionTransform.set(matrix4);
            this.normalTransform.set(matrix4).inv().transpose();
        } else {
            this.positionTransform.idt();
            this.normalTransform.idt();
        }
    }

    @Override
    public boolean isVertexTransformationEnabled() {
        return this.vertexTransformationEnabled;
    }

    @Override
    public void setVertexTransformationEnabled(boolean bl2) {
        this.vertexTransformationEnabled = bl2;
    }

    @Override
    public void ensureVertices(int n2) {
        this.vertices.ensureCapacity(this.stride * n2);
    }

    @Override
    public void ensureIndices(int n2) {
        this.indices.ensureCapacity(n2);
    }

    @Override
    public void ensureCapacity(int n2, int n3) {
        this.ensureVertices(n2);
        this.ensureIndices(n3);
    }

    @Override
    public void ensureTriangleIndices(int n2) {
        if (this.primitiveType == 1) {
            this.ensureIndices(6 * n2);
        } else if (this.primitiveType == 4 || this.primitiveType == 0) {
            this.ensureIndices(3 * n2);
        } else {
            throw new GdxRuntimeException("Incorrect primtive type");
        }
    }

    @Deprecated
    public void ensureTriangles(int n2, int n3) {
        this.ensureVertices(n2);
        this.ensureTriangleIndices(n3);
    }

    @Deprecated
    public void ensureTriangles(int n2) {
        this.ensureVertices(3 * n2);
        this.ensureTriangleIndices(n2);
    }

    @Override
    public void ensureRectangleIndices(int n2) {
        if (this.primitiveType == 0) {
            this.ensureIndices(4 * n2);
        } else if (this.primitiveType == 1) {
            this.ensureIndices(8 * n2);
        } else {
            this.ensureIndices(6 * n2);
        }
    }

    @Deprecated
    public void ensureRectangles(int n2, int n3) {
        this.ensureVertices(n2);
        this.ensureRectangleIndices(n3);
    }

    @Deprecated
    public void ensureRectangles(int n2) {
        this.ensureVertices(4 * n2);
        this.ensureRectangleIndices(n2);
    }

    @Override
    public short lastIndex() {
        return (short)this.lastIndex;
    }

    private static final void transformPosition(float[] fArray, int n2, int n3, Matrix4 matrix4) {
        if (n3 > 2) {
            vTmp.set(fArray[n2], fArray[n2 + 1], fArray[n2 + 2]).mul(matrix4);
            fArray[n2] = MeshBuilder.vTmp.x;
            fArray[n2 + 1] = MeshBuilder.vTmp.y;
            fArray[n2 + 2] = MeshBuilder.vTmp.z;
        } else if (n3 > 1) {
            vTmp.set(fArray[n2], fArray[n2 + 1], 0.0f).mul(matrix4);
            fArray[n2] = MeshBuilder.vTmp.x;
            fArray[n2 + 1] = MeshBuilder.vTmp.y;
        } else {
            fArray[n2] = MeshBuilder.vTmp.set((float)fArray[n2], (float)0.0f, (float)0.0f).mul((Matrix4)matrix4).x;
        }
    }

    private static final void transformNormal(float[] fArray, int n2, int n3, Matrix3 matrix3) {
        if (n3 > 2) {
            vTmp.set(fArray[n2], fArray[n2 + 1], fArray[n2 + 2]).mul(matrix3).nor();
            fArray[n2] = MeshBuilder.vTmp.x;
            fArray[n2 + 1] = MeshBuilder.vTmp.y;
            fArray[n2 + 2] = MeshBuilder.vTmp.z;
        } else if (n3 > 1) {
            vTmp.set(fArray[n2], fArray[n2 + 1], 0.0f).mul(matrix3).nor();
            fArray[n2] = MeshBuilder.vTmp.x;
            fArray[n2 + 1] = MeshBuilder.vTmp.y;
        } else {
            fArray[n2] = MeshBuilder.vTmp.set((float)fArray[n2], (float)0.0f, (float)0.0f).mul((Matrix3)matrix3).nor().x;
        }
    }

    private final void addVertex(float[] fArray, int n2) {
        int n3 = this.vertices.size;
        this.vertices.addAll(fArray, n2, this.stride);
        this.lastIndex = this.vindex++;
        if (this.vertexTransformationEnabled) {
            MeshBuilder.transformPosition(this.vertices.items, n3 + this.posOffset, this.posSize, this.positionTransform);
            if (this.norOffset >= 0) {
                MeshBuilder.transformNormal(this.vertices.items, n3 + this.norOffset, 3, this.normalTransform);
            }
            if (this.biNorOffset >= 0) {
                MeshBuilder.transformNormal(this.vertices.items, n3 + this.biNorOffset, 3, this.normalTransform);
            }
            if (this.tangentOffset >= 0) {
                MeshBuilder.transformNormal(this.vertices.items, n3 + this.tangentOffset, 3, this.normalTransform);
            }
        }
        float f2 = this.vertices.items[n3 + this.posOffset];
        float f3 = this.posSize > 1 ? this.vertices.items[n3 + this.posOffset + 1] : 0.0f;
        float f4 = this.posSize > 2 ? this.vertices.items[n3 + this.posOffset + 2] : 0.0f;
        this.bounds.ext(f2, f3, f4);
        if (this.hasColor) {
            if (this.colOffset >= 0) {
                int n4 = n3 + this.colOffset;
                this.vertices.items[n4] = this.vertices.items[n4] * this.color.r;
                int n5 = n3 + this.colOffset + 1;
                this.vertices.items[n5] = this.vertices.items[n5] * this.color.g;
                int n6 = n3 + this.colOffset + 2;
                this.vertices.items[n6] = this.vertices.items[n6] * this.color.b;
                if (this.colSize > 3) {
                    int n7 = n3 + this.colOffset + 3;
                    this.vertices.items[n7] = this.vertices.items[n7] * this.color.a;
                }
            } else if (this.cpOffset >= 0) {
                Color.abgr8888ToColor(this.tempC1, this.vertices.items[n3 + this.cpOffset]);
                this.vertices.items[n3 + this.cpOffset] = this.tempC1.mul(this.color).toFloatBits();
            }
        }
        if (this.hasUVTransform && this.uvOffset >= 0) {
            this.vertices.items[n3 + this.uvOffset] = this.uOffset + this.uScale * this.vertices.items[n3 + this.uvOffset];
            this.vertices.items[n3 + this.uvOffset + 1] = this.vOffset + this.vScale * this.vertices.items[n3 + this.uvOffset + 1];
        }
    }

    @Override
    public short vertex(Vector3 vector3, Vector3 vector32, Color color, Vector2 vector2) {
        if (this.vindex > 65535) {
            throw new GdxRuntimeException("Too many vertices used");
        }
        this.vertex[this.posOffset] = vector3.x;
        if (this.posSize > 1) {
            this.vertex[this.posOffset + 1] = vector3.y;
        }
        if (this.posSize > 2) {
            this.vertex[this.posOffset + 2] = vector3.z;
        }
        if (this.norOffset >= 0) {
            if (vector32 == null) {
                vector32 = this.tmpNormal.set(vector3).nor();
            }
            this.vertex[this.norOffset] = vector32.x;
            this.vertex[this.norOffset + 1] = vector32.y;
            this.vertex[this.norOffset + 2] = vector32.z;
        }
        if (this.colOffset >= 0) {
            if (color == null) {
                color = Color.WHITE;
            }
            this.vertex[this.colOffset] = color.r;
            this.vertex[this.colOffset + 1] = color.g;
            this.vertex[this.colOffset + 2] = color.b;
            if (this.colSize > 3) {
                this.vertex[this.colOffset + 3] = color.a;
            }
        } else if (this.cpOffset > 0) {
            if (color == null) {
                color = Color.WHITE;
            }
            this.vertex[this.cpOffset] = color.toFloatBits();
        }
        if (vector2 != null && this.uvOffset >= 0) {
            this.vertex[this.uvOffset] = vector2.x;
            this.vertex[this.uvOffset + 1] = vector2.y;
        }
        this.addVertex(this.vertex, 0);
        return (short)this.lastIndex;
    }

    @Override
    public short vertex(float ... fArray) {
        int n2 = fArray.length - this.stride;
        for (int i2 = 0; i2 <= n2; i2 += this.stride) {
            this.addVertex(fArray, i2);
        }
        return (short)this.lastIndex;
    }

    @Override
    public short vertex(MeshPartBuilder.VertexInfo vertexInfo) {
        return this.vertex(vertexInfo.hasPosition ? vertexInfo.position : null, vertexInfo.hasNormal ? vertexInfo.normal : null, vertexInfo.hasColor ? vertexInfo.color : null, vertexInfo.hasUV ? vertexInfo.uv : null);
    }

    @Override
    public void index(short s2) {
        this.indices.add(s2);
    }

    @Override
    public void index(short s2, short s3) {
        this.ensureIndices(2);
        this.indices.add(s2);
        this.indices.add(s3);
    }

    @Override
    public void index(short s2, short s3, short s4) {
        this.ensureIndices(3);
        this.indices.add(s2);
        this.indices.add(s3);
        this.indices.add(s4);
    }

    @Override
    public void index(short s2, short s3, short s4, short s5) {
        this.ensureIndices(4);
        this.indices.add(s2);
        this.indices.add(s3);
        this.indices.add(s4);
        this.indices.add(s5);
    }

    @Override
    public void index(short s2, short s3, short s4, short s5, short s6, short s7) {
        this.ensureIndices(6);
        this.indices.add(s2);
        this.indices.add(s3);
        this.indices.add(s4);
        this.indices.add(s5);
        this.indices.add(s6);
        this.indices.add(s7);
    }

    @Override
    public void index(short s2, short s3, short s4, short s5, short s6, short s7, short s8, short s9) {
        this.ensureIndices(8);
        this.indices.add(s2);
        this.indices.add(s3);
        this.indices.add(s4);
        this.indices.add(s5);
        this.indices.add(s6);
        this.indices.add(s7);
        this.indices.add(s8);
        this.indices.add(s9);
    }

    @Override
    public void line(short s2, short s3) {
        if (this.primitiveType != 1) {
            throw new GdxRuntimeException("Incorrect primitive type");
        }
        this.index(s2, s3);
    }

    @Override
    public void line(MeshPartBuilder.VertexInfo vertexInfo, MeshPartBuilder.VertexInfo vertexInfo2) {
        this.ensureVertices(2);
        this.line(this.vertex(vertexInfo), this.vertex(vertexInfo2));
    }

    @Override
    public void line(Vector3 vector3, Vector3 vector32) {
        this.line(this.vertTmp1.set(vector3, null, null, null), this.vertTmp2.set(vector32, null, null, null));
    }

    @Override
    public void line(float f2, float f3, float f4, float f5, float f6, float f7) {
        this.line(this.vertTmp1.set(null, null, null, null).setPos(f2, f3, f4), this.vertTmp2.set(null, null, null, null).setPos(f5, f6, f7));
    }

    @Override
    public void line(Vector3 vector3, Color color, Vector3 vector32, Color color2) {
        this.line(this.vertTmp1.set(vector3, null, color, null), this.vertTmp2.set(vector32, null, color2, null));
    }

    @Override
    public void triangle(short s2, short s3, short s4) {
        if (this.primitiveType == 4 || this.primitiveType == 0) {
            this.index(s2, s3, s4);
        } else if (this.primitiveType == 1) {
            this.index(s2, s3, s3, s4, s4, s2);
        } else {
            throw new GdxRuntimeException("Incorrect primitive type");
        }
    }

    @Override
    public void triangle(MeshPartBuilder.VertexInfo vertexInfo, MeshPartBuilder.VertexInfo vertexInfo2, MeshPartBuilder.VertexInfo vertexInfo3) {
        this.ensureVertices(3);
        this.triangle(this.vertex(vertexInfo), this.vertex(vertexInfo2), this.vertex(vertexInfo3));
    }

    @Override
    public void triangle(Vector3 vector3, Vector3 vector32, Vector3 vector33) {
        this.triangle(this.vertTmp1.set(vector3, null, null, null), this.vertTmp2.set(vector32, null, null, null), this.vertTmp3.set(vector33, null, null, null));
    }

    @Override
    public void triangle(Vector3 vector3, Color color, Vector3 vector32, Color color2, Vector3 vector33, Color color3) {
        this.triangle(this.vertTmp1.set(vector3, null, color, null), this.vertTmp2.set(vector32, null, color2, null), this.vertTmp3.set(vector33, null, color3, null));
    }

    @Override
    public void rect(short s2, short s3, short s4, short s5) {
        if (this.primitiveType == 4) {
            this.index(s2, s3, s4, s4, s5, s2);
        } else if (this.primitiveType == 1) {
            this.index(s2, s3, s3, s4, s4, s5, s5, s2);
        } else if (this.primitiveType == 0) {
            this.index(s2, s3, s4, s5);
        } else {
            throw new GdxRuntimeException("Incorrect primitive type");
        }
    }

    @Override
    public void rect(MeshPartBuilder.VertexInfo vertexInfo, MeshPartBuilder.VertexInfo vertexInfo2, MeshPartBuilder.VertexInfo vertexInfo3, MeshPartBuilder.VertexInfo vertexInfo4) {
        this.ensureVertices(4);
        this.rect(this.vertex(vertexInfo), this.vertex(vertexInfo2), this.vertex(vertexInfo3), this.vertex(vertexInfo4));
    }

    @Override
    public void rect(Vector3 vector3, Vector3 vector32, Vector3 vector33, Vector3 vector34, Vector3 vector35) {
        this.rect(this.vertTmp1.set(vector3, vector35, null, null).setUV(0.0f, 1.0f), this.vertTmp2.set(vector32, vector35, null, null).setUV(1.0f, 1.0f), this.vertTmp3.set(vector33, vector35, null, null).setUV(1.0f, 0.0f), this.vertTmp4.set(vector34, vector35, null, null).setUV(0.0f, 0.0f));
    }

    @Override
    public void rect(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16) {
        this.rect(this.vertTmp1.set(null, null, null, null).setPos(f2, f3, f4).setNor(f14, f15, f16).setUV(0.0f, 1.0f), this.vertTmp2.set(null, null, null, null).setPos(f5, f6, f7).setNor(f14, f15, f16).setUV(1.0f, 1.0f), this.vertTmp3.set(null, null, null, null).setPos(f8, f9, f10).setNor(f14, f15, f16).setUV(1.0f, 0.0f), this.vertTmp4.set(null, null, null, null).setPos(f11, f12, f13).setNor(f14, f15, f16).setUV(0.0f, 0.0f));
    }

    @Override
    public void addMesh(Mesh mesh) {
        this.addMesh(mesh, 0, mesh.getNumIndices());
    }

    @Override
    public void addMesh(MeshPart meshPart) {
        if (meshPart.primitiveType != this.primitiveType) {
            throw new GdxRuntimeException("Primitive type doesn't match");
        }
        this.addMesh(meshPart.mesh, meshPart.offset, meshPart.size);
    }

    @Override
    public void addMesh(Mesh mesh, int n2, int n3) {
        if (!this.attributes.equals(mesh.getVertexAttributes())) {
            throw new GdxRuntimeException("Vertex attributes do not match");
        }
        if (n3 <= 0) {
            return;
        }
        int n4 = mesh.getNumVertices() * this.stride;
        tmpVertices.clear();
        tmpVertices.ensureCapacity(n4);
        MeshBuilder.tmpVertices.size = n4;
        mesh.getVertices(MeshBuilder.tmpVertices.items);
        tmpIndices.clear();
        tmpIndices.ensureCapacity(n3);
        MeshBuilder.tmpIndices.size = n3;
        mesh.getIndices(n2, n3, MeshBuilder.tmpIndices.items, 0);
        this.addMesh(MeshBuilder.tmpVertices.items, MeshBuilder.tmpIndices.items, 0, n3);
    }

    @Override
    public void addMesh(float[] fArray, short[] sArray, int n2, int n3) {
        if (indicesMap == null) {
            indicesMap = new IntIntMap(n3);
        } else {
            indicesMap.clear();
            indicesMap.ensureCapacity(n3);
        }
        this.ensureIndices(n3);
        int n4 = fArray.length / this.stride;
        this.ensureVertices(n4 < n3 ? n4 : n3);
        for (int i2 = 0; i2 < n3; ++i2) {
            int n5 = sArray[n2 + i2] & 0xFFFF;
            int n6 = indicesMap.get(n5, -1);
            if (n6 < 0) {
                this.addVertex(fArray, n5 * this.stride);
                n6 = this.lastIndex;
                indicesMap.put(n5, n6);
            }
            this.index((short)n6);
        }
    }

    @Override
    public void addMesh(float[] fArray, short[] sArray) {
        int n2;
        int n3 = this.lastIndex + 1;
        int n4 = fArray.length / this.stride;
        this.ensureVertices(n4);
        for (n2 = 0; n2 < fArray.length; n2 += this.stride) {
            this.addVertex(fArray, n2);
        }
        this.ensureIndices(sArray.length);
        for (n2 = 0; n2 < sArray.length; ++n2) {
            this.index((short)(sArray[n2] + n3));
        }
    }

    @Override
    @Deprecated
    public void patch(MeshPartBuilder.VertexInfo vertexInfo, MeshPartBuilder.VertexInfo vertexInfo2, MeshPartBuilder.VertexInfo vertexInfo3, MeshPartBuilder.VertexInfo vertexInfo4, int n2, int n3) {
        PatchShapeBuilder.build(this, vertexInfo, vertexInfo2, vertexInfo3, vertexInfo4, n2, n3);
    }

    @Override
    @Deprecated
    public void patch(Vector3 vector3, Vector3 vector32, Vector3 vector33, Vector3 vector34, Vector3 vector35, int n2, int n3) {
        PatchShapeBuilder.build(this, vector3, vector32, vector33, vector34, vector35, n2, n3);
    }

    @Override
    @Deprecated
    public void patch(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, int n2, int n3) {
        PatchShapeBuilder.build(this, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, n2, n3);
    }

    @Override
    @Deprecated
    public void box(MeshPartBuilder.VertexInfo vertexInfo, MeshPartBuilder.VertexInfo vertexInfo2, MeshPartBuilder.VertexInfo vertexInfo3, MeshPartBuilder.VertexInfo vertexInfo4, MeshPartBuilder.VertexInfo vertexInfo5, MeshPartBuilder.VertexInfo vertexInfo6, MeshPartBuilder.VertexInfo vertexInfo7, MeshPartBuilder.VertexInfo vertexInfo8) {
        BoxShapeBuilder.build((MeshPartBuilder)this, vertexInfo, vertexInfo2, vertexInfo3, vertexInfo4, vertexInfo5, vertexInfo6, vertexInfo7, vertexInfo8);
    }

    @Override
    @Deprecated
    public void box(Vector3 vector3, Vector3 vector32, Vector3 vector33, Vector3 vector34, Vector3 vector35, Vector3 vector36, Vector3 vector37, Vector3 vector38) {
        BoxShapeBuilder.build((MeshPartBuilder)this, vector3, vector32, vector33, vector34, vector35, vector36, vector37, vector38);
    }

    @Override
    @Deprecated
    public void box(Matrix4 matrix4) {
        BoxShapeBuilder.build((MeshPartBuilder)this, matrix4);
    }

    @Override
    @Deprecated
    public void box(float f2, float f3, float f4) {
        BoxShapeBuilder.build(this, f2, f3, f4);
    }

    @Override
    @Deprecated
    public void box(float f2, float f3, float f4, float f5, float f6, float f7) {
        BoxShapeBuilder.build(this, f2, f3, f4, f5, f6, f7);
    }

    @Override
    @Deprecated
    public void circle(float f2, int n2, float f3, float f4, float f5, float f6, float f7, float f8) {
        EllipseShapeBuilder.build((MeshPartBuilder)this, f2, n2, f3, f4, f5, f6, f7, f8);
    }

    @Override
    @Deprecated
    public void circle(float f2, int n2, Vector3 vector3, Vector3 vector32) {
        EllipseShapeBuilder.build(this, f2, n2, vector3, vector32);
    }

    @Override
    @Deprecated
    public void circle(float f2, int n2, Vector3 vector3, Vector3 vector32, Vector3 vector33, Vector3 vector34) {
        EllipseShapeBuilder.build((MeshPartBuilder)this, f2, n2, vector3, vector32, vector33, vector34);
    }

    @Override
    @Deprecated
    public void circle(float f2, int n2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14) {
        EllipseShapeBuilder.build(this, f2, n2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14);
    }

    @Override
    @Deprecated
    public void circle(float f2, int n2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        EllipseShapeBuilder.build(this, f2, n2, f3, f4, f5, f6, f7, f8, f9, f10);
    }

    @Override
    @Deprecated
    public void circle(float f2, int n2, Vector3 vector3, Vector3 vector32, float f3, float f4) {
        EllipseShapeBuilder.build((MeshPartBuilder)this, f2, n2, vector3, vector32, f3, f4);
    }

    @Override
    @Deprecated
    public void circle(float f2, int n2, Vector3 vector3, Vector3 vector32, Vector3 vector33, Vector3 vector34, float f3, float f4) {
        this.circle(f2, n2, vector3.x, vector3.y, vector3.z, vector32.x, vector32.y, vector32.z, vector33.x, vector33.y, vector33.z, vector34.x, vector34.y, vector34.z, f3, f4);
    }

    @Override
    @Deprecated
    public void circle(float f2, int n2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16) {
        EllipseShapeBuilder.build(this, f2, n2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16);
    }

    @Override
    @Deprecated
    public void ellipse(float f2, float f3, int n2, float f4, float f5, float f6, float f7, float f8, float f9) {
        EllipseShapeBuilder.build((MeshPartBuilder)this, f2, f3, n2, f4, f5, f6, f7, f8, f9);
    }

    @Override
    @Deprecated
    public void ellipse(float f2, float f3, int n2, Vector3 vector3, Vector3 vector32) {
        EllipseShapeBuilder.build(this, f2, f3, n2, vector3, vector32);
    }

    @Override
    @Deprecated
    public void ellipse(float f2, float f3, int n2, Vector3 vector3, Vector3 vector32, Vector3 vector33, Vector3 vector34) {
        EllipseShapeBuilder.build((MeshPartBuilder)this, f2, f3, n2, vector3, vector32, vector33, vector34);
    }

    @Override
    @Deprecated
    public void ellipse(float f2, float f3, int n2, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15) {
        EllipseShapeBuilder.build(this, f2, f3, n2, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15);
    }

    @Override
    @Deprecated
    public void ellipse(float f2, float f3, int n2, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11) {
        EllipseShapeBuilder.build((MeshPartBuilder)this, f2, f3, n2, f4, f5, f6, f7, f8, f9, f10, f11);
    }

    @Override
    @Deprecated
    public void ellipse(float f2, float f3, int n2, Vector3 vector3, Vector3 vector32, float f4, float f5) {
        EllipseShapeBuilder.build((MeshPartBuilder)this, f2, f3, n2, vector3, vector32, f4, f5);
    }

    @Override
    @Deprecated
    public void ellipse(float f2, float f3, int n2, Vector3 vector3, Vector3 vector32, Vector3 vector33, Vector3 vector34, float f4, float f5) {
        EllipseShapeBuilder.build((MeshPartBuilder)this, f2, f3, n2, vector3, vector32, vector33, vector34, f4, f5);
    }

    @Override
    @Deprecated
    public void ellipse(float f2, float f3, int n2, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17) {
        EllipseShapeBuilder.build(this, f2, f3, n2, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17);
    }

    @Override
    @Deprecated
    public void ellipse(float f2, float f3, float f4, float f5, int n2, Vector3 vector3, Vector3 vector32) {
        EllipseShapeBuilder.build((MeshPartBuilder)this, f2, f3, f4, f5, n2, vector3, vector32);
    }

    @Override
    @Deprecated
    public void ellipse(float f2, float f3, float f4, float f5, int n2, float f6, float f7, float f8, float f9, float f10, float f11) {
        EllipseShapeBuilder.build((MeshPartBuilder)this, f2, f3, f4, f5, n2, f6, f7, f8, f9, f10, f11);
    }

    @Override
    @Deprecated
    public void ellipse(float f2, float f3, float f4, float f5, int n2, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13) {
        EllipseShapeBuilder.build(this, f2, f3, f4, f5, n2, f6, f7, f8, f9, f10, f11, f12, f13);
    }

    @Override
    @Deprecated
    public void ellipse(float f2, float f3, float f4, float f5, int n2, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19) {
        EllipseShapeBuilder.build(this, f2, f3, f4, f5, n2, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, f18, f19);
    }

    @Override
    @Deprecated
    public void cylinder(float f2, float f3, float f4, int n2) {
        CylinderShapeBuilder.build(this, f2, f3, f4, n2);
    }

    @Override
    @Deprecated
    public void cylinder(float f2, float f3, float f4, int n2, float f5, float f6) {
        CylinderShapeBuilder.build(this, f2, f3, f4, n2, f5, f6);
    }

    @Override
    @Deprecated
    public void cylinder(float f2, float f3, float f4, int n2, float f5, float f6, boolean bl2) {
        CylinderShapeBuilder.build(this, f2, f3, f4, n2, f5, f6, bl2);
    }

    @Override
    @Deprecated
    public void cone(float f2, float f3, float f4, int n2) {
        this.cone(f2, f3, f4, n2, 0.0f, 360.0f);
    }

    @Override
    @Deprecated
    public void cone(float f2, float f3, float f4, int n2, float f5, float f6) {
        ConeShapeBuilder.build(this, f2, f3, f4, n2, f5, f6);
    }

    @Override
    @Deprecated
    public void sphere(float f2, float f3, float f4, int n2, int n3) {
        SphereShapeBuilder.build(this, f2, f3, f4, n2, n3);
    }

    @Override
    @Deprecated
    public void sphere(Matrix4 matrix4, float f2, float f3, float f4, int n2, int n3) {
        SphereShapeBuilder.build(this, matrix4, f2, f3, f4, n2, n3);
    }

    @Override
    @Deprecated
    public void sphere(float f2, float f3, float f4, int n2, int n3, float f5, float f6, float f7, float f8) {
        SphereShapeBuilder.build(this, f2, f3, f4, n2, n3, f5, f6, f7, f8);
    }

    @Override
    @Deprecated
    public void sphere(Matrix4 matrix4, float f2, float f3, float f4, int n2, int n3, float f5, float f6, float f7, float f8) {
        SphereShapeBuilder.build(this, matrix4, f2, f3, f4, n2, n3, f5, f6, f7, f8);
    }

    @Override
    @Deprecated
    public void capsule(float f2, float f3, int n2) {
        CapsuleShapeBuilder.build(this, f2, f3, n2);
    }

    @Override
    @Deprecated
    public void arrow(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, int n2) {
        ArrowShapeBuilder.build(this, f2, f3, f4, f5, f6, f7, f8, f9, n2);
    }
}

