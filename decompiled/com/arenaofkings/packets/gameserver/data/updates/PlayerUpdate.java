/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.gameserver.data.updates;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.updates.PlayerSnapshot;
import com.arenaofkings.packets.gameserver.data.updates.PlayerUpdateList;
import com.arenaofkings.packets.gameserver.data.updates.UpdatePacket;
import java.util.ArrayList;

public class PlayerUpdate
extends UpdatePacket {
    ArrayList<PlayerUpdateList> new_player_snapshots = new ArrayList();

    @Override
    public void handle(Object object, Engine engine) {
        PlayerUpdate playerUpdate = (PlayerUpdate)object;
        for (PlayerUpdateList playerUpdateList : playerUpdate.new_player_snapshots) {
            for (PlayerSnapshot playerSnapshot : playerUpdateList.getSnapshots()) {
                playerSnapshot.handle(playerUpdateList.getUsername(), playerSnapshot, engine);
            }
        }
    }
}

