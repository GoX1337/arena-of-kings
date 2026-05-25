/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.utils;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.model.MeshPart;
import com.badlogic.gdx.graphics.g3d.model.Node;
import com.badlogic.gdx.graphics.g3d.model.NodePart;
import com.badlogic.gdx.graphics.g3d.utils.MeshBuilder;
import com.badlogic.gdx.graphics.g3d.utils.MeshPartBuilder;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.GdxRuntimeException;

public class ModelBuilder {
    private Model model;
    private Node node;
    private Array<MeshBuilder> builders = new Array();
    private Matrix4 tmpTransform = new Matrix4();

    private MeshBuilder getBuilder(VertexAttributes vertexAttributes) {
        for (MeshBuilder meshBuilder : this.builders) {
            if (!meshBuilder.getAttributes().equals(vertexAttributes) || meshBuilder.lastIndex() >= 16383) continue;
            return meshBuilder;
        }
        MeshBuilder meshBuilder = new MeshBuilder();
        meshBuilder.begin(vertexAttributes);
        this.builders.add(meshBuilder);
        return meshBuilder;
    }

    public void begin() {
        if (this.model != null) {
            throw new GdxRuntimeException("Call end() first");
        }
        this.node = null;
        this.model = new Model();
        this.builders.clear();
    }

    public Model end() {
        if (this.model == null) {
            throw new GdxRuntimeException("Call begin() first");
        }
        Model model = this.model;
        this.endnode();
        this.model = null;
        for (MeshBuilder meshBuilder : this.builders) {
            meshBuilder.end();
        }
        this.builders.clear();
        ModelBuilder.rebuildReferences(model);
        return model;
    }

    private void endnode() {
        if (this.node != null) {
            this.node = null;
        }
    }

    protected Node node(Node node) {
        if (this.model == null) {
            throw new GdxRuntimeException("Call begin() first");
        }
        this.endnode();
        this.model.nodes.add(node);
        this.node = node;
        return node;
    }

    public Node node() {
        Node node = new Node();
        this.node(node);
        node.id = "node" + this.model.nodes.size;
        return node;
    }

    public Node node(String string, Model model) {
        Node node = new Node();
        node.id = string;
        node.addChildren(model.nodes);
        this.node(node);
        for (Disposable disposable : model.getManagedDisposables()) {
            this.manage(disposable);
        }
        return node;
    }

    public void manage(Disposable disposable) {
        if (this.model == null) {
            throw new GdxRuntimeException("Call begin() first");
        }
        this.model.manageDisposable(disposable);
    }

    public void part(MeshPart meshPart, Material material) {
        if (this.node == null) {
            this.node();
        }
        this.node.parts.add(new NodePart(meshPart, material));
    }

    public MeshPart part(String string, Mesh mesh, int n2, int n3, int n4, Material material) {
        MeshPart meshPart = new MeshPart();
        meshPart.id = string;
        meshPart.primitiveType = n2;
        meshPart.mesh = mesh;
        meshPart.offset = n3;
        meshPart.size = n4;
        this.part(meshPart, material);
        return meshPart;
    }

    public MeshPart part(String string, Mesh mesh, int n2, Material material) {
        return this.part(string, mesh, n2, 0, mesh.getNumIndices(), material);
    }

    public MeshPartBuilder part(String string, int n2, VertexAttributes vertexAttributes, Material material) {
        MeshBuilder meshBuilder = this.getBuilder(vertexAttributes);
        this.part(meshBuilder.part(string, n2), material);
        return meshBuilder;
    }

    public MeshPartBuilder part(String string, int n2, long l2, Material material) {
        return this.part(string, n2, MeshBuilder.createAttributes(l2), material);
    }

    public Model createBox(float f2, float f3, float f4, Material material, long l2) {
        return this.createBox(f2, f3, f4, 4, material, l2);
    }

    public Model createBox(float f2, float f3, float f4, int n2, Material material, long l2) {
        this.begin();
        this.part("box", n2, l2, material).box(f2, f3, f4);
        return this.end();
    }

    public Model createRect(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, Material material, long l2) {
        return this.createRect(f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, 4, material, l2);
    }

    public Model createRect(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, int n2, Material material, long l2) {
        this.begin();
        this.part("rect", n2, l2, material).rect(f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16);
        return this.end();
    }

    public Model createCylinder(float f2, float f3, float f4, int n2, Material material, long l2) {
        return this.createCylinder(f2, f3, f4, n2, 4, material, l2);
    }

    public Model createCylinder(float f2, float f3, float f4, int n2, int n3, Material material, long l2) {
        return this.createCylinder(f2, f3, f4, n2, n3, material, l2, 0.0f, 360.0f);
    }

    public Model createCylinder(float f2, float f3, float f4, int n2, Material material, long l2, float f5, float f6) {
        return this.createCylinder(f2, f3, f4, n2, 4, material, l2, f5, f6);
    }

    public Model createCylinder(float f2, float f3, float f4, int n2, int n3, Material material, long l2, float f5, float f6) {
        this.begin();
        this.part("cylinder", n3, l2, material).cylinder(f2, f3, f4, n2, f5, f6);
        return this.end();
    }

    public Model createCone(float f2, float f3, float f4, int n2, Material material, long l2) {
        return this.createCone(f2, f3, f4, n2, 4, material, l2);
    }

