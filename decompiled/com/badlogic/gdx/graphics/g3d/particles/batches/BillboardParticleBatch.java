/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.particles.batches;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Renderable;
import com.badlogic.gdx.graphics.g3d.Shader;
import com.badlogic.gdx.graphics.g3d.attributes.BlendingAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.DepthTestAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.TextureAttribute;
import com.badlogic.gdx.graphics.g3d.particles.ParallelArray;
import com.badlogic.gdx.graphics.g3d.particles.ParticleShader;
import com.badlogic.gdx.graphics.g3d.particles.ResourceData;
import com.badlogic.gdx.graphics.g3d.particles.batches.BufferedParticleBatch;
import com.badlogic.gdx.graphics.g3d.particles.renderers.BillboardControllerRenderData;
import com.badlogic.gdx.graphics.g3d.shaders.BaseShader;
import com.badlogic.gdx.graphics.g3d.shaders.DefaultShader;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Matrix3;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pool;

public class BillboardParticleBatch
extends BufferedParticleBatch<BillboardControllerRenderData> {
    protected static final Vector3 TMP_V1 = new Vector3();
    protected static final Vector3 TMP_V2 = new Vector3();
    protected static final Vector3 TMP_V3 = new Vector3();
    protected static final Vector3 TMP_V4 = new Vector3();
    protected static final Vector3 TMP_V5 = new Vector3();
    protected static final Vector3 TMP_V6 = new Vector3();
    protected static final Matrix3 TMP_M3 = new Matrix3();
    protected static final int sizeAndRotationUsage = 512;
    protected static final int directionUsage = 1024;
    private static final VertexAttributes GPU_ATTRIBUTES = new VertexAttributes(new VertexAttribute(1, 3, "a_position"), new VertexAttribute(16, 2, "a_texCoord0"), new VertexAttribute(2, 4, "a_color"), new VertexAttribute(512, 4, "a_sizeAndRotation"));
    private static final VertexAttributes CPU_ATTRIBUTES = new VertexAttributes(new VertexAttribute(1, 3, "a_position"), new VertexAttribute(16, 2, "a_texCoord0"), new VertexAttribute(2, 4, "a_color"));
    private static final int GPU_POSITION_OFFSET = (short)(BillboardParticleBatch.GPU_ATTRIBUTES.findByUsage((int)1).offset / 4);
    private static final int GPU_UV_OFFSET = (short)(BillboardParticleBatch.GPU_ATTRIBUTES.findByUsage((int)16).offset / 4);
    private static final int GPU_SIZE_ROTATION_OFFSET = (short)(BillboardParticleBatch.GPU_ATTRIBUTES.findByUsage((int)512).offset / 4);
    private static final int GPU_COLOR_OFFSET = (short)(BillboardParticleBatch.GPU_ATTRIBUTES.findByUsage((int)2).offset / 4);
    private static final int GPU_VERTEX_SIZE = BillboardParticleBatch.GPU_ATTRIBUTES.vertexSize / 4;
    private static final int CPU_POSITION_OFFSET = (short)(BillboardParticleBatch.CPU_ATTRIBUTES.findByUsage((int)1).offset / 4);
    private static final int CPU_UV_OFFSET = (short)(BillboardParticleBatch.CPU_ATTRIBUTES.findByUsage((int)16).offset / 4);
    private static final int CPU_COLOR_OFFSET = (short)(BillboardParticleBatch.CPU_ATTRIBUTES.findByUsage((int)2).offset / 4);
    private static final int CPU_VERTEX_SIZE = BillboardParticleBatch.CPU_ATTRIBUTES.vertexSize / 4;
    private static final int MAX_PARTICLES_PER_MESH = 8191;
    private static final int MAX_VERTICES_PER_MESH = 32764;
    private RenderablePool renderablePool;
    private Array<Renderable> renderables;
    private float[] vertices;
    private short[] indices;
    private int currentVertexSize = 0;
    private VertexAttributes currentAttributes;
    protected boolean useGPU = false;
    protected ParticleShader.AlignMode mode = ParticleShader.AlignMode.Screen;
    protected Texture texture;
    protected BlendingAttribute blendingAttribute;
    protected DepthTestAttribute depthTestAttribute;
    Shader shader;

    public BillboardParticleBatch(ParticleShader.AlignMode alignMode, boolean bl2, int n2, BlendingAttribute blendingAttribute, DepthTestAttribute depthTestAttribute) {
        super(BillboardControllerRenderData.class);
        this.renderables = new Array();
        this.renderablePool = new RenderablePool();
        this.blendingAttribute = blendingAttribute;
        this.depthTestAttribute = depthTestAttribute;
        if (this.blendingAttribute == null) {
            this.blendingAttribute = new BlendingAttribute(1, 771, 1.0f);
        }
        if (this.depthTestAttribute == null) {
            this.depthTestAttribute = new DepthTestAttribute(515, false);
        }
        this.allocIndices();
        this.initRenderData();
        this.ensureCapacity(n2);
        this.setUseGpu(bl2);
        this.setAlignMode(alignMode);
    }

    public BillboardParticleBatch(ParticleShader.AlignMode alignMode, boolean bl2, int n2) {
        this(alignMode, bl2, n2, null, null);
    }

    public BillboardParticleBatch() {
        this(ParticleShader.AlignMode.Screen, false, 100);
    }

    public BillboardParticleBatch(int n2) {
        this(ParticleShader.AlignMode.Screen, false, n2);
    }

    @Override
    public void allocParticlesData(int n2) {
        this.vertices = new float[this.currentVertexSize * 4 * n2];
        this.allocRenderables(n2);
    }

    protected Renderable allocRenderable() {
        Renderable renderable = new Renderable();
        renderable.meshPart.primitiveType = 4;
        renderable.meshPart.offset = 0;
        renderable.material = new Material(this.blendingAttribute, this.depthTestAttribute, TextureAttribute.createDiffuse(this.texture));
        renderable.meshPart.mesh = new Mesh(false, 32764, 49146, this.currentAttributes);
        renderable.meshPart.mesh.setIndices(this.indices);
        renderable.shader = this.shader;
        return renderable;
    }

    private void allocIndices() {
        int n2 = 49146;
        this.indices = new short[n2];
        int n3 = 0;
        int n4 = 0;
        while (n3 < n2) {
            this.indices[n3] = (short)n4;
            this.indices[n3 + 1] = (short)(n4 + 1);
            this.indices[n3 + 2] = (short)(n4 + 2);
            this.indices[n3 + 3] = (short)(n4 + 2);
            this.indices[n3 + 4] = (short)(n4 + 3);
            this.indices[n3 + 5] = (short)n4;
            n3 += 6;
            n4 += 4;
        }
    }

    private void allocRenderables(int n2) {
        int n3 = MathUtils.ceil(n2 / 8191);
        int n4 = this.renderablePool.getFree();
        if (n4 < n3) {
            int n5 = n3 - n4;
            for (int i2 = 0; i2 < n5; ++i2) {
                this.renderablePool.free(this.renderablePool.newObject());
            }
        }
    }

    protected Shader getShader(Renderable renderable) {
        BaseShader baseShader = this.useGPU ? new ParticleShader(renderable, new ParticleShader.Config(this.mode)) : new DefaultShader(renderable);
        baseShader.init();
        return baseShader;
    }

    private void allocShader() {
        Renderable renderable = this.allocRenderable();
        this.shader = renderable.shader = this.getShader(renderable);
        this.renderablePool.free(renderable);
    }

    private void clearRenderablesPool() {
        this.renderablePool.freeAll(this.renderables);
        int n2 = this.renderablePool.getFree();
        for (int i2 = 0; i2 < n2; ++i2) {
            Renderable renderable = (Renderable)this.renderablePool.obtain();
            renderable.meshPart.mesh.dispose();
        }
        this.renderables.clear();
    }

    public void setVertexData() {
        if (this.useGPU) {
            this.currentAttributes = GPU_ATTRIBUTES;
            this.currentVertexSize = GPU_VERTEX_SIZE;
        } else {
            this.currentAttributes = CPU_ATTRIBUTES;
            this.currentVertexSize = CPU_VERTEX_SIZE;
        }
    }

    private void initRenderData() {
        this.setVertexData();
        this.clearRenderablesPool();
        this.allocShader();
        this.resetCapacity();
    }

    public void setAlignMode(ParticleShader.AlignMode alignMode) {
        if (alignMode != this.mode) {
            this.mode = alignMode;
            if (this.useGPU) {
                this.initRenderData();
                this.allocRenderables(this.bufferedParticlesCount);
            }
        }
    }

    public ParticleShader.AlignMode getAlignMode() {
        return this.mode;
    }

    public void setUseGpu(boolean bl2) {
        if (this.useGPU != bl2) {
            this.useGPU = bl2;
            this.initRenderData();
            this.allocRenderables(this.bufferedParticlesCount);
        }
    }

    public boolean isUseGPU() {
        return this.useGPU;
    }

    public void setTexture(Texture texture) {
        this.renderablePool.freeAll(this.renderables);
        this.renderables.clear();
        int n2 = this.renderablePool.getFree();
        for (int i2 = 0; i2 < n2; ++i2) {
            Renderable renderable = (Renderable)this.renderablePool.obtain();
            TextureAttribute textureAttribute = (TextureAttribute)renderable.material.get(TextureAttribute.Diffuse);
            textureAttribute.textureDescription.texture = texture;
        }
        this.texture = texture;
    }

    public Texture getTexture() {
        return this.texture;
    }

    public BlendingAttribute getBlendingAttribute() {
        return this.blendingAttribute;
    }

    @Override
    public void begin() {
        super.begin();
        this.renderablePool.freeAll(this.renderables);
        this.renderables.clear();
    }

    private static void putVertex(float[] fArray, int n2, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14) {
        fArray[n2 + BillboardParticleBatch.GPU_POSITION_OFFSET] = f2;
        fArray[n2 + BillboardParticleBatch.GPU_POSITION_OFFSET + 1] = f3;
        fArray[n2 + BillboardParticleBatch.GPU_POSITION_OFFSET + 2] = f4;
        fArray[n2 + BillboardParticleBatch.GPU_UV_OFFSET] = f5;
        fArray[n2 + BillboardParticleBatch.GPU_UV_OFFSET + 1] = f6;
        fArray[n2 + BillboardParticleBatch.GPU_SIZE_ROTATION_OFFSET] = f7;
        fArray[n2 + BillboardParticleBatch.GPU_SIZE_ROTATION_OFFSET + 1] = f8;
        fArray[n2 + BillboardParticleBatch.GPU_SIZE_ROTATION_OFFSET + 2] = f9;
        fArray[n2 + BillboardParticleBatch.GPU_SIZE_ROTATION_OFFSET + 3] = f10;
        fArray[n2 + BillboardParticleBatch.GPU_COLOR_OFFSET] = f11;
        fArray[n2 + BillboardParticleBatch.GPU_COLOR_OFFSET + 1] = f12;
        fArray[n2 + BillboardParticleBatch.GPU_COLOR_OFFSET + 2] = f13;
        fArray[n2 + BillboardParticleBatch.GPU_COLOR_OFFSET + 3] = f14;
    }

    private static void putVertex(float[] fArray, int n2, Vector3 vector3, float f2, float f3, float f4, float f5, float f6, float f7) {
        fArray[n2 + BillboardParticleBatch.CPU_POSITION_OFFSET] = vector3.x;
        fArray[n2 + BillboardParticleBatch.CPU_POSITION_OFFSET + 1] = vector3.y;
        fArray[n2 + BillboardParticleBatch.CPU_POSITION_OFFSET + 2] = vector3.z;
        fArray[n2 + BillboardParticleBatch.CPU_UV_OFFSET] = f2;
        fArray[n2 + BillboardParticleBatch.CPU_UV_OFFSET + 1] = f3;
        fArray[n2 + BillboardParticleBatch.CPU_COLOR_OFFSET] = f4;
        fArray[n2 + BillboardParticleBatch.CPU_COLOR_OFFSET + 1] = f5;
        fArray[n2 + BillboardParticleBatch.CPU_COLOR_OFFSET + 2] = f6;
        fArray[n2 + BillboardParticleBatch.CPU_COLOR_OFFSET + 3] = f7;
    }

    private void fillVerticesGPU(int[] nArray) {
        int n2 = 0;
        for (BillboardControllerRenderData billboardControllerRenderData : this.renderData) {
            ParallelArray.FloatChannel floatChannel = billboardControllerRenderData.scaleChannel;
            ParallelArray.FloatChannel floatChannel2 = billboardControllerRenderData.regionChannel;
            ParallelArray.FloatChannel floatChannel3 = billboardControllerRenderData.positionChannel;
            ParallelArray.FloatChannel floatChannel4 = billboardControllerRenderData.colorChannel;
            ParallelArray.FloatChannel floatChannel5 = billboardControllerRenderData.rotationChannel;
            int n3 = 0;
            int n4 = billboardControllerRenderData.controller.particles.size;
            while (n3 < n4) {
                int n5 = nArray[n2] * this.currentVertexSize * 4;
                float f2 = floatChannel.data[n3 * floatChannel.strideSize];
                int n6 = n3 * floatChannel2.strideSize;
                int n7 = n3 * floatChannel3.strideSize;
                int n8 = n3 * floatChannel4.strideSize;
                int n9 = n3 * floatChannel5.strideSize;
                float f3 = floatChannel3.data[n7 + 0];
                float f4 = floatChannel3.data[n7 + 1];
                float f5 = floatChannel3.data[n7 + 2];
                float f6 = floatChannel2.data[n6 + 0];
                float f7 = floatChannel2.data[n6 + 1];
                float f8 = floatChannel2.data[n6 + 2];
                float f9 = floatChannel2.data[n6 + 3];
                float f10 = floatChannel2.data[n6 + 4] * f2;
                float f11 = floatChannel2.data[n6 + 5] * f2;
                float f12 = floatChannel4.data[n8 + 0];
                float f13 = floatChannel4.data[n8 + 1];
                float f14 = floatChannel4.data[n8 + 2];
                float f15 = floatChannel4.data[n8 + 3];
                float f16 = floatChannel5.data[n9 + 0];
                float f17 = floatChannel5.data[n9 + 1];
                BillboardParticleBatch.putVertex(this.vertices, n5, f3, f4, f5, f6, f9, -f10, -f11, f16, f17, f12, f13, f14, f15);
                BillboardParticleBatch.putVertex(this.vertices, n5 += this.currentVertexSize, f3, f4, f5, f8, f9, f10, -f11, f16, f17, f12, f13, f14, f15);
                BillboardParticleBatch.putVertex(this.vertices, n5 += this.currentVertexSize, f3, f4, f5, f8, f7, f10, f11, f16, f17, f12, f13, f14, f15);
                BillboardParticleBatch.putVertex(this.vertices, n5 += this.currentVertexSize, f3, f4, f5, f6, f7, -f10, f11, f16, f17, f12, f13, f14, f15);
                n5 += this.currentVertexSize;
                ++n3;
                ++n2;
            }
        }
    }

    private void fillVerticesToViewPointCPU(int[] nArray) {
        int n2 = 0;
        for (BillboardControllerRenderData billboardControllerRenderData : this.renderData) {
            ParallelArray.FloatChannel floatChannel = billboardControllerRenderData.scaleChannel;
            ParallelArray.FloatChannel floatChannel2 = billboardControllerRenderData.regionChannel;
            ParallelArray.FloatChannel floatChannel3 = billboardControllerRenderData.positionChannel;
            ParallelArray.FloatChannel floatChannel4 = billboardControllerRenderData.colorChannel;
            ParallelArray.FloatChannel floatChannel5 = billboardControllerRenderData.rotationChannel;
            int n3 = 0;
            int n4 = billboardControllerRenderData.controller.particles.size;
            while (n3 < n4) {
                int n5 = nArray[n2] * this.currentVertexSize * 4;
                float f2 = floatChannel.data[n3 * floatChannel.strideSize];
                int n6 = n3 * floatChannel2.strideSize;
                int n7 = n3 * floatChannel3.strideSize;
                int n8 = n3 * floatChannel4.strideSize;
                int n9 = n3 * floatChannel5.strideSize;
                float f3 = floatChannel3.data[n7 + 0];
                float f4 = floatChannel3.data[n7 + 1];
                float f5 = floatChannel3.data[n7 + 2];
                float f6 = floatChannel2.data[n6 + 0];
                float f7 = floatChannel2.data[n6 + 1];
                float f8 = floatChannel2.data[n6 + 2];
                float f9 = floatChannel2.data[n6 + 3];
                float f10 = floatChannel2.data[n6 + 4] * f2;
                float f11 = floatChannel2.data[n6 + 5] * f2;
                float f12 = floatChannel4.data[n8 + 0];
                float f13 = floatChannel4.data[n8 + 1];
                float f14 = floatChannel4.data[n8 + 2];
                float f15 = floatChannel4.data[n8 + 3];
                float f16 = floatChannel5.data[n9 + 0];
                float f17 = floatChannel5.data[n9 + 1];
                Vector3 vector3 = TMP_V3.set(this.camera.position).sub(f3, f4, f5).nor();
                Vector3 vector32 = TMP_V1.set(this.camera.up).crs(vector3).nor();
                Vector3 vector33 = TMP_V2.set(vector3).crs(vector32);
                vector32.scl(f10);
                vector33.scl(f11);
                if (f16 != 1.0f) {
                    TMP_M3.setToRotation(vector3, f16, f17);
                    BillboardParticleBatch.putVertex(this.vertices, n5, TMP_V6.set(-BillboardParticleBatch.TMP_V1.x - BillboardParticleBatch.TMP_V2.x, -BillboardParticleBatch.TMP_V1.y - BillboardParticleBatch.TMP_V2.y, -BillboardParticleBatch.TMP_V1.z - BillboardParticleBatch.TMP_V2.z).mul(TMP_M3).add(f3, f4, f5), f6, f9, f12, f13, f14, f15);
                    BillboardParticleBatch.putVertex(this.vertices, n5 += this.currentVertexSize, TMP_V6.set(BillboardParticleBatch.TMP_V1.x - BillboardParticleBatch.TMP_V2.x, BillboardParticleBatch.TMP_V1.y - BillboardParticleBatch.TMP_V2.y, BillboardParticleBatch.TMP_V1.z - BillboardParticleBatch.TMP_V2.z).mul(TMP_M3).add(f3, f4, f5), f8, f9, f12, f13, f14, f15);
                    BillboardParticleBatch.putVertex(this.vertices, n5 += this.currentVertexSize, TMP_V6.set(BillboardParticleBatch.TMP_V1.x + BillboardParticleBatch.TMP_V2.x, BillboardParticleBatch.TMP_V1.y + BillboardParticleBatch.TMP_V2.y, BillboardParticleBatch.TMP_V1.z + BillboardParticleBatch.TMP_V2.z).mul(TMP_M3).add(f3, f4, f5), f8, f7, f12, f13, f14, f15);
                    BillboardParticleBatch.putVertex(this.vertices, n5 += this.currentVertexSize, TMP_V6.set(-BillboardParticleBatch.TMP_V1.x + BillboardParticleBatch.TMP_V2.x, -BillboardParticleBatch.TMP_V1.y + BillboardParticleBatch.TMP_V2.y, -BillboardParticleBatch.TMP_V1.z + BillboardParticleBatch.TMP_V2.z).mul(TMP_M3).add(f3, f4, f5), f6, f7, f12, f13, f14, f15);
                } else {
                    BillboardParticleBatch.putVertex(this.vertices, n5, TMP_V6.set(-BillboardParticleBatch.TMP_V1.x - BillboardParticleBatch.TMP_V2.x + f3, -BillboardParticleBatch.TMP_V1.y - BillboardParticleBatch.TMP_V2.y + f4, -BillboardParticleBatch.TMP_V1.z - BillboardParticleBatch.TMP_V2.z + f5), f6, f9, f12, f13, f14, f15);
                    BillboardParticleBatch.putVertex(this.vertices, n5 += this.currentVertexSize, TMP_V6.set(BillboardParticleBatch.TMP_V1.x - BillboardParticleBatch.TMP_V2.x + f3, BillboardParticleBatch.TMP_V1.y - BillboardParticleBatch.TMP_V2.y + f4, BillboardParticleBatch.TMP_V1.z - BillboardParticleBatch.TMP_V2.z + f5), f8, f9, f12, f13, f14, f15);
                    BillboardParticleBatch.putVertex(this.vertices, n5 += this.currentVertexSize, TMP_V6.set(BillboardParticleBatch.TMP_V1.x + BillboardParticleBatch.TMP_V2.x + f3, BillboardParticleBatch.TMP_V1.y + BillboardParticleBatch.TMP_V2.y + f4, BillboardParticleBatch.TMP_V1.z + BillboardParticleBatch.TMP_V2.z + f5), f8, f7, f12, f13, f14, f15);
                    BillboardParticleBatch.putVertex(this.vertices, n5 += this.currentVertexSize, TMP_V6.set(-BillboardParticleBatch.TMP_V1.x + BillboardParticleBatch.TMP_V2.x + f3, -BillboardParticleBatch.TMP_V1.y + BillboardParticleBatch.TMP_V2.y + f4, -BillboardParticleBatch.TMP_V1.z + BillboardParticleBatch.TMP_V2.z + f5), f6, f7, f12, f13, f14, f15);
                }
                ++n3;
                ++n2;
            }
        }
    }

    private void fillVerticesToScreenCPU(int[] nArray) {
        Vector3 vector3 = TMP_V3.set(this.camera.direction).scl(-1.0f);
        Vector3 vector32 = TMP_V4.set(this.camera.up).crs(vector3).nor();
        Vector3 vector33 = this.camera.up;
        int n2 = 0;
        for (BillboardControllerRenderData billboardControllerRenderData : this.renderData) {
            ParallelArray.FloatChannel floatChannel = billboardControllerRenderData.scaleChannel;
            ParallelArray.FloatChannel floatChannel2 = billboardControllerRenderData.regionChannel;
            ParallelArray.FloatChannel floatChannel3 = billboardControllerRenderData.positionChannel;
            ParallelArray.FloatChannel floatChannel4 = billboardControllerRenderData.colorChannel;
            ParallelArray.FloatChannel floatChannel5 = billboardControllerRenderData.rotationChannel;
            int n3 = 0;
            int n4 = billboardControllerRenderData.controller.particles.size;
            while (n3 < n4) {
                int n5 = nArray[n2] * this.currentVertexSize * 4;
                float f2 = floatChannel.data[n3 * floatChannel.strideSize];
                int n6 = n3 * floatChannel2.strideSize;
                int n7 = n3 * floatChannel3.strideSize;
                int n8 = n3 * floatChannel4.strideSize;
                int n9 = n3 * floatChannel5.strideSize;
                float f3 = floatChannel3.data[n7 + 0];
                float f4 = floatChannel3.data[n7 + 1];
                float f5 = floatChannel3.data[n7 + 2];
                float f6 = floatChannel2.data[n6 + 0];
                float f7 = floatChannel2.data[n6 + 1];
                float f8 = floatChannel2.data[n6 + 2];
                float f9 = floatChannel2.data[n6 + 3];
                float f10 = floatChannel2.data[n6 + 4] * f2;
                float f11 = floatChannel2.data[n6 + 5] * f2;
                float f12 = floatChannel4.data[n8 + 0];
                float f13 = floatChannel4.data[n8 + 1];
                float f14 = floatChannel4.data[n8 + 2];
                float f15 = floatChannel4.data[n8 + 3];
                float f16 = floatChannel5.data[n9 + 0];
                float f17 = floatChannel5.data[n9 + 1];
                TMP_V1.set(vector32).scl(f10);
                TMP_V2.set(vector33).scl(f11);
                if (f16 != 1.0f) {
                    TMP_M3.setToRotation(vector3, f16, f17);
                    BillboardParticleBatch.putVertex(this.vertices, n5, TMP_V6.set(-BillboardParticleBatch.TMP_V1.x - BillboardParticleBatch.TMP_V2.x, -BillboardParticleBatch.TMP_V1.y - BillboardParticleBatch.TMP_V2.y, -BillboardParticleBatch.TMP_V1.z - BillboardParticleBatch.TMP_V2.z).mul(TMP_M3).add(f3, f4, f5), f6, f9, f12, f13, f14, f15);
                    BillboardParticleBatch.putVertex(this.vertices, n5 += this.currentVertexSize, TMP_V6.set(BillboardParticleBatch.TMP_V1.x - BillboardParticleBatch.TMP_V2.x, BillboardParticleBatch.TMP_V1.y - BillboardParticleBatch.TMP_V2.y, BillboardParticleBatch.TMP_V1.z - BillboardParticleBatch.TMP_V2.z).mul(TMP_M3).add(f3, f4, f5), f8, f9, f12, f13, f14, f15);
                    BillboardParticleBatch.putVertex(this.vertices, n5 += this.currentVertexSize, TMP_V6.set(BillboardParticleBatch.TMP_V1.x + BillboardParticleBatch.TMP_V2.x, BillboardParticleBatch.TMP_V1.y + BillboardParticleBatch.TMP_V2.y, BillboardParticleBatch.TMP_V1.z + BillboardParticleBatch.TMP_V2.z).mul(TMP_M3).add(f3, f4, f5), f8, f7, f12, f13, f14, f15);
                    BillboardParticleBatch.putVertex(this.vertices, n5 += this.currentVertexSize, TMP_V6.set(-BillboardParticleBatch.TMP_V1.x + BillboardParticleBatch.TMP_V2.x, -BillboardParticleBatch.TMP_V1.y + BillboardParticleBatch.TMP_V2.y, -BillboardParticleBatch.TMP_V1.z + BillboardParticleBatch.TMP_V2.z).mul(TMP_M3).add(f3, f4, f5), f6, f7, f12, f13, f14, f15);
                } else {
                    BillboardParticleBatch.putVertex(this.vertices, n5, TMP_V6.set(-BillboardParticleBatch.TMP_V1.x - BillboardParticleBatch.TMP_V2.x + f3, -BillboardParticleBatch.TMP_V1.y - BillboardParticleBatch.TMP_V2.y + f4, -BillboardParticleBatch.TMP_V1.z - BillboardParticleBatch.TMP_V2.z + f5), f6, f9, f12, f13, f14, f15);
                    BillboardParticleBatch.putVertex(this.vertices, n5 += this.currentVertexSize, TMP_V6.set(BillboardParticleBatch.TMP_V1.x - BillboardParticleBatch.TMP_V2.x + f3, BillboardParticleBatch.TMP_V1.y - BillboardParticleBatch.TMP_V2.y + f4, BillboardParticleBatch.TMP_V1.z - BillboardParticleBatch.TMP_V2.z + f5), f8, f9, f12, f13, f14, f15);
                    BillboardParticleBatch.putVertex(this.vertices, n5 += this.currentVertexSize, TMP_V6.set(BillboardParticleBatch.TMP_V1.x + BillboardParticleBatch.TMP_V2.x + f3, BillboardParticleBatch.TMP_V1.y + BillboardParticleBatch.TMP_V2.y + f4, BillboardParticleBatch.TMP_V1.z + BillboardParticleBatch.TMP_V2.z + f5), f8, f7, f12, f13, f14, f15);
                    BillboardParticleBatch.putVertex(this.vertices, n5 += this.currentVertexSize, TMP_V6.set(-BillboardParticleBatch.TMP_V1.x + BillboardParticleBatch.TMP_V2.x + f3, -BillboardParticleBatch.TMP_V1.y + BillboardParticleBatch.TMP_V2.y + f4, -BillboardParticleBatch.TMP_V1.z + BillboardParticleBatch.TMP_V2.z + f5), f6, f7, f12, f13, f14, f15);
                }
                ++n3;
                ++n2;
            }
        }
    }

    @Override
    protected void flush(int[] nArray) {
        if (this.useGPU) {
            this.fillVerticesGPU(nArray);
        } else if (this.mode == ParticleShader.AlignMode.Screen) {
            this.fillVerticesToScreenCPU(nArray);
        } else if (this.mode == ParticleShader.AlignMode.ViewPoint) {
            this.fillVerticesToViewPointCPU(nArray);
        }
        int n2 = 0;
        int n3 = this.bufferedParticlesCount * 4;
        for (int i2 = 0; i2 < n3; i2 += n2) {
            n2 = Math.min(n3 - i2, 32764);
            Renderable renderable = (Renderable)this.renderablePool.obtain();
            renderable.meshPart.size = n2 / 4 * 6;
            renderable.meshPart.mesh.setVertices(this.vertices, this.currentVertexSize * i2, this.currentVertexSize * n2);
            renderable.meshPart.update();
            this.renderables.add(renderable);
        }
    }

    @Override
    public void getRenderables(Array<Renderable> array, Pool<Renderable> pool) {
        for (Renderable renderable : this.renderables) {
            array.add(pool.obtain().set(renderable));
        }
    }

    @Override
    public void save(AssetManager assetManager, ResourceData resourceData) {
        ResourceData.SaveData saveData = resourceData.createSaveData("billboardBatch");
        saveData.save("cfg", new Config(this.useGPU, this.mode));
        saveData.saveAsset(assetManager.getAssetFileName(this.texture), Texture.class);
    }

    @Override
    public void load(AssetManager assetManager, ResourceData resourceData) {
        ResourceData.SaveData saveData = resourceData.getSaveData("billboardBatch");
        if (saveData != null) {
            this.setTexture((Texture)assetManager.get(saveData.loadAsset()));
            Config config = (Config)saveData.load("cfg");
            this.setUseGpu(config.useGPU);
            this.setAlignMode(config.mode);
        }
    }

    public static class Config {
        boolean useGPU;
        ParticleShader.AlignMode mode;

        public Config() {
        }

        public Config(boolean bl2, ParticleShader.AlignMode alignMode) {
            this.useGPU = bl2;
            this.mode = alignMode;
        }
    }

    class RenderablePool
    extends Pool<Renderable> {
        @Override
        public Renderable newObject() {
            return BillboardParticleBatch.this.allocRenderable();
        }
    }
}

