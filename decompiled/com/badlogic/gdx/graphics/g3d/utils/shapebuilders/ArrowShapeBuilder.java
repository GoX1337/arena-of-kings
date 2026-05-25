/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.utils.shapebuilders;

import com.badlogic.gdx.graphics.g3d.utils.MeshPartBuilder;
import com.badlogic.gdx.graphics.g3d.utils.shapebuilders.BaseShapeBuilder;
import com.badlogic.gdx.graphics.g3d.utils.shapebuilders.ConeShapeBuilder;
import com.badlogic.gdx.graphics.g3d.utils.shapebuilders.CylinderShapeBuilder;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;

public class ArrowShapeBuilder
extends BaseShapeBuilder {
    public static void build(MeshPartBuilder meshPartBuilder, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, int n2) {
        Vector3 vector3 = ArrowShapeBuilder.obtainV3().set(f2, f3, f4);
        Vector3 vector32 = ArrowShapeBuilder.obtainV3().set(f5, f6, f7);
        float f10 = vector3.dst(vector32);
        float f11 = f10 * f8;
        float f12 = 2.0f * (float)((double)f11 * Math.sqrt(0.3333333432674408));
        float f13 = f10 - f11;
        float f14 = f12 * f9;
        Vector3 vector33 = ArrowShapeBuilder.obtainV3().set(vector32).sub(vector3).nor();
        Vector3 vector34 = ArrowShapeBuilder.obtainV3().set(vector33).crs(Vector3.Z);
        if (vector34.isZero()) {
            vector34.set(Vector3.X);
        }
        vector34.crs(vector33).nor();
        Vector3 vector35 = ArrowShapeBuilder.obtainV3().set(vector33).crs(vector34).nor();
        Vector3 vector36 = ArrowShapeBuilder.obtainV3().set(vector32).sub(vector3).nor();
        Matrix4 matrix4 = meshPartBuilder.getVertexTransform(ArrowShapeBuilder.obtainM4());
        Matrix4 matrix42 = ArrowShapeBuilder.obtainM4();
        float[] fArray = matrix42.val;
        fArray[0] = vector35.x;
        fArray[4] = vector33.x;
        fArray[8] = vector34.x;
        fArray[1] = vector35.y;
        fArray[5] = vector33.y;
        fArray[9] = vector34.y;
        fArray[2] = vector35.z;
        fArray[6] = vector33.z;
        fArray[10] = vector34.z;
        Matrix4 matrix43 = ArrowShapeBuilder.obtainM4();
        matrix42.setTranslation(ArrowShapeBuilder.obtainV3().set(vector36).scl(f13 / 2.0f).add(f2, f3, f4));
        meshPartBuilder.setVertexTransform(matrix43.set(matrix42).mul(matrix4));
        CylinderShapeBuilder.build(meshPartBuilder, f14, f13, f14, n2);
        matrix42.setTranslation(ArrowShapeBuilder.obtainV3().set(vector36).scl(f13).add(f2, f3, f4));
        meshPartBuilder.setVertexTransform(matrix43.set(matrix42).mul(matrix4));
        ConeShapeBuilder.build(meshPartBuilder, f12, f11, f12, n2);
        meshPartBuilder.setVertexTransform(matrix4);
        ArrowShapeBuilder.freeAll();
    }
}

