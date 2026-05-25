/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d;

import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.Renderable;
import com.badlogic.gdx.graphics.g3d.RenderableProvider;
import com.badlogic.gdx.graphics.g3d.model.Animation;
import com.badlogic.gdx.graphics.g3d.model.Node;
import com.badlogic.gdx.graphics.g3d.model.NodeAnimation;
import com.badlogic.gdx.graphics.g3d.model.NodeKeyframe;
import com.badlogic.gdx.graphics.g3d.model.NodePart;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.BoundingBox;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ArrayMap;
import com.badlogic.gdx.utils.Pool;

public class ModelInstance
implements RenderableProvider {
    public static boolean defaultShareKeyframes = true;
    public final Array<Material> materials = new Array();
    public final Array<Node> nodes = new Array();
    public final Array<Animation> animations = new Array();
    public final Model model;
    public Matrix4 transform;
    public Object userData;

    public ModelInstance(Model model) {
        this(model, (String[])null);
    }

    public ModelInstance(Model model, String string, boolean bl2) {
        this(model, null, string, false, false, bl2);
    }

    public ModelInstance(Model model, Matrix4 matrix4, String string, boolean bl2) {
        this(model, matrix4, string, false, false, bl2);
    }

    public ModelInstance(Model model, String string, boolean bl2, boolean bl3) {
        this(model, null, string, true, bl2, bl3);
    }

    public ModelInstance(Model model, Matrix4 matrix4, String string, boolean bl2, boolean bl3) {
        this(model, matrix4, string, true, bl2, bl3);
    }

    public ModelInstance(Model model, String string, boolean bl2, boolean bl3, boolean bl4) {
        this(model, null, string, bl2, bl3, bl4);
    }

    public ModelInstance(Model model, Matrix4 matrix4, String string, boolean bl2, boolean bl3, boolean bl4) {
        this(model, matrix4, string, bl2, bl3, bl4, defaultShareKeyframes);
    }

    public ModelInstance(Model model, Matrix4 matrix4, String string, boolean bl2, boolean bl3, boolean bl4, boolean bl5) {
        this.model = model;
        this.transform = matrix4 == null ? new Matrix4() : matrix4;
        Node node = model.getNode(string, bl2);
        Node node2 = node.copy();
        this.nodes.add(node2);
        if (bl4) {
            this.transform.mul(bl3 ? node.globalTransform : node.localTransform);
            node2.translation.set(0.0f, 0.0f, 0.0f);
            node2.rotation.idt();
            node2.scale.set(1.0f, 1.0f, 1.0f);
        } else if (bl3 && node2.hasParent()) {
            this.transform.mul(node.getParent().globalTransform);
        }
        this.invalidate();
        this.copyAnimations(model.animations, bl5);
        this.calculateTransforms();
    }

    public ModelInstance(Model model, String ... stringArray) {
        this(model, (Matrix4)null, stringArray);
    }

    public ModelInstance(Model model, Matrix4 matrix4, String ... stringArray) {
        this.model = model;
        Matrix4 matrix42 = this.transform = matrix4 == null ? new Matrix4() : matrix4;
        if (stringArray == null) {
            this.copyNodes(model.nodes);
        } else {
            this.copyNodes(model.nodes, stringArray);
        }
        this.copyAnimations(model.animations, defaultShareKeyframes);
        this.calculateTransforms();
    }

    public ModelInstance(Model model, Array<String> array) {
        this(model, null, array);
    }

    public ModelInstance(Model model, Matrix4 matrix4, Array<String> array) {
        this(model, matrix4, array, defaultShareKeyframes);
    }

    public ModelInstance(Model model, Matrix4 matrix4, Array<String> array, boolean bl2) {
        this.model = model;
        this.transform = matrix4 == null ? new Matrix4() : matrix4;
        this.copyNodes(model.nodes, array);
        this.copyAnimations(model.animations, bl2);
        this.calculateTransforms();
    }

    public ModelInstance(Model model, Vector3 vector3) {
        this(model);
        this.transform.setToTranslation(vector3);
    }

    public ModelInstance(Model model, float f2, float f3, float f4) {
        this(model);
        this.transform.setToTranslation(f2, f3, f4);
    }

    public ModelInstance(Model model, Matrix4 matrix4) {
        this(model, matrix4, (String[])null);
    }

    public ModelInstance(ModelInstance modelInstance) {
        this(modelInstance, modelInstance.transform.cpy());
    }

    public ModelInstance(ModelInstance modelInstance, Matrix4 matrix4) {
        this(modelInstance, matrix4, defaultShareKeyframes);
    }

    public ModelInstance(ModelInstance modelInstance, Matrix4 matrix4, boolean bl2) {
        this.model = modelInstance.model;
        this.transform = matrix4 == null ? new Matrix4() : matrix4;
        this.copyNodes(modelInstance.nodes);
        this.copyAnimations(modelInstance.animations, bl2);
        this.calculateTransforms();
    }

    public ModelInstance copy() {
        return new ModelInstance(this);
    }

    private void copyNodes(Array<Node> array) {
        int n2 = array.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            Node node = array.get(i2);
            this.nodes.add(node.copy());
        }
        this.invalidate();
    }

    private void copyNodes(Array<Node> array, String ... stringArray) {
        int n2 = array.size;
        block0: for (int i2 = 0; i2 < n2; ++i2) {
            Node node = array.get(i2);
            for (String string : stringArray) {
                if (!string.equals(node.id)) continue;
                this.nodes.add(node.copy());
                continue block0;
            }
        }
        this.invalidate();
    }

    private void copyNodes(Array<Node> array, Array<String> array2) {
        int n2 = array.size;
        block0: for (int i2 = 0; i2 < n2; ++i2) {
            Node node = array.get(i2);
            for (String string : array2) {
                if (!string.equals(node.id)) continue;
                this.nodes.add(node.copy());
                continue block0;
            }
        }
        this.invalidate();
    }

    private void invalidate(Node node) {
        int n2;
        int n3 = node.parts.size;
        for (n2 = 0; n2 < n3; ++n2) {
            int n4;
            NodePart nodePart = node.parts.get(n2);
            ArrayMap<Node, Matrix4> arrayMap = nodePart.invBoneBindTransforms;
            if (arrayMap != null) {
                for (n4 = 0; n4 < arrayMap.size; ++n4) {
                    ((Node[])arrayMap.keys)[n4] = this.getNode(((Node[])arrayMap.keys)[n4].id);
                }
            }
            if (this.materials.contains(nodePart.material, true)) continue;
            n4 = this.materials.indexOf(nodePart.material, false);
            if (n4 < 0) {
                nodePart.material = nodePart.material.copy();
                this.materials.add(nodePart.material);
                continue;
            }
            nodePart.material = this.materials.get(n4);
        }
        n3 = node.getChildCount();
        for (n2 = 0; n2 < n3; ++n2) {
            this.invalidate(node.getChild(n2));
        }
    }

    private void invalidate() {
        int n2 = this.nodes.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            this.invalidate(this.nodes.get(i2));
        }
    }

    public void copyAnimations(Iterable<Animation> iterable) {
        for (Animation animation : iterable) {
            this.copyAnimation(animation, defaultShareKeyframes);
        }
    }

    public void copyAnimations(Iterable<Animation> iterable, boolean bl2) {
        for (Animation animation : iterable) {
            this.copyAnimation(animation, bl2);
        }
    }

    public void copyAnimation(Animation animation) {
        this.copyAnimation(animation, defaultShareKeyframes);
    }

    public void copyAnimation(Animation animation, boolean bl2) {
        Animation animation2 = new Animation();
        animation2.id = animation.id;
        animation2.duration = animation.duration;
        for (NodeAnimation nodeAnimation : animation.nodeAnimations) {
            Node node = this.getNode(nodeAnimation.node.id);
            if (node == null) continue;
            NodeAnimation nodeAnimation2 = new NodeAnimation();
            nodeAnimation2.node = node;
            if (bl2) {
                nodeAnimation2.translation = nodeAnimation.translation;
                nodeAnimation2.rotation = nodeAnimation.rotation;
                nodeAnimation2.scaling = nodeAnimation.scaling;
            } else {
                if (nodeAnimation.translation != null) {
                    nodeAnimation2.translation = new Array();
                    for (NodeKeyframe nodeKeyframe : nodeAnimation.translation) {
                        nodeAnimation2.translation.add(new NodeKeyframe(nodeKeyframe.keytime, nodeKeyframe.value));
                    }
                }
                if (nodeAnimation.rotation != null) {
                    nodeAnimation2.rotation = new Array();
                    for (NodeKeyframe nodeKeyframe : nodeAnimation.rotation) {
                        nodeAnimation2.rotation.add(new NodeKeyframe(nodeKeyframe.keytime, nodeKeyframe.value));
                    }
                }
                if (nodeAnimation.scaling != null) {
                    nodeAnimation2.scaling = new Array();
                    for (NodeKeyframe nodeKeyframe : nodeAnimation.scaling) {
                        nodeAnimation2.scaling.add(new NodeKeyframe(nodeKeyframe.keytime, nodeKeyframe.value));
                    }
                }
            }
            if (nodeAnimation2.translation == null && nodeAnimation2.rotation == null && nodeAnimation2.scaling == null) continue;
            animation2.nodeAnimations.add(nodeAnimation2);
        }
        if (animation2.nodeAnimations.size > 0) {
            this.animations.add(animation2);
        }
    }

    @Override
    public void getRenderables(Array<Renderable> array, Pool<Renderable> pool) {
        for (Node node : this.nodes) {
            this.getRenderables(node, array, pool);
        }
    }

    public Renderable getRenderable(Renderable renderable) {
        return this.getRenderable(renderable, this.nodes.get(0));
    }

    public Renderable getRenderable(Renderable renderable, Node node) {
        return this.getRenderable(renderable, node, node.parts.get(0));
    }

    public Renderable getRenderable(Renderable renderable, Node node, NodePart nodePart) {
        nodePart.setRenderable(renderable);
        if (nodePart.bones == null && this.transform != null) {
            renderable.worldTransform.set(this.transform).mul(node.globalTransform);
        } else if (this.transform != null) {
            renderable.worldTransform.set(this.transform);
        } else {
            renderable.worldTransform.idt();
        }
        renderable.userData = this.userData;
        return renderable;
    }

    protected void getRenderables(Node node, Array<Renderable> array, Pool<Renderable> pool) {
        if (node.parts.size > 0) {
            for (NodePart object : node.parts) {
                if (!object.enabled) continue;
                array.add(this.getRenderable(pool.obtain(), node, object));
            }
        }
        for (Node node2 : node.getChildren()) {
            this.getRenderables(node2, array, pool);
        }
    }

    public void calculateTransforms() {
        int n2;
        int n3 = this.nodes.size;
        for (n2 = 0; n2 < n3; ++n2) {
            this.nodes.get(n2).calculateTransforms(true);
        }
        for (n2 = 0; n2 < n3; ++n2) {
            this.nodes.get(n2).calculateBoneTransforms(true);
        }
    }

    public BoundingBox calculateBoundingBox(BoundingBox boundingBox) {
        boundingBox.inf();
        return this.extendBoundingBox(boundingBox);
    }

    public BoundingBox extendBoundingBox(BoundingBox boundingBox) {
        int n2 = this.nodes.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            this.nodes.get(i2).extendBoundingBox(boundingBox);
        }
        return boundingBox;
    }

    public Animation getAnimation(String string) {
        return this.getAnimation(string, false);
    }

    public Animation getAnimation(String string, boolean bl2) {
        int n2 = this.animations.size;
        if (bl2) {
            for (int i2 = 0; i2 < n2; ++i2) {
                Animation animation = this.animations.get(i2);
                if (!animation.id.equalsIgnoreCase(string)) continue;
                return animation;
            }
        } else {
            for (int i3 = 0; i3 < n2; ++i3) {
                Animation animation = this.animations.get(i3);
                if (!animation.id.equals(string)) continue;
                return animation;
            }
        }
        return null;
    }

    public Material getMaterial(String string) {
        return this.getMaterial(string, true);
    }

    public Material getMaterial(String string, boolean bl2) {
        int n2 = this.materials.size;
        if (bl2) {
            for (int i2 = 0; i2 < n2; ++i2) {
                Material material = this.materials.get(i2);
                if (!material.id.equalsIgnoreCase(string)) continue;
                return material;
            }
        } else {
            for (int i3 = 0; i3 < n2; ++i3) {
                Material material = this.materials.get(i3);
                if (!material.id.equals(string)) continue;
                return material;
            }
        }
        return null;
    }

    public Node getNode(String string) {
        return this.getNode(string, true);
    }

    public Node getNode(String string, boolean bl2) {
        return this.getNode(string, bl2, false);
    }

    public Node getNode(String string, boolean bl2, boolean bl3) {
        return Node.getNode(this.nodes, string, bl2, bl3);
    }
}

