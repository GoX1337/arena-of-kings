/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.model;

import com.badlogic.gdx.graphics.g3d.model.MeshPart;
import com.badlogic.gdx.graphics.g3d.model.NodePart;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.BoundingBox;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.GdxRuntimeException;

public class Node {
    public String id;
    public boolean inheritTransform = true;
    public boolean isAnimated;
    public final Vector3 translation = new Vector3();
    public final Quaternion rotation = new Quaternion(0.0f, 0.0f, 0.0f, 1.0f);
    public final Vector3 scale = new Vector3(1.0f, 1.0f, 1.0f);
    public final Matrix4 localTransform = new Matrix4();
    public final Matrix4 globalTransform = new Matrix4();
    public Array<NodePart> parts = new Array(2);
    protected Node parent;
    private final Array<Node> children = new Array(2);

    public Matrix4 calculateLocalTransform() {
        if (!this.isAnimated) {
            this.localTransform.set(this.translation, this.rotation, this.scale);
        }
        return this.localTransform;
    }

    public Matrix4 calculateWorldTransform() {
        if (this.inheritTransform && this.parent != null) {
            this.globalTransform.set(this.parent.globalTransform).mul(this.localTransform);
        } else {
            this.globalTransform.set(this.localTransform);
        }
        return this.globalTransform;
    }

    public void calculateTransforms(boolean bl2) {
        this.calculateLocalTransform();
        this.calculateWorldTransform();
        if (bl2) {
            for (Node node : this.children) {
                node.calculateTransforms(true);
            }
        }
    }

    public void calculateBoneTransforms(boolean bl2) {
        for (NodePart object : this.parts) {
            if (object.invBoneBindTransforms == null || object.bones == null || object.invBoneBindTransforms.size != object.bones.length) continue;
            int n2 = object.invBoneBindTransforms.size;
            for (int i2 = 0; i2 < n2; ++i2) {
                object.bones[i2].set(((Node[])object.invBoneBindTransforms.keys)[i2].globalTransform).mul(((Matrix4[])object.invBoneBindTransforms.values)[i2]);
            }
        }
        if (bl2) {
            for (Node node : this.children) {
                node.calculateBoneTransforms(true);
            }
        }
    }

    public BoundingBox calculateBoundingBox(BoundingBox boundingBox) {
        boundingBox.inf();
        return this.extendBoundingBox(boundingBox);
    }

    public BoundingBox calculateBoundingBox(BoundingBox boundingBox, boolean bl2) {
        boundingBox.inf();
        return this.extendBoundingBox(boundingBox, bl2);
    }

    public BoundingBox extendBoundingBox(BoundingBox boundingBox) {
        return this.extendBoundingBox(boundingBox, true);
    }

    public BoundingBox extendBoundingBox(BoundingBox boundingBox, boolean bl2) {
        int n2;
        int n3 = this.parts.size;
        for (n2 = 0; n2 < n3; ++n2) {
            NodePart nodePart = this.parts.get(n2);
            if (!nodePart.enabled) continue;
            MeshPart meshPart = nodePart.meshPart;
            if (bl2) {
                meshPart.mesh.extendBoundingBox(boundingBox, meshPart.offset, meshPart.size, this.globalTransform);
                continue;
            }
            meshPart.mesh.extendBoundingBox(boundingBox, meshPart.offset, meshPart.size);
        }
        n2 = this.children.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            this.children.get(i2).extendBoundingBox(boundingBox);
        }
        return boundingBox;
    }

    public <T extends Node> void attachTo(T node) {
        node.addChild((Node)this);
    }

    public void detach() {
        if (this.parent != null) {
            this.parent.removeChild(this);
            this.parent = null;
        }
    }

    public boolean hasChildren() {
        return this.children != null && this.children.size > 0;
    }

    public int getChildCount() {
        return this.children.size;
    }

    public Node getChild(int n2) {
        return this.children.get(n2);
    }

    public Node getChild(String string, boolean bl2, boolean bl3) {
        return Node.getNode(this.children, string, bl2, bl3);
    }

    public <T extends Node> int addChild(T t2) {
        return this.insertChild(-1, t2);
    }

    public <T extends Node> int addChildren(Iterable<T> iterable) {
        return this.insertChildren(-1, iterable);
    }

    public <T extends Node> int insertChild(int n2, T t2) {
        Node node;
        for (node = this; node != null; node = node.getParent()) {
            if (node != t2) continue;
            throw new GdxRuntimeException("Cannot add a parent as a child");
        }
        node = t2.getParent();
        if (node != null && !node.removeChild(t2)) {
            throw new GdxRuntimeException("Could not remove child from its current parent");
        }
        if (n2 < 0 || n2 >= this.children.size) {
            n2 = this.children.size;
            this.children.add(t2);
        } else {
            this.children.insert(n2, t2);
        }
        t2.parent = this;
        return n2;
    }

    public <T extends Node> int insertChildren(int n2, Iterable<T> iterable) {
        if (n2 < 0 || n2 > this.children.size) {
            n2 = this.children.size;
        }
        int n3 = n2;
        for (Node node : iterable) {
            this.insertChild(n3++, node);
        }
        return n2;
    }

    public <T extends Node> boolean removeChild(T t2) {
        if (!this.children.removeValue(t2, true)) {
            return false;
        }
        t2.parent = null;
        return true;
    }

    public Iterable<Node> getChildren() {
        return this.children;
    }

    public Node getParent() {
        return this.parent;
    }

    public boolean hasParent() {
        return this.parent != null;
    }

    public Node copy() {
        return new Node().set(this);
    }

    protected Node set(Node node) {
        this.detach();
        this.id = node.id;
        this.isAnimated = node.isAnimated;
        this.inheritTransform = node.inheritTransform;
        this.translation.set(node.translation);
        this.rotation.set(node.rotation);
        this.scale.set(node.scale);
        this.localTransform.set(node.localTransform);
        this.globalTransform.set(node.globalTransform);
        this.parts.clear();
        for (NodePart object : node.parts) {
            this.parts.add(object.copy());
        }
        this.children.clear();
        for (Node node2 : node.getChildren()) {
            this.addChild(node2.copy());
        }
        return this;
    }

    public static Node getNode(Array<Node> array, String string, boolean bl2, boolean bl3) {
        Node node;
        int n2;
        int n3 = array.size;
        if (bl3) {
            for (n2 = 0; n2 < n3; ++n2) {
                node = array.get(n2);
                if (!node.id.equalsIgnoreCase(string)) continue;
                return node;
            }
        } else {
            for (n2 = 0; n2 < n3; ++n2) {
                node = array.get(n2);
                if (!node.id.equals(string)) continue;
                return node;
            }
        }
        if (bl2) {
            for (n2 = 0; n2 < n3; ++n2) {
                node = Node.getNode(array.get((int)n2).children, string, true, bl3);
                if (node == null) continue;
                return node;
            }
        }
        return null;
    }
}

