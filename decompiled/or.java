/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.EffectList;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class or {
    private final Engine var_com_arenaofkings_client_core_Engine_a;
    public TextureAtlas var_com_badlogic_gdx_graphics_g2d_TextureAtlas_a;

    public or(Engine engine) {
        this.var_com_arenaofkings_client_core_Engine_a = engine;
    }

    public void a(TextureAtlas textureAtlas) {
        this.var_com_badlogic_gdx_graphics_g2d_TextureAtlas_a = textureAtlas;
    }

    public void a(EffectList effectList, long l2, String string, String string2) {
        Engine.a("spawnEffect() in");
        oo oo2 = this.a(effectList);
        if (oo2 != null) {
            oo2.a(new azv(l2, true));
            br br2 = ay.ay_a().br_a(string);
            Engine.a("set effect: " + oo2.getClass().getSimpleName() + " to " + string);
            oo2.a(br2);
            oo2.b(ay.ay_a().br_a(string2));
            oo2.d();
            br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_EffectManager_a().push(oo2);
        }
        Engine.a("spawnEffect() out");
    }

    public oo a(EffectList effectList) {
        switch (effectList) {
            case Bleeding: {
                return new ts(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case Blind: {
                return new tt(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case Burning: {
                return new tu(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case Fear: {
                return new tv(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case Hobble: {
                return new tw(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case Incapacitate: {
                return new tx(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case Infection: {
                return new ty(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case Interrupt: {
                return new tz(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case Poison: {
                return new ua(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case Shock: {
                return new ub(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case Silence: {
                return new uc(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case Stun: {
                return new ud(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case Bandage: {
                return new rd(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case Dash: {
                return new re(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case ExposeVulnerabilities: {
                return new pi(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case DustCloud: {
                return new rf(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case MurderousInstincts: {
                return new rg(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case Puncture: {
                return new pj(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case ShadowWalk: {
                return new pk(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case Shroud: {
                return new rh(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case Slash: {
                return new pl(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case Stealth: {
                return new ri(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case WhirlingKnives: {
                return new pm(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case ArmorBreak: {
                return new pn(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case Bloodthirst: {
                return new rj(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case Charge: {
                return new po(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case CripplingSlash: {
                return new pp(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case Intimidation: {
                return new oz(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case Sprint: {
                return new rp(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case Enrage: {
                return new rl(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case EnduringWarcry: {
                return new rk(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case MasterOfTheSword: {
                return new rm(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case ResoundingWarcry: {
                return new rn(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case Safeguard: {
                return new ro(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case Whirlwind: {
                return new rq(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case HeavensGuidance: {
                return new sx(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case Enlightenment: {
                return new su(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case Grace: {
                return new sv(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case GuardianShield: {
                return new sw(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case CrusadersFury: {
                return new st(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case Purify: {
                return new sy(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case Valor: {
                return new sz(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case Aegis: {
                return new sf(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case Amnesia: {
                return new qe(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case AstralShock: {
                return new qf(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case BlessingSunAndMoon: {
                return new sg(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case CosmicInfusion: {
                return new sh(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case Divination: {
                return new si(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case DreamOfProsperity: {
                return new sj(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case LifeStream: {
                return new qg(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case LightsWrath: {
                return new qh(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case SlowTime: {
                return new qi(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case SpiritForm: {
                return new sk(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case TemporalBarrier: {
                return new sl(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case Contagion: {
                return new ow(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case DeathsGrasp: {
                return new pu(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case Depravity: {
                return new pv(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case Exhaustion: {
                return new pw(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case Inflame: {
                return new px(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case Malediction: {
                return new py(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case Miasma: {
                return new pz(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case Parasite: {
                return new qa(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case Pestilence: {
                return new qb(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case PoolOfSouls: {
                return new qc(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case Torment: {
                return new qd(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case SacrificeSoul: {
                return new sd(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case UnderworldArmor: {
                return new se(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case Amalgamation: {
                return new ov(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case DarkInoculation: {
                return new ox(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case Gloom: {
                return new oy(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case Infuse: {
                return new sm(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case Karma: {
                return new qj(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case LingeringDemise: {
                return new qk(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case MindLeech: {
                return new ql(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case OrbOfAbsolution: {
                return new sn(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case OrbOfReplenishment: {
                return new so(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case OrbOfSmoke: {
                return new sp(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case OrbOfWisdom: {
                return new sq(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case ShadowAffinity: {
                return new sr(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case SiphonMana: {
                return new qm(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case SpellBreaker: {
                return new ss(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case Sear: {
                return new qo(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case Prudence: {
                return new qn(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case Sanctuary: {
                return new pc(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case EtherealBindings: {
                return new qt(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case GospelOfDefiance: {
                return new td(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case GospelOfHarmony: {
                return new te(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case GospelOfOnslaught: {
                return new tf(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case GospelOfPurity: {
                return new tg(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case Ethereal: {
                return new qu(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case Immortality: {
                return new th(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case Judgement: {
                return new qv(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case LifeBurst: {
                return new ti(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case Portal: {
                return new qw(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case RiteOfPassage: {
                return new tj(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case TransferLife: {
                return new tk(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case Truth: {
                return new pd(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case Ironhide: {
                return new ru(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case DeafeningRoar: {
                return new pq(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case GraspingVines: {
                return new pr(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case Inspiration: {
                return new rt(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case MendingSpirit: {
                return new rv(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case Remedy: {
                return new rw(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case Revitalize: {
                return new rx(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case Ritual: {
                return new pb(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case Soothe: {
                return new sa(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case SeedOfLife: {
                return new ry(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case Serenity: {
                return new rz(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case SpiritWolf: {
                return new sb(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case Symbiosis: {
                return new sc(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case Bear: {
                return new rs(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case Windstorm: {
                return new ps(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case AetherShot: {
                return new qp(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case ElementalArrow: {
                return new qq(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case Pierce: {
                return new qr(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case MarkOfDeath: {
                return new pa(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case Quicksand: {
                return new qs(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case RejuvinationPotion: {
                return new ta(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case Vigor: {
                return new tb(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case VigorBoost: {
                return new tc(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case Combust: {
                return new qx(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case Chill: {
                return new qz(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case ChillingArmor: {
                return new tl(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case Crystallize: {
                return new tm(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case Geyser: {
                return new ra(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case Hypothermia: {
                return new rb(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case Freeze: {
                return new qy(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case MasterOfMagic: {
                return new tn(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case RunicShield: {
                return new to(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case Sheepify: {
                return new tp(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case Teleport: {
                return new tq(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case Meditate: {
                return new rr(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case VexathrasCurse: {
                return new pg(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case VexathrasContagion: {
                return new pf(this.var_com_arenaofkings_client_core_Engine_a);
            }
            case VexathrasExhaustion: {
                return new ph(this.var_com_arenaofkings_client_core_Engine_a);
            }
        }
        Engine.a("[ERROR] COULD NOT CREATE EFFECT - IT DOESN'T EXIST IN SWITCH STATEMENT");
        return null;
    }
}

