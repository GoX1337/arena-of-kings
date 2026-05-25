/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.particles.emitters;

import com.badlogic.gdx.graphics.g3d.particles.ParallelArray;
import com.badlogic.gdx.graphics.g3d.particles.ParticleChannels;
import com.badlogic.gdx.graphics.g3d.particles.ParticleControllerComponent;
import com.badlogic.gdx.graphics.g3d.particles.emitters.Emitter;
import com.badlogic.gdx.graphics.g3d.particles.values.RangedNumericValue;
import com.badlogic.gdx.graphics.g3d.particles.values.ScaledNumericValue;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;

public class RegularEmitter
extends Emitter
implements Json.Serializable {
    public RangedNumericValue delayValue = new RangedNumericValue();
    public RangedNumericValue durationValue = new RangedNumericValue();
    public ScaledNumericValue lifeOffsetValue = new ScaledNumericValue();
    public ScaledNumericValue lifeValue = new ScaledNumericValue();
    public ScaledNumericValue emissionValue = new ScaledNumericValue();
    protected int emission;
    protected int emissionDiff;
    protected int emissionDelta;
    protected int lifeOffset;
    protected int lifeOffsetDiff;
    protected int life;
    protected int lifeDiff;
    protected float duration;
    protected float delay;
    protected float durationTimer;
    protected float delayTimer;
    private boolean continuous;
    private EmissionMode emissionMode;
    private ParallelArray.FloatChannel lifeChannel;

    public RegularEmitter() {
        this.durationValue.setActive(true);
        this.emissionValue.setActive(true);
        this.lifeValue.setActive(true);
        this.continuous = true;
        this.emissionMode = EmissionMode.Enabled;
    }

    public RegularEmitter(RegularEmitter regularEmitter) {
        this();
        this.set(regularEmitter);
    }

    @Override
    public void allocateChannels() {
        this.lifeChannel = (ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.Life);
    }

    @Override
    public void start() {
        this.delay = this.delayValue.active ? this.delayValue.newLowValue() : 0.0f;
        this.delayTimer = 0.0f;
        this.durationTimer = 0.0f;
        this.duration = this.durationValue.newLowValue();
        this.percent = this.durationTimer / this.duration;
        this.emission = (int)this.emissionValue.newLowValue();
        this.emissionDiff = (int)this.emissionValue.newHighValue();
        if (!this.emissionValue.isRelative()) {
            this.emissionDiff -= this.emission;
        }
        this.life = (int)this.lifeValue.newLowValue();
        this.lifeDiff = (int)this.lifeValue.newHighValue();
        if (!this.lifeValue.isRelative()) {
            this.lifeDiff -= this.life;
        }
        this.lifeOffset = this.lifeOffsetValue.active ? (int)this.lifeOffsetValue.newLowValue() : 0;
        this.lifeOffsetDiff = (int)this.lifeOffsetValue.newHighValue();
        if (!this.lifeOffsetValue.isRelative()) {
            this.lifeOffsetDiff -= this.lifeOffset;
        }
    }

    @Override
    public void init() {
        super.init();
        this.emissionDelta = 0;
        this.durationTimer = this.duration;
    }

    @Override
    public void activateParticles(int n2, int n3) {
        int n4;
        int n5;
        int n6 = n5 = this.life + (int)((float)this.lifeDiff * this.lifeValue.getScale(this.percent));
        int n7 = (int)((float)this.lifeOffset + (float)this.lifeOffsetDiff * this.lifeOffsetValue.getScale(this.percent));
        if (n7 > 0) {
            if (n7 >= n6) {
                n7 = n6 - 1;
            }
            n6 -= n7;
        }
        float f2 = 1.0f - (float)n6 / (float)n5;
        int n8 = n4 + n3 * this.lifeChannel.strideSize;
        for (n4 = n2 * this.lifeChannel.strideSize; n4 < n8; n4 += this.lifeChannel.strideSize) {
            this.lifeChannel.data[n4 + 0] = n6;
            this.lifeChannel.data[n4 + 1] = n5;
            this.lifeChannel.data[n4 + 2] = f2;
        }
    }

    @Override
    public void update() {
        int n2;
        int n3;
        float f2 = this.controller.deltaTime * 1000.0f;
        if (this.delayTimer < this.delay) {
            this.delayTimer += f2;
        } else {
            int n4 = n3 = this.emissionMode != EmissionMode.Disabled ? 1 : 0;
            if (this.durationTimer < this.duration) {
                this.durationTimer += f2;
                this.percent = this.durationTimer / this.duration;
            } else if (this.continuous && n3 != 0 && this.emissionMode == EmissionMode.Enabled) {
                this.controller.start();
            } else {
                n3 = 0;
            }
            if (n3 != 0) {
                this.emissionDelta = (int)((float)this.emissionDelta + f2);
                float f3 = (float)this.emission + (float)this.emissionDiff * this.emissionValue.getScale(this.percent);
                if (f3 > 0.0f && (float)this.emissionDelta >= (f3 = 1000.0f / f3)) {
                    n2 = (int)((float)this.emissionDelta / f3);
                    n2 = Math.min(n2, this.maxParticleCount - this.controller.particles.size);
                    this.emissionDelta = (int)((float)this.emissionDelta - (float)n2 * f3);
                    this.emissionDelta = (int)((float)this.emissionDelta % f3);
                    this.addParticles(n2);
                }
                if (this.controller.particles.size < this.minParticleCount) {
                    this.addParticles(this.minParticleCount - this.controller.particles.size);
                }
            }
        }
        n3 = this.controller.particles.size;
        int n5 = 0;
        n2 = 0;
        while (n5 < this.controller.particles.size) {
            int n6 = n2 + 0;
            float f4 = this.lifeChannel.data[n6] = this.lifeChannel.data[n6] - f2;
            if (f4 <= 0.0f) {
                this.controller.particles.removeElement(n5);
                continue;
            }
            this.lifeChannel.data[n2 + 2] = 1.0f - this.lifeChannel.data[n2 + 0] / this.lifeChannel.data[n2 + 1];
            ++n5;
            n2 += this.lifeChannel.strideSize;
        }
        if (this.controller.particles.size < n3) {
            this.controller.killParticles(this.controller.particles.size, n3 - this.controller.particles.size);
        }
    }

    private void addParticles(int n2) {
        if ((n2 = Math.min(n2, this.maxParticleCount - this.controller.particles.size)) <= 0) {
            return;
        }
        this.controller.activateParticles(this.controller.particles.size, n2);
        this.controller.particles.size += n2;
    }

    public ScaledNumericValue getLife() {
        return this.lifeValue;
    }

    public ScaledNumericValue getEmission() {
        return this.emissionValue;
    }

    public RangedNumericValue getDuration() {
        return this.durationValue;
    }

    public RangedNumericValue getDelay() {
        return this.delayValue;
    }

    public ScaledNumericValue getLifeOffset() {
        return this.lifeOffsetValue;
    }

    public boolean isContinuous() {
        return this.continuous;
    }

    public void setContinuous(boolean bl2) {
        this.continuous = bl2;
    }

    public EmissionMode getEmissionMode() {
        return this.emissionMode;
    }

    public void setEmissionMode(EmissionMode emissionMode) {
        this.emissionMode = emissionMode;
    }

    @Override
    public boolean isComplete() {
        if (this.delayTimer < this.delay) {
            return false;
        }
        return this.durationTimer >= this.duration && this.controller.particles.size == 0;
    }

    public float getPercentComplete() {
        if (this.delayTimer < this.delay) {
            return 0.0f;
        }
        return Math.min(1.0f, this.durationTimer / this.duration);
    }

    public void set(RegularEmitter regularEmitter) {
        super.set(regularEmitter);
        this.delayValue.load(regularEmitter.delayValue);
        this.durationValue.load(regularEmitter.durationValue);
        this.lifeOffsetValue.load(regularEmitter.lifeOffsetValue);
        this.lifeValue.load(regularEmitter.lifeValue);
        this.emissionValue.load(regularEmitter.emissionValue);
        this.emission = regularEmitter.emission;
        this.emissionDiff = regularEmitter.emissionDiff;
        this.emissionDelta = regularEmitter.emissionDelta;
        this.lifeOffset = regularEmitter.lifeOffset;
        this.lifeOffsetDiff = regularEmitter.lifeOffsetDiff;
        this.life = regularEmitter.life;
        this.lifeDiff = regularEmitter.lifeDiff;
        this.duration = regularEmitter.duration;
        this.delay = regularEmitter.delay;
        this.durationTimer = regularEmitter.durationTimer;
        this.delayTimer = regularEmitter.delayTimer;
        this.continuous = regularEmitter.continuous;
    }

    @Override
    public ParticleControllerComponent copy() {
        return new RegularEmitter(this);
    }

    @Override
    public void write(Json json) {
        super.write(json);
        json.writeValue("continous", this.continuous);
        json.writeValue("emission", this.emissionValue);
        json.writeValue("delay", this.delayValue);
        json.writeValue("duration", this.durationValue);
        json.writeValue("life", this.lifeValue);
        json.writeValue("lifeOffset", this.lifeOffsetValue);
    }

    @Override
    public void read(Json json, JsonValue jsonValue) {
        super.read(json, jsonValue);
        this.continuous = json.readValue("continous", Boolean.TYPE, jsonValue);
        this.emissionValue = json.readValue("emission", ScaledNumericValue.class, jsonValue);
        this.delayValue = json.readValue("delay", RangedNumericValue.class, jsonValue);
        this.durationValue = json.readValue("duration", RangedNumericValue.class, jsonValue);
        this.lifeValue = json.readValue("life", ScaledNumericValue.class, jsonValue);
        this.lifeOffsetValue = json.readValue("lifeOffset", ScaledNumericValue.class, jsonValue);
    }

    public static enum EmissionMode {
        Enabled,
        EnabledUntilCycleEnd,
        Disabled;

    }
}

