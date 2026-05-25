/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g2d;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.collision.BoundingBox;
import com.badlogic.gdx.utils.Array;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;

public class ParticleEmitter {
    private static final int UPDATE_SCALE = 1;
    private static final int UPDATE_ANGLE = 2;
    private static final int UPDATE_ROTATION = 4;
    private static final int UPDATE_VELOCITY = 8;
    private static final int UPDATE_WIND = 16;
    private static final int UPDATE_GRAVITY = 32;
    private static final int UPDATE_TINT = 64;
    private static final int UPDATE_SPRITE = 128;
    private RangedNumericValue delayValue = new RangedNumericValue();
    private IndependentScaledNumericValue lifeOffsetValue = new IndependentScaledNumericValue();
    private RangedNumericValue durationValue = new RangedNumericValue();
    private IndependentScaledNumericValue lifeValue = new IndependentScaledNumericValue();
    private ScaledNumericValue emissionValue = new ScaledNumericValue();
    private ScaledNumericValue xScaleValue = new ScaledNumericValue();
    private ScaledNumericValue yScaleValue = new ScaledNumericValue();
    private ScaledNumericValue rotationValue = new ScaledNumericValue();
    private ScaledNumericValue velocityValue = new ScaledNumericValue();
    private ScaledNumericValue angleValue = new ScaledNumericValue();
    private ScaledNumericValue windValue = new ScaledNumericValue();
    private ScaledNumericValue gravityValue = new ScaledNumericValue();
    private ScaledNumericValue transparencyValue = new ScaledNumericValue();
    private GradientColorValue tintValue = new GradientColorValue();
    private RangedNumericValue xOffsetValue = new ScaledNumericValue();
    private RangedNumericValue yOffsetValue = new ScaledNumericValue();
    private ScaledNumericValue spawnWidthValue = new ScaledNumericValue();
    private ScaledNumericValue spawnHeightValue = new ScaledNumericValue();
    private SpawnShapeValue spawnShapeValue = new SpawnShapeValue();
    private RangedNumericValue[] xSizeValues;
    private RangedNumericValue[] ySizeValues;
    private RangedNumericValue[] motionValues;
    private float accumulator;
    private Array<Sprite> sprites;
    private SpriteMode spriteMode = SpriteMode.single;
    private Particle[] particles;
    private int minParticleCount;
    private int maxParticleCount = 4;
    private float x;
    private float y;
    private String name;
    private Array<String> imagePaths;
    private int activeCount;
    private boolean[] active;
    private boolean firstUpdate;
    private boolean flipX;
    private boolean flipY;
    private int updateFlags;
    private boolean allowCompletion;
    private BoundingBox bounds;
    private int emission;
    private int emissionDiff;
    private int emissionDelta;
    private int lifeOffset;
    private int lifeOffsetDiff;
    private int life;
    private int lifeDiff;
    private float spawnWidth;
    private float spawnWidthDiff;
    private float spawnHeight;
    private float spawnHeightDiff;
    public float duration = 1.0f;
    public float durationTimer;
    private float delay;
    private float delayTimer;
    private boolean attached;
    private boolean continuous;
    private boolean aligned;
    private boolean behind;
    private boolean additive = true;
    private boolean premultipliedAlpha = false;
    boolean cleansUpBlendFunction = true;

    public ParticleEmitter() {
        this.initialize();
    }

    public ParticleEmitter(BufferedReader bufferedReader) {
        this.initialize();
        this.load(bufferedReader);
    }

    public ParticleEmitter(ParticleEmitter particleEmitter) {
        this.sprites = new Array<Sprite>(particleEmitter.sprites);
        this.name = particleEmitter.name;
        this.imagePaths = new Array<String>(particleEmitter.imagePaths);
        this.setMaxParticleCount(particleEmitter.maxParticleCount);
        this.minParticleCount = particleEmitter.minParticleCount;
        this.delayValue.load(particleEmitter.delayValue);
        this.durationValue.load(particleEmitter.durationValue);
        this.emissionValue.load(particleEmitter.emissionValue);
        this.lifeValue.load(particleEmitter.lifeValue);
        this.lifeOffsetValue.load(particleEmitter.lifeOffsetValue);
        this.xScaleValue.load(particleEmitter.xScaleValue);
        this.yScaleValue.load(particleEmitter.yScaleValue);
        this.rotationValue.load(particleEmitter.rotationValue);
        this.velocityValue.load(particleEmitter.velocityValue);
        this.angleValue.load(particleEmitter.angleValue);
        this.windValue.load(particleEmitter.windValue);
        this.gravityValue.load(particleEmitter.gravityValue);
        this.transparencyValue.load(particleEmitter.transparencyValue);
        this.tintValue.load(particleEmitter.tintValue);
        this.xOffsetValue.load(particleEmitter.xOffsetValue);
        this.yOffsetValue.load(particleEmitter.yOffsetValue);
        this.spawnWidthValue.load(particleEmitter.spawnWidthValue);
        this.spawnHeightValue.load(particleEmitter.spawnHeightValue);
        this.spawnShapeValue.load(particleEmitter.spawnShapeValue);
        this.attached = particleEmitter.attached;
        this.continuous = particleEmitter.continuous;
        this.aligned = particleEmitter.aligned;
        this.behind = particleEmitter.behind;
        this.additive = particleEmitter.additive;
        this.premultipliedAlpha = particleEmitter.premultipliedAlpha;
        this.cleansUpBlendFunction = particleEmitter.cleansUpBlendFunction;
        this.spriteMode = particleEmitter.spriteMode;
        this.setPosition(particleEmitter.getX(), particleEmitter.getY());
    }

    private void initialize() {
        this.sprites = new Array();
        this.imagePaths = new Array();
        this.durationValue.setAlwaysActive(true);
        this.emissionValue.setAlwaysActive(true);
        this.lifeValue.setAlwaysActive(true);
        this.xScaleValue.setAlwaysActive(true);
        this.transparencyValue.setAlwaysActive(true);
        this.spawnShapeValue.setAlwaysActive(true);
        this.spawnWidthValue.setAlwaysActive(true);
        this.spawnHeightValue.setAlwaysActive(true);
    }

    public void setMaxParticleCount(int n2) {
        this.maxParticleCount = n2;
        this.active = new boolean[n2];
        this.activeCount = 0;
        this.particles = new Particle[n2];
    }

    public void addParticle() {
        int n2 = this.activeCount;
        if (n2 == this.maxParticleCount) {
            return;
        }
        boolean[] blArray = this.active;
        int n3 = blArray.length;
        for (int i2 = 0; i2 < n3; ++i2) {
            if (blArray[i2]) continue;
            this.activateParticle(i2);
            blArray[i2] = true;
            this.activeCount = n2 + 1;
            break;
        }
    }

    public void addParticles(int n2) {
        if ((n2 = Math.min(n2, this.maxParticleCount - this.activeCount)) == 0) {
            return;
        }
        boolean[] blArray = this.active;
        int n3 = 0;
        int n4 = blArray.length;
        block0: for (int i2 = 0; i2 < n2; ++i2) {
            while (n3 < n4) {
                if (blArray[n3]) {
                    ++n3;
                    continue;
                }
                this.activateParticle(n3);
                blArray[n3++] = true;
                continue block0;
            }
            break block0;
        }
        this.activeCount += n2;
    }

