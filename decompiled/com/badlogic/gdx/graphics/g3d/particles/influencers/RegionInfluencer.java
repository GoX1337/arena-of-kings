/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.particles.influencers;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g3d.particles.ParallelArray;
import com.badlogic.gdx.graphics.g3d.particles.ParticleChannels;
import com.badlogic.gdx.graphics.g3d.particles.ResourceData;
import com.badlogic.gdx.graphics.g3d.particles.influencers.Influencer;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;

public abstract class RegionInfluencer
extends Influencer {
    public Array<AspectTextureRegion> regions;
    ParallelArray.FloatChannel regionChannel;
    public String atlasName;
    private static final String ASSET_DATA = "atlasAssetData";

    public RegionInfluencer(int n2) {
        this.regions = new Array(false, n2, AspectTextureRegion.class);
    }

    public RegionInfluencer() {
        this(1);
        AspectTextureRegion aspectTextureRegion = new AspectTextureRegion();
        aspectTextureRegion.v = 0.0f;
        aspectTextureRegion.u = 0.0f;
        aspectTextureRegion.v2 = 1.0f;
        aspectTextureRegion.u2 = 1.0f;
        aspectTextureRegion.halfInvAspectRatio = 0.5f;
        this.regions.add(aspectTextureRegion);
    }

    public RegionInfluencer(TextureRegion ... textureRegionArray) {
        this.setAtlasName(null);
        this.regions = new Array(false, textureRegionArray.length, AspectTextureRegion.class);
        this.add(textureRegionArray);
    }

    public RegionInfluencer(Texture texture) {
        this(new TextureRegion(texture));
    }

    public RegionInfluencer(RegionInfluencer regionInfluencer) {
        this(regionInfluencer.regions.size);
        this.regions.ensureCapacity(regionInfluencer.regions.size);
        for (int i2 = 0; i2 < regionInfluencer.regions.size; ++i2) {
            this.regions.add(new AspectTextureRegion(regionInfluencer.regions.get(i2)));
        }
    }

    public void setAtlasName(String string) {
        this.atlasName = string;
    }

    public void add(TextureRegion ... textureRegionArray) {
        this.regions.ensureCapacity(textureRegionArray.length);
        for (TextureRegion textureRegion : textureRegionArray) {
            this.regions.add(new AspectTextureRegion(textureRegion));
        }
    }

    public void clear() {
        this.atlasName = null;
        this.regions.clear();
    }

    @Override
    public void load(AssetManager assetManager, ResourceData resourceData) {
        super.load(assetManager, resourceData);
        ResourceData.SaveData saveData = resourceData.getSaveData(ASSET_DATA);
        if (saveData == null) {
            return;
        }
        TextureAtlas textureAtlas = (TextureAtlas)assetManager.get(saveData.loadAsset());
        for (AspectTextureRegion aspectTextureRegion : this.regions) {
            aspectTextureRegion.updateUV(textureAtlas);
        }
    }

    @Override
    public void save(AssetManager assetManager, ResourceData resourceData) {
        super.save(assetManager, resourceData);
        if (this.atlasName != null) {
            ResourceData.SaveData saveData = resourceData.getSaveData(ASSET_DATA);
            if (saveData == null) {
                saveData = resourceData.createSaveData(ASSET_DATA);
            }
            saveData.saveAsset(this.atlasName, TextureAtlas.class);
        }
    }

    @Override
    public void allocateChannels() {
        this.regionChannel = (ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.TextureRegion);
    }

    @Override
    public void write(Json json) {
        json.writeValue("regions", this.regions, Array.class, AspectTextureRegion.class);
    }

    @Override
    public void read(Json json, JsonValue jsonValue) {
        this.regions.clear();
        this.regions.addAll(json.readValue("regions", Array.class, AspectTextureRegion.class, jsonValue));
    }

    public static class AspectTextureRegion {
        public float u;
        public float v;
        public float u2;
        public float v2;
        public float halfInvAspectRatio;
        public String imageName;

        public AspectTextureRegion() {
        }

        public AspectTextureRegion(AspectTextureRegion aspectTextureRegion) {
            this.set(aspectTextureRegion);
        }

        public AspectTextureRegion(TextureRegion textureRegion) {
            this.set(textureRegion);
        }

        public void set(TextureRegion textureRegion) {
            this.u = textureRegion.getU();
            this.v = textureRegion.getV();
            this.u2 = textureRegion.getU2();
            this.v2 = textureRegion.getV2();
            this.halfInvAspectRatio = 0.5f * ((float)textureRegion.getRegionHeight() / (float)textureRegion.getRegionWidth());
            if (textureRegion instanceof TextureAtlas.AtlasRegion) {
                this.imageName = ((TextureAtlas.AtlasRegion)textureRegion).name;
            }
        }

        public void set(AspectTextureRegion aspectTextureRegion) {
            this.u = aspectTextureRegion.u;
            this.v = aspectTextureRegion.v;
            this.u2 = aspectTextureRegion.u2;
            this.v2 = aspectTextureRegion.v2;
            this.halfInvAspectRatio = aspectTextureRegion.halfInvAspectRatio;
            this.imageName = aspectTextureRegion.imageName;
        }

        public void updateUV(TextureAtlas textureAtlas) {
            if (this.imageName == null) {
                return;
            }
            TextureAtlas.AtlasRegion atlasRegion = textureAtlas.findRegion(this.imageName);
            this.u = atlasRegion.getU();
            this.v = atlasRegion.getV();
            this.u2 = atlasRegion.getU2();
            this.v2 = atlasRegion.getV2();
            this.halfInvAspectRatio = 0.5f * ((float)atlasRegion.getRegionHeight() / (float)atlasRegion.getRegionWidth());
        }
    }

    public static class Animated
    extends RegionInfluencer {
        ParallelArray.FloatChannel lifeChannel;

        public Animated() {
        }

        public Animated(Animated animated) {
            super(animated);
        }

        public Animated(TextureRegion textureRegion) {
            super(textureRegion);
        }

        public Animated(Texture texture) {
            super(texture);
        }

        @Override
        public void allocateChannels() {
            super.allocateChannels();
            this.lifeChannel = (ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.Life);
        }

        @Override
        public void update() {
            int n2 = 0;
            int n3 = 2;
            int n4 = this.controller.particles.size * this.regionChannel.strideSize;
            while (n2 < n4) {
                AspectTextureRegion aspectTextureRegion = (AspectTextureRegion)this.regions.get((int)(this.lifeChannel.data[n3] * (float)(this.regions.size - 1)));
                this.regionChannel.data[n2 + 0] = aspectTextureRegion.u;
                this.regionChannel.data[n2 + 1] = aspectTextureRegion.v;
                this.regionChannel.data[n2 + 2] = aspectTextureRegion.u2;
                this.regionChannel.data[n2 + 3] = aspectTextureRegion.v2;
                this.regionChannel.data[n2 + 4] = 0.5f;
                this.regionChannel.data[n2 + 5] = aspectTextureRegion.halfInvAspectRatio;
                n2 += this.regionChannel.strideSize;
                n3 += this.lifeChannel.strideSize;
            }
        }

        @Override
        public Animated copy() {
            return new Animated(this);
        }
    }

    public static class Random
    extends RegionInfluencer {
        public Random() {
        }

        public Random(Random random) {
            super(random);
        }

        public Random(TextureRegion textureRegion) {
            super(textureRegion);
        }

        public Random(Texture texture) {
            super(texture);
        }

        @Override
        public void activateParticles(int n2, int n3) {
            int n4;
            int n5 = n4 + n3 * this.regionChannel.strideSize;
            for (n4 = n2 * this.regionChannel.strideSize; n4 < n5; n4 += this.regionChannel.strideSize) {
                AspectTextureRegion aspectTextureRegion = (AspectTextureRegion)this.regions.random();
                this.regionChannel.data[n4 + 0] = aspectTextureRegion.u;
                this.regionChannel.data[n4 + 1] = aspectTextureRegion.v;
                this.regionChannel.data[n4 + 2] = aspectTextureRegion.u2;
                this.regionChannel.data[n4 + 3] = aspectTextureRegion.v2;
                this.regionChannel.data[n4 + 4] = 0.5f;
                this.regionChannel.data[n4 + 5] = aspectTextureRegion.halfInvAspectRatio;
            }
        }

        @Override
        public Random copy() {
            return new Random(this);
        }
    }

    public static class Single
    extends RegionInfluencer {
        public Single() {
        }

        public Single(Single single) {
            super(single);
        }

        public Single(TextureRegion textureRegion) {
            super(textureRegion);
        }

        public Single(Texture texture) {
            super(texture);
        }

        @Override
        public void init() {
            AspectTextureRegion aspectTextureRegion = ((AspectTextureRegion[])this.regions.items)[0];
            int n2 = this.controller.emitter.maxParticleCount * this.regionChannel.strideSize;
            for (int i2 = 0; i2 < n2; i2 += this.regionChannel.strideSize) {
                this.regionChannel.data[i2 + 0] = aspectTextureRegion.u;
                this.regionChannel.data[i2 + 1] = aspectTextureRegion.v;
                this.regionChannel.data[i2 + 2] = aspectTextureRegion.u2;
                this.regionChannel.data[i2 + 3] = aspectTextureRegion.v2;
                this.regionChannel.data[i2 + 4] = 0.5f;
                this.regionChannel.data[i2 + 5] = aspectTextureRegion.halfInvAspectRatio;
            }
        }

        @Override
        public Single copy() {
            return new Single(this);
        }
    }
}

