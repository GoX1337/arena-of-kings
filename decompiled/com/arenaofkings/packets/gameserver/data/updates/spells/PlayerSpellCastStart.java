/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.gameserver.data.updates.spells;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.updates.PlayerSnapshot;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;

public class PlayerSpellCastStart
extends PlayerSnapshot {
    private String actor;
    private SpellName spellName;

    public PlayerSpellCastStart() {
    }

    public PlayerSpellCastStart(String string, SpellName spellName) {
        this.actor = string;
        this.spellName = spellName;
    }

    public String getActor() {
        return this.actor;
    }

    public SpellName getSpellName() {
        return this.spellName;
    }

    public void setActor(String string) {
        this.actor = string;
    }

    public void setSpellName(SpellName spellName) {
        this.spellName = spellName;
    }

    @Override
    public void handle(String string, PlayerSnapshot playerSnapshot, Engine engine) {
        Engine.a("new playercaststart: " + string + " spellName: " + (Object)((Object)this.spellName));
    }
}

