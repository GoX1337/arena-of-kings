/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.utils;

import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.model.Animation;
import com.badlogic.gdx.graphics.g3d.model.Node;
import com.badlogic.gdx.graphics.g3d.model.NodeAnimation;
import com.badlogic.gdx.graphics.g3d.model.NodeKeyframe;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.ObjectMap;
import com.badlogic.gdx.utils.Pool;

public class BaseAnimationController {
    private final Pool<Transform> transformPool = new Pool<Transform>(){

        @Override
        protected Transform newObject() {
            return new Transform();
        }
    };
    private static final ObjectMap<Node, Transform> transforms = new ObjectMap();
    private boolean applying = false;
    public final ModelInstance target;
    private static final Transform tmpT = new Transform();

    public BaseAnimationController(ModelInstance modelInstance) {
        this.target = modelInstance;
    }

    protected void begin() {
        if (this.applying) {
            throw new GdxRuntimeException("You must call end() after each call to being()");
        }
        this.applying = true;
    }

    protected void apply(Animation animation, float f2, float f3) {
        if (!this.applying) {
            throw new GdxRuntimeException("You must call begin() before adding an animation");
        }
        BaseAnimationController.applyAnimation(transforms, this.transformPool, f3, animation, f2);
    }

    protected void end() {
        if (!this.applying) {
            throw new GdxRuntimeException("You must call begin() first");
        }
        for (ObjectMap.Entry entry : transforms.entries()) {
            ((Transform)entry.value).toMatrix4(((Node)entry.key).localTransform);
            this.transformPool.free((Transform)entry.value);
        }
        transforms.clear();
        this.target.calculateTransforms();
        this.applying = false;
    }

    protected void applyAnimation(Animation animation, float f2) {
        if (this.applying) {
            throw new GdxRuntimeException("Call end() first");
        }
        BaseAnimationController.applyAnimation(null, null, 1.0f, animation, f2);
        this.target.calculateTransforms();
    }

    protected void applyAnimations(Animation animation, float f2, Animation animation2, float f3, float f4) {
        if (animation2 == null || f4 == 0.0f) {
            this.applyAnimation(animation, f2);
        } else if (animation == null || f4 == 1.0f) {
            this.applyAnimation(animation2, f3);
        } else {
            if (this.applying) {
                throw new GdxRuntimeException("Call end() first");
            }
            this.begin();
            this.apply(animation, f2, 1.0f);
            this.apply(animation2, f3, f4);
            this.end();
        }
    }

    static final <T> int getFirstKeyframeIndexAtTime(Array<NodeKeyframe<T>> array, float f2) {
        int n2 = array.size - 1;
        if (n2 <= 0 || f2 < array.get((int)0).keytime || f2 > array.get((int)n2).keytime) {
            return 0;
        }
        int n3 = 0;
        int n4 = n2;
        while (n3 < n4) {
            int n5 = (n3 + n4) / 2;
            if (f2 > array.get((int)(n5 + 1)).keytime) {
                n3 = n5 + 1;
                continue;
            }
            if (f2 < array.get((int)n5).keytime) {
                n4 = n5 - 1;
                continue;
            }
            return n5;
        }
        return n3;
    }

    private static final Vector3 getTranslationAtTime(NodeAnimation nodeAnimation, float f2, Vector3 vector3) {
        if (nodeAnimation.translation == null) {
            return vector3.set(nodeAnimation.node.translation);
        }
        if (nodeAnimation.translation.size == 1) {
            return vector3.set((Vector3)nodeAnimation.translation.get((int)0).value);
        }
        int n2 = BaseAnimationController.getFirstKeyframeIndexAtTime(nodeAnimation.translation, f2);
        NodeKeyframe<Vector3> nodeKeyframe = nodeAnimation.translation.get(n2);
        vector3.set((Vector3)nodeKeyframe.value);
        if (++n2 < nodeAnimation.translation.size) {
            NodeKeyframe<Vector3> nodeKeyframe2 = nodeAnimation.translation.get(n2);
            float f3 = (f2 - nodeKeyframe.keytime) / (nodeKeyframe2.keytime - nodeKeyframe.keytime);
            vector3.lerp((Vector3)nodeKeyframe2.value, f3);
        }
        return vector3;
    }

    private static final Quaternion getRotationAtTime(NodeAnimation nodeAnimation, float f2, Quaternion quaternion) {
        if (nodeAnimation.rotation == null) {
            return quaternion.set(nodeAnimation.node.rotation);
        }
        if (nodeAnimation.rotation.size == 1) {
            return quaternion.set((Quaternion)nodeAnimation.rotation.get((int)0).value);
        }
        int n2 = BaseAnimationController.getFirstKeyframeIndexAtTime(nodeAnimation.rotation, f2);
        NodeKeyframe<Quaternion> nodeKeyframe = nodeAnimation.rotation.get(n2);
        quaternion.set((Quaternion)nodeKeyframe.value);
        if (++n2 < nodeAnimation.rotation.size) {
            NodeKeyframe<Quaternion> nodeKeyframe2 = nodeAnimation.rotation.get(n2);
            float f3 = (f2 - nodeKeyframe.keytime) / (nodeKeyframe2.keytime - nodeKeyframe.keytime);
            quaternion.slerp((Quaternion)nodeKeyframe2.value, f3);
        }
        return quaternion;
    }

