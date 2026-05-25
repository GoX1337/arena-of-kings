/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.particles.batches;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.Renderable;
import com.badlogic.gdx.graphics.g3d.particles.ResourceData;
import com.badlogic.gdx.graphics.g3d.particles.batches.ParticleBatch;
import com.badlogic.gdx.graphics.g3d.particles.renderers.ModelInstanceControllerRenderData;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pool;

public class ModelInstanceParticleBatch
implements ParticleBatch<ModelInstanceControllerRenderData> {
    Array<ModelInstanceControllerRenderData> controllersRenderData = new Array(false, 5);
    int bufferedParticlesCount;

    @Override
    public void getRenderables(Array<Renderable> array, Pool<Renderable> pool) {
        for (ModelInstanceControllerRenderData modelInstanceControllerRenderData : this.controllersRenderData) {
            int n2 = modelInstanceControllerRenderData.controller.particles.size;
            for (int i2 = 0; i2 < n2; ++i2) {
                ((ModelInstance[])modelInstanceControllerRenderData.modelInstanceChannel.data)[i2].getRenderables(array, pool);
            }
        }
    }

    public int getBufferedCount() {
        return this.bufferedParticlesCount;
    }

    @Override
    public void begin() {
        this.controllersRenderData.clear();
        this.bufferedParticlesCount = 0;
    }

    @Override
    public void end() {
    }

    @Override
    public void draw(ModelInstanceControllerRenderData modelInstanceControllerRenderData) {
        this.controllersRenderData.add(modelInstanceControllerRenderData);
        this.bufferedParticlesCount += modelInstanceControllerRenderData.controller.particles.size;
    }

    @Override
    public void save(AssetManager assetManager, ResourceData resourceData) {
    }

    @Override
    public void load(AssetManager assetManager, ResourceData resourceData) {
    }
}

