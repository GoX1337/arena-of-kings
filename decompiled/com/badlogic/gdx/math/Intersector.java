/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.math;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Frustum;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Plane;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.BoundingBox;
import com.badlogic.gdx.math.collision.Ray;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.FloatArray;
import java.util.Arrays;
import java.util.List;

public final class Intersector {
    private static final Vector3 v0 = new Vector3();
    private static final Vector3 v1 = new Vector3();
    private static final Vector3 v2 = new Vector3();
    private static final FloatArray floatArray = new FloatArray();
    private static final FloatArray floatArray2 = new FloatArray();
    private static final Vector2 ip = new Vector2();
    private static final Vector2 ep1 = new Vector2();
    private static final Vector2 ep2 = new Vector2();
    private static final Vector2 s = new Vector2();
    private static final Vector2 e = new Vector2();
    static Vector2 v2a = new Vector2();
    static Vector2 v2b = new Vector2();
    static Vector2 v2c = new Vector2();
    static Vector2 v2d = new Vector2();
    private static final Plane p = new Plane(new Vector3(), 0.0f);
    private static final Vector3 i = new Vector3();
    private static final Vector3 dir = new Vector3();
    private static final Vector3 start = new Vector3();
    static Vector3 best = new Vector3();
    static Vector3 tmp = new Vector3();
    static Vector3 tmp1 = new Vector3();
    static Vector3 tmp2 = new Vector3();
    static Vector3 tmp3 = new Vector3();
    static Vector3 intersection = new Vector3();

    private Intersector() {
    }

    public static boolean isPointInTriangle(Vector3 vector3, Vector3 vector32, Vector3 vector33, Vector3 vector34) {
        v0.set(vector32).sub(vector3);
        v1.set(vector33).sub(vector3);
        v2.set(vector34).sub(vector3);
        float f2 = v0.dot(v1);
        float f3 = v0.dot(v2);
        float f4 = v1.dot(v2);
        float f5 = v2.dot(v2);
        if (f4 * f3 - f5 * f2 < 0.0f) {
            return false;
        }
        float f6 = v1.dot(v1);
        return !(f2 * f4 - f3 * f6 < 0.0f);
    }

    public static boolean isPointInTriangle(Vector2 vector2, Vector2 vector22, Vector2 vector23, Vector2 vector24) {
        boolean bl2;
        float f2;
        float f3;
        if ((vector24.x - vector22.x) * f3 - (vector24.y - vector22.y) * f2 > 0.0f == (bl2 = (vector23.x - vector22.x) * (f3 = vector2.y - vector22.y) - (vector23.y - vector22.y) * (f2 = vector2.x - vector22.x) > 0.0f)) {
            return false;
        }
        return (vector24.x - vector23.x) * (vector2.y - vector23.y) - (vector24.y - vector23.y) * (vector2.x - vector23.x) > 0.0f == bl2;
    }

    public static boolean isPointInTriangle(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        boolean bl2;
        float f10;
        float f11;
        if ((f8 - f4) * f11 - (f9 - f5) * f10 > 0.0f == (bl2 = (f6 - f4) * (f11 = f3 - f5) - (f7 - f5) * (f10 = f2 - f4) > 0.0f)) {
            return false;
        }
        return (f8 - f6) * (f3 - f7) - (f9 - f7) * (f2 - f6) > 0.0f == bl2;
    }

    public static boolean intersectSegmentPlane(Vector3 vector3, Vector3 vector32, Plane plane, Vector3 vector33) {
        Vector3 vector34 = v0.set(vector32).sub(vector3);
        float f2 = vector34.dot(plane.getNormal());
        if (f2 == 0.0f) {
            return false;
        }
        float f3 = -(vector3.dot(plane.getNormal()) + plane.getD()) / f2;
        if (f3 < 0.0f || f3 > 1.0f) {
            return false;
        }
        vector33.set(vector3).add(vector34.scl(f3));
        return true;
    }

    public static int pointLineSide(Vector2 vector2, Vector2 vector22, Vector2 vector23) {
        return (int)Math.signum((vector22.x - vector2.x) * (vector23.y - vector2.y) - (vector22.y - vector2.y) * (vector23.x - vector2.x));
    }

    public static int pointLineSide(float f2, float f3, float f4, float f5, float f6, float f7) {
        return (int)Math.signum((f4 - f2) * (f7 - f3) - (f5 - f3) * (f6 - f2));
    }

    public static boolean isPointInPolygon(Array<Vector2> array, Vector2 vector2) {
        Vector2 vector22 = array.peek();
        float f2 = vector2.x;
        float f3 = vector2.y;
        boolean bl2 = false;
        for (int i2 = 0; i2 < array.size; ++i2) {
            Vector2 vector23 = array.get(i2);
            if ((vector23.y < f3 && vector22.y >= f3 || vector22.y < f3 && vector23.y >= f3) && vector23.x + (f3 - vector23.y) / (vector22.y - vector23.y) * (vector22.x - vector23.x) < f2) {
                bl2 = !bl2;
            }
            vector22 = vector23;
        }
        return bl2;
    }

    public static boolean isPointInPolygon(float[] fArray, int n2, int n3, float f2, float f3) {
        int n4;
        float f4;
        boolean bl2 = false;
        float f5 = fArray[n2];
        float f6 = f4 = fArray[n2 + 1];
        int n5 = n2 + n3;
        for (n4 = n2 + 3; n4 < n5; n4 += 2) {
            float f7;
            float f8 = fArray[n4];
            if ((f8 < f3 && f6 >= f3 || f6 < f3 && f8 >= f3) && (f7 = fArray[n4 - 1]) + (f3 - f8) / (f6 - f8) * (fArray[n4 - 3] - f7) < f2) {
                bl2 = !bl2;
            }
            f6 = f8;
        }
        if ((f4 < f3 && f6 >= f3 || f6 < f3 && f4 >= f3) && f5 + (f3 - f4) / (f6 - f4) * (fArray[n4 - 3] - f5) < f2) {
            bl2 = !bl2;
        }
        return bl2;
    }

