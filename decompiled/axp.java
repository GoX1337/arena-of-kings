/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.Direction;
import com.arenaofkings.packets.gameserver.data.HitCircle;
import com.badlogic.gdx.math.Vector3;

public class axp {
    public static float float_a(double d2, double d3, double d4, double d5) {
        Engine.a("distance() " + d2 + "," + d3 + "  " + d4 + "," + d5 + "    " + (float)Math.sqrt(Math.pow(d4 - d2, 2.0) + Math.pow(d5 - d3, 2.0)));
        return (float)Math.sqrt(Math.pow(d4 - d2, 2.0) + Math.pow(d5 - d3, 2.0));
    }

    public static double double_a(double d2, double d3, double d4, double d5) {
        return (d5 - d3) / (d4 - d2);
    }

    public static double a(double d2, double d3, double d4) {
        return d3 - d4 * d2;
    }

    public static boolean a(double d2, double d3, int n2, double d4, double d5, int n3) {
        double d6 = Math.sqrt(Math.pow(d4 - d2, 2.0) + Math.pow(d5 - d3, 2.0));
        double d7 = n2 + n3;
        Engine.a("true if : " + d6 + "<= " + d7);
        return d6 <= d7;
    }

    public static boolean a(HitCircle hitCircle, HitCircle hitCircle2) {
        Engine.a("h1 radius: " + hitCircle.getRadius() + " h1 range: " + hitCircle.getRange() + "  h2 radius: " + hitCircle2.getRadius() + " h2 range: " + hitCircle2.getRange());
        return axp.a(hitCircle.getX(), hitCircle.getY(), hitCircle.getRadius(), hitCircle2.getX(), hitCircle2.getY(), 8);
    }

    public static Direction a(Direction direction, HitCircle hitCircle, HitCircle hitCircle2) {
        Direction direction2 = direction;
        double d2 = hitCircle2.getX() - hitCircle.getX();
        double d3 = hitCircle2.getY() - hitCircle.getY();
        double d4 = 0.0;
        if (d3 == 0.0) {
            if (d2 == 0.0) {
                return direction2;
            }
            if (d2 < 0.0) {
                double d5 = (hitCircle2.getY() - hitCircle.getY()) / (hitCircle2.getX() - hitCircle.getX());
                d4 = Math.atan(d5);
                double d6 = Math.atan(1.7320507764816284 * Math.tan(d4));
                d4 = Math.toDegrees(d4);
            } else if (d2 > 0.0) {
                double d7 = (hitCircle2.getY() - hitCircle.getY()) / (hitCircle2.getX() - hitCircle.getX());
                d4 = Math.atan(d7);
                double d8 = Math.atan(1.7320507764816284 * Math.tan(d4));
                d4 = Math.toDegrees(d4) + 180.0;
            }
        } else if (d3 > 0.0) {
            if (d2 > 0.0) {
                double d9 = (hitCircle2.getY() - hitCircle.getY()) / (hitCircle2.getX() - hitCircle.getX());
                d4 = Math.atan(d9);
                double d10 = Math.atan(1.7320507764816284 * Math.tan(d4));
                d4 = Math.toDegrees(d4) + 180.0;
            } else if (d2 < 0.0) {
                double d11 = (hitCircle2.getY() - hitCircle.getY()) / (hitCircle2.getX() - hitCircle.getX());
                d4 = Math.atan(d11);
                double d12 = Math.atan(1.7320507764816284 * Math.tan(d4));
                d4 = Math.toDegrees(d4) + 360.0;
            }
        } else if (d3 < 0.0) {
            if (d2 > 0.0) {
                double d13 = (hitCircle2.getY() - hitCircle.getY()) / (hitCircle2.getX() - hitCircle.getX());
                d4 = Math.atan(d13);
                double d14 = Math.atan(1.7320507764816284 * Math.tan(d4));
                d4 = Math.toDegrees(d4) + 180.0;
            } else if (d2 < 0.0) {
                double d15 = (hitCircle2.getY() - hitCircle.getY()) / (hitCircle2.getX() - hitCircle.getX());
                d4 = Math.atan(d15);
                double d16 = Math.atan(1.7320507764816284 * Math.tan(d4));
                d4 = Math.toDegrees(d4);
            }
        }
        if (d2 == 0.0) {
            if (d2 == d3) {
                return direction2;
            }
            if (d3 < 0.0) {
                d4 = 4.71238898038469;
                d4 = Math.toDegrees(d4) + 180.0;
            } else if (d3 > 0.0) {
                d4 = 4.71238898038469;
                d4 = Math.toDegrees(d4);
            }
        }
        if (d4 > 337.5 || d4 <= 22.5) {
            direction2 = Direction.EAST;
        } else if (d4 > 22.5 && d4 <= 67.5) {
            direction2 = Direction.NORTH_EAST;
        } else if (d4 > 67.5 && d4 <= 112.5) {
            direction2 = Direction.NORTH;
        } else if (d4 > 112.5 && d4 <= 157.5) {
            direction2 = Direction.NORTH_WEST;
        } else if (d4 > 157.5 && d4 <= 202.5) {
            direction2 = Direction.WEST;
        } else if (d4 > 202.5 && d4 <= 247.5) {
            direction2 = Direction.SOUTH_WEST;
        } else if (d4 > 247.5 && d4 <= 292.5) {
            direction2 = Direction.SOUTH;
        } else if (d4 > 292.5 && d4 <= 337.5) {
            direction2 = Direction.SOUTH_EAST;
        }
        return direction2;
    }

