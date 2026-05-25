/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.math;

import com.badlogic.gdx.math.Frustum;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.BoundingBox;
import com.badlogic.gdx.math.collision.Ray;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ObjectSet;
import com.badlogic.gdx.utils.Pool;
import java.util.Iterator;

public class Octree<T> {
    final int maxItemsPerNode;
    final Pool<OctreeNode> nodePool = new Pool<OctreeNode>(){

        @Override
        protected OctreeNode newObject() {
            return new OctreeNode();
        }
    };
    protected OctreeNode root;
    final Collider<T> collider;
    static final Vector3 tmp = new Vector3();

    public Octree(Vector3 vector3, Vector3 vector32, int n2, int n3, Collider<T> collider) {
        Vector3 vector33 = new Vector3(Math.min(vector3.x, vector32.x), Math.min(vector3.y, vector32.y), Math.min(vector3.z, vector32.z));
        Vector3 vector34 = new Vector3(Math.max(vector3.x, vector32.x), Math.max(vector3.y, vector32.y), Math.max(vector3.z, vector32.z));
        this.root = this.createNode(vector33, vector34, n2);
        this.collider = collider;
        this.maxItemsPerNode = n3;
    }

    OctreeNode createNode(Vector3 vector3, Vector3 vector32, int n2) {
        OctreeNode octreeNode = this.nodePool.obtain();
        octreeNode.bounds.set(vector3, vector32);
        octreeNode.level = n2;
        octreeNode.leaf = true;
        return octreeNode;
    }

    public void add(T t2) {
        this.root.add(t2);
    }

    public void remove(T t2) {
        this.root.remove(t2);
    }

    public void update(T t2) {
        this.root.remove(t2);
        this.root.add(t2);
    }

    public ObjectSet<T> getAll(ObjectSet<T> objectSet) {
        this.root.getAll(objectSet);
        return objectSet;
    }

    public ObjectSet<T> query(BoundingBox boundingBox, ObjectSet<T> objectSet) {
        this.root.query(boundingBox, objectSet);
        return objectSet;
    }

    public ObjectSet<T> query(Frustum frustum, ObjectSet<T> objectSet) {
        this.root.query(frustum, objectSet);
        return objectSet;
    }

    public T rayCast(Ray ray, RayCastResult<T> rayCastResult) {
        rayCastResult.distance = rayCastResult.maxDistanceSq;
        this.root.rayCast(ray, rayCastResult);
        return rayCastResult.geometry;
    }

    public ObjectSet<BoundingBox> getNodesBoxes(ObjectSet<BoundingBox> objectSet) {
        this.root.getBoundingBox(objectSet);
        return objectSet;
    }

    public static class RayCastResult<T> {
        T geometry;
        float distance;
        float maxDistanceSq = Float.MAX_VALUE;
    }

    public static interface Collider<T> {
        public boolean intersects(BoundingBox var1, T var2);

        public boolean intersects(Frustum var1, T var2);

        public float intersects(Ray var1, T var2);
    }

    protected class OctreeNode {
        int level;
        final BoundingBox bounds = new BoundingBox();
        boolean leaf;
        private OctreeNode[] children;
        private final Array<T> geometries;

        protected OctreeNode() {
            this.geometries = new Array(Math.min(16, Octree.this.maxItemsPerNode));
        }

        private void split() {
            float f2 = (this.bounds.max.x + this.bounds.min.x) * 0.5f;
            float f3 = (this.bounds.max.y + this.bounds.min.y) * 0.5f;
            float f4 = (this.bounds.max.z + this.bounds.min.z) * 0.5f;
            int n2 = this.level - 1;
            this.leaf = false;
            if (this.children == null) {
                this.children = new OctreeNode[8];
            }
            this.children[0] = Octree.this.createNode(new Vector3(this.bounds.min.x, f3, f4), new Vector3(f2, this.bounds.max.y, this.bounds.max.z), n2);
            this.children[1] = Octree.this.createNode(new Vector3(f2, f3, f4), new Vector3(this.bounds.max.x, this.bounds.max.y, this.bounds.max.z), n2);
            this.children[2] = Octree.this.createNode(new Vector3(f2, f3, this.bounds.min.z), new Vector3(this.bounds.max.x, this.bounds.max.y, f4), n2);
            this.children[3] = Octree.this.createNode(new Vector3(this.bounds.min.x, f3, this.bounds.min.z), new Vector3(f2, this.bounds.max.y, f4), n2);
            this.children[4] = Octree.this.createNode(new Vector3(this.bounds.min.x, this.bounds.min.y, f4), new Vector3(f2, f3, this.bounds.max.z), n2);
            this.children[5] = Octree.this.createNode(new Vector3(f2, this.bounds.min.y, f4), new Vector3(this.bounds.max.x, f3, this.bounds.max.z), n2);
            this.children[6] = Octree.this.createNode(new Vector3(f2, this.bounds.min.y, this.bounds.min.z), new Vector3(this.bounds.max.x, f3, f4), n2);
            this.children[7] = Octree.this.createNode(new Vector3(this.bounds.min.x, this.bounds.min.y, this.bounds.min.z), new Vector3(f2, f3, f4), n2);
            for (OctreeNode octreeNode : this.children) {
                for (Object e2 : this.geometries) {
                    octreeNode.add(e2);
                }
            }
            this.geometries.clear();
        }

