/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.particles.influencers;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g3d.particles.ParallelArray;
import com.badlogic.gdx.graphics.g3d.particles.ParticleChannels;
import com.badlogic.gdx.graphics.g3d.particles.ResourceData;
import com.badlogic.gdx.graphics.g3d.particles.influencers.Influencer;
import com.badlogic.gdx.graphics.g3d.particles.values.PointSpawnShapeValue;
import com.badlogic.gdx.graphics.g3d.particles.values.SpawnShapeValue;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;

public class SpawnInfluencer
extends Influencer {
    public SpawnShapeValue spawnShapeValue;
    ParallelArray.FloatChannel positionChannel;
    ParallelArray.FloatChannel rotationChannel;

    public SpawnInfluencer() {
        this.spawnShapeValue = new PointSpawnShapeValue();
    }

    public SpawnInfluencer(SpawnShapeValue spawnShapeValue) {
        this.spawnShapeValue = spawnShapeValue;
    }

    public SpawnInfluencer(SpawnInfluencer spawnInfluencer) {
        this.spawnShapeValue = spawnInfluencer.spawnShapeValue.copy();
    }

    @Override
    public void init() {
        this.spawnShapeValue.init();
    }

    @Override
    public void allocateChannels() {
        this.positionChannel = (ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.Position);
        this.rotationChannel = (ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.Rotation3D);
    }

    @Override
    public void start() {
        this.spawnShapeValue.start();
    }

    @Override
    public void activateParticles(int n2, int n3) {
        int n4;
        int n5 = n4 + n3 * this.positionChannel.strideSize;
        for (n4 = n2 * this.positionChannel.strideSize; n4 < n5; n4 += this.positionChannel.strideSize) {
            this.spawnShapeValue.spawn(TMP_V1, this.controller.emitter.percent);
            TMP_V1.mul(this.controller.transform);
            this.positionChannel.data[n4 + 0] = SpawnInfluencer.TMP_V1.x;
            this.positionChannel.data[n4 + 1] = SpawnInfluencer.TMP_V1.y;
            this.positionChannel.data[n4 + 2] = SpawnInfluencer.TMP_V1.z;
        }
        n5 = n4 + n3 * this.rotationChannel.strideSize;
        for (n4 = n2 * this.rotationChannel.strideSize; n4 < n5; n4 += this.rotationChannel.strideSize) {
            this.controller.transform.getRotation(TMP_Q, true);
            this.rotationChannel.data[n4 + 0] = SpawnInfluencer.TMP_Q.x;
            this.rotationChannel.data[n4 + 1] = SpawnInfluencer.TMP_Q.y;
            this.rotationChannel.data[n4 + 2] = SpawnInfluencer.TMP_Q.z;
            this.rotationChannel.data[n4 + 3] = SpawnInfluencer.TMP_Q.w;
        }
    }

    @Override
    public SpawnInfluencer copy() {
        return new SpawnInfluencer(this);
    }

    @Override
    public void write(Json json) {
        json.writeValue("spawnShape", this.spawnShapeValue, SpawnShapeValue.class);
    }

    @Override
    public void read(Json json, JsonValue jsonValue) {
        this.spawnShapeValue = json.readValue("spawnShape", SpawnShapeValue.class, jsonValue);
    }

    @Override
    public void save(AssetManager assetManager, ResourceData resourceData) {
        this.spawnShapeValue.save(assetManager, resourceData);
    }

    @Override
    public void load(AssetManager assetManager, ResourceData resourceData) {
        this.spawnShapeValue.load(assetManager, resourceData);
    }
}

