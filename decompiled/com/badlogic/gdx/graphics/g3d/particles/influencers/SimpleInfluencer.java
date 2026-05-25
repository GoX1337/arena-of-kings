/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.particles.influencers;

import com.badlogic.gdx.graphics.g3d.particles.ParallelArray;
import com.badlogic.gdx.graphics.g3d.particles.ParticleChannels;
import com.badlogic.gdx.graphics.g3d.particles.influencers.Influencer;
import com.badlogic.gdx.graphics.g3d.particles.values.ScaledNumericValue;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;

public abstract class SimpleInfluencer
extends Influencer {
    public ScaledNumericValue value = new ScaledNumericValue();
    ParallelArray.FloatChannel valueChannel;
    ParallelArray.FloatChannel interpolationChannel;
    ParallelArray.FloatChannel lifeChannel;
    ParallelArray.ChannelDescriptor valueChannelDescriptor;

    public SimpleInfluencer() {
        this.value.setHigh(1.0f);
    }

    public SimpleInfluencer(SimpleInfluencer simpleInfluencer) {
        this();
        this.set(simpleInfluencer);
    }

    private void set(SimpleInfluencer simpleInfluencer) {
        this.value.load(simpleInfluencer.value);
        this.valueChannelDescriptor = simpleInfluencer.valueChannelDescriptor;
    }

    @Override
    public void allocateChannels() {
        this.valueChannel = (ParallelArray.FloatChannel)this.controller.particles.addChannel(this.valueChannelDescriptor);
        ParticleChannels.Interpolation.id = this.controller.particleChannels.newId();
        this.interpolationChannel = (ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.Interpolation);
        this.lifeChannel = (ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.Life);
    }

    @Override
    public void activateParticles(int n2, int n3) {
        if (!this.value.isRelative()) {
            int n4 = n2 * this.valueChannel.strideSize;
            int n5 = n2 * this.interpolationChannel.strideSize;
            int n6 = n4 + n3 * this.valueChannel.strideSize;
            while (n4 < n6) {
                float f2 = this.value.newLowValue();
                float f3 = this.value.newHighValue() - f2;
                this.interpolationChannel.data[n5 + 0] = f2;
                this.interpolationChannel.data[n5 + 1] = f3;
                this.valueChannel.data[n4] = f2 + f3 * this.value.getScale(0.0f);
                n4 += this.valueChannel.strideSize;
                n5 += this.interpolationChannel.strideSize;
            }
        } else {
            int n7 = n2 * this.valueChannel.strideSize;
            int n8 = n2 * this.interpolationChannel.strideSize;
            int n9 = n7 + n3 * this.valueChannel.strideSize;
            while (n7 < n9) {
                float f4 = this.value.newLowValue();
                float f5 = this.value.newHighValue();
                this.interpolationChannel.data[n8 + 0] = f4;
                this.interpolationChannel.data[n8 + 1] = f5;
                this.valueChannel.data[n7] = f4 + f5 * this.value.getScale(0.0f);
                n7 += this.valueChannel.strideSize;
                n8 += this.interpolationChannel.strideSize;
            }
        }
    }

    @Override
    public void update() {
        int n2 = 0;
        int n3 = 0;
        int n4 = 2;
        int n5 = n2 + this.controller.particles.size * this.valueChannel.strideSize;
        while (n2 < n5) {
            this.valueChannel.data[n2] = this.interpolationChannel.data[n3 + 0] + this.interpolationChannel.data[n3 + 1] * this.value.getScale(this.lifeChannel.data[n4]);
            n2 += this.valueChannel.strideSize;
            n3 += this.interpolationChannel.strideSize;
            n4 += this.lifeChannel.strideSize;
        }
    }

    @Override
    public void write(Json json) {
        json.writeValue("value", this.value);
    }

    @Override
    public void read(Json json, JsonValue jsonValue) {
        this.value = json.readValue("value", ScaledNumericValue.class, jsonValue);
    }
}