        private void merge() {
            this.clearChildren();
            this.leaf = true;
        }

        private void free() {
            this.geometries.clear();
            if (!this.leaf) {
                this.clearChildren();
            }
            Octree.this.nodePool.free(this);
        }

        private void clearChildren() {
            for (int i2 = 0; i2 < 8; ++i2) {
                this.children[i2].free();
                this.children[i2] = null;
            }
        }

        protected void add(T t2) {
            if (!Octree.this.collider.intersects(this.bounds, t2)) {
                return;
            }
            if (!this.leaf) {
                for (OctreeNode octreeNode : this.children) {
                    octreeNode.add(t2);
                }
            } else if (this.geometries.size >= Octree.this.maxItemsPerNode && this.level > 0) {
                this.split();
                for (OctreeNode octreeNode : this.children) {
                    octreeNode.add(t2);
                }
            } else {
                this.geometries.add(t2);
            }
        }

        protected boolean remove(T t2) {
            if (!this.leaf) {
                boolean bl2 = false;
                for (OctreeNode octreeNode : this.children) {
                    bl2 |= octreeNode.remove(t2);
                }
                if (bl2) {
                    ObjectSet objectSet = new ObjectSet();
                    for (OctreeNode octreeNode : this.children) {
                        octreeNode.getAll(objectSet);
                    }
                    if (objectSet.size <= Octree.this.maxItemsPerNode) {
                        Iterator iterator = objectSet.iterator();
                        while (iterator.hasNext()) {
                            Object e2 = iterator.next();
                            this.geometries.add(e2);
                        }
                        this.merge();
                    }
                }
                return bl2;
            }
            return this.geometries.removeValue(t2, true);
        }

        protected boolean isLeaf() {
            return this.leaf;
        }

        protected void query(BoundingBox boundingBox, ObjectSet<T> objectSet) {
            if (!boundingBox.intersects(this.bounds)) {
                return;
            }
            if (!this.leaf) {
                for (OctreeNode octreeNode : this.children) {
                    octreeNode.query(boundingBox, objectSet);
                }
            } else {
                for (Object e2 : this.geometries) {
                    if (!Octree.this.collider.intersects(this.bounds, e2)) continue;
                    objectSet.add(e2);
                }
            }
        }

        protected void query(Frustum frustum, ObjectSet<T> objectSet) {
            if (!Intersector.intersectFrustumBounds(frustum, this.bounds)) {
                return;
            }
            if (!this.leaf) {
                for (OctreeNode octreeNode : this.children) {
                    octreeNode.query(frustum, objectSet);
                }
            } else {
                for (Object e2 : this.geometries) {
                    if (!Octree.this.collider.intersects(frustum, e2)) continue;
                    objectSet.add(e2);
                }
            }
        }

        protected void rayCast(Ray ray, RayCastResult<T> rayCastResult) {
            boolean bl2 = Intersector.intersectRayBounds(ray, this.bounds, tmp);
            if (!bl2) {
                return;
            }
            float f2 = tmp.dst2(ray.origin);
            if (f2 >= rayCastResult.maxDistanceSq) {
                return;
            }
            if (!this.leaf) {
                for (OctreeNode octreeNode : this.children) {
                    octreeNode.rayCast(ray, rayCastResult);
                }
            } else {
                for (Object e2 : this.geometries) {
                    float f3 = Octree.this.collider.intersects(ray, e2);
                    if (rayCastResult.geometry != null && !(f3 < rayCastResult.distance)) continue;
                    rayCastResult.geometry = e2;
                    rayCastResult.distance = f3;
                }
            }
        }

        protected void getAll(ObjectSet<T> objectSet) {
            if (!this.leaf) {
                for (OctreeNode octreeNode : this.children) {
                    octreeNode.getAll(objectSet);
                }
            }
            objectSet.addAll(this.geometries);
        }

        protected void getBoundingBox(ObjectSet<BoundingBox> objectSet) {
            if (!this.leaf) {
                for (OctreeNode octreeNode : this.children) {
                    octreeNode.getBoundingBox(objectSet);
                }
            }
            objectSet.add(this.bounds);
        }
    }
}

