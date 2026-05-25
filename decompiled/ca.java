/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.loginserver.PUB_TRADE_SILVER_OFFER;
import com.arenaofkings.packets.misc.items.ItemLocation;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ca
implements axr {
    private final Engine var_com_arenaofkings_client_core_Engine_a;
    private int var_int_a;
    private int var_int_b;
    private ayh var_ayh_a;
    private boolean var_boolean_b = false;
    private List<fm> var_java_util_List_fm__a;
    private List<fm> var_java_util_List_fm__b;
    private ListIterator<fm> var_java_util_ListIterator_fm__a;
    private int var_int_c = 0;
    private int var_int_d = 0;
    private String var_java_lang_String_a;
    private ayc var_ayc_a;
    private ayc var_ayc_b;
    private ayh var_ayh_b;
    private ayh var_ayh_c;
    private ayh var_ayh_d;
    private ayh e;
    private Dialog var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a;
    private TextField var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a;
    protected cf var_cf_a;
    protected cf var_cf_b;
    protected boolean var_boolean_a = false;
    protected gp var_gp_a;

    public ca(Engine engine) {
        this.var_com_arenaofkings_client_core_Engine_a = engine;
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a = new TextField("", engine.var_com_badlogic_gdx_scenes_scene2d_ui_Skin_a);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.setAlignment(1);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.setFocusTraversal(true);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.setMaxLength(15);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.setWidth(350.0f);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.setPosition(730.0f, 625.0f);
        TextField.TextFieldStyle textFieldStyle = new TextField.TextFieldStyle(this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.getStyle());
        textFieldStyle.font = engine.o;
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.setStyle(textFieldStyle);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.setVisible(true);
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.setTextFieldFilter(new TextField.TextFieldFilter.DigitsOnlyFilter());
    }

    private void c() {
        int n2;
        int n3 = 24;
        this.var_com_arenaofkings_client_core_Engine_a = new ArrayList(n3);
        for (n2 = 0; n2 < n3; ++n2) {
            this.var_com_arenaofkings_client_core_Engine_a.add(new ff(ItemLocation.TRADE, n2));
        }
        this.var_int_b = (int)new ArrayList(n3);
        for (n2 = 0; n2 < n3; ++n2) {
            this.var_int_b.add(new ff(ItemLocation.TRADE, n2));
        }
        this.var_int_c = 0;
        this.var_int_d = 0;
    }

    public void a(int n2) {
        this.var_int_c = n2;
    }

    public void b(int n2) {
        this.var_int_d = n2;
    }

    public int int_a() {
        this.var_com_arenaofkings_client_core_Engine_a = this.var_com_arenaofkings_client_core_Engine_a.listIterator();
        while (this.var_com_arenaofkings_client_core_Engine_a.hasNext()) {
            fm fm2 = (fm)this.var_com_arenaofkings_client_core_Engine_a.next();
            if (!(fm2 instanceof ff)) continue;
            return fm2.int_a();
        }
        return -1;
    }

    public void a(axm axm2, Stage stage) {
        this.var_int_a = 50;
        this.var_int_b = 350;
        this.var_ayh_a = new ayh(this.var_int_a, this.var_int_b, axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c), "trade_window", true);
        this.var_ayc_a = new cb(this, this.var_int_a + 200, this.var_int_b + 8, axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c), "trade_accept_button_default", "trade_accept_button_hovered", "trade_accept_button_grayed", true);
        this.var_ayc_b = new cc(this, this.var_int_a + 385, this.var_int_b + 8, axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c), "trade_decline_button_default", "trade_decline_button_hovered", "trade_decline_button_grayed", true);
        this.var_ayh_d = new cd(this, this.var_int_a + 696, this.var_int_b + 87, axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c), "SilverCoinSmall", true, stage);
        this.e = new ayh(this.var_int_a, this.var_int_b, axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c), "SilverCoinSmall", true);
        this.var_ayh_b = new ayh(this.var_int_a, this.var_int_b, axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c), "trade_green_top_bar", true);
        this.var_ayh_c = new ayh(this.var_int_a, this.var_int_b, axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c), "trade_red_top_bar", true);
    }

    @Override
    public void a(float f2, Engine engine) {
        this.var_ayc_a.a(f2, engine);
        this.var_ayc_b.a(f2, engine);
        this.var_ayh_d.a(f2, engine);
    }

    @Override
    public void b(float f2, Engine engine) {
        if (this.var_boolean_b) {
            fm fm22;
            this.a(f2, engine);
            this.var_ayh_a.b(f2, engine);
            this.var_ayc_a.b(f2, engine);
            this.var_ayc_b.b(f2, engine);
            engine.a("[LIGHT_GRAY]" + this.var_int_c, engine.var_axy_c.a(), Color.WHITE, engine.var_axy_c.a(), Color.BLACK, this.var_int_a + 691, this.var_int_b + 101, 16);
            engine.a("[LIGHT_GRAY]" + this.var_int_d, engine.var_axy_c.a(), Color.WHITE, engine.var_axy_c.a(), Color.BLACK, this.var_int_a + 322, this.var_int_b + 101, 16);
            this.e.a(f2, engine.var_azi_a, this.var_int_a + 330, this.var_int_b + 87, 1.0f);
            this.var_ayh_d.b(f2, engine);
            if (this.var_cf_b == cf.d) {
                this.var_ayh_b.b(f2, engine, this.var_int_a, this.var_int_b + 400);
            } else {
                this.var_ayh_c.b(f2, engine, this.var_int_a, this.var_int_b + 400);
            }
            if (this.var_cf_a == cf.d) {
                this.var_ayh_b.b(f2, engine, this.var_int_a + 363, this.var_int_b + 400);
            } else {
                this.var_ayh_c.b(f2, engine, this.var_int_a + 363, this.var_int_b + 400);
            }
            Iterator iterator = this.var_com_arenaofkings_client_core_Engine_a.iterator();
            while (iterator.hasNext()) {
                fm22 = (fm)iterator.next();
                fm22.b(f2, engine);
            }
            for (fm fm22 : this.var_int_b) {
                fm22.b(f2, engine);
            }
            iterator = this.var_com_arenaofkings_client_core_Engine_a.iterator();
            while (iterator.hasNext()) {
                fm22 = (fm)iterator.next();
                if (!fm22.boolean_a()) continue;
                if (Gdx.input.isKeyPressed(57)) {
                    if (fm22.ayh_a() == null || fm22.ayh_a().com_badlogic_gdx_graphics_g2d_Sprite_a() == null) continue;
                    fm22.a(engine, (int)fm22.ayh_a().com_badlogic_gdx_graphics_g2d_Sprite_a().getX() + 48, (int)fm22.ayh_a().com_badlogic_gdx_graphics_g2d_Sprite_a().getY() - 248, 0, false, false);
                    continue;
                }
                if (fm22.ayh_a() == null || fm22.ayh_a().com_badlogic_gdx_graphics_g2d_Sprite_a() == null) continue;
                fm22.a(engine, (int)fm22.ayh_a().com_badlogic_gdx_graphics_g2d_Sprite_a().getX() + 48, (int)fm22.ayh_a().com_badlogic_gdx_graphics_g2d_Sprite_a().getY() - 48, 0, false, false);
            }
            for (fm fm22 : this.var_int_b) {
                if (!fm22.boolean_a()) continue;
                if (Gdx.input.isKeyPressed(57)) {
                    if (fm22.ayh_a() == null || fm22.ayh_a().com_badlogic_gdx_graphics_g2d_Sprite_a() == null) continue;
                    fm22.a(engine, (int)fm22.ayh_a().com_badlogic_gdx_graphics_g2d_Sprite_a().getX() + 48, (int)fm22.ayh_a().com_badlogic_gdx_graphics_g2d_Sprite_a().getY() - 248, 0, false, false);
                    continue;
                }
                if (fm22.ayh_a() == null || fm22.ayh_a().com_badlogic_gdx_graphics_g2d_Sprite_a() == null) continue;
                fm22.a(engine, (int)fm22.ayh_a().com_badlogic_gdx_graphics_g2d_Sprite_a().getX() + 48, (int)fm22.ayh_a().com_badlogic_gdx_graphics_g2d_Sprite_a().getY() - 48, 0, false, false);
            }
        }
    }

    public void c(float f2, Engine engine) {
        if (this.var_boolean_b) {
            Iterator iterator = this.var_com_arenaofkings_client_core_Engine_a.iterator();
            while (iterator.hasNext()) {
                fm fm2 = (fm)iterator.next();
                fm2.d(f2, engine);
            }
        }
    }

    private void d() {
        if (!this.var_boolean_b) {
            this.var_boolean_b = true;
            this.var_com_arenaofkings_client_core_Engine_a.var_baa_a.a(ajw.jY);
            this.var_boolean_a = true;
            this.c();
        }
    }

    private void e() {
        if (this.var_boolean_b) {
            this.var_boolean_b = false;
            this.var_com_arenaofkings_client_core_Engine_a.var_baa_a.a(ajw.jS);
            this.c();
        }
    }

    public void a(String string) {
        this.var_java_lang_String_a = string;
        this.var_com_arenaofkings_client_core_Engine_a.var_baa_a.a(ajw.kA);
        this.d();
    }

    public void b(String string) {
        this.var_java_lang_String_a = string;
        this.var_gp_a.a(true);
    }

    public void void_a() {
        this.var_gp_a.a(false);
    }

    public void b() {
        this.var_java_lang_String_a = "";
        this.e();
    }

    public void a(String string, fm fm2, int n2) {
        this.var_cf_a = cf.c;
        this.var_cf_b = cf.c;
        fm2.a(n2, ItemLocation.TRADE);
        if (this.var_java_lang_String_a.equals(string)) {
            this.var_int_b.set(n2, fm2);
            fm2.b(363);
        } else {
            this.var_com_arenaofkings_client_core_Engine_a.set(n2, fm2);
        }
        this.var_com_arenaofkings_client_core_Engine_a.var_baa_a.a(fm2.ajw_a(), 0.65f);
    }

    public void a(String string, int n2) {
        this.var_cf_a = cf.c;
        this.var_cf_b = cf.c;
        if (this.var_java_lang_String_a.equals(string)) {
            this.var_int_b.set(n2, new ff(ItemLocation.TRADE, n2));
            if (t.a(we.class, this.var_com_arenaofkings_client_core_Engine_a)) {
                we we2 = (we)this.var_com_arenaofkings_client_core_Engine_a.axc_a();
                wg wg2 = we2.wh_a().wg_a();
                wg2.a("[RED]Careful! Items were modified in Trade.");
            }
        } else {
            this.var_com_arenaofkings_client_core_Engine_a.set(n2, new ff(ItemLocation.TRADE, n2));
        }
        this.var_com_arenaofkings_client_core_Engine_a.var_baa_a.a(ajw.jZ, 0.5f);
    }

    public void a(ArrayList<Integer> arrayList, ArrayList<Integer> arrayList2, ArrayList<Integer> arrayList3, int n2) {
        Engine.b("START SUCCESSFUL TRADE");
        if (arrayList != null) {
            for (Integer object : arrayList) {
                ay.ay_a().gd_a().as_a().void_a(object);
            }
        }
        if (arrayList2 != null) {
            for (int i2 = 0; i2 < arrayList2.size(); ++i2) {
                ay.ay_a().gd_a().bu_a().void_a(arrayList2.get(i2), arrayList3.get(i2));
            }
        }
        for (fm fm2 : this.var_int_b) {
            if (!ay.ay_a().gd_a().as_a().boolean_b()) {
                ay.ay_a().gd_a().as_a().a(fm2);
            } else {
                ay.ay_a().gd_a().bu_a().a(fm2);
            }
            this.var_com_arenaofkings_client_core_Engine_a.var_baa_a.a(fm2.ajw_a(), 0.6f);
        }
        this.var_int_b.clear();
        this.var_com_arenaofkings_client_core_Engine_a.clear();
        this.var_cf_a = cf.var_cf_a;
        this.var_cf_b = cf.var_cf_a;
        if (t.a(we.class, this.var_com_arenaofkings_client_core_Engine_a)) {
            we we2 = (we)this.var_com_arenaofkings_client_core_Engine_a.axc_a();
            wg wg2 = we2.wh_a().wg_a();
            wg2.a("[RARITY_UNCOMMON]Trade successful.");
            if (n2 > 0) {
                wg2.a("[WHITE]You received [LIGHT_GRAY]" + n2 + " Silver[].");
                this.var_com_arenaofkings_client_core_Engine_a.var_baa_a.a(ajw.jU);
                this.var_com_arenaofkings_client_core_Engine_a.var_baa_a.a(ajw.jW);
            }
        }
        this.e();
        ay.ay_a().gd_a().ca_a().a(false);
        Engine.b("CLOSE SUCCESSFUL TRADE");
    }

    public void a(gp gp2) {
        this.var_gp_a = gp2;
    }

    public List<fm> a() {
        return this.var_com_arenaofkings_client_core_Engine_a;
    }

    public List<fm> b() {
        return this.var_int_b;
    }

    public void a(cf cf2) {
        this.var_cf_a = cf2;
    }

    public void b(cf cf2) {
        this.var_cf_b = cf2;
    }

    public boolean boolean_a() {
        return this.var_boolean_a;
    }

    public void a(boolean bl2) {
        this.var_boolean_a = bl2;
    }

    public String java_lang_String_a() {
        return this.var_java_lang_String_a;
    }

    public Dialog com_badlogic_gdx_scenes_scene2d_ui_Dialog_a() {
        return this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a;
    }

    public TextField com_badlogic_gdx_scenes_scene2d_ui_TextField_a() {
        return this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a;
    }

    public void a(Object object) {
        if (object.equals("confirm")) {
            if (Integer.valueOf(this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.getText()) <= ay.ay_a().gd_a().int_a()) {
                this.var_com_arenaofkings_client_core_Engine_a.var_baa_a.a(ajw.kE, 0.4f);
                PUB_TRADE_SILVER_OFFER pUB_TRADE_SILVER_OFFER = new PUB_TRADE_SILVER_OFFER();
                pUB_TRADE_SILVER_OFFER.amount = Integer.valueOf(this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.getText());
                this.var_com_arenaofkings_client_core_Engine_a.var_z_a.void_a(pUB_TRADE_SILVER_OFFER);
            } else if (t.a(we.class, this.var_com_arenaofkings_client_core_Engine_a)) {
                we we2 = (we)this.var_com_arenaofkings_client_core_Engine_a.axc_a();
                wg wg2 = we2.wh_a().wg_a();
                wg2.a("[RED]You don't have enough [LIGHT_GRAY]Silver[].");
            }
            this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.setText("");
        } else if (object.equals("deny")) {
            this.var_com_arenaofkings_client_core_Engine_a.var_baa_a.a(ajw.kE, 0.4f);
        }
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.setText("");
        this.var_com_arenaofkings_client_core_Engine_a.i();
        this.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a.remove();
        this.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a.hide();
    }

    public gp gp_a() {
        return this.var_gp_a;
    }

    static /* synthetic */ Engine com_arenaofkings_client_core_Engine_a(ca ca2) {
        return ca2.var_com_arenaofkings_client_core_Engine_a;
    }

    static /* synthetic */ Dialog a(ca ca2, Dialog dialog) {
        ca2.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a = dialog;
        return ca2.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a;
    }

    static /* synthetic */ TextField com_badlogic_gdx_scenes_scene2d_ui_TextField_a(ca ca2) {
        return ca2.var_com_badlogic_gdx_scenes_scene2d_ui_TextField_a;
    }

    static /* synthetic */ Dialog com_badlogic_gdx_scenes_scene2d_ui_Dialog_a(ca ca2) {
        return ca2.var_com_badlogic_gdx_scenes_scene2d_ui_Dialog_a;
    }
}

