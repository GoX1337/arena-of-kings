/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.gameserver.data;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.EffectList;
import com.arenaofkings.packets.gameserver.data.HitCircle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.Array;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public class EffectManager {
    private final Engine engine;
    private az movementManager;
    private Array<oo> allEffects = new Array();
    private Array<oo> buffs = new Array();
    private Array<oo> debuffs = new Array();
    private Array<oo> statusAilments = new Array();
    private Array<oo> removeList = new Array();
    private ayh debuffDivider;
    private int nameplateRow = 0;
    private int nameplatePos = 0;

    public EffectManager(Engine engine) {
        this.engine = engine;
    }

    public void init(axm axm2) {
        this.debuffDivider = new ayh(0, 0, axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.e), "debuff_separator", true);
        this.allEffects.clear();
        this.buffs.clear();
        this.debuffs.clear();
        this.statusAilments.clear();
    }

    public void clear() {
        this.allEffects.clear();
        this.buffs.clear();
        this.debuffs.clear();
        this.statusAilments.clear();
    }

    public oo getPriorityEffect() {
        oq oq2 = oq.k;
        oo oo2 = null;
        Iterator iterator = this.allEffects.iterator();
        while (iterator.hasNext()) {
            if (oo2 == null) {
                oo2 = (oo)iterator.next();
                oq2 = oq.a(oo2);
                continue;
            }
            oo oo3 = (oo)iterator.next();
            oo2 = oq.a(oo2, oo3);
            oq2 = oq.a(oo2);
        }
        if (oq2 == oq.k) {
            return null;
        }
        return oo2;
    }

    public Array<oo> getEffects() {
        return this.allEffects;
    }

    public void push(oo oo2) {
        Engine.a("PRE PUSH: size " + this.allEffects.size + " buffs size: " + this.buffs.size);
        for (oo oo3 : this.allEffects) {
            Engine.a("PRE AllList: " + (Object)((Object)oo3.op_a().com_arenaofkings_packets_gameserver_data_EffectList_a()) + " " + (Object)((Object)oo3.op_a().com_arenaofkings_packets_gameserver_data_EffectList_b()) + " " + oo3.azv_a().a(TimeUnit.MILLISECONDS));
        }
        for (oo oo3 : this.buffs) {
            Engine.a("PRE BuffList: " + (Object)((Object)oo3.op_a().com_arenaofkings_packets_gameserver_data_EffectList_a()) + " " + (Object)((Object)oo3.op_a().com_arenaofkings_packets_gameserver_data_EffectList_b()) + " " + oo3.azv_a().a(TimeUnit.MILLISECONDS));
        }
        if (oo2 != null) {
            switch (oo2.ot_a()) {
                case var_ot_a: {
                    this.buffs.add(oo2);
                    break;
                }
                case b: {
                    this.debuffs.add(oo2);
                    break;
                }
                case c: {
                    this.statusAilments.add(oo2);
                    break;
                }
            }
            this.allEffects.add(oo2);
            Engine.a("new effect added");
        }
        Engine.a("sound inc");
        if (oo2.azo_a() != null && !oo2.azo_a().boolean_a()) {
            Engine.a("sound inc 2");
            oo2.azo_a().a(this.engine.axc_a().axm_a());
            Engine.a("sound inc 3");
            if (oo2.azo_a().boolean_a()) {
                Engine.a("sound inc 4");
                this.engine.var_baa_a.a(oo2.azo_a().ajw_a(), 0.15f);
            }
        }
        Engine.a("POST PUSH: size " + this.allEffects.size + " buffs size: " + this.buffs.size);
        for (oo oo3 : this.allEffects) {
            Engine.a("POST AllList: " + (Object)((Object)oo3.op_a().com_arenaofkings_packets_gameserver_data_EffectList_a()) + " " + (Object)((Object)oo3.op_a().com_arenaofkings_packets_gameserver_data_EffectList_b()) + " " + oo3.azv_a().a(TimeUnit.MILLISECONDS));
        }
        for (oo oo3 : this.buffs) {
            Engine.a("POST BuffList: " + (Object)((Object)oo3.op_a().com_arenaofkings_packets_gameserver_data_EffectList_a()) + " " + (Object)((Object)oo3.op_a().com_arenaofkings_packets_gameserver_data_EffectList_b()) + " " + oo3.azv_a().a(TimeUnit.MILLISECONDS));
        }
        oo2.c();
        this.movementManager.void_d();
    }

    public void remove(EffectList effectList) {
        oo oo2;
        Iterator iterator = this.allEffects.iterator();
        while (iterator.hasNext()) {
            oo2 = (oo)iterator.next();
            if (oo2.op_a().com_arenaofkings_packets_gameserver_data_EffectList_a() != effectList && oo2.op_a().com_arenaofkings_packets_gameserver_data_EffectList_b() != effectList) continue;
            Engine.a("REMOVING EFFECT");
            oo2.void_b();
            iterator.remove();
            break;
        }
        iterator = this.buffs.iterator();
        while (iterator.hasNext()) {
            oo2 = (oo)iterator.next();
            if (oo2.op_a().com_arenaofkings_packets_gameserver_data_EffectList_a() != effectList && oo2.op_a().com_arenaofkings_packets_gameserver_data_EffectList_b() != effectList) continue;
            Engine.a("REMOVING EFFECT");
            iterator.remove();
            break;
        }
        iterator = this.debuffs.iterator();
        while (iterator.hasNext()) {
            oo2 = (oo)iterator.next();
            if (oo2.op_a().com_arenaofkings_packets_gameserver_data_EffectList_a() != effectList && oo2.op_a().com_arenaofkings_packets_gameserver_data_EffectList_b() != effectList) continue;
            Engine.a("REMOVING EFFECT");
            iterator.remove();
            break;
        }
        iterator = this.statusAilments.iterator();
        while (iterator.hasNext()) {
            oo2 = (oo)iterator.next();
            if (oo2.op_a().com_arenaofkings_packets_gameserver_data_EffectList_a() != effectList && oo2.op_a().com_arenaofkings_packets_gameserver_data_EffectList_b() != effectList) continue;
            Engine.a("REMOVING EFFECT");
            iterator.remove();
            break;
        }
        this.movementManager.void_d();
    }

    public void renderBack(float f2, Engine engine) {
        for (int i2 = 0; i2 < this.allEffects.size; ++i2) {
            oo oo2 = this.allEffects.get(i2);
            oo2.a(f2, engine);
            oo2.a(f2, engine, i2);
        }
    }

    public void renderFront(float f2, Engine engine) {
        for (int i2 = 0; i2 < this.allEffects.size; ++i2) {
            oo oo2 = this.allEffects.get(i2);
            oo2.b(f2, engine, i2);
        }
    }

    public void renderIcons(float f2, Engine engine) {
        block17: {
            oo oo2;
            int n2;
            block16: {
                for (n2 = 0; n2 < this.buffs.size; ++n2) {
                    oo2 = this.buffs.get(n2);
                    oo2.a(f2, engine, oo2.azv_a(), 0, n2);
                }
                for (n2 = 0; n2 < this.buffs.size; ++n2) {
                    oo2 = this.buffs.get(n2);
                    oo2.b(f2, engine, oo2.azv_a(), 0, n2);
                }
                for (n2 = 0; n2 < this.buffs.size; ++n2) {
                    oo2 = this.buffs.get(n2);
                    oo2.c(f2, engine, oo2.azv_a(), 0, n2);
                }
                for (n2 = 0; n2 < this.buffs.size; ++n2) {
                    oo2 = this.buffs.get(n2);
                    oo2.d(f2, engine, oo2.azv_a(), 0, n2);
                }
                for (n2 = 0; n2 < this.debuffs.size; ++n2) {
                    oo2 = this.debuffs.get(n2);
                    oo2.a(f2, engine, oo2.azv_a(), 1, n2);
                }
                for (n2 = 0; n2 < this.debuffs.size; ++n2) {
                    oo2 = this.debuffs.get(n2);
                    oo2.b(f2, engine, oo2.azv_a(), 1, n2);
                }
                for (n2 = 0; n2 < this.debuffs.size; ++n2) {
                    oo2 = this.debuffs.get(n2);
                    oo2.c(f2, engine, oo2.azv_a(), 1, n2);
                }
                for (n2 = 0; n2 < this.debuffs.size; ++n2) {
                    oo2 = this.debuffs.get(n2);
                    oo2.d(f2, engine, oo2.azv_a(), 1, n2);
                }
                if (this.debuffs.size != 0 || this.statusAilments.size <= 0) break block16;
                this.debuffDivider.a(f2, engine.var_azi_a, (int)this.statusAilments.get(0).op_a().com_badlogic_gdx_graphics_g2d_Sprite_a().getX() + 29, (int)this.statusAilments.get(0).op_a().com_badlogic_gdx_graphics_g2d_Sprite_a().getY() - 80, 1.0f);
                this.debuffDivider.a(f2, engine.var_azi_a, (int)this.statusAilments.get(0).op_a().com_badlogic_gdx_graphics_g2d_Sprite_a().getX() + 29, (int)this.statusAilments.get(0).op_a().com_badlogic_gdx_graphics_g2d_Sprite_a().getY() - 80, 1.0f);
                for (n2 = 0; n2 < this.statusAilments.size; ++n2) {
                    oo2 = this.statusAilments.get(n2);
                    oo2.a(f2, engine, oo2.azv_a(), 1, n2 + 1);
                }
                for (n2 = 0; n2 < this.statusAilments.size; ++n2) {
                    oo2 = this.statusAilments.get(n2);
                    oo2.b(f2, engine, oo2.azv_a(), 1, n2 + 1);
                }
                for (n2 = 0; n2 < this.statusAilments.size; ++n2) {
                    oo2 = this.statusAilments.get(n2);
                    oo2.c(f2, engine, oo2.azv_a(), 1, n2 + 1);
                }
                for (n2 = 0; n2 < this.statusAilments.size; ++n2) {
                    oo2 = this.statusAilments.get(n2);
                    oo2.d(f2, engine, oo2.azv_a(), 1, n2 + 1);
                }
                break block17;
            }
            if (this.debuffs.size <= 0 || this.statusAilments.size <= 0) break block17;
            this.debuffDivider.a(f2, engine.var_azi_a, (int)this.statusAilments.get(0).op_a().com_badlogic_gdx_graphics_g2d_Sprite_a().getX() - this.debuffs.size * 58 + 14, (int)this.statusAilments.get(0).op_a().com_badlogic_gdx_graphics_g2d_Sprite_a().getY() - 80, 1.0f);
            this.debuffDivider.a(f2, engine.var_azi_a, (int)this.statusAilments.get(0).op_a().com_badlogic_gdx_graphics_g2d_Sprite_a().getX() - this.debuffs.size * 58 + 14, (int)this.statusAilments.get(0).op_a().com_badlogic_gdx_graphics_g2d_Sprite_a().getY() - 80, 1.0f);
            for (n2 = 0; n2 < this.statusAilments.size; ++n2) {
                oo2 = this.statusAilments.get(n2);
                oo2.a(f2, engine, oo2.azv_a(), 1, n2 + (this.debuffs.size + 1));
            }
            for (n2 = 0; n2 < this.statusAilments.size; ++n2) {
                oo2 = this.statusAilments.get(n2);
                oo2.b(f2, engine, oo2.azv_a(), 1, n2 + (this.debuffs.size + 1));
            }
            for (n2 = 0; n2 < this.statusAilments.size; ++n2) {
                oo2 = this.statusAilments.get(n2);
                oo2.c(f2, engine, oo2.azv_a(), 1, n2 + (this.debuffs.size + 1));
            }
            for (n2 = 0; n2 < this.statusAilments.size; ++n2) {
                oo2 = this.statusAilments.get(n2);
                oo2.d(f2, engine, oo2.azv_a(), 1, n2 + (this.debuffs.size + 1));
            }
        }
    }

    public void updateEffectTimer(EffectList effectList, float f2, int n2) {
        oo oo2 = null;
        oo oo3 = null;
        Iterator iterator = this.allEffects.iterator();
        boolean bl2 = false;
        while (iterator.hasNext()) {
            oo2 = (oo)iterator.next();
            if (oo2.op_a().com_arenaofkings_packets_gameserver_data_EffectList_a() != effectList && oo2.op_a().com_arenaofkings_packets_gameserver_data_EffectList_b() != effectList) continue;
            bl2 = true;
            iterator.remove();
            break;
        }
        iterator = this.buffs.iterator();
        while (iterator.hasNext()) {
            oo3 = (oo)iterator.next();
            if (oo3.op_a().com_arenaofkings_packets_gameserver_data_EffectList_a() != effectList && oo3.op_a().com_arenaofkings_packets_gameserver_data_EffectList_b() != effectList) continue;
            iterator.remove();
            break;
        }
        iterator = this.debuffs.iterator();
        while (iterator.hasNext()) {
            oo3 = (oo)iterator.next();
            if (oo3.op_a().com_arenaofkings_packets_gameserver_data_EffectList_a() != effectList && oo3.op_a().com_arenaofkings_packets_gameserver_data_EffectList_b() != effectList) continue;
            iterator.remove();
            break;
        }
        iterator = this.statusAilments.iterator();
        while (iterator.hasNext()) {
            oo3 = (oo)iterator.next();
            if (oo3.op_a().com_arenaofkings_packets_gameserver_data_EffectList_a() != effectList && oo3.op_a().com_arenaofkings_packets_gameserver_data_EffectList_b() != effectList) continue;
            iterator.remove();
            break;
        }
        if (bl2 && oo2 != null && !this.contains(oo2.op_a().com_arenaofkings_packets_gameserver_data_EffectList_a()) && !this.contains(oo2.op_a().com_arenaofkings_packets_gameserver_data_EffectList_b())) {
            oo2.azv_a().void_b();
            oo2.a(new azv((long)f2, true));
            oo2.a(n2);
            oo2.void_a();
            this.push(oo2);
        }
    }

    public void removeExpiredEffects() {
        int n2;
        if (this.allEffects.size > 0) {
            for (n2 = 0; n2 < this.allEffects.size; ++n2) {
                if (!this.allEffects.get(n2).azv_a().boolean_b()) continue;
                this.allEffects.get(n2).void_b();
                this.removeList.add(this.allEffects.get(n2));
            }
            if (this.removeList.size > 0) {
                this.allEffects.removeAll(this.removeList, true);
                this.removeList.clear();
            }
        }
        if (this.buffs.size > 0) {
            for (n2 = 0; n2 < this.buffs.size; ++n2) {
                if (!this.buffs.get(n2).azv_a().boolean_b()) continue;
                this.buffs.get(n2).void_b();
                this.removeList.add(this.buffs.get(n2));
            }
            if (this.removeList.size > 0) {
                this.buffs.removeAll(this.removeList, true);
                this.removeList.clear();
            }
        }
        if (this.debuffs.size > 0) {
            for (n2 = 0; n2 < this.debuffs.size; ++n2) {
                if (!this.debuffs.get(n2).azv_a().boolean_b()) continue;
                this.debuffs.get(n2).void_b();
                this.removeList.add(this.debuffs.get(n2));
            }
            if (this.removeList.size > 0) {
                this.debuffs.removeAll(this.removeList, true);
                this.removeList.clear();
            }
        }
        if (this.statusAilments.size > 0) {
            for (n2 = 0; n2 < this.statusAilments.size; ++n2) {
                if (!this.statusAilments.get(n2).azv_a().boolean_b()) continue;
                this.statusAilments.get(n2).void_b();
                this.removeList.add(this.statusAilments.get(n2));
            }
            if (this.removeList.size > 0) {
                this.statusAilments.removeAll(this.removeList, true);
                this.removeList.clear();
            }
        }
        this.movementManager.void_d();
    }

    public void handleExpired(br br2) {
    }

    public void setMovementManager(az az2) {
        this.movementManager = az2;
    }

    public boolean contains(EffectList effectList) {
        for (oo oo2 : this.allEffects) {
            if (oo2.op_a().com_arenaofkings_packets_gameserver_data_EffectList_a() != effectList && oo2.op_a().com_arenaofkings_packets_gameserver_data_EffectList_b() != effectList) continue;
            return true;
        }
        return false;
    }

    public boolean isRooted() {
        for (oo oo2 : this.allEffects) {
            if (oo2.op_a().com_arenaofkings_packets_gameserver_data_EffectList_a() != EffectList.Charge && oo2.op_a().com_arenaofkings_packets_gameserver_data_EffectList_a() != EffectList.CripplingSlash && oo2.op_a().com_arenaofkings_packets_gameserver_data_EffectList_a() != EffectList.Crystallize && oo2.op_a().com_arenaofkings_packets_gameserver_data_EffectList_a() != EffectList.DeathsGrasp && oo2.op_a().com_arenaofkings_packets_gameserver_data_EffectList_a() != EffectList.EtherealBindings && oo2.op_a().com_arenaofkings_packets_gameserver_data_EffectList_a() != EffectList.FlashFreeze && oo2.op_a().com_arenaofkings_packets_gameserver_data_EffectList_a() != EffectList.Freeze && oo2.op_a().com_arenaofkings_packets_gameserver_data_EffectList_a() != EffectList.GraspingVines && oo2.op_a().com_arenaofkings_packets_gameserver_data_EffectList_a() != EffectList.Slash && oo2.op_a().com_arenaofkings_packets_gameserver_data_EffectList_a() != EffectList.Windstorm) continue;
            return true;
        }
        return false;
    }

    public void renderNameplateIcons(float f2, Engine engine, float f3, float f4) {
        this.nameplateRow = 0;
        this.nameplatePos = 0;
        for (int i2 = 0; i2 < this.allEffects.size; ++i2) {
            if (this.allEffects.get(i2).br_b() != ay.ay_a() && (this.allEffects.get(i2).com_arenaofkings_packets_gameserver_data_EffectList_a() == null || this.allEffects.get(i2).com_arenaofkings_packets_gameserver_data_EffectList_a() != EffectList.Stun && this.allEffects.get(i2).com_arenaofkings_packets_gameserver_data_EffectList_a() != EffectList.Fear)) continue;
            if (i2 > 0 && i2 % 5 == 0) {
                ++this.nameplateRow;
                this.nameplatePos = 0;
            }
            oo oo2 = this.allEffects.get(i2);
            oo2.op_a().com_badlogic_gdx_graphics_g2d_Sprite_a().setScale(0.5f);
            oo2.op_a().com_badlogic_gdx_graphics_g2d_Sprite_a().setFlip(false, false);
            float f5 = 0.0f;
            float f6 = 0.0f;
            if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer() == null || ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer() == oo2.br_a()) {
                f5 = f3 - 68.0f + (float)(this.nameplatePos * 28);
                f6 = f4 + 162.0f + (float)(this.nameplateRow * 30);
                oo2.op_a().a(f2, engine.var_azi_a, f5, f6, 1.0f);
                if (this.allEffects.get(i2).azv_a().int_a() < 500 && this.allEffects.get(i2).com_arenaofkings_packets_gameserver_data_EffectList_a() != EffectList.SpiritWolf && this.allEffects.get(i2).com_arenaofkings_packets_gameserver_data_EffectList_a() != EffectList.Bear && this.allEffects.get(i2).com_arenaofkings_packets_gameserver_data_EffectList_a() != EffectList.DarkInoculation) {
                    oo2.da_a().a(f5 - 1.0f, f6 - 1.0f);
                    oo2.da_a().a(oo2.da_a().float_a() + f2 * 60.0f);
                    oo2.da_a().a(oo2.da_a().float_a(), engine.var_azi_a);
                }
                if (this.allEffects.get(i2).azv_a().int_a() < 30 && (float)this.allEffects.get(i2).azv_a().int_b() > 0.0f) {
                    if (oo2.azv_a().int_a() > 2) {
                        engine.a(String.valueOf(oo2.azv_a().int_a()), engine.var_axy_c.a(), Color.WHITE, engine.var_axy_c.a(), Color.BLACK, f5 + 24.0f, f6 + 29.0f, 1, 1);
                    } else if (oo2.azv_a().int_a() <= 2 && oo2.azv_a().int_a() > 1) {
                        engine.a("2", engine.var_axy_c.a(), Color.RED, engine.var_axy_c.a(), Color.BLACK, f5 + 24.0f, f6 + 29.0f, 1, 1);
                    } else if (oo2.azv_a().int_a() <= 1 && oo2.azv_a().int_b() >= 500) {
                        engine.a("1", engine.var_axy_c.a(), Color.RED, engine.var_axy_c.a(), Color.BLACK, f5 + 24.0f, f6 + 29.0f, 1, 1);
                    } else if (oo2.azv_a().int_b() >= 500) {
                        engine.a(String.valueOf(oo2.azv_a().int_a()), engine.var_axy_c.a(), Color.WHITE, engine.var_axy_c.a(), Color.BLACK, f5 + 24.0f, f6 + 29.0f, 1, 1);
                    }
                }
                if (this.allEffects.get(i2).boolean_a()) {
                    engine.a(String.valueOf(oo2.java_lang_String_b()), engine.var_axy_c.a(), Color.WHITE, engine.var_axy_c.a(), Color.BLACK, f5 + 14.0f, f6 + 16.0f, 8, 1);
                    engine.a(String.valueOf(oo2.java_lang_String_a()), engine.var_axy_c.a(), Color.GREEN, engine.var_axy_c.a(), Color.BLACK, f5 + 14.0f, f6 + 16.0f, 8, 1);
                }
            } else {
                f5 = f3 - 68.0f + (float)(this.nameplatePos * 28);
                f6 = f4 + 162.0f + (float)(this.nameplateRow * 30);
                oo2.op_a().a(f2, engine.var_azi_a, f5, f6, 0.6f);
                if (this.allEffects.get(i2).azv_a().int_a() < 500 && this.allEffects.get(i2).com_arenaofkings_packets_gameserver_data_EffectList_a() != EffectList.SpiritWolf && this.allEffects.get(i2).com_arenaofkings_packets_gameserver_data_EffectList_a() != EffectList.Bear && this.allEffects.get(i2).com_arenaofkings_packets_gameserver_data_EffectList_a() != EffectList.DarkInoculation) {
                    oo2.da_a().a(f5 - 1.0f, f6 - 1.0f);
                    oo2.da_a().a(oo2.da_a().float_a() + f2 * 60.0f);
                    oo2.da_a().a(oo2.da_a().float_a(), engine.var_azi_a);
                }
                if (this.allEffects.get(i2).azv_a().int_a() < 30 && (float)this.allEffects.get(i2).azv_a().int_b() > 0.0f) {
                    if (oo2.azv_a().int_a() > 2) {
                        engine.a(String.valueOf(oo2.azv_a().int_a()), engine.var_axy_c.a(), Color.WHITE, engine.var_axy_c.a(), Color.BLACK, f5 + 24.0f, f6 + 29.0f, 1, 1);
                    } else if (oo2.azv_a().int_a() <= 2 && oo2.azv_a().int_a() > 1) {
                        engine.a("2", engine.var_axy_c.a(), Color.RED, engine.var_axy_c.a(), Color.BLACK, f5 + 24.0f, f6 + 29.0f, 1, 1);
                    } else if (oo2.azv_a().int_a() <= 1 && oo2.azv_a().int_b() >= 500) {
                        engine.a("1", engine.var_axy_c.a(), Color.RED, engine.var_axy_c.a(), Color.BLACK, f5 + 24.0f, f6 + 29.0f, 1, 1);
                    } else if (oo2.azv_a().int_b() >= 500) {
                        engine.a(String.valueOf(oo2.azv_a().int_a()), engine.var_axy_c.a(), Color.WHITE, engine.var_axy_c.a(), Color.BLACK, f5 + 24.0f, f6 + 29.0f, 1, 1);
                    }
                }
                if (this.allEffects.get(i2).boolean_a()) {
                    engine.a(String.valueOf(oo2.java_lang_String_b()), engine.var_axy_c.a(), Color.WHITE, engine.var_axy_c.a(), Color.BLACK, f5 + 14.0f, f6 + 16.0f, 8, 1);
                    engine.a(String.valueOf(oo2.java_lang_String_a()), engine.var_axy_c.a(), Color.GREEN, engine.var_axy_c.a(), Color.BLACK, f5 + 14.0f, f6 + 16.0f, 8, 1);
                }
            }
            oo2.op_a().com_badlogic_gdx_graphics_g2d_Sprite_a().setScale(0.0f);
            oo2.op_a().com_badlogic_gdx_graphics_g2d_Sprite_a().setFlip(false, false);
            ++this.nameplatePos;
        }
    }

    public void renderTopHudIconsAlly(float f2, Engine engine, HitCircle hitCircle) {
        int n2;
        int n3;
        oo oo2;
        int n4;
        this.nameplatePos = 0;
        this.nameplateRow = 0;
        for (n4 = 0; n4 < this.buffs.size; ++n4) {
            if (this.buffs.get(n4).com_arenaofkings_packets_gameserver_data_EffectList_a() == null) continue;
            if (n4 > 0 && n4 % 5 == 0) {
                this.nameplatePos = 0;
                ++this.nameplateRow;
            }
            oo2 = this.buffs.get(n4);
            System.out.println("SIZE: " + this.buffs.size + "  Render buff effect " + (Object)((Object)oo2.com_arenaofkings_packets_gameserver_data_EffectList_a()) + " index: " + n4);
            oo2.op_a().com_badlogic_gdx_graphics_g2d_Sprite_a().setScale(0.5f);
            oo2.op_a().com_badlogic_gdx_graphics_g2d_Sprite_a().setFlip(false, false);
            n3 = 0;
            n2 = 0;
            n3 = (int)hitCircle.getX() - 68 + this.nameplatePos * 28;
            n2 = (int)hitCircle.getY() + 162 - this.nameplateRow * 30;
            System.out.println("b2 " + n3 + "," + n2);
            oo2.op_a().a(f2, engine.var_azi_a, n3, n2, 1.0f);
            if (this.buffs.get(n4).azv_a().int_a() < 500 && this.buffs.get(n4).com_arenaofkings_packets_gameserver_data_EffectList_a() != EffectList.SpiritWolf && this.buffs.get(n4).com_arenaofkings_packets_gameserver_data_EffectList_a() != EffectList.Bear && this.buffs.get(n4).com_arenaofkings_packets_gameserver_data_EffectList_a() != EffectList.DarkInoculation) {
                oo2.da_b().a((float)(n3 - 1), n2 - 1);
                oo2.da_b().a(oo2.da_b().float_a() + f2 * 60.0f);
                oo2.da_b().a(oo2.da_b().float_a(), engine.var_azi_a);
            }
            oo2.op_a().a(f2, engine, this.nameplateRow, this.nameplatePos);
            if (this.buffs.get(n4).azv_a().int_a() < 30 && (float)this.buffs.get(n4).azv_a().int_b() > 0.0f) {
                if (oo2.azv_a().int_a() > 2) {
                    engine.a(String.valueOf(oo2.azv_a().int_a()), engine.var_axy_c.a(), Color.WHITE, engine.var_axy_c.a(), Color.BLACK, (float)(n3 + 24), (float)(n2 + 30), 1, 1);
                } else if (oo2.azv_a().int_a() <= 2 && oo2.azv_a().int_a() > 1) {
                    engine.a("2", engine.var_axy_c.a(), Color.RED, engine.var_axy_c.a(), Color.BLACK, (float)(n3 + 24), (float)(n2 + 30), 1, 1);
                } else if (oo2.azv_a().int_a() <= 1 && oo2.azv_a().int_b() >= 500) {
                    engine.a("1", engine.var_axy_c.a(), Color.RED, engine.var_axy_c.a(), Color.BLACK, (float)(n3 + 24), (float)(n2 + 30), 1, 1);
                } else if (oo2.azv_a().int_b() >= 500) {
                    engine.a(String.valueOf(oo2.azv_a().int_a()), engine.var_axy_c.a(), Color.WHITE, engine.var_axy_c.a(), Color.BLACK, (float)(n3 + 24), (float)(n2 + 30), 1, 1);
                }
            }
            if (this.buffs.get(n4).boolean_a()) {
                engine.a(String.valueOf(oo2.java_lang_String_b()), engine.var_axy_b.a(), Color.WHITE, engine.var_axy_b.a(), Color.BLACK, (float)(n3 + 14), (float)(n2 + 16), 8, 1);
                engine.a(String.valueOf(oo2.java_lang_String_a()), engine.var_axy_b.a(), Color.GREEN, engine.var_axy_b.a(), Color.BLACK, (float)(n3 + 14), (float)(n2 + 16), 8, 1);
            }
            oo2.op_a().com_badlogic_gdx_graphics_g2d_Sprite_a().setScale(0.0f);
            oo2.op_a().com_badlogic_gdx_graphics_g2d_Sprite_a().setFlip(false, false);
            ++this.nameplatePos;
        }
        if (!this.buffs.isEmpty()) {
            ++this.nameplateRow;
            this.nameplatePos = 0;
        }
        for (n4 = 0; n4 < this.allEffects.size; ++n4) {
            if (this.allEffects.get(n4).com_arenaofkings_packets_gameserver_data_EffectList_a() == null || (oo2 = this.allEffects.get(n4)).ot_a() == ot.var_ot_a) continue;
            oo2.op_a().com_badlogic_gdx_graphics_g2d_Sprite_a().setScale(0.5f);
            oo2.op_a().com_badlogic_gdx_graphics_g2d_Sprite_a().setFlip(false, false);
            if (n4 > 0 && n4 % 5 == 0) {
                ++this.nameplateRow;
                this.nameplatePos = 0;
            }
            n3 = 0;
            n2 = 0;
            n3 = (int)hitCircle.getX() - 68 + this.nameplatePos * 28;
            n2 = (int)hitCircle.getY() + 162 - this.nameplateRow * 30;
            oo2.op_a().a(f2, engine.var_azi_a, n3, n2, 1.0f);
            if (oo2.azv_a().int_a() < 500 && oo2.com_arenaofkings_packets_gameserver_data_EffectList_a() != EffectList.SpiritWolf && oo2.com_arenaofkings_packets_gameserver_data_EffectList_a() != EffectList.Bear && oo2.com_arenaofkings_packets_gameserver_data_EffectList_a() != EffectList.DarkInoculation) {
                oo2.da_b().a((float)(n3 - 1), n2 - 1);
                oo2.da_b().a(oo2.da_b().float_a() + f2 * 60.0f);
                oo2.da_b().a(oo2.da_b().float_a(), engine.var_azi_a);
            }
            oo2.op_a().a(f2, engine, this.nameplateRow, this.nameplatePos);
            if (oo2.azv_a().int_a() < 30 && (float)oo2.azv_a().int_b() > 0.0f) {
                if (oo2.azv_a().int_a() > 2) {
                    engine.a(String.valueOf(oo2.azv_a().int_a()), engine.var_axy_c.a(), Color.WHITE, engine.var_axy_c.a(), Color.BLACK, (float)(n3 + 24), (float)(n2 + 30), 1, 1);
                } else if (oo2.azv_a().int_a() <= 2 && oo2.azv_a().int_a() > 1) {
                    engine.a("2", engine.var_axy_c.a(), Color.RED, engine.var_axy_c.a(), Color.BLACK, (float)(n3 + 24), (float)(n2 + 30), 1, 1);
                } else if (oo2.azv_a().int_a() <= 1 && oo2.azv_a().int_b() >= 500) {
                    engine.a("1", engine.var_axy_c.a(), Color.RED, engine.var_axy_c.a(), Color.BLACK, (float)(n3 + 24), (float)(n2 + 30), 1, 1);
                } else if (oo2.azv_a().int_b() >= 500) {
                    engine.a(String.valueOf(oo2.azv_a().int_a()), engine.var_axy_c.a(), Color.WHITE, engine.var_axy_c.a(), Color.BLACK, (float)(n3 + 24), (float)(n2 + 30), 1, 1);
                }
            }
            if (oo2.boolean_a()) {
                engine.a(String.valueOf(oo2.java_lang_String_b()), engine.var_axy_b.a(), Color.WHITE, engine.var_axy_b.a(), Color.BLACK, (float)(n3 + 14), (float)(n2 + 16), 8, 1);
                engine.a(String.valueOf(oo2.java_lang_String_a()), engine.var_axy_b.a(), Color.GREEN, engine.var_axy_b.a(), Color.BLACK, (float)(n3 + 14), (float)(n2 + 16), 8, 1);
            }
            oo2.op_a().com_badlogic_gdx_graphics_g2d_Sprite_a().setScale(0.0f);
            oo2.op_a().com_badlogic_gdx_graphics_g2d_Sprite_a().setFlip(false, false);
            ++this.nameplatePos;
        }
    }

    public void renderTopHudIconsEnemy(float f2, Engine engine, HitCircle hitCircle) {
        int n2;
        int n3;
        oo oo2;
        int n4;
        this.nameplateRow = 0;
        this.nameplatePos = 0;
        for (n4 = 0; n4 < this.allEffects.size; ++n4) {
            if (this.allEffects.get(n4).com_arenaofkings_packets_gameserver_data_EffectList_a() == null || (oo2 = this.allEffects.get(n4)).ot_a() == ot.var_ot_a) continue;
            oo2.op_a().com_badlogic_gdx_graphics_g2d_Sprite_a().setScale(0.5f);
            oo2.op_a().com_badlogic_gdx_graphics_g2d_Sprite_a().setFlip(false, false);
            if (n4 > 0 && n4 % 5 == 0) {
                ++this.nameplateRow;
                this.nameplatePos = 0;
            }
            n3 = 0;
            n2 = 0;
            n3 = (int)hitCircle.getX() - 68 + this.nameplatePos * 28;
            n2 = (int)hitCircle.getY() + 162 - this.nameplateRow * 30;
            oo2.op_a().a(f2, engine.var_azi_a, n3, n2, 1.0f);
            if (oo2.azv_a().int_a() < 500 && oo2.com_arenaofkings_packets_gameserver_data_EffectList_a() != EffectList.SpiritWolf && oo2.com_arenaofkings_packets_gameserver_data_EffectList_a() != EffectList.Bear && oo2.com_arenaofkings_packets_gameserver_data_EffectList_a() != EffectList.DarkInoculation) {
                oo2.da_b().a((float)(n3 - 1), n2 - 1);
                oo2.da_b().a(oo2.da_b().float_a() + f2 * 60.0f);
                oo2.da_b().a(oo2.da_b().float_a(), engine.var_azi_a);
            }
            oo2.op_a().a(f2, engine, this.nameplateRow, this.nameplatePos);
            if (oo2.azv_a().int_a() < 30 && (float)oo2.azv_a().int_b() > 0.0f) {
                if (oo2.azv_a().int_a() > 2) {
                    engine.a(String.valueOf(oo2.azv_a().int_a()), engine.var_axy_c.a(), Color.WHITE, engine.var_axy_c.a(), Color.BLACK, (float)(n3 + 24), (float)(n2 + 30), 1, 1);
                } else if (oo2.azv_a().int_a() <= 2 && oo2.azv_a().int_a() > 1) {
                    engine.a("2", engine.var_axy_c.a(), Color.RED, engine.var_axy_c.a(), Color.BLACK, (float)(n3 + 24), (float)(n2 + 30), 1, 1);
                } else if (oo2.azv_a().int_a() <= 1 && oo2.azv_a().int_b() >= 500) {
                    engine.a("1", engine.var_axy_c.a(), Color.RED, engine.var_axy_c.a(), Color.BLACK, (float)(n3 + 24), (float)(n2 + 30), 1, 1);
                } else if (oo2.azv_a().int_b() >= 500) {
                    engine.a(String.valueOf(oo2.azv_a().int_a()), engine.var_axy_c.a(), Color.WHITE, engine.var_axy_c.a(), Color.BLACK, (float)(n3 + 24), (float)(n2 + 30), 1, 1);
                }
            }
            if (oo2.boolean_a()) {
                engine.a(String.valueOf(oo2.java_lang_String_b()), engine.var_axy_b.a(), Color.WHITE, engine.var_axy_b.a(), Color.BLACK, (float)(n3 + 14), (float)(n2 + 16), 8, 1);
                engine.a(String.valueOf(oo2.java_lang_String_a()), engine.var_axy_b.a(), Color.GREEN, engine.var_axy_b.a(), Color.BLACK, (float)(n3 + 14), (float)(n2 + 16), 8, 1);
            }
            oo2.op_a().com_badlogic_gdx_graphics_g2d_Sprite_a().setScale(0.0f);
            oo2.op_a().com_badlogic_gdx_graphics_g2d_Sprite_a().setFlip(false, false);
            ++this.nameplatePos;
        }
        if (!this.debuffs.isEmpty() || !this.statusAilments.isEmpty()) {
            ++this.nameplateRow;
            this.nameplatePos = 0;
        }
        for (n4 = 0; n4 < this.buffs.size; ++n4) {
            if (this.buffs.get(n4).com_arenaofkings_packets_gameserver_data_EffectList_a() == null) continue;
            if (n4 > 0 && n4 % 5 == 0) {
                ++this.nameplateRow;
                this.nameplatePos = 0;
            }
            oo2 = this.buffs.get(n4);
            oo2.op_a().com_badlogic_gdx_graphics_g2d_Sprite_a().setScale(0.5f);
            oo2.op_a().com_badlogic_gdx_graphics_g2d_Sprite_a().setFlip(false, false);
            n3 = 0;
            n2 = 0;
            n3 = (int)hitCircle.getX() - 68 + this.nameplatePos * 28;
            n2 = (int)hitCircle.getY() + 162 - this.nameplateRow * 30;
            System.out.println("b2 " + n3 + "," + n2);
            oo2.op_a().a(f2, engine.var_azi_a, n3, n2, 1.0f);
            if (this.buffs.get(n4).azv_a().int_a() < 500 && this.buffs.get(n4).com_arenaofkings_packets_gameserver_data_EffectList_a() != EffectList.SpiritWolf && this.buffs.get(n4).com_arenaofkings_packets_gameserver_data_EffectList_a() != EffectList.Bear && this.buffs.get(n4).com_arenaofkings_packets_gameserver_data_EffectList_a() != EffectList.DarkInoculation) {
                oo2.da_b().a((float)(n3 - 1), n2 - 1);
                oo2.da_b().a(oo2.da_b().float_a() + f2 * 60.0f);
                oo2.da_b().a(oo2.da_b().float_a(), engine.var_azi_a);
            }
            oo2.op_a().a(f2, engine, this.nameplateRow, this.nameplatePos);
            if (this.buffs.get(n4).azv_a().int_a() < 30 && (float)this.buffs.get(n4).azv_a().int_b() > 0.0f) {
                if (oo2.azv_a().int_a() > 2) {
                    engine.a(String.valueOf(oo2.azv_a().int_a()), engine.var_axy_c.a(), Color.WHITE, engine.var_axy_c.a(), Color.BLACK, (float)(n3 + 24), (float)(n2 + 30), 1, 1);
                } else if (oo2.azv_a().int_a() <= 2 && oo2.azv_a().int_a() > 1) {
                    engine.a("2", engine.var_axy_c.a(), Color.RED, engine.var_axy_c.a(), Color.BLACK, (float)(n3 + 24), (float)(n2 + 30), 1, 1);
                } else if (oo2.azv_a().int_a() <= 1 && oo2.azv_a().int_b() >= 500) {
                    engine.a("1", engine.var_axy_c.a(), Color.RED, engine.var_axy_c.a(), Color.BLACK, (float)(n3 + 24), (float)(n2 + 30), 1, 1);
                } else if (oo2.azv_a().int_b() >= 500) {
                    engine.a(String.valueOf(oo2.azv_a().int_a()), engine.var_axy_c.a(), Color.WHITE, engine.var_axy_c.a(), Color.BLACK, (float)(n3 + 24), (float)(n2 + 30), 1, 1);
                }
            }
            if (this.buffs.get(n4).boolean_a()) {
                engine.a(String.valueOf(oo2.java_lang_String_b()), engine.var_axy_b.a(), Color.WHITE, engine.var_axy_b.a(), Color.BLACK, (float)(n3 + 14), (float)(n2 + 16), 8, 1);
                engine.a(String.valueOf(oo2.java_lang_String_a()), engine.var_axy_b.a(), Color.GREEN, engine.var_axy_b.a(), Color.BLACK, (float)(n3 + 14), (float)(n2 + 16), 8, 1);
            }
            oo2.op_a().com_badlogic_gdx_graphics_g2d_Sprite_a().setScale(0.0f);
            oo2.op_a().com_badlogic_gdx_graphics_g2d_Sprite_a().setFlip(false, false);
            ++this.nameplatePos;
        }
    }
}

