/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.utils.shapebuilders;

import com.badlogic.gdx.graphics.g3d.utils.MeshPartBuilder;
import com.badlogic.gdx.graphics.g3d.utils.shapebuilders.BaseShapeBuilder;
import com.badlogic.gdx.graphics.g3d.utils.shapebuilders.CylinderShapeBuilder;
import com.badlogic.gdx.graphics.g3d.utils.shapebuilders.SphereShapeBuilder;
import com.badlogic.gdx.utils.GdxRuntimeException;

public class CapsuleShapeBuilder
extends BaseShapeBuilder {
    public static void build(MeshPartBuilder meshPartBuilder, float f2, float f3, int n2) {
        if (f3 < 2.0f * f2) {
            throw new GdxRuntimeException("Height must be at least twice the radius");
        }
        float f4 = 2.0f * f2;
        CylinderShapeBuilder.build(meshPartBuilder, f4, f3 - f4, f4, n2, 0.0f, 360.0f, false);
        SphereShapeBuilder.build(meshPartBuilder, matTmp1.setToTranslation(0.0f, 0.5f * (f3 - f4), 0.0f), f4, f4, f4, n2, n2, 0.0f, 360.0f, 0.0f, 90.0f);
        SphereShapeBuilder.build(meshPartBuilder, matTmp1.setToTranslation(0.0f, -0.5f * (f3 - f4), 0.0f), f4, f4, f4, n2, n2, 0.0f, 360.0f, 90.0f, 180.0f);
    }
}

