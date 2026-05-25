/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.utils.shapebuilders;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g3d.utils.MeshPartBuilder;
import com.badlogic.gdx.graphics.g3d.utils.shapebuilders.BaseShapeBuilder;
import com.badlogic.gdx.math.Frustum;
import com.badlogic.gdx.math.Vector3;

public class FrustumShapeBuilder
extends BaseShapeBuilder {
    public static void build(MeshPartBuilder meshPartBuilder, Camera camera) {
        FrustumShapeBuilder.build(meshPartBuilder, camera, tmpColor0.set(1.0f, 0.66f, 0.0f, 1.0f), tmpColor1.set(1.0f, 0.0f, 0.0f, 1.0f), tmpColor2.set(0.0f, 0.66f, 1.0f, 1.0f), tmpColor3.set(1.0f, 1.0f, 1.0f, 1.0f), tmpColor4.set(0.2f, 0.2f, 0.2f, 1.0f));
    }

    public static void build(MeshPartBuilder meshPartBuilder, Camera camera, Color color, Color color2, Color color3, Color color4, Color color5) {
        Vector3[] vector3Array = camera.frustum.planePoints;
        FrustumShapeBuilder.build(meshPartBuilder, camera.frustum, color, color5);
        meshPartBuilder.line(vector3Array[0], color2, camera.position, color2);
        meshPartBuilder.line(vector3Array[1], color2, camera.position, color2);
        meshPartBuilder.line(vector3Array[2], color2, camera.position, color2);
        meshPartBuilder.line(vector3Array[3], color2, camera.position, color2);
        meshPartBuilder.line(camera.position, color4, FrustumShapeBuilder.centerPoint(vector3Array[4], vector3Array[5], vector3Array[6]), color4);
        float f2 = tmpV0.set(vector3Array[1]).sub(vector3Array[0]).scl(0.5f).len();
        Vector3 vector3 = FrustumShapeBuilder.centerPoint(vector3Array[0], vector3Array[1], vector3Array[2]);
        tmpV0.set(camera.up).scl(f2 * 2.0f);
        vector3.add(tmpV0);
        meshPartBuilder.line(vector3, color3, vector3Array[2], color3);
        meshPartBuilder.line(vector3Array[2], color3, vector3Array[3], color3);
        meshPartBuilder.line(vector3Array[3], color3, vector3, color3);
    }

    public static void build(MeshPartBuilder meshPartBuilder, Frustum frustum, Color color, Color color2) {
        Vector3[] vector3Array = frustum.planePoints;
        meshPartBuilder.line(vector3Array[0], color, vector3Array[1], color);
        meshPartBuilder.line(vector3Array[1], color, vector3Array[2], color);
        meshPartBuilder.line(vector3Array[2], color, vector3Array[3], color);
        meshPartBuilder.line(vector3Array[3], color, vector3Array[0], color);
        meshPartBuilder.line(vector3Array[4], color, vector3Array[5], color);
        meshPartBuilder.line(vector3Array[5], color, vector3Array[6], color);
        meshPartBuilder.line(vector3Array[6], color, vector3Array[7], color);
        meshPartBuilder.line(vector3Array[7], color, vector3Array[4], color);
        meshPartBuilder.line(vector3Array[0], color, vector3Array[4], color);
        meshPartBuilder.line(vector3Array[1], color, vector3Array[5], color);
        meshPartBuilder.line(vector3Array[2], color, vector3Array[6], color);
        meshPartBuilder.line(vector3Array[3], color, vector3Array[7], color);
        meshPartBuilder.line(FrustumShapeBuilder.middlePoint(vector3Array[1], vector3Array[0]), color2, FrustumShapeBuilder.middlePoint(vector3Array[3], vector3Array[2]), color2);
        meshPartBuilder.line(FrustumShapeBuilder.middlePoint(vector3Array[2], vector3Array[1]), color2, FrustumShapeBuilder.middlePoint(vector3Array[3], vector3Array[0]), color2);
        meshPartBuilder.line(FrustumShapeBuilder.middlePoint(vector3Array[5], vector3Array[4]), color2, FrustumShapeBuilder.middlePoint(vector3Array[7], vector3Array[6]), color2);
        meshPartBuilder.line(FrustumShapeBuilder.middlePoint(vector3Array[6], vector3Array[5]), color2, FrustumShapeBuilder.middlePoint(vector3Array[7], vector3Array[4]), color2);
    }

    private static Vector3 middlePoint(Vector3 vector3, Vector3 vector32) {
        tmpV0.set(vector32).sub(vector3).scl(0.5f);
        return tmpV1.set(vector3).add(tmpV0);
    }

    private static Vector3 centerPoint(Vector3 vector3, Vector3 vector32, Vector3 vector33) {
        tmpV0.set(vector32).sub(vector3).scl(0.5f);
        tmpV1.set(vector3).add(tmpV0);
        tmpV0.set(vector33).sub(vector32).scl(0.5f);
        return tmpV1.add(tmpV0);
    }
}

