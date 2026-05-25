/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.player.shared.SharedAccountData;
import com.arenaofkings.packets.gameserver.data.resources.Energy;
import com.arenaofkings.packets.misc.CharacterClass;
import com.arenaofkings.packets.misc.InputIdentifier;
import com.arenaofkings.packets.misc.PartyRole;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;
import java.util.concurrent.TimeUnit;

public abstract class br
implements Comparable<br> {
    public boolean var_boolean_a = false;
    protected SharedAccountData var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a;
    protected int var_int_a;
    protected PartyRole var_com_arenaofkings_packets_misc_PartyRole_a;
    protected azv var_azv_a;
    protected azv var_azv_b = new azv(1500L, false);
    private boolean c = false;
    boolean var_boolean_b = false;

    public SharedAccountData com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a() {
        return this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a;
    }

    public void void_b() {
        if (this != ay.ay_a()) {
            this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().az_a().ar_a().void_b();
        }
        this.void_c();
        this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().cr_a().void_a();
    }

    public void b(float f2, Engine engine, ayh ayh2, ayh ayh3) {
        if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer() == this) {
            if (ay.ay_a().boolean_a(this) && engine.var_aj_a.boolean_a(ai.F)) {
                ayh2.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().az_a().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX() - 110.0f, this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY() - 79.0f);
                ayh2.b(f2, engine);
            } else if ((!this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().boolean_b() || this.c) && engine.var_aj_a.boolean_a(ai.F)) {
                ayh3.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().az_a().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX() - 110.0f, this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY() - 79.0f);
                ayh3.b(f2, engine);
            }
        } else if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getID() != -1 && ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().ui_a() != null && engine.var_aj_a.boolean_a(ai.F)) {
            ayh3.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().ui_a().hf_a().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX() - 117.0f, ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().ui_a().hf_a().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY() - 79.0f - 57.0f);
            ayh3.b(f2, engine);
        }
    }

    public void b(float f2, Engine engine) {
        if (this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().boolean_b() && !this.f()) {
            if (ay.ay_a().boolean_a(this)) {
                this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().com_arenaofkings_packets_gameserver_data_EffectManager_a().renderBack(f2, engine);
            }
        } else {
            this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().com_arenaofkings_packets_gameserver_data_EffectManager_a().renderBack(f2, engine);
        }
    }

    public void c(float f2, Engine engine) {
        if (this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().boolean_b() && !this.f()) {
            if (ay.ay_a().boolean_a(this)) {
                this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().com_arenaofkings_packets_gameserver_data_EffectManager_a().renderFront(f2, engine);
            }
        } else {
            this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().com_arenaofkings_packets_gameserver_data_EffectManager_a().renderFront(f2, engine);
        }
    }

    public void d(float f2, Engine engine) {
        this.var_boolean_a = true;
        if (this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().cr_a().da_a() != null) {
            this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().cr_a().a(f2);
            this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().cr_a().da_a().a(f2, engine);
            if (this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().com_arenaofkings_packets_gameserver_data_EffectManager_a().getEffects().size == 0) {
                this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().cr_a().da_a().com_badlogic_gdx_graphics_g2d_Sprite_a().setColor(Color.WHITE);
            } else {
                this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().cr_a().da_a().com_badlogic_gdx_graphics_g2d_Sprite_a().setColor(Color.WHITE);
                boolean bl2 = false;
                block12: for (int i2 = 0; i2 < this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().com_arenaofkings_packets_gameserver_data_EffectManager_a().getEffects().size && !bl2; ++i2) {
                    switch (this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().com_arenaofkings_packets_gameserver_data_EffectManager_a().getEffects().get(i2).op_a().com_arenaofkings_packets_gameserver_data_EffectList_a()) {
                        case DarkInoculation: {
                            bl2 = true;
                            this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().cr_a().da_a().com_badlogic_gdx_graphics_g2d_Sprite_a().setColor(axe.u);
                            continue block12;
                        }
                        case Shroud: {
                            bl2 = true;
                            this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().cr_a().da_a().com_badlogic_gdx_graphics_g2d_Sprite_a().setColor(axe.u);
                        }
                        case EtherealBindings: {
                            bl2 = true;
                            this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().cr_a().da_a().com_badlogic_gdx_graphics_g2d_Sprite_a().setColor(Color.YELLOW);
                            continue block12;
                        }
                        case Windstorm: {
                            bl2 = true;
                            this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().cr_a().da_a().com_badlogic_gdx_graphics_g2d_Sprite_a().setColor(Color.YELLOW);
                            continue block12;
                        }
                        case Enrage: {
                            bl2 = true;
                            this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().cr_a().da_a().com_badlogic_gdx_graphics_g2d_Sprite_a().setColor(Color.RED);
                            continue block12;
                        }
                        case Freeze: {
                            this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().cr_a().da_a().com_badlogic_gdx_graphics_g2d_Sprite_a().setColor(Color.BLUE);
                            continue block12;
                        }
                        case Chill: {
                            this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().cr_a().da_a().com_badlogic_gdx_graphics_g2d_Sprite_a().setColor(Color.BLUE);
                            continue block12;
                        }
                        case Hypothermia: {
                            this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().cr_a().da_a().com_badlogic_gdx_graphics_g2d_Sprite_a().setColor(Color.BLUE);
                            continue block12;
                        }
                        case ElementalArrow: {
                            this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().cr_a().da_a().com_badlogic_gdx_graphics_g2d_Sprite_a().setColor(Color.BLUE);
                            continue block12;
                        }
                        case Geyser: {
                            this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().cr_a().da_a().com_badlogic_gdx_graphics_g2d_Sprite_a().setColor(Color.BLUE);
                        }
                    }
                }
            }
            if (this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().boolean_b()) {
                if (ay.ay_a().boolean_a(this)) {
                    this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().cr_a().da_a().com_badlogic_gdx_graphics_g2d_Sprite_a().setAlpha(0.4f);
                } else {
                    System.out.println("stealthed?: " + this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().boolean_c());
                    System.out.println("DISTANCE: " + axp.float_a(ay.ay_a().double_a(), ay.ay_a().double_b(), this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX(), this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY()));
                    if (this.var_azv_a.boolean_b() && this.var_azv_a.boolean_a()) {
                        this.var_azv_a.void_b();
                        if (axp.float_a(ay.ay_a().double_a(), ay.ay_a().double_b(), this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX(), this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY()) <= 200.0f) {
                            this.var_boolean_b = true;
                            System.out.println("IN RANGE");
                        } else {
                            this.var_boolean_b = false;
                        }
                        this.var_azv_b = this.var_boolean_b ? new azv(875 + MathUtils.random(1450), true) : new azv(375 + MathUtils.random(850), true);
                        if (this.var_boolean_b && this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().boolean_c()) {
                            engine.var_baa_a.a(ajw.ci, this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX(), this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY(), 0.3f);
                        }
                        System.out.println("Restart stealthRevealHeartbeat");
                    }
                    if (this.var_azv_b.boolean_b() && this.var_azv_b.boolean_a()) {
                        this.var_azv_b.void_b();
                        this.var_azv_a.void_c();
                        System.out.println("stealthRevealHeartbeat.isDone()");
                    }
                    if (this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().boolean_c() && this.var_azv_b.boolean_a() && this.var_boolean_b) {
                        System.out.println("REVEAL PLAYER");
                        this.c = true;
                    } else {
                        this.c = false;
                    }
                    System.out.println("heartBeat: " + this.var_azv_a.a(TimeUnit.MILLISECONDS) + " revealBeat: " + this.var_azv_b.a(TimeUnit.MILLISECONDS) + " assassinStealthedButRevealable: " + this.c);
                    if (this.c) {
                        this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().cr_a().da_a().com_badlogic_gdx_graphics_g2d_Sprite_a().setAlpha(0.4f);
                    } else if (!this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().boolean_a()) {
                        this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().cr_a().da_a().com_badlogic_gdx_graphics_g2d_Sprite_a().setAlpha(0.4f);
                    } else {
                        this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().cr_a().da_a().com_badlogic_gdx_graphics_g2d_Sprite_a().setAlpha(0.0f);
                    }
                }
            }
            if (this == ay.ay_a() && !this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().boolean_a()) {
                this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().cr_a().h();
            }
            this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().cr_a().a(f2, engine.var_azi_a);
        } else {
            Engine.a("current animation is null");
        }
    }

    public azv azv_a() {
        return this.var_azv_b;
    }

    public void a(float f2, Engine engine, ayh ayh2, ayh ayh3) {
        if (this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().boolean_b() && !this.c && !ay.ay_a().boolean_a(this) && this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().boolean_a()) {
            return;
        }
        if (!this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().boolean_a()) {
            return;
        }
        this.a(f2, engine);
        if (this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().ahs_a() != null) {
            this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().ahs_a().b(f2, engine);
        }
        String string = this.java_lang_String_a();
        String string2 = "";
        Color color = null;
        if (string.equals("NONE")) {
            if (engine.var_aj_a.boolean_a(ai.m)) {
                string2 = this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().java_lang_String_a();
            } else if (engine.var_aj_a.boolean_a(ai.n)) {
                string2 = CharacterClass.simpleName(this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().com_arenaofkings_packets_misc_CharacterClass_a());
            } else if (engine.var_aj_a.boolean_a(ai.o)) {
                if (ay.ay_a().boolean_a(this)) {
                    if (this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().int_h() == 1) {
                        string2 = this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().java_lang_String_a();
                    } else if (this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().int_h() == 2) {
                        string2 = ay.ay_a().gd_a().boolean_b() ? this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().java_lang_String_a() : engine.var_agc_a.a(InputIdentifier.TARGET_ALLY_2);
                    } else if (this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().int_h() == 3) {
                        string2 = ay.ay_a().gd_a().boolean_b() ? this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().java_lang_String_a() : engine.var_agc_a.a(InputIdentifier.TARGET_ALLY_3);
                    }
                } else if (this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().int_h() == 1) {
                    string2 = ay.ay_a().gd_a().boolean_b() ? this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().java_lang_String_a() : engine.var_agc_a.a(InputIdentifier.TARGET_ENEMY_1);
                } else if (this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().int_h() == 2) {
                    string2 = ay.ay_a().gd_a().boolean_b() ? this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().java_lang_String_a() : engine.var_agc_a.a(InputIdentifier.TARGET_ENEMY_2);
                } else if (this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().int_h() == 3) {
                    string2 = ay.ay_a().gd_a().boolean_b() ? this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().java_lang_String_a() : engine.var_agc_a.a(InputIdentifier.TARGET_ENEMY_3);
                }
            } else if (engine.var_aj_a.boolean_a(ai.m)) {
                string2 = this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().java_lang_String_a();
            } else if (engine.var_aj_a.boolean_a(ai.p)) {
                string2 = String.valueOf(this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().int_h());
            }
        } else {
            string2 = string;
            color = Color.GOLD;
        }
        if (ay.ay_a().boolean_a(this)) {
            if (color == null) {
                color = this != ay.ay_a() ? Color.LIME : Color.SKY;
            }
            color = Color.WHITE;
            if (ay.ay_a() != this) {
                engine.a(string2, engine.var_axy_c.a(), Color.WHITE, engine.var_axy_c.a(), Color.BLACK, this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX() + 9.0f, this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY() + 172.0f, 1, 1);
            } else {
                engine.a(string2, engine.var_axy_c.a(), color, engine.var_axy_c.a(), Color.BLACK, this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX() + 9.0f, this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY() + 172.0f, 1, 1);
            }
        } else {
            if (color == null) {
                color = this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().db_a() == db.var_db_a ? Color.LIME : Color.RED;
            }
            engine.a(string2, engine.var_axy_c.a(), color, engine.var_axy_c.a(), Color.BLACK, this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX() + 9.0f, this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY() + 172.0f, 1, 1);
        }
        this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().com_arenaofkings_packets_gameserver_data_EffectManager_a().renderNameplateIcons(f2, engine, this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX(), this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY());
        if (ay.ay_a().boolean_a(this) && this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().com_arenaofkings_packets_misc_CharacterClass_a() == CharacterClass.ASSASSIN) {
            for (int i2 = 1; i2 <= 5; ++i2) {
                if (i2 <= ((Energy)this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().com_arenaofkings_packets_gameserver_data_resources_Resource_a()).getCombo_points()) {
                    ayh3.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX() - 57.0f + (float)(i2 * 16), this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY() + 116.0f);
                    ayh3.b(f2, engine);
                    continue;
                }
                ayh2.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX() - 57.0f + (float)(i2 * 16), this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY() + 116.0f);
                ayh2.b(f2, engine);
            }
        }
    }

    private String java_lang_String_a() {
        String string = "";
        oo oo2 = null;
        for (oo oo3 : this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().com_arenaofkings_packets_gameserver_data_EffectManager_a().getEffects()) {
            if (oo2 == null) {
                oo2 = oo3;
                continue;
            }
            oo2 = oq.a(oo2, oo3);
        }
        if (oo2 == null) {
            return "NONE";
        }
        string = oq.a(oo2).name();
        return string;
    }

    protected void a(float f2, Engine engine) {
        if (this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().ahs_a() != null) {
            this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().ahs_a().agv_a().a(this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().double_a(), this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().double_b());
            this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().ahs_a().b().a(this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().com_arenaofkings_packets_gameserver_data_resources_Resource_a().getCurrentValue(), this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().com_arenaofkings_packets_gameserver_data_resources_Resource_a().getMaxValue());
        }
    }

    public double double_a() {
        return this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX();
    }

    public double double_b() {
        return this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY();
    }

    public boolean boolean_b() {
        return this.var_boolean_a;
    }

    public void void_c() {
        this.var_boolean_a = false;
    }

    public int int_a() {
        return this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().int_i();
    }

    public void a(int n2) {
        if (ao.a(n2) != ao.a(this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().int_i())) {
            this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().bd_a().c(false);
        }
        this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().i(n2);
    }

    public boolean a(boolean bl2) {
        for (oo oo2 : this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().com_arenaofkings_packets_gameserver_data_EffectManager_a().getEffects()) {
            if (!(bl2 ? oo2.getClass() == ud.class || oo2.getClass() == tx.class || oo2.getClass() == tv.class || oo2.getClass() == tp.class || oo2.getClass() == uc.class || oo2.getClass() == ps.class : oo2.getClass() == ud.class || oo2.getClass() == tx.class || oo2.getClass() == tv.class || oo2.getClass() == tp.class || oo2.getClass() == ps.class)) continue;
            return true;
        }
        return false;
    }

    public boolean boolean_c() {
        for (oo oo2 : this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().com_arenaofkings_packets_gameserver_data_EffectManager_a().getEffects()) {
            if (oo2.getClass() != tp.class) continue;
            return true;
        }
        return false;
    }

    public boolean d() {
        for (oo oo2 : this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().com_arenaofkings_packets_gameserver_data_EffectManager_a().getEffects()) {
            if (oo2.getClass() != tv.class) continue;
            return true;
        }
        return false;
    }

    public boolean e() {
        for (oo oo2 : this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().com_arenaofkings_packets_gameserver_data_EffectManager_a().getEffects()) {
            if (oo2.getClass() != tv.class && oo2.getClass() != tp.class) continue;
            return true;
        }
        return false;
    }

    public int int_a(br br2) {
        if (this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY() >= br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY()) {
            return -1;
        }
        return 1;
    }

    public void void_a() {
    }

    public void b(int n2) {
        this.var_int_a = n2;
    }

    public int int_b() {
        return this.var_int_a;
    }

    public boolean f() {
        return this.c;
    }

    public PartyRole com_arenaofkings_packets_misc_PartyRole_a() {
        return this.var_com_arenaofkings_packets_misc_PartyRole_a;
    }

    public void a(PartyRole partyRole) {
        this.var_com_arenaofkings_packets_misc_PartyRole_a = partyRole;
    }

    @Override
    public /* synthetic */ int compareTo(Object object) {
        return this.int_a((br)object);
    }
}

