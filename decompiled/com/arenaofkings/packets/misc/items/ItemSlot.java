/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.misc.items;

public enum ItemSlot {
    WEAPON,
    HEAD,
    SHOULDER,
    CHEST,
    BACK,
    WRIST,
    HANDS,
    LEGS,
    FEET,
    NECK,
    RING,
    TRINKET,
    CONSUMABLE;


    public static String getFormattedName(ItemSlot itemSlot) {
        switch (itemSlot) {
            case BACK: {
                return "Back";
            }
            case CHEST: {
                return "Chest";
            }
            case FEET: {
                return "Feet";
            }
            case HANDS: {
                return "Hands";
            }
            case HEAD: {
                return "Head";
            }
            case LEGS: {
                return "Legs";
            }
            case NECK: {
                return "Neck";
            }
            case RING: {
                return "Ring";
            }
            case SHOULDER: {
                return "Shoulder";
            }
            case TRINKET: {
                return "Trinket";
            }
            case WEAPON: {
                return "Weapon";
            }
            case WRIST: {
                return "Wrist";
            }
            case CONSUMABLE: {
                return "Consumable";
            }
        }
        return "";
    }
}

