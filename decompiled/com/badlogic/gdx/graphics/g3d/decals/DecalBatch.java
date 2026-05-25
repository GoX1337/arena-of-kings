/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.decals;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.g3d.decals.Decal;
import com.badlogic.gdx.graphics.g3d.decals.DecalMaterial;
import com.badlogic.gdx.graphics.g3d.decals.GroupStrategy;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.Pool;
import com.badlogic.gdx.utils.SortedIntList;

public class DecalBatch
implements Disposable {
    private static final int DEFAULT_SIZE = 1000;
    private float[] vertices;
    private Mesh mesh;
    private final SortedIntList<Array<Decal>> groupList = new SortedIntList();
    private GroupStrategy groupStrategy;
    private final Pool<Array<Decal>> groupPool = new Pool<Array<Decal>>(16){

        @Override
        protected Array<Decal> newObject() {
            return new Array<Decal>(false, 100);
        }
    };
    private final Array<Array<Decal>> usedGroups = new Array(16);

    public DecalBatch(GroupStrategy groupStrategy) {
        this(1000, groupStrategy);
    }

    public DecalBatch(int n2, GroupStrategy groupStrategy) {
        this.initialize(n2);
        this.setGroupStrategy(groupStrategy);
    }

    public void setGroupStrategy(GroupStrategy groupStrategy) {
        this.groupStrategy = groupStrategy;
    }

    public void initialize(int n2) {
        this.vertices = new float[n2 * 24];
        Mesh.VertexDataType vertexDataType = Mesh.VertexDataType.VertexArray;
        if (Gdx.gl30 != null) {
            vertexDataType = Mesh.VertexDataType.VertexBufferObjectWithVAO;
        }
        this.mesh = new Mesh(vertexDataType, false, n2 * 4, n2 * 6, new VertexAttribute(1, 3, "a_position"), new VertexAttribute(4, 4, "a_color"), new VertexAttribute(16, 2, "a_texCoord0"));
        short[] sArray = new short[n2 * 6];
        int n3 = 0;
        int n4 = 0;
        while (n4 < sArray.length) {
            sArray[n4] = (short)n3;
            sArray[n4 + 1] = (short)(n3 + 2);
            sArray[n4 + 2] = (short)(n3 + 1);
            sArray[n4 + 3] = (short)(n3 + 1);
            sArray[n4 + 4] = (short)(n3 + 2);
            sArray[n4 + 5] = (short)(n3 + 3);
            n4 += 6;
            n3 += 4;
        }
        this.mesh.setIndices(sArray);
    }

    public int getSize() {
        return this.vertices.length / 24;
    }

    public void add(Decal decal) {
        int n2 = this.groupStrategy.decideGroup(decal);
        Array<Decal> array = this.groupList.get(n2);
        if (array == null) {
            array = this.groupPool.obtain();
            array.clear();
            this.usedGroups.add(array);
            this.groupList.insert(n2, array);
        }
        array.add(decal);
    }

    public void flush() {
        this.render();
        this.clear();
    }

    protected void render() {
        this.groupStrategy.beforeGroups();
        for (SortedIntList.Node<Array<Decal>> node : this.groupList) {
            this.groupStrategy.beforeGroup(node.index, (Array)node.value);
            ShaderProgram shaderProgram = this.groupStrategy.getGroupShader(node.index);
            this.render(shaderProgram, (Array)node.value);
            this.groupStrategy.afterGroup(node.index);
        }
        this.groupStrategy.afterGroups();
    }

    private void render(ShaderProgram shaderProgram, Array<Decal> array) {
        DecalMaterial decalMaterial = null;
        int n2 = 0;
        for (Decal decal : array) {
            if (decalMaterial == null || !decalMaterial.equals(decal.getMaterial())) {
                if (n2 > 0) {
                    this.flush(shaderProgram, n2);
                    n2 = 0;
                }
                decal.material.set();
                decalMaterial = decal.material;
            }
            decal.update();
            System.arraycopy(decal.vertices, 0, this.vertices, n2, decal.vertices.length);
            if ((n2 += decal.vertices.length) != this.vertices.length) continue;
            this.flush(shaderProgram, n2);
            n2 = 0;
        }
        if (n2 > 0) {
            this.flush(shaderProgram, n2);
        }
    }

    protected void flush(ShaderProgram shaderProgram, int n2) {
        this.mesh.setVertices(this.vertices, 0, n2);
        this.mesh.render(shaderProgram, 4, 0, n2 / 4);
    }

    protected void clear() {
        this.groupList.clear();
        this.groupPool.freeAll(this.usedGroups);
        this.usedGroups.clear();
    }

    @Override
    public void dispose() {
        this.clear();
        this.vertices = null;
        this.mesh.dispose();
    }
}

