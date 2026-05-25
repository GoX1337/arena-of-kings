/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.gameserver.data.updates;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.updates.PlayerSnapshot;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;

public class PlayerSpellDestroyedUpdate
extends PlayerSnapshot {
    private SpellName spellName;

    public PlayerSpellDestroyedUpdate() {
    }

    public PlayerSpellDestroyedUpdate(SpellName spellName) {
        this.spellName = spellName;
    }

    @Override
    public void handle(String string, PlayerSnapshot playerSnapshot, Engine engine) {
        if (t.a(agd.class, engine)) {
            ((agd)engine.axc_a()).hi_a().a(string, this.spellName);
        }
    }
}

