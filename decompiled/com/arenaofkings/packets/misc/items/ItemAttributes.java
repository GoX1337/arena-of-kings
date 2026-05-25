/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.misc.items;

import com.arenaofkings.client.core.Engine;

public enum ItemAttributes {
    STRENGTH,
    AGILITY,
    INTELLIGENCE,
    WISDOM,
    CRITICAL_CHANCE,
    HP5,
    MP5,
    HEALTH,
    MANA,
    ARMOR,
    MAGIC_RESIST,
    RESILIENCE,
    TENACITY,
    LIFE_STEAL,
    SOCKETS,
    INCREASED_RARITY,
    POWER;


    public static Class<? extends dc> getAttributeClass(ItemAttributes itemAttributes) {
        switch (itemAttributes) {
            case AGILITY: {
                return di.class;
            }
            case ARMOR: {
                return dj.class;
            }
            case CRITICAL_CHANCE: {
                return dm.class;
            }
            case HEALTH: {
                return dp.class;
            }
            case HP5: {
                return dq.class;
            }
            case INCREASED_RARITY: {
                return dr.class;
            }
            case INTELLIGENCE: {
                return ds.class;
            }
            case LIFE_STEAL: {
                return dt.class;
            }
            case MAGIC_RESIST: {
                return dv.class;
            }
            case MANA: {
                return dw.class;
            }
            case MP5: {
                return dy.class;
            }
            case POWER: {
                return dz.class;
            }
            case RESILIENCE: {
                return ea.class;
            }
            case SOCKETS: {
                return null;
            }
            case STRENGTH: {
                return eb.class;
            }
            case TENACITY: {
                return ec.class;
            }
            case WISDOM: {
                return ee.class;
            }
        }
        return null;
    }

    public static Class getAttribute(ItemAttributes itemAttributes) {
        switch (itemAttributes) {
            case AGILITY: {
                return di.class;
            }
            case ARMOR: {
                return dj.class;
            }
            case CRITICAL_CHANCE: {
                return dm.class;
            }
            case HEALTH: {
                return dp.class;
            }
            case HP5: {
                return dq.class;
            }
            case INCREASED_RARITY: {
                return dr.class;
            }
            case INTELLIGENCE: {
                return ds.class;
            }
            case LIFE_STEAL: {
                return dt.class;
            }
            case MAGIC_RESIST: {
                return dv.class;
            }
            case MANA: {
                return dw.class;
            }
            case MP5: {
                return dy.class;
            }
            case POWER: {
                return dz.class;
            }
            case RESILIENCE: {
                return ea.class;
            }
            case SOCKETS: {
                return null;
            }
            case STRENGTH: {
                return eb.class;
            }
            case TENACITY: {
                return ec.class;
            }
            case WISDOM: {
                return ee.class;
            }
        }
        return null;
    }

    public static String getFormattedName(ItemAttributes itemAttributes) {
        switch (itemAttributes) {
            case AGILITY: {
                return "Agility";
            }
            case ARMOR: {
                return "Armor";
            }
            case CRITICAL_CHANCE: {
                return "Critical Strike chance";
            }
            case HEALTH: {
                return "Health";
            }
            case HP5: {
                return "Health per second";
            }
            case INCREASED_RARITY: {
                return " Item Rarity";
            }
            case INTELLIGENCE: {
                return "Intelligence";
            }
            case LIFE_STEAL: {
                return "Lifesteal";
            }
            case MAGIC_RESIST: {
                return "Magic Resist";
            }
            case MANA: {
                return "Mana";
            }
            case MP5: {
                return "Mana per second";
            }
            case POWER: {
                return "Power";
            }
            case RESILIENCE: {
                return "Reduced effect of Mana Burns";
            }
            case SOCKETS: {
                return "Socketed";
            }
            case STRENGTH: {
                return "Strength";
            }
            case TENACITY: {
                return "Reduces damage taken while Crowd Controlled by ";
            }
            case WISDOM: {
                return "Wisdom";
            }
        }
        return "";
    }