    public static boolean intersectPolygons(Polygon polygon, Polygon polygon2, Polygon polygon3) {
        if (polygon.getVertices().length == 0 || polygon2.getVertices().length == 0) {
            return false;
        }
        Vector2 vector2 = ip;
        Vector2 vector22 = ep1;
        Vector2 vector23 = ep2;
        Vector2 vector24 = s;
        Vector2 vector25 = e;
        FloatArray floatArray = Intersector.floatArray;
        FloatArray floatArray2 = Intersector.floatArray2;
        floatArray.clear();
        floatArray2.clear();
        floatArray2.addAll(polygon.getTransformedVertices());
        float[] fArray = polygon2.getTransformedVertices();
        int n2 = fArray.length - 2;
        for (int i2 = 0; i2 <= n2; i2 += 2) {
            vector22.set(fArray[i2], fArray[i2 + 1]);
            if (i2 < n2) {
                vector23.set(fArray[i2 + 2], fArray[i2 + 3]);
            } else {
                vector23.set(fArray[0], fArray[1]);
            }
            if (floatArray2.size == 0) {
                return false;
            }
            vector24.set(floatArray2.get(floatArray2.size - 2), floatArray2.get(floatArray2.size - 1));
            for (int i3 = 0; i3 < floatArray2.size; i3 += 2) {
                boolean bl2;
                vector25.set(floatArray2.get(i3), floatArray2.get(i3 + 1));
                boolean bl3 = bl2 = Intersector.pointLineSide(vector23, vector22, vector24) > 0;
                if (Intersector.pointLineSide(vector23, vector22, vector25) > 0) {
                    if (!bl2) {
                        Intersector.intersectLines(vector24, vector25, vector22, vector23, vector2);
                        if (floatArray.size < 2 || floatArray.get(floatArray.size - 2) != vector2.x || floatArray.get(floatArray.size - 1) != vector2.y) {
                            floatArray.add(vector2.x);
                            floatArray.add(vector2.y);
                        }
                    }
                    floatArray.add(vector25.x);
                    floatArray.add(vector25.y);
                } else if (bl2) {
                    Intersector.intersectLines(vector24, vector25, vector22, vector23, vector2);
                    floatArray.add(vector2.x);
                    floatArray.add(vector2.y);
                }
                vector24.set(vector25.x, vector25.y);
            }
            floatArray2.clear();
            floatArray2.addAll(floatArray);
            floatArray.clear();
        }
        if (floatArray2.size != 0) {
            if (polygon3 != null) {
                if (polygon3.getVertices().length == floatArray2.size) {
                    System.arraycopy(floatArray2.items, 0, polygon3.getVertices(), 0, floatArray2.size);
                } else {
                    polygon3.setVertices(floatArray2.toArray());
                }
            }
            return true;
        }
        return false;
    }

    public static boolean intersectPolygons(FloatArray floatArray, FloatArray floatArray2) {
        if (Intersector.isPointInPolygon(floatArray.items, 0, floatArray.size, floatArray2.items[0], floatArray2.items[1])) {
            return true;
        }
        if (Intersector.isPointInPolygon(floatArray2.items, 0, floatArray2.size, floatArray.items[0], floatArray.items[1])) {
            return true;
        }
        return Intersector.intersectPolygonEdges(floatArray, floatArray2);
    }

    public static boolean intersectPolygonEdges(FloatArray floatArray, FloatArray floatArray2) {
        int n2 = floatArray.size - 2;
        int n3 = floatArray2.size - 2;
        float[] fArray = floatArray.items;
        float[] fArray2 = floatArray2.items;
        float f2 = fArray[n2];
        float f3 = fArray[n2 + 1];
        for (int i2 = 0; i2 <= n2; i2 += 2) {
            float f4 = fArray[i2];
            float f5 = fArray[i2 + 1];
            float f6 = fArray2[n3];
            float f7 = fArray2[n3 + 1];
            for (int i3 = 0; i3 <= n3; i3 += 2) {
                float f8 = fArray2[i3];
                float f9 = fArray2[i3 + 1];
                if (Intersector.intersectSegments(f2, f3, f4, f5, f6, f7, f8, f9, null)) {
                    return true;
                }
                f6 = f8;
                f7 = f9;
            }
            f2 = f4;
            f3 = f5;
        }
        return false;
    }

    public static float distanceLinePoint(float f2, float f3, float f4, float f5, float f6, float f7) {
        float f8 = (float)Math.sqrt((f4 - f2) * (f4 - f2) + (f5 - f3) * (f5 - f3));
        return Math.abs((f6 - f2) * (f5 - f3) - (f7 - f3) * (f4 - f2)) / f8;
    }

    public static float distanceSegmentPoint(float f2, float f3, float f4, float f5, float f6, float f7) {
        return Intersector.nearestSegmentPoint(f2, f3, f4, f5, f6, f7, v2a).dst(f6, f7);
    }

    public static float distanceSegmentPoint(Vector2 vector2, Vector2 vector22, Vector2 vector23) {
        return Intersector.nearestSegmentPoint(vector2, vector22, vector23, v2a).dst(vector23);
    }

    public static Vector2 nearestSegmentPoint(Vector2 vector2, Vector2 vector22, Vector2 vector23, Vector2 vector24) {
        float f2 = vector2.dst2(vector22);
        if (f2 == 0.0f) {
            return vector24.set(vector2);
        }
        float f3 = ((vector23.x - vector2.x) * (vector22.x - vector2.x) + (vector23.y - vector2.y) * (vector22.y - vector2.y)) / f2;
        if (f3 <= 0.0f) {
            return vector24.set(vector2);
        }
        if (f3 >= 1.0f) {
            return vector24.set(vector22);
        }
        return vector24.set(vector2.x + f3 * (vector22.x - vector2.x), vector2.y + f3 * (vector22.y - vector2.y));
    }

    public static Vector2 nearestSegmentPoint(float f2, float f3, float f4, float f5, float f6, float f7, Vector2 vector2) {
        float f8 = f4 - f2;
        float f9 = f5 - f3;
        float f10 = f8 * f8 + f9 * f9;
        if (f10 == 0.0f) {
            return vector2.set(f2, f3);
        }
        float f11 = ((f6 - f2) * (f4 - f2) + (f7 - f3) * (f5 - f3)) / f10;
        if (f11 <= 0.0f) {
            return vector2.set(f2, f3);
        }
        if (f11 >= 1.0f) {
            return vector2.set(f4, f5);
        }
        return vector2.set(f2 + f11 * (f4 - f2), f3 + f11 * (f5 - f3));
    }

    public static boolean intersectSegmentCircle(Vector2 vector2, Vector2 vector22, Vector2 vector23, float f2) {
        tmp.set(vector22.x - vector2.x, vector22.y - vector2.y, 0.0f);
        tmp1.set(vector23.x - vector2.x, vector23.y - vector2.y, 0.0f);
        float f3 = tmp.len();
        float f4 = tmp1.dot(tmp.nor());
        if (f4 <= 0.0f) {
            tmp2.set(vector2.x, vector2.y, 0.0f);
        } else if (f4 >= f3) {
            tmp2.set(vector22.x, vector22.y, 0.0f);
        } else {
            tmp3.set(tmp.scl(f4));
            tmp2.set(Intersector.tmp3.x + vector2.x, Intersector.tmp3.y + vector2.y, 0.0f);
        }
        float f5 = vector23.x - Intersector.tmp2.x;
        float f6 = vector23.y - Intersector.tmp2.y;
        return f5 * f5 + f6 * f6 <= f2;
    }