    public void update(float f2) {
        this.accumulator += f2 * 1000.0f;
        if (this.accumulator < 1.0f) {
            return;
        }
        int n2 = (int)this.accumulator;
        this.accumulator -= (float)n2;
        if (this.delayTimer < this.delay) {
            this.delayTimer += (float)n2;
        } else {
            boolean bl2 = false;
            if (this.firstUpdate) {
                this.firstUpdate = false;
                this.addParticle();
            }
            if (this.durationTimer < this.duration) {
                this.durationTimer += (float)n2;
            } else if (!this.continuous || this.allowCompletion) {
                bl2 = true;
            } else {
                this.restart();
            }
            if (!bl2) {
                this.emissionDelta += n2;
                float f3 = (float)this.emission + (float)this.emissionDiff * this.emissionValue.getScale(this.durationTimer / this.duration);
                if (f3 > 0.0f && (float)this.emissionDelta >= (f3 = 1000.0f / f3)) {
                    int n3 = (int)((float)this.emissionDelta / f3);
                    n3 = Math.min(n3, this.maxParticleCount - this.activeCount);
                    this.emissionDelta = (int)((float)this.emissionDelta - (float)n3 * f3);
                    this.emissionDelta = (int)((float)this.emissionDelta % f3);
                    this.addParticles(n3);
                }
                if (this.activeCount < this.minParticleCount) {
                    this.addParticles(this.minParticleCount - this.activeCount);
                }
            }
        }
        boolean[] blArray = this.active;
        int n4 = this.activeCount;
        Particle[] particleArray = this.particles;
        int n5 = blArray.length;
        for (int i2 = 0; i2 < n5; ++i2) {
            if (!blArray[i2] || this.updateParticle(particleArray[i2], f2, n2)) continue;
            blArray[i2] = false;
            --n4;
        }
        this.activeCount = n4;
    }

