/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.model;

import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Renderable;
import com.badlogic.gdx.graphics.g3d.model.MeshPart;
import com.badlogic.gdx.graphics.g3d.model.Node;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.utils.ArrayMap;

public class NodePart {
    public MeshPart meshPart;
    public Material material;
    public ArrayMap<Node, Matrix4> invBoneBindTransforms;
    public Matrix4[] bones;
    public boolean enabled = true;

    public NodePart() {
    }

    public NodePart(MeshPart meshPart, Material material) {
        this.meshPart = meshPart;
        this.material = material;
    }

    public Renderable setRenderable(Renderable renderable) {
        renderable.material = this.material;
        renderable.meshPart.set(this.meshPart);
        renderable.bones = this.bones;
        return renderable;
    }

    public NodePart copy() {
        return new NodePart().set(this);
    }

    protected NodePart set(NodePart nodePart) {
        this.meshPart = new MeshPart(nodePart.meshPart);
        this.material = nodePart.material;
        this.enabled = nodePart.enabled;
        if (nodePart.invBoneBindTransforms == null) {
            this.invBoneBindTransforms = null;
            this.bones = null;
        } else {
            if (this.invBoneBindTransforms == null) {
                this.invBoneBindTransforms = new ArrayMap(true, nodePart.invBoneBindTransforms.size, Node.class, Matrix4.class);
            } else {
                this.invBoneBindTransforms.clear();
            }
            this.invBoneBindTransforms.putAll(nodePart.invBoneBindTransforms);
            if (this.bones == null || this.bones.length != this.invBoneBindTransforms.size) {
                this.bones = new Matrix4[this.invBoneBindTransforms.size];
            }
            for (int i2 = 0; i2 < this.bones.length; ++i2) {
                if (this.bones[i2] != null) continue;
                this.bones[i2] = new Matrix4();
            }
        }
        return this;
    }
}

