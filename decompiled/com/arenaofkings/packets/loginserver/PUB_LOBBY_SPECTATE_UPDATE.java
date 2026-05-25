/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.loginserver;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.ArenaName;
import com.arenaofkings.packets.misc.CharacterClass;
import com.arenaofkings.packets.misc.PublicPacket;

public class PUB_LOBBY_SPECTATE_UPDATE
extends PublicPacket {
    private ArenaName arena;
    private CharacterClass character_1;
    private CharacterClass character_2;
    private CharacterClass character_3;
    private CharacterClass character_4;
    private CharacterClass character_5;
    private CharacterClass character_6;

    @Override
    public void handle(Engine engine) {
        Engine.b("Received Spectate: " + this.toString());
        if (t.a(we.class, engine)) {
            we we2 = (we)engine.axc_a();
            we2.wh_a().a(this.arena, this.character_1, this.character_2, this.character_3, this.character_4, this.character_5, this.character_6);
        }
    }

    public String toString() {
        return "PUB_LOBBY_SPECTATE_UPDATE [arena=" + (Object)((Object)this.arena) + ", character_1=" + (Object)((Object)this.character_1) + ", character_2=" + (Object)((Object)this.character_2) + ", character_3=" + (Object)((Object)this.character_3) + ", character_4=" + (Object)((Object)this.character_4) + ", character_5=" + (Object)((Object)this.character_5) + ", character_6=" + (Object)((Object)this.character_6) + "]";
    }
}

