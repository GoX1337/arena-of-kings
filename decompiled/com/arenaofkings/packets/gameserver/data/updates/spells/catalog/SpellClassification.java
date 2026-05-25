/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.gameserver.data.updates.spells.catalog;

import com.arenaofkings.packets.gameserver.data.updates.PlayerSnapshot;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;

public abstract class SpellClassification
extends PlayerSnapshot {
    protected SpellName spellName;
    protected int ID;

    public SpellClassification() {
    }

    public SpellClassification(SpellName spellName) {
        this.spellName = spellName;
    }
}

