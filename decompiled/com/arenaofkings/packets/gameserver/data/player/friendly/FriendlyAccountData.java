/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.gameserver.data.player.friendly;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.player.shared.SharedAccountData;
import com.arenaofkings.packets.misc.CharacterClass;
import com.arenaofkings.packets.misc.ProfileBackgrounds;
import java.util.ArrayList;

public class FriendlyAccountData
extends SharedAccountData {
    public FriendlyAccountData(Engine engine, String string, int n2, CharacterClass characterClass, int n3, ProfileBackgrounds profileBackgrounds, String string2, String string3, String string4, int n4, int n5, int n6, int n7, ArrayList<String> arrayList, int n8, int n9) {
        this.active_character_entity = new ei(engine, string, n2, characterClass, n3, profileBackgrounds, string2, string3, string4, n4, n5, n6, n7, arrayList, n8, n9);
    }

    public FriendlyAccountData(Engine engine, String string, int n2, String string2, int n3, int n4, int n5, int n6, int n7) {
        this.active_character_entity = new ei(engine, string, n2, string2, n3, n4, n5, n6, n7);
    }
}

