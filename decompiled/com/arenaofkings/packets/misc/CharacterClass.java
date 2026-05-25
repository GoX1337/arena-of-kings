/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.misc;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.Array;

public enum CharacterClass {
    ASSASSIN("Assassins are masters of Stealth, capable of\nAnnihilating victims through bursts of Energy.\n\nSneak in or out of battle with skillful\ntactics to deceive and elude your opponents, Poison\nvulnerable foes when the flow of battle is in your favor.\n\nMastering the art of offense, control, and avoidance\nare essential in devastating those that stand in your way.\n\n\nRole:  Control, Damage, Utility\nArmor:  Leather\nDifficulty: Hard", "CLASS_COLOR_ASSASSIN"),
    CHAMPION("Champions are elite fighters with sheer force\nthat excel in close-combat brawls to generate Rage\nwhile supporting allies with powerful Warcries.\n\nEquipped with Plate armor and a massive two-handed\nsword, any foe within striking distance will swiftly be\nDecapitated from an onslaught of attacks.\n\nOne would be foolish to engage a Champion head-on\nin a fight.\n\nRole:  Damage, Utility\nArmor:  Plate\nDifficulty: Medium", "CLASS_COLOR_CHAMPION"),
    ELDER("Elders embody aspects of life and death\nthrough the form of nature magic.\n\nPrimarily Revitalizing allies with restorative Buffs and\nheals, the Elder can also conjure Windstorms to provide\nimmediate reprieve from fierce threats.\n\nShapeshift when in danger, transforming into a nimble\nSpirit Wolf that is tough to catch in any Arena.\n\n\nRole:  Healer, Sustain\nArmor:  Leather\nDifficulty: Easy", "CLASS_COLOR_ELDER"),
    LICH("Liches are exiled cultists with a fascination\nfor Shadow magic and Poisonous necromancy.\n\nWatch enemies languish from your dark Torment.\n\nPrimarily through curses and other Debuffs, a Lich\nwill slowly suck the life out of an entire enemy team.\n\nBe wary, for using black magic in exchange for\nPower may hurt you, making you vulnerable in the Arena.\n\nRole:  Damage, Control\nArmor:  Cloth\nDifficulty: Easy", "CLASS_COLOR_LICH"),
    MYSTIC("Mystics are prophetic seers that manipulate\nthreads of the universe through Spiritual\nrituals and communion of the supernatural.\n\nWearing only Cloth robes, Mystics rely on ancestral\ntutelage to cast Healing Visions and the conjuring of\nTemporal Barriers for defense.\n\nAs an alternative threat create a Blackout, unleashing\nvisions of Fear into your opponents' minds.\n\nRole:  Healer, Utility, Control\nArmor:  Cloth\nDifficulty: Hard", "CLASS_COLOR_MYSTIC"),
    NIHILIST("Nihilists are Power-hungry force users seduced\nby Mana assimilated from the corrupted Orb they carry.\n\nSummon diverse Orbs in the Arena to assist your\nallies, swaying the tides of battle in your favor.\n\nManipulate dark energy to infiltrate the Mind of your\nenemies, Leeching their life and rendering them\nhelpless, or convert it to heal and bolster\nyour allies' potency.\n\nRole:  Damage, Healer, Support, Utility\nArmor: Leather\nDifficulty: Hard", "CLASS_COLOR_NIHILIST"),
    PALADIN("Paladins are fanatical holy knights blessed with\nHeaven's Guidance.\n\nEquipped with a shield and exceptional Plate armor,\nprovide Sanctuary to allies through Divine spells\nor relentless aggression to foes that stand in your way.\n\nThis righteous force is capable of calling down Heaven's\nWrath at a moment's notice, vanquishing\nyour foes with Burning retribution.\n\nRole:  Hybrid, Utility\nArmor: Plate\nDifficulty:  Easy", "CLASS_COLOR_PALADIN"),
    RANGER("Rangers are seasoned pathfinders, adept at augmenting\ntheir arrows to apply variety of deadly Status Ailments.\n\nFire arrows into foes from a greater distance to deal\nadditional damage, leaving them\nBleeding, Hobbled, Poisoned, and Stunned.\n\nBeing highly mobile and flexible at target switching,\na Ranger can Rain  Arrows anytime, anywhere.\n\n\nRole:  Damage, Control\nArmor:  Leather\nDifficulty: Easy", "CLASS_COLOR_RANGER"),
    SCHOLAR("Scholars are religious followers and students of\nNosrevi, one of the Old Gods.\n\nThese supportive Truth-seekers recite Gospels,\nproviding tremendously powerful global Buffs\nto all allies in the Arena.\n\nInstead of using brute force, Scholars rely on\nunique Crowd Control and various utility spells to\nmake the presence of their Gods felt in the Arena.\n\nRole:  Healer, Utility, Control\nArmor:  Cloth\nDifficulty: Medium", "CLASS_COLOR_SCHOLAR"),
    WIZARD("Wizards are disciplined masters of Fire, Ice,\nLightning, and Arcane schools of magic.\n\nUtilizing a combinations of the elements, manipulate\nthe flow of battle within the blink of an eye.\n\nThrough Teleportation, Burning Meteors, Shocking\nLightning Strikes, or violent Ice Storms,\nenemies will be overwhelmed by an elemental\nonslaught created by a clever Wizard.\n\nRole:  Control, Damage, Utility\nArmor:  Cloth\nDifficulty: Hard", "CLASS_COLOR_WIZARD");

