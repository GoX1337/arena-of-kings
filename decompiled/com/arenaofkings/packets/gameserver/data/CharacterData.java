/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.gameserver.data;

import java.util.ArrayList;
import java.util.List;

public class CharacterData {
    private List<ej> characterEntities = new ArrayList<ej>();
    private ej active_character_entity;
    private String account_name;
    private int ordinal;

    public String getAccount_name() {
        return this.account_name;
    }

    public int getOrdinal() {
        return this.ordinal;
    }

    public void setActive_character_entity(ej ej2) {
        this.active_character_entity = ej2;
    }

    public ej getActive_character_entity() {
        return this.active_character_entity;
    }

    public String toString() {
        return "CharacterData [account_name=" + this.account_name + ", ordinal=" + this.ordinal + "]";
    }
}

