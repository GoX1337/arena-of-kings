/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.utils.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class zu
extends zm {
    private ayh var_ayh_a = new ArrayList();
    private TextField var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a;
    private TextField var_com_badlogic_gdx_scenes_scene2d_ui_TextField_b;
    private SelectBox<String> var_com_badlogic_gdx_scenes_scene2d_ui_SelectBox_java_lang_String__a;
    private String var_java_lang_String_a;
    private ayh var_ayh_b;
    private ayh c;
    private ayh d;
    private int var_int_a = 0;
    private ayh e;
    private ayf var_ayf_a;
    private ayf var_ayf_b;
    private axj var_axj_a;
    private axj var_axj_b;
    private ayh f;
    private List<zo> var_java_util_List_zo__a;
    private boolean var_boolean_b = true;

    public zu(Engine engine, axm axm2, Stage stage) {
        super(engine, axm2, stage);
    }

    @Override
    public void void_a() {
        TextureAtlas textureAtlas = ((axm)((Object)this.var_ayh_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c);
        TextureAtlas textureAtlas2 = ((axm)((Object)this.var_ayh_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.jd);
        TextureAtlas textureAtlas3 = ((axm)((Object)this.var_ayh_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.je);
        TextureAtlas textureAtlas4 = ((axm)((Object)this.var_ayh_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.i);
        TextureAtlas textureAtlas5 = ((axm)((Object)this.var_ayh_a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.b);
        this.var_ayh_a = new ayh(1130, 390, textureAtlas, "team_charter", true);
        this.f = new ayh(500, 500, textureAtlas, "available_team_slot", true);
        this.c = new ayh(1173, 586, textureAtlas2, ao.var_ao_a.name(), true);
        this.var_ayh_a = new SelectBox(((Engine)((Object)this.var_ayh_a)).var_com_badlogic_gdx_scenes_scene2d_ui_Skin_a);
        Array<String> array = new Array<String>();
        for (zh zh2 : zh.values()) {
            array.add(zh2.a());
        }
        ((SelectBox)((Object)this.var_ayh_a)).setItems(array);
        if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity() != null) {
            ((SelectBox)((Object)this.var_ayh_a)).setSelected(zh.dL.a());
        }
        ((SelectBox)((Object)this.var_ayh_a)).setAlignment(1);
        ((SelectBox)((Object)this.var_ayh_a)).getList().setAlignment(1);
        ((Actor)((Object)this.var_ayh_a)).setWidth(230.0f);
        ((Actor)((Object)this.var_ayh_a)).setColor(235.0f, 0.0f, 0.0f, 1.0f);
        ((SelectBox)((Object)this.var_ayh_a)).getStyle().fontColor = Color.WHITE;
        ((Actor)((Object)this.var_ayh_a)).addCaptureListener(new zv(this));
        ((Actor)((Object)this.var_ayh_a)).addListener(new zw(this, textureAtlas3));
        ((Actor)((Object)this.var_ayh_a)).setPosition(1200.0f, 720.0f);
        this.var_java_lang_String_a = (String)((SelectBox)((Object)this.var_ayh_a)).getSelected();
        this.var_ayh_b = new ayh(1413, 598, textureAtlas3, (String)((SelectBox)((Object)this.var_ayh_a)).getSelected(), true);
        this.var_ayh_b.com_badlogic_gdx_graphics_g2d_Sprite_a().scale(-0.35f);
        this.d = new ayh(1163, 548, textureAtlas4, "base_banner", true);
        this.var_ayf_a = new zx(this, 1252, 668, textureAtlas, "switch_character_left_default", "switch_character_left_hovered", true, textureAtlas4);
        this.var_ayf_b = new zy(this, 1340, 668, textureAtlas, "switch_character_right_default", "switch_character_right_hovered", true, textureAtlas4);
        this.e = new ayh(1166, 550, textureAtlas4, this.a(this.var_int_a), true);
        this.var_axj_b = new axj((Engine)((Object)this.var_ayh_a), this, 1120, 450, textureAtlas5, textureAtlas, abi.af, true);
        this.var_axj_a = new axj((Engine)((Object)this.var_ayh_a), this, 1300, 450, textureAtlas5, textureAtlas, abi.ag, true);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a = new TextField("", ((Engine)((Object)this.var_ayh_a)).var_com_badlogic_gdx_scenes_scene2d_ui_Skin_a);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.setPosition(1165.0f, 795.0f);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.setSize(220.0f, 30.0f);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.setMaxLength(25);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.setFocusTraversal(false);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.setColor(235.0f, 0.0f, 0.0f, 1.0f);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.setBlinkTime(0.2f);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.setAlignment(8);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_b = new TextField("", ((Engine)((Object)this.var_ayh_a)).var_com_badlogic_gdx_scenes_scene2d_ui_Skin_a);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_b.setPosition(1410.0f, 795.0f);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_b.setSize(60.0f, 30.0f);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_b.setMaxLength(4);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_b.setFocusTraversal(false);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_b.setColor(235.0f, 0.0f, 0.0f, 1.0f);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_b.setBlinkTime(0.2f);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_b.setAlignment(1);
    }

    private void void_d() {
        Engine.b("cleaing loadTeamBanners 1");
        this.var_ayh_a.clear();
        Engine.b("cleaing loadTeamBanners 2");
        for (int i2 = 0; i2 < ay.ay_a().gd_a().a().size; ++i2) {
            Engine.b("cleaing loadTeamBanners 3");
            zg zg2 = ay.ay_a().gd_a().a().get(i2);
            Engine.b("cleaing loadTeamBanners 4 " + zg2.java_lang_String_a() + " " + zg2.java_lang_String_b());
            zo zo2 = new zo((Engine)((Object)this.var_ayh_a), (Stage)((Object)this.var_ayh_a), (axm)((Object)this.var_ayh_a), 755, 790 - i2 * 180, zg2.f(), zg2.java_lang_String_a(), zg2.java_lang_String_b(), zg2.int_a(), zg2.int_b(), zg2.java_lang_String_d(), zg2.java_lang_String_c(), "", zg2.int_e());
            Engine.b("cleaing loadTeamBanners 5");
            this.var_ayh_a.add(zo2);
            Engine.b("cleaing loadTeamBanners 6");
        }
        Engine.b("cleaing loadTeamBanners 7");
    }

    @Override
    public void a(float f2, Engine engine) {
    }

    @Override
    public void b(float f2, Engine engine) {
        if (this.var_ayh_a != false) {
            if (this.var_boolean_b) {
                this.void_d();
                this.var_boolean_b = false;
            }
            this.var_ayh_a.b(f2, engine);
            this.f.b(f2, engine, 755, 790);
            this.f.b(f2, engine, 755, 610);
            this.f.b(f2, engine, 755, 430);
            Iterator iterator = this.var_ayh_a.iterator();
            while (iterator.hasNext()) {
                zo zo2 = (zo)iterator.next();
                zo2.b(f2, engine);
            }
            this.var_ayf_a.a(f2, engine);
            this.var_ayf_a.b(f2, engine);
            this.var_ayf_b.a(f2, engine);
            this.var_ayf_b.b(f2, engine);
            this.e.b(f2, engine);
            this.d.b(f2, engine);
            this.c.b(f2, engine);
            this.var_ayh_b.b(f2, engine);
            if (engine.a(this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.getText(), engine.var_axy_c.a()) >= 223) {
                engine.a(this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.getText(), engine.var_axy_c.a(), Color.RED, engine.var_axy_c.a(), Color.BLACK, 1252.0f, 660.0f, 8, 1);
            } else {
                engine.a(this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.getText(), engine.var_axy_c.a(), Color.WHITE, engine.var_axy_c.a(), Color.BLACK, 1252.0f, 660.0f, 8, 1);
            }
            if (this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_b.getText().length() < 2) {
                engine.a("[" + this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_b.getText() + "]", engine.var_axy_c.a(), Color.RED, engine.var_axy_c.a(), Color.BLACK, 1252.0f, 640.0f, 8, 1);
            } else {
                engine.a("[" + this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_b.getText() + "]", engine.var_axy_c.a(), Color.WHITE, engine.var_axy_c.a(), Color.BLACK, 1252.0f, 640.0f, 8, 1);
            }
            engine.a("Rank: N/A", engine.var_axy_c.a(), Color.WHITE, engine.var_axy_c.a(), Color.BLACK, 1252.0f, 620.0f, 8, 1);
            engine.a("Points: 0", engine.var_axy_c.a(), Color.WHITE, engine.var_axy_c.a(), Color.BLACK, 1252.0f, 600.0f, 8, 1);
            this.var_axj_b.a(f2, engine);
            this.var_axj_b.b(f2, engine);
            this.var_axj_a.a(f2, engine);
            this.var_axj_a.b(f2, engine);
        }
    }

    @Override
    public void void_b() {
        this.var_ayh_a = (ayh)true;
        ((Stage)((Object)this.var_ayh_a)).addActor(this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a);
        ((Stage)((Object)this.var_ayh_a)).addActor(this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_b);
        ((Stage)((Object)this.var_ayh_a)).addActor((Actor)((Object)this.var_ayh_a));
    }

    @Override
    public void void_c() {
        this.var_ayh_a = (ayh)false;
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.remove();
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_b.remove();
        ((Actor)((Object)this.var_ayh_a)).remove();
    }

    public void a(boolean bl2) {
        this.var_boolean_b = bl2;
    }

    private String a(int n2) {
        if (n2 == -1) {
            this.var_int_a = 39;
        } else if (n2 == 40) {
            this.var_int_a = 0;
        }
        return "BB-" + this.var_int_a;
    }

    public String java_lang_String_a() {
        return this.var_java_lang_String_a;
    }

    public String java_lang_String_b() {
        return this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.getText();
    }

    public String java_lang_String_c() {
        return this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_b.getText();
    }

    public String java_lang_String_d() {
        return "BB-" + this.var_int_a;
    }

    public boolean boolean_b() {
        if (((we)((Engine)((Object)this.var_ayh_a)).axc_a()).wh_a().com_badlogic_gdx_scenes_scene2d_Stage_c().getKeyboardFocus() == this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a || ((we)((Engine)((Object)this.var_ayh_a)).axc_a()).wh_a().com_badlogic_gdx_scenes_scene2d_Stage_c().getKeyboardFocus() == this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_b) {
            return true;
        }
        if (((we)((Engine)((Object)this.var_ayh_a)).axc_a()).wh_a().com_badlogic_gdx_scenes_scene2d_Stage_a().getKeyboardFocus() == this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a || ((we)((Engine)((Object)this.var_ayh_a)).axc_a()).wh_a().com_badlogic_gdx_scenes_scene2d_Stage_a().getKeyboardFocus() == this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_b) {
            return true;
        }
        return ((we)((Engine)((Object)this.var_ayh_a)).axc_a()).wh_a().com_badlogic_gdx_scenes_scene2d_Stage_b().getKeyboardFocus() == this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a || ((we)((Engine)((Object)this.var_ayh_a)).axc_a()).wh_a().com_badlogic_gdx_scenes_scene2d_Stage_b().getKeyboardFocus() == this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_b;
    }

    public void a(String string) {
        Iterator iterator = this.var_ayh_a.iterator();
        while (iterator.hasNext()) {
            zo zo2 = (zo)iterator.next();
            if (!zo2.a().equals(string)) continue;
            iterator.remove();
        }
    }

    static /* synthetic */ String a(zu zu2, String string) {
        zu2.var_java_lang_String_a = string;
        return zu2.var_java_lang_String_a;
    }

    static /* synthetic */ SelectBox com_badlogic_gdx_scenes_scene2d_ui_SelectBox_a(zu zu2) {
        return zu2.var_ayh_a;
    }

    static /* synthetic */ ayh a(zu zu2, ayh ayh2) {
        zu2.var_ayh_b = ayh2;
        return zu2.var_ayh_b;
    }

    static /* synthetic */ ayh ayh_a(zu zu2) {
        return zu2.var_ayh_b;
    }

    static /* synthetic */ ayh b(zu zu2, ayh ayh2) {
        zu2.e = ayh2;
        return zu2.e;
    }

    static /* synthetic */ int int_a(zu zu2) {
        return --zu2.var_int_a;
    }

    static /* synthetic */ String a(zu zu2, int n2) {
        return zu2.a(n2);
    }

    static /* synthetic */ int b(zu zu2) {
        return ++zu2.var_int_a;
    }
}