    public static boolean intersectSegmentCircle(Vector2 vector2, Vector2 vector22, Circle circle, MinimumTranslationVector minimumTranslationVector) {
        v2a.set(vector22).sub(vector2);
        v2b.set(circle.x - vector2.x, circle.y - vector2.y);
        float f2 = v2a.len();
        float f3 = v2b.dot(v2a.nor());
        if (f3 <= 0.0f) {
            v2c.set(vector2);
        } else if (f3 >= f2) {
            v2c.set(vector22);
        } else {
            v2d.set(v2a.scl(f3));
            v2c.set(v2d).add(vector2);
        }
        v2a.set(Intersector.v2c.x - circle.x, Intersector.v2c.y - circle.y);
        if (minimumTranslationVector != null) {
            if (v2a.equals(Vector2.Zero)) {
                v2d.set(vector22.y - vector2.y, vector2.x - vector22.x);
                minimumTranslationVector.normal.set(v2d).nor();
                minimumTranslationVector.depth = circle.radius;
            } else {
                minimumTranslationVector.normal.set(v2a).nor();
                minimumTranslationVector.depth = circle.radius - v2a.len();
            }
        }
        return v2a.len2() <= circle.radius * circle.radius;
    }

    public static boolean intersectFrustumBounds(Frustum frustum, BoundingBox boundingBox) {
        boolean bl2;
        boolean bl3 = bl2 = frustum.pointInFrustum(boundingBox.getCorner000(tmp)) || frustum.pointInFrustum(boundingBox.getCorner001(tmp)) || frustum.pointInFrustum(boundingBox.getCorner010(tmp)) || frustum.pointInFrustum(boundingBox.getCorner011(tmp)) || frustum.pointInFrustum(boundingBox.getCorner100(tmp)) || frustum.pointInFrustum(boundingBox.getCorner101(tmp)) || frustum.pointInFrustum(boundingBox.getCorner110(tmp)) || frustum.pointInFrustum(boundingBox.getCorner111(tmp));
        if (bl2) {
            return true;
        }
        boolean bl4 = false;
        for (Vector3 vector3 : frustum.planePoints) {
            bl4 |= boundingBox.contains(vector3);
        }
        return bl4;
    }

    public static float intersectRayRay(Vector2 vector2, Vector2 vector22, Vector2 vector23, Vector2 vector24) {
        float f2 = vector23.x - vector2.x;
        float f3 = vector23.y - vector2.y;
        float f4 = vector22.x * vector24.y - vector22.y * vector24.x;
        if (f4 == 0.0f) {
            return Float.POSITIVE_INFINITY;
        }
        float f5 = vector24.x / f4;
        float f6 = vector24.y / f4;
        return f2 * f6 - f3 * f5;
    }

    public static boolean intersectRayPlane(Ray ray, Plane plane, Vector3 vector3) {
        float f2 = ray.direction.dot(plane.getNormal());
        if (f2 != 0.0f) {
            float f3 = -(ray.origin.dot(plane.getNormal()) + plane.getD()) / f2;
            if (f3 < 0.0f) {
                return false;
            }
            if (vector3 != null) {
                vector3.set(ray.origin).add(v0.set(ray.direction).scl(f3));
            }
            return true;
        }
        if (plane.testPoint(ray.origin) == Plane.PlaneSide.OnPlane) {
            if (vector3 != null) {
                vector3.set(ray.origin);
            }
            return true;
        }
        return false;
    }

    public static float intersectLinePlane(float f2, float f3, float f4, float f5, float f6, float f7, Plane plane, Vector3 vector3) {
        Vector3 vector32 = tmp.set(f5, f6, f7).sub(f2, f3, f4);
        Vector3 vector33 = tmp2.set(f2, f3, f4);
        float f8 = vector32.dot(plane.getNormal());
        if (f8 != 0.0f) {
            float f9 = -(vector33.dot(plane.getNormal()) + plane.getD()) / f8;
            if (vector3 != null) {
                vector3.set(vector33).add(vector32.scl(f9));
            }
            return f9;
        }
        if (plane.testPoint(vector33) == Plane.PlaneSide.OnPlane) {
            if (vector3 != null) {
                vector3.set(vector33);
            }
            return 0.0f;
        }
        return -1.0f;
    }

    public static boolean intersectPlanes(Plane plane, Plane plane2, Plane plane3, Vector3 vector3) {
        tmp1.set(plane.normal).crs(plane2.normal);
        tmp2.set(plane2.normal).crs(plane3.normal);
        tmp3.set(plane3.normal).crs(plane.normal);
        float f2 = -plane.normal.dot(tmp2);
        if (Math.abs(f2) < 1.0E-6f) {
            return false;
        }
        tmp1.scl(plane3.d);
        tmp2.scl(plane.d);
        tmp3.scl(plane2.d);
        vector3.set(Intersector.tmp1.x + Intersector.tmp2.x + Intersector.tmp3.x, Intersector.tmp1.y + Intersector.tmp2.y + Intersector.tmp3.y, Intersector.tmp1.z + Intersector.tmp2.z + Intersector.tmp3.z);
        vector3.scl(1.0f / f2);
        return true;
    }

    public static boolean intersectRayTriangle(Ray ray, Vector3 vector3, Vector3 vector32, Vector3 vector33, Vector3 vector34) {
        Vector3 vector35 = v0.set(vector32).sub(vector3);
        Vector3 vector36 = v1.set(vector33).sub(vector3);
        Vector3 vector37 = v2.set(ray.direction).crs(vector36);
        float f2 = vector35.dot(vector37);
        if (MathUtils.isZero(f2)) {
            p.set(vector3, vector32, vector33);
            if (p.testPoint(ray.origin) == Plane.PlaneSide.OnPlane && Intersector.isPointInTriangle(ray.origin, vector3, vector32, vector33)) {
                if (vector34 != null) {
                    vector34.set(ray.origin);
                }
                return true;
            }
            return false;
        }
        f2 = 1.0f / f2;
        Vector3 vector38 = i.set(ray.origin).sub(vector3);
        float f3 = vector38.dot(vector37) * f2;
        if (f3 < 0.0f || f3 > 1.0f) {
            return false;
        }
        Vector3 vector39 = vector38.crs(vector35);
        float f4 = ray.direction.dot(vector39) * f2;
        if (f4 < 0.0f || f3 + f4 > 1.0f) {
            return false;
        }
        float f5 = vector36.dot(vector39) * f2;
        if (f5 < 0.0f) {
            return false;
        }
        if (vector34 != null) {
            if (f5 <= 1.0E-6f) {
                vector34.set(ray.origin);
            } else {
                ray.getEndPoint(vector34, f5);
            }
        }
        return true;
    }