    private String description;
    private String classColor;

    private CharacterClass(String string2, String string3) {
        this.description = string2;
        this.classColor = string3;
    }

    public String getClassColor() {
        return this.classColor;
    }

    public static Color getClassColorObj(CharacterClass characterClass) {
        switch (characterClass) {
            case ASSASSIN: {
                return axe.O;
            }
            case CHAMPION: {
                return axe.P;
            }
            case ELDER: {
                return axe.Q;
            }
            case LICH: {
                return axe.R;
            }
            case MYSTIC: {
                return axe.S;
            }
            case NIHILIST: {
                return axe.T;
            }
            case PALADIN: {
                return axe.U;
            }
            case RANGER: {
                return axe.V;
            }
            case SCHOLAR: {
                return axe.W;
            }
            case WIZARD: {
                return Color.SKY;
            }
        }
        return axe.O;
    }

    public String getClassColorTextFormatted() {
        return "[" + this.classColor + "]";
    }

    public static String simpleName(CharacterClass characterClass) {
        switch (characterClass) {
            case ASSASSIN: {
                return "Assassin";
            }
            case CHAMPION: {
                return "Champion";
            }
            case ELDER: {
                return "Elder";
            }
            case LICH: {
                return "Lich";
            }
            case MYSTIC: {
                return "Mystic";
            }
            case NIHILIST: {
                return "Nihilist";
            }
            case PALADIN: {
                return "Paladin";
            }
            case RANGER: {
                return "Ranger";
            }
            case SCHOLAR: {
                return "Scholar";
            }
            case WIZARD: {
                return "Wizard";
            }
        }
        return "Player";
    }

    public static CharacterClass fromString(String string) {
        if (string.equalsIgnoreCase(ASSASSIN.toString())) {
            return ASSASSIN;
        }
        if (string.equalsIgnoreCase(ELDER.toString())) {
            return ELDER;
        }
        if (string.equalsIgnoreCase(PALADIN.toString())) {
            return PALADIN;
        }
        if (string.equalsIgnoreCase(MYSTIC.toString())) {
            return MYSTIC;
        }
        if (string.equalsIgnoreCase(NIHILIST.toString())) {
            return NIHILIST;
        }
        if (string.equalsIgnoreCase(LICH.toString())) {
            return LICH;
        }
        if (string.equalsIgnoreCase(RANGER.toString())) {
            return RANGER;
        }
        if (string.equalsIgnoreCase(CHAMPION.toString())) {
            return CHAMPION;
        }
        if (string.equalsIgnoreCase(WIZARD.toString())) {
            return WIZARD;
        }
        if (string.equalsIgnoreCase(SCHOLAR.toString())) {
            return SCHOLAR;
        }
        Engine.a("[ERROR] Couldn't determine the CharacterClass.");
        return null;
    }

    public static String convertToString(CharacterClass characterClass) {
        switch (characterClass) {
            case ASSASSIN: {
                return "Assassin";
            }
            case ELDER: {
                return "Elder";
            }
            case PALADIN: {
                return "Paladin";
            }
            case MYSTIC: {
                return "Mystic";
            }
            case NIHILIST: {
                return "Nihilist";
            }
            case LICH: {
                return "Lich";
            }
            case RANGER: {
                return "Ranger";
            }
            case CHAMPION: {
                return "Champion";
            }
            case WIZARD: {
                return "Wizard";
            }
            case SCHOLAR: {
                return "Scholar";
            }
        }
        Engine.a("[ERROR] Couldn't convert the CharacterClass.");
        return "Unknown";
    }

    public String getDescription() {
        return this.description;
    }

