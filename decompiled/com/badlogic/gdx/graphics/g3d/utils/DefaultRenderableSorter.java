/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.utils;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g3d.Renderable;
import com.badlogic.gdx.graphics.g3d.attributes.BlendingAttribute;
import com.badlogic.gdx.graphics.g3d.utils.RenderableSorter;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import java.util.Comparator;

public class DefaultRenderableSorter
implements RenderableSorter,
Comparator<Renderable> {
    private Camera camera;
    private final Vector3 tmpV1 = new Vector3();
    private final Vector3 tmpV2 = new Vector3();

    @Override
    public void sort(Camera camera, Array<Renderable> array) {
        this.camera = camera;
        array.sort(this);
    }

    private Vector3 getTranslation(Matrix4 matrix4, Vector3 vector3, Vector3 vector32) {
        if (vector3.isZero()) {
            matrix4.getTranslation(vector32);
        } else if (!matrix4.hasRotationOrScaling()) {
            matrix4.getTranslation(vector32).add(vector3);
        } else {
            vector32.set(vector3).mul(matrix4);
        }
        return vector32;
    }

    @Override
    public int compare(Renderable renderable, Renderable renderable2) {
        boolean bl2;
        boolean bl3 = renderable.material.has(BlendingAttribute.Type) && ((BlendingAttribute)renderable.material.get((long)BlendingAttribute.Type)).blended;
        boolean bl4 = bl2 = renderable2.material.has(BlendingAttribute.Type) && ((BlendingAttribute)renderable2.material.get((long)BlendingAttribute.Type)).blended;
        if (bl3 != bl2) {
            return bl3 ? 1 : -1;
        }
        this.getTranslation(renderable.worldTransform, renderable.meshPart.center, this.tmpV1);
        this.getTranslation(renderable2.worldTransform, renderable2.meshPart.center, this.tmpV2);
        float f2 = (int)(1000.0f * this.camera.position.dst2(this.tmpV1)) - (int)(1000.0f * this.camera.position.dst2(this.tmpV2));
        int n2 = f2 < 0.0f ? -1 : (f2 > 0.0f ? 1 : 0);
        return bl3 ? -n2 : n2;
    }
}