    public static boolean intersectRaySphere(Ray ray, Vector3 vector3, float f2, Vector3 vector32) {
        float f3;
        float f4 = ray.direction.dot(vector3.x - ray.origin.x, vector3.y - ray.origin.y, vector3.z - ray.origin.z);
        if (f4 < 0.0f) {
            return false;
        }
        float f5 = vector3.dst2(ray.origin.x + ray.direction.x * f4, ray.origin.y + ray.direction.y * f4, ray.origin.z + ray.direction.z * f4);
        if (f5 > (f3 = f2 * f2)) {
            return false;
        }
        if (vector32 != null) {
            vector32.set(ray.direction).scl(f4 - (float)Math.sqrt(f3 - f5)).add(ray.origin);
        }
        return true;
    }

    public static boolean intersectRayBounds(Ray ray, BoundingBox boundingBox, Vector3 vector3) {
        float f2;
        if (boundingBox.contains(ray.origin)) {
            if (vector3 != null) {
                vector3.set(ray.origin);
            }
            return true;
        }
        float f3 = 0.0f;
        boolean bl2 = false;
        if (ray.origin.x <= boundingBox.min.x && ray.direction.x > 0.0f && (f2 = (boundingBox.min.x - ray.origin.x) / ray.direction.x) >= 0.0f) {
            v2.set(ray.direction).scl(f2).add(ray.origin);
            if (Intersector.v2.y >= boundingBox.min.y && Intersector.v2.y <= boundingBox.max.y && Intersector.v2.z >= boundingBox.min.z && Intersector.v2.z <= boundingBox.max.z && (!bl2 || f2 < f3)) {
                bl2 = true;
                f3 = f2;
            }
        }
        if (ray.origin.x >= boundingBox.max.x && ray.direction.x < 0.0f && (f2 = (boundingBox.max.x - ray.origin.x) / ray.direction.x) >= 0.0f) {
            v2.set(ray.direction).scl(f2).add(ray.origin);
            if (Intersector.v2.y >= boundingBox.min.y && Intersector.v2.y <= boundingBox.max.y && Intersector.v2.z >= boundingBox.min.z && Intersector.v2.z <= boundingBox.max.z && (!bl2 || f2 < f3)) {
                bl2 = true;
                f3 = f2;
            }
        }
        if (ray.origin.y <= boundingBox.min.y && ray.direction.y > 0.0f && (f2 = (boundingBox.min.y - ray.origin.y) / ray.direction.y) >= 0.0f) {
            v2.set(ray.direction).scl(f2).add(ray.origin);
            if (Intersector.v2.x >= boundingBox.min.x && Intersector.v2.x <= boundingBox.max.x && Intersector.v2.z >= boundingBox.min.z && Intersector.v2.z <= boundingBox.max.z && (!bl2 || f2 < f3)) {
                bl2 = true;
                f3 = f2;
            }
        }
        if (ray.origin.y >= boundingBox.max.y && ray.direction.y < 0.0f && (f2 = (boundingBox.max.y - ray.origin.y) / ray.direction.y) >= 0.0f) {
            v2.set(ray.direction).scl(f2).add(ray.origin);
            if (Intersector.v2.x >= boundingBox.min.x && Intersector.v2.x <= boundingBox.max.x && Intersector.v2.z >= boundingBox.min.z && Intersector.v2.z <= boundingBox.max.z && (!bl2 || f2 < f3)) {
                bl2 = true;
                f3 = f2;
            }
        }
        if (ray.origin.z <= boundingBox.min.z && ray.direction.z > 0.0f && (f2 = (boundingBox.min.z - ray.origin.z) / ray.direction.z) >= 0.0f) {
            v2.set(ray.direction).scl(f2).add(ray.origin);
            if (Intersector.v2.x >= boundingBox.min.x && Intersector.v2.x <= boundingBox.max.x && Intersector.v2.y >= boundingBox.min.y && Intersector.v2.y <= boundingBox.max.y && (!bl2 || f2 < f3)) {
                bl2 = true;
                f3 = f2;
            }
        }
        if (ray.origin.z >= boundingBox.max.z && ray.direction.z < 0.0f && (f2 = (boundingBox.max.z - ray.origin.z) / ray.direction.z) >= 0.0f) {
            v2.set(ray.direction).scl(f2).add(ray.origin);
            if (Intersector.v2.x >= boundingBox.min.x && Intersector.v2.x <= boundingBox.max.x && Intersector.v2.y >= boundingBox.min.y && Intersector.v2.y <= boundingBox.max.y && (!bl2 || f2 < f3)) {
                bl2 = true;
                f3 = f2;
            }
        }
        if (bl2 && vector3 != null) {
            vector3.set(ray.direction).scl(f3).add(ray.origin);
            if (vector3.x < boundingBox.min.x) {
                vector3.x = boundingBox.min.x;
            } else if (vector3.x > boundingBox.max.x) {
                vector3.x = boundingBox.max.x;
            }
            if (vector3.y < boundingBox.min.y) {
                vector3.y = boundingBox.min.y;
            } else if (vector3.y > boundingBox.max.y) {
                vector3.y = boundingBox.max.y;
            }
            if (vector3.z < boundingBox.min.z) {
                vector3.z = boundingBox.min.z;
            } else if (vector3.z > boundingBox.max.z) {
                vector3.z = boundingBox.max.z;
            }
        }
        return bl2;
    }

    public static boolean intersectRayBoundsFast(Ray ray, BoundingBox boundingBox) {
        return Intersector.intersectRayBoundsFast(ray, boundingBox.getCenter(tmp1), boundingBox.getDimensions(tmp2));
    }

