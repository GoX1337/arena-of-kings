/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.gameserver.data.updates;

public enum SpellName {
    AUTO_ATTACK("Delivers an auto attack"),
    Empty("No ability has been assigned to this slot"),
    Assassin_Basic("A basic ability"),
    Annihilate("[Skill] - Deals X physical damage to target enemy. If target enemy is below 20% health they suffer an additional Y physical damage. Lose all of your energy, increasing the damage dealt by this ability by 1% for each energy lost."),
    Bandage("[Skill] - Removes the most recently applied status effect from self and heals for X over 6 seconds."),
    Dash("[Skill] - For 3 seconds you have 33% increased Movement Speed."),
    Daze("[Skill] - Target enemy suffers X physical damage and is effected with incapacitate for 3 seconds."),
    DisappearingAct("[Skill] - Applies Blind to all nearby enemies for 4 seconds."),
    Envenom(""),
    MurderousInstincts("[Skill] - Your damaging attacks and abilities have a 25% to deal X physical damage and apply Hobble for 5 seconds."),
    PoisonedBlades(""),
    Puncture(""),
    ShadowWalk("[Spell] - Teleport to target. If you teleported to an enemy they are slowed by 33% for 3 seconds."),
    Shroud("[Spell] - You gain 50% Deflection rating for 4 seconds and remove all curse effects from yourself. For each Curse effect removed you restore X health."),
    Slap("[Skill] - Target enemy suffers X physical damage and interrupts them."),
    Slash("[Skill] - Target enemy suffers X physical damage and is effected with Bleeding 9 seconds."),
    Stealth("[Skill] - You become invisible to your enemies for 5 seconds. Using any ability ends Stealth."),
    TempleStrike("[Skill] - Target enemy suffers X physical damage and is effected with Stun for 2 seconds."),
    WhirlingKnives("[Skill] - Knives flare out from the assassin dealing X physical damage to nearby enemies."),
    EmbraceShadows("[Spell] - Remove all curse effects from yourself. For each Curse effect removed you restore X health."),
    ArmorBreak("[Skill] - Deals X physical damage and interrupts target enemy's ability."),
    Champion_Basic("A basic ability"),
    Coward("[Skill] - Interrupts and applies Silence to target enemy for 2 seconds."),
    CripplingSlash("[Skill] - Target enemy suffers X physical damage and applies Hobble to target enemy for 7 seconds."),
    CrushingBlow("[Skill] - Deals X physical damage and applies Stun to target enemy for 2 seconds."),
    Decapitate("[Skill] - If target enemy has less than 25% health they suffer X physical damage, otherwise they suffer Y physical damage. You lose all of your rage."),
    EnduringWarcry("[Skill] - For 12 seconds all allies within earshot gain X% increased health. You gain 15 Rage."),
    Enrage("[Skill] - Increases your Power by 350 for 5 seconds and you gain 25 Rage."),
    Intimidation("TODO"),
    Lacerate("[Skill] - Deals X physical damage and applies Laceration to target enemy for 7 seconds."),
    MasterOfTheSword("[Skill] For 3 seconds swords protect the Champion, increasing Deflection by 20% and dealing X physical damage to nearby enemies every second."),
    PiercingDagger("[Skill] Throws a dagger at target enemy dealing damage."),
    ResoundingWarcry("[Skill] - For 12 seconds all allies within earshot gain X% increased Armor and Critical Strike. You gain 15 Rage."),
    Safeguard(""),
    SlashingStrike("[Skill] - Deals X physical damage and applies Bleeding to target enemy for 8 seconds."),
    Sprint("[Skill] - For 6 seconds you have 25% increased Movement Speed."),
    Whirlwind("[Skill] - Deals X physical damage to all nearby enemies."),
    Elder_Basic("A basic ability"),
    GraspingVines("[Spell] - Decreases Movement Speed to 0% and deals X magic damage over 2.5 seconds to target enemy."),
    Inspiration("[Enchantment] - For 10 seconds, target ally restores (X) 200 mana every second "),
    MendingSpirit("[Spell] - Heals target ally for X health every second for 6 seconds."),
    CorrosiveAsp(""),
    Remedy("[Spell] - Heal target other ally for X health and removes the most recently applied harm effect. If a harm effect was removed, target ally is healed an additional Y."),
    Revitalize("[Spell] - Heal target ally for X and apply a HoT for 8 seconds. Heals an additional Y for each enchantment on the target."),
    Ritual("[Aura] - Increases the Class Mastery of all allies by X"),
    SeedOfLife("[Spell] - Heals target ally for X every second. After 3 seconds remove this effect from target ally and apply this to your lowest health ally. Bounces 2 times."),
    Serenity("[Spell] - Heals all allies in the radius for X every second. Lasts 3 seconds. When this effect expires heals all allies an additional Y health."),
    SpiritWolf("[Spell] - You transform into a Spirit Wolf, removing all root and slowing effects and increasing Movement Speed by 35%. Casting a spell removes the Spirit Wolf enchantment."),
    Soothe("[Spell] - Heal target ally for X health every Y seconds."),
    Symbiosis("[Spell] - Heals all allies in the radius for X every second. Lasts 3 seconds. When this effect expires heals all allies an additional Y health."),
    Bear(""),
    Bear_Charge(""),
    Bear_Smash(""),
    Bear_Ironhide(""),
    ToxicSpore("[Spell] - Place a toxic spore at target location. After 1 second the Spore bursts dealing X magic damage to all enemies in the area and applies poison to them for 7 seconds."),
    Windstorm("[Spell] - Places a windstorm at target location lasting 5 seconds. Deals X magic damage every second to all enemies in the radius and applies Bleeding for 6 seconds."),
    Lich_Basic("A basic ability"),
    AbyssalSpike("[Spell] - Deals X magic damage to target enemy and applies stun for 1 second."),
    AcidRain("[Spell] - Lasts for 6 seconds. Damages enemies in target location for X magic damage every second and lowers their armor and magic resist by 20% for 3 seconds."),
    BloodOfTheDying(""),
    Contagion("[Aura] - Lowers the Magic Resistance of nearby enemies by 10%."),
    DeathsGrasp("[Spell] - Death's hand rises from the ground at target area, causing X magic damage and inflicts bleeding for 6 seconds and immobilize for 2 seconds."),
    Depravity("[Spell] - For 7 seconds, target enemy loses X mana every second. Deals Y damage for each mana burned."),
    Exhaustion("[Spell] - Target enemy is slowed by 25% for 6 seconds."),
    Inflame(""),
    Miasma("[Spell] - Target enemy and all nearby enemies of that target suffer X magic damage every second for 8 seconds."),
    NetherBolt("[Spell]"),
    Parasite("[Spell] - For 9 seconds target enemy suffers X magic damage every second. You are healed for 30% of the damage dealt."),
    PoisonNova("[Spell] - Conjure an outward expanding ring around the Lich that deals X magic damage and inflicts Poison for 6 seconds to enemies hit by the ring."),
    PoolOfAgony(""),
    PoolOfSouls(""),
    SacrificeSoul("[Spell] - Restore 4% of total mana."),
    ShatterMagic("[Spell] - Deals X magic damage to target enemy instantly and deals an additional Y magic damage over 4 seconds."),
    Pestilence("[Spell] Channeled over 3 seconds. Target enemy suffers X magic damage and loses Y mana every second."),
    Terrify("[Spell]"),
    Torment("[Spell] - For 18 seconds, target enemy loses 9 health per second."),
    UnderworldArmor("[Spell] - For 8 seconds, target ally has X% increased armor and receives 20% increased healing received."),
    Mystic_Basic("A basic ability"),
    Aegis("[Spell] - Heal target ally for X health. For 6 seconds target ally gains 30% chance to deflect incoming attacks and spells. Whenever that ally performs a deflection restore Y health."),
    AstralShock("[Spell] - Deals X magical damage to target enemy and applies Laceration for 6 seconds."),
    Blackout("[Spell]  - Deals X magic damage and stuns target enemy for 1.5 seconds."),
    BlessingSunAndMoon("[Spell] - Removes the most recently applied harm or curse effect from all allies. If an effect was removed this way, that ally is healed for X"),
    Cleanse("[Spell] - Removes the most recently applied curse and harm effect from target ally. For each effect was removed, target ally is healed for X."),
    CosmicInfusion(""),
    Divination("[Spell] - You restore X mana every second for 4 seconds. The amount of mana restored doubles every second."),
    SpiritForm("[Spell] - [Spell] - Target enemy suffers from Life Stream for 6 seconds. Life Stream reduces healing received by 20% and transfers that amount healed to the caster's party members split evenly."),
    TemporalBarrier("[Spell] For 6 seconds, target ally has a shield absorbing X damage. When Temporal Shield ends, heal target ally for Y."),
    LifeStream("[Spell] - Channeled over 3 seconds. Heals target ally for X health every second. Every second spent channeling increases the healing from Light Steam by 15%."),
    HealingVision("[Spell] Restores X health to target ally. Restore an additional Y health and Z mana to target ally if that ally is under the effects of a curse or harm effect."),
    DreamOfProsperity("[Spell] - Restores X health to all party members."),
    Disenchant("[Spell] - Removes the most recently applied enchantment from all enemies in target location."),
    ManaTap("[Spell] - Target enemy loses X mana. For each mana lost they suffer Y magic damage."),
    Nihilist_Basic("A basic ability"),
    Amalgamation("[Aura] - Deals X magic damage to nearby enemies every second and heals you for 30% of the damage dealt."),
    Blink("[Passive] - Healing an ally applies a shield to that ally, absorbing X damage for 2 seconds."),
    ChaosWave(""),
    DarkInoculation(""),
    Infuse("[Spell] - Restore X health to target ally. If that ally was below 50% health Infuse restores 1.75x more health."),
    Karma("[Spell] If target is an enemy reduces their armor and magic resistance by 15% for 6 seconds. If target is an ally increases their armor and magic resistance by 25% for 6 seconds."),
    LingeringDemise("[Spell] - For 7 seconds target enemy suffers from Lingering Demise. If this spell expires naturally it deals X magic damage for every second Lingering Demise was active."),
    MindLeech("[Spell] - Deals x magic damage to target enemy every second for 8 seconds. Heals all allies for y% of damage dealt."),
    OrbOfAbsolution("[Spell] - Place an orb at target location for 9 seconds. When placed and every 3 seconds thereafter, remove the most recently applied negative effect from all allies in the radius. The orb has X health and can be targeted."),
    OrbOfReplenishment("[Spell] - Place an orb at target location for 9 seconds. When placed and every 2 seconds thereafter, restore X health to all allies near the orb. The orb has X health and can be targeted."),
    OrbOfSmoke("[Spell] - Place an orb at target location for 6 seconds. When placed and every 3 seconds thereafter, nearby enemies suffer from Blind for 2 seconds and take Y magic damage. The orb has X health and can be targeted."),
    OrbOfWisdom("[Spell] - Place an orb at target location for 9 seconds. When placed and every 2 seconds thereafter, restore X mana to all allies near the orb. The orb has X health and can be targeted."),
    Rockslide("[Spell] - Deals X magic damage to all enemies inside the area every second and inflicts Stun for 1.5 seconds when this spell ends."),
    ShadowAffinity("[Spell] - Heal target ally for X health. Restores Y health over Z seconds."),
    SiphonMana("[Spell] - For 6 seconds target enemy loses X mana every second and you restore Y mana."),
    SpellBreaker("[Spell] Remove the most recently applied curse from target ally. For 3.5 seconds, target ally deflects the next 2 incoming spells from an enemy. If a spell was deflected in this way, target ally restores X health."),
    Paladin_Basic("A basic ability"),
    AngelicStrike("[Skill] - Deals X physical damage to target enemy. Removes the most recently applied enchantment."),
    BlazingSlash("[Skill] - Deals X physical damage to target enemy and applies Burning to all nearby enemies for 4 seconds."),
    SealOfTheHeavens("[Spell] - Decreases damage taken by X% and heals for Y every second for 6 seconds."),
    DivineLight("[Spell] - Heals target ally for X health."),
    SealOfTheCrusader("[Skill] - Instantly heals target ally for X while empowering their weapon, causing abilities heal themself for Y for 8 seconds."),
    GlimmerOfLight(""),
    HeavensStrike(""),
    HolyNova("[Spell] - Deals X magic damage to nearby enemies and heals nearby allies for Y."),
    Sear("[Skill] - Deals X magic damage and Y physical damage to target enemy. Deals an additional Z magic damage if the enemy is suffering from Burning."),
    Prudence(""),
    Purify("[Spell] - Heal target ally for X health and removes the most recently applied curse and harm effect. If a curse or harm effect was removed, target ally is healed an additional Y."),
    Sanctuary("[Aura] - Nearby allies gain X% increased armor and magic resistance."),
    ShatteringSlash("[Skill] - Deals X physical damage to target enemy. Removes the most recently applied enchantment."),
    StreamOfLight(""),
    Valor("[Skill] - Increases target ally's armor and magic resist by 35% for 3 seconds."),
    WrathOfHeaven("[Spell] - Target enemy and all nearby enemies suffer X magic damage. Restores health to all allies evenly for 20% of damage dealt."),
    Ranger_Basic("A basic ability"),
    AetherShot("[Skill] - Deals X magical damage to target enemy and they lose Y mana every second for 8 seconds."),
    ElementalArrow("[Skill] - Deals X magical damage and applies Burning for 4 seconds to target enemy and all nearby enemies."),
    Precision("[Passive Aura] - Increases the deflection penetration of all allies by 15%."),
    SilencingShot("[Skill] - Deals X physical damage to target enemy and applies Silence for 1 second."),
    DebilitatingShot("[Skill] - Applies Fatigue to target enemy and they lose 66 mana."),
    TwistingShot("[Skill] - Deals X physical damage to target enemy and applies Hobble for 7 seconds."),
    HeadShot("[Skill] - Deals X physical damage and applies Stun for 2 seconds."),
    ContagionShot("[Skill] - Deals X physical damage and applies Blind and Burning for 4 seconds to target enemy."),
    AntidotePotion("[Skill] - Removes a harm effect from yourself."),
    LightningArrow(""),
    NightmareShot(""),
    MarkOfDeath("[Curse Spell] - For 8 seconds, target enemy suffers 20% additional damage from all sources."),
    PoisonousShot("[Skill] - Deals X physical damage and applies Poison to target enemy for 7 seconds."),
    Quicksand("[Skill] - Slows enemies inside of the trap by 25%. Lasts for 12 seconds."),
    RejuvinationPotion(""),
    ShatteringShot("[Skill] - Deals X physical damage to target enemy and X physical damage to enemies around your target."),
    RainOfArrows("[Skill"),
    Vigor("Increases your Movement Speed by 20%."),
    Scholar_Basic("A basic ability"),
    Armageddon("[Spell] - Deals X magic damage to all enemies in target area every second for 4 seconds and applies Burning for 2 seconds each time an enemy is hit by this spell. Armageddon deals an additional 20% damage against enemies suffering from Burning."),
    EtherealBindings("[Spell] - Deals X magic damage every second and slows target enemy for 30% for 6 seconds."),
    GospelOfDefiance("[Spell] - All allies gain X% increased armor, magic resist, and deflection rating for 8 seconds."),
    GospelOfHarmony("[Spell] - Heal all allies for X and heal an additional Y health over 10 seconds."),
    GospelOfOnslaught("[Spell] - All allies gain X% increased power for 7 seconds."),
    GospelOfPurity(""),
    Immortality("[Spell] - Target ally becomes immune to all forms of damage for 3 seconds."),
    Judgement("[Spell] - Deals X damage if target is an enemy. Heals for Y if target is an ally."),
    LifeBurst("[Spell] - [Spell] - Heals target ally and all nearby allies of that target by X."),
    Mesmerize("[Spell] - Incapacitates all nearby enemies for 1.5 seconds."),
    Portal("[Spell] - Opens a teleportation portal between you and target ally, swapping your locations and healing both of you for X."),
    RiteOfPassage("[Spell] Target ally becomes immune to all root and slowing effects for 5 seconds and is healed for X health every second."),
    Silence("[Spell] - Applies Silence to target enemy for 2 seconds."),
    TransferLife("[Spell] - Target other ally is healed for 41% of your current health. Lose 25% of your current health."),
    Truth("[Aura] - Increases the primary attribute of all nearby allies by X and mana regeneration by Y."),
    Wizard_Basic("A basic ability"),
    AganothsDescent(""),
    LightsWrath("[Spell] - All enemies in the area suffer X magic damage and Blind for 4 seconds."),
    Charge("[Spell] - Charge at an enemy, stunning them for .5 seconds and generating some rage."),
    ChillingArmor(""),
    Combust("[Spell] - Target enemy suffers from Burning for 3 seconds and Combust. The next time that enemy suffers fire spell damage, the damage is increased by 30% and Combust is removed."),
    Counterspell("[Spell] - Interrupt target enemy and all nearby enemies."),
    Crystallize(""),
    EyeOfTheStorm(""),
    Fireball("[Spell] - Fires a projectile toward target enemy dealing X magic damage and applies from Burning for 2 seconds."),
    FlashFreeze("[Spell] - PBAE. Deals X magic damage to all nearby enemies and freezes them in place for 4 seconds."),
    ShockNova(""),
    Frostbolt("[Spell] - Fires a projectile toward target enemy dealing X magic damage and slowing them by 30% for 4 seconds."),
    Geyser("[Spell] - Place a geyser at target location. After 1 second the Geser erupts dealing X magic damage to all enemies in the area and incapacitates them for .5 seconds."),
    IceSpikes("[Spell] - Deals X magic damage to target enemy and all nearby enemies. Applies immobilize for 3 seconds."),
    LightningStrike("[Spell] - Deals X magic damage to target enemy and dispels all buffs."),
    MagicMissiles("[Spell] - Shoots icy missiles at target enemy, dealing additional damage if they are chilled or frozen.."),
    MasterOfMagic("[Spell] - For 10 seconds your next spell deals 30% additional damage and restores mana equal to twice the casting cost."),
    Meteor("[Spell] - Calls down an incendiary meteor at target location. Upon impact, Metoer deals X magic damage to all enemies in the radius, interrupts their action, and creates burning ground for 4 seconds inflicting Burning on enemies that enter the region for 2 seconds."),
    RunicShield("[Spell] - For 6 seconds Increases target ally's magic resistance by +X and absorbs Y damage."),
    Sheepify("[Spell"),
    Teleport("[Spell] - Teleport to target location."),
    ThundersWrath("[Spell] - Deals X magic damage to all enemies near target ally. Target ally is fully dispelled."),
    VolcanicEruption("[Spell] - [Spell] - Place a volcano at target location. After 0.4 seconds the volcano erupts dealing X magic damage to all enemies in the area and applies Burning for 6 seconds."),
    TrinketOfResolve(""),
    SummonDragonling(""),
    Meditate(""),
    VexathrasRain(""),
    VexathrasCurse(""),
    VexathrasShatter(""),
    VexathrasContagion(""),
    VexathrasGrasp(""),
    VexathrasFear(""),
    VexathrasFireball("");

