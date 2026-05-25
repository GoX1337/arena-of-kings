/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.particles.values;

import com.badlogic.gdx.graphics.g3d.particles.values.PrimitiveSpawnShapeValue;
import com.badlogic.gdx.graphics.g3d.particles.values.SpawnShapeValue;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;

public final class LineSpawnShapeValue
extends PrimitiveSpawnShapeValue {
    public LineSpawnShapeValue(LineSpawnShapeValue lineSpawnShapeValue) {
        super(lineSpawnShapeValue);
        this.load(lineSpawnShapeValue);
    }

    public LineSpawnShapeValue() {
    }

    @Override
    public void spawnAux(Vector3 vector3, float f2) {
        float f3 = this.spawnWidth + this.spawnWidthDiff * this.spawnWidthValue.getScale(f2);
        float f4 = this.spawnHeight + this.spawnHeightDiff * this.spawnHeightValue.getScale(f2);
        float f5 = this.spawnDepth + this.spawnDepthDiff * this.spawnDepthValue.getScale(f2);
        float f6 = MathUtils.random();
        vector3.x = f6 * f3;
        vector3.y = f6 * f4;
        vector3.z = f6 * f5;
    }

    @Override
    public SpawnShapeValue copy() {
        return new LineSpawnShapeValue(this);
    }
}