    public static boolean intersectRayBoundsFast(Ray ray, Vector3 vector3, Vector3 vector32) {
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7 = 1.0f / ray.direction.x;
        float f8 = 1.0f / ray.direction.y;
        float f9 = 1.0f / ray.direction.z;
        float f10 = (vector3.x - vector32.x * 0.5f - ray.origin.x) * f7;
        float f11 = (vector3.x + vector32.x * 0.5f - ray.origin.x) * f7;
        if (f10 > f11) {
            f6 = f10;
            f10 = f11;
            f11 = f6;
        }
        if ((f6 = (vector3.y - vector32.y * 0.5f - ray.origin.y) * f8) > (f5 = (vector3.y + vector32.y * 0.5f - ray.origin.y) * f8)) {
            f4 = f6;
            f6 = f5;
            f5 = f4;
        }
        if ((f4 = (vector3.z - vector32.z * 0.5f - ray.origin.z) * f9) > (f3 = (vector3.z + vector32.z * 0.5f - ray.origin.z) * f9)) {
            f2 = f4;
            f4 = f3;
            f3 = f2;
        }
        f2 = Math.max(Math.max(f10, f6), f4);
        float f12 = Math.min(Math.min(f11, f5), f3);
        return f12 >= 0.0f && f12 >= f2;
    }

    public static boolean intersectRayOrientedBoundsFast(Ray ray, BoundingBox boundingBox, Matrix4 matrix4) {
        float f2;
        float f3;
        float f4 = 0.0f;
        float f5 = Float.MAX_VALUE;
        Vector3 vector3 = matrix4.getTranslation(tmp);
        Vector3 vector32 = vector3.sub(ray.origin);
        Vector3 vector33 = tmp1;
        tmp1.set(matrix4.val[0], matrix4.val[1], matrix4.val[2]);
        float f6 = vector33.dot(vector32);
        float f7 = ray.direction.dot(vector33);
        if (Math.abs(f7) > 1.0E-6f) {
            f3 = (f6 + boundingBox.min.x) / f7;
            f2 = (f6 + boundingBox.max.x) / f7;
            if (f3 > f2) {
                float f8 = f3;
                f3 = f2;
                f2 = f8;
            }
            if (f2 < f5) {
                f5 = f2;
            }
            if (f3 > f4) {
                f4 = f3;
            }
            if (f5 < f4) {
                return false;
            }
        } else if (-f6 + boundingBox.min.x > 0.0f || -f6 + boundingBox.max.x < 0.0f) {
            return false;
        }
        Vector3 vector34 = tmp2;
        tmp2.set(matrix4.val[4], matrix4.val[5], matrix4.val[6]);
        f6 = vector34.dot(vector32);
        f7 = ray.direction.dot(vector34);
        if (Math.abs(f7) > 1.0E-6f) {
            f3 = (f6 + boundingBox.min.y) / f7;
            f2 = (f6 + boundingBox.max.y) / f7;
            if (f3 > f2) {
                float f9 = f3;
                f3 = f2;
                f2 = f9;
            }
            if (f2 < f5) {
                f5 = f2;
            }
            if (f3 > f4) {
                f4 = f3;
            }
            if (f4 > f5) {
                return false;
            }
        } else if (-f6 + boundingBox.min.y > 0.0f || -f6 + boundingBox.max.y < 0.0f) {
            return false;
        }
        Vector3 vector35 = tmp3;
        tmp3.set(matrix4.val[8], matrix4.val[9], matrix4.val[10]);
        f6 = vector35.dot(vector32);
        f7 = ray.direction.dot(vector35);
        if (Math.abs(f7) > 1.0E-6f) {
            f3 = (f6 + boundingBox.min.z) / f7;
            f2 = (f6 + boundingBox.max.z) / f7;
            if (f3 > f2) {
                float f10 = f3;
                f3 = f2;
                f2 = f10;
            }
            if (f2 < f5) {
                f5 = f2;
            }
            if (f3 > f4) {
                f4 = f3;
            }
            if (f4 > f5) {
                return false;
            }
        } else if (-f6 + boundingBox.min.z > 0.0f || -f6 + boundingBox.max.z < 0.0f) {
            return false;
        }
        return true;
    }

    public static boolean intersectRayTriangles(Ray ray, float[] fArray, Vector3 vector3) {
        float f2 = Float.MAX_VALUE;
        boolean bl2 = false;
        if (fArray.length % 9 != 0) {
            throw new RuntimeException("triangles array size is not a multiple of 9");
        }
        for (int i2 = 0; i2 < fArray.length; i2 += 9) {
            float f3;
            boolean bl3 = Intersector.intersectRayTriangle(ray, tmp1.set(fArray[i2], fArray[i2 + 1], fArray[i2 + 2]), tmp2.set(fArray[i2 + 3], fArray[i2 + 4], fArray[i2 + 5]), tmp3.set(fArray[i2 + 6], fArray[i2 + 7], fArray[i2 + 8]), tmp);
            if (!bl3 || !((f3 = ray.origin.dst2(tmp)) < f2)) continue;
            f2 = f3;
            best.set(tmp);
            bl2 = true;
        }
        if (!bl2) {
            return false;
        }
        if (vector3 != null) {
            vector3.set(best);
        }
        return true;
    }

    public static boolean intersectRayTriangles(Ray ray, float[] fArray, short[] sArray, int n2, Vector3 vector3) {
        float f2 = Float.MAX_VALUE;
        boolean bl2 = false;
        if (sArray.length % 3 != 0) {
            throw new RuntimeException("triangle list size is not a multiple of 3");
        }
        for (int i2 = 0; i2 < sArray.length; i2 += 3) {
            float f3;
            int n3 = sArray[i2] * n2;
            int n4 = sArray[i2 + 1] * n2;
            int n5 = sArray[i2 + 2] * n2;
            boolean bl3 = Intersector.intersectRayTriangle(ray, tmp1.set(fArray[n3], fArray[n3 + 1], fArray[n3 + 2]), tmp2.set(fArray[n4], fArray[n4 + 1], fArray[n4 + 2]), tmp3.set(fArray[n5], fArray[n5 + 1], fArray[n5 + 2]), tmp);
            if (!bl3 || !((f3 = ray.origin.dst2(tmp)) < f2)) continue;
            f2 = f3;
            best.set(tmp);
            bl2 = true;
        }
        if (!bl2) {
            return false;
        }
        if (vector3 != null) {
            vector3.set(best);
        }
        return true;
    }

