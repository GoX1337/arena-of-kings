/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.misc;

public enum Region {
    US_EAST,
    EU_WEST;


    public static String getSimpleName(Region region) {
        switch (region) {
            case EU_WEST: {
                return "EU";
            }
            case US_EAST: {
                return "US";
            }
        }
        return "??";
    }
}

