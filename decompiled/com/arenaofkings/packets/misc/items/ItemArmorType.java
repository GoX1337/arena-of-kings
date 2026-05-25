/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.misc.items;

public enum ItemArmorType {
    MISC,
    CLOTH,
    LEATHER,
    PLATE;


    public static String getFormattedName(ItemArmorType itemArmorType) {
        switch (itemArmorType) {
            case CLOTH: {
                return "Cloth";
            }
            case LEATHER: {
                return "Leather";
            }
            case MISC: {
                return "";
            }
            case PLATE: {
                return "Plate";
            }
        }
        return "";
    }
}