    public static boolean intersectRayTriangles(Ray ray, List<Vector3> list, Vector3 vector3) {
        float f2 = Float.MAX_VALUE;
        boolean bl2 = false;
        if (list.size() % 3 != 0) {
            throw new RuntimeException("triangle list size is not a multiple of 3");
        }
        for (int i2 = 0; i2 < list.size(); i2 += 3) {
            float f3;
            boolean bl3 = Intersector.intersectRayTriangle(ray, list.get(i2), list.get(i2 + 1), list.get(i2 + 2), tmp);
            if (!bl3 || !((f3 = ray.origin.dst2(tmp)) < f2)) continue;
            f2 = f3;
            best.set(tmp);
            bl2 = true;
        }
        if (!bl2) {
            return false;
        }
        if (vector3 != null) {
            vector3.set(best);
        }
        return true;
    }

    public static boolean intersectBoundsPlaneFast(BoundingBox boundingBox, Plane plane) {
        return Intersector.intersectBoundsPlaneFast(boundingBox.getCenter(tmp1), boundingBox.getDimensions(tmp2).scl(0.5f), plane.normal, plane.d);
    }

    public static boolean intersectBoundsPlaneFast(Vector3 vector3, Vector3 vector32, Vector3 vector33, float f2) {
        float f3 = vector32.x * Math.abs(vector33.x) + vector32.y * Math.abs(vector33.y) + vector32.z * Math.abs(vector33.z);
        float f4 = vector33.dot(vector3) - f2;
        return Math.abs(f4) <= f3;
    }

    public static boolean intersectLines(Vector2 vector2, Vector2 vector22, Vector2 vector23, Vector2 vector24, Vector2 vector25) {
        float f2 = vector24.y;
        float f3 = vector23.y;
        float f4 = vector22.x;
        float f5 = vector2.x;
        float f6 = vector24.x;
        float f7 = vector23.x;
        float f8 = vector22.y;
        float f9 = vector2.y;
        float f10 = (f2 - f3) * (f4 - f5) - (f6 - f7) * (f8 - f9);
        if (f10 == 0.0f) {
            return false;
        }
        if (vector25 != null) {
            float f11 = ((f6 - f7) * (f9 - f3) - (f2 - f3) * (f5 - f7)) / f10;
            vector25.set(f5 + (f4 - f5) * f11, f9 + (f8 - f9) * f11);
        }
        return true;
    }

    public static boolean intersectLines(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, Vector2 vector2) {
        float f10 = (f9 - f7) * (f4 - f2) - (f8 - f6) * (f5 - f3);
        if (f10 == 0.0f) {
            return false;
        }
        if (vector2 != null) {
            float f11 = ((f8 - f6) * (f3 - f7) - (f9 - f7) * (f2 - f6)) / f10;
            vector2.set(f2 + (f4 - f2) * f11, f3 + (f5 - f3) * f11);
        }
        return true;
    }

    public static boolean intersectLinePolygon(Vector2 vector2, Vector2 vector22, Polygon polygon) {
        float[] fArray = polygon.getTransformedVertices();
        float f2 = vector2.x;
        float f3 = vector2.y;
        float f4 = vector22.x;
        float f5 = vector22.y;
        int n2 = fArray.length;
        float f6 = fArray[n2 - 2];
        float f7 = fArray[n2 - 1];
        for (int i2 = 0; i2 < n2; i2 += 2) {
            float f8;
            float f9;
            float f10;
            float f11 = fArray[i2 + 1];
            float f12 = fArray[i2];
            float f13 = (f11 - f7) * (f4 - f2) - (f12 - f6) * (f5 - f3);
            if (f13 != 0.0f && (f10 = ((f12 - f6) * (f9 = f3 - f7) - (f11 - f7) * (f8 = f2 - f6)) / f13) >= 0.0f && f10 <= 1.0f) {
                return true;
            }
            f6 = f12;
            f7 = f11;
        }
        return false;
    }

    public static boolean intersectRectangles(Rectangle rectangle, Rectangle rectangle2, Rectangle rectangle3) {
        if (rectangle.overlaps(rectangle2)) {
            rectangle3.x = Math.max(rectangle.x, rectangle2.x);
            rectangle3.width = Math.min(rectangle.x + rectangle.width, rectangle2.x + rectangle2.width) - rectangle3.x;
            rectangle3.y = Math.max(rectangle.y, rectangle2.y);
            rectangle3.height = Math.min(rectangle.y + rectangle.height, rectangle2.y + rectangle2.height) - rectangle3.y;
            return true;
        }
        return false;
    }

    public static boolean intersectSegmentRectangle(float f2, float f3, float f4, float f5, Rectangle rectangle) {
        float f6 = rectangle.x + rectangle.width;
        float f7 = rectangle.y + rectangle.height;
        if (Intersector.intersectSegments(f2, f3, f4, f5, rectangle.x, rectangle.y, rectangle.x, f7, null)) {
            return true;
        }
        if (Intersector.intersectSegments(f2, f3, f4, f5, rectangle.x, rectangle.y, f6, rectangle.y, null)) {
            return true;
        }
        if (Intersector.intersectSegments(f2, f3, f4, f5, f6, rectangle.y, f6, f7, null)) {
            return true;
        }
        if (Intersector.intersectSegments(f2, f3, f4, f5, rectangle.x, f7, f6, f7, null)) {
            return true;
        }
        return rectangle.contains(f2, f3);
    }

    public static boolean intersectSegmentRectangle(Vector2 vector2, Vector2 vector22, Rectangle rectangle) {
        return Intersector.intersectSegmentRectangle(vector2.x, vector2.y, vector22.x, vector22.y, rectangle);
    }

    public static boolean intersectSegmentPolygon(Vector2 vector2, Vector2 vector22, Polygon polygon) {
        float[] fArray = polygon.getTransformedVertices();
        float f2 = vector2.x;
        float f3 = vector2.y;
        float f4 = vector22.x;
        float f5 = vector22.y;
        int n2 = fArray.length;
        float f6 = fArray[n2 - 2];
        float f7 = fArray[n2 - 1];
        for (int i2 = 0; i2 < n2; i2 += 2) {
            float f8;
            float f9;
            float f10;
            float f11;
            float f12 = fArray[i2 + 1];
            float f13 = fArray[i2];
            float f14 = (f12 - f7) * (f4 - f2) - (f13 - f6) * (f5 - f3);
            if (f14 != 0.0f && (f11 = ((f13 - f6) * (f10 = f3 - f7) - (f12 - f7) * (f9 = f2 - f6)) / f14) >= 0.0f && f11 <= 1.0f && (f8 = ((f4 - f2) * f10 - (f5 - f3) * f9) / f14) >= 0.0f && f8 <= 1.0f) {
                return true;
            }
            f6 = f13;
            f7 = f12;
        }
        return false;
    }

