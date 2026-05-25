/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.gameserver.data;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import java.util.ArrayList;
import java.util.List;

public class EnemyPlayerData {
    public String character_name;
    public int character_ordinal;
    public String character_class;
    public int outfit;
    public int x;
    public int y;
    public int maxHealth;
    public int maxResource;
    public ArrayList<SpellName> auraList = new ArrayList();

    public EnemyPlayerData() {
    }

    public EnemyPlayerData(String string, int n2, String string2, int n3, int n4, int n5, List<ui> list) {
        this.character_name = string;
        this.character_ordinal = n2;
        this.character_class = string2;
        this.outfit = n3;
        this.x = n4;
        this.y = n5;
        for (ui ui2 : list) {
            Engine.a("spell name friendly " + (Object)((Object)ui2.hf_a().uk_a()));
            if (ui2.hf_a().uk_a() != uk.b) continue;
            this.auraList.add(ui2.hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a());
        }
    }
}

