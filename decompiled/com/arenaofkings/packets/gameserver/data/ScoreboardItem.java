/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.gameserver.data;

public class ScoreboardItem {
    private String spellName;
    private int totalValue;

    public ScoreboardItem() {
    }

    public ScoreboardItem(String string, int n2) {
        this.spellName = string;
        this.totalValue = n2;
    }

    public String getSpellName() {
        return this.spellName;
    }

    public int getTotalValue() {
        return this.totalValue;
    }
}

