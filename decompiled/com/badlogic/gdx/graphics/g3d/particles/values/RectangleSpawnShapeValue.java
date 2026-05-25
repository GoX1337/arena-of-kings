/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.particles.values;

import com.badlogic.gdx.graphics.g3d.particles.values.PrimitiveSpawnShapeValue;
import com.badlogic.gdx.graphics.g3d.particles.values.SpawnShapeValue;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;

public final class RectangleSpawnShapeValue
extends PrimitiveSpawnShapeValue {
    public RectangleSpawnShapeValue(RectangleSpawnShapeValue rectangleSpawnShapeValue) {
        super(rectangleSpawnShapeValue);
        this.load(rectangleSpawnShapeValue);
    }

    public RectangleSpawnShapeValue() {
    }

    @Override
    public void spawnAux(Vector3 vector3, float f2) {
        float f3 = this.spawnWidth + this.spawnWidthDiff * this.spawnWidthValue.getScale(f2);
        float f4 = this.spawnHeight + this.spawnHeightDiff * this.spawnHeightValue.getScale(f2);
        float f5 = this.spawnDepth + this.spawnDepthDiff * this.spawnDepthValue.getScale(f2);
        if (this.edges) {
            int n2 = MathUtils.random(-1, 1);
            float f6 = 0.0f;
            float f7 = 0.0f;
            float f8 = 0.0f;
            if (n2 == -1) {
                float f9 = f6 = MathUtils.random(1) == 0 ? -f3 / 2.0f : f3 / 2.0f;
                if (f6 == 0.0f) {
                    f7 = MathUtils.random(1) == 0 ? -f4 / 2.0f : f4 / 2.0f;
                    f8 = MathUtils.random(1) == 0 ? -f5 / 2.0f : f5 / 2.0f;
                } else {
                    f7 = MathUtils.random(f4) - f4 / 2.0f;
                    f8 = MathUtils.random(f5) - f5 / 2.0f;
                }
            } else if (n2 == 0) {
                float f10 = f8 = MathUtils.random(1) == 0 ? -f5 / 2.0f : f5 / 2.0f;
                if (f8 == 0.0f) {
                    f7 = MathUtils.random(1) == 0 ? -f4 / 2.0f : f4 / 2.0f;
                    f6 = MathUtils.random(1) == 0 ? -f3 / 2.0f : f3 / 2.0f;
                } else {
                    f7 = MathUtils.random(f4) - f4 / 2.0f;
                    f6 = MathUtils.random(f3) - f3 / 2.0f;
                }
            } else {
                float f11 = f7 = MathUtils.random(1) == 0 ? -f4 / 2.0f : f4 / 2.0f;
                if (f7 == 0.0f) {
                    f6 = MathUtils.random(1) == 0 ? -f3 / 2.0f : f3 / 2.0f;
                    f8 = MathUtils.random(1) == 0 ? -f5 / 2.0f : f5 / 2.0f;
                } else {
                    f6 = MathUtils.random(f3) - f3 / 2.0f;
                    f8 = MathUtils.random(f5) - f5 / 2.0f;
                }
            }
            vector3.x = f6;
            vector3.y = f7;
            vector3.z = f8;
        } else {
            vector3.x = MathUtils.random(f3) - f3 / 2.0f;
            vector3.y = MathUtils.random(f4) - f4 / 2.0f;
            vector3.z = MathUtils.random(f5) - f5 / 2.0f;
        }
    }

    @Override
    public SpawnShapeValue copy() {
        return new RectangleSpawnShapeValue(this);
    }
}

