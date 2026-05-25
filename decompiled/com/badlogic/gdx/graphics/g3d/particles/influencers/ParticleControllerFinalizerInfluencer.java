/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.particles.influencers;

import com.badlogic.gdx.graphics.g3d.particles.ParallelArray;
import com.badlogic.gdx.graphics.g3d.particles.ParticleChannels;
import com.badlogic.gdx.graphics.g3d.particles.ParticleController;
import com.badlogic.gdx.graphics.g3d.particles.influencers.Influencer;
import com.badlogic.gdx.utils.GdxRuntimeException;

public class ParticleControllerFinalizerInfluencer
extends Influencer {
    ParallelArray.FloatChannel positionChannel;
    ParallelArray.FloatChannel scaleChannel;
    ParallelArray.FloatChannel rotationChannel;
    ParallelArray.ObjectChannel<ParticleController> controllerChannel;
    boolean hasScale;
    boolean hasRotation;

    @Override
    public void init() {
        this.controllerChannel = (ParallelArray.ObjectChannel)this.controller.particles.getChannel(ParticleChannels.ParticleController);
        if (this.controllerChannel == null) {
            throw new GdxRuntimeException("ParticleController channel not found, specify an influencer which will allocate it please.");
        }
        this.scaleChannel = (ParallelArray.FloatChannel)this.controller.particles.getChannel(ParticleChannels.Scale);
        this.rotationChannel = (ParallelArray.FloatChannel)this.controller.particles.getChannel(ParticleChannels.Rotation3D);
        this.hasScale = this.scaleChannel != null;
        this.hasRotation = this.rotationChannel != null;
    }

    @Override
    public void allocateChannels() {
        this.positionChannel = (ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.Position);
    }

    @Override
    public void update() {
        int n2 = 0;
        int n3 = 0;
        int n4 = this.controller.particles.size;
        while (n2 < n4) {
            ParticleController particleController = ((ParticleController[])this.controllerChannel.data)[n2];
            float f2 = this.hasScale ? this.scaleChannel.data[n2] : 1.0f;
            float f3 = 0.0f;
            float f4 = 0.0f;
            float f5 = 0.0f;
            float f6 = 1.0f;
            if (this.hasRotation) {
                int n5 = n2 * this.rotationChannel.strideSize;
                f3 = this.rotationChannel.data[n5 + 0];
                f4 = this.rotationChannel.data[n5 + 1];
                f5 = this.rotationChannel.data[n5 + 2];
                f6 = this.rotationChannel.data[n5 + 3];
            }
            particleController.setTransform(this.positionChannel.data[n3 + 0], this.positionChannel.data[n3 + 1], this.positionChannel.data[n3 + 2], f3, f4, f5, f6, f2);
            particleController.update();
            ++n2;
            n3 += this.positionChannel.strideSize;
        }
    }

    @Override
    public ParticleControllerFinalizerInfluencer copy() {
        return new ParticleControllerFinalizerInfluencer();
    }
}

