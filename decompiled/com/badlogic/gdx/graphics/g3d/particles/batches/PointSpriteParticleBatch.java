/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.particles.batches;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Renderable;
import com.badlogic.gdx.graphics.g3d.attributes.BlendingAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.DepthTestAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.TextureAttribute;
import com.badlogic.gdx.graphics.g3d.particles.ParallelArray;
import com.badlogic.gdx.graphics.g3d.particles.ParticleShader;
import com.badlogic.gdx.graphics.g3d.particles.ResourceData;
import com.badlogic.gdx.graphics.g3d.particles.batches.BufferedParticleBatch;
import com.badlogic.gdx.graphics.g3d.particles.renderers.PointSpriteControllerRenderData;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pool;

public class PointSpriteParticleBatch
extends BufferedParticleBatch<PointSpriteControllerRenderData> {
    private static boolean pointSpritesEnabled = false;
    protected static final Vector3 TMP_V1 = new Vector3();
    protected static final int sizeAndRotationUsage = 512;
    protected static final VertexAttributes CPU_ATTRIBUTES = new VertexAttributes(new VertexAttribute(1, 3, "a_position"), new VertexAttribute(2, 4, "a_color"), new VertexAttribute(16, 4, "a_region"), new VertexAttribute(512, 3, "a_sizeAndRotation"));
    protected static final int CPU_VERTEX_SIZE = (short)(PointSpriteParticleBatch.CPU_ATTRIBUTES.vertexSize / 4);
    protected static final int CPU_POSITION_OFFSET = (short)(PointSpriteParticleBatch.CPU_ATTRIBUTES.findByUsage((int)1).offset / 4);
    protected static final int CPU_COLOR_OFFSET = (short)(PointSpriteParticleBatch.CPU_ATTRIBUTES.findByUsage((int)2).offset / 4);
    protected static final int CPU_REGION_OFFSET = (short)(PointSpriteParticleBatch.CPU_ATTRIBUTES.findByUsage((int)16).offset / 4);
    protected static final int CPU_SIZE_AND_ROTATION_OFFSET = (short)(PointSpriteParticleBatch.CPU_ATTRIBUTES.findByUsage((int)512).offset / 4);
    private float[] vertices;
    Renderable renderable;
    protected BlendingAttribute blendingAttribute;
    protected DepthTestAttribute depthTestAttribute;

    private static void enablePointSprites() {
        Gdx.gl.glEnable(34370);
        if (Gdx.app.getType() == Application.ApplicationType.Desktop) {
            Gdx.gl.glEnable(34913);
        }
        pointSpritesEnabled = true;
    }

    public PointSpriteParticleBatch() {
        this(1000);
    }

    public PointSpriteParticleBatch(int n2) {
        this(n2, new ParticleShader.Config(ParticleShader.ParticleType.Point));
    }

    public PointSpriteParticleBatch(int n2, ParticleShader.Config config) {
        this(n2, config, null, null);
    }

    public PointSpriteParticleBatch(int n2, ParticleShader.Config config, BlendingAttribute blendingAttribute, DepthTestAttribute depthTestAttribute) {
        super(PointSpriteControllerRenderData.class);
        if (!pointSpritesEnabled) {
            PointSpriteParticleBatch.enablePointSprites();
        }
        this.blendingAttribute = blendingAttribute;
        this.depthTestAttribute = depthTestAttribute;
        if (this.blendingAttribute == null) {
            this.blendingAttribute = new BlendingAttribute(1, 771, 1.0f);
        }
        if (this.depthTestAttribute == null) {
            this.depthTestAttribute = new DepthTestAttribute(515, false);
        }
        this.allocRenderable();
        this.ensureCapacity(n2);
        this.renderable.shader = new ParticleShader(this.renderable, config);
        this.renderable.shader.init();
    }

    @Override
    protected void allocParticlesData(int n2) {
        this.vertices = new float[n2 * CPU_VERTEX_SIZE];
        if (this.renderable.meshPart.mesh != null) {
            this.renderable.meshPart.mesh.dispose();
        }
        this.renderable.meshPart.mesh = new Mesh(false, n2, 0, CPU_ATTRIBUTES);
    }

    protected void allocRenderable() {
        this.renderable = new Renderable();
        this.renderable.meshPart.primitiveType = 0;
        this.renderable.meshPart.offset = 0;
        this.renderable.material = new Material(this.blendingAttribute, this.depthTestAttribute, TextureAttribute.createDiffuse((Texture)null));
    }

    public void setTexture(Texture texture) {
        TextureAttribute textureAttribute = (TextureAttribute)this.renderable.material.get(TextureAttribute.Diffuse);
        textureAttribute.textureDescription.texture = texture;
    }

    public Texture getTexture() {
        TextureAttribute textureAttribute = (TextureAttribute)this.renderable.material.get(TextureAttribute.Diffuse);
        return (Texture)textureAttribute.textureDescription.texture;
    }

    public BlendingAttribute getBlendingAttribute() {
        return this.blendingAttribute;
    }

    @Override
    protected void flush(int[] nArray) {
        int n2 = 0;
        for (PointSpriteControllerRenderData pointSpriteControllerRenderData : this.renderData) {
            ParallelArray.FloatChannel floatChannel = pointSpriteControllerRenderData.scaleChannel;
            ParallelArray.FloatChannel floatChannel2 = pointSpriteControllerRenderData.regionChannel;
            ParallelArray.FloatChannel floatChannel3 = pointSpriteControllerRenderData.positionChannel;
            ParallelArray.FloatChannel floatChannel4 = pointSpriteControllerRenderData.colorChannel;
            ParallelArray.FloatChannel floatChannel5 = pointSpriteControllerRenderData.rotationChannel;
            int n3 = 0;
            while (n3 < pointSpriteControllerRenderData.controller.particles.size) {
                int n4 = nArray[n2] * CPU_VERTEX_SIZE;
                int n5 = n3 * floatChannel2.strideSize;
                int n6 = n3 * floatChannel3.strideSize;
                int n7 = n3 * floatChannel4.strideSize;
                int n8 = n3 * floatChannel5.strideSize;
                this.vertices[n4 + PointSpriteParticleBatch.CPU_POSITION_OFFSET] = floatChannel3.data[n6 + 0];
                this.vertices[n4 + PointSpriteParticleBatch.CPU_POSITION_OFFSET + 1] = floatChannel3.data[n6 + 1];
                this.vertices[n4 + PointSpriteParticleBatch.CPU_POSITION_OFFSET + 2] = floatChannel3.data[n6 + 2];
                this.vertices[n4 + PointSpriteParticleBatch.CPU_COLOR_OFFSET] = floatChannel4.data[n7 + 0];
                this.vertices[n4 + PointSpriteParticleBatch.CPU_COLOR_OFFSET + 1] = floatChannel4.data[n7 + 1];
                this.vertices[n4 + PointSpriteParticleBatch.CPU_COLOR_OFFSET + 2] = floatChannel4.data[n7 + 2];
                this.vertices[n4 + PointSpriteParticleBatch.CPU_COLOR_OFFSET + 3] = floatChannel4.data[n7 + 3];
                this.vertices[n4 + PointSpriteParticleBatch.CPU_SIZE_AND_ROTATION_OFFSET] = floatChannel.data[n3 * floatChannel.strideSize];
                this.vertices[n4 + PointSpriteParticleBatch.CPU_SIZE_AND_ROTATION_OFFSET + 1] = floatChannel5.data[n8 + 0];
                this.vertices[n4 + PointSpriteParticleBatch.CPU_SIZE_AND_ROTATION_OFFSET + 2] = floatChannel5.data[n8 + 1];
                this.vertices[n4 + PointSpriteParticleBatch.CPU_REGION_OFFSET] = floatChannel2.data[n5 + 0];
                this.vertices[n4 + PointSpriteParticleBatch.CPU_REGION_OFFSET + 1] = floatChannel2.data[n5 + 1];
                this.vertices[n4 + PointSpriteParticleBatch.CPU_REGION_OFFSET + 2] = floatChannel2.data[n5 + 2];
                this.vertices[n4 + PointSpriteParticleBatch.CPU_REGION_OFFSET + 3] = floatChannel2.data[n5 + 3];
                ++n3;
                ++n2;
            }
        }
        this.renderable.meshPart.size = this.bufferedParticlesCount;
        this.renderable.meshPart.mesh.setVertices(this.vertices, 0, this.bufferedParticlesCount * CPU_VERTEX_SIZE);
        this.renderable.meshPart.update();
    }

    @Override
    public void getRenderables(Array<Renderable> array, Pool<Renderable> pool) {
        if (this.bufferedParticlesCount > 0) {
            array.add(pool.obtain().set(this.renderable));
        }
    }

    @Override
    public void save(AssetManager assetManager, ResourceData resourceData) {
        ResourceData.SaveData saveData = resourceData.createSaveData("pointSpriteBatch");
        saveData.saveAsset(assetManager.getAssetFileName(this.getTexture()), Texture.class);
    }

    @Override
    public void load(AssetManager assetManager, ResourceData resourceData) {
        ResourceData.SaveData saveData = resourceData.getSaveData("pointSpriteBatch");
        if (saveData != null) {
            this.setTexture((Texture)assetManager.get(saveData.loadAsset()));
        }
    }
}

