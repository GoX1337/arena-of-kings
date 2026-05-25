/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.misc.items;

public enum ItemRarity {
    COMMON,
    UNCOMMON,
    RARE,
    EPIC,
    LEGENDARY,
    UNIQUE,
    ANCIENT;


    public static String getColorCode(ItemRarity itemRarity) {
        String string = "";
        switch (itemRarity) {
            case COMMON: {
                string = "[RARITY_POOR]";
                break;
            }
            case UNCOMMON: {
                string = "[RARITY_UNCOMMON]";
                break;
            }
            case RARE: {
                string = "[RARITY_RARE]";
                break;
            }
            case EPIC: {
                string = "[RARITY_EPIC]";
                break;
            }
            case LEGENDARY: {
                string = "[RARITY_LEGENDARY]";
                break;
            }
            case UNIQUE: {
                string = "[RARITY_UNIQUE]";
                break;
            }
            case ANCIENT: {
                string = "[RARITY_ANCIENT]";
                break;
            }
            default: {
                string = "[RARITY_COMMON]";
            }
        }
        return string;
    }

    public static String getFormattedName(ItemRarity itemRarity) {
        switch (itemRarity) {
            case COMMON: {
                return "Common";
            }
            case EPIC: {
                return "Epic";
            }
            case LEGENDARY: {
                return "Legendary";
            }
            case RARE: {
                return "Rare";
            }
            case UNCOMMON: {
                return "Uncommon";
            }
            case UNIQUE: {
                return "Unidentified";
            }
            case ANCIENT: {
                return "Ancient";
            }
        }
        return "";
    }

    public static String getFormattedNameCommonIsPoor(ItemRarity itemRarity) {
        switch (itemRarity) {
            case COMMON: {
                return "Poor";
            }
            case EPIC: {
                return "Epic";
            }
            case LEGENDARY: {
                return "Legendary";
            }
            case RARE: {
                return "Rare";
            }
            case UNCOMMON: {
                return "Uncommon";
            }
            case UNIQUE: {
                return "Unidentified";
            }
            case ANCIENT: {
                return "Ancient";
            }
        }
        return "";
    }
}

