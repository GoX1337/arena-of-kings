/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.particles.values;

import com.badlogic.gdx.graphics.g3d.particles.values.PrimitiveSpawnShapeValue;
import com.badlogic.gdx.graphics.g3d.particles.values.SpawnShapeValue;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;

public final class CylinderSpawnShapeValue
extends PrimitiveSpawnShapeValue {
    public CylinderSpawnShapeValue(CylinderSpawnShapeValue cylinderSpawnShapeValue) {
        super(cylinderSpawnShapeValue);
        this.load(cylinderSpawnShapeValue);
    }

    public CylinderSpawnShapeValue() {
    }

    @Override
    public void spawnAux(Vector3 vector3, float f2) {
        boolean bl2;
        float f3;
        float f4;
        float f5 = this.spawnWidth + this.spawnWidthDiff * this.spawnWidthValue.getScale(f2);
        float f6 = this.spawnHeight + this.spawnHeightDiff * this.spawnHeightValue.getScale(f2);
        float f7 = this.spawnDepth + this.spawnDepthDiff * this.spawnDepthValue.getScale(f2);
        float f8 = f6 / 2.0f;
        float f9 = MathUtils.random(f6) - f8;
        if (this.edges) {
            f4 = f5 / 2.0f;
            f3 = f7 / 2.0f;
        } else {
            f4 = MathUtils.random(f5) / 2.0f;
            f3 = MathUtils.random(f7) / 2.0f;
        }
        float f10 = 0.0f;
        boolean bl3 = f4 == 0.0f;
        boolean bl4 = bl2 = f3 == 0.0f;
        if (!bl3 && !bl2) {
            f10 = MathUtils.random(360.0f);
        } else if (bl3) {
            f10 = MathUtils.random(1) == 0 ? -90.0f : 90.0f;
        } else if (bl2) {
            f10 = MathUtils.random(1) == 0 ? 0.0f : 180.0f;
        }
        vector3.set(f4 * MathUtils.cosDeg(f10), f9, f3 * MathUtils.sinDeg(f10));
    }

    @Override
    public SpawnShapeValue copy() {
        return new CylinderSpawnShapeValue(this);
    }
}

