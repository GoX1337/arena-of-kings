/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.Array;
import java.util.Iterator;

public class hi {
    private Array<ui> var_com_badlogic_gdx_utils_Array_ui__a = new Array();
    private Color var_com_badlogic_gdx_graphics_Color_a;
    private Iterator<ui> var_java_util_Iterator_ui__a;

    public void a(ui ui2) {
        Engine.a("pre size: " + this.var_com_badlogic_gdx_utils_Array_ui__a.size);
        if (ui2 != null) {
            if (ui2.da_a() != null) {
                Engine.a("setting spritesheet stateTtime to 0");
                ui2.da_a().a(0.0f);
                if (ui2.da_a().a() != null) {
                    Engine.a("hard resetting spritesheet");
                    ui2.da_a().void_a();
                }
            }
            if (ui2.da_b() != null) {
                Engine.a("setting impact stateTime to 0");
                ui2.da_b().a(0.0f);
                if (ui2.da_b().a() != null) {
                    Engine.a("hard resetting impact");
                    ui2.da_b().void_a();
                }
            }
            if (ui2 instanceof ul) {
                ((gw)ui2.hf_a()).b(false);
                ((gw)ui2.hf_a()).a(false);
                Engine.a("collided is false");
            }
            if (ui2.azo_a() != null) {
                ui2.azo_a().a(false);
            }
            if (ui2.azo_b() != null) {
                ui2.azo_b().a(false);
            }
            Engine.a("adding spell: " + ui2.getClass().getSimpleName());
            this.var_com_badlogic_gdx_utils_Array_ui__a.add(ui2);
        } else {
            Engine.a("Spell is null --------------- didnt push it to spell list");
        }
        Engine.a("post size: " + this.var_com_badlogic_gdx_utils_Array_ui__a.size);
    }

    public void a(azi azi2) {
        this.var_com_badlogic_gdx_graphics_Color_a = azi2.getColor();
    }

