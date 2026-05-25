/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.arenaofkings.packets.misc.CharacterClass;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Array;
import java.util.Iterator;

public class vl
extends aya {
    private final wd var_wd_a;
    wa var_wa_a;
    private BitmapFont var_com_badlogic_gdx_graphics_g2d_BitmapFont_a = new BitmapFont();
    private SpriteBatch var_com_badlogic_gdx_graphics_g2d_SpriteBatch_a = new SpriteBatch();
    private ct var_ct_a;
    private da var_da_a;
    private axh var_axh_a;
    private CharacterClass var_com_arenaofkings_packets_misc_CharacterClass_a;
    private Array<hd> var_com_badlogic_gdx_utils_Array_hd__a;
    private ayh var_ayh_a;
    private ayh var_ayh_b;
    private ayh var_ayh_c;
    private ayh var_ayh_d;
    private ayh var_ayh_e;
    private ayh var_ayh_f;
    private ayh var_ayh_g;
    private ayh var_ayh_h;
    private ayh var_ayh_i;
    private ayh var_ayh_j;
    private ayh var_ayh_k;
    private ayh var_ayh_l;
    private ayh var_ayh_m;
    private hd var_hd_a;
    private hd var_hd_b;
    private hd var_hd_c;
    private hd var_hd_d;
    private hd var_hd_e;
    private hd var_hd_f;
    private ayh var_ayh_n;
    private ayh var_ayh_o;
    private ayh var_ayh_p;
    private hd var_hd_g;
    private hd var_hd_h;
    private hd var_hd_i;
    private hd var_hd_j;
    private hd var_hd_k;
    private hd var_hd_l;
    private ayh var_ayh_q;
    private ayh var_ayh_r;
    private ayh var_ayh_s;
    private hd var_hd_m;
    private hd var_hd_n;
    private hd var_hd_o;
    private hd var_hd_p;
    private hd var_hd_q;
    private hd var_hd_r;
    private ayh var_ayh_t;
    private ayh var_ayh_u;
    private ayh var_ayh_v;
    private hd var_hd_s;
    private hd var_hd_t;
    private hd var_hd_u;
    private hd var_hd_v;
    private hd var_hd_w;
    private hd var_hd_x;
    private ayh var_ayh_w;
    private ayh var_ayh_x;
    private ayh var_ayh_y;
    private hd var_hd_y;
    private hd var_hd_z;
    private hd var_hd_A;
    private hd var_hd_B;
    private hd var_hd_C;
    private hd var_hd_D;
    private ayh var_ayh_z;
    private ayh var_ayh_A;
    private ayh var_ayh_B;
    private hd var_hd_E;
    private hd var_hd_F;
    private hd var_hd_G;
    private hd var_hd_H;
    private hd var_hd_I;
    private hd var_hd_J;
    private ayh var_ayh_C;
    private ayh var_ayh_D;
    private ayh var_ayh_E;
    private hd var_hd_K;
    private hd var_hd_L;
    private hd var_hd_M;
    private hd var_hd_N;
    private hd var_hd_O;
    private hd var_hd_P;
    private ayh var_ayh_F;
    private ayh var_ayh_G;
    private ayh var_ayh_H;
    private hd var_hd_Q;
    private hd var_hd_R;
    private hd S;
    private hd T;
    private hd U;
    private hd V;
    private ayh var_ayh_I;
    private ayh var_ayh_J;
    private ayh var_ayh_K;
    private hd W;
    private hd X;
    private hd Y;
    private hd Z;
    private hd aa;
    private hd ab;
    private ayh var_ayh_L;
    private ayh var_ayh_M;
    private ayh var_ayh_N;
    private hd ac;
    private hd ad;
    private hd ae;
    private hd af;
    private hd ag;
    private hd ah;
    private ayh var_ayh_O;
    private String var_java_lang_String_a;
    private String var_java_lang_String_b;
    private ayh var_ayh_P;
    public ayc var_ayc_a;
    public ayf var_ayf_a;
    private ayh var_ayh_Q;
    private ayj var_ayj_a;
    private ayh var_ayh_R;
    private ayj var_ayj_b;
    private ayj var_ayj_c;
    private ayj var_ayj_d;
    private Dialog var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a;

    public vl(axm axm2, wa wa2, wd wd2, Engine engine) {
        super(axm2, engine);
        this.var_wa_a = wa2;
        this.var_wd_a = wd2;
    }

    @Override
    public void void_a() {
        System.out.println("init");
        this.o();
        this.q();
        this.r();
        this.d();
        this.a(CharacterClass.ASSASSIN);
    }

    private void d() {
        this.var_wd_a = new Array(6);
        this.n();
        this.m();
        this.l();
        this.k();
        this.j();
        this.i();
        this.h();
        this.g();
        this.f();
        this.e();
        this.var_java_lang_String_a = this.var_java_lang_String_b = "Assassins are masters of stealth and deadly ambushers. Sneak in or out of battle with skillful\ntactics to deceive and elude your opponents, striking vulnerable foes when the flow of battle\n is in your favor. Mastering the art of offense, control, and avoidance are essential in devestating\nthose that stand in your way.";
    }

    private void e() {
        this.ac = ((Engine)((Object)this.var_wd_a)).var_hg_a.ui_a(SpellName.Fireball).hd_a();
        this.ac.a((axm)((Object)this.var_wd_a));
        this.ad = ((Engine)((Object)this.var_wd_a)).var_hg_a.ui_a(SpellName.Combust).hd_a();
        this.ad.a((axm)((Object)this.var_wd_a));
        this.ae = ((Engine)((Object)this.var_wd_a)).var_hg_a.ui_a(SpellName.FlashFreeze).hd_a();
        this.ae.a((axm)((Object)this.var_wd_a));
        this.af = ((Engine)((Object)this.var_wd_a)).var_hg_a.ui_a(SpellName.Meteor).hd_a();
        this.af.a((axm)((Object)this.var_wd_a));
        this.ag = ((Engine)((Object)this.var_wd_a)).var_hg_a.ui_a(SpellName.Sheepify).hd_a();
        this.ag.a((axm)((Object)this.var_wd_a));
        this.ah = ((Engine)((Object)this.var_wd_a)).var_hg_a.ui_a(SpellName.Teleport).hd_a();
        this.ah.a((axm)((Object)this.var_wd_a));
    }

    private void f() {
        this.X = ((Engine)((Object)this.var_wd_a)).var_hg_a.ui_a(SpellName.TransferLife).hd_a();
        this.X.a((axm)((Object)this.var_wd_a));
        this.W = ((Engine)((Object)this.var_wd_a)).var_hg_a.ui_a(SpellName.LifeBurst).hd_a();
        this.W.a((axm)((Object)this.var_wd_a));
        this.aa = ((Engine)((Object)this.var_wd_a)).var_hg_a.ui_a(SpellName.GospelOfPurity).hd_a();
        this.aa.a((axm)((Object)this.var_wd_a));
        this.Y = ((Engine)((Object)this.var_wd_a)).var_hg_a.ui_a(SpellName.GospelOfHarmony).hd_a();
        this.Y.a((axm)((Object)this.var_wd_a));
        this.Z = ((Engine)((Object)this.var_wd_a)).var_hg_a.ui_a(SpellName.GospelOfDefiance).hd_a();
        this.Z.a((axm)((Object)this.var_wd_a));
        this.ab = ((Engine)((Object)this.var_wd_a)).var_hg_a.ui_a(SpellName.Truth).hd_a();
        this.ab.a((axm)((Object)this.var_wd_a));
    }

    private void g() {
        this.S = ((Engine)((Object)this.var_wd_a)).var_hg_a.ui_a(SpellName.HeadShot).hd_a();
        this.S.a((axm)((Object)this.var_wd_a));
        this.var_hd_R = ((Engine)((Object)this.var_wd_a)).var_hg_a.ui_a(SpellName.ElementalArrow).hd_a();
        this.var_hd_R.a((axm)((Object)this.var_wd_a));
        this.var_hd_Q = ((Engine)((Object)this.var_wd_a)).var_hg_a.ui_a(SpellName.PoisonousShot).hd_a();
        this.var_hd_Q.a((axm)((Object)this.var_wd_a));
        this.U = ((Engine)((Object)this.var_wd_a)).var_hg_a.ui_a(SpellName.SilencingShot).hd_a();
        this.U.a((axm)((Object)this.var_wd_a));
        this.T = ((Engine)((Object)this.var_wd_a)).var_hg_a.ui_a(SpellName.Quicksand).hd_a();
        this.T.a((axm)((Object)this.var_wd_a));
        this.V = ((Engine)((Object)this.var_wd_a)).var_hg_a.ui_a(SpellName.Vigor).hd_a();
        this.V.a((axm)((Object)this.var_wd_a));
    }

    private void h() {
        this.var_hd_L = ((Engine)((Object)this.var_wd_a)).var_hg_a.ui_a(SpellName.BlazingSlash).hd_a();
        this.var_hd_L.a((axm)((Object)this.var_wd_a));
        this.var_hd_K = ((Engine)((Object)this.var_wd_a)).var_hg_a.ui_a(SpellName.Sear).hd_a();
        this.var_hd_K.a((axm)((Object)this.var_wd_a));
        this.var_hd_N = ((Engine)((Object)this.var_wd_a)).var_hg_a.ui_a(SpellName.HeavensStrike).hd_a();
        this.var_hd_N.a((axm)((Object)this.var_wd_a));
        this.var_hd_M = ((Engine)((Object)this.var_wd_a)).var_hg_a.ui_a(SpellName.Immortality).hd_a();
        this.var_hd_M.a((axm)((Object)this.var_wd_a));
        this.var_hd_O = ((Engine)((Object)this.var_wd_a)).var_hg_a.ui_a(SpellName.DivineLight).hd_a();
        this.var_hd_O.a((axm)((Object)this.var_wd_a));
        this.var_hd_P = ((Engine)((Object)this.var_wd_a)).var_hg_a.ui_a(SpellName.SealOfTheHeavens).hd_a();
        this.var_hd_P.a((axm)((Object)this.var_wd_a));
    }

    private void i() {
        this.var_ayh_Q = new ayh(265, 460, ((axm)((Object)this.var_wd_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c), "Graylock", true);
        this.var_ayj_a = new ayj((Engine)((Object)this.var_wd_a), 265, 460, "[RED]Class Locked[]\nUnlocks at Rank [RARITY_POOR]Adept (3)[] - [RARITY_LEGENDARY]75 Fame[]\n\n[GREEN]Protip:[]\nPermanently gain [RARITY_LEGENDARY]Fame[] by winning 3v3 matches. Win Streaks reward greatly more [RARITY_LEGENDARY]Fame[] per win .. so build a great party and run with them!", azn.c, ((axm)((Object)this.var_wd_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c));
        this.var_ayj_a.d(280);
        this.var_ayj_a.c(50, 10);
        this.var_ayj_a.a(false);
        this.var_ayh_R = new ayh(870, 220, ((axm)((Object)this.var_wd_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c), "Graylock", true);
        this.var_ayh_R.com_badlogic_gdx_graphics_g2d_Sprite_a().scale(-0.3f);
        this.var_ayj_b = new ayj((Engine)((Object)this.var_wd_a), 870, 220, "[RED]Class Locked[]\nUnlocks at Rank [RARITY_POOR]Adept (3)[] - [RARITY_LEGENDARY]75 Fame[]\n\n[GREEN]Protip:[]\nPermanently gain [RARITY_LEGENDARY]Fame[] by winning 3v3 matches. Win Streaks reward greatly more [RARITY_LEGENDARY]Fame[] per win .. so build a great party and run with them!", azn.b, ((axm)((Object)this.var_wd_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c));
        this.var_ayj_b.d(280);
        this.var_ayj_b.c(50, 40);
        this.var_ayj_b.a(false);
        this.var_ayj_c = new ayj((Engine)((Object)this.var_wd_a), 450, 710, "Recommended [GREEN]Healer[] for beginners", "quest_icon_unhovered", azn.b, ((axm)((Object)this.var_wd_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c));
        this.var_ayj_c.d(250);
        this.var_ayj_c.c(40, 25);
        this.var_ayj_d = new ayj((Engine)((Object)this.var_wd_a), 450, 265, "Recommended [GREEN]Damage[] for beginners", "quest_icon_unhovered", azn.b, ((axm)((Object)this.var_wd_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c));
        this.var_ayj_d.d(250);
        this.var_ayj_d.c(40, 25);
        this.var_hd_E = ((Engine)((Object)this.var_wd_a)).var_hg_a.ui_a(SpellName.MindLeech).hd_a();
        this.var_hd_E.a((axm)((Object)this.var_wd_a));
        this.var_hd_F = ((Engine)((Object)this.var_wd_a)).var_hg_a.ui_a(SpellName.Karma).hd_a();
        this.var_hd_F.a((axm)((Object)this.var_wd_a));
        this.var_hd_G = ((Engine)((Object)this.var_wd_a)).var_hg_a.ui_a(SpellName.LingeringDemise).hd_a();
        this.var_hd_G.a((axm)((Object)this.var_wd_a));
        this.var_hd_H = ((Engine)((Object)this.var_wd_a)).var_hg_a.ui_a(SpellName.SiphonMana).hd_a();
        this.var_hd_H.a((axm)((Object)this.var_wd_a));
        this.var_hd_I = ((Engine)((Object)this.var_wd_a)).var_hg_a.ui_a(SpellName.OrbOfWisdom).hd_a();
        this.var_hd_I.a((axm)((Object)this.var_wd_a));
        this.var_hd_J = ((Engine)((Object)this.var_wd_a)).var_hg_a.ui_a(SpellName.DarkInoculation).hd_a();
        this.var_hd_J.a((axm)((Object)this.var_wd_a));
    }

    private void j() {
        this.var_hd_y = ((Engine)((Object)this.var_wd_a)).var_hg_a.ui_a(SpellName.HealingVision).hd_a();
        this.var_hd_y.a((axm)((Object)this.var_wd_a));
        this.var_hd_A = ((Engine)((Object)this.var_wd_a)).var_hg_a.ui_a(SpellName.TemporalBarrier).hd_a();
        this.var_hd_A.a((axm)((Object)this.var_wd_a));
        this.var_hd_z = ((Engine)((Object)this.var_wd_a)).var_hg_a.ui_a(SpellName.DreamOfProsperity).hd_a();
        this.var_hd_z.a((axm)((Object)this.var_wd_a));
        this.var_hd_C = ((Engine)((Object)this.var_wd_a)).var_hg_a.ui_a(SpellName.BlessingSunAndMoon).hd_a();
        this.var_hd_C.a((axm)((Object)this.var_wd_a));
        this.var_hd_B = ((Engine)((Object)this.var_wd_a)).var_hg_a.ui_a(SpellName.Cleanse).hd_a();
        this.var_hd_B.a((axm)((Object)this.var_wd_a));
        this.var_hd_D = ((Engine)((Object)this.var_wd_a)).var_hg_a.ui_a(SpellName.Blackout).hd_a();
        this.var_hd_D.a((axm)((Object)this.var_wd_a));
    }

    private void k() {
        this.var_hd_s = ((Engine)((Object)this.var_wd_a)).var_hg_a.ui_a(SpellName.Torment).hd_a();
        this.var_hd_s.a((axm)((Object)this.var_wd_a));
        this.var_hd_v = ((Engine)((Object)this.var_wd_a)).var_hg_a.ui_a(SpellName.Parasite).hd_a();
        this.var_hd_v.a((axm)((Object)this.var_wd_a));
        this.var_hd_t = ((Engine)((Object)this.var_wd_a)).var_hg_a.ui_a(SpellName.Miasma).hd_a();
        this.var_hd_t.a((axm)((Object)this.var_wd_a));
        this.var_hd_u = ((Engine)((Object)this.var_wd_a)).var_hg_a.ui_a(SpellName.Terrify).hd_a();
        this.var_hd_u.a((axm)((Object)this.var_wd_a));
        this.var_hd_w = ((Engine)((Object)this.var_wd_a)).var_hg_a.ui_a(SpellName.BloodOfTheDying).hd_a();
        this.var_hd_w.a((axm)((Object)this.var_wd_a));
        this.var_hd_x = ((Engine)((Object)this.var_wd_a)).var_hg_a.ui_a(SpellName.UnderworldArmor).hd_a();
        this.var_hd_x.a((axm)((Object)this.var_wd_a));
    }

    private void l() {
        this.var_hd_m = ((Engine)((Object)this.var_wd_a)).var_hg_a.ui_a(SpellName.Revitalize).hd_a();
        this.var_hd_m.a((axm)((Object)this.var_wd_a));
        this.var_hd_n = ((Engine)((Object)this.var_wd_a)).var_hg_a.ui_a(SpellName.MendingSpirit).hd_a();
        this.var_hd_n.a((axm)((Object)this.var_wd_a));
        this.var_hd_o = ((Engine)((Object)this.var_wd_a)).var_hg_a.ui_a(SpellName.Remedy).hd_a();
        this.var_hd_o.a((axm)((Object)this.var_wd_a));
        this.var_hd_p = ((Engine)((Object)this.var_wd_a)).var_hg_a.ui_a(SpellName.SeedOfLife).hd_a();
        this.var_hd_p.a((axm)((Object)this.var_wd_a));
        this.var_hd_q = ((Engine)((Object)this.var_wd_a)).var_hg_a.ui_a(SpellName.Inspiration).hd_a();
        this.var_hd_q.a((axm)((Object)this.var_wd_a));
        this.var_hd_r = ((Engine)((Object)this.var_wd_a)).var_hg_a.ui_a(SpellName.SpiritWolf).hd_a();
        this.var_hd_r.a((axm)((Object)this.var_wd_a));
    }

    private void m() {
        this.var_hd_h = ((Engine)((Object)this.var_wd_a)).var_hg_a.ui_a(SpellName.Lacerate).hd_a();
        this.var_hd_h.a((axm)((Object)this.var_wd_a));
        this.var_hd_i = ((Engine)((Object)this.var_wd_a)).var_hg_a.ui_a(SpellName.CrushingBlow).hd_a();
        this.var_hd_i.a((axm)((Object)this.var_wd_a));
        this.var_hd_g = ((Engine)((Object)this.var_wd_a)).var_hg_a.ui_a(SpellName.ArmorBreak).hd_a();
        this.var_hd_g.a((axm)((Object)this.var_wd_a));
        this.var_hd_j = ((Engine)((Object)this.var_wd_a)).var_hg_a.ui_a(SpellName.Whirlwind).hd_a();
        this.var_hd_j.a((axm)((Object)this.var_wd_a));
        this.var_hd_l = ((Engine)((Object)this.var_wd_a)).var_hg_a.ui_a(SpellName.Charge).hd_a();
        this.var_hd_l.a((axm)((Object)this.var_wd_a));
        this.var_hd_k = ((Engine)((Object)this.var_wd_a)).var_hg_a.ui_a(SpellName.EnduringWarcry).hd_a();
        this.var_hd_k.a((axm)((Object)this.var_wd_a));
    }

    private void n() {
        this.var_hd_a = ((Engine)((Object)this.var_wd_a)).var_hg_a.ui_a(SpellName.Annihilate).hd_a();
        this.var_hd_a.a((axm)((Object)this.var_wd_a));
        this.var_hd_b = ((Engine)((Object)this.var_wd_a)).var_hg_a.ui_a(SpellName.Envenom).hd_a();
        this.var_hd_b.a((axm)((Object)this.var_wd_a));
        this.var_hd_c = ((Engine)((Object)this.var_wd_a)).var_hg_a.ui_a(SpellName.Slap).hd_a();
        this.var_hd_c.a((axm)((Object)this.var_wd_a));
        this.var_hd_d = ((Engine)((Object)this.var_wd_a)).var_hg_a.ui_a(SpellName.Daze).hd_a();
        this.var_hd_d.a((axm)((Object)this.var_wd_a));
        this.var_hd_e = ((Engine)((Object)this.var_wd_a)).var_hg_a.ui_a(SpellName.Dash).hd_a();
        this.var_hd_e.a((axm)((Object)this.var_wd_a));
        this.var_hd_f = ((Engine)((Object)this.var_wd_a)).var_hg_a.ui_a(SpellName.Stealth).hd_a();
        this.var_hd_f.a((axm)((Object)this.var_wd_a));
    }

    private void o() {
        System.out.println("a");
        TextureAtlas textureAtlas = ((axm)((Object)this.var_wd_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.jd);
        this.var_ayh_k = new ayh(250, 891, textureAtlas, "Assassin", true);
        this.var_ayh_n = new ayh(250, 802, textureAtlas, "Champion", true);
        this.var_ayh_q = new ayh(250, 713, textureAtlas, "Elder", true);
        this.var_ayh_t = new ayh(250, 624, textureAtlas, "Lich", true);
        this.var_ayh_w = new ayh(250, 535, textureAtlas, "Mystic", true);
        this.var_ayh_z = new ayh(250, 446, textureAtlas, "Nihilist", true);
        this.var_ayh_C = new ayh(250, 357, textureAtlas, "Paladin", true);
        this.var_ayh_F = new ayh(250, 268, textureAtlas, "Ranger", true);
        this.var_ayh_I = new ayh(250, 179, textureAtlas, "Scholar", true);
        this.var_ayh_L = new ayh(250, 90, textureAtlas, "Wizard", true);
        System.out.println("b");
        this.var_ayh_l = new ayh(328, 912, textureAtlas, "assassin_label", true);
        this.var_ayh_o = new ayh(320, 823, textureAtlas, "champion_label", true);
        this.var_ayh_r = new ayh(336, 734, textureAtlas, "elder_label", true);
        this.var_ayh_u = new ayh(345, 645, textureAtlas, "lich_label", true);
        this.var_ayh_x = new ayh(335, 556, textureAtlas, "mystic_label", true);
        this.var_ayh_A = new ayh(328, 467, textureAtlas, "nihilist_label", true);
        this.var_ayh_D = new ayh(332, 378, textureAtlas, "paladin_label", true);
        this.var_ayh_G = new ayh(332, 289, textureAtlas, "ranger_label", true);
        this.var_ayh_J = new ayh(330, 200, textureAtlas, "scholar_label", true);
        this.var_ayh_M = new ayh(333, 111, textureAtlas, "wizard_label", true);
        this.var_ayh_m = new vm(this, 233, 892, ((axm)((Object)this.var_wd_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.f), "class_backdrop", 1, true);
        this.var_ayh_p = new vs(this, 233, 803, ((axm)((Object)this.var_wd_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.f), "class_backdrop", 1, true);
        this.var_ayh_s = new vt(this, 233, 714, ((axm)((Object)this.var_wd_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.f), "class_backdrop", 1, true);
        this.var_ayh_v = new vu(this, 233, 625, ((axm)((Object)this.var_wd_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.f), "class_backdrop", 1, true);
        this.var_ayh_y = new vv(this, 233, 536, ((axm)((Object)this.var_wd_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.f), "class_backdrop", 1, true);
        this.var_ayh_B = new vw(this, 233, 447, ((axm)((Object)this.var_wd_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.f), "class_backdrop", 1, true);
        this.var_ayh_E = new vx(this, 233, 358, ((axm)((Object)this.var_wd_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.f), "class_backdrop", 1, true);
        this.var_ayh_H = new vy(this, 233, 269, ((axm)((Object)this.var_wd_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.f), "class_backdrop", 1, true);
        this.var_ayh_K = new vz(this, 233, 180, ((axm)((Object)this.var_wd_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.f), "class_backdrop", 1, true);
        this.var_ayh_N = new vn(this, 233, 91, ((axm)((Object)this.var_wd_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.f), "class_backdrop", 1, true);
        this.var_ayh_c = new ayh(0, 0, ((axm)((Object)this.var_wd_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.f), "class_backdrop_glow", true);
        this.var_ct_a = new ct();
        this.var_ct_a.a(((Engine)((Object)this.var_wd_a)).var_com_badlogic_gdx_assets_AssetManager_a, CharacterClass.ASSASSIN, db.var_db_a, 1);
        this.var_ct_a.a(CharacterClass.ASSASSIN).a(819.0f, 375.0f);
        this.var_ct_a.a(((Engine)((Object)this.var_wd_a)).var_com_badlogic_gdx_assets_AssetManager_a, CharacterClass.CHAMPION, db.var_db_a, 1);
        this.var_ct_a.a(CharacterClass.CHAMPION).a(819.0f, 375.0f);
        this.var_ct_a.a(((Engine)((Object)this.var_wd_a)).var_com_badlogic_gdx_assets_AssetManager_a, CharacterClass.ELDER, db.var_db_a, 1);
        this.var_ct_a.a(CharacterClass.ELDER).a(819.0f, 375.0f);
        this.var_ct_a.a(((Engine)((Object)this.var_wd_a)).var_com_badlogic_gdx_assets_AssetManager_a, CharacterClass.LICH, db.var_db_a, 1);
        this.var_ct_a.a(CharacterClass.LICH).a(819.0f, 375.0f);
        this.var_ct_a.a(((Engine)((Object)this.var_wd_a)).var_com_badlogic_gdx_assets_AssetManager_a, CharacterClass.MYSTIC, db.var_db_a, 1);
        this.var_ct_a.a(CharacterClass.MYSTIC).a(819.0f, 375.0f);
        this.var_ct_a.a(((Engine)((Object)this.var_wd_a)).var_com_badlogic_gdx_assets_AssetManager_a, CharacterClass.NIHILIST, db.var_db_a, 1);
        this.var_ct_a.a(CharacterClass.NIHILIST).a(819.0f, 375.0f);
        this.var_ct_a.a(((Engine)((Object)this.var_wd_a)).var_com_badlogic_gdx_assets_AssetManager_a, CharacterClass.PALADIN, db.var_db_a, 1);
        this.var_ct_a.a(CharacterClass.PALADIN).a(819.0f, 375.0f);
        this.var_ct_a.a(((Engine)((Object)this.var_wd_a)).var_com_badlogic_gdx_assets_AssetManager_a, CharacterClass.RANGER, db.var_db_a, 1);
        this.var_ct_a.a(CharacterClass.RANGER).a(819.0f, 375.0f);
        this.var_ct_a.a(((Engine)((Object)this.var_wd_a)).var_com_badlogic_gdx_assets_AssetManager_a, CharacterClass.SCHOLAR, db.var_db_a, 1);
        this.var_ct_a.a(CharacterClass.SCHOLAR).a(819.0f, 375.0f);
        this.var_ct_a.a(((Engine)((Object)this.var_wd_a)).var_com_badlogic_gdx_assets_AssetManager_a, CharacterClass.WIZARD, db.var_db_a, 1);
        this.var_ct_a.a(CharacterClass.WIZARD).a(819.0f, 375.0f);
        this.var_ayh_d = new ayh(741, 146, ((axm)((Object)this.var_wd_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.f), "name_backdrop", 1, true);
        this.var_ayh_e = new ayh(727, 910, ((axm)((Object)this.var_wd_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.f), "choose_your_class", true);
        this.var_ayh_j = new ayh(647, 883, ((axm)((Object)this.var_wd_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.f), "decorative_detail", true);
        this.var_ayh_f = new ayh(0, 0, ((axm)((Object)this.var_wd_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.f), "bottom_bar", true);
        this.var_ayh_g = new ayh(0, 1004, ((axm)((Object)this.var_wd_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.f), "top_bar", true);
        this.var_ayh_h = new ayh(1376, 84, ((axm)((Object)this.var_wd_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.f), "bottom_right_panel", true);
        this.var_ayh_i = new ayh(1376, 558, ((axm)((Object)this.var_wd_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.f), "top_right_panel", true);
        this.var_ayh_c = new ayh(0, 0, ((axm)((Object)this.var_wd_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.f), "class_backdrop_glow", true);
        Engine.a("pree");
        this.var_ayh_P = new ayh(885, 435, ((axm)((Object)this.var_wd_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.h), "black_platform", 0, true);
        Engine.a("postt");
        this.var_ayc_a = new vo(this, 857, 66, ((axm)((Object)this.var_wd_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.f), "create_button_unhovered", "create_button_hovered", "create_button_grayed", true);
        this.var_ayf_a = new vp(this, 16, 66, ((axm)((Object)this.var_wd_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.f), "cancel_button_unhovered", "cancel_button_hovered", true);
    }

    private void a(CharacterClass characterClass) {
        this.var_da_a = this.var_ct_a.a(characterClass);
        this.var_com_arenaofkings_packets_misc_CharacterClass_a = characterClass;
        switch (characterClass) {
            case ASSASSIN: {
                this.var_ayh_O = this.var_ayh_k;
                this.var_ayh_a = this.var_ayh_l;
                this.var_ayh_b = this.var_ayh_m;
                ((Array)((Object)this.var_wd_a)).clear();
                ((Array)((Object)this.var_wd_a)).add(this.var_hd_a, this.var_hd_b, this.var_hd_c);
                ((Array)((Object)this.var_wd_a)).add(this.var_hd_d, this.var_hd_e, this.var_hd_f);
                break;
            }
            case CHAMPION: {
                this.var_ayh_O = this.var_ayh_n;
                this.var_ayh_a = this.var_ayh_o;
                this.var_ayh_b = this.var_ayh_p;
                ((Array)((Object)this.var_wd_a)).clear();
                ((Array)((Object)this.var_wd_a)).add(this.var_hd_g, this.var_hd_h, this.var_hd_i);
                ((Array)((Object)this.var_wd_a)).add(this.var_hd_j, this.var_hd_k, this.var_hd_l);
                break;
            }
            case ELDER: {
                this.var_ayh_O = this.var_ayh_q;
                this.var_ayh_a = this.var_ayh_r;
                this.var_ayh_b = this.var_ayh_s;
                ((Array)((Object)this.var_wd_a)).clear();
                ((Array)((Object)this.var_wd_a)).add(this.var_hd_m, this.var_hd_n, this.var_hd_o);
                ((Array)((Object)this.var_wd_a)).add(this.var_hd_p, this.var_hd_q, this.var_hd_r);
                break;
            }
            case LICH: {
                this.var_ayh_O = this.var_ayh_t;
                this.var_ayh_a = this.var_ayh_u;
                this.var_ayh_b = this.var_ayh_v;
                ((Array)((Object)this.var_wd_a)).clear();
                ((Array)((Object)this.var_wd_a)).add(this.var_hd_s, this.var_hd_t, this.var_hd_u);
                ((Array)((Object)this.var_wd_a)).add(this.var_hd_v, this.var_hd_w, this.var_hd_x);
                break;
            }
            case MYSTIC: {
                this.var_ayh_O = this.var_ayh_w;
                this.var_ayh_a = this.var_ayh_x;
                this.var_ayh_b = this.var_ayh_y;
                ((Array)((Object)this.var_wd_a)).clear();
                ((Array)((Object)this.var_wd_a)).add(this.var_hd_y, this.var_hd_z, this.var_hd_A);
                ((Array)((Object)this.var_wd_a)).add(this.var_hd_B, this.var_hd_C, this.var_hd_D);
                break;
            }
            case NIHILIST: {
                this.var_ayh_O = this.var_ayh_z;
                this.var_ayh_a = this.var_ayh_A;
                this.var_ayh_b = this.var_ayh_B;
                ((Array)((Object)this.var_wd_a)).clear();
                ((Array)((Object)this.var_wd_a)).add(this.var_hd_E, this.var_hd_F, this.var_hd_G);
                ((Array)((Object)this.var_wd_a)).add(this.var_hd_H, this.var_hd_I, this.var_hd_J);
                break;
            }
            case PALADIN: {
                this.var_ayh_O = this.var_ayh_C;
                this.var_ayh_a = this.var_ayh_D;
                this.var_ayh_b = this.var_ayh_E;
                ((Array)((Object)this.var_wd_a)).clear();
                ((Array)((Object)this.var_wd_a)).add(this.var_hd_K, this.var_hd_L, this.var_hd_M);
                ((Array)((Object)this.var_wd_a)).add(this.var_hd_N, this.var_hd_O, this.var_hd_P);
                break;
            }
            case RANGER: {
                this.var_ayh_O = this.var_ayh_F;
                this.var_ayh_a = this.var_ayh_G;
                this.var_ayh_b = this.var_ayh_H;
                ((Array)((Object)this.var_wd_a)).clear();
                ((Array)((Object)this.var_wd_a)).add(this.var_hd_Q, this.var_hd_R, this.S);
                ((Array)((Object)this.var_wd_a)).add(this.T, this.U, this.V);
                break;
            }
            case SCHOLAR: {
                this.var_ayh_O = this.var_ayh_I;
                this.var_ayh_a = this.var_ayh_J;
                this.var_ayh_b = this.var_ayh_K;
                ((Array)((Object)this.var_wd_a)).clear();
                ((Array)((Object)this.var_wd_a)).add(this.W, this.X, this.Y);
                ((Array)((Object)this.var_wd_a)).add(this.Z, this.aa, this.ab);
                break;
            }
            case WIZARD: {
                this.var_ayh_O = this.var_ayh_L;
                this.var_ayh_a = this.var_ayh_M;
                this.var_ayh_b = this.var_ayh_N;
                ((Array)((Object)this.var_wd_a)).clear();
                ((Array)((Object)this.var_wd_a)).add(this.ac, this.ad, this.ae);
                ((Array)((Object)this.var_wd_a)).add(this.af, this.ag, this.ah);
                break;
            }
        }
        ((Engine)((Object)this.var_wd_a)).var_baa_a.a(ajw.kD, 0.7f);
        this.p();
    }

    private void p() {
        Iterator iterator = ((Array)((Object)this.var_wd_a)).iterator();
        while (iterator.hasNext()) {
            hd hd2 = (hd)iterator.next();
            hd2.da_b().void_a();
        }
    }

    private void q() {
        this.var_axh_a = new axh("", ((Engine)((Object)this.var_wd_a)).var_com_badlogic_gdx_scenes_scene2d_ui_Skin_a);
        this.var_axh_a.setPosition(780.0f, 160.0f);
        this.var_axh_a.setSize(350.0f, 40.0f);
        this.var_axh_a.void_a(11);
        this.var_axh_a.c(false);
        this.var_axh_a.setColor(Color.LIGHT_GRAY);
        this.var_axh_a.com_badlogic_gdx_scenes_scene2d_ui_TextField$TextFieldStyle_a().fontColor = Color.WHITE;
        this.var_axh_a.void_a(0.2f);
        this.var_axh_a.c(1);
    }

    private void r() {
        ((Stage)((Object)this.var_wd_a)).addActor(this.var_axh_a);
        ((Stage)((Object)this.var_wd_a)).setKeyboardFocus(this.var_axh_a);
    }

    public void a(float f2) {
        this.var_ayh_m.a(f2, (Engine)((Object)this.var_wd_a));
        this.var_ayh_p.a(f2, (Engine)((Object)this.var_wd_a));
        this.var_ayh_s.a(f2, (Engine)((Object)this.var_wd_a));
        this.var_ayh_v.a(f2, (Engine)((Object)this.var_wd_a));
        this.var_ayh_y.a(f2, (Engine)((Object)this.var_wd_a));
        this.var_ayh_B.a(f2, (Engine)((Object)this.var_wd_a));
        this.var_ayh_E.a(f2, (Engine)((Object)this.var_wd_a));
        this.var_ayh_H.a(f2, (Engine)((Object)this.var_wd_a));
        this.var_ayh_K.a(f2, (Engine)((Object)this.var_wd_a));
        this.var_ayh_N.a(f2, (Engine)((Object)this.var_wd_a));
    }

    @Override
    public void a(float f2, azi azi2) {
        this.a(f2);
        azi2.begin();
        this.var_ayh_P.b(f2, (Engine)((Object)this.var_wd_a));
        this.var_da_a.b(f2, (Engine)((Object)this.var_wd_a));
        this.var_ayh_O.b(f2, (Engine)((Object)this.var_wd_a), 1377, 886);
        this.var_ayh_d.b(f2, (Engine)((Object)this.var_wd_a));
        this.var_ayh_e.b(f2, (Engine)((Object)this.var_wd_a));
        this.var_ayh_j.b(f2, (Engine)((Object)this.var_wd_a));
        this.var_ayh_f.b(f2, (Engine)((Object)this.var_wd_a));
        this.var_ayh_g.b(f2, (Engine)((Object)this.var_wd_a));
        this.var_ayh_h.b(f2, (Engine)((Object)this.var_wd_a));
        this.var_ayh_i.b(f2, (Engine)((Object)this.var_wd_a));
        if (this.var_ayh_a == this.var_ayh_l) {
            this.var_ayh_a.b(f2, (Engine)((Object)this.var_wd_a), 1555, 911);
        } else if (this.var_ayh_a == this.var_ayh_o) {
            this.var_ayh_a.b(f2, (Engine)((Object)this.var_wd_a), 1547, 912);
        } else if (this.var_ayh_a == this.var_ayh_r) {
            this.var_ayh_a.b(f2, (Engine)((Object)this.var_wd_a), 1567, 909);
        } else if (this.var_ayh_a == this.var_ayh_u) {
            this.var_ayh_a.b(f2, (Engine)((Object)this.var_wd_a), 1574, 909);
        } else if (this.var_ayh_a == this.var_ayh_x) {
            this.var_ayh_a.b(f2, (Engine)((Object)this.var_wd_a), 1562, 911);
        } else if (this.var_ayh_a == this.var_ayh_A) {
            this.var_ayh_a.b(f2, (Engine)((Object)this.var_wd_a), 1555, 910);
        } else if (this.var_ayh_a == this.var_ayh_D) {
            this.var_ayh_a.b(f2, (Engine)((Object)this.var_wd_a), 1555, 910);
        } else if (this.var_ayh_a == this.var_ayh_G) {
            this.var_ayh_a.b(f2, (Engine)((Object)this.var_wd_a), 1558, 911);
        } else if (this.var_ayh_a == this.var_ayh_J) {
            this.var_ayh_a.b(f2, (Engine)((Object)this.var_wd_a), 1555, 909);
        } else if (this.var_ayh_a == this.var_ayh_M) {
            this.var_ayh_a.b(f2, (Engine)((Object)this.var_wd_a), 1560, 910);
        }
        this.var_ayh_c.b(f2, (Engine)((Object)this.var_wd_a), (int)this.var_ayh_b.com_badlogic_gdx_graphics_g2d_Sprite_a().getX() - 10, (int)this.var_ayh_b.com_badlogic_gdx_graphics_g2d_Sprite_a().getY() - 15);
        this.var_ayh_m.b(f2, (Engine)((Object)this.var_wd_a));
        this.var_ayh_l.b(f2, (Engine)((Object)this.var_wd_a));
        this.var_ayh_k.b(f2, (Engine)((Object)this.var_wd_a));
        this.var_ayh_p.b(f2, (Engine)((Object)this.var_wd_a));
        this.var_ayh_o.b(f2, (Engine)((Object)this.var_wd_a));
        this.var_ayh_n.b(f2, (Engine)((Object)this.var_wd_a));
        this.var_ayh_s.b(f2, (Engine)((Object)this.var_wd_a));
        this.var_ayh_r.b(f2, (Engine)((Object)this.var_wd_a));
        this.var_ayh_q.b(f2, (Engine)((Object)this.var_wd_a));
        this.var_ayh_v.b(f2, (Engine)((Object)this.var_wd_a));
        this.var_ayh_u.b(f2, (Engine)((Object)this.var_wd_a));
        this.var_ayh_t.b(f2, (Engine)((Object)this.var_wd_a));
        this.var_ayh_y.b(f2, (Engine)((Object)this.var_wd_a));
        this.var_ayh_x.b(f2, (Engine)((Object)this.var_wd_a));
        this.var_ayh_w.b(f2, (Engine)((Object)this.var_wd_a));
        this.var_ayh_B.b(f2, (Engine)((Object)this.var_wd_a));
        this.var_ayh_A.b(f2, (Engine)((Object)this.var_wd_a));
        this.var_ayh_z.b(f2, (Engine)((Object)this.var_wd_a));
        this.var_ayh_E.b(f2, (Engine)((Object)this.var_wd_a));
        this.var_ayh_D.b(f2, (Engine)((Object)this.var_wd_a));
        this.var_ayh_C.b(f2, (Engine)((Object)this.var_wd_a));
        this.var_ayh_H.b(f2, (Engine)((Object)this.var_wd_a));
        this.var_ayh_G.b(f2, (Engine)((Object)this.var_wd_a));
        this.var_ayh_F.b(f2, (Engine)((Object)this.var_wd_a));
        this.var_ayh_K.b(f2, (Engine)((Object)this.var_wd_a));
        this.var_ayh_J.b(f2, (Engine)((Object)this.var_wd_a));
        this.var_ayh_I.b(f2, (Engine)((Object)this.var_wd_a));
        this.var_ayh_N.b(f2, (Engine)((Object)this.var_wd_a));
        this.var_ayh_M.b(f2, (Engine)((Object)this.var_wd_a));
        this.var_ayh_L.b(f2, (Engine)((Object)this.var_wd_a));
        this.var_ayj_c.a(f2, (Engine)((Object)this.var_wd_a));
        this.var_ayj_c.b(f2, (Engine)((Object)this.var_wd_a));
        this.var_ayj_d.a(f2, (Engine)((Object)this.var_wd_a));
        this.var_ayj_d.b(f2, (Engine)((Object)this.var_wd_a));
        ((Engine)((Object)this.var_wd_a)).a(this.var_com_arenaofkings_packets_misc_CharacterClass_a.getDescription(), ((Engine)((Object)this.var_wd_a)).var_axy_c.a(), axe.y, ((Engine)((Object)this.var_wd_a)).var_axy_c.a(), Color.BLACK, 1612.0f, 880.0f, 1, 1);
        ((Engine)((Object)this.var_wd_a)).a(this.var_axh_a.java_lang_String_a(), ((Engine)((Object)this.var_wd_a)).var_axy_c.a(), Color.WHITE, ((Engine)((Object)this.var_wd_a)).var_axy_c.a(), Color.BLACK, 948.0f, 600.0f, 1, 1);
        azi2.end();
        ((Stage)((Object)this.var_wd_a)).act(f2);
        ((Stage)((Object)this.var_wd_a)).draw();
        azi2.begin();
        ((Engine)((Object)this.var_wd_a)).a("[GREEN]Seasonal Hero\n[WHITE]A fresh start!\nCharacters are reset & wiped\nevery new season.", 1130, 131, 225);
        ((Engine)((Object)this.var_wd_a)).a("[GREEN]Seasonal Hero\n[WHITE]A fresh start!\nCharacters are reset & wiped\nevery new season.", 1130, 131);
        for (int i2 = 0; i2 < ((Array)((Object)this.var_wd_a)).size; ++i2) {
            ((hd)((Array)((Object)this.var_wd_a)).get(i2)).a(f2, (Engine)((Object)this.var_wd_a), 1420, 458 - 60 * i2);
            ((Engine)((Object)this.var_wd_a)).a(SpellName.getFormattedName(((hd)((Array)((Object)this.var_wd_a)).get(i2)).com_arenaofkings_packets_gameserver_data_updates_SpellName_a()), ((Engine)((Object)this.var_wd_a)).var_axy_c.a(), axe.y, ((Engine)((Object)this.var_wd_a)).var_axy_c.a(), Color.BLACK, 1612.0f, (float)(496 - 60 * i2), 1, 1);
        }
        azi2.end();
    }

    public void void_c() {
        Label.LabelStyle labelStyle = new Label.LabelStyle(((Engine)((Object)this.var_wd_a)).j, Color.WHITE);
        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = ((Engine)((Object)this.var_wd_a)).l;
        textButtonStyle.fontColor = axe.K;
        this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a = new vq(this, "", ((Engine)((Object)this.var_wd_a)).var_com_badlogic_gdx_scenes_scene2d_ui_Skin_a, labelStyle);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a.align(1);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a.setBounds(827.0f, 245.0f, 250.0f, 125.0f);
        if (!((Stage)((Object)this.var_wd_a)).getActors().contains(this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a, true)) {
            ((Stage)((Object)this.var_wd_a)).addActor(this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a);
            Engine.b("added dialog");
        } else {
            Engine.b("didn't add dialog");
        }
    }

    public axh axh_a() {
        return this.var_axh_a;
    }

    @Override
    public void void_b() {
        this.var_com_badlogic_gdx_graphics_g2d_BitmapFont_a.dispose();
        this.var_com_badlogic_gdx_graphics_g2d_SpriteBatch_a.dispose();
        super.void_b();
    }

    static /* synthetic */ void a(vl vl2, CharacterClass characterClass) {
        vl2.a(characterClass);
    }

    static /* synthetic */ ayh ayh_a(vl vl2) {
        return vl2.var_ayh_O;
    }

    static /* synthetic */ ayh b(vl vl2) {
        return vl2.var_ayh_z;
    }

    static /* synthetic */ axh axh_a(vl vl2) {
        return vl2.var_axh_a;
    }

    static /* synthetic */ CharacterClass com_arenaofkings_packets_misc_CharacterClass_a(vl vl2) {
        return vl2.var_com_arenaofkings_packets_misc_CharacterClass_a;
    }

    static /* synthetic */ wd wd_a(vl vl2) {
        return vl2.var_wd_a;
    }
}