    public static boolean intersectSegments(Vector2 vector2, Vector2 vector22, Vector2 vector23, Vector2 vector24, Vector2 vector25) {
        float f2 = vector24.y;
        float f3 = vector23.y;
        float f4 = vector22.x;
        float f5 = vector2.x;
        float f6 = vector24.x;
        float f7 = vector23.x;
        float f8 = vector22.y;
        float f9 = vector2.y;
        float f10 = (f2 - f3) * (f4 - f5) - (f6 - f7) * (f8 - f9);
        if (f10 == 0.0f) {
            return false;
        }
        float f11 = f9 - f3;
        float f12 = f5 - f7;
        float f13 = ((f6 - f7) * f11 - (f2 - f3) * f12) / f10;
        if (f13 < 0.0f || f13 > 1.0f) {
            return false;
        }
        float f14 = ((f4 - f5) * f11 - (f8 - f9) * f12) / f10;
        if (f14 < 0.0f || f14 > 1.0f) {
            return false;
        }
        if (vector25 != null) {
            vector25.set(f5 + (f4 - f5) * f13, f9 + (f8 - f9) * f13);
        }
        return true;
    }

    public static boolean intersectSegments(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, Vector2 vector2) {
        float f10 = (f9 - f7) * (f4 - f2) - (f8 - f6) * (f5 - f3);
        if (f10 == 0.0f) {
            return false;
        }
        float f11 = f3 - f7;
        float f12 = f2 - f6;
        float f13 = ((f8 - f6) * f11 - (f9 - f7) * f12) / f10;
        if (f13 < 0.0f || f13 > 1.0f) {
            return false;
        }
        float f14 = ((f4 - f2) * f11 - (f5 - f3) * f12) / f10;
        if (f14 < 0.0f || f14 > 1.0f) {
            return false;
        }
        if (vector2 != null) {
            vector2.set(f2 + (f4 - f2) * f13, f3 + (f5 - f3) * f13);
        }
        return true;
    }

    static float det(float f2, float f3, float f4, float f5) {
        return f2 * f5 - f3 * f4;
    }

    static double detd(double d2, double d3, double d4, double d5) {
        return d2 * d5 - d3 * d4;
    }

    public static boolean overlaps(Circle circle, Circle circle2) {
        return circle.overlaps(circle2);
    }

    public static boolean overlaps(Rectangle rectangle, Rectangle rectangle2) {
        return rectangle.overlaps(rectangle2);
    }

    public static boolean overlaps(Circle circle, Rectangle rectangle) {
        float f2 = circle.x;
        float f3 = circle.y;
        if (circle.x < rectangle.x) {
            f2 = rectangle.x;
        } else if (circle.x > rectangle.x + rectangle.width) {
            f2 = rectangle.x + rectangle.width;
        }
        if (circle.y < rectangle.y) {
            f3 = rectangle.y;
        } else if (circle.y > rectangle.y + rectangle.height) {
            f3 = rectangle.y + rectangle.height;
        }
        f2 -= circle.x;
        f2 *= f2;
        f3 -= circle.y;
        f3 *= f3;
        return f2 + f3 < circle.radius * circle.radius;
    }

    public static boolean overlapConvexPolygons(Polygon polygon, Polygon polygon2) {
        return Intersector.overlapConvexPolygons(polygon, polygon2, null);
    }

    public static boolean overlapConvexPolygons(Polygon polygon, Polygon polygon2, MinimumTranslationVector minimumTranslationVector) {
        return Intersector.overlapConvexPolygons(polygon.getTransformedVertices(), polygon2.getTransformedVertices(), minimumTranslationVector);
    }

    public static boolean overlapConvexPolygons(float[] fArray, float[] fArray2, MinimumTranslationVector minimumTranslationVector) {
        return Intersector.overlapConvexPolygons(fArray, 0, fArray.length, fArray2, 0, fArray2.length, minimumTranslationVector);
    }

    public static boolean overlapConvexPolygons(float[] fArray, int n2, int n3, float[] fArray2, int n4, int n5, MinimumTranslationVector minimumTranslationVector) {
        boolean bl2;
        if (minimumTranslationVector != null) {
            minimumTranslationVector.depth = Float.MAX_VALUE;
            minimumTranslationVector.normal.setZero();
        }
        if (bl2 = Intersector.overlapsOnAxisOfShape(fArray2, n4, n5, fArray, n2, n3, minimumTranslationVector, true)) {
            bl2 = Intersector.overlapsOnAxisOfShape(fArray, n2, n3, fArray2, n4, n5, minimumTranslationVector, false);
        }
        if (!bl2) {
            if (minimumTranslationVector != null) {
                minimumTranslationVector.depth = 0.0f;
                minimumTranslationVector.normal.setZero();
            }
            return false;
        }
        return true;
    }

    private static boolean overlapsOnAxisOfShape(float[] fArray, int n2, int n3, float[] fArray2, int n4, int n5, MinimumTranslationVector minimumTranslationVector, boolean bl2) {
        int n6 = n2 + n3;
        int n7 = n4 + n5;
        for (int i2 = n2; i2 < n6; i2 += 2) {
            boolean bl3;
            float f2;
            float f3 = fArray[i2];
            float f4 = fArray[i2 + 1];
            float f5 = fArray[(i2 + 2) % n3];
            float f6 = fArray[(i2 + 3) % n3];
            float f7 = f4 - f6;
            float f8 = -(f3 - f5);
            float f9 = (float)Math.sqrt(f7 * f7 + f8 * f8);
            f7 /= f9;
            f8 /= f9;
            float f10 = Float.MAX_VALUE;
            float f11 = -3.4028235E38f;
            for (int i3 = n2; i3 < n6; i3 += 2) {
                f2 = fArray[i3] * f7 + fArray[i3 + 1] * f8;
                f10 = Math.min(f10, f2);
                f11 = Math.max(f11, f2);
            }
            float f12 = Float.MAX_VALUE;
            f2 = -3.4028235E38f;
            for (int i4 = n4; i4 < n7; i4 += 2) {
                float f13 = fArray2[i4] * f7 + fArray2[i4 + 1] * f8;
                f12 = Math.min(f12, f13);
                f2 = Math.max(f2, f13);
            }
            if (f11 < f12 || f2 < f10) {
                return false;
            }
            if (minimumTranslationVector == null) continue;
            float f14 = Math.min(f11, f2) - Math.max(f10, f12);
            boolean bl4 = f10 < f12 && f11 > f2;
            boolean bl5 = f12 < f10 && f2 > f11;
            float f15 = 0.0f;
            float f16 = 0.0f;
            if (bl4 || bl5) {
                f15 = Math.abs(f10 - f12);
                f16 = Math.abs(f11 - f2);
                f14 += Math.min(f15, f16);
            }
            if (!(minimumTranslationVector.depth > f14)) continue;
            minimumTranslationVector.depth = f14;
            if (bl2) {
                bl3 = f10 < f12;
                f7 = bl3 ? f7 : -f7;
                f8 = bl3 ? f8 : -f8;
            } else {
                bl3 = f10 > f12;
                f7 = bl3 ? f7 : -f7;
                float f17 = f8 = bl3 ? f8 : -f8;
            }
            if (bl4 || bl5) {
                bl3 = f15 > f16;
                f7 = bl3 ? f7 : -f7;
                f8 = bl3 ? f8 : -f8;
            }
            minimumTranslationVector.normal.set(f7, f8);
        }
        return true;
    }