    public static String getAttributeInfo(ItemAttributes itemAttributes, int n2, String string) {
        switch (itemAttributes) {
            case AGILITY: {
                return "[RARITY_UNIQUE]Agility: " + string + n2 + "[WHITE]\n Increases Power by " + string + Engine.a((float)n2 * 0.125f, 0) + "[].\n Increases Armor by " + string + Engine.a((float)n2 * 0.15f, 0) + "[].\n Increases Crit Chance by " + string + Engine.a(0.01875 * (double)((float)n2 * 0.2f), 2) + "%[].";
            }
            case ARMOR: {
                return "[RARITY_UNIQUE]Armor: " + string + n2 + "[WHITE]\n Reduces physical damage taken by " + string + Engine.a(100.0f * ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().float_a(dj.class), 2) + "%[]";
            }
            case CRITICAL_CHANCE: {
                return "[RARITY_UNIQUE]Critical Chance: " + string + n2 + "[WHITE]\n Abilities have a " + string + Engine.a(100.0f * ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().float_a(dm.class), 2) + "%[]" + " to deal 1.5x\nmore. DoTs and HoTs cannot crit.";
            }
            case HEALTH: {
                return "[RARITY_UNIQUE]Health: " + string + n2 + "[WHITE]\n Your Maximum Health pool.";
            }
            case HP5: {
                return "[RARITY_UNIQUE]Health Regeneration: " + string + n2 + "[WHITE]\n Restores missing Health every second.";
            }
            case INCREASED_RARITY: {
                return "[RARITY_UNIQUE]Item Rarity: " + string + Engine.a(100.0f * ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().float_a(dr.class), 2) + "%[WHITE]\n Increases the quality of items found.\n Increases the chance to find\n[RARITY_LEGENDARY]Legendary items[].";
            }
            case INTELLIGENCE: {
                return "[RARITY_UNIQUE]Intelligence: " + string + n2 + "[WHITE]\n Increases Power by " + string + Engine.a((float)n2 * 0.125f, 0) + "[].\n Increases Mana by " + string + n2 + "[].\n Increases Magic Resist by " + string + Engine.a((float)n2 * 0.1f, 0) + "[].\n Increases Crit Chance by " + string + Engine.a(0.01875 * (double)((float)n2 * 0.2f), 2) + "%[].";
            }
            case LIFE_STEAL: {
                return "[RARITY_UNIQUE]Lifesteal: " + string + Engine.a((float)ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a(dt.class) / 100.0f, 2) + "%[WHITE]\n Your Abilities heal you equal to a\npercentage of the damage dealt.";
            }
            case MAGIC_RESIST: {
                return "[RARITY_UNIQUE]Magic Resist: " + string + n2 + "[WHITE]\n Reduces magic damage taken by " + string + Engine.a(100.0f * ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().float_a(dv.class), 2) + "%[]";
            }
            case MANA: {
                return "[RARITY_UNIQUE]Mana: " + string + n2 + "[WHITE]\n Your Maximum Mana pool.";
            }
            case MP5: {
                return "[RARITY_UNIQUE]Mana Regeneration: " + string + n2 + "[WHITE]\n Restores missing Mana every second.";
            }
            case POWER: {
                return "[RARITY_UNIQUE]Power: " + string + n2 + "[WHITE]\n Increases damage and healing done.\n Abilities with [ORANGE]orange tooltip values[]\nscale with your Power.\n Weapon and Primary Attributes\nincrease your Power.";
            }
            case RESILIENCE: {
                return "Reduces the effectiveness of incoming Mana Burns by ";
            }
            case SOCKETS: {
                return "Insert Gems, Jewels, or Runes into the Socket to alter the item. (NOT YET IMPLEMENTED)";
            }
            case STRENGTH: {
                return "[RARITY_UNIQUE]Strength: " + string + n2 + "[WHITE]\n Increases Power by " + string + Engine.a((float)n2 * 0.15f, 0) + "[].\n Increases Health by " + string + n2 * 2 + "[].\n";
            }
            case TENACITY: {
                return " - Crowd Control sources include: Stun, Incapacitate, Fear, and Sheep";
            }
            case WISDOM: {
                return "[RARITY_UNIQUE]Wisdom: " + string + n2 + "[WHITE]\n Increases Power by " + string + Engine.a((float)n2 * 0.15f, 0) + "[].\n Increases Mana by " + string + n2 * 2 + "[].\n Increases Mana/sec by " + string + Engine.a((float)n2 / 5.0f * 0.1f, 1) + "[].\n";
            }
        }
        return " - Complain to the devs! Not yet implemented";
    }