    public void draw(Batch batch) {
        if (this.premultipliedAlpha) {
            batch.setBlendFunction(1, 771);
        } else if (this.additive) {
            batch.setBlendFunction(770, 1);
        } else {
            batch.setBlendFunction(770, 771);
        }
        Particle[] particleArray = this.particles;
        boolean[] blArray = this.active;
        int n2 = blArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (!blArray[i2]) continue;
            particleArray[i2].draw(batch);
        }
        if (this.cleansUpBlendFunction && (this.additive || this.premultipliedAlpha)) {
            batch.setBlendFunction(770, 771);
        }
    }

    public void draw(Batch batch, float f2) {
        this.accumulator += f2 * 1000.0f;
        if (this.accumulator < 1.0f) {
            this.draw(batch);
            return;
        }
        int n2 = (int)this.accumulator;
        this.accumulator -= (float)n2;
        if (this.premultipliedAlpha) {
            batch.setBlendFunction(1, 771);
        } else if (this.additive) {
            batch.setBlendFunction(770, 1);
        } else {
            batch.setBlendFunction(770, 771);
        }
        Particle[] particleArray = this.particles;
        boolean[] blArray = this.active;
        int n3 = this.activeCount;
        int n4 = blArray.length;
        for (int i2 = 0; i2 < n4; ++i2) {
            if (!blArray[i2]) continue;
            Particle particle = particleArray[i2];
            if (this.updateParticle(particle, f2, n2)) {
                particle.draw(batch);
                continue;
            }
            blArray[i2] = false;
            --n3;
        }
        this.activeCount = n3;
        if (this.cleansUpBlendFunction && (this.additive || this.premultipliedAlpha)) {
            batch.setBlendFunction(770, 771);
        }
        if (this.delayTimer < this.delay) {
            this.delayTimer += (float)n2;
            return;
        }
        if (this.firstUpdate) {
            this.firstUpdate = false;
            this.addParticle();
        }
        if (this.durationTimer < this.duration) {
            this.durationTimer += (float)n2;
        } else {
            if (!this.continuous || this.allowCompletion) {
                return;
            }
            this.restart();
        }
        this.emissionDelta += n2;
        float f3 = (float)this.emission + (float)this.emissionDiff * this.emissionValue.getScale(this.durationTimer / this.duration);
        if (f3 > 0.0f && (float)this.emissionDelta >= (f3 = 1000.0f / f3)) {
            n4 = (int)((float)this.emissionDelta / f3);
            n4 = Math.min(n4, this.maxParticleCount - n3);
            this.emissionDelta = (int)((float)this.emissionDelta - (float)n4 * f3);
            this.emissionDelta = (int)((float)this.emissionDelta % f3);
            this.addParticles(n4);
        }
        if (n3 < this.minParticleCount) {
            this.addParticles(this.minParticleCount - n3);
        }
    }

    public void start() {
        this.firstUpdate = true;
        this.allowCompletion = false;
        this.restart();
    }

    public void reset() {
        this.emissionDelta = 0;
        this.durationTimer = this.duration;
        boolean[] blArray = this.active;
        int n2 = blArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            blArray[i2] = false;
        }
        this.activeCount = 0;
        this.start();
    }

    private void restart() {
        this.delay = this.delayValue.active ? this.delayValue.newLowValue() : 0.0f;
        this.delayTimer = 0.0f;
        this.durationTimer -= this.duration;
        this.duration = this.durationValue.newLowValue();
        this.emission = (int)this.emissionValue.newLowValue();
        this.emissionDiff = (int)this.emissionValue.newHighValue();
        if (!this.emissionValue.isRelative()) {
            this.emissionDiff -= this.emission;
        }
        if (!this.lifeValue.independent) {
            this.generateLifeValues();
        }
        if (!this.lifeOffsetValue.independent) {
            this.generateLifeOffsetValues();
        }
        this.spawnWidth = this.spawnWidthValue.newLowValue();
        this.spawnWidthDiff = this.spawnWidthValue.newHighValue();
        if (!this.spawnWidthValue.isRelative()) {
            this.spawnWidthDiff -= this.spawnWidth;
        }
        this.spawnHeight = this.spawnHeightValue.newLowValue();
        this.spawnHeightDiff = this.spawnHeightValue.newHighValue();
        if (!this.spawnHeightValue.isRelative()) {
            this.spawnHeightDiff -= this.spawnHeight;
        }
        this.updateFlags = 0;
        if (this.angleValue.active && this.angleValue.timeline.length > 1) {
            this.updateFlags |= 2;
        }
        if (this.velocityValue.active) {
            this.updateFlags |= 8;
        }
        if (this.xScaleValue.timeline.length > 1) {
            this.updateFlags |= 1;
        }
        if (this.yScaleValue.active && this.yScaleValue.timeline.length > 1) {
            this.updateFlags |= 1;
        }
        if (this.rotationValue.active && this.rotationValue.timeline.length > 1) {
            this.updateFlags |= 4;
        }
        if (this.windValue.active) {
            this.updateFlags |= 0x10;
        }
        if (this.gravityValue.active) {
            this.updateFlags |= 0x20;
        }
        if (this.tintValue.timeline.length > 1) {
            this.updateFlags |= 0x40;
        }
        if (this.spriteMode == SpriteMode.animated) {
            this.updateFlags |= 0x80;
        }
    }

    protected Particle newParticle(Sprite sprite) {
        return new Particle(sprite);
    }

    protected Particle[] getParticles() {
        return this.particles;
    }

    private void activateParticle(int n2) {
        float[] fArray;
        Sprite sprite = null;
        switch (this.spriteMode) {
            case single: 
            case animated: {
                sprite = this.sprites.first();
                break;
            }
            case random: {
                sprite = this.sprites.random();
            }
        }
        Particle particle = this.particles[n2];
        if (particle == null) {
            this.particles[n2] = particle = this.newParticle(sprite);
            particle.flip(this.flipX, this.flipY);
        } else {
            particle.set(sprite);
        }
        float f2 = this.durationTimer / this.duration;
        int n3 = this.updateFlags;
        if (this.lifeValue.independent) {
            this.generateLifeValues();
        }
        if (this.lifeOffsetValue.independent) {
            this.generateLifeOffsetValues();
        }
        particle.currentLife = particle.life = this.life + (int)((float)this.lifeDiff * this.lifeValue.getScale(f2));
        if (this.velocityValue.active) {
            particle.velocity = this.velocityValue.newLowValue();
            particle.velocityDiff = this.velocityValue.newHighValue();
            if (!this.velocityValue.isRelative()) {
                particle.velocityDiff -= particle.velocity;
            }
        }
        particle.angle = this.angleValue.newLowValue();
        particle.angleDiff = this.angleValue.newHighValue();
        if (!this.angleValue.isRelative()) {
            particle.angleDiff -= particle.angle;
        }
        float f3 = 0.0f;
        if ((n3 & 2) == 0) {
            particle.angle = f3 = particle.angle + particle.angleDiff * this.angleValue.getScale(0.0f);
            particle.angleCos = MathUtils.cosDeg(f3);
            particle.angleSin = MathUtils.sinDeg(f3);
        }
        float f4 = sprite.getWidth();
        float f5 = sprite.getHeight();
        particle.xScale = this.xScaleValue.newLowValue() / f4;
        particle.xScaleDiff = this.xScaleValue.newHighValue() / f4;
        if (!this.xScaleValue.isRelative()) {
            particle.xScaleDiff -= particle.xScale;
        }
        if (this.yScaleValue.active) {
            particle.yScale = this.yScaleValue.newLowValue() / f5;
            particle.yScaleDiff = this.yScaleValue.newHighValue() / f5;
            if (!this.yScaleValue.isRelative()) {
                particle.yScaleDiff -= particle.yScale;
            }
            particle.setScale(particle.xScale + particle.xScaleDiff * this.xScaleValue.getScale(0.0f), particle.yScale + particle.yScaleDiff * this.yScaleValue.getScale(0.0f));
        } else {
            particle.setScale(particle.xScale + particle.xScaleDiff * this.xScaleValue.getScale(0.0f));
        }
        if (this.rotationValue.active) {
            particle.rotation = this.rotationValue.newLowValue();
            particle.rotationDiff = this.rotationValue.newHighValue();
            if (!this.rotationValue.isRelative()) {
                particle.rotationDiff -= particle.rotation;
            }
            float f6 = particle.rotation + particle.rotationDiff * this.rotationValue.getScale(0.0f);
            if (this.aligned) {
                f6 += f3;
            }
            particle.setRotation(f6);
        }
        if (this.windValue.active) {
            particle.wind = this.windValue.newLowValue();
            particle.windDiff = this.windValue.newHighValue();
            if (!this.windValue.isRelative()) {
                particle.windDiff -= particle.wind;
            }
        }
        if (this.gravityValue.active) {
            particle.gravity = this.gravityValue.newLowValue();
            particle.gravityDiff = this.gravityValue.newHighValue();
            if (!this.gravityValue.isRelative()) {
                particle.gravityDiff -= particle.gravity;
            }
        }
        if ((fArray = particle.tint) == null) {
            particle.tint = fArray = new float[3];
        }
        float[] fArray2 = this.tintValue.getColor(0.0f);
        fArray[0] = fArray2[0];
        fArray[1] = fArray2[1];
        fArray[2] = fArray2[2];
        particle.transparency = this.transparencyValue.newLowValue();
        particle.transparencyDiff = this.transparencyValue.newHighValue() - particle.transparency;
        float f7 = this.x;
        if (this.xOffsetValue.active) {
            f7 += this.xOffsetValue.newLowValue();
        }
        float f8 = this.y;
        if (this.yOffsetValue.active) {
            f8 += this.yOffsetValue.newLowValue();
        }
        switch (this.spawnShapeValue.shape) {
            case square: {
                float f9 = this.spawnWidth + this.spawnWidthDiff * this.spawnWidthValue.getScale(f2);
                float f10 = this.spawnHeight + this.spawnHeightDiff * this.spawnHeightValue.getScale(f2);
                f7 += MathUtils.random(f9) - f9 / 2.0f;
                f8 += MathUtils.random(f10) - f10 / 2.0f;
                break;
            }
            case ellipse: {
                float f11;
                float f12;
                float f9 = this.spawnWidth + this.spawnWidthDiff * this.spawnWidthValue.getScale(f2);
                float f13 = this.spawnHeight + this.spawnHeightDiff * this.spawnHeightValue.getScale(f2);
                float f14 = f9 / 2.0f;
                float f15 = f13 / 2.0f;
                if (f14 == 0.0f || f15 == 0.0f) break;
                float f16 = f14 / f15;
                if (this.spawnShapeValue.edges) {
                    float f17;
                    switch (this.spawnShapeValue.side) {
                        case top: {
                            f17 = -MathUtils.random(179.0f);
                            break;
                        }
                        case bottom: {
                            f17 = MathUtils.random(179.0f);
                            break;
                        }
                        default: {
                            f17 = MathUtils.random(360.0f);
                        }
                    }
                    float f18 = MathUtils.cosDeg(f17);
                    float f19 = MathUtils.sinDeg(f17);
                    f7 += f18 * f14;
                    f8 += f19 * f14 / f16;
                    if ((n3 & 2) != 0) break;
                    particle.angle = f17;
                    particle.angleCos = f18;
                    particle.angleSin = f19;
                    break;
                }
                float f20 = f14 * f14;
                while (!((f12 = MathUtils.random(f9) - f14) * f12 + (f11 = MathUtils.random(f9) - f14) * f11 <= f20)) {
                }
                f7 += f12;
                f8 += f11 / f16;
                break;
            }
            case line: {
                float f9 = this.spawnWidth + this.spawnWidthDiff * this.spawnWidthValue.getScale(f2);
                float f21 = this.spawnHeight + this.spawnHeightDiff * this.spawnHeightValue.getScale(f2);
                if (f9 != 0.0f) {
                    float f22 = f9 * MathUtils.random();
                    f7 += f22;
                    f8 += f22 * (f21 / f9);
                    break;
                }
                f8 += f21 * MathUtils.random();
                break;
            }
        }
        particle.setBounds(f7 - f4 / 2.0f, f8 - f5 / 2.0f, f4, f5);
        int n4 = (int)((float)this.lifeOffset + (float)this.lifeOffsetDiff * this.lifeOffsetValue.getScale(f2));
        if (n4 > 0) {
            if (n4 >= particle.currentLife) {
                n4 = particle.currentLife - 1;
            }
            this.updateParticle(particle, (float)n4 / 1000.0f, n4);
        }
    }

    private boolean updateParticle(Particle particle, float f2, int n2) {
        int n3;
        float f3;
        float f4;
        float f5;
        float f6;
        int n4 = particle.currentLife - n2;
        if (n4 <= 0) {
            return false;
        }
        particle.currentLife = n4;
        float f7 = 1.0f - (float)particle.currentLife / (float)particle.life;
        int n5 = this.updateFlags;
        if ((n5 & 1) != 0) {
            if (this.yScaleValue.active) {
                particle.setScale(particle.xScale + particle.xScaleDiff * this.xScaleValue.getScale(f7), particle.yScale + particle.yScaleDiff * this.yScaleValue.getScale(f7));
            } else {
                particle.setScale(particle.xScale + particle.xScaleDiff * this.xScaleValue.getScale(f7));
            }
        }
        if ((n5 & 8) != 0) {
            float f8 = (particle.velocity + particle.velocityDiff * this.velocityValue.getScale(f7)) * f2;
            if ((n5 & 2) != 0) {
                f6 = particle.angle + particle.angleDiff * this.angleValue.getScale(f7);
                f5 = f8 * MathUtils.cosDeg(f6);
                f4 = f8 * MathUtils.sinDeg(f6);
                if ((n5 & 4) != 0) {
                    f3 = particle.rotation + particle.rotationDiff * this.rotationValue.getScale(f7);
                    if (this.aligned) {
                        f3 += f6;
                    }
                    particle.setRotation(f3);
                }
            } else {
                f5 = f8 * particle.angleCos;
                f4 = f8 * particle.angleSin;
                if (this.aligned || (n5 & 4) != 0) {
                    f6 = particle.rotation + particle.rotationDiff * this.rotationValue.getScale(f7);
                    if (this.aligned) {
                        f6 += particle.angle;
                    }
                    particle.setRotation(f6);
                }
            }
            if ((n5 & 0x10) != 0) {
                f5 += (particle.wind + particle.windDiff * this.windValue.getScale(f7)) * f2;
            }
            if ((n5 & 0x20) != 0) {
                f4 += (particle.gravity + particle.gravityDiff * this.gravityValue.getScale(f7)) * f2;
            }
            particle.translate(f5, f4);
        } else if ((n5 & 4) != 0) {
            particle.setRotation(particle.rotation + particle.rotationDiff * this.rotationValue.getScale(f7));
        }
        float[] fArray = (n5 & 0x40) != 0 ? this.tintValue.getColor(f7) : particle.tint;
        if (this.premultipliedAlpha) {
            f5 = this.additive ? 0.0f : 1.0f;
            f4 = particle.transparency + particle.transparencyDiff * this.transparencyValue.getScale(f7);
            particle.setColor(fArray[0] * f4, fArray[1] * f4, fArray[2] * f4, f4 * f5);
        } else {
            particle.setColor(fArray[0], fArray[1], fArray[2], particle.transparency + particle.transparencyDiff * this.transparencyValue.getScale(f7));
        }
        if ((n5 & 0x80) != 0 && particle.frame != (n3 = Math.min((int)(f7 * (float)this.sprites.size), this.sprites.size - 1))) {
            Sprite sprite = this.sprites.get(n3);
            f6 = particle.getWidth();
            f3 = particle.getHeight();
            particle.setRegion(sprite);
            particle.setSize(sprite.getWidth(), sprite.getHeight());
            particle.setOrigin(sprite.getOriginX(), sprite.getOriginY());
            particle.translate((f6 - sprite.getWidth()) / 2.0f, (f3 - sprite.getHeight()) / 2.0f);
            particle.frame = n3;
        }
        return true;
    }

    private void generateLifeValues() {
        this.life = (int)this.lifeValue.newLowValue();
        this.lifeDiff = (int)this.lifeValue.newHighValue();
        if (!this.lifeValue.isRelative()) {
            this.lifeDiff -= this.life;
        }
    }

    private void generateLifeOffsetValues() {
        this.lifeOffset = this.lifeOffsetValue.active ? (int)this.lifeOffsetValue.newLowValue() : 0;
        this.lifeOffsetDiff = (int)this.lifeOffsetValue.newHighValue();
        if (!this.lifeOffsetValue.isRelative()) {
            this.lifeOffsetDiff -= this.lifeOffset;
        }
    }

    public void setPosition(float f2, float f3) {
        if (this.attached) {
            float f4 = f2 - this.x;
            float f5 = f3 - this.y;
            boolean[] blArray = this.active;
            int n2 = blArray.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                if (!blArray[i2]) continue;
                this.particles[i2].translate(f4, f5);
            }
        }
        this.x = f2;
        this.y = f3;
    }

    public void setSprites(Array<Sprite> array) {
        this.sprites = array;
        if (array.size == 0) {
            return;
        }
        for (Particle particle : this.particles) {
            if (particle == null) break;
            Sprite sprite = null;
            switch (this.spriteMode) {
                case single: {
                    sprite = array.first();
                    break;
                }
                case random: {
                    sprite = array.random();
                    break;
                }
                case animated: {
                    float f2 = 1.0f - (float)particle.currentLife / (float)particle.life;
                    particle.frame = Math.min((int)(f2 * (float)array.size), array.size - 1);
                    sprite = array.get(particle.frame);
                }
            }
            particle.setRegion(sprite);
            particle.setOrigin(sprite.getOriginX(), sprite.getOriginY());
        }
    }

    public void setSpriteMode(SpriteMode spriteMode) {
        this.spriteMode = spriteMode;
    }

    public void preAllocateParticles() {
        if (this.sprites.isEmpty()) {
            throw new IllegalStateException("ParticleEmitter.setSprites() must have been called before preAllocateParticles()");
        }
        for (int i2 = 0; i2 < this.particles.length; ++i2) {
            Particle particle = this.particles[i2];
            if (particle != null) continue;
            this.particles[i2] = particle = this.newParticle(this.sprites.first());
            particle.flip(this.flipX, this.flipY);
        }
    }

    public void allowCompletion() {
        this.allowCompletion = true;
        this.durationTimer = this.duration;
    }

    public Array<Sprite> getSprites() {
        return this.sprites;
    }

    public SpriteMode getSpriteMode() {
        return this.spriteMode;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String string) {
        this.name = string;
    }

    public ScaledNumericValue getLife() {
        return this.lifeValue;
    }

    public ScaledNumericValue getXScale() {
        return this.xScaleValue;
    }

    public ScaledNumericValue getYScale() {
        return this.yScaleValue;
    }

    public ScaledNumericValue getRotation() {
        return this.rotationValue;
    }

    public GradientColorValue getTint() {
        return this.tintValue;
    }

    public ScaledNumericValue getVelocity() {
        return this.velocityValue;
    }

    public ScaledNumericValue getWind() {
        return this.windValue;
    }

    public ScaledNumericValue getGravity() {
        return this.gravityValue;
    }

    public ScaledNumericValue getAngle() {
        return this.angleValue;
    }

    public ScaledNumericValue getEmission() {
        return this.emissionValue;
    }

    public ScaledNumericValue getTransparency() {
        return this.transparencyValue;
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

    public RangedNumericValue getXOffsetValue() {
        return this.xOffsetValue;
    }

    public RangedNumericValue getYOffsetValue() {
        return this.yOffsetValue;
    }

    public ScaledNumericValue getSpawnWidth() {
        return this.spawnWidthValue;
    }

    public ScaledNumericValue getSpawnHeight() {
        return this.spawnHeightValue;
    }

    public SpawnShapeValue getSpawnShape() {
        return this.spawnShapeValue;
    }

    public boolean isAttached() {
        return this.attached;
    }

    public void setAttached(boolean bl2) {
        this.attached = bl2;
    }

    public boolean isContinuous() {
        return this.continuous;
    }

    public void setContinuous(boolean bl2) {
        this.continuous = bl2;
    }

    public boolean isAligned() {
        return this.aligned;
    }

    public void setAligned(boolean bl2) {
        this.aligned = bl2;
    }

    public boolean isAdditive() {
        return this.additive;
    }

    public void setAdditive(boolean bl2) {
        this.additive = bl2;
    }

    public boolean cleansUpBlendFunction() {
        return this.cleansUpBlendFunction;
    }

    public void setCleansUpBlendFunction(boolean bl2) {
        this.cleansUpBlendFunction = bl2;
    }

    public boolean isBehind() {
        return this.behind;
    }

    public void setBehind(boolean bl2) {
        this.behind = bl2;
    }

    public boolean isPremultipliedAlpha() {
        return this.premultipliedAlpha;
    }

    public void setPremultipliedAlpha(boolean bl2) {
        this.premultipliedAlpha = bl2;
    }

    public int getMinParticleCount() {
        return this.minParticleCount;
    }

    public void setMinParticleCount(int n2) {
        this.minParticleCount = n2;
    }

    public int getMaxParticleCount() {
        return this.maxParticleCount;
    }

    public boolean isComplete() {
        if (this.continuous && !this.allowCompletion) {
            return false;
        }
        if (this.delayTimer < this.delay) {
            return false;
        }
        return this.durationTimer >= this.duration && this.activeCount == 0;
    }

    public float getPercentComplete() {
        if (this.delayTimer < this.delay) {
            return 0.0f;
        }
        return Math.min(1.0f, this.durationTimer / this.duration);
    }

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }

    public int getActiveCount() {
        return this.activeCount;
    }

    public Array<String> getImagePaths() {
        return this.imagePaths;
    }

    public void setImagePaths(Array<String> array) {
        this.imagePaths = array;
    }

    public void setFlip(boolean bl2, boolean bl3) {
        this.flipX = bl2;
        this.flipY = bl3;
        if (this.particles == null) {
            return;
        }
        for (Particle particle : this.particles) {
            if (particle == null) continue;
            particle.flip(bl2, bl3);
        }
    }

    public void flipY() {
        this.angleValue.setHigh(-this.angleValue.getHighMin(), -this.angleValue.getHighMax());
        this.angleValue.setLow(-this.angleValue.getLowMin(), -this.angleValue.getLowMax());
        this.gravityValue.setHigh(-this.gravityValue.getHighMin(), -this.gravityValue.getHighMax());
        this.gravityValue.setLow(-this.gravityValue.getLowMin(), -this.gravityValue.getLowMax());
        this.windValue.setHigh(-this.windValue.getHighMin(), -this.windValue.getHighMax());
        this.windValue.setLow(-this.windValue.getLowMin(), -this.windValue.getLowMax());
        this.rotationValue.setHigh(-this.rotationValue.getHighMin(), -this.rotationValue.getHighMax());
        this.rotationValue.setLow(-this.rotationValue.getLowMin(), -this.rotationValue.getLowMax());
        this.yOffsetValue.setLow(-this.yOffsetValue.getLowMin(), -this.yOffsetValue.getLowMax());
    }

    public BoundingBox getBoundingBox() {
        if (this.bounds == null) {
            this.bounds = new BoundingBox();
        }
        Particle[] particleArray = this.particles;
        boolean[] blArray = this.active;
        BoundingBox boundingBox = this.bounds;
        boundingBox.inf();
        int n2 = blArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (!blArray[i2]) continue;
            Rectangle rectangle = particleArray[i2].getBoundingRectangle();
            boundingBox.ext(rectangle.x, rectangle.y, 0.0f);
            boundingBox.ext(rectangle.x + rectangle.width, rectangle.y + rectangle.height, 0.0f);
        }
        return boundingBox;
    }

    protected RangedNumericValue[] getXSizeValues() {
        if (this.xSizeValues == null) {
            this.xSizeValues = new RangedNumericValue[3];
            this.xSizeValues[0] = this.xScaleValue;
            this.xSizeValues[1] = this.spawnWidthValue;
            this.xSizeValues[2] = this.xOffsetValue;
        }
        return this.xSizeValues;
    }

    protected RangedNumericValue[] getYSizeValues() {
        if (this.ySizeValues == null) {
            this.ySizeValues = new RangedNumericValue[3];
            this.ySizeValues[0] = this.yScaleValue;
            this.ySizeValues[1] = this.spawnHeightValue;
            this.ySizeValues[2] = this.yOffsetValue;
        }
        return this.ySizeValues;
    }

    protected RangedNumericValue[] getMotionValues() {
        if (this.motionValues == null) {
            this.motionValues = new RangedNumericValue[3];
            this.motionValues[0] = this.velocityValue;
            this.motionValues[1] = this.windValue;
            this.motionValues[2] = this.gravityValue;
        }
        return this.motionValues;
    }

    public void scaleSize(float f2) {
        if (f2 == 1.0f) {
            return;
        }
        this.scaleSize(f2, f2);
    }

    public void scaleSize(float f2, float f3) {
        if (f2 == 1.0f && f3 == 1.0f) {
            return;
        }
        for (RangedNumericValue rangedNumericValue : this.getXSizeValues()) {
            rangedNumericValue.scale(f2);
        }
        for (RangedNumericValue rangedNumericValue : this.getYSizeValues()) {
            rangedNumericValue.scale(f3);
        }
    }

    public void scaleMotion(float f2) {
        if (f2 == 1.0f) {
            return;
        }
        for (RangedNumericValue rangedNumericValue : this.getMotionValues()) {
            rangedNumericValue.scale(f2);
        }
    }

    public void matchSize(ParticleEmitter particleEmitter) {
        this.matchXSize(particleEmitter);
        this.matchYSize(particleEmitter);
    }

    public void matchXSize(ParticleEmitter particleEmitter) {
        RangedNumericValue[] rangedNumericValueArray = this.getXSizeValues();
        RangedNumericValue[] rangedNumericValueArray2 = particleEmitter.getXSizeValues();
        for (int i2 = 0; i2 < rangedNumericValueArray.length; ++i2) {
            rangedNumericValueArray[i2].set(rangedNumericValueArray2[i2]);
        }
    }

    public void matchYSize(ParticleEmitter particleEmitter) {
        RangedNumericValue[] rangedNumericValueArray = this.getYSizeValues();
        RangedNumericValue[] rangedNumericValueArray2 = particleEmitter.getYSizeValues();
        for (int i2 = 0; i2 < rangedNumericValueArray.length; ++i2) {
            rangedNumericValueArray[i2].set(rangedNumericValueArray2[i2]);
        }
    }

    public void matchMotion(ParticleEmitter particleEmitter) {
        RangedNumericValue[] rangedNumericValueArray = this.getMotionValues();
        RangedNumericValue[] rangedNumericValueArray2 = particleEmitter.getMotionValues();
        for (int i2 = 0; i2 < rangedNumericValueArray.length; ++i2) {
            rangedNumericValueArray[i2].set(rangedNumericValueArray2[i2]);
        }
    }

    public void save(Writer writer) {
        writer.write(this.name + "\n");
        writer.write("- Delay -\n");
        this.delayValue.save(writer);
        writer.write("- Duration - \n");
        this.durationValue.save(writer);
        writer.write("- Count - \n");
        writer.write("min: " + this.minParticleCount + "\n");
        writer.write("max: " + this.maxParticleCount + "\n");
        writer.write("- Emission - \n");
        this.emissionValue.save(writer);
        writer.write("- Life - \n");
        this.lifeValue.save(writer);
        writer.write("- Life Offset - \n");
        this.lifeOffsetValue.save(writer);
        writer.write("- X Offset - \n");
        this.xOffsetValue.save(writer);
        writer.write("- Y Offset - \n");
        this.yOffsetValue.save(writer);
        writer.write("- Spawn Shape - \n");
        this.spawnShapeValue.save(writer);
        writer.write("- Spawn Width - \n");
        this.spawnWidthValue.save(writer);
        writer.write("- Spawn Height - \n");
        this.spawnHeightValue.save(writer);
        writer.write("- X Scale - \n");
        this.xScaleValue.save(writer);
        writer.write("- Y Scale - \n");
        this.yScaleValue.save(writer);
        writer.write("- Velocity - \n");
        this.velocityValue.save(writer);
        writer.write("- Angle - \n");
        this.angleValue.save(writer);
        writer.write("- Rotation - \n");
        this.rotationValue.save(writer);
        writer.write("- Wind - \n");
        this.windValue.save(writer);
        writer.write("- Gravity - \n");
        this.gravityValue.save(writer);
        writer.write("- Tint - \n");
        this.tintValue.save(writer);
        writer.write("- Transparency - \n");
        this.transparencyValue.save(writer);
        writer.write("- Options - \n");
        writer.write("attached: " + this.attached + "\n");
        writer.write("continuous: " + this.continuous + "\n");
        writer.write("aligned: " + this.aligned + "\n");
        writer.write("additive: " + this.additive + "\n");
        writer.write("behind: " + this.behind + "\n");
        writer.write("premultipliedAlpha: " + this.premultipliedAlpha + "\n");
        writer.write("spriteMode: " + this.spriteMode.toString() + "\n");
        writer.write("- Image Paths -\n");
        for (String string : this.imagePaths) {
            writer.write(string + "\n");
        }
        writer.write("\n");
    }

    public void load(BufferedReader bufferedReader) {
        try {
            this.name = ParticleEmitter.readString(bufferedReader, "name");
            bufferedReader.readLine();
            this.delayValue.load(bufferedReader);
            bufferedReader.readLine();
            this.durationValue.load(bufferedReader);
            bufferedReader.readLine();
            this.setMinParticleCount(ParticleEmitter.readInt(bufferedReader, "minParticleCount"));
            this.setMaxParticleCount(ParticleEmitter.readInt(bufferedReader, "maxParticleCount"));
            bufferedReader.readLine();
            this.emissionValue.load(bufferedReader);
            bufferedReader.readLine();
            this.lifeValue.load(bufferedReader);
            bufferedReader.readLine();
            this.lifeOffsetValue.load(bufferedReader);
            bufferedReader.readLine();
            this.xOffsetValue.load(bufferedReader);
            bufferedReader.readLine();
            this.yOffsetValue.load(bufferedReader);
            bufferedReader.readLine();
            this.spawnShapeValue.load(bufferedReader);
            bufferedReader.readLine();
            this.spawnWidthValue.load(bufferedReader);
            bufferedReader.readLine();
            this.spawnHeightValue.load(bufferedReader);
            String string = bufferedReader.readLine();
            if (string.trim().equals("- Scale -")) {
                this.xScaleValue.load(bufferedReader);
                this.yScaleValue.setActive(false);
            } else {
                this.xScaleValue.load(bufferedReader);
                bufferedReader.readLine();
                this.yScaleValue.load(bufferedReader);
            }
            bufferedReader.readLine();
            this.velocityValue.load(bufferedReader);
            bufferedReader.readLine();
            this.angleValue.load(bufferedReader);
            bufferedReader.readLine();
            this.rotationValue.load(bufferedReader);
            bufferedReader.readLine();
            this.windValue.load(bufferedReader);
            bufferedReader.readLine();
            this.gravityValue.load(bufferedReader);
            bufferedReader.readLine();
            this.tintValue.load(bufferedReader);
            bufferedReader.readLine();
            this.transparencyValue.load(bufferedReader);
            bufferedReader.readLine();
            this.attached = ParticleEmitter.readBoolean(bufferedReader, "attached");
            this.continuous = ParticleEmitter.readBoolean(bufferedReader, "continuous");
            this.aligned = ParticleEmitter.readBoolean(bufferedReader, "aligned");
            this.additive = ParticleEmitter.readBoolean(bufferedReader, "additive");
            this.behind = ParticleEmitter.readBoolean(bufferedReader, "behind");
            string = bufferedReader.readLine();
            if (string.startsWith("premultipliedAlpha")) {
                this.premultipliedAlpha = ParticleEmitter.readBoolean(string);
                string = bufferedReader.readLine();
            }
            if (string.startsWith("spriteMode")) {
                this.spriteMode = SpriteMode.valueOf(ParticleEmitter.readString(string));
                string = bufferedReader.readLine();
            }
            Array<String> array = new Array<String>();
            while ((string = bufferedReader.readLine()) != null && !string.isEmpty()) {
                array.add(string);
            }
            this.setImagePaths(array);
        }
        catch (RuntimeException runtimeException) {
            if (this.name == null) {
                throw runtimeException;
            }
            throw new RuntimeException("Error parsing emitter: " + this.name, runtimeException);
        }
    }

    static String readString(String string) {
        return string.substring(string.indexOf(":") + 1).trim();
    }

    static String readString(BufferedReader bufferedReader, String string) {
        String string2 = bufferedReader.readLine();
        if (string2 == null) {
            throw new IOException("Missing value: " + string);
        }
        return ParticleEmitter.readString(string2);
    }

    static boolean readBoolean(String string) {
        return Boolean.parseBoolean(ParticleEmitter.readString(string));
    }

    static boolean readBoolean(BufferedReader bufferedReader, String string) {
        return Boolean.parseBoolean(ParticleEmitter.readString(bufferedReader, string));
    }

    static int readInt(BufferedReader bufferedReader, String string) {
        return Integer.parseInt(ParticleEmitter.readString(bufferedReader, string));
    }

    static float readFloat(BufferedReader bufferedReader, String string) {
        return Float.parseFloat(ParticleEmitter.readString(bufferedReader, string));
    }

    public static enum SpriteMode {
        single,
        random,
        animated;

    }

    public static enum SpawnEllipseSide {
        both,
        top,
        bottom;

    }

    public static enum SpawnShape {
        point,
        line,
        square,
        ellipse;

    }

    public static class SpawnShapeValue
    extends ParticleValue {
        SpawnShape shape = SpawnShape.point;
        boolean edges;
        SpawnEllipseSide side = SpawnEllipseSide.both;

        public SpawnShape getShape() {
            return this.shape;
        }

        public void setShape(SpawnShape spawnShape) {
            this.shape = spawnShape;
        }

        public boolean isEdges() {
            return this.edges;
        }

        public void setEdges(boolean bl2) {
            this.edges = bl2;
        }

        public SpawnEllipseSide getSide() {
            return this.side;
        }

        public void setSide(SpawnEllipseSide spawnEllipseSide) {
            this.side = spawnEllipseSide;
        }

        @Override
        public void save(Writer writer) {
            super.save(writer);
            if (!this.active) {
                return;
            }
            writer.write("shape: " + (Object)((Object)this.shape) + "\n");
            if (this.shape == SpawnShape.ellipse) {
                writer.write("edges: " + this.edges + "\n");
                writer.write("side: " + (Object)((Object)this.side) + "\n");
            }
        }

        @Override
        public void load(BufferedReader bufferedReader) {
            super.load(bufferedReader);
            if (!this.active) {
                return;
            }
            this.shape = SpawnShape.valueOf(ParticleEmitter.readString(bufferedReader, "shape"));
            if (this.shape == SpawnShape.ellipse) {
                this.edges = ParticleEmitter.readBoolean(bufferedReader, "edges");
                this.side = SpawnEllipseSide.valueOf(ParticleEmitter.readString(bufferedReader, "side"));
            }
        }

        public void load(SpawnShapeValue spawnShapeValue) {
            super.load(spawnShapeValue);
            this.shape = spawnShapeValue.shape;
            this.edges = spawnShapeValue.edges;
            this.side = spawnShapeValue.side;
        }
    }

    public static class GradientColorValue
    extends ParticleValue {
        private static float[] temp = new float[4];
        private float[] colors = new float[]{1.0f, 1.0f, 1.0f};
        float[] timeline = new float[]{0.0f};

        public GradientColorValue() {
            this.alwaysActive = true;
        }

        public float[] getTimeline() {
            return this.timeline;
        }

        public void setTimeline(float[] fArray) {
            this.timeline = fArray;
        }

        public float[] getColors() {
            return this.colors;
        }

        public void setColors(float[] fArray) {
            this.colors = fArray;
        }

        public float[] getColor(float f2) {
            float f3;
            int n2 = 0;
            int n3 = -1;
            float[] fArray = this.timeline;
            int n4 = fArray.length;
            int n5 = 1;
            while (n5 < n4) {
                f3 = fArray[n5];
                if (f3 > f2) {
                    n3 = n5;
                    break;
                }
                n2 = n5++;
            }
            float f4 = fArray[n2];
            f3 = this.colors[n2 *= 3];
            float f5 = this.colors[n2 + 1];
            float f6 = this.colors[n2 + 2];
            if (n3 == -1) {
                GradientColorValue.temp[0] = f3;
                GradientColorValue.temp[1] = f5;
                GradientColorValue.temp[2] = f6;
                return temp;
            }
            float f7 = (f2 - f4) / (fArray[n3] - f4);
            GradientColorValue.temp[0] = f3 + (this.colors[n3 *= 3] - f3) * f7;
            GradientColorValue.temp[1] = f5 + (this.colors[n3 + 1] - f5) * f7;
            GradientColorValue.temp[2] = f6 + (this.colors[n3 + 2] - f6) * f7;
            return temp;
        }

        @Override
        public void save(Writer writer) {
            int n2;
            super.save(writer);
            if (!this.active) {
                return;
            }
            writer.write("colorsCount: " + this.colors.length + "\n");
            for (n2 = 0; n2 < this.colors.length; ++n2) {
                writer.write("colors" + n2 + ": " + this.colors[n2] + "\n");
            }
            writer.write("timelineCount: " + this.timeline.length + "\n");
            for (n2 = 0; n2 < this.timeline.length; ++n2) {
                writer.write("timeline" + n2 + ": " + this.timeline[n2] + "\n");
            }
        }

        @Override
        public void load(BufferedReader bufferedReader) {
            int n2;
            super.load(bufferedReader);
            if (!this.active) {
                return;
            }
            this.colors = new float[ParticleEmitter.readInt(bufferedReader, "colorsCount")];
            for (n2 = 0; n2 < this.colors.length; ++n2) {
                this.colors[n2] = ParticleEmitter.readFloat(bufferedReader, "colors" + n2);
            }
            this.timeline = new float[ParticleEmitter.readInt(bufferedReader, "timelineCount")];
            for (n2 = 0; n2 < this.timeline.length; ++n2) {
                this.timeline[n2] = ParticleEmitter.readFloat(bufferedReader, "timeline" + n2);
            }
        }

        public void load(GradientColorValue gradientColorValue) {
            super.load(gradientColorValue);
            this.colors = new float[gradientColorValue.colors.length];
            System.arraycopy(gradientColorValue.colors, 0, this.colors, 0, this.colors.length);
            this.timeline = new float[gradientColorValue.timeline.length];
            System.arraycopy(gradientColorValue.timeline, 0, this.timeline, 0, this.timeline.length);
        }
    }

    public static class IndependentScaledNumericValue
    extends ScaledNumericValue {
        boolean independent;

        public boolean isIndependent() {
            return this.independent;
        }

        public void setIndependent(boolean bl2) {
            this.independent = bl2;
        }

        @Override
        public void set(RangedNumericValue rangedNumericValue) {
            if (rangedNumericValue instanceof IndependentScaledNumericValue) {
                this.set((IndependentScaledNumericValue)rangedNumericValue);
            } else {
                super.set(rangedNumericValue);
            }
        }

        @Override
        public void set(ScaledNumericValue scaledNumericValue) {
            if (scaledNumericValue instanceof IndependentScaledNumericValue) {
                this.set((IndependentScaledNumericValue)scaledNumericValue);
            } else {
                super.set(scaledNumericValue);
            }
        }

        public void set(IndependentScaledNumericValue independentScaledNumericValue) {
            super.set(independentScaledNumericValue);
            this.independent = independentScaledNumericValue.independent;
        }

        @Override
        public void save(Writer writer) {
            super.save(writer);
            writer.write("independent: " + this.independent + "\n");
        }

        @Override
        public void load(BufferedReader bufferedReader) {
            String string;
            super.load(bufferedReader);
            if (bufferedReader.markSupported()) {
                bufferedReader.mark(100);
            }
            if ((string = bufferedReader.readLine()) == null) {
                throw new IOException("Missing value: independent");
            }
            if (string.contains("independent")) {
                this.independent = Boolean.parseBoolean(ParticleEmitter.readString(string));
            } else if (bufferedReader.markSupported()) {
                bufferedReader.reset();
            } else {
                String string2 = "The loaded particle effect descriptor file uses an old invalid format. Please download the latest version of the Particle Editor tool and recreate the file by loading and saving it again.";
                Gdx.app.error("ParticleEmitter", string2);
                throw new IOException(string2);
            }
        }

        public void load(IndependentScaledNumericValue independentScaledNumericValue) {
            super.load(independentScaledNumericValue);
            this.independent = independentScaledNumericValue.independent;
        }
    }

    public static class ScaledNumericValue
    extends RangedNumericValue {
        private float[] scaling = new float[]{1.0f};
        float[] timeline = new float[]{0.0f};
        private float highMin;
        private float highMax;
        private boolean relative;

        public float newHighValue() {
            return this.highMin + (this.highMax - this.highMin) * MathUtils.random();
        }

        public void setHigh(float f2) {
            this.highMin = f2;
            this.highMax = f2;
        }

        public void setHigh(float f2, float f3) {
            this.highMin = f2;
            this.highMax = f3;
        }

        public float getHighMin() {
            return this.highMin;
        }

        public void setHighMin(float f2) {
            this.highMin = f2;
        }

        public float getHighMax() {
            return this.highMax;
        }

        public void setHighMax(float f2) {
            this.highMax = f2;
        }

        @Override
        public void scale(float f2) {
            super.scale(f2);
            this.highMin *= f2;
            this.highMax *= f2;
        }

        @Override
        public void set(RangedNumericValue rangedNumericValue) {
            if (rangedNumericValue instanceof ScaledNumericValue) {
                this.set((ScaledNumericValue)rangedNumericValue);
            } else {
                super.set(rangedNumericValue);
            }
        }

        public void set(ScaledNumericValue scaledNumericValue) {
            super.set(scaledNumericValue);
            this.highMin = scaledNumericValue.highMin;
            this.highMax = scaledNumericValue.highMax;
            if (this.scaling.length != scaledNumericValue.scaling.length) {
                this.scaling = Arrays.copyOf(scaledNumericValue.scaling, scaledNumericValue.scaling.length);
            } else {
                System.arraycopy(scaledNumericValue.scaling, 0, this.scaling, 0, this.scaling.length);
            }
            if (this.timeline.length != scaledNumericValue.timeline.length) {
                this.timeline = Arrays.copyOf(scaledNumericValue.timeline, scaledNumericValue.timeline.length);
            } else {
                System.arraycopy(scaledNumericValue.timeline, 0, this.timeline, 0, this.timeline.length);
            }
            this.relative = scaledNumericValue.relative;
        }

        public float[] getScaling() {
            return this.scaling;
        }

        public void setScaling(float[] fArray) {
            this.scaling = fArray;
        }

        public float[] getTimeline() {
            return this.timeline;
        }

        public void setTimeline(float[] fArray) {
            this.timeline = fArray;
        }

        public boolean isRelative() {
            return this.relative;
        }

        public void setRelative(boolean bl2) {
            this.relative = bl2;
        }

        public float getScale(float f2) {
            int n2 = -1;
            float[] fArray = this.timeline;
            int n3 = fArray.length;
            for (int i2 = 1; i2 < n3; ++i2) {
                float f3 = fArray[i2];
                if (!(f3 > f2)) continue;
                n2 = i2;
                break;
            }
            if (n2 == -1) {
                return this.scaling[n3 - 1];
            }
            float[] fArray2 = this.scaling;
            int n4 = n2 - 1;
            float f4 = fArray2[n4];
            float f5 = fArray[n4];
            return f4 + (fArray2[n2] - f4) * ((f2 - f5) / (fArray[n2] - f5));
        }

        @Override
        public void save(Writer writer) {
            int n2;
            super.save(writer);
            if (!this.active) {
                return;
            }
            writer.write("highMin: " + this.highMin + "\n");
            writer.write("highMax: " + this.highMax + "\n");
            writer.write("relative: " + this.relative + "\n");
            writer.write("scalingCount: " + this.scaling.length + "\n");
            for (n2 = 0; n2 < this.scaling.length; ++n2) {
                writer.write("scaling" + n2 + ": " + this.scaling[n2] + "\n");
            }
            writer.write("timelineCount: " + this.timeline.length + "\n");
            for (n2 = 0; n2 < this.timeline.length; ++n2) {
                writer.write("timeline" + n2 + ": " + this.timeline[n2] + "\n");
            }
        }

        @Override
        public void load(BufferedReader bufferedReader) {
            int n2;
            super.load(bufferedReader);
            if (!this.active) {
                return;
            }
            this.highMin = ParticleEmitter.readFloat(bufferedReader, "highMin");
            this.highMax = ParticleEmitter.readFloat(bufferedReader, "highMax");
            this.relative = ParticleEmitter.readBoolean(bufferedReader, "relative");
            this.scaling = new float[ParticleEmitter.readInt(bufferedReader, "scalingCount")];
            for (n2 = 0; n2 < this.scaling.length; ++n2) {
                this.scaling[n2] = ParticleEmitter.readFloat(bufferedReader, "scaling" + n2);
            }
            this.timeline = new float[ParticleEmitter.readInt(bufferedReader, "timelineCount")];
            for (n2 = 0; n2 < this.timeline.length; ++n2) {
                this.timeline[n2] = ParticleEmitter.readFloat(bufferedReader, "timeline" + n2);
            }
        }

        public void load(ScaledNumericValue scaledNumericValue) {
            super.load(scaledNumericValue);
            this.highMax = scaledNumericValue.highMax;
            this.highMin = scaledNumericValue.highMin;
            this.scaling = new float[scaledNumericValue.scaling.length];
            System.arraycopy(scaledNumericValue.scaling, 0, this.scaling, 0, this.scaling.length);
            this.timeline = new float[scaledNumericValue.timeline.length];
            System.arraycopy(scaledNumericValue.timeline, 0, this.timeline, 0, this.timeline.length);
            this.relative = scaledNumericValue.relative;
        }
    }

    public static class RangedNumericValue
    extends ParticleValue {
        private float lowMin;
        private float lowMax;

        public float newLowValue() {
            return this.lowMin + (this.lowMax - this.lowMin) * MathUtils.random();
        }

        public void setLow(float f2) {
            this.lowMin = f2;
            this.lowMax = f2;
        }

        public void setLow(float f2, float f3) {
            this.lowMin = f2;
            this.lowMax = f3;
        }

        public float getLowMin() {
            return this.lowMin;
        }

        public void setLowMin(float f2) {
            this.lowMin = f2;
        }

        public float getLowMax() {
            return this.lowMax;
        }

        public void setLowMax(float f2) {
            this.lowMax = f2;
        }

        public void scale(float f2) {
            this.lowMin *= f2;
            this.lowMax *= f2;
        }

        public void set(RangedNumericValue rangedNumericValue) {
            this.lowMin = rangedNumericValue.lowMin;
            this.lowMax = rangedNumericValue.lowMax;
        }

        @Override
        public void save(Writer writer) {
            super.save(writer);
            if (!this.active) {
                return;
            }
            writer.write("lowMin: " + this.lowMin + "\n");
            writer.write("lowMax: " + this.lowMax + "\n");
        }

        @Override
        public void load(BufferedReader bufferedReader) {
            super.load(bufferedReader);
            if (!this.active) {
                return;
            }
            this.lowMin = ParticleEmitter.readFloat(bufferedReader, "lowMin");
            this.lowMax = ParticleEmitter.readFloat(bufferedReader, "lowMax");
        }

        public void load(RangedNumericValue rangedNumericValue) {
            super.load(rangedNumericValue);
            this.lowMax = rangedNumericValue.lowMax;
            this.lowMin = rangedNumericValue.lowMin;
        }
    }

    public static class NumericValue
    extends ParticleValue {
        private float value;

        public float getValue() {
            return this.value;
        }

        public void setValue(float f2) {
            this.value = f2;
        }

        @Override
        public void save(Writer writer) {
            super.save(writer);
            if (!this.active) {
                return;
            }
            writer.write("value: " + this.value + "\n");
        }

        @Override
        public void load(BufferedReader bufferedReader) {
            super.load(bufferedReader);
            if (!this.active) {
                return;
            }
            this.value = ParticleEmitter.readFloat(bufferedReader, "value");
        }

        public void load(NumericValue numericValue) {
            super.load(numericValue);
            this.value = numericValue.value;
        }
    }

    public static class ParticleValue {
        boolean active;
        boolean alwaysActive;

        public void setAlwaysActive(boolean bl2) {
            this.alwaysActive = bl2;
        }

        public boolean isAlwaysActive() {
            return this.alwaysActive;
        }

        public boolean isActive() {
            return this.alwaysActive || this.active;
        }

        public void setActive(boolean bl2) {
            this.active = bl2;
        }

        public void save(Writer writer) {
            if (!this.alwaysActive) {
                writer.write("active: " + this.active + "\n");
            } else {
                this.active = true;
            }
        }

        public void load(BufferedReader bufferedReader) {
            this.active = !this.alwaysActive ? ParticleEmitter.readBoolean(bufferedReader, "active") : true;
        }

        public void load(ParticleValue particleValue) {
            this.active = particleValue.active;
            this.alwaysActive = particleValue.alwaysActive;
        }
    }

    public static class Particle
    extends Sprite {
        protected int life;
        protected int currentLife;
        protected float xScale;
        protected float xScaleDiff;
        protected float yScale;
        protected float yScaleDiff;
        protected float rotation;
        protected float rotationDiff;
        protected float velocity;
        protected float velocityDiff;
        protected float angle;
        protected float angleDiff;
        protected float angleCos;
        protected float angleSin;
        protected float transparency;
        protected float transparencyDiff;
        protected float wind;
        protected float windDiff;
        protected float gravity;
        protected float gravityDiff;
        protected float[] tint;
        protected int frame;

        public Particle(Sprite sprite) {
            super(sprite);
        }
    }
}

