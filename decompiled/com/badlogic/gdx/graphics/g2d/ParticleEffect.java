/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g2d;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.ParticleEmitter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.collision.BoundingBox;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.ObjectMap;
import com.badlogic.gdx.utils.StreamUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Writer;

public class ParticleEffect
implements Disposable {
    private final Array<ParticleEmitter> emitters;
    private BoundingBox bounds;
    private boolean ownsTexture;
    protected float xSizeScale = 1.0f;
    protected float ySizeScale = 1.0f;
    protected float motionScale = 1.0f;

    public ParticleEffect() {
        this.emitters = new Array(8);
    }

    public ParticleEffect(ParticleEffect particleEffect) {
        this.emitters = new Array(true, particleEffect.emitters.size);
        int n2 = particleEffect.emitters.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            this.emitters.add(this.newEmitter(particleEffect.emitters.get(i2)));
        }
    }

    public void start() {
        int n2 = this.emitters.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            this.emitters.get(i2).start();
        }
    }

    public void reset() {
        this.reset(true);
    }

    public void reset(boolean bl2) {
        int n2 = this.emitters.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            this.emitters.get(i2).reset();
        }
        if (bl2 && (this.xSizeScale != 1.0f || this.ySizeScale != 1.0f || this.motionScale != 1.0f)) {
            this.scaleEffect(1.0f / this.xSizeScale, 1.0f / this.ySizeScale, 1.0f / this.motionScale);
            this.motionScale = 1.0f;
            this.ySizeScale = 1.0f;
            this.xSizeScale = 1.0f;
        }
    }

    public void update(float f2) {
        int n2 = this.emitters.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            this.emitters.get(i2).update(f2);
        }
    }

    public void draw(Batch batch) {
        int n2 = this.emitters.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            this.emitters.get(i2).draw(batch);
        }
    }

    public void draw(Batch batch, float f2) {
        int n2 = this.emitters.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            this.emitters.get(i2).draw(batch, f2);
        }
    }

    public void allowCompletion() {
        int n2 = this.emitters.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            this.emitters.get(i2).allowCompletion();
        }
    }

    public boolean isComplete() {
        int n2 = this.emitters.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            ParticleEmitter particleEmitter = this.emitters.get(i2);
            if (particleEmitter.isComplete()) continue;
            return false;
        }
        return true;
    }

    public void setDuration(int n2) {
        int n3 = this.emitters.size;
        for (int i2 = 0; i2 < n3; ++i2) {
            ParticleEmitter particleEmitter = this.emitters.get(i2);
            particleEmitter.setContinuous(false);
            particleEmitter.duration = n2;
            particleEmitter.durationTimer = 0.0f;
        }
    }

    public void setPosition(float f2, float f3) {
        int n2 = this.emitters.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            this.emitters.get(i2).setPosition(f2, f3);
        }
    }

    public void setFlip(boolean bl2, boolean bl3) {
        int n2 = this.emitters.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            this.emitters.get(i2).setFlip(bl2, bl3);
        }
    }

    public void flipY() {
        int n2 = this.emitters.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            this.emitters.get(i2).flipY();
        }
    }

    public Array<ParticleEmitter> getEmitters() {
        return this.emitters;
    }

    public ParticleEmitter findEmitter(String string) {
        int n2 = this.emitters.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            ParticleEmitter particleEmitter = this.emitters.get(i2);
            if (!particleEmitter.getName().equals(string)) continue;
            return particleEmitter;
        }
        return null;
    }

    public void preAllocateParticles() {
        for (ParticleEmitter particleEmitter : this.emitters) {
            particleEmitter.preAllocateParticles();
        }
    }

    public void save(Writer writer) {
        int n2 = 0;
        int n3 = this.emitters.size;
        for (int i2 = 0; i2 < n3; ++i2) {
            ParticleEmitter particleEmitter = this.emitters.get(i2);
            if (n2++ > 0) {
                writer.write("\n");
            }
            particleEmitter.save(writer);
        }
    }

    public void load(FileHandle fileHandle, FileHandle fileHandle2) {
        this.loadEmitters(fileHandle);
        this.loadEmitterImages(fileHandle2);
    }

    public void load(FileHandle fileHandle, TextureAtlas textureAtlas) {
        this.load(fileHandle, textureAtlas, null);
    }

    public void load(FileHandle fileHandle, TextureAtlas textureAtlas, String string) {
        this.loadEmitters(fileHandle);
        this.loadEmitterImages(textureAtlas, string);
    }

    public void loadEmitters(FileHandle fileHandle) {
        InputStream inputStream = fileHandle.read();
        this.emitters.clear();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream), 512);
            do {
                ParticleEmitter particleEmitter = this.newEmitter(bufferedReader);
                this.emitters.add(particleEmitter);
            } while (bufferedReader.readLine() != null);
        }
        catch (IOException iOException) {
            try {
                throw new GdxRuntimeException("Error loading effect: " + fileHandle, iOException);
            }
            catch (Throwable throwable) {
                StreamUtils.closeQuietly(bufferedReader);
                throw throwable;
            }
        }
        StreamUtils.closeQuietly(bufferedReader);
    }

    public void loadEmitterImages(TextureAtlas textureAtlas) {
        this.loadEmitterImages(textureAtlas, null);
    }

    public void loadEmitterImages(TextureAtlas textureAtlas, String string) {
        int n2 = this.emitters.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            ParticleEmitter particleEmitter = this.emitters.get(i2);
            if (particleEmitter.getImagePaths().size == 0) continue;
            Array<Sprite> array = new Array<Sprite>();
            for (String string2 : particleEmitter.getImagePaths()) {
                Sprite sprite;
                String string3 = new File(string2.replace('\\', '/')).getName();
                int n3 = string3.lastIndexOf(46);
                if (n3 != -1) {
                    string3 = string3.substring(0, n3);
                }
                if (string != null) {
                    string3 = string + string3;
                }
                if ((sprite = textureAtlas.createSprite(string3)) == null) {
                    throw new IllegalArgumentException("SpriteSheet missing image: " + string3);
                }
                array.add(sprite);
            }
            particleEmitter.setSprites(array);
        }
    }

    public void loadEmitterImages(FileHandle fileHandle) {
        this.ownsTexture = true;
        ObjectMap<String, Sprite> objectMap = new ObjectMap<String, Sprite>(this.emitters.size);
        int n2 = this.emitters.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            ParticleEmitter particleEmitter = this.emitters.get(i2);
            if (particleEmitter.getImagePaths().size == 0) continue;
            Array<Sprite> array = new Array<Sprite>();
            for (String string : particleEmitter.getImagePaths()) {
                String string2 = new File(string.replace('\\', '/')).getName();
                Sprite sprite = (Sprite)objectMap.get(string2);
                if (sprite == null) {
                    sprite = new Sprite(this.loadTexture(fileHandle.child(string2)));
                    objectMap.put(string2, sprite);
                }
                array.add(sprite);
            }
            particleEmitter.setSprites(array);
        }
    }

    protected ParticleEmitter newEmitter(BufferedReader bufferedReader) {
        return new ParticleEmitter(bufferedReader);
    }

    protected ParticleEmitter newEmitter(ParticleEmitter particleEmitter) {
        return new ParticleEmitter(particleEmitter);
    }

    protected Texture loadTexture(FileHandle fileHandle) {
        return new Texture(fileHandle, false);
    }

    @Override
    public void dispose() {
        if (!this.ownsTexture) {
            return;
        }
        int n2 = this.emitters.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            ParticleEmitter particleEmitter = this.emitters.get(i2);
            for (Sprite sprite : particleEmitter.getSprites()) {
                sprite.getTexture().dispose();
            }
        }
    }

    public BoundingBox getBoundingBox() {
        if (this.bounds == null) {
            this.bounds = new BoundingBox();
        }
        BoundingBox boundingBox = this.bounds;
        boundingBox.inf();
        for (ParticleEmitter particleEmitter : this.emitters) {
            boundingBox.ext(particleEmitter.getBoundingBox());
        }
        return boundingBox;
    }

    public void scaleEffect(float f2) {
        this.scaleEffect(f2, f2, f2);
    }

    public void scaleEffect(float f2, float f3) {
        this.scaleEffect(f2, f2, f3);
    }

    public void scaleEffect(float f2, float f3, float f4) {
        this.xSizeScale *= f2;
        this.ySizeScale *= f3;
        this.motionScale *= f4;
        for (ParticleEmitter particleEmitter : this.emitters) {
            particleEmitter.scaleSize(f2, f3);
            particleEmitter.scaleMotion(f4);
        }
    }

    public void setEmittersCleanUpBlendFunction(boolean bl2) {
        int n2 = this.emitters.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            this.emitters.get(i2).setCleansUpBlendFunction(bl2);
        }
    }
}

