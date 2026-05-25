/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.particles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g3d.particles.ParallelArray;
import com.badlogic.gdx.graphics.g3d.particles.ParticleChannels;
import com.badlogic.gdx.graphics.g3d.particles.ResourceData;
import com.badlogic.gdx.graphics.g3d.particles.emitters.Emitter;
import com.badlogic.gdx.graphics.g3d.particles.influencers.Influencer;
import com.badlogic.gdx.graphics.g3d.particles.renderers.ParticleControllerRenderer;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.BoundingBox;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.reflect.ClassReflection;

public class ParticleController
implements ResourceData.Configurable,
Json.Serializable {
    protected static final float DEFAULT_TIME_STEP = 0.016666668f;
    public String name;
    public Emitter emitter;
    public Array<Influencer> influencers;
    public ParticleControllerRenderer<?, ?> renderer;
    public ParallelArray particles;
    public ParticleChannels particleChannels;
    public Matrix4 transform = new Matrix4();
    public Vector3 scale = new Vector3(1.0f, 1.0f, 1.0f);
    protected BoundingBox boundingBox;
    public float deltaTime;
    public float deltaTimeSqr;

    public ParticleController() {
        this.influencers = new Array(true, 3, Influencer.class);
        this.setTimeStep(0.016666668f);
    }

    public ParticleController(String string, Emitter emitter, ParticleControllerRenderer<?, ?> particleControllerRenderer, Influencer ... influencerArray) {
        this();
        this.name = string;
        this.emitter = emitter;
        this.renderer = particleControllerRenderer;
        this.particleChannels = new ParticleChannels();
        this.influencers = new Array<Influencer>(influencerArray);
    }

    private void setTimeStep(float f2) {
        this.deltaTime = f2;
        this.deltaTimeSqr = this.deltaTime * this.deltaTime;
    }

    public void setTransform(Matrix4 matrix4) {
        this.transform.set(matrix4);
        matrix4.getScale(this.scale);
    }

    public void setTransform(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        this.transform.set(f2, f3, f4, f5, f6, f7, f8, f9, f9, f9);
        this.scale.set(f9, f9, f9);
    }

    public void rotate(Quaternion quaternion) {
        this.transform.rotate(quaternion);
    }

    public void rotate(Vector3 vector3, float f2) {
        this.transform.rotate(vector3, f2);
    }

    public void translate(Vector3 vector3) {
        this.transform.translate(vector3);
    }

    public void setTranslation(Vector3 vector3) {
        this.transform.setTranslation(vector3);
    }

    public void scale(float f2, float f3, float f4) {
        this.transform.scale(f2, f3, f4);
        this.transform.getScale(this.scale);
    }

    public void scale(Vector3 vector3) {
        this.scale(vector3.x, vector3.y, vector3.z);
    }

    public void mul(Matrix4 matrix4) {
        this.transform.mul(matrix4);
        this.transform.getScale(this.scale);
    }

    public void getTransform(Matrix4 matrix4) {
        matrix4.set(this.transform);
    }

    public boolean isComplete() {
        return this.emitter.isComplete();
    }

    public void init() {
        this.bind();
        if (this.particles != null) {
            this.end();
            this.particleChannels.resetIds();
        }
        this.allocateChannels(this.emitter.maxParticleCount);
        this.emitter.init();
        for (Influencer influencer : this.influencers) {
            influencer.init();
        }
        this.renderer.init();
    }

    protected void allocateChannels(int n2) {
        this.particles = new ParallelArray(n2);
        this.emitter.allocateChannels();
        for (Influencer influencer : this.influencers) {
            influencer.allocateChannels();
        }
        this.renderer.allocateChannels();
    }

    protected void bind() {
        this.emitter.set(this);
        for (Influencer influencer : this.influencers) {
            influencer.set(this);
        }
        this.renderer.set(this);
    }

    public void start() {
        this.emitter.start();
        for (Influencer influencer : this.influencers) {
            influencer.start();
        }
    }

    public void reset() {
        this.end();
        this.start();
    }

    public void end() {
        for (Influencer influencer : this.influencers) {
            influencer.end();
        }
        this.emitter.end();
    }

    public void activateParticles(int n2, int n3) {
        this.emitter.activateParticles(n2, n3);
        for (Influencer influencer : this.influencers) {
            influencer.activateParticles(n2, n3);
        }
    }

    public void killParticles(int n2, int n3) {
        this.emitter.killParticles(n2, n3);
        for (Influencer influencer : this.influencers) {
            influencer.killParticles(n2, n3);
        }
    }

    public void update() {
        this.update(Gdx.graphics.getDeltaTime());
    }

    public void update(float f2) {
        this.setTimeStep(f2);
        this.emitter.update();
        for (Influencer influencer : this.influencers) {
            influencer.update();
        }
    }

    public void draw() {
        if (this.particles.size > 0) {
            this.renderer.update();
        }
    }

    public ParticleController copy() {
        Emitter emitter = (Emitter)this.emitter.copy();
        Influencer[] influencerArray = new Influencer[this.influencers.size];
        int n2 = 0;
        for (Influencer influencer : this.influencers) {
            influencerArray[n2++] = (Influencer)influencer.copy();
        }
        return new ParticleController(new String(this.name), emitter, (ParticleControllerRenderer)this.renderer.copy(), influencerArray);
    }

    public void dispose() {
        this.emitter.dispose();
        for (Influencer influencer : this.influencers) {
            influencer.dispose();
        }
    }

    public BoundingBox getBoundingBox() {
        if (this.boundingBox == null) {
            this.boundingBox = new BoundingBox();
        }
        this.calculateBoundingBox();
        return this.boundingBox;
    }

    protected void calculateBoundingBox() {
        this.boundingBox.clr();
        ParallelArray.FloatChannel floatChannel = (ParallelArray.FloatChannel)this.particles.getChannel(ParticleChannels.Position);
        int n2 = floatChannel.strideSize * this.particles.size;
        for (int i2 = 0; i2 < n2; i2 += floatChannel.strideSize) {
            this.boundingBox.ext(floatChannel.data[i2 + 0], floatChannel.data[i2 + 1], floatChannel.data[i2 + 2]);
        }
    }

    private <K extends Influencer> int findIndex(Class<K> clazz) {
        for (int i2 = 0; i2 < this.influencers.size; ++i2) {
            Influencer influencer = this.influencers.get(i2);
            if (!ClassReflection.isAssignableFrom(clazz, influencer.getClass())) continue;
            return i2;
        }
        return -1;
    }

    public <K extends Influencer> K findInfluencer(Class<K> clazz) {
        int n2 = this.findIndex(clazz);
        return (K)(n2 > -1 ? this.influencers.get(n2) : null);
    }

    public <K extends Influencer> void removeInfluencer(Class<K> clazz) {
        int n2 = this.findIndex(clazz);
        if (n2 > -1) {
            this.influencers.removeIndex(n2);
        }
    }

    public <K extends Influencer> boolean replaceInfluencer(Class<K> clazz, K k2) {
        int n2 = this.findIndex(clazz);
        if (n2 > -1) {
            this.influencers.insert(n2, k2);
            this.influencers.removeIndex(n2 + 1);
            return true;
        }
        return false;
    }

    @Override
    public void write(Json json) {
        json.writeValue("name", this.name);
        json.writeValue("emitter", this.emitter, Emitter.class);
        json.writeValue("influencers", this.influencers, Array.class, Influencer.class);
        json.writeValue("renderer", this.renderer, ParticleControllerRenderer.class);
    }

    @Override
    public void read(Json json, JsonValue jsonValue) {
        this.name = json.readValue("name", String.class, jsonValue);
        this.emitter = json.readValue("emitter", Emitter.class, jsonValue);
        this.influencers.addAll(json.readValue("influencers", Array.class, Influencer.class, jsonValue));
        this.renderer = json.readValue("renderer", ParticleControllerRenderer.class, jsonValue);
    }

    public void save(AssetManager assetManager, ResourceData resourceData) {
        this.emitter.save(assetManager, resourceData);
        for (Influencer influencer : this.influencers) {
            influencer.save(assetManager, resourceData);
        }
        this.renderer.save(assetManager, resourceData);
    }

    public void load(AssetManager assetManager, ResourceData resourceData) {
        this.emitter.load(assetManager, resourceData);
        for (Influencer influencer : this.influencers) {
            influencer.load(assetManager, resourceData);
        }
        this.renderer.load(assetManager, resourceData);
    }
}