    public static void splitTriangle(float[] fArray, Plane plane, SplitTriangle splitTriangle) {
        int n2 = fArray.length / 3;
        boolean bl2 = plane.testPoint(fArray[0], fArray[1], fArray[2]) == Plane.PlaneSide.Back;
        boolean bl3 = plane.testPoint(fArray[0 + n2], fArray[1 + n2], fArray[2 + n2]) == Plane.PlaneSide.Back;
        boolean bl4 = plane.testPoint(fArray[0 + n2 * 2], fArray[1 + n2 * 2], fArray[2 + n2 * 2]) == Plane.PlaneSide.Back;
        splitTriangle.reset();
        if (bl2 == bl3 && bl3 == bl4) {
            splitTriangle.total = 1;
            if (bl2) {
                splitTriangle.numBack = 1;
                System.arraycopy(fArray, 0, splitTriangle.back, 0, fArray.length);
            } else {
                splitTriangle.numFront = 1;
                System.arraycopy(fArray, 0, splitTriangle.front, 0, fArray.length);
            }
            return;
        }
        splitTriangle.total = 3;
        splitTriangle.numFront = (bl2 ? 0 : 1) + (bl3 ? 0 : 1) + (bl4 ? 0 : 1);
        splitTriangle.numBack = splitTriangle.total - splitTriangle.numFront;
        splitTriangle.setSide(!bl2);
        int n3 = 0;
        int n4 = n2;
        if (bl2 != bl3) {
            Intersector.splitEdge(fArray, n3, n4, n2, plane, splitTriangle.edgeSplit, 0);
            splitTriangle.add(fArray, n3, n2);
            splitTriangle.add(splitTriangle.edgeSplit, 0, n2);
            splitTriangle.setSide(!splitTriangle.getSide());
            splitTriangle.add(splitTriangle.edgeSplit, 0, n2);
        } else {
            splitTriangle.add(fArray, n3, n2);
        }
        n3 = n2;
        n4 = n2 + n2;
        if (bl3 != bl4) {
            Intersector.splitEdge(fArray, n3, n4, n2, plane, splitTriangle.edgeSplit, 0);
            splitTriangle.add(fArray, n3, n2);
            splitTriangle.add(splitTriangle.edgeSplit, 0, n2);
            splitTriangle.setSide(!splitTriangle.getSide());
            splitTriangle.add(splitTriangle.edgeSplit, 0, n2);
        } else {
            splitTriangle.add(fArray, n3, n2);
        }
        n3 = n2 + n2;
        n4 = 0;
        if (bl4 != bl2) {
            Intersector.splitEdge(fArray, n3, n4, n2, plane, splitTriangle.edgeSplit, 0);
            splitTriangle.add(fArray, n3, n2);
            splitTriangle.add(splitTriangle.edgeSplit, 0, n2);
            splitTriangle.setSide(!splitTriangle.getSide());
            splitTriangle.add(splitTriangle.edgeSplit, 0, n2);
        } else {
            splitTriangle.add(fArray, n3, n2);
        }
        if (splitTriangle.numFront == 2) {
            System.arraycopy(splitTriangle.front, n2 * 2, splitTriangle.front, n2 * 3, n2 * 2);
            System.arraycopy(splitTriangle.front, 0, splitTriangle.front, n2 * 5, n2);
        } else {
            System.arraycopy(splitTriangle.back, n2 * 2, splitTriangle.back, n2 * 3, n2 * 2);
            System.arraycopy(splitTriangle.back, 0, splitTriangle.back, n2 * 5, n2);
        }
    }

    private static void splitEdge(float[] fArray, int n2, int n3, int n4, Plane plane, float[] fArray2, int n5) {
        float f2 = Intersector.intersectLinePlane(fArray[n2], fArray[n2 + 1], fArray[n2 + 2], fArray[n3], fArray[n3 + 1], fArray[n3 + 2], plane, intersection);
        fArray2[n5 + 0] = Intersector.intersection.x;
        fArray2[n5 + 1] = Intersector.intersection.y;
        fArray2[n5 + 2] = Intersector.intersection.z;
        for (int i2 = 3; i2 < n4; ++i2) {
            float f3 = fArray[n2 + i2];
            float f4 = fArray[n3 + i2];
            fArray2[n5 + i2] = f3 + f2 * (f4 - f3);
        }
    }

    public static class MinimumTranslationVector {
        public Vector2 normal = new Vector2();
        public float depth = 0.0f;
    }

    public static class SplitTriangle {
        public float[] front;
        public float[] back;
        float[] edgeSplit;
        public int numFront;
        public int numBack;
        public int total;
        boolean frontCurrent = false;
        int frontOffset = 0;
        int backOffset = 0;

        public SplitTriangle(int n2) {
            this.front = new float[n2 * 3 * 2];
            this.back = new float[n2 * 3 * 2];
            this.edgeSplit = new float[n2];
        }

        public String toString() {
            return "SplitTriangle [front=" + Arrays.toString(this.front) + ", back=" + Arrays.toString(this.back) + ", numFront=" + this.numFront + ", numBack=" + this.numBack + ", total=" + this.total + "]";
        }

        void setSide(boolean bl2) {
            this.frontCurrent = bl2;
        }

        boolean getSide() {
            return this.frontCurrent;
        }

        void add(float[] fArray, int n2, int n3) {
            if (this.frontCurrent) {
                System.arraycopy(fArray, n2, this.front, this.frontOffset, n3);
                this.frontOffset += n3;
            } else {
                System.arraycopy(fArray, n2, this.back, this.backOffset, n3);
                this.backOffset += n3;
            }
        }

        void reset() {
            this.frontCurrent = false;
            this.frontOffset = 0;
            this.backOffset = 0;
            this.numFront = 0;
            this.numBack = 0;
            this.total = 0;
        }
    }
}