    public Model createCone(float f2, float f3, float f4, int n2, int n3, Material material, long l2) {
        return this.createCone(f2, f3, f4, n2, n3, material, l2, 0.0f, 360.0f);
    }

    public Model createCone(float f2, float f3, float f4, int n2, Material material, long l2, float f5, float f6) {
        return this.createCone(f2, f3, f4, n2, 4, material, l2, f5, f6);
    }

    public Model createCone(float f2, float f3, float f4, int n2, int n3, Material material, long l2, float f5, float f6) {
        this.begin();
        this.part("cone", n3, l2, material).cone(f2, f3, f4, n2, f5, f6);
        return this.end();
    }

    public Model createSphere(float f2, float f3, float f4, int n2, int n3, Material material, long l2) {
        return this.createSphere(f2, f3, f4, n2, n3, 4, material, l2);
    }

    public Model createSphere(float f2, float f3, float f4, int n2, int n3, int n4, Material material, long l2) {
        return this.createSphere(f2, f3, f4, n2, n3, n4, material, l2, 0.0f, 360.0f, 0.0f, 180.0f);
    }

    public Model createSphere(float f2, float f3, float f4, int n2, int n3, Material material, long l2, float f5, float f6, float f7, float f8) {
        return this.createSphere(f2, f3, f4, n2, n3, 4, material, l2, f5, f6, f7, f8);
    }

    public Model createSphere(float f2, float f3, float f4, int n2, int n3, int n4, Material material, long l2, float f5, float f6, float f7, float f8) {
        this.begin();
        this.part("sphere", n4, l2, material).sphere(f2, f3, f4, n2, n3, f5, f6, f7, f8);
        return this.end();
    }

    public Model createCapsule(float f2, float f3, int n2, Material material, long l2) {
        return this.createCapsule(f2, f3, n2, 4, material, l2);
    }

    public Model createCapsule(float f2, float f3, int n2, int n3, Material material, long l2) {
        this.begin();
        this.part("capsule", n3, l2, material).capsule(f2, f3, n2);
        return this.end();
    }

    public static void rebuildReferences(Model model) {
        model.materials.clear();
        model.meshes.clear();
        model.meshParts.clear();
        for (Node node : model.nodes) {
            ModelBuilder.rebuildReferences(model, node);
        }
    }

    private static void rebuildReferences(Model model, Node node) {
        for (NodePart object : node.parts) {
            if (!model.materials.contains(object.material, true)) {
                model.materials.add(object.material);
            }
            if (model.meshParts.contains(object.meshPart, true)) continue;
            model.meshParts.add(object.meshPart);
            if (!model.meshes.contains(object.meshPart.mesh, true)) {
                model.meshes.add(object.meshPart.mesh);
            }
            model.manageDisposable(object.meshPart.mesh);
        }
        for (Node node2 : node.getChildren()) {
            ModelBuilder.rebuildReferences(model, node2);
        }
    }

    public Model createXYZCoordinates(float f2, float f3, float f4, int n2, int n3, Material material, long l2) {
        this.begin();
        Node node = this.node();
        MeshPartBuilder meshPartBuilder = this.part("xyz", n3, l2, material);
        meshPartBuilder.setColor(Color.RED);
        meshPartBuilder.arrow(0.0f, 0.0f, 0.0f, f2, 0.0f, 0.0f, f3, f4, n2);
        meshPartBuilder.setColor(Color.GREEN);
        meshPartBuilder.arrow(0.0f, 0.0f, 0.0f, 0.0f, f2, 0.0f, f3, f4, n2);
        meshPartBuilder.setColor(Color.BLUE);
        meshPartBuilder.arrow(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, f2, f3, f4, n2);
        return this.end();
    }

    public Model createXYZCoordinates(float f2, Material material, long l2) {
        return this.createXYZCoordinates(f2, 0.1f, 0.1f, 5, 4, material, l2);
    }

    public Model createArrow(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, int n2, int n3, Material material, long l2) {
        this.begin();
        this.part("arrow", n3, l2, material).arrow(f2, f3, f4, f5, f6, f7, f8, f9, n2);
        return this.end();
    }

    public Model createArrow(Vector3 vector3, Vector3 vector32, Material material, long l2) {
        return this.createArrow(vector3.x, vector3.y, vector3.z, vector32.x, vector32.y, vector32.z, 0.1f, 0.1f, 5, 4, material, l2);
    }

    public Model createLineGrid(int n2, int n3, float f2, float f3, Material material, long l2) {
        int n4;
        this.begin();
        MeshPartBuilder meshPartBuilder = this.part("lines", 1, l2, material);
        float f4 = (float)n2 * f2;
        float f5 = (float)n3 * f3;
        float f6 = f4 / 2.0f;
        float f7 = f5 / 2.0f;
        float f8 = -f6;
        float f9 = 0.0f;
        float f10 = f7;
        float f11 = -f6;
        float f12 = 0.0f;
        float f13 = -f7;
        for (n4 = 0; n4 <= n2; ++n4) {
            meshPartBuilder.line(f8, f9, f10, f11, f12, f13);
            f8 += f2;
            f11 += f2;
        }
        f8 = -f6;
        f9 = 0.0f;
        f10 = -f7;
        f11 = f6;
        f12 = 0.0f;
        f13 = -f7;
        for (n4 = 0; n4 <= n3; ++n4) {
            meshPartBuilder.line(f8, f9, f10, f11, f12, f13);
            f10 += f3;
            f13 += f3;
        }
        return this.end();
    }
}

