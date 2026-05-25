/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.loginserver.PUB_LOGIN_CREATE_ACCOUNT_REQUEST;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;

public class up
extends aya {
    private TextField var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a;
    private TextField var_com_badlogic_gdx_scenes_scene2d_ui_TextField_b;
    private TextField var_com_badlogic_gdx_scenes_scene2d_ui_TextField_c;
    private TextField var_com_badlogic_gdx_scenes_scene2d_ui_TextField_d;
    private TextField var_com_badlogic_gdx_scenes_scene2d_ui_TextField_e;
    private ayj var_ayj_a;
    private ayj var_ayj_b;
    private ayj var_ayj_c;
    private ayj var_ayj_d;
    private da var_da_a;
    protected ayh var_ayh_a;
    protected ayc var_ayc_a;
    protected ayf var_ayf_a;
    private boolean var_boolean_a;
    private ayg var_ayg_a;
    private ayg var_ayg_b;
    private ayg var_ayg_c;
    private ayg var_ayg_d;
    private CheckBox var_com_badlogic_gdx_scenes_scene2d_ui_CheckBox_a;
    private CheckBox var_com_badlogic_gdx_scenes_scene2d_ui_CheckBox_b;
    protected ayf var_ayf_b;
    protected ayf var_ayf_c;
    protected ayf var_ayf_d;
    protected ayf var_ayf_e;
    protected ayf f;
    protected ayf g;
    protected Dialog var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a = null;
    private azv var_azv_a = new azv(5000L, true);

    public up(axm axm2, Engine engine) {
        super(axm2, engine);
    }

    @Override
    public void void_a() {
        this.a((Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a));
        this.e();
        this.f();
    }

    private void a(Engine engine) {
        this.var_da_a = new da(ajw.jx, "Snow", 30, 0.02f, 0.0f, Animation.PlayMode.LOOP, 0, 0);
        this.var_da_a.a(((axm)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.jx));
        this.var_ayj_a = new ayj(engine, 1175, 390, "The name you will use to login\n\nPlayers will interact with your [RARITY_LEGENDARY]Username[] and your (soon to be created) [RARITY_LEGENDARY]Character Names[]\n\nExample [RARITY_LEGENDARY]Usernames[]:\n[GREEN]arenaofkingsTWTV[]\n[GREEN]Bob[]\n[GREEN]360noscope[]\n\n[RED]3 Characters minimum[]\n[RED]No spaces[]\n[GREEN]Letters and Numbers only[]", true);
        this.var_ayj_a.d(250);
        this.var_ayj_b = new ayj(engine, 1175, 400, "[DIGICERT]Passwords[] are [DIGICERT]encrypted[] and [DIGICERT]salted[] with industry leading [DIGICERT]hashing algorithms[]. All network traffic is encrypted and sent through [DIGICERT]SSL[].\n\nFor your safety, choose a never-before-used password that is hard to guess\n\n[RED]8 Characters minimum[]", true);
        this.var_ayj_b.d(250);
        this.var_ayj_c = new ayj(engine, 1175, 350, "A valid [RARITY_LEGENDARY]Email[] is critical for [RARITY_LEGENDARY]Account Recovery[].\n\nWe will [RED]never[] spam you (even if you opt in to receiving awesome [RARITY_LEGENDARY]News Updates[])!\n\n[GRAY]Some EU keyboards won't type @.\nSet keyboard to US or copy+paste it in![]", true);
        this.var_ayj_c.d(250);
        this.var_ayj_d = new ayj(engine, 1175, 300, "Arena of Kings is a [RARITY_UNCOMMON]team game[] and is [RARITY_UNCOMMON]1000% more fun[] when [RARITY_LEGENDARY]theorycrafting[], [RARITY_LEGENDARY]strategizing[], and [RARITY_LEGENDARY]coordinating[] with [RARITY_UNCOMMON]friends[]!\n\nCarefully enter the [RARITY_LEGENDARY]Username[] of a friend to link your accounts (if you have a group of 3, use each [RARITY_LEGENDARY]Username[] once for a chain-link RAF).\n\nEx: if your friend logs in with [RARITY_LEGENDARY]Username[] [GREEN]Bob[]\n you'd enter [GREEN]Bob[] here. Easy!\n\nWhile partied, you and your friend will permanently have the following bonuses automatically:\n[RARITY_UNCOMMON]+10% Experience Boost[]\n[RARITY_UNCOMMON]+10% Ability Essence generated[]\n[RARITY_UNCOMMON]+10% Silver from Bounties![]\n", true);
        this.var_ayj_d.d(250);
        this.var_ayh_a = new ayh(770, 137, ((axm)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.var_ajw_a), "register_main_frame", true);
        this.var_ayc_a = new uq(this, 877, 185, ((axm)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.var_ajw_a), "register_button_default", "register_button_hovered", "register_button_grayed", true, engine);
        this.var_ayf_a = new uy(this, 827, 636, ((axm)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.var_ajw_a), "undo_hovered", "undo_default", true, engine);
        this.var_ayf_b = new uz(this, 1565, 17, ((axm)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.var_ajw_a), "gamepedia_logo_default", "gamepedia_logo_hovered", true);
        this.var_ayf_c = new va(this, 170, 270, ((axm)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.var_ajw_a), "discord_button_default", "discord_button_hovered", true);
        this.var_ayf_d = new vb(this, 1675, 17, ((axm)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.var_ajw_a), "facebook_button_default", "facebook_button_hovered", true);
        this.var_ayf_e = new vc(this, 240, 270, ((axm)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.var_ajw_a), "twitter_button_default", "twitter_button_hovered", true);
        this.f = new vd(this, 1785, 17, ((axm)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.var_ajw_a), "instagram_button_default", "instagram_button_hovered", true);
        this.g = new ve(this, 310, 270, ((axm)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.var_ajw_a), "youtube_button_default", "youtube_button_hovered", true);
    }

    private void e() {
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a = new TextField("", ((Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).var_com_badlogic_gdx_scenes_scene2d_ui_Skin_a);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.setPosition(832.0f, 583.0f);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.setSize(280.0f, 20.0f);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.setMaxLength(15);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.setFocusTraversal(false);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.setColor(235.0f, 0.0f, 0.0f, 1.0f);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.setBlinkTime(0.2f);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.setAlignment(8);
        ((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).setKeyboardFocus(this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_b = new TextField("", ((Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).var_com_badlogic_gdx_scenes_scene2d_ui_Skin_a);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_b.setPosition(832.0f, 520.0f);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_b.setSize(280.0f, 20.0f);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_b.setMaxLength(20);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_b.setPasswordMode(true);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_b.setPasswordCharacter('*');
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_b.setFocusTraversal(false);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_b.setColor(235.0f, 0.0f, 0.0f, 1.0f);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_b.setBlinkTime(0.2f);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_b.setAlignment(8);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_c = new TextField("", ((Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).var_com_badlogic_gdx_scenes_scene2d_ui_Skin_a);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_c.setPosition(832.0f, 457.0f);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_c.setSize(280.0f, 20.0f);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_c.setMaxLength(20);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_c.setPasswordMode(true);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_c.setPasswordCharacter('*');
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_c.setFocusTraversal(false);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_c.setColor(235.0f, 0.0f, 0.0f, 1.0f);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_c.setBlinkTime(0.2f);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_c.setAlignment(8);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_d = new TextField("", ((Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).var_com_badlogic_gdx_scenes_scene2d_ui_Skin_a);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_d.setPosition(832.0f, 394.0f);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_d.setSize(280.0f, 20.0f);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_d.setMaxLength(100);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_d.setFocusTraversal(false);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_d.setColor(235.0f, 0.0f, 0.0f, 1.0f);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_d.setBlinkTime(0.2f);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_d.setAlignment(8);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_e = new TextField("", ((Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).var_com_badlogic_gdx_scenes_scene2d_ui_Skin_a);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_e.setPosition(832.0f, 332.0f);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_e.setSize(280.0f, 20.0f);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_e.setMaxLength(16);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_e.setFocusTraversal(false);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_e.setColor(235.0f, 0.0f, 0.0f, 1.0f);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_e.setBlinkTime(0.2f);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_e.setAlignment(8);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_CheckBox_a = new CheckBox("", ((Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).var_com_badlogic_gdx_scenes_scene2d_ui_Skin_a);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_CheckBox_a.addListener(new vf(this));
        this.var_com_badlogic_gdx_scenes_scene2d_ui_CheckBox_a.setPosition(856.0f, 284.0f);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_CheckBox_a.setTransform(true);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_CheckBox_a.setScale(1.5f);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_CheckBox_a.setChecked(false);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_CheckBox_b = new CheckBox("", ((Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).var_com_badlogic_gdx_scenes_scene2d_ui_Skin_a);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_CheckBox_b.addListener(new ur(this));
        this.var_com_badlogic_gdx_scenes_scene2d_ui_CheckBox_b.setPosition(856.0f, 243.0f);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_CheckBox_b.setTransform(true);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_CheckBox_b.setScale(1.5f);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_CheckBox_b.setChecked(false);
    }

    private void f() {
        ((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).addActor(this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a);
        ((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).addActor(this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_b);
        ((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).addActor(this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_c);
        ((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).addActor(this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_d);
        ((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).addActor(this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_e);
        ((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).addActor(this.var_com_badlogic_gdx_scenes_scene2d_ui_CheckBox_a);
        ((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).addActor(this.var_com_badlogic_gdx_scenes_scene2d_ui_CheckBox_b);
    }

    public void a(float f2) {
        this.h();
        this.g();
        this.var_ayg_a.b((Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a));
        this.var_ayg_b.b((Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a));
        this.var_ayg_c.b((Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a));
        this.var_ayg_d.b((Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a));
    }

    private void g() {
        if (Gdx.input.isKeyJustPressed(61)) {
            if (((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).getKeyboardFocus() != this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a && ((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).getKeyboardFocus() != this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_b && ((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).getKeyboardFocus() != this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_c && ((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).getKeyboardFocus() != this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_e && ((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).getKeyboardFocus() != this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_d) {
                ((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).setKeyboardFocus(this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a);
            } else if (((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).getKeyboardFocus() == this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a) {
                ((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).setKeyboardFocus(this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_b);
            } else if (((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).getKeyboardFocus() == this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_b) {
                ((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).setKeyboardFocus(this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_c);
            } else if (((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).getKeyboardFocus() == this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_c) {
                ((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).setKeyboardFocus(this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_d);
            } else if (((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).getKeyboardFocus() == this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_d) {
                ((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).setKeyboardFocus(this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_e);
            } else if (((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).getKeyboardFocus() == this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_e) {
                ((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).setKeyboardFocus(this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a);
            }
            ((Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).var_baa_a.a(ajw.kC, 1.0f);
        }
        if (Gdx.input.isKeyJustPressed(66)) {
            this.var_ayc_a.void_a();
        }
        this.var_ayg_c = new us(this, 770, 30, 894, 55);
        this.var_ayg_d = new ut(this, 1373, 30, 1418, 55);
        this.var_ayg_a = new uu(this, 936, 289, 1052, 304);
        this.var_ayg_b = new uv(this, 1009, 305, 1135, 323);
    }

    private void h() {
        if (this.var_boolean_a && ((Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).var_z_a.boolean_b() && ((Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).var_z_a.boolean_c()) {
            PUB_LOGIN_CREATE_ACCOUNT_REQUEST pUB_LOGIN_CREATE_ACCOUNT_REQUEST = new PUB_LOGIN_CREATE_ACCOUNT_REQUEST(this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.getText(), this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_b.getText(), "OPEN BETA", this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_e.getText(), this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_d.getText(), this.var_com_badlogic_gdx_scenes_scene2d_ui_CheckBox_b.isChecked(), "");
            ((Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).var_z_a.void_a(pUB_LOGIN_CREATE_ACCOUNT_REQUEST);
            this.var_boolean_a = false;
        }
    }

    @Override
    public void a(float f2, azi azi2) {
        this.a(f2);
        ((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).act(f2);
        ((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).draw();
        if (((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).getKeyboardFocus() == this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a) {
            azi2.begin();
            this.var_ayj_a.b(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a));
            azi2.end();
        } else if (((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).getKeyboardFocus() == this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_b || ((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).getKeyboardFocus() == this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_c) {
            azi2.begin();
            this.var_ayj_b.b(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a));
            azi2.end();
        } else if (((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).getKeyboardFocus() == this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_d) {
            azi2.begin();
            this.var_ayj_c.b(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a));
            azi2.end();
        } else if (((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).getKeyboardFocus() == this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_e) {
            azi2.begin();
            this.var_ayj_d.b(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a));
            azi2.end();
        }
        azi2.begin();
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a));
        this.var_da_a.com_badlogic_gdx_graphics_Color_a().a = 0.2f;
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), -70, 0);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), -70, 200);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), -70, 400);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), -70, 600);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), -70, 800);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), -70, 1000);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), -70, 1200);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), 284, 0);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), 284, 200);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), 284, 400);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), 284, 600);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), 284, 800);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), 284, 1000);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), 284, 1200);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), 449, 0);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), 449, 200);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), 449, 400);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), 449, 600);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), 449, 800);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), 449, 1000);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), 449, 1200);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), 803, -30);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), 803, 170);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), 803, 690);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), 803, 890);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), 803, 1090);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), 803, 1290);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), 1157, 0);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), 1157, 200);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), 1157, 400);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), 1157, 600);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), 1157, 800);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), 1157, 1000);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), 1157, 1200);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), 1511, 0);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), 1511, 200);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), 1511, 400);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), 1511, 600);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), 1511, 800);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), 1511, 1000);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), 1511, 1200);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), 1865, 0);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), 1865, 200);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), 1865, 400);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), 1865, 600);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), 1865, 800);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), 1865, 1000);
        this.var_da_a.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a), 1865, 1200);
        this.var_ayf_c.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a));
        this.var_ayf_c.b(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a));
        this.var_ayf_e.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a));
        this.var_ayf_e.b(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a));
        this.g.a(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a));
        this.g.b(f2, (Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a));
        azi2.end();
    }

    @Override
    public void void_b() {
        super.void_b();
    }

    public void void_c() {
        Label.LabelStyle labelStyle = new Label.LabelStyle(((Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).j, Color.WHITE);
        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = ((Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).l;
        textButtonStyle.fontColor = axe.K;
        this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a = new uw(this, "", ((Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).var_com_badlogic_gdx_scenes_scene2d_ui_Skin_a, labelStyle);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a.align(1);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a.setBounds(750.0f, 450.0f, 450.0f, 205.0f);
        if (!((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).getActors().contains(this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a, true)) {
            ((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).addActor(this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a);
            Engine.b("added dialog");
        } else {
            Engine.b("didn't add dialog");
        }
    }

    public void d() {
        Label.LabelStyle labelStyle = new Label.LabelStyle(((Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).j, Color.WHITE);
        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = ((Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).l;
        textButtonStyle.fontColor = axe.K;
        this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a = new ux(this, "", ((Engine)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).var_com_badlogic_gdx_scenes_scene2d_ui_Skin_a, labelStyle);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a.align(1);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a.setBounds(750.0f, 450.0f, 450.0f, 205.0f);
        if (!((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).getActors().contains(this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a, true)) {
            ((Stage)((Object)this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a)).addActor(this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a);
            Engine.b("added dialog");
        } else {
            Engine.b("didn't add dialog");
        }
    }

    static /* synthetic */ TextField com_badlogic_gdx_scenes_scene2d_ui_TextField_a(up up2) {
        return up2.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a;
    }

    static /* synthetic */ TextField com_badlogic_gdx_scenes_scene2d_ui_TextField_b(up up2) {
        return up2.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_b;
    }

    static /* synthetic */ TextField c(up up2) {
        return up2.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_c;
    }

    static /* synthetic */ TextField d(up up2) {
        return up2.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_d;
    }

    static /* synthetic */ CheckBox com_badlogic_gdx_scenes_scene2d_ui_CheckBox_a(up up2) {
        return up2.var_com_badlogic_gdx_scenes_scene2d_ui_CheckBox_a;
    }

    static /* synthetic */ azv azv_a(up up2) {
        return up2.var_azv_a;
    }

    static /* synthetic */ boolean a(up up2, boolean bl2) {
        up2.var_boolean_a = bl2;
        return up2.var_boolean_a;
    }

    static /* synthetic */ CheckBox com_badlogic_gdx_scenes_scene2d_ui_CheckBox_b(up up2) {
        return up2.var_com_badlogic_gdx_scenes_scene2d_ui_CheckBox_b;
    }
}

