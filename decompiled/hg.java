/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.Location;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.utils.Array;
import java.util.HashMap;

public class hg {
    private final Engine var_com_arenaofkings_client_core_Engine_a;
    private HashMap<SpellName, ui> cfr_renamed_57;
    private Array<ajw> var_com_badlogic_gdx_utils_Array_ajw__a;

    public hg(Engine engine) {
        this.var_com_arenaofkings_client_core_Engine_a = engine;
        this.a();
    }

    public void a() {
        Engine.a("Initializing spell store");
        this.var_com_arenaofkings_client_core_Engine_a = new HashMap();
        this.var_com_arenaofkings_client_core_Engine_a = new Array();
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.Empty, new hq());
        this.u();
        this.w();
        this.k();
        this.o();
        this.s();
        this.e();
        this.g();
        this.i();
        this.m();
        this.q();
        this.d();
    }

    public void b() {
        Engine.b("recatalog in");
        this.v();
        this.x();
        this.l();
        this.p();
        this.t();
        this.f();
        this.h();
        this.j();
        this.n();
        this.r();
        Engine.b("recatalog out");
    }

    private void d() {
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.VexathrasCurse, new hk());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.VexathrasContagion, new hj());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.VexathrasShatter, new ho());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.VexathrasGrasp, new hl());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.VexathrasFear, new hm());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.VexathrasFireball, new hn());
    }

    private void e() {
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.Nihilist_Basic, new le());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.Amalgamation, new ld());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.Blink, new lf());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.ChaosWave, new lg());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.DarkInoculation, new lh());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.Infuse, new li());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.Karma, new lj());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.LingeringDemise, new lk());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.MindLeech, new ll());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.OrbOfAbsolution, new lm());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.OrbOfReplenishment, new ln());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.OrbOfSmoke, new lo());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.OrbOfWisdom, new lp());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.Rockslide, new lq());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.ShadowAffinity, new lr());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.ShatterMagic, new kj());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.SiphonMana, new ls());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.SpellBreaker, new lt());
    }

    private void f() {
        this.a(new le());
        this.a(new ld());
        this.a(new lf());
        this.a(new lg());
        this.a(new lh());
        this.a(new li());
        this.a(new lj());
        this.a(new lk());
        this.a(new ll());
        this.a(new lm());
        this.a(new ln());
        this.a(new lo());
        this.a(new lp());
        this.a(new lq());
        this.a(new lr());
        this.a(new kj());
        this.a(new ls());
        this.a(new lt());
    }

    private void g() {
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.Paladin_Basic, new lv());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.AngelicStrike, new lu());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.BlazingSlash, new lw());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.SealOfTheHeavens, new ma());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.DivineLight, new ly());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.SealOfTheCrusader, new lx());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.GlimmerOfLight, new lz());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.HeavensStrike, new mb());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.HolyNova, new mc());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.Immortality, new md());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.Sear, new mi());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.Prudence, new me());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.Purify, new mf());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.RiteOfPassage, new mg());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.Sanctuary, new mh());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.ShatteringSlash, new mj());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.StreamOfLight, new mk());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.Valor, new ml());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.WrathOfHeaven, new mm());
    }

    private void h() {
        this.a(new lv());
        this.a(new lu());
        this.a(new lw());
        this.a(new ma());
        this.a(new ly());
        this.a(new lx());
        this.a(new lz());
        this.a(new mb());
        this.a(new mc());
        this.a(new md());
        this.a(new mi());
        this.a(new me());
        this.a(new mf());
        this.a(new mg());
        this.a(new mh());
        this.a(new mj());
        this.a(new mk());
        this.a(new ml());
        this.a(new mm());
    }

    private void i() {
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.Ranger_Basic, new mo());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.AetherShot, new mn());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.ElementalArrow, new mp());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.HeadShot, new mq());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.TwistingShot, new mr());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.LightningArrow, new ms());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.MarkOfDeath, new mt());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.NightmareShot, new mu());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.PoisonousShot, new mv());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.RainOfArrows, new my());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.Precision, new mw());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.Quicksand, new mx());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.RejuvinationPotion, new mz());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.SilencingShot, new na());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.Vigor, new nb());
    }

    private void j() {
        this.a(new mo());
        this.a(new mn());
        this.a(new mp());
        this.a(new mq());
        this.a(new mr());
        this.a(new ms());
        this.a(new mt());
        this.a(new mu());
        this.a(new mv());
        this.a(new my());
        this.a(new mw());
        this.a(new mx());
        this.a(new mz());
        this.a(new na());
        this.a(new nb());
    }

    private void k() {
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.Elder_Basic, new ja());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.GraspingVines, new jg());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.Inspiration, new jh());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.MendingSpirit, new ji());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.CorrosiveAsp, new jf());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.Remedy, new jj());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.Revitalize, new jk());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.Ritual, new jl());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.SeedOfLife, new jm());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.Serenity, new jn());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.Soothe, new jo());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.SpiritWolf, new jp());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.Symbiosis, new jq());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.ToxicSpore, new jr());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.Bear, new jb());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.Bear_Charge, new jc());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.Bear_Smash, new je());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.Bear_Ironhide, new jd());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.Windstorm, new js());
    }

    private void l() {
        this.a(new ja());
        this.a(new jg());
        this.a(new jh());
        this.a(new ji());
        this.a(new jf());
        this.a(new jj());
        this.a(new jk());
        this.a(new jl());
        this.a(new jm());
        this.a(new jn());
        this.a(new jo());
        this.a(new jp());
        this.a(new jq());
        this.a(new jr());
        this.a(new jb());
        this.a(new jc());
        this.a(new je());
        this.a(new jd());
        this.a(new js());
    }

    private void m() {
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.Scholar_Basic, new nd());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.Armageddon, new nc());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.EtherealBindings, new ne());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.GospelOfDefiance, new nf());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.GospelOfHarmony, new ng());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.GospelOfOnslaught, new nh());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.GospelOfPurity, new ni());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.Immortality, new nj());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.Judgement, new nk());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.LifeBurst, new nl());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.Mesmerize, new nm());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.Portal, new nn());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.RiteOfPassage, new no());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.Silence, new np());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.TransferLife, new nq());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.Truth, new nr());
    }

    private void n() {
        this.a(new nd());
        this.a(new nc());
        this.a(new ne());
        this.a(new nf());
        this.a(new ng());
        this.a(new nh());
        this.a(new ni());
        this.a(new nj());
        this.a(new nk());
        this.a(new nl());
        this.a(new nm());
        this.a(new nn());
        this.a(new no());
        this.a(new np());
        this.a(new nq());
        this.a(new nr());
    }

    private void o() {
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.Lich_Basic, new jv());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.AbyssalSpike, new jt());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.AcidRain, new ju());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.BloodOfTheDying, new jw());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.Contagion, new jx());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.DeathsGrasp, new jy());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.Depravity, new jz());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.Exhaustion, new ka());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.Inflame, new kb());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.Miasma, new kc());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.NetherBolt, new kd());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.Parasite, new ke());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.PoisonNova, new kg());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.PoolOfSouls, new kh());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.SacrificeSoul, new ki());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.ShatterMagic, new kj());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.Pestilence, new kf());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.Terrify, new kk());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.Torment, new kl());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.UnderworldArmor, new km());
    }

    private void p() {
        this.a(new jv());
        this.a(new jt());
        this.a(new ju());
        this.a(new jw());
        this.a(new jx());
        this.a(new jy());
        this.a(new jz());
        this.a(new ka());
        this.a(new kb());
        this.a(new kc());
        this.a(new kd());
        this.a(new ke());
        this.a(new kg());
        this.a(new kh());
        this.a(new ki());
        this.a(new kj());
        this.a(new kf());
        this.a(new kk());
        this.a(new kl());
        this.a(new km());
    }

    private void q() {
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.Wizard_Basic, new nt());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.AganothsDescent, new ns());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.Combust, new nv());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.Counterspell, new nw());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.ChillingArmor, new nu());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.Crystallize, new nx());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.EyeOfTheStorm, new ny());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.Frostbolt, new ob());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.Fireball, new nz());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.FlashFreeze, new oa());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.Geyser, new oc());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.IceSpikes, new od());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.LightningStrike, new oe());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.MagicMissiles, new of());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.MasterOfMagic, new og());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.Meteor, new oh());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.RunicShield, new oi());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.Sheepify, new oj());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.ShockNova, new ok());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.Teleport, new ol());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.ThundersWrath, new om());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.VolcanicEruption, new on());
    }

    private void r() {
        this.a(new nt());
        this.a(new ns());
        this.a(new nv());
        this.a(new nw());
        this.a(new nu());
        this.a(new nx());
        this.a(new ny());
        this.a(new ob());
        this.a(new nz());
        this.a(new oa());
        this.a(new oc());
        this.a(new od());
        this.a(new oe());
        this.a(new of());
        this.a(new og());
        this.a(new oh());
        this.a(new oi());
        this.a(new oj());
        this.a(new ok());
        this.a(new ol());
        this.a(new om());
        this.a(new on());
    }

    private void s() {
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.Mystic_Basic, new kp());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.Aegis, new kn());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.AstralShock, new ko());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.Blackout, new kq());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.BlessingSunAndMoon, new kr());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.Cleanse, new ks());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.CosmicInfusion, new kt());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.Disenchant, new ku());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.Divination, new kv());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.DreamOfProsperity, new kw());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.HealingVision, new kx());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.LifeStream, new ky());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.LightsWrath, new kz());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.ManaTap, new la());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.SpiritForm, new lb());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.TemporalBarrier, new lc());
    }

    private void t() {
        this.a(new kp());
        this.a(new kn());
        this.a(new ko());
        this.a(new kq());
        this.a(new kr());
        this.a(new ks());
        this.a(new kt());
        this.a(new ku());
        this.a(new kv());
        this.a(new kw());
        this.a(new kx());
        this.a(new ky());
        this.a(new kz());
        this.a(new la());
        this.a(new lb());
        this.a(new lc());
    }

    private void u() {
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.Assassin_Basic, new ht());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.Annihilate, new hr());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.Bandage, new hs());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.Dash, new hu());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.Daze, new hv());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.Envenom, new hx());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.WhirlingKnives, new ih());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.DisappearingAct, new hw());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.ShadowWalk, new ib());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.MurderousInstincts, new hy());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.PoisonedBlades, new hz());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.Puncture, new ia());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.Shroud, new ic());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.Slap, new id());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.Slash, new ie());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.Stealth, new _if());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.TempleStrike, new ig());
    }

    private void v() {
        this.a(new ht());
        this.a(new hr());
        this.a(new hs());
        this.a(new hu());
        this.a(new hv());
        this.a(new hx());
        this.a(new ih());
        this.a(new hw());
        this.a(new ib());
        this.a(new hy());
        this.a(new hz());
        this.a(new ia());
        this.a(new ic());
        this.a(new id());
        this.a(new ie());
        this.a(new _if());
        this.a(new ig());
    }

    private void a(ui ui2) {
        if (((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).get((Object)ui2.hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a()) != null) {
            ((ui)((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).get((Object)ui2.hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a())).hf_a().a(ui2.java_lang_String_a());
            if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity() != null) {
                for (ej ej2 : ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getCharacterEntities()) {
                    if (ej2.gu_a().ui_a(ui2.hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a()) == null) continue;
                    ej2.gu_a().ui_a(ui2.hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a()).hf_a().a(ui2.java_lang_String_a());
                }
            }
        }
    }

    private void w() {
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.ArmorBreak, new ii());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.Charge, new ik());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.Champion_Basic, new ij());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.Coward, new il());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.CripplingSlash, new im());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.CrushingBlow, new in());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.Decapitate, new io());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.EnduringWarcry, new ip());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.Enrage, new iq());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.Intimidation, new ir());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.Lacerate, new is());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.MasterOfTheSword, new it());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.PiercingDagger, new iu());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.ResoundingWarcry, new iv());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.Safeguard, new iw());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.SlashingStrike, new ix());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.Sprint, new iy());
        ((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(SpellName.Whirlwind, new iz());
    }

    private void x() {
        this.a(new ii());
        this.a(new ik());
        this.a(new ij());
        this.a(new il());
        this.a(new im());
        this.a(new in());
        this.a(new io());
        this.a(new ip());
        this.a(new iq());
        this.a(new ir());
        this.a(new is());
        this.a(new it());
        this.a(new iu());
        this.a(new iv());
        this.a(new iw());
        this.a(new ix());
        this.a(new iy());
        this.a(new iz());
    }

    public void c() {
        ((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).clear();
    }

    public void void_a(SpellName spellName) {
        Object object;
        Object object2;
        Engine.a("Getting dependency for SpellName: " + (Object)((Object)spellName));
        if (((ui)((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).get((Object)spellName)).da_a() != null) {
            object2 = ((ui)((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).get((Object)spellName)).da_a().ajw_a();
            Engine.a("Dependency = " + object2);
            if (object2 != null && !((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).contains(object2, true)) {
                Engine.a("[INFO] Adding dependency to SpellStore " + ((ajw)((Object)object2)).toString());
                ((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).add(object2);
            } else if (object2 == null) {
                Engine.a("[ERROR] Dependency is null in SpellStore - did not add for SpellName: " + (Object)((Object)spellName) + " (hint) put this spell in the SpellStore catalog");
            } else {
                Engine.a("[WARN] Dependency already exists in SpellStore - did not add " + ((ajw)((Object)object2)).toString());
            }
        }
        if (((ui)((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).get((Object)spellName)).da_b() != null) {
            object2 = ((ui)((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).get((Object)spellName)).da_b().ajw_a();
            Engine.a("Dependency = " + object2);
            if (object2 != null && !((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).contains(object2, true)) {
                Engine.a("[INFO] Adding dependency to SpellStore " + ((ajw)((Object)object2)).toString());
                ((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).add(object2);
            } else if (object2 == null) {
                Engine.a("[ERROR] Dependency is null in SpellStore - did not add for SpellName: " + (Object)((Object)spellName) + " (hint) put this spell in the SpellStore catalog");
            } else {
                Engine.a("[WARN] Dependency already exists in SpellStore - did not add " + ((ajw)((Object)object2)).toString());
            }
        }
        if ((object2 = ((ui)((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).get((Object)spellName)).azo_a()) != null) {
            object = ((azo)object2).ajw_a();
            Engine.a("Sound effect dependency = " + object);
            if (object != null && !((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).contains(object, true)) {
                Engine.a("[INFO] Adding Sound effect dependency to SpellStore " + ((ajw)((Object)object)).toString());
                ((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).add(object);
            } else if (object == null) {
                Engine.a("[ERROR] Sound effect dependency is null in SpellStore - did not add for SpellName: " + (Object)((Object)spellName) + " (hint) put this spell in the SpellStore catalog");
            } else {
                Engine.a("[WARN] Sound effect dependency already exists in SpellStore - did not add " + ((ajw)((Object)object)).toString());
            }
        }
        if ((object = ((ui)((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).get((Object)spellName)).azo_b()) != null) {
            ajw ajw2 = ((azo)object).ajw_a();
            Engine.a("Sound effect dependency = " + (Object)((Object)ajw2));
            if (ajw2 != null && !((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).contains(ajw2, true)) {
                Engine.a("[INFO] Adding impactSound effect dependency to SpellStore " + ajw2.toString());
                ((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).add(ajw2);
            } else if (ajw2 == null) {
                Engine.a("[ERROR] impactSound effect dependency is null in SpellStore - did not add for SpellName: " + (Object)((Object)spellName) + " (hint) put this spell in the SpellStore catalog");
            } else {
                Engine.a("[WARN] impactSound effect dependency already exists in SpellStore - did not add " + ajw2.toString());
            }
        }
    }

    public Array<ajw> a() {
        return this.var_com_arenaofkings_client_core_Engine_a;
    }

    public void a(ui[] uiArray, String string, int n2) {
        ui ui2;
        Engine.a("Attempting to clone spell " + string);
        ui ui3 = (ui)((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).get((Object)SpellName.valueOf(string));
        if (ui3 == null) {
            Engine.a("[ERROR] spell needs to be cataloged in spellmap - MISSING catalog.put(" + string + ", new " + string + "();");
        }
        if ((ui2 = ui.a(ui3)) != null) {
            Engine.a("spell " + string + " cloned successfully");
        } else {
            Engine.a("spell " + string + " DID NOT clone successfully .. ERROR");
        }
        ui2.hd_a().b(n2);
        for (Location location : ui2.a()) {
            switch (ui2.hf_a().com_arenaofkings_packets_gameserver_data_LocationType_a()) {
                case POSITIONAL: {
                    location.setPosition(this.var_com_arenaofkings_client_core_Engine_a.var_com_badlogic_gdx_math_Vector3_b.x, this.var_com_arenaofkings_client_core_Engine_a.var_com_badlogic_gdx_math_Vector3_b.y);
                    break;
                }
                case TARGETED: {
                    break;
                }
                case NONE: {
                    break;
                }
            }
        }
        Engine.a("Cloned a Spell of name: " + (Object)((Object)ui2.hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a()));
        uiArray[n2 - 1] = ui2;
    }

    public void b(ui[] uiArray, String string, int n2) {
        Engine.a("new changeSpell() " + string + " " + n2);
        for (int i2 = 0; i2 < uiArray.length; ++i2) {
            if (uiArray[i2].hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a() != ((ui)((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).get((Object)SpellName.valueOf(string))).hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a()) continue;
            Engine.a("setting spell slot " + i2 + " to empty");
            uiArray[i2] = ui.a((ui)((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).get((Object)SpellName.Empty));
            Engine.a("just cloned Empty spell");
        }
        Engine.a("Cloning spell " + string);
        this.a(uiArray, string, n2);
        Engine.a("Cloned");
    }

    public void a(ui[] uiArray) {
        this.b();
        Engine.b("updateSpellDescription in");
        for (int i2 = 0; i2 < uiArray.length; ++i2) {
            ui ui2 = (ui)((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).get((Object)uiArray[i2].hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a());
            if (ui2 == null) continue;
            uiArray[i2].hf_a().a(ui2.java_lang_String_a());
            Engine.b("updateSpellDescription " + (Object)((Object)ui2.hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a()));
        }
    }

    public ul ul_a(SpellName spellName, String string) {
        switch (spellName) {
            case Charge: {
                return new ik();
            }
            case Safeguard: {
                return new iw();
            }
            case PiercingDagger: {
                return new iu();
            }
            case Elder_Basic: {
                return new ja();
            }
            case Bear_Charge: {
                return new jc();
            }
            case CorrosiveAsp: {
                return new jf();
            }
            case Lich_Basic: {
                return new jv();
            }
            case NetherBolt: {
                return new kd();
            }
            case Mystic_Basic: {
                return new kp();
            }
            case Nihilist_Basic: {
                return new le();
            }
            case ChaosWave: {
                return new lg();
            }
            case StreamOfLight: {
                return new mk();
            }
            case Ranger_Basic: {
                return new mo();
            }
            case AetherShot: {
                return new mn();
            }
            case ElementalArrow: {
                return new mp();
            }
            case HeadShot: {
                return new mq();
            }
            case TwistingShot: {
                return new mr();
            }
            case LightningArrow: {
                return new ms();
            }
            case NightmareShot: {
                return new mu();
            }
            case PoisonousShot: {
                return new mv();
            }
            case SilencingShot: {
                return new na();
            }
            case Scholar_Basic: {
                return new nd();
            }
            case Wizard_Basic: {
                return new nt();
            }
            case AganothsDescent: {
                return new ns();
            }
            case Fireball: {
                return new nz();
            }
            case Frostbolt: {
                return new ob();
            }
            case MagicMissiles: {
                return new of();
            }
            case VexathrasFireball: {
                return new hn();
            }
        }
        Engine.a("[ERROR] COULDN'T CREATE SPELL " + (Object)((Object)spellName) + " does not exist in SpellStore.createTargetedProjectileSpell() switch statement");
        return null;
    }

    public ue ue_a(SpellName spellName, String string) {
        switch (spellName) {
            case Assassin_Basic: {
                return new ht();
            }
            case Annihilate: {
                return new hr();
            }
            case Bandage: {
                return new hs();
            }
            case Dash: {
                return new hu();
            }
            case Daze: {
                return new hv();
            }
            case Envenom: {
                return new hx();
            }
            case MurderousInstincts: {
                return new hy();
            }
            case PoisonedBlades: {
                return new hz();
            }
            case Puncture: {
                return new ia();
            }
            case Shroud: {
                return new ic();
            }
            case Slap: {
                return new id();
            }
            case Slash: {
                return new ie();
            }
            case TempleStrike: {
                return new ig();
            }
            case ArmorBreak: {
                return new ii();
            }
            case Champion_Basic: {
                return new ij();
            }
            case Coward: {
                return new il();
            }
            case CripplingSlash: {
                return new im();
            }
            case CrushingBlow: {
                return new in();
            }
            case Decapitate: {
                return new io();
            }
            case Enrage: {
                return new iq();
            }
            case Lacerate: {
                return new is();
            }
            case MasterOfTheSword: {
                return new it();
            }
            case SlashingStrike: {
                return new ix();
            }
            case Sprint: {
                return new iy();
            }
            case Whirlwind: {
                return new iz();
            }
            case Bear_Smash: {
                return new je();
            }
            case Bear_Ironhide: {
                return new jd();
            }
            case GraspingVines: {
                return new jg();
            }
            case Inspiration: {
                return new jh();
            }
            case MendingSpirit: {
                return new ji();
            }
            case Remedy: {
                return new jj();
            }
            case Revitalize: {
                return new jk();
            }
            case SeedOfLife: {
                return new jm();
            }
            case Soothe: {
                return new jo();
            }
            case Symbiosis: {
                return new jq();
            }
            case Windstorm: {
                return new js();
            }
            case AbyssalSpike: {
                return new jt();
            }
            case BloodOfTheDying: {
                return new jw();
            }
            case Depravity: {
                return new jz();
            }
            case Exhaustion: {
                return new ka();
            }
            case Inflame: {
                return new kb();
            }
            case Miasma: {
                return new kc();
            }
            case Parasite: {
                return new ke();
            }
            case SacrificeSoul: {
                return new ki();
            }
            case ShatterMagic: {
                return new kj();
            }
            case Pestilence: {
                return new kf();
            }
            case Terrify: {
                return new kk();
            }
            case Torment: {
                return new kl();
            }
            case UnderworldArmor: {
                return new km();
            }
            case Aegis: {
                return new kn();
            }
            case AstralShock: {
                return new ko();
            }
            case BlessingSunAndMoon: {
                return new kr();
            }
            case Cleanse: {
                return new ks();
            }
            case CosmicInfusion: {
                return new kt();
            }
            case Divination: {
                return new kv();
            }
            case DreamOfProsperity: {
                return new kw();
            }
            case HealingVision: {
                return new kx();
            }
            case ManaTap: {
                return new la();
            }
            case LifeStream: {
                return new ky();
            }
            case LightsWrath: {
                return new kz();
            }
            case TemporalBarrier: {
                return new lc();
            }
            case DarkInoculation: {
                return new lh();
            }
            case Infuse: {
                return new li();
            }
            case Karma: {
                return new lj();
            }
            case LingeringDemise: {
                return new lk();
            }
            case MindLeech: {
                return new ll();
            }
            case ShadowAffinity: {
                return new lr();
            }
            case SiphonMana: {
                return new ls();
            }
            case SpellBreaker: {
                return new lt();
            }
            case Paladin_Basic: {
                return new lv();
            }
            case AngelicStrike: {
                return new lu();
            }
            case BlazingSlash: {
                return new lw();
            }
            case SealOfTheHeavens: {
                return new ma();
            }
            case DivineLight: {
                return new ly();
            }
            case SealOfTheCrusader: {
                return new lx();
            }
            case GlimmerOfLight: {
                return new lz();
            }
            case HeavensStrike: {
                return new mb();
            }
            case HolyNova: {
                return new mc();
            }
            case Sear: {
                return new mi();
            }
            case Prudence: {
                return new me();
            }
            case Purify: {
                return new mf();
            }
            case ShatteringSlash: {
                return new mj();
            }
            case Valor: {
                return new ml();
            }
            case WrathOfHeaven: {
                return new mm();
            }
            case MarkOfDeath: {
                return new mt();
            }
            case RejuvinationPotion: {
                return new mz();
            }
            case Vigor: {
                return new nb();
            }
            case EtherealBindings: {
                return new ne();
            }
            case GospelOfDefiance: {
                return new nf();
            }
            case GospelOfHarmony: {
                return new ng();
            }
            case GospelOfOnslaught: {
                return new nh();
            }
            case GospelOfPurity: {
                return new ni();
            }
            case Immortality: {
                return new nj();
            }
            case LifeBurst: {
                return new nl();
            }
            case Mesmerize: {
                return new nm();
            }
            case Portal: {
                return new nn();
            }
            case RiteOfPassage: {
                return new no();
            }
            case Silence: {
                return new np();
            }
            case TransferLife: {
                return new nq();
            }
            case Combust: {
                return new nv();
            }
            case Counterspell: {
                return new nw();
            }
            case ChillingArmor: {
                return new nu();
            }
            case Crystallize: {
                return new nx();
            }
            case IceSpikes: {
                return new od();
            }
            case LightningStrike: {
                return new oe();
            }
            case MasterOfMagic: {
                return new og();
            }
            case RunicShield: {
                return new oi();
            }
            case ThundersWrath: {
                return new om();
            }
            case Meditate: {
                return new hp();
            }
            case VexathrasCurse: {
                return new hk();
            }
            case VexathrasFear: {
                return new hm();
            }
            case VexathrasShatter: {
                return new ho();
            }
        }
        Engine.a("[ERROR] COULDN'T CREATE SPELL " + (Object)((Object)spellName) + " does not exist in SpellStore.createDynamicPlayerSpell() switch statement");
        return null;
    }

    public ug ug_a(SpellName spellName, String string) {
        switch (spellName) {
            case DisappearingAct: {
                return new hw();
            }
            case ShadowWalk: {
                return new ib();
            }
            case Stealth: {
                return new _if();
            }
            case WhirlingKnives: {
                return new ih();
            }
            case EnduringWarcry: {
                return new ip();
            }
            case ResoundingWarcry: {
                return new iv();
            }
            case SpiritWolf: {
                return new jp();
            }
            case Bear: {
                return new jb();
            }
            case PoisonNova: {
                return new kg();
            }
            case FlashFreeze: {
                return new oa();
            }
            case Sheepify: {
                return new oj();
            }
            case ShockNova: {
                return new ok();
            }
            case Blackout: {
                return new kq();
            }
            case SpiritForm: {
                return new lb();
            }
            case Judgement: {
                return new nk();
            }
        }
        Engine.a("[ERROR] COULDN'T CREATE SPELL " + (Object)((Object)spellName) + " does not exist in SpellStore.createFixedPlayerSpell() switch statement");
        return null;
    }

    public uf a(SpellName spellName, float f2, float f3) {
        switch (spellName) {
            case Serenity: {
                return new jn();
            }
            case ToxicSpore: {
                return new jr();
            }
            case AcidRain: {
                return new ju();
            }
            case DeathsGrasp: {
                return new jy();
            }
            case PoolOfSouls: {
                return new kh();
            }
            case Disenchant: {
                return new ku();
            }
            case Blink: {
                return new lf();
            }
            case OrbOfAbsolution: {
                return new lm();
            }
            case OrbOfReplenishment: {
                return new ln();
            }
            case OrbOfSmoke: {
                return new lo();
            }
            case OrbOfWisdom: {
                return new lp();
            }
            case Rockslide: {
                return new lq();
            }
            case RainOfArrows: {
                return new my();
            }
            case Quicksand: {
                return new mx();
            }
            case Armageddon: {
                return new nc();
            }
            case EyeOfTheStorm: {
                return new ny();
            }
            case Geyser: {
                return new oc();
            }
            case Meteor: {
                return new oh();
            }
            case Teleport: {
                return new ol();
            }
            case VolcanicEruption: {
                return new on();
            }
        }
        Engine.a("[ERROR] COULDN'T CREATE SPELL " + (Object)((Object)spellName) + " does not exist in SpellStore.createFixedCoordinateSpell() switch statement");
        return null;
    }

    public ui ui_a(SpellName spellName) {
        return (ui)((HashMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).get((Object)spellName);
    }
}

