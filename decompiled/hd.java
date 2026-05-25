/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class hd
implements axr {
    private ayh var_ayh_a;
    private ayh var_ayh_b;
    private ayh var_ayh_c;
    private da var_da_a;
    private da var_da_b;
    private da var_da_c;
    private da d;
    protected final hf var_hf_a;
    private SpellName var_com_arenaofkings_packets_gameserver_data_updates_SpellName_a;
    private String var_java_lang_String_a;
    private boolean var_boolean_a;
    private int var_int_a = -1;
    private int var_int_b = -1;
    private boolean var_boolean_b = false;

    public hd(hf hf2, String string) {
        this.var_com_arenaofkings_packets_gameserver_data_updates_SpellName_a = hf2.com_arenaofkings_packets_gameserver_data_updates_SpellName_a();
        this.var_hf_a = hf2;
        this.var_java_lang_String_a = string;
        this.var_boolean_a = false;
    }

    public hd(hd hd2) {
        this.var_hf_a = hd2.var_hf_a;
        this.var_com_arenaofkings_packets_gameserver_data_updates_SpellName_a = hd2.var_com_arenaofkings_packets_gameserver_data_updates_SpellName_a;
        this.var_java_lang_String_a = hd2.var_java_lang_String_a;
        this.var_boolean_a = false;
        this.var_int_a = hd2.var_int_a;
        this.var_int_b = hd2.var_int_b;
    }

    public void a(axm axm2) {
        if (this.var_java_lang_String_a != "") {
            System.out.println("hey");
            Engine.a("LoadGFXSpellBook " + this.var_com_arenaofkings_packets_gameserver_data_updates_SpellName_a.name() + " " + this.var_java_lang_String_a + " ... loading spell icon from SpellIcon.atlas");
            this.var_ayh_a = new ayh(new Sprite(axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.jc).findRegion(this.var_java_lang_String_a)), true);
            this.var_ayh_a.b(-8, 0);
            this.var_ayh_b = new ayh(new Sprite(axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.jc).findRegion("spell_icon_border_default")), true);
            this.var_ayh_c = new ayh(new Sprite(axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.jc).findRegion("spell_icon_border_glowing")), false);
            this.var_da_a = new da(ajw.jf, "GCD_Default", 60, 0.02f, 0.0f, Animation.PlayMode.NORMAL, -25, -25);
            this.var_da_a.a(axm2, false, true);
            this.var_da_b = new da(ajw.jh, "GCD_Red", 60, 0.02f, 0.0f, Animation.PlayMode.NORMAL, -25, -25);
            this.var_da_b.a(axm2, false, true);
            this.var_da_c = new da(ajw.jg, "GCD_Flash", 60, 0.02f, 0.0f, Animation.PlayMode.NORMAL, -65, -65);
            this.var_da_c.a(axm2, false, true);
            this.var_da_c.void_d();
            this.d = new da(ajw.ji, "GCD_Glow", 20, 0.025f, 0.0f, Animation.PlayMode.NORMAL, -24, -24);
            this.d.a(axm2, false, true);
            this.var_da_a.a((float)(732 + this.var_int_b * 58), 1.0f);
            this.var_da_c.a((float)(733 + this.var_int_b * 58), 44.0f);
            this.d.a((float)(733 + this.var_int_b * 58), 44.0f);
            this.var_boolean_a = true;
        }
    }

    public void b(axm axm2) {
        Engine.b("loadGFXSpellBar for " + (Object)((Object)this.var_com_arenaofkings_packets_gameserver_data_updates_SpellName_a) + " " + this.var_java_lang_String_a);
        if (this.var_java_lang_String_a != "") {
            Engine.a("Searching for ICON that MATCHES: " + this.var_java_lang_String_a);
            Engine.a("Loading icon [1/2] ... trying ...");
            this.var_ayh_a = new ayh(new Sprite(axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.jc).findRegion(this.var_java_lang_String_a)), true);
            this.var_ayh_a.b(-8, 0);
            Engine.a("Loaded icon [2/2] success!");
            this.var_ayh_b = new ayh(new Sprite(axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.jc).findRegion("spell_icon_border_default")), true);
            this.var_ayh_c = new ayh(new Sprite(axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.jc).findRegion("spell_icon_border_glowing")), false);
            this.var_da_a = new da(ajw.jf, "GCD_Default", 60, 0.01666f, 0.0f, Animation.PlayMode.NORMAL, -25, -25);
            this.var_da_a.a(axm2, false, true);
            this.var_da_b = new da(ajw.jh, "GCD_Red", 60, 0.02f, 0.0f, Animation.PlayMode.NORMAL, -25, -25);
            this.var_da_b.a(axm2, false, true);
            this.var_da_c = new da(ajw.jg, "GCD_Flash", 60, 0.02f, 0.0f, Animation.PlayMode.NORMAL, -65, -65);
            this.var_da_c.a(axm2, false, true);
            this.d = new da(ajw.ji, "GCD_Glow", 20, 0.025f, 0.0f, Animation.PlayMode.NORMAL, -24, -24);
            this.d.a(axm2, false, true);
            if (SpellName.isBasic(this.var_com_arenaofkings_packets_gameserver_data_updates_SpellName_a)) {
                int n2 = 40;
                int n3 = -60;
                this.var_da_a.a((float)(622 + this.var_int_b * 57 + n2), 65 + n3);
                this.var_da_c.a((float)(623 + (this.var_int_b * 57 + n2)), 65 + n3);
                this.d.a((float)(623 + (this.var_int_b * 57 + n2)), 65 + n3);
                this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(623 + this.var_int_b * 57 + n2, 64 + n3);
                this.var_ayh_b.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(620 + this.var_int_b * 57 + n2, 64 + n3);
                this.var_ayh_c.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(620 + this.var_int_b * 57 + n2, 64 + n3);
            } else {
                this.var_da_a.a((float)(622 + this.var_int_b * 57), 65.0f);
                this.var_da_c.a((float)(623 + this.var_int_b * 57), 65.0f);
                this.d.a((float)(623 + this.var_int_b * 57), 65.0f);
                this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(623 + this.var_int_b * 57, 64.0f);
                this.var_ayh_b.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(620 + this.var_int_b * 57, 64.0f);
                this.var_ayh_c.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(620 + this.var_int_b * 57, 64.0f);
            }
            this.var_boolean_a = true;
        } else {
            this.var_boolean_a = true;
            Engine.b("lookup_name isn't set " + (Object)((Object)this.var_com_arenaofkings_packets_gameserver_data_updates_SpellName_a));
        }
    }

    public void a(Engine engine, boolean bl2, int n2, int n3) {
        if (ay.ay_a().gd_a().bu_a().boolean_a() && engine.var_com_badlogic_gdx_math_Vector3_a.x > 1070.0f) {
            return;
        }
        engine.var_azi_a.end();
        Gdx.gl.glEnable(3042);
        Gdx.gl.glBlendFunc(770, 771);
        engine.var_axf_a.begin();
        engine.var_axf_a.set(ShapeRenderer.ShapeType.Filled);
        String string = SpellName.getFormattedName(this.var_hf_a.com_arenaofkings_packets_gameserver_data_updates_SpellName_a());
        String string2 = "";
        String string3 = "";
        String string4 = "";
        if (this.var_hf_a.uk_a() != uk.b && this.var_hf_a.uk_a() != uk.c) {
            if (this.var_hf_a.azv_b().long_a() <= 0L) {
                string3 = "Instant";
                if (this.var_hf_a.int_b() > 0) {
                    switch (this.var_hf_a.gx_a()) {
                        case d: {
                            string2 = string2 + "[YELLOW]" + this.var_hf_a.int_b() + " " + gx.a(this.var_hf_a.gx_a()) + "[]";
                            break;
                        }
                        case b: {
                            string2 = string2 + "[ORANGE]" + this.var_hf_a.int_b() + " " + gx.a(this.var_hf_a.gx_a()) + "[]";
                            break;
                        }
                        case c: {
                            string2 = string2 + "[SKY]" + this.var_hf_a.int_b() + " " + gx.a(this.var_hf_a.gx_a()) + "[]";
                            break;
                        }
                        case var_gx_a: {
                            break;
                        }
                        case e: {
                            string2 = string2 + "[RED]" + this.var_hf_a.int_b() + " " + gx.a(this.var_hf_a.gx_a()) + "[]";
                            break;
                        }
                    }
                }
                string4 = (int)((float)this.var_hf_a.azv_c().long_a() / 1000.0f) + " sec cooldown";
            } else {
                string3 = (float)this.var_hf_a.azv_b().long_a() / 1000.0f + " sec cast";
                if (this.var_hf_a.int_b() > 0) {
                    switch (this.var_hf_a.gx_a()) {
                        case d: {
                            string2 = string2 + "[YELLOW]" + this.var_hf_a.int_b() + " " + gx.a(this.var_hf_a.gx_a()) + "[]";
                            break;
                        }
                        case b: {
                            string2 = string2 + "[ORANGE]" + this.var_hf_a.int_b() + " " + gx.a(this.var_hf_a.gx_a()) + "[]";
                            break;
                        }
                        case c: {
                            string2 = string2 + "[SKY]" + this.var_hf_a.int_b() + " " + gx.a(this.var_hf_a.gx_a()) + "[]";
                            break;
                        }
                        case var_gx_a: {
                            break;
                        }
                        case e: {
                            string2 = string2 + "[RED]" + this.var_hf_a.int_b() + " " + gx.a(this.var_hf_a.gx_a()) + "[]";
                            break;
                        }
                    }
                }
                string4 = (int)((float)this.var_hf_a.azv_c().long_a() / 1000.0f) + " sec cooldown";
            }
        }
        String string5 = "";
        if (this.var_hf_a.int_a() != 0 && this.var_hf_a.int_a() != -1) {
            string5 = this.var_hf_a.int_a() / 10 + " yd range";
        }
        String string6 = "Description not yet implemented :(";
        if (this.var_hf_a.java_lang_String_a() != null) {
            string6 = this.var_hf_a.java_lang_String_a();
        }
        int n4 = azu.a(engine, engine.var_axy_c.a(), string);
        int n5 = azu.a(engine, engine.var_axy_b.a(), string2);
        int n6 = azu.a(engine, engine.var_axy_b.a(), string3);
        int n7 = azu.a(engine, engine.var_axy_b.a(), string5);
        int n8 = azu.a(engine, engine.var_axy_b.a(), string4);
        int n9 = 10;
        int n10 = 16;
        int n11 = -20;
        int n12 = -8;
        int n13 = 0;
        int n14 = 550;
        String string7 = azu.a(engine, engine.var_axy_b.a(), string6, n14);
        int n15 = azu.b(engine, engine.var_axy_c.a(), string) + azu.b(engine, engine.var_axy_b.a(), string2) + azu.b(engine, engine.var_axy_b.a(), string3) + azu.b(engine, engine.var_axy_b.a(), string7);
        n15 += 26;
        if (bl2) {
            engine.var_axf_a.b(this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getX() + (float)n2, this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getY() + (float)n3 + 4.0f, n14 + 25, n15 + 36, 10.0f);
        } else {
            engine.var_axf_a.b(n2, n3 + 4, n14 + 25, n15 + 36, 10.0f);
        }
        n15 += 25;
        engine.var_axf_a.end();
        Gdx.gl.glDisable(3042);
        engine.var_azi_a.begin();
        if (bl2) {
            engine.a(string, engine.var_axy_c.a(), Color.WHITE, engine.var_axy_c.a(), Color.BLACK, this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getX() + (float)n9 + (float)n2, this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getY() + (float)n15 + 5.0f + (float)n3, 8);
        } else {
            engine.a(string, engine.var_axy_c.a(), Color.WHITE, engine.var_axy_c.a(), Color.BLACK, n9 + n2, n15 + 5 + n3, 8);
        }
        if (string2.length() > 0) {
            ++n13;
            if (bl2) {
                engine.a(string2, engine.var_axy_b.a(), Color.WHITE, engine.var_axy_b.a(), Color.BLACK, this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getX() + (float)n9 + (float)n2, this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getY() + (float)n15 + (float)n3 + (float)(-20 * n13), 8);
                engine.a(string5, engine.var_axy_b.a(), Color.WHITE, engine.var_axy_b.a(), Color.BLACK, this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getX() + (float)n14 + (float)n10 + (float)n2, this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getY() + (float)n15 + (float)n3 + (float)(-20 * n13), 16);
            } else {
                engine.a(string2, engine.var_axy_b.a(), Color.WHITE, engine.var_axy_b.a(), Color.BLACK, n9 + n2, n15 + n3 + -20 * n13, 8);
                engine.a(string5, engine.var_axy_b.a(), Color.WHITE, engine.var_axy_b.a(), Color.BLACK, n14 + n10 + n2, n15 + n3 + -20 * n13, 16);
            }
        }
        if (!string3.equals("") || !string4.equals("")) {
            ++n13;
        }
        if (bl2) {
            engine.a(string3, engine.var_axy_b.a(), Color.WHITE, engine.var_axy_b.a(), Color.BLACK, this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getX() + (float)n9 + (float)n2, this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getY() + (float)n15 + (float)n3 + (float)(-20 * n13), 8);
            engine.a(string4, engine.var_axy_b.a(), Color.WHITE, engine.var_axy_b.a(), Color.BLACK, this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getX() + (float)n14 + (float)n10 + (float)n2, this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getY() + (float)n15 + (float)n3 + (float)(-20 * n13), 16);
        } else {
            engine.a(string3, engine.var_axy_b.a(), Color.WHITE, engine.var_axy_b.a(), Color.BLACK, n9 + n2, n15 + n3 + -20 * n13, 8);
            engine.a(string4, engine.var_axy_b.a(), Color.WHITE, engine.var_axy_b.a(), Color.BLACK, n14 + n10 + n2, n15 + n3 + -20 * n13, 16);
        }
        ++n13;
        if (bl2) {
            engine.a(string7, engine.var_axy_b.a(), Color.WHITE, engine.var_axy_b.a(), Color.BLACK, this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getX() + (float)n9 + (float)n2, this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getY() + (float)n15 + (float)n3 + (float)(-20 * n13) + -8.0f, 8);
        } else {
            engine.a(string7, engine.var_axy_b.a(), Color.WHITE, engine.var_axy_b.a(), Color.BLACK, n9 + n2, n15 + n3 + -20 * n13 + -8, 8);
        }
    }

    public void c(float f2, Engine engine) {
        this.d(f2, engine);
    }

    public void d(float f2, Engine engine) {
        if (!this.var_java_lang_String_a.equals("")) {
            this.var_ayh_b.a(f2, engine);
            if (this.var_ayh_a != null) {
                this.var_ayh_a.a(f2, engine);
                this.var_ayh_a.b(f2, engine);
            }
            this.var_ayh_b.b(f2, engine);
            if (this.var_ayh_a != null && !this.var_java_lang_String_a.equals("Empty") && this.var_ayh_a.boolean_a()) {
                String string = "";
                ui ui2 = engine.var_hg_a.ui_a(this.var_com_arenaofkings_packets_gameserver_data_updates_SpellName_a);
                if (ui2 != null) {
                    this.a(engine, true, -620, -130);
                }
                if (Gdx.input.isKeyPressed(129) && Gdx.input.isKeyJustPressed(31)) {
                    Gdx.app.getClipboard().setContents(azu.a(ui2.java_lang_String_a()));
                }
            }
        }
    }

    @Override
    public void b(float f2, Engine engine) {
        if (!this.var_java_lang_String_a.equals("")) {
            this.var_ayh_b.a(f2, engine);
            this.var_ayh_c.a(f2, engine);
            if (this.var_ayh_a != null && !this.var_java_lang_String_a.equals("Empty")) {
                this.var_ayh_a.a(f2, engine);
                if (this.var_ayh_a.boolean_a()) {
                    String string = "";
                    ui ui2 = engine.var_hg_a.ui_a(this.var_com_arenaofkings_packets_gameserver_data_updates_SpellName_a);
                    if (ui2 != null) {
                        this.a(engine, true, -620, -115);
                    }
                }
                this.var_ayh_a.b(f2, engine);
            }
            this.var_ayh_b.b(f2, engine);
            this.var_ayh_c.b(f2, engine);
        }
    }

    public void a(float f2, Engine engine, int n2, int n3) {
        if (!this.var_java_lang_String_a.equals("") && this.var_ayh_a != null) {
            float f3 = this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getX();
            float f4 = this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getY();
            this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(n2, n3);
            this.var_ayh_a.a(f2, engine);
            this.var_ayh_a.b(f2, engine, n2, n3);
            this.var_ayh_b.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(n2 - 2, n3);
            this.var_ayh_b.a(f2, engine);
            this.var_ayh_b.b(f2, engine);
            this.var_da_c.a((float)n2, n3);
            this.var_da_c.b(f2, engine);
            if (!this.var_java_lang_String_a.equals("Empty") && this.var_ayh_a.boolean_a()) {
                String string = "";
                ui ui2 = engine.var_hg_a.ui_a(this.var_com_arenaofkings_packets_gameserver_data_updates_SpellName_a);
                if (ui2 != null) {
                    this.a(engine, true, -620, -115);
                }
            }
            this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(f3, f4);
        }
    }

    public void e(float f2, Engine engine) {
        if (ay.ay_a().gd_a().boolean_b()) {
            return;
        }
        if (this.var_ayh_b == null || this.var_ayh_b.com_badlogic_gdx_graphics_g2d_Sprite_a() == null) {
            return;
        }
        this.var_ayh_b.com_badlogic_gdx_graphics_g2d_Sprite_a().scale(-0.175f);
        this.var_ayh_c.com_badlogic_gdx_graphics_g2d_Sprite_a().scale(-0.175f);
        this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().scale(-0.175f);
        this.var_da_c.d(-0.15f);
        if (!this.var_java_lang_String_a.equals("")) {
            this.var_ayh_b.a(f2, engine);
            this.var_ayh_c.a(f2, engine);
            if (this.var_ayh_a != null) {
                this.var_ayh_a.a(f2, engine);
                this.var_ayh_a.b(f2, engine);
            } else {
                Engine.a("icon is null");
            }
            this.var_ayh_b.b(f2, engine);
            this.var_ayh_c.b(f2, engine);
            if (this.var_com_arenaofkings_packets_gameserver_data_updates_SpellName_a != SpellName.Empty) {
                this.d.b(f2, engine);
            }
            this.var_da_c.b(f2, engine);
            if (this.var_ayh_a != null && !this.var_java_lang_String_a.equals("Empty") && this.var_ayh_a.boolean_a()) {
                String string = "";
                ui ui2 = engine.var_hg_a.ui_a(this.var_com_arenaofkings_packets_gameserver_data_updates_SpellName_a);
                if (ui2 != null) {
                    this.a(engine, false, 1300, 100);
                } else if (this.var_com_arenaofkings_packets_gameserver_data_updates_SpellName_a == SpellName.TrinketOfResolve) {
                    this.a(engine, false, 1300, 100);
                } else if (this.var_com_arenaofkings_packets_gameserver_data_updates_SpellName_a == SpellName.Meditate) {
                    this.a(engine, false, 1300, 100);
                }
            }
        }
        this.var_ayh_b.com_badlogic_gdx_graphics_g2d_Sprite_a().scale(0.175f);
        this.var_ayh_c.com_badlogic_gdx_graphics_g2d_Sprite_a().scale(0.175f);
        this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().scale(0.175f);
        this.var_da_c.d(0.15f);
    }

    public void f(float f2, Engine engine) {
        if (!this.var_java_lang_String_a.equals("") && this.var_ayh_a != null) {
            this.var_ayh_a.a(f2, engine);
            this.var_ayh_a.b(f2, engine);
        }
    }

    public void g(float f2, Engine engine) {
        if (!this.var_java_lang_String_a.equals("") && this.var_ayh_a != null) {
            this.var_ayh_b.a(f2, engine);
            this.var_ayh_b.b(f2, engine);
        }
    }

    public void h(float f2, Engine engine) {
        if (!this.var_java_lang_String_a.equals("") && this.var_ayh_a != null) {
            this.var_ayh_c.a(f2, engine);
            this.var_ayh_c.b(f2, engine);
        }
    }

    public void i(float f2, Engine engine) {
        if (!this.var_java_lang_String_a.equals("") && this.var_ayh_a != null) {
            this.var_da_c.b(f2, engine);
        }
    }

    public void j(float f2, Engine engine) {
        if (!this.var_java_lang_String_a.equals("") && this.var_ayh_a != null) {
            this.d.b(f2, engine);
        }
    }

    public void k(float f2, Engine engine) {
        if (this.var_ayh_a != null && !this.var_java_lang_String_a.equals("Empty") && this.var_ayh_a.boolean_a()) {
            ((agd)engine.axc_a()).e(true);
            String string = "";
            ui ui2 = engine.var_hg_a.ui_a(this.var_com_arenaofkings_packets_gameserver_data_updates_SpellName_a);
            if (ui2 != null) {
                this.a(engine, false, 1300, 100);
            } else if (this.var_com_arenaofkings_packets_gameserver_data_updates_SpellName_a == SpellName.TrinketOfResolve) {
                this.a(engine, false, 1300, 100);
            }
        }
    }

    public void a(int n2, int n3) {
        if (!this.var_java_lang_String_a.equals("")) {
            if (this.var_ayh_a != null) {
                this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(n2, n3);
            }
            if (this.var_ayh_b != null) {
                this.var_ayh_b.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(n2 - 3, n3 - 2);
            }
            if (this.var_ayh_c != null) {
                this.var_ayh_c.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(n2 - 3, n3);
            }
            if (this.var_da_c != null) {
                this.var_da_c.a((float)(n2 - 5), n3);
            }
            if (this.d != null) {
                this.d.a((float)(n2 - 5), n3);
            }
        }
    }

    public void void_a() {
        if (!this.var_java_lang_String_a.equals("")) {
            this.var_ayh_b.a(false);
            this.var_ayh_c.a(true);
            for (ui ui2 : ay.ay_a().gu_a().ui_arr_a()) {
                if (this == ui2.hd_a()) continue;
                ui2.hd_a().void_b();
            }
        }
    }

    public void a(int n2) {
        if (!this.var_java_lang_String_a.equals("")) {
            if (this.var_ayh_b == null || this.var_ayh_b.com_badlogic_gdx_graphics_g2d_Sprite_a() == null) {
                return;
            }
            if (this.var_ayh_c == null || this.var_ayh_c.com_badlogic_gdx_graphics_g2d_Sprite_a() == null) {
                return;
            }
            this.var_ayh_b.a(false, n2);
            this.var_ayh_c.a(true, n2);
            for (ui ui2 : ay.ay_a().gu_a().ui_arr_a()) {
                if (ui2 == null || ui2.hd_a() == null || this == ui2.hd_a()) continue;
                ui2.hd_a().void_b();
            }
        }
    }

    public void void_b() {
        if (!this.var_java_lang_String_a.equals("")) {
            this.var_ayh_b.a(true);
            this.var_ayh_c.a(false);
        }
    }

    public void b(int n2) {
        this.var_int_b = n2;
    }

    public ayh ayh_a() {
        return this.var_ayh_a;
    }

    public Sprite com_badlogic_gdx_graphics_g2d_Sprite_a() {
        return this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a();
    }

    public ayh ayh_b() {
        return this.var_ayh_b;
    }

    public ayh ayh_c() {
        return this.var_ayh_c;
    }

    public da da_a() {
        return this.var_da_a;
    }

    public da da_b() {
        return this.var_da_c;
    }

    public da da_c() {
        return this.d;
    }

    public void c(int n2) {
        this.var_int_a = n2;
    }

    public int int_a() {
        return this.var_int_b;
    }

    public String java_lang_String_a() {
        return this.var_java_lang_String_a;
    }

    public boolean boolean_a() {
        return this.var_boolean_a;
    }

    @Override
    public void a(float f2, Engine engine) {
        if (!this.var_java_lang_String_a.equals("") && this.var_ayh_a != null) {
            this.var_ayh_a.a(f2, engine);
        }
    }

    public SpellName com_arenaofkings_packets_gameserver_data_updates_SpellName_a() {
        return this.var_com_arenaofkings_packets_gameserver_data_updates_SpellName_a;
    }

    public boolean boolean_b() {
        return this.var_boolean_b;
    }

    public void void_c() {
        Engine.a("UNz called");
        this.var_boolean_b = false;
    }

    public void d() {
        Engine.a("ZERO called");
        this.var_da_a.void_a();
        this.var_boolean_b = true;
    }

    public String toString() {
        return "SpellIcon [spellName=" + (Object)((Object)this.var_com_arenaofkings_packets_gameserver_data_updates_SpellName_a) + ", lookup_name=" + this.var_java_lang_String_a + ", loaded=" + this.var_boolean_a + ", index=" + this.var_int_a + ", slot=" + this.var_int_b + "]";
    }
}

