/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.gameserver.data.player.enemy;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.player.shared.SharedAccountData;

public class EnemyAccountData
extends SharedAccountData {
    public EnemyAccountData(Engine engine, String string, int n2, String string2, int n3, int n4, int n5, int n6, int n7) {
        this.active_character_entity = new eg(engine, string, n2, string2, n3, n4, n5, n6, n7);
    }
}

