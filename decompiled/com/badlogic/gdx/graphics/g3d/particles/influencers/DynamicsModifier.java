/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.particles.influencers;

import com.badlogic.gdx.graphics.g3d.particles.ParallelArray;
import com.badlogic.gdx.graphics.g3d.particles.ParticleChannels;
import com.badlogic.gdx.graphics.g3d.particles.ParticleControllerComponent;
import com.badlogic.gdx.graphics.g3d.particles.influencers.Influencer;
import com.badlogic.gdx.graphics.g3d.particles.values.ScaledNumericValue;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;

public abstract class DynamicsModifier
extends Influencer {
    protected static final Vector3 TMP_V1 = new Vector3();
    protected static final Vector3 TMP_V2 = new Vector3();
    protected static final Vector3 TMP_V3 = new Vector3();
    protected static final Quaternion TMP_Q = new Quaternion();
    public boolean isGlobal = false;
    protected ParallelArray.FloatChannel lifeChannel;

    public DynamicsModifier() {
    }

    public DynamicsModifier(DynamicsModifier dynamicsModifier) {
        this.isGlobal = dynamicsModifier.isGlobal;
    }

    @Override
    public void allocateChannels() {
        this.lifeChannel = (ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.Life);
    }

    @Override
    public void write(Json json) {
        super.write(json);
        json.writeValue("isGlobal", this.isGlobal);
    }

    @Override
    public void read(Json json, JsonValue jsonValue) {
        super.read(json, jsonValue);
        this.isGlobal = json.readValue("isGlobal", Boolean.TYPE, jsonValue);
    }

    public static class BrownianAcceleration
    extends Strength {
        ParallelArray.FloatChannel accelerationChannel;

        public BrownianAcceleration() {
        }

        public BrownianAcceleration(BrownianAcceleration brownianAcceleration) {
            super(brownianAcceleration);
        }

        @Override
        public void allocateChannels() {
            super.allocateChannels();
            this.accelerationChannel = (ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.Acceleration);
        }

        @Override
        public void update() {
            int n2 = 2;
            int n3 = 0;
            int n4 = 0;
            int n5 = 0;
            int n6 = this.controller.particles.size;
            while (n5 < n6) {
                float f2 = this.strengthChannel.data[n3 + 0] + this.strengthChannel.data[n3 + 1] * this.strengthValue.getScale(this.lifeChannel.data[n2]);
                TMP_V3.set(MathUtils.random(-1.0f, 1.0f), MathUtils.random(-1.0f, 1.0f), MathUtils.random(-1.0f, 1.0f)).nor().scl(f2);
                int n7 = n4 + 0;
                this.accelerationChannel.data[n7] = this.accelerationChannel.data[n7] + BrownianAcceleration.TMP_V3.x;
                int n8 = n4 + 1;
                this.accelerationChannel.data[n8] = this.accelerationChannel.data[n8] + BrownianAcceleration.TMP_V3.y;
                int n9 = n4 + 2;
                this.accelerationChannel.data[n9] = this.accelerationChannel.data[n9] + BrownianAcceleration.TMP_V3.z;
                ++n5;
                n3 += this.strengthChannel.strideSize;
                n4 += this.accelerationChannel.strideSize;
                n2 += this.lifeChannel.strideSize;
            }
        }

        @Override
        public BrownianAcceleration copy() {
            return new BrownianAcceleration(this);
        }
    }

    public static class TangentialAcceleration
    extends Angular {
        ParallelArray.FloatChannel directionalVelocityChannel;
        ParallelArray.FloatChannel positionChannel;

        public TangentialAcceleration() {
        }

        public TangentialAcceleration(TangentialAcceleration tangentialAcceleration) {
            super(tangentialAcceleration);
        }

        @Override
        public void allocateChannels() {
            super.allocateChannels();
            this.directionalVelocityChannel = (ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.Acceleration);
            this.positionChannel = (ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.Position);
        }

        @Override
        public void update() {
            int n2 = 0;
            int n3 = 2;
            int n4 = 0;
            int n5 = 0;
            int n6 = 0;
            int n7 = n2 + this.controller.particles.size * this.directionalVelocityChannel.strideSize;
            while (n2 < n7) {
                float f2 = this.lifeChannel.data[n3];
                float f3 = this.strengthChannel.data[n4 + 0] + this.strengthChannel.data[n4 + 1] * this.strengthValue.getScale(f2);
                float f4 = this.angularChannel.data[n5 + 2] + this.angularChannel.data[n5 + 3] * this.phiValue.getScale(f2);
                float f5 = this.angularChannel.data[n5 + 0] + this.angularChannel.data[n5 + 1] * this.thetaValue.getScale(f2);
                float f6 = MathUtils.cosDeg(f5);
                float f7 = MathUtils.sinDeg(f5);
                float f8 = MathUtils.cosDeg(f4);
                float f9 = MathUtils.sinDeg(f4);
                TMP_V3.set(f6 * f9, f8, f7 * f9);
                TMP_V1.set(this.positionChannel.data[n6 + 0], this.positionChannel.data[n6 + 1], this.positionChannel.data[n6 + 2]);
                if (!this.isGlobal) {
                    this.controller.transform.getTranslation(TMP_V2);
                    TMP_V1.sub(TMP_V2);
                    this.controller.transform.getRotation(TMP_Q, true);
                    TMP_V3.mul(TMP_Q);
                }
                TMP_V3.crs(TMP_V1).nor().scl(f3);
                int n8 = n2 + 0;
                this.directionalVelocityChannel.data[n8] = this.directionalVelocityChannel.data[n8] + TangentialAcceleration.TMP_V3.x;
                int n9 = n2 + 1;
                this.directionalVelocityChannel.data[n9] = this.directionalVelocityChannel.data[n9] + TangentialAcceleration.TMP_V3.y;
                int n10 = n2 + 2;
                this.directionalVelocityChannel.data[n10] = this.directionalVelocityChannel.data[n10] + TangentialAcceleration.TMP_V3.z;
                n4 += this.strengthChannel.strideSize;
                n2 += this.directionalVelocityChannel.strideSize;
                n5 += this.angularChannel.strideSize;
                n3 += this.lifeChannel.strideSize;
                n6 += this.positionChannel.strideSize;
            }
        }

        @Override
        public TangentialAcceleration copy() {
            return new TangentialAcceleration(this);
        }
    }

    public static class PolarAcceleration
    extends Angular {
        ParallelArray.FloatChannel directionalVelocityChannel;

        public PolarAcceleration() {
        }

        public PolarAcceleration(PolarAcceleration polarAcceleration) {
            super(polarAcceleration);
        }

        @Override
        public void allocateChannels() {
            super.allocateChannels();
            this.directionalVelocityChannel = (ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.Acceleration);
        }

        @Override
        public void update() {
            int n2 = 0;
            int n3 = 2;
            int n4 = 0;
            int n5 = 0;
            int n6 = n2 + this.controller.particles.size * this.directionalVelocityChannel.strideSize;
            while (n2 < n6) {
                float f2 = this.lifeChannel.data[n3];
                float f3 = this.strengthChannel.data[n4 + 0] + this.strengthChannel.data[n4 + 1] * this.strengthValue.getScale(f2);
                float f4 = this.angularChannel.data[n5 + 2] + this.angularChannel.data[n5 + 3] * this.phiValue.getScale(f2);
                float f5 = this.angularChannel.data[n5 + 0] + this.angularChannel.data[n5 + 1] * this.thetaValue.getScale(f2);
                float f6 = MathUtils.cosDeg(f5);
                float f7 = MathUtils.sinDeg(f5);
                float f8 = MathUtils.cosDeg(f4);
                float f9 = MathUtils.sinDeg(f4);
                TMP_V3.set(f6 * f9, f8, f7 * f9).nor().scl(f3);
                if (!this.isGlobal) {
                    this.controller.transform.getRotation(TMP_Q, true);
                    TMP_V3.mul(TMP_Q);
                }
                int n7 = n2 + 0;
                this.directionalVelocityChannel.data[n7] = this.directionalVelocityChannel.data[n7] + PolarAcceleration.TMP_V3.x;
                int n8 = n2 + 1;
                this.directionalVelocityChannel.data[n8] = this.directionalVelocityChannel.data[n8] + PolarAcceleration.TMP_V3.y;
                int n9 = n2 + 2;
                this.directionalVelocityChannel.data[n9] = this.directionalVelocityChannel.data[n9] + PolarAcceleration.TMP_V3.z;
                n4 += this.strengthChannel.strideSize;
                n2 += this.directionalVelocityChannel.strideSize;
                n5 += this.angularChannel.strideSize;
                n3 += this.lifeChannel.strideSize;
            }
        }

        @Override
        public PolarAcceleration copy() {
            return new PolarAcceleration(this);
        }
    }

    public static class CentripetalAcceleration
    extends Strength {
        ParallelArray.FloatChannel accelerationChannel;
        ParallelArray.FloatChannel positionChannel;

        public CentripetalAcceleration() {
        }

        public CentripetalAcceleration(CentripetalAcceleration centripetalAcceleration) {
            super(centripetalAcceleration);
        }

        @Override
        public void allocateChannels() {
            super.allocateChannels();
            this.accelerationChannel = (ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.Acceleration);
            this.positionChannel = (ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.Position);
        }

        @Override
        public void update() {
            float f2 = 0.0f;
            float f3 = 0.0f;
            float f4 = 0.0f;
            if (!this.isGlobal) {
                float[] fArray = this.controller.transform.val;
                f2 = fArray[12];
                f3 = fArray[13];
                f4 = fArray[14];
            }
            int n2 = 2;
            int n3 = 0;
            int n4 = 0;
            int n5 = 0;
            int n6 = 0;
            int n7 = this.controller.particles.size;
            while (n6 < n7) {
                float f5 = this.strengthChannel.data[n3 + 0] + this.strengthChannel.data[n3 + 1] * this.strengthValue.getScale(this.lifeChannel.data[n2]);
                TMP_V3.set(this.positionChannel.data[n4 + 0] - f2, this.positionChannel.data[n4 + 1] - f3, this.positionChannel.data[n4 + 2] - f4).nor().scl(f5);
                int n8 = n5 + 0;
                this.accelerationChannel.data[n8] = this.accelerationChannel.data[n8] + CentripetalAcceleration.TMP_V3.x;
                int n9 = n5 + 1;
                this.accelerationChannel.data[n9] = this.accelerationChannel.data[n9] + CentripetalAcceleration.TMP_V3.y;
                int n10 = n5 + 2;
                this.accelerationChannel.data[n10] = this.accelerationChannel.data[n10] + CentripetalAcceleration.TMP_V3.z;
                ++n6;
                n4 += this.positionChannel.strideSize;
                n3 += this.strengthChannel.strideSize;
                n5 += this.accelerationChannel.strideSize;
                n2 += this.lifeChannel.strideSize;
            }
        }

        @Override
        public CentripetalAcceleration copy() {
            return new CentripetalAcceleration(this);
        }
    }

    public static class Rotational3D
    extends Angular {
        ParallelArray.FloatChannel rotationChannel;
        ParallelArray.FloatChannel rotationalForceChannel;

        public Rotational3D() {
        }

        public Rotational3D(Rotational3D rotational3D) {
            super(rotational3D);
        }

        @Override
        public void allocateChannels() {
            super.allocateChannels();
            this.rotationChannel = (ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.Rotation3D);
            this.rotationalForceChannel = (ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.AngularVelocity3D);
        }

        @Override
        public void update() {
            int n2 = 0;
            int n3 = 2;
            int n4 = 0;
            int n5 = 0;
            int n6 = this.controller.particles.size * this.rotationalForceChannel.strideSize;
            while (n2 < n6) {
                float f2 = this.lifeChannel.data[n3];
                float f3 = this.strengthChannel.data[n4 + 0] + this.strengthChannel.data[n4 + 1] * this.strengthValue.getScale(f2);
                float f4 = this.angularChannel.data[n5 + 2] + this.angularChannel.data[n5 + 3] * this.phiValue.getScale(f2);
                float f5 = this.angularChannel.data[n5 + 0] + this.angularChannel.data[n5 + 1] * this.thetaValue.getScale(f2);
                float f6 = MathUtils.cosDeg(f5);
                float f7 = MathUtils.sinDeg(f5);
                float f8 = MathUtils.cosDeg(f4);
                float f9 = MathUtils.sinDeg(f4);
                TMP_V3.set(f6 * f9, f8, f7 * f9);
                TMP_V3.scl(f3 * ((float)Math.PI / 180));
                int n7 = n2 + 0;
                this.rotationalForceChannel.data[n7] = this.rotationalForceChannel.data[n7] + Rotational3D.TMP_V3.x;
                int n8 = n2 + 1;
                this.rotationalForceChannel.data[n8] = this.rotationalForceChannel.data[n8] + Rotational3D.TMP_V3.y;
                int n9 = n2 + 2;
                this.rotationalForceChannel.data[n9] = this.rotationalForceChannel.data[n9] + Rotational3D.TMP_V3.z;
                n4 += this.strengthChannel.strideSize;
                n2 += this.rotationalForceChannel.strideSize;
                n5 += this.angularChannel.strideSize;
                n3 += this.lifeChannel.strideSize;
            }
        }

        @Override
        public Rotational3D copy() {
            return new Rotational3D(this);
        }
    }

    public static class Rotational2D
    extends Strength {
        ParallelArray.FloatChannel rotationalVelocity2dChannel;

        public Rotational2D() {
        }

        public Rotational2D(Rotational2D rotational2D) {
            super(rotational2D);
        }

        @Override
        public void allocateChannels() {
            super.allocateChannels();
            this.rotationalVelocity2dChannel = (ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.AngularVelocity2D);
        }

        @Override
        public void update() {
            int n2 = 0;
            int n3 = 2;
            int n4 = 0;
            int n5 = n2 + this.controller.particles.size * this.rotationalVelocity2dChannel.strideSize;
            while (n2 < n5) {
                int n6 = n2;
                this.rotationalVelocity2dChannel.data[n6] = this.rotationalVelocity2dChannel.data[n6] + (this.strengthChannel.data[n4 + 0] + this.strengthChannel.data[n4 + 1] * this.strengthValue.getScale(this.lifeChannel.data[n3]));
                n4 += this.strengthChannel.strideSize;
                n2 += this.rotationalVelocity2dChannel.strideSize;
                n3 += this.lifeChannel.strideSize;
            }
        }

        @Override
        public Rotational2D copy() {
            return new Rotational2D(this);
        }
    }

    public static abstract class Angular
    extends Strength {
        protected ParallelArray.FloatChannel angularChannel;
        public ScaledNumericValue thetaValue = new ScaledNumericValue();
        public ScaledNumericValue phiValue = new ScaledNumericValue();

        public Angular() {
        }

        public Angular(Angular angular) {
            super(angular);
            this.thetaValue.load(angular.thetaValue);
            this.phiValue.load(angular.phiValue);
        }

        @Override
        public void allocateChannels() {
            super.allocateChannels();
            ParticleChannels.Interpolation4.id = this.controller.particleChannels.newId();
            this.angularChannel = (ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.Interpolation4);
        }

        @Override
        public void activateParticles(int n2, int n3) {
            int n4;
            super.activateParticles(n2, n3);
            int n5 = n4 + n3 * this.angularChannel.strideSize;
            for (n4 = n2 * this.angularChannel.strideSize; n4 < n5; n4 += this.angularChannel.strideSize) {
                float f2 = this.thetaValue.newLowValue();
                float f3 = this.thetaValue.newHighValue();
                if (!this.thetaValue.isRelative()) {
                    f3 -= f2;
                }
                this.angularChannel.data[n4 + 0] = f2;
                this.angularChannel.data[n4 + 1] = f3;
                f2 = this.phiValue.newLowValue();
                f3 = this.phiValue.newHighValue();
                if (!this.phiValue.isRelative()) {
                    f3 -= f2;
                }
                this.angularChannel.data[n4 + 2] = f2;
                this.angularChannel.data[n4 + 3] = f3;
            }
        }

        @Override
        public void write(Json json) {
            super.write(json);
            json.writeValue("thetaValue", this.thetaValue);
            json.writeValue("phiValue", this.phiValue);
        }

        @Override
        public void read(Json json, JsonValue jsonValue) {
            super.read(json, jsonValue);
            this.thetaValue = json.readValue("thetaValue", ScaledNumericValue.class, jsonValue);
            this.phiValue = json.readValue("phiValue", ScaledNumericValue.class, jsonValue);
        }
    }

    public static abstract class Strength
    extends DynamicsModifier {
        protected ParallelArray.FloatChannel strengthChannel;
        public ScaledNumericValue strengthValue = new ScaledNumericValue();

        public Strength() {
        }

        public Strength(Strength strength) {
            super(strength);
            this.strengthValue.load(strength.strengthValue);
        }

        @Override
        public void allocateChannels() {
            super.allocateChannels();
            ParticleChannels.Interpolation.id = this.controller.particleChannels.newId();
            this.strengthChannel = (ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.Interpolation);
        }

        @Override
        public void activateParticles(int n2, int n3) {
            int n4;
            int n5 = n4 + n3 * this.strengthChannel.strideSize;
            for (n4 = n2 * this.strengthChannel.strideSize; n4 < n5; n4 += this.strengthChannel.strideSize) {
                float f2 = this.strengthValue.newLowValue();
                float f3 = this.strengthValue.newHighValue();
                if (!this.strengthValue.isRelative()) {
                    f3 -= f2;
                }
                this.strengthChannel.data[n4 + 0] = f2;
                this.strengthChannel.data[n4 + 1] = f3;
            }
        }

        @Override
        public void write(Json json) {
            super.write(json);
            json.writeValue("strengthValue", this.strengthValue);
        }

        @Override
        public void read(Json json, JsonValue jsonValue) {
            super.read(json, jsonValue);
            this.strengthValue = json.readValue("strengthValue", ScaledNumericValue.class, jsonValue);
        }
    }

    public static class FaceDirection
    extends DynamicsModifier {
        ParallelArray.FloatChannel rotationChannel;
        ParallelArray.FloatChannel accellerationChannel;

        public FaceDirection() {
        }

        public FaceDirection(FaceDirection faceDirection) {
            super(faceDirection);
        }

        @Override
        public void allocateChannels() {
            this.rotationChannel = (ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.Rotation3D);
            this.accellerationChannel = (ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.Acceleration);
        }

        @Override
        public void update() {
            int n2 = 0;
            int n3 = 0;
            int n4 = n2 + this.controller.particles.size * this.rotationChannel.strideSize;
            while (n2 < n4) {
                Vector3 vector3 = TMP_V1.set(this.accellerationChannel.data[n3 + 0], this.accellerationChannel.data[n3 + 1], this.accellerationChannel.data[n3 + 2]).nor();
                Vector3 vector32 = TMP_V2.set(TMP_V1).crs(Vector3.Y).nor().crs(TMP_V1).nor();
                Vector3 vector33 = TMP_V3.set(vector32).crs(vector3).nor();
                TMP_Q.setFromAxes(false, vector33.x, vector32.x, vector3.x, vector33.y, vector32.y, vector3.y, vector33.z, vector32.z, vector3.z);
                this.rotationChannel.data[n2 + 0] = FaceDirection.TMP_Q.x;
                this.rotationChannel.data[n2 + 1] = FaceDirection.TMP_Q.y;
                this.rotationChannel.data[n2 + 2] = FaceDirection.TMP_Q.z;
                this.rotationChannel.data[n2 + 3] = FaceDirection.TMP_Q.w;
                n2 += this.rotationChannel.strideSize;
                n3 += this.accellerationChannel.strideSize;
            }
        }

        @Override
        public ParticleControllerComponent copy() {
            return new FaceDirection(this);
        }
    }
}

