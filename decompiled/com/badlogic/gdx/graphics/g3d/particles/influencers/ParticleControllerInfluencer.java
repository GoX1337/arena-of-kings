/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.particles.influencers;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g3d.particles.ParallelArray;
import com.badlogic.gdx.graphics.g3d.particles.ParticleChannels;
import com.badlogic.gdx.graphics.g3d.particles.ParticleController;
import com.badlogic.gdx.graphics.g3d.particles.ParticleEffect;
import com.badlogic.gdx.graphics.g3d.particles.ResourceData;
import com.badlogic.gdx.graphics.g3d.particles.influencers.Influencer;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.IntArray;
import com.badlogic.gdx.utils.Pool;
import java.util.Iterator;

public abstract class ParticleControllerInfluencer
extends Influencer {
    public Array<ParticleController> templates;
    ParallelArray.ObjectChannel<ParticleController> particleControllerChannel;

    public ParticleControllerInfluencer() {
        this.templates = new Array(true, 1, ParticleController.class);
    }

    public ParticleControllerInfluencer(ParticleController ... particleControllerArray) {
        this.templates = new Array<ParticleController>(particleControllerArray);
    }

    public ParticleControllerInfluencer(ParticleControllerInfluencer particleControllerInfluencer) {
        this((ParticleController[])particleControllerInfluencer.templates.items);
    }

    @Override
    public void allocateChannels() {
        this.particleControllerChannel = (ParallelArray.ObjectChannel)this.controller.particles.addChannel(ParticleChannels.ParticleController);
    }

    @Override
    public void end() {
        for (int i2 = 0; i2 < this.controller.particles.size; ++i2) {
            ((ParticleController[])this.particleControllerChannel.data)[i2].end();
        }
    }

    @Override
    public void dispose() {
        if (this.controller != null) {
            for (int i2 = 0; i2 < this.controller.particles.size; ++i2) {
                ParticleController particleController = ((ParticleController[])this.particleControllerChannel.data)[i2];
                if (particleController == null) continue;
                particleController.dispose();
                ((ParticleController[])this.particleControllerChannel.data)[i2] = null;
            }
        }
    }

    @Override
    public void save(AssetManager assetManager, ResourceData resourceData) {
        ResourceData.SaveData saveData = resourceData.createSaveData();
        Array<ParticleEffect> array = assetManager.getAll(ParticleEffect.class, new Array());
        Array<ParticleController> array2 = new Array<ParticleController>(this.templates);
        Array<IntArray> array3 = new Array<IntArray>();
        for (int i2 = 0; i2 < array.size && array2.size > 0; ++i2) {
            ParticleEffect particleEffect = array.get(i2);
            Array<ParticleController> array4 = particleEffect.getControllers();
            Iterator iterator = array2.iterator();
            IntArray intArray = null;
            while (iterator.hasNext()) {
                ParticleController particleController = (ParticleController)iterator.next();
                int n2 = -1;
                n2 = array4.indexOf(particleController, true);
                if (n2 <= -1) continue;
                if (intArray == null) {
                    intArray = new IntArray();
                }
                iterator.remove();
                intArray.add(n2);
            }
            if (intArray == null) continue;
            saveData.saveAsset(assetManager.getAssetFileName(particleEffect), ParticleEffect.class);
            array3.add(intArray);
        }
        saveData.save("indices", array3);
    }

    @Override
    public void load(AssetManager assetManager, ResourceData resourceData) {
        AssetDescriptor assetDescriptor;
        ResourceData.SaveData saveData = resourceData.getSaveData();
        Array array = (Array)saveData.load("indices");
        Iterator iterator = array.iterator();
        while ((assetDescriptor = saveData.loadAsset()) != null) {
            ParticleEffect particleEffect = (ParticleEffect)assetManager.get(assetDescriptor);
            if (particleEffect == null) {
                throw new RuntimeException("Template is null");
            }
            Array<ParticleController> array2 = particleEffect.getControllers();
            IntArray intArray = (IntArray)iterator.next();
            int n2 = intArray.size;
            for (int i2 = 0; i2 < n2; ++i2) {
                this.templates.add(array2.get(intArray.get(i2)));
            }
        }
    }

    public static class Random
    extends ParticleControllerInfluencer {
        ParticleControllerPool pool = new ParticleControllerPool();

        public Random() {
        }

        public Random(ParticleController ... particleControllerArray) {
            super(particleControllerArray);
        }

        public Random(Random random) {
            super(random);
        }

        @Override
        public void init() {
            this.pool.clear();
            for (int i2 = 0; i2 < this.controller.emitter.maxParticleCount; ++i2) {
                this.pool.free(this.pool.newObject());
            }
        }

        @Override
        public void dispose() {
            this.pool.clear();
            super.dispose();
        }

        @Override
        public void activateParticles(int n2, int n3) {
            int n4 = n2 + n3;
            for (int i2 = n2; i2 < n4; ++i2) {
                ParticleController particleController = (ParticleController)this.pool.obtain();
                particleController.start();
                ((ParticleController[])this.particleControllerChannel.data)[i2] = particleController;
            }
        }

        @Override
        public void killParticles(int n2, int n3) {
            int n4 = n2 + n3;
            for (int i2 = n2; i2 < n4; ++i2) {
                ParticleController particleController = ((ParticleController[])this.particleControllerChannel.data)[i2];
                particleController.end();
                this.pool.free(particleController);
                ((ParticleController[])this.particleControllerChannel.data)[i2] = null;
            }
        }

        @Override
        public Random copy() {
            return new Random(this);
        }

        class ParticleControllerPool
        extends Pool<ParticleController> {
            @Override
            public ParticleController newObject() {
                ParticleController particleController = ((ParticleController)Random.this.templates.random()).copy();
                particleController.init();
                return particleController;
            }

            @Override
            public void clear() {
                int n2 = Random.this.pool.getFree();
                for (int i2 = 0; i2 < n2; ++i2) {
                    ((ParticleController)Random.this.pool.obtain()).dispose();
                }
                super.clear();
            }
        }
    }

    public static class Single
    extends ParticleControllerInfluencer {
        public Single(ParticleController ... particleControllerArray) {
            super(particleControllerArray);
        }

        public Single() {
        }

        public Single(Single single) {
            super(single);
        }

        @Override
        public void init() {
            ParticleController particleController = (ParticleController)this.templates.first();
            int n2 = this.controller.particles.capacity;
            for (int i2 = 0; i2 < n2; ++i2) {
                ParticleController particleController2 = particleController.copy();
                particleController2.init();
                ((ParticleController[])this.particleControllerChannel.data)[i2] = particleController2;
            }
        }

        @Override
        public void activateParticles(int n2, int n3) {
            int n4 = n2 + n3;
            for (int i2 = n2; i2 < n4; ++i2) {
                ((ParticleController[])this.particleControllerChannel.data)[i2].start();
            }
        }

        @Override
        public void killParticles(int n2, int n3) {
            int n4 = n2 + n3;
            for (int i2 = n2; i2 < n4; ++i2) {
                ((ParticleController[])this.particleControllerChannel.data)[i2].end();
            }
        }

        @Override
        public Single copy() {
            return new Single(this);
        }
    }
}

