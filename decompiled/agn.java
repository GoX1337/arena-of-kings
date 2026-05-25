/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class agn
extends aya {
    protected agt var_agt_a;
    protected ahn var_ahn_a;
    protected i var_i_a;
    public ayh var_ayh_a;
    public ayh b;
    public ayh c;
    public ayh d;
    public Dialog var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a;
    private fm var_fm_a;

    public agn(axm axm2, Engine engine) {
        super(axm2, engine);
    }

    @Override
    public void void_a() {
        this.e();
        this.d();
        this.f();
    }

    private void d() {
        Engine.a("load chat in");
        this.var_i_a = new i((Engine)((Object)this.var_agt_a), (axm)((Object)this.var_agt_a), ((Engine)((Object)this.var_agt_a)).var_com_badlogic_gdx_scenes_scene2d_ui_Skin_a, 100, (Stage)((Object)this.var_agt_a), 370, 40, 499, 350);
        this.var_i_a.m();
        Engine.a("load chat out");
    }

    private void e() {
        Engine.a("loadImages() in");
        this.var_agt_a = new agt((Engine)((Object)this.var_agt_a), ((axm)((Object)this.var_agt_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.e), ((axm)((Object)this.var_agt_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.jd), ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_misc_CharacterClass_a());
        this.var_ahn_a = new ahn(((axm)((Object)this.var_agt_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.e));
        ay.ay_a().gd_a().ev_a().a(((axm)((Object)this.var_agt_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.e));
        ay.ay_a().gd_a().axz_a().a(((axm)((Object)this.var_agt_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.e), "social_backdrop", "social_scrollbar", "scrollknob", 1553, 400);
        ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bd_a().c((axm)((Object)this.var_agt_a), true);
        ay.ay_a().gd_a().as_a().a((axm)((Object)this.var_agt_a));
        this.c = new ayh(((axm)((Object)this.var_agt_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.e).createSprite("top_bar_empty_globe"));
        this.c.com_badlogic_gdx_graphics_g2d_Sprite_a().scale(-0.5f);
        this.d = new ayh(((axm)((Object)this.var_agt_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.e).createSprite("top_bar_enemy_globe"));
        this.d.com_badlogic_gdx_graphics_g2d_Sprite_a().scale(-0.5f);
        this.var_ayh_a = new ayh(((axm)((Object)this.var_agt_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.e).createSprite("friendly_reticle"));
        this.b = new ayh(((axm)((Object)this.var_agt_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.e).createSprite("enemy_reticle"));
        Engine.a("loadImages() out");
    }

    public void void_c() {
        System.out.println("ct 4");
        if (((Stage)((Object)this.var_agt_a)).getActors().contains(this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a, true)) {
            this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a.remove();
            return;
        }
        System.out.println("ct 5");
        Label.LabelStyle labelStyle = new Label.LabelStyle(((Engine)((Object)this.var_agt_a)).j, Color.WHITE);
        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = ((Engine)((Object)this.var_agt_a)).l;
        textButtonStyle.fontColor = axe.K;
        this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a = new ago(this, "", ((Engine)((Object)this.var_agt_a)).var_com_badlogic_gdx_scenes_scene2d_ui_Skin_a, labelStyle);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a.align(1);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a.setBounds(798.0f, 450.0f, 325.0f, 150.0f);
        System.out.println("ct 6");
        if (!((Stage)((Object)this.var_agt_a)).getActors().contains(this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a, true)) {
            System.out.println("ct 7");
            ((Stage)((Object)this.var_agt_a)).addActor(this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a);
        }
    }

    private void f() {
        Engine.a("loadStage() in");
        ((Stage)((Object)this.var_agt_a)).addActor(this.var_i_a.axh_a());
        Engine.a("loadStage() out");
    }

    public void a(float f2) {
        ((Stage)((Object)this.var_agt_a)).act(f2);
        if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bd_a().da_a() != null) {
            ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bd_a().da_a().a(false);
        }
        if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bd_a().da_b() != null) {
            ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bd_a().da_b().a(false);
        }
        if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bd_a().da_c() != null) {
            ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bd_a().da_c().a(false);
        }
    }

    @Override
    public void a(float f2, azi azi2) {
        this.var_i_a.b(f2, (Engine)((Object)this.var_agt_a));
        if (this.var_fm_a != null) {
            if (!this.var_fm_a.boolean_c()) {
                this.var_fm_a.a((axm)((Object)this.var_agt_a), true);
            }
            if (this.var_fm_a.boolean_c()) {
                this.var_fm_a.a((Engine)((Object)this.var_agt_a), 450, 500, 0, false, true);
            }
        }
        ((Engine)((Object)this.var_agt_a)).var_azi_a.end();
        this.a(f2);
        ((Stage)((Object)this.var_agt_a)).draw();
    }

    public i i_a() {
        return this.var_i_a;
    }

    public agt agt_a() {
        return this.var_agt_a;
    }

    @Override
    public void void_b() {
        super.void_b();
    }

    public ayh ayh_a() {
        return this.c;
    }

    public ayh ayh_b() {
        return this.d;
    }

    public fm fm_a() {
        return this.var_fm_a;
    }

    public void a(fm fm2) {
        this.var_fm_a = fm2;
        if (fm2 != null) {
            this.var_fm_a.a((Engine)((Object)this.var_agt_a), (axm)((Object)this.var_agt_a));
        }
    }
}

