/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.misc;

public enum ProfileBackgrounds {
    NONE("NONE", -1),
    PBG_0("Blackwood Vale", 0),
    PBG_1("Hero's Path", 1),
    PBG_2("Wasteland", 2),
    PBG_3("Twilight Moon", 3),
    PBG_4("Kazaar", 4),
    PBG_5("Sarossa, Queen of Ice", 5),
    PBG_6("Shrine of the Elders", 6),
    PBG_7("Moonlight Grove", 7),
    PBG_8("Cathedral of Sin", 8),
    PBG_9("Arcane Terrace", 9),
    PBG_10("Heaven's Ascent", 10),
    PBG_11("Vault of the Gods", 11),
    PBG_12("Silent Night", 12),
    PBG_14("Underworld 2022", 14),
    PBG_15("Crystal Palace 2022", 15);

    private final String formattedName;
    private final int atlasIndex;

    private ProfileBackgrounds(String string2, int n3) {
        this.formattedName = string2;
        this.atlasIndex = n3;
    }

    public int getAtlasIndex() {
        return this.atlasIndex;
    }

    public String getFormattedName() {
        return this.formattedName;
    }
}

