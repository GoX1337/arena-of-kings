package com.arenaofkings;

import java.util.Map;
import java.util.TreeMap;

/**
 * Spell registry for the prototype spell bar: character -> spell names.
 * Names match asset folders exactly: assets/spells/&lt;character&gt;/&lt;spell&gt;/
 * containing {@code <spell>_on_tick.atlas} (or {@code <spell>.atlas}) and
 * {@code <spell>.ogg} (or {@code <spell>-2.ogg}). Lists generated from disk.
 */
public final class Spells {
  private static final Map<String, String[]> BY_CHARACTER = new TreeMap<>();

  static {
    BY_CHARACTER.put("assassin", new String[]{
        "Annihilate", "Bandage", "Basic", "Dash", "Daze", "DustCloud",
        "EmbraceShadows", "Envenom", "MurderousInstincts", "Puncture",
        "ShadowWalk", "Shroud", "Slap", "Slash", "Stealth", "TempleStrike",
        "WhirlingKnives"});
    BY_CHARACTER.put("champion", new String[]{
        "Basic", "Charge", "CripplingSlash", "CrushingBlow", "Decapitate",
        "DisruptingBlade", "EnduringWarcry", "Enrage", "Intimidation",
        "Lacerate", "MasterOfTheSword", "PiercingDagger", "ResoundingWarcry",
        "SlashingStrike", "Sprint", "Whirlwind"});
    BY_CHARACTER.put("elder", new String[]{
        "Basic", "GraspingVines", "Inspiration", "MendingSpirit",
        "NaturesFury", "Remedy", "Revitalize", "Ritual", "SeedOfLife",
        "Serenity", "Shapeshift", "Soothe", "Symbiosis", "ToxicSpore",
        "Windstorm"});
    BY_CHARACTER.put("lich", new String[]{
        "AbyssalSpike", "AcidRain", "Basic", "BloodOfTheDying", "Contagion",
        "DeathsGrasp", "Depravity", "Exhaustion", "Hysteria", "Inflame",
        "Miasma", "NetherBolt", "Parasite", "Pestilence", "PoisonNova",
        "PoolOfAgony", "PoolOfSouls", "SacrificeSoul", "ShatterMagic",
        "Torment", "UnderworldArmor"});
    BY_CHARACTER.put("mystic", new String[]{
        "Aegis", "AstralShock", "Basic", "Blackout", "BlessingSunAndMoon",
        "Cleanse", "CosmicInfusion", "Disenchant", "Divination",
        "DreamOfProsperity", "HealingVision", "LifeStream", "LightsWrath",
        "ManaTap", "SpiritForm", "TemporalBarrier"});
    BY_CHARACTER.put("nihilist", new String[]{
        "Amalgamation", "Basic", "Blink", "ChaosWave", "DarkInoculation",
        "Infuse", "Karma", "LingeringDemise", "MindLeech", "OrbOfAbsolution",
        "OrbOfReplenishment", "OrbOfSmoke", "OrbOfWisdom", "Rockslide",
        "ShadowAffinity", "SiphonMana", "SpellBreaker"});
    BY_CHARACTER.put("paladin", new String[]{
        "AngelicStrike", "Basic", "BlazingSlash", "CelestialProtection",
        "DivineLight", "GlimmerOfLight", "HeavensGuidance", "HeavensStrike",
        "HolyNova", "InfernalStrike", "Prudence", "Purify", "Sanctuary",
        "ShatteringSlash", "StreamOfLight", "Valor", "WrathOfHeaven"});
    BY_CHARACTER.put("ranger", new String[]{
        "AetherShot", "AntidotePotion", "Basic", "ElementalArrow", "HeadShot",
        "HobblingArrow", "LightningArrow", "MarkOfDeath", "NightmareShot",
        "PoisonousShot", "Precision", "Quicksand", "RainOfArrows",
        "RejuvinationPotion", "SilencingShot", "Vigor"});
    BY_CHARACTER.put("scholar", new String[]{
        "Armageddon", "Basic", "EtherealBindings", "GospelOfDefiance",
        "GospelOfHarmony", "GospelOfOnslaught", "GospelOfPurity",
        "Immortality", "Judgment", "LifeBurst", "Mesmerize", "Portal",
        "RiteOfPassage", "Silence", "TransferLife", "Truth"});
    BY_CHARACTER.put("wizard", new String[]{
        "AganothsDescent", "Basic", "ChillingArmor", "Combust",
        "Counterspell", "Crystallize", "EyeOfTheStorm", "Fireball",
        "FlashFreeze", "Frostbolt", "Geyser", "IceSpikes", "LightningStrike",
        "MagicMissiles", "MasterOfMagic", "Meteor", "RunicShield", "Sheepify",
        "ShockNova", "Teleport", "ThundersWrath", "VolcanicEruption"});
  }

  private Spells() {
  }

  /** Spell folder names for a character (empty array when unknown). */
  public static String[] forCharacter(String character) {
    String[] spells = BY_CHARACTER.get(character);
    return spells == null ? new String[0] : spells.clone();
  }
}
