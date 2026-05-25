/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.particles.values;

import com.badlogic.gdx.graphics.g3d.particles.values.ParticleValue;
import com.badlogic.gdx.graphics.g3d.particles.values.PrimitiveSpawnShapeValue;
import com.badlogic.gdx.graphics.g3d.particles.values.SpawnShapeValue;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;

public final class EllipseSpawnShapeValue
extends PrimitiveSpawnShapeValue {
    PrimitiveSpawnShapeValue.SpawnSide side = PrimitiveSpawnShapeValue.SpawnSide.both;

    public EllipseSpawnShapeValue(EllipseSpawnShapeValue ellipseSpawnShapeValue) {
        super(ellipseSpawnShapeValue);
        this.load(ellipseSpawnShapeValue);
    }

    public EllipseSpawnShapeValue() {
    }

    @Override
    public void spawnAux(Vector3 vector3, float f2) {
        float f3;
        float f4;
        float f5;
        float f6 = this.spawnWidth + this.spawnWidthDiff * this.spawnWidthValue.getScale(f2);
        float f7 = this.spawnHeight + this.spawnHeightDiff * this.spawnHeightValue.getScale(f2);
        float f8 = this.spawnDepth + this.spawnDepthDiff * this.spawnDepthValue.getScale(f2);
        float f9 = 0.0f;
        float f10 = (float)Math.PI * 2;
        if (this.side == PrimitiveSpawnShapeValue.SpawnSide.top) {
            f10 = (float)Math.PI;
        } else if (this.side == PrimitiveSpawnShapeValue.SpawnSide.bottom) {
            f10 = (float)(-Math.PI);
        }
        float f11 = MathUtils.random(f9, f10);
        if (this.edges) {
            if (f6 == 0.0f) {
                vector3.set(0.0f, f7 / 2.0f * MathUtils.sin(f11), f8 / 2.0f * MathUtils.cos(f11));
                return;
            }
            if (f7 == 0.0f) {
                vector3.set(f6 / 2.0f * MathUtils.cos(f11), 0.0f, f8 / 2.0f * MathUtils.sin(f11));
                return;
            }
            if (f8 == 0.0f) {
                vector3.set(f6 / 2.0f * MathUtils.cos(f11), f7 / 2.0f * MathUtils.sin(f11), 0.0f);
                return;
            }
            f5 = f6 / 2.0f;
            f4 = f7 / 2.0f;
            f3 = f8 / 2.0f;
        } else {
            f5 = MathUtils.random(f6 / 2.0f);
            f4 = MathUtils.random(f7 / 2.0f);
            f3 = MathUtils.random(f8 / 2.0f);
        }
        float f12 = MathUtils.random(-1.0f, 1.0f);
        float f13 = (float)Math.sqrt(1.0f - f12 * f12);
        vector3.set(f5 * f13 * MathUtils.cos(f11), f4 * f13 * MathUtils.sin(f11), f3 * f12);
    }

    public PrimitiveSpawnShapeValue.SpawnSide getSide() {
        return this.side;
    }

    public void setSide(PrimitiveSpawnShapeValue.SpawnSide spawnSide) {
        this.side = spawnSide;
    }

    @Override
    public void load(ParticleValue particleValue) {
        super.load(particleValue);
        EllipseSpawnShapeValue ellipseSpawnShapeValue = (EllipseSpawnShapeValue)particleValue;
        this.side = ellipseSpawnShapeValue.side;
    }

    @Override
    public SpawnShapeValue copy() {
        return new EllipseSpawnShapeValue(this);
    }

    @Override
    public void write(Json json) {
        super.write(json);
        json.writeValue("side", (Object)this.side);
    }

    @Override
    public void read(Json json, JsonValue jsonValue) {
        super.read(json, jsonValue);
        this.side = json.readValue("side", PrimitiveSpawnShapeValue.SpawnSide.class, jsonValue);
    }
}

