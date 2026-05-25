/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.misc.items;

import com.arenaofkings.packets.misc.CharacterClass;
import com.arenaofkings.packets.misc.items.EquippableRequirement;
import com.arenaofkings.packets.misc.items.ItemRequirement;

public class ClassRequirement
extends EquippableRequirement {
    protected CharacterClass classRequirement;

    public ClassRequirement() {
    }

    public ClassRequirement(CharacterClass characterClass) {
        super(ItemRequirement.CHARACTER_CLASS);
        this.classRequirement = characterClass;
    }

    public CharacterClass getClassRequirement() {
        return this.classRequirement;
    }

    @Override
    public String getValue() {
        return this.classRequirement.toString();
    }

    public String toString() {
        return "ClassRequirement [classRequirement=" + (Object)((Object)this.classRequirement) + "]";
    }
}

