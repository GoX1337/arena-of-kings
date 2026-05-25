/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.particles.renderers;

import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.BlendingAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.particles.ParallelArray;
import com.badlogic.gdx.graphics.g3d.particles.ParticleChannels;
import com.badlogic.gdx.graphics.g3d.particles.ParticleControllerComponent;
import com.badlogic.gdx.graphics.g3d.particles.batches.ModelInstanceParticleBatch;
import com.badlogic.gdx.graphics.g3d.particles.batches.ParticleBatch;
import com.badlogic.gdx.graphics.g3d.particles.renderers.ModelInstanceControllerRenderData;
import com.badlogic.gdx.graphics.g3d.particles.renderers.ParticleControllerRenderer;

public class ModelInstanceRenderer
extends ParticleControllerRenderer<ModelInstanceControllerRenderData, ModelInstanceParticleBatch> {
    private boolean hasColor;
    private boolean hasScale;
    private boolean hasRotation;

    public ModelInstanceRenderer() {
        super(new ModelInstanceControllerRenderData());
    }

    public ModelInstanceRenderer(ModelInstanceParticleBatch modelInstanceParticleBatch) {
        this();
        this.setBatch(modelInstanceParticleBatch);
    }

    @Override
    public void allocateChannels() {
        ((ModelInstanceControllerRenderData)this.renderData).positionChannel = (ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.Position);
    }

    @Override
    public void init() {
        ((ModelInstanceControllerRenderData)this.renderData).modelInstanceChannel = (ParallelArray.ObjectChannel)this.controller.particles.getChannel(ParticleChannels.ModelInstance);
        ((ModelInstanceControllerRenderData)this.renderData).colorChannel = (ParallelArray.FloatChannel)this.controller.particles.getChannel(ParticleChannels.Color);
        ((ModelInstanceControllerRenderData)this.renderData).scaleChannel = (ParallelArray.FloatChannel)this.controller.particles.getChannel(ParticleChannels.Scale);
        ((ModelInstanceControllerRenderData)this.renderData).rotationChannel = (ParallelArray.FloatChannel)this.controller.particles.getChannel(ParticleChannels.Rotation3D);
        this.hasColor = ((ModelInstanceControllerRenderData)this.renderData).colorChannel != null;
        this.hasScale = ((ModelInstanceControllerRenderData)this.renderData).scaleChannel != null;
        this.hasRotation = ((ModelInstanceControllerRenderData)this.renderData).rotationChannel != null;
    }

    @Override
    public void update() {
        int n2 = 0;
        int n3 = 0;
        int n4 = this.controller.particles.size;
        while (n2 < n4) {
            int n5;
            ModelInstance modelInstance = ((ModelInstance[])((ModelInstanceControllerRenderData)this.renderData).modelInstanceChannel.data)[n2];
            float f2 = this.hasScale ? ((ModelInstanceControllerRenderData)this.renderData).scaleChannel.data[n2] : 1.0f;
            float f3 = 0.0f;
            float f4 = 0.0f;
            float f5 = 0.0f;
            float f6 = 1.0f;
            if (this.hasRotation) {
                n5 = n2 * ((ModelInstanceControllerRenderData)this.renderData).rotationChannel.strideSize;
                f3 = ((ModelInstanceControllerRenderData)this.renderData).rotationChannel.data[n5 + 0];
                f4 = ((ModelInstanceControllerRenderData)this.renderData).rotationChannel.data[n5 + 1];
                f5 = ((ModelInstanceControllerRenderData)this.renderData).rotationChannel.data[n5 + 2];
                f6 = ((ModelInstanceControllerRenderData)this.renderData).rotationChannel.data[n5 + 3];
            }
            modelInstance.transform.set(((ModelInstanceControllerRenderData)this.renderData).positionChannel.data[n3 + 0], ((ModelInstanceControllerRenderData)this.renderData).positionChannel.data[n3 + 1], ((ModelInstanceControllerRenderData)this.renderData).positionChannel.data[n3 + 2], f3, f4, f5, f6, f2, f2, f2);
            if (this.hasColor) {
                n5 = n2 * ((ModelInstanceControllerRenderData)this.renderData).colorChannel.strideSize;
                ColorAttribute colorAttribute = (ColorAttribute)modelInstance.materials.get(0).get(ColorAttribute.Diffuse);
                BlendingAttribute blendingAttribute = (BlendingAttribute)modelInstance.materials.get(0).get(BlendingAttribute.Type);
                colorAttribute.color.r = ((ModelInstanceControllerRenderData)this.renderData).colorChannel.data[n5 + 0];
                colorAttribute.color.g = ((ModelInstanceControllerRenderData)this.renderData).colorChannel.data[n5 + 1];
                colorAttribute.color.b = ((ModelInstanceControllerRenderData)this.renderData).colorChannel.data[n5 + 2];
                if (blendingAttribute != null) {
                    blendingAttribute.opacity = ((ModelInstanceControllerRenderData)this.renderData).colorChannel.data[n5 + 3];
                }
            }
            ++n2;
            n3 += ((ModelInstanceControllerRenderData)this.renderData).positionChannel.strideSize;
        }
        super.update();
    }

    @Override
    public ParticleControllerComponent copy() {
        return new ModelInstanceRenderer((ModelInstanceParticleBatch)this.batch);
    }

    @Override
    public boolean isCompatible(ParticleBatch<?> particleBatch) {
        return particleBatch instanceof ModelInstanceParticleBatch;
    }
}

