/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.ScoreboardItem;
import com.arenaofkings.packets.gameserver.data.ScoreboardUpdate;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class aju
implements axr {
    private final Engine var_com_arenaofkings_client_core_Engine_a;
    private ayh var_ayh_a;
    private ayh var_ayh_b;
    private String var_java_lang_String_a;
    private int var_int_a;
    private ajr var_ajr_a;
    private ajr var_ajr_b;
    private ajr var_ajr_c;
    private ajr var_ajr_d;
    private int var_int_b;
    private int var_int_c = 0;
    private int var_int_d;
    private int e;
    private int f;
    private int g;
    private Color var_com_badlogic_gdx_graphics_Color_a;
    private Color var_com_badlogic_gdx_graphics_Color_b;
    private br var_br_a;
    private boolean var_boolean_a = false;
    private boolean var_boolean_b = false;
    private boolean var_boolean_c = false;

    public aju(Engine engine, TextureAtlas textureAtlas, TextureAtlas textureAtlas2, int n2, ScoreboardUpdate scoreboardUpdate) {
        br br2;
        agd agd2;
        this.var_com_arenaofkings_client_core_Engine_a = engine;
        this.g = n2;
        this.var_java_lang_String_a = scoreboardUpdate.getPlayer_name();
        this.var_int_a = scoreboardUpdate.getScore();
        if (t.a(agd.class, engine) && (agd2 = (agd)engine.axc_a()).agp_a().c()) {
            this.var_boolean_c = true;
        }
        this.var_ayh_a = ay.ay_a().boolean_a(this.var_java_lang_String_a) ? new ayh(377, 750 - n2 * 33, textureAtlas, "scoreboard_row_ally", true) : new ayh(377, 750 - n2 * 33, textureAtlas, "scoreboard_row_enemy", true);
        this.var_int_c = scoreboardUpdate.ratingChange;
        this.var_int_d = this.var_int_c > 100 ? 2 : (this.var_int_c > 50 ? 5 : (this.var_int_c > 25 ? 7 : 8));
        System.out.println("The rating change: " + this.var_int_c);
        agd2 = (agd)engine.axc_a();
        this.var_boolean_b = agd2.agp_a().boolean_a();
        this.var_br_a = br2 = ay.ay_a().br_a(this.var_java_lang_String_a);
        if (br2 != null) {
            this.e = this.var_boolean_c ? br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().k() : br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().l();
            br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().p(scoreboardUpdate.newRating);
            this.var_int_b = scoreboardUpdate.newRating;
            Engine.b("character is not null");
            switch (br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_misc_CharacterClass_a()) {
                case ASSASSIN: {
                    this.var_ayh_b = new ayh(381, 753 - n2 * 32, textureAtlas2, "Assassin_square", true);
                    break;
                }
                case CHAMPION: {
                    this.var_ayh_b = new ayh(381, 753 - n2 * 32, textureAtlas2, "Champion_square", true);
                    break;
                }
                case ELDER: {
                    this.var_ayh_b = new ayh(381, 753 - n2 * 32, textureAtlas2, "Elder_square", true);
                    break;
                }
                case LICH: {
                    this.var_ayh_b = new ayh(381, 753 - n2 * 32, textureAtlas2, "Lich_square", true);
                    break;
                }
                case MYSTIC: {
                    this.var_ayh_b = new ayh(381, 753 - n2 * 32, textureAtlas2, "Mystic_square", true);
                    break;
                }
                case NIHILIST: {
                    this.var_ayh_b = new ayh(381, 753 - n2 * 32, textureAtlas2, "Nihilist_square", true);
                    break;
                }
                case PALADIN: {
                    this.var_ayh_b = new ayh(381, 753 - n2 * 32, textureAtlas2, "Paladin_square", true);
                    break;
                }
                case RANGER: {
                    this.var_ayh_b = new ayh(381, 753 - n2 * 32, textureAtlas2, "Ranger_square", true);
                    break;
                }
                case SCHOLAR: {
                    this.var_ayh_b = new ayh(381, 753 - n2 * 32, textureAtlas2, "Scholar_square", true);
                    break;
                }
                case WIZARD: {
                    this.var_ayh_b = new ayh(381, 753 - n2 * 32, textureAtlas2, "Wizard_square", true);
                    break;
                }
            }
        }
        if (ay.ay_a().br_a(this.var_java_lang_String_a) != null && ay.ay_a().boolean_a(this.var_java_lang_String_a)) {
            this.var_com_badlogic_gdx_graphics_Color_a = axe.w;
            this.var_com_badlogic_gdx_graphics_Color_b = axe.w;
            if (ay.ay_a() == ay.ay_a().br_a(this.var_java_lang_String_a)) {
                this.var_com_badlogic_gdx_graphics_Color_b = Color.GOLDENROD;
            }
        } else {
            this.var_com_badlogic_gdx_graphics_Color_a = Color.RED;
            this.var_com_badlogic_gdx_graphics_Color_b = Color.RED;
        }
        this.var_ajr_a = new ajr(engine, textureAtlas);
        for (ScoreboardItem scoreboardItem : scoreboardUpdate.getDamage()) {
            this.var_ajr_a.a(new ajs(scoreboardItem.getSpellName(), scoreboardItem.getTotalValue()));
        }
        this.var_ajr_b = new ajr(engine, textureAtlas);
        for (ScoreboardItem scoreboardItem : scoreboardUpdate.getHealing()) {
            this.var_ajr_b.a(new ajs(scoreboardItem.getSpellName(), scoreboardItem.getTotalValue()));
        }
        this.var_ajr_c = new ajr(engine, textureAtlas);
        for (ScoreboardItem scoreboardItem : scoreboardUpdate.getTanked()) {
            this.var_ajr_c.a(new ajs(scoreboardItem.getSpellName(), scoreboardItem.getTotalValue()));
        }
        this.var_ajr_d = new ajr(engine, textureAtlas);
        for (ScoreboardItem scoreboardItem : scoreboardUpdate.getControl()) {
            this.var_ajr_d.a(new ajs(scoreboardItem.getSpellName(), scoreboardItem.getTotalValue()));
        }
    }

    @Override
    public void a(float f2, Engine engine) {
    }

    public void c(float f2, Engine engine) {
        this.var_ayh_a.b(f2, engine);
        if (this.var_ayh_b != null) {
            this.var_ayh_b.b(f2, engine);
        }
        engine.a(this.var_java_lang_String_a, engine.var_axy_c.a(), this.var_com_badlogic_gdx_graphics_Color_b, engine.var_axy_c.a(), Color.BLACK, this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getX() + 30.0f, this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getY() + 21.0f, 8, 1);
        engine.a(String.valueOf(this.var_int_a), engine.var_axy_c.a(), this.var_com_badlogic_gdx_graphics_Color_b, engine.var_axy_c.a(), Color.BLACK, this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getX() + 240.0f, this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getY() + 21.0f, 1, 1);
        this.var_ajr_a.a(f2, engine, this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getX() + 406.0f, this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getY() + 21.0f, this.var_com_badlogic_gdx_graphics_Color_b);
        this.var_ajr_b.a(f2, engine, this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getX() + 556.0f, this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getY() + 21.0f, this.var_com_badlogic_gdx_graphics_Color_b);
        this.var_ajr_c.a(f2, engine, this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getX() + 690.0f, this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getY() + 21.0f, this.var_com_badlogic_gdx_graphics_Color_b);
        this.var_ajr_d.a(f2, engine, this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getX() + 838.0f, this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getY() + 21.0f, this.var_com_badlogic_gdx_graphics_Color_b);
        if (this.var_boolean_b) {
            if (this.var_boolean_c) {
                if (this.var_java_lang_String_a.equals(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().java_lang_String_a()) && ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().boolean_d()) {
                    engine.a("Placements", engine.var_axy_c.a(), this.var_com_badlogic_gdx_graphics_Color_b, engine.var_axy_c.a(), Color.BLACK, this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getX() + 1010.0f, this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getY() + 21.0f, 1, 1);
                } else {
                    engine.a(String.valueOf(this.var_int_b), engine.var_axy_c.a(), this.var_com_badlogic_gdx_graphics_Color_b, engine.var_axy_c.a(), Color.BLACK, this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getX() + 1010.0f, this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getY() + 21.0f, 1, 1);
                }
            } else {
                engine.a(String.valueOf(this.var_int_b), engine.var_axy_c.a(), this.var_com_badlogic_gdx_graphics_Color_b, engine.var_axy_c.a(), Color.BLACK, this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getX() + 1010.0f, this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getY() + 21.0f, 1, 1);
            }
        }
        if (this.var_boolean_c) {
            if (!this.var_java_lang_String_a.equals(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().java_lang_String_a()) || !ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().boolean_d()) {
                if (this.var_int_c > 0) {
                    engine.a("+" + String.valueOf(this.var_int_c), engine.var_axy_c.a(), this.var_com_badlogic_gdx_graphics_Color_b, engine.var_axy_c.a(), Color.BLACK, this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getX() + 1115.0f, this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getY() + 21.0f, 1, 1);
                } else {
                    engine.a(String.valueOf(this.var_int_c), engine.var_axy_c.a(), this.var_com_badlogic_gdx_graphics_Color_b, engine.var_axy_c.a(), Color.BLACK, this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getX() + 1115.0f, this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getY() + 21.0f, 1, 1);
                }
            }
        } else if (this.var_int_c > 0) {
            engine.a("+" + String.valueOf(this.var_int_c), engine.var_axy_c.a(), this.var_com_badlogic_gdx_graphics_Color_b, engine.var_axy_c.a(), Color.BLACK, this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getX() + 1115.0f, this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getY() + 21.0f, 1, 1);
        } else {
            engine.a(String.valueOf(this.var_int_c), engine.var_axy_c.a(), this.var_com_badlogic_gdx_graphics_Color_b, engine.var_axy_c.a(), Color.BLACK, this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getX() + 1115.0f, this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getY() + 21.0f, 1, 1);
        }
        if (this.var_boolean_b && this.var_br_a == ay.ay_a()) {
            if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().boolean_d()) {
                return;
            }
            ++this.f;
            if (this.f >= this.var_int_d) {
                this.f = 0;
                if (this.e > this.var_int_b) {
                    --this.e;
                } else if (this.e < this.var_int_b) {
                    ++this.e;
                } else {
                    this.var_boolean_a = true;
                }
            }
            engine.a("New Rating", engine.w, Color.WHITE, engine.w, Color.BLACK, 960.0f, 491.0f, 1, 1);
            if (this.var_int_c >= 0) {
                if (this.var_boolean_a) {
                    if (this.var_boolean_c) {
                        if (this.var_br_a.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().k() <= 1599) {
                            engine.a(this.e + " (+" + this.var_int_c + ")", engine.w, axe.j, engine.w, Color.BLACK, 960.0f, 458.0f, 1);
                        } else if (this.var_br_a.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().k() <= 1799) {
                            engine.a(this.e + " (+" + this.var_int_c + ")", engine.w, axe.k, engine.w, Color.BLACK, 960.0f, 458.0f, 1);
                        } else if (this.var_br_a.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().k() <= 1999) {
                            engine.a(this.e + " (+" + this.var_int_c + ")", engine.w, axe.l, engine.w, Color.BLACK, 960.0f, 458.0f, 1);
                        } else if (this.var_br_a.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().k() <= 2199) {
                            engine.a(this.e + " (+" + this.var_int_c + ")", engine.w, axe.m, engine.w, Color.BLACK, 960.0f, 458.0f, 1);
                        } else {
                            engine.a(this.e + " (+" + this.var_int_c + ")", engine.w, axe.n, engine.w, Color.BLACK, 960.0f, 458.0f, 1);
                        }
                    } else if (this.var_br_a.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().int_j() <= 1599) {
                        engine.a(this.e + " (+" + this.var_int_c + ")", engine.w, axe.j, engine.w, Color.BLACK, 960.0f, 458.0f, 1);
                    } else if (this.var_br_a.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().int_j() <= 1799) {
                        engine.a(this.e + " (+" + this.var_int_c + ")", engine.w, axe.k, engine.w, Color.BLACK, 960.0f, 458.0f, 1);
                    } else if (this.var_br_a.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().int_j() <= 1999) {
                        engine.a(this.e + " (+" + this.var_int_c + ")", engine.w, axe.l, engine.w, Color.BLACK, 960.0f, 458.0f, 1);
                    } else if (this.var_br_a.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().int_j() <= 2199) {
                        engine.a(this.e + " (+" + this.var_int_c + ")", engine.w, axe.m, engine.w, Color.BLACK, 960.0f, 458.0f, 1);
                    } else {
                        engine.a(this.e + " (+" + this.var_int_c + ")", engine.w, axe.n, engine.w, Color.BLACK, 960.0f, 458.0f, 1);
                    }
                } else {
                    engine.a(String.valueOf(this.e), engine.w, Color.GREEN, engine.w, Color.BLACK, 960.0f, 458.0f, 1, 1);
                }
            } else if (this.var_boolean_a) {
                if (this.var_boolean_c) {
                    if (this.var_br_a.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().k() <= 1599) {
                        engine.a(this.e + " (" + this.var_int_c + ")", engine.w, axe.j, engine.w, Color.BLACK, 960.0f, 458.0f, 1);
                    } else if (this.var_br_a.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().k() <= 1799) {
                        engine.a(this.e + " (" + this.var_int_c + ")", engine.w, axe.k, engine.w, Color.BLACK, 960.0f, 458.0f, 1);
                    } else if (this.var_br_a.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().k() <= 1999) {
                        engine.a(this.e + " (" + this.var_int_c + ")", engine.w, axe.l, engine.w, Color.BLACK, 960.0f, 458.0f, 1);
                    } else if (this.var_br_a.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().k() <= 2199) {
                        engine.a(this.e + " (" + this.var_int_c + ")", engine.w, axe.m, engine.w, Color.BLACK, 960.0f, 458.0f, 1);
                    } else {
                        engine.a(this.e + " (" + this.var_int_c + ")", engine.w, axe.n, engine.w, Color.BLACK, 960.0f, 458.0f, 1);
                    }
                } else if (this.var_br_a.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().int_j() <= 1599) {
                    engine.a(this.e + " (" + this.var_int_c + ")", engine.w, axe.j, engine.w, Color.BLACK, 960.0f, 458.0f, 1);
                } else if (this.var_br_a.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().int_j() <= 1799) {
                    engine.a(this.e + " (" + this.var_int_c + ")", engine.w, axe.k, engine.w, Color.BLACK, 960.0f, 458.0f, 1);
                } else if (this.var_br_a.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().int_j() <= 1999) {
                    engine.a(this.e + " (" + this.var_int_c + ")", engine.w, axe.l, engine.w, Color.BLACK, 960.0f, 458.0f, 1);
                } else if (this.var_br_a.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().int_j() <= 2199) {
                    engine.a(this.e + " (" + this.var_int_c + ")", engine.w, axe.m, engine.w, Color.BLACK, 960.0f, 458.0f, 1);
                } else {
                    engine.a(this.e + " (" + this.var_int_c + ")", engine.w, axe.n, engine.w, Color.BLACK, 960.0f, 458.0f, 1);
                }
            } else {
                engine.a(String.valueOf(this.e), engine.w, Color.RED, engine.w, Color.BLACK, 960.0f, 458.0f, 1, 1);
            }
        }
    }

    @Override
    public void b(float f2, Engine engine) {
        this.var_ajr_a.b(f2, engine, this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getX() + 406.0f, this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getY() + 21.0f, this.var_com_badlogic_gdx_graphics_Color_b);
        this.var_ajr_b.b(f2, engine, this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getX() + 556.0f, this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getY() + 21.0f, this.var_com_badlogic_gdx_graphics_Color_b);
        this.var_ajr_c.b(f2, engine, this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getX() + 690.0f, this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getY() + 21.0f, this.var_com_badlogic_gdx_graphics_Color_b);
        this.var_ajr_d.b(f2, engine, this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getX() + 838.0f, this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getY() + 21.0f, this.var_com_badlogic_gdx_graphics_Color_b);
    }

    public ayh a() {
        return this.var_ayh_a;
    }
}