    public void a(float f2, Engine engine, axm axm2) {
        for (ui ui2 : this.var_com_badlogic_gdx_utils_Array_ui__a) {
            Engine.a("we have a spell: " + ui2.getClass().getName());
            if (ui2.da_a() == null || !ui2.da_a().boolean_a()) {
                Engine.a("Loading animation gfx");
                ui2.a(axm2);
                Engine.a("Loaded animation gfx");
            }
            if (ui2.azo_a() != null && !ui2.boolean_b() && !ui2.azo_a().boolean_a()) {
                ui2.azo_a().a(axm2);
                if (ui2.azo_a().boolean_a()) {
                    System.out.println("Sound emph: " + ui2.azo_a().float_a());
                    if (ui2.hf_a() instanceof gw) {
                        engine.var_baa_a.a(ui2.azo_a().ajw_a(), ((gw)ui2.hf_a()).float_a(), ((gw)ui2.hf_a()).float_b(), ui2.azo_a().float_a() * 0.15f);
                    } else if (ui2.hf_a().a().isEmpty()) {
                        engine.var_baa_a.a(ui2.azo_a().ajw_a(), ui2.azo_a().float_a() * 0.15f);
                    } else {
                        engine.var_baa_a.a(ui2.azo_a().ajw_a(), ui2.hf_a().a().get(0).getX(), ui2.hf_a().a().get(0).getY(), ui2.azo_a().float_a() * 0.15f);
                    }
                }
            } else {
                if (ui2.azo_a() == null) {
                    Engine.a("sound effect is null");
                }
                if (ui2.boolean_b()) {
                    Engine.a("ignore sound effect");
                }
                if (ui2.azo_a() != null && ui2.azo_a().boolean_a()) {
                    Engine.a("spell sound is loaded");
                }
            }
            ui2.a(f2, engine);
            if (ui2.hf_a() instanceof gw) {
                if (ui2.da_a() == null || !ui2.da_a().boolean_a()) {
                    Engine.a("Loading projectile animation gfx");
                    ui2.a(axm2);
                    Engine.a("Loadedprojectile  animation gfx");
                }
                if (((gw)ui2.hf_a()).boolean_b()) {
                    Engine.b("Spells.update() - collided");
                    if (ui2.azo_b() != null && !ui2.boolean_b() && !ui2.azo_b().boolean_a()) {
                        ui2.azo_b().a(axm2);
                        if (ui2.azo_b().boolean_a()) {
                            if (ui2.hf_a().a().isEmpty()) {
                                engine.var_baa_a.a(ui2.azo_b().ajw_a(), ui2.azo_a().float_a() * 0.185f);
                            } else {
                                engine.var_baa_a.a(ui2.azo_b().ajw_a(), ui2.hf_a().a().get(0).getX(), ui2.hf_a().a().get(0).getY(), ui2.azo_a().float_a() * 0.185f);
                            }
                        }
                    }
                    if (ui2.da_b() != null) {
                        ((gw)ui2.hf_a()).a(true);
                    }
                    if (ui2.da_b() != null && (ui2.da_b() == null || !ui2.da_b().boolean_b())) continue;
                    if (ui2.da_b() == null) {
                        Engine.a("impact animation is null");
                    } else {
                        Engine.a("impact animation isn't null");
                        if (ui2.da_b().boolean_b()) {
                            Engine.a("impact is done");
                        } else {
                            Engine.a("impact animation is not done");
                        }
                    }
                    Engine.a("proj 2");
                    Engine.a("TargetedProjectileSpell collided, removing it from world.");
                    ui2.a().clear();
                    this.var_com_badlogic_gdx_utils_Array_ui__a.remove();
                    continue;
                }
                if (ui2.hf_a().azv_a().long_a() < 0L || !ui2.hf_a().azv_a().boolean_b()) continue;
                Engine.a("proj 3");
                Engine.a("TargetedProjectileSpell expired, removing it from world.");
                ui2.a().clear();
                this.var_com_badlogic_gdx_utils_Array_ui__a.remove();
                continue;
            }
            if (ui2.hf_a().azv_a().long_a() >= 0L) {
                if (ui2.da_a() != null && ui2.hf_a().azv_a().boolean_b()) {
                    Engine.a("Spell expired, removing it from world.");
                    if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().ui_a() == ui2) {
                        ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().a((ui)null);
                    }
                    if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a() != null && ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getID() == ui2.int_a()) {
                        ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().setData("", -1);
                    }
                    ui2.a().clear();
                    this.var_com_badlogic_gdx_utils_Array_ui__a.remove();
                    continue;
                }
                if (ui2.da_a() != null) continue;
                Engine.a("1 spell.getSpriteSheetAnimation() is null .. Removing spell");
                ui2.a().clear();
                this.var_com_badlogic_gdx_utils_Array_ui__a.remove();
                continue;
            }
            if (ui2.da_a() != null && (ui2.hf_a().azv_a().boolean_b() || ui2.da_a().boolean_b())) {
                if (ui2.hf_a().azv_a().boolean_b()) {
                    Engine.a("alive timer is done");
                }
                if (ui2.da_a().boolean_b()) {
                    Engine.a("sprite animation is done");
                }
                Engine.a("Removing spell");
                ui2.a().clear();
                this.var_com_badlogic_gdx_utils_Array_ui__a.remove();
                if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().ui_a() == ui2) {
                    ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().a((ui)null);
                }
                if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a() != null && ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getID() == ui2.int_a()) {
                    ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().setData("", -1);
                }
                Engine.a("Removed spell");
                continue;
            }
            if (ui2.da_a() != null) continue;
            Engine.a("2 spell.getSpriteSheetAnimation() is null .. Removing spell");
            if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().ui_a() == ui2) {
                ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().a((ui)null);
            }
            if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a() != null && ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getID() == ui2.int_a()) {
                ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().setData("", -1);
            }
            ui2.a().clear();
            this.var_com_badlogic_gdx_utils_Array_ui__a.remove();
        }
    }

    public void a(float f2, Engine engine, Array<axi> array, boolean bl2) {
        if (!bl2) {
            for (ui ui2 : this.var_com_badlogic_gdx_utils_Array_ui__a) {
                if (ui2.da_a() == null) continue;
                if (ui2.da_a().float_c() == 0.0f) {
                    Engine.a("transparency a: " + ui2.da_a().float_c());
                    continue;
                }
                Engine.a("XD1 " + (Object)((Object)ui2.hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a()));
                if (ui2.da_a().boolean_c()) continue;
                if (ui2.br_a() != null && ui2.br_a().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().boolean_b() && !ui2.br_a().f()) {
                    if (ay.ay_a().boolean_a(ui2.br_a())) {
                        ui2.a(f2, engine, true);
                        continue;
                    }
                    if (ui2.hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a() != SpellName.Stealth) continue;
                    ui2.a(f2, engine, true);
                    continue;
                }
                ui2.a(f2, engine, true);
            }
        } else {
            for (ui ui3 : this.var_com_badlogic_gdx_utils_Array_ui__a) {
                if (ui3.da_a() == null) continue;
                if (ui3.da_a().float_c() == 0.0f) {
                    Engine.a("transparency b: " + ui3.da_a().float_c());
                    continue;
                }
                Engine.a("XD2 " + (Object)((Object)ui3.hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a()));
                if (ui3.da_a().boolean_c()) continue;
                for (axi axi2 : array) {
                    if (ui3.da_a() == null || ui3.da_a().com_badlogic_gdx_graphics_g2d_Sprite_a() == null || ui3.da_a().com_badlogic_gdx_graphics_g2d_Sprite_a().getBoundingRectangle() == null || ui3.da_a().com_badlogic_gdx_graphics_g2d_Sprite_a().getBoundingRectangle().overlaps(axi2.com_badlogic_gdx_graphics_g2d_Sprite_a().getBoundingRectangle())) continue;
                    Engine.a("overlap " + axi2.java_lang_String_a() + " " + axi2.com_badlogic_gdx_graphics_g2d_Sprite_a().getRegionWidth() + " " + axi2.com_badlogic_gdx_graphics_g2d_Sprite_a().getRegionHeight());
                }
                if (ui3.br_a() != null && ui3.br_a().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().boolean_b() && !ui3.br_a().f()) {
                    if (ay.ay_a().boolean_a(ui3.br_a())) {
                        ui3.a(f2, engine, true);
                        continue;
                    }
                    if (ui3.hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a() != SpellName.Stealth) continue;
                    ui3.a(f2, engine, true);
                    continue;
                }
                ui3.a(f2, engine, true);
            }
        }
    }

    public void a(float f2, Engine engine) {
        for (ui ui2 : this.var_com_badlogic_gdx_utils_Array_ui__a) {
            if (ui2.da_a() == null) continue;
            if (ui2.br_a() != null && ui2.br_a().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().boolean_b() && !ui2.br_a().f()) {
                if (ay.ay_a().boolean_a(ui2.br_a())) {
                    ui2.c(f2, engine);
                    continue;
                }
                if (ui2.hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a() != SpellName.Stealth) continue;
                ui2.c(f2, engine);
                continue;
            }
            ui2.c(f2, engine);
        }
    }

    public void a(float f2, azi azi2) {
        for (ui ui2 : this.var_com_badlogic_gdx_utils_Array_ui__a) {
            ui2.a(f2, azi2);
        }
    }

    public Array<ui> a() {
        return this.var_com_badlogic_gdx_utils_Array_ui__a;
    }

    public void a(String string, SpellName spellName) {
        Iterator iterator = this.var_com_badlogic_gdx_utils_Array_ui__a.iterator();
        while (iterator.hasNext()) {
            ui ui2 = (ui)iterator.next();
            if (ui2.hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a() != spellName || !ui2.br_a().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().java_lang_String_a().equals(string)) continue;
            if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a() != null && ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getID() == ui2.int_a()) {
                ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().setData("", -1);
            }
            if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().ui_a() != null && ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().ui_a().int_a() == ui2.int_a()) {
                ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().a((ui)null);
            }
            ui2.a().clear();
            iterator.remove();
            break;
        }
    }
}

