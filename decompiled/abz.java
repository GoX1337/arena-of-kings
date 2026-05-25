/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.items.ItemData;
import com.arenaofkings.packets.misc.items.ItemRarity;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;

public class abz
extends ze {
    private boolean var_boolean_b = false;
    private fx var_fx_a;
    private fx var_fx_b;
    private fx var_fx_c;
    private da var_da_a = new da();
    private ayh var_ayh_c;
    private ayh d;
    private ayh e;
    private ayh f;
    private ayh g;
    private ayh h;
    private ayf var_ayf_a;
    private Dialog var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a;

    public abz(Engine engine, axm axm2, Stage stage, boolean bl2) {
        super(engine, 6, axm2, stage, yo.c, bl2);
        this.f();
        ItemData itemData = new ItemData(fp.bU, ItemRarity.LEGENDARY);
        itemData.name = "Membership Subscription (1 month)";
        this.var_fx_a = new fx(itemData);
        this.var_fx_a.a("[RARITY_UNCOMMON]Subscribe to unlock Membership perks to your account:[RARITY_UNIQUE]\n -Subscriber Badge displayed next to your name in chat channels based on consecutive months  with an active Subscription.\n  1 Month Badge\n  2 Month Badge\n  3 Month Badge\n  6 Month Badge\n  1 Year Badge\n  2 Year Badge\n -Items looted in-game are sent directly to an available Stash Tab when your Inventory is full.\n -Satchels of Tresure are sent directly to an available Stash Tab when your Inventory is full.\n -Prioritized matchmaking and expedited queue times for you and your Party Members to get into your next game faster.\n -Bypass login queue times, being put to the front of the line for fastest server access.\n -Access to Live Servers when they are over capacity and not allowing users to log in.\n -Access to Test Realm content to experience new content, spells, and game updates directly with the Developers.\n -Automatically receive occasional Member's Only gifts (exclusive skins, perks, giveaways) from the development team as a token of our thanks!\n -Exclusive Member's Only GM Tickets can be created via the Discord Ticket Tool to help you with any issue. Members Tickets are put to the front of the line.\n -Extended hands-on Support and account recovery protection.\n");
        ItemData itemData2 = new ItemData(fp.bV, ItemRarity.LEGENDARY);
        itemData2.name = "Membership Scroll (3 months)";
        this.var_fx_b = new fx(itemData2);
        this.var_fx_b.a("[RARITY_UNCOMMON]Subscribe to unlock Membership perks to your account:[RARITY_UNIQUE]\n -Subscriber Badge displayed next to your name in chat channels based on consecutive months  with an active Subscription.\n  1 Month Badge\n  2 Month Badge\n  3 Month Badge\n  6 Month Badge\n  1 Year Badge\n  2 Year Badge\n -Items looted in-game are sent directly to an available Stash Tab when your Inventory is full.\n -Satchels of Tresure are sent directly to an available Stash Tab when your Inventory is full.\n -Prioritized matchmaking and expedited queue times for you and your Party Members to get into your next game faster.\n -Bypass login queue times, being put to the front of the line for fastest server access.\n -Access to Live Servers when they are over capacity and not allowing users to log in.\n -Access to Test Realm content to experience new content, spells, and game updates directly with the Developers.\n -Automatically receive occasional Member's Only gifts (exclusive skins, perks, giveaways) from the development team as a token of our thanks!\n -Exclusive Member's Only GM Tickets can be created via the Discord Ticket Tool to help you with any issue. Members Tickets are put to the front of the line.\n -Extended hands-on Support and account recovery protection.\n");
        ItemData itemData3 = new ItemData(fp.bW, ItemRarity.LEGENDARY);
        itemData3.name = "Membership Scroll (1 year)";
        this.var_fx_c = new fx(itemData3);
        this.var_fx_c.a("[RARITY_UNCOMMON]Subscribe to unlock Membership perks to your account:[RARITY_UNIQUE]\n -Subscriber Badge displayed next to your name in chat channels based on consecutive months  with an active Subscription.\n  1 Month Badge\n  2 Month Badge\n  3 Month Badge\n  6 Month Badge\n  1 Year Badge\n  2 Year Badge\n -Items looted in-game are sent directly to an available Stash Tab when your Inventory is full.\n -Satchels of Tresure are sent directly to an available Stash Tab when your Inventory is full.\n -Prioritized matchmaking and expedited queue times for you and your Party Members to get into your next game faster.\n -Bypass login queue times, being put to the front of the line for fastest server access.\n -Access to Live Servers when they are over capacity and not allowing users to log in.\n -Access to Test Realm content to experience new content, spells, and game updates directly with the Developers.\n -Automatically receive occasional Member's Only gifts (exclusive skins, perks, giveaways) from the development team as a token of our thanks!\n -Exclusive Member's Only GM Tickets can be created via the Discord Ticket Tool to help you with any issue. Members Tickets are put to the front of the line.\n -Extended hands-on Support and account recovery protection.\n");
        abi abi2 = abi.Y;
        this.var_da_a = new da(abi2.getScreenDependency(), abi2.aer_a().java_lang_String_a(), abi2.aer_a().int_c(), 0.06666667f, abi2.aer_a().float_b(), Animation.PlayMode.LOOP, abi2.aer_a().d(), abi2.aer_a().e());
        this.var_da_a.d(-0.4f);
        this.var_da_a.a(axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.jy));
    }

    @Override
    public void g() {
        super.g();
        if (!this.var_boolean_b) {
            TextureAtlas textureAtlas = ((axm)((Object)this.var_fx_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.b);
            TextureAtlas textureAtlas2 = ((axm)((Object)this.var_fx_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c);
            this.var_ayf_a = new aca(this, 993, 450, textureAtlas, "unsubscribe_default", "unsubscribe_hovered", true);
            this.a(new acz((Engine)((Object)this.var_fx_a), abi.ah, new acw(), textureAtlas, abe.var_abe_a, this, new acc(this, (Engine)((Object)this.var_fx_a), 0, 0, ((axm)((Object)this.var_fx_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.b), abi.ah, true, true), true));
            this.a(new acz((Engine)((Object)this.var_fx_a), abi.ai, new acx(), textureAtlas, abe.var_abe_b, this, new acd(this, (Engine)((Object)this.var_fx_a), 0, 0, ((axm)((Object)this.var_fx_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.b), abi.ai, true, true), true));
            this.a(new acz((Engine)((Object)this.var_fx_a), abi.aj, new acy(), textureAtlas, abe.c, this, new ace(this, (Engine)((Object)this.var_fx_a), 0, 0, ((axm)((Object)this.var_fx_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.b), abi.aj, true, true), true));
            this.var_ayh_c = new ayh(500, 500, textureAtlas2, "LargeSubBadge-01", 0.4f);
            this.d = new ayh(500, 500, textureAtlas2, "LargeSubBadge-02", 0.4f);
            this.e = new ayh(500, 500, textureAtlas2, "LargeSubBadge-03", 0.4f);
            this.f = new ayh(500, 500, textureAtlas2, "LargeSubBadge-04", 0.4f);
            this.g = new ayh(500, 500, textureAtlas2, "LargeSubBadge-05", 0.4f);
            this.h = new ayh(500, 500, textureAtlas2, "LargeSubBadge-06", 0.4f);
            this.var_fx_a.a((axm)((Object)this.var_fx_a), true);
            this.var_boolean_b = true;
        }
    }

    @Override
    public void a(float f2, Engine engine) {
    }

    @Override
    public void b(float f2, Engine engine) {
        if (this.var_fx_a != false) {
            this.a(f2, engine);
            super.b(f2, engine);
            if (ay.ay_a().gd_a().boolean_d() && ay.ay_a().gd_a().boolean_f()) {
                engine.a(" [SKY]We're processing your Membership Cancelation. \nCheck back in a few minutes.", engine.var_axy_b.a(), Color.WHITE, engine.var_axy_b.a(), Color.BLACK, 1110.0f, 550.0f, 1, 1.0f);
            } else if (ay.ay_a().gd_a().boolean_d()) {
                engine.a("You have an active Membership.\nUnsubscribe any time by clicking this button.", engine.var_axy_b.a(), Color.WHITE, engine.var_axy_b.a(), Color.BLACK, 1110.0f, 550.0f, 1, 1.0f);
                this.var_ayf_a.a(f2, engine);
                this.var_ayf_a.b(f2, engine);
            } else if (ay.ay_a().gd_a().boolean_c()) {
                engine.a("[RED]Your Membership is canceled.[]\n[WHITE]Your benefits will remain until the current billing cycle ends.\nSubscribe above to get benefits again!", engine.var_axy_b.a(), Color.WHITE, engine.var_axy_b.a(), Color.BLACK, 1110.0f, 530.0f, 1, 1.0f);
            }
        }
    }

    public void h() {
        this.b();
    }

    public void i() {
        this.c();
    }

    public void d(float f2, Engine engine) {
        if (this.var_fx_a != false) {
            this.var_fx_a.a(810, 790);
            this.var_fx_a.a(f2, engine);
            this.var_fx_a.b(f2, engine);
            this.var_fx_a.c(f2, engine);
            if (!ay.ay_a().gd_a().bu_a().boolean_a()) {
                this.var_fx_b.a(1085, 790);
                this.var_fx_b.a(f2, engine);
                this.var_fx_b.b(f2, engine);
                this.var_fx_b.c(f2, engine);
                this.var_fx_c.a(1360, 790);
                this.var_fx_c.a(f2, engine);
                this.var_fx_c.b(f2, engine);
                this.var_fx_c.c(f2, engine);
            }
            if (this.var_fx_a.boolean_a()) {
                this.var_ayh_c.a(f2, engine.var_azi_a, 590, 758, 1.0f);
                this.d.a(f2, engine.var_azi_a, 590, 737, 1.0f);
                this.e.a(f2, engine.var_azi_a, 590, 715, 1.0f);
                this.f.a(f2, engine.var_azi_a, 590, 688, 1.0f);
                this.g.a(f2, engine.var_azi_a, 590, 668, 1.0f);
                this.h.a(f2, engine.var_azi_a, 590, 641, 1.0f);
            }
            if (this.var_fx_b.boolean_a() && !ay.ay_a().gd_a().bu_a().boolean_a()) {
                this.var_ayh_c.a(f2, engine.var_azi_a, 865, 758, 1.0f);
                this.d.a(f2, engine.var_azi_a, 865, 737, 1.0f);
                this.e.a(f2, engine.var_azi_a, 865, 715, 1.0f);
                this.f.a(f2, engine.var_azi_a, 865, 688, 1.0f);
                this.g.a(f2, engine.var_azi_a, 865, 668, 1.0f);
                this.h.a(f2, engine.var_azi_a, 865, 641, 1.0f);
            }
            if (this.var_fx_c.boolean_a() && !ay.ay_a().gd_a().bu_a().boolean_a()) {
                this.var_ayh_c.a(f2, engine.var_azi_a, 1140, 758, 1.0f);
                this.d.a(f2, engine.var_azi_a, 1140, 737, 1.0f);
                this.e.a(f2, engine.var_azi_a, 1140, 715, 1.0f);
                this.f.a(f2, engine.var_azi_a, 1140, 688, 1.0f);
                this.g.a(f2, engine.var_azi_a, 1140, 668, 1.0f);
                this.h.a(f2, engine.var_azi_a, 1140, 641, 1.0f);
            }
            this.var_da_a.a(f2, engine);
            this.var_da_a.a(f2, engine, 674, 675);
            if (!ay.ay_a().gd_a().bu_a().boolean_a()) {
                this.var_da_a.a(f2, engine, 950, 675);
                this.var_da_a.a(f2, engine, 1226, 675);
            }
        }
    }

    static /* synthetic */ Engine com_arenaofkings_client_core_Engine_a(abz abz2) {
        return abz2.var_fx_a;
    }

    static /* synthetic */ Engine com_arenaofkings_client_core_Engine_b(abz abz2) {
        return abz2.var_fx_a;
    }

    static /* synthetic */ Engine c(abz abz2) {
        return abz2.var_fx_a;
    }

    static /* synthetic */ Dialog a(abz abz2, Dialog dialog) {
        abz2.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a = dialog;
        return abz2.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a;
    }

    static /* synthetic */ Engine d(abz abz2) {
        return abz2.var_fx_a;
    }

    static /* synthetic */ Engine e(abz abz2) {
        return abz2.var_fx_a;
    }

    static /* synthetic */ Engine f(abz abz2) {
        return abz2.var_fx_a;
    }

    static /* synthetic */ Engine g(abz abz2) {
        return abz2.var_fx_a;
    }

    static /* synthetic */ Engine h(abz abz2) {
        return abz2.var_fx_a;
    }

    static /* synthetic */ Engine i(abz abz2) {
        return abz2.var_fx_a;
    }

    static /* synthetic */ Dialog com_badlogic_gdx_scenes_scene2d_ui_Dialog_a(abz abz2) {
        return abz2.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a;
    }

    static /* synthetic */ Stage com_badlogic_gdx_scenes_scene2d_Stage_a(abz abz2) {
        return abz2.var_fx_a;
    }

    static /* synthetic */ Engine j(abz abz2) {
        return abz2.var_fx_a;
    }

    static /* synthetic */ Stage com_badlogic_gdx_scenes_scene2d_Stage_b(abz abz2) {
        return abz2.var_fx_a;
    }

    static /* synthetic */ Engine k(abz abz2) {
        return abz2.var_fx_a;
    }

    static /* synthetic */ Engine l(abz abz2) {
        return abz2.var_fx_a;
    }

    static /* synthetic */ Engine m(abz abz2) {
        return abz2.var_fx_a;
    }
}

