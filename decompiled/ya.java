/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Array;

public class ya
extends yf {
    private final Engine var_com_arenaofkings_client_core_Engine_a;
    private azp var_azp_a;
    private azq var_azq_a;
    private ayo var_ayo_a;
    private aze var_aze_a;
    private azh var_azh_a;
    private SelectBox<ej> var_com_badlogic_gdx_scenes_scene2d_ui_SelectBox_ej__a;
    private boolean var_boolean_a = false;
    private boolean b = false;
    private ayf var_ayf_a;
    private Dialog var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a;

    public ya(Engine engine, axm axm2) {
        super(394, 380, axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c), "character_panel");
        this.var_com_arenaofkings_client_core_Engine_a = engine;
        TextureAtlas textureAtlas = axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c);
        Engine.a("cp 1");
        this.var_ayo_a = new ayo(engine, axm2, "mtx_outfits", "mtx_scrollbar", "scrollknob", 408, 757);
        Engine.a("cp 2");
        this.var_aze_a = new aze(engine, axm2, "mtx_backgrounds", "mtx_scrollbar", "scrollknob", 408, 577);
        Engine.a("cp 3");
        this.var_azh_a = new azh(engine, axm2, "mtx_effects", "mtx_scrollbar", "scrollknob", 408, 392);
        Engine.a("cp 4");
        engine.var_hg_a.b();
        this.var_azq_a = new azq(engine, axm2, "spell_book", "spell_book_scrollbar", "scrollknob", 1123, 502);
        Engine.a("cp 5");
        this.var_azp_a = new azp(axm2);
        this.var_ayf_a = new yb(this, 1034, 406, textureAtlas, "delete_button_default", "delete_button_hovered", true);
        Array<ej> array = new Array<ej>();
        for (ej ej2 : ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getCharacterEntities()) {
            Engine.a("character ordinal: " + ej2.int_h() + " " + ej2.java_lang_String_a());
            array.add(ej2);
        }
        this.var_com_arenaofkings_client_core_Engine_a = new SelectBox(engine.var_com_badlogic_gdx_scenes_scene2d_ui_Skin_a);
        ((SelectBox)((Object)this.var_com_arenaofkings_client_core_Engine_a)).setItems(array);
        if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity() != null) {
            ((SelectBox)((Object)this.var_com_arenaofkings_client_core_Engine_a)).setSelected(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity());
        }
        ((SelectBox)((Object)this.var_com_arenaofkings_client_core_Engine_a)).setAlignment(1);
        ((SelectBox)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getList().setAlignment(1);
        ((Actor)((Object)this.var_com_arenaofkings_client_core_Engine_a)).setWidth(230.0f);
        ((Actor)((Object)this.var_com_arenaofkings_client_core_Engine_a)).setColor(1.0f, 1.0f, 1.0f, 0.6f);
        ((SelectBox)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getStyle().fontColor = Color.GREEN;
        ((Actor)((Object)this.var_com_arenaofkings_client_core_Engine_a)).addCaptureListener(new yc(this));
        ((Actor)((Object)this.var_com_arenaofkings_client_core_Engine_a)).addListener(new yd(this, engine));
        ((Actor)((Object)this.var_com_arenaofkings_client_core_Engine_a)).setPosition(840.0f, 893.0f);
    }

    public void void_a() {
        if (this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a != null) {
            this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a.remove();
        }
    }

    private void void_b() {
        Label.LabelStyle labelStyle = new Label.LabelStyle(this.var_com_arenaofkings_client_core_Engine_a.j, Color.WHITE);
        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = this.var_com_arenaofkings_client_core_Engine_a.l;
        textButtonStyle.fontColor = axe.K;
        this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a = new ye(this, "", this.var_com_arenaofkings_client_core_Engine_a.var_com_badlogic_gdx_scenes_scene2d_ui_Skin_a, labelStyle);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a.align(1);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a.setBounds(750.0f, 450.0f, 450.0f, 205.0f);
        if (!this.var_com_arenaofkings_client_core_Engine_a.axc_a().aya_a().com_badlogic_gdx_scenes_scene2d_Stage_c().getActors().contains(this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a, true)) {
            this.var_com_arenaofkings_client_core_Engine_a.axc_a().aya_a().com_badlogic_gdx_scenes_scene2d_Stage_c().addActor(this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a);
        }
    }

    public void a(boolean bl2) {
        if (((SelectBox)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getItems().size == 1) {
            return;
        }
        if (bl2) {
            if (((SelectBox)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getSelectedIndex() + 1 >= ((SelectBox)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getItems().size) {
                ((SelectBox)((Object)this.var_com_arenaofkings_client_core_Engine_a)).setSelectedIndex(0);
            } else {
                ((SelectBox)((Object)this.var_com_arenaofkings_client_core_Engine_a)).setSelectedIndex(((SelectBox)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getSelectedIndex() + 1);
            }
        } else if (((SelectBox)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getSelectedIndex() - 1 < 0) {
            ((SelectBox)((Object)this.var_com_arenaofkings_client_core_Engine_a)).setSelectedIndex(((SelectBox)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getItems().size - 1);
        } else {
            ((SelectBox)((Object)this.var_com_arenaofkings_client_core_Engine_a)).setSelectedIndex(((SelectBox)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getSelectedIndex() - 1);
        }
    }

    public boolean boolean_a() {
        boolean bl2 = this.var_com_arenaofkings_client_core_Engine_a.axc_a().aya_a().com_badlogic_gdx_scenes_scene2d_Stage_c().getKeyboardFocus() == this.var_com_arenaofkings_client_core_Engine_a || this.var_com_arenaofkings_client_core_Engine_a.axc_a().aya_a().com_badlogic_gdx_scenes_scene2d_Stage_c().getScrollFocus() == this.var_com_arenaofkings_client_core_Engine_a;
        Engine.a("returning cond: " + bl2);
        return bl2;
    }

    @Override
    public void a(float f2, Engine engine) {
        this.var_boolean_a = false;
    }

    @Override
    public void b(float f2, Engine engine) {
        this.a(f2, engine);
        if (((ayh)((Object)this.var_com_arenaofkings_client_core_Engine_a)).boolean_b()) {
            super.b(f2, engine);
            if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bd_a() != null) {
                ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bd_a().b(f2, engine);
            }
            this.var_aze_a.b(f2, engine);
            this.var_azh_a.b(f2, engine);
            this.var_ayo_a.b(f2, engine);
            if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getCharacterEntities().size() >= ay.ay_a().gd_a().h()) {
                engine.a("Character Slots used (" + ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getCharacterEntities().size() + "/" + ay.ay_a().gd_a().h() + ")", engine.var_axy_b.a(), Color.RED, engine.var_axy_b.a(), Color.BLACK, 954.0f, 475.0f, 1, 1);
            } else {
                engine.a("Character Slots used (" + ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getCharacterEntities().size() + "/" + ay.ay_a().gd_a().h() + ")", engine.var_axy_b.a(), Color.GREEN, engine.var_axy_b.a(), Color.BLACK, 954.0f, 475.0f, 1, 1);
            }
            this.var_ayf_a.a(f2, engine);
            this.var_ayf_a.b(f2, engine);
        }
    }

    public void c(float f2, Engine engine) {
        if (((ayh)((Object)this.var_com_arenaofkings_client_core_Engine_a)).boolean_b() && !ay.ay_a().gd_a().bu_a().boolean_a()) {
            this.var_azq_a.b(f2, engine);
            this.var_azp_a.b(f2, engine);
        }
    }

    @Override
    public void a(Stage stage) {
        super.a(stage);
        stage.addActor((Actor)((Object)this.var_com_arenaofkings_client_core_Engine_a));
        this.var_azp_a.a(true);
        ((ayh)((Object)this.var_ayo_a.var_aym_a)).a(true);
        this.var_ayo_a.b.a(true);
        this.var_ayo_a.c.a(true);
        ((ayh)((Object)this.var_aze_a.var_azc_a)).a(true);
        this.var_aze_a.b.a(true);
        this.var_aze_a.c.a(true);
        ((ayh)((Object)this.var_azh_a.a)).a(true);
        this.var_azh_a.b.a(true);
        this.var_azh_a.c.a(true);
        ((ayh)((Object)this.var_azq_a.a)).a(true);
        this.var_azq_a.b.a(true);
        this.var_azq_a.c.a(true);
        ay.ay_a().gd_a().as_a().void_a();
    }

    @Override
    public void b(Stage stage) {
        super.b(stage);
        this.var_azp_a.a(false);
        stage.getRoot().removeActor((Actor)((Object)this.var_com_arenaofkings_client_core_Engine_a));
        ((ayh)((Object)this.var_ayo_a.var_aym_a)).a(false);
        this.var_ayo_a.b.a(false);
        this.var_ayo_a.c.a(false);
        ((ayh)((Object)this.var_aze_a.var_azc_a)).a(false);
        this.var_aze_a.b.a(false);
        this.var_aze_a.c.a(false);
        ((ayh)((Object)this.var_azh_a.a)).a(false);
        this.var_azh_a.b.a(false);
        this.var_azh_a.c.a(false);
        ((ayh)((Object)this.var_azq_a.a)).a(false);
        this.var_azq_a.b.a(false);
        this.var_azq_a.c.a(false);
    }

    public azq azq_a() {
        return this.var_azq_a;
    }

    public ayo ayo_a() {
        return this.var_ayo_a;
    }

    public azp azp_a() {
        return this.var_azp_a;
    }

    public aze aze_a() {
        return this.var_aze_a;
    }

    public azh azh_a() {
        return this.var_azh_a;
    }

    static /* synthetic */ void void_a(ya ya2) {
        ya2.void_b();
    }

    static /* synthetic */ SelectBox com_badlogic_gdx_scenes_scene2d_ui_SelectBox_a(ya ya2) {
        return ya2.var_com_arenaofkings_client_core_Engine_a;
    }

    static /* synthetic */ boolean boolean_a(ya ya2) {
        return ya2.var_boolean_a;
    }

    static /* synthetic */ boolean a(ya ya2, boolean bl2) {
        ya2.var_boolean_a = bl2;
        return ya2.var_boolean_a;
    }

    static /* synthetic */ Engine com_arenaofkings_client_core_Engine_a(ya ya2) {
        return ya2.var_com_arenaofkings_client_core_Engine_a;
    }
}

