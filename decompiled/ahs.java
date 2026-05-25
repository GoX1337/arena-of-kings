/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.EffectManager;
import com.arenaofkings.packets.gameserver.data.HitCircle;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.arenaofkings.packets.misc.CharacterClass;
import com.arenaofkings.packets.misc.InputIdentifier;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import java.util.concurrent.TimeUnit;

public abstract class ahs
implements axr {
    private final br var_br_a;
    protected ayh var_ayh_a;
    protected ayh var_ayh_b;
    private ayh e;
    private int var_int_b = 0;
    private ayh f;
    private ayh g;
    private ayh h;
    private ayh i;
    protected agv var_agv_a;
    protected agv var_agv_b;
    protected agv var_agv_c;
    protected agv var_agv_d;
    protected ayh var_ayh_c;
    protected boolean var_boolean_a = false;
    protected ayh var_ayh_d;
    protected gz var_gz_a;
    protected EffectManager var_com_arenaofkings_packets_gameserver_data_EffectManager_a;
    protected HitCircle var_com_arenaofkings_packets_gameserver_data_HitCircle_a;
    protected float var_float_a;
    protected float var_float_b;
    protected int var_int_a;
    protected String var_java_lang_String_a;
    private boolean var_boolean_c;
    boolean var_boolean_b = false;
    private float var_float_c;
    private float var_float_d = 45.0f;
    private da var_da_a;
    private boolean var_boolean_d = false;

    public ahs(Engine engine, TextureAtlas textureAtlas, TextureAtlas textureAtlas2, br br2, gz gz2, EffectManager effectManager, HitCircle hitCircle, boolean bl2, gx gx2, CharacterClass characterClass, int n2) {
        Engine.a("starting loading nameplate");
        this.var_br_a = br2;
        this.var_ayh_a = new ayh(0, 0, textureAtlas, "v3_nameplate_frame_default", true);
        this.var_ayh_b = new ayh(0, 0, textureAtlas, "v3_nameplate_frame_casting", true);
        this.var_boolean_c = bl2;
        this.var_agv_a = bl2 ? new agv(textureAtlas, "v3_nameplate_health_bar") : new agv(textureAtlas, "v3_nameplate_enemy_health_bar");
        this.var_agv_c = new agv(textureAtlas, "v3_nameplate_cast_bar");
        this.var_agv_d = new agv(textureAtlas, "v3_nameplate_cc_bar");
        this.var_ayh_c = new ayh(0, 0, textureAtlas, "v3_nameplate_cc_bar_background", true);
        this.var_ayh_d = new ayh(0, 0, textureAtlas, "nameplate_cast_flare", true);
        if (bl2) {
            this.f = new ayh(0, 0, textureAtlas, "nameplate_ally_backdrop", true);
            this.g = new ayh(0, 0, textureAtlas, "nameplate_ally_left_curl", true);
            this.h = new ayh(0, 0, textureAtlas, "nameplate_ally_right_curl", true);
            this.i = new ayh(0, 0, textureAtlas, "target_ally", true);
        } else {
            this.f = new ayh(0, 0, textureAtlas, "nameplate_enemy_backdrop", true);
            this.g = new ayh(0, 0, textureAtlas, "nameplate_enemy_left_curl", true);
            this.h = new ayh(0, 0, textureAtlas, "nameplate_enemy_right_curl", true);
            this.i = new ayh(0, 0, textureAtlas, "target_enemy", true);
        }
        this.var_da_a = new da(ajw.jg, "GCD_Flash", 15, 45, 0.02f, 0.0f, Animation.PlayMode.LOOP, -65, -65);
        this.var_da_a.d(-0.6f);
        this.var_da_a.a(engine.axc_a().axm_a(), false, true);
        this.var_da_a.a(1550.0f, 415.0f);
        switch (characterClass) {
            case ASSASSIN: {
                this.e = new ayh(0, 0, textureAtlas, "Assassin_Icon", true);
                this.var_int_b = 1;
                break;
            }
            case CHAMPION: {
                this.e = new ayh(0, 0, textureAtlas, "Champion_Icon", true);
                this.var_int_b = 2;
                break;
            }
            case ELDER: {
                this.e = new ayh(0, 0, textureAtlas, "Elder_Icon", true);
                this.var_int_b = 1;
                break;
            }
            case LICH: {
                this.e = new ayh(0, 0, textureAtlas, "Lich_Icon", true);
                this.var_int_b = 1;
                break;
            }
            case MYSTIC: {
                this.e = new ayh(0, 0, textureAtlas, "Mystic_Icon", true);
                break;
            }
            case NIHILIST: {
                this.e = new ayh(0, 0, textureAtlas, "Nihilist_Icon", true);
                this.var_int_b = 1;
                break;
            }
            case PALADIN: {
                this.e = new ayh(0, 0, textureAtlas, "Paladin_Icon", true);
                this.var_int_b = 1;
                break;
            }
            case RANGER: {
                this.e = new ayh(0, 0, textureAtlas, "Ranger_Icon", true);
                break;
            }
            case SCHOLAR: {
                this.e = new ayh(0, 0, textureAtlas, "Scholar_Icon", true);
                this.var_int_b = 1;
                break;
            }
            case WIZARD: {
                this.e = new ayh(0, 0, textureAtlas, "Wizard_Icon", true);
            }
        }
        this.var_java_lang_String_a = String.valueOf(n2);
        this.var_int_a = n2;
        this.var_gz_a = gz2;
        this.var_com_arenaofkings_packets_gameserver_data_EffectManager_a = effectManager;
        this.var_com_arenaofkings_packets_gameserver_data_HitCircle_a = hitCircle;
        Engine.a("exit nameplate constructor");
    }

    @Override
    public void a(float f2, Engine engine) {
        oo oo2;
        this.var_float_a = this.var_br_a.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX() + (float)(this.var_br_a.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getRadius() / 2);
        this.var_float_b = this.var_br_a.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY();
        this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(this.var_float_a - this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getWidth() / 2.0f, this.var_float_b + 139.0f);
        this.var_ayh_b.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(this.var_float_a - this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getWidth() / 2.0f, this.var_float_b + 134.0f);
        this.f.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(this.var_float_a - this.f.com_badlogic_gdx_graphics_g2d_Sprite_a().getWidth() / 2.0f, this.var_float_b + 125.0f);
        this.g.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(this.var_float_a - this.g.com_badlogic_gdx_graphics_g2d_Sprite_a().getWidth() / 2.0f - 70.0f, this.var_float_b + 116.0f);
        this.h.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(this.var_float_a - this.h.com_badlogic_gdx_graphics_g2d_Sprite_a().getWidth() / 2.0f + 70.0f, this.var_float_b + 116.0f);
        this.i.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(this.var_float_a - 22.0f, this.var_float_b + 165.0f + this.var_float_c);
        if (this.var_float_c >= 35.0f) {
            this.var_float_d *= -1.0f;
        } else if (this.var_float_c <= -1.0f) {
            this.var_float_d *= -1.0f;
        }
        if (!(f2 >= 0.016f)) {
            this.var_float_c += f2 * this.var_float_d;
        }
        this.e.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(this.var_float_a - 68.0f + (float)this.var_int_b, this.var_float_b + 138.0f);
        this.var_agv_a.ayh_a().com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(this.var_float_a - this.var_agv_a.ayh_a().com_badlogic_gdx_graphics_g2d_Sprite_a().getWidth() / 2.0f, this.var_float_b + 147.0f);
        this.var_agv_b.ayh_a().com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(this.var_float_a - this.var_agv_b.ayh_a().com_badlogic_gdx_graphics_g2d_Sprite_a().getWidth() / 2.0f, this.var_float_b + 142.0f);
        this.var_agv_c.ayh_a().com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(this.var_float_a - this.var_agv_c.ayh_a().com_badlogic_gdx_graphics_g2d_Sprite_a().getWidth() / 2.0f, this.var_float_b + 133.0f);
        this.var_agv_d.ayh_a().com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(this.var_float_a - this.var_agv_c.ayh_a().com_badlogic_gdx_graphics_g2d_Sprite_a().getWidth() / 2.0f, this.var_float_b + 153.0f);
        this.var_ayh_c.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(this.var_float_a - 46.0f, this.var_float_b + 153.0f);
        if (this.var_gz_a.ui_a() != null && this.var_gz_a.ui_a().hf_a().azv_b().boolean_a() && !this.var_gz_a.ui_a().hf_a().azv_b().boolean_b()) {
            this.var_ayh_d.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(this.var_float_a - 52.0f + this.var_gz_a.ui_a().hf_a().azv_b().float_a() * (float)this.var_agv_c.ayh_a().com_badlogic_gdx_graphics_g2d_Sprite_a().getRegionWidth(), this.var_float_b + 130.0f);
            this.var_agv_c.a((double)this.var_gz_a.ui_a().hf_a().azv_b().a(TimeUnit.MILLISECONDS), this.var_gz_a.ui_a().hf_a().azv_b().long_a());
        }
        if ((oo2 = this.var_com_arenaofkings_packets_gameserver_data_EffectManager_a.getPriorityEffect()) != null) {
            this.var_agv_d.a((double)oo2.azv_a().int_b(), oo2.azv_a().long_b());
            this.var_boolean_a = true;
            Engine.a("setValues: " + oo2.azv_a().int_b() + " " + oo2.azv_a().long_b());
        } else {
            this.var_boolean_a = false;
        }
    }

    @Override
    public void b(float f2, Engine engine) {
        this.a(f2, engine);
        if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a() != null && ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer() != null && ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().ahs_a() == this) {
            this.var_boolean_d = true;
            if (this.var_boolean_c && engine.var_aj_a.boolean_a(ai.q)) {
                this.i.b(f2, engine);
            } else if (!this.var_boolean_c && engine.var_aj_a.boolean_a(ai.r)) {
                this.i.b(f2, engine);
            }
        } else {
            this.var_boolean_d = false;
        }
        if (this.var_gz_a.ui_a() != null && this.var_gz_a.ui_a().hf_a().azv_b().boolean_a() && !this.var_gz_a.ui_a().hf_a().azv_b().boolean_b()) {
            this.var_ayh_b.b(f2, engine);
        } else {
            this.var_ayh_a.b(f2, engine);
        }
        this.e.b(f2, engine);
        if (this.var_gz_a.ui_a() != null && this.var_gz_a.ui_a().hf_a().azv_b().boolean_a() && !this.var_gz_a.ui_a().hf_a().azv_b().boolean_b() && this.var_gz_a.ui_a().hd_a() != null && this.var_gz_a.ui_a().hd_a().com_badlogic_gdx_graphics_g2d_Sprite_a() != null) {
            System.out.println("Tracing:");
            System.out.println("curSpell: " + (Object)((Object)this.var_gz_a.ui_a().hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a()));
            if (this.var_gz_a.ui_a() == null) {
                System.out.println("Null 1");
            }
            if (this.var_gz_a.ui_a().hd_a() == null) {
                System.out.println("Null 2");
            }
            if (this.var_gz_a.ui_a().hd_a().com_badlogic_gdx_graphics_g2d_Sprite_a() == null) {
                System.out.println("Null 3");
            }
            System.out.println("Done null checking");
            float f3 = this.var_gz_a.ui_a().hd_a().com_badlogic_gdx_graphics_g2d_Sprite_a().getX();
            System.out.println("got x");
            float f4 = this.var_gz_a.ui_a().hd_a().com_badlogic_gdx_graphics_g2d_Sprite_a().getY();
            this.var_gz_a.ui_a().hd_a().com_badlogic_gdx_graphics_g2d_Sprite_a().setScale(0.5f);
            this.var_gz_a.ui_a().hd_a().com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(this.var_com_arenaofkings_packets_gameserver_data_HitCircle_a.getX() - this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getWidth() / 2.0f - 26.0f + 114.0f, this.var_com_arenaofkings_packets_gameserver_data_HitCircle_a.getY() + 124.0f);
            this.var_gz_a.ui_a().hd_a().com_badlogic_gdx_graphics_g2d_Sprite_a().draw(engine.var_azi_a);
            this.var_agv_c.b(f2, engine);
            this.var_ayh_d.b(f2, engine);
            this.var_gz_a.ui_a().hd_a().com_badlogic_gdx_graphics_g2d_Sprite_a().setScale(1.0f);
            this.var_gz_a.ui_a().hd_a().com_badlogic_gdx_graphics_g2d_Sprite_a().setX(f3);
            this.var_gz_a.ui_a().hd_a().com_badlogic_gdx_graphics_g2d_Sprite_a().setY(f4);
            engine.a(SpellName.getFormattedName(this.var_gz_a.ui_a().hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a()), engine.var_axy_a.a(), Color.WHITE, engine.var_axy_a.a(), Color.BLACK, this.var_float_a, this.var_float_b + 132.0f, 1, 1);
        }
        this.var_agv_a.b(f2, engine);
        if (this.var_boolean_a && this.var_agv_d.double_a() / this.var_agv_d.b() > (double)0.03f) {
            this.var_ayh_c.b(f2, engine);
            this.var_agv_d.b(f2, engine);
            this.var_ayh_d.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition((float)((double)(this.var_float_a - 54.0f) + this.var_agv_d.double_a() / this.var_agv_d.b() * (double)this.var_agv_d.ayh_a().com_badlogic_gdx_graphics_g2d_Sprite_a().getRegionWidth()), this.var_float_b + 149.0f);
            this.var_ayh_d.b(f2, engine);
        }
        if (!ay.ay_a().gd_a().boolean_b() && engine.var_aj_a.boolean_a(ai.l)) {
            if (this.var_boolean_c) {
                if (this.var_int_a == 1) {
                    if (this.var_boolean_d) {
                        engine.a(engine.var_agc_a.a(InputIdentifier.TARGET_SELF), engine.var_axy_d.a(), Color.YELLOW, engine.var_axy_d.a(), Color.BLACK, this.var_float_a, this.var_float_b + 157.0f, 1, 1);
                    } else {
                        engine.a(engine.var_agc_a.a(InputIdentifier.TARGET_SELF), engine.var_axy_d.a(), Color.WHITE, engine.var_axy_d.a(), Color.BLACK, this.var_float_a, this.var_float_b + 157.0f, 1, 1);
                    }
                } else if (this.var_int_a == 2) {
                    if (this.var_boolean_d) {
                        engine.a(engine.var_agc_a.a(InputIdentifier.TARGET_ALLY_2), engine.var_axy_d.a(), Color.YELLOW, engine.var_axy_d.a(), Color.BLACK, this.var_float_a, this.var_float_b + 157.0f, 1, 1);
                    } else {
                        engine.a(engine.var_agc_a.a(InputIdentifier.TARGET_ALLY_2), engine.var_axy_d.a(), Color.WHITE, engine.var_axy_d.a(), Color.BLACK, this.var_float_a, this.var_float_b + 157.0f, 1, 1);
                    }
                } else if (this.var_int_a == 3) {
                    if (this.var_boolean_d) {
                        engine.a(engine.var_agc_a.a(InputIdentifier.TARGET_ALLY_3), engine.var_axy_d.a(), Color.YELLOW, engine.var_axy_d.a(), Color.BLACK, this.var_float_a, this.var_float_b + 157.0f, 1, 1);
                    } else {
                        engine.a(engine.var_agc_a.a(InputIdentifier.TARGET_ALLY_3), engine.var_axy_d.a(), Color.WHITE, engine.var_axy_d.a(), Color.BLACK, this.var_float_a, this.var_float_b + 157.0f, 1, 1);
                    }
                }
            } else if (this.var_int_a == 1) {
                if (this.var_boolean_d) {
                    engine.a(engine.var_agc_a.a(InputIdentifier.TARGET_ENEMY_1), engine.var_axy_d.a(), Color.YELLOW, engine.var_axy_d.a(), Color.BLACK, this.var_float_a, this.var_float_b + 157.0f, 1, 1);
                } else {
                    engine.a(engine.var_agc_a.a(InputIdentifier.TARGET_ENEMY_1), engine.var_axy_d.a(), Color.WHITE, engine.var_axy_d.a(), Color.BLACK, this.var_float_a, this.var_float_b + 157.0f, 1, 1);
                }
            } else if (this.var_int_a == 2) {
                if (this.var_boolean_d) {
                    engine.a(engine.var_agc_a.a(InputIdentifier.TARGET_ENEMY_2), engine.var_axy_d.a(), Color.YELLOW, engine.var_axy_d.a(), Color.BLACK, this.var_float_a, this.var_float_b + 157.0f, 1, 1);
                } else {
                    engine.a(engine.var_agc_a.a(InputIdentifier.TARGET_ENEMY_2), engine.var_axy_d.a(), Color.WHITE, engine.var_axy_d.a(), Color.BLACK, this.var_float_a, this.var_float_b + 157.0f, 1, 1);
                }
            } else if (this.var_int_a == 3) {
                if (this.var_boolean_d) {
                    engine.a(engine.var_agc_a.a(InputIdentifier.TARGET_ENEMY_3), engine.var_axy_d.a(), Color.YELLOW, engine.var_axy_d.a(), Color.BLACK, this.var_float_a, this.var_float_b + 157.0f, 1, 1);
                } else {
                    engine.a(engine.var_agc_a.a(InputIdentifier.TARGET_ENEMY_3), engine.var_axy_d.a(), Color.WHITE, engine.var_axy_d.a(), Color.BLACK, this.var_float_a, this.var_float_b + 157.0f, 1, 1);
                }
            }
        }
        this.var_agv_b.b(f2, engine);
    }

    public void void_a() {
        this.var_float_c = 0.0f;
        this.var_float_d = 45.0f;
    }

    public agv agv_a() {
        return this.var_agv_a;
    }

    public agv b() {
        return this.var_agv_b;
    }
}

