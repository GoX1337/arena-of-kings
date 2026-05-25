/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.particles.values;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g3d.particles.ResourceData;
import com.badlogic.gdx.graphics.g3d.particles.values.ParticleValue;
import com.badlogic.gdx.graphics.g3d.particles.values.RangedNumericValue;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;

public abstract class SpawnShapeValue
extends ParticleValue
implements ResourceData.Configurable,
Json.Serializable {
    public RangedNumericValue xOffsetValue = new RangedNumericValue();
    public RangedNumericValue yOffsetValue = new RangedNumericValue();
    public RangedNumericValue zOffsetValue = new RangedNumericValue();

    public SpawnShapeValue() {
    }

    public SpawnShapeValue(SpawnShapeValue spawnShapeValue) {
        this();
    }

    public abstract void spawnAux(Vector3 var1, float var2);

    public final Vector3 spawn(Vector3 vector3, float f2) {
        this.spawnAux(vector3, f2);
        if (this.xOffsetValue.active) {
            vector3.x += this.xOffsetValue.newLowValue();
        }
        if (this.yOffsetValue.active) {
            vector3.y += this.yOffsetValue.newLowValue();
        }
        if (this.zOffsetValue.active) {
            vector3.z += this.zOffsetValue.newLowValue();
        }
        return vector3;
    }

    public void init() {
    }

    public void start() {
    }

    @Override
    public void load(ParticleValue particleValue) {
        super.load(particleValue);
        SpawnShapeValue spawnShapeValue = (SpawnShapeValue)particleValue;
        this.xOffsetValue.load(spawnShapeValue.xOffsetValue);
        this.yOffsetValue.load(spawnShapeValue.yOffsetValue);
        this.zOffsetValue.load(spawnShapeValue.zOffsetValue);
    }

    public abstract SpawnShapeValue copy();

    @Override
    public void write(Json json) {
        super.write(json);
        json.writeValue("xOffsetValue", this.xOffsetValue);
        json.writeValue("yOffsetValue", this.yOffsetValue);
        json.writeValue("zOffsetValue", this.zOffsetValue);
    }

    @Override
    public void read(Json json, JsonValue jsonValue) {
        super.read(json, jsonValue);
        this.xOffsetValue = json.readValue("xOffsetValue", RangedNumericValue.class, jsonValue);
        this.yOffsetValue = json.readValue("yOffsetValue", RangedNumericValue.class, jsonValue);
        this.zOffsetValue = json.readValue("zOffsetValue", RangedNumericValue.class, jsonValue);
    }

    public void save(AssetManager assetManager, ResourceData resourceData) {
    }

    public void load(AssetManager assetManager, ResourceData resourceData) {
    }
}

