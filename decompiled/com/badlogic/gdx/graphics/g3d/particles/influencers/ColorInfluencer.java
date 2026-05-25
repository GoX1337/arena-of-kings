/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.particles.influencers;

import com.badlogic.gdx.graphics.g3d.particles.ParallelArray;
import com.badlogic.gdx.graphics.g3d.particles.ParticleChannels;
import com.badlogic.gdx.graphics.g3d.particles.influencers.Influencer;
import com.badlogic.gdx.graphics.g3d.particles.values.GradientColorValue;
import com.badlogic.gdx.graphics.g3d.particles.values.ScaledNumericValue;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;

public abstract class ColorInfluencer
extends Influencer {
    ParallelArray.FloatChannel colorChannel;

    @Override
    public void allocateChannels() {
        this.colorChannel = (ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.Color);
    }

    public static class Single
    extends ColorInfluencer {
        ParallelArray.FloatChannel alphaInterpolationChannel;
        ParallelArray.FloatChannel lifeChannel;
        public ScaledNumericValue alphaValue;
        public GradientColorValue colorValue = new GradientColorValue();

        public Single() {
            this.alphaValue = new ScaledNumericValue();
            this.alphaValue.setHigh(1.0f);
        }

        public Single(Single single) {
            this();
            this.set(single);
        }

        public void set(Single single) {
            this.colorValue.load(single.colorValue);
            this.alphaValue.load(single.alphaValue);
        }

        @Override
        public void allocateChannels() {
            super.allocateChannels();
            ParticleChannels.Interpolation.id = this.controller.particleChannels.newId();
            this.alphaInterpolationChannel = (ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.Interpolation);
            this.lifeChannel = (ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.Life);
        }

        @Override
        public void activateParticles(int n2, int n3) {
            int n4 = n2 * this.colorChannel.strideSize;
            int n5 = n2 * this.alphaInterpolationChannel.strideSize;
            int n6 = n2 * this.lifeChannel.strideSize + 2;
            int n7 = n4 + n3 * this.colorChannel.strideSize;
            while (n4 < n7) {
                float f2 = this.alphaValue.newLowValue();
                float f3 = this.alphaValue.newHighValue() - f2;
                this.colorValue.getColor(0.0f, this.colorChannel.data, n4);
                this.colorChannel.data[n4 + 3] = f2 + f3 * this.alphaValue.getScale(this.lifeChannel.data[n6]);
                this.alphaInterpolationChannel.data[n5 + 0] = f2;
                this.alphaInterpolationChannel.data[n5 + 1] = f3;
                n4 += this.colorChannel.strideSize;
                n5 += this.alphaInterpolationChannel.strideSize;
                n6 += this.lifeChannel.strideSize;
            }
        }

        @Override
        public void update() {
            int n2 = 0;
            int n3 = 0;
            int n4 = 2;
            int n5 = n2 + this.controller.particles.size * this.colorChannel.strideSize;
            while (n2 < n5) {
                float f2 = this.lifeChannel.data[n4];
                this.colorValue.getColor(f2, this.colorChannel.data, n2);
                this.colorChannel.data[n2 + 3] = this.alphaInterpolationChannel.data[n3 + 0] + this.alphaInterpolationChannel.data[n3 + 1] * this.alphaValue.getScale(f2);
                n2 += this.colorChannel.strideSize;
                n3 += this.alphaInterpolationChannel.strideSize;
                n4 += this.lifeChannel.strideSize;
            }
        }

        @Override
        public Single copy() {
            return new Single(this);
        }

        @Override
        public void write(Json json) {
            json.writeValue("alpha", this.alphaValue);
            json.writeValue("color", this.colorValue);
        }

        @Override
        public void read(Json json, JsonValue jsonValue) {
            this.alphaValue = json.readValue("alpha", ScaledNumericValue.class, jsonValue);
            this.colorValue = json.readValue("color", GradientColorValue.class, jsonValue);
        }
    }

    public static class Random
    extends ColorInfluencer {
        ParallelArray.FloatChannel colorChannel;

        @Override
        public void allocateChannels() {
            this.colorChannel = (ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.Color);
        }

        @Override
        public void activateParticles(int n2, int n3) {
            int n4;
            int n5 = n4 + n3 * this.colorChannel.strideSize;
            for (n4 = n2 * this.colorChannel.strideSize; n4 < n5; n4 += this.colorChannel.strideSize) {
                this.colorChannel.data[n4 + 0] = MathUtils.random();
                this.colorChannel.data[n4 + 1] = MathUtils.random();
                this.colorChannel.data[n4 + 2] = MathUtils.random();
                this.colorChannel.data[n4 + 3] = MathUtils.random();
            }
        }

        @Override
        public Random copy() {
            return new Random();
        }
    }
}

