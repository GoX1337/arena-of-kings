/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.gameserver.data;

import com.badlogic.gdx.math.MathUtils;

public enum Direction {
    NORTH,
    EAST,
    SOUTH,
    WEST,
    NORTH_EAST,
    NORTH_WEST,
    SOUTH_EAST,
    SOUTH_WEST;


    public static Direction randomDirection() {
        Direction direction = NORTH;
        int n2 = MathUtils.random(7);
        if (n2 == 0) {
            direction = SOUTH;
        } else if (n2 == 1) {
            direction = SOUTH_EAST;
        } else if (n2 == 2) {
            direction = EAST;
        } else if (n2 == 3) {
            direction = NORTH_EAST;
        } else if (n2 == 4) {
            direction = NORTH;
        } else if (n2 == 5) {
            direction = NORTH_WEST;
        } else if (n2 == 6) {
            direction = WEST;
        } else if (n2 == 7) {
            direction = SOUTH_WEST;
        }
        return direction;
    }

    public static Direction randomEastWestDirection() {
        if (MathUtils.randomBoolean()) {
            return EAST;
        }
        return WEST;
    }

    public static Direction randomNoSouthDirection() {
        Direction direction = NORTH;
        int n2 = MathUtils.random(7);
        if (n2 == 0) {
            direction = EAST;
        } else if (n2 == 1) {
            direction = WEST;
        } else if (n2 == 2) {
            direction = EAST;
        } else if (n2 == 3) {
            direction = NORTH_EAST;
        } else if (n2 == 4) {
            direction = NORTH;
        } else if (n2 == 5) {
            direction = NORTH_WEST;
        } else if (n2 == 6) {
            direction = WEST;
        } else if (n2 == 7) {
            direction = WEST;
        }
        return direction;
    }
}