    private static final Vector3 getScalingAtTime(NodeAnimation nodeAnimation, float f2, Vector3 vector3) {
        if (nodeAnimation.scaling == null) {
            return vector3.set(nodeAnimation.node.scale);
        }
        if (nodeAnimation.scaling.size == 1) {
            return vector3.set((Vector3)nodeAnimation.scaling.get((int)0).value);
        }
        int n2 = BaseAnimationController.getFirstKeyframeIndexAtTime(nodeAnimation.scaling, f2);
        NodeKeyframe<Vector3> nodeKeyframe = nodeAnimation.scaling.get(n2);
        vector3.set((Vector3)nodeKeyframe.value);
        if (++n2 < nodeAnimation.scaling.size) {
            NodeKeyframe<Vector3> nodeKeyframe2 = nodeAnimation.scaling.get(n2);
            float f3 = (f2 - nodeKeyframe.keytime) / (nodeKeyframe2.keytime - nodeKeyframe.keytime);
            vector3.lerp((Vector3)nodeKeyframe2.value, f3);
        }
        return vector3;
    }

    private static final Transform getNodeAnimationTransform(NodeAnimation nodeAnimation, float f2) {
        Transform transform = tmpT;
        BaseAnimationController.getTranslationAtTime(nodeAnimation, f2, transform.translation);
        BaseAnimationController.getRotationAtTime(nodeAnimation, f2, transform.rotation);
        BaseAnimationController.getScalingAtTime(nodeAnimation, f2, transform.scale);
        return transform;
    }

    private static final void applyNodeAnimationDirectly(NodeAnimation nodeAnimation, float f2) {
        Node node = nodeAnimation.node;
        node.isAnimated = true;
        Transform transform = BaseAnimationController.getNodeAnimationTransform(nodeAnimation, f2);
        transform.toMatrix4(node.localTransform);
    }

    private static final void applyNodeAnimationBlending(NodeAnimation nodeAnimation, ObjectMap<Node, Transform> objectMap, Pool<Transform> pool, float f2, float f3) {
        Node node = nodeAnimation.node;
        node.isAnimated = true;
        Transform transform = BaseAnimationController.getNodeAnimationTransform(nodeAnimation, f3);
        Transform transform2 = objectMap.get(node, null);
        if (transform2 != null) {
            if (f2 > 0.999999f) {
                transform2.set(transform);
            } else {
                transform2.lerp(transform, f2);
            }
        } else if (f2 > 0.999999f) {
            objectMap.put(node, pool.obtain().set(transform));
        } else {
            objectMap.put(node, pool.obtain().set(node.translation, node.rotation, node.scale).lerp(transform, f2));
        }
    }

    protected static void applyAnimation(ObjectMap<Node, Transform> objectMap, Pool<Transform> pool, float f2, Animation animation, float f3) {
        if (objectMap == null) {
            for (NodeAnimation nodeAnimation : animation.nodeAnimations) {
                BaseAnimationController.applyNodeAnimationDirectly(nodeAnimation, f3);
            }
        } else {
            for (Node object : objectMap.keys()) {
                object.isAnimated = false;
            }
            for (NodeAnimation nodeAnimation : animation.nodeAnimations) {
                BaseAnimationController.applyNodeAnimationBlending(nodeAnimation, objectMap, pool, f2, f3);
            }
            for (ObjectMap.Entry entry : objectMap.entries()) {
                if (((Node)entry.key).isAnimated) continue;
                ((Node)entry.key).isAnimated = true;
                ((Transform)entry.value).lerp(((Node)entry.key).translation, ((Node)entry.key).rotation, ((Node)entry.key).scale, f2);
            }
        }
    }

    protected void removeAnimation(Animation animation) {
        for (NodeAnimation nodeAnimation : animation.nodeAnimations) {
            nodeAnimation.node.isAnimated = false;
        }
    }

    public static final class Transform
    implements Pool.Poolable {
        public final Vector3 translation = new Vector3();
        public final Quaternion rotation = new Quaternion();
        public final Vector3 scale = new Vector3(1.0f, 1.0f, 1.0f);

        public Transform idt() {
            this.translation.set(0.0f, 0.0f, 0.0f);
            this.rotation.idt();
            this.scale.set(1.0f, 1.0f, 1.0f);
            return this;
        }

        public Transform set(Vector3 vector3, Quaternion quaternion, Vector3 vector32) {
            this.translation.set(vector3);
            this.rotation.set(quaternion);
            this.scale.set(vector32);
            return this;
        }

        public Transform set(Transform transform) {
            return this.set(transform.translation, transform.rotation, transform.scale);
        }

        public Transform lerp(Transform transform, float f2) {
            return this.lerp(transform.translation, transform.rotation, transform.scale, f2);
        }

        public Transform lerp(Vector3 vector3, Quaternion quaternion, Vector3 vector32, float f2) {
            this.translation.lerp(vector3, f2);
            this.rotation.slerp(quaternion, f2);
            this.scale.lerp(vector32, f2);
            return this;
        }

        public Matrix4 toMatrix4(Matrix4 matrix4) {
            return matrix4.set(this.translation, this.rotation, this.scale);
        }

        @Override
        public void reset() {
            this.idt();
        }

        public String toString() {
            return this.translation.toString() + " - " + this.rotation.toString() + " - " + this.scale.toString();
        }
    }
}

