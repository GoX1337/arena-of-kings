/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.gameserver.data.updates;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.EffectList;
import com.arenaofkings.packets.gameserver.data.updates.PlayerSnapshot;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;

public class PlayerEffectRemove
extends PlayerSnapshot {
    private EffectList effect;

    @Override
    public void handle(String string, PlayerSnapshot playerSnapshot, Engine engine) {
        if (ay.ay_a().br_a(string) == null) {
            return;
        }
        if (ay.ay_a().br_a(string).com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_EffectManager_a() != null) {
            ay.ay_a().br_a(string).com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_EffectManager_a().remove(this.effect);
            if (this.effect != EffectList.None && this.effect != EffectList.Bleeding && this.effect != EffectList.Blind && this.effect != EffectList.Burning && this.effect != EffectList.Fear && this.effect != EffectList.Hobble && this.effect != EffectList.Incapacitate && this.effect != EffectList.Infection && this.effect != EffectList.Interrupt && this.effect != EffectList.Poison && this.effect != EffectList.Shock && this.effect != EffectList.Silence && this.effect != EffectList.Stun && t.a(agd.class, engine)) {
                try {
                    SpellName spellName = SpellName.valueOf(this.effect.toString());
                    if (spellName != null && spellName != SpellName.OrbOfAbsolution && spellName != SpellName.OrbOfReplenishment && spellName != SpellName.OrbOfSmoke && spellName != SpellName.OrbOfWisdom) {
                        ((agd)engine.axc_a()).hi_a().a(string, spellName);
                    }
                }
                catch (Exception exception) {
                    // empty catch block
                }
            }
        }
    }
}

