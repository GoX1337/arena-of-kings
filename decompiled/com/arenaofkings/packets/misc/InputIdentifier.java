/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.misc;

public enum InputIdentifier {
    MOVE_NORTH("MOVE_NORTH"),
    MOVE_SOUTH("MOVE_SOUTH"),
    MOVE_EAST("MOVE_EAST"),
    MOVE_WEST("MOVE_WEST"),
    BASIC("BASIC"),
    ABILITY_1("ABILITY_1"),
    ABILITY_2("ABILITY_2"),
    ABILITY_3("ABILITY_3"),
    ABILITY_4("ABILITY_4"),
    ABILITY_5("ABILITY_5"),
    ABILITY_6("ABILITY_6"),
    ABILITY_7("ABILITY_7"),
    ABILITY_8("ABILITY_8"),
    TRINKET_1("TRINKET_1"),
    TARGET_SELF("1"),
    TARGET_ALLY_2("2"),
    TARGET_ALLY_3("3"),
    TARGET_TAB("TAB"),
    TARGET_CLEAR("CLEAR"),
    TARGET_NEAREST_ENEMY("NEAREST"),
    TARGET_ENEMY_1("1"),
    TARGET_ENEMY_2("2"),
    TARGET_ENEMY_3("3"),
    SELF_INTERRUPT("SELF_INTERRUPT"),
    MEDITATE("MEDITATE"),
    SHOW_UI("UI"),
    TARGET_HOVERABLE("TARGET"),
    MOVE_TOWARD_CURSOR("MOVE");

    private final String simpleName;

    private InputIdentifier(String string2) {
        this.simpleName = string2;
    }

    public String defaultSimpleName(InputIdentifier inputIdentifier) {
        return inputIdentifier.simpleName;
    }
}