    public static String getAdvancedTooltipName(ItemAttributes itemAttributes, int n2, String string) {
        switch (itemAttributes) {
            case AGILITY: {
                return " - A Primary Attribute for [CLASS_COLOR_ASSASSIN]Assassin[], [CLASS_COLOR_CHAMPION]Champion[], [CLASS_COLOR_ELDER]Elder[], and [CLASS_COLOR_RANGER]Ranger[] granting " + string + Engine.a((float)n2 * 0.125f, 0) + " Power[][RED] ONLY to those Classes[]. In addition, [GREEN]all classes[] gain " + string + Engine.a((float)n2 * 0.15f, 0) + " Armor[] and " + string + "Increases Critical Strike Chance by " + Engine.a(0.01875 * (double)((float)n2 * 0.2f), 2) + "%[].";
            }
            case ARMOR: {
                return " - Reduces Damage taken from Physical Sources (typically Attacks) by " + string + Engine.a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().a(dj.class, (float)(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a(dj.class) + n2) - ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().float_a(dj.class)), 2) + "%[]";
            }
            case CRITICAL_CHANCE: {
                return " - Your Abilities have a chance to deal 1.5x more. DoTs and HoTs cannot be Critical Strikes.";
            }
            case HEALTH: {
                return " - Increases your Maximum Health pool.";
            }
            case HP5: {
                return " - Restores missing Health every second during battle.";
            }
            case INCREASED_RARITY: {
                return " - Feeling lucky?";
            }
            case INTELLIGENCE: {
                return " - A Primary Attribute for [CLASS_COLOR_LICH]Lich[], [CLASS_COLOR_MYSTIC]Mystic[], [CLASS_COLOR_NIHILIST]Nihilist[], [CLASS_COLOR_SCHOLAR]Scholar[], and [CLASS_COLOR_WIZARD]Wizard[] granting " + string + Engine.a((float)n2 * 0.125f, 0) + " Power[][RED] ONLY to those Classes[]. In addition, [GREEN]all classes[] gain " + string + Engine.a((float)n2 * 0.1f, 0) + " Magic Resist[], " + string + n2 + " Mana[] and " + string + "Increases Critical Strike Chance by " + Engine.a(0.01875 * (double)((float)n2 * 0.2f), 2) + "%[].";
            }
            case LIFE_STEAL: {
                return " - All sources of damage you deal cause you to restore Health.";
            }
            case MAGIC_RESIST: {
                return " - Reduces Damage taken from Magical Sources (typically Spells) by " + string + Engine.a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().a(dv.class, (float)(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a(dv.class) + n2) - ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().float_a(dv.class)), 2) + "%[]";
            }
            case MANA: {
                return " - Increases your Maximum Mana pool, if your class uses Mana as a Resource.";
            }
            case MP5: {
                return "- Restores missing Mana every second during battle, if your class uses Mana as a Resource.";
            }
            case POWER: {
                return " - Increases Damage and Healing dealt with Abilities. Primary Attributes increase your Power.";
            }
            case RESILIENCE: {
                return "Reduces the effectiveness of incoming Mana Burns by ";
            }
            case SOCKETS: {
                return "Insert Gems, Jewels, or Runes into the Socket to alter the item. (NOT YET IMPLEMENTED)";
            }
            case STRENGTH: {
                return " - A Primary Attribute for [CLASS_COLOR_ASSASSIN]Assassin[], [CLASS_COLOR_CHAMPION]Champion[], [CLASS_COLOR_LICH]Lich[], [CLASS_COLOR_NIHILIST]Nihilist[], [CLASS_COLOR_PALADIN]Paladin[], and [CLASS_COLOR_RANGER]Ranger[] granting " + string + Engine.a((float)n2 * 0.15f, 0) + " Power[][RED] ONLY to those Classes[]. In addition, [GREEN]all classes[] gain " + string + n2 * 2 + " Health[].";
            }
            case TENACITY: {
                return " - Crowd Control sources include: Stun, Incapacitate, Fear, and Sheep";
            }
            case WISDOM: {
                return " - A Primary Attribute for [CLASS_COLOR_ELDER]Elder[], [CLASS_COLOR_MYSTIC]Mystic[], [CLASS_COLOR_PALADIN]Paladin[], [CLASS_COLOR_SCHOLAR]Scholar[], and [CLASS_COLOR_WIZARD]Wizard[] granting " + string + Engine.a((float)n2 * 0.15f, 0) + " Power[][RED] ONLY to those Classes[]. In addition, [GREEN]all classes[] gain " + string + n2 * 2 + " Mana[] and " + string + " Restores " + Engine.a((float)n2 / 5.0f * 0.1f, 1) + " Mana per Second[].";
            }
        }
        return " - Complain to the devs! Not yet implemented";
    }
}

