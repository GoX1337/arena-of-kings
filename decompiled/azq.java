/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.utils.Array;

public class azq
extends azk<ha> {
    private final axm a;
    private ayh d;
    private ayh e;

    public azq(Engine engine, axm axm2, String string, String string2, String string3, int n2, int n3) {
        super(axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c), string, string2, string3, n2, n3);
        this.c.com_badlogic_gdx_graphics_g2d_Sprite_a().scale(0.2f);
        this.c.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(n2 + 354, n3 + 322);
        this.c = (int)this.c.com_badlogic_gdx_graphics_g2d_Sprite_a().getY();
        this.a = new Array();
        this.a = axm2;
        Engine.a("st 1");
        this.a(engine);
        this.a();
        Engine.a("st 2");
        Engine.a("created spellTable");
    }

    public void a(Engine engine) {
        this.b = 0;
        this.a = (axm)5;
        this.i = 0.0f;
        this.g = 0.0f;
        this.f = 0.0f;
        ((Array)((Object)this.a)).clear();
        switch (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_misc_CharacterClass_a()) {
            case ASSASSIN: {
                this.d = new ayh(1119, 872, this.a.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.jd), "Assassin", true);
                this.a(engine, SpellName.Annihilate);
                this.a(engine, SpellName.Dash);
                this.a(engine, SpellName.Daze);
                this.a(engine, SpellName.DisappearingAct);
                this.a(engine, SpellName.Envenom);
                this.a(engine, SpellName.MurderousInstincts);
                this.a(engine, SpellName.Puncture);
                this.a(engine, SpellName.Bandage);
                this.a(engine, SpellName.ShadowWalk);
                this.a(engine, SpellName.Shroud);
                this.a(engine, SpellName.Slap);
                this.a(engine, SpellName.Slash);
                this.a(engine, SpellName.Stealth);
                this.a(engine, SpellName.TempleStrike);
                this.a(engine, SpellName.WhirlingKnives);
                break;
            }
            case CHAMPION: {
                this.d = new ayh(1119, 872, this.a.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.jd), "Champion", true);
                this.a(engine, SpellName.ArmorBreak);
                this.a(engine, SpellName.Charge);
                this.a(engine, SpellName.Coward);
                this.a(engine, SpellName.CripplingSlash);
                this.a(engine, SpellName.CrushingBlow);
                this.a(engine, SpellName.Decapitate);
                this.a(engine, SpellName.EnduringWarcry);
                this.a(engine, SpellName.Intimidation);
                this.a(engine, SpellName.Lacerate);
                this.a(engine, SpellName.MasterOfTheSword);
                this.a(engine, SpellName.ResoundingWarcry);
                this.a(engine, SpellName.Safeguard);
                this.a(engine, SpellName.SlashingStrike);
                this.a(engine, SpellName.Sprint);
                this.a(engine, SpellName.Whirlwind);
                break;
            }
            case ELDER: {
                this.d = new ayh(1119, 872, this.a.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.jd), "Elder", true);
                this.a(engine, SpellName.GraspingVines);
                this.a(engine, SpellName.Inspiration);
                this.a(engine, SpellName.MendingSpirit);
                this.a(engine, SpellName.CorrosiveAsp);
                this.a(engine, SpellName.Remedy);
                this.a(engine, SpellName.Revitalize);
                this.a(engine, SpellName.Ritual);
                this.a(engine, SpellName.SeedOfLife);
                this.a(engine, SpellName.Serenity);
                this.a(engine, SpellName.Soothe);
                this.a(engine, SpellName.Bear);
                this.a(engine, SpellName.SpiritWolf);
                this.a(engine, SpellName.Symbiosis);
                this.a(engine, SpellName.ToxicSpore);
                this.a(engine, SpellName.Windstorm);
                break;
            }
            case LICH: {
                this.d = new ayh(1119, 872, this.a.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.jd), "Lich", true);
                this.a(engine, SpellName.AbyssalSpike);
                this.a(engine, SpellName.AcidRain);
                this.a(engine, SpellName.BloodOfTheDying);
                this.a(engine, SpellName.Contagion);
                this.a(engine, SpellName.DeathsGrasp);
                this.a(engine, SpellName.Depravity);
                this.a(engine, SpellName.Exhaustion);
                this.a(engine, SpellName.Inflame);
                this.a(engine, SpellName.Miasma);
                this.a(engine, SpellName.NetherBolt);
                this.a(engine, SpellName.Parasite);
                this.a(engine, SpellName.PoisonNova);
                this.a(engine, SpellName.SacrificeSoul);
                this.a(engine, SpellName.ShatterMagic);
                this.a(engine, SpellName.Pestilence);
                this.a(engine, SpellName.Terrify);
                this.a(engine, SpellName.Torment);
                this.a(engine, SpellName.UnderworldArmor);
                break;
            }
            case MYSTIC: {
                this.d = new ayh(1119, 872, this.a.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.jd), "Mystic", true);
                this.a(engine, SpellName.Aegis);
                this.a(engine, SpellName.AstralShock);
                this.a(engine, SpellName.Blackout);
                this.a(engine, SpellName.BlessingSunAndMoon);
                this.a(engine, SpellName.Cleanse);
                this.a(engine, SpellName.CosmicInfusion);
                this.a(engine, SpellName.Disenchant);
                this.a(engine, SpellName.Divination);
                this.a(engine, SpellName.DreamOfProsperity);
                this.a(engine, SpellName.HealingVision);
                this.a(engine, SpellName.ManaTap);
                this.a(engine, SpellName.SpiritForm);
                this.a(engine, SpellName.LifeStream);
                this.a(engine, SpellName.LightsWrath);
                this.a(engine, SpellName.TemporalBarrier);
                break;
            }
            case NIHILIST: {
                this.d = new ayh(1119, 872, this.a.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.jd), "Nihilist", true);
                this.a(engine, SpellName.Amalgamation);
                this.a(engine, SpellName.Blink);
                this.a(engine, SpellName.ChaosWave);
                this.a(engine, SpellName.DarkInoculation);
                this.a(engine, SpellName.Infuse);
                this.a(engine, SpellName.Karma);
                this.a(engine, SpellName.LingeringDemise);
                this.a(engine, SpellName.MindLeech);
                this.a(engine, SpellName.OrbOfAbsolution);
                this.a(engine, SpellName.OrbOfSmoke);
                this.a(engine, SpellName.OrbOfReplenishment);
                this.a(engine, SpellName.OrbOfWisdom);
                this.a(engine, SpellName.Rockslide);
                this.a(engine, SpellName.ShadowAffinity);
                this.a(engine, SpellName.ShatterMagic);
                this.a(engine, SpellName.SiphonMana);
                this.a(engine, SpellName.SpellBreaker);
                break;
            }
            case PALADIN: {
                this.d = new ayh(1119, 872, this.a.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.jd), "Paladin", true);
                this.a(engine, SpellName.AngelicStrike);
                this.a(engine, SpellName.BlazingSlash);
                this.a(engine, SpellName.SealOfTheHeavens);
                this.a(engine, SpellName.DivineLight);
                this.a(engine, SpellName.SealOfTheCrusader);
                this.a(engine, SpellName.GlimmerOfLight);
                this.a(engine, SpellName.HeavensStrike);
                this.a(engine, SpellName.HolyNova);
                this.a(engine, SpellName.Immortality);
                this.a(engine, SpellName.Sear);
                this.a(engine, SpellName.Prudence);
                this.a(engine, SpellName.Purify);
                this.a(engine, SpellName.RiteOfPassage);
                this.a(engine, SpellName.Sanctuary);
                this.a(engine, SpellName.ShatteringSlash);
                this.a(engine, SpellName.StreamOfLight);
                this.a(engine, SpellName.Valor);
                this.a(engine, SpellName.WrathOfHeaven);
                break;
            }
            case RANGER: {
                this.d = new ayh(1119, 872, this.a.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.jd), "Ranger", true);
                this.a(engine, SpellName.AetherShot);
                this.a(engine, SpellName.ElementalArrow);
                this.a(engine, SpellName.HeadShot);
                this.a(engine, SpellName.TwistingShot);
                this.a(engine, SpellName.LightningArrow);
                this.a(engine, SpellName.MarkOfDeath);
                this.a(engine, SpellName.NightmareShot);
                this.a(engine, SpellName.PoisonousShot);
                this.a(engine, SpellName.RainOfArrows);
                this.a(engine, SpellName.Quicksand);
                this.a(engine, SpellName.RejuvinationPotion);
                this.a(engine, SpellName.SilencingShot);
                this.a(engine, SpellName.Vigor);
                break;
            }
            case SCHOLAR: {
                this.d = new ayh(1119, 872, this.a.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.jd), "Scholar", true);
                this.a(engine, SpellName.Armageddon);
                this.a(engine, SpellName.EtherealBindings);
                this.a(engine, SpellName.GospelOfDefiance);
                this.a(engine, SpellName.GospelOfHarmony);
                this.a(engine, SpellName.GospelOfOnslaught);
                this.a(engine, SpellName.GospelOfPurity);
                this.a(engine, SpellName.Immortality);
                this.a(engine, SpellName.Judgement);
                this.a(engine, SpellName.LifeBurst);
                this.a(engine, SpellName.Mesmerize);
                this.a(engine, SpellName.Portal);
                this.a(engine, SpellName.RiteOfPassage);
                this.a(engine, SpellName.Silence);
                this.a(engine, SpellName.TransferLife);
                this.a(engine, SpellName.Truth);
                break;
            }
            case WIZARD: {
                this.d = new ayh(1119, 872, this.a.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.jd), "Wizard", true);
                this.a(engine, SpellName.AganothsDescent);
                this.a(engine, SpellName.Combust);
                this.a(engine, SpellName.Counterspell);
                this.a(engine, SpellName.ChillingArmor);
                this.a(engine, SpellName.Crystallize);
                this.a(engine, SpellName.EyeOfTheStorm);
                this.a(engine, SpellName.Frostbolt);
                this.a(engine, SpellName.Fireball);
                this.a(engine, SpellName.FlashFreeze);
                this.a(engine, SpellName.Geyser);
                this.a(engine, SpellName.IceSpikes);
                this.a(engine, SpellName.LightningStrike);
                this.a(engine, SpellName.MagicMissiles);
                this.a(engine, SpellName.MasterOfMagic);
                this.a(engine, SpellName.Meteor);
                this.a(engine, SpellName.RunicShield);
                this.a(engine, SpellName.Sheepify);
                this.a(engine, SpellName.ShockNova);
                this.a(engine, SpellName.Teleport);
                this.a(engine, SpellName.VolcanicEruption);
                break;
            }
        }
        ((Array)((Object)this.a)).sort();
        for (int i2 = 0; i2 < ((Array)((Object)this.a)).size; ++i2) {
            ((ha)((Array)((Object)this.a)).get(i2)).a().c(i2);
            ((ha)((Array)((Object)this.a)).get(i2)).a(this.a);
        }
        this.e = new ayh(1473, 884, this.a.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.jc), "skill_342", true);
        this.e.com_badlogic_gdx_graphics_g2d_Sprite_a().scale(-0.5f);
    }

    private void a(Engine engine, SpellName spellName) {
        ((Array)((Object)this.a)).add(new ha(engine, this.a.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c), spellName));
    }

    @Override
    public void b(float f2, Engine engine) {
        this.a(f2, engine);
        ((ayh)((Object)this.a)).b(f2, engine);
        this.d.b(f2, engine);
        if (((Array)((Object)this.a)).size <= 5) {
            this.a = (axm)((Array)((Object)this.a)).size;
        }
        if (this.a >= 5) {
            int n2 = 0;
            for (int i2 = this.b; i2 <= this.a; ++i2) {
                ((ha)((Array)((Object)this.a)).get(i2)).a().a(f2, engine);
                ((ha)((Array)((Object)this.a)).get(i2)).a(n2);
                ((ha)((Array)((Object)this.a)).get(i2)).b(f2, engine);
                ++n2;
            }
        } else {
            int n3 = 0;
            for (int i3 = this.b; i3 < ((Array)((Object)this.a)).size; ++i3) {
                ((ha)((Array)((Object)this.a)).get(i3)).a().a(f2, engine);
                ((ha)((Array)((Object)this.a)).get(i3)).a(n3);
                ((ha)((Array)((Object)this.a)).get(i3)).b(f2, engine);
                ++n3;
            }
        }
        super.b(f2, engine);
        this.b.b(f2, engine);
        this.c.b(f2, engine);
    }

    @Override
    public void c() {
        for (int i2 = 0; i2 < ((Array)((Object)this.a)).size; ++i2) {
            if (((ha)((Array)((Object)this.a)).get(i2)).a() == null || ((ha)((Array)((Object)this.a)).get(i2)).a().ayh_a() == null) continue;
            ((ha)((Array)((Object)this.a)).get(i2)).a().ayh_a().b(false);
        }
        super.c();
    }

    @Override
    public void d() {
        for (int i2 = 0; i2 < ((Array)((Object)this.a)).size; ++i2) {
            if (((ha)((Array)((Object)this.a)).get(i2)).a() == null || ((ha)((Array)((Object)this.a)).get(i2)).a().ayh_a() == null) continue;
            ((ha)((Array)((Object)this.a)).get(i2)).a().ayh_a().b(false);
        }
        super.d();
    }
}

