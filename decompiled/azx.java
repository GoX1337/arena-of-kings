/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class azx
extends ayc
implements azs {
    private final Engine var_com_arenaofkings_client_core_Engine_a;
    protected abi var_abi_a;
    private String var_java_lang_String_a = "";
    private Sprite d;
    private String b = "";

    public azx(Engine engine, int n2, int n3, TextureAtlas textureAtlas, abi abi2, boolean bl2, boolean bl3) {
        super(n2, n3, textureAtlas, "purchase_button_default2", "purchase_button_hovered2", "unavailable_button", bl3);
        this.var_com_arenaofkings_client_core_Engine_a = engine;
        this.var_abi_a = abi2;
        this.a(abi2, bl2);
        we we2 = (we)engine.axc_a();
        TextureAtlas textureAtlas2 = we2.axm_a().com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c);
        this.d = new Sprite(textureAtlas2.createSprite("villain_coin_menu_default"));
        this.d.setScale(0.9f);
        this.d.setPosition(n2 - 8, n3 - 30);
    }

    @Override
    public void a(float f2, Engine engine) {
        super.a(f2, engine);
    }

    @Override
    public void b(float f2, Engine engine) {
        if (ay.ay_a().gd_a().a(this.var_abi_a)) {
            engine.a("You own this item", engine.var_axy_e.a(), axe.F, engine.var_axy_e.a(), Color.BLACK, ((Sprite)((Object)this.b)).getX() - 16.0f, ((Sprite)((Object)this.b)).getY() + 37.0f, 8, 1);
            return;
        }
        if (this.b == false && this.var_com_arenaofkings_client_core_Engine_a == false) {
            ((Sprite)((Object)this.b)).draw(engine.var_azi_a);
            if (this.var_abi_a == abi.ah) {
                axe cfr_ignored_0 = engine.var_axe_a;
                engine.a("$6.99", engine.var_axy_c.a(), axe.F, engine.var_axy_c.a(), Color.BLACK, ((Sprite)((Object)this.b)).getX() + 86.0f, ((Sprite)((Object)this.b)).getY() + 45.0f, 8, 1);
            } else if (this.var_abi_a == abi.ai) {
                axe cfr_ignored_1 = engine.var_axe_a;
                engine.a("$16.99", engine.var_axy_c.a(), axe.F, engine.var_axy_c.a(), Color.BLACK, ((Sprite)((Object)this.b)).getX() + 86.0f, ((Sprite)((Object)this.b)).getY() + 45.0f, 8, 1);
            } else if (this.var_abi_a == abi.aj) {
                axe cfr_ignored_2 = engine.var_axe_a;
                engine.a("$59.99", engine.var_axy_c.a(), axe.F, engine.var_axy_c.a(), Color.BLACK, ((Sprite)((Object)this.b)).getX() + 86.0f, ((Sprite)((Object)this.b)).getY() + 45.0f, 8, 1);
            } else {
                this.d.draw(engine.var_azi_a);
                axe cfr_ignored_3 = engine.var_axe_a;
                engine.a(String.valueOf(this.var_abi_a.int_a()), engine.var_axy_e.a(), axe.F, engine.var_axy_e.a(), Color.BLACK, ((Sprite)((Object)this.b)).getX() + 86.0f, ((Sprite)((Object)this.b)).getY() + 30.0f, 1, 1);
            }
        } else if (this.b != false && this.var_com_arenaofkings_client_core_Engine_a == false) {
            this.c.draw(engine.var_azi_a);
            if (this.var_abi_a == abi.ah) {
                axe cfr_ignored_4 = engine.var_axe_a;
                engine.a("$6.99", engine.var_axy_c.a(), axe.F, engine.var_axy_c.a(), Color.BLACK, ((Sprite)((Object)this.b)).getX() + 86.0f, ((Sprite)((Object)this.b)).getY() + 45.0f, 8, 1);
            } else if (this.var_abi_a == abi.ai) {
                axe cfr_ignored_5 = engine.var_axe_a;
                engine.a("$16.99", engine.var_axy_c.a(), axe.F, engine.var_axy_c.a(), Color.BLACK, ((Sprite)((Object)this.b)).getX() + 86.0f, ((Sprite)((Object)this.b)).getY() + 45.0f, 8, 1);
            } else if (this.var_abi_a == abi.aj) {
                axe cfr_ignored_6 = engine.var_axe_a;
                engine.a("$59.99", engine.var_axy_c.a(), axe.F, engine.var_axy_c.a(), Color.BLACK, ((Sprite)((Object)this.b)).getX() + 86.0f, ((Sprite)((Object)this.b)).getY() + 45.0f, 8, 1);
            } else {
                this.d.draw(engine.var_azi_a);
                axe cfr_ignored_7 = engine.var_axe_a;
                engine.a(String.valueOf(this.var_abi_a.int_a()), engine.var_axy_e.a(), axe.F, engine.var_axy_e.a(), Color.BLACK, ((Sprite)((Object)this.b)).getX() + 86.0f, ((Sprite)((Object)this.b)).getY() + 30.0f, 1, 1);
            }
        } else {
            ((Sprite)((Object)this.var_com_arenaofkings_client_core_Engine_a)).draw(engine.var_azi_a);
        }
    }

    @Override
    public void void_a() {
        if (ay.ay_a().gd_a().a(this.var_abi_a)) {
            return;
        }
        if (this.var_com_arenaofkings_client_core_Engine_a.boolean_b()) {
            return;
        }
        we we2 = (we)this.var_com_arenaofkings_client_core_Engine_a.axc_a();
        Label.LabelStyle labelStyle = new Label.LabelStyle(this.var_com_arenaofkings_client_core_Engine_a.j, Color.WHITE);
        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = this.var_com_arenaofkings_client_core_Engine_a.l;
        textButtonStyle.fontColor = axe.K;
        azy azy2 = new azy(this, "", this.var_com_arenaofkings_client_core_Engine_a.var_com_badlogic_gdx_scenes_scene2d_ui_Skin_a, labelStyle);
        azy2.setBounds(830.0f, 575.0f, 450.0f, 135.0f);
        this.var_com_arenaofkings_client_core_Engine_a.a(azy2);
        we2.wh_a().com_badlogic_gdx_scenes_scene2d_Stage_c().addActor(azy2);
    }

    public void a(abi abi2, boolean bl2) {
        if (bl2) {
            switch (abi2.getRarity()) {
                case var_yt_a: {
                    this.var_java_lang_String_a = "\nPurchase [RARITY_UNCOMMON]" + abi2.getContent() + "[] for [AOK_NAMEPLATE_GOLD]" + abi2.java_lang_String_a() + "[]?";
                    break;
                }
                case b: {
                    this.var_java_lang_String_a = "\nPurchase [RARITY_RARE]" + abi2.getContent() + "[] for [AOK_NAMEPLATE_GOLD]" + abi2.java_lang_String_a() + "[]?";
                    break;
                }
                case c: {
                    this.var_java_lang_String_a = "\nPurchase [RARITY_EPIC]" + abi2.getContent() + "[] for [AOK_NAMEPLATE_GOLD]" + abi2.java_lang_String_a() + "[]?";
                    break;
                }
                case d: {
                    this.var_java_lang_String_a = "\nPurchase [RARITY_LEGENDARY]" + abi2.getContent() + "[] for [AOK_NAMEPLATE_GOLD]" + abi2.java_lang_String_a() + "[]?";
                    break;
                }
                default: {
                    this.var_java_lang_String_a = "\nPurchase [RARITY_LEGENDARY]" + abi2.getContent() + "[] for [AOK_NAMEPLATE_GOLD]" + abi2.java_lang_String_a() + "[]?";
                    break;
                }
            }
        } else {
            switch (abi2.getRarity()) {
                case var_yt_a: {
                    this.var_java_lang_String_a = "\nUnlock [RARITY_UNCOMMON]" + abi2.getContent() + "[] for [AOK_NAMEPLATE_GOLD]" + abi2.java_lang_String_a() + "[]?";
                    break;
                }
                case b: {
                    this.var_java_lang_String_a = "\nUnlock [RARITY_RARE]" + abi2.getContent() + "[] for [AOK_NAMEPLATE_GOLD]" + abi2.java_lang_String_a() + "[]?";
                    break;
                }
                case c: {
                    this.var_java_lang_String_a = "\nUnlock [RARITY_EPIC]" + abi2.getContent() + "[] for [AOK_NAMEPLATE_GOLD]" + abi2.java_lang_String_a() + "[]?";
                    break;
                }
                case d: {
                    this.var_java_lang_String_a = "\nUnlock [RARITY_LEGENDARY]" + abi2.getContent() + "[] for [AOK_NAMEPLATE_GOLD]" + abi2.java_lang_String_a() + "[]?";
                    break;
                }
                default: {
                    this.var_java_lang_String_a = "\nUnlock [RARITY_LEGENDARY]" + abi2.getContent() + "[] for [AOK_NAMEPLATE_GOLD]" + abi2.java_lang_String_a() + "[]?";
                }
            }
        }
    }

    @Override
    public void a(int n2, int n3) {
        super.a((float)(n2 += 34), n3 += 30);
        this.d.setPosition(n2 + 18, n3 + 1);
    }

    static /* synthetic */ Engine com_arenaofkings_client_core_Engine_a(azx azx2) {
        return azx2.var_com_arenaofkings_client_core_Engine_a;
    }

    static /* synthetic */ String java_lang_String_a(azx azx2) {
        return azx2.var_java_lang_String_a;
    }
}

