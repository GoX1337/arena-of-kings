/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.particles.values;

import com.badlogic.gdx.graphics.g3d.particles.values.PrimitiveSpawnShapeValue;
import com.badlogic.gdx.graphics.g3d.particles.values.SpawnShapeValue;
import com.badlogic.gdx.math.Vector3;

public final class PointSpawnShapeValue
extends PrimitiveSpawnShapeValue {
    public PointSpawnShapeValue(PointSpawnShapeValue pointSpawnShapeValue) {
        super(pointSpawnShapeValue);
        this.load(pointSpawnShapeValue);
    }

    public PointSpawnShapeValue() {
    }

    @Override
    public void spawnAux(Vector3 vector3, float f2) {
        vector3.x = this.spawnWidth + this.spawnWidthDiff * this.spawnWidthValue.getScale(f2);
        vector3.y = this.spawnHeight + this.spawnHeightDiff * this.spawnHeightValue.getScale(f2);
        vector3.z = this.spawnDepth + this.spawnDepthDiff * this.spawnDepthValue.getScale(f2);
    }

    @Override
    public SpawnShapeValue copy() {
        return new PointSpawnShapeValue(this);
    }
}