    private String spellDescription;

    private SpellName(String string2) {
        this.spellDescription = string2;
    }

    public String getSpellDescription() {
        return this.spellDescription;
    }

    public static String getFormattedName(SpellName spellName) {
        if (spellName == Bear) {
            return "Shapeshift: Bear";
        }
        if (spellName == SpiritWolf) {
            return "Shapeshift: Spirit Wolf";
        }
        if (spellName == ArmorBreak) {
            return "Disrupting Blade";
        }
        if (spellName == MurderousInstincts) {
            return "Reckfulness";
        }
        if (spellName == RejuvinationPotion) {
            return "Rejuvenation Potion";
        }
        String string = spellName.name();
        StringBuilder stringBuilder = new StringBuilder();
        if (string.length() > 0) {
            stringBuilder.append(string.charAt(0));
        }
        for (int i2 = 1; i2 < string.length(); ++i2) {
            char c2 = string.charAt(i2);
            if (Character.isUpperCase(c2) && i2 != 0) {
                stringBuilder.append(' ');
            }
            stringBuilder.append(c2);
        }
        String string2 = stringBuilder.toString();
        return string2;
    }

    public static boolean isBasic(SpellName spellName) {
        return spellName == Assassin_Basic || spellName == Champion_Basic || spellName == Elder_Basic || spellName == Lich_Basic || spellName == Mystic_Basic || spellName == Nihilist_Basic || spellName == Paladin_Basic || spellName == Ranger_Basic || spellName == Scholar_Basic || spellName == Wizard_Basic;
    }
}

