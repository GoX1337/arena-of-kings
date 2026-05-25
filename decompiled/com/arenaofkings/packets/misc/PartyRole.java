/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.misc;

public enum PartyRole {
    DPS,
    HEALER,
    BOTH,
    NONE;


    public static String simpleText(PartyRole partyRole) {
        switch (partyRole) {
            case BOTH: {
                return "Damage or Healer";
            }
            case DPS: {
                return "Damage";
            }
            case HEALER: {
                return "Healer";
            }
            case NONE: {
                return "Unknown";
            }
        }
        return "Unknown";
    }
}

