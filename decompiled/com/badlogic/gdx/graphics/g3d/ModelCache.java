/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Renderable;
import com.badlogic.gdx.graphics.g3d.RenderableProvider;
import com.badlogic.gdx.graphics.g3d.model.MeshPart;
import com.badlogic.gdx.graphics.g3d.utils.MeshBuilder;
import com.badlogic.gdx.graphics.g3d.utils.RenderableSorter;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.FlushablePool;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.Pool;
import java.util.Comparator;

public class ModelCache
implements RenderableProvider,
Disposable {
    private Array<Renderable> renderables = new Array();
    private FlushablePool<Renderable> renderablesPool = new FlushablePool<Renderable>(){

        @Override
        protected Renderable newObject() {
            return new Renderable();
        }
    };
    private FlushablePool<MeshPart> meshPartPool = new FlushablePool<MeshPart>(){

        @Override
        protected MeshPart newObject() {
            return new MeshPart();
        }
    };
    private Array<Renderable> items = new Array();
    private Array<Renderable> tmp = new Array();
    private MeshBuilder meshBuilder;
    private boolean building;
    private RenderableSorter sorter;
    private MeshPool meshPool;
    private Camera camera;

    public ModelCache() {
        this(new Sorter(), new SimpleMeshPool());
    }

    public ModelCache(RenderableSorter renderableSorter, MeshPool meshPool) {
        this.sorter = renderableSorter;
        this.meshPool = meshPool;
        this.meshBuilder = new MeshBuilder();
    }

    public void begin() {
        this.begin(null);
    }

    public void begin(Camera camera) {
        if (this.building) {
            throw new GdxRuntimeException("Call end() after calling begin()");
        }
        this.building = true;
        this.camera = camera;
        this.renderablesPool.flush();
        this.renderables.clear();
        this.items.clear();
        this.meshPartPool.flush();
        this.meshPool.flush();
    }

    private Renderable obtainRenderable(Material material, int n2) {
        Renderable renderable = this.renderablesPool.obtain();
        renderable.bones = null;
        renderable.environment = null;
        renderable.material = material;
        renderable.meshPart.mesh = null;
        renderable.meshPart.offset = 0;
        renderable.meshPart.size = 0;
        renderable.meshPart.primitiveType = n2;
        renderable.meshPart.center.set(0.0f, 0.0f, 0.0f);
        renderable.meshPart.halfExtents.set(0.0f, 0.0f, 0.0f);
        renderable.meshPart.radius = -1.0f;
        renderable.shader = null;
        renderable.userData = null;
        renderable.worldTransform.idt();
        return renderable;
    }

    public void end() {
        if (!this.building) {
            throw new GdxRuntimeException("Call begin() prior to calling end()");
        }
        this.building = false;
        if (this.items.size == 0) {
            return;
        }
        this.sorter.sort(this.camera, this.items);
        int n2 = this.items.size;
        int n3 = this.renderables.size;
        Renderable renderable = this.items.get(0);
        VertexAttributes vertexAttributes = renderable.meshPart.mesh.getVertexAttributes();
        Material material = renderable.material;
        int n4 = renderable.meshPart.primitiveType;
        int n5 = this.renderables.size;
        this.meshBuilder.begin(vertexAttributes);
        Object object = this.meshBuilder.part("", n4, this.meshPartPool.obtain());
        this.renderables.add(this.obtainRenderable(material, n4));
        int n6 = this.items.size;
        for (int i2 = 0; i2 < n6; ++i2) {
            boolean bl2;
            Renderable renderable2 = this.items.get(i2);
            VertexAttributes vertexAttributes2 = renderable2.meshPart.mesh.getVertexAttributes();
            Material material2 = renderable2.material;
            int n7 = renderable2.meshPart.primitiveType;
            boolean bl3 = vertexAttributes2.equals(vertexAttributes);
            boolean bl4 = renderable2.meshPart.mesh.getNumIndices() > 0;
            int n8 = bl4 ? renderable2.meshPart.mesh.getNumVertices() : renderable2.meshPart.size;
            boolean bl5 = this.meshBuilder.getNumVertices() + n8 <= 65536;
            boolean bl6 = bl3 && bl5;
            boolean bl7 = bl2 = bl6 && n7 == n4 && material2.same(material, true);
            if (!bl2) {
                Object object2;
                if (!bl6) {
                    object2 = this.meshBuilder.end(this.meshPool.obtain(vertexAttributes, this.meshBuilder.getNumVertices(), this.meshBuilder.getNumIndices()));
                    while (n5 < this.renderables.size) {
                        this.renderables.get((int)n5++).meshPart.mesh = object2;
                    }
                    vertexAttributes = vertexAttributes2;
                    this.meshBuilder.begin(vertexAttributes);
                }
                object2 = this.meshBuilder.part("", n7, this.meshPartPool.obtain());
                Renderable renderable3 = this.renderables.get(this.renderables.size - 1);
                renderable3.meshPart.offset = ((MeshPart)object).offset;
                renderable3.meshPart.size = ((MeshPart)object).size;
                object = object2;
                material = material2;
                n4 = n7;
                this.renderables.add(this.obtainRenderable(material, n4));
            }
            this.meshBuilder.setVertexTransform(renderable2.worldTransform);
            this.meshBuilder.addMesh(renderable2.meshPart.mesh, renderable2.meshPart.offset, renderable2.meshPart.size);
        }
        Mesh mesh = this.meshBuilder.end(this.meshPool.obtain(vertexAttributes, this.meshBuilder.getNumVertices(), this.meshBuilder.getNumIndices()));
        while (n5 < this.renderables.size) {
            this.renderables.get((int)n5++).meshPart.mesh = mesh;
        }
        Renderable renderable4 = this.renderables.get(this.renderables.size - 1);
        renderable4.meshPart.offset = ((MeshPart)object).offset;
        renderable4.meshPart.size = ((MeshPart)object).size;
    }

    public void add(Renderable renderable) {
        if (!this.building) {
            throw new GdxRuntimeException("Can only add items to the ModelCache in between .begin() and .end()");
        }
        if (renderable.bones == null) {
            this.items.add(renderable);
        } else {
            this.renderables.add(renderable);
        }
    }

    public void add(RenderableProvider renderableProvider) {
        renderableProvider.getRenderables(this.tmp, this.renderablesPool);
        int n2 = this.tmp.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            this.add(this.tmp.get(i2));
        }
        this.tmp.clear();
    }

    public <T extends RenderableProvider> void add(Iterable<T> iterable) {
        for (RenderableProvider renderableProvider : iterable) {
            this.add(renderableProvider);
        }
    }

    @Override
    public void getRenderables(Array<Renderable> array, Pool<Renderable> pool) {
        if (this.building) {
            throw new GdxRuntimeException("Cannot render a ModelCache in between .begin() and .end()");
        }
        for (Renderable renderable : this.renderables) {
            renderable.shader = null;
            renderable.environment = null;
        }
        array.addAll(this.renderables);
    }

    @Override
    public void dispose() {
        if (this.building) {
            throw new GdxRuntimeException("Cannot dispose a ModelCache in between .begin() and .end()");
        }
        this.meshPool.dispose();
    }

    public static class Sorter
    implements RenderableSorter,
    Comparator<Renderable> {
        @Override
        public void sort(Camera camera, Array<Renderable> array) {
            array.sort(this);
        }

        @Override
        public int compare(Renderable renderable, Renderable renderable2) {
            VertexAttributes vertexAttributes;
            VertexAttributes vertexAttributes2 = renderable.meshPart.mesh.getVertexAttributes();
            int n2 = vertexAttributes2.compareTo(vertexAttributes = renderable2.meshPart.mesh.getVertexAttributes());
            if (n2 == 0) {
                int n3 = renderable.material.compareTo(renderable2.material);
                if (n3 == 0) {
                    return renderable.meshPart.primitiveType - renderable2.meshPart.primitiveType;
                }
                return n3;
            }
            return n2;
        }
    }

    public static class TightMeshPool
    implements MeshPool {
        private Array<Mesh> freeMeshes = new Array();
        private Array<Mesh> usedMeshes = new Array();

        @Override
        public void flush() {
            this.freeMeshes.addAll(this.usedMeshes);
            this.usedMeshes.clear();
        }

        @Override
        public Mesh obtain(VertexAttributes vertexAttributes, int n2, int n3) {
            int n4 = this.freeMeshes.size;
            for (int i2 = 0; i2 < n4; ++i2) {
                Mesh mesh = this.freeMeshes.get(i2);
                if (!mesh.getVertexAttributes().equals(vertexAttributes) || mesh.getMaxVertices() != n2 || mesh.getMaxIndices() != n3) continue;
                this.freeMeshes.removeIndex(i2);
                this.usedMeshes.add(mesh);
                return mesh;
            }
            Mesh mesh = new Mesh(true, n2, n3, vertexAttributes);
            this.usedMeshes.add(mesh);
            return mesh;
        }

        @Override
        public void dispose() {
            for (Mesh mesh : this.usedMeshes) {
                mesh.dispose();
            }
            this.usedMeshes.clear();
            for (Mesh mesh : this.freeMeshes) {
                mesh.dispose();
            }
            this.freeMeshes.clear();
        }
    }

    public static class SimpleMeshPool
    implements MeshPool {
        private Array<Mesh> freeMeshes = new Array();
        private Array<Mesh> usedMeshes = new Array();

        @Override
        public void flush() {
            this.freeMeshes.addAll(this.usedMeshes);
            this.usedMeshes.clear();
        }

        @Override
        public Mesh obtain(VertexAttributes vertexAttributes, int n2, int n3) {
            int n4 = this.freeMeshes.size;
            for (int i2 = 0; i2 < n4; ++i2) {
                Mesh mesh = this.freeMeshes.get(i2);
                if (!mesh.getVertexAttributes().equals(vertexAttributes) || mesh.getMaxVertices() < n2 || mesh.getMaxIndices() < n3) continue;
                this.freeMeshes.removeIndex(i2);
                this.usedMeshes.add(mesh);
                return mesh;
            }
            n2 = 65536;
            n3 = Math.max(n2, 1 << 32 - Integer.numberOfLeadingZeros(n3 - 1));
            Mesh mesh = new Mesh(false, n2, n3, vertexAttributes);
            this.usedMeshes.add(mesh);
            return mesh;
        }

        @Override
        public void dispose() {
            for (Mesh mesh : this.usedMeshes) {
                mesh.dispose();
            }
            this.usedMeshes.clear();
            for (Mesh mesh : this.freeMeshes) {
                mesh.dispose();
            }
            this.freeMeshes.clear();
        }
    }

    public static interface MeshPool
    extends Disposable {
        public Mesh obtain(VertexAttributes var1, int var2, int var3);

        public void flush();
    }
}

