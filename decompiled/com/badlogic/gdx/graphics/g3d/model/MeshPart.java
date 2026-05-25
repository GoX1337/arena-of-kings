/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.model;

import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.BoundingBox;

public class MeshPart {
    public String id;
    public int primitiveType;
    public int offset;
    public int size;
    public Mesh mesh;
    public final Vector3 center = new Vector3();
    public final Vector3 halfExtents = new Vector3();
    public float radius = -1.0f;
    private static final BoundingBox bounds = new BoundingBox();

    public MeshPart() {
    }

    public MeshPart(String string, Mesh mesh, int n2, int n3, int n4) {
        this.set(string, mesh, n2, n3, n4);
    }

    public MeshPart(MeshPart meshPart) {
        this.set(meshPart);
    }

    public MeshPart set(MeshPart meshPart) {
        this.id = meshPart.id;
        this.mesh = meshPart.mesh;
        this.offset = meshPart.offset;
        this.size = meshPart.size;
        this.primitiveType = meshPart.primitiveType;
        this.center.set(meshPart.center);
        this.halfExtents.set(meshPart.halfExtents);
        this.radius = meshPart.radius;
        return this;
    }

    public MeshPart set(String string, Mesh mesh, int n2, int n3, int n4) {
        this.id = string;
        this.mesh = mesh;
        this.offset = n2;
        this.size = n3;
        this.primitiveType = n4;
        this.center.set(0.0f, 0.0f, 0.0f);
        this.halfExtents.set(0.0f, 0.0f, 0.0f);
        this.radius = -1.0f;
        return this;
    }

    public void update() {
        this.mesh.calculateBoundingBox(bounds, this.offset, this.size);
        bounds.getCenter(this.center);
        bounds.getDimensions(this.halfExtents).scl(0.5f);
        this.radius = this.halfExtents.len();
    }

    public boolean equals(MeshPart meshPart) {
        return meshPart == this || meshPart != null && meshPart.mesh == this.mesh && meshPart.primitiveType == this.primitiveType && meshPart.offset == this.offset && meshPart.size == this.size;
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (object == this) {
            return true;
        }
        if (!(object instanceof MeshPart)) {
            return false;
        }
        return this.equals((MeshPart)object);
    }

    public void render(ShaderProgram shaderProgram, boolean bl2) {
        this.mesh.render(shaderProgram, this.primitiveType, this.offset, this.size, bl2);
    }

    public void render(ShaderProgram shaderProgram) {
        this.mesh.render(shaderProgram, this.primitiveType, this.offset, this.size);
    }
}

