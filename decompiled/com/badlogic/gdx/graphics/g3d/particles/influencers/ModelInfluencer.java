/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.particles.influencers;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.particles.ParallelArray;
import com.badlogic.gdx.graphics.g3d.particles.ParticleChannels;
import com.badlogic.gdx.graphics.g3d.particles.ResourceData;
import com.badlogic.gdx.graphics.g3d.particles.influencers.Influencer;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pool;

public abstract class ModelInfluencer
extends Influencer {
    public Array<Model> models;
    ParallelArray.ObjectChannel<ModelInstance> modelChannel;

    public ModelInfluencer() {
        this.models = new Array(true, 1, Model.class);
    }

    public ModelInfluencer(Model ... modelArray) {
        this.models = new Array<Model>(modelArray);
    }

    public ModelInfluencer(ModelInfluencer modelInfluencer) {
        this(modelInfluencer.models.toArray(Model.class));
    }

    @Override
    public void allocateChannels() {
        this.modelChannel = (ParallelArray.ObjectChannel)this.controller.particles.addChannel(ParticleChannels.ModelInstance);
    }

    @Override
    public void save(AssetManager assetManager, ResourceData resourceData) {
        ResourceData.SaveData saveData = resourceData.createSaveData();
        for (Model model : this.models) {
            saveData.saveAsset(assetManager.getAssetFileName(model), Model.class);
        }
    }

    @Override
    public void load(AssetManager assetManager, ResourceData resourceData) {
        AssetDescriptor assetDescriptor;
        ResourceData.SaveData saveData = resourceData.getSaveData();
        while ((assetDescriptor = saveData.loadAsset()) != null) {
            Model model = (Model)assetManager.get(assetDescriptor);
            if (model == null) {
                throw new RuntimeException("Model is null");
            }
            this.models.add(model);
        }
    }

    public static class Random
    extends ModelInfluencer {
        ModelInstancePool pool = new ModelInstancePool();

        public Random() {
        }

        public Random(Random random) {
            super(random);
        }

        public Random(Model ... modelArray) {
            super(modelArray);
        }

        @Override
        public void init() {
            this.pool.clear();
        }

        @Override
        public void activateParticles(int n2, int n3) {
            int n4 = n2 + n3;
            for (int i2 = n2; i2 < n4; ++i2) {
                ((ModelInstance[])this.modelChannel.data)[i2] = (ModelInstance)this.pool.obtain();
            }
        }

        @Override
        public void killParticles(int n2, int n3) {
            int n4 = n2 + n3;
            for (int i2 = n2; i2 < n4; ++i2) {
                this.pool.free(((ModelInstance[])this.modelChannel.data)[i2]);
                ((ModelInstance[])this.modelChannel.data)[i2] = null;
            }
        }

        @Override
        public Random copy() {
            return new Random(this);
        }

        class ModelInstancePool
        extends Pool<ModelInstance> {
            @Override
            public ModelInstance newObject() {
                return new ModelInstance((Model)Random.this.models.random());
            }
        }
    }

    public static class Single
    extends ModelInfluencer {
        public Single() {
        }

        public Single(Single single) {
            super(single);
        }

        public Single(Model ... modelArray) {
            super(modelArray);
        }

        @Override
        public void init() {
            Model model = (Model)this.models.first();
            int n2 = this.controller.emitter.maxParticleCount;
            for (int i2 = 0; i2 < n2; ++i2) {
                ((ModelInstance[])this.modelChannel.data)[i2] = new ModelInstance(model);
            }
        }

        @Override
        public Single copy() {
            return new Single(this);
        }
    }
}

