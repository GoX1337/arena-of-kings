/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.PlayerAction;
import com.arenaofkings.packets.misc.ProfileBackgrounds;
import com.arenaofkings.packets.misc.ReadyStatus;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class bd
implements axr {
    private final Engine var_com_arenaofkings_client_core_Engine_a;
    private el var_el_a;
    private ayf var_ayf_a;
    private ayf var_ayf_b;
    private ReadyStatus var_com_arenaofkings_packets_misc_ReadyStatus_a = ReadyStatus.RED;
    private ayh var_ayh_a;
    private boolean var_boolean_a = false;
    private ProfileBackgrounds var_com_arenaofkings_packets_misc_ProfileBackgrounds_a = ProfileBackgrounds.NONE;
    private da var_da_a = new da();
    private da var_da_b = new da();
    private da var_da_c = new da();
    private abi var_abi_a = abi.L;
    private abi var_abi_b = abi.L;
    private abi var_abi_c = abi.L;
    private boolean var_boolean_b = false;
    private ayh var_ayh_b;
    private ayh var_ayh_c;
    private ayh var_ayh_d;
    private int var_int_a = 0;
    private boolean var_boolean_c = false;
    private ao var_ao_a = ao.var_ao_a;
    private ayh var_ayh_e;
    private bo var_bo_a = bo.e;
    private ayh var_ayh_f;
    private boolean var_boolean_d = false;
    private ayh var_ayh_g;
    private ayh var_ayh_h;
    private boolean var_boolean_e;
    private boolean var_boolean_f = false;
    private ayh var_ayh_i;
    private boolean var_boolean_g = false;
    private int var_int_b = 32;
    private int var_int_c = 26;
    private boolean var_boolean_h = false;
    private ayf var_ayf_c;
    private cr var_cr_a;
    private agw var_agw_a;
    private boolean var_boolean_i;

    public bd(Engine engine, el el2, cr cr2, boolean bl2) {
        this.var_com_arenaofkings_client_core_Engine_a = engine;
        this.var_el_a = el2;
        this.var_cr_a = cr2;
        this.void_a();
        this.var_boolean_i = bl2;
        this.var_int_a = bl2 ? ay.ay_a().int_b() : el2.int_f();
        Engine.b("Test Membership months: " + this.var_int_a);
        Engine.a("new profile: " + this.var_boolean_g);
    }

    public void a(axm axm2, ajw ajw2, boolean bl2, boolean bl3) {
        Engine.a("fullLoad: " + this.var_boolean_g);
        Engine.a("loadGFX in ()");
        if (bl2) {
            Engine.a("force");
            TextureAtlas textureAtlas = axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw2);
            if (!bl3) {
                this.var_agw_a = new agw(textureAtlas, "exp_bar_unfilled", "exp_bar_filled");
                this.var_agw_a.a().com_badlogic_gdx_graphics_g2d_Sprite_a().setColor(Color.GRAY);
                this.var_ayf_a = new be(this, 800, 887, textureAtlas, "switch_character_left_default", "switch_character_left_hovered", true);
                Engine.a("3");
                this.var_ayf_b = new bf(this, 1070, 887, textureAtlas, "switch_character_right_default", "switch_character_right_hovered", true);
                this.var_ayf_c = new bg(this, 773, 406, textureAtlas, "create_character_default", "create_character_hovered", true);
            }
            TextureAtlas textureAtlas2 = axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.jl);
            if (this.var_com_arenaofkings_packets_misc_ProfileBackgrounds_a == ProfileBackgrounds.NONE) {
                Engine.a("bg is NONE");
                this.var_ayh_i = new ayh(774, 665, textureAtlas2, "PBG_DEFAULT", true);
                this.var_boolean_h = true;
            } else {
                if (this.var_com_arenaofkings_packets_misc_ProfileBackgrounds_a == null) {
                    Engine.a("profile background is null");
                }
                Engine.a("loaded " + this.var_com_arenaofkings_packets_misc_ProfileBackgrounds_a.name());
                this.var_ayh_i = new ayh(774, 665, textureAtlas2, "PBG", this.var_com_arenaofkings_packets_misc_ProfileBackgrounds_a.getAtlasIndex(), true);
                this.var_boolean_h = true;
            }
            this.var_boolean_c = false;
            this.b(axm2);
            this.var_boolean_d = false;
            this.b(axm2, bl3);
            this.var_boolean_e = false;
            this.a(axm2);
            if (this.var_el_a.l() >= 2200) {
                this.var_bo_a = bo.var_bo_a;
                this.var_ayh_e = new ayh(1000, 1000, axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw2), "border_master", true);
            } else if (this.var_el_a.l() >= 2000) {
                this.var_bo_a = bo.b;
                this.var_ayh_e = new ayh(1000, 1000, axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw2), "border_diamond", true);
            } else if (this.var_el_a.l() >= 1800) {
                this.var_bo_a = bo.c;
                this.var_ayh_e = new ayh(1000, 1000, axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw2), "border_platinum", true);
            } else if (this.var_el_a.l() >= 1600) {
                this.var_bo_a = bo.d;
                this.var_ayh_e = new ayh(1000, 1000, axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw2), "border_gold", true);
            } else {
                this.var_bo_a = bo.e;
                this.var_ayh_e = new ayh(1000, 1000, axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw2), "border_silver", true);
            }
            this.var_boolean_f = false;
            this.a(axm2, bl3);
            if (!this.var_boolean_a) {
                TextureAtlas textureAtlas3 = axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.jm);
                this.a(textureAtlas3);
                this.var_boolean_a = true;
            }
            if (!this.var_boolean_b) {
                Engine.a("1p");
                if (this.var_abi_a.getScreenDependency() != ajw.bs) {
                    Engine.a("2p");
                    this.var_da_a = new da(this.var_abi_a.getScreenDependency(), this.var_abi_a.aer_a().java_lang_String_a(), this.var_abi_a.aer_a().int_c(), this.var_abi_a.aer_a().float_c(), this.var_abi_a.aer_a().float_b(), Animation.PlayMode.LOOP, this.var_abi_a.aer_a().d() + this.var_abi_a.aer_a().int_a(), this.var_abi_a.aer_a().e() + this.var_abi_a.aer_a().int_b());
                    this.var_da_a.a(this.var_abi_a.aer_a().com_badlogic_gdx_graphics_Color_a());
                }
                if (this.var_abi_b.getScreenDependency() != ajw.bs) {
                    Engine.a("3p");
                    this.var_da_b = new da(this.var_abi_b.getScreenDependency(), this.var_abi_b.aer_a().java_lang_String_a(), this.var_abi_b.aer_a().int_c(), this.var_abi_b.aer_a().float_c(), this.var_abi_b.aer_a().float_b(), Animation.PlayMode.LOOP, this.var_abi_b.aer_a().d() + this.var_abi_b.aer_a().int_a(), this.var_abi_b.aer_a().e() + this.var_abi_b.aer_a().int_b());
                    this.var_da_b.a(this.var_abi_b.aer_a().com_badlogic_gdx_graphics_Color_a());
                }
                if (this.var_abi_c.getScreenDependency() != ajw.bs) {
                    Engine.a("4p");
                    this.var_da_c = new da(this.var_abi_c.getScreenDependency(), this.var_abi_c.aer_a().java_lang_String_a(), this.var_abi_c.aer_a().int_c(), this.var_abi_c.aer_a().float_c(), this.var_abi_c.aer_a().float_b(), Animation.PlayMode.LOOP, this.var_abi_c.aer_a().d() + this.var_abi_c.aer_a().int_a(), this.var_abi_c.aer_a().e() + this.var_abi_c.aer_a().int_b());
                    this.var_da_c.a(this.var_abi_c.aer_a().com_badlogic_gdx_graphics_Color_a());
                }
            }
            Engine.a("loadGFX out ()");
            this.var_boolean_g = true;
        } else {
            TextureAtlas textureAtlas;
            TextureAtlas textureAtlas4 = axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw2);
            if (this.var_ayf_a == null) {
                this.var_ayf_a = new bh(this, 800, 897, textureAtlas4, "switch_character_left_default", "switch_character_left_hovered", true);
            }
            if (this.var_ayf_b == null) {
                this.var_ayf_b = new bi(this, 1070, 897, textureAtlas4, "switch_character_right_default", "switch_character_right_hovered", true);
            }
            if (this.var_ayf_c == null) {
                this.var_ayf_c = new bj(this, 865, 640, textureAtlas4, "create_character_default", "create_character_hovered", true);
            }
            if (!this.var_boolean_h) {
                textureAtlas = axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.jl);
                if (this.var_com_arenaofkings_packets_misc_ProfileBackgrounds_a == ProfileBackgrounds.NONE) {
                    Engine.a("bg is NONE");
                    this.var_ayh_i = new ayh(774, 665, textureAtlas, "PBG_DEFAULT", true);
                    this.var_boolean_h = true;
                } else {
                    if (this.var_com_arenaofkings_packets_misc_ProfileBackgrounds_a == null) {
                        Engine.a("profile background is null");
                    }
                    Engine.a("loaded " + this.var_com_arenaofkings_packets_misc_ProfileBackgrounds_a.name());
                    this.var_ayh_i = new ayh(774, 665, textureAtlas, "PBG", this.var_com_arenaofkings_packets_misc_ProfileBackgrounds_a.getAtlasIndex(), true);
                    this.var_boolean_h = true;
                }
            }
            if (!this.var_boolean_a) {
                textureAtlas = axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.jm);
                this.a(textureAtlas);
            }
            this.b(axm2, bl3);
            this.a(axm2, bl3);
            if (!this.var_boolean_b) {
                if (this.var_abi_a.getScreenDependency() != ajw.bs) {
                    this.var_da_a = new da(this.var_abi_a.getScreenDependency(), this.var_abi_a.aer_a().java_lang_String_a(), this.var_abi_a.aer_a().int_c(), this.var_abi_a.aer_a().float_c(), this.var_abi_a.aer_a().float_b(), Animation.PlayMode.LOOP, this.var_abi_a.aer_a().d() + this.var_abi_a.aer_a().int_a(), this.var_abi_a.aer_a().e());
                    this.var_da_a.a(this.var_abi_a.aer_a().com_badlogic_gdx_graphics_Color_a());
                }
                if (this.var_abi_b.getScreenDependency() != ajw.bs) {
                    this.var_da_b = new da(this.var_abi_b.getScreenDependency(), this.var_abi_b.aer_a().java_lang_String_a(), this.var_abi_b.aer_a().int_c(), this.var_abi_b.aer_a().float_c(), this.var_abi_b.aer_a().float_b(), Animation.PlayMode.LOOP, this.var_abi_b.aer_a().d() + this.var_abi_b.aer_a().int_a(), this.var_abi_b.aer_a().e());
                    this.var_da_b.a(this.var_abi_b.aer_a().com_badlogic_gdx_graphics_Color_a());
                }
                if (this.var_abi_c.getScreenDependency() != ajw.bs) {
                    this.var_da_c = new da(this.var_abi_c.getScreenDependency(), this.var_abi_c.aer_a().java_lang_String_a(), this.var_abi_c.aer_a().int_c(), this.var_abi_c.aer_a().float_c(), this.var_abi_c.aer_a().float_b(), Animation.PlayMode.LOOP, this.var_abi_c.aer_a().d() + this.var_abi_c.aer_a().int_a(), this.var_abi_c.aer_a().e());
                    this.var_da_c.a(this.var_abi_c.aer_a().com_badlogic_gdx_graphics_Color_a());
                }
            }
            Engine.a("profile loadGFX out ()");
            this.var_boolean_g = true;
        }
    }

    public void a(axm axm2) {
        if (!this.var_boolean_e) {
            this.var_boolean_e = true;
            TextureAtlas textureAtlas = axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.jd);
            switch (this.var_el_a.com_arenaofkings_packets_misc_CharacterClass_a()) {
                case ASSASSIN: {
                    this.var_ayh_h = new ayh(1000, 1000, textureAtlas, "Assassin", true);
                    break;
                }
                case CHAMPION: {
                    this.var_ayh_h = new ayh(1000, 1000, textureAtlas, "Champion", true);
                    break;
                }
                case ELDER: {
                    this.var_ayh_h = new ayh(1000, 1000, textureAtlas, "Elder", true);
                    break;
                }
                case LICH: {
                    this.var_ayh_h = new ayh(1000, 1000, textureAtlas, "Lich", true);
                    break;
                }
                case MYSTIC: {
                    this.var_ayh_h = new ayh(1000, 1000, textureAtlas, "Mystic", true);
                    break;
                }
                case NIHILIST: {
                    this.var_ayh_h = new ayh(1000, 1000, textureAtlas, "Nihilist", true);
                    break;
                }
                case PALADIN: {
                    this.var_ayh_h = new ayh(1000, 1000, textureAtlas, "Paladin", true);
                    break;
                }
                case RANGER: {
                    this.var_ayh_h = new ayh(1000, 1000, textureAtlas, "Ranger", true);
                    break;
                }
                case SCHOLAR: {
                    this.var_ayh_h = new ayh(1000, 1000, textureAtlas, "Scholar", true);
                    break;
                }
                case WIZARD: {
                    this.var_ayh_h = new ayh(1000, 1000, textureAtlas, "Wizard", true);
                    break;
                }
            }
        }
    }

    public void a(TextureAtlas textureAtlas) {
        Engine.a("load boarder: " + (Object)((Object)this.var_com_arenaofkings_packets_misc_ReadyStatus_a));
        switch (this.var_com_arenaofkings_packets_misc_ReadyStatus_a) {
            case GREEN: {
                this.var_ayh_a = new ayh(773, 662, textureAtlas, "BORDER_Green", true);
                this.var_boolean_a = true;
                break;
            }
            case RED: {
                this.var_ayh_a = new ayh(773, 662, textureAtlas, "BORDER_Red", true);
                this.var_boolean_a = true;
                break;
            }
            case YELLOW: {
                this.var_ayh_a = new ayh(773, 662, textureAtlas, "BORDER_Yellow", true);
                this.var_boolean_a = true;
                break;
            }
        }
    }

    public void a(axm axm2, boolean bl2) {
        if (!this.var_boolean_f) {
            TextureAtlas textureAtlas = !bl2 ? axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c) : axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.e);
            switch (this.var_el_a.com_arenaofkings_packets_misc_CharacterClass_a()) {
                case ASSASSIN: {
                    this.var_ayh_g = new ayh(1000, 1000, textureAtlas, "Assassin_square", true);
                    break;
                }
                case CHAMPION: {
                    this.var_ayh_g = new ayh(1000, 1000, textureAtlas, "Champion_square", true);
                    break;
                }
                case ELDER: {
                    this.var_ayh_g = new ayh(1000, 1000, textureAtlas, "Elder_square", true);
                    break;
                }
                case LICH: {
                    this.var_ayh_g = new ayh(1000, 1000, textureAtlas, "Lich_square", true);
                    break;
                }
                case MYSTIC: {
                    this.var_ayh_g = new ayh(1000, 1000, textureAtlas, "Mystic_square", true);
                    break;
                }
                case NIHILIST: {
                    this.var_ayh_g = new ayh(1000, 1000, textureAtlas, "Nihilist_square", true);
                    break;
                }
                case PALADIN: {
                    this.var_ayh_g = new ayh(1000, 1000, textureAtlas, "Paladin_square", true);
                    break;
                }
                case RANGER: {
                    this.var_ayh_g = new ayh(1000, 1000, textureAtlas, "Ranger_square", true);
                    break;
                }
                case SCHOLAR: {
                    this.var_ayh_g = new ayh(1000, 1000, textureAtlas, "Scholar_square", true);
                    break;
                }
                case WIZARD: {
                    this.var_ayh_g = new ayh(1000, 1000, textureAtlas, "Wizard_square", true);
                    break;
                }
            }
            this.var_boolean_f = true;
        }
    }

    public void b(axm axm2, boolean bl2) {
        if (!this.var_boolean_d) {
            Engine.a("started loadFameRank");
            TextureAtlas textureAtlas = axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.jd);
            this.var_ao_a = this.var_el_a == ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity() ? ao.a(ay.ay_a().int_a()) : ao.a(this.var_el_a.int_i());
            this.var_ayh_f = new bk(this, 1000, 1000, textureAtlas, this.var_ao_a.name(), true);
            this.var_boolean_d = true;
            Engine.a("ended loadFameRank");
            if (bl2) {
                if (this.var_el_a.l() >= 2200) {
                    this.var_bo_a = bo.var_bo_a;
                    this.var_ayh_e = new ayh(1000, 1000, axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c), "border_master", true);
                } else if (this.var_el_a.l() >= 2000) {
                    this.var_bo_a = bo.b;
                    this.var_ayh_e = new ayh(1000, 1000, axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c), "border_diamond", true);
                } else if (this.var_el_a.l() >= 1800) {
                    this.var_bo_a = bo.c;
                    this.var_ayh_e = new ayh(1000, 1000, axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c), "border_platinum", true);
                } else if (this.var_el_a.l() >= 1600) {
                    this.var_bo_a = bo.d;
                    this.var_ayh_e = new ayh(1000, 1000, axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c), "border_gold", true);
                } else {
                    this.var_bo_a = bo.e;
                    this.var_ayh_e = new ayh(1000, 1000, axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c), "border_silver", true);
                }
            } else if (this.var_el_a.l() >= 2200) {
                this.var_bo_a = bo.var_bo_a;
                this.var_ayh_e = new ayh(1000, 1000, axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c), "border_master", true);
            } else if (this.var_el_a.l() >= 2000) {
                this.var_bo_a = bo.b;
                this.var_ayh_e = new ayh(1000, 1000, axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c), "border_diamond", true);
            } else if (this.var_el_a.l() >= 1800) {
                this.var_bo_a = bo.c;
                this.var_ayh_e = new ayh(1000, 1000, axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c), "border_platinum", true);
            } else if (this.var_el_a.l() >= 1600) {
                this.var_bo_a = bo.d;
                this.var_ayh_e = new ayh(1000, 1000, axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c), "border_gold", true);
            } else {
                this.var_bo_a = bo.e;
                this.var_ayh_e = new ayh(1000, 1000, axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c), "border_silver", true);
            }
        }
    }

    public void b(axm axm2) {
        if (!this.var_boolean_c) {
            TextureAtlas textureAtlas = axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c);
            this.var_ayh_b = new ayh(774, 665, textureAtlas, "detail", true);
            if (this.var_int_a == 1) {
                this.var_ayh_c = new ayh(774, 665, textureAtlas, "MediumSubBadge-01", true);
            } else if (this.var_int_a == 2) {
                this.var_ayh_c = new ayh(774, 665, textureAtlas, "MediumSubBadge-02", true);
            } else if (this.var_int_a == 3) {
                this.var_ayh_c = new ayh(774, 665, textureAtlas, "MediumSubBadge-03", true);
            } else if (this.var_int_a >= 6 && this.var_int_a < 12) {
                this.var_ayh_c = new ayh(774, 665, textureAtlas, "MediumSubBadge-04", true);
            } else if (this.var_int_a >= 12 && this.var_int_a < 24) {
                this.var_ayh_c = new ayh(774, 665, textureAtlas, "MediumSubBadge-05", true);
            } else if (this.var_int_a >= 24) {
                this.var_ayh_c = new ayh(774, 665, textureAtlas, "MediumSubBadge-06", true);
            }
            System.out.println("Loading privilege = " + ay.ay_a().gd_a().axd_a().name());
            if (ay.ay_a().gd_a().axd_a() == axd.i) {
                this.var_ayh_c = new ayh(774, 665, textureAtlas, "PatreonBadge1", true);
            }
            this.var_ayh_d = new ayh(774, 665, textureAtlas, "MediumSubBadge-02", true);
            this.var_boolean_c = true;
        }
    }

    public void c(axm axm2) {
        if (!this.var_boolean_h) {
            TextureAtlas textureAtlas = axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.jl);
            if (this.var_com_arenaofkings_packets_misc_ProfileBackgrounds_a == ProfileBackgrounds.NONE) {
                this.var_ayh_i = new ayh(774, 665, textureAtlas, "PBG_DEFAULT", true);
            } else {
                Engine.a("loadingg " + this.var_com_arenaofkings_packets_misc_ProfileBackgrounds_a.name());
                this.var_ayh_i = new ayh(774, 665, textureAtlas, "PBG", this.var_com_arenaofkings_packets_misc_ProfileBackgrounds_a.getAtlasIndex(), true);
                Engine.a("loaded background");
            }
            this.var_boolean_h = true;
        }
    }

    public void c(axm axm2, boolean bl2) {
        if (!this.var_boolean_b || bl2) {
            Engine.a("setting the profile effects");
            if (this.var_abi_a.getScreenDependency() != ajw.bs) {
                this.var_da_a = new da(this.var_abi_a.getScreenDependency(), this.var_abi_a.aer_a().java_lang_String_a(), this.var_abi_a.aer_a().int_c(), this.var_abi_a.aer_a().float_c(), this.var_abi_a.aer_a().float_b(), Animation.PlayMode.LOOP, this.var_abi_a.aer_a().d() + this.var_abi_a.aer_a().int_a(), this.var_abi_a.aer_a().e() + this.var_abi_a.aer_a().int_b());
                this.var_da_a.a(this.var_abi_a.aer_a().com_badlogic_gdx_graphics_Color_a());
            } else {
                this.a(abi.L, 1);
            }
            if (this.var_abi_b.getScreenDependency() != ajw.bs) {
                this.var_da_b = new da(this.var_abi_b.getScreenDependency(), this.var_abi_b.aer_a().java_lang_String_a(), this.var_abi_b.aer_a().int_c(), this.var_abi_b.aer_a().float_c(), this.var_abi_b.aer_a().float_b(), Animation.PlayMode.LOOP, this.var_abi_b.aer_a().d() + this.var_abi_b.aer_a().int_a(), this.var_abi_b.aer_a().e() + this.var_abi_b.aer_a().int_b());
                this.var_da_b.a(this.var_abi_b.aer_a().com_badlogic_gdx_graphics_Color_a());
            } else {
                this.a(abi.L, 2);
            }
            if (this.var_abi_c.getScreenDependency() != ajw.bs) {
                this.var_da_c = new da(this.var_abi_c.getScreenDependency(), this.var_abi_c.aer_a().java_lang_String_a(), this.var_abi_c.aer_a().int_c(), this.var_abi_c.aer_a().float_c(), this.var_abi_c.aer_a().float_b(), Animation.PlayMode.LOOP, this.var_abi_c.aer_a().d() + this.var_abi_c.aer_a().int_a(), this.var_abi_c.aer_a().e() + this.var_abi_c.aer_a().int_b());
                this.var_da_c.a(this.var_abi_c.aer_a().com_badlogic_gdx_graphics_Color_a());
            } else {
                this.a(abi.L, 3);
            }
            Engine.a("loadProfileEffects");
            Engine.a("PE 1 : " + (Object)((Object)this.var_abi_a.getScreenDependency()) + " " + (Object)((Object)this.var_da_a.ajw_a()));
            Engine.a("PE 2 : " + (Object)((Object)this.var_abi_b.getScreenDependency()) + " " + (Object)((Object)this.var_da_b.ajw_a()));
            Engine.a("PE 3 : " + (Object)((Object)this.var_abi_c.getScreenDependency()) + " " + (Object)((Object)this.var_da_c.ajw_a()));
            if (this.var_da_a.ajw_a() != abi.L.getScreenDependency()) {
                this.var_da_a.a(axm2, false, true);
                this.var_da_a.a(this.var_abi_a.aer_a().com_badlogic_gdx_graphics_Color_a());
            }
            if (this.var_da_b.ajw_a() != abi.L.getScreenDependency()) {
                this.var_da_b.a(axm2, false, true);
                this.var_da_b.a(this.var_abi_b.aer_a().com_badlogic_gdx_graphics_Color_a());
            }
            if (this.var_da_c.ajw_a() != abi.L.getScreenDependency()) {
                this.var_da_c.a(axm2, false, true);
                this.var_da_c.a(this.var_abi_c.aer_a().com_badlogic_gdx_graphics_Color_a());
            }
            this.var_boolean_b = true;
        }
    }

    @Override
    public void a(float f2, Engine engine) {
        this.var_ayf_c.a(f2, engine);
    }

    @Override
    public void b(float f2, Engine engine) {
        this.a(f2, engine);
        this.a(f2, engine, 770, 653, false, false, false, true);
        this.var_ayf_c.b(f2, engine);
    }

    public void a(float f2, Engine engine, int n2, int n3, int n4, int n5, boolean bl2, boolean bl3, boolean bl4) {
        if (this.var_ayh_g == null || this.var_ayh_i == null || this.var_ayh_i == null || this.var_ayh_i.com_badlogic_gdx_graphics_g2d_Sprite_a() == null || this.var_ayh_f == null || this.var_ayh_f.com_badlogic_gdx_graphics_g2d_Sprite_a() == null || this.var_cr_a.da_a() == null || this.var_cr_a.da_a().com_badlogic_gdx_graphics_g2d_Sprite_a() == null || this.var_ayh_a == null) {
            this.var_boolean_g = false;
        }
        if (bl2 && this.var_ayh_a != null) {
            this.var_ayh_a.b(f2, engine, n2 + 4 + n4, n3 + 17 + n5);
        }
        if (this.var_ayh_i != null) {
            this.var_ayh_i.b(f2, engine, n2 - 18 + n4, n3 + 20 + n5);
        }
        if (this.var_ayh_c != null && ay.ay_a().gd_a().a(abi.at) && this.var_ayh_d != null) {
            this.var_ayh_d.a(n2 + 240, n3 + 267);
            this.var_ayh_d.a(f2, engine);
            this.var_ayh_d.b(f2, engine);
            if (this.var_ayh_d.boolean_a()) {
                engine.a("[RARITY_LEGENDARY]Legendary Badge\n[RARITY_LEGENDARY]  Game Edition", n2 + 208, n2 + 355, 300);
                engine.a("[RARITY_LEGENDARY]Legendary Badge\n[RARITY_LEGENDARY]  Game Edition", n2 + 208, n2 + 355);
            }
            this.var_ayh_c.a(n2 + 280, n3 + 267);
            this.var_ayh_c.a(f2, engine);
            this.var_ayh_c.b(f2, engine);
            if (this.var_ayh_c.boolean_a()) {
                engine.a("[RARITY_LEGENDARY]Patreon Badge\n[RARITY_RARE]Supporter", n2 + 248, n2 + 355, 300);
                engine.a("[RARITY_LEGENDARY]Patreon Badge\n[RARITY_RARE]Supporter", n2 + 248, n2 + 355);
            }
        } else if (this.var_ayh_c != null) {
            this.var_ayh_c.a(n2 + 270, n3 + 267);
            this.var_ayh_c.a(f2, engine);
            this.var_ayh_c.b(f2, engine);
            if (this.var_ayh_c.boolean_a()) {
                engine.a("[RARITY_UNCOMMON]Patreon Badge\n[RARITY_RARE]Supporter", n2 + 218, n2 + 355, 300);
                engine.a("[RARITY_UNCOMMON]Patreon Badge\n[RARITY_RARE]Supporter", n2 + 218, n2 + 355);
            }
        } else if (this.var_ayh_d != null && ay.ay_a().gd_a().a(abi.at)) {
            this.var_ayh_d.a(n2 + 270, n3 + 267);
            this.var_ayh_d.a(f2, engine);
            this.var_ayh_d.b(f2, engine);
            if (this.var_ayh_d.boolean_a()) {
                engine.a("[RARITY_LEGENDARY]Legendary Badge\n[RARITY_LEGENDARY]  Game Edition", n2 + 208, n2 + 355, 300);
                engine.a("[RARITY_LEGENDARY]Legendary Badge\n[RARITY_LEGENDARY]  Game Edition", n2 + 208, n2 + 355);
            }
        }
        if (this.var_da_a != null && this.var_da_a.ajw_a() != abi.L.getScreenDependency()) {
            this.var_da_a.a(f2, engine, n2 - 25 + n4, n3 + 4 + n5);
        }
        if (this.var_da_b != null && this.var_da_b.ajw_a() != abi.L.getScreenDependency()) {
            this.var_da_b.a(f2, engine, n2 - 25 + n4, n3 + 4 + n5);
        }
        if (this.var_da_c != null && this.var_da_c.ajw_a() != abi.L.getScreenDependency()) {
            this.var_da_c.a(f2, engine, n2 - 25 + n4, n3 + 4 + n5);
        }
        if (this.var_agw_a != null) {
            this.var_agw_a.a(n4, n3, (double)ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a(), (double)ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().eh_a().a());
            this.var_agw_a.a(f2, engine, n2 - 10, n3 + 202);
            engine.a("EXP: " + ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_a() + "/" + ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().eh_a().a(), engine.var_axy_c.a(), Color.WHITE, engine.var_axy_c.a(), Color.BLACK, (float)(n2 + 155), (float)(n3 + 217), 1, 1);
        }
        if (this.var_cr_a.da_a() != null) {
            if (this.var_cr_a.da_a() != this.var_cr_a.cy_a().a().get(PlayerAction.IDLE_SOUTH)) {
                this.var_cr_a.cy_a().a().get(PlayerAction.IDLE_SOUTH).a(f2, engine);
            }
            this.var_cr_a.cy_a().a().get(PlayerAction.IDLE_SOUTH).a(f2, engine, n2 + 33, n3 - 30 + n5);
        }
        if (bl3) {
            if (this.var_ayh_e != null) {
                engine.a(this.var_ao_a.java_lang_String_a() + "[GREEN]" + this.var_el_a.java_lang_String_a(), n2 + 66, n3 + 285);
            }
            if (this.var_ayh_h != null) {
                this.var_ayh_h.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(n2 - 10, n3 + 233);
                this.var_ayh_h.a(f2, engine);
                this.var_ayh_h.b(f2, engine);
            }
            if (this.var_ayh_b != null) {
                this.var_ayh_b.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(n2 + 35, n3 + 228);
                this.var_ayh_b.a(f2, engine);
                this.var_ayh_b.b(f2, engine);
                engine.a("" + ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().int_e(), engine.var_axy_b.a(), Color.WHITE, engine.var_axy_b.a(), Color.BLACK, (float)(n2 + 48), (float)(n3 + 246), 1, 1);
            }
        }
        engine.a("Victories", engine.var_axy_c.a(), Color.WHITE, engine.var_axy_c.a(), Color.BLACK, (float)(n2 + 100), (float)(n3 + 259), 1, 1);
        axe cfr_ignored_0 = engine.var_axe_a;
        engine.a("" + ay.ay_a().gd_a().int_c(), engine.var_axy_b.a(), axe.y, engine.var_axy_b.a(), Color.BLACK, (float)(n2 + 100), (float)(n3 + 242), 1, 1);
        engine.a("Rating", engine.var_axy_c.a(), Color.WHITE, engine.var_axy_c.a(), Color.BLACK, (float)(n2 + 189), (float)(n3 + 259), 1, 1);
        if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().l() <= 1599) {
            engine.a("" + ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().l(), engine.var_axy_c.a(), axe.t, engine.var_axy_c.a(), Color.BLACK, n2 + 189, n3 + 242, 1);
        } else if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().l() <= 1799) {
            engine.a("" + ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().l(), engine.var_axy_c.a(), axe.s, engine.var_axy_c.a(), Color.BLACK, n2 + 189, n3 + 242, 1);
        } else if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().l() <= 1999) {
            engine.a("" + ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().l(), engine.var_axy_c.a(), axe.r, engine.var_axy_c.a(), Color.BLACK, n2 + 189, n3 + 242, 1);
        } else if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().l() <= 2199) {
            engine.a("" + ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().l(), engine.var_axy_c.a(), axe.q, engine.var_axy_c.a(), Color.BLACK, n2 + 189, n3 + 242, 1);
        } else {
            engine.a("" + ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().l(), engine.var_axy_c.a(), axe.p, engine.var_axy_c.a(), Color.BLACK, n2 + 189, n3 + 242, 1);
        }
    }

    public void a(float f2, Engine engine, int n2, int n3, boolean bl2, boolean bl3, boolean bl4, boolean bl5) {
        if (this.var_ayh_g == null || this.var_ayh_i == null || this.var_ayh_i == null || this.var_ayh_i.com_badlogic_gdx_graphics_g2d_Sprite_a() == null || this.var_ayh_f == null || this.var_ayh_f.com_badlogic_gdx_graphics_g2d_Sprite_a() == null || this.var_cr_a.da_a() == null || this.var_cr_a.da_a().com_badlogic_gdx_graphics_g2d_Sprite_a() == null || this.var_ayh_a == null) {
            this.var_boolean_g = false;
        }
        if (bl2 && this.var_ayh_a != null) {
            this.var_ayh_a.b(f2, engine, n2 + 4, n3 + 13);
        }
        if (this.var_ayh_i != null) {
            this.var_ayh_i.b(f2, engine, n2 + 7, n3 + 16);
        }
        if (this.var_da_a != null && this.var_da_a.ajw_a() != abi.L.getScreenDependency()) {
            this.var_da_a.a(f2, engine, n2, n3);
        }
        if (this.var_da_b != null && this.var_da_b.ajw_a() != abi.L.getScreenDependency()) {
            this.var_da_b.a(f2, engine, n2, n3);
        }
        if (this.var_da_c != null && this.var_da_c.ajw_a() != abi.L.getScreenDependency()) {
            this.var_da_c.a(f2, engine, n2, n3);
        }
        if (this.var_cr_a.da_a() != null) {
            this.var_cr_a.da_a().a(f2, engine, n2 + 53, n3 - 30);
        }
        if (bl3) {
            if (this.var_ayh_e != null) {
                if (this.var_bo_a != null) {
                    switch (this.var_bo_a) {
                        case var_bo_a: {
                            this.var_ayh_e.b(f2, engine, n2 - 99, n3 - 22);
                            break;
                        }
                        case b: {
                            this.var_ayh_e.b(f2, engine, n2 - 99, n3 - 22);
                            break;
                        }
                        case c: {
                            this.var_ayh_e.b(f2, engine, n2 - 99, n3 - 22);
                            break;
                        }
                        case d: {
                            this.var_ayh_e.b(f2, engine, n2 - 99, n3 - 22);
                            break;
                        }
                        case e: {
                            this.var_ayh_e.b(f2, engine, n2 - 99, n3 - 22);
                            break;
                        }
                    }
                }
                engine.a("[GREEN]" + this.var_el_a.java_lang_String_a(), n2 + 105, n3 + 267);
            }
            if (this.var_ayh_h != null) {
                this.var_ayh_h.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(n2 + 15, n3 + 218);
                this.var_ayh_h.a(f2, engine);
                this.var_ayh_h.b(f2, engine);
            }
            if (bl5 && this.var_ayh_b != null) {
                this.var_ayh_b.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(n2 + 60, n3 + 213);
                this.var_ayh_b.a(f2, engine);
                this.var_ayh_b.b(f2, engine);
                if (this.var_el_a != null) {
                    engine.a("" + this.var_el_a.int_e(), engine.var_axy_b.a(), Color.WHITE, engine.var_axy_b.a(), Color.BLACK, (float)(n2 + 73), (float)(n3 + 231), 1, 1);
                }
            }
        }
    }

    public void b(float f2, Engine engine, int n2, int n3, boolean bl2, boolean bl3, boolean bl4, boolean bl5) {
        if (this.var_ayh_g == null || this.var_ayh_i == null || this.var_ayh_i == null || this.var_ayh_i.com_badlogic_gdx_graphics_g2d_Sprite_a() == null || this.var_ayh_f == null || this.var_ayh_f.com_badlogic_gdx_graphics_g2d_Sprite_a() == null || this.var_cr_a.da_a() == null || this.var_cr_a.da_a().com_badlogic_gdx_graphics_g2d_Sprite_a() == null || this.var_ayh_a == null) {
            this.var_boolean_g = false;
        }
        if (bl2 && this.var_ayh_a != null) {
            this.var_ayh_a.b(f2, engine, n2 + 4 - this.var_int_c, n3 + 13 - this.var_int_b);
        }
        if (this.var_ayh_i != null) {
            this.var_ayh_i.b(f2, engine, n2 + 7 - this.var_int_c, n3 + 16 - this.var_int_b);
        }
        if (this.var_da_a != null && this.var_da_a.ajw_a() != abi.L.getScreenDependency()) {
            this.var_da_a.a(f2, engine, n2 - this.var_int_c, n3 - this.var_int_b);
        }
        if (this.var_da_b != null && this.var_da_b.ajw_a() != abi.L.getScreenDependency()) {
            this.var_da_b.a(f2, engine, n2 - this.var_int_c, n3 - this.var_int_b);
        }
        if (this.var_da_c != null && this.var_da_c.ajw_a() != abi.L.getScreenDependency()) {
            this.var_da_c.a(f2, engine, n2 - this.var_int_c, n3 - this.var_int_b);
        }
        if (this.var_cr_a.da_a() != null) {
            this.var_cr_a.da_a().a(f2, engine, n2 + 53 - this.var_int_c, n3 - 30 - this.var_int_b);
        }
        if (bl3) {
            if (this.var_ayh_e != null) {
                if (this.var_bo_a != null) {
                    switch (this.var_bo_a) {
                        case var_bo_a: {
                            this.var_ayh_e.b(f2, engine, n2 - 99 - this.var_int_c, n3 - 22 - this.var_int_b);
                            break;
                        }
                        case b: {
                            this.var_ayh_e.b(f2, engine, n2 - 99 - this.var_int_c, n3 - 22 - this.var_int_b);
                            break;
                        }
                        case c: {
                            this.var_ayh_e.b(f2, engine, n2 - 99 - this.var_int_c, n3 - 22 - this.var_int_b);
                            break;
                        }
                        case d: {
                            this.var_ayh_e.b(f2, engine, n2 - 99 - this.var_int_c, n3 - 22 - this.var_int_b);
                            break;
                        }
                        case e: {
                            this.var_ayh_e.b(f2, engine, n2 - 99 - this.var_int_c, n3 - 22 - this.var_int_b);
                            break;
                        }
                    }
                }
                engine.a(this.var_el_a.com_arenaofkings_packets_misc_CharacterClass_a().getClassColorTextFormatted() + this.var_el_a.java_lang_String_a(), n2 + 103 - this.var_int_c, n3 + 306 - this.var_int_b);
            }
            if (this.var_ayh_h != null && this.var_bo_a != null) {
                switch (this.var_bo_a) {
                    case var_bo_a: {
                        this.var_ayh_h.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(n2 + 13 - this.var_int_c, n3 + 250 - this.var_int_b);
                        break;
                    }
                    case b: {
                        this.var_ayh_h.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(n2 + 12 - this.var_int_c, n3 + 250 - this.var_int_b);
                        break;
                    }
                    case c: {
                        this.var_ayh_h.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(n2 + 11 - this.var_int_c, n3 + 250 - this.var_int_b);
                        break;
                    }
                    case d: {
                        this.var_ayh_h.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(n2 + 11 - this.var_int_c, n3 + 250 - this.var_int_b);
                        break;
                    }
                    case e: {
                        this.var_ayh_h.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(n2 + 12 - this.var_int_c, n3 + 250 - this.var_int_b);
                        break;
                    }
                }
                this.var_ayh_h.a(f2, engine);
                this.var_ayh_h.b(f2, engine);
            }
            if (bl5 && this.var_ayh_b != null) {
                this.var_ayh_b.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(n2 + 104 - this.var_int_c - 45, n3 + 287 - this.var_int_b - 46);
                this.var_ayh_b.a(f2, engine);
                this.var_ayh_b.b(f2, engine);
                if (this.var_el_a != null) {
                    engine.a("" + this.var_el_a.int_e(), engine.var_axy_b.a(), Color.WHITE, engine.var_axy_b.a(), Color.BLACK, (float)(n2 + 117 - this.var_int_c - 45), (float)(n3 + 305 - this.var_int_b - 46), 1, 1);
                    engine.a("" + this.var_el_a.int_e(), engine.var_axy_b.a(), Color.WHITE, engine.var_axy_b.a(), Color.BLACK, (float)(n2 + 117 - this.var_int_c - 45), (float)(n3 + 305 - this.var_int_b - 46), 1, 1);
                    if (this.var_el_a.l() <= 1599) {
                        engine.a("" + this.var_el_a.l(), engine.var_axy_c.a(), axe.t, engine.var_axy_c.a(), Color.BLACK, n2 + 103 - this.var_int_c, n3 + 280 - this.var_int_b, 8);
                    } else if (this.var_el_a.l() <= 1799) {
                        engine.a("" + this.var_el_a.l(), engine.var_axy_c.a(), axe.s, engine.var_axy_c.a(), Color.BLACK, n2 + 103 - this.var_int_c, n3 + 280 - this.var_int_b, 8);
                    } else if (this.var_el_a.l() <= 1999) {
                        engine.a("" + this.var_el_a.l(), engine.var_axy_c.a(), axe.r, engine.var_axy_c.a(), Color.BLACK, n2 + 103 - this.var_int_c, n3 + 280 - this.var_int_b, 8);
                    } else if (this.var_el_a.l() <= 2199) {
                        engine.a("" + this.var_el_a.l(), engine.var_axy_c.a(), axe.q, engine.var_axy_c.a(), Color.BLACK, n2 + 103 - this.var_int_c, n3 + 280 - this.var_int_b, 8);
                    } else {
                        engine.a("" + this.var_el_a.l(), engine.var_axy_c.a(), axe.p, engine.var_axy_c.a(), Color.BLACK, n2 + 103 - this.var_int_c, n3 + 280 - this.var_int_b, 8);
                    }
                }
            }
        }
    }

    public boolean boolean_a() {
        return this.var_boolean_h;
    }

    public boolean boolean_b() {
        return this.var_boolean_f;
    }

    public boolean boolean_c() {
        return this.var_boolean_d;
    }

    public boolean d() {
        return this.var_boolean_b;
    }

    public boolean e() {
        return this.var_boolean_e;
    }

    public boolean f() {
        return this.var_boolean_a;
    }

    public void a(boolean bl2) {
        this.var_boolean_h = bl2;
    }

    public void b(boolean bl2) {
        this.var_boolean_b = bl2;
    }

    public void void_a() {
        this.var_boolean_g = false;
        this.var_boolean_a = false;
        this.var_boolean_h = false;
    }

    public boolean g() {
        return this.var_boolean_g;
    }

    public void a(el el2) {
        this.var_el_a = el2;
    }

    public cr cr_a() {
        return this.var_cr_a;
    }

    public abi abi_a() {
        return this.var_abi_a;
    }

    public abi abi_b() {
        return this.var_abi_b;
    }

    public abi abi_c() {
        return this.var_abi_c;
    }

    public da da_a() {
        return this.var_da_a;
    }

    public da da_b() {
        return this.var_da_b;
    }

    public da da_c() {
        return this.var_da_c;
    }

    public ProfileBackgrounds com_arenaofkings_packets_misc_ProfileBackgrounds_a() {
        return this.var_com_arenaofkings_packets_misc_ProfileBackgrounds_a;
    }

    public void a(ProfileBackgrounds profileBackgrounds) {
        if (profileBackgrounds != this.var_com_arenaofkings_packets_misc_ProfileBackgrounds_a) {
            Engine.a("setting bg: " + (Object)((Object)profileBackgrounds));
            this.var_com_arenaofkings_packets_misc_ProfileBackgrounds_a = profileBackgrounds;
            this.var_boolean_h = false;
        }
    }

    public void a(abi abi2, int n2) {
        if (n2 == 1) {
            Engine.a("setting 1 " + abi2);
            this.var_abi_a = abi2;
            this.var_da_a = new da(abi2.getScreenDependency(), abi2.aer_a().java_lang_String_a(), abi2.aer_a().int_c(), abi2.aer_a().float_c(), abi2.aer_a().float_b(), Animation.PlayMode.LOOP, abi2.aer_a().d() + abi2.aer_a().int_a(), abi2.aer_a().e() + abi2.aer_a().int_b());
            this.var_da_a.a(this.var_abi_a.aer_a().com_badlogic_gdx_graphics_Color_a());
            this.var_boolean_b = false;
        } else if (n2 == 2) {
            Engine.a("setting 2 " + abi2);
            this.var_abi_b = abi2;
            this.var_da_b = new da(abi2.getScreenDependency(), abi2.aer_a().java_lang_String_a(), abi2.aer_a().int_c(), abi2.aer_a().float_c(), abi2.aer_a().float_b(), Animation.PlayMode.LOOP, abi2.aer_a().d() + abi2.aer_a().int_a(), abi2.aer_a().e() + abi2.aer_a().int_b());
            this.var_da_b.a(this.var_abi_b.aer_a().com_badlogic_gdx_graphics_Color_a());
            this.var_boolean_b = false;
        } else if (n2 == 3) {
            Engine.a("setting 3 " + abi2);
            this.var_abi_c = abi2;
            this.var_da_c = new da(abi2.getScreenDependency(), abi2.aer_a().java_lang_String_a(), abi2.aer_a().int_c(), abi2.aer_a().float_c(), abi2.aer_a().float_b(), Animation.PlayMode.LOOP, abi2.aer_a().d() + abi2.aer_a().int_a(), abi2.aer_a().e() + abi2.aer_a().int_b());
            this.var_da_c.a(this.var_abi_c.aer_a().com_badlogic_gdx_graphics_Color_a());
            this.var_boolean_b = false;
        }
    }

    public ReadyStatus com_arenaofkings_packets_misc_ReadyStatus_a() {
        return this.var_com_arenaofkings_packets_misc_ReadyStatus_a;
    }

    public void c(boolean bl2) {
        this.var_boolean_d = bl2;
    }

    public void a(ReadyStatus readyStatus) {
        if (this.var_com_arenaofkings_packets_misc_ReadyStatus_a != readyStatus) {
            this.var_com_arenaofkings_packets_misc_ReadyStatus_a = readyStatus;
            this.var_boolean_a = false;
        }
    }

    static /* synthetic */ Engine com_arenaofkings_client_core_Engine_a(bd bd2) {
        return bd2.var_com_arenaofkings_client_core_Engine_a;
    }

    static /* synthetic */ el el_a(bd bd2) {
        return bd2.var_el_a;
    }

    static /* synthetic */ ao ao_a(bd bd2) {
        return bd2.var_ao_a;
    }
}