    public static Array<String> getStarterSpells(CharacterClass characterClass) {
        Array<String> array = new Array<String>(8);
        switch (characterClass) {
            case ASSASSIN: {
                array.add(SpellName.Annihilate.name());
                array.add(SpellName.Envenom.name());
                array.add(SpellName.Puncture.name());
                array.add(SpellName.Daze.name());
                array.add(SpellName.Slap.name());
                array.add(SpellName.Stealth.name());
                array.add(SpellName.Shroud.name());
                array.add(SpellName.Bandage.name());
                break;
            }
            case CHAMPION: {
                array.add(SpellName.Lacerate.name());
                array.add(SpellName.SlashingStrike.name());
                array.add(SpellName.CrushingBlow.name());
                array.add(SpellName.Charge.name());
                array.add(SpellName.Whirlwind.name());
                array.add(SpellName.ArmorBreak.name());
                array.add(SpellName.EnduringWarcry.name());
                array.add(SpellName.Intimidation.name());
                break;
            }
            case ELDER: {
                array.add(SpellName.Revitalize.name());
                array.add(SpellName.MendingSpirit.name());
                array.add(SpellName.Remedy.name());
                array.add(SpellName.Soothe.name());
                array.add(SpellName.Symbiosis.name());
                array.add(SpellName.Inspiration.name());
                array.add(SpellName.Bear.name());
                array.add(SpellName.Ritual.name());
                break;
            }
            case LICH: {
                array.add(SpellName.Torment.name());
                array.add(SpellName.Inflame.name());
                array.add(SpellName.Parasite.name());
                array.add(SpellName.Pestilence.name());
                array.add(SpellName.Terrify.name());
                array.add(SpellName.AbyssalSpike.name());
                array.add(SpellName.BloodOfTheDying.name());
                array.add(SpellName.UnderworldArmor.name());
                break;
            }
            case MYSTIC: {
                array.add(SpellName.HealingVision.name());
                array.add(SpellName.TemporalBarrier.name());
                array.add(SpellName.DreamOfProsperity.name());
                array.add(SpellName.BlessingSunAndMoon.name());
                array.add(SpellName.Cleanse.name());
                array.add(SpellName.Divination.name());
                array.add(SpellName.Blackout.name());
                array.add(SpellName.SpiritForm.name());
                break;
            }
            case NIHILIST: {
                array.add(SpellName.MindLeech.name());
                array.add(SpellName.Karma.name());
                array.add(SpellName.LingeringDemise.name());
                array.add(SpellName.SiphonMana.name());
                array.add(SpellName.ChaosWave.name());
                array.add(SpellName.OrbOfWisdom.name());
                array.add(SpellName.SpellBreaker.name());
                array.add(SpellName.DarkInoculation.name());
                break;
            }
            case PALADIN: {
                array.add(SpellName.BlazingSlash.name());
                array.add(SpellName.Sear.name());
                array.add(SpellName.HeavensStrike.name());
                array.add(SpellName.HolyNova.name());
                array.add(SpellName.DivineLight.name());
                array.add(SpellName.SealOfTheHeavens.name());
                array.add(SpellName.Immortality.name());
                array.add(SpellName.Sanctuary.name());
                break;
            }
            case RANGER: {
                array.add(SpellName.HeadShot.name());
                array.add(SpellName.ElementalArrow.name());
                array.add(SpellName.PoisonousShot.name());
                array.add(SpellName.TwistingShot.name());
                array.add(SpellName.SilencingShot.name());
                array.add(SpellName.NightmareShot.name());
                array.add(SpellName.Vigor.name());
                array.add(SpellName.RejuvinationPotion.name());
                break;
            }
            case SCHOLAR: {
                array.add(SpellName.TransferLife.name());
                array.add(SpellName.LifeBurst.name());
                array.add(SpellName.GospelOfPurity.name());
                array.add(SpellName.GospelOfHarmony.name());
                array.add(SpellName.GospelOfDefiance.name());
                array.add(SpellName.Portal.name());
                array.add(SpellName.Immortality.name());
                array.add(SpellName.Truth.name());
                break;
            }
            case WIZARD: {
                array.add(SpellName.Fireball.name());
                array.add(SpellName.AganothsDescent.name());
                array.add(SpellName.Combust.name());
                array.add(SpellName.Meteor.name());
                array.add(SpellName.FlashFreeze.name());
                array.add(SpellName.Sheepify.name());
                array.add(SpellName.Teleport.name());
                array.add(SpellName.Crystallize.name());
                break;
            }
        }
        return array;
    }
}

