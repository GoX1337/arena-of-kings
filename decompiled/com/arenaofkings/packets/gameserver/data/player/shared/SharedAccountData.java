/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.gameserver.data.player.shared;

public abstract class SharedAccountData {
    protected el active_character_entity;
    protected int ordinal;

    public el getActive_character_entity() {
        return this.active_character_entity;
    }

    public void renderProfileToLobby(float f2, azi azi2) {
    }

    public void setActive_character_entity(el el2) {
        this.active_character_entity = el2;
    }
}

