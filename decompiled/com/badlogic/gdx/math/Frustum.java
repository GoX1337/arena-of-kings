/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.math;

import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Plane;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.BoundingBox;

public class Frustum {
    protected static final Vector3[] clipSpacePlanePoints = new Vector3[]{new Vector3(-1.0f, -1.0f, -1.0f), new Vector3(1.0f, -1.0f, -1.0f), new Vector3(1.0f, 1.0f, -1.0f), new Vector3(-1.0f, 1.0f, -1.0f), new Vector3(-1.0f, -1.0f, 1.0f), new Vector3(1.0f, -1.0f, 1.0f), new Vector3(1.0f, 1.0f, 1.0f), new Vector3(-1.0f, 1.0f, 1.0f)};
    protected static final float[] clipSpacePlanePointsArray = new float[24];
    private static final Vector3 tmpV;
    public final Plane[] planes = new Plane[6];
    public final Vector3[] planePoints = new Vector3[]{new Vector3(), new Vector3(), new Vector3(), new Vector3(), new Vector3(), new Vector3(), new Vector3(), new Vector3()};
    protected final float[] planePointsArray = new float[24];

    public Frustum() {
        for (int i2 = 0; i2 < 6; ++i2) {
            this.planes[i2] = new Plane(new Vector3(), 0.0f);
        }
    }

    public void update(Matrix4 matrix4) {
        System.arraycopy(clipSpacePlanePointsArray, 0, this.planePointsArray, 0, clipSpacePlanePointsArray.length);
        Matrix4.prj(matrix4.val, this.planePointsArray, 0, 8, 3);
        int n2 = 0;
        for (int i2 = 0; i2 < 8; ++i2) {
            Vector3 vector3 = this.planePoints[i2];
            vector3.x = this.planePointsArray[n2++];
            vector3.y = this.planePointsArray[n2++];
            vector3.z = this.planePointsArray[n2++];
        }
        this.planes[0].set(this.planePoints[1], this.planePoints[0], this.planePoints[2]);
        this.planes[1].set(this.planePoints[4], this.planePoints[5], this.planePoints[7]);
        this.planes[2].set(this.planePoints[0], this.planePoints[4], this.planePoints[3]);
        this.planes[3].set(this.planePoints[5], this.planePoints[1], this.planePoints[6]);
        this.planes[4].set(this.planePoints[2], this.planePoints[3], this.planePoints[6]);
        this.planes[5].set(this.planePoints[4], this.planePoints[0], this.planePoints[1]);
    }

    public boolean pointInFrustum(Vector3 vector3) {
        for (int i2 = 0; i2 < this.planes.length; ++i2) {
            Plane.PlaneSide planeSide = this.planes[i2].testPoint(vector3);
            if (planeSide != Plane.PlaneSide.Back) continue;
            return false;
        }
        return true;
    }

    public boolean pointInFrustum(float f2, float f3, float f4) {
        for (int i2 = 0; i2 < this.planes.length; ++i2) {
            Plane.PlaneSide planeSide = this.planes[i2].testPoint(f2, f3, f4);
            if (planeSide != Plane.PlaneSide.Back) continue;
            return false;
        }
        return true;
    }

    public boolean sphereInFrustum(Vector3 vector3, float f2) {
        for (int i2 = 0; i2 < 6; ++i2) {
            if (!(this.planes[i2].normal.x * vector3.x + this.planes[i2].normal.y * vector3.y + this.planes[i2].normal.z * vector3.z < -f2 - this.planes[i2].d)) continue;
            return false;
        }
        return true;
    }

    public boolean sphereInFrustum(float f2, float f3, float f4, float f5) {
        for (int i2 = 0; i2 < 6; ++i2) {
            if (!(this.planes[i2].normal.x * f2 + this.planes[i2].normal.y * f3 + this.planes[i2].normal.z * f4 < -f5 - this.planes[i2].d)) continue;
            return false;
        }
        return true;
    }

    public boolean sphereInFrustumWithoutNearFar(Vector3 vector3, float f2) {
        for (int i2 = 2; i2 < 6; ++i2) {
            if (!(this.planes[i2].normal.x * vector3.x + this.planes[i2].normal.y * vector3.y + this.planes[i2].normal.z * vector3.z < -f2 - this.planes[i2].d)) continue;
            return false;
        }
        return true;
    }

    public boolean sphereInFrustumWithoutNearFar(float f2, float f3, float f4, float f5) {
        for (int i2 = 2; i2 < 6; ++i2) {
            if (!(this.planes[i2].normal.x * f2 + this.planes[i2].normal.y * f3 + this.planes[i2].normal.z * f4 < -f5 - this.planes[i2].d)) continue;
            return false;
        }
        return true;
    }

    public boolean boundsInFrustum(BoundingBox boundingBox) {
        int n2 = this.planes.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (this.planes[i2].testPoint(boundingBox.getCorner000(tmpV)) != Plane.PlaneSide.Back || this.planes[i2].testPoint(boundingBox.getCorner001(tmpV)) != Plane.PlaneSide.Back || this.planes[i2].testPoint(boundingBox.getCorner010(tmpV)) != Plane.PlaneSide.Back || this.planes[i2].testPoint(boundingBox.getCorner011(tmpV)) != Plane.PlaneSide.Back || this.planes[i2].testPoint(boundingBox.getCorner100(tmpV)) != Plane.PlaneSide.Back || this.planes[i2].testPoint(boundingBox.getCorner101(tmpV)) != Plane.PlaneSide.Back || this.planes[i2].testPoint(boundingBox.getCorner110(tmpV)) != Plane.PlaneSide.Back || this.planes[i2].testPoint(boundingBox.getCorner111(tmpV)) != Plane.PlaneSide.Back) continue;
            return false;
        }
        return true;
    }

    public boolean boundsInFrustum(Vector3 vector3, Vector3 vector32) {
        return this.boundsInFrustum(vector3.x, vector3.y, vector3.z, vector32.x / 2.0f, vector32.y / 2.0f, vector32.z / 2.0f);
    }

    public boolean boundsInFrustum(float f2, float f3, float f4, float f5, float f6, float f7) {
        int n2 = this.planes.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (this.planes[i2].testPoint(f2 + f5, f3 + f6, f4 + f7) != Plane.PlaneSide.Back || this.planes[i2].testPoint(f2 + f5, f3 + f6, f4 - f7) != Plane.PlaneSide.Back || this.planes[i2].testPoint(f2 + f5, f3 - f6, f4 + f7) != Plane.PlaneSide.Back || this.planes[i2].testPoint(f2 + f5, f3 - f6, f4 - f7) != Plane.PlaneSide.Back || this.planes[i2].testPoint(f2 - f5, f3 + f6, f4 + f7) != Plane.PlaneSide.Back || this.planes[i2].testPoint(f2 - f5, f3 + f6, f4 - f7) != Plane.PlaneSide.Back || this.planes[i2].testPoint(f2 - f5, f3 - f6, f4 + f7) != Plane.PlaneSide.Back || this.planes[i2].testPoint(f2 - f5, f3 - f6, f4 - f7) != Plane.PlaneSide.Back) continue;
            return false;
        }
        return true;
    }

    static {
        int n2 = 0;
        for (Vector3 vector3 : clipSpacePlanePoints) {
            Frustum.clipSpacePlanePointsArray[n2++] = vector3.x;
            Frustum.clipSpacePlanePointsArray[n2++] = vector3.y;
            Frustum.clipSpacePlanePointsArray[n2++] = vector3.z;
        }
        tmpV = new Vector3();
    }
}

