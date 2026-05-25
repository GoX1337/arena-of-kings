/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.particles.influencers;

import com.badlogic.gdx.graphics.g3d.particles.ParallelArray;
import com.badlogic.gdx.graphics.g3d.particles.ParticleChannels;
import com.badlogic.gdx.graphics.g3d.particles.ParticleController;
import com.badlogic.gdx.graphics.g3d.particles.influencers.DynamicsModifier;
import com.badlogic.gdx.graphics.g3d.particles.influencers.Influencer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;
import java.util.Arrays;

public class DynamicsInfluencer
extends Influencer {
    public Array<DynamicsModifier> velocities;
    private ParallelArray.FloatChannel accellerationChannel;
    private ParallelArray.FloatChannel positionChannel;
    private ParallelArray.FloatChannel previousPositionChannel;
    private ParallelArray.FloatChannel rotationChannel;
    private ParallelArray.FloatChannel angularVelocityChannel;
    boolean hasAcceleration;
    boolean has2dAngularVelocity;
    boolean has3dAngularVelocity;

    public DynamicsInfluencer() {
        this.velocities = new Array(true, 3, DynamicsModifier.class);
    }

    public DynamicsInfluencer(DynamicsModifier ... dynamicsModifierArray) {
        this.velocities = new Array(true, dynamicsModifierArray.length, DynamicsModifier.class);
        for (DynamicsModifier dynamicsModifier : dynamicsModifierArray) {
            this.velocities.add((DynamicsModifier)dynamicsModifier.copy());
        }
    }

    public DynamicsInfluencer(DynamicsInfluencer dynamicsInfluencer) {
        this(dynamicsInfluencer.velocities.toArray(DynamicsModifier.class));
    }

    @Override
    public void allocateChannels() {
        for (int i2 = 0; i2 < this.velocities.size; ++i2) {
            ((DynamicsModifier[])this.velocities.items)[i2].allocateChannels();
        }
        this.accellerationChannel = (ParallelArray.FloatChannel)this.controller.particles.getChannel(ParticleChannels.Acceleration);
        boolean bl2 = this.hasAcceleration = this.accellerationChannel != null;
        if (this.hasAcceleration) {
            this.positionChannel = (ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.Position);
            this.previousPositionChannel = (ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.PreviousPosition);
        }
        this.angularVelocityChannel = (ParallelArray.FloatChannel)this.controller.particles.getChannel(ParticleChannels.AngularVelocity2D);
        boolean bl3 = this.has2dAngularVelocity = this.angularVelocityChannel != null;
        if (this.has2dAngularVelocity) {
            this.rotationChannel = (ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.Rotation2D);
            this.has3dAngularVelocity = false;
        } else {
            this.angularVelocityChannel = (ParallelArray.FloatChannel)this.controller.particles.getChannel(ParticleChannels.AngularVelocity3D);
            boolean bl4 = this.has3dAngularVelocity = this.angularVelocityChannel != null;
            if (this.has3dAngularVelocity) {
                this.rotationChannel = (ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.Rotation3D);
            }
        }
    }

    @Override
    public void set(ParticleController particleController) {
        super.set(particleController);
        for (int i2 = 0; i2 < this.velocities.size; ++i2) {
            ((DynamicsModifier[])this.velocities.items)[i2].set(particleController);
        }
    }

    @Override
    public void init() {
        for (int i2 = 0; i2 < this.velocities.size; ++i2) {
            ((DynamicsModifier[])this.velocities.items)[i2].init();
        }
    }

    @Override
    public void activateParticles(int n2, int n3) {
        int n4;
        int n5;
        if (this.hasAcceleration) {
            n4 = n5 + n3 * this.positionChannel.strideSize;
            for (n5 = n2 * this.positionChannel.strideSize; n5 < n4; n5 += this.positionChannel.strideSize) {
                this.previousPositionChannel.data[n5 + 0] = this.positionChannel.data[n5 + 0];
                this.previousPositionChannel.data[n5 + 1] = this.positionChannel.data[n5 + 1];
                this.previousPositionChannel.data[n5 + 2] = this.positionChannel.data[n5 + 2];
            }
        }
        if (this.has2dAngularVelocity) {
            n4 = n5 + n3 * this.rotationChannel.strideSize;
            for (n5 = n2 * this.rotationChannel.strideSize; n5 < n4; n5 += this.rotationChannel.strideSize) {
                this.rotationChannel.data[n5 + 0] = 1.0f;
                this.rotationChannel.data[n5 + 1] = 0.0f;
            }
        } else if (this.has3dAngularVelocity) {
            n4 = n5 + n3 * this.rotationChannel.strideSize;
            for (n5 = n2 * this.rotationChannel.strideSize; n5 < n4; n5 += this.rotationChannel.strideSize) {
                this.rotationChannel.data[n5 + 0] = 0.0f;
                this.rotationChannel.data[n5 + 1] = 0.0f;
                this.rotationChannel.data[n5 + 2] = 0.0f;
                this.rotationChannel.data[n5 + 3] = 1.0f;
            }
        }
        for (n5 = 0; n5 < this.velocities.size; ++n5) {
            ((DynamicsModifier[])this.velocities.items)[n5].activateParticles(n2, n3);
        }
    }

    @Override
    public void update() {
        block9: {
            float f2;
            float f3;
            int n2;
            int n3;
            block8: {
                float f4;
                if (this.hasAcceleration) {
                    Arrays.fill(this.accellerationChannel.data, 0, this.controller.particles.size * this.accellerationChannel.strideSize, 0.0f);
                }
                if (this.has2dAngularVelocity || this.has3dAngularVelocity) {
                    Arrays.fill(this.angularVelocityChannel.data, 0, this.controller.particles.size * this.angularVelocityChannel.strideSize, 0.0f);
                }
                for (n3 = 0; n3 < this.velocities.size; ++n3) {
                    ((DynamicsModifier[])this.velocities.items)[n3].update();
                }
                if (this.hasAcceleration) {
                    n3 = 0;
                    n2 = 0;
                    while (n3 < this.controller.particles.size) {
                        f4 = this.positionChannel.data[n2 + 0];
                        f3 = this.positionChannel.data[n2 + 1];
                        f2 = this.positionChannel.data[n2 + 2];
                        this.positionChannel.data[n2 + 0] = 2.0f * f4 - this.previousPositionChannel.data[n2 + 0] + this.accellerationChannel.data[n2 + 0] * this.controller.deltaTimeSqr;
                        this.positionChannel.data[n2 + 1] = 2.0f * f3 - this.previousPositionChannel.data[n2 + 1] + this.accellerationChannel.data[n2 + 1] * this.controller.deltaTimeSqr;
                        this.positionChannel.data[n2 + 2] = 2.0f * f2 - this.previousPositionChannel.data[n2 + 2] + this.accellerationChannel.data[n2 + 2] * this.controller.deltaTimeSqr;
                        this.previousPositionChannel.data[n2 + 0] = f4;
                        this.previousPositionChannel.data[n2 + 1] = f3;
                        this.previousPositionChannel.data[n2 + 2] = f2;
                        ++n3;
                        n2 += this.positionChannel.strideSize;
                    }
                }
                if (!this.has2dAngularVelocity) break block8;
                n3 = 0;
                n2 = 0;
                while (n3 < this.controller.particles.size) {
                    f4 = this.angularVelocityChannel.data[n3] * this.controller.deltaTime;
                    if (f4 != 0.0f) {
                        f3 = MathUtils.cosDeg(f4);
                        f2 = MathUtils.sinDeg(f4);
                        float f5 = this.rotationChannel.data[n2 + 0];
                        float f6 = this.rotationChannel.data[n2 + 1];
                        float f7 = f5 * f3 - f6 * f2;
                        float f8 = f6 * f3 + f5 * f2;
                        this.rotationChannel.data[n2 + 0] = f7;
                        this.rotationChannel.data[n2 + 1] = f8;
                    }
                    ++n3;
                    n2 += this.rotationChannel.strideSize;
                }
                break block9;
            }
            if (!this.has3dAngularVelocity) break block9;
            n3 = 0;
            n2 = 0;
            int n4 = 0;
            while (n3 < this.controller.particles.size) {
                f3 = this.angularVelocityChannel.data[n4 + 0];
                f2 = this.angularVelocityChannel.data[n4 + 1];
                float f9 = this.angularVelocityChannel.data[n4 + 2];
                float f10 = this.rotationChannel.data[n2 + 0];
                float f11 = this.rotationChannel.data[n2 + 1];
                float f12 = this.rotationChannel.data[n2 + 2];
                float f13 = this.rotationChannel.data[n2 + 3];
                TMP_Q.set(f3, f2, f9, 0.0f).mul(f10, f11, f12, f13).mul(0.5f * this.controller.deltaTime).add(f10, f11, f12, f13).nor();
                this.rotationChannel.data[n2 + 0] = DynamicsInfluencer.TMP_Q.x;
                this.rotationChannel.data[n2 + 1] = DynamicsInfluencer.TMP_Q.y;
                this.rotationChannel.data[n2 + 2] = DynamicsInfluencer.TMP_Q.z;
                this.rotationChannel.data[n2 + 3] = DynamicsInfluencer.TMP_Q.w;
                ++n3;
                n2 += this.rotationChannel.strideSize;
                n4 += this.angularVelocityChannel.strideSize;
            }
        }
    }

    @Override
    public DynamicsInfluencer copy() {
        return new DynamicsInfluencer(this);
    }

    @Override
    public void write(Json json) {
        json.writeValue("velocities", this.velocities, Array.class, DynamicsModifier.class);
    }

    @Override
    public void read(Json json, JsonValue jsonValue) {
        this.velocities.addAll(json.readValue("velocities", Array.class, DynamicsModifier.class, jsonValue));
    }
}

