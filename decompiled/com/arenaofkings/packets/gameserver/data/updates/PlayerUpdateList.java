/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.gameserver.data.updates;

import com.arenaofkings.packets.gameserver.data.updates.PlayerSnapshot;
import java.util.ArrayList;

public class PlayerUpdateList {
    protected String username;
    protected ArrayList<PlayerSnapshot> snapshots = new ArrayList();

    public PlayerUpdateList() {
    }

    public PlayerUpdateList(String string, PlayerSnapshot playerSnapshot) {
        this.username = string;
        this.snapshots.add(playerSnapshot);
    }

    public ArrayList<PlayerSnapshot> getSnapshots() {
        return this.snapshots;
    }

    public void setSnapshots(ArrayList<PlayerSnapshot> arrayList) {
        this.snapshots = arrayList;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String string) {
        this.username = string;
    }
}