    public static Vector3 a(float f2, long l2, HitCircle hitCircle, HitCircle hitCircle2) {
        Vector3 vector3 = new Vector3();
        float f3 = f2 * (float)l2;
        double d2 = hitCircle2.getX() - hitCircle.getX();
        double d3 = hitCircle2.getY() - hitCircle.getY();
        double d4 = 0.0;
        double d5 = 0.0;
        double d6 = 0.0;
        if (d3 == 0.0) {
            if (d2 == 0.0) {
                vector3.set(hitCircle.getX(), hitCircle.getY(), (float)d4);
                return vector3;
            }
            if (d2 < 0.0) {
                double d7 = (hitCircle2.getY() - hitCircle.getY()) / (hitCircle2.getX() - hitCircle.getX());
                d4 = Math.atan(d7);
                double d8 = Math.atan(1.7320507764816284 * Math.tan(d4));
                d5 = (double)(-1.0f * f3) * Math.cos(d8);
                d6 = 0.0;
                d4 = Math.toDegrees(d4);
            } else if (d2 > 0.0) {
                double d9 = (hitCircle2.getY() - hitCircle.getY()) / (hitCircle2.getX() - hitCircle.getX());
                d4 = Math.atan(d9);
                double d10 = Math.atan(1.7320507764816284 * Math.tan(d4));
                d5 = (double)f3 * Math.cos(d10);
                d6 = 0.0;
                d4 = Math.toDegrees(d4) + 180.0;
            }
        } else if (d3 > 0.0) {
            if (d2 > 0.0) {
                double d11 = (hitCircle2.getY() - hitCircle.getY()) / (hitCircle2.getX() - hitCircle.getX());
                d4 = Math.atan(d11);
                double d12 = Math.atan(1.7320507764816284 * Math.tan(d4));
                f3 = f2 * (float)l2;
                d5 = (double)f3 * Math.cos(d12);
                d6 = f3 / 1.7320508f * (float)Math.sin(d12);
                d4 = Math.toDegrees(d4) + 180.0;
            } else if (d2 < 0.0) {
                double d13 = (hitCircle2.getY() - hitCircle.getY()) / (hitCircle2.getX() - hitCircle.getX());
                d4 = Math.atan(d13);
                double d14 = Math.atan(1.7320507764816284 * Math.tan(d4));
                f3 = f2 * (float)l2;
                d5 = (double)(-1.0f * f3) * Math.cos(d14);
                d6 = -1.0f * (f3 / 1.7320508f) * (float)Math.sin(d14);
                d4 = Math.toDegrees(d4);
            }
        } else if (d3 < 0.0) {
            if (d2 > 0.0) {
                double d15 = (hitCircle2.getY() - hitCircle.getY()) / (hitCircle2.getX() - hitCircle.getX());
                d4 = Math.atan(d15);
                double d16 = Math.atan(1.7320507764816284 * Math.tan(d4));
                f3 = f2 * (float)l2;
                d5 = (double)f3 * Math.cos(d16);
                d6 = f3 / 1.7320508f * (float)Math.sin(d16);
                d4 = Math.toDegrees(d4) + 180.0;
            } else if (d2 < 0.0) {
                double d17 = (hitCircle2.getY() - hitCircle.getY()) / (hitCircle2.getX() - hitCircle.getX());
                d4 = Math.atan(d17);
                double d18 = Math.atan(1.7320507764816284 * Math.tan(d4));
                f3 = f2 * (float)l2;
                d5 = (double)(-1.0f * f3) * Math.cos(d18);
                d6 = -1.0f * (f3 / 1.7320508f) * (float)Math.sin(d18);
                d4 = Math.toDegrees(d4);
            }
        }
        if (d2 == 0.0) {
            if (d3 < 0.0) {
                d4 = 4.71238898038469;
                d5 = 0.0;
                d6 = -1.0f * (f3 / 1.7320508f);
                d4 = Math.toDegrees(d4) + 180.0;
            } else if (d3 > 0.0) {
                d4 = 4.71238898038469;
                d5 = 0.0;
                d6 = f3 / 1.7320508f;
                d4 = Math.toDegrees(d4);
            }
        }
        vector3.set((float)d5, (float)d6, (float)d4);
        return vector3;
    }

    public static int a(int n2) {
        int n3 = 0;
        n3 = (int)(700.0 + 900.0 / (1.0 + 7000.0 * Math.pow(Math.E, (double)(-1 * n2) / 220.0)));
        return n3;
    }
}

