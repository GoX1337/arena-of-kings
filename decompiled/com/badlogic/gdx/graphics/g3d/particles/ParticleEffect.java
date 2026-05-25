/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.particles;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g3d.particles.ParticleController;
import com.badlogic.gdx.graphics.g3d.particles.ResourceData;
import com.badlogic.gdx.graphics.g3d.particles.batches.ParticleBatch;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.BoundingBox;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import java.util.Iterator;

public class ParticleEffect
implements ResourceData.Configurable,
Disposable {
    private Array<ParticleController> controllers;
    private BoundingBox bounds;

    public ParticleEffect() {
        this.controllers = new Array(true, 3, ParticleController.class);
    }

    public ParticleEffect(ParticleEffect particleEffect) {
        this.controllers = new Array(true, particleEffect.controllers.size);
        int n2 = particleEffect.controllers.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            this.controllers.add(particleEffect.controllers.get(i2).copy());
        }
    }

    public ParticleEffect(ParticleController ... particleControllerArray) {
        this.controllers = new Array<ParticleController>(particleControllerArray);
    }

    public void init() {
        int n2 = this.controllers.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            this.controllers.get(i2).init();
        }
    }

    public void start() {
        int n2 = this.controllers.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            this.controllers.get(i2).start();
        }
    }

    public void end() {
        int n2 = this.controllers.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            this.controllers.get(i2).end();
        }
    }

    public void reset() {
        int n2 = this.controllers.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            this.controllers.get(i2).reset();
        }
    }

    public void update() {
        int n2 = this.controllers.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            this.controllers.get(i2).update();
        }
    }

    public void update(float f2) {
        int n2 = this.controllers.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            this.controllers.get(i2).update(f2);
        }
    }

    public void draw() {
        int n2 = this.controllers.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            this.controllers.get(i2).draw();
        }
    }

    public boolean isComplete() {
        int n2 = this.controllers.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (this.controllers.get(i2).isComplete()) continue;
            return false;
        }
        return true;
    }

    public void setTransform(Matrix4 matrix4) {
        int n2 = this.controllers.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            this.controllers.get(i2).setTransform(matrix4);
        }
    }

    public void rotate(Quaternion quaternion) {
        int n2 = this.controllers.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            this.controllers.get(i2).rotate(quaternion);
        }
    }

    public void rotate(Vector3 vector3, float f2) {
        int n2 = this.controllers.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            this.controllers.get(i2).rotate(vector3, f2);
        }
    }

    public void translate(Vector3 vector3) {
        int n2 = this.controllers.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            this.controllers.get(i2).translate(vector3);
        }
    }

    public void scale(float f2, float f3, float f4) {
        int n2 = this.controllers.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            this.controllers.get(i2).scale(f2, f3, f4);
        }
    }

    public void scale(Vector3 vector3) {
        int n2 = this.controllers.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            this.controllers.get(i2).scale(vector3.x, vector3.y, vector3.z);
        }
    }

    public Array<ParticleController> getControllers() {
        return this.controllers;
    }

    public ParticleController findController(String string) {
        int n2 = this.controllers.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            ParticleController particleController = this.controllers.get(i2);
            if (!particleController.name.equals(string)) continue;
            return particleController;
        }
        return null;
    }

    @Override
    public void dispose() {
        int n2 = this.controllers.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            this.controllers.get(i2).dispose();
        }
    }

    public BoundingBox getBoundingBox() {
        if (this.bounds == null) {
            this.bounds = new BoundingBox();
        }
        BoundingBox boundingBox = this.bounds;
        boundingBox.inf();
        for (ParticleController particleController : this.controllers) {
            boundingBox.ext(particleController.getBoundingBox());
        }
        return boundingBox;
    }

    public void setBatch(Array<ParticleBatch<?>> array) {
        for (ParticleController particleController : this.controllers) {
            ParticleBatch particleBatch;
            Iterator iterator = array.iterator();
            while (iterator.hasNext() && !particleController.renderer.setBatch(particleBatch = (ParticleBatch)iterator.next())) {
            }
        }
    }

    public ParticleEffect copy() {
        return new ParticleEffect(this);
    }

    public void save(AssetManager assetManager, ResourceData resourceData) {
        for (ParticleController particleController : this.controllers) {
            particleController.save(assetManager, resourceData);
        }
    }

    public void load(AssetManager assetManager, ResourceData resourceData) {
        boolean bl2 = false;
        for (ParticleController particleController : this.controllers) {
            particleController.load(assetManager, resourceData);
        }
    }
}

