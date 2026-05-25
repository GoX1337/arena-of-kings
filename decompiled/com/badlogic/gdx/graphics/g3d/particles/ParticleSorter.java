/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.particles;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g3d.particles.renderers.ParticleControllerRenderData;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;

public abstract class ParticleSorter {
    static final Vector3 TMP_V1 = new Vector3();
    protected Camera camera;

    public abstract <T extends ParticleControllerRenderData> int[] sort(Array<T> var1);

    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    public void ensureCapacity(int n2) {
    }

    public static class Distance
    extends ParticleSorter {
        private float[] distances;
        private int[] particleIndices;
        private int[] particleOffsets;
        private int currentSize = 0;

        @Override
        public void ensureCapacity(int n2) {
            if (this.currentSize < n2) {
                this.distances = new float[n2];
                this.particleIndices = new int[n2];
                this.particleOffsets = new int[n2];
                this.currentSize = n2;
            }
        }

        @Override
        public <T extends ParticleControllerRenderData> int[] sort(Array<T> array) {
            float[] fArray = this.camera.view.val;
            float f2 = fArray[2];
            float f3 = fArray[6];
            float f4 = fArray[10];
            int n2 = 0;
            int n3 = 0;
            for (ParticleControllerRenderData particleControllerRenderData : array) {
                int n4 = 0;
                int n5 = n3 + particleControllerRenderData.controller.particles.size;
                while (n3 < n5) {
                    this.distances[n3] = f2 * particleControllerRenderData.positionChannel.data[n4 + 0] + f3 * particleControllerRenderData.positionChannel.data[n4 + 1] + f4 * particleControllerRenderData.positionChannel.data[n4 + 2];
                    this.particleIndices[n3] = n3;
                    ++n3;
                    n4 += particleControllerRenderData.positionChannel.strideSize;
                }
                n2 += particleControllerRenderData.controller.particles.size;
            }
            this.qsort(0, n2 - 1);
            for (n3 = 0; n3 < n2; ++n3) {
                this.particleOffsets[this.particleIndices[n3]] = n3;
            }
            return this.particleOffsets;
        }

        public void qsort(int n2, int n3) {
            if (n2 < n3) {
                if (n3 - n2 <= 8) {
                    for (int i2 = n2; i2 <= n3; ++i2) {
                        for (int i3 = i2; i3 > n2 && this.distances[i3 - 1] > this.distances[i3]; --i3) {
                            float f2 = this.distances[i3];
                            this.distances[i3] = this.distances[i3 - 1];
                            this.distances[i3 - 1] = f2;
                            int n4 = this.particleIndices[i3];
                            this.particleIndices[i3] = this.particleIndices[i3 - 1];
                            this.particleIndices[i3 - 1] = n4;
                        }
                    }
                    return;
                }
                float f3 = this.distances[n2];
                int n5 = n2 + 1;
                int n6 = this.particleIndices[n2];
                for (int i4 = n2 + 1; i4 <= n3; ++i4) {
                    if (!(f3 > this.distances[i4])) continue;
                    if (i4 > n5) {
                        float f4 = this.distances[i4];
                        this.distances[i4] = this.distances[n5];
                        this.distances[n5] = f4;
                        int n7 = this.particleIndices[i4];
                        this.particleIndices[i4] = this.particleIndices[n5];
                        this.particleIndices[n5] = n7;
                    }
                    ++n5;
                }
                this.distances[n2] = this.distances[n5 - 1];
                this.distances[n5 - 1] = f3;
                this.particleIndices[n2] = this.particleIndices[n5 - 1];
                this.particleIndices[n5 - 1] = n6;
                this.qsort(n2, n5 - 2);
                this.qsort(n5, n3);
            }
        }
    }

    public static class None
    extends ParticleSorter {
        int currentCapacity = 0;
        int[] indices;

        @Override
        public void ensureCapacity(int n2) {
            if (this.currentCapacity < n2) {
                this.indices = new int[n2];
                for (int i2 = 0; i2 < n2; ++i2) {
                    this.indices[i2] = i2;
                }
                this.currentCapacity = n2;
            }
        }

        @Override
        public <T extends ParticleControllerRenderData> int[] sort(Array<T> array) {
            return this.indices;
        }
    }
}

