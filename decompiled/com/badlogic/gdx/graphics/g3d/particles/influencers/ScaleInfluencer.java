/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.particles.influencers;

import com.badlogic.gdx.graphics.g3d.particles.ParticleChannels;
import com.badlogic.gdx.graphics.g3d.particles.ParticleControllerComponent;
import com.badlogic.gdx.graphics.g3d.particles.influencers.SimpleInfluencer;

public class ScaleInfluencer
extends SimpleInfluencer {
    public ScaleInfluencer() {
        this.valueChannelDescriptor = ParticleChannels.Scale;
    }

    @Override
    public void activateParticles(int n2, int n3) {
        if (this.value.isRelative()) {
            int n4 = n2 * this.valueChannel.strideSize;
            int n5 = n2 * this.interpolationChannel.strideSize;
            int n6 = n4 + n3 * this.valueChannel.strideSize;
            while (n4 < n6) {
                float f2 = this.value.newLowValue() * this.controller.scale.x;
                float f3 = this.value.newHighValue() * this.controller.scale.x;
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
                float f4 = this.value.newLowValue() * this.controller.scale.x;
                float f5 = this.value.newHighValue() * this.controller.scale.x - f4;
                this.interpolationChannel.data[n8 + 0] = f4;
                this.interpolationChannel.data[n8 + 1] = f5;
                this.valueChannel.data[n7] = f4 + f5 * this.value.getScale(0.0f);
                n7 += this.valueChannel.strideSize;
                n8 += this.interpolationChannel.strideSize;
            }
        }
    }

    public ScaleInfluencer(ScaleInfluencer scaleInfluencer) {
        super(scaleInfluencer);
    }

    @Override
    public ParticleControllerComponent copy() {
        return new ScaleInfluencer(this);
    }
}

